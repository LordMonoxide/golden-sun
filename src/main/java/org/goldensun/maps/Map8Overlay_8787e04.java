package org.goldensun.maps;

import org.goldensun.GoldenSun;
import org.goldensun.GoldenSunVars;
import org.goldensun.GoldenSun_801;
import org.goldensun.GoldenSun_807;
import org.goldensun.GoldenSun_808;
import org.goldensun.GoldenSun_80b;
import org.goldensun.GoldenSun_80f;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Map194;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Structccc;
import org.goldensun.weather.LightningStruct1f88;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;

/** Scripts for first cutscene, in house */
public final class Map8Overlay_8787e04 {
  private Map8Overlay_8787e04() { }

  /**
   * {@link GoldenSunVars#getRooms_200800c}
   */
  @Method(0x2008088)
  public static int getRooms() {
    return 0x2009fd0;
  }

  /**
   * {@link GoldenSunVars#getLadders_200802c}
   */
  @Method(0x2008090)
  public static int getLadders() {
    return 0;
  }

  /**
   * {@link GoldenSunVars#getTransitions_2008014}
   */
  @Method(0x2008094)
  public static int getTransitions() {
    return readFlag(0x834) != 0 ? 0x200a1dc : 0x200a198;
  }

  /**
   * {@link GoldenSunVars#getActors_200801c}
   */
  @Method(0x20080b8)
  public static int getActors() {
    if(entranceId_2000402.get() == 19) { // Lab in Babi's palace
      return 0x200a518;
    }

    //LAB_20080ce
    final int r5;
    if(readFlag(0x87a) != 0) {
      r5 = 0x200a410;
      //LAB_20080dc
    } else if(readFlag(0x815) != 0) {
      r5 = 0x200a338;
    } else {
      //LAB_20080ea
      r5 = 0x200a218;
    }

    //LAB_20080ec
    FUN_808a038(r5);
    return r5;
  }

  /**
   * Event list 0x200ac5c handler 1
   */
  @Method(value = 0x2008118, ignoreExtraParams = true)
  public static void FUN_2008118(final int r0) {
    FUN_808a170(0x22b9);
    FUN_808a178(r0);

    if(FUN_808a070(0, 0) == 0) {
      FUN_808a010(10);
      FUN_808a170(0x22ba);
    } else {
      //LAB_2008146
      FUN_808a170(0x22bb);
    }

    //LAB_200814c
    FUN_808a180(r0, 0);
  }

  /**
   * {@link GoldenSunVars#getEvents_2008024}
   */
  @Method(0x2008160)
  public static int getEvents() {
    final int r0;
    if(entranceId_2000402.get() == 19) { // Lab in Babi's palace
      if(readFlag(0x950) != 0) {
        r0 = 0x200ac5c;
      } else {
        //LAB_2008182
        r0 = 0x200ab9c;
      }
      //LAB_2008186
    } else if(readFlag(0x834) != 0) {
      r0 = 0x200a5a8;
      //LAB_2008194
    } else if(readFlag(0x87a) != 0) {
      r0 = 0x200a980;
      //LAB_20081a2
    } else if(readFlag(0x815) != 0) {
      r0 = 0x200a800;
    } else {
      //LAB_20081b0
      r0 = 0x200a6b0;
    }

    //LAB_20081b2
    return r0;
  }

  /**
   * Event list 0x200a6b0 handler 4
   */
  @Method(value = 0x20081e0, ignoreExtraParams = true)
  public static void FUN_20081e0() {
    FUN_808a018();
    FUN_808a130(16, 2);
    FUN_808a010(30);
    FUN_808a170(0xf5b);
    FUN_808a150(0, 16, 10);
    FUN_808a188(16, 0, 6);
    FUN_808a1e8(16, 0x102, 0);
    FUN_808a130(16, 1);
    FUN_808a010(20);
    setActorAnimationAndWaitUntilFinished(16, 4);
    FUN_808a010(20);
    FUN_808a178(16);

    if(FUN_808a070(0, 0) == 0x1) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    }

    //LAB_200825a
    FUN_808a130(16, 1);
    FUN_808a010(20);
    FUN_808a188(16, 0, 4);
    FUN_808a020();
  }

  /**
   * Event list 0x200a800 handler 2
   */
  @Method(value = 0x2008284, ignoreExtraParams = true)
  public static void FUN_2008284() {
    FUN_808a018();
    FUN_808a148(14, 0, 10);
    FUN_808a170(0x11aa);
    FUN_808a178(14);

    if(FUN_808a070(0, 0) == 0) {
      FUN_808a180(14, 0);
    } else {
      //LAB_20082b8
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
      FUN_808a190(14, 0);
    }

    //LAB_20082d0
    FUN_808a020();
  }

  @Method(0x20082e0)
  public static void FUN_20082e0(final int r0) {
    if(readFlag(0x834) != 0) {
      FUN_808a2d0();
    }

    //LAB_20082f2
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);
    FUN_808a368();
    FUN_808a370();
    FUN_808a248(r0);
  }

  /**
   * Event list 0x200a6b0 handler 6
   */
  @Method(value = 0x200831c, ignoreExtraParams = true)
  public static void FUN_200831c() {
    playSound(0x7b);
    FUN_20082e0(1);
  }

  /**
   * Event list 0x200a6b0 handler 7
   */
  @Method(value = 0x2008330, ignoreExtraParams = true)
  public static void FUN_2008330() {
    playSound(0x7b);
    FUN_20082e0(2);
  }

  /**
   * Event list 0x200a6b0 handler 8
   */
  @Method(value = 0x2008344, ignoreExtraParams = true)
  public static void FUN_2008344() {
    playSound(0x7b);
    FUN_20082e0(3);
  }

  /**
   * Event list 0x200a6b0 handler 9
   */
  @Method(value = 0x2008358, ignoreExtraParams = true)
  public static void FUN_2008358() {
    playSound(0x7b);
    FUN_20082e0(4);
  }

  /**
   * Event list 0x200a6b0 handler 10
   */
  @Method(value = 0x200836c, ignoreExtraParams = true)
  public static void FUN_200836c() {
    playSound(0x80);
    FUN_20082e0(5);
  }

  /**
   * Event list 0x200a6b0 handler 11
   */
  @Method(value = 0x2008380, ignoreExtraParams = true)
  public static void FUN_2008380() {
    playSound(0x7b);
    FUN_20082e0(6);
  }

  /**
   * Event list 0x200a6b0 handler 12
   */
  @Method(value = 0x2008394, ignoreExtraParams = true)
  public static void FUN_2008394() {
    playSound(0x80);
    FUN_20082e0(7);
  }

  /**
   * Event list 0x200a6b0 handler 13
   */
  @Method(value = 0x20083a8, ignoreExtraParams = true)
  public static void FUN_20083a8() {
    playSound(0x81);
    FUN_20082e0(8);
  }

  /**
   * Event list 0x200a6b0 handler 14
   */
  @Method(value = 0x20083bc, ignoreExtraParams = true)
  public static void FUN_20083bc() {
    playSound(0x81);
    FUN_20082e0(9);
  }

  /**
   * Event list 0x200a6b0 handler 15
   */
  @Method(value = 0x20083d0, ignoreExtraParams = true)
  public static void FUN_20083d0() {
    playSound(0x7b);
    FUN_20082e0(10);
  }

  /**
   * Event list 0x200a6b0 handler 16
   */
  @Method(value = 0x20083e4, ignoreExtraParams = true)
  public static void FUN_20083e4() {
    playSound(0x7b);
    FUN_20082e0(11);
  }

  /**
   * {@link GoldenSunVars#init_2008004}
   */
  @Method(0x20083f8)
  public static int init() {
    if(entranceId_2000402.get() == 19) {
      clearFlag(0x12f);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);
    } else {
      //LAB_2008420
      if(readFlag(0x834) != 0) {
        FUN_808a0f0(11, 0, 0);
        FUN_808a0f0(12, 0, 0);
        FUN_808a0f0(13, 0, 0);
        FUN_808a0f0(14, 0, 0);
        FUN_808a0f0(15, 0, 0);
        FUN_808a0f0(16, 0, 0);
      } else {
        //LAB_2008468
        FUN_20093b4();
      }

      //LAB_200846c
      setActorPriority(13, 1);

      if(readFlag(0x87a) != 0) {
        FUN_80091e0(getMapActor(17), 0);
        if(entranceId_2000402.get() >= 6 && entranceId_2000402.get() < 8) {
          if(readFlag(0x109) != 0) {
            if(readFlag(0x203) != 0) {
              FUN_8009188(12);
            }
          } else {
            //LAB_20084bc
            FUN_8009188(11);
            FUN_80091e0(getMapActor(8), 0);
            setActorAnimationIfLoaded(8, 10);
          }
        }
        //LAB_20084d8
      } else if(entranceId_2000402.get() == 21) {
        FUN_2008a0c();
        //LAB_20084ee
      } else if(entranceId_2000402.get() == 20) {
        setFlag(0x834);
        FUN_2008578();
        //LAB_20084fe
      } else if(entranceId_2000402.get() == 22) {
        FUN_20093e4();
      } else {
        //LAB_2008508
        boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);

        if(readFlag(0x834) != 0) {
          FUN_808a2c8();
          boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).cast(LightningStruct1f88::new).quiet_1f84.set(true);
          FUN_808a2d8();
          sleep(30);
          FUN_808a360();
          FUN_808a370();
          FUN_808a2e0();
        } else {
          //LAB_2008546
          FUN_8009128();
          sleep(1);
        }
      }
    }

    //LAB_2008550
    return 0;
  }

  @Method(0x2008578)
  public static void FUN_2008578() {
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Actor70 r6 = r1.actor_1e0.deref();
    final Sprite38 r8 = getMapActor(17).sprite_50.deref();
    FUN_808a018();
    FUN_808a0f0(11, 0, 0);
    FUN_808a0f0(12, 0, 0);
    FUN_808a0f0(13, 0, 0);
    FUN_808a0f0(14, 0, 0);
    FUN_808a0f0(15, 0, 0);
    FUN_808a0f0(16, 0, 0);
    FUN_80091e0(getMapActor(0), 0);
    setActorAnimationIfLoaded(0, 18);
    r8.rotation_1e.set(0x555);
    getMapActor(17)._55.set(0);
    FUN_80091e0(getMapActor(17), 0);
    FUN_808a0f0(17, 0x2400000, 0x28a0000);
    FUN_8009188(7);
    FUN_808a0f0(8, 0x2160000, 0x2b00000);
    FUN_8009208();
    FUN_808a1d8(8);
    FUN_8015210(0xe52, 1, 0);
    FUN_808a010(40);
    FUN_80091f0(0x10000, 0x10000, 0x10000);
    FUN_808a1d8(8);
    FUN_8015210(0xe53, 1, 0);
    FUN_8009210();
    FUN_808a010(40);
    r7._ec.set(0x1480000);
    r7._f0.set(0x2580000);
    r7._f4.set(0x2700000);
    r7._f8.set(0x3300000);
    r6.pos_08.set(0x2340000, 0, 0x2b30000);
    FUN_8009128();
    sleep(1);
    r1._1c0.set(0x209);
    r1._1c8.set(64);
    FUN_808a2c8();
    boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).cast(LightningStruct1f88::new).quiet_1f84.set(true);
    FUN_808a2d8();
    sleep(30);
    FUN_808a360();
    FUN_808a370();
    FUN_808a2e0();
    setActorAnimationAndWaitUntilFinished(8, 4);
    FUN_808a170(0xe54);
    FUN_808a188(0x9008, 0, 60);
    FUN_808a138(0, 2);
    FUN_808a010(40);
    FUN_808a138(8, 1);
    FUN_808a010(40);
    FUN_808a188(0x9008, 0, 20);
    FUN_808a138(0, 2);
    FUN_8009190(7);
    FUN_808a010(20);
    FUN_8009188(8);
    setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
    setActorAnimationIfLoaded(0, 19);
    FUN_808a0c0(0, 557, 679);
    FUN_8009190(8);
    FUN_8009188(9);
    FUN_808a0c0(0, 555, 680);
    FUN_808a010(30);
    FUN_808a1b8(8, 0xd000, 0);
    FUN_80091e0(getMapActor(0), 1);
    FUN_808a128(0, 4, 0);
    FUN_808a0d0(0, 543, 674);
    setActorPriority(0, 3);
    FUN_808a1b8(0, 0x4000, 40);
    setActorAnimationAndWaitUntilFinished(8, 4);
    FUN_808a010(20);
    FUN_808a180(0x9008, 0);
    FUN_20097e4();
    FUN_808a130(8, 2);
    FUN_808a188(0x9008, 0, 20);
    getMapActor(8)._5a.and(~0x1);
    FUN_808a0d0(8, 542, 680);
    FUN_808a010(1);
    getMapActor(8)._5a.or(0x1);
    FUN_808a010(10);
    FUN_808a138(8, 2);
    addLayerToSpriteIfRegularSprite(getMapActor(0), 226);
    setFlag(0x21);
    playSound(126);
    FUN_808a158(0, 7);
    FUN_808a010(10);
    FUN_808a158(0, 0);
    FUN_808a010(20);
    getMapActor(8)._5a.and(~0x1);
    FUN_808a0d0(8, 534, 688);
    FUN_808a010(1);
    getMapActor(8)._5a.or(0x1);
    FUN_808a010(20);
    setActorVelocityScalerAndAcceleration(8, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(0, 0x18000, 0xc000);
    FUN_808a200(8, 1);
    getMapActor(0).flags_23.or(0x1);
    FUN_808a098(8, 0x2009ab4);
    FUN_808a010(20);
    FUN_808a098(0, 0x2009ab4);
    FUN_808a0a0(8);
    FUN_808a0d0(8, 419, 661);
    FUN_808a0d0(8, 408, 661);
    setActorAnimationIfLoaded(8, 1);
    setActorAnimationIfLoaded(0, 1);
    FUN_808a1b8(8, 0x4000, 10);
    FUN_808a178(0x8008);

    if(FUN_808a070(0, 0) == 0) {
      r1._1d8.incr();
    }

    //LAB_200895a
    FUN_808a010(20);
    FUN_808a188(0x8008, 0, 20);
    setActorAnimationIfLoaded(0, 3);
    setActorAnimationAndWaitUntilFinished(8, 3);
    FUN_808a010(20);
    FUN_808a098(8, 0x2009b04);
    FUN_808a098(0, 0x2009b34);
    FUN_808a010(20);
    r1._1c0.set(0x201);
    r1._1c8.set(16);
    FUN_808a368();
    FUN_808a370();
    FUN_808a248(20);
  }

  @Method(0x2008a0c)
  public static void FUN_2008a0c() {
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Actor70 r5 = getMapActor(10);
    final Sprite38 r6 = r5.sprite_50.deref();
    FUN_808a018();
    FUN_808a0f0(11, 0, 0);
    FUN_808a0f0(12, 0, 0);
    FUN_808a0f0(13, 0, 0);
    FUN_808a0f0(14, 0, 0);
    FUN_808a0f0(15, 0, 0);
    FUN_808a0f0(16, 0, 0);
    FUN_808a0f0(8, 0x1af0000, 0x1870000);
    FUN_808a0f0(10, 0x1cf0000, 0x1940000);
    FUN_80091e0(getMapActor(10), 0);
    r5.flags_23.and(~0x1);
    r5._55.set(0);
    r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    FUN_808a098(10, 0x2009cec);
    r3._1c0.set(0x201);
    FUN_8009180(83, 15, 83, 19, 5, 4);
    FUN_8009180(90, 16, 90, 20, 5, 4);
    FUN_8009180(77, 23, 82, 23, 5, 7);
    FUN_8009180(83, 33, 85, 33, 2, 2);
    FUN_8009180(91, 28, 90, 28, 1, 1);
    FUN_8009180(91, 28, 88, 30, 1, 1);
    FUN_8009180(94, 27, 94, 23, 6, 4);
    FUN_8009180(92, 28, 87, 23, 4, 4);
    FUN_8009180(65, 53, 88, 24, 2, 2);
    FUN_80091a0();
    GPU.BLDCNT.setu(0x3f42);
    GPU.BLDALPHA.setu(0x100c);
    FUN_808a2c8();
    boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).cast(LightningStruct1f88::new).quiet_1f84.set(true);
    FUN_808a2d8();
    sleep(30);
    FUN_808a200(8, 1);
    setActorVelocityScalerAndAcceleration(8, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(0, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(9, 0x18000, 0xc000);
    FUN_808a098(0, 0x2009bb4);
    FUN_808a098(8, 0x2009b78);
    FUN_808a360();
    FUN_808a0a0(8);
    playSound(0x9e);
    FUN_808a1e8(8, 0x100, 0);
    FUN_808a138(8, 2);
    FUN_808a1b8(8, 0x4000, 10);
    FUN_808a208(0x40000, 0x8000);
    FUN_808a210(0x19e0000, -1, 0x2120000, 1);
    FUN_808a0f0(9, 0x19e0000, 0x2120000);
    FUN_808a0d0(9, 427, 483);
    FUN_808a218();
    FUN_808a170(0xe5b);
    FUN_808a188(0x8009, 0, 10);
    FUN_808a208(0x18000, 0x3000);
    FUN_808a210(0x1e00000, -1, 0x1bc0000, 1);
    FUN_808a218();
    FUN_808a010(20);
    FUN_808a1b8(8, 0x8000, 20);
    setActorAnimationIfLoaded(8, 3);
    setActorAnimationAndWaitUntilFinished(0, 3);
    setActorAnimationAndWaitUntilFinished(9, 3);
    FUN_808a0c8(9, 415, 589);
    FUN_808a010(10);
    FUN_808a098(8, 0x2009c04);
    FUN_808a098(0, 0x2009c54);
    playSound(0xea);
    FUN_808a010(20);
    FUN_808a098(10, 0x2009d38);

    //LAB_2008cc0
    for(int i = 0; i < 4; i++) {
      GPU.BLDALPHA.setu(0x100e + i);
      sleep(1);
    }

    playSound(0xca);
    sleep(10);

    //LAB_2008ce4
    for(int i = 0; i < 16; i++) {
      GPU.BLDALPHA.setu(0x100f - i);
      sleep(1);
    }

    FUN_808a0a0(0);
    setActorAnimationIfLoaded(8, 1);
    FUN_808a130(8, 2);
    FUN_808a138(0, 2);
    FUN_808a010(10);
    FUN_808a1b8(8, 0xc000, 0);
    FUN_808a1b8(0, 0xc000, 20);
    FUN_808a1f0(8, 0x102);
    FUN_808a1f0(0, 0x102);
    FUN_808a010(80);
    FUN_808a0f0(9, 0, 0);
    FUN_808a150(8, 0, 20);
    setActorAnimationIfLoaded(8, 3);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_808a010(40);
    FUN_808a208(0xcccc, 0x1999);
    FUN_808a200(8, 1);
    FUN_808a098(8, 0x2009ca4);
    FUN_808a0b0(0, 0x2009ca4);
    r3._1c0.set(0x100);
    r3._1c8.set(32);
    FUN_808a368();
    FUN_808a370();
    FUN_808a248(21);
  }

  /**
   * Event list 0x200a6b0 handler 5
   */
  @Method(value = 0x2008e34, ignoreExtraParams = true)
  public static void FUN_2008e34() {
    final Actor70 r0 = getMapActor(0);
    if((r0.angle_06.get() & 0xffff) < 0x2000 || (r0.angle_06.get() & 0xffff) > 0xb000) {
      FUN_2009aa4(0, 13);
    } else {
      //LAB_2008e54
      FUN_808a018();

      if(readFlag(0x87a) != 0) {
        FUN_808a138(13, 2);
        FUN_808a148(13, 0, 10);

        if(readFlag(0x300) == 0) {
          FUN_808a170(0x1c14);
          FUN_808a180(13, 0);
          setFlag(0x300);
        }

        //LAB_2008e96
        FUN_808a170(0x1c15);
        FUN_808a190(13, 0);
        FUN_808a1b8(13, 0x9000, 10);
        //LAB_2008eb0
      } else {
        if(readFlag(0x815) != 0) {
          FUN_808a170(0x11a9);
        } else {
          //LAB_2008ec2
          FUN_808a170(0xf58);
        }

        //LAB_2008ec8
        FUN_808a180(13, 0);
      }

      //LAB_2008ed0
      FUN_808a020();
    }
  }

  /**
   * Event list 0x200a980 handler 13
   */
  @Method(value = 0x2008ef8, ignoreExtraParams = true)
  public static void FUN_2008ef8() {
    FUN_808a018();
    FUN_808a148(16, 0, 10);
    FUN_808a170(0x1c13);
    FUN_808a180(16, 0);
    FUN_808a1b8(16, 0xb000, 10);
    setFlag(0x301);
    FUN_808a020();
  }

  /**
   * Event list 0x200a980 handler 12
   */
  @Method(value = 0x2008f38, ignoreExtraParams = true)
  public static void FUN_2008f38() {
    FUN_808a018();
    FUN_808a170(0x1c1b);
    FUN_808a180(13, 0);
    setFlag(0x81c);
    FUN_808a020();
  }

  /**
   * Event list 0x200a980 handler 14
   */
  @Method(value = 0x2008f64, ignoreExtraParams = true)
  public static void FUN_2008f64() {
    FUN_808a018();
    FUN_808a170(0x1c1a);
    FUN_808a180(16, 0);
    setFlag(0x81c);
    FUN_808a020();
  }

  /**
   * Event list 0x200a980 handler 17
   */
  @Method(value = 0x2008f90, ignoreExtraParams = true)
  public static void FUN_2008f90() {
    FUN_808a018();
    setActorVelocityScalerAndAcceleration(0, 0x9999, 0x4ccc);
    FUN_808a0d0(0, 569, 393);
    FUN_808a1b8(0, 0x4000, 40);
    FUN_808a130(8, 2);
    FUN_808a170(0x1c66);
    FUN_808a188(8, 0, 80);
    FUN_808a1e8(8, 0x101, 60);
    FUN_808a130(8, 1);
    FUN_808a188(8, 0, 60);
    FUN_808a138(8, 2);
    FUN_808a010(80);
    setActorVelocityScalerAndAcceleration(8, 0xcccc, 0x6666);
    FUN_808a0b8(8, 584, 406);
    FUN_8009190(11);
    FUN_8009188(12);
    setActorAnimationIfLoaded(8, 12);
    FUN_808a010(80);
    FUN_808a138(8, 2);
    FUN_808a010(40);
    FUN_808a188(8, 0, 40);
    FUN_808a1e8(8, 264, 40);
    FUN_808a188(8, 0, 40);
    FUN_808a1e8(0, 261, 60);
    setActorAnimationAndWaitUntilFinished(8, 13);
    FUN_808a1e8(8, 0x103, 0);
    setActorAnimationIfLoaded(8, 11);
    FUN_808a010(40);
    FUN_808a188(8, 0, 40);
    FUN_808a138(8, 1);
    FUN_808a010(20);
    FUN_808a188(8, 0, 20);
    setActorAnimationAndWaitUntilFinished(8, 12);
    FUN_808a010(20);
    FUN_808a1e8(0, 0x102, 60);
    setActorAnimationIfLoaded(8, 13);
    FUN_808a178(8);

    if(FUN_808a070(0, 0) == 1) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    }

    //LAB_20090ea
    if(readFlag(0x81c) != 0) {
      FUN_808a1e8(8, 0x102, 60);
    }

    //LAB_2009100
    FUN_808a010(20);
    FUN_808a180(8, 0);
    FUN_808a1e8(8, 0x107, 60);
    FUN_808a170(0x1c6f);
    FUN_808a178(8);

    if(FUN_808a070(0, 0) == 1) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1d8.incr();
    }

    //LAB_2009144
    if(readFlag(0x81c) != 0) {
      FUN_808a1e8(8, 0x102, 60);
    }

    //LAB_200915a
    FUN_808a010(20);
    FUN_808a180(8, 0);
    FUN_808a1e8(8, 0x107, 60);
    FUN_808a170(0x1c72);
    FUN_808a180(8, 0);
    FUN_808a138(8, 1);
    FUN_808a010(20);
    setActorAnimationAndWaitUntilFinished(8, 13);
    FUN_808a130(8, 2);
    FUN_808a188(8, 0, 40);
    FUN_808a138(8, 1);
    FUN_808a010(20);
    FUN_808a188(8, 0, 40);
    FUN_808a138(8, 2);
    FUN_808a010(40);
    getMapActor(0).angle_06.set(0);
    sleep(1);
    getMapActor(0)._5a.and(~0x1);
    FUN_808a0b8(0, 558, 388);
    setActorVelocityScalerAndAcceleration(8, 0x13333, 0x9999);
    setActorAnimationIfLoaded(8, 14);
    FUN_808a0c0(8, 586, 400);
    FUN_808a010(40);
    FUN_808a0d0(8, 580, 382);
    FUN_808a1b8(8, 0x8000, 40);
    getMapActor(0)._5a.or(0x1);
    FUN_808a1b8(8, 0xc000, 8);
    FUN_808a1b8(8, 0, 8);
    FUN_808a1b8(8, 0x4000, 8);
    FUN_808a1b8(8, 0x8000, 10);
    FUN_808a128(8, 4, 20);
    FUN_808a128(8, 6, 40);
    FUN_808a128(8, 4, 20);
    FUN_808a188(8, 0, 40);
    setActorVelocityScalerAndAcceleration(8, 0x6666, 0x3333);
    FUN_808a0d0(8, 572, 384);
    FUN_808a188(8, 0, 20);
    setActorAnimationAndWaitUntilFinished(0, 3);
    FUN_808a010(20);
    setActorAnimationAndWaitUntilFinished(8, 3);
    setFlag(0x81e);
    setFlag(0x203);
    FUN_808a020();
  }

  /**
   * Event list 0x200a980 handler 16
   */
  @Method(value = 0x200933c, ignoreExtraParams = true)
  public static void FUN_200933c() {
    FUN_808a018();

    if(readFlag(0x203) != 0) {
      FUN_808a168(8, 0x10000, 0x2009e6c);
      FUN_808a010(20);
      FUN_808a170(0x1c77);
      FUN_808a180(8, 0);
    } else {
      //LAB_200936e
      FUN_808a138(8, 2);
      FUN_808a010(40);
      FUN_808a170(0x1c79);
      FUN_808a188(8, 0, 40);
      FUN_8015040(0x1c7a, 1);
    }

    //LAB_2009398
    FUN_808a020();
  }

  @Method(0x20093b4)
  public static void FUN_20093b4() {
    FUN_8009180(22, 85, 25, 85, 2, 2);
    FUN_80091c0(25, 15, 2, 2, 25, 25);
  }

  @Method(0x20093e4)
  public static void FUN_20093e4() {
    FUN_808a018();
    FUN_808a210(-1, -1, -1, 0);
    sleep(1);
    FUN_808a0f0(0, 0, 0);
    FUN_808a0f0(18, 0x1e00000, 0xca0000);
    sleep(1);
    FUN_808a200(18, 1);
    final Actor70 r8 = loadActor(22, 0x1480000, 0x20000, 0xc30000);
    r8._55.set(0);
    final Sprite38 r6 = r8.sprite_50.deref();
    r8.pos_08.setY(0x50000);
    r6.layerCount_27.set(0);
    r6.packet_00.attribs_04.flags_01.and(~0x20);
    r6.packet_00.attribs_04.attrib2_04.and(0xfff);
    final int r5 = mallocSlotChip(17, 0x608) + 0x400;
    FUN_8015250(224);
    allocateSpriteSlot(r6.slot_1c.get(), 0x80, r5);
    freeSlot(17);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x202);
    FUN_808a360();
    setActorVelocityScalerAndAcceleration(18, 0x10000, 0x8000);
    FUN_808a0d0(18, 480, 176);
    FUN_808a0d0(18, 420, 164);
    FUN_808a0d0(18, 326, 185);
    FUN_808a1b8(18, 0x4000, 10);
    FUN_8009098(r8, 0x2009eac);
    FUN_8009148(r8);
    FUN_8009098(r8, 0x2009ecc);
    FUN_8009148(r8);
    FUN_808a010(20);
    clearActor(r8);
    FUN_808a128(18, 2, 20);
    FUN_808a1b8(18, 0, 40);
    FUN_808a368();
    FUN_808a370();
    FUN_808a248(22);
  }

  @Method(0x20097e4)
  public static void FUN_20097e4() {
    FUN_808a428(148, 1);
    setFieldPsynergyTargetAndCaster(8, 17);
    FUN_808a448();
    FUN_808a420(1);
    FUN_808a438();
    FUN_808a440();
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x2009814)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#mallocSlotChip_} */
  @Method(0x200982c)
  public static int mallocSlotChip(final int slot, final int size) {
    return (int)MEMORY.call(0x8000140, slot, size);
  }

  /** {@link GoldenSun#freeSlot_} */
  @Method(0x2009834)
  public static void freeSlot(final int slot) {
    MEMORY.call(0x8000150, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot_} */
  @Method(0x2009844)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x80001c8, slot, size, newDataPtr);
  }

  /** {@link GoldenSun#setActorSpriteScript_} */
  @Method(0x2009854)
  public static void FUN_8009098(final Actor70 r0, final int r1) {
    MEMORY.call(0x8009098, r0, r1);
  }

  /** {@link GoldenSun#loadActor_} */
  @Method(0x200985c)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x80090c8, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor_} */
  @Method(0x2009864)
  public static void clearActor(final Actor70 r0) {
    MEMORY.call(0x80090d0, r0);
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200986c)
  public static void FUN_8009128() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009148} */
  @Method(0x2009874)
  public static void FUN_8009148(final Actor70 r0) {
    MEMORY.call(0x8009148, r0);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200987c)
  public static void FUN_8009180(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_8009188} */
  @Method(0x2009884)
  public static void FUN_8009188(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  /** {@link GoldenSun#FUN_8009190} */
  @Method(0x200988c)
  public static void FUN_8009190(final int r0) {
    MEMORY.call(0x8009190, r0);
  }

  /** {@link GoldenSun#FUN_80091a0} */
  @Method(0x2009894)
  public static void FUN_80091a0() {
    MEMORY.call(0x80091a0);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200989c)
  public static void FUN_80091c0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x20098a4)
  public static void FUN_80091e0(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x20098ac)
  public static void FUN_80091f0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009208} */
  @Method(0x20098b4)
  public static void FUN_8009208() {
    MEMORY.call(0x8009208);
  }

  /** {@link GoldenSun#FUN_8009210} */
  @Method(0x20098bc)
  public static void FUN_8009210() {
    MEMORY.call(0x8009210);
  }

  /** {@link GoldenSun#addLayerToSpriteIfRegularSprite_} */
  @Method(0x20098c4)
  public static void addLayerToSpriteIfRegularSprite(final Actor70 actor, final int spriteDataIndex) {
    MEMORY.call(0x8009228, actor, spriteDataIndex);
  }

  /** {@link GoldenSun_801#FUN_8015040} */
  @Method(0x20098d4)
  public static void FUN_8015040(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015210} */
  @Method(0x20098dc)
  public static void FUN_8015210(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8015250} */
  @Method(0x20098e4)
  public static void FUN_8015250(final int itemId) {
    MEMORY.call(0x8015250, itemId);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x20098ec)
  public static int readFlag(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x20098f4)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x20098fc)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x2009904)
  public static void FUN_808a010(final int sleepFrames) {
    MEMORY.call(0x808a010, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200990c)
  public static void FUN_808a018() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x2009914)
  public static void FUN_808a020() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a038} */
  @Method(0x200991c)
  public static void FUN_808a038(final int r0) {
    MEMORY.call(0x808a038, r0);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x2009924)
  public static int FUN_808a070(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_808#getMapActor_} */
  @Method(0x200992c)
  public static Actor70 getMapActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x808a080, actorIndex);
  }

  /** {@link GoldenSun_808#setActorVelocityScalerAndAcceleration_} */
  @Method(0x2009934)
  public static void setActorVelocityScalerAndAcceleration(final int actorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x808a090, actorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a098} */
  @Method(0x200993c)
  public static void FUN_808a098(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x2009944)
  public static void FUN_808a0a0(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200994c)
  public static void FUN_808a0b0(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0b8} */
  @Method(0x2009954)
  public static void FUN_808a0b8(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0b8, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200995c)
  public static void FUN_808a0c0(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x2009964)
  public static void FUN_808a0c8(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0c8, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200996c)
  public static void FUN_808a0d0(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0d0, actorIndex, x, z);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x2009974)
  public static void FUN_808a0f0(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_808#setActorAnimationIfLoaded_} */
  @Method(0x200997c)
  public static void setActorAnimationIfLoaded(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a100, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x2009984)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a128} */
  @Method(0x200998c)
  public static void FUN_808a128(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2009994)
  public static void FUN_808a130(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a130, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200999c)
  public static void FUN_808a138(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a148} */
  @Method(0x20099a4)
  public static void FUN_808a148(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a148, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x20099ac)
  public static void FUN_808a150(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x808a150, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x20099b4)
  public static void FUN_808a158(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a168} */
  @Method(0x20099bc)
  public static void FUN_808a168(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    MEMORY.call(0x808a168, mapActorIndex1, mapActorIndex2AndFlags, r2);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x20099c4)
  public static void FUN_808a170(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x20099cc)
  public static Panel24 FUN_808a178(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x20099d4)
  public static void FUN_808a180(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x20099dc)
  public static void FUN_808a188(final int r0, final int r1, final int sleepFrames) {
    MEMORY.call(0x808a188, r0, r1, sleepFrames);
  }

  /** {@link GoldenSun_808#FUN_808a190} */
  @Method(0x20099e4)
  public static int FUN_808a190(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a190, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x20099ec)
  public static void FUN_808a1b8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1d8} */
  @Method(0x20099f4)
  public static void FUN_808a1d8(final int r0) {
    MEMORY.call(0x808a1d8, r0);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x20099fc)
  public static void setActorPriority(final int mapActorIndex, final int priority) {
    MEMORY.call(0x808a1e0, mapActorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2009a04)
  public static void FUN_808a1e8(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x2009a0c)
  public static void FUN_808a1f0(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x2009a14)
  public static void FUN_808a200(final int actorIndex, final int r1) {
    MEMORY.call(0x808a200, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x2009a1c)
  public static void FUN_808a208(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2009a24)
  public static void FUN_808a210(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x808a210, x, y, z, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x2009a2c)
  public static void FUN_808a218() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x2009a34)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x2009a3c)
  public static void FUN_808a2c8() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d0} */
  @Method(0x2009a44)
  public static void FUN_808a2d0() {
    MEMORY.call(0x808a2d0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x2009a4c)
  public static void FUN_808a2d8() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x2009a54)
  public static void FUN_808a2e0() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x2009a5c)
  public static void FUN_808a360() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x2009a64)
  public static void FUN_808a368() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x2009a6c)
  public static void FUN_808a370() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a420} */
  @Method(0x2009a74)
  public static void FUN_808a420(final int r0) {
    MEMORY.call(0x808a420, r0);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x2009a7c)
  public static void FUN_808a428(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#setFieldPsynergyTargetAndCaster_} */
  @Method(0x2009a84)
  public static void setFieldPsynergyTargetAndCaster(final int casterMapActorIndex, final int targetMapActorIndex) {
    MEMORY.call(0x808a430, casterMapActorIndex, targetMapActorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a438} */
  @Method(0x2009a8c)
  public static void FUN_808a438() {
    MEMORY.call(0x808a438);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x2009a94)
  public static void FUN_808a440() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#FUN_808a448} */
  @Method(0x2009a9c)
  public static void FUN_808a448() {
    MEMORY.call(0x808a448);
  }

  /** {@link GoldenSun_80b#FUN_80b0018} */
  @Method(0x2009aa4)
  public static int FUN_2009aa4(final int r0, final int mapActorIndex) {
    return (int)MEMORY.call(0x80b0018, r0, mapActorIndex);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x2009aac)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
