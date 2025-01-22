package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.types.Panel24;

import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.MEMORY;

public final class Map10Overlay_878ac38 {
  private Map10Overlay_878ac38() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    return 0x2008cf0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008038)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x200803c)
  public static int getTransitions() {
    return 0x2008d38;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    return 0x2008d44;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    return 0x2008e94;
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008054)
  public static int init() {
    if(entranceId_2000402.get() == 15) {
      FUN_2008074();
    }

    //LAB_200806a
    return 0;
  }

  @Method(0x2008074)
  public static void FUN_2008074() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    FUN_2008af8();
    r0 = 0xe;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xf;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x10;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x11;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x12;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x13;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x109;
    r2 = 0x1e7;
    FUN_2008b40(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0xb;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0x80;
    r2 = 0xfa;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = r2 << 1;
    FUN_2008b40(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x0;
    r0 = 0xc;
    r1 = r1 << 8;
    FUN_2008b98(r0, r1, r2);
    r1 = 0x10006;
    r0 = 0x10003;
    FUN_2008be0(r0, r1);
    FUN_2008bd8();
    r0 = 0x3c;
    sleep(r0);
    r0 = 0x80;
    r1 = 0x1;
    r2 = 0x99;
    r0 = r0 << 17;
    r1 = -r1;
    r2 = r2 << 18;
    r3 = 0x0;
    FUN_2008bb8(r0, r1, r2, r3);
    FUN_2008bc0();
    FUN_2008ac0();
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xe4;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = 0x20;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2008be8();
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_2008bb0(r0, r1);
    r0 = 0x80;
    r1 = 0x1;
    r2 = 0xfa;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 17;
    r0 = r0 << 17;
    FUN_2008bb8(r0, r1, r2, r3);
    r0 = 0x14;
    FUN_2008af0(r0);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 9;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008bd8();
    r0 = 0x91;
    playSound(r0);
    r0 = 0x1e;
    FUN_2008af0(r0);
    FUN_2008bd8();
    r0 = 0x91;
    playSound(r0);
    FUN_2008bc0();
    r0 = 0x80;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008bd8();
    r0 = 0x91;
    playSound(r0);
    r0 = 0x1;
    r1 = 0x1;
    r1 = -r1;
    r2 = 0xe666;
    r0 = -r0;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008ad8();
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x1122;
    FUN_2008b80(r0);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r1 = 0xa0;
    r2 = 0x0;
    r1 = r1 << 7;
    r0 = 0x9;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x0;
    r0 = 0x9;
    FUN_2008b90(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0xb;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xb;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0xc;
    FUN_2008b70(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0xc;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xc;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r0 = 0xd;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0xd;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r2 = 0x0;
    r1 = 0xd;
    r0 = 0xa;
    FUN_2008b70(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0xa;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0xa;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r2 = 0x0;
    r1 = 0xa;
    r0 = 0x9;
    FUN_2008b70(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r2 = 0x0;
    r1 = 0x9;
    r0 = 0xa;
    FUN_2008b70(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0xa;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x0;
    r0 = 0xa;
    FUN_2008b90(r0, r1);
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x80;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008bd8();
    r0 = 0x91;
    playSound(r0);
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x9;
    r2 = 0x0;
    FUN_2008b78(r0, r1, r2);
    r0 = 0xa;
    r1 = 0xb;
    r2 = 0x0;
    FUN_2008b78(r0, r1, r2);
    r2 = 0x0;
    r0 = 0xc;
    r1 = 0xd;
    FUN_2008b78(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0x9;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0xa;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0xb;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0xc;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0xd;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    r0 = -r0;
    r1 = -r1;
    r2 = 0xe666;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008ad8();
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xf0;
    r2 = 0x81;
    r2 = r2 << 17;
    r0 = 0x0;
    r1 = r1 << 15;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xc0;
    r1 = 0xc0;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_2008bb0(r0, r1);
    r0 = 0xe0;
    r1 = 0x1;
    r2 = 0xa0;
    r3 = 0x1;
    r2 = r2 << 17;
    r1 = -r1;
    r0 = r0 << 15;
    FUN_2008bb8(r0, r1, r2, r3);
    r0 = 0x28;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0xa0;
    r0 = 0x0;
    r1 = 0x78;
    r2 = r2 << 1;
    FUN_2008b28(r0, r1, r2);
    r2 = 0xa0;
    r2 = r2 << 1;
    r0 = 0x1;
    r1 = 0x68;
    FUN_2008b30(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    FUN_2008bc0();
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0x80;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x1;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x32;
    FUN_2008af0(r0);
    r1 = 0xc0;
    r2 = 0xc0;
    r2 = r2 << 8;
    r0 = 0x1;
    r1 = r1 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0xab;
    r2 = r2 << 1;
    r0 = 0x1;
    r1 = 0x69;
    FUN_2008b30(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0x1;
    FUN_2008b90(r0, r1);
    r0 = 0xa;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_2008b60(r0, r1);
    r1 = 0x1;
    r2 = 0x0;
    r0 = 0x0;
    FUN_2008b78(r0, r1, r2);
    r0 = 0x14;
    FUN_2008af0(r0);
    r1 = 0x0;
    r0 = 0x1;
    FUN_2008b88(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_2008b08(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x3c;
      FUN_2008af0(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x32;
      FUN_2008af0(r0);
      r1 = 0xc0;
      r2 = 0x0;
      r0 = 0x0;
      r1 = r1 << 8;
      FUN_2008b98(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x2;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x80;
      r2 = 0x80;
      r0 = 0x1;
      r1 = r1 << 9;
      r2 = r2 << 8;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r2 = 0xa0;
      r0 = 0x1;
      r1 = 0x67;
      r2 = r2 << 1;
      FUN_2008b30(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
    } else {
      //LAB_20084a8
      r0 = 0x3c;
      FUN_2008af0(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x32;
      FUN_2008af0(r0);
      r1 = 0xc0;
      r2 = 0x0;
      r0 = 0x1;
      r1 = r1 << 6;
      FUN_2008b98(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x2;
      setActorAnimationIfLoaded(r0, r1);
      r2 = 0xaa;
      r0 = 0x0;
      r1 = 0x78;
      r2 = r2 << 1;
      FUN_2008b30(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
    }

    //LAB_20084ec
    r0 = 0xc;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_2008ba8(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0xa0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0xb;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0xa;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0xc;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x0;
    r0 = 0xd;
    r1 = r1 << 8;
    FUN_2008b98(r0, r1, r2);
    r0 = 0xc0;
    r1 = 0xc0;
    r0 = r0 << 10;
    r1 = r1 << 7;
    FUN_2008bb0(r0, r1);
    r1 = 0x1;
    r0 = 0xa;
    FUN_2008bc8(r0, r1);
    FUN_2008bc0();
    r0 = 0x32;
    FUN_2008af0(r0);
    r0 = 0xa;
    r1 = 0x2;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0xa;
    FUN_2008b90(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0x8;
    FUN_2008b90(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0x9;
    FUN_2008b90(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r0 = 0xe0;
    r1 = 0x1;
    r2 = 0xa0;
    r2 = r2 << 17;
    r3 = 0x1;
    r0 = r0 << 15;
    r1 = -r1;
    FUN_2008bb8(r0, r1, r2, r3);
    FUN_2008bc0();
    r0 = 0x0;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_2008b60(r0, r1);
    r0 = 0x1;
    FUN_2008b20(r0);
    r0 = 0x32;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    FUN_2008b20(r0);
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_2008bb0(r0, r1);
    r0 = 0xd6;
    r1 = 0x1;
    r2 = 0xec;
    r3 = 0x1;
    r0 = r0 << 16;
    r1 = -r1;
    r2 = r2 << 17;
    FUN_2008bb8(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r2 = r2 << 8;
    r0 = 0x1;
    r1 = r1 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x2008c00;
    r0 = 0x0;
    FUN_2008b18(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x2008c64;
    r0 = 0x1;
    FUN_2008b18(r0, r1);
    r0 = 0x1;
    FUN_2008b20(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    FUN_2008bc0();
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r2 = 0x6666;
    r0 = 0x8;
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x109;
    r2 = 0x1c7;
    FUN_2008b30(r0, r1, r2);
    r2 = 0x1c7;
    r0 = 0x8;
    r1 = 0xf6;
    FUN_2008b30(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x0;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x32;
    FUN_2008af0(r0);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x32;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0x8;
    FUN_2008b90(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0x1;
    r2 = 0x0;
    r0 = 0x0;
    FUN_2008b78(r0, r1, r2);
    r0 = 0x32;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_2008b98(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x14;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0xa;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x32;
    FUN_2008af0(r0);
    r1 = 0xc0;
    r1 = r1 << 6;
    r2 = 0x0;
    r0 = 0x1;
    FUN_2008b98(r0, r1, r2);
    r0 = 0xa;
    FUN_2008af0(r0);
    r1 = 0x0;
    r0 = 0xa;
    FUN_2008b88(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_2008b08(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x28;
      FUN_2008af0(r0);
      r1 = 0x9;
      r2 = 0x0;
      r0 = 0x8;
      FUN_2008b78(r0, r1, r2);
      r0 = 0x32;
      FUN_2008af0(r0);
      r1 = 0x80;
      r0 = 0x8;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_2008b98(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x0;
      r1 = r1 << 8;
      r0 = 0x9;
      FUN_2008b98(r0, r1, r2);
      r0 = 0x28;
      FUN_2008af0(r0);
      r0 = 0x9;
      r1 = 0x1;
      FUN_2008b68(r0, r1);
      r0 = 0x9;
      r1 = 0x0;
      FUN_2008b90(r0, r1);
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    } else {
      //LAB_20087f0
      r0 = 0x28;
      FUN_2008af0(r0);
      r1 = 0x9;
      r2 = 0x0;
      r0 = 0x8;
      FUN_2008b78(r0, r1, r2);
      r0 = 0x32;
      FUN_2008af0(r0);
      r1 = 0x80;
      r0 = 0x8;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_2008b98(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x0;
      r1 = r1 << 8;
      r0 = 0x9;
      FUN_2008b98(r0, r1, r2);
      r0 = 0x28;
      FUN_2008af0(r0);
      r0 = 0x9;
      r1 = 0x1;
      FUN_2008b68(r0, r1);
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
      r0 = 0x9;
      r1 = 0x0;
      FUN_2008b90(r0, r1);
    }

    //LAB_2008844
    r0 = 0x1e;
    FUN_2008af0(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x2;
    FUN_2008b60(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x8;
    r1 = 0x0;
    FUN_2008b90(r0, r1);
    r2 = 0x0;
    r1 = 0x9;
    r0 = 0x8;
    FUN_2008b70(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x1;
    r0 = 0x8;
    FUN_2008b68(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_2008b90(r0, r1);
    r0 = 0x14;
    FUN_2008af0(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r1 = 0xb0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x9;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x32;
    FUN_2008af0(r0);
    r1 = 0x80;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x14;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_2008b68(r0, r1);
    r1 = 0x0;
    r0 = 0x8;
    FUN_2008b90(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r2 = 0x0;
    r1 = 0x9;
    r0 = 0x8;
    FUN_2008b78(r0, r1, r2);
    r0 = 0x28;
    FUN_2008af0(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r1 = 0xff;
    r2 = 0x1bd;
    r0 = 0x8;
    FUN_2008b40(r0, r1, r2);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0x2d;
    r2 = 0xb;
    r0 = 0x2008ea0;
    FUN_2008ac8(r0, r1, r2);
    r0 = 0xbc;
    playSound(r0);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r2 = 0xc3;
    r1 = 0xff;
    r2 = r2 << 1;
    r0 = 0x8;
    FUN_2008b38(r0, r1, r2);
    r0 = 0x14;
    FUN_2008af0(r0);
    r0 = 0x9;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xa;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xc3;
    r0 = 0x9;
    r1 = 0xff;
    r2 = r2 << 1;
    FUN_2008b38(r0, r1, r2);
    r2 = 0xe6;
    r0 = 0xa;
    r1 = 0xff;
    r2 = r2 << 1;
    FUN_2008b40(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0xa;
    FUN_2008b98(r0, r1, r2);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_2008b60(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    FUN_2008b68(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r2 = 0xc3;
    r2 = r2 << 1;
    r0 = 0xa;
    r1 = 0xff;
    FUN_2008b38(r0, r1, r2);
    r5 = 0x2008cb4;
    r0 = 0x0;
    r1 = r5;
    FUN_2008b18(r0, r1);
    r0 = 0x28;
    FUN_2008af0(r0);
    r1 = r5;
    r0 = 0x1;
    FUN_2008b18(r0, r1);
    r0 = 0x1;
    FUN_2008b20(r0);
    r1 = 0x81;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_2008ba0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0xc;
    FUN_2008ba0(r0, r1, r2);
    r0 = 0x28;
    FUN_2008af0(r0);
    r0 = 0x80;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008bd8();
    r0 = 0x91;
    playSound(r0);
    r0 = 0x1e;
    FUN_2008af0(r0);
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xe4;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = 0x40;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2008bf0();
    r0 = 0x1;
    r1 = 0x1;
    r1 = -r1;
    r2 = 0xe666;
    r0 = -r0;
    FUN_2008ad0(r0, r1, r2);
    FUN_2008ad8();
    r0 = 0x12f;
    clearFlag(r0);
    r0 = 0x879;
    setFlag(r0);
    r0 = 0x1;
    FUN_2008bd0(r0);
    FUN_2008b00();
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x2008ab8)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x2008ac0)
  public static void FUN_2008ac0() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x2008ac8)
  public static void FUN_2008ac8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x2008ad0)
  public static void FUN_2008ad0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f8} */
  @Method(0x2008ad8)
  public static void FUN_2008ad8() {
    MEMORY.call(0x80091f8);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x2008ae0)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x2008ae8)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x2008af0)
  public static void FUN_2008af0(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x2008af8)
  public static void FUN_2008af8() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x2008b00)
  public static void FUN_2008b00() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x2008b08)
  public static int FUN_2008b08(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x2008b10)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x2008b18)
  public static void FUN_2008b18(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x808a098, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x2008b20)
  public static void FUN_2008b20(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x2008b28)
  public static void FUN_2008b28(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x2008b30)
  public static void FUN_2008b30(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x2008b38)
  public static void FUN_2008b38(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x2008b40)
  public static void FUN_2008b40(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x2008b48)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x2008b50)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x2008b58)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2008b60)
  public static void FUN_2008b60(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x2008b68)
  public static void FUN_2008b68(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x2008b70)
  public static void FUN_2008b70(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x2008b78)
  public static void FUN_2008b78(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x2008b80)
  public static void FUN_2008b80(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x2008b88)
  public static Panel24 FUN_2008b88(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x2008b90)
  public static void FUN_2008b90(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x2008b98)
  public static void FUN_2008b98(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2008ba0)
  public static void FUN_2008ba0(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x2008ba8)
  public static void FUN_2008ba8(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x2008bb0)
  public static void FUN_2008bb0(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2008bb8)
  public static void FUN_2008bb8(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x2008bc0)
  public static void FUN_2008bc0() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a220} */
  @Method(0x2008bc8)
  public static void FUN_2008bc8(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a220, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x2008bd0)
  public static void FUN_2008bd0(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x2008bd8)
  public static void FUN_2008bd8() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e8} */
  @Method(0x2008be0)
  public static void FUN_2008be0(final int r0, final int r1) {
    MEMORY.call(0x808a2e8, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x2008be8)
  public static void FUN_2008be8() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x2008bf0)
  public static void FUN_2008bf0() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x2008bf8)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
