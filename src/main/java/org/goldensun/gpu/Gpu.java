package org.goldensun.gpu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.DebugHelper;
import org.goldensun.Hardware;
import org.goldensun.cpu.InterruptController;
import org.goldensun.cpu.InterruptType;
import org.goldensun.dma.DmaController;
import org.goldensun.memory.IllegalAddressException;
import org.goldensun.memory.Memory;
import org.goldensun.memory.Segment;
import org.goldensun.memory.Value;
import org.goldensun.memory.segments.RamSegment;
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

import static org.goldensun.Hardware.CODE;
import static org.lwjgl.opengl.GL11C.GL_BLEND;
import static org.lwjgl.opengl.GL11C.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11C.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11C.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11C.GL_NEAREST;
import static org.lwjgl.opengl.GL11C.GL_RED;
import static org.lwjgl.opengl.GL11C.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11C.glClear;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.opengl.GL11C.glDisable;
import static org.lwjgl.opengl.GL11C.glViewport;

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
  /** Nanoseconds per line */
  private static final int V_LINE_NANOS = 1_000_000_000 / V_LINES;
  /** Nanoseconds per dot */
  private static final int H_DOT_NANOS = V_LINE_NANOS / H_DOTS;
  private static final int H_DRAW_NANOS = H_DOT_NANOS * H_DRAW_DOTS;

  private static final int VBLANK_FLAG_MASK = 0b1;
  private static final int VBLANK_FLAG_SHIFT = 0;
  private static final int HBLANK_FLAG_MASK = 0b10;
  private static final int HBLANK_FLAG_SHIFT = 1;
  private static final int VCOUNT_FLAG_MASK = 0b100;
  private static final int VCOUNT_FLAG_SHIFT = 2;
  private static final int VBLANK_IRQ_ENABLE_MASK = 0b1000;
  private static final int VBLANK_IRQ_ENABLE_SHIFT = 3;
  private static final int HBLANK_IRQ_ENABLE_MASK = 0b1_0000;
  private static final int HBLANK_IRQ_ENABLE_SHIFT = 4;
  private static final int VCOUNT_IRQ_ENABLE_MASK = 0b10_0000;
  private static final int VCOUNT_IRQ_ENABLE_SHIFT = 5;
  private static final int VCOUNT_SETTING_MASK = 0b1111_1111_0000_0000;
  private static final int VCOUNT_SETTING_SHIFT = 8;

  private int dispCnt;
  private int dispStat;
  private int vcount;
  private int bg0cnt;

  private final DmaController dma;
  private final InterruptController interrupts;

  public final Window window;

  private final Matrix4f proj = new Matrix4f();
  private final Matrix4f transforms = new Matrix4f();
  private final Shader.UniformBuffer transformsUniform;
  private final FloatBuffer transformsBuffer = BufferUtils.createFloatBuffer(4 * 4 * 2);

  private int width;
  private int height;

  private final Shader vramShader;
  private final Texture vramTexture;
  private final Mesh vramMesh;

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

    memory.addSegment(new GpuSegment());
    memory.addSegment(new RamSegment(0x500_0000, 0x400)); //TODO BG/OBJ palette RAM
    memory.addSegment(new RamSegment(0x600_0000, 0x1_8000)); //TODO VRAM

    this.window = new Window("Diiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiig", 640, 640);
    this.window.events.onResize(this::onResize);
    this.window.show();

    this.transformsUniform = new Shader.UniformBuffer((long)this.transformsBuffer.capacity() * Float.BYTES, Shader.UniformBuffer.TRANSFORM);

    this.vramShader = this.loadShader(Paths.get("gfx", "shaders", "vram.vsh"), Paths.get("gfx", "shaders", "vram.fsh"));
    this.vramTexture = Texture.create(builder -> {
      builder.size(32, 32);
      builder.internalFormat(GL_RED);
      builder.dataFormat(GL_RED);
      builder.minFilter(GL_NEAREST);
      builder.magFilter(GL_NEAREST);
    });

    this.vramMesh = new Mesh(GL_TRIANGLE_STRIP, new float[] {
      0, 0, 0, 0,
      0, 1, 0, 1,
      1, 0, 1, 0,
      1, 1, 1, 1,
    }, 4);
    this.vramMesh.attribute(0, 0L, 2, 4);
    this.vramMesh.attribute(1, 2L, 2, 4);

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
    this.pre();

    for(this.vcount = 0; this.vcount < V_LINES; this.vcount++) {
      final long time = System.nanoTime();
      final long hdrawEnd = time + H_DRAW_NANOS;
      final long hblankEnd = time + V_LINE_NANOS;

      while(System.nanoTime() < hdrawEnd) {
        DebugHelper.sleep(0);
      }

      this.drawLine();
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

    this.vramShader.use();
    this.vramTexture.use();
    this.vramMesh.draw();

    if(!CODE.isAlive()) {
      LOGGER.info("Code thread no longer running, shutting down");
      Hardware.stop();
      this.window.close();
    }
  }

  private void drawLine() {
    //TODO implement
  }

  private void startHblank() {
    this.dma.triggerHblank();

    if((this.dispStat & HBLANK_IRQ_ENABLE_MASK) != 0) {
      this.interrupts.set(InterruptType.LCD_HBLANK);
    }

    this.dispStat |= HBLANK_FLAG_MASK;

    if((this.dispStat & VCOUNT_FLAG_MASK) != 0 && this.vcount == ((this.dispStat & VCOUNT_SETTING_MASK) >>> VCOUNT_SETTING_SHIFT)) {
      this.interrupts.set(InterruptType.LCD_VCOUNT_MATCH);
    }
  }

  private void endHblank() {
    this.dispStat &= ~HBLANK_FLAG_MASK;
  }

  private void startVblank() {
    this.dma.triggerVblank();

    if((this.dispStat & VBLANK_IRQ_ENABLE_MASK) != 0) {
      this.interrupts.set(InterruptType.LCD_VBLANK);
    }

    this.dispStat |= VBLANK_FLAG_MASK;
  }

  private void endVblank() {
    this.dispStat &= ~VBLANK_FLAG_MASK;
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
    return this.dispCnt;
  }

  private void onDispCntWrite(final int val) {
    this.dispCnt = val;
  }

  private int onDispStatRead() {
    return this.dispStat;
  }

  private void onDispStatWrite(final int val) {
    if((val & VBLANK_FLAG_MASK) != 0 && (this.dispStat & VBLANK_FLAG_MASK) != 0) {
      throw new RuntimeException("Cannot set VBLANK flag");
    }

    if((val & HBLANK_FLAG_MASK) != 0 && (this.dispStat & HBLANK_FLAG_MASK) != 0) {
      throw new RuntimeException("Cannot set HBLANK flag");
    }

    if((val & VCOUNT_FLAG_MASK) != 0 && (this.dispStat & VCOUNT_FLAG_MASK) != 0) {
      throw new RuntimeException("Cannot set VCOUNT flag");
    }

    this.dispStat = val;
  }

  private int onVcountRead() {
    return this.vcount;
  }

  private int onBg0cntRead() {
    return this.bg0cnt;
  }

  private void onBg0cntWrite(final int val) {
    this.bg0cnt = val;
  }

  public class GpuSegment extends Segment {
    public GpuSegment() {
      super(0x400_0000, 0x60);
    }

    @Override
    public int get(final int offset, final int size) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      return switch(offset & 0x7e) {
        case 0x0 -> (Gpu.this.onDispCntRead() & mask) >> shift;

        case 0x4 -> (Gpu.this.onDispStatRead() & mask) >> shift;
        case 0x6 -> (Gpu.this.onVcountRead() & mask) >> shift;
        case 0x8 -> (Gpu.this.onBg0cntRead() & mask) >> shift;

        default -> throw new IllegalAddressException("There is no GPU port at " + Integer.toHexString(this.getAddress() + offset));
      };
    }

    @Override
    public void set(final int offset, final int size, final int value) {
      final int shift = (offset & 0x1) * 8;
      final int mask = (int)((1L << size * 8) - 1 << shift);

      switch(offset & 0x7e) {
        case 0x0 -> Gpu.this.onDispCntWrite(value << shift & mask);

        case 0x4 -> Gpu.this.onDispStatWrite(value << shift & mask);

        case 0x8 -> Gpu.this.onBg0cntWrite(value << shift & mask);

        default -> throw new IllegalAddressException("There is no GPU port at " + Integer.toHexString(this.getAddress() + offset));
      }
    }
  }
}
