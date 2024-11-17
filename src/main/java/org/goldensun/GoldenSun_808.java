package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct0c;
import org.goldensun.types.GraphicsStruct24;
import org.goldensun.types.Map194;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Actor70;

import static org.goldensun.GoldenSun.FUN_8009230;
import static org.goldensun.GoldenSun.FUN_8009268;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.decompressPointerTableEntry;
import static org.goldensun.GoldenSun.rotVec3;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.fadeInBrightness;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.initVramSlots;
import static org.goldensun.GoldenSun.clearTickCallbacks;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.FUN_8004760;
import static org.goldensun.GoldenSun.FUN_8009048;
import static org.goldensun.GoldenSun.FUN_8009078;
import static org.goldensun.GoldenSun.FUN_8009080;
import static org.goldensun.GoldenSun.FUN_80090a0;
import static org.goldensun.GoldenSun.FUN_80090a8;
import static org.goldensun.GoldenSun.FUN_80090b0;
import static org.goldensun.GoldenSun.FUN_80090b8;
import static org.goldensun.GoldenSun.loadActor_;
import static org.goldensun.GoldenSun.FUN_80090d0;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_80090f0;
import static org.goldensun.GoldenSun.loadMap_;
import static org.goldensun.GoldenSun.FUN_8009118;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009130;
import static org.goldensun.GoldenSun.FUN_8009138;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_80091a8;
import static org.goldensun.GoldenSun.FUN_80091e0;
import static org.goldensun.GoldenSun.addLayerToSpriteIfRegularSprite_;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.initMemoryAllocator;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSunVars._2000400;
import static org.goldensun.GoldenSunVars._2000402;
import static org.goldensun.GoldenSunVars._2000404;
import static org.goldensun.GoldenSunVars._2000406;
import static org.goldensun.GoldenSunVars._2000408;
import static org.goldensun.GoldenSunVars._200040a;
import static org.goldensun.GoldenSunVars._200040c;
import static org.goldensun.GoldenSunVars._200040e;
import static org.goldensun.GoldenSunVars._2000410;
import static org.goldensun.GoldenSunVars._2000412;
import static org.goldensun.GoldenSunVars._2000414;
import static org.goldensun.GoldenSunVars._2000416;
import static org.goldensun.GoldenSunVars._200041a;
import static org.goldensun.GoldenSunVars._200041c;
import static org.goldensun.GoldenSunVars._2000420;
import static org.goldensun.GoldenSunVars._2000424;
import static org.goldensun.GoldenSunVars._2000428;
import static org.goldensun.GoldenSunVars._200042c;
import static org.goldensun.GoldenSunVars._2000430;
import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars._2000434;
import static org.goldensun.GoldenSunVars._2000445;
import static org.goldensun.GoldenSunVars._2000446;
import static org.goldensun.GoldenSunVars._200045e;
import static org.goldensun.GoldenSunVars._2000464;
import static org.goldensun.GoldenSunVars._200046c;
import static org.goldensun.GoldenSunVars._200046e;
import static org.goldensun.GoldenSunVars._2000470;
import static org.goldensun.GoldenSunVars._2000472;
import static org.goldensun.GoldenSunVars._2000474;
import static org.goldensun.GoldenSunVars._2000478;
import static org.goldensun.GoldenSunVars._200047c;
import static org.goldensun.GoldenSunVars._200047e;
import static org.goldensun.GoldenSunVars._2000480;
import static org.goldensun.GoldenSunVars._2000482;
import static org.goldensun.GoldenSunVars._200048a;
import static org.goldensun.GoldenSunVars._200048c;
import static org.goldensun.GoldenSunVars._2002090;
import static org.goldensun.GoldenSunVars._2008004;
import static org.goldensun.GoldenSunVars._200800c;
import static org.goldensun.GoldenSunVars._200801c;
import static org.goldensun.GoldenSunVars._2008024;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
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
import static org.goldensun.GoldenSun_807.FUN_8077080;
import static org.goldensun.GoldenSun_807.FUN_8077098;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770c8;
import static org.goldensun.GoldenSun_807.FUN_80770d0;
import static org.goldensun.GoldenSun_807.FUN_8077120;
import static org.goldensun.GoldenSun_807.FUN_8077148;
import static org.goldensun.GoldenSun_807.FUN_80772f0;
import static org.goldensun.GoldenSun_809.FUN_80901c0;
import static org.goldensun.GoldenSun_809.FUN_80907b0;
import static org.goldensun.GoldenSun_809.FUN_8091174;
import static org.goldensun.GoldenSun_809.FUN_8091200;
import static org.goldensun.GoldenSun_809.FUN_8091220;
import static org.goldensun.GoldenSun_809.FUN_8091240;
import static org.goldensun.GoldenSun_809.FUN_8091254;
import static org.goldensun.GoldenSun_809.FUN_8091660;
import static org.goldensun.GoldenSun_809.FUN_8091858;
import static org.goldensun.GoldenSun_809.FUN_80919d8;
import static org.goldensun.GoldenSun_809.FUN_8091a58;
import static org.goldensun.GoldenSun_809.FUN_8093874;
import static org.goldensun.GoldenSun_809.FUN_8093a6c;
import static org.goldensun.GoldenSun_809.FUN_80941e0;
import static org.goldensun.GoldenSun_809.FUN_8094428;
import static org.goldensun.GoldenSun_809.FUN_8095680;
import static org.goldensun.GoldenSun_809.FUN_8095778;
import static org.goldensun.GoldenSun_809.FUN_8096af0;
import static org.goldensun.GoldenSun_809.FUN_8096b28;
import static org.goldensun.GoldenSun_809.FUN_8096fb0;
import static org.goldensun.GoldenSun_809.FUN_80970f8;
import static org.goldensun.GoldenSun_809.FUN_8097174;
import static org.goldensun.GoldenSun_809.FUN_8097194;
import static org.goldensun.GoldenSun_809.FUN_8099810;
import static org.goldensun.GoldenSun_809.FUN_809c138;
import static org.goldensun.GoldenSun_809.FUN_809c3a4;
import static org.goldensun.GoldenSun_80b.FUN_80b50a0;
import static org.goldensun.GoldenSun_80b.FUN_80b50f8;
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

  /** {@link GoldenSun_809#FUN_809163c} */
  @Method(0x808a010)
  public static void FUN_808a010(final int r0) {
    MEMORY.call(0x809163c, r0);
  }

  /** {@link GoldenSun_809#FUN_80916b0} */
  @Method(0x808a018)
  public static void FUN_808a018() {
    MEMORY.call(0x80916b0);
  }

  /** {@link GoldenSun_809#FUN_8091750} */
  @Method(0x808a020)
  public static void FUN_808a020() {
    MEMORY.call(0x8091750);
  }

  @Method(0x808a03c)
  public static void FUN_808a03c(final int r0) {
    MEMORY.call(0x808b868, r0);
  }

  /** {@link GoldenSun_809#FUN_8091c7c} */
  @Method(0x808a070)
  public static int FUN_808a070(final int r0, final int r1) {
    return (int)MEMORY.call(0x8091c7c, r0, r1);
  }

  @Method(0x808a080)
  public static Actor70 FUN_808a080(final int r0) {
    return (Actor70)MEMORY.call(0x8092054, r0);
  }

  /** {@link GoldenSun_809#FUN_8092064} */
  @Method(0x808a090)
  public static void FUN_808a090(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092064, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_809207c} */
  @Method(0x808a098)
  public static void FUN_808a098(final int actorIndex, final int r1) {
    MEMORY.call(0x809207c, actorIndex, r1);
  }

  @Method(0x808a0a0)
  public static void FUN_808a0a0(final int r0) {
    MEMORY.call(0x80920e8, r0);
  }

  /** {@link GoldenSun_809#FUN_80920fc} */
  @Method(0x808a0b0)
  public static void FUN_808a0b0(final int r0, final int r1) {
    MEMORY.call(0x80920fc, r0, r1);
  }

  @Method(0x808a0c0)
  public static void FUN_808a0c0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092158, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_809218c} */
  @Method(0x808a0c8)
  public static void FUN_808a0c8(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x809218c, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_80921c4} */
  @Method(0x808a0d0)
  public static void FUN_808a0d0(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x80921c4, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_80923e4} */
  @Method(0x808a0f0)
  public static void FUN_808a0f0(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x80923e4, actorIndex, x, z);
  }

  @Method(0x808a100)
  public static void FUN_808a100(final int r0, final int r1) {
    MEMORY.call(0x80924d4, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8092548} */
  @Method(0x808a110)
  public static void FUN_808a110(final int actorIndex, final int r1) {
    MEMORY.call(0x8092548, actorIndex, r1);
  }

  @Method(0x808a128)
  public static void FUN_808a128(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092560, r0, r1, r2);
  }

  @Method(0x808a130)
  public static void FUN_808a130(final int r0, final int r1) {
    MEMORY.call(0x809259c, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_80925cc} */
  @Method(0x808a138)
  public static void FUN_808a138(final int actorIndex, final int r1) {
    MEMORY.call(0x80925cc, actorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_8092848} */
  @Method(0x808a150)
  public static void FUN_808a150(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x8092848, actorIndex, r1, r2);
  }

  @Method(0x808a158)
  public static void FUN_808a158(final int r0, final int r1) {
    MEMORY.call(0x8092950, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8092b94} */
  @Method(0x808a170)
  public static void FUN_808a170(final int r0) {
    MEMORY.call(0x8092b94, r0);
  }

  /** {@link GoldenSun_809#FUN_8092c40} */
  @Method(0x808a178)
  public static GraphicsStruct24 FUN_808a178(final int r0) {
    return (GraphicsStruct24)MEMORY.call(0x8092c40, r0);
  }

  /** {@link GoldenSun_809#FUN_8092f84} */
  @Method(0x808a180)
  public static void FUN_808a180(final int r0, final int r1) {
    MEMORY.call(0x8092f84, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8093040} */
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

  /** {@link GoldenSun_809#FUN_80937b8} */
  @Method(0x808a1e8)
  public static void FUN_808a1e8(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x80937b8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_8093874} */
  @Method(0x808a1f0)
  public static void FUN_808a1f0(final int actorIndex, final int r1) {
    MEMORY.call(0x8093874, actorIndex, r1);
  }

  @Method(0x808a200)
  public static void FUN_808a200(final int r0, final int r1) {
    MEMORY.call(0x809335c, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_80933d4} */
  @Method(0x808a208)
  public static void FUN_808a208(final int r0, final int r1) {
    MEMORY.call(0x80933d4, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_80933f8} */
  @Method(0x808a210)
  public static void FUN_808a210(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80933f8, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_809#FUN_8093530} */
  @Method(0x808a218)
  public static void FUN_808a218() {
    MEMORY.call(0x8093530);
  }

  @Method(0x808a238)
  public static void FUN_808a238(final int r0, final int r1) {
    MEMORY.call(0x8091e3d, r0, r1);
  }

  @Method(0x808a248)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x8091e9c, r0);
  }

  @Method(0x808a278)
  public static void FUN_808a278(final int r0, final int r1) {
    MEMORY.call(0x8094154, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8094ac8} */
  @Method(0x808a2c0)
  public static void FUN_808a2c0() {
    MEMORY.call(0x8094ac8);
  }

  /** {@link GoldenSun_809#FUN_8095160} */
  @Method(0x808a2c8)
  public static void FUN_808a2c8() {
    MEMORY.call(0x8095160);
  }

  /** {@link GoldenSun_809#FUN_8095240} */
  @Method(0x808a2d8)
  public static void FUN_808a2d8() {
    MEMORY.call(0x8095240);
  }

  /** {@link GoldenSun_809#FUN_8095268} */
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

  /** {@link GoldenSun_809#FUN_8091dc8} */
  @Method(0x808a360)
  public static void FUN_808a360() {
    MEMORY.call(0x8091dc8);
  }

  /** Called after confirming character names */
  @Method(0x808a368)
  public static void FUN_808a368() {
    MEMORY.call(0x8091df4);
  }

  /** {@link GoldenSun_809#FUN_8091e20} */
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

  /** {@link GoldenSun_809#FUN_8091ff0} */
  @Method(0x808a5e0)
  public static void FUN_808a5e0(final int r0) {
    MEMORY.call(0x8091ff0, r0);
  }

  /** {@link GoldenSun_809#FUN_809202c} */
  @Method(0x808a5e8)
  public static void FUN_808a5e8() {
    MEMORY.call(0x809202c);
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
    r7 = _2000400.get();
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
        _2000400.set(r1);
        _2000402.set(CPU.r9().value);
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

    r3 = debug_3001f54.get();
    CPU.r11().value = 0x809f1a8; //TODO

    if(r3 == 0) {
      FUN_8077098();
      _2000400.set(0);
      _2000402.set(2);
    } else if(r0 == 1) {
      _2000400.set(5);
      _2000402.set(1);
    } else if(r0 == 2) {
      _2000400.set(1);
      _2000402.set(1);
    } else {
      //LAB_808a932
      FUN_8077098();
      _2000400.set(0);
      _2000402.set(2);
    }

    //LAB_808a94c
    FUN_8015360(_2000445.get(), _2000446.get());
    initVramSlots();
    clearTickCallbacks();
    clearTickCallbacks();
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
      CPU.r10().value = CPU.r11().value + _2000400.get() * 0x8;
      r6 = _2000402.get();
      DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);
      clearTickCallbacks();
      setInterruptHandler(1, 0, null);
      setInterruptHandler(2, 0, null);
      initMemoryAllocator();
      FUN_8004760();
      initVramSlots();
      r3 = _2000400.get();
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
          setMallocAddress(r5);
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
          setMallocAddress(r5);
        } else if(r3 == 0x1fe) {
          r6 = FUN_80b50a0(r6);
        }

        //LAB_808aaa0
        FUN_808a6e4(r6);
      } else {
        //LAB_808aaa8
        FUN_808ab74(_2000400.get(), FUN_80770c0(0x109));
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
          r0 = _200045e.get();
          if(r0 != -1) {
            FUN_80f9010(r0);
          } else {
            //LAB_808ab06
            FUN_808acc4();
          }
        }

        //LAB_808ab0a
        _200041a.set(MEMORY.ref(2, CPU.r10().value + 0x4).getUnsigned());
        FUN_808ab48();
        FUN_808a5f8(FUN_808c4f8(r6));
      }
    } while(true);
  }

  @Method(0x808ab48)
  public static void FUN_808ab48() {
    decompressPointerTableEntry(MEMORY.ref(2, 0x809f1a8 + _2000400.get() * 0x8).get(), 0x2008000);
  }

  @Method(0x808ab74)
  public static void FUN_808ab74(final int r0, final int r1) {
    final int r6 = MEMORY.ref(1, 0x809f1a8 + _2000400.get() * 0x8 + 0x2).get(); //TODO
    if(r1 == 0) {
      //LAB_808ab94
      for(int r5 = 0x200; r5 < 0x300; r5++) {
        FUN_80770d0(r5);
      }

      if(r6 != _200040c.get()) {
        //LAB_808abb6
        for(int r5 = 0x300; r5 < 0x400; r5++) {
          FUN_80770d0(r5);
        }

        FUN_80770c8(0x12f);
        _2000478.set(0);
        _2000472.set(0);
        FUN_80770d0(0x110);
        FUN_80770d0(0x111);
        FUN_80770d0(0x112);
        FUN_80770d0(0x113);
        _2000480.set(_2000400.get());
        _2000482.set(_2000402.get());
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
      _200045e.set(-1);
    }

    //LAB_808ac54
    _200040c.set(r6);
    FUN_80770c8((r6 & 0x7f) + 0x180);

    final int r2 = MEMORY.ref(1, 0x809f1a8 + _2000400.get() * 0x8 + 0x3).get();
    _200047e.set(r2);
    if(r2 == 2) {
      FUN_80770c8(0x123);
    }

    //LAB_808ac8e
    FUN_80772f0();
  }

  @Method(0x808acc4)
  public static void FUN_808acc4() {
    FUN_80f9010(_2000430.get());
  }

  @Method(0x808ace0)
  public static void FUN_808ace0(int r0) {
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);

    CPU.r10().value = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    CPU.r11().value = _2000400.get();
    CPU.sp().value -= 0x8;
    CPU.r9().value = _2000402.get();
    r6 = CPU.r10().value + 0x1a0;
    r5 = 0x809d170;
    r7 = 0;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    if(r0 != 0) {
      //LAB_808ad34
      while(MEMORY.ref(2, r5).get() != -1) {
        if(MEMORY.ref(2, r5).get() == CPU.r11().value) {
          r3 = MEMORY.ref(2, r5 + 0x2).get();
          if(r3 == -1 || r3 == CPU.r9().value) {
            //LAB_808ad48
            r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
            if((r0 & 0x7fff) == 0x7fff || FUN_80770c0(r0 << 17 >> 17) == 0) {
              //LAB_808ad62
              r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
              r3 = CPU.lslT(r3, 24);
              r3 = CPU.asrT(r3, 31);
              r3 = CPU.lslT(r3, 16);
              r3 = CPU.asrT(r3, 16);
              r7 = MEMORY.ref(2, r5 + 0x6).get();
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
              break;
            }
          }
        }

        //LAB_808ad74
        r5 += 0x8;
      }
    }

    //LAB_808ad80
    MEMORY.ref(1, r6).setu(0);
    r6++;

    //LAB_808ad88
    for(r3 = 0; r3 < 7; r3++) {
      MEMORY.ref(1, r6).setu(r7);
      r6++;
      if(r7 != 0) {
        r7++;
      }

      //LAB_808ad92
    }

    if(MEMORY.ref(4, CPU.sp().value + 0x4).get() != 0) {
      MEMORY.ref(1, CPU.r10().value + 0x1a0).setu(MEMORY.ref(1, CPU.r10().value + 0x1a1).getUnsigned());
      MEMORY.ref(1, CPU.r10().value + 0x1a1).setu(0);
    }

    //LAB_808adb0
    MEMORY.ref(4, CPU.r10().value + 0x1a8).setu(0);
    MEMORY.ref(4, CPU.r10().value + 0x1ac).setu(0x100000);
    FUN_808b25c();
    CPU.sp().value += 0x8;

    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808adf0)
  public static int FUN_808adf0(final int r0) {
    CPU.sp().value -= 0x4;
    int r5 = 0x809d7a8;
    final int r6 = FUN_8009268(r0, CPU.sp().value);
    int r10 = 0;
    //LAB_808ae1a
    while(MEMORY.ref(2, r5).get() != -1) {
      if(MEMORY.ref(2, r5).get() == MEMORY.ref(4, CPU.sp().value).get()) {
        final int r3 = MEMORY.ref(2, r5 + 0x2).get();
        if(r3 == -1 || r3 == r6) {
          //LAB_808ae32
          final int r0_0 = MEMORY.ref(2, r5 + 0x4).get();
          if(r0_0 == -1 || FUN_80770c0(r0_0) == 0) {
            //LAB_808ae42
            r10 = MEMORY.ref(2, r5 + 0x6).get();
            break;
          }
        }
      }

      //LAB_808ae4a
      r5 += 0x8;
    }

    //LAB_808ae56
    FUN_808b2b0(r6);

    CPU.sp().value += 0x4;
    return r10;
  }

  @Method(0x808ae74)
  public static int FUN_808ae74(final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808b02c)
  public static int FUN_808b02c(final int r0, final int r1) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x1a0;
    return FUN_808ae74(MEMORY.ref(1, r3 + r0).getUnsigned(), r1);
  }

  @Method(0x808b048)
  public static int FUN_808b048(final int r0, final int r1) {
    return FUN_808ae74(FUN_808adf0(r0), r1);
  }

  @Method(0x808b090)
  public static void FUN_808b090() {
    int r10 = 0x12;
    final int r11 = _2000400.get();
    int r5 = 0x809d9f0;
    final int r7 = _2000402.get();
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
    _2000430.set(r10);
  }

  @Method(0x808b1d8)
  public static void FUN_808b1d8() {
    final int r6 = _2000400.get();
    final int r5 = _2000402.get();
    int r2 = 0x809e1d8;

    //LAB_808b20e
    while(MEMORY.ref(2, r2).get() != -1) {
      if(MEMORY.ref(2, r2).get() == r6) {
        final int r3 = MEMORY.ref(2, r2 + 0x2).get();
        if(r3 == -1 || r3 == r5) {
          //LAB_808b222
          _2000404.set(MEMORY.ref(2, r2 + 0x4).getUnsigned());
          _2000406.set(MEMORY.ref(2, r2 + 0x6).getUnsigned());
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

    final int r0 = _2000400.get();

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
    _2000416.set(r1);
  }

  @Method(0x808b2b0)
  public static void FUN_808b2b0(final int r0) {
    final int r2 = switch(r0) {
      case 1 -> 0x38;
      case 2 -> 0x3a;
      case 3 -> 0x3c;
      case 4, 7 -> 0x36;
      case 5, 6 -> 0x37;
      default -> 0x39;
    };

    //LAB_808b2f2
    _2000416.set(r2);
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
    int r3;
    int r5;
    int r7;
    final int r9;
    int r10;
    int r11;

    r9 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r3 = MEMORY.ref(4, r9).get();
    r7 = r0;
    r11 = r1;
    r1 = 0;

    jmp_808b42e:
    if(r3 != r7) {
      if(r3 == 0) {
        MEMORY.ref(4, r9).setu(r7);
      } else {
        //LAB_808b418
        do {
          r1++;
          if(r1 > 3) {
            break jmp_808b42e;
          }
          r3 = MEMORY.ref(4, r9 + r1 * 0x4).get();
          if(r3 == r7) {
            break jmp_808b42e;
          }
        } while(r3 != 0);

        MEMORY.ref(4, r9 + r1 * 0x4).setu(r7);
      }
    }

    //LAB_808b42e
    r3 = MEMORY.ref(2, r7).get();

    //LAB_808b43a
    while(r3 != -1 && r11 <= 0x41) {
      int sp04 = 0;
      if(r3 < 8) {
        sp04 = r3;
        //LAB_808b446
      } else if(r3 < 9990) {
        sp04 = r11;
        r11++;
      }

      //LAB_808b454
      r5 = MEMORY.ref(2, r7 + 0x2).get();
      if(FUN_808d428(r5) != 0) {
        //LAB_808b464
        if(r5 < 0x30 || r5 > 0x7f || MEMORY.ref(2, r9 + 0x19e).get() == 3 || FUN_808d428(r5 + 0x50) != 0) {
          //LAB_808b488
          r10 = FUN_808b398(MEMORY.ref(2, r7).get());
          Actor70 r6 = getActor(sp04);
          Sprite38 r8 = null; // Appears to be uninitialized in one of the conditions
          if(r6 == null) {
            r6 = loadActor_(r10, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0xc).get(), MEMORY.ref(4, r7 + 0x10).get());
            if((MEMORY.ref(1, r7 + 0x17).getUnsigned() & 0x1) != 0) {
              final Actor70 r0_0 = getActor(sp04 - 1);
              if(r0_0.spriteType_54.get() == 1 && r6.spriteType_54.get() == 1) {
                final Sprite38 r0_1 = r0_0.sprite_50.deref();
                r0_1._1d.or(0x1);
                r5 = r0_1.slot_1c.get();
                r8 = r6.sprite_50.deref();
                r8._1d.or(0x1);
                clearVramSlot(r8.slot_1c.get());
                r8.slot_1c.set(r5);
              }
            }

            //LAB_808b4f6
            if(FUN_80770c0(0x21) != 0) {
              r3 = r10 - 0x12;
              if(r3 >= 0 && r3 < 2) {
                addLayerToSpriteIfRegularSprite_(r6, 226);
              }
            }
            //LAB_808b512
          } else if(FUN_80770c0(0x109) == 0) {
            FUN_80090f0(r6, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0xc).get(), MEMORY.ref(4, r7 + 0x10).get());
          }

          //LAB_808b528
          if(r6 != null) {
            FUN_8009080(r6, 0x1);

            if(r6.spriteType_54.get() == 1) {
              r8 = r6.sprite_50.derefNullable();
              if(r8 != null) {
                r8._24.set(modU(rand(), 0x1e));
              }
            }

            //LAB_808b556
            r6.angle_06.set(MEMORY.ref(2, r7 + 0x14).getUnsigned());
            r6._59.set(0x1);
            FUN_8093a6c(r6, MEMORY.ref(4, r7 + 0x4).get());
            FUN_8009080(r6, 0x1);
            r6._64.set(r6.pos_08.getX() / 0x10000);
            r6._66.set(r6.pos_08.getZ() / 0x10000);
            if(r6.pos_08.getY() != 0) {
              r6._55.set(0x4);
              r6.pos_08.y_04.add(0x8000);
            }

            //LAB_808b5ac
            if(MEMORY.ref(2, r9 + 0x19e).get() == 3) {
              r6._55.and(0xfe);

              if(FUN_80770c0(0x21) == 0) {
                r8.scale_18.set((int)MEMORY.call(0x3000118, r8.scale_18.get(), 0xc000));
              }
            } else {
              //LAB_808b5e6
              r0 = FUN_80091a8(0, r6.pos_08.getX(), r6.pos_08.getZ());
              r6._14.set(r0);
              r6.pos_08.y_04.add(r0);
            }

            //LAB_808b5f8
            r6.flags_23.set(0x1);
          }

          //LAB_808b600
          MEMORY.ref(4, r9 + 0x14 + sp04 * 0x4).setu(r6.getAddress()); //TODO
        }
      }

      //LAB_808b60a
      r7 = CPU.addT(r7, 0x18);
      r3 = MEMORY.ref(2, r7).get();

      //LAB_808b618
    }

    //LAB_808b624
  }

  @Method(0x808b674)
  public static void FUN_808b674(int r0) {
    final int r1;
    int r2;
    int r3;
    final int r5;
    final int r7;
    final int r8;
    final int r10;

    r10 = r0;
    r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r7 = _2000434.get();
    r5 = r8 + 0x200;
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

    r2 = r8 + 0x218;

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

    r3 = r8 + 0xc;
    CPU.r12().value = r8;

    //LAB_808b6b6
    do {
      MEMORY.ref(4, r3).setu(0);
      r3 -= 0x4;
    } while(r3 >= CPU.r12().value);

    FUN_808b9f8();
    MEMORY.ref(2, r5).setu(r7);
    MEMORY.ref(2, r5 + 0x2).setu(0xffff);
    MEMORY.ref(4, r5 + 0xc).setu(0);
    MEMORY.ref(4, r5 + 0x8).setu(_200041c.get());
    MEMORY.ref(4, r5 + 0x10).setu(_2000424.get());
    MEMORY.ref(2, r5 + 0x14).setu(_2000428.get());
    FUN_808b3ec(r5, r7);
    FUN_808b3ec(r10, 0x8);

    final Actor70 r5_0 = MEMORY.ref(4, r8 + 0x14 + r7 * 0x4).deref(4).cast(Actor70::new);
    r5_0.layer_22.set(_200042c.get());

    r3 = (r5_0.pos_08.getX() / 0x100000 + r5_0.pos_08.getZ() / 0x100000 * 0x80) * 0x4;
    r2 = 0x2010000 + r3;
    r1 = 0x200fe00 + r3;

    if(_2000420.get() != 0 && MEMORY.ref(1, r2 + 0x2).getUnsigned() == 0xfd && MEMORY.ref(1, r1 + 0x2).getUnsigned() == 0xfd) {
      _2000432.set(0x1);
      r0 = FUN_80091a8(0, r5_0.pos_08.getX(), r5_0.pos_08.getZ() - 0x100000) - 0x200000;
      r3 = r5_0.pos_08.getY() + r0;
      r5_0.pos_08.setY(r3);
      r5_0._14.set(r3);
      r5_0._55.set(0);
      FUN_80091e0(r5_0, 0);
      FUN_8009080(r5_0, 0xc);
    } else {
      //LAB_808b7b8
      _2000432.set(0);
    }

    //LAB_808b7c4
    final Actor70 r6 = loadActor_(0x8000, r5_0.pos_08.getX(), r5_0.pos_08.getY(), r5_0.pos_08.getZ());
    r6._14.set(r5_0._14.get());
    FUN_80090e0(r6, r5_0);

    if(MEMORY.ref(2, r8 + 0x19e).get() == 3) {
      r0 = FUN_8009048(r5_0.sprite_50.deref(), 0x17);
      MEMORY.ref(1, r0 + 0x5).setu(0xf);
      MEMORY.ref(1, r0 + 0x6).setu(0x9);
    }

    //LAB_808b7fc
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._00.set(r6.pos_08.getAddress()); //TODO polymorphic?
    MEMORY.ref(4, r8 + 0x1e0).setu(r6.getAddress()); //TODO
  }

  @Method(0x808b868)
  public static void FUN_808b868(final int r0) {
    final Map194 r6 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    FUN_80770d0(0x164);
    FUN_80770c8(0x165);

    //LAB_808b894
    int r5 = r0;
    while(MEMORY.ref(2, r5).get() != -1) {
      if(MEMORY.ref(2, r5 + 0x2).get() == 0) {
        final int r2 = MEMORY.ref(4, r5 + 0x8).get();
        final int r1 = MEMORY.ref(4, r5 + 0x10).get();

        if(r2 >= r6._ec.get() && r2 <= r6._f4.get() && r1 >= r6._f0.get() && r1 <= r6._f8.get()) {
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
  public static Actor70 getActor(final int index) {
    if(index < 0 || index >= 0xc0) {
      return null;
    }

    final int r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final int addr = MEMORY.ref(4, r2 + 0x14 + index * 0x4).get();

    if(addr == 0) {
      return null;
    }

    return MEMORY.ref(4, addr, Actor70::new);
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
    final int r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    return MEMORY.ref(2, r1 + 0x16c).get() + MEMORY.ref(2, r1 + 0x16e).get() + MEMORY.ref(2, r1 + 0x170).get() + MEMORY.ref(2, r1 + 0x172).get() + MEMORY.ref(2, r1 + 0x174).get() + MEMORY.ref(2, r1 + 0x176).get() + MEMORY.ref(2, r1 + 0x178).get() * 2 + MEMORY.ref(2, r1 + 0x17a).get() + MEMORY.ref(2, r1 + 0x17c).get() + MEMORY.ref(2, r1 + 0x17e).get() + MEMORY.ref(2, r1 + 0x180).get() + MEMORY.ref(2, r1 + 0x182).get();
  }

  @Method(0x808bd24)
  public static int FUN_808bd24() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r2 = MEMORY.ref(4, 0x808bdcc).get();
    r1 = CPU.movT(0, 0xfa);
    r1 = CPU.lslT(r1, 1);
    r2 = CPU.addT(r2, r1);
    r3 = MEMORY.ref(4, 0x808bdd0).get();
    r2 = MEMORY.ref(4, r2).get();
    r6 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 2);
    r2 = CPU.addT(r2, 0x14);
    r2 = MEMORY.ref(4, r6 + r2).get();
    r3 = CPU.subT(r3, 0x4c);
    CPU.sp().value -= 0xc;
    r7 = MEMORY.ref(4, r3).get();
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, r2 + 0x8).get();
      r5 = CPU.sp().value;
      MEMORY.ref(4, r5).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0xc).get();
      MEMORY.ref(4, r5 + 0x4).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x10).get();
      MEMORY.ref(4, r5 + 0x8).setu(r3);
      r0 = CPU.movT(0, 0x80);
      r1 = MEMORY.ref(2, r2 + 0x6).getUnsigned();
      r0 = CPU.lslT(r0, 13);
      r2 = CPU.addT(r5, 0x0);
      rotVec3(r0, r1, r2);
      r2 = CPU.movT(0, 0xcf);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r6, r2);
      r1 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r1).get();
      CPU.cmpT(r3, 0x3);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r5).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x808bdd4).get();
          r3 = CPU.addT(r3, r2);
        }

        //LAB_808bd78
        r2 = MEMORY.ref(4, r5 + 0x8).get();
        r1 = CPU.asrT(r3, 21);
        r0 = CPU.movT(0, 0x1f);
        r1 = CPU.andT(r1, r0);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808bdd4).get();
          r2 = CPU.addT(r2, r3);
        }

        //LAB_808bd88
        r3 = CPU.asrT(r2, 21);
        r3 = CPU.andT(r3, r0);
        r3 = CPU.lslT(r3, 5);
        r3 = CPU.addT(r1, r3);
        r2 = MEMORY.ref(4, 0x808bdd8).get();
        r3 = CPU.lslT(r3, 2);
        r1 = CPU.addT(r3, r2);
      } else {
        //LAB_808bd98
        r1 = CPU.movT(0, 0x98);
        r1 = CPU.lslT(r1, 1);
        r3 = CPU.addT(r7, r1);
        r1 = MEMORY.ref(4, r3).get();
        r3 = MEMORY.ref(4, r5).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x808bddc).get();
          r3 = CPU.addT(r3, r2);
        }

        //LAB_808bdaa
        r2 = MEMORY.ref(4, r5 + 0x8).get();
        r0 = CPU.asrT(r3, 20);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808bddc).get();
          r2 = CPU.addT(r2, r3);
        }

        //LAB_808bdb6
        r3 = CPU.asrT(r2, 20);
        r3 = CPU.lslT(r3, 7);
        r3 = CPU.addT(r0, r3);
        r3 = CPU.lslT(r3, 2);
        r1 = CPU.addT(r1, r3);
      }

      //LAB_808bdc0
      r0 = MEMORY.ref(1, r1 + 0x2).getUnsigned();
    }

    //LAB_808bdc2
    CPU.sp().value += 0xc;
    return r0;
  }

  @Method(0x808bde0)
  public static void FUN_808bde0(final int r0, final int r1, final int r2) {
    int r5 = (int)MEMORY.call(MEMORY.ref(4, 0x200802c).get());
    if(r5 != 0) {
      final int sp00 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
      int r6 = MEMORY.ref(2, r5).get();
      //LAB_808be16
      while(r6 != -1) {
        final int r8 = MEMORY.ref(2, r5 + 0x2).get();
        final int r11 = MEMORY.ref(2, r5 + 0x4).get();
        final int r10 = MEMORY.ref(2, r5 + 0x6).get();
        final int r9 = MEMORY.ref(2, r5 + 0xa).get();
        final int r7 = MEMORY.ref(2, r5 + 0x8).get();
        final int sp04 = MEMORY.ref(2, r5 + 0xe).get();
        if(FUN_808d428(MEMORY.ref(2, r5 + 0xc).get()) != 0) {
          if(r1 >= r8 << 16 && r1 < r7 << 16) {
            if(r0 >= r6 << 16 && r0 < r10 << 16) {
              if(r2 >= r11 << 16 && r2 < r9 << 16) {
                MEMORY.ref(2, sp00 + 0x170).setu(sp04);
                FUN_80f9010(0x7b);
                FUN_8091660();
                break;
              }
            }
          }
        }

        //LAB_808be90
        r5 += 0x10;
        r6 = MEMORY.ref(2, r5).get();
      }
    }

    //LAB_808bea4
  }

  @Method(0x808bec0)
  public static void FUN_808bec0(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x2c;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
    CPU.r9().value = r3;
    r3 = MEMORY.ref(4, 0x808c0fc).get();
    CPU.r11().value = r0;
    r0 = MEMORY.ref(4, r3).get();
    r3 = CPU.subT(r3, 0x4c);
    r3 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r1;
    r7 = MEMORY.ref(4, 0x808c100).get();
    r1 = CPU.movT(0, 0xfa);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r7, r1);
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    r3 = CPU.lslT(r3, 2);
    r3 = CPU.addT(r3, 0x14);
    r3 = MEMORY.ref(4, r0 + r3).get();
    r2 = CPU.movT(0, 0x0);
    CPU.r8().value = r0;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_808bf02
      r0 = FUN_8077148();
      r6 = CPU.movT(0, 0x0);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
      r6 = CPU.cmpT(r6, r0);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r3 = CPU.movT(0, 0xfc);
        r3 = CPU.lslT(r3, 1);
        r5 = CPU.sp().value + 0x1c;
        r7 = CPU.addT(r7, r3);

        //LAB_808bf16
        do {
          r0 = MEMORY.ref(1, r7).getUnsigned();
          r0 = FUN_8077008(r0);
          r3 = MEMORY.ref(2, r0 + 0x38).getUnsigned();
          MEMORY.ref(2, r5).setu(r3);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r6 = CPU.addT(r6, 0x1);
          r7 = CPU.addT(r7, 0x1);
          r5 = CPU.addT(r5, 0x2);
          r6 = CPU.cmpT(r6, r4);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      }

      //LAB_808bf2c
      r3 = CPU.movT(0, 0xcf);
      r3 = CPU.lslT(r3, 1);
      r3 += CPU.r8().value;
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r0).get();
      CPU.cmpT(r3, 0x3);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.r10().value;
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808c104).get();
          r3 += CPU.r10().value;
        }

        //LAB_808bf44
        r2 = CPU.asrT(r3, 21);
        r1 = CPU.movT(0, 0x1f);
        r3 = CPU.r9().value;
        r2 = CPU.andT(r2, r1);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808c104).get();
          r3 += CPU.r9().value;
        }

        //LAB_808bf54
        r3 = CPU.asrT(r3, 21);
        r3 = CPU.andT(r3, r1);
        r3 = CPU.lslT(r3, 5);
        r3 = CPU.addT(r2, r3);
        r1 = MEMORY.ref(4, 0x808c108).get();
        r3 = CPU.lslT(r3, 2);
        r0 = CPU.addT(r3, r1);
      } else {
        //LAB_808bf64
        r2 = CPU.r11().value;
        CPU.cmpT(r2, 0x2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r3 = CPU.lslT(r2, 1);
          r3 += CPU.r11().value;
          r4 = CPU.movT(0, 0x98);
          r3 = CPU.lslT(r3, 4);
          r4 = CPU.lslT(r4, 1);
          r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r3 = CPU.addT(r3, r4);
          r0 = MEMORY.ref(4, r1 + r3).get();
        } else {
          //LAB_808bf7c
          r0 = MEMORY.ref(4, 0x808c10c).get();
        }

        //LAB_808bf7e
        r3 = CPU.r10().value;
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808c110).get();
          r3 += CPU.r10().value;
        }

        //LAB_808bf88
        r2 = CPU.asrT(r3, 20);
        r3 = CPU.r9().value;
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x808c110).get();
          r3 += CPU.r9().value;
        }

        //LAB_808bf94
        r3 = CPU.asrT(r3, 20);
        r3 = CPU.lslT(r3, 7);
        r3 = CPU.addT(r2, r3);
        r3 = CPU.lslT(r3, 2);
        r0 = CPU.addT(r0, r3);
      }

      //LAB_808bf9e
      r2 = CPU.movT(0, 0xdc);
      r2 = CPU.lslT(r2, 1);
      r2 += CPU.r8().value;
      r1 = CPU.movT(0, 0xde);
      r3 = MEMORY.ref(4, r2).get();
      r1 = CPU.lslT(r1, 1);
      r6 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
      r1 += CPU.r8().value;
      MEMORY.ref(4, r1).setu(r3);
      MEMORY.ref(4, r2).setu(r0);
      CPU.cmpT(r6, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.r10().value;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r2 = CPU.r9().value;
        FUN_808bde0(r0, r1, r2);
      }

      //LAB_808bfc0
      r3 = CPU.subT(r6, 0x1);
      CPU.cmpT(r3, 0xee);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r3 = CPU.movT(0, 0xb6);
        r3 = CPU.lslT(r3, 1);
        r3 += CPU.r8().value;
        MEMORY.ref(2, r3).setu(r6);
      }

      //LAB_808bfce
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.subT(r3, 0xfc);
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r3 = CPU.movT(0, 0xb7);
        r3 = CPU.lslT(r3, 1);
        r3 += CPU.r8().value;
        MEMORY.ref(2, r3).setu(r6);
      }

      //LAB_808bfde
      r4 = MEMORY.ref(4, 0x808c100).get();
      r2 = CPU.movT(0, 0xf9);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r4, r2);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_808bfee
        r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_808bff6
          r0 = CPU.movT(0, 0x80);
          r3 = MEMORY.ref(4, r3 + 0x38).get();
          r0 = CPU.lslT(r0, 24);
          r3 = CPU.cmpT(r3, r0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_808c002
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = MEMORY.ref(4, 0x808c114).get();
            r5 = MEMORY.ref(4, r1 + 0x30).get();
            r0 = FUN_80770c0(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r5 = CPU.lslT(r5, 1);
            }

            //LAB_808c012
            r3 = CPU.movT(0, 0xcf);
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r8().value;
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(2, r3 + r2).get();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r1 = CPU.addT(r5, 0x0);
              r0 = CPU.addT(r0, 0x8);
              r0 = FUN_808b048(r0, r1);
              r3 = CPU.movT(0, 0xbe);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r7 = CPU.movT(0, 0x1);
            } else {
              //LAB_808c034
              r3 = CPU.addT(r6, 0x0);
              r3 = CPU.subT(r3, 0xf0);
              CPU.cmpT(r3, 0x1);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r3 = CPU.addT(r6, 0x0);
                r0 = CPU.addT(r6, 0x0);
                r3 = CPU.addT(r3, 0xb1);
                r4 = CPU.r8().value;
                r0 = CPU.subT(r0, 0xef);
                r1 = CPU.addT(r5, 0x0);
                r7 = MEMORY.ref(1, r4 + r3).getUnsigned();
              } else {
                //LAB_808c04c
                r3 = CPU.movT(0, 0xd0);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r8().value;
                r0 = CPU.movT(0, 0x0);
                r1 = CPU.addT(r5, 0x0);
                r7 = MEMORY.ref(1, r3).getUnsigned();
              }

              //LAB_808c058
              r0 = FUN_808b02c(r0, r1);
              r3 = CPU.movT(0, 0xbe);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
            }

            //LAB_808c062
            MEMORY.ref(2, r3).setu(r0);
            r3 = CPU.movT(0, 0xd8);
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r8().value;
            r4 = MEMORY.ref(4, 0x808c118).get();
            r0 = MEMORY.ref(4, r3).get();
            r1 = MEMORY.ref(4, r2 + 0x30).get();
            r0 = CPU.lslT(r0, 0);
            CPU.r12().value = 0x808c078;
            r0 = (int)MEMORY.call(r4, r0, r1);
            CPU.cmpT(r7, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.lsrT(r0, 31);
              r3 = CPU.addT(r0, r3);
              r0 = CPU.asrT(r3, 1);
            }

            //LAB_808c082
            r2 = CPU.movT(0, 0xda);
            r2 = CPU.lslT(r2, 1);
            r2 += CPU.r8().value;
            r3 = MEMORY.ref(4, r2).get();
            r0 = CPU.addT(r3, r0);
            r3 = MEMORY.ref(4, 0x808c11c).get();
            MEMORY.ref(4, r2).setu(r0);
            r0 = CPU.cmpT(r0, r3);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r1 = CPU.addT(r0, 0x0);
              CPU.cmpT(r0, 0x0);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                r1 = CPU.addT(r0, r3);
              }

              //LAB_808c09c
              r0 = CPU.andT(r0, r3);
              r1 = CPU.asrT(r1, 16);
              MEMORY.ref(4, r2).setu(r0);
              r0 = CPU.addT(r1, 0x0);
              r1 = CPU.movT(0, 0x0);
              FUN_808c2dc(r0);
              r0 = FUN_80b50f8();
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = CPU.movT(0, 0x8b);
                FUN_80f9010(r0);
              }

              //LAB_808c0b8
              FUN_8091858();
              r0 = FUN_808c3a4();
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            }

            //LAB_808c0c2
            r4 = MEMORY.ref(4, 0x808c100).get();
            r0 = MEMORY.ref(4, 0x808c120).get();
            r3 = CPU.addT(r4, r0);
            r1 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(2, r3 + r1).get();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              CPU.cmpT(r6, 0xfa);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.movT(0, 0xde);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r8().value;
                r3 = MEMORY.ref(4, r3).get();
                r3 = MEMORY.ref(1, r3 + 0x2).getUnsigned();
                CPU.cmpT(r3, 0xfa);
                if(CPU.cpsr().getZero()) { // ==
                  r2 = MEMORY.ref(4, 0x808c124).get();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r1 = CPU.addT(r4, r2);
                  r2 = MEMORY.ref(4, r3 + 0x30).get();
                  CPU.cmpT(r2, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r0 = MEMORY.ref(4, 0x808c11c).get();
                    r2 = CPU.addT(r2, r0);
                  }

                  //LAB_808c0f2
                  r3 = MEMORY.ref(2, r1).getUnsigned();
                  r2 = CPU.asrT(r2, 16);
                  r3 = CPU.addT(r3, r2);
                  MEMORY.ref(2, r1).setu(r3);
                } else {
                  //LAB_808c128
                  r1 = CPU.movT(0, 0x8b);
                  r1 = CPU.lslT(r1, 2);
                  r3 = CPU.addT(r4, r1);
                  r3 = MEMORY.ref(2, r3).getUnsigned();
                  r3 = CPU.lslT(r3, 16);
                  r2 = CPU.asrT(r3, 16);
                  r0 = MEMORY.ref(4, 0x808c2c0).get();
                  r3 = CPU.lsrT(r3, 31);
                  r2 = CPU.addT(r2, r3);
                  r2 = CPU.asrT(r2, 1);
                  r3 = CPU.addT(r4, r0);
                  MEMORY.ref(2, r3).setu(r2);
                }
              }
            }

            //LAB_808c140
            r2 = CPU.movT(0, 0x91);
            r2 = CPU.lslT(r2, 2);
            r1 = CPU.addT(r4, r2);
            r2 = MEMORY.ref(4, r1).get();
            CPU.cmpT(r2, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = MEMORY.ref(4, 0x808c2c4).get();
              r3 = CPU.addT(r4, r0);
              r0 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r0).get();
              CPU.cmpT(r3, 0x2);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r3 = MEMORY.ref(4, r0 + 0x30).get();
                r3 = CPU.subT(r2, r3);
                MEMORY.ref(4, r1).setu(r3);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r3 = CPU.movT(0, 0x1);
                  r2 = CPU.movT(0, 0xbf);
                  MEMORY.ref(4, r1).setu(r3);
                  r2 = CPU.lslT(r2, 1);
                  r2 += CPU.r8().value;
                  r1 = CPU.movT(0, 0x0);
                  r3 = MEMORY.ref(2, r2 + r1).get();
                  CPU.cmpT(r3, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r3 = MEMORY.ref(4, 0x808c2c8).get();
                    MEMORY.ref(2, r2).setu(r3);
                  }
                }
              }
            }
          }
        }
      }

      //LAB_808c17a
      r2 = MEMORY.ref(4, 0x808c2cc).get();
      r3 = CPU.addT(r4, r2);
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r0).get();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r1 = MEMORY.ref(4, 0x808c2c0).get();
        r5 = CPU.addT(r4, r1);
        r3 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(2, r5).setu(r3);
        r2 = CPU.subT(r2, 0x2);
        r6 = CPU.addT(r4, r2);
        r0 = MEMORY.ref(2, r6).getUnsigned();
        r2 = CPU.lslT(r0, 16);
        r1 = CPU.asrT(r2, 16);
        r2 = CPU.lsrT(r2, 31);
        r1 = CPU.addT(r1, r2);
        r3 = CPU.lslT(r3, 16);
        r3 = CPU.asrT(r3, 16);
        r1 = CPU.asrT(r1, 1);
        r3 = CPU.cmpT(r3, r1);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r1 = MEMORY.ref(4, 0x808c2d0).get();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          FUN_8093874(r0, r1);
          r0 = MEMORY.ref(2, r6).getUnsigned();
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_808c1b6
        r3 = CPU.movT(0, 0x0);
        r2 = MEMORY.ref(2, r5 + r3).get();
        r3 = CPU.lslT(r0, 16);
        r3 = CPU.asrT(r3, 16);
        r2 = CPU.cmpT(r2, r3);
        if(CPU.cpsr().getZero()) { // ==
          r1 = CPU.movT(0, 0x80);
          r1 = CPU.lslT(r1, 1);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          FUN_8093874(r0, r1);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }
      }

      //LAB_808c1d0
      r1 = MEMORY.ref(4, 0x808c2c0).get();
      r2 = CPU.movT(0, 0x8b);
      r2 = CPU.lslT(r2, 2);
      r0 = CPU.addT(r4, r1);
      r3 = CPU.addT(r4, r2);
      r1 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r1).get();
      r1 = CPU.movT(0, 0x0);
      r2 = MEMORY.ref(2, r0 + r1).get();
      r2 = CPU.cmpT(r2, r3);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r2 = CPU.movT(0, 0x8c);
        r2 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r4, r2);
        r2 = CPU.movT(0, 0x0);
        r1 = MEMORY.ref(2, r3 + r2).get();
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r0).setu(r3);
        r0 = CPU.movT(0, 0xff);
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 1);
        r0 = CPU.andT(r0, r1);
        r0 = CPU.negT(r0, r0);
        r1 = CPU.andT(r1, r3);
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        FUN_808c30c(r0, r1);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_808c20e
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xc2);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.movT(0, 0x0);
        r3 += CPU.r8().value;
        MEMORY.ref(2, r3).setu(r2);
        r3 = CPU.movT(0, 0xc3);
        r3 = CPU.lslT(r3, 1);
        r3 += CPU.r8().value;
        MEMORY.ref(2, r3).setu(r2);
        r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 11);
        MEMORY.ref(4, r1 + 0x28).setu(r3);
        r1 = CPU.movT(0, 0x81);
        r1 = CPU.lslT(r1, 1);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        FUN_8093874(r0, r1);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r6 = CPU.movT(0, 0x0);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        r6 = CPU.cmpT(r6, r2);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          r3 = CPU.movT(0, 0xc1);
          r3 = CPU.lslT(r3, 1);
          r7 = CPU.movT(0, 0xc3);
          r0 = CPU.movT(0, 0xfc);
          r3 += CPU.r8().value;
          r7 = CPU.lslT(r7, 1);
          r0 = CPU.lslT(r0, 1);
          CPU.r10().value = r3;
          r7 += CPU.r8().value;
          r5 = CPU.addT(r4, r0);

          //LAB_808c258
          do {
            r0 = MEMORY.ref(1, r5).getUnsigned();
            r0 = FUN_8077008(r0);
            r1 = CPU.movT(0, 0x38);
            r3 = MEMORY.ref(2, r0 + r1).get();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r3 = MEMORY.ref(2, r7).getUnsigned();
              r3 = CPU.addT(r3, 0x1);
              MEMORY.ref(2, r7).setu(r3);
            } else {
              //LAB_808c26e
              r3 = CPU.sp().value + 0x1c;
              r2 = CPU.lslT(r6, 1);
              r3 = MEMORY.ref(2, r3 + r2).get();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r1 = CPU.movT(0, 0xc2);
                r1 = CPU.lslT(r1, 1);
                r1 += CPU.r8().value;
                r3 = MEMORY.ref(2, r1).getUnsigned();
                r2 = CPU.addT(r3, 0x1);
                MEMORY.ref(2, r1).setu(r2);
                r3 = CPU.lslT(r3, 16);
                r1 = CPU.movT(0, 0xc4);
                r1 = CPU.lslT(r1, 1);
                r2 = MEMORY.ref(1, r5).getUnsigned();
                r3 = CPU.asrT(r3, 15);
                r3 = CPU.addT(r3, r1);
                r4 = CPU.r8().value;
                MEMORY.ref(2, r4 + r3).setu(r2);
                r3 = MEMORY.ref(4, 0x808c2d4).get();
                r1 = CPU.r10().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = MEMORY.ref(4, 0x808c2d8).get();
                r2 = CPU.addT(r0, r3);
                r3 = CPU.movT(0, 0x0);
                MEMORY.ref(1, r2).setu(r3);
              }
            }

            //LAB_808c2a2
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r6 = CPU.addT(r6, 0x1);
            r5 = CPU.addT(r5, 0x1);
            r6 = CPU.cmpT(r6, r4);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }
      }
    }

    //LAB_808c2ac
    CPU.sp().value += 0x2c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808c2dc)
  public static void FUN_808c2dc(final int r0) {
    final int r5 = FUN_8077148();

    //LAB_808c2f2
    for(int i = 0; i < r5; i++) {
      FUN_8077120(MEMORY.ref(1, 0x2000438 + i).getUnsigned(), r0);
    }

    //LAB_808c302
  }

  @Method(0x808c30c)
  public static void FUN_808c30c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c3a4)
  public static int FUN_808c3a4() {
    throw new RuntimeException("Not implemented");
  }

  /** Pressing start as soon as you gain control of the player */
  @Method(0x808c44c)
  public static void FUN_808c44c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;

    r0 = mallocSlotBoard(27, 0xccc);
    r1 = CPU.movT(0, 0xcf);
    r5 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r5, r1);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = mallocSlotBoard(31, 0x540);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x808c4b4).get();
        r4 = CPU.addT(r0, r3);
        r3 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(1, r4 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, 0x808c4b8).get();
          r2 = CPU.movT(0, 0x0);
          r3 = CPU.addT(r0, r1);
          r1 = CPU.addT(r1, 0x1);
          MEMORY.ref(1, r3).setu(r2);
          r3 = CPU.addT(r0, r1);
          MEMORY.ref(1, r3).setu(r2);
          r3 = MEMORY.ref(4, 0x808c4bc).get();
          r1 = CPU.addT(r0, r3);
          r3 = CPU.movT(0, 0x1);
          MEMORY.ref(1, r1).setu(r3);
          MEMORY.ref(1, r4).setu(r2);
        }
      }

      //LAB_808c498
      r1 = CPU.movT(0, 0xf0);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r5, r1);
      r3 = MEMORY.ref(4, r3).get();
      r2 = CPU.movT(0, 0x1);
      r3 = CPU.addT(r3, 0x5b);
      MEMORY.ref(1, r3).setu(r2);
      FUN_8009230();
    }

    //LAB_808c4aa
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
    int r5;
    int r6;
    int r7;
    final int r8;
    final int r9;
    final int r11;

    CPU.sp().value -= 0x10;
    r8 = mallocSlotBoard(27, 0xccc);

    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value + 0xc);
    DMA.channels[3].DAD.setu(r8);
    DMA.channels[3].CNT.setu(0x85000333);

    FUN_80770d0(0x103);
    _2000408.set(_2000400.get());
    _200040a.set(_2000402.get());
    _200040e.set(-1);
    _2000410.set(-1);
    _2000412.set(-1);
    _2000414.set(-1);
    clearTickCallbacks();
    FUN_8095778(0);
    r0 = _200041a.get();
    if(r0 == 1) {
      FUN_8009118();
      _2000464.set(1);
      FUN_808ace0(0);
      r6 = 3;
    } else {
      //LAB_808c598
      loadMap_(r0);
      FUN_808ace0(1);
      r6 = 2;
    }

    //LAB_808c5a4
    MEMORY.ref(2, r8 + 0x19e).setu(r6);
    FUN_8009078(r6);
    FUN_8015000();
    FUN_808bc44();
    MEMORY.ref(4, r8 + 0x10).setu(_2008024.deref().run());
    FUN_808cf78();
    FUN_808b674(_200801c.deref().run());

    if(FUN_80770c0(0x109) != 0) {
      FUN_808bb2c();
    }

    //LAB_808c5e2
    if(_2000474.get() != 0) {
      FUN_8095680();
    }

    //LAB_808c5f6
    if(r6 == 3) {
      FUN_8009130();
      FUN_8009138(_200041c.get(), _2000424.get());
    } else {
      //LAB_808c614
      FUN_8009128();
    }

    //LAB_808c618
    FUN_808e9c0();
    FUN_8091174();
    FUN_8091200(0x10000, 0);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r8 + 0x1c0);
    MEMORY.ref(4, r8 + 0x1c0).setu(0x100);
    MEMORY.ref(4, r8 + 0x1c8).setu(0x10);
    r7 = r8 + 0x1c6;
    MEMORY.ref(2, r8 + 0x1c6).setu(0);
    MEMORY.ref(4, r8 + 0x1b0).setu(0x199);
    MEMORY.ref(4, r8 + 0x1b4).setu(0);

    if(_200047e.get() == 2) {
      MEMORY.ref(4, r8 + 0x1b0).setu(0);
      FUN_80770c8(0x144);
    }

    //LAB_808c678
    MEMORY.ref(4, r8 + 0x1bc).setu(0x2010000);

    if(FUN_80770c0(0x109) == 0) {
      FUN_808b1d8();
      _200046c.set(0x10);
      _200046e.set(0);
      _2000470.set(1);
      _200048a.set(-1);
      _200048c.set(0);
    }

    //LAB_808c6bc
    FUN_8099810();
    MEMORY.ref(2, r8 + 0xcc8).setu(-1);
    _2008004.deref().run();
    r0 = MEMORY.ref(2, r8 + 0x170).get();
    if(r0 != 0) {
      r7 = r0;
      MEMORY.ref(2, r8 + 0x170).setu(0);
    } else {
      //LAB_808c6ec
      FUN_80770d0(0x109);

      if(FUN_808bc9c() == 0) {
        r5 = MEMORY.ref(2, r7).getUnsigned();
        if(r5 == 0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          FUN_808fefc(MEMORY.ref(4, r3).get(), MEMORY.ref(4, r8 + 0x1c8).get());
          MEMORY.ref(2, r7).setu(0x1);
          MEMORY.ref(2, 0x5000000).setu(r5);

          if(FUN_8094428() == 0) {
            sleep((MEMORY.ref(4, r8 + 0x1c8).get() + 1) / 2);
          }
        }

        //LAB_808c72e
        if(FUN_80770c0(0x12f) != 0) {
          FUN_80770d0(0x12f);
          FUN_8015200(_2000400.get());
        }

        //LAB_808c750
        if(_2000474.get() != 0) {
          FUN_8095778(_2000474.get());
          _2000474.set(0);
        }

        //LAB_808c76a
        if(_200047c.get() != 0) {
          FUN_808c44c();

          if(FUN_80919d8(_200047c.get()) == 0) {
            FUN_8091a58(_200047c.get(), 0);
          }

          //LAB_808c78c
          FUN_808c4c0();
          _200047c.set(0);
        }
      }

      //LAB_808c794
      r9 = 0x2000240;
      r11 = 0;

      //LAB_808c79c
      outer:
      do {
        FUN_80770c8(0x104);
        final Actor70 r10 = MEMORY.ref(4, r8 + 0x14 + _2000434.get() * 0x4).deref(4).cast(Actor70::new);
        FUN_8009140(r10);
        MEMORY.ref(4, r9 + 0x1dc).setu(r10.pos_08.getX());
        MEMORY.ref(4, r9 + 0x1e0).setu(r11);
        MEMORY.ref(4, r9 + 0x1e4).setu(r10.pos_08.getZ());
        MEMORY.ref(4, r9 + 0x1e8).setu(r10.angle_06.get());
        _200042c.set(r10.layer_22.get());

        //LAB_808c838
        while(FUN_808bc9c() != 0) {
          r1 = r8 + 0x170;
          r5 = MEMORY.ref(2, r8 + 0x170).get();
          if(r5 != 0) {
            //LAB_808c6e4
            r7 = r5;
            MEMORY.ref(2, r8 + 0x170).setu(0);
            break outer;
          }

          //LAB_808c848
          if(MEMORY.ref(2, r8 + 0x182).get() != 0) {
            //LAB_808c858
            MEMORY.ref(2, r8 + 0xcb6).setu(0x1);

            r0 = MEMORY.ref(2, r8 + 0x182).get();
            if(r0 != -1) {
              //LAB_808c9d4
              if(r0 == -0x378) {
                FUN_8091660();
                FUN_809c138(0x1b);
                //LAB_808c9e6
              } else if(r0 == -0x379) {
                FUN_8091660();
                FUN_809c3a4();
              } else {
                //LAB_808c9f6
                FUN_808d7d8(r0);
              }
            } else {
              //LAB_808c86e
              FUN_8091660();
              FUN_808c44c();

              //LAB_808c894
              for(r6 = 0; r6 < MEMORY.ref(2, r8 + 0x184).get(); r6++) {
                FUN_8009080(r10, 0x16);
                FUN_8015120(MEMORY.ref(2, r8 + 0x188 + r6 * 0x2).get(), 0x1);
                FUN_8015040(0x91a, 0x1);
              }

              //LAB_808c8c0
              if(MEMORY.ref(2, r8 + 0x186).get() != 0) {
                //LAB_808c9c0
                FUN_808c4c0();
              } else {
                //LAB_808c8d0
                if(_2000434.get() != 0) {
                  //LAB_808c900
                  FUN_8009080(r10, 0x13);
                } else if(FUN_80770c0(0x20) != 0) {
                  FUN_8009080(r10, 0x15);
                } else {
                  //LAB_808c8ec
                  FUN_8009080(r10, 0x25);
                }

                //LAB_808c908
                FUN_80f9010(0x3b);
                FUN_8015040(0x91b, 0x1);
                r6 = FUN_8077008(_2000434.get());
                MEMORY.ref(2, r6 + 0x38).setu(0x1);
                r5 = MathHelper.clamp(divideS(0x4000, MEMORY.ref(2, r6 + 0x34).get()), 0, 0x4000);

                //LAB_808c950
                MEMORY.ref(2, r6 + 0x14).setu(r5);
                if(r5 == 0 && MEMORY.ref(2, r6 + 0x38).get() != 0) {
                  MEMORY.ref(2, r6 + 0x14).setu(0x1);
                }

                //LAB_808c964
                r3 = MathHelper.clamp(divideS(MEMORY.ref(2, r6 + 0x3a).get() << 14, MEMORY.ref(2, r6 + 0x36).get()), 0, 0x4000);

                //LAB_808c988
                MEMORY.ref(2, r6 + 0x16).setu(r3);
                if(r3 == 0 && MEMORY.ref(2, r6 + 0x3a).get() != 0) {
                  MEMORY.ref(2, r6 + 0x16).setu(0x1);
                }

                //LAB_808c99c
                MEMORY.ref(2, r9 + 0x1c0).setu(MEMORY.ref(2, r9 + 0x1c4).getUnsigned());
                _2000402.set(MEMORY.ref(2, r9 + 0x1c6).getUnsigned());
                FUN_808c4c0();
                r7 = 999;
                break outer;
              }
            }

            //LAB_808c9fa
            MEMORY.ref(2, r8 + 0xcb6).setu(r11);
            MEMORY.ref(2, r8 + 0x182).setu(r11);
            //LAB_808ca0e
          } else if(MEMORY.ref(2, r8 + 0x17c).get() != 0) {
            FUN_8091660();
            FUN_808ba38();
            MEMORY.ref(2, r9 + 0x21e).setu(0xffff);
            MEMORY.ref(2, r9 + 0x1c0).setu(0x1fe);
            _2000402.set(MEMORY.ref(2, r8 + 0x17c).getUnsigned());
            MEMORY.ref(2, r1).setu(999);
            FUN_80941e0(MEMORY.ref(2, r8 + 0x17c).get());
            MEMORY.ref(4, r8 + 0x1a8).setu(0);
            MEMORY.ref(2, r8 + 0x17c).setu(0);
            _2000478.set(0);
            //LAB_808ca5e
          } else if(MEMORY.ref(2, r8 + 0x16c).get() != 0) {
            MEMORY.ref(2, r8 + 0xcb6).setu(0x1);
            FUN_808d828(MEMORY.ref(2, r8 + 0x16c).get());
            MEMORY.ref(2, r8 + 0xcb6).setu(0);
            MEMORY.ref(2, r8 + 0x16c).setu(0);
            //LAB_808ca86
          } else if(MEMORY.ref(2, r8 + 0x16e).get() != 0) {
            FUN_808d8f0(MEMORY.ref(2, r8 + 0x16e).get());
            MEMORY.ref(2, r8 + 0x16e).setu(0);
            //LAB_808cac4
          } else if(MEMORY.ref(2, r8 + 0x174).get() != 0) {
            FUN_8015208();
            r5 = FUN_808ddec(_2000434.get());
            r6 = 0;
            if(r5 != -1) {
              r0 = FUN_808d5a4(r5);
              if(r0 != 0) {
                r0 = 0x1;
              }

              //LAB_808caf4
              r6 = r0;
            }

            //LAB_808caf6
            if(r6 != 0) {
              MEMORY.ref(2, r8 + 0x178).setu(r5 | 0x1000);
              MEMORY.ref(2, r8 + 0x172).setu(r11);
            } else {
              //LAB_808cb1c
              r6 = FUN_808ce74();
              if(r6 != 0) {
                MEMORY.ref(2, r8 + 0x17a).setu(r6);
                MEMORY.ref(2, r8 + 0x172).setu(r11);
              } else {
                //LAB_808cb3a
                MEMORY.ref(2, r8 + 0x172).setu(0x1);
              }
            }

            //LAB_808cb44
            MEMORY.ref(2, r8 + 0x174).setu(r11);
            //LAB_808cb4c
          } else if(MEMORY.ref(2, r8 + 0x172).get() != 0) {
            FUN_8015208();
            FUN_8091660();
            FUN_80f9010(0x6f);
            FUN_808c44c();
            FUN_80770c8(0x106);

            if(debug_3001f54.get() == 0 || (heldButtonsLastFrame_3001ae8.get() & 0x2) == 0 || (heldButtonsLastFrame_3001ae8.get() & 0x4) == 0) {
              //LAB_808cb98
              if(FUN_80770c0(0x107) != 0) {
                MEMORY.ref(2, r8 + 0x182).setu(0xfa);
              } else {
                //LAB_808cbae
                MEMORY.ref(2, r8 + 0xcc0).setu(0);
                FUN_80151e8();
                MEMORY.ref(2, r8 + 0xcc0).setu(0x1);
              }
            } else {
              FUN_8015290();
            }

            //LAB_808cbbe
            FUN_808c4c0();
            FUN_80770d0(0x106);
            FUN_80772f0();
            MEMORY.ref(2, r8 + 0x172).setu(r11);
            //LAB_808cbe4
          } else if(MEMORY.ref(2, r8 + 0x178).get() != 0) {
            FUN_808c44c();
            FUN_808d5dc(MEMORY.ref(2, r8 + 0x178).getUnsigned() & 0xfff);
            FUN_808c4c0();
            MEMORY.ref(2, r8 + 0x178).setu(0);
            //LAB_808cc02
          } else if(MEMORY.ref(2, r8 + 0x17a).get() != 0) {
            FUN_808c44c();
            FUN_808d9a4(MEMORY.ref(2, r8 + 0x17a).get());
            FUN_808c4c0();
            MEMORY.ref(2, r8 + 0x17a).setu(0);
            //LAB_808cc24
          } else if(MEMORY.ref(2, r8 + 0x17e).get() != 0) {
            FUN_8015208();
            FUN_808c44c();
            FUN_808e680(MEMORY.ref(2, r8 + 0x17e).get());
            FUN_808c4c0();
            MEMORY.ref(2, r8 + 0x17e).setu(0);
            //LAB_808cc4a
          } else if(MEMORY.ref(2, r8 + 0x180).get() != 0) {
            FUN_808c44c();
            FUN_808e23c(MEMORY.ref(2, r8 + 0x180).get(), MEMORY.ref(2, r8 + 0x19a).get());
            FUN_808c4c0();
            MEMORY.ref(2, r8 + 0x180).setu(0);
            //LAB_808cc76
          } else if(MEMORY.ref(2, r8 + 0x176).get() != 0) {
            FUN_80f9010(0x6f);
            FUN_8091660();
            FUN_808c44c();
            FUN_80770c8(0x106);

            if(debug_3001f54.get() != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x2) != 0) {
              FUN_8015288();
              //LAB_808ccb4
            } else if(debug_3001f54.get() != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x200) != 0) {
              FUN_808d0c8();
              //LAB_808ccce
            } else if(FUN_80770c0(0x107) != 0) {
              MEMORY.ref(2, r8 + 0x182).setu(0xfa);
            } else {
              //LAB_808cce4
              FUN_808e118();
              FUN_8015208();
              MEMORY.ref(2, r9 + 0x21e).setu(FUN_80f9070());
              if(FUN_80770c0(0x17e) == 0) {
                r5 = MEMORY.ref(4, 0x3001e68).get();
                r0 = 0;

                //LAB_808cd0e
                for(r2 = 0; r2 < 0x200; r2++) {
                  if(_3001810.get(r2).get() == 0xff) {
                    r0++;
                  }

                  //LAB_808cd18
                }

                if(r0 < 0x88) {
                  MEMORY.ref(2, r5 + 0x4).setu(0x1);
                  sleep(0x1);
                }

                //LAB_808cd30
                FUN_8015370();
                MEMORY.ref(2, r5 + 0x4).setu(r11);
              } else {
                //LAB_808cd58
                FUN_8015040(0xc2f, 0x1);
              }
            }

            //LAB_808cd60
            FUN_808c4c0();
            FUN_80770d0(0x106);
            MEMORY.ref(2, r8 + 0x176).setu(r11);
          }

          //LAB_808cd76
        }

        //LAB_808cd80
        FUN_80770d0(0x104);

        final int r10_0 = MEMORY.ref(4, r8 + 0x14 + _2000434.get() * 0x4).get();
        if(r10_0 != 0) {
          r3 = _2000432.get();
          if(r3 == 2) {
            FUN_80090b8(MEMORY.ref(4, r10_0, Actor70::new)); //TODO
            //LAB_808cdb0
          } else if(r3 == 1) {
            FUN_80090b0(MEMORY.ref(4, r10_0, Actor70::new)); //TODO
            //LAB_808cdbc
          } else if(MEMORY.ref(2, r8 + 0x19e).get() == 3) {
            FUN_80090a8(MEMORY.ref(4, r10_0, Actor70::new)); //TODO
          } else {
            //LAB_808cdd2
            FUN_80090a0(MEMORY.ref(4, r10_0, Actor70::new)); //TODO
          }
        }

        //LAB_808cdd8
        //LAB_808cdda
        do {
          sleep(1);
          final int r10_1 = MEMORY.ref(4, r8 + 0x14 + _2000434.get() * 0x4).get();
          if(debug_3001f54.get() == 0 || FUN_80770c0(0x163) == 0) {
            //LAB_808cdfe
            FUN_808bec0(MEMORY.ref(1, r10_1 + 0x22).getUnsigned(), MEMORY.ref(4, r10_1 + 0x8).get(), MEMORY.ref(4, r10_1 + 0xc).get(), MEMORY.ref(4, r10_1 + 0x10).get());
          }

          //LAB_808ce12
        } while(FUN_808bc9c() == 0);
      } while(true);
    }

    //LAB_808ce1c
    if(MEMORY.ref(2, r8 + 0x1c6).getUnsigned() != 0) {
      FUN_80901c0(MEMORY.ref(4, r8 + 0x1c0).get(), MEMORY.ref(4, r8 + 0x1c8).get());
      MEMORY.ref(2, r8 + 0x1c6).setu(0);
      sleep(MEMORY.ref(4, r8 + 0x1c8).get());
    }

    //LAB_808ce46
    freeSlot(27);
    CPU.sp().value += 0x10;

    return r7;
  }

  @Method(0x808ce74)
  public static int FUN_808ce74() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808cf78)
  public static void FUN_808cf78() {
    int r0;
    int r3;
    int r5;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    CPU.r8().value = _2000402.get();
    r5 = _200800c.deref().run();
    CPU.r10().value = 0;

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
          r3 = MEMORY.ref(2, r5).get();
          if(r3 == -1) {
            break jmp_808cfc8;
          }
        } while(r3 != CPU.r8().value);

        r0 = MEMORY.ref(2, r5 + 0x2).get();
      } while(r0 != -1 && FUN_80770c0(r0) == 0);

      //LAB_808cfc4
      CPU.r10().value = 0x1;
    }

    //LAB_808cfc8
    if(CPU.r10().value == 0) {
      r5 = _200800c.deref().run();
    }

    //LAB_808cfd8
    if(FUN_80770c0(0x109) == 0) {
      _200041c.set(MEMORY.ref(2, r5 + 0x4).get() << 16);
      _2000420.set(MEMORY.ref(2, r5 + 0x6).get() << 16);
      _2000424.set(MEMORY.ref(2, r5 + 0x8).get() << 16);
      _2000428.set(MEMORY.ref(2, r5 + 0xa).getUnsigned());
      _200042c.set(0);
    }

    //LAB_808d020
    r3 = MEMORY.ref(2, r5 + 0xe).get();
    if(r3 != -1) {
      r7._ec.set(r3 << 16);
    }

    //LAB_808d03a
    r3 = MEMORY.ref(2, r5 + 0x10).get();
    if(r3 != -1) {
      r7._f0.set(r3 << 16);
    }

    //LAB_808d050
    r3 = MEMORY.ref(2, r5 + 0x12).get();
    if(r3 != -1) {
      r7._f4.set(r3 << 16);
    }

    //LAB_808d066
    r0 = MEMORY.ref(2, r5 + 0x14).get();
    if(r0 != -1) {
      r7._f8.set(r0 << 16);
    }

    //LAB_808d07c
    if(r7._ec.get() > r7._f4.get() - 0xf00000) {
      r7._ec.set(r7._f4.get() - 0xf00000);
    }

    //LAB_808d090
    if(r7._f0.get() > r7._f8.get() - 0xa00000) {
      r7._f0.set(r7._f8.get() - 0xa00000);
    }

    //LAB_808d0a4
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x808d0c8)
  public static void FUN_808d0c8() {
    throw new RuntimeException("Not implemented");
  }

  /** Opening cutscene when leaving house */
  @Method(0x808d394)
  public static int FUN_808d394(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;
    final int lr;

    r3 = MEMORY.ref(4, 0x808d424).get();
    r2 = CPU.movT(0, 0x1);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.negT(r2, r2);
    r7 = MEMORY.ref(4, r3).get();
    r4 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x8);
    CPU.r12().value = r1;
    lr = r2;

    //LAB_808d3a8
    do {
      r0 = MEMORY.ref(4, r7).get();
      r7 += 0x4;

      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r4, 0x7);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          //LAB_808d3d6
          r2 = MEMORY.ref(2, r0).getUnsigned();
          r3 = CPU.lslT(r2, 16);
          r3 = CPU.asrT(r3, 16);
          r1 = CPU.addT(r2, 0x0);
          CPU.cmpT(r3, lr);
          if(!CPU.cpsr().getZero()) { // !=
            r5 = CPU.movT(0, 0x1);
            r5 = CPU.negT(r5, r5);

            //LAB_808d3e6
            do {
              r3 = CPU.lslT(r1, 16);
              r1 = CPU.movT(0, 0xe0);
              r1 = CPU.lslT(r1, 11);
              r3 = CPU.cmpT(r3, r1);
              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                r6 = CPU.cmpT(r6, r4);
                if(CPU.cpsr().getZero()) { // ==
                  if((short)r2 == -1) {
                    r0 = 0;
                  }

                  return r0;
                }
                r6 = CPU.addT(r6, 0x1);
              }

              //LAB_808d3f6
              r0 = CPU.addT(r0, 0x18);
              r2 = MEMORY.ref(2, r0).getUnsigned();
              r3 = CPU.lslT(r2, 16);
              r3 = CPU.asrT(r3, 16);
              r1 = CPU.addT(r2, 0x0);
              r3 = CPU.cmpT(r3, r5);
            } while(!CPU.cpsr().getZero()); // !=
          }
        } else {
          r5 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r0 + r5).get();
          r2 = MEMORY.ref(2, r0).getUnsigned();
          CPU.cmpT(r3, lr);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = CPU.movT(0, 0x1);
            r1 = CPU.negT(r1, r1);

            //LAB_808d3c0
            do {
              r3 = CPU.lslT(r2, 16);
              r3 = CPU.asrT(r3, 16);
              r3 = CPU.cmpT(r3, r4);
              if(CPU.cpsr().getZero()) { // ==
                if((short)r2 == -1) {
                  r0 = 0;
                }

                return r0;
              }
              r0 = CPU.addT(r0, 0x18);
              r5 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r0 + r5).get();
              r2 = MEMORY.ref(2, r0).getUnsigned();
              r3 = CPU.cmpT(r3, r1);
            } while(!CPU.cpsr().getZero()); // !=
          }
        }
      }

      //LAB_808d404
      r2 = CPU.movT(0, 0x1);
      CPU.r12().value += r2;
      r3 = CPU.r12().value;
      CPU.cmpT(r3, 0x3);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r2 = MEMORY.ref(2, r0).getUnsigned();

    //LAB_808d410
    if((short)r2 == -1) {
      r0 = 0;
    }

    //LAB_808d41e
    return r0;
  }

  @Method(0x808d428)
  public static int FUN_808d428(int r0) {
    if(r0 == -1) {
      return 1;
    }

    //LAB_808d436
    if((r0 & 0x1000) != 0) {
      return FUN_80770c0(r0);
    }

    //LAB_808d446
    r0 = FUN_80770c0(r0);

    //LAB_808d454
    return 1 - ((-r0 | r0) >>> 31);
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

  @Method(0x808ddb8)
  public static int FUN_808ddb8(final int r0) {
    int r2;
    int r3;

    r2 = 0x809e686;
    r3 = MEMORY.ref(2, r2).get();
    r2 += 0x2;

    if(r3 == -1) {
      return 0x10;
    }

    //LAB_808ddc8
    while(r3 != r0) {
      r2 += 0x2;
      r3 = MEMORY.ref(2, r2).get();

      //LAB_808ddd2
      if(r3 == -1) {
        return 0x10;
      }
      r2 += 0x2;
    }

    //LAB_808dde0
    return MEMORY.ref(2, r2).get();
  }

  @Method(0x808ddec)
  public static int FUN_808ddec(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808df1c)
  public static int FUN_808df1c(final int r0, final int r1) {
    int sp04 = -1;
    int sp00 = FUN_808ddb8(r1);

    final Actor70 r7 = getActor(r0);
    if(r7 != null) {
      //LAB_808df4c
      final int r11 = r7.angle_06.get() + 0x2000 & 0xc000;

      //LAB_808df60
      for(int r9 = 0; r9 <= 0x42; r9++) {
        if(r9 != r0) {
          final Actor70 r6 = getActor(r9);
          if(r6 != null) {
            if((r6._59.get() & 0x8) == 0) {
              final int r0_0;
              if(r1 == 13) {
                r0_0 = 0x300000;
              } else if(r1 == 5) {
                r0_0 = 0x400000;
              } else if(r1 == 2) {
                r0_0 = 0x100000;
              } else {
                r0_0 = 0x80000;
              }

              //LAB_808dfa4
              //LAB_808dfb4
              if(Math.abs(r7.pos_08.getY() - r6.pos_08.getY()) <= r0_0) {
                //LAB_808dfba
                final int dx = (r6.pos_08.getX() - r7.pos_08.getX()) / 0x10000;
                final int dz = (r6.pos_08.getZ() - r7.pos_08.getZ()) / 0x10000;
                int r5 = (int)MEMORY.call(0x30001d8, dx * dx + dz * dz);
                if((r6._59.get() & 0x10) != 0) {
                  r5 = divideS(r5 * 2, 3);
                }

                //LAB_808e006
                if(r5 < sp00) {
                  final int angle = atan2(r6.pos_08.getZ() - r7.pos_08.getZ(), r6.pos_08.getX() - r7.pos_08.getX()) & 0xffff;

                  int r2;
                  if(r5 > 0x13) {
                    r2 = 0x1000;
                  } else {
                    r2 = 0x1800;
                  }

                  //LAB_808e02c
                  if(r1 == 2) {
                    r2 = 0x2000;
                  }

                  //LAB_808e036
                  if(r5 <= 0xb) {
                    sp04 = r9;
                    sp00 = r5;
                  } else if(Math.abs((short)(angle - r11)) < r2) {
                    //LAB_808e04c
                    sp04 = r9;
                    sp00 = r5;
                  }
                }
              }
            }
          }
        }

        //LAB_808e052
      }
    }

    //LAB_808e05c
    return sp04;
  }

  @Method(0x808e118)
  public static void FUN_808e118() {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    MEMORY.ref(2, r3 + 0xcb6).setu(0);
    if(MEMORY.ref(2, r3 + 0xcb8).get() != 0) {
      FUN_808e5d8(0x2090);
    }

    //LAB_808e138
  }

  @Method(0x808e23c)
  public static int FUN_808e23c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e4b4)
  public static int FUN_808e4b4(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0xc;

    r6 = r2;
    r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    CPU.r9().value = r0;
    r0 = _2000434.get();
    r7 = MEMORY.ref(4, r3 + 0x10).get();
    CPU.r10().value = r1;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(getActor(r0).angle_06.get());
    r0 = FUN_808df1c(_2000434.get(), CPU.r10().value);
    MEMORY.ref(4, r6).setu(r0);
    CPU.r8().value = r0;
    CPU.r11().value = 0;
    r0 = FUN_808bd24();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    if(CPU.r9().value == 0x70000005) {
      CPU.r11().value = 1;
    }

    //LAB_808e502
    r1 = MEMORY.ref(4, r7).get();
    if(r1 == -1) {
      //LAB_808e5bc
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_808e50c
      do {
        r5 = MEMORY.ref(2, r7 + 0x4).get() & 0xf000;
        r2 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
        r3 = r2 & 0x800;
        r3 = CPU.lslT(r3, 16);
        r6 = CPU.asrT(r3, 16);
        r3 = r1 & 0xf;
        r4 = r2 & 0xff;
        if(r3 == 5) {
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = FUN_808d428(MEMORY.ref(2, r7 + 0x6).get());
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            if(r6 == 0 || (r5 - MEMORY.ref(4, CPU.sp().value + 0x8).get() + 0x17ff & 0xffff) <= 0x2ffe) {
              //LAB_808e56a
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              r0 = FUN_8077080(MEMORY.ref(1, r7 + 0x1).getUnsigned());
              r3 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
              r4 = MEMORY.ref(4, CPU.sp().value).get();
              CPU.cmpT(r3, CPU.r10().value);
              if(CPU.cpsr().getZero()) { // ==
                r1 = MEMORY.ref(4, r7).get();
                r3 = CPU.r11().value;
                if(r3 != 0 || (r1 & 0x7000000f) == CPU.r9().value) {
                  //LAB_808e58e
                  r3 = CPU.movT(0, 0x80);
                  r3 = CPU.andT(r3, r1);
                  r0 = CPU.addT(r7, 0x0);
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break;
                  }
                  r3 = CPU.movT(0, 0x10);
                  r3 = CPU.andT(r3, r1);
                  CPU.cmpT(r3, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    //LAB_808e5a6
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                    r0 = CPU.addT(r7, 0x0);
                    r4 = CPU.cmpT(r4, r2);
                    if(CPU.cpsr().getZero()) { // ==
                      break;
                    }
                  } else {
                    CPU.cmpT(r4, CPU.r8().value);
                    if(CPU.cpsr().getZero()) { // ==
                      break;
                    }
                  }
                }
              }
            }
          }
        }

        //LAB_808e5ae
        r7 = CPU.addT(r7, 0xc);
        r3 = MEMORY.ref(4, r7).get();
        r2 = CPU.movT(0, 0x1);
        r2 = CPU.negT(r2, r2);
        r1 = CPU.addT(r3, 0x0);
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_808e5be
    CPU.sp().value += 0xc;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x808e5d8)
  public static int FUN_808e5d8(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x808e670).get();
    r5 = CPU.addT(r0, 0x0);
    r3 = CPU.andT(r3, r5);
    CPU.r8().value = r3;
    r0 = CPU.r8().value;
    r3 = CPU.movT(0, 0xf);
    r5 = CPU.lsrT(r5, 10);
    CPU.sp().value -= 0x4;
    r5 = CPU.andT(r5, r3);
    r0 = FUN_8077080(r0);
    r6 = MEMORY.ref(4, 0x808e674).get();
    r3 = CPU.movT(0, 0xfa);
    r3 = CPU.lslT(r3, 1);
    r0 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
    r6 = CPU.addT(r6, r3);
    CPU.r9().value = r0;
    r0 = MEMORY.ref(4, r6).get();
    final Actor70 unused = getActor(r0);
    CPU.r10().value = CPU.sp().value;
    r1 = CPU.r9().value;
    r2 = CPU.r10().value;
    r0 = MEMORY.ref(4, 0x808e678).get();
    r0 = FUN_808e4b4(r0, r1, r2);
    r2 = CPU.r10().value;
    CPU.r11().value = r0;
    r1 = CPU.r9().value;
    r0 = MEMORY.ref(4, 0x808e67c).get();
    r0 = FUN_808e4b4(r0, r1, r2);
    r1 = CPU.movT(0, 0x0);
    CPU.r10().value = r0;
    r0 = CPU.r8().value;
    FUN_8096fb0(r0, r1);
    r0 = MEMORY.ref(4, r6).get();
    r1 = MEMORY.ref(4, CPU.sp().value).get();
    FUN_80970f8(r0, r1);
    r1 = CPU.addT(r5, 0x0);
    r2 = MEMORY.ref(4, CPU.sp().value).get();
    r0 = CPU.r11().value;
    FUN_8096b28(r0, r1, r2);
    FUN_8096af0();
    FUN_8097174();
    r1 = CPU.addT(r5, 0x0);
    r2 = MEMORY.ref(4, CPU.sp().value).get();
    r0 = CPU.r10().value;
    FUN_8096b28(r0, r1, r2);
    FUN_8097194();

    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return 0;
  }

  @Method(0x808e680)
  public static int FUN_808e680(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e9a8)
  public static void FUN_808e9a8(final Actor70 r0) {
    final int ret = FUN_80091a8(0, r0.pos_08.getX(), r0.pos_08.getZ());
    r0.pos_08.setY(ret);
    r0._14.set(ret);
  }

  @Method(0x808e9c0)
  public static void FUN_808e9c0() {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;
    int r11;

    int sp00 = 0;
    r10 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._10.get();
    r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x11c;

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r8);
    DMA.channels[3].CNT.setu(0x85000014);
    CPU.sp().value += 0x4;

    if(r10 != 0) {
      //LAB_808e9fc
      r7 = MEMORY.ref(1, r10).getUnsigned();
      r10++;
      r5 = MEMORY.ref(1, r10).getUnsigned();
      r10++;

      //LAB_808ea12
      jmp_808ebe2:
      while(r7 != 0xff || r5 != 0xff) {
        r2 = MEMORY.ref(1, r10).getUnsigned();
        r10++;
        r3 = r2 - 100;
        final int sp04 = r2;
        CPU.cmpT(r3, 0x8b);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_808ea26
          r6 = (int)MEMORY.call(MEMORY.ref(4, 0x2008024).get());
          r2 = MEMORY.ref(4, r6).get();
          if(r2 != -1) {
            //LAB_808ea3c
            r11 = r7 << 20;
            r7 = r5 << 20;

            //LAB_808ea48
            do {
              jmp_808ebb8:
              if(MEMORY.ref(2, r6 + 0x4).get() == sp04) {
                //LAB_808ea54
                r3 = r2 & 0x1ff;
                if(r3 != 0x13) {
                  //LAB_808eb02
                  if(r3 == 0x3) {
                    if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) == 0x300000) {
                      if(FUN_80770c0(MEMORY.ref(2, r6 + 0x6).get()) == 0) {
                        final Actor70 r5_0 = loadActor_(28, r11 + 0x80000, 0, r7 + 0x80000);
                        if(r5_0 != null) {
                          FUN_808e9a8(r5_0);
                          FUN_80091e0(r5_0, 0);
                          FUN_8009140(r5_0);
                          FUN_8009080(r5_0, 0x1);

                          r5_0._64.set(r5_0.pos_08.getX() / 0x10000);
                          r5_0._66.set(r5_0.pos_08.getZ() / 0x10000);
                          r5_0.flags_23.set(0x1);
                          r5_0._59.set(0x1);
                          MEMORY.ref(4, r8).setu(r5_0.getAddress()); //TODO
                          MEMORY.ref(1, r8 + 0x4).setu(MEMORY.ref(2, r6 + 0x4).getUnsigned());
                          MEMORY.ref(1, r8 + 0x6).setu(r5_0.pos_08.getX() / 0x100000);
                          MEMORY.ref(1, r8 + 0x7).setu(r5_0.pos_08.getZ() / 0x100000);
                          sp00++;
                          r8 += 0x8;
                          if(sp00 > 9) {
                            break;
                          }
                          break jmp_808ebe2;
                        }
                      }
                    }
                  }
                } else {
                  final Actor70 r5_0 = loadActor_(20, r11 + 0x80000, 0, r7 + 0x80000);

                  if(r5_0 != null) {
                    //LAB_808ea74
                    FUN_808e9a8(r5_0);
                    FUN_80091e0(r5_0, 0);

                    if(FUN_80770c0(MEMORY.ref(2, r6 + 0x6).get()) != 0) {
                      if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) == 0x500000) {
                        FUN_80090d0(r5_0);
                        break jmp_808ebb8;
                      }

                      //LAB_808eaa2
                      FUN_8009080(r5_0, 0x2);
                    }

                    //LAB_808eaaa
                    FUN_8009140(r5_0);

                    r5_0._64.set(r5_0.pos_08.getX() / 0x10000);
                    r5_0._66.set(r5_0.pos_08.getZ() / 0x10000);
                    r5_0.flags_23.set(0x1);
                    r5_0._59.set(0x1);
                    MEMORY.ref(1, r8 + 0x4).setu(MEMORY.ref(2, r6 + 0x4).getUnsigned());
                    MEMORY.ref(4, r8).setu(r5_0.getAddress()); //TODO
                    MEMORY.ref(1, r8 + 0x6).setu(r5_0.pos_08.getX() / 0x100000);
                    MEMORY.ref(1, r8 + 0x7).setu(r5_0.pos_08.getZ() / 0x100000);
                    sp00++;
                    r8 += 0x8;
                    if(sp00 > 9) {
                      break;
                    }
                    break jmp_808ebe2;
                  }
                }
              }

              //LAB_808ebb8
              r6 += 0xc;
              r2 = MEMORY.ref(4, r6 + 0xc).get();
              if(r2 == -1) {
                break;
              }
            } while(true);
          }
        }

        //LAB_808ebc8
        r7 = MEMORY.ref(1, r10).getUnsigned();
        r10++;
        r5 = MEMORY.ref(1, r10).getUnsigned();
        r10++;
      }
    }

    //LAB_808ebe2
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

    /*             Don't refactor this code yet since it isn't fully implemented             */

    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r6 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new).getAddress(); //TODO
    r3 = boardWramMallocHead_3001e50.offset(31 * 0x4).get();
    CPU.sp().value -= 0x18;
    r0 = 0x53c;
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
          clearTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"));
          clearTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"));
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
        r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = MEMORY.ref(4, 0x808f90c).get();
        r3 = CPU.addT(r2, r5);
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r3 = CPU.movT(0, 0x1f);
        r3 = CPU.andT(r3, r5);
        r2 = CPU.lslT(r3, 3);
        r2 = CPU.subT(r2, r3);
        r3 = MEMORY.ref(4, 0x808f910).get();
        r2 = CPU.lslT(r2, 2);
        r2 = CPU.addT(r2, r3);
        r3 = CPU.movT(0, 0x20);
        r3 = CPU.andT(r3, r5);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(2, r2).getUnsigned();
          MEMORY.ref(2, r4).setu(r3);
          r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
        } else {
          //LAB_808f83e
          r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
          MEMORY.ref(2, r4).setu(r3);
          r3 = MEMORY.ref(2, r2).getUnsigned();
        }

        //LAB_808f844
        r4 = CPU.addT(r4, 0x2);
        MEMORY.ref(2, r4).setu(r3);
        r4 = CPU.addT(r4, 0x2);
        r7 = CPU.movT(0, 0x0);
        r2 = CPU.addT(r2, 0x4);
        CPU.r8().value = r7;
        CPU.r10().value = r2;

        //LAB_808f852
        do {
          r2 = CPU.r10().value;
          r7 = MEMORY.ref(2, r2).getUnsigned();
          r0 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
          CPU.cmpT(r7, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = CPU.movT(0, 0x0);
              CPU.r9().value = r1;
              CPU.cmpT(CPU.r9().value, r7);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                //LAB_808f868
                do {
                  r2 = CPU.movT(0, 0x1);
                  CPU.r9().value += r2;
                  MEMORY.ref(2, r4).setu(r0);
                  r4 = CPU.addT(r4, 0x4);
                  CPU.cmpT(CPU.r9().value, r7);
                } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
              }
            } else {
              //LAB_808f876
              r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
              r6 = MEMORY.ref(1, r2 + 0x6).getUnsigned();
              CPU.r11().value = r3;
              r0 = MEMORY.ref(1, r2 + 0x7).getUnsigned();
              r3 = MEMORY.ref(1, r2 + 0x5).getUnsigned();
              CPU.cmpT(r7, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = CPU.r11().value;
                r5 = CPU.subT(r3, r5);
                r0 = CPU.subT(r0, r6);
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                r2 = CPU.movT(0, 0x0);
                r3 = CPU.movT(0, 0x0);
                CPU.r9().value = r7;

                //LAB_808f894
                do {
                  r0 = CPU.addT(r3, 0x0);
                  r1 = CPU.addT(r7, 0x0);
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                  MEMORY.ref(4, CPU.sp().value).setu(r4);
                  r0 = divideS(r0, r1);
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                  r5 = CPU.addT(r0, 0x0);
                  r1 = CPU.addT(r7, 0x0);
                  r0 = CPU.addT(r2, 0x0);
                  r0 = divideS(r0, r1);
                  r5 += CPU.r11().value;
                  r0 = CPU.addT(r6, r0);
                  r4 = MEMORY.ref(4, CPU.sp().value).get();
                  r5 = CPU.lslT(r5, 8);
                  r5 = CPU.addT(r5, r0);
                  MEMORY.ref(2, r4).setu(r5);
                  r5 = CPU.movT(0, 0x1);
                  r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                  r5 = CPU.negT(r5, r5);
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                  CPU.r9().value += r5;
                  r2 = CPU.addT(r2, r0);
                  r0 = CPU.r9().value;
                  r4 = CPU.addT(r4, 0x4);
                  r3 = CPU.addT(r3, r1);
                  CPU.cmpT(r0, 0x0);
                } while(!CPU.cpsr().getZero()); // !=
              }
            }
          }

          //LAB_808f8d4
          r2 = CPU.movT(0, 0x1);
          CPU.r8().value += r2;
          r1 = CPU.movT(0, 0x8);
          r3 = CPU.r8().value;
          CPU.r10().value += r1;
          CPU.cmpT(r3, 0x2);
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
        return;

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
        final Actor70 r0_0 = getActor(r0);
        r3 = r0_0.pos_08.getX();
        r3 = CPU.subT(r3, r5);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = MEMORY.ref(4, 0x808fd8c).get();
          r3 = CPU.addT(r3, r1);
        }

        //LAB_808fc5e
        r2 = r0_0.pos_08.getY();
        r7 = CPU.asrT(r3, 16);
        r3 = r0_0.pos_08.getZ();
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
    final int r4 = mallocSlotBoard(31, 0x540);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000150);
    CPU.sp().value += 0x4;

    return r4;
  }

  @Method(0x808fefc)
  public static void FUN_808fefc(final int r0, final int r1) {
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int r6 = r0 & 0xff;

    //LAB_808ff1c
    switch(r0 >> 8 & 0xff) {
      case 0: {
        fadeOutBrightness(0);
        fadeInBrightness(r1);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(_2002090.count_00.get() < 0x20) {
          final GraphicsStruct0c r2_0 = _2002090._04.get(_2002090.count_00.get());
          r2_0._00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0._04.set(GPU.DISPCNT.getAddress());
          r2_0._08.set(0x20000);
          _2002090.count_00.incr();
        }

        //LAB_809019a
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        break;
      }

      case 1: {
        FUN_8091220(0x8000, MEMORY.ref(2, 0x5000000).getUnsigned());
        FUN_8091254(r1);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(_2002090.count_00.get() < 0x20) {
          final GraphicsStruct0c r2_0 = _2002090._04.get(_2002090.count_00.get());
          r2_0._00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0._04.set(GPU.DISPCNT.getAddress());
          r2_0._08.set(0x20000);
          _2002090.count_00.incr();
        }

        //LAB_808ff98
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        FUN_8091240(0);
        break;
      }

      case 2: {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(_2002090.count_00.get() < 0x20) {
          final GraphicsStruct0c r2_0 = _2002090._04.get(_2002090.count_00.get());
          r2_0._00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0._04.set(GPU.DISPCNT.getAddress());
          r2_0._08.set(0x20000);
          _2002090.count_00.incr();
        }

        //LAB_8090018
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(1, r5 + 0x53a).setu(0);
        MEMORY.ref(1, r5 + 0x53b).setu(0x20);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
        break;
      }

      case 3: {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);

        FUN_80907b0(0xf);
        sleep(0x1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090658"), 0xc80);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(_2002090.count_00.get() < 0x20) {
          final GraphicsStruct0c r2_0 = _2002090._04.get(_2002090.count_00.get());
          r2_0._00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0._04.set(GPU.DISPCNT.getAddress());
          r2_0._08.set(0x20000);
          _2002090.count_00.incr();
        }

        //LAB_809009e
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(1, r5 + 0x53a).setu(0);
        MEMORY.ref(1, r5 + 0x53b).setu(0x20);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
        break;
      }

      case 4:
        final int r5 = FUN_808fecc();
        r7._100.get(0).set(0x50);
        r7._100.get(0).set(0);
        r7._100.get(0).set(0x50);
        r7._103.set(0);
        sleep(0x1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_%x".formatted(r6 == 0 ? 0x80903bc : 0x8090488)), 0xc80);
        setInterruptHandler(0x1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
        MEMORY.ref(1, r5 + 0x53a).setu(0x50);
        MEMORY.ref(1, r5 + 0x53b).setu(0);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);

        // fall through

      default: {
        //LAB_8090168
        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(_2002090.count_00.get() < 0x20) {
          final GraphicsStruct0c r2_0 = _2002090._04.get(_2002090.count_00.get());
          r2_0._00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0._04.set(GPU.DISPCNT.getAddress());
          r2_0._08.set(0x20000);
          _2002090.count_00.incr();
        }

        //LAB_809019a
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        break;
      }
    }

    //LAB_809019c
  }
}
