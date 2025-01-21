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
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;

import static org.goldensun.CopiedSegment8000770.FUN_30003e0;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/** Inside Sol Sanctum portal when guardian appears */
public final class Map18Overlay_8791794 {
  private Map18Overlay_8791794() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    return 0x200b6d4;
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
    return 0x200b704;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    return 0x200b710;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    return 0x200b998;
  }

  @Method(0x2008054)
  public static void FUN_2008054() {
    final int r7 = MEMORY.ref(4, 0x3001ec4).get();
    FUN_200b4d4();
    MEMORY.ref(4, r7 + 0x40c).setu(0);
    playSound(0x8d);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    moveActorToPosition(0, 0xe80000, 0x9c0000);
    moveActorToPosition(1, 0xda0000, 0xac0000);
    FUN_200b59c(0, 0xb000, 0);
    FUN_200b59c(1, 0xd000, 0);
    moveActorToPosition(5, 0x1db0000, 0x14c0000);
    moveActorToPosition(9, 0x1eb0000, 0x14c0000);
    moveActorToPosition(11, 0x1cb0000, 0x15c0000);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    moveActorToPosition(13, 0x1d70000, 0x1320000);
    moveActorToPosition(14, 0x1df0000, 0x16a0000);
    setActorPriority(15, 1);
    FUN_200b5c4(0xe80000, -1, 0x9c0000, 0);
    FUN_200b464();
    final int r3 = MEMORY.ref(4, 0x3001ebc).get();
    MEMORY.ref(4, r3 + 0x1c8).setu(8);
    FUN_200b5fc();
    FUN_200b604();
    FUN_200b5ec(0x7fff, 0);
    FUN_200b5f4(4);
    FUN_200b4cc(4);
    FUN_200b5ec(0x10000, 0);
    FUN_200b5f4(4);
    FUN_200b4cc(4);
    FUN_2008f64();
    FUN_200b5ec(0x7fff, 0);
    FUN_200b5f4(4);
    FUN_200b4cc(16);
    playSound(0x90);
    FUN_200b5ec(0x10000, 0);
    FUN_200b5f4(4);
    FUN_200b4cc(4);
    FUN_200b5ec(0x7fff, 0);
    FUN_200b5f4(4);
    FUN_200b4cc(4);
    playSound(0x90);
    FUN_200b5ec(0x10000, 0);
    FUN_200b5f4(48);
    FUN_200b4cc(48);
    FUN_200b54c(0, 6, 0);
    FUN_200b54c(1, 6, 20);
    FUN_200ad48(1, 20, 20);
    FUN_200ad48(0, 20, 40);
    FUN_200b57c(0x10cd);
    FUN_200b594(11, 0, 20);
    FUN_200b58c(10, 0);
    FUN_200ad48(1, 20, 0);
    FUN_200b594(5, 0, 20);
    FUN_200ad48(0, 20, 0);
    FUN_200b594(14, 0, 20);
    FUN_200b594(9, 0, 20);
    FUN_200b564(0, 1, 0);
    FUN_200b4cc(40);
    FUN_200b554(0, 2);
    FUN_200b55c(1, 2);
    FUN_200b4cc(20);
    FUN_200b59c(0, 0xb000, 0);
    FUN_200b59c(1, 0xd000, 30);
    FUN_200ad48(1, 20, 0);
    FUN_200b554(0, 2);
    FUN_200b55c(1, 2);
    FUN_200b4cc(20);
    FUN_200ad48(0, 20, 20);
    FUN_200b484(getMapActor(15), 0);
    moveActorToPosition(15, 0x1450000, 0x12e0000);
    getMapActor(15)._55.set(5);
    MEMORY.ref(4, r7 + 0x40c).setu(1);
    playSound(0x121);
    FUN_200b494(-1, -1, 0xe666);
    FUN_200b49c();
    FUN_200b4cc(150);
    FUN_200b594(11, 0, 20);
    FUN_200b58c(5, 0);
    FUN_200b594(10, 0, 10);
    FUN_200b564(0, 1, 20);
    FUN_200b59c(0, 0x3000, 0);
    FUN_200b59c(1, 0x3000, 10);
    moveActorToPosition(5, 0x1db0000, 0x14c0000);
    moveActorToPosition(9, 0x1eb0000, 0x14c0000);
    moveActorToPosition(11, 0x1cb0000, 0x15c0000);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    moveActorToPosition(13, 0x1d70000, 0x1320000);
    moveActorToPosition(14, 0x1df0000, 0x16a0000);
    FUN_200b5bc(0x66666, 0xcccc);
    FUN_200b5c4(0x1480000, -1, 0x12b0000, 1);
    FUN_200b5cc();
    playSound(0xa7);
    FUN_200b5ec(0x205294, 2);
    FUN_200b5f4(20);
    sleep(20);
    FUN_200b5ec(0x10000, 2);
    FUN_200b5f4(20);
    FUN_200b4cc(200);
    FUN_200b584(0x1001);

    if(FUN_200b4e4(0, 0) == 0) {
      FUN_200b57c(0x10d6);
    } else {
      //LAB_2008418
      FUN_200b57c(0x10d7);
    }

    //LAB_200841e
    FUN_200b594(0x1001, 0, 80);
    FUN_200b57c(0x10d8);
    FUN_200b594(9, 0, 20);
    FUN_200ad48(1, 20, 0);
    MEMORY.ref(4, r7 + 0x40c).setu(0);
    playSound(0x8d);
    FUN_200b494(0x10000, 0x20000, 0x10000);
    FUN_200b4cc(80);
    MEMORY.ref(4, r7 + 0x40c).setu(1);
    playSound(0x121);
    FUN_200b494(-1, -1, 0xe666);
    FUN_200b49c();
    FUN_200ad48(0, 20, 60);
    FUN_200b594(14, 0, 30);
    FUN_200b59c(15, 0xa000, 40);
    FUN_200ad48(1, 20, 20);
    FUN_200ad48(0, 20, 20);
    FUN_200b594(0x1001, 0, 30);
    FUN_200b59c(15, 0x1000, 40);
    FUN_200ad48(1, 20, 20);
    FUN_200ad48(0, 20, 20);
    FUN_200b594(5, 0, 30);
    FUN_2009084();
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_20090c4"), 0xc80);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200935c"), 0xc80);
    FUN_200b4cc(240);
    FUN_200b594(10, 0, 30);
    moveActorToPosition(5, 0x1db0000, 0x14c0000);
    moveActorToPosition(9, 0x1eb0000, 0x14c0000);
    moveActorToPosition(11, 0x1cb0000, 0x15c0000);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    moveActorToPosition(13, 0x1d70000, 0x1320000);
    moveActorToPosition(14, 0x1df0000, 0x16a0000);
    FUN_200b59c(5, 0x8000, 0);
    FUN_200b59c(9, 0x8000, 0);
    FUN_200b59c(11, 0x8000, 0);
    FUN_200b59c(10, 0x8000, 0);
    FUN_200b59c(13, 0x8000, 0);
    FUN_200b59c(14, 0x8000, 0);
    final Actor70 actor5 = getMapActor(5);
    FUN_200b5c4(actor5.pos_08.getX() & 0xffff0000, -1, actor5.pos_08.getZ() & 0xffff0000, 1);
    FUN_200b5cc();
    FUN_200b4cc(40);
    FUN_200b55c(13, 2);
    FUN_200b4cc(20);
    FUN_200b58c(13, 0);
    FUN_200b55c(11, 2);
    FUN_200b594(11, 0, 10);
    setActorAnimationIfLoaded(14, 4);
    FUN_200b594(14, 0, 20);
    FUN_200b564(10, 11, 40);
    setActorAnimationIfLoaded(10, 4);
    FUN_200b594(10, 0, 10);
    FUN_200b5ac(5, 0x100, 0);
    FUN_200b59c(5, 0x3000, 40);
    FUN_200b594(0x4005, 0, 10);
    FUN_200b59c(10, 0xb000, 0);
    FUN_200b59c(11, 0xd000, 40);
    FUN_200b564(10, 11, 40);
    FUN_200b5ac(10, 0x105, 40);
    FUN_200b59c(10, 0xb000, 10);
    FUN_200b594(10, 0, 10);
    FUN_200b59c(10, 0x8000, 10);
    FUN_200b55c(11, 2);
    FUN_200b594(11, 0, 10);
    setActorAnimationIfLoaded(10, 3);
    FUN_200b594(10, 0, 40);
    FUN_200b59c(14, 0xb000, 60);
    setActorAnimationAndWaitUntilFinished(14, 3);
    FUN_200b594(14, 0, 10);
    FUN_200b59c(13, 0x3000, 0);
    FUN_200b59c(5, 0x3000, 0);
    FUN_200b59c(9, 0x5000, 0);
    FUN_200b59c(11, 0x3000, 0);
    FUN_200b59c(10, 0x5000, 20);
    FUN_200b59c(14, 0xd000, 20);
    setActorAnimationAndWaitUntilFinished(14, 4);
    FUN_200b594(14, 0, 10);
    FUN_200b5ac(13, 0x103, 0);
    setActorVelocityScalerAndAcceleration(13, 0x10000, 0x8000);
    FUN_200b524(13, 471, 314);
    FUN_200b554(13, 3);
    FUN_200b594(13, 0, 10);
    FUN_200b59c(14, 0xb000, 10);
    setActorAnimationIfLoaded(14, 4);
    FUN_200b594(14, 0, 10);
    FUN_200b554(13, 3);
    FUN_200b594(13, 0, 10);
    FUN_200b55c(9, 2);
    FUN_200b594(0x4009, 0, 10);
    FUN_200b59c(10, 0xb000, 20);
    FUN_200b594(10, 0, 30);
    FUN_200b59c(11, 0, 20);
    FUN_200b55c(11, 2);
    FUN_200b4cc(30);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200b4cc(30);
    FUN_200b59c(11, 0xd000, 30);
    setActorAnimationAndWaitUntilFinished(11, 4);
    FUN_200b4cc(10);
    FUN_200b594(11, 0, 10);
    FUN_200b59c(13, 0x5000, 20);
    FUN_200b55c(13, 2);
    FUN_200b4cc(20);
    FUN_200b564(10, 11, 0);
    FUN_200b4cc(30);
    setActorAnimationIfLoaded(10, 3);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200b59c(11, 0xd000, 0);
    FUN_200b59c(10, 0xb000, 0);
    FUN_200b4cc(40);
    FUN_200b55c(13, 1);
    FUN_200b4cc(30);
    FUN_200b59c(13, 0x8000, 0);
    FUN_200b4cc(40);
    FUN_200b5ac(13, 0x102, 0);
    FUN_200b4cc(60);
    FUN_200b59c(14, 0xb000, 0);
    FUN_200b4cc(30);
    setActorAnimationAndWaitUntilFinished(14, 4);
    FUN_200b594(0x200e, 0, 30);
    FUN_200b59c(9, 0xb000, 0);
    FUN_200b59c(5, 0xb000, 0);
    FUN_200b59c(13, 0x3000, 20);
    FUN_200b5ac(5, 0x102, 40);
    FUN_200b594(0x2005, 0, 40);
    FUN_200b5ac(13, 0x105, 60);
    setActorAnimationAndWaitUntilFinished(13, 3);
    FUN_200b5ac(10, 0x101, 0);
    FUN_200b5ac(11, 0x101, 60);
    FUN_200b55c(14, 2);
    FUN_200b594(14, 0, 60);
    setActorAnimationAndWaitUntilFinished(13, 3);
    FUN_200b4cc(40);
    FUN_200b5ac(5, 0x102, 0);
    FUN_200b5ac(9, 0x102, 40);
    FUN_200b564(10, 11, 20);
    setActorAnimationIfLoaded(10, 3);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200b4cc(20);
    setActorVelocityScalerAndAcceleration(10, 0x9999, 0x4ccc);
    setActorVelocityScalerAndAcceleration(11, 0x9999, 0x4ccc);
    FUN_200b51c(11, 475, 348);
    FUN_200b51c(10, 491, 348);
    FUN_200b52c(11);
    FUN_200b52c(10);
    setActorAnimationIfLoaded(11, 1);
    setActorAnimationIfLoaded(10, 1);
    FUN_200b59c(11, 0xd000, 0);
    FUN_200b59c(10, 0xb000, 0);
    FUN_200b59c(13, 0x3000, 10);
    FUN_200b5ac(11, 0x103, 0);
    FUN_200b55c(11, 2);
    FUN_200b58c(0x200b, 0);
    setActorVelocityScalerAndAcceleration(11, 0x19999, 0xcccc);
    setActorVelocityScalerAndAcceleration(5, 0x13333, 0x9999);
    FUN_200b524(11, 475, 338);
    final Actor70 actor11 = getMapActor(11);
    actor11._5a.and(~0x1);
    FUN_200b524(11, 475, 348);
    FUN_200b55c(5, 1);
    FUN_200b54c(5, 4, 0);
    FUN_200b524(5, 459, 316);
    setActorVelocityScalerAndAcceleration(5, 0x8000, 0x4000);
    FUN_200b5ac(13, 0x103, 0);
    FUN_200b554(13, 3);
    FUN_200b594(13, 0, 30);
    FUN_200b55c(11, 1);
    FUN_200b4cc(20);
    actor11._5a.or(0x1);
    setActorVelocityScalerAndAcceleration(11, 0x10000, 0x8000);
    FUN_200b524(11, 475, 332);
    FUN_200b59c(11, 0xb000, 20);
    FUN_200b58c(0x200b, 0);
    FUN_200b59c(10, 0xb000, 0);
    FUN_200b554(10, 2);
    FUN_200b594(10, 0, 20);
    FUN_200b5ac(11, 0x102, 20);
    FUN_200b59c(5, 0x3000, 0);
    FUN_200b59c(11, 0x3000, 20);
    setActorAnimationAndWaitUntilFinished(10, 4);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200b59c(11, 0xb000, 20);
    setActorAnimationAndWaitUntilFinished(11, 3);
    setActorAnimationAndWaitUntilFinished(13, 3);
    FUN_200b4cc(20);
    FUN_200b51c(5, 432, 316);
    FUN_200b524(13, 422, 311);
    setActorAnimationIfLoaded(5, 1);
    FUN_200b59c(5, 0x3000, 0);
    FUN_200b59c(13, 0x3000, 20);
    FUN_200b55c(10, 2);
    FUN_200b59c(10, 0xd000, 20);
    FUN_200b594(0x100a, 0, 40);
    FUN_200b55c(9, 2);
    FUN_200b4cc(20);
    FUN_200b59c(9, 0xb000, 30);
    setActorVelocityScalerAndAcceleration(9, 0x8000, 0x4000);
    FUN_200b524(9, 491, 296);
    FUN_200b59c(9, 0x5000, 40);
    setActorVelocityScalerAndAcceleration(10, 0x10000, 0x8000);
    setActorVelocityScalerAndAcceleration(11, 0x10000, 0x8000);
    setActorVelocityScalerAndAcceleration(13, 0x10000, 0x8000);
    setActorVelocityScalerAndAcceleration(14, 0x10000, 0x8000);
    FUN_200b524(10, 471, 308);
    FUN_200b59c(10, 0x5000, 0);
    FUN_200b524(11, 455, 308);
    FUN_200b59c(11, 0x3000, 0);
    FUN_200b524(14, 487, 308);
    FUN_200b59c(10, 0xc000, 0);
    FUN_200b59c(11, 0xd000, 0);
    FUN_200b59c(14, 0xb000, 0);
    FUN_200b59c(5, 0xd000, 0);
    FUN_200b59c(13, 0xd000, 0);
    FUN_200b5bc(0x8000, 0x1000);
    FUN_200b5c4(0x1d80000, -1, 0x12c0000, 1);
    FUN_200b5cc();
    FUN_200b4cc(40);
    setFlag(0x246);
    setActorVelocityScalerAndAcceleration(10, 0x8000, 0x4000);
    setActorVelocityScalerAndAcceleration(11, 0x8000, 0x4000);
    setActorVelocityScalerAndAcceleration(14, 0x8000, 0x4000);
    setActorAnimationAndWaitUntilFinished(10, 3);
    FUN_2008e30(10);
    FUN_200b55c(9, 2);
    FUN_2008e30(9);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_2008e30(11);
    FUN_200b59c(5, 0x9000, 40);
    FUN_200b554(5, 2);
    FUN_200b594(0x2005, 0, 40);
    FUN_200b59c(13, 0x3000, 0);
    FUN_200b59c(5, 0xb000, 30);
    FUN_200b59c(13, 0xe000, 0);
    FUN_2008e30(5);
    FUN_2008e30(13);
    FUN_200b59c(14, 0x7000, 40);
    FUN_200b594(14, 0, 30);
    setActorAnimationAndWaitUntilFinished(14, 4);
    FUN_200b4cc(20);
    FUN_200b594(14, 0, 30);
    FUN_2008e30(14);
    FUN_2009410();
    removeCharAndHealRemainingChars(5);
  }

  @Method(0x2008e30)
  public static void FUN_2008e30(final int r0) {
    final Actor70 r8 = getMapActor(8);
    r8.scale_18.set(0x10000);
    r8._1c.set(0x10000);
    FUN_200b524(r0, 471, 290);
    FUN_200b59c(r0, 0xc000, 0);
    FUN_200b4cc(10);
    moveActorToPosition(8, 0x1d70000, 0x1220000);
    final Actor70 r5 = getMapActor(r0);
    FUN_200b484(r5, 0);
    FUN_200b56c(r0, 0x100);
    r5._55.set(0);
    playSound(0xc9);

    //LAB_2008ea2
    for(int i = 0; i < 60; i++) {
      r5.pos_08.y_04.add(0x8000);
      FUN_200b4cc(1);
    }

    playSound(0xbe);

    //LAB_2008ec6
    for(int i = 0; i < 90; i++) {
      r5.pos_08.y_04.add(0x1999);
      r5.scale_18.sub(0x28f);
      r5._1c.sub(0x28f);
      r8.scale_18.sub(0x28f);
      r8._1c.sub(0x28f);
      FUN_200b4cc(1);
    }

    moveActorToPosition(r0, 0, 0);
    moveActorToPosition(8, 0, 0);
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008f30)
  public static int init() {
    if(entranceId_2000402.get() == 10) {
      FUN_200b5e4();
      FUN_2008054();
    }

    //LAB_2008f4a
    return 0;
  }

  @Method(0x2008f54)
  public static int FUN_2008f54(final Actor70 r0) {
    r0.sprite_50.deref().rotation_1e.set(r0.angle_06.get() + 0x4000);
    return 1;
  }

  @Method(0x2008f64)
  public static void FUN_2008f64() {
    //LAB_2008f6e
    for(int i = 16; i < 32; i++) {
      final Actor70 r5 = getMapActor(i);
      FUN_200b504(i);
      FUN_200b484(r5, 0);
      setActorAnimation(r5, 2);
      final Sprite38 r1 = r5.sprite_50.deref();
      r1.packet_00.attribs_04.attrib2_04.and(~0xc00);
      r5._55.set(0);
      r5.velocityScalar_30.set(0x80000);
      r5.acceleration_34.set(0xc000);
      r5.scale_18.set(0x1cccc);
      r5._1c.set(0x1cccc);
      r5.pos_08.set(0xe80000, 0x140000, 0x840000);
    }

    playSound(0x91);

    //LAB_2008fd8
    for(int i = 0; i < 16; i++) {
      final Actor70 r6 = getMapActor(16 + i);
      final Sprite38 r2 = r6.sprite_50.deref();
      r2.rotation_1e.set((i << 12) - 0x4000);
      moveActorTo(r6, r6.pos_08.getX() + mul16(cos(i << 12), 0x1000000), r6.pos_08.getY(), r6.pos_08.getZ() + mul16(sin(i << 12), 0x1000000));
    }

    FUN_200b4cc(20);
    FUN_200b52c(16);

    //LAB_200903e
    for(int i = 16; i < 32; i++) {
      final Actor70 r5 = getMapActor(i);
      FUN_200b504(i);
      r5.pos_08.zero();
      r5.scale_18.set(0x10000);
      r5._1c.set(0x10000);
      r5.velocity_24.zero();
      r5.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    }
  }

  @Method(0x2009084)
  public static void FUN_2009084() {
    MEMORY.ref(4, 0x200bb68).setu(0x3f);
    MEMORY.ref(4, 0x200bb00).setu(0);
    MEMORY.ref(4, 0x200bb6c).setu(0);
    MEMORY.ref(4, 0x200bb70).setu(120);

    //LAB_20090a2
    for(int r3 = 0; r3 < 16; r3++) {
      MEMORY.ref(4, 0x200bac0 + r3 * 0x4).setu(0);
    }
  }

  @Method(0x20090c4)
  public static void FUN_20090c4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001ec4;
    r5 = MEMORY.ref(4, r3).get();
    r3 = 0x200bb00;
    r1 = 0xa;
    r0 = MEMORY.ref(4, r3).get();
    r0 = divideU(r0, r1);
    if(r0 != 0x0) {
      r1 = 0x40c;
      r2 = 0x0;
      r3 = r5 + r1;
      MEMORY.ref(4, r3).setu(r2);
      r1 = r0 << 16;
      r2 = 0x80;
      r0 = r1;
      r2 = r2 << 9;
      FUN_200b494(r0, r1, r2);
    } else {
      //LAB_20090fc
      r3 = 0x40c;
      r0 = 0x1;
      r2 = r5 + r3;
      r1 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = -r0;
      r1 = -r1;
      r2 = 0xe666;
      FUN_200b494(r0, r1, r2);
    }

    //LAB_2009112
    r2 = 0x200bb00;
    r3 = MEMORY.ref(4, r2).get();
    if(r3 != 0x0) {
      r3 = r3 - 0x3;
      MEMORY.ref(4, r2).setu(r3);
    }

    //LAB_200911e
    r1 = 0x200bac0;
    r0 = 0x0;
    CPU.r8().value = r0;
    CPU.r10().value = r1;
    r2 = 0x0;

    //LAB_2009128
    do {
      r3 = CPU.r8().value;
      r6 = r3 << 2;
      r0 = CPU.r10().value;
      r3 = MEMORY.ref(4, r0 + r6).get();
      if(r3 != 0x0) {
        final Actor70 actor = getMapActor(CPU.r8().value + 0x10);
        if(actor.dest_38.getX() == 0x80000000 && actor.dest_38.getZ() == 0x80000000) {
          r0 = CPU.r10().value;
          r3 = MEMORY.ref(4, r0 + r6).get();
          r3 = r3 + 0x1;
          MEMORY.ref(4, r0 + r6).setu(r3);
          if(r3 == 0x2) {
            setActorAnimation(actor, 3);
          }

          //LAB_2009168
          r3 = MEMORY.ref(4, CPU.r10().value + r6).get();
          if(r3 == 19) {
            actor.pos_08.zero();
            actor.velocity_24.zero();
            actor.dest_38.set(0x80000000, 0x80000000, 0x80000000);
            FUN_200b574(actor, 15);
            //LAB_2009190
          } else if(r3 == 20) {
            MEMORY.ref(4, CPU.r10().value + r6).setu(r2);
          }
        }
      }

      //LAB_2009198
      r3 = CPU.r8().value;
      r3 = r3 + 0x1;
      r3 = r3 << 24;
      r3 = r3 >>> 24;
      CPU.r8().value = r3;
    } while((r3 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL));

    r3 = 0x200bb68;
    r0 = 0x3e7;
    r2 = MEMORY.ref(4, r3).get();
    if(r2 != r0) {
      //LAB_20091b2
      r3 = 0x3001e40;
      r3 = MEMORY.ref(4, r3).get();
      r3 = r3 & r2;
      if(r3 == 0x0) {
        //LAB_20091be
        r2 = 0x3000118;
        r1 = 0x0;
        r6 = 0x200bac0;
        CPU.r8().value = r1;
        CPU.r9().value = r2;

        //LAB_20091c8
        do {
          CPU.r11().value = (short)FUN_30003e0(rand(), 0xffff);
          r3 = CPU.r8().value;
          r5 = r3 << 2;
          final Actor70 r7 = getMapActor(CPU.r8().value + 0x10);
          r0 = MEMORY.ref(4, r6 + r5).get();
          CPU.r10().value = r0;
          if(r0 == 0x0) {
            //LAB_20091f0
            r0 = 0x246;
            r0 = readFlag(r0);
            if(r0 == 0x0) {
              r0 = 0xf6;
              playSound(r0);
            }

            //LAB_2009200
            r3 = 0x1;
            MEMORY.ref(4, r6 + r5).setu(r3);
            r1 = CPU.r10().value;
            r7._55.set(r1);
            r7.velocityScalar_30.set(0x80000);
            r7.acceleration_34.set(0x10000);
            FUN_200b484(r7, 0);
            r7.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
            setActorAnimation(r7, 2);
            setActorSpriteScript(r7, 0x200ba00);
            r1 = CPU.r11().value;
            r6 = r1 << 16;
            r6 = r6 >>> 16;
            r0 = r6;
            r0 = cos(r0);
            r5 = r0;
            r0 = rand();
            r1 = r0;
            r1 = r1 << 8;
            r1 = r1 >>> 16;
            r2 = 0x80;
            r2 = r2 << 17;
            r1 = r1 << 16;
            r0 = r5;
            r1 = r1 + r2;
            r0 = (int)MEMORY.call(CPU.r9().value, r0, r1);
            r3 = 0x1450000;
            r0 = r0 + r3;
            r7.pos_08.setX(r0);
            r0 = CPU.r10().value;
            r7.pos_08.setY(r0);
            r0 = r6;
            r0 = sin(r0);
            r5 = r0;
            r0 = rand();
            r1 = r0;
            r1 = r1 << 8;
            r1 = r1 >>> 16;
            r2 = 0x80;
            r2 = r2 << 17;
            r1 = r1 << 16;
            r0 = r5;
            r1 = r1 + r2;
            r0 = (int)MEMORY.call(CPU.r9().value, r0, r1);
            r3 = 0x97;
            r3 = r3 << 17;
            r0 = r0 + r3;
            r7.pos_08.setZ(r0);
            r0 = r6;
            r0 = cos(r0);
            r5 = r0;
            r0 = rand();
            r1 = r0;
            r0 = 0x3f;
            r1 = r1 & r0;
            r2 = 0x80;
            r2 = r2 << 12;
            r1 = r1 << 16;
            r0 = r5;
            r1 = r1 + r2;
            r0 = (int)MEMORY.call(CPU.r9().value, r0, r1);
            r5 = r0;
            r0 = r6;
            r0 = sin(r0);
            r6 = r0;
            r0 = rand();
            r3 = 0x3f;
            r1 = r0;
            r1 = r1 & r3;
            r2 = 0x80;
            r2 = r2 << 12;
            r1 = r1 << 16;
            r0 = r6;
            r1 = r1 + r2;
            r0 = (int)MEMORY.call(CPU.r9().value, r0, r1);
            r5 = r5 + 0x1450000;
            r3 = r0 + 0x11e0000;
            moveActorTo(r7, r5, 0, r3);
            FUN_200b574(r7, 0);
            r2 = 0x200bb00;
            r3 = 0x1e;
            MEMORY.ref(4, r2).setu(r3);
            break;
          }

          //LAB_2009304
          r3 = CPU.r8().value;
          r3 = r3 + 0x1;
          r3 = r3 << 24;
          r3 = r3 >>> 24;
          CPU.r8().value = r3;
          if((r3 & 0xffff_ffffL) > (0xf & 0xffff_ffffL)) {
            break;
          }
        } while(true);
      }
    }

    //LAB_2009314
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x200935c)
  public static void FUN_200935c() {
    int r0;
    int r2;
    int r3;
    int r5;

    r2 = 0x200bb70;
    r3 = MEMORY.ref(4, r2).get();
    if(r3 != 0x0) {
      r3 = r3 - 0x1;
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_200936c
      r5 = 0x200bb6c;
      r3 = MEMORY.ref(4, r5).get();
      if(r3 != 0x0) {
        r3 = r3 - 0x1;
        MEMORY.ref(4, r5).setu(r3);
      } else {
        //LAB_200937a
        r0 = rand();
        r0 = r0 << 2;
        r0 = r0 >>> 16;
        MEMORY.ref(4, r5).setu(r0);
      }

      //LAB_2009384
      r3 = 0x200bb6c;
      r2 = MEMORY.ref(4, r3).get();
      if(r2 == 0x2) {
        //LAB_20093b0
        r2 = 0x200bb68;
        r3 = 0xf;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x200bb70;
        r0 = rand();
        r3 = r0 << 2;
        r3 = r3 + r0;
        r3 = r3 << 3;
        r3 = r3 >>> 16;
        r3 = r3 + 0x50;
      } else if(r2 == 0x1) {
        //LAB_20093c8
        r2 = 0x200bb68;
        r3 = 0x3f;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x200bb70;
        r0 = rand();
        r3 = r0 << 2;
        r3 = r3 + r0;
        r3 = r3 << 4;
        r3 = r3 >>> 16;
        r3 = r3 + 0xa0;
      } else if(r2 == 0x3) {
        r3 = 0x200bb68;
        MEMORY.ref(4, r3).setu(r2);
        r5 = 0x200bb70;
        r0 = rand();
        r3 = r0 << 2;
        r3 = r3 + r0;
        r3 = r3 << 2;
        r3 = r3 >>> 16;
        r3 = r3 + 0x28;
      } else {
        //LAB_20093e0
        r2 = 0x200bb68;
        r3 = 0x7f;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x200bb70;
        r0 = rand();
        r3 = r0 << 2;
        r3 = r3 + r0;
        r3 = r3 << 5;
        r2 = 0xa0;
        r3 = r3 >>> 16;
        r2 = r2 << 1;
        r3 = r3 + r2;
      }

      //LAB_20093fa
      MEMORY.ref(4, r5).setu(r3);
    }
  }

  @Method(0x2009410)
  public static void FUN_2009410() {
    Actor70 r0;

    final int r9 = MEMORY.ref(4, 0x3001ec4).get();
    final Actor70 r10 = getMapActor(15);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200935c"));
    MEMORY.ref(4, 0x200bb68).setu(3);
    FUN_200b4cc(80);
    playSound(17);
    FUN_200b5ec(0x7fff, 0);
    FUN_200b5f4(40);
    FUN_200b4cc(40);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_20090c4"));

    //LAB_200945e
    for(int i = 0; i < 16; i++) {
      moveActorToPosition(16 + i, 0, 0);
    }

    sleep(1);
    moveActorToPosition(15, 0, 0);
    FUN_200a820(0);
    FUN_200a820(1);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    FUN_200b4cc(80);
    FUN_200ac9c();
    r0 = FUN_200b5d4();
    r0._55.set(0);
    r0.pos_08.set(0xe70000, 0, 0x900000);
    r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    r0.velocity_24.setX(0);
    r0.velocity_24.setZ(0);
    sleep(4);
    FUN_200b464();
    sleep(4);
    setActorPriority(0, 3);
    setActorPriority(1, 3);
    FUN_200b5ec(0x10000, 0);
    FUN_200b5f4(40);
    FUN_200b4cc(40);
    final Actor70 r8 = getMapActor(0);
    final Actor70 r6 = getMapActor(1);
    final Sprite38 r2 = r8.sprite_50.deref();
    final Sprite38 r7 = r6.sprite_50.deref();

    //LAB_2009528
    for(int i = 0; i < 20; i++) {
      r2.rotation_1e.add(0x100);
      r7.rotation_1e.sub(0x100);
      r8.pos_08.x_00.add(0x6000);
      r6.pos_08.x_00.sub(0x6000);
      sleep(1);
    }

    FUN_200b4cc(40);
    setActorVelocityScalerAndAcceleration(0, 0x20000, 0x10000);
    setActorVelocityScalerAndAcceleration(1, 0x20000, 0x10000);
    r0 = getMapActor(0);
    r0.sprite_50.deref().rotation_1e.set(0);
    r0 = getMapActor(1);
    r0.sprite_50.deref().rotation_1e.set(0);
    FUN_200b54c(0, 6, 0);
    FUN_200b54c(1, 6, 0);
    FUN_200b50c(0, 246, 150);
    FUN_200b514(1, 220, 150);
    setActorPriority(0, 2);
    setActorPriority(1, 2);
    getMapActor(0).flags_23.or(0x1);
    getMapActor(1).flags_23.or(0x1);
    FUN_200b504(0);
    FUN_200b504(1);
    FUN_200b59c(0, 0x2000, 0);
    FUN_200b4cc(20);
    FUN_200b59c(1, 0xe000, 0);
    FUN_200b4cc(40);
    FUN_200b59c(0, 0x9000, 0);
    FUN_200b4cc(40);
    FUN_200b59c(1, 0x5000, 0);
    FUN_200b4cc(80);
    FUN_200b59c(0, 0x8000, 0);
    FUN_200b4cc(10);
    FUN_200b59c(1, 0x1000, 0);
    FUN_200b4cc(60);
    FUN_200b55c(1, 2);
    FUN_200b57c(0x10f8);
    FUN_200b584(1);

    if(FUN_200b4e4(0, 0) == 0) {
      setActorAnimationAndWaitUntilFinished(1, 3);
      FUN_200b57c(0x10f9);
    } else {
      //LAB_2009696
      FUN_200b55c(1, 1);
      FUN_200b57c(0x10fa);
    }

    //LAB_20096a4
    FUN_200b594(1, 0, 60);
    FUN_200b59c(1, 0x3000, 0);
    FUN_200b4cc(40);
    FUN_200b54c(1, 2, 0);
    FUN_200b5ac(1, 0x102, 0);
    FUN_200b4cc(40);
    FUN_200b57c(0x10fb);
    FUN_200b594(1, 0, 10);
    FUN_200b54c(0, 2, 0);
    FUN_200b4cc(10);
    FUN_200b59c(0, 0x2000, 0);
    FUN_200b4cc(60);
    FUN_200b5ac(0, 0x102, 0);
    FUN_200b4cc(80);
    FUN_200b59c(1, 0x1000, 0);
    FUN_200b4cc(10);
    FUN_200b55c(1, 2);
    FUN_200b584(1);

    if(FUN_200b4e4(0, 0) == 0) {
      FUN_200b4cc(10);
      FUN_200b55c(1, 2);
      FUN_200b4cc(10);
      FUN_200b59c(1, 0x3000, 0);
      FUN_200b4cc(60);
      FUN_200b59c(1, 0x1000, 0);
      FUN_200b4cc(10);
      setActorAnimationIfLoaded(1, 4);
      FUN_200b57c(0x10fd);
    } else {
      //LAB_20097c0
      FUN_200b4cc(10);
      FUN_200b55c(1, 2);
      FUN_200b4cc(10);
      FUN_200b59c(1, 0x3000, 0);
      FUN_200b4cc(60);
      FUN_200b59c(1, 0x1000, 0);
      FUN_200b4cc(10);
      setActorAnimationIfLoaded(1, 4);
      FUN_200b57c(0x10fe);
    }

    //LAB_2009806
    FUN_200b594(1, 0, 40);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200b4cc(40);
    FUN_200b59c(0, 0x8000, 0);
    FUN_200b59c(1, 0x7000, 0);
    FUN_200b5bc(0x20000, 0x4000);
    FUN_200b5c4(0x11c0000, -1, 0x5c0000, 1);
    FUN_200b5cc();
    FUN_200b4cc(20);
    FUN_200b59c(0, 0x6000, 0);
    FUN_200b59c(1, 0x5000, 0);
    FUN_200b5bc(0x18000, 0x3000);
    FUN_200b5c4(0x7f0000, -1, 0xa20000, 1);
    FUN_200b5cc();
    FUN_200b4cc(40);
    FUN_200b59c(0, 0x2000, 0);
    FUN_200b59c(1, 0x3000, 0);
    FUN_200b5bc(0x40000, 0x8000);
    FUN_200b5c4(0x1300000, -1, 0x1260000, 1);
    FUN_200b5cc();
    FUN_200b4cc(20);
    FUN_200b59c(0, 0, 0);
    FUN_200b59c(1, 0x1000, 0);
    FUN_200b5bc(0x10000, 0x2000);
    FUN_200b5c4(0x1900000, -1, 0xd70000, 1);
    FUN_200b5cc();
    FUN_200b4cc(60);
    FUN_200b5bc(0x40000, 0x8000);
    FUN_200b5c4(0x1110000, -1, 0x910000, 1);
    FUN_200b5cc();
    FUN_200b4cc(20);
    FUN_200b55c(1, 2);
    FUN_200b57c(0x10ff);
    FUN_200b594(1, 0, 20);
    FUN_200b59c(1, 0x3000, 0);
    FUN_200b4cc(40);
    FUN_200b59c(1, 0xd000, 0);
    FUN_200b4cc(20);
    FUN_200b59c(1, 0xf000, 0);
    FUN_200b4cc(60);
    FUN_200b59c(1, 0x3000, 0);
    FUN_200b4cc(40);
    FUN_200b59c(1, 0xf000, 0);
    FUN_200b4cc(10);
    FUN_200b594(1, 0, 10);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200b4cc(10);
    playSound(0x17);
    FUN_200ad48(1, 4, 0);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x50000, 0x50000, 0x10000);
    FUN_200b4cc(10);
    FUN_200ad48(0, 40, 0);
    setActorVelocityScalerAndAcceleration(0, 0x20000, 0x10000);
    setActorVelocityScalerAndAcceleration(1, 0x20000, 0x10000);
    FUN_200b54c(0, 6, 0);
    FUN_200b54c(1, 6, 0);
    FUN_200b50c(0, 243, 144);
    FUN_200b50c(1, 202, 144);
    FUN_200b52c(0);
    FUN_200b4cc(20);
    MEMORY.ref(4, r9 + 0x40c).setu(1);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    FUN_200b4cc(60);
    FUN_200b5ac(0, 0x102, 0);
    FUN_200b5ac(1, 0x102, 0);
    FUN_200b4cc(80);
    setActorVelocityScalerAndAcceleration(0, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(1, 0x6666, 0x3333);
    FUN_200b51c(1, 220, 150);
    FUN_200b524(0, 246, 150);
    setActorAnimationIfLoaded(1, 1);
    FUN_200b59c(0, 0x8000, 0);
    FUN_200b59c(1, 0x7000, 0);
    FUN_200b4cc(60);
    FUN_200b55c(1, 2);
    FUN_200b4cc(10);
    FUN_200b59c(1, 0x3000, 0);
    FUN_200b4cc(40);
    FUN_200b584(1);

    if(FUN_200b4e4(0, 0) == 0) {
      FUN_200b59c(1, 0x1000, 0);
      FUN_200b4cc(10);
      setActorAnimationAndWaitUntilFinished(1, 3);
    } else {
      //LAB_2009b4c
      FUN_200b59c(1, 0x1000, 0);
      FUN_200b4cc(10);
      setActorAnimationIfLoaded(1, 4);
      FUN_200b57c(0x1103);
    }

    //LAB_2009b6c
    FUN_200b4cc(20);
    FUN_200b58c(1, 0);
    moveActorToPosition(15, 0x6e0000, 0x980000);
    sleep(1);
    setActorVelocityScalerAndAcceleration(15, 0x13333, 0x9999);
    FUN_200b50c(15, 171, 152);
    FUN_200b59c(15, 0, 0);
    FUN_200b484(getMapActor(15), 1);
    setActorVelocityScalerAndAcceleration(1, 0x10000, 0x8000);
    FUN_200b51c(1, 217, 182);
    FUN_200b59c(0, 0x7000, 0);
    FUN_200b4cc(10);
    FUN_200b5bc(0x20000, 0x4000);
    FUN_200b5c4(0xd90000, -1, 0xb00000, 1);
    FUN_200b5cc();
    FUN_200b4cc(20);
    FUN_200b5b4(0, 0x102);
    FUN_200b4cc(20);
    FUN_200b54c(0, 2, 0);
    FUN_200b4cc(10);
    FUN_200b54c(0, 4, 0);
    FUN_200b4cc(30);
    FUN_200b5ac(1, 0x100, 0);
    setActorAnimationIfLoaded(1, 1);
    FUN_200b4cc(40);
    FUN_200b59c(1, 0x2000, 0);
    FUN_200b4cc(4);
    FUN_200b524(1, 231, 175);
    FUN_200b59c(1, 0xe000, 0);
    FUN_200b57c(0x1104);
    FUN_200b58c(1, 0);
    FUN_200b4cc(40);
    FUN_200b5ac(1, 0x101, 0);
    FUN_200b4cc(40);
    FUN_200b59c(1, 0xa000, 0);
    FUN_200b4cc(60);
    FUN_200b554(1, 1);
    FUN_200b5b4(1, 0x102);
    FUN_200b4cc(40);
    FUN_200ad48(1, 20, 0);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    FUN_200b4cc(40);
    FUN_200b554(0, 2);
    FUN_200b554(1, 2);
    playSound(0x121);
    FUN_200b5ec(0x10000, 1);
    FUN_200b5f4(40);
    MEMORY.ref(4, r9 + 0x40c).setu(1);
    FUN_200b494(-1, -1, 0xe666);
    FUN_200b4cc(120);
    FUN_200b58c(15, 0);
    FUN_200b4cc(20);
    FUN_200b5ac(0, 0x102, 0);
    FUN_200b5ac(1, 0x102, 0);
    FUN_200b4cc(100);
    FUN_200b58c(15, 0);
    FUN_200b4cc(20);
    FUN_200ad48(1, 10, 0);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x20000, 0x20000, 0x10000);
    FUN_200b4cc(20);
    setActorVelocityScalerAndAcceleration(0, 0x20000, 0x10000);
    setActorVelocityScalerAndAcceleration(1, 0x20000, 0x10000);
    getMapActor(0)._5a.and(~0x1);
    getMapActor(1)._5a.and(~0x1);
    FUN_200b54c(0, 4, 0);
    FUN_200b54c(1, 4, 0);
    FUN_200b50c(0, 0x100, 150);
    FUN_200b50c(1, 231, 180);
    FUN_200b52c(1);
    FUN_200ad48(0, 40, 0);
    FUN_200b4cc(20);
    getMapActor(0)._5a.or(0x1);
    getMapActor(1)._5a.or(0x1);
    FUN_200b554(0, 2);
    FUN_200b55c(1, 2);
    FUN_200b4cc(40);
    FUN_200b5ac(1, 0x103, 0);
    FUN_200b4cc(40);
    FUN_200b58c(1, 0);
    FUN_200b4cc(20);
    FUN_200b5ac(15, 0x101, 0);
    FUN_200b4cc(60);
    FUN_200b59c(0, 0x5000, 0);
    FUN_200b59c(1, 0xd000, 0);
    FUN_200b4cc(20);
    FUN_200b59c(0, 0x8000, 0);
    FUN_200b59c(1, 0xb000, 0);
    FUN_200b4cc(10);
    playSound(0x6b);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a93c"), 0xc80);
    FUN_200b4cc(10);
    FUN_200b5ac(15, 0x100, 0);
    FUN_200b4cc(40);
    FUN_200b5bc(0x10000, 0x2000);
    FUN_200b5c4(0xba0000, -1, 0xa60000, 1);
    FUN_200b50c(15, 130, 113);
    FUN_200b52c(15);
    FUN_200b59c(15, 0x3000, 0);
    FUN_200b4cc(20);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x20000, 0x20000, 0x10000);
    FUN_200b5ec(0x20119e, 1);
    FUN_200b5f4(20);
    FUN_200b4cc(20);
    FUN_200aff0();
    setActorAnimationAndWaitUntilFinished(15, 2);

    //LAB_2009f78
    for(int i = 0; i < 40; i++) {
      FUN_200ad94(r10);
      sleep(1);
    }

    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"), 0xc80);
    FUN_200b5ec(0x10000, 1);
    FUN_200b5f4(60);
    FUN_200b4cc(30);
    playSound(0x121);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a93c"));
    FUN_200b494(0x10000, 0x10000, 0x10000);

    //LAB_2009fc8
    for(int i = 15; i >= 0; i--) {
      FUN_200a84c(0);
      sleep(i);
      FUN_200a84c(1);
      sleep(i);
    }

    FUN_200a84c(0);
    MEMORY.ref(4, r9 + 0x40c).setu(1);
    FUN_200b494(-1, -1, 0xe666);
    FUN_200b49c();
    setActorAnimationAndWaitUntilFinished(15, 3);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"));
    sleep(1);
    FUN_200b56c(15, 0);
    FUN_200b4cc(60);
    FUN_200b58c(15, 0);
    FUN_200b4cc(40);
    FUN_200b5ac(0, 0x102, 0);
    FUN_200b5ac(1, 0x102, 0);
    FUN_200b4cc(60);
    FUN_200b5bc(0x10000, 0x2000);
    FUN_200b5c4(0xda0000, -1, 0xb50000, 1);
    setActorVelocityScalerAndAcceleration(15, 0x10000, 0x8000);
    FUN_200b50c(15, 169, 151);
    FUN_200b52c(15);
    FUN_200b4cc(10);
    FUN_200b59c(15, 0x1000, 0);
    FUN_200b4cc(40);
    FUN_200b58c(15, 0);
    FUN_200b4cc(20);
    FUN_200b59c(0, 0x5000, 0);
    FUN_200b59c(1, 0xd000, 0);
    FUN_200b4cc(40);
    FUN_200b59c(15, 0xf000, 0);
    FUN_200b4cc(10);
    FUN_200b59c(0, 0x7000, 0);
    FUN_200b59c(1, 0xb000, 0);
    FUN_200b5c4(0xe00000, -1, 0x9e0000, 1);
    FUN_200b5cc();
    FUN_200a9a4(0);
    FUN_200b55c(15, 2);
    FUN_200b4cc(20);
    FUN_200b58c(15, 0);
    FUN_200b4cc(40);
    FUN_200b584(15);

    if(FUN_200b4e4(0, 0) == 0) {
      FUN_200b4cc(40);
    } else {
      //LAB_200a164
      FUN_200b4ac(0x110c, 1);
      FUN_200b4cc(40);
    }

    //LAB_200a172
    r0 = getMapActor(0);
    final Actor70 r7_0 = loadActor(22, r0.pos_08.getX(), r0.pos_08.getY() + 0x240000, r0.pos_08.getZ());
    if(r7_0 != null) {
      final int r5 = mallocSlotChip(17, 0x608);
      final Sprite38 r6_0 = r7_0.sprite_50.deref();
      r6_0._26.set(0);
      r6_0.layerCount_27.set(0);
      r6_0.packet_00.attribs_04.flags_01.and(~0x20);
      r6_0.packet_00.attribs_04.attrib2_04.and(0xfff).and(~0xc00).or(0x400);
      FUN_200b4b4(222);
      allocateSpriteSlot(r6_0.slot_1c.get(), 0x80, r5 + 0x400);
      freeSlot(17);
      setActorAnimationIfLoaded(0, 28);
      FUN_200b60c(r7_0, 3);
      setActorAnimationIfLoaded(0, 28);
    }

    //LAB_200a1f8
    FUN_200ad48(1, 20, 0);

    //LAB_200a20c
    for(int i = 0; i < 24; i++) {
      FUN_200ad94(r10);
      sleep(1);
      FUN_200ad94(r10);
      sleep(1);
      r7_0.scale_18.set(0x6666);
      r7_0._1c.set(0x6666);
      FUN_200ad94(r10);
      sleep(1);
      FUN_200ad94(r10);
      sleep(1);
      r7_0.scale_18.set(0x10000);
      r7_0._1c.set(0x10000);
    }

    FUN_200b56c(15, 0);
    FUN_200ad48(0, 20, 0);
    FUN_200b57c(0x110d);
    FUN_200b594(15, 0, 20);

    if(r7_0 != null) {
      clearActor(r7_0);
    }

    //LAB_200a278
    setActorAnimationIfLoaded(0, 1);
    FUN_200b4cc(20);
    FUN_200b59c(0, 0x8000, 0);
    FUN_200b59c(1, 0xa000, 60);
    FUN_200b58c(15, 0);
    FUN_200b4cc(40);
    FUN_200b59c(15, 0x4000, 0);
    FUN_200b5bc(0x40000, 0x8000);
    FUN_200ac1c(232, 464);
    FUN_200a9a4(1);
    FUN_200b58c(15, 0);
    FUN_200ac1c(711, 144);
    FUN_200a9a4(2);
    FUN_200b58c(15, 0);
    FUN_200ac1c(711, 464);
    FUN_200a9a4(3);
    FUN_200b58c(15, 0);
    FUN_200b59c(15, 0x1000, 0);
    moveActorToPosition(1, 0x2460000, 0x1590000);
    FUN_200b4cc(20);
    FUN_200b58c(1, 0);
    moveActorToPosition(1, 0xe70000, 0xb40000);
    FUN_200b59c(1, 0xb000, 0);
    sleep(20);
    FUN_200ac1c(219, 171);
    FUN_200b58c(15, 0);
    FUN_200b4cc(10);
    FUN_200b554(0, 2);
    FUN_200b55c(1, 2);
    FUN_200b58c(15, 0);
    FUN_200b4cc(20);
    FUN_200b58c(15, 0);
    FUN_200b4cc(40);
    MEMORY.ref(4, r9 + 0x40c).setu(0);
    FUN_200b494(0x40000, 0x40000, 0x10000);
    FUN_200b5ec(0x20119e, 1);
    FUN_200b5f4(20);
    FUN_200b4cc(20);
    playSound(0x6b);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a970"), 0xc80);
    FUN_200b4cc(20);
    FUN_200b5bc(0x10000, 0x2000);
    FUN_200b5c4(0xb80000, -1, 0x840000, 1);
    FUN_200b54c(0, 6, 0);
    FUN_200b54c(1, 6, 0);
    getMapActor(0)._5a.and(~0x1);
    getMapActor(1)._5a.and(~0x1);
    FUN_200b50c(0, 245, 145);
    FUN_200b50c(1, 215, 168);
    FUN_200b52c(1);
    FUN_200b4cc(80);
    getMapActor(0)._5a.or(0x1);
    getMapActor(1)._5a.or(0x1);
    FUN_200b50c(15, 184, 87);
    FUN_200b52c(15);
    FUN_200b59c(15, 0x4000, 0);
    FUN_200b4cc(20);
    setActorAnimationAndWaitUntilFinished(15, 2);

    //LAB_200a490
    for(int i = 0; i < 40; i++) {
      FUN_200ad94(r10);
      sleep(1);
    }

    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"), 0xc80);
    FUN_200b5ec(0x10000, 1);
    FUN_200b5f4(60);
    FUN_200b4cc(30);
    playSound(0x121);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a970"));
    FUN_200b494(0x20000, 0x20000, 0x10000);

    //LAB_200a4e0
    for(int i = 7; i >= 0; i--) {
      FUN_200a8dc(0);
      sleep(i);
      FUN_200a8dc(1);
      sleep(i);
    }

    FUN_200a8dc(0);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    setActorAnimationAndWaitUntilFinished(15, 3);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"));
    sleep(1);
    FUN_200b56c(15, 0);
    FUN_200b4cc(60);
    FUN_200b494(0x40000, 0x40000, 0x10000);
    FUN_200b5ec(0x20119e, 1);
    FUN_200b5f4(20);
    FUN_200b4cc(20);
    playSound(0x6b);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a93c"), 0xc80);
    FUN_200b4cc(40);
    FUN_200b514(15, 127, 110);
    FUN_200b59c(15, 0x4000, 0);
    FUN_200b4cc(20);
    setActorAnimationAndWaitUntilFinished(15, 2);

    //LAB_200a5c8
    for(int i = 0; i < 40; i++) {
      FUN_200ad94(r10);
      sleep(1);
    }

    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"), 0xc80);
    FUN_200b5ec(0x10000, 1);
    FUN_200b5f4(60);
    playSound(0x121);
    FUN_200b4cc(30);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a93c"));
    FUN_200b494(0x20000, 0x20000, 0x10000);

    //LAB_200a618
    for(int i = 7; i >= 0; i--) {
      FUN_200a84c(0);
      sleep(i);
      FUN_200a84c(1);
      sleep(i);
    }

    FUN_200a84c(0);
    FUN_200b494(0x10000, 0x10000, 0x10000);
    playSound(0x6b);
    playSound(0x3f);
    FUN_200b494(0x40000, 0x40000, 0x10000);
    FUN_200b5ec(0x20119e, 1);
    FUN_200b5f4(20);
    FUN_200b4cc(20);
    playSound(0x6b);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200a970"), 0xc80);
    setActorAnimationAndWaitUntilFinished(15, 3);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"));
    sleep(1);
    FUN_200b56c(15, 0);
    FUN_200b4cc(60);
    FUN_200b514(15, 184, 87);
    FUN_200b59c(15, 0x4000, 0);
    FUN_200b4cc(10);
    setActorAnimationAndWaitUntilFinished(15, 3);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"));
    sleep(1);
    FUN_200b56c(15, 0);
    playSound(0x8d);
    FUN_200b4cc(100);
    FUN_200b5ac(0, 0x102, 0);
    FUN_200b5ac(1, 0x102, 0);
    FUN_200b4cc(60);
    FUN_200b58c(15, 0);
    FUN_200b55c(1, 3);
    FUN_200b58c(1, 0);
    FUN_200b4cc(20);
    playSound(0x121);
    FUN_200b59c(15, 0x3000, 0);
    FUN_200b4cc(20);
    FUN_200b58c(15, 0);
    FUN_200b4cc(20);

    //LAB_200a75c
    for(int i = 0; i < 40; i++) {
      FUN_200ad94(r10);
      sleep(1);
    }

    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"), 3200);
    FUN_200b4cc(20);
    FUN_200b5ec(0x7fff, 2);
    FUN_200b5f4(60);
    sleep(100);
    FUN_200b5ec(0x7fff, 1);
    FUN_200b5f4(60);
    sleep(60);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200b00c"));
    MEMORY.ref(4, r9 + 0x40c).setu(1);
    FUN_200b494(-1, -1, 0xe666);
    FUN_200b49c();
    FUN_200b000();
    setFlag(0x814);
    setFlag(0x83f);
    FUN_200b5dc(5);
    setFlag(0x100);
  }

  @Method(0x200a820)
  public static void FUN_200a820(final int mapActorIndex) {
    final Actor70 r6 = getMapActor(mapActorIndex);
    moveActorToPosition(mapActorIndex, 0xe80000, 0x7d0000);
    r6.angle_06.set(0x4000);
    setActorPriority(mapActorIndex, 3);
  }

  @Method(0x200a84c)
  public static void FUN_200a84c(final int r0) {
    if(r0 != 0) {
      FUN_200b474(8, 47, 64, 7, 1, 1);
      FUN_200b474(7, 48, 63, 8, 2, 1);
      FUN_200b474(7, 49, 63, 9, 2, 1);
    } else {
      //LAB_200a88a
      FUN_200b474(56, 0, 64, 7, 1, 1);
      FUN_200b474(56, 0, 63, 8, 1, 1);
      FUN_200b474(56, 0, 63, 9, 2, 1);
      FUN_200b474(58, 25, 64, 8, 1, 1);
    }

    //LAB_200a8ce
    FUN_200b464();
  }

  @Method(0x200a8dc)
  public static void FUN_200a8dc(final int r0) {
    if(r0 != 0) {
      FUN_200b474(9, 45, 65, 5, 2, 2);
      FUN_200b474(11, 46, 67, 6, 1, 2);
    } else {
      //LAB_200a90a
      FUN_200b474(89, 2, 65, 5, 2, 2);
      FUN_200b474(102, 32, 67, 6, 1, 2);
    }

    //LAB_200a92e
    FUN_200b464();
  }

  @Method(0x200a93c)
  public static void FUN_200a93c() {
    if((_3001e40.get() & 0x1) == 0) {
      final int r0 = FUN_30003e0(rand(), 100);
      if(r0 < 0 || r0 > 50) {
        FUN_200a84c(1);
      } else {
        //LAB_200a960
        FUN_200a84c(0);
      }
    }
  }

  @Method(0x200a970)
  public static void FUN_200a970() {
    if((_3001e40.get() & 0x1) == 0) {
      final int r0 = FUN_30003e0(rand(), 100);
      if(r0 < 0 || r0 > 50) {
        FUN_200a8dc(1);
      } else {
        //LAB_200a994
        FUN_200a8dc(0);
      }
    }
  }

  @Method(0x200a9a4)
  public static void FUN_200a9a4(final int r0) {
    int r1;
    int r3;
    int r6;

    //LAB_200a9b2
    for(r6 = 0; r6 < 16; r6++) {
      FUN_200b4f4(r6 + 0x10);
    }

    if(r0 == 0x1) {
      //LAB_200a9d6
      FUN_200b5ec(0x4049d2, 1);
    } else if((r0 & 0xffff_ffffL) < 1) {
      //LAB_200a9d2
      FUN_200b5ec(0x4039d2, 1);
    } else if(r0 == 0x2) {
      //LAB_200a9da
      FUN_200b5ec(0x404a4e, 1);
    } else if(r0 == 0x3) {
      //LAB_200a9e4
      FUN_200b5ec(0x403a52, 1);
    }

    //LAB_200a9ec
    FUN_200b5f4(60);
    playSound(0xd6);

    //LAB_200aa00
    for(r6 = 0; r6 < 10; r6++) {
      r1 = MEMORY.ref(4, 0x200b684 + r6 * 0x8).get();
      r3 = 0x0;
      if(r0 == 0x1) {
        //LAB_200aa26
        r1 = r1 + 0xe80000;
        r3 = 0x1d00000;
      } else if((r0 & 0xffff_ffffL) < 1) {
        //LAB_200aa1a
        r1 = r1 + 0xe80000;
        r3 = 0x900000;
      } else if(r0 == 0x2) {
        //LAB_200aa30
        r1 = r1 + 0x2c70000;
        r3 = 0x900000;
      } else if(r0 == 0x3) {
        //LAB_200aa3a
        r1 = r1 + 0x2c70000;
        r3 = 0x1d00000;
      }

      //LAB_200aa42
      MEMORY.ref(4, 0x200bb40 + r6 * 0x4).setu(0);
      final Actor70 actor = loadActor(0x11c, r1, MEMORY.ref(4, 0x200b684 + r6 * 0x8 + 0x4).get(), r3);
      MEMORY.ref(4, 0x200bb10 + r6 * 0x4).setu(actor.getAddress());
      actor._55.set(0);
      final Sprite38 sprite = actor.sprite_50.deref();
      sprite._26.set(0);
      sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
      setActorAnimation(actor, 6);
      sleep(6);
    }

    if(r0 == 0) {
      FUN_200b5ac(0, 0x100, 0);
      FUN_200b5ac(1, 0x100, 0);
    }

    //LAB_200aaaa
    sleep(20);
    setTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200aba0"), 0xc80);
    playSound(0xf6);
    MEMORY.ref(4, 0x200bb40).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x4).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x8).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0xc).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x10).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x14).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x18).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x1c).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x20).setu(1);
    sleep(6);
    MEMORY.ref(4, 0x200bb40 + 0x24).setu(1);
    sleep(6);

    //LAB_200ab28
    do {
      //LAB_200ab38
      for(r6 = 0; r6 < 10; r6++) {
        if(MEMORY.ref(4, 0x200bb40 + r6 * 0x4).get() != 0) {
          r6 = 0x378;
          break;
        }

        //LAB_200ab2e
      }

      //LAB_200ab40
      if(r6 != 0x378) {
        break;
      }
      sleep(1);
    } while(true);

    //LAB_200ab50
    sleep(40);
    clearTickCallback(getRunnable(Map18Overlay_8791794.class, "FUN_200aba0"));
    FUN_200b5ec(0x10000, 1);
    FUN_200b5f4(40);
  }

  @Method(0x200aba0)
  public static void FUN_200aba0() {
    //LAB_200abb6
    for(int r4 = 0; r4 < 10; r4++) {
      final int r3 = MEMORY.ref(4, 0x200bb40 + r4 * 0x4).get();
      if(r3 != 0) {
        final int r2 = MEMORY.ref(4, 0x200bb10 + r4 * 0x4).get();
        if((r3 & 0xffff_ffffL) < 9) {
          MEMORY.ref(4, r2 + 0x18).sub(0x1ccc);
          MEMORY.ref(4, r2 + 0x1c).add(0x8000);
          MEMORY.ref(4, r2 + 0xc).add(0x4ccc);
          MEMORY.ref(4, r2 + 0x3c).add(0x4ccc);
        } else {
          //LAB_200abe4
          MEMORY.ref(4, r2 + 0xc).add(0x140000);
          MEMORY.ref(4, r2 + 0x3c).add(0x140000);
        }

        //LAB_200abee
        MEMORY.ref(4, 0x200bb40 + r4 * 0x4).incr();
        if((MEMORY.ref(4, 0x200bb40 + r4 * 0x4).get() & 0xffff_ffffL) > 14) {
          MEMORY.ref(4, 0x200bb40 + r4 * 0x4).setu(0);
        }
      }

      //LAB_200abfe
    }
  }

  @Method(0x200ac1c)
  public static void FUN_200ac1c(final int x, final int z) {
    final Actor70 r5 = FUN_200b5d4();
    FUN_200b5c4(x << 16, -1, z << 16, 1);
    FUN_200b5ec(0, 0);
    FUN_200b5f4(20);
    sleep(40);
    r5.dest_38.setX(0x80000000);
    r5.dest_38.setZ(0x80000000);
    r5.velocity_24.setX(0);
    r5.velocity_24.setZ(0);
    r5.pos_08.setX(x << 16);
    r5.pos_08.setZ(z << 16);
    sleep(5);
    FUN_200b464();
    sleep(5);
    FUN_200b5ec(0x10000, 0);
    FUN_200b5f4(20);
    sleep(30);
  }

  @Method(0x200ac9c)
  public static void FUN_200ac9c() {
    FUN_200b47c(14, 8, 1, 1, 0, 10);
    FUN_200b47c(14, 28, 1, 1, 11, 0);
    FUN_200b47c(44, 8, 1, 1, 12, 0);
    FUN_200b47c(44, 28, 1, 1, 13, 0);
    FUN_200b47c(13, 8, 1, 1, 14, 8);
    FUN_200b47c(13, 28, 1, 1, 14, 28);
    FUN_200b47c(43, 8, 1, 1, 44, 8);
    FUN_200b47c(43, 28, 1, 1, 44, 28);
  }

  @Method(0x200ad48)
  public static void FUN_200ad48(final int r0, final int r1, final int r2) {
    if(r0 == 1) {
      playSound(0x134);
      FUN_200b5ec(0x203a52, 1);
    } else {
      //LAB_200ad64
      playSound(0x121);
      FUN_200b5ec(0x10000, 1);
    }

    //LAB_200ad74
    FUN_200b5f4(r1);

    if(r2 != 0) {
      FUN_200b4cc(r2);
    }
  }

  @Method(0x200ad94)
  public static void FUN_200ad94(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0) {
      FUN_200b4a4(r0, 7);
    } else {
      //LAB_200adac
      FUN_200b4a4(r0, 0);
    }

    //LAB_200adb4
    if((_3001e40.get() & 0xf) == 0) {
      FUN_200aeb0(r0);
    }
  }

  @Method(0x200add0)
  public static void FUN_200add0(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_200b4a4(r0, FUN_30003e0(_3001e40.get() >>> 1, 6));
    }

    //LAB_200adf2
    if((_3001e40.get() & 0xf) == 0) {
      FUN_200aeb0(r0);
    }
  }

  @Method(0x200ae0c)
  public static void FUN_200ae0c(final Actor70 r0) {
    r0._64.incr();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200ae2c
      final Actor70 r6 = r0.parent_68.deref();
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.setZ(r6.pos_08.getZ() + 0x80000 + (0x10000 - sin) * 5);
    }
  }

  @Method(0x200ae5c)
  public static void FUN_200ae5c(final Actor70 r0) {
    r0._64.incr();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200ae7c
      final Actor70 r6 = r0.parent_68.deref();
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(-sin);
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.setZ(r6.pos_08.getZ() + 0x100000 - (0x10000 - sin) * 5);
    }
  }

  @Method(0x200aeb0)
  public static void FUN_200aeb0(final Actor70 r0) {
    final FieldPsynergy720 r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    playSound(0x124);
    final Actor70[] r10 = new Actor70[2];

    //LAB_200aed8
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 actor26 = loadActor(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      r10[r7] = actor26;

      if(actor26 != null) {
        actor26._14.set(r0._14.get());
        final Sprite38 r5 = actor26.sprite_50.deref();
        actor26._55.set(0);
        actor26._64.set(0);
        actor26.parent_68.set(r0);

        if(r5 != null) {
          //LAB_200af14
          setSpriteAnimation(r5, 0);
          r5._26.set(0);
          clearVramSlot(r5.slot_1c.get());
          r5.slot_1c.set(r11.vramSlot_46.get());
          r5._1d.or(0x1);
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(vramSlots_3001b10.get(r5.slot_1c.get()).vramAddr_02.get() << 17 >>> 22);
          r5.packet_00.attribs_04.flags_01.and(~0x20).and(0x3f).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_200af84
    }

    r10[0]._6c.set(getConsumer(Map18Overlay_8791794.class, "FUN_200ae5c", Actor70.class));
    final Actor70 actor15 = getMapActor(15);
    final Sprite38 r3 = actor15.sprite_50.deref();
    r10[0].sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    r10[1].sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    r10[1].flags_23.set(0x2);
    r10[1]._6c.set(getConsumer(Map18Overlay_8791794.class, "FUN_200ae0c", Actor70.class));
  }

  @Method(0x200aff0)
  public static void FUN_200aff0() {
    FUN_200b614(140, 0);
  }

  @Method(0x200b000)
  public static void FUN_200b000() {
    FUN_200b61c();
  }

  @Method(0x200b00c)
  public static void FUN_200b00c() {
    FUN_200add0(getMapActor(15));
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200b3e4)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200b3ec)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200b3f4)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200b3fc)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200b404)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#cos_} */
  @Method(0x200b40c)
  public static int cos(final int angle) {
    return (int)MEMORY.call(0x8000120, angle);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200b414)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200b424)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#clearVramSlot_} */
  @Method(0x200b42c)
  public static int clearVramSlot(final int slot) {
    return (int)MEMORY.call(0x80001b8, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200b434)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setSpriteAnimation_} */
  @Method(0x200b43c)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x8009020, sprite, animation);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200b444)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200b44c)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    MEMORY.call(0x8009098, actor, script);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200b454)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x200b45c)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200b464)
  public static void FUN_200b464() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#moveActorTo_} */
  @Method(0x200b46c)
  public static void moveActorTo(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200b474)
  public static void FUN_200b474(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200b47c)
  public static void FUN_200b47c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200b484)
  public static void FUN_200b484(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200b494)
  public static void FUN_200b494(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f8} */
  @Method(0x200b49c)
  public static void FUN_200b49c() {
    MEMORY.call(0x80091f8);
  }

  /** {@link GoldenSun#FUN_8009240} */
  @Method(0x200b4a4)
  public static void FUN_200b4a4(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009240, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200b4ac)
  public static void FUN_200b4ac(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200b4b4)
  public static void FUN_200b4b4(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200b4bc)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200b4c4)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200b4cc)
  public static void FUN_200b4cc(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200b4d4)
  public static void FUN_200b4d4() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#removeCharAndHealRemainingChars_} */
  @Method(0x200b4dc)
  public static void removeCharAndHealRemainingChars(final int charId) {
    MEMORY.call(0x808a058, charId);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200b4e4)
  public static int FUN_200b4e4(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /**
   * {@link GoldenSun_808#getMapActor_}
   */
  @Method(0x200b4ec)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a088} */
  @Method(0x200b4f4)
  public static void FUN_200b4f4(final int mapActorIndex) {
    MEMORY.call(0x808a088, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200b4fc)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x200b504)
  public static void FUN_200b504(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200b50c)
  public static void FUN_200b50c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200b514)
  public static void FUN_200b514(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200b51c)
  public static void FUN_200b51c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200b524)
  public static void FUN_200b524(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200b52c)
  public static void FUN_200b52c(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200b534)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200b53c)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200b544)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200b54c)
  public static void FUN_200b54c(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200b554)
  public static void FUN_200b554(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200b55c)
  public static void FUN_200b55c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200b564)
  public static void FUN_200b564(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200b56c)
  public static void FUN_200b56c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a158, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a160} */
  @Method(0x200b574)
  public static void FUN_200b574(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a160, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200b57c)
  public static void FUN_200b57c(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200b584)
  public static Panel24 FUN_200b584(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200b58c)
  public static void FUN_200b58c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200b594)
  public static void FUN_200b594(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200b59c)
  public static void FUN_200b59c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200b5a4)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200b5ac)
  public static void FUN_200b5ac(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200b5b4)
  public static void FUN_200b5b4(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200b5bc)
  public static void FUN_200b5bc(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200b5c4)
  public static void FUN_200b5c4(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200b5cc)
  public static void FUN_200b5cc() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a228} */
  @Method(0x200b5d4)
  public static Actor70 FUN_200b5d4() {
    return (Actor70)MEMORY.call(0x808a228);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200b5dc)
  public static void FUN_200b5dc(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x200b5e4)
  public static void FUN_200b5e4() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200b5ec)
  public static void FUN_200b5ec(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200b5f4)
  public static void FUN_200b5f4(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200b5fc)
  public static void FUN_200b5fc() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200b604)
  public static void FUN_200b604() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a390} */
  @Method(0x200b60c)
  public static void FUN_200b60c(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a390, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x200b614)
  public static void FUN_200b614(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x200b61c)
  public static void FUN_200b61c() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200b624)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
