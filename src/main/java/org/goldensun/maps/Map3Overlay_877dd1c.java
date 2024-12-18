package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
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
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;

import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/** Vale */
public final class Map3Overlay_877dd1c {
  private Map3Overlay_877dd1c() { }

  @Method(0x2008064)
  public static int FUN_2008064(final Actor70 r0) {
    final int r3 = r0._64.get();
    if(r3 == 0) {
      //LAB_20080b6
      r0.scale_18.set(0x10000);
      r0._1c.set(0x10000);
      r0._64.set(FUN_200c634(rand(), 90) + 60);
    } else if(r3 == 2) {
      //LAB_20080a2
      r0.scale_18.add(0x1000);
      r0._1c.sub(0x800);
      //LAB_200807c
    } else if(r3 == 4) {
      //LAB_2008094
      r0.scale_18.add(0x2000);
      r0._1c.sub(0x1000);
    } else if(r3 == 6) {
      r0.scale_18.sub(0x4000);
      r0._1c.add(0x2000);
    }

    //LAB_20080cc
    r0._64.decr();
    return 1;
  }

  /** {@link GoldenSunVars#getRooms_200800c} */
  @Method(0x20080e8)
  public static int getRooms() {
    return 0x200d0e4;
  }

  /** {@link GoldenSunVars#getLadders_200802c} */
  @Method(0x20080f0)
  public static int getLadders() {
    return 0;
  }

  /** {@link GoldenSunVars#getTransitions_2008014} */
  @Method(0x20080f4)
  public static int getTransitions() {
    return 0x200d27c;
  }

  /** {@link GoldenSunVars#getActors_200801c} */
  @Method(0x20080fc)
  public static int getActors() {
    return 0x200d2b8;
  }

  /** {@link GoldenSunVars#getEvents_2008024} */
  @Method(0x2008104)
  public static int getEvents() {
    return 0x200d558;
  }

  /**
   * Event list 0x200d558 handler 27
   */
  @Method(value = 0x200810c, ignoreExtraParams = true)
  public static void FUN_200810c() {
    setFlag(0x210);
    FUN_80091c0(40, 84, 7, 4, 10, 84);
  }

  /**
   * Event list 0x200d558 handler 28
   */
  @Method(value = 0x2008134, ignoreExtraParams = true)
  public static void FUN_2008134() {
    clearFlag(0x210);
    FUN_80091c0(40, 89, 7, 4, 10, 84);
  }

  @Method(0x200815c)
  public static void FUN_200815c(final int r0) {
    if(readFlag(0x834) != 0) {
      FUN_808a2d0();
    }

    //LAB_200816e
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x100);
    r1._1c8.set(0x10);
    FUN_808a248(r0);
  }

  /**
   * Event list 0x200d558 handler 0
   */
  @Method(value = 0x20081d0, ignoreExtraParams = true)
  public static void FUN_20081d0() {
    playSound(0x7b);
    FUN_200815c(1);
  }

  /**
   * Event list 0x200d558 handler 1
   */
  @Method(value = 0x20081e4, ignoreExtraParams = true)
  public static void FUN_20081e4() {
    playSound(0x7b);
    FUN_200815c(0x3);
  }

  /**
   * Event list 0x200d558 handler 2
   */
  @Method(value = 0x20081f8, ignoreExtraParams = true)
  public static void FUN_20081f8() {
    playSound(0x7b);
    FUN_200815c(0x4);
  }

  /**
   * Event list 0x200d558 handler 3
   */
  @Method(value = 0x200820c, ignoreExtraParams = true)
  public static void FUN_200820c() {
    playSound(0x7b);

    if(readFlag(0x841) != 0 && readFlag(0x842) == 0) {
      FUN_200bfb0();
    }

    //LAB_200822c
    FUN_200815c(0x2);
  }

  /**
   * Event list 0x200d558 handler 4
   */
  @Method(value = 0x2008240, ignoreExtraParams = true)
  public static void FUN_2008240() {
    playSound(0x9e);
    FUN_8009178(0x200d78a, 0x36, 0x20);
    FUN_808a0c8(0, 0x196, 0x2d7);
    FUN_808a010(0x3);
    FUN_200815c(0x5);
  }

  /**
   * Event list 0x200d558 handler 5
   */
  @Method(value = 0x2008278, ignoreExtraParams = true)
  public static void FUN_2008278() {
    if(readFlag(0x206) == 0) {
      playSound(0x9e);
      FUN_8009178(0x200d7a0, 0x2d, 0x27);
    }

    //LAB_2008294
    if(readFlag(0x835) == 0 && readFlag(0x831) == 0) {
      FUN_200950c();
      setFlag(0x206);
    } else {
      //LAB_20082b4
      FUN_808a0c8(0, 0x106, 0x325);
      FUN_808a010(0x3);
      FUN_200815c(0x6);
    }
  }

  /**
   * Event list 0x200d558 handler 6
   */
  @Method(value = 0x20082e4, ignoreExtraParams = true)
  public static void FUN_20082e4() {
    if(readFlag(0x205) == 0) {
      playSound(0x9e);
      FUN_8009178(0x200d78a, 0x32, 0x2c);
    }

    //LAB_2008300
    FUN_808a0c8(0, 0x154, 0x378);
    FUN_808a010(0x3);
    FUN_200815c(0x7);
  }

  /**
   * Event list 0x200d558 handler 7
   */
  @Method(value = 0x2008328, ignoreExtraParams = true)
  public static void FUN_2008328() {
    playSound(0x9e);
    FUN_8009178(0x200d7a0, 0x31, 0x45);
    FUN_808a0c8(0, 0x146, 0x466);
    FUN_808a010(0x3);
    FUN_200815c(0x8);
  }

  /**
   * Event list 0x200d558 handler 8
   */
  @Method(value = 0x2008360, ignoreExtraParams = true)
  public static void FUN_2008360() {
    playSound(0x9e);
    FUN_8009178(0x200d7b6, 52, 76);
    FUN_808a0c8(0, 0x176, 0x4d6);
    FUN_808a010(3);
    FUN_200815c(9);
  }

  /**
   * Event list 0x200d558 handler 9
   */
  @Method(value = 0x2008398, ignoreExtraParams = true)
  public static void FUN_2008398() {
    playSound(0x9e);
    FUN_8009178(0x200d78a, 35, 74);
    FUN_808a0c8(0, 102, 1206);
    FUN_808a010(3);
    FUN_200815c(10);
  }

  /**
   * Event list 0x200d558 handler 10
   */
  @Method(value = 0x20083cc, ignoreExtraParams = true)
  public static void FUN_20083cc() {
    playSound(0x9e);
    FUN_8009178(0x200d78a, 35, 73);
    FUN_808a0c8(0, 102, 1206);
    FUN_808a010(3);
    FUN_200815c(12);
  }

  /**
   * Event list 0x200d558 handler 11
   */
  @Method(value = 0x2008400, ignoreExtraParams = true)
  public static void FUN_2008400() {
    playSound(0x9e);
    FUN_8009178(0x200d7a0, 38, 72);
    FUN_808a0c8(0, 146, 1182);
    FUN_808a010(3);
    FUN_200815c(13);
  }

  @Method(0x2008434)
  public static int init() {
    FUN_808a5e0(0xaa);
    FUN_808a0f0(23, 0, 0);

    if(readFlag(0x109) != 0) {
      clearFlag(0x205);
      clearFlag(0x206);
    }

    //LAB_2008462
    if(readFlag(0x830) != 0) {
      FUN_808a0f0(11, 0x14e0000, 0x3a40000);
      FUN_2008ec4();
    }

    //LAB_2008480
    if(readFlag(0x831) != 0) {
      FUN_808a0f0(12, 0xe00000, 0x3680000);
      FUN_20090a4();
    }

    //LAB_200849c
    if(readFlag(0x832) != 0) {
      FUN_808a0f0(13, 0x400000, 0x2bf0000);
      FUN_20092f0();
    }

    //LAB_20084b6
    if(readFlag(0x833) != 0) {
      FUN_808a0f0(14, 0x1b00000, 0x47b0000);
      FUN_2009498();
    }

    //LAB_20084d0
    getMapActor(11)._59.or(0x4);
    getMapActor(12)._59.or(0x4);
    getMapActor(13)._59.or(0x4);
    getMapActor(14)._59.or(0x4);
    getMapActor(15)._59.or(0x4);
    getMapActor(16)._59.or(0x4);
    getMapActor(17)._59.or(0x4);
    getMapActor(18)._59.or(0x4);

    if(readFlag(0x837) != 0) {
      FUN_808a0f0(22, 0, 0);
    }

    //LAB_2008556
    final Actor70 actor19 = getMapActor(19);
    actor19.scale_18.set(0x20000);
    actor19._1c.set(0x20000);

    if(readFlag(0x838) != 0) {
      FUN_808a0f0(19, 0x720000, 0x14d0000);
    } else {
      //LAB_200857c
      FUN_808a098(19, 0x200c9f4);
    }

    //LAB_2008584
    if(readFlag(0x841) != 0) {
      //LAB_2008590
      FUN_200c0f0();
      FUN_808a0f0(9, 0xa50000, 0x4cd0000);
      final Actor70 actor9 = getMapActor(9);
      actor9.angle_06.set(0xe000);
      actor9._64.set(FUN_200c634(rand(), 90) + 60);
      actor9._66.set(1);
      FUN_808a098(9, 0x200cec8);
      FUN_808a0f0(26, 0xa50000, 0x4e60000);
      final Actor70 actor26 = getMapActor(26);
      actor26.angle_06.set(0xe000);
      actor26._64.set(FUN_200c634(rand(), 90) + 60);
      actor26._66.set(2);
      FUN_808a098(26, 0x200cec8);
      FUN_808a0f0(22, 0x980000, 0x5050000);
      final Actor70 actor22 = getMapActor(22);
      actor22.angle_06.set(0xe000);
      actor22._64.set(FUN_200c634(rand(), 90) + 60);
      actor22._66.set(3);
      FUN_808a098(22, 0x200cec8);
      FUN_808a0f0(8, 0xb80000, 0x5180000);
      final Actor70 actor8 = getMapActor(8);
      actor8.angle_06.set(0xe000);
      actor8._64.set(FUN_200c634(rand(), 90) + 60);
      actor8._66.set(4);
      FUN_808a098(8, 0x200cec8);
      setActorAnimationIfLoaded(8, 6);
      getMapActor(22).flags_23.and(~0x1);
      getMapActor(8).flags_23.and(~0x1);
      setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c5b8"), 0xc80);
      FUN_808a0f0(24, 0, 0);
      FUN_808a0f0(25, 0, 0);
      FUN_808a0f0(23, 0, 0);
      FUN_808a0f0(19, 0, 0);

      if(readFlag(0x842) != 0) {
        //LAB_20086dc
        FUN_808a0f0(22, 0, 0);
      }
      //LAB_20086e0
    } else if(readFlag(0x83a) == 0) {
      //LAB_20086ec
      FUN_808a0f0(10, 0xc00000, 0x4be0000);
      FUN_808a1b8(10, 0x2000, 0);
      setActorAnimationIfLoaded(10, 5);
      getMapActor(10)._64.set(FUN_200c634(rand(), 90) + 60);
      FUN_808a098(10, 0x200cec8);
      FUN_808a0f0(24, 0xe30000, 0x4be0000);
      FUN_808a1b8(24, 0x4000, 0);
      setActorAnimationIfLoaded(24, 6);
      getMapActor(24)._64.set(FUN_200c634(rand(), 90) + 60);
      FUN_808a098(24, 0x200cec8);
      FUN_808a0f0(25, 0xf70000, 0x4be0000);
      FUN_808a1b8(25, 0x4000, 0);
      setActorAnimationIfLoaded(25, 6);
      getMapActor(25)._64.set(FUN_200c634(rand(), 90) + 0x3c);
      FUN_808a098(25, 0x200cec8);
      FUN_808a0f0(23, 0xf30000, 0x4fd0000);
      FUN_808a1b8(23, 0xc000, 0);
      FUN_80091e0(getMapActor(23), 0);
      FUN_808a0f0(17, 0, 0);
      FUN_808a0f0(18, 0, 0);
    } else {
      //LAB_2008840
      FUN_808a0f0(17, 0, 0);
      FUN_808a0f0(18, 0, 0);
    }

    //LAB_2008854
    if(entranceId_2000402.get() != 15 || readFlag(0x87b) != 0) {
      //LAB_200886e
      FUN_808a2c0();
      FUN_808a2c8();
    }

    //LAB_2008876
    if(readFlag(0x210) != 0) {
      FUN_200810c();
    }

    //LAB_2008886
    setFlag(0x834);
    FUN_80091c0(29, 24, 1, 2, 26, 46);
    FUN_80091c0(29, 25, 1, 1, 27, 46);
    FUN_80091c0(29, 25, 1, 1, 28, 46);
    FUN_80091c0(19, 90, 1, 1, 20, 88);
    FUN_80091c0(19, 90, 1, 1, 20, 89);
    final Actor70 actor21 = getMapActor(21);
    actor21.pos_08.setY(0xc00000);
    actor21._55.set(0);
    actor21._59.set(8);
    FUN_80091e0(actor21, 0);
    sleep(1);

    if(readFlag(0x87b) != 0 || entranceId_2000402.get() != 15) {
      //LAB_2008930
      setActorAnimationIfLoaded(23, 7);

      if(readFlag(0x837) == 0) {
        FUN_808a018();
        FUN_808a1f0(22, 0x101);
        FUN_808a0f0(22, 0x1900000, 0x2630000);
        FUN_808a0f0(21, 0x1a80000, 0x2730000);
        FUN_808a0c8(22, 0x190, 0x26b);
        FUN_808a0d0(21, 0x1a8, 0x26b);
        setActorAnimationIfLoaded(21, 2);
        setActorAnimationIfLoaded(22, 5);
        FUN_808a020();
      } else {
        //LAB_2008994
        FUN_808a018();
        FUN_808a0f0(21, 0x1a80000, 0x2730000);
        FUN_808a0d0(21, 0x1a8, 0x26b);
        setActorAnimationIfLoaded(21, 3);
        FUN_808a020();
      }

      //LAB_20089bc
      final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
      r1._1c0.set(0x100);
      r1._1c8.set(0x18);
      FUN_808a360();
      FUN_808a370();
      FUN_808a2e0();
    } else {
      FUN_2008a10();
    }

    //LAB_20089de
    return 0;
  }

  @Method(0x2008a10)
  public static void FUN_2008a10() {
    FUN_808a018();
    FUN_808a2c0();
    FUN_808a2c8();
    FUN_808a2d8();
    sleep(60);
    FUN_808a208(0x4000, 0x800);
    FUN_808a210(0x13c0000, 0xa00000, 0x3700000, 1);
    FUN_808a0f0(10, 0x1260000, 0x3640000);
    FUN_808a0f0(0, 0, 0);
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x100);
    r1._1c8.set(0x10);
    FUN_808a360();
    FUN_808a370();
    FUN_808a2e0();
    playSound(0x9e);
    FUN_8009178(0x200d78a, 50, 44);
    FUN_808a1f0(22, 0x101);
    setActorVelocityScalerAndAcceleration(9, 0xcccc, 0x6666);
    setActorVelocityScalerAndAcceleration(0, 0xcccc, 0x6666);
    setActorVelocityScalerAndAcceleration(10, 0xcccc, 0x6666);
    FUN_808a0f0(0x9, 0x1560000, 0x37a0000);
    FUN_808a0d0(9, 342, 905);
    FUN_808a5e8();
    FUN_808a0c8(9, 296, 905);
    FUN_808a0f0(0, 0x1560000, 0x37a0000);
    FUN_808a0c8(0, 342, 890);
    FUN_808a0d0(0, 342, 905);
    FUN_808a0d0(0, 318, 905);
    setActorAnimationIfLoaded(9, 1);
    FUN_808a138(9, 1);
    FUN_808a1b8(9, 0xc000, 60);
    FUN_808a170(0xe5c);
    FUN_808a180(9, 0);
    FUN_808a0d0(10, 294, 838);
    FUN_808a010(40);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_808a180(10, 0);
    FUN_808a150(0, 9, 0);
    FUN_808a010(40);
    FUN_808a1b8(10, 0x4000, 0);
    FUN_808a188(10, 0, 20);
    FUN_808a1e8(9, 0x101, 20);
    FUN_808a1b8(9, 0xc000, 10);
    FUN_808a188(9, 0, 10);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_808a180(10, 0);
    FUN_808a1f0(9, 0x102);
    FUN_808a010(30);
    FUN_808a1b8(9, 0, 50);
    FUN_808a1b8(9, 0xc000, 10);
    setActorVelocityScalerAndAcceleration(9, 0x18000, 0xc000);
    FUN_808a0d0(9, 289, 883);
    FUN_808a1b8(9, 0xe000, 0);
    FUN_808a180(9, 0);
    FUN_808a138(10, 2);
    FUN_808a180(10, 0);
    setActorAnimationAndWaitUntilFinished(9, 4);
    FUN_808a188(9, 0, 10);
    FUN_808a1b8(9, 0x2000, 10);
    FUN_808a170(0xe64);
    FUN_808a178(9);
    FUN_808a0d0(0, 302, 905);
    FUN_808a1b8(0, 0xc000, 0);

    //LAB_2008c72
    while(FUN_808a070(0, 0) == 1) {
      //LAB_2008c5c
      FUN_808a138(9, 1);
      FUN_808a170(0xe65);
      FUN_808a178(9);
    }

    setActorAnimationAndWaitUntilFinished(9, 3);
    FUN_808a170(0xe66);
    FUN_808a188(9, 0, 10);
    setActorAnimationAndWaitUntilFinished(0, 3);
    setActorVelocityScalerAndAcceleration(10, 0x18000, 0xc000);
    FUN_808a0c8(10, 297, 750);
    FUN_808a010(10);
    FUN_808a0d0(9, 297, 750);
    FUN_808a0f0(9, 0, 0);
    FUN_808a0f0(10, 0, 0);
    setActorAnimationIfLoaded(10, 1);
    setActorAnimationIfLoaded(21, 2);
    setActorAnimationIfLoaded(22, 5);
    clearFlag(0x12f);
    setFlag(0x87b);
    setFlag(0x205);
    FUN_808a020();
  }

  /**
   * Event list 0x200d558 handler 29
   */
  @Method(value = 0x2008d5c, ignoreExtraParams = true)
  public static void FUN_2008d5c() {
    if(readFlag(0x310) == 0) {
      //LAB_2008d6c
      FUN_808a018();

      if(readFlag(0x830) == 0) {
        final Actor70 r5 = getMapActor(11);
        final Sprite38 r6 = r5.sprite_50.deref();
        FUN_80091f0(0x40000, 0x40000, 0x10000);
        playSound(0x8d);
        sleep(40);
        playSound(0x91);
        r5.flags_23.and(~0x1);
        r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
        FUN_808a0f0(11, 0x1d90000, 0x3a40000);
        r5.velocityScalar_30.set(0x18000);
        r5.acceleration_34.set(0x18000);
        r5.pos_08.y_04.add(0xf00000);
        r5.dest_38.setY(r5.pos_08.getY());
        r5._44.set(0x6666);
        FUN_808a0d0(11, 344, 932);
        r6.packet_00.attribs_04.attrib2_04.or(0xc00);
        r5.flags_23.or(0x1);
        FUN_808a010(40);
        playSound(0x121);
        FUN_80091f0(-1, -1, 0xe666);
        FUN_80091f8();
        FUN_808a5e8();
        setFlag(0x830);
      }

      //LAB_2008e2e
      FUN_2008ec4();
      setFlag(0x310);

      if(readFlag(0x837) != 0 && readFlag(0x841) == 0 && readFlag(0x30c) == 0) {
        if(getMapActor(0).pos_08.getY() > 0x800000) {
          FUN_2009a64(326, 918);
          FUN_808a0d0(0, 291, 918);
        } else {
          //LAB_2008e82
          FUN_2009a64(335, 957);
        }

        //LAB_2008e8a
        setFlag(0x30c);
      }

      //LAB_2008e92
      FUN_808a020();
    }
  }

  @Method(0x2008ec4)
  public static void FUN_2008ec4() {
    FUN_80091c0(29, 64, 1, 1, 57, 21);
    FUN_80091c0(29, 64, 1, 1, 21, 58);
    FUN_80091c0(29, 64, 1, 1, 22, 58);
    FUN_80091c0(29, 64, 1, 1, 20, 58);
    FUN_80091c0(28, 20, 1, 1, 20, 57);
  }

  /**
   * Event list 0x200d558 handler 30
   */
  @Method(value = 0x2008f38, ignoreExtraParams = true)
  public static void FUN_2008f38() {
    if(readFlag(0x311) == 0) {
      //LAB_2008f46
      FUN_808a018();

      if(readFlag(0x831) == 0) {
        final Actor70 r5 = getMapActor(12);
        FUN_80091f0(0x40000, 0x40000, 0x10000);
        playSound(0x8d);
        sleep(40);
        playSound(0x91);
        FUN_808a0f0(12, 0x17d0000, 0x3280000);
        r5.velocityScalar_30.set(0x18000);
        r5.acceleration_34.set(0x18000);
        r5.pos_08.y_04.add(0x1000000);
        r5.dest_38.setY(r5.pos_08.getY());
        r5._44.set(0x8000);
        FUN_808a0d0(12, 290, 833);
        setActorPriority(12, 1);
        FUN_808a0d0(12, 258, 852);
        setActorPriority(12, 2);
        FUN_808a0d0(12, 224, 872);
        FUN_808a010(40);
        playSound(0x121);
        FUN_80091f0(-1, -1, 0xe666);
        FUN_80091f8();
        FUN_808a5e8();
        setFlag(0x831);
      }

      //LAB_2009002
      FUN_20090a4();
      setFlag(0x311);

      if(readFlag(0x837) != 0 && readFlag(0x841) == 0) {
        if(readFlag(0x30c) == 0) {
          if(getMapActor(0).pos_08.getY() > 0x800000) {
            FUN_2009a64(219, 843);
            FUN_808a0d0(0, 179, 829);
          } else {
            //LAB_2009050
            FUN_2009a64(214, 908);
            FUN_808a0d0(0, 219, 911);
          }

          //LAB_2009064
          setFlag(0x30c);
        }
      }

      //LAB_200906c
      FUN_808a020();
    }
  }

  @Method(0x20090a4)
  public static void FUN_20090a4() {
    FUN_80091c0(29, 23, 1, 1, 15, 53);
    FUN_80091c0(29, 23, 1, 1, 14, 53);
    FUN_80091c0(29, 23, 1, 1, 13, 53);
    FUN_80091c0(26, 20, 2, 1, 14, 52);
    FUN_80091c0(25, 21, 1, 1, 13, 54);
    FUN_80091c0(25, 21, 1, 1, 15, 54);
    FUN_80091c0(14, 53, 1, 1, 14, 54);
    FUN_80091c0(13, 55, 1, 1, 15, 55);
  }

  /**
   * Event list 0x200d558 handler 31
   */
  @Method(value = 0x2009154, ignoreExtraParams = true)
  public static void FUN_2009154() {
    if(readFlag(0x312) == 0) {
      //LAB_2009168
      FUN_808a018();

      if(readFlag(0x832) == 0) {
        final Actor70 r6 = getMapActor(13);
        final Actor70 r0 = getMapActor(0);
        final int r5 = r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() >>> 8;
        final int r10 = r0.flags_23.get();
        FUN_80091f0(0x40000, 0x40000, 0x10000);
        playSound(0x8d);
        sleep(40);
        playSound(0x91);
        setActorPriority(0, 3);
        getMapActor(0).flags_23.or(0x2);
        FUN_808a0f0(13, 0, 0x2bf0000);
        r6.velocityScalar_30.set(0x18000);
        r6.acceleration_34.set(0x18000);
        r6.pos_08.y_04.add(0x500000);
        r6.dest_38.setY(r6.pos_08.getY());
        r6._44.set(0x8000);
        FUN_808a0d0(13, 64, 703);
        FUN_808a010(40);
        playSound(0x121);
        FUN_80091f0(-1, -1, 0xe666);
        FUN_80091f8();
        FUN_808a5e8();
        setFlag(0x832);
        setActorPriority(0, r5 << 28 >>> 30);
        getMapActor(0).flags_23.or(0x1);
        r0.flags_23.set(r10);
      }

      //LAB_2009246
      FUN_20092f0();
      setFlag(0x312);

      if(readFlag(0x837) != 0 && readFlag(0x841) == 0 && readFlag(0x30c) == 0) {
        if(getMapActor(0).pos_08.getZ() < 0x2b50000) {
          FUN_2009a64(62, 669);
          FUN_808a0d0(0, 27, 627);
        } else {
          //LAB_2009292
          FUN_2009a64(75, 715);
          FUN_808a0d0(0, 67, 757);
        }

        //LAB_20092a4
        setFlag(0x30c);
      }

      //LAB_20092ac
      FUN_808a020();
    }

    //LAB_20092b0
  }

  @Method(0x20092f0)
  public static void FUN_20092f0() {
    FUN_80091c0(29, 22, 1, 1, 3, 42);
    FUN_80091c0(29, 21, 1, 1, 2, 42);
    FUN_80091c0(29, 21, 1, 1, 4, 42);
    FUN_80091c0(23, 20, 3, 1, 2, 43);
  }

  /**
   * Event list 0x200d558 handler 32
   */
  @Method(value = 0x2009348, ignoreExtraParams = true)
  public static void FUN_2009348() {
    if(readFlag(0x313) == 0) {
      //LAB_2009356
      FUN_808a018();

      if(readFlag(0x833) == 0) {
        final Actor70 r5 = getMapActor(14);
        FUN_80091f0(0x40000, 0x40000, 0x10000);
        playSound(0x8d);
        sleep(40);
        playSound(0x91);
        FUN_808a0f0(14, 0x1da0000, 0x47b0000);
        r5.velocityScalar_30.set(0x10000);
        r5.acceleration_34.set(0x10000);
        r5.pos_08.y_04.add(0x480000);
        r5.dest_38.setY(r5.pos_08.getY());
        r5._44.set(0x8000);
        FUN_808a0d0(14, 432, 1147);
        FUN_808a010(40);
        playSound(0x121);
        FUN_80091f0(-1, -1, 0xe666);
        FUN_80091f8();
        FUN_808a5e8();
        setFlag(0x833);
      }

      //LAB_20093e8
      FUN_2009498();
      setFlag(0x313);

      if(readFlag(0x837) != 0 && readFlag(0x841) == 0 && readFlag(0x30c) == 0) {
        if(getMapActor(0).pos_08.getZ() < 0x47a0000) {
          FUN_2009a64(412, 1120);
          FUN_808a0d0(0, 414, 1068);
        } else {
          //LAB_200943a
          FUN_2009a64(445, 1172);
          FUN_808a0d0(0, 447, 1227);
        }

        //LAB_200944c
        setFlag(0x30c);
      }

      //LAB_2009454
      FUN_808a020();
    }
  }

  @Method(0x2009498)
  public static void FUN_2009498() {
    FUN_80091c0(29, 20, 1, 1, 26, 71);
    FUN_80091c0(29, 20, 1, 1, 26, 70);
    FUN_80091c0(29, 20, 1, 1, 27, 70);
    FUN_80091c0(28, 21, 1, 1, 28, 71);
    FUN_80091c0(28, 22, 1, 1, 27, 72);
  }

  @Method(0x200950c)
  public static void FUN_200950c() {
    FUN_808a018();
    FUN_808a0d0(0, 262, 810);
    FUN_808a0f0(20, 0x1060000, 0x3250000);
    FUN_808a0c8(20, 262, 825);
    setActorVelocityScalerAndAcceleration(0, 0x20000, 0x10000);
    FUN_808a128(0, 2, 0);
    FUN_808a0d0(0, 282, 855);
    setActorAnimationIfLoaded(20, 1);
    FUN_808a128(0, 4, 0);
    FUN_808a150(0, 20, 0);
    FUN_808a5e8();
    FUN_808a010(30);
    FUN_808a138(0, 2);
    FUN_808a1e8(20, 256, 20);
    FUN_808a170(0xe67);
    FUN_808a180(20, 0);
    FUN_808a010(20);
    FUN_808a190(20, 0);
    FUN_808a138(20, 2);
    FUN_808a170(0xe6b);
    FUN_808a188(20, 0, 20);
    FUN_808a0b0(20, 0x200c8c0);
    setFlag(0x835);
    FUN_808a020();
  }

  /**
   * Event list 0x200d558 handler 33
   */
  @Method(value = 0x2009600, ignoreExtraParams = true)
  public static void FUN_2009600() {
    if(readFlag(0x836) == 0 && readFlag(0x837) == 0) {
      FUN_808a018();
      FUN_808a170(0xe6c);
      FUN_808a188(22, 0, 20);
      FUN_808a1e8(0, 257, 40);
      FUN_808a0d0(0, 382, 619);
      FUN_200c7bc(0, 22, 0);
      FUN_808a138(0, 2);
      FUN_808a010(30);
      FUN_808a180(22, 0);
      setFlag(0x836);
      FUN_808a020();
    }
  }

  /**
   * Event list 0x200d558 handler 34
   */
  @Method(value = 0x2009684, ignoreExtraParams = true)
  public static void FUN_2009684() {
    if(readFlag(0x837) == 0 && readFlag(0x836) != 0) {
      FUN_808a018();
      FUN_808a138(22, 2);
      FUN_808a010(20);
      FUN_808a170(0xe71);
      FUN_200973c();
      FUN_808a020();
    }
  }

  /**
   * Event list 0x200d558 handler 12
   */
  @Method(value = 0x20096cc, ignoreExtraParams = true)
  public static void FUN_20096cc() {
    if(readFlag(0x841) != 0) {
      FUN_808a018();
      FUN_200c7bc(22, 0, 0);
      FUN_808a010(20);
      FUN_808a170(0xed0);
      FUN_808a180(22, 0);
      FUN_808a1b8(22, 0xe000, 10);
      FUN_808a020();
      //LAB_200970c
    } else if(readFlag(0x837) == 0) {
      FUN_808a018();
      FUN_808a170(0xe6e);
      FUN_200973c();
      FUN_808a020();
    }
  }

  @Method(0x200973c)
  public static void FUN_200973c() {
    FUN_808a178(22);
    FUN_808a150(0, 22, 0);

    final int r5;
    if(FUN_808a070(0, 0) == 0) {
      FUN_808a170(0xee5);
      r5 = 1;
    } else {
      //LAB_2009768
      FUN_808a170(0xee6);
      r5 = 0;
    }

    //LAB_200976e
    FUN_808a010(20);
    FUN_808a188(22, 0, 40);
    FUN_808a1f0(22, 0x100);
    setActorAnimationIfLoaded(21, 3);
    setActorAnimationIfLoaded(22, 1);
    FUN_808a010(40);
    FUN_200c7bc(22, 0, 0);
    FUN_808a010(20);
    setActorAnimationAndWaitUntilFinished(22, 3);

    if(r5 != 0) {
      FUN_808a170(0xe70);
    } else {
      //LAB_20097c2
      FUN_808a170(0xee7);
    }

    //LAB_20097c8
    FUN_808a180(22, 0);
    setActorAnimationIfLoaded(22, 2);

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_808a0b8(22, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_20097f0
    FUN_808a0e8(22);
    FUN_808a0f0(22, 0, 0);
    FUN_200c714(1, 1);
    setFlag(0x837);
  }

  /**
   * Event list 0x200d558 handler 35
   */
  @Method(value = 0x2009828, ignoreExtraParams = true)
  public static void FUN_2009828() {
    if(readFlag(0x837) == 0) {
      //LAB_2009836
      FUN_808a018();
      FUN_808a1f0(22, 0x100);
      FUN_808a170(0xe74);
      FUN_808a180(22, 0);
      FUN_808a1e8(0, 0x100, 20);
      FUN_808a1b8(0, 0x4000, 0);
      FUN_808a208(0x6666, 0xccc);
      FUN_808a210(0x1000000, -1, 0x24c0000, 1);
      setActorVelocityScalerAndAcceleration(22, 0x20000, 0x10000);
      FUN_808a0b0(22, 0x200c934);
      FUN_808a150(0, 22, 0);
      FUN_808a010(30);
      FUN_808a098(22, 0x200c984);
      FUN_808a180(22, 0);
      getMapActor(22)._1c.set(0x10000);
      FUN_808a138(22, 1);
      FUN_808a010(20);
      FUN_808a190(22, 0);
      FUN_808a010(40);
      FUN_808a138(22, 1);
      FUN_808a170(0xe79);
      FUN_808a188(22, 0, 20);
      setActorAnimationAndWaitUntilFinished(0, 3);
      setActorAnimationAndWaitUntilFinished(22, 3);
      FUN_808a180(22, 0);
      setActorVelocityScalerAndAcceleration(22, 0x10000, 0x8000);
      setActorAnimationIfLoaded(22, 2);

      final Actor70 r0 = getMapActor(0);
      if(r0 != null) {
        FUN_808a0b8(22, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_2009942
      FUN_808a0e8(22);
      FUN_808a0f0(22, 0, 0);
      FUN_200c714(1, 1);
      setActorAnimationIfLoaded(21, 3);
      setFlag(0x837);
      FUN_808a020();
    }
  }

  /**
   * Event list 0x200d558 handler 36
   */
  @Method(value = 0x200998c, ignoreExtraParams = true)
  public static void FUN_200998c() {
    FUN_808a018();

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_808a0f0(22, r0.pos_08.getX(), r0.pos_08.getZ());
    }

    //LAB_20099a6
    setActorVelocityScalerAndAcceleration(22, 0x10000, 0x8000);
    FUN_808a0d0(22, 281, 507);
    FUN_808a150(22, 0, 0);
    FUN_808a010(30);
    FUN_808a170(3707);
    FUN_808a180(22, 0);
    FUN_200c7bc(0, 22, 0);
    FUN_808a010(10);
    FUN_808a138(0, 1);
    FUN_808a010(20);
    FUN_808a1b8(22, 0x4000, 0);
    FUN_808a180(22, 0);
    setActorAnimationIfLoaded(22, 2);

    if(r0 != null) {
      FUN_808a0b8(22, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_2009a2e
    FUN_808a0e8(22);
    FUN_808a0f0(22, 0, 0);
    FUN_808a0d0(0, 256, 517);
    FUN_808a020();
  }

  @Method(0x2009a64)
  public static void FUN_2009a64(final int r0, final int r1) {
    final Actor70 actor = getMapActor(0);
    if(actor != null) {
      FUN_808a0f0(22, actor.pos_08.getX(), actor.pos_08.getZ());
    }

    //LAB_2009a7e
    setActorVelocityScalerAndAcceleration(22, 0x10000, 0x8000);
    FUN_808a0d0(22, r0, r1);
    FUN_808a150(0, 22, 0);
    FUN_808a010(20);
    FUN_808a1f0(0, 0x102);
    FUN_808a010(40);
    FUN_808a170(0xe7d);
    FUN_808a180(22, 0);
    FUN_808a138(22, 2);
    FUN_808a180(22, 0);
    setActorAnimationAndWaitUntilFinished(0, 3);
    setActorAnimationIfLoaded(22, 2);

    if(actor != null) {
      FUN_808a0b8(22, actor.pos_08.getX() >> 16, actor.pos_08.getZ() >> 16);
    }

    //LAB_2009afc
    FUN_808a0e8(22);
    FUN_808a0f0(22, 0, 0);
  }

  /**
   * Event list 0x200d558 handler 37
   */
  @Method(value = 0x2009b18, ignoreExtraParams = true)
  public static void FUN_2009b18() {
    if(readFlag(0x838) == 0) {
      //LAB_2009b32
      FUN_808a018();
      FUN_200c70c(0x200d4b0);
      FUN_200c550();
      sleep(1);
      playSound(0x8d);
      FUN_80091f0(0x20000, 0x20000, 0x10000);
      FUN_808a010(30);
      FUN_80091f0(0x30000, 0x30000, 0x10000);
      playSound(0x91);
      FUN_808a010(30);

      final Actor70 r0 = getMapActor(0);
      if(r0 != null) {
        FUN_808a0f0(22, r0.pos_08.getX(), r0.pos_08.getZ());
      }

      //LAB_2009b92
      setActorVelocityScalerAndAcceleration(0, 0x20000, 0x10000);
      setActorVelocityScalerAndAcceleration(22, 0x20000, 0x10000);
      FUN_808a098(0, 0x200ca00);
      FUN_808a0b0(22, 0x200ca3c);
      FUN_808a0a0(0);
      FUN_808a1e8(0, 0x100, 0);
      FUN_808a1e8(22, 0x100, 30);
      FUN_80091f0(0x40000, 0x40000, 0x10000);
      playSound(0x91);
      FUN_808a010(40);
      FUN_80091f0(0x50000, 0x50000, 0x10000);
      playSound(0x91);
      FUN_808a010(20);
      FUN_808a1f0(0, 0x102);
      FUN_808a1f0(22, 0x102);
      FUN_808a010(40);
      setActorAnimationIfLoaded(32, 5);
      setActorAnimationIfLoaded(33, 5);
      setActorAnimationIfLoaded(30, 8);
      setActorAnimationIfLoaded(29, 8);
      getMapActor(30).scale_18.set(0xffff0000);
      setActorPriority(32, 2);
      setActorPriority(33, 2);
      setActorPriority(30, 3);
      setActorPriority(29, 3);
      FUN_808a170(0xe7f);
      FUN_808a188(28, 0, 20);
      FUN_808a1b8(0, 0xc000, 0);
      FUN_808a1b8(22, 0xc000, 20);
      FUN_808a208(0x40000, 0x8000);
      FUN_808a210(0x700000, -1, 0x14b0000, 1);
      FUN_808a218();

      //LAB_2009cc2
      for(int r5 = 0; r5 < 40; r5++) {
        FUN_200c2bc(getMapActor(32));
        FUN_200c2bc(getMapActor(33));
        FUN_200c2bc(getMapActor(30));
        FUN_200c2bc(getMapActor(29));
        sleep(1);
      }

      MEMORY.ref(4, 0x200d7f8).setu(0);
      MEMORY.ref(4, 0x200d7fc).setu(0);
      setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c56c"), 0xc80);
      setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c5a8"), 0xc80);
      FUN_808a010(40);
      MEMORY.ref(4, 0x200d7fc).setu(1);
      FUN_808a010(30);
      FUN_808a0f0(19, 0x720000, 0x1220000);
      final Actor70 actor19 = getMapActor(19);
      actor19.pos_08.y_04.add(0x400000);
      actor19.dest_38.setY(actor19.pos_08.getY());
      setActorVelocityScalerAndAcceleration(19, 0xcccc, 0x6666);
      playSound(0x91);
      FUN_808a0c0(19, 114, 333);
      setActorAnimationIfLoaded(19, 2);
      FUN_80091f0(0x20000, 0x20000, 0x10000);
      playSound(0x91);
      MEMORY.ref(4, 0x200d7fc).setu(0);
      setActorVelocityScalerAndAcceleration(19, 0x6666, 0x3333);
      FUN_808a0c0(19, 114, 300);
      setActorAnimationIfLoaded(19, 2);
      FUN_80091f0(0x50000, 0x50000, 0x10000);
      playSound(0x91);
      MEMORY.ref(4, 0x200d7fc).setu(2);
      setActorVelocityScalerAndAcceleration(19, 0xcccc, 0x6666);
      FUN_808a0c0(19, 114, 333);
      setActorAnimationIfLoaded(19, 2);
      FUN_80091f0(0x20000, 0x20000, 0x10000);
      playSound(0x91);
      MEMORY.ref(4, 0x200d7fc).setu(0);
      setActorVelocityScalerAndAcceleration(19, 0x6666, 0x3333);
      FUN_808a0c0(19, 114, 300);
      setActorAnimationIfLoaded(19, 2);
      FUN_80091f0(0x40000, 0x40000, 0x10000);
      playSound(0x91);
      MEMORY.ref(4, 0x200d7fc).setu(2);
      setActorVelocityScalerAndAcceleration(19, 0xcccc, 0x6666);
      FUN_808a0c0(19, 114, 333);
      setActorAnimationIfLoaded(19, 2);
      FUN_80091f0(0x20000, 0x20000, 0x10000);
      playSound(0x91);
      MEMORY.ref(4, 0x200d7fc).setu(1);
      FUN_808a010(20);
      FUN_808a1f0(32, 0x102);
      FUN_808a138(32, 2);
      FUN_808a180(31, 0);
      FUN_808a1e8(33, 0x100, 0);
      FUN_808a138(33, 2);
      FUN_808a188(28, 0, 40);
      FUN_808a1f0(30, 0x102);
      FUN_808a138(30, 2);
      FUN_808a180(30, 0);
      MEMORY.ref(4, 0x200d7f8).setu(1);
      setActorAnimationIfLoaded(29, 1);
      sleep(1);
      FUN_808a158(29, 0);
      FUN_808a1e8(29, 0x105, 20);
      FUN_808a1b8(29, 0x8000, 40);
      FUN_808a1b8(29, 0, 20);
      FUN_808a1b8(29, 0x8000, 20);
      FUN_808a1b8(29, 0x4000, 40);
      FUN_808a1e8(29, 0x100, 0);
      FUN_808a138(29, 2);
      FUN_808a128(29, 4, 40);
      setActorAnimationIfLoaded(29, 9);
      FUN_808a010(10);
      FUN_808a188(29, 0, 20);
      playSound(0x121);
      FUN_80091f0(-1, -1, 0xe666);
      FUN_808a208(0x60000, 0xc000);
      FUN_808a210(0x540000, -1, 0x2340000, 1);
      FUN_808a218();
      FUN_808a5e8();
      FUN_200c7bc(22, 0, 0);
      FUN_808a010(20);
      FUN_808a1f0(22, 0x102);
      FUN_808a010(30);
      clearTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c56c"));
      clearTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c5a8"));
      FUN_808a180(22, 0);
      FUN_200c7bc(0, 22, 0);
      FUN_808a010(20);
      FUN_200c560();
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationAndWaitUntilFinished(22, 3);
      FUN_808a010(20);
      setActorAnimationIfLoaded(22, 2);

      if(r0 != null) {
        FUN_808a0b8(22, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
      }

      //LAB_200a040
      FUN_808a0e8(22);
      FUN_808a0f0(22, 0, 0);
      FUN_200c734(31);
      FUN_200c734(28);
      FUN_200c734(30);
      FUN_200c734(29);
      FUN_200c734(32);
      FUN_200c734(33);
      setFlag(0x838);
      FUN_808a020();
    }

    //LAB_200a07e
  }

  /**
   * Event list 0x200d558 handler 38
   */
  @Method(value = 0x200a180, ignoreExtraParams = true)
  public static void FUN_200a180() {
    if(readFlag(0x83a) == 0) {
      //LAB_200a18e
      FUN_808a018();
      FUN_808a0f0(10, 0xc00000, 0x4be0000);
      FUN_808a1b8(10, 0x2000, 0);
      setActorAnimationIfLoaded(10, 5);
      getMapActor(10)._64.set(FUN_200c634(rand(), 90) + 60);
      FUN_808a098(10, 0x200cec8);
      FUN_808a0f0(9, 0xc00000, 0x4a50000);
      FUN_808a1b8(9, 0x2000, 0);
      FUN_808a0f0(24, 0xe30000, 0x4be0000);
      FUN_808a1b8(24, 0x4000, 0);
      setActorAnimationIfLoaded(24, 6);
      getMapActor(24)._64.set(FUN_200c634(rand(), 90) + 60);
      FUN_808a098(24, 0x200cec8);
      FUN_808a0f0(25, 0xfa0000, 0x4be0000);
      FUN_808a1b8(25, 0x4000, 0);
      setActorAnimationIfLoaded(25, 6);
      getMapActor(25)._64.set(FUN_200c634(rand(), 90) + 60);
      FUN_808a098(25, 0x200cec8);
      FUN_808a0f0(26, 0xe30000, 0x4a50000);
      FUN_808a1b8(26, 0x3000, 0);
      FUN_808a0f0(23, 0xf30000, 0x4fd0000);
      FUN_808a1b8(23, 0xc000, 0);
      FUN_80091e0(getMapActor(23), 0);
      sleep(3);
      FUN_808a170(0xe8c);
      FUN_808a180(0x201a, 0);
      FUN_808a1e8(0, 0x100, 20);
      FUN_808a0d0(0, 150, 1094);

      final Actor70 actor0 = getMapActor(0);
      if(actor0 != null) {
        FUN_808a0f0(22, actor0.pos_08.getX(), actor0.pos_08.getZ());
      }

      //LAB_200a2e6
      FUN_808a0d0(22, 132, 1094);
      FUN_808a150(0, 22, 0);
      FUN_808a010(40);
      FUN_808a1b8(0, 0x4000, 0);
      FUN_808a1b8(22, 0x4000, 20);
      FUN_808a208(0x40000, 0x8000);
      FUN_808a210(0xd80000, -1, 0x4d00000, 1);
      FUN_808a218();
      FUN_808a010(40);
      FUN_808a138(10, 2);
      FUN_808a188(10, 0, 10);
      FUN_808a138(23, 3);
      FUN_808a1b8(9, 0, 10);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a188(9, 0, 10);
      FUN_808a1b8(9, 0x3000, 10);
      FUN_808a208(0x30000, 0x6000);
      FUN_808a210(0xe80000, -1, 0x4e50000, 1);
      FUN_808a218();
      FUN_808a010(20);
      playSound(0x86);
      FUN_808a128(23, 4, 0);
      setActorAnimationIfLoaded(23, 6);
      FUN_808a010(10);
      FUN_808a0f0(23, 0, 0);
      FUN_808a010(60);
      FUN_808a5e8();
      setActorAnimationIfLoaded(10, 1);
      final Actor70 actor10 = getMapActor(10);
      actor10.scale_18.set(0x10000);
      actor10._1c.set(0x10000);
      setActorAnimationIfLoaded(24, 1);
      final Actor70 actor24 = getMapActor(24);
      actor24.scale_18.set(0x10000);
      actor24._1c.set(0x10000);
      setActorAnimationIfLoaded(25, 1);
      final Actor70 actor25 = getMapActor(25);
      actor25.scale_18.set(0x10000);
      actor25._1c.set(0x10000);
      FUN_808a130(10, 2);
      FUN_808a130(9, 2);
      FUN_808a130(24, 2);
      FUN_808a130(25, 2);
      FUN_808a138(26, 2);
      FUN_808a208(0x9999, 0x1333);
      FUN_808a210(0xd80000, -1, 0x4d00000, 1);
      FUN_808a218();
      FUN_808a1f0(26, 0x102);
      FUN_808a1f0(9, 0x102);
      FUN_808a010(60);
      FUN_808a138(26, 2);
      FUN_808a130(26, 3);
      FUN_808a180(26, 0);
      FUN_808a128(25, 2, 0);
      FUN_808a0b8(25, 234, 1205);
      FUN_808a128(26, 2, 0);
      FUN_808a0b8(26, 227, 1201);
      FUN_808a010(90);
      FUN_808a210(0xe80000, -1, 0x4e50000, 1);
      FUN_808a218();
      FUN_808a0f0(23, 0xf30000, 0x4fd0000);
      sleep(1);
      playSound(0x6a);
      getMapActor(23).velocity_24.setY(0x20000);
      FUN_808a010(6);
      setActorAnimationIfLoaded(23, 7);
      FUN_808a010(20);
      FUN_808a5e8();
      FUN_808a010(20);
      FUN_808a208(0x19999, 0x3333);
      FUN_808a210(0xd80000, -1, 0x4d00000, 1);
      FUN_808a218();
      FUN_808a138(24, 2);
      FUN_808a010(20);
      FUN_808a1e8(24, 0x105, 40);
      FUN_808a150(24, 10, 0);
      FUN_808a010(10);
      FUN_808a138(10, 2);
      FUN_808a180(0x800a, 0);
      getMapActor(25)._5a.and(~0x1);
      getMapActor(26)._5a.and(~0x1);
      setActorVelocityScalerAndAcceleration(25, 0x9999, 0x4ccc);
      setActorVelocityScalerAndAcceleration(26, 0x9999, 0x4ccc);
      FUN_808a0b8(25, 247, 1210);
      FUN_808a0c0(26, 227, 1189);
      getMapActor(25)._5a.or(0x1);
      getMapActor(26)._5a.or(0x1);
      FUN_808a1b8(26, 0x6000, 0);
      FUN_808a1b8(25, 0x8000, 10);
      setActorAnimationIfLoaded(24, 4);
      FUN_808a188(0x8018, 0, 10);
      FUN_808a1b8(10, 0xc000, 20);
      FUN_808a1b8(10, 0, 10);
      setActorAnimationIfLoaded(10, 4);
      FUN_808a188(0x800a, 0, 10);
      FUN_808a1e8(24, 261, 0);
      FUN_808a1e8(10, 261, 60);
      FUN_808a1e8(9, 262, 20);
      FUN_808a1b8(9, 0x8000, 40);
      FUN_808a1b8(9, 0xc000, 20);
      FUN_808a1b8(9, 0, 30);
      FUN_808a1b8(9, 0x4000, 10);
      FUN_808a188(9, 0, 10);
      FUN_808a1b8(10, 0xc000, 0);
      FUN_808a1b8(25, 0x9000, 0);
      FUN_808a1b8(24, 0xa000, 0);
      FUN_808a1b8(26, 0x8000, 10);
      FUN_808a138(10, 1);
      FUN_808a188(0x800a, 0, 10);
      setActorAnimationIfLoaded(9, 4);
      FUN_808a188(9, 0, 10);
      FUN_808a1e8(10, 261, 0);
      FUN_808a1e8(24, 261, 0);
      FUN_808a1e8(25, 261, 0);
      FUN_808a1e8(26, 261, 40);
      FUN_808a1b8(9, 0, 10);
      FUN_808a150(24, 25, 0);
      FUN_808a010(20);
      FUN_808a1b8(9, 0, 0);
      FUN_808a1b8(10, 0, 10);
      FUN_808a1b8(24, 0x8000, 0);
      FUN_808a1b8(25, 0x8000, 10);
      setActorAnimationIfLoaded(24, 3);
      setActorAnimationAndWaitUntilFinished(25, 3);
      FUN_808a150(10, 9, 0);
      FUN_808a010(20);
      FUN_808a138(10, 1);
      FUN_808a188(0x800a, 0, 10);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a1b8(24, 0xd000, 10);
      FUN_808a130(24, 1);
      FUN_808a188(24, 0, 10);
      FUN_808a1b8(10, 0, 0);
      FUN_808a1b8(9, 0, 0);
      FUN_808a138(26, 1);
      FUN_808a1b8(26, 0x2000, 20);
      FUN_808a1b8(25, 0xa000, 20);
      setActorAnimationAndWaitUntilFinished(25, 3);
      FUN_808a188(25, 0, 10);
      setActorAnimationAndWaitUntilFinished(26, 3);
      FUN_808a010(20);
      FUN_808a138(9, 2);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a188(9, 0, 10);
      FUN_808a1b8(26, 0x8000, 10);
      setActorAnimationAndWaitUntilFinished(26, 3);
      FUN_808a010(20);
      FUN_808a138(9, 1);
      FUN_808a188(9, 0, 10);
      FUN_200a8a4();
      setFlag(0x83a);
      FUN_808a020();
    }
  }

  @Method(0x200a8a4)
  public static void FUN_200a8a4() {
    FUN_808a1b8(26, 0x3000, 0);
    FUN_808a1b8(24, 0xd000, 0);
    FUN_808a1b8(25, 0xb000, 0);
    FUN_808a1b8(9, 0x3000, 0);
    FUN_808a1b8(10, 0xd000, 20);
    setActorAnimationIfLoaded(26, 3);
    setActorAnimationIfLoaded(24, 3);
    setActorAnimationIfLoaded(25, 3);
    setActorAnimationIfLoaded(9, 3);
    setActorAnimationAndWaitUntilFinished(25, 3);
    FUN_808a010(20);
    FUN_808a208(0x10000, 0x2000);
    FUN_808a210(0x860000, -1, 0x4ab0000, 1);
    setActorVelocityScalerAndAcceleration(26, 0x19999, 0xcccc);
    setActorVelocityScalerAndAcceleration(9, 0x19999, 0xcccc);
    FUN_808a098(26, 0x200cab4);
    FUN_808a0b0(9, 0x200ca78);
    playSound(0x9e);
    FUN_8009178(0x200d7a0, 38, 72);
    FUN_808a010(10);
    FUN_808a0d0(9, 149, 1175);
    FUN_808a0f0(9, 0, 0);
    FUN_808a0d0(25, 250, 1214);
    FUN_808a5e8();
    FUN_808a1b8(10, 0x3000, 0);
    FUN_808a1b8(24, 0x3000, 0);
    FUN_808a1b8(25, 0x3000, 0);
    setActorAnimationIfLoaded(10, 5);
    setActorAnimationIfLoaded(24, 6);
    setActorAnimationIfLoaded(25, 6);
    getMapActor(10)._64.set(FUN_200c634(rand(), 90) + 60);
    getMapActor(24)._64.set(FUN_200c634(rand(), 90) + 60);
    getMapActor(25)._64.set(FUN_200c634(rand(), 90) + 60);
    FUN_808a098(10, 0x200cec8);
    FUN_808a098(24, 0x200cec8);
    FUN_808a098(25, 0x200cec8);
    FUN_808a0a0(26);
    FUN_808a010(10);
    playSound(159);
    FUN_8009178(0x200d7e2, 38, 72);
    FUN_808a010(30);
    FUN_808a5e8();
    FUN_808a210(0x700000, -1, 0x4c90000, 1);
    playSound(0x9e);
    FUN_8009178(0x200d78a, 35, 73);
    FUN_808a010(20);
    FUN_808a5e8();
    FUN_808a098(9, 0x200cb28);
    FUN_808a010(20);
    FUN_808a098(26, 0x200cb9c);
    FUN_808a010(40);
    playSound(0x9f);
    FUN_8009178(0x200d7cc, 35, 73);
    FUN_808a0a0(26);
    FUN_808a5e8();
    FUN_808a010(40);
    FUN_808a170(0xe9b);
    FUN_808a188(9, 0, 20);
    setActorAnimationAndWaitUntilFinished(26, 3);
    FUN_808a188(0x201a, 0, 40);
    setActorAnimationIfLoaded(9, 3);
    setActorAnimationAndWaitUntilFinished(26, 3);
    FUN_808a010(30);
    FUN_808a098(9, 0x200cc0c);
    FUN_808a098(26, 0x200cc5c);
    FUN_808a010(40);
    FUN_808a208(0x20000, 0x4000);
    FUN_808a210(0x690000, -1, 0x43e0000, 1);
    FUN_808a0a0(9);
    FUN_808a1b8(9, 0, 0);
    FUN_808a1e8(9, 256, 40);
    FUN_808a188(9, 0, 10);
    FUN_808a1b8(0, 0x8000, 0);
    FUN_808a1b8(22, 0x8000, 10);
    FUN_808a0d0(9, 105, 1086);
    FUN_808a138(9, 2);
    FUN_808a178(0x8009);
    FUN_808a1b8(22, 0, 0);

    if(FUN_808a070(0, 0) == 0) {
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a170(0xe9f);
    } else {
      //LAB_200ab9c
      FUN_808a138(9, 2);
      FUN_808a170(0xea0);
    }

    //LAB_200abaa
    FUN_808a180(0x8009, 0);
    FUN_808a1b8(22, 0x8000, 40);
    FUN_808a1e8(9, 256, 30);
    FUN_808a170(0xea1);
    FUN_808a178(0x8009);

    if(FUN_808a070(0, 0) == 0) {
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a170(0xea2);
      FUN_808a188(0x8009, 0, 30);
      FUN_808a1b8(22, 0x8000, 20);
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationIfLoaded(22, 3);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a010(40);
    } else {
      //LAB_200ac2a
      FUN_808a1e8(9, 261, 90);
      FUN_808a1e8(9, 259, 40);
      setActorAnimationIfLoaded(9, 4);
      FUN_808a170(0xea3);
      FUN_808a180(0x8009, 0);
    }

    //LAB_200ac54
    FUN_808a098(9, 0x200cca8);
    FUN_808a010(90);
    FUN_808a150(0, 22, 0);
    FUN_808a010(40);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(22, 3);
    FUN_808a010(20);
    setActorAnimationIfLoaded(22, 2);

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_808a0b8(22, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_200aca8
    FUN_808a0e8(22);
    FUN_808a0f0(22, 0, 0);
  }

  /**
   * Event list 0x200d558 handler 13
   */
  @Method(value = 0x200ad28, ignoreExtraParams = true)
  public static void FUN_200ad28() {
    FUN_808a018();
    setActorAnimationIfLoaded(10, 1);
    FUN_808a010(10);
    FUN_808a150(10, 0, 20);

    if(readFlag(0x30d) != 0) {
      FUN_808a170(0xea5);
      FUN_808a188(10, 0, 10);
    } else {
      //LAB_200ad62
      FUN_808a170(0xea4);
      FUN_808a130(10, 1);
      FUN_808a188(10, 0, 10);
      FUN_808a130(10, 2);
      FUN_808a188(10, 0, 10);
    }

    //LAB_200ad8c
    FUN_808a1b8(10, 0x2000, 20);
    setActorAnimationIfLoaded(10, 5);
    FUN_808a010(10);
    getMapActor(10)._64.set(FUN_200c634(rand(), 90) + 60);
    FUN_808a098(10, 0x200cec8);
    FUN_808a010(20);
    setFlag(0x30d);
    FUN_808a020();
  }

  /**
   * Event list 0x200d558 handler 39
   */
  @Method(value = 0x200adec, ignoreExtraParams = true)
  public static void FUN_200adec() {
    if(readFlag(0x840) != 0 && readFlag(0x841) == 0) {
      FUN_808a018();
      setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
      setActorVelocityScalerAndAcceleration(22, 0x10000, 0x8000);
      setActorVelocityScalerAndAcceleration(26, 0x10000, 0x8000);
      setActorVelocityScalerAndAcceleration(8, 0x10000, 0x8000);
      FUN_808a0d0(0, 217, 1367);

      final Actor70 r0 = getMapActor(0);
      if(r0 != null) {
        FUN_808a0f0(22, r0.pos_08.getX(), r0.pos_08.getZ());
      }

      //LAB_200ae62
      FUN_808a0d0(22, 235, 1367);
      FUN_808a1b8(22, 0xb000, 0);

      if(r0 != null) {
        FUN_808a0f0(26, r0.pos_08.getX(), r0.pos_08.getZ());
      }

      //LAB_200ae8c
      FUN_808a0d0(26, 199, 1367);
      FUN_808a1b8(26, 0xd000, 0);
      FUN_808a0f0(25, 0xf70000, 0x4ba0000);
      FUN_808a1b8(25, 0x6000, 0);
      final Actor70 actor8 = getMapActor(8);
      final Sprite38 sprite8 = actor8.sprite_50.deref();
      actor8.flags_23.and(~0x1);
      sprite8.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
      sprite8.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);

      if(r0 != null) {
        r0.flags_23.and(~0x1);
        FUN_808a0f0(8, r0.pos_08.getX(), r0.pos_08.getZ());
      }

      //LAB_200af10
      FUN_808a0d0(8, 221, 1385);
      FUN_808a1b8(8, 0xb000, 60);
      FUN_808a138(26, 2);
      FUN_808a170(0xec6);
      FUN_808a188(26, 0, 40);
      FUN_808a0f0(9, 0x650000, 0x4ad0000);
      FUN_808a1b8(9, 0x2000, 0);
      FUN_808a188(0x1009, 0, 10);
      FUN_808a1b8(26, 0xa000, 0);
      FUN_808a208(0x13333, 0x2666);
      FUN_808a210(0x650000, -1, 0x4ad0000, 1);
      setActorVelocityScalerAndAcceleration(9, 0x16666, 0xb333);
      FUN_808a098(9, 0x200cd1c);
      FUN_808a010(60);
      FUN_808a208(0x9999, 0x1333);
      FUN_808a210(0xbb0000, -1, 0x5300000, 1);
      FUN_808a218();
      FUN_808a010(40);
      FUN_808a138(26, 2);
      FUN_808a188(26, 0, 20);
      FUN_808a138(9, 2);
      FUN_808a188(0x4009, 0, 20);
      FUN_808a208(0x20000, 0x4000);
      FUN_808a210(0xdd0000, -1, 0x5690000, 1);
      FUN_200c7bc(0, 8, 0);
      FUN_200c7bc(22, 8, 0);
      FUN_808a1b8(26, 0x3000, 80);
      FUN_808a210(0xb60000, -1, 0x5500000, 1);
      FUN_808a0d0(8, 182, 1384);
      FUN_200c7bc(8, 9, 0);
      FUN_808a010(30);
      setActorAnimationAndWaitUntilFinished(8, 3);
      FUN_808a010(10);
      FUN_200c7bc(0, 9, 0);
      FUN_200c7bc(22, 9, 0);
      FUN_200c7bc(26, 9, 0);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a180(9, 0);
      FUN_808a138(26, 2);
      FUN_808a188(26, 0, 10);
      FUN_808a1b8(9, 0xe000, 40);
      FUN_808a1b8(9, 0x3000, 20);
      setActorAnimationAndWaitUntilFinished(9, 3);
      FUN_808a180(9, 0);
      FUN_808a150(26, 8, 0);
      FUN_808a150(22, 0, 0);
      FUN_808a010(40);
      FUN_200c7bc(0, 9, 0);
      FUN_200c7bc(22, 9, 0);
      FUN_200c7bc(26, 9, 0);
      FUN_200c7bc(8, 9, 0);
      FUN_808a138(9, 2);
      FUN_808a010(20);
      FUN_808a188(9, 0, 10);
      setActorAnimationIfLoaded(0, 3);
      setActorAnimationIfLoaded(26, 3);
      setActorAnimationIfLoaded(22, 3);
      setActorAnimationAndWaitUntilFinished(8, 3);
      r0.flags_23.or(0x1);
      actor8.flags_23.or(0x1);
      FUN_200b1ac();
      setFlag(0x841);
      FUN_808a020();
    }
  }

  @Method(0x200b1ac)
  public static void FUN_200b1ac() {
    final Actor70 r7 = getMapActor(19);
    final Actor70 r6 = getMapActor(27);
    final Sprite38 r11 = r6.sprite_50.deref();
    final Sprite38 r10 = r7.sprite_50.deref();
    FUN_808a208(0x10000, 0x2000);
    FUN_808a210(0x6e0000, -1, 0x58b0000, 1);
    setActorVelocityScalerAndAcceleration(8, 0x13333, 0x9999);
    setActorVelocityScalerAndAcceleration(26, 0x13333, 0x9999);
    setActorVelocityScalerAndAcceleration(0, 0x13333, 0x9999);
    setActorVelocityScalerAndAcceleration(22, 0x13333, 0x9999);
    FUN_808a098(8, 0x200cd6c);
    FUN_808a010(10);
    FUN_808a098(26, 0x200cd6c);
    FUN_808a2d8();
    FUN_808a010(10);
    FUN_808a098(0, 0x200cd6c);
    FUN_808a010(10);
    FUN_808a2d0();
    FUN_808a098(22, 0x200cd6c);
    FUN_808a010(0x80);
    FUN_2008134();
    FUN_808a210(0xae0000, -1, 0x5940000, 1);
    FUN_808a010(104);
    FUN_808a210(0x990000, -1, 0x52d0000, 1);
    FUN_808a0d0(9, 158, 1272);
    FUN_808a1b8(9, 0x2000, 0);
    FUN_808a0a0(8);
    FUN_808a098(8, 0x200ce04);
    FUN_808a098(26, 0x200ce30);
    FUN_808a098(0, 0x200ce5c);
    FUN_808a0b0(22, 0x200ce88);
    FUN_80091f0(0x40000, 0x40000, 0x10000);
    playSound(0x91);
    FUN_808a010(20);
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a010(60);
    FUN_808a1e8(0, 0x101, 0);
    FUN_808a1e8(26, 0x101, 0);
    FUN_808a1e8(22, 0x101, 0);
    FUN_808a1e8(8, 0x101, 0);
    FUN_808a1e8(9, 0x101, 60);
    FUN_808a150(26, 8, 0);
    FUN_808a150(22, 0, 0);
    FUN_808a010(20);
    getMapActor(0)._64.set(FUN_200c634(rand(), 20) + 20);
    getMapActor(22)._64.set(FUN_200c634(rand(), 20) + 20);
    getMapActor(26)._64.set(FUN_200c634(rand(), 20) + 20);
    getMapActor(8)._64.set(FUN_200c634(rand(), 20) + 20);
    getMapActor(9)._64.set(FUN_200c634(rand(), 20) + 20);
    FUN_808a098(9, 0x200ceb4);
    FUN_808a010(30);
    FUN_808a098(0, 0x200ceb4);
    FUN_808a098(26, 0x200ceb4);
    FUN_808a098(22, 0x200ceb4);
    FUN_808a098(8, 0x200ceb4);
    FUN_808a010(10);
    playSound(17);
    FUN_80091f0(0x30000, 0x30000, 0x10000);
    playSound(0x91);
    FUN_808a010(30);
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a010(120);
    FUN_80091f0(0x30000, 0x30000, 0x10000);
    playSound(0x91);
    FUN_808a010(40);
    FUN_80091f0(0x20000, 0x20000, 0x10000);
    FUN_808a010(60);
    FUN_80091f0(0x40000, 0x40000, 0x10000);
    playSound(0x91);
    FUN_808a010(20);
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a010(60);
    FUN_80091f0(0x30000, 0x30000, 0x10000);
    playSound(0x91);
    FUN_808a010(40);
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a010(60);
    FUN_808a2d0();
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a010(1);
    FUN_80091f0(-1, -1, 0xe666);
    FUN_808a208(0x80000, 0x80000);
    FUN_808a210(0xd90000, -1, 0x43c0000, 1);
    FUN_808a330(0, 0);
    FUN_808a348(40);
    sleep(40);
    FUN_808a158(19, 0);
    FUN_80091e0(getMapActor(19), 0);
    FUN_80091e0(getMapActor(27), 0);
    r6.scale_18.set(0xcccc);
    r6._1c.set(0xcccc);
    r6.flags_23.and(~0x1);
    r11.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    r7.pos_08.set(0xc80000, 0xc80000, 0x3820000);
    r7.dest_38.set(0xc80000, 0xc80000, 0x3820000);
    r7._55.set(0);
    r7.flags_23.and(~0x1);
    r10.packet_00.attribs_04.attrib2_04.and(~0xc00);
    Actor70 r0 = FUN_808a228();
    r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    r0.velocity_24.set(0, 0, 0);
    sleep(1);
    FUN_808a210(0xf70000, 0x800000, 0x3950000, 0);
    FUN_8009128();
    sleep(1);
    FUN_808a330(0x10003, 1);
    FUN_808a330(0x10000, 2);
    FUN_808a348(30);
    sleep(30);
    setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200bce4"), 3200);
    FUN_808a098(19, 0x200cedc);
    FUN_808a208(0x20000, 0x7ae);
    FUN_808a210(0xaf0000, 0x600000, 0x43e0000, 1);

    //LAB_200b662
    do {
      sleep(1);
    } while(r7._66.get() != 8);

    FUN_808a330(0, 0);
    FUN_808a348(60);
    sleep(60);
    FUN_80091f8();
    r0 = FUN_808a228();
    r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    r0.velocity_24.set(0, 0, 0);
    clearTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200bce4"));
    FUN_808a0a8(19);
    sleep(1);
    setActorAnimationIfLoaded(19, 0);
    r6.scale_18.set(0x14000);
    r6._1c.set(0x14000);
    r11.y_23.set(2);
    r11.scale_18.set(0x14000);
    r7.scale_18.set(0x20000);
    r7._1c.set(0x20000);
    r7.pos_08.setX(0);
    r7.pos_08.setZ(0);
    r7.dest_38.setX(0);
    r7.dest_38.setZ(0);
    sleep(1);
    setActorAnimationIfLoaded(23, 8);
    FUN_808a0f0(9, 0xa90000, 0x4f00000);
    FUN_808a1b8(9, 0xc000, 0);
    setActorAnimationIfLoaded(9, 9);
    FUN_808a0f0(26, 0x970000, 0x50c0000);
    FUN_808a1b8(26, 0x8000, 0);
    setActorAnimationIfLoaded(26, 5);
    FUN_808a0f0(8, 0xaa0000, 0x5210000);
    FUN_808a1b8(8, 0x6000, 0);
    setActorAnimationIfLoaded(8, 5);
    FUN_808a0f0(0, 0xb90000, 0x5350000);
    FUN_808a1b8(0, 0x2000, 0);
    setActorAnimationIfLoaded(0, 17);
    FUN_808a0f0(22, 0xa90000, 0x5680000);
    FUN_808a1b8(22, 0x4000, 0);
    setActorAnimationIfLoaded(22, 0);
    FUN_808a210(0xa60000, 0, 0x5390000, 0);
    FUN_8009128();
    r7._55.set(0);
    r7.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    FUN_200bc48();
    FUN_808a0f0(27, 0xda0000, 0x4980000);
    FUN_808a210(0xd20000, 0, 0x4ac0000, 0);
    FUN_8009128();
    r6.scale_18.set(0x20000);
    r6._1c.set(0x20000);
    setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200be18"), 0xc80);
    FUN_808a0a8(10);
    FUN_808a0a8(24);
    FUN_808a0a8(25);
    sleep(1);
    final Actor70 actor10 = getMapActor(10);
    actor10.flags_23.and(~0x1);
    actor10.scale_18.set(0x10000);
    actor10._1c.set(0x10000);
    actor10.angle_06.set(0xd000);
    actor10.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    setActorAnimationIfLoaded(10, 0);
    final Actor70 actor24 = getMapActor(24);
    actor24.flags_23.and(~0x1);
    actor24.scale_18.set(0x10000);
    actor24._1c.set(0x10000);
    actor24.angle_06.set(0xb000);
    actor24.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    setActorAnimationIfLoaded(24, 5);
    final Actor70 actor25 = getMapActor(25);
    actor25.flags_23.and(~0x1);
    actor25.scale_18.set(0x10000);
    actor25._1c.set(0x10000);
    actor25.angle_06.set(0xb000);
    actor25.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00);
    setActorAnimationIfLoaded(25, 5);
    final Actor70 actor27 = getMapActor(27);
    FUN_200bc48();
    r7.pos_08.set(0xd60000, 0x300000, 0x4c00000);
    r7.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    actor27.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    FUN_808a0f0(27, 0xd60000, 0x4c00000);
    FUN_808a1b8(24, 0xc000, 0);
    FUN_808a1b8(25, 0xc000, 20);
    setFlag(0x166);
    FUN_8009190(0);
    FUN_8009190(1);
    FUN_8009190(2);
    FUN_8009190(3);
    FUN_8009190(4);
    FUN_8009190(5);
    FUN_808a330(0x10003, 1);
    FUN_808a330(0x10000, 2);
    FUN_808a348(120);
    sleep(160);
    FUN_808a330(0x7fff, 1);
    FUN_808a330(0x7fff, 2);
    FUN_808a348(80);
    FUN_808a010(80);
    FUN_808a010(100);
    clearTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200be18"));
    actor27.sprite_50.deref().scale_18.set(actor27.scale_18.get());
    clearFlag(0x166);
    FUN_8009188(0);
    FUN_8009188(1);
    FUN_8009188(2);
    FUN_8009188(3);
    FUN_8009188(4);
    FUN_8009188(5);
    FUN_200c0f0();
    FUN_808a0f0(9, 0xa50000, 0x4cd0000);
    setActorAnimationIfLoaded(9, 1);
    final Actor70 actor9 = getMapActor(9);
    actor9.angle_06.set(0xe000);
    actor9._64.set(FUN_200c634(rand(), 90) + 60);
    actor9._66.set(1);
    FUN_808a098(9, 0x200cec8);
    FUN_808a0f0(26, 0xa50000, 0x4e60000);
    setActorAnimationIfLoaded(26, 1);
    final Actor70 actor26 = getMapActor(26);
    actor26.angle_06.set(0xe000);
    actor26._64.set(FUN_200c634(rand(), 90) + 60);
    actor26._66.set(2);
    FUN_808a098(26, 0x200cec8);
    FUN_808a0f0(22, 0x980000, 0x5050000);
    setActorAnimationIfLoaded(22, 1);
    final Actor70 actor22 = getMapActor(22);
    actor22.angle_06.set(0xe000);
    actor22._64.set(FUN_200c634(rand(), 90) + 60);
    actor22._66.set(3);
    FUN_808a098(22, 0x200cec8);
    FUN_808a0f0(8, 0xb40000, 0x51f0000);
    final Actor70 actor8 = getMapActor(8);
    actor8.angle_06.set(0xe000);
    actor8._64.set(FUN_200c634(rand(), 90) + 60);
    actor8._66.set(4);
    FUN_808a098(8, 0x200cec8);
    setActorAnimationIfLoaded(8, 6);
    getMapActor(22).flags_23.and(~0x1);
    getMapActor(8).flags_23.and(~0x1);
    setTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c5b8"), 0xc80);
    FUN_808a0f0(0, 0xb50000, 0x4f90000);
    getMapActor(0).angle_06.set(0xe000);
    setActorAnimationIfLoaded(0, 1);
    FUN_808a210(0xb50000, 0, 0x4f90000, 0);
    FUN_8009128();
    FUN_808a0f0(10, 0, 0);
    FUN_808a0f0(19, 0, 0);
    FUN_808a0f0(24, 0, 0);
    FUN_808a0f0(25, 0, 0);
    FUN_808a0f0(23, 0, 0);
    FUN_808a0f0(27, 0, 0);
    FUN_808a0f0(17, 0x900000, 0x42e0000);
    FUN_808a0f0(18, 0x1140000, 0x4f60000);
    sleep(60);
    FUN_808a330(0x10003, 1);
    FUN_808a330(0x10000, 2);
    FUN_808a348(80);
    FUN_808a010(60);
    FUN_808a5e8();
    FUN_808a010(60);
    removeCharAndHealRemainingChars(1);
    FUN_808a2e0();
  }

  @Method(0x200bc48)
  public static void FUN_200bc48() {
    int r0;
    int r1;

    r0 = 0x14;
    sleep(r0);
    r0 = 0xb3;
    r0 = r0 << 1;
    setFlag(r0);
    r0 = 0x0;
    FUN_8009190(r0);
    r0 = 0x1;
    FUN_8009190(r0);
    r0 = 0x2;
    FUN_8009190(r0);
    r0 = 0x3;
    FUN_8009190(r0);
    r0 = 0x4;
    FUN_8009190(r0);
    r0 = 0x5;
    FUN_8009190(r0);
    r0 = 0x10003;
    r1 = 0x1;
    FUN_808a330(r0, r1);
    r0 = 0x80;
    r1 = 0x2;
    r0 = r0 << 9;
    FUN_808a330(r0, r1);
    r0 = 0x1;
    FUN_808a348(r0);
    r0 = 0x78;
    sleep(r0);
    r1 = 0x0;
    r0 = 0x0;
    FUN_808a330(r0, r1);
    r0 = 0x3c;
    FUN_808a348(r0);
    r0 = 0x3c;
    sleep(r0);
    r0 = 0xb3;
    r0 = r0 << 1;
    clearFlag(r0);
    r0 = 0x0;
    FUN_8009188(r0);
    r0 = 0x1;
    FUN_8009188(r0);
    r0 = 0x2;
    FUN_8009188(r0);
    r0 = 0x3;
    FUN_8009188(r0);
    r0 = 0x4;
    FUN_8009188(r0);
    r0 = 0x5;
    FUN_8009188(r0);
  }

  /**
   * Event list 0x200d558 handler 18
   */
  @Method(value = 0x200be48, ignoreExtraParams = true)
  public static void FUN_200be48() {
    final Actor70 r6 = getMapActor(0);
    final Actor70 r5 = getMapActor(8);
    FUN_808a018();

    FUN_808a0a8(8);
    if(readFlag(0x305) != 0) {
      FUN_808a010(10);
      FUN_808a138(8, 2);
      FUN_808a010(40);

      if(r6.angle_06.get() < 0) {
        setActorAnimationIfLoaded(8, 7);
      } else {
        //LAB_200be94
        setActorAnimationIfLoaded(8, 8);
      }

      //LAB_200be9c
      FUN_808a138(8, 2);
      FUN_808a010(20);
      FUN_808a170(0xed2);
      FUN_808a180(8, 0);
      FUN_808a098(8, 0x200cec8);
      setActorAnimationIfLoaded(8, 6);
    } else {
      //LAB_200beca
      r5.scale_18.set(0x10000);
      r5._1c.set(0x10000);
      FUN_808a1b8(8, 0x1000, 0);

      if(r6.angle_06.get() >= 0) {
        setActorAnimationIfLoaded(8, 7);
      } else {
        //LAB_200bef6
        setActorAnimationIfLoaded(8, 8);
      }

      //LAB_200befe
      FUN_808a010(20);
      FUN_808a170(0xed1);
      FUN_808a188(8, 0, 20);
      setActorAnimationIfLoaded(8, 1);
      FUN_808a128(8, 4, 0);
      FUN_808a010(80);
      FUN_808a138(8, 2);
      FUN_808a010(40);

      if(r6.angle_06.get() >= 0) {
        setActorAnimationIfLoaded(8, 7);
      } else {
        //LAB_200bf4c
        setActorAnimationIfLoaded(8, 8);
      }

      //LAB_200bf54
      FUN_808a010(2);
      FUN_808a128(8, 2, 0);
      FUN_808a010(60);
      FUN_808a138(8, 2);
      FUN_808a010(20);
      FUN_808a180(8, 0);
      FUN_808a098(8, 0x200cec8);
      setActorAnimationIfLoaded(8, 6);
      setFlag(0x305);
    }

    //LAB_200bf96
    FUN_808a020();
  }

  @Method(0x200bfb0)
  public static void FUN_200bfb0() {
    FUN_808a018();
    FUN_808a210(-1, -1, -1, 0);
    FUN_808a0a8(22);
    clearTickCallback(getRunnable(Map3Overlay_877dd1c.class, "FUN_200c5b8"));
    FUN_808a0d0(0, 480, 1392);
    FUN_808a0f0(0, 0, 0);
    FUN_808a1b8(22, 0x3000, 20);
    getMapActor(22).flags_23.or(0x1);
    FUN_808a0f0(22, 0xf90000, 0x4d80000);
    sleep(1);
    FUN_808a170(0xed3);
    FUN_808a180(0x1016, 0);
    FUN_808a0f0(22, 0xac0000, 0x4fe0000);
    sleep(1);
    FUN_808a208(0x40000, 0x8000);
    FUN_808a210(0xa20000, 0, 0x5050000, 1);
    FUN_808a218();
    FUN_808a010(40);
    setActorAnimationAndWaitUntilFinished(22, 4);
    FUN_808a188(0x1016, 0, 10);
    FUN_808a1b8(22, 0xc000, 20);
    FUN_808a138(22, 2);
    FUN_808a188(0x1016, 0, 10);
    FUN_808a1b8(22, 0x1000, 20);
    setActorAnimationAndWaitUntilFinished(22, 3);
    setActorVelocityScalerAndAcceleration(22, 0x20000, 0x10000);
    FUN_808a0d0(22, 165, 1300);
    FUN_808a0d0(22, 195, 1432);
    setFlag(0x842);
  }

  @Method(0x200c0f0)
  public static void FUN_200c0f0() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r6);
    CPU.push(r5);
    r6 = CPU.r8().value;
    CPU.push(r6);
    CPU.sp().value -= 0x8;
    r2 = 0x6;
    r3 = 0x3;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    CPU.r9().value = r2;
    CPU.r10().value = r3;
    r0 = 0x10;
    r1 = 0x60;
    r2 = 0xb;
    r3 = 0x49;
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = 0xa;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r6 = 0xe;
    CPU.r8().value = r2;
    r0 = 0x10;
    r1 = 0x60;
    r2 = 0x22;
    r3 = 0x44;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r5 = 0x7;
    r0 = 0x10;
    r1 = 0x60;
    r2 = 0x40;
    r3 = 0x44;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = CPU.r9().value;
    r2 = CPU.r10().value;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x9;
    r1 = 0x5f;
    r2 = 0xb;
    r3 = 0x49;
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = CPU.r8().value;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x28;
    r1 = 0x5e;
    r2 = 0x22;
    r3 = 0x44;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    CPU.r8().value = r2;
    r0 = 0x36;
    r1 = 0x5e;
    r2 = 0x40;
    r3 = 0x44;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r5 = 0x1;
    r0 = 0x48;
    r1 = 0x4b;
    r2 = 0x48;
    r3 = 0x4c;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x48;
    r1 = 0x4b;
    r2 = 0x4a;
    r3 = 0x4c;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_8009180(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = CPU.r9().value;
    r3 = 0x4b;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x7;
    r1 = 0x4b;
    r2 = 0x1;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = CPU.r8().value;
    r3 = 0x47;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x8;
    r1 = 0x46;
    r2 = 0x3;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x48;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r6 = 0x9;
    r0 = 0x8;
    r1 = 0x46;
    r2 = 0x2;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r5 = 0x49;
    r0 = 0x8;
    r1 = 0x46;
    r2 = 0x2;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = CPU.r8().value;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xb;
    r1 = 0x42;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0xb;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0xc;
    r1 = 0x42;
    r2 = 0x1;
    r3 = 0x4;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = CPU.r9().value;
    r3 = 0x4a;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x19;
    r1 = 0x0;
    r2 = 0x1;
    r3 = 0x1;
    FUN_80091c0(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    FUN_8009128();
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  /**
   * Event list 0x200d558 handler 40
   */
  @Method(value = 0x200c234, ignoreExtraParams = true)
  public static void FUN_200c234() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_808a018();
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 + 0x40;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 - 0x38;
    r2 = r1 + r3;
    r3 = 0x40;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x87c;
    setFlag(r0);
    r1 = 0x2;
    r0 = 0xc;
    FUN_808a250(r0, r1);
    r0 = 0x90;
    r0 = r0 << 4;
    setFlag(r0);
    FUN_808a020();
  }

  /**
   * Event list 0x200d558 handler 41
   */
  @Method(value = 0x200c278, ignoreExtraParams = true)
  public static void FUN_200c278() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_808a018();
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 + 0x40;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 - 0x38;
    r2 = r1 + r3;
    r3 = 0x40;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x87f;
    setFlag(r0);
    r1 = 0x3;
    r0 = 0xc;
    FUN_808a250(r0, r1);
    r0 = 0x90;
    r0 = r0 << 4;
    setFlag(r0);
    FUN_808a020();
  }

  @Method(0x200c2bc)
  public static void FUN_200c2bc(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0) {
      FUN_8009240(r0, 7);
    } else {
      //LAB_200c2d4
      FUN_8009240(r0, 0);
    }

    //LAB_200c2dc
    if(FUN_200c634(_3001e40.get(), MEMORY.ref(4, 0x200d7fc).get() * 8 + 16) == 0) {
      FUN_200c41c(r0);
    }
  }

  @Method(0x200c41c)
  public static void FUN_200c41c(final Actor70 r0) {
    final int r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    playSound(0x98);
    final Actor70[] r10 = new Actor70[2];

    //LAB_200c442
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 actor = loadActor(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      r10[r7] = actor;
      if(actor != null) {
        actor._14.set(r0._14.get());
        final Sprite38 r5 = actor.sprite_50.derefNullable();
        actor._55.set(0);
        actor._64.set(0);
        actor._68.set(r0);
        if(r5 != null) {
          setSpriteAnimation(r5, 0);
          r5._26.set(0);
          clearVramSlot(r5.slot_1c.get());
          r5.slot_1c.set(MEMORY.ref(2, r11 + 0x46).getUnsigned());
          r5._1d.or(0x1);
          r5.packet_00.attribs_04.flags_01.and(~0x2).and(0x3f).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(vramSlots_3001b10.get(r5.slot_1c.get()).vramAddr_02.get() << 17 >>> 22);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_200c4f0
    }

    final Actor70 r2 = r10[0];
    r2._6c.set(getConsumer(Map3Overlay_877dd1c.class, "FUN_200c3c8", Actor70.class));
    r2.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
    final Actor70 r0_0 = r10[1];
    r0_0.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(r0.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
    r0_0._6c.set(getConsumer(Map3Overlay_877dd1c.class, "FUN_200c378", Actor70.class));
    r0_0.flags_23.set(2);
  }

  @Method(0x200c550)
  public static void FUN_200c550() {
    FUN_808a428(140, 0);
  }

  @Method(0x200c560)
  public static void FUN_200c560() {
    FUN_808a440();
  }

  /**
   * Event list 0x200d558 handler 42
   */
  @Method(value = 0x200c5fc, ignoreExtraParams = true)
  public static void FUN_200c5fc() {
    FUN_808a018();
    FUN_8015040(0xee4, 1);
    FUN_808a020();
  }

  /**
   * Event list 0x200d558 handler 43
   */
  @Method(value = 0x200c618, ignoreExtraParams = true)
  public static void FUN_200c618() {
    FUN_808a018();
    FUN_8015040(0x1120, 1);
    FUN_808a020();
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x200c634)
  public static int FUN_200c634(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200c63c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200c644)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200c64c)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200c654)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#clearVramSlot_} */
  @Method(0x200c664)
  public static int clearVramSlot(final int slot) {
    return (int)MEMORY.call(0x80001b8, slot);
  }

  /** {@link GoldenSun#setSpriteAnimation_} */
  @Method(0x200c66c)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x8009020, sprite, animation);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200c674)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200c684)
  public static void FUN_8009128() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200c68c)
  public static void FUN_8009178(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200c694)
  public static void FUN_8009180(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_8009188} */
  @Method(0x200c69c)
  public static void FUN_8009188(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  /** {@link GoldenSun#FUN_8009190} */
  @Method(0x200c6a4)
  public static void FUN_8009190(final int r0) {
    MEMORY.call(0x8009190, r0);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200c6ac)
  public static void FUN_80091c0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200c6b4)
  public static void FUN_80091e0(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200c6bc)
  public static void FUN_80091f0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f8} */
  @Method(0x200c6c4)
  public static void FUN_80091f8() {
    MEMORY.call(0x80091f8);
  }

  /** {@link GoldenSun#FUN_8009240} */
  @Method(0x200c6cc)
  public static void FUN_8009240(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009240, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200c6d4)
  public static void FUN_8015040(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200c6dc)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200c6e4)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200c6ec)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200c6f4)
  public static void FUN_808a010(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200c6fc)
  public static void FUN_808a018() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200c704)
  public static void FUN_808a020() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a030} */
  @Method(0x200c70c)
  public static void FUN_200c70c(final int r0) {
    MEMORY.call(0x808a030, r0);
  }

  /** {@link GoldenSun_808#FUN_808a048} */
  @Method(0x200c714)
  public static void FUN_200c714(final int charId, final int r1) {
    MEMORY.call(0x808a048, charId, r1);
  }

  /** {@link GoldenSun_808#removeCharAndHealRemainingChars_} */
  @Method(0x200c71c)
  public static void removeCharAndHealRemainingChars(final int charId) {
    MEMORY.call(0x808a058, charId);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200c724)
  public static int FUN_808a070(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200c72c)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a088} */
  @Method(0x200c734)
  public static void FUN_200c734(final int mapActorIndex) {
    MEMORY.call(0x808a088, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200c73c)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200c744)
  public static void FUN_808a098(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x200c74c)
  public static void FUN_808a0a0(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x200c754)
  public static void FUN_808a0a8(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200c75c)
  public static void FUN_808a0b0(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200c764)
  public static void FUN_808a0b8(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200c76c)
  public static void FUN_808a0c0(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200c774)
  public static void FUN_808a0c8(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200c77c)
  public static void FUN_808a0d0(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200c784)
  public static void FUN_808a0e8(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x200c78c)
  public static void FUN_808a0f0(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200c794)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200c79c)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200c7a4)
  public static void FUN_808a128(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200c7ac)
  public static void FUN_808a130(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200c7b4)
  public static void FUN_808a138(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200c7bc)
  public static void FUN_200c7bc(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200c7c4)
  public static void FUN_808a150(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200c7cc)
  public static void FUN_808a158(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200c7d4)
  public static void FUN_808a170(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200c7dc)
  public static Panel24 FUN_808a178(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200c7e4)
  public static void FUN_808a180(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200c7ec)
  public static void FUN_808a188(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x200c7f4)
  public static int FUN_808a190(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200c7fc)
  public static void FUN_808a1b8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200c804)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200c80c)
  public static void FUN_808a1e8(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200c814)
  public static void FUN_808a1f0(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200c81c)
  public static void FUN_808a208(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200c824)
  public static void FUN_808a210(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200c82c)
  public static void FUN_808a218() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a228} */
  @Method(0x200c834)
  public static Actor70 FUN_808a228() {
    return (Actor70)MEMORY.call(0x808a228);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200c83c)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a250} */
  @Method(0x200c844)
  public static void FUN_808a250(final int r0, final int r1) {
    MEMORY.call(0x808a250, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a2c0} */
  @Method(0x200c84c)
  public static void FUN_808a2c0() {
    MEMORY.call(0x808a2c0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x200c854)
  public static void FUN_808a2c8() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d0} */
  @Method(0x200c85c)
  public static void FUN_808a2d0() {
    MEMORY.call(0x808a2d0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x200c864)
  public static void FUN_808a2d8() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x200c86c)
  public static void FUN_808a2e0() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200c874)
  public static void FUN_808a330(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200c87c)
  public static void FUN_808a348(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200c884)
  public static void FUN_808a360() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200c88c)
  public static void FUN_808a370() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x200c894)
  public static void FUN_808a428(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x200c89c)
  public static void FUN_808a440() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x200c8a4)
  public static void FUN_808a5e0(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a5e8} */
  @Method(0x200c8ac)
  public static void FUN_808a5e8() {
    MEMORY.call(0x808a5e8);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200c8b4)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
