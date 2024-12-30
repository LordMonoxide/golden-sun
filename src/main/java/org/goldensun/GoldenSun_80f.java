package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.SoundStruct;
import org.goldensun.types.SoundStruct0c;
import org.goldensun.types.SoundStruct50;
import org.goldensun.types.SoundStructFb0;

import static org.goldensun.GoldenSun.CpuSet;
import static org.goldensun.GoldenSun.FUN_80037d4;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004760;
import static org.goldensun.GoldenSun.FUN_80053e8;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearTickCallbacks;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.fadeInAlpha;
import static org.goldensun.GoldenSun.fadeInBrightness;
import static org.goldensun.GoldenSun.fadeOutAlpha;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.initVramSlots;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadUiTextures;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.waitForFade;
import static org.goldensun.GoldenSunVars.vblankTransferQueue_2002090;
import static org.goldensun.GoldenSunVars._2003050;
import static org.goldensun.GoldenSunVars._3001d18;
import static org.goldensun.GoldenSunVars._3001d20;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001f58;
import static org.goldensun.GoldenSunVars._3007ff0;
import static org.goldensun.GoldenSunVars._80fc624;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.Hardware.TIMERS;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getMethodAddress;
import static org.goldensun.memory.MemoryHelper.getRunnable;
import static org.goldensun.memory.MemoryHelper.getTriConsumer;

public final class GoldenSun_80f {
  private GoldenSun_80f() { }

  /** {@link GoldenSun_80f#FUN_80f26ec} */
  @Method(0x80f2000)
  public static int FUN_80f2000(final int r0) {
    return (int)MEMORY.call(0x80f26ec, r0);
  }

  @Method(0x80f2018)
  public static int FUN_80f2018(final int r0) {
    return (int)MEMORY.call(0x80f2b71, r0);
  }

  @Method(0x80f2020)
  public static int FUN_80f2020() {
    return (int)MEMORY.call(0x80f2d55);
  }

  @Method(0x80f2028)
  public static void FUN_80f2028() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    int r7;
    int r8;
    final int r9;
    final int r10;
    final int r12;

    r6 = boardWramMallocHead_3001e50.offset(43 * 0x4).get();
    r8 = 0;
    if(_3001d20.get() == 0) {
      MEMORY.ref(4, r6 + 0xc).incr();
      if((MEMORY.ref(4, r6 + 0xc).get() & 0x3) == 0) {
        MEMORY.ref(4, r6 + 0x14).incr();
      }
    }

    //LAB_80f2056
    r10 = 0x30 - MEMORY.ref(2, 0x3001ad0 + 0x6).getUnsigned();
    r1 = 0x90 - MEMORY.ref(4, r6 + 0x14).get();
    if(MEMORY.ref(4, r6 + 0x8).get() < 0x118) {
      //LAB_80f2072
      if((MEMORY.ref(4, r6 + 0xc).get() & 0x1) == 0) {
        //LAB_80f207e
        r3 = MEMORY.ref(1, 0x80f39ab).getUnsigned();
        r9 = r1 - r10;
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x10;
        r7 = r3 - 0x10;

        //LAB_80f20a4
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f20aa
        //LAB_80f20b2
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f20b8
        r0 = r7 + 0x4 << 16;
        r1 = r7 + 0x14 << 16;
        r2 = r5 + 0x10 << 24 >>> 24;
        MEMORY.ref(4, r6 + 0x18).setu(0x40002400 | r0 | r5);
        MEMORY.ref(4, r6 + 0x20).setu(0x50002400 | r1 | r5);
        MEMORY.ref(4, r6 + 0x28).setu(0x60002400 | r0 | r2);
        MEMORY.ref(4, r6 + 0x30).setu(0x70002400 | r1 | r2);
        MEMORY.ref(4, r6 + 0x1c).setu(0xe8);
        MEMORY.ref(4, r6 + 0x24).setu(0xe8);
        MEMORY.ref(4, r6 + 0x2c).setu(0xe8);
        MEMORY.ref(4, r6 + 0x34).setu(0xe8);
        r3 = MEMORY.ref(1, 0x80f39ab + 0x2).getUnsigned();
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x10;
        r7 = r3 - 0x10;

        //LAB_80f2128
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f212e
        //LAB_80f2136
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f213c
        r3 = r7 + 0x4 << 16;
        MEMORY.ref(4, r6 + 0x38).setu(0x80002400 | r3 | r5);
        MEMORY.ref(4, r6 + 0x3c).setu(0x80);
        r8 = 5;
        r3 = MEMORY.ref(1, 0x80f39ab + 0x4).getUnsigned();
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x20;
        r7 = r3 - 0x20;

        //LAB_80f2174
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f217a
        //LAB_80f2182
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f2188
        r0 = r7 + 0x4 << 16;
        r1 = r7 + 0x24 << 16;
        r2 = r5 + 0x20 << 24 >>> 24;
        r12 = r8 * 0x8;
        MEMORY.ref(4, r6 + r12 + 0x18).setu(0x80002400 | r0 | r5);
        MEMORY.ref(4, r6 + r12 + 0x20).setu(0x90002400 | r1 | r5);
        MEMORY.ref(4, r6 + r12 + 0x28).setu(0xa0002400 | r0 | r2);
        r1 = 0xb0002400 | r1 | r2;
        r0 = r12;
        r3 = r12;
        r2 = 0xc0;
      } else {
        //LAB_80f2208
        r3 = MEMORY.ref(1, 0x80f39ab + 0x1).getUnsigned();
        r9 = r1 - r10;
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x10;
        r7 = r3 - 0x10;

        //LAB_80f222e
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f2234
        //LAB_80f223c
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f2242
        r0 = r7 + 0x4 << 16;
        r1 = r7 + 0x14 << 16;
        r2 = r5 + 0x10 << 24 >>> 24;
        MEMORY.ref(4, r6 + 0x18).setu(0x40002400 | r0 | r5);
        MEMORY.ref(4, r6 + 0x20).setu(0x50002400 | r1 | r5);
        MEMORY.ref(4, r6 + 0x28).setu(0x60002400 | r0 | r2);
        MEMORY.ref(4, r6 + 0x30).setu(0x70002400 | r1 | r2);
        MEMORY.ref(4, r6 + 0x1c).setu(0xe8);
        MEMORY.ref(4, r6 + 0x24).setu(0xe8);
        MEMORY.ref(4, r6 + 0x2c).setu(0xe8);
        MEMORY.ref(4, r6 + 0x34).setu(0xe8);
        r3 = MEMORY.ref(1, 0x80f39ab + 0x3).getUnsigned();
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x10;
        r7 = r3 - 0x10;

        //LAB_80f22b2
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f22b8
        //LAB_80f22c0
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f22c6
        r0 = r7 + 0x4 << 16;
        r1 = r7 + 0x14 << 16;
        r2 = r5 + 0x10 << 24 >>> 24;
        MEMORY.ref(4, r6 + 0x38).setu(0x40002400 | r0 | r5);
        MEMORY.ref(4, r6 + 0x40).setu(0x50002400 | r1 | r5);
        MEMORY.ref(4, r6 + 0x48).setu(0x60002400 | r0 | r2);
        MEMORY.ref(4, r6 + 0x50).setu(0x70002400 | r1 | r2);
        MEMORY.ref(4, r6 + 0x3c).setu(0xe0);
        MEMORY.ref(4, r6 + 0x44).setu(0xe0);
        MEMORY.ref(4, r6 + 0x4c).setu(0xe0);
        MEMORY.ref(4, r6 + 0x54).setu(0xe0);
        r8 = 0x8;
        r3 = MEMORY.ref(1, 0x80f39ab + 0x5).getUnsigned();
        r5 = divideS(r9 * (r3 - 104), 80) + r10 - 0x20;
        r7 = r3 - 0x20;

        //LAB_80f233a
        while(r5 > 0xff) {
          r5 = r5 - 0x100;
        }

        //LAB_80f2340
        //LAB_80f2348
        while(r5 < 0) {
          r5 = r5 + 0x100;
        }

        //LAB_80f234e
        r0 = r7 + 0x4 << 16;
        r12 = r8 * 0x8;
        MEMORY.ref(4, r6 + 0x18 + r12).setu(0x80002400 | r0 | r5);
        r1 = r7 + 0x24 << 16;
        MEMORY.ref(4, r6 + 0x20 + r12).setu(0x90002400 | r1 | r5);
        r2 = r5 + 0x20 << 24 >>> 24;
        MEMORY.ref(4, r6 + 0x28 + r12).setu(0xa0002400 | r0 | r2);
        r1 = 0xb0002400 | r1 | r2;
        r0 = r12;
        r3 = r12;
        r2 = 0xa0;
      }

      //LAB_80f2396
      MEMORY.ref(4, r6 + r0 + 0x30).setu(r1);
      MEMORY.ref(4, r6 + r3 + 0x1c).setu(r2);
      MEMORY.ref(4, r6 + r3 + 0x24).setu(r2);
      MEMORY.ref(4, r6 + r3 + 0x2c).setu(r2);
      MEMORY.ref(4, r6 + r3 + 0x34).setu(r2);
      r8 += 0x4;
    }

    //LAB_80f23ae
    //LAB_80f23ba
    while(r8 < 120) {
      MEMORY.ref(4, r6 + 0x18 + r8 * 0x8).setu(0x400020a0);
      r8++;
    }

    //LAB_80f23c8
    GPU.BLDCNT.setu(0x3f50);
    GPU.BLDALPHA.setu(0xe0e);
    r5 = r8 * 0x8;
    DMA.channels[3].SAD.setu(r6 + 0x18);
    DMA.channels[3].DAD.setu(0x7000000);
    DMA.channels[3].CNT.setu(0x84000000 | r5 >>> 2);

    r2 = 32 - MEMORY.ref(2, 0x3001ad0 + 0x6).getUnsigned();

    //LAB_80f243c
    //LAB_80f2442
    while(r2 > 0xff) {
      r2 = r2 - 0x100;
    }

    //LAB_80f2448
    //LAB_80f2450
    while(r2 < 0) {
      r2 = r2 + 0x100;
    }

    //LAB_80f2456
    MEMORY.ref(4, r6 + 0x78).setu(0xc05c2000 | r2);
    MEMORY.ref(4, r6 + 0x7c).setu(0x800);
    DMA.channels[3].SAD.setu(r6 + 0x78);
    DMA.channels[3].DAD.setu(0x7000000 + r5);
    DMA.channels[3].CNT.setu(0x84000002);
    DMA.channels[3].SAD.setu(r6 + 0x18);
    DMA.channels[3].DAD.setu(0x7000000);
    DMA.channels[3].CNT.setu(0x84000008);
  }

  /** Part of load game menu? */
  @Method(0x80f24a0)
  public static void FUN_80f24a0() {
    int r0;
    int r1;
    int r3;
    int r4;

    final int r7 = boardWramMallocHead_3001e50.offset(43 * 0x4).get();
    GPU.DISPCNT.setu(0);

    r4 = getPointerTableEntry(21);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x5000200);
    DMA.channels[3].CNT.setu(0x84000080);
    MEMORY.ref(2, 0x5000200).setu(0);

    FUN_80053e8(r4 + 0x200, 0x2010000);
    DMA.channels[3].SAD.setu(0x2010000);
    DMA.channels[3].DAD.setu(0x6010000);
    DMA.channels[3].CNT.setu(0x80000f00);

    r4 = getPointerTableEntry(23);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000080);
    MEMORY.ref(2, 0x5000000).setu(0);
    FUN_80053e8(r4 + 0x200, 0x2010000);

    DMA.channels[3].SAD.setu(0x2012940);
    DMA.channels[3].DAD.setu(0x6000000);
    DMA.channels[3].CNT.setu(0x80002760);
    DMA.channels[3].SAD.setu(0x201a140);
    DMA.channels[3].DAD.setu(0x6004ec0);
    DMA.channels[3].CNT.setu(0x80004ec0);

    r1 = 0x600f000;
    r3 = 0x267;

    //LAB_80f254a
    for(r4 = 0; r4 < 11; r4++) {
      //LAB_80f254c
      for(r0 = 0; r0 < 30; r0++) {
        MEMORY.ref(2, r1).setu(r3);
        r1 = r1 + 0x2;
        r3++;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
    }

    r3 = 0x13b;

    //LAB_80f2574
    for(r4 = 11; r4 < 32; r4++) {
      //LAB_80f2576
      for(r0 = 0; r0 < 30; r0++) {
        MEMORY.ref(2, r1).setu(r3);
        r1 = r1 + 0x2;
        r3++;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
    }

    r1 = 0x600f800;
    r3 = 0x12c;

    //LAB_80f25a2
    for(r4 = 0; r4 < 11; r4++) {
      //LAB_80f25a4
      for(r0 = 0; r0 < 30; r0++) {
        MEMORY.ref(2, r1).setu(r3);
        r1 = r1 + 0x2;
        r3++;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
    }

    r3 = 0;

    //LAB_80f25cc
    for(r4 = 11; r4 < 32; r4++) {
      //LAB_80f25ce
      for(r0 = 0; r0 < 30; r0++) {
        MEMORY.ref(2, r1).setu(r3);
        r1 = r1 + 0x2;
        r3++;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
    }

    GPU.BG1CNT.setu(0x1f43);
    GPU.BG2CNT.setu(0x1e81);
    GPU.WIN0H.setu(0xf0);
    GPU.WIN0V.setu(0x9f);
    GPU.WIN1H.setu(0xf0);
    GPU.WIN1V.setu(0x9f);
    GPU.WININ.setu(0x1616);

    //LAB_80f2680
    for(r4 = 0; r4 < 4; r4++) {
      MEMORY.ref(2, 0x3001ad0 + r4 * 0x4 + 0x2).setu(0);
      MEMORY.ref(2, 0x3001ad0 + r4 * 0x4).setu(0);
    }

    r0 = 0x3001ad0;
    MEMORY.ref(2, r0 + 0x6).setu(0x60);
    MEMORY.ref(2, r0 + 0xa).setu(0x60);
    MEMORY.ref(4, r7 + 0x8).setu(0);
    MEMORY.ref(4, r7).setu(0);
    MEMORY.ref(4, r7 + 0x4).setu(0);
    MEMORY.ref(4, r7 + 0xc).setu(0);
    MEMORY.ref(4, r7 + 0x14).setu(0);
    MEMORY.ref(4, r7 + 0x10).setu(0);
    DMA.channels[3].SAD.setu(0x3001ad0);
    DMA.channels[3].DAD.setu(0x4000010);
    DMA.channels[3].CNT.setu(0x84000004);
    GPU.BLDCNT.setu(0x3fbf);
    GPU.BLDALPHA.setu(0x1010);
    GPU.BLDCNT.setu(0x3f44);
  }

  @Method(0x80f26ec)
  public static int FUN_80f26ec(final int r0) {
    int r1;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.sp().value -= 0x14;
    int sp08 = 0;
    final int sp04 = _3001f58.get();
    final int r8 = mallocSlotChip(43, 0xe0);
    FUN_8004760();
    initVramSlots();
    sleep(1);
    clearTickCallbacks();
    _3001d18.set(0);
    _3001f58.set(0);
    FUN_80f24a0();
    FUN_80f377c();
    FUN_80f3824(2, 0);

    r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    final int r2 = vblankTransferQueue_2002090.count_00.get();
    if(r2 < 32) {
      vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(0xf740);
      vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(0x4000000);
      vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0x20000);
      vblankTransferQueue_2002090.count_00.incr();
    }

    //LAB_80f276e
    INTERRUPTS.INT_MASTER_ENABLE.setu(r4);

    FUN_80f3858(60);
    setTickCallback(getRunnable(GoldenSun_80f.class, "FUN_80f2028"), 0x480);
    final int r11 = CPU.sp().value + 0x12;

    //LAB_80f278e
    do {
      r1 = MEMORY.ref(4, r8 + 0x8).get();
      if(r1 >= 0x15 && r1 < 0xef) {
        if((pressedButtons_3001c94.get() & 0x9) != 0) {
          MEMORY.ref(4, r8 + 0x10).setu(0x1);
          MEMORY.ref(4, r8 + 0x8).setu(0xef);
          r1 = 0xef;
        }
      }

      //LAB_80f27b2
      r3 = r1 + 1;
      MEMORY.ref(4, r8 + 0x8).setu(r3);
      if(r3 < 0x117) {
        //LAB_80f27c2
        r5 = MEMORY.ref(4, r8 + 0xc).get();
        if(modS(r5, 3) == 0) {
          MEMORY.ref(2, 0x3001ad0 + 0x6).decr();

          if((MEMORY.ref(2, 0x3001ad0 + 0x6).getUnsigned() & 0x7) == 0) {
            r3 = MEMORY.ref(4, r8).get();
            DMA.channels[3].SAD.setu(0x2012580 - r3 * 0x3c0);
            DMA.channels[3].DAD.setu(0x6004b00 - r3 * 0x3c0);
            DMA.channels[3].CNT.setu(0x800001e0);
            MEMORY.ref(4, r8).incr();
          }
        }

        //LAB_80f280a
        if((r5 & 0x1) == 0) {
          MEMORY.ref(2, 0x3001ad0 + 0xa).decr();

          if((MEMORY.ref(2, 0x3001ad0 + 0xa).getUnsigned() & 0x7) == 0) {
            r3 = MEMORY.ref(4, r8 + 0x4).get();
            r1 = r3 * 8;
            if(r1 <= 0x18) {
              DMA.channels[3].SAD.setu(0x20199c0 - r3 * 0x780);
              DMA.channels[3].DAD.setu(0x600e4c0 - r3 * 0x780);
              DMA.channels[3].CNT.setu(0x800003c0);
            } else {
              //LAB_80f288c
              MEMORY.ref(2, r11).setu(0);
              DMA.channels[3].SAD.setu(r11);
              DMA.channels[3].DAD.setu(0x6004ec0 + modS(160 - r1, 160) * 0xf0);
              DMA.channels[3].CNT.setu(0x810003c0);
              r1 = 0x600f6c0;

              //LAB_80f28b4
              for(r7 = 0; r7 < 5; r7++) {
                //LAB_80f28b6
                for(r6 = 0; r6 < 30; r6++) {
                  MEMORY.ref(2, r1).setu(0x13b);
                  r1 = r1 + 0x2;
                }

                MEMORY.ref(2, r1).setu(0x13b);
                r1 = r1 + 0x2;
                MEMORY.ref(2, r1).setu(0x13b);
                r1 = r1 + 0x2;
              }
            }

            //LAB_80f28e4
            MEMORY.ref(4, r8 + 0x4).incr();
          }
        }

        //LAB_80f28ec
        if(MEMORY.ref(4, r8 + 0x8).get() == 0xef) {
          MEMORY.ref(4, r8 + 0x10).setu(0x1);
        }
        //LAB_80f28fa
      } else if(r3 == 0x119) {
        MEMORY.ref(4, r8 + 0x10).setu(2);
        //LAB_80f2908
      } else if(r3 == 0x121) {
        MEMORY.ref(4, r8 + 0x10).setu(0);
        //LAB_80f2920
      } else if(r3 == 0x118) {
        break;
      }

      //LAB_80f29bc
      sleep(1);
    } while(true);

    fadeOutAlpha(1);
    clearTickCallback(getRunnable(GoldenSun_80f.class, "FUN_80f2028"));
    _3001d18.set(0x1);
    sleep(1);
    GPU.BG2CNT.setu(0x681);
    GPU.DISPCNT.setu(0x1440);
    MEMORY.ref(2, 0x3001ad0 + 0xa).setu(0);
    r4 = getPointerTableEntry(22);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000078);
    MEMORY.ref(2, 0x5000000).setu(0);
    FUN_80053e8(r4 + 0x200, tileAttribs_2010000.getAddress());
    DMA.channels[3].SAD.setu(tileAttribs_2010000.getAddress());
    DMA.channels[3].DAD.setu(0x6004000);
    DMA.channels[3].CNT.setu(0x80004b00);
    r1 = 0x6003000;
    r3 = 0x100;

    //LAB_80f29ea
    for(r7 = 0; r7 < 20; r7++) {
      //LAB_80f29c4
      //LAB_80f29c6
      for(r6 = 0; r6 < 30; r6++) {
        MEMORY.ref(2, r1).setu(r3);
        r3 = r3 + 0x1;
        r1 = r1 + 0x2;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 = r1 + 0x2;
    }

    //here
    loadUiTextures();
    FUN_8004760();

    if(r0 != 0) {
      r6 = mallocSlotBoard(14, 0x400);
      FUN_80053e8(0x80f38bc, r6);
      r5 = r8 + 0x80;

      //LAB_80f2a16
      for(r7 = 0; r7 < 5; r7++) {
        MEMORY.ref(4, r5).setu(0);
        MEMORY.ref(4, r5 + 0x4).setu(0x40004000);
        MEMORY.ref(4, r5 + 0x8).setu(FUN_8003fa4(getFreeVramSlot(), 0x80, r6 + (r7 * 0x100 >>> 1)));
        r5 = r5 + 0xc;
      }

      freeSlot(14);
    }

    //LAB_80f2a40
    fadeInAlpha(30);
    waitForFade();
    GPU.DISPCNT.setu(0x1540);
    final int r9;
    if(r0 != 0) {
      r9 = 3600;
    } else {
      r9 = 300;
    }

    //LAB_80f2a8c
    //LAB_80f2a96
    for(r7 = 0; r7 < r9; r7++) {
      if(r0 != 0) {
        r5 = r8 + 0x80;

        //LAB_80f2aa8
        for(r6 = 0; r6 < 3; r6++) {
          MEMORY.ref(2, r5 + 0x6).and(~0x1ff).or(0x50 + r6 * 0x20 & 0x1ff);
          MEMORY.ref(1, r5 + 0x4).setu(0x7c);
          insertIntoRenderQueue(MEMORY.ref(4, r5, RenderPacket0c::new), 0); //TODO
          r5 = r5 + 0xc;
        }

        r1 = MEMORY.ref(1, 0x80f39b1 + modU(r7, 60)).getUnsigned();
        GPU.BLDCNT.setu(0x2f50);
        GPU.BLDALPHA.setu((16 - r1) * 256 + r1);
      }

      //LAB_80f2b04
      if((pressedButtons_3001c94.get() & 0x9) != 0x0) {
        //LAB_80f2a66
        sp08 = 1;
        break;
      }
      sleep(1);
    }

    //LAB_80f2b1c
    _3001f58.set(sp04);
    freeSlot(43);
    GPU.BLDCNT.setu(0);
    GPU.BLDALPHA.setu(0);
    sleep(1);
    CPU.sp().value += 0x14;
    return sp08;
  }

  @Method(0x80f2b70)
  public static int FUN_80f2b70(final int r0) {
    int r1;
    int r3;
    final int r4;
    int r5;
    int r6;

    playSound_(0x6e);
    _3001d18.set(0x1);
    clearTickCallbacks();
    fadeOutBrightness(1);
    FUN_8004760();
    sleep(1);
    GPU.BG2CNT.setu(0x681);
    GPU.DISPCNT.setu(0x1440);
    MEMORY.ref(2, 0x3001ada).setu(0);
    r4 = getPointerTableEntry(24);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000070);

    decompress(r4 + 0x1c0, 0x2010000);
    DMA.channels[3].SAD.setu(0x2010000);
    DMA.channels[3].DAD.setu(0x6004000);
    DMA.channels[3].CNT.setu(0x84002580);

    r1 = 0x6003000;

    //LAB_80f2c10
    for(r5 = 0; r5 < 20; r5++) {
      //LAB_80f2c12
      for(int r0_0 = 0; r0_0 < 30; r0_0++) {
        MEMORY.ref(2, r1).setu(0x100 + r0_0);
        r1 += 0x2;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 += 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 += 0x2;
    }

    r3 = 0x3001ad0;

    //LAB_80f2c3c
    for(r5 = 0; r5 < 4; r5++) {
      MEMORY.ref(2, r3 + 0x2).setu(0);
      MEMORY.ref(2, r3).setu(0);
      r3 += 0x4;
    }

    DMA.channels[3].SAD.setu(0x3001ad0);
    DMA.channels[3].DAD.setu(GPU.BG0HOFS.getAddress());
    DMA.channels[3].CNT.setu(0x84000004);

    loadUiTextures();
    FUN_8004760();

    GPU.DISPCNT.setu(0x1540);

    if(r0 == 0) {
      fadeInBrightness(1);
      waitForFade();
      r5 = 0;

      //LAB_80f2ca4
      //LAB_80f2cb8
      r6 = -1;
      while((pressedButtons_3001c94.get() & 0x9) == 0) { // A/Start
        sleep(1);
        r5++;
        if(r5 >= 120) {
          r6 = 0;
          break;
        }
      }
    } else {
      //LAB_80f2cc2
      r5 = 0;

      //LAB_80f2cce
      //LAB_80f2ce2
      r6 = -1;
      while((pressedButtons_3001c94.get() & 0x9) == 0) {
        sleep(1);
        r5++;
        if(r5 >= 60) {
          r6 = 0;
          break;
        }
      }

      //LAB_80f2cea
      if(r6 != 0) {
        fadeInBrightness(8);
      } else {
        //LAB_80f2cf6
        fadeInBrightness(60);
      }

      //LAB_80f2cfc
      waitForFade();

      if(r6 != 0) {
        fadeOutBrightness(8);
      } else {
        r5 = 0;

        //LAB_80f2d10
        //LAB_80f2d24
        r6 = -1;
        while((pressedButtons_3001c94.get() & 0x9) == 0) {
          sleep(1);
          r5++;
          if(r5 >= 180) {
            r6 = 0;
            break;
          }
        }

        //LAB_80f2d2c
        if(r6 != 0) {
          //LAB_80f2d30
          fadeOutBrightness(8);
        } else {
          //LAB_80f2d38
          fadeOutBrightness(60);
        }
      }

      //LAB_80f2d3e
      waitForFade();
    }

    //LAB_80f2d42
    return r6;
  }

  /** Graphics for Camelot intro */
  @Method(0x80f2d54)
  public static int FUN_80f2d54() {
    int r3;
    int r5;
    int r6;

    _3001d18.set(1);
    clearTickCallbacks();
    fadeOutBrightness(1);
    FUN_8004760();
    sleep(1);
    GPU.BG2CNT.setu(0x685);
    GPU.DISPCNT.setu(0x1440);
    MEMORY.ref(2, 0x3001ada).setu(0);
    decompress(getPointerTableEntry(25), 0x2010000); // Camelot logo

    r6 = 0x2010000;
    DMA.channels[3].SAD.setu(r6);
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000070);

    r6 = r6 + 0x1c0;
    DMA.channels[3].SAD.setu(r6);
    DMA.channels[3].DAD.setu(0x6003000);
    DMA.channels[3].CNT.setu(0x84000200);

    r6 = r6 + 0x800;
    DMA.channels[3].SAD.setu(r6);
    DMA.channels[3].DAD.setu(0x6004000);
    DMA.channels[3].CNT.setu(0x84001000);

    r6 = r6 + 0x4000;
    r3 = 0x3001ad0;

    //LAB_80f2dfe
    for(r5 = 0; r5 < 4; r5++) {
      MEMORY.ref(2, r3 + 0x2).setu(0);
      MEMORY.ref(2, r3).setu(0);
      r3 += 0x4;
    }

    DMA.channels[3].SAD.setu(0x3001ad0);
    DMA.channels[3].DAD.setu(GPU.BG0HOFS.getAddress());
    DMA.channels[3].CNT.setu(0x84000004);

    loadUiTextures();
    FUN_8004760();
    fadeInAlpha(1);
    waitForFade();
    GPU.DISPCNT.setu(0x1540);
    DMA.channels[3].SAD.setu(r6 + (_3001e40.get() >>> 3 & 0x3) * 0x400);
    DMA.channels[3].DAD.setu(0x6004100);
    DMA.channels[3].CNT.setu(0x840000d0);

    //LAB_80f2e68
    r5 = 0;
    while((pressedButtons_3001c94.get() & 0x9) == 0) {
      sleep(1);
      r5++;
      if(r5 >= 120) {
        break;
      }

      DMA.channels[3].SAD.setu(r6 + (_3001e40.get() >>> 3 & 0x3) * 0x400);
      DMA.channels[3].DAD.setu(0x6004100);
      DMA.channels[3].CNT.setu(0x840000d0);
    }

    //LAB_80f2e98
    return 0;
  }

  @Method(0x80f2ebc)
  public static void FUN_80f2ebc(final int r0, final int r1, final int r2, final int r3) {
    if(r3 > 0) {
      //LAB_80f2ed8
      for(int i = 0; i < 0x600; i++) {
        MEMORY.ref(2, r2 + i * 0x2).setu((int)MEMORY.call(0x3000380, MEMORY.ref(2, r1 + i * 0x2).get() - MEMORY.ref(2, r0 + i * 0x2).get(), r3));
      }
    }

    //LAB_80f2efa
  }

  @Method(0x80f2f10)
  public static void FUN_80f2f10() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r5 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    r4 = r5 + 0x1c00;
    if(MEMORY.ref(1, r5 + 0x3001).get() != 0) {
      //LAB_80f2f2a
      MEMORY.ref(1, r5 + 0x3002).incr();

      if(MEMORY.ref(1, r5 + 0x3001).get() < MEMORY.ref(1, r5 + 0x3001).get()) {
        //LAB_80f2f4a
        for(r0 = 0; r0 < 0x600; r0++) {
          MEMORY.ref(2, r5 + 0x400 + r0 * 0x2).addu(MEMORY.ref(2, r4 + r0 * 0x2).getUnsigned());
        }
      } else {
        //LAB_80f2f6c
        DMA.channels[3].SAD.setu(r5 + 0x1000);
        DMA.channels[3].DAD.setu(r5 + 0x400);
        DMA.channels[3].CNT.setu(0x84000300);
        MEMORY.ref(1, r5 + 0x3001).setu(0);
      }

      //LAB_80f2f88
      r3 = (MEMORY.ref(1, r5 + 0x3000).getUnsigned() ^ 0x1) * 0x400;
      r3 = r5 + r3;
      r4 = r3 + 0x2800;
      r1 = r5 + 0x400;

      //LAB_80f2fc8
      for(r0 = 0; r0 < 0x200; r0++) {
        MEMORY.ref(2, r4).setu(MEMORY.ref(2, r1).getUnsigned() & 0x7c00 | MEMORY.ref(2, r1 + 0x2).get() >> 5 & 0x3e0 | MEMORY.ref(2, r1 + 0x4).get() >> 10 & 0x1f);
        r4 = r4 + 0x2;
        r1 = r1 + 0x6;
      }

      MEMORY.ref(1, r5 + 0x3000).xoru(0x1);
      r0 = r5 + MEMORY.ref(1, r5 + 0x3000).getUnsigned() * 0x400;

      final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
      INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

      r2 = vblankTransferQueue_2002090.count_00.get();
      if(r2 < 32) {
        vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(r0 + 0x2800);
        vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(0x5000000);
        vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0x84000080);
        vblankTransferQueue_2002090.count_00.incr();
      }

      //LAB_80f3032
      r2 = vblankTransferQueue_2002090.count_00.get();
      if(r2 < 32) {
        vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(r0 + 0x2a00);
        vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(0x5000200);
        vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0x84000080);
        vblankTransferQueue_2002090.count_00.incr();
      }

      //LAB_80f305e
      INTERRUPTS.INT_MASTER_ENABLE.setu(oldIme);
    }

    //LAB_80f3060
  }

  @Method(0x80f3078)
  public static void FUN_80f3078(int r0, final int r1, int r2, final int r3) {
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r9;
    int r10;

    r10 = r1;
    r8 = r2;
    r2 = r3;
    int sp24 = 0x200;
    if(r0 == 0x8000) {
      r0 = MEMORY.ref(2, r10).getUnsigned();
    }

    //LAB_80f30a0
    if(r2 == 1) {
      sp24 = 0x100;
      //LAB_80f30ac
    } else if(r2 == 2) {
      r8 = r8 + 0x600;
      sp24 = 0x100;
      r10 = r10 + 0x200;
    }

    //LAB_80f30c2
    if((r0 & 0xffff_ffffL) < 0x8000) {
      MEMORY.ref(2, r8).setu(r0 & 0x7c00);
      MEMORY.ref(2, r8 + 0x2).setu((r0 & 0x3e0) << 5);
      MEMORY.ref(2, r8 + 0x4).setu((r0 & 0x1f) << 10);
      r8 = r8 + 0x6;
      DMA.channels[3].SAD.setu(r8 - 0x6);
      DMA.channels[3].DAD.setu(r8);
      DMA.channels[3].CNT.setu(0x80000000 | (sp24 - 1) * 6 >>> 1);
    } else {
      //LAB_80f311a
      if((r0 & 0xffff_ffffL) >= 0x100000) {
        //LAB_80f3546
        if((r0 & 0x200000) != 0) {
          final int sp20 = r0 & 0x1f;
          final int sp1c = r0 >>> 5 & 0x1f;
          final int r11 = r0 >>> 10 & 0x1f;

          //LAB_80f3576
          for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
            r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
            r4 = divideS((r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 96);
            MEMORY.ref(2, r8 + r9 * 0x6).setu(FUN_80f38ac(r11 * r4));
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(FUN_80f38ac(sp1c * r4));
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(FUN_80f38ac(sp20 * r4));
          }
          //LAB_80f35e6
        } else if((r0 & 0x400000) != 0) {
          //LAB_80f35f2
          final int sp18 = r0 & 0x1f;
          final int sp14 = r0 >>> 5 & 0x1f;
          final int r11 = r0 >>> 10 & 0x1f;
          final int sp04 = sp18 + sp14;
          final int sp10 = sp18 << 16;
          final int sp0c = sp14 << 16;
          final int sp08 = r11 << 16;

          //LAB_80f3630
          for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
            r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
            r4 = divideS(((r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f)) * 16, sp04 + r11);
            r7 = FUN_80f3898((int)MEMORY.call(0x3000118, sp18 * r4 >>> 4 << 16, sp10 >> 4) >>> 16);
            r6 = FUN_80f3898((int)MEMORY.call(0x3000118, sp14 * r4 >>> 4 << 16, sp0c >> 4) >>> 16);
            r5 = FUN_80f3898((int)MEMORY.call(0x3000118, r11 * r4 >>> 4 << 16, sp08 >> 4) >>> 16);
            MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f39ee + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f39ee + r6 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f39ee + r7 * 0x2).getUnsigned());
          }
          //LAB_80f36f0
        } else if((r0 & 0x800000) != 0) {
          //LAB_80f371c
          for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
            r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
            MEMORY.ref(2, r8 + r9 * 0x6).setu(r4 & 0x7c00);
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu((r4 & 0x3e0) << 5);
            MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu((r4 & 0x1f) << 10);
          }
        } else {
          //LAB_80f3746
          if(r2 == 2) {
            r0 = r0 + 0x600;
          }

          //LAB_80f3750
          DMA.channels[3].SAD.setu(r0);
          DMA.channels[3].DAD.setu(r8);
          DMA.channels[3].CNT.setu(0x84000000 | sp24 * 5 >>> 1);
        }
      } else {
        //LAB_80f3124
        //LAB_80f312e
        switch(r0 - 0x10001) {
          case 0: // switch 80f3138
            //LAB_80f3154
            //LAB_80f3160
            //LAB_80f3164
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r4 = divideS((r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 7);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(r4);
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(r4);
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(r4);
            }
            break;

          case 1: // switch 80f3138
            //LAB_80f31a2
            //LAB_80f31ae
            //LAB_80f31b4
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r4 = divideS((r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f), 10);
              r7 = MathHelper.clamp(r4 * 4 + 5, 8, 28);
              r6 = MathHelper.clamp(r4 * 3 + 5, 8, 28);
              r5 = MathHelper.clamp(r4 * 3 + 5, 8, 28);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f3a2e + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f3a2e + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f3a2e + r7 * 0x2).getUnsigned());
            }
            break;

          case 2: // switch 80f3138
            //LAB_80f323e
            //LAB_80f324a
            //LAB_80f324e
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r6 = r4 >>> 5 & 0x1f;
              r5 = r4 >>> 10 & 0x1f;
              r7 = r4 & 0x1f;
              r7 = r7 - (r7 >>> 1);
              r6 = r6 - divideS(r6, 3);
              r7 = FUN_80f3898(r7 + 6);
              r6 = FUN_80f3898(r6 + 4);
              r5 = FUN_80f3898(r5 - 6);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f3a6e + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f3a2e + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f39ee + r7 * 0x2).getUnsigned());
            }
            break;

          case 3: // switch 80f3138
            //LAB_80f32bc
            //LAB_80f32c8
            //LAB_80f32cc
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r7 = FUN_80f3898(MathHelper.clamp(r4 & 0x1f, 10, 28));
              r6 = FUN_80f3898(MathHelper.clamp(r4 >>> 5 & 0x1f, 16, 24) + 2);
              r5 = FUN_80f3898(MathHelper.clamp(r4 >>> 10 & 0x1f, 16, 26) + 2);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f39ee + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f39ee + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f39ee + r7 * 0x2).getUnsigned());
            }
            break;

          case 4: // switch 80f3138
            //LAB_80f3356
            //LAB_80f3362
            //LAB_80f3366
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r6 = r4 >>> 5 & 0x1f;
              r5 = r4 >>> 10 & 0x1f;
              r7 = r4 & 0x1f;
              r0 = FUN_80f3898(divideS(r7 + r6 + r5, 3));
              r7 = FUN_80f3898(r7 / 2 + r0);
              r6 = FUN_80f3898(r6 / 2 + r0);
              r5 = FUN_80f3898(r5 / 2 + r0);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f3a6e + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f3a6e + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f3a6e + r7 * 0x2).getUnsigned());
            }
            break;

          case 5: // switch 80f3138
            //LAB_80f33d8
            //LAB_80f33e4
            //LAB_80f33e8
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r6 = r4 >>> 5 & 0x1f;
              r5 = r4 >>> 10 & 0x1f;
              r7 = FUN_80f3898((r4 & 0x1f) + r6 / 8 + r5 / 8);
              r6 = r6 - divideS(r6, 3);
              r5 = r5 - divideS(r5, 3);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f39ee + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f39ee + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f3a2e + r7 * 0x2).getUnsigned());
            }
            break;

          case 6: // switch 80f3138
            //LAB_80f346c
            //LAB_80f3478
            //LAB_80f347c
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              r7 = r4 & 0x1f;
              r6 = r4 >>> 5 & 0x1f;
              r5 = (r4 >>> 10) & 0x1f;
              r7 = r7 - (r7 >>> 1);
              r6 = r6 - divideS(r6, 3);
              r7 = FUN_80f3898(r7 + 6);
              r6 = FUN_80f3898(r6 + 4);
              r5 = FUN_80f3898(r5 - 6);
              MEMORY.ref(2, r8 + r9 * 0x6).setu(MEMORY.ref(2, 0x80f3a6e + r5 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu(MEMORY.ref(2, 0x80f3a2e + r6 * 0x2).getUnsigned());
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu(MEMORY.ref(2, 0x80f39ee + r7 * 0x2).getUnsigned());
            }
            break;

          default:
            //LAB_80f34f8
            //LAB_80f3504
            //LAB_80f351c
            for(r9 = 0; r9 < (sp24 & 0xffff_ffffL); r9++) {
              r4 = MEMORY.ref(2, r10 + r9 * 0x2).getUnsigned();
              MEMORY.ref(2, r8 + r9 * 0x6).setu(r4 & 0x7c00);
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x2).setu((r4 & 0x3e0) << 5);
              MEMORY.ref(2, r8 + r9 * 0x6 + 0x4).setu((r4 & 0x1f) << 10);
            }
            break;
        }
      }
    }

    //LAB_80f3766
  }

  /** Seems like this is only used during the title screen mountain/sun intro */
  @Method(0x80f377c)
  public static void FUN_80f377c() {
    final int r4 = mallocSlotBoard(32, 0x3004);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000c01);
    CPU.sp().value += 0x4;

    DMA.channels[3].SAD.setu(0x5000000);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x84000080);

    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(r4 + 0x200);
    DMA.channels[3].CNT.setu(0x84000080);

    FUN_80f3078(0x10000, r4, r4 + 0x1000, 0);
    setTickCallback(getRunnable(GoldenSun_80f.class, "FUN_80f2f10"), 0xc80);
  }

  @Method(0x80f3824)
  public static void FUN_80f3824(final int r0, final int r1) {
    final int r1_0 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    if(r1_0 != 0) {
      FUN_80f3078(r0, r1_0, r1_0 + 0x400, r1);
    }

    //LAB_80f383c
  }

  @Method(0x80f3858)
  public static void FUN_80f3858(final int r0) {
    final int r4 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    if(r4 != 0) {
      MEMORY.ref(1, r4 + 0x3001).setu(r0);
      MEMORY.ref(1, r4 + 0x3002).setu(0);
      FUN_80f2ebc(r4 + 0x400, r4 + 0x1000, r4 + 0x1c00, r0);
    }

    //LAB_80f388a
  }

  @Method(0x80f3898)
  public static int FUN_80f3898(final int r0) {
    return MathHelper.clamp(r0, 0, 0x1f);
  }

  @Method(0x80f38ac)
  public static int FUN_80f38ac(final int r0) {
    return Math.min(r0, 0x7c00);
  }

  @Method(0x80f4000)
  public static int FUN_80f4000(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80f6000)
  public static int FUN_80f6000(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80f9008)
  public static void FUN_80f9008() {
    FUN_80f9438();
  }

  /** {@link GoldenSun_80f#playSound} */
  @Method(0x80f9010)
  public static void playSound_(final int r0) {
    MEMORY.call(0x80f9080, r0);
  }

  @Method(0x80f9018)
  public static void FUN_80f9018() {
    FUN_80f91e8();
  }

  @Method(0x80f9048)
  public static int FUN_80f9048() {
    return (int)MEMORY.call(0x80f954c);
  }

  /** {@link GoldenSun_80f#FUN_80f9594} */
  @Method(0x80f9070)
  public static int FUN_80f9070() {
    return (int)MEMORY.call(0x80f9594);
  }

  @Method(0x80f9080)
  public static void playSound(final int r0) {
    int r2;
    int r3;

    final int r5 = r0 & 0xf000;
    final int r6 = r0 & 0xfff;
    if(r6 == 0x11) {
      if(MEMORY.ref(1, 0x2003014).getUnsigned() != 0) {
        return;
      }

      //LAB_80f909c
      FUN_80fa4bc(0x2004290, 0x7);
      MEMORY.ref(1, 0x2003014).incr();
      r2 = 0x200303c;
      r3 = 0x13;
    } else {
      //LAB_80f90b0
      if(r6 == 0x121) {
        MEMORY.ref(2, 0x2003026).setu(0);
        FUN_80fa4bc(0x2004360, 0x3);
        return;
      }

      //LAB_80f90c6
      if(r6 > 0x63) {
        //TODO
        final int r7 = 0x80fc684;
        r2 = MEMORY.ref(2, r7 + r6 * 0x8 + 0x4).getUnsigned();

        if(r2 == 7) {
          //LAB_80f90d8
          for(int i = 7; i > 3; i--) {
            if((_80fc624.get(i)._00.deref()._04.get() & 0xff) == 0) {
              r2 = i;
              break;
            }
          }
        }

        //LAB_80f90f2
        //LAB_80f90f6
        FUN_80faa58(_80fc624.get(r2)._00.deref(), MEMORY.ref(4, r7 + r6 * 0x8).get());
        MEMORY.ref(2, 0x2003020 + r2 * 0x2).setu(r6);
        return;
      }

      //LAB_80f9108
      if(r6 > 0x4f) {
        FUN_80fb2cc(0x2004290, 0xff, 0);
        MEMORY.ref(2, 0x2003034).setu(0);
        MEMORY.ref(2, 0x2003008).setu(0);
        FUN_80fa324(r6 & 0xffff);
        r2 = 0x2003000;
        r3 = 0xa;
      } else {
        //LAB_80f9164
        if(r6 == 0x12) {
          return;
        }

        if(r6 == MEMORY.ref(1, 0x200303c).getUnsigned()) {
          return;
        }

        MEMORY.ref(1, 0x200303c).setu(r6);

        final int r0_0;
        if(r6 == 0x46 || r6 == 0x4b || r6 == 0x43) {
          r0_0 = 3;
        } else {
          r0_0 = 2;
        }

        //LAB_80f9182
        FUN_80037d4(r0_0);
        FUN_80fa324(r6 & 0xffff);

        if((r5 & 0x1000) != 0) {
          r3 = 0;
        } else {
          //LAB_80f91ac
          r3 = 0x100;
        }

        //LAB_80f91b0
        MEMORY.ref(2, 0x2003008).setu(r3);
        MEMORY.ref(2, 0x2003034).setu(0x100);
        MEMORY.ref(2, 0x2003010).setu(0x4);
        r2 = 0x2003014;
        r3 = 0;
      }
    }

    //LAB_80f91c2
    MEMORY.ref(1, r2).setu(r3);

    //LAB_80f91e0
  }

  @Method(0x80f91e8)
  public static void FUN_80f91e8() {
    int r0;
    final int r1;
    int r2;
    int r3;
    int r4;

    r3 = MEMORY.ref(1, 0x2003000).getUnsigned();
    if(r3 != 0) {
      if(r3 == 1) {
        r3 = MEMORY.ref(1, 0x2004214).getUnsigned();
        if(r3 == 0) {
          MEMORY.ref(1, 0x2003000).setu(0);
          MEMORY.ref(2, 0x2003034).setu(0x100);
        }
      } else {
        //LAB_80f920a
        MEMORY.ref(1, 0x2003000).setu(r3 + 0xff);
      }
    }

    //LAB_80f920e
    r2 = MEMORY.ref(2, 0x2003034).get();
    r3 = MEMORY.ref(2, 0x2003008).get();
    r4 = MEMORY.ref(2, 0x2003008).getUnsigned();
    if(r2 != r3) {
      r0 = r2 - r3;
      if(r0 > 0) {
        r3 = r4 + MEMORY.ref(2, 0x2003010).getUnsigned();
      } else {
        //LAB_80f9248
        r3 = r4 - MEMORY.ref(2, 0x2003010).getUnsigned();
      }

      //LAB_80f924e
      MEMORY.ref(2, 0x2003008).setu(r3);
      r4 = MEMORY.ref(2, 0x2003034).getUnsigned();
      r3 = MEMORY.ref(2, 0x2003034).get() - MEMORY.ref(2, 0x2003008).get();
      r3 = r3 ^ r0;

      if(r3 < 0) {
        MEMORY.ref(2, 0x2003008).setu(r4);
      }

      //LAB_80f9268
      FUN_80fb2cc(0x2004290, 0xff, MEMORY.ref(2, 0x2003008).getUnsigned());
    }

    //LAB_80f9272
    r2 = MEMORY.ref(2, 0x2003030).get();
    r3 = MEMORY.ref(2, 0x2003038).get();
    r4 = MEMORY.ref(2, 0x2003038).getUnsigned();

    if(r2 != r3) {
      r0 = r2 - r3;
      if(r0 > 0) {
        r3 = r4 + MEMORY.ref(2, 0x200300c).getUnsigned();
      } else {
        //LAB_80f9292
        r3 = r4 - MEMORY.ref(2, 0x200300c).getUnsigned();
      }

      //LAB_80f9298
      MEMORY.ref(2, 0x2003038).setu(r3);
      r1 = MEMORY.ref(2, 0x2003030).getUnsigned();
      r3 = MEMORY.ref(2, 0x2003030).get() - MEMORY.ref(2, 0x2003038).get();
      r3 = r3 ^ r0;
      if(r3 < 0) {
        MEMORY.ref(2, 0x2003038).setu(r1);
      }

      //LAB_80f92b2
      FUN_80fb2a4(0x2004290, MEMORY.ref(2, 0x2003038).getUnsigned());
      FUN_80fb334(0x2004290, 0xff, (short)(0xf400 + MEMORY.ref(2, 0x2003038).get() * 0xc));
    }

    //LAB_80f92d6
    FUN_80f9c44();
  }

  @Method(0x80f9438)
  public static void FUN_80f9438() {
    FUN_80fa2a0();

    MEMORY.ref(1, 0x200303c).setu(0xff);
    MEMORY.ref(1, 0x2003000).setu(0);
    MEMORY.ref(2, 0x2003034).setu(0x100);
    MEMORY.ref(2, 0x2003008).setu(0x100);
    MEMORY.ref(2, 0x2003010).setu(0x4);
    MEMORY.ref(2, 0x2003030).setu(0x100);
    MEMORY.ref(2, 0x2003038).setu(0x100);
    MEMORY.ref(2, 0x200300c).setu(0x4);
    MEMORY.ref(1, 0x2003014).setu(0);
    MEMORY.ref(1, 0x2003040).setu(0);
    MEMORY.ref(1, 0x2003004).setu(0);

    //LAB_80f94b8
    for(int i = 0; i < 8; i++) {
      MEMORY.ref(2, 0x2003020 + i * 0x2).setu(0);
    }
  }

  @Method(0x80f954c)
  public static int FUN_80f954c() {
    return MEMORY.ref(1, 0x2003000).getUnsigned();
  }

  @Method(0x80f9594)
  public static int FUN_80f9594() {
    return MEMORY.ref(1, 0x200303c).getUnsigned();
  }

  @Method(0x80f95e0)
  public static int FUN_80f95e0(final int r0, final int r1) {
    return (int)MEMORY.call(0x80f95e4, r0, r1);
  }

  @Method(0x80f95e4)
  public static int FUN_80f95e4(final int r0, final int r1) {
    final long result80f95e4 = (r0 & 0xffff_ffffL) * (r1 & 0xffff_ffffL);
    final int r2 = (int)result80f95e4;
    final int r3 = (int)(result80f95e4 >>> 32);
    return r3;
  }

  @Method(0x80f9a18)
  public static void FUN_80f9a18(final int r0) {
    MEMORY.memfill(r0, 0x40, 0);
  }

  @Method(0x80f9a30)
  public static void FUN_80f9a30(final SoundStructFb0.Sub40 r0) {
    final SoundStruct50 r3 = r0._2c.derefNullable();

    if(r3 != null) {
      final SoundStructFb0.Sub40 r1 = r0._34.derefNullable();
      final SoundStructFb0.Sub40 r2 = r0._30.derefNullable();

      if(r2 != null) {
        r2._34.setNullable(r1);
      } else {
        //LAB_80f9a42
        r3._20.setNullable(r1);
      }

      //LAB_80f9a44
      if(r1 != null) {
        r1._30.setNullable(r2);
      }

      //LAB_80f9a4a
      r0._2c.clear();
    }

    //LAB_80f9a4e
  }

  @Method(0x80f9a50)
  public static void FUN_80f9a50(final SoundStruct r0_0, final SoundStruct50 r1_0) {
    SoundStructFb0.Sub40 r4 = r1_0._20.derefNullable();

    //LAB_80f9a5a
    while(r4 != null) {
      if((r4._00.get() & 0xc7) != 0) {
        r4._00.or(0x40);
      }

      //LAB_80f9a68
      FUN_80f9a30(r4);

      r4 = r4._34.derefNullable();
    }

    //LAB_80f9a74
    r1_0._00.set(0);
  }

  @Method(0x80f9a80)
  public static void FUN_80f9a80(int r0) {
    int r1;
    int r2;
    int r3;
    r1 = 0x24;
    r2 = 0x80fb7a0;

    //LAB_80f9a86
    do {
      r3 = MEMORY.ref(4, r2).get();

      // This if statement was actually a function call but also not really
      if(r2 >>> 25 == 0) {
        if(r2 < 0x80fb7a0 || r2 >>> 14 != 0) {
          //LAB_80f9aaa
          r3 = 0;
        }
      }

      MEMORY.ref(4, r0).setu(r3);
      r0 += 0x4;
      r2 += 0x4;
      r1--;
    } while(r1 != 0);
  }

  @Method(0x80f9a9a)
  public static void FUN_80f9a9a(final SoundStruct r0, final SoundStruct50 r1, final int r2, final IntRef r3ref) {
    if(r2 >>> 25 == 0) {
      if(r2 < 0x80fb7a0 || r2 >>> 14 != 0) {
        //LAB_80f9aaa
        r3ref.set(0);
      }
    }

    //LAB_80f9aac
  }

  @Method(0x80f9ab4)
  public static void FUN_80f9ab4(final SoundStruct r0, final SoundStruct50 r1, final IntRef r3) {
    final int r2;
    r2 = r1._40.get();
    r1._40.set(r2 + 1);
    r3.set(MEMORY.ref(1, r2).getUnsigned());
    FUN_80f9a9a(r0, r1, r2, r3);

    //LAB_80f9aac
  }

  @Method(0x80f9ac0)
  public static void FUN_80f9ac0(final SoundStruct r0, final SoundStruct50 r1) {
    final int r2 = r1._40.get();
    r1._40.set(MEMORY.ref(1, r2 + 0x3).getUnsigned() << 24 | MEMORY.ref(1, r2 + 0x2).getUnsigned() << 16 | MEMORY.ref(1, r2 + 0x1).getUnsigned() << 8 | MEMORY.ref(1, r2).getUnsigned());
  }

  @Method(0x80f9ae0)
  public static void FUN_80f9ae0(final SoundStruct r0, final SoundStruct50 r1) {
    int r2;
    int r3;
    r2 = r1._02.get();
    CPU.cmpT(r2, 0x3);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r1._44.get(r2).set(r1._40.get() + 0x4);
      r1._02.incr();
      r2 = r1._40.get();
      final int r0_0 = MEMORY.ref(1, r2 + 0x3).getUnsigned() << 24 | MEMORY.ref(1, r2 + 0x2).getUnsigned() << 16 | MEMORY.ref(1, r2 + 0x1).getUnsigned() << 8;

      r3 = MEMORY.ref(1, r2).getUnsigned();
      if(r2 >>> 25 == 0 && (r2 < 0x80fb7a0 || r2 >>> 14 != 0)) {
        //LAB_80f9aaa
        r3 = 0;
      }

      //LAB_80f9aac
      r1._40.set(r0_0 | r3);
      return;
    }

    //LAB_80f9af8
    FUN_80f9a50(r0, r1);
  }

  @Method(0x80f9afc)
  public static void FUN_80f9afc(final SoundStruct r0, final SoundStruct50 r1) {
    int r2 = r1._02.get();
    if(r2 != 0) {
      r2 = r2 - 1;
      r1._02.set(r2);
      r1._40.set(r1._44.get(r2).get());
    }

    //LAB_80f9b0e
  }

  @Method(0x80f9b4c)
  public static void FUN_80f9b4c(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    int r3 = CPU.lslT(r3ref.get(), 1);
    r0._1c.set(r3);
    final int r2 = r0._1e.get();
    r3 = CPU.mulT(r3, r2);
    r3 = CPU.lsrT(r3, 8);
    r0._20.set(r3);
  }

  @Method(0x80f9b60)
  public static void FUN_80f9b60(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._0a.set(r3ref.get());
    r1._00.or(0xc);
  }

  @Method(0x80f9b74)
  public static void FUN_80f9b74(final SoundStruct r0, final SoundStruct50 r1) {
    int r2;
    int r3;
    r2 = r1._40.get();
    r3 = MEMORY.ref(1, r2).getUnsigned();
    r2 = CPU.addT(r2, 0x1);
    r1._40.set(r2);
    r2 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r2, r3);
    r2 = CPU.lslT(r2, 2);
    r3 = r0._30.get();
    r2 = CPU.addT(r2, r3);
    final IntRef r3ref = new IntRef().set(MEMORY.ref(4, r2).get());
    FUN_80f9a9a(r0, r1, r2, r3ref);
    MEMORY.ref(4, r1._24.getAddress()).setu(r3ref.get()); //TODO
    r3ref.set(MEMORY.ref(4, r2 + 0x4).get());
    FUN_80f9a9a(r0, r1, r2, r3ref);
    r1._28.set(r3ref.get());
    r3ref.set(MEMORY.ref(4, r2 + 0x8).get());
    FUN_80f9a9a(r0, r1, r2, r3ref);
    r1._2c.set(r3ref.get());
  }

  @Method(0x80f9ba4)
  public static void FUN_80f9ba4(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._12.set(r3ref.get());
    r1._00.or(0x3);
  }

  @Method(0x80f9bb8)
  public static void FUN_80f9bb8(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._14.set(r3ref.get() - 0x40);
    r1._00.or(0x3);
  }

  @Method(0x80f9bcc)
  public static void FUN_80f9bcc(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._0e.set(r3ref.get() - 0x40);
    r1._00.or(0xc);
  }

  @Method(0x80f9be0)
  public static void FUN_80f9be0(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._0f.set(r3ref.get());
    r1._00.or(0xc);
  }

  @Method(0x80f9bf4)
  public static void FUN_80f9bf4(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._1b.set(r3ref.get());
  }

  @Method(0x80f9c00)
  public static void FUN_80f9c00(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    final int r3 = r3ref.get();

    if(r1._18.get() != r3) {
      r1._18.set(r3);
      r1._00.or(0xf);
    }
  }

  @Method(0x80f9c18)
  public static void FUN_80f9c18(final SoundStruct r0, final SoundStruct50 r1) {
    final IntRef r3ref = new IntRef();
    FUN_80f9ab4(r0, r1, r3ref);
    r1._0c.set(r3ref.get() - 0x40);
    r1._00.or(0xc);
  }

  @Method(0x80f9c44)
  public static void FUN_80f9c44() {
    int r1;

    final int r0 = MEMORY.ref(4, 0x3007ff0).get();
    final int r3 = MEMORY.ref(4, r0).get() - 0x68736d53;
    CPU.cmpT(r3, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r1 = MEMORY.ref(1, r0 + 0x4).getUnsigned();
      r1 = CPU.subT(r1, 0x1);
      MEMORY.ref(1, r0 + 0x4).setu(r1);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        MEMORY.ref(1, r0 + 0x4).setu(MEMORY.ref(1, r0 + 0xb).getUnsigned());
        r1 = DMA.channels[1].CNT.get();
        r1 = CPU.lslT(r1, 7);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          DMA.channels[1].CNT.setu(0x84400004);
        }

        //LAB_80f9c6a
        r1 = DMA.channels[2].SAD.get();
        r1 = CPU.lslT(r1, 7);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          DMA.channels[2].SAD.setu(0x80f9c8c);
        }

        //LAB_80f9c74
        DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
        DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);
        DMA.channels[1].CNT.offset(2, 0x2).setu(0xb600);
        DMA.channels[2].CNT.offset(2, 0x2).setu(0xb600);
      }
    }

    //LAB_80f9c84
  }

  @Method(0x80f9c90)
  public static void FUN_80f9c90(final SoundStruct r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r6;

    r3 = r0._34.get();
    if(r3 != 0x68736d53) { // !=
      return;
    }

    //LAB_80f9c9a
    r0._34.incr();

    if(!r0._38.isNull()) {
      r0._38.deref().run(r0._3c.deref());
    }

    //LAB_80f9cac
    jmp_80f9ed8:
    if(r0._04.get() >= 0) {
      //LAB_80f9cc4
      final SoundStructFb0 r8 = _3007ff0.deref();
      FUN_80fab7c(r0);

      if(r0._04.get() >= 0) {
        //LAB_80f9cd8
        r0._22.add(r0._20.get());

        //LAB_80f9ce0
        while(r0._22.get() >= 0x96) {
          r3 = 1;
          r4 = 0;

          //LAB_80f9ce8
          for(int i = 0; i < r0._08.get(); i++) {
            final SoundStruct50 r5 = r0._2c.deref().get(i);

            if((r5._00.get() & 0x80) != 0) {
              //LAB_80f9cf2
              final int r11 = r4 | r3;

              SoundStructFb0.Sub40 r4_0 = r5._20.derefNullable();

              //LAB_80f9cfe
              while(r4_0 != null) {
                if((r4_0._00.get() & 0xc7) != 0) {
                  if(r4_0._10.get() != 0) {
                    r4_0._10.decr();

                    if(r4_0._10.get() == 0) {
                      r4_0._00.or(0x40);
                    }
                  }
                } else {
                  //LAB_80f9d1a
                  FUN_80fa678(r4_0);
                }

                //LAB_80f9d20
                r4_0 = r4_0._34.derefNullable();
              }

              //LAB_80f9d26
              if((r5._00.get() & 0x40) != 0) {
                FUN_80fa68c(r5.getAddress());
                r5._00.set(0x80);
                r5._0f.set(0x2);
                r5._13.set(0x40);
                r5._19.set(0x16);
                r5._24.set(0x1);
              }

              //LAB_80f9da4
              jmp_80f9e00:
              {
                //LAB_80f9d4c
                while(r5._01.get() == 0) {
                  r1 = MEMORY.ref(1, r5._40.get()).getUnsigned();

                  if(r1 < 0x80) {
                    r1 = r5._07.get();
                  } else {
                    //LAB_80f9d58
                    r5._40.incr();

                    if(r1 >= 0xbd) {
                      r5._07.set(r1);
                    }
                  }

                  //LAB_80f9d62
                  if(r1 >= 0xcf) {
                    r8._38.deref().run(r1 - 0xcf, r0, r5);
                  } else {
                    //LAB_80f9d78
                    if(r1 > 0xb0) {
                      final int r0_0 = r1 - 0xb1;
                      r0._0a.set(r0_0);
                      r8._34.deref().get(r0_0).deref().run(r0, r5);

                      if(r5._00.get() == 0) {
                        break jmp_80f9e00;
                      }
                    } else {
                      //LAB_80f9d9a
                      r5._01.set(MEMORY.ref(1, 0x80fba14 + (r1 - 0x80)).getUnsigned());
                    }
                  }
                }

                r5._01.decr();

                r1 = r5._19.get();
                if(r1 != 0) {
                  if(r5._17.get() != 0) {
                    if(r5._1c.get() != 0) {
                      r5._1c.decr();
                    } else {
                      //LAB_80f9dc6
                      r5._1a.add(r1);
                      if(r5._1a.get() < 0x40) {
                        r2 = r5._1a.get();
                      } else {
                        //LAB_80f9dda
                        r2 = 0x80 - r5._1a.getUnsigned();
                      }

                      //LAB_80f9dde
                      r2 = r5._17.get() * r2 >> 6;
                      if((byte)(r5._16.get() ^ r2) != 0) {
                        r5._16.set(r2);

                        if(r5._18.get() == 0) {
                          r1 = 0xc;
                        } else {
                          //LAB_80f9dfa
                          r1 = 0x3;
                        }

                        //LAB_80f9dfc
                        r5._00.or(r1);
                      }
                    }
                  }
                }
              }

              //LAB_80f9e00
              r4 = r11;
            }

            //LAB_80f9e04
            r3 <<= 1;
          }

          //LAB_80f9e10
          r0._0c.incr();

          if(r4 == 0) {
            r0._04.set(0x80000000);
            break jmp_80f9ed8;
          }

          //LAB_80f9e22
          r0._04.set(r4);
          r0._22.sub(150);
        }

        //LAB_80f9e30
        //LAB_80f9e34
        for(int i = 0; i < r0._08.get(); i++) {
          final SoundStruct50 r5 = r0._2c.deref().get(i);

          if((r5._00.get() & 0x80) != 0 && (r5._00.get() & 0xf) != 0) {
            FUN_80fac44(0, r5);

            SoundStructFb0.Sub40 r4_0 = r5._20.derefNullable();

            //LAB_80f9e52
            while(r4_0 != null) {
              if((r4_0._00.get() & 0xc7) == 0) {
                FUN_80fa678(r4_0);
              } else {
                //LAB_80f9e62
                r6 = r4_0._01.get() & 0x7;
                if((r5._00.get() & 0x3) != 0) {
                  FUN_80f9f3c(0, 0, 0, 0, r4_0, r5);

                  if(r6 != 0) {
                    r4_0._1d.or(0x1);
                  }
                }

                //LAB_80f9e80
                if((r5._00.get() & 0xc) != 0) {
                  int r2_0 = r4_0._08.get() + r5._08.get();
                  if(r2_0 < 0) {
                    r2_0 = 0;
                  }

                  //LAB_80f9e94
                  if(r6 != 0) {
                    r4_0._20.set(r8._30.deref().run(r6, r2_0, r5._09.get()));
                    r4_0._1d.or(0x2);
                  } else {
                    //LAB_80f9eb2
                    r4_0._20.set(FUN_80fa1fc(r4_0._24.get(), r2_0, r5._09.get()));
                  }
                }
              }

              //LAB_80f9ebe
              r4_0 = r4_0._34.derefNullable();
            }

            //LAB_80f9ec4
            r5._00.and(0xf0);
          }

          //LAB_80f9ece
        }
      }
    }

    //LAB_80f9ed8
    r0._34.set(0x68736d53);
  }

  @Method(0x80f9ee8)
  public static int FUN_80f9ee8(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x80f9ef8)
  public static void FUN_80f9ef8(final SoundStruct r0unused, final SoundStruct50 r1) {
    final int r1_0 = r1._00.get();
    if((r1_0 & 0x80) != 0) {
      SoundStructFb0.Sub40 r4 = r1._20.derefNullable();

      //LAB_80f9f0c
      while(r4 != null) {
        if(r4._00.get() != 0) {
          final int r0 = r4._01.get() & 0x7;
          if(r0 != 0) {
            _3007ff0.deref()._2c.deref().run(r0);
          }

          //LAB_80f9f24
          r4._00.set(0);
        }

        //LAB_80f9f26
        r4._2c.clear();
        r4 = r4._34.derefNullable();
      }

      //LAB_80f9f2e
      r1._20.setNullable(r4);
    }

    //LAB_80f9f30
  }

  @Method(0x80f9f3c)
  public static void FUN_80f9f3c(int r0, int r1, int r2, int r3, final SoundStructFb0.Sub40 r4, final SoundStruct50 r5) {
    r1 = r4._12.get();
    r2 = r4._14.get();
    r3 = (r2 + 0x80) * r1;
    r0 = r5._10.get() * r3 >> 14;
    CPU.cmpT(r0, 0xff);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = 0xff;
    }

    //LAB_80f9f54
    r4._02.set(r0);

    r3 = (0x7f - r2) * r1;
    r0 = r5._11.get() * r3 >> 14;
    CPU.cmpT(r0, 0xff);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = 0xff;
    }

    //LAB_80f9f68
    r4._03.set(r0);
  }

  @Method(0x80f9f6c)
  public static void FUN_80f9f6c(int r0, final SoundStruct r1, final SoundStruct50 r2) {
    int r3;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);

    CPU.sp().value -= 0x18;

    r2._04.set(MEMORY.ref(1, 0x80fba14 + r0).getUnsigned());

    r3 = r2._40.get();
    if(MEMORY.ref(1, r3).getUnsigned() < 0x80) {
      r2._05.set(MEMORY.ref(1, r3).getUnsigned());
      r3++;
      if(MEMORY.ref(1, r3).getUnsigned() < 0x80) {
        r2._06.set(MEMORY.ref(1, r3).getUnsigned());
        r3++;
        if(MEMORY.ref(1, r3).getUnsigned() < 0x80) {
          r2._04.add(MEMORY.ref(1, r3).getUnsigned());
          r3++;
        }
      }

      //LAB_80f9fb0
      r2._40.set(r3);
    }

    //LAB_80f9fb2
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    final int r2_0 = r2._24.get();
    r3 = r2._05.get();
    if((r2_0 & 0xc0) == 0) {
      //LAB_80fa004
      CPU.r9().value = r2._24.getAddress();
    } else {
      if((r2_0 & 0x40) != 0) {
        r0 = MEMORY.ref(4, r2.getAddress() + 0x2c).deref(1).offset(r3).getUnsigned();
      } else {
        //LAB_80f9fd2
        r0 = r3;
      }

      //LAB_80f9fd4
      CPU.r9().value = r2._28.get() + r0 * 0xc;
      r6 = CPU.r9().value;

      if((MEMORY.ref(1, r6).getUnsigned() & 0xc0) != 0) {
        CPU.sp().value += 0x18;
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return;
      }

      //LAB_80f9fec
      if((r2_0 & 0x80) != 0) {
        if((MEMORY.ref(1, r6 + 0x3).getUnsigned() & 0x80) != 0) {
          MEMORY.ref(4, CPU.sp().value + 0x14).setu((MEMORY.ref(1, r6 + 0x3).getUnsigned() - 0xc0) * 2);
        }

        //LAB_80fa000
        r3 = MEMORY.ref(1, r6 + 0x1).getUnsigned();
      }
    }

    //LAB_80fa008
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    r0 = r2._1d.get() + r1._09.get();
    if(r0 > 0xff) {
      r0 = 0xff;
    }

    //LAB_80fa018
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
    r6 = MEMORY.ref(1, CPU.r9().value).getUnsigned() & 0x7;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6);

    SoundStructFb0.Sub40 r4;
    if(r6 == 0) {
      //LAB_80fa058
      r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      SoundStruct50 r7 = r2;
      int r2_1 = 0;
      SoundStructFb0.Sub40 r8 = null;

      //LAB_80fa066
      for(int i = 0; i < _3007ff0.deref()._06.get(); i++) {
        r4 = _3007ff0.deref()._50.get(i);
        final int r1_0 = r4._00.get();
        if((r1_0 & 0xc7) == 0) {
          break;
        }

        //TODO not sure if I got this if statement right
        if((r1_0 & 0x40) != 0 && r2_1 == 0) {
          r2_1++;
          r6 = r4._13.get();
          r7 = r4._2c.deref();
          r8 = r4;
          //LAB_80fa080
        } else if((r1_0 & 0x40) == 0 && r2_1 == 0 || (r1_0 & 0x40) != 0 && r2_1 != 0) {
          //LAB_80fa084
          r0 = r4._13.get();
          r0 = CPU.cmpT(r0, r6);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r6 = CPU.addT(r0, 0x0);
            r7 = r4._2c.deref();
            r8 = r4;
            //LAB_80fa090
          } else if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            if(r4._2c.deref().getAddress() > r7.getAddress()) {
              r7 = r4._2c.deref();
              r8 = r4;
              //LAB_80fa09c
            } else if(r4._2c.deref().getAddress() == r7.getAddress()) {
              //LAB_80fa09e
              r8 = r4;
            }
          }
        }

        //LAB_80fa0a0
      }

      r4 = r8;
      if(r4 == null) {
        CPU.sp().value += 0x18;
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return;
      }
    } else {
      if(_3007ff0.deref()._1c.isNull()) {
        CPU.sp().value += 0x18;
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return;
      }

      //LAB_80fa030
      r4 = _3007ff0.deref()._1c.deref().get(r6 - 1);
      if((r4._00.get() & 0xc7) != 0 && (r4._00.get() & 0x40) == 0) {
        final int r1_0 = r4._13.get();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        if(r1_0 >= (r0 & 0xffff_ffffL)) {
          if(r1_0 != 0) {
            CPU.sp().value += 0x18;
            CPU.r9().value = CPU.pop();
            CPU.r10().value = CPU.pop();
            CPU.r11().value = CPU.pop();
            return;
          }

          //LAB_80fa050
          if(r4._2c.deref().getAddress() < r2.getAddress()) {
            CPU.sp().value += 0x18;
            CPU.r9().value = CPU.pop();
            CPU.r10().value = CPU.pop();
            CPU.r11().value = CPU.pop();
            return;
          }
        }
      }
    }

    //LAB_80fa0ac
    FUN_80fa678(r4);

    r4._30.clear();
    final SoundStructFb0.Sub40 r3ptr = r2._20.derefNullable();
    r4._34.setNullable(r3ptr);
    if(r3ptr != null) {
      r3ptr._30.setNullable(r4);
    }

    //LAB_80fa0c0
    r2._20.set(r4);
    r4._2c.set(r2);
    r0 = r2._1b.get();
    r2._1c.set(r0);
    if(r0 != 0) {
      FUN_80fa1ac(0, r2);
    }

    //LAB_80fa0d2
    FUN_80fac44(0, r2);
    r4._10.set(r2._04.get());
    r4._11.set(r2._05.get());
    r4._12.set(r2._06.get());
    r4._13.set(r2._07.get());
    r4._13.set(MEMORY.ref(4, CPU.sp().value + 0x10).get());
    r4._08.set(MEMORY.ref(4, CPU.sp().value + 0x8).get());
    r4._14.set(MEMORY.ref(4, CPU.sp().value + 0x14).get());
    r6 = CPU.r9().value;
    r4._01.set(MEMORY.ref(1, r6).getUnsigned());
    final int r7_0 = MEMORY.ref(4, r6 + 0x4).get();
    r4._24.set(r7_0);
    r4._04.set(MEMORY.ref(4, r6 + 0x8).get());
    r4._0c.set(r2._1e.get());
    FUN_80f9f3c(0, 0, 0, 0, r4, r2);

    int r3_0 = r4._08.get() + r2._08.get();
    if(r3_0 < 0) {
      r3_0 = 0;
    }

    //LAB_80fa10c
    if(MEMORY.ref(4, CPU.sp().value + 0xc).get() != 0) {
      r6 = CPU.r9().value;
      r4._1e.set(MEMORY.ref(1, r6 + 0x2).getUnsigned());

      int r1_0 = MEMORY.ref(1, r6 + 0x3).getUnsigned();
      if((r1_0 & 0x80) != 0 || (r1_0 & 0x70) == 0) {
        //LAB_80fa126
        r1_0 = 8;
      }

      //LAB_80fa128
      r4._1f.set(r1_0);

      r0 = _3007ff0.deref()._30.deref().run(MEMORY.ref(4, CPU.sp().value + 0xc).get(), r3_0, r2._09.get());
    } else {
      //LAB_80fa13a
      r0 = FUN_80fa1fc(r7_0, r3_0, r2._09.get());
    }

    //LAB_80fa144
    r4._20.set(r0);
    r4._00.set(0x80);
    r2._00.and(0xf0);

    //LAB_80fa152
    CPU.sp().value += 0x18;
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80fa16c)
  public static void FUN_80fa16c(final SoundStruct r0, final SoundStruct50 r1) {
    int r3 = MEMORY.ref(1, r1._40.get()).getUnsigned();
    if(r3 < 0x80) {
      r1._05.set(r3);
      r1._40.incr();
    } else {
      //LAB_80fa17e
      r3 = r1._05.get();
    }

    //LAB_80fa180
    SoundStructFb0.Sub40 r1_0 = r1._20.derefNullable();

    //LAB_80fa18a
    while(r1_0 != null) {
      if((r1_0._00.get() & 0x83) != 0 && (r1_0._00.get() & 0x40) == 0 && r1_0._11.get() == r3) {
        r1_0._00.or(0x40);
        break;
      }

      //LAB_80fa1a2
      r1_0 = r1_0._34.derefNullable();
    }

    //LAB_80fa1a8
  }

  @Method(0x80fa1ac)
  public static void FUN_80fa1ac(final int r0unused, final SoundStruct50 r1) {
    r1._16.set(0);
    r1._1a.set(0);

    final int r2;
    if(r1._18.get() == 0) {
      r2 = 0xc;
    } else {
      //LAB_80fa1bc
      r2 = 0x3;
    }

    //LAB_80fa1be
    r1._00.or(r2);
  }

  @Method(0x80fa1d4)
  public static void FUN_80fa1d4(final SoundStruct r0, final SoundStruct50 r1) {
    final int r3 = MEMORY.ref(1, r1._40.get()).getUnsigned();
    r1._19.set(r3);
    r1._40.incr();

    if(r3 == 0) {
      FUN_80fa1ac(0, r1);
    }

    //LAB_80fa1e4
  }

  @Method(0x80fa1e8)
  public static void FUN_80fa1e8(final SoundStruct r0, final SoundStruct50 r1) {
    final int r3 = MEMORY.ref(1, r1._40.get()).getUnsigned();
    r1._17.set(r3);
    r1._40.incr();

    if(r3 == 0) {
      FUN_80fa1ac(0, r1);
    }

    //LAB_80fa1f8
  }

  @Method(0x80fa1fc)
  public static int FUN_80fa1fc(int r0, int r1, int r2) {
    final int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.r12().value = r0;
    r1 = CPU.lslT(r1, 24);
    r6 = CPU.lsrT(r1, 24);
    r7 = CPU.lslT(r2, 24);
    CPU.cmpT(r6, 0xb2);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r6 = CPU.movT(0xb2);
      r7 = CPU.movT(0xff);
      r7 = CPU.lslT(r7, 24);
    }

    //LAB_80fa210
    r3 = MEMORY.ref(4, 0x80fa258).get();
    r0 = CPU.addT(r6, r3);
    r5 = MEMORY.ref(1, r0).getUnsigned();
    r4 = MEMORY.ref(4, 0x80fa25c).get();
    r2 = CPU.movT(0xf);
    r0 = CPU.addT(r5, 0x0);
    r0 = CPU.andT(r0, r2);
    r0 = CPU.lslT(r0, 2);
    r0 = CPU.addT(r0, r4);
    r1 = CPU.lsrT(r5, 4);
    r5 = MEMORY.ref(4, r0).get();
    r5 = CPU.lsrT(r5, r1);
    r0 = CPU.addT(r6, 0x1);
    r0 = CPU.addT(r0, r3);
    r1 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r1, 0x0);
    r0 = CPU.andT(r0, r2);
    r0 = CPU.lslT(r0, 2);
    r0 = CPU.addT(r0, r4);
    r1 = CPU.lsrT(r1, 4);
    r0 = MEMORY.ref(4, r0).get();
    r0 = CPU.lsrT(r0, r1);
    r1 = CPU.r12().value;
    r4 = MEMORY.ref(4, r1 + 0x4).get();
    r0 = CPU.subT(r0, r5);
    r1 = CPU.addT(r7, 0x0);
    r0 = FUN_80f95e0(r0, r1);
    r1 = CPU.addT(r0, 0x0);
    r1 = CPU.addT(r5, r1);
    r0 = CPU.addT(r4, 0x0);
    r0 = FUN_80f95e0(r0, r1);

    return r0;
  }

  @Method(0x80fa280)
  public static void FUN_80fa280(final int r0, final int r1) {
    if(MEMORY.ref(4, r0 + 0x34).get() == 0x68736d53) {
      MEMORY.ref(2, r0 + 0x26).setu(r1 & 0xffff);
      MEMORY.ref(2, r0 + 0x24).setu(r1 & 0xffff);
      MEMORY.ref(2, r0 + 0x28).setu(0x100);
    }

    //LAB_80fa298
  }

  @Method(0x80fa2a0)
  public static void FUN_80fa2a0() {
    CpuSet(MEMORY.ref(4, 0x80fa2f4).get() & ~0x1, 0x3007000, 0x4000100);
    FUN_80fa6a0(_2003050);
    FUN_80fa55c(0x2004090);
    FUN_80fa83c(0x97f800);

    //LAB_80fa2d2
    for(int i = 0; i < 8; i++) {
      final SoundStruct0c r5 = _80fc624.get(i);
      final SoundStruct r4 = r5._00.deref();
      FUN_80fa9e0(r4, r5._04.deref(), r5._08.get());
      r4._0b.set(r5._0a.get());
      r4._18.set(0x2004350);
    }

    //LAB_80fa2ee
  }

  @Method(0x80fa324)
  public static void FUN_80fa324(final int r0) {
    final int r0_0 = 0x80fc684 + r0 * 0x8;
    final int r3 = MEMORY.ref(2, r0_0 + 0x4).getUnsigned();
    FUN_80faa58(_80fc624.get(r3)._00.deref(), MEMORY.ref(4, r0_0).get());
  }

  @Method(0x80fa4bc)
  public static void FUN_80fa4bc(final int r0, final int r1) {
    FUN_80fa280(r0, r1 & 0xffff);
  }

  @Method(0x80fa55c)
  public static void FUN_80fa55c(int r0) {
    int r1;
    int r2;
    final int r3;
    final int r4;
    final int r5;
    int r6;

    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    r1 = MEMORY.ref(4, 0x80fa624).get();
    r0 = CPU.movT(0x8f);
    MEMORY.ref(2, r1).setu(r0);
    r3 = MEMORY.ref(4, 0x80fa628).get();
    r2 = CPU.movT(0x0);
    MEMORY.ref(2, r3).setu(r2); // SOUNDCNT_L
    r0 = MEMORY.ref(4, 0x80fa62c).get();
    r1 = CPU.movT(0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_H
    r0 = CPU.addT(r0, 0x6);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_L
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_L
    r0 = CPU.subT(r0, 0x14);
    r1 = CPU.movT(0x80);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_X
    r0 = CPU.addT(r0, 0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_H
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_H
    r0 = CPU.subT(r0, 0xd);
    MEMORY.ref(1, r0).setu(r2); // SOUND3CNT_L
    r0 = CPU.movT(0x77);
    MEMORY.ref(1, r3).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa630).get();
    r4 = MEMORY.ref(4, r0).get();
    r6 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, 0x80fa634).get();
    r6 = CPU.cmpT(r6, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r6, 0x1);
      MEMORY.ref(4, r4).setu(r0);
      r1 = MEMORY.ref(4, 0x80fa638).get();
      r0 = MEMORY.ref(4, 0x80fa63c).get();
      MEMORY.ref(4, r1 + 0x20).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa640).get();
      MEMORY.ref(4, r1 + 0x44).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa644).get();
      MEMORY.ref(4, r1 + 0x4c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa648).get();
      MEMORY.ref(4, r1 + 0x70).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa64c).get();
      MEMORY.ref(4, r1 + 0x74).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa650).get();
      MEMORY.ref(4, r1 + 0x78).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa654).get();
      MEMORY.ref(4, r1 + 0x7c).setu(r0);
      r2 = CPU.addT(r1, 0x0);
      r2 = CPU.addT(r2, 0x80);
      r0 = MEMORY.ref(4, 0x80fa658).get();
      MEMORY.ref(4, r2).setu(r0);
      r1 = CPU.addT(r1, 0x84);
      r0 = MEMORY.ref(4, 0x80fa65c).get();
      MEMORY.ref(4, r1).setu(r0);
      MEMORY.ref(4, r4 + 0x1c).setu(r5);
      r0 = MEMORY.ref(4, 0x80fa660).get();
      MEMORY.ref(4, r4 + 0x28).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa664).get();
      MEMORY.ref(4, r4 + 0x2c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa668).get();
      MEMORY.ref(4, r4 + 0x30).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa66c).get();
      r1 = CPU.movT(0x0);
      MEMORY.ref(1, r4 + 0xc).setu(r0);
      MEMORY.ref(4, CPU.sp().value).setu(r1);
      r2 = MEMORY.ref(4, 0x80fa670).get();
      r0 = CPU.sp().value;
      r1 = CPU.addT(r5, 0x0);
      CpuSet(r0, r1, r2);
      r0 = CPU.movT(0x1);
      MEMORY.ref(1, r5 + 0x1).setu(r0);
      r0 = CPU.movT(0x11);
      MEMORY.ref(1, r5 + 0x1c).setu(r0);
      r1 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r1, 0x41);
      r0 = CPU.movT(0x2);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0x22);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x25);
      r0 = CPU.movT(0x3);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0x44);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x24);
      r0 = CPU.movT(0x4);
      MEMORY.ref(1, r1 + 0x1).setu(r0);
      r0 = CPU.movT(0x88);
      MEMORY.ref(1, r1 + 0x1c).setu(r0);
      MEMORY.ref(4, r4).setu(r6);
    }

    //LAB_80fa61c
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa678)
  public static void FUN_80fa678(final SoundStructFb0.Sub40 r0) {
    MEMORY.ref(4, 0x2004088).deref(1).call(r0);
  }

  @Method(0x80fa68c)
  public static void FUN_80fa68c(final int r0) {
    MEMORY.ref(4, 0x200408c).deref(1).call(r0);
  }

  @Method(0x80fa6a0)
  public static void FUN_80fa6a0(final SoundStructFb0 r0) {
    r0._00.set(0);

    if((DMA.channels[1].CNT.get() & 0x2000000) != 0) {
      DMA.channels[1].CNT.setu(0x84400004);
    }

    //LAB_80fa6bc
    if((DMA.channels[2].CNT.get() & 0x2000000) != 0) {
      DMA.channels[2].CNT.setu(0x84400004);
    }

    //LAB_80fa6ca
    DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
    DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);
    MEMORY.ref(2, 0x4000084).setu(0x8f); // SOUNDCNT_X
    MEMORY.ref(2, 0x4000082).setu(0xa90e); // SOUNDCNT_H
    MEMORY.ref(1, 0x4000089).and(0x3f).oru(0x40); // SOUNDBIAS (upper byte)

    DMA.channels[1].SAD.setu(r0._350.getAddress());
    DMA.channels[1].DAD.setu(0x40000a0);

    DMA.channels[2].SAD.setu(r0._980.getAddress());
    DMA.channels[2].DAD.setu(0x40000a4);

    _3007ff0.set(r0);

    // Zero out 0xfb0
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    CpuSet(CPU.sp().value, r0.getAddress(), 0x50003ec);
    CPU.sp().value += 0x4;

    r0._06.set(0x8);
    r0._07.set(0xf);
    r0._38.set(getTriConsumer(GoldenSun_80f.class, "FUN_80f9f6c", int.class, SoundStruct.class, SoundStruct50.class));
    r0._28.setPointer(getMethodAddress(GoldenSun_80f.class, "FUN_80fb790"));
    r0._2c.setPointer(getMethodAddress(GoldenSun_80f.class, "FUN_80fb790"));
    r0._30.setPointer(getMethodAddress(GoldenSun_80f.class, "FUN_80fb790"));
    r0._3c.setPointer(getMethodAddress(GoldenSun_80f.class, "FUN_80fb790"));
    FUN_80f9a80(0x2004000);
    r0._34.setPointer(0x2004000); //TODO
    FUN_80fa798(0x40000);

    r0._00.set(0x68736d53);
  }

  @Method(0x80fa798)
  public static void FUN_80fa798(final int r0) {
    final int r1;
    final int r2;
    final int r5;

    final SoundStructFb0 r4 = _3007ff0.deref();
    r2 = (r0 & 0xf0000) >>> 16;
    r4._08.set(r2);
    r5 = MEMORY.ref(2, 0x80fb914 + (r2 - 1) * 0x2).getUnsigned();
    r4._10.set(r5);
    r4._0b.set(divideS(0x630, r5));
    r1 = divideS(0x91d1b * r5 + 0x1388, 0x2710);
    r4._14.set(r1);
    r4._18.set(divideS(0x1000000, r1) + 1 >> 1);
    TIMERS.timers[0].CNT_H.setu(0);
    TIMERS.timers[0].CNT_L.setu(-divideS(0x44940, r5));
    FUN_80fa9a4();

    //LAB_80fa7fc
    while(GPU.VCOUNT.getUnsigned() == 0x9f) {
      // ...
    }

    //LAB_80fa804
    while(GPU.VCOUNT.getUnsigned() != 0x9f) {
      // ...
    }

    TIMERS.timers[0].CNT_H.setu(0x80); // start timer 0
  }

  @Method(0x80fa83c)
  public static void FUN_80fa83c(int r0) {
    int r1;
    final int r2;
    final int r3;
    int r4;
    final int r5;

    r3 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80fa8c8).get();
    r5 = MEMORY.ref(4, r0).get();
    r1 = MEMORY.ref(4, r5).get();
    r0 = MEMORY.ref(4, 0x80fa8cc).get();
    r1 = CPU.cmpT(r1, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r1, 0x1);
      MEMORY.ref(4, r5).setu(r0);
      r4 = CPU.movT(0xff);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0x7f);
        r4 = CPU.andT(r4, r0);
        MEMORY.ref(1, r5 + 0x5).setu(r4);
      }

      //LAB_80fa85e
      r4 = CPU.movT(0xf0);
      r4 = CPU.lslT(r4, 4);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 8);
        MEMORY.ref(1, r5 + 0x6).setu(r0);
        r4 = CPU.movT(0xc);
        r0 = CPU.addT(r5, 0x0);
        r0 = CPU.addT(r0, 0x50);
        r1 = CPU.movT(0x0);

        //LAB_80fa874
        do {
          MEMORY.ref(1, r0).setu(r1);
          r4 = CPU.subT(r4, 0x1);
          r0 = CPU.addT(r0, 0x40);
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80fa87e
      r4 = CPU.movT(0xf0);
      r4 = CPU.lslT(r4, 8);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 12);
        MEMORY.ref(1, r5 + 0x7).setu(r0);
      }

      //LAB_80fa88c
      r4 = CPU.movT(0xb0);
      r4 = CPU.lslT(r4, 16);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0xc0);
        r0 = CPU.lslT(r0, 14);
        r0 = CPU.andT(r0, r4);
        r4 = CPU.lsrT(r0, 14);
        r2 = MEMORY.ref(4, 0x80fa8d0).get();
        r1 = MEMORY.ref(1, r2).getUnsigned();
        r0 = CPU.movT(0x3f);
        r0 = CPU.andT(r0, r1);
        r0 = CPU.orrT(r0, r4);
        MEMORY.ref(1, r2).setu(r0);
      }

      //LAB_80fa8aa
      r4 = CPU.movT(0xf0);
      r4 = CPU.lslT(r4, 12);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_80fa928();
        r0 = CPU.addT(r4, 0x0);
        FUN_80fa798(r0);
      }

      //LAB_80fa8be
      r0 = MEMORY.ref(4, 0x80fa8cc).get();
      MEMORY.ref(4, r5).setu(r0);
    }

    //LAB_80fa8c2
  }

  @Method(0x80fa928)
  public static void FUN_80fa928() {
    CPU.sp().value -= 0x4;

    final int r2 = MEMORY.ref(4, 0x3007ff0).get();
    final int r1 = MEMORY.ref(4, r2).get();
    final int r0 = r1 + 0x978c_92ad;
    CPU.cmpT(r0, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      MEMORY.ref(4, r2).setu(r1 + 0xa);

      if((DMA.channels[1].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[1].CNT.setu(0x8440_0004);
      }

      //LAB_80fa952
      if((DMA.channels[2].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[2].CNT.setu(0x8440_0004);
      }

      //LAB_80fa960
      DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
      DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);

      MEMORY.ref(4, CPU.sp().value).setu(0);
      CpuSet(CPU.sp().value, r2 + 0x350, 0x500_0318);
    }

    //LAB_80fa980
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa9a4)
  public static void FUN_80fa9a4() {
    final SoundStructFb0 r2 = _3007ff0.deref();
    final int r3 = r2._00.get();

    if(r3 != 0x68736d53) { // Magic number for MP2K? https://github.com/mgba-emu/mgba/blob/master/include/mgba/internal/gba/audio.h
      DMA.channels[1].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      DMA.channels[2].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      r2._04.set(0);
      r2._00.sub(0xa);
    }

    //LAB_80fa9cc
  }

  @Method(0x80fa9e0)
  public static void FUN_80fa9e0(final SoundStruct r0, final UnboundedArrayRef<SoundStruct50> r1, final int r2) {
    int r4;

    r4 = r2 & 0xff;
    if(r4 != 0) {
      if(r4 > 16) {
        r4 = 16;
      }

      //LAB_80fa9f4
      final SoundStructFb0 r5 = _3007ff0.deref();
      if(r5._00.get() == 0x68736d53) {
        r5._00.incr();
        FUN_80fa68c(r0.getAddress());
        r0._2c.set(r1);
        r0._08.set(r4);
        r0._04.set(0x80000000);

        //LAB_80faa1a
        for(int i = 0; i < r4; i++) {
          r1.get(i)._00.set(0);
        }

        //LAB_80faa28
        if(!r5._20.isNull()) {
          r0._38.set(r5._20.deref());
          r0._3c.set(r5._24.deref());
          r5._20.clear();
        }

        //LAB_80faa38
        r5._24.set(r0);
        r5._20.set(getConsumer(GoldenSun_80f.class, "FUN_80f9c90", SoundStruct.class));
        r5._00.set(0x68736d53);
        r0._34.set(0x68736d53);
      }
    }

    //LAB_80faa44
  }

  @Method(0x80faa58)
  public static void FUN_80faa58(final SoundStruct r0, final int r1) {
    if(r0._34.get() != 0x68736d53) {
      return;
    }

    final int r2 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
    if(r0._0b.get() != 0) {
      if(r0._00.get() != 0 && (MEMORY.ref(4, r0.getAddress() + 0x2c).deref(1).getUnsigned() & 0x40) != 0 || (r0._04.get() & 0xffff) != 0 && r0._04.get() >= 0) {
        //LAB_80faa90
        if( r0._09.get() > r2) {
          return;
        }
      }
    }

    //LAB_80faa9a
    r0._00.set(r1);
    r0._04.set(0);
    r0._09.set(r2);
    r0._0c.set(0);
    r0._1c.set(150);
    r0._1e.set(256);
    r0._20.set(150);
    r0._22.set(0);
    r0._24.set(0);
    r0._30.set(MEMORY.ref(4, r1 + 0x4).get());
    r0._34.incr();

    final UnboundedArrayRef<SoundStruct50> structs = r0._2c.deref();
    int r6 = 0;

    //LAB_80faace
    while(r6 < MEMORY.ref(1, r1).getUnsigned() && r6 < r0._08.get()) {
      final SoundStruct50 r4 = structs.get(r6);
      FUN_80f9ef8(r0, r4);
      r4._00.set(0xc0);
      r4._20.clear();
      r4._40.set(MEMORY.ref(4, r1 + 0x8 + r6 * 0x4).get());
      r6++;
    }

    //LAB_80faafa
    //LAB_80fab04
    while(r6 < r0._08.get()) {
      final SoundStruct50 r4 = structs.get(r6);
      FUN_80f9ef8(r0, r4);
      r4._00.set(0);
      r6++;
    }

    //LAB_80fab1a
    if((MEMORY.ref(1, r1 + 0x3).getUnsigned() & 0x80) != 0) {
      FUN_80fa83c(MEMORY.ref(1, r1 + 0x3).getUnsigned());
    }

    //LAB_80fab2a
    r0._34.set(0x68736d53);

    //LAB_80fab2e
  }

  @Method(0x80fab7c)
  public static void FUN_80fab7c(final SoundStruct r0) {
    int r5;

    final int r1 = r0._24.get();
    if(r1 == 0) {
      return;
    }

    r0._26.decr();

    final int r3 = r0._26.get();
    if(r3 != 0) {
      return;
    }

    r0._26.set(r1);

    if((r0._28.get() & 0x2) != 0) {
      r0._28.add(0x10);

      if(r0._28.get() > 0xff) {
        r0._28.set(0x100);
        r0._24.set(r3);
      }
    } else {
      //LAB_80fabc0
      r0._28.sub(0x10);

      if(r0._28.get() <= 0) {
        final UnboundedArrayRef<SoundStruct50> structs = r0._2c.deref();
        r5 = r0._08.get();

        //LAB_80fabd6
        for(int i = 0; i < r5; i++) {
          final SoundStruct50 r4 = structs.get(i);
          FUN_80f9ef8(r0, r4);

          if((r0._28.get() & 0x1) == 0) {
            r4._00.set(0);
          }

          //LAB_80fabea
        }

        //LAB_80fabf2
        if((r0._28.get() & 0x1) != 0) {
          r0._04.or(0x80000000);
        } else {
          //LAB_80fac06
          r0._04.set(0x80000000);
        }

        //LAB_80fac0a
        r0._24.set(0);
        return;
      }
    }

    //LAB_80fac12
    final UnboundedArrayRef<SoundStruct50> structs = r0._2c.deref();
    r5 = r0._08.get();

    //LAB_80fac20
    for(int i = 0; i < r5; i++) {
      final SoundStruct50 r4 = structs.get(i);

      if((r4._00.get() & 0x80) != 0) {
        r4._13.set(r0._28.get() >>> 2);
        r4._00.or(0x3);
      }

      //LAB_80fac36
      r5--;
    }

    //LAB_80fac3e
  }

  @Method(0x80fac44)
  public static void FUN_80fac44(final int r0, final SoundStruct50 r1) {
    if((r1._00.get() & 0x1) != 0) {
      int r3 = r1._13.get() * r1._12.get() >>> 5;
      final int r4 = r1._18.get();
      if(r4 == 0x1) {
        r3 = r3 * (r1._16.get() + 0x80) >>> 7;
      }

      //LAB_80fac6c
      int r1_0 = r1._14.get() * 2 + r1._15.get();
      if(r4 == 0x2) {
        r1_0 += r1._16.get();
      }

      //LAB_80fac82
      if(r1_0 < -0x80) {
        r1_0 = -0x80;
        //LAB_80fac8e
      } else if(r1_0 > 0x7f) {
        r1_0 = 0x7f;
      }

      //LAB_80fac94
      r1._10.set((r1_0 + 0x80) * r3 >>> 8);
      r1._11.set((0x7f - r1_0) * r3 >>> 8);
    }

    //LAB_80faca8
    if((r1._00.get() & 0x4) != 0) {
      int r1_0 = r1._0d.get() + (r1._0c.get() + r1._0e.get() * r1._0f.get() << 2) + (r1._0a.get() << 8) + (r1._0b.get() << 8);
      if(r1._18.get() == 0) {
        r1_0 += (r1._16.get() << 4);
      }

      //LAB_80face6
      r1._08.set(r1_0 >> 8);
      r1._09.set(r1_0);
    }

    //LAB_80facec
    r1._00.and(0xfa);
  }

  @Method(0x80facf8)
  public static int FUN_80facf8(int r0, int r1, int r2) {
    final int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    r0 = CPU.lslT(r0, 24);
    r0 = CPU.lsrT(r0, 24);
    r1 = CPU.lslT(r1, 24);
    r5 = CPU.lsrT(r1, 24);
    r2 = CPU.lslT(r2, 24);
    r2 = CPU.lsrT(r2, 24);
    CPU.r12().value = r2;
    CPU.cmpT(r0, 0x4);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r5, 0x14);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r5 = CPU.movT(0x0);
      } else {
        //LAB_80fad14
        r0 = CPU.addT(r5, 0x0);
        r0 = CPU.subT(r0, 0x15);
        r0 = CPU.lslT(r0, 24);
        r5 = CPU.lsrT(r0, 24);
        CPU.cmpT(r5, 0x3b);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r5 = CPU.movT(0x3b);
        }
      }

      //LAB_80fad22
      r0 = MEMORY.ref(4, 0x80fad2c).get();
      r0 = CPU.addT(r5, r0);
      r0 = MEMORY.ref(1, r0).getUnsigned();
    } else {
      //LAB_80fad30
      CPU.cmpT(r5, 0x23);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r0 = CPU.movT(0x0);
        CPU.r12().value = r0;
        r5 = CPU.movT(0x0);
      } else {
        //LAB_80fad3c
        r0 = CPU.addT(r5, 0x0);
        r0 = CPU.subT(r0, 0x24);
        r0 = CPU.lslT(r0, 24);
        r5 = CPU.lsrT(r0, 24);
        CPU.cmpT(r5, 0x82);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r5 = CPU.movT(0x82);
          r1 = CPU.movT(0xff);
          CPU.r12().value = r1;
        }
      }

      //LAB_80fad4e
      r3 = MEMORY.ref(4, 0x80fad98).get();
      r0 = CPU.addT(r5, r3);
      r6 = MEMORY.ref(1, r0).getUnsigned();
      r4 = MEMORY.ref(4, 0x80fad9c).get();
      r2 = CPU.movT(0xf);
      r0 = CPU.addT(r6, 0x0);
      r0 = CPU.andT(r0, r2);
      r0 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, r4);
      r7 = CPU.movT(0x0);
      r1 = MEMORY.ref(2, r0 + r7).get();
      r0 = CPU.asrT(r6, 4);
      r6 = CPU.addT(r1, 0x0);
      r6 = CPU.asrT(r6, r0);
      r0 = CPU.addT(r5, 0x1);
      r0 = CPU.addT(r0, r3);
      r1 = MEMORY.ref(1, r0).getUnsigned();
      r0 = CPU.addT(r1, 0x0);
      r0 = CPU.andT(r0, r2);
      r0 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, r4);
      r2 = CPU.movT(0x0);
      r0 = MEMORY.ref(2, r0 + r2).get();
      r1 = CPU.asrT(r1, 4);
      r0 = CPU.asrT(r0, r1);
      r0 = CPU.subT(r0, r6);
      r7 = CPU.r12().value;
      r7 = CPU.mulT(r7, r0);
      r0 = CPU.addT(r7, 0x0);
      r0 = CPU.asrT(r0, 8);
      r0 = CPU.addT(r6, r0);
      r1 = CPU.movT(0x80);
      r1 = CPU.lslT(r1, 4);
      r0 = CPU.addT(r0, r1);
    }

    //LAB_80fad92
    return r0;
  }

  @Method(0x80fada0)
  public static void FUN_80fada0(int r0) {
    int r1;

    r0 = CPU.lslT(r0, 24);
    r0 = CPU.lsrT(r0, 24);
    r1 = CPU.addT(r0, 0x0);
    CPU.cmpT(r0, 0x2);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_80fadc8
      r1 = MEMORY.ref(4, 0x80fadcc).get();
    } else {
      CPU.cmpT(r0, 0x2);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        //LAB_80fadb4
        CPU.cmpT(r1, 0x3);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_80fadd0
          r1 = MEMORY.ref(4, 0x80fadd8).get();
          r0 = CPU.movT(0x0);
          MEMORY.ref(1, r1).setu(r0);
          return;
        }
      } else {
        CPU.cmpT(r0, 0x1);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_80fadba
          r1 = MEMORY.ref(4, 0x80fadc4).get();
          r0 = CPU.movT(0x8);
          MEMORY.ref(1, r1).setu(r0);
          r1 = CPU.addT(r1, 0x2);
          r0 = CPU.movT(0x80);
          MEMORY.ref(1, r1).setu(r0);
          return;
        }
      }

      //LAB_80faddc
      r1 = MEMORY.ref(4, 0x80fadec).get();
    }

    //LAB_80fadde
    r0 = CPU.movT(0x8);
    MEMORY.ref(1, r1).setu(r0);
    r1 = CPU.addT(r1, 0x4);

    //LAB_80fade4
    r0 = CPU.movT(0x80);

    //LAB_80fade6
    MEMORY.ref(1, r1).setu(r0);
  }

  @Method(0x80fadf0)
  public static void FUN_80fadf0(int r0) {
    final int r1;
    int r2;
    int r3;
    int r4;

    r1 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
    r2 = CPU.lslT(r0, 24);
    r4 = CPU.lsrT(r2, 24);
    r3 = MEMORY.ref(1, r1 + 0x3).getUnsigned();
    r0 = CPU.lslT(r3, 24);
    r3 = CPU.lsrT(r0, 24);
    r4 = CPU.cmpT(r4, r3);

    jmp_80fae3c:
    {
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = CPU.lsrT(r2, 25);
        r0 = CPU.cmpT(r0, r3);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_80fae1c
          r0 = CPU.movT(0xff);
          MEMORY.ref(1, r1 + 0x1b).setu(r0);
          r2 = MEMORY.ref(1, r1 + 0x3).getUnsigned();
          r3 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
          r0 = CPU.addT(r2, r3);
          r0 = CPU.lsrT(r0, 4);
          MEMORY.ref(1, r1 + 0xa).setu(r0);
          break jmp_80fae3c;
        }
        r0 = CPU.movT(0xf);
        MEMORY.ref(1, r1 + 0x1b).setu(r0);
      } else {
        //LAB_80fae10
        r0 = CPU.lsrT(r0, 25);
        r0 = CPU.cmpT(r0, r4);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_80fae1c
          r0 = CPU.movT(0xff);
          MEMORY.ref(1, r1 + 0x1b).setu(r0);
          r2 = MEMORY.ref(1, r1 + 0x3).getUnsigned();
          r3 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
          r0 = CPU.addT(r2, r3);
          r0 = CPU.lsrT(r0, 4);
          MEMORY.ref(1, r1 + 0xa).setu(r0);
          break jmp_80fae3c;
        }
        r0 = CPU.movT(0xf0);
        MEMORY.ref(1, r1 + 0x1b).setu(r0);
      }

      //LAB_80fae2a
      r2 = MEMORY.ref(1, r1 + 0x3).getUnsigned();
      r3 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
      r0 = CPU.addT(r2, r3);
      r0 = CPU.lsrT(r0, 4);
      MEMORY.ref(1, r1 + 0xa).setu(r0);
      CPU.cmpT(r0, 0xf);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = CPU.movT(0xf);
        MEMORY.ref(1, r1 + 0xa).setu(r0);
      }
    }

    //LAB_80fae3c
    r2 = MEMORY.ref(1, r1 + 0x6).getUnsigned();
    r3 = MEMORY.ref(1, r1 + 0xa).getUnsigned();
    r0 = CPU.addT(r2, 0x0);
    r0 = CPU.mulT(r0, r3);
    r0 = CPU.addT(r0, 0xf);
    r0 = CPU.asrT(r0, 4);
    MEMORY.ref(1, r1 + 0x19).setu(r0);
    r0 = MEMORY.ref(1, r1 + 0x1c).getUnsigned();
    r2 = MEMORY.ref(1, r1 + 0x1b).getUnsigned();
    r0 = CPU.andT(r0, r2);
    MEMORY.ref(1, r1 + 0x1b).setu(r0);
  }

  /** I would like to wish this method a very fuck you */
  @Method(0x80fae58)
  public static void FUN_80fae58(final SoundStructFb0 r0unused) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    CPU.sp().value -= 0x1c;
    r0 = MEMORY.ref(4, 0x80fae78).get();
    r0 = MEMORY.ref(4, r0).get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r0 = MEMORY.ref(1, r0 + 0xa).getUnsigned();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.subT(r0, 0x1);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      MEMORY.ref(1, r1 + 0xa).setu(r0);
    } else {
      //LAB_80fae7c
      r0 = CPU.movT(0xe);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      MEMORY.ref(1, r2 + 0xa).setu(r0);
    }

    //LAB_80fae82
    r6 = CPU.movT(0x1);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r4 = MEMORY.ref(4, r0 + 0x1c).get();

    //LAB_80fae88
    do {
      r1 = MEMORY.ref(1, r4).getUnsigned();
      r0 = CPU.movT(0xc7);
      r0 = CPU.andT(r0, r1);
      r2 = CPU.addT(r6, 0x1);
      CPU.r10().value = r2;
      r2 = CPU.movT(0x40);
      r2 = CPU.addT(r2, r4);
      CPU.r9().value = r2;
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_80fae9e
        CPU.cmpT(r6, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_80faed0
          r0 = MEMORY.ref(4, 0x80faedc).get();
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
          r7 = MEMORY.ref(4, 0x80faee0).get();
          r2 = MEMORY.ref(4, 0x80faee4).get();
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
          r0 = CPU.addT(r0, 0xb);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
          r2 = CPU.addT(r2, 0x4);
        } else {
          CPU.cmpT(r6, 0x2);
          if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
            CPU.cmpT(r6, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_80faeb2
              r0 = MEMORY.ref(4, 0x80faec4).get();
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
              r7 = MEMORY.ref(4, 0x80faec8).get();
              r2 = MEMORY.ref(4, 0x80faecc).get();
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
              r0 = CPU.addT(r0, 0x4);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
              r2 = CPU.addT(r2, 0x2);
            } else {
              r0 = MEMORY.ref(4, 0x80faf68).get();
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
              r7 = MEMORY.ref(4, 0x80faf6c).get();
              r2 = MEMORY.ref(4, 0x80faf70).get();
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
              r0 = CPU.addT(r0, 0xb);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
              r2 = CPU.addT(r2, 0x4);
            }
          } else {
            //LAB_80faeac
            CPU.cmpT(r6, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_80faee8
              r0 = MEMORY.ref(4, 0x80faefc).get();
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
              r7 = MEMORY.ref(4, 0x80faf00).get();
              r2 = MEMORY.ref(4, 0x80faf04).get();
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
              r0 = CPU.addT(r0, 0x4);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
              r2 = CPU.addT(r2, 0x2);
            } else {
              r0 = MEMORY.ref(4, 0x80faf68).get();
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
              r7 = MEMORY.ref(4, 0x80faf6c).get();
              r2 = MEMORY.ref(4, 0x80faf70).get();
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
              r0 = CPU.addT(r0, 0xb);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
              r2 = CPU.addT(r2, 0x4);
            }
          }
        }

        jmp_80fb284:
        {
          jmp_80fb186:
          {
            //LAB_80faf18
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r0 = MEMORY.ref(1, r0 + 0xa).getUnsigned();
            MEMORY.ref(4, CPU.sp().value).setu(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = MEMORY.ref(1, r2).getUnsigned();
            CPU.r8().value = r0;
            r2 = CPU.addT(r1, 0x0);
            r0 = CPU.movT(0x80);
            r0 = CPU.andT(r0, r2);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.movT(0x40);
              r0 = CPU.addT(r3, 0x0);
              r0 = CPU.andT(r0, r2);
              r0 = CPU.lslT(r0, 24);
              r5 = CPU.lsrT(r0, 24);
              r0 = CPU.addT(r6, 0x1);
              CPU.r10().value = r0;
              r1 = CPU.movT(0x40);
              r1 = CPU.addT(r1, r4);
              CPU.r9().value = r1;
              CPU.cmpT(r5, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80fb032
                r0 = CPU.lslT(r6, 24);
                r0 = CPU.lsrT(r0, 24);
                FUN_80fada0(r0);
                r0 = CPU.movT(0x0);
                MEMORY.ref(1, r4).setu(r0);
                break jmp_80fb284;
              }
              r0 = CPU.movT(0x3);
              MEMORY.ref(1, r4).setu(r0);
              MEMORY.ref(1, r4 + 0x1d).setu(r0);
              r0 = CPU.addT(r4, 0x0);
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
              FUN_80fadf0(r0);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              CPU.cmpT(r6, 0x2);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_80faf80
                r0 = MEMORY.ref(4, r4 + 0x24).get();
                r0 = CPU.lslT(r0, 6);
                r1 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                r0 = CPU.addT(r1, r0);
                MEMORY.ref(1, r7).setu(r0);
                r0 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
                r0 = CPU.addT(r0, 0x8);
                CPU.r8().value = r0;
                r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.movT(0x40);
                }

                //LAB_80fafee
                MEMORY.ref(1, r4 + 0x1a).setu(r0);
              } else {
                CPU.cmpT(r6, 0x2);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  CPU.cmpT(r6, 0x1);
                  if(CPU.cpsr().getZero()) { // ==
                    //LAB_80faf7a
                    r0 = MEMORY.ref(1, r4 + 0x1f).getUnsigned();
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    MEMORY.ref(1, r2).setu(r0);
                    r0 = MEMORY.ref(4, r4 + 0x24).get();
                    r0 = CPU.lslT(r0, 6);
                    r1 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    r0 = CPU.addT(r1, r0);
                    MEMORY.ref(1, r7).setu(r0);
                    r0 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
                    r0 = CPU.addT(r0, 0x8);
                    CPU.r8().value = r0;
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.movT(0x40);
                    }

                    //LAB_80fafee
                    MEMORY.ref(1, r4 + 0x1a).setu(r0);
                  } else {
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    MEMORY.ref(1, r7).setu(r0);
                    r0 = MEMORY.ref(4, r4 + 0x24).get();
                    r0 = CPU.lslT(r0, 3);
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                    MEMORY.ref(1, r2).setu(r0);
                    r0 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
                    r0 = CPU.addT(r0, 0x8);
                    CPU.r8().value = r0;
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.movT(0x40);
                    }

                    //LAB_80fafee
                    MEMORY.ref(1, r4 + 0x1a).setu(r0);
                  }
                } else {
                  //LAB_80faf74
                  CPU.cmpT(r6, 0x3);
                  if(CPU.cpsr().getZero()) { // ==
                    //LAB_80faf8c
                    r1 = MEMORY.ref(4, r4 + 0x24).get();
                    r0 = MEMORY.ref(4, r4 + 0x28).get();
                    r1 = CPU.cmpT(r1, r0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                      MEMORY.ref(1, r2).setu(r3);
                      r1 = MEMORY.ref(4, 0x80fafc8).get();
                      r2 = MEMORY.ref(4, r4 + 0x24).get();
                      r0 = MEMORY.ref(4, r2).get();
                      MEMORY.ref(4, r1).setu(r0);
                      r1 = CPU.addT(r1, 0x4);
                      r0 = MEMORY.ref(4, r2 + 0x4).get();
                      MEMORY.ref(4, r1).setu(r0);
                      r1 = CPU.addT(r1, 0x4);
                      r0 = MEMORY.ref(4, r2 + 0x8).get();
                      MEMORY.ref(4, r1).setu(r0);
                      r1 = CPU.addT(r1, 0x4);
                      r0 = MEMORY.ref(4, r2 + 0xc).get();
                      MEMORY.ref(4, r1).setu(r0);
                      MEMORY.ref(4, r4 + 0x28).setu(r2);
                    }

                    //LAB_80fafb4
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    MEMORY.ref(1, r0).setu(r5);
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    MEMORY.ref(1, r7).setu(r0);
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.movT(0xc0);
                      MEMORY.ref(1, r4 + 0x1a).setu(r0);
                    } else {
                      //LAB_80fafcc
                      r1 = CPU.movT(0x80);
                      r1 = CPU.negT(r1);
                      MEMORY.ref(1, r4 + 0x1a).setu(r1);
                    }
                  } else {
                    //LAB_80fafd4
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    MEMORY.ref(1, r7).setu(r0);
                    r0 = MEMORY.ref(4, r4 + 0x24).get();
                    r0 = CPU.lslT(r0, 3);
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                    MEMORY.ref(1, r2).setu(r0);
                    r0 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
                    r0 = CPU.addT(r0, 0x8);
                    CPU.r8().value = r0;
                    r0 = MEMORY.ref(1, r4 + 0x1e).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.movT(0x40);
                    }

                    //LAB_80fafee
                    MEMORY.ref(1, r4 + 0x1a).setu(r0);
                  }
                }
              }

              //LAB_80faff0
              r1 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
              r2 = CPU.movT(0x0);
              MEMORY.ref(1, r4 + 0xb).setu(r1);
              r0 = CPU.movT(0xff);
              r0 = CPU.andT(r0, r1);
              r1 = CPU.addT(r6, 0x1);
              CPU.r10().value = r1;
              r1 = CPU.movT(0x40);
              r1 = CPU.addT(r1, r4);
              CPU.r9().value = r1;
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80fb00a
                MEMORY.ref(1, r4 + 0x9).setu(r2);
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
              } else {
                r0 = MEMORY.ref(1, r4).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                r2 = CPU.movT(0x0);
                MEMORY.ref(1, r4).setu(r0);
                r1 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
                MEMORY.ref(1, r4 + 0xb).setu(r1);
                r0 = CPU.movT(0xff);
                r0 = CPU.andT(r0, r1);
                CPU.cmpT(r0, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = MEMORY.ref(1, r4 + 0x6).getUnsigned();
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.movT(0xfc);
                    r1 = MEMORY.ref(1, r4).getUnsigned();
                    r0 = CPU.andT(r0, r1);
                    MEMORY.ref(1, r4).setu(r0);
                    r2 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
                    r1 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                    r0 = CPU.addT(r2, 0x0);
                    r0 = CPU.mulT(r0, r1);
                    r0 = CPU.addT(r0, 0xff);
                    r0 = CPU.asrT(r0, 8);
                    r1 = CPU.movT(0x0);
                    MEMORY.ref(1, r4 + 0x9).setu(r0);
                    r0 = CPU.lslT(r0, 24);
                    CPU.cmpT(r0, 0x0);
                    if(CPU.cpsr().getZero()) { // ==
                      //LAB_80fb032
                      r0 = CPU.lslT(r6, 24);
                      r0 = CPU.lsrT(r0, 24);
                      FUN_80fada0(r0);
                      r0 = CPU.movT(0x0);
                      MEMORY.ref(1, r4).setu(r0);
                      break jmp_80fb284;
                    }
                    r0 = CPU.movT(0x4);
                    r2 = MEMORY.ref(1, r4).getUnsigned();
                    r0 = CPU.orrT(r0, r2);
                    MEMORY.ref(1, r4).setu(r0);
                    r0 = CPU.movT(0x1);
                    r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                    r0 = CPU.orrT(r0, r1);
                    MEMORY.ref(1, r4 + 0x1d).setu(r0);
                    CPU.cmpT(r6, 0x3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r2 = CPU.movT(0x8);
                      CPU.r8().value = r2;
                    }
                    break jmp_80fb186;
                  }

                  //LAB_80fb11a
                  r0 = MEMORY.ref(1, r4).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4).setu(r0);
                  r0 = CPU.movT(0x1);
                  r2 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                  r0 = CPU.orrT(r0, r2);
                  MEMORY.ref(1, r4 + 0x1d).setu(r0);
                  CPU.cmpT(r6, 0x3);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = CPU.movT(0x8);
                    CPU.r8().value = r0;
                  }
                  r0 = MEMORY.ref(1, r4 + 0x19).getUnsigned();
                  MEMORY.ref(1, r4 + 0x9).setu(r0);
                  r0 = CPU.movT(0x7);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value).get();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break jmp_80fb186;
                  }
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                } else {
                  r0 = CPU.movT(0x1);
                  r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                  r0 = CPU.orrT(r0, r1);
                  MEMORY.ref(1, r4 + 0x1d).setu(r0);
                  r0 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                  MEMORY.ref(1, r4 + 0x9).setu(r0);
                  CPU.cmpT(r6, 0x3);
                  if(!CPU.cpsr().getZero()) { // !=
                    r2 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
                    CPU.r8().value = r2;
                  }

                  r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value).get();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break jmp_80fb186;
                  }
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                }
              }
            } else {
              //LAB_80fb00e
              r0 = CPU.movT(0x4);
              r0 = CPU.andT(r0, r2);
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(1, r4 + 0xd).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xd).setu(r0);
                r2 = CPU.movT(0xff);
                r0 = CPU.andT(r0, r2);
                r0 = CPU.lslT(r0, 24);
                r1 = CPU.addT(r6, 0x1);
                CPU.r10().value = r1;
                r2 = CPU.movT(0x40);
                r2 = CPU.addT(r2, r4);
                CPU.r9().value = r2;
                CPU.cmpT(r0, 0x0);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  //LAB_80fb032
                  r0 = CPU.lslT(r6, 24);
                  r0 = CPU.lsrT(r0, 24);
                  FUN_80fada0(r0);
                  r0 = CPU.movT(0x0);
                  MEMORY.ref(1, r4).setu(r0);
                  break jmp_80fb284;
                }
                break jmp_80fb186;
              }

              //LAB_80fb040
              r0 = CPU.movT(0x40);
              r0 = CPU.andT(r0, r1);
              r2 = CPU.addT(r6, 0x1);
              CPU.r10().value = r2;
              r2 = CPU.movT(0x40);
              r2 = CPU.addT(r2, r4);
              CPU.r9().value = r2;
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = CPU.movT(0x3);
                r0 = CPU.andT(r0, r1);
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.movT(0xfc);
                  r0 = CPU.andT(r0, r1);
                  r2 = CPU.movT(0x0);
                  MEMORY.ref(1, r4).setu(r0);
                  r1 = MEMORY.ref(1, r4 + 0x7).getUnsigned();
                  MEMORY.ref(1, r4 + 0xb).setu(r1);
                  r0 = CPU.movT(0xff);
                  r0 = CPU.andT(r0, r1);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r2 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
                    r1 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                    r0 = CPU.addT(r2, 0x0);
                    r0 = CPU.mulT(r0, r1);
                    r0 = CPU.addT(r0, 0xff);
                    r0 = CPU.asrT(r0, 8);
                    r1 = CPU.movT(0x0);
                    MEMORY.ref(1, r4 + 0x9).setu(r0);
                    r0 = CPU.lslT(r0, 24);
                    CPU.cmpT(r0, 0x0);
                    if(CPU.cpsr().getZero()) { // ==
                      //LAB_80fb032
                      r0 = CPU.lslT(r6, 24);
                      r0 = CPU.lsrT(r0, 24);
                      FUN_80fada0(r0);
                      r0 = CPU.movT(0x0);
                      MEMORY.ref(1, r4).setu(r0);
                      break jmp_80fb284;
                    }
                    r0 = CPU.movT(0x4);
                    r2 = MEMORY.ref(1, r4).getUnsigned();
                    r0 = CPU.orrT(r0, r2);
                    MEMORY.ref(1, r4).setu(r0);
                    r0 = CPU.movT(0x1);
                    r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                    r0 = CPU.orrT(r0, r1);
                    MEMORY.ref(1, r4 + 0x1d).setu(r0);
                    CPU.cmpT(r6, 0x3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r2 = CPU.movT(0x8);
                      CPU.r8().value = r2;
                    }
                    break jmp_80fb186;
                  }
                  r0 = CPU.movT(0x1);
                  r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                  r0 = CPU.orrT(r0, r1);
                  MEMORY.ref(1, r4 + 0x1d).setu(r0);
                  CPU.cmpT(r6, 0x3);
                  if(!CPU.cpsr().getZero()) { // !=
                    r2 = MEMORY.ref(1, r4 + 0x7).getUnsigned();
                    CPU.r8().value = r2;
                  }

                  r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value).get();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break jmp_80fb186;
                  }
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                }
              }
            }

            //LAB_80fb080
            do {
              r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                continue;
              }
              CPU.cmpT(r6, 0x3);
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.movT(0x1);
                r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                r0 = CPU.orrT(r0, r1);
                MEMORY.ref(1, r4 + 0x1d).setu(r0);
              }

              //LAB_80fb092
              r0 = CPU.addT(r4, 0x0);
              FUN_80fadf0(r0);
              r0 = CPU.movT(0x3);
              r2 = MEMORY.ref(1, r4).getUnsigned();
              r0 = CPU.andT(r0, r2);
              CPU.cmpT(r0, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r0 = MEMORY.ref(1, r4 + 0x9).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                r1 = CPU.movT(0xff);
                r0 = CPU.andT(r0, r1);
                r0 = CPU.lslT(r0, 24);
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  //LAB_80fb0e2
                  r0 = MEMORY.ref(1, r4 + 0x7).getUnsigned();
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value).get();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break jmp_80fb186;
                  }
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                  continue;
                }

                //LAB_80fb0b2
                r2 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
                r1 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                r0 = CPU.addT(r2, 0x0);
                r0 = CPU.mulT(r0, r1);
                r0 = CPU.addT(r0, 0xff);
                r0 = CPU.asrT(r0, 8);
                r1 = CPU.movT(0x0);
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                r0 = CPU.lslT(r0, 24);
                CPU.cmpT(r0, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_80fb032
                  r0 = CPU.lslT(r6, 24);
                  r0 = CPU.lsrT(r0, 24);
                  FUN_80fada0(r0);
                  r0 = CPU.movT(0x0);
                  MEMORY.ref(1, r4).setu(r0);
                  break jmp_80fb284;
                }
                r0 = CPU.movT(0x4);
                r2 = MEMORY.ref(1, r4).getUnsigned();
                r0 = CPU.orrT(r0, r2);
                MEMORY.ref(1, r4).setu(r0);
                r0 = CPU.movT(0x1);
                r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                r0 = CPU.orrT(r0, r1);
                MEMORY.ref(1, r4 + 0x1d).setu(r0);
                CPU.cmpT(r6, 0x3);
                if(!CPU.cpsr().getZero()) { // !=
                  r2 = CPU.movT(0x8);
                  CPU.r8().value = r2;
                }
                break jmp_80fb186;
              }

              //LAB_80fb0e6
              CPU.cmpT(r0, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_80fb0ea
                r0 = MEMORY.ref(1, r4 + 0x19).getUnsigned();
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                r0 = CPU.movT(0x7);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                continue;
              }

              //LAB_80fb0f2
              CPU.cmpT(r0, 0x2);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80fb136
                r0 = MEMORY.ref(1, r4 + 0x9).getUnsigned();
                r0 = CPU.addT(r0, 0x1);
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                r1 = CPU.movT(0xff);
                r0 = CPU.andT(r0, r1);
                r2 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                r0 = CPU.cmpT(r0, r2);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  //LAB_80fb170
                  r0 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(1, r4 + 0xb).setu(r0);
                  r0 = MEMORY.ref(4, CPU.sp().value).get();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break jmp_80fb186;
                  }
                  r0 = CPU.subT(r0, 0x1);
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                  continue;
                }

                //LAB_80fb146
                r0 = MEMORY.ref(1, r4).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                r2 = CPU.movT(0x0);
                MEMORY.ref(1, r4).setu(r0);
                r1 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
                MEMORY.ref(1, r4 + 0xb).setu(r1);
                r0 = CPU.movT(0xff);
                r0 = CPU.andT(r0, r1);
                CPU.cmpT(r0, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = MEMORY.ref(1, r4 + 0x6).getUnsigned();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    //LAB_80fb11a
                    r0 = MEMORY.ref(1, r4).getUnsigned();
                    r0 = CPU.subT(r0, 0x1);
                    MEMORY.ref(1, r4).setu(r0);
                    r0 = CPU.movT(0x1);
                    r2 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                    r0 = CPU.orrT(r0, r2);
                    MEMORY.ref(1, r4 + 0x1d).setu(r0);
                    CPU.cmpT(r6, 0x3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.movT(0x8);
                      CPU.r8().value = r0;
                    }
                    r0 = MEMORY.ref(1, r4 + 0x19).getUnsigned();
                    MEMORY.ref(1, r4 + 0x9).setu(r0);
                    r0 = CPU.movT(0x7);
                    MEMORY.ref(1, r4 + 0xb).setu(r0);
                    r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                    r0 = CPU.subT(r0, 0x1);
                    MEMORY.ref(1, r4 + 0xb).setu(r0);
                    r0 = MEMORY.ref(4, CPU.sp().value).get();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      break jmp_80fb186;
                    }
                    r0 = CPU.subT(r0, 0x1);
                    MEMORY.ref(4, CPU.sp().value).setu(r0);
                    continue;
                  }
                  r0 = CPU.movT(0xfc);
                  r1 = MEMORY.ref(1, r4).getUnsigned();
                  r0 = CPU.andT(r0, r1);
                  MEMORY.ref(1, r4).setu(r0);
                  r2 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
                  r1 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                  r0 = CPU.addT(r2, 0x0);
                  r0 = CPU.mulT(r0, r1);
                  r0 = CPU.addT(r0, 0xff);
                  r0 = CPU.asrT(r0, 8);
                  r1 = CPU.movT(0x0);
                  MEMORY.ref(1, r4 + 0x9).setu(r0);
                  r0 = CPU.lslT(r0, 24);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    //LAB_80fb032
                    r0 = CPU.lslT(r6, 24);
                    r0 = CPU.lsrT(r0, 24);
                    FUN_80fada0(r0);
                    r0 = CPU.movT(0x0);
                    MEMORY.ref(1, r4).setu(r0);
                    break jmp_80fb284;
                  }
                  r0 = CPU.movT(0x4);
                  r2 = MEMORY.ref(1, r4).getUnsigned();
                  r0 = CPU.orrT(r0, r2);
                  MEMORY.ref(1, r4).setu(r0);
                  r0 = CPU.movT(0x1);
                  r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                  r0 = CPU.orrT(r0, r1);
                  MEMORY.ref(1, r4 + 0x1d).setu(r0);
                  CPU.cmpT(r6, 0x3);
                  if(!CPU.cpsr().getZero()) { // !=
                    r2 = CPU.movT(0x8);
                    CPU.r8().value = r2;
                  }
                  break jmp_80fb186;
                }
                r0 = CPU.movT(0x1);
                r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                r0 = CPU.orrT(r0, r1);
                MEMORY.ref(1, r4 + 0x1d).setu(r0);
                r0 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                CPU.cmpT(r6, 0x3);
                if(!CPU.cpsr().getZero()) { // !=
                  r2 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
                  CPU.r8().value = r2;
                }
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                continue;
              }
              r0 = MEMORY.ref(1, r4 + 0x9).getUnsigned();
              r0 = CPU.subT(r0, 0x1);
              MEMORY.ref(1, r4 + 0x9).setu(r0);
              r1 = CPU.movT(0xff);
              r0 = CPU.andT(r0, r1);
              r0 = CPU.lslT(r0, 24);
              r2 = MEMORY.ref(1, r4 + 0x19).getUnsigned();
              r1 = CPU.lslT(r2, 24);
              r0 = CPU.cmpT(r0, r1);
              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                //LAB_80fb132
                r0 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                continue;
              }

              //LAB_80fb10a
              r0 = MEMORY.ref(1, r4 + 0x6).getUnsigned();
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80fb11a
                r0 = MEMORY.ref(1, r4).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4).setu(r0);
                r0 = CPU.movT(0x1);
                r2 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                r0 = CPU.orrT(r0, r2);
                MEMORY.ref(1, r4 + 0x1d).setu(r0);
                CPU.cmpT(r6, 0x3);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.movT(0x8);
                  CPU.r8().value = r0;
                }
                r0 = MEMORY.ref(1, r4 + 0x19).getUnsigned();
                MEMORY.ref(1, r4 + 0x9).setu(r0);
                r0 = CPU.movT(0x7);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(1, r4 + 0xb).getUnsigned();
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r4 + 0xb).setu(r0);
                r0 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  break jmp_80fb186;
                }
                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                continue;
              }

              break;
            } while(true);

            r0 = CPU.movT(0xfc);
            r1 = MEMORY.ref(1, r4).getUnsigned();
            r0 = CPU.andT(r0, r1);
            MEMORY.ref(1, r4).setu(r0);
            r2 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
            r1 = MEMORY.ref(1, r4 + 0xa).getUnsigned();
            r0 = CPU.addT(r2, 0x0);
            r0 = CPU.mulT(r0, r1);
            r0 = CPU.addT(r0, 0xff);
            r0 = CPU.asrT(r0, 8);
            r1 = CPU.movT(0x0);
            MEMORY.ref(1, r4 + 0x9).setu(r0);
            r0 = CPU.lslT(r0, 24);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_80fb032
              r0 = CPU.lslT(r6, 24);
              r0 = CPU.lsrT(r0, 24);
              FUN_80fada0(r0);
              r0 = CPU.movT(0x0);
              MEMORY.ref(1, r4).setu(r0);
              break jmp_80fb284;
            }
            r0 = CPU.movT(0x4);
            r2 = MEMORY.ref(1, r4).getUnsigned();
            r0 = CPU.orrT(r0, r2);
            MEMORY.ref(1, r4).setu(r0);
            r0 = CPU.movT(0x1);
            r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
            r0 = CPU.orrT(r0, r1);
            MEMORY.ref(1, r4 + 0x1d).setu(r0);
            CPU.cmpT(r6, 0x3);
            if(!CPU.cpsr().getZero()) { // !=
              r2 = CPU.movT(0x8);
              CPU.r8().value = r2;
            }
          }

          //LAB_80fb186
          r0 = CPU.movT(0x2);
          r1 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
          r0 = CPU.andT(r0, r1);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            CPU.cmpT(r6, 0x3);
            if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
              r0 = CPU.movT(0x8);
              r2 = MEMORY.ref(1, r4 + 0x1).getUnsigned();
              r0 = CPU.andT(r0, r2);
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(4, 0x80fb1b0).get();
                r0 = MEMORY.ref(1, r0).getUnsigned();
                CPU.cmpT(r0, 0x3f);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r0 = MEMORY.ref(4, r4 + 0x20).get();
                  r0 = CPU.addT(r0, 0x2);
                  r1 = MEMORY.ref(4, 0x80fb1b4).get();
                  r0 = CPU.andT(r0, r1);
                  MEMORY.ref(4, r4 + 0x20).setu(r0);
                } else {
                  //LAB_80fb1b8
                  CPU.cmpT(r0, 0x7f);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r0 = MEMORY.ref(4, r4 + 0x20).get();
                    r0 = CPU.addT(r0, 0x1);
                    r1 = MEMORY.ref(4, 0x80fb1d4).get();
                    r0 = CPU.andT(r0, r1);
                    MEMORY.ref(4, r4 + 0x20).setu(r0);
                  }
                }
              }
            }

            //LAB_80fb1c6
            CPU.cmpT(r6, 0x4);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = MEMORY.ref(4, r4 + 0x20).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              MEMORY.ref(1, r1).setu(r0);
            } else {
              //LAB_80fb1d8
              r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              r0 = MEMORY.ref(1, r2).getUnsigned();
              r1 = CPU.movT(0x8);
              r1 = CPU.andT(r1, r0);
              r0 = MEMORY.ref(4, r4 + 0x20).get();
              r0 = CPU.orrT(r0, r1);
              MEMORY.ref(1, r2).setu(r0);
            }

            //LAB_80fb1e6
            r0 = CPU.movT(0xc0);
            r1 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
            r0 = CPU.andT(r0, r1);
            r1 = CPU.addT(r4, 0x0);
            r1 = CPU.addT(r1, 0x21);
            r1 = MEMORY.ref(1, r1).getUnsigned();
            r0 = CPU.addT(r1, r0);
            MEMORY.ref(1, r4 + 0x1a).setu(r0);
            r2 = CPU.movT(0xff);
            r0 = CPU.andT(r0, r2);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.ref(1, r1).setu(r0);
          }

          //LAB_80fb1fe
          r0 = CPU.movT(0x1);
          r2 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
          r0 = CPU.andT(r0, r2);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = MEMORY.ref(4, 0x80fb248).get();
            r0 = MEMORY.ref(1, r1).getUnsigned();
            r2 = MEMORY.ref(1, r4 + 0x1c).getUnsigned();
            r0 = CPU.bicT(r0, r2);
            r2 = MEMORY.ref(1, r4 + 0x1b).getUnsigned();
            r0 = CPU.orrT(r0, r2);
            MEMORY.ref(1, r1).setu(r0);
            CPU.cmpT(r6, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r0 = MEMORY.ref(4, 0x80fb24c).get();
              r1 = MEMORY.ref(1, r4 + 0x9).getUnsigned();
              r0 = CPU.addT(r1, r0);
              r0 = MEMORY.ref(1, r0).getUnsigned();
              r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              MEMORY.ref(1, r2).setu(r0);
              r1 = CPU.movT(0x80);
              r0 = CPU.addT(r1, 0x0);
              r2 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
              r0 = CPU.andT(r0, r2);
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(1, r0).setu(r1);
                r0 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                MEMORY.ref(1, r1).setu(r0);
                r0 = CPU.movT(0x7f);
                r2 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
                r0 = CPU.andT(r0, r2);
                MEMORY.ref(1, r4 + 0x1a).setu(r0);
              }
            } else {
              //LAB_80fb250
              r0 = CPU.movT(0xf);
              r1 = CPU.r8().value;
              r1 = CPU.andT(r1, r0);
              CPU.r8().value = r1;
              r2 = MEMORY.ref(1, r4 + 0x9).getUnsigned();
              r0 = CPU.lslT(r2, 4);
              r0 += CPU.r8().value;
              r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              MEMORY.ref(1, r1).setu(r0);
              r2 = CPU.movT(0x80);
              r0 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
              r0 = CPU.orrT(r0, r2);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              MEMORY.ref(1, r1).setu(r0);
              CPU.cmpT(r6, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r1 = MEMORY.ref(1, r0).getUnsigned();
                r0 = CPU.movT(0x8);
                r0 = CPU.andT(r0, r1);
                CPU.cmpT(r0, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = MEMORY.ref(1, r4 + 0x1a).getUnsigned();
                  r0 = CPU.orrT(r0, r2);
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  MEMORY.ref(1, r1).setu(r0);
                }
              }
            }
          }
        }

        //LAB_80fb284
        r0 = CPU.movT(0x0);
        MEMORY.ref(1, r4 + 0x1d).setu(r0);
      }

      //LAB_80fb288
      r6 = CPU.r10().value;
      r4 = CPU.r9().value;
      CPU.cmpT(r6, 0x4);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        break;
      }
    } while(true);

    //LAB_80fb292
    CPU.sp().value += 0x1c;
    r3 = CPU.pop();
    r4 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r4;
    CPU.r10().value = r5;
  }

  @Method(0x80fb2a4)
  public static void FUN_80fb2a4(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80fb2cc)
  public static void FUN_80fb2cc(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r4 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 16);
    r7 = CPU.lsrT(r1, 16);
    r6 = CPU.lslT(r2, 16);
    r3 = MEMORY.ref(4, r4 + 0x34).get();
    r0 = MEMORY.ref(4, 0x80fb330).get();
    r3 = CPU.cmpT(r3, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r3, 0x1);
      MEMORY.ref(4, r4 + 0x34).setu(r0);
      r2 = MEMORY.ref(1, r4 + 0x8).getUnsigned();
      r1 = MEMORY.ref(4, r4 + 0x2c).get();
      r5 = CPU.movT(0x1);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = CPU.movT(0x80);
        CPU.r8().value = r0;
        r6 = CPU.lsrT(r6, 18);
        r0 = CPU.movT(0x3);
        CPU.r12().value = r0;

        //LAB_80fb2fc
        do {
          r0 = CPU.addT(r7, 0x0);
          r0 = CPU.andT(r0, r5);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(1, r1).getUnsigned();
            r0 = CPU.r8().value;
            r0 = CPU.andT(r0, r3);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              MEMORY.ref(1, r1 + 0x13).setu(r6);
              r0 = CPU.r12().value;
              r0 = CPU.orrT(r0, r3);
              MEMORY.ref(1, r1).setu(r0);
            }
          }

          //LAB_80fb316
          r2 = CPU.subT(r2, 0x1);
          r1 = CPU.addT(r1, 0x50);
          r5 = CPU.lslT(r5, 1);
          CPU.cmpT(r2, 0x0);
        } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
      }

      //LAB_80fb320
      r0 = MEMORY.ref(4, 0x80fb330).get();
      MEMORY.ref(4, r4 + 0x34).setu(r0);
    }

    //LAB_80fb324
    r3 = CPU.pop();
    r4 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r4;
  }

  @Method(0x80fb334)
  public static void FUN_80fb334(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(value = 0x80fb790, ignoreExtraParams = true)
  public static void FUN_80fb790() {
    // no-op
  }
}
