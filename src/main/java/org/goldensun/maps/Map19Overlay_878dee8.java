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
import org.goldensun.types.Structccc;
import org.goldensun.types.Vec3;

import static org.goldensun.GoldenSunVars.*;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/**
 * Used for multiple maps
 * <ul>
 *   <li>16 - Sol Sanctum Inside (first two rooms)</li>
 *   <li>19 - Sol Sanctum Approach</li>
 * </ul>
 */
public final class Map19Overlay_878dee8 {
  private Map19Overlay_878dee8() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008030)
  public static int getRooms() {
    final int r0;
    int r1;
    final int r2;
    int r3;

    r3 = 0x2000240;
    r1 = 0xe0;
    r1 = r1 << 1;
    r3 = r3 + r1;
    r1 = 0x0;
    r2 = MEMORY.ref(2, r3 + r1).get();
    r3 = 0x13;
    if(r2 == r3) {
      r0 = 0x2009d04;
    } else {
      //LAB_2008048
      r3 = 0x10;
      if(r2 == r3) {
        r0 = 0x2009d64;
      } else {
        //LAB_2008052
        r0 = 0x2009cd4;
      }
    }

    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008070)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008074)
  public static int getTransitions() {
    final int r0;

    r0 = 0x2009f14;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x200807c)
  public static int getActors() {
    int r0;
    final int r1;
    int r2;
    int r3;
    final int r5;

    r1 = 0x2000240;
    r0 = 0xe0;
    r0 = r0 << 1;
    r3 = r1 + r0;
    r0 = 0x0;
    r2 = MEMORY.ref(2, r3 + r0).get();
    r3 = 0x10;
    if(r2 == r3) {
      r2 = 0xe1;
      r2 = r2 << 1;
      r3 = r1 + r2;
      r0 = 0x0;
      r3 = MEMORY.ref(2, r3 + r0).get();
      if(r3 < 0xb) {
        //LAB_20080ae
        r5 = 0x2009fd8;
        r0 = r5;
        FUN_2009bbc(r0);
        r0 = r5;
      } else {
        if(r3 <= 0xd) {
          //LAB_20080aa
          r0 = 0x200a050;
        } else {
          if(r3 > 0x10) {
            //LAB_20080ae
            r5 = 0x2009fd8;
            r0 = r5;
            FUN_2009bbc(r0);
            r0 = r5;
          } else {
            r0 = 0x200a1b8;
          }
        }
      }
    } else {
      //LAB_20080ba
      r3 = 0x13;
      if(r2 == r3) {
        r0 = 0x200a2a8;
      } else {
        //LAB_20080c4
        r0 = 0x2009fc0;
      }
    }

    //LAB_20080c6
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x20080ec)
  public static int getEvents() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r1 = 0x2000240;
    r0 = 0xe0;
    r0 = r0 << 1;
    r3 = r1 + r0;
    r0 = 0x0;
    r2 = MEMORY.ref(2, r3 + r0).get();
    r3 = 0x13;
    if(r2 == r3) {
      r0 = 0x200a2e4;
    } else {
      //LAB_2008104
      r3 = 0x10;
      if(r2 == r3) {
        r2 = 0xe1;
        r2 = r2 << 1;
        r3 = r1 + r2;
        r0 = 0x0;
        r3 = MEMORY.ref(2, r3 + r0).get();
        if(r3 < 0xb) {
          //LAB_2008128
          r0 = 0x200a32c;
        } else {
          if(r3 <= 0xd) {
            //LAB_2008124
            r0 = 0x200a41c;
          } else {
            if(r3 > 0x10) {
              //LAB_2008128
              r0 = 0x200a32c;
            } else {
              r0 = 0x200a524;
            }
          }
        }
      } else {
        //LAB_200812c
        r0 = 0x200a2d8;
      }
    }

    return r0;
  }

  /**
   * Event list 0x200a2e4 handler 1
   */
  @Method(value = 0x2008154, ignoreExtraParams = true)
  public static void FUN_2008154() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    CPU.sp().value -= 0x8;
    FUN_2009bac();
    r0 = 0xb5;
    playSound(r0);
    r5 = 0x3;
    r6 = 0x2;
    r1 = 0x1c;
    r2 = 0x15;
    r3 = 0x3;
    r0 = 0x10;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
    FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xa;
    sleep(r0);
    r1 = 0x1e;
    r2 = 0x15;
    r3 = 0x3;
    r0 = 0x10;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
    FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xa;
    sleep(r0);
    r3 = 0x3;
    r2 = 0x15;
    r1 = 0x20;
    r0 = 0x10;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
    FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0xa;
    sleep(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorPriority(r0, r1);
    r0 = 0x0;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x62;
    r0 = 0x0;
    r1 = 0x78;
    FUN_2009be4(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x8;
    r1 = 0x0;
    r2 = -r2;
    r0 = 0x0;
    FUN_2009bec(r0, r1, r2);
    r0 = 0xa;
    FUN_2009ba4(r0);
    FUN_2009cac();
    FUN_2009cb4();
    r0 = 0x2;
    FUN_2009c94(r0);
    FUN_2009bb4();
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200a32c handler 18
   */
  @Method(value = 0x2008200, ignoreExtraParams = true)
  public static void FUN_2008200() {
    int r0;
    int r1;
    final int r2;
    int r3;

    FUN_2009bac();
    r0 = 0x81a;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x1034;
      r1 = 0x1;
      FUN_2009b84(r0, r1);
    } else {
      //LAB_200821a
      r0 = 0x1031;
      r1 = 0x1;
      FUN_2009b84(r0, r1);
      r0 = 0xf01;
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
    }

    //LAB_200823a
    FUN_2009bb4();
  }

  /**
   * Event list 0x200a32c handler 17
   */
  @Method(value = 0x2008258, ignoreExtraParams = true)
  public static void FUN_2008258() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    int r6;

    r6 = CPU.r8().value;
    CPU.push(r6);
    r0 = 0xf01;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      //LAB_200826c
      r0 = 0x81a;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        //LAB_2008278
        FUN_2009bac();
        FUN_2009cbc();
        r0 = 0xb6;
        playSound(r0);
        r5 = 0x1;
        r2 = 0x1e;
        r1 = 0x46;
        r3 = 0x2a;
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        FUN_2009b44();
        r0 = 0x28;
        FUN_2009ba4(r0);
        r3 = 0x1032;
        CPU.r8().value = r3;
        r1 = 0x1;
        r0 = CPU.r8().value;
        FUN_2009b84(r0, r1);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r0 = 0xb7;
        playSound(r0);
        r3 = 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r6 = 0x3;
        r0 = 0x0;
        r1 = 0x1d;
        r2 = 0x3;
        r3 = 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = 0x0;
        r1 = 0x1d;
        r2 = 0x3;
        r3 = 0x2;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x51;
        r0 = 0x1;
        r1 = 0x6d;
        r2 = 0x4;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        FUN_2009b44();
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r1 = r1 << 9;
        r2 = r2 << 9;
        r0 = r0 << 9;
        FUN_2009b7c(r0, r1, r2);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_2009c6c(r0, r1, r2);
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r1 = r1 << 10;
        r2 = r2 << 9;
        r0 = r0 << 10;
        FUN_2009b7c(r0, r1, r2);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 7;
        r2 = 0x28;
        FUN_2009c5c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 8;
        r2 = 0x14;
        FUN_2009c5c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x14;
        FUN_2009c5c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 7;
        r2 = 0xa;
        FUN_2009c5c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x4;
        r2 = 0x14;
        FUN_2009c14(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x6;
        r2 = 0x28;
        FUN_2009c14(r0, r1, r2);
        r0 = 0x1;
        r1 = 0x1;
        r2 = 0xe666;
        r1 = -r1;
        r0 = -r0;
        FUN_2009b7c(r0, r1, r2);
        r0 = 0x28;
        FUN_2009ba4(r0);
        r3 = 0x1;
        CPU.r8().value = CPU.r8().value + r3;
        r1 = 0x1;
        r0 = CPU.r8().value;
        FUN_2009b84(r0, r1);
        r0 = 0x143;
        setFlag(r0);
        r0 = 0x81a;
        setFlag(r0);
        FUN_2009bb4();
      }
    }

    //LAB_200839c
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  /**
   * Event list 0x200a524 handler 24
   */
  @Method(value = 0x20083bc, ignoreExtraParams = true)
  public static void FUN_20083bc() {
    int r0;
    final int r1;
    final int r2;
    int r3;
    final int r5;

    FUN_2009bac();
    r0 = 0x821;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x1034;
      r1 = 0x1;
      FUN_2009b84(r0, r1);
    } else {
      //LAB_20083d6
      r0 = 0xf02;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x3001ebc;
        r0 = 0x1031;
        r1 = 0x1;
        r5 = MEMORY.ref(4, r3).get();
        FUN_2009b84(r0, r1);
        r3 = 0xb9;
        r3 = r3 << 1;
        r2 = r5 + r3;
        r3 = 0x1;
        MEMORY.ref(2, r2).setu(r3);
      } else {
        //LAB_20083f8
        r0 = 0x1031;
        r1 = 0x1;
        FUN_2009b84(r0, r1);
      }
    }

    //LAB_2008400
    FUN_2009bb4();
  }

  /**
   * Event list 0x200a524 handler 23
   */
  @Method(value = 0x2008420, ignoreExtraParams = true)
  public static void FUN_2008420() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    int r6;

    r0 = 0xf02;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      //LAB_2008430
      r0 = 0x821;
      r0 = readFlag(r0);
      if(r0 == 0x0) {
        //LAB_200843c
        FUN_2009bac();
        FUN_2009cbc();
        r0 = 0xb6;
        playSound(r0);
        r5 = 0x1;
        r2 = 0x64;
        r3 = 0x47;
        r1 = 0x47;
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        FUN_2009b44();
        r0 = 0x28;
        FUN_2009ba4(r0);
        r6 = 0x1032;
        r1 = 0x1;
        r0 = r6;
        FUN_2009b84(r0, r1);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r0 = 0xb7;
        playSound(r0);
        r3 = 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r0 = 0x7a;
        r1 = 0x14;
        r2 = 0x78;
        r3 = 0x1e;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r3 = 0x78;
        r2 = 0x1e;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r3 = 0x2;
        r0 = 0x7a;
        r1 = 0x14;
        r2 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        FUN_2009b44();
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r1 = r1 << 9;
        r2 = r2 << 9;
        r0 = r0 << 9;
        FUN_2009b7c(r0, r1, r2);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 1;
        r2 = 0x0;
        FUN_2009c6c(r0, r1, r2);
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r1 = r1 << 10;
        r2 = r2 << 9;
        r0 = r0 << 10;
        FUN_2009b7c(r0, r1, r2);
        r0 = 0x14;
        FUN_2009ba4(r0);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 7;
        r2 = 0x28;
        FUN_2009c5c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 8;
        r2 = 0x14;
        FUN_2009c5c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x14;
        FUN_2009c5c(r0, r1, r2);
        r1 = 0x80;
        r0 = 0x0;
        r1 = r1 << 7;
        r2 = 0xa;
        FUN_2009c5c(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x4;
        r2 = 0x14;
        FUN_2009c14(r0, r1, r2);
        r0 = 0x0;
        r1 = 0x6;
        r2 = 0x28;
        FUN_2009c14(r0, r1, r2);
        r0 = 0x1;
        r1 = 0x1;
        r2 = 0xe666;
        r1 = -r1;
        r0 = -r0;
        FUN_2009b7c(r0, r1, r2);
        r6 = r6 + 0x1;
        r0 = 0x28;
        FUN_2009ba4(r0);
        r1 = 0x1;
        r0 = r6;
        FUN_2009b84(r0, r1);
        r0 = 0x143;
        setFlag(r0);
        r0 = 0x821;
        setFlag(r0);
        FUN_2009bb4();
      }
    }

    //LAB_200854e
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200a41c handler 16
   */
  @Method(value = 0x200856c, ignoreExtraParams = true)
  public static void FUN_200856c() {
    final Actor70 r0 = getMapActor(9);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x302);
      clearFlag(0x303);
      if(r5 == 93) {
        setFlag(0x303);
        //LAB_2008594
      } else if(r5 == 0x5f) {
        setFlag(0x302);
      }
    }
  }

  /**
   * Event list 0x200a41c handler 17
   */
  @Method(value = 0x20085ac, ignoreExtraParams = true)
  public static void FUN_20085ac() {
    final Actor70 r0 = getMapActor(10);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x300);
      clearFlag(0x301);
      if(r5 == 0x73) {
        setFlag(0x300);
        //LAB_20085d8
      } else if(r5 == 0x71) {
        setFlag(0x301);
      }
    }
  }

  /**
   * Event list 0x200a524 handler 16
   */
  @Method(value = 0x20085ec, ignoreExtraParams = true)
  public static void FUN_20085ec() {
    final Actor70 r0 = getMapActor(9);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x310);
      clearFlag(0x311);
      if(r5 == 0x63) {
        setFlag(0x311);
        //LAB_2008616
      } else if(r5 == 0x65) {
        setFlag(0x310);
      }

      //LAB_2008622
      FUN_20097c0(0);
    }
  }

  /**
   * Event list 0x200a524 handler 17
   */
  @Method(value = 0x2008634, ignoreExtraParams = true)
  public static void FUN_2008634() {
    final Actor70 r0 = getMapActor(10);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x312);
      clearFlag(0x313);
      if(r5 == 0x67) {
        setFlag(0x313);
        //LAB_200865c
      } else if(r5 == 0x69) {
        setFlag(0x312);
      }

      //LAB_2008666
      FUN_20097c0(0);
    }
  }

  /**
   * Event list 0x200a524 handler 18
   */
  @Method(value = 0x200867c, ignoreExtraParams = true)
  public static void FUN_200867c() {
    final Actor70 r0 = getMapActor(11);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x314);
      clearFlag(0x315);
      if(r5 == 0x6b) {
        setFlag(0x315);
        //LAB_20086a6
      } else if(r5 == 0x6d) {
        setFlag(0x314);
      }

      //LAB_20086b2
      FUN_20097c0(0);
    }
  }

  /**
   * Event list 0x200a524 handler 19
   */
  @Method(value = 0x20086c4, ignoreExtraParams = true)
  public static void FUN_20086c4() {
    final Actor70 r0 = getMapActor(12);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x316);
      clearFlag(0x317);
      if(r5 == 0x6f) {
        setFlag(0x317);
        //LAB_20086ec
      } else if(r5 == 0x71) {
        setFlag(0x316);
      }

      //LAB_20086f6
      FUN_20097c0(0);
    }
  }

  /**
   * Event list 0x200a524 handler 20
   */
  @Method(value = 0x200870c, ignoreExtraParams = true)
  public static void FUN_200870c() {
    final Actor70 r0 = getMapActor(13);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x318);
      clearFlag(0x319);
      if(r5 == 0x73) {
        setFlag(0x319);
        //LAB_2008736
      } else if(r5 == 0x75) {
        setFlag(0x318);
      }

      //LAB_2008742
      FUN_20097c0(0);
    }
  }

  /**
   * Event list 0x200a524 handler 21
   */
  @Method(value = 0x2008754, ignoreExtraParams = true)
  public static void FUN_2008754() {
    final Actor70 r0 = getMapActor(14);
    if(r0 != null) {
      final int r5 = r0.pos_08.getX() >> 20;
      clearFlag(0x31a);
      clearFlag(0x31b);
      if(r5 == 0x77) {
        setFlag(0x31b);
        //LAB_200877c
      } else if(r5 == 0x79) {
        setFlag(0x31a);
      }

      //LAB_2008786
      FUN_20097c0(0);
    }
  }

  @Method(0x200879c)
  public static Actor70 FUN_200879c(final int x, final int z) {
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_20087aa
    for(int r4 = 8; r4 < 66; r4++) {
      final Actor70 actor = r3.actors_14.get(r4).deref();
      if((actor.pos_08.getX() >> 20) == x && (actor.pos_08.getZ() >> 20) == z) {
        return actor;
      }

      //LAB_20087bc
    }

    //LAB_20087c4
    return null;
  }

  /**
   * Event list 0x200a41c handler 20
   */
  @Method(value = 0x20087d0, ignoreExtraParams = true)
  public static void FUN_20087d0() {
    final Actor70 r8 = getMapActor(0);
    final int r3 = (r8.angle_06.get() & 0xffff) >>> 12;
    final int r3_0 = MEMORY.ref(4, 0x200a65c + r3 * 0x4).get();
    final Actor70 r7 = FUN_200879c((r8.pos_08.getX() >> 16) + (r3_0 >> 16) >> 4, (r8.pos_08.getZ() >> 16) + (short)r3_0 >> 4);
    if(r7 != null) {
      r7.layer_22.set(2);
      final Vec3 r6 = new Vec3();
      r6.setX(r7.pos_08.getX() + (r3_0 & 0xffff0000));
      r6.setY(r7.pos_08.getY());
      r6.setZ(r7.pos_08.getZ() + (r3_0 << 16));

      if(FUN_2009b6c(r7, r6) <= 0x0) {
        setActorAnimation(r8, 8);
        sleep(15);
        playSound(0xb9);
        r7.velocityScalar_30.set(0x3333);
        r7.acceleration_34.set(0x3333);
        moveActorTo(r7, r6.getX(), r6.getY(), r6.getZ());
        r8.velocityScalar_30.set(0x3333);
        r8.acceleration_34.set(0x3333);
        moveActorTo(r8, r6.getX(), r6.getY(), r6.getZ());
        FUN_2009b54(r7);
        r7.pos_08.setX(r6.getX());
        r7.pos_08.setZ(r6.getZ());
        r7.velocity_24.setX(0);
        r7.velocity_24.setZ(0);
        setActorAnimation(r8, 1);

        final int entranceId = entranceId_2000402.get();
        if(entranceId >= 0xb) {
          if(entranceId <= 0xd) {
            //LAB_20088b2
            FUN_200856c();
            FUN_20085ac();
          } else if(entranceId <= 0x10) {
            //LAB_20088bc
            FUN_20085ec();
            FUN_2008634();
            FUN_200867c();
            FUN_20086c4();
            FUN_200870c();
            FUN_2008754();
          }
        }
      }
    }

    //LAB_20088d4
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x20088f4)
  public static int init() {
    final int r2 = mapId_2000400.get();
    if(r2 == 0x13) {
      FUN_200892c();
      //LAB_200890e
    } else if(r2 == 0x10) {
      FUN_2008a24();
    }

    //LAB_2008918
    return 0;
  }

  @Method(0x200892c)
  public static void FUN_200892c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r0 = 0xa2;
    r0 = r0 << 1;
    CPU.sp().value -= 0x8;
    setFlag(r0);
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x814;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x200a69c;
      r2 = 0x0;
      MEMORY.ref(4, r3).setu(r2);
      setTickCallback(getRunnable(Map19Overlay_878dee8.class, "FUN_2009ac8"), 0xc80);
    }

    //LAB_2008960
    r0 = 0x879;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r5 = 0x6;
      r0 = 0x5;
      r1 = 0x6;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x7;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x5;
      r1 = 0x6;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x5;
      r1 = 0x6;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x5;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r0 = 0x0;
      r1 = 0x1;
      r2 = 0x3;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_20089b2
    r0 = 0x815;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r1 = 0xf0;
      r2 = 0xe8;
      r0 = 0x8;
      r1 = r1 << 15;
      r2 = r2 << 16;
      moveActorToPosition(r0, r1, r2);
      r3 = 0x6;
      r5 = 0xe;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2;
      r1 = 0xa;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x7;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2;
      r1 = 0xa;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2;
      r1 = 0xa;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_2008a02
    CPU.sp().value += 0x8;
  }

  @Method(0x2008a24)
  public static void FUN_2008a24() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r3 = 0x3001ebc;
    r0 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r0 = r0 << 1;
    r2 = 0x81;
    r3 = r3 + r0;
    r2 = r2 << 2;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x814;
    CPU.sp().value -= 0x8;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x8d;
      FUN_2009cc4(r0);
      r0 = 0x80;
      r1 = 0x80;
      r2 = 0x80;
      r0 = r0 << 9;
      r1 = r1 << 9;
      r2 = r2 << 9;
      FUN_2009b7c(r0, r1, r2);
      FUN_2009c9c();
    }

    //LAB_2008a5c
    r1 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r1 + r2;
    r0 = 0x0;
    r3 = MEMORY.ref(2, r3 + r0).get();
    r3 = r3 - 0x1;

    //LAB_2008a70
    switch(r3) {
      case 0: // switch 2008a78
      case 1: // switch 2008a78
        //LAB_2008ab8
        r0 = 0x81a;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          //LAB_2008ac4
          r5 = 0x1;
          r0 = 0x1;
          r1 = 0x6d;
          r2 = 0x4;
          r3 = 0x51;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x0;
          r1 = 0x46;
          r2 = 0x1e;
          r3 = 0x2a;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r6 = 0x3;
          r0 = 0x0;
          r1 = 0x1d;
          r2 = 0x3;
          r3 = 0x1;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x0;
          r1 = 0x1d;
          r2 = 0x3;
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          FUN_2009b44();
        }
        break;

      case 2: // switch 2008a78
        //LAB_2008b10
        FUN_2009b74(getMapActor(9), 0);
        break;

      case 7: // switch 2008a78
        //LAB_2008b1e
        r0 = 0x90;
        r2 = 0x10;
        r0 = r0 << 2;
        r3 = r1 + r0;
        MEMORY.ref(2, r3).setu(r2);
        r3 = 0x242;
        r2 = r1 + r3;
        r3 = 0x8;
        MEMORY.ref(2, r2).setu(r3);
        r0 = 0x802;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          //LAB_2008b3c
          FUN_2008d1c();
        }
        break;

      case 10: // switch 2008a78
      case 11: // switch 2008a78
      case 12: // switch 2008a78
        //LAB_2008b42
        FUN_2009b74(getMapActor(9), 0);
        FUN_2009b74(getMapActor(10), 0);
        FUN_2009b74(getMapActor(11), 0);
        FUN_2009b74(getMapActor(12), 0);
        FUN_2009b74(getMapActor(13), 0);
        FUN_2009b74(getMapActor(14), 0);
        FUN_2009b74(getMapActor(15), 0);
        FUN_2009b74(getMapActor(16), 0);
        FUN_2009b74(getMapActor(17), 0);
        FUN_2009b74(getMapActor(18), 0);
        FUN_2009b74(getMapActor(19), 0);

        if(readFlag(0x804) == 0) {
          FUN_2008f8c();
        }

        //LAB_2008bd4
        r0 = 0x303;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r1 = 0xbb;
          r2 = 0x88;
          r0 = 0x9;
          r1 = r1 << 19;
          r2 = r2 << 16;
          moveActorToPosition(r0, r1, r2);
        } else {
          //LAB_2008bee
          r0 = 0x302;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r1 = 0xbf;
            r2 = 0x88;
            r0 = 0x9;
            r1 = r1 << 19;
            r2 = r2 << 16;
            moveActorToPosition(r0, r1, r2);
          }
        }

        //LAB_2008c06
        r0 = 0x301;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r1 = 0xe3;
          r2 = 0x88;
          r0 = 0xa;
          r1 = r1 << 19;
          r2 = r2 << 16;
          moveActorToPosition(r0, r1, r2);
        } else {
          //LAB_2008c14
          r0 = 0xc0;
          r0 = r0 << 2;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r1 = 0xe7;
            r2 = 0x88;
            r0 = 0xa;
            r1 = r1 << 19;
            r2 = r2 << 16;
            moveActorToPosition(r0, r1, r2);
          }
        }
        break;

      case 13: // switch 2008a78
      case 14: // switch 2008a78
      case 15: // switch 2008a78
        //LAB_2008c30
        FUN_2009b74(getMapActor(9), 0);
        FUN_2009b74(getMapActor(10), 0);
        FUN_2009b74(getMapActor(11), 0);
        FUN_2009b74(getMapActor(12), 0);
        FUN_2009b74(getMapActor(13), 0);
        FUN_2009b74(getMapActor(14), 0);
        if(readFlag(0x825) == 0) {
          FUN_200961c();
        }

        //LAB_2008c86
        r0 = 0x1;
        FUN_20097c0(r0);
        r0 = 0x8d;
        r0 = r0 << 2;
        setFlag(r0);
        r0 = 0x821;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r5 = 0x1;
          r0 = 0x0;
          r1 = 0x47;
          r2 = 0x64;
          r3 = 0x47;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
          FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = 0x7a;
          r1 = 0x14;
          r2 = 0x78;
          r3 = 0x1e;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          FUN_2009b5c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = 0x78;
          r2 = 0x1e;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          r0 = 0x7a;
          r1 = 0x14;
          r2 = 0x1;
          r3 = 0x2;
          FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          FUN_2009b44();
        }
        break;
    }

    //LAB_2008cda
    CPU.sp().value += 0x8;
  }

  @Method(0x2008d1c)
  public static void FUN_2008d1c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    FUN_2009bac();
    r5 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r5).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 - 0xc0;
    MEMORY.ref(4, r3).setu(r2);
    FUN_2009ca4();
    r1 = 0x0;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x4;
    FUN_2009ba4(r0);
    r0 = 0x1;
    r1 = 0x1;
    r2 = 0x1;
    r2 = -r2;
    r3 = 0x0;
    r0 = -r0;
    r1 = -r1;
    FUN_2009c84(r0, r1, r2, r3);
    r0 = 0x9999;
    r1 = 0x1333;
    FUN_2009c7c(r0, r1);
    r0 = 0x99;
    r1 = 0x1;
    r2 = 0x88;
    r0 = r0 << 19;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    FUN_2009c84(r0, r1, r2, r3);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      moveActorToPosition(8, actor0.pos_08.getX(), actor0.pos_08.getZ());
      moveActorToPosition(5, actor0.pos_08.getX(), actor0.pos_08.getZ());
      moveActorToPosition(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_2008daa
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x4ccc;
    r0 = 0x1;
    r1 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x10;
    r0 = 0x1;
    r1 = -r1;
    r2 = 0x0;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x10;
    r2 = 0x0;
    FUN_2009bec(r0, r1, r2);
    r2 = 0x20;
    r2 = -r2;
    r1 = 0x0;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x1;
    FUN_2009bf4(r0);
    r0 = 0x1;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x5;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x28;
    FUN_2009ba4(r0);
    r1 = 0x2;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0x14;
    FUN_2009ba4(r0);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 6;
    r2 = 0x28;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x8;
    r1 = r1 << 7;
    r2 = 0x28;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 6;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r2 = 0x14;
    r1 = 0x4;
    r0 = 0x8;
    FUN_2009c14(r0, r1, r2);
    r0 = 0xfd3;
    FUN_2009c34(r0);
    r1 = 0x0;
    r0 = 0x4008;
    r0 = FUN_2009c54(r0, r1);
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x99;
    r1 = 0x1;
    r2 = 0x94;
    r0 = r0 << 19;
    r1 = -r1;
    r2 = r2 << 16;
    r3 = 0x1;
    FUN_2009c84(r0, r1, r2, r3);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      FUN_2009bdc(1, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_2008ec6
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      FUN_2009bdc(5, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_2008ee6
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      FUN_2009bdc(8, actor0.pos_08.getX() >> 16, actor0.pos_08.getZ() >> 16);
    }

    //LAB_2008f06
    r0 = 0x1;
    FUN_2009bf4(r0);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x5;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r2 = 0x0;
    r0 = 0x8;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x802;
    setFlag(r0);
    r3 = MEMORY.ref(4, r5).get();
    r2 = 0xe0;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 + 0x44;
    MEMORY.ref(4, r3).setu(r2);
    r0 = 0x12f;
    clearFlag(r0);
    FUN_2009bb4();
  }

  @Method(0x2008f8c)
  public static void FUN_2008f8c() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_2009bac();
    FUN_2009ca4();
    FUN_2009cb4();

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      moveActorToPosition(8, actor0.pos_08.getX(), actor0.pos_08.getZ());
      moveActorToPosition(5, actor0.pos_08.getX(), actor0.pos_08.getZ());
      moveActorToPosition(1, actor0.pos_08.getX(), actor0.pos_08.getZ());
    }

    //LAB_2008fd6
    r0 = 0x8;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x9999;
    r2 = 0x4ccc;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x4ccc;
    r0 = 0x1;
    r1 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x10;
    r0 = 0x1;
    r1 = -r1;
    r2 = 0x0;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x10;
    r2 = 0x0;
    FUN_2009bec(r0, r1, r2);
    r2 = 0x10;
    r2 = -r2;
    r1 = 0x0;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x0;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x1e;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x1e;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 7;
    r2 = 0x1e;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0xa;
    FUN_2009ba4(r0);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x10;
    r2 = -r2;
    r1 = 0x0;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x6;
    FUN_2009ba4(r0);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x20;
    r2 = -r2;
    r1 = 0x0;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 10;
    r1 = r1 << 7;
    FUN_2009c7c(r0, r1);
    r1 = 0x1;
    r2 = 0x96;
    r2 = r2 << 16;
    r3 = 0x1;
    r1 = -r1;
    r0 = 0x6310000;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0xa;
    FUN_2009ba4(r0);
    r0 = 0x13333;
    r1 = 0x2666;
    FUN_2009c7c(r0, r1);
    r1 = 0x1;
    r2 = 0xc8;
    r0 = 0x6550000;
    r1 = -r1;
    r2 = r2 << 15;
    r3 = 0x1;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r1 = 0x1;
    r2 = 0xc8;
    r2 = r2 << 15;
    r3 = 0x1;
    r0 = 0x6b60000;
    r1 = -r1;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xdb;
    r1 = 0x1;
    r2 = 0x96;
    r2 = r2 << 16;
    r3 = 0x1;
    r1 = -r1;
    r0 = r0 << 19;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0x28;
    FUN_2009ba4(r0);
    r0 = 0x26666;
    r1 = 0x4ccc;
    FUN_2009c7c(r0, r1);
    r1 = 0x1;
    r2 = 0x80;
    r3 = 0x1;
    r2 = r2 << 17;
    r0 = 0x6840000;
    r1 = -r1;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_2009ba4(r0);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x5;
    r1 = r1 << 8;
    r2 = 0xa;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x101;
    r2 = 0x14;
    r0 = 0x1;
    FUN_2009c6c(r0, r1, r2);
    r0 = 0xfd6;
    FUN_2009c34(r0);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x3c;
    r0 = 0x8;
    r1 = r1 << 1;
    FUN_2009c6c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    FUN_2009c1c(r0, r1);
    r2 = 0xa;
    r0 = 0x8;
    r1 = 0x0;
    FUN_2009c4c(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_2009c1c(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_2009c1c(r0, r1);
    r0 = 0x5;
    r1 = 0x2;
    FUN_2009c1c(r0, r1);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    FUN_2009c74(r0, r1);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_2009c74(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r0 = 0x5;
    FUN_2009c74(r0, r1);
    r0 = 0x28;
    FUN_2009ba4(r0);
    r1 = 0x2;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x8;
    r1 = 0x0;
    FUN_2009c44(r0, r1);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x5;
    r0 = 0x0;
    FUN_2009c2c(r0, r1, r2);
    r0 = 0x28;
    FUN_2009ba4(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_2009c1c(r0, r1);
    r1 = 0x1;
    r0 = 0x5;
    FUN_2009c24(r0, r1);
    r0 = 0xa;
    FUN_2009ba4(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x14;
    r0 = 0x5;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x2;
    FUN_2009c24(r0, r1);
    r2 = 0xa;
    r0 = 0x5;
    r1 = 0x0;
    FUN_2009c4c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x4;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r1 = 0xc0;
    r0 = 0x8;
    r1 = r1 << 6;
    r2 = 0xa;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x28;
    FUN_2009c4c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x14;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0xa;
    FUN_2009ba4(r0);
    r1 = 0x81;
    r0 = 0x8;
    r1 = r1 << 1;
    FUN_2009c74(r0, r1);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x3c;
    r0 = 0x8;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x2;
    r0 = 0x8;
    FUN_2009c24(r0, r1);
    r0 = 0xa;
    FUN_2009ba4(r0);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x8;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    r2 = 0x14;
    FUN_2009c14(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x28;
    FUN_2009c4c(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x1;
    FUN_2009c3c(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_2009bc4(r0, r1);
    if(r0 == 0x0) {
      r0 = 0xfe0;
      FUN_2009c34(r0);
      r0 = 0x1;
      r1 = 0x1;
      FUN_2009c24(r0, r1);
      r0 = 0x1;
      r1 = 0x0;
      r2 = 0xa;
      FUN_2009c4c(r0, r1, r2);
    } else {
      //LAB_2009442
      r0 = 0xfe1;
      FUN_2009c34(r0);
      r1 = 0x80;
      r0 = 0x5;
      r1 = r1 << 8;
      r2 = 0x14;
      FUN_2009c5c(r0, r1, r2);
      r0 = 0x5;
      r1 = 0x0;
      r2 = 0xa;
      FUN_2009c4c(r0, r1, r2);
      r1 = 0xc0;
      r0 = 0x0;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_2009c5c(r0, r1, r2);
      r1 = 0xe0;
      r0 = 0x1;
      r1 = r1 << 8;
      r2 = 0x0;
      FUN_2009c5c(r0, r1, r2);
      r1 = 0xa0;
      r0 = 0x5;
      r1 = r1 << 8;
      r2 = 0x3c;
      FUN_2009c5c(r0, r1, r2);
      r1 = 0x81;
      r2 = 0x28;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_2009c6c(r0, r1, r2);
      r1 = 0x1;
      r0 = 0x1;
      FUN_2009c24(r0, r1);
      r0 = 0xa;
      FUN_2009ba4(r0);
      r1 = 0x3;
      r0 = 0x1;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_2009ba4(r0);
      r0 = 0x1;
      r1 = 0x0;
      r2 = 0x0;
      FUN_2009c5c(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x1e;
      r0 = 0x5;
      r1 = r1 << 8;
      FUN_2009c5c(r0, r1, r2);
      r1 = 0x1;
      r0 = 0x1;
      FUN_2009c24(r0, r1);
      r0 = 0xa;
      FUN_2009ba4(r0);
      r0 = 0x1;
      r1 = 0x0;
      r2 = 0xa;
      FUN_2009c4c(r0, r1, r2);
    }

    //LAB_20094d8
    r2 = 0x4ccc;
    r0 = 0x8;
    r1 = 0x9999;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x30;
    r1 = 0x0;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x6;
    FUN_2009ba4(r0);
    r1 = 0xe0;
    r0 = 0x1;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xa0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x5;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x5;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x6;
    FUN_2009ba4(r0);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_2009bdc(1, r1, r2);
    }

    //LAB_2009572
    r0 = 0x5;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_2009bdc(5, r1, r2);
    }

    //LAB_2009592
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_2009bdc(8, r1, r2);
    }

    //LAB_20095b2
    r0 = 0x8;
    FUN_2009bf4(r0);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x5;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x8;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x1;
    r0 = 0x5;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x804;
    setFlag(r0);
    r0 = 0x12f;
    clearFlag(r0);
    FUN_2009bb4();
  }

  @Method(0x200961c)
  public static void FUN_200961c() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_2009bac();
    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = r2 + 0x44;
    MEMORY.ref(4, r3).setu(r2);
    FUN_2009ca4();
    FUN_2009cb4();
    r0 = 0x14;
    FUN_2009ba4(r0);

    final Actor70 actor0 = getMapActor(0);
    if(actor0 != null) {
      r1 = actor0.pos_08.getX();
      r2 = actor0.pos_08.getZ();
      moveActorToPosition(8, r1, r2);
    }

    //LAB_2009652
    r1 = 0x80;
    r2 = 0x80;
    r2 = r2 << 8;
    r0 = 0x8;
    r1 = r1 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0xa;
    r2 = -r2;
    r1 = 0x18;
    r0 = 0x8;
    FUN_2009bec(r0, r1, r2);
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x6;
    FUN_2009ba4(r0);
    r1 = 0xb0;
    r0 = 0x8;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_2009c5c(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x28;
    r0 = 0x0;
    r1 = r1 << 8;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x26666;
    r1 = 0x4ccc;
    FUN_2009c7c(r0, r1);
    r0 = 0xd1;
    r1 = 0x1;
    r2 = 0x83;
    r2 = r2 << 18;
    r3 = 0x1;
    r1 = -r1;
    r0 = r0 << 19;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x19999;
    r1 = 0x3333;
    FUN_2009c7c(r0, r1);
    r0 = 0xeb;
    r1 = 0x1;
    r2 = 0x83;
    r2 = r2 << 18;
    r3 = 0x1;
    r1 = -r1;
    r0 = r0 << 19;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x33333;
    r1 = 0x6666;
    FUN_2009c7c(r0, r1);
    r1 = 0x1;
    r2 = 0x89;
    r3 = 0x1;
    r2 = r2 << 18;
    r1 = -r1;
    r0 = 0x6e90000;
    FUN_2009c84(r0, r1, r2, r3);
    FUN_2009c8c();
    r0 = 0x14;
    FUN_2009ba4(r0);
    r0 = 0x8;
    r1 = 0x2;
    FUN_2009c24(r0, r1);
    r1 = 0x0;
    r2 = 0x1e;
    r0 = 0x8;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x103a;
    FUN_2009c34(r0);
    r0 = 0x4008;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x28;
    r0 = 0x8;
    r1 = r1 << 1;
    FUN_2009c6c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x1;
    FUN_2009c24(r0, r1);
    r1 = 0xa0;
    r0 = 0x8;
    r1 = r1 << 7;
    r2 = 0x14;
    FUN_2009c5c(r0, r1, r2);
    r0 = 0x4008;
    r1 = 0x0;
    r2 = 0xa;
    FUN_2009c4c(r0, r1, r2);
    r0 = 0x8;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);

    if(actor0 != null) {
      r1 = actor0.pos_08.getX() >> 16;
      r2 = actor0.pos_08.getZ() >> 16;
      FUN_2009bdc(8, r1, r2);
    }

    //LAB_2009776
    r0 = 0x8;
    FUN_2009bf4(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x825;
    setFlag(r0);
    FUN_2009bb4();
  }

  @Method(0x20097c0)
  public static void FUN_20097c0(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    CPU.sp().value -= 0x8;
    r5 = 0x20;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    r6 = r0;
    r7 = 0x64;
    r0 = 0x7a;
    MEMORY.ref(4, CPU.sp().value).setu(r7);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x68;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x7a;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x6c;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x7a;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x70;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x7a;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x74;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x7a;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0x78;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = 0x7a;
    r1 = 0x14;
    r2 = 0x1;
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x311;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r7);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xc7;
        r2 = 0x82;
        r0 = 0x9;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_2009862
      r0 = 0xc4;
      r0 = r0 << 2;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r7);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xcb;
          r2 = 0x82;
          r0 = 0x9;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_2009890
    r0 = 0x313;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x68;
      r2 = 0x20;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xcf;
        r2 = 0x82;
        r0 = 0xa;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_20098c2
      r0 = 0x312;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x68;
        r2 = 0x20;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xd3;
          r2 = 0x82;
          r0 = 0xa;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_20098f2
    r0 = 0x315;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x6c;
      r2 = 0x20;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xd7;
        r2 = 0x82;
        r0 = 0xb;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_2009924
      r0 = 0xc5;
      r0 = r0 << 2;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x6c;
        r2 = 0x20;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xdb;
          r2 = 0x82;
          r0 = 0xb;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_2009956
    r0 = 0x317;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x70;
      r2 = 0x20;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xdf;
        r2 = 0x82;
        r0 = 0xc;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_2009988
      r0 = 0x316;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x70;
        r2 = 0x20;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xe3;
          r2 = 0x82;
          r0 = 0xc;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_20099b8
    r0 = 0x319;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x74;
      r2 = 0x20;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xe7;
        r2 = 0x82;
        r0 = 0xd;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_20099ea
      r0 = 0xc6;
      r0 = r0 << 2;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x74;
        r2 = 0x20;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xeb;
          r2 = 0x82;
          r0 = 0xd;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_2009a1c
    r0 = 0x31b;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r3 = 0x78;
      r2 = 0x20;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      r0 = 0x79;
      r1 = 0x14;
      r2 = 0x1;
      r3 = 0x1;
      FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      if(r6 != 0x0) {
        r1 = 0xef;
        r2 = 0x82;
        r0 = 0xe;
        r1 = r1 << 19;
        r2 = r2 << 18;
        moveActorToPosition(r0, r1, r2);
      }
    } else {
      //LAB_2009a4e
      r0 = 0x31a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r3 = 0x78;
        r2 = 0x20;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
        r0 = 0x79;
        r1 = 0x14;
        r2 = 0x1;
        r3 = 0x1;
        FUN_2009b64(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        if(r6 != 0x0) {
          r1 = 0xf3;
          r2 = 0x82;
          r0 = 0xe;
          r1 = r1 << 19;
          r2 = r2 << 18;
          moveActorToPosition(r0, r1, r2);
        }
      }
    }

    //LAB_2009a7e
    CPU.sp().value += 0x8;
  }

  /**
   * Event list 0x200a2e4 handler 2
   */
  @Method(value = 0x2009aac, ignoreExtraParams = true)
  public static void FUN_2009aac() {
    final int r0;
    final int r1;

    FUN_2009bac();
    r0 = 0x953;
    r1 = 0x1;
    FUN_2009b84(r0, r1);
    FUN_2009bb4();
  }

  @Method(0x2009ac8)
  public static void FUN_2009ac8() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    r5 = 0x200a69c;
    r3 = MEMORY.ref(4, r5).get();
    if(r3 != 0x0) {
      r3 = r3 - 0x1;
      MEMORY.ref(4, r5).setu(r3);
      if(r3 == 0x28) {
        r0 = 0x1;
        r1 = 0x1;
        r0 = -r0;
        r1 = -r1;
        r2 = 0xe666;
        FUN_2009b7c(r0, r1, r2);
      }
    } else {
      //LAB_2009aea
      r0 = rand();
      r3 = r0 << 4;
      r3 = r3 - r0;
      r3 = r3 << 3;
      r3 = r3 >>> 16;
      if(r3 == 0x0) {
        r0 = 0x8a;
        playSound(r0);
        r0 = 0x80;
        r1 = 0x80;
        r2 = 0x80;
        r0 = r0 << 9;
        r1 = r1 << 10;
        r2 = r2 << 9;
        FUN_2009b7c(r0, r1, r2);
        r3 = 0x50;
        MEMORY.ref(4, r5).setu(r3);
      }
    }
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x2009b24)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x2009b2c)
  public static void setTickCallback(final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x2009b34)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#setActorAnimation_} */
  @Method(0x2009b3c)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x8009080, actor, animationIndex);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x2009b44)
  public static void FUN_2009b44() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#moveActorTo_} */
  @Method(0x2009b4c)
  public static void moveActorTo(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x8009150, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009158} */
  @Method(0x2009b54)
  public static void FUN_2009b54(final Actor70 r0) {
    MEMORY.call(0x8009158, r0);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x2009b5c)
  public static void FUN_2009b5c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x2009b64)
  public static void FUN_2009b64(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091d8} */
  @Method(0x2009b6c)
  public static int FUN_2009b6c(final Actor70 r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80091d8, r0, r1);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x2009b74)
  public static void FUN_2009b74(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x2009b7c)
  public static void FUN_2009b7c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x2009b84)
  public static void FUN_2009b84(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x2009b8c)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x2009b94)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x2009b9c)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x2009ba4)
  public static void FUN_2009ba4(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x2009bac)
  public static void FUN_2009bac() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x2009bb4)
  public static void FUN_2009bb4() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a038} */
  @Method(0x2009bbc)
  public static void FUN_2009bbc(final int r0) {
    MEMORY.call(0x808a038, r0);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x2009bc4)
  public static int FUN_2009bc4(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x2009bcc)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x2009bd4)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x2009bdc)
  public static void FUN_2009bdc(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x2009be4)
  public static void FUN_2009be4(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e0} */
  @Method(0x2009bec)
  public static void FUN_2009bec(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0e0, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x2009bf4)
  public static void FUN_2009bf4(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x2009bfc)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x2009c04)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x2009c0c)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x2009c14)
  public static void FUN_2009c14(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2009c1c)
  public static void FUN_2009c1c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x2009c24)
  public static void FUN_2009c24(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x2009c2c)
  public static void FUN_2009c2c(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x2009c34)
  public static void FUN_2009c34(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x2009c3c)
  public static Panel24 FUN_2009c3c(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x2009c44)
  public static void FUN_2009c44(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x2009c4c)
  public static void FUN_2009c4c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x2009c54)
  public static int FUN_2009c54(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a190, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x2009c5c)
  public static void FUN_2009c5c(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x2009c64)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2009c6c)
  public static void FUN_2009c6c(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x2009c74)
  public static void FUN_2009c74(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x2009c7c)
  public static void FUN_2009c7c(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2009c84)
  public static void FUN_2009c84(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x2009c8c)
  public static void FUN_2009c8c() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x2009c94)
  public static void FUN_2009c94(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2f8} */
  @Method(0x2009c9c)
  public static void FUN_2009c9c() {
    MEMORY.call(0x808a2f8);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x2009ca4)
  public static void FUN_2009ca4() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x2009cac)
  public static void FUN_2009cac() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x2009cb4)
  public static void FUN_2009cb4() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a460} */
  @Method(0x2009cbc)
  public static void FUN_2009cbc() {
    MEMORY.call(0x808a460);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x2009cc4)
  public static void FUN_2009cc4(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x2009ccc)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }
}
