package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Structccc;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map7Overlay_8786f0c {
  private Map7Overlay_8786f0c() { }

  /** {@link GoldenSunVars#getRooms_200800c} */
  @Method(0x20080cc)
  public static int getRooms() {
    return 0x2009478;
  }

  /** {@link GoldenSunVars#getLadders_200802c} */
  @Method(0x20080d4)
  public static int getLadders() {
    return 0;
  }

  /** {@link GoldenSunVars#getTransitions_2008014} */
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

  /** {@link GoldenSunVars#getActors_200801c} */
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

  /** {@link GoldenSunVars#getEvents_2008024} */
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

  /** {@link GoldenSunVars#init_2008004} */
  @Method(0x2008368)
  public static void init() {
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);

    if(readFlag(0x834) != 0) {
      FUN_2009204(0x8, 0, 0);
      FUN_2009204(0x9, 0, 0);
      FUN_2009204(0xa, 0, 0);
      FUN_2009204(0xb, 0, 0);
      FUN_2009204(0xc, 0, 0);
      FUN_2009204(0xd, 0, 0);
      FUN_2009204(0xe, 0, 0);
      FUN_2009204(0xf, 0, 0);
      FUN_2009204(0x10, 0, 0);
      FUN_2009204(0x11, 0, 0);
      FUN_2009204(0x12, 0, 0);
      FUN_2009204(0x13, 0, 0);
      FUN_2009204(0x14, 0, 0);
      FUN_2009204(0x15, 0, 0);
      FUN_2009204(0x16, 0, 0);
      FUN_20092b4();
      boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
      FUN_20092c4();
      sleep(0x1e);
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
      getMapActor(0xa)._59.or(0x80);
    }

    //LAB_2008474
    if(entranceId_2000402.get() == 2 && readFlag(0x815) != 0) {
      FUN_2009204(0xd, 0x12c0000, 0x960000);
      FUN_2009174(getMapActor(0xd), 0);
      setActorAnimationIfLoaded(0xd, 0x5);
      FUN_200916c(0x4);
    }

    //LAB_20084b6
  }

  @Method(0x2008658)
  public static void FUN_2008658() {
    FUN_200919c();
    FUN_2009294(-1, -1, -1, 0);
    sleep(0x1);
    setActorPriority(0x3, 0x1);
    setActorVelocityScalerAndAcceleration(0, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(0x1, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(0x2, 0x6666, 0x3333);
    setActorVelocityScalerAndAcceleration(0x3, 0x6666, 0x3333);
    setActorAnimationIfLoaded(0x8, 0x5);
    FUN_20091ec(0, 0x328, 0x1fc);
    FUN_2009174(getMapActor(0x17), 0);
    FUN_2009174(getMapActor(0x18), 0);
    FUN_2009174(getMapActor(0x19), 0);
    getMapActor(0x17)._55.set(0);
    getMapActor(0x18)._55.set(0);
    getMapActor(0x19)._55.set(0);
    setTickCallback(getRunnable(Map7Overlay_8786f0c.class, "FUN_20090c0"), 0xc80);
    sleep(0x1);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c8.set(0x20);
    FUN_20092d4();
    FUN_20092e4();
    FUN_20091fc(0);
    setActorAnimationIfLoaded(0, 1);

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_2009204(0x1, r0.pos_08.getX(), r0.pos_08.getZ());
      FUN_2009204(0x2, r0.pos_08.getX(), r0.pos_08.getZ());
      FUN_2009204(0x3, r0.pos_08.getX(), r0.pos_08.getZ());
    }

    //LAB_200877a
    FUN_20091ec(0x1, 0x318, 0x200);
    FUN_20091ec(0x2, 0x338, 0x1f8);
    FUN_20091f4(0x3, 0x332, 0x20c);
    setActorAnimationIfLoaded(0x1, 0x1);
    setActorAnimationIfLoaded(0x2, 0x1);
    FUN_2009194(0xa);
    FUN_200923c(0, 0x1000a, 0x20092fc);
    FUN_200923c(0x1, 0x1000a, 0x20092fc);
    FUN_200923c(0x2, 0x1000a, 0x20092fc);
    FUN_200923c(0x3, 0x1000a, 0x20092fc);
    FUN_2009194(0x12c);
    FUN_20092a4()._55.set(0);
    FUN_200928c(0x1999, 0x333);
    FUN_2009294(0x3120000, 0, 0x1ae0000, 0x1);
    FUN_2009194(0xf0);
    FUN_20091dc(0xa);
    FUN_2009284(0xa, 0x102, 0x50);
    FUN_20091f4(0xa, 0x333, 0x195);
    FUN_2009194(0x28);
    setActorAnimationAndWaitUntilFinished(0xa, 0x4);
    FUN_2009194(0x28);
    FUN_200926c(0xa, 0xd000, 0x14);
    FUN_2009244(0x1c1e);
    FUN_200925c(0x900a, 0, 0x14);
    FUN_20091dc(0);
    FUN_20091dc(1);
    FUN_20091dc(2);
    FUN_20091dc(3);
    FUN_2009284(0xb, 0x100, 0x28);
    FUN_200925c(0x200b, 0, 0x14);
    FUN_200922c(0xa, 0x2);
    FUN_2009194(0x28);
    FUN_200925c(0x900a, 0, 0xa);
    FUN_200926c(0xb, 0x5000, 0xa);
    FUN_200925c(0x200B, 0, 0x28);
    FUN_200922c(0xa, 0x2);
    FUN_2009194(0x14);
    FUN_200925c(0x900a, 0, 0x14);
    FUN_2009284(0, 0x102, 0x50);
    FUN_2009284(0xb, 0x106, 0x28);
    FUN_200925c(0x200b, 0, 0x28);
    FUN_2009224(0xa, 0x2);
    FUN_2009284(0xa, 0x102, 0x14);
    setActorAnimationIfLoaded(0xa, 0x4);
    FUN_200925c(0x900a, 0, 0xa);
    FUN_2009224(0xb, 0x1);
    setActorAnimationAndWaitUntilFinished(0xb, 0x3);
    FUN_2009194(0x14);
    FUN_2009224(0xa, 0x1);
    setActorAnimationAndWaitUntilFinished(0xa, 0x4);
    FUN_2009224(0xb, 0x1);
    setActorAnimationAndWaitUntilFinished(0xb, 0x3);
    FUN_2009224(0xa, 0x1);
    setActorAnimationAndWaitUntilFinished(0xa, 0x4);
    FUN_2009284(0x9, 0x105, 0);
    FUN_200922c(0x9, 0x1);
    FUN_2009194(0x14);
    FUN_200926c(0x9, 0x1000, 0x28);
    FUN_200922c(0x9, 0x2);
    FUN_2009194(0x3c);
    FUN_200922c(0x9, 0x3);
    FUN_2009194(0x28);
    FUN_200925c(0x4009, 0, 0x28);
    setActorAnimationIfLoaded(0xb, 0);
    FUN_200922c(0xb, 0x2);
    FUN_200925c(0x200b, 0, 0xa);
    setActorAnimationAndWaitUntilFinished(0x9, 0x4);
    FUN_200922c(0x9, 0x2);
    FUN_200925c(0x4009, 0, 0xa);
    FUN_2009284(0xa, 0x100, 0x14);
    FUN_200926c(0xa, 0x5000, 0x28);
    setActorAnimationAndWaitUntilFinished(0xa, 0x3);
    FUN_200925c(0x400a, 0, 0xa);
    setActorAnimationAndWaitUntilFinished(0x9, 0x4);
    FUN_200926c(0x9, 0xd000, 0xa);
    FUN_200921c(0x9, 0x2, 0);
    setActorAnimationIfLoaded(0x9, 0x4);
    FUN_200925c(0x4009, 0, 0xa);
    FUN_2009284(0xb, 0x101, 0);
    FUN_2009284(0xa, 0x101, 0x28);
    FUN_200926c(0xa, 0xd000, 0x50);
    FUN_200926c(0xa, 0x5000, 0x3c);
    FUN_2009224(0xa, 0x2);
    FUN_2009224(0xb, 0x2);
    FUN_2009274(0xa, 0xb, 0x6, 0x6, 0x6, 0xb, 0xc, 0x1, 0x7, 0x1);
    FUN_2009194(0x14);
    FUN_200928c(0x19999, 0x3333);
    FUN_2009294(0x3090000, 0, 0x1d40000, 0x1);
    FUN_200929c();
    FUN_2009194(0x28);
    setActorAnimationAndWaitUntilFinished(0x1, 0x3);
    FUN_200925c(0x1001, 0, 0x14);
    FUN_200922c(0x8, 0x2);
    clearTickCallback(getRunnable(Map7Overlay_8786f0c.class, "FUN_20090c0"));
    FUN_2009194(0x28);
    setActorAnimationAndWaitUntilFinished(0x8, 0x6);
    FUN_2009194(0x14);
    FUN_200925c(0x4008, 0, 0x14);
    FUN_2009294(0x2ee0000, 0, 0x1c30000, 0x1);
    FUN_2009194(0x14);
    FUN_200926c(0xb, 0x5000, 0);
    FUN_200926c(0xa, 0x5000, 0xa);
    FUN_200926c(0x8, 0x1000, 0x28);
    FUN_2009284(0x8, 0x100, 0x28);
    FUN_200926c(0x8, 0x3000, 0x14);
    FUN_200926c(0x8, 0x1000, 0x14);
    FUN_200926c(0x8, 0x3000, 0x28);
    setActorAnimationAndWaitUntilFinished(0x8, 0x6);
    FUN_2009194(0x3c);
    FUN_200921c(0x8, 0x6, 0);
    FUN_200925c(0x4008, 0, 0x14);
    setActorVelocityScalerAndAcceleration(0x1, 0x19999, 0xcccc);
    FUN_20091f4(0x1, 0x315, 0x1d9);
    FUN_200926c(0x1, 0x7000, 0x14);
    setActorAnimationAndWaitUntilFinished(0x1, 0x3);
    FUN_200925c(0x4001, 0, 0xa);
    FUN_200926c(0x8, 0x1000, 0x14);
    setActorAnimationAndWaitUntilFinished(0x8, 0x3);
    FUN_200924c(0x4008);
    FUN_200926c(0xa, 0x5000, 0);
    FUN_200926c(0x9, 0x1000, 0);
    FUN_200926c(0x1, 0x3000, 0);
    FUN_200926c(0x2, 0x7000, 0);
    FUN_200926c(0x3, 0xb000, 0);

    if(FUN_20091bc(0, 0) == 1) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    }

    //LAB_2008c6c
    FUN_2009294(0x3090000, 0, 0x1ac0000, 0x1);
    FUN_2009194(0x14);
    FUN_200922c(0xa, 0x2);
    FUN_2009254(0xa, 0);
    setActorAnimationAndWaitUntilFinished(0xb, 0x4);
    FUN_2009194(0x14);
    FUN_2009244(0x1c33);
    FUN_2009254(0x200b, 0);
    FUN_2009294(0x3090000, 0, 0x1d40000, 0x1);
    FUN_2009194(0x14);
    FUN_200926c(0x1, 0xd000, 0x14);
    setActorAnimationAndWaitUntilFinished(0x1, 0x3);
    FUN_2009194(0x14);
    setActorAnimationAndWaitUntilFinished(0x9, 0x4);
    FUN_200926c(0x9, 0xd000, 0xa);
    FUN_2009254(0x4009, 0);
    setActorAnimationAndWaitUntilFinished(0x8, 0x3);
    FUN_2009254(0x4008, 0);
    FUN_200926c(0x1, 0x7000, 0xa);
    setActorAnimationAndWaitUntilFinished(0x1, 0x3);
    FUN_200926c(0x9, 0x1000, 0xa);
    setActorAnimationIfLoaded(0xb, 0x3);
    setActorAnimationIfLoaded(0xa, 0x3);
    setActorAnimationIfLoaded(0x9, 0x3);
    setActorAnimationAndWaitUntilFinished(0x8, 0x3);
    FUN_2009194(0x14);
    FUN_200926c(0x1, 0x3000, 0x14);
    FUN_2009284(0x1, 0x102, 0x50);
    FUN_200926c(0x1, 0x7000, 0x14);
    FUN_200925c(0x4001, 0, 0x14);
    FUN_200926c(0x1, 0x3000, 0xa);
    FUN_200926c(0, 0, 0x28);
    setActorAnimationIfLoaded(0, 0x3);
    setActorAnimationAndWaitUntilFinished(0x1, 0x3);
    FUN_2009194(0x14);
    FUN_200926c(0, 0x4000, 0x14);
    setActorAnimationAndWaitUntilFinished(0x3, 0x3);
    FUN_2009194(0x14);
    FUN_200926c(0x1, 0x1000, 0);
    FUN_200926c(0, 0xe000, 0);
    setActorVelocityScalerAndAcceleration(0x2, 0x10000, 0x8000);
    FUN_20091f4(0x2, 0x333, 0x1e9);
    FUN_200926c(0x2, 0xb000, 0x28);
    FUN_200922c(0x2, 0x2);
    FUN_200925c(0x2, 0, 0x14);
    setActorAnimationAndWaitUntilFinished(0x2, 0x3);
    setActorAnimationIfLoaded(0x8, 0x3);
    setActorAnimationIfLoaded(0x9, 0x3);
    setActorAnimationIfLoaded(0xa, 0x3);
    setActorAnimationAndWaitUntilFinished(0x9, 0x3);
    getMapActor(0x3).flags_23.and(~0x1);
    setActorPriority(0x3, 0x1);
    setActorVelocityScalerAndAcceleration(0x3, 0x10000, 0x8000);
    FUN_20091f4(0x3, 0x31a, 0x208);
    FUN_200926c(0x1, 0x5000, 0);
    FUN_200926c(0, 0xa000, 0);
    FUN_20091f4(0x3, 0x310, 0x1f0);
    FUN_200926c(0x3, 0x9000, 0xa);
    getMapActor(0x3).flags_23.or(0x1);
    FUN_200925c(0x3, 0, 0x14);
    setActorAnimationIfLoaded(0x8, 0x3);
    setActorAnimationIfLoaded(0x9, 0x3);
    setActorAnimationIfLoaded(0xa, 0x3);
    setActorAnimationAndWaitUntilFinished(0x9, 0x3);
    FUN_2009194(0x14);
    FUN_2009294(0x3090000, 0, 0x1ac0000, 0x1);
    FUN_2009194(0x14);
    setActorVelocityScalerAndAcceleration(0xb, 0x6666, 0x3333);
    FUN_20091f4(0xb, 0x343, 0x184);
    FUN_200926c(0xb, 0x5000, 0);
    FUN_2009284(0xb, 0x108, 0x28);
    FUN_200925c(0x200b, 0, 0x14);
    FUN_2009294(0x3090000, 0, 0x1d40000, 0x1);
    FUN_2009194(0x28);
    FUN_200926c(0x2, 0x7000, 0);
    FUN_200926c(0x3, 0xf000, 0x28);
    FUN_200926c(0x2, 0x9000, 0);
    FUN_200926c(0x3, 0xd000, 0x14);
    setActorAnimationIfLoaded(0x2, 0x3);
    setActorAnimationAndWaitUntilFinished(0x3, 0x3);
    FUN_2009194(0x14);
    FUN_200922c(0xa, 0x1);
    FUN_2009194(0x14);
    setActorAnimationIfLoaded(0xa, 0x3);
    FUN_200925c(0xa, 0, 0x14);
    FUN_200926c(0, 0xc000, 0);
    FUN_200926c(0x1, 0xd000, 0);
    FUN_200926c(0x2, 0xb000, 0);
    FUN_200926c(0x3, 0xd000, 0x28);
    setActorAnimationIfLoaded(0, 0x3);
    setActorAnimationIfLoaded(0x1, 0x3);
    setActorAnimationIfLoaded(0x2, 0x3);
    setActorAnimationAndWaitUntilFinished(0x3, 0x3);
    FUN_2009194(0x14);
    setActorVelocityScalerAndAcceleration(0x2, 0x10000, 0x8000);
    FUN_20091d4(0x1, 0x2009400);
    FUN_20091d4(0x2, 0x2009400);
    FUN_20091e4(0x3, 0x2009400);
    FUN_20091d4(0xa, 0x2009310);
    FUN_20091f4(0xb, 0x345, 0x178);
    FUN_200926c(0xb, 0xd000, 0x14);
    setFlag(0x81d);
    FUN_20091a4();
  }

  @Method(0x20090c0)
  public static void FUN_20090c0() {
    final int r0 = FUN_2009144(_3001e40.get(), 0xb4);
    final int r6;
    if(r0 == 0) {
      //LAB_20090e2
      r6 = 0x18;
      //LAB_20090dc
    } else if(r0 == 10 || r0 == 30) {
      //LAB_20090e6
      r6 = 0x19;
    } else {
      return;
    }

    //LAB_20090e8
    final Actor70 actor1 = getMapActor(r6);
    if(actor1 != null) {
      final Actor70 actor2 = getMapActor(0x8);
      if(actor2 != null) {
        FUN_2009204(r6, actor2.pos_08.getX(), actor2.pos_08.getZ());
      }

      //LAB_2009108
      actor1._18.set(0x6666);
      actor1._1c.set(0x6666);
      actor1.pos_08.y_04.add(0x180000);
      actor1.dest_38.setY(actor1.pos_08.getY());
      actor1._64.set(0x19);
      actor1._66.set(0x80);
      FUN_20091d4(r6, 0x2009440);
    }

    //LAB_2009130
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x2009144)
  public static int FUN_2009144(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200914c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x2009154)
  public static void setTickCallback(@Nullable final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200915c)
  public static void clearTickCallback(final RunnableRef r0) {
    MEMORY.call(0x80000d8, r0);
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
  public static void FUN_20091ec(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x20091f4)
  public static void FUN_20091f4(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0d0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x20091fc)
  public static void FUN_20091fc(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x2009204)
  public static void FUN_2009204(final int mapActorIndex, final int x, final int z) {
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
  public static void FUN_200924c(final int r0) {
    MEMORY.call(0x808a178, r0);
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

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x20092b4)
  public static void FUN_20092b4() {
    MEMORY.call(0x808a2c8);
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

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x20092e4)
  public static void FUN_20092e4() {
    MEMORY.call(0x808a370);
  }
}
