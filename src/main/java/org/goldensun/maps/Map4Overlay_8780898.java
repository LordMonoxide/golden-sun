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
import org.goldensun.types.Map194;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;
import org.goldensun.types.Vec3;
import org.goldensun.types.VramSlot04;

import javax.annotation.Nullable;

import static org.goldensun.CopiedSegment8000770.FUN_30003e0;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.clearActor;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map4Overlay_8780898 {
  private Map4Overlay_8780898() { }

  @Method(0x200806c)
  public static Actor70 FUN_200806c(final Vec3 r0) {
    final Structccc r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_2008080
    for(int r5 = 8; r5 < 66; r5++) {
      //BUGFIX: NPE
      final Actor70 actor = r2.actors_14.get(r5).derefNullable();
      if(actor != null && r0.getX() >> 20 == actor.pos_08.getX() >> 20 && r0.getY() / 0x10000 == actor.pos_08.getY() / 0x10000 && r0.getZ() >> 20 == actor.pos_08.getZ() >> 20) {
        return actor;
      }

      //LAB_20080ae
    }

    //LAB_20080b6
    return null;
  }

  @Method(0x20080c4)
  public static void FUN_20080c4() {
    final Actor70 r8 = getMapActor(0);
    final int r3 = (r8.angle_06.get() & 0xffff) >>> 12;
    final int r1 = MEMORY.ref(4, 0x200e190 + r3 * 0x4).get();
    final Vec3 r7 = new Vec3();
    r7.setX(r8.pos_08.getX() + (r1 & 0xffff0000));
    r7.setY(r8.pos_08.getY());
    r7.setZ(r8.pos_08.getZ() + (r1 << 16));

    final Actor70 r6 = FUN_200806c(r7);
    if(r6 != null) {
      //LAB_2008114
      r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
      r7.setY(r6.pos_08.getY());
      r7.setZ(r6.pos_08.getZ() + (r1 << 16));

      final Actor70 actor1 = FUN_200806c(r7);
      if(actor1 == null || (actor1._59.get() & 0x1) == 0) {
        //LAB_200814a
        r7.setX(r6.pos_08.getX());
        r7.setY(r6.pos_08.getY() + 0x100000);
        r7.setZ(r6.pos_08.getZ());

        final Actor70 actor2 = FUN_200806c(r7);
        if(actor2 == null || (actor2._59.get() & 0x1) == 0) {
          //LAB_2008176
          r6.layer_22.set(2);
          r7.setX(r6.pos_08.getX() + (r1 & 0xffff0000));
          r7.setY(r6.pos_08.getY());
          r7.setZ(r6.pos_08.getZ() + (r1 << 16));

          if(FUN_200df44(r6, r7) <= 0) {
            if(r6._62.get() == 0) {
              setActorAnimation(r8, 8);
              sleep(15);
              playSound(0xb9);
              r6.velocityScalar_30.set(0x3333);
              r6.acceleration_34.set(0x3333);
              FUN_200df1c(r6, r7.getX(), r7.getY(), r7.getZ());
              r8.velocityScalar_30.set(0x3333);
              r8.acceleration_34.set(0x3333);
              FUN_200df1c(r8, r7.getX(), r7.getY(), r7.getZ());
              FUN_200df24(r6);
              FUN_200e144();
              r6.pos_08.setX(r7.getX());
              r6.pos_08.setZ(r7.getZ());
              r6.velocity_24.setX(0);
              r6.velocity_24.setZ(0);
              r8.dest_38.setX(0x80000000);
              r8.dest_38.setZ(0x80000000);
              r8.velocity_24.setX(0);
              r8.velocity_24.setZ(0);
              r8.pos_08.setX(r8.pos_08.getX() & 0xffff0000);
              r8.pos_08.setZ(r8.pos_08.getZ() & 0xffff0000);
              setActorAnimation(r8, 1);
            }
          }
        }
      }
    }

    //LAB_2008226
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x20089dc)
  public static int getRooms() {
    final int r0;

    r0 = 0x200e708;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x20089e4)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x20089e8)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200e870;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x20089f0)
  public static int getActors() {
    int r0;
    int r2;
    int r3;

    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x10) {
      r0 = 0x200ee48;
    } else {
      //LAB_2008a06
      r0 = 0x87a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x200ecc8;
      } else {
        //LAB_2008a14
        r0 = 0x815;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r0 = 0x200eab8;
        } else {
          //LAB_2008a22
          r0 = 0x200e8a8;
        }
      }
    }

    return r0;
  }

  /**
   * Event list 0x200f100 handler 41
   */
  @Method(value = 0x2008a44, ignoreExtraParams = true)
  public static void FUN_2008a44() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1a;
    FUN_200e03c(r0, r1, r2);
    r0 = 0xfd;
    r0 = r0 << 4;
    setFlag(r0);
    r0 = 0xb5;
    r1 = 0x3;
    FUN_200e11c(r0, r1);
    r1 = 0x0;
    r0 = 0xb5;
    r0 = FUN_200dfd4(r0, r1);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f334 handler 38
   */
  @Method(value = 0x2008a74, ignoreExtraParams = true)
  public static void FUN_2008a74() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x14;
    FUN_200e03c(r0, r1, r2);
    r0 = 0xfd;
    r0 = r0 << 4;
    setFlag(r0);
    r0 = 0xb5;
    r1 = 0x3;
    FUN_200e11c(r0, r1);
    r1 = 0x0;
    r0 = 0xb5;
    r0 = FUN_200dfd4(r0, r1);
    FUN_200dfc4();
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008aa4)
  public static int getEvents() {
    int r0;

    r0 = 0x87a;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x200f334;
    } else {
      //LAB_2008ab4
      r0 = 0x815;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x200f100;
      } else {
        //LAB_2008ac2
        r0 = 0x200ef38;
      }
    }

    return r0;
  }

  /**
   * Event list 0x200f100 handler 2
   */
  @Method(value = 0x2008adc, ignoreExtraParams = true)
  public static void FUN_2008adc() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r0 = 0x815;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x11cc;
      FUN_200e084(r0);
      r0 = 0xa;
      r1 = 0x0;
      FUN_200e094(r0, r1);
    } else {
      //LAB_2008afc
      r0 = 0xf81;
      FUN_200e084(r0);
      r0 = 0xa;
      r1 = 0x0;
      r2 = 0x4;
      FUN_200e074(r0, r1, r2);
      r0 = 0xa;
      r1 = 0x0;
      r0 = FUN_200e0a4(r0, r1);
    }

    //LAB_2008b14
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f100 handler 6
   */
  @Method(value = 0x2008b28, ignoreExtraParams = true)
  public static void FUN_2008b28() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r0 = 0x815;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x11c9;
      FUN_200e084(r0);
      r0 = 0xe;
      r1 = 0x0;
      FUN_200e094(r0, r1);
    } else {
      //LAB_2008b48
      r0 = 0x806;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x806;
        setFlag(r0);
        r0 = 0xf7c;
        FUN_200e084(r0);
        r0 = 0xe;
        r1 = 0x0;
        r2 = 0x4;
        FUN_200e074(r0, r1, r2);
        r0 = 0xe;
        r1 = 0x0;
        r0 = FUN_200e0a4(r0, r1);
      } else {
        //LAB_2008b72
        r0 = 0xf7e;
        FUN_200e084(r0);
        r0 = 0xe;
        r1 = 0x0;
        r2 = 0x4;
        FUN_200e074(r0, r1, r2);
        r0 = 0xe;
        r1 = 0x0;
        FUN_200e094(r0, r1);
      }
    }

    //LAB_2008b8a
    FUN_200dfc4();
  }

  /**
   * Event list 0x200ef38 handler 7
   */
  @Method(value = 0x2008ba8, ignoreExtraParams = true)
  public static void FUN_2008ba8() {
    int r0;
    int r1;
    int r2;

    FUN_200dfbc();
    r0 = 0x807;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x807;
      setFlag(r0);
      r0 = 0xf63;
      FUN_200e084(r0);
      r0 = 0x12;
      r1 = 0x103;
      r2 = 0x0;
      FUN_200e0c4(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x12;
      r2 = 0x14;
      FUN_200e074(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x0;
      r2 = 0x6;
      FUN_200e09c(r0, r1, r2);
      r1 = 0x80;
      r0 = 0x12;
      r1 = r1 << 8;
      r2 = 0x1e;
      FUN_200e0ac(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x2;
      r2 = 0x14;
      FUN_200e054(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x0;
      r2 = 0x6;
      FUN_200e09c(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x0;
      r2 = 0xa;
      FUN_200e074(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x103;
      r2 = 0x0;
      FUN_200e0c4(r0, r1, r2);
      r0 = 0x12;
      r1 = 0x0;
      r2 = 0xa;
      FUN_200e09c(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x3c;
      FUN_200e0c4(r0, r1, r2);
    } else {
      //LAB_2008c2e
      r1 = 0x103;
      r2 = 0x0;
      r0 = 0x12;
      FUN_200e0c4(r0, r1, r2);
      r0 = 0xf66;
      FUN_200e084(r0);
      r0 = 0x12;
      r1 = 0x0;
      r2 = 0x14;
      FUN_200e09c(r0, r1, r2);
    }

    //LAB_2008c48
    FUN_200dfc4();
  }

  /**
   * Event list 0x200ef38 handler 9
   */
  @Method(value = 0x2008c60, ignoreExtraParams = true)
  public static void FUN_2008c60() {
    int r0;
    final int r1;

    FUN_200dfbc();
    r0 = 0x202;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0xf68;
      FUN_200e084(r0);
    } else {
      //LAB_2008c78
      r0 = 0xf69;
      FUN_200e084(r0);
    }

    //LAB_2008c7e
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f334 handler 15
   */
  @Method(value = 0x2008c9c, ignoreExtraParams = true)
  public static void FUN_2008c9c() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r2 = 0x14;
    r1 = 0xa;
    r0 = 0x0;
    FUN_200e074(r0, r1, r2);
    r0 = 0x1c8d;
    FUN_200e084(r0);
    r1 = 0x0;
    r0 = 0xa;
    FUN_200e094(r0, r1);
    r0 = 0x81f;
    setFlag(r0);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f334 handler 8
   */
  @Method(value = 0x2008cd0, ignoreExtraParams = true)
  public static void FUN_2008cd0() {
    int r0;
    int r1;
    int r2;

    FUN_200dfbc();
    r0 = 0xc0;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_200df54(r0, r1, r2);
    r0 = 0xa;
    sleep(r0);
    r0 = 0x1;
    r1 = 0x1;
    r1 = -r1;
    r2 = 0xe666;
    r0 = -r0;
    FUN_200df54(r0, r1, r2);
    r0 = 0x1c9a;
    FUN_200e084(r0);
    r0 = 0x11;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x11;
    r1 = 0x0;
    FUN_200e06c(r0, r1, r2);
    r0 = 0x11;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f334 handler 21
   */
  @Method(value = 0x2008d2c, ignoreExtraParams = true)
  public static void FUN_2008d2c() {
    int r0;
    int r1;
    final int r2;

    FUN_200dfbc();
    r1 = 0x2;
    r0 = 0x13;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r2 = 0x14;
    r1 = 0x0;
    r0 = 0x13;
    FUN_200e06c(r0, r1, r2);
    r0 = 0x1c9d;
    FUN_200e084(r0);
    r1 = 0x0;
    r0 = 0x13;
    r0 = FUN_200e0a4(r0, r1);
    r0 = 0x307;
    setFlag(r0);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f100 handler 31
   */
  @Method(value = 0x2008d70, ignoreExtraParams = true)
  public static void FUN_2008d70() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r0 = 0x84;
    r0 = r0 << 2;
    CPU.sp().value -= 0x8;
    setFlag(r0);
    r3 = 0xa;
    r2 = 0x54;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x28;
    r1 = 0x54;
    r2 = 0x7;
    r3 = 0x4;
    FUN_200df3c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200f100 handler 32
   */
  @Method(value = 0x2008d98, ignoreExtraParams = true)
  public static void FUN_2008d98() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r0 = 0x84;
    r0 = r0 << 2;
    CPU.sp().value -= 0x8;
    clearFlag(r0);
    r3 = 0xa;
    r2 = 0x54;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x28;
    r1 = 0x59;
    r2 = 0x7;
    r3 = 0x4;
    FUN_200df3c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200f100 handler 20
   */
  @Method(value = 0x2008dc0, ignoreExtraParams = true)
  public static void FUN_2008dc0() {
    int r0;
    int r1;
    int r2;

    r0 = 0xbc;
    playSound(r0);
    r0 = 0x200f544;
    r1 = 0x2d;
    r2 = 0xb;
    FUN_200df2c(r0, r1, r2);
    r2 = 0xd2;
    r0 = 0x0;
    r1 = 0x101;
    r2 = r2 << 1;
    FUN_200e01c(r0, r1, r2);
    r0 = 0xb;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 21
   */
  @Method(value = 0x2008df0, ignoreExtraParams = true)
  public static void FUN_2008df0() {
    int r0;

    r0 = 0x801;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      FUN_2008fec();
    } else {
      //LAB_2008e02
      r0 = 0x7b;
      playSound(r0);
      r0 = 0x1;
      FUN_200e0fc(r0);
    }
  }

  /**
   * Event list 0x200f100 handler 22
   */
  @Method(value = 0x2008e18, ignoreExtraParams = true)
  public static void FUN_2008e18() {
    int r0;

    r0 = 0x7b;
    playSound(r0);
    r0 = 0x3;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 23
   */
  @Method(value = 0x2008e2c, ignoreExtraParams = true)
  public static void FUN_2008e2c() {
    int r0;

    r0 = 0x7b;
    playSound(r0);
    r0 = 0x4;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 24
   */
  @Method(value = 0x2008e40, ignoreExtraParams = true)
  public static void FUN_2008e40() {
    int r0;

    r0 = 0x7b;
    playSound(r0);
    r0 = 0x2;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 25
   */
  @Method(value = 0x2008e54, ignoreExtraParams = true)
  public static void FUN_2008e54() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200f55a;
    r1 = 0x36;
    r2 = 0x20;
    FUN_200df2c(r0, r1, r2);
    r1 = 0xcb;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x2d7;
    FUN_200e01c(r0, r1, r2);
    r0 = 0x5;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 26
   */
  @Method(value = 0x2008e84, ignoreExtraParams = true)
  public static void FUN_2008e84() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200f570;
    r1 = 0x2d;
    r2 = 0x27;
    FUN_200df2c(r0, r1, r2);
    r1 = 0x83;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x325;
    FUN_200e01c(r0, r1, r2);
    r0 = 0x6;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 27
   */
  @Method(value = 0x2008eb4, ignoreExtraParams = true)
  public static void FUN_2008eb4() {
    int r0;
    int r1;
    int r2;
    int r3;

    if(readFlag(0x815) != 0x0 && readFlag(0x87a) == 0x0) {
      FUN_200dfbc();
      r0 = 0x11b6;
      FUN_200e084(r0);
      r1 = 0x0;
      r0 = 0x15;
      FUN_200e08c(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200dfdc(r0, r1);
      if(r0 == 0x0) {
        r0 = 0x15;
        r1 = 0x0;
        r2 = 0x3c;
        FUN_200e09c(r0, r1, r2);
        r0 = 0x15;
        r1 = 0x0;
        FUN_200e094(r0, r1);
      } else {
        //LAB_2008efc
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x2;
        r0 = 0x28;
        MEMORY.ref(2, r2).setu(r3);
        FUN_200dfb4(r0);
        r0 = 0x15;
        r1 = 0x0;
        FUN_200e094(r0, r1);
      }

      //LAB_2008f1a
      FUN_200dfc4();
    } else {
      //LAB_2008f20
      r0 = 0x9e;
      playSound(r0);
      r0 = 0x200f55a;
      r1 = 0x32;
      r2 = 0x2c;
      FUN_200df2c(r0, r1, r2);
      r1 = 0xaa;
      r2 = 0xde;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = r2 << 2;
      FUN_200e01c(r0, r1, r2);
      r0 = 0x7;
      FUN_200e0fc(r0);
    }
  }

  /**
   * Event list 0x200f100 handler 28
   */
  @Method(value = 0x2008f5c, ignoreExtraParams = true)
  public static void FUN_2008f5c() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200f570;
    r1 = 0x31;
    r2 = 0x45;
    FUN_200df2c(r0, r1, r2);
    r1 = 0xa3;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x466;
    FUN_200e01c(r0, r1, r2);
    r0 = 0x8;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 29
   */
  @Method(value = 0x2008f8c, ignoreExtraParams = true)
  public static void FUN_2008f8c() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200f586;
    r1 = 0x34;
    r2 = 0x4c;
    FUN_200df2c(r0, r1, r2);
    r1 = 0xbb;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x4d6;
    FUN_200e01c(r0, r1, r2);
    r0 = 0x9;
    FUN_200e0fc(r0);
  }

  /**
   * Event list 0x200f100 handler 30
   */
  @Method(value = 0x2008fbc, ignoreExtraParams = true)
  public static void FUN_2008fbc() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200f55a;
    r1 = 0x23;
    r2 = 0x4a;
    FUN_200df2c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x66;
    r2 = 0x4b6;
    FUN_200e01c(r0, r1, r2);
    r0 = 0xa;
    FUN_200e0fc(r0);
  }

  @Method(0x2008fec)
  public static void FUN_2008fec() {
    final Actor70 r6 = getMapActor(0);
    final Actor70 r5 = getMapActor(5);
    FUN_200dfbc();
    r5.pos_08.set(r6.pos_08);
    r5.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    r5.velocity_24.zero();
    r5._14.set(r6.pos_08.getY());
    sleep(1);
    setActorVelocityScalerAndAcceleration(5, 0x10000, 0x8000);
    FUN_200e024(5, 110, 283);
    FUN_200e074(0, 5, 2);
    FUN_200e084(0xf39);

    if(r6.pos_08.getX() < r5.pos_08.getX()) {
      FUN_200e09c(0xa005, 0, 2);
    } else {
      //LAB_2009066
      FUN_200e09c(0x8005, 0, 2);
    }

    //LAB_2009070
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200dfb4(2);
    setActorAnimationIfLoaded(5, 2);

    final Actor70 r0 = getMapActor(0);
    if(r0 != null) {
      FUN_200e00c(5, r0.pos_08.getX() >> 16, r0.pos_08.getZ() >> 16);
    }

    //LAB_200909e
    FUN_200e034(5);
    FUN_200e03c(5, 0, 0);
    FUN_200e024(0, 110, 303);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f100 handler 33
   */
  @Method(value = 0x20090d8, ignoreExtraParams = true)
  public static void FUN_20090d8() {
    if(readFlag(0x808) == 0) {
      final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
      FUN_200dfbc();
      setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
      setActorAnimationIfLoaded(0, 1);
      FUN_200dfb4(2);
      FUN_200e084(0xf4d);
      FUN_200e09c(15, 0, 2);
      FUN_200e09c(16, 0, 2);
      final Actor70 r0 = getMapActor(0);
      final Vec3 r7 = new Vec3();
      r7.set(r0.pos_08);
      final Vec3 r10 = r8._00.derefNullable();
      r8._00.set(r7);

      //LAB_200914e
      for(int r6 = 0; r6 < 40; r6++) {
        r7.z_08.add(0x20000);
        FUN_200dfb4(1);
        FUN_200df14();
      }

      FUN_200dfb4(60);
      FUN_200df7c(0xf4f, 1);
      FUN_200dfb4(6);

      //LAB_2009180
      for(int r6 = 0; r6 < 40; r6++) {
        r7.z_08.sub(0x20000);
        FUN_200dfb4(1);
        FUN_200df14();
      }

      r8._00.setNullable(r10);
      FUN_200dfb4(60);
      FUN_200e024(0, 70, 741);
      FUN_200dfc4();
    }

    //LAB_20091b2
  }

  /**
   * Event list 0x200f100 handler 34
   */
  @Method(value = 0x20091d8, ignoreExtraParams = true)
  public static void FUN_20091d8() {
    int r0;
    int r1;
    int r2;
    int r5;

    r0 = 0x808;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      FUN_200dfbc();
      r1 = 0x80;
      r2 = 0x80;
      r1 = r1 << 9;
      r2 = r2 << 8;
      r0 = 0x0;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r5 = 0xf4d;
      r0 = r5;
      FUN_200e084(r0);
      r0 = 0xf;
      r1 = 0x0;
      r2 = 0x2;
      FUN_200e09c(r0, r1, r2);
      r5 = r5 + 0x2;
      r2 = 0x2;
      r0 = 0x10;
      r1 = 0x0;
      FUN_200e09c(r0, r1, r2);
      r1 = 0x1;
      r0 = r5;
      FUN_200df7c(r0, r1);
      r0 = 0x6;
      FUN_200dfb4(r0);
      r0 = 0x0;
      r1 = 0x45;
      r2 = 0x366;
      FUN_200e024(r0, r1, r2);
      FUN_200dfc4();
    }
  }

  /**
   * Event list 0x200f100 handler 39
   */
  @Method(value = 0x2009244, ignoreExtraParams = true)
  public static void FUN_2009244() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    FUN_200dfbc();
    r3 = 0x14;
    r2 = 0x32;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x31;
    r1 = 0x35;
    r2 = 0x8;
    r3 = 0x4;
    FUN_200df3c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r1 = 0xa;
    r2 = 0xb;
    r3 = 0x1;
    r0 = 0x0;
    FUN_200b2b0(r0, r1, r2, r3);
    r0 = 0x81;
    r0 = r0 << 2;
    setFlag(r0);
    FUN_200dfc4();
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200f100 handler 40
   */
  @Method(value = 0x2009280, ignoreExtraParams = true)
  public static void FUN_2009280() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    FUN_200dfbc();
    r1 = 0xd;
    r2 = 0xa;
    r3 = 0x1;
    r0 = 0x0;
    FUN_200b380(r0, r1, r2, r3);
    r0 = 0x81;
    r0 = r0 << 2;
    clearFlag(r0);
    r3 = 0x14;
    r2 = 0x32;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x31;
    r1 = 0x2e;
    r2 = 0x8;
    r3 = 0x4;
    FUN_200df3c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    FUN_200dfc4();
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200f100 handler 35
   */
  @Method(value = 0x20092bc, ignoreExtraParams = true)
  public static void FUN_20092bc() {
    int r0;
    int r1;
    int r2;

    final Actor70 r5 = getMapActor(22);
    FUN_200dfbc();
    setActorVelocityScalerAndAcceleration(0, 0x20000, 0x20000);
    FUN_200e054(0, 5, 0);
    FUN_200e01c(0, 215, 403);
    r5._5a.or(0x1);
    FUN_200e03c(22, 0xa60000, 0x1770000);
    FUN_200e0ac(22, 0x2000, 20);
    r5._5a.xor(0x1);
    setActorVelocityScalerAndAcceleration(22, 0x28000, 0x28000);
    r0 = 0x16;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200e054(r0, r1, r2);
    r2 = 0x18b;
    r0 = 0x16;
    r1 = 0xca;
    FUN_200e024(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0xb0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x16;
    r1 = r1 << 6;
    r2 = 0x18;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200e05c(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0xc0;
    r2 = 0x80;
    r2 = r2 << 9;
    r0 = 0x16;
    r1 = r1 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x200f59c;
    r0 = 0x0;
    FUN_200dff4(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r2 = 0x0;
    r0 = 0x16;
    r1 = 0x103;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0x200f5ec;
    r0 = 0x16;
    FUN_200dff4(r0, r1);
    r0 = 0x0;
    FUN_200dffc(r0);
    r1 = 0x80;
    r2 = 0xed;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = r2 << 1;
    FUN_200e024(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x16;
    FUN_200dffc(r0);
    r1 = 0x80;
    r2 = 0xe4;
    r2 = r2 << 1;
    r0 = 0x16;
    r1 = r1 << 1;
    FUN_200e024(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x16;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x16;
    FUN_200e05c(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r0 = 0xfce;
    FUN_200e084(r0);
    r1 = 0x0;
    r0 = 0x16;
    FUN_200e0a4(r0, r1);
    getMapActor(22)._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200d72c", Actor70.class));
    FUN_200dff4(22, 0x200e248);
    setFlag(0x823);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f100 handler 36
   */
  @Method(value = 0x2009454, ignoreExtraParams = true)
  public static void FUN_2009454() {
    final Actor70 r5 = getMapActor(22);
    if(readFlag(0x823) != 0 && r5._64.get() == 1) {
      FUN_2009490(0x200f63c, 0x200f6cc);
    }
  }

  @Method(0x2009490)
  public static void FUN_2009490(final int r0, final int r1) {
    final Actor70 r6 = getMapActor(22);
    FUN_200dfbc();
    FUN_200e05c(22, 2);
    FUN_200e0c4(22, 0x100, 20);
    FUN_200e05c(0, 2);
    FUN_200e0c4(0, 0x102, 40);
    FUN_200dff4(0, r0);
    FUN_200dfb4(10);
    FUN_200e0c4(22, 0x103, 0);
    FUN_200e004(22, r1);
    FUN_200dffc(0);
    FUN_200dfb4(20);
    FUN_200e064(22, 2);
    r6.scale_18.set(0x10000);
    r6._1c.set(0x10000);
    final Actor70 actor0 = getMapActor(0);
    actor0.scale_18.set(0x10000);
    actor0._1c.set(0x10000);
    FUN_200e084(0xfce);
    FUN_200e0a4(22, 0);
    final Actor70 actor22 = getMapActor(22);
    actor22._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200d72c", Actor70.class));
    FUN_200dff4(22, 0x200e248);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f100 handler 37
   */
  @Method(value = 0x2009554, ignoreExtraParams = true)
  public static void FUN_2009554() {
    final Actor70 r5 = getMapActor(22);
    if(readFlag(0x823) != 0 && r5._64.get() == 2) {
      FUN_2009490(0x200f748, 0x200f7c4);
    }

    //LAB_200957c
  }

  /**
   * Event list 0x200f100 handler 38
   */
  @Method(value = 0x2009590, ignoreExtraParams = true)
  public static void FUN_2009590() {
    final Actor70 r5 = getMapActor(22);
    if(readFlag(0x823) != 0) {
      final int r0 = r5._64.get();
      if(r0 == 1) {
        FUN_2009490(0x200f748, 0x200f6cc);
        //LAB_20095ba
      } else if(r0 == 2) {
        FUN_2009490(0x200f748, 0x200f7c4);
      }
    }

    //LAB_20095c6
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x200aa54)
  public static int init() {
    if(MEMORY.ref(2, 0x2000402).get() == 0x10) {
      FUN_200df94(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
      FUN_200b4c8();
    } else {
      //LAB_200aa7e
      if(readFlag(0xfd0) == 0) {
        if(readFlag(0x87a) == 0) {
          FUN_200db48(26);
        } else {
          //LAB_200aa9c
          FUN_200db48(20);
        }
      }

      //LAB_200aaa2
      FUN_200df34(2, 102, 84, 41, 2, 1);
      FUN_200df34(1, 102, 83, 41, 1, 1);
      final int r3 = readFlag(0x87a);
      final int r0 = (-r3 | r3) >>> 31;
      final Actor70 r5 = getMapActor(20 + r0);
      FUN_200df4c(r5, 0);

      if(readFlag(0x314) != 0) {
        r5.pos_08.setX(0x16a0000);
        //LAB_200aaf2
      } else if(readFlag(0x316) != 0) {
        r5.pos_08.setX(0x18a0000);
      } else {
        //LAB_200ab00
        r5.pos_08.setX(0x17a0000);
      }

      //LAB_200ab02
      r5.pos_08.setY(0xc00000);
      r5.pos_08.setZ(0x2480000);
      FUN_200d950();

      //BUGFIX: This is set to 3 in retail but corrects itself to 2 if interacted with. There are only 3 layers.
      // It's the "move" pillar Garet interacts with
      r5.layer_22.set(2);
      r5._55.set(0);
      setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da94"), 0xc80);

      if(readFlag(0x87a) == 0) {
        if(readFlag(0x815) != 0) {
          final Actor70 actor21 = getMapActor(21);
          FUN_200df4c(actor21, 0);
          actor21.scale_18.set(0x28f);
          actor21._1c.set(0x28f);
        }

        //LAB_200ab5e
        if(readFlag(0x808) != 0) {
          FUN_200e03c(15, 0, 0);
          FUN_200e03c(16, 0, 0);
          FUN_200e03c(17, 0, 0);
        }

        //LAB_200ab86
        if(readFlag(0x815) == 0) {
          if(readFlag(0x109) == 0) {
            if(readFlag(0x823) != 0) {
              FUN_200e03c(22, 0x1000000, 0x1c80000);
              getMapActor(22)._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200d72c", Actor70.class));
              FUN_200dff4(22, 0x200e248);
            }
          } else {
            //LAB_200abc8
            getMapActor(22)._5b.set(0);
            clearFlag(0x241);
          }

          //LAB_200abd8
          if(MEMORY.ref(2, 0x2000402).get() != 0x10 && readFlag(0x87a) == 0) {
            setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da40"), 0xc80);
          }
        }

        //LAB_200abfc
        if(readFlag(0x308) == 0 && MEMORY.ref(2, 0x2000402).get() == 0x11) {
          FUN_200bfb0();
          setFlag(0x308);
        }
      }

      //LAB_200ac24
      if(readFlag(0x109) != 0) {
        if(readFlag(0x204) != 0) {
          FUN_200df3c(49, 53, 8, 4, 20, 50);
        }

        //LAB_200ac4e
        if(readFlag(0x210) != 0) {
          FUN_2008d70();
        }
      }

      //LAB_200ac5e
      FUN_200e13c(170);
      FUN_200df14();
      sleep(1);
    }

    //LAB_200ac6e
    return 0;
  }

  /**
   * Event list 0x200f334 handler 11
   */
  @Method(value = 0x200acb0, ignoreExtraParams = true)
  public static void FUN_200acb0() {
    FUN_200dfbc();
    FUN_200e07c(0, 0);
    FUN_200e06c(8, 0, 20);
    FUN_200e084(0x1c45);
    FUN_200e05c(8, 2);
    FUN_200e09c(8, 0, 20);
    FUN_200e0dc(0x10000, 0x2000);
    FUN_200e0e4(0x18e0000, -1, 0x2460000, 1);
    setActorVelocityScalerAndAcceleration(0, 0xcccc, 0x6666);
    setActorVelocityScalerAndAcceleration(1, 0xcccc, 0x6666);
    FUN_200e024(0, 420, 608);
    FUN_200e0ac(0, 0xa000, 0);
    FUN_200e0ac(8, 0x3000, 0);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      FUN_200e03c(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_200ad4c
    FUN_200e024(1, 402, 608);
    FUN_200e0ac(1, 0xd000, 20);
    FUN_200e094(0x1001, 0);
    FUN_200e0ac(8, 0x5000, 20);
    setActorAnimationAndWaitUntilFinished(8, 3);
    FUN_200e094(0x4008, 0);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200dfb4(20);
    FUN_200e064(8, 2);
    FUN_200e08c(0x4008);

    if(FUN_200dfdc(0, 0) == 1) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
      FUN_200e05c(8, 1);
    }

    //LAB_200add4
    FUN_200e09c(0x4008, 0, 40);
    FUN_200e0c4(8, 0x105, 60);
    FUN_200e084(0x1c4b);
    FUN_200e09c(0x4008, 0, 20);
    FUN_200e064(1, 1);
    FUN_200dfb4(40);
    FUN_200e09c(0x1001, 0, 40);
    FUN_200e064(8, 1);
    FUN_200e0ac(8, 0xd000, 20);
    FUN_200e094(0x4008, 0);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200e09c(0x1001, 0, 120);
    FUN_200e09c(0x4008, 0, 20);
    FUN_200e0c4(1, 0x105, 40);
    FUN_200e09c(0x1001, 0, 40);
    setActorAnimationAndWaitUntilFinished(8, 4);
    FUN_200e09c(0x4008, 0, 20);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200dfb4(40);
    FUN_200e0ac(8, 0x5000, 20);
    FUN_200e09c(0x4008, 0, 10);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200dfb4(20);
    setActorAnimationAndWaitUntilFinished(8, 3);
    setActorAnimationIfLoaded(1, 2);

    if(actor0 != null) {
      FUN_200e00c(1, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_200aed0
    FUN_200e034(1);
    FUN_200e03c(1, 0, 0);
    setFlag(0x303);
    FUN_200dfc4();
  }

  /**
   * Event list 0x200f334 handler 13
   */
  @Method(value = 0x200af14, ignoreExtraParams = true)
  public static void FUN_200af14() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200dfbc();
    FUN_200e0e4(0x1650000, -1, 0x2e20000, 1);
    FUN_200e024(0, 367, 745);
    FUN_200e0ac(0, 0xa000, 0);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      FUN_200e03c(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_200af52
    r1 = 0xad;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x2e9;
    FUN_200e024(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0x14;
    r1 = r1 << 8;
    r0 = 0x1;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1c53;
    FUN_200e084(r0);
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x9;
    r1 = r1 << 7;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x28;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200e064(r0, r1);
    r1 = 0xa0;
    r0 = 0x9;
    r1 = r1 << 7;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    FUN_200e05c(r0, r1);
    r0 = 0x1;
    r1 = 0x103;
    r2 = 0x28;
    FUN_200e0c4(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x28;
    r0 = 0x1;
    r1 = r1 << 5;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    r1 = 0xb0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r2 = 0xa;
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x50;
    FUN_200e0c4(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 5;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200e08c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200dfdc(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x1;
      r1 = 0x105;
      r2 = 0x3c;
      FUN_200e0c4(r0, r1, r2);
    } else {
      //LAB_200b0e0
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200b0f0
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0xa;
    r1 = r1 << 8;
    r0 = 0x1;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1c60;
    FUN_200e084(r0);
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0x14;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 5;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      FUN_200e00c(1, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_200b170
    r0 = 0x1;
    FUN_200e034(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200e03c(r0, r1, r2);
    r0 = 0xc1;
    r0 = r0 << 2;
    setFlag(r0);
    FUN_200dfc4();
  }

  @Method(0x200b2b0)
  public static void FUN_200b2b0(final int mapActorIndex, final int r1, final int r2, final int r3) {
    final Actor70 r6 = getMapActor(mapActorIndex);
    final Sprite38 r5 = r6.sprite_50.deref();
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x10000, 0x8000);
    FUN_200e024(mapActorIndex, 392, 886);
    FUN_200e0ac(0, 0xc000, 10);
    r6._55.set(0);
    r5._26.set(0);
    setActorAnimationIfLoaded(mapActorIndex, r1);
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x4ccc, 0x2666);
    FUN_200e014(mapActorIndex, 392, 875);
    FUN_200dfb4(10);
    setActorAnimationIfLoaded(mapActorIndex, r2);
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x10000, 0x8000);
    FUN_200e014(mapActorIndex, 392, 859);
    r5._26.set(1);

    if(r3 != 0) {
      r6._55.set(3);
    }

    //LAB_200b34e
    FUN_200dfb4(10);
    setActorAnimationIfLoaded(mapActorIndex, 1);
  }

  @Method(0x200b380)
  public static void FUN_200b380(final int mapActorIndex, final int r1, final int r2, final int r3) {
    final Actor70 r6 = getMapActor(mapActorIndex);
    final Sprite38 r5 = r6.sprite_50.deref();
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x10000, 0x8000);
    FUN_200e024(mapActorIndex, 392, 859);
    FUN_200e0ac(mapActorIndex, 0xc000, 10);
    r6._55.set(0);
    r5._26.set(0);
    setActorAnimationIfLoaded(mapActorIndex, r1);
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x10000, 0x8000);
    FUN_200e014(mapActorIndex, 392, 875);
    FUN_200dfb4(10);
    setActorVelocityScalerAndAcceleration(mapActorIndex, 0x4ccc, 0x2666);
    setActorAnimationIfLoaded(mapActorIndex, r2);
    FUN_200e014(mapActorIndex, 392, 890);
    r6.velocity_24.setY(0x20000);
    r5._26.set(1);

    if(r3 != 0) {
      r6._55.set(3);
    }

    //LAB_200b42e
    setActorAnimationIfLoaded(mapActorIndex, 1);
  }

  @Method(0x200b4c8)
  public static void FUN_200b4c8() {
    final Actor70 r9 = getMapActor(0);
    final Actor70 r6 = getMapActor(14);
    FUN_200dfbc();
    FUN_200e0e4(-1, -1, -1, 0);
    sleep(1);
    FUN_200e0f4()._55.set(0);
    sleep(1);
    FUN_200df3c(49, 53, 8, 4, 20, 50);
    FUN_200df34(2, 102, 84, 41, 2, 1);
    FUN_200df34(1, 102, 83, 41, 1, 1);
    FUN_200df34(0, 103, 82, 42, 1, 1);
    Actor70 r7 = getMapActor(11);
    r7.pos_08.set(0xa00000, 0x1840000, 0x3480000);
    r7._55.set(0);
    FUN_200df4c(r7, 0);
    r7 = getMapActor(12);
    r7.pos_08.set(0x1840000, 0xa00000, 0x34c0000);
    r7._55.set(0);
    FUN_200df4c(r7, 0);
    r7 = getMapActor(13);
    r7.pos_08.set(0x1840000, 0xa00000, 0x3500000);
    r7._55.set(0);
    FUN_200df4c(r7, 0);
    FUN_200df4c(getMapActor(11), 0);
    FUN_200df4c(getMapActor(12), 0);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 33613200);
    FUN_200df64();
    FUN_200df84(0xee8, 0, 0);
    FUN_200df6c();
    FUN_200e0e4(0x1530000, 0xa00000, 0x4950000, 0);
    FUN_200df14();
    sleep(1);
    FUN_200e0dc(0x547a, 2703);
    FUN_200e0e4(0x1280000, 0xa00000, 0x3990000, 1);
    FUN_200e03c(5, 0x1990000, 0x46e0000);
    sleep(1);
    setActorVelocityScalerAndAcceleration(5, 0xb333, 22937);
    FUN_200e01c(5, 420, 1068);
    FUN_200e134();
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c8.set(60);
    FUN_200e104();
    FUN_200e034(5);
    setActorVelocityScalerAndAcceleration(5, 0x10000, 0x8000);
    FUN_200e024(5, 341, 1064);
    setActorVelocityScalerAndAcceleration(5, 0xcccc, 0x6666);
    FUN_200e024(5, 359, 1033);
    setActorVelocityScalerAndAcceleration(8, 0x8000, 0x4000);
    FUN_200e01c(8, 318, 947);
    setActorAnimationIfLoaded(8, 2);
    FUN_200e024(5, 412, 1033);
    FUN_200e024(5, 412, 1019);
    FUN_200e024(5, 374, 1008);
    FUN_200e024(5, 347, 955);
    FUN_200e024(8, 318, 947);
    FUN_200e074(5, 8, 40);
    FUN_200e064(8, 2);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200dfb4(10);
    FUN_200e01c(8, 379, 1017);
    FUN_200e0dc(0x8000, 0x1000);
    FUN_200e024(5, 333, 920);
    FUN_200e024(5, 299, 924);
    FUN_200e0ec();
    FUN_200dfb4(10);
    FUN_200e0ac(5, 0xf000, 30);
    FUN_200e064(5, 2);
    FUN_200dfb4(20);
    FUN_200e0dc(0x20000, 0x4000);
    FUN_200e0e4(0x1830000, 0xa00000, 0x3620000, 1);
    FUN_200e0ec();
    FUN_200e054(10, 2, 20);
    FUN_200e084(0xee9);
    FUN_200e09c(0x100a, 0, 10);
    r9.scale_18.set(0x10000);
    r9._1c.set(0x10000);
    FUN_200dff4(0, 1);
    FUN_200e074(10, 0, 40);
    FUN_200e0cc(0, 0x102);
    FUN_200e064(0, 2);
    FUN_200dfb4(40);
    FUN_200e05c(10, 2);
    FUN_200dfb4(40);
    FUN_200e09c(0x100a, 0, 40);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 0x200e590);
    FUN_200e0d4(5, 1);
    FUN_200e0ec();
    FUN_200dfb4(40);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200e0ac(5, 0xd000, 10);
    FUN_200e024(5, 312, 759);
    FUN_200e024(5, 361, 760);
    FUN_200dfb4(20);
    FUN_200e0ac(5, 0x8000, 40);
    FUN_200e0ac(5, 0, 40);
    FUN_200e09c(0x6001, 0, 10);
    FUN_200e0c4(5, 0x100, 0);
    FUN_200e054(5, 4, 40);
    FUN_200e0ac(5, 0xc000, 30);
    FUN_200e064(5, 2);
    FUN_200dfb4(40);
    FUN_200e09c(5, 0, 30);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200dfb4(10);
    FUN_200e0dc(0x40000, 0x8000);
    FUN_200e0e4(0x18c0000, -1, 0x24c0000, 1);
    FUN_200e024(5, 456, 739);
    FUN_200e0ec();
    FUN_200dfb4(10);
    FUN_200e0c4(1, 0x105, 40);
    FUN_200e064(1, 2);
    FUN_200dfb4(20);
    FUN_200d594();
    setActorAnimationIfLoaded(1, 17);
    FUN_200e09c(0x2001, 0, 20);
    playSound(0x83);

    //LAB_200b922
    for(int r5 = 0; r5 < 60; r5++) {
      FUN_200dc20(getMapActor(1));
      sleep(1);
    }

    setActorPriority(1, 1);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5b0"), 0xc80);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5d0"), 0xc80);
    FUN_200df4c(getMapActor(14), 0);
    r6.angle_06.set(0x8000);
    r6.pos_08.set(0x1ac0000, 0xd00000, 0x2480000);
    r6._55.set(0);
    r6._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200d75c", Actor70.class));
    FUN_200dfb4(4);
    setActorVelocityScalerAndAcceleration(14, 0x20000, 0x20000);
    FUN_200df1c(r6, 0x1980000, 0xd00000, 0x2480000);
    FUN_200dfb4(40);
    setActorVelocityScalerAndAcceleration(9, 0x2666, 0x1333);
    setActorVelocityScalerAndAcceleration(14, 0x2666, 0x1333);
    FUN_200df1c(r6, 0x1880000, 0xd00000, 0x2480000);
    FUN_200e014(9, 378, 584);
    FUN_200dfb4(20);
    FUN_200e09c(0x2005, 0, 10);
    r6._6c.clear();
    setActorPriority(1, 2);
    getMapActor(1).flags_23.or(0x1);
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5b0"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5d0"));
    sleep(1);
    FUN_200e07c(1, 0);
    FUN_200e07c(9, 0);
    FUN_200e0ac(1, 0x3000, 0);
    setActorAnimationIfLoaded(1, 1);
    FUN_200d7fc(r6);
    FUN_200d5a4();
    FUN_200dfb4(10);
    FUN_200e024(5, 424, 624);
    FUN_200e074(1, 5, 60);
    FUN_200e064(1, 2);
    FUN_200dfb4(10);
    FUN_200e09c(0x6001, 0, 20);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200dfb4(10);
    FUN_200e09c(5, 0, 20);
    FUN_200e0c4(1, 0x102, 40);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e09c(5, 0, 20);
    FUN_200e0c4(1, 0x101, 80);
    FUN_200e064(5, 1);
    FUN_200dfb4(10);
    FUN_200e09c(5, 0, 20);
    FUN_200e0c4(1, 0x102, 80);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e09c(5, 0, 20);
    setActorAnimationAndWaitUntilFinished(1, 3);
    FUN_200dfb4(10);
    FUN_200e024(5, 388, 604);
    FUN_200e0ac(5, 0xa000, 20);
    FUN_200e064(5, 2);
    FUN_200dfb4(10);
    FUN_200e09c(0x1005, 0, 20);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e0c4(1, 0x105, 40);
    FUN_200e064(1, 2);
    FUN_200dfb4(10);
    FUN_200e0ac(5, 0, 0);
    FUN_200e0ac(1, 32768, 40);
    FUN_200e0b4(1, 1, 2, 25, 2, 5, 10, 14, 4, 14);
    FUN_200dfb4(40);
    FUN_200e0cc(5, 0x102);
    FUN_200e0cc(1, 0x102);
    FUN_200dfb4(80);
    FUN_200e0c4(5, 0x101, 40);
    FUN_200e09c(0x1005, 0, 20);
    FUN_200e0cc(1, 0x102);
    FUN_200dfb4(80);
    setActorAnimationAndWaitUntilFinished(1, 4);
    FUN_200dfb4(10);
    FUN_200e0c4(5, 0x101, 40);
    FUN_200e09c(0x1005, 0, 20);
    FUN_200e064(1, 2);
    FUN_200dfb4(40);
    setActorAnimationAndWaitUntilFinished(1, 4);
    FUN_200dfb4(20);
    FUN_200e0c4(5, 0x101, 80);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e09c(0x1005, 0, 10);
    FUN_200e0ac(5, 0x1000, 40);
    FUN_200e06c(5, 1, 40);
    FUN_200e064(1, 2);
    FUN_200dfb4(10);
    FUN_200e024(5, 380, 620);
    FUN_200dfb4(10);
    FUN_200e09c(0x1005, 0, 10);
    FUN_200e0ac(1, 0x5000, 30);
    FUN_200e0cc(1, 0x102);
    FUN_200dfb4(80);
    FUN_200e064(1, 2);
    FUN_200dfb4(10);
    FUN_200e09c(0x6001, 0, 20);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e0c4(1, 0x101, 80);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    setActorVelocityScalerAndAcceleration(1, 0xcccc, 0x6666);
    FUN_200e024(1, 412, 604);
    FUN_200e0ac(1, 0x5000, 20);
    FUN_200e064(5, 1);
    FUN_200dfb4(10);
    FUN_200e09c(0x1005, 0, 20);
    FUN_200e0c4(1, 0x101, 80);
    FUN_200e054(5, 4, 30);
    FUN_200e09c(0x1005, 0, 20);
    FUN_200e064(1, 3);
    FUN_200dfb4(10);
    FUN_200e09c(0x6001, 0, 20);
    FUN_200dfb4(30);
    FUN_200e0ac(5, 0xe000, 40);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200e09c(0x1005, 0, 20);
    FUN_200e0c4(1, 0x101, 80);
    FUN_200e0c4(5, 0x103, 40);
    setActorVelocityScalerAndAcceleration(5, 0xcccc, 0x6666);
    FUN_200e01c(5, 428, 628);
    FUN_200dfb4(20);
    FUN_200e0ac(1, 0x3000, 0);
    FUN_200e034(5);
    FUN_200e094(0x5001, 0);
    setActorAnimationIfLoaded(5, 1);
    FUN_200dfb4(60);
    FUN_200e0ac(5, 0xb000, 30);
    FUN_200e064(1, 2);
    FUN_200e024(5, 428, 628);
    FUN_200e0ac(5, 0xb000, 20);
    FUN_200e064(1, 3);
    FUN_200dfb4(10);
    setActorAnimationAndWaitUntilFinished(5, 4);
    FUN_200dfb4(10);
    FUN_200e09c(0x2005, 0, 20);
    FUN_200e0cc(1, 0x102);
    FUN_200dfb4(40);
    FUN_200e09c(0x5001, 0, 20);
    setActorAnimationIfLoaded(1, 3);
    setActorAnimationAndWaitUntilFinished(5, 3);
    FUN_200dfb4(10);
    setActorVelocityScalerAndAcceleration(5, 0x8000, 0x4000);
    setActorVelocityScalerAndAcceleration(1, 0x8000, 0x4000);
    FUN_200e01c(5, 450, 750);
    FUN_200e01c(1, 450, 750);
    FUN_200dfb4(60);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c8.set(60);
    FUN_200e10c();
    FUN_200e114();
    FUN_200e0fc(12);
    FUN_200dfc4();
  }

  @Method(0x200bfb0)
  public static void FUN_200bfb0() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    Actor70 r7;

    CPU.sp().value -= 0x1c;
    final Actor70 r11 = getMapActor(0);
    FUN_200dfbc();
    FUN_200e0e4(-1, -1, -1, 0);
    sleep(1);
    FUN_200df3c(49, 53, 8, 4, 20, 50);
    FUN_200df34(2, 102, 84, 41, 2, 1);
    FUN_200df34(1, 102, 83, 41, 1, 1);
    FUN_200df34(0, 103, 82, 42, 1, 1);
    FUN_200e03c(21, 0x1880000, 0x3800000);
    getMapActor(21).angle_06.set(0xc000);
    FUN_200e03c(1, 0x12a0000, 0x2e00000);
    getMapActor(1).angle_06.set(0x4000);
    FUN_200e03c(5, 0x12a0000, 0x2f80000);
    getMapActor(5).angle_06.set(0x4000);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 0x200e590);
    r7 = getMapActor(23);
    r7._55.set(0);
    r7.pos_08.set(0x1840000, 0xa00000, 0x3480000);
    FUN_200df4c(r7, 0);
    r7 = getMapActor(24);
    r7._55.set(0);
    r7.pos_08.set(0x1840000, 0xa00000, 0x34c0000);
    FUN_200df4c(r7, 0);
    r7 = getMapActor(25);
    r7._55.set(0);
    r7.pos_08.set(0x1840000, 0xa00000, 0x3500000);
    FUN_200df4c(r7, 0);
    FUN_200e0f4()._55.set(0);
    sleep(1);
    FUN_200e0e4(0x17f0000, 0xa00000, 0x36d0000, 0);
    FUN_200df14();
    sleep(1);
    r3 = MEMORY.ref(4, 0x3001ebc).get();
    MEMORY.ref(4, r3 + 0x1c8).setu(32);
    FUN_200e104();
    setActorVelocityScalerAndAcceleration(5, 0x8000, 0x4000);
    setActorVelocityScalerAndAcceleration(1, 0x8000, 0x4000);
    FUN_200dff4(5, 0x200e614);
    FUN_200dff4(1, 0x200e5cc);
    FUN_200dfb4(40);
    FUN_200dff4(0, 1);
    r11.scale_18.set(0x10000);
    r11._1c.set(0x10000);
    FUN_200e0ac(0, 0xb000, 40);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200dfb4(10);
    setActorVelocityScalerAndAcceleration(0, 0x4ccc, 0x2666);
    FUN_200e024(0, 400, 840);
    FUN_200dfb4(10);
    FUN_200e0ac(0, 0xc000, 30);
    FUN_200e064(0, 1);
    FUN_200dfb4(20);
    FUN_200e0ac(0, 0x8000, 40);
    FUN_200d594();
    setActorAnimationIfLoaded(0, 17);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"), 0xc80);

    //LAB_200c1f0
    for(r5 = 0; r5 < 40; r5++) {
      FUN_200dc20(r11);
      sleep(1);
    }

    setActorPriority(0, 1);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"), 0xc80);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5e0"), 0xc80);
    setActorVelocityScalerAndAcceleration(23, 0x3333, 0x1999);
    FUN_200e014(23, 390, 832);
    FUN_200e0ac(0, 0xc000, 0);
    FUN_200e014(23, 400, 826);
    FUN_200dfb4(20);
    getMapActor(0).flags_23.or(0x1);
    setActorAnimationIfLoaded(0, 1);
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5e0"));
    sleep(1);
    FUN_200e07c(0, 0);
    FUN_200e07c(23, 0);
    FUN_200e03c(23, 0, 0);
    FUN_200dfb4(20);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 0x200e590);
    FUN_200dfb4(120);
    FUN_200df34(7, 102, 84, 41, 2, 1);
    FUN_200dff4(0, 1);
    r11.scale_18.set(0x10000);
    r11._1c.set(0x10000);
    setActorAnimationIfLoaded(0, 1);
    FUN_200dfb4(40);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200e024(0, 377, 843);
    FUN_200e0ac(0, 0xc000, 40);
    FUN_200e0ac(0, 0, 20);
    setActorAnimationIfLoaded(0, 17);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"), 0xc80);

    //LAB_200c332
    for(r5 = 0; r5 < 40; r5++) {
      FUN_200dc20(r11);
      sleep(1);
    }

    setActorPriority(0, 1);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"), 0xc80);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5f0"), 0xc80);
    setActorVelocityScalerAndAcceleration(24, 0x3333, 0x1999);
    FUN_200e014(24, 390, 832);
    FUN_200e0ac(0, 0xc000, 0);
    FUN_200e014(24, 377, 828);
    FUN_200dfb4(20);
    getMapActor(0).flags_23.or(0x1);
    setActorAnimationIfLoaded(0, 1);
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5f0"));
    sleep(1);
    FUN_200e07c(0, 0);
    FUN_200e07c(24, 0);
    FUN_200e03c(24, 0, 0);
    FUN_200dfb4(20);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 0x200e590);
    FUN_200dfb4(120);
    FUN_200df34(6, 102, 83, 41, 1, 1);
    FUN_200dff4(0, 1);
    r11.scale_18.set(0x10000);
    r11._1c.set(0x10000);
    setActorAnimationIfLoaded(0, 1);
    FUN_200dfb4(40);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_200e024(0, 360, 855);
    FUN_200e0ac(21, 0xb000, 10);
    FUN_200e0ac(0, 0xc000, 30);
    FUN_200e0ac(0, 0xd000, 20);
    setActorAnimationIfLoaded(0, 17);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"), 0xc80);

    //LAB_200c4cc
    for(r5 = 0; r5 < 40; r5++) {
      FUN_200dc20(r11);
      sleep(1);
    }

    setActorPriority(0, 1);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"), 0xc80);
    setTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d600"), 0xc80);
    setActorVelocityScalerAndAcceleration(25, 0x3333, 0x1999);
    FUN_200e014(25, 390, 832);
    FUN_200e0ac(0, 0xc000, 0);
    FUN_200e014(25, 360, 837);
    FUN_200dfb4(20);
    getMapActor(0).flags_23.or(0x1);
    setActorAnimationIfLoaded(0, 1);
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200da08"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d5c0"));
    clearTickCallback(getRunnable(Map4Overlay_8780898.class, "FUN_200d600"));
    sleep(1);
    FUN_200e07c(0, 0);
    FUN_200e07c(25, 0);
    FUN_200e03c(25, 0, 0);
    FUN_200dfb4(20);
    setActorAnimationIfLoaded(0, 11);
    FUN_200dff4(0, 0x200e590);
    FUN_200dfb4(120);
    FUN_200d5a4();
    FUN_200df34(5, 103, 82, 42, 1, 1);
    FUN_200dff4(0, 1);
    r11.scale_18.set(0x10000);
    r11._1c.set(0x10000);
    r1 = 0x2;
    r2 = 0x14;
    r0 = 0x15;
    FUN_200e054(r0, r1, r2);
    r0 = 0xf03;
    FUN_200e084(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 5;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r3 = 0x0;
    r0 = 0x15;
    r1 = 0x5;
    r2 = 0x6;
    FUN_200b2b0(r0, r1, r2, r3);
    r0 = 0x15;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xd0;
    r1 = 0x18d;
    r2 = r2 << 2;
    r0 = 0x15;
    FUN_200e024(r0, r1, r2);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x3c;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x3c;
    r0 = 0x15;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xba;
    r2 = 0xd0;
    r1 = r1 << 1;
    r2 = r2 << 2;
    r0 = 0x15;
    FUN_200e024(r0, r1, r2);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x28;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x28;
    r0 = 0x15;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x14;
    r0 = 0x15;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x0;
    r0 = 0x15;
    FUN_200e08c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200dfdc(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x15;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
    } else {
      //LAB_200c71c
      r0 = 0x15;
      r1 = 0x4;
      setActorAnimationAndWaitUntilFinished(r0, r1);
    }

    //LAB_200c724
    r1 = 0x0;
    r2 = 0x14;
    r0 = 0x15;
    FUN_200e09c(r0, r1, r2);
    r0 = 0xf0a;
    FUN_200e084(r0);
    r1 = 0xc1;
    r1 = r1 << 1;
    r2 = 0x349;
    r0 = 0x15;
    FUN_200e024(r0, r1, r2);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0xd0;
    r2 = 0x3c;
    r0 = 0x15;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x1e;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x15;
    FUN_200e08c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200dfdc(r0, r1);
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

    //LAB_200c794
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0x3c;
    r0 = 0x15;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x15;
    FUN_200e064(r0, r1);
    r0 = 0xf0e;
    FUN_200e084(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xc1;
    r2 = 0x339;
    r1 = r1 << 1;
    r0 = 0x15;
    FUN_200e024(r0, r1, r2);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0x4;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x3c;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xba;
    r2 = 0xd0;
    r0 = 0x15;
    r1 = r1 << 1;
    r2 = r2 << 2;
    FUN_200e024(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0xa;
    r0 = 0x15;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x3;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x3c;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x6666;
    r1 = 0xccc;
    FUN_200e0dc(r0, r1);
    r1 = 0xa0;
    r2 = 0xd7;
    r3 = 0x1;
    r0 = 0x1790000;
    r1 = r1 << 16;
    r2 = r2 << 18;
    FUN_200e0e4(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x5;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x1;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xe2;
    r0 = 0x1;
    r1 = 0x171;
    r2 = r2 << 2;
    FUN_200e01c(r0, r1, r2);
    r1 = 0xc4;
    r2 = 0xe2;
    r2 = r2 << 2;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200e024(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r3 = 0x0;
    r0 = 0x5;
    r1 = 0xa;
    r2 = 0xb;
    FUN_200b2b0(r0, r1, r2, r3);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x15;
    FUN_200e064(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0xc0;
    r0 = 0x15;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 5;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200e054(r0, r1, r2);
    r1 = 0xc4;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x34b;
    FUN_200e024(r0, r1, r2);
    r1 = 0x90;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x15;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0x14;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r3 = 0x0;
    r0 = 0x1;
    r1 = 0xa;
    r2 = 0xb;
    FUN_200b2b0(r0, r1, r2, r3);
    r0 = 0x5;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xc4;
    r1 = r1 << 1;
    r2 = 0x34b;
    r0 = 0x1;
    FUN_200e01c(r0, r1, r2);
    r1 = 0xcc;
    getMapActor(5)._5a.and(~0x1);
    r1 = r1 << 1;
    r2 = 0x34b;
    r0 = 0x5;
    FUN_200e024(r0, r1, r2);
    r0 = 0x1;
    FUN_200dfb4(r0);
    r1 = 0x80;
    getMapActor(5)._5a.or(0x1);
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x5;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    FUN_200e034(r0);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x1e;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x4;
    r2 = 0x1e;
    FUN_200e054(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0xa0;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0x1e;
    r0 = 0x0;
    r1 = 0x2;
    FUN_200e054(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x0;
    FUN_200e0cc(r0, r1);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x15;
    r1 = r1 << 6;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x101;
    r2 = 0x50;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x1e;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x3c;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x15;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x50;
    FUN_200dfb4(r0);
    r2 = 0x1e;
    r0 = 0x5;
    r1 = 0x1;
    FUN_200e074(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e05c(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200e064(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x105;
    r2 = 0x3c;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r2 = 0xa;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x15;
    FUN_200e05c(r0, r1);
    r0 = 0x28;
    FUN_200dfb4(r0);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x9999;
    r1 = 0x1333;
    FUN_200e0dc(r0, r1);
    r1 = 0xa0;
    r3 = 0x1;
    r0 = 0x1750000;
    r1 = r1 << 16;
    r2 = 0x3450000;
    FUN_200e0e4(r0, r1, r2, r3);
    r1 = 0xb6;
    r2 = 0xcc;
    r0 = 0x15;
    r1 = r1 << 1;
    r2 = r2 << 2;
    FUN_200e024(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x15;
    r1 = r1 << 6;
    r2 = 0xa;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200e09c(r0, r1, r2);
    r2 = 0x1e;
    r0 = 0x5;
    r1 = 0x1;
    FUN_200e074(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e05c(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x0;
    r1 = 0x105;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x15;
    FUN_200e08c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200dfdc(r0, r1);
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

    //LAB_200ccda
    r1 = 0x0;
    r2 = 0x14;
    r0 = 0x15;
    FUN_200e09c(r0, r1, r2);
    r0 = 0xf27;
    FUN_200e084(r0);
    r2 = 0x0;
    r0 = 0x15;
    r1 = 0x103;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    FUN_200e064(r0, r1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x15;
    r1 = 0x4;
    FUN_200e054(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    FUN_200e064(r0, r1);
    r1 = 0x7;
    r0 = 0x15;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    FUN_200dfb4(r0);
    FUN_200e0b4(21, 14, 2, 24, 2, 1, 10, 14, 4, 14);
    playSound(0xa1);
    r7 = getMapActor(21);
    r7.sprite_50.deref()._26.set(0);
    r7._5a.and(~0x1);
    setActorVelocityScalerAndAcceleration(21, 0x30000, 0x18000);
    r1 = 0xb6;
    r0 = 0x15;
    r1 = r1 << 1;
    r2 = 0x32f;
    FUN_200e024(r0, r1, r2);
    r0 = 0x4;
    FUN_200dfb4(r0);
    r5 = 0x0;

    //LAB_200cd8a
    do {
      r7.pos_08.z_08.add(0x18000);
      r7._1c.sub(0x1999);
      r5 = r5 + 0x1;
      FUN_200dfb4(1);
    } while(r5 != 0x4);

    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200e03c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 10;
    r2 = r2 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200e054(r0, r1, r2);
    r1 = 0xbb;
    r2 = 0x33b;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200e024(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    FUN_200e094(r0, r1);
    r1 = 0xb0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200e05c(r0, r1);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xd;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x2;
    r2 = 0x5;
    r0 = 0x1;
    FUN_200e054(r0, r1, r2);
    r0 = 0x8f;
    playSound(r0);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 11;
    r2 = r2 << 9;
    FUN_200df54(r0, r1, r2);
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r2 = 0x53;
    r3 = 0x29;
    r1 = 0x66;
    r0 = 0x1;
    FUN_200df34(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    FUN_200df4c(getMapActor(1), 0);
    r1 = 0xd0;
    r2 = 0xa;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    FUN_200e05c(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    r0 = -r0;
    r1 = -r1;
    r2 = 0xe666;
    FUN_200df54(r0, r1, r2);
    FUN_200df5c();
    r1 = 0x81;
    r2 = 0x50;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r3 = 0x80;
    r3 = r3 << 8;
    r1 = 0xb6;
    r7._1c.set(r3);
    r0 = 0x15;
    r1 = r1 << 17;
    r2 = 0x32b0000;
    FUN_200e03c(r0, r1, r2);
    r5 = 0x0;

    //LAB_200ce9c
    do {
      r7._1c.add(0x1999);
      FUN_200dfb4(1);
      r5 = r5 + 0x1;
    } while(r5 != 0x5);

    r0 = 0x3c;
    FUN_200dfb4(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r1 = 0xa0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e05c(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200e064(r0, r1);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r1 = 0x2;
    r0 = 0x15;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x4ccc;
    r1 = 0x999;
    FUN_200e0dc(r0, r1);
    r0 = 0xba;
    r1 = 0xa0;
    r3 = 0x1;
    r0 = r0 << 17;
    r1 = r1 << 16;
    r2 = 0x35b0000;
    FUN_200e0e4(r0, r1, r2, r3);
    r1 = 0xc0;
    r2 = 0xc0;
    r0 = 0x15;
    r1 = r1 << 10;
    r2 = r2 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200e054(r0, r1, r2);
    r1 = 0x167;
    r2 = 0x343;
    r0 = 0x15;
    FUN_200e024(r0, r1, r2);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x15;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r7.flags_23.and(~0x1);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x50;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x101;
    r2 = 0x50;
    FUN_200e0c4(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    FUN_200e064(r0, r1);
    r2 = 0xa;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x15;
    FUN_200e0cc(r0, r1);
    r0 = 0x50;
    FUN_200dfb4(r0);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x28;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x50;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x1;
    FUN_200e064(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0x3;
    r0 = 0x1;
    FUN_200e064(r0, r1);
    FUN_200df4c(getMapActor(1), 1);
    r2 = 0x0;
    r0 = 0x1;
    r1 = 0x6;
    FUN_200e054(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 11;
    r2 = r2 << 10;
    r0 = 0x1;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    getMapActor(1)._5a.and(~0x1);
    r0 = 0x1;
    r2 = 0x33b;
    r1 = 0x193;
    FUN_200e00c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x5;
    r1 = r1 << 1;
    FUN_200e0cc(r0, r1);
    r1 = 0xc0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x0;
    r2 = 0x1;
    r0 = 0x5;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    FUN_200e034(r0);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xd;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x5;
    r1 = 0x2;
    r0 = 0x1;
    FUN_200e054(r0, r1, r2);
    FUN_200df4c(getMapActor(1), 0);
    r3 = 0x2;
    r2 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 = 0x29;
    r1 = 0x66;
    r2 = 0x54;
    r0 = 0x2;
    FUN_200df34(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x8f;
    playSound(r0);
    r1 = 0x80;
    r2 = 0x80;
    r2 = r2 << 9;
    r0 = 0x0;
    r1 = r1 << 11;
    FUN_200df54(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    FUN_200e064(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    r0 = -r0;
    r1 = -r1;
    r2 = 0xe666;
    FUN_200df54(r0, r1, r2);
    FUN_200df5c();
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x1e;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xcc;
    r2 = 0x357;
    r1 = r1 << 1;
    r0 = 0x5;
    FUN_200e024(r0, r1, r2);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e064(r0, r1);
    r2 = 0x3c;
    r0 = 0x15;
    r1 = 0x105;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x3;
    FUN_200e05c(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    FUN_200e064(r0, r1);
    r0 = 0x50;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x1;
    FUN_200e064(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r1 = 0x4;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x50;
    FUN_200dfb4(r0);
    r1 = 0x3;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x3c;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x3c;
    r0 = 0x15;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x4;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x50;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x105;
    r2 = 0x50;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x3c;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200e0c4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200e0c4(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0x4;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_200dfb4(r0);
    r2 = 0x3c;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200e05c(r0, r1);
    r1 = 0x2;
    r0 = 0x5;
    FUN_200e064(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x3c;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x1e;
    FUN_200e0ac(r0, r1, r2);
    r2 = 0x1e;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r2 = 0x1e;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x4;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x5;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x3;
    r0 = 0x1;
    FUN_200e064(r0, r1);
    r0 = 0xa;
    FUN_200dfb4(r0);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200e09c(r0, r1, r2);
    r1 = 0xd0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x15;
    r1 = r1 << 1;
    FUN_200e0c4(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x15;
    FUN_200e064(r0, r1);
    r0 = 0x1e;
    FUN_200dfb4(r0);
    r2 = 0x3c;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200e09c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x3;
    FUN_200e064(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r2 = r2 << 8;
    r1 = r1 << 9;
    r0 = 0x1;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    FUN_200df4c(getMapActor(1), 0);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200e054(r0, r1, r2);
    r1 = 0xc7;
    r2 = 0xcf;
    r1 = r1 << 1;
    r2 = r2 << 2;
    r0 = 0x1;
    FUN_200e024(r0, r1, r2);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r1 = 0x80;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x3c;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_200dfb4(r0);
    r1 = 0x3;
    r0 = 0x15;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    FUN_200dfb4(60);
    getMapActor(1)._5a.or(0x1);
    getMapActor(5)._5a.or(0x1);
    r7 = getMapActor(0);
    setActorVelocityScalerAndAcceleration(1, 0x10000, 0x8000);
    setActorVelocityScalerAndAcceleration(5, 0x10000, 0x8000);
    FUN_200e0ac(0, 0, 0);
    FUN_200e01c(5, (r7.pos_08.getX() >> 16) + 0x10, r7.pos_08.getZ() >> 16);
    FUN_200e024(1, (r7.pos_08.getX() >> 16) + 0x10, (r7.pos_08.getZ() >> 16) - 0x10);
    FUN_200e034(1);
    r1 = 0xa0;
    r2 = 0x1e;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200e0ac(r0, r1, r2);
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
    FUN_200dfb4(r0);
    r1 = r7.pos_08.getX() >> 16;
    r0 = 0x5;
    r2 = r7.pos_08.getZ() >> 16;
    FUN_200e024(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200e03c(r0, r1, r2);
    r1 = r7.pos_08.getX() >> 16;
    r0 = 0x1;
    r2 = r7.pos_08.getZ() >> 16;
    FUN_200e024(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x1;
    r1 = 0x0;
    FUN_200e03c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x5;
    FUN_200dfcc(r0, r1);
    r1 = 0xa0;
    r0 = 0x1790000;
    r1 = r1 << 16;
    r2 = 0x3770000;
    r3 = 0x1;
    FUN_200e0e4(r0, r1, r2, r3);
    r3 = 0x0;
    r0 = 0x0;
    r1 = 0xd;
    r2 = 0xa;
    FUN_200b380(r0, r1, r2, r3);
    r1 = 0xbc;
    r2 = 0xe4;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = r2 << 2;
    FUN_200e024(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    getMapActor(21)._5a.or(0x1);
    r3 = 0x0;
    r0 = 0x15;
    r1 = 0x6;
    r2 = 0x5;
    FUN_200b380(r0, r1, r2, r3);
    r0 = 0x15;
    r1 = 0x175;
    r2 = 0x377;
    FUN_200e024(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x15;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200e0ac(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200e0ac(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200dfb4(r0);
    r1 = 0x1;
    r0 = 0x0;
    FUN_200e0d4(r0, r1);
    FUN_200e0ec();
    r0 = 0x64;
    FUN_200dfb4(r0);
    r3 = 0x14;
    r2 = 0x32;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r1 = 0x2e;
    r2 = 0x8;
    r3 = 0x4;
    r0 = 0x31;
    FUN_200df3c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    setFlag(0x202);
    clearFlag(0x12f);
    r11._55.set(3);
    r11.pos_08.setY(0xa00000);
    r11.dest_38.setY(0x80000000);
    r11.velocity_24.setY(0);
    FUN_200dfc4();
    CPU.sp().value += 0x1c;
  }

  @Method(0x200d594)
  public static void FUN_200d594() {
    FUN_200e124(140, 0);
  }

  @Method(0x200d5a4)
  public static void FUN_200d5a4() {
    FUN_200e12c();
  }

  @Method(0x200d5b0)
  public static void FUN_200d5b0() {
    FUN_200dc5c(getMapActor(1));
  }

  @Method(0x200d5c0)
  public static void FUN_200d5c0() {
    FUN_200dc5c(getMapActor(0));
  }

  @Method(0x200d5d0)
  public static void FUN_200d5d0() {
    FUN_200dc98(getMapActor(9));
  }

  @Method(0x200d5e0)
  public static void FUN_200d5e0() {
    FUN_200dc98(getMapActor(23));
  }

  @Method(0x200d5f0)
  public static void FUN_200d5f0() {
    FUN_200dc98(getMapActor(24));
  }

  @Method(0x200d600)
  public static void FUN_200d600() {
    FUN_200dc98(getMapActor(25));
  }

  @Method(0x200d610)
  public static int deltaMagnitude(final Vec3 r0, final Vec3 r1) {
    final int dx = r0.getX() - r1.getX() >> 16;
    final int dy = r0.getY() - r1.getY() >> 16;
    final int dz = r0.getZ() - r1.getZ() >> 16;
    return sqrt(dx * dx + dy * dy + dz * dz);
  }

  @Method(0x200d64c)
  public static int FUN_200d64c(final Actor70 r0, final Actor70 r1, final int r2, final int r3) {
    if(r0._5b.get() == 1 && r0._62.get() == 0) {
      setActorAnimation(r0, 1);
      return 1;
    }

    //LAB_200d690
    if(deltaMagnitude(r1.pos_08, r0.pos_08) < r2 || r3 != 0) {
      //LAB_200d6ac
      final int angle = atan2(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX()) & 0xffff;
      if((angle & 0xf000) == (r0.angle_06.get() & 0xf000) || (angle + 0x1000 & 0xf000) == (r0.angle_06.get() & 0xf000) || (angle - 0x1000 & 0xf000) == (r0.angle_06.get() & 0xf000) || r3 != 0) {
        //LAB_200d6ec
        r0._5b.set(1);
        setActorAnimation(r0, 1);
        r0._62.set(1);
        return 1;
      }
    }

    //LAB_200d704
    r0._5b.set(r3);
    setActorAnimation(r0, 2);
    r0._62.set(r3);
    return 0;
  }

  @Method(0x200d72c)
  public static int FUN_200d72c(final Actor70 r0) {
    final Actor70 r1 = getMapActor(0);
    if(r0.dest_38.getX() == 0x80000000 && r0.dest_38.getX() == r0.dest_38.getZ()) {
      return 0;
    }

    //LAB_200d74a
    FUN_200d64c(r0, r1, 18, 0);
    return 0;
  }

  @Method(0x200d75c)
  public static void FUN_200d75c(final Actor70 r0) {
    final Vec3 r5 = new Vec3();
    r5.setX(r0.pos_08.getX());
    r5.setY(r0.pos_08.getY() - rand() * 0x10 - 0x80000);
    r5.setZ(r0.pos_08.getZ());
    retVec3(rand() * 0x30, rand(), r5);

    final Actor70 actor = loadActor(0x11d, r5.getX(), r5.getY(), r5.getZ());
    if(actor != null) {
      actor._55.set(2);
      actor._48.set(0x1999);
      actor._5e.set(12);
      FUN_200df4c(actor, 0);
      setActorAnimation(actor, 0);
      setActorSpriteScript(actor, 0x200e6e0);
      actor.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    }

    //LAB_200d7de
    playSound(0x8a);
  }

  @Method(0x200d7fc)
  public static void FUN_200d7fc(final Actor70 r0) {
    playSound(0x9a);

    //LAB_200d810
    for(int i = 0; i < 31; i++) {
      r0.pos_08.y_04.add(0x10000);
      r0.angle_06.add(0x2000);
      r0.scale_18.sub(0x800);
      r0._1c.sub(0x800);
      sleep(1);
    }

    //LAB_200d846
    for(int i = 0; i < 8; i++) {
      final Actor70 r6 = loadActor(0x11d, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      if(r6 != null) {
        FUN_200df4c(r6, 0);
        setActorSpriteScript(r6, 0x200e6e4);
        r6.velocityScalar_30.set(0x10000 + rand());
        r6.acceleration_34.set(0x10000);
        r6._48.set(0xa3d);
        r6._55.set(2);
        r6.velocity_24.setY(rand() - rand());
        FUN_200d8f0(r6, rand() * 0x18 + 0x80000, rand());
      }

      //LAB_200d8ac
    }

    playSound(0x83);
    r0.pos_08.zero();
    r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    r0.velocity_24.zero();
  }

  @Method(0x200d8f0)
  public static void FUN_200d8f0(@Nullable final Actor70 r0, final int r1, final int r2) {
    if(r0 != null) {
      final Vec3 r5 = new Vec3();
      r5.set(r0.pos_08);
      retVec3(r1, r2, r5);
      FUN_200df1c(r0, r5.getX(), r5.getY(), r5.getZ());
    }

    //LAB_200d91e
  }

  /**
   * Event list 0x200f100 handler 44
   */
  @Method(value = 0x200d928, ignoreExtraParams = true)
  public static void FUN_200d928() {
    FUN_200df3c(17, 0, 3, 1, 22, 36);
    FUN_20080c4();
    FUN_200d950();
  }

  /**
   * Event list 0x200f100 handler 42
   */
  @Method(value = 0x200d950, ignoreExtraParams = true)
  public static void FUN_200d950() {
    FUN_200df3c(17, 0, 3, 1, 22, 36);

    final Actor70 r5 = getMapActor(readFlag(0x87a) != 0 ? 21 : 20);
    if(r5 != null) {
      clearFlag(0x314);
      clearFlag(0x315);
      clearFlag(0x316);

      final int r0 = r5.pos_08.getX() >> 20;
      if(r0 == 0x16) {
        FUN_200df3c(17, 1, 1, 1, 22, 36);
        setFlag(0x314);
        //LAB_200d9ba
      } else if(r0 == 0x17) {
        FUN_200df3c(17, 1, 1, 1, 23, 36);
        setFlag(0x315);
      } else {
        //LAB_200d9d8
        FUN_200df3c(17, 1, 1, 1, 24, 36);
        setFlag(0x316);
      }
    }

    //LAB_200d9f2
  }

  @Method(0x200da08)
  public static void FUN_200da08() {
    if((_3001e40.get() & 0xf) == 0) {
      playSound(0x83);
    }
  }

  /**
   * Event list 0x200f100 handler 45
   */
  @Method(value = 0x200da24, ignoreExtraParams = true)
  public static void FUN_200da24() {
    FUN_200dfbc();
    FUN_200df7c(0xee4, 1);
    FUN_200dfc4();
  }

  @Method(0x200da40)
  public static void FUN_200da40() {
    if(readFlag(0x241) != 0) {
      if(readFlag(0x106) == 0) {
        getMapActor(22)._5b.set(0);
        clearFlag(0x241);
      }
    } else {
      //LAB_200da6c
      if(readFlag(0x106) != 0) {
        getMapActor(22)._5b.set(1);
        setFlag(0x241);
      }
    }
  }

  @Method(0x200da94)
  public static void FUN_200da94() {
    final Actor70 r5 = getMapActor(0);
    final Actor70 r0;
    if(readFlag(0x87a) != 0) {
      r0 = getMapActor(21);
    } else {
      //LAB_200dab0
      r0 = getMapActor(20);
    }

    //LAB_200dab6
    if(r0 != null) {
      if(r5.pos_08.getY() > 0xc80000) {
        r0.flags_23.set(0x3);
      } else {
        //LAB_200dacc
        r0.flags_23.set(0x1);
      }
    }
  }

  @Method(0x200dae0)
  public static int FUN_200dae0(final Actor70 r0) {
    int r5 = sin(r0.velocityScalar_30.get()) << 1;
    if(r5 > 0) {
      r5 = -r5;
    }

    //LAB_200daf4
    r0.pos_08.setX(r0.dest_38.getX() + cos(r0.velocityScalar_30.get()) * 2);
    r0.pos_08.setY(r0.dest_38.getY() + r5);
    r0.sprite_50.deref().rotation_1e.set(cos(r0.velocityScalar_30.get() + 0x8000) / 8);
    r0.velocityScalar_30.add((rand() << 9 >>> 16) + (rand() << 9 >>> 16) + 0x400);
    return 0;
  }

  @Method(0x200db48)
  public static void FUN_200db48(final int mapActorSlot) {
    final Actor70 r7 = getMapActor(mapActorSlot);
    final Sprite38 r6 = r7.sprite_50.deref();
    r6.packet_00.attribs_04.flags_01.and(~0x20);
    r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400).and(0xfff);
    r6.layerCount_27.set(0);
    FUN_200df4c(r7, 0);
    r7._5c.set(0);
    r7._55.set(0);
    if(readFlag(0x109) == 0) {
      r7.pos_08.y_04.add(0x200000);
    }

    //LAB_200dbac
    r7.flags_23.and(0xfe);
    r7._61.set(1);
    final int r5 = mallocSlotChip(17, 0x608);
    FUN_200df8c(181);
    allocateSpriteSlot(r6.slot_1c.get(), 0x80, r5 + 0x400);
    freeSlot(17);
    r7.velocityScalar_30.set(0);
    r7.dest_38.setX(r7.pos_08.getX());
    r7.dest_38.setY(r7.pos_08.getY());
    r7._56.set(0);
    r7._5c.set(1);
    r7._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200dae0", Actor70.class));
  }

  @Method(0x200dc20)
  public static void FUN_200dc20(final Actor70 r0) {
    if((_3001e40.get() & 0x2) == 0) {
      //LAB_200dc38
      FUN_200df74(r0, 0);
    } else {
      FUN_200df74(r0, 7);
    }

    //LAB_200dc40
    if((_3001e40.get() & 0xf) == 0) {
      FUN_200dd68(r0);
    }
  }

  @Method(0x200dc5c)
  public static void FUN_200dc5c(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_200df74(r0, FUN_30003e0(_3001e40.get() >>> 1, 6));
    }

    //LAB_200dc7e
    if((_3001e40.get() & 0xf) == 0) {
      FUN_200dd68(r0);
    }
  }

  @Method(0x200dc98)
  public static void FUN_200dc98(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_200df74(r0, FUN_30003e0(_3001e40.get() >>> 1, 6));
    }
  }

  @Method(0x200dcc4)
  public static void FUN_200dcc4(final Actor70 r0) {
    final Actor70 r6 = r0.parent_68.deref();
    r0._64.incr();
    final int r0_0 = r0._64.get();
    if(r0_0 > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200dce4
      final int r0_1 = sin(r0_0 << 10);
      r0.scale_18.set(r0_1);
      r0._1c.set(r0_1);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.setZ(r6.pos_08.getZ() + (0x10000 - r0_1) * 5 + 0x80000);
    }
  }

  @Method(0x200dd14)
  public static void FUN_200dd14(final Actor70 r0) {
    final Actor70 r6 = r0.parent_68.deref();
    r0._64.incr();
    final int r0_0 = r0._64.get();
    if(r0_0 > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200dd34
      final int r0_1 = sin(r0_0 << 10);
      r0.scale_18.set(r0_1);
      r0._1c.set(-r0_1);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.setZ(r6.pos_08.getZ() - (0x10000 - r0_1) * 5 + 0x100000);
    }
  }

  @Method(0x200dd68)
  public static void FUN_200dd68(final Actor70 r0) {
    final FieldPsynergy720 r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70[] r10 = new Actor70[2];

    //LAB_200dd88
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 actor = loadActor(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      r10[r7] = actor;

      if(actor != null) {
        actor._14.set(r0._14.get());
        actor._55.set(0);
        actor._64.set(0);
        actor.parent_68.set(r0);

        final Sprite38 r5 = actor.sprite_50.deref();
        if(r5 != null) {
          setSpriteAnimation(r5, 0);
          r5._26.set(0);
          clearVramSlot(r5.slot_1c.get());
          r5.slot_1c.set(r11.vramSlot_46.get());
          r5._1d.or(0x1);
          final VramSlot04 r3 = vramSlots_3001b10.get(r5.slot_1c.get());
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(r3.vramAddr_02.get() << 17 >>> 22);
          r5.packet_00.attribs_04.flags_01.and(~0x20).and(0x3f).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_200de34
    }

    r10[0]._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200dd14", Actor70.class));
    r10[0].sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    final Actor70 r1 = r10[1];
    r1.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    r1.flags_23.set(2);
    r1._6c.set(getConsumer(Map4Overlay_8780898.class, "FUN_200dcc4", Actor70.class));
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200de8c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200de94)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200de9c)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200dea4)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#retVec3} */
  @Method(0x200dec4)
  public static void retVec3(final int distance, final int angle, final Vec3 vec) {
    MEMORY.call(0x8000128, distance, angle, vec);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200decc)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200ded4)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#clearVramSlot_} */
  @Method(0x200dedc)
  public static int clearVramSlot(final int slot) {
    return (int)MEMORY.call(0x80001b8, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200dee4)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setSpriteAnimation_} */
  @Method(0x200deec)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x8009020, sprite, animation);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200def4)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200defc)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    MEMORY.call(0x8009098, actor, script);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200df04)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200df14)
  public static void FUN_200df14() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009150} */
  @Method(0x200df1c)
  public static void FUN_200df1c(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009158} */
  @Method(0x200df24)
  public static void FUN_200df24(final Actor70 r0) {
    MEMORY.call(0x8009158, r0);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200df2c)
  public static void FUN_200df2c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200df34)
  public static void FUN_200df34(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200df3c)
  public static void FUN_200df3c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091d8} */
  @Method(0x200df44)
  public static int FUN_200df44(final Actor70 r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80091d8, r0, r1);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200df4c)
  public static void FUN_200df4c(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200df54)
  public static void FUN_200df54(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_80091f8} */
  @Method(0x200df5c)
  public static void FUN_200df5c() {
    MEMORY.call(0x80091f8);
  }

  /** {@link GoldenSun#FUN_8009208} */
  @Method(0x200df64)
  public static void FUN_200df64() {
    MEMORY.call(0x8009208);
  }

  /** {@link GoldenSun#FUN_8009210} */
  @Method(0x200df6c)
  public static void FUN_200df6c() {
    MEMORY.call(0x8009210);
  }

  /** {@link GoldenSun#FUN_8009240} */
  @Method(0x200df74)
  public static void FUN_200df74(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009240, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200df7c)
  public static void FUN_200df7c(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015210} */
  @Method(0x200df84)
  public static void FUN_200df84(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200df8c)
  public static void FUN_200df8c(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_801#FUN_8015360} */
  @Method(0x200df94)
  public static void FUN_200df94(final int r0, final int r1) {
    MEMORY.call(0x8015360, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200df9c)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200dfa4)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200dfac)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200dfb4)
  public static void FUN_200dfb4(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200dfbc)
  public static void FUN_200dfbc() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200dfc4)
  public static void FUN_200dfc4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a050} */
  @Method(0x200dfcc)
  public static void FUN_200dfcc(final int r0, final int r1) {
    MEMORY.call(0x808a050, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a060} */
  @Method(0x200dfd4)
  public static int FUN_200dfd4(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a060, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200dfdc)
  public static int FUN_200dfdc(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200dfe4)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200dfec)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200dff4)
  public static void FUN_200dff4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x200dffc)
  public static void FUN_200dffc(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200e004)
  public static void FUN_200e004(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200e00c)
  public static void FUN_200e00c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200e014)
  public static void FUN_200e014(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200e01c)
  public static void FUN_200e01c(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200e024)
  public static void FUN_200e024(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200e034)
  public static void FUN_200e034(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x200e03c)
  public static void FUN_200e03c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200e044)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200e04c)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200e054)
  public static void FUN_200e054(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200e05c)
  public static void FUN_200e05c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200e064)
  public static void FUN_200e064(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200e06c)
  public static void FUN_200e06c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200e074)
  public static void FUN_200e074(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200e07c)
  public static void FUN_200e07c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200e084)
  public static void FUN_200e084(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200e08c)
  public static Panel24 FUN_200e08c(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200e094)
  public static void FUN_200e094(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200e09c)
  public static void FUN_200e09c(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x200e0a4)
  public static int FUN_200e0a4(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200e0ac)
  public static void FUN_200e0ac(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1d0} */
  @Method(0x200e0b4)
  public static void FUN_200e0b4(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    MEMORY.call(0x808a1d0, r0, r1, r2, r3, a4, a5, a6, a7, a8, a9);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200e0bc)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200e0c4)
  public static void FUN_200e0c4(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200e0cc)
  public static void FUN_200e0cc(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x200e0d4)
  public static void FUN_200e0d4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200e0dc)
  public static void FUN_200e0dc(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200e0e4)
  public static void FUN_200e0e4(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200e0ec)
  public static void FUN_200e0ec() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a228} */
  @Method(0x200e0f4)
  public static Actor70 FUN_200e0f4() {
    return (Actor70)MEMORY.call(0x808a228);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200e0fc)
  public static void FUN_200e0fc(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200e104)
  public static void FUN_200e104() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200e10c)
  public static void FUN_200e10c() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200e114)
  public static void FUN_200e114() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a398} */
  @Method(0x200e11c)
  public static void FUN_200e11c(final int r0, final int r1) {
    MEMORY.call(0x808a398, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x200e124)
  public static void FUN_200e124(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x200e12c)
  public static void FUN_200e12c() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#FUN_808a4f0} */
  @Method(0x200e134)
  public static void FUN_200e134() {
    MEMORY.call(0x808a4f0);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x200e13c)
  public static void FUN_200e13c(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a5e8} */
  @Method(0x200e144)
  public static void FUN_200e144() {
    MEMORY.call(0x808a5e8);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200e14c)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
