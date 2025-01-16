package org.goldensun.maps;

import org.goldensun.CopiedSegment8000770;
import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80b;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Panel24;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;

import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;

/** Sanctums */
public final class Map9Overlay_87892c8 {
  private Map9Overlay_87892c8() { }

  @Method(0x2008030)
  public static void FUN_2008030(final Actor70 r0) {
    final Actor70 r2 = getMapActor(r0._64.get());
    r0.angle_06.set(atan2(r2.pos_08.getZ() - r0.pos_08.getZ(), r2.pos_08.getX() - r0.pos_08.getX()));
  }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x200805c)
  public static int getRooms() {
    final int r0;

    r0 = 0x200baa8;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008064)
  public static int getLadders() {
    final int r0;

    r0 = 0x0;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008068)
  public static int getTransitions() {
    final int r0;

    r0 = 0x200bbc8;
    return r0;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x2008070)
  public static int getActors() {
    final int r0;
    int r2;
    int r3;

    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    r3 = r3 - 0x1;

    switch(r3) {
      case 0: // switch 200808c
      case 1: // switch 200808c
        //LAB_2008118
        r0 = 0x200bc0c;
        break;

      case 9: // switch 200808c
      case 10: // switch 200808c
      case 11: // switch 200808c
      case 34: // switch 200808c
        //LAB_200811c
        r0 = 0x200bccc;
        break;

      case 19: // switch 200808c
      case 20: // switch 200808c
        //LAB_2008120
        r0 = 0x200bd2c;
        break;

      case 28: // switch 200808c
      case 31: // switch 200808c
        //LAB_2008124
        r0 = 0x200be04;
        break;

      default:
        //LAB_2008128
        r0 = 0x200bbf4;
        break;
      }

    //LAB_200812a
    return r0;
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x200814c)
  public static int getEvents() {
    int r0;
    int r2;
    int r3;

    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    r3 = r3 - 0xa;

    switch(r3) {
      case 0: // switch 2008168
      case 2: // switch 2008168
        //LAB_200820c
        r0 = 0x200be70;
        break;

      case 1: // switch 2008168
        //LAB_2008210
        r0 = 0x200bec4;
        break;

      case 10: // switch 2008168
      case 11: // switch 2008168
      case 40: // switch 2008168
        //LAB_2008214
        r0 = 0x200bf0c;
        break;

      case 22: // switch 2008168
        //LAB_2008218
        r0 = 0x200c0ec;
        break;

      case 19: // switch 2008168
        //LAB_200821c
        r0 = 0x200c038;
        break;

      case 25: // switch 2008168
        //LAB_2008220
        r0 = 0x200c080;
        break;

      default:
        //LAB_2008224
        r0 = 0x87a;
        r0 = readFlag(r0);
        if(r0 != 0) {
          r0 = 0x200bfd8;
        } else {
          //LAB_2008232
          r0 = 0x815;
          r0 = readFlag(r0);
          if(r0 != 0) {
            r0 = 0x200bf78;
          } else {
            //LAB_2008240
            r0 = 0x200be34;
          }
        }
        break;
    }

    //LAB_2008242
    return r0;
  }

  /**
   * Event list 0x200bec4 handler 2
   */
  @Method(value = 0x200827c, ignoreExtraParams = true)
  public static void FUN_200827c() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200b5f0();
    r0 = 0x855;
    r0 = readFlag(r0);
    if(r0 != 0x0) {
      r0 = 0x1377;
      FUN_200b6a8(r0);
    } else {
      //LAB_2008294
      r0 = 0x1289;
      FUN_200b6a8(r0);
    }

    //LAB_200829a
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0xb) {
      r0 = 0x1ce9;
      FUN_200b6a8(r0);
    }

    //LAB_20082b0
    r0 = 0x9;
    r1 = 0x1;
    setActorAnimationIfLoaded(r0, r1);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x9;
    FUN_200b698(r0, r1, r2);
    r0 = 0x2;
    FUN_200b5e8(r0);
    r0 = 0x9;
    r1 = 0x0;
    FUN_200b6b8(r0, r1);
    FUN_200b5f8();
  }

  /**
   * Event list 0x200bec4 handler 4
   */
  @Method(value = 0x20082ec, ignoreExtraParams = true)
  public static void FUN_20082ec() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200b5f0();
    r0 = 0x855;
    r0 = readFlag(r0);
    if(r0 == 0x0) {
      r0 = 0x128b;
      FUN_200b6a8(r0);
    } else {
      //LAB_2008304
      r0 = 0x1379;
      FUN_200b6a8(r0);
    }

    //LAB_200830a
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 == 0xb) {
      r0 = 0x1ceb;
      FUN_200b6a8(r0);
    }

    //LAB_2008320
    r0 = 0x9;
    FUN_200b630(r0);
    r1 = 0x1;
    r0 = 0x9;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x2;
    FUN_200b5e8(r0);
    r0 = 0x9;
    r1 = 0x0;
    FUN_200b6b8(r0, r1);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200b620(r0, r1);
    FUN_200b5f8();
  }

  /**
   * Event list 0x200bf0c handler 0
   */
  @Method(value = 0x2008360, ignoreExtraParams = true)
  public static void FUN_2008360() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200b5f0();
    r0 = 0x1164;
    FUN_200b6a8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b0(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200b608(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x8;
      r1 = 0x3;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
    } else {
      //LAB_2008390
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b0(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200b608(r0, r1);
      if(r0 == 0x0) {
        //LAB_20083ac
        r0 = 0x14;
        FUN_200b5e8(r0);
        r1 = 0x0;
        r0 = 0x8;
        FUN_200b6b0(r0);
        r0 = 0x0;
        r1 = 0x0;
        r0 = FUN_200b608(r0, r1);
        if(r0 == 0x0) {
          //LAB_20083c8
          r0 = 0x14;
          FUN_200b5e8(r0);
          if((getMapActor(8).angle_06.get() & 0xffff) >= 0xa000 && (getMapActor(8).angle_06.get() & 0xffff) <= 0xe000) {
            r1 = 0x80;
            r2 = 0x80;
            r0 = 0x8;
            r1 = r1 << 8;
            r2 = r2 << 7;
            setActorVelocityScalerAndAcceleration(r0, r1, r2);
            r1 = 0x0;
            r2 = 0x0;
            r0 = 0x8;
            FUN_200b6c0(r0, r1, r2);
            r0 = 0xa;
            FUN_200b5e8(r0);
            getMapActor(8)._5a.and(~0x1);
            r1 = 0x98;
            r2 = 0x78;
            r0 = 0x8;
            FUN_200b648(r0, r1, r2);
            r0 = 0x1;
            FUN_200b5e8(r0);
            getMapActor(8)._5a.or(0x1);
            r0 = 0x14;
            FUN_200b5e8(r0);
            r1 = 0x3;
            r0 = 0x8;
            setActorAnimationAndWaitUntilFinished(r0, r1);
            r0 = 0x14;
            FUN_200b5e8(r0);
            r0 = 0x0;
            r1 = 0xa8;
            r2 = 0x78;
            FUN_200b648(r0, r1, r2);
            r1 = 0xc0;
            r2 = 0xa8;
            r0 = 0x0;
            FUN_200b640(r0, r1, r2);
            r0 = 0x14;
            FUN_200b5e8(r0);
            r0 = 0x8;
            r1 = 0xa8;
            r2 = 0x78;
            FUN_200b648(r0, r1, r2);
            r1 = 0xc0;
            r0 = 0x8;
            r1 = r1 << 6;
            r2 = 0x0;
            FUN_200b6c0(r0, r1, r2);
            r0 = 0x0;
            FUN_200b650(r0);
          } else {
            //LAB_2008488
            r1 = 0xc0;
            r2 = 0xa8;
            r0 = 0x0;
            FUN_200b640(r0, r1, r2);
            r0 = 0x14;
            FUN_200b5e8(r0);
            r1 = 0xc0;
            r0 = 0x8;
            r1 = r1 << 6;
            r2 = 0x0;
            FUN_200b6c0(r0, r1, r2);
            r0 = 0x0;
            FUN_200b650(r0);
          }

          //LAB_20084aa
          FUN_200987c();
          r1 = 0x0;
          r0 = 0x0;
          FUN_200b708(r0, r1);
          r0 = 0x78;
          FUN_200b710(r0);
          r0 = 0x78;
          FUN_200b5e8(r0);
          r0 = 0x56;
          playSound(r0);
          FUN_200b738();
          r0 = 0x9f;
          r0 = r0 << 4;
          setFlag(r0);
          r0 = 0x1e;
          FUN_200b700(r0);
        }
      }
    }

    //LAB_20084da
    FUN_200b5f8();
  }

  /**
   * Event list 0x200bfd8 handler 2
   */
  @Method(value = 0x20084e8, ignoreExtraParams = true)
  public static void FUN_20084e8() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;

    CPU.sp().value -= 0x1c;
    FUN_200b5f0();
    r0 = 0x200bc9c;
    FUN_200b600(r0);
    r0 = 0x1;
    sleep(r0);
    r0 = 0x1bfd;
    FUN_200b6a8(r0);
    r1 = 0x0;
    r0 = 0x9;
    FUN_200b6b0(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200b608(r0, r1);
    if(r0 == 0x0) {
      r0 = 0x9;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
    } else {
      //LAB_2008520
      r3 = 0x3001ebc;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0xec;
      r3 = r3 << 1;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = r3 + 0x1;
      MEMORY.ref(2, r2).setu(r3);
      r0 = 0x1;
      r3 = 0x3;
      r2 = 0x7;
      r1 = 0x10;
      r4 = 0xe;
      MEMORY.ref(4, CPU.sp().value).setu(r0);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
      r5 = 0x0;
      r0 = 0x2;
      r2 = 0x1;
      r3 = 0x18;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);
      FUN_200b6c8(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get());
      r0 = 0x9;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
    }

    //LAB_200855c
    FUN_200b5f8();
    CPU.sp().value += 0x1c;
  }

  /**
   * Event list 0x200bf78 handler 3
   */
  @Method(value = 0x2008574, ignoreExtraParams = true)
  public static void FUN_2008574() {
    int r0;
    int r1;
    int r2;
    int r3;

    FUN_200b5f0();
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x119f;
    FUN_200b6a8(r0);
    r1 = 0x0;
    r0 = 0xa;
    FUN_200b6b0(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200b608(r0, r1);
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

    //LAB_20085b4
    r0 = 0xa;
    r1 = 0x0;
    FUN_200b6b8(r0, r1);
    FUN_200b5f8();
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x20085cc)
  public static int init() {
    int r0;
    int r1;
    int r2;
    int r3;

    r3 = 0x3001ebc;
    r2 = 0xe0;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 << 1;
    r3 = r3 + r2;
    r0 = 0x80;
    r2 = r2 + 0x49;
    MEMORY.ref(4, r3).setu(r2);
    r1 = 0x0;
    r0 = r0 << 9;
    FUN_200b708(r0, r1);
    r0 = 0x1;
    FUN_200b710(r0);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r3 = 0x2000240;
    r2 = 0xe1;
    r2 = r2 << 1;
    r3 = r3 + r2;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r3 + r2).get();
    r3 = r3 - 0xa;

    switch(r3) {
      case 0: // switch 200860c
      case 1: // switch 200860c
      case 2: // switch 200860c
        //LAB_2008674
        r0 = 0x855;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r1 = 0xc8;
          r2 = 0xa0;
          r0 = 0xa;
          r1 = r1 << 16;
          r2 = r2 << 15;
          moveActorToPosition(r0, r1, r2);
        }
        clearFlag(0x12f);
        break;

      case 10: // switch 200860c
        //LAB_200868e
        FUN_200b270();
        r0 = 0x109;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_200888c();
        }
        clearFlag(0x12f);
        break;

      case 19: // switch 200860c
      case 22: // switch 200860c
      case 25: // switch 200860c
        //LAB_20086a0
        clearFlag(0x12f);
        break;

      case 11: // switch 200860c
        //LAB_20086a8
        FUN_200b270();
        r0 = 0x201;
        setFlag(r0);
        r0 = 0x109;
        r0 = readFlag(r0);
        if(r0 == 0x0) {
          FUN_200888c();
        }

        //LAB_20086c0
        r0 = 0x12f;
        clearFlag(r0);
        break;
    }

    //LAB_20086c6
    r0 = 0x0;
    return r0;
  }

  /**
   * Event list 0x200bf0c handler 7
   */
  @Method(value = 0x20086e8, ignoreExtraParams = true)
  public static void FUN_20086e8() {
    int r0;
    int r1;
    final int r2;

    FUN_200b5f0();
    r0 = 0x80;
    r1 = 0x80;
    r0 = r0 << 9;
    r1 = r1 << 6;
    FUN_200b6e0(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200b6f8(r0, r1);
    FUN_200b6f0();
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x116c;
    FUN_200b6a8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x80;
    r0 = r0 << 2;
    setFlag(r0);
    FUN_200b5f8();
  }

  /**
   * Event list 0x200bf0c handler 6
   */
  @Method(value = 0x200874c, ignoreExtraParams = true)
  public static void FUN_200874c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;

    FUN_200b5f0();
    r0 = 0x0;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xa;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x0;
    r0 = 0x10002;
    FUN_200b708(r0, r1);
    r0 = 0x78;
    FUN_200b710(r0);
    r0 = 0xb4;
    FUN_200b5e8(r0);
    r3 = 0x3001ed0;
    r0 = 0xe5a;
    r2 = MEMORY.ref(4, r3).get();
    r4 = 0xe5c;
    r1 = 0xf8;
    r3 = r2 + r0;
    r1 = r1 << 7;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r2 + r4;
    r4 = r4 + 0x2;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r2 + r4;
    MEMORY.ref(2, r3).setu(r1);
    r1 = 0xa8;
    r0 = 0x0;
    r1 = r1 << 6;
    r4 = 0x2a01;
    r3 = r2 + r1;
    MEMORY.ref(1, r3).setu(r0);
    r0 = 0x2a02;
    r3 = r2 + r4;
    r1 = 0x1;
    MEMORY.ref(1, r3).setu(r1);
    r3 = r2 + r0;
    MEMORY.ref(1, r3).setu(r1);
    r3 = 0x2a03;
    r2 = r2 + r3;
    MEMORY.ref(1, r2).setu(r1);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r0 = 0x116d;
    r1 = 0x1;
    FUN_200b5a0(r0, r1, r2);
    r1 = 0x0;
    r0 = 0x0;
    FUN_200b708(r0, r1);
    r0 = 0x78;
    FUN_200b710(r0);
    r0 = 0x78;
    FUN_200b5e8(r0);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = FUN_200a7d4();
    if(r0 == 0x0) {
      FUN_200b5f8();
      r0 = 0x14;
      FUN_200b700(r0);
    } else {
      //LAB_200883a
      FUN_200b5f8();
      r0 = 0x32;
      FUN_200b700(r0);
    }
  }

  @Method(0x2008848)
  public static int FUN_2008848(final Actor70 r0) {
    final Sprite38 r3 = getMapActor(0).sprite_50.deref();
    final Sprite38 r4 = r0.sprite_50.deref();
    r4.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    r4.shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r3.packet_00.attribs_04.attrib2_04.get() & 0xc00);
    return 0;
  }

  @Method(0x200888c)
  public static void FUN_200888c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    FUN_200b5f0();
    r0 = 0x201;
    r0 = readFlag(r0);
    if(r0 != 0) {
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b698(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xa;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc0;
      r1 = 0x1;
      r2 = 0xa0;
      r0 = r0 << 16;
      r1 = -r1;
      r2 = r2 << 16;
      r3 = 0x1;
      FUN_200b6e8(r0, r1, r2, r3);
      FUN_200b6f0();
      r3 = 0x3001ebc;
      r1 = MEMORY.ref(4, r3).get();
      r3 = 0xe0;
      r3 = r3 << 1;
      r2 = r1 + r3;
      r3 = r3 - 0xc0;
      MEMORY.ref(4, r2).setu(r3);
      r3 = r3 + 0xc8;
      r2 = r1 + r3;
      r3 = 0x40;
      MEMORY.ref(4, r2).setu(r3);
      FUN_200b718();
      FUN_200b720();
      r0 = 0x78;
      FUN_200b5e8(r0);
    } else {
      //LAB_2008916
      r1 = 0x0;
      r0 = 0x10002;
      FUN_200b708(r0, r1);
      r0 = 0x1;
      FUN_200b710(r0);
      r0 = 0x1;
      FUN_200b5e8(r0);
      r0 = 0xc0;
      r1 = 0x1;
      r2 = 0xa0;
      r0 = r0 << 16;
      r1 = -r1;
      r2 = r2 << 16;
      r3 = 0x1;
      FUN_200b6e8(r0, r1, r2, r3);
      FUN_200b6f0();
      r5 = 0x3001ebc;
      r2 = 0xe0;
      r3 = MEMORY.ref(4, r5).get();
      r2 = r2 << 1;
      r3 = r3 + r2;
      r2 = r2 + 0x49;
      MEMORY.ref(4, r3).setu(r2);
      FUN_200b718();
      FUN_200b720();
      FUN_200a90c();
      r0 = 0x80;
      r1 = 0x0;
      r0 = r0 << 9;
      FUN_200b708(r0, r1);
      r0 = 0x3c;
      FUN_200b710(r0);
      r0 = 0x64;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x1;
      r0 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0xc;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0xc;
      r0 = 0x1;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0x1;
      FUN_200b620(r0, r1);
      r0 = 0xc;
      r1 = 0x1;
      FUN_200b620(r0, r1);
      r0 = 0x0;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0x1;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0xb;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0xc;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0x9;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0xa;
      r1 = 0xcccc;
      r2 = 0x6666;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r2 = 0x6666;
      r1 = 0xcccc;
      r0 = 0x8;
      setActorVelocityScalerAndAcceleration(r0, r1, r2);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0xc;
      FUN_200b688(r0, r1);
      r0 = 0x1138;
      FUN_200b6a8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0x1;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0xc;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0xb;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r1 = 0xb;
      r2 = 0x0;
      r0 = 0x1;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b0(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200b608(r0, r1);
      if(r0 == 0) {
        r0 = 0x14;
        FUN_200b5e8(r0);
        r1 = 0x3;
        r0 = 0xb;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x14;
        FUN_200b5e8(r0);
        r0 = 0xb;
        r1 = 0x0;
        FUN_200b6b8(r0, r1);
        r2 = MEMORY.ref(4, r5).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
      } else {
        //LAB_2008aa4
        r0 = 0x14;
        FUN_200b5e8(r0);
        r1 = 0x4;
        r0 = 0xb;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x14;
        FUN_200b5e8(r0);
        r2 = MEMORY.ref(4, r5).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
        r0 = 0xb;
        r1 = 0x0;
        FUN_200b6b8(r0, r1);
      }

      //LAB_2008ace
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0x9;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x9;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x9;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r1 = 0x9;
      r2 = 0x0;
      r0 = 0xb;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x9;
      FUN_200b6b0(r0);
      r0 = 0x0;
      r1 = 0x0;
      r0 = FUN_200b608(r0, r1);
      if(r0 == 0) {
        r0 = 0x14;
        FUN_200b5e8(r0);
        r1 = 0x3;
        r0 = 0x9;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x14;
        FUN_200b5e8(r0);
        r0 = 0x9;
        r1 = 0x0;
        FUN_200b6b8(r0, r1);
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
      } else {
        //LAB_2008b60
        r0 = 0x14;
        FUN_200b5e8(r0);
        r1 = 0x4;
        r0 = 0x9;
        setActorAnimationAndWaitUntilFinished(r0, r1);
        r0 = 0x14;
        FUN_200b5e8(r0);
        r3 = 0x3001ebc;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0xec;
        r3 = r3 << 1;
        r2 = r2 + r3;
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(2, r2).setu(r3);
        r0 = 0x9;
        r1 = 0x0;
        FUN_200b6b8(r0, r1);
      }

      //LAB_2008b8c
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xb;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xc;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x9;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0xa;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x101;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x8;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x78;
      r1 = 0xe0;
      r0 = 0xc;
      FUN_200b648(r0, r1, r2);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xa;
      FUN_200b690(r0, r1, r2);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0x3;
      FUN_200b688(r0, r1);
      r1 = 0x80;
      r1 = r1 << 1;
      r2 = 0x0;
      r0 = 0x8;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0xc;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0xa0;
      r1 = r1 << 7;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b6c0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xc;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0xc;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0xc0;
      r2 = 0x0;
      r1 = r1 << 6;
      r0 = 0x8;
      FUN_200b6c0(r0, r1, r2);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0xa0;
      r1 = r1 << 7;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b6c0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x8;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b690(r0, r1, r2);
      r0 = 0x32;
      FUN_200b5e8(r0);
      r1 = 0x101;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x101;
      r0 = 0xa;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x80;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x80;
      r0 = 0x1;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x80;
      r0 = 0xb;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x80;
      r0 = 0xc;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x80;
      r0 = 0x9;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x80;
      r2 = 0x0;
      r1 = r1 << 1;
      r0 = 0xa;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0x1;
      FUN_200b688(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x1;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r2 = 0x0;
      r0 = 0xc;
      r1 = r1 << 1;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0x1;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0xb;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0x9;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r1 = 0x1;
      r0 = 0xa;
      FUN_200b688(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0xc;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0x0;
      FUN_200b688(r0, r1);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0xc;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xc;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0x2;
      FUN_200b688(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x80;
      r1 = r1 << 1;
      r0 = 0x8;
      r5 = 0x90;
      FUN_200b6a0(r0, r1);
      r5 = r5 << 5;
      FUN_200a5c4();
      r0 = 0xc4;
      playSound(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x20;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x10;
      FUN_200b5e8(r0);
      r5 = 0x0;

      //LAB_2008f44
      do {
        r1 = 0x90;
        r0 = 0x8;
        r1 = r1 << 5;
        FUN_200a750(r0, r1);
        r5 = r5 + 0x1;
        r0 = 0x8;
        FUN_200b5e8(r0);
      } while((r5 & 0xffff_ffffL) <= (0x5 & 0xffff_ffffL));

      r5 = 0x90;
      r5 = r5 << 5;
      r0 = 0x8;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x20;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x60;
      FUN_200b5e8(r0);
      r0 = 0x20;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6a0(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      FUN_200a660();
      r0 = 0x8;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x2;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0xc;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0x1;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0xb;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0x9;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r1 = r1 << 1;
      r0 = 0xa;
      FUN_200b6d8(r0, r1);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0xa;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xa;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x1;
      r0 = 0x0;
      FUN_200b698(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0x1;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x1;
      r0 = 0x0;
      FUN_200b698(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r2 = 0x0;
      r1 = 0xa;
      r0 = 0x9;
      FUN_200b698(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x9;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0xa;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xa;
      waitForActorAnimationToChange(r0);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0xb;
      r2 = 0x0;
      FUN_200b698(r0, r1, r2);
      r2 = 0x0;
      r1 = 0xc;
      r0 = 0x1;
      FUN_200b698(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xb;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0xc;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xc;
      waitForActorAnimationToChange(r0);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0x2;
      FUN_200b688(r0, r1);
      r0 = 0x8;
      r1 = 0x0;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x80;
      r1 = r1 << 1;
      r0 = 0x8;
      FUN_200b6a0(r0, r1);
      FUN_200a5c4();
      r0 = 0xc4;
      playSound(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x20;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xa;
      FUN_200b690(r0, r1, r2);
      r0 = 0x10;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0x1;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0xb;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0xc;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0x9;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0xa;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r5 = 0x0;

      //LAB_20091a0
      do {
        r1 = 0x90;
        r0 = 0x8;
        r1 = r1 << 5;
        FUN_200a750(r0, r1);
        r5 = r5 + 0x1;
        r0 = 0x8;
        FUN_200b5e8(r0);
      } while((r5 & 0xffff_ffffL) <= (0x5 & 0xffff_ffffL));

      r5 = 0x90;
      r0 = 0x8;
      r5 = r5 << 5;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x20;
      FUN_200b5e8(r0);
      r1 = r5;
      r0 = 0x8;
      FUN_200a750(r0, r1);
      r0 = 0x80;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6a0(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      FUN_200a660();
      r0 = 0x8;
      r1 = 0x1;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x2;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x105;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0xa;
      r2 = 0x0;
      r0 = 0x9;
      FUN_200b698(r0, r1, r2);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r0 = 0x9;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r0 = 0xa;
      r1 = 0x8;
      FUN_200b690(r0, r1, r2);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x2;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0x1;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r2 = 0x0;
      r0 = 0x0;
      r1 = 0x1;
      FUN_200b698(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r0 = 0xa;
      r1 = 0x1;
      FUN_200b680(r0, r1);
      r2 = 0x0;
      r0 = 0x9;
      r1 = 0xa;
      FUN_200b698(r0, r1, r2);
      r1 = 0x81;
      r1 = r1 << 1;
      r0 = 0xc;
      FUN_200b6d8(r0, r1);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xa;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x1;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x101;
      r0 = 0xa;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x1;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xb;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xc;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0x9;
      r1 = 0x3;
      setActorAnimationIfLoaded(r0, r1);
      r1 = 0x3;
      r0 = 0xa;
      setActorAnimationIfLoaded(r0, r1);
      r0 = 0xa;
      waitForActorAnimationToChange(r0);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0xc;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0xc;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x32;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x1;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r0 = 0xb;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r0 = 0xc;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x9;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r2 = 0x0;
      r1 = r1 << 1;
      r0 = 0xa;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x50;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x101;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x101;
      r0 = 0xa;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x50;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0x1;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0xb;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0xc;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r0 = 0x9;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r1 = 0x81;
      r1 = r1 << 1;
      r0 = 0xa;
      FUN_200b6d8(r0, r1);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0xc;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x1;
      r2 = 0x0;
      FUN_200b698(r0, r1, r2);
      r0 = 0x9;
      r1 = 0xa;
      r2 = 0x0;
      FUN_200b698(r0, r1, r2);
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0xc;
      FUN_200b690(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xb;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x9;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x8;
      r0 = 0xa;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0xb;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0xc8;
      r2 = 0x88;
      FUN_200b648(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x0;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r2 = 0x0;
      r1 = 0x1;
      r0 = 0x8;
      FUN_200b698(r0, r1, r2);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x32;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x28;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x32;
      FUN_200b5e8(r0);
      r1 = 0x1;
      r0 = 0x8;
      FUN_200b688(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r2 = 0x0;
      r1 = r1 << 1;
      r0 = 0x1;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0xb;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r0 = 0xb;
      r1 = 0x1;
      FUN_200b688(r0, r1);
      r1 = 0x0;
      r0 = 0xb;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r2 = 0x0;
      r0 = 0xc;
      r1 = r1 << 1;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x1;
      r0 = 0xc;
      FUN_200b680(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0x8;
      r1 = 0xa8;
      r2 = 0x78;
      FUN_200b648(r0, r1, r2);
      r0 = 0x0;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0x1;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r0 = 0xc;
      r1 = 0x8;
      r2 = 0x0;
      FUN_200b690(r0, r1, r2);
      r1 = 0xd0;
      r2 = 0x0;
      r1 = r1 << 8;
      r0 = 0x8;
      FUN_200b6c0(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x4;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r1 = 0x81;
      r0 = 0x0;
      r1 = r1 << 1;
      r2 = 0x0;
      FUN_200b6d0(r0, r1, r2);
      r1 = 0x81;
      r2 = 0x0;
      r1 = r1 << 1;
      r0 = 0x1;
      FUN_200b6d0(r0, r1, r2);
      r0 = 0x3c;
      FUN_200b5e8(r0);
      r1 = 0x3;
      r0 = 0x8;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0xa;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0x8;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r2 = 0x0;
      r0 = 0xc;
      r1 = 0x0;
      FUN_200b690(r0, r1, r2);
      r1 = 0x81;
      r0 = 0x1;
      r1 = r1 << 1;
      FUN_200b6d8(r0, r1);
      r0 = 0x1;
      r1 = 0x2;
      FUN_200b688(r0, r1);
      r1 = 0x0;
      r2 = 0x0;
      r0 = 0x1;
      FUN_200b690(r0, r1, r2);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r0 = 0x1;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      r0 = 0x1e;
      FUN_200b5e8(r0);
    }

    //LAB_20097ca
    r0 = 0x1162;
    FUN_200b6a8(r0);
    r1 = 0x1;
    r0 = 0x8;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b0(r0);
    r0 = 0x0;
    r1 = 0x0;
    r0 = FUN_200b608(r0, r1);
    if(r0 == 0) {
      FUN_200987c();
      r1 = 0x0;
      r0 = 0x0;
      FUN_200b708(r0, r1);
      r0 = 0x78;
      FUN_200b710(r0);
      r0 = 0x78;
      FUN_200b5e8(r0);
      r0 = 0x56;
      playSound(r0);
      FUN_200b738();
      r0 = 0x9f;
      r0 = r0 << 4;
      setFlag(r0);
      r0 = 0x1e;
      FUN_200b700(r0);
    } else {
      //LAB_2009824
      r0 = 0x1e;
      FUN_200b5e8(r0);
      r0 = 0xc;
      r1 = 0x1;
      FUN_200b688(r0, r1);
      r1 = 0x4;
      r0 = 0xc;
      setActorAnimationAndWaitUntilFinished(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      r1 = 0x0;
      r0 = 0xc;
      FUN_200b6b8(r0, r1);
      r0 = 0x14;
      FUN_200b5e8(r0);
      getMapActor(10).flags_23.and(~0x1);
      getMapActor(10)._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_2008848", Actor70.class));
    }

    //LAB_2009868
    FUN_200b5f8();
  }

  @Method(0x200987c)
  public static void FUN_200987c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    FUN_200b6d8(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xb;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xc;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x9;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xa;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x8;
    r1 = 0xcccc;
    r2 = 0x6666;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0xc0;
    r1 = 0x1;
    r2 = 0xa0;
    r3 = 0x1;
    r0 = r0 << 16;
    r1 = -r1;
    r2 = r2 << 16;
    FUN_200b6e8(r0, r1, r2, r3);
    FUN_200b6f0();
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0x0;
    FUN_200b698(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x32;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x8;
    r0 = 0xa;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x1171;
    FUN_200b6a8(r0);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r0 = 0xc;
    r1 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r2 = 0x0;
    r1 = 0x103;
    r0 = 0xc;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r0 = 0x1;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x8;
    r0 = 0xc;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0xd0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x8;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x50;
    FUN_200b5e8(r0);
    r0 = 0x11;
    playSound(r0);
    r1 = 0x1;
    r0 = 0x10005;
    FUN_200b708(r0, r1);
    r0 = 0x3c;
    FUN_200b710(r0);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r0 = 0x6666;
    r1 = 0xccc;
    FUN_200b6e0(r0, r1);
    r0 = 0xc0;
    r1 = 0x1;
    r2 = 0xd0;
    r3 = 0x1;
    r1 = -r1;
    r2 = r2 << 15;
    r0 = r0 << 16;
    FUN_200b6e8(r0, r1, r2, r3);
    r0 = 0x78;
    FUN_200b5e8(r0);
    r0 = 0x15;
    playSound(r0);
    r0 = 0x9a;
    r0 = r0 << 1;
    playSound(r0);
    r1 = 0xc8;
    r2 = 0x80;
    r0 = 0xd;
    r1 = r1 << 16;
    r2 = r2 << 12;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xd;
    r1 = 0x6666;
    r2 = 0x3333;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r2 = 0x48;
    r1 = 0xc8;
    r0 = 0xd;
    FUN_200b638(r0, r1, r2);
    r0 = 0x90;
    r0 = r0 << 1;
    playSound(r0);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0x2;
    FUN_200b688(r0, r1);
    r0 = 0x8;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    FUN_200a5c4();
    r0 = 0x0;
    r1 = 0xd;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xd;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0xd;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0xd;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0xd;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r0 = 0xa;
    r1 = 0xd;
    FUN_200b690(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r0 = 0xb;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r0 = 0xc;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r0 = 0x9;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r1 = 0x2;
    r0 = 0xa;
    FUN_200b680(r0, r1);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xd;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xd;
    FUN_200b6b8(r0, r1);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x80;
    r1 = r1 << 1;
    r0 = 0xd;
    FUN_200b6a0(r0, r1);
    r0 = 0x11;
    playSound(r0);
    r0 = 0x9a;
    r0 = r0 << 1;
    playSound(r0);
    r6 = 0xfffffd71;
    r5 = 0x0;

    //LAB_2009bd0
    do {
      r0 = 0xd;
      FUN_200b1b8(r0);
      r0 = 0x4;
      FUN_200b5e8(r0);
      getMapActor(13).scale_18.add(r6);
      getMapActor(13)._1c.add(r6);
      r5 = r5 + 0x1;
    } while((r5 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL));

    r0 = 0x90;
    r0 = r0 << 1;
    playSound(r0);
    r0 = 0xd;
    r1 = 0x0;
    FUN_200b6a0(r0, r1);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0xd;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r0 = 0xc0;
    r1 = 0x1;
    r2 = 0xa0;
    r3 = 0x1;
    r2 = r2 << 16;
    r0 = r0 << 16;
    r1 = -r1;
    FUN_200b6e8(r0, r1, r2, r3);
    FUN_200b6f0();
    r0 = 0x80;
    r1 = 0x0;
    r0 = r0 << 9;
    FUN_200b708(r0, r1);
    r0 = 0x3c;
    FUN_200b710(r0);
    r0 = 0x78;
    FUN_200b5e8(r0);
    FUN_200a660();
    r1 = 0x1;
    r0 = 0x8;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x2;
    playSound(r0);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x8;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xc;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r1 = 0x1;
    r0 = 0xa;
    FUN_200b688(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x8;
    r2 = 0x0;
    r0 = 0xc;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x8;
    r0 = 0xa;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xb4;
    FUN_200b5e8(r0);
    r1 = 0x105;
    r2 = 0x0;
    r0 = 0xc;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x1;
    r2 = 0x0;
    FUN_200b698(r0, r1, r2);
    r1 = 0xa;
    r2 = 0x0;
    r0 = 0x9;
    FUN_200b698(r0, r1, r2);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x8;
    r0 = 0xa;
    FUN_200b690(r0, r1, r2);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x101;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xc;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r1 = 0x1;
    r0 = 0xa;
    FUN_200b688(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x101;
    r2 = 0x0;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x50;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0xc;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x105;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0x1;
    FUN_200b688(r0, r1);
    r1 = 0x83;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x1;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xb;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0xc;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r0 = 0x9;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r1 = 0x1;
    r0 = 0xa;
    FUN_200b688(r0, r1);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x78;
    FUN_200b5e8(r0);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x105;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x105;
    r0 = 0xa;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0xc;
    r1 = 0x1;
    FUN_200b688(r0, r1);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0x8;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = 0x0;
    r0 = 0x8;
    FUN_200b6b8(r0, r1);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0xa8;
    r2 = 0xb0;
    FUN_200b648(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x8;
    r1 = 0xc8;
    r2 = 0xc8;
    FUN_200b648(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0x9;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0x80;
    r0 = 0xa;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r2 = 0x88;
    r1 = 0xc8;
    r2 = r2 << 1;
    r0 = 0x8;
    FUN_200b640(r0, r1, r2);
    r0 = 0x28;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r0 = 0xb;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xa0;
    r0 = 0x9;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x8;
    FUN_200b650(r0);
    r1 = 0x0;
    r2 = 0x0;
    r0 = 0x8;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x1;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0xb;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0xc;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r0 = 0x9;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x78;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x9;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x9;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r1 = 0x9;
    r2 = 0x0;
    r0 = 0xc;
    FUN_200b690(r0, r1, r2);
    r0 = 0x78;
    FUN_200b5e8(r0);
    r1 = 0x105;
    r2 = 0x0;
    r0 = 0x9;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x9;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x9;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x9;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x50;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r0 = 0x9;
    r1 = 0xa;
    FUN_200b690(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x9;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0x9;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0xa;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x101;
    r0 = 0xa;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x9;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0xa;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0xa;
    FUN_200b688(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r2 = 0x0;
    r1 = r1 << 7;
    r0 = 0xa;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xa;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x88;
    r0 = 0x9;
    r1 = 0xc8;
    r2 = r2 << 1;
    FUN_200b640(r0, r1, r2);
    r2 = 0x88;
    r0 = 0xa;
    r1 = 0xc8;
    r2 = r2 << 1;
    FUN_200b648(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r1 = 0x105;
    r2 = 0x0;
    r0 = 0xc;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0xc;
    r1 = 0xc8;
    r2 = 0x88;
    FUN_200b648(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xc;
    r2 = 0x0;
    FUN_200b698(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xc;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0xb;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0xb;
    r1 = 0xa8;
    r2 = 0xa8;
    FUN_200b648(r0, r1, r2);
    r1 = 0xc;
    r2 = 0x0;
    r0 = 0xb;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xb;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x4;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xc;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0xb;
    FUN_200b688(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0xc;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xc;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r1 = 0x80;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x80;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x1;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x0;
    r0 = 0xb;
    FUN_200b6b8(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0x0;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
  }

  @Method(0x200a5c4)
  public static void FUN_200a5c4() {
    final Actor70 r0 = getMapActor(8);
    if(r0 != null) {
      moveActorToPosition(14, r0.pos_08.getX(), r0.pos_08.getZ());
    }

    //LAB_200a5da
    setActorAnimationIfLoaded(14, 0);
    final Actor70 r5 = getMapActor(14);
    r5.angle_06.set(getMapActor(8).angle_06.get() & 0xffff);
    getMapActor(14)._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_200a67c", Actor70.class));
    final Sprite38 sprite = getMapActor(14).sprite_50.deref();

    //LAB_200a61a
    for(int layerIndex = 0; layerIndex < sprite.layerCount_27.get(); layerIndex++) {
      final SpriteLayer18 layer = sprite.layers_28.get(layerIndex).derefNullable();
      if(layer != null && layer.dataPtr_10.get() != 0) {
        layer._05.set(10);
      }

      //LAB_200a628
    }

    //LAB_200a62e
    sprite._25.set(1);
    getMapActor(14).flags_23.and(~0x1);
    sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x800);
  }

  @Method(0x200a660)
  public static void FUN_200a660() {
    final int r0;
    final int r1;
    final int r2;

    getMapActor(14)._6c.clear();
    r1 = 0x0;
    r0 = 0xe;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
  }

  @Method(0x200a67c)
  public static void FUN_200a67c(final Actor70 r0) {
    final Actor70 actor = getMapActor(8);
    r0.pos_08.set(actor.pos_08.getX(), actor.pos_08.getY(), actor.pos_08.getZ() - 0x20000);

    final int r2 = _3001e40.get() & 0x3;
    if(r2 == 1) {
      //LAB_200a6bc
      r0.pos_08.setX(actor.pos_08.getX() + 0x30000);
    } else if(r2 == 2) {
      //LAB_200a6ca
      r0.pos_08.setY(actor.pos_08.getY() + 0x20000);
    } else if(r2 == 3) {
      //LAB_200a6d8
      r0.pos_08.setZ(actor.pos_08.getZ());
    } else {
      //LAB_200a6b6
      r0.pos_08.setX(actor.pos_08.getX() - 0x38000);
    }

    //LAB_200a6de
    r0.dest_38.set(actor.pos_08);
  }

  @Method(0x200a6f0)
  public static void FUN_200a6f0(final Actor70 r0) {
    final int r6 = r0._64.get();
    final Actor70 r1 = r0.parent_68.deref();
    r0.pos_08.setX(r1.pos_08.getX() + cos(r6) * 14);
    r0.pos_08.setZ(r1.pos_08.getZ() + sin(r6) * 10);
    r0.dest_38.setX(r0.pos_08.getX());
    r0.dest_38.setZ(r0.pos_08.getZ());
    r0._64.add(r0._66.get());
  }

  @Method(0x200a750)
  public static void FUN_200a750(final int r0, final int r1) {
    final Actor70 r7 = getMapActor(r0);
    if(r7 != null) {
      final Actor70 r6 = loadActor(0x11d, r7.pos_08.getX(), r7.pos_08.getY() + 0x2d0000, r7.pos_08.getZ());
      if(r6 != null) {
        final Sprite38 r5 = r6.sprite_50.deref();
        setActorSpriteScript(r6, 0x200c15c);
        r6._55.set(0);
        r6._64.set(0);
        r6._66.set(r1);
        r6._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_200a6f0", Actor70.class));
        r5._26.set(0);
        r5.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r7.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
        r6.parent_68.set(r7);
      }
    }

    //LAB_200a7c8
  }

  @Method(0x200a7d4)
  public static int FUN_200a7d4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.push(CPU.r8().value);
    r0 = 0x8;
    r1 = 0x0;
    r2 = 0x0;
    CPU.sp().value -= 0x14;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x9;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xa;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xb;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0xc;
    r1 = 0x0;
    r2 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r2 = 0x0;
    r0 = 0x0;
    r1 = 0x0;
    moveActorToPosition(r0, r1, r2);
    r0 = 0x80;
    r1 = 0x2;
    r0 = r0 << 9;
    FUN_200b708(r0, r1);
    r0 = 0x1;
    FUN_200b710(r0);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r3 = 0x1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r1 = 0x7;
    r2 = 0x19;
    r3 = 0x5;
    final Panel24 r7 = addPanel(2, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r5 = 0x116e;
    r0 = r5;
    r2 = 0x10;
    r3 = 0x0;
    FUN_200b598(r0, r7, r2, r3);
    r0 = 0x1;
    r0 = FUN_200b5c8(r0);
    if(r0 == 0x0) {
      r0 = r5 + 0x2;
      r2 = 0x10;
      r3 = 0x10;
      FUN_200b598(r0, r7, r2, r3);
    } else {
      //LAB_200a870
      r0 = r5 + 0x1;
      r2 = 0x10;
      r3 = 0x10;
      FUN_200b598(r0, r7, r2, r3);
    }

    //LAB_200a87c
    r1 = CPU.sp().value + 0x4;
    r0 = CPU.sp().value + 0x8;
    FUN_200b5a8(r0, r1);
    r2 = 0x3c;
    r0 = CPU.sp().value + 0x8;
    r1 = 0x48;
    queueRenderPacketXy(MEMORY.ref(4, r0, RenderPacket0c::new), r1, r2);
    r3 = 0x3001c94;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x1;
    r3 = r3 & r2;
    r5 = 0x0;
    if(r3 == 0x0) {
      r2 = 0x200c11c;
      r6 = 0x1;
      CPU.r8().value = r2;

      //LAB_200a8a2
      do {
        r3 = 0x3001b04;
        r3 = MEMORY.ref(4, r3).get();
        r2 = 0xc0;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          r5 = r5 ^ r6;
        }

        //LAB_200a8b0
        r3 = 0x3001800;
        r3 = MEMORY.ref(4, r3).get();
        r2 = 0xf;
        r3 = r3 >>> 1;
        r3 = r3 & r2;
        r3 = r3 << 2;
        r2 = CPU.r8().value;
        r1 = MEMORY.ref(4, r2 + r3).get();
        r2 = r5 << 4;
        r0 = CPU.sp().value + 0x8;
        r1 = r1 + 0x18;
        r2 = r2 + 0x3c;
        queueRenderPacketXy(MEMORY.ref(4, r0, RenderPacket0c::new), r1, r2);
        r0 = 0x1;
        FUN_200b5e8(r0);
        r3 = 0x3001c94;
        r3 = MEMORY.ref(4, r3).get();
        r3 = r3 & r6;
      } while(r3 == 0x0);
    }

    //LAB_200a8dc
    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    clearVramSlot2(r0);
    r1 = 0x1;
    FUN_200b590(r7, r1);
    r0 = r5;
    CPU.sp().value += 0x14;
    r3 = CPU.pop();
    CPU.r8().value = r3;
    return r0;
  }

  @Method(0x200a90c)
  public static void FUN_200a90c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r1 = 0xc0;
    r2 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0xc0;
    r2 = r2 << 8;
    r0 = 0x1;
    r1 = r1 << 9;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0x2;
    r0 = 0xc;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r0 = 0x0;
    r1 = 0x1;
    FUN_200b690(r0, r1, r2);
    r1 = 0x1;
    r0 = 0x0;
    FUN_200b680(r0, r1);
    getMapActor(0)._5a.and(~0x1);
    r1 = 0xb8;
    r2 = 0xa8;
    r0 = 0x0;
    FUN_200b640(r0, r1, r2);
    r2 = 0xa8;
    r1 = 0xc8;
    getMapActor(1)._5a.and(~0x1);
    r0 = 0x1;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    FUN_200b5e8(r0);
    getMapActor(1)._5a.or(0x1);
    r0 = 0x0;
    FUN_200b650(r0);
    r1 = 0x1;
    r0 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    getMapActor(0)._5a.or(0x1);
    getMapActor(1)._5a.or(0x1);
    r1 = 0x2;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b678(r0, r1, r2);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r1 = 0x8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x5;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x2;
    r0 = 0x1;
    FUN_200b678(r0, r1, r2);
    r0 = 0x19;
    FUN_200b5e8(r0);
    r0 = 0x1;
    r1 = 0x2;
    FUN_200b688(r0, r1);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x5;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x5;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0xc;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x8;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x9;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xa;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xc;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xb;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xb8;
    r2 = 0xd8;
    r3 = 0xa8;
    r3 = r3 << 16;
    r1 = r1 << 16;
    r2 = r2 << 13;
    r0 = 0xde;
    FUN_200b098(r0, r1, r2, r3);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200b678(r0, r1, r2);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r1 = 0xb0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xb0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r0 = 0x1;
    r1 = 0x4;
    r2 = 0x0;
    FUN_200b678(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 6;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r1 = r1 << 6;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r1 = r1 << 6;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 8;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xc0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x81;
    r0 = 0x0;
    r1 = r1 << 1;
    r2 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r6 = 0x1;
    getMapActor(8)._64.set(r6);
    getMapActor(8)._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_2008030", Actor70.class));
    getMapActor(12)._64.set(r6);
    r1 = 0xc4;
    getMapActor(12)._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_2008030", Actor70.class));
    r2 = 0xb4;
    r0 = 0x1;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xb8;
    r2 = 0xb8;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xb4;
    r2 = 0xb4;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xa8;
    r2 = 0xa8;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xb4;
    r2 = 0x9c;
    FUN_200b648(r0, r1, r2);
    r0 = 0x1;
    r1 = 0xc8;
    r2 = 0x68;
    FUN_200b640(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xc0;
    r2 = 0xa8;
    FUN_200b648(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x1;
    FUN_200b650(r0);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r1 = r1 << 7;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xf;
    FUN_200b5e8(r0);
    getMapActor(12)._6c.clear();
    getMapActor(8)._6c.clear();
    r1 = 0x2;
    r0 = 0x8;
    FUN_200b680(r0, r1);
    r1 = 0x80;
    r2 = 0x0;
    r1 = r1 << 1;
    r0 = 0x8;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x8;
    r1 = 0x0;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x81;
    r1 = r1 << 1;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200b6d0(r0, r1, r2);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xb;
    r0 = 0x0;
    FUN_200b698(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xb;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r2 = 0x0;
    r1 = r1 << 8;
    r0 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r0 = 0x0;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200b678(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r1 = 0x2;
    r2 = 0x0;
    r0 = 0x0;
    FUN_200b678(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0xf;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x0;
    FUN_200b698(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x0;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x3c;
    FUN_200b5e8(r0);
    r0 = 0x1;
    r1 = 0xd0;
    r2 = 0xa8;
    FUN_200b648(r0, r1, r2);
    r0 = 0x0;
    r1 = 0xb;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x4;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x4;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x1;
    FUN_200b680(r0, r1);
    r1 = 0x1;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x2;
    FUN_200b680(r0, r1);
    r1 = 0x2;
    r0 = 0x1;
    FUN_200b688(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0x200b740;
    r0 = 0x0;
    FUN_200b620(r0, r1);
    r1 = 0x200b81c;
    r0 = 0x1;
    FUN_200b620(r0, r1);
    r0 = 0x0;
    FUN_200b628(r0);
    r0 = 0x1;
    FUN_200b628(r0);
    r1 = 0xc0;
    r2 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r1 = 0xc0;
    r2 = 0xc0;
    r0 = 0x1;
    r1 = r1 << 9;
    r2 = r2 << 8;
    setActorVelocityScalerAndAcceleration(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200b678(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x6;
    r2 = 0x0;
    FUN_200b678(r0, r1, r2);
    r0 = 0x0;
    r1 = 0x9;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r1 = 0x8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xc;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r1 = 0xb;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x8;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r1 = 0x9;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x1;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xc0;
    r2 = 0xa8;
    FUN_200b640(r0, r1, r2);
    r1 = 0xd0;
    r2 = 0xa8;
    r0 = 0x1;
    FUN_200b648(r0, r1, r2);
    r0 = 0x0;
    FUN_200b650(r0);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xb0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xc0;
    r0 = 0x0;
    r1 = r1 << 6;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xd0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r1 = 0xa0;
    r0 = 0x0;
    r1 = r1 << 7;
    r2 = 0x0;
    FUN_200b6c0(r0, r1, r2);
    r1 = 0xb0;
    r1 = r1 << 8;
    r2 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0xb;
    r2 = 0x0;
    FUN_200b690(r0, r1, r2);
    r2 = 0x0;
    r1 = 0xc;
    r0 = 0x1;
    FUN_200b690(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0xb;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0xc;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0x1e;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x1;
    r0 = 0x0;
    FUN_200b698(r0, r1, r2);
    r0 = 0x14;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x3;
    setActorAnimationIfLoaded(r0, r1);
    r1 = 0x3;
    r0 = 0x1;
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r2 = 0x0;
    r1 = 0x0;
    r0 = 0x1;
    FUN_200b6c0(r0, r1, r2);
    r0 = 0xa;
    FUN_200b5e8(r0);
    r0 = 0x0;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x1;
    r1 = 0x2;
    setActorAnimationIfLoaded(r0, r1);
    r0 = 0x3c;
    FUN_200b5e8(r0);
  }

  @Method(0x200b098)
  public static void FUN_200b098(int r0, int r1, int r2, int r3) {
    int r5;
    int r8;

    r8 = r0;
    final Actor70 r7 = loadActor(22, r1, r2, r3);
    if(r7 != null) {
      r1 = 0x200b8f8;
      setActorSpriteScript(r7, r1);
      final Sprite38 r6 = r7.sprite_50.deref();
      r6._26.set(0);
      r6.layerCount_27.set(0);
      r6.packet_00.attribs_04.flags_01.and(~0x20);
      r6.packet_00.attribs_04.attrib2_04.and(0xfff);
      r3 = 0x80;
      r3 = r3 << 10;
      r7.velocity_24.setY(r3);
      r3 = 0x80;
      r3 = r3 << 7;
      r1 = 0xc1;
      r7._48.set(r3);
      r1 = r1 << 3;
      r0 = 0x11;
      r0 = mallocSlotChip(r0, r1);
      r5 = r0;
      r0 = r8;
      FUN_200b5c0(r0);
      r2 = 0x80;
      r2 = r2 << 3;
      r5 = r5 + r2;
      r2 = r5;
      r0 = r6.slot_1c.get();
      r1 = 0x80;
      allocateSpriteSlot(r0, r1, r2);
      r0 = 0x11;
      freeSlot(r0);
      r5 = 0x0;
      r8 = r5;

      //LAB_200b10e
      do {
        r3 = r7.velocity_24.getY();
        r2 = 0xff;
        r3 = r3 + 0xff;
        r2 = r2 << 1;
        if((r3 & 0xffff_ffffL) <= (r2 & 0xffff_ffffL)) {
          r3 = r8;
          r7._55.set(r3);
        }

        //LAB_200b11e
        r0 = 0x1;
        r5 = r5 + 0x1;
        sleep(r0);
      } while((r5 & 0xffff_ffffL) <= (0x3b & 0xffff_ffffL));

      r1 = 0x200ba9c;
      setActorSpriteScript(r7, r1);
    }

    //LAB_200b132
  }

  @Method(0x200b144)
  public static void FUN_200b144(final Actor70 r0) {
    r0.pos_08.y_04.add(r0._64.get() << 12);
    r0.dest_38.setY(r0.pos_08.getY());
    final int r2 = (r0._66.get() >> 2) & 0x3;

    final int r4;
    if(r2 == 0) {
      //LAB_200b184
      r4 = 0x10000;
    } else if(r2 == 1) {
      //LAB_200b18a
      r4 = 0xcccc;
    } else if(r2 == 2) {
      //LAB_200b18e
      r4 = 0x9999;
    } else if(r2 == 3) {
      //LAB_200b18a
      r4 = 0xcccc;
    } else {
      r4 = 0;
    }

    //LAB_200b190
    r0.scale_18.set(r4);
    r0._1c.set(r4);
    r0._66.decr();

    if(r0._66.get() <= 0) {
      setActorSpriteScript(r0, 0x200c18c);
    }
  }

  @Method(0x200b1b8)
  public static void FUN_200b1b8(final int r0) {
    final Actor70 r6 = getMapActor(r0);
    if(r6 != null) {
      final Actor70 r7 = loadActor(0x11e, r6.pos_08.getX() + (FUN_200b520(rand(), 20) << 16) - 0xa0000, r6.pos_08.getY() + ((rand() & 0xf) << 16) - 0x80000, r6.pos_08.getZ());
      if(r7 != null) {
        final Sprite38 r5 = r7.sprite_50.deref();
        r7._55.set(0);
        r7._64.set(FUN_200b520(rand(), 10) + 5);
        r7._66.set(FUN_200b520(rand(), 60) + 30);
        r7._6c.set(getConsumer(Map9Overlay_87892c8.class, "FUN_200b144", Actor70.class));
        r5._26.set(0);
        r5.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r6.sprite_50.deref().packet_00.attribs_04.attrib2_04.get() & 0xc00);
      }
    }

    //LAB_200b264
  }

  @Method(0x200b270)
  public static void FUN_200b270() {
    int r0;
    int r1;
    int r2;
    int r3;

    CPU.sp().value -= 0x8;
    r3 = 0x3;
    r2 = 0x2;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r0 = 0x0;
    r1 = 0x40;
    r2 = 0xb;
    r3 = 0x44;
    FUN_200b578(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r3 = 0xb;
    r2 = 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r1 = 0xa;
    r2 = 0x3;
    r3 = 0x2;
    r0 = 0xb;
    FUN_200b580(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r0 = 0x1;
    sleep(r0);
    CPU.sp().value += 0x8;
  }

  @Method(0x200b2a8)
  public static int FUN_200b2a8() {
    int r0;
    int r2;
    int r3;

    r2 = 0x5fff;
    r3 = getMapActor(0).angle_06.get() & 0xffff;
    r3 = r3 + r2;
    r2 = 0x3ffe0000;
    r3 = r3 << 16;
    r0 = 0x1;
    if((r3 & 0xffff_ffffL) > (r2 & 0xffff_ffffL)) {
      r0 = 0x0;
    }

    return r0;
  }

  /**
   * Event list 0x200bf78 handler 1
   */
  @Method(value = 0x200b2d0, ignoreExtraParams = true)
  public static void FUN_200b2d0() {
    int r0;
    final int r1;

    r0 = FUN_200b2a8();
    if(r0 != 0x0) {
      r0 = 0x8;
      r0 = FUN_200b728(r0);
    } else {
      //LAB_200b2e2
      FUN_200b5f0();
      r0 = 0x87a;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x1bfc;
        FUN_200b6a8(r0);
      } else {
        //LAB_200b2f8
        r0 = 0x815;
        r0 = readFlag(r0);
        if(r0 != 0x0) {
          r0 = 0x119d;
          FUN_200b6a8(r0);
        } else {
          //LAB_200b30a
          r0 = 0x1035;
          FUN_200b6a8(r0);
        }
      }

      //LAB_200b310
      r0 = 0x8;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      FUN_200b5f8();
    }
  }

  /**
   * Event list 0x200bec4 handler 1
   */
  @Method(value = 0x200b334, ignoreExtraParams = true)
  public static void FUN_200b334() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r0 = FUN_200b2a8();
    if(r0 != 0x0) {
      r0 = 0x8;
      r0 = FUN_200b728(r0);
    } else {
      //LAB_200b346
      FUN_200b5f0();
      r3 = 0x2000240;
      r2 = 0xe1;
      r2 = r2 << 1;
      r3 = r3 + r2;
      r2 = 0x0;
      r3 = MEMORY.ref(2, r3 + r2).get();
      r3 = r3 - 0xa;

      switch(r3) {
        case 0: // switch 200b364
        case 2: // switch 200b364
          //LAB_200b408
          r0 = 0x855;
          r0 = readFlag(r0);
          if(r0 != 0x0) {
            r0 = 0x1376;
            FUN_200b6a8(r0);
          } else {
            //LAB_200b41a
            r0 = 0x1288;
            FUN_200b6a8(r0);
          }
          break;

        case 1: // switch 200b364
          //LAB_200b422
          r0 = 0x1ce8;
          FUN_200b6a8(r0);
          break;

        case 10: // switch 200b364
        case 11: // switch 200b364
        case 40: // switch 200b364
          //LAB_200b42a
          FUN_200b5f8();
          FUN_2008360();
          return;
      }

      //LAB_200b434
      r0 = 0x8;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      FUN_200b5f8();
    }
  }

  /**
   * Event list 0x200c080 handler 0
   */
  @Method(value = 0x200b45c, ignoreExtraParams = true)
  public static void FUN_200b45c() {
    int r0;
    final int r1;

    r0 = FUN_200b2a8();
    if(r0 != 0x0) {
      r0 = 0x8;
      r0 = FUN_200b728(r0);
    } else {
      //LAB_200b46e
      FUN_200b5f0();
      r0 = 0x845;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x171c;
        FUN_200b6a8(r0);
      } else {
        //LAB_200b484
        r0 = 0x1408;
        FUN_200b6a8(r0);
      }

      //LAB_200b48a
      r0 = 0x8;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      FUN_200b5f8();
    }
  }

  /**
   * Event list 0x200c038 handler 2
   */
  @Method(value = 0x200b4a8, ignoreExtraParams = true)
  public static void FUN_200b4a8() {
    int r0;
    final int r1;

    r0 = FUN_200b2a8();
    if(r0 != 0x0) {
      r0 = 0x8;
      r0 = FUN_200b728(r0);
    } else {
      //LAB_200b4ba
      FUN_200b5f0();
      r0 = 0x190a;
      FUN_200b6a8(r0);
      r0 = 0x909;
      r0 = readFlag(r0);
      if(r0 != 0x0) {
        r0 = 0x1951;
        FUN_200b6a8(r0);
      }

      //LAB_200b4d4
      r0 = 0x8;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      FUN_200b5f8();
    }
  }

  /**
   * Event list 0x200c0ec handler 1
   */
  @Method(value = 0x200b4f0, ignoreExtraParams = true)
  public static void FUN_200b4f0() {
    int r0;
    final int r1;

    r0 = FUN_200b2a8();
    if(r0 != 0x0) {
      r0 = 0x8;
      r0 = FUN_200b728(r0);
    } else {
      //LAB_200b502
      FUN_200b5f0();
      r0 = 0x1823;
      FUN_200b6a8(r0);
      r0 = 0x8;
      r1 = 0x0;
      FUN_200b6b8(r0, r1);
      FUN_200b5f8();
    }
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x200b520)
  public static int FUN_200b520(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200b528)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200b530)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#atan2_} */
  @Method(0x200b538)
  public static int atan2(final int b, final int a) {
    return (int)MEMORY.call(0x8000100, b, a);
  }

  /** {@link GoldenSun#sin_} */
  @Method(0x200b540)
  public static int sin(final int angle) {
    return (int)MEMORY.call(0x8000118, angle);
  }

  /** {@link GoldenSun#cos_} */
  @Method(0x200b548)
  public static int cos(final int angle) {
    return (int)MEMORY.call(0x8000120, angle);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200b550)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x200b558)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x200b560)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x200b568)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    MEMORY.call(0x8009098, actor, script);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200b570)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200b578)
  public static void FUN_200b578(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200b580)
  public static void FUN_200b580(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#addPanel_} */
  @Method(0x200b588)
  public static Panel24 addPanel(final int x, final int y, final int w, final int h, final int flags) {
    return (Panel24)MEMORY.call(0x8015010, x, y, w, h, flags);
  }

  /** {@link GoldenSun_801#FUN_8015018} */
  @Method(0x200b590)
  public static void FUN_200b590(final Panel24 r0, final int r1) {
    MEMORY.call(0x8015018, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015078} */
  @Method(0x200b598)
  public static void FUN_200b598(final int r0, final Panel24 panel, final int x, final int y) {
    MEMORY.call(0x8015078, r0, panel, x, y);
  }

  /** {@link GoldenSun_801#FUN_8015210} */
  @Method(0x200b5a0)
  public static void FUN_200b5a0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8015228} */
  @Method(0x200b5a8)
  public static void FUN_200b5a8(final int r0, final int r1) {
    MEMORY.call(0x8015228, r0, r1);
  }

  /** {@link GoldenSun_801#queueRenderPacketXy_} */
  @Method(0x200b5b0)
  public static void queueRenderPacketXy(final RenderPacket0c renderPacket, final int x, final int y) {
    MEMORY.call(0x8015230, renderPacket, x, y);
  }

  /** {@link GoldenSun_801#clearVramSlot2_} */
  @Method(0x200b5b8)
  public static void clearVramSlot2(final int vramSlot) {
    MEMORY.call(0x8015238, vramSlot);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x200b5c0)
  public static void FUN_200b5c0(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_801#FUN_8015400} */
  @Method(0x200b5c8)
  public static int FUN_200b5c8(final int r0) {
    return (int)MEMORY.call(0x8015400, r0);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x200b5d0)
  public static int readFlag(final int flag) {
    return (int)MEMORY.call(0x80770c0, flag);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200b5d8)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x200b5e0)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200b5e8)
  public static void FUN_200b5e8(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200b5f0)
  public static void FUN_200b5f0() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200b5f8)
  public static void FUN_200b5f8() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a030} */
  @Method(0x200b600)
  public static void FUN_200b600(final int r0) {
    MEMORY.call(0x808a030, r0);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200b608)
  public static int FUN_200b608(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x808a070, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200b610)
  public static Actor70 getMapActor(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x808a080, mapActorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x200b618)
  public static void setActorVelocityScalerAndAcceleration(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200b620)
  public static void FUN_200b620(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x808a098, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x200b628)
  public static void FUN_200b628(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0a8} */
  @Method(0x200b630)
  public static void FUN_200b630(final int mapActorIndex) {
    MEMORY.call(0x808a0a8, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200b638)
  public static void FUN_200b638(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200b640)
  public static void FUN_200b640(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200b648)
  public static void FUN_200b648(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0e8} */
  @Method(0x200b650)
  public static void FUN_200b650(final int mapActorIndex) {
    MEMORY.call(0x808a0e8, mapActorIndex);
  }

  /** {@link GoldenSun_808#moveActorToPosition_} */
  @Method(0x200b658)
  public static void moveActorToPosition(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200b660)
  public static void setActorAnimationIfLoaded(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200b668)
  public static void setActorAnimationAndWaitUntilFinished(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#waitForActorAnimationToChange_} */
  @Method(0x200b670)
  public static void waitForActorAnimationToChange(final int actorIndex) {
    MEMORY.call(0x808a118, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200b678)
  public static void FUN_200b678(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x808a128, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x200b680)
  public static void FUN_200b680(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200b688)
  public static void FUN_200b688(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a138, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x200b690)
  public static void FUN_200b690(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200b698)
  public static void FUN_200b698(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x200b6a0)
  public static void FUN_200b6a0(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a158, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200b6a8)
  public static void FUN_200b6a8(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200b6b0)
  public static Panel24 FUN_200b6b0(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x808a178, mapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200b6b8)
  public static void FUN_200b6b8(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a180, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x200b6c0)
  public static void FUN_200b6c0(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a1b8, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1d0} */
  @Method(0x200b6c8)
  public static void FUN_200b6c8(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    MEMORY.call(0x808a1d0, r0, r1, r2, r3, a4, a5, a6, a7, a8, a9);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200b6d0)
  public static void FUN_200b6d0(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x808a1e8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200b6d8)
  public static void FUN_200b6d8(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a1f0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200b6e0)
  public static void FUN_200b6e0(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200b6e8)
  public static void FUN_200b6e8(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x200b6f0)
  public static void FUN_200b6f0() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a220} */
  @Method(0x200b6f8)
  public static void FUN_200b6f8(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a220, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x200b700)
  public static void FUN_200b700(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a330} */
  @Method(0x200b708)
  public static void FUN_200b708(final int r0, final int r1) {
    MEMORY.call(0x808a330, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a348} */
  @Method(0x200b710)
  public static void FUN_200b710(final int r0) {
    MEMORY.call(0x808a348, r0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200b718)
  public static void FUN_200b718() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200b720)
  public static void FUN_200b720() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_80b#FUN_80b0010} */
  @Method(0x200b728)
  public static int FUN_200b728(final int mapActorIndex) {
    return (int)MEMORY.call(0x80b0010, mapActorIndex);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200b730)
  public static void playSound(final int soundId) {
    MEMORY.call(0x80f9010, soundId);
  }

  /** {@link GoldenSun_80f#FUN_80f9078} */
  @Method(0x200b738)
  public static void FUN_200b738() {
    MEMORY.call(0x80f9078);
  }
}
