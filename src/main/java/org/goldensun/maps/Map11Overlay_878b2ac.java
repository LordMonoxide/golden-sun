package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;

import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map11Overlay_878b2ac {
  private Map11Overlay_878b2ac() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    final int r0;

    r0 = 0x200aafc;
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

    r0 = 0x200abec;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008044)
  public static int getActors() {
    final int r0;

    r0 = 0x200ac14;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200804c)
  public static int getEvents() {
    final int r0;

    r0 = 0x200ad34;
    return r0;
  }

  /**
   * Event list 0x200ad34 handler 2
   */
  @Method(value = 0x2008054, ignoreExtraParams = true)
  public static void FUN_2008054() {
    int r0;
    final int r1;

    r0 = FUN_200a5b0();
    if(r0 != 0x0) {
      r0 = 0x201;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        FUN_200a9d4();
        r1 = 0x1;
        r0 = 0x2051cc;
        FUN_200aabc(r0, r1);
        r0 = 0x14;
        FUN_200aacc(r0);
        r0 = 0x201;
        setFlag(r0);
        r0 = 0x80;
        r0 = r0 << 2;
        clearFlag(r0);
        r0 = 0x202;
        clearFlag(r0);
        r0 = 0x80a;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_20089f4();
        }

        //LAB_200809c
        r0 = FUN_200a5b0();
        if(r0 != 0x0) {
          r0 = 0x811;
          r0 = readFlag(r0);
          if(r0 == 0x0) {
            FUN_2009be8();
          }
        }

        //LAB_20080b2
        FUN_200a9dc();
      }
    } else {
      //LAB_20080b8
      r0 = 0x80;
      r0 = r0 << 2;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        FUN_200a9d4();
        r0 = 0x80;
        r1 = 0x1;
        r0 = r0 << 9;
        FUN_200aabc(r0, r1);
        r0 = 0x14;
        FUN_200aacc(r0);
        r0 = 0x80;
        r0 = r0 << 2;
        setFlag(r0);
        r0 = 0x201;
        clearFlag(r0);
        r0 = 0x202;
        clearFlag(r0);
        FUN_200a9dc();
      }
    }
  }

  /**
   * Event list 0x200ad34 handler 3
   */
  @Method(value = 0x2008108, ignoreExtraParams = true)
  public static void FUN_2008108() {
    int r0;
    final int r1;

    r0 = 0x80;
    r0 = r0 << 2;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      FUN_200a9d4();
      r0 = 0x80;
      r1 = 0x1;
      r0 = r0 << 9;
      FUN_200aabc(r0, r1);
      r0 = 0x14;
      FUN_200aacc(r0);
      r0 = 0x80;
      r0 = r0 << 2;
      setFlag(r0);
      r0 = 0x201;
      clearFlag(r0);
      r0 = 0x202;
      clearFlag(r0);
      FUN_200a9dc();
    }
  }

  /**
   * Event list 0x200ad34 handler 1
   */
  @Method(value = 0x2008150, ignoreExtraParams = true)
  public static void FUN_2008150() {
    int r0;
    final int r1;

    r0 = FUN_200a5b0();
    if(r0 != 0x0 && readFlag(0x200) == 0x0) {
      FUN_200a9d4();
      r0 = 0x80;
      r1 = 0x1;
      r0 = r0 << 9;
      FUN_200aabc(r0, r1);
      r0 = 0x14;
      FUN_200aacc(r0);
      r0 = 0x80;
      r0 = r0 << 2;
      setFlag(r0);
      r0 = 0x201;
      clearFlag(r0);
      r0 = 0x202;
      clearFlag(r0);
      FUN_200a9dc();
    } else {
      //LAB_2008194
      r0 = 0x201;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        FUN_200a9d4();
        r1 = 0x1;
        r0 = 0x2051cc;
        FUN_200aabc(r0, r1);
        r0 = 0x14;
        FUN_200aacc(r0);
        r0 = 0x201;
        setFlag(r0);
        r0 = 0x80;
        r0 = r0 << 2;
        clearFlag(r0);
        r0 = 0x202;
        clearFlag(r0);
        r0 = 0x80a;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_20089f4();
        }

        //LAB_20081d2
        FUN_200a9dc();
      }
    }
  }

  /**
   * Event list 0x200ad34 handler 4
   */
  @Method(value = 0x20081ec, ignoreExtraParams = true)
  public static void FUN_20081ec() {
    int r0;
    final int r1;

    r0 = 0x202;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r1 = 0x1;
      r0 = 0x202db1;
      FUN_200aabc(r0, r1);
      r0 = 0x14;
      FUN_200aacc(r0);
      r0 = 0x202;
      setFlag(r0);
      r0 = 0x80;
      r0 = r0 << 2;
      clearFlag(r0);
      r0 = 0x201;
      clearFlag(r0);
    }
  }

  /**
   * Event list 0x200ad34 handler 5
   */
  @Method(value = 0x200822c, ignoreExtraParams = true)
  public static void FUN_200822c() {
    final int r2;
    int r3;

    r3 = 0xa0;
    r2 = 0x0;
    r3 = r3 << 19;
    MEMORY.ref(2, r3).setu(r2);
  }

  @Method(0x2008238)
  public static void FUN_2008238() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = 0x80b;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200825a
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1c;
      r2 = 0x24;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008278
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1d;
      r2 = 0x22;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008296
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1d;
      r2 = 0x24;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20082b4
    CPU.sp().value += 0x8;
  }

  @Method(0x20082cc)
  public static void FUN_20082cc() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = 0x826;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20082ee
    r0 = 0x827;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1c;
      r2 = 0x24;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200830c
    r0 = 0x828;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1d;
      r2 = 0x22;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_200832a
    r0 = 0x829;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1d;
      r2 = 0x24;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008348
    CPU.sp().value += 0x8;
  }

  @Method(0x2008360)
  public static void FUN_2008360() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = 0x80b;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1e;
      r2 = 0x22;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008382
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1e;
      r2 = 0x24;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20083a0
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1f;
      r2 = 0x22;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20083be
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1f;
      r2 = 0x24;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20083dc
    CPU.sp().value += 0x8;
  }

  @Method(0x20083f4)
  public static void FUN_20083f4() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = 0x826;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1e;
      r2 = 0x22;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008416
    r0 = 0x827;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1e;
      r2 = 0x24;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008434
    r0 = 0x828;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1f;
      r2 = 0x22;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008452
    r0 = 0x829;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1f;
      r2 = 0x24;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008470
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200ad34 handler 10
   */
  @Method(value = 0x2008488, ignoreExtraParams = true)
  public static void FUN_2008488() {
    int r0;
    int r1;
    int r2;
    final int r3;

    r0 = 0x814;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      FUN_2008054();
    }

    //LAB_2008498
    r0 = 0x809;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      //LAB_20084a4
      FUN_200a9d4();
      r0 = 0xfe3;
      FUN_200aa54(r0);
      r0 = 0x11;
      playSound(r0);
      r1 = 0x80;
      r2 = 0x80;
      r0 = 0x0;
      r1 = r1 << 9;
      r2 = r2 << 8;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r1 = 0x90;
      r2 = 0xe8;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200aa0c(r0, r1, r2);
      r1 = 0x0;
      r0 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r0 = 0x15;
      playSound(r0);
      r1 = 0xc0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);

      final Actor70 actor0 = getMapActor(0);
      if(actor0 != null) {
        r1 = actor0.pos_08.getX();
        r2 = actor0.pos_08.getZ();
        moveActorToPosition(16, r1, r2);
      }

      //LAB_2008502
      r0 = 0x10;
      r1 = 0x16666;
      r2 = 0xb333;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r1 = 0x90;
      r1 = r1 << 1;
      r2 = 0xce;
      r0 = 0x10;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x28;
      FUN_200a9cc(r0);
      r1 = 0x80;
      r0 = 0x10;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200aa7c(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x4;
      r2 = 0x3c;
      FUN_200aa34(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x14;
      FUN_200a5fc(r0, r1);

      if(actor0 != null) {
        r1 = actor0.pos_08.getX();
        r2 = actor0.pos_08.getZ();
        moveActorToPosition(1, r1, r2);
        r1 = actor0.pos_08.getX();
        r2 = actor0.pos_08.getZ();
        moveActorToPosition(5, r1, r2);
      }

      //LAB_2008564
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
      r1 = 0x8c;
      r0 = 0x1;
      r1 = r1 << 1;
      r2 = 0xf8;
      FUN_200aa04(r0, r1, r2);
      r1 = 0x94;
      r2 = 0xf8;
      r0 = 0x5;
      r1 = r1 << 1;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0xd0;
      r0 = 0x1;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xb0;
      r2 = 0x1e;
      r0 = 0x5;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x9999;
      r1 = 0x1333;
      FUN_200aa94(r0, r1);
      r0 = 0x90;
      r1 = 0x1;
      r2 = 0xd5;
      r3 = 0x1;
      r0 = r0 << 17;
      r1 = -r1;
      r2 = r2 << 16;
      FUN_200aa9c(r0, r1, r2, r3);
      r0 = 0x10;
      r1 = 0x6666;
      r2 = 0x3333;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r1 = 0x90;
      r2 = 0xb0;
      r1 = r1 << 1;
      r0 = 0x10;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x28;
      FUN_200a9cc(r0);
      r0 = 0x10;
      r1 = 0x2;
      FUN_200aa3c(r0, r1);
      r0 = 0x10;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r1 = 0x80;
      r2 = 0x3c;
      r0 = 0x10;
      r1 = r1 << 7;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x14;
      FUN_200a5fc(r0, r1);
      r2 = 0x28;
      r0 = 0x10;
      r1 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x3;
      r0 = 0x10;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200a9cc(r0);
      r1 = 0x80;
      r2 = 0x28;
      r0 = 0x10;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x3;
      r0 = 0x10;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r0 = 0x5;
      r1 = 0x2;
      FUN_200aa3c(r0, r1);
      r1 = 0x90;
      r2 = 0xa;
      r0 = 0x5;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x5;
      r1 = 0xa;
      FUN_200a5fc(r0, r1);
      r0 = 0x1;
      r1 = 0x2;
      FUN_200aa3c(r0, r1);
      r1 = 0xf0;
      r2 = 0xa;
      r0 = 0x1;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r1 = 0x81;
      r1 = r1 << 1;
      r0 = 0x5;
      FUN_200aa84(r0, r1);
      r0 = 0x28;
      FUN_200a9cc(r0);
      r1 = 0xa0;
      r2 = 0xa;
      r0 = 0x5;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x2005;
      r1 = 0xa;
      FUN_200a5fc(r0, r1);
      r1 = 0x2;
      r0 = 0x10;
      FUN_200aa3c(r0, r1);
      r0 = 0xa;
      FUN_200a9cc(r0);
      r1 = 0xa0;
      r2 = 0x14;
      r0 = 0x10;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x81;
      r1 = r1 << 1;
      r0 = 0x10;
      FUN_200aa84(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r1 = 0xa0;
      r0 = 0x0;
      r1 = r1 << 7;
      r2 = 0x28;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xc0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xe0;
      r0 = 0x1;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xa0;
      r0 = 0x5;
      r1 = r1 << 8;
      r2 = 0x28;
      FUN_200aa74(r0, r1, r2);
      r2 = 0x14;
      r0 = 0x1;
      r1 = 0x101;
      FUN_200aa7c(r0, r1, r2);
      r1 = 0x0;
      r0 = 0x1;
      FUN_200aa64(r0, r1);
      r0 = 0x3c;
      FUN_200a9cc(r0);
      r1 = 0x4;
      r0 = 0x10;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x28;
      FUN_200a9cc(r0);
      r0 = 0x10;
      r1 = 0x14;
      FUN_200a5fc(r0, r1);
      r2 = 0x28;
      r0 = 0x5;
      r1 = 0x101;
      FUN_200aa7c(r0, r1, r2);
      r0 = 0x5;
      r1 = 0x3c;
      FUN_200a5fc(r0, r1);
      r0 = 0x10;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x10;
      r1 = 0xa;
      FUN_200a5fc(r0, r1);
      r0 = 0x0;
      r1 = 0x105;
      r2 = 0x0;
      FUN_200aa7c(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x105;
      r2 = 0x0;
      FUN_200aa7c(r0, r1, r2);
      r2 = 0x3c;
      r0 = 0x5;
      r1 = 0x105;
      FUN_200aa7c(r0, r1, r2);
      r1 = 0x2;
      r0 = 0x1;
      FUN_200aa3c(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r0 = 0x1;
      r1 = 0xa;
      FUN_200a5fc(r0, r1);
      r1 = 0x3;
      r0 = 0x10;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200aa7c(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x1;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200aa7c(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x5;
      r1 = r1 << 1;
      r2 = 0x50;
      FUN_200aa7c(r0, r1, r2);
      r2 = 0x50;
      r0 = 0x10;
      r1 = 0x105;
      FUN_200aa7c(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r1 = 0x80;
      r0 = 0x0;
      r1 = r1 << 7;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xf0;
      r0 = 0x1;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x90;
      r0 = 0x5;
      r1 = r1 << 8;
      r2 = 0x3c;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x80;
      r2 = 0xa;
      r0 = 0x10;
      r1 = r1 << 7;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x3;
      r0 = 0x10;
      FUN_200aa3c(r0, r1);
      r0 = 0x6;
      FUN_200a9cc(r0);
      r1 = 0x0;
      r0 = 0x10;
      FUN_200aa5c(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200a9e4(r0, r1);
      if(r0 == 0x0) {
        r0 = 0xff0;
        FUN_200aa54(r0);
      } else {
        //LAB_2008850
        r0 = 0xff1;
        FUN_200aa54(r0);
        r0 = 0x10;
        r1 = 0x107;
        r2 = 0x14;
        FUN_200aa7c(r0, r1, r2);
      }

      //LAB_2008860
      r0 = 0x10;
      r1 = 0x4;
      r2 = 0x14;
      FUN_200aa34(r0, r1, r2);
      r1 = 0xc0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xe0;
      r0 = 0x1;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xa0;
      r2 = 0x0;
      r0 = 0x5;
      r1 = r1 << 8;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x6;
      r0 = 0x10;
      FUN_200a5fc(r0, r1);
      r0 = 0xff2;
      FUN_200aa54(r0);
      r0 = 0x1e;
      FUN_200a9cc(r0);
      r0 = 0x5;
      r1 = 0x4;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x2005;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x1;
      r1 = 0x14;
      FUN_200a5fc(r0, r1);
      r0 = 0x10;
      r1 = 0x6;
      r2 = 0x14;
      FUN_200aa34(r0, r1, r2);
      r1 = 0x82;
      r2 = 0x14;
      r0 = 0x10;
      r1 = r1 << 1;
      FUN_200aa7c(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x1e;
      FUN_200a5fc(r0, r1);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0x5;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r0 = 0x10;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x10;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
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
      r1 = 0x80;
      r2 = 0x80;
      r0 = 0x10;
      r1 = r1 << 10;
      r2 = r2 << 9;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x2;
      setActorAnimationIfLoaded(r0, r1);

      if(actor0 != null) {
        r1 = actor0.pos_08.getX() >> 16;
        r2 = actor0.pos_08.getZ() >> 16;
        FUN_200a9fc(16, r1, r2);
      }

      //LAB_2008958
      r0 = 0x10;
      FUN_200aa14(r0);
      r0 = 0x10;
      r1 = 0x0;
      r2 = 0x0;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x2;
      setActorAnimationIfLoaded(r0, r1);

      if(actor0 != null) {
        r1 = actor0.pos_08.getX() >> 16;
        r2 = actor0.pos_08.getZ() >> 16;
        FUN_200a9fc(1, r1, r2);
      }

      //LAB_2008988
      r0 = 0x1;
      FUN_200aa14(r0);
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
        FUN_200a9fc(5, r1, r2);
      }

      //LAB_20089b8
      r0 = 0x5;
      FUN_200aa14(r0);
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x5;
      moveActorToPosition(r0, r1, r2);
      r0 = 0xa2;
      r0 = r0 << 1;
      setFlag(r0);
      r0 = 0x809;
      setFlag(r0);
      FUN_200a9dc();
    }

    //LAB_20089da
  }

  @Method(0x20089f4)
  public static void FUN_20089f4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r0 = 0xff6;
    FUN_200aa54(r0);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xf4;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0xb0;
    FUN_200aa0c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(16, r1, r2);
    }

    //LAB_2008a32
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x1;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x10;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xec;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0xa8;
    FUN_200aa0c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x0;
    r2 = 0x3c;
    FUN_200aa74(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x10;
    r1 = 0x4;
    FUN_200aa34(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r0 = 0x26666;
    r1 = 0x4ccc;
    FUN_200aa94(r0, r1);
    r1 = 0x1;
    r2 = 0xb5;
    r2 = r2 << 16;
    r3 = 0x1;
    r1 = -r1;
    r0 = 0x23f0000;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200aaa4();
    r0 = 0x78;
    FUN_200a9cc(r0);
    r0 = 0x1010;
    r1 = 0x50;
    FUN_200a5fc(r0, r1);
    r0 = 0xf6;
    r1 = 0x1;
    r2 = 0xa8;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 16;
    r0 = r0 << 17;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200aaa4();
    r0 = 0x14;
    FUN_200a9cc(r0);
    r5 = 0x4010;
    r1 = 0xc0;
    r2 = 0x14;
    r0 = 0x10;
    r1 = r1 << 6;
    FUN_200aa74(r0, r1, r2);
    r0 = r5;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r2 = 0x3c;
    r0 = 0x10;
    r1 = 0x0;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x2;
    FUN_200aa3c(r0, r1);
    r1 = 0xc0;
    r0 = 0x10;
    r1 = r1 << 6;
    r2 = 0xa;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x0;
    r0 = r5;
    FUN_200aa5c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200a9e4(r0, r1);
    if(r0 == 0x0) {
      r0 = 0xffa;
      FUN_200aa54(r0);
    } else {
      //LAB_2008b08
      r0 = 0xffb;
      FUN_200aa54(r0);
    }

    //LAB_2008b0e
    r5 = 0x4010;
    r1 = 0xa0;
    r2 = 0xa;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200aa74(r0, r1, r2);
    r1 = 0xa;
    r0 = r5;
    FUN_200a5fc(r0, r1);
    r6 = 0xffc;
    r0 = r6;
    FUN_200aa54(r0);
    r0 = 0x10;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200aa74(r0, r1, r2);
    r2 = 0x28;
    r0 = 0x10;
    r1 = 0x105;
    FUN_200aa7c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0xc0;
    r2 = 0xa;
    r0 = 0x10;
    r1 = r1 << 6;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x0;
    r0 = r5;
    FUN_200aa5c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200a9e4(r0, r1);
    if(r0 == 0x0) {
      r0 = r6 + 0x1;
      FUN_200aa54(r0);
      r0 = 0x896;
      setFlag(r0);
    } else {
      //LAB_2008b7e
      r0 = r6 + 0x2;
      FUN_200aa54(r0);
    }

    //LAB_2008b84
    r0 = 0x4010;
    r1 = 0x4;
    FUN_200a5fc(r0, r1);
    r0 = 0x10;
    r1 = 0x1;
    FUN_200aa8c(r0, r1);
    r1 = 0xf3;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0x83;
    FUN_200aa0c(r0, r1, r2);
    r1 = 0x90;
    r0 = 0x10;
    r1 = r1 << 2;
    r2 = 0x78;
    FUN_200aa0c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x2;
    r0 = 0x10;
    r1 = r1 << 8;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 11;
    r1 = r1 << 8;
    FUN_200aa94(r0, r1);
    r0 = 0x80a;
    setFlag(r0);
  }

  /**
   * Event list 0x200ad34 handler 11
   */
  @Method(value = 0x2008c00, ignoreExtraParams = true)
  public static void FUN_2008c00() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(16);
    r0 = 0x809;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      //LAB_2008c16
      r0 = 0x814;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        FUN_2008108();
      } else {
        //LAB_2008c26
        r0 = 0x819;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          //LAB_2008c32
          FUN_200a9d4();
          r0 = 0x0;
          r1 = 0x0;
          setActorAnimationIfLoaded(r0, r1);
          r0 = 0x1000;
          FUN_200aa54(r0);
          r0 = 0x81;
          r0 = r0 << 4;
          r0 = readFlag(r0);
          if(r0 != 0x0 || readFlag(0x80a) == 0x0) {
            //LAB_2008c5a
            final Actor70 actor0 = getMapActor(0);
            if(actor0 != null) {
              r1 = actor0.pos_08.getX();
              r2 = actor0.pos_08.getZ();
              moveActorToPosition(16, r1, r2);
            }

            //LAB_2008c6e
            FUN_200a9cc(4);
            r1 = 0x80;
            r2 = 0x80;
            r1 = r1 << 9;
            r2 = r2 << 8;
            setActorVelocityScalerAndAcceleration(16, r1, r2);
          } else {
            //LAB_2008c84
            r0 = 0x81;
            r0 = r0 << 4;
            r0 = readFlag(r0);
            if(r0 != 0x0 || r5.pos_08.getX() > 0x1540000) {
              //LAB_2008c9a
              r1 = 0xc4;
              r2 = 0xa8;
              r1 = r1 << 17;
              r2 = r2 << 16;
              r0 = 0x10;
              moveActorToPosition(r0, r1, r2);
              r0 = 0x4;
              FUN_200a9cc(r0);
              r1 = 0x80;
              r2 = 0x80;
              r0 = 0x10;
              r1 = r1 << 10;
              r2 = r2 << 9;
              setActorVelocityScalerAndAcceleration(r0, r1, r2);
            }
          }

          //LAB_2008cbc
          r0 = 0x81;
          r0 = r0 << 4;
          r0 = readFlag(r0);
          if(r0 != 0x0 || r5.pos_08.getX() > 0x1540000) {
            //LAB_2008cd2
            r1 = 0x90;
            r0 = 0x10;
            r1 = r1 << 1;
            r2 = 0xe8;
            FUN_200aa0c(r0, r1, r2);
          } else {
            //LAB_2008ce0
            r0 = 0x80a;
            r0 = readFlag(r0);
          }

          //LAB_2008ce6
          r1 = 0x90;
          r0 = 0x10;
          r1 = r1 << 1;
          r2 = 0xe8;
          FUN_200aa0c(r0, r1, r2);
          r1 = 0xc0;
          r0 = 0x0;
          r1 = r1 << 8;
          r2 = 0x0;
          FUN_200aa74(r0, r1, r2);
          r1 = 0x80;
          r0 = 0x10;
          r1 = r1 << 7;
          r2 = 0xa;
          FUN_200aa74(r0, r1, r2);
          r0 = 0x10;
          r1 = 0x0;
          r2 = 0xa;
          FUN_200aa6c(r0, r1, r2);
          r0 = 0x0;
          r1 = 0x3;
          setActorAnimationAndWaitUntilFinished(r0, r1);
          r0 = 0x81;
          r0 = r0 << 4;
          r0 = readFlag(r0);
          if(r0 != 0x0 || readFlag(0x80a) == 0x0) {
            //LAB_2008d32
            r0 = 0x10;
            r1 = 0x2;
            setActorAnimationIfLoaded(r0, r1);

            final Actor70 actor0 = getMapActor(0);
            if(actor0 != null) {
              r1 = actor0.pos_08.getX() >> 16;
              r2 = actor0.pos_08.getZ() >> 16;
              FUN_200a9fc(16, r1, r2);
            }

            //LAB_2008d52
            FUN_200aa14(16);
            moveActorToPosition(16, 0, 0);
            FUN_200aa0c(0, 288, 232);
          } else {
            //LAB_2008d70
            r1 = 0x90;
            r0 = 0x0;
            r1 = r1 << 1;
            r2 = 0xf8;
            FUN_200aa0c(r0, r1, r2);
          }

          //LAB_2008d7c
          FUN_200a9dc();
        }
      }
    }

    //LAB_2008d80
  }

  @Method(0x2008d9c)
  public static void FUN_2008d9c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.sp().value -= 0x8;
    r0 = rand();
    r3 = 0x3;
    r0 = r0 & r3;
    if(r0 != 0x0) {
      //LAB_2008dae
      r6 = 0x200ade4;
      r5 = MEMORY.ref(2, r6).getUnsigned();
      if(r5 == 0x0) {
        //LAB_2008dd2
        r0 = 0xbb;
        playSound(r0);
        r3 = 0x1;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x21;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x1) {
        //LAB_2008dee
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x21;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x22;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x2) {
        //LAB_2008e0c
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x22;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x23;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x4) {
        //LAB_2008e4c
        r2 = 0x200ade8;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 < 0x4) {
        //LAB_2008e2c
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x23;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x1e;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x50) {
        //LAB_2008e78
        r3 = 0x1;
        r2 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2e;
        r1 = 0x31;
        r2 = 0x1e;
        r3 = 0x21;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_2008e8c
      r3 = MEMORY.ref(2, r6).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r6).setu(r3);
      r5 = MEMORY.ref(2, r6).getUnsigned();
      r0 = rand();
      r3 = r0 << 2;
      r3 = r3 + r0;
      r3 = r3 << 3;
      r3 = r3 >>> 16;
      r3 = r3 + 0x5a;
      if((r5 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r3);
      }
    }

    //LAB_2008eaa
    r5 = 0x200ade8;
    r3 = MEMORY.ref(4, r5).get();
    if(r3 != 0x0) {
      if(r3 == 0x2) {
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r0 = r0 << 9;
        r1 = r1 << 9;
        r2 = r2 << 9;
        FUN_200a9ac(r0, r1, r2);
        //LAB_2008ed4
      } else if(r3 == 0x1) {
        r0 = 0x1;
        r1 = 0x1;
        r0 = -r0;
        r1 = -r1;
        r2 = 0xe666;
        FUN_200a9ac(r0, r1, r2);
      }

      //LAB_2008ee6
      r3 = MEMORY.ref(4, r5).get();
      r3 = r3 - 0x1;
      MEMORY.ref(4, r5).setu(r3);
    }

    //LAB_2008eec
    CPU.sp().value += 0x8;
  }

  @Method(0x2008ef8)
  public static void FUN_2008ef8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.sp().value -= 0x8;
    r0 = rand();
    r3 = 0x3;
    r0 = r0 & r3;
    if(r0 != 0x0) {
      //LAB_2008f0a
      r6 = 0x200addc;
      r5 = MEMORY.ref(2, r6).getUnsigned();
      if(r5 == 0x2) {
        //LAB_2008f68
        r5 = 0x1;
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x22;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x23;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x0) {
        //LAB_2008f2e
        r0 = 0xbb;
        playSound(r0);
        r3 = 0x1;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x21;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x1) {
        //LAB_2008f4a
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x21;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x22;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x4) {
        //LAB_2008fa8
        r2 = 0x200ade8;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x1;
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 < 0x4) {
        //LAB_2008f88
        r5 = 0x1;
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x23;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2f;
        r1 = 0x3b;
        r2 = 0x2a;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x5a) {
        //LAB_2008fd4
        r3 = 0x1;
        r2 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2f;
        r1 = 0x31;
        r2 = 0x2a;
        r3 = 0x21;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_2008fe8
      r3 = MEMORY.ref(2, r6).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r6).setu(r3);
      r5 = MEMORY.ref(2, r6).getUnsigned();
      r0 = rand();
      r3 = r0 << 2;
      r3 = r3 + r0;
      r3 = r3 << 3;
      r3 = r3 >>> 16;
      r3 = r3 + 0x64;
      if((r5 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r3);
      }
    }

    //LAB_2009006
    CPU.sp().value += 0x8;
  }

  @Method(0x200901c)
  public static void FUN_200901c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.sp().value -= 0x8;
    r0 = rand();
    r3 = 0x3;
    r0 = r0 & r3;
    if(r0 != 0x0) {
      //LAB_200902e
      r6 = 0x200ade0;
      r5 = MEMORY.ref(2, r6).getUnsigned();
      if(r5 == 0x2) {
        //LAB_200908c
        r5 = 0x1;
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x26;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x0) {
        //LAB_2009052
        r0 = 0xbb;
        playSound(r0);
        r3 = 0x1;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x24;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x1) {
        //LAB_200906e
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x4) {
        //LAB_20090cc
        r2 = 0x200ade8;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x1;
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x28;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 < 0x4) {
        //LAB_20090ac
        r5 = 0x1;
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x26;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x30;
        r1 = 0x3b;
        r2 = 0x1f;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x5f) {
        //LAB_20090f8
        r3 = 0x1;
        r2 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x30;
        r1 = 0x31;
        r2 = 0x1f;
        r3 = 0x24;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_200910c
      r3 = MEMORY.ref(2, r6).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r6).setu(r3);
      r5 = MEMORY.ref(2, r6).getUnsigned();
      r0 = rand();
      r3 = r0 << 2;
      r3 = r3 + r0;
      r3 = r3 << 3;
      r3 = r3 >>> 16;
      r3 = r3 + 0x69;
      if((r5 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r3);
      }
    }

    //LAB_200912a
    CPU.sp().value += 0x8;
  }

  @Method(0x2009140)
  public static void FUN_2009140() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.sp().value -= 0x8;
    r0 = rand();
    r3 = 0x3;
    r0 = r0 & r3;
    if(r0 != 0x0) {
      //LAB_2009152
      r6 = 0x200adec;
      r5 = MEMORY.ref(2, r6).getUnsigned();
      if(r5 == 0x2) {
        //LAB_20091b0
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x26;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x0) {
        //LAB_2009176
        r0 = 0xbb;
        playSound(r0);
        r3 = 0x1;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x24;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x1) {
        //LAB_2009192
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x4) {
        //LAB_20091f0
        r2 = 0x200ade8;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x28;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 < 0x4) {
        //LAB_20091d0
        r5 = 0x1;
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x26;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x5;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2e;
        r1 = 0x3b;
        r2 = 0x29;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      } else if(r5 == 0x55) {
        //LAB_200921c
        r3 = 0x1;
        r2 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2e;
        r1 = 0x31;
        r2 = 0x29;
        r3 = 0x24;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_2009230
      r3 = MEMORY.ref(2, r6).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r6).setu(r3);
      r5 = MEMORY.ref(2, r6).getUnsigned();
      r0 = rand();
      r3 = r0 << 2;
      r3 = r3 + r0;
      r3 = r3 << 3;
      r3 = r3 >>> 16;
      r3 = r3 + 0x5f;
      if((r5 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r3);
      }
    }

    //LAB_200924e
    CPU.sp().value += 0x8;
  }

  @Method(0x2009264)
  public static void FUN_2009264() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r0 = -r0;
    r1 = -r1;
    r2 = -r2;
    r3 = 0x0;
    CPU.sp().value -= 0x8;
    FUN_200aa9c(r0, r1, r2, r3);
    r6 = 0x8;
    r5 = 0x3;
    r0 = 0x1e;
    r1 = 0x2b;
    r2 = 0x20;
    r3 = 0x28;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0x1e;
    r1 = 0x2b;
    r2 = 0x21;
    r3 = 0x27;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x1e;
    r1 = 0x2b;
    r2 = 0x24;
    r3 = 0x26;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x4;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = 0xe;
    r1 = 0x29;
    r2 = 0x20;
    r3 = 0x29;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r1 = 0x1;
    r2 = 0x9e;
    r3 = 0x0;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200a98c();
    r2 = 0xf0;
    r0 = 0x10;
    r1 = 0x23e0000;
    r2 = r2 << 15;
    moveActorToPosition(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r1 = 0x1;
    r0 = 0x2051cc;
    FUN_200aabc(r0, r1);
    r0 = 0x14;
    FUN_200aacc(r0);
    r0 = 0x201;
    setFlag(r0);
    r0 = 0x80;
    r0 = r0 << 2;
    clearFlag(r0);
    r0 = 0x202;
    clearFlag(r0);
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
    FUN_200aad4();
    FUN_200aae4();
    r0 = 0x28;
    FUN_200a9cc(r0);
    r0 = 0xab;
    playSound(r0);
    r1 = 0x1;
    r0 = 0x10005;
    FUN_200aabc(r0, r1);
    r0 = 0x8;
    FUN_200aacc(r0);
    r0 = 0x20;
    FUN_200a9cc(r0);
    r1 = 0x1;
    r0 = 0x2051cc;
    FUN_200aabc(r0, r1);
    r0 = 0x18;
    FUN_200aacc(r0);
    CPU.sp().value += 0x8;
  }

  @Method(0x2009380)
  public static void FUN_2009380() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    FUN_200a9d4();
    FUN_2009264();
    r0 = 0x1018;
    FUN_200aa54(r0);
    r1 = 0x80;
    r0 = 0x10;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200aa7c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    r2 = 0x1e;
    FUN_200aa34(r0, r1, r2);
    r1 = 0x1;
    r2 = 0xae;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    r0 = 0x23e0000;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200aaa4();
    r0 = 0x1e;
    FUN_200a9cc(r0);
    r0 = 0x8010;
    r1 = 0x14;
    FUN_200a5fc(r0, r1);
    r5 = 0x0;

    //LAB_20093d6
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0xc;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0xc;
      FUN_200a9cc(r0);
    } while(r5 != 0x4);

    r5 = 0x0;

    //LAB_20093fe
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x8;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x8;
      FUN_200a9cc(r0);
    } while(r5 != 0x6);

    r5 = 0x0;

    //LAB_2009426
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x6;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x6;
      FUN_200a9cc(r0);
    } while(r5 != 0x8);

    r5 = 0x0;

    //LAB_200944e
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x4;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x4;
      FUN_200a9cc(r0);
    } while(r5 != 0xa);

    r5 = 0x0;

    //LAB_2009476
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x2;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x2;
      FUN_200a9cc(r0);
    } while(r5 != 0xc);

    FUN_2008238();
    r0 = 0x6;
    FUN_200a9cc(r0);
    r0 = 0x8010;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x10;
    r1 = r1 << 10;
    r2 = r2 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0x8c;
    r0 = 0x10;
    r1 = r1 << 2;
    r2 = r2 << 1;
    FUN_200aa0c(r0, r1, r2);
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
    FUN_200aadc();
    FUN_200aae4();
    r0 = 0x813;
    setFlag(r0);
    r0 = 0x3;
    FUN_200aaac(r0);
  }

  @Method(0x2009510)
  public static void FUN_2009510() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    CPU.sp().value -= 0x8;
    FUN_200a9d4();
    FUN_2009264();
    r2 = 0x0;
    r3 = 0x200ade4;
    MEMORY.ref(2, r3).setu(r2);
    r3 = 0x200addc;
    MEMORY.ref(2, r3).setu(r2);
    r3 = 0x200ade0;
    MEMORY.ref(2, r3).setu(r2);
    r3 = 0x200adec;
    r0 = 0x1001;
    MEMORY.ref(2, r3).setu(r2);
    FUN_200aa54(r0);
    r1 = 0x80;
    r0 = 0x10;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200aa7c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    r2 = 0x1e;
    FUN_200aa34(r0, r1, r2);
    r1 = 0x1;
    r2 = 0xae;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    r0 = 0x23e0000;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200aaa4();
    r0 = 0x1e;
    FUN_200a9cc(r0);
    r0 = 0x8010;
    r1 = 0x14;
    FUN_200a5fc(r0, r1);
    r5 = 0x0;

    //LAB_2009596
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0xc;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0xc;
      FUN_200a9cc(r0);
    } while(r5 != 0x4);

    r1 = 0x6;
    r0 = 0x8010;
    FUN_200a5fc(r0, r1);
    r5 = 0x200ade4;
    r0 = rand();
    r3 = r0 << 4;
    r3 = r3 - r0;
    r3 = r3 << 2;
    r3 = r3 >>> 16;
    r3 = r3 + 0x14;
    MEMORY.ref(2, r5).setu(r3);
    r5 = 0x200addc;
    r0 = rand();
    r3 = r0 << 4;
    r3 = r3 - r0;
    r3 = r3 << 2;
    r3 = r3 >>> 16;
    r3 = r3 + 0x14;
    MEMORY.ref(2, r5).setu(r3);
    r5 = 0x200ade0;
    r0 = rand();
    r3 = r0 << 4;
    r3 = r3 - r0;
    r3 = r3 << 2;
    r3 = r3 >>> 16;
    r3 = r3 + 0x14;
    MEMORY.ref(2, r5).setu(r3);
    r5 = 0x200adec;
    r0 = rand();
    r3 = r0 << 4;
    r3 = r3 - r0;
    r3 = r3 << 2;
    r3 = r3 >>> 16;
    r2 = 0x200ade8;
    r3 = r3 + 0x14;
    MEMORY.ref(2, r5).setu(r3);
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    setTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2008d9c"), 0xc80);
    setTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2008ef8"), 0xc80);
    setTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_200901c"), 0xc80);
    setTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2009140"), 0xc80);
    r5 = 0x0;

    //LAB_200963c
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x5;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x5;
      FUN_200a9cc(r0);
    } while(r5 != 0x6);

    r5 = 0x0;

    //LAB_2009664
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x4;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x4;
      FUN_200a9cc(r0);
    } while(r5 != 0x8);

    r5 = 0x0;

    //LAB_200968c
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x3;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x3;
      FUN_200a9cc(r0);
    } while(r5 != 0xa);

    r5 = 0x0;

    //LAB_20096b4
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_2008238();
      r0 = 0x2;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_2008360();
      r0 = 0x2;
      FUN_200a9cc(r0);
    } while(r5 != 0xc);

    r3 = 0x4;
    r2 = 0x2;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 = 0xa;
    r0 = 0x2d;
    r1 = 0x1e;
    r2 = 0x22;
    FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r2 = 0x28;
    r0 = 0x10;
    r1 = 0x6;
    FUN_200aa34(r0, r1, r2);
    r0 = 0x8010;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x10;
    r1 = r1 << 10;
    r2 = r2 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x90;
    r2 = 0x8c;
    r1 = r1 << 2;
    r2 = r2 << 1;
    r0 = 0x10;
    FUN_200aa0c(r0, r1, r2);
    clearTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2008d9c"));
    clearTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2008ef8"));
    clearTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_200901c"));
    clearTickCallback(getRunnable(Map11Overlay_878b2ac.class, "FUN_2009140"));
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
    FUN_200aadc();
    FUN_200aae4();
    r0 = 0x4;
    FUN_200aaac(r0);
    CPU.sp().value += 0x8;
  }

  @Method(0x2009790)
  public static void FUN_2009790() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    CPU.sp().value -= 0x8;
    FUN_200a9d4();
    r0 = 0x80b;
    r0 = readFlag(r0);
    if(r0 != 0x0 && readFlag(0x826) != 0x0) {
      r0 = 0x826;
      clearFlag(r0);
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1c;
      r2 = 0x22;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_20097c8
      r0 = 0x80b;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x826;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r0 = 0x826;
          setFlag(r0);
        }
      }
    }

    //LAB_20097e2
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 != 0x0 && readFlag(0x827) != 0x0) {
      r0 = 0x827;
      clearFlag(r0);
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1c;
      r2 = 0x24;
      r3 = 0xa;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_2009812
      r0 = 0x80c;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x827;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r0 = 0x827;
          setFlag(r0);
        }
      }
    }

    //LAB_200982c
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 != 0x0 && readFlag(0x828) != 0x0) {
      r0 = 0x828;
      clearFlag(r0);
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2d;
      r1 = 0x1d;
      r2 = 0x22;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_200985c
      r0 = 0x80d;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x828;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r0 = 0x828;
          setFlag(r0);
        }
      }
    }

    //LAB_2009876
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 != 0x0 && readFlag(0x829) != 0x0) {
      r0 = 0x829;
      clearFlag(r0);
      r3 = 0x2;
      r2 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x2f;
      r1 = 0x1d;
      r2 = 0x24;
      r3 = 0xb;
      FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_20098a6
      r0 = 0x80e;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x829;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r0 = 0x829;
          setFlag(r0);
        }
      }
    }

    //LAB_20098c0
    FUN_2009264();
    r1 = 0x80;
    r0 = 0x10;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    r2 = 0x1e;
    FUN_200aa34(r0, r1, r2);
    r1 = 0x1;
    r2 = 0xae;
    r0 = 0x23e0000;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200aaa4();
    r0 = 0x1e;
    FUN_200a9cc(r0);
    r5 = 0x0;

    //LAB_20098f6
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_20082cc();
      r0 = 0xc;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_20083f4();
      r0 = 0xc;
      FUN_200a9cc(r0);
    } while(r5 != 0x4);

    r5 = 0x0;

    //LAB_200991e
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_20082cc();
      r0 = 0x8;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_20083f4();
      r0 = 0x8;
      FUN_200a9cc(r0);
    } while(r5 != 0x6);

    r5 = 0x0;

    //LAB_2009946
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_20082cc();
      r0 = 0x6;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_20083f4();
      r0 = 0x6;
      FUN_200a9cc(r0);
    } while(r5 != 0x8);

    r5 = 0x0;

    //LAB_200996e
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_20082cc();
      r0 = 0x4;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_20083f4();
      r0 = 0x4;
      FUN_200a9cc(r0);
    } while(r5 != 0xa);

    r5 = 0x0;

    //LAB_2009996
    do {
      r0 = 0xf6;
      playSound(r0);
      FUN_20082cc();
      r0 = 0x2;
      FUN_200a9cc(r0);
      r0 = 0xf6;
      playSound(r0);
      r5 = r5 + 0x1;
      FUN_20083f4();
      r0 = 0x2;
      FUN_200a9cc(r0);
    } while(r5 != 0xc);

    r0 = 0xf6;
    playSound(r0);
    FUN_20082cc();
    r0 = 0x6;
    FUN_200a9cc(r0);
    r0 = 0x822;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x8010;
      r0 = 0x1025;
      FUN_200aa54(r0);
      r0 = r5;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r0 = 0x10;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = r5;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
    }

    //LAB_20099f6
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
    FUN_200aadc();
    FUN_200aae4();
    r0 = 0x5;
    FUN_200aaac(r0);
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200ad34 handler 7
   */
  @Method(value = 0x2009a58, ignoreExtraParams = true)
  public static void FUN_2009a58() {
    int r0;
    int r1;
    int r2;
    final int r3;

    r0 = 0x81;
    r0 = r0 << 4;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      //LAB_2009a68
      r0 = FUN_200a5b0();
      if(r0 != 0x0) {
        //LAB_2009a72
        FUN_200a9d4();
        r2 = 0x93;
        r0 = 0x10;
        r1 = 0x2410000;
        r2 = r2 << 16;
        moveActorToPosition(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x10;
        r1 = r1 << 7;
        r2 = 0x1;
        FUN_200aa74(r0, r1, r2);
        r1 = 0x1;
        r2 = 0xb8;
        r3 = 0x1;
        r1 = -r1;
        r2 = r2 << 16;
        r0 = 0x23e0000;
        FUN_200aa9c(r0, r1, r2, r3);
        r0 = 0x1027;
        FUN_200aa54(r0);
        r1 = 0x90;
        r2 = 0xe8;
        r0 = 0x0;
        r1 = r1 << 2;
        FUN_200aa0c(r0, r1, r2);
        r1 = 0x0;
        r0 = 0x0;
        setActorAnimationIfLoaded(r0, r1);
        FUN_200aaa4();
        r0 = 0xa;
        FUN_200a9cc(r0);
        r1 = 0x80;
        r2 = 0x80;
        r0 = 0x10;
        r1 = r1 << 9;
        r2 = r2 << 8;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r1 = 0x90;
        r1 = r1 << 2;
        r2 = 0x98;
        r0 = 0x10;
        FUN_200aa0c(r0, r1, r2);
        r0 = 0x6;
        FUN_200a9cc(r0);
        r2 = 0x1e;
        r0 = 0x10;
        r1 = 0x6;
        FUN_200aa34(r0, r1, r2);
        r0 = 0x10;
        r1 = 0x6;
        FUN_200a5fc(r0, r1);
        r1 = 0x3;
        r0 = 0x0;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x2;
        FUN_200a9cc(r0);
        r0 = 0x10;
        r1 = 0x4;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x10;
        r1 = 0x6;
        FUN_200a5fc(r0, r1);
        r1 = 0x81;
        r1 = r1 << 1;
        r0 = 0x0;
        FUN_200aa84(r0, r1);
        r0 = 0x28;
        FUN_200a9cc(r0);
        r1 = 0x2;
        r0 = 0x10;
        FUN_200aa3c(r0, r1);
        r0 = 0x1e;
        FUN_200a9cc(r0);
        r0 = 0x10;
        r1 = 0x6;
        FUN_200a5fc(r0, r1);
        r0 = 0x0;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r1 = 0x90;
        r2 = 0xb8;
        r1 = r1 << 2;
        r0 = 0x10;
        FUN_200aa0c(r0, r1, r2);
        r0 = 0x6;
        FUN_200a9cc(r0);
        r1 = 0x2;
        r0 = 0x10;
        FUN_200aa3c(r0, r1);
        r0 = 0x28;
        FUN_200a9cc(r0);
        r0 = 0x4010;
        r1 = 0x6;
        FUN_200a5fc(r0, r1);
        r1 = 0x90;
        r2 = 0xd0;
        r1 = r1 << 2;
        r0 = 0x10;
        FUN_200aa0c(r0, r1, r2);
        r0 = 0x28;
        FUN_200a9cc(r0);
        r1 = 0x3;
        r0 = 0x0;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x6;
        FUN_200a9cc(r0);
        r1 = 0x80;
        r2 = 0x80;
        r0 = 0x10;
        r1 = r1 << 8;
        r2 = r2 << 7;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r0 = 0x10;
        r1 = 0x2;
        setActorAnimationIfLoaded(r0, r1);

        final Actor70 actor = getMapActor(0);
        if(actor != null) {
          r1 = actor.pos_08.getX() >> 16;
          r2 = actor.pos_08.getZ() >> 16;
          FUN_200a9fc(16, r1, r2);
        }

        //LAB_2009bb6
        FUN_200aa14(16);
        moveActorToPosition(16, 0, 0);
        setFlag(0x810);
        FUN_200a9dc();
      }
    }

    //LAB_2009bd2
  }

  @Method(0x2009be8)
  public static void FUN_2009be8() {
    int r0;
    int r1;
    int r2;

    r0 = 0x15;
    playSound(r0);
    r1 = 0xbc;
    r2 = 0xb8;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200aa0c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xbc;
    r2 = 0xb8;
    r0 = 0x10;
    r1 = r1 << 17;
    r2 = r2 << 16;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x10;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xc4;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0xa8;
    FUN_200aa0c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x1e;
    r0 = 0x10;
    r1 = r1 << 8;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x10;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x102b;
    FUN_200aa54(r0);
    r2 = 0x1e;
    r0 = 0x10;
    r1 = 0x4;
    FUN_200aa34(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200aa3c(r0, r1);
    r0 = 0x6;
    FUN_200a9cc(r0);
    r0 = 0x10;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x10;
    r1 = 0x6;
    FUN_200a5fc(r0, r1);
    r1 = 0xbc;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0xb8;
    FUN_200aa0c(r0, r1, r2);
    r1 = 0xc9;
    r1 = r1 << 19;
    r2 = r1;
    r0 = 0x10;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x4;
    FUN_200a9cc(r0);
    r0 = 0x811;
    setFlag(r0);
  }

  /**
   * Event list 0x200ad34 handler 6
   */
  @Method(value = 0x2009ca8, ignoreExtraParams = true)
  public static void FUN_2009ca8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    Actor70 r6;
    Sprite38 r7;

    CPU.push(CPU.r8().value);
    r0 = 0x811;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      //LAB_2009cbc
      FUN_200a9d4();
      r0 = 0x80;
      r1 = 0x80;
      r0 = r0 << 9;
      r1 = r1 << 6;
      FUN_200aa94(r0, r1);
      r1 = 0x1;
      r2 = 0x94;
      r3 = 0x1;
      r0 = 0x11f0000;
      r1 = -r1;
      r2 = r2 << 16;
      FUN_200aa9c(r0, r1, r2, r3);
      r1 = 0x90;
      r2 = 0x78;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x0;
      r1 = 0x4;
      r2 = 0x1e;
      FUN_200aa34(r0, r1, r2);
      r1 = 0x90;
      r2 = 0xf0;
      r0 = 0x10;
      r1 = r1 << 17;
      r2 = r2 << 15;
      moveActorToPosition(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x80;
      r0 = 0x10;
      r1 = r1 << 9;
      r2 = r2 << 8;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r1 = 0x8a;
      r0 = 0x10;
      r1 = r1 << 1;
      r2 = 0x88;
      FUN_200aa0c(r0, r1, r2);
      r1 = 0x84;
      r0 = 0x10;
      r1 = r1 << 1;
      r2 = 0x88;
      FUN_200aa04(r0, r1, r2);
      r1 = 0x9c;
      r2 = 0x88;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x10;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0xb0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_200aa74(r0, r1, r2);
      r1 = 0xd0;
      r0 = 0x10;
      r1 = r1 << 8;
      r2 = 0x14;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x819;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0xdc;
        playSound(r0);
      }

      //LAB_2009d72
      r0 = 0x28;
      FUN_200a9cc(r0);
      r0 = 0x819;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        //LAB_2009d84
        r2 = 0x3;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r5 = 0x2;
        CPU.r8().value = r2;
        r0 = 0x24;
        r1 = 0x3e;
        r2 = 0x11;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x26;
        r0 = 0x2c;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0xa;
        FUN_200a9cc(r0);
        r3 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x26;
        r1 = 0x3e;
        r2 = 0x11;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x27;
        r0 = 0x2c;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0xa;
        FUN_200a9cc(r0);
        r2 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x28;
        r1 = 0x3e;
        r2 = 0x11;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x0;
        r1 = 0x20;
        r2 = 0x11;
        r3 = 0x27;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x28;
        r1 = 0x3b;
        r2 = 0x11;
        r0 = 0x2c;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0xa;
        FUN_200a9cc(r0);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_200aa7c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x10;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_200aa7c(r0, r1, r2);
        r3 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x2a;
        r1 = 0x3e;
        r2 = 0x11;
        r3 = 0x24;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x0;
        r1 = 0x20;
        r2 = 0x11;
        r3 = 0x28;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x29;
        r0 = 0x2c;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0xa;
        FUN_200a9cc(r0);
        r0 = 0x0;
        r1 = 0x20;
        r2 = 0x11;
        r3 = 0x29;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r1 = 0x3b;
        r2 = 0x11;
        r3 = 0x2a;
        r0 = 0x2c;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(1);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0xa;
        FUN_200a9cc(r0);
        r2 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r1 = 0x20;
        r2 = 0x11;
        r3 = 0x2a;
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x50;
        FUN_200a9cc(r0);
        r0 = 0x9;
        FUN_200a99c(r0);
        r0 = 0xa;
        FUN_200a99c(r0);
        r0 = 0x819;
        setFlag(r0);
      }

      //LAB_2009eb2
      r2 = 0x1e;
      r0 = 0x10;
      r1 = 0x0;
      FUN_200aa44(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x10;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r5 = 0x8010;
      r1 = 0x0;
      r0 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x102e;
      FUN_200aa54(r0);
      r0 = r5;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r0 = 0x10;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x10;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = r5;
      r1 = 0x0;
      FUN_200aa64(r0, r1);
      r1 = 0x3;
      r0 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x3c;
      FUN_200a9cc(r0);
      r6 = getMapActor(0);
      r1 = 0x1333;
      r0 = 0x9999;
      FUN_200aa94(r0, r1);
      r1 = 0x1;
      r2 = 0xe4;
      r3 = 0x1;
      r0 = 0x11f0000;
      r1 = -r1;
      r2 = r2 << 15;
      FUN_200aa9c(r0, r1, r2, r3);
      r1 = 0x90;
      r1 = r1 << 1;
      r2 = 0x78;
      r0 = 0x0;
      FUN_200aa0c(r0, r1, r2);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r1 = 0xc0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x14;
      FUN_200aa74(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x4ccc;
      r2 = 0x2666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r6._5a.and(~0x1);
      r6._55.set(0);
      playSound(0xc9);
      FUN_200aa4c(0, 0x100);
      r7 = r6.sprite_50.deref();
      r7._26.set(0);
      r5 = 0x0;

      //LAB_2009f88
      do {
        r6.pos_08.y_04.add(0x3333);
        r0 = 0x1;
        r5 = r5 + 0x1;
        sleep(r0);
      } while(r5 != 0x78);

      r0 = 0xbe;
      playSound(r0);
      r5 = 0x0;

      //LAB_2009fa4
      do {
        r6.pos_08.y_04.add(0x1999);
        r7.scale_18.sub(0x400);
        sleep(1);
        r5 = r5 + 0x1;
      } while(r5 != 0x3c);

      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x0;
      moveActorToPosition(r0, r1, r2);
      r2 = 0x14;
      r0 = 0x10;
      r1 = 0x4;
      FUN_200aa34(r0, r1, r2);
      r0 = 0x10;
      r1 = 0x6;
      FUN_200a5fc(r0, r1);
      r1 = 0x90;
      r2 = 0x78;
      r0 = 0x10;
      r1 = r1 << 1;
      FUN_200aa0c(r0, r1, r2);
      r1 = 0x2;
      r0 = 0x10;
      FUN_200aa3c(r0, r1);
      r0 = 0x14;
      FUN_200a9cc(r0);
      r1 = 0xc0;
      r0 = 0x10;
      r1 = r1 << 8;
      r2 = 0x14;
      FUN_200aa74(r0, r1, r2);
      r1 = 0x4ccc;
      r2 = 0x2666;
      r0 = 0x10;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r6 = getMapActor(16);
      r6._5a.and(~0x1);
      r6._55.set(0);
      playSound(0xc9);
      r1 = 0x80;
      r0 = 0x10;
      r1 = r1 << 1;
      FUN_200aa4c(r0, r1);
      r7 = r6.sprite_50.deref();
      r7._26.set(0);
      r5 = 0x0;

      //LAB_200a040
      do {
        r6.pos_08.y_04.add(0x3333);
        r0 = 0x1;
        r5 = r5 + 0x1;
        sleep(r0);
      } while(r5 != 0x78);

      r0 = 0xbe;
      playSound(r0);
      r5 = 0x0;

      //LAB_200a05c
      do {
        r6.pos_08.y_04.add(0x1999);
        r7.scale_18.sub(0x400);
        r0 = 0x1;
        r5 = r5 + 0x1;
        sleep(r0);
      } while(r5 != 0x3c);

      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x10;
      moveActorToPosition(r0, r1, r2);
      r0 = 0x50;
      FUN_200a9cc(r0);
      r3 = 0x3001ebc;
      r1 = MEMORY.ref(4, r3).get();
      r3 = 0xe0;
      r3 = r3 << 1;
      r2 = r1 + r3;
      r3 = r3 + 0x43;
      MEMORY.ref(4, r2).setu(r3);
      r3 = r3 - 0x3b;
      r2 = r1 + r3;
      r3 = 0x18;
      MEMORY.ref(4, r2).setu(r3);
      FUN_200aadc();
      FUN_200aae4();
      r1 = 0x0;
      r0 = 0x0;
      FUN_200aabc(r0, r1);
      r0 = 0x1;
      FUN_200aacc(r0);
      r0 = 0x1;
      sleep(r0);
      r0 = 0x7;
      FUN_200aaac(r0);
      FUN_200a9dc();
    }

    //LAB_200a0fc
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x200a108)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r0 = 0x1;
    CPU.sp().value -= 0x8;
    sleep(r0);
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 + 0x44;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x809;
    r5 = 0x0;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x814;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r0 = 0x819;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          r0 = 0xa2;
          r0 = r0 << 1;
          setFlag(r0);
        }
      }
    }

    //LAB_200a14c
    r0 = 0x80;
    r0 = r0 << 9;
    r1 = 0x0;
    FUN_200aac4(r0, r1);
    r0 = 0x109;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x201;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x2051cc;
        r1 = 0x1;
        FUN_200aabc(r0, r1);
        r0 = 0x1;
        FUN_200aacc(r0);
        r0 = 0x1;
        sleep(r0);
      } else {
        //LAB_200a16e
        r0 = 0x202;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r0 = 0x202db1;
          r1 = 0x1;
          FUN_200aabc(r0, r1);
          r0 = 0x1;
          FUN_200aacc(r0);
          r0 = 0x1;
          sleep(r0);
        }
      }
    } else {
      //LAB_200a18e
      r0 = 0x80;
      r0 = r0 << 2;
      setFlag(r0);
      r0 = 0x80a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r1 = 0x90;
        r2 = 0xf0;
        r0 = 0x10;
        r1 = r1 << 18;
        r2 = r2 << 15;
        moveActorToPosition(r0, r1, r2);
      }
    }

    //LAB_200a1ae
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x4) {
      r0 = 0x813;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        FUN_2009380();
        r0 = 0x813;
        setFlag(r0);
        r5 = 0x1;
      }
    } else {
      //LAB_200a1d4
      if(r3 != 0x5) {
        //LAB_200a206
        if(r3 == 0x6) {
          r0 = 0x812;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            FUN_2009790();
            r0 = 0x822;
            setFlag(r0);
          }

          //LAB_200a21e
          r5 = 0x1;
        }
      } else {
        r0 = 0x812;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_2009510();
          r0 = 0x812;
          setFlag(r0);
          r0 = 0x80b;
          clearFlag(r0);
          r0 = 0x80c;
          clearFlag(r0);
          r0 = 0x80d;
          clearFlag(r0);
          r0 = 0x80e;
          clearFlag(r0);
          r5 = 0x1;
        }
      }
    }

    //LAB_200a220
    r0 = 0x80b;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x826;
      setFlag(r0);
    }

    //LAB_200a230
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x827;
      setFlag(r0);
    }

    //LAB_200a240
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x828;
      setFlag(r0);
    }

    //LAB_200a250
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x829;
      setFlag(r0);
    }

    //LAB_200a260
    r0 = 0x4;
    sleep(r0);
    if(r5 == 0x0) {
      //LAB_200a26c
      r0 = FUN_200a5b0();
      if(r0 != 0x0) {
        //LAB_200a276
        r3 = 0xc;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x1e;
        r1 = 0x2c;
        r2 = 0x1e;
        r3 = 0x26;
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r5 = 0x4;
        r0 = 0x1e;
        r1 = 0x2c;
        r2 = 0x22;
        CPU.r8().value = r3;
        r3 = 0x25;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r6 = 0x8;
        r0 = 0xe;
        r1 = 0x29;
        r2 = 0x20;
        r3 = 0x29;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r7 = 0x2;
        r0 = 0x2d;
        r1 = 0x1c;
        r2 = 0x22;
        r3 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r7);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x2d;
        r1 = 0x1e;
        r2 = 0x10;
        r3 = 0xa;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r7);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r2 = 0xe;
        r3 = 0x29;
        r0 = 0xe;
        r1 = 0x2d;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x2000240;
        r2 = 0xe1;
        r2 = r2 << 1;
        r3 = r3 + r2;
        r2 = 0x0;
        r3 = MEMORY.ref(2, r3 + r2).get();
        if(r3 != 0x8) {
          r0 = 0x814;
          r0 = readFlag(r0);
          if(r0 == 0x0) {
            r0 = 0x819;
            r0 = readFlag(r0);
            if(r0 != 0x0) {
              r3 = CPU.r8().value;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
              r0 = 0x0;
              r1 = 0x20;
              r2 = 0x11;
              r3 = 0x27;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r5 = 0x3;
              r0 = 0x2a;
              r1 = 0x3e;
              r2 = 0x11;
              r3 = 0x24;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r2 = CPU.r8().value;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
              r0 = 0x0;
              r1 = 0x20;
              r2 = 0x11;
              r3 = 0x28;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r3 = CPU.r8().value;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
              r0 = 0x0;
              r1 = 0x20;
              r2 = 0x11;
              r3 = 0x29;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r0 = 0x0;
              r1 = 0x20;
              r2 = 0x11;
              r3 = 0x2a;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            } else {
              //LAB_200a362
              r3 = 0x6;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
              r0 = 0x2c;
              r1 = 0x3b;
              r2 = 0x11;
              r3 = 0x25;
              MEMORY.ref(4, CPU.sp().value).setu(r7);
              FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_200a374
            r0 = 0x9;
            FUN_200a99c(r0);
            r0 = 0xa;
            FUN_200a99c(r0);
          }
        }

        //LAB_200a380
        r0 = 0x10;
        r1 = 0x0;
        r2 = 0x0;
        moveActorToPosition(r0, r1, r2);
      } else {
        //LAB_200a3e4
        r0 = 0x80b;
        r5 = 0x0;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r5 = 0x2;
          r6 = 0x1;
          r0 = 0x2d;
          r1 = 0x1c;
          r2 = 0x22;
          r3 = 0xa;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x2d;
          r1 = 0x1e;
          r2 = 0x10;
          r3 = 0xa;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r5 = 0x1;
        }

        //LAB_200a416
        r0 = 0x80c;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r5 = 0x2;
          r6 = 0x1;
          r0 = 0x2f;
          r1 = 0x1c;
          r2 = 0x24;
          r3 = 0xa;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x2f;
          r1 = 0x1e;
          r2 = 0x12;
          r3 = 0xa;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r5 = 0x1;
        }

        //LAB_200a446
        r0 = 0x80d;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r5 = 0x2;
          r6 = 0x1;
          r0 = 0x2d;
          r1 = 0x1d;
          r2 = 0x22;
          r3 = 0xb;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x2d;
          r1 = 0x1f;
          r2 = 0x10;
          r3 = 0xb;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r5 = 0x1;
        }

        //LAB_200a476
        r0 = 0x80e;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r5 = 0x2;
          r6 = 0x1;
          r0 = 0x2f;
          r1 = 0x1d;
          r2 = 0x24;
          r3 = 0xb;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x2f;
          r1 = 0x1f;
          r2 = 0x12;
          r3 = 0xb;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r5 = 0x1;
        }

        //LAB_200a4a6
        r0 = 0x812;
        r0 = readFlag(r0);
        if(r0 != 0x0 || r5 != 0x0) {
          //LAB_200a4b4
          r6 = 0x8;
          r5 = 0x3;
          r0 = 0x1e;
          r1 = 0x2b;
          r2 = 0x20;
          r3 = 0x28;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = 0x1e;
          r1 = 0x2b;
          r2 = 0x21;
          r3 = 0x27;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1e;
          r1 = 0x2b;
          r2 = 0x24;
          r3 = 0x26;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = 0x4;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = 0x24;
          r1 = 0x3a;
          r2 = 0x20;
          r3 = 0x29;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          FUN_200a994(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_200a4fc
        r3 = 0x11;
        r2 = 0x6;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0xf;
        r1 = 0x6;
        r2 = 0x2;
        r3 = 0x1;
        FUN_200a9a4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }
    }

    //LAB_200a510
    r0 = 0x309;
    r0 = readFlag(r0);
    if(r0 == 0x0 && entranceId_2000402.get() == 0x8) {
      FUN_200a614();
      r0 = 0x309;
      setFlag(r0);
      r3 = 0x11;
      r2 = 0x6;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0xf;
      r1 = 0x6;
      r2 = 0x2;
      r3 = 0x1;
      FUN_200a9a4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    } else {
      //LAB_200a54a
      r0 = 0x814;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x8d;
        FUN_200aaec(r0);
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r0 = r0 << 9;
        r1 = r1 << 9;
        r2 = r2 << 9;
        FUN_200a9ac(r0, r1, r2);
        FUN_200aab4();
        r3 = 0x11;
        r2 = 0x6;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0xf;
        r1 = 0x6;
        r2 = 0x2;
        r3 = 0x1;
        FUN_200a9a4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }
    }

    //LAB_200a582
    r0 = 0x0;
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    CPU.r8().value = r3;
    return r0;
  }

  @Method(0x200a5b0)
  public static int FUN_200a5b0() {
    int r0;
    int r5;

    r0 = 0x80b;
    r5 = 0x1;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x0;
    }

    //LAB_200a5c0
    r0 = 0x80c;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x0;
    }

    //LAB_200a5cc
    r0 = 0x80d;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x0;
    }

    //LAB_200a5d8
    r0 = 0x80e;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r5 = 0x0;
    }

    //LAB_200a5e4
    r0 = r5;
    return r0;
  }

  @Method(0x200a5fc)
  public static void FUN_200a5fc(int r0, int r1) {
    final int r5;

    r5 = r1;
    r1 = 0x0;
    FUN_200aa64(r0, r1);
    r0 = r5;
    FUN_200a9cc(r0);
  }

  @Method(0x200a614)
  public static void FUN_200a614() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    FUN_200a9d4();
    r0 = 0x8f;
    r1 = 0x1;
    r2 = 0x86;
    r3 = 0x0;
    r2 = r2 << 16;
    r1 = -r1;
    r0 = r0 << 17;
    FUN_200aa9c(r0, r1, r2, r3);
    FUN_200a98c();
    r0 = 0x1;
    sleep(r0);
    r0 = 0x7fff;
    r1 = 0x0;
    FUN_200aac4(r0, r1);
    r1 = 0x0;
    r0 = 0x7fff;
    FUN_200aabc(r0, r1);
    r0 = 0x1;
    FUN_200aacc(r0);
    r0 = 0x1;
    sleep(r0);
    r1 = 0x8c;
    r2 = 0x86;
    r0 = 0x1;
    r1 = r1 << 17;
    r2 = r2 << 16;
    moveActorToPosition(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x0;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x3001ebc;
    r1 = 0xe4;
    r3 = MEMORY.ref(4, r0).get();
    r1 = r1 << 1;
    r7 = 0x1;
    MEMORY.ref(4, r3 + r1).setu(r7);
    CPU.r8().value = r0;
    CPU.r10().value = r1;
    FUN_200aad4();
    FUN_200aae4();
    r1 = 0x1;
    r0 = 0x2051cc;
    FUN_200aabc(r0, r1);
    r0 = 0x78;
    FUN_200aacc(r0);
    r0 = 0x78;
    sleep(r0);
    r0 = 0x201;
    setFlag(r0);
    r0 = 0x80;
    r0 = r0 << 2;
    clearFlag(r0);
    r0 = 0x202;
    clearFlag(r0);
    r0 = 0x80;
    r1 = 0x2;
    r0 = r0 << 9;
    FUN_200aabc(r0, r1);
    r0 = 0x3c;
    FUN_200aacc(r0);
    r0 = 0x64;
    sleep(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200aa84(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200aa84(r0, r1);
    r0 = 0x3c;
    FUN_200a9cc(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x14;
    FUN_200aa74(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x90;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200aa74(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x50;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200aa74(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 5;
    r2 = 0x3c;
    FUN_200aa74(r0, r1, r2);
    r0 = 0xc0;
    r1 = 0xc0;
    r2 = 0x80;
    r1 = r1 << 10;
    r2 = r2 << 9;
    r0 = r0 << 10;
    FUN_200a9ac(r0, r1, r2);
    r0 = 0x14;
    FUN_200a9cc(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200aa74(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200aa74(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0xe666;
    r1 = -r1;
    r0 = -r0;
    FUN_200a9ac(r0, r1, r2);
    r0 = 0x14;
    FUN_200a9cc(r0);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200aa3c(r0, r1);
    r0 = 0x1119;
    FUN_200aa54(r0);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200aa5c(r0);
    r1 = 0x0;
    r0 = 0x0;
    r0 = FUN_200a9e4(r0, r1);
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x28;
    FUN_200a9cc(r0);
    r0 = 0x6b;
    playSound(r0);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 11;
    r2 = r2 << 9;
    r0 = r0 << 11;
    FUN_200a9ac(r0, r1, r2);
    r0 = 0x28;
    FUN_200a9cc(r0);
    FUN_200aab4();
    getMapActor(0)._5a.and(~0x1);
    getMapActor(1)._5a.and(~0x1);
    r1 = 0x4;
    r0 = 0x0;
    r2 = 0x0;
    FUN_200aa34(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200aa34(r0, r1, r2);
    r1 = 0x96;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x82;
    FUN_200a9fc(r0, r1, r2);
    r1 = 0x85;
    r1 = r1 << 1;
    r2 = 0x90;
    r0 = 0x1;
    FUN_200a9fc(r0, r1, r2);
    r0 = 0x1;
    FUN_200aa14(r0);
    r0 = 0x28;
    FUN_200a9cc(r0);
    getMapActor(0)._5a.or(0x1);
    getMapActor(1)._5a.or(0x1);
    r0 = 0x8d;
    FUN_200aaec(r0);
    r0 = 0x80;
    r1 = 0x80;
    r2 = 0x80;
    r2 = r2 << 9;
    r1 = r1 << 9;
    r0 = r0 << 9;
    FUN_200a9ac(r0, r1, r2);
    r0 = 0x28;
    FUN_200a9cc(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200aa3c(r0, r1);
    r0 = 0x1;
    r1 = 0xa;
    FUN_200a5fc(r0, r1);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor = getMapActor(0);
    if(actor != null) {
      r1 = actor.pos_08.getX() >> 16;
      r2 = actor.pos_08.getZ() >> 16;
      FUN_200a9fc(1, r1, r2);
    }

    //LAB_200a88c
    FUN_200aa14(1);
    moveActorToPosition(1, 0, 0);
    r3 = MEMORY.ref(4, CPU.r8().value + 0x14).get();
    MEMORY.ref(2, r3 + 0xe00).setu(0);
    MEMORY.ref(2, r3 + 0xe02).setu(0);
    MEMORY.ref(2, r3 + 0xe04).setu(0);
    MEMORY.ref(1, r3 + 0x2a00).setu(0);
    MEMORY.ref(1, r3 + 0x2a01).setu(1);
    MEMORY.ref(1, r3 + 0x2a02).setu(1);
    MEMORY.ref(1, r3 + 0x2a03).setu(1);
    MEMORY.ref(2, 0x5000000).setu(0);
    r1 = MEMORY.ref(4, CPU.r8().value).get();
    MEMORY.ref(4, r1 + 0x1c0).setu(0x204);
    MEMORY.ref(4, r1 + CPU.r10().value).setu(16);
    FUN_200a9dc();
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  /**
   * Event list 0x200ad34 handler 0
   */
  @Method(value = 0x200a924, ignoreExtraParams = true)
  public static void FUN_200a924() {
    int r0;
    int r1;
    int r2;

    FUN_200a9d4();
    r0 = 0x896;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0xffd;
      FUN_200aa54(r0);
    } else {
      //LAB_200a93c
      r0 = 0xfff;
      FUN_200aa54(r0);
    }

    //LAB_200a942
    r0 = 0x10;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200aa6c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x10;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200aa74(r0, r1, r2);
    FUN_200a9dc();
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200a96c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200a974)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200a97c)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200a984)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200a98c)
  public static void FUN_200a98c() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200a994)
  public static void FUN_200a994(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_8009188} */
  @Method(0x200a99c)
  public static void FUN_200a99c(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200a9a4)
  public static void FUN_200a9a4(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x200a9ac)
  public static void FUN_200a9ac(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200a9b4)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200a9bc)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200a9c4)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200a9cc)
  public static void FUN_200a9cc(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200a9d4)
  public static void FUN_200a9d4() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200a9dc)
  public static void FUN_200a9dc() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200a9e4)
  public static int FUN_200a9e4(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200a9ec)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200a9f4)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200a9fc)
  public static void FUN_200a9fc(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200aa04)
  public static void FUN_200aa04(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200aa0c)
  public static void FUN_200aa0c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200aa14)
  public static void FUN_200aa14(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200aa1c)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200aa24)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200aa2c)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200aa34)
  public static void FUN_200aa34(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200aa3c)
  public static void FUN_200aa3c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200aa44)
  public static void FUN_200aa44(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200aa4c)
  public static void FUN_200aa4c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a158, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200aa54)
  public static void FUN_200aa54(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200aa5c)
  public static Panel24 FUN_200aa5c(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200aa64)
  public static void FUN_200aa64(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200aa6c)
  public static void FUN_200aa6c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200aa74)
  public static void FUN_200aa74(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200aa7c)
  public static void FUN_200aa7c(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200aa84)
  public static void FUN_200aa84(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x200aa8c)
  public static void FUN_200aa8c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200aa94)
  public static void FUN_200aa94(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200aa9c)
  public static void FUN_200aa9c(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200aaa4)
  public static void FUN_200aaa4() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200aaac)
  public static void FUN_200aaac(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x200aab4)
  public static void FUN_200aab4() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200aabc)
  public static void FUN_200aabc(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a338} */
  @Method(0x200aac4)
  public static void FUN_200aac4(final int r0, final int r1) {
    MEMORY.call(0x808a338, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200aacc)
  public static void FUN_200aacc(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200aad4)
  public static void FUN_200aad4() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200aadc)
  public static void FUN_200aadc() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200aae4)
  public static void FUN_200aae4() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x200aaec)
  public static void FUN_200aaec(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200aaf4)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
