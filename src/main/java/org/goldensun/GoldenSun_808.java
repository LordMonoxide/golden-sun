package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_8002304;
import static org.goldensun.GoldenSun.FUN_8004278;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.setMallocSlot;
import static org.goldensun.GoldenSun.FUN_8002fb0;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003b70;
import static org.goldensun.GoldenSun.FUN_8003bb4;
import static org.goldensun.GoldenSun.FUN_8003f3c;
import static org.goldensun.GoldenSun.FUN_800403c;
import static org.goldensun.GoldenSun.FUN_80040e8;
import static org.goldensun.GoldenSun.FUN_80041d8;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.FUN_8004760;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.FUN_8009048;
import static org.goldensun.GoldenSun.FUN_8009078;
import static org.goldensun.GoldenSun.FUN_8009080;
import static org.goldensun.GoldenSun.FUN_80090a0;
import static org.goldensun.GoldenSun.FUN_80090a8;
import static org.goldensun.GoldenSun.FUN_80090b0;
import static org.goldensun.GoldenSun.FUN_80090b8;
import static org.goldensun.GoldenSun.FUN_80090c8;
import static org.goldensun.GoldenSun.FUN_80090d0;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_80090f0;
import static org.goldensun.GoldenSun.FUN_8009110;
import static org.goldensun.GoldenSun.FUN_8009118;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009130;
import static org.goldensun.GoldenSun.FUN_8009138;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_80091a8;
import static org.goldensun.GoldenSun.FUN_80091e0;
import static org.goldensun.GoldenSun.FUN_8009228;
import static org.goldensun.GoldenSun.initMemoryAllocator;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSunVars._3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_801.FUN_8015000;
import static org.goldensun.GoldenSun_801.FUN_8015040;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_80151e8;
import static org.goldensun.GoldenSun_801.FUN_8015200;
import static org.goldensun.GoldenSun_801.FUN_8015208;
import static org.goldensun.GoldenSun_801.FUN_8015268;
import static org.goldensun.GoldenSun_801.FUN_8015288;
import static org.goldensun.GoldenSun_801.FUN_8015290;
import static org.goldensun.GoldenSun_801.FUN_8015360;
import static org.goldensun.GoldenSun_801.FUN_8015370;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_807.FUN_8077098;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770c8;
import static org.goldensun.GoldenSun_807.FUN_80770d0;
import static org.goldensun.GoldenSun_807.FUN_80772f0;
import static org.goldensun.GoldenSun_809.FUN_80901c0;
import static org.goldensun.GoldenSun_809.FUN_80907b0;
import static org.goldensun.GoldenSun_809.FUN_8091174;
import static org.goldensun.GoldenSun_809.FUN_8091200;
import static org.goldensun.GoldenSun_809.FUN_8091220;
import static org.goldensun.GoldenSun_809.FUN_8091240;
import static org.goldensun.GoldenSun_809.FUN_8091254;
import static org.goldensun.GoldenSun_809.FUN_8091660;
import static org.goldensun.GoldenSun_809.FUN_80919d8;
import static org.goldensun.GoldenSun_809.FUN_8091a58;
import static org.goldensun.GoldenSun_809.FUN_8093a6c;
import static org.goldensun.GoldenSun_809.FUN_80941e0;
import static org.goldensun.GoldenSun_809.FUN_8094428;
import static org.goldensun.GoldenSun_809.FUN_8095680;
import static org.goldensun.GoldenSun_809.FUN_8095778;
import static org.goldensun.GoldenSun_809.FUN_8099810;
import static org.goldensun.GoldenSun_809.FUN_809c138;
import static org.goldensun.GoldenSun_809.FUN_809c3a4;
import static org.goldensun.GoldenSun_80b.FUN_80b50a0;
import static org.goldensun.GoldenSun_80f.FUN_80f4000;
import static org.goldensun.GoldenSun_80f.FUN_80f6000;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.GoldenSun_80f.FUN_80f9070;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_808 {
  private GoldenSun_808() { }

  @Method(0x808a008)
  public static void FUN_808a008(final int r0) {
    MEMORY.call(0x808a8e5, r0);
  }

  @Method(0x808a010)
  public static void FUN_808a010(final int r0) {
    MEMORY.call(0x809163d, r0);
  }

  @Method(0x808a018)
  public static void FUN_808a018() {
    MEMORY.call(0x80916b0);
  }

  @Method(0x808a03c)
  public static void FUN_808a03c(final int r0) {
    MEMORY.call(0x808b868, r0);
  }

  @Method(0x808a070)
  public static int FUN_808a070(final int r0, final int r1) {
    return (int)MEMORY.call(0x8091c7c, r0, r1);
  }

  @Method(0x808a080)
  public static int FUN_808a080(final int r0) {
    return (int)MEMORY.call(0x8092054, r0);
  }

  @Method(0x808a090)
  public static void FUN_808a090(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092064, r0, r1, r2);
  }

  @Method(0x808a098)
  public static void FUN_808a098(final int r0, final int r1) {
    MEMORY.call(0x809207c, r0, r1);
  }

  @Method(0x808a0a0)
  public static void FUN_808a0a0(final int r0) {
    MEMORY.call(0x80920e8, r0);
  }

  @Method(0x808a0c0)
  public static void FUN_808a0c0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092158, r0, r1, r2);
  }

  @Method(0x808a0d0)
  public static void FUN_808a0d0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80921c4, r0, r1, r2);
  }

  @Method(0x808a0f0)
  public static void FUN_808a0f0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80923e4, r0, r1, r2);
  }

  @Method(0x808a100)
  public static void FUN_808a100(final int r0, final int r1) {
    MEMORY.call(0x80924d4, r0, r1);
  }

  @Method(0x808a110)
  public static void FUN_808a110(final int r0, final int r1) {
    MEMORY.call(0x8092548, r0, r1);
  }

  @Method(0x808a128)
  public static void FUN_808a128(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092560, r0, r1, r2);
  }

  @Method(0x808a130)
  public static void FUN_808a130(final int r0, final int r1) {
    MEMORY.call(0x809259c, r0, r1);
  }

  @Method(0x808a138)
  public static void FUN_808a138(final int r0, final int r1) {
    MEMORY.call(0x80925cc, r0, r1);
  }

  @Method(0x808a158)
  public static void FUN_808a158(final int r0, final int r1) {
    MEMORY.call(0x8092950, r0, r1);
  }

  @Method(0x808a170)
  public static void FUN_808a170(final int r0) {
    MEMORY.call(0x8092b94, r0);
  }

  @Method(0x808a178)
  public static void FUN_808a178(final int r0, final int r1) {
    MEMORY.call(0x8092c40, r0, r1);
  }

  @Method(0x808a180)
  public static void FUN_808a180(final int r0, final int r1) {
    MEMORY.call(0x8092f84, r0, r1);
  }

  @Method(0x808a188)
  public static void FUN_808a188(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8093040, r0, r1, r2);
  }

  @Method(0x808a1b8)
  public static void FUN_808a1b8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092adc, r0, r1, r2);
  }

  @Method(0x808a1d8)
  public static void FUN_808a1d8(final int r0) {
    MEMORY.call(0x8093304, r0);
  }

  @Method(0x808a1e0)
  public static void FUN_808a1e0(final int r0, final int r1) {
    MEMORY.call(0x8092b08, r0, r1);
  }

  @Method(0x808a200)
  public static void FUN_808a200(final int r0, final int r1) {
    MEMORY.call(0x809335c, r0, r1);
  }

  @Method(0x808a238)
  public static void FUN_808a238(final int r0, final int r1) {
    MEMORY.call(0x8091e3d, r0, r1);
  }

  @Method(0x808a248)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x8091e9c, r0);
  }

  @Method(0x808a2c8)
  public static void FUN_808a2c8() {
    MEMORY.call(0x8095160);
  }

  @Method(0x808a2d8)
  public static void FUN_808a2d8() {
    MEMORY.call(0x8095240);
  }

  @Method(0x808a2e0)
  public static void FUN_808a2e0() {
    MEMORY.call(0x8095268);
  }

  @Method(0x808a330)
  public static void FUN_808a330(final int r0, final int r1) {
    MEMORY.call(0x8091200, r0, r1);
  }

  @Method(0x808a348)
  public static void FUN_808a348(final int r0) {
    MEMORY.call(0x8091254, r0);
  }

  @Method(0x808a360)
  public static void FUN_808a360() {
    MEMORY.call(0x8091dc8);
  }

  /** Called after confirming character names */
  @Method(0x808a368)
  public static void FUN_808a368() {
    MEMORY.call(0x8091df4);
  }

  @Method(0x808a370)
  public static void FUN_808a370() {
    MEMORY.call(0x8091e20);
  }

  @Method(0x808a420)
  public static void FUN_808a420(final int r0) {
    MEMORY.call(0x80967e4, r0);
  }

  @Method(0x808a428)
  public static void FUN_808a428(final int r0, final int r1) {
    MEMORY.call(0x8096fb0, r0, r1);
  }

  @Method(0x808a430)
  public static void FUN_808a430(final int r0, final int r1) {
    MEMORY.call(0x80970f8, r0, r1);
  }

  @Method(0x808a438)
  public static void FUN_808a438() {
    MEMORY.call(0x8097174);
  }

  @Method(0x808a440)
  public static void FUN_808a440() {
    MEMORY.call(0x8097194);
  }

  @Method(0x808a448)
  public static void FUN_808a448() {
    MEMORY.call(0x809728c);
  }

  @Method(0x808a5d0)
  public static int FUN_808a5d0(final int r0, final int r1) {
    return (int)MEMORY.call(0x808b158, r0, r1);
  }

  @Method(0x808a5f8)
  public static void FUN_808a5f8(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r7 = MEMORY.ref(2, 0x2000400).get();
    r1 = 999;
    r6 = (int)MEMORY.call(MEMORY.ref(4, 0x2008014).get());
    CPU.r9().value = 0;

    if(CPU.r8().value != r1) {
      do {
        r5 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
      } while((r5 & 0xffff_f000) != 0);

      //LAB_808a638
      while((r5 & 0xfff) != 0x1ff) {
        if((r5 & 0xfff) == r7) {
          CPU.r10().value = r6;

          r3 = MEMORY.ref(4, r6).get();
          r6 += 0x4;

          r7 = (r3 & 0xff000) >>> 12;
          r5 = r3 & 0xfff;
          r2 = (r3 & 0xff00000) >>> 20;
          if((r3 & 0x10000000) != 0) {
            r0 = MEMORY.ref(4, r6).get();
            r6 += 0x4;
          } else {
            r0 = 0;
          }

          r1 = MEMORY.ref(4, CPU.r10().value).get() & 0x1ff;

          //LAB_808a640
          //LAB_808a648
          while(r2 != 0 && r5 != 0x1ff) {
            if((r2 == 0xff || r2 == CPU.r8().value) && (r0 == 0 || FUN_80770c0(r0) == 0)) {
              //LAB_808a654
              r1 = r5;
              CPU.r9().value = r7;
              break;
            }

            //LAB_808a65a
            r3 = MEMORY.ref(4, r6).get();
            r6 += 0x4;

            r7 = (r3 & 0xff000) >>> 12;
            r5 = r3 & 0xfff;
            r2 = (r3 & 0xff00000) >>> 20;
            if((r3 & 0x10000000) != 0) {
              r0 = MEMORY.ref(4, r6).get();
              r6 += 0x4;
            } else {
              r0 = 0;
            }

            //LAB_808a67c
          }

          //LAB_808a686
          break;
        }

        //LAB_808a68e
        do {
          r5 = MEMORY.ref(4, r6).get();
          r6 += 0x4;
        } while((r5 & 0xffff_f000) != 0);
      }

      //LAB_808a6a2
      if(r1 != 999) {
        MEMORY.ref(2, 0x2000400).setu(r1);
        MEMORY.ref(2, 0x2000402).setu(CPU.r9().value);
      }
    }

    //LAB_808a6bc
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x808a6e4)
  public static void FUN_808a6e4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808a8e4)
  public static void FUN_808a8e4(int r0) {
    int r1;
    int r3;
    int r5;
    int r6;

    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(0);

    r3 = _3001f54.get();
    CPU.r11().value = 0x809f1a8; //TODO

    if(r3 == 0) {
      FUN_8077098();
      MEMORY.ref(2, 0x2000400).setu(0);
      MEMORY.ref(2, 0x2000402).setu(2);
    } else if(r0 == 1) {
      MEMORY.ref(2, 0x2000400).setu(5);
      MEMORY.ref(2, 0x2000402).setu(1);
    } else if(r0 == 2) {
      MEMORY.ref(2, 0x2000400).setu(1);
      MEMORY.ref(2, 0x2000402).setu(1);
    } else {
      //LAB_808a932
      FUN_8077098();
      MEMORY.ref(2, 0x2000400).setu(0);
      MEMORY.ref(2, 0x2000402).setu(2);
    }

    //LAB_808a94c
    FUN_8015360(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
    FUN_800403c();
    FUN_80040e8();
    FUN_80040e8();
    CPU.r9().value = 0x50001c0;

    //LAB_808a96e
    do {
      if(FUN_80770c0(0x101) != 0) {
        FUN_80770d0(0x101);
      } else {
        //LAB_808a9a8
        FUN_80f9010(0x120);
      }

      //LAB_808a9b0
      r3 = MEMORY.ref(2, 0x2000400).get();
      r3 = CPU.lslT(r3, 3);
      r3 += CPU.r11().value;
      CPU.r10().value = r3;
      r6 = MEMORY.ref(2, 0x2000402).get();
      DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);
      FUN_80040e8();
      setInterruptHandler(1, 0, null);
      setInterruptHandler(2, 0, null);
      initMemoryAllocator();
      FUN_8004760();
      FUN_800403c();
      r3 = MEMORY.ref(2, 0x2000400).get();
      if(r3 > 0x1fa) {
        if(r3 == 0x1fb) {
          //LAB_808aa9e
          r6 = 0;
        } else if(r3 == 0x1fc) {
          //LAB_808aa6e
          r5 = mallocChip(0x40);
          DMA.channels[3].SAD.setu(CPU.r9().value);
          DMA.channels[3].DAD.setu(r5);
          DMA.channels[3].CNT.setu(0x84000010);
          r6 = FUN_80f6000(r6);
          DMA.channels[3].SAD.setu(r5);
          DMA.channels[3].DAD.setu(CPU.r9().value);
          DMA.channels[3].CNT.setu(0x84000010);
          setMallocSlot(r5);
        } else if(r3 == 0x1fd) {
          //LAB_808aa52
          r5 = mallocChip(0x40);
          DMA.channels[3].SAD.setu(CPU.r9().value);
          DMA.channels[3].DAD.setu(r5);
          DMA.channels[3].CNT.setu(0x84000010);
          r6 = FUN_80f4000(r6);
          DMA.channels[3].SAD.setu(r5);
          DMA.channels[3].DAD.setu(CPU.r9().value);
          DMA.channels[3].CNT.setu(0x84000010);
          setMallocSlot(r5);
        } else if(r3 == 0x1fe) {
          r6 = FUN_80b50a0(r6);
        }

        //LAB_808aaa0
        FUN_808a6e4(r6);
      } else {
        //LAB_808aaa8
        r1 = FUN_80770c0(0x109);
        r0 = MEMORY.ref(2, 0x2000400).get();
        FUN_808ab74(r0, r1);
        FUN_808b090();
        if(FUN_80770c0(0x109) == 0) {
          if(FUN_80770c0(0x11a) != 0) {
            FUN_80770d0(0x11a);
          } else {
            if(FUN_80770c0(0x11b) == 0) {
              FUN_808acc4();
            } else {
              //LAB_808aae6
              FUN_80770d0(0x11a);
            }
          }
        } else {
          //LAB_808aaf0
          r0 = MEMORY.ref(2, 0x200045e).get();
          if(r0 != -1) {
            FUN_80f9010(r0);
          } else {
            //LAB_808ab06
            FUN_808acc4();
          }
        }

        //LAB_808ab0a
        MEMORY.ref(2, 0x200041a).setu(MEMORY.ref(2, CPU.r10().value + 0x4).getUnsigned());
        FUN_808ab48();
        FUN_808a5f8(FUN_808c4f8(r6));
      }
    } while(true);
  }

  @Method(0x808ab48)
  public static void FUN_808ab48() {
    FUN_8002fb0(MEMORY.ref(2, 0x809f1a8 + MEMORY.ref(2, 0x2000400).get() * 0x8).get(), 0x2008000);
  }

  @Method(0x808ab74)
  public static void FUN_808ab74(final int r0, final int r1) {
    final int r6 = MEMORY.ref(1, 0x809f1a8 + MEMORY.ref(2, 0x2000400).get() * 0x8 + 0x2).get(); //TODO
    if(r1 == 0) {
      //LAB_808ab94
      for(int r5 = 0x200; r5 < 0x300; r5++) {
        FUN_80770d0(r5);
      }

      if(r6 != MEMORY.ref(2, 0x200040c).get()) {
        //LAB_808abb6
        for(int r5 = 0x300; r5 < 0x400; r5++) {
          FUN_80770d0(r5);
        }

        FUN_80770c8(0x12f);
        MEMORY.ref(4, 0x2000478).setu(0);
        MEMORY.ref(2, 0x2000472).setu(0);
        FUN_80770d0(0x110);
        FUN_80770d0(0x111);
        FUN_80770d0(0x112);
        FUN_80770d0(0x113);
        MEMORY.ref(2, 0x2000480).setu(MEMORY.ref(2, 0x2000400).getUnsigned());
        MEMORY.ref(2, 0x2000482).setu(MEMORY.ref(2, 0x2000402).getUnsigned());
      }

      //LAB_808ac16
      //LAB_808ac18
      for(int r5 = 0x80; r5 < 0xe0; r5++) {
        FUN_80770d0(r5);
      }

      FUN_80770d0(0x16c);
      FUN_80770d0(0x144);
      FUN_80770d0(0x161);
      FUN_80770d0(0x123);
      FUN_80770d0(0x11c);
      MEMORY.ref(2, 0x200045e).setu(0xffff);
    }

    //LAB_808ac54
    MEMORY.ref(2, 0x200040c).setu(r6);
    FUN_80770c8((r6 & 0x7f) + 0x180);

    final int r2 = MEMORY.ref(1, 0x809f1a8 + MEMORY.ref(2, 0x2000400).get() * 0x8 + 0x3).get();
    MEMORY.ref(2, 0x200047e).setu(r2);
    if(r2 == 2) {
      FUN_80770c8(0x123);
    }

    //LAB_808ac8e
    FUN_80772f0();
  }

  @Method(0x808acc4)
  public static void FUN_808acc4() {
    FUN_80f9010(MEMORY.ref(2, 0x2000430).get());
  }

  @Method(0x808ace0)
  public static void FUN_808ace0(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x808addc).get();
    r2 = MEMORY.ref(4, 0x808ade0).get();
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.movT(0, 0xe0);
    r1 = CPU.lslT(r1, 1);
    CPU.r10().value = r3;
    r3 = CPU.addT(r2, r1);
    r1 = CPU.movT(0, 0x0);
    r4 = MEMORY.ref(2, r3 + r1).get();
    CPU.r11().value = r4;
    r4 = CPU.movT(0, 0xe1);
    r4 = CPU.lslT(r4, 1);
    r3 = CPU.addT(r2, r4);
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r2).get();
    r6 = CPU.movT(0, 0xd0);
    CPU.sp().value -= 0x8;
    r6 = CPU.lslT(r6, 1);
    r3 = CPU.movT(0, 0x0);
    CPU.r9().value = r1;
    r6 += CPU.r10().value;
    r5 = MEMORY.ref(4, 0x808ade4).get();
    r7 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x1);
      r4 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r1 = CPU.negT(r1, r1);
      r2 = MEMORY.ref(2, r5).getUnsigned();
      r3 = CPU.cmpT(r3, r1);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.r8().value = r1;
        r1 = MEMORY.ref(4, 0x808ade8).get();

        //LAB_808ad34
        do {
          r3 = CPU.lslT(r2, 16);
          r3 = CPU.asrT(r3, 16);
          CPU.cmpT(r3, CPU.r11().value);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x2);
            r3 = MEMORY.ref(2, r5 + r0).get();
            CPU.cmpT(r3, CPU.r8().value);
            if(r3 == CPU.r8().value || r3 == CPU.r9().value) {
              //LAB_808ad48
              r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
              if((r0 & r1) == r1 || FUN_80770c0(r0 << 17 >> 17) == 0) {
                //LAB_808ad62
                r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
                r3 = CPU.lslT(r3, 24);
                r3 = CPU.asrT(r3, 31);
                r3 = CPU.lslT(r3, 16);
                r3 = CPU.asrT(r3, 16);
                r1 = CPU.movT(0, 0x6);
                r7 = MEMORY.ref(2, r5 + r1).get();
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                break;
              }
            }
          }

          //LAB_808ad74
          r5 = CPU.addT(r5, 0x8);
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r5 + r4).get();
          r2 = MEMORY.ref(2, r5).getUnsigned();
          CPU.cmpT(r3, CPU.r8().value);
        } while(!CPU.cpsr().getZero()); // !=
      }
    }

    //LAB_808ad80
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r6).setu(r3);
    r6 = CPU.addT(r6, 0x1);
    r3 = CPU.movT(0, 0x0);

    //LAB_808ad88
    do {
      MEMORY.ref(1, r6).setu(r7);
      r6 = CPU.addT(r6, 0x1);
      CPU.cmpT(r7, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r7 = CPU.addT(r7, 0x1);
      }

      //LAB_808ad92
      r3 = CPU.addT(r3, 0x1);
      CPU.cmpT(r3, 0x6);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, 0x808adec).get();
      r2 = CPU.movT(0, 0xd0);
      r0 += CPU.r10().value;
      r3 = MEMORY.ref(1, r0).getUnsigned();
      r2 = CPU.lslT(r2, 1);
      r2 += CPU.r10().value;
      MEMORY.ref(1, r2).setu(r3);
      MEMORY.ref(1, r0).setu(0);
    }

    //LAB_808adb0
    MEMORY.ref(4, CPU.r10().value + 0x1a8).setu(0);
    MEMORY.ref(4, CPU.r10().value + 0x1ac).setu(0x100000);
    FUN_808b25c();
    CPU.sp().value += 0x8;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808b090)
  public static void FUN_808b090() {
    int r10 = 0x12;
    final int r11 = MEMORY.ref(2, 0x2000400).get();
    int r5 = 0x809d9f0;
    final int r7 = MEMORY.ref(2, 0x2000402).get();
    int r1 = MEMORY.ref(2, r5).getUnsigned();
    final int r9 = MEMORY.ref(2, 0x200040c).get();

    //LAB_808b0da
    while((short)r1 != -1) {
      if((MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) != 0 && (short)r1 == r11 || (MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) == 0 && (short)r1 == r9) {
        //LAB_808b0f6
        final int r2 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        if((r2 & 0x7fff) == 0x7fff || r2 << 17 >> 17 == r7) {
          //LAB_808b108
          final int r0 = MEMORY.ref(2, r5 + 0x4).get();
          if(r0 == -1 || FUN_80770c0(r0) != 0) {
            //LAB_808b118
            r10 = MEMORY.ref(2, r5 + 0x6).get();
            break;
          }
        }
      }

      //LAB_808b122
      r5 += 0x8;
      r1 = MEMORY.ref(2, r5).getUnsigned();
    }

    //LAB_808b132
    MEMORY.ref(2, 0x2000430).setu(r10);
  }

  @Method(0x808b1d8)
  public static void FUN_808b1d8() {
    final int r6 = MEMORY.ref(2, 0x2000400).get();
    final int r5 = MEMORY.ref(2, 0x2000402).get();
    int r2 = 0x809e1d8;

    //LAB_808b20e
    while(MEMORY.ref(2, r2).get() != -1) {
      if(MEMORY.ref(2, r2).get() == r6) {
        final int r3 = MEMORY.ref(2, r2 + 0x2).get();
        if(r3 == -1 || r3 == r5) {
          //LAB_808b222
          MEMORY.ref(2, 0x2000404).setu(MEMORY.ref(2, r2 + 0x4).getUnsigned());
          MEMORY.ref(2, 0x2000406).setu(MEMORY.ref(2, r2 + 0x6).getUnsigned());
          break;
        }
      }

      //LAB_808b22c
      r2 += 0x8;
    }

    //LAB_808b238
  }

  @Method(0x808b25c)
  public static void FUN_808b25c() {
    int r1 = 0; // r1 undefined when if statement conditions are false

    int r4 = 0x809e270;
    int r2 = MEMORY.ref(4, r4).get();
    r4 += 0x4;

    final int r0 = MEMORY.ref(2, 0x2000400).get();

    //LAB_808b27e
    while(r2 != 0 && r2 != r0) {
      if((r2 & 0x80000000) != 0) {
        r1 = r2 & 0xffff;
      }

      //LAB_808b28a
      r2 = MEMORY.ref(4, r4).get();
      r4 += 0x4;
    }

    //LAB_808b294
    MEMORY.ref(2, 0x2000416).setu(r1);
  }

  @Method(0x808b398)
  public static int FUN_808b398(final int r0) {
    if(r0 <= 8) {
      if(FUN_80770c0(0x20) != 0) {
        if(r0 == 0) {
          return 0x12;
        }

        //LAB_808b3b0
        if(r0 == 1) {
          return 0x13;
        }
      } else if(FUN_80770c0(0x21) != 0 && r0 == 0) {
        return 0x11;
      }
    }

    //LAB_808b3c8
    return r0;
  }

  @Method(0x808b3ec)
  public static void FUN_808b3ec(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    CPU.r9().value = r3;
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r0, 0x0);
    CPU.r11().value = r1;
    CPU.sp().value -= 0x8;
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.cmpT(r3, r7);

    jmp_808b42e:
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.r9().value;
        MEMORY.ref(4, r0).setu(r7);
      } else {
        //LAB_808b418
        do {
          r1 = CPU.addT(r1, 0x1);
          CPU.cmpT(r1, 0x3);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break jmp_808b42e;
          }
          r2 = CPU.lslT(r1, 2);
          r0 = CPU.r9().value;
          r3 = MEMORY.ref(4, r0 + r2).get();
          r3 = CPU.cmpT(r3, r7);
          if(CPU.cpsr().getZero()) { // ==
            break jmp_808b42e;
          }
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=

        MEMORY.ref(4, r0 + r2).setu(r7);
      }
    }

    //LAB_808b42e
    r0 = CPU.movT(0, 0x1);
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r7 + r1).get();
    r0 = CPU.negT(r0, r0);
    r2 = MEMORY.ref(2, r7).getUnsigned();

    //LAB_808b43a
    while(r3 != r0 && CPU.r11().value <= 0x41) {
      r3 = CPU.lslT(r2, 16);
      r3 = CPU.asrT(r3, 16);
      CPU.cmpT(r3, 0x7);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      } else {
        //LAB_808b446
        r3 = CPU.cmpT(r3, 0x2705);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = CPU.r11().value;
          r0 = CPU.movT(0, 0x1);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          CPU.r11().value += r0;
        }
      }

      //LAB_808b454
      r1 = CPU.movT(0, 0x2);
      r5 = MEMORY.ref(2, r7 + r1).get();
      r0 = CPU.addT(r5, 0x0);
      r0 = FUN_808d428(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_808b464
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.subT(r3, 0x30);
        if(r3 < 0 || r3 > 0x4f || MEMORY.ref(2, CPU.r9().value + 0x19e).get() == 3 || FUN_808d428(r5 + 0x50) != 0) {
          //LAB_808b488
          r3 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(2, r7 + r3).get();
          r0 = FUN_808b398(r0);
          CPU.r10().value = r0;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r0 = FUN_808ba1c(r0);
          r6 = CPU.addT(r0, 0x0);
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = MEMORY.ref(4, r7 + 0x8).get();
            r2 = MEMORY.ref(4, r7 + 0xc).get();
            r3 = MEMORY.ref(4, r7 + 0x10).get();
            r0 = CPU.r10().value;
            r0 = FUN_80090c8(r0, r1, r2, r3);
            r2 = MEMORY.ref(1, r7 + 0x17).getUnsigned();
            r3 = CPU.movT(0, 0x1);
            r3 = CPU.andT(r3, r2);
            r6 = CPU.addT(r0, 0x0);
            r1 = CPU.movT(0, 0x1);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r0 = CPU.subT(r0, 0x1);
              MEMORY.ref(4, CPU.sp().value).setu(r1);
              r0 = FUN_808ba1c(r0);
              r3 = CPU.addT(r0, 0x0);
              r3 = CPU.addT(r3, 0x54);
              r3 = MEMORY.ref(1, r3).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              CPU.cmpT(r3, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.addT(r6, 0x0);
                r3 = CPU.addT(r3, 0x54);
                r3 = MEMORY.ref(1, r3).getUnsigned();
                CPU.cmpT(r3, 0x1);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = MEMORY.ref(4, r0 + 0x50).get();
                  r3 = MEMORY.ref(1, r0 + 0x1d).getUnsigned();
                  r3 = CPU.orrT(r3, r1);
                  MEMORY.ref(1, r0 + 0x1d).setu(r3);
                  r5 = MEMORY.ref(1, r0 + 0x1c).getUnsigned();
                  r0 = MEMORY.ref(4, r6 + 0x50).get();
                  r3 = MEMORY.ref(1, r0 + 0x1d).getUnsigned();
                  r3 = CPU.orrT(r3, r1);
                  CPU.r8().value = r0;
                  MEMORY.ref(1, r0 + 0x1d).setu(r3);
                  r0 = MEMORY.ref(1, r0 + 0x1c).getUnsigned();
                  r0 = FUN_8003f3c(r0);
                  r1 = CPU.r8().value;
                  MEMORY.ref(1, r1 + 0x1c).setu(r5);
                }
              }
            }

            //LAB_808b4f6
            r0 = CPU.movT(0, 0x21);
            r0 = FUN_80770c0(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.r10().value;
              r3 = CPU.subT(r3, 0x12);
              CPU.cmpT(r3, 0x1);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r0 = CPU.addT(r6, 0x0);
                r1 = CPU.movT(0, 0xe2);
                FUN_8009228(r0, r1);
              }
            }
          } else {
            //LAB_808b512
            r0 = FUN_80770c0(0x109);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r1 = MEMORY.ref(4, r7 + 0x8).get();
              r2 = MEMORY.ref(4, r7 + 0xc).get();
              r3 = MEMORY.ref(4, r7 + 0x10).get();
              r0 = CPU.addT(r6, 0x0);
              FUN_80090f0(r0, r1, r2, r3);
            }
          }

          //LAB_808b528
          CPU.cmpT(r6, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r6, 0x0);
            r1 = CPU.movT(0, 0x1);
            FUN_8009080(r0, r1);
            r3 = CPU.addT(r6, 0x0);
            r3 = CPU.addT(r3, 0x54);
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              r2 = MEMORY.ref(4, r6 + 0x50).get();
              CPU.r8().value = r2;
              CPU.cmpT(r2, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = rand();
                r1 = CPU.movT(0, 0x1e);
                r0 = FUN_8002304(r0, r1);
                r3 = CPU.r8().value;
                r3 = CPU.addT(r3, 0x24);
                MEMORY.ref(1, r3).setu(r0);
              }
            }

            //LAB_808b556
            r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
            r2 = CPU.addT(r6, 0x0);
            MEMORY.ref(2, r6 + 0x6).setu(r3);
            r2 = CPU.addT(r2, 0x59);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2).setu(r3);
            r1 = MEMORY.ref(4, r7 + 0x4).get();
            r0 = CPU.addT(r6, 0x0);
            FUN_8093a6c(r0, r1);
            r0 = CPU.addT(r6, 0x0);
            r1 = CPU.movT(0, 0x1);
            FUN_8009080(r0, r1);
            r2 = MEMORY.ref(4, r6 + 0x8).get();
            CPU.cmpT(r2, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r2 = CPU.addT(r2, 0xffff);
            }

            //LAB_808b57c
            r3 = CPU.addT(r6, 0x0);
            r3 = CPU.addT(r3, 0x64);
            r2 = CPU.asrT(r2, 16);
            MEMORY.ref(2, r3).setu(r2);
            r3 = MEMORY.ref(4, r6 + 0x10).get();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r3 = CPU.addT(r3, 0xffff);
            }

            //LAB_808b58e
            r2 = CPU.addT(r6, 0x0);
            r3 = CPU.asrT(r3, 16);
            r2 = CPU.addT(r2, 0x66);
            MEMORY.ref(2, r2).setu(r3);
            r3 = MEMORY.ref(4, r6 + 0xc).get();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.movT(0, 0x4);
              r2 = CPU.subT(r2, 0x11);
              MEMORY.ref(1, r2).setu(r3);
              r1 = CPU.movT(0, 0x80);
              r3 = MEMORY.ref(4, r6 + 0xc).get();
              r1 = CPU.lslT(r1, 8);
              r3 = CPU.addT(r3, r1);
              MEMORY.ref(4, r6 + 0xc).setu(r3);
            }

            //LAB_808b5ac
            r3 = CPU.movT(0, 0xcf);
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r9().value;
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(2, r3 + r2).get();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r1 = CPU.addT(r6, 0x0);
              r1 = CPU.addT(r1, 0x55);
              r3 = MEMORY.ref(1, r1).getUnsigned();
              r2 = CPU.movT(0, 0xfe);
              r2 = CPU.andT(r2, r3);
              MEMORY.ref(1, r1).setu(r2);
              r0 = CPU.movT(0, 0x21);
              r0 = FUN_80770c0(r0);
              CPU.cmpT(r0, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r1 = CPU.r8().value;
                r0 = MEMORY.ref(4, r1 + 0x18).get();
                r1 = CPU.movT(0, 0xc0);
                r1 = CPU.lslT(r1, 8);
                r0 = CPU.lslT(r0, 0);
                r0 = (int)MEMORY.call(0x3000118, r0, r1);
                r2 = CPU.r8().value;
                MEMORY.ref(4, r2 + 0x18).setu(r0);
              }
            } else {
              //LAB_808b5e6
              r1 = MEMORY.ref(4, r6 + 0x8).get();
              r2 = MEMORY.ref(4, r6 + 0x10).get();
              r0 = CPU.movT(0, 0x0);
              r0 = FUN_80091a8(r0, r1, r2);
              r3 = MEMORY.ref(4, r6 + 0xc).get();
              r3 = CPU.addT(r3, r0);
              MEMORY.ref(4, r6 + 0x14).setu(r0);
              MEMORY.ref(4, r6 + 0xc).setu(r3);
            }

            //LAB_808b5f8
            r2 = CPU.addT(r6, 0x0);
            r2 = CPU.addT(r2, 0x23);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2).setu(r3);
          }

          //LAB_808b600
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = CPU.lslT(r0, 2);
          r3 = CPU.addT(r3, 0x14);
          r1 = CPU.r9().value;
          MEMORY.ref(4, r1 + r3).setu(r6);
        }
      }

      //LAB_808b60a
      r7 = CPU.addT(r7, 0x18);
      r3 = MEMORY.ref(2, r7).getUnsigned();
      r2 = CPU.addT(r3, 0x0);
      r3 = CPU.lslT(r2, 16);
      r0 = CPU.movT(0, 0x1);
      r3 = CPU.asrT(r3, 16);
      r0 = CPU.negT(r0, r0);

      //LAB_808b618
    }

    //LAB_808b624
    CPU.sp().value += 0x8;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808b674)
  public static void FUN_808b674(int r0) {
    final int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.r10().value = r0;
    CPU.r8().value = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r7 = MEMORY.ref(4, 0x2000434).get();
    r5 = CPU.r8().value + 0x200;
    r2 = r5;

    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f810).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f814).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f818).get());
    r2 += 0x4;

    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f81c).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f820).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f824).get());

    r2 = CPU.r8().value + 0x218;

    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f828).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f82c).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f830).get());
    r2 += 0x4;

    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f834).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f838).get());
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f83c).get());

    r3 = CPU.r8().value + 0xc;
    CPU.r12().value = CPU.r8().value;

    //LAB_808b6b6
    do {
      MEMORY.ref(4, r3).setu(0);
      r3 -= 0x4;
    } while(r3 >= CPU.r12().value);

    FUN_808b9f8();
    MEMORY.ref(2, r5).setu(r7);
    MEMORY.ref(2, r5 + 0x2).setu(0xffff);
    MEMORY.ref(4, r5 + 0xc).setu(0);
    MEMORY.ref(4, r5 + 0x8).setu(MEMORY.ref(4, 0x2000240 + 0x1dc).get());
    MEMORY.ref(4, r5 + 0x10).setu(MEMORY.ref(4, 0x2000240 + 0x1e4).get());
    MEMORY.ref(2, r5 + 0x14).setu(MEMORY.ref(4, 0x2000240 + 0x1e8).get());
    FUN_808b3ec(r5, r7);
    FUN_808b3ec(CPU.r10().value, 0x8);
    r5 = MEMORY.ref(4, CPU.r8().value + 0x14 + r7 * 0x4).get();
    MEMORY.ref(1, r5 + 0x22).setu(MEMORY.ref(2, 0x200042c).getUnsigned());

    r3 = (MEMORY.ref(4, r5 + 0x8).get() / 0x100000 + MEMORY.ref(4, r5 + 0x10).get() / 0x100000 * 0x80) * 0x4;
    r2 = 0x2010000 + r3;
    r1 = 0x200fe00 + r3;

    if(MEMORY.ref(4, 0x2000420).get() != 0 && MEMORY.ref(1, r2 + 0x2).getUnsigned() == 0xfd && MEMORY.ref(1, r1 + 0x2).getUnsigned() == 0xfd) {
      MEMORY.ref(1, 0x2000432).setu(0x1);
      r0 = FUN_80091a8(0, MEMORY.ref(4, r5 + 0x8).get(), MEMORY.ref(4, r5 + 0x10).get() + 0xfff00000);
      r3 = MEMORY.ref(4, r5 + 0xc).get();
      r0 = CPU.addT(r0, 0xffe00000);
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(4, r5 + 0xc).setu(r3);
      MEMORY.ref(4, r5 + 0x14).setu(r3);
      MEMORY.ref(1, r5 + 0x55).setu(0);
      FUN_80091e0(r5, 0);
      FUN_8009080(r5, 0xc);
    } else {
      //LAB_808b7b8
      MEMORY.ref(1, 0x2000432).setu(0);
    }

    //LAB_808b7c4
    r6 = FUN_80090c8(0x8000, MEMORY.ref(4, r5 + 0x8).get(), MEMORY.ref(4, r5 + 0xc).get(), MEMORY.ref(4, r5 + 0x10).get());
    MEMORY.ref(4, r6 + 0x14).setu(MEMORY.ref(4, r5 + 0x14).get());
    FUN_80090e0(r6, r5);

    if(MEMORY.ref(2, CPU.r8().value + 0x19e).get() == 3) {
      r0 = FUN_8009048(MEMORY.ref(4, r5 + 0x50).get(), 0x17);
      MEMORY.ref(1, r0 + 0x5).setu(0xf);
      MEMORY.ref(1, r0 + 0x6).setu(0x9);
    }

    //LAB_808b7fc
    r2 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    MEMORY.ref(4, r2).setu(r6 + 0x8);
    MEMORY.ref(4, CPU.r8().value + 0x1e0).setu(r6);

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x808b868)
  public static void FUN_808b868(final int r0) {
    final int r6 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    FUN_80770d0(0x164);
    FUN_80770c8(0x165);

    //LAB_808b894
    int r5 = r0;
    while(MEMORY.ref(2, r5).get() != -1) {
      if(MEMORY.ref(2, r5 + 0x2).get() == 0) {
        final int r2 = MEMORY.ref(4, r5 + 0x8).get();
        final int r1 = MEMORY.ref(4, r5 + 0x10).get();

        if(r2 >= MEMORY.ref(4, r6 + 0xec).get() && r2 <= MEMORY.ref(4, r6 + 0xf4).get() && r1 >= MEMORY.ref(4, r6 + 0xf0).get() && r1 <= MEMORY.ref(4, r6 + 0xf8).get()) {
          MEMORY.ref(2, r5 + 0x2).setu(0x164);
        } else {
          //LAB_808b8cc
          MEMORY.ref(2, r5 + 0x2).setu(0x165);
        }
      }

      //LAB_808b8ce
      r5 += 0x18;
    }

    //LAB_808b8d8
  }

  @Method(0x808b9f8)
  public static void FUN_808b9f8() {
    int r2;
    int r3;

    r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x118;
    r2 = 0x41;

    //LAB_808ba08
    do {
      MEMORY.ref(4, r3).setu(0);
      r3 -= 0x4;
      r2--;
    } while(r2 >= 0);
  }

  @Method(0x808ba1c)
  public static int FUN_808ba1c(final int r0) {
    if(r0 < 0 || r0 >= 0xc0) {
      return 0;
    }

    final int r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    return MEMORY.ref(4, r2 + 0x14 + r0 * 0x4).get();
  }

  @Method(0x808ba38)
  public static void FUN_808ba38() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bb2c)
  public static void FUN_808bb2c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bc44)
  public static void FUN_808bc44() {
    int r0;
    final int r1;
    int r3;

    r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r0 = 0x16c;
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(0);
    r3 = CPU.addT(r1, r0);
    MEMORY.ref(2, r3).setu(0);
  }

  @Method(0x808bc9c)
  public static int FUN_808bc9c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bec0)
  public static void FUN_808bec0(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c44c)
  public static void FUN_808c44c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c4c0)
  public static void FUN_808c4c0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c4f8)
  public static int FUN_808c4f8(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x10;
    CPU.r8().value = mallocSlotBoard(27, 0xccc);
    r0 = CPU.sp().value + 0xc;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(CPU.r8().value);
    DMA.channels[3].CNT.setu(0x85000333);

    FUN_80770d0(0x103);
    MEMORY.ref(2, 0x2000408).setu(MEMORY.ref(2, 0x2000400).getUnsigned());
    MEMORY.ref(2, 0x200040a).setu(MEMORY.ref(2, 0x2000402).getUnsigned());
    MEMORY.ref(2, 0x200040e).setu(MEMORY.ref(4, 0x808c804).get());
    MEMORY.ref(2, 0x2000410).setu(-1);
    MEMORY.ref(2, 0x2000412).setu(-1);
    MEMORY.ref(2, 0x2000414).setu(-1);
    FUN_80040e8();
    FUN_8095778(0);
    r0 = MEMORY.ref(2, 0x200041a).get();
    if(r0 == 1) {
      FUN_8009118();
      MEMORY.ref(1, 0x2000464).setu(1);
      FUN_808ace0(0);
      r6 = 3;
    } else {
      //LAB_808c598
      FUN_8009110(r0);
      FUN_808ace0(1);
      r6 = 2;
    }

    //LAB_808c5a4
    MEMORY.ref(2, CPU.r8().value + 0x19e).setu(r6);
    FUN_8009078(r6);
    FUN_8015000();
    FUN_808bc44();
    MEMORY.ref(4, CPU.r8().value + 0x10).setu((int)MEMORY.call(MEMORY.ref(4, 0x2008024).get()));
    FUN_808cf78();
    FUN_808b674((int)MEMORY.call(MEMORY.ref(4, 0x200801c).get()));

    if(FUN_80770c0(0x109) != 0) {
      FUN_808bb2c();
    }

    //LAB_808c5e2
    if(MEMORY.ref(2, 0x2000474).get() != 0) {
      FUN_8095680();
    }

    //LAB_808c5f6
    if(r6 == 3) {
      FUN_8009130();
      FUN_8009138(MEMORY.ref(4, 0x200041c).get(), MEMORY.ref(4, 0x2000424).get());
    } else {
      //LAB_808c614
      FUN_8009128();
    }

    //LAB_808c618
    FUN_808e9c0();
    FUN_8091174();
    FUN_8091200(0x10000, 0);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(CPU.r8().value + 0x1c0);
    MEMORY.ref(4, CPU.r8().value + 0x1c0).setu(0x100);
    MEMORY.ref(4, CPU.r8().value + 0x1c8).setu(0x10);
    CPU.r10().value = CPU.r8().value + 0x1c8;
    r7 = CPU.r8().value + 0x1c6;
    MEMORY.ref(2, CPU.r8().value + 0x1c6).setu(0);
    MEMORY.ref(4, CPU.r8().value + 0x1b0).setu(0x199);
    MEMORY.ref(4, CPU.r8().value + 0x1b4).setu(0);
    CPU.r11().value = 0x10;

    if(MEMORY.ref(2, 0x200047e).get() == 2) {
      MEMORY.ref(4, CPU.r8().value + 0x1b0).setu(0);
      FUN_80770c8(0x144);
    }

    //LAB_808c678
    CPU.r9().value = 0x109;
    MEMORY.ref(4, CPU.r8().value + 0x1bc).setu(0x2010000);

    if(FUN_80770c0(CPU.r9().value) == 0) {
      FUN_808b1d8();
      MEMORY.ref(2, 0x200046c).setu(CPU.r11().value);
      MEMORY.ref(2, 0x200046e).setu(0);
      MEMORY.ref(2, 0x2000470).setu(0x1);
      MEMORY.ref(2, 0x200048a).setu(0xffff);
      MEMORY.ref(2, 0x200048c).setu(0);
    }

    //LAB_808c6bc
    FUN_8099810();
    r2 = MEMORY.ref(4, 0x808c828).get();
    r3 = MEMORY.ref(4, 0x808c804).get();
    r2 += CPU.r8().value;
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x808c80c).get();
    r0 = MEMORY.ref(4, r3 + 0x4).get();
    MEMORY.call(r0);
    r3 = CPU.movT(0, 0xb8);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r8().value;
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r7 = CPU.addT(r0, 0x0);
      MEMORY.ref(2, r3).setu(0);
    } else {
      //LAB_808c6ec
      r0 = CPU.r9().value;
      FUN_80770d0(r0);
      r0 = FUN_808bc9c();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r5 = MEMORY.ref(2, r7).getUnsigned();
        CPU.cmpT(r5, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r4 = CPU.r10().value;
          r0 = MEMORY.ref(4, r3).get();
          r1 = MEMORY.ref(4, r4).get();
          FUN_808fefc(r0, r1);
          r3 = CPU.movT(0, 0x1);
          MEMORY.ref(2, r7).setu(r3);
          r3 = CPU.movT(0, 0xa0);
          r3 = CPU.lslT(r3, 19);
          MEMORY.ref(2, r3).setu(r5);
          r0 = FUN_8094428();
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = CPU.r10().value;
            r0 = MEMORY.ref(4, r1).get();
            r0 = CPU.addT(r0, 0x1);
            r3 = CPU.lsrT(r0, 31);
            r0 = CPU.addT(r0, r3);
            r0 = CPU.asrT(r0, 1);
            FUN_80030f8(r0);
          }
        }

        //LAB_808c72e
        r5 = MEMORY.ref(4, 0x808c82c).get();
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r5, 0x0);
          FUN_80770d0(r0);
          r3 = MEMORY.ref(4, 0x808c800).get();
          r2 = CPU.movT(0, 0xe0);
          r2 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r3, r2);
          r4 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(2, r3 + r4).get();
          FUN_8015200(r0);
        }

        //LAB_808c750
        r5 = MEMORY.ref(4, 0x808c800).get();
        r1 = CPU.movT(0, 0x8d);
        r1 = CPU.lslT(r1, 2);
        r6 = CPU.addT(r5, r1);
        r2 = CPU.movT(0, 0x0);
        r0 = MEMORY.ref(2, r6 + r2).get();
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0x1);
          FUN_8095778(r0);
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(2, r6).setu(r3);
        }

        //LAB_808c76a
        r3 = CPU.movT(0, 0x8f);
        r3 = CPU.lslT(r3, 2);
        r5 = CPU.addT(r5, r3);
        r3 = MEMORY.ref(2, r5).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          FUN_808c44c();
          r0 = MEMORY.ref(2, r5).getUnsigned();
          r0 = FUN_80919d8(r0);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = MEMORY.ref(2, r5).getUnsigned();
            r1 = CPU.movT(0, 0x0);
            r0 = FUN_8091a58(r0, r1);
          }

          //LAB_808c78c
          FUN_808c4c0();
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(2, r5).setu(r3);
        }
      }

      //LAB_808c794
      r4 = MEMORY.ref(4, 0x808c800).get();
      r1 = CPU.movT(0, 0x0);
      CPU.r9().value = r4;
      CPU.r11().value = r1;

      //LAB_808c79c
      outer:
      do {
        r0 = CPU.movT(0, 0x82);
        r0 = CPU.lslT(r0, 1);
        FUN_80770c8(r0);
        r2 = MEMORY.ref(4, 0x808c830).get();
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.lslT(r3, 2);
        r4 = CPU.r8().value;
        r3 = CPU.addT(r3, 0x14);
        r3 = MEMORY.ref(4, r4 + r3).get();
        CPU.r10().value = r3;
        r0 = CPU.r10().value;
        FUN_8009140(r0);
        r1 = CPU.r10().value;
        r2 = CPU.movT(0, 0xee);
        r3 = MEMORY.ref(4, r1 + 0x8).get();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r3 = CPU.movT(0, 0xf0);
        r3 = CPU.lslT(r3, 1);
        r3 += CPU.r9().value;
        r2 = CPU.r11().value;
        MEMORY.ref(4, r3).setu(r2);
        r2 = CPU.movT(0, 0xf2);
        r3 = MEMORY.ref(4, r1 + 0x10).get();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r2 = CPU.movT(0, 0xf4);
        r3 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r3 = CPU.r10().value;
        r3 = CPU.addT(r3, 0x22);
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r4 = MEMORY.ref(4, 0x808c834).get();
        MEMORY.ref(2, r4).setu(r3);

        //LAB_808c838
        while(FUN_808bc9c() != 0) {
          r1 = CPU.movT(0, 0xb8);
          r1 = CPU.lslT(r1, 1);
          r1 += CPU.r8().value;
          r2 = CPU.movT(0, 0x0);
          r5 = MEMORY.ref(2, r1 + r2).get();
          CPU.cmpT(r5, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_808c6e4
            r3 = CPU.movT(0, 0x0);
            r7 = CPU.addT(r5, 0x0);
            MEMORY.ref(2, r1).setu(r3);
            break outer;
          }

          //LAB_808c848
          r2 = CPU.movT(0, 0xc1);
          r2 = CPU.lslT(r2, 1);
          r2 += CPU.r8().value;
          r3 = CPU.movT(0, 0x0);
          r6 = MEMORY.ref(2, r2 + r3).get();
          CPU.cmpT(r6, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_808c858
            r3 = MEMORY.ref(4, 0x808c890).get();
            r4 = MEMORY.ref(4, 0x808c88c).get();
            r3 += CPU.r8().value;
            MEMORY.ref(2, r3).setu(r4);
            r1 = CPU.movT(0, 0x0);
            r0 = MEMORY.ref(2, r2 + r1).get();
            r2 = CPU.movT(0, 0x1);
            r2 = CPU.negT(r2, r2);
            r0 = CPU.cmpT(r0, r2);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_808c9d4
              r3 = MEMORY.ref(4, 0x808caa0).get();
              r0 = CPU.cmpT(r0, r3);
              if(CPU.cpsr().getZero()) { // ==
                FUN_8091660();
                r0 = MEMORY.ref(4, 0x808caa4).get();
                FUN_809c138(r0);
              } else {
                //LAB_808c9e6
                r4 = MEMORY.ref(4, 0x808caa8).get();
                r0 = CPU.cmpT(r0, r4);
                if(CPU.cpsr().getZero()) { // ==
                  FUN_8091660();
                  FUN_809c3a4();
                } else {
                  //LAB_808c9f6
                  FUN_808d7d8(r0);
                }
              }
            } else {
              //LAB_808c86e
              FUN_8091660();
              FUN_808c44c();
              r3 = CPU.movT(0, 0xc2);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r4 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r4).get();
              r6 = CPU.movT(0, 0x0);
              r5 = CPU.cmpT(r5, r3);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r5 = CPU.movT(0, 0xc4);
                r5 = CPU.lslT(r5, 1);

                //LAB_808c894
                do {
                  r0 = CPU.r10().value;
                  r1 = CPU.movT(0, 0x16);
                  FUN_8009080(r0, r1);
                  r1 = CPU.r8().value;
                  r0 = MEMORY.ref(2, r5 + r1).get();
                  r1 = CPU.movT(0, 0x1);
                  FUN_8015120(r0, r1);
                  r0 = MEMORY.ref(4, 0x808c8f8).get();
                  r1 = CPU.movT(0, 0x1);
                  FUN_8015040(r0, r1);
                  r3 = CPU.movT(0, 0xc2);
                  r3 = CPU.lslT(r3, 1);
                  r3 += CPU.r8().value;
                  r4 = CPU.movT(0, 0x0);
                  r3 = MEMORY.ref(2, r3 + r4).get();
                  r6 = CPU.addT(r6, 0x1);
                  r5 = CPU.addT(r5, 0x2);
                  r6 = CPU.cmpT(r6, r3);
                } while(!CPU.cpsr().getCarry()); // unsigned <
              }

              //LAB_808c8c0
              r3 = CPU.movT(0, 0xc3);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r1 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r1).get();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_808c9c0
                FUN_808c4c0();
              } else {
                //LAB_808c8d0
                r2 = MEMORY.ref(4, 0x808c8fc).get();
                r3 = MEMORY.ref(4, r2).get();
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = CPU.movT(0, 0x20);
                  r0 = FUN_80770c0(r0);
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = CPU.r10().value;
                    r1 = CPU.movT(0, 0x15);
                    FUN_8009080(r0, r1);
                  } else {
                    //LAB_808c8ec
                    r0 = CPU.r10().value;
                    r1 = CPU.movT(0, 0x25);
                    FUN_8009080(r0, r1);
                  }
                } else {
                  //LAB_808c900
                  r0 = CPU.r10().value;
                  r1 = CPU.movT(0, 0x13);
                  FUN_8009080(r0, r1);
                }

                //LAB_808c908
                r0 = CPU.movT(0, 0x3b);
                FUN_80f9010(r0);
                r1 = CPU.movT(0, 0x1);
                r0 = MEMORY.ref(4, 0x808c948).get();
                FUN_8015040(r0, r1);
                r3 = MEMORY.ref(4, 0x808c94c).get();
                r0 = MEMORY.ref(4, r3).get();
                r0 = FUN_8077008(r0);
                r4 = MEMORY.ref(4, 0x808c944).get();
                r6 = CPU.addT(r0, 0x0);
                MEMORY.ref(2, r6 + 0x38).setu(r4);
                r1 = CPU.movT(0, 0x1);
                r5 = CPU.lslT(r1, 14);
                r0 = CPU.addT(r5, 0x0);
                r2 = CPU.movT(0, 0x34);
                r1 = MEMORY.ref(2, r6 + r2).get();
                r0 = FUN_80022ec(r0, r1);
                r3 = CPU.movT(0, 0x80);
                r3 = CPU.lslT(r3, 7);
                r0 = CPU.cmpT(r0, r3);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r5 = CPU.movT(0, 0x0);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                    r5 = CPU.addT(r0, 0x0);
                  }
                }

                //LAB_808c950
                r3 = CPU.lslT(r5, 16);
                MEMORY.ref(2, r6 + 0x14).setu(r5);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r4 = CPU.movT(0, 0x38);
                  r3 = MEMORY.ref(2, r6 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r1 = MEMORY.ref(4, 0x808c984).get();
                    MEMORY.ref(2, r6 + 0x14).setu(r1);
                  }
                }

                //LAB_808c964
                r2 = CPU.movT(0, 0x3a);
                r0 = MEMORY.ref(2, r6 + r2).get();
                r3 = CPU.movT(0, 0x36);
                r1 = MEMORY.ref(2, r6 + r3).get();
                r0 = CPU.lslT(r0, 14);
                r0 = FUN_80022ec(r0, r1);
                r3 = CPU.movT(0, 0x80);
                r3 = CPU.lslT(r3, 7);
                r0 = CPU.cmpT(r0, r3);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r3 = CPU.movT(0, 0x0);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                    r3 = CPU.addT(r0, 0x0);
                  }
                }

                //LAB_808c988
                MEMORY.ref(2, r6 + 0x16).setu(r3);
                r3 = CPU.lslT(r3, 16);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r4 = CPU.movT(0, 0x3a);
                  r3 = MEMORY.ref(2, r6 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r1 = MEMORY.ref(4, 0x808c9c8).get();
                    MEMORY.ref(2, r6 + 0x16).setu(r1);
                  }
                }

                //LAB_808c99c
                r3 = CPU.movT(0, 0xe2);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                r2 = MEMORY.ref(2, r3).getUnsigned();
                r3 = CPU.movT(0, 0xe0);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                MEMORY.ref(2, r3).setu(r2);
                r3 = CPU.movT(0, 0xe3);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                r3 = MEMORY.ref(2, r3).getUnsigned();
                r2 = MEMORY.ref(4, 0x808c9cc).get();
                MEMORY.ref(2, r2).setu(r3);
                FUN_808c4c0();
                r7 = MEMORY.ref(4, 0x808c9d0).get();
                break outer;
              }
            }

            //LAB_808c9fa
            r3 = MEMORY.ref(4, 0x808caac).get();
            r1 = CPU.r11().value;
            r3 += CPU.r8().value;
            MEMORY.ref(2, r3).setu(r1);
            r3 = CPU.movT(0, 0xc1);
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r8().value;
            r2 = CPU.r11().value;
            MEMORY.ref(2, r3).setu(r2);
          } else {
            //LAB_808ca0e
            r5 = CPU.movT(0, 0xbe);
            r5 = CPU.lslT(r5, 1);
            r5 += CPU.r8().value;
            r3 = CPU.movT(0, 0x0);
            r7 = MEMORY.ref(2, r5 + r3).get();
            CPU.cmpT(r7, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
              FUN_8091660();
              FUN_808ba38();
              r2 = MEMORY.ref(4, 0x808cab0).get();
              r3 = MEMORY.ref(4, 0x808cab4).get();
              r2 += CPU.r9().value;
              MEMORY.ref(2, r2).setu(r3);
              r2 = CPU.movT(0, 0xe0);
              r2 = CPU.lslT(r2, 1);
              r3 = CPU.movT(0, 0xff);
              r2 += CPU.r9().value;
              r3 = CPU.lslT(r3, 1);
              MEMORY.ref(2, r2).setu(r3);
              r4 = MEMORY.ref(4, 0x808cab8).get();
              r3 = MEMORY.ref(2, r5).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              MEMORY.ref(2, r4).setu(r3);
              r3 = MEMORY.ref(4, 0x808cabc).get();
              MEMORY.ref(2, r1).setu(r3);
              r1 = CPU.movT(0, 0x0);
              r0 = MEMORY.ref(2, r5 + r1).get();
              FUN_80941e0(r0);
              r3 = CPU.movT(0, 0xd4);
              r3 = CPU.lslT(r3, 1);
              r2 = MEMORY.ref(4, 0x808cac0).get();
              r3 += CPU.r8().value; // returned from last method call
              MEMORY.ref(4, r3).setu(r6);
              MEMORY.ref(2, r5).setu(r6);
              MEMORY.ref(4, r2).setu(r6);
            } else {
              //LAB_808ca5e
              r3 = CPU.movT(0, 0xb6);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r4 = CPU.movT(0, 0x0);
              r6 = MEMORY.ref(2, r3 + r4).get();
              CPU.cmpT(r6, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = MEMORY.ref(4, 0x808caac).get();
                r1 = MEMORY.ref(4, 0x808ca9c).get();
                r5 += CPU.r8().value;
                MEMORY.ref(2, r5).setu(r1);
                r2 = CPU.movT(0, 0x0);
                r0 = MEMORY.ref(2, r3 + r2).get();
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r0 = FUN_808d828(r0);
                r3 = MEMORY.ref(4, CPU.sp().value).get();
                MEMORY.ref(2, r5).setu(r7);
                MEMORY.ref(2, r3).setu(r7);
              } else {
                //LAB_808ca86
                r5 = CPU.movT(0, 0xb7);
                r5 = CPU.lslT(r5, 1);
                r5 += CPU.r8().value;
                r3 = CPU.movT(0, 0x0);
                r0 = MEMORY.ref(2, r5 + r3).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = FUN_808d8f0(r0);
                  MEMORY.ref(2, r5).setu(r6);
                } else {
                  //LAB_808cac4
                  r3 = CPU.movT(0, 0xba);
                  r3 = CPU.lslT(r3, 1);
                  r3 += CPU.r8().value;
                  r4 = CPU.movT(0, 0x0);
                  r3 = MEMORY.ref(2, r3 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    FUN_8015208();
                    r1 = MEMORY.ref(4, 0x808cb18).get();
                    r0 = MEMORY.ref(4, r1).get();
                    r0 = FUN_808ddec(r0, r1);
                    r2 = CPU.movT(0, 0x1);
                    r5 = CPU.addT(r0, 0x0);
                    r2 = CPU.negT(r2, r2);
                    r6 = CPU.movT(0, 0x0);
                    r5 = CPU.cmpT(r5, r2);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = FUN_808d5a4(r0);
                      CPU.cmpT(r0, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r0 = CPU.movT(0, 0x1);
                      }

                      //LAB_808caf4
                      r6 = CPU.addT(r0, 0x0);
                    }

                    //LAB_808caf6
                    CPU.cmpT(r6, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r3 = MEMORY.ref(4, 0x808cb14).get();
                      r5 = CPU.orrT(r5, r3);
                      r3 = CPU.movT(0, 0xbc);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      MEMORY.ref(2, r3).setu(r5);
                      r3 = CPU.movT(0, 0xb9);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      r4 = CPU.r11().value;
                      MEMORY.ref(2, r3).setu(r4);
                    } else {
                      //LAB_808cb1c
                      r0 = FUN_808ce74();
                      r6 = CPU.addT(r0, 0x0);
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r3 = CPU.movT(0, 0xbd);
                        r3 = CPU.lslT(r3, 1);
                        r3 += CPU.r8().value;
                        MEMORY.ref(2, r3).setu(r6);
                        r3 = CPU.movT(0, 0xb9);
                        r3 = CPU.lslT(r3, 1);
                        r3 += CPU.r8().value;
                        r1 = CPU.r11().value;
                        MEMORY.ref(2, r3).setu(r1);
                      } else {
                        //LAB_808cb3a
                        r3 = CPU.movT(0, 0xb9);
                        r3 = CPU.lslT(r3, 1);
                        r2 = MEMORY.ref(4, 0x808cb48).get();
                        r3 += CPU.r8().value;
                        MEMORY.ref(2, r3).setu(r2);
                      }
                    }

                    //LAB_808cb44
                    r3 = CPU.movT(0, 0xba);
                    r3 = CPU.lslT(r3, 1);
                    r3 += CPU.r8().value;
                    r4 = CPU.r11().value;
                    MEMORY.ref(2, r3).setu(r4);
                  } else {
                    //LAB_808cb4c
                    r3 = CPU.movT(0, 0xb9);
                    r3 = CPU.lslT(r3, 1);
                    r3 += CPU.r8().value;
                    r1 = CPU.movT(0, 0x0);
                    r7 = MEMORY.ref(2, r3 + r1).get();
                    CPU.cmpT(r7, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      FUN_8015208();
                      FUN_8091660();
                      r0 = CPU.movT(0, 0x6f);
                      FUN_80f9010(r0);
                      FUN_808c44c();
                      r0 = CPU.movT(0, 0x83);
                      r0 = CPU.lslT(r0, 1);
                      FUN_80770c8(r0);

                      r1 = MEMORY.ref(4, 0x808cbdc).get();
                      if(MEMORY.ref(4, 0x808cbd8).deref(1).getUnsigned() == 0 || (MEMORY.ref(4, r1).get() & 0x2) == 0 || (MEMORY.ref(4, r1).get() & 0x4) == 0) {
                        //LAB_808cb98
                        r0 = MEMORY.ref(4, 0x808cbe0).get();
                        r0 = FUN_80770c0(r0);
                        CPU.cmpT(r0, 0x0);
                        if(!CPU.cpsr().getZero()) { // !=
                          r2 = CPU.movT(0, 0xc1);
                          r2 = CPU.lslT(r2, 1);
                          r2 += CPU.r8().value;
                          r3 = CPU.movT(0, 0xfa);
                          MEMORY.ref(2, r2).setu(r3);
                        } else {
                          //LAB_808cbae
                          r5 = CPU.movT(0, 0xcc);
                          r5 = CPU.lslT(r5, 4);
                          r5 += CPU.r8().value;
                          MEMORY.ref(2, r5).setu(r0);
                          r0 = FUN_80151e8();
                          r2 = MEMORY.ref(4, 0x808cbd4).get();
                          MEMORY.ref(2, r5).setu(r2);
                        }
                      } else {
                        r0 = FUN_8015290();
                      }

                      //LAB_808cbbe
                      FUN_808c4c0();
                      r0 = CPU.movT(0, 0x83);
                      r0 = CPU.lslT(r0, 1);
                      FUN_80770d0(r0);
                      FUN_80772f0();
                      r3 = CPU.movT(0, 0xb9);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      r4 = CPU.r11().value;
                      MEMORY.ref(2, r3).setu(r4);
                    } else {
                      //LAB_808cbe4
                      r5 = CPU.movT(0, 0xbc);
                      r5 = CPU.lslT(r5, 1);
                      r5 += CPU.r8().value;
                      r1 = CPU.movT(0, 0x0);
                      r6 = MEMORY.ref(2, r5 + r1).get();
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        FUN_808c44c();
                        r3 = MEMORY.ref(2, r5).getUnsigned();
                        r0 = MEMORY.ref(4, 0x808cc20).get();
                        r0 = CPU.andT(r0, r3);
                        r0 = FUN_808d5dc(r0);

                        //LAB_808cc42
                        FUN_808c4c0();
                        MEMORY.ref(2, r5).setu(r7);
                      } else {
                        //LAB_808cc02
                        r5 = CPU.movT(0, 0xbd);
                        r5 = CPU.lslT(r5, 1);
                        r5 += CPU.r8().value;
                        r2 = CPU.movT(0, 0x0);
                        r7 = MEMORY.ref(2, r5 + r2).get();
                        CPU.cmpT(r7, 0x0);
                        if(!CPU.cpsr().getZero()) { // !=
                          FUN_808c44c();
                          r3 = CPU.movT(0, 0x0);
                          r0 = MEMORY.ref(2, r5 + r3).get();
                          r0 = FUN_808d9a4(r0);

                          //LAB_808cc6e
                          FUN_808c4c0();
                          MEMORY.ref(2, r5).setu(r6);
                        } else {
                          //LAB_808cc24
                          r5 = CPU.movT(0, 0xbf);
                          r5 = CPU.lslT(r5, 1);
                          r5 += CPU.r8().value;
                          r4 = CPU.movT(0, 0x0);
                          r6 = MEMORY.ref(2, r5 + r4).get();
                          CPU.cmpT(r6, 0x0);
                          if(!CPU.cpsr().getZero()) { // !=
                            FUN_8015208();
                            FUN_808c44c();
                            r1 = CPU.movT(0, 0x0);
                            r0 = MEMORY.ref(2, r5 + r1).get();
                            r0 = FUN_808e680(r0);
                            FUN_808c4c0();
                            MEMORY.ref(2, r5).setu(r7);
                          } else {
                            //LAB_808cc4a
                            r5 = CPU.movT(0, 0xc0);
                            r5 = CPU.lslT(r5, 1);
                            r5 += CPU.r8().value;
                            r2 = CPU.movT(0, 0x0);
                            r3 = MEMORY.ref(2, r5 + r2).get();
                            CPU.cmpT(r3, 0x0);
                            if(!CPU.cpsr().getZero()) { // !=
                              FUN_808c44c();
                              r3 = CPU.movT(0, 0x0);
                              r0 = MEMORY.ref(2, r5 + r3).get();
                              r3 = CPU.movT(0, 0xcd);
                              r3 = CPU.lslT(r3, 1);
                              r3 += CPU.r8().value;
                              r4 = CPU.movT(0, 0x0);
                              r1 = MEMORY.ref(2, r3 + r4).get();
                              r0 = FUN_808e23c(r0, r1);
                              FUN_808c4c0();
                              MEMORY.ref(2, r5).setu(r6);
                            } else {
                              //LAB_808cc76
                              r3 = CPU.movT(0, 0xbb);
                              r3 = CPU.lslT(r3, 1);
                              r3 += CPU.r8().value;
                              r1 = CPU.movT(0, 0x0);
                              r3 = MEMORY.ref(2, r3 + r1).get();
                              CPU.cmpT(r3, 0x0);
                              if(!CPU.cpsr().getZero()) { // !=
                                r0 = CPU.movT(0, 0x6f);
                                FUN_80f9010(r0);
                                FUN_8091660();
                                FUN_808c44c();
                                r0 = CPU.movT(0, 0x83);
                                r0 = CPU.lslT(r0, 1);
                                FUN_80770c8(r0);
                                r1 = MEMORY.ref(4, 0x808cd40).get();
                                if(MEMORY.ref(1, r1).getUnsigned() != 0 && (MEMORY.ref(4, 0x808cd44).deref(4).get() & 0x2) != 0) {
                                  r0 = FUN_8015288();
                                } else {
                                  //LAB_808ccb4
                                  if(MEMORY.ref(1, r1).getUnsigned() != 0 && (MEMORY.ref(4, 0x808cd44).deref(4).get() & 0x200) != 0) {
                                    FUN_808d0c8();
                                  } else {
                                    //LAB_808ccce
                                    r0 = MEMORY.ref(4, 0x808cd48).get();
                                    r0 = FUN_80770c0(r0);
                                    CPU.cmpT(r0, 0x0);
                                    if(!CPU.cpsr().getZero()) { // !=
                                      r2 = CPU.movT(0, 0xc1);
                                      r2 = CPU.lslT(r2, 1);
                                      r2 += CPU.r8().value;
                                      r3 = CPU.movT(0, 0xfa);
                                      MEMORY.ref(2, r2).setu(r3);
                                    } else {
                                      //LAB_808cce4
                                      FUN_808e118();
                                      FUN_8015208();
                                      r0 = FUN_80f9070();
                                      r3 = MEMORY.ref(4, 0x808cd4c).get();
                                      r3 += CPU.r9().value;
                                      MEMORY.ref(2, r3).setu(r0);
                                      r0 = CPU.movT(0, 0xbf);
                                      r0 = CPU.lslT(r0, 1);
                                      r0 = FUN_80770c0(r0);
                                      CPU.cmpT(r0, 0x0);
                                      if(CPU.cpsr().getZero()) { // ==
                                        r3 = MEMORY.ref(4, 0x808cd50).get();
                                        r2 = CPU.movT(0, 0x80);
                                        r5 = MEMORY.ref(4, r3).get();
                                        r1 = MEMORY.ref(4, 0x808cd54).get();
                                        r0 = CPU.movT(0, 0x0);
                                        r2 = CPU.lslT(r2, 2);

                                        //LAB_808cd0e
                                        do {
                                          r3 = MEMORY.ref(1, r1).getUnsigned();
                                          r1 = CPU.addT(r1, 0x1);
                                          CPU.cmpT(r3, 0xff);
                                          if(CPU.cpsr().getZero()) { // ==
                                            r0 = CPU.addT(r0, 0x1);
                                          }

                                          //LAB_808cd18
                                          r2 = CPU.subT(r2, 0x1);
                                          CPU.cmpT(r2, 0x0);
                                        } while(!CPU.cpsr().getZero()); // !=

                                        r3 = CPU.addT(r0, 0x0);
                                        r3 = CPU.subT(r3, 0x88);
                                        CPU.cmpT(r3, 0x0);
                                        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                                          r2 = MEMORY.ref(4, 0x808cd3c).get();
                                          r0 = CPU.movT(0, 0x1);
                                          MEMORY.ref(2, r5 + 0x4).setu(r2);
                                          FUN_80030f8(r0);
                                        }

                                        //LAB_808cd30
                                        r0 = CPU.movT(0, 0x0);
                                        r0 = FUN_8015370(r0);
                                        r3 = CPU.r11().value;
                                        MEMORY.ref(2, r5 + 0x4).setu(r3);
                                      } else {
                                        //LAB_808cd58
                                        r0 = MEMORY.ref(4, 0x808ce60).get();
                                        r1 = CPU.movT(0, 0x1);
                                        FUN_8015040(r0, r1);
                                      }
                                    }
                                  }
                                }

                                //LAB_808cd60
                                FUN_808c4c0();
                                r0 = CPU.movT(0, 0x83);
                                r0 = CPU.lslT(r0, 1);
                                FUN_80770d0(r0);
                                r3 = CPU.movT(0, 0xbb);
                                r3 = CPU.lslT(r3, 1);
                                r3 += CPU.r8().value;
                                r4 = CPU.r11().value;
                                MEMORY.ref(2, r3).setu(r4);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          //LAB_808cd76
        }

        //LAB_808cd80
        FUN_80770d0(0x104);
        r3 = MEMORY.ref(4, CPU.r8().value + 0x14 + MEMORY.ref(4, 0x2000434).get() * 0x4).get();
        CPU.r10().value = r3;
        if(r3 != 0) {
          r3 = MEMORY.ref(1, 0x2000432).getUnsigned();
          if(r3 == 2) {
            FUN_80090b8(CPU.r10().value);
          } else {
            //LAB_808cdb0
            if(r3 == 1) {
              FUN_80090b0(CPU.r10().value);
            } else {
              //LAB_808cdbc
              if(MEMORY.ref(2, CPU.r8().value + 0x19e).get() == 3) {
                FUN_80090a8(CPU.r10().value);
              } else {
                //LAB_808cdd2
                FUN_80090a0(CPU.r10().value);
              }
            }
          }
        }

        //LAB_808cdd8
        //LAB_808cdda
        do {
          FUN_80030f8(1);
          CPU.r10().value = MEMORY.ref(4, CPU.r8().value + 0x14 + MEMORY.ref(4, 0x2000434).get() * 0x4).get();
          if(_3001f54.get() == 0 || FUN_80770c0(0x163) == 0) {
            //LAB_808cdfe
            FUN_808bec0(MEMORY.ref(1, CPU.r10().value + 0x22).getUnsigned(), MEMORY.ref(4, CPU.r10().value + 0x8).get(), MEMORY.ref(4, CPU.r10().value + 0xc).get(), MEMORY.ref(4, CPU.r10().value + 0x10).get());
          }

          //LAB_808ce12
          r0 = FUN_808bc9c();
          CPU.cmpT(r0, 0x0);
        } while(CPU.cpsr().getZero()); // ==
      } while(true);
    }

    //LAB_808ce1c
    if(MEMORY.ref(2, CPU.r8().value + 0x1c6).getUnsigned() != 0) {
      FUN_80901c0(MEMORY.ref(4, CPU.r8().value + 0x1c0).get(), MEMORY.ref(4, CPU.r8().value + 0x1c8).get());
      MEMORY.ref(2, CPU.r8().value + 0x1c6).setu(0);
      FUN_80030f8(MEMORY.ref(4, CPU.r8().value + 0x1c8).get());
    }

    //LAB_808ce46
    freeSlot(0x1b);
    CPU.sp().value += 0x10;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r7;
  }

  @Method(0x808ce74)
  public static int FUN_808ce74() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808cf78)
  public static void FUN_808cf78() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r3 = MEMORY.ref(4, 0x808d0b0).get();
    r0 = CPU.movT(0, 0xe1);
    r7 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, 0x808d0b4).get();
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r0);
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r2).get();
    r3 = MEMORY.ref(4, 0x808d0b8).get();
    r0 = MEMORY.ref(4, r3 + 0xc).get();
    CPU.r8().value = r1;
    r0 = (int)MEMORY.call(r0);
    r6 = CPU.movT(0, 0x1);
    r3 = CPU.movT(0, 0x0);
    r5 = r0;
    CPU.r10().value = r3;
    r6 = CPU.negT(r6, r6);

    // Subtract 0x18 so we don't have to jump over the initial increment
    r5 -= 0x18;
    // LAB_808cfa8;

    //LAB_808cfa6
    jmp_808cfc8:
    {
      do {
        do {
          r5 += 0x18;

          //LAB_808cfa8
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r5 + r4).get();
          r3 = CPU.cmpT(r3, r6);
          if(CPU.cpsr().getZero()) { // ==
            break jmp_808cfc8;
          }
          CPU.cmpT(r3, CPU.r8().value);
        } while(!CPU.cpsr().getZero()); // !=

        r1 = CPU.movT(0, 0x2);
        r0 = MEMORY.ref(2, r5 + r1).get();
        r0 = CPU.cmpT(r0, r6);
        if(CPU.cpsr().getZero()) { // ==
          break;
        }
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
      } while(CPU.cpsr().getZero()); // ==

      //LAB_808cfc4
      r2 = CPU.movT(0, 0x1);
      CPU.r10().value = r2;
    }

    //LAB_808cfc8
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = MEMORY.ref(4, 0x808d0b8).get();
      r0 = MEMORY.ref(4, r3 + 0xc).get();
      r0 = (int)MEMORY.call(r0);
      r5 = CPU.addT(r0, 0x0);
    }

    //LAB_808cfd8
    r0 = MEMORY.ref(4, 0x808d0bc).get();
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r1 = MEMORY.ref(4, 0x808d0b4).get();
      r4 = CPU.movT(0, 0xee);
      r4 = CPU.lslT(r4, 1);
      r2 = CPU.addT(r1, r4);
      r4 = CPU.movT(0, 0x4);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf0);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0x6);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf2);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0x8);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf4);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0xf6);
      r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
      r4 = CPU.lslT(r4, 1);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.addT(r1, r4);
      MEMORY.ref(2, r3).setu(r0);
    }

    //LAB_808d020
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.movT(0, 0xe);
    r3 = MEMORY.ref(2, r5 + r0).get();
    r1 = CPU.negT(r1, r1);
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = CPU.addT(r7, 0x0);
      r6 = CPU.addT(r6, 0xec);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r6).setu(r3);
    } else {
      //LAB_808d036
      r6 = CPU.addT(r7, 0x0);
      r6 = CPU.addT(r6, 0xec);
    }

    //LAB_808d03a
    r2 = CPU.movT(0, 0x10);
    r3 = MEMORY.ref(2, r5 + r2).get();
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = CPU.addT(r7, 0x0);
      r4 = CPU.addT(r4, 0xf0);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r4).setu(r3);
    } else {
      //LAB_808d04c
      r4 = CPU.addT(r7, 0x0);
      r4 = CPU.addT(r4, 0xf0);
    }

    //LAB_808d050
    r0 = CPU.movT(0, 0x12);
    r3 = MEMORY.ref(2, r5 + r0).get();
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.addT(r7, 0x0);
      r2 = CPU.addT(r2, 0xf4);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_808d062
      r2 = CPU.addT(r7, 0x0);
      r2 = CPU.addT(r2, 0xf4);
    }

    //LAB_808d066
    r3 = CPU.movT(0, 0x14);
    r0 = MEMORY.ref(2, r5 + r3).get();
    r0 = CPU.cmpT(r0, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.addT(r7, 0x0);
      r1 = CPU.addT(r1, 0xf8);
      r3 = CPU.lslT(r0, 16);
      MEMORY.ref(4, r1).setu(r3);
    } else {
      //LAB_808d078
      r1 = CPU.addT(r7, 0x0);
      r1 = CPU.addT(r1, 0xf8);
    }

    //LAB_808d07c
    r3 = MEMORY.ref(4, r6).get();
    r0 = CPU.movT(0, 0xf0);
    r0 = CPU.lslT(r0, 16);
    r2 = MEMORY.ref(4, r2).get();
    r3 = CPU.addT(r3, r0);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = MEMORY.ref(4, 0x808d0c0).get();
      r3 = CPU.addT(r2, r0);
      MEMORY.ref(4, r6).setu(r3);
    }

    //LAB_808d090
    r3 = MEMORY.ref(4, r4).get();
    r2 = CPU.movT(0, 0xa0);
    r2 = CPU.lslT(r2, 16);
    r3 = CPU.addT(r3, r2);
    r2 = MEMORY.ref(4, r1).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = MEMORY.ref(4, 0x808d0c4).get();
      r3 = CPU.addT(r2, r0);
      MEMORY.ref(4, r4).setu(r3);
    }

    //LAB_808d0a4
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x808d0c8)
  public static void FUN_808d0c8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d394)
  public static int FUN_808d394(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d428)
  public static int FUN_808d428(int r0) {
    int r3;

    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero()) { // ==
      return CPU.movT(0, 0x1);
    }

    //LAB_808d436
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 5);
    r3 = CPU.andT(r3, r0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      return FUN_80770c0(r0);
    }

    //LAB_808d446
    r0 = FUN_80770c0(r0);
    r3 = CPU.negT(r3, r0);
    r3 = CPU.orrT(r3, r0);
    r3 = CPU.lsrT(r3, 31);
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.subT(r0, r3);

    //LAB_808d454
    return r0;
  }

  @Method(0x808d5a4)
  public static int FUN_808d5a4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d5dc)
  public static int FUN_808d5dc(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d7d8)
  public static int FUN_808d7d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d828)
  public static int FUN_808d828(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d8f0)
  public static int FUN_808d8f0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d9a4)
  public static int FUN_808d9a4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808ddec)
  public static int FUN_808ddec(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e118)
  public static void FUN_808e118() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e23c)
  public static int FUN_808e23c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e680)
  public static int FUN_808e680(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e9a8)
  public static void FUN_808e9a8(final int r0) {
    final int ret = FUN_80091a8(0, MEMORY.ref(4, r0 + 0x8).get(), MEMORY.ref(4, r0 + 0x10).get());
    MEMORY.ref(4, r0 + 0xc).setu(ret);
    MEMORY.ref(4, r0 + 0x14).setu(ret);
  }

  @Method(0x808e9c0)
  public static void FUN_808e9c0() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r3 = MEMORY.ref(4, 0x808ebf4).get();
    CPU.sp().value -= 0xc;
    r1 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x4c).get();
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r2 = MEMORY.ref(4, r2 + 0x10).get();
    CPU.r10().value = r2;
    r2 = CPU.movT(0, 0x8e);
    r2 = CPU.lslT(r2, 1);
    r2 = CPU.addT(r2, r3);
    CPU.r8().value = r2;
    r0 = CPU.sp().value + 0x8;
    MEMORY.ref(4, r0).setu(r1);
    r3 = MEMORY.ref(4, 0x808ebf8).get();
    r1 = CPU.r8().value;
    r2 = MEMORY.ref(4, 0x808ebfc).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;

    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_808e9fc
      r4 = CPU.movT(0, 0x1);
      CPU.r10().value += r4;
      r7 = MEMORY.ref(1, r3).getUnsigned();
      r1 = CPU.r10().value;
      r5 = MEMORY.ref(1, r1).getUnsigned();
      CPU.r10().value += r4;
      if(r7 != 0xff || r5 != 0xff) {
        //LAB_808ea12
        jmp_808ebe2:
        do {
          r2 = CPU.r10().value;
          r2 = MEMORY.ref(1, r2).getUnsigned();
          r3 = CPU.movT(0, 0x1);
          CPU.r10().value += r3;
          r3 = CPU.addT(r2, 0x0);
          r3 = CPU.subT(r3, 0x64);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          CPU.cmpT(r3, 0x8b);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_808ea26
            r3 = MEMORY.ref(4, 0x808ec00).get();
            r0 = MEMORY.ref(4, r3 + 0x24).get();
            r0 = (int)MEMORY.call(r0);
            r6 = CPU.addT(r0, 0x0);
            r4 = CPU.movT(0, 0x1);
            r2 = MEMORY.ref(4, r6).get();
            r4 = CPU.negT(r4, r4);
            r2 = CPU.cmpT(r2, r4);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_808ea3c
              r1 = CPU.movT(0, 0x80);
              r7 = CPU.lslT(r7, 20);
              r1 = CPU.lslT(r1, 12);
              CPU.r11().value = r7;
              CPU.r9().value = r1;
              r7 = CPU.lslT(r5, 20);

              //LAB_808ea48
              do {
                r4 = CPU.movT(0, 0x4);
                r3 = MEMORY.ref(2, r6 + r4).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r3 = CPU.cmpT(r3, r1);
                jmp_808ebb8:
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_808ea54
                  r3 = MEMORY.ref(4, 0x808ec04).get();
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, 0x13);
                  if(!CPU.cpsr().getZero()) { // !=
                    //LAB_808eb02
                    CPU.cmpT(r3, 0x3);
                    if(CPU.cpsr().getZero()) { // ==
                      r3 = MEMORY.ref(4, 0x808ec08).get();
                      r2 = MEMORY.ref(4, r6 + 0x8).get();
                      r2 = CPU.andT(r2, r3);
                      r3 = CPU.movT(0, 0xc0);
                      r3 = CPU.lslT(r3, 14);
                      r2 = CPU.cmpT(r2, r3);
                      if(CPU.cpsr().getZero()) { // ==
                        r4 = CPU.movT(0, 0x6);
                        r0 = MEMORY.ref(2, r6 + r4).get();
                        r0 = FUN_80770c0(r0);
                        CPU.cmpT(r0, 0x0);
                        if(CPU.cpsr().getZero()) { // ==
                          r4 = CPU.r9().value;
                          r1 = CPU.r11().value;
                          r0 = CPU.movT(0, 0x1c);
                          r1 += CPU.r9().value;
                          r2 = CPU.movT(0, 0x0);
                          r3 = CPU.addT(r7, r4);
                          r0 = FUN_80090c8(r0, r1, r2, r3);
                          r5 = CPU.addT(r0, 0x0);
                          CPU.cmpT(r5, 0x0);
                          if(!CPU.cpsr().getZero()) { // !=
                            FUN_808e9a8(r0);
                            r1 = CPU.movT(0, 0x0);
                            r0 = CPU.addT(r5, 0x0);
                            FUN_80091e0(r0, r1);
                            r0 = CPU.addT(r5, 0x0);
                            FUN_8009140(r0);
                            r0 = CPU.addT(r5, 0x0);
                            r1 = CPU.movT(0, 0x1);
                            FUN_8009080(r0, r1);
                            r2 = MEMORY.ref(4, r5 + 0x8).get();
                            CPU.cmpT(r2, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r1 = MEMORY.ref(4, 0x808ec0c).get();
                              r2 = CPU.addT(r2, r1);
                            }

                            //LAB_808eb5a
                            r3 = CPU.addT(r5, 0x0);
                            r3 = CPU.addT(r3, 0x64);
                            r2 = CPU.asrT(r2, 16);
                            MEMORY.ref(2, r3).setu(r2);
                            r3 = MEMORY.ref(4, r5 + 0x10).get();
                            CPU.cmpT(r3, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r2 = MEMORY.ref(4, 0x808ec0c).get();
                              r3 = CPU.addT(r3, r2);
                            }

                            //LAB_808eb6c
                            r2 = CPU.addT(r5, 0x0);
                            r3 = CPU.asrT(r3, 16);
                            r2 = CPU.addT(r2, 0x66);
                            MEMORY.ref(2, r2).setu(r3);
                            r3 = CPU.movT(0, 0x1);
                            r2 = CPU.subT(r2, 0xd);
                            MEMORY.ref(1, r2).setu(r3);
                            r2 = CPU.subT(r2, 0x36);
                            MEMORY.ref(1, r2).setu(r3);
                            r3 = CPU.r8().value;
                            MEMORY.ref(4, r3).setu(r5);
                            r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
                            r4 = CPU.r8().value;
                            MEMORY.ref(1, r4 + 0x4).setu(r3);
                            r3 = MEMORY.ref(4, r5 + 0x8).get();
                            CPU.cmpT(r3, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r1 = MEMORY.ref(4, 0x808ec10).get();
                              r3 = CPU.addT(r3, r1);
                            }

                            //LAB_808eb92
                            r0 = MEMORY.ref(4, r5 + 0x10).get();
                            r3 = CPU.asrT(r3, 20);
                            r2 = CPU.r8().value;
                            MEMORY.ref(1, r2 + 0x6).setu(r3);
                            CPU.cmpT(r0, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r3 = MEMORY.ref(4, 0x808ec10).get();
                              r0 = CPU.addT(r0, r3);
                            }

                            //LAB_808eba2
                            r4 = CPU.r8().value;
                            r3 = CPU.asrT(r0, 20);
                            MEMORY.ref(1, r4 + 0x7).setu(r3);
                            r2 = MEMORY.ref(4, CPU.sp().value).get();
                            r1 = CPU.movT(0, 0x8);
                            r2 = CPU.addT(r2, 0x1);
                            CPU.r8().value += r1;
                            MEMORY.ref(4, CPU.sp().value).setu(r2);
                            CPU.cmpT(r2, 0x9);
                            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                              break;
                            }
                            break jmp_808ebe2;
                          }
                        }
                      }
                    }
                  } else {
                    r4 = CPU.r9().value;
                    r1 = CPU.r11().value;
                    r0 = CPU.movT(0, 0x14);
                    r1 += CPU.r9().value;
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.addT(r7, r4);
                    r0 = FUN_80090c8(r0, r1, r2, r3);
                    r5 = CPU.addT(r0, 0x0);
                    CPU.cmpT(r5, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      //LAB_808ea74
                      FUN_808e9a8(r0);
                      r0 = CPU.addT(r5, 0x0);
                      r1 = CPU.movT(0, 0x0);
                      FUN_80091e0(r0, r1);
                      r1 = CPU.movT(0, 0x6);
                      r0 = MEMORY.ref(2, r6 + r1).get();
                      r0 = FUN_80770c0(r0);
                      if(r0 != 0) {
                        if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) == 0x500000) {
                          r0 = FUN_80090d0(r5, r1, r2);
                          break jmp_808ebb8;
                        }

                        //LAB_808eaa2
                        r0 = CPU.addT(r5, 0x0);
                        r1 = CPU.movT(0, 0x2);
                        FUN_8009080(r0, r1);
                      }

                      //LAB_808eaaa
                      r0 = CPU.addT(r5, 0x0);
                      FUN_8009140(r0);
                      r2 = MEMORY.ref(4, r5 + 0x8).get();
                      CPU.cmpT(r2, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r4 = MEMORY.ref(4, 0x808ec0c).get();
                        r2 = CPU.addT(r2, r4);
                      }

                      //LAB_808eaba
                      r3 = CPU.addT(r5, 0x0);
                      r3 = CPU.addT(r3, 0x64);
                      r2 = CPU.asrT(r2, 16);
                      MEMORY.ref(2, r3).setu(r2);
                      r3 = MEMORY.ref(4, r5 + 0x10).get();
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r1 = MEMORY.ref(4, 0x808ec0c).get();
                        r3 = CPU.addT(r3, r1);
                      }

                      //LAB_808eacc
                      r2 = CPU.addT(r5, 0x0);
                      r3 = CPU.asrT(r3, 16);
                      r2 = CPU.addT(r2, 0x66);
                      MEMORY.ref(2, r2).setu(r3);
                      r3 = CPU.movT(0, 0x1);
                      r2 = CPU.subT(r2, 0x43);
                      MEMORY.ref(1, r2).setu(r3);
                      r2 = CPU.addT(r2, 0x36);
                      MEMORY.ref(1, r2).setu(r3);
                      r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
                      r2 = CPU.r8().value;
                      MEMORY.ref(1, r2 + 0x4).setu(r3);
                      r3 = MEMORY.ref(4, r5 + 0x8).get();
                      MEMORY.ref(4, r2).setu(r5);
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r4 = MEMORY.ref(4, 0x808ec10).get();
                        r3 = CPU.addT(r3, r4);
                      }

                      //LAB_808eaf0
                      r0 = MEMORY.ref(4, r5 + 0x10).get();
                      r3 = CPU.asrT(r3, 20);
                      r1 = CPU.r8().value;
                      MEMORY.ref(1, r1 + 0x6).setu(r3);
                      CPU.cmpT(r0, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r2 = MEMORY.ref(4, 0x808ec10).get();
                        r0 = CPU.addT(r0, r2);
                      }
                      r4 = CPU.r8().value;
                      r3 = CPU.asrT(r0, 20);
                      MEMORY.ref(1, r4 + 0x7).setu(r3);
                      r2 = MEMORY.ref(4, CPU.sp().value).get();
                      r1 = CPU.movT(0, 0x8);
                      r2 = CPU.addT(r2, 0x1);
                      CPU.r8().value += r1;
                      MEMORY.ref(4, CPU.sp().value).setu(r2);
                      CPU.cmpT(r2, 0x9);
                      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                        break;
                      }
                      break jmp_808ebe2;
                    }
                  }
                }

                //LAB_808ebb8
                r6 = CPU.addT(r6, 0xc);
                r3 = MEMORY.ref(4, r6).get();
                r4 = CPU.movT(0, 0x1);
                r4 = CPU.negT(r4, r4);
                r2 = CPU.addT(r3, 0x0);
                r3 = CPU.cmpT(r3, r4);
                if(CPU.cpsr().getZero()) { // ==
                  break;
                }
              } while(true);
            }
          }

          //LAB_808ebc8
          r1 = CPU.r10().value;
          r2 = CPU.movT(0, 0x1);
          CPU.r10().value += r2;
          r7 = MEMORY.ref(1, r1).getUnsigned();
          r3 = CPU.r10().value;
          r5 = MEMORY.ref(1, r3).getUnsigned();
          CPU.r10().value += r2;
          CPU.cmpT(r7, 0xff);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_808ebdc
            CPU.cmpT(r5, 0xff);
            if(CPU.cpsr().getZero()) { // ==
              break;
            }
          }
        } while(true);
      }
    }

    //LAB_808ebe2
    CPU.sp().value += 0xc;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x808f498)
  public static void FUN_808f498() {
    int r0 = boardWramMallocHead_3001e50.offset(31 * 0x4).get();
    final int r2 = MEMORY.ref(1, r0 + 0x539).getUnsigned();
    DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);
    GPU.DISPCNT.oru(0x6000);
    r0 = r0 + r2 * 0x284;
    GPU.WININ.setu(MEMORY.ref(2, r0).getUnsigned());
    GPU.WINOUT.setu(MEMORY.ref(2, r0 + 0x2).getUnsigned());
    GPU.WIN0H.setu(MEMORY.ref(2, r0 + 0x4).getUnsigned());
    GPU.WIN1H.setu(MEMORY.ref(2, r0 + 0x6).getUnsigned());
    GPU.WIN0V.setu(0xa0);
    GPU.WIN1V.setu(0xa0);
    DMA.channels[0].SAD.setu(r0 + 0x8);
    DMA.channels[0].DAD.setu(GPU.WIN0H.getAddress());
    DMA.channels[0].CNT.setu(0xa6600001);
  }

  @Method(0x808f52c)
  public static void FUN_808f52c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x808f7a0).get();
    r6 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x5c).get();
    CPU.sp().value -= 0x18;
    r0 = MEMORY.ref(4, 0x808f7a4).get();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r4 = CPU.addT(r3, r0);
    r2 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(1, r4 + r2).get();
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r5 = MEMORY.ref(4, 0x808f7a8).get();
      r1 = CPU.addT(r3, r5);
      r3 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(1, r1 + r3).get();
      r0 = MEMORY.ref(1, r1).getUnsigned();
      r3 = CPU.cmpT(r3, r2);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(1, r4).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = MEMORY.ref(4, 0x808f7ac).get();
        r3 = CPU.addT(r7, r0);
        r2 = CPU.movT(0, 0x0);
        r2 = MEMORY.ref(1, r3 + r2).get();
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r1 = MEMORY.ref(4, 0x808f7b0).get();
          r3 = CPU.addT(r7, r1);
          r3 = MEMORY.ref(1, r3).getUnsigned();
          r3 = CPU.lslT(r3, 24);
          r3 = CPU.asrT(r3, 24);
          CPU.cmpT(r3, 0x40);
          if(CPU.cpsr().getZero()) { // ==
            r1 = CPU.movT(0, 0x80);
            r1 = CPU.lslT(r1, 19);
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = MEMORY.ref(4, 0x808f7b4).get();
          } else {
            //LAB_808f588
            r1 = CPU.movT(0, 0x80);
            r1 = CPU.lslT(r1, 19);
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = MEMORY.ref(4, 0x808f7b8).get();
          }

          //LAB_808f590
          r3 = CPU.andT(r3, r2);
          MEMORY.ref(2, r1).setu(r3);
          r0 = MEMORY.ref(4, 0x808f7bc).get();
          r0 = FUN_8004278(r0);
          r0 = MEMORY.ref(4, 0x808f7c0).get();
          r0 = FUN_8004278(r0);
          r2 = MEMORY.ref(4, 0x808f7c4).get();
          r3 = MEMORY.ref(4, 0x808f7c8).get();
          r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
          r3 = CPU.andT(r3, r1);
          MEMORY.ref(2, r2 + 0xa).setu(r3);
          r3 = MEMORY.ref(4, 0x808f7cc).get();
          r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
          r3 = CPU.andT(r3, r1);
          MEMORY.ref(2, r2 + 0xa).setu(r3);

          CPU.sp().value += 0x18;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          CPU.pop();
          CPU.pop();
          CPU.pop();
          CPU.pop();
          return;
        }

        //LAB_808f5b8
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = CPU.movT(0, 0xa5);
        r7 = CPU.lslT(r7, 3);
        r3 = CPU.addT(r5, r7);
        MEMORY.ref(2, r3).setu(r2);
      } else {
        //LAB_808f5c4
        r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = MEMORY.ref(4, 0x808f7b0).get();
        r3 = CPU.addT(r2, r5);
        r2 = CPU.movT(0, 0x0);
        r2 = MEMORY.ref(1, r3 + r2).get();
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r3 = MEMORY.ref(4, 0x808f7d0).get();
        r5 = CPU.addT(r7, r3);
        r3 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(1, r5 + r3).get();
        r2 = CPU.subT(r2, r3);
        r3 = CPU.addT(r0, 0x1);
        MEMORY.ref(1, r1).setu(r3);
        r3 = CPU.lslT(r3, 24);
        r3 = CPU.asrT(r3, 24);
        r0 = CPU.addT(r3, 0x0);
        r0 = CPU.mulT(r0, r2);
        r1 = CPU.movT(0, 0x0);
        r1 = MEMORY.ref(1, r4 + r1).get();
        r3 = MEMORY.ref(4, 0x808f7d4).get();
        r0 = (int)MEMORY.call(r3, r0, r1);
        r3 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(1, r5 + r3).get();
        r5 = MEMORY.ref(4, 0x808f7d8).get();
        r3 = CPU.addT(r3, r0);
        r2 = CPU.addT(r7, r5);
        MEMORY.ref(2, r2).setu(r3);
      }
    }

    //LAB_808f5fc
    r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r0 = MEMORY.ref(4, 0x808f7dc).get();
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.eorT(r2, r3);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 5);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 2);
    r4 = CPU.addT(r7, r3);
    r0 = CPU.addT(r4, 0x4);
    MEMORY.ref(4, CPU.sp().value).setu(r4);
    FUN_8015268(r0);
    r1 = CPU.movT(0, 0xa5);
    r1 = CPU.lslT(r1, 3);
    r3 = CPU.addT(r7, r1);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    CPU.cmpT(r3, 0x4d);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r0 = MEMORY.ref(4, 0x808fe34).get();
      r3 = CPU.addT(r7, r0);
      r2 = MEMORY.ref(1, r3).getUnsigned();
      r1 = CPU.movT(0, 0x1);
      r2 = CPU.eorT(r2, r1);
      MEMORY.ref(1, r3).setu(r2);

      CPU.sp().value += 0x18;
      CPU.r8().value = CPU.pop();
      CPU.r9().value = CPU.pop();
      CPU.r10().value = CPU.pop();
      CPU.r11().value = CPU.pop();
      CPU.pop();
      CPU.pop();
      CPU.pop();
      CPU.pop();
      return;
    }

    //LAB_808f62e
    switch(r3) {
      case 0:
        throw new RuntimeException("0808f770");
      case 1:
        throw new RuntimeException("0808f818");
      case 2:
        throw new RuntimeException("0808f8e4");
      case 3:
        throw new RuntimeException("0808f958");
      case 4:
        throw new RuntimeException("0808f9ea");
      case 5:
      case 6:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
        throw new RuntimeException("0808fe10");
      case 7:
        throw new RuntimeException("0808fa52");
      case 8:
        throw new RuntimeException("0808fb3c");
      case 9:
        r2 = CPU.addT(r6, 0x0);
        r2 = CPU.addT(r2, 0xe4);
        r3 = MEMORY.ref(4, 0x808fd84).get();
        r5 = MEMORY.ref(4, r2).get();
        r6 = MEMORY.ref(4, r2 + 0x4).get();
        r5 = CPU.andT(r5, r3);
        r6 = CPU.andT(r6, r3);
        r7 = CPU.movT(0, 0xfa);
        r3 = MEMORY.ref(4, 0x808fd88).get();
        r7 = CPU.lslT(r7, 1);
        r3 = CPU.addT(r3, r7);
        r0 = MEMORY.ref(4, r3).get();
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_808ba1c(r0);
        r3 = MEMORY.ref(4, r0 + 0x8).get();
        r3 = CPU.subT(r3, r5);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = MEMORY.ref(4, 0x808fd8c).get();
          r3 = CPU.addT(r3, r1);
        }

        //LAB_808fc5e
        r2 = MEMORY.ref(4, r0 + 0xc).get();
        r7 = CPU.asrT(r3, 16);
        r3 = MEMORY.ref(4, r0 + 0x10).get();
        r3 = CPU.subT(r3, r2);
        r0 = CPU.subT(r3, r6);
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x808fd8c).get();
          r0 = CPU.addT(r0, r2);
        }

        //LAB_808fc70
        r3 = CPU.asrT(r0, 16);
        r3 = CPU.subT(r3, 0x10);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        CPU.r10().value = r3;
        r0 = MEMORY.ref(4, 0x808fd98).get();
        r3 = MEMORY.ref(4, 0x808fd94).get();
        r3 = MEMORY.ref(4, r3).get();
        r3 = CPU.addT(r5, r0);
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = MEMORY.ref(4, 0x808fd90).get();
        MEMORY.ref(2, r4).setu(r3);
        r3 = CPU.addT(r5, r1);
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = CPU.addT(r4, 0x2);
        r2 = MEMORY.ref(4, 0x808fd9c).get();
        MEMORY.ref(2, r4).setu(r3);
        r3 = CPU.addT(r5, r2);
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r2 = CPU.movT(0, 0x20);
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.andT(r3, r2);
        r4 = CPU.addT(r4, 0x2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.movT(0, 0x1f);
          r3 = CPU.andT(r3, r5);
          r5 = CPU.subT(r2, r3);
        } else {
          //LAB_808fca8
          r3 = CPU.movT(0, 0x1f);
          r5 = CPU.andT(r5, r3);
        }

        //LAB_808fcac
        r3 = CPU.lslT(r5, 2);
        r5 = CPU.addT(r3, r5);
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.mulT(r3, r5);
        r5 = MEMORY.ref(4, 0x808fda0).get();
        r3 = CPU.lslT(r3, 16);
        CPU.r11().value = r3;
        r3 = CPU.movT(0, 0x0);
        CPU.r8().value = r3;
        CPU.r9().value = r5;

        //LAB_808fcc0
        do {
          r0 = CPU.r8().value;
          r1 = CPU.r10().value;
          r5 = CPU.subT(r0, r1);
          r3 = CPU.addT(r5, 0x0);
          r3 = CPU.mulT(r3, r5);
          r0 = CPU.lslT(r3, 1);
          r0 = CPU.addT(r0, r3);
          r2 = CPU.r11().value;
          r0 = CPU.lslT(r0, 15);
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = CPU.subT(r2, r0);
          r0 = (int)MEMORY.call(CPU.r9().value, r0);
          r0 = CPU.asrT(r0, 8);
          r6 = CPU.subT(r7, r0);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          r0 = CPU.addT(r7, r0);
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r6 = CPU.movT(0, 0x0);
          }

          //LAB_808fce8
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r0 = CPU.movT(0, 0x0);
          }

          //LAB_808fcee
          CPU.cmpT(r6, 0xf0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r6 = CPU.movT(0, 0xf0);
          }

          //LAB_808fcf4
          CPU.cmpT(r0, 0xf0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r0 = CPU.movT(0, 0xf0);
          }

          //LAB_808fcfa
          r3 = CPU.lslT(r6, 8);
          r3 = CPU.addT(r3, r0);
          MEMORY.ref(2, r4).setu(r3);
          r3 = CPU.movT(0, 0x1);
          CPU.r8().value += r3;
          r5 = CPU.r8().value;
          r4 = CPU.addT(r4, 0x4);
          CPU.cmpT(r5, 0x9f);
        } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = MEMORY.ref(4, 0x808fe34).get();
        r3 = CPU.addT(r7, r0);
        r2 = MEMORY.ref(1, r3).getUnsigned();
        r1 = CPU.movT(0, 0x1);
        r2 = CPU.eorT(r2, r1);
        MEMORY.ref(1, r3).setu(r2);

        CPU.sp().value += 0x18;
        CPU.r8().value = CPU.pop();
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        CPU.pop();
        CPU.pop();
        CPU.pop();
        CPU.pop();
        break;

      case 77:
        throw new RuntimeException("0808fd0e");
    }
  }

  @Method(0x808fecc)
  public static int FUN_808fecc() {
    final int r4 = mallocSlotBoard(0x1f, 0x540);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000150);
    CPU.sp().value += 0x4;

    return r4;
  }

  @Method(0x808fefc)
  public static void FUN_808fefc(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = CPU.movT(0, 0xff);
    CPU.r10().value = r1;
    r2 = CPU.asrT(r0, 8);
    r1 = MEMORY.ref(4, 0x80900fc).get();
    r6 = CPU.addT(r3, 0x0);
    r2 = CPU.andT(r2, r3);
    r7 = MEMORY.ref(4, r1).get();
    r6 = CPU.andT(r6, r0);

    //LAB_808ff1c
    switch(r2) {
      case 0:
        r0 = CPU.movT(0, 0x0);
        FUN_8003b70(r0);
        r0 = CPU.r10().value;
        FUN_8003bb4(r0);
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r1 = MEMORY.ref(4, 0x80901b8).get();
        r4 = MEMORY.ref(4, 0x80901bc).get();
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r5 = CPU.addT(r3, 0x0);
        MEMORY.ref(2, r4).setu(r4);
        r3 = MEMORY.ref(2, r1).getUnsigned();
        CPU.cmpT(r3, 0x1f);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r2 = CPU.lslT(r3, 1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(2, r1).setu(r3);
          r0 = CPU.movT(0, 0x80);
          r0 = CPU.lslT(r0, 19);
          r2 = CPU.lslT(r2, 2);
          r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
          r2 = CPU.addT(r2, r1);
          r1 = MEMORY.ref(2, r0).getUnsigned();
          r2 = CPU.addT(r2, 0x4);
          r3 = CPU.orrT(r3, r1);
          MEMORY.ref(4, r2).setu(r3);
          r2 += 0x4;
          r3 = CPU.movT(0, 0x80);
          MEMORY.ref(4, r2).setu(r0);
          r2 += 0x4;
          r3 = CPU.lslT(r3, 10);
          MEMORY.ref(4, r2).setu(r3);
        }

        //LAB_809019a
        MEMORY.ref(2, r4).setu(r5);
        break;

      case 1:
        r3 = CPU.movT(0, 0xa0);
        r3 = CPU.lslT(r3, 19);
        r0 = CPU.movT(0, 0x80);
        r1 = MEMORY.ref(2, r3).getUnsigned();
        r0 = CPU.lslT(r0, 8);
        FUN_8091220(r0, r1);
        r0 = CPU.r10().value;
        FUN_8091254(r0);
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r1 = MEMORY.ref(4, 0x8090104).get();
        r4 = MEMORY.ref(4, 0x8090108).get();
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r5 = CPU.addT(r3, 0x0);
        MEMORY.ref(2, r4).setu(r4);
        r3 = MEMORY.ref(2, r1).getUnsigned();
        CPU.cmpT(r3, 0x1f);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r2 = CPU.lslT(r3, 1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(2, r1).setu(r3);
          r0 = CPU.movT(0, 0x80);
          r0 = CPU.lslT(r0, 19);
          r2 = CPU.lslT(r2, 2);
          r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
          r2 = CPU.addT(r2, r1);
          r1 = MEMORY.ref(2, r0).getUnsigned();
          r2 = CPU.addT(r2, 0x4);
          r3 = CPU.orrT(r3, r1);
          MEMORY.ref(4, r2).setu(r3);
          r2 += 0x4;
          r3 = CPU.movT(0, 0x80);
          MEMORY.ref(4, r2).setu(r0);
          r2 += 0x4;
          r3 = CPU.lslT(r3, 10);
          MEMORY.ref(4, r2).setu(r3);
        }

        //LAB_808ff98
        MEMORY.ref(2, r4).setu(r5);
        r0 = CPU.movT(0, 0x0);
        FUN_8091240(r0);
        break;

      case 2:
        r5 = FUN_808fecc();
        CPU.r8().value = 0;
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(CPU.r8().value);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        FUN_80041d8(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        FUN_80041d8(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        FUN_80030f8(0x1);

        r6 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        r3 = MEMORY.ref(2, 0x2002090).getUnsigned();
        if(r3 < 0x20) {
          r2 = CPU.lslT(r3, 1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(2, 0x2002090).setu(r3);
          r2 = CPU.lslT(r2, 2);
          r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
          r2 = 0x2002090 + r2;
          r1 = GPU.DISPCNT.getUnsigned();
          r2 = CPU.addT(r2, 0x4);
          r3 = CPU.orrT(r3, r1);
          MEMORY.ref(4, r2).setu(r3);
          r2 += 0x4;
          MEMORY.ref(4, r2).setu(GPU.DISPCNT.getAddress());
          r2 += 0x4;
          MEMORY.ref(4, r2).setu(0x20000);
        }

        //LAB_8090018
        INTERRUPTS.INT_MASTER_ENABLE.setu(r6);
        MEMORY.ref(1, r5 + 0x53a).setu(CPU.r8().value);
        MEMORY.ref(1, r5 + 0x53b).setu(0x20);
        MEMORY.ref(1, r5 + 0x53c).setu(CPU.r10().value);
        MEMORY.ref(1, r5 + 0x53d).setu(CPU.r8().value);
        break;

      case 3:
        r0 = FUN_808fecc();
        r1 = CPU.movT(0, 0xa5);
        r5 = CPU.addT(r0, 0x0);
        r1 = CPU.lslT(r1, 3);
        r3 = CPU.addT(r5, r1);
        r2 = MEMORY.ref(4, 0x8090124).get();
        r1 = CPU.movT(0, 0x20);
        CPU.r8().value = r1;
        MEMORY.ref(2, r3).setu(r6);
        r3 = CPU.addT(r5, r2);
        r2 = CPU.r8().value;
        MEMORY.ref(2, r3).setu(r2);
        r0 = CPU.movT(0, 0xf);
        FUN_80907b0(r0);
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r1 = CPU.movT(0, 0xc8);
        r1 = CPU.lslT(r1, 4);
        FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_8090658"), r1);
        r1 = MEMORY.ref(4, 0x8090104).get();
        r4 = MEMORY.ref(4, 0x8090108).get();
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r6 = CPU.addT(r3, 0x0);
        MEMORY.ref(2, r4).setu(r4);
        r3 = MEMORY.ref(2, r1).getUnsigned();
        CPU.cmpT(r3, 0x1f);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r2 = CPU.lslT(r3, 1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(2, r1).setu(r3);
          r0 = CPU.movT(0, 0x80);
          r0 = CPU.lslT(r0, 19);
          r2 = CPU.lslT(r2, 2);
          r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
          r2 = CPU.addT(r2, r1);
          r1 = MEMORY.ref(2, r0).getUnsigned();
          r2 = CPU.addT(r2, 0x4);
          r3 = CPU.orrT(r3, r1);
          MEMORY.ref(4, r2).setu(r3);
          r2 += 0x4;
          r3 = CPU.movT(0, 0x80);
          MEMORY.ref(4, r2).setu(r0);
          r2 += 0x4;
          r3 = CPU.lslT(r3, 10);
          MEMORY.ref(4, r2).setu(r3);
        }

        //LAB_809009e
        MEMORY.ref(2, r4).setu(r6);
        r1 = MEMORY.ref(4, 0x8090118).get();
        r2 = CPU.movT(0, 0x0);
        r3 = CPU.addT(r5, r1);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(1, r3).setu(r2);
        r3 = CPU.addT(r5, r1);
        r1 = CPU.r8().value;
        MEMORY.ref(1, r3).setu(r1);
        r1 = MEMORY.ref(4, 0x8090120).get();
        r3 = CPU.addT(r5, r1);
        r1 = CPU.r10().value;
        MEMORY.ref(1, r3).setu(r1);
        r1 = MEMORY.ref(4, 0x809012c).get();
        r3 = CPU.addT(r5, r1);
        MEMORY.ref(1, r3).setu(r2);
        break;

      case 4:
        r7 = MEMORY.ref(4, r1).get();
        r0 = FUN_808fecc();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 1);
        r1 = MEMORY.ref(4, 0x80900f4).get();
        r2 = CPU.addT(r7, r3);
        r3 = MEMORY.ref(4, 0x80900f8).get();
        CPU.r8().value = r1;
        r1 = CPU.movT(0, 0x81);
        CPU.r9().value = r3;
        r1 = CPU.lslT(r1, 1);
        r3 = CPU.movT(0, 0x50);
        MEMORY.ref(2, r2).setu(r3);
        r2 = CPU.addT(r7, r1);
        r5 = CPU.addT(r0, 0x0);
        MEMORY.ref(2, r2).setu(r3);
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r1 = CPU.movT(0, 0xc8);
          r1 = CPU.lslT(r1, 4);
          r0 = 0x80903bc;
        } else {
          //LAB_8090134
          r1 = CPU.movT(0, 0xc8);
          r1 = CPU.lslT(r1, 4);
          r0 = 0x8090488;
        }

        //LAB_809013a
        FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_%x".formatted(r0)), r1);
        r1 = CPU.movT(0, 0x0);
        r0 = CPU.movT(0, 0x1);
        setInterruptHandler(r0, r1, getRunnable(GoldenSun_809.class, "FUN_8090584"));
        r2 = MEMORY.ref(4, 0x80901b4).get();
        r1 = CPU.r9().value;
        r3 = CPU.addT(r5, r2);
        r2 = CPU.addT(r2, 0x1);
        MEMORY.ref(1, r3).setu(r1);
        r3 = CPU.addT(r5, r2);
        r1 = CPU.r8().value;
        r2 = CPU.addT(r2, 0x1);
        MEMORY.ref(1, r3).setu(r1);
        r3 = CPU.addT(r5, r2);
        r1 = CPU.r10().value;
        r2 = CPU.addT(r2, 0x1);
        MEMORY.ref(1, r3).setu(r1);
        r3 = CPU.addT(r5, r2);
        r1 = CPU.r8().value;
        MEMORY.ref(1, r3).setu(r1);

        // fall through

      default:
        //LAB_8090168
        r1 = MEMORY.ref(4, 0x80901b8).get();
        r4 = MEMORY.ref(4, 0x80901bc).get();
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r5 = CPU.addT(r3, 0x0);
        MEMORY.ref(2, r4).setu(r4);
        r3 = MEMORY.ref(2, r1).getUnsigned();
        CPU.cmpT(r3, 0x1f);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r2 = CPU.lslT(r3, 1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(2, r1).setu(r3);
          r0 = CPU.movT(0, 0x80);
          r0 = CPU.lslT(r0, 19);
          r2 = CPU.lslT(r2, 2);
          r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
          r2 = CPU.addT(r2, r1);
          r1 = MEMORY.ref(2, r0).getUnsigned();
          r2 = CPU.addT(r2, 0x4);
          r3 = CPU.orrT(r3, r1);
          MEMORY.ref(4, r2).setu(r3);
          r2 += 0x4;
          r3 = CPU.movT(0, 0x80);
          MEMORY.ref(4, r2).setu(r0);
          r2 += 0x4;
          r3 = CPU.lslT(r3, 10);
          MEMORY.ref(4, r2).setu(r3);
        }

        //LAB_809019a
        MEMORY.ref(2, r4).setu(r5);
        break;
    }

    //LAB_809019c
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }
}
