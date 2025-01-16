package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80b;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Structccc;
import org.goldensun.weather.LightningStruct1f88;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map7Overlay_8786f0c {
  private Map7Overlay_8786f0c() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x20080cc)
  public static int getRooms() {
    return 0x2009478;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x20080d4)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x20080d8)
  public static int getTransitions() {
    final int r0;
    if(readFlag(0x834) != 0) {
      r0 = 0x2009590;
    } else {
      //LAB_20080e8
      r0 = 0x2009568;
    }

    //LAB_20080ea
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x20080fc)
  public static int getActors() {
    final int r5;
    if(readFlag(0x87a) != 0) {
      r5 = 0x20098b8;
      //LAB_200810c
    } else if(readFlag(0x815) != 0) {
      r5 = 0x2009738;
    } else {
      //LAB_200811a
      r5 = 0x20095b8;
    }

    //LAB_200811c
    FUN_20091ac(r5);
    return r5;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008140)
  public static int getEvents() {
    final int r0;

    if(readFlag(0x834) != 0) {
      r0 = 0x2009ac8;
      //LAB_2008150
    } else if(readFlag(0x87a) != 0) {
      r0 = 0x2009ffc;
      //LAB_200815e
    } else if(readFlag(0x815) != 0) {
      r0 = 0x2009da4;
    } else {
      //LAB_200816c
      r0 = 0x2009c00;
    }

    //LAB_200816e
    return r0;
  }

  /**
   * Event list 0x2009c00 handler 7
   */
  @Method(value = 0x2008190, ignoreExtraParams = true)
  public static void FUN_2008190() {
    FUN_200919c();
    FUN_2009244(0xf6d);
    FUN_2009234(0, 15, 6);
    FUN_2009264(15, 0);
    FUN_20091a4();
  }

  /**
   * Event list 0x2009c00 handler 11
   */
  @Method(value = 0x20081bc, ignoreExtraParams = true)
  public static void FUN_20081bc() {
    FUN_200919c();
    FUN_2009244(0xf73);
    FUN_2009234(0, 19, 6);
    FUN_2009264(19, 0);
    FUN_20091a4();
  }

  @Method(0x20081e8)
  public static void FUN_20081e8() {
    FUN_200919c();

    if(readFlag(0x81b) != 0) {
      FUN_2009244(0x11a6);
      FUN_2009254(20, 0);
      FUN_200923c(20, 0x10000, 33592060);
    } else {
      //LAB_2008214
      FUN_2009244(0x11a4);
      FUN_200925c(20, 0, 20);
      FUN_200917c(0x11a5, 1);
      FUN_20091b4(180, 0);
      setFlag(0x81b);
    }

    //LAB_200823e
    FUN_20091a4();
  }

  /**
   * Event list 0x2009da4 handler 8
   */
  @Method(value = 0x2008258, ignoreExtraParams = true)
  public static void FUN_2008258() {
    FUN_200919c();
    FUN_2009244(0x11be);
    FUN_2009264(16, 0);
    FUN_20091a4();
  }

  /**
   * Event list 0x2009ffc handler 2
   */
  @Method(value = 0x2008278, ignoreExtraParams = true)
  public static void FUN_2008278() {
    FUN_200919c();
    FUN_2009244(0x1c3d);
    FUN_2009264(10, 0);
    FUN_20091a4();
  }

  /**
   * Event list 0x2009ffc handler 3
   */
  @Method(value = 0x2008298, ignoreExtraParams = true)
  public static void FUN_2008298() {
    FUN_200919c();
    FUN_2009244(0x1c40);
    FUN_2009254(0x800b, 0);
    FUN_20091a4();
  }

  @Method(0x20082bc)
  public static void FUN_20082bc(final int r0) {
    if(readFlag(0x834) != 0) {
      FUN_20092bc();
    }

    //LAB_20082ce
    playSound(0x7b);
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x209);
    r1._1c8.set(16);
    FUN_20092dc();
    FUN_20092e4();
    FUN_20092ac(r0);
  }

  /**
   * Event list 0x2009ffc handler 31
   */
  @Method(value = 0x2008308, ignoreExtraParams = true)
  public static void FUN_2008308() {
    FUN_20082bc(1);
  }

  /**
   * Event list 0x2009ffc handler 32
   */
  @Method(value = 0x2008314, ignoreExtraParams = true)
  public static void FUN_2008314() {
    FUN_20082bc(2);
  }

  /**
   * Event list 0x2009ffc handler 33
   */
  @Method(value = 0x2008320, ignoreExtraParams = true)
  public static void FUN_2008320() {
    FUN_20082bc(3);
  }

  /**
   * Event list 0x2009ffc handler 34
   */
  @Method(value = 0x200832c, ignoreExtraParams = true)
  public static void FUN_200832c() {
    FUN_20082bc(4);
  }

  /**
   * Event list 0x2009ffc handler 35
   */
  @Method(value = 0x2008338, ignoreExtraParams = true)
  public static void FUN_2008338() {
    FUN_20082bc(5);
  }

  /**
   * Event list 0x2009ffc handler 36
   */
  @Method(value = 0x2008344, ignoreExtraParams = true)
  public static void FUN_2008344() {
    FUN_20082bc(6);
  }

  /**
   * Event list 0x2009ffc handler 37
   */
  @Method(value = 0x2008350, ignoreExtraParams = true)
  public static void FUN_2008350() {
    FUN_20082bc(7);
  }

  /**
   * Event list 0x2009ffc handler 38
   */
  @Method(value = 0x200835c, ignoreExtraParams = true)
  public static void FUN_200835c() {
    FUN_20082bc(8);
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008368)
  public static int init() {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);

    if(readFlag(0x834) != 0) {
      moveActorToPosition(8, 0, 0);
      moveActorToPosition(9, 0, 0);
      moveActorToPosition(10, 0, 0);
      moveActorToPosition(11, 0, 0);
      moveActorToPosition(12, 0, 0);
      moveActorToPosition(13, 0, 0);
      moveActorToPosition(14, 0, 0);
      moveActorToPosition(15, 0, 0);
      moveActorToPosition(16, 0, 0);
      moveActorToPosition(17, 0, 0);
      moveActorToPosition(18, 0, 0);
      moveActorToPosition(19, 0, 0);
      moveActorToPosition(20, 0, 0);
      moveActorToPosition(21, 0, 0);
      moveActorToPosition(22, 0, 0);
      FUN_20092b4();
      boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).cast(LightningStruct1f88::new).quiet_1f84.set(true);
      FUN_20092c4();
      sleep(30);
      FUN_20092d4();
      FUN_20092e4();
      FUN_20092cc();
    }

    //LAB_200843c
    if(readFlag(0x87a) != 0) {
      if(entranceId_2000402.get() == 6 && readFlag(0x81d) == 0) {
        FUN_2008658();
      }

      //LAB_2008464
      getMapActor(10)._59.or(0x80);
    }

    //LAB_2008474
    if(entranceId_2000402.get() == 2 && readFlag(0x815) != 0) {
      moveActorToPosition(13, 0x1c60000, 0x960000);
      FUN_2009174(getMapActor(13), 0);
      setActorAnimationIfLoaded(13, 5);
      FUN_200916c(4);
    }

    //LAB_20084b6
    return 0;
  }

  /**
   * Event list 0x2009ffc handler 12
   */
  @Method(value = 0x20084dc, ignoreExtraParams = true)
  public static void FUN_20084dc() {
    if((getMapActor(0).angle_06.get() & 0xffff) >= 0xa001 && (getMapActor(0).angle_06.get() & 0xffff) < 0xe000) {
      FUN_20092ec(1, 21);
    } else {
      //LAB_20084fa
      FUN_200919c();

      if(readFlag(0x87a) != 0) {
        FUN_2009244(0x1c06);
        FUN_2009264(21, 0);
      } else {
        //LAB_2008518
        if(readFlag(0x815) != 0) {
          FUN_2009244(0x11a2);
        } else {
          //LAB_200852a
          FUN_2009244(0xf53);
        }

        //LAB_2008530
        FUN_2009254(21, 0);
      }

      //LAB_2008538
      FUN_20091a4();
    }
  }

  /**
   * Event list 0x2009ffc handler 13
   */
  @Method(value = 0x200855c, ignoreExtraParams = true)
  public static void FUN_200855c() {
    if((getMapActor(0).angle_06.get() & 0xffff) >= 0xa001 && (getMapActor(0).angle_06.get() & 0xffff) < 0xe000) {
      FUN_20092ec(2, 22);
    } else {
      //LAB_200857a
      FUN_200919c();

      if(readFlag(0x87a) != 0) {
        FUN_2009244(0x1c09);
        //LAB_2008590
      } else if(readFlag(0x815) != 0) {
        FUN_2009244(0x11a3);
      } else {
        //LAB_20085a2
        FUN_2009244(0xf54);
      }

      //LAB_20085a8
      FUN_2009254(22, 0);
      FUN_20091a4();
    }
  }

  /**
   * Event list 0x2009ffc handler 14
   */
  @Method(value = 0x20085d4, ignoreExtraParams = true)
  public static void FUN_20085d4() {
    if((getMapActor(0).angle_06.get() & 0xffff) >= 0xa001 && (getMapActor(0).angle_06.get() & 0xffff) < 0xe000) {
      FUN_20092ec(3, 20);
      //LAB_20085f2
    } else if(readFlag(0x87a) != 0) {
      FUN_200919c();
      FUN_2009244(0x1c0a);
      FUN_2009254(20, 0);
      FUN_20091a4();
      //LAB_2008614
    } else if(readFlag(0x815) != 0) {
      FUN_20081e8();
    } else {
      //LAB_2008624
      FUN_200919c();
      FUN_2009244(0xf55);
      FUN_2009254(20, 0);
      FUN_20091a4();
    }
  }

  @Method(0x2008658)
  public static void FUN_2008658() {
    FUN_200919c();
    FUN_2009294(-1, -1, -1, 0);
    sleep(1);
    setActorPriority(3, 1);
    setActorVelocityScalerAndAcceleration(0, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(1, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(2, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(3, 0x6666, 0x3333);
    setActorAnimationIfLoaded(8, 5);
    FUN_20091ec(0, 808, 508);
    FUN_2009174(getMapActor(23), 0);
    FUN_2009174(getMapActor(24), 0);
    FUN_2009174(getMapActor(25), 0);
    getMapActor(23)._55.set(0);
    getMapActor(24)._55.set(0);
    getMapActor(25)._55.set(0);
    setTickCallback(getRunnable(Map7Overlay_8786f0c.class, "FUN_20090c0"), 0xc80);
    sleep(1);
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r3._1c8.set(32);
    FUN_20092d4();
    FUN_20092e4();
    FUN_20091fc(0);
    setActorAnimationIfLoaded(0, 1);

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      moveActorToPosition(1, r0.pos_08.getX(), r0.pos_08.getZ());
      moveActorToPosition(2, r0.pos_08.getX(), r0.pos_08.getZ());
      moveActorToPosition(3, r0.pos_08.getX(), r0.pos_08.getZ());
    }

    //LAB_200877a
    FUN_20091ec(1, 792, 512);
    FUN_20091ec(2, 824, 504);
    FUN_20091f4(3, 818, 524);
    setActorAnimationIfLoaded(1, 1);
    setActorAnimationIfLoaded(2, 1);
    FUN_2009194(10);
    FUN_200923c(0, 0x1000a, 0x20092fc);
    FUN_200923c(1, 0x1000a, 0x20092fc);
    FUN_200923c(2, 0x1000a, 0x20092fc);
    FUN_200923c(3, 0x1000a, 0x20092fc);
    FUN_2009194(300);
    FUN_20092a4()._55.set(0);
    FUN_200928c(0x1999, 0x333);
    FUN_2009294(0x3120000, 0, 0x1ae0000, 1);
    FUN_2009194(240);
    FUN_20091dc(10);
    FUN_2009284(10, 0x102, 80);
    FUN_20091f4(10, 819, 405);
    FUN_2009194(40);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_2009194(40);
    FUN_200926c(10, 0xd000, 20);
    FUN_2009244(0x1c1e);
    FUN_200925c(0x900a, 0, 20);
    FUN_20091dc(0);
    FUN_20091dc(1);
    FUN_20091dc(2);
    FUN_20091dc(3);
    FUN_2009284(11, 0x100, 40);
    FUN_200925c(0x200b, 0, 20);
    FUN_200922c(10, 2);
    FUN_2009194(40);
    FUN_200925c(0x900a, 0, 10);
    FUN_200926c(11, 0x5000, 10);
    FUN_200925c(0x200b, 0, 40);
    FUN_200922c(10, 2);
    FUN_2009194(20);
    FUN_200925c(0x900a, 0, 20);
    FUN_2009284(0, 0x102, 80);
    FUN_2009284(11, 0x106, 40);
    FUN_200925c(0x200b, 0, 40);
    FUN_2009224(10, 2);
    FUN_2009284(10, 0x102, 20);
    setActorAnimationIfLoaded(10, 4);
    FUN_200925c(0x900a, 0, 10);
    FUN_2009224(11, 1);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_2009194(20);
    FUN_2009224(10, 1);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_2009224(11, 1);
    setActorAnimationAndWaitUntilFinished(11, 3);
    FUN_2009224(10, 1);
    setActorAnimationAndWaitUntilFinished(10, 4);
    FUN_2009284(9, 0x105, 0);
    FUN_200922c(9, 1);
    FUN_2009194(20);
    FUN_200926c(9, 0x1000, 40);
    FUN_200922c(9, 2);
    FUN_2009194(60);
    FUN_200922c(9, 3);
    FUN_2009194(40);
    FUN_200925c(0x4009, 0, 40);
    setActorAnimationIfLoaded(11, 0);
    FUN_200922c(11, 2);
    FUN_200925c(0x200b, 0, 10);
    setActorAnimationAndWaitUntilFinished(9, 4);
    FUN_200922c(9, 2);
    FUN_200925c(0x4009, 0, 10);
    FUN_2009284(10, 0x100, 20);
    FUN_200926c(10, 0x5000, 40);
    setActorAnimationAndWaitUntilFinished(10, 3);
    FUN_200925c(0x400a, 0, 10);
    setActorAnimationAndWaitUntilFinished(9, 4);
    FUN_200926c(9, 0xd000, 10);
    FUN_200921c(9, 2, 0);
    setActorAnimationIfLoaded(9, 4);
    FUN_200925c(0x4009, 0, 10);
    FUN_2009284(11, 0x101, 0);
    FUN_2009284(10, 0x101, 40);
    FUN_200926c(10, 0xd000, 80);
    FUN_200926c(10, 0x5000, 60);
    FUN_2009224(10, 2);
    FUN_2009224(11, 2);
    FUN_2009274(10, 11, 6, 6, 6, 11, 12, 1, 7, 1);
    FUN_2009194(20);
    FUN_200928c(0x19999, 0x3333);
    FUN_2009294(0x3090000, 0, 0x1d40000, 1);
    FUN_200929c();
    FUN_2009194(40);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200925c(0x1001, 0, 20);
    FUN_200922c(8, 2);
    clearTickCallback(getRunnable(Map7Overlay_8786f0c.class, "FUN_20090c0"));
    FUN_2009194(40);
    setActorAnimationAndWaitUntilFinished(8, 6);
    FUN_2009194(20);
    FUN_200925c(0x4008, 0, 20);
    FUN_2009294(0x2ee0000, 0, 0x1c30000, 1);
    FUN_2009194(20);
    FUN_200926c(11, 0x5000, 0);
    FUN_200926c(10, 0x5000, 10);
    FUN_200926c(8, 0x1000, 40);
    FUN_2009284(8, 0x100, 40);
    FUN_200926c(8, 0x3000, 20);
    FUN_200926c(8, 0x1000, 20);
    FUN_200926c(8, 0x3000, 40);
    setActorAnimationAndWaitUntilFinished(8, 6);
    FUN_2009194(60);
    FUN_200921c(8, 6, 0);
    FUN_200925c(0x4008, 0, 20);
    setActorVelocityScalerAndAcceleration(1, 0x19999, 0xcccc);
    FUN_20091f4(1, 789, 473);
    FUN_200926c(1, 0x7000, 20);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200925c(0x4001, 0, 10);
    FUN_200926c(8, 0x1000, 20);
    setActorAnimationAndWaitUntilFinished(8, 3);
    FUN_200924c(0x4008);
    FUN_200926c(10, 0x5000, 0);
    FUN_200926c(9, 0x1000, 0);
    FUN_200926c(1, 0x3000, 0);
    FUN_200926c(2, 0x7000, 0);
    FUN_200926c(3, 0xb000, 0);

    if(FUN_20091bc(0, 0) == 1) {
      r3._1d8.incr();
    }

    //LAB_2008c6c
    FUN_2009294(0x3090000, 0, 0x1ac0000, 1);
    FUN_2009194(20);
    FUN_200922c(10, 2);
    FUN_2009254(10, 0);
    setActorAnimationAndWaitUntilFinished(11, 4);
    FUN_2009194(20);
    FUN_2009244(0x1c33);
    FUN_2009254(0x200b, 0);
    FUN_2009294(0x3090000, 0, 0x1d40000, 1);
    FUN_2009194(20);
    FUN_200926c(1, 0xd000, 20);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_2009194(20);
    setActorAnimationAndWaitUntilFinished(9, 4);
    FUN_200926c(9, 0xd000, 10);
    FUN_2009254(0x4009, 0);
    setActorAnimationAndWaitUntilFinished(8, 3);
    FUN_2009254(0x4008, 0);
    FUN_200926c(1, 0x7000, 10);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200926c(9, 0x1000, 10);
    setActorAnimationIfLoaded(11, 3);
    setActorAnimationIfLoaded(10, 3);
    setActorAnimationIfLoaded(9, 3);
    setActorAnimationAndWaitUntilFinished(8, 3);
    FUN_2009194(20);
    FUN_200926c(1, 0x3000, 20);
    FUN_2009284(1, 0x102, 80);
    FUN_200926c(1, 0x7000, 20);
    FUN_200925c(0x4001, 0, 20);
    FUN_200926c(1, 0x3000, 10);
    FUN_200926c(0, 0, 40);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_2009194(20);
    FUN_200926c(0, 0x4000, 20);
    setActorAnimationAndWaitUntilFinished(3, 3);
    FUN_2009194(20);
    FUN_200926c(1, 0x1000, 0);
    FUN_200926c(0, 0xe000, 0);
    setActorVelocityScalerAndAcceleration(2, 0x10000, 0x8000);
    FUN_20091f4(2, 819, 489);
    FUN_200926c(2, 0xb000, 40);
    FUN_200922c(2, 2);
    FUN_200925c(2, 0, 20);
    setActorAnimationAndWaitUntilFinished(2, 3);
    setActorAnimationIfLoaded(8, 3);
    setActorAnimationIfLoaded(9, 3);
    setActorAnimationIfLoaded(10, 3);
    setActorAnimationAndWaitUntilFinished(9, 3);
    getMapActor(3).flags_23.and(~0x1);
    setActorPriority(3, 1);
    setActorVelocityScalerAndAcceleration(3, 0x10000, 0x8000);
    FUN_20091f4(3, 794, 520);
    FUN_200926c(1, 0x5000, 0);
    FUN_200926c(0, 0xa000, 0);
    FUN_20091f4(3, 784, 496);
    FUN_200926c(3, 0x9000, 10);
    getMapActor(3).flags_23.or(0x1);
    FUN_200925c(3, 0, 20);
    setActorAnimationIfLoaded(8, 3);
    setActorAnimationIfLoaded(9, 3);
    setActorAnimationIfLoaded(10, 3);
    setActorAnimationAndWaitUntilFinished(9, 3);
    FUN_2009194(20);
    FUN_2009294(0x3090000, 0, 0x1ac0000, 1);
    FUN_2009194(20);
    setActorVelocityScalerAndAcceleration(11, 0x6666, 0x3333);
    FUN_20091f4(11, 835, 388);
    FUN_200926c(11, 0x5000, 0);
    FUN_2009284(11, 0x108, 40);
    FUN_200925c(0x200b, 0, 20);
    FUN_2009294(0x3090000, 0, 0x1d40000, 1);
    FUN_2009194(40);
    FUN_200926c(2, 0x7000, 0);
    FUN_200926c(3, 0xf000, 40);
    FUN_200926c(2, 0x9000, 0);
    FUN_200926c(3, 0xd000, 20);
    setActorAnimationIfLoaded(2, 3);
    setActorAnimationAndWaitUntilFinished(3, 3);
    FUN_2009194(20);
    FUN_200922c(10, 1);
    FUN_2009194(20);
    setActorAnimationIfLoaded(10, 3);
    FUN_200925c(10, 0, 20);
    FUN_200926c(0, 0xc000, 0);
    FUN_200926c(1, 0xd000, 0);
    FUN_200926c(2, 0xb000, 0);
    FUN_200926c(3, 0xd000, 40);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationIfLoaded(1, 3);
    setActorAnimationIfLoaded(2, 3);
    setActorAnimationAndWaitUntilFinished(3, 3);
    FUN_2009194(20);
    setActorVelocityScalerAndAcceleration(2, 0x10000, 0x8000);
    FUN_20091d4(1, 0x2009400);
    FUN_20091d4(2, 0x2009400);
    FUN_20091e4(3, 0x2009400);
    FUN_20091d4(10, 0x2009310);
    FUN_20091f4(11, 837, 376);
    FUN_200926c(11, 0xd000, 20);
    setFlag(0x81d);
    FUN_20091a4();
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200914c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x2009154)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200915c)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#FUN_8009188} */
  @Method(0x200916c)
  public static void FUN_200916c(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x2009174)
  public static void FUN_2009174(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200917c)
  public static void FUN_200917c(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x2009184)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200918c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x2009194)
  public static void FUN_2009194(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200919c)
  public static void FUN_200919c() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x20091a4)
  public static void FUN_20091a4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a038} */
  @Method(0x20091ac)
  public static void FUN_20091ac(final int r0) {
    MEMORY.call(0x808a038, r0);
  }

  /** {@link GoldenSun_808#FUN_808a060} */
  @Method(0x20091b4)
  public static int FUN_20091b4(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a060, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x20091bc)
  public static int FUN_20091bc(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x20091c4)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x20091cc)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x20091d4)
  public static void FUN_20091d4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x20091dc)
  public static void FUN_20091dc(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x20091e4)
  public static void FUN_20091e4(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x20091ec)
  public static void FUN_20091ec(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x20091f4)
  public static void FUN_20091f4(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x20091fc)
  public static void FUN_20091fc(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x2009204)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200920c)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x2009214)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200921c)
  public static void FUN_200921c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2009224)
  public static void FUN_2009224(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200922c)
  public static void FUN_200922c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x2009234)
  public static void FUN_2009234(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a168} */
  @Method(0x200923c)
  public static void FUN_200923c(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    MEMORY.call(0x808a168, mapActorIndex1, mapActorIndex2AndFlags, r2);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x2009244)
  public static void FUN_2009244(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200924c)
  public static Panel24 FUN_200924c(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x2009254)
  public static void FUN_2009254(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200925c)
  public static void FUN_200925c(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x2009264)
  public static int FUN_2009264(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200926c)
  public static void FUN_200926c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1d0} */
  @Method(0x2009274)
  public static void FUN_2009274(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    MEMORY.call(0x808a1d0, r0, r1, r2, r3, a4, a5, a6, a7, a8, a9);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200927c)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2009284)
  public static void FUN_2009284(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200928c)
  public static void FUN_200928c(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2009294)
  public static void FUN_2009294(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200929c)
  public static void FUN_200929c() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a228} */
  @Method(0x20092a4)
  public static Actor70 FUN_20092a4() {
    return (Actor70)MEMORY.call(0x808a228);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x20092ac)
  public static void FUN_20092ac(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x20092b4)
  public static void FUN_20092b4() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d0} */
  @Method(0x20092bc)
  public static void FUN_20092bc() {
    MEMORY.call(0x808a2d0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x20092c4)
  public static void FUN_20092c4() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x20092cc)
  public static void FUN_20092cc() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x20092d4)
  public static void FUN_20092d4() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x20092dc)
  public static void FUN_20092dc() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x20092e4)
  public static void FUN_20092e4() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_80b#FUN_80b0008} */
  @Method(0x20092ec)
  public static int FUN_20092ec(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b0008, r0, r1);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x20092f4)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
