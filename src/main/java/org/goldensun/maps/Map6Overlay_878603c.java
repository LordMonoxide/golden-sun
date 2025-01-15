package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.MathHelper;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Structccc;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.MEMORY;

public final class Map6Overlay_878603c {
  private Map6Overlay_878603c() { }

  @Method(0x2008030)
  public static int FUN_2008030(final Actor70 r0) {
    final Actor70 r1 = r0.parent_68.derefNullable();
    if(r1 != null) {
      r0._5a.and(~0x1);

      final int angle = (short)((atan2(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX()) & 0xffff) - (r0.angle_06.get() & 0xffff));
      if(angle != 0) {
        //LAB_200806e
        //LAB_2008076
        r0.angle_06.add(MathHelper.clamp(angle, -0x1000, 0x1000));
      }
    }

    //LAB_200807a
    return 1;
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008088)
  public static int getRooms() {
    return 0x2009cf4;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008090)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008094)
  public static int getTransitions() {
    return 0x2009db4;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x200809c)
  public static int getActors() {
    return 0x2009ddc;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x20080a4)
  public static int getEvents() {
    final int r0;
    if(readFlag(0x87a) != 0) {
      r0 = 0x200a028;
      //LAB_20080b4
    } else if(readFlag(0x834) != 0) {
      r0 = 0x2009fb0;
    } else {
      //LAB_20080c2
      r0 = 0x2009efc;
    }

    return r0;
  }

  /**
   * Event list 0x2009efc handler 1
   */
  @Method(value = 0x20080dc, ignoreExtraParams = true)
  public static void FUN_20080dc() {
    FUN_2009a84();

    if(readFlag(0x815) != 0) {
      FUN_2009b2c(0x11c4);
      FUN_2009b3c(12, 0);
    } else {
      //LAB_20080fc
      FUN_2009b2c(0xf76);
      FUN_2009b14(12, 0, 10);
      FUN_2009b0c(12, 2);
      FUN_2009a7c(6);
      FUN_2009b34(12);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xf77);
      } else {
        //LAB_2008138
        FUN_2009b2c(0xf78);
      }

      //LAB_200813e
      FUN_2009b04(12, 3);
      FUN_2009b3c(12, 0);
      FUN_2009b54(12, 0xc000, 10);
    }

    //LAB_200815a
    FUN_2009a8c();
  }

  /**
   * Event list 0x2009efc handler 0
   */
  @Method(value = 0x2008170, ignoreExtraParams = true)
  public static void FUN_2008170() {
    if(readFlag(0x801) == 0) {
      //LAB_200817e
      FUN_2009a84();
      setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
      FUN_2009b2c(0xfa6);
      FUN_2009b0c(13, 1);
      FUN_2009ad4(0, 232, 264);
      setActorAnimationIfLoaded(0, 0);
      FUN_2009b1c(0, 13, 20);
      FUN_2009b0c(13, 2);
      FUN_2009b44(13, 0, 10);
      final Actor70 r0 = getMapActor(0);
      final int r5 = r0.pos_08.getX() & ~0xffff;
      final int r6 = r0.pos_08.getZ() & ~0xffff;
      FUN_2009ae4(5, r5, r6);
      FUN_2009ae4(1, r5, r6);
      setActorVelocityScalerAndAcceleration(5, 0x8000, 0x4000);
      setActorVelocityScalerAndAcceleration(1, 0x8000, 0x4000);
      FUN_2009acc(5, 248, 264);
      FUN_2009ad4(1, 216, 264);
      setActorAnimationIfLoaded(0, 1);
      setActorAnimationIfLoaded(5, 1);
      setActorAnimationIfLoaded(1, 1);
      FUN_2009a7c(4);
      FUN_2009b54(5, 0xb000, 0);
      FUN_2009b54(1, 0xd000, 20);
      setActorAnimationAndWaitUntilFinished(5, 4);
      FUN_2009a7c(10);
      FUN_2009b44(5, 0, 20);
      FUN_2009b0c(13, 1);
      FUN_2009a7c(10);
      FUN_2009b54(13, 0x3000, 10);
      FUN_2009b44(13, 0, 10);
      FUN_2009b54(1, 0x3000, 40);
      FUN_2009b0c(1, 2);
      FUN_2009b44(1, 0, 10);
      FUN_2009b0c(13, 2);
      FUN_2009b54(13, 0x5000, 10);
      setActorAnimationIfLoaded(13, 3);
      FUN_2009b44(13, 0, 8);
      FUN_2009b54(5, 0x3000, 20);
      FUN_2009b44(5, 0, 10);
      FUN_2009b54(13, 0x3000, 10);
      setActorAnimationAndWaitUntilFinished(13, 3);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 6);
      FUN_2009b5c(0, 0x101, 0);
      FUN_2009b5c(1, 0x101, 0);
      FUN_2009b5c(5, 0x101, 60);
      FUN_2009b54(1, 0xd000, 0);
      FUN_2009b54(5, 0xb000, 20);
      FUN_2009b0c(5, 2);
      FUN_2009b44(5, 0, 10);
      FUN_2009b5c(13, 0x102, 60);
      setActorAnimationAndWaitUntilFinished(13, 4);
      FUN_2009b44(13, 0, 10);
      FUN_2009b54(1, 0, 0);
      FUN_2009b54(5, 0x8000, 20);
      FUN_2009b5c(0, 0x100, 60);
      FUN_2009b54(1, 0xd000, 0);
      FUN_2009b54(5, 0xb000, 0);
      FUN_2009b54(13, 0x5000, 20);
      FUN_2009b54(13, 0x3000, 40);
      FUN_2009b54(13, 0x5000, 40);
      FUN_2009b54(13, 0x3000, 20);
      FUN_2009b34(13);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xfb0);
      } else {
        //LAB_2008414
        FUN_2009b2c(0xfb1);
      }

      //LAB_200841a
      FUN_2009a7c(20);
      setActorAnimationAndWaitUntilFinished(13, 3);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 10);
      FUN_2009b2c(0xfb2);
      FUN_2009b0c(5, 2);
      FUN_2009b54(5, 0x8000, 10);
      FUN_2009b44(5, 0, 6);
      FUN_2009b5c(1, 0x103, 30);
      FUN_2009afc(1, 4, 30);
      FUN_2009b54(1, 0, 10);
      FUN_2009b44(1, 0, 6);
      FUN_2009b1c(0, 1, 10);
      FUN_2009b1c(0, 5, 0);
      FUN_2009b14(13, 1, 10);
      FUN_2009b14(13, 5, 10);
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationIfLoaded(1, 3);
      setActorAnimationAndWaitUntilFinished(5, 3);
      FUN_2009a7c(10);
      setActorAnimationIfLoaded(5, 1);
      setActorAnimationIfLoaded(1, 1);
      setActorAnimationIfLoaded(0, 0);
      FUN_2009b54(0, 0x4000, 0);
      FUN_2009b54(1, 0x4000, 0);
      FUN_2009b54(5, 0x4000, 16);
      FUN_2009b64(13, 0x102);
      FUN_2009b0c(13, 3);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 6);
      FUN_2009b5c(0, 0x100, 0);
      FUN_2009b5c(1, 0x100, 0);
      FUN_2009b5c(5, 0x100, 40);
      setActorAnimationAndWaitUntilFinished(13, 4);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 6);
      FUN_2009b0c(13, 1);
      FUN_2009b44(13, 0, 6);
      FUN_2009b54(5, 0xb000, 10);
      FUN_2009b44(5, 0, 6);
      FUN_2009b54(13, 0x3000, 10);
      setActorAnimationAndWaitUntilFinished(13, 3);
      FUN_2009a7c(6);
      FUN_2009b44(13, 0, 10);
      FUN_2009afc(0, 2, 0);
      FUN_2009afc(1, 2, 0);
      FUN_2009afc(5, 2, 10);
      FUN_2009b54(0, 0xc000, 0);
      FUN_2009b54(1, 0xd000, 20);
      FUN_2009b44(1, 0, 6);
      FUN_2009b54(13, 0x5000, 10);
      setActorAnimationAndWaitUntilFinished(13, 3);
      FUN_2009a7c(16);
      FUN_2009b1c(0, 5, 40);
      FUN_2009b44(5, 0, 10);
      FUN_2009b0c(13, 2);
      FUN_2009b54(13, 0x3000, 10);
      FUN_2009b44(13, 0, 6);
      FUN_2009b54(0, 0xc000, 0);
      FUN_2009b54(5, 0xb000, 30);
      FUN_2009b5c(0, 0x105, 0);
      FUN_2009b5c(1, 0x105, 0);
      FUN_2009b5c(5, 0x105, 80);
      setActorAnimationAndWaitUntilFinished(13, 4);
      FUN_2009b34(13);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xfbd);
      } else {
        //LAB_2008696
        FUN_2009b2c(0xfbe);
      }

      //LAB_200869c
      FUN_2009b44(13, 0, 20);
      FUN_2009b2c(0xfbf);
      FUN_2009b54(1, 0, 10);
      FUN_2009b0c(1, 2);
      FUN_2009b34(1);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xfc0);
      } else {
        //LAB_20086dc
        FUN_2009b2c(0xfc1);
      }

      //LAB_20086e2
      FUN_2009b44(1, 0, 6);
      FUN_2009b2c(0xfc2);
      FUN_2009b54(5, 0x8000, 10);
      FUN_2009b0c(5, 1);
      FUN_2009b34(5);
      FUN_2009a7c(4);

      if(FUN_2009a94(0, 0) == 1) {
        FUN_2009afc(5, 2, 20);
        FUN_2009b44(5, 0, 10);
      } else {
        //LAB_2008758
        setActorAnimationIfLoaded(0, 3);
        setActorAnimationIfLoaded(1, 3);
        setActorAnimationAndWaitUntilFinished(5, 3);
        FUN_2009a7c(8);
        setActorAnimationIfLoaded(0, 0);
        boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
      }

      //LAB_200878e
      setActorAnimationAndWaitUntilFinished(13, 3);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 10);
      FUN_2009b54(0, 0xc000, 0);
      FUN_2009b54(1, 0xd000, 0);
      FUN_2009b54(5, 0xb000, 10);
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationIfLoaded(1, 3);
      setActorAnimationAndWaitUntilFinished(5, 3);
      FUN_2009a7c(10);
      setActorAnimationIfLoaded(0, 0);
      FUN_2009a7c(20);
      FUN_2009b0c(13, 2);
      FUN_2009b34(13);
      FUN_2009a7c(4);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xfc6);
      } else {
        //LAB_2008820
        FUN_2009b2c(0xfc9);
      }

      //LAB_2008826
      FUN_2009a7c(10);
      FUN_2009b0c(1, 2);
      FUN_2009b54(1, 0, 10);
      FUN_2009b44(1, 0, 6);
      FUN_2009b54(5, 0x8000, 10);
      setActorAnimationAndWaitUntilFinished(5, 4);
      FUN_2009b44(5, 0, 6);
      FUN_2009b0c(1, 2);
      FUN_2009b54(1, 0x8000, 10);
      FUN_2009b5c(1, 0x103, 30);
      FUN_2009b44(1, 0, 10);
      FUN_2009b5c(13, 0x100, 40);
      FUN_2009afc(13, 4, 40);
      FUN_2009b54(0, 0xc000, 0);
      FUN_2009b54(1, 0xc000, 0);
      FUN_2009b54(5, 0xb000, 20);
      FUN_2009b54(13, 0xb000, 10);
      playSound(158);
      FUN_2009a54(0x200a0ac, 43, 8);
      setActorVelocityScalerAndAcceleration(13, 0x10000, 0x8000);
      FUN_2009ad4(13, 232, 218);
      FUN_2009ae4(13, 0, 0);
      FUN_2009b5c(0, 0x101, 0);
      FUN_2009b5c(1, 0x101, 0);
      FUN_2009b5c(5, 0x101, 60);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
      FUN_2009bbc();
      FUN_2009bc4();
      FUN_2009b8c(13);
      FUN_2009a8c();
    }
  }

  @Method(0x2008964)
  public static void FUN_2008964() {
    FUN_2009a84();
    FUN_2009ae4(13, 0, 0);
    FUN_2009ae4(1, 0xd80000, 0x1080000);
    FUN_2009ae4(5, 0xf80000, 0x1080000);
    getMapActor(1).angle_06.set(0xc000);
    getMapActor(5).angle_06.set(0xc000);
    FUN_2009a54(0x200a0ac, 43, 8);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
    FUN_2009bb4();
    FUN_2009bc4();
    FUN_2009a7c(40);
    setActorVelocityScalerAndAcceleration(13, 0xcccc, 0x6666);
    FUN_2009ae4(13, 0xe60000, 0xdc0000);
    FUN_2009ad4(13, 230, 232);
    FUN_2009a7c(20);
    setActorAnimationAndWaitUntilFinished(13, 3);
    FUN_2009b2c(0xfcc);
    FUN_2009b44(13, 0, 10);
    FUN_2009b0c(13, 2);
    FUN_2009b54(13, 0x3000, 10);
    FUN_2009b44(13, 0, 10);
    FUN_2009b54(1, 0, 0);
    FUN_2009b54(0, 0x8000, 10);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 3);
    setActorAnimationIfLoaded(0, 0);
    FUN_2009a7c(20);
    FUN_2009b54(0, 0, 0);
    FUN_2009b54(5, 0x8000, 10);
    setActorAnimationIfLoaded(5, 3);
    setActorAnimationAndWaitUntilFinished(0, 3);
    setActorAnimationIfLoaded(0, 0);
    setActorVelocityScalerAndAcceleration(1, 0xcccc, 0x6666);
    setActorVelocityScalerAndAcceleration(5, 0xcccc, 0x6666);
    FUN_2009b54(0, 0xc000, 0);
    setActorAnimationIfLoaded(1, 2);

    Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_2009ac4(1, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_2008ac8
    setActorAnimationIfLoaded(5, 2);

    r0 = getMapActor(0);
    if(r0 != null) {
      FUN_2009ac4(5, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_2008ae8
    setActorAnimationIfLoaded(13, 2);

    r0 = getMapActor(0);
    if(r0 != null) {
      FUN_2009ac4(13, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_2008b08
    FUN_2009adc(1);
    FUN_2009ae4(1, 0, 0);
    FUN_2009ae4(5, 0, 0);
    FUN_2009adc(13);
    FUN_2009ae4(13, 0, 0);
    setActorAnimationIfLoaded(1, 1);
    setActorAnimationIfLoaded(5, 1);
    setActorAnimationIfLoaded(13, 1);
    FUN_2009ae4(14, 0, 0);
    FUN_2009ae4(15, 0, 0);
    setFlag(0x801);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x100);
    FUN_2009bac(0x10000, 0);
    setFlag(0x242);
    FUN_2009a8c();
  }

  /**
   * Event list 0x200a028 handler 2
   */
  @Method(value = 0x2008ba8, ignoreExtraParams = true)
  public static void FUN_2008ba8() {
    if(readFlag(0x242) == 0) {
      playSound(0x9e);
      FUN_2009a54(0x200a0ac, 43, 8);
    }

    //LAB_2008bc4
    FUN_2009acc(0, 229, 217);
    FUN_2009b8c(3);
  }

  /**
   * Event list 0x2009efc handler 11
   */
  @Method(value = 0x2008be0, ignoreExtraParams = true)
  public static void FUN_2008be0() {
    if(readFlag(0x808) == 0) {
      //LAB_2008bee
      FUN_2009a84();
      playSound(0x11);
      setFlag(0x808);
      FUN_2009b2c(0xf85);
      FUN_2009b44(14, 0, 10);
      setActorVelocityScalerAndAcceleration(0, 0x13333, 0x9999);
      FUN_2009b5c(0, 0x100, 30);
      FUN_2009ad4(0, 392, 328);
      FUN_2009b54(0, 0x4000, 10);
      Actor70 r0 = getMapActor(0);
      final int r5 = r0.pos_08.getX() & ~0xffff;
      final int r6 = r0.pos_08.getZ() & ~0xffff;
      FUN_2009ae4(5, r5, r6);
      FUN_2009ae4(1, r5, r6);
      setActorVelocityScalerAndAcceleration(5, 0x13333, 0x9999);
      setActorVelocityScalerAndAcceleration(1, 0x13333, 0x9999);
      FUN_2009acc(5, 376, 328);
      FUN_2009ad4(1, 408, 328);
      setActorAnimationIfLoaded(0, 0);
      setActorAnimationIfLoaded(5, 0);
      setActorAnimationIfLoaded(1, 0);
      FUN_2009b54(1, 0x8000, 0);
      FUN_2009b54(5, 0, 20);
      FUN_2009b5c(0, 0x101, 0);
      FUN_2009b5c(1, 0x101, 0);
      FUN_2009b5c(5, 0x101, 30);
      FUN_2009b54(0, 0x4000, 0);
      FUN_2009b54(1, 0x4000, 0);
      FUN_2009b54(5, 0x4000, 0);
      FUN_2009b74(0x60000, 0xc000);
      FUN_2009b7c(0xd70000, -1, 0x1590000, 1);
      FUN_2009b84();
      FUN_2009a7c(20);
      playSound(0x3d);
      setActorAnimationAndWaitUntilFinished(14, 4);
      setActorAnimationIfLoaded(14, 4);
      FUN_2009b44(14, 0, 20);
      FUN_2009b54(15, 0, 10);
      FUN_2009b44(15, 0, 10);
      setActorAnimationAndWaitUntilFinished(14, 3);
      FUN_2009b44(14, 0, 10);
      FUN_2009b54(15, 0x4000, 60);
      FUN_2009b0c(15, 1);
      FUN_2009b44(15, 0, 20);
      setActorAnimationAndWaitUntilFinished(14, 3);
      FUN_2009b44(14, 0, 10);
      setActorAnimationAndWaitUntilFinished(15, 4);
      FUN_2009b44(15, 0, 6);
      FUN_2009b5c(14, 0x100, 0);
      FUN_2009b0c(14, 2);
      FUN_2009a7c(20);
      FUN_2009b54(15, 0, 10);
      FUN_2009b5c(15, 0x101, 40);
      FUN_2009b54(14, 0, 60);
      FUN_2009b54(14, 0x8000, 40);
      FUN_2009b54(14, 0, 40);
      FUN_2009ad4(14, 0xe8, 360);
      FUN_2009b54(14, 0, 10);
      setActorAnimationAndWaitUntilFinished(15, 3);
      FUN_2009a7c(10);
      FUN_2009acc(14, 392, 360);
      FUN_2009ad4(15, 216, 360);
      FUN_2009acc(15, 376, 360);
      FUN_2009b54(0, 0x4000, 0);
      FUN_2009b54(1, 0x4000, 0);
      FUN_2009b54(5, 0x4000, 0);
      FUN_2009b7c(0x1890000, -1, 0x1530000, 1);
      FUN_2009acc(14, 392, 360);
      FUN_2009ad4(15, 376, 360);
      setActorAnimationIfLoaded(14, 0);
      setActorAnimationIfLoaded(15, 0);
      FUN_2009b54(14, 0xd000, 0);
      FUN_2009b54(15, 0xd000, 30);
      FUN_2009b0c(14, 2);
      FUN_2009b44(14, 0, 10);
      FUN_2009b5c(1, 0x102, 60);
      FUN_2009b0c(1, 1);
      FUN_2009b44(1, 0, 10);
      setActorAnimationAndWaitUntilFinished(15, 4);
      FUN_2009b34(0x100f);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xf8f);
      } else {
        //LAB_2008f40
        FUN_2009b2c(0xf90);
      }

      //LAB_2008f48
      FUN_2009b44(0x100f, 0, 10);
      FUN_2009b0c(1, 2);
      FUN_2009b2c(0xf91);
      FUN_2009b44(1, 0, 20);
      FUN_2009b1c(14, 15, 40);
      FUN_2009b54(14, 0xd000, 0);
      FUN_2009b54(15, 0xd000, 20);
      FUN_2009b44(14, 0, 60);
      FUN_2009b0c(15, 1);
      FUN_2009a7c(10);
      setActorAnimationAndWaitUntilFinished(15, 3);
      FUN_2009b44(0x100f, 0, 10);
      FUN_2009b0c(5, 2);
      setActorAnimationAndWaitUntilFinished(5, 3);
      FUN_2009b44(0x1005, 0, 20);
      FUN_2009b0c(14, 2);
      FUN_2009b54(14, 0xa000, 20);
      FUN_2009b34(14);

      if(FUN_2009a94(0, 0) == 0) {
        FUN_2009b2c(0xf96);
      } else {
        //LAB_2009002
        FUN_2009b2c(0xf97);
      }

      //LAB_2009008
      FUN_2009b54(5, 0, 0);
      FUN_2009b54(1, 0x8000, 20);
      FUN_2009b0c(14, 2);
      FUN_2009b44(14, 0, 10);
      FUN_2009b14(14, 1, 30);
      FUN_2009b14(14, 5, 30);
      FUN_2009b5c(14, 0x105, 80);
      setActorAnimationAndWaitUntilFinished(14, 4);
      FUN_2009b2c(0xf98);
      FUN_2009b44(14, 0, 6);
      FUN_2009b5c(0, 0x100, 0);
      FUN_2009b5c(1, 0x100, 0);
      FUN_2009b5c(5, 0x100, 0);
      FUN_2009b04(1, 1);
      FUN_2009b04(5, 1);
      FUN_2009b0c(0, 1);
      FUN_2009a7c(40);
      FUN_2009b0c(5, 2);
      FUN_2009b54(1, 0x4000, 0);
      FUN_2009b54(5, 0x4000, 10);
      FUN_2009b44(0x1005, 0, 10);
      FUN_2009b0c(15, 2);
      FUN_2009b54(15, 0, 10);
      FUN_2009b44(0x100f, 0, 10);
      FUN_2009b54(14, 0x8000, 20);
      setActorAnimationAndWaitUntilFinished(14, 4);
      FUN_2009b44(14, 0, 10);
      FUN_2009b0c(15, 2);
      FUN_2009a7c(10);
      FUN_2009b54(14, 0xb000, 0);
      FUN_2009b54(15, 0xd000, 20);
      setActorVelocityScalerAndAcceleration(15, 0x8000, 0x4000);
      setActorVelocityScalerAndAcceleration(14, 0x8000, 0x4000);
      getMapActor(14)._5a.and(~0x1);
      getMapActor(15)._5a.and(~0x1);
      FUN_2009acc(14, 392, 376);
      FUN_2009ad4(15, 376, 376);
      FUN_2009a7c(6);
      getMapActor(14)._5a.or(0x1);
      getMapActor(15)._5a.or(0x1);
      setActorAnimationIfLoaded(14, 0);
      setActorAnimationIfLoaded(15, 0);
      FUN_2009a7c(20);
      FUN_2009b0c(1, 2);
      FUN_2009b44(1, 0, 10);
      FUN_2009b54(0, 1, 20);
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationAndWaitUntilFinished(1, 3);
      playSound(0x11);
      setActorAnimationIfLoaded(1, 2);

      r0 = getMapActor(0);
      if(r0 != null) {
        FUN_2009ac4(1, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_200921e
      FUN_2009adc(1);
      FUN_2009ae4(1, 0, 0);
      setActorAnimationIfLoaded(5, 2);

      r0 = getMapActor(0);
      if(r0 != null) {
        FUN_2009ac4(5, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_200924e
      FUN_2009adc(5);
      FUN_2009ae4(5, 0, 0);
      FUN_2009b24(14, 0x10000, 0x2009ce0);
      FUN_2009b24(15, 0x10000, 0x2009ce0);
      FUN_2009bcc();
      FUN_2009a8c();
    }
  }

  /**
   * Event list 0x2009efc handler 10
   */
  @Method(value = 0x20092a0, ignoreExtraParams = true)
  public static void FUN_20092a0() {
    if(readFlag(0x800) == 0) {
      //LAB_20092b0
      FUN_2009a84();
      setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
      FUN_2009b2c(0xf9f);
      FUN_2009b3c(13, 0);
      Actor70 r0 = getMapActor(0);
      final int r5 = r0.pos_08.getX() & ~0xffff;
      final int r6 = r0.pos_08.getZ() & ~0xffff;
      FUN_2009ae4(5, r5, r6);
      FUN_2009ae4(1, r5, r6);
      setActorVelocityScalerAndAcceleration(5, 0xcccc, 0x6666);
      setActorVelocityScalerAndAcceleration(1, 0xcccc, 0x6666);
      FUN_2009acc(5, 296, 328);
      FUN_2009ad4(1, 280, 328);
      setActorAnimationIfLoaded(0, 0);
      setActorAnimationIfLoaded(5, 0);
      setActorAnimationIfLoaded(1, 0);
      FUN_2009b54(5, 0xb000, 0);
      FUN_2009b54(1, 0xb000, 0);
      FUN_2009b54(0, 0xb000, 0);
      FUN_2009b7c(0xe80000, -1, 0xf00000, 1);
      FUN_2009b84();
      FUN_2009b54(13, 0x8000, 20);
      FUN_2009b0c(13, 2);
      FUN_2009b3c(13, 0);
      setActorVelocityScalerAndAcceleration(13, 0x3333, 0x1999);
      FUN_2009ad4(13, 216, 232);
      FUN_2009a7c(20);
      FUN_2009b0c(13, 1);
      FUN_2009a7c(10);
      FUN_2009b44(13, 0, 40);
      FUN_2009afc(13, 2, 10);
      FUN_2009b54(13, 0, 10);
      FUN_2009b44(13, 0, 10);
      FUN_2009ad4(13, 248, 232);
      FUN_2009a7c(40);
      FUN_2009b0c(13, 2);
      FUN_2009a7c(20);
      FUN_2009b3c(13, 0);
      FUN_2009b5c(13, 0x101, 60);
      FUN_2009b0c(13, 1);
      FUN_2009b54(13, 0x8000, 20);
      FUN_2009b44(13, 0, 2);
      FUN_2009ad4(13, 232, 232);
      FUN_2009a7c(2);
      FUN_2009b54(13, 0x4000, 4);
      FUN_2009b0c(13, 2);
      FUN_2009a7c(4);
      FUN_2009b44(13, 0, 2);
      setActorAnimationAndWaitUntilFinished(13, 4);
      FUN_2009a7c(20);
      FUN_2009b6c(0, 1);
      FUN_2009b84();
      setActorAnimationIfLoaded(1, 2);

      r0 = getMapActor(0);
      if(r0 != null) {
        FUN_2009ac4(1, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_20094a0
      FUN_2009adc(1);
      FUN_2009ae4(1, 0, 0);
      setActorAnimationIfLoaded(5, 2);

      r0 = getMapActor(0);
      if(r0 != null) {
        FUN_2009ac4(5, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_20094d0
      FUN_2009adc(5);
      FUN_2009ae4(5, 0, 0);
      setFlag(0x800);
      FUN_2009a8c();
    }
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x200950c)
  public static int init() {
    if(entranceId_2000402.get() >= 5 && entranceId_2000402.get() < 7) {
      clearFlag(0x12f);
    }

    //LAB_2009530
    if(readFlag(0x109) != 0) {
      clearFlag(0x242);
    }

    //LAB_2009540
    if(readFlag(0x834) != 0) {
      //LAB_200954c
      FUN_2009b9c();
      FUN_2009ba4();
      FUN_2009a84();
      FUN_2009ae4(12, 0, 0);
      FUN_2009ae4(13, 0, 0);
      FUN_2009ae4(14, 0, 0);
      FUN_2009ae4(15, 0, 0);
      FUN_2009ae4(5, 0, 0);
      getMapActor(8)._59.or(0x8);
      FUN_2009ae4(11, 0x530000, 0x1090000);
      FUN_2009ad4(11, 83, 273);
      setActorAnimationIfLoaded(11, 5);
      getMapActor(11).radius_20.set(12);
      FUN_2009aac(11, 0x2009c34);

      if(readFlag(0x839) != 0) {
        FUN_2009ae4(11, 0, 0);
      }

      //LAB_20095de
      FUN_2009a8c();
      FUN_2009a5c(9, 24, 1, 1, 14, 21);
      FUN_2009a5c(9, 24, 1, 1, 15, 21);
      FUN_2009a5c(9, 24, 1, 1, 23, 19);
      FUN_2009a5c(9, 24, 1, 1, 24, 19);
      FUN_2009a5c(9, 24, 1, 1, 23, 20);
      FUN_2009a5c(9, 24, 1, 1, 24, 20);
    } else {
      //LAB_2009656
      FUN_2009ae4(9, 0, 0);
      FUN_2009ae4(10, 0, 0);
      FUN_2009ae4(1, 0, 0);
      FUN_2009ae4(11, 0, 0);
      FUN_2009a84();

      if(readFlag(0x109) == 0 && entranceId_2000402.get() == 10) {
        FUN_2008964();
      }

      //LAB_2009698
      if(readFlag(0x801) != 0) {
        FUN_2009ae4(13, 0, 0);
        FUN_2009ae4(14, 0, 0);
        FUN_2009ae4(15, 0, 0);
        //LAB_20096c2
      } else if(readFlag(0x808) != 0) {
        FUN_2009ae4(14, 0x1880000, 0x1780000);
        FUN_2009ae4(15, 0x1780000, 0x1780000);
        FUN_2009b24(14, 0x10000, 0x2009ce0);
        FUN_2009b24(15, 0x10000, 0x2009ce0);
      }

      //LAB_2009702
      if(readFlag(0x87a) != 0) {
        FUN_2009ae4(16, 0x840000, 0x1080000);
      }

      //LAB_200971a
      FUN_2009a8c();
    }

    //LAB_200971e
    return 0;
  }

  /**
   * Event list 0x2009fb0 handler 5
   */
  @Method(value = 0x2009760, ignoreExtraParams = true)
  public static void FUN_2009760() {
    if(readFlag(0x839) == 0) {
      //LAB_200976e
      if(readFlag(0x82f) != 0) {
        FUN_2009a84();
        FUN_2009b0c(11, 2);
        FUN_2009b2c(0xe8b);
        FUN_2009b3c(11, 0);
        FUN_2009a8c();
      } else {
        //LAB_2009798
        FUN_2009a84();
        FUN_2009ab4(11);
        FUN_2009b0c(11, 1);
        FUN_2009b2c(0xe85);
        FUN_2009b44(11, 0, 20);
        FUN_2009b5c(0, 0x100, 30);
        FUN_2009b7c(0x620000, -1, 0x11b0000, 1);
        FUN_2009ad4(0, 94, 293);
        FUN_2009b54(0, 0xa000, 0);

        Actor70 r0 = getMapActor(0);
        if(r0 != null) {
          FUN_2009ae4(1, r0.pos_08.getX(), r0.pos_08.getZ());
        }

        //LAB_2009802
        FUN_2009ad4(1, 110, 279);
        FUN_2009b54(1, 0xa000, 40);
        FUN_2009b0c(11, 2);
        FUN_2009a7c(40);
        FUN_2009b34(11);

        if(FUN_2009a94(0, 0) == 0) {
          FUN_2009b0c(11, 2);
          FUN_2009a7c(20);
          FUN_2009b2c(0xe87);
          FUN_2009b3c(11, 0);
          setFlag(0x82f);
        } else {
          //LAB_200985e
          FUN_2009b0c(11, 2);
          FUN_2009a7c(20);
          FUN_2009b2c(0xe88);
          FUN_2009b44(11, 0, 40);
          FUN_2009b14(11, 0, 0);
          setActorAnimationIfLoaded(11, 1);
          FUN_2009afc(11, 4, 40);
          setActorAnimationIfLoaded(11, 6);
          FUN_2009b5c(11, 0x101, 40);
          FUN_2009b44(11, 0, 10);
          setActorAnimationIfLoaded(11, 1);
          FUN_2009a7c(10);
          setActorAnimationAndWaitUntilFinished(11, 3);
          FUN_2009b44(11, 0, 10);
          setActorAnimationAndWaitUntilFinished(11, 3);
          FUN_2009b24(0, 0x1000b, 0x2009ce0);
          FUN_2009b24(1, 0x1000b, 0x2009ce0);
          FUN_2009abc(11, 0x2009bdc);
          FUN_2009ab4(0);
          FUN_2009ab4(1);
          FUN_2009b54(0, 0x4000, 0);
          FUN_2009b54(1, 0x4000, 60);
          FUN_2009b5c(0, 0x105, 0);
          FUN_2009b5c(1, 0x105, 120);
          setFlag(0x839);
        }

        //LAB_2009938
        setActorAnimationIfLoaded(1, 2);

        r0 = getMapActor(0);
        if(r0 != null) {
          FUN_2009ac4(1, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
        }

        //LAB_2009958
        FUN_2009adc(1);
        FUN_2009ae4(1, 0, 0);
        FUN_2009a8c();
      }
    }
  }

  /**
   * Event list 0x2009fb0 handler 6
   */
  @Method(value = 0x20099a4, ignoreExtraParams = true)
  public static void FUN_20099a4() {
    FUN_2009a84();
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x200);
    r1._1c8.set(64);
    setFlag(0x87d);
    startEncounter(12, 0);
    setFlag(0x900);
    FUN_2009a8c();
  }

  /**
   * Event list 0x2009fb0 handler 7
   */
  @Method(value = 0x20099e8, ignoreExtraParams = true)
  public static void FUN_20099e8() {
    FUN_2009a84();
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x200);
    r1._1c8.set(64);
    setFlag(0x87e);
    startEncounter(12, 1);
    setFlag(0x900);
    FUN_2009a8c();
  }

  /**
   * Event list 0x200a028 handler 6
   */
  @Method(value = 0x2009a2c, ignoreExtraParams = true)
  public static void FUN_2009a2c() {
    FUN_2009a84();
    FUN_2009b2c(0x1c96);
    FUN_2009b4c(16, 0);
    FUN_2009a8c();
  }

  /** {@link GoldenSun#atan2_} */
  @Method(0x2009a4c)
  public static int atan2(final int b, final int a) {
    return (int)MEMORY.call(0x8000100, b, a);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x2009a54)
  public static void FUN_2009a54(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x2009a5c)
  public static void FUN_2009a5c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x2009a64)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x2009a6c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x2009a74)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x2009a7c)
  public static void FUN_2009a7c(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x2009a84)
  public static void FUN_2009a84() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x2009a8c)
  public static void FUN_2009a8c() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x2009a94)
  public static int FUN_2009a94(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x2009a9c)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x2009aa4)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x2009aac)
  public static void FUN_2009aac(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x2009ab4)
  public static void FUN_2009ab4(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x2009abc)
  public static void FUN_2009abc(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x2009ac4)
  public static void FUN_2009ac4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x2009acc)
  public static void FUN_2009acc(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x2009ad4)
  public static void FUN_2009ad4(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x2009adc)
  public static void FUN_2009adc(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x2009ae4)
  public static void FUN_2009ae4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x2009aec)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x2009af4)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x2009afc)
  public static void FUN_2009afc(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2009b04)
  public static void FUN_2009b04(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x2009b0c)
  public static void FUN_2009b0c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x2009b14)
  public static void FUN_2009b14(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x2009b1c)
  public static void FUN_2009b1c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a168} */
  @Method(0x2009b24)
  public static void FUN_2009b24(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    MEMORY.call(0x808a168, mapActorIndex1, mapActorIndex2AndFlags, r2);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x2009b2c)
  public static void FUN_2009b2c(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x2009b34)
  public static Panel24 FUN_2009b34(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x2009b3c)
  public static void FUN_2009b3c(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x2009b44)
  public static void FUN_2009b44(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x2009b4c)
  public static int FUN_2009b4c(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x2009b54)
  public static void FUN_2009b54(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2009b5c)
  public static void FUN_2009b5c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x2009b64)
  public static void FUN_2009b64(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x2009b6c)
  public static void FUN_2009b6c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x2009b74)
  public static void FUN_2009b74(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2009b7c)
  public static void FUN_2009b7c(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x2009b84)
  public static void FUN_2009b84() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x2009b8c)
  public static void FUN_2009b8c(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#startEncounter_} */
  @Method(0x2009b94)
  public static void startEncounter(final int encounterSet, final int encounterIndex) {
    MEMORY.call(0x808a250, encounterSet, encounterIndex);
  }

  /** {@link GoldenSun_808#FUN_808a2c0} */
  @Method(0x2009b9c)
  public static void FUN_2009b9c() {
    MEMORY.call(0x808a2c0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x2009ba4)
  public static void FUN_2009ba4() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a338} */
  @Method(0x2009bac)
  public static void FUN_2009bac(final int r0, final int r1) {
    MEMORY.call(0x808a338, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x2009bb4)
  public static void FUN_2009bb4() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x2009bbc)
  public static void FUN_2009bbc() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x2009bc4)
  public static void FUN_2009bc4() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a4f0} */
  @Method(0x2009bcc)
  public static void FUN_2009bcc() {
    MEMORY.call(0x808a4f0);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x2009bd4)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
