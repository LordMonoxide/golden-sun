package org.goldensun;

import org.goldensun.battle.Camera4c;
import org.goldensun.battle.BattleStruct82c;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
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

import javax.annotation.Nullable;

import static org.goldensun.GoldenSun.FUN_80037d4;
import static org.goldensun.GoldenSun.FUN_800393c;
import static org.goldensun.GoldenSun.FUN_80039fc;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.allocateFirstFreeSpriteSlot;
import static org.goldensun.GoldenSun.FUN_80040d0;
import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.rotateMatrixX;
import static org.goldensun.GoldenSun.rotateMatrixY;
import static org.goldensun.GoldenSun.translateMatrix;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.FUN_80051e8;
import static org.goldensun.GoldenSun.FUN_8005258;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_8009050;
import static org.goldensun.GoldenSun.FUN_8009070;
import static org.goldensun.GoldenSun.FUN_8009088;
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
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setActorSpriteScript_;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.waitForFade;
import static org.goldensun.GoldenSunVars._200042e;
import static org.goldensun.GoldenSunVars._3001a10;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars._80c2a7c;
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
import static org.goldensun.GoldenSun_801.FUN_80151c0;
import static org.goldensun.GoldenSun_801.FUN_80151c8;
import static org.goldensun.GoldenSun_801.FUN_8015218;
import static org.goldensun.GoldenSun_801.FUN_80153b0;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawIcon;
import static org.goldensun.GoldenSun_807.FUN_8077078;
import static org.goldensun.GoldenSun_807.FUN_80770e0;
import static org.goldensun.GoldenSun_807.FUN_8077140;
import static org.goldensun.GoldenSun_807.FUN_80771c8;
import static org.goldensun.GoldenSun_807.getSummon_;
import static org.goldensun.GoldenSun_807.FUN_8077210;
import static org.goldensun.GoldenSun_807.FUN_8077228;
import static org.goldensun.GoldenSun_807.FUN_8077230;
import static org.goldensun.GoldenSun_807.FUN_807822c;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.lcgRand_;
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
import static org.goldensun.GoldenSun_80c.FUN_80c0a24;
import static org.goldensun.GoldenSun_80c.FUN_80c0cec;
import static org.goldensun.GoldenSun_80c.FUN_80c1ffc;
import static org.goldensun.GoldenSun_80c.FUN_80c23a0;
import static org.goldensun.GoldenSun_80c.FUN_80c23c0;
import static org.goldensun.GoldenSun_80c.FUN_80c24b0;
import static org.goldensun.GoldenSun_80c.FUN_80c2724;
import static org.goldensun.GoldenSun_80c.getActorPropertiesSprite;
import static org.goldensun.GoldenSun_80c.loadBattleBackground;
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
    allocateSpriteSlot(r0, 0x80, 0x80b3940);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x392).setu(r0);
    allocateSpriteSlot(r0, 0x80, 0x80b3b40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x394).setu(r0);
    allocateSpriteSlot(r0, 0x80, 0x80b3bc0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x396).setu(r0);
    allocateSpriteSlot(r0, 0x80, 0x80b39c0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x39a).setu(r0);
    allocateSpriteSlot(r0, 0x80, 0x80b3a40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x398).setu(r0);
    allocateSpriteSlot(r0, 0x80, 0x80b3ac0);
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

  /** {@link GoldenSun_80b#loadUnitSprites} */
  @Method(0x80b5010)
  public static void loadUnitSprites_(final int[] unitIds, final int setAnimations) {
    MEMORY.call(0x80b7b6c, unitIds, setAnimations);
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

  /** {@link GoldenSun_80c#loadBattleBackground} */
  @Method(0x80b5040)
  public static void loadBattleBackground_(final int r0, final int pointerTableEntry, final int r2) {
    MEMORY.call(0x80c08ec, r0, pointerTableEntry, r2);
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

  /** {@link GoldenSun_80b#getUnitIds} */
  @Method(0x80b5090)
  public static int getUnitIds_(final int flags, final int[] out) {
    return (int)MEMORY.call(0x80b6c08, flags, out);
  }

  /** {@link GoldenSun_80b#getCombatantForUnit} */
  @Method(0x80b5098)
  public static BattleStruct82c.Combatant2c getCombatantForUnit_(final int unitId) {
    return (BattleStruct82c.Combatant2c)MEMORY.call(0x80b7dd0, unitId);
  }

  /** {@link GoldenSun_80b#loadBattle} */
  @Method(0x80b50a0)
  public static int loadBattle_(final int entranceId) {
    return (int)MEMORY.call(0x80b63c8, entranceId);
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

  /** {@link GoldenSun_80b#getBattleChars} */
  @Method(0x80b50c8)
  public static int getBattleChars_(@Nullable final int[] out) {
    return (int)MEMORY.call(0x80b6a60, out);
  }

  /** {@link GoldenSun_80b#FUN_80b8fd4} */
  @Method(0x80b50d0)
  public static void FUN_80b50d0(final int r0) {
    MEMORY.call(0x80b8fd4, r0);
  }

  /** {@link GoldenSun_80b#getActorSprite} */
  @Method(0x80b50d8)
  public static Sprite38 getActorSprite_(final Actor70 actor, final int spriteIndex) {
    return (Sprite38)MEMORY.call(0x80b7f70, actor, spriteIndex);
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

  /** {@link GoldenSun_80b#loadAllUnitSpritesAndSetAnimations} */
  @Method(0x80b5118)
  public static void loadAllUnitSpritesAndSetAnimations_() {
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
  public static void decompressBattleBackground(int r0, int r1) {
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
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    final BattleStruct82c r1 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int r7 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    if(r1._44.get() != 0) {
      if((_3001f64.get() & 0x3) == 0x3) {
        //LAB_80b58a8
        if(r1._50.get() != MEMORY.ref(4, 0x4000128).get() << 26 >>> 30) { // SIOCNT
          r1._52.set(1);
        }

        //LAB_80b58c2
        r1._51.set(0);
      } else {
        r1._51.incr();
        if(r1._51.get() > 24) {
          r1._52.set(1);
        }
      }
    }

    //LAB_80b58ca
    if(MEMORY.ref(4, r7 + 0x4).get() != 0) {
      camera.rotationY_36.add((MEMORY.ref(4, r7).get() - camera.rotationY_36.get()) / 16);
      MEMORY.ref(4, r7 + 0x4).incr();
    }

    //LAB_80b58ee
    final Vec3 r5;
    if(!camera._1c.isNull()) {
      r5 = camera._1c.deref();
    } else {
      r5 = camera._0c;
    }

    //LAB_80b58fa
    initMatrixStack();
    translateMatrix(r5);
    rotateMatrixY(camera.rotationY_36.get());
    rotateMatrixX(camera.rotationX_34.get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, camera._20.get()), camera._00);

    if(MEMORY.ref(4, r7 + 0x14).get() == 0) {
      FUN_80c0a24(0x780000, 0x780000, 0, 0, 0x10000);
    }

    //LAB_80b5942
  }

  @Method(0x80b595c)
  public static void FUN_80b595c(final int r0) {
    CPU.sp().value -= 0x10;
    final BattleStruct82c r10 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    FUN_8015118();
    final int[] r6 = new int[7];
    getBattleMonsters(r6);

    //LAB_80b5984
    for(int r5 = 0; r5 < r0; r5++) {
      FUN_8015120(r6[r5], 1);

      if(r5 == r0 - 1) {
        FUN_80151c8(0x811);
      } else {
        //LAB_80b599a
        FUN_80151c8(0x810);
      }

      //LAB_80b59a0
      FUN_80bb65c();
    }

    //LAB_80b59aa
    FUN_8015218();

    final int r3 = r10._45.get();
    if(r3 == 0x1) {
      FUN_8015118();
      FUN_8015120(0, 1);
      FUN_80151c8(0x812);
      FUN_80bb65c();
      //LAB_80b59d0
    } else if(r3 == 0x2) {
      FUN_8015118();
      FUN_8015120(0, 1);
      FUN_80151c8(0x813);
      FUN_80bb65c();
    }

    //LAB_80b59ea
    CPU.sp().value += 0x10;
  }

  @Method(0x80b5a0c)
  public static void loadBattleCharsAndMonsters() {
    final int[] ids = new int[7];
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    int count = getBattleChars(ids);

    //LAB_80b5a2c
    for(int i = 0; i < count; i++) {
      r5.charIds_58.get(i).set(ids[i]);
    }

    //LAB_80b5a3a
    r5.charIds_58.get(count).set(0xff);

    count = getBattleMonsters(ids);

    if(r5._42.get() < 2) {
      //LAB_80b5a74
      for(int i = 0; i < count; i++) {
        r5.monsterIds_66.get(i).set(ids[i]);
      }
    } else {
      //LAB_80b5a84
      //LAB_80b5a9a
      for(int i = 0; i < count; i++) {
        final int r3 = MEMORY.ref(1, 0x80c2a10 + i).get() + count / 2; // load monsters in alternating left/right pattern
        r5.monsterIds_66.get(r3).set(ids[i]);
      }
    }

    //LAB_80b5aba
    r5.monsterIds_66.get(count).set(0xff);
  }

  @Method(0x80b5b14)
  public static void noop_80b5b14(final int r0) {
    // no-op
  }

  @Method(0x80b5b18)
  public static void FUN_80b5b18() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b5c08)
  public static void FUN_80b5c08() {
    final int[] charIds = new int[5];
    final int charCount = getBattleChars(charIds);

    //LAB_80b5c28
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      final int charId = charIds[charSlot];

      //LAB_80b5c2e
      for(int element = 0; element < 4; element++) {
        //LAB_80b5c30
        for(int djinn = 0; djinn < 20; djinn++) {
          if(FUN_8077210(charId, element, djinn) != 0) {
            //LAB_80b5c46
            final RecoveryQueue10c r1 = getDjinnRecoveryQueue_(charId > 7 ? 1 : 0);

            //LAB_80b5c6a
            int r0 = 0;
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
          if(getCombatantForUnit(r7.charId_02.get()) == null) {
            setDjinn_(r7.charId_02.get(), r7.element_00.get(), r7.djinn_01.get());
            recoverDjinn_(r7.charId_02.get(), r7.element_00.get(), r7.djinn_01.get());
          }
        }

        //LAB_80b5d18
      }
    }

    //LAB_80b5d2a
  }

  @Method(0x80b5d3c)
  public static void FUN_80b5d3c() {
    CPU.sp().value -= 0x20;
    final int[] charIds = new int[5];
    final int charCount = getBattleChars(charIds);
    final int r10 = CPU.sp().value + 0x1c;

    //LAB_80b5d64
    for(int r8 = 0; r8 < 4; r8++) {
      MEMORY.ref(1, r10 + r8).setu(0);

      //LAB_80b5d7c
      for(int i = 0; i < charCount; i++) {
        MEMORY.ref(1, r10 + r8).addu(getCharOrMonsterData_(charIds[i])._118.get(r8).get());
      }

      //LAB_80b5d9e
    }

    //LAB_80b5dac
    int r11 = 0; //TODO bitset of available summons?
    for(int r8 = 0; r8 < 32; r8++) {
      final int summon = getSummon_(r8);

      if(summon != 0) {
        //LAB_80b5dc6
        int r4;
        for(r4 = 0; r4 < 4 && MEMORY.ref(1, r10 + r4).getUnsigned() >= MEMORY.ref(1, summon + 0x4 + r4).getUnsigned(); r4++) {
          //
        }

        //LAB_80b5dd8
        if(r4 == 4) {
          r11 |= 0x1 << r8;
        }
      }

      //LAB_80b5de8
    }

    getDjinnRecoveryQueue_(0)._00.set(r11);
    CPU.sp().value += 0x20;
  }

  @Method(0x80b60a0)
  public static int FUN_80b60a0() {
    throw new RuntimeException("Not implemented");
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
  public static int loadBattle(final int entranceId) {
    CPU.sp().value -= 0x44;
    final Camera4c r10 = MEMORY.ref(4, mallocSlotBoard(12, 0x4c), Camera4c::new);
    final BattleStruct82c r8 = MEMORY.ref(4, mallocSlotBoard(9, 0x82c), BattleStruct82c::new);
    int r6 = mallocSlotBoard(54, 0x7c8);
    final int sp08 = mallocSlotBoard(44, 0x20);
    mallocSlotBoard(11, 0x280);
    MEMORY.call(0x3000164, r6, 0x7c8); // memzero
    clearTickCallbacks();
    MEMORY.ref(4, sp08).setu(0x2000);
    MEMORY.ref(4, sp08 + 0x4).setu(0);
    MEMORY.ref(4, sp08 + 0x14).setu(1);
    MEMORY.ref(4, sp08 + 0x18).setu(0);
    MEMORY.ref(4, sp08 + 0x1c).setu(0);
    GPU.DISPCNT.setu(1);
    setFlag_(0x103);
    setFlag_(0x169);
    initMatrixStack();

    int r5 = CPU.sp().value + 0x10;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r10.getAddress());
    DMA.channels[3].CNT.setu(0x85000013);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r8.getAddress());
    DMA.channels[3].CNT.setu(0x8500020b);

    r8.entranceId_00.set(entranceId);
    r8.vramSlot_54.set(-1);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(mallocSlotBoard(37, 0xc));
    DMA.channels[3].CNT.setu(0x85000003);

    r8.backgroundPointerTableId_648.set(FUN_808a4a0());
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
    r10._00.set(0, 0xb40000, 0x400000);
    r10._0c.set(0, 0x400000, 0);
    r10._20.set(0x1000000);
    r10.rotationX_34.set(0x5000);
    r10.rotationY_36.set(0x2800);
    r6 = FUN_80c1ffc(r8.entranceId_00.get());

    if(readFlag_(0x16c) != 0) {
      r8._44.set(1);
      MEMORY.ref(1, 0x200046b).setu(4);
    }

    //LAB_80b652e
    if(r8._44.get() != 0) {
      MEMORY.ref(4, 0x20023a8).setu(0);
      r5 = 0x0;

      //LAB_80b654a
      do {
        if((_3001f64.get() & 0x3) == 0x3) {
          break;
        }

        sleep(1);

        r5++;
        if(r5 > 0x18) {
          r8._52.set(1);
          break;
        }
      } while(true);

      //LAB_80b6566
      r8._50.set(MEMORY.ref(4, 0x4000128).get() << 26 >>> 30); // SIOCNT
      final int r2 = MEMORY.ref(4, 0x3001f28).get();

      //LAB_80b657e
      for(int i = 0; i < 0x7c8; i++) {
        MEMORY.ref(1, r2 + i).setu(MEMORY.ref(1, 0x2018000 + i).getUnsigned());
      }

      r6 = FUN_80770e0(0x3f0);
      FUN_80b6378();
      r8._42.set(0);
    }

    //LAB_80b65a2
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b5864"), 0xc7f);

    final int sound = _200042e.get();
    if(sound != 0) {
      playSound_(sound);

      if(readFlag_(0x16c) != 0) {
        playSound_(0x37);
        FUN_80037d4(4);
      }
    } else {
      //LAB_80b65d8
      playSound_(0x33);
      playSound_(0x4c);
    }

    //LAB_80b65e4
    loadBattleCharsAndMonsters();
    initCombatants();
    FUN_80b5c08(); // recovery queue
    FUN_80b5d3c(); // summons

    if(getDjinnRecoveryQueue_(0)._00.get() != 0) {
      r8._41.set(3);
    } else {
      //LAB_80b6658
      r8._41.set(1);
    }

    //LAB_80b6662
    FUN_8015128(9); // ui
    initCamera();
    loadAllUnitSpritesAndSetAnimations();
    FUN_80c08a8(); // allocate struct 10
    loadBattleBackground(1, r8.backgroundPointerTableId_648.get(), 0);
    FUN_80c0a24(0xa00000, 0x500000, 0, 0, 0x20000);
    FUN_80c0cec(0, 0, 0, 190); // camera
    noop_80b5b14(1);
    GPU.BLDCNT.setu(0);
    FUN_80c24b0();
    r8.vramSlot_54.set(allocateFirstFreeSpriteSlot(0x80));
    r8._45.set(0);

    if(readFlag_(0x16e) != 0) {
      r8._45.set(1);
    } else if(MEMORY.ref(1, 0x200046b).getUnsigned() == 0) {
      if((lcgRand_() & 0xf) == 0) {
        //LAB_80b6700
        r8._45.set(1);
        //LAB_80b6708
      } else if((lcgRand_() & 0x1f) == 0) {
        r8._45.set(2);
      }
    }

    //LAB_80b671a
    FUN_80c02a4(r6, entranceId);
    MEMORY.ref(4, sp08 + 0x14).setu(0);
    MEMORY.ref(1, 0x3001f58).setu(0);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b7738"), 0xc80);

    //LAB_80b6736
    int r7;
    outer:
    do {
      FUN_80b9b2c();
      FUN_80b5d3c();

      if(getDjinnRecoveryQueue_(0)._00.get() != 0) {
        r8._41.set(3);
      } else {
        //LAB_80b6752
        r8._41.set(1);
      }

      //LAB_80b6758
      MEMORY.ref(4, sp08).setu(0x2800);
      MEMORY.ref(4, sp08 + 0x4).setu(60);
      FUN_8015130(r8._41.get());
      MEMORY.call(0x3000164, r8.turns_2ec.getAddress(), 0x140); // memzero
      clearVramSlot(r8.vramSlot_54.get());

      if(readFlag_(0x16a) == 0) {
        r5 = FUN_80b9934(r8.turns_2ec);
      } else {
        //LAB_80b67ac
        r5 = FUN_80b8574(r8.turns_2ec);
      }

      //LAB_80b67b4
      r8.vramSlot_54.set(allocateFirstFreeSpriteSlot(0x80));
      FUN_8015130(r8._41.get());
      if(r5 < 0) {
        //LAB_80b696e
        FUN_80b63b0();
        disableTickCallback(null);
        GPU.DISPCNT.setu(1);
        setFlag_(0x3e8);
        r7 = r8._538.get();
        break;
      }

      //LAB_80b67cc
      //LAB_80b67d6
      for(r7 = 0; r7 < r5; r7++) {
        final int r10_0 = r8.turns_2ec.get(r7).unitId_00.get();
        final int flag = readFlag_(0x16a);
        if(flag != 0 && FUN_80b874c(r8.turns_2ec.get(r7)) == 1 || flag == 0 && FUN_80b9b30(r8.turns_2ec.get(r7), r7 != 0 ? 0 : 10) == 1) {
          //LAB_80b6a00
          playSound_(0x11);
          fadeOutBrightness(30);
          waitForFade();
          r7 = 999;
          break outer;
        }

        //LAB_80b6814
        if(getLivingUnitIds(1, 0) == 0) {
          //LAB_80b69b0
          FUN_80b63b0();
          playSound_(0x3b);
          FUN_8015118();
          FUN_8015120(charIds_2000438.get(0).get(), 1);
          if(getBattleChars(null) == 1) {
            FUN_80151c8(0x83d);
          } else {
            //LAB_80b69e0
            FUN_80151c8(0x837);
          }

          //LAB_80b69e6
          FUN_80bb65c();
          playSound_(0x11);
          fadeOutBrightness(30);
          waitForFade();
          r7 = -1;
          break outer;
        }

        //LAB_80b682a
        if(getLivingUnitIds(2, 0) == 0) {
          if(r10_0 >= 0 && r10_0 < 8) {
            if(r8._538.get() == 0x1) {
              r8._3e.set(3);
            }
          }

          //LAB_80b68ec
          FUN_80b63b0();
          if(readFlag_(0x16e) == 0) {
            if(r8._44.get() != 0) {
              playSound_(0x3a);
            }

            //LAB_80b690a
            if(r8._538.get() != 0) {
              playSound_(0x3a);
              if(r8._3e.get() < 2) {
                FUN_8077140(0x80, r8._10.get(r8._3c.get()).get(), 0x1a);
                FUN_8015118();
                FUN_8015120(0x80, 1);
                FUN_80151c8(0x838 + r8._3e.get());
                FUN_80bb65c();
              }
            }

            //LAB_80b6950
            FUN_80c2724();
          }

          //LAB_80b6954
          playSound_(0x11);
          fadeOutBrightness(30);
          waitForFade();
          r7 = r8._538.get();
          break outer;
        }

        //LAB_80b6850
        if(FUN_80b6148() < 0) {
          //LAB_80b696e
          FUN_80b63b0();
          disableTickCallback(null);
          GPU.DISPCNT.setu(1);
          setFlag_(0x3e8);
          r7 = r8._538.get();
          break outer;
        }

        //LAB_80b685a
      }

      //LAB_80b6862
      r8._45.set(0);
      FUN_80bf674();
      FUN_80bf678();
      FUN_80b7e7c();

      if(r8._44.get() == 0) {
        //LAB_80b6886
        sleep(20);
      } else if(FUN_80b6148() < 0) {
        //LAB_80b696e
        FUN_80b63b0();
        disableTickCallback(null);
        GPU.DISPCNT.setu(1);
        setFlag_(0x3e8);
        r7 = r8._538.get();
        break;
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
    MEMORY.ref(1, 0x200046b).setu(0);
    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b7738"));
    FUN_80c08e0();
    CPU.sp().value += 0x44;
    return r7;
  }

  @Method(0x80b6a60)
  public static int getBattleChars(@Nullable final int[] out) {
    final int maxCharCount;
    if(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._44.get() != 0) {
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

      if(out != null) {
        out[charSlot] = charId;
      }

      //LAB_80b6aa4
      getCharOrMonsterData_(charId)._12a.set(2);
    }

    //LAB_80b6abc
    if(out != null) {
      out[charCount] = 0xff;
    }

    //LAB_80b6ac4
    return charCount;
  }

  @Method(0x80b6ae0)
  public static int getBattleMonsters(@Nullable final int[] out) {
    if(out == null) {
      return 0;
    }

    final int maxMonsterCount;
    if(readFlag_(0x16c) != 0) {
      maxMonsterCount = 3;
    } else {
      maxMonsterCount = 6;
    }

    //LAB_80b6b02
    //LAB_80b6b0a
    int count = 0;
    for(int r5 = 0x80; r5 < maxMonsterCount + 0x80; r5++) {
      if(getCharOrMonsterData_(r5)._12a.get() != 0) {
        out[count] = r5;
        count++;
      }

      //LAB_80b6b24
    }

    //LAB_80b6b2a
    out[count] = 0xff;

    //LAB_80b6b30
    return count;
  }

  /**
   * @param flags 0x1 - get players, 0x2 - get NPCs
   * @return count
   */
  @Method(0x80b6b40)
  public static int getLivingUnitIds(final int flags, final int out) {
    final int maxMonsterCount = readFlag_(0x16c) != 0 ? 3 : 6;

    //LAB_80b6b68
    int count = 0;
    if((flags & 0x1) != 0) {
      final int[] charIds = new int[5];
      final int charCount = getBattleChars(charIds);

      //LAB_80b6b82
      for(int r5 = 0; r5 < charCount; r5++) {
        final int charId = charIds[r5];
        if(getCharOrMonsterData_(charId).hp_38.get() > 0) {
          if(out != 0) {
            MEMORY.ref(2, out + count * 0x2).setu(charId);
          }

          //LAB_80b6ba0
          count++;
        }

        //LAB_80b6ba4
      }
    }

    //LAB_80b6baa
    if((flags & 0x2) != 0) {
      //LAB_80b6bbe
      for(int r5 = 0x80; r5 < maxMonsterCount + 0x80; r5++) {
        final Unit14c unit = getCharOrMonsterData_(r5);
        if(unit._12a.get() != 0) {
          if(unit.hp_38.get() > 0) {
            if(out != 0) {
              MEMORY.ref(2, out + count * 0x2).setu(r5);
            }

            //LAB_80b6be0
            count++;
          }
        }

        //LAB_80b6be4
      }
    }

    //LAB_80b6bea
    if(out != 0) {
      MEMORY.ref(2, out + count * 0x2).setu(0xff);
    }

    //LAB_80b6bf2
    return count;
  }

  /**
   * @param flags 0x1 - get players, 0x2 - get NPCs
   * @param out 15 elements
   * @return count
   */
  @Method(0x80b6c08)
  public static int getUnitIds(final int flags, @Nullable final int[] out) {
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    int count = 0;

    if((flags & 0x1) != 0) {
      //LAB_80b6c26
      for(int i = 0; struct.charIds_58.get(i).get() != 0xff; i++) {
        if(struct.charIds_58.get(i).get() != Unit14c.REMOVED_FROM_FIELD) {
          if(out != null) {
            out[count] = struct.charIds_58.get(i).get();
          }

          //LAB_80b6c38
          count++;
        }

        //LAB_80b6c3a
      }
    }

    //LAB_80b6c44
    if((flags & 0x2) != 0) {
      //LAB_80b6c5a
      for(int i = 0; struct.monsterIds_66.get(i).get() != 0xff; i++) {
        if(struct.monsterIds_66.get(i).get() != Unit14c.REMOVED_FROM_FIELD) {
          if(out != null) {
            out[count] = struct.monsterIds_66.get(i).get();
          }

          //LAB_80b6c6a
          count++;
        }

        //LAB_80b6c6c
      }
    }

    //LAB_80b6c76
    if(out != null) {
      out[count] = 0xff;
    }

    //LAB_80b6c7e
    return count;
  }

  @Method(0x80b6c90)
  public static void loadAllUnitSpritesAndSetAnimations() {
    final int[] unitIds = new int[15];
    getUnitIds(0x3, unitIds);
    loadUnitSprites(unitIds, 1);
  }

  @Method(0x80b6cd0)
  public static int FUN_80b6cd0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b6d30)
  public static int FUN_80b6d30(final int charId) {
    final BattleStruct82c r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final Unit14c r9 = getCharOrMonsterData_(charId);
    final int r8 = FUN_80c23c0(r9.id_128.get());
    final int r7 = getActorPropertiesSprite(r9.id_128.get());
    int r10 = 0;

    //LAB_80b6d68
    for(int r4 = 0; r4 < 2; r4++) {
      if(r9.class_129.get() == 0) {
        //LAB_80b6d8a
        int r5;
        for(r5 = 0; r5 < 6 && (r6._04.get(r5).get() != 0 || r8 == 0 && (r5 > 4 || r6._04.get(r5 + 1).get() != 0)); r5++) {
          //
        }

        //LAB_80b6dac
        if(r5 == 6) {
          break;
        }

        if(FUN_8009270(r5, 0x2018000 + r5 * 0x4000, r7 + r4, FUN_80c23a0(r9.id_128.get())) == 0) {
          return 0;
        }

        //LAB_80b6dda
        if(r4 == 0) {
          r10 = r5 << 12 | r7;
        }

        //LAB_80b6de4
        r6._04.get(r5).set(charId);
        if(r8 == 0) {
          r6._04.get(r5 + 1).set(charId);
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
    return switch(r6.id_128.get()) {
      case 0 -> MEMORY.ref(2, 0x80c2a1c + r1 * 0x2).getUnsigned();
      case 1 -> MEMORY.ref(2, 0x80c2a2a + r1 * 0x2).getUnsigned();
      case 2 -> MEMORY.ref(2, 0x80c2a38 + r1 * 0x2).getUnsigned();
      case 3 -> MEMORY.ref(2, 0x80c2a46 + r1 * 0x2).getUnsigned();
      case 5 -> MEMORY.ref(2, 0x80c2a54 + r1 * 0x2).getUnsigned();
      default -> 0;
    };
  }

  @Method(0x80b6f44)
  public static void initCombatant(final BattleStruct82c.Combatant2c combatant, final int charId, final int x, final int z) {
    final Actor70 actor = loadActor_(0xf000, x << 16, 0, z << 16);
    final Unit14c unit = getCharOrMonsterData_(charId);
    final int r7 = FUN_80b6d30(charId);
    int r11 = 0;

    int spriteIndex;
    if(unit.class_129.get() == 0) {
      spriteIndex = getActorPropertiesSprite(unit.id_128.get());

      if(r7 == 0) {
        r11 = FUN_80c23a0(unit.id_128.get());
      } else {
        //LAB_80b6fb0
        spriteIndex = r7;
      }
    } else {
      //LAB_80b6fb4
      spriteIndex = switch(unit.id_128.get()) {
        case 1 -> 0x12d;
        case 3 -> 0x12f;
        case 2 -> 0x12e;
        case 5 -> 0x131;
        default -> 0x12c;
      };

      //LAB_80b6ff4
      if(charId > 7) {
        r11 = 1;
      }
    }

    //LAB_80b6ffe
    //LAB_80b7014
    switch(unit.id_128.get() - 18) {
      case 60, 113 -> combatant.scale_18.set(0x19999);
      case 71, 128 -> combatant.scale_18.set(0x18ccc);
      case 112, 29, 30, 92, 118, 119, 126 -> combatant.scale_18.set(0x13333);
      case 120, 130, 132, 133, 134, 135, 136, 137, 138, 139, 76, 123, 127 -> combatant.scale_18.set(0x18000);
      case 129, 131 -> combatant.scale_18.set(0x1cccc);
      case 103 -> combatant.scale_18.set(0x1b333);
      case 31, 110, 111 -> combatant.scale_18.set(0x16666);
      case 67, 34, 87 -> combatant.scale_18.set(0x14000);
      case 80 -> combatant.scale_18.set(0x14ccc);
      case 114, 115 -> combatant.scale_18.set(0x10ccc);
      case 116, 117 -> combatant.scale_18.set(0x11999);
      case 50, 74, 12, 52, 51, 0, 1, 2, 3, 108, 105, 106, 107, 104 -> combatant.scale_18.set(0xe666);
      default -> combatant.scale_18.set(0x10000);
    }

    //LAB_80b7350
    combatant.actor_00.set(actor);
    combatant.x_0c.set(x << 16);
    combatant.z_10.set(z << 16);
    combatant._14.set(r11);
    combatant.spriteDataIndex_04.set(spriteIndex);
    combatant.spriteDataIndex_06.set(FUN_80b6eb4(charId));
    combatant.spriteDataIndex_08.set(0);
    combatant.spriteDataIndex_0a.set(0x1fe);
    combatant.spriteLayer_20.clear();
    combatant.spriteLayer_24.clear();
    combatant._28.set(0);
    combatant._2a.set(0);

    if(unit.id_128.get() < 2) {
      if(FUN_8077078(unit, 1) == 15) {
        if(unit.id_128.get() == 0) {
          spriteIndex = 0x1e0;
        } else {
          //LAB_80b739e
          spriteIndex = 0x1e2;
        }

        //LAB_80b73a0
        combatant.spriteDataIndex_04.set(spriteIndex);
        combatant.spriteDataIndex_06.set(0);
      }
    }

    //LAB_80b73a8
    actor.angle_06.set(atan2(z / 8, x) + 0x8000);
    actor._59.set(3);
    actor._55.set(2);

    final int scale;
    if(unit.class_129.get() == 0) {
      scale = 0x14ccc;
    } else {
      //LAB_80b73dc
      scale = 0x10000;
    }

    //LAB_80b73e0
    actor.scale_18.set(scale);
    actor._1c.set(scale);
    setActorSpriteScript_(actor, 0x80c5938);
  }

  @Method(0x80b7424)
  public static void FUN_80b7424(final int[] charIds, final int r1, int r2, final int r3) {
    final int r11 = r2;
    r2 = 0x1e;
    if(r1 > 4) {
      r2 = 0x1b;
    }

    //LAB_80b7442
    int r7 = (r1 - 1) * r2 / 2;
    int r8 = 0;

    //LAB_80b745c
    for(int r10 = 0; r10 < r1; r10++) {
      MEMORY.ref(4, r11 + r8).setu(-80);
      r2 = 0x0;
      if(r10 != 0) {
        r2 = 0x19;
        if(charIds[r10] < 0xfe || charIds[r10] > 0xff) {
          final Unit14c r5 = getCharOrMonsterData_(charIds[r10]);

          if(FUN_80c23c0(r5.id_128.get()) == 0) {
            r2 = 0x26;
          } else {
            r2 = 0x1b;
          }

          //LAB_80b749c
          if(r5.id_128.get() == 0x94 || r5.id_128.get() == 0x79) {
            //LAB_80b74ac
            MEMORY.ref(4, r11 + r8).setu(-50);
          }
        }
      }

      //LAB_80b74b6
      r7 -= (r2 >>> 1);
      MEMORY.ref(4, r3 + r8).setu(r7);
      r2 = 0x19;
      if(charIds[r10] < 0xfe || charIds[r10] > 0xff) {
        r2 = 0x1b;
        if(FUN_80c23c0(getCharOrMonsterData_(charIds[r10]).id_128.get()) == 0) {
          r2 = 0x26;
        }
      }

      //LAB_80b74ec
      r7 -= (r2 >>> 1);
      r8 += 0x4;
    }

    //LAB_80b74fe
  }

  @Method(0x80b75dc)
  public static void initCombatants() {
    CPU.sp().value -= 0x50;
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int[] charIds = new int[5];
    final int charCount = getBattleChars(charIds);

    //LAB_80b760c
    for(int i = 0; i < 14; i++) {
      struct.combatantCharIds_2dc.get(i).set(0xff);
    }

    //LAB_80b761e
    for(int i = 8; i < 14; i++) {
      struct.combatantCharIds_2dc.get(i).set(i);
    }

    //LAB_80b763c
    for(int i = 0; i < charCount; i++) {
      final int charId = charIds[i];
      struct.combatantCharIds_2dc.get(charId).set(i);
      initCombatant(getCombatantForUnit(charId), charId, MEMORY.ref(1, 0x80c2a62 + i * 0x2).get(), MEMORY.ref(1, 0x80c2a62 + i * 0x2 + 0x1).get());
    }

    //LAB_80b7672
    //LAB_80b768a
    int r7;
    for(r7 = 0; r7 < 6 && struct.monsterIds_66.get(r7).get() != 0xff; r7++) {
      charIds[r7] = struct.monsterIds_66.get(r7).get();
    }

    //LAB_80b769e
    final int r9 = CPU.sp().value + 0x1c;
    final int r10 = CPU.sp().value + 0x4;
    FUN_80b7424(charIds, r7, r9, r10);

    //LAB_80b76c4
    for(int i = 0; i < r7; i++) {
      final int r5_0 = struct.monsterIds_66.get(i).get();
      if(r5_0 != 0xfe) {
        initCombatant(getCombatantForUnit(r5_0), r5_0, MEMORY.ref(4, r9 + i * 0x4).get(), MEMORY.ref(4, r10 + i * 0x4).get());
      }

      //LAB_80b76e2
    }

    //LAB_80b76ee
    CPU.sp().value += 0x50;
  }

  @Method(0x80b770c)
  public static int unitIsPresent(final int[] unitIds, int unitId) {
    if(unitId > 8) {
      unitId += 120;
    }

    //LAB_80b7714
    //LAB_80b7716
    for(int unitSlot = 0; unitSlot < 14; unitSlot++) {
      if(unitIds[unitSlot] == 0xff) {
        break;
      }

      if(unitIds[unitSlot] == unitId) {
        return 1;
      }

      //LAB_80b772c
    }

    //LAB_80b7732
    //LAB_80b7734
    return 0;
  }

  @Method(0x80b7738)
  public static void FUN_80b7738() {
    int r1;
    int r2;
    int r3;
    int r4;
    int r7;
    int r9;
    int r11;

    CPU.sp().value -= 0x2c;
    final int[] unitIds = new int[14];
    getUnitIds(0x3, unitIds);

    //LAB_80b775e
    for(r7 = 0; r7 < 14 && unitIds[r7] != 0xff; r7++) {
      final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitIds[r7]);
      if(combatant != null) {
        final Actor70 actor = combatant.actor_00.deref();
        FUN_80b7994(combatant);

        if(!combatant.spriteLayer_24.isNull()) {
          final Sprite38 sprite = getActorSprite(actor, 0);
          if(sprite != null) {
            if(actor.pos_08.getY() != 0) {
              r1 = 9;
            } else {
              r1 = 0;
            }

            //LAB_80b778e
            final SpriteLayer18 layer = combatant.spriteLayer_24.deref();
            if(layer._06.get() != r1) {
              layer._06.set(r1);
              sprite._25.set(1);
            }
          }
        }
      }

      //LAB_80b77a0
    }

    //LAB_80b77b2
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    if(camera.rotationY_36.get() >= 0) {
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(1);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(2);
    } else {
      //LAB_80b77c8
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(2);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(1);
    }

    //LAB_80b77d0
    r9 = getUnitIds(0x1, unitIds);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r3 = r1 & 0x3;
    r2 = r3 << 2;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r11 = r3;

    //LAB_80b77ee
    for(r7 = 0; r7 < r9; r7++) {
      final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitIds[r7]);
      if(combatant != null) {
        final Actor70 actor = combatant.actor_00.deref();
        final int spriteType = actor.spriteType_54.get() & 0xf;
        if(spriteType == 1) {
          //LAB_80b7814
          final Sprite38 sprite = actor.sprite_50.deref();
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(MEMORY.ref(4, CPU.sp().value + 0x4).get() << 8);
        } else if(spriteType == 2) {
          //LAB_80b7826
          final int sprites = actor.sprite_50.getPointer();

          //LAB_80b7832
          for(r4 = 0; r4 < 4; r4++) {
            final int sprite = MEMORY.ref(4, sprites + r4 * 0x4).get();
            if(sprite != 0) {
              MEMORY.ref(1, sprite + 0x9).and(~0xc).or(r11 << 2);
            }

            //LAB_80b7842
          }
        }
      }

      //LAB_80b7848
    }

    //LAB_80b784e
    r9 = getUnitIds(2, unitIds);
    r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r3 = r1 & 0x3;
    r2 = r3 << 2;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r11 = r3;

    //LAB_80b786c
    for(r7 = 0; r7 < r9; r7++) {
      final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitIds[r7]);
      if(combatant != null) {
        final Actor70 actor = combatant.actor_00.deref();
        final int spriteType = actor.spriteType_54.get() & 0xf;
        if(spriteType == 1) {
          //LAB_80b7892
          final Sprite38 sprite = actor.sprite_50.deref();
          sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or(MEMORY.ref(4, CPU.sp().value).get() << 8);
        } else if(spriteType == 2) {
          //LAB_80b78a4
          final int sprites = actor.sprite_50.getPointer();

          //LAB_80b78b0
          for(r4 = 0; r4 < 4; r4++) {
            final int sprite = MEMORY.ref(4, sprites + r4 * 0x4).get();
            if(sprite != 0) {
              MEMORY.ref(1, sprite + 0x9).and(~0xc).or(r11 << 2);
            }

            //LAB_80b78c0
          }
        }
      }

      //LAB_80b78c6
    }

    //LAB_80b78cc
    CPU.sp().value += 0x2c;
  }

  @Method(0x80b78e4)
  public static void FUN_80b78e4(final int unitId, final BattleStruct82c.Combatant2c r1) {
    final Unit14c r2 = getCharOrMonsterData_(unitId);
    int r3 = r2.affliction_131.get();
    int flags = 0;
    if(r3 == 0x1) {
      flags = 0x1;
    }

    //LAB_80b7900
    if(r3 == 0x2) {
      flags = flags | 0x2;
    }

    //LAB_80b7906
    if(r2._138.get() != 0) {
      flags = flags | 0x20;
    }

    //LAB_80b7916
    if(r2._13b.get() != 0) {
      flags = flags | 0x4;

      if(r2.id_128.get() == 0x79 || r2.id_128.get() == 0x94) {
        //LAB_80b7932
        flags = flags & ~0x4;
      }
    }

    //LAB_80b7938
    if(r2._13d.get() != 0) {
      flags = flags | 0x8;
    }

    //LAB_80b7946
    if(r2.haunt_140.get() != 0) {
      flags = flags | 0x40;
    }

    //LAB_80b7956
    if(r2._13c.get() != 0) {
      flags = flags | 0x10;
    }

    //LAB_80b7966
    r3 = r2._141.get();
    if(r3 != 0) {
      flags = flags | 0x1 << r3 + 6;
    }

    //LAB_80b797a
    r1.flags_1c.set(flags);
  }

  @Method(0x80b7994)
  public static void FUN_80b7994(final BattleStruct82c.Combatant2c r0) {
    int r8 = 0;
    if(r0._1f.get() >= 0) {
      r0._1f.decr();
    }

    //LAB_80b79ae
    final SpriteLayer18 r4 = r0.spriteLayer_20.derefNullable();
    if(r4 == null && r0.flags_1c.get() != 0 || r4 != null && (r0.flags_1c.get() >> r0._1e.get() & 0x1) == 0 || r0._1f.get() == 0) {
      //LAB_80b79da
      final int r3 = r0.flags_1c.get();
      int r6 = -1;
      final Actor70 actor = r0.actor_00.deref();
      if(r3 != 0) {
        final int r2 = r0._1e.get();
        r6 = r2 + 0x1;

        //LAB_80b79f4
        do {
          if(r6 > 0xd) {
            r6 = 0x0;
          }

          //LAB_80b79fa
          if((r3 >> r6 & 0x1) != 0) {
            break;
          }

          //LAB_80b79f2
          r6 = r6 + 0x1;
        } while(true);

        if(r2 != r6 || r4 == null) {
          //LAB_80b7a0c
          r0._1e.set(r6);
          r8 = 1;
        }

        //LAB_80b7a12
        r0._1f.set(0x50);
      } else {
        //LAB_80b7a18
        r8 = 1;
      }

      //LAB_80b7a1c
      final Sprite38 r7 = getActorSprite(actor, 0);
      if(r7 != null) {
        if(r6 >= 0) {
          if(r7.width_20.get() == 32) {
            r6 = r6 + 0x154;
          } else {
            //LAB_80b7a3e
            r6 = r6 + 0x163;
          }
        }

        //LAB_80b7a42
        final SpriteLayer18 r1 = r0.spriteLayer_20.derefNullable();
        if(r1 != null && r8 != 0) {
          FUN_8009050(r7, r1);
          r0.spriteLayer_20.clear();
        }

        //LAB_80b7a58
        if(r6 >= 0 && r8 != 0) {
          final SpriteLayer18 layer = addLayerToSprite_(r7, r6);
          r0.spriteLayer_20.setNullable(layer);
          if(layer != null) {
            layer._06.set(3);
            FUN_8009070(layer, 0);
          }
        }

        //LAB_80b7a88
        r7._25.set(1);
        r0.spriteDataIndex_08.set(Math.max(r6, 0));
      }
    }

    //LAB_80b7a9c
  }

  @Method(0x80b7aac)
  public static void FUN_80b7aac(final int unitId) {
    final Unit14c unit = getCharOrMonsterData_(unitId);
    int r5 = 0x1;
    if(unit.hp_38.get() == 0) {
      //LAB_80b7af6
      final int r3 = unit._12a.get() ^ 0x1;
      r5 = (-r3 | r3) >>> 31;
      r5 = 0x5 - r5;
    } else if(unit._13c.get() != 0 || unit._13b.get() != 0 || unit._145.get() != 0) {
      //LAB_80b7ae0
      final int r3 = unit._12a.get() ^ 0x1;
      r5 = (-r3 | r3) >>> 31;
      r5 = r5 << 2;
    }

    //LAB_80b7b0a
    final Actor70 actor = getCombatantForUnit(unitId).actor_00.deref();
    setActorAnimation_(actor, r5);
    FUN_8009088(actor, (unitId & 0x3) + 0xe);
  }

  @Method(0x80b7b30)
  public static void clearUnitSprite(final int unitId) {
    final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitId);
    if(combatant == null) {
      return;
    }

    final Actor70 actor = combatant.actor_00.derefNullable();
    if(actor == null) {
      return;
    }

    int spriteIndex = 0;
    combatant.spriteLayer_20.clear();
    combatant.spriteLayer_24.clear();

    //LAB_80b7b50
    do {
      final Sprite38 sprite = getActorSprite(actor, spriteIndex);
      if(sprite == null) {
        break;
      }

      //LAB_80b7b4a
      clearSprite_(sprite);
      spriteIndex++;
    } while(true);

    actor.sprite_50.clear();
    actor.spriteType_54.set(0);
  }

  @Method(0x80b7b6c)
  public static void loadUnitSprites(final int[] unitIds, final int setAnimations) {
    //LAB_80b7b84
    for(int unitId = 0; unitId < 14; unitId++) {
      if(unitIsPresent(unitIds, unitId) == 0) {
        //LAB_80b7b9c
        clearUnitSprite(unitId < 8 ? unitId : unitId + 120);
      }

      //LAB_80b7ba0
    }

    if(_3001a10.get() == 0) {
      sleep(1);
    }

    //LAB_80b7bb8
    int unitId;

    //LAB_80b7bca
    //LAB_80b7bce
    int r5;
    for(int unitSlot = 0; unitSlot < 14 && (unitId = unitIds[unitSlot]) != 0xff; unitSlot++) {
      if(unitId != Unit14c.REMOVED_FROM_FIELD) {
        //LAB_80b7bd6
        final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitId);
        if(combatant != null) {
          //LAB_80b7be4
          FUN_80b78e4(unitId, combatant);

          final Actor70 actor = combatant.actor_00.derefNullable();
          if(actor != null) {
            //LAB_80b7bf6
            if(actor.spriteType_54.get() == 0) {
              //LAB_80b7c04
              final int spriteDataIndex = combatant.spriteDataIndex_04.get() & 0xfff;
              if(spriteDataIndex == 0x1dc || spriteDataIndex == 0x1e3) {
                //LAB_80b7c18
                final int r2 = boardWramMallocHead_3001e50.offset(6 * 0x4).get();
                final int r9 = r2 + MEMORY.ref(4, r2 + 0x18).get() * 0x4;
                actor.spriteType_54.set(2);
                r5 = combatant.spriteDataIndex_04.get();
                actor.sprite_50.setPointer(r9 + 0x8);
                MEMORY.call(0x3000164, r9 + 0x8, 0x10); // memzero
                Sprite38 r6 = loadSprite_(r5);
                if(r6 != null) {
                  r6.scale_18.set((int)MEMORY.call(0x3000118, r6.scale_18.get(), combatant.scale_18.get()));
                  final int spriteData = getSpriteData(r5);
                  actor.radius_20.set(MEMORY.ref(1, spriteData + 0x9).getUnsigned() >>> 1);
                  MEMORY.ref(4, r9 + 0x8).setu(r6.getAddress());
                  r6._26.set(0);
                }

                //LAB_80b7c82
                r6 = loadSprite_(0x2001 + r5);
                if(r6 != null) {
                  r6.scale_18.set((int)MEMORY.call(0x3000118, r6.scale_18.get(), combatant.scale_18.get()));
                  MEMORY.ref(4, r9 + 0x8).setu(r6.getAddress());
                  r6._26.set(0);
                }

                //LAB_80b7caa
              } else {
                //LAB_80b7cb4
                final Sprite38 sprite = loadSprite_(combatant.spriteDataIndex_04.get());
                if(sprite != null) {
                  actor.spriteType_54.set(1);
                  actor.sprite_50.set(sprite);
                  sprite.scale_18.set((int)MEMORY.call(0x3000118, sprite.scale_18.get(), combatant.scale_18.get()));
                  final SpriteLayer18 layer = sprite.layers_28.get(0).deref();
                  layer._06.set(1);
                  layer._05.set(combatant._14.get());
                  r5 = combatant.spriteDataIndex_06.get();
                  if(r5 != 0) {
                    final SpriteLayer18 r5_0 = addLayerToSprite_(sprite, r5);
                    r5_0._06.set(1);
                  }

                  //LAB_80b7cf8
                  r5 = combatant.spriteDataIndex_08.get();
                  if(r5 != 0) {
                    final SpriteLayer18 r5_0 = addLayerToSprite_(sprite, r5);
                    combatant.spriteLayer_20.set(r5_0);
                    FUN_8009070(r5_0, 0);
                    r5_0._06.set(3);
                  }

                  //LAB_80b7d14
                  r5 = combatant.spriteDataIndex_0a.get();
                  if(r5 != 0) {
                    if(sprite.width_20.get() == 32) {
                      r5 = 0x1ff;
                    }

                    //LAB_80b7d26
                    final SpriteLayer18 r5_0 = addLayerToSprite_(sprite, r5);
                    combatant.spriteLayer_24.set(r5_0);
                    r5_0._06.set(0);
                    sprite._26.set(0);
                  }
                }
              }

              //LAB_80b7d40
              FUN_80b7aac(unitId);
            }
          }
        }
      }

      //LAB_80b7d46
    }

    //LAB_80b7d62
    if(setAnimations != 0) {
      //LAB_80b7d76
      for(int r11 = 0; r11 < 14 && (r5 = unitIds[r11]) != 0xff; r11++) {
        if(r5 != Unit14c.REMOVED_FROM_FIELD) {
          final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(r5);

          if(combatant != null && !combatant.actor_00.isNull()) {
            FUN_80b7aac(r5);
          }
        }

        //LAB_80b7d9a
      }
    }

    //LAB_80b7dae
  }

  @Method(0x80b7dd0)
  public static BattleStruct82c.Combatant2c getCombatantForUnit(int unitId) {
    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    if(unitId > 7) {
      unitId -= 120;
    }

    //LAB_80b7de0
    if(r2.combatantCharIds_2dc.get(unitId).get() == 0xff) {
      return null;
    }

    //LAB_80b7df0
    return r2.combatants_74.get(r2.combatantCharIds_2dc.get(unitId).get());
  }

  @Method(0x80b7e7c)
  public static void FUN_80b7e7c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b7f70)
  public static Sprite38 getActorSprite(final Actor70 actor, final int spriteIndex) {
    if((actor.spriteType_54.get() & 0xf) == 1) {
      if(spriteIndex != 0) {
        return null;
      }

      return actor.sprite_50.deref();
    }

    //LAB_80b7f88
    if((actor.spriteType_54.get() & 0xf) != 2) {
      //LAB_80b7f94
      return null;
    }

    final int r3 = actor.sprite_50.getPointer(); //TODO
    return MEMORY.ref(4, r3 + spriteIndex * 0x4).deref(4).cast(Sprite38::new);
  }

  @Method(0x80b7f9c)
  public static void initCamera() {
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    camera.rotationX_34.set(0xfe00);
    camera.rotationY_36.set(0x3000);
    camera._0c.zero();
    camera._18.clear();
    camera._1c.clear();
    camera._20.set(0x1fe0000);
    initMatrixStack();
    translateMatrix(camera._0c);
    rotateMatrixY(camera.rotationY_36.get());
    rotateMatrixX(camera.rotationX_34.get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, camera._20.get()), camera._00);
  }

  /** {@link GoldenSun_80b#FUN_80b84c0} */
  @Method(0x80b50b8)
  public static void FUN_80b50b8(final int charId, final Vec3 r1) {
    MEMORY.call(0x80b84c0, charId, r1);
  }

  @Method(0x80b7ed8)
  public static void FUN_80b7ed8() {
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);

    initMatrixStack();

    if(readFlag_(0x16b) != 0) {
      MEMORY.call(0x30002c0, _80c2a7c);
      FUN_80051e8(camera._00, camera._0c);
    } else {
      //LAB_80b7f00
      FUN_80051d8(camera._00, camera._0c);
    }
  }

  @Method(0x80b84c0)
  public static int FUN_80b84c0(final int charId, final Vec3 r1) {
    final Actor70 actor = getCombatantForUnit(charId).actor_00.deref();
    final Sprite38 sprite = getActorSprite(actor, 0);

    FUN_80b7ed8();

    final int r6 = (int)MEMORY.call(0x3000118, FUN_8005268(actor.pos_08, r1), sprite.scale_18.get());

    final int r1_0;
    if(FUN_80c23c0(getCharOrMonsterData_(charId).id_128.get()) != 0) {
      r1_0 = 0x18;
    } else {
      //LAB_80b850e
      r1_0 = 0x30;
    }

    //LAB_80b8512
    r1.y_04.add((int)MEMORY.call(0x3000118, r6, r1_0));
    return 0;
  }

  @Method(0x80b8574)
  public static int FUN_80b8574(final ArrayRef<BattleStruct82c.Turn10> turns) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b874c)
  public static int FUN_80b874c(final BattleStruct82c.Turn10 turn) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b8fd4)
  public static void FUN_80b8fd4(final int r0) {
    CPU.push(CPU.r8().value);
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    CPU.r8().value = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    MEMORY.ref(4, CPU.r8().value).setu(0x4000);
    camera._0c.set(0, 0x50000, 0);
    camera.rotationX_34.set(0xf400);
    camera.rotationY_36.set(0x4000);
    camera._18.clear();
    camera._1c.clear();
    camera._20.set(0x2ee0000);
    CPU.sp().value -= 0x10;
    initMatrixStack();
    translateMatrix(camera._0c);
    rotateMatrixY(camera.rotationY_36.get());
    rotateMatrixX(camera.rotationX_34.get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, camera._20.get()), camera._00);
    FUN_8005258(0, (int)MEMORY.call(0x300013c, 0x3c90000, 0xc000), 0x7920000);
    MEMORY.ref(4, 0x3001ce0 + 0x10).setu(r0 + 120);
    MEMORY.ref(4, CPU.r8().value + 0x10).setu(1);
    MEMORY.ref(4, CPU.sp().value).setu(0x20000);
    FUN_80c0a24(0x780000, 0x76 - r0 << 16, 0, 0x800, MEMORY.ref(4, CPU.sp().value).get());
    MEMORY.ref(4, CPU.r8().value + 0x14).setu(1);
    MEMORY.ref(4, CPU.r8().value + 0x10).setu(0);
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80b90ac)
  public static void recalcAllUnitStats() {
    final int[] unitIds = new int[15];
    final int unitCount = getUnitIds(0x3, unitIds);

    //LAB_80b90ca
    for(int i = 0; i < unitCount; i++) {
      getCharOrMonsterData_(unitIds[i])._12b.set(0);
      recalcStats_(unitIds[i]);
    }

    //LAB_80b90e6
  }

  @Method(0x80b90f8)
  public static int FUN_80b90f8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b920c)
  public static int FUN_80b920c(final ArrayRef<BattleStruct82c.Turn10> turns) {
    final int sp08 = mallocBoard(17);
    final int charIds = mallocBoard(9);
    final int charCount = getLivingUnitIds(0x1, charIds);
    int turnCount = 0;
    int r9 = 0;

    //LAB_80b9246
    for(int i = 0; i < charCount; i++) {
      final Unit14c unit = getCharOrMonsterData_(MEMORY.ref(2, charIds + i * 0x2).getUnsigned());

      //LAB_80b9282
      for(int r5 = 0; r5 < unit.turns_43.get(); r5++) {
        if(unit._13c.get() != 0 || (unit._138.get() & ~0xff) != 0) {
          final BattleStruct82c.Turn10 turn = turns.get(turnCount);

          //LAB_80b9296
          turn.unitId_00.set(MEMORY.ref(2, charIds + i * 0x2).getUnsigned());
          turn.agility_04.set(unit.agility_40.get());
          turn._06.set(8);
          turn._08.set(0);
          turn._0a.set(0x180);
          turnCount++;
        } else {
          //LAB_80b92c0
          MEMORY.ref(2, sp08 + r9 * 0x2).setu(MEMORY.ref(2, charIds + i * 0x2).getUnsigned());
          r9++;
        }

        //LAB_80b92ca
      }

      //LAB_80b92d4
    }

    //LAB_80b92e2
    final int r0_0 = FUN_80151c0(turns.get(turnCount), sp08, r9);

    final int r5;
    if(r0_0 >= 0) {
      r5 = turnCount + r0_0;
    } else {
      r5 = -1;
    }

    //LAB_80b9302
    setMallocAddress(charIds);
    setMallocAddress(sp08);
    return r5;
  }

  @Method(0x80b9324)
  public static int FUN_80b9324(final BattleStruct82c.Turn10 r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b9470)
  public static void FUN_80b9470(final ArrayRef<BattleStruct82c.Turn10> r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b9724)
  public static int FUN_80b9724(final ArrayRef<BattleStruct82c.Turn10> r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b98b4)
  public static void FUN_80b98b4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;
    final int r7;

    r1 = 0x0;
    r5 = r0;
    r3 = 0xf;
    CPU.lr().value = r1;
    r7 = 0x1f;

    //LAB_80b98c0
    do {
      r3 = r3 << 4;
      r6 = 0x0;
      CPU.r12().value = r3;

      //LAB_80b98c6
      do {
        r2 = CPU.r12().value;
        r3 = r2 + r6;
        r1 = 0xa0;
        r1 = r1 << 19;
        r0 = r3 << 1;
        r3 = r0 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r3 >>> 10;
        r4 = r4 & r7;
        r2 = r3 >>> 5;
        r1 = r7;
        r2 = r2 & r7;
        r1 = r1 & r3;
        r4 = r4 + r5;
        r2 = r2 + r5;
        r1 = r1 + r5;
        if(r4 > 0x1f) {
          r4 = 0x1f;
        }

        //LAB_80b98ec
        if(r2 > 0x1f) {
          r2 = 0x1f;
        }

        //LAB_80b98f2
        if(r1 > 0x1f) {
          r1 = 0x1f;
        }

        //LAB_80b98f8
        if(r4 < 0) {
          r4 = 0x0;
        }

        //LAB_80b98fe
        if(r2 < 0) {
          r2 = 0x0;
        }

        //LAB_80b9904
        if(r1 < 0) {
          r1 = 0x0;
        }

        //LAB_80b990a
        r2 = r2 << 5;
        r3 = r4 << 10;
        r3 = r3 | r2;
        r3 = r3 | r1;
        r1 = 0x4ffffe0;
        r6 = r6 + 0x1;
        r2 = r0 + r1;
        MEMORY.ref(2, r2).setu(r3);
      } while(r6 <= 0xf);

      r2 = 0x1;
      CPU.lr().value = CPU.lr().value + r2;
      r1 = CPU.lr().value;
      r3 = 0x5;
    } while(r1 <= 0x1);
  }

  @Method(0x80b9934)
  public static int FUN_80b9934(final ArrayRef<BattleStruct82c.Turn10> turns) {
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    //LAB_80b994a
    for(int i = 0; i < 20; i++) {
      struct.turns_2ec.get(i).unitId_00.set(0xff);
      struct.turns_2ec.get(i).agility_04.set(0x8000);
    }

    recalcAllUnitStats();
    FUN_80b98b4(8);
    setFlag_(0x16b);
    FUN_80b8fd4(0);
    FUN_8015218();

    int r6;
    if(struct._45.get() != 0x2) {
      r6 = FUN_80b920c(turns);
      if(r6 < 0) {
        clearFlag_(0x16b);
        initCamera();
        boardWramMallocHead_3001e50.offset(44 * 0x4).deref(4).setu(0x2000);
        return r6;
      }

      if(r6 != 0 && turns.get(0)._06.get() == 0x63 && FUN_80b90f8() == 0) {
        struct._45.set(2);
      }
    } else {
      //LAB_80b999e
      r6 = 0;
    }

    //LAB_80b99a0
    if(struct._44.get() == 0) {
      //LAB_80b99ca
      r6 = r6 + FUN_80b9324(turns.get(r6));
    } else {
      final int r5 = FUN_80b9724(turns, r6);
      if(FUN_80b60a0() < 0 || r5 < 0) {
        //LAB_80b99c4
        clearFlag_(0x16b);
        initCamera();
        boardWramMallocHead_3001e50.offset(44 * 0x4).deref(4).setu(0x2000);
        return -1;
      }
      r6 = r6 + r5;
    }

    //LAB_80b99d4
    FUN_80b9470(turns, r6);

    //LAB_80b99e4
    for(int i = 0; i < r6; i++) {
      final BattleStruct82c.Turn10 turn = turns.get(i);
      final int r3 = turn._06.get();
      if(r3 == 0x3 || r3 == 0x7) {
        //LAB_80b99f0
        final int r2 = turn._06.get() ^ 0x3;
        getCharOrMonsterData_(turn.unitId_00.get())._12b.set(((-r2 | r2) >>> 31) + 1);
      }

      //LAB_80b9a0e
    }

    //LAB_80b9a16
    clearFlag_(0x16b);
    initCamera();
    boardWramMallocHead_3001e50.offset(44 * 0x4).deref(4).setu(0x2000);
    return r6;
  }

  @Method(0x80b9b2c)
  public static void FUN_80b9b2c() {
    // no-op
  }

  @Method(0x80b9b30)
  public static int FUN_80b9b30(final BattleStruct82c.Turn10 r0, final int r1) {
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
    r0 = allocateFirstFreeSpriteSlot(r0);
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
    final int[] unitIds = new int[8];
    final int unitCount = getUnitIds(r0 > 7 ? 0x2 : 0x1, unitIds);

    //LAB_80be0e8
    final RecoveryQueue10c r8 = getDjinnRecoveryQueue_(r0 > 7 ? 1 : 0);
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
        for(r4 = 0; r4 < unitCount && unitIds[r4] != r8._08.get(r10).charId_02.get(); r4++) {
          //
        }

        //LAB_80be14c
        if(r4 != unitCount) {
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
