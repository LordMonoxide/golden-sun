package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80a;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;
import org.goldensun.types.Vec3;

import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/** World map */
public final class Map2Overlay_877a7c8 {
  private Map2Overlay_877a7c8() { }

  /**
   * Event list 0x200e3f4 handler 5
   */
  @Method(value = 0x2008030, ignoreExtraParams = true)
  public static void FUN_2008030() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r3 = 0x3001ebc;
    r2 = 0x8e;
    r6 = MEMORY.ref(4, r3).get();
    r3 = 0x2000240;
    r2 = r2 << 2;
    r7 = r3 + r2;
    r3 = 0xd6;
    r3 = r3 << 1;
    r5 = r6 + r3;
    r3 = MEMORY.ref(4, r5).get();
    r0 = r3 << 3;
    r0 = r0 + r3;
    r1 = 0xa;
    r0 = FUN_200c174(r0, r1);
    r3 = MEMORY.ref(4, r7).get();
    if(r3 >= r0) {
      r0 = rand();
      r2 = 0x80;
      r2 = r2 << 8;
      if((r0 & 0xffff_ffffL) < (r2 & 0xffff_ffffL)) {
        r0 = 0x808;
        r1 = 0x3;
        FUN_200c41c(r0, r1);
        r3 = 0xd4;
        r3 = r3 << 1;
        r2 = r6 + r3;
        r3 = 0x0;
        MEMORY.ref(4, r2).setu(r3);
      } else {
        //LAB_2008076
        r3 = MEMORY.ref(4, r5).get();
        MEMORY.ref(4, r7).setu(r3);
      }
    }
  }

  /**
   * Event list 0x200e3f4 handler 6
   */
  @Method(value = 0x200808c, ignoreExtraParams = true)
  public static void FUN_200808c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r3 = 0x3001ebc;
    r5 = 0x2000240;
    r2 = 0x8e;
    r2 = r2 << 2;
    r6 = MEMORY.ref(4, r3).get();
    r5 = r5 + r2;
    r2 = r2 - 0x8c;
    r3 = r6 + r2;
    r3 = MEMORY.ref(4, r3).get();
    r0 = r3 << 3;
    r0 = r0 + r3;
    r1 = 0xa;
    r0 = FUN_200c174(r0, r1);
    r3 = MEMORY.ref(4, r5).get();
    if(r3 >= r0) {
      r0 = 0x809;
      r1 = 0x2a;
      FUN_200c41c(r0, r1);
      r3 = 0xd4;
      r3 = r3 << 1;
      r2 = r6 + r3;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
    }
  }

  /**
   * Event list 0x200e3f4 handler 7
   */
  @Method(value = 0x20080d4, ignoreExtraParams = true)
  public static void FUN_20080d4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r3 = 0x3001ebc;
    r5 = 0x2000240;
    r2 = 0x8e;
    r2 = r2 << 2;
    r6 = MEMORY.ref(4, r3).get();
    r5 = r5 + r2;
    r2 = r2 - 0x8c;
    r3 = r6 + r2;
    r3 = MEMORY.ref(4, r3).get();
    r0 = r3 << 3;
    r0 = r0 + r3;
    r1 = 0xa;
    r0 = FUN_200c174(r0, r1);
    r3 = MEMORY.ref(4, r5).get();
    if(r3 >= r0) {
      r0 = 0x80a;
      r1 = 0x18;
      FUN_200c41c(r0, r1);
      r3 = 0xd4;
      r3 = r3 << 1;
      r2 = r6 + r3;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
    }
  }

  @Method(0x200811c)
  public static void FUN_200811c(final Actor70 r0) {
    if(r0._64.get() <= 0x0) {
      r0._64.incr();
    } else {
      //LAB_2008132
      clearActor(r0);
    }
  }

  @Method(0x200813c)
  public static void FUN_200813c(final Actor70 r0) {
    final int r3;
    if((_3001e40.get() & 0x4) != 0) {
      r3 = 0x14ccc;
    } else {
      //LAB_200814e
      r3 = 0x10000;
    }

    //LAB_2008152
    r0.scale_18.set(r3);
    r0._1c.set(r3);

    if((_3001e40.get() & 0x2) != 0) {
      final Actor70 r6 = loadActor(0x11d, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      playSound(0xf6);
      if(r6 != null) {
        r6._55.set(0);
        r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
        FUN_200c244(r6, 0);
        setActorAnimation(r6, 1);
        r6._64.set(0);
        r6._6c.set(getConsumer(Map2Overlay_877a7c8.class, "FUN_200811c", Actor70.class));
      }
    }
  }

  @Method(0x20081c4)
  public static void FUN_20081c4(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0) {
      FUN_200c25c(r0, 10);
    } else {
      //LAB_20081dc
      FUN_200c25c(r0, 7);
    }

    //LAB_20081e4
    if(r0._66.get() == 0) {
      r0.pos_08.setX(0x15d00000);
      r0.pos_08.setY(mul16(sin(r0._64.get() * 8), 0x40000) + 0x100000);
      r0.pos_08.setZ(0x5300000);
      rotVec3(0x100000, r0._64.get(), r0.pos_08);
      r0.angle_06.set(r0._64.get() + 0x4000);
      r0._64.add(0x400);
    }
  }

  @Method(0x2008250)
  public static int FUN_2008250(final Actor70 r0) {
    if(readFlag(0x30) == 0 && readFlag(0x16e) == 0) {
      r0.scale_18.set(0x8000);
      r0._1c.set(0x8000);
      r0._55.set(0);
      r0._64.set(0);
      r0._66.set(0);
      r0._6c.set(getConsumer(Map2Overlay_877a7c8.class, "FUN_20081c4", Actor70.class));
    }

    //LAB_2008284
    return 0;
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008290)
  public static int getRooms() {
    final int r0;

    r0 = 0x200d27c;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008298)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x200829c)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200da2c;
    return r0;
  }

  @Method(0x20082a4)
  public static int FUN_20082a4(final Actor70 r0) {
    FUN_20082cc(r0);

    if(readFlag(0x847) != 0) {
      setActorAnimation(r0, 2);
    }

    //LAB_20082be
    return 1;
  }

  @Method(0x20082cc)
  public static int FUN_20082cc(final Actor70 r0) {
    final int r2 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final Sprite38 r3 = r0.sprite_50.deref();
    r3.rotation_1e.set(MEMORY.ref(2, r2 + 0x11a).getUnsigned());
    r3._26.set(0);
    return 1;
  }

  @Method(0x20082f0)
  public static int FUN_20082f0(final Actor70 r0) {
    r0._59.or(0x1);
    final int r1 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    r0.sprite_50.deref().rotation_1e.set(MEMORY.ref(2, r1 + 0x11a).getUnsigned());
    return 1;
  }

  @Method(0x2008314)
  public static int FUN_2008314(final Actor70 r0) {
    FUN_200c244(r0, 0);
    FUN_200c25c(r0, 10);
    r0._59.set(0);

    if(readFlag(0x8a0) != 0) {
      setFlag(0x2f1);
      r0.pos_08.setX(0);
      r0.pos_08.setY(0);
    }

    //LAB_2008344
    return 0;
  }

  @Method(0x2008350)
  public static int FUN_2008350(final Actor70 r0) {
    if((r0.spriteType_54.get() & 0x1) != 0 && (_3001e40.get() & 0x1) != 0) {
      r0.spriteType_54.xor(0x1);
    }

    //LAB_2008370
    return 1;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x200837c)
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
    r3 = r3 - 0x31;

    switch(r3) {
      case 0: // switch 2008398
        //LAB_2008418
        r0 = 0x94f;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          break;
        }
        r0 = 0x941;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          break;
        }
        r0 = 0x200e154;
        return r0;

      case 15: // switch 2008398
        //LAB_2008430
        r0 = 0x85a;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          break;
        }
        r0 = 0x200e04c;
        return r0;

      case 16: // switch 2008398
      case 21: // switch 2008398
        //LAB_200843e
        r0 = 0x200e1e4;
        return r0;

      case 22: // switch 2008398
        //LAB_2008442
        r0 = 0x200e28c;
        return r0;

      case 23: // switch 2008398
        //LAB_2008446
        r0 = 0x200e394;
        return r0;

      case 24: // switch 2008398
        //LAB_200844a
        r0 = 0x200e3c4;
        return r0;

      case 17: // switch 2008398
      case 18: // switch 2008398
      case 19: // switch 2008398
      case 20: // switch 2008398
      case 26: // switch 2008398
        //LAB_200844e
        r0 = 0x200e25c;
        return r0;

      case 31: // switch 2008398
        //LAB_2008452
        r0 = 0x200e2ec;
        return r0;
    }

    //LAB_2008456
    r0 = 0x235;
    setFlag(r0);
    r0 = 0x200db84;
    return r0;
  }

  @Method(0x20084a0)
  public static void FUN_20084a0(final int r0, final int r1, final int r2) {
    final Structccc struct = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(getMapActor(playerMapActorIndex_2000434.get()).pos_08.getX() < getMapActor(r0 - 100).pos_08.getX()) {
      struct._170.set(r1);
    } else {
      //LAB_20084d2
      struct._170.set(r2);
    }

    //LAB_20084da
    playSound(0x7b);
  }

  @Method(0x20084f0)
  public static void FUN_20084f0(final int r0, final int r1, final int r2) {
    final Structccc struct = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(getMapActor(playerMapActorIndex_2000434.get()).pos_08.getZ() < getMapActor(r0 - 100).pos_08.getZ()) {
      struct._170.set(r1);
    } else {
      //LAB_2008522
      struct._170.set(r2);
    }

    //LAB_200852a
    playSound(0x7b);
  }

  /**
   * Event list 0x200e3f4 handler 30
   */
  @Method(value = 0x2008540, ignoreExtraParams = true)
  public static void FUN_2008540() {
    final int r0;
    final int r1;
    final int r2;

    r0 = 0x82;
    r1 = 0x6;
    r2 = 0x2f;
    FUN_20084a0(r0, r1, r2);
  }

  /**
   * Event list 0x200e3f4 handler 32
   */
  @Method(value = 0x2008550, ignoreExtraParams = true)
  public static void FUN_2008550() {
    final int r0;
    final int r1;
    final int r2;

    r0 = 0x96;
    r1 = 0x2e;
    r2 = 0xb;
    FUN_20084f0(r0, r1, r2);
  }

  /**
   * Event list 0x200e3f4 handler 49
   */
  @Method(value = 0x2008560, ignoreExtraParams = true)
  public static void FUN_2008560() {
    final int r0;
    final int r1;
    final int r2;

    r0 = 0x74;
    r1 = 0x38;
    r2 = 0x15;
    FUN_20084f0(r0, r1, r2);
  }

  /**
   * Event list 0x200e3f4 handler 53
   */
  @Method(value = 0x2008570, ignoreExtraParams = true)
  public static void FUN_2008570() {
    final int r0;
    final int r1;
    final int r2;

    r0 = 0x97;
    r1 = 0x19;
    r2 = 0x36;
    FUN_20084f0(r0, r1, r2);
  }

  /**
   * Event list 0x200e3f4 handler 60
   */
  @Method(value = 0x2008580, ignoreExtraParams = true)
  public static void FUN_2008580() {
    final int r0;
    final int r1;
    final int r2;

    r0 = 0x7d;
    r1 = 0x3b;
    r2 = 0x1e;
    FUN_20084f0(r0, r1, r2);
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008590)
  public static int getEvents() {
    final int r0;

    r0 = 0x200e3f4;
    return r0;
  }

  @Method(0x2008598)
  public static void FUN_2008598() {
    int r2;
    int r3;
    final int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x8;
    final Actor70 r7 = getMapActor(playerMapActorIndex_2000434.get());
    MEMORY.ref(4, CPU.sp().value).setu(r7.radius_20.get() * r7.sprite_50.deref().scale_18.get());
    CPU.r8().value = MEMORY.ref(4, 0x3001ebc).get();
    r5 = MEMORY.ref(4, CPU.r8().value + 0x1e0).get();
    r3 = MEMORY.ref(4, r5 + 0x8).get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3 - 0xa00000);
    CPU.r11().value = r3 + 0xa00000;
    r3 = MEMORY.ref(4, r5 + 0x10).get();
    CPU.r9().value = r3 - 0x12c0000;
    CPU.r10().value = r3 + 0xc80000;
    r6 = 0x8;

    //LAB_20085f4
    do {
      final Actor70 actor = getMapActor2_(r6);
      if(actor != null) {
        r3 = actor.pos_08.getX();
        r2 = actor.pos_08.getZ();
        if(r3 < MEMORY.ref(4, CPU.sp().value + 0x4).get() || r3 > CPU.r11().value || r2 < CPU.r9().value || r2 > CPU.r10().value) {
          //LAB_2008616
          actor.spriteType_54.set(0);
        } else {
          //LAB_2008620
          actor.spriteType_54.set(1);

          if(MEMORY.ref(1, 0x3001f54).getUnsigned() == 0 || readFlag(0x163) == 0) {
            //LAB_200863a
            if(Math.abs(actor.pos_08.getX() - r7.pos_08.getX()) + Math.abs(r7.pos_08.getZ() - actor.pos_08.getZ()) < MEMORY.ref(4, CPU.sp().value).get() + actor.radius_20.get() * actor.sprite_50.deref().scale_18.get()) {
              //LAB_200866c
              if(readFlag(0x104) == 0) {
                MEMORY.ref(2, CPU.r8().value + 0x16c).setu(r6 + 100);
              }
            }
          }
        }
      }

      //LAB_2008684
      r6 = r6 + 0x1;
    } while((r6 & 0xffff_ffffL) <= (0x41 & 0xffff_ffffL));

    CPU.sp().value += 0x8;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  /**
   * Event list 0x200e3f4 handler 26
   */
  @Method(value = 0x20086b4, ignoreExtraParams = true)
  public static void FUN_20086b4() {
    int r0;

    r0 = 0x85a;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x65;
      FUN_200c40c(r0);
    } else {
      //LAB_20086c8
      r0 = 0x7b;
      playSound(r0);
      r0 = 0x3;
      FUN_200c40c(r0);
    }
  }

  /**
   * Event list 0x200e3f4 handler 61
   */
  @Method(value = 0x20086dc, ignoreExtraParams = true)
  public static void FUN_20086dc() {
    final int r0;

    FUN_200c2dc();
    r0 = 0x4a;
    FUN_200c40c(r0);
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x20086ec)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r3 = 0x2000240;
    r1 = 0xe1;
    r1 = r1 << 1;
    r5 = r3 + r1;
    r1 = 0x0;
    r3 = MEMORY.ref(2, r5 + r1).get();
    r2 = MEMORY.ref(2, r5).getUnsigned();
    if(r3 == 0x63) {
      r0 = 0xb0;
      r0 = r0 << 1;
      setFlag(r0);
      r0 = 0x161;
      setFlag(r0);
      r0 = 0x163;
      setFlag(r0);
      r2 = MEMORY.ref(2, r5).getUnsigned();
    }

    //LAB_2008716
    r3 = r2 << 16;
    r3 = r3 >> 16;
    if(r3 == 0x5a) {
      r0 = 0x0;
      FUN_200b9fc(r0);
      r0 = 0x3a;
      r1 = 0x1;
      setMapAndEntranceId(r0, r1);
    } else if(r3 == 0x5b) {
      r0 = 0x1;
      FUN_200b9fc(r0);
      r0 = 0xbb;
      r1 = 0x5d;
      setMapAndEntranceId(r0, r1);
    } else if(r3 == 0x4e) {
      FUN_200c2dc();
      r0 = 0xf2;
      FUN_200c2cc(r0);
      r0 = 0x70;
      FUN_200c40c(r0);
    } else {
      //LAB_2008758
      r0 = 0xa2;
      r0 = r0 << 1;
      setFlag(r0);
      r3 = 0x3001ebc;
      r1 = MEMORY.ref(4, r3).get();
      r3 = 0xe0;
      r3 = r3 << 1;
      r2 = r1 + r3;
      r3 = 0x80;
      r3 = r3 << 3;
      MEMORY.ref(4, r2).setu(r3);
      r3 = 0xe4;
      r3 = r3 << 1;
      r2 = r1 + r3;
      r3 = 0x10;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r0 = 0x80;
      r1 = 0x80;
      r1 = r1 << 9;
      r0 = r0 << 12;
      FUN_200c3ec(r0, r1);
      r0 = 0x12f;
      clearFlag(r0);
      setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_2008598"), 0xc80);
      r0 = 0x90a;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        r1 = 0x80;
        r0 = 0x80;
        r1 = r1 << 1;
        r2 = 0xb0;
        r3 = 0x38;
        FUN_200c23c(r0, r1, r2, r3);
      }

      //LAB_20087b4
      r1 = 0x0;
      r3 = MEMORY.ref(2, r5 + r1).get();
      r3 = r3 - 0x1;

      //LAB_20087c0
      switch(r3) {
        case 0: // switch 20087c8
          //LAB_2008908
          r0 = 0x815;
          r0 = readFlag(r0);
          if(r0 == 0x0) {
            //LAB_2008914
            r0 = 0x815;
            setFlag(r0);
            r0 = 0x85c;
            setFlag(r0);
          }
          break;

        case 32: // switch 20087c8
          //LAB_2008922
          r0 = 0x109;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r0 = 0x85d;
            r0 = readFlag(r0);
            if(r0 == 0x0) {
              r0 = 0x8d;
              r0 = r0 << 2;
              r0 = readFlag(r0);
              if(r0 != 0x0) {
                r5 = 0x200e79c;
                r3 = 0x37;
                MEMORY.ref(4, r5).setu(r3);
                r0 = 0x37;
                r1 = 0x17940000;
                r2 = 0xd480000;
                moveActorToPosition(r0, r1, r2);
                getMapActor(MEMORY.ref(4, r5).get()).angle_06.set(0x3000);
                FUN_200a768();
              }
            }
          } else {
            //LAB_2008966
            r0 = 0x85d;
            r0 = readFlag(r0);
            if(r0 == 0x0) {
              r0 = 0x9b8;
              r0 = readFlag(r0);
              if(r0 == 0x0) {
                FUN_200a4a8();
              }
            }
          }
          break;

        case 48: // switch 20087c8
          //LAB_2008980
          r0 = 0x94f;
          r0 = readFlag(r0);
          if(r0 == 0x0) {
            r0 = 0x941;
            r0 = readFlag(r0);
            if(r0 != 0x0) {
              FUN_2008a8c();
            }
          }
          break;

        case 63: // switch 20087c8
          //LAB_200899a
          r0 = 0x85a;
          r0 = readFlag(r0);
          if(r0 == 0x0) {
            FUN_2008c28();
          }
          break;

        case 64: // switch 20087c8
          //LAB_20089aa
          FUN_20097fc();
          break;

        case 65: // switch 20087c8
          //LAB_20089b0
          FUN_2009888();
          break;

        case 66: // switch 20087c8
          //LAB_20089b6
          FUN_2009938();
          break;

        case 67: // switch 20087c8
          //LAB_20089bc
          FUN_20099e8();
          break;

        case 68: // switch 20087c8
          //LAB_20089c2
          FUN_2009a98();
          break;

        case 69: // switch 20087c8
          //LAB_20089c8
          FUN_2009b5c();
          break;

        case 70: // switch 20087c8
          //LAB_20089ce
          FUN_200a274();
          break;

        case 71: // switch 20087c8
          //LAB_20089d4
          FUN_200b57c();
          break;

        case 72: // switch 20087c8
          //LAB_20089da
          FUN_200b130();
          break;

        case 73: // switch 20087c8
        case 75: // switch 20087c8
        case 76: // switch 20087c8
          //LAB_20089e0
          r0 = 0x8e;
          r0 = r0 << 1;
          setFlag(r0);
          r0 = 0xbe;
          r0 = r0 << 2;
          r0 = readFlagsByte(r0);
          if(r0 != 0x0) {
            _2000432.set(2);
            setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b678"), 0xc80);
          }
          break;

        case 74: // switch 20087c8
          //LAB_2008a0c
          FUN_200b2f0();
          break;

        case 79: // switch 20087c8
          //LAB_2008a12
          FUN_200acb4();
          break;

        case 1: // switch 20087c8
        case 2: // switch 20087c8
        case 3: // switch 20087c8
        case 4: // switch 20087c8
        case 5: // switch 20087c8
        case 6: // switch 20087c8
        case 7: // switch 20087c8
        case 8: // switch 20087c8
        case 9: // switch 20087c8
        case 10: // switch 20087c8
        case 11: // switch 20087c8
        case 12: // switch 20087c8
        case 13: // switch 20087c8
        case 14: // switch 20087c8
        case 15: // switch 20087c8
        case 16: // switch 20087c8
        case 17: // switch 20087c8
        case 18: // switch 20087c8
        case 19: // switch 20087c8
        case 20: // switch 20087c8
        case 21: // switch 20087c8
        case 22: // switch 20087c8
        case 23: // switch 20087c8
        case 24: // switch 20087c8
        case 25: // switch 20087c8
        case 26: // switch 20087c8
        case 27: // switch 20087c8
        case 28: // switch 20087c8
        case 29: // switch 20087c8
        case 30: // switch 20087c8
        case 31: // switch 20087c8
        case 33: // switch 20087c8
        case 34: // switch 20087c8
        case 35: // switch 20087c8
        case 36: // switch 20087c8
        case 37: // switch 20087c8
        case 38: // switch 20087c8
        case 39: // switch 20087c8
        case 40: // switch 20087c8
        case 41: // switch 20087c8
        case 42: // switch 20087c8
        case 43: // switch 20087c8
        case 44: // switch 20087c8
        case 45: // switch 20087c8
        case 46: // switch 20087c8
        case 47: // switch 20087c8
        case 49: // switch 20087c8
        case 50: // switch 20087c8
        case 51: // switch 20087c8
        case 52: // switch 20087c8
        case 53: // switch 20087c8
        case 54: // switch 20087c8
        case 55: // switch 20087c8
        case 56: // switch 20087c8
        case 57: // switch 20087c8
        case 58: // switch 20087c8
        case 59: // switch 20087c8
        case 60: // switch 20087c8
        case 61: // switch 20087c8
        case 62: // switch 20087c8
        case 77: // switch 20087c8
        case 78: // switch 20087c8
          //LAB_2008a18
          getMapActor(53).scale_18.set(0x14000);
          getMapActor(53)._1c.set(0x14000);
          break;
      }
    }

    //LAB_2008a2c
    r0 = 0x0;
    return r0;
  }

  @Method(0x2008a8c)
  public static void FUN_2008a8c() {
    int r0;
    int r1;
    int r2;

    FUN_200c2dc();
    FUN_200c43c();
    FUN_200c44c();
    FUN_200c45c();
    r0 = 0x94f;
    setFlag(r0);
    r1 = 0xb7;
    r0 = 0xb;
    r1 = r1 << 21;
    r2 = 0x49c0000;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x18;
    r2 = 0x8;
    r0 = 0xb;
    FUN_200c34c(r0, r1, r2);
    r0 = 0xb;
    FUN_200c354(r0);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r1 = 0xb7;
    r0 = 0xc;
    r1 = r1 << 21;
    r2 = 0x49c0000;
    moveActorToPosition(r0, r1, r2);
    r1 = 0xc;
    r2 = 0x18;
    r0 = 0xc;
    FUN_200c34c(r0, r1, r2);
    r0 = 0x1e;
    FUN_200c2d4(r0);
    r1 = 0xa0;
    r0 = 0xb;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0xc;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x78;
    FUN_200c2d4(r0);
    r2 = 0x97;
    r1 = 0x16f80000;
    r2 = r2 << 19;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0xc;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor8 = getMapActor(8);
    if(actor8 != null) {
      r1 = actor8.pos_08.getX() >> 16;
      r2 = actor8.pos_08.getZ() >> 16;
      FUN_200c32c(12, r1, r2);
    }

    //LAB_2008b48
    r0 = 0xc;
    FUN_200c354(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xc;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0xb;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor8 != null) {
      r1 = actor8.pos_08.getX() >> 16;
      r2 = actor8.pos_08.getZ() >> 16;
      FUN_200c32c(11, r1, r2);
    }

    //LAB_2008b7e
    r0 = 0xb;
    FUN_200c354(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xb;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor8 != null) {
      r1 = actor8.pos_08.getX() >> 16;
      r2 = actor8.pos_08.getZ() >> 16;
      FUN_200c32c(0, r1, r2);
    }

    //LAB_2008bb4
    r0 = 0x0;
    FUN_200c354(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = r2 << 7;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x38;
    r2 = 0x8;
    r0 = 0x8;
    FUN_200c34c(r0, r1, r2);
    r0 = 0x8;
    FUN_200c354(r0);
    r1 = 0x28;
    r2 = 0x28;
    r0 = 0x8;
    FUN_200c34c(r0, r1, r2);
    r0 = 0x8;
    FUN_200c354(r0);
    r1 = 0x8;
    r2 = 0x58;
    r0 = 0x8;
    FUN_200c34c(r0, r1, r2);
    r0 = 0x8;
    FUN_200c354(r0);
    FUN_200c444();
    r0 = 0x6c;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2008c28)
  public static void FUN_2008c28() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    final Actor70 r6 = getMapActor(15);
    FUN_200c2dc();
    r0 = 0xa0;
    r1 = 0x1;
    r0 = r0 << 9;
    FUN_200c48c(r0, r1);
    r0 = 0x4;
    sleep(r0);
    FUN_200c43c();
    FUN_200c44c();
    FUN_200c45c();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xc5;
    r0 = 0x0;
    r1 = 0x16fc;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r2 = 0xc5;
    r2 = r2 << 19;
    r1 = 0x16d80000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r1 = 0xf;
    r0 = 0x8;
    FUN_200c394(r0, r1);
    r1 = 0x0;
    FUN_200c244(getMapActor(8), r1);
    r0 = 0xa;
    r1 = 0x19999;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x19999;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x19999;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x6666;
    r1 = 0x19999;
    r0 = 0xd;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8d;
    playSound(r0);
    r1 = 0x200c9e4;
    r0 = 0xa;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cb50;
    r0 = 0xb;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cc74;
    r0 = 0xc;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cd98;
    r0 = 0xd;
    FUN_200c324(r0, r1);
    r0 = 0x121;
    playSound(r0);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(1, r1, r2);
    }

    //LAB_2008d36
    r2 = 0xc8;
    r0 = 0x1;
    r1 = 0x1704;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x101;
    r2 = 0x3c;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0xc7;
    r1 = 0x16d80000;
    r2 = r2 << 19;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x1215;
    FUN_200c3a4(r0);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x28;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x3c;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0xa;
    r1 = r1 << 7;
    r0 = 0x1;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8d;
    playSound(r0);
    r1 = 0x200ca78;
    r0 = 0xa;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cbe4;
    r0 = 0xb;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cd08;
    r0 = 0xc;
    FUN_200c314(r0, r1);
    r0 = 0xa;
    FUN_200c2d4(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 7;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x200ce2c;
    r0 = 0xd;
    FUN_200c324(r0, r1);
    r0 = 0x121;
    playSound(r0);
    r0 = 0x14;
    FUN_200c2d4(r0);
    FUN_200c464();
    r0 = 0xa;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xd;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x1;
    r2 = 0xdf;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 19;
    r0 = 0x16080000;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    r0 = 0x14;
    FUN_200c2d4(r0);
    FUN_200c45c();
    r2 = 0xdb;
    r1 = 0x16080000;
    r2 = r2 << 19;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x9;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xd9;
    r0 = 0x9;
    r1 = 0x1608;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r2 = 0xd9;
    r0 = 0x9;
    r1 = 0x15f8;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r2 = 0xdf;
    r2 = r2 << 3;
    r1 = 0x15f8;
    r0 = 0x9;
    FUN_200c344(r0, r1, r2);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200c384(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200c3dc(r0, r1);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r2 = 0x14;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3;
    FUN_200c37c(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r2 = 0xdf;
    r2 = r2 << 19;
    r1 = 0x16180000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200c394(r0, r1);
    r1 = 0x1;
    FUN_200c244(getMapActor(8), r1);
    r0 = 0x8;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xdf;
    r2 = r2 << 3;
    r1 = 0x1608;
    r0 = 0x8;
    FUN_200c344(r0, r1, r2);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x2;
    FUN_200c37c(r0, r1);
    r0 = 0x2008;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 6;
    r2 = 0x3c;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200c3dc(r0, r1);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x8;
    r1 = r1 << 6;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200c3dc(r0, r1);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x2;
    FUN_200c37c(r0, r1);
    r2 = 0x28;
    r0 = 0x2008;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x105;
    r2 = 0x3c;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x2008;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x2008;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x101;
    r2 = 0x3c;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    FUN_200c464();
    r0 = 0x6b;
    playSound(r0);
    r0 = 0x80;
    r1 = 0x80;
    r1 = r1 << 11;
    r0 = r0 << 11;
    FUN_200c3ec(r0, r1);
    FUN_200955c();
    r0 = 0x121;
    playSound(r0);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200c3d4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200c3d4(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xb0;
    r2 = 0x0;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xd9;
    r3 = 0x1;
    r0 = 0x15e80000;
    r1 = -r1;
    r2 = r2 << 19;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    r2 = 0xd5;
    r1 = 0x15a80000;
    r2 = r2 << 19;
    r0 = 0xe;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x2666;
    r0 = 0xe;
    r1 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x200cebc;
    r0 = 0xe;
    FUN_200c314(r0, r1);
    r0 = 0xa0;
    FUN_200c2d4(r0);
    r3 = 0x1999;
    r6._44.set(r3);
    r6._48.set(r3);
    r3 = 0xc0;
    r3 = r3 << 9;
    r6.scale_18.set(r3);
    r6._1c.set(r3);
    r3 = 0x0;
    r6._64.set(r3);
    r3 = 0x80;
    r3 = r3 << 15;
    r6.pos_08.setY(r3);
    r3 = 0xf0;
    r3 = r3 << 8;
    r6.sprite_50.deref().rotation_1e.set(r3);
    r1 = 0x0;
    FUN_200c244(r6, r1);
    r1 = 0x2;
    setActorAnimation(r6, r1);
    r0 = 0x1;
    sleep(r0);
    FUN_200c244(getMapActor(15), 0);
    setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_20097a4"), 0xc80);

    //LAB_200917a
    do {
      r0 = 0x1;
      sleep(r0);
      r3 = r6._64.get();
    } while(r3 == 0x0);

    r1 = 0x0;
    FUN_200c244(getMapActor(15), r1);
    r1 = 0x0;
    FUN_200c244(getMapActor(14), r1);
    r0 = 0xa;
    FUN_200c2d4(r0);
    r5 = 0xc0;
    r5 = r5 << 11;
    getMapActor(9).velocity_24.setY(r5);
    getMapActor(8).velocity_24.setY(r5);
    r0 = 0x91;
    playSound(r0);
    r0 = 0x80;
    r1 = 0x80;
    r1 = r1 << 11;
    r0 = r0 << 11;
    FUN_200c3ec(r0, r1);
    FUN_2009680();
    FUN_2009680();
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 10;
    r1 = r1 << 7;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xdf;
    r3 = 0x1;
    r2 = r2 << 19;
    r0 = 0x16080000;
    r1 = -r1;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    FUN_200c45c();
    r1 = 0x81;
    r0 = 0x9;
    r1 = r1 << 1;
    FUN_200c3dc(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200c3dc(r0, r1);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    clearTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_20097a4"));
    r0 = 0x1;
    sleep(r0);
    r0 = 0xe;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xf;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x4;
    r2 = 0x28;
    FUN_200c374(r0, r1, r2);
    r0 = 0x2008;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x2008;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x4;
    r2 = 0x14;
    FUN_200c374(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x9;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200c3c4(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x2008;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x9;
    FUN_200c3dc(r0, r1);
    r0 = 0x50;
    FUN_200c2d4(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r2 = 0xdf;
    r0 = 0x8;
    r1 = 0x1618;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xd9;
    r0 = 0x9;
    r1 = 0x15f8;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r2 = 0xd9;
    r0 = 0x9;
    r1 = 0x1608;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r2 = 0xdb;
    r0 = 0x9;
    r1 = 0x1608;
    r2 = r2 << 3;
    FUN_200c344(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x9;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x8d;
    playSound(r0);
    r1 = 0x200cac4;
    r0 = 0xa;
    FUN_200c314(r0, r1);
    r1 = 0x200cc30;
    r0 = 0xb;
    FUN_200c314(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    r1 = 0x200cd54;
    r0 = 0xc;
    FUN_200c314(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    r1 = 0x200ce78;
    r0 = 0xd;
    FUN_200c324(r0, r1);
    FUN_200c464();
    r2 = 0xc5;
    r0 = 0x0;
    r1 = 0x170c0000;
    r2 = r2 << 19;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xc8;
    r2 = r2 << 19;
    r0 = 0x1;
    r1 = 0x17140000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 11;
    r1 = r1 << 8;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xc9;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x16d80000;
    r1 = -r1;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    r5 = 0x200caf4;
    r0 = 0xa;
    r1 = r5;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x6666;
    r1 = 0xccc;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xc1;
    r3 = 0x1;
    r2 = r2 << 19;
    r0 = 0x16d80000;
    r1 = -r1;
    FUN_200c3f4(r0, r1, r2, r3);
    r1 = r5;
    r0 = 0xb;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = r5;
    r0 = 0xc;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r1 = r5;
    r0 = 0xd;
    FUN_200c314(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x1;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0xd;
    FUN_200c31c(r0);
    r0 = 0x121;
    playSound(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 11;
    r1 = r1 << 8;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xc9;
    r3 = 0x1;
    r0 = 0x16f80000;
    r1 = -r1;
    r2 = r2 << 19;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x50;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_200c32c(1, r1, r2);
    }

    //LAB_2009490
    r0 = 0x1;
    FUN_200c354(r0);
    r2 = 0x0;
    r0 = 0x1;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r2 = 0xc9;
    r3 = 0x1;
    r0 = 0x16d80000;
    r1 = -r1;
    r2 = r2 << 19;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x0;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xc5;
    r1 = 0x16d8;
    r2 = r2 << 3;
    r0 = 0x0;
    FUN_200c344(r0, r1, r2);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x85a;
    setFlag(r0);
    r0 = 0x3;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x200955c)
  public static void FUN_200955c() {
    int r0;
    int r1;
    int r2;
    int r3;

    r1 = 0x1;
    r2 = 0xdf;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x160c0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6fc0000;
    r3 = 0x1;
    r0 = 0x16040000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6f40000;
    r3 = 0x1;
    r0 = 0x160c0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6fc0000;
    r3 = 0x1;
    r0 = 0x160c0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6f40000;
    r3 = 0x1;
    r0 = 0x16040000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xdf;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x16080000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xdf;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x160a0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6fa0000;
    r3 = 0x1;
    r0 = 0x16060000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6f60000;
    r3 = 0x1;
    r0 = 0x160a0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6fa0000;
    r3 = 0x1;
    r0 = 0x160a0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6f60000;
    r3 = 0x1;
    r0 = 0x16060000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xdf;
    r0 = 0x16080000;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
  }

  @Method(0x2009680)
  public static void FUN_2009680() {
    int r0;
    int r1;
    int r2;
    int r3;

    r1 = 0x1;
    r2 = 0xd9;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x15ec0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6cc0000;
    r3 = 0x1;
    r0 = 0x15e40000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6c40000;
    r3 = 0x1;
    r0 = 0x15ec0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6cc0000;
    r3 = 0x1;
    r0 = 0x15ec0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6c40000;
    r3 = 0x1;
    r0 = 0x15e40000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xd9;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x15e80000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xd9;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    r0 = 0x15ea0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6ca0000;
    r3 = 0x1;
    r0 = 0x15e60000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6c60000;
    r3 = 0x1;
    r0 = 0x15ea0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6ca0000;
    r3 = 0x1;
    r0 = 0x15ea0000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r1 = -r1;
    r2 = 0x6c60000;
    r3 = 0x1;
    r0 = 0x15e60000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
    r1 = 0x1;
    r2 = 0xd9;
    r0 = 0x15e80000;
    r1 = -r1;
    r2 = r2 << 19;
    r3 = 0x1;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x4;
    sleep(r0);
  }

  @Method(0x20097a4)
  public static void FUN_20097a4() {
    final Actor70 r5 = getMapActor(15);
    final Actor70 r0 = getMapActor(14);
    r5.pos_08.setX(r0.pos_08.getX());
    r5.pos_08.setZ(r0.pos_08.getZ());
    if(r5.pos_08.getY() < 0xa0000) {
      r5.pos_08.setY(0xa0000);
      if(readFlag(0x200) == 0) {
        playSound(0x91);
        setActorAnimation(r5, 3);
        setFlag(0x200);
        r5._64.set(1);
      }
    }
  }

  @Method(0x20097fc)
  public static void FUN_20097fc() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x0;
    r0 = 0x0;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x6666;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x14a8;
    r2 = 0x918;
    r0 = 0x8;
    FUN_200c344(r0, r1, r2);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x927;
    setFlag(r0);
    r0 = 0x66;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2009888)
  public static void FUN_2009888() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xc8;
    r2 = r2 << 16;
    r1 = 0x1f080000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r3 = 0x0;
    r5._64.set(r3);
    r1 = 0x200d158;
    r0 = 0x8;
    FUN_200c314(r0, r1);

    //LAB_20098f6
    do {
      r0 = 0x1;
      sleep(r0);
      r3 = r5._64.get();
    } while(r3 == 0x0);

    FUN_200c444();
    FUN_200c44c();
    r0 = 0x927;
    setFlag(r0);
    r0 = 0x67;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2009938)
  public static void FUN_2009938() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xc8;
    r2 = r2 << 16;
    r1 = 0x1f080000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r3 = 0x0;
    r5._64.set(r3);
    r1 = 0x200d158;
    r0 = 0x8;
    FUN_200c314(r0, r1);

    //LAB_20099a6
    do {
      r0 = 0x1;
      sleep(r0);
      r3 = r5._64.get();
    } while(r3 == 0x0);

    FUN_200c444();
    FUN_200c44c();
    r0 = 0x927;
    setFlag(r0);
    r0 = 0x68;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x20099e8)
  public static void FUN_20099e8() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xc8;
    r2 = r2 << 16;
    r1 = 0x1f080000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r3 = 0x0;
    r5._64.set(r3);
    r1 = 0x200d158;
    r0 = 0x8;
    FUN_200c314(r0, r1);

    //LAB_2009a56
    do {
      r0 = 0x1;
      sleep(r0);
      r3 = r5._64.get();
    } while(r3 == 0x0);

    FUN_200c444();
    FUN_200c44c();
    r0 = 0x927;
    setFlag(r0);
    r0 = 0x69;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2009a98)
  public static void FUN_2009a98() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0xc8;
    r2 = r2 << 16;
    r1 = 0x1f080000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r3 = 0x0;
    r5._64.set(r3);
    r0 = FUN_200b41c();
    if(r0 == 0xb) {
      r1 = 0x200d1b8;
      r0 = 0x8;
      FUN_200c314(r0, r1);
    } else {
      //LAB_2009b10
      r1 = 0x200d158;
      r0 = 0x8;
      FUN_200c314(r0, r1);
    }

    //LAB_2009b18
    do {
      r0 = 0x1;
      sleep(r0);
      r3 = r5._64.get();
    } while(r3 == 0x0);

    FUN_200c444();
    FUN_200c44c();
    r0 = 0x927;
    setFlag(r0);
    r0 = 0x6a;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2009b5c)
  public static void FUN_2009b5c() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(8);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0x9180000;
    r1 = 0x13e80000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c3e4(r0, r1);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x6666;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x13c8;
    r2 = 0x918;
    r0 = 0x8;
    FUN_200c344(r0, r1, r2);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x93e;
    setFlag(r0);
    r0 = 0x927;
    clearFlag(r0);
    r0 = 0x6b;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x2009c08)
  public static void FUN_2009c08() {
    int r0;
    int r1;
    final int r2;

    FUN_200c464();
    r0 = 0x80;
    r0 = r0 << 9;
    r1 = 0x6;
    FUN_200c48c(r0, r1);
    FUN_200c494();
    FUN_200c45c();
    r1 = 0x2;
    r0 = 0x8;
    FUN_200c384(r0, r1);
    r0 = 0xc66;
    FUN_200c3a4(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200c3b4(r0, r1);
    r0 = 0x1e;
    FUN_200c2d4(r0);
    r0 = 0x6f;
    playSound(r0);
    r1 = 0x2;
    r0 = 0x0;
    r0 = FUN_200c284(r0, r1);
    r0 = 0x16f;
    clearFlag(r0);
    r0 = 0x171;
    clearFlag(r0);
    r0 = handleDjinnMenu();
    r2 = 0x1e;
    r1 = 0x4;
    r0 = 0x8;
    FUN_200c374(r0, r1, r2);
    r0 = 0xc67;
    FUN_200c3a4(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200c3b4(r0, r1);
    r0 = 0x16f;
    clearFlag(r0);
    r0 = 0x171;
    setFlag(r0);
    r0 = handleDjinnMenu();
    r0 = 0x1e;
    FUN_200c2d4(r0);
    r0 = 0xc;
    r1 = 0x6;
    startEncounter(r0, r1);
  }

  /**
   * Event list 0x200e3f4 handler 0
   */
  @Method(value = 0x2009ca4, ignoreExtraParams = true)
  public static void FUN_2009ca4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    final Actor70 r6 = getMapActor(8);
    final Actor70 actor0 = getMapActor(0);
    r1 = 0xea300000;
    r3 = actor0.pos_08.getX();
    r3 = r3 + r1;
    r2 = r3 >>> 31;
    r3 = r3 + r2;
    r2 = 0x15d00000;
    r3 = r3 >> 1;
    CPU.r11().value = r2;
    r3 = r3 + CPU.r11().value;
    CPU.r9().value = r3;
    r1 = 0xfad00000;
    r3 = actor0.pos_08.getZ();
    r3 = r3 + r1;
    r2 = r3 >>> 31;
    r3 = r3 + r2;
    r7 = 0xa6;
    r3 = r3 >> 1;
    r7 = r7 << 19;
    r0 = 0xb7;
    r3 = r3 + r7;
    r0 = r0 << 1;
    r5 = 0x0;
    CPU.r10().value = r3;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      //LAB_2009cf8
      r0 = 0x1;
      restorePlayer(r0);
      r0 = 0xb7;
      r0 = r0 << 1;
      setFlag(r0);
      FUN_200c2dc();

      if(actor0 != null) {
        r1 = actor0.pos_08.getX();
        r2 = actor0.pos_08.getZ();
        moveActorToPosition(8, r1, r2);
      }

      //LAB_2009d1e
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x0;
      r0 = FUN_200c2b4(r0, r1, r2);
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x0;
      FUN_200c2bc(r0, r1, r2);
      FUN_200c45c();
      r1 = 0x8;
      r2 = 0x0;
      r0 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r0 = 0xa;
      FUN_200c2d4(r0);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x3c;
      FUN_200c3d4(r0, r1, r2);
      r3 = 0x1;
      r6._66.set(r3);
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x8;
      FUN_200c38c(r0, r1, r2);
      r0 = 0x10;
      sleep(r0);
      r0 = 0xc4f;
      FUN_200c3a4(r0);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      FUN_200c464();
      r0 = 0x13333;
      r1 = 0x6;
      FUN_200c48c(r0, r1);
      FUN_200c494();
      FUN_200c45c();
      r3 = 0x2;
      r6._55.set(r3);
      r3 = 0x80;
      r3 = r3 << 7;
      r6._48.set(r3);
      r3 = 0x80;
      r3 = r3 << 9;
      r6.velocityScalar_30.set(r3);
      r6.acceleration_34.set(r3);
      r6.velocity_24.setY(r5);
      r6._14.set(r5);
      r3 = r7;
      r1 = CPU.r11().value;
      r2 = 0x0;
      moveActorTo(r6, r1, r2, r3);
      r7 = 0x80;
      r7 = r7 << 4;
      r5 = 0xf;

      //LAB_2009db8
      do {
        r6.scale_18.add(r7);
        r6._1c.add(r7);
        r0 = 0x1;
        r5 = r5 - 0x1;
        sleep(r0);
      } while(r5 >= 0x0);

      r0 = 0x8;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r0 = 0x10;
      sleep(r0);
      r6._6c.clear();
      r1 = 0x0;
      FUN_200c25c(r6, r1);
      r3 = 0x80;
      r3 = r3 << 9;
      r6._48.set(r3);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3b4(r0, r1);
      r0 = 0x83;
      playSound(r0);
      r0 = 0x8c;
      r1 = 0x0;
      FUN_200c474(r0, r1);
      r7 = 0x3001e40;
      r5 = 0x3b;

      //LAB_2009e16
      do {
        r3 = MEMORY.ref(4, r7).get();
        r2 = 0x2;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          r1 = 0x7;
          FUN_200c25c(r6, r1);
        } else {
          //LAB_2009e48
          r1 = 0x0;
          FUN_200c25c(r6, r1);
        }

        //LAB_2009e50
        r3 = MEMORY.ref(4, r7).get();
        r2 = 0xf;
        r3 = r3 & r2;
        if(r3 == 0x0) {
          FUN_200c058(r6);
        }

        //LAB_2009e60
        r0 = 0x1;
        r5 = r5 - 0x1;
        sleep(r0);
      } while(r5 >= 0x0);

      FUN_200c47c();
      r1 = 0x0;
      FUN_200c25c(r6, r1);
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c384(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r1 = 0x81;
      r2 = 0x1e;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200c3d4(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x1e;
      FUN_200c3d4(r0, r1, r2);
      r3 = CPU.r9().value;
      r1 = r3 >> 16;
      r3 = CPU.r10().value;
      r2 = r3 >> 16;
      r0 = 0x8;
      FUN_200c344(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x16;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x28;
      FUN_200c3d4(r0, r1, r2);
      r2 = 0x1e;
      r0 = 0x8;
      r1 = 0x4;
      FUN_200c374(r0, r1, r2);
      r0 = 0x96;
      r0 = r0 << 1;
      r1 = 0x4;
      FUN_200c26c(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r1 = 0x80;
      r2 = 0x1e;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200c3d4(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r0 = 0x0;
      r1 = 0x2;
      FUN_200c384(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r2 = 0x1e;
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c374(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r5 = 0x0;
      r2 = 0x80;
      r6._55.set(r5);
      r1 = CPU.r9().value;
      r2 = r2 << 13;
      r3 = CPU.r10().value;
      moveActorTo(r6, r1, r2, r3);
      r7 = 0x1000;
      r5 = 0xf;

      //LAB_2009f38
      do {
        r6.angle_06.add(r7);
        r0 = 0x1;
        r5 = r5 - 0x1;
        sleep(r0);
      } while(r5 >= 0x0);

      r0 = 0x0;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3b4(r0, r1);
      r2 = 0x0;
      r3 = 0x2;
      r6._55.set(r3);
      r7 = 0x1000;
      r6.velocity_24.setY(r2);
      r6._14.set(r2);
      r5 = 0x7;

      //LAB_2009f76
      do {
        r6.angle_06.add(r7);
        r0 = 0x1;
        r5 = r5 - 0x1;
        sleep(r0);
      } while(r5 >= 0x0);

      r0 = 0x0;
      r1 = 0x16;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r1 = 0x81;
      r0 = 0x8;
      r1 = r1 << 1;
      r2 = 0x1e;
      FUN_200c3d4(r0, r1, r2);
      r2 = 0x0;
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c384(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r0 = 0x8;
      r1 = 0x2;
      r2 = 0x1e;
      FUN_200c374(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3ac(r0);
      r5 = 0x0;

      //LAB_2009fd2
      do {
        r0 = 0x0;
        r1 = 0x0;
        r0 = FUN_200c2f4(r0, r1);
        if(r0 != 0x1) {
          //LAB_200a01a
          r0 = 0x0;
          r1 = 0x16;
          setActorAnimationIfLoaded(r0, r1);
          r0 = 0x8;
          r1 = 0x2;
          r2 = 0x14;
          FUN_200c374(r0, r1, r2);
          r1 = 0x4;
          r0 = 0x8;
          r2 = 0x14;
          FUN_200c374(r0, r1, r2);
          r0 = 0xc63;
          FUN_200c3a4(r0);
          r0 = 0x8;
          r1 = 0x0;
          FUN_200c3b4(r0, r1);
          break;
        }
        r0 = 0x8;
        r1 = 0x2;
        r2 = 0x14;
        FUN_200c374(r0, r1, r2);
        r0 = 0x8;
        r1 = 0x2;
        r2 = 0x14;
        FUN_200c374(r0, r1, r2);
        if(r5 == 0x6) {
          r0 = 0xc62;
          FUN_200c3a4(r0);
          r0 = 0x8;
          r1 = 0x0;
          FUN_200c3b4(r0, r1);
          break;
        }

        //LAB_200a006
        r0 = 0xc5c;
        r0 = r5 + r0;
        FUN_200c3a4(r0);
        r0 = 0x8;
        r1 = 0x0;
        FUN_200c3ac(r0);
        r5 = r5 + 0x1;
      } while(true);

      //LAB_200a044
      r0 = 0x96;
      r1 = 0x4;
      r0 = r0 << 1;
      FUN_200c26c(r0, r1);
      r0 = 0x51;
      playSound(r0);
      r5 = 0xc64;
      r1 = 0x3;
      r0 = r5;
      r5 = r5 + 0x1;
      FUN_200c264(r0, r1);
      r0 = r5;
      FUN_200c3a4(r0);
      r2 = 0x14;
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c374(r0, r1, r2);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3b4(r0, r1);
      r0 = 0x9;
      playSound(r0);
      FUN_2009c08();
      FUN_200c464();
    } else {
      //LAB_200a080
      FUN_200c2dc();

      if(actor0 != null) {
        r1 = actor0.pos_08.getX();
        r2 = actor0.pos_08.getZ();
        moveActorToPosition(8, r1, r2);
      }

      //LAB_200a098
      r3 = 0xa0;
      r3 = r3 << 12;
      r1 = CPU.r9().value;
      r2 = 0x0;
      r6.velocity_24.setY(r3);
      r3 = CPU.r10().value;
      moveActorTo(r6, r1, r2, r3);
      r0 = 0x1e;
      FUN_200c2d4(r0);
      FUN_200c45c();
      r0 = 0x8;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r2 = 0x0;
      r0 = 0x0;
      r1 = 0x8;
      FUN_200c38c(r0, r1, r2);
      r1 = 0x16;
      r0 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xc68;
      FUN_200c3a4(r0);
      r0 = 0x8;
      r1 = 0x2;
      r2 = 0x14;
      FUN_200c374(r0, r1, r2);
      r2 = 0x14;
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c374(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c384(r0, r1);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3b4(r0, r1);
      r0 = 0x6f;
      playSound(r0);
      r1 = 0x2;
      r0 = 0x0;
      r0 = FUN_200c284(r0, r1);
      r0 = 0x16f;
      setFlag(r0);
      r0 = 0x171;
      clearFlag(r0);
      r0 = handleDjinnMenu();
      r0 = 0xc6a;
      FUN_200c3a4(r0);
      r3 = r7;
      r2 = 0x0;
      r1 = CPU.r11().value;
      moveActorTo(r6, r1, r2, r3);
      r0 = 0x1e;
      FUN_200c2d4(r0);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r2 = 0x0;
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c38c(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3ac(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200c2f4(r0, r1);
      if(r0 == 0x1) {
        r0 = 0x0;
        r1 = 0x16;
        setActorAnimationIfLoaded(r0, r1);
        r1 = 0x2;
        r0 = 0x8;
        FUN_200c384(r0, r1);
        r0 = 0xc6d;
        FUN_200c3a4(r0);
        r1 = 0x0;
        r0 = 0x8;
        FUN_200c3ac(r0);
        r0 = 0x0;
        r1 = 0x0;
        r0 = FUN_200c2f4(r0, r1);
        if(r0 != 0x1) {
          r0 = 0x8;
          r1 = 0x0;
          FUN_200c3b4(r0, r1);
          r3 = CPU.r10().value;
          r2 = CPU.r9().value;
          r1 = r2 >> 16;
          r0 = 0x8;
          r2 = r3 >> 16;
          FUN_200c344(r0, r1, r2);
          FUN_2009c08();
          FUN_200c464();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return;
        }
      }

      //LAB_200a1b0
      r1 = 0x16;
      r0 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xc6f;
      FUN_200c3a4(r0);
      r0 = 0x8;
      r1 = 0x2;
      r2 = 0x14;
      FUN_200c374(r0, r1, r2);
      r2 = 0x14;
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c374(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r1 = 0x80;
      r2 = 0x1e;
      r0 = 0x8;
      r1 = r1 << 1;
      FUN_200c3d4(r0, r1, r2);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200c3b4(r0, r1);
      r0 = 0x16f;
      setFlag(r0);
      r0 = 0x171;
      setFlag(r0);
      r0 = handleDjinnMenu();
      r2 = 0x14;
      r0 = 0x8;
      r1 = 0x2;
      FUN_200c374(r0, r1, r2);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200c3b4(r0, r1);
      FUN_200c464();
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x8;
      FUN_200c484(r0, r1, r2);
      r0 = 0x2a;
      playSound(r0);
      FUN_200c2e4();
      r0 = 0xb7;
      r0 = r0 << 1;
      clearFlag(r0);
      r0 = 0x16f;
      clearFlag(r0);
      r0 = 0x171;
      clearFlag(r0);
    }

    //LAB_200a23c
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x200a274)
  public static void FUN_200a274() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(10);
    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r1 = -r1;
    r2 = -r2;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r3 = 0xc0;
    r3 = r3 << 9;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r3 = 0x80;
    r3 = r3 << 7;
    r5.angle_06.set(r3);
    FUN_200c43c();
    FUN_200c44c();
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x15680000;
    r2 = 0x8380000;
    r0 = 0xa;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8d;
    playSound(r0);
    r2 = 0x6666;
    r0 = 0xa;
    r1 = 0x19999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x858;
    r0 = 0xa;
    r1 = 0x156d;
    FUN_200c334(r0, r1, r2);
    r0 = 0x6666;
    r1 = 0xccc;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x15b80000;
    r1 = -r1;
    r2 = 0x8580000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0xa;
    r1 = 0x159e;
    r2 = 0x858;
    FUN_200c334(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x15a8;
    r2 = 0x86e;
    FUN_200c334(r0, r1, r2);
    r2 = 0x878;
    r0 = 0xa;
    r1 = 0x15e8;
    FUN_200c334(r0, r1, r2);
    r1 = 0x1;
    r0 = 0xa;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x121;
    playSound(r0);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x15d80000;
    r2 = 0x8780000;
    r0 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200c374(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x0;
    r1 = r1 << 10;
    r2 = r2 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x15c8;
    r2 = 0x878;
    FUN_200c344(r0, r1, r2);
    r2 = 0x28;
    r1 = 0x0;
    r0 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8d;
    playSound(r0);
    r0 = 0xa;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    r1 = 0x15f8;
    r2 = 0x878;
    FUN_200c334(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x15f8;
    r2 = 0x838;
    FUN_200c334(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x15bd;
    r2 = 0x838;
    FUN_200c334(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x15b8;
    r2 = 0x853;
    FUN_200c334(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x1572;
    r2 = 0x858;
    FUN_200c334(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x1568;
    r2 = 0x838;
    FUN_200c334(r0, r1, r2);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xa;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x121;
    playSound(r0);
    r0 = 0x28;
    FUN_200c2d4(r0);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x15d80000;
    r1 = -r1;
    r2 = 0x8580000;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x0;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x15d8;
    r2 = 0x858;
    r0 = 0x0;
    FUN_200c344(r0, r1, r2);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x14;
    FUN_200c40c(r0);
    FUN_200c2e4();
  }

  @Method(0x200a4a8)
  public static void FUN_200a4a8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r6 = CPU.r8().value;
    CPU.push(r6);
    FUN_200c2dc();
    r6 = 0x200e79c;
    r3 = 0x37;
    MEMORY.ref(4, r6).setu(r3);
    r0 = 0x37;
    FUN_200a768();
    FUN_200c43c();
    FUN_200c44c();
    FUN_200c45c();

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r0 = MEMORY.ref(4, r6).get();
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(r0, r1, r2);
    }

    //LAB_200a4e0
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1768;
    r2 = 0xd78;
    FUN_200c344(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x3c;
    r0 = MEMORY.ref(4, r6).get();
    r1 = r1 << 1;
    FUN_200c3d4(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x2;
    FUN_200c37c(r0, r1);
    r0 = 0x263c;
    FUN_200c3a4(r0);
    r0 = MEMORY.ref(4, r6).get();
    r3 = 0x80;
    r3 = r3 << 5;
    r0 = r0 | r3;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x0;
    r1 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    FUN_200c464();
    r0 = 0x16666;
    r1 = 0xa;
    FUN_200c48c(r0, r1);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 12;
    r1 = r1 << 9;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r2 = 0xd680000;
    r1 = -r1;
    r0 = 0x17880000;
    FUN_200c3f4(r0, r1, r2, r3);
    FUN_200c3fc();
    r0 = 0x28;
    FUN_200c2d4(r0);
    FUN_200c45c();
    r1 = 0x81;
    r0 = MEMORY.ref(4, r6).get();
    r1 = r1 << 1;
    FUN_200c3dc(r0, r1);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r5 = 0xc0;
    r0 = MEMORY.ref(4, r6).get();
    r5 = r5 << 6;
    r0 = r0 | r5;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200c3bc(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1768;
    r2 = 0xd48;
    FUN_200c344(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1794;
    r2 = 0xd48;
    FUN_200c344(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = r5;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r2 = 0x6666;
    r0 = 0x0;
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x200cf20;
    r0 = 0x0;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);

    //LAB_200a5de
    do {
      r3 = getMapActor(0)._64.get();
      if(r3 != 0x0) {
        break;
      }

      //LAB_200a5d8
      r0 = 0x1;
      sleep(r0);
    } while(true);

    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r6 = 0x200e79c;
    r1 = 0x83;
    r0 = MEMORY.ref(4, r6).get();
    r2 = 0x0;
    r1 = r1 << 1;
    FUN_200c3d4(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x2;
    FUN_200c384(r0, r1);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x80;
    r0 = MEMORY.ref(4, r6).get();
    r2 = 0xa;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x0;
    FUN_200c3b4(r0, r1);
    r1 = 0x0;
    r2 = 0x14;
    r0 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    getMapActor(MEMORY.ref(4, r6).get())._5a.and(~0x1);
    r1 = 0x178c;
    r2 = 0xd48;
    r0 = MEMORY.ref(4, r6).get();
    FUN_200c344(r0, r1, r2);
    r0 = 0x1;
    FUN_200c2d4(r0);
    getMapActor(MEMORY.ref(4, r6).get())._5a.or(CPU.r8().value);
    CPU.r8().value = 1;
    r0 = 0x14;
    FUN_200c2d4(r0);
    getMapActor(MEMORY.ref(4, r6).get())._5a.and(~0x1);
    r1 = 0x1794;
    r2 = 0xd48;
    r0 = MEMORY.ref(4, r6).get();
    FUN_200c344(r0, r1, r2);
    r0 = 0x1;
    FUN_200c2d4(r0);
    getMapActor(MEMORY.ref(4, r6).get())._5a.or(CPU.r8().value);
    CPU.r8().value = getMapActor(MEMORY.ref(4, r6).get())._5a.get();
    r1 = 0x3;
    r0 = 0xf2;
    FUN_200c454(r0, r1);
    r1 = 0x0;
    r0 = 0xf2;
    r0 = FUN_200c2ec(r0, r1);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = 0x2642;
    FUN_200c3a4(r0);
    r0 = MEMORY.ref(4, r6).get();
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x0;
    r0 = MEMORY.ref(4, r6).get();
    r1 = r1 << 6;
    FUN_200c3c4(r0, r1, r2);
    FUN_200c464();
    r0 = 0x80;
    r1 = 0xa;
    r0 = r0 << 9;
    FUN_200c48c(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x8d;
    r0 = r0 << 2;
    setFlag(r0);
    r0 = 0x9bf;
    setFlag(r0);
    r1 = 0x2000240;
    r0 = 0xe2;
    r2 = 0x2;
    r0 = r0 << 1;
    r3 = r1 + r0;
    MEMORY.ref(2, r3).setu(r2);
    r3 = 0xe3;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = 0x4e;
    MEMORY.ref(2, r2).setu(r3);
    FUN_200c2e4();
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x200a768)
  public static void FUN_200a768() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;
    final int r7;

    r4 = 0x200e3f4;
    r3 = 0x1;
    r3 = -r3;
    r6 = 0x200a859;
    r0 = r4;
    r7 = 0x2;
    CPU.r12().value = r4;
    r1 = 0x4;
    r2 = 0x0;
    CPU.lr().value = r3;

    //LAB_200a77e
    do {
      r3 = MEMORY.ref(4, r2 + r4).get();
      if(r3 == 0x1) {
        r3 = MEMORY.ref(2, r0 + r1).get();
        if(r3 == 0x8a) {
          r3 = r1 + 0x4;
          MEMORY.ref(4, r0 + r2).setu(r7);
          MEMORY.ref(4, r0 + r3).setu(r6);
          r0 = CPU.r12().value;
        }
      }

      //LAB_200a792
      r3 = MEMORY.ref(4, r2 + r4).get();
      if(r3 == CPU.lr().value) {
        break;
      }
      r1 = r1 + 0xc;
      r2 = r2 + 0xc;
    } while(true);

    //LAB_200a79e
    r0 = 0x200db84;
    r6 = 0xc0;
    r2 = r0;
    r4 = 0x17940000;
    r5 = 0xd480000;
    r6 = r6 << 6;
    r2 = r2 + 0x8;
    r1 = 0x0;

    //LAB_200a7ae
    do {
      r3 = MEMORY.ref(2, r1 + r0).get();
      if(r3 == 0x39) {
        MEMORY.ref(4, r2).setu(r4);
        MEMORY.ref(4, r2 + 0x8).setu(r5);
        MEMORY.ref(2, r2 + 0xc).setu(r6);
        return;
      }

      //LAB_200a7c0
      r2 = r2 + 0x18;
      r1 = r1 + 0x18;
    } while(true);
  }

  @Method(0x200a7dc)
  public static void FUN_200a7dc() {
    final int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r6;
    final int r7;

    r0 = 0x200e3f4;
    r3 = 0x21;
    r4 = 0x1;
    r7 = r0;
    r6 = 0x1;
    r1 = r0 + 0x4;
    r2 = 0x0;
    CPU.r12().value = r3;
    r4 = -r4;

    //LAB_200a7f0
    do {
      r3 = MEMORY.ref(4, r2 + r0).get();
      if(r3 == 0x2) {
        r3 = MEMORY.ref(2, r1).get();
        if(r3 == 0x8a) {
          r3 = CPU.r12().value;
          MEMORY.ref(4, r2 + r7).setu(r6);
          MEMORY.ref(4, r1 + 0x4).setu(r3);
          break;
        }
      }

      //LAB_200a806
      r3 = MEMORY.ref(4, r2 + r0).get();
      if(r3 == r4) {
        break;
      }
      r1 = r1 + 0xc;
      r2 = r2 + 0xc;
    } while(true);
  }

  /**
   * Event list 0x200e3f4 handler 12
   */
  @Method(value = 0x200a81c, ignoreExtraParams = true)
  public static void FUN_200a81c() {
    int r0;
    int r1;
    int r2;
    final int r3;

    FUN_200c2dc();
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x37;
    FUN_200c38c(r0, r1, r2);
    r0 = 0x2642;
    FUN_200c3a4(r0);
    r3 = 0x200e79c;
    r1 = 0x0;
    r0 = MEMORY.ref(4, r3).get();
    FUN_200c3b4(r0, r1);
    r1 = 0xc0;
    r0 = 0x37;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    FUN_200c2e4();
  }

  /**
   * Event list 0x200e3f4 handler 8
   */
  @Method(value = 0x200a8a8, ignoreExtraParams = true)
  public static void FUN_200a8a8() {
    int r0;
    int r1;
    final int r2;
    int r3;

    FUN_200c2dc();
    FUN_200c45c();
    r0 = 0x264c;
    r1 = 0x1;
    FUN_200c264(r0, r1);
    r0 = 0x8d;
    r0 = r0 << 2;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x3001ebc;
      r1 = 0xb9;
      r3 = MEMORY.ref(4, r3).get();
      r1 = r1 << 1;
      r2 = r3 + r1;
      r3 = 0x1;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200a8d4
    FUN_200c464();
    FUN_200c2e4();
  }

  /**
   * Event list 0x200e3f4 handler 9
   */
  @Method(value = 0x200a8e8, ignoreExtraParams = true)
  public static void FUN_200a8e8() {
    int r0;
    int r1;
    int r2;
    int r3;
    Actor70 r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    final Actor70 r5 = getMapActor(0);
    FUN_200c2dc();
    FUN_200c464();
    r0 = 0x16666;
    r1 = 0x6;
    FUN_200c48c(r0, r1);
    r0 = 0xc0;
    r1 = 0xc0;
    r0 = r0 << 10;
    r1 = r1 << 7;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x17880000;
    r1 = -r1;
    r2 = 0xd680000;
    FUN_200c3f4(r0, r1, r2, r3);
    r2 = 0x6666;
    r0 = 0x0;
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r5._5b.set(0);
    FUN_200c21c(r5);
    r3 = r5.pos_08.getZ();
    r2 = 0xd680000;
    if(r3 > r2) {
      r3 = r5.pos_08.getX();
      r1 = 0x176e0000;
      if(r3 > r1) {
        r2 = r5.pos_08.getY();
        r3 = 0xd7d0000;
        moveActorTo(r5, r1, r2, r3);
        FUN_200c22c(r5);
      }
    } else {
      //LAB_200a964
      r3 = r5.pos_08.getX();
      r1 = 0x177a0000;
      if(r3 > r1) {
        throw new RuntimeException("NPE: r7 is 0 here");
/*
        r2 = MEMORY.ref(4, r7 + 0xc).get();
        r3 = 0xd480000;
        moveActorTo(r5, r1, r2, r3);
        FUN_200c22c(r5);
*/
      }
    }

    //LAB_200a97c
    r3 = 0xd680000;
    r2 = 0x0;
    r1 = 0x17690000;
    moveActorTo(r5, r1, r2, r3);
    FUN_200c22c(r5);
    r0 = 0x0;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x28;
    r0 = 0x0;
    r1 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    FUN_200c45c();
    r1 = 0x2;
    r0 = 0x0;
    FUN_200c384(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x0;
    r1 = 0x1c;
    setActorAnimationIfLoaded(r0, r1);
    r7 = loadActor(22, r5.pos_08.getX() + 0x20000, 0x260000, r5.pos_08.getZ());
    if(r7 != null) {
      r7._55.set(0);
      final Sprite38 r6 = r7.sprite_50.deref();
      r6._26.set(0);
      r6.layerCount_27.set(0);
      r6.packet_00.attribs_04.flags_01.and(~0x20);
      r6.packet_00.attribs_04.attrib2_04.and(0xfff);
      final int r5_0 = mallocSlotChip(17, 0x608);
      r0 = 0xf2;
      FUN_200c274(r0);
      allocateSpriteSlot(r6.slot_1c.get(), 0x80, r5_0 + 0x400);
      r0 = 0x11;
      freeSlot(r0);
      r0 = 0x14;
      FUN_200c2d4(r0);
      r0 = 0x50;
      r7._6c.set(getConsumer(Map2Overlay_877a7c8.class, "FUN_200813c", Actor70.class));
      FUN_200c2d4(r0);
    }

    //LAB_200aa30
    CPU.r8().value = 0x3000;
    getMapActor(MEMORY.ref(4, 0x200e79c).get()).angle_06.set(CPU.r8().value);
    r1 = 0x80;
    r2 = 0x0;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = r1 << 1;
    FUN_200c3d4(r0, r1, r2);
    r1 = 0x2;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    FUN_200c384(r0, r1);
    r3 = 0x2644;
    CPU.r10().value = r3;
    r0 = CPU.r10().value;
    FUN_200c3a4(r0);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    r2 = 0x50;
    FUN_200c3bc(r0, r1, r2);
    if(r7 != null) {
      clearActor(r7);
    }

    //LAB_200aa74
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x6;
    r2 = 0x28;
    FUN_200c374(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xd0;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r2 = 0x28;
    r0 = r0 | 0x9000;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    r0 = r0 | 0x9000;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = CPU.r8().value;
    r2 = 0x14;
    FUN_200c3c4(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r2 = 0x6666;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x2;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    setActorAnimationIfLoaded(r0, r1);
    r7 = getMapActor(55);
    r2 = r7.pos_08.getY();
    r1 = 0x177a0000;
    r3 = 0xd480000;
    moveActorTo(r7, r1, r2, r3);
    FUN_200c22c(r7);
    r3 = 0xd580000;
    r2 = 0x0;
    r1 = 0x17710000;
    moveActorTo(r7, r1, r2, r3);
    FUN_200c22c(r7);
    r0 = 0x37;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xa0;
    r2 = 0xa;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = r1 << 7;
    FUN_200c3c4(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r3 = 0x80;
    r3 = r3 << 5;
    r0 = r0 | r3;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r1 = r1 << 9;
    r2 = r2 << 8;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    getMapActor(55)._5a.and(~0x1);
    r1 = 0x2;
    r0 = 0x37;
    setActorAnimationIfLoaded(r0, r1);
    r3 = 0xd6;
    r2 = 0x0;
    r3 = r3 << 20;
    r1 = 0x176d0000;
    moveActorTo(r7, r1, r2, r3);
    FUN_200c22c(r7);
    r1 = 0x1;
    r0 = 0x37;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200c2d4(r0);
    r0 = 0x37;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x0;
    r3 = 0xd580000;
    r1 = 0x17710000;
    moveActorTo(r7, r1, r2, r3);
    FUN_200c22c(r7);
    r0 = 0x37;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = CPU.r10().value;
    r1 = 0x1;
    r0 = r0 + 0x6;
    FUN_200c264(r0, r1);
    r3 = 0x3001ebc;
    r2 = MEMORY.ref(4, r3).get();
    r3 = 0xec;
    r3 = r3 << 1;
    r2 = r2 + r3;
    r3 = MEMORY.ref(2, r2).getUnsigned();
    r3 = r3 + 0x1;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0xf2;
    FUN_200c2cc(r0);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0xa;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      r0 = MEMORY.ref(4, 0x200e79c).get();
      FUN_200c32c(r0, r1, r2);
    }

    //LAB_200ac20
    r0 = MEMORY.ref(4, 0x200e79c).get();
    FUN_200c354(r0);
    r2 = 0x0;
    r0 = MEMORY.ref(4, 0x200e79c).get();
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    FUN_200c464();
    r0 = 0x80;
    r1 = 0x6;
    r0 = r0 << 9;
    FUN_200c48c(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    FUN_200a7dc();
    r0 = MEMORY.ref(4, 0x200e79c).get();
    FUN_200c304(r0);
    r0 = 0x8d;
    r0 = r0 << 2;
    clearFlag(r0);
    r0 = 0x85d;
    setFlag(r0);
    FUN_200c2e4();
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x200acb4)
  public static void FUN_200acb4() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;

    r3 = 0x2000240;
    r1 = 0x205;
    r2 = r3 + r1;
    r0 = MEMORY.ref(1, r2).getUnsigned();
    r2 = 0x206;
    r3 = r3 + r2;
    r1 = MEMORY.ref(1, r3).getUnsigned();
    CPU.sp().value -= 0x1c;
    FUN_200c27c(r0, r1);
    FUN_200c2dc();
    r0 = 0x80;
    r1 = 0x96;
    r0 = r0 << 9;
    r1 = r1 << 1;
    FUN_200c48c(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r2 = -r2;
    r0 = -r0;
    r1 = -r1;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x5;
    r1 = 0x13;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x5;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0xc0;
    r0 = r0 << 9;
    r1 = 0x10;
    FUN_200c48c(r0, r1);
    r5 = 0x3001ebc;
    r1 = 0xe0;
    r3 = MEMORY.ref(4, r5).get();
    r1 = r1 << 1;
    r2 = 0x80;
    r3 = r3 + r1;
    r2 = r2 << 1;
    r1 = 0x1;
    r0 = 0x10003;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200c424(r0, r1);
    r3 = MEMORY.ref(4, r5).get();
    r2 = 0xe4;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x10;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200c43c();
    FUN_200c494();
    FUN_200c45c();
    r0 = 0x28;
    FUN_200c2d4(r0);
    r1 = 0x1;
    r0 = 0x5;
    FUN_200c384(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x2913;
    FUN_200c3a4(r0);
    r2 = 0x14;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200c384(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x107;
    r2 = 0x14;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x105;
    r2 = 0x50;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x8;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200c384(r0, r1);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x105;
    r2 = 0x64;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x105;
    r2 = 0x28;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x5;
    r1 = r1 << 1;
    r2 = 0x14;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0xa;
    r0 = 0x5;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200c3dc(r0, r1);
    r0 = 0x50;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x105;
    r2 = 0x50;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0x78;
    r0 = 0x8;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x105;
    r2 = 0x28;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x78;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x6666;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1ddc0000;
    r2 = 0xd840000;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x1d94;
    r2 = 0xd8c;
    FUN_200c344(r0, r1, r2);
    r2 = 0xda;
    r1 = 0x1d88;
    r2 = r2 << 4;
    r0 = 0x9;
    FUN_200c344(r0, r1, r2);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0x6009;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200c3d4(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x5;
    r1 = 0x101;
    FUN_200c3d4(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x0;
    r0 = 0x6009;
    FUN_200c3b4(r0, r1);
    FUN_200c234();
    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x200cf7c;
    r0 = 0x9;
    FUN_200c314(r0, r1);
    r0 = 0x50;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x28;
    r0 = 0x8;
    r1 = 0x4;
    FUN_200c374(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x4;
    r2 = 0x3c;
    FUN_200c374(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0xb0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x28;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x4ccc;
    r0 = 0x5;
    r1 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x200d01c;
    r0 = 0x8;
    FUN_200c314(r0, r1);
    r0 = 0x14;
    FUN_200c2d4(r0);
    r0 = 0xb333;
    r1 = 0x1666;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r0 = 0x1e380000;
    r1 = -r1;
    r2 = 0xdc80000;
    r3 = 0x1;
    FUN_200c3f4(r0, r1, r2, r3);
    r1 = 0x200d0a8;
    r0 = 0x5;
    FUN_200c314(r0, r1);

    //LAB_200af4a
    do {
      r0 = 0xa;
      r1 = 0x6;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x8;
      r0 = 0x6;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      sleep(r0);
      r3 = getMapActor(5)._64.get();
    } while(r3 == 0x0);

    r0 = 0x14;
    FUN_200c2d4(r0);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x9;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x8;
    r1 = r1 << 1;
    FUN_200c3dc(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x5;
    FUN_200c3dc(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    FUN_200c45c();
    r3 = 0x4;
    r2 = 0xc;
    r1 = 0x8;
    r0 = 0x9;
    r4 = 0x3;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    r2 = 0xd;
    r3 = 0x2;
    r1 = 0x7;
    r5 = 0x0;
    r0 = 0x5;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);
    FUN_200c3cc(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get());
    r0 = 0x14;
    FUN_200c2d4(r0);
    FUN_200c234();
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_200c3ec(r0, r1);
    r1 = 0x1;
    r3 = 0x1;
    r0 = 0x1e580000;
    r1 = -r1;
    r2 = 0xdc80000;
    FUN_200c3f4(r0, r1, r2, r3);
    r1 = 0xc0;
    r0 = 0x9;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x19999;
    r2 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1e7c;
    r2 = 0xdb8;
    FUN_200c33c(r0, r1, r2);
    r2 = 0xdd8;
    r0 = 0x5;
    r1 = 0x1e6c;
    FUN_200c344(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    FUN_200c45c();
    r0 = 0x50;
    FUN_200c2d4(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200c384(r0, r1);
    r2 = 0x14;
    r0 = 0x8;
    r1 = 0x0;
    FUN_200c3bc(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    FUN_200c384(r0, r1);
    r0 = 0x1005;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200c3bc(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x14;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_200c3c4(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    FUN_200c37c(r0, r1);
    r2 = 0x3c;
    r1 = 0x0;
    r0 = 0x8;
    FUN_200c3bc(r0, r1, r2);
    FUN_200c234();
    r0 = 0x11;
    playSound(r0);
    r1 = 0x0;
    r0 = 0x0;
    FUN_200c424(r0, r1);
    r0 = 0x78;
    FUN_200c434(r0);
    r0 = 0x78;
    sleep(r0);
    r0 = 0x0;
    r1 = 0xa;
    setMapAndEntranceId(r0, r1);
    CPU.sp().value += 0x1c;
  }

  @Method(0x200b130)
  public static void FUN_200b130() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200c2dc();
    r0 = 0x8d;
    playSound(r0);
    r0 = 0x0;
    r1 = 0x0;
    FUN_200c42c(r0, r1);
    r1 = 0x0;
    r0 = 0x0;
    FUN_200c424(r0, r1);
    r0 = 0x1;
    FUN_200c434(r0);
    r0 = 0x2;
    sleep(r0);
    r3 = 0x3001ebc;
    r2 = 0xe4;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x1;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200c43c();
    FUN_200c44c();
    r1 = 0xf;
    r0 = 0x0;
    FUN_200c394(r0, r1);
    r1 = 0x0;
    FUN_200c244(getMapActor(0), r1);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 11;
    r1 = r1 << 8;
    FUN_200c3ec(r0, r1);
    setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b1fc"), 0xc80);
    r0 = 0x0;
    r1 = 0x0;
    FUN_200c42c(r0, r1);
    r0 = 0x10004;
    r1 = 0x1;
    FUN_200c424(r0, r1);
    r0 = 0x80;
    r1 = 0x2;
    r0 = r0 << 9;
    FUN_200c424(r0, r1);
    r0 = 0x28;
    FUN_200c434(r0);
    r0 = 0xf0;
    FUN_200c2d4(r0);
    r1 = 0x0;
    r0 = 0x0;
    FUN_200c424(r0, r1);
    r0 = 0x50;
    FUN_200c434(r0);
    r0 = 0x5a;
    sleep(r0);
    r0 = 0x6d;
    FUN_200c40c(r0);
    r0 = 0x8d;
    r0 = r0 << 1;
    setFlag(r0);
    FUN_200c2e4();
  }

  @Method(0x200b1fc)
  public static void FUN_200b1fc() {
    final Actor70 r6 = loadActor(0xde, (rand() * 40 >>> 16 << 16) + 0x17b00000, 0, (rand() * 30 >>> 16 << 16) + 0xc4c0000);
    if(r6 != null) {
      final Sprite38 r5 = r6.sprite_50.deref();
      final int r0 = (rand() * 0x8000 >>> 16) + 0x13333;
      r5._26.set(0);
      r5.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
      r6._55.set(0);
      r6.scale_18.set(r0);
      r6._1c.set(r0);
      setActorAnimation(r6, 1);
      setActorSpriteScript(r6, 0x200d14c);
    }

    //LAB_200b270
    if(FUN_200c17c(_3001e40.get(), 3) == 0) {
      final int r0 = rand() * 4 >>> 16;
      if(r0 == 0x1) {
        //LAB_200b29e
        FUN_200c3f4(0x17c90000, -1, 0xc670000, 1);
      } else if((r0 & 0xffff_ffffL) < (0x1 & 0xffff_ffffL)) {
        //LAB_200b298
        FUN_200c3f4(0x17c70000, -1, 0xc690000, 1);
      } else if(r0 == 0x2) {
        //LAB_200b2a8
        FUN_200c3f4(0x17c90000, -1, 0xc690000, 1);
      } else if(r0 == 0x3) {
        //LAB_200b2b8
        FUN_200c3f4(0x17c70000, -1, 0xc670000, 1);
      }
    }

    //LAB_200b2c6
  }

  @Method(0x200b2f0)
  public static void FUN_200b2f0() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200c2dc();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r3 = 0x0;
    r2 = -r2;
    r1 = -r1;
    r0 = -r0;
    FUN_200c3f4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0xca;
    r2 = r2 << 18;
    r1 = 0x13080000;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    getMapActor(8).angle_06.set(0xa000);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x13333;
    r1 = 0x1;
    FUN_200c48c(r0, r1);
    r2 = 0x0;
    r0 = 0x0;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x8;
    FUN_200c3e4(r0, r1);
    r0 = 0x1;
    sleep(r0);
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200c43c();
    r0 = 0x8;
    r1 = 0x6666;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xb2;
    r0 = 0x8;
    r1 = 0x12d8;
    r2 = r2 << 2;
    FUN_200c334(r0, r1, r2);
    r2 = 0x9a;
    r0 = 0x8;
    r1 = 0x12a8;
    r2 = r2 << 2;
    FUN_200c334(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x4ccc;
    r2 = 0x2666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xec;
    r0 = 0x8;
    r1 = 0x12a8;
    r2 = r2 << 1;
    FUN_200c334(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x3333;
    r2 = 0x1999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xe4;
    r0 = 0x8;
    r1 = 0x1298;
    r2 = r2 << 1;
    FUN_200c334(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1999;
    r2 = 0xccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xdc;
    r2 = r2 << 1;
    r0 = 0x8;
    r1 = 0x1298;
    FUN_200c334(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x28;
    FUN_200c2d4(r0);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x6e;
    FUN_200c40c(r0);
  }

  @Method(0x200b41c)
  public static int FUN_200b41c() {
    int r0;
    int r5;
    int r6;

    r0 = 0x0;
    r0 = FUN_200b448(r0);
    r6 = r0;
    r0 = 0x2;
    r0 = FUN_200b448(r0);
    r6 = r6 + r0;
    r0 = 0x1;
    r0 = FUN_200b448(r0);
    r5 = r0;
    r0 = 0x3;
    r0 = FUN_200b448(r0);
    r5 = r5 + r0;
    r6 = r6 - r5;
    r0 = r6;
    return r0;
  }

  @Method(0x200b448)
  public static int FUN_200b448(int r0) {
    final int r2;
    final int r3;
    int r5;
    int r6;

    r6 = 0x0;
    if(r0 == 0x1) {
      //LAB_200b462
      r6 = 0x935;
    } else if((r0 & 0xffff_ffffL) < (0x1 & 0xffff_ffffL)) {
      //LAB_200b45e
      r6 = 0x92c;
    } else if(r0 == 0x2) {
      //LAB_200b466
      r6 = 0x917;
    } else if(r0 == 0x3) {
      //LAB_200b472
      r6 = 0x99;
      r6 = r6 << 4;
    }

    //LAB_200b476
    r5 = 0x0;

    //LAB_200b478
    do {
      r0 = r6 + r5;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        //LAB_200b46a
        r3 = 0x200e718;
        r2 = r5 << 2;
        r0 = MEMORY.ref(4, r3 + r2).get();
        return r0;
      }

      r5 = r5 + 0x1;
    } while((r5 & 0xffff_ffffL) <= (0x8 & 0xffff_ffffL));

    //LAB_200b48a
    return 0;
  }

  @Method(0x200b4a0)
  public static void FUN_200b4a0() {
    if((_3001e40.get() & 0xf) == 0) {
      final Actor70 r6 = getMapActor(8);
      final Actor70 r5 = loadActor(0xde, r6.pos_08.getX() - 0x200000, r6.pos_08.getY(), r6.pos_08.getZ() - 0x100000);

      if(r5 != null) {
        r5.scale_18.set(0x8000);
        r5._1c.set(0x8000);

        if(rand() * 2 >>> 16 != 0) {
          final int r2 = rand() * 48 >>> 16 << 16;
          r5.pos_08.x_00.sub(r2 / 2);
          r5.pos_08.z_08.sub(r2);
        } else {
          //LAB_200b502
          final int r0 = rand() * 32 >>> 16 << 16;
          r5.pos_08.x_00.add(r0);
          r5.pos_08.z_08.add(r0 / 2);
        }

        //LAB_200b518
        final Sprite38 r7 = r5.sprite_50.deref();
        r7._26.set(0);
        r7.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
        r5.flags_23.or(0x2);
        r5._55.set(r6._55.get());
        FUN_200c39c(r5, 9);
        setActorAnimation(r5, 2);
        setActorSpriteScript(r5, 0x200e73c);
      }
    }

    //LAB_200b566
  }

  @Method(0x200b57c)
  public static void FUN_200b57c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r6;

    final Actor70 r5 = getMapActor(8);
    r0 = 0x3c;
    FUN_200c2d4(r0);
    FUN_200c2dc();
    r0 = 0x9999;
    r1 = 0x1;
    FUN_200c48c(r0, r1);
    r3 = 0x13333;
    r1 = 0x1;
    r5.scale_18.set(r3);
    r5._1c.set(r3);
    r0 = 0x8;
    FUN_200c3e4(r0, r1);
    r0 = 0x1;
    sleep(r0);
    r1 = 0xf;
    r0 = 0x0;
    FUN_200c394(r0, r1);
    FUN_200c244(getMapActor(0), 0);
    FUN_200c244(getMapActor(8), 0);
    r2 = 0x3333;
    r0 = 0x8;
    r1 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r5._64.set(0);
    r1 = 0x200d218;
    r0 = 0x8;
    FUN_200c314(r0, r1);
    setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b4a0"), 0xc80);
    r2 = 0xe0;
    r3 = MEMORY.ref(4, 0x3001ebc).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    r1 = 0x1;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x10003;
    FUN_200c424(r0, r1);
    r6 = 0xe4;
    r2 = MEMORY.ref(4, 0x3001ebc).get();
    r3 = 0x20;
    r6 = r6 << 1;
    MEMORY.ref(4, r2 + r6).setu(r3);
    FUN_200c43c();
    r0 = 0x78;
    FUN_200c2d4(r0);
    r1 = 0x96;
    r1 = r1 << 1;
    r0 = 0x16666;
    FUN_200c48c(r0, r1);
    r0 = 0x87;
    r0 = r0 << 1;
    FUN_200c2d4(r0);
    r2 = MEMORY.ref(4, 0x3001ebc).get();
    r3 = 0x10;
    MEMORY.ref(4, r2 + r6).setu(r3);
    r3 = 0x7fff;
    r2 = 0xa0;
    r2 = r2 << 19;
    MEMORY.ref(2, r2).setu(r3);
    FUN_200c444();
    FUN_200c44c();
    r0 = 0x6f;
    FUN_200c40c(r0);
  }

  @Method(0x200b678)
  public static void FUN_200b678() {
    final Actor70 r0 = getMapActor(playerMapActorIndex_2000434.get());
    final int r6 = MEMORY.ref(4, 0x3001ebc).get();
    r0.angle_06.set(_3001e40.get() << 12);

    int r5 = readFlagsByte(0x2f8);
    if(r5 != 0) {
      if(r5 == 1) {
        MEMORY.ref(2, r6 + 0x182).setu(99);
        //LAB_200b6b2
      } else if(readFlag(0x106) == 0) {
        r5--;
      }
    }

    //LAB_200b6c0
    setFlagsByte(0x2f8, r5);
  }

  @Method(0x200b6dc)
  public static void FUN_200b6dc(int r0) {
    int r1;
    int r2;
    int r3;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    r2 = 0x2000240;
    r3 = 0xfa;
    CPU.r10().value = r2;
    r3 = r3 << 1;
    r3 = r3 + CPU.r10().value;
    r6 = MEMORY.ref(4, r3).get();
    r7 = r0;
    final Actor70 r5 = getMapActor(r6);
    r0 = 0xbc;
    r0 = r0 << 2;
    r0 = readFlag(r0);
    CPU.r8().value = r0;
    if(r0 == 0x0) {
      FUN_200c2dc();
      r0 = r6;
      r1 = 0x101;
      FUN_200c3dc(r0, r1);
      r0 = r6;
      r1 = 0x9;
      setActorAnimationIfLoaded(r0, r1);

      final Actor70 actor = getMapActor(r7);
      if(actor != null) {
        r1 = actor.pos_08.getX() >> 16;
        r2 = actor.pos_08.getZ() >> 16;
        FUN_200c32c(r6, r1, r2);
      }

      //LAB_200b734
      r0 = r6;
      FUN_200c354(r0);
      r0 = 0xf4;
      playSound(r0);
      setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b678"), 0xc80);
      r2 = CPU.r8().value;
      r5._55.set(r2);
      r3 = 0x80;
      r2 = r5.pos_08.getY();
      r3 = r3 << 14;
      r1 = r5.pos_08.getX();
      r2 = r2 + r3;
      r3 = r5.pos_08.getZ();
      moveActorTo(r5, r1, r2, r3);
      r0 = r6;
      FUN_200c354(r0);
      r2 = CPU.r8().value;
      r5.velocity_24.setY(r2);
      r2 = 0xf9;
      r3 = 0x4;
      r2 = r2 << 1;
      r2 = r2 + CPU.r10().value;
      r5._55.set(r3);
      r0 = 0xbc;
      r3 = 0x2;
      MEMORY.ref(1, r2).setu(r3);
      r0 = r0 << 2;
      setFlag(r0);
      r0 = 0xbe;
      r0 = r0 << 2;
      r1 = 0xb4;
      setFlagsByte(r0, r1);
      FUN_200c2e4();
      r3 = 0x3001ebc;
      r2 = 0xbe;
      r3 = MEMORY.ref(4, r3).get();
      r2 = r2 << 1;
      r3 = r3 + r2;
      r2 = CPU.r8().value;
      MEMORY.ref(2, r3).setu(r2);
    }

    //LAB_200b7a0
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  /**
   * Event list 0x200e3f4 handler 1
   */
  @Method(value = 0x200b7bc, ignoreExtraParams = true)
  public static void FUN_200b7bc() {
    final int r0;

    r0 = 0x36;
    FUN_200b6dc(r0);
  }

  /**
   * Event list 0x200e3f4 handler 63
   */
  @Method(value = 0x200b7c8, ignoreExtraParams = true)
  public static void FUN_200b7c8() {
    final int r2;
    int r3;

    r3 = 0x3001f30;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x1;
    r3 = r3 + 0x34;
    MEMORY.ref(1, r3).setu(r2);
  }

  /**
   * Event list 0x200e3f4 handler 64
   */
  @Method(value = 0x200b7d8, ignoreExtraParams = true)
  public static void FUN_200b7d8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r3 = 0x3001ebc;
    r1 = 0xc1;
    r3 = MEMORY.ref(4, r3).get();
    r1 = r1 << 1;
    r2 = r3 + r1;
    r1 = 0x0;
    r3 = MEMORY.ref(2, r2 + r1).get();
    if(r3 == 0x63) {
      r3 = 0x0;
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200b7f0
    r0 = 0xbc;
    r0 = r0 << 2;
    clearFlag(r0);
    r0 = 0x2f1;
    setFlag(r0);
    r0 = 0xbe;
    r0 = r0 << 2;
    r1 = 0x0;
    setFlagsByte(r0, r1);
    r0 = 0x62;
    r1 = 0x5;
    startEncounter(r0, r1);
    r5 = 0x2000240;
    r3 = 0x22b;
    r2 = r5 + r3;
    r3 = 0x3;
    MEMORY.ref(1, r2).setu(r3);
    r0 = 0x62;
    r1 = 0x7;
    startEncounter(r0, r1);
    r1 = 0xfa;
    r1 = r1 << 1;
    r5 = r5 + r1;
    getMapActor(MEMORY.ref(4, r5).get())._55.set(2);
  }

  /**
   * Event list 0x200e3f4 handler 65
   */
  @Method(value = 0x200b84c, ignoreExtraParams = true)
  public static void FUN_200b84c() {
    final Actor70 r5 = getMapActor(playerMapActorIndex_2000434.get());
    final Actor70 r8 = getMapActor(54);
    FUN_200c2dc();
    FUN_200c3f4(-1, -1, -1, 0);
    playSound(0xdb);
    FUN_200c244(r5, 0);
    r8._55.set(0);
    r5._55.set(0);
    r5.velocity_24.setY(0);
    r5._61.set(1);
    r8._61.set(1);

    //LAB_200b8ae
    for(int i = 0; i < 60; i++) {
      r5.velocity_24.y_04.add(0x3333);
      r8.velocity_24.y_04.add(0x3333);
      sleep(1);
    }

    FUN_200c444();
    FUN_200c44c();
    FUN_200c2e4();
    setFlag(0x122);
    setMapAndEntranceId(2, 27);
  }

  @Method(0x200b8fc)
  public static void FUN_200b8fc() {
    queueVblankNand16(GPU.BLDCNT.getAddress(), 0x3f41);

    if((_3001e40.get() & 0x2) != 0) {
      queueVblankNand16(GPU.BLDALPHA.getAddress(), MEMORY.ref(2, 0x200e7a0).getUnsigned() | 0xc);
    } else {
      //LAB_200b93c
      queueVblankNand16(GPU.BLDALPHA.getAddress(), MEMORY.ref(2, 0x200e7a0).getUnsigned() | 0x10);
    }
  }

  @Method(0x200b95c)
  public static void FUN_200b95c() {
    final Actor70 r0 = getMapActor(playerMapActorIndex_2000434.get());
    final int r5 = r0.pos_08.getX() >> 16;
    final int r6 = r0.pos_08.getZ() >> 16;

    if(FUN_200c17c(_3001e40.get(), 3) == 0) {
      final int r0_0 = rand() * 4 >>> 16;
      if(r0_0 == 0x1) {
        //LAB_200b9ac
        FUN_200c3f4((r5 << 16) + 0x10000, -1, (r6 << 16) - 0x10000, 1);
      } else if((r0_0 & 0xffff_ffffL) < (0x1 & 0xffff_ffffL)) {
        //LAB_200b99c
        FUN_200c3f4((r5 << 16) - 0x10000, -1, (r6 << 16) + 0x10000, 1);
      } else if(r0_0 == 0x2) {
        //LAB_200b9bc
        FUN_200c3f4((r5 << 16) + 0x10000, -1, (r6 << 16) + 0x10000, 1);
      } else if(r0_0 == 0x3) {
        //LAB_200b9d4
        FUN_200c3f4((r5 << 16) - 0x10000, -1, (r6 << 16) - 0x10000, 1);
      }
    }
  }

  @Method(0x200b9fc)
  public static void FUN_200b9fc(int r0) {
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
    CPU.r8().value = r0;
    r0 = 0x80;
    r0 = r0 << 7;
    r0 = mallocBoard(r0);
    r7 = r0;
    r0 = 0x1;
    sleep(r0);
    r0 = 0x109;
    clearFlag(r0);
    FUN_200c24c();
    r1 = r7;
    r0 = 0x200c7a6;
    r0 = decompress(r0, r1);
    r2 = 0x80;
    r2 = r2 << 5;
    r1 = r7 + r2;
    r0 = 0x200c4ec;
    r0 = decompress(r0, r1);
    r6 = 0x2002090;
    r5 = 0x4000208;
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r0 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r1 = CPU.r8().value;
      r2 = r2 + 0x1;
      r3 = r3 << 2;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r1 << 5;
      r1 = 0x200c4ac;
      r3 = r3 + r6;
      r3 = r3 + 0x4;
      r2 = r2 + r1;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x50001c0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80000010;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200ba6a
    MEMORY.ref(2, r5).setu(r0);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r3 = r3 + r6;
      r3 = r3 + 0x4;
      r2 = r2 + 0x1;
      MEMORY.ref(4, r3).setu(r7);
      r3 += 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = 0x6001000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000400;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200ba90
    MEMORY.ref(2, r5).setu(r1);
    setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b8fc"), 0xc80);
    FUN_200c2dc();
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xea;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200baca
    MEMORY.ref(2, r5).setu(r1);
    getMapActor(MEMORY.ref(4, 0x2000434).get()).spriteType_54.set(0);
    r3 = 0x3001ebc;
    r2 = 0xe4;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x10;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200c43c();
    FUN_200c44c();
    r0 = 0xf6;
    playSound(r0);
    r3 = 0x200e7a0;
    CPU.r8().value = r3;
    r3 = 0xe00;
    r0 = CPU.r8().value;
    MEMORY.ref(2, r0).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xd2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bb78
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r3 = 0xd00;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xba;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bbc0
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r3 = 0xc00;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xa2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bc08
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r1 = 0xb0;
    r1 = r1 << 4;
    CPU.r11().value = r1;
    r2 = CPU.r11().value;
    r3 = CPU.r8().value;
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0x8a;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bc46
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r1 = 0xa0;
    r1 = r1 << 4;
    CPU.r9().value = r1;
    r2 = CPU.r9().value;
    r3 = CPU.r8().value;
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xe4;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 5;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bc84
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r1 = 0x90;
    r1 = r1 << 4;
    CPU.r10().value = r1;
    r2 = CPU.r10().value;
    r3 = CPU.r8().value;
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xb4;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 5;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bcc2
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x2;
    FUN_200c2d4(r0);
    r3 = 0x800;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0x84;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 5;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bd08
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x8c;
    FUN_200c2d4(r0);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xb4;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 5;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bd3a
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xe4;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 5;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bd6c
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0x8a;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bd9e
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r1 = CPU.r10().value;
    r2 = CPU.r8().value;
    MEMORY.ref(2, r2).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xa2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200bdd6
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r1 = CPU.r9().value;
    r2 = CPU.r8().value;
    MEMORY.ref(2, r2).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xba;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200be0e
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r1 = CPU.r11().value;
    r2 = CPU.r8().value;
    MEMORY.ref(2, r2).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xd2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200be46
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = 0xc00;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r0 = 0xea;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      r0 = r0 << 6;
      r3 = r3 + 0x4;
      MEMORY.ref(2, r6).setu(r2);
      r2 = r7 + r0;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x6002000;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x84000140;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200be8c
    MEMORY.ref(2, r5).setu(r1);
    FUN_200c254();
    setTickCallback(getRunnable(Map2Overlay_877a7c8.class, "FUN_200b95c"), 0xc80);
    r0 = 0x8d;
    playSound(r0);
    r3 = 0xd00;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = 0xe00;
    r2 = CPU.r8().value;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = 0xf00;
    r0 = CPU.r8().value;
    MEMORY.ref(2, r0).setu(r3);
    r0 = 0x4;
    FUN_200c2d4(r0);
    r3 = 0x1000;
    r1 = CPU.r8().value;
    MEMORY.ref(2, r1).setu(r3);
    r0 = 0x2d;
    FUN_200c2d4(r0);
    FUN_200c444();
    FUN_200c44c();
    r0 = r7;
    setMallocAddress(r0);
    r0 = 0x101;
    setFlag(r0);
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x200bfb4)
  public static void FUN_200bfb4(final Actor70 r0) {
    r0._64.incr();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      final Actor70 r6 = r0.parent_68.deref();

      //LAB_200bfd4
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.setZ(r6.pos_08.getZ() + (0x10000 - sin) * 5 + 0x80000);
      r0.pos_08.y_04.add(0x10000);
    }
  }

  @Method(0x200c004)
  public static void FUN_200c004(final Actor70 r0) {
    r0._64.incr();
    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      final Actor70 r6 = r0.parent_68.deref();

      //LAB_200c024
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(-sin);
      r0.pos_08.setX(r6.pos_08.getX());
      r0.pos_08.setZ(r6.pos_08.getZ() - (0x10000 - sin) * 5 + 0x100000);
      r0.pos_08.y_04.add(0x10000);
    }
  }

  @Method(0x200c058)
  public static void FUN_200c058(final Actor70 r0) {
    final FieldPsynergy720 r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    final Actor70[] r10 = new Actor70[2];

    //LAB_200c078
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 actor = loadActor(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      r10[r7] = actor;

      if(actor != null) {
        actor._14.set(r0._14.get());
        actor._55.set(0);
        actor._64.set(0);
        actor.parent_68.set(r0);

        final Sprite38 r5 = actor.sprite_50.derefNullable();
        if(r5 != null) {
          //LAB_200c0b4
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

      //LAB_200c124
    }

    r10[0]._6c.set(getConsumer(Map2Overlay_877a7c8.class, "FUN_200c004", Actor70.class));
    r10[0].sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    r10[1].sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    r10[1]._6c.set(getConsumer(Map2Overlay_877a7c8.class, "FUN_200bfb4", Actor70.class));
    r10[1].flags_23.set(2);
  }

  /** {@link CopiedSegment8000770#FUN_3000380} */
  @Method(0x200c174)
  public static int FUN_200c174(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x200c17c)
  public static int FUN_200c17c(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200c184)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200c18c)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200c194)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200c19c)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200c1a4)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#rotVec3_} */
  @Method(0x200c1ac)
  public static void rotVec3(final int distance, final int angle, final Vec3 vec) {
    MEMORY.call(0x8000128, distance, angle, vec);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200c1b4)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200c1bc)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#mallocBoard_} */
  @Method(0x200c1c4)
  public static int mallocBoard(final int size) {
    return (int)MEMORY.call(0x8000170, size);
  }

  /** {@link GoldenSun#setMallocAddress_} */
  @Method(0x200c1cc)
  public static void setMallocAddress(final int addr) {
    MEMORY.call(0x8000178, addr);
  }

  /** {@link GoldenSun#decompress_} */
  @Method(0x200c1d4)
  public static int decompress(final int src, final int dest) {
    return (int)MEMORY.call(0x80001a8, src, dest);
  }

  /** {@link GoldenSun#clearVramSlot_} */
  @Method(0x200c1dc)
  public static int clearVramSlot(final int slot) {
    return (int)MEMORY.call(0x80001b8, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200c1e4)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#queueVblankNand16_} */
  @Method(0x200c1ec)
  public static void queueVblankNand16(final int dst, final int val) {
    MEMORY.call(0x8000318, dst, val);
  }

  /** {@link GoldenSun#setSpriteAnimation_} */
  @Method(0x200c1f4)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x8009020, sprite, animation);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x200c1fc)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200c204)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    MEMORY.call(0x8009098, actor, script);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200c20c)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x200c214)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009140} */
  @Method(0x200c21c)
  public static void FUN_200c21c(final Actor70 r0) {
    MEMORY.call(0x8009140, r0);
  }

  /** {@link GoldenSun#moveActorTo_} */
  @Method(0x200c224)
  public static void moveActorTo(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009158} */
  @Method(0x200c22c)
  public static void FUN_200c22c(final Actor70 r0) {
    MEMORY.call(0x8009158, r0);
  }

  /** {@link GoldenSun#FUN_8009170} */
  @Method(0x200c234)
  public static void FUN_200c234() {
    MEMORY.call(0x8009170);
  }

  /** {@link GoldenSun#FUN_80091d0} */
  @Method(0x200c23c)
  public static void FUN_200c23c(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80091d0, r0, r1, r2, r3);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200c244)
  public static void FUN_200c244(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_8009230} */
  @Method(0x200c24c)
  public static void FUN_200c24c() {
    MEMORY.call(0x8009230);
  }

  /** {@link GoldenSun#FUN_8009238} */
  @Method(0x200c254)
  public static void FUN_200c254() {
    MEMORY.call(0x8009238);
  }

  /** {@link GoldenSun#FUN_8009240} */
  @Method(0x200c25c)
  public static void FUN_200c25c(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009240, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200c264)
  public static void FUN_200c264(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015120} */
  @Method(0x200c26c)
  public static void FUN_200c26c(final int r0, final int r1) {
    MEMORY.call(0x8015120, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200c274)
  public static void FUN_200c274(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_801#FUN_8015360} */
  @Method(0x200c27c)
  public static void FUN_200c27c(final int r0, final int r1) {
    MEMORY.call(0x8015360, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_80153e8} */
  @Method(0x200c284)
  public static int FUN_200c284(final int initialSelection, final int r1) {
    return (int)MEMORY.call(0x80153e8, initialSelection, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200c28c)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200c294)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200c29c)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_807#readFlagsByte_} */
  @Method(0x200c2a4)
  public static int readFlagsByte(final int flag) {
    return (int)MEMORY.call(0x80770e0, flag);
  }

  /** {@link GoldenSun_807#setFlagsByte_} */
  @Method(0x200c2ac)
  public static void setFlagsByte(final int flag, final int val) {
    MEMORY.call(0x80770e8, flag, val);
  }

  /** {@link GoldenSun_807#FUN_80771a8} */
  @Method(0x200c2b4)
  public static int FUN_200c2b4(final int unitId, final int r1, final int r2) {
    return (int)MEMORY.call(0x80771a8, unitId, r1, r2);
  }

  /** {@link GoldenSun_807#FUN_80771c8} */
  @Method(0x200c2bc)
  public static void FUN_200c2bc(final int charId, final int element, final int djinn) {
    MEMORY.call(0x80771c8, charId, element, djinn);
  }

  /** {@link GoldenSun_807#restorePlayer_} */
  @Method(0x200c2c4)
  public static void restorePlayer(final int restoreStatus) {
    MEMORY.call(0x8077260, restoreStatus);
  }

  /** {@link GoldenSun_807#FUN_80772e8} */
  @Method(0x200c2cc)
  public static void FUN_200c2cc(final int itemId) {
    MEMORY.call(0x80772e8, itemId);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200c2d4)
  public static void FUN_200c2d4(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200c2dc)
  public static void FUN_200c2dc() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200c2e4)
  public static void FUN_200c2e4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a060} */
  @Method(0x200c2ec)
  public static int FUN_200c2ec(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a060, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200c2f4)
  public static int FUN_200c2f4(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200c2fc)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a088} */
  @Method(0x200c304)
  public static void FUN_200c304(final int mapActorIndex) {
    MEMORY.call(0x808a088, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200c30c)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200c314)
  public static void FUN_200c314(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x808a098, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x200c31c)
  public static void FUN_200c31c(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200c324)
  public static void FUN_200c324(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x808a0b0, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200c32c)
  public static void FUN_200c32c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200c334)
  public static void FUN_200c334(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200c33c)
  public static void FUN_200c33c(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200c344)
  public static void FUN_200c344(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e0} */
  @Method(0x200c34c)
  public static void FUN_200c34c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0e0, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200c354)
  public static void FUN_200c354(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200c35c)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200c364)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200c36c)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200c374)
  public static void FUN_200c374(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200c37c)
  public static void FUN_200c37c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200c384)
  public static void FUN_200c384(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200c38c)
  public static void FUN_200c38c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200c394)
  public static void FUN_200c394(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a158, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a160} */
  @Method(0x200c39c)
  public static void FUN_200c39c(final Actor70 r0, final int r1) {
    MEMORY.call(0x808a160, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200c3a4)
  public static void FUN_200c3a4(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200c3ac)
  public static Panel24 FUN_200c3ac(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200c3b4)
  public static void FUN_200c3b4(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200c3bc)
  public static void FUN_200c3bc(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200c3c4)
  public static void FUN_200c3c4(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1d0} */
  @Method(0x200c3cc)
  public static void FUN_200c3cc(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    MEMORY.call(0x808a1d0, r0, r1, r2, r3, a4, a5, a6, a7, a8, a9);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200c3d4)
  public static void FUN_200c3d4(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200c3dc)
  public static void FUN_200c3dc(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x200c3e4)
  public static void FUN_200c3e4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200c3ec)
  public static void FUN_200c3ec(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200c3f4)
  public static void FUN_200c3f4(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200c3fc)
  public static void FUN_200c3fc() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#setMapAndEntranceId_} */
  @Method(0x200c404)
  public static void setMapAndEntranceId(final int mapId, final int entranceId) {
    MEMORY.call(0x808a238, mapId, entranceId);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200c40c)
  public static void FUN_200c40c(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#startEncounter_} */
  @Method(0x200c414)
  public static void startEncounter(final int encounterSet, final int encounterId) {
    MEMORY.call(0x808a250, encounterSet, encounterId);
  }

  /** {@link GoldenSun_808#FUN_808a258} */
  @Method(0x200c41c)
  public static void FUN_200c41c(final int r0, final int r1) {
    MEMORY.call(0x808a258, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200c424)
  public static void FUN_200c424(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a338} */
  @Method(0x200c42c)
  public static void FUN_200c42c(final int r0, final int r1) {
    MEMORY.call(0x808a338, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200c434)
  public static void FUN_200c434(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200c43c)
  public static void FUN_200c43c() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200c444)
  public static void FUN_200c444() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200c44c)
  public static void FUN_200c44c() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a398} */
  @Method(0x200c454)
  public static void FUN_200c454(final int itemId, final int flags) {
    MEMORY.call(0x808a398, itemId, flags);
  }

  /** {@link GoldenSun_808#FUN_808a3d8} */
  @Method(0x200c45c)
  public static void FUN_200c45c() {
    MEMORY.call(0x808a3d8);
  }

  /** {@link GoldenSun_808#FUN_808a3e0} */
  @Method(0x200c464)
  public static void FUN_200c464() {
    MEMORY.call(0x808a3e0);
  }

  /** {@link GoldenSun_808#getMapActor2_} */
  @Method(0x200c46c)
  public static Actor70 getMapActor2_(final int index) {
    return (Actor70)MEMORY.call(0x808a400, index);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x200c474)
  public static void FUN_200c474(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x200c47c)
  public static void FUN_200c47c() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#FUN_808a4f8} */
  @Method(0x200c484)
  public static void FUN_200c484(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a4f8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a5c0} */
  @Method(0x200c48c)
  public static void FUN_200c48c(final int r0, final int r1) {
    MEMORY.call(0x808a5c0, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a5c8} */
  @Method(0x200c494)
  public static void FUN_200c494() {
    MEMORY.call(0x808a5c8);
  }

  /** {@link GoldenSun_80a#handleDjinnMenu_} */
  @Method(0x200c49c)
  public static int handleDjinnMenu() {
    return (int)MEMORY.call(0x80a1040);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200c4a4)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
