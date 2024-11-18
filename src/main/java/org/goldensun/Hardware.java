package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.cpu.Cpu;
import org.goldensun.cpu.InterruptController;
import org.goldensun.dma.DmaController;
import org.goldensun.gpu.Gpu;
import org.goldensun.input.Input;
import org.goldensun.memory.Memory;
import org.goldensun.memory.segments.PrivilegeGate;
import org.goldensun.memory.segments.RamSegment;
import org.goldensun.memory.segments.RomSegment;
import org.goldensun.saves.Sram;
import org.goldensun.spu.Spu;
import org.goldensun.timers.TimerController;

import java.nio.file.Path;

public final class Hardware {
  private Hardware() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(Hardware.class);

  public static final Memory MEMORY = new Memory();
  public static final PrivilegeGate GATE = new PrivilegeGate();
  public static final InterruptController INTERRUPTS = new InterruptController(MEMORY); // 0x400_0200
  public static final DmaController DMA = new DmaController(MEMORY);
  public static final Sram SRAM = new Sram(MEMORY);
  public static final Cpu CPU = new Cpu(MEMORY, SRAM);
  public static final Gpu GPU = new Gpu(MEMORY, DMA, INTERRUPTS);
  public static final Spu SPU = new Spu(MEMORY);
  public static final Input INPUT = new Input(MEMORY, GPU.window.events);
  public static final TimerController TIMERS = new TimerController(MEMORY, INTERRUPTS);

  public static final Thread CODE = new Thread(Hardware::run, "Game");
  private static final Thread cpuThread = new Thread(CPU, "CPU");
  private static final Thread timerThread = new Thread(TIMERS, "Timers");

  static {
    MEMORY.addSegment(GATE.wrap(RomSegment.fromFile(0x000_0000, 0x4000, Path.of("bios.rom"))));
    MEMORY.addSegment(new RamSegment(0x200_0000, 0x4_0000)); // On-board work RAM
    MEMORY.addSegment(new RamSegment(0x300_0000, 0x8000, 0xf00_7fff)); // On-chip work RAM
    MEMORY.addSegment(RomSegment.fromFile(0x800_0000, 0x80_0000, Path.of("game.rom")));

    GATE.acquire();
    MEMORY.addFunctions(Bios.class);
    MEMORY.addFunctions(GoldenSun.class);
    MEMORY.addFunctions(GoldenSun_80b.class);
    MEMORY.addFunctions(GoldenSun_80f.class);
    MEMORY.addFunctions(GoldenSun_801.class);
    MEMORY.addFunctions(GoldenSun_802.class);
    MEMORY.addFunctions(GoldenSun_807.class);
    MEMORY.addFunctions(GoldenSun_808.class);
    MEMORY.addFunctions(GoldenSun_809.class);
    MEMORY.addFunctions(GoldenSun_80a.class);
    MEMORY.addFunctions(GoldenSun_818.class);
    GATE.release();
  }

  public static void start() {
    cpuThread.start();
    timerThread.start();
    CODE.start();

    GPU.run();
  }

  private static void run() {
    final int offset = MEMORY.get(0x800_0000, 1) * 4;

    MEMORY.ref(4, 0x800_0008 + offset).call();

    LOGGER.error("Terminated");
    stop();
  }

  public static void stop() {
    CPU.stop();
    TIMERS.stop();
  }
}
