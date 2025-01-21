package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80b;
import org.goldensun.GoldenSun_80f;
import org.goldensun.MathHelper;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;
import org.goldensun.types.Unit14c;

import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/** Sol Sanctum inside portal */
public final class Map17Overlay_878ef88 {
  private Map17Overlay_878ef88() { }

  @Method(0x2008104)
  public static void FUN_2008104(final Actor70 r0) {
    r0.pos_08.x_00.add(r0._44.get());
    r0.pos_08.y_04.add(r0._48.get());
    r0.pos_08.z_08.add(r0._4c.get());
    r0.scale_18.add(r0.velocityScalar_30.get());
    r0._1c.add(r0.acceleration_34.get());
    r0.sprite_50.deref().rotation_1e.add(r0._64.get());
  }

  @Method(0x200813c)
  public static void FUN_200813c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7) {
    final Actor70 r9 = getMapActor(0);

    //LAB_200817e
    final Actor70 r6 = loadActor((a6 & 0x100000) != 0 && a7 != 0 ? MEMORY.ref(2, a7 + 0x18).get() : 0xde, r0, r1, r2);
    if(r6 != null) {
      //LAB_200818e
      final Sprite38 r8 = r6.sprite_50.deref();
      setActorAnimation(r6, a6 + 1 & 0xf);
      final int r11 = (a6 & 0xf) * 0x4;
      setActorSpriteScript(r6, MEMORY.ref(4, 0x200cbc4 + r11).get());
      r6._55.set(0);
      r8._26.set(0);
      r6._6c.set(getConsumer(Map17Overlay_878ef88.class, "FUN_2008104", Actor70.class));
      r6._44.set(r3);
      r6._48.set(a4);
      r6._4c.set(a5);
      r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r9.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
      r6.velocityScalar_30.set(0);
      r6.acceleration_34.set(0);
      r6._64.set(0);

      if((a6 & ~0xffff) != 0 && a7 != 0) {
        if((a6 & 0x10000) != 0) {
          FUN_200ca4c(r6, MEMORY.ref(4, a7 + 0x4).get());
        }

        //LAB_200821c
        if((a6 & 0x20000) != 0) {
          r6.flags_23.and(~0x1);
          r8.packet_00.attribs_04.attrib2_04.and(~0xc00).or((MEMORY.ref(1, a7).getUnsigned() & 0x3) << 10);
        }

        //LAB_2008248
        if((a6 & 0x80000) != 0) {
          r6.scale_18.set(MEMORY.ref(4, a7 + 0x8).get());
          r6._1c.set(MEMORY.ref(4, a7 + 0xc).get());
        }

        //LAB_200825c
        if((a6 & 0x40000) != 0) {
          final int r5 = MEMORY.ref(4, 0x200cbc4 + r11).get();
          if((a6 & 0x80000) != 0) {
            r6.velocityScalar_30.set(FUN_200c854(MEMORY.ref(4, a7 + 0x10).get() - r6.scale_18.get(), MEMORY.ref(4, r5 + 0xc).get()));
            r6.acceleration_34.set(FUN_200c854(MEMORY.ref(4, a7 + 0x14).get() - r6._1c.get(), MEMORY.ref(4, r5 + 0xc).get()));
          } else {
            //LAB_200828a
            r6.velocityScalar_30.set(FUN_200c854(MEMORY.ref(4, a7 + 0x10).get() - 0x10000, MEMORY.ref(4, r5 + 0xc).get()));
            r6.acceleration_34.set(FUN_200c854(MEMORY.ref(4, a7 + 0x14).get() - 0x10000, MEMORY.ref(4, r5 + 0xc).get()));
          }

          //LAB_20082a0
        }

        //LAB_20082a6
        if((a6 & 0x200000) != 0) {
          setActorAnimation(r6, 1);
          setActorSpriteScript(r6, MEMORY.ref(4, a7 + 0x1c).get());
        }

        //LAB_20082c2
        if((a6 & 0x400000) != 0) {
          r8.rotation_1e.set(MEMORY.ref(2, a7 + 0x20).getUnsigned());
        }

        //LAB_20082d4
        if((a6 & 0x800000) != 0) {
          r6._64.set(MEMORY.ref(2, a7 + 0x22).getUnsigned());
        }

        //LAB_20082e6
        if((a6 & 0x1000000) != 0) {
          r6._6c.setPointer(MEMORY.ref(4, a7 + 0x24).get());
        }
      }
    }

    //LAB_20082f6
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x200836c)
  public static int getRooms() {
    return 0x200cd88;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008374)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008378)
  public static int getTransitions() {
    return 0x200cdb8;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008380)
  public static int getActors() {
    return 0x200cdc4;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008388)
  public static int getEvents() {
    return 0x200cfa4;
  }

  /**
   * Event list 0x200cfa4 handler 14
   */
  @Method(value = 0x2008390, ignoreExtraParams = true)
  public static void FUN_2008390() {
    FUN_200c99c();
    playSound(0x8d);

    //LAB_20083aa
    for(int i = 0; i < 6; i++) {
      FUN_200cacc(0x403a52, 1);
      FUN_200cadc(8);
      FUN_200c994(8);
      FUN_200cacc(0x10000, 1);
      FUN_200cadc(8);
      FUN_200c994(8);

      if(i == 1) {
        FUN_200c90c(0x10000, 0x10000, 0x10000);
      }

      //LAB_20083e8
    }

    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(30);
    FUN_200caa4(0x26666, 0x4ccc);
    FUN_200caac(0x2980000, -1, 0x1f10000, 1);
    FUN_200cab4();
    FUN_200c994(20);
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 96, 29);
    FUN_200c8f4(0, 0, 1, 1, 41, 29);
    FUN_200c8ec(87, 42, 41, 31, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caa4(0x66666, 0xcccc);
    FUN_200caac(0x1370000, -1, 0x1f10000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 74, 29);
    FUN_200c8f4(0, 0, 1, 1, 19, 29);
    FUN_200c8ec(87, 42, 19, 31, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caac(0x2970000, -1, 0xc00000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 96, 10);
    FUN_200c8f4(0, 0, 1, 1, 41, 10);
    FUN_200c8ec(87, 42, 41, 12, 1, 2);
    FUN_200c994(40);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x2c60000, -1, 0x1da0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200c90c(0x20000, 0x10000, 0x10000);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    playSound(0x121);
    FUN_200c90c(-1, -1, 0xe666);
    FUN_200c914();
    FUN_200c994(20);
    FUN_200c8ec(0, 40, 43, 66, 3, 3);
    FUN_200c994(20);
    final int r5 = FUN_200c260(220, 0x2c80000, 0x100000, 0x1d00000);
    FUN_200c994(40);
    FUN_200c924(r5, 1);
    FUN_200c91c(0x1075, 1);
    FUN_200ca7c(9, 0x2000, 0);
    FUN_200ca7c(5, 0x2000, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1ce0000, -1, 0x15e0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    FUN_200ca1c(9, 4, 30);
    FUN_200ca54(0x1074);
    FUN_200c248(9, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x2c60000, -1, 0x1da0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    setFlag(0x83c);
    FUN_200c9a4();
  }

  @Method(0x2008314)
  public static int FUN_2008314(final Actor70 r0) {
    final Actor70 r1 = r0.parent_68.derefNullable();

    if(r1 != null) {
      r0._5a.and(~0x1);

      final int angle = (short)((atan2(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX()) & 0xffff) - (r0.angle_06.get() & 0xffff));

      if(angle != 0) {
        r0.angle_06.add(MathHelper.clamp(angle, -0x1000, 0x1000));
      }
    }

    //LAB_200835e
    return 1;
  }

  /**
   * Event list 0x200cfa4 handler 15
   */
  @Method(value = 0x20086f4, ignoreExtraParams = true)
  public static void FUN_20086f4() {
    FUN_200c99c();
    playSound(0x8d);

    //LAB_200870e
    for(int i = 0; i < 6; i++) {
      FUN_200cacc(0x404a4e, 1);
      FUN_200cadc(8);
      FUN_200c994(8);
      FUN_200cacc(0x10000, 1);
      FUN_200cadc(8);
      FUN_200c994(8);

      if(i == 1) {
        FUN_200c90c(0x10000, 0x10000, 0x10000);
      }

      //LAB_200874c
    }

    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(30);
    FUN_200c90c(0, 0, 0);
    FUN_200caa4(0x59999, 0xb333);
    FUN_200caac(0x1d80000, -1, 0x620000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 84, 4);
    FUN_200c8f4(0, 0, 1, 1, 29, 4);
    FUN_200c8ec(87, 42, 29, 6, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caac(0x1570000, -1, 0x1710000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 76, 21);
    FUN_200c8f4(0, 0, 1, 1, 21, 21);
    FUN_200c8ec(87, 42, 21, 23, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caa4(0x33333, 0x6666);
    FUN_200caac(0x1570000, -1, 0x1f10000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 76, 29);
    FUN_200c8f4(0, 0, 1, 1, 21, 29);
    FUN_200c8ec(87, 42, 21, 31, 1, 2);
    FUN_200c994(40);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x2c80000, -1, 0x980000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200c90c(0x20000, 0x10000, 0x10000);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    playSound(0x121);
    FUN_200c90c(-1, -1, 58982);
    FUN_200c914();
    FUN_200c994(20);
    FUN_200c8ec(0, 40, 43, 46, 3, 3);
    FUN_200c994(20);
    final int r5 = FUN_200c260(221, 0x2c80000, 0x100000, 0x900000);
    FUN_200c994(40);
    FUN_200c924(r5, 1);
    FUN_200c91c(0x1076, 1);
    FUN_200ca7c(9, 0xe000, 0);
    FUN_200ca7c(5, 0xe000, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1ce0000, -1, 0x15e0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    FUN_200ca1c(9, 4, 30);
    FUN_200ca54(0x1074);
    FUN_200c248(9, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x2c80000, -1, 0x980000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    setFlag(0x83d);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 16
   */
  @Method(value = 0x2008a64, ignoreExtraParams = true)
  public static void FUN_2008a64() {
    FUN_200c99c();
    FUN_2008a98();
    FUN_2008d5c();
    FUN_2008f8c();
    FUN_2009450();
    FUN_200978c();
    FUN_2009d04();
    setFlag(0x83e);
    FUN_200c9a4();
    FUN_200a27c();
  }

  @Method(0x2008a98)
  public static void FUN_2008a98() {
    playSound(0x8d);

    //LAB_2008aaa
    for(int i = 0; i < 6; i++) {
      FUN_200cacc(0x4049d2, 1);
      FUN_200cadc(8);
      FUN_200c994(8);
      FUN_200cacc(0x10000, 1);
      FUN_200cadc(8);
      FUN_200c994(8);

      if(i == 1) {
        FUN_200c90c(0x10000, 0x10000, 0x10000);
      }

      //LAB_2008ae8
    }

    FUN_200c90c(0x20000, 0x10000, 0x10000);
    FUN_200c994(30);
    FUN_200caa4(0x26666, 0x4ccc);
    FUN_200caac(0xa70000, -1, 0x2110000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 65, 31);
    FUN_200c8f4(0, 0, 1, 1, 10, 31);
    FUN_200c8ec(87, 42, 10, 33, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caa4(0x66666, 0xcccc);
    FUN_200caac(0x1870000, -1, 0xb10000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 79, 9);
    FUN_200c8f4(0, 0, 1, 1, 24, 9);
    FUN_200c8ec(87, 42, 24, 11, 1, 2);
    FUN_200c994(40);
    FUN_200c90c(0, 0, 0);
    FUN_200caa4(0x26666, 0x4ccc);
    FUN_200caac(0x2470000, -1, 0xc10000, 1);
    FUN_200cab4();
    FUN_200c90c(0x10000, 0x20000, 0x10000);
    FUN_200c994(20);
    playSound(0x90);
    FUN_200c8e4(0x200d088, 91, 10);
    FUN_200c8f4(0, 0, 1, 1, 36, 10);
    FUN_200c8ec(87, 42, 36, 12, 1, 2);
    FUN_200c994(40);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0xe80000, -1, 0x1dd0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200c90c(0x20000, 0x10000, 0x10000);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    playSound(0x121);
    FUN_200c90c(-1, -1, 0xe666);
    FUN_200c914();
    FUN_200c994(20);
    FUN_200c8ec(0, 40, 13, 66, 3, 3);
    FUN_200c994(20);
    final int r5 = FUN_200c260(223, 0xe80000, 0x100000, 0x1d00000);
    FUN_200c994(40);
    FUN_200c924(r5, 1);
    FUN_200c91c(0x1077, 1);
  }

  @Method(0x2008d5c)
  public static void FUN_2008d5c() {
    playSound(0x11);
    setActorVelocityScalerAndAcceleration(0, 0x8000, 0x4000);
    FUN_200c9f4(0, 231, 490);
    FUN_200ca7c(0, 0xc000, 30);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200c994(180);
    FUN_200ca2c(0, 2);
    FUN_200c994(80);
    FUN_200ca8c(0, 0x101, 60);
    setActorVelocityScalerAndAcceleration(0, 0x8000, 0x4000);
    FUN_200c9f4(0, 246, 479);
    FUN_200ca7c(0, 0xe000, 10);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      moveActorToPosition(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_2008de8
    setActorVelocityScalerAndAcceleration(1, 0x10000, 0x8000);
    FUN_200c9f4(1, 257, 491);
    FUN_200ca7c(0, 0x2000, 0);
    FUN_200ca7c(1, 0xa000, 40);
    FUN_200ca24(0, 2);
    FUN_200ca2c(1, 2);
    FUN_200c994(20);
    FUN_200ca8c(0, 0x101, 0);
    FUN_200ca8c(1, 0x101, 80);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 4);
    setActorVelocityScalerAndAcceleration(0, 0x13333, 0x9999);
    setActorVelocityScalerAndAcceleration(1, 0x13333, 0x9999);
    FUN_200c9ec(0, 265, 453);
    FUN_200c9f4(1, 282, 469);
    setActorAnimationIfLoaded(0, 1);
    FUN_200ca7c(0, 0xe000, 0);
    FUN_200ca7c(1, 0xe000, 40);
    FUN_200ca8c(0, 0x100, 0);
    FUN_200ca8c(1, 0x100, 0);
    FUN_200ca1c(0, 6, 0);
    FUN_200ca1c(1, 6, 60);
    moveActorToPosition(5, 0x1db0000, 0x14c0000);
    moveActorToPosition(9, 0x1eb0000, 0x14c0000);
    moveActorToPosition(11, 0x1cb0000, 0x15c0000);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    FUN_200caa4(0x73333, 0xe666);
    FUN_200caac(0x1e50000, -1, 0x1590000, 1);
    FUN_200ca7c(5, 0x6000, 0);
    FUN_200ca7c(9, 0x5000, 0);
    FUN_200ca7c(11, 0x5000, 0);
    FUN_200ca7c(10, 0x5000, 0);
    FUN_200cab4();
    FUN_200c994(40);
  }

  @Method(0x2008f8c)
  public static void FUN_2008f8c() {
    playSound(0x3d);
    setActorAnimationIfLoaded(10, 4);
    FUN_200ca54(0x107d);
    FUN_200c248(10, 10);
    setActorAnimationIfLoaded(11, 4);
    FUN_200c248(11, 30);
    FUN_200ca8c(9, 0x102, 60);
    FUN_200ca1c(9, 4, 10);
    FUN_200ca1c(9, 6, 30);
    FUN_200c248(9, 10);
    FUN_200ca2c(10, 1);
    FUN_200ca7c(10, 0xb000, 10);
    FUN_200c248(10, 20);
    FUN_200ca2c(11, 1);
    FUN_200ca7c(11, 0xd000, 20);
    FUN_200c248(11, 30);
    FUN_200ca8c(9, 0x102, 60);
    FUN_200ca7c(5, 0, 0);
    FUN_200ca7c(9, 0x7000, 80);
    FUN_200ca8c(5, 0x102, 40);
    FUN_200c248(5, 20);
    FUN_200ca2c(9, 2);
    setActorAnimationIfLoaded(9, 4);
    FUN_200c248(9, 10);
    final Actor70 r6 = getMapActor(12);
    final Actor70 r0 = getMapActor(8);
    final Sprite38 r9 = r6.sprite_50.deref();
    r9._26.set(0);
    r6.scale_18.set(0x1999);
    r6._1c.set(0x1999);
    r0.scale_18.set(0x1999);
    r0._1c.set(0x1999);
    FUN_200ca44(12, 0x100);
    moveActorToPosition(12, 0x1d70000, 0x1220000);
    r6._55.set(0);
    r6.pos_08.setY(0x280000);
    FUN_200c994(1);
    FUN_200c248(12, 10);
    FUN_200ca8c(5, 0x100, 0);
    FUN_200ca8c(9, 0x100, 30);
    FUN_200ca7c(5, 0xc000, 0);
    FUN_200ca7c(9, 0xb000, 10);
    FUN_200ca7c(11, 0xd000, 0);
    FUN_200ca7c(10, 0xb000, 0);
    FUN_200caa4(0x20000, 0x4000);
    FUN_200caac(0x1d70000, -1, 0x1350000, 1);
    FUN_200cab4();
    moveActorToPosition(8, 0x1d70000, 0x1220000);
    playSound(0xbe);
    setActorPriority(12, 2);

    //LAB_2009148
    for(int i = 0; i < 90; i++) {
      r6.pos_08.y_04.sub(0x1999);
      r6.scale_18.add(0x28f);
      r6._1c.add(0x28f);
      r0.scale_18.add(0x28f);
      r0._1c.add(0x28f);
      FUN_200c994(1);
    }

    r6._55.set(5);
    FUN_200c994(80);

    //LAB_2009184
    for(int i = 0; i < 60; i++) {
      r6.pos_08.y_04.sub(0x8000);
      FUN_200c994(1);
    }

    r6._55.set(3);
    FUN_200c994(30);
    r9._26.set(1);
    moveActorToPosition(8, 0, 0);
    setActorPriority(12, 1);
    getMapActor(12).flags_23.or(0x1);
    FUN_200ca44(12, 0);
    setActorVelocityScalerAndAcceleration(12, 0x8000, 0x4000);
    FUN_200c9f4(12, 471, 306);
    FUN_200c994(40);
    FUN_200ca2c(12, 2);
    FUN_200c248(0x400c, 20);
    FUN_200ca3c(5, 9, 0);
    FUN_200c994(20);
    FUN_200ca24(5, 2);
    FUN_200ca2c(9, 2);
    FUN_200c994(40);
    FUN_200ca24(10, 1);
    FUN_200ca2c(11, 1);
    FUN_200c994(20);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_200ca7c(10, 0x5000, 0);
    FUN_200ca7c(11, 0x5000, 10);
    FUN_200c248(10, 30);
    FUN_200ca94(12, 0x102);
    FUN_200c994(60);
    FUN_200ca2c(11, 1);
    FUN_200c994(10);
    FUN_200c248(11, 30);
    FUN_200ca7c(11, 0xd000, 30);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200c994(20);
    FUN_200c248(11, 30);
    setActorAnimationAndWaitUntilFinished(12, 3);
    FUN_200c994(20);
    FUN_200ca7c(11, 0x5000, 40);
    FUN_200ca7c(9, 0x5000, 0);
    FUN_200ca7c(5, 0x6000, 20);
    setActorAnimationAndWaitUntilFinished(10, 3);
    FUN_200c994(20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1080000, -1, 0x1cc0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(40);
    FUN_200c248(10, 40);
    FUN_200ca24(0, 3);
    FUN_200ca2c(1, 3);
    FUN_200c994(80);
    FUN_200ca5c(11);

    if(FUN_200c9b4(0, 0) != 0) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    }

    //LAB_2009364
    FUN_200ca6c(9, 0, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1dd0000, -1, 0x14e0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(20);
    FUN_200ca2c(10, 2);
    FUN_200ca7c(10, 0xb000, 10);
    FUN_200ca54(0x108d);
    FUN_200c248(10, 20);
    FUN_200ca7c(5, 0x2000, 0);
    FUN_200ca7c(9, 0x3000, 10);
    setActorAnimationIfLoaded(9, 4);
    FUN_200c248(0x5009, 40);
    FUN_200ca2c(11, 1);
    FUN_200c248(11, 10);
    FUN_200ca24(5, 2);
    FUN_200ca2c(9, 2);
  }

  @Method(0x2009450)
  public static void FUN_2009450() {
    FUN_200ca7c(5, 0x6000, 0);
    FUN_200ca7c(9, 0x5000, 0);
    FUN_200ca7c(10, 0x8000, 0);
    FUN_200ca7c(12, 0x5000, 40);
    FUN_200ca7c(11, 0xd000, 40);
    FUN_200ca2c(11, 2);
    FUN_200c248(11, 20);
    FUN_200ca2c(12, 2);
    FUN_200ca94(12, 0x102);
    FUN_200c994(60);
    FUN_200c248(12, 10);
    FUN_200ca34(10, 12, 0);
    FUN_200ca34(5, 12, 0);
    FUN_200ca34(9, 12, 0);
    FUN_200c994(40);
    FUN_200ca2c(10, 1);
    FUN_200ca7c(10, 0x8000, 10);
    setActorAnimationIfLoaded(10, 3);
    FUN_200c248(10, 10);
    FUN_200ca7c(11, 0, 10);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_200c994(10);
    FUN_200ca7c(5, 0, 0);
    FUN_200ca7c(9, 0x8000, 20);
    FUN_200ca24(5, 2);
    FUN_200ca2c(9, 2);
    FUN_200c994(10);
    FUN_200ca7c(5, 0xc000, 0);
    FUN_200ca7c(9, 0xb000, 10);
    FUN_200ca7c(10, 0xb000, 40);
    setActorAnimationAndWaitUntilFinished(10, 3);
    FUN_200c248(10, 10);
    FUN_200ca8c(5, 0x100, 20);
    FUN_200ca94(12, 0x102);
    FUN_200ca2c(12, 3);
    FUN_200c994(40);
    moveActorToPosition(1, 0x15a0000, 0x1b80000);
    sleep(1);
    FUN_200ca64(1, 0);
    FUN_200ca7c(0, 0x2000, 0);
    FUN_200ca7c(1, 0xa000, 20);
    FUN_200caec();
    FUN_200caf4();
    moveActorToPosition(1, 0x1180000, 0x1d60000);
    FUN_200caac(0x1050000, -1, 0x1d20000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(20);
    FUN_200ca7c(0, 0x3000, 10);
    FUN_200ca8c(1, 0x102, 0);
    FUN_200ca2c(1, 3);
    FUN_200ca74(1, 0);
    FUN_200c994(10);
    setActorAnimationAndWaitUntilFinished(1, 4);
    FUN_200c994(10);
    FUN_200ca74(1, 0);
    FUN_200c994(10);
    FUN_200ca54(0x109b);
    FUN_200ca64(11, 0);
    FUN_200ca7c(11, 0xd000, 10);
    FUN_200ca24(0, 2);
    FUN_200ca2c(0, 2);
    FUN_200c994(10);
    FUN_200ca7c(0, 0xe000, 0);
    FUN_200ca7c(1, 0xe000, 20);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1dd0000, -1, 0x14e0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(20);
    FUN_200ca2c(9, 2);
    FUN_200c994(10);
    FUN_200ca7c(9, 0x8000, 30);
    FUN_200c248(9, 20);
    FUN_200ca7c(5, 0, 40);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200c994(20);
    FUN_200c248(5, 10);
    FUN_200ca2c(12, 2);
    FUN_200c994(80);
    FUN_200c248(12, 20);
    FUN_200ca2c(5, 2);
    FUN_200ca7c(5, 0xc000, 0);
    FUN_200ca7c(9, 0xb000, 20);
    setActorAnimationAndWaitUntilFinished(12, 3);
    FUN_200c248(12, 20);
    FUN_200ca24(5, 2);
    FUN_200ca2c(9, 2);
    FUN_200ca7c(12, 0xb000, 40);
  }

  @Method(0x200978c)
  public static void FUN_200978c() {
    int r0;
    int r1;
    int r2;
    final int r3;
    int r5;
    final int r6;

    r0 = 0xa1;
    playSound(r0);
    r0 = 0xc;
    r1 = 0x3;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);

    final Actor70 actor12 = getMapActor(12);
    if(actor12 != null) {
      r1 = actor12.pos_08.getX();
      r2 = actor12.pos_08.getZ();
      moveActorToPosition(13, r1, r2);
    }

    //LAB_20097b6
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xc;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0xd;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x3;
    FUN_200ca2c(r0, r1);
    r1 = 0x3;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r1 = 0x3;
    r0 = 0xd;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x3;
    FUN_200ca24(r0, r1);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0x9;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0xb0;
    r2 = 0x28;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0xd;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0xd;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r1 = 0x1;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0xd;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0xd;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r0 = 0xa;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0xa;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x50;
    FUN_200c248(r0, r1);
    r0 = 0xd;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0xd;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0xd;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x4;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x50;
    FUN_200c248(r0, r1);
    r0 = 0xd;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xd;
    r1 = 0x50;
    FUN_200c248(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x4;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0xa;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0xb;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0xa;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x50;
    FUN_200ca7c(r0, r1, r2);
    r2 = 0x50;
    r0 = 0x9;
    r1 = 0x105;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r1 = 0xa0;
    r2 = 0x28;
    r0 = 0xb;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0xb;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    FUN_200caec();
    FUN_200caf4();
    r1 = 0x1;
    r2 = 0xe9;
    r3 = 0x0;
    r1 = -r1;
    r2 = r2 << 17;
    r0 = 0x1050000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200c8d4();
    r0 = 0x1;
    sleep(r0);
    FUN_200cae4();
    FUN_200caf4();
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
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
    r2 = 0xef;
    r0 = 0x0;
    r1 = 0xf4;
    r2 = r2 << 1;
    FUN_200c9ec(r0, r1, r2);
    r1 = 0x82;
    r2 = 0xf5;
    r2 = r2 << 1;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x0;
    FUN_200c9fc(r0);
    r0 = 0x0;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    final Unit14c unit1 = getUnit(1);
    r5 = 0;

    //LAB_2009a70
    for(int i = 0; i < 15; i++) {
      r2 = unit1.items_d8.get(i).get() & 0x1ff;
      if(r2 >= 0xdc && r2 < 0xde || r2 == 0xdf) {
        //LAB_2009a84
        r5++;
      }

      //LAB_2009a86
    }

    r0 = 0x1;
    FUN_200ca5c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200c9b4(r0, r1);
    if(r0 == 0x0) {
      r6 = 0x10b0;
      r0 = r6;
      FUN_200ca54(r0);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200c994(r0);
      if(r5 <= 0x2) {
        r0 = 0x1;
        r1 = 0x1e;
        FUN_200c248(r0, r1);
        r2 = 0xf3;
        r2 = r2 << 1;
        r0 = 0x1;
        r1 = 0xfc;
        FUN_200c9f4(r0, r1, r2);
        r1 = 0x2;
        r0 = 0x1;
        FUN_200ca2c(r0, r1);
        r0 = 0xa;
        FUN_200c994(r0);
        r0 = r6 + 0x1;
        r1 = 0x1;
        r2 = 0x0;
        FUN_200c92c(r0, r1, r2);
      } else {
        //LAB_2009ae8
        r0 = 0x10b4;
        FUN_200ca54(r0);
        r0 = 0x1;
        r1 = 0x1e;
        FUN_200c248(r0, r1);
      }
    } else {
      //LAB_2009af8
      if(r5 <= 0x2) {
        r6 = 0x10b2;
        FUN_200ca54(0x10b2);
        FUN_200ca2c(1, 3);
        setActorAnimationAndWaitUntilFinished(1, 4);
        FUN_200c248(1, 10);
        setActorAnimationAndWaitUntilFinished(1, 4);
        FUN_200ca2c(1, 1);
        setActorVelocityScalerAndAcceleration(1, 0x20000, 0x10000);
        final Actor70 actor0 = getMapActor(0);
        actor0._5a.and(~0x1);
        FUN_200c9f4(1, 244, 478);
        setActorVelocityScalerAndAcceleration(0, 0x18000, 0xc000);
        FUN_200ca1c(0, 6, 0);
        FUN_200c9dc(0, 218, 471);
        FUN_200c9fc(0);
        FUN_200c92c(0x10b3, 1, 0);
        FUN_200ca2c(0, 2);
        FUN_200ca7c(0, 0, 30);
        actor0._5a.or(0x1);
      } else {
        //LAB_2009baa
        FUN_200ca54(0x10b5);
        FUN_200ca2c(1, 3);
        setActorAnimationAndWaitUntilFinished(1, 4);
        FUN_200c248(1, 10);
        setActorAnimationAndWaitUntilFinished(1, 4);
        FUN_200ca7c(0, 0xe000, 30);
      }
    }

    //LAB_2009bdc
    FUN_200caa4(0x8000, 0x1000);
    FUN_200ca9c(1, 1);
    FUN_200cab4();
    FUN_200ca7c(1, 0x8000, 30);
    FUN_200ca2c(1, 2);
    setActorVelocityScalerAndAcceleration(1, 0x8000, 16384);
    final Actor70 actor1 = getMapActor(1);
    actor1._5a.and(~0x1);
    FUN_200c9f4(1, 264, 482);
    actor1._5a.or(0x1);
    FUN_200c9f4(1, 278, 480);
    actor1.velocityScalar_30.set(0x30000);
    actor1.acceleration_34.set(0x20000);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 312, 470);
    setActorAnimationIfLoaded(1, 1);
    FUN_200c994(30);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 342, 470);
    setActorAnimationIfLoaded(1, 1);
    FUN_200c994(30);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 376, 470);
    setActorAnimationIfLoaded(1, 1);
  }

  @Method(0x2009d04)
  public static void FUN_2009d04() {
    FUN_200ca2c(1, 3);
    FUN_200c994(10);
    FUN_200ca7c(1, 0x3000, 0);
    FUN_200c8fc(getMapActor(14), 0);
    FUN_200ca44(14, 15);
    moveActorToPosition(14, 0x1880000, 0x1c60000);
    FUN_200c3bc();
    FUN_200ca7c(1, 0xd000, 10);
    FUN_200ca24(1, 2);
    FUN_200ca8c(1, 0x100, 40);
    FUN_200ca7c(14, 0x5000, 10);
    FUN_200ca2c(14, 2);
    FUN_200c994(20);
    FUN_200ca54(0x10b6);
    FUN_200ca64(14, 0);
    moveActorToPosition(10, 0x1d50000, 0x15c0000);
    FUN_200c994(20);
    FUN_200c248(0x200a, 10);
    FUN_200c248(0x200a, 40);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    FUN_200ca2c(1, 2);
    FUN_200c994(40);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200c994(40);
    setActorVelocityScalerAndAcceleration(1, 0x8000, 0x4000);
    FUN_200c9f4(1, 389, 468);
    FUN_200ca7c(1, 0xd000, 60);
    FUN_200c248(1, 20);
    FUN_200c92c(0x10ba, 1, 10);
    setActorVelocityScalerAndAcceleration(1, 0x8000, 0x4000);
    final Actor70 actor1 = getMapActor(1);
    actor1._5a.and(~0x1);
    FUN_200c9f4(1, 376, 470);
    FUN_200c994(30);
    actor1._5a.or(0x1);
    setActorAnimationAndWaitUntilFinished(14, 4);
    FUN_200c994(10);
    FUN_200ca54(0x10bb);
    FUN_200c248(14, 20);
    FUN_200ca8c(1, 0x101, 60);
    setActorAnimationAndWaitUntilFinished(14, 3);
    FUN_200c248(14, 20);
    FUN_200ca8c(1, 0x102, 60);
    setActorAnimationAndWaitUntilFinished(14, 3);
    FUN_200c994(20);
    FUN_200ca7c(14, 0xc000, 20);
    FUN_200ca44(14, 0x100);
    FUN_200c8fc(getMapActor(14), 0);
    final Actor70 actor14 = getMapActor(14);
    actor14._55.set(0);
    playSound(0xdc);

    //LAB_2009ee6
    for(int r5 = 0; r5 < 30; r5++) {
      actor14.pos_08.y_04.add(0x10000);
      FUN_200c994(1);
    }

    actor14._55.set(5);
    FUN_200ca24(1, 2);
    FUN_200c248(1, 10);
    FUN_200ca8c(14, 0x101, 60);
    FUN_200ca7c(14, 0x5000, 10);
    FUN_200c248(1, 20);
    FUN_200ca2c(14, 1);
    FUN_200c248(14, 20);
    FUN_200ca8c(1, 0x103, 20);
    FUN_200c248(1, 30);
    FUN_200ca8c(14, 0x105, 80);
    FUN_200ca7c(14, 0xd000, 40);
    FUN_200ca7c(10, 0x5000, 10);
    FUN_200caec();
    FUN_200caf4();
    FUN_200caac(0x1dd0000, -1, 0x14e0000, 0);
    FUN_200c8d4();
    sleep(1);
    FUN_200cae4();
    FUN_200caf4();
    FUN_200c994(20);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_200c248(10, 10);
    FUN_200ca5c(11);
    FUN_200caa4(0x66666, 0xcccc);
    FUN_200caac(0x1760000, -1, 0x1d60000, 1);
    FUN_200cab4();
    FUN_200ca7c(14, 0x5000, 0);
    FUN_200ca7c(1, 0xe000, 10);
    FUN_200ca2c(1, 2);

    if(FUN_200c9b4(1, 0) != 0) {
      FUN_200c994(10);
      setActorAnimationAndWaitUntilFinished(14, 4);
      int r0 = 0x10c3;

      //LAB_200a05e
      do {
        FUN_200ca54(r0);
        FUN_200ca5c(14);

        if(FUN_200c9b4(1, 0) != 0) {
          break;
        }

        //LAB_200a048
        FUN_200c994(20);
        setActorAnimationAndWaitUntilFinished(14, 4);
        FUN_200c994(10);
        r0 = 0x10c6;
      } while(true);
    }

    //LAB_200a076
    FUN_200c994(30);
    setActorAnimationAndWaitUntilFinished(14, 3);
    FUN_200c994(20);
    FUN_200ca54(0x10c4);
    FUN_200c248(14, 30);
    setActorAnimationAndWaitUntilFinished(14, 3);
    FUN_200c994(10);
    FUN_200c248(14, 30);
    actor14._55.set(0);
    setActorVelocityScalerAndAcceleration(14, 0x26666, 0x13333);
    moveActorTo(actor14, 0x1cc0000, 0, 0x1680000);
    FUN_200c9fc(14);
    FUN_200ca44(14, 0);
    FUN_200c8fc(getMapActor(14), 1);
    FUN_200c994(30);
    FUN_200ca9c(1, 1);
    FUN_200cab4();
    FUN_200c994(40);
    FUN_200ca8c(1, 0x103, 40);
    FUN_200ca2c(1, 3);
    FUN_200c994(20);
    actor1._5a.or(0x1);
    actor1.velocityScalar_30.set(0x30000);
    actor1.acceleration_34.set(0x20000);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 342, 470);
    setActorAnimationIfLoaded(1, 1);
    FUN_200c994(30);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 312, 470);
    setActorAnimationIfLoaded(1, 1);
    FUN_200c994(30);
    playSound(0x99);
    actor1.velocity_24.setY(0x60000);
    setActorAnimationIfLoaded(1, 7);
    FUN_200c9e4(1, 278, 480);
    setActorAnimationIfLoaded(1, 1);
    FUN_200c994(30);
    FUN_200caa4(0x8000, 0x1000);
    FUN_200ca9c(0, 1);
    setActorVelocityScalerAndAcceleration(1, 0x19999, 0xcccc);
    FUN_200ca3c(0, 1, 0);
    FUN_200c994(30);
    setActorAnimationAndWaitUntilFinished(1, 3);
    setActorAnimationAndWaitUntilFinished(0, 4);
    FUN_200ca2c(1, 2);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200c994(20);
    setActorAnimationIfLoaded(1, 2);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      FUN_200c9dc(1, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_200a232
    FUN_200c9fc(1);
    moveActorToPosition(1, 0, 0);
    FUN_200c98c(220);
    FUN_200c98c(221);
    FUN_200c98c(223);
  }

  @Method(0x200a27c)
  public static void FUN_200a27c() {
    final Actor70 r10 = getMapActor(0);

    FUN_200c99c();

    FUN_200c9cc(5, 1);
    FUN_200c9cc(9, 1);
    FUN_200c9cc(11, 1);
    FUN_200c9cc(10, 1);
    FUN_200c9cc(14, 1);
    FUN_200c9cc(13, 1);

    moveActorToPosition(5, 0x1db0000, 0x14c0000);
    moveActorToPosition(9, 0x1eb0000, 0x14c0000);
    moveActorToPosition(11, 0x1cb0000, 0x15c0000);
    moveActorToPosition(10, 0x1fb0000, 0x15c0000);
    moveActorToPosition(14, 0x1cc0000, 0x1680000);
    moveActorToPosition(13, 0x1d70000, 0x1320000);

    final Actor70 actor5 = getMapActor(5);
    actor5.parent_68.set(r10);
    actor5._5a.or(0x1);
    setActorSpriteScript(actor5, 0x200cbd0);

    final Actor70 actor9 = getMapActor(9);
    actor9.parent_68.set(r10);
    actor9._5a.or(0x1);
    setActorSpriteScript(actor9, 0x200cbd0);

    final Actor70 actor11 = getMapActor(11);
    actor11.parent_68.set(r10);
    actor11._5a.or(0x1);
    setActorSpriteScript(actor11, 0x200cbd0);

    final Actor70 actor10 = getMapActor(10);
    actor10.parent_68.set(r10);
    actor10._5a.or(0x1);
    setActorSpriteScript(actor10, 0x200cbd0);

    final Actor70 actor14 = getMapActor(14);
    actor14.parent_68.set(r10);
    actor14._5a.or(0x1);
    actor14.scale_18.set(0x10000);
    actor14._1c.set(0x10000);
    actor14._55.set(actor11._55.get());
    actor14.pos_08.setY(0);
    setActorSpriteScript(actor14, 0x200cbd0);

    final Actor70 actor13 = getMapActor(13);
    actor13.parent_68.set(r10);
    actor13._5a.or(0x1);
    setActorSpriteScript(actor13, 0x200cbd0);

    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 17
   */
  @Method(value = 0x200a400, ignoreExtraParams = true)
  public static void FUN_200a400() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    CPU.sp().value -= 0x8;
    FUN_200c99c();
    r0 = 0x8d;
    playSound(r0);
    r5 = 0x0;

    //LAB_200a410
    do {
      r1 = 0x1;
      r0 = 0x4039d2;
      FUN_200cacc(r0, r1);
      r0 = 0x8;
      FUN_200cadc(r0);
      r0 = 0x8;
      FUN_200c994(r0);
      r0 = 0x80;
      r0 = r0 << 9;
      r1 = 0x1;
      FUN_200cacc(r0, r1);
      r0 = 0x8;
      FUN_200cadc(r0);
      r0 = 0x8;
      FUN_200c994(r0);
      if(r5 == 0x1) {
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r0 = r0 << 9;
        r1 = r1 << 9;
        r2 = r2 << 9;
        FUN_200c90c(r0, r1, r2);
      }

      //LAB_200a44e
      r3 = r5 + 0x1;
      r3 = r3 << 24;
      r5 = r3 >>> 24;
    } while(r5 != 0x6);

    r0 = 0x121;
    playSound(r0);
    r0 = 0x1;
    r1 = 0x1;
    r0 = -r0;
    r1 = -r1;
    r2 = 0xe666;
    FUN_200c90c(r0, r1, r2);
    r3 = 0x3;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r1 = 0x28;
    r2 = 0xd;
    r3 = 0x2e;
    r0 = 0x0;
    FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xe8;
    r2 = 0x80;
    r3 = 0x90;
    r3 = r3 << 16;
    r2 = r2 << 13;
    r1 = r1 << 16;
    r0 = 0xde;
    r0 = FUN_200c260(r0, r1, r2, r3);
    r5 = r0;
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = r5;
    r1 = 0x1;
    FUN_200c924(r0, r1);
    r0 = 0x1078;
    r1 = 0x1;
    FUN_200c91c(r0, r1);
    r0 = 0x5;
    r1 = 0x1330000;
    r2 = 0x1150000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1330000;
    r2 = 0x1150000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x1330000;
    r2 = 0x1150000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x1330000;
    r2 = 0x1150000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xe;
    r1 = 0x1330000;
    r2 = 0x1150000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xe8;
    r2 = 0x9c;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200c994(r0);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      moveActorToPosition(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_200a50e
    r0 = 0x1;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xda;
    r2 = 0xac;
    FUN_200c9f4(r0, r1, r2);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200ca3c(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x91;
    playSound(r0);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 11;
    r2 = r2 << 9;
    r0 = r0 << 11;
    FUN_200c90c(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 9;
    r2 = r2 << 9;
    r0 = r0 << 9;
    FUN_200c90c(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x32;
    r0 = 0x1;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x90;
    playSound(r0);
    r0 = 0xc0;
    r1 = 0xc0;
    r2 = 0x80;
    r0 = r0 << 10;
    r1 = r1 << 10;
    r2 = r2 << 9;
    FUN_200c90c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x32;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 9;
    r2 = r2 << 9;
    FUN_200c90c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x32;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x90;
    playSound(r0);
    r0 = 0xc0;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_200c90c(r0, r1, r2);
    r0 = 0x1e;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x2;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    r2 = 0x14;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0x6;
    r0 = 0x1;
    r2 = 0x28;
    FUN_200ca1c(r0, r1, r2);
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200caec();
    FUN_200caf4();
    r0 = 0x2;
    FUN_200cabc(r0);
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200cfa4 handler 0
   */
  @Method(value = 0x200a674, ignoreExtraParams = true)
  public static void FUN_200a674() {
    int r0;
    int r1;
    final int r2;

    FUN_200c99c();
    r0 = 0x83e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x10cb;
      FUN_200ca54(r0);
      r0 = 0x9;
      r1 = 0x0;
      FUN_200ca64(r0, r1);
    } else {
      //LAB_200a694
      r0 = 0x83c;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x1079;
        FUN_200ca54(r0);
      } else {
        //LAB_200a6a6
        r0 = 0x107b;
        FUN_200ca54(r0);
      }

      //LAB_200a6ac
      r1 = 0x0;
      r0 = 0x9;
      r2 = 0x0;
      FUN_200ca3c(r0, r1, r2);
      r0 = 0xa;
      FUN_200c994(r0);
      r0 = 0x9;
      r1 = 0x0;
      FUN_200ca64(r0, r1);
    }

    //LAB_200a6c4
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 7
   */
  @Method(value = 0x200a6e0, ignoreExtraParams = true)
  public static void FUN_200a6e0() {
    int r0;
    int r1;
    final int r2;

    FUN_200c99c();
    r0 = 0x83e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x10c9;
      FUN_200ca54(r0);
      r0 = 0x5;
      r1 = 0x0;
      FUN_200ca64(r0, r1);
    } else {
      //LAB_200a700
      r0 = 0x83c;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x107a;
        FUN_200ca54(r0);
      } else {
        //LAB_200a712
        r0 = 0x107c;
        FUN_200ca54(r0);
      }

      //LAB_200a718
      r1 = 0x0;
      r0 = 0x5;
      r2 = 0x0;
      FUN_200ca3c(r0, r1, r2);
      r0 = 0xa;
      FUN_200c994(r0);
      r0 = 0x5;
      r1 = 0x0;
      FUN_200ca64(r0, r1);
    }

    //LAB_200a730
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 2
   */
  @Method(value = 0x200a74c, ignoreExtraParams = true)
  public static void FUN_200a74c() {
    int r0;
    final int r1;

    FUN_200c99c();
    r0 = 0x10ca;
    FUN_200ca54(r0);
    r0 = 0xa;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 9
   */
  @Method(value = 0x200a76c, ignoreExtraParams = true)
  public static void FUN_200a76c() {
    int r0;
    final int r1;

    FUN_200c99c();
    r0 = 0x10c7;
    FUN_200ca54(r0);
    r0 = 0xb;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 4
   */
  @Method(value = 0x200a78c, ignoreExtraParams = true)
  public static void FUN_200a78c() {
    int r0;
    final int r1;

    FUN_200c99c();
    r0 = 0x10c8;
    FUN_200ca54(r0);
    r0 = 0xd;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 5
   */
  @Method(value = 0x200a7ac, ignoreExtraParams = true)
  public static void FUN_200a7ac() {
    int r0;
    final int r1;

    FUN_200c99c();
    r0 = 0x10cc;
    FUN_200ca54(r0);
    r0 = 0xe;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 11
   */
  @Method(value = 0x200a7cc, ignoreExtraParams = true)
  public static void FUN_200a7cc() {
    int r0;
    final int r1;

    FUN_200c99c();
    r0 = 0x1072;
    FUN_200ca54(r0);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    FUN_200c9a4();
  }

  /**
   * Event list 0x200cfa4 handler 13
   */
  @Method(value = 0x200a7ec, ignoreExtraParams = true)
  public static void FUN_200a7ec() {
    FUN_200cac4();
  }

  @Method(0x200a7f8)
  public static void FUN_200a7f8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r11;

    CPU.sp().value -= 0x8;
    FUN_200c99c();
    r3 = 0x1b;
    r2 = 0x11;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x1b;
    r1 = 0x10;
    r2 = 0x5;
    r3 = 0x1;
    FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r1 = 0x1;
    r2 = 0x1050000;
    r1 = -r1;
    r3 = 0x0;
    r0 = 0x1d70000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    FUN_200c8d4();

    final Actor70 actor8 = getMapActor(8);
    actor8.scale_18.set(0x1999);
    actor8._1c.set(0x1999);

    final Actor70 actor0 = getMapActor(0);
    final Sprite38 sprite0 = actor0.sprite_50.deref();
    sprite0._26.set(0);
    actor0.scale_18.set(0x1999);
    actor0._1c.set(0x1999);
    FUN_200ca44(0, 0x100);
    r2 = 0x91;
    r0 = 0x0;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    moveActorToPosition(r0, r1, r2);
    actor0._55.set(0);
    actor0.pos_08.setY(0x280000);
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r2 = r1 + 0x1c0;
    MEMORY.ref(4, r2).setu(0x203);
    r2 = r1 + 0x1c8;
    MEMORY.ref(4, r2).setu(0x20);
    FUN_200cae4();
    FUN_200caf4();
    r0 = 0x14;
    FUN_200c994(r0);
    r2 = 0x91;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xbe;
    playSound(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorPriority(r0, r1);
    r5 = 0x0;

    //LAB_200a8c0
    do {
      actor0.pos_08.y_04.sub(0x1999);
      actor0.scale_18.add(0x28f);
      actor0._1c.add(0x28f);
      actor8.scale_18.add(0x28f);
      actor8._1c.add(0x28f);
      FUN_200c994(1);
      r5 = r5 + 0x10000;
      r3 = r5 >>> 16;
    } while(r3 != 0x5a);

    actor0._55.set(5);
    r0 = 0x50;
    FUN_200c994(r0);
    r0 = 0x4ccc;
    r1 = 0x999;
    FUN_200caa4(r0, r1);
    r1 = 0x1;
    r2 = 0x91;
    r0 = 0x1d70000;
    r1 = -r1;
    r2 = r2 << 17;
    r3 = 0x1;
    FUN_200caac(r0, r1, r2, r3);
    r5 = 0x0;

    //LAB_200a91a
    do {
      actor0.pos_08.y_04.sub(0x8000);
      FUN_200c994(1);
      r5 = r5 + 0x10000;
      r3 = r5 >>> 16;
    } while(r3 != 0x3c);

    actor0._55.set(3);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x1;
    r0 = 0x0;
    setActorPriority(r0, r1);
    getMapActor(0).flags_23.or(0x1);
    r1 = 0x0;
    r0 = 0x0;
    FUN_200ca44(r0, r1);
    sprite0._26.set(1);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    FUN_200cab4();
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200ca9c(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x9b;
    r2 = r2 << 1;
    r1 = 0x1d7;
    r0 = 0x0;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r5 = 0x0;

    if(actor0 != null) {
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(5, r1, r2);
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(1, r1, r2);
    }

    //LAB_200a9da
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x97;
    r0 = 0x5;
    r1 = 0x1c5;
    r2 = r2 << 1;
    FUN_200c9ec(r0, r1, r2);
    r2 = 0x97;
    r2 = r2 << 1;
    r0 = 0x1;
    r1 = 0x1e9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x5;
    r1 = r1 << 7;
    r2 = 0xa;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x1;
    r1 = 0x2;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    FUN_200ca24(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200ca94(r0, r1);
    r1 = 0x81;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200ca94(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200ca94(r0, r1);
    r0 = 0x3c;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xad;
    r0 = 0x0;
    r1 = 0x1d7;
    r2 = r2 << 1;
    FUN_200c9ec(r0, r1, r2);
    r2 = 0xa9;
    r0 = 0x5;
    r1 = 0x1af;
    r2 = r2 << 1;
    FUN_200c9ec(r0, r1, r2);
    r2 = 0xa9;
    r2 = r2 << 1;
    r1 = 0x1ff;
    r0 = 0x1;
    FUN_200c9ec(r0, r1, r2);
    r0 = 0x0;
    FUN_200c9fc(r0);
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    FUN_200c9fc(r0);
    r1 = 0x1;
    r0 = 0x5;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    FUN_200c9fc(r0);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x0;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x3c;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x3c;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200ca7c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x0;
    r1 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x28;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x101;
    r2 = 0x3c;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 7;
    r2 = 0x3c;
    r0 = 0x5;
    FUN_200ca7c(r0, r1, r2);
    final Actor70 actor9 = getMapActor(9);
    final Sprite38 sprite9 = actor9.sprite_50.deref();
    sprite9._26.set(0);
    actor9.scale_18.set(0x1999);
    actor9._1c.set(0x1999);
    actor8.scale_18.set(0x1999);
    actor8._1c.set(0x1999);
    FUN_200ca44(9, 0x100);
    r2 = 0x91;
    r2 = r2 << 17;
    r1 = 0x1d70000;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    actor9._55.set(r5);
    actor9.pos_08.setY(0x280000);
    r0 = 0x1;
    FUN_200c994(r0);
    r0 = 0x103c;
    FUN_200ca54(r0);
    r0 = 0x9;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    r0 = 0x0;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x28;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x0;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 10;
    r1 = r1 << 7;
    FUN_200caa4(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x1d70000;
    r1 = -r1;
    r2 = 0x1350000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r2 = 0x91;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xbe;
    playSound(r0);
    r0 = 0x9;
    r1 = 0x2;
    setActorPriority(r0, r1);
    r5 = 0x0;

    //LAB_200ad34
    do {
      actor9.pos_08.y_04.sub(0x1999);
      actor9.scale_18.add(0x28f);
      actor9._1c.add(0x28f);
      actor8.scale_18.add(0x28f);
      actor8._1c.add(0x28f);
      FUN_200c994(1);
      r5 = r5 + 0x10000;
      r3 = r5 >>> 16;
    } while(r3 != 0x5a);

    actor9._55.set(5);
    r0 = 0x50;
    FUN_200c994(r0);
    r5 = 0x0;

    //LAB_200ad76
    do {
      actor9.pos_08.y_04.sub(0x8000);
      FUN_200c994(1);
      r3 = r5 + 0x10000;
      r5 = r3;
      r3 = r5 >>> 16;
    } while(r3 != 0x3c);

    actor9._55.set(3);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0x1;
    r0 = 0x9;
    setActorPriority(r0, r1);
    getMapActor(9).flags_23.or(0x1);
    r1 = 0x0;
    r0 = 0x9;
    FUN_200ca44(r0, r1);
    sprite9._26.set(1);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1e;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x99;
    r1 = 0x1d7;
    r2 = r2 << 1;
    r0 = 0x9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r2 = 0x50;
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r2 = 0x1e;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x26666;
    r2 = 0x13333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x99;
    r0 = 0x9;
    r1 = 0x1a7;
    r2 = r2 << 1;
    FUN_200c9f4(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r2 = 0x99;
    r0 = 0x9;
    r1 = 0x207;
    r2 = r2 << 1;
    FUN_200c9f4(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r5 = 0x4009;
    r1 = 0x4;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = r5;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r2 = 0x0;
    r1 = 0x5;
    r0 = 0x0;
    FUN_200ca3c(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r2 = 0x28;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r1 = 0xa0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = r5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x5;
    r1 = 0x101;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = r5;
    r1 = 0xa;
    FUN_200c248(r0, r1);
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
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 8;
    r1 = r1 << 5;
    FUN_200caa4(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x2150000;
    r1 = -r1;
    r2 = 0x1530000;
    FUN_200caac(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x215;
    r2 = 0x153;
    FUN_200c9f4(r0, r1, r2);
    FUN_200cab4();
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x3c;
    r0 = 0x9;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200ca9c(r0, r1);
    r0 = 0x9;
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xb4;
    r1 = 0x1c7;
    r2 = r2 << 1;
    r0 = 0x9;
    FUN_200c9ec(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r2 = 0xb4;
    r1 = 0x1c7;
    r2 = r2 << 1;
    r0 = 0x9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xa0;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r2 = 0xb4;
    r1 = 0x1d7;
    r2 = r2 << 1;
    r0 = 0x9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x1e;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x9;
    r1 = r1 << 1;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r0 = 0x5;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xdc;
    r2 = 0xad;
    r1 = r1 << 1;
    r2 = r2 << 1;
    r0 = 0x5;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x5;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x1;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xad;
    r1 = 0x1ef;
    r2 = r2 << 1;
    r0 = 0x1;
    FUN_200c9f4(r0, r1, r2);
    FUN_200cab4();
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0xc0;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200ca5c(r0);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200c9b4(r0, r1);
    if(r0 == 0x1) {
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200b20e
    r1 = 0xc0;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x1e;
    r0 = 0x9;
    FUN_200c248(r0, r1);
    r0 = 0x1048;
    FUN_200ca54(r0);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x9;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200ca94(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x14;
    r1 = r1 << 6;
    r0 = 0x1;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9d4(r0);
    r0 = 0x0;
    FUN_200c9d4(r0);
    r0 = 0x5;
    FUN_200c9d4(r0);
    r0 = 0x1;
    FUN_200c9d4(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 12;
    r1 = r1 << 9;
    FUN_200caa4(r0, r1);
    r1 = 0x1;
    r2 = 0xe8;
    r3 = 0x1;
    r0 = 0x2c70000;
    r1 = -r1;
    r2 = r2 << 17;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r2 = 0x1610000;
    r1 = 0x24d0000;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x1009;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    r2 = 0xb4;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x1;
    r2 = 0xb9;
    r3 = 0x1;
    r2 = r2 << 17;
    r1 = -r1;
    r0 = 0x1d70000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0xd0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x1;
    r2 = 0x93;
    r3 = 0x1;
    r0 = 0x2c70000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r1 = 0x95;
    r2 = 0xee;
    r2 = r2 << 16;
    r1 = r1 << 18;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x1009;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    r2 = 0xb4;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x1;
    r2 = 0xb9;
    r3 = 0x1;
    r2 = r2 << 17;
    r1 = -r1;
    r0 = 0x1d70000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r1 = 0xa0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0xe7;
    r1 = 0x1;
    r2 = 0x93;
    r3 = 0x1;
    r0 = r0 << 16;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r1 = 0x9a;
    r2 = 0xfa;
    r2 = r2 << 16;
    r1 = r1 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x2009;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    r2 = 0xb4;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x1;
    r2 = 0xb9;
    r3 = 0x1;
    r2 = r2 << 17;
    r1 = -r1;
    r0 = 0x1d70000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = 0x9;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x5;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0xe7;
    r1 = 0x1;
    r2 = 0xe8;
    r3 = 0x1;
    r0 = r0 << 16;
    r1 = -r1;
    r2 = r2 << 17;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r1 = 0x99;
    r2 = 0xb5;
    r2 = r2 << 17;
    r1 = r1 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = 0x2009;
    r1 = 0x0;
    FUN_200ca64(r0, r1);
    r2 = 0xb4;
    r1 = 0x1d70000;
    r2 = r2 << 17;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x1;
    r2 = 0xb9;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 17;
    r0 = 0x1d70000;
    FUN_200caac(r0, r1, r2, r3);
    FUN_200cab4();
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0x82;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x3c;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x28;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x28;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = 0xa009;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    FUN_200ca24(r0, r1);
    r0 = 0xa009;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x101;
    r2 = 0x3c;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x0;
    r0 = 0x8009;
    FUN_200ca5c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200c9b4(r0, r1);
    if(r0 == 0x1) {
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200b67a
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa;
    r0 = 0x1;
    FUN_200c248(r0, r1);
    r0 = 0x1056;
    FUN_200ca54(r0);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    r2 = 0x28;
    FUN_200ca1c(r0, r1, r2);
    r2 = 0x8009;
    r11 = r2;
    r0 = r11;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r2 = 0x50;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200ca94(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r0 = r11;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r1 = 0x83;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x83;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x83;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x3c;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x0;
    r0 = r11;
    FUN_200ca5c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200c9b4(r0, r1);
    if(r0 == 0x1) {
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200b750
    r1 = 0x1;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = r11;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r0 = 0x105b;
    FUN_200ca54(r0);
    r0 = 0x5;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0xb0;
    r2 = 0xa;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r2 = 0x28;
    r0 = 0x9;
    r1 = 0x4;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0xa009;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r0 = 0x5;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0xc0;
    r2 = 0xa;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = r11;
    r1 = 0x28;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x105;
    r2 = 0x78;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x107;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x1;
    r1 = 0x4;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x1;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x50;
    r0 = 0x9;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = r11;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r2 = 0x1e;
    r0 = 0x0;
    r1 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x28;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200ca94(r0, r1);
    r1 = 0x81;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200ca94(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200ca94(r0, r1);
    r0 = 0x50;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x28;
    r0 = r11;
    FUN_200c248(r0, r1);
    r0 = 0x6;
    sleep(r0);
    r2 = 0xc0;
    r3 = 0x80;
    r3 = r3 << 10;
    r2 = r2 << 10;
    r6 = 0xc0;
    actor9.velocityScalar_30.set(r2);
    actor9.acceleration_34.set(r3);
    r6 = r6 << 11;
    r0 = 0x99;
    playSound(r0);
    r1 = 0x1d7;
    r2 = 0x18b;
    actor9.velocity_24.setY(r6);
    r0 = 0x9;
    FUN_200c9e4(r0, r1, r2);
    r0 = 0x6;
    sleep(r0);
    r0 = 0x9;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    actor9._5a.and(~0x1);
    r1 = 0x1d9;
    r2 = 0x18b;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r2 = 0x18b;
    r1 = 0x1d5;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r2 = 0x18b;
    r1 = 0x1d7;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1d7;
    r2 = 0x19b;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xed;
    actor9._5a.and(~0x1);
    r1 = r1 << 1;
    r2 = 0x19b;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r0 = 0x9;
    r1 = 0x3;
    FUN_200ca2c(r0, r1);
    r1 = 0xea;
    r2 = 0x19b;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r0 = 0x9;
    r1 = 0x3;
    FUN_200ca2c(r0, r1);
    r2 = 0x19b;
    r1 = 0x1d7;
    r0 = 0x9;
    FUN_200c9dc(r0, r1, r2);
    r0 = 0x9;
    FUN_200c9fc(r0);
    r1 = 0x81;
    r0 = 0x9;
    r1 = r1 << 1;
    FUN_200ca94(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    FUN_200ca24(r0, r1);
    r0 = 0x9;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r0 = 0x9;
    r1 = 0x3333;
    r2 = 0x1999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x18b;
    r0 = 0x9;
    r1 = 0x1d7;
    FUN_200c9f4(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x9;
    FUN_200c9cc(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0xc0;
    actor9._5a.or(0x1);
    r1 = r1 << 8;
    r2 = 0x3c;
    r0 = 0x9;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x6;
    sleep(r0);
    actor9.velocityScalar_30.set(0x30000);
    actor9.acceleration_34.set(0x20000);
    r0 = 0x99;
    playSound(r0);
    r2 = 0xb4;
    r1 = 0x1d7;
    r2 = r2 << 1;
    actor9.velocity_24.setY(0x60000);
    r0 = 0x9;
    FUN_200c9e4(r0, r1, r2);
    r0 = 0x6;
    sleep(r0);
    r0 = 0x28;
    FUN_200c994(r0);
    r1 = 0x81;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x50;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x50;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x1;
    FUN_200ca2c(r0, r1);
    r2 = 0x28;
    r0 = 0x5;
    r1 = 0x107;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r1 = 0xb0;
    r2 = 0x28;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa009;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x1e;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x83;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x3c;
    FUN_200ca8c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x5;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200ca1c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x28;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200ca24(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x28;
    FUN_200c994(r0);
    r2 = 0x1e;
    r0 = 0x0;
    r1 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0xd0;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = r11;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200ca24(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r2 = 0x1e;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x5;
    FUN_200ca5c(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);

    //LAB_200bc92
    do {
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200c9b4(r0, r1);
      if(r0 == 0x0) {
        break;
      }

      //LAB_200bc70
      r0 = 0x1068;
      FUN_200ca54(r0);
      r0 = 0x5;
      r1 = 0x107;
      r2 = 0x0;
      FUN_200ca8c(r0, r1, r2);
      r0 = 0x5;
      r1 = 0x4;
      r2 = 0x3c;
      FUN_200ca1c(r0, r1, r2);
      r0 = 0x5;
      r1 = 0x0;
      FUN_200ca5c(r0);
    } while(true);

    r0 = 0x1069;
    FUN_200ca54(r0);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x5;
    r1 = r1 << 6;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0xa;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x1e;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3333;
    r2 = 0x1999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xb0;
    r2 = r2 << 1;
    r1 = 0x1d7;
    r0 = 0x9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r5 = 0x8009;
    r1 = 0x2;
    r0 = 0x9;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = r5;
    r1 = 0x3c;
    FUN_200c248(r0, r1);
    actor9._5a.and(~0x1);
    r1 = 0xe4;
    r2 = 0xb4;
    r2 = r2 << 1;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200c9f4(r0, r1, r2);
    r0 = 0x14;
    FUN_200c994(r0);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200ca2c(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x106d;
    FUN_200ca54(r0);
    r0 = 0x5;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r1 = 0xb0;
    r2 = 0x1e;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r2 = 0x3c;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0xd0;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = r5;
    r1 = 0x14;
    FUN_200c248(r0, r1);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200ca7c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200ca8c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200ca8c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200ca2c(r0, r1);
    r0 = r5;
    r1 = 0xa;
    FUN_200c248(r0, r1);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x9;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r0 = r5;
    r1 = 0x1e;
    FUN_200c248(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c994(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200ca7c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200ca2c(r0, r1);
    r0 = 0x1e;
    FUN_200c994(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200c994(r0);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200c9dc(1, r1, r2);
    }

    //LAB_200be94
    r0 = 0x1;
    FUN_200c9fc(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x1;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x83b;
    setFlag(r0);
    r0 = 0x5;
    removeCharAndHealRemainingChars(r0);
    FUN_200c328();
    r3 = 0x1b;
    r2 = 0x11;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r1 = 0x0;
    r0 = 0x8;
    r2 = 0x5;
    r3 = 0x1;
    FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x3001ebc;
    r2 = 0xe4;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x10;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x12f;
    clearFlag(r0);
    FUN_200c9a4();
    CPU.sp().value += 0x8;
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x200bf24)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r6 = CPU.r11().value;
    r5 = CPU.r10().value;
    CPU.push(r6);
    CPU.push(r5);
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r6);
    CPU.push(r5);
    r0 = 0x80;
    r0 = r0 << 9;
    r1 = 0x0;
    CPU.sp().value -= 0x8;
    FUN_200cad4(r0, r1);
    r0 = 0xa2;
    r0 = r0 << 1;
    setFlag(r0);

    //LAB_200bf4a
    for(r5 = 15; r5 < 25; r5++) {
      getMapActor(r5)._59.set(0);
      setActorPriority(r5, 1);
    }

    r0 = 0xf;
    r1 = 0x10;
    FUN_200c78c(r0, r1);
    r0 = 0x83b;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xe4;
      r2 = 0xb4;
      r0 = 0x9;
      r1 = r1 << 17;
      r2 = r2 << 17;
      moveActorToPosition(r0, r1, r2);
      r1 = 0xdc;
      r2 = 0xad;
      r0 = 0x5;
      r1 = r1 << 17;
      r2 = r2 << 17;
      moveActorToPosition(r0, r1, r2);
    }

    //LAB_200bf90
    r0 = 0x83c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r5 = 0x3;
      r0 = 0x0;
      r1 = 0x28;
      r2 = 0x2b;
      r3 = 0x42;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = 0x4;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r10().value = r2;
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x60;
      r3 = 0x1d;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x29;
      r2 = 0x1d;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r11().value = r3;
      CPU.r9().value = r2;
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r6 = 0x1;
      CPU.r8().value = r3;
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x29;
      r3 = 0x1f;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r10().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x4a;
      r3 = 0x1d;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x13;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r3 = CPU.r9().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x13;
      r3 = 0x1f;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = CPU.r10().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x60;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0xa;
      r2 = CPU.r11().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x29;
      r3 = 0xc;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200c05e
    r0 = 0x83d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r6 = 0x3;
      r0 = 0x0;
      r1 = 0x28;
      r2 = 0x2b;
      r3 = 0x2e;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = 0x4;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r8().value = r2;
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x54;
      r3 = 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x1d;
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r11().value = r3;
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x1;
      r2 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r10().value = r3;
      CPU.r9().value = r2;
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x1d;
      r3 = 0x6;
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x4c;
      r3 = 0x15;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r5 = 0x15;
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r10().value;
      r3 = CPU.r9().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x15;
      r3 = 0x17;
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x4c;
      r3 = 0x1d;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = CPU.r11().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r10().value;
      r3 = CPU.r9().value;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x15;
      r3 = 0x1f;
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200c12c
    r0 = 0x83e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r5 = 0x3;
      r0 = 0x0;
      r1 = 0x28;
      r2 = 0xd;
      r3 = 0x42;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = 0x4;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r10().value = r2;
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x41;
      r3 = 0x1f;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0xa;
      CPU.r9().value = r3;
      r2 = CPU.r9().value;
      r3 = 0x1f;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r6 = 0x1;
      CPU.r8().value = r3;
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0xa;
      r3 = 0x21;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r10().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x4f;
      r3 = 0x9;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x18;
      r2 = 0x9;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x18;
      r3 = 0xb;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r10().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x53;
      r1 = 0x28;
      r2 = 0x5b;
      r3 = 0xa;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x24;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r3 = CPU.r9().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x1;
      r3 = 0x1;
      FUN_200c8f4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r2 = CPU.r8().value;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x57;
      r1 = 0x2a;
      r2 = 0x24;
      r3 = 0xc;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_200c8ec(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      FUN_200a27c();
    }

    //LAB_200c1fe
    r0 = 0x83b;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r3 = 0x2000240;
      r2 = 0xe1;
      r2 = r2 << 1;
      r3 = r3 + r2;
      r2 = 0x0;
      r3 = MEMORY.ref(2, r3 + r2).get();
      if(r3 == 0xa) {
        FUN_200a7f8();
      }
    }

    //LAB_200c21c
    r0 = 0x0;
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    r3 = CPU.pop();
    CPU.r11().value = r3;
    return r0;
  }

  @Method(0x200c248)
  public static void FUN_200c248(final int mapActorIndex, final int sleepFrames) {
    FUN_200ca64(mapActorIndex, 0);
    FUN_200c994(sleepFrames);
  }

  @Method(0x200c260)
  public static int FUN_200c260(final int itemId, final int x, final int y, final int z) {
    final Actor70 r6 = loadActor(22, x, y, z);
    final int r7 = getCharUnitIdWhoHasItemId(224);
    final int r9 = getUnitItemSlotForItemId(r7, 224);

    if(r6 != null) {
      setActorSpriteScript(r6, 0x200cbe4);
      final Sprite38 r5 = r6.sprite_50.deref();
      r5._26.set(0);
      r5.layerCount_27.set(0);
      r5.packet_00.attribs_04.flags_01.and(~0x20);
      r5.packet_00.attribs_04.attrib2_04.and(0xfff);
      r6.velocity_24.setY(0x28000);
      r6._48.set(0x4000);
      final int r8 = mallocSlotChip(17, 0x608);
      FUN_200c934(itemId);
      allocateSpriteSlot(r5.slot_1c.get(), 0x80, r8 + 0x400);
      freeSlot(17);
      playSound(0x53);
      FUN_200cafc(r6, 3);
      FUN_200c984(r7, r9);
      addItem(r7, itemId);
      clearActor(r6);
      setActorAnimationIfLoaded(0, 1);
    }

    //LAB_200c316
    return r7;
  }

  @Method(0x200c328)
  public static void FUN_200c328() {
    CPU.sp().value -= 0x8;
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int r7 = r6._1d8.get();
    playSound(0x53);
    FUN_200cb04(224, 3);
    FUN_200c91c(0x111b, 1);

    //LAB_200c350
    while(30 - getUnitItemCount(0) - getUnitItemCount(1) <= 3) {
      FUN_200c91c(0x111c, 1);

      if(FUN_200cb0c(CPU.sp().value + 0x4, CPU.sp().value) != -1) {
        FUN_200c984(MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value).get());
      }
    }

    //LAB_200c388
    giveItem(224);
    giveItem(224);
    giveItem(224);
    giveItem(224);
    r6._1d8.set(r7);
    CPU.sp().value += 0x8;
  }

  @Method(0x200c3bc)
  public static void FUN_200c3bc() {
    CPU.sp().value -= 0x38;
    final Actor70 r10 = getMapActor(14);
    playSound(0xbe);
    FUN_200c8fc(r10, 0);
    final int r7 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r7).setu(1);
    MEMORY.ref(4, r7 + 0x4).setu(5);
    MEMORY.ref(4, r7 + 0x8).setu(0x6666);
    MEMORY.ref(4, r7 + 0xc).setu(0x30000);
    MEMORY.ref(2, r7 + 0x18).setu(0x11c);

    //LAB_200c3fe
    for(int r8 = 0; r8 < 32; r8++) {
      FUN_200c994(1);

      if((r8 & 0x1) == 0) {
        FUN_200813c(r10.pos_08.getX() + (rand() * 24 & ~0xffff) - 0xc0000, r10.pos_08.getY() + (rand() * 32 & ~0xffff) + 0x200000, r10.pos_08.getZ(), 0, -0x40000, 0, 0x1b0000, r7);
      }

      //LAB_200c454
      if(r8 == 20) {
        FUN_200ca44(14, 0x100);
      }

      //LAB_200c464
    }

    FUN_200ca44(14, 0);
    FUN_200c8fc(r10, 1);
    CPU.sp().value += 0x38;
  }

  @Method(0x200c49c)
  public static void FUN_200c49c() {
    int r0;
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
    r1 = 0xca;
    r1 = r1 << 1;
    r0 = 0x21;
    CPU.sp().value -= 0x44;
    r0 = mallocSlotBoard(r0, r1);
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
    r0 = 0x0;
    r2 = 0xc8;
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
    r2 = r2 << 1;
    r3 = r1 + r2;
    r3 = MEMORY.ref(2, r3).getUnsigned();
    if(r3 != 0x0) {
      //LAB_200c4ce
      r1 = r1 + 0x8;
      r3 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
      r4 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
      r0 = 0x200d0e4;
      CPU.r10().value = r1;
      r1 = 0x200d102;
      r3 = r3 + 0x24;
      r4 = r4 + 0x25;
      r0 = r0 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
      MEMORY.ref(4, CPU.sp().value).setu(r1);

      //LAB_200c4ea
      do {
        r3 = CPU.r10().value;
        r3 = MEMORY.ref(4, r3 + 0x8).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r5 = MEMORY.ref(4, r2).get();
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        r4 = CPU.r10().value;
        r4 = MEMORY.ref(4, r4 + 0xc).get();
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r4);
        r0 = CPU.r10().value;
        r0 = MEMORY.ref(4, r0 + 0x10).get();
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
        r1 = CPU.r10().value;
        r1 = MEMORY.ref(4, r1 + 0x14).get();
        MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
        r2 = CPU.r10().value;
        r2 = MEMORY.ref(4, r2 + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
        r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r4 = MEMORY.ref(4, r4 + 0x4).get();
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r4);
        r0 = MEMORY.ref(4, r0 + 0x8).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        r2 = MEMORY.ref(4, r2 + 0xc).get();
        CPU.r11().value = r3;
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r3 = MEMORY.ref(1, r3).getUnsigned();
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
        r3 = r3 + 0xff;
        r3 = r3 << 24;
        r3 = r3 >>> 24;
        r1 = CPU.r11().value;
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
        if(r3 == 0x0) {
          //LAB_200c53a
          r4 = 0x3;
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r4);
          if(r1 == 0x0) {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
            r0 = r0 + r2;
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
            r3 = 0x200d140;
            r2 = r4 << 2;
            r3 = MEMORY.ref(4, r3 + r2).get();
            if(r0 >= r3) {
              r3 = 0x200d168;
              r3 = MEMORY.ref(4, r3 + r2).get();
              r3 = -r3;
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
            } else {
              //LAB_200c560
              r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
              r3 = 0x1999;
              if(r0 <= r3) {
                r3 = 0x200d168;
                r4 = 0x1999;
                r3 = MEMORY.ref(4, r3 + r2).get();
                MEMORY.ref(4, CPU.sp().value + 0x28).setu(r4);
                MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
                r2 = MEMORY.ref(4, r5 + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
                r3 = MEMORY.ref(4, r5 + 0xc).get();
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
                r4 = MEMORY.ref(4, r5 + 0x10).get();
                r0 = 0x18;
                MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
                MEMORY.ref(4, r5 + 0x8).setu(r1);
                MEMORY.ref(4, r5 + 0xc).setu(r1);
                MEMORY.ref(4, r5 + 0x10).setu(r1);
                CPU.r11().value = r0;
              }
            }

            //LAB_200c588
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            MEMORY.ref(4, r5 + 0x18).setu(r0);
            MEMORY.ref(4, r5 + 0x1c).setu(r0);
          }

          //LAB_200c58e
          r0 = rand();
          r2 = 0x200d0e4;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = MEMORY.ref(1, r1 + r2).getUnsigned();
          r3 = r3 * r0;
          r6 = r3 >>> 16;
          r0 = rand();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r3 = r3 * r0;
          r7 = r3 >>> 16;
          r0 = rand();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = MEMORY.ref(1, r1 + 0x1).getUnsigned();
          r3 = r3 * r0;
          r3 = r3 >>> 16;
          CPU.r8().value = r3;
          if(r6 != 0x0) {
            r1 = 0xfa;
            r0 = r6 << 16;
            r1 = r1 << 2;
            r0 = divideU(r0, r1);
            r6 = r0;
          } else {
            //LAB_200c5c8
            r6 = 0x0;
          }

          //LAB_200c5ca
          if(r7 != 0x0) {
            r1 = 0xfa;
            r0 = r7 << 16;
            r1 = r1 << 2;
            r0 = divideU(r0, r1);
            CPU.r9().value = r0;
          } else {
            //LAB_200c5dc
            r2 = 0x0;
            CPU.r9().value = r2;
          }

          //LAB_200c5e0
          r3 = CPU.r8().value;
          if(r3 != 0x0) {
            r1 = 0xfa;
            r0 = r3 << 16;
            r1 = r1 << 2;
            r0 = divideU(r0, r1);
          } else {
            //LAB_200c5f2
            r0 = 0x0;
          }

          //LAB_200c5f4
          r2 = 0x200d120;
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = MEMORY.ref(1, r2 + r4).get();
          if(r3 == 0x1) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
            r1 = r1 + r6;
            MEMORY.ref(4, CPU.sp().value + 0x34).setu(r1);
          } else {
            //LAB_200c606
            r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
            r1 = 0x1;
            r4 = r4 - r6;
            r1 = -r1;
            MEMORY.ref(4, CPU.sp().value + 0x34).setu(r4);
            if(r3 != r1) {
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
            }
          }

          //LAB_200c618
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = r3 + 0x1;
          r3 = MEMORY.ref(1, r2 + r3).get();
          if(r3 == 0x1) {
            r4 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r4 = r4 + CPU.r9().value;
            MEMORY.ref(4, CPU.sp().value + 0x30).setu(r4);
          } else {
            //LAB_200c62a
            r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r4 = CPU.r9().value;
            r1 = r1 - r4;
            MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
            r1 = 0x1;
            r1 = -r1;
            if(r3 != r1) {
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
            }
          }

          //LAB_200c63e
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = r3 + 0x2;
          r3 = MEMORY.ref(1, r2 + r3).get();
          if(r3 == 0x1) {
            r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r4 = r4 + r0;
            MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r4);
          } else {
            //LAB_200c650
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r2 = 0x1;
            r1 = r1 - r0;
            r2 = -r2;
            MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1);
            if(r3 != r2) {
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
            }
          }

          //LAB_200c662
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r0 = r3;
          r0 = r0 * r1;
          r0 = sin(r0);
          r2 = MEMORY.ref(4, CPU.sp().value).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = MEMORY.ref(1, r2 + 0x1).getUnsigned();
          r6 = r0 << 1;
          r0 = r3;
          r0 = r0 * r4;
          r0 = sin(r0);
          r7 = r0 << 1;
          r0 = MEMORY.ref(4, CPU.sp().value).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
          r0 = r3;
          r0 = r0 * r1;
          r0 = cos(r0);
          r2 = CPU.r11().value;
          r0 = r0 << 1;
          if(r2 != 0x0) {
            r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r3 = r3 + r6;
            MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
            r3 = CPU.r11().value;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            r3 = r3 + 0xff;
            r3 = r3 << 24;
            r4 = r4 + r7;
            r1 = r1 + r0;
            r3 = r3 >>> 24;
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
            CPU.r11().value = r3;
            if(r3 == 0x0) {
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r3 = CPU.r9().value;
              MEMORY.ref(4, r5 + 0x8).setu(r2);
              MEMORY.ref(4, r5 + 0x38).setu(r2);
              if(r3 != 0x0) {
                MEMORY.ref(4, r5 + 0xc).setu(r4);
                MEMORY.ref(4, r5 + 0x3c).setu(r4);
              }

              //LAB_200c6c8
              r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              MEMORY.ref(4, r5 + 0x10).setu(r4);
              MEMORY.ref(4, r5 + 0x40).setu(r4);
            }
          } else {
            //LAB_200c6d0
            r3 = MEMORY.ref(4, r5 + 0x8).get();
            r1 = CPU.r9().value;
            r3 = r3 + r6;
            MEMORY.ref(4, r5 + 0x8).setu(r3);
            MEMORY.ref(4, r5 + 0x38).setu(r3);
            if(r1 != 0x0) {
              r3 = MEMORY.ref(4, r5 + 0xc).get();
              r3 = r3 + r7;
              MEMORY.ref(4, r5 + 0xc).setu(r3);
              MEMORY.ref(4, r5 + 0x3c).setu(r3);
            }

            //LAB_200c6e6
            r3 = MEMORY.ref(4, r5 + 0x10).get();
            r3 = r3 + r0;
            MEMORY.ref(4, r5 + 0x10).setu(r3);
            MEMORY.ref(4, r5 + 0x40).setu(r3);
          }
        }

        //LAB_200c6ee
        r2 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
        r3 = CPU.r10().value;
        MEMORY.ref(4, r3 + 0x8).setu(r2);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        MEMORY.ref(4, r3 + 0xc).setu(r4);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        MEMORY.ref(4, r3 + 0x10).setu(r0);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        MEMORY.ref(4, r3 + 0x14).setu(r1);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        MEMORY.ref(4, r3 + 0x18).setu(r2);
        r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r3 = CPU.r11().value;
        MEMORY.ref(1, r4).setu(r3);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        MEMORY.ref(4, r1 + 0x4).setu(r0);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r3 = CPU.r10().value;
        MEMORY.ref(4, r3).setu(r2);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = CPU.sp().value + 0x20;
        MEMORY.ref(4, r1 + 0xc).setu(r4);
        r0 = MEMORY.ref(1, r0).getUnsigned();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.ref(1, r1).setu(r0);
        r1 = MEMORY.ref(4, CPU.sp().value).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r1 = r1 + 0x3;
        r2 = r2 + 0x3;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r3 = r3 + 0x3;
        r4 = r4 + 0x1;
        r1 = r1 + 0x28;
        r2 = r2 + 0x28;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r0 = 0x28;
        r3 = r3 + 0x28;
        CPU.r10().value = CPU.r10().value + r0;
        r4 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r0 = 0xc8;
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
        r0 = r0 << 1;
        r3 = r4 + r0;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      } while(r1 != r3);
    }

    //LAB_200c762
    CPU.sp().value += 0x44;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x200c78c)
  public static void FUN_200c78c(int r0, int r1) {
    final int r6 = r0;
    CPU.sp().value -= 0x4;
    final int r9 = mallocSlotBoard(33, 0x194);
    int r5 = r9;
    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r9);
    DMA.channels[3].CNT.setu(0x85000065);

    if(r1 > 10) {
      r1 = 10;
    }

    //LAB_200c7c8
    //LAB_200c7d6
    for(int r10 = 0; r10 < r1; r10++) {
      final Actor70 actor = getMapActor(r6 + r10);
      final Sprite38 r3 = actor.sprite_50.deref();
      MEMORY.ref(4, r5).setu(actor.getAddress());
      r3._26.set(0);
      actor._55.set(0);
      FUN_200c904(actor, 1);
      MEMORY.ref(4, r5 + 0x1c).setu(MEMORY.ref(4, 0x200d140 + r10 * 0x4).get());
      MEMORY.ref(4, r5 + 0x20).setu(-MEMORY.ref(4, 0x200d168 + r10 * 0x4).get());
      MEMORY.ref(1, r5 + 0x24).setu(3);
      r5 = r5 + 0x28;
    }

    //LAB_200c81a
    MEMORY.ref(2, r9 + 0x190).setu(r1);
    setTickCallback(getRunnable(Map17Overlay_878ef88.class, "FUN_200c49c"), 0xc80);
    CPU.sp().value += 0x4;
  }

  /** {@link CopiedSegment8000770#FUN_3000380} */
  @Method(0x200c854)
  public static int FUN_200c854(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200c864)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200c86c)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200c874)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#atan2_} */
  @Method(0x200c87c)
  public static int atan2(final int b, final int a) {
    return (int)MEMORY.call(0x8000100, b, a);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200c884)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#cos_} */
  @Method(0x200c88c)
  public static int cos(final int angle) {
    return (int)MEMORY.call(0x8000120, angle);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200c894)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#mallocSlotBoard_} */
  @Method(0x200c89c)
  public static int mallocSlotBoard(final int slot, final int size) {
    return (int)MEMORY.call(0x8000148, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200c8a4)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200c8ac)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200c8b4)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200c8bc)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    MEMORY.call(0x8009098, actor, script);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200c8c4)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x200c8cc)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200c8d4)
  public static void FUN_200c8d4() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#moveActorTo_} */
  @Method(0x200c8dc)
  public static void moveActorTo(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200c8e4)
  public static void FUN_200c8e4(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200c8ec)
  public static void FUN_200c8ec(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200c8f4)
  public static void FUN_200c8f4(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200c8fc)
  public static void FUN_200c8fc(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091e8} */
  @Method(0x200c904)
  public static void FUN_200c904(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e8, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200c90c)
  public static void FUN_200c90c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f8} */
  @Method(0x200c914)
  public static void FUN_200c914() {
    MEMORY.call(0x80091f8);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200c91c)
  public static void FUN_200c91c(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015120} */
  @Method(0x200c924)
  public static void FUN_200c924(final int r0, final int r1) {
    MEMORY.call(0x8015120, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015210} */
  @Method(0x200c92c)
  public static void FUN_200c92c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200c934)
  public static void FUN_200c934(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_807#getUnit_} */
  @Method(0x200c93c)
  public static Unit14c getUnit(final int slot) {
    return (Unit14c)MEMORY.call(0x8077008, slot);
  }

  /** {@link GoldenSun_807#addItem_} */
  @Method(0x200c944)
  public static int addItem(final int charId, final int itemId) {
    return (int)MEMORY.call(0x8077028, charId, itemId);
  }

  /** {@link GoldenSun_807#giveItem_} */
  @Method(0x200c94c)
  public static int giveItem(final int itemId) {
    return (int)MEMORY.call(0x8077030, itemId);
  }

  /** {@link GoldenSun_807#getUnitItemSlotForItemId_} */
  @Method(0x200c954)
  public static int getUnitItemSlotForItemId(final int unitId, final int itemId) {
    return (int)MEMORY.call(0x8077038, unitId, itemId);
  }

  /** {@link GoldenSun_807#getCharUnitIdWhoHasItemId_} */
  @Method(0x200c95c)
  public static int getCharUnitIdWhoHasItemId(final int itemId) {
    return (int)MEMORY.call(0x8077040, itemId);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200c964)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200c96c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200c974)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_807#getUnitItemCount_} */
  @Method(0x200c97c)
  public static int getUnitItemCount(final int unitId) {
    return (int)MEMORY.call(0x8077248, unitId);
  }

  /** {@link GoldenSun_807#FUN_80772b0} */
  @Method(0x200c984)
  public static int FUN_200c984(final int unitId, final int itemSlot) {
    return (int)MEMORY.call(0x80772b0, unitId, itemSlot);
  }

  /** {@link GoldenSun_807#FUN_80772e8} */
  @Method(0x200c98c)
  public static void FUN_200c98c(final int itemId) {
    MEMORY.call(0x80772e8, itemId);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200c994)
  public static void FUN_200c994(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200c99c)
  public static void FUN_200c99c() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200c9a4)
  public static void FUN_200c9a4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#removeCharAndHealRemainingChars_} */
  @Method(0x200c9ac)
  public static void removeCharAndHealRemainingChars(final int charId) {
    MEMORY.call(0x808a058, charId);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200c9b4)
  public static int FUN_200c9b4(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200c9bc)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200c9c4)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200c9cc)
  public static void FUN_200c9cc(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x808a098, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x200c9d4)
  public static void FUN_200c9d4(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200c9dc)
  public static void FUN_200c9dc(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200c9e4)
  public static void FUN_200c9e4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200c9ec)
  public static void FUN_200c9ec(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200c9f4)
  public static void FUN_200c9f4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200c9fc)
  public static void FUN_200c9fc(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200ca04)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200ca0c)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200ca14)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200ca1c)
  public static void FUN_200ca1c(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200ca24)
  public static void FUN_200ca24(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200ca2c)
  public static void FUN_200ca2c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200ca34)
  public static void FUN_200ca34(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200ca3c)
  public static void FUN_200ca3c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200ca44)
  public static void FUN_200ca44(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a158, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a160} */
  @Method(0x200ca4c)
  public static void FUN_200ca4c(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a160, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200ca54)
  public static void FUN_200ca54(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200ca5c)
  public static Panel24 FUN_200ca5c(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200ca64)
  public static void FUN_200ca64(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200ca6c)
  public static void FUN_200ca6c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x200ca74)
  public static int FUN_200ca74(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a190, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200ca7c)
  public static void FUN_200ca7c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200ca84)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200ca8c)
  public static void FUN_200ca8c(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200ca94)
  public static void FUN_200ca94(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x200ca9c)
  public static void FUN_200ca9c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200caa4)
  public static void FUN_200caa4(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200caac)
  public static void FUN_200caac(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200cab4)
  public static void FUN_200cab4() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200cabc)
  public static void FUN_200cabc(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2a0} */
  @Method(0x200cac4)
  public static int FUN_200cac4() {
    return (int)MEMORY.call(0x808a2a0);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200cacc)
  public static void FUN_200cacc(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a338} */
  @Method(0x200cad4)
  public static void FUN_200cad4(final int r0, final int r1) {
    MEMORY.call(0x808a338, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200cadc)
  public static void FUN_200cadc(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200cae4)
  public static void FUN_200cae4() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200caec)
  public static void FUN_200caec() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200caf4)
  public static void FUN_200caf4() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a390} */
  @Method(0x200cafc)
  public static void FUN_200cafc(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a390, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a398} */
  @Method(0x200cb04)
  public static void FUN_200cb04(final int itemId, final int flags) {
    MEMORY.call(0x808a398, itemId, flags);
  }

  /** {@link GoldenSun_80b#FUN_80b0058} */
  @Method(0x200cb0c)
  public static int FUN_200cb0c(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b0058, r0, r1);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200cb14)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
