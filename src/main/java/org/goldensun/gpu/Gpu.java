package org.goldensun.gpu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.DebugHelper;
import org.goldensun.Hardware;
import org.goldensun.MathHelper;
import org.goldensun.cpu.InterruptController;
import org.goldensun.cpu.InterruptType;
import org.goldensun.dma.DmaController;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;
import org.goldensun.opengl.Mesh;
import org.goldensun.opengl.Shader;
import org.goldensun.opengl.Texture;
import org.goldensun.opengl.Window;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.goldensun.Hardware.CODE;
import static org.goldensun.MathHelper.*;
import static org.goldensun.MathHelper.colour15To24;
import static org.goldensun.MathHelper.get;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_EQUAL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_MINUS;
import static org.lwjgl.opengl.GL11C.GL_BLEND;
import static org.lwjgl.opengl.GL11C.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11C.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11C.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11C.GL_NEAREST;
import static org.lwjgl.opengl.GL11C.GL_RGBA;
import static org.lwjgl.opengl.GL11C.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11C.glClear;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.opengl.GL11C.glDisable;
import static org.lwjgl.opengl.GL11C.glViewport;
import static org.lwjgl.opengl.GL12C.GL_UNSIGNED_INT_8_8_8_8_REV;

// Adapted from https://github.com/Martin1994/OptimeGBA

public class Gpu {
  private static final Logger LOGGER = LogManager.getFormatterLogger(Gpu.class);

  /** 4000000 */
  public final Value DISPCNT;

  /** 4000004 */
  public final Value DISPSTAT;
  /** 4000006 */
  public final Value VCOUNT;
  /** 4000008 */
  public final Value BG0CNT;
  /** 400000a */
  public final Value BG1CNT;
  /** 400000c */
  public final Value BG2CNT;
  /** 400000e */
  public final Value BG3CNT;
  /** 4000010 */
  public final Value BG0HOFS;
  /** 4000012 */
  public final Value BG0VOFS;
  /** 4000014 */
  public final Value BG1HOFS;
  /** 4000016 */
  public final Value BG1VOFS;
  /** 4000018 */
  public final Value BG2HOFS;
  /** 400001a */
  public final Value BG2VOFS;
  /** 400001c */
  public final Value BG3HOFS;
  /** 400001e */
  public final Value BG3VOFS;
  /** 4000020 */
  public final Value BG2PA;
  /** 4000022 */
  public final Value BG2PB;
  /** 4000024 */
  public final Value BG2PC;
  /** 4000026 */
  public final Value BG2PD;
  /** 4000028 */
  public final Value BG2X;
  /** 400002c */
  public final Value BG2Y;
  /** 4000030 */
  public final Value BG3PA;
  /** 4000032 */
  public final Value BG3PB;
  /** 4000034 */
  public final Value BG3PC;
  /** 4000036 */
  public final Value BG3PD;
  /** 4000038 */
  public final Value BG3X;
  /** 400003c */
  public final Value BG3Y;
  /** 4000040 */
  public final Value WIN0H;
  /** 4000042 */
  public final Value WIN1H;
  /** 4000044 */
  public final Value WIN0V;
  /** 4000046 */
  public final Value WIN1V;
  /** 4000048 */
  public final Value WININ;
  /** 400004a */
  public final Value WINOUT;
  /** 400004c */
  public final Value MOSAIC;

  /** 4000050 */
  public final Value BLDCNT;
  /** 4000052 */
  public final Value BLDALPHA;
  /** 4000054 */
  public final Value BLDY;

  private static final int H_DRAW_DOTS = 240;
  private static final int H_BLANK_DOTS = 68;
  private static final int H_DOTS = H_DRAW_DOTS + H_BLANK_DOTS;
  private static final int V_DRAW_LINES = 160;
  private static final int V_BLANK_LINES = 68;
  private static final int V_LINES = V_DRAW_LINES + V_BLANK_LINES;
  private static final int CYCLES_PER_DOT = 4;
  private static final int CYCLES_PER_H_DRAW = H_DRAW_DOTS * CYCLES_PER_DOT;
  private static final int CYCLES_PER_H_BLANK = H_BLANK_DOTS * CYCLES_PER_DOT;
  private static final int CYCLES_PER_LINE = H_DOTS * CYCLES_PER_DOT;
  private static final int FRAMES_PER_SECOND = 60;
  /** Nanoseconds per line */
  private static final int V_LINE_NANOS = 1_000_000_000 / FRAMES_PER_SECOND / V_LINES;
  /** Nanoseconds per dot */
  private static final int H_DOT_NANOS = V_LINE_NANOS / H_DOTS;
  private static final int H_DRAW_NANOS = H_DOT_NANOS * H_DRAW_DOTS;

  private static final int MOSAIC_BG_X_SIZE_MASK = 0b1111;
  private static final int MOSAIC_BG_X_SIZE_SHIFT = 0;
  private static final int MOSAIC_BG_Y_SIZE_MASK = 0b1111_0000;
  private static final int MOSAIC_BG_Y_SIZE_SHIFT = 4;
  private static final int MOSAIC_OBJ_X_SIZE_MASK = 0b1111_0000_0000;
  private static final int MOSAIC_OBJ_X_SIZE_SHIFT = 8;
  private static final int MOSAIC_OBJ_Y_SIZE_MASK = 0b1111_0000_0000_0000;
  private static final int MOSAIC_OBJ_Y_SIZE_SHIFT = 12;

  private final DispCnt dispCnt = new DispCnt();
  private final DispStat dispStat = new DispStat();
  private int vcount;
  private final BgCnt[] bgcnt = new BgCnt[4];

  private int win0hRight;
  private int win0hLeft;
  private int win1hRight;
  private int win1hLeft;
  private int win0vBottom;
  private int win0vTop;
  private int win1vBottom;
  private int win1vTop;
  private final Win win0in = new Win();
  private final Win win1in = new Win();
  private final Win winout = new Win();
  private final Win winobj = new Win();

  private int bgMosaicW;
  private int bgMosaicH;
  private int objMosaicW;
  private int objMosaicH;

  private int bgMosaicYCounter;
  private int objMosaicYCounter;

  private final BldCnt bldCnt = new BldCnt();
  private int bldAlpha1;
  private int bldAlpha2;
  private int bldY;

  private final DmaController dma;
  private final InterruptController interrupts;

  public final Window window;

  private final Matrix4f proj = new Matrix4f();
  private final Matrix4f transforms = new Matrix4f();
  private final Shader.UniformBuffer transformsUniform;
  private final FloatBuffer transformsBuffer = BufferUtils.createFloatBuffer(4 * 4 * 2);

  private int width;
  private int height;

  private final Shader displayShader;
  private final Mesh displayMesh;
  private final Texture displayTexture;

  private final byte[] palette = new byte[0x400];
  private final byte[] vram = new byte[0x1_8000];
  private final OamSegment oam = new OamSegment();
  private final int[] pixels = new int[H_DRAW_DOTS * V_DRAW_LINES];

  private boolean backgroundSettingsDirty = true;
  private final BgCnt[] bgRefList = new BgCnt[4];
  private final int[] bgList = new int[4];
  private int bgCount;
  private final ObjPixel[] objBuffer = new ObjPixel[H_DRAW_DOTS];
  { Arrays.setAll(this.objBuffer, i -> new ObjPixel()); }
  private final int[] objWindowBuffer = new int[H_DRAW_DOTS];
  private final int[] winMasks = new int[H_DRAW_DOTS + 16];
  // Bytes 0-1: Color
  // Byte 2: Flag
  // Byte 3: Priority
  private final int[] bgLo = new int[H_DRAW_DOTS + 16];
  private final int[] bgHi = new int[H_DRAW_DOTS + 16];

  private final boolean[] debugEnableBg = {true, true, true, true};
  private final boolean debugEnableObj = true;

  private static final int MAP_BLOCK_SIZE = 0x800;

  private static final int[] CHAR_BLOCK_HEIGHT_TABLE = {
    0, 0, // Size 0 - 256x256
    0, 0, // Size 1 - 512x256
    0, 1, // Size 2 - 256x512
    0, 2, // Size 3 - 512x512
  };
  private static final int[] CHAR_BLOCK_WIDTH_TABLE = {
    0, 0, // Size 0 - 256x256
    0, 1, // Size 1 - 512x256
    0, 0, // Size 2 - 256x512
    0, 1, // Size 3 - 512x512
  };

  private int speedMultiplier = 1;
  private boolean updateVsync;

  public Gpu(final Memory memory, final DmaController dma, final InterruptController interrupts) {
    this.DISPCNT = memory.ref(2, 0x400_0000);
    this.DISPSTAT = memory.ref(2, 0x400_0004);
    this.VCOUNT = memory.ref(2, 0x400_0006);
    this.BG0CNT = memory.ref(2, 0x400_0008);
    this.BG1CNT = memory.ref(2, 0x400_000a);
    this.BG2CNT = memory.ref(2, 0x400_000c);
    this.BG3CNT = memory.ref(2, 0x400_000e);
    this.BG0HOFS = memory.ref(2, 0x400_0010);
    this.BG0VOFS = memory.ref(2, 0x400_0012);
    this.BG1HOFS = memory.ref(2, 0x400_0014);
    this.BG1VOFS = memory.ref(2, 0x400_0016);
    this.BG2HOFS = memory.ref(2, 0x400_0018);
    this.BG2VOFS = memory.ref(2, 0x400_001a);
    this.BG3HOFS = memory.ref(2, 0x400_001c);
    this.BG3VOFS = memory.ref(2, 0x400_001e);
    this.BG2PA = memory.ref(2, 0x400_0020);
    this.BG2PB = memory.ref(2, 0x400_0022);
    this.BG2PC = memory.ref(2, 0x400_0024);
    this.BG2PD = memory.ref(2, 0x400_0026);
    this.BG2X = memory.ref(4, 0x400_0028);
    this.BG2Y = memory.ref(4, 0x400_002c);
    this.BG3PA = memory.ref(2, 0x400_0030);
    this.BG3PB = memory.ref(2, 0x400_0032);
    this.BG3PC = memory.ref(2, 0x400_0034);
    this.BG3PD = memory.ref(2, 0x400_0036);
    this.BG3X = memory.ref(4, 0x400_0038);
    this.BG3Y = memory.ref(4, 0x400_003c);
    this.WIN0H = memory.ref(2, 0x400_0040);
    this.WIN1H = memory.ref(2, 0x400_0042);
    this.WIN0V = memory.ref(2, 0x400_0044);
    this.WIN1V = memory.ref(2, 0x400_0046);
    this.WININ = memory.ref(2, 0x400_0048);
    this.WINOUT = memory.ref(2, 0x400_004a);
    this.MOSAIC = memory.ref(2, 0x400_004c);
    this.BLDCNT = memory.ref(2, 0x400_0050);
    this.BLDALPHA = memory.ref(2, 0x400_0052);
    this.BLDY = memory.ref(2, 0x400_0054);

    this.dma = dma;
    this.interrupts = interrupts;

    Arrays.setAll(this.bgcnt, BgCnt::new);

    memory.addSegment(new GpuSegment());
    memory.addSegment(new PaletteSegment());
    memory.addSegment(new VramSegment());
    memory.addSegment(this.oam);

    this.window = new Window("Golden Sun", H_DRAW_DOTS * 3, V_DRAW_LINES * 3);
    this.window.events.onResize(this::onResize);
    this.window.events.onKeyPress((window1, key, scancode, mods) -> {
      if(key == GLFW_KEY_MINUS) {
        this.speedMultiplier = Math.max(1, this.speedMultiplier - 1);
        this.updateVsync = true;
      } else if(key == GLFW_KEY_EQUAL) {
        this.speedMultiplier = Math.min(10, this.speedMultiplier + 1);
        this.updateVsync = true;
      }
    });
    this.window.show();

    this.transformsUniform = new Shader.UniformBuffer((long)this.transformsBuffer.capacity() * Float.BYTES, Shader.UniformBuffer.TRANSFORM);

    this.displayShader = this.loadShader(Paths.get("gfx", "shaders", "vram.vsh"), Paths.get("gfx", "shaders", "vram.fsh"));
    this.displayTexture = Texture.create(builder -> {
      builder.size(H_DRAW_DOTS, V_DRAW_LINES);
      builder.internalFormat(GL_RGBA);
      builder.dataFormat(GL_RGBA);
      builder.dataType(GL_UNSIGNED_INT_8_8_8_8_REV);
      builder.minFilter(GL_NEAREST);
      builder.magFilter(GL_NEAREST);
    });

    this.displayMesh = new Mesh(GL_TRIANGLE_STRIP, new float[] {
      0, 0, 0, 0,
      0, 1, 0, 1,
      1, 0, 1, 0,
      1, 1, 1, 1,
    }, 4);
    this.displayMesh.attribute(0, 0L, 2, 4);
    this.displayMesh.attribute(1, 2L, 2, 4);

    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
  }

  private void onResize(final Window window, final int width, final int height) {
    if(width == 0 && height == 0) {
      return;
    }

    this.width = width;
    this.height = height;

    this.proj.setOrtho2D(0.0f, width / window.getScale(), height / window.getScale(), 0.0f);
  }

  public void run() {
    this.window.events.onDraw(this::tick);
    this.window.run();
  }

  private void pre() {
    glDisable(GL_CULL_FACE);
    glDisable(GL_DEPTH_TEST);
    glDisable(GL_BLEND);

    glViewport(0, 0, this.width, this.height);

    // Update global transforms
    this.transforms.scaling(this.width, this.height, 1.0f);

    this.proj.get(0, this.transformsBuffer);
    this.transforms.get(16, this.transformsBuffer);
    this.transformsUniform.set(this.transformsBuffer);

    // Render scene
    this.clear();
  }

  public void clear() {
    glClear(GL_COLOR_BUFFER_BIT);
  }

  private void tick() {
    if(this.updateVsync) {
      if(this.speedMultiplier == 1) {
        this.window.enableVsync();
      } else {
        this.window.disableVsync();
      }

      this.updateVsync = false;
    }

    this.pre();

    for(this.vcount = 0; this.vcount < V_LINES; this.vcount++) {
      final long time = System.nanoTime();
      final long hdrawEnd = time + H_DRAW_NANOS / this.speedMultiplier;
      final long hblankEnd = time + V_LINE_NANOS / this.speedMultiplier;

      while(System.nanoTime() < hdrawEnd) {
        DebugHelper.sleep(0);
      }

      this.drawLine(this.vcount);
      this.startHblank();

      while(System.nanoTime() < hblankEnd) {
        DebugHelper.sleep(0);
      }

      this.endHblank();

      if(this.vcount == V_DRAW_LINES - 1) {
        this.startVblank();
      }

      if(this.vcount == V_LINES - 1) {
        this.endVblank();
      }
    }

    this.displayTexture.data(0, 0, H_DRAW_DOTS, V_DRAW_LINES, this.pixels);

    this.displayShader.use();
    this.displayTexture.use();
    this.displayMesh.draw();

    if(!CODE.isAlive()) {
      LOGGER.info("Code thread no longer running, shutting down");
      Hardware.stop();
      this.window.close();
    }
  }

  private void prepareBackgroundAndWindow(final int line) {
    if(this.backgroundSettingsDirty) {
      this.prepareBackground();
      this.backgroundSettingsDirty = false;
    }

    final boolean win0InsideY = line - this.win0vTop < this.win0vBottom - this.win0vTop && this.dispCnt.window0Display;
    final boolean win1InsideY = line - this.win1vTop < this.win1vBottom - this.win1vTop && this.dispCnt.window1Display;

    int win0ThresholdX = this.win0hRight - this.win0hLeft;
    int win1ThresholdX = this.win1hRight - this.win1hLeft;

    if(!win0InsideY) {
      win0ThresholdX = 0;
    }

    if(!win1InsideY) {
      win1ThresholdX = 0;
    }

    int win0HPos = -this.win0hLeft;
    int win1HPos = -this.win1hLeft;

    // Erase with priority 4, backdrop flag, and color 0;
    final int eraseColor = 4 << 24 | BlendFlag.Backdrop.val << 16 | this.readPalette(0);
    if(this.dispCnt.window0Display || this.dispCnt.window1Display || this.dispCnt.objWindowDisplay) {
      for(int i = 0; i < H_DRAW_DOTS; i++) {
        int val = this.winout.pack();

        if(win0HPos < win0ThresholdX) {
          val = this.win0in.pack();
        } else if(win1HPos < win1ThresholdX) {
          val = this.win1in.pack();
        } else if(this.objWindowBuffer[i] != 0) {
          val = this.winobj.pack();
        }

        win0HPos++;
        win1HPos++;

        this.winMasks[i + 8] = val;

        // Also prepare backgrounds arrays in this loop
        this.bgHi[i + 8] = eraseColor;
      }
    } else {
      for(int i = 0; i < H_DRAW_DOTS; i++) {
        this.winMasks[i + 8] = 0b111111;

        this.bgHi[i + 8] = eraseColor;
      }
    }
  }

  private void prepareBackground() {
    this.bgCount = 0;
    for(int bg = 0; bg < 4; bg++) {
      // -1 means disabled
      // Look up backgrounds in reverse order to ensure backgrounds are in correct order
      // (backgrounds carry a specific render order even if they are the same priority)
      final int invBg = 3 - bg;
      this.bgList[bg] = -1;
      this.bgList[this.bgCount] = invBg;
      if(this.BgIsEnabled(invBg)) {
        this.bgCount++;
      }
    }

    // Insertion sort backgrounds according to priority
    int j;
    for(int i = 1; i < this.bgCount; i++) {
      final int key = this.bgcnt[this.bgList[i]].priority;
      j = i - 1;

      while(j >= 0 && this.bgcnt[this.bgList[j]].priority < key) {
        final int tmp = this.bgList[j];
        this.bgList[j] = this.bgList[j + 1];
        this.bgList[j + i] = tmp;
        j--;
      }
    }

    // Look up references for each background
    for(int i = 0; i < this.bgCount; i++) {
      this.bgRefList[i] = this.bgcnt[this.bgList[i]];
    }

    this.bgcnt[0].mode = BackgroundMode.CHAR;
    this.bgcnt[1].mode = BackgroundMode.CHAR;
    this.bgcnt[2].mode = BackgroundMode.CHAR;
    this.bgcnt[3].mode = BackgroundMode.CHAR;
    switch(this.dispCnt.bgMode) {
      case 1 -> this.bgcnt[2].mode = BackgroundMode.AFFINE;
      case 2 -> {
        this.bgcnt[2].mode = BackgroundMode.AFFINE;
        this.bgcnt[3].mode = BackgroundMode.AFFINE;
      }
    }
  }

  private boolean BgIsEnabled(final int id) {
    switch(this.dispCnt.bgMode) {
      case 1 -> {
        if(id == 3) {
          return false;
        }
      }
      case 2 -> {
        if(id == 0 || id == 1) {
          return false;
        }
      }
    }

    return this.dispCnt.displayBg[id] && this.debugEnableBg[id];
  }

  private void drawLine(final int line) {
    if(line < V_DRAW_LINES) {
      if(this.dispCnt.forcedBlank) {
        for(int x = 0; x < H_DRAW_DOTS; x++) {
          this.pixels[line * H_DRAW_DOTS + x] = 0x7fff;
        }

        return;
      }

      if(this.dispCnt.bgMode < 3) {
        this.prepareBackgroundAndWindow(line);
      }

      switch(this.dispCnt.bgMode) {
        case 0, 1, 2 -> this.drawBgModeLine(line);
        case 3 -> this.drawMode3Line(line);
        case 4 -> this.drawMode4Line(line);
        case 5 -> this.drawMode5Line(line);
      }

      if(this.dispCnt.bgMode < 3) {
        this.composite(line);

        if(this.debugEnableObj && this.dispCnt.displayObj && line != 159) {
          this.renderObjs(line + 1);
        }
      }
    }
  }

  private void drawBgModeLine(final int line) {
    for(int i = 0; i < this.bgCount; i++) {
      final var bg = this.bgRefList[i];
      switch(bg.mode) {
        case CHAR -> this.renderCharBackground(line, bg);
        case AFFINE -> this.renderAffineBackground(line, bg);
      }
    }
  }

  private void drawMode3Line(final int line) {
    throw new RuntimeException("Not implemented");
  }

  private void drawMode4Line(final int line) {
    throw new RuntimeException("Not implemented");
  }

  private void drawMode5Line(final int line) {
    throw new RuntimeException("Not implemented");
  }

  public void renderCharBackground(final int line, final BgCnt bg) {
    final boolean enableMosaicX = bg.mosaic && this.bgMosaicW != 0;
    this.renderCharBackground(line, bg, enableMosaicX);
  }

  private final int[] indices = new int[8];

  private void renderCharBackground(final int line, final BgCnt bg, final boolean mosaicX) {
    final int charBase = bg.characterBaseBlock;
    final int mapBase = bg.screenBaseBlock;

    int pixelY = bg.vofs + line;
    if(bg.mosaic) {
      pixelY -= this.bgMosaicYCounter;
    }
    final int pixelYWrapped = pixelY & 0xff;

    final int screenSizeBase = bg.screenSize * 2;
    final int verticalOffsetBlocks = CHAR_BLOCK_HEIGHT_TABLE[screenSizeBase + ((pixelY & 0x1ff) >> 8)];
    final int mapVertOffset = MAP_BLOCK_SIZE * verticalOffsetBlocks;

    final int tileY = pixelYWrapped >> 3;
    final int intraTileY = pixelYWrapped & 0x7;

    int pixelX = bg.hofs;
    final int intraTileX = bg.hofs & 0x7;
    int lineIndex = 8 - intraTileX;

    int tilesToRender = H_DRAW_DOTS / 8;
    if(lineIndex < 8) {
      tilesToRender++;
    }

    final int mosaicXCounter = this.bgMosaicW;

    // Every byte of these vectors are filled
    final int meta = bg.priority << 8 | 1 << bg.id;

    for(int tile = 0; tile < tilesToRender; tile++) {
      final int pixelXWrapped = pixelX & 0xff;

      // 2 bytes per tile
      final int tileX = pixelXWrapped >> 3;
      final int horizontalOffsetBlocks = CHAR_BLOCK_WIDTH_TABLE[screenSizeBase + ((pixelX & 0x1ff) >> 8)];
      final int mapHoriOffset = MAP_BLOCK_SIZE * horizontalOffsetBlocks;
      final int mapEntryIndex = mapBase + mapVertOffset + mapHoriOffset + tileY * 64 + tileX * 2;
      final int mapEntry = get(this.vram, mapEntryIndex, 2);

      final int tileNumber = mapEntry & 0x3ff;
      final boolean xFlip = (mapEntry & 0x400) != 0;
      final boolean yFlip = (mapEntry & 0x800) != 0;

      int effectiveIntraTileY = intraTileY;
      if(yFlip) {
        effectiveIntraTileY ^= 7;
      }

      if(bg.coloursPalettes == BgCnt.ColoursPalettes._256_1) {
        final int vramTileAddr = charBase + tileNumber * 64 + effectiveIntraTileY * 8;
        final long data = getLong(this.vram, vramTileAddr);

        if(data != 0) {
          if(xFlip) {
            this.indices[0] = (int)(data >> 56 & 0xff);
            this.indices[1] = (int)(data >> 48 & 0xff);
            this.indices[2] = (int)(data >> 40 & 0xff);
            this.indices[3] = (int)(data >> 32 & 0xff);
            this.indices[4] = (int)(data >> 24 & 0xff);
            this.indices[5] = (int)(data >> 16 & 0xff);
            this.indices[6] = (int)(data >> 8 & 0xff);
            this.indices[7] = (int)(data & 0xff);
          } else {
            this.indices[0] = (int)(data & 0xff);
            this.indices[1] = (int)(data >> 8 & 0xff);
            this.indices[2] = (int)(data >> 16 & 0xff);
            this.indices[3] = (int)(data >> 24 & 0xff);
            this.indices[4] = (int)(data >> 32 & 0xff);
            this.indices[5] = (int)(data >> 40 & 0xff);
            this.indices[6] = (int)(data >> 48 & 0xff);
            this.indices[7] = (int)(data >> 56 & 0xff);
          }

          this.setBgRow(lineIndex, 0, this.indices, meta, 0xff);
        }

        pixelX += 8;
        lineIndex += 8;
      } else {
        final int paletteRow = mapEntry >> 12 & 0xF;
        final int vramTileAddr = charBase + tileNumber * 32 + effectiveIntraTileY * 4;

        final int data = get(this.vram, vramTileAddr, 4);

        if(data != 0) {
          if(xFlip) {
            this.indices[0] = data >> 28 & 0xf;
            this.indices[1] = data >> 24 & 0xf;
            this.indices[2] = data >> 20 & 0xf;
            this.indices[3] = data >> 16 & 0xf;
            this.indices[4] = data >> 12 & 0xf;
            this.indices[5] = data >> 8 & 0xf;
            this.indices[6] = data >> 4 & 0xf;
            this.indices[7] = data & 0xf;
          } else {
            this.indices[0] = data & 0xf;
            this.indices[1] = data >> 4 & 0xf;
            this.indices[2] = data >> 8 & 0xf;
            this.indices[3] = data >> 12 & 0xf;
            this.indices[4] = data >> 16 & 0xf;
            this.indices[5] = data >> 20 & 0xf;
            this.indices[6] = data >> 24 & 0xf;
            this.indices[7] = data >> 28 & 0xf;
          }

          this.setBgRow(lineIndex, paletteRow, this.indices, meta, 0xf);
        }

        pixelX += 8;
        lineIndex += 8;
      }
    }
  }

  private static final int[] AFFINE_SIZE_TABLE = { 128, 256, 512, 1024 };
  private static final int[] AFFINE_TILE_SIZE_TABLE = { 16, 32, 64, 128 };
  private static final int[] AFFINE_SIZE_MASK = { 127, 255, 511, 1023 };

  private void renderAffineBackground(final int line, final BgCnt bg) {
    final int charBase = bg.characterBaseBlock;
    final int mapBase = bg.screenBaseBlock;

    final int meta = bg.priority << 8 | 0x1 << bg.id;

    int posX = bg.affinePosX;
    int posY = bg.affinePosY;

    final int size = AFFINE_SIZE_TABLE[bg.screenSize];
    final int sizeMask = AFFINE_SIZE_MASK[bg.screenSize];
    final int tileSize = AFFINE_TILE_SIZE_TABLE[bg.screenSize];

    for(int p = 0; p < H_DRAW_DOTS; p++) {
      int pixelX = posX >> 8 & 0x7ffff;
      int pixelY = posY >> 8 & 0x7ffff;

      posX += bg.affineA;
      posY += bg.affineC;

      if(!bg.overflowWrap && (pixelX >= size || pixelY >= size)) {
        continue;
      }

      pixelX &= sizeMask;
      pixelY &= sizeMask;

      final int tileX = pixelX >> 3;
      final int intraTileX = pixelX & 7;

      final int tileY = pixelY >> 3;
      final int intraTileY = pixelY & 7;

      // 1 byte per tile
      final int mapEntryIndex = mapBase + tileY * tileSize + tileX;
      final int tileNumber = this.vram[mapEntryIndex] & 0xff;

      // Always 256color
      // 256 color, 64 bytes per tile, 8 bytes per row
      final int vramAddr = charBase + tileNumber * 64 + intraTileY * 8 + intraTileX;
      final int vramValue = this.vram[vramAddr] & 0xff;

      if(vramValue != 0) {
        this.setBgPixel(p + 8, this.readPalette(vramValue), meta);
      }
    }

    bg.affinePosX += bg.affineB;
    bg.affinePosY += bg.affineD;
  }

  private void setBgPixel(final int lineIndex, final int color, final int meta) {
    if((this.winMasks[lineIndex] & meta) != 0) {
      this.bgLo[lineIndex] = this.bgHi[lineIndex];
      this.bgHi[lineIndex] = color | meta << 16;
    }
  }

  private void setBgRow(final int line, final int paletteRow, final int[] indices, final int meta, final int clearMask) {
    for(int i = 0; i < 8; i++) {
      final int indexI = indices[i];

      // Weave metadata (priority, ID) into color data
      final int color = this.readPalette((paletteRow * 16 + indexI) * 0x2) | meta << 16;

      int winMask = this.winMasks[line + i];
      winMask &= meta;
      // Get important color bits
      final int clear = indexI & clearMask;
      // Merge with window mask
      final boolean mergedMask = winMask != 0 && clear != 0;

      // Push back covered pixels from hi to lo
      if(mergedMask) {
        this.bgLo[line + i] = this.bgHi[line + i];
        this.bgHi[line + i] = color;
      }
    }
  }

  public void renderObjs(final int line) {
    // OAM address for the last sprite
    for(int objIndex = 0; objIndex < 128; objIndex++) {
      final int yPos = this.oam.getYCoordinate(objIndex);
      final boolean affine = this.oam.isRotScaleEnabled(objIndex);
      final ObjMode mode = ObjMode.values()[this.oam.getMode(objIndex)];
      final boolean mosaic = this.oam.isMosaicEnabled(objIndex);
      final boolean use8BitColor = this.oam.is256ColorPalette(objIndex);

      final int xPos = this.oam.getXCoordinate(objIndex);
      final boolean xFlip = this.oam.isHFlipEnabled(objIndex) && !affine;
      final boolean yFlip = this.oam.isVFlipEnabled(objIndex) && !affine;

      int tileNumber = this.oam.getTileNumber(objIndex);
      final int palette = this.oam.getPaletteNumber(objIndex);

      final int xSize = this.oam.getXSize(objIndex);
      final int ySize = this.oam.getYSize(objIndex);

      int yEnd = yPos + ySize & 0xff;
      int screenLineBase = xPos;

      final boolean disabled = !this.oam.isDisplayable(objIndex);

      final int priority = this.oam.getPriority(objIndex);

      boolean render = false;
      if(!disabled && !affine) {
        if(yPos <= line && yEnd > line || yPos > yEnd && yEnd > line) {
          render = true;
        }
      } else if(affine) {
        if(disabled) {
          yEnd += ySize;
        }

        if(yPos <= line && yEnd > line || yPos > yEnd && yEnd > line) {
          render = true;
        }
      }

      if(!render) {
        continue;
      }

      // y relative to the object itself
      int objPixelY = line - yPos & 0xff;

      if(yFlip) {
        objPixelY = ySize - objPixelY - 1;
      }

      // Tile numbers are halved in 256-color mode
      if(use8BitColor) {
        tileNumber >>= 1;
      }

      if(!affine) {
        for(int x = 0; x < xSize; x++) {
          if(screenLineBase >= 0 && screenLineBase < H_DRAW_DOTS) {
            int objPixelX = x;

            if(xFlip) {
              objPixelX = xSize - objPixelX - 1;
            }

            this.renderObjPixel(objPixelX, objPixelY, tileNumber, xSize, use8BitColor, screenLineBase, palette, priority, mode);
          }
          screenLineBase = (screenLineBase + 1) % 0x200;
        }
      } else {
        int renderXSize = xSize;

        final boolean doubleSize = this.oam.isDoubleSize(objIndex);
        if(doubleSize) {
          renderXSize *= 2;
        }

        final int parameterId = this.oam.getRotScaleGroupNumber(objIndex);
        final int pA = this.oam.getPA(parameterId);
        final int pB = this.oam.getPB(parameterId);
        final int pC = this.oam.getPC(parameterId);
        final int pD = this.oam.getPD(parameterId);

        final int xofs;
        final int yofs;

        final int xfofs;
        final int yfofs;

        if(!doubleSize) {
          xofs = xSize / 2;
          yofs = ySize / 2;

          xfofs = 0;
          yfofs = 0;
        } else {
          xofs = xSize;
          yofs = ySize;

          xfofs = -xofs / 2;
          yfofs = -yofs / 2;
        }

        // Left edge
        final int origXEdge0 = -xofs;
        final int origY = objPixelY - yofs;

        // Calculate starting parameters for matrix multiplications
        final int shiftedXOfs = xofs + xfofs << 8;
        final int shiftedYOfs = yofs + yfofs << 8;
        final int pBYOffset = pB * origY + shiftedXOfs;
        final int pDYOffset = pD * origY + shiftedYOfs;

        int objPixelXEdge0 = pA * origXEdge0 + pBYOffset;
        int objPixelYEdge0 = pC * origXEdge0 + pDYOffset;

        for(int x = 0; x < renderXSize; x++) {
          if(screenLineBase >= 0 && screenLineBase < H_DRAW_DOTS) {
            final int lerpedObjPixelX = objPixelXEdge0 >> 8;
            final int lerpedObjPixelY = objPixelYEdge0 >> 8;

            if(lerpedObjPixelX >= 0 && lerpedObjPixelX < xSize && lerpedObjPixelY >= 0 && lerpedObjPixelY < ySize) {
              this.renderObjPixel(lerpedObjPixelX, lerpedObjPixelY, tileNumber, xSize, use8BitColor, screenLineBase, palette, priority, mode);
            }
          }
          objPixelXEdge0 += pA;
          objPixelYEdge0 += pC;

          screenLineBase = (screenLineBase + 1) % 0x200;
        }
      }
    }
  }

  public void renderObjPixel(final int objX, final int objY, final int tile, final int width, final boolean use8BitColor, final int x, final int palette, final int priority, final ObjMode mode) {
    final int intraTileX = objX & 0x7;
    final int intraTileY = objY & 0x7;

    final int tileX = objX / 8;
    final int tileY = objY / 8;

    final int charBase = 0x10000;

    int effectiveTileNumber = tile + tileX;

    if(this.dispCnt.objCharacterVramMapping == DispCnt.ObjCharacterVramMapping.ONE_DIMENSIONAL) {
      effectiveTileNumber += tileY * (width / 8);
    } else if(use8BitColor) {
      effectiveTileNumber += 16 * tileY;
    } else {
      effectiveTileNumber += 32 * tileY;
    }

    if(use8BitColor) {
      // 256 color, 64 bytes per tile, 8 bytes per row
      final int vramAddr = charBase + effectiveTileNumber * 64 + intraTileY * 8 + intraTileX;
      final int vramValue = this.vram[vramAddr] & 0xff;

      if(vramValue != 0) {
        this.setObjPixel(x, vramValue, priority, mode);
      }
    } else {
      // 16 color, 32 bytes per tile, 4 bytes per row
      final int vramAddr = charBase + effectiveTileNumber * 32 + intraTileY * 4 + intraTileX / 2;
      final int vramValue = this.vram[vramAddr] & 0xff;
      // Lower 4 bits is left pixel, upper 4 bits is right pixel
      final int color = vramValue >> (intraTileX & 0x1) * 4 & 0xf;
      final int finalColor = palette * 16 + color;

      if(color != 0) {
        this.setObjPixel(x, finalColor, priority, mode);
      }
    }
  }

  private void setObjPixel(final int x, final int paletteIndex, final int priority, final ObjMode mode) {
    switch(mode) {
      case NORMAL -> {
        if(priority < this.objBuffer[x].priority) {
          this.objBuffer[x].set(paletteIndex, priority, mode);
        }
      }

      case TRANSLUCENT -> {
        if(priority < this.objBuffer[x].priority) {
          this.objBuffer[x].set(paletteIndex, priority, mode);
        }
        this.objBuffer[x].priority = priority;
      }

      default -> {
        if(this.dispCnt.objWindowDisplay) {
          this.objWindowBuffer[x] = 1;
        }
      }
    }
  }

  public void composite(final int line) {
    int screenBase = line * H_DRAW_DOTS;

    for(int i = 0; i < H_DRAW_DOTS; i++) {
      int winMask = this.winMasks[i + 8];
      final ObjPixel objPixel = this.objBuffer[i];

      final int hi = this.bgHi[i + 8];
      final int lo = this.bgLo[i + 8];
      int hiColor = hi;
      int loColor = lo;
      int hiPixelFlag = hi >>> 16 & 0xff;
      int loPixelFlag = lo >>> 16 & 0xff;
      final int objPaletteIndex = objPixel.palette;

      int effectiveTarget1Flags = this.bldCnt.firstTargetFlags();
      BldCnt.BlendingMode effectiveBlendEffect = this.bldCnt.blendingMode;

      if(objPaletteIndex != 0 && (winMask & Win.OBJ_ENABLE_MASK) != 0) {
        final int hiPriority = hi >>> 24;
        final int loPriority = lo >>> 24;

        if(objPixel.priority <= hiPriority) {
          loColor = hiColor;
          loPixelFlag = hiPixelFlag;

          hiColor = this.readPalette(0x200 + objPaletteIndex * 0x2);
          hiPixelFlag = BlendFlag.Obj.val;
        } else if(objPixel.priority <= loPriority) {
          loColor = this.readPalette(0x200 + objPaletteIndex * 0x2);
          loPixelFlag = BlendFlag.Obj.val;
        }

        if(objPixel.mode == ObjMode.TRANSLUCENT) {
          effectiveTarget1Flags |= BlendFlag.Obj.val;
          effectiveBlendEffect = BldCnt.BlendingMode.ALPHA;
          winMask |= Win.COLOUR_SPECIAL_EFFECT_MASK;
        }
      }

      if(
        effectiveBlendEffect != BldCnt.BlendingMode.NONE &&
        (effectiveTarget1Flags & hiPixelFlag) != 0 &&
        (winMask & Win.COLOUR_SPECIAL_EFFECT_MASK) != 0
      ) {
        final int r1 = hiColor & 0x1f;
        final int g1 = hiColor >>> 5 & 0x1f;
        final int b1 = hiColor >>> 10 & 0x1f;

        int fr = r1;
        int fg = g1;
        int fb = b1;
        switch(this.bldCnt.blendingMode) {
          case ALPHA -> {
            if((this.bldCnt.secondTargetFlags() & loPixelFlag) != 0) {
              final int r2 = loColor & 0x1f;
              final int g2 = loColor >>> 5 & 0x1f;
              final int b2 = loColor >>> 10 & 0x1f;

              fr = Math.min(0x1ff, r1 * this.bldAlpha1 + r2 * this.bldAlpha2) >> 4 & 0x1f;
              fg = Math.min(0x1ff, g1 * this.bldAlpha1 + g2 * this.bldAlpha2) >> 4 & 0x1f;
              fb = Math.min(0x1ff, b1 * this.bldAlpha1 + b2 * this.bldAlpha2) >> 4 & 0x1f;
            }
          }
          case ADDITIVE -> {
            fr = r1 + ((31 - r1) * this.bldY >> 4) & 0x1f;
            fg = g1 + ((31 - g1) * this.bldY >> 4) & 0x1f;
            fb = b1 + ((31 - b1) * this.bldY >> 4) & 0x1f;
          }
          case SUBTRACTIVE -> {
            fr = r1 - (r1 * this.bldY >> 4) & 0x1f;
            fg = g1 - (g1 * this.bldY >> 4) & 0x1f;
            fb = b1 - (b1 * this.bldY >> 4) & 0x1f;
          }
        }

        this.pixels[screenBase++] = colour15To24(fb << 10 | fg << 5 | fr);
      } else {
        this.pixels[screenBase++] = colour15To24(hiColor);
      }

      // Use this loop as an opportunity to clear the sprite buffer
      this.objBuffer[i].palette = 0;
      this.objBuffer[i].priority = 4;
      this.objWindowBuffer[i] = 0;
    }
  }

  private void startHblank() {
    this.dma.triggerHblank();

    if(this.dispStat.hblankIrqEnable) {
      this.interrupts.set(InterruptType.LCD_HBLANK);
    }

    this.dispStat.hblankFlag = true;

    this.tickMosaic();

    if(this.dispStat.vcountIrqEnable && this.vcount == this.dispStat.vcountSetting) {
      this.interrupts.set(InterruptType.LCD_VCOUNT_MATCH);
    }
  }

  private void endHblank() {
    this.dispStat.hblankFlag = false;
  }

  private void startVblank() {
    this.dma.triggerVblank();

    this.runVblankOperations();

    if(this.dispStat.vblankIrqEnable) {
      this.interrupts.set(InterruptType.LCD_VBLANK);
    }

    this.dispStat.vblankFlag = true;
  }

  private void endVblank() {
    this.dispStat.vblankFlag = false;
  }

  private void tickMosaic() {
    if(++this.bgMosaicYCounter > this.bgMosaicH) {
      this.bgMosaicYCounter = 0;
    }

    if(++this.objMosaicYCounter > this.objMosaicH) {
      this.objMosaicYCounter = 0;
    }
  }

  public void runVblankOperations()
  {
    this.bgcnt[2].copyAffineParams();
    this.bgcnt[3].copyAffineParams();

    this.bgMosaicYCounter = this.bgMosaicH;
    this.objMosaicYCounter = this.objMosaicH;
  }

  private int readPalette(final int offset) {
    return get(this.palette, offset, 2);
  }

  private Shader loadShader(final Path vsh, final Path fsh) {
    final Shader shader;

    try {
      shader = new Shader(vsh, fsh);
    } catch(final IOException e) {
      throw new RuntimeException("Failed to load vram shader", e);
    }

    shader.bindUniformBlock("transforms", Shader.UniformBuffer.TRANSFORM);
    return shader;
  }

  private int onDispCntRead() {
    return this.dispCnt.pack();
  }

  private void onDispCntWrite(final int val) {
    LOGGER.info("DISPCNT set to 0x%x", val);
    this.dispCnt.unpack(val);
    this.backgroundSettingsDirty = true;
  }

  private int onDispStatRead() {
    return this.dispStat.pack();
  }

  private void onDispStatWrite(final int val) {
    this.dispStat.unpack(val);
  }

  private int onVcountRead() {
    return this.vcount;
  }

  private int onBgCntRead(final int index) {
    return this.bgcnt[index].packCnt();
  }

  private void onBgCntWrite(final int index, final int val) {
    this.bgcnt[index].unpackCnt(val);
    this.backgroundSettingsDirty = true;
  }

  private int onBgHofsRead(final int index) {
    return this.bgcnt[index].hofs;
  }

  private void onBgHofsWrite(final int index, final int val) {
    this.bgcnt[index].hofs = val;
  }

  private int onBgVofsRead(final int index) {
    return this.bgcnt[index].vofs;
  }

  private void onBgVofsWrite(final int index, final int val) {
    this.bgcnt[index].vofs = val;
  }

  private int onBgAffineARead(final int index) {
    return this.bgcnt[index].affineA;
  }

  private void onBgAffineAWrite(final int index, final int val) {
    this.bgcnt[index].affineA = val;
  }

  private int onBgAffineBRead(final int index) {
    return this.bgcnt[index].affineB;
  }

  private void onBgAffineBWrite(final int index, final int val) {
    this.bgcnt[index].affineB = val;
  }

  private int onBgAffineCRead(final int index) {
    return this.bgcnt[index].affineC;
  }

  private void onBgAffineCWrite(final int index, final int val) {
    this.bgcnt[index].affineC = val;
  }

  private int onBgAffineDRead(final int index) {
    return this.bgcnt[index].affineD;
  }

  private void onBgAffineDWrite(final int index, final int val) {
    this.bgcnt[index].affineD = val;
  }

  private int onBgXRead(final int index) {
    return this.bgcnt[index].refPointX;
  }

  private void onBgXWrite(final int index, final int val) {
    this.bgcnt[index].refPointX = val;
    this.bgcnt[index].copyAffineParams();
  }

  private int onBgYRead(final int index) {
    return this.bgcnt[index].refPointY;
  }

  private void onBgYWrite(final int index, final int val) {
    this.bgcnt[index].refPointY = val;
    this.bgcnt[index].copyAffineParams();
  }

  private int onWin0hRead() {
    return (this.win0hLeft & 0xff) << 16 | this.win0hRight & 0xff;
  }

  private void onWin0hWrite(final int val) {
    this.win0hRight = val & 0xff;
    this.win0hLeft = val >>> 16 & 0xff;
  }

  private int onWin1hRead() {
    return (this.win1hLeft & 0xff) << 16 | this.win1hRight & 0xff;
  }

  private void onWin1hWrite(final int val) {
    this.win1hRight = val & 0xff;
    this.win1hLeft = val >>> 16 & 0xff;
  }

  private int onWin0vRead() {
    return (this.win0vTop & 0xff) << 16 | this.win0vBottom & 0xff;
  }

  private void onWin0vWrite(final int val) {
    this.win0vBottom = val & 0xff;
    this.win0vTop = val >>> 16 & 0xff;
  }

  private int onWin1vRead() {
    return (this.win1vTop & 0xff) << 16 | this.win1vBottom & 0xff;
  }

  private void onWin1vWrite(final int val) {
    this.win1vBottom = val & 0xff;
    this.win1vTop = val >>> 16 & 0xff;
  }

  private int onWininRead() {
    return this.win1in.pack() << 8 | this.win0in.pack();
  }

  private void onWininWrite(final int val) {
    this.win0in.unpack(val & 0xff);
    this.win1in.unpack(val >>> 8 & 0xff);
  }

  private int onWinoutRead() {
    return this.winobj.pack() << 8 | this.winout.pack();
  }

  private void onWinoutWrite(final int val) {
    this.winout.unpack(val & 0xff);
    this.winobj.unpack(val >>> 8 & 0xff);
  }

  private int onMosaicRead() {
    return
      this.bgMosaicW - 1 << MOSAIC_BG_X_SIZE_SHIFT |
      this.bgMosaicH - 1 << MOSAIC_BG_Y_SIZE_SHIFT |
      this.objMosaicW - 1 << MOSAIC_OBJ_X_SIZE_SHIFT |
      this.objMosaicH - 1 << MOSAIC_OBJ_Y_SIZE_SHIFT
    ;
  }

  private void onMosaicWrite(final int val) {
    this.bgMosaicW = ((val & MOSAIC_BG_X_SIZE_MASK) >>> MOSAIC_BG_X_SIZE_SHIFT) + 1;
    this.bgMosaicH = ((val & MOSAIC_BG_Y_SIZE_MASK) >>> MOSAIC_BG_Y_SIZE_SHIFT) + 1;
    this.objMosaicW = ((val & MOSAIC_OBJ_X_SIZE_MASK) >>> MOSAIC_OBJ_X_SIZE_SHIFT) + 1;
    this.objMosaicH = ((val & MOSAIC_OBJ_Y_SIZE_MASK) >>> MOSAIC_OBJ_Y_SIZE_SHIFT) + 1;
  }

  private int onBldCntRead() {
    return this.bldCnt.pack();
  }

  private void onBldCntWrite(final int val) {
    this.bldCnt.unpack(val);
  }

  private int onBldAlphaRead() {
    return this.bldAlpha2 << 8 | this.bldAlpha1;
  }

  private void onBldAlphaWrite(final int val) {
    // Upper 3 bits of each value are ignored
    this.bldAlpha1 = val & 0x1f;
    this.bldAlpha2 = (val & 0x1f00) >>> 8;
  }

  private int onBldYRead() {
    return this.bldY;
  }

  private void onBldYWrite(final int val) {
    this.bldY = Math.min(val & 0x1f, 16);
  }

  public class PaletteSegment extends Segment {
    public PaletteSegment() {
      super(0x500_0000, 0x400);
    }

    @Override
    public int get(final int offset, final int size) {
      if(size == 1) {
        return Gpu.this.palette[offset];
      }

      return MathHelper.get(Gpu.this.palette, offset, size);
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      if(size == 1) {
        Gpu.this.palette[offset] = (byte)value;
        return;
      }

      MathHelper.set(Gpu.this.palette, offset, size, value);
    }

    @Override
    public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
      System.arraycopy(data, dataOffset, Gpu.this.palette, offset, dataLength);
    }

    @Override
    public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
      System.arraycopy(Gpu.this.palette, offset, dest, dataOffset, dataSize);
    }
  }

  public class VramSegment extends Segment {
    public VramSegment() {
      super(0x600_0000, 0x1_8000);
    }

    @Override
    public int get(final int offset, final int size) {
      if(size == 1) {
        return Gpu.this.vram[offset];
      }

      return MathHelper.get(Gpu.this.vram, offset, size);
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      if(size == 1) {
        Gpu.this.vram[offset] = (byte)value;
        return;
      }

      MathHelper.set(Gpu.this.vram, offset, size, value);
    }

    @Override
    public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
      System.arraycopy(data, dataOffset, Gpu.this.vram, offset, dataLength);
    }

    @Override
    public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
      System.arraycopy(Gpu.this.vram, offset, dest, dataOffset, dataSize);
    }

    @Override
    public void memcpy(final int dest, final int src, final int length) {
      System.arraycopy(Gpu.this.vram, src, Gpu.this.vram, dest, length);
    }

    @Override
    public void memfill(final int addr, final int length, final int value) {
      Arrays.fill(Gpu.this.vram, addr, addr + length, (byte)value);
    }
  }

  public static class OamSegment extends Segment {
    private final byte[] oam = new byte[0x400];

    public OamSegment() {
      super(0x700_0000, 0x400);
    }

    @Override
    public int get(final int offset, final int size) {
      if(size == 1) {
        return this.oam[offset];
      }

      return MathHelper.get(this.oam, offset, size);
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      if(size == 1) {
        this.oam[offset] = (byte)value;
        return;
      }

      MathHelper.set(this.oam, offset, size, value);
    }

    @Override
    public void setBytes(final int offset, final byte[] data, final int dataOffset, final int dataLength) {
      System.arraycopy(data, dataOffset, this.oam, offset, dataLength);
    }

    @Override
    public void getBytes(final int offset, final byte[] dest, final int dataOffset, final int dataSize) {
      System.arraycopy(this.oam, offset, dest, dataOffset, dataSize);
    }

    public int getPriority(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress + 5] >>> 2 & 0x3;
    }

    public int getXSize(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return switch((this.oam[objAttributesAddress + 1] & 0xc0) >>> 6 |
        (this.oam[objAttributesAddress + 3] & 0xc0) >>> 4) {
        case 0, 2, 6 -> 8;
        case 1, 4, 10 -> 16;
        case 5, 8, 9, 14 -> 32;
        case 12, 13 -> 64;
        default -> 0;
      };
    }

    public int getYSize(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return switch((this.oam[objAttributesAddress + 1] & 0xc0) >>> 6 |
        (this.oam[objAttributesAddress + 3] & 0xc0) >>> 4) {
        case 0, 1, 5 -> 8;
        case 2, 4, 9 -> 16;
        case 6, 8, 10, 13 -> 32;
        case 12, 14 -> 64;
        default -> 0;
      };
    }

    public int getXCoordinate(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress + 2] & 0xff | this.oam[objAttributesAddress + 3] << 31 >> 23;
    }

    public int getYCoordinate(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress] & 0xff;
    }

    public boolean isMosaicEnabled(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x10) != 0;
    }

    public boolean is256ColorPalette(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x20) != 0;
    }

    public int getMode(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress + 1] >>> 2 & 0x3;
    }

    public int getPaletteNumber(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 5] & 0xf0) >>> 4;
    }

    public int getTileNumber(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress + 4] & 0xff | (this.oam[objAttributesAddress + 5] & 0x3) << 8;
    }

    public boolean isRotScaleEnabled(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x1) != 0;
    }

    public int getRotScaleGroupNumber(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return this.oam[objAttributesAddress + 3] >>> 1 & 0x1f;
    }

    public int getPA(final int groupNumber) {
      final int address = (groupNumber << 5) + 6;
      return this.oam[address + 1] << 8 | this.oam[address] & 0xff;
    }

    public int getPB(final int groupNumber) {
      final int address = (groupNumber << 5) + 14;
      return this.oam[address + 1] << 8 | this.oam[address] & 0xff;
    }

    public int getPC(final int groupNumber) {
      final int address = (groupNumber << 5) + 22;
      return this.oam[address + 1] << 8 | this.oam[address] & 0xff;
    }

    public int getPD(final int groupNumber) {
      final int address = (groupNumber << 5) + 30;
      return this.oam[address + 1] << 8 | this.oam[address] & 0xff;
    }

    public boolean isDisplayable(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x2) == 0;
    }

    public boolean isDoubleSize(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x2) != 0;
    }

    public boolean isHFlipEnabled(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 3] & 0x10) != 0;
    }

    public boolean isVFlipEnabled(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 3] & 0x20) != 0;
    }
  }

  public class GpuSegment extends Segment {
    public GpuSegment() {
      super(0x400_0000, 0x60);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x7c) {
        case 0x0 -> (Gpu.this.onDispCntRead() & mask) >> shift;

        case 0x4 -> ((Gpu.this.onVcountRead() << 16 | Gpu.this.onDispStatRead()) & mask) >> shift;
        case 0x8 -> ((Gpu.this.onBgCntRead(1) << 16 | Gpu.this.onBgCntRead(0)) & mask) >> shift;
        case 0xc -> ((Gpu.this.onBgCntRead(3) << 16 | Gpu.this.onBgCntRead(2)) & mask) >> shift;
        case 0x10 -> ((Gpu.this.onBgVofsRead(0) << 16 | Gpu.this.onBgHofsRead(0)) & mask) >> shift;
        case 0x14 -> ((Gpu.this.onBgVofsRead(1) << 16 | Gpu.this.onBgHofsRead(1)) & mask) >> shift;
        case 0x18 -> ((Gpu.this.onBgVofsRead(2) << 16 | Gpu.this.onBgHofsRead(2)) & mask) >> shift;
        case 0x1c -> ((Gpu.this.onBgVofsRead(3) << 16 | Gpu.this.onBgHofsRead(3)) & mask) >> shift;
        case 0x20 -> ((Gpu.this.onBgAffineBRead(2) << 16 | Gpu.this.onBgAffineARead(2)) & mask) >> shift;
        case 0x24 -> ((Gpu.this.onBgAffineDRead(2) << 16 | Gpu.this.onBgAffineCRead(2)) & mask) >> shift;
        case 0x28 -> (Gpu.this.onBgXRead(2) & mask) >> shift;
        case 0x2c -> (Gpu.this.onBgYRead(2) & mask) >> shift;
        case 0x30 -> ((Gpu.this.onBgAffineBRead(3) << 16 | Gpu.this.onBgAffineARead(3)) & mask) >> shift;
        case 0x34 -> ((Gpu.this.onBgAffineDRead(3) << 16 | Gpu.this.onBgAffineCRead(3)) & mask) >> shift;
        case 0x38 -> (Gpu.this.onBgXRead(3) & mask) >> shift;
        case 0x3c -> (Gpu.this.onBgYRead(3) & mask) >> shift;
        case 0x40 -> ((Gpu.this.onWin1hRead() << 16 | Gpu.this.onWin0hRead()) & mask) >> shift;
        case 0x44 -> ((Gpu.this.onWin1vRead() << 16 | Gpu.this.onWin0vRead()) & mask) >> shift;
        case 0x48 -> ((Gpu.this.onWinoutRead() << 16 | Gpu.this.onWininRead()) & mask) >> shift;
        case 0x4c -> (Gpu.this.onMosaicRead() & mask) >> shift;
        case 0x50 -> ((Gpu.this.onBldAlphaRead() << 16 | Gpu.this.onBldCntRead()) & mask) >> shift;
        case 0x54 -> (Gpu.this.onBldYRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no GPU port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x3) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x7c) {
        case 0x0 -> Gpu.this.onDispCntWrite(Gpu.this.onDispCntRead() & ~mask | value << shift & mask);

        case 0x4 -> Gpu.this.onDispStatWrite(Gpu.this.onDispStatRead() & ~mask | value << shift & mask);

        case 0x8 -> {
          final int current = Gpu.this.onBgCntRead(1) << 16 | Gpu.this.onBgCntRead(0);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgCntWrite(0, newValue & 0xffff);
          Gpu.this.onBgCntWrite(1, newValue >>> 16);
        }

        case 0xc -> {
          final int current = Gpu.this.onBgCntRead(3) << 16 | Gpu.this.onBgCntRead(2);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgCntWrite(2, newValue & 0xffff);
          Gpu.this.onBgCntWrite(3, newValue >>> 16);
        }

        case 0x10 -> {
          final int current = Gpu.this.onBgVofsRead(0) << 16 | Gpu.this.onBgHofsRead(0);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgHofsWrite(0, newValue & 0xffff);
          Gpu.this.onBgVofsWrite(0, newValue >>> 16);
        }

        case 0x14 -> {
          final int current = Gpu.this.onBgVofsRead(1) << 16 | Gpu.this.onBgHofsRead(1);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgHofsWrite(1, newValue & 0xffff);
          Gpu.this.onBgVofsWrite(1, newValue >>> 16);
        }

        case 0x18 -> {
          final int current = Gpu.this.onBgVofsRead(2) << 16 | Gpu.this.onBgHofsRead(2);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgHofsWrite(2, newValue & 0xffff);
          Gpu.this.onBgVofsWrite(2, newValue >>> 16);
        }

        case 0x1c -> {
          final int current = Gpu.this.onBgVofsRead(3) << 16 | Gpu.this.onBgHofsRead(3);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgHofsWrite(3, newValue & 0xffff);
          Gpu.this.onBgVofsWrite(3, newValue >>> 16);
        }

        case 0x20 -> {
          final int current = Gpu.this.onBgAffineBRead(2) << 16 | Gpu.this.onBgAffineARead(2);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgAffineAWrite(2, newValue & 0xffff);
          Gpu.this.onBgAffineBWrite(2, newValue >>> 16);
        }

        case 0x24 -> {
          final int current = Gpu.this.onBgAffineDRead(2) << 16 | Gpu.this.onBgAffineCRead(2);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgAffineCWrite(2, newValue & 0xffff);
          Gpu.this.onBgAffineDWrite(2, newValue >>> 16);
        }

        case 0x28 -> Gpu.this.onBgXWrite(2, Gpu.this.onBgXRead(2) & ~mask | value << shift & mask);
        case 0x2c -> Gpu.this.onBgYWrite(2, Gpu.this.onBgYRead(2) & ~mask | value << shift & mask);

        case 0x30 -> {
          final int current = Gpu.this.onBgAffineBRead(3) << 16 | Gpu.this.onBgAffineARead(3);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgAffineAWrite(3, newValue & 0xffff);
          Gpu.this.onBgAffineBWrite(3, newValue >>> 16);
        }

        case 0x34 -> {
          final int current = Gpu.this.onBgAffineDRead(3) << 16 | Gpu.this.onBgAffineCRead(3);
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBgAffineCWrite(3, newValue & 0xffff);
          Gpu.this.onBgAffineDWrite(3, newValue >>> 16);
        }

        case 0x38 -> Gpu.this.onBgXWrite(3, Gpu.this.onBgXRead(3) & ~mask | value << shift & mask);
        case 0x3c -> Gpu.this.onBgYWrite(3, Gpu.this.onBgYRead(3) & ~mask | value << shift & mask);

        case 0x40 -> {
          final int current = Gpu.this.onWin1hRead() << 16 | Gpu.this.onWin0hRead();
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onWin0hWrite(newValue & 0xffff);
          Gpu.this.onWin1hWrite(newValue >>> 16);
        }

        case 0x44 -> {
          final int current = Gpu.this.onWin1vRead() << 16 | Gpu.this.onWin0vRead();
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onWin0vWrite(newValue & 0xffff);
          Gpu.this.onWin1vWrite(newValue >>> 16);
        }

        case 0x48 -> {
          final int current = Gpu.this.onWinoutRead() << 16 | Gpu.this.onWininRead();
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onWininWrite(newValue & 0xffff);
          Gpu.this.onWinoutWrite(newValue >>> 16);
        }

        case 0x4c -> Gpu.this.onMosaicWrite(Gpu.this.onMosaicRead() & ~mask | value << shift & mask);

        case 0x50 -> {
          final int current = Gpu.this.onBldAlphaRead() << 16 | Gpu.this.onBldCntRead();
          final int newValue = current & ~mask | value << shift & mask;
          Gpu.this.onBldCntWrite(newValue & 0xffff);
          Gpu.this.onBldAlphaWrite(newValue >>> 16);
        }

        case 0x54 -> Gpu.this.onBldYWrite(Gpu.this.onBldYRead() & ~mask | value << shift & mask);

        default -> throw new IllegalAddressException("There is no GPU port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }

  public enum BlendFlag {
    Bg0(0x1),
    Bg1(0x1 << 1),
    Bg2(0x1 << 2),
    Bg3(0x1 << 3),
    Obj(0x1 << 4),
    Backdrop(0x1 << 5),
    ;

    public final int val;

    BlendFlag(final int val) {
      this.val = val;
    }
  }
}
