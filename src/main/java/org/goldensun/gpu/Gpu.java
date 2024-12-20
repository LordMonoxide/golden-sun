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
  private final int[] bghofs = new int[4];
  private final int[] bgvofs = new int[4];

  //TODO implement windowing
  private int win0h;
  private int win1h;
  private int win0v;
  private int win1v;
  private int winin;
  private int winout;

  //TODO implement mosaic
  private int bgMosaicW;
  private int bgMosaicH;
  private int objMosaicW;
  private int objMosaicH;

  //TODO implement blending
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

    Arrays.setAll(this.bgcnt, i -> new BgCnt());

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

  private void drawLine(final int line) {
    if(line < V_DRAW_LINES) {
      if(this.dispCnt.forcedBlank) {
        for(int x = 0; x < H_DRAW_DOTS; x++) {
          this.pixels[line * H_DRAW_DOTS + x] = 0x7fff;
        }

        return;
      }

      switch(this.dispCnt.bgMode) {
        case 0 -> this.drawMode0Line(line);
        case 1 -> this.drawMode1Line(line);
        case 2 -> this.drawMode2Line(line);
        case 3 -> this.drawMode3Line(line);
        case 4 -> this.drawMode4Line(line);
        case 5 -> this.drawMode5Line(line);
      }
    }
  }

  private void drawMode0Line(final int line) {
    this.drawBgLine(line);

    for(int priority = 3; priority >= 0; priority--) {
      for(int bg = 3; bg >= 0; bg--) {
        if(this.dispCnt.displayBg[bg] && this.bgcnt[bg].priority == priority) {
          this.drawBgTextModeLine(line, bg);
        }
      }

      if(this.dispCnt.displayObj) {
        this.drawObjLine(line, priority);
      }
    }
  }

  private void drawMode1Line(final int line) {
    //TODO
  }

  private void drawMode2Line(final int line) {
    //TODO
  }

  private void drawMode3Line(final int line) {
    //TODO
  }

  private void drawMode4Line(final int line) {
    //TODO
  }

  private void drawMode5Line(final int line) {
    //TODO
  }

  private void drawBgLine(final int line) {
    final int bgColor = colour15To24(get(this.vram, 0, 2));

    final int begPixel = line * H_DRAW_DOTS;
    final int endPixel = (line + 1) * H_DRAW_DOTS;

    for(int x = begPixel; x < endPixel; x++) {
      this.pixels[x] = bgColor;
    }
  }

  private void drawBgTextModeLine(final int line, final int bgIndex) {
    final int characterBase = this.bgcnt[bgIndex].characterBaseBlock;
    final int screenBase = this.bgcnt[bgIndex].screenBaseBlock;

    final int xSize = this.bgcnt[bgIndex].screenSizeX;
    final int ySize = this.bgcnt[bgIndex].screenSizeY;
    final int xMask = xSize - 1;
    final int yMask = ySize - 1;

    final int xOffset = this.bghofs[bgIndex];
    final int yOffset = this.bgvofs[bgIndex];

    final boolean isTileDataUpsideDown = xSize != 256;
    final boolean is256ColorPalette = this.bgcnt[bgIndex].coloursPalettes == BgCnt.ColoursPalettes._256_1;
    final boolean isMosaicEnabled = this.bgcnt[bgIndex].mosaic;

    int y = isMosaicEnabled ? line - line % this.bgMosaicH : line;
    y = y + yOffset & yMask;

    int yOffsetToAdd = 0;
    if(isTileDataUpsideDown) {
      if(y >= 256) {
        yOffsetToAdd = 0x800 * 2;
      }
      y &= 0xff;
    }

    final int yTileDataOffset = (y >>> 3) * 32;

    for(int xScreen = 0; xScreen < H_DRAW_DOTS; xScreen++) {
      int x = isMosaicEnabled ? xScreen - xScreen % this.bgMosaicW : xScreen;
      x = x + xOffset & xMask;

      int xOffsetToAdd = 0;
      if(isTileDataUpsideDown) {
        if(x >= 256) {
          xOffsetToAdd = 0x800;
        }
        x &= 0xff;
      }

      final int xTileDataOffset = x >>> 3;

      int tileX = x & 0x7;
      int tileY = y & 0x7;

      final int tileDataOffset = (yTileDataOffset + xTileDataOffset) * 2 + yOffsetToAdd + xOffsetToAdd;
      final int tileData = get(this.vram, screenBase + tileDataOffset, 2);
      final int tileNumber = tileData & 0x3ff;

      if((tileData & 0x400) != 0) {
        tileX = 7 - tileX; // H-Flip
      }

      if((tileData & 0x800) != 0) {
        tileY = 7 - tileY; // V-Flip
      }

      if(is256ColorPalette) {
        final int colorIndex = this.vram[characterBase + tileNumber * 8 * 8 + tileY * 8 + tileX] & 0xff;

        if(colorIndex != 0) { // Not a transparent color
          final int rgb15 = get(this.palette, colorIndex * 2, 2);
          this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
        }
      } else {
        int colorIndex = this.vram[characterBase + tileNumber * 8 * 4 + tileY * 4 + tileX / 2] & 0xff;

        if((tileX & 0x1) != 0) {
          colorIndex >>>= 4;
        } else {
          colorIndex &= 0xf;
        }

        if(colorIndex != 0) {
          final int paletteNumber = tileData >>> 12 & 0xf;
          final int rgb15 = get(this.palette, (paletteNumber * 16 + colorIndex) * 2, 2);
          this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
        }
      }
    }
  }

  private void drawObjLine(final int line, final int priority) {
    final int vidBase = 0x1_0000;
    final int palBase = 0x200;

    final boolean is1DMapping = this.dispCnt.objCharacterVramMapping == DispCnt.ObjCharacterVramMapping.ONE_DIMENSIONAL;

    final int xMosaic = this.objMosaicW;
    final int yMosaic = this.objMosaicH;

    for(int objNumber = 127; objNumber >= 0; objNumber--) {
      final int objPriority = this.oam.getPriority(objNumber);

      if(objPriority == priority) {
        final boolean isRotScaleEnabled = this.oam.isRotScaleEnabled(objNumber);

        final int xSize = this.oam.getXSize(objNumber);
        final int ySize = this.oam.getYSize(objNumber);

        final int xTiles = xSize >>> 3;
        final int yTiles = ySize >>> 3;

        final int xCoordinate = this.oam.getXCoordinate(objNumber);
        int yCoordinate = this.oam.getYCoordinate(objNumber);

        final boolean isHFlip = this.oam.isHFlipEnabled(objNumber);
        final boolean isVFlip = this.oam.isVFlipEnabled(objNumber);

        if(yCoordinate >= V_DRAW_LINES) {
          yCoordinate -= 256;
        }

        final boolean is256ColorPalette = this.oam.is256ColorPalette(objNumber);
        final int paletteNumber = this.oam.getPaletteNumber(objNumber);

        int firstTileNumber = this.oam.getTileNumber(objNumber);
        final int tileNumberIncrement;
        if(is1DMapping) {
          tileNumberIncrement = is256ColorPalette ? xTiles * 2 : xTiles;
        } else {
          tileNumberIncrement = 32;
          if(is256ColorPalette) firstTileNumber &= 0xfffe;
        }

        final boolean isMosaicEnabled = this.oam.isMosaicEnabled(objNumber);

        if(!isRotScaleEnabled) {
          final boolean isDisplayable = this.oam.isDisplayable(objNumber);

          if(isDisplayable) {
            if(line >= yCoordinate && line < yCoordinate + ySize) {
              final int ySprite = line - yCoordinate;

              for(int xSprite = 0; xSprite < xSize; xSprite++) {
                final int xScreen = xCoordinate + xSprite;

                if(xScreen >= 0 && xScreen < H_DRAW_DOTS) {
                  final int x = isHFlip ? xSize - 1 - xSprite : xSprite;
                  final int y = isVFlip ? ySize - 1 - ySprite : ySprite;

                  final int xTile = x >>> 3;
                  final int yTile = y >>> 3;

                  final int tileX = x & 0x7;
                  final int tileY = y & 0x7;

                  if(is256ColorPalette) {
                    final int tileNumber = firstTileNumber + yTile * tileNumberIncrement + xTile * 2;

                    final int colorIndex = this.vram[vidBase + tileNumber * 32 + tileY * 8 + tileX] & 0xff;

                    if(colorIndex != 0) {
                      final int rgb15 = get(this.palette, palBase + colorIndex * 2, 2);
                      this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
                    }
                  } else {
                    final int tileNumber = firstTileNumber + yTile * tileNumberIncrement + xTile;

                    int colorIndex = this.vram[vidBase + tileNumber * 32 + tileY * 4 + tileX / 2] & 0xff;

                    if((tileX & 0x1) != 0) {
                      colorIndex >>>= 4;
                    } else {
                      colorIndex &= 0xf;
                    }

                    if(colorIndex != 0) {
                      final int rgb15 = get(this.palette, palBase + (paletteNumber * 16 + colorIndex) * 2, 2);
                      this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
                    }
                  }
                }
              }
            }
          }
        } else {
          final int mode = this.oam.getMode(objNumber);
          final boolean doubleSize = this.oam.isDoubleSize(objNumber);

          int renderXSize = xSize;

          if(doubleSize) {
            renderXSize *= 2;
          }

          final int parameterId = this.oam.getRotScaleGroupNumber(objNumber);
          final int pA = this.oam.getPA(parameterId);
          final int pB = this.oam.getPB(parameterId);
          final int pC = this.oam.getPC(parameterId);
          final int pD = this.oam.getPD(parameterId);

          final int xofs;
          final int yofs;
          final int xfofs;
          final int yfofs;

          if(doubleSize) {
            xofs = xSize;
            yofs = ySize;
            xfofs = -xofs / 2;
            yfofs = -yofs / 2;
          } else {
            xofs = xSize / 2;
            yofs = ySize / 2;
            xfofs = 0;
            yfofs = 0;
          }

          // Left edge
          final int origXEdge0 = -xofs;
          final int origY = (line - yCoordinate) - yofs;

          // Calculate starting parameters for matrix multiplications
          final int shiftedXOfs = xofs + xfofs << 8;
          final int shiftedYOfs = yofs + yfofs << 8;
          final int pBYOffset = pB * origY + shiftedXOfs;
          final int pDYOffset = pD * origY + shiftedYOfs;

          int objPixelXEdge0 = pA * origXEdge0 + pBYOffset;
          int objPixelYEdge0 = pC * origXEdge0 + pDYOffset;

          for(int xSprite = 0; xSprite < renderXSize; xSprite++) {
            final int xScreen = xCoordinate + xSprite;

            if(xScreen < H_DRAW_DOTS) {
              final int lerpedObjPixelX = objPixelXEdge0 >> 8;
              final int lerpedObjPixelY = objPixelYEdge0 >> 8;

              if(lerpedObjPixelX >= 0 && lerpedObjPixelX < xSize && lerpedObjPixelY >= 0 && lerpedObjPixelY < ySize) {
                final int x = isHFlip ? xSize - 1 - lerpedObjPixelX : lerpedObjPixelX;
                final int y = isVFlip ? ySize - 1 - lerpedObjPixelY : lerpedObjPixelY;

                final int xTile = x >>> 3;
                final int yTile = y >>> 3;

                final int tileX = x & 0x7;
                final int tileY = y & 0x7;

                if(is256ColorPalette) {
                  final int tileNumber = firstTileNumber + yTile * tileNumberIncrement + xTile * 2;

                  final int colorIndex = this.vram[vidBase + tileNumber * 32 + tileY * 8 + tileX] & 0xff;

                  if(colorIndex != 0) {
                    final int rgb15 = get(this.palette, palBase + colorIndex * 2, 2);
                    this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
                  }
                } else {
                  final int tileNumber = firstTileNumber + yTile * tileNumberIncrement + xTile;

                  int colorIndex = this.vram[vidBase + tileNumber * 32 + tileY * 4 + tileX / 2] & 0xff;

                  if((tileX & 0x1) != 0) {
                    colorIndex >>>= 4;
                  } else {
                    colorIndex &= 0xf;
                  }

                  if(colorIndex != 0) {
                    final int rgb15 = get(this.palette, palBase + (paletteNumber * 16 + colorIndex) * 2, 2);
                    this.pixels[line * H_DRAW_DOTS + xScreen] = colour15To24(rgb15);
                  }
                }
              }
            }
            objPixelXEdge0 += pA;
            objPixelYEdge0 += pC;
          }
        }
      }
    }
  }

  private void startHblank() {
    this.dma.triggerHblank();

    if(this.dispStat.hblankIrqEnable) {
      this.interrupts.set(InterruptType.LCD_HBLANK);
    }

    this.dispStat.hblankFlag = true;

    if(this.dispStat.vcountIrqEnable && this.vcount == this.dispStat.vcountSetting) {
      this.interrupts.set(InterruptType.LCD_VCOUNT_MATCH);
    }
  }

  private void endHblank() {
    this.dispStat.hblankFlag = false;
  }

  private void startVblank() {
    this.dma.triggerVblank();

    if(this.dispStat.vblankIrqEnable) {
      this.interrupts.set(InterruptType.LCD_VBLANK);
    }

    this.dispStat.vblankFlag = true;
  }

  private void endVblank() {
    this.dispStat.vblankFlag = false;
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
    return this.bgcnt[index].pack();
  }

  private void onBgCntWrite(final int index, final int val) {
    this.bgcnt[index].unpack(val);
  }

  private int onBgHofsRead(final int index) {
    return this.bghofs[index];
  }

  private void onBgHofsWrite(final int index, final int val) {
    this.bghofs[index] = val;
  }

  private int onBgVofsRead(final int index) {
    return this.bgvofs[index];
  }

  private void onBgVofsWrite(final int index, final int val) {
    this.bgvofs[index] = val;
  }

  private int onWin0hRead() {
    return this.win0h;
  }

  private void onWin0hWrite(final int val) {
    this.win0h = val;
  }

  private int onWin1hRead() {
    return this.win1h;
  }

  private void onWin1hWrite(final int val) {
    this.win1h = val;
  }

  private int onWin0vRead() {
    return this.win0v;
  }

  private void onWin0vWrite(final int val) {
    this.win0v = val;
  }

  private int onWin1vRead() {
    return this.win1v;
  }

  private void onWin1vWrite(final int val) {
    this.win1v = val;
  }

  private int onWinoutRead() {
    return this.winout;
  }

  private void onWinoutWrite(final int val) {
    this.winout = val;
  }

  private int onWininRead() {
    return this.winin;
  }

  private void onWininWrite(final int val) {
    this.winin = val;
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

    if(val != 0) {
      //TODO
      LOGGER.warn("BLDCNT not implemented");
    }
  }

  private int onBldAlphaRead() {
    return this.bldAlpha2 << 8 | this.bldAlpha1;
  }

  private void onBldAlphaWrite(final int val) {
    // Upper 4 bits of each value are ignored
    this.bldAlpha1 = val & 0xf;
    this.bldAlpha2 = val & 0xf00;
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
      return this.oam[objAttributesAddress + 2] & 0xff | (this.oam[objAttributesAddress + 3] << 31) >> 23;
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

    public boolean isDoubleSizeEnabled(final int objNumber) {
      final int objAttributesAddress = objNumber << 3;
      return (this.oam[objAttributesAddress + 1] & 0x2) != 0;
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
}
