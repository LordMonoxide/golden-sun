package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct0c;
import org.goldensun.types.GraphicsStruct24;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Map194;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Actor70;

import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.fadeInBrightness;
import static org.goldensun.GoldenSun.FUN_8003f3c;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.rotVec3;
import static org.goldensun.GoldenSun.FUN_80044d0;
import static org.goldensun.GoldenSun.sqrt;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_8009008;
import static org.goldensun.GoldenSun.FUN_8009020;
import static org.goldensun.GoldenSun.FUN_8009038;
import static org.goldensun.GoldenSun.FUN_8009080;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.FUN_8009098;
import static org.goldensun.GoldenSun.FUN_80090c8;
import static org.goldensun.GoldenSun.FUN_80090d0;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_80090f0;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_8009148;
import static org.goldensun.GoldenSun.FUN_8009150;
import static org.goldensun.GoldenSun.FUN_8009158;
import static org.goldensun.GoldenSun.FUN_80091a8;
import static org.goldensun.GoldenSun.FUN_80091e0;
import static org.goldensun.GoldenSun.FUN_8009240;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars._2000434;
import static org.goldensun.GoldenSunVars._200048a;
import static org.goldensun.GoldenSunVars._2002090;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars._3001b10;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015040;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_8015050;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015100;
import static org.goldensun.GoldenSun_801.FUN_8015108;
import static org.goldensun.GoldenSun_801.FUN_8015110;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80151e0;
import static org.goldensun.GoldenSun_801.FUN_8015208;
import static org.goldensun.GoldenSun_801.FUN_8015390;
import static org.goldensun.GoldenSun_807.FUN_8077080;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770c8;
import static org.goldensun.GoldenSun_807.FUN_80770d0;
import static org.goldensun.GoldenSun_808.FUN_808ba1c;
import static org.goldensun.GoldenSun_808.FUN_808d394;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_808.FUN_808fecc;
import static org.goldensun.GoldenSun_808.FUN_808fefc;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.GoldenSun_818.FUN_8185000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_809 {
  private GoldenSun_809() { }

  @Method(0x80901c0)
  public static void FUN_80901c0(final int r0, final int r1) {

    final int r2 = (r0 >> 8) & 0xff;
    final int r6 = r0 & 0xff;

    switch(r2) {
      case 0 -> {
        fadeInBrightness(0);
        fadeOutBrightness(r1);
      }

      case 1 -> {
        FUN_8091200(0x8000, 0);
        FUN_8091254(r1);
      }

      case 2 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        FUN_80030f8(0x1);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53B).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 3 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        FUN_80907b0(0);
        FUN_80030f8(1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090658"), 0xc80);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53b).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 4 -> {
        final int r5 = FUN_808fecc();
        if(r6 == 0) {
          setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80903bc"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(r6);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(r6);
        } else {
          //LAB_8090322
          setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090488"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(0);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(0);
        }
      }
    }

    //LAB_8090352
  }

  @Method(0x80907b0)
  public static void FUN_80907b0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80908e0)
  public static void FUN_80908e0() {
    if(FUN_80770c0(0x152) != 0) {
      return;
    }

    //LAB_80908fa
    final int r6 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    if(MEMORY.ref(1, r6 + 0x2a01).get() == 0) {
      return;
    }

    //LAB_8090908
    MEMORY.ref(1, r6 + 0x2a02).incr();

    if(MEMORY.ref(1, r6 + 0x2a02).get() < MEMORY.ref(1, r6 + 0x2a01).get()) {
      //LAB_8090928
      for(int r0 = 0; r0 < 0x540; r0++) {
        MEMORY.ref(2, r6 + 0x380 + r0 * 0x2).and(MEMORY.ref(2, r6 + 0x1880 + r0 * 0x2).getUnsigned());
      }
    } else {
      //LAB_8090948
      MEMORY.call(0x3001388, r6 + 0x380, r6 + 0xe00, 0xa80); // memcpy
      MEMORY.ref(1, r6 + 0x2a01).setu(0);
    }

    //LAB_8090966
    final int r4 = r6 + 0x2300 + (MEMORY.ref(1, r6 + 0x2a00).getUnsigned() ^ 0x1) * 0x380;

    //LAB_80909a8
    for(int r0 = 0; r0 < 0x1c0; r0++) {
      final int r1 = r6 + 0x380 + r0 * 0x6;
      MEMORY.ref(2, r4 + r0 * 0x2).setu(MEMORY.ref(2, r1).getUnsigned() & 0x7c00 | (MEMORY.ref(2, r1 + 0x2).get() >> 5) & 0x3e0 | (MEMORY.ref(2, r1 + 0x4).get() >> 10) & 0x1f);
    }

    MEMORY.ref(1, r6 + 0x2a00).xoru(0x1);
    final int r2 = MEMORY.ref(1, r6 + 0x2a00).getUnsigned();

    final int oldInterrupts1 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    if(_2002090.count_00.get() < 0x20) {
      final GraphicsStruct0c r3 = _2002090._04.get(_2002090.count_00.get());
      r3._00.set(r6 + 0x2300 + r2 * 0x380);
      r3._04.set(0x5000000);
      r3._08.set(0x84000070);
      _2002090.count_00.incr();
    }

    //LAB_8090a16
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts1);

    final int oldInterrupts2 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    if(_2002090.count_00.get() < 0x20) {
      final GraphicsStruct0c r3 = _2002090._04.get(_2002090.count_00.get());
      r3._00.set(r6 + 0x24c0 + r2 * 0x380);
      r3._04.set(0x5000200);
      r3._08.set(0x84000070);
      _2002090.count_00.incr();
    }

    //LAB_8090a42
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts2);

    //LAB_8090a44
  }

  @Method(0x809088c)
  public static void FUN_809088c(final int r0, final int r1, final int r2, final int r3) {
    if(r3 > 0) {
      //LAB_80908a8
      for(int i = 0; i < 0x540; i++) {
        MEMORY.ref(2, r2 + i * 0x2).setu((int)MEMORY.call(0x3000380, MEMORY.ref(2, r1 + i * 0x2).get() - MEMORY.ref(2, r0 + i * 0x2).get(), r3));
      }
    }

    //LAB_80908ca
  }

  @Method(0x8090a5c)
  public static void FUN_8090a5c(int r0, int r1, final int r2, final int r3) {
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;

    r10 = r1;
    r8 = r2;
    CPU.sp().value -= 0x28;
    int count = 0x1c0;
    if(r0 == 0x8000) {
      r0 = MEMORY.ref(2, 0x5000000).getUnsigned();
    }

    //LAB_8090a86
    if(r3 == 1) {
      count = 0xe0;
      //LAB_8090a90
    } else if(r3 == 2) {
      r8 += 0x540;
      count = 0xe0;
      r10 += 0x1c0;
    }

    //LAB_8090aa4
    if(r0 >= 0 && r0 < 0x8000) {
      MEMORY.ref(2, r8).setu(r0 & 0x7c00);
      r8 += 0x2;
      MEMORY.ref(2, r8).setu((r0 & 0x3e0) << 5);
      r8 += 0x2;
      MEMORY.ref(2, r8).setu((r0 & 0x1f) << 10);
      r8 += 0x2;
      DMA.channels[3].SAD.setu(r8 - 0x6);
      DMA.channels[3].DAD.setu(r8);
      DMA.channels[3].CNT.setu(0x80000000 | (count - 1) * 6 / 2);
      //LAB_8090afe
    } else if(r0 < 0 || r0 >= 0x100000) {
      //LAB_8090f3e
      if((r0 & 0x200000) != 0) {
        final int sp20 = r0 & 0x1f;
        final int sp1c = r0 >>> 5 & 0x1f;
        final int r11 = r0 >>> 10 & 0x1f;

        //LAB_8090f6e
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10).getUnsigned();
          r10 += 0x2;
          r4 = (int)MEMORY.call(0x3000380, (r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 0x60);
          MEMORY.ref(2, r8).setu(FUN_80912a8(r11 * r4));
          MEMORY.ref(2, r8 + 0x2).setu(FUN_80912a8(sp1c * r4));
          MEMORY.ref(2, r8 + 0x4).setu(FUN_80912a8(sp20 * r4));
          r8 += 0x6;
        }
        //LAB_8090fde
      } else if((r0 & 0x400000) != 0) {
        //LAB_8090fea
        final int sp18 = r0 & 0x1f;
        final int sp14 = r0 >>> 5 & 0x1f;
        final int r11 = r0 >>> 10 & 0x1f;

        //LAB_8091010
        final int sp10 = sp18 + sp14;
        final int sp0c = sp18 << 16;
        final int sp08 = sp14 << 16;
        final int sp04 = r11 << 16;

        //LAB_8091028
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10).getUnsigned();
          r10 += 0x2;
          r4 = (int)MEMORY.call(0x3000380, (r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f) << 4, sp10 + r11);
          r7 = (int)MEMORY.call(0x3000118, sp18 * r4 >>> 4 << 16, sp0c >> 4);
          r6 = (int)MEMORY.call(0x3000118, sp14 * r4 >>> 4 << 16, sp08 >> 4);
          r5 = (int)MEMORY.call(0x3000118, r11 * r4 >>> 4 << 16, sp04 >> 4);
          r7 = FUN_8091294(r7 >>> 16);
          r6 = FUN_8091294(r6 >>> 16);
          r5 = FUN_8091294(r5 >>> 16);
          MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
          r8 += 0x2;
          MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
          r8 += 0x2;
          MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
          r8 += 0x2;
        }
      } else if((r0 & 0x800000) != 0) {
        r1 = r8;

        //LAB_8091114
        for(int i = 0; i < count; i++) {
          r4 = MEMORY.ref(2, r10).getUnsigned();
          r10 += 0x2;
          MEMORY.ref(2, r1).setu(r4 & 0x7c00);
          MEMORY.ref(2, r1 + 0x2).setu((r4 & 0x3e0) << 5);
          MEMORY.ref(2, r1 + 0x4).setu((r4 & 0x1f) << 10);
          r1 += 0x6;
        }
      } else {
        //LAB_809113e
        if(r3 == 2) {
          r0 = r0 + 0x540;
        }

        //LAB_8091148
        DMA.channels[3].SAD.setu(r0);
        DMA.channels[3].DAD.setu(r8);
        DMA.channels[3].CNT.setu(0x84000000 | count * 3 / 0x4);
      }
    } else {
      //LAB_8090b08
      //LAB_8090b12
      switch(r0 - 0x10001) {
        case 0:
          //LAB_8090b44
          r5 = r8;

          //LAB_8090b48
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            r4 = (int)MEMORY.call(0x3000380, (r4 << 11 & 0xf800) + (r4 << 7 & 0x1f000) + (r4 & 0x7c00), 0x7);
            MEMORY.ref(2, r5).setu(r4);
            MEMORY.ref(2, r5 + 0x2).setu(r4);
            MEMORY.ref(2, r5 + 0x4).setu(r4);
            r5 += 0x6;
          }
          break;

        case 1:
          //LAB_8090b92
          //LAB_8090b98
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            r4 = (int)MEMORY.call(0x3000380, (r4 & 0x1f) + (r4 >>> 5 & 0x1f) + (r4 >>> 10 & 0x1f), 0xa);
            r6 = r4 * 4 + 5;
            r5 = r4 * 3 + 5;
            r7 = r5;
            if(r6 < 0x8) {
              r6 = 0x8;
            }

            //LAB_8090bd4
            // This condition seems bugged in retail, it was partially merged with the subsequent condition and checked the wrong var
            if(r7 < 0x8) {
              r7 = 0x8;
            }

            if(r5 < 0x8) {
              r5 = 0x8;
            }

            //LAB_8090be0
            if(r6 > 0x1c) {
              r6 = 0x1c;
            }

            //LAB_8090be6
            if(r7 > 0x1c) {
              r7 = 0x1c;
            }

            //LAB_8090bec
            if(r5 > 0x1c) {
              r5 = 0x1c;
            }

            //LAB_8090bf2
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e96e + r5 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e96e + r6 * 0x2).getUnsigned());
            r8 += 0x2;
          }
          break;

        case 2:
          //LAB_8090c2e
          //LAB_8090c32
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r10 += 0x2;
            if((r6 | r7 | r5) != 0) {
              r6 = r6 - (r6 >>> 1);
              r7 = r7 - divideS(r7, 0x3);
              r6 = FUN_8091294(r6 + 0xa);
              r7 = FUN_8091294(r7 + 0x8);
              r5 = FUN_8091294(r5 - 0x7);
            }

            //LAB_8090c7e
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
            r8 += 0x2;
          }
          break;

        case 3:
          //LAB_8090cc0
          //LAB_8090cc4
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            if(r6 < 0xa) {
              r6 = 0xa;
            }

            //LAB_8090ce0
            if(r7 < 0x10) {
              r7 = 0x10;
            }

            //LAB_8090ce6
            if(r5 < 0x10) {
              r5 = 0x10;
            }

            //LAB_8090cec
            if(r6 > 0x1c) {
              r6 = 0x1c;
            }

            //LAB_8090cf2
            if(r7 > 0x18) {
              r7 = 0x18;
            }

            //LAB_8090cf8
            if(r5 > 0x1a) {
              r5 = 0x1a;
            }

            //LAB_8090cfe
            r6 = FUN_8091294(r6);
            r7 = FUN_8091294(r7 + 0x2);
            r5 = FUN_8091294(r5 + 0x2);
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
            r8 += 0x2;
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
            r8 += 0x2;
            r10 += 0x2;
          }
          break;

        case 4:
          //LAB_8090d5a
          //LAB_8090d5e
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            r6 = r4 & 0x1f;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r0 = FUN_8091294(divideS(r6 + r7 + r5, 0x3));
            r6 = FUN_8091294(r6 / 2 + r0);
            r7 = FUN_8091294(r7 / 2 + r0);
            r5 = FUN_8091294(r5 / 2 + r0);
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x2).setu(MEMORY.ref(2, 0x809e9ae + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x4).setu(MEMORY.ref(2, 0x809e9ae + r6 * 0x2).getUnsigned());
            r8 += 0x6;
          }
          break;

        case 5:
          //LAB_8090ddc
          //LAB_8090de0
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r6 = FUN_8091294((r4 & 0x1f) + r7 / 8 + r5 / 8);
            r7 = r7 - divideS(r7, 0x3);
            r5 = r5 - divideS(r5, 0x3);
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e92e + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x2).setu(MEMORY.ref(2, 0x809e92e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x4).setu(MEMORY.ref(2, 0x809e96e + r6 * 0x2).getUnsigned());
            r8 += 0x6;
          }
          break;

        case 6:
          //LAB_8090e70
          //LAB_8090e74
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            r7 = r4 >>> 5 & 0x1f;
            r5 = r4 >>> 10 & 0x1f;
            r6 = r4 & 0x1f;
            r6 = r6 - (r6 >>> 1);
            r7 = r7 - divideS(r7, 0x3);
            r6 = FUN_8091294(r6 + 0x6);
            r7 = FUN_8091294(r7 + 0x4);
            r5 = FUN_8091294(r5 - 0x6);
            MEMORY.ref(2, r8).setu(MEMORY.ref(2, 0x809e9ae + r5 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x2).setu(MEMORY.ref(2, 0x809e96e + r7 * 0x2).getUnsigned());
            MEMORY.ref(2, r8 + 0x4).setu(MEMORY.ref(2, 0x809e92e + r6 * 0x2).getUnsigned());
            r8 += 0x6;
          }
          break;

        default:
          //LAB_8090ef0
          r1 = r8;

          //LAB_8090f14
          for(int i = 0; i < count; i++) {
            r4 = MEMORY.ref(2, r10).getUnsigned();
            r10 += 0x2;
            MEMORY.ref(2, r1).setu(r4 & 0x7c00);
            MEMORY.ref(2, r1 + 0x2).setu((r4 & 0x3e0) << 5);
            MEMORY.ref(2, r1 + 0x4).setu((r4 & 0x1f) << 10);
            r1 += 0x6;
          }
          break;
      }
    }

    //LAB_809115e
    CPU.sp().value += 0x28;
  }

  @Method(0x8091174)
  public static void FUN_8091174() {
    final int addr = mallocSlotBoard(32, 0x2a04);

    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x85000a81);
    CPU.sp().value += 0x4;

    DMA.channels[3].SAD.setu(0x5000000);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000070);

    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(addr + 0x1c0);
    DMA.channels[3].CNT.setu(0x84000070);

    FUN_8090a5c(0x10000, addr, addr + 0xe00, 0);
    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80908e0"), 0xc8f);
  }

  @Method(0x8091200)
  public static void FUN_8091200(final int r0, final int r1) {
    final int r1_0 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();

    if(r1_0 != 0) {
      FUN_8090a5c(r0, r1_0, r1_0 + 0xe00, r1);
    }

    //LAB_8091218
  }

  @Method(0x8091220)
  public static void FUN_8091220(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091240)
  public static void FUN_8091240(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091254)
  public static void FUN_8091254(final int r0) {
    final int r4 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    if(r4 != 0) {
      MEMORY.ref(1, r4 + 0x2a01).setu(r0);
      MEMORY.ref(1, r4 + 0x2a02).setu(0);
      FUN_809088c(r4 + 0x380, r4 + 0xe00, r4 + 0x1880, r0);
    }

    //LAB_8091286
  }

  @Method(0x8091294)
  public static int FUN_8091294(final int r0) {
    return MathHelper.clamp(r0, 0, 0x1f);
  }

  @Method(0x80912a8)
  public static int FUN_80912a8(final int r0) {
    return Math.min(r0, 0x7c00);
  }

  @Method(0x8091560)
  public static int FUN_8091560(int r0) {
    int r1;
    final int r2;
    int r3;

    r2 = CPU.addT(r0, 0x0);
    r0 = 0x809e9f0;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_809156e
      do {
        r1 = CPU.addT(r1, 0x1);
        r0 = CPU.addT(r0, 0x4);
        CPU.cmpT(r1, 0x81);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_809157c
    return r0;
  }

  @Method(0x80915ac)
  public static int FUN_80915ac(final int r0) {
    if(MEMORY.ref(1, 0x200044a).getUnsigned() == 0) {
      return 0;
    }

    final int r0_0 = MEMORY.ref(1, FUN_8091560(r0) + 0x2).getUnsigned();
    if(r0_0 == 0xff) {
      //LAB_80915c4
      return 0;
    }

    //LAB_80915c8
    //LAB_80915ce
    return r0_0 + 0x100;
  }

  @Method(0x80915ec)
  public static void FUN_80915ec() {
    final int r1;
    int r2;
    int r3;

    r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r3 = _3001f54.get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x80);
      r3 = pressedButtons_3001c94.get();
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xe6);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r1, r3);
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_8091612
      r3 = pressedButtons_3001c94.get();
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xe6);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r1, r3);
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.negT(r3, r3);
        MEMORY.ref(4, r2).setu(r3);
      }
    }

    //LAB_809162a
  }

  @Method(0x809163c)
  public static void FUN_809163c(final int r0) {
    if(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x1cc).get() == 0 && r0 != 0) {
      FUN_80030f8(r0);
    }

    //LAB_8091656
  }

  @Method(0x8091660)
  public static void FUN_8091660() {
    final Actor70 r0 = FUN_808ba1c(_2000434.get());
    r0.velocity_24.setX(0);
    r0.velocity_24.setZ(0);
    r0._30.set(0x10000);
    r0._34.set(0x8000);
    r0.dest_38.setX(0x80000000);
    r0.dest_38.setZ(0x80000000);

    if(_2000432.get() == 1) {
      FUN_8009080(r0, 0xc);
    } else {
      //LAB_809169e
      FUN_8009080(r0, 0x1);
    }

    //LAB_80916a4
  }

  @Method(0x80916b0)
  public static void FUN_80916b0() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_8015208();
    FUN_8091660();
    r2 = 0xcb6;
    r3 = CPU.addT(r6, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_808e118();
    }

    //LAB_80916ce
    r2 = 0xcc2;
    r5 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r6, r2);
    r2 = CPU.addT(r2, 0x2);
    MEMORY.ref(2, r3).setu(r5);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(2, r3).setu(r5);
    r3 = CPU.movT(0, 0xe4);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x10);
    MEMORY.ref(4, r2).setu(r3);
    r2 = CPU.movT(0, 0xe6);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(4, r3).setu(r5);
    r3 = CPU.movT(0, 0xed);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    MEMORY.ref(2, r2).setu(0xffff);
    r3 = CPU.movT(0, 0xee);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.movT(0, 0xef);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r1 = CPU.movT(0, 0xc8);
    MEMORY.ref(2, r2).setu(r3);
    r1 = CPU.lslT(r1, 4);
    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80915ec"), r1);
    r0 = CPU.movT(0, 0x99);
    r0 = CPU.lslT(r0, 1);
    FUN_80770d0(r0);
    r2 = CPU.movT(0, 0xfa);
    r2 = CPU.lslT(r2, 1);
    r3 = MEMORY.ref(4, 0x2000240 + r2).get();
    MEMORY.ref(4, r6 + r2).setu(r3);
    r2 = CPU.addT(r2, 0x4);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(4, r3).setu(r5);
  }

  @Method(0x80919d8)
  public static int FUN_80919d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091a58)
  public static int FUN_8091a58(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091c44)
  public static void FUN_8091c44(final int r0, final int r1) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      if(r0_0._54.get() == 1) {
        final Sprite38 r3 = r0_0.sprite_50.deref();
        int r5 = 0;

        FUN_80030f8(0x1);

        //LAB_8091c66
        //LAB_8091c64
        while(r1 == r3._24.get()) {
          r5++;

          if(r5 > 0x59) {
            break;
          }
          FUN_80030f8(0x1);
        }
      }
    }

    //LAB_8091c76
  }

  /** Opening cutscene just before leaving the house */
  @Method(0x8091c7c)
  public static int FUN_8091c7c(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x8091d78).get();
    CPU.r8().value = r0;
    r6 = MEMORY.ref(4, r3).get();
    r0 = CPU.movT(0, 0xfa);
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r6, r0);
    r0 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    CPU.r9().value = r1;
    r0 = FUN_808d394(r0);
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r0 + r2).get();
    r0 = CPU.movT(0, 0xfc);
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r6, r0);
    r3 = MEMORY.ref(4, r3).get();
    CPU.r11().value = r1;
    r1 = CPU.movT(0, 0xfe);
    r1 = CPU.lslT(r1, 1);
    r2 = CPU.movT(0, 0x1);
    CPU.r10().value = r3;
    r3 = CPU.addT(r6, r1);
    r5 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r2 = MEMORY.ref(4, 0x8091d7c).get();
    r3 = MEMORY.ref(4, r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r7 = CPU.addT(r2, 0x0);

      //LAB_8091cc6
      do {
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r3 = MEMORY.ref(4, r7).get();
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8091cd4
    //LAB_8091cda
    while(FUN_8015048() == 0) {
      r0 = CPU.movT(0, 0x1);
      FUN_80030f8(r0);
    }

    r0 = CPU.movT(0, 0x3);
    FUN_80030f8(r0);
    r3 = CPU.r9().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.r10().value;
      r2 = MEMORY.ref(2, r0 + 0xe).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0xa).getUnsigned();
      r1 = CPU.addT(r2, r3);
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
        r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
        r2 = CPU.addT(r2, r3);
        r1 = CPU.cmpT(r1, r2);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = CPU.addT(r2, 0x0);
        }
      }

      //LAB_8091d06
      CPU.cmpT(r1, 0xf);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r1 = CPU.movT(0, 0x0);
        MEMORY.ref(4, CPU.sp().value).setu(r1);
      }
    }

    //LAB_8091d0e
    r2 = MEMORY.ref(4, 0x8091d80).get();
    r3 = CPU.addT(r6, r2);
    r2 = CPU.addT(r2, 0x2);
    r0 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r0).get();
    r3 = CPU.addT(r6, r2);
    r0 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(2, r3 + r0).get();
    r0 = MEMORY.ref(4, CPU.sp().value).get();
    r3 = CPU.movT(0, 0x0);
    r0 = FUN_8015390(r0, r1, r2, r3);
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x4);
      r0 = CPU.r8().value;
      FUN_80924d4(r0, r1);
      r0 = CPU.r11().value;
      FUN_8015100(r0);
      FUN_8015140();
      r0 = CPU.r8().value;
      r1 = CPU.movT(0, 0x4);
      FUN_8091c44(r0, r1);
    } else {
      //LAB_8091d48
      r1 = CPU.movT(0, 0x3);
      r0 = CPU.r8().value;
      FUN_80924d4(r0, r1);
      r0 = CPU.r11().value;
      FUN_8015100(r0);
      FUN_8015140();
      r0 = CPU.r8().value;
      r1 = CPU.movT(0, 0x3);
      FUN_8091c44(r0, r1);
    }

    //LAB_8091d62
    r0 = CPU.addT(r5, 0x0);
    CPU.sp().value += 0x4;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r0;
  }

  @Method(0x8091dc8)
  public static void FUN_8091dc8() {
    final int r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_808fefc(MEMORY.ref(4, r5 + 0x1c0).get(), MEMORY.ref(4, r5 + 0x1c8).get());
    MEMORY.ref(2, r5 + 0x1c6).setu(0x1);
  }

  /** Called after confirming character names */
  @Method(0x8091df4)
  public static void FUN_8091df4() {
    final int r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_80901c0(MEMORY.ref(4, r5 + 0x1c0).get(), MEMORY.ref(4, r5 + 0x1c8).get());
    MEMORY.ref(2, r5 + 0x1c6).setu(0);
  }

  @Method(0x8091e20)
  public static void FUN_8091e20() {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x1c8;
    FUN_80030f8(MEMORY.ref(4, r3).get());
  }

  @Method(0x8091e3c)
  public static void FUN_8091e3c(final int r0, final int r1) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x170;
    MEMORY.ref(2, r3).setu(999);
    MEMORY.ref(2, 0x2000400).setu(r0);
    MEMORY.ref(2, 0x2000402).setu(r1);
  }

  @Method(0x8091e9c)
  public static void FUN_8091e9c(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x170;
    MEMORY.ref(2, r3).setu(r0);
  }

  @Method(0x809202c)
  public static void FUN_809202c() {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0xcc8;
    final int r0 = MEMORY.ref(2, r3).get();
    if(r0 != -1) {
      FUN_80f9010(r0);
    }

    //LAB_8092046
  }

  @Method(0x8092054)
  public static Actor70 FUN_8092054(final int r0) {
    return FUN_808ba1c(r0);
  }

  @Method(0x8092064)
  public static void FUN_8092064(final int r0, final int r1, final int r2) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      r0_0._34.set(r2);
      r0_0._30.set(r1);
    }

    //LAB_8092076
  }

  @Method(0x809207c)
  public static void FUN_809207c(final int r0, final int r1) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      r0_0._5a.or(0x1);
      FUN_8093a6c(r0_0, r1);
    }

    //LAB_809209a
  }

  @Method(0x80920e8)
  public static void FUN_80920e8(final int r0) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      FUN_8009148(r0_0);
    }

    //LAB_80920f6
  }

  @Method(0x80920fc)
  public static void FUN_80920fc(final int r0, final int r1) {
    final Actor70 r5 = FUN_808ba1c(r0);
    if(r5 != null) {
      r5._5a.or(0x1);
      FUN_8093a6c(r5, r1);
      FUN_8009148(r5);
    }

    //LAB_8092122
  }

  @Method(0x8092158)
  public static void FUN_8092158(final int r0, final int r1, final int r2) {
    final Actor70 r5 = FUN_808ba1c(r0);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      FUN_8009150(r5, r1 << 16, r5.pos_08.getY(), r2 << 16);
      FUN_8009158(r5);
    }

    //LAB_8092186
  }

  @Method(0x809218c)
  public static void FUN_809218c(final int r0, final int r1, final int r2) {
    final Actor70 r5 = FUN_808ba1c(r0);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      FUN_8009080(r5, 0x2);
      FUN_8009150(r5, r1 << 16, r5.pos_08.getY(), r2 << 16);
    }

    //LAB_80921bc
  }

  @Method(0x80921c4)
  public static void FUN_80921c4(final int r0, final int r1, final int r2) {
    final Actor70 r5 = FUN_808ba1c(r0);
    if(r5 != null) {
      r5._5b.set(0);
      FUN_8009140(r5);
      FUN_8009080(r5, 0x2);
      FUN_8009150(r5, r1 << 16, r5.pos_08.getY(), r2 << 16);
      FUN_8009158(r5);
      FUN_8009080(r5, 0x1);
    }

    //LAB_8092202
  }

  @Method(0x80923e4)
  public static void FUN_80923e4(int r0, final int x, final int z) {
    final Actor70 r5 = FUN_808ba1c(r0);
    if(r5 != null) {
      FUN_8009140(r5);
      r5.pos_08.setX(x);
      r5.pos_08.setZ(z);
      r5.velocity_24.zero();
      r5.dest_38.setX(0x80000000);
      r5.dest_38.setY(0x80000000);

      if((r5._55.get() & 0x1) != 0) {
        r0 = FUN_80091a8(r5.layer_22.get(), x / 0x10000, z / 0x10000) << 16;
        r5.pos_08.y_04.sub(r5._14.get()).add(r0);
        r5._14.set(r0);
      }
    }

    //LAB_809244a
  }

  @Method(0x80924d4)
  public static void FUN_80924d4(final int r0, final int r1) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      FUN_8009080(r0_0, r1);
    }

    //LAB_80924e6
  }

  @Method(0x8092504)
  public static void FUN_8092504(final int r0) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      if(r0_0._54.get() == 1) {
        final Sprite38 r3 = r0_0.sprite_50.deref();
        final int sp00 = r3._24.get();

        int r5 = 0;
        FUN_80030f8(0x1);

        //LAB_809252a
        while(sp00 == r3._24.get()) {
          r5++;

          //LAB_809252c
          if(r5 >= 90) {
            break;
          }
          FUN_80030f8(0x1);
        }
      }
    }

    //LAB_809253e
  }

  @Method(0x8092548)
  public static void FUN_8092548(final int r0, final int r1) {
    FUN_80924d4(r0, r1);
    FUN_8092504(r0);
  }

  @Method(0x8092560)
  public static void FUN_8092560(final int r0, final int r1, final int r2) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      r0_0._55.or(0x2);
      r0_0.velocity_24.setY(r1 << 16);

      if(r1 > 5) {
        FUN_80f9010(0x99);
      } else {
        //LAB_809258a
        FUN_80f9010(0x98);
      }

      //LAB_8092590
      FUN_809163c(r2);
    }

    //LAB_8092596
  }

  @Method(0x809259c)
  public static void FUN_809259c(final int r0, final int r1) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null && r1 > 0) {
      //LAB_80925b2
      FUN_8009098(r0_0, 0x809ebfc + (3 - Math.min(r1, 3)) * 0x80);
    }

    //LAB_80925c0
  }

  @Method(0x80925cc)
  public static void FUN_80925cc(final int r0, final int r1) {
    FUN_809259c(r0, r1);
    FUN_80920e8(r0);
  }

  @Method(0x8092848)
  public static void FUN_8092848(final int r0, final int r1, final int r2) {
    final Actor70 r6 = FUN_808ba1c(r0);
    final Actor70 r1_0 = FUN_808ba1c(r1);
    if(r6 != null) {
      if(r1_0 != null) {
        FUN_8092878(r6, r1_0);
        FUN_809163c(r2);
      }
    }

    //LAB_8092870
  }

  @Method(0x8092878)
  public static void FUN_8092878(final Actor70 r0, final Actor70 r1) {
    if(r0 != null && r1 != null) {
      final int r7 = FUN_80044d0(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX());
      final int r8 = r7 + 0x8000;
      int r4 = 0;

      //LAB_80928aa
      do {
        int r3 = (short)(r7 - r0.angle_06.get());

        int r1_0 = 2;
        if(r3 != 0) {
          //LAB_80928cc
          r0.angle_06.add(MathHelper.clamp(r3, -0x1000, 0x1000));
        } else {
          //LAB_80928d2
          r1_0--;
        }

        //LAB_80928d4
        r3 = (short)(r8 - r1.angle_06.get());
        if(r3 != 0) {
          //LAB_80928f6
          r1.angle_06.add(MathHelper.clamp(r3, -0x1000, 0x1000));
        } else {
          //LAB_80928fc
          r1_0--;
        }

        //LAB_80928fe
        if(r1_0 == 0) {
          break;
        }

        FUN_80030f8(0x1);
        r4++;
      } while(r4 < 60);
    }

    //LAB_8092912
  }

  @Method(0x8092950)
  public static void FUN_8092950(final int r0, final int r1) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      if((r1 & 0x100) != 0) {
        r0_0._6c.set(getConsumer(GoldenSun_809.class, "FUN_8092980", Actor70.class));
      } else {
        //LAB_809296c
        r0_0._6c.clear();
        FUN_80929d8(r0_0, r1);
      }
    }

    //LAB_8092974
  }

  @Method(0x80929d8)
  public static void FUN_80929d8(final Actor70 r0, final int r1) {
    if((r0._54.get() & 0xf) == 1) {
      final Sprite38 r12 = r0.sprite_50.deref();

      //LAB_80929fc
      for(int i = 0; i < r12.layerCount_27.get(); i++) {
        final SpriteLayer18 r2 = r12.layers_28.get(i).derefNullable();

        if(r2 != null && r2._10.get() != 0) {
          r2._05.set(r1);
        }

        //LAB_8092a0a
      }

      //LAB_8092a10
      r12._25.set(0x1);
    }

    //LAB_8092a18
  }

  @Method(0x8092a74)
  public static int FUN_8092a74(final Actor70 r0) {
    if(r0 == null) {
      return 0;
    }

    int r0_0 = (short)(r0._64.get() - r0.angle_06.get());

    if(r0_0 == 0) {
      return 0;
    }

    if(r0_0 > 0x1000) {
      r0_0 = 0x800;
    }

    //LAB_8092a9c
    if(r0_0 < -0x1000) {
      r0_0 = -0x800;
    }

    //LAB_8092aa4
    r0.angle_06.add(r0_0);

    //LAB_8092aa8
    return r0_0;
  }

  @Method(0x8092adc)
  public static void FUN_8092adc(final int r0, final int r1, final int r2) {
    final Actor70 r0_0 = FUN_808ba1c(r0);
    if(r0_0 != null) {
      r0_0._64.set(r1);
      FUN_8009098(r0_0, 0x809fc1c);
      FUN_809163c(r2);
    }

    //LAB_8092afc
  }

  @Method(0x8092b08)
  public static void FUN_8092b08(final int r0, final int r1) {
    final Actor70 r6 = FUN_808ba1c(r0);
    if(r6 != null) {
      if((r6._54.get() & 0xf) == 1) {
        final int r5 = r1 & 0x3;
        final Sprite38 r1_0 = r6.sprite_50.deref();
        r1_0.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r5 << 10);
        r1_0.shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r5 << 10);
        r6.flags_23.and(0xfe);
      }
    }

    //LAB_8092b4e
  }

  @Method(0x8092b94)
  public static void FUN_8092b94(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x1d8;
    MEMORY.ref(2, r3).setu(r0);
  }

  @Method(0x8092ba8)
  public static int FUN_8092ba8(final int r0) {
    final int r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x14 + (r0 & 0xfff) * 0x4).get();

    if(r2 == 0 || MEMORY.ref(1, r2 + 0x54).getUnsigned() != 1) {
      return -1;
    }

    //LAB_8092bd2
    return MEMORY.ref(4, r2 + 0x50).deref(4).offset(0x28).deref(2).get();
  }

  @Method(0x8092c40)
  public static GraphicsStruct24 FUN_8092c40(int r0) {
    final int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    final int r11;

    CPU.sp().value -= 0x40;

    final int sp20 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r6 = r0;
    final int sp1c = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    GraphicsStruct24 r10 = null;
    GraphicsStruct24 r9 = null;
    int sp14 = 0;
    int sp10 = 0;
    int sp0c = 0x4;
    int sp18 = FUN_8092ba8(r6);
    r11 = r6 & 0xf000;
    r6 = r6 & 0xfff;
    r8 = MEMORY.ref(2, sp1c + 0x1d8).get();
    r0 = FUN_808ba1c(r6).getAddress(); //TODO
    MEMORY.ref(4, sp1c + 0x1f4).setu(r6);
    r5 = 0;
    r7 = 0;
    r4 = 0;
    if(MEMORY.ref(4, sp1c + 0x1cc).get() == 0) {
      //LAB_8092cb6
      if(r0 != 0) {
        if(MEMORY.ref(2, sp1c + 0x19e).get() == 3) {
          r5 = CPU.sp().value + 0x34;
          FUN_8005268(r0 + 8, r5);
          r4 = MEMORY.ref(4, r5).get() / 8;
          r5 = MEMORY.ref(4, r5 + 0x4).get() / 8;
          r7 = 0x1;
          r5 = r5 - 0x2;
        } else {
          //LAB_8092cde
          r5 = CPU.sp().value + 0x34;
          r0 = ~FUN_8094154(r6, r5);
          r7 = (-r0 | r0) >>> 31;
          r4 = MEMORY.ref(4, r5).get() / 8;
          r5 = MEMORY.ref(4, r5 + 0x4).get() / 8;
        }
        //LAB_8092ce6
      } else if(r6 < 8) {
        sp18 = r6;
        r0 = FUN_808ba1c(MEMORY.ref(4, 0x2000434).get()).getAddress(); //TODO
        if(MEMORY.ref(2, sp1c + 0x19e).get() == 3) {
          r5 = CPU.sp().value + 0x34;
          FUN_8005268(r0 + 8, r5);
          r4 = MEMORY.ref(4, r5).get() / 8;
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r7 = 0x1;
        } else {
          //LAB_8092d1e
          r5 = CPU.sp().value + 0x34;

          //LAB_8092d24
          r0 = ~FUN_8094154(_2000434.get(), r5);
          r7 = (-r0 | r0) >>> 31;
          r4 = MEMORY.ref(4, r5).get() / 8;
          r3 = MEMORY.ref(4, r5 + 0x4).get();
        }

        //LAB_8092d36
        r5 = r3 / 8;
      }

      //LAB_8092d38
      if(r7 == 0) {
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(0xf);
        r3 = 0xa;
      } else {
        //LAB_8092d44
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
        FUN_8015110(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r4 - MEMORY.ref(4, CPU.sp().value + 0x28).get() / 2);

        if((r11 & 0x4000) != 0) {
          r3 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() - 0x1;
        } else {
          //LAB_8092d7e
          r3 = r11 >>> 15;
          if(r3 == 0 && r5 <= 8) {
            r3 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() - 0x1;
          } else {
            //LAB_8092d92
            r3 = r5 + 0x4;
          }
        }
      }

      //LAB_8092d94
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);

      if(MEMORY.ref(1, sp20 + 0xea4).getUnsigned() != 0) {
        sp0c = 0x5;
      }

      //LAB_8092da6
      r6 = r4;
      if((r11 & 0x1000) != 0) {
        r6 = r6 - sp0c - 2;
        if(r6 < 0) {
          r6 = 0;
        }
      } else {
        //LAB_8092dc2
        if((r11 & 0x2000) != 0) {
          r6 = r6 - 2;
          if(r6 + sp0c > 0x1d) {
            r6 = 0x1d - sp0c;
          }
        } else {
          //LAB_8092dde
          if(r6 < 0x10) {
            r6 = r6 - sp0c - 2;
            if(r6 < 0) {
              r6 = r6 + 2;
            }
          } else {
            //LAB_8092df0
            r6 = r6 + 2;
            if(r6 + sp0c > 0x1d) {
              r6 = r6 - sp0c - 2;
            }
          }
        }
      }

      //LAB_8092dfe
      r7 = FUN_80151e0(sp18);
      if(r7 != -1) {
        r7 = CPU.sp().value + 0x24;
        r0 = FUN_8015110(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r8 = -1;
        sp10 = r2 - 0x5;
        if(r2 <= r5) {
          sp10 = r2 + MEMORY.ref(4, CPU.sp().value + 0x24).get();
        }

        //LAB_8092e3e
        if(sp10 < 0) {
          sp10 = r2 + MEMORY.ref(4, CPU.sp().value + 0x24).get();
          //LAB_8092e4c
        } else if(sp10 + 0x5 > 0x13) {
          sp10 = r2 - 0x5;
        }

        //LAB_8092e58
        if(r2 < sp10) {
          r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r0 = FUN_8015108(-1, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, r7);
          sp14 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() + 1;
        }
        //LAB_8092e80
      } else if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() < r5) {
        r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        r0 = FUN_8015108(r8, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        sp14 = r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() + 1;
        r8 = r7;
      }

      //LAB_8092ea2
      if(r6 < 0) {
        r6 = 0;
        //LAB_8092eaa
      } else if(r6 + sp0c > 0x1d) {
        r6 = 0x1d - sp0c;
      }

      //LAB_8092eb6
      r1 = sp20;
      if(MEMORY.ref(1, r1 + 0xea4).getUnsigned() != 0) {
        FUN_80030f8(0x8);

        if(sp14 != 0) {
          r2 = sp14 + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
          r3 = 0x12;
        } else {
          //LAB_8092edc
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x2;
        }
      } else {
        //LAB_8092ee6
        r0 = FUN_80915ac(sp18);

        if(sp14 != 0) {
          r3 = r0 << 16 | 0x11;
          r2 = sp14 + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
        } else {
          //LAB_8092f04
          r3 = r0 << 16 | 0x1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        }

        //LAB_8092f0e
      }

      //LAB_8092f10
      r10 = FUN_8015038(r8, MEMORY.ref(4, CPU.sp().value + 0x30).get(), r2, r3);
      r9 = FUN_80150f8(sp18, 0, r6, sp10);

      //LAB_8092f34
      //LAB_8092f2e
      while(FUN_8015048() == 0) {
        FUN_80030f8(1);
      }
    }

    //LAB_8092f3c
    MEMORY.ref(4, sp1c + 0x1f8).setu(r10 == null ? 0 : r10.getAddress()); //TODO
    MEMORY.ref(4, sp1c + 0x1fc).setu(r9 == null ? 0 : r9.getAddress()); //TODO
    MEMORY.ref(2, sp1c + 0x1d8).incr();

    CPU.sp().value += 0x40;

    return r10;
  }

  @Method(0x8092f84)
  public static void FUN_8092f84(final int r0, final int r1) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final GraphicsStruct24 r10 = FUN_8092c40(r0);
    FUN_80030f8(0x1);
    int r8 = FUN_8092ba8(r0);
    if(r0 < 8) {
      final int r6 = r0 & 0xfff;
      if(FUN_808d394(r6) == 0) {
        r8 = r6;
      }
    }

    //LAB_8092fc0
    FUN_8015100(r8);

    if(MEMORY.ref(4, r3 + 0x1cc).get() == 0) {
      //LAB_8092fd4
      int r5 = 0;
      while(FUN_8015050(r10) == 0) {
        FUN_80030f8(0x1);
        r5++;
        if(r5 > 600) {
          FUN_8015140();
        } else if((heldButtonsLastFrame_3001ae8.get() & 0x4) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x100) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x200) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x1) != 0) {
          //LAB_8093010
          FUN_8015140();
        }
      }
    }

    //LAB_809301e
    FUN_80030f8(0x1);
  }

  @Method(0x8093040)
  public static void FUN_8093040(final int r0, final int r1, final int r2) {
    FUN_8092f84(r0, r1);
    FUN_809163c(r2);
  }

  @Method(0x8093304)
  public static void FUN_8093304(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;

    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 24);
    r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r0 = CPU.cmpT(r0, r1);
    if(CPU.cpsr().getZero()) { // ==
      r2 = 0x12f4;
      r1 = 0x12f6;
      r3 = CPU.addT(r5, r2);
      r2 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r3).setu(r2);
    } else {
      //LAB_809331e
      r0 = FUN_8092ba8(r0);
      r0 = FUN_80915ac(r0);
      r3 = 0x2000240;
      r1 = CPU.movT(0, 0x83);
      r1 = CPU.lslT(r1, 2);
      r3 = CPU.addT(r3, r1);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r1 = 0x12f4;
      r2 = MEMORY.ref(1, 0x809fc28 + r3).getUnsigned();
      r3 = CPU.addT(r5, r1);
      r1 = CPU.addT(r1, 0x2);
      MEMORY.ref(2, r3).setu(r0);
    }

    //LAB_809333c
    r3 = CPU.addT(r5, r1);
    MEMORY.ref(2, r3).setu(r2);
  }

  @Method(0x809335c)
  public static void FUN_809335c(final int r0, final int r1) {
    final Actor70 r6 = FUN_808ba1c(r0);
    final int r8 = mallocSlotBoard(27, 0xccc);
    final Actor70 r5 = MEMORY.ref(4, r8 + 0x1e0).deref(4).cast(Actor70::new); //TODO
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    if(r6 != null) {
      r3._00.set(r5.pos_08.getAddress()); //TODO
      FUN_80090e0(r5, r6);

      if(r1 == 0) {
        r5.pos_08.set(r6.pos_08);
        FUN_80030f8(0x1);

        if(MEMORY.ref(2, r8 + 0x19e).get() != 0x3) {
          FUN_8009128();
        }
      }
    }

    //LAB_80933be
  }

  @Method(0x80933d4)
  public static void FUN_80933d4(final int r0, final int r1) {
    final int addr = mallocSlotBoard(27, 0xccc);
    final int r3 = MEMORY.ref(4, addr + 0x1e0).get();
    MEMORY.ref(4, r3 + 0x30).setu(r0);
    MEMORY.ref(4, r3 + 0x34).setu(r1);
  }

  @Method(0x80933f8)
  public static void FUN_80933f8(final int x, final int y, final int z, final int r3) {
    int r6;
    int r7;
    final int r9;
    int r10;
    final int r11;

    r6 = x;
    r10 = y;
    r7 = z;
    final int sp08 = mallocSlotBoard(27, 0xccc);
    final Actor70 r5 = MEMORY.ref(4, sp08 + 0x1e0).deref(4).cast(Actor70::new);
    final int r1_0 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final int sp04 = MEMORY.ref(4, r1_0 + 0xec).get() + 0x780000;
    final int sp00 = MEMORY.ref(4, r1_0 + 0xf0).get() + r5.pos_08.getY() + 0x600000;
    r11 = MEMORY.ref(4, r1_0 + 0xf4).get() - 0x780000;
    r9 = MEMORY.ref(4, r1_0 + 0xf8).get() + r5.pos_08.getY() - 0x400000;
    MEMORY.ref(4, r1_0).setu(r5.pos_08.getAddress()); //TODO
    FUN_8009140(r5);

    if(r6 == -1) {
      r6 = r5.pos_08.getX();
    }

    //LAB_809347a
    if(r10 == -1) {
      r10 = r5.pos_08.getY();
    }

    //LAB_8093482
    if(r7 == -1) {
      r7 = r5.pos_08.getZ();
    }

    //LAB_8093488
    if(r6 < sp04) {
      r6 = sp04;
    }

    //LAB_8093490
    if(r7 < sp00) {
      r7 = sp00;
    }

    //LAB_8093498
    if(r6 > r11) {
      r6 = r11;
    }

    //LAB_809349e
    if(r7 > r9) {
      r7 = r9;
    }

    //LAB_80934a4
    if(r3 == 0) {
      r5.pos_08.set(r6, r10, r7);
      FUN_80030f8(0x1);

      if(MEMORY.ref(2, sp08 + 0x19e).get() != 3) {
        FUN_8009128();
      }
    } else {
      //LAB_80934d0
      FUN_8009150(r5, r6, r10, r7);
    }

    //LAB_80934dc
  }

  @Method(0x8093530)
  public static void FUN_8093530() {
    FUN_8009158(MEMORY.ref(4, mallocSlotBoard(27, 0xccc) + 0x1e0).deref(4).cast(Actor70::new));
    FUN_809163c(0x2);
  }

  @Method(0x809376c)
  public static int FUN_809376c(final Actor70 r0) {
    final Actor70 r6 = r0._68.derefNullable();
    if(r6 != null) {
      r0._55.set(0);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.setY(r6.pos_08.getY() + MEMORY.ref(1, FUN_8185000(MEMORY.ref(2, FUN_808d394(r0._66.get())).get()) + 0x8).get() * 0x10000 + 0x80000);
      r0.pos_08.setZ(r6.pos_08.getZ());
      r0._14.set(r6._14.get());
    }

    //LAB_80937b0
    return 0;
  }

  @Method(0x80937b8)
  public static void FUN_80937b8(final int r0, final int r1, final int r2) {
    if((r1 & 0xff) == 6) {
      FUN_80f9010(0x6e);
    }

    //LAB_80937d4
    final Actor70 r6 = FUN_808ba1c(r0);
    if(r6 != null) {
      final Actor70 r5 = FUN_80090c8(0x15, r6.pos_08.getX(), r6.pos_08.getY(), r6.pos_08.getZ());
      if(r5 != null) {
        FUN_8009098(r5, 0x809fc2c);
        FUN_8009080(r5, r1 & 0xf);
        r5._55.set(0);
        r5._64.set(0);
        r5._66.set(r0);
        r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_809376c", Actor70.class));
        r5._68.set(r6);

        final Sprite38 sprite = r5.sprite_50.deref();
        sprite._26.set(0);

        if((r1 & 0x100) != 0) {
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
        } else {
          //LAB_809384c
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
        }
      }

      //LAB_8093860
      FUN_809163c(r2);
    }

    //LAB_8093866
  }

  @Method(0x8093874)
  public static void FUN_8093874(final int r0, final int r1) {
    final Actor70 r7 = FUN_808ba1c(r0);
    Actor70 r5 = null;
    if(r7 != null) {
      if((r1 & 0x3) != 0) {
        if((r1 & 0x3) == 2 || r7._68.isNull()) {
          //LAB_80938a2
          r5 = FUN_80090c8(0xd1, r7.pos_08.getX(), r7.pos_08.getY(), r7.pos_08.getZ());
        }

        //LAB_80938c2
        if(r5 != null) {
          if((r1 & 0x3) == 1) {
            //LAB_80938d6
            FUN_8009080(r5, 0x1);
            r7._68.set(r5);
            r5._64.set(0x1);
          } else if((r1 & 0x3) == 2) {
            //LAB_80938e8
            FUN_8009080(r5, 0x2);
            FUN_8009098(r5, 0x809fd38);
            r5._64.set(0x1);
          }

          //LAB_8093900
          r5._66.set(r0);
          r5._55.set(0);
          r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_809376c", Actor70.class));
          r5._68.set(r7);

          final Sprite38 r6 = r5.sprite_50.deref();
          r6._26.set(0);

          if((r1 & 0x100) != 0) {
            r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
          } else {
            //LAB_8093944
            r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r7.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
          }
        }
      } else {
        //LAB_80938b2
        r5 = r7._68.derefNullable();
        if(r5 != null) {
          FUN_80090d0(r5);
          r7._68.clear();
        }
      }
    }

    //LAB_8093958
  }

  @Method(0x8093a6c)
  public static void FUN_8093a6c(final Actor70 r0, int r1) {
    switch(r1 - 1) {
      case 0 -> r1 = 0x809fe00;
      case 1 -> r1 = 0x809fd44;
      case 2 -> r1 = 0x809fe10;
      case 3 -> r1 = 0x809fecc;
      case 4 -> r1 = 0x809ff18;
      case 5 -> {
        r0._68.set(FUN_8092054(MEMORY.ref(4, 0x2000434).get()));
        r1 = 0x809ff2c;
      }
    }

    //LAB_8093ac6
    FUN_8009098(r0, r1);
  }

  @Method(0x8094154)
  public static int FUN_8094154(int r0, int r1) {
    int r3;
    final int r5;
    final int r6;

    r5 = r1;
    final Actor70 r4 = FUN_808ba1c(r0);
    if(r4 == null) {
      return -1;
    }

    //LAB_8094168
    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get() + 0xe4;
    r1 = r4.pos_08.getX() - (MEMORY.ref(4, r3).get() & 0xffff0000);
    r3 = r4.pos_08.getZ() - (MEMORY.ref(4, r3 + 0x4).get() & 0xffff0000);
    r6 = r3 - r4.pos_08.getY();
    MEMORY.ref(4, r5).setu(r1 / 0x10000);
    MEMORY.ref(4, r5 + 0x4).setu(r6 / 0x10000);

    if((r4._54.get() & 0xf) == 1) {
      r0 = FUN_8185000(r4.sprite_50.deref().layers_28.get(0).deref()._00.get());
      MEMORY.ref(4, r5 + 0x4).subu(MEMORY.ref(1, r0 + 0x8).get());
    }

    //LAB_80941c6
    //LAB_80941c8
    return 0;
  }

  @Method(0x80941e0)
  public static void FUN_80941e0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8094428)
  public static int FUN_8094428() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80949a8)
  public static void FUN_80949a8() {
    final int r6 = boardWramMallocHead_3001e50.offset(30 * 0x4).get();
    final int r7 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();

    if(MEMORY.ref(2, r6 + 0x1f80).get() >= 0) {
      if(FUN_80770c0(0x166) != 0) {
        MEMORY.ref(2, r6 + 0x1f80).setu(0x80);
      }

      //LAB_80949ce
      final int r3 = (short)MEMORY.ref(2, r6 + 0x1f80).getUnsigned();
      MEMORY.ref(2, r6 + 0x1f80).decr();

      switch(r3) {
        case 0:
          if(MEMORY.ref(2, r6 + 0x1f82).get() != 0) {
            MEMORY.ref(2, r6 + 0x1f80).setu((rand() * 400 >>> 16) - (rand() * 100 >>> 16) + 150);
            if(MEMORY.ref(2, r6 + 0x1f84).get() != 0) {
              FUN_80f9010(0xac);
            } else {
              //LAB_8094a5c
              FUN_80f9010(0xab);
            }
          }

        case 5:
        case 10:
          //LAB_8094a62
          FUN_8091200(r6, 0x1);
          DMA.channels[3].SAD.setu(r6 + 0x1500);
          DMA.channels[3].DAD.setu(r7 + 0x1880);
          DMA.channels[3].CNT.setu(0x840002a0);

          MEMORY.ref(1, r7 + 0x2a01).setu(0xc);
          MEMORY.ref(1, r7 + 0x2a02).setu(0);
          break;

        case 1:
        case 6:
        case 11:
          FUN_8091200(r6 + 0xa80, 0x1);
          MEMORY.ref(1, r7 + 0x2a01).setu(0x1);
          MEMORY.ref(1, r7 + 0x2a02).setu(0);
          break;
      }
    }

    //LAB_8094aa2
  }

  @Method(0x8095160)
  public static void FUN_8095160() {
    final int r5 = mallocSlotBoard(30, 0x1f88);
    final int r3 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x850007e2);
    CPU.sp().value += 0x4;

    FUN_8090a5c(0x10003, r3, r5, 0x1);
    FUN_8090a5c(0x10005, r3, r5 + 0xa80, 0x1);
    FUN_809088c(r5 + 0xa80, r5, r5 + 0x1500, 0xc);
    FUN_8090a5c(r5, 0, r3 + 0xe00, 0x1);

    MEMORY.ref(2, r5 + 0x1f80).setu(0x258);
    MEMORY.ref(2, r5).setu(0x1);

    setTickCallback(getRunnable(GoldenSun_809.class, "FUN_80949a8"), 0xc80);
  }

  @Method(0x8095240)
  public static void FUN_8095240() {
    final int r0 = mallocSlotBoard(30, 0x1f88);
    MEMORY.ref(2, r0 + 0x1f80).setu(0xc);
    MEMORY.ref(2, r0 + 0x1f82).setu(0);
  }

  @Method(0x8095268)
  public static void FUN_8095268() {
    final int r0 = mallocSlotBoard(30, 0x1f88);
    MEMORY.ref(2, r0 + 0x1f80).setu(0x80);
    MEMORY.ref(2, r0 + 0x1f82).setu(0x1);
  }

  @Method(0x80955b0)
  public static void FUN_80955b0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095680)
  public static void FUN_8095680() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095778)
  public static void FUN_8095778(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r1 = 0x2000240;
    r0 = CPU.movT(0, 0x8d);
    r0 = CPU.lslT(r0, 2);
    r7 = CPU.addT(r1, r0);
    r3 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(2, r7 + r3).get();
    r2 = MEMORY.ref(2, r7).getUnsigned();
    r3 = CPU.movT(0, 0xf0);
    r6 = 0xfff;
    r3 = CPU.lslT(r3, 8);
    r0 = CPU.r8().value;
    r5 = CPU.andT(r5, r3);
    r6 = CPU.andT(r6, r2);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = 0x7ff;
        r2 = -300;
        r6 = CPU.andT(r6, r3);
        r3 = CPU.addT(r6, r2);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = 0x236;
          r3 = CPU.addT(r1, r0);
          r1 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r1).get();
          if(r2 <= 0 || r2 == 999) {
            //LAB_80957c0
            r0 = CPU.addT(r6, 0x0);
            r0 = CPU.subT(r0, 0xac);
            FUN_80770c8(r0);
            MEMORY.ref(2, r7).setu(r5);
          }
        }
      } else {
        //LAB_80957cc
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 5);
        r5 = CPU.cmpT(r5, r0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = 0x236;
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x1);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.addT(r6, 0x0);
            FUN_80770c8(r0);
          }

          //LAB_80957e6
          r1 = CPU.r8().value;
          MEMORY.ref(2, r7).setu(r1);
        }
      }
    } else {
      //LAB_80957ec
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r2 = 0x7ff;
        r0 = -300;
        r6 = CPU.andT(r6, r2);
        r3 = CPU.addT(r6, r0);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r6 = CPU.andT(r6, r2);
          r2 = 0x236;
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = -300;
            r5 = CPU.addT(r6, r1);
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.movT(0, 0x14);
            r0 = divideS(r0, r1);
            r1 = CPU.movT(0, 0x14);
            CPU.r8().value = r0;
            r0 = CPU.addT(r5, 0x0);
            r0 = modS(r0, r1);
            r5 = CPU.movT(0, 0x7);
            r7 = CPU.addT(r0, 0x0);

            //LAB_8095826
            jmp_8095854:
            {
              do {
                do {
                  r5++;

                  //LAB_8095828
                  if(r5 > 0x41) {
                    break jmp_8095854;
                  }
                  r0 = FUN_808d394(r5);
                } while(r0 == 0);

                r2 = CPU.movT(0, 0x2);
                r3 = MEMORY.ref(2, r0 + r2).get();
                r0 = -300;
                r3 = CPU.subT(r3, 0x30);
                r2 = CPU.addT(r6, r0);
                r3 = CPU.cmpT(r3, r2);
              } while(!CPU.cpsr().getZero()); // !=

              r0 = CPU.movT(0, 0x28);
              FUN_80030f8(r0);
              r1 = CPU.r8().value;
              r0 = CPU.addT(r5, 0x0);
              r2 = CPU.addT(r7, 0x0);
              FUN_80955b0(r0, r1, r2);
            }

            //LAB_8095854
            r1 = 0x2000240;
          }
        }
      }

      //LAB_8095856
      r3 = CPU.movT(0, 0x8d);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r1, r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_8095860
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80967e4)
  public static void FUN_80967e4(final int r0) {
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_8096810();
    } else {
      //LAB_80967f0
      CPU.cmpT(r0, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        FUN_8096960();
      } else {
        //LAB_80967fa
        CPU.cmpT(r0, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          FUN_8096ab0();
        } else {
          //LAB_8096804
          CPU.cmpT(r0, 0x3);
          if(CPU.cpsr().getZero()) { // ==
            FUN_8096af0();
          }
        }
      }
    }

    //LAB_809680c
  }

  @Method(0x8096810)
  public static void FUN_8096810() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096960)
  public static void FUN_8096960() {
    final int r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final int r1 = MEMORY.ref(2, r6 + 0x1e).get();
    final int r0 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final int r5 = MEMORY.ref(2, r6 + 0x1a).get();
    MEMORY.ref(1, r6 + 0x20).setu(0);

    //LAB_8096982
    switch(r1) {
      case 2:
        if(MEMORY.ref(2, r0 + 0xcb8).get() != 0) {
          FUN_80984c0();
        }

        //LAB_80969dc
        if(MEMORY.ref(2, 0x200048a).get() != MEMORY.ref(2, 0x20004a4).get()) {
          final int r3 = MEMORY.ref(4, r6 + 0x14).get() + 0x5b;
          MEMORY.ref(1, r3).setu(0x1);
        }

        //LAB_80969f6
        FUN_8097540(MEMORY.ref(2, r6 + 0x18).get(), r5);
        break;

      case 1:
        FUN_8097c3c(r5);
        break;

      case 7:
        FUN_8098848(r5);
        break;

      case 11:
        FUN_8099da4(r5);
        break;

      case 4:
        FUN_8098ccc(r5);
        break;

      case 5:
        FUN_80999e4(r5);
        break;

      case 6:
        FUN_8099128(r5);
        break;

      case 12:
        FUN_80985a8(r5);
        break;

      case 9:
        if(MEMORY.ref(2, 0x200048a).get() != -1) {
          FUN_809ade8();
          MEMORY.ref(2, 0x200048a).setu(0xffff);
        }

        //LAB_8096a54
        FUN_809ad90(r5);
        MEMORY.ref(2, 0x200048a).setu(r5);
        FUN_809ab98(r5);
        break;

      case 3:
        FUN_80994c0(r5);
        break;

      case 14:
        FUN_809a8b8(r5);
        break;

      case 13:
        FUN_809ae58(r5);
        break;

      case 8:
        FUN_80983a0();
        break;

      case 10:
        FUN_8099838();
        break;

      case 15:
        FUN_809b208();
        break;

      case 16:
        FUN_809b698();
        break;
    }

    //LAB_8096a92
  }

  @Method(0x8096ab0)
  public static void FUN_8096ab0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096af0)
  public static void FUN_8096af0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096c24)
  public static int FUN_8096c24() {
    int r0 = 0;

    //LAB_8096c2e
    for(int i = 0; i < 0x200; i++) {
      if(_3001810.get(i).get() == 0xff) {
        r0++;
      }

      //LAB_8096c38
    }

    return r0;
  }

  @Method(0x8096c80)
  public static Actor70 FUN_8096c80(final int r0, final int r1, final int r2, int r3) {
    final int r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final Actor70 r5 = FUN_80090c8(r0, r1, r2, r3);
    if(r5 != null) {
      if(r5._54.get() == 0) {
        FUN_80090d0(r5);
        return null;
      }

      //LAB_8096ca2
      r3 = MEMORY.ref(4, r6 + 0x10).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r5._14.set(r3);
      r5._55.set(0x4);
      r5.flags_23.set(0x4);
      r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
      FUN_80091e0(r5, 0);
      FUN_8009080(r5, 1);
    }

    //LAB_8096cce
    //LAB_8096cd0
    return r5;
  }

  @Method(0x8096cdc)
  public static void FUN_8096cdc(final Actor70 r0, final int r1, final int r2) {
    //LAB_8096cf0
    for(int r5 = 0; r5 < 0x43; r5++) {
      final Actor70 r0_0 = FUN_808ba1c(r5);
      if(r5 != _200048a.get() && r0_0 != null && r0_0.getAddress() != r0.getAddress()) {
        r0_0._5b.set(r1);
        FUN_8009088(r0_0, r2);
      }

      //LAB_8096d14
    }
  }

  @Method(0x8096d2c)
  public static void FUN_8096d2c(final Actor70 r0) {
    r0._64.incr();
    final Actor70 r6 = r0._68.deref();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      FUN_8009098(r0, 0x809f0b0);
    } else {
      //LAB_8096d4e
      final int sin = sin(angle << 10);
      r0._18.set(sin);
      r0._1c.set(sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.add((0x10000 - sin) * 5 + 0x90000);
    }

    //LAB_8096d78
  }

  @Method(0x8096d84)
  public static void FUN_8096d84(final Actor70 r0) {
    r0._64.incr();
    final Actor70 r6 = r0._68.deref();
    final int r0_0 = r0._64.get();
    if(r0_0 > 0x1f) {
      FUN_8009098(r0, 0x809f0b0);
    } else {
      //LAB_8096da6
      final int sin = sin(r0_0 << 10);
      r0._18.set(sin);
      r0._1c.set(-sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.sub((0x10000 - sin) * 5).add(0x100000);
    }

    //LAB_8096dd2
  }

  @Method(0x8096ddc)
  public static void FUN_8096ddc(final Actor70 r0) {
    final int r10 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final int sp00 = MEMORY.ref(4, r10 + 0x10).get();
    CPU.sp().value -= 0xc;

    final Actor70[] sp04 = new Actor70[2];

    //LAB_8096e04
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 r0_0 = FUN_80090c8(0x1a, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      sp04[r7] = r0_0;
      if(r0_0 != null) {
        r0_0._14.set(r0._14.get());
        final Sprite38 r5 = r0_0.sprite_50.deref();
        r0_0._55.set(0);
        r0_0._64.set(0);
        r0_0._68.set(r0);
        r0_0._1c.set(0x1999);
        r0_0._18.set(0x1999);
        if(r5 != null) {
          FUN_8009020(r5, 0);
          r5._26.set(0);
          FUN_8003f3c(r5.slot_1c.get());
          r5.slot_1c.set(MEMORY.ref(2, r10 + 0x46).getUnsigned());
          r5._1d.or(0x1);
          final int r1 = _3001b10.get(r5.slot_1c.get()).vramAddr_02.get() << 17 >>> 22;
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(r1);
          r5.packet_00.attribs_04.flags_01.and(0x3f).and(~0x20).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_8096ebc
    }

    final Actor70 r2 = sp04[0];
    r2._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096d84", Actor70.class));
    r2.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    final Actor70 r0_1 = sp04[1];
    r0_1._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096d2c", Actor70.class));
    final int r3 = MEMORY.ref(4, sp00 + 0x50).get();
    r0_1.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or((MEMORY.ref(1, r3 + 0x9).getUnsigned() & 0xc) << 8);
    r0_1.flags_23.set(0x2);

    CPU.sp().value += 0xc;
  }

  @Method(0x8096f14)
  public static void FUN_8096f14(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0) {
      FUN_8009240(r0, 0x7);
    } else {
      //LAB_8096f2c
      FUN_8009240(r0, 0);
    }

    //LAB_8096f34
    if((_3001e40.get() & 0xf) == 0) {
      FUN_8096ddc(r0);
    }

    //LAB_8096f46
  }

  @Method(0x8096f8c)
  public static void FUN_8096f8c() {
    final int r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();

    //LAB_8096f98
    for(int i = 0; i < 24; i++) {
      FUN_809b804(r3 + 0x58 + i * 0x48);
    }
  }

  @Method(0x8096fb0)
  public static void FUN_8096fb0(final int r0, final int r1) {
    final int r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    int r6 = MEMORY.ref(1, r2 + 0xcc6).get();
    final int r5;
    if(r6 == 0) {
      r5 = mallocSlotChip(56, 0x720);

      CPU.sp().value -= 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(r5);
      DMA.channels[3].CNT.setu(0x850001c8);
      CPU.sp().value += 0x4;
    } else {
      //LAB_8097004
      r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    }

    //LAB_8097006
    MEMORY.ref(2, r5 + 0x1c).setu(r0);
    MEMORY.ref(2, r5 + 0x1e).setu(MEMORY.ref(1, FUN_8077080(r0) + 0xc).getUnsigned());

    r6 = MEMORY.ref(1, r2 + 0xcc6).get();
    if(r6 == 0) {
      MEMORY.ref(2, r5 + 0x4a).setu(0x200 - FUN_8096c24());
      MEMORY.ref(1, r5 + 0x21).setu(r1);
      MEMORY.ref(1, r5 + 0x22).setu(0x1);
      MEMORY.ref(1, r5 + 0x20).setu(0x1);
      MEMORY.ref(1, r5 + 0x23).setu(0x1);
      MEMORY.ref(1, r5 + 0x71c).setu(0x1);
      MEMORY.ref(4, r5 + 0x4c).setu(r7._04.get());
      MEMORY.ref(4, r5 + 0x50).setu(r7._08.get());
      MEMORY.ref(4, r5 + 0x54).setu(r7._0c.get());

      if(MEMORY.ref(2, 0x200041a).get() == 0x35) {
        MEMORY.ref(1, r5 + 0x45).setu(0x1);
      }

      //LAB_8097086
      if(MEMORY.ref(2, 0x200041a).get() == 0x37) {
        MEMORY.ref(1, r5 + 0x45).setu(0x1);
      }

      //LAB_8097096
      FUN_80970f8(MEMORY.ref(4, 0x2000434).get(), -1);

      if(MEMORY.ref(2, r5 + 0x1e).get() != 0x8) {
        MEMORY.ref(2, r2 + 0xcc0).setu(r6);
      }

      //LAB_80970b6
      MEMORY.ref(2, r5 + 0x46).setu(FUN_8004080());
      FUN_8003fa4(MEMORY.ref(2, r5 + 0x46).get(), 0x100, 0x809c410);
      setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8096f8c"), 0xc80);
    }

    //LAB_80970d8
  }

  @Method(0x80970f8)
  public static void FUN_80970f8(final int r0, final int r1) {
    final int r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final Actor70 r7 = FUN_808ba1c((short)r0);
    final Actor70 r0_0 = FUN_808ba1c((short)r1);
    MEMORY.ref(2, r6 + 0x18).setu(r0);
    MEMORY.ref(2, r6 + 0x1a).setu(r1);
    MEMORY.ref(4, r6 + 0x10).setu(r7 == null ? 0 : r7.getAddress());
    MEMORY.ref(4, r6 + 0x14).setu(r0_0 == null ? 0 : r0_0.getAddress());
    MEMORY.ref(4, r6).setu(r7.angle_06.get() + 0x2000 & 0xc000);
    if(r0_0 != null) {
      MEMORY.ref(4, r6 + 0x38).setu(r0_0._6c.getPointer());
      MEMORY.ref(4, r6 + 0x3c).setu(r0_0._00.get());
      final SpriteLayer18 r3 = r0_0.sprite_50.deref().layers_28.get(0).deref();
      MEMORY.ref(1, r6 + 0x44).setu(r3._05.get());
      MEMORY.ref(4, r6 + 0x4).setu(r0_0.pos_08.getX());
      MEMORY.ref(4, r6 + 0x8).setu(r0_0.pos_08.getY());
      MEMORY.ref(4, r6 + 0xc).setu(r0_0.pos_08.getZ());
    } else {
      //LAB_8097152
      MEMORY.ref(4, r6 + 0x4).setu(r7.pos_08.getX());
      MEMORY.ref(4, r6 + 0x8).setu(r7.pos_08.getY());
      MEMORY.ref(4, r6 + 0xc).setu(r7.pos_08.getZ());
      rotVec3(0x100000, MEMORY.ref(4, r6).get(), r6 + 0x4);
    }

    //LAB_8097168
  }

  @Method(0x8097174)
  public static void FUN_8097174() {
    final int r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final Actor70 r0 = MEMORY.ref(4, r3 + 0x10).deref(4).cast(Actor70::new);
    r0._6c.clear();
    FUN_8009240(r0, 0);
    FUN_80030f8(0x1);
  }

  @Method(0x8097194)
  public static void FUN_8097194() {
    final int r8 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final int r11 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final Map194 r9 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    int r7 = r8 + 0x9d;
    int r6 = r8 + 0x58;
    int r5 = 0x17;

    //LAB_80971c0
    do {
      final int r3 = MEMORY.ref(1, r7).getUnsigned();
      r7 += 0x48;
      if(r3 != 0) {
        FUN_809bb34(r6);
      }

      //LAB_80971d0
      r5--;
      r6 += 0x48;
    } while(r5 >= 0);

    if(MEMORY.ref(1, r11 + 0xcc6).get() == 0) {
      r7 = 0x8096d2d; //TODO function
      final int r10 = 0x8096d85; //TODO function

      //LAB_80971ee
      for(r6 = 0; r6 < 0x1e; r6++) {
        int r3 = boardWramMallocHead_3001e50.offset(5 * 0x4).get();
        int r1 = 0;
        r5 = 0;

        //LAB_80971f6
        int r2;
        do {
          if(r5 > 0x3f) {
            break;
          }
          r2 = MEMORY.ref(4, r3 + 0x6c).get();
          if(r2 == r10) {
            //LAB_8097208
            r1 = 1;
            break;
          }
          r5++;
          r3 += 0x70;
        } while(r2 != r7);

        //LAB_809720a
        if(r1 == 0) {
          break;
        }
        FUN_80030f8(0x1);
      }

      //LAB_809721a
      MEMORY.ref(1, r11 + 0xcc7).setu(0);
      clearTickCallback(getRunnable(GoldenSun_809.class, "FUN_8096f8c"));
      FUN_8003f3c(MEMORY.ref(2, r8 + 0x46).get());

      r9._04.set(MEMORY.ref(4, r8 + 0x4c).get());
      r9._08.set(MEMORY.ref(4, r8 + 0x50).get());
      r9._0c.set(MEMORY.ref(4, r8 + 0x54).get());

      if(MEMORY.ref(2, r8 + 0x1e).get() != 0x8) {
        MEMORY.ref(2, r11 + 0xcc0).setu(0x1);
      }

      //LAB_8097256
      FUN_809202c();
      freeSlot(56);
    }

    //LAB_8097260
  }

  @Method(0x809728c)
  public static void FUN_809728c() {
    final int r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    final Actor70 r5 = MEMORY.ref(4, r6 + 0x10).deref(4).cast(Actor70::new);
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final int r7 = MEMORY.ref(2, r6 + 0x1c).get();
    FUN_8009080(r5, 0x14);
    r5.dest_38.set(r5.pos_08);
    r5.velocity_24.zero();

    if(MEMORY.ref(1, r6 + 0x22).get() != 0) {
      FUN_80f9010(0xd4);
      r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096f14", Actor70.class));
    }

    //LAB_80972da
    if(MEMORY.ref(1, r6 + 0x23).get() != 0) {
      FUN_8096cdc(r5, 1, 0);
      FUN_8015120(r7, 4);
      FUN_8015040(0x926, MEMORY.ref(1, r6 + 0x71c).get());
      FUN_8096cdc(r5, 0, 0x10);
    }

    //LAB_8097330
    if(FUN_80770c0(0x140) != 0) {
      if(MEMORY.ref(1, r6 + 0x22).get() != 0) {
        r5._6c.set(getConsumer(GoldenSun_809.class, "FUN_8096f50", Actor70.class));
      }

      //LAB_809734a
      FUN_8009080(r5, 0x15);
    } else {
      //LAB_8097354
      FUN_8097174();
    }

    //LAB_8097358
    MEMORY.ref(1, r3 + 0xcc7).setu(0x1);
  }

  @Method(0x8097384)
  public static void FUN_8097384() {
    int r5 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    final int r4 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    DMA.channels[3].SAD.setu(r5 + 0x1340);
    DMA.channels[3].DAD.setu(r4 + 0x776);
    DMA.channels[3].CNT.setu(0x84000150);

    if(MEMORY.ref(2, r4 + 0xcb8).get() == 0) {
      DMA.channels[3].SAD.setu(r5 + 0xe00);
      DMA.channels[3].DAD.setu(r4 + 0x236);
      DMA.channels[3].CNT.setu(0x84000150);
    }

    //LAB_80973bc
    DMA.channels[3].SAD.setu(r5 + 0xe00);
    DMA.channels[3].DAD.setu(r5 + 0x380);
    DMA.channels[3].CNT.setu(0x840002A0);

    r5 = _3001e40.get() & 0x7;

    if(FUN_80770c0(0x148) != 0) {
      r5 = 0;
    }

    //LAB_80973e6
    if(FUN_80770c0(0x149) != 0) {
      r5 = 0x1;
    }

    //LAB_80973f2
    if(FUN_80770c0(0x14a) != 0) {
      r5 = 0x2;
    }

    //LAB_8097400
    if(FUN_80770c0(0x14b) != 0) {
      r5 = 0x3;
    }

    //LAB_809740c
    if(FUN_80770c0(0x14c) != 0) {
      r5 = 0x4;
    }

    //LAB_809741a
    if(FUN_80770c0(0x14d) != 0) {
      r5 = 0x5;
    }

    //LAB_8097426
    if(FUN_80770c0(0x14e) != 0) {
      r5 = 0x6;
    }

    //LAB_8097434
    if(FUN_80770c0(0x14f) != 0) {
      r5 = 0x7;
    }

    //LAB_8097440
    FUN_8091200(MEMORY.ref(4, 0x80a0108 + r5 * 0x4).get(), 0x1);
    FUN_8091254(0x8);
  }

  @Method(0x809748c)
  public static void FUN_809748c() {
    final int r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();

    FUN_8091200(r5 + 0x236, 0x2);

    if(MEMORY.ref(2, r5 + 0xcb8).get() != 0) {
      FUN_8091200(0x10001, 0x1);
    } else {
      //LAB_80974b4
      FUN_8091200(r5 + 0x236, 0x1);
    }

    //LAB_80974bc
    FUN_8091254(0x8);
  }

  @Method(0x8097540)
  public static void FUN_8097540(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8097c3c)
  public static void FUN_8097c3c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80983a0)
  public static void FUN_80983a0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80984c0)
  public static void FUN_80984c0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80985a8)
  public static void FUN_80985a8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8098848)
  public static void FUN_8098848(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8098ccc)
  public static void FUN_8098ccc(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8099128)
  public static void FUN_8099128(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80994c0)
  public static void FUN_80994c0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8099810)
  public static void FUN_8099810() {
    if(MEMORY.ref(2, 0x200048c).get() != 0) {
      setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8099678"), 0xc80);
    }

    //LAB_809982c
  }

  @Method(0x8099838)
  public static void FUN_8099838() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80999e4)
  public static void FUN_80999e4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8099da4)
  public static void FUN_8099da4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809a8b8)
  public static void FUN_809a8b8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ab98)
  public static void FUN_809ab98(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ad90)
  public static void FUN_809ad90(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ade8)
  public static void FUN_809ade8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809ae58)
  public static void FUN_809ae58(final int r0) {
    FUN_809ae64();
  }

  @Method(0x809ae64)
  public static void FUN_809ae64() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r5 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    r7 = MEMORY.ref(4, r5 + 0x10).get();
    CPU.sp().value -= 0x28;
    final int sp00 = MEMORY.ref(4, r5 + 0x14).get();
    r3 = MEMORY.ref(4, r7 + 0x8).get();
    r2 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r2).setu(r3);
    r3 = MEMORY.ref(4, r7 + 0xc).get();
    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 13);
    r3 = CPU.addT(r3, r1);
    MEMORY.ref(4, r2 + 0x4).setu(r3);
    r3 = MEMORY.ref(4, r7 + 0x10).get();
    MEMORY.ref(4, r2 + 0x8).setu(r3);
    r3 = CPU.addT(r5, 0x0);
    r3 = CPU.addT(r3, 0x20);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    CPU.r11().value = r2;
    if(r3 != 0) {
      r2 = CPU.sp().value + 0x4;
      MEMORY.ref(4, r2).setu(MEMORY.ref(4, r7 + 0x8).get());
      MEMORY.ref(4, r2 + 0x4).setu(MEMORY.ref(4, r7 + 0xc).get() + 0x200000);
      MEMORY.ref(4, r2 + 0x8).setu(MEMORY.ref(4, r7 + 0x10).get());
      CPU.r9().value = r2;
      rotVec3(0x200000, MEMORY.ref(4, r5).get(), r2);
    } else {
      //LAB_809aec4
      r3 = CPU.sp().value + 0x4;
      CPU.r9().value = r3;
      r1 = CPU.r9().value;
      MEMORY.ref(4, r1).setu(MEMORY.ref(4, r5 + 0x4).get());
      MEMORY.ref(4, r1 + 0x4).setu(MEMORY.ref(4, r5 + 0x8).get() + 0x200000);
      MEMORY.ref(4, r1 + 0x8).setu(MEMORY.ref(4, r5 + 0xc).get());
    }

    //LAB_809aedc
    r1 = MEMORY.ref(4, r5 + 0x4).get();

    //TODO r0 is probably a vec3
    r0 = CPU.sp().value + 0x1c;
    MEMORY.ref(4, r0).setu(r1);
    r2 = MEMORY.ref(4, r5 + 0x8).get() + 0x200000;
    MEMORY.ref(4, r0 + 0x4).setu(r2);
    r3 = MEMORY.ref(4, r5 + 0xc).get();
    MEMORY.ref(4, r0 + 0x8).setu(r3);

    final Actor70 r6 = FUN_8096c80(0xd7, r1, r2, r3);
    if(r6 != null) {
      //LAB_809aefe
      FUN_8097384();
      FUN_80f9010(0x8a);
      r6.angle_06.set(MEMORY.ref(2, r7 + 0x6).getUnsigned());
      r6._30.set(0x14ccc);
      r6._55.set(0);
      FUN_8009080(r6, 0x5);
      FUN_8009240(r6, 0x1);
      r7 = 0;
      CPU.r10().value = CPU.r11().value;
      CPU.r8().value = CPU.r9().value;

      //LAB_809af38
      do {
        r2 = CPU.r10().value;
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r2).get();
        r3 = MEMORY.ref(4, r1).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setX(r5);
        r2 = CPU.r10().value;
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r2 + 0x4).get();
        r3 = MEMORY.ref(4, r1 + 0x4).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setY(r5);
        r2 = CPU.r10().value;
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r2 + 0x8).get();
        r3 = MEMORY.ref(4, r1 + 0x8).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setZ(r5);
        r0 = divideS(r7 * 0xc000, 10) + 0x4000;
        r6._18.set(r0);
        r6._1c.set(r0);
        r7 = CPU.addT(r7, 0x1);
        FUN_80030f8(0x1);
        CPU.cmpT(r7, 0xb);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

      FUN_80030f8(10);
      FUN_8009080(r6, 0x6);
      FUN_80030f8(0xf);
      r5 = 0x9;

      //LAB_809afba
      do {
        r6.pos_08.y_04.sub(0x20000);
        FUN_80030f8(0x1);
        r5--;
      } while(r5 >= 0);

      FUN_8009080(r6, 0x5);
      FUN_80f9010(0x84);

      if(sp00 != 0) {
        FUN_80090f0(MEMORY.ref(4, sp00, Actor70::new), -0x90000, MEMORY.ref(4, r2 + 0xc).get(), -0x90000); //TODO
      }

      //LAB_809afee
      FUN_80030f8(0x14);
      r5 = 12;

      //LAB_809aff6
      do {
        r6.pos_08.y_04.add(0x18000);
        FUN_80030f8(0x1);
        r5--;
      } while(r5 >= 0);

      FUN_80030f8(10);
      FUN_80f9010(0x72);
      r7 = 0;
      CPU.r10().value = CPU.r9().value;
      CPU.r8().value = CPU.r11().value;

      //LAB_809b01e
      do {
        r2 = CPU.r8().value;
        r1 = CPU.r10().value;
        r3 = MEMORY.ref(4, r2).get();
        r5 = MEMORY.ref(4, r1).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setX(r5);
        r2 = CPU.r8().value;
        r1 = CPU.r10().value;
        r3 = MEMORY.ref(4, r2 + 0x4).get();
        r5 = MEMORY.ref(4, r1 + 0x4).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setY(r5);
        r2 = CPU.r8().value;
        r1 = CPU.r10().value;
        r3 = MEMORY.ref(4, r2 + 0x8).get();
        r5 = MEMORY.ref(4, r1 + 0x8).get();
        r3 = CPU.subT(r3, r5);
        r0 = divideS(r7 * r3, 10);
        r3 = MEMORY.ref(4, 0x809b0ac).get();
        r5 = CPU.addT(r5, r0);
        r6.pos_08.setZ(r5);
        r0 = divideS(r7 * r3, 10) + 0x10000;
        r6._18.set(r0);
        r6._1c.set(r0);
        r7 = CPU.addT(r7, 0x1);
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        CPU.cmpT(r7, 0xb);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

      FUN_80090d0(r6);
      FUN_809748c();
    }

    //LAB_809b092
    CPU.sp().value += 0x28;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x809b208)
  public static void FUN_809b208() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809b698)
  public static void FUN_809b698() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809b804)
  public static void FUN_809b804(final int r0) {
    if(MEMORY.ref(1, r0 + 0x45).get() != 0) {
      MEMORY.ref(2, r0 + 0x38).incr();

      if(MEMORY.ref(2, r0 + 0x3a).get() != 0) {
        MEMORY.ref(2, r0 + 0x3a).decr();
      } else {
        //LAB_809b82a
        final int r3 = MEMORY.ref(4, r0 + 0x34).get();

        if(r3 != 0) {
          MEMORY.call(r3, r0);
        }
      }

      //LAB_809b836
      if(MEMORY.ref(1, r0 + 0x45).get() != 0) {
        if(MEMORY.ref(1, r0 + 0x43).get() != 0) {
          FUN_809b8f4(r0);
        }

        //LAB_809b852
        if(MEMORY.ref(1, r0 + 0x44).get() != 0) {
          FUN_809b86c(r0);
        }
      }
    }

    //LAB_809b866
  }

  @Method(0x809b86c)
  public static void FUN_809b86c(final int r0) {
    CPU.sp().value -= 0x18;

    final int r5 = MEMORY.ref(4, r0).get();
    final int r6;
    if((MEMORY.ref(1, r0 + 0x47).getUnsigned() & 0x4) != 0) {
      r6 = 0x1fc0000 - MEMORY.ref(4, r0 + 0x8).get();
    } else {
      r6 = 0;
    }

    //LAB_809b88c
    MEMORY.ref(4, CPU.sp().value).setu((int)MEMORY.call(0x3000118, MEMORY.ref(4, r0 + 0x28).get(), MEMORY.ref(4, r5 + 0x18).get()));
    MEMORY.ref(4, CPU.sp().value + 0x4).setu((int)MEMORY.call(0x3000118, MEMORY.ref(4, r0 + 0x2c).get(), MEMORY.ref(4, r5 + 0x18).get()));
    final int r2 = MEMORY.ref(4, r0 + 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6);
    final int r0_0 = MEMORY.ref(4, r0 + 0x8).get();
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0_0 + r6);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    CPU.cmpT(r2 + 0x1fffff, 0x12ffffe);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      if(r0_0 > -0x200000 && r0_0 < 0xe00000) {
        FUN_8009008(r5, CPU.sp().value + 0x8, CPU.sp().value, 0);
      }
    }

    //LAB_809b8dc
    CPU.sp().value += 0x18;
  }

  @Method(0x809b8f4)
  public static void FUN_809b8f4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    r6 = CPU.addT(r0, 0x0);
    r2 = CPU.movT(0, 0x80);
    r0 = MEMORY.ref(4, r6 + 0xc).get();
    r2 = CPU.lslT(r2, 24);
    CPU.sp().value -= 0x4;
    r0 = CPU.cmpT(r0, r2);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_809b906
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      r2 = MEMORY.ref(4, r6 + 0x10).get();
      r7 = CPU.subT(r0, r3);
      r3 = MEMORY.ref(4, r6 + 0x8).get();
      r5 = CPU.subT(r2, r3);
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x41);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.lslT(r3, 24);
      r3 = CPU.asrT(r3, 24);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.addT(r7, 0x0);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x809ba28).get();
          r0 = CPU.addT(r7, r3);
        }

        //LAB_809b928
        r0 = CPU.asrT(r0, 16);
        r3 = CPU.addT(r5, 0x0);
        CPU.cmpT(r5, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x809ba28).get();
          r3 = CPU.addT(r5, r2);
        }

        //LAB_809b934
        r2 = CPU.addT(r0, 0x0);
        r2 = CPU.mulT(r2, r0);
        r3 = CPU.asrT(r3, 16);
        r0 = CPU.addT(r2, 0x0);
        r2 = CPU.addT(r3, 0x0);
        r2 = CPU.mulT(r2, r3);
        r3 = CPU.addT(r2, 0x0);
        r0 = CPU.addT(r0, r3);
        r3 = MEMORY.ref(4, 0x809ba2c).get();
        r0 = (int)MEMORY.call(r3, r0);
        r3 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 16);
        r3 = CPU.lslT(r3, 16);
        r0 = CPU.cmpT(r0, r3);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r4 = MEMORY.ref(4, 0x809ba30).get();
          r0 = CPU.addT(r7, 0x0);
          r1 = CPU.addT(r7, 0x0);
          r0 = CPU.lslT(r0, 0);
          CPU.r12().value = 0x809b960;
          r0 = (int)MEMORY.call(r4, r0, r1);
          r3 = CPU.addT(r0, 0x0);
          r1 = CPU.addT(r5, 0x0);
          r0 = CPU.addT(r5, 0x0);
          r0 = CPU.lslT(r0, 0);
          CPU.r12().value = 0x809b96c;
          r0 = (int)MEMORY.call(r4, r0, r1);
          r3 = CPU.addT(r3, r0);
          r0 = CPU.addT(r3, 0x0);
          r0 = sqrt(r0);
        }

        //LAB_809b974
        r2 = CPU.movT(0, 0x80);
        r2 = CPU.lslT(r2, 12);
        r0 = CPU.cmpT(r0, r2);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r1 = MEMORY.ref(4, r6 + 0xc).get();
          r2 = MEMORY.ref(4, r6 + 0x10).get();
          r0 = CPU.addT(r6, 0x0);
          FUN_809ba5c(r0, r1, r2);
          CPU.sp().value += 0x4;
          return;
        }
      }

      //LAB_809b988
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r7, 0x0);
      r0 = FUN_80044d0(r0, r1);
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x42);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.lslT(r3, 24);
      r3 = CPU.asrT(r3, 24);
      r0 = CPU.lslT(r0, 16);
      r4 = CPU.asrT(r0, 16);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = MEMORY.ref(2, r6 + 0x30).getUnsigned();
        r3 = CPU.subT(r4, r5);
        r3 = CPU.lslT(r3, 16);
        r2 = CPU.asrT(r3, 16);
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = CPU.negT(r3, r2);
        }

        //LAB_809b9b2
        r7 = CPU.movT(0, 0x32);
        r1 = MEMORY.ref(2, r6 + r7).get();
        r0 = MEMORY.ref(2, r6 + 0x32).getUnsigned();
        r3 = CPU.cmpT(r3, r1);
        if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r3 = CPU.negT(r3, r2);
            r3 = CPU.cmpT(r3, r1);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r3 = CPU.negT(r3, r0);
              r3 = CPU.lslT(r3, 16);
              r2 = CPU.asrT(r3, 16);
            }
          } else {
            //LAB_809b9ce
            r2 = CPU.cmpT(r2, r1);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r2 = CPU.addT(r1, 0x0);
            }
          }

          //LAB_809b9d4
          r3 = CPU.addT(r2, r5);
          r3 = CPU.lslT(r3, 16);
          r4 = CPU.asrT(r3, 16);
        }
      }

      //LAB_809b9da
      r3 = CPU.lslT(r4, 16);
      r0 = CPU.lsrT(r3, 16);
      r2 = MEMORY.ref(4, r6 + 0x1c).get();
      r3 = MEMORY.ref(4, r6 + 0x24).get();
      r7 = CPU.addT(r2, r3);
      r3 = MEMORY.ref(4, r6 + 0x20).get();
      MEMORY.ref(2, r6 + 0x30).setu(r0);
      r7 = CPU.cmpT(r7, r3);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r7 = CPU.addT(r3, 0x0);
      }

      //LAB_809b9ee
      r3 = CPU.lslT(r0, 16);
      r4 = CPU.asrT(r3, 16);
      r0 = CPU.addT(r4, 0x0);
      MEMORY.ref(4, r6 + 0x1c).setu(r7);
      MEMORY.ref(4, CPU.sp().value).setu(r4);
      r0 = cos(r0);
      r5 = MEMORY.ref(4, 0x809ba30).get();
      r1 = CPU.addT(r7, 0x0);
      r0 = (int)MEMORY.call(r5, r0, r1);
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      r4 = MEMORY.ref(4, CPU.sp().value).get();
      r3 = CPU.addT(r3, r0);
      r0 = CPU.addT(r4, 0x0);
      MEMORY.ref(4, r6 + 0x4).setu(r3);
      r0 = sin(r0);
      r1 = CPU.addT(r7, 0x0);
      r0 = (int)MEMORY.call(r5, r0, r1);
      r3 = MEMORY.ref(4, r6 + 0x8).get();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(4, r6 + 0x8).setu(r3);
    }

    //LAB_809ba1e
    CPU.sp().value += 0x4;
  }

  @Method(0x809ba5c)
  public static void FUN_809ba5c(final int r0, final int r1, final int r2) {
    MEMORY.ref(4, r0 + 0xc).setu(0x80000000);
    MEMORY.ref(4, r0 + 0x10).setu(0x80000000);
    MEMORY.ref(4, r0 + 0x4).setu(r1);
    MEMORY.ref(4, r0 + 0x8).setu(r2);
    MEMORY.ref(4, r0 + 0x1c).setu(0);
  }

  @Method(0x809bb34)
  public static void FUN_809bb34(final int r0) {
    CPU.sp().value -= 0x4;

    if(MEMORY.ref(4, r0).get() != 0) {
      FUN_8009038(MEMORY.ref(4, r0).get());
    }

    //LAB_809bb44
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r0);
    DMA.channels[3].CNT.setu(0x85000012);

    CPU.sp().value += 0x4;
  }

  @Method(0x809c138)
  public static void FUN_809c138(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809c3a4)
  public static void FUN_809c3a4() {
    throw new RuntimeException("Not implemented");
  }
}
