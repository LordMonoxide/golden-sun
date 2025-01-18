package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.RenderPacket0c;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map12Overlay_878c76c {
  private Map12Overlay_878c76c() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    final int r0;

    r0 = 0x200a5c0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008038)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x200803c)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200a698;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    final int r0;

    r0 = 0x200a6bc;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    final int r0;

    r0 = 0x200a80c;
    return r0;
  }

  @Method(0x2008054)
  public static int FUN_2008054() {
    int r0;

    r0 = 0x818;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x813;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        return -1;
      }
      r0 = 0x3;
      FUN_200a52c(r0);
      r0 = 0x1;
      return r0;
    }

    //LAB_200806e
    r0 = 0x812;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x4;
      FUN_200a52c(r0);
      r0 = 0x1;
      return r0;
    }

    //LAB_2008082
    r0 = 0x1;
    r0 = -r0;
    return r0;
  }

  @Method(0x2008098)
  public static void FUN_2008098() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    CPU.sp().value -= 0x8;
    r3 = 0x2;
    r2 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x0;
    r1 = 0x1c;
    r2 = 0x11;
    r3 = 0x8;
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xc8;
    playSound(r0);
    r5 = 0x0;
    r7 = 0x2;
    r6 = 0x1;

    //LAB_20080bc
    do {
      r1 = 0x3d;
      r2 = 0x11;
      r3 = 0x28;
      r0 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r7);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      FUN_200a44c(r0);
      r0 = 0x8;
      r1 = 0x3d;
      r2 = 0x11;
      r3 = 0x28;
      MEMORY.ref(4, CPU.sp().value).setu(r7);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      r5 = r5 + 0x1;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      FUN_200a44c(r0);
    } while(r5 != 0x16);

    r5 = 0x4;
    r6 = 0x3;
    r0 = 0x0;
    r1 = 0x3b;
    r2 = 0xf;
    r3 = 0x26;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x4;
    r1 = 0x3b;
    r2 = 0x11;
    r3 = 0x26;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x2;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x8;
    r1 = 0x3c;
    r2 = 0x11;
    r3 = 0x27;
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x11;
    r2 = 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r1 = 0x0;
    r2 = 0x2;
    r3 = 0x1;
    r0 = 0x0;
    FUN_200a40c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x207;
    setFlag(r0);
    FUN_20096dc();
    CPU.sp().value += 0x8;
  }

  @Method(0x2008150)
  public static void FUN_2008150() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    FUN_200a454();
    r7 = 0x3001ebc;
    r6 = 0xe0;
    r2 = MEMORY.ref(4, r7).get();
    r3 = 0x80;
    r6 = r6 << 1;
    r3 = r3 << 1;
    r5 = 0xe4;
    MEMORY.ref(4, r2 + r6).setu(r3);
    r5 = r5 << 1;
    r3 = 0x20;
    MEMORY.ref(4, r2 + r5).setu(r3);
    FUN_200a544();
    FUN_200a554();
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x90;
    r2 = 0xe8;
    r2 = r2 << 16;
    r1 = r1 << 18;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    FUN_200a44c(r0);
    r0 = 0x101a;
    FUN_200a4dc(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x90;
    r2 = 0x8c;
    r2 = r2 << 17;
    r0 = 0x8;
    r1 = r1 << 18;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xb4;
    r3 = 0x1;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r1 = r1 << 2;
    r2 = 0xd8;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x14;
    FUN_200a44c(r0);
    r2 = 0x0;
    r1 = 0x2;
    r0 = 0x5;
    FUN_200a4bc(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x5;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200a4c4(r0, r1);
    r0 = 0x6;
    FUN_200a44c(r0);
    r1 = 0x90;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x59999;
    r1 = 0xb333;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xb0;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    r0 = 0x11f0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x3c;
    FUN_200a44c(r0);
    r1 = 0x1;
    r2 = 0xb4;
    r3 = 0x1;
    r2 = r2 << 16;
    r1 = -r1;
    r0 = 0x23e0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200a44c(r0);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 10;
    r2 = r2 << 10;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0xb8;
    r1 = r1 << 2;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x80;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r2 = MEMORY.ref(4, r7).get();
    r3 = 0x202;
    MEMORY.ref(4, r2 + r6).setu(r3);
    r6 = 0x10;
    MEMORY.ref(4, r2 + r5).setu(r6);
    FUN_200a54c();
    FUN_200a554();
    r1 = 0x1;
    r2 = 0xb0;
    r3 = 0x0;
    r1 = -r1;
    r2 = r2 << 16;
    r0 = 0x11f0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a3fc();
    r0 = 0x1;
    sleep(r0);
    FUN_200a544();
    FUN_200a554();
    r0 = 0x28;
    FUN_200a44c(r0);
    r1 = 0xd4;
    r2 = 0xc8;
    r2 = r2 << 16;
    r1 = r1 << 17;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x14;
    FUN_200a3a4(r0, r1);
    FUN_200a54c();
    FUN_200a554();
    r1 = 0x90;
    r2 = 0xb8;
    r0 = 0x8;
    r1 = r1 << 18;
    r2 = r2 << 16;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x1;
    r2 = 0xb4;
    r2 = r2 << 16;
    r3 = 0x0;
    r1 = -r1;
    r0 = 0x23e0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a3fc();
    r0 = 0x1;
    sleep(r0);
    FUN_200a544();
    FUN_200a554();
    r0 = 0x14;
    FUN_200a44c(r0);
    r0 = 0x13333;
    r1 = 0x2666;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0x9d;
    r3 = 0x1;
    r2 = r2 << 16;
    r1 = -r1;
    r0 = 0x23e0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x14;
    FUN_200a44c(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200a4c4(r0, r1);
    r0 = 0x1;
    r1 = 0x14;
    FUN_200a3a4(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x5;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200a4c4(r0, r1);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x50;
    FUN_200a3a4(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a504(r0, r1, r2);
    r0 = 0x3c;
    FUN_200a44c(r0);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x14;
    FUN_200a3a4(r0, r1);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200a504(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200a504(r0, r1, r2);
    r1 = 0x101;
    r2 = 0x0;
    r0 = 0x5;
    FUN_200a504(r0, r1, r2);
    r0 = 0x3c;
    FUN_200a44c(r0);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x1;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200a4d4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r2 = 0x0;
    r1 = 0x5;
    r0 = 0x0;
    FUN_200a4d4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r1 = r1 << 7;
    r0 = 0x1;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x19999;
    r1 = 0x3333;
    FUN_200a514(r0, r1);
    r0 = 0x90;
    r1 = 0x1;
    r2 = 0xd7;
    r3 = 0x1;
    r0 = r0 << 18;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r1 = 0x80;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0x90;
    r1 = r1 << 2;
    r2 = 0xd9;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x90;
    r0 = 0x8;
    r1 = r1 << 2;
    r2 = 0x141;
    FUN_200a494(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x8;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x39999;
    r1 = 0x7333;
    FUN_200a514(r0, r1);
    r0 = 0x90;
    r1 = 0x1;
    r2 = 0x88;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 16;
    r0 = r0 << 18;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x5;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200a47c(1, r1, r2);
    }

    //LAB_20085ae
    r0 = 0x1;
    FUN_200a49c(r0);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200a47c(5, r1, r2);
    }

    //LAB_20085de
    r0 = 0x5;
    FUN_200a49c(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x5;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x12f;
    clearFlag(r0);
    r1 = MEMORY.ref(4, r7).get();
    r2 = 0xe0;
    r2 = r2 << 1;
    r3 = r1 + r2;
    r2 = r2 + 0x44;
    MEMORY.ref(4, r3).setu(r2);
    r2 = r2 - 0x3c;
    r3 = r1 + r2;
    MEMORY.ref(4, r3).setu(r6);
    FUN_200a45c();
  }

  @Method(0x2008614)
  public static void FUN_2008614() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200a454();
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 - 0xc0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 + 0xc8;
    r2 = r1 + r3;
    r3 = 0x20;
    MEMORY.ref(4, r2).setu(r3);
    FUN_200a544();
    FUN_200a554();
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x90;
    r2 = 0x94;
    r2 = r2 << 17;
    r1 = r1 << 18;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    FUN_200a44c(r0);
    r0 = 0x1004;
    FUN_200a4dc(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xb4;
    r3 = 0x1;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r1 = r1 << 2;
    r2 = 0xd8;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x14;
    FUN_200a44c(r0);
    r2 = 0x0;
    r1 = 0x2;
    r0 = 0x5;
    FUN_200a4bc(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x5;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200a4c4(r0, r1);
    r0 = 0x6;
    FUN_200a44c(r0);
    r1 = 0x90;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x59999;
    r1 = 0xb333;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xb0;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    r0 = 0x11f0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x3c;
    FUN_200a44c(r0);
    r1 = 0x1;
    r2 = 0xb4;
    r3 = 0x1;
    r2 = r2 << 16;
    r1 = -r1;
    r0 = 0x23e0000;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200a44c(r0);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 10;
    r2 = r2 << 10;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0xb8;
    r1 = r1 << 2;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x3;
    FUN_200a4c4(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x0;
    r1 = 0x2;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x2;
    r0 = 0x5;
    FUN_200a4bc(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200a4c4(r0, r1);
    r0 = 0x1;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200a4c4(r0, r1);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x5;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200a4d4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200a4cc(r0, r1, r2);
    r1 = 0x5;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4cc(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0x90;
    r0 = 0x8;
    r1 = r1 << 2;
    r2 = 0xd8;
    FUN_200a494(r0, r1, r2);
    r1 = 0x80;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xd8;
    r2 = 0xc8;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200a48c(r0, r1, r2);
    r0 = 0x14;
    FUN_200a44c(r0);
    r0 = 0x26666;
    r1 = 0x4ccc;
    FUN_200a514(r0, r1);
    r0 = 0x90;
    r1 = 0x1;
    r2 = 0xab;
    r2 = r2 << 16;
    r3 = 0x1;
    r1 = -r1;
    r0 = r0 << 17;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x50;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x1;
    r2 = 0xb4;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 16;
    r0 = 0x23e0000;
    FUN_200a51c(r0, r1, r2, r3);
    r0 = 0x14;
    FUN_200a44c(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r1 = 0x90;
    r0 = 0x8;
    r1 = r1 << 2;
    r2 = 0xd8;
    FUN_200a494(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xab;
    r3 = 0x1;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 10;
    r2 = r2 << 10;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0xb8;
    r1 = r1 << 2;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x50;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x14;
    FUN_200a3a4(r0, r1);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x5;
    FUN_200a504(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200a4c4(r0, r1);
    r0 = 0x5;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x80;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200a504(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200a504(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x101;
    r0 = 0x5;
    FUN_200a504(r0, r1, r2);
    r0 = 0x3c;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200a4d4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x5;
    FUN_200a4d4(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200a4e4(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200a464(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x1010;
      FUN_200a4dc(r0);
    } else {
      //LAB_2008a5e
      r0 = 0x1011;
      FUN_200a4dc(r0);
    }

    //LAB_2008a64
    r1 = 0x6;
    r0 = 0x8;
    FUN_200a3a4(r0, r1);
    r0 = 0x1012;
    FUN_200a4dc(r0);
    r0 = 0x8;
    r1 = 0x2;
    FUN_200a4c4(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200a504(r0, r1, r2);
    r0 = 0x3c;
    FUN_200a44c(r0);
    r0 = 0x1;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0x80;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200a4bc(r0, r1, r2);
    r1 = 0x90;
    r2 = 0xd8;
    r1 = r1 << 2;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200a514(r0, r1);
    r1 = 0x1;
    r2 = 0xbf;
    r3 = 0x1;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0xe8;
    r1 = r1 << 2;
    r0 = 0x8;
    FUN_200a494(r0, r1, r2);
    r0 = 0x28;
    FUN_200a44c(r0);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200a4c4(r0, r1);
    r0 = 0x28;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a44c(r0);
    r0 = 0x8;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x90;
    r1 = 0x1;
    r2 = 0xd7;
    r3 = 0x1;
    r0 = r0 << 18;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200a51c(r0, r1, r2, r3);
    r0 = 0x8;
    r1 = 0x23e;
    r2 = 0x143;
    FUN_200a494(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x8;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x39999;
    r1 = 0x7333;
    FUN_200a514(r0, r1);
    r0 = 0x90;
    r1 = 0x1;
    r2 = 0x88;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 16;
    r0 = r0 << 18;
    FUN_200a51c(r0, r1, r2, r3);
    FUN_200a524();
    r0 = 0x14;
    FUN_200a44c(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x5;
    FUN_200a4f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200a44c(r0);
    r0 = 0x5;
    r1 = 0x6;
    FUN_200a3a4(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x5;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200a47c(5, r1, r2);
    }

    //LAB_2008bf8
    r0 = 0x5;
    FUN_200a49c(r0);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200a47c(1, r1, r2);
    }

    //LAB_2008c28
    r0 = 0x1;
    FUN_200a49c(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x1;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x12f;
    clearFlag(r0);
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 + 0x44;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 - 0x3c;
    r2 = r1 + r3;
    r3 = 0x10;
    MEMORY.ref(4, r2).setu(r3);
    FUN_200a45c();
  }

  @Method(0x2008c8c)
  public static void FUN_2008c8c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001e70;
    r3 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r3;
    CPU.sp().value -= 0x14;
    final Actor70 r5 = getMapActor(0);
    r2 = 0xb3;
    r3 = r5.pos_08.getZ();
    r2 = r2 << 16;
    if(r3 < r2) {
      r0 = 0x0;
      r1 = 0x23f;
      r2 = 0x84;
      FUN_200a494(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x0;
      r0 = 0x0;
      r1 = r1 << 7;
      FUN_200a4f4(r0, r1, r2);
      r0 = 0x1e;
      FUN_200a44c(r0);
      r3 = CPU.r10().value;
      r3 = MEMORY.ref(4, r3).get();
      CPU.r11().value = r3;
      r3 = r5.pos_08.getX();
      r7 = CPU.sp().value + 0x8;
      MEMORY.ref(4, r7).setu(r3);
      r3 = r5.pos_08.getY();
      MEMORY.ref(4, r7 + 0x4).setu(r3);
      r3 = r5.pos_08.getZ();
      r2 = CPU.r10().value;
      MEMORY.ref(4, r7 + 0x8).setu(r3);
      MEMORY.ref(4, r2).setu(r7);
      r6 = 0x0;

      //LAB_2008cec
      do {
        r3 = MEMORY.ref(4, r7 + 0x8).get();
        r2 = 0x80;
        r2 = r2 << 9;
        r3 = r3 + r2;
        MEMORY.ref(4, r7 + 0x8).setu(r3);
        r0 = 0x1;
        r6 = r6 + 0x1;
        FUN_200a44c(r0);
      } while(r6 != 0x1e);

      r0 = 0x28;
      FUN_200a44c(r0);
      r3 = 0x1;
    } else {
      //LAB_2008d0c
      r0 = 0x0;
      r1 = 0x241;
      r2 = 0xde;
      FUN_200a494(r0, r1, r2);
      r1 = 0xc0;
      r2 = 0x0;
      r0 = 0x0;
      r1 = r1 << 8;
      FUN_200a4f4(r0, r1, r2);
      r0 = 0x1e;
      FUN_200a44c(r0);
      r3 = r5.pos_08.getX();
      r7 = CPU.sp().value + 0x8;
      MEMORY.ref(4, r7).setu(r3);
      r3 = r5.pos_08.getY();
      MEMORY.ref(4, r7 + 0x4).setu(r3);
      r3 = r5.pos_08.getZ();
      r2 = CPU.r10().value;
      r2 = MEMORY.ref(4, r2).get();
      MEMORY.ref(4, r7 + 0x8).setu(r3);
      r3 = CPU.r10().value;
      MEMORY.ref(4, r3).setu(r7);
      CPU.r11().value = r2;
      r6 = 0x0;

      //LAB_2008d44
      do {
        r3 = MEMORY.ref(4, r7 + 0x8).get();
        r2 = 0xffff0000;
        r3 = r3 + r2;
        MEMORY.ref(4, r7 + 0x8).setu(r3);
        r0 = 0x1;
        r6 = r6 + 0x1;
        FUN_200a44c(r0);
      } while(r6 != 0x1e);

      r0 = 0x28;
      FUN_200a44c(r0);
      r3 = 0x2;
    }

    //LAB_2008d60
    CPU.r9().value = r3;
    r2 = 0x4;
    r6 = 0x0;
    CPU.r8().value = r2;

    //LAB_2008d6a
    do {
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      r0 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x8;
      FUN_200a44c(r0);
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      r0 = 0x2;
      r1 = 0x1e;
      r2 = 0x22;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      r6 = r6 + 0x1;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x8;
      FUN_200a44c(r0);
    } while(r6 != 0x6);

    r3 = 0x4;
    r6 = 0x0;
    CPU.r8().value = r3;

    //LAB_2008da8
    do {
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      r0 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      FUN_200a44c(r0);
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2;
      r1 = 0x1e;
      r2 = 0x22;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      r6 = r6 + 0x1;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      FUN_200a44c(r0);
    } while(r6 != 0xa);

    r2 = 0x4;
    r6 = 0x0;
    CPU.r8().value = r2;

    //LAB_2008de6
    do {
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      r0 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x2;
      FUN_200a44c(r0);
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      r0 = 0x2;
      r1 = 0x1e;
      r2 = 0x22;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(2);
      r6 = r6 + 0x1;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x2;
      FUN_200a44c(r0);
    } while(r6 != 0xc);

    r3 = 0x2;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x2;
    r1 = 0x1c;
    r2 = 0x22;
    r3 = 0xa;
    MEMORY.ref(4, CPU.sp().value).setu(4);
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x8;
    r3 = 0x28;
    r1 = 0x37;
    r2 = 0x20;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(4);
    FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x3c;
    FUN_200a44c(r0);
    r3 = CPU.r9().value;
    if(r3 == 0x1) {
      r6 = 0x0;

      //LAB_2008e52
      do {
        r3 = MEMORY.ref(4, r7 + 0x8).get();
        r2 = 0xffff0000;
        r3 = r3 + r2;
        MEMORY.ref(4, r7 + 0x8).setu(r3);
        r0 = 0x1;
        r6 = r6 + 0x1;
        FUN_200a44c(r0);
      } while(r6 != 0x1e);
    } else {
      //LAB_2008e68
      r3 = CPU.r9().value;
      if(r3 == 0x2) {
        r6 = 0x0;

        //LAB_2008e72
        do {
          r3 = MEMORY.ref(4, r7 + 0x8).get();
          r2 = 0x80;
          r2 = r2 << 9;
          r3 = r3 + r2;
          MEMORY.ref(4, r7 + 0x8).setu(r3);
          r0 = 0x1;
          r6 = r6 + 0x1;
          FUN_200a44c(r0);
        } while(r6 != 0x1e);
      }
    }

    //LAB_2008e88
    r3 = CPU.r11().value;
    r2 = CPU.r10().value;
    MEMORY.ref(4, r2).setu(r3);
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x2008eb0)
  public static void FUN_2008eb0() {
    int r0;
    int r1;
    int r2;
    int r3;
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
    r3 = 0x3001e70;
    r3 = MEMORY.ref(4, r3).get();
    r3 = r3 + 0xe4;
    r2 = MEMORY.ref(4, r3).get();
    r6 = 0x200aa50;
    if(r2 < 0x0) {
      r1 = 0xffff;
      r2 = r2 + r1;
    }

    //LAB_2008ed0
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    r2 = r2 >> 16;
    CPU.r10().value = r2;
    if(r3 < 0x0) {
      r2 = 0xffff;
      r3 = r3 + r2;
    }

    //LAB_2008ede
    r3 = r3 >> 16;
    r2 = 0x50;
    r2 = r2 - r3;
    CPU.r8().value = r2;
    r3 = CPU.r8().value;
    r3 = r3 + 0x10;
    if((r3 & 0xffff_ffffL) <= (0xaf & 0xffff_ffffL)) {
      r3 = 0x200a974;
      r3 = MEMORY.ref(4, r3).get();
      r1 = CPU.r10().value;
      r3 = r3 >> 10;
      r5 = r3 - r1;
      r3 = 0x20;
      r3 = -r3;
      r5 = r5 | r3;
      r2 = 0x1ff;
      r3 = 0xfffffe00;
      r7 = 0x0;
      CPU.r11().value = r2;
      CPU.r9().value = r3;

      //LAB_2008f08
      do {
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r2 = r5;
        r1 = CPU.r11().value;
        r2 = r2 & r1;
        r1 = CPU.r9().value;
        r3 = r3 & r1;
        r3 = r3 | r2;
        r2 = CPU.r8().value;
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        MEMORY.ref(1, r6 + 0x4).setu(r2);
        r0 = r6;
        r1 = 0x0;
        r7 = r7 + 0x1;
        insertIntoRenderQueue(MEMORY.ref(4, r0, RenderPacket0c::new), r1);
        r5 = r5 + 0x20;
        r6 = r6 + 0xc;
      } while((r7 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

      r3 = 0x200a974;
      r3 = MEMORY.ref(4, r3).get();
      r1 = CPU.r10().value;
      r3 = r3 >> 9;
      r5 = r3 - r1;
      r3 = 0x20;
      r3 = -r3;
      r5 = r5 | r3;
      r2 = 0x1ff;
      r3 = 0xfffffe00;
      r7 = 0x0;
      CPU.r11().value = r2;
      CPU.r9().value = r3;

      //LAB_2008f48
      do {
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r2 = r5;
        r1 = CPU.r11().value;
        r2 = r2 & r1;
        r1 = CPU.r9().value;
        r3 = r3 & r1;
        r3 = r3 | r2;
        r2 = CPU.r8().value;
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        MEMORY.ref(1, r6 + 0x4).setu(r2);
        r0 = r6;
        r1 = 0x0;
        r7 = r7 + 0x1;
        insertIntoRenderQueue(MEMORY.ref(4, r0, RenderPacket0c::new), r1);
        r5 = r5 + 0x20;
        r6 = r6 + 0xc;
      } while((r7 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

      r3 = 0x200a974;
      r3 = MEMORY.ref(4, r3).get();
      r1 = CPU.r10().value;
      r3 = r3 >> 8;
      r5 = r3 - r1;
      r3 = 0x20;
      r3 = -r3;
      r5 = r5 | r3;
      r1 = 0xfffffe00;
      r3 = 0x1ff;
      r2 = 0x8;
      r7 = 0x0;
      CPU.r8().value = CPU.r8().value + r2;
      CPU.r9().value = r3;
      CPU.r10().value = r1;

      //LAB_2008f8c
      do {
        r2 = r5;
        r3 = CPU.r9().value;
        r2 = r2 & r3;
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r1 = CPU.r10().value;
        r3 = r3 & r1;
        r3 = r3 | r2;
        r2 = CPU.r8().value;
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        MEMORY.ref(1, r6 + 0x4).setu(r2);
        r0 = r6;
        r1 = 0x0;
        r7 = r7 + 0x1;
        insertIntoRenderQueue(MEMORY.ref(4, r0, RenderPacket0c::new), r1);
        r5 = r5 + 0x20;
        r6 = r6 + 0xc;
      } while((r7 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));
    }

    //LAB_2008fb2
    r2 = 0x200a974;
    r3 = MEMORY.ref(4, r2).get();
    r3 = r3 + 0x80;
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  /**
   * Event list 0x200a80c handler 2
   */
  @Method(value = 0x2008fe4, ignoreExtraParams = true)
  public static void FUN_2008fe4() {
    if((getMapActor(0).angle_06.get() & 0xffff) == 0xc000) {
      FUN_200a534();
    }
  }

  /**
   * Event list 0x200a80c handler 3
   */
  @Method(value = 0x2009000, ignoreExtraParams = true)
  public static void FUN_2009000() {
    if((getMapActor(0).angle_06.get() & 0xffff) == 0x4000) {
      FUN_200a534();
    }
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x200905c)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r6 = CPU.r8().value;
    CPU.push(r6);
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 + 0x44;
    MEMORY.ref(4, r3).setu(r2);
    CPU.sp().value -= 0x8;
    FUN_20094b8();
    r0 = 0xa2;
    r0 = r0 << 1;
    setFlag(r0);
    final Actor70 actor18 = getMapActor(18);
    actor18._59.set(0);
    actor18.flags_23.or(0x2);
    FUN_200a414(getMapActor(18), 0);
    getMapActor(18).flags_23.and(~0x1);
    r1 = 0x1;
    r0 = 0x12;
    setActorPriority(r0, r1);
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r2 = 0x80;
    r3 = r3 - 0x3;
    r3 = r3 << 16;
    r2 = r2 << 9;
    if((r3 & 0xffff_ffffL) > (r2 & 0xffff_ffffL)) {
      r0 = 0x5;
      r1 = 0x0;
      r2 = 0x0;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x0;
      r2 = 0x0;
      moveActorToPosition(r0, r1, r2);
    }

    //LAB_20090e4
    r0 = 0x818;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0x90;
      r2 = 0xb2;
      r0 = 0x12;
      r1 = r1 << 17;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r1 = 0xc9;
      r2 = 0xc9;
      r0 = 0x11;
      r1 = r1 << 19;
      r2 = r2 << 19;
      moveActorToPosition(r0, r1, r2);
      r1 = 0xe8;
      r2 = 0xf0;
      r0 = 0xa;
      r1 = r1 << 16;
      r2 = r2 << 15;
      moveActorToPosition(r0, r1, r2);
      r1 = 0xac;
      r2 = 0xf0;
      r0 = 0xc;
      r1 = r1 << 17;
      r2 = r2 << 15;
      moveActorToPosition(r0, r1, r2);
      r1 = 0xe8;
      r2 = 0xf0;
      r0 = 0xa;
      r1 = r1 << 16;
      r2 = r2 << 15;
      moveActorToPosition(r0, r1, r2);
      r5 = 0x4;
      r3 = 0x26;
      r6 = 0x3;
      r0 = 0x0;
      r1 = 0x3b;
      r2 = 0xf;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r1 = 0xac;
      r2 = 0xf0;
      r0 = 0xc;
      r1 = r1 << 17;
      r2 = r2 << 15;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x4;
      r1 = 0x3b;
      r2 = 0x11;
      r3 = 0x26;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x8;
      r1 = 0x3c;
      r2 = 0x11;
      r3 = 0x27;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x11;
      r2 = 0x7;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x0;
      r1 = 0x1;
      r2 = 0x2;
      r3 = 0x1;
      FUN_200a40c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_2009186
      if(readFlag(0x816) != 0x0 && readFlag(0x817) != 0x0) {
        r1 = 0xe8;
        r2 = 0xf0;
        r0 = 0xa;
        r1 = r1 << 16;
        r2 = r2 << 15;
        moveActorToPosition(r0, r1, r2);
        r1 = 0xac;
        r2 = 0xf0;
        r0 = 0xc;
        r1 = r1 << 17;
        r2 = r2 << 15;
        moveActorToPosition(r0, r1, r2);
        r3 = 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r5 = 0x2;
        r3 = 0x8;
        r0 = 0x0;
        r1 = 0x1c;
        r2 = 0x11;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0xe8;
        r2 = 0xf0;
        r0 = 0xa;
        r1 = r1 << 16;
        r2 = r2 << 15;
        moveActorToPosition(r0, r1, r2);
        r3 = 0x3;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r6 = 0x4;
        CPU.r8().value = r3;
        r0 = 0x0;
        r3 = 0x26;
        r1 = 0x3b;
        r2 = 0xf;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0xac;
        r2 = 0xf0;
        r0 = 0xc;
        r1 = r1 << 17;
        r2 = r2 << 15;
        moveActorToPosition(r0, r1, r2);
        r2 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x4;
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x26;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x8;
        r1 = 0x3c;
        r2 = 0x11;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x11;
        r2 = 0x8;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x2;
        r3 = 0x1;
        FUN_200a40c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else {
        //LAB_2009234
        r0 = 0x816;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r1 = 0xe8;
          r2 = 0xf0;
          r0 = 0xa;
          r1 = r1 << 16;
          r2 = r2 << 15;
          moveActorToPosition(r0, r1, r2);
          r3 = 0x4;
          r2 = 0x3;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          r0 = 0x0;
          r1 = 0x3b;
          r2 = 0xf;
          r3 = 0x26;
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_2009260
        r0 = 0x817;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r1 = 0xac;
          r2 = 0xf0;
          r0 = 0xc;
          r1 = r1 << 17;
          r2 = r2 << 15;
          moveActorToPosition(r0, r1, r2);
          r3 = 0x4;
          r2 = 0x3;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          r0 = 0x4;
          r1 = 0x3b;
          r2 = 0x11;
          r3 = 0x26;
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }
      }
    }

    //LAB_200928c
    r0 = 0x80b;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xfc;
      r2 = 0x98;
      r0 = 0x9;
      r1 = r1 << 17;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r5 = 0x2;
      r6 = 0x1;
      r0 = 0x2;
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x2;
      r1 = 0x1e;
      r2 = 0x10;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x4;
      r2 = 0x3;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x0;
      r1 = 0x37;
      r2 = 0x20;
      r3 = 0x28;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20092dc
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xa2;
      r2 = 0x98;
      r0 = 0xb;
      r1 = r1 << 18;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r5 = 0x2;
      r6 = 0x1;
      r0 = 0x4;
      r1 = 0x1c;
      r2 = 0x24;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      r1 = 0x1e;
      r2 = 0x12;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x4;
      r2 = 0x3;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x4;
      r1 = 0x37;
      r2 = 0x24;
      r3 = 0x28;
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200932c
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xfc;
      r2 = 0xc8;
      r0 = 0xd;
      r1 = r1 << 17;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r5 = 0x1;
      r6 = 0x2;
      r0 = 0x2;
      r1 = 0x1d;
      r2 = 0x22;
      r3 = 0xb;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x2;
      r1 = 0x1f;
      r2 = 0x10;
      r3 = 0xb;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x0;
      r1 = 0x3a;
      r2 = 0x20;
      r3 = 0x2b;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200937a
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xa2;
      r2 = 0xc8;
      r0 = 0xf;
      r1 = r1 << 18;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r5 = 0x1;
      r6 = 0x2;
      r0 = 0x4;
      r1 = 0x1d;
      r2 = 0x24;
      r3 = 0xb;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = 0x4;
      r1 = 0x1f;
      r2 = 0x12;
      r3 = 0xb;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x4;
      r1 = 0x3a;
      r2 = 0x24;
      r3 = 0x2b;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20093c8
    r5 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r5 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x3) {
      r0 = 0x30a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x1;
        r1 = 0x0;
        r2 = 0x0;
        moveActorToPosition(r0, r1, r2);
        r0 = 0x5;
        r1 = 0x0;
        r2 = 0x0;
        moveActorToPosition(r0, r1, r2);
      } else {
        //LAB_2009420
        r0 = 0x109;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_2008150();
          r0 = 0x30a;
          setFlag(r0);
        }
      }
    }

    //LAB_2009434
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r5 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x4) {
      r0 = 0x30b;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x1;
        r1 = 0x0;
        r2 = 0x0;
        moveActorToPosition(r0, r1, r2);
        r0 = 0x5;
        r1 = 0x0;
        r2 = 0x0;
        moveActorToPosition(r0, r1, r2);
      } else {
        //LAB_2009462
        r0 = 0x109;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_2008614();
          r0 = 0x30b;
          setFlag(r0);
        }
      }
    }

    //LAB_2009476
    r0 = 0x814;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x8d;
      FUN_200a55c(r0);
      r0 = 0x80;
      r1 = 0x80;
      r2 = 0x80;
      r0 = r0 << 9;
      r1 = r1 << 9;
      r2 = r2 << 9;
      FUN_200a41c(r0, r1, r2);
      FUN_200a53c();
    }

    //LAB_200949a
    r0 = 0x0;
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    CPU.r8().value = r3;
    return r0;
  }

  @Method(0x20094b8)
  public static void FUN_20094b8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r1 = 0x80;
    r1 = r1 << 3;
    r0 = 0xe;
    r5 = 0x200aa50;
    r0 = mallocSlotBoard(r0, r1);
    r6 = r0;
    r1 = r6;
    r0 = 0x200a56c;
    FUN_200a3dc(r0, r1);
    r0 = getFreeVramSlot();
    r1 = 0x80;
    r2 = r6;
    r0 = allocateSpriteSlot(r0, r1, r2);
    r3 = 0xac;
    r3 = r3 << 8;
    r1 = 0x40004000;
    r2 = 0x0;
    r4 = 0x0;
    r0 = r0 | r3;

    //LAB_20094e8
    do {
      r3 = r5;
      MEMORY.ref(4, r3).setu(r4);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      r2 = r2 + 0x1;
      r5 = r5 + 0xc;
      MEMORY.ref(4, r3).setu(r0);
    } while((r2 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

    r0 = getFreeVramSlot();
    r2 = r6;
    r2 = r2 + 0x80;
    r1 = 0x80;
    r0 = allocateSpriteSlot(r0, r1, r2);
    r3 = 0xdc;
    r3 = r3 << 8;
    r1 = 0x40004000;
    r2 = 0x0;
    r4 = 0x0;
    r0 = r0 | r3;

    //LAB_2009512
    do {
      r3 = r5;
      MEMORY.ref(4, r3).setu(r4);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      r2 = r2 + 0x1;
      r5 = r5 + 0xc;
      MEMORY.ref(4, r3).setu(r0);
    } while((r2 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

    r0 = getFreeVramSlot();
    r3 = 0x80;
    r3 = r3 << 1;
    r2 = r6 + r3;
    r1 = 0x80;
    r0 = allocateSpriteSlot(r0, r1, r2);
    r3 = 0xc0;
    r3 = r3 << 4;
    r1 = 0x40004000;
    r2 = 0x0;
    r4 = 0x0;
    r0 = r0 | r3;

    //LAB_200953e
    do {
      r3 = r5;
      MEMORY.ref(4, r3).setu(r4);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      r2 = r2 + 0x1;
      r5 = r5 + 0xc;
      MEMORY.ref(4, r3).setu(r0);
    } while((r2 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

    freeSlot(14);
    setTickCallback(getRunnable(Map12Overlay_878c76c.class, "FUN_2008eb0"), 0xc80);
  }

  /**
   * Event list 0x200a80c handler 4
   */
  @Method(value = 0x2009574, ignoreExtraParams = true)
  public static void FUN_2009574() {
    int r0;
    final int r1;
    final int r2;

    r0 = 0x9;
    r1 = 0x1f;
    r2 = 0x9;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_2009c14();
    }
  }

  /**
   * Event list 0x200a80c handler 5
   */
  @Method(value = 0x200958c, ignoreExtraParams = true)
  public static void FUN_200958c() {
    int r0;
    final int r1;
    final int r2;

    r0 = 0xb;
    r1 = 0x28;
    r2 = 0x9;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_2009d14();
    }
  }

  /**
   * Event list 0x200a80c handler 6
   */
  @Method(value = 0x20095a4, ignoreExtraParams = true)
  public static void FUN_20095a4() {
    int r0;
    final int r1;
    final int r2;

    r0 = 0xd;
    r1 = 0x1f;
    r2 = 0xc;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_2009e10();
    }
  }

  /**
   * Event list 0x200a80c handler 7
   */
  @Method(value = 0x20095bc, ignoreExtraParams = true)
  public static void FUN_20095bc() {
    int r0;
    final int r1;
    final int r2;

    r0 = 0xf;
    r1 = 0x28;
    r2 = 0xc;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_2009f0c();
    }
  }

  /**
   * Event list 0x200a80c handler 13
   */
  @Method(value = 0x20095d4, ignoreExtraParams = true)
  public static void FUN_20095d4() {
    int r0;
    int r1;
    int r2;
    final int r3;

    r1 = 0xd0;
    r2 = 0xe0;
    r0 = 0x2;
    r1 = r1 << 16;
    r2 = r2 << 15;
    r3 = 0x0;
    FUN_200a424(r0, r1, r2, r3);
    r0 = 0xa;
    r1 = 0xe;
    r2 = 0x7;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_200a244();
    }
  }

  /**
   * Event list 0x200a80c handler 15
   */
  @Method(value = 0x20095fc, ignoreExtraParams = true)
  public static void FUN_20095fc() {
    int r0;
    int r1;
    int r2;
    final int r3;

    r1 = 0xb0;
    r2 = 0xe0;
    r0 = 0x2;
    r1 = r1 << 17;
    r2 = r2 << 15;
    r3 = 0x0;
    FUN_200a424(r0, r1, r2, r3);
    r0 = 0xc;
    r1 = 0x15;
    r2 = 0x7;
    r0 = mapActorIsAt(r0, r1, r2);
    if(r0 != 0x0) {
      FUN_200a2f4();
    }
  }

  /**
   * Event list 0x200a80c handler 26
   */
  @Method(value = 0x2009624, ignoreExtraParams = true)
  public static void FUN_2009624() {
    int r1;
    int r2;
    int r3;
    final int r5;

    final Actor70 r0 = getMapActor(0);
    r3 = r0.pos_08.getX();
    r5 = r3 >> 20;
    r3 = r0.pos_08.getZ();
    r3 = r3 >> 20;
    if(r3 == 0x8) {
      r3 = r5;
      r3 = r3 - 0x11;
      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
        r1 = 0x88;
        r2 = 0x80;
        r1 = r1 << 17;
        r2 = r2 << 16;
        r3 = 0xff;
        FUN_200a424(2, r1, r2, r3);
        r1 = 0x90;
        r2 = 0x80;
        r1 = r1 << 17;
        r2 = r2 << 16;
        r3 = 0xff;
        FUN_200a424(2, r1, r2, r3);
      }
    }
  }

  /**
   * Event list 0x200a80c handler 12
   */
  @Method(value = 0x200966c, ignoreExtraParams = true)
  public static void FUN_200966c() {
    int r1;
    int r2;
    int r3;
    final int r5;

    final Actor70 r0 = getMapActor(0);
    r3 = r0.pos_08.getX();
    r5 = r3 >> 20;
    r3 = r0.pos_08.getZ();
    r3 = r3 >> 20;
    if(r3 == 0x7) {
      r3 = r5;
      r3 = r3 - 0xd;
      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
        r1 = 0xd0;
        r2 = 0xe0;
        r1 = r1 << 16;
        r2 = r2 << 15;
        r3 = 0xff;
        FUN_200a424(2, r1, r2, r3);
      }
    }

    //LAB_200969e
  }

  /**
   * Event list 0x200a80c handler 14
   */
  @Method(value = 0x20096a4, ignoreExtraParams = true)
  public static void FUN_20096a4() {
    final Actor70 r0 = getMapActor(0);
    if(r0.pos_08.getZ() >> 20 == 7) {
      final int r5 = r0.pos_08.getX() >> 20;
      if(r5 >= 21 && r5 < 23) {
        FUN_200a424(2, 0x1600000, 0x700000, 0xff);
      }
    }

    //LAB_20096d6
  }

  /**
   * Event list 0x200a80c handler 27
   */
  @Method(value = 0x20096dc, ignoreExtraParams = true)
  public static void FUN_20096dc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    CPU.sp().value -= 0x8;
    r1 = 0x88;
    r2 = 0x80;
    final Actor70 r6 = getMapActor(17);
    r1 = r1 << 17;
    r0 = 0x2;
    r2 = r2 << 16;
    r3 = 0x0;
    FUN_200a424(r0, r1, r2, r3);
    r1 = 0x90;
    r2 = 0x80;
    r0 = 0x2;
    r1 = r1 << 17;
    r2 = r2 << 16;
    r3 = 0x0;
    FUN_200a424(r0, r1, r2, r3);
    if(r6 != null) {
      //LAB_200970e
      r5 = r6.pos_08.getZ();
      r5 = r5 >> 20;
      FUN_200a454();
      if(r5 == 0x8) {
        //LAB_200971c
        r0 = 0x207;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r3 = getMapActor(0).pos_08.getZ();
          r3 = r3 >> 19;
          if((r3 & 0xffff_ffffL) <= (0x11 & 0xffff_ffffL)) {
            r0 = 0x0;
            r1 = 0x121;
            r2 = 0x9e;
            FUN_200a494(r0, r1, r2);
            getMapActor(0).angle_06.set(0xc000);
          }
        }

        //LAB_200974a
        r0 = 0x816;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          //LAB_2009756
          r0 = 0x817;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            //LAB_2009762
            r0 = 0x818;
            setFlag(r0);
            r0 = 0x80;
            r1 = 0x80;
            r0 = r0 << 10;
            r1 = r1 << 7;
            FUN_200a514(r0, r1);
            r0 = 0x8f;
            r1 = 0x1;
            r2 = 0x92;
            r1 = -r1;
            r2 = r2 << 16;
            r3 = 0x1;
            r0 = r0 << 17;
            FUN_200a51c(r0, r1, r2, r3);
            FUN_200a524();
            r1 = 0xc0;
            r2 = 0x80;
            r2 = r2 << 9;
            getMapActor(17)._5a.and(~0x1);
            r1 = r1 << 10;
            r0 = 0x11;
            setActorVelocityScalerAndAcceleration(r0, r1, r2);
            r5 = 0x0;
            r6._55.set(0);
            r1 = 0x3;
            r0 = 0x11;
            setActorPriority(r0, r1);
            r0 = 0xbd;
            playSound(r0);
            r1 = 0x90;
            r1 = r1 << 1;
            r2 = 0xb2;
            r0 = 0x11;
            FUN_200a47c(r0, r1, r2);
            r0 = 0x8;
            FUN_200a44c(r0);
            r1 = 0x90;
            r2 = 0xb2;
            r0 = 0x12;
            r1 = r1 << 17;
            r2 = r2 << 16;
            moveActorToPosition(r0, r1, r2);
            r6.dest_38.set(0x80000000, 0x80000000, 0x80000000);
            r0 = 0x11;
            r1 = 0x0;
            r2 = 0x0;
            r6.pos_08.set(0, 0, 0);
            r6.velocity_24.set(0, 0, 0);
            moveActorToPosition(r0, r1, r2);
            r0 = 0x80;
            r1 = 0x80;
            r2 = 0x80;
            r1 = r1 << 9;
            r2 = r2 << 9;
            r0 = r0 << 9;
            FUN_200a41c(r0, r1, r2);
            r0 = 0xa;
            FUN_200a44c(r0);
            r0 = 0x8d;
            playSound(r0);
            r0 = 0xc0;
            r1 = 0xc0;
            r2 = 0x80;
            r1 = r1 << 10;
            r2 = r2 << 9;
            r0 = r0 << 10;
            FUN_200a41c(r0, r1, r2);
            r0 = 0xa;
            FUN_200a44c(r0);
            r0 = 0xa0;
            r1 = 0xa0;
            r2 = 0x80;
            r1 = r1 << 11;
            r2 = r2 << 9;
            r0 = r0 << 11;
            FUN_200a41c(r0, r1, r2);
            r0 = 0x23;
            FUN_200a44c(r0);
            r0 = 0x80;
            r1 = 0x80;
            r2 = 0x80;
            r1 = r1 << 11;
            r2 = r2 << 9;
            r0 = r0 << 11;
            FUN_200a41c(r0, r1, r2);
            r0 = 0x14;
            FUN_200a44c(r0);
            r0 = 0xc0;
            r1 = 0xc0;
            r2 = 0x80;
            r1 = r1 << 10;
            r2 = r2 << 9;
            r0 = r0 << 10;
            FUN_200a41c(r0, r1, r2);
            r0 = 0x1e;
            FUN_200a44c(r0);
            r0 = 0x80;
            r1 = 0x80;
            r2 = 0x80;
            r1 = r1 << 10;
            r2 = r2 << 9;
            r0 = r0 << 10;
            FUN_200a41c(r0, r1, r2);
            r0 = 0x28;
            FUN_200a44c(r0);
            r0 = 0x121;
            playSound(r0);
            r0 = 0x80;
            r1 = 0x80;
            r2 = 0x80;
            r1 = r1 << 9;
            r2 = r2 << 9;
            r0 = r0 << 9;
            FUN_200a41c(r0, r1, r2);
            r0 = 0xa;
            FUN_200a44c(r0);
            r0 = 0x1;
            r1 = 0x1;
            r1 = -r1;
            r2 = 0xe666;
            r0 = -r0;
            FUN_200a41c(r0, r1, r2);
            r0 = 0x3c;
            FUN_200a44c(r0);
            r0 = 0xbc;
            playSound(r0);
            r0 = 0x80b;
            r0 = readFlag(r0);
            if(r0 != 0x0) {
              r0 = 0x80c;
              r0 = readFlag(r0);
              if(r0 != 0x0) {
                r0 = 0x80d;
                r0 = readFlag(r0);
                if(r0 != 0x0) {
                  r0 = 0x80e;
                  r0 = readFlag(r0);
                  if(r0 != 0x0) {
                    r0 = 0x80f;
                    setFlag(r0);
                  }
                }
              }
            }

            //LAB_20098ec
            r0 = 0x28;
            FUN_200a44c(r0);
            r0 = 0x1038;
            r1 = 0x1;
            FUN_200a42c(r0, r1);
            r3 = 0x8;
            r5 = 0x11;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r0 = 0x0;
            r1 = 0x1;
            r2 = 0x2;
            r3 = 0x1;
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            FUN_200a40c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r3 = 0x7;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r0 = 0x11;
            r1 = 0x9;
            r2 = 0x2;
            r3 = 0x1;
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            FUN_200a40c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }
      }

      //LAB_2009920
      FUN_200a45c();
    }

    //LAB_2009924
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200a80c handler 28
   */
  @Method(value = 0x200995c, ignoreExtraParams = true)
  public static void FUN_200995c() {
    int r0;
    int r1;
    int r2;

    final Actor70 actor17 = getMapActor(17);
    if(actor17 != null) {
      if(actor17.pos_08.getZ() >> 20 == 8) {
        FUN_200a454();
        r0 = 0xb9;
        playSound(r0);
        r0 = 0x11;
        r1 = 0x3333;
        r2 = 0x1999;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r1 = 0x3333;
        r2 = 0x1999;
        r0 = 0x0;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        getMapActor(17)._5a.and(~0x1);
        r1 = 0x8;
        r0 = 0x0;
        setActorAnimationIfLoaded(r0, r1);
        FUN_200a47c(0, getMapActor(0).pos_08.getX() >> 16, 136);
        r1 = 0x90;
        r1 = r1 << 1;
        r2 = 0x78;
        r0 = 0x11;
        FUN_200a47c(r0, r1, r2);
        r0 = 0x11;
        FUN_200a49c(r0);
        r0 = 0x0;
        r1 = 0x1;
        setActorAnimationIfLoaded(r0, r1);
        FUN_200a45c();
      }
    }

    //LAB_20099d6
  }

  /**
   * Event list 0x200a80c handler 8
   */
  @Method(value = 0x20099e4, ignoreExtraParams = true)
  public static void FUN_20099e4() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0x9;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x9;
    r1 = 0x1f;
    r2 = 0x9;
    r3 = 0x1e;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_2009c14();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 9
   */
  @Method(value = 0x2009a04, ignoreExtraParams = true)
  public static void FUN_2009a04() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0x9;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xb;
    r1 = 0x28;
    r2 = 0x9;
    r3 = 0x29;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_2009d14();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 10
   */
  @Method(value = 0x2009a24, ignoreExtraParams = true)
  public static void FUN_2009a24() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0xc;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xd;
    r1 = 0x1f;
    r2 = 0xc;
    r3 = 0x1e;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_2009e10();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 11
   */
  @Method(value = 0x2009a44, ignoreExtraParams = true)
  public static void FUN_2009a44() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0xc;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xf;
    r1 = 0x28;
    r2 = 0xc;
    r3 = 0x29;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_2009f0c();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 17
   */
  @Method(value = 0x2009a64, ignoreExtraParams = true)
  public static void FUN_2009a64() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0x7;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xa;
    r1 = 0xe;
    r2 = 0x7;
    r3 = 0xd;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_200a244();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 18
   */
  @Method(value = 0x2009a84, ignoreExtraParams = true)
  public static void FUN_2009a84() {
    final Actor70 r0 = getMapActor(10);
    if(r0 != null) {
      final int r3 = r0.pos_08.getZ() >> 20;
      FUN_2009b44(10, 13, r3 + 1, 13, r3);
    }

    //LAB_2009aa4
  }

  /**
   * Event list 0x200a80c handler 20
   */
  @Method(value = 0x2009aac, ignoreExtraParams = true)
  public static void FUN_2009aac() {
    final Actor70 r0 = getMapActor(10);
    if(r0 != null) {
      final int r3 = r0.pos_08.getZ() >> 20;
      FUN_2009b44(10, 13, r3 - 1, 13, r3);
    }

    //LAB_2009acc
  }

  /**
   * Event list 0x200a80c handler 22
   */
  @Method(value = 0x2009ad4, ignoreExtraParams = true)
  public static void FUN_2009ad4() {
    final int r0;
    final int r1;
    final int r2;
    int r3;

    CPU.sp().value -= 0x4;
    r3 = 0x7;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xc;
    r1 = 0x15;
    r2 = 0x7;
    r3 = 0x16;
    FUN_2009b44(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    FUN_200a2f4();
    CPU.sp().value += 0x4;
  }

  /**
   * Event list 0x200a80c handler 23
   */
  @Method(value = 0x2009af4, ignoreExtraParams = true)
  public static void FUN_2009af4() {
    final Actor70 r0 = getMapActor(12);
    if(r0 != null) {
      final int r3 = r0.pos_08.getZ() >> 20;
      FUN_2009b44(12, 22, r3 + 1, 22, r3);
    }

    //LAB_2009b14
  }

  /**
   * Event list 0x200a80c handler 25
   */
  @Method(value = 0x2009b1c, ignoreExtraParams = true)
  public static void FUN_2009b1c() {
    final Actor70 r0 = getMapActor(12);
    if(r0 != null) {
      final int r3 = r0.pos_08.getZ() >> 20;
      FUN_2009b44(12, 22, r3 - 1, 22, r3);
    }

    //LAB_2009b3c
  }

  @Method(0x2009b44)
  public static void FUN_2009b44(int r0, int r1, int r2, int r3, final int a4) {
    int r5;
    int r6;

    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r6);
    CPU.push(r5);
    r6 = CPU.r8().value;
    CPU.push(r6);
    r6 = a4;
    CPU.r9().value = r0;
    r5 = r3;
    CPU.r8().value = r1;
    CPU.r10().value = r2;
    FUN_200a454();
    r0 = 0xb9;
    playSound(r0);
    r0 = CPU.r9().value;
    r1 = 0x3333;
    r2 = 0x1999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x3333;
    r2 = 0x1999;
    r0 = 0x0;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r5 = r5 << 4;
    r6 = r6 << 4;
    getMapActor(CPU.r9().value)._5a.and(~0x1);
    r1 = 0x8;
    r0 = 0x0;
    r5 = r5 + 0x8;
    r6 = r6 + 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r1 = r5;
    r2 = r6;
    r0 = 0x0;
    FUN_200a47c(r0, r1, r2);
    r3 = CPU.r8().value;
    r3 = r3 << 4;
    CPU.r8().value = r3;
    r3 = CPU.r10().value;
    r3 = r3 << 4;
    CPU.r10().value = r3;
    r3 = 0x8;
    CPU.r8().value = CPU.r8().value + r3;
    CPU.r10().value = CPU.r10().value + r3;
    r1 = CPU.r8().value;
    r2 = CPU.r10().value;
    r0 = CPU.r9().value;
    FUN_200a47c(r0, r1, r2);
    r0 = CPU.r9().value;
    FUN_200a49c(r0);
    r0 = 0x0;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    FUN_200a45c();
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x2009be8)
  public static int mapActorIsAt(final int mapActorIndex, final int x, final int z) {
    final Actor70 r0 = getMapActor(mapActorIndex);
    if(r0 == null) {
      //LAB_2009bfe
      return 0;
    }

    if(r0.pos_08.getX() >> 20 != x) {
      //LAB_2009bfe
      return 0;
    }

    //LAB_2009c02
    if(r0.pos_08.getZ() >> 20 != z) {
      return 0;
    }

    //LAB_2009c0e
    return 1;
  }

  @Method(0x2009c14)
  public static void FUN_2009c14() {
    final int r0;
    final int r1;
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
    r7 = 0x200a980;
    r3 = 0x0;
    MEMORY.ref(4, r7).setu(r3);
    r3 = 0x37;
    CPU.r9().value = r3;
    MEMORY.ref(4, r7 + 0x4).setu(r3);
    r3 = 0x4;
    CPU.lr().value = r3;
    MEMORY.ref(4, r7 + 0x10).setu(r3);
    r3 = 0x10;
    MEMORY.ref(4, r7 + 0x50).setu(r3);
    r3 = 0x80b;
    MEMORY.ref(4, r7 + 0x60).setu(r3);
    r3 = 0x80;
    r3 = r3 << 7;
    MEMORY.ref(4, r7 + 0x64).setu(r3);
    r3 = 0xfa;
    r6 = 0x28;
    r3 = r3 << 1;
    r4 = 0x20;
    CPU.r12().value = r6;
    MEMORY.ref(4, r7 + 0xc).setu(r6);
    MEMORY.ref(4, r7 + 0x68).setu(r3);
    r6 = 0x1c;
    r3 = 0x84;
    CPU.r10().value = r4;
    CPU.r11().value = r6;
    MEMORY.ref(4, r7 + 0x34).setu(r6);
    MEMORY.ref(4, r7 + 0x6c).setu(r3);
    r6 = CPU.r9().value;
    r3 = 0x8;
    MEMORY.ref(4, r7 + 0x8).setu(r4);
    MEMORY.ref(4, r7 + 0x70).setu(r3);
    r4 = 0x3;
    MEMORY.ref(4, r7 + 0x74).setu(r6);
    r3 = CPU.r10().value;
    r6 = CPU.r12().value;
    r2 = 0x2;
    r1 = 0xa;
    r0 = 0x1;
    r5 = 0x22;
    CPU.r8().value = r4;
    MEMORY.ref(4, r7 + 0x14).setu(r4);
    MEMORY.ref(4, r7 + 0x78).setu(r3);
    r4 = 0x1e;
    MEMORY.ref(4, r7 + 0x7c).setu(r6);
    r3 = 0x80;
    r6 = CPU.lr().value;
    MEMORY.ref(4, r7 + 0x18).setu(r2);
    MEMORY.ref(4, r7 + 0x1c).setu(r4);
    MEMORY.ref(4, r7 + 0x28).setu(r2);
    MEMORY.ref(4, r7 + 0x30).setu(r2);
    MEMORY.ref(4, r7 + 0x40).setu(r2);
    MEMORY.ref(4, r7 + 0x48).setu(r2);
    MEMORY.ref(4, r7 + 0x4c).setu(r4);
    MEMORY.ref(4, r7 + 0x58).setu(r2);
    MEMORY.ref(4, r7 + 0x20).setu(r5);
    MEMORY.ref(4, r7 + 0x24).setu(r1);
    MEMORY.ref(4, r7 + 0x2c).setu(r0);
    MEMORY.ref(4, r7 + 0x38).setu(r5);
    MEMORY.ref(4, r7 + 0x3c).setu(r1);
    MEMORY.ref(4, r7 + 0x44).setu(r0);
    MEMORY.ref(4, r7 + 0x54).setu(r1);
    MEMORY.ref(4, r7 + 0x5c).setu(r0);
    MEMORY.ref(4, r3 + r7).setu(r6);
    r6 = CPU.r8().value;
    r3 = 0x84;
    MEMORY.ref(4, r3 + r7).setu(r6);
    r3 = r7;
    r3 = r3 + 0x88;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r4 = CPU.r11().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r6 = 0x10;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r6);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    r2 = r7;
    MEMORY.ref(4, r3).setu(r0);
    r2 = r2 + 0xb8;
    r3 = 0x9;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xf4;
    r2 = r2 + 0x4;
    r3 = r3 << 1;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r2 + 0x4;
    r3 = 0x98;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009ff4();
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x2009d14)
  public static void FUN_2009d14() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r4;
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
    r7 = 0x200a980;
    r3 = 0x37;
    CPU.r10().value = r3;
    MEMORY.ref(4, r7 + 0x4).setu(r3);
    r3 = 0x3;
    CPU.r8().value = r3;
    MEMORY.ref(4, r7 + 0x14).setu(r3);
    r3 = 0x1c;
    CPU.r9().value = r3;
    MEMORY.ref(4, r7 + 0x34).setu(r3);
    r3 = 0x80c;
    MEMORY.ref(4, r7 + 0x60).setu(r3);
    r3 = 0x80;
    r3 = r3 << 7;
    MEMORY.ref(4, r7 + 0x64).setu(r3);
    r3 = 0x28e;
    MEMORY.ref(4, r7 + 0x68).setu(r3);
    r3 = 0x84;
    r6 = 0x28;
    MEMORY.ref(4, r7 + 0x6c).setu(r3);
    r3 = 0xc;
    CPU.lr().value = r6;
    MEMORY.ref(4, r7 + 0xc).setu(r6);
    MEMORY.ref(4, r7 + 0x70).setu(r3);
    r6 = 0x1e;
    r3 = CPU.r10().value;
    CPU.r11().value = r6;
    MEMORY.ref(4, r7 + 0x1c).setu(r6);
    MEMORY.ref(4, r7 + 0x4c).setu(r6);
    MEMORY.ref(4, r7 + 0x74).setu(r3);
    r6 = 0x12;
    r3 = r7;
    r2 = 0x4;
    r1 = 0x24;
    r0 = 0xa;
    r4 = 0x2;
    r5 = 0x1;
    CPU.r12().value = r6;
    MEMORY.ref(4, r7 + 0x50).setu(r6);
    r3 = r3 + 0x80;
    r6 = CPU.lr().value;
    MEMORY.ref(4, r7).setu(r2);
    MEMORY.ref(4, r7 + 0x10).setu(r2);
    MEMORY.ref(4, r7 + 0x18).setu(r2);
    MEMORY.ref(4, r7 + 0x30).setu(r2);
    MEMORY.ref(4, r7 + 0x48).setu(r2);
    MEMORY.ref(4, r7 + 0x7c).setu(r6);
    MEMORY.ref(4, r7 + 0x8).setu(r1);
    r6 = CPU.r8().value;
    MEMORY.ref(4, r7 + 0x20).setu(r1);
    MEMORY.ref(4, r7 + 0x24).setu(r0);
    MEMORY.ref(4, r7 + 0x28).setu(r4);
    MEMORY.ref(4, r7 + 0x2c).setu(r5);
    MEMORY.ref(4, r7 + 0x38).setu(r1);
    MEMORY.ref(4, r7 + 0x3c).setu(r0);
    MEMORY.ref(4, r7 + 0x40).setu(r4);
    MEMORY.ref(4, r7 + 0x44).setu(r5);
    MEMORY.ref(4, r7 + 0x54).setu(r0);
    MEMORY.ref(4, r7 + 0x58).setu(r4);
    MEMORY.ref(4, r7 + 0x5c).setu(r5);
    MEMORY.ref(4, r7 + 0x78).setu(r1);
    MEMORY.ref(4, r3).setu(r2);
    r3 = 0x84;
    MEMORY.ref(4, r3 + r7).setu(r6);
    r3 = r7;
    r3 = r3 + 0x88;
    MEMORY.ref(4, r3).setu(r2);
    r6 = CPU.r11().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r6);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r2 = CPU.r9().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r6 = CPU.r12().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r6);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r2 = r7;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r2 = r2 + 0xb8;
    r3 = 0xb;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xa6;
    r2 = r2 + 0x4;
    r3 = r3 << 2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r2 + 0x4;
    r3 = 0x98;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009ff4();
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x2009e10)
  public static void FUN_2009e10() {
    final int r0;
    final int r1;
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
    r7 = 0x200a980;
    r3 = 0x0;
    MEMORY.ref(4, r7).setu(r3);
    r3 = 0x3a;
    CPU.r10().value = r3;
    MEMORY.ref(4, r7 + 0x4).setu(r3);
    r3 = 0x4;
    CPU.lr().value = r3;
    MEMORY.ref(4, r7 + 0x10).setu(r3);
    r3 = 0x10;
    CPU.r11().value = r3;
    MEMORY.ref(4, r7 + 0x50).setu(r3);
    r3 = 0x80d;
    MEMORY.ref(4, r7 + 0x60).setu(r3);
    r3 = 0xc0;
    r3 = r3 << 8;
    MEMORY.ref(4, r7 + 0x64).setu(r3);
    r3 = 0xfa;
    r6 = 0x2b;
    r3 = r3 << 1;
    r4 = 0x20;
    CPU.r12().value = r6;
    MEMORY.ref(4, r7 + 0xc).setu(r6);
    MEMORY.ref(4, r7 + 0x68).setu(r3);
    r6 = 0x1d;
    r3 = 0xd8;
    CPU.r8().value = r4;
    CPU.r9().value = r6;
    MEMORY.ref(4, r7 + 0x34).setu(r6);
    MEMORY.ref(4, r7 + 0x6c).setu(r3);
    r6 = CPU.r10().value;
    r3 = 0x8;
    MEMORY.ref(4, r7 + 0x70).setu(r3);
    MEMORY.ref(4, r7 + 0x74).setu(r6);
    r3 = CPU.r8().value;
    r6 = CPU.r12().value;
    r2 = 0x2;
    r1 = 0x1;
    r0 = 0xb;
    r5 = 0x22;
    MEMORY.ref(4, r7 + 0x8).setu(r4);
    MEMORY.ref(4, r7 + 0x78).setu(r3);
    r4 = 0x1f;
    MEMORY.ref(4, r7 + 0x7c).setu(r6);
    r3 = 0x80;
    r6 = CPU.lr().value;
    MEMORY.ref(4, r7 + 0x18).setu(r2);
    MEMORY.ref(4, r7 + 0x1c).setu(r4);
    MEMORY.ref(4, r7 + 0x28).setu(r2);
    MEMORY.ref(4, r7 + 0x30).setu(r2);
    MEMORY.ref(4, r7 + 0x40).setu(r2);
    MEMORY.ref(4, r7 + 0x48).setu(r2);
    MEMORY.ref(4, r7 + 0x4c).setu(r4);
    MEMORY.ref(4, r7 + 0x58).setu(r2);
    MEMORY.ref(4, r7 + 0x14).setu(r1);
    MEMORY.ref(4, r7 + 0x20).setu(r5);
    MEMORY.ref(4, r7 + 0x24).setu(r0);
    MEMORY.ref(4, r7 + 0x2c).setu(r1);
    MEMORY.ref(4, r7 + 0x38).setu(r5);
    MEMORY.ref(4, r7 + 0x3c).setu(r0);
    MEMORY.ref(4, r7 + 0x44).setu(r1);
    MEMORY.ref(4, r7 + 0x54).setu(r0);
    MEMORY.ref(4, r7 + 0x5c).setu(r1);
    MEMORY.ref(4, r3 + r7).setu(r6);
    r3 = r7;
    r3 = r3 + 0x84;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r4 = CPU.r9().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r6 = CPU.r11().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r6);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    r2 = r7;
    MEMORY.ref(4, r3).setu(r1);
    r2 = r2 + 0xb8;
    r3 = 0xd;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xf4;
    r2 = r2 + 0x4;
    r3 = r3 << 1;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r2 + 0x4;
    r3 = 0xc8;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009ff4();
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x2009f0c)
  public static void FUN_2009f0c() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    r7 = 0x200a980;
    r3 = 0x3a;
    CPU.r8().value = r3;
    MEMORY.ref(4, r7 + 0x4).setu(r3);
    r3 = 0x2b;
    CPU.lr().value = r3;
    MEMORY.ref(4, r7 + 0xc).setu(r3);
    r3 = 0x1d;
    CPU.r10().value = r3;
    MEMORY.ref(4, r7 + 0x34).setu(r3);
    r3 = 0x12;
    CPU.r12().value = r3;
    MEMORY.ref(4, r7 + 0x50).setu(r3);
    r3 = 0x80e;
    MEMORY.ref(4, r7 + 0x60).setu(r3);
    r3 = 0xc0;
    r3 = r3 << 8;
    MEMORY.ref(4, r7 + 0x64).setu(r3);
    r3 = 0x28e;
    MEMORY.ref(4, r7 + 0x68).setu(r3);
    r3 = 0xd8;
    MEMORY.ref(4, r7 + 0x6c).setu(r3);
    r3 = 0xc;
    MEMORY.ref(4, r7 + 0x70).setu(r3);
    r3 = CPU.r8().value;
    MEMORY.ref(4, r7 + 0x74).setu(r3);
    r3 = CPU.lr().value;
    MEMORY.ref(4, r7 + 0x7c).setu(r3);
    r3 = r7;
    r2 = 0x4;
    r1 = 0x1;
    r0 = 0x24;
    r4 = 0xb;
    r5 = 0x2;
    r6 = 0x1f;
    r3 = r3 + 0x80;
    MEMORY.ref(4, r7).setu(r2);
    MEMORY.ref(4, r7 + 0x10).setu(r2);
    MEMORY.ref(4, r7 + 0x18).setu(r2);
    MEMORY.ref(4, r7 + 0x30).setu(r2);
    MEMORY.ref(4, r7 + 0x48).setu(r2);
    MEMORY.ref(4, r7 + 0x8).setu(r0);
    MEMORY.ref(4, r7 + 0x14).setu(r1);
    MEMORY.ref(4, r7 + 0x1c).setu(r6);
    MEMORY.ref(4, r7 + 0x20).setu(r0);
    MEMORY.ref(4, r7 + 0x24).setu(r4);
    MEMORY.ref(4, r7 + 0x28).setu(r5);
    MEMORY.ref(4, r7 + 0x2c).setu(r1);
    MEMORY.ref(4, r7 + 0x38).setu(r0);
    MEMORY.ref(4, r7 + 0x3c).setu(r4);
    MEMORY.ref(4, r7 + 0x40).setu(r5);
    MEMORY.ref(4, r7 + 0x44).setu(r1);
    MEMORY.ref(4, r7 + 0x4c).setu(r6);
    MEMORY.ref(4, r7 + 0x54).setu(r4);
    MEMORY.ref(4, r7 + 0x58).setu(r5);
    MEMORY.ref(4, r7 + 0x5c).setu(r1);
    MEMORY.ref(4, r7 + 0x78).setu(r0);
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r6);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r0);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r2 = CPU.r10().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r2 = CPU.r12().value;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r4);
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r5);
    r2 = r7;
    r3 = r3 + 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r2 = r2 + 0xb8;
    r3 = 0xf;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0xa6;
    r2 = r2 + 0x4;
    r3 = r3 << 2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r2 + 0x4;
    r3 = 0xc8;
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009ff4();
    r3 = CPU.pop();
    r5 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x2009ff4)
  public static void FUN_2009ff4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r3 = 0x0;
    CPU.sp().value -= 0x8;
    CPU.r8().value = r3;
    FUN_200a454();
    r0 = 0x80f;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      //LAB_200a010
      r0 = 0x80;
      r1 = 0x80;
      r0 = r0 << 10;
      r1 = r1 << 7;
      FUN_200a514(r0, r1);
      r0 = 0x90;
      r1 = 0x1;
      r2 = 0xac;
      r1 = -r1;
      r2 = r2 << 16;
      r3 = 0x1;
      r0 = r0 << 18;
      FUN_200a51c(r0, r1, r2, r3);
      FUN_200a524();
      r0 = 0xba;
      playSound(r0);
      r5 = 0x200a980;
      r6 = MEMORY.ref(4, r5 + 0x14).get();
      r4 = MEMORY.ref(4, r5 + 0x10).get();
      r0 = MEMORY.ref(4, r5).get();
      r1 = MEMORY.ref(4, r5 + 0x4).get();
      r2 = MEMORY.ref(4, r5 + 0x8).get();
      r3 = MEMORY.ref(4, r5 + 0xc).get();
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      MEMORY.ref(4, CPU.sp().value).setu(r4);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r7 = 0x0;
      r6 = r5;

      //LAB_200a052
      do {
        r0 = 0xf6;
        playSound(r0);
        r4 = MEMORY.ref(4, r6 + 0x28).get();
        r5 = MEMORY.ref(4, r6 + 0x2c).get();
        r1 = MEMORY.ref(4, r6 + 0x1c).get();
        r2 = MEMORY.ref(4, r6 + 0x20).get();
        r3 = MEMORY.ref(4, r6 + 0x24).get();
        r0 = MEMORY.ref(4, r6 + 0x18).get();
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x4;
        FUN_200a44c(r0);
        r0 = 0xf6;
        playSound(r0);
        r4 = MEMORY.ref(4, r6 + 0x40).get();
        r5 = MEMORY.ref(4, r6 + 0x44).get();
        r0 = MEMORY.ref(4, r6 + 0x30).get();
        r1 = MEMORY.ref(4, r6 + 0x34).get();
        r2 = MEMORY.ref(4, r6 + 0x38).get();
        r3 = MEMORY.ref(4, r6 + 0x3c).get();
        r7 = r7 + 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x4;
        FUN_200a44c(r0);
      } while(r7 != 0x14);

      r7 = 0x200a980;
      r4 = MEMORY.ref(4, r7 + 0x58).get();
      r5 = MEMORY.ref(4, r7 + 0x5c).get();
      r3 = MEMORY.ref(4, r7 + 0x54).get();
      r1 = MEMORY.ref(4, r7 + 0x4c).get();
      r2 = MEMORY.ref(4, r7 + 0x50).get();
      r0 = MEMORY.ref(4, r7 + 0x48).get();
      MEMORY.ref(4, CPU.sp().value).setu(r4);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r0 = MEMORY.ref(4, r7 + 0x60).get();
      setFlag(r0);
      r0 = FUN_2008054();
      r3 = 0x1;
      CPU.r8().value = r0;
      r3 = -r3;
      if(CPU.r8().value == r3) {
        r0 = 0x818;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          //LAB_200a0ce
          r1 = 0x1;
          r0 = 0x0;
          FUN_200a50c(r0, r1);
          final Actor70 actor0 = getMapActor(0);
          r3 = MEMORY.ref(4, r7 + 0x64).get();
          r1 = 0x80;
          r2 = 0x80;
          actor0.angle_06.set(r3);
          r1 = r1 << 10;
          r2 = r2 << 10;
          r0 = 0x0;
          setActorVelocityScalerAndAcceleration(r0, r1, r2);
          actor0._5a.and(~0x1);
          r1 = 0x4;
          r0 = 0x0;
          r2 = 0x0;
          FUN_200a4bc(r0, r1, r2);
          r1 = MEMORY.ref(4, r7 + 0x68).get();
          r2 = MEMORY.ref(4, r7 + 0x6c).get();
          r0 = 0x0;
          FUN_200a47c(r0, r1, r2);
          r4 = r7;
          r4 = r4 + 0x80;
          r5 = MEMORY.ref(4, r4).get();
          r4 = r4 + 0x4;
          r4 = MEMORY.ref(4, r4).get();
          r0 = MEMORY.ref(4, r7 + 0x70).get();
          r1 = MEMORY.ref(4, r7 + 0x74).get();
          r2 = MEMORY.ref(4, r7 + 0x78).get();
          r3 = MEMORY.ref(4, r7 + 0x7c).get();
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = r7;
          r3 = r3 + 0x88;
          r4 = r7;
          r0 = MEMORY.ref(4, r3).get();
          r4 = r4 + 0x98;
          r3 = r3 + 0x4;
          r1 = MEMORY.ref(4, r3).get();
          r5 = MEMORY.ref(4, r4).get();
          r3 = r3 + 0x4;
          r4 = r4 + 0x4;
          r2 = MEMORY.ref(4, r3).get();
          r4 = MEMORY.ref(4, r4).get();
          r3 = r3 + 0x4;
          r3 = MEMORY.ref(4, r3).get();
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = r7;
          r3 = r3 + 0xa0;
          r4 = r7;
          r0 = MEMORY.ref(4, r3).get();
          r4 = r4 + 0xb0;
          r3 = r3 + 0x4;
          r1 = MEMORY.ref(4, r3).get();
          r5 = MEMORY.ref(4, r4).get();
          r3 = r3 + 0x4;
          r2 = MEMORY.ref(4, r3).get();
          r4 = r4 + 0x4;
          r3 = r3 + 0x4;
          r4 = MEMORY.ref(4, r4).get();
          r3 = MEMORY.ref(4, r3).get();
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          r5 = r7;
          r5 = r5 + 0xb8;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          getMapActor(MEMORY.ref(4, r5).get())._5a.and(~0x1);
          r3 = r7;
          r3 = r3 + 0xbc;
          r1 = MEMORY.ref(4, r3).get();
          r3 = r3 + 0x4;
          r2 = MEMORY.ref(4, r3).get();
          r0 = MEMORY.ref(4, r5).get();
          FUN_200a484(r0, r1, r2);
          actor0._5a.or(0x1);
          r0 = MEMORY.ref(4, r7 + 0x60).get();
          clearFlag(r0);
        }
      } else {
        //LAB_200a1b0
        r3 = CPU.r8().value;
        if(r3 == 0x0) {
          r0 = 0x818;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            if(readFlag(0x80b) != 0x0 && readFlag(0x80d) != 0x0 && readFlag(0x80e) != 0x0) {
              if(readFlag(0x80f) == 0x0) {
                setFlag(0x80f);
                FUN_2008c8c();
              }
            } else {
              //LAB_200a1f4
              r0 = 0x812;
              r0 = readFlag(r0);
              if(r0 != 0x0) {
                r0 = 0x5;
                FUN_200a52c(r0);
                r3 = 0x1;
                CPU.r8().value = r3;
              }
            }
          }
        }
      }
    }

    //LAB_200a208
    r3 = CPU.r8().value;
    if(r3 == 0x1) {
      FUN_200a54c();
      FUN_200a554();
    }

    //LAB_200a216
    FUN_200a45c();
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x200a244)
  public static void FUN_200a244() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    FUN_200a454();
    r0 = 0x818;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x816;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x80;
        r1 = 0x80;
        r0 = r0 << 10;
        r1 = r1 << 7;
        FUN_200a514(r0, r1);
        r0 = 0x8f;
        r1 = 0x1;
        r2 = 0x92;
        r1 = -r1;
        r2 = r2 << 16;
        r3 = 0x1;
        r0 = r0 << 17;
        FUN_200a51c(r0, r1, r2, r3);
        FUN_200a524();
        r0 = 0xba;
        playSound(r0);
        r3 = 0x4;
        r2 = 0x3;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x0;
        r1 = 0x3b;
        r2 = 0xf;
        r3 = 0x26;
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x817;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = 0x8;
          r1 = 0x3c;
          r2 = 0x11;
          r3 = 0x27;
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_200a2b8
        r1 = 0x0;
        r2 = 0x0;
        r0 = 0x0;
        FUN_200a4f4(r0, r1, r2);
        r0 = 0x1e;
        FUN_200a44c(r0);
        r0 = 0x816;
        setFlag(r0);
        r0 = 0x817;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          FUN_2008098();
        }
      }
    }

    //LAB_200a2dc
    FUN_200a45c();
    CPU.sp().value += 0x8;
  }

  @Method(0x200a2f4)
  public static void FUN_200a2f4() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    FUN_200a454();
    r0 = 0x818;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x817;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x80;
        r1 = 0x80;
        r0 = r0 << 10;
        r1 = r1 << 7;
        FUN_200a514(r0, r1);
        r0 = 0x8f;
        r1 = 0x1;
        r2 = 0x92;
        r1 = -r1;
        r2 = r2 << 16;
        r3 = 0x1;
        r0 = r0 << 17;
        FUN_200a51c(r0, r1, r2, r3);
        FUN_200a524();
        r0 = 0xba;
        playSound(r0);
        r3 = 0x4;
        r2 = 0x3;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x4;
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x26;
        FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x816;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = 0x8;
          r1 = 0x3c;
          r2 = 0x11;
          r3 = 0x27;
          FUN_200a404(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_200a368
        r1 = 0x80;
        r1 = r1 << 8;
        r2 = 0x0;
        r0 = 0x0;
        FUN_200a4f4(r0, r1, r2);
        r0 = 0x1e;
        FUN_200a44c(r0);
        r0 = 0x817;
        setFlag(r0);
        r0 = 0x816;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          FUN_2008098();
        }
      }
    }

    //LAB_200a38e
    FUN_200a45c();
    CPU.sp().value += 0x8;
  }

  @Method(0x200a3a4)
  public static void FUN_200a3a4(int r0, int r1) {
    final int r5;

    r5 = r1;
    r1 = 0x0;
    FUN_200a4ec(r0, r1);
    r0 = r5;
    FUN_200a44c(r0);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200a3bc)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200a3c4)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#mallocSlotBoard_} */
  @Method(0x200a3cc)
  public static int mallocSlotBoard(final int slot, final int size) {
    return (int)MEMORY.call(0x8000148, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200a3d4)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#FUN_80001a0} */
  @Method(0x200a3dc)
  public static int FUN_200a3dc(final int src, final int dest) {
    return (int)MEMORY.call(0x80001a0, src, dest);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200a3e4)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#getFreeVramSlot_} */
  @Method(0x200a3ec)
  public static int getFreeVramSlot() {
    return (int)MEMORY.call(0x80001d0);
  }

  /** {@link GoldenSun#insertIntoRenderQueue_} */
  @Method(0x200a3f4)
  public static void insertIntoRenderQueue(final RenderPacket0c packet, final int z) {
    MEMORY.call(0x80001e8, packet, z);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200a3fc)
  public static void FUN_200a3fc() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200a404)
  public static void FUN_200a404(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200a40c)
  public static void FUN_200a40c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200a414)
  public static void FUN_200a414(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200a41c)
  public static void FUN_200a41c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009278} */
  @Method(0x200a424)
  public static void FUN_200a424(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8009278, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200a42c)
  public static void FUN_200a42c(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200a434)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200a43c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200a444)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200a44c)
  public static void FUN_200a44c(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200a454)
  public static void FUN_200a454() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200a45c)
  public static void FUN_200a45c() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200a464)
  public static int FUN_200a464(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200a46c)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200a474)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200a47c)
  public static void FUN_200a47c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200a484)
  public static void FUN_200a484(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200a48c)
  public static void FUN_200a48c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200a494)
  public static void FUN_200a494(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200a49c)
  public static void FUN_200a49c(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200a4a4)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200a4ac)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200a4b4)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200a4bc)
  public static void FUN_200a4bc(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200a4c4)
  public static void FUN_200a4c4(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200a4cc)
  public static void FUN_200a4cc(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200a4d4)
  public static void FUN_200a4d4(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200a4dc)
  public static void FUN_200a4dc(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200a4e4)
  public static Panel24 FUN_200a4e4(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200a4ec)
  public static void FUN_200a4ec(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200a4f4)
  public static void FUN_200a4f4(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200a4fc)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200a504)
  public static void FUN_200a504(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x200a50c)
  public static void FUN_200a50c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200a514)
  public static void FUN_200a514(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200a51c)
  public static void FUN_200a51c(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200a524)
  public static void FUN_200a524() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200a52c)
  public static void FUN_200a52c(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2a0} */
  @Method(0x200a534)
  public static int FUN_200a534() {
    return (int)MEMORY.call(0x808a2a0);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x200a53c)
  public static void FUN_200a53c() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200a544)
  public static void FUN_200a544() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200a54c)
  public static void FUN_200a54c() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200a554)
  public static void FUN_200a554() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x200a55c)
  public static void FUN_200a55c(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200a564)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
