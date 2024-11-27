package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.Panel24;
import org.goldensun.types.Map194;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Actor70;
import org.goldensun.types.Structccc;

import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;

/** Scripts for first cutscene, in house */
public final class Map8Overlay_8787e04 {
  private Map8Overlay_8787e04() { }

  /** {@link GoldenSunVars#getRooms_200800c} */
  @Method(0x2008088)
  public static int getRooms() {
    return 0x2009fd0;
  }

  /** {@link GoldenSunVars#getLadders_200802c} */
  @Method(0x2008090)
  public static int getLadders() {
    return 0;
  }

  /** {@link GoldenSunVars#getTransitions_2008014} */
  @Method(0x2008094)
  public static int getTransitions() {
    //LAB_20080a4
    //LAB_20080a6
    return readFlag(0x834) != 0 ? 0x200a1dc : 0x200a198;
  }

  /** {@link GoldenSunVars#getActors_200801c} */
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
    FUN_200991c(r5);

    //LAB_20080f4
    return r5;
  }

  /** {@link GoldenSunVars#getEvents_2008024} */
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

  @Method(0x20082e0)
  public static void FUN_20082e0(final int r0) {
    if(readFlag(0x834) != 0) {
      FUN_2009a44();
    }

    //LAB_20082f2
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);
    FUN_2009a64();
    FUN_2009a6c();
    FUN_2009a34(r0);
  }

  /** Event handler, exiting house */
  @Method(0x2008380)
  public static void FUN_2008380(final int r0) {
    playSound(0x7b);
    FUN_20082e0(0x6);
  }

  /** {@link GoldenSunVars#init_2008004} */
  @Method(0x20083f8)
  public static int init() {
    int r3;

    if(entranceId_2000402.get() == 19) { // Lab in Babi's palace
      clearFlag(0x12f);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);
    } else {
      //LAB_2008420
      if(readFlag(0x834) != 0) {
        FUN_2009974(11, 0, 0);
        FUN_2009974(12, 0, 0);
        FUN_2009974(13, 0, 0);
        FUN_2009974(14, 0, 0);
        FUN_2009974(15, 0, 0);
        FUN_2009974(16, 0, 0);
      } else {
        //LAB_2008468
        FUN_20093b4();
      }

      //LAB_200846c
      setActorPriority(13, 1);

      if(readFlag(0x87a) != 0) {
        FUN_20098a4(getMapActor(17), 0);
        r3 = entranceId_2000402.get() & 0xffff;
        r3 = CPU.subT(r3, 0x6);
        r3 = CPU.lslT(r3, 16);
        r3 = CPU.cmpT(r3, 0x10000);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          if(readFlag(0x109) != 0) {
            if(readFlag(0x203) != 0) {
              FUN_2009884(0xc);
            }
          } else {
            //LAB_20084bc
            FUN_2009884(0xb);
            FUN_20098a4(getMapActor(8), 0);
            setActorAnimationIfLoaded(8, 10);
          }
        }
      } else {
        //LAB_20084d8
        r3 = entranceId_2000402.get();
        if(r3 == 0x15) {
          FUN_2008a0c();
          //LAB_20084ee
        } else if(r3 == 0x14) {
          setFlag(0x834);
          FUN_2008578();
          //LAB_20084fe
        } else if(r3 == 0x16) {
          FUN_20093e4();
        } else {
          //LAB_2008508
          boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x209);

          if(readFlag(0x834) != 0) {
            FUN_2009a3c();
            boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
            FUN_2009a4c();
            sleep(30);
            FUN_2009a5c();
            FUN_2009a6c();
            FUN_2009a54();
          } else {
            //LAB_2008546
            FUN_200986c();
            sleep(1);
          }
        }
      }
    }

    //LAB_2008550
    return 0;
  }

  @Method(0x2008578)
  public static void FUN_2008578() {
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Actor70 r6 = r3.actor_1e0.deref();
    final Sprite38 r8 = getMapActor(17).sprite_50.deref();
    FUN_200990c();
    FUN_2009974(11, 0, 0);
    FUN_2009974(12, 0, 0);
    FUN_2009974(13, 0, 0);
    FUN_2009974(14, 0, 0);
    FUN_2009974(15, 0, 0);
    FUN_2009974(16, 0, 0);
    FUN_20098a4(getMapActor(0), 0);
    setActorAnimationIfLoaded(0, 0x12);
    r8.rotation_1e.set(0x555);
    getMapActor(0x11)._55.set(0);
    FUN_20098a4(getMapActor(0x11), 0);
    FUN_2009974(0x11, 0x2400000, 0x28a0000);
    FUN_2009884(0x7);
    FUN_2009974(0x8, 0x2160000, 0x2b00000);
    FUN_20098b4();
    FUN_20099f4(0x8);
    FUN_20098dc(0xe52, 0x1, 0);
    FUN_2009904(0x28);
    FUN_20098ac(0x10000, 0x10000, 0x10000);
    FUN_20099f4(0x8);
    FUN_20098dc(0xe53, 0x1, 0);
    FUN_20098bc();
    FUN_2009904(0x28);
    r7._ec.set(0x1480000);
    r7._f0.set(0x2580000);
    r7._f4.set(0x2700000);
    r7._f8.set(0x3300000);
    r6.pos_08.set(0x2340000, 0, 0x2b30000);
    FUN_200986c();
    sleep(0x1);
    r3._1c0.set(0x209);
    r3._1c8.set(0x40);
    FUN_2009a3c();
    boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
    FUN_2009a4c();
    sleep(0x1e);
    FUN_2009a5c();
    FUN_2009a6c();
    FUN_2009a54();
    setActorAnimationAndWaitUntilFinished(0x8, 0x4);
    FUN_20099c4(0xe54);
    FUN_20099dc(0x9008, 0, 0x3c);
    FUN_200999c(0, 0x2);
    FUN_2009904(0x28);
    FUN_200999c(0x8, 0x1);
    FUN_2009904(0x28);
    FUN_20099dc(0x9008, 0, 0x14);
    FUN_200999c(0, 0x2);
    FUN_200988c(0x7);
    FUN_2009904(0x14);
    FUN_2009884(0x8);
    setActorVelocityScalerAndAcceleration(0, 0x10000, 0x8000);
    setActorAnimationIfLoaded(0, 0x13);
    FUN_200995c(0, 0x22d, 0x2a7);
    FUN_200988c(0x8);
    FUN_2009884(0x9);
    FUN_200995c(0, 0x22b, 0x2a8);
    FUN_2009904(0x1e);
    FUN_20099ec(0x8, 0xd000, 0);
    FUN_20098a4(getMapActor(0), 0x1);
    FUN_200998c(0, 0x4, 0);
    FUN_200996c(0, 0x21f, 0x2a2);
    setActorPriority(0, 0x3);
    FUN_20099ec(0, 0x4000, 0x28);
    setActorAnimationAndWaitUntilFinished(0x8, 0x4);
    FUN_2009904(0x14);
    FUN_20099d4(0x9008, 0);
    FUN_20097e4();
    FUN_2009994(0x8, 0x2);
    FUN_20099dc(0x9008, 0, 0x14);
    getMapActor(0x8)._5a.and(0xfe);
    FUN_200996c(0x8, 0x21e, 0x2a8);
    FUN_2009904(0x1);
    getMapActor(0x8)._5a.or(0x1);
    FUN_2009904(0xa);
    FUN_200999c(0x8, 0x2);
    addLayerToSpriteIfRegularSprite(getMapActor(0), 0xe2);
    setFlag(0x21);
    playSound(0x7e);
    FUN_20099b4(0, 0x7);
    FUN_2009904(0xa);
    FUN_20099b4(0, 0);
    FUN_2009904(0x14);
    getMapActor(0x8)._5a.add(0xfe);
    FUN_200996c(0x8, 0x216, 0x2b0);
    FUN_2009904(0x1);
    getMapActor(0x8)._5a.or(0x1);
    FUN_2009904(0x14);
    setActorVelocityScalerAndAcceleration(0x8, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(0, 0x18000, 0xc000);
    FUN_2009a14(0x8, 0x1);
    getMapActor(0).flags_23.or(0x1);
    FUN_200993c(0x8, 0x2009ab4);
    FUN_2009904(0x14);
    FUN_200993c(0, 0x2009ab4);
    FUN_2009944(0x8);
    FUN_200996c(0x8, 0x1a3, 0x295);
    FUN_200996c(0x8, 0x198, 0x295);
    setActorAnimationIfLoaded(0x8, 0x1);
    setActorAnimationIfLoaded(0, 0x1);
    FUN_20099ec(0x8, 0x4000, 0xa);
    FUN_20099cc(0x8008);

    if(FUN_2009924(0, 0) == 0) {
      r3._1d8.incr();
    }

    //LAB_200895a
    FUN_2009904(0x14);
    FUN_20099dc(0x8008, 0, 0x14);
    setActorAnimationIfLoaded(0, 0x3);
    setActorAnimationAndWaitUntilFinished(0x8, 0x3);
    FUN_2009904(0x14);
    FUN_200993c(0x8, 0x2009b04);
    FUN_200993c(0, 0x2009b34);
    FUN_2009904(0x14);
    r3._1c0.set(0x201);
    r3._1c8.set(0x10);
    FUN_2009a64();
    FUN_2009a6c();
    FUN_2009a34(0x14);
  }

  /** This is the cutscene code for going downstairs in the first cutscene */
  @Method(0x2008a0c)
  public static void FUN_2008a0c() {
    final Actor70 r5 = getMapActor(0xa);
    final Sprite38 r6 = r5.sprite_50.deref();
    FUN_200990c();
    FUN_2009974(0xb, 0x0, 0x0);
    FUN_2009974(0xc, 0x0, 0x0);
    FUN_2009974(0xd, 0x0, 0x0);
    FUN_2009974(0xe, 0x0, 0x0);
    FUN_2009974(0xf, 0x0, 0x0);
    FUN_2009974(0x10, 0x0, 0x0);
    FUN_2009974(0x8, 0x1af0000, 0x1870000);
    FUN_2009974(0xa, 0x1cf0000, 0x1940000);
    FUN_20098a4(getMapActor(0xa), 0);
    r5.flags_23.and(0xfe);
    r5._55.set(0);
    r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
    FUN_200993c(0xa, 0x2009cec);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(0x201);
    FUN_200987c(0x53, 0xf, 0x53, 0x13, 0x5, 0x4);
    FUN_200987c(0x5a, 0x10, 0x5a, 0x14, 0x5, 0x4);
    FUN_200987c(0x4d, 0x17, 0x52, 0x17, 0x5, 0x7);
    FUN_200987c(0x53, 0x21, 0x55, 0x21, 0x2, 0x2);
    FUN_200987c(0x5b, 0x1c, 0x5a, 0x1c, 0x1, 0x1);
    FUN_200987c(0x5b, 0x1c, 0x58, 0x1e, 0x1, 0x1);
    FUN_200987c(0x5e, 0x1b, 0x5e, 0x17, 0x6, 0x4);
    FUN_200987c(0x5c, 0x1c, 0x57, 0x17, 0x4, 0x4);
    FUN_200987c(0x41, 0x35, 0x58, 0x18, 0x2, 0x2);
    FUN_2009894();
    GPU.BLDCNT.setu(0x3f42);
    GPU.BLDALPHA.setu(0x100c);
    FUN_2009a3c();
    boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
    FUN_2009a4c();
    sleep(0x1e);
    FUN_2009a14(0x8, 0x1);
    setActorVelocityScalerAndAcceleration(0x8, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(0x0, 0x18000, 0xc000);
    setActorVelocityScalerAndAcceleration(0x9, 0x18000, 0xc000);
    FUN_200993c(0x0, 0x2009bb4);
    FUN_200993c(0x8, 0x2009b78);
    FUN_2009a5c();
    FUN_2009944(0x8);
    playSound(0x9e);
    FUN_2009a04(0x8, 0x100, 0x0);
    FUN_200999c(0x8, 0x2);
    FUN_20099ec(0x8, 0x4000, 0xa);
    FUN_2009a1c(0x40000, 0x8000);
    FUN_2009a24(0x19e0000, -1, 0x2120000, 1);
    FUN_2009974(0x9, 0x19e0000, 0x2120000);
    FUN_200996c(0x9, 0x1ab, 0x1e3);
    FUN_2009a2c();
    FUN_20099c4(0xe5b);
    FUN_20099dc(0x8009, 0x0, 0xa);
    FUN_2009a1c(0x18000, 0x3000);
    FUN_2009a24(0x1e00000, -1, 0x1bc0000, 0x1);
    FUN_2009a2c();
    FUN_2009904(0x14);
    FUN_20099ec(0x8, 0x8000, 0x14);
    setActorAnimationIfLoaded(0x8, 0x3);
    setActorAnimationAndWaitUntilFinished(0x0, 0x3);
    setActorAnimationAndWaitUntilFinished(0x9, 0x3);
    FUN_2009964(0x9, 0x19f, 0x24d);
    FUN_2009904(0xa);
    FUN_200993c(0x8, 0x2009c04);
    FUN_200993c(0x0, 0x2009c54);
    playSound(0xea);
    FUN_2009904(0x14);
    FUN_200993c(0xa, 0x2009d38);

    //LAB_2008cc0
    for(int i = 0; i < 4; i++) {
      GPU.BLDALPHA.setu(0x100e + i);
      sleep(0x1);
    }

    playSound(0xca);
    sleep(0xa);

    //LAB_2008ce4
    for(int i = 0; i < 0x10; i++) {
      GPU.BLDALPHA.setu(0x100f - i);
      sleep(0x1);
    }

    FUN_2009944(0x0);
    setActorAnimationIfLoaded(0x8, 0x1);
    FUN_2009994(0x8, 0x2);
    FUN_200999c(0x0, 0x2);
    FUN_2009904(0xa);
    FUN_20099ec(0x8, 0xc000, 0x0);
    FUN_20099ec(0x0, 0xc000, 0x14);
    FUN_2009a0c(0x8, 0x102);
    FUN_2009a0c(0x0, 0x102);
    FUN_2009904(0x50);
    FUN_2009974(0x9, 0x0, 0x0);
    FUN_20099ac(0x8, 0x0, 0x14);
    setActorAnimationIfLoaded(0x8, 0x3);
    setActorAnimationAndWaitUntilFinished(0x0, 0x3);
    FUN_2009904(0x28);
    FUN_2009a1c(0xcccc, 0x1999);
    FUN_2009a14(0x8, 0x1);
    FUN_200993c(0x8, 0x2009ca4);
    FUN_200994c(0x0, 0x2009ca4);

    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x100);
    r1._1c8.set(0x20);

    FUN_2009a64();
    FUN_2009a6c();
    FUN_2009a34(0x15);
  }

  @Method(0x20093b4)
  public static void FUN_20093b4() {
    FUN_200987c(0x16, 0x55, 0x19, 0x55, 0x2, 0x2);
    FUN_200989c(0x19, 0xf, 0x2, 0x2, 0x19, 0x19);
  }

  @Method(0x20097e4)
  public static void FUN_20097e4() {
    FUN_2009a7c(0x94, 0x1);
    FUN_2009a84(8, 17);
    FUN_2009a9c();
    FUN_2009a74(0x1);
    FUN_2009a8c();
    FUN_2009a94();
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x2009814)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  @Method(0x20093e4)
  public static void FUN_20093e4() {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun#FUN_8009128} */
  @Method(0x200986c)
  public static void FUN_200986c() {
    MEMORY.call(0x8009128);
  }

  /** {@link GoldenSun#FUN_8009180} */
  @Method(0x200987c)
  public static void FUN_200987c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_8009188} */
  @Method(0x2009884)
  public static void FUN_2009884(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  /** {@link GoldenSun#FUN_80091a0} */
  @Method(0x2009894)
  public static void FUN_2009894() {
    MEMORY.call(0x80091a0);
  }

  /** {@link GoldenSun#FUN_80091c0} */
  @Method(0x200989c)
  public static void FUN_200989c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x20098a4)
  public static void FUN_20098a4(final Actor70 actor, final int r1) {
    MEMORY.call(0x80091e0, actor, r1);
  }

  /** {@link GoldenSun#FUN_80091f0} */
  @Method(0x20098ac)
  public static void FUN_20098ac(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  /** {@link GoldenSun#FUN_8009190} */
  @Method(0x200988c)
  public static void FUN_200988c(final int r0) {
    MEMORY.call(0x8009190, r0);
  }

  /** {@link GoldenSun#FUN_8009208} */
  @Method(0x20098b4)
  public static void FUN_20098b4() {
    MEMORY.call(0x8009208);
  }

  /** {@link GoldenSun#FUN_8009210} */
  @Method(0x20098bc)
  public static void FUN_20098bc() {
    MEMORY.call(0x8009210);
  }

  /** {@link GoldenSun#addLayerToSpriteIfRegularSprite_} */
  @Method(0x20098c4)
  public static void addLayerToSpriteIfRegularSprite(final Actor70 actor, final int spriteIndex) {
    MEMORY.call(0x8009228, actor, spriteIndex);
  }

  /** {@link GoldenSun_801#FUN_8015210} */
  @Method(0x20098dc)
  public static void FUN_20098dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
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
  public static void FUN_2009904(final int r0) {
    MEMORY.call(0x808a010, r0);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200990c)
  public static void FUN_200990c() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a03c} */
  @Method(0x200991c)
  public static void FUN_200991c(final int r0) {
    MEMORY.call(0x808a03c, r0);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x2009924)
  public static int FUN_2009924(final int r0, final int r1) {
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
  public static void FUN_200993c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a098, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0a0} */
  @Method(0x2009944)
  public static void FUN_2009944(final int actorIndex) {
    MEMORY.call(0x808a0a0, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a0b0} */
  @Method(0x200994c)
  public static void FUN_200994c(final int mapActorIndex, final int r1) {
    MEMORY.call(0x808a0b0, mapActorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0c0} */
  @Method(0x200995c)
  public static void FUN_200995c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x2009964)
  public static void FUN_2009964(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200996c)
  public static void FUN_200996c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0d0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x2009974)
  public static void FUN_2009974(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, actorIndex, x, z);
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
  public static void FUN_200998c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a128, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a130} */
  @Method(0x2009994)
  public static void FUN_2009994(final int actorIndex, final int r1) {
    MEMORY.call(0x808a130, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200999c)
  public static void FUN_200999c(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x20099ac)
  public static void FUN_20099ac(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a150, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a158} */
  @Method(0x20099b4)
  public static void FUN_20099b4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a158, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x20099c4)
  public static void FUN_20099c4(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x20099cc)
  public static Panel24 FUN_20099cc(final int r0) {
    return (Panel24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x20099d4)
  public static void FUN_20099d4(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x20099dc)
  public static void FUN_20099dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a188, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1b8} */
  @Method(0x20099ec)
  public static void FUN_20099ec(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1d8} */
  @Method(0x20099f4)
  public static void FUN_20099f4(final int r0) {
    MEMORY.call(0x808a1d8, r0);
  }

  /** {@link GoldenSun_808#setActorPriority_} */
  @Method(0x20099fc)
  public static void setActorPriority(final int actorIndex, final int priority) {
    MEMORY.call(0x808a1e0, actorIndex, priority);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x2009a04)
  public static void FUN_2009a04(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, r0, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x2009a0c)
  public static void FUN_2009a0c(final int r0, final int r1) {
    MEMORY.call(0x808a1f0, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a200} */
  @Method(0x2009a14)
  public static void FUN_2009a14(final int r0, final int r1) {
    MEMORY.call(0x808a200, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x2009a1c)
  public static void FUN_2009a1c(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x808a208, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x2009a24)
  public static void FUN_2009a24(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x808a210, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_808#FUN_808a218} */
  @Method(0x2009a2c)
  public static void FUN_2009a2c() {
    MEMORY.call(0x808a218);
  }

  /** {@link GoldenSun_808#FUN_808a248} */
  @Method(0x2009a34)
  public static void FUN_2009a34(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x2009a3c)
  public static void FUN_2009a3c() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d0} */
  @Method(0x2009a44)
  public static void FUN_2009a44() {
    MEMORY.call(0x808a2d0);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x2009a4c)
  public static void FUN_2009a4c() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x2009a54)
  public static void FUN_2009a54() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x2009a5c)
  public static void FUN_2009a5c() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a368} */
  @Method(0x2009a64)
  public static void FUN_2009a64() {
    MEMORY.call(0x808a368);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x2009a6c)
  public static void FUN_2009a6c() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a420} */
  @Method(0x2009a74)
  public static void FUN_2009a74(final int r0) {
    MEMORY.call(0x808a420, r0);
  }

  /** {@link GoldenSun_808#FUN_808a428} */
  @Method(0x2009a7c)
  public static void FUN_2009a7c(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a430} */
  @Method(0x2009a84)
  public static void FUN_2009a84(final int actorIndex1, final int actorIndex2) {
    MEMORY.call(0x808a430, actorIndex1, actorIndex2);
  }

  /** {@link GoldenSun_808#FUN_808a438} */
  @Method(0x2009a8c)
  public static void FUN_2009a8c() {
    MEMORY.call(0x808a438);
  }

  /** {@link GoldenSun_808#FUN_808a440} */
  @Method(0x2009a94)
  public static void FUN_2009a94() {
    MEMORY.call(0x808a440);
  }

  /** {@link GoldenSun_808#FUN_808a448} */
  @Method(0x2009a9c)
  public static void FUN_2009a9c() {
    MEMORY.call(0x808a448);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x2009aac)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
