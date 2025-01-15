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
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;

import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Map5Overlay_8784360 {
  private Map5Overlay_8784360() { }

  @Method(0x2008030)
  public static int FUN_2008030(final Actor70 r0) {
    final Actor70 r1 = r0.parent_68.derefNullable();
    if(r1 != null) {
      r0._5a.and(~0x1);

      int angle = (short)((atan2(r1.pos_08.getZ() - r0.pos_08.getZ(), r1.pos_08.getX() - r0.pos_08.getX()) & 0xffff) - (r0.angle_06.get() & 0xffff));
      if(angle != 0) {
        if(angle > 0x1000) {
          angle = 0x1000;
        }

        //LAB_200806e
        if(angle < -0x1000) {
          angle = -0x1000;
        }

        //LAB_2008076
        r0.angle_06.add(angle);
      }
    }

    //LAB_200807a
    return 1;
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008088)
  public static int getRooms() {
    final int r0;

    r0 = 0x200afa0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008090)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008094)
  public static int getTransitions() {
    int r0;

    r0 = 0x834;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x200b144;
    } else {
      //LAB_20080a4
      r0 = 0x200b108;
    }

    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x20080b8)
  public static int getActors() {
    int r0;
    int r2;
    int r3;

    r0 = 0x834;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x200b380;
    } else {
      //LAB_20080c8
      r3 = 0x2000240;
      r2 = 0xe1;
      r2 = r2 << 1;
      r3 = r3 + r2;
      r2 = 0x0;
      r3 = MEMORY.ref(2, r3 + r2).get();
      if(r3 == 0xc) {
        r0 = 0x200b560;
      } else {
        //LAB_20080dc
        r0 = 0x87a;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r0 = 0x200b7d0;
        } else {
          //LAB_20080ea
          r0 = 0x200b170;
        }
      }
    }

    return r0;
  }

  /**
   * Event list 0x200bb3c handler 34
   */
  @Method(value = 0x200810c, ignoreExtraParams = true)
  public static void FUN_200810c() {
    int r0;
    int r1;

    FUN_200a69c();
    r1 = 0x1;
    r0 = 0x111f;
    FUN_200a664(r0, r1);
    r0 = 0x7e;
    playSound(r0);
    r1 = 0x0;
    r0 = 0x3e7;
    addPpToAll(r0);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x1;
    r0 = 0x974;
    FUN_200a664(r0, r1);
    FUN_200a66c();
    r0 = 0xa1;
    r0 = r0 << 1;
    clearFlag(r0);
    FUN_200a6a4();
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008158)
  public static int getEvents() {
    int r0;
    int r2;
    int r3;

    r0 = 0x87a;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x200bcec;
    } else {
      //LAB_2008168
      r0 = 0x815;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x200bb3c;
      } else {
        //LAB_2008176
        r3 = 0x2000240;
        r2 = 0xe1;
        r2 = r2 << 1;
        r3 = r3 + r2;
        r2 = 0x0;
        r3 = MEMORY.ref(2, r3 + r2).get();
        if(r3 == 0xc) {
          r0 = 0x200bb30;
        } else {
          //LAB_200818a
          r0 = 0x834;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r0 = 0x200ba64;
          } else {
            //LAB_2008198
            r0 = 0x200b938;
          }
        }
      }
    }

    //LAB_200819a
    return r0;
  }

  /**
   * Event list 0x200b938 handler 2
   */
  @Method(value = 0x20081c4, ignoreExtraParams = true)
  public static void FUN_20081c4() {
    int r0;
    int r1;
    final int r2;

    FUN_200a69c();
    r0 = 0xf3c;
    FUN_200a764(r0);
    r2 = 0x2;
    r0 = 0x17;
    r1 = 0x0;
    FUN_200a74c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x17;
    r0 = FUN_200a784(r0, r1);
    FUN_200a6a4();
  }

  /**
   * Event list 0x200b938 handler 3
   */
  @Method(value = 0x20081f0, ignoreExtraParams = true)
  public static void FUN_20081f0() {
    int r0;
    int r1;
    final int r2;

    FUN_200a69c();
    r0 = 0xf3f;
    FUN_200a764(r0);
    r2 = 0x2;
    r0 = 0x18;
    r1 = 0x0;
    FUN_200a74c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x18;
    r0 = FUN_200a784(r0, r1);
    FUN_200a6a4();
  }

  /**
   * Event list 0x200b938 handler 6
   */
  @Method(value = 0x200821c, ignoreExtraParams = true)
  public static void FUN_200821c() {
    int r0;
    int r1;
    final int r2;

    FUN_200a69c();
    r0 = 0xf44;
    FUN_200a764(r0);
    r2 = 0x2;
    r0 = 0xf;
    r1 = 0x0;
    FUN_200a74c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0xf;
    r0 = FUN_200a784(r0, r1);
    FUN_200a6a4();
  }

  /**
   * Event list 0x200bb3c handler 8
   */
  @Method(value = 0x2008248, ignoreExtraParams = true)
  public static void FUN_2008248() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    int r7;

    FUN_200a69c();
    r0 = 0x815;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r5 = 0x1197;
      r0 = r5;
      FUN_200a764(r0);
      r0 = 0x2;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
      }

      //LAB_200827a
      r0 = 0x3;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
      }

      //LAB_2008294
      r1 = 0x0;
      r0 = 0x11;
      FUN_200a76c(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200a6bc(r0, r1);
      if(r0 == 0x0) {
        r0 = r5 + 0x3;
        FUN_200a764(r0);
      } else {
        //LAB_20082b0
        r0 = r5 + 0x4;
        FUN_200a764(r0);
      }

      //LAB_20082b6
      r0 = 0x11;
      r1 = 0x0;
      FUN_200a774(r0, r1);
    } else {
      //LAB_20082c0
      r3 = 0x3001e70;
      r3 = MEMORY.ref(4, r3).get();
      r0 = 0xf48;
      r6 = MEMORY.ref(4, r3).get();
      FUN_200a764(r0);
      r2 = 0x0;
      r0 = 0x11;
      r1 = 0x0;
      FUN_200a74c(r0, r1, r2);
      r1 = 0x0;
      r0 = 0x11;
      FUN_200a784(r0, r1);
      r0 = 0x14;
      FUN_200a694(r0);
      r1 = 0x2;
      r0 = 0x11;
      FUN_200a734(r0, r1);
      r0 = 0xf;
      FUN_200a694(r0);
      FUN_200a564();
      r7 = 0x0;
      r5 = 0x0;

      //LAB_20082fa
      do {
        FUN_200a2f8(getMapActor(17));
        r5 = r5 + 0x1;
        r0 = 0x1;
        sleep(r0);
      } while((r5 & 0xffff_ffffL) <= (0x27 & 0xffff_ffffL));

      r1 = 0xc8;
      r1 = r1 << 4;
      setTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a590"), r1);
      r0 = 0x6b;
      playSound(r0);
      r5 = 0x0;

      //LAB_2008322
      do {
        r0 = r5;
        r1 = 0xa;
        r0 = FUN_200a5e4(r0, r1);
        if(r0 == 0x0) {
          r3 = 0x1;
          r3 = r3 & r7;
          if(r3 != 0x0) {
            r3 = MEMORY.ref(4, r6).get();
            r2 = 0xffff0000;
          } else {
            //LAB_200833c
            r3 = MEMORY.ref(4, r6).get();
            r2 = 0x80;
            r2 = r2 << 9;
          }

          //LAB_2008342
          r3 = r3 + r2;
          MEMORY.ref(4, r6).setu(r3);
          r7 = r7 + 0x1;
        }

        //LAB_2008348
        r0 = 0x1;
        r5 = r5 + 0x1;
        FUN_200a694(r0);
      } while(r5 != 0xb4);

      r0 = 0x121;
      playSound(r0);
      clearTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a590"));
      r0 = 0x1;
      sleep(r0);
      FUN_200a574();
      r1 = 0x0;
      r0 = 0x11;
      FUN_200a754(r0, r1);
      r0 = 0x28;
      FUN_200a694(r0);
      r0 = 0xf4b;
      FUN_200a764(r0);
      r0 = 0x11;
      r1 = 0x0;
      FUN_200a774(r0, r1);
    }

    //LAB_2008386
    FUN_200a6a4();
  }

  /**
   * Event list 0x200bb3c handler 4
   */
  @Method(value = 0x20083b4, ignoreExtraParams = true)
  public static void FUN_20083b4() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200a69c();
    r0 = 0x87a;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x1be8;
      FUN_200a764(r0);
      r1 = 0x0;
      r0 = 0xf;
      FUN_200a76c(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200a6bc(r0, r1);
      if(r0 == 0x1) {
        r0 = 0xf;
        r1 = 0x0;
        FUN_200a774(r0, r1);
      } else {
        //LAB_20083e8
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
        r0 = 0xf;
        r1 = 0x0;
        r0 = FUN_200a784(r0, r1);
      }
    } else {
      //LAB_20083fc
      r0 = 0x815;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x1191;
        FUN_200a764(r0);
        r0 = 0xb;
        r1 = 0x0;
        r0 = FUN_200a784(r0, r1);
      } else {
        //LAB_2008416
        r0 = 0xea8;
        FUN_200a764(r0);
        r0 = 0xb;
        r1 = 0x0;
        r0 = FUN_200a784(r0, r1);
      }
    }

    //LAB_2008424
    FUN_200a6a4();
  }

  /**
   * Event list 0x200bb3c handler 10
   */
  @Method(value = 0x2008444, ignoreExtraParams = true)
  public static void FUN_2008444() {
    int r0;
    int r1;
    int r2;
    final int r3;

    FUN_200a69c();
    r0 = 0x1a;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1a;
    r1 = 0x0;
    r2 = 0x14;
    FUN_200a744(r0, r1, r2);
    r2 = 0x28;
    r1 = 0x15;
    r0 = 0x1a;
    FUN_200a744(r0, r1, r2);
    r0 = 0x11c7;
    FUN_200a764(r0);
    r0 = 0x1a;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r0 = 0x19999;
    r1 = 0x3333;
    FUN_200a7ac(r0, r1);
    r1 = 0x1;
    r2 = 0x88;
    r3 = 0x1;
    r2 = r2 << 17;
    r1 = -r1;
    r0 = 0x1510000;
    FUN_200a7b4(r0, r1, r2, r3);
    r0 = 0x14;
    FUN_200a694(r0);
    r1 = 0x2;
    r0 = 0x1a;
    FUN_200a73c(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r2 = 0xa;
    r0 = 0x1a;
    r1 = 0x0;
    FUN_200a744(r0, r1, r2);
    r0 = 0x1a;
    r1 = 0x28;
    FUN_200a2c8(r0, r1);
    r0 = 0x1a;
    r1 = 0x2;
    FUN_200a6d4(r0, r1);
    FUN_200a6a4();
  }

  /**
   * Event list 0x200ba64 handler 4
   */
  @Method(value = 0x20084d4, ignoreExtraParams = true)
  public static void FUN_20084d4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    FUN_200a69c();
    r2 = 0xbe;
    r0 = 0x0;
    r1 = 0x52;
    r2 = r2 << 2;
    FUN_200a704(r0, r1, r2);
    r2 = 0x1e;
    r1 = 0x0;
    r0 = 0xf;
    FUN_200a74c(r0, r1, r2);
    r0 = 0xeae;
    FUN_200a764(r0);
    r0 = 0xf;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r1 = 0xa0;
    r2 = 0x14;
    r1 = r1 << 8;
    r0 = 0xf;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0xf;
    FUN_200a7a4(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    FUN_200a564();
    r5 = 0x0;

    //LAB_2008524
    do {
      FUN_200a2f8(getMapActor(15));
      r5 = r5 + 0x1;
      r0 = 0x1;
      sleep(r0);
      CPU.cmpT(r5, 0x27);
    } while((r5 & 0xffff_ffffL) <= (0x27 & 0xffff_ffffL));

    r1 = 0xc8;
    r1 = r1 << 4;
    setTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a580"), r1);
    r1 = 0xc8;
    r1 = r1 << 4;
    setTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a5a0"), r1);
    r1 = 0xa0;
    r2 = 0xa;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_200a78c(r0, r1, r2);
    final Actor70 r6 = getMapActor(20);
    r2 = r6._55.get();
    r6._55.set(0);
    CPU.r8().value = r2;
    r5 = 0x0;

    //LAB_2008570
    do {
      r6.pos_08.y_04.add(0x1800);
      r5 = r5 + 0x1;
      sleep(1);
    } while((r5 & 0xffff_ffffL) <= (0x27 & 0xffff_ffffL));

    r3 = CPU.r8().value;
    r6._55.set(r3);
    clearTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a580"));
    clearTickCallback(getRunnable(Map5Overlay_8784360.class, "FUN_200a5a0"));
    r0 = 0x1;
    sleep(r0);
    r0 = 0xa1;
    playSound(r0);
    r0 = 0xf;
    r1 = 0x0;
    FUN_200a754(r0, r1);
    r1 = 0x0;
    r0 = 0x14;
    FUN_200a754(r0, r1);
    r0 = 0x28;
    FUN_200a694(r0);
    FUN_200a574();
    r2 = 0x1e;
    r0 = 0x0;
    r1 = 0xf;
    FUN_200a74c(r0, r1, r2);
    r0 = 0xf;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    FUN_200a6a4();
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  /**
   * Event list 0x200ba64 handler 5
   */
  @Method(value = 0x20085e8, ignoreExtraParams = true)
  public static void FUN_20085e8() {
    int r0;
    int r1;
    final int r2;

    FUN_200a69c();
    r0 = 0x10;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200a74c(r0, r1, r2);
    r0 = 0x84;
    r0 = r0 << 4;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0xeb1;
      FUN_200a764(r0);
      r0 = 0x10;
      r1 = 0x0;
      FUN_200a774(r0, r1);
    } else {
      //LAB_2008614
      r0 = 0xeb0;
      FUN_200a764(r0);
      r0 = 0x10;
      r1 = 0x0;
      FUN_200a774(r0, r1);
    }

    //LAB_2008622
    FUN_200a6a4();
  }

  /**
   * Event list 0x200bcec handler 0
   */
  @Method(value = 0x2008634, ignoreExtraParams = true)
  public static void FUN_2008634() {
    int r0;
    final int r1;

    FUN_200a69c();
    r0 = 0x302;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x1be4;
      FUN_200a764(r0);
    } else {
      //LAB_200864c
      r0 = 0x1be3;
      FUN_200a764(r0);
      r0 = 0x302;
      setFlag(r0);
    }

    //LAB_2008658
    r0 = 0xb;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    FUN_200a6a4();
  }

  /**
   * Event list 0x200bcec handler 21
   */
  @Method(value = 0x2008674, ignoreExtraParams = true)
  public static void FUN_2008674() {
    int r0;
    int r1;
    int r2;
    int r3;

    final Actor70 r5 = getMapActor(21);
    FUN_200a69c();
    r3 = 0x80;
    r3 = r3 << 24;
    r5.dest_38.set(r3, r3, r3);
    r1 = 0x1;
    r0 = 0x15;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x15;
    FUN_200a6e4(r0);
    r1 = 0x80;
    r2 = 0x28;
    r1 = r1 << 1;
    r0 = 0x15;
    FUN_200a79c(r0, r1, r2);
    r3 = 0xb0;
    r3 = r3 << 8;
    r5.angle_06.set(r3);
    r0 = 0x14;
    FUN_200a694(r0);
    r1 = 0x2;
    r0 = 0x15;
    FUN_200a734(r0, r1);
    r0 = 0x1c94;
    FUN_200a764(r0);
    r0 = 0x15;
    r1 = 0x0;
    r2 = 0x28;
    FUN_200a77c(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x15;
    r1 = 0x0;
    FUN_200a744(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x2;
    FUN_200a734(r0, r1);
    r1 = 0x0;
    r0 = 0x15;
    FUN_200a774(r0, r1);
    r0 = 0x306;
    setFlag(r0);
    r0 = 0x15;
    FUN_200a6e4(r0);
    r0 = 0x1;
    sleep(r0);
    r1 = 0x200ae34;
    r0 = 0x15;
    FUN_200a6d4(r0, r1);
    FUN_200a6a4();
  }

  @Method(0x2008714)
  public static void FUN_2008714(int r0) {
    final int r1;
    int r2;
    int r3;
    final int r5;

    r5 = r0;
    r0 = 0x834;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      FUN_200a7fc();
    }

    //LAB_2008726
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 - 0xc0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 + 0xc8;
    r2 = r1 + r3;
    r3 = 0x10;
    MEMORY.ref(4, r2).setu(r3);
    r0 = r5;
    FUN_200a7cc(r0);
  }

  /**
   * Event list 0x200bb3c handler 22
   */
  @Method(value = 0x2008750, ignoreExtraParams = true)
  public static void FUN_2008750() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x2c;
    r2 = 0x7;
    FUN_200a63c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xf8;
    r2 = 0x117;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x1;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bcec handler 24
   */
  @Method(value = 0x2008780, ignoreExtraParams = true)
  public static void FUN_2008780() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    r0 = 0xbc;
    CPU.sp().value -= 0x8;
    playSound(r0);
    r5 = 0x2;
    r1 = 0x3f;
    r2 = 0x33;
    r3 = 0x8;
    r0 = 0x0;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xa;
    sleep(r0);
    r3 = 0x8;
    r1 = 0x3f;
    r2 = 0x33;
    r0 = 0x2;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xa;
    sleep(r0);
    r1 = 0xb0;
    r2 = 0x99;
    r2 = r2 << 1;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200a704(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorPriority(r0, r1);
    r1 = 0xb0;
    r2 = 0x94;
    r1 = r1 << 1;
    r2 = r2 << 1;
    r0 = 0x0;
    FUN_200a704(r0, r1, r2);
    r0 = 0x2;
    FUN_2008714(r0);
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200bb3c handler 23
   */
  @Method(value = 0x20087ec, ignoreExtraParams = true)
  public static void FUN_20087ec() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x2b;
    r2 = 0xf;
    FUN_200a63c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xe6;
    r2 = 0x197;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x3;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bb3c handler 24
   */
  @Method(value = 0x200881c, ignoreExtraParams = true)
  public static void FUN_200881c() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x34;
    r2 = 0x12;
    FUN_200a63c(r0, r1, r2);
    r1 = 0xbb;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x1a3;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x4;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bb3c handler 25
   */
  @Method(value = 0x200884c, ignoreExtraParams = true)
  public static void FUN_200884c() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x29;
    r2 = 0x20;
    FUN_200a63c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xc8;
    r2 = 0x222;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x5;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bb3c handler 26
   */
  @Method(value = 0x200887c, ignoreExtraParams = true)
  public static void FUN_200887c() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x23;
    r2 = 0x24;
    FUN_200a63c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x66;
    r2 = 0x263;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x6;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bb3c handler 27
   */
  @Method(value = 0x20088ac, ignoreExtraParams = true)
  public static void FUN_20088ac() {
    int r0;
    int r1;
    int r2;

    r0 = 0x9e;
    playSound(r0);
    r0 = 0x200beb4;
    r1 = 0x33;
    r2 = 0x27;
    FUN_200a63c(r0, r1, r2);
    r1 = 0xb3;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x29e;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x7;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200ba64 handler 13
   */
  @Method(value = 0x20088dc, ignoreExtraParams = true)
  public static void FUN_20088dc() {
    int r0;

    r0 = 0x7b;
    playSound(r0);
    r0 = 0x8;
    FUN_2008714(r0);
  }

  /**
   * Event list 0x200bb3c handler 28
   */
  @Method(value = 0x20088f0, ignoreExtraParams = true)
  public static void FUN_20088f0() {
    int r0;

    r0 = 0x815;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x7b;
      playSound(r0);
      r0 = 0xa;
      FUN_2008714(r0);
    }
  }

  /**
   * Event list 0x200bb3c handler 31
   */
  @Method(value = 0x2008910, ignoreExtraParams = true)
  public static void FUN_2008910() {
    final int r0;

    r0 = 0x90b;
    setFlag(r0);
  }

  /**
   * Event list 0x200bb3c handler 32
   */
  @Method(value = 0x2008920, ignoreExtraParams = true)
  public static void FUN_2008920() {
    final int r0;

    r0 = 0x90c;
    setFlag(r0);
  }

  /**
   * Event list 0x200bb3c handler 33
   */
  @Method(value = 0x2008930, ignoreExtraParams = true)
  public static void FUN_2008930() {
    final int r0;

    r0 = 0x90d;
    setFlag(r0);
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x2008940)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r0 = 0x90b;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x8;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200a714(r0, r1, r2);
    }

    //LAB_2008958
    r0 = 0x90c;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x9;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200a714(r0, r1, r2);
    }

    //LAB_200896c
    r0 = 0x90d;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0xa;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200a714(r0, r1, r2);
    }

    //LAB_2008980
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0x61) {
      FUN_20095b4();
    } else if(r3 == 0x62) {
      //LAB_20089a2
      r0 = 0x20;
      setFlag(r0);
      r0 = 0x32;
      FUN_200a7cc(r0);
    } else if(r3 == 0x63) {
      //LAB_20089b0
      FUN_200a5b0();
    } else {
      //LAB_20089b6
      getMapActor(8)._1c.set(0x18000);
      getMapActor(9)._1c.set(0x18000);
      getMapActor(10)._1c.set(0x18000);
      r0 = 0x87a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x2;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x61;
        r1 = 0x2;
        r2 = 0x50;
        r3 = 0x5;
        FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x3;
        r2 = 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x2a;
        r1 = 0x35;
        r2 = 0x2a;
        r3 = 0x36;
        FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        FUN_200a634();
        r0 = 0x1;
        sleep(r0);
      } else {
        //LAB_2008a0e
        r0 = 0x834;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          FUN_200a7ec();
          FUN_200a7f4();
          r3 = 0x12;
          r2 = 0x29;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          r0 = 0x15;
          r1 = 0x26;
          r2 = 0x1;
          r3 = 0x1;
          FUN_200a64c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x84;
          r0 = r0 << 4;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r0 = 0x11;
            r1 = 0x0;
            r2 = 0x0;
            FUN_200a714(r0, r1, r2);
            r0 = 0x12;
            r1 = 0x0;
            r2 = 0x0;
            FUN_200a714(r0, r1, r2);
            r1 = 0x80;
            r2 = 0x200ac00;
            r0 = 0x13;
            r1 = r1 << 9;
            FUN_200a75c(r0, r1, r2);
          }
        } else {
          //LAB_2008a62
          r0 = 0x815;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r1 = 0xb4;
            r2 = 0x8e;
            r0 = 0x10;
            r1 = r1 << 16;
            r2 = r2 << 18;
            FUN_200a714(r0, r1, r2);
            r3 = 0x2;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r0 = 0x5c;
            r1 = 0x2;
            r2 = 0x50;
            r3 = 0x5;
            FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r3 = 0x3;
            r2 = 0x1;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
            r0 = 0x2a;
            r1 = 0x35;
            r2 = 0x2a;
            r3 = 0x36;
            FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            FUN_200a634();
            r0 = 0x1;
            sleep(r0);
          }
        }

        //LAB_2008aaa
        r3 = 0x2000240;
        r2 = 0xe1;
        r2 = r2 << 1;
        r3 = r3 + r2;
        r2 = 0x0;
        r3 = MEMORY.ref(2, r3 + r2).get();
        if(r3 == 0xc) {
          FUN_20097c8();
        } else {
          //LAB_2008ac0
          if(readFlag(0x834) != 0x0) {
            final Actor70 actor20 = getMapActor(20);
            actor20.scale_18.set(0x4ccc);
            actor20._1c.set(0x4ccc);
            FUN_200a654(actor20, 0);
            final Actor70 actor21 = getMapActor(21);
            actor21.scale_18.set(0x9999);
            actor21._1c.set(0x9999);
            setActorAnimationIfLoaded(13, 5);
            //LAB_2008af8
          } else if(readFlag(0x815) != 0x0) {
            FUN_200a714(21, 0x14b0000, 0xf90000);
            FUN_200a654(getMapActor(21), 0);
          }

          //LAB_2008b1a
          r0 = 0x84;
          r0 = r0 << 4;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r0 = 0x1a;
            r1 = 0x0;
            r2 = 0x0;
            FUN_200a714(r0, r1, r2);
            r0 = 0x16;
            r1 = 0x0;
            r2 = 0x0;
            FUN_200a714(r0, r1, r2);
          }

          //LAB_2008b3a
          r3 = 0x2000240;
          r2 = 0xe1;
          r2 = r2 << 1;
          r3 = r3 + r2;
          r2 = 0x0;
          r3 = MEMORY.ref(2, r3 + r2).get();
          if(r3 == 0x13) {
            //LAB_2008b4a
            FUN_20095b4();
          } else {
            //LAB_2008b50
            r0 = 0x834;
            r0 = readFlag(r0);
            if(r0 != 0x0 && readFlag(0x842) != 0x0) {
              FUN_2009084();
            } else {
              //LAB_2008b6a
              r0 = 0x834;
              r0 = readFlag(r0);
              if(r0 != 0x0) {
                FUN_200a814();
                FUN_200a824();
                FUN_200a80c();
              }
            }
          }
        }
      }
    }

    //LAB_2008b80
    r0 = 0x0;
    CPU.sp().value += 0x8;
    return r0;
  }

  /**
   * Event list 0x200ba64 handler 14
   */
  @Method(value = 0x2008bbc, ignoreExtraParams = true)
  public static void FUN_2008bbc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r0 = 0x834;
    r6 = 0x0;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      //LAB_2008bcc
      r0 = 0x84;
      r0 = r0 << 4;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        //LAB_2008bda
        FUN_200a69c();
        r0 = 0x19999;
        r1 = 0x3333;
        FUN_200a7ac(r0, r1);
        r0 = 0xc5;
        r1 = 0x1;
        r2 = 0xc0;
        r3 = 0x1;
        r2 = r2 << 18;
        r1 = -r1;
        r0 = r0 << 16;
        FUN_200a7b4(r0, r1, r2, r3);
        FUN_200a7bc();
        r0 = 0xeb6;
        FUN_200a764(r0);
        r0 = 0x13;
        r1 = 0x2;
        FUN_200a73c(r0, r1);
        r0 = 0x4013;
        r1 = 0x0;
        r2 = 0xa;
        FUN_200a77c(r0, r1, r2);
        r1 = 0x80;
        r2 = 0x80;
        r0 = 0x0;
        r1 = r1 << 9;
        r2 = r2 << 8;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r1 = 0x80;
        r2 = 0x80;
        r0 = 0x19;
        r1 = r1 << 9;
        r2 = r2 << 8;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r0 = 0x0;
        r1 = 0xb3;
        r2 = 0x315;
        FUN_200a704(r0, r1, r2);
        final Actor70 actor0 = getMapActor(0);
        if(actor0 != null) {
          FUN_200a714(25, actor0.pos_08.getX(), actor0.pos_08.getZ());
        }

        //LAB_2008c4e
        r2 = 0xc9;
        r0 = 0x19;
        r1 = 0xb3;
        r2 = r2 << 2;
        FUN_200a704(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x19;
        r2 = 0x28;
        FUN_200a74c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r2 = 0x0;
        r0 = 0x19;
        r1 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r0 = 0x11;
        r1 = 0x3;
        setActorAnimationIfLoaded(r0, r1);
        r0 = 0x12;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r2 = 0x0;
        r1 = 0x12;
        r0 = 0x11;
        FUN_200a74c(r0, r1, r2);
        r0 = 0x14;
        FUN_200a694(r0);
        r0 = 0x11;
        r1 = 0x1;
        FUN_200a734(r0, r1);
        r2 = 0xa;
        r0 = 0x4011;
        r1 = 0x0;
        FUN_200a77c(r0, r1, r2);
        r0 = 0x12;
        r1 = 0x3;
        setActorAnimationIfLoaded(r0, r1);
        r0 = 0x12;
        r1 = 0x0;
        r2 = 0xa;
        FUN_200a77c(r0, r1, r2);
        r0 = 0x11;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r1 = 0xf0;
        r2 = 0xa;
        r0 = 0x12;
        r1 = r1 << 8;
        FUN_200a78c(r0, r1, r2);
        r0 = 0x13;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x4013;
        r1 = 0x0;
        r2 = 0xa;
        FUN_200a77c(r0, r1, r2);
        r0 = 0x11;
        r1 = 0x19999;
        r2 = 0xcccc;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r2 = 0xcccc;
        r0 = 0x12;
        r1 = 0x19999;
        setActorVelocityScalerAndAcceleration(r0, r1, r2);
        r5 = 0x200aef0;
        r0 = 0x11;
        r1 = r5;
        FUN_200a6d4(r0, r1);
        r0 = 0x14;
        FUN_200a694(r0);
        r0 = 0x12;
        r1 = r5;
        FUN_200a6d4(r0, r1);
        r1 = 0xc0;
        r0 = 0x0;
        r1 = r1 << 8;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r1 = 0xc0;
        r2 = 0x3c;
        r0 = 0x19;
        r1 = r1 << 8;
        FUN_200a78c(r0, r1, r2);
        r1 = 0x200af50;
        r0 = 0x0;
        FUN_200a6d4(r0, r1);
        r1 = 0x200af78;
        r0 = 0x19;
        FUN_200a6ec(r0, r1);
        r0 = 0x14;
        FUN_200a694(r0);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r2 = 0xa;
        r0 = 0x19;
        r1 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r0 = 0x19;
        r1 = 0x0;
        FUN_200a774(r0, r1);
        r1 = 0x80;
        r0 = 0x13;
        r1 = r1 << 8;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r1 = 0xc0;
        r2 = 0x14;
        r1 = r1 << 7;
        r0 = 0x1a;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x1a;
        r1 = 0x2;
        FUN_200a73c(r0, r1);
        r0 = 0x1a;
        r1 = 0xa;
        FUN_200a2c8(r0, r1);
        r0 = 0x0;
        r1 = 0x3;
        setActorAnimationIfLoaded(r0, r1);
        r1 = 0x3;
        r0 = 0x19;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x14;
        FUN_200a694(r0);
        r0 = 0x13;
        r1 = 0x2;
        FUN_200a73c(r0, r1);
        FUN_200a76c(0x4013);
        r0 = 0x0;
        r1 = 0x0;
        r0 = FUN_200a6bc(r0, r1);
        if(r0 == 0x1) {
          r0 = 0x13;
          r1 = 0x4;
          r6 = 0x1;
          setActorAnimationIfLoaded(r0, r1);
        } else {
          //LAB_2008dec
          r0 = 0x13;
          r1 = 0x3;
          setActorAnimationIfLoaded(r0, r1);
          r3 = 0x3001ebc;
          r2 = MEMORY.ref(4, r3).get();
          r3 = 0xec;
          r3 = r3 << 1;
          r2 = r2 + r3;
          r3 = MEMORY.ref(2, r2).getUnsigned();
          r3 = r3 + 0x1;
          MEMORY.ref(2, r2).setu(r3);
        }

        //LAB_2008e04
        r0 = 0x4013;
        r1 = 0x0;
        FUN_200a774(r0, r1);
        if(r6 != 0x0) {
          r3 = 0x3001ebc;
          r2 = MEMORY.ref(4, r3).get();
          r3 = 0xec;
          r3 = r3 << 1;
          r2 = r2 + r3;
          r3 = MEMORY.ref(2, r2).getUnsigned();
          r3 = r3 + 0x1;
          MEMORY.ref(2, r2).setu(r3);
        }

        //LAB_2008e20
        r5 = 0x80;
        r5 = r5 << 7;
        r1 = r5;
        r2 = 0x1e;
        r0 = 0x16;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x16;
        r1 = 0x0;
        FUN_200a774(r0, r1);
        r1 = 0x80;
        r0 = 0x13;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_200a79c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x1a;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_200a79c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_200a79c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x19;
        r1 = r1 << 1;
        r2 = 0x28;
        FUN_200a79c(r0, r1, r2);
        r1 = 0xa0;
        r0 = 0x13;
        r1 = r1 << 8;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r1 = 0xa0;
        r0 = 0x1a;
        r1 = r1 << 8;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r6 = 0xe0;
        r1 = 0xe0;
        r6 = r6 << 8;
        r0 = 0x0;
        r1 = r1 << 8;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r1 = r6;
        r2 = 0xa;
        r0 = 0x19;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x13333;
        r1 = 0x2666;
        FUN_200a7ac(r0, r1);
        r0 = 0xd7;
        r1 = 0x1;
        r2 = 0x2f60000;
        r3 = 0x1;
        r0 = r0 << 16;
        r1 = -r1;
        FUN_200a7b4(r0, r1, r2, r3);
        FUN_200a7bc();
        r0 = 0xcccc;
        r1 = 0x1999;
        FUN_200a7ac(r0, r1);
        r0 = 0xcd;
        r1 = 0x1;
        r3 = 0x1;
        r2 = 0x30a0000;
        r0 = r0 << 16;
        r1 = -r1;
        FUN_200a7b4(r0, r1, r2, r3);
        r1 = 0x200a874;
        r0 = 0x16;
        FUN_200a6d4(r0, r1);
        r0 = 0x16;
        FUN_200a6dc(r0);
        r1 = 0x80;
        r2 = 0x3c;
        r1 = r1 << 6;
        r0 = 0x16;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x13;
        r1 = 0x2;
        FUN_200a73c(r0, r1);
        r0 = 0x13;
        r1 = 0xa;
        FUN_200a2c8(r0, r1);
        r0 = 0x16;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x16;
        r1 = 0x14;
        FUN_200a2c8(r0, r1);
        r1 = 0x3;
        r0 = 0x13;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0xa;
        FUN_200a694(r0);
        r1 = r5;
        r2 = 0x1e;
        r0 = 0x13;
        r5 = r5 + 0x13;
        FUN_200a2e0(r0, r1, r2);
        r0 = r5;
        r1 = 0xa;
        FUN_200a2c8(r0, r1);
        r1 = r6;
        r2 = 0x1e;
        r0 = 0x1a;
        r6 = 0x80;
        FUN_200a2e0(r0, r1, r2);
        r6 = r6 << 8;
        r0 = 0x1a;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r2 = 0x1e;
        r0 = 0x13;
        r1 = r6;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x13;
        r1 = 0x2;
        FUN_200a73c(r0, r1);
        r0 = r5;
        r1 = 0xa;
        FUN_200a2c8(r0, r1);
        r0 = 0x0;
        r1 = 0x19;
        r2 = 0x28;
        FUN_200a74c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a78c(r0, r1, r2);
        r0 = 0x19;
        r1 = 0x0;
        r2 = 0x14;
        FUN_200a2e0(r0, r1, r2);
        r2 = 0x1e;
        r0 = 0x1a;
        r1 = r6;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x1a;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x1a;
        r1 = 0x1e;
        FUN_200a2c8(r0, r1);
        r1 = 0xc0;
        r2 = 0x1e;
        r1 = r1 << 8;
        r0 = 0x1a;
        FUN_200a2e0(r0, r1, r2);
        r0 = 0x1a;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x16;
        r1 = 0x3;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x19;
        r1 = 0x2;
        setActorAnimationIfLoaded(r0, r1);

        if(actor0 != null) {
          FUN_200a6f4(25, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
        }

        //LAB_2008fcc
        r0 = 0x19;
        FUN_200a70c(r0);
        r0 = 0x19;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a714(r0, r1, r2);
        r0 = 0x1a;
        r1 = 0x2;
        setActorAnimationIfLoaded(r0, r1);

        if(actor0 != null) {
          FUN_200a6f4(26, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
        }

        //LAB_2008ffc
        r0 = 0x1a;
        FUN_200a70c(r0);
        r0 = 0x1a;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a714(r0, r1, r2);
        r0 = 0x16;
        r1 = 0x2;
        setActorAnimationIfLoaded(r0, r1);

        if(actor0 != null) {
          FUN_200a6f4(22, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
        }

        //LAB_200902c
        r0 = 0x16;
        FUN_200a70c(r0);
        r0 = 0x16;
        r1 = 0x0;
        r2 = 0x0;
        FUN_200a714(r0, r1, r2);
        r1 = 0x80;
        r2 = 0x200ac00;
        r0 = 0x13;
        r1 = r1 << 9;
        FUN_200a75c(r0, r1, r2);
        r0 = 0x84;
        r0 = r0 << 4;
        setFlag(r0);
        FUN_200a6a4();
      }
    }

    //LAB_2009054
  }

  @Method(0x2009084)
  public static void FUN_2009084() {
    final Actor70 r5 = FUN_200a7c4();
    FUN_200a69c();
    FUN_200a7b4(-1, -1, -1, 0);
    sleep(1);
    FUN_200a7b4(0x400000, 0x900000, 0x15e0000, 0);
    FUN_200a634();
    sleep(1);
    FUN_200a6ac(1, 0);
    FUN_200a814();
    playSound(0x11);
    FUN_200a80c();
    FUN_200a714(23, 0x690000, 0x10b0000);
    sleep(1);
    setActorVelocityScalerAndAcceleration(0, 0x13333, 0x9999);
    FUN_200a704(0, 93, 343);
    FUN_200a764(0xed6);
    FUN_200a774(23, 0);
    playSound(0x3d);
    r5._55.set(0);
    FUN_200a7ac(0x30000, 0x6000);
    FUN_200a7b4(0x6d0000, 0xb00000, 0x1190000, 1);
    FUN_200a7bc();
    FUN_200a694(40);
    FUN_200a714(24, 0x870000, 0xb10000);
    setActorVelocityScalerAndAcceleration(24, 0xcccc, 0x6666);
    FUN_200a6fc(24, 126, 258);
    FUN_200a694(40);
    FUN_200a78c(23, 0xd000, 0);
    FUN_200a70c(24);
    setActorAnimationIfLoaded(24, 1);
    FUN_200a2e0(24, 0x7000, 10);
    setActorAnimationAndWaitUntilFinished(23, 3);
    setActorAnimationAndWaitUntilFinished(24, 4);
    FUN_200a774(0x2018, 0);
    FUN_200a73c(23, 2);
    FUN_200a2c8(0x8017, 30);
    FUN_200a2e0(24, 0xb000, 20);
    FUN_200a2c8(0x2018, 10);
    FUN_200a2e0(23, 0xb000, 40);
    FUN_200a774(0x8017, 0);
    setActorAnimationAndWaitUntilFinished(24, 4);
    FUN_200a774(0x2018, 0);
    FUN_200a2e0(23, 0xf000, 10);
    FUN_200a73c(23, 2);
    FUN_200a774(0x8017, 0);
    FUN_200a2e0(24, 0x6000, 20);
    setActorAnimationAndWaitUntilFinished(24, 3);
    FUN_200a694(20);
    FUN_200a2c8(0x2018, 20);
    FUN_2009274();
    FUN_200a6a4();
  }

  /** Saturos and Menardi attack */
  @Method(0x2009274)
  public static void FUN_2009274() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r6 = CPU.r8().value;
    CPU.push(r6);
    r1 = 0xf;
    r0 = 0x19;
    FUN_200a754(r0, r1);
    FUN_200a654(getMapActor(25), 0);
    r2 = 0x14b0000;
    r1 = 0x0;
    r0 = 0x19;
    FUN_200a714(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x1019;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r1 = 0x80;
    r0 = 0x17;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x18;
    r1 = r1 << 1;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r0 = 0x19;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200a714(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x17;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r2 = 0xa0;
    r2 = r2 << 7;
    CPU.r8().value = r2;
    r1 = CPU.r8().value;
    r2 = 0x28;
    r0 = 0x18;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc0;
    r1 = 0xc0;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_200a7ac(r0, r1);
    r0 = 0xb2;
    r1 = 0xb0;
    r3 = 0x1;
    r1 = r1 << 16;
    r2 = 0x1390000;
    r0 = r0 << 15;
    FUN_200a7b4(r0, r1, r2, r3);
    FUN_200a7bc();
    r0 = 0x28;
    FUN_200a694(r0);
    r1 = 0xe0;
    r0 = 0x17;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = 0xe0;
    r2 = 0x28;
    r1 = r1 << 7;
    r0 = 0x18;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xcccc;
    r1 = 0x1999;
    FUN_200a7ac(r0, r1);
    r0 = 0xc8;
    r1 = 0x90;
    r3 = 0x1;
    r0 = r0 << 15;
    r1 = r1 << 16;
    r2 = 0x14d0000;
    FUN_200a7b4(r0, r1, r2, r3);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x17;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x18;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x69;
    r2 = 0x149;
    r0 = 0x17;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0xa;
    FUN_200a694(r0);
    r2 = 0x149;
    r1 = 0x7c;
    r0 = 0x18;
    FUN_200a6fc(r0, r1, r2);
    r0 = 0x17;
    FUN_200a70c(r0);
    r0 = 0x17;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = CPU.r8().value;
    r2 = 0x0;
    r0 = 0x17;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x18;
    FUN_200a70c(r0);
    r0 = 0x18;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x0;
    r1 = CPU.r8().value;
    r0 = 0x18;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x19;
    FUN_200a754(r0, r1);
    FUN_200a654(getMapActor(25), 1);
    r0 = 0x19;
    r1 = 0x0;
    r2 = 0x14b0000;
    FUN_200a714(r0, r1, r2);
    r0 = 0x19;
    r1 = 0x13333;
    r2 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x153;
    r1 = 0x25;
    r0 = 0x19;
    FUN_200a704(r0, r1, r2);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0x17;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r5 = 0xd0;
    FUN_200a76c(23);
    r5 = r5 << 8;
    r0 = 0x19;
    r1 = 0x101;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r2 = 0xa;
    r1 = r5;
    r0 = 0x0;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x0;
    r0 = FUN_200a6bc(r0, r1);
    r6 = 0x80;
    r0 = 0x28;
    FUN_200a694(r0);
    r6 = r6 << 8;
    r0 = 0x17;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r2 = 0x14;
    r1 = r6;
    r0 = 0x18;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x19;
    r1 = 0x2;
    FUN_200a73c(r0, r1);
    r0 = 0x1019;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r2 = 0x200ac00;
    r0 = 0x0;
    r1 = 0x10019;
    FUN_200a75c(r0, r1, r2);
    r0 = 0x19;
    r1 = 0x5d;
    r2 = 0x169;
    FUN_200a704(r0, r1, r2);
    r2 = 0x28;
    r1 = r5;
    r0 = 0x19;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x14;
    r0 = 0x19;
    FUN_200a2c8(r0, r1);
    r0 = 0x0;
    FUN_200a6e4(r0);
    r0 = 0x17;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r2 = 0xf;
    r1 = r6;
    r0 = 0x18;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x17;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x18;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = CPU.r8().value;
    r0 = 0x17;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r2 = 0x1e;
    r1 = CPU.r8().value;
    r0 = 0x18;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x18;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x2018;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r1 = r5;
    r0 = 0x0;
    r2 = 0x1e;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x28;
    r1 = r1 << 7;
    r0 = 0x0;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x17;
    r1 = 0x2;
    FUN_200a73c(r0, r1);
    r0 = 0x17;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x17;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_200a7a4(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x19;
    FUN_200a7a4(r0, r1);
    r0 = 0x50;
    FUN_200a694(r0);
    r1 = 0x200a8e8;
    r0 = 0x18;
    FUN_200a6d4(r0, r1);
    r0 = 0x6;
    FUN_200a694(r0);
    r1 = 0x200a940;
    r0 = 0x17;
    FUN_200a6d4(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r1 = 0x200a998;
    r0 = 0x0;
    FUN_200a6d4(r0, r1);
    r0 = 0x6;
    FUN_200a694(r0);
    r1 = 0x200a9f0;
    r0 = 0x19;
    FUN_200a6ec(r0, r1);
    r3 = 0x2000240;
    r2 = 0x22b;
    r3 = r3 + r2;
    r2 = 0x2;
    MEMORY.ref(1, r3).setu(r2);
    r5 = 0x5;
    r1 = 0x13;
    r0 = r5;
    FUN_200a7dc(r0, r1);
    r0 = r5;
    r1 = 0x13;
    FUN_200a7e4(r0, r1);
    r0 = 0xc;
    r1 = 0x4;
    startEncounter(r0, r1);
    r0 = 0x8d;
    r0 = r0 << 1;
    setFlag(r0);
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x20095b4)
  public static void FUN_20095b4() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.push(CPU.r8().value);
    r0 = 0x11;
    playSound(r0);
    FUN_200a69c();
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r1 = -r1;
    r2 = -r2;
    r3 = 0x0;
    r0 = -r0;
    FUN_200a7b4(r0, r1, r2, r3);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x80;
    r1 = 0x90;
    r2 = 0xaf;
    r3 = 0x0;
    r1 = r1 << 16;
    r2 = r2 << 17;
    r0 = r0 << 15;
    FUN_200a7b4(r0, r1, r2, r3);
    FUN_200a634();
    r0 = 0x1;
    sleep(r0);
    r1 = 0xc0;
    r2 = 0xad;
    r0 = 0x0;
    r1 = r1 << 14;
    r2 = r2 << 17;
    FUN_200a714(r0, r1, r2);
    r1 = 0x9c;
    r2 = 0xb3;
    r0 = 0x19;
    r1 = r1 << 15;
    r2 = r2 << 17;
    FUN_200a714(r0, r1, r2);
    r1 = 0xce;
    r2 = 0xab;
    r0 = 0x17;
    r1 = r1 << 15;
    r2 = r2 << 17;
    FUN_200a714(r0, r1, r2);
    r1 = 0xe0;
    r2 = 0xb4;
    r0 = 0x18;
    r1 = r1 << 15;
    r2 = r2 << 17;
    FUN_200a714(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x17;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x18;
    r1 = r1 << 8;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x10;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    getMapActor(0).scale_18.set(-0x10000);
    FUN_200a654(getMapActor(0), 0);
    r1 = 0x7;
    r0 = 0x19;
    setActorAnimationIfLoaded(r0, r1);
    getMapActor(25).sprite_50.deref().rotation_1e.set(0x1555);
    FUN_200a654(getMapActor(25), 0);
    r2 = 0x3001ebc;
    CPU.r8().value = r2;
    r3 = MEMORY.ref(4, r2).get();
    r2 = 0xe0;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    MEMORY.ref(4, r3).setu(r2);
    FUN_200a814();
    FUN_200a80c();
    FUN_200a824();
    r0 = 0x50;
    FUN_200a694(r0);
    r1 = 0xc0;
    r0 = 0x17;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x18;
    r1 = r1 << 8;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x17;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0x18;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x80;
    r0 = 0x17;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0xa;
    r0 = 0x18;
    r1 = r1 << 8;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x3;
    setActorPriority(r0, r1);
    r0 = 0x19;
    r1 = 0x3;
    setActorPriority(r0, r1);
    r2 = 0x13333;
    r1 = 0x26666;
    r0 = 0x17;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    final Actor70 actor23 = getMapActor(23);
    actor23._44.set(0x28f);
    actor23._48.set(0x8000);
    FUN_200a6d4(23, 0x200aa48);
    FUN_200a694(24);
    setActorVelocityScalerAndAcceleration(24, 0x26666, 0x13333);
    final Actor70 actor24 = getMapActor(24);
    actor24._44.set(0x28f);
    actor24._48.set(0x8000);
    FUN_200a6ec(24, 0x200ab2c);
    FUN_200a694(40);
    FUN_200a7fc();
    FUN_200a804();
    sleep(20);
    FUN_200a804();
    sleep(60);
    FUN_200a804();
    sleep(20);
    FUN_200a7fc();
    FUN_200a694(40);
    MEMORY.ref(4, MEMORY.ref(4, CPU.r8().value).get() + 0x1c8).setu(120);
    FUN_200a81c();
    FUN_200a824();
    clearFlag(0x834);
    FUN_200a7cc(9);
    FUN_200a6a4();
    CPU.r8().value = CPU.pop();
  }

  @Method(0x20097c8)
  public static void FUN_20097c8() {
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
    CPU.sp().value -= 0x8;
    restorePlayer(1);
    FUN_200a69c();
    r3 = 0x3;
    r2 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x2a;
    r1 = 0x35;
    r2 = 0x2a;
    r3 = 0x36;
    FUN_200a644(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xb4;
    r1 = 0x80;
    r3 = 0x0;
    r2 = 0x26a0000;
    r1 = r1 << 13;
    r0 = r0 << 16;
    FUN_200a7b4(r0, r1, r2, r3);
    FUN_200a634();
    sleep(1);
    FUN_200a654(getMapActor(22), 0);
    FUN_200a654(getMapActor(23), 0);
    FUN_200a654(getMapActor(24), 0);
    FUN_200a654(getMapActor(25), 0);
    FUN_200a654(getMapActor(26), 0);
    FUN_200a654(getMapActor(29), 0);
    r0 = 0x0;
    r1 = 0x1;
    setActorPriority(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    setActorPriority(r0, r1);
    r0 = 0x11;
    r1 = 0x1;
    setActorPriority(r0, r1);
    r0 = 0x10;
    r1 = 0x1;
    setActorPriority(r0, r1);
    r0 = 0xf;
    r1 = 0x1;
    setActorPriority(r0, r1);
    r1 = 0xd0;
    r1 = r1 << 16;
    r2 = 0x32e0000;
    r0 = 0x0;
    FUN_200a714(r0, r1, r2);
    FUN_200a814();
    FUN_200a824();
    r0 = 0x50;
    FUN_200a694(r0);
    r0 = 0xc;
    r1 = 0x101;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r3 = 0xe0;
    r3 = r3 << 7;
    CPU.r8().value = r3;
    r2 = 0x14;
    r1 = CPU.r8().value;
    r0 = 0xc;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x11fa;
    FUN_200a764(r0);
    r0 = 0xc;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x81;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x14;
    FUN_200a79c(r0, r1, r2);
    r3 = 0x80;
    r3 = r3 << 5;
    CPU.r11().value = r3;
    r2 = 0xa;
    r0 = 0xb;
    r1 = CPU.r11().value;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0xb;
    r1 = 0x2;
    FUN_200a73c(r0, r1);
    r0 = 0xb;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x80;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r7 = 0xc0;
    r0 = 0xc;
    r1 = 0xcccc;
    r2 = 0x6666;
    r7 = r7 << 6;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xc;
    r1 = 0xb8;
    r2 = 0x26a;
    FUN_200a704(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0xc;
    r1 = r7;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0xb;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xb;
    r1 = 0xa8;
    r2 = 0x26a;
    FUN_200a704(r0, r1, r2);
    r1 = 0xf0;
    r2 = 0xa;
    r0 = 0xb;
    r1 = r1 << 8;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r2 = 0xa;
    r0 = 0xc;
    r1 = CPU.r8().value;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x1;
    FUN_200a73c(r0, r1);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200a774(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0x1e;
    r1 = 0x26666;
    r2 = 0x13333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xdc;
    r2 = 0xba;
    r2 = r2 << 18;
    r1 = r1 << 15;
    r0 = 0x1e;
    FUN_200a714(r0, r1, r2);
    r0 = 0x2;
    sleep(r0);
    r0 = 0x1e;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x200ac14;
    r0 = 0x1e;
    FUN_200a6d4(r0, r1);
    r0 = 0x28;
    FUN_200a694(r0);
    r5 = 0x200ac00;
    r0 = 0xb;
    r1 = 0x1001e;
    r2 = r5;
    FUN_200a75c(r0, r1, r2);
    r1 = 0x1001e;
    r2 = r5;
    r0 = 0xc;
    FUN_200a75c(r0, r1, r2);
    r0 = 0x1e;
    FUN_200a6dc(r0);
    r0 = 0xb;
    FUN_200a6e4(r0);
    r0 = 0xc;
    FUN_200a6e4(r0);
    r0 = 0x3c;
    FUN_200a694(r0);
    r0 = 0xb;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x105;
    r2 = 0x78;
    FUN_200a79c(r0, r1, r2);
    r0 = 0xb;
    r1 = CPU.r11().value;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r0 = 0xc;
    r1 = CPU.r8().value;
    r2 = 0x50;
    FUN_200a2e0(r0, r1, r2);
    r3 = 0xa0;
    r3 = r3 << 7;
    CPU.r9().value = r3;
    r0 = 0xb;
    r1 = CPU.r9().value;
    r2 = 0x28;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0x14;
    r0 = 0xb;
    r1 = CPU.r11().value;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0xc;
    r1 = CPU.r9().value;
    r2 = 0x3c;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = r7;
    r2 = 0x28;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = CPU.r9().value;
    r2 = 0x3c;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x101;
    r2 = 0x50;
    FUN_200a79c(r0, r1, r2);
    r0 = 0xb;
    r1 = r7;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = 0xb8;
    r2 = 0x276;
    r0 = 0xc;
    FUN_200a704(r0, r1, r2);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0xc;
    r1 = r7;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = CPU.r9().value;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = r7;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x101;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x101;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r1 = 0xa8;
    r2 = 0x276;
    r0 = 0xb;
    FUN_200a704(r0, r1, r2);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0xb;
    r1 = r7;
    r2 = 0x28;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = CPU.r9().value;
    r2 = 0x28;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = r7;
    r2 = 0x28;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x101;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r2 = 0xa;
    r0 = 0xb;
    r1 = CPU.r11().value;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xc;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x80;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x14;
    FUN_200a79c(r0, r1, r2);
    r0 = 0xb;
    r1 = CPU.r9().value;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = r7;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = CPU.r9().value;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0xb;
    r1 = CPU.r9().value;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xb;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);

    final Actor70 actor30 = getMapActor(30);
    if(actor30 != null) {
      FUN_200a714(31, actor30.pos_08.getX(), actor30.pos_08.getZ());
    }

    //LAB_2009b66
    sleep(2);
    getMapActor(30).flags_23.and(~0x1);
    getMapActor(31).flags_23.and(~0x1);
    r1 = 0x2;
    r0 = 0x1e;
    setActorPriority(r0, r1);
    r0 = 0x1f;
    r1 = 0x2;
    setActorPriority(r0, r1);
    r2 = 0x1cccc;
    r0 = 0x1f;
    r1 = 0x39999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1f;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r5 = 0x200ac90;
    r0 = 0x1f;
    r1 = r5;
    FUN_200a6d4(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0x1e;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x26666;
    r0 = 0x1e;
    r1 = 0x4cccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = r5;
    r0 = 0x1e;
    FUN_200a6ec(r0, r1);
    r0 = 0x3c;
    FUN_200a694(r0);
    r0 = 0xc;
    r1 = 0x2;
    FUN_200a73c(r0, r1);
    r2 = 0xa;
    r1 = CPU.r8().value;
    r0 = 0xc;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xc;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x1;
    r0 = 0xb;
    FUN_200a73c(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r2 = 0xa;
    r1 = CPU.r11().value;
    r0 = 0xb;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xb;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0xb;
    r1 = 0x26666;
    r2 = 0x13333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x13333;
    r0 = 0xc;
    r1 = 0x26666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x200acf8;
    r0 = 0xb;
    FUN_200a6d4(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x4ccc;
    r0 = 0x26666;
    FUN_200a7ac(r0, r1);
    FUN_200a7c4()._55.set(0);
    r1 = 0x80;
    r0 = 0xd7;
    r3 = 0x1;
    r2 = 0x3210000;
    r1 = r1 << 13;
    r0 = r0 << 16;
    FUN_200a7b4(r0, r1, r2, r3);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x200ad74;
    r0 = 0xc;
    FUN_200a6d4(r0, r1);
    r0 = 0xc;
    FUN_200a6dc(r0);
    r2 = 0x78;
    r1 = r7;
    r0 = 0xc;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x2;
    r0 = 0xd;
    FUN_200a73c(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r6 = 0x90;
    r0 = 0xd;
    r1 = 0x14;
    FUN_200a2c8(r0, r1);
    r6 = r6 << 8;
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = r6;
    r0 = 0x1;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r3 = 0xc0;
    r3 = r3 << 8;
    CPU.r10().value = r3;
    r1 = CPU.r10().value;
    r0 = 0x0;
    r2 = 0xa;
    FUN_200a2e0(r0, r1, r2);
    r3 = 0xb0;
    r3 = r3 << 8;
    CPU.r8().value = r3;
    r2 = 0xa;
    r1 = CPU.r8().value;
    r0 = 0x1;
    FUN_200a2e0(r0, r1, r2);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200a694(r0);
    r1 = 0x2;
    r0 = 0x10;
    FUN_200a73c(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0x10;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0x80;
    r2 = 0x80;
    r0 = 0x10;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0xc8;
    r0 = 0x10;
    r1 = 0xd8;
    r2 = r2 << 2;
    FUN_200a704(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x10;
    r1 = r1 << 7;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0xb4;
    r0 = FUN_200a6b4(r0, r1);
    r1 = 0x84;
    r2 = 0xc8;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = r2 << 2;
    FUN_200a704(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x10;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x28;
    FUN_200a79c(r0, r1, r2);
    r1 = 0xf0;
    r2 = 0xa;
    r0 = 0x1;
    r1 = r1 << 8;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r0 = 0x11;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x11;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = CPU.r11().value;
    r0 = 0x1;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x103;
    r2 = 0x14;
    FUN_200a79c(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x1;
    r1 = 0x4;
    FUN_200a72c(r0, r1, r2);
    r5 = 0xd0;
    r1 = 0x2;
    r0 = 0xe;
    FUN_200a73c(r0, r1);
    r5 = r5 << 8;
    r0 = 0x14;
    FUN_200a694(r0);
    r1 = r5;
    r2 = 0xa;
    r0 = 0xe;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xe;
    r1 = 0x3c;
    FUN_200a2c8(r0, r1);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x10;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x11;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x12;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x13;
    r1 = r1 << 1;
    r2 = 0x50;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x11;
    r1 = r1 << 1;
    FUN_200a79c(r0, r1, r2);
    r0 = 0x11;
    r1 = 0x3c;
    FUN_200a2c8(r0, r1);
    r0 = 0x0;
    r1 = 0x11;
    FUN_200a844(r0, r1);
    r0 = 0x1;
    r1 = 0x11;
    FUN_200a844(r0, r1);
    r2 = 0xc8;
    r0 = 0x11;
    r1 = 0xd8;
    r2 = r2 << 2;
    FUN_200a704(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x11;
    r1 = r1 << 7;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x11;
    r1 = 0x3c;
    FUN_200a2c8(r0, r1);
    r1 = 0x0;
    r0 = 0xcf;
    r0 = FUN_200a6b4(r0, r1);
    r0 = 0x0;
    FUN_200a6e4(r0);
    r0 = 0x1;
    FUN_200a6e4(r0);
    r1 = 0x88;
    r2 = 0xcc;
    r0 = 0x11;
    r1 = r1 << 1;
    r2 = r2 << 2;
    FUN_200a704(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r0 = 0x11;
    r1 = r1 << 8;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200a73c(r0, r1);
    r1 = r6;
    r2 = 0xa;
    r0 = 0x1;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = r7;
    r0 = 0xe;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0xa;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0x3c;
    r0 = 0x0;
    r1 = 0x101;
    FUN_200a79c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x1;
    FUN_200a73c(r0, r1);
    r0 = 0x10;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = 0xf0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0x14;
    r0 = 0x1;
    r1 = 0x101;
    FUN_200a79c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x10;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r0 = 0x12;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x12;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r2 = 0x0;
    r1 = r5;
    r0 = 0x1;
    FUN_200a78c(r0, r1, r2);
    r0 = 0x12;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x12;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r0 = 0x12;
    r1 = 0x3;
    FUN_200a734(r0, r1);
    r0 = 0x12;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r0 = 0x10;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x13;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x11;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0x18;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x12;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1b;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r1 = 0x3;
    r0 = 0x1c;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0x19;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x14;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xf;
    r1 = 0x2;
    r2 = 0xa;
    FUN_200a72c(r0, r1, r2);
    r2 = 0x28;
    r0 = 0xf;
    r1 = 0x4;
    FUN_200a72c(r0, r1, r2);
    r0 = 0xf;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = CPU.r8().value;
    r0 = 0x1;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r1 = CPU.r10().value;
    r0 = 0x0;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r1 = r5;
    r2 = 0xa;
    r0 = 0xf;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xf;
    r1 = 0xa;
    FUN_200a2c8(r0, r1);
    r1 = r6;
    r0 = 0xf;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0xa;
    r1 = CPU.r9().value;
    r0 = 0xf;
    FUN_200a2e0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xe;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x11;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x14;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x17;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1a;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1d;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xf;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x12;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x15;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x18;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1b;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    FUN_200a694(r0);
    r0 = 0xd;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x10;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x13;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x16;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x19;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1c;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x50;
    FUN_200a694(r0);
    r0 = 0xb;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0xe;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x11;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x14;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x17;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x1a;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x1d;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0xf;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x12;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x15;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x18;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x1b;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0xd;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x10;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x13;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x16;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r0 = 0x19;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200a72c(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x1c;
    r1 = 0x4;
    FUN_200a72c(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x1214;
    FUN_200a664(r0, r1);
    r0 = 0x50;
    FUN_200a694(r0);
    getMapActor(0).flags_23.or(0x1);
    getMapActor(1).flags_23.or(0x1);
    FUN_200a79c(0, 0x102, 0);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x50;
    FUN_200a79c(r0, r1, r2);
    r1 = 0x80;
    r1 = r1 << 7;
    r0 = 0x0;
    r2 = 0xa;
    FUN_200a2e0(r0, r1, r2);
    r1 = CPU.r9().value;
    r0 = 0x1;
    r2 = 0x14;
    FUN_200a2e0(r0, r1, r2);
    r2 = 0x6666;
    r0 = 0x0;
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r5 = 0x200adf0;
    r0 = 0x0;
    r1 = r5;
    FUN_200a6d4(r0, r1);
    r0 = 0x14;
    FUN_200a694(r0);
    r0 = 0x6666;
    r1 = 0xccc;
    FUN_200a7ac(r0, r1);
    r0 = 0xd8;
    r1 = 0x80;
    r3 = 0x1;
    r1 = r1 << 13;
    r2 = 0x3890000;
    r0 = r0 << 16;
    FUN_200a7b4(r0, r1, r2, r3);
    r0 = 0x14;
    FUN_200a694(r0);
    r2 = 0x6666;
    r0 = 0x1;
    r1 = 0xcccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = r5;
    r0 = 0x1;
    FUN_200a6d4(r0, r1);
    r0 = 0x3c;
    FUN_200a694(r0);
    r3 = 0x3001ebc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = 0xe0;
    r3 = r3 << 1;
    r2 = r1 + r3;
    r3 = r3 - 0xc0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = r3 + 0xc8;
    r2 = r1 + r3;
    r3 = 0x3c;
    MEMORY.ref(4, r2).setu(r3);
    FUN_200a81c();
    FUN_200a824();
    r0 = 0x0;
    FUN_200a6e4(r0);
    r0 = 0x1;
    FUN_200a6e4(r0);
    r0 = 0xa;
    FUN_200a7cc(r0);
    FUN_200a6a4();
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x200a2c8)
  public static void FUN_200a2c8(int r0, int r1) {
    final int r5;

    r5 = r1;
    r1 = 0x0;
    FUN_200a774(r0, r1);
    r0 = r5;
    FUN_200a694(r0);
  }

  @Method(0x200a2e0)
  public static void FUN_200a2e0(int r0, final int r1, int r2) {
    final int r5;

    r5 = r2;
    r2 = 0x0;
    FUN_200a78c(r0, r1, r2);
    r0 = r5;
    FUN_200a694(r0);
  }

  @Method(0x200a2f8)
  public static void FUN_200a2f8(final Actor70 r0) {
    if((_3001e40.get() & 0x2) != 0x0) {
      FUN_200a65c(r0, 7);
    } else {
      //LAB_200a310
      FUN_200a65c(r0, 0);
    }

    //LAB_200a318
    if((_3001e40.get() & 0xf) == 0x0) {
      FUN_200a440(r0);
    }
  }

  @Method(0x200a334)
  public static void FUN_200a334(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_200a65c(r0, FUN_200a5e4(_3001e40.get() >>> 1, 6));
    }

    //LAB_200a356
    if((_3001e40.get() & 0xf) == 0) {
      FUN_200a440(r0);
    }
  }

  @Method(0x200a370)
  public static void FUN_200a370(final Actor70 r0) {
    if((_3001e40.get() & 0x1) != 0) {
      FUN_200a65c(r0, FUN_200a5e4(_3001e40.get() >>> 1, 6));
    }
  }

  @Method(0x200a39c)
  public static void FUN_200a39c(final Actor70 r0) {
    r0._64.incr();

    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200a3bc
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(sin);
      r0.pos_08.setX(r0.parent_68.deref().pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.add(0x80000 + (0x10000 - sin) * 5);
    }
  }

  @Method(0x200a3ec)
  public static void FUN_200a3ec(final Actor70 r0) {
    r0._64.incr();

    final int angle = r0._64.get();
    if(angle > 0x1f) {
      clearActor(r0);
    } else {
      //LAB_200a40c
      final int sin = sin(angle << 10);
      r0.scale_18.set(sin);
      r0._1c.set(-sin);
      r0.pos_08.setX(r0.parent_68.deref().pos_08.getX());
      r0.pos_08.y_04.add(0x10000);
      r0.pos_08.z_08.sub((0x10000 - sin) * 5).add(0x100000);
    }
  }

  @Method(0x200a440)
  public static void FUN_200a440(final Actor70 r0) {
    final FieldPsynergy720 r11 = boardWramMallocHead_3001e50.offset(56 * 0x4).deref(4).cast(FieldPsynergy720::new);
    playSound(0x83);
    final Actor70[] actors = new Actor70[2];

    //LAB_200a466
    for(int r7 = 0; r7 < 2; r7++) {
      final Actor70 actor = loadActor(26, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
      actors[r7] = actor;
      if(actor != null) {
        actor._14.set(r0._14.get());
        actor._55.set(0);
        actor._64.set(0);
        actor.parent_68.set(r0);

        final Sprite38 r5 = actor.sprite_50.derefNullable();
        if(r5 != null) {
          //LAB_200a4a4
          setSpriteAnimation(r5, 0);
          r5._26.set(0);
          clearVramSlot(r5.slot_1c.get());
          r5.slot_1c.set(r11.vramSlot_46.get());
          r5._1d.or(0x1);
          r5.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(vramSlots_3001b10.get(r5.slot_1c.get()).vramAddr_02.get() << 17 >>> 22);
          r5.packet_00.attribs_04.flags_01.and(0x3f).and(~0x20).or(0x40);
          r5.packet_00.attribs_04.attrib1_02.and(0x3fff).or(0x8000);
          r5.layers_28.get(0).deref()._16.set(0);
        }
      }

      //LAB_200a514
    }

    final Actor70 r2 = actors[0];
    r2._6c.set(getConsumer(Map5Overlay_8784360.class, "FUN_200a3ec", Actor70.class));
    r2.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
    final Actor70 r1 = actors[1];
    r1._6c.set(getConsumer(Map5Overlay_8784360.class, "FUN_200a39c", Actor70.class));
    r1.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
    r1.flags_23.set(2);
  }

  @Method(0x200a564)
  public static void FUN_200a564() {
    final int r0;
    final int r1;

    r0 = 0x8c;
    r1 = 0x0;
    FUN_200a82c(r0, r1);
  }

  @Method(0x200a574)
  public static void FUN_200a574() {
    FUN_200a834();
  }

  @Method(0x200a580)
  public static void FUN_200a580() {
    FUN_200a334(getMapActor(15));
  }

  @Method(0x200a590)
  public static void FUN_200a590() {
    FUN_200a334(getMapActor(17));
  }

  @Method(0x200a5a0)
  public static void FUN_200a5a0() {
    FUN_200a370(getMapActor(20));
  }

  @Method(0x200a5b0)
  public static void FUN_200a5b0() {
    int r0;

    r0 = 0xb0;
    r0 = r0 << 1;
    setFlag(r0);
    r0 = 0x16d;
    setFlag(r0);
    r0 = 0x844;
    setFlag(r0);
    r0 = 0x845;
    setFlag(r0);
    r0 = 0x28;
    FUN_200a7cc(r0);
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x200a5e4)
  public static int FUN_200a5e4(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200a5ec)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200a5f4)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x200a5fc)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#atan2_} */
  @Method(0x200a604)
  public static int atan2(final int b, final int a) {
    return (int)MEMORY.call(0x8000100, b, a);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200a60c)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#clearVramSlot_} */
  @Method(0x200a614)
  public static int clearVramSlot(final int slot) {
    return (int)MEMORY.call(0x80001b8, slot);
  }

  /** {@link GoldenSun#setSpriteAnimation_} */
  @Method(0x200a61c)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x8009020, sprite, animation);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200a624)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x200a62c)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200a634)
  public static void FUN_200a634() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200a63c)
  public static void FUN_200a63c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200a644)
  public static void FUN_200a644(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200a64c)
  public static void FUN_200a64c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200a654)
  public static void FUN_200a654(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_8009240} */
  @Method(0x200a65c)
  public static void FUN_200a65c(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009240, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x200a664)
  public static void FUN_200a664(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015140} */
  @Method(0x200a66c)
  public static void FUN_200a66c() {
    MEMORY.call(0x8015140);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200a674)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200a67c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200a684)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_807#restorePlayer_} */
  @Method(0x200a68c)
  public static void restorePlayer(final int restoreStatus) {
    MEMORY.call(0x8077260, restoreStatus);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200a694)
  public static void FUN_200a694(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200a69c)
  public static void FUN_200a69c() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200a6a4)
  public static void FUN_200a6a4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a048} */
  @Method(0x200a6ac)
  public static void FUN_200a6ac(final int charId, final int r1) {
    MEMORY.call(0x808a048, charId, r1);
  }

  /** {@link GoldenSun_808#FUN_808a060} */
  @Method(0x200a6b4)
  public static int FUN_200a6b4(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a060, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200a6bc)
  public static int FUN_200a6bc(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200a6c4)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200a6cc)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200a6d4)
  public static void FUN_200a6d4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x200a6dc)
  public static void FUN_200a6dc(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x200a6e4)
  public static void FUN_200a6e4(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200a6ec)
  public static void FUN_200a6ec(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x200a6f4)
  public static void FUN_200a6f4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200a6fc)
  public static void FUN_200a6fc(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200a704)
  public static void FUN_200a704(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200a70c)
  public static void FUN_200a70c(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x200a714)
  public static void FUN_200a714(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200a71c)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200a724)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200a72c)
  public static void FUN_200a72c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200a734)
  public static void FUN_200a734(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200a73c)
  public static void FUN_200a73c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200a744)
  public static void FUN_200a744(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200a74c)
  public static void FUN_200a74c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200a754)
  public static void FUN_200a754(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a168} */
  @Method(0x200a75c)
  public static void FUN_200a75c(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    MEMORY.call(0x808a168, mapActorIndex1, mapActorIndex2AndFlags, r2);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200a764)
  public static void FUN_200a764(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200a76c)
  public static Panel24 FUN_200a76c(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200a774)
  public static void FUN_200a774(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200a77c)
  public static void FUN_200a77c(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x200a784)
  public static int FUN_200a784(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200a78c)
  public static void FUN_200a78c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x200a794)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200a79c)
  public static void FUN_200a79c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200a7a4)
  public static void FUN_200a7a4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200a7ac)
  public static void FUN_200a7ac(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200a7b4)
  public static void FUN_200a7b4(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200a7bc)
  public static void FUN_200a7bc() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a228} */
  @Method(0x200a7c4)
  public static Actor70 FUN_200a7c4() {
    return (Actor70)MEMORY.call(0x808a228);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200a7cc)
  public static void FUN_200a7cc(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#startEncounter_} */
  @Method(0x200a7d4)
  public static void startEncounter(final int encounterSet, final int encounterIndex) {
    MEMORY.call(0x808a250, encounterSet, encounterIndex);
  }

  /** {@link GoldenSun_808#FUN_808a260} */
  @Method(0x200a7dc)
  public static void FUN_200a7dc(final int r0, final int r1) {
    MEMORY.call(0x808a260, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a268} */
  @Method(0x200a7e4)
  public static void FUN_200a7e4(final int r0, final int r1) {
    MEMORY.call(0x808a268, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a2c0} */
  @Method(0x200a7ec)
  public static void FUN_200a7ec() {
    MEMORY.call(0x808a2c0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x200a7f4)
  public static void FUN_200a7f4() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d0} */
  @Method(0x200a7fc)
  public static void FUN_200a7fc() {
    MEMORY.call(0x808a2d0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x200a804)
  public static void FUN_200a804() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x200a80c)
  public static void FUN_200a80c() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200a814)
  public static void FUN_200a814() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x200a81c)
  public static void FUN_200a81c() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200a824)
  public static void FUN_200a824() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x200a82c)
  public static void FUN_200a82c(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x200a834)
  public static void FUN_200a834() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#addPpToAll_} */
  @Method(0x200a83c)
  public static void addPpToAll(final int amount) {
    MEMORY.call(0x808a4c0, amount);
  }

  /** {@link GoldenSun_808#FUN_808a588} */
  @Method(0x200a844)
  public static void FUN_200a844(final int mapActorIndex0, final int mapActorIndex1) {
    MEMORY.call(0x808a588, mapActorIndex0, mapActorIndex1);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200a84c)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
