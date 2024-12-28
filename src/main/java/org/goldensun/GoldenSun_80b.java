package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.IntRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Menua70;
import org.goldensun.types.Panel24;
import org.goldensun.types.RecoveryQueue10c;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Structccc;
import org.goldensun.types.Unit14c;
import org.goldensun.types.Vec3;

import static org.goldensun.GoldenSun.FUN_80037d4;
import static org.goldensun.GoldenSun.FUN_800393c;
import static org.goldensun.GoldenSun.FUN_80039fc;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_80040b4;
import static org.goldensun.GoldenSun.FUN_80040d0;
import static org.goldensun.GoldenSun.FUN_800488c;
import static org.goldensun.GoldenSun.FUN_80048a0;
import static org.goldensun.GoldenSun.FUN_80049ac;
import static org.goldensun.GoldenSun.FUN_8004bd4;
import static org.goldensun.GoldenSun.FUN_8004c1c;
import static org.goldensun.GoldenSun.FUN_8004cb4;
import static org.goldensun.GoldenSun.FUN_8009070;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.FUN_8009098;
import static org.goldensun.GoldenSun.FUN_8009270;
import static org.goldensun.GoldenSun.addLayerToSprite_;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearTickCallbacks;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.disableTickCallback;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.initActors_;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadActor_;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.waitForFade;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSun_801.FUN_8015008;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_80150b0;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015118;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015128;
import static org.goldensun.GoldenSun_801.FUN_8015130;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80151c8;
import static org.goldensun.GoldenSun_801.FUN_8015218;
import static org.goldensun.GoldenSun_801.FUN_80153b0;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawIcon;
import static org.goldensun.GoldenSun_807.FUN_8077078;
import static org.goldensun.GoldenSun_807.FUN_80770e0;
import static org.goldensun.GoldenSun_807.FUN_8077140;
import static org.goldensun.GoldenSun_807.lcgRand_;
import static org.goldensun.GoldenSun_807.FUN_80771c8;
import static org.goldensun.GoldenSun_807.FUN_80771e0;
import static org.goldensun.GoldenSun_807.FUN_8077210;
import static org.goldensun.GoldenSun_807.FUN_8077228;
import static org.goldensun.GoldenSun_807.FUN_8077230;
import static org.goldensun.GoldenSun_807.FUN_807822c;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.recoverDjinn_;
import static org.goldensun.GoldenSun_807.setDjinn_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a360;
import static org.goldensun.GoldenSun_808.FUN_808a368;
import static org.goldensun.GoldenSun_808.FUN_808a370;
import static org.goldensun.GoldenSun_808.FUN_808a4a0;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_809.FUN_80915ac;
import static org.goldensun.GoldenSun_809.getMapActor_;
import static org.goldensun.GoldenSun_80a.FUN_80a1038;
import static org.goldensun.GoldenSun_80c.FUN_80c02a4;
import static org.goldensun.GoldenSun_80c.FUN_80c08a8;
import static org.goldensun.GoldenSun_80c.FUN_80c08e0;
import static org.goldensun.GoldenSun_80c.FUN_80c08ec;
import static org.goldensun.GoldenSun_80c.FUN_80c0a24;
import static org.goldensun.GoldenSun_80c.FUN_80c0cec;
import static org.goldensun.GoldenSun_80c.FUN_80c1ffc;
import static org.goldensun.GoldenSun_80c.FUN_80c2384;
import static org.goldensun.GoldenSun_80c.FUN_80c23a0;
import static org.goldensun.GoldenSun_80c.FUN_80c23c0;
import static org.goldensun.GoldenSun_80c.FUN_80c24b0;
import static org.goldensun.GoldenSun_80c.FUN_80c2724;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.GoldenSun_818.getSpriteData;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  /** {@link GoldenSun_80b#FUN_80b0278} */
  @Method(0x80b0008)
  public static int FUN_80b0008(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b0278, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b3284} */
  @Method(0x80b0018)
  public static int FUN_80b0018(final int r0, final int mapActorIndex) {
    return (int)MEMORY.call(0x80b3284, r0, mapActorIndex);
  }

  /** {@link GoldenSun_80b#FUN_80b08b8} */
  @Method(0x80b0020)
  public static void FUN_80b0020(final int r0) {
    MEMORY.call(0x80b08b8, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b0958} */
  @Method(0x80b0028)
  public static void FUN_80b0028(final int r0) {
    MEMORY.call(0x80b0958, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b09fc} */
  @Method(0x80b0030)
  public static void FUN_80b0030(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80b09fc, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_80b#FUN_80b0a20} */
  @Method(0x80b0038)
  public static void FUN_80b0038(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b0a20, r0, r1, r2);
  }

  /** {@link GoldenSun_80b#FUN_80b06c0} */
  @Method(0x80b0040)
  public static void FUN_80b0040(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b06c0, r0, r1, r2);
  }

  @Method(0x80b010c)
  public static void FUN_80b010c() {
    int r0;

    CPU.sp().value -= 0x4;
    final int r5 = mallocSlotChip(55, 0xa70);
    FUN_808e118();
    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x8500029c);
    MEMORY.ref(1, r5 + 0x3a8).setu(12);
    MEMORY.ref(1, r5 + 0x3a7).setu(getPartyMemberIds_(r5 + 0x36e));
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x390).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3940);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x392).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3b40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x394).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3bc0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x396).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b39c0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x39a).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3a40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x398).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3ac0);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b00f4"), 0xc80);
    CPU.sp().value += 0x4;
  }

  @Method(0x80b0204)
  public static void FUN_80b0204() {
    final int r5 = MEMORY.ref(4, 0x3001f2c).get();
    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b00f4"));
    FUN_8015140();
    clearVramSlot(MEMORY.ref(2, r5 + 0x390).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x392).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x394).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x396).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x398).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x39a).getUnsigned());
    freeSlot(55);
  }

  @Method(0x80b0278)
  public static int FUN_80b0278(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b04c4)
  public static void FUN_80b04c4() {
    //LAB_80b04ce
    while(FUN_80f9048() != 0) {
      //LAB_80b04c8
      sleep(1);
    }
  }

  @Method(0x80b04dc)
  public static void FUN_80b04dc(final int r0) {
    int r5 = r0;
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r7 = FUN_80915ac(r6._3a4.get());
    FUN_8015140();

    final int r1 = r6._3a9.get();
    if(r1 == 2) {
      r5 = r5 + 0x2b;
    }

    //LAB_80b050a
    if(r1 == 0) {
      r5 = r5 + 0x56;
    }

    //LAB_80b0516
    if(r6._3ac.get() != 0) {
      r5 = r5 + 0xb1;
    }

    //LAB_80b052e
    FUN_8015038(r5, 5, 0, r7 << 16 | 0x22);

    //LAB_80b0546
    while(FUN_8015048() == 0) {
      //LAB_80b0540
      sleep(1);
    }

    sleep(1);
  }

  @Method(0x80b0634)
  public static int FUN_80b0634(final int defaultOption) {
    final GraphicsStruct1c r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._380.deref();
    final int r6 = r3._05.get();
    FUN_80a1038(r3);
    final int ret = FUN_80153b0(7, 5, defaultOption);
    r3._05.set(r6);
    return ret;
  }

  @Method(0x80b06c0)
  public static void FUN_80b06c0(int r0, int r1, final int r2) {
    int r3;
    int r4;

    r3 = r1 << 4;
    r1 = r3 + 0x1;
    if(r0 > 0x0) {
      r4 = 0x80b4100;

      //LAB_80b06cc
      do {
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r0 = r0 - 0x1;
        r3 = r2 + r3;
        r4 = r4 + 0x2;
        MEMORY.ref(1, r3 + 0x4).setu(r1);
        MEMORY.ref(1, r3 + 0x8).setu(r1);
        MEMORY.ref(1, r3 + 0xc).setu(r1);
        MEMORY.ref(1, r3 + 0x10).setu(r1);
        MEMORY.ref(1, r3 + 0x14).setu(r1);
        MEMORY.ref(1, r3 + 0x18).setu(r1);
      } while(r0 != 0x0);
    }
  }

  @Method(0x80b08b8)
  public static void FUN_80b08b8(final int r0) {
    if(r0 != 0) {
      final int r10 = MEMORY.ref(1, r0 + 0xd).get();
      if(r10 != 0) {
        final int r8 = MEMORY.ref(4, r0).get();
        MEMORY.ref(1, r0 + 0xc).incr();
        MEMORY.ref(2, r8 + 0x6).setu(MEMORY.ref(2, r0 + 0x4).getUnsigned() + divideS(MEMORY.ref(1, r0 + 0xc).get() * MEMORY.ref(2, r0 + 0x8).get() - MEMORY.ref(2, r0 + 0x4).get(), CPU.r10().value));
        MEMORY.ref(2, r8 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r8 + 0x6).getUnsigned() & 0x1ff);
        final int r5 = MEMORY.ref(2, r0 + 0x6).getUnsigned() + divideS(MEMORY.ref(1, r0 + 0xc).get() * (MEMORY.ref(2, r0 + 0xa).get() - MEMORY.ref(2, r0 + 0x6).get()), CPU.r10().value);
        MEMORY.ref(2, r8 + 0x8).setu(r5);
        MEMORY.ref(1, r8 + 0x14).setu(r5);

        if(MEMORY.ref(1, r0 + 0xc).get() == r10) {
          MEMORY.ref(1, r0 + 0xd).setu(0);
          MEMORY.ref(1, r0 + 0xc).setu(0);
        }
      }
    }

    //LAB_80b094a
  }

  @Method(0x80b0958)
  public static void FUN_80b0958(int r0) {
    int r2;
    int r3;
    final int r4;
    final int r5;

    r5 = r0;
    r4 = MEMORY.ref(4, r5).get();
    if(r4 != 0) {
      r2 = MEMORY.ref(2, r4 + 0x6).getUnsigned();
      r0 = r2 - MEMORY.ref(2, r5 + 0x8).get();
      r3 = Math.abs(r0 / 4);

      //LAB_80b097a
      if(r0 > 0) {
        if(r3 != 0) {
          r3 = r2 - r3;
        } else {
          //LAB_80b0986
          r3 = r2 - 1;
        }

        MEMORY.ref(2, r4 + 0x6).setu(r3);
        MEMORY.ref(2, r4 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r4 + 0x6).getUnsigned() & 0x1ff);
      } else {
        //LAB_80b098c
        if(r0 < 0) {
          if(r3 != 0) {
            r3 = r2 + r3;
          } else {
            //LAB_80b0998
            r3 = r2 + 1;
          }

          //LAB_80b099a
          MEMORY.ref(2, r4 + 0x6).setu(r3);
          MEMORY.ref(2, r4 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r4 + 0x6).getUnsigned() & 0x1ff);
        }
      }

      //LAB_80b09ac
      r2 = MEMORY.ref(2, r4 + 0x8).getUnsigned();
      r0 = r2 - MEMORY.ref(2, r5 + 0xa).get();
      r3 = Math.abs(r0 / 4);

      //LAB_80b09c4
      if(r0 > 0) {
        if(r3 != 0) {
          r3 = r2 - r3;
        } else {
          //LAB_80b09d0
          r3 = r2 - 1;
        }

        MEMORY.ref(2, r4 + 0x8).setu(r3);
        MEMORY.ref(1, r4 + 0x14).setu(MEMORY.ref(2, r4 + 0x8).getUnsigned());
      } else {
        //LAB_80b09d6
        if(r0 < 0) {
          if(r3 != 0) {
            r3 = r2 + r3;
          } else {
            //LAB_80b09e2
            r3 = r2 + 1;
          }

          //LAB_80b09e4
          MEMORY.ref(2, r4 + 0x8).setu(r3);
          MEMORY.ref(1, r4 + 0x14).setu(MEMORY.ref(2, r4 + 0x8).getUnsigned());
        }
      }
    }

    //LAB_80b09ea
  }

  @Method(0x80b09fc)
  public static void FUN_80b09fc(final int r0, final int r1, final int r2, final int r3) {
    final int r5 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r0 + 0x4).setu(MEMORY.ref(2, r5 + 0x6).getUnsigned());
    MEMORY.ref(2, r0 + 0x6).setu(MEMORY.ref(2, r5 + 0x8).getUnsigned());
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(1, r0 + 0xd).setu(r3);
    MEMORY.ref(1, r0 + 0xc).setu(0);
  }

  @Method(0x80b0a20)
  public static void FUN_80b0a20(final int r0, final int r1, final int r2) {
    final int r5 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r5 + 0x6).setu(r1);
    MEMORY.ref(2, r5 + 0x8).setu(r2);
    MEMORY.ref(1, r5 + 0x14).setu(r2 & 0xffff);
    MEMORY.ref(2, r5 + 0x16).and(0xfffffe00).oru(r1 & 0x1ff);
    MEMORY.ref(1, r0 + 0xd).setu(0x1);
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0x4).setu(r1);
    MEMORY.ref(1, r0 + 0xc).setu(0);
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(2, r0 + 0x6).setu(r2);
  }

  @Method(0x80b10cc)
  public static void FUN_80b10cc() {
    final Menua70 r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Panel24 r5 = r3.panel_0c.derefNullable();

    if(r5 != null) {
      drawIcon(0xc8a, r5, 0, 0);
      FUN_80150b0(MEMORY.ref(4, 0x2000250).get(), 6, r5, 32, 8);
    }

    //LAB_80b10f8
  }

  @Method(0x80b3210)
  public static int FUN_80b3210(final int r0) {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r10 = MEMORY.ref(1, 0x80b4ab6 + r0).get();
    int r2 = 0;

    //LAB_80b323e
    for(int r7 = 0; r7 < r6._3a7.get(); r7++) {
      if(getCharOrMonsterData_(MEMORY.ref(2, r6._36c.getAddress() + r7 * 0x2 + 0x2).get()).hp_38.get() != 0) { //TODO
        r2++;
      }
    }

    //LAB_80b3266
    return r10 * r2;
  }

  @Method(0x80b3284)
  public static int FUN_80b3284(final int r0, final int mapActorIndex) {
    FUN_80b010c();
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r5._3a9.set(1);
    if(r0 == 5) {
      r5._3ac.set(1);
    }

    //LAB_80b32ae
    r5._3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
    Panel24 r8 = FUN_80150f8(r5._3a4.get(), 0, 0, 0);
    final int r6 = FUN_80b3210(r0);
    FUN_8015120(r6, 5);
    FUN_80b04dc(0xd1c);
    r5.panel_0c.set(addPanel_(0, 16, 12, 4, 2));
    FUN_80b10cc();

    if(FUN_80b0634(0) != 0) {
      FUN_80b04dc(0xd1f);
      FUN_8015018(r5.panel_0c.deref(), 2);
      //LAB_80b330e
    } else if((r6 & 0xffff_ffffL) > (MEMORY.ref(4, 0x2000250).get() & 0xffff_ffffL)) {
      FUN_80b04dc(0xd1e);
      FUN_8015018(r5.panel_0c.deref(), 2);
    } else {
      //LAB_80b3328
      FUN_8015018(r5.panel_0c.deref(), 2);
      FUN_80b04dc(0xd1d);
      FUN_8015018(r8, 2);
      FUN_80b3398(r6);
      r5._3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
      r8 = FUN_80150f8(r5._3a4.get(), 0, 0, 0);
      FUN_80b04dc(0xd20);
    }

    //LAB_80b336a
    FUN_8015018(r8, 2);
    FUN_80b0204();
    return 0;
  }

  @Method(0x80b3398)
  public static void FUN_80b3398(final int r0) {
    CPU.sp().value -= 0x10;
    final int r8 = CPU.sp().value;
    final int r7 = getPartyMemberIds_(r8);
    FUN_8077230(-r0);

    //LAB_80b33c0
    for(int r5 = 0; r5 < r7; r5++) {
      final Unit14c unit = getCharOrMonsterData_(MEMORY.ref(2, r8 + r5 * 0x2).get());
      if(unit.hp_38.get() != 0) {
        unit.hp_38.set(unit.maxHp_34.get());
        unit.pp_3a.set(unit.maxPp_36.get());
        FUN_807822c(MEMORY.ref(2, r8 + r5 * 0x2).get());
      }
    }

    //LAB_80b33e8
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x209);
    r1._1c8.set(60);
    sleep(20);
    FUN_808a368();
    FUN_808a370();
    playSound_(0x56);
    FUN_80b04c4();
    sleep(10);
    FUN_808a360();
    FUN_808a370();
    sleep(30);
    r1._1c8.set(16);
    CPU.sp().value += 0x10;
  }

  /** {@link GoldenSun_80b#FUN_80b7b6c} */
  @Method(0x80b5010)
  public static void FUN_80b5010(final int r0, final int r1) {
    MEMORY.call(0x80b7b6c, r0, r1);
  }

  /** {@link GoldenSun_80c#FUN_80c0cec} */
  @Method(0x80b5028)
  public static void FUN_80b5028(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80c0cec, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_80c#FUN_80c0774} */
  @Method(0x80b5038)
  public static void FUN_80b5038(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80c0774, r0, r1, r2);
  }

  /** {@link GoldenSun_80c#FUN_80c08ec} */
  @Method(0x80b5040)
  public static void FUN_80b5040(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80c08ec, r0, r1, r2);
  }

  /** {@link GoldenSun_80c#FUN_80c0700} */
  @Method(0x80b5048)
  public static void FUN_80b5048(final int r0, final int r1) {
    MEMORY.call(0x80c0700, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b8228} */
  @Method(0x80b5088)
  public static void FUN_80b5088(final int r0, final int r1) {
    MEMORY.call(0x80b8228, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b6c08} */
  @Method(0x80b5090)
  public static int FUN_80b5090(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b6c08, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b7dd0} */
  @Method(0x80b5098)
  public static int FUN_80b5098(final int r0) {
    return (int)MEMORY.call(0x80b7dd0, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b63c8} */
  @Method(0x80b50a0)
  public static int FUN_80b50a0(final int r0) {
    return (int)MEMORY.call(0x80b63c8, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b7f20} */
  @Method(0x80b50a8)
  public static int FUN_80b50a8(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b7f20, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b845c} */
  @Method(0x80b50b0)
  public static int FUN_80b50b0(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b845c, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b6a60} */
  @Method(0x80b50c8)
  public static int FUN_80b50c8(final int r0) {
    return (int)MEMORY.call(0x80b6a60, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b8fd4} */
  @Method(0x80b50d0)
  public static void FUN_80b50d0(final int r0) {
    MEMORY.call(0x80b8fd4, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b7f70} */
  @Method(0x80b50d8)
  public static Sprite38 FUN_80b50d8(final int r0, final int r1) {
    return (Sprite38)MEMORY.call(0x80b7f70, r0, r1);
  }

  /** {@link GoldenSun_80c#FUN_80c10e8} */
  @Method(0x80b50e0)
  public static void FUN_80b50e0(final int r0, final int r1) {
    MEMORY.call(0x80c10e8, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80bd7dc} */
  @Method(0x80b50e8)
  public static void FUN_80b50e8(final int r0) {
    MEMORY.call(0x80bd7dc, r0);
  }

  /** {@link GoldenSun_80b#FUN_80bf5a8} */
  @Method(0x80b50f8)
  public static int FUN_80b50f8() {
    return (int)MEMORY.call(0x80bf5a8);
  }

  /** {@link GoldenSun_80b#FUN_80b6cd0} */
  @Method(0x80b5100)
  public static int FUN_80b5100(final int r0) {
    return (int)MEMORY.call(0x80b6cd0, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b6c90} */
  @Method(0x80b5118)
  public static void FUN_80b5118() {
    MEMORY.call(0x80b6c90);
  }

  /** {@link GoldenSun_80b#FUN_80bb7c0} */
  @Method(0x80b5128)
  public static void FUN_80b5128(final int r0, final int r1) {
    MEMORY.call(0x80bb7c0, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80be0b4} */
  @Method(0x80b5130)
  public static int FUN_80b5130(final int r0, final int out) {
    return (int)MEMORY.call(0x80be0b4, r0, out);
  }

  @Method(0x80b5138)
  public static void FUN_80b5138(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    int address80b5138 = CPU.sp().value - 0x20;
    CPU.sp().value = address80b5138;
    address80b5138 += 0x4;
    address80b5138 += 0x4;
    address80b5138 += 0x4;
    MEMORY.ref(4, address80b5138).setu(CPU.r8().value);
    address80b5138 += 0x4;
    MEMORY.ref(4, address80b5138).setu(CPU.r9().value);
    address80b5138 += 0x4;
    MEMORY.ref(4, address80b5138).setu(CPU.r10().value);
    address80b5138 += 0x4;
    MEMORY.ref(4, address80b5138).setu(CPU.r11().value);
    address80b5138 += 0x4;
    MEMORY.ref(4, address80b5138).setu(CPU.lr().value);
    final int[] _80b5218 = new int[8];

    //LAB_80b5150
    for(int i = 0; i < 8; i++) {
      _80b5218[i] = MEMORY.ref(4, 0x80b5238 + i * 0x4).getUnsigned();
    }

    CPU.r11().value = 0x7;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r0 = r0 + 0x2;
    r2 = 0x0;
    r5 = 0x0;
    CPU.r9().value = 0xf;
    final int address80b5178 = 0x80b5180 + 0x84;
    CPU.r10().value = MEMORY.ref(4, address80b5178).getUnsigned();

    //LAB_80b517c
    do {
      CPU.r8().value = 0x8;

      //LAB_80b5180
      do {
        r7 = 0x20;

        //LAB_80b5184
        do {
          final IntRef r0ref = new IntRef().set(r0);
          final IntRef r2ref = new IntRef().set(r2);
          final IntRef r3ref = new IntRef().set(r3);
          final IntRef r5ref = new IntRef().set(r5);
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r5ref.get() >>> 25;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 17;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 9;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 1;
          r6 = r6 + CPU.r10().value;
          final int address80b51a8 = r1;
          MEMORY.ref(4, address80b51a8).setu(r6);
          r1 = r1 + 0x4;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r5ref.get() >>> 25;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 17;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 9;
          FUN_80b520c(_80b5218, r0ref, r2ref, r3ref, r5ref);
          r6 = r6 | r5ref.get() >>> 1;
          r6 = r6 + CPU.r10().value;
          final int address80b51d0 = r1;
          MEMORY.ref(4, address80b51d0).setu(r6);
          r1 = r1 + 0x3c;

          r0 = r0ref.get();
          r2 = r2ref.get();
          r3 = r3ref.get();
          r5 = r5ref.get();

          r7 = CPU.subA(r7, 0x1);
        } while(!CPU.cpsr().getZero()); // !=

        r1 = r1 - 0x800;
        r1 = r1 + 0x8;
        CPU.r8().value = CPU.subA(CPU.r8().value, 0x1);
      } while(!CPU.cpsr().getZero()); // !=

      r1 = r1 - 0x40;
      r1 = r1 + 0x800;
      CPU.r9().value = CPU.subA(CPU.r9().value, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    int address80b51fc = CPU.sp().value;
    address80b51fc += 0x4;
    address80b51fc += 0x4;
    address80b51fc += 0x4;
    CPU.r8().value = MEMORY.ref(4, address80b51fc).getUnsigned();
    address80b51fc += 0x4;
    CPU.r9().value = MEMORY.ref(4, address80b51fc).getUnsigned();
    address80b51fc += 0x4;
    CPU.r10().value = MEMORY.ref(4, address80b51fc).getUnsigned();
    address80b51fc += 0x4;
    CPU.r11().value = MEMORY.ref(4, address80b51fc).getUnsigned();
    address80b51fc += 0x4;
    CPU.lr().value = MEMORY.ref(4, address80b51fc).getUnsigned();
    address80b51fc += 0x4;
    CPU.sp().value = address80b51fc;
  }

  @Method(0x80b520c)
  public static void FUN_80b520c(final int[] _80b5218, final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = r3.get() & 0x7;
    MEMORY.call(_80b5218[CPU.r12().value], r0, r2, r3, r5);
  }

  @Method(0x80b5258)
  public static void FUN_80b5258(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    r3.shr(2);
    r2.sub(0x2);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b5274)
  public static void FUN_80b5274(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = r3.get() & 0x8;
    CPU.setCFlag((r3.get() & 0x1 << 3) != 0);
    r3.set(CPU.movA(0, r3.get() >>> 4));
    CPU.r12().value = CPU.r12().value + 0x8;
    r5.add(CPU.r12().value << 22);
    r2.sub(0x4);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b529c)
  public static void FUN_80b529c(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = r3.get() & 0x8;
    CPU.setCFlag((r3.get() & 0x1 << 3) != 0);
    r3.set(CPU.movA(0, r3.get() >>> 4));
    CPU.r12().value = CPU.r12().value + 0x8;
    r5.sub(CPU.r12().value << 22);
    r2.sub(0x4);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b52c4)
  public static void FUN_80b52c4(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = CPU.r11().value & r3.get() >>> 3;
    r3.shr(6);
    CPU.r12().value = CPU.r12().value + 0x3;
    r5.add(CPU.r12().value << 25);
    r2.sub(0x6);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b52ec)
  public static void FUN_80b52ec(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = CPU.r11().value & r3.get() >>> 3;
    r3.shr(6);
    CPU.r12().value = CPU.r12().value + 0x3;
    r5.sub(CPU.r12().value << 25);
    r2.sub(0x6);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b5314)
  public static void FUN_80b5314(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    CPU.r12().value = 0xf;
    CPU.setCFlag((r3.get() & 0x1 << 3) != 0);
    CPU.r12().value = CPU.andA(CPU.r12().value, r3.get() >>> 4);
    CPU.r12().value = CPU.r12().value + 0xb;
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.r12().value = -CPU.r12().value;
    }
    r5.add(CPU.r12().value << 25);
    r3.shr(8);
    r2.sub(8);
    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b5344)
  public static void FUN_80b5344(final IntRef r0, final IntRef r2, final IntRef r3, final IntRef r5) {
    r5.set(Integer.rotateRight(r3.get(), 10) & 0xfe000000);
    r3.shr(10);
    r2.sub(0xa);

    if(r2.get() < 0) {
      CPU.r12().value = MEMORY.ref(2, r0.get()).getUnsigned();
      r0.add(0x2);
      r2.add(0x10);
      r3.or(CPU.r12().value << r2.get());
    }
  }

  @Method(0x80b5864)
  public static void FUN_80b5864() {
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    r3 = 0x3001e80;
    r2 = r3;
    r6 = MEMORY.ref(4, r3).get();
    r3 = r3 - 0xc;
    r1 = MEMORY.ref(4, r3).get();
    r3 = r1;
    r3 = r3 + 0x44;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r2 = r2 + 0x80;
    CPU.sp().value -= 0x10;
    r7 = MEMORY.ref(4, r2).get();
    if(r3 != 0) {
      r3 = 0x3001f64;
      r2 = MEMORY.ref(2, r3).getUnsigned();
      r3 = 0x3;
      r3 = r3 & r2;
      if(r3 == 0x3) {
        //LAB_80b58a8
        r3 = 0x4000128;
        r2 = r1;
        r3 = MEMORY.ref(4, r3).get();
        r2 = r2 + 0x50;
        r3 = r3 << 26;
        r2 = MEMORY.ref(1, r2).getUnsigned();
        r3 = r3 >>> 30;
        if(r2 != r3) {
          r2 = r1;
          r2 = r2 + 0x52;
          r3 = 0x1;
          MEMORY.ref(1, r2).setu(r3);
        }

        //LAB_80b58c2
        r2 = r1;
        r2 = r2 + 0x51;
        r3 = 0x0;
        MEMORY.ref(1, r2).setu(r3);
      } else {
        r2 = r1 + 0x51;
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r3 = r3 + 0x1;
        MEMORY.ref(1, r2).setu(r3);
        r3 = r3 << 24;
        if((r3 & 0xffff_ffffL) > 0x18000000) {
          MEMORY.ref(1, r1 + 0x52).setu(1);
        }
      }
    }

    //LAB_80b58ca
    r3 = MEMORY.ref(4, r7 + 0x4).get();
    if(r3 != 0) {
      r3 = MEMORY.ref(4, r7).get();
      r1 = MEMORY.ref(2, r6 + 0x36).getUnsigned();
      r3 = r3 - r1;
      r3 = r3 << 16;
      r3 = r3 >> 16;
      r2 = r3;
      if(r3 < 0) {
        r2 = r2 + 0xf;
      }

      //LAB_80b58e2
      r3 = r2 >> 4;
      r3 = r1 + r3;
      MEMORY.ref(2, r6 + 0x36).setu(r3);
      r3 = MEMORY.ref(4, r7 + 0x4).get();
      r3 = r3 - 0x1;
      MEMORY.ref(4, r7 + 0x4).setu(r3);
    }

    //LAB_80b58ee
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    r5 = r6 + 0xc;
    if(r3 != 0) {
      r5 = r3;
    }

    //LAB_80b58fa
    FUN_80049ac();
    FUN_8004cb4(r5);
    FUN_8004c1c(MEMORY.ref(2, r6 + 0x36).get());
    FUN_8004bd4(MEMORY.ref(2, r6 + 0x34).get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, MEMORY.ref(4, r6 + 0x20).get()), r6);

    if(MEMORY.ref(4, r7 + 0x14).get() == 0) {
      FUN_80c0a24(0x780000, 0x780000, 0, 0, 0x10000);
    }

    //LAB_80b5942
    CPU.sp().value += 0x10;
  }

  @Method(0x80b595c)
  public static void FUN_80b595c(int r0) {
    int r1;
    int r3;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001e74;
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x10;
    r7 = r0;
    CPU.r10().value = r3;
    FUN_8015118();
    r6 = CPU.sp().value;
    r0 = r6;
    r0 = FUN_80b6ae0(r0);
    r5 = 0x0;
    if(r7 != 0) {
      r3 = r7 - 0x1;
      CPU.r8().value = r3;

      //LAB_80b5984
      do {
        r0 = MEMORY.ref(2, r6).getUnsigned();
        r1 = 0x1;
        r6 = r6 + 0x2;
        FUN_8015120(r0, r1);
        if(r5 == CPU.r8().value) {
          r0 = 0x811;
          FUN_80151c8(r0);
        } else {
          //LAB_80b599a
          r0 = 0x810;
          FUN_80151c8(r0);
        }

        //LAB_80b59a0
        r5 = r5 + 0x1;
        FUN_80bb65c();
      } while(r5 != r7);
    }

    //LAB_80b59aa
    FUN_8015218();
    r3 = CPU.r10().value;
    r3 = r3 + 0x45;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    if(r3 == 0x1) {
      FUN_8015118();
      r0 = 0x0;
      r1 = 0x1;
      FUN_8015120(r0, r1);
      r0 = 0x812;
      FUN_80151c8(r0);
      FUN_80bb65c();
    } else {
      //LAB_80b59d0
      if(r3 == 0x2) {
        FUN_8015118();
        r0 = 0x0;
        r1 = 0x1;
        FUN_8015120(r0, r1);
        r0 = 0x813;
        FUN_80151c8(r0);
        FUN_80bb65c();
      }
    }

    //LAB_80b59ea
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80b5a0c)
  public static void FUN_80b5a0c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    CPU.sp().value -= 0x1c;
    r3 = 0x3001e74;
    r7 = CPU.sp().value;
    r0 = r7;
    r5 = MEMORY.ref(4, r3).get();
    r0 = FUN_80b6a60(r0);
    r6 = r0;
    if(r6 > 0) {
      r2 = r5;
      r0 = r7;
      r2 = r2 + 0x58;
      r4 = 0x0;
      r1 = r6;

      //LAB_80b5a2c
      do {
        r3 = MEMORY.ref(2, r4 + r0).getUnsigned();
        r1 = r1 - 0x1;
        MEMORY.ref(2, r2).setu(r3);
        r4 = r4 + 0x2;
        r2 = r2 + 0x2;
      } while(r1 != 0);
    }

    //LAB_80b5a3a
    r3 = r6 << 1;
    r2 = 0xff;
    r3 = r3 + 0x58;
    MEMORY.ref(2, r5 + r3).setu(r2);
    r0 = r7;
    r0 = FUN_80b6ae0(r0);
    r3 = r5;
    r3 = r3 + 0x42;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r6 = r0;
    if(r3 >= 0 && r3 <= 0x1) {
      r1 = 0x0;
      if(r1 >= r6) {
        r5 = r5 + 0x2;
        CPU.r12().value = r5;
      } else {
        r3 = r5 + 0x2;
        r2 = r5;
        CPU.r12().value = r3;
        r0 = r7;
        r2 = r2 + 0x66;
        r4 = 0x0;

        //LAB_80b5a74
        do {
          r3 = MEMORY.ref(2, r4 + r0).getUnsigned();
          r1 = r1 + 0x1;
          MEMORY.ref(2, r2).setu(r3);
          r4 = r4 + 0x2;
          r2 = r2 + 0x2;
        } while(r1 < r6);
      }
    } else {
      //LAB_80b5a84
      if(r6 > 0) {
        r3 = r6 >>> 31;
        r3 = r6 + r3;
        r5 = r5 + 0x2;
        r3 = r3 >> 1;
        r4 = 0x80c2a10;
        CPU.r12().value = r5;
        CPU.lr().value = r3;
        r0 = r7;
        r1 = r6;

        //LAB_80b5a9a
        do {
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r3 = r3 << 24;
          r3 = r3 >> 24;
          r3 = r3 + CPU.lr().value;
          r2 = MEMORY.ref(2, r0).getUnsigned();
          r3 = r3 << 1;
          r3 = r3 + 0x64;
          r1 = r1 - 0x1;
          r4 = r4 + 0x1;
          r0 = r0 + 0x2;
          MEMORY.ref(2, r5 + r3).setu(r2);
        } while(r1 != 0);
      } else {
        //LAB_80b5ab6
        r5 = r5 + 0x2;
        CPU.r12().value = r5;
      }
    }

    //LAB_80b5aba
    r3 = r6 << 1;
    r2 = 0xff;
    r3 = r3 + 0x64;
    r1 = CPU.r12().value;
    MEMORY.ref(2, r1 + r3).setu(r2);
    CPU.sp().value += 0x1c;
  }

  @Method(0x80b5b14)
  public static void FUN_80b5b14(final int r0) {
    // no-op
  }

  @Method(0x80b5b18)
  public static void FUN_80b5b18() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b5c08)
  public static void FUN_80b5c08() {
    CPU.sp().value -= 0x18;
    final int r9 = CPU.sp().value + 0x4;
    final int r10 = FUN_80b6a60(r9);

    //LAB_80b5c28
    for(int r8 = 0; r8 < r10; r8++) {
      final int charId = MEMORY.ref(2, r9 + r8 * 0x2).getUnsigned();

      //LAB_80b5c2e
      for(int element = 0; element < 4; element++) {
        //LAB_80b5c30
        for(int djinn = 0; djinn < 20; djinn++) {
          if(FUN_8077210(charId, element, djinn) != 0) {
            int r0;
            if((charId & 0xffff_ffffL) > 7) {
              r0 = 0x1;
            } else {
              r0 = 0x0;
            }

            //LAB_80b5c46
            final RecoveryQueue10c r1 = getDjinnRecoveryQueue_(r0);
            r0 = 0x0;

            //LAB_80b5c6a
            while(r0 < r1.count_108.get() && (element != r1._08.get(r0).element_00.get() || djinn != r1._08.get(r0).djinn_01.get())) {
              r0++;
            }

            //LAB_80b5c88
            if(r0 == r1.count_108.get()) {
              FUN_80771c8(charId, element, djinn);
            }
          }

          //LAB_80b5c9e
        }
      }
    }

    //LAB_80b5cb6
    if(readFlag_(0x16c) == 0) {
      final RecoveryQueue10c queue = getDjinnRecoveryQueue_(0);

      //LAB_80b5ce8
      for(int r8 = 0; r8 < queue.count_108.get(); r8++) {
        final RecoveryQueue10c.DjinnInfo04 r7 = queue._08.get(r8);
        if(r7._03.get() == -1) {
          if(FUN_80b7dd0(r7.charId_02.get()) == 0) {
            setDjinn_(r7.charId_02.get(), r7.element_00.get(), r7.djinn_01.get());
            recoverDjinn_(r7.charId_02.get(), r7.element_00.get(), r7.djinn_01.get());
          }
        }

        //LAB_80b5d18
      }
    }

    //LAB_80b5d2a
    CPU.sp().value += 0x18;
  }

  @Method(0x80b5d3c)
  public static void FUN_80b5d3c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r6;
    int r8;
    final int r9;
    final int r10;
    int r11;

    CPU.sp().value -= 0x20;
    r9 = CPU.sp().value + 0x8;
    r4 = FUN_80b6a60(r9);
    r11 = 0;
    r8 = 0;
    r10 = CPU.sp().value + 0x1c;

    //LAB_80b5d64
    while(r8 < 4) {
      MEMORY.ref(1, r10 + r8).setu(0);
      r6 = r9;

      //LAB_80b5d7c
      for(int i = 0; i < r4; i++) {
        MEMORY.ref(1, r10 + r8).addu(getCharOrMonsterData_(MEMORY.ref(2, r6).getUnsigned())._118.get(r8).get());
        r6 += 0x2;
      }

      //LAB_80b5d9e
      r8++;
    }

    r8 = 0;

    //LAB_80b5dac
    do {
      r0 = FUN_80771e0(r8);
      if(r0 != 0) {
        r0 = r0 + 0x4;
        r2 = MEMORY.ref(1, r10).getUnsigned();
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r4 = 0x0;
        r1 = r10;

        //LAB_80b5dc6
        while((r2 & 0xffff_ffffL) >= (r3 & 0xffff_ffffL)) {
          r4 = r4 + 0x1;
          if(r4 > 0x3) {
            break;
          }
          r1 = r1 + 0x1;
          r0 = r0 + 0x1;
          r2 = MEMORY.ref(1, r1).getUnsigned();
          r3 = MEMORY.ref(1, r0).getUnsigned();
        }

        //LAB_80b5dd8
        if(r4 == 0x4) {
          r11 |= 0x1 << r8;
        }
      }

      //LAB_80b5de8
      r8++;
    } while(r8 < 32);

    getDjinnRecoveryQueue_(0)._00.set(r11);
    CPU.sp().value += 0x20;
  }

  @Method(0x80b6148)
  public static int FUN_80b6148() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b6378)
  public static void FUN_80b6378() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b63b0)
  public static int FUN_80b63b0() {
    return (int)MEMORY.call(0x3000164, 0x2002224, 0x10); // memzero
  }

  /** Starting battle? */
  @Method(0x80b63c8)
  public static int FUN_80b63c8(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x44;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    CPU.r10().value = mallocSlotBoard(12, 0x4c);
    CPU.r8().value = mallocSlotBoard(9, 0x82c);
    r6 = mallocSlotBoard(54, 0x7c8);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(mallocSlotBoard(44, 0x20));
    mallocSlotBoard(11, 0x280);
    CPU.r9().value = CPU.r10().value + 0xc;
    MEMORY.call(0x3000164, r6, 0x7c8); // memzero
    clearTickCallbacks();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, r2 + 0x4).setu(0);
    MEMORY.ref(4, r2).setu(0x2000);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, r3 + 0x14).setu(1);
    MEMORY.ref(4, r3 + 0x18).setu(0);
    MEMORY.ref(4, r3 + 0x1c).setu(0);
    GPU.DISPCNT.setu(1);
    setFlag_(0x103);
    setFlag_(0x169);
    FUN_80049ac();

    r5 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(CPU.r10().value);
    DMA.channels[3].CNT.setu(0x85000013);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(CPU.r8().value);
    DMA.channels[3].CNT.setu(0x8500020b);

    MEMORY.ref(4, CPU.r8().value + 0x54).setu(-1);
    MEMORY.ref(4, CPU.r8().value).setu(MEMORY.ref(4, CPU.sp().value + 0xc).get());

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(mallocSlotBoard(37, 0xc));
    DMA.channels[3].CNT.setu(0x85000003);

    MEMORY.ref(2, CPU.r8().value + 0x648).setu(FUN_808a4a0());
    mallocSlotBoard(4, 0xe00);
    mallocSlotBoard(3, 0x600);
    initActors_(4);

    if(readFlag_(0x16e) != 0) {
      FUN_8015008(1);
    } else {
      //LAB_80b64c6
      FUN_8015008(0);
    }

    //LAB_80b64cc
    r5 = 0x0;
    MEMORY.ref(4, CPU.r9().value).setu(0);
    MEMORY.ref(4, CPU.r9().value + 0x4).setu(0x400000);
    MEMORY.ref(4, CPU.r9().value + 0x8).setu(0);
    MEMORY.ref(4, CPU.r10().value).setu(0);
    MEMORY.ref(4, CPU.r10().value + 0x4).setu(0xb40000);
    MEMORY.ref(4, CPU.r10().value + 0x8).setu(0x400000);
    MEMORY.ref(4, CPU.r10().value + 0x20).setu(0x1000000);
    MEMORY.ref(2, CPU.r10().value + 0x34).setu(0x5000);
    MEMORY.ref(2, CPU.r10().value + 0x36).setu(0x2800);
    r6 = FUN_80c1ffc(MEMORY.ref(4, CPU.r8().value).get());

    if(readFlag_(0x16c) != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(CPU.r8().value + 0x44);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      MEMORY.ref(1, r1).setu(1);
      r3 = 0x2000240;
      r2 = 0x22b;
      r3 = r3 + r2;
      r2 = 0x4;
      MEMORY.ref(1, r3).setu(r2);
    } else {
      //LAB_80b6528
      r3 = CPU.r8().value;
      r3 = r3 + 0x44;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    }

    //LAB_80b652e
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r3 = MEMORY.ref(1, r1).getUnsigned();
    if(r3 != 0) {
      r3 = 0x20023a8;
      MEMORY.ref(4, r3).setu(r5);
      r5 = 0x0;
      r2 = 0x3001f64;
      r6 = CPU.r8().value;
      r3 = 0x1;
      CPU.r10().value = r2;
      r6 = r6 + 0x52;
      r7 = 0x3;
      CPU.r9().value = r3;

      //LAB_80b654a
      do {
        r1 = CPU.r10().value;
        r2 = MEMORY.ref(2, r1).getUnsigned();
        r3 = r7;
        r3 = r3 & r2;
        if(r3 == 0x3) {
          break;
        }
        r0 = 0x1;
        r5 = r5 + 0x1;
        sleep(r0);
        if(r5 > 0x18) {
          r2 = CPU.r9().value;
          MEMORY.ref(1, r6).setu(r2);
          break;
        }
      } while(true);

      //LAB_80b6566
      r3 = 0x4000128;
      r3 = MEMORY.ref(4, r3).get();
      r2 = CPU.r8().value;
      r3 = r3 << 26;
      r3 = r3 >>> 30;
      r2 = r2 + 0x50;
      MEMORY.ref(1, r2).setu(r3);
      r3 = 0x3001f28;
      r4 = 0x7c7;
      r2 = MEMORY.ref(4, r3).get();
      r1 = 0x2018000;
      r0 = 0x0;

      //LAB_80b657e
      do {
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r0 = r0 + 0x1;
        MEMORY.ref(1, r2).setu(r3);
        r1 = r1 + 0x1;
        r2 = r2 + 0x1;
      } while((r0 & 0xffff_ffffL) <= (r4 & 0xffff_ffffL));

      r0 = 0xfc;
      r0 = r0 << 2;
      r0 = FUN_80770e0(r0);
      r6 = r0;
      FUN_80b6378();
      r2 = CPU.r8().value;
      r2 = r2 + 0x42;
      r3 = 0x0;
      MEMORY.ref(1, r2).setu(r3);
    }

    //LAB_80b65a2
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b5864"), 0xc7f);
    r3 = 0x2000240;
    r1 = 0xf7;
    r1 = r1 << 1;
    r3 = r3 + r1;
    r2 = 0x0;
    r0 = MEMORY.ref(2, r3 + r2).get();
    if(r0 != 0) {
      playSound_(r0);
      r0 = 0xb6;
      r0 = r0 << 1;
      r0 = readFlag_(r0);
      if(r0 != 0) {
        r0 = 0x37;
        playSound_(r0);
        r0 = 0x4;
        r0 = FUN_80037d4(r0);
      }
    } else {
      //LAB_80b65d8
      r0 = 0x33;
      playSound_(r0);
      r0 = 0x4c;
      playSound_(r0);
    }

    //LAB_80b65e4
    FUN_80b5a0c();
    FUN_80b75dc();
    FUN_80b5c08();
    FUN_80b5d3c();
    r3 = getDjinnRecoveryQueue_(0)._00.get();
    if(r3 != 0) {
      r3 = 0x41;
      r3 = r3 + CPU.r8().value;
      CPU.r9().value = r3;
      r1 = CPU.r9().value;
      r3 = 0x3;
      MEMORY.ref(1, r1).setu(r3);
    } else {
      //LAB_80b6658
      r2 = 0x41;
      r2 = r2 + CPU.r8().value;
      r3 = 0x1;
      MEMORY.ref(1, r2).setu(r3);
      CPU.r9().value = r2;
    }

    //LAB_80b6662
    r0 = 0x9;
    FUN_8015128(r0);
    FUN_80b7f9c();
    FUN_80b6c90();
    FUN_80c08a8();
    r3 = 0xc9;
    r3 = r3 << 3;
    r3 = r3 + CPU.r8().value;
    r1 = MEMORY.ref(2, r3).getUnsigned();
    r0 = 0x1;
    r2 = 0x0;
    FUN_80c08ec(r0, r1, r2);
    r3 = 0x80;
    r3 = r3 << 10;
    r0 = 0xa0;
    r1 = 0xa0;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = r0 << 16;
    r1 = r1 << 15;
    r2 = 0x0;
    r3 = 0x0;
    FUN_80c0a24(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r1 = 0x0;
    r2 = 0x0;
    r3 = 0xbe;
    r0 = 0x0;
    FUN_80c0cec(r0, r1, r2, r3);
    r0 = 0x1;
    FUN_80b5b14(r0);
    r5 = 0x0;
    GPU.BLDCNT.setu(0);
    FUN_80c24b0();
    r0 = 0x80;
    r0 = FUN_80040b4(r0);
    r3 = CPU.r8().value;
    r1 = 0x45;
    MEMORY.ref(4, r3 + 0x54).setu(r0);
    r1 = r1 + CPU.r8().value;
    MEMORY.ref(1, r1).setu(r5);
    CPU.r11().value = r1;
    if(readFlag_(0x16e) != 0) {
      r3 = 0x1;
      r2 = CPU.r11().value;
      MEMORY.ref(1, r2).setu(r3);
    } else if(MEMORY.ref(1, 0x200046b).getUnsigned() == 0) {
      if((lcgRand_() & 0xf) == 0) {
        //LAB_80b6700
        MEMORY.ref(1, CPU.r11().value).setu(1);
        //LAB_80b6708
      } else if((lcgRand_() & 0x1f) == 0) {
        MEMORY.ref(1, CPU.r11().value).setu(2);
      }
    }

    //LAB_80b671a
    r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    FUN_80c02a4(r6, r1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, r3 + 0x14).setu(0);
    r3 = 0x3001f58;
    MEMORY.ref(1, r3).setu(0);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b7738"), 0xc80);

    //LAB_80b6736
    outer:
    do {
      FUN_80b9b2c();
      FUN_80b5d3c();

      if(getDjinnRecoveryQueue_(0)._00.get() != 0) {
        MEMORY.ref(1, CPU.r9().value).setu(3);
      } else {
        //LAB_80b6752
        MEMORY.ref(1, CPU.r9().value).setu(1);
      }

      //LAB_80b6758
      r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r3 = 0xa0;
      r3 = r3 << 6;
      MEMORY.ref(4, r1).setu(r3);
      r3 = 0x3c;
      MEMORY.ref(4, r1 + 0x4).setu(r3);
      r2 = CPU.r9().value;
      r5 = 0xbb;
      r0 = MEMORY.ref(1, r2).getUnsigned();
      r5 = r5 << 2;
      FUN_8015130(r0);
      r5 = r5 + CPU.r8().value;
      r1 = 0xa0;
      r1 = r1 << 1;
      r0 = r5;
      MEMORY.call(0x3000164, r0, r1); // memzero
      r3 = CPU.r8().value;
      r0 = MEMORY.ref(4, r3 + 0x54).get();
      clearVramSlot(r0);
      r0 = 0xb5;
      r0 = r0 << 1;
      r0 = readFlag_(r0);
      if(r0 == 0) {
        r0 = FUN_800488c();
        r0 = FUN_80048a0();
        r0 = r5;
        r0 = FUN_80b9934(r0);
        r5 = r0;
        r0 = FUN_800488c();
        r0 = FUN_80048a0();
      } else {
        //LAB_80b67ac
        r0 = r5;
        r0 = FUN_80b8574(r0);
        r5 = r0;
      }

      //LAB_80b67b4
      r0 = 0x80;
      r0 = FUN_80040b4(r0);
      r1 = CPU.r8().value;
      MEMORY.ref(4, r1 + 0x54).setu(r0);
      r2 = CPU.r9().value;
      r0 = MEMORY.ref(1, r2).getUnsigned();
      FUN_8015130(r0);
      if(r5 < 0) {
        //LAB_80b696e
        FUN_80b63b0();
        disableTickCallback(null);
        GPU.DISPCNT.setu(1);
        r7 = MEMORY.ref(4, CPU.r8().value + 0x538).get();
        setFlag_(0x3e8);
        break;
      }

      //LAB_80b67cc
      r7 = 0x0;
      if(r7 < r5) {
        r6 = 0xbb;
        r6 = r6 << 2;

        //LAB_80b67d6
        do {
          r3 = CPU.r8().value;
          r3 = MEMORY.ref(2, r6 + r3).get();
          CPU.r10().value = r3;
          r0 = FUN_800488c();
          r0 = FUN_80048a0();
          r0 = readFlag_(0x16a);
          if(r0 != 0 && FUN_80b874c(r6 + CPU.r8().value) == 1 || r0 == 0 && FUN_80b9b30(r6 + CPU.r8().value, r7 != 0 ? 0 : 10) == 1) {
            //LAB_80b6a00
            playSound_(0x11);
            fadeOutBrightness(30);
            waitForFade();
            r7 = 0x3e7;
            break outer;
          }

          //LAB_80b6814
          r0 = FUN_800488c();
          r0 = FUN_80048a0();
          r0 = 0x1;
          r1 = 0x0;
          r0 = FUN_80b6b40(r0, r1);
          if(r0 == 0) {
            //LAB_80b69b0
            FUN_80b63b0();
            playSound_(0x3b);
            FUN_8015118();
            FUN_8015120(charIds_2000438.get(0).get(), 1);
            if(FUN_80b6a60(0) == 1) {
              FUN_80151c8(0x83d);
            } else {
              //LAB_80b69e0
              FUN_80151c8(0x837);
            }

            //LAB_80b69e6
            FUN_80bb65c();
            playSound_(0x11);
            fadeOutBrightness(30);
            r7 = -1;
            waitForFade();
            break outer;
          }

          //LAB_80b682a
          r0 = 0x2;
          r1 = 0x0;
          r0 = FUN_80b6b40(r0, r1);
          if(r0 == 0) {
            r1 = CPU.r10().value;
            if((r1 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
              r3 = 0xa7;
              r3 = r3 << 3;
              r3 = r3 + CPU.r8().value;
              r3 = MEMORY.ref(4, r3).get();
              if(r3 == 0x1) {
                r3 = 0x3;
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2 + 0x3e).setu(r3);
              }
            }

            //LAB_80b68ec
            FUN_80b63b0();
            r0 = 0xb7;
            r0 = r0 << 1;
            r0 = readFlag_(r0);
            if(r0 == 0) {
              r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r3 = MEMORY.ref(1, r1).getUnsigned();
              if(r3 != 0) {
                r0 = 0x3a;
                playSound_(r0);
              }

              //LAB_80b690a
              r3 = 0xa7;
              r3 = r3 << 3;
              r3 = r3 + CPU.r8().value;
              r3 = MEMORY.ref(4, r3).get();
              if(r3 != 0) {
                r0 = 0x3a;
                playSound_(r0);
                r2 = CPU.r8().value;
                r3 = MEMORY.ref(2, r2 + 0x3e).getUnsigned();
                CPU.cmpT(r3, 0x1);
                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                  r3 = MEMORY.ref(2, r2 + 0x3c).getUnsigned();
                  r3 = r3 << 1;
                  r3 = r3 + 0x10;
                  r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
                  r0 = 0x80;
                  r2 = 0x1a;
                  r0 = FUN_8077140(r0, r1, r2);
                  FUN_8015118();
                  r0 = 0x80;
                  r1 = 0x1;
                  FUN_8015120(r0, r1);
                  FUN_80151c8(0x838 + MEMORY.ref(2, CPU.r8().value + 0x3e).getUnsigned());
                  FUN_80bb65c();
                }
              }

              //LAB_80b6950
              FUN_80c2724();
            }

            //LAB_80b6954
            r0 = 0x11;
            playSound_(r0);
            r0 = 0x1e;
            fadeOutBrightness(r0);
            waitForFade();
            r3 = 0xa7;
            r3 = r3 << 3;
            r3 = r3 + CPU.r8().value;
            r7 = MEMORY.ref(4, r3).get();
            break outer;
          }

          //LAB_80b6850
          r0 = FUN_80b6148();
          if(r0 < 0) {
            //LAB_80b696e
            FUN_80b63b0();
            disableTickCallback(null);
            GPU.DISPCNT.setu(1);
            r7 = MEMORY.ref(4, CPU.r8().value + 0x538).get();
            setFlag_(0x3e8);
            break outer;
          }

          //LAB_80b685a
          r7 = r7 + 0x1;
          r6 = r6 + 0x10;
        } while(r7 < r5);
      }

      //LAB_80b6862
      r3 = 0x0;
      r1 = CPU.r11().value;
      MEMORY.ref(1, r1).setu(r3);
      FUN_80bf674();
      FUN_80bf678();
      FUN_80b7e7c();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r3 = MEMORY.ref(1, r2).getUnsigned();
      if(r3 == 0) {
        //LAB_80b6886
        r0 = 0x14;
        sleep(r0);
      } else {
        r0 = FUN_80b6148();
        if(r0 < 0) {
          //LAB_80b696e
          FUN_80b63b0();
          disableTickCallback(null);
          GPU.DISPCNT.setu(1);
          r7 = MEMORY.ref(4, CPU.r8().value + 0x538).get();
          setFlag_(0x3e8);
          break;
        }
      }

      //LAB_80b688c
      if(readFlag_(0x16e) != 0) {
        //LAB_80b689a
        Panel24 panel = FUN_8015038(0xc47, 0, 4, 1);

        //LAB_80b68b0
        while(FUN_8015048() == 0) {
          //LAB_80b68aa
          sleep(1);
        }

        FUN_8015018(panel, 1);
        sleep(1);
        panel = FUN_8015038(0xc48, 10, 4, 1);
        FUN_80bb7c0(0x5c, 0x18);
        FUN_8015018(panel, 1);
        sleep(1);
      }
    } while(true);

    //LAB_80b6a12
    FUN_80b5b18();
    FUN_80bf674();
    FUN_80bf5a8();
    r3 = 0x2000240;
    r2 = 0x22b;
    r3 = r3 + r2;
    r2 = 0x0;
    MEMORY.ref(1, r3).setu(r2);
    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b7738"));
    FUN_80c08e0();
    r0 = r7;
    CPU.sp().value += 0x44;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80b6a60)
  public static int FUN_80b6a60(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).offset(1, 0x44).getUnsigned();
    final int maxCharCount;
    if(r3 != 0) {
      maxCharCount = 3;
    } else {
      maxCharCount = 4;
    }

    //LAB_80b6a7a
    final int charCount = Math.min(maxCharCount, getCharCount_());

    //LAB_80b6a86
    //LAB_80b6a98
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      final int charId = charIds_2000438.get(charSlot).get();

      if(r0 != 0) {
        MEMORY.ref(2, r0 + charSlot * 0x2).setu(charId);
      }

      //LAB_80b6aa4
      getCharOrMonsterData_(charId)._12a.set(2);
    }

    //LAB_80b6abc
    if(r0 != 0) {
      MEMORY.ref(2, r0 + charCount * 0x2).setu(0xff);
    }

    //LAB_80b6ac4
    return charCount;
  }

  @Method(0x80b6ae0)
  public static int FUN_80b6ae0(int r0) {
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);
    r6 = r0;
    CPU.r8().value = 0;
    r7 = 0x6;
    r0 = 0x0;
    if(r6 != 0) {
      if(readFlag_(0x16c) != 0) {
        r7 = 0x3;
      }

      //LAB_80b6b02
      r5 = 0x80;
      r7 = r7 + 0x80;

      //LAB_80b6b0a
      while(r5 < r7) {
        if(getCharOrMonsterData_(r5)._12a.get() != 0) {
          MEMORY.ref(2, r6).setu(r5);
          r6 += 0x2;
          CPU.r8().value++;
        }

        //LAB_80b6b24
        r5++;
      }

      //LAB_80b6b2a
      MEMORY.ref(2, r6).setu(0xff);
      r0 = CPU.r8().value;
    }

    //LAB_80b6b30
    CPU.r8().value = CPU.pop();
    return r0;
  }

  @Method(0x80b6b40)
  public static int FUN_80b6b40(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b6c08)
  public static int FUN_80b6c08(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    r3 = 0x3001e74;
    r6 = r0;
    r0 = MEMORY.ref(4, r3).get();
    r5 = 0x0;
    if((r6 & 0x1) != 0) {
      if(MEMORY.ref(2, r0 + 0x58).get() != 0xff) {
        r2 = r0 + 0x58;

        //LAB_80b6c26
        do {
          r7 = 0x0;
          r3 = MEMORY.ref(2, r2 + r7).get();
          r4 = MEMORY.ref(2, r2).getUnsigned();
          if(r3 != 0xfe) {
            if(r1 != 0) {
              MEMORY.ref(2, r1).setu(r4);
              r1 = r1 + 0x2;
            }

            //LAB_80b6c38
            r5 = r5 + 0x1;
          }

          //LAB_80b6c3a
          r2 = r2 + 0x2;
          r4 = 0x0;
          r3 = MEMORY.ref(2, r2 + r4).get();
        } while(r3 != 0xff);
      }
    }

    //LAB_80b6c44
    r3 = 0x2;
    r3 = r3 & r6;
    if(r3 != 0) {
      r2 = r0 + 0x2;
      r3 = MEMORY.ref(2, r2 + 0x64).get();
      CPU.r12().value = r2;
      if(r3 != 0xff) {
        r0 = 0x64;

        //LAB_80b6c5a
        do {
          r3 = MEMORY.ref(2, r2 + r0).get();
          r4 = MEMORY.ref(2, r2 + r0).getUnsigned();
          if(r3 != 0xfe) {
            if(r1 != 0) {
              MEMORY.ref(2, r1).setu(r4);
              r1 = r1 + 0x2;
            }

            //LAB_80b6c6a
            r5 = r5 + 0x1;
          }

          //LAB_80b6c6c
          r0 = r0 + 0x2;
          r2 = CPU.r12().value;
          r3 = MEMORY.ref(2, r2 + r0).get();
        } while(r3 != 0xff);
      }
    }

    //LAB_80b6c76
    if(r1 != 0) {
      MEMORY.ref(2, r1).setu(0xff);
    }

    //LAB_80b6c7e
    return r5;
  }

  @Method(0x80b6c90)
  public static void FUN_80b6c90() {
    int r0;
    int r1;
    final int r5;

    CPU.sp().value -= 0x1c;
    r5 = CPU.sp().value;
    r1 = r5;
    r0 = 0x3;
    r0 = FUN_80b6c08(r0, r1);
    r0 = r5;
    r1 = 0x1;
    FUN_80b7b6c(r0, r1);
    CPU.sp().value += 0x1c;
  }

  @Method(0x80b6cd0)
  public static int FUN_80b6cd0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b6d30)
  public static int FUN_80b6d30(final int r0) {
    final int r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    final Unit14c r9 = getCharOrMonsterData_(r0);
    final int r8 = FUN_80c23c0(r9._128.get());
    final int r7 = FUN_80c2384(r9._128.get());
    int r10 = 0;

    //LAB_80b6d68
    for(int r4 = 0; r4 < 2; r4++) {
      if(r9.class_129.get() == 0) {
        //LAB_80b6d8a
        int r5;
        for(r5 = 0; r5 < 6 && (MEMORY.ref(2, r6 + 0x4 + r5 * 0x2).get() != 0 || r8 == 0 && (r5 > 4 || MEMORY.ref(2, r6 + 0x6 + r5 * 0x2).get() != 0)); r5++) {
          //
        }

        //LAB_80b6dac
        if(r5 == 6) {
          break;
        }

        if(FUN_8009270(r5, 0x2018000 + r5 * 0x4000, r7 + r4, FUN_80c23a0(r9._128.get())) == 0) {
          return 0;
        }

        //LAB_80b6dda
        if(r4 == 0) {
          r10 = r5 << 12 | r7;
        }

        //LAB_80b6de4
        MEMORY.ref(2, r6 + 0x4 + r5 * 0x2).setu(r0);
        if(r8 == 0) {
          MEMORY.ref(2, r6 + 0x6 + r5 * 0x2).setu(r0);
        }

        //LAB_80b6df6
        if(r7 != 0x1dc && r7 != 0x1e3) {
          break;
        }
      }

      //LAB_80b6e04
    }

    //LAB_80b6e0a
    return r10;
  }

  @Method(0x80b6e7c)
  public static int FUN_80b6e7c(final int r0) {
    int r2;
    int r4;

    r4 = 0x0;

    //LAB_80b6e84
    do {
      r2 = MEMORY.ref(2, 0x80c593c + r4 * 0x2).get();

      if(r0 == (r2 & 0x1ff)) {
        return MEMORY.ref(2, 0x80c593c + r4 * 0x2).getUnsigned() >>> 9;
      }

      //LAB_80b6e96
      r4++;
    } while(r2 != -1);

    return 6;
  }

  @Method(0x80b6eb4)
  public static int FUN_80b6eb4(final int r0) {
    final Unit14c r6 = getCharOrMonsterData_(r0);
    final int r0_0 = FUN_8077228(r0, 1);
    if(r0_0 < 0) {
      return 0;
    }

    final int r1 = FUN_80b6e7c(r6.items_d8.get(r0_0).get() & 0x1ff);

    //LAB_80b6f1e
    return switch(r6._128.get()) {
      case 0 -> MEMORY.ref(2, 0x80c2a1c + r1 * 0x2).getUnsigned();
      case 1 -> MEMORY.ref(2, 0x80c2a2a + r1 * 0x2).getUnsigned();
      case 2 -> MEMORY.ref(2, 0x80c2a38 + r1 * 0x2).getUnsigned();
      case 3 -> MEMORY.ref(2, 0x80c2a46 + r1 * 0x2).getUnsigned();
      case 5 -> MEMORY.ref(2, 0x80c2a54 + r1 * 0x2).getUnsigned();
      default -> 0;
    };
  }

  @Method(0x80b6f44)
  public static void FUN_80b6f44(int r0, int r1, int r2, int r3) {
    CPU.sp().value -= 0x14;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    final int r6 = r0;
    r2 = r2 << 16;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    r3 = r3 << 16;
    final int r9 = r1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    final Actor70 r8 = loadActor_(0xf000, r2, 0, r3);
    final Unit14c r10 = getCharOrMonsterData_(r9);
    int r11 = 0;
    r0 = FUN_80b6d30(r9);
    final int r7 = r0;
    if(r10.class_129.get() == 0) {
      r1 = FUN_80c2384(r10._128.get());
      if(r7 == 0) {
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        r11 = FUN_80c23a0(r10._128.get());
        r1 = MEMORY.ref(4, CPU.sp().value).get();
      } else {
        //LAB_80b6fb0
        r1 = r7;
      }
    } else {
      //LAB_80b6fb4
      switch(r10._128.get()) {
        case 1: // switch 80b6fc8
          //LAB_80b6fe0
          r1 = 0x12d;
          break;

        case 3: // switch 80b6fc8
          //LAB_80b6fe4
          r1 = 0x12f;
          break;

        case 2: // switch 80b6fc8
          //LAB_80b6fe8
          r1 = 0x12e;
          break;

        case 5: // switch 80b6fc8
          //LAB_80b6fec
          r1 = 0x131;
          break;

        default:
          //LAB_80b6ff0
          r1 = 0x12c;
          break;
      }

      //LAB_80b6ff4
      if((r9 & 0xffff_ffffL) > 7) {
        r11 = 1;
      }
    }

    //LAB_80b6ffe
    MEMORY.ref(4, r6 + 0x18).setu(0x10000);

    //LAB_80b7014
    switch(r10._128.get() - 18) {
      case 60: // switch 80b701c
        //LAB_80b724c
        r3 = 0x19999;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 71: // switch 80b701c
        //LAB_80b7250
        r3 = 0x18ccc;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 112: // switch 80b701c
        //LAB_80b7254
        r3 = 0x13333;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 113: // switch 80b701c
        //LAB_80b7258
        r3 = 0x19999;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 120: // switch 80b701c
        //LAB_80b725c
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 129: // switch 80b701c
        //LAB_80b7262
        r3 = 0x1cccc;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 131: // switch 80b701c
        //LAB_80b7266
        r3 = 0x1cccc;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 11: // switch 80b701c
        //LAB_80b726a
        r3 = 0x80;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 103: // switch 80b701c
        //LAB_80b7270
        r3 = 0x1b333;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 130: // switch 80b701c
        //LAB_80b7274
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 132: // switch 80b701c
        //LAB_80b727a
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 133: // switch 80b701c
        //LAB_80b7280
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 134: // switch 80b701c
        //LAB_80b7286
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 135: // switch 80b701c
        //LAB_80b728c
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 136: // switch 80b701c
        //LAB_80b7292
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 137: // switch 80b701c
        //LAB_80b7298
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 138: // switch 80b701c
        //LAB_80b729e
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 139: // switch 80b701c
        //LAB_80b72a4
        r3 = 0xc0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 29: // switch 80b701c
        //LAB_80b72aa
        r3 = 0x13333;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 30: // switch 80b701c
        //LAB_80b72ae
        r3 = 0x13333;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 31: // switch 80b701c
        //LAB_80b72b2
        r3 = 0x16666;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 66: // switch 80b701c
        //LAB_80b72b6
        r3 = 0x80;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 67: // switch 80b701c
        //LAB_80b72bc
        r3 = 0xa0;
        r3 = r3 << 9;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 110: // switch 80b701c
        //LAB_80b72c2
        r3 = 0x16666;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 111: // switch 80b701c
        //LAB_80b72c6
        r3 = 0x16666;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        break;

      case 76: // switch 80b701c
        //LAB_80b72ca
        MEMORY.ref(4, r6 + 0x18).setu(0x18000);
        break;

      case 80: // switch 80b701c
        //LAB_80b72d0
        MEMORY.ref(4, r6 + 0x18).setu(0x14ccc);
        break;

      case 92: // switch 80b701c
        //LAB_80b72d4
        MEMORY.ref(4, r6 + 0x18).setu(0x13333);
        break;

      case 114: // switch 80b701c
        //LAB_80b72d8
        MEMORY.ref(4, r6 + 0x18).setu(0x10ccc);
        break;

      case 115: // switch 80b701c
        //LAB_80b72dc
        MEMORY.ref(4, r6 + 0x18).setu(0x10ccc);
        break;

      case 116: // switch 80b701c
        //LAB_80b72e0
        MEMORY.ref(4, r6 + 0x18).setu(0x11999);
        break;

      case 117: // switch 80b701c
        //LAB_80b72e4
        MEMORY.ref(4, r6 + 0x18).setu(0x11999);
        break;

      case 118: // switch 80b701c
        //LAB_80b72e8
        MEMORY.ref(4, r6 + 0x18).setu(0x13333);
        break;

      case 119: // switch 80b701c
        //LAB_80b72ec
        MEMORY.ref(4, r6 + 0x18).setu(0x13333);
        break;

      case 123: // switch 80b701c
        //LAB_80b72f0
        MEMORY.ref(4, r6 + 0x18).setu(0x18000);
        break;

      case 126: // switch 80b701c
        //LAB_80b72f6
        MEMORY.ref(4, r6 + 0x18).setu(0x13333);
        break;

      case 127: // switch 80b701c
        //LAB_80b72fa
        MEMORY.ref(4, r6 + 0x18).setu(0x18000);
        break;

      case 128: // switch 80b701c
        //LAB_80b7300
        MEMORY.ref(4, r6 + 0x18).setu(0x18ccc);
        break;

      case 34: // switch 80b701c
        //LAB_80b7304
        MEMORY.ref(4, r6 + 0x18).setu(0x14000);
        break;

      case 87: // switch 80b701c
        //LAB_80b730a
        MEMORY.ref(4, r6 + 0x18).setu(0x14000);
        break;

      case 50: // switch 80b701c
      case 74: // switch 80b701c
      case 12: // switch 80b701c
      case 52: // switch 80b701c
      case 51: // switch 80b701c
      case 0: // switch 80b701c
      case 1: // switch 80b701c
      case 2: // switch 80b701c
      case 3: // switch 80b701c
      case 108: // switch 80b701c
      case 105: // switch 80b701c
      case 106: // switch 80b701c
      case 107: // switch 80b701c
      case 104: // switch 80b701c
        //LAB_80b734c
        MEMORY.ref(4, r6 + 0x18).setu(0xe666);
        break;
    }

    //case 22: // switch 80b701c
    //case 102: // switch 80b701c
    //case 125: // switch 80b701c
    //case 24: // switch 80b701c
    //case 18: // switch 80b701c
    //case 78: // switch 80b701c
    //case 53: // switch 80b701c
    //case 16: // switch 80b701c
    //case 28: // switch 80b701c
    //case 68: // switch 80b701c
    //case 95: // switch 80b701c
    //case 43: // switch 80b701c
    //case 41: // switch 80b701c
    //case 26: // switch 80b701c
    //case 70: // switch 80b701c
    //case 72: // switch 80b701c
    //case 45: // switch 80b701c
    //case 20: // switch 80b701c
    //case 93: // switch 80b701c
    //case 99: // switch 80b701c
    //case 47: // switch 80b701c
    //case 49: // switch 80b701c
    //case 97: // switch 80b701c
    //case 62: // switch 80b701c
    //case 10: // switch 80b701c
    //case 59: // switch 80b701c
    //case 65: // switch 80b701c
    //case 13: // switch 80b701c
    //case 61: // switch 80b701c
    //case 14: // switch 80b701c
    //case 63: // switch 80b701c
    //case 64: // switch 80b701c
    //case 15: // switch 80b701c
    //case 55: // switch 80b701c
    //case 121: // switch 80b701c
    //case 54: // switch 80b701c
    //case 56: // switch 80b701c
    //case 57: // switch 80b701c
    //case 122: // switch 80b701c
    //case 58: // switch 80b701c
    //case 124: // switch 80b701c
    //case 48: // switch 80b701c
    //case 75: // switch 80b701c
    //case 101: // switch 80b701c
    //case 21: // switch 80b701c
    //case 23: // switch 80b701c
    //case 73: // switch 80b701c
    //case 25: // switch 80b701c
    //case 77: // switch 80b701c
    //case 19: // switch 80b701c
    //case 79: // switch 80b701c
    //case 17: // switch 80b701c
    //case 42: // switch 80b701c
    //case 27: // switch 80b701c
    //case 69: // switch 80b701c
    //case 40: // switch 80b701c
    //case 98: // switch 80b701c
    //case 44: // switch 80b701c
    //case 46: // switch 80b701c
    //case 94: // switch 80b701c
    //case 96: // switch 80b701c
    //case 35: // switch 80b701c
    //case 88: // switch 80b701c
    //case 90: // switch 80b701c
    //case 36: // switch 80b701c
    //case 6: // switch 80b701c
    //case 91: // switch 80b701c
    //case 9: // switch 80b701c
    //case 86: // switch 80b701c
    //case 5: // switch 80b701c
    //case 8: // switch 80b701c
    //case 7: // switch 80b701c
    //case 89: // switch 80b701c
    //case 4: // switch 80b701c
    //case 109: // switch 80b701c
    //case 82: // switch 80b701c
    //case 83: // switch 80b701c
    //case 39: // switch 80b701c
    //case 38: // switch 80b701c
    //case 85: // switch 80b701c
    //case 37: // switch 80b701c
    //case 84: // switch 80b701c
    //case 81: // switch 80b701c
    //case 100: // switch 80b701c
    //case 33: // switch 80b701c
    //case 32: // switch 80b701c
    //LAB_80b7350
    MEMORY.ref(4, r6).setu(r8.getAddress());
    MEMORY.ref(4, r6 + 0xc).setu(MEMORY.ref(4, CPU.sp().value + 0x8).get());
    MEMORY.ref(4, r6 + 0x10).setu(MEMORY.ref(4, CPU.sp().value + 0x4).get());
    MEMORY.ref(4, r6 + 0x14).setu(r11);
    MEMORY.ref(2, r6 + 0x4).setu(r1);
    r0 = FUN_80b6eb4(r9);
    MEMORY.ref(2, r6 + 0x8).setu(0);
    MEMORY.ref(4, r6 + 0x20).setu(0);
    MEMORY.ref(4, r6 + 0x24).setu(0);
    MEMORY.ref(2, r6 + 0x28).setu(0);
    MEMORY.ref(2, r6 + 0x2a).setu(0);
    MEMORY.ref(2, r6 + 0xa).setu(0x1fe);
    MEMORY.ref(2, r6 + 0x6).setu(r0);

    if(r10._128.get() < 2) {
      if(FUN_8077078(r10, 1) == 15) {
        if(r10._128.get() == 0) {
          r1 = 0x1e0;
        } else {
          //LAB_80b739e
          r1 = 0x1e2;
        }

        //LAB_80b73a0
        MEMORY.ref(2, r6 + 0x4).setu(r1);
        MEMORY.ref(2, r6 + 0x6).setu(0);
      }
    }

    //LAB_80b73a8
    r8.angle_06.set(atan2(MEMORY.ref(4, CPU.sp().value + 0xc).get() / 8, MEMORY.ref(4, CPU.sp().value + 0x10).get()) + 0x8000);
    r8._59.set(3);
    r8._55.set(2);

    if(r10.class_129.get() == 0) {
      r3 = 0x14ccc;
    } else {
      //LAB_80b73dc
      r3 = 0x10000;
    }

    //LAB_80b73e0
    r8.scale_18.set(r3);
    r8._1c.set(r3);
    FUN_8009098(r8, 0x80c5938);
    CPU.sp().value += 0x14;
  }

  @Method(0x80b7424)
  public static void FUN_80b7424(int r0, int r1, int r2, int r3) {
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x4;
    CPU.r11().value = r2;
    CPU.r9().value = r1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r2 = 0x1e;
    if(r1 > 4) {
      r2 = 0x1b;
    }

    //LAB_80b7442
    r3 = CPU.r9().value;
    r3 = r3 - 0x1;
    r3 = r3 * r2;
    r2 = r3 >>> 31;
    r3 = r3 + r2;
    r1 = 0x0;
    r2 = CPU.r9().value;
    r7 = r3 >> 1;
    CPU.r10().value = r1;
    if(r2 != 0) {
      r6 = r0;
      CPU.r8().value = r1;

      //LAB_80b745c
      do {
        r3 = 0x50;
        r3 = -r3;
        r0 = CPU.r8().value;
        r1 = CPU.r11().value;
        MEMORY.ref(4, r0 + r1).setu(r3);
        r3 = CPU.r10().value;
        r2 = 0x0;
        if(r3 != 0) {
          r3 = MEMORY.ref(2, r6).getUnsigned();
          r3 = r3 + 0xff02;
          r3 = r3 << 16;
          r2 = 0x19;
          if((r3 & 0xffff_ffffL) > 0x10000) {
            final Unit14c r5 = getCharOrMonsterData_(MEMORY.ref(2, r6).getUnsigned());

            if(FUN_80c23c0(r5._128.get()) == 0) {
              r2 = 0x26;
            } else {
              r2 = 0x1b;
            }

            //LAB_80b749c
            r0 = r5._128.get();
            if(r0 == 0x94 || r0 == 0x79) {
              //LAB_80b74ac
              MEMORY.ref(4, CPU.r8().value + CPU.r11().value).setu(-50);
            }
          }
        }

        //LAB_80b74b6
        r3 = r2 >>> 1;
        r7 = r7 - r3;
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = MEMORY.ref(2, r6).getUnsigned();
        r0 = 0xff02;
        r1 = CPU.r8().value;
        MEMORY.ref(4, r1 + r2).setu(r7);
        r3 = r3 + r0;
        r1 = 0x80;
        r3 = r3 << 16;
        r1 = r1 << 9;
        r2 = 0x19;
        if((r3 & 0xffff_ffffL) > (r1 & 0xffff_ffffL)) {
          r0 = FUN_80c23c0(getCharOrMonsterData_(MEMORY.ref(2, r6).getUnsigned())._128.get());
          r2 = 0x1b;
          if(r0 == 0) {
            r2 = 0x26;
          }
        }

        //LAB_80b74ec
        r3 = r2 >>> 1;
        r0 = 0x1;
        r7 = r7 - r3;
        CPU.r10().value = CPU.r10().value + r0;
        r3 = 0x4;
        r6 = r6 + 0x2;
        CPU.r8().value = CPU.r8().value + r3;
      } while(CPU.r10().value != CPU.r9().value);
    }

    //LAB_80b74fe
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80b75dc)
  public static void FUN_80b75dc() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x50;
    r3 = 0x3001e74;
    r2 = CPU.sp().value;
    r3 = MEMORY.ref(4, r3).get();
    r2 = r2 + 0x34;
    r1 = 0x0;
    r0 = r2;
    CPU.r10().value = r3;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    CPU.r9().value = r1;
    r0 = FUN_80b6a60(r0);
    r3 = 0x2e9;
    r5 = r0;
    r2 = 0xff;
    r7 = 0xd;
    r3 = r3 + CPU.r10().value;

    //LAB_80b760c
    do {
      r7 = r7 - 0x1;
      MEMORY.ref(1, r3).setu(r2);
      r3 = r3 - 0x1;
    } while(r7 >= 0);

    r3 = 0x2e9;
    r1 = 0x5;
    r3 = r3 + CPU.r10().value;
    r2 = 0xd;

    //LAB_80b761e
    do {
      r1 = r1 - 0x1;
      MEMORY.ref(1, r3).setu(r2);
      r3 = r3 - 0x1;
      r2 = r2 - 0x1;
    } while(r1 >= 0);

    if(r5 > 0) {
      r3 = 0x80c2a62;
      r1 = MEMORY.ref(4, CPU.sp().value).get();
      r2 = CPU.r9().value;
      CPU.r11().value = r3;
      CPU.r8().value = r1;
      r6 = r2 << 1;
      r7 = r5;

      //LAB_80b763c
      do {
        r5 = MEMORY.ref(2, CPU.r8().value).getUnsigned();
        MEMORY.ref(1, CPU.r10().value + r5 + 0x2dc).setu(CPU.r9().value);
        FUN_80b6f44(FUN_80b7dd0(r5), r5, MEMORY.ref(1, r6 + CPU.r11().value).get(), MEMORY.ref(1, r6 + CPU.r11().value + 0x1).get());
        r6 += 0x2;
        CPU.r8().value += 2;
        CPU.r9().value++;
        r7--;
      } while(r7 != 0);
    }

    //LAB_80b7672
    r5 = CPU.r10().value + 0x2;
    r3 = MEMORY.ref(2, r5 + 0x64).get();
    r7 = 0x0;
    CPU.r11().value = r5;
    if(r3 != 0xff) {
      r4 = MEMORY.ref(4, CPU.sp().value).get();
      r0 = 0x0;
      r2 = 0x64;
      r1 = CPU.r11().value;

      //LAB_80b768a
      do {
        r3 = MEMORY.ref(2, r1 + r2).getUnsigned();
        r7 = r7 + 0x1;
        MEMORY.ref(2, r0 + r4).setu(r3);
        r2 = r2 + 0x2;
        r0 = r0 + 0x2;
        if(r7 > 0x5) {
          break;
        }
        r3 = MEMORY.ref(2, r1 + r2).get();
      } while(r3 != 0xff);
    }

    //LAB_80b769e
    r1 = 0x1c;
    r2 = 0x4;
    r1 = r1 + CPU.sp().value;
    r2 = r2 + CPU.sp().value;
    r5 = r7;
    CPU.r9().value = r1;
    CPU.r10().value = r2;
    r0 = MEMORY.ref(4, CPU.sp().value).get();
    r1 = r5;
    r2 = CPU.r9().value;
    r3 = CPU.r10().value;
    FUN_80b7424(r0, r1, r2, r3);
    if(r5 > 0) {
      r3 = 0x0;
      r6 = r3 << 2;
      r3 = 0x64;
      CPU.r8().value = r3;

      //LAB_80b76c4
      do {
        r1 = CPU.r11().value;
        r3 = CPU.r8().value;
        r5 = MEMORY.ref(2, r1 + r3).get();
        if(r5 != 0xfe) {
          r0 = r5;
          r0 = FUN_80b7dd0(r0);
          r1 = CPU.r9().value;
          r2 = MEMORY.ref(4, r6 + r1).get();
          r1 = CPU.r10().value;
          r3 = MEMORY.ref(4, r6 + r1).get();
          r1 = r5;
          FUN_80b6f44(r0, r1, r2, r3);
        }

        //LAB_80b76e2
        r2 = 0x2;
        r7 = r7 - 0x1;
        CPU.r8().value = CPU.r8().value + r2;
        r6 = r6 + 0x4;
      } while(r7 != 0);
    }

    //LAB_80b76ee
    CPU.sp().value += 0x50;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80b770c)
  public static int FUN_80b770c(int r0, int r1) {
    int r2;
    int r3;
    int r4;

    if(r1 > 0x7) {
      r1 = r1 + 0x78;
    }

    //LAB_80b7714
    r2 = 0x0;

    //LAB_80b7716
    do {
      r4 = 0x0;
      r3 = MEMORY.ref(2, r0 + r4).get();
      r3 = r3 << 16;
      r3 = r3 >>> 16;
      r0 = r0 + 0x2;
      if(r3 == 0xff) {
        break;
      }
      if(r3 == r1) {
        return 1;
      }

      //LAB_80b772c
      r2 = r2 + 0x1;
    } while((r2 & 0xffff_ffffL) <= (0xd & 0xffff_ffffL));

    //LAB_80b7732
    r0 = 0x0;

    //LAB_80b7734
    return r0;
  }

  @Method(0x80b7738)
  public static void FUN_80b7738() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x2c;
    r1 = CPU.sp().value + 0x10;
    CPU.r10().value = r1;
    r0 = 0x3;
    r0 = FUN_80b6c08(r0, r1);
    r7 = 0x0;
    r2 = CPU.r10().value;
    r3 = MEMORY.ref(2, r2 + r7).getUnsigned();
    if(r3 != 0xff) {
      r2 = 0x0;

      //LAB_80b775e
      do {
        r3 = CPU.r10().value;
        r0 = MEMORY.ref(2, r3 + r2).getUnsigned();
        r0 = FUN_80b7dd0(r0);
        r6 = r0;
        if(r6 != 0) {
          r5 = MEMORY.ref(4, r6).get();
          FUN_80b7994(r0);
          r3 = MEMORY.ref(4, r6 + 0x24).get();
          if(r3 != 0) {
            r0 = r5;
            r1 = 0x0;
            r0 = FUN_80b7f70(r0, r1);
            if(r0 != 0) {
              r3 = MEMORY.ref(4, r5 + 0xc).get();
              r1 = 0x0;
              if(r3 != 0) {
                r1 = 0x9;
              }

              //LAB_80b778e
              r2 = MEMORY.ref(4, r6 + 0x24).get();
              r3 = MEMORY.ref(1, r2 + 0x6).getUnsigned();
              if(r3 != r1) {
                MEMORY.ref(1, r2 + 0x6).setu(r1);
                r2 = r0;
                r2 = r2 + 0x25;
                r3 = 0x1;
                MEMORY.ref(1, r2).setu(r3);
              }
            }
          }
        }

        //LAB_80b77a0
        r7 = r7 + 0x1;
        if(r7 > 0xd) {
          break;
        }
        r3 = r7 << 1;
        r2 = r3;
        r1 = CPU.r10().value;
        r3 = MEMORY.ref(2, r1 + r2).getUnsigned();
      } while(r3 != 0xff);
    }

    //LAB_80b77b2
    r3 = 0x3001e80;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x36;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 >= 0) {
      r3 = 0x1;
      r1 = 0x2;
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    } else {
      //LAB_80b77c8
      r2 = 0x2;
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    }

    //LAB_80b77d0
    r0 = 0x1;
    r1 = CPU.r10().value;
    r0 = FUN_80b6c08(r0, r1);
    r7 = 0x0;
    CPU.r9().value = r0;
    if(r7 < CPU.r9().value) {
      r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r3 = 0x3;
      r3 = r3 & r1;
      r2 = r3 << 2;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      CPU.r11().value = r3;
      CPU.r8().value = CPU.r10().value;

      //LAB_80b77ee
      do {
        r3 = CPU.r8().value;
        r1 = 0x2;
        r0 = MEMORY.ref(2, r3).getUnsigned();
        CPU.r8().value = CPU.r8().value + r1;
        r0 = FUN_80b7dd0(r0);
        if(r0 != 0) {
          r5 = MEMORY.ref(4, r0).get();
          r3 = r5;
          r3 = r3 + 0x54;
          r3 = MEMORY.ref(1, r3).getUnsigned();
          r2 = 0xf;
          r2 = r2 & r3;
          if(r2 == 0x1) {
            //LAB_80b7814
            r0 = MEMORY.ref(4, r5 + 0x50).get();
            r2 = 0xd;
            r3 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r2 = -r2;
            r3 = r3 & r2;
            r3 = r3 | r1;
            MEMORY.ref(1, r0 + 0x9).setu(r3);
          } else {
            if(r2 == 0x2) {
              //LAB_80b7826
              r2 = CPU.r11().value;
              r6 = 0xd;
              r1 = MEMORY.ref(4, r5 + 0x50).get();
              r6 = -r6;
              r5 = r2 << 2;
              r4 = 0x3;

              //LAB_80b7832
              do {
                r0 = MEMORY.ref(4, r1).get();
                r1 += 0x4;
                if(r0 != 0) {
                  r2 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
                  r3 = r6;
                  r3 = r3 & r2;
                  r3 = r3 | r5;
                  MEMORY.ref(1, r0 + 0x9).setu(r3);
                }

                //LAB_80b7842
                r4 = r4 - 0x1;
              } while(r4 >= 0);
            }
          }
        }

        //LAB_80b7848
        r7 = r7 + 0x1;
      } while(r7 < CPU.r9().value);
    }

    //LAB_80b784e
    r0 = 0x2;
    r1 = CPU.r10().value;
    r0 = FUN_80b6c08(r0, r1);
    r7 = 0x0;
    CPU.r9().value = r0;
    if(r7 < CPU.r9().value) {
      r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r3 = 0x3;
      r3 = r3 & r1;
      r2 = r3 << 2;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      CPU.r11().value = r3;
      CPU.r8().value = CPU.r10().value;

      //LAB_80b786c
      do {
        r3 = CPU.r8().value;
        r1 = 0x2;
        r0 = MEMORY.ref(2, r3).getUnsigned();
        CPU.r8().value = CPU.r8().value + r1;
        r0 = FUN_80b7dd0(r0);
        if(r0 != 0) {
          r5 = MEMORY.ref(4, r0).get();
          r3 = r5;
          r3 = r3 + 0x54;
          r3 = MEMORY.ref(1, r3).getUnsigned();
          r2 = 0xf;
          r2 = r2 & r3;
          if(r2 == 0x1) {
            //LAB_80b7892
            r0 = MEMORY.ref(4, r5 + 0x50).get();
            r2 = 0xd;
            r3 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
            r1 = MEMORY.ref(4, CPU.sp().value).get();
            r2 = -r2;
            r3 = r3 & r2;
            r3 = r3 | r1;
            MEMORY.ref(1, r0 + 0x9).setu(r3);
          } else {
            if(r2 == 0x2) {
              //LAB_80b78a4
              r2 = CPU.r11().value;
              r6 = 0xd;
              r1 = MEMORY.ref(4, r5 + 0x50).get();
              r6 = -r6;
              r5 = r2 << 2;
              r4 = 0x3;

              //LAB_80b78b0
              do {
                r0 = MEMORY.ref(4, r1).get();
                r1 += 0x4;
                if(r0 != 0) {
                  r2 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
                  r3 = r6;
                  r3 = r3 & r2;
                  r3 = r3 | r5;
                  MEMORY.ref(1, r0 + 0x9).setu(r3);
                }

                //LAB_80b78c0
                r4 = r4 - 0x1;
              } while(r4 >= 0);
            }
          }
        }

        //LAB_80b78c6
        r7 = r7 + 0x1;
      } while(r7 < CPU.r9().value);
    }

    //LAB_80b78cc
    CPU.sp().value += 0x2c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80b78e4)
  public static void FUN_80b78e4(final int r0, int r1) {
    final int r5 = r1;
    final Unit14c r2 = getCharOrMonsterData_(r0);
    int r3 = r2.affliction_131.get();
    r1 = 0x0;
    if(r3 == 0x1) {
      r1 = 0x1;
    }

    //LAB_80b7900
    if(r3 == 0x2) {
      r1 = r1 | 0x2;
    }

    //LAB_80b7906
    if(r2._138.get() != 0) {
      r1 = r1 | 0x20;
    }

    //LAB_80b7916
    if(r2._13b.get() != 0) {
      r1 = r1 | 0x4;

      if(r2._128.get() == 0x79 || r2._128.get() == 0x94) {
        //LAB_80b7932
        r1 = r1 & ~0x4;
      }
    }

    //LAB_80b7938
    if(r2._13d.get() != 0) {
      r1 = r1 | 0x8;
    }

    //LAB_80b7946
    if(r2.haunt_140.get() != 0) {
      r1 = r1 | 0x40;
    }

    //LAB_80b7956
    if(r2._13c.get() != 0) {
      r1 = r1 | 0x10;
    }

    //LAB_80b7966
    r3 = r2._141.get();
    if(r3 != 0) {
      r1 = r1 | 0x1 << r3 + 6;
    }

    //LAB_80b797a
    MEMORY.ref(2, r5 + 0x1c).setu(r1);
  }

  @Method(0x80b7994)
  public static void FUN_80b7994(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b7aac)
  public static void FUN_80b7aac(final int r0) {
    final Unit14c r2 = getCharOrMonsterData_(r0);
    int r5 = 0x1;
    if(r2.hp_38.get() == 0) {
      //LAB_80b7af6
      final int r3 = r2._12a.get() ^ 0x1;
      r5 = (-r3 | r3) >>> 31;
      r5 = 0x5 - r5;
    } else if(r2._13c.get() != 0 || r2._13b.get() != 0 || r2._145.get() != 0) {
      //LAB_80b7ae0
      final int r3 = r2._12a.get() ^ 0x1;
      r5 = (-r3 | r3) >>> 31;
      r5 = r5 << 2;
    }

    //LAB_80b7b0a
    final Actor70 actor = MEMORY.ref(4, FUN_80b7dd0(r0)).deref(4).cast(Actor70::new);
    setActorAnimation_(actor, r5);
    FUN_8009088(actor, (r0 & 0x3) + 0xe);
  }

  @Method(0x80b7b30)
  public static void FUN_80b7b30(int r0) {
    r0 = FUN_80b7dd0(r0);
    if(r0 == 0) {
      return;
    }
    final int r5 = MEMORY.ref(4, r0).get();
    if(r5 == 0) {
      return;
    }

    int r6 = 0;
    MEMORY.ref(4, r0 + 0x20).setu(0);
    MEMORY.ref(4, r0 + 0x24).setu(0);

    //LAB_80b7b50
    do {
      r0 = FUN_80b7f70(r5, r6);
      if(r0 == 0) {
        break;
      }

      //LAB_80b7b4a
      clearSprite_(MEMORY.ref(4, r0, Sprite38::new));
      r6++;
    } while(true);

    MEMORY.ref(1, r5 + 0x54).setu(0);
    MEMORY.ref(4, r5 + 0x50).setu(0);
  }

  @Method(0x80b7b6c)
  public static void FUN_80b7b6c(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    Sprite38 r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x1c;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    r1 = 0x0;
    CPU.r11().value = r1;

    //LAB_80b7b84
    do {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      r1 = CPU.r11().value;
      r0 = FUN_80b770c(r0, r1);
      if(r0 == 0) {
        r0 = CPU.r11().value;
        r2 = CPU.r11().value;
        r0 = r0 + 0x78;
        if(r2 <= 7) {
          r0 = CPU.r11().value;
        }

        //LAB_80b7b9c
        FUN_80b7b30(r0);
      }

      //LAB_80b7ba0
      r3 = 0x1;
      CPU.r11().value = CPU.r11().value + r3;
      r1 = CPU.r11().value;
    } while(r1 < 14);

    r3 = 0x3001a10;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    if(r3 == 0) {
      r0 = 0x1;
      sleep(r0);
    }

    //LAB_80b7bb8
    r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r1 = 0x0;
    r3 = MEMORY.ref(2, r3 + r1).get();
    r2 = 0x0;
    CPU.r11().value = r2;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    if(r3 != 0xff) {
      //LAB_80b7bca
      r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);

      //LAB_80b7bce
      do {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        if(r2 != 0xfe) {
          //LAB_80b7bd6
          r0 = r2;
          r0 = FUN_80b7dd0(r0);
          r7 = r0;
          if(r7 != 0) {
            //LAB_80b7be4
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = r7;
            FUN_80b78e4(r0, r1);
            r3 = MEMORY.ref(4, r7).get();
            CPU.r8().value = r3;
            if(r3 != 0) {
              //LAB_80b7bf6
              r1 = CPU.r8().value;
              r1 = r1 + 0x54;
              r2 = MEMORY.ref(1, r1).getUnsigned();
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
              if(r2 == 0) {
                //LAB_80b7c04
                r2 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
                r3 = 0xfff;
                r3 = r3 & r2;
                r2 = 0xee;
                r2 = r2 << 1;
                if(r3 == r2 || r3 == r2 + 0x7) {
                  //LAB_80b7c18
                  r3 = 0x3001e68;
                  r2 = MEMORY.ref(4, r3).get();
                  r3 = MEMORY.ref(4, r2 + 0x18).get();
                  r3 = r3 << 2;
                  r2 = r2 + r3;
                  CPU.r9().value = r2;
                  r3 = 0x8;
                  r3 = r3 + CPU.r9().value;
                  CPU.r10().value = r3;
                  r3 = 0x2;
                  MEMORY.ref(1, r1).setu(r3);
                  r2 = CPU.r8().value;
                  r5 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
                  r1 = CPU.r10().value;
                  MEMORY.ref(4, r2 + 0x50).setu(r1);
                  MEMORY.call(0x3000164, CPU.r10().value, 0x10); // memzero
                  r6 = loadSprite_(r5);
                  if(r6 != null) {
                    r6.scale_18.set((int)MEMORY.call(0x3000118, r6.scale_18.get(), MEMORY.ref(4, r7 + 0x18).get()));
                    r0 = getSpriteData(r5);
                    MEMORY.ref(2, CPU.r8().value + 0x20).setu(MEMORY.ref(1, r0 + 0x9).getUnsigned() >>> 1);
                    MEMORY.ref(4, CPU.r10().value).setu(r6.getAddress());
                    CPU.r10().value = CPU.r9().value + 0xc;
                    r6._26.set(MEMORY.ref(1, CPU.sp().value + 0xc).getUnsigned());
                  }

                  //LAB_80b7c82
                  r6 = loadSprite_(0x2001 + r5);
                  if(r6 != null) {
                    r6.scale_18.set((int)MEMORY.call(0x3000118, r6.scale_18.get(), MEMORY.ref(4, r7 + 0x18).get()));
                    MEMORY.ref(4, CPU.r10().value).setu(r6.getAddress());
                    r6._26.set(MEMORY.ref(1, CPU.sp().value + 0xc).getUnsigned());
                  }

                  //LAB_80b7caa
                } else {
                  //LAB_80b7cb4
                  r6 = loadSprite_(MEMORY.ref(2, r7 + 0x4).getUnsigned());
                  if(r6 != null) {
                    MEMORY.ref(1, r1).setu(1);
                    MEMORY.ref(4, CPU.r8().value + 0x50).setu(r6.getAddress());
                    r6.scale_18.set((int)MEMORY.call(0x3000118, r6.scale_18.get(), MEMORY.ref(4, r7 + 0x18).get()));
                    final SpriteLayer18 layer = r6.layers_28.get(0).deref();
                    layer._06.set(1);
                    layer._05.set(MEMORY.ref(4, r7 + 0x14).get());
                    r5 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                    if(r5 != 0) {
                      final SpriteLayer18 r5_0 = addLayerToSprite_(r6, r5);
                      r5_0._06.set(1);
                    }

                    //LAB_80b7cf8
                    r5 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
                    if(r5 != 0) {
                      final SpriteLayer18 r5_0 = addLayerToSprite_(r6, r5);
                      MEMORY.ref(4, r7 + 0x20).setu(r5_0.getAddress());
                      FUN_8009070(r5_0, 0);
                      r5_0._06.set(3);
                    }

                    //LAB_80b7d14
                    r5 = MEMORY.ref(2, r7 + 0xa).getUnsigned();
                    if(r5 != 0) {
                      if(r6.width_20.get() == 32) {
                        r5 = 0x1ff;
                      }

                      //LAB_80b7d26
                      final SpriteLayer18 r5_0 = addLayerToSprite_(r6, r5);
                      r1 = MEMORY.ref(1, CPU.sp().value + 0xc).getUnsigned();
                      MEMORY.ref(4, r7 + 0x24).setu(r5_0.getAddress());
                      r5_0._06.set(r1);
                      r6._26.set(r1);
                    }
                  }
                }

                //LAB_80b7d40
                r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                FUN_80b7aac(r0);
              }
            }
          }
        }

        //LAB_80b7d46
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        CPU.r11().value++;
        r3 = r3 + 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        if(CPU.r11().value > 13) {
          break;
        }
        r1 = 0x0;
        r3 = MEMORY.ref(2, r3 + r1).get();
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
        if(r3 == 0xff) {
          break;
        }
      } while(true);
    }

    //LAB_80b7d62
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    if(r2 != 0) {
      r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      r1 = 0x0;
      r5 = MEMORY.ref(2, r2 + r1).get();
      r3 = 0x0;
      CPU.r11().value = r3;
      if(r5 != 0xff) {
        //LAB_80b7d76
        do {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r3 = MEMORY.ref(2, r3 + r1).get();
          if(r3 != 0xfe) {
            r0 = r5;
            r0 = FUN_80b7dd0(r0);
            r7 = r0;
            if(r7 != 0) {
              r7 = MEMORY.ref(4, r7).get();
              CPU.r8().value = r7;
              r3 = CPU.r8().value;
              if(r3 != 0) {
                r0 = r5;
                FUN_80b7aac(r0);
              }
            }
          }

          //LAB_80b7d9a
          r1 = 0x1;
          CPU.r11().value = CPU.r11().value + r1;
          r2 = CPU.r11().value;
          if(r2 > 13) {
            break;
          }
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r3 = r2 << 1;
          r5 = MEMORY.ref(2, r3 + r1).get();
        } while(r5 != 0xff);
      }
    }

    //LAB_80b7dae
    CPU.sp().value += 0x1c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80b7dd0)
  public static int FUN_80b7dd0(int charId) {
    final int r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();

    if(charId > 7) {
      charId = charId - 0x78;
    }

    //LAB_80b7de0
    if(MEMORY.ref(1, r2 + 0x2dc + charId).getUnsigned() == 0xff) {
      return 0;
    }

    //LAB_80b7df0
    return r2 + 0x74 + MEMORY.ref(1, r2 + 0x2dc + charId).getUnsigned() * 0x2c;
  }

  @Method(0x80b7e7c)
  public static void FUN_80b7e7c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b7f70)
  public static int FUN_80b7f70(int r0, final int r1) {
    int r3 = MEMORY.ref(1, r0 + 0x54).getUnsigned();
    if((r3 & 0xf) == 0x1) {
      if(r1 != 0) {
        r0 = 0;
      } else {
        r0 = MEMORY.ref(4, r0 + 0x50).get();
      }
      //LAB_80b7f88
    } else if((r3 & 0xf) == 0x2) {
      r3 = MEMORY.ref(4, r0 + 0x50).get();
      r0 = MEMORY.ref(4, r3 + r1 * 0x4).get();
    } else {
      //LAB_80b7f94
      r0 = 0;
    }

    //LAB_80b7f96
    return r0;
  }

  @Method(0x80b7f9c)
  public static void FUN_80b7f9c() {
    final int r5 = boardWramMallocHead_3001e50.offset(12 * 0x4).get();
    MEMORY.ref(2, r5 + 0x36).setu(0x3000);
    MEMORY.ref(2, r5 + 0x34).setu(0xfe00);
    MEMORY.ref(4, r5 + 0x20).setu(0x1fe0000);
    MEMORY.ref(4, r5 + 0xc).setu(0);
    MEMORY.ref(4, r5 + 0x10).setu(0);
    MEMORY.ref(4, r5 + 0x14).setu(0);
    MEMORY.ref(4, r5 + 0x1c).setu(0);
    MEMORY.ref(4, r5 + 0x18).setu(0);
    FUN_80049ac();
    FUN_8004cb4(r5 + 0xc);
    FUN_8004c1c(MEMORY.ref(2, r5 + 0x36).get());
    FUN_8004bd4(MEMORY.ref(2, r5 + 0x34).get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, MEMORY.ref(4, r5 + 0x20).get()), r5);
  }

  @Method(0x80b8574)
  public static int FUN_80b8574(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b874c)
  public static int FUN_80b874c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b8fd4)
  public static void FUN_80b8fd4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b9934)
  public static int FUN_80b9934(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b9b2c)
  public static void FUN_80b9b2c() {
    // no-op
  }

  @Method(0x80b9b30)
  public static int FUN_80b9b30(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80bb65c)
  public static int FUN_80bb65c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;

    //LAB_80bb674
    while(FUN_8015048() == 0) {
      //LAB_80bb66e
      sleep(1);
    }

    r0 = 0x80;
    r7 = CPU.sp().value + 0x4;
    r0 = FUN_80040b4(r0);
    r1 = 0x0;
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    CPU.r11().value = r0;

    //LAB_80bb68a
    do {
      r2 = 0x3001e40;
      r5 = MEMORY.ref(4, r2).get();
      r3 = 0x7;
      r5 = r5 >>> 2;
      r5 = r5 & r3;
      r3 = 0x80c3734;
      r5 = r5 << 7;
      r5 = r5 + r3;
      r3 = 0x3001ee4;
      r3 = MEMORY.ref(4, r3).get();
      r6 = 0x400004a;
      r1 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      r0 = r6;
      CPU.r10().value = r1;
      r1 = 0x4;
      CPU.r8().value = r2;
      CPU.r9().value = r3;
      FUN_80039fc(r0, r1);
      r0 = r6;
      r1 = 0x10;
      FUN_800393c(r0, r1);
      r2 = 0x10;
      r3 = 0x4000052;
      MEMORY.ref(2, r3).setu(r2);
      r3 = 0xa4;
      r3 = r3 << 8;
      MEMORY.ref(4, r7 + 0x4).setu(r3);
      r3 = 0x0;
      MEMORY.ref(4, r7 + 0x8).setu(r3);
      r1 = r5;
      r0 = CPU.r11().value;
      r0 = FUN_80040d0(r0, r1);
      r3 = 0x3ff;
      r2 = 0xfffffc00;
      r0 = r0 & r3;
      r3 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
      r3 = r3 & r2;
      r2 = CPU.r10().value;
      r3 = r3 | r0;
      r1 = MEMORY.ref(2, r2 + 0xc).getUnsigned();
      r2 = CPU.r9().value;
      MEMORY.ref(2, r7 + 0x8).setu(r3);
      r3 = MEMORY.ref(2, r2 + 0x4).getUnsigned();
      r1 = r1 << 3;
      r3 = r3 >>> 8;
      r1 = r1 + r3;
      r3 = 0x1ff;
      r1 = r1 + 0x4;
      r1 = r1 & r3;
      r2 = 0xfffffe00;
      r3 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
      r3 = r3 & r2;
      r3 = r3 | r1;
      MEMORY.ref(2, r7 + 0x6).setu(r3);
      r3 = CPU.r8().value;
      r0 = MEMORY.ref(4, r3).get();
      r0 = r0 << 12;
      r0 = sin(r0);
      if(r0 < 0) {
        r1 = 0x7fff;
        r0 = r0 + r1;
      }

      //LAB_80bb738
      r1 = CPU.r10().value;
      r3 = MEMORY.ref(2, r1 + 0xe).getUnsigned();
      r2 = r0 >> 15;
      r3 = r3 << 3;
      r1 = CPU.r9().value;
      r2 = r2 + r3;
      r3 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
      r3 = r3 >>> 8;
      r3 = r3 + r2;
      r3 = r3 + 0x6;
      MEMORY.ref(1, r7 + 0x4).setu(r3);
      insertIntoRenderQueue(MEMORY.ref(4, r7, RenderPacket0c::new), 240);
      r1 = 0x3001ae8;
      r3 = MEMORY.ref(4, r1).get();
      r2 = 0x2;
      r3 = r3 & r2;
      if(r3 != 0) {
        break;
      }
      r3 = 0x3001c94;
      r2 = 0x303;
      r3 = MEMORY.ref(4, r3).get();
      r3 = r3 & r2;
      if(r3 != 0) {
        break;
      }
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      if(r3 > 0xf) {
        r3 = MEMORY.ref(4, r1).get();
        r3 = r3 & r2;
        if(r3 != 0) {
          break;
        }
      }

      //LAB_80bb77c
      r0 = 0x1;
      sleep(r0);
      r1 = MEMORY.ref(4, CPU.sp().value).get();
      r1 = r1 + 0x1;
      MEMORY.ref(4, CPU.sp().value).setu(r1);
    } while(true);

    //LAB_80bb78a
    r0 = 0x6f;
    playSound_(r0);
    r0 = CPU.r11().value;
    r0 = clearVramSlot(r0);
    r0 = 0x1;
    sleep(r0);
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }


  @Method(0x80bb7c0)
  public static void FUN_80bb7c0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80be0b4)
  public static int FUN_80be0b4(final int r0, final int out) {
    CPU.sp().value -= 0x14;
    final int r9 = CPU.sp().value + 0x4;
    final int r7 = FUN_80b6c08((r0 & 0xffff_ffffL) > 7 ? 2 : 1, r9);

    //LAB_80be0e8
    final RecoveryQueue10c r8 = getDjinnRecoveryQueue_((r0 & 0xffff_ffffL) > 7 ? 1 : 0);
    if(out != 0) {
      //LAB_80be0fa
      for(int i = 0; i < 4; i++) {
        MEMORY.ref(1, out + i).setu(0);
      }
    }

    //LAB_80be102
    //LAB_80be11c
    int r11 = 0;
    for(int r10 = 0; r10 < r8.count_108.get(); r10++) {
      if(r8._08.get(r10)._03.get() == -1) {
        //LAB_80be13c
        int r4;
        for(r4 = 0; r4 < r7 && MEMORY.ref(2, r9 + r4 * 0x2).getUnsigned() != r8._08.get(r10).charId_02.get(); r4++) {
          //
        }

        //LAB_80be14c
        if(r4 != r7) {
          if(out != 0) {
            MEMORY.ref(1, out + r8._08.get(r10).element_00.get()).incr();
          }

          //LAB_80be160
          r11++;
        }
      }

      //LAB_80be164
    }

    //LAB_80be176
    CPU.sp().value += 0x14;
    return r11;
  }

  @Method(0x80bf5a8)
  public static int FUN_80bf5a8() {
    final RecoveryQueue10c queue = getDjinnRecoveryQueue_(0);
    int r2 = 0;

    //LAB_80bf5ce
    for(int r8 = 0; r8 < queue.count_108.get(); r8++) {
      if(queue._08.get(r8)._03.get() > 0) {
        final Unit14c r0 = getCharOrMonsterData_(queue._08.get(r8).charId_02.get());
        if(r0.hp_38.get() != 0) {
          queue._08.get(r8)._03.decr();
        }
      }

      //LAB_80bf5ee
    }

    //LAB_80bf600
    //LAB_80bf612
    for(int r8 = 0; r8 < queue.count_108.get(); ) {
      if(queue._08.get(r8)._03.get() == 0) {
        final int charId = queue._08.get(r8).charId_02.get();
        setDjinn_(charId, queue._08.get(r8).element_00.get(), queue._08.get(r8).djinn_01.get());
        recoverDjinn_(charId, queue._08.get(r8).element_00.get(), queue._08.get(r8).djinn_01.get());
        recalcStats_(charId);
        r2 = 1;
      } else {
        //LAB_80bf63a
        r8++;
      }

      //LAB_80bf640
    }

    //LAB_80bf64c
    return r2;
  }

  @Method(0x80bf674)
  public static void FUN_80bf674() {
    // no-op
  }

  @Method(0x80bf678)
  public static void FUN_80bf678() {
    throw new RuntimeException("Not implemented");
  }
}
