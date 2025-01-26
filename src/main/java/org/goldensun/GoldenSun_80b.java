package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.Camera4c;
import org.goldensun.battle.EnemyStats54;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Ability10;
import org.goldensun.types.Actor70;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Item2c;
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

import static org.goldensun.CopiedSegment8000770.mulTransforms;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.CopiedSegment8000770.transformVector;
import static org.goldensun.GoldenSun.FUN_80037d4;
import static org.goldensun.GoldenSun.FUN_8009248;
import static org.goldensun.GoldenSun.FUN_8009280;
import static org.goldensun.GoldenSun.queueVblankOr16;
import static org.goldensun.GoldenSun.queueVblankNand16_80000;
import static org.goldensun.GoldenSun.FUN_80040d0;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.FUN_80051e8;
import static org.goldensun.GoldenSun.FUN_8005258;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_8009050;
import static org.goldensun.GoldenSun.FUN_8009070;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.FUN_80090f8;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.moveActorTo_;
import static org.goldensun.GoldenSun.FUN_8009260;
import static org.goldensun.GoldenSun.FUN_8009270;
import static org.goldensun.GoldenSun.addLayerToSprite_;
import static org.goldensun.GoldenSun.allocateFirstFreeSpriteSlot;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.clearActor_;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearTickCallbacks;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.disableTickCallback;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.initActors_;
import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadActor_;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.rotVec3;
import static org.goldensun.GoldenSun.rotateMatrixX;
import static org.goldensun.GoldenSun.rotateMatrixY;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setActorSpriteScript_;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.translateMatrix;
import static org.goldensun.GoldenSun.waitForFade;
import static org.goldensun.GoldenSunVars._200042e;
import static org.goldensun.GoldenSunVars._3001a10;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars._80c2a7c;
import static org.goldensun.GoldenSunVars.evenMoveSelection_80c2b80;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.rareMoveSelection_80c2b88;
import static org.goldensun.GoldenSunVars.veryRareMoveSelection_80c2b90;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSun_801.FUN_8015008;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_8015060;
import static org.goldensun.GoldenSun_801.FUN_8015078;
import static org.goldensun.GoldenSun_801.FUN_80150b0;
import static org.goldensun.GoldenSun_801.FUN_80150c8;
import static org.goldensun.GoldenSun_801.FUN_80150d8;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015118;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015128;
import static org.goldensun.GoldenSun_801.FUN_8015130;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80151c0;
import static org.goldensun.GoldenSun_801.FUN_80151c8;
import static org.goldensun.GoldenSun_801.FUN_80151d0;
import static org.goldensun.GoldenSun_801.FUN_8015218;
import static org.goldensun.GoldenSun_801.FUN_80152b8;
import static org.goldensun.GoldenSun_801.FUN_80152d0;
import static org.goldensun.GoldenSun_801.FUN_8015388;
import static org.goldensun.GoldenSun_801.FUN_80153b0;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawIcon_;
import static org.goldensun.GoldenSun_801.drawPanelBackground_;
import static org.goldensun.GoldenSun_807.FUN_8077220;
import static org.goldensun.GoldenSun_807.FUN_80772a8;
import static org.goldensun.GoldenSun_807.getUnitEquippedItemIdOfType_;
import static org.goldensun.GoldenSun_807.readFlagsByte_;
import static org.goldensun.GoldenSun_807.calcHpPpFractions_;
import static org.goldensun.GoldenSun_807.getUnitItemCount_;
import static org.goldensun.GoldenSun_807.loadEnemyUnit_;
import static org.goldensun.GoldenSun_807.FUN_8077160;
import static org.goldensun.GoldenSun_807.getUnitElement_;
import static org.goldensun.GoldenSun_807.FUN_8077178;
import static org.goldensun.GoldenSun_807.FUN_8077180;
import static org.goldensun.GoldenSun_807.FUN_8077188;
import static org.goldensun.GoldenSun_807.FUN_8077190;
import static org.goldensun.GoldenSun_807.getEnemyStats_;
import static org.goldensun.GoldenSun_807.FUN_80771b8;
import static org.goldensun.GoldenSun_807.FUN_80771c8;
import static org.goldensun.GoldenSun_807.getDjinnAbility_;
import static org.goldensun.GoldenSun_807.FUN_8077208;
import static org.goldensun.GoldenSun_807.FUN_8077210;
import static org.goldensun.GoldenSun_807.getEquippedItemSlotOfType_;
import static org.goldensun.GoldenSun_807.addCoins_;
import static org.goldensun.GoldenSun_807.doesAbilityRevive_;
import static org.goldensun.GoldenSun_807.FUN_80772f8;
import static org.goldensun.GoldenSun_807.calcHpPpFractions;
import static org.goldensun.GoldenSun_807.addHp_;
import static org.goldensun.GoldenSun_807.addPp_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.getSummon_;
import static org.goldensun.GoldenSun_807.lcgRand_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.recoverDjinn_;
import static org.goldensun.GoldenSun_807.setDjinn_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a330;
import static org.goldensun.GoldenSun_808.FUN_808a348;
import static org.goldensun.GoldenSun_808.FUN_808a360;
import static org.goldensun.GoldenSun_808.FUN_808a368;
import static org.goldensun.GoldenSun_808.FUN_808a370;
import static org.goldensun.GoldenSun_808.FUN_808a4a0;
import static org.goldensun.GoldenSun_808.FUN_808a500;
import static org.goldensun.GoldenSun_808.FUN_808a508;
import static org.goldensun.GoldenSun_808.FUN_808a510;
import static org.goldensun.GoldenSun_808.FUN_808a520;
import static org.goldensun.GoldenSun_808.FUN_808a528;
import static org.goldensun.GoldenSun_808.FUN_808a540;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_809.FUN_80915ac;
import static org.goldensun.GoldenSun_809.clearFieldPsynergyInstance;
import static org.goldensun.GoldenSun_809.getMapActor_;
import static org.goldensun.GoldenSun_809.setFieldPsynergyInstanceSpriteIndex;
import static org.goldensun.GoldenSun_80a.FUN_80a1028;
import static org.goldensun.GoldenSun_80a.FUN_80a1030;
import static org.goldensun.GoldenSun_80a.FUN_80a1038;
import static org.goldensun.GoldenSun_80c.FUN_80c02a4;
import static org.goldensun.GoldenSun_80c.FUN_80c0774;
import static org.goldensun.GoldenSun_80c.FUN_80c08a8;
import static org.goldensun.GoldenSun_80c.FUN_80c08e0;
import static org.goldensun.GoldenSun_80c.FUN_80c0a24;
import static org.goldensun.GoldenSun_80c.FUN_80c0cec;
import static org.goldensun.GoldenSun_80c.FUN_80c0df4;
import static org.goldensun.GoldenSun_80c.FUN_80c10e8;
import static org.goldensun.GoldenSun_80c.FUN_80c1798;
import static org.goldensun.GoldenSun_80c.FUN_80c1a14;
import static org.goldensun.GoldenSun_80c.FUN_80c1df4;
import static org.goldensun.GoldenSun_80c.FUN_80c1ebc;
import static org.goldensun.GoldenSun_80c.FUN_80c1f50;
import static org.goldensun.GoldenSun_80c.FUN_80c1fa8;
import static org.goldensun.GoldenSun_80c.FUN_80c1ffc;
import static org.goldensun.GoldenSun_80c.FUN_80c2368;
import static org.goldensun.GoldenSun_80c.FUN_80c23a0;
import static org.goldensun.GoldenSun_80c.FUN_80c23c0;
import static org.goldensun.GoldenSun_80c.FUN_80c23e8;
import static org.goldensun.GoldenSun_80c.FUN_80c2410;
import static org.goldensun.GoldenSun_80c.FUN_80c2454;
import static org.goldensun.GoldenSun_80c.FUN_80c24b0;
import static org.goldensun.GoldenSun_80c.FUN_80c24f0;
import static org.goldensun.GoldenSun_80c.FUN_80c2724;
import static org.goldensun.GoldenSun_80c.FUN_80c9008;
import static org.goldensun.GoldenSun_80c.FUN_80c9018;
import static org.goldensun.GoldenSun_80c.getActorPropertiesSprite;
import static org.goldensun.GoldenSun_80c.loadBattleBackground;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.GoldenSun_818.getSpriteData;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  /** {@link GoldenSun_80b#FUN_80b0278} */
  @Method(0x80b0008)
  public static int FUN_80b0008(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b0278, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b29a8} */
  @Method(0x80b0010)
  public static int FUN_80b0010(final int mapActorIndex) {
    return (int)MEMORY.call(0x80b29a8, mapActorIndex);
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

  /** {@link GoldenSun_80b#FUN_80b3444} */
  @Method(0x80b0058)
  public static int FUN_80b0058(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b3444, r0, r1);
  }

  @Method(0x80b00f4)
  public static void FUN_80b00f4() {
    FUN_80b08b8(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._380.getAddress());
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
    final int r7 = FUN_80915ac(r6.spriteDataIndex_3a4.get());
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

  @Method(0x80b0664)
  public static int FUN_80b0664(final int r0) {
    final GraphicsStruct1c r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._380.deref();
    final int r6 = r5._05.get();
    FUN_80a1038(r5);
    final int ret = FUN_80153b0(7, 7, r0);
    r5._05.set(r6);
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

  @Method(0x80b0840)
  public static void FUN_80b0840(final int r0) {
    final int r5 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    final int r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    DMA.channels[3].SAD.setu(r5 + 0xe00);
    DMA.channels[3].DAD.setu(r1 + 0x236);
    DMA.channels[3].CNT.setu(0x84000150);
    DMA.channels[3].SAD.setu(r5 + 0xe00);
    DMA.channels[3].DAD.setu(r5 + 0x380);
    DMA.channels[3].CNT.setu(0x840002a0);
    FUN_808a330(r0, 1);
    FUN_808a348(16);
  }

  @Method(0x80b0894)
  public static void FUN_80b0894() {
    FUN_808a330(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._236.getAddress(), 1);
    FUN_808a348(16);
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
  public static void FUN_80b09fc(final int r0, final int x, final int y, final int r3) {
    final int r5 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r0 + 0x4).setu(MEMORY.ref(2, r5 + 0x6).getUnsigned());
    MEMORY.ref(2, r0 + 0x6).setu(MEMORY.ref(2, r5 + 0x8).getUnsigned());
    MEMORY.ref(2, r0 + 0x8).setu(x);
    MEMORY.ref(2, r0 + 0xa).setu(y);
    MEMORY.ref(1, r0 + 0xd).setu(r3);
    MEMORY.ref(1, r0 + 0xc).setu(0);
  }

  @Method(0x80b0a20)
  public static void FUN_80b0a20(final int r0, final int r1, final int r2) {
    final int r5 = MEMORY.ref(4, r0).get();

    //BUGFIX: NPE
    if(r5 != 0) {
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
  }

  @Method(0x80b0a6c)
  public static void FUN_80b0a6c(@Nullable final Panel24 r0, int x, int y) {
    final Menua70 r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    if(r0 != null) {
      x += r0.x_0c.get() * 8 + 8;
      y += r0.y_0e.get() * 8 + 8;
    }

    //LAB_80b0a8c
    FUN_80b09fc(r3._380.getAddress(), x, y, r3._3a8.get());
  }

  @Method(0x80b10cc)
  public static void FUN_80b10cc() {
    final Menua70 r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Panel24 r5 = r3.panel_0c.derefNullable();

    if(r5 != null) {
      drawIcon_(0xc8a, r5, 0, 0);
      FUN_80150b0(MEMORY.ref(4, 0x2000250).get(), 6, r5, 32, 8);
    }

    //LAB_80b10f8
  }

  @Method(0x80b11a4)
  public static void drawPanelWithIcon(final Panel24 panel, final int iconId) {
    if(panel != null) {
      drawPanelBackground_(panel);
      drawIcon_(iconId, panel, 0, 0);
    }
  }

  @Method(0x80b11c4)
  public static void FUN_80b11c4(final Panel24 r0, final int r1, final int r2) {
    if(r0 != null) {
      final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

      //LAB_80b11fe
      for(int r6 = 0; r6 < r7._3a7.get(); r6++) {
        if(r6 == r1) {
          setSpriteAnimation_(r7.charSprites_114.get(r6).deref(), 30);
        } else {
          //LAB_80b120c
          setSpriteAnimation_(r7.charSprites_114.get(r6).deref(), 1);
        }

        //LAB_80b1214
        r7._154.get(r6).set(0x10000);

        if(FUN_8077220(MEMORY.ref(2, r7._36c.getAddress() + 0x2 + r6 * 0x2).get(), r2) == 0) {
          r7._154.get(r6).set(0xcccc);
        }

        //LAB_80b122e
      }
    }

    //LAB_80b1244
  }

  @Method(0x80b19cc)
  public static int FUN_80b19cc(final int itemId) {
    final Item2c item = getItem_(itemId);
    final int r5;
    if((item.flags_03.get() & 0x8) != 0) {
      r5 = 0;
      //LAB_80b19ee
    } else if((itemId & 0x400) != 0) {
      r5 = item.price_00.get() / 2;
    } else {
      //LAB_80b1a00
      r5 = item.price_00.get() * 3 / 4;
    }

    //LAB_80b1a0c
    return r5;
  }

  @Method(0x80b1dec)
  public static void FUN_80b1dec(final Panel24 panel, final int unitId) {
    final Unit14c r10 = getUnit_(unitId);
    int r7 = 8;
    int r8 = 0;

    if(panel != null) {
      FUN_8015060(panel);

      if(getUnitItemCount_(unitId) == 0) {
        FUN_8015078(0xc91, panel, 8, 20);
      } else {
        //LAB_80b1e2e
        //LAB_80b1e32
        for(int r5 = 0; r5 < 15; r5++) {
          final int itemId = r10.items_d8.get(r5).get();
          if(itemId != 0) {
            FUN_80152d0(itemId, 27, panel, r7, r8).z_0f.set(252);
          }

          //LAB_80b1e4e
          r7 += 16;
          if(r5 == 0x4) {
            r7 = 8;
            r8 += 16;
          }

          //LAB_80b1e5a
          if(r5 == 0x9) {
            r7 = 8;
            r8 += 16;
          }

          //LAB_80b1e64
        }
      }
    }

    //LAB_80b1e6c
  }

  @Method(0x80b2778)
  public static int FUN_80b2778(final int unitId, final int mode) {
    final int level = getUnit_(unitId).level_0f.get();

    final int ret;
    if(mode == 0) {
      ret = level * 20;
      //LAB_80b2790
    } else if(mode == 1) {
      ret = 10;
      //LAB_80b2798
    } else if(mode == 2) {
      ret = 50;
      //LAB_80b27a0
    } else if(mode == 3) {
      ret = level * 10;
    } else {
      ret = 0;
    }

    //LAB_80b27aa
    return ret;
  }

  @Method(0x80b27b0)
  public static int FUN_80b27b0(final int unitSlot, final int mode) {
    final Unit14c r2 = getUnit_(unitSlot);

    if(mode == 0 && r2.hp_38.get() <= 0) {
      return 1;
    }

    //LAB_80b27c8
    if(mode == 1 && r2.affliction_131.get() != 0) {
      return 1;
    }

    //LAB_80b27da
    if(mode == 2 && r2.haunt_140.get() != 0) {
      return 1;
    }

    //LAB_80b27ea
    if(mode == 3 && r2.curse_130.get() != 0) {
      //LAB_80b27fe
      return 1;
    }

    //LAB_80b2800
    return 0;
  }

  @Method(0x80b280c)
  public static int FUN_80b280c() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r2 = 0;

    //LAB_80b2840
    for(int r7 = 0; r7 < r5._3a7.get(); r7++) {
      if(FUN_80b27b0(MEMORY.ref(2, r5._36c.getAddress() + 0x2 + r7 * 0x2).get(), r5._3aa.get()) != 0) {
        r2++;
      }

      //LAB_80b2854
    }

    //LAB_80b2866
    return r2;
  }

  @Method(0x80b2884)
  public static int FUN_80b2884(int r0) {
    int r2;
    int r3;

    final int r1 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._3aa.get();

    if(r1 == 0x1) {
      r3 = 0xd2e;
      r2 = 0xd24;
      r3 = r3 - r2;
      r0 = r0 + r3;
    }

    //LAB_80b289e
    if(r1 == 0x2) {
      r3 = 0xd38;
      r2 = 0xd24;
      r3 = r3 - r2;
      r0 = r0 + r3;
    }

    //LAB_80b28aa
    if(r1 == 0x3) {
      r3 = 0xd42;
      r2 = 0xd24;
      r3 = r3 - r2;
      r0 = r0 + r3;
    }

    return r0;
  }

  @Method(0x80b28d4)
  public static void FUN_80b28d4(final int r0) {
    final int r5 = FUN_808a540(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).spriteDataIndex_3a4.get()) << 16 | 0x22;
    FUN_8015140();
    FUN_8015038(FUN_80b2884(r0), 5, 0, r5);

    //LAB_80b290e
    while(FUN_8015048() == 0) {
      //LAB_80b2908
      sleep(1);
    }

    sleep(1);
  }

  @Method(0x80b2928)
  public static void FUN_80b2928(int r0) {
    final int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001f2c;
    r3 = MEMORY.ref(4, r3).get();
    r6 = 0xe0;
    CPU.r8().value = r3;
    r6 = r6 << 2;
    r6 = r6 + CPU.r8().value;
    r3 = MEMORY.ref(4, r6).get();
    r3 = MEMORY.ref(1, r3 + 0x5).getUnsigned();
    CPU.r10().value = r3;
    r3 = 0xe9;
    r3 = r3 << 2;
    r3 = r3 + CPU.r8().value;
    r7 = r0;
    r0 = MEMORY.ref(2, r3).getUnsigned();
    r0 = FUN_808a540(r0);
    r5 = r0;
    r0 = r7;
    FUN_80b2884(r0);
    r2 = MEMORY.ref(4, r6).get();
    r3 = 0xd;
    MEMORY.ref(1, r2 + 0x5).setu(r3);
    r7 = r0;
    r5 = r5 << 16;
    FUN_8015140();
    r3 = 0x22;
    r5 = r5 | r3;
    r0 = r7;
    r1 = 0x5;
    r2 = 0x0;
    r3 = r5;
    FUN_8015038(r0, r1, r2, r3);

    //LAB_80b297e
    while(FUN_8015048() == 0) {
      //LAB_80b2978
      sleep(1);
    }

    r0 = 0x1;
    sleep(r0);
    r3 = 0xe0;
    r3 = r3 << 2;
    r3 = r3 + CPU.r8().value;
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.r10().value;
    MEMORY.ref(1, r3 + 0x5).setu(r2);
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80b29a8)
  public static int FUN_80b29a8(final int mapActorIndex) {
    int r10 = 0;
    FUN_80b010c();
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r7._3aa.set(0);
    r7.spriteDataIndex_3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
    Panel24 r8 = FUN_80150f8(r7.spriteDataIndex_3a4.get(), 0, 0, 0);
    if(r8 == null) {
      r8 = addPanel_(-5, 0, 5, 5, 2);
      if(r8 == null) {
        r8 = addPanel_(0, 0, 5, 5, 2);
        FUN_80150d8(2, 0, 0, r8, -4, -4);
      }
    }

    //LAB_80b2a2c
    final GraphicsStruct1c r5 = FUN_80150c8(r7.vramSlot_390.get(), 0x40000000, r8, 0, 0);
    r5._05.set(1);
    r5._04.set(0);
    FUN_80b0a20(r7._380.getAddress(), -32, 112);
    r7._380.set(r5);
    FUN_80b28d4(0xd21);
    r7.panel_0c.set(addPanel_(16, 11, 12, 4, 2));
    FUN_80b10cc();

    //LAB_80b2ab8d
    do {
      r10 = FUN_8015388(r10);
      r7._3aa.set(r10);
      if(r10 == -1) {
        break;
      }

      //LAB_80b2a82
      FUN_80b28d4(0xd24);

      if(FUN_80b280c() == 0) {
        FUN_80b28d4(0xd25);
      } else {
        //LAB_80b2a9a
        FUN_80b2b10();
      }

      //LAB_80b2a9e
      r7._3aa.set(0);
      FUN_80b0a20(r7._380.getAddress(), -32, 112);
      FUN_80b28d4(0xd22);
    } while(true);

    FUN_80b28d4(0xd23);
    FUN_8015018(r7.panel_0c.deref(), 2);
    FUN_8015018(r8, 2);
    FUN_80b0204();
    return 0;
  }

  @Method(0x80b2b10)
  public static int FUN_80b2b10() {
    int r3;
    int r5;
    int r6;
    int r8;
    int r10;
    int sp04;

    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r9 = r7._3aa.get();
    FUN_80b28d4(0xd26);
    final Panel24 r11 = addPanel_(1, 12, 13, 3, 2);
    r7._380.deref()._05.set(4);
    r7._3a8.set(1);
    FUN_80a1028(r11, 2, 0, 8);
    final Panel24 sp08 = addPanel_(1, 16, 23, 3, 2);
    r10 = 0;
    r8 = 0;

    //LAB_80b2b98
    for(r6 = 0; r6 < r7._3a7.get(); r6++) {
      r10 = MEMORY.ref(2, r7._36c.getAddress() + 0x2 + r6 * 0x2).get();

      if(FUN_80b27b0(r10, r9) != 0) {
        break;
      }

      //LAB_80b2b94
    }

    //LAB_80b2bb6
    sp04 = 1;

    //LAB_80b2bba
    do {
      if(r8 != 0) {
        r8 = 0;
        FUN_80b28d4(0xd26);
        sp04 = 1;

        //LAB_80b2bda
        for(r6 = 0; r6 < r7._3a7.get(); r6++) {
          r10 = MEMORY.ref(2, r7._36c.getAddress() + 0x2 + r6 * 0x2).get();

          if(FUN_80b27b0(r10, r9) != 0) {
            break;
          }

          //LAB_80b2bd6
        }
      }

      //LAB_80b2bfa
      if(sp04 != 0) {
        sp04 = 0;
        r6 = modS(r6 + r7._3a7.get(), r7._3a7.get());
        r10 = MEMORY.ref(2, r7._36c.getAddress() + 0x2 + r6 * 0x2).get();
        FUN_80b0a6c(r11, r6 * 24 - 12, 0);
        r7._3a8.set(3);
        FUN_80b2e30(r11, r6);
        FUN_80b2ed8(sp08, r10);
      }

      //LAB_80b2c4a
      if((pressedButtons_3001c94.get() & 0x1) != 0) {
        sleep(1);
        r5 = FUN_80b2778(r10, r9);
        if(FUN_80b27b0(r10, r9) == 0) {
          playSound_(0x71);
          continue;
        }

        //LAB_80b2c7a
        FUN_8015120(r10, 1);
        FUN_8015120(r5, 5);
        r8 = 0xd27;
        FUN_80b28d4(0xd27);
        if(FUN_80b0664(0) != 0) {
          FUN_80b2928(0xd29);
          r8 = 1;
          continue;
        }

        //LAB_80b2cac
        r3 = 0x2000240;
        r3 = MEMORY.ref(4, r3 + 0x10).get();
        if((r5 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
          playSound_(0x71);
          FUN_80b2928(0xd28);
          r8 = 1;
          continue;
        }

        //LAB_80b2cc8
        FUN_8015120(r10, 1);
        FUN_80b28d4(0xd2a);
        FUN_8015140();
        FUN_80b2da8(r10, r9);
        FUN_80b3050(r6);
        addCoins_(-r5);
        FUN_80b10cc();
        FUN_8015120(r10, 1);
        FUN_80b28d4(0xd2b);

        if(FUN_80b280c() == 0) {
          break;
        }

        continue;
      }

      //LAB_80b2d12
      if((pressedButtons_3001c94.get() & 0x2) != 0) {
        playSound_(0x71);
        break;
      }

      //LAB_80b2d24
      if((pressedButtons_3001b04.get() & 0x20) != 0) {
        playSound_(0x6f);
        sp04 = 1;
        r6--;
      }

      //LAB_80b2d3c
      if((pressedButtons_3001b04.get() & 0x10) != 0) {
        playSound_(0x6f);
        sp04 = 1;
        r6++;
      }

      //LAB_80b2d52
      sleep(1);
    } while(true);

    //LAB_80b2d5a
    FUN_80a1030();
    FUN_8015018(sp08, 2);
    FUN_8015018(r11, 2);
    sleep(1);
    return 0;
  }

  @Method(0x80b2da8)
  public static void FUN_80b2da8(final int unitSlot, final int mode) {
    final Unit14c unit = getUnit_(unitSlot);
    if(mode == 0) {
      unit.hp_38.set(unit.maxHp_34.get());
      calcHpPpFractions_(unitSlot);
      //LAB_80b2dc8
    } else if(mode == 1) {
      unit.affliction_131.set(0);
      //LAB_80b2dd0
    } else if(mode == 2) {
      unit.haunt_140.set(0);
      //LAB_80b2de0
    } else if(mode == 3) {
      //LAB_80b2df0
      for(int r6 = 0; r6 < 15; r6++) {
        final UnsignedShortRef r5 = unit.items_d8.get(r6);
        if((r5.get() & 0x200) != 0 && (getItem_(r5.get()).flags_03.get() & 0x1) != 0) {
          r5.xor(0x200);
          recalcStats_(unitSlot);
        }

        //LAB_80b2e18
      }
    }

    //LAB_80b2e20
  }

  @Method(0x80b2e30)
  public static void FUN_80b2e30(@Nullable final Panel24 r0, final int r1) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r9 = r7._3aa.get();

    if(r0 != null) {
      //LAB_80b2e72
      for(int r6 = 0; r6 < r7._3a7.get(); r6++) {
        if(r6 == r1) {
          setSpriteAnimation_(r7.charSprites_114.get(r6).deref(), 30);
        } else {
          //LAB_80b2e80
          setSpriteAnimation_(r7.charSprites_114.get(r6).deref(), 1);
        }

        //LAB_80b2e88
        r7._154.get(r6).set(0x10000);
        if(FUN_80b27b0(MEMORY.ref(2, r7._36c.getAddress() + 0x2 + r6 * 0x2).get(), r9) == 0) {
          r7._154.get(r6).set(0xb333);
        }

        //LAB_80b2ea2
      }
    }

    //LAB_80b2eb8
  }

  @Method(0x80b2ed8)
  public static void FUN_80b2ed8(@Nullable final Panel24 r0, final int r1) {
    int r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._3aa.get();
    final int r8 = FUN_80b2778(r1, r5);
    if(r0 != null) {
      FUN_8015060(r0);
      if(FUN_80b27b0(r1, r5) != 0) {
        r5 = 0xd2c;
      } else {
        //LAB_80b2f12
        r5 = 0xd2d;
      }

      //LAB_80b2f14
      r5 = FUN_80b2884(r5);
      FUN_8015120(r8, 5);
      FUN_8015078(r5, r0, 0, 0);
    }

    //LAB_80b2f30
  }

  @Method(0x80b2f4c)
  public static void FUN_80b2f4c(final FieldPsynergy720.Sub48 r0) {
    final int r7 = r0._40.get();
    if(r7 == 0) {
      final Vec3 r5 = new Vec3();
      r5.setX(r0._14.get());
      r5.setZ(r0._18.get());
      rotVec3(0x280000, rand(), r5);
      FUN_808a510(r0, r5.getX(), r5.getZ());
      r5.setX(r0._14.get());
      r5.setZ(r0._18.get());
      rotVec3(0x40000, rand(), r5);
      r0._0c.set(r5.getX());
      r0._10.set(r5.getZ());
      r0._20.set(0x20000);
      r0._24.set(0x6666);
      r0._42.set(0);
      r0._40.incr();
      //LAB_80b2fc2
    } else if(r7 == 1) {
      if(FUN_808a508(r0) == 0) {
        r0._40.set(0);
      }
      //LAB_80b2fd6
    } else if(r7 == 2) {
      if(FUN_808a508(r0) == 0) {
        clearFieldPsynergyInstance(r0);
      }
    }

    //LAB_80b2fea
  }

  @Method(0x80b2ffc)
  public static void FUN_80b2ffc() {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80b300a
    for(int r6 = 0; r6 < 24; r6++) {
      FUN_808a500(r7._3b0.get(r6));
    }

    final int r5 = r7._3ab.get();
    if(r5 != -1) {
      FUN_8009248(r7.charSprites_114.get(r5).deref(), rand() * 7 >>> 16);
    }
  }

  @Method(0x80b3050)
  public static void FUN_80b3050(final int r0) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r11 = r8._380.deref()._05.get();
    r8._3ab.set(0xff);
    r8._380.deref()._05.set(13);
    CPU.sp().value -= 0xc;
    playSound_(MEMORY.ref(1, 0x80b4ab2 + r8._3aa.get()).get());
    FUN_80b0840(0x202108);
    FUN_8009280(r8.charSprites_114.get(r0).deref(), 0);
    sleep(20);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b2ffc"), 0xc80);
    final int r6 = CPU.sp().value;
    MEMORY.ref(4, r6).setu(r8._134.get(r0).get() << 16);
    MEMORY.ref(4, r6 + 0x8).setu((r8._144.get(r0).get() << 16) - 0xc0000);

    //LAB_80b30ee
    for(int r7 = 0; r7 < 18; r7++) {
      final FieldPsynergy720.Sub48 r5_0 = r8._3b0.get(r7);
      FUN_808a528(r5_0, 0x11c, MEMORY.ref(4, r6).get(), MEMORY.ref(4, r6 + 0x8).get());
      FUN_808a520(r5_0, getConsumer(GoldenSun_80b.class, "FUN_80b2f4c", FieldPsynergy720.Sub48.class));
      setFieldPsynergyInstanceSpriteIndex(r5_0, 7);
      FUN_8009248(r5_0.sprite_00.deref(), rand() * 7 >>> 16);
      r5_0._28.set(0xb333);
      r5_0._2c.set(0xb333);
      sleep(3);

      if(r7 == 0x5) {
        r8._3ab.set(r0);
      }

      //LAB_80b3134
    }

    FUN_80b04c4();

    //LAB_80b314a
    for(int r7 = 0; r7 < 24; r7++) {
      final FieldPsynergy720.Sub48 r2_0 = r8._3b0.get(r7);
      if(r2_0._45.get() != 0) {
        r2_0._40.set(2);
      }

      //LAB_80b3154
    }

    sleep(20);
    playSound_(0x7e);
    r8._3ab.set(-1);
    FUN_8009248(r8.charSprites_114.get(r0).deref(), 0);
    sleep(20);

    //LAB_80b3190
    for(int r7 = 0; r7 < 24; r7++) {
      final FieldPsynergy720.Sub48 r5_0 = r8._3b0.get(r7);
      if(r5_0._45.get() != 0) {
        clearFieldPsynergyInstance(r5_0);
      }

      //LAB_80b31a0
    }

    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b2ffc"));
    FUN_8009280(r8.charSprites_114.get(r0).deref(), 16);
    FUN_80b0894();
    sleep(30);
    r8._380.deref()._05.set(r11);
    CPU.sp().value += 0xc;
  }

  @Method(0x80b3210)
  public static int FUN_80b3210(final int r0) {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r10 = MEMORY.ref(1, 0x80b4ab6 + r0).get();
    int r2 = 0;

    //LAB_80b323e
    for(int r7 = 0; r7 < r6._3a7.get(); r7++) {
      if(getUnit_(MEMORY.ref(2, r6._36c.getAddress() + r7 * 0x2 + 0x2).get()).hp_38.get() != 0) { //TODO
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
    r5.spriteDataIndex_3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
    Panel24 r8 = FUN_80150f8(r5.spriteDataIndex_3a4.get(), 0, 0, 0);
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
      r5.spriteDataIndex_3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
      r8 = FUN_80150f8(r5.spriteDataIndex_3a4.get(), 0, 0, 0);
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
    addCoins_(-r0);

    //LAB_80b33c0
    for(int r5 = 0; r5 < r7; r5++) {
      final Unit14c unit = getUnit_(MEMORY.ref(2, r8 + r5 * 0x2).get());
      if(unit.hp_38.get() != 0) {
        unit.hp_38.set(unit.maxHp_34.get());
        unit.pp_3a.set(unit.maxPp_36.get());
        calcHpPpFractions(MEMORY.ref(2, r8 + r5 * 0x2).get());
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

  @Method(0x80b3444)
  public static int FUN_80b3444(final int r0, final int r1) {
    int r9 = 1;
    int r11 = 0;
    FUN_80b010c();
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r8.panel_20.set(addPanel_(16, 12, 14, 8, 0x2));
    final Panel24 r10 = addPanel_(0, 14, 13, 3, 0x2);
    final GraphicsStruct1c r5 = FUN_80150c8(r8.vramSlot_390.get(), 0x40000000, r10, 0, 0);
    r5._05.set(4);
    r5._04.set(0);
    FUN_80b0a20(r8._380.getAddress(), -32, 112);
    r8._380.set(r5);
    r8._3a8.set(12);
    FUN_80a1028(r10, 2, 0, 8);
    int r7 = 0x0;

    //LAB_80b34ea
    final int sp04;
    do {
      if(r9 != 0) {
        r7 = modS(r7 + r8._3a7.get(), r8._3a7.get());
        r11 = MEMORY.ref(2, r8._36c.getAddress() + 0x2 + r7 * 0x2).get();
        FUN_80b0a6c(r10, r7 * 24 - 12, 0);
        r8._3a8.set(3);
        FUN_80b11c4(r10, r7, 0);
        FUN_80b1dec(r8.panel_20.deref(), r11);
        r9 = 0;
      }

      //LAB_80b353a
      sleep(1);

      if((pressedButtons_3001c94.get() & 0x1) == 0) {
        //LAB_80b3598
        if((pressedButtons_3001c94.get() & 0x2) != 0) {
          playSound_(0x71);
          MEMORY.ref(4, r0).setu(-1);
          MEMORY.ref(4, r1).setu(-1);
          sp04 = -1;
          break;
        }

        //LAB_80b35b8
        if((pressedButtons_3001b04.get() & 0x20) != 0) {
          playSound_(0x6f);
          r9 = 1;
          r7--;
        }

        //LAB_80b35d0
        if((pressedButtons_3001b04.get() & 0x10) != 0) {
          playSound_(0x6f);
          r9 = 1;
          r7++;
        }
      } else if(getUnitItemCount_(r11) != 0) {
        //LAB_80b355e
        playSound_(0x70);
        final int r0_0 = FUN_80b362c(r11);
        if(r0_0 != -1) {
          //LAB_80b3588
          MEMORY.ref(4, r0).setu(r11);
          MEMORY.ref(4, r1).setu(r0_0);
          sp04 = 0;
          break;
        }

        r8._380.deref()._05.set(4);
        r8._3a8.set(12);
        r9 = 1;
      } else {
        playSound_(0x71);
      }
    } while(true);

    //LAB_80b35e8
    FUN_80a1030();
    FUN_8015018(r10, 2);
    FUN_8015018(r8.panel_20.deref(), 2);
    sleep(1);
    FUN_80b0204();
    return sp04;
  }

  @Method(0x80b362c)
  public static int FUN_80b362c(final int unitId) {
    int r3;
    int r6;
    int r7;
    int r9;
    int r10;

    final Menua70 sp14 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Unit14c sp08 = getUnit_(unitId);
    int sp04 = 0;
    r10 = 1;
    r9 = 1;
    final Panel24 sp0c = addPanel_(14, 8, 16, 4, 0x2);
    final Panel24 sp10 = addPanel_(0, 5, 30, 3, 0x2);
    sp14._380.deref()._05.set(18);
    sp14._3a8.set(12);
    r7 = 0;

    //LAB_80b3690
    do {
      if(r9 != 0) {
        r9 = 0;
        r10 = getUnitItemCount_(unitId);
        r3 = r10 - 1;
        if(r7 > r3) {
          r7 = r3;
        }

        //LAB_80b36ac
        r6 = sp08.items_d8.get(r7).get() & 0x1ff;
        FUN_80b0a6c(sp14.panel_20.deref(), modS(r7, 5) * 16, divideS(r7, 5) * 16 + 8);
        sp14._3a8.set(3);
        FUN_80b386c(sp0c, unitId, r7);
        drawPanelWithIcon(sp10, r6 + 0x75);
      }

      //LAB_80b370c
      sleep(1);

      if((pressedButtons_3001c94.get() & 0x1) == 0) {
        //LAB_80b377c
        if((pressedButtons_3001c94.get() & 0x2) != 0) {
          playSound_(0x71);
          sp04 = -1;
          break;
        }

        //LAB_80b3794
        if((pressedButtons_3001b04.get() & 0x20) != 0) {
          playSound_(0x6f);
          r7 = modS(r7 - 1 + r10, r10);
          r9 = 1;
        }

        //LAB_80b37b8
        if((pressedButtons_3001b04.get() & 0x10) != 0) {
          playSound_(0x6f);
          r7 = modS(r7 + 1 + r10, r10);
          r9 = 1;
        }

        //LAB_80b37da
        if((pressedButtons_3001b04.get() & 0x40) != 0) {
          r7 = r7 - 0x5;
          if(r7 < 0x0) {
            r7 = r7 + 0xf;
          }

          //LAB_80b37ec
          //LAB_80b37f0
          while(r7 >= r10) {
            r7 = r7 - 0x5;
          }

          //LAB_80b37f6
          playSound_(0x6f);
          r9 = 1;
        }

        //LAB_80b3800
        if((pressedButtons_3001b04.get() & 0x80) != 0) {
          //LAB_80b380e
          r7 = r7 + 0x5;
          if(r7 >= r10) {
            r7 = r7 - 0xf;
          }

          //LAB_80b3816
          //LAB_80b381a
          while(r7 < 0) {
            r7 = r7 + 0x5;
          }

          //LAB_80b3820
          playSound_(0x6f);
          r9 = 1;
        }
      } else {
        final int r0_0 = FUN_80772a8(unitId, r7);
        if(r0_0 == 0) {
          playSound_(0x70);
          sp04 = r7;
          break;
        }

        //LAB_80b3734
        if(r0_0 == -4) {
          FUN_8015038(0xc96, 8, 1, 2);
          //LAB_80b374a
        } else if(sp04 == -3) {
          FUN_8015038(0xc97, 8, 1, 2);
        }

        //LAB_80b3760
        playSound_(0x71);

        //LAB_80b376e
        while(FUN_8015048() == 0) {
          //LAB_80b3768
          sleep(1);
        }

        FUN_8015140();
      }
    } while(true);

    //LAB_80b382c
    FUN_8015018(sp10, 2);
    FUN_8015018(sp0c, 2);
    sleep(1);
    return sp04;
  }

  @Method(0x80b386c)
  public static void FUN_80b386c(final Panel24 r0, final int r1, final int r2) {
    final Unit14c r8 = getUnit_(r1);
    final int r5 = r8.items_d8.get(r2).get() & 0x1ff;
    final int r11 = (r8.items_d8.get(r2).get() >>> 11) + 1;
    if(r0 != null) {
      drawPanelBackground_(r0);
      drawIcon_(0x182 + r5, r0, 0, 0);
      final int r0_0 = FUN_80772a8(r1, r2);
      if(r0_0 == -4) {
        drawIcon_(0xc94, r0, 0, 8);
        //LAB_80b38cc
      } else if(r0_0 == -3) {
        drawIcon_(0xc95, r0, 0, 8);
      } else {
        //LAB_80b38e2
        final int r6 = r11 * FUN_80b19cc(r8.items_d8.get(r2).get());
        drawIcon_(0xc8d, r0, 8, 8);
        FUN_80150b0(r6, 5, r0, 40, 8);
        drawIcon_(0xc88, r0, 80, 8);
      }
    }

    //LAB_80b391a
  }

  /** {@link GoldenSun_80b#loadUnitSprites} */
  @Method(0x80b5010)
  public static void loadUnitSprites_(final int[] unitIds, final int setAnimations) {
    MEMORY.call(0x80b7b6c, unitIds, setAnimations);
  }

  /** {@link GoldenSun_80c#FUN_80c0cec} */
  @Method(0x80b5028)
  public static void FUN_80b5028(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x80c0cec, x, y, z, r3);
  }

  /** {@link GoldenSun_80c#FUN_80c0df4} */
  @Method(0x80b5030)
  public static void FUN_80b5030(final int unitId0, final int unitId1, final int r2) {
    MEMORY.call(0x80c0df4, unitId0, unitId1, r2);
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

  /** {@link GoldenSun_80c#FUN_80c2434} */
  @Method(0x80b5058)
  public static int FUN_80b5058(final int r0) {
    return (int)MEMORY.call(0x80c2434, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b8530} */
  @Method(0x80b5070)
  public static int FUN_80b5070(final int unitId) {
    return (int)MEMORY.call(0x80b8530, unitId);
  }

  /** {@link GoldenSun_80b#FUN_80b82c4} */
  @Method(0x80b5078)
  public static void FUN_80b5078(final int unitId0, final int unitId1, final int r2, final int r3) {
    MEMORY.call(0x80b82c4, unitId0, unitId1, r2, r3);
  }

  /** {@link GoldenSun_80b#FUN_80b8228} */
  @Method(0x80b5088)
  public static void FUN_80b5088(final int unitId, final int r1) {
    MEMORY.call(0x80b8228, unitId, r1);
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
  public static int FUN_80b50a8(final int r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80b7f20, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b845c} */
  @Method(0x80b50b0)
  public static int FUN_80b50b0(final int unitId, final Vec3 r1) {
    return (int)MEMORY.call(0x80b845c, unitId, r1);
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

  /** {@link GoldenSun_80b#tickRecoveryQueue} */
  @Method(0x80b50f8)
  public static boolean tickRecoveryQueue_() {
    return (boolean)MEMORY.call(0x80bf5a8);
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
    transformVector(new Vec3().set(0, 0, camera._20.get()), camera._00);

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
    final int[] charIds = new int[10];
    final int charCount = getBattleChars(charIds);

    //LAB_80b5b3c
    for(int charIndex = 0; charIndex < charCount; charIndex++) {
      final Unit14c unit = getUnit_(charIds[charIndex]);

      //LAB_80b5b4c
      for(int r1 = 0; r1 < 4; r1++) {
        unit.summonBoosts_12c.get(r1).set(0);
      }

      unit._132.set(0);
      unit._133.set(0);
      unit._134.set(0);
      unit._135.set(0);
      unit._136.set(0);
      unit._137.set(0);
      unit._138.set(0);
      unit._139.set(0);
      unit._13a.set(0);
      unit._13b.set(0);
      unit._13c.set(0);
      unit._13d.set(0);
      unit._13e.set(0);
      unit._13f.set(0);
      unit._141.set(0);
      unit.crit_142.set(0);
      unit.reflux_143.set(0);
      unit.kiteTurns_144.set(0);
      unit._145.set(0);
      unit._146.set(0);
      unit._147.set(0);
      unit._148.set(0);
      recalcStats_(charIds[charIndex]);
    }

    //LAB_80b5bee
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
            while(r0 < r1.count_108.get() && (element != r1.djinn_08.get(r0).element_00.get() || djinn != r1.djinn_08.get(r0).djinn_01.get())) {
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
        final RecoveryQueue10c.DjinnInfo04 r7 = queue.djinn_08.get(r8);
        if(r7.turnsRemaining_03.get() == -1) {
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
        MEMORY.ref(1, r10 + r8).addu(getUnit_(charIds[i]).djinn_f8.djinnCounts_20.get(r8).get());
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

  /** Called when first character finishes attacking and second character is about to attack */
  @Method(0x80b6148)
  public static int FUN_80b6148() {
    final BattleStruct82c r1 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    int r7 = 0;
    if(r1._44.get() == 0) {
      return 0;
    }

    //LAB_80b615e
    final int r2 = r1._50.get();
    final int r5 = 0x2002024 + (r2 ^ 0x1) * 0x18;
    if(r1._52.get() != 0) {
      return -1;
    }

    //LAB_80b6180
    final int r6 = 0x2002224;
    MEMORY.ref(2, r6).setu(0x65);
    MEMORY.ref(2, r6 + 0x2).setu(0x78);
    MEMORY.ref(2, r6 + 0x8).setu(0x54);
    MEMORY.ref(2, r6 + 0xa).setu(0x55);
    sleep(1);

    //LAB_80b61ba
    do {
      while((_3001f64.get() & 0x3) != 0x3) {
        r7++;
        if(r7 > 0x18) {
          return -1;
        }

        //LAB_80b61b4
        sleep(1);
      }

      //LAB_80b61ce
      r7 = 0;
      if(MEMORY.ref(2, r6 + 0x4).getUnsigned() != MEMORY.ref(2, r5 + 0x4).getUnsigned() || MEMORY.ref(2, r6 + 0x6).getUnsigned() != MEMORY.ref(2, r5 + 0x6).getUnsigned()) {
        return -1;
      }

      //LAB_80b61e4
      if(MEMORY.ref(2, r6).getUnsigned() == MEMORY.ref(2, r5).getUnsigned() && MEMORY.ref(2, r6 + 0x2).getUnsigned() == MEMORY.ref(2, r5 + 0x2).getUnsigned() && MEMORY.ref(2, r6 + 0x8).getUnsigned() == MEMORY.ref(2, r5 + 0x8).getUnsigned() && MEMORY.ref(2, r6 + 0xa).getUnsigned() == MEMORY.ref(2, r5 + 0xa).getUnsigned()) {
        break;
      }

      sleep(1);
    } while(true);

    MEMORY.ref(2, r6 + 0xc).setu(0x72);
    MEMORY.ref(2, r6 + 0xe).setu(0x6e);

    //LAB_80b6214
    do {
      while((_3001f64.get() & 0x3) != 0x3) {
        r7++;
        if(r7 > 0x18) {
          return -1;
        }

        //LAB_80b620e
        sleep(1);
      }

      //LAB_80b6234
      r7 = 0;
      if(MEMORY.ref(2, r6 + 0x8).getUnsigned() != MEMORY.ref(2, r5 + 0x8).getUnsigned() || MEMORY.ref(2, r6 + 0xa).getUnsigned() != MEMORY.ref(2, r5 + 0xa).getUnsigned()) {
        return -1;
      }

      if(MEMORY.ref(2, r6 + 0xc).getUnsigned() == MEMORY.ref(2, r5 + 0xc).getUnsigned() && MEMORY.ref(2, r6 + 0xe).getUnsigned() == MEMORY.ref(2, r5 + 0xe).getUnsigned()) {
        break;
      }

      sleep(1);
    } while(true);

    MEMORY.ref(2, r6).setu(0x45);
    MEMORY.ref(2, r6 + 0x4).setu(0x45);
    MEMORY.ref(2, r6 + 0x2).setu(0x58);
    MEMORY.ref(2, r6 + 0x6).setu(0x43);

    //LAB_80b6270
    do {
      while((_3001f64.get() & 0x3) != 0x3) {
        r7++;
        if(r7 > 0x18) {
          return -1;
        }

        //LAB_80b626a
        sleep(1);
      }

      //LAB_80b6294
      r7 = 0;
      if(MEMORY.ref(2, r6 + 0xc).getUnsigned() != MEMORY.ref(2, r5 + 0xc).getUnsigned() || MEMORY.ref(2, r6 + 0xe).getUnsigned() != MEMORY.ref(2, r5 + 0xe).getUnsigned()) {
        return -1;
      }

      if(MEMORY.ref(2, r6).getUnsigned() == MEMORY.ref(2, r5).getUnsigned() && MEMORY.ref(2, r6 + 0x2).getUnsigned() == MEMORY.ref(2, r5 + 0x2).getUnsigned() && MEMORY.ref(2, r6 + 0x4).getUnsigned() == MEMORY.ref(2, r5 + 0x4).getUnsigned() && MEMORY.ref(2, r6 + 0x6).getUnsigned() == MEMORY.ref(2, r5 + 0x6).getUnsigned()) {
        break;
      }

      sleep(1);
    } while(true);

    MEMORY.ref(2, r6 + 0x8).setu(0x74);
    MEMORY.ref(2, r6 + 0xa).setu(0x75);

    //LAB_80b62d6
    do {
      while((_3001f64.get() & 0x3) != 0x3) {
        r7++;
        if(r7 > 0x18) {
          return -1;
        }

        //LAB_80b62d0
        sleep(1);
      }

      //LAB_80b62f8
      r7 = 0;
      if(MEMORY.ref(2, r6).getUnsigned() != MEMORY.ref(2, r5).getUnsigned() || MEMORY.ref(2, r6 + 0x2).getUnsigned() != MEMORY.ref(2, r5 + 0x2).getUnsigned() || MEMORY.ref(2, r6 + 0x4).getUnsigned() != MEMORY.ref(2, r5 + 0x4).getUnsigned() || MEMORY.ref(2, r6 + 0x6).getUnsigned() != MEMORY.ref(2, r5 + 0x6).getUnsigned()) {
        return -1;
      }

      if(MEMORY.ref(2, r6 + 0x8).getUnsigned() == MEMORY.ref(2, r5 + 0x8).getUnsigned() && MEMORY.ref(2, r6 + 0xa).getUnsigned() == MEMORY.ref(2, r5 + 0xa).getUnsigned()) {
        break;
      }

      sleep(1);
    } while(true);

    MEMORY.ref(2, r6 + 0xc).setu(0x52);
    MEMORY.ref(2, r6 + 0xe).setu(0x4e);

    //LAB_80b633a
    do {
      while((_3001f64.get() & 0x3) != 0x3) {
        r7++;
        if(r7 > 0x18) {
          return -1;
        }

        //LAB_80b6334
        sleep(1);
      }

      //LAB_80b6360
      r7 = 0;
      if(MEMORY.ref(2, r5 + 0xc).getUnsigned() != 0x72 || MEMORY.ref(2, r5 + 0xe).getUnsigned() != 0x6e) {
        break;
      }

      sleep(1);
    } while(true);

    //LAB_80b636e
    return 0;
  }

  @Method(0x80b6378)
  public static void FUN_80b6378() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b63b0)
  public static void FUN_80b63b0() {
    MEMORY.call(0x3000164, 0x2002224, 0x10); // memzero
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

      r6 = readFlagsByte_(0x3f0);
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
        if(getLivingUnitIds(1, null) == 0) {
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
        if(getLivingUnitIds(2, null) == 0) {
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
                loadEnemyUnit_(0x80, r8._10.get(r8._3c.get()).get(), 0x1a);
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
    tickRecoveryQueue();
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
      getUnit_(charId)._12a.set(2);
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
      if(getUnit_(r5)._12a.get() != 0) {
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
  public static int getLivingUnitIds(final int flags, @Nullable final int[] out) {
    final int maxMonsterCount = readFlag_(0x16c) != 0 ? 3 : 6;

    //LAB_80b6b68
    int count = 0;
    if((flags & 0x1) != 0) {
      final int[] charIds = new int[5];
      final int charCount = getBattleChars(charIds);

      //LAB_80b6b82
      for(int r5 = 0; r5 < charCount; r5++) {
        final int charId = charIds[r5];
        if(getUnit_(charId).hp_38.get() > 0) {
          if(out != null) {
            out[count] = charId;
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
        final Unit14c unit = getUnit_(r5);
        if(unit._12a.get() != 0) {
          if(unit.hp_38.get() > 0) {
            if(out != null) {
              out[count] = r5;
            }

            //LAB_80b6be0
            count++;
          }
        }

        //LAB_80b6be4
      }
    }

    //LAB_80b6bea
    if(out != null) {
      out[count] = 0xff;
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

  @Method(0x80b6cb0)
  public static void loadAllUnitSprites() {
    final int[] unitIds = new int[15];
    getUnitIds(0x3, unitIds);
    loadUnitSprites(unitIds, 0);
  }

  @Method(0x80b6cd0)
  public static int FUN_80b6cd0(final int unitId) {
    return getCombatantForUnit(unitId)._14.get();
  }

  @Method(0x80b6cdc)
  public static int FUN_80b6cdc(int r0) {
    r0 = FUN_80c23c0(r0);
    final BattleStruct82c r4 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    int r1 = 0;
    //LAB_80b6cfc
    while(r4.unitIds_04.get(r1).get() != 0 || r0 == 0 && (r1 > 0x4 || r4.unitIds_04.get(r1 + 1).get() != 0)) {
      r1 = r1 + 0x1;
      if(r1 > 0x5) {
        break;
      }
    }

    //LAB_80b6d1c
    final int r3 = 0x6 ^ r1;
    return (-r3 | r3) >>> 31;
  }

  @Method(0x80b6d30)
  public static int FUN_80b6d30(final int charId) {
    final BattleStruct82c r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final Unit14c r9 = getUnit_(charId);
    final int r8 = FUN_80c23c0(r9.id_128.get());
    final int r7 = getActorPropertiesSprite(r9.id_128.get());
    int r10 = 0;

    //LAB_80b6d68
    for(int r4 = 0; r4 < 2; r4++) {
      if(r9.class_129.get() == 0) {
        //LAB_80b6d8a
        int r5;
        for(r5 = 0; r5 < 6 && (r6.unitIds_04.get(r5).get() != 0 || r8 == 0 && (r5 > 4 || r6.unitIds_04.get(r5 + 1).get() != 0)); r5++) {
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
        r6.unitIds_04.get(r5).set(charId);
        if(r8 == 0) {
          r6.unitIds_04.get(r5 + 1).set(charId);
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

  @Method(0x80b6e30)
  public static void FUN_80b6e30(final int unitId) {
    final BattleStruct82c r7 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    //LAB_80b6e46
    for(int r6 = 0; r6 < 6; r6++) {
      if(r7.unitIds_04.get(r6).get() == unitId) {
        FUN_8009270(r6, 0, 0, 0);
        r7.unitIds_04.get(r6).set(0);
      }

      //LAB_80b6e68
    }
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
    final Unit14c r6 = getUnit_(r0);
    final int r0_0 = getEquippedItemSlotOfType_(r0, 1);
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
    final Unit14c unit = getUnit_(charId);
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
      if(getUnitEquippedItemIdOfType_(unit, 1) == 15) {
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
          final Unit14c r5 = getUnit_(charIds[r10]);

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
        if(FUN_80c23c0(getUnit_(charIds[r10]).id_128.get()) == 0) {
          r2 = 0x26;
        }
      }

      //LAB_80b74ec
      r7 -= (r2 >>> 1);
      r8 += 0x4;
    }

    //LAB_80b74fe
  }

  @Method(0x80b7514)
  public static int FUN_80b7514() {
    //LAB_80b751c
    for(int r5 = 0; r5 < 6; r5++) {
      final int r6 = r5 + 0x80;
      if(getUnit_(r6)._12a.get() == 0) {
        return r6;
      }

      //LAB_80b751a
    }

    //LAB_80b7536
    //LAB_80b7540
    return -1;
  }

  @Method(0x80b7548)
  public static void FUN_80b7548() {
    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int[] r0 = new int[6];

    //LAB_80b7570
    int r6;
    for(r6 = 0; r6 < 6 && r2.monsterIds_66.get(r6).get() != 0xff; r6++) {
      r0[r6] = r2.monsterIds_66.get(r6).get();
    }

    //LAB_80b7588
    CPU.sp().value -= 0x4c;
    final int r10 = CPU.sp().value + 0x18;
    final int r8 = CPU.sp().value;
    FUN_80b7424(r0, r6, r10, r8);

    //LAB_80b75a0
    for(int i = 0; i < r6; i++) {
      final int unitId = r2.monsterIds_66.get(i).get();
      if(unitId != 0xfe) {
        final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitId);
        combatant.x_0c.set(MEMORY.ref(4, r10 + i * 0x4).get() << 16);
        combatant.z_10.set(MEMORY.ref(4, r8 + i * 0x4).get() << 16);
      }

      //LAB_80b75bc
    }

    //LAB_80b75c6
    CPU.sp().value += 0x4c;
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
    final Unit14c r2 = getUnit_(unitId);
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
    final Unit14c unit = getUnit_(unitId);
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

  @Method(0x80b7e60)
  public static int FUN_80b7e60(final int unitId) {
    FUN_80b6e30(unitId);
    getCombatantForUnit(unitId)._28.set(1);
    return 0;
  }

  /** Called when enemy dies, also looks like it handles players */
  @Method(0x80b7e7c)
  public static void FUN_80b7e7c() {
    //LAB_80b7e82
    for(int r6 = 0; r6 < 14; r6++) {
      final int r0;
      if(r6 < 8) {
        r0 = r6;
      } else {
        r0 = r6 + 120;
      }

      //LAB_80b7e8c
      final BattleStruct82c.Combatant2c r5 = getCombatantForUnit(r0);
      if(r5 != null) {
        if(r5._28.get() != 0) {
          clearActor_(r5.actor_00.deref());
          r5.actor_00.clear();
          r5._28.set(0);
        }
      }

      //LAB_80b7ea8
    }
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
    transformVector(new Vec3().set(0, 0, camera._20.get()), camera._00);
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
      mulTransforms(_80c2a7c);
      FUN_80051e8(camera._00, camera._0c);
    } else {
      //LAB_80b7f00
      FUN_80051d8(camera._00, camera._0c);
    }
  }

  @Method(0x80b8000)
  public static void FUN_80b8000(final int unitId) {
    final BattleStruct82c.Combatant2c r6 = getCombatantForUnit(unitId);
    final Actor70 r5 = r6.actor_00.deref();
    r5.velocity_24.setY(0);
    r5.velocityScalar_30.set(0x80000);
    r5.acceleration_34.set(0x20000);
    r5._44.set(0);
    r5._48.set(0xab85);
    r5._58.set(1);
    r5._5a.set(0);
    FUN_8009140(r5);
    moveActorTo_(r5, r6.x_0c.get(), 0, r6.z_10.get());
    r5.angle_06.set(atan2(r6.z_10.get() / 8, r6.x_0c.get()) + 0x8000);
  }

  @Method(0x80b8178)
  public static void FUN_80b8178(final int unitId) {
    final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitId);
    final Actor70 actor = combatant.actor_00.deref();
    actor.velocityScalar_30.set(0x40000);
    actor.acceleration_34.set(0x10000);
    actor.velocity_24.setY(0x30000);
    actor._48.set(0x9999);
    actor._44.set(0);
    actor._5a.set(0);
    FUN_8009140(actor);
    moveActorTo_(actor, combatant.x_0c.get() * 3 / 2, 0, combatant.z_10.get());
  }

  @Method(0x80b8064)
  public static void FUN_80b8064(final int unitId) {
    final BattleStruct82c.Combatant2c r6 = getCombatantForUnit(unitId);
    final Actor70 r5 = r6.actor_00.deref();
    r5.velocityScalar_30.set(0x80000);
    r5.acceleration_34.set(0x20000);
    r5.velocity_24.setY(0x50000);
    r5._44.set(0);
    r5._48.set(0x7851);
    r5._5a.set(0);
    FUN_8009140(r5);
    moveActorTo_(r5, r6.x_0c.get() * 3, 0, r6.z_10.get());
    setActorAnimation_(r5, 1);
  }

  @Method(0x80b8228)
  public static void FUN_80b8228(final int unitId, final int r1) {
    final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(unitId);
    final Actor70 actor = combatant.actor_00.deref();
    if(getUnit_(unitId).id_128.get() != 0x94) {
      actor.acceleration_34.set(MEMORY.ref(4, 0x80c59a4 + r1 * 0x4).get());
      actor.velocityScalar_30.set(MEMORY.ref(4, 0x80c59c4 + r1 * 0x4).get());

      if(actor.pos_08.getY() == 0 || r1 > 0x4) {
        //LAB_80b8266
        actor.velocity_24.setY(MEMORY.ref(4, 0x80c59e4 + r1 * 0x4).get());
      }

      //LAB_80b826c
      actor._44.set(0);
      actor._48.set(0x9999);
      actor._5a.set(0);
      FUN_8009140(actor);
      moveActorTo_(actor, divideS(MEMORY.ref(4, 0x80c5a04 + r1 * 0x4).get() * combatant.x_0c.get(), 100), 0, combatant.z_10.get());
    }

    //LAB_80b829c
    setActorAnimation_(actor, 5);
  }

  @Method(0x80b82c4)
  public static void FUN_80b82c4(final int unitId0, final int unitId1, final int r2, final int r3) {
    final Actor70 actor0 = getCombatantForUnit(unitId0).actor_00.deref();
    final Actor70 actor1 = getCombatantForUnit(unitId1).actor_00.deref();
    int dx = divideS(75 * (actor1.pos_08.getX() - actor0.pos_08.getX()), 100);
    int dz = divideS(75 * (actor1.pos_08.getZ() - actor0.pos_08.getZ()), 100);
    final int r8 = actor0.pos_08.getX() + dx;
    final int r6 = actor0.pos_08.getZ() + dz;
    dx = dx >> 8;
    dz = dz >> 8;
    final int r0 = divideS(sqrt(dx * dx + dz * dz) << 8, r2);
    actor0.acceleration_34.set(r0);
    actor0.velocityScalar_30.set(r0);
    actor0._58.set(1);

    if((actor0._55.get() & 0x4) != 0) {
      actor0.velocity_24.setY(r3);
    }

    //LAB_80b8352
    actor0.velocity_24.setY(r3);
    actor0._48.set(0xab85);
    actor0._5a.set(1);
    FUN_8009140(actor0);
    moveActorTo_(actor0, r8, 0, r6);
    setActorAnimation_(actor0, 2);
  }

  @Method(0x80b845c)
  public static int FUN_80b845c(final int unitId, final Vec3 r1) {
    final Actor70 actor = getCombatantForUnit(unitId).actor_00.deref();
    final Sprite38 sprite = getActorSprite(actor, 0);
    FUN_80b7ed8();
    final int r6 = (int)MEMORY.call(0x3000118, FUN_8005268(actor.pos_08, r1), sprite.scale_18.get());
    r1.y_04.sub((int)MEMORY.call(0x3000118, r6, FUN_80b8530(unitId) >> 16));
    return 0;
  }

  @Method(0x80b84c0)
  public static int FUN_80b84c0(final int charId, final Vec3 r1) {
    final Actor70 actor = getCombatantForUnit(charId).actor_00.deref();
    final Sprite38 sprite = getActorSprite(actor, 0);

    FUN_80b7ed8();

    final int r6 = (int)MEMORY.call(0x3000118, FUN_8005268(actor.pos_08, r1), sprite.scale_18.get());

    final int r1_0;
    if(FUN_80c23c0(getUnit_(charId).id_128.get()) != 0) {
      r1_0 = 0x18;
    } else {
      //LAB_80b850e
      r1_0 = 0x30;
    }

    //LAB_80b8512
    r1.y_04.add((int)MEMORY.call(0x3000118, r6, r1_0));
    return 0;
  }

  @Method(0x80b8530)
  public static int FUN_80b8530(final int r0) {
    int r3 = FUN_80c2454(getUnit_(r0).id_128.get()) << 24 >>> 8;
    if(r3 == 0) {
      if(FUN_80c23c0(getUnit_(r0).id_128.get()) == 0) {
        r3 = 0x300000;
      } else {
        r3 = 0x180000;
      }
    }

    //LAB_80b856a
    return r3;
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
    transformVector(new Vec3().set(0, 0, camera._20.get()), camera._00);
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
      getUnit_(unitIds[i])._12b.set(0);
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
    final int[] charIds = new int[5];
    final int charCount = getLivingUnitIds(0x1, charIds);
    int turnCount = 0;
    int r9 = 0;

    //LAB_80b9246
    for(int i = 0; i < charCount; i++) {
      final Unit14c unit = getUnit_(charIds[i]);

      //LAB_80b9282
      for(int r5 = 0; r5 < unit.turns_43.get(); r5++) {
        if(unit._13c.get() != 0 || (unit._138.get() & ~0xff) != 0) {
          final BattleStruct82c.Turn10 turn = turns.get(turnCount);

          //LAB_80b9296
          turn.unitId_00.set(charIds[i]);
          turn.agility_04.set(unit.agility_40.get());
          turn._06.set(8);
          turn._08.set(0);
          turn._0a.set(0x180);
          turnCount++;
        } else {
          //LAB_80b92c0
          MEMORY.ref(2, sp08 + r9 * 0x2).setu(charIds[i]);
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
    setMallocAddress(sp08);
    return r5;
  }

  @Method(0x80b9324)
  public static int FUN_80b9324(final ArrayRef<BattleStruct82c.Turn10> turns, final int turnIndex) {
    final BattleStruct82c sp08 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    if(sp08._45.get() == 1) {
      return 0;
    }

    //LAB_80b934c
    final int[] monsterIds = new int[8];
    int r8 = getLivingUnitIds(0x2, monsterIds);
    if(r8 == 0) {
      return 0;
    }

    //LAB_80b9368
    for(int r4 = 0; r4 < 32; r4++) {
      final int r5 = r8 * rand() >>> 16;
      final int r2 = r8 * rand() >>> 16;
      final int r1 = monsterIds[r5];
      final int r3 = monsterIds[r2];
      monsterIds[r5] = r3;
      monsterIds[r2] = r1;
    }

    if(sp08._45.get() == 2) {
      int r3 = (rand() * 5 >>> 16) + 1;
      if(r3 < 2) {
        r3 = 2;
      }

      //LAB_80b93ac
      if(r8 > r3) {
        r8 = r3;
      }
    }

    //LAB_80b93b2
    //LAB_80b93b8
    int sp0c = turnIndex;
    for(int r4 = 0; r4 < r8; r4++) {
      final int r9 = monsterIds[r4];
      final Unit14c unit = getUnit_(r9);

      //LAB_80b93e8
      for(int r7 = 0; r7 < unit.turns_43.get(); r7++) {
        final BattleStruct82c.Turn10 r5 = turns.get(sp0c);
        r5.unitId_00.set(r9);

        final int r2 = unit.agility_40.get();
        if(r7 != 0) {
          r5.agility_04.set(r2 / 2);
        } else {
          r5.agility_04.set(r2);
        }

        //LAB_80b9402
        if(unit._13c.get() != 0 || unit._13b.get() != 0) {
          //LAB_80b9418
          r5._06.set(8);
          r5._08.set(0);
          r5._0a.set(0x100);
        } else {
          //LAB_80b9430
          FUN_80bd424(r5, 0);
        }

        //LAB_80b943c
        sp0c++;
        if(sp08._45.get() == 2) {
          break;
        }
      }

      //LAB_80b9456
    }

    //LAB_80b945c
    //LAB_80b945e
    return sp0c;
  }

  @Method(0x80b9470)
  public static void FUN_80b9470(final ArrayRef<BattleStruct82c.Turn10> turns, final int r1) {
    CPU.sp().value -= 0x10;

    //LAB_80b948c
    for(int i = 0; i < r1; i++) {
      final BattleStruct82c.Turn10 turn = turns.get(i);
      if(turn._06.get() == 5) {
        int r2 = turn._08.get();
        r2 = getAbility_(getDjinnAbility_(r2 >> 8 & 0xf, r2 & 0xff)).effect_03.get();
        final int r3 = r2 + 210 << 24;
        if((r3 & 0xffff_ffffL) <= 0x1000000 || r2 == 0x35) {
          //LAB_80b94c8
          turn.agility_04.add(10000);
        }
      }

      //LAB_80b94dc
    }

    //LAB_80b94e4
    //LAB_80b94e8
    int r10;
    do {
      int r7 = r1 - 1;
      r10 = 0;

      //LAB_80b9500
      while(r7 > 0) {
        final BattleStruct82c.Turn10 r5 = turns.get(r7 - 1);
        final BattleStruct82c.Turn10 r6 = turns.get(r7);

        if(r6.agility_04.get() > r5.agility_04.get()) {
          MEMORY.call(0x3001388, CPU.sp().value, r6.getAddress(), 0x10); // memcpy
          MEMORY.call(0x3001388, r6.getAddress(), r5.getAddress(), 0x10); // memcpy
          MEMORY.call(0x3001388, r5.getAddress(), CPU.sp().value, 0x10); // memcpy
          r10++;
        }

        //LAB_80b952e
        r7--;
      }

      //LAB_80b9538
    } while(r10 != 0);

    CPU.sp().value += 0x10;
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
      r6 += FUN_80b9324(turns, r6);
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
        getUnit_(turn.unitId_00.get())._12b.set(((-r2 | r2) >>> 31) + 1);
      }

      //LAB_80b9a0e
    }

    //LAB_80b9a16
    clearFlag_(0x16b);
    initCamera();
    boardWramMallocHead_3001e50.offset(44 * 0x4).deref(4).setu(0x2000);
    return r6;
  }

  @Method(0x80b9a44)
  public static int FUN_80b9a44(final int r0) {
    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    if((r0 & 0x80) != 0) {
      return r2.monsterIds_66.get(r0 & 0xf).get();
    }

    //LAB_80b9a5e
    return r2.charIds_58.get(r0 & 0xf).get();
  }

  @Method(0x80b9a70)
  public static int FUN_80b9a70(final int unitId) {
    final BattleStruct82c r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    if(unitId < 8) {
      //LAB_80b9a84
      for(int i = 0; ; i++) {
        final int r2 = r3.charIds_58.get(i).get();

        if(r2 == 0xff) {
          return -1;
        }

        if(r2 != 0xfe && r2 == unitId) {
          return i | 0x100;
        }

        //LAB_80b9a92
      }
    }

    //LAB_80b9a98
    //LAB_80b9aa2
    for(int i = 0; ; i++) {
      final int r2 = r3.monsterIds_66.get(i).get();
      if(r2 == 0xff) {
        //LAB_80b9aa8
        return -1;
      }

      //LAB_80b9aae
      if(r2 != 0xfe && r2 == unitId) {
        //LAB_80b9ab6
        return i | 0x180;
      }

      //LAB_80b9aba
    }

    //LAB_80b9ac0
  }

  @Method(0x80b9b2c)
  public static void FUN_80b9b2c() {
    // no-op
  }

  @Method(0x80b9b30)
  public static int FUN_80b9b30(final BattleStruct82c.Turn10 turn, final int r1) {
    final int unitId = turn.unitId_00.get();
    if(unitId == 0xff) {
      return 0;
    }

    //LAB_80b9b50
    final Unit14c unit = getUnit_(unitId);
    if(unit.hp_38.get() == 0) {
      return -1;
    }

    //LAB_80b9b62
    if(unit.class_129.get() == 0) {
      FUN_80bd424(turn, 1);
    }

    //LAB_80b9b74
    final int r7 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    final BattleStruct82c r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final Camera4c r5 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    MEMORY.ref(4, r7 + 0x4).setu(60);
    MEMORY.ref(4, r7 + 0x14).setu(0);
    r6._644.set(0x10000);
    initMatrixStack();
    FUN_80051d8(r5._00, r5._0c);
    FUN_8005258(0x1fe0000, (int)MEMORY.call(0x300013c, 0x1fe0000, 0xc000), 0x7fff0000);

    if(r1 != 0) {
      MEMORY.ref(4, r7).setu(0x2000);
      sleep(r1);
    }

    //LAB_80b9bce
    CPU.sp().value -= 0x20;
    final int r0_0 = CPU.sp().value + 0x1c;
    MEMORY.ref(2, r0_0).setu(turn.unitId_00.get());
    MEMORY.ref(2, r0_0 + 0x2).setu(0xff);
    FUN_80c10e8(r0_0, 1);
    CPU.sp().value += 0x20;

    int r9 = 0;
    final int r0_1 = FUN_80be378(turn, r6._654);
    if(r0_1 != 0) {
      //LAB_80b9c9c
      if(r0_1 == -1) {
        FUN_80bb65c();
        sleep(3);
      }

      //LAB_80b9cae
      FUN_80c10e8(0, 0);
    } else {
      switch(r6._654._54.get() - 1) {
        case 0 ->
          //LAB_80b9c28
          FUN_80ba27c(r6._654);
        case 1 ->
          //LAB_80b9c34
          FUN_80ba2c0(r6._654, 0);
        case 4 ->
          //LAB_80b9c40
          FUN_80b9ec0(r6._654, 1);
        case 8 ->
          //LAB_80b9c4c
          FUN_80b9ec0(r6._654, 0);
        case 2 ->
          //LAB_80b9c58
          FUN_80ba978(r6._654, 0);
        case 5 ->
          //LAB_80b9c5e
          FUN_80ba978(r6._654, 1);
        case 7 ->
          //LAB_80b9c6a
          FUN_80ba978(r6._654, 2);
        case 3 ->
          //LAB_80b9c76
          FUN_80ba6ac(r6._654, 0, turn);
        case 6 -> {
          //LAB_80b9c84
          if(FUN_80b9dc4(r6._654) != 0) {
            r9 = 1;
          }

          //LAB_80b9c94
          if(r9 != 0) {
            FUN_80c0774(2, boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new).backgroundPointerTableId_648.get(), 0);
            return r9;
          }
        }
      }
    }

    //LAB_80b9cb6
    FUN_80b7e7c();
    FUN_80bfba4(r6._654);
    loadAllUnitSpritesAndSetAnimations();
    final int[] unitIds = new int[15];
    final int unitCount = getUnitIds(0x3, unitIds);

    //LAB_80b9cd8
    for(int i = 0; i < unitCount; i++) {
      FUN_80b8000(unitIds[i]);
    }

    //LAB_80b9ce6
    turn.unitId_00.set(0xff);
    FUN_80c0774(2, boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new).backgroundPointerTableId_648.get(), 0);
    return r9;
  }

  @Method(0x80b9d34)
  public static void FUN_80b9d34(final BattleStruct82c.Sub64 r0, final int r1) {
    final int r2;
    int r4;
    int r7;
    int r8;

    r4 = 0x0;
    MEMORY.ref(4, r1 + 0x1c).setu(0);
    r2 = r0._58.get();
    MEMORY.ref(4, r1).setu(r2 & 0xfff);
    MEMORY.ref(4, r1 + 0x18).setu((r2 & 0x3000) >>> 12);
    MEMORY.ref(4, r1 + 0x8).setu(r0.unitId_00.get());
    r7 = r1 + 0x24;

    //LAB_80b9d68
    for(r8 = 0; r8 < r0._01.get(); r8++) {
      if(getUnit_(r0._02.get(r8).get()).hp_38.get() != 0 || (r0._58.get() & 0x10000) != 0) {
        //LAB_80b9d8a
        MEMORY.ref(2, r7).setu(r0._02.get(r8).get());
        r4 = r4 + 0x1;
        r7 = r7 + 0x2;
      }

      //LAB_80b9d92
    }

    //LAB_80b9da0
    if(r4 == 0) {
      MEMORY.ref(2, r1 + 0x24).setu(r0._02.get(0).get());
      r4 = 0x1;
    }

    //LAB_80b9daa
    MEMORY.ref(4, r1 + 0xc).setu(r0._02.get(0).get());
    MEMORY.ref(4, r1 + 0x14).setu(r4);
    MEMORY.ref(4, r1 + 0x10).setu(1);
  }

  @Method(0x80b9dc4)
  public static int FUN_80b9dc4(final BattleStruct82c.Sub64 r0) {
    final int r1 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    final BattleStruct82c r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    MEMORY.ref(4, r1).setu(0x2000);
    MEMORY.ref(4, r1 + 0x10).setu(1);
    FUN_80c10e8(0, 0);
    int r7 = 0;
    if(r0.unitId_00.get() < 8) {
      //LAB_80b9e00
      if(r6._45.get() == 2) {
        FUN_80151c8(0x847);
        FUN_80bb65c();
      } else {
        //LAB_80b9e10
        final int[] unitIds = new int[5];
        int unitSlot = getLivingUnitIds(0x1, unitIds) - 1;

        //LAB_80b9e26
        while(unitSlot >= 0) {
          final Unit14c unit = getUnit_(unitIds[unitSlot]);
          if(unit._13b.get() == 0 && unit._13c.get() == 0) {
            FUN_80b8064(unitIds[unitSlot]);
            sleep(8);
          }

          //LAB_80b9e4e
          unitSlot--;
        }

        //LAB_80b9e5a
        sleep(22);
        r7 = 0x1;
      }
      //LAB_80b9e64
    } else if(rand() * 10 >>> 16 < 7) {
      FUN_80b8064(r0.unitId_00.get());
      sleep(8);
      FUN_80bac6c(r0.unitId_00.get());
      FUN_80b7e60(r0.unitId_00.get());
    } else {
      //LAB_80b9e96
      FUN_80151c8(0x847);
      FUN_80bb65c();
    }

    //LAB_80b9ea0
    MEMORY.ref(4, r1 + 0x10).setu(0);
    return r7;
  }

  @Method(0x80b9ec0)
  public static void FUN_80b9ec0(final BattleStruct82c.Sub64 r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  /** While fighting mushrooms in Sol Sanctum */
  @Method(0x80ba27c)
  public static void FUN_80ba27c(final BattleStruct82c.Sub64 r0) {
    FUN_80c10e8(0, 0);

    if(r0._01.get() == 0) {
      FUN_80bb65c();
    } else {
      //LAB_80ba296
      //LAB_80ba29c
      for(int r5 = 0; r5 < r0._01.get(); r5++) {
        FUN_80bbb0c(r0, r5);
        FUN_80bb938();
      }
    }

    //LAB_80ba2b2
    sleep(1);
  }

  @Method(0x80ba2c0)
  public static int FUN_80ba2c0(final BattleStruct82c.Sub64 r0_0, int r1) {
    int r2;
    int r3;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x6c;
    r3 = 0x3001f00;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    final Actor70 actor = getCombatantForUnit(r0_0.unitId_00.get()).actor_00.deref();
    int r0 = atan2(actor.pos_08.getX(), actor.pos_08.getZ());
    r0 = r0 << 16;
    r0 = r0 >>> 16;
    r2 = r0 - 0x2000;
    r3 = r0_0.unitId_00.get();
    if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
      r3 = 0xc0;
      r3 = r3 << 7;
      r2 = r0 + r3;
    }

    //LAB_80ba300
    r3 = 0x7fff;
    r1 = 0xffffe000;
    r2 = r2 & r3;
    r3 = r2 + r1;
    r2 = r3 >>> 31;
    r3 = r3 + r2;
    r1 = 0x80;
    r3 = r3 >> 1;
    r1 = r1 << 6;
    r2 = r3 + r1;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r3 = MEMORY.ref(4, r1).get();
    if(r3 == r2) {
      MEMORY.ref(4, r1).setu(r2);
      r0 = 0x5;
      sleep(r0);
    } else {
      //LAB_80ba326
      r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r0 = 0xa;
      MEMORY.ref(4, r3).setu(r2);
      sleep(r0);
    }

    //LAB_80ba330
    r0 = 0x0;
    r1 = 0x0;
    FUN_80c10e8(r0, r1);
    final int r7 = CPU.sp().value + 0x18;
    r1 = r7;
    FUN_80b9d34(r0_0, r1);
    r3 = MEMORY.ref(4, r7).get();
    if(r3 == 0x87) {
      FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get() & ~0x1);
    }

    //LAB_80ba35a
    final Unit14c r5 = getUnit_(MEMORY.ref(4, r7 + 0x8).get());
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0_0._2c.get(0).get());
    final int r6;
    if(r0_0._1e.get(0).get() == 0) {
      r6 = 0x1;
    } else {
      r6 = 0x0;
    }

    //LAB_80ba384
    CPU.r9().value = FUN_8009260(getActorSprite(getCombatantForUnit(r0_0.unitId_00.get()).actor_00.deref(), 0).layers_28.get(0).deref().spriteDataIndex_00.get(), 2, 1);
    r3 = FUN_80c2410(r5.id_128.get()) << 16;
    FUN_80b82c4(MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(2, r7 + 0x24).get(), CPU.r9().value, r3);
    FUN_8009088(getCombatantForUnit(MEMORY.ref(4, r7 + 0x8).get()).actor_00.deref(), 16);

    if(MEMORY.ref(2, r7 + 0x24).getUnsigned() < 8) {
      r3 = 0x1;
    } else {
      //LAB_80ba3f0
      r3 = 0x0;
    }

    //LAB_80ba3f2
    MEMORY.ref(4, r7 + 0x4).setu(r3);
    r1 = 0xf0;
    r3 = 0x4000040;
    r2 = 0x1088;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 - 0x2;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r2 = 0x4000048;
    r3 = 0x3537;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f21;
    r2 = r2 + 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r1 = 0x80;
    r1 = r1 << 19;
    r3 = MEMORY.ref(2, r1).getUnsigned();
    r2 = 0x6000;
    r3 = r3 | r2;
    MEMORY.ref(2, r1).setu(r3);

    //LAB_80ba440
    if(r6 != 0) {
      r0 = 0xa;
      sleep(r0);
      r1 = 0x24;
      r0 = MEMORY.ref(2, r7 + r1).get();
      FUN_80b8178(r0);
      r0 = 0x2;
      sleep(r0);
      r0 = 0x4;
      sleep(r0);
      r0 = 0xa;
      sleep(r0);
      r0 = 0x0;
      r1 = r0_0._02.get(0).get();
      FUN_80bbabc(r0, r1);
      r1 = 0x853;
      r0 = 0x4;
      FUN_80bbabc(r0, r1);
      FUN_80bb938();
      r3 = 0x24;
      r0 = MEMORY.ref(2, r7 + r3).get();
      FUN_80b8000(r0);
    } else {
      //LAB_80ba484
      r1 = 0x0;
      MEMORY.ref(4, CPU.sp().value).setu(r1);
      MEMORY.ref(4, r7 + 0x1c).setu(r1);
      r3 = r0_0._58.get();
      if(r3 != 0) {
        r3 = 0x1;
        MEMORY.ref(4, r7 + 0x1c).setu(r3);
      }

      //LAB_80ba496
      r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      if(r3 != 0) {
        r3 = MEMORY.ref(4, r7).get();
        r3 = r3 + 0xc8;
        MEMORY.ref(4, r7).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        MEMORY.ref(4, CPU.sp().value).setu(1);
        MEMORY.ref(4, r2 + 0x14).setu(1);
        final int[] ids = new int[3];
        ids[0] = MEMORY.ref(4, r7 + 0x8).get();
        ids[1] = MEMORY.ref(4, r7 + 0xc).get();
        ids[2] = 0xff;
        loadUnitSprites(ids, 0);
      }

      //LAB_80ba4be
      r3 = 0x8;
      r3 = -r3;
      CPU.r9().value = CPU.r9().value + r3;
      r1 = CPU.r9().value;
      if(r1 <= 0) {
        r2 = 0x1;
        CPU.r9().value = r2;
      }

      //LAB_80ba4ce
      r3 = 0x0;
      r1 = CPU.r9().value;
      CPU.r11().value = r3;
      if(r1 != 0) {
        CPU.r8().value = r7;
        CPU.r10().value = r3;

        //LAB_80ba4dc
        do {
          if(MEMORY.ref(4, CPU.sp().value).get() != 0) {
            FUN_80c0df4(MEMORY.ref(4, CPU.r8().value + 0x8).get(), MEMORY.ref(4, CPU.r8().value + 0xc).get(), divideS(CPU.r10().value, CPU.r9().value) + 100);
          }

          //LAB_80ba4fc
          sleep(1);
          r2 = 0x1;
          r1 = 0x1e;
          CPU.r11().value = CPU.r11().value + r2;
          CPU.r10().value = CPU.r10().value + r1;
        } while(CPU.r11().value != CPU.r9().value);
      }

      //LAB_80ba50e
      setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80bd898"), 0xc80);
      r3 = MEMORY.ref(4, r7).get();
      if(r3 != 0) {
        r3 = r0_0._58.get() & 0x4000;
        if(r3 != 0) {
          r0 = r7;
          FUN_80c9008(r0);
        } else {
          //LAB_80ba534
          r0 = r7;
          FUN_80c9018(r0);
        }
      }

      //LAB_80ba53a
      FUN_80be02c();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      if(r2 != 0) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = 0x0;
        MEMORY.ref(4, r1 + 0x14).setu(r3);
        loadAllUnitSprites();
        r0 = 0x0;
        r1 = 0x0;
        r2 = 0x0;
        r3 = 0x64;
        FUN_80c0cec(r0, r1, r2, r3);
      }

      //LAB_80ba55a
      r2 = 0x24;
      r0 = MEMORY.ref(2, r7 + r2).get();
      FUN_80b8000(r0);
    }

    //LAB_80ba562
    r0 = MEMORY.ref(4, r7 + 0x8).get();
    FUN_80b8000(r0);
    r0 = 0x0;
    CPU.sp().value += 0x6c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80ba6ac)
  public static void FUN_80ba6ac(final BattleStruct82c.Sub64 r0, final int r1, final BattleStruct82c.Turn10 turn) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80ba918)
  public static void FUN_80ba918(final Actor70 r0, final int r1) {
    //LAB_80ba95e
    for(int r6 = 0; ; r6++) {
      final Sprite38 sprite = getActorSprite(r0, r6);
      if(sprite == null) {
        break;
      }

      //LAB_80ba92c
      SpriteLayer18 r2 = sprite.layers_28.get(0).deref();
      r2._16.or(0xff);
      r2._05.set(r1);

      //LAB_80ba94c
      for(int i = 0; i < sprite.layerCount_27.get() - 1; i++) {
        r2 = sprite.layers_28.get(i + 1).deref();
        r2._16.or(0xff);
        r2._05.set(0);
      }

      //LAB_80ba95c
    }
  }

  @Method(0x80ba978)
  public static int FUN_80ba978(final BattleStruct82c.Sub64 r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.push(CPU.r10().value);
    r3 = 0x3001f00;
    r5 = MEMORY.ref(4, r3).get();
    r2 = 0x80;
    r3 = r0._58.get();
    r2 = r2 << 11;
    r3 = r3 & r2;
    CPU.sp().value -= 0x58;
    CPU.r10().value = r1;
    if(r3 != 0) {
      r3 = r0.unitId_00.get();
      r2 = 0xffffe000;
      if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
        r2 = 0xa0;
        r2 = r2 << 7;
      }

      //LAB_80ba9a2
      MEMORY.ref(4, r5).setu(r2);
      MEMORY.ref(4, r5 + 0x4).setu(60);
    } else {
      //LAB_80ba9aa
      final Actor70 actor = getCombatantForUnit(r0.unitId_00.get()).actor_00.deref();
      final int angle = atan2(actor.pos_08.getX(), actor.pos_08.getZ()) & 0xffff;
      r4 = r0.unitId_00.get();
      if((r4 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
        r1 = angle + 0x1800;
      } else {
        r1 = angle - 0x1800;
      }

      //LAB_80ba9d0
      r3 = r1 << 16;
      r1 = r3 >> 16;
      r3 = r4;
      if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
        r3 = 0x2000;
      } else {
        //LAB_80ba9e0
        r3 = -0x2000;
      }

      //LAB_80ba9e2
      r3 = r3 - r1;
      r2 = r3 << 1;
      r2 = r2 + r3;
      if(r2 < 0) {
        r2 = r2 + 0x3;
      }

      //LAB_80ba9ee
      r3 = r2 >> 2;
      r1 = r1 + r3;
      r3 = r0._02.get(0).get();
      r2 = r4;
      if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
        r3 = 0x0;
        if((r2 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
          r3 = 0x1;
        }

        //LAB_80baa02
        if(r3 != 0) {
          r1 = 0x90;
          r3 = r4;
          r1 = r1 << 6;
          if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
            r1 = 0xffffdc00;
          }
        }
      } else {
        //LAB_80baa08
        r3 = 0x0;
        if((r2 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
          r3 = 0x1;
        }

        //LAB_80baa10
        if(r3 != 0) {
          //LAB_80baa14
          r1 = 0x90;
          r3 = r4;
          r1 = r1 << 6;
          if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
            r1 = 0xffffdc00;
          }
        }
      }

      //LAB_80baa20
      r3 = MEMORY.ref(4, r5).get();
      if(r3 != r1) {
        MEMORY.ref(4, r5).setu(r1);
      }
    }

    //LAB_80baa28
    r3 = r0._58.get();
    r2 = 0x80;
    r2 = r2 << 12;
    r3 = r3 & r2;
    if(r3 != 0) {
      r3 = r0.unitId_00.get();
      r2 = 0xffffe000;
      if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
        r2 = 0x2000;
      }

      //LAB_80baa40
      MEMORY.ref(4, r5).setu(r2);
      MEMORY.ref(4, r5 + 0x4).setu(60);
    }

    //LAB_80baa46
    r5 = CPU.sp().value + 0x4;
    FUN_80b9d34(r0, r5);
    r6 = CPU.r10().value;
    r3 = 0x1;
    r6 = r6 & r3;
    if(r6 != 0) {
      MEMORY.ref(4, r5 + 0x1c).setu(r3);
    }

    //LAB_80baa5c
    FUN_80c10e8(0, 0);
    FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get() & ~0x1);
    final Actor70 r8 = getCombatantForUnit(MEMORY.ref(4, r5 + 0x8).get()).actor_00.deref();
    setActorAnimation_(r8, 3);
    FUN_8009088(r8, 16);
    playSound_(0x9a);

    if((CPU.r10().value & 0x2) != 0) {
      FUN_80c1798(MEMORY.ref(4, r5 + 0x8).get(), r0.element_50.get(), 1, 0);
      //LAB_80baaac
    } else if(r6 == 0) {
      FUN_80c1798(MEMORY.ref(4, r5 + 0x8).get(), r0.element_50.get(), 0, 0);
    }

    //LAB_80baabc
    r3 = r0._02.get(0).get();
    if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
      r3 = 0x1;
    } else {
      //LAB_80baac6
      r3 = 0x0;
    }

    //LAB_80baac8
    MEMORY.ref(4, r5 + 0x4).setu(r3);
    r3 = MEMORY.ref(4, r5 + 0x14).get();
    r4 = 0x0;
    r2 = r5;
    if(r3 != 0) {
      r6 = 0x0;

      //LAB_80baad6
      do {
        r3 = r4 << 1;
        r3 = r3 + 0x24;
        final Sprite38 sprite = getActorSprite(getCombatantForUnit(MEMORY.ref(2, r2 + r3).get()).actor_00.deref(), 0);
        r3 = sprite.layerCount_27.get();
        r3 = r3 - 0x1;
        r1 = 0x0;
        if(r3 != 0) {
          CPU.r12().value = r3;
          r3 = r6 + r5;
          r2 = r3;
          r2 = r2 + 0x34;

          //LAB_80bab04
          do {
            MEMORY.ref(1, r2).setu(sprite.layers_28.get(r1).deref()._05.get());
            r2 = r2 + 0x1;
            r1 = r1 + 0x1;
          } while(r1 != CPU.r12().value);
        }

        //LAB_80bab12
        r3 = MEMORY.ref(4, r5 + 0x14).get();
        r4 = r4 + 0x1;
        r6 = r6 + 0x4;
        r2 = r5;
      } while(r4 != r3);
    }

    //LAB_80bab1e
    r3 = r0._5c.get();
    if(r3 != 0) {
      if(r3 == 1) {
        FUN_80bbabc(0, r0.unitId_00.get());
        FUN_80bbabc(4, 0x856);
      } else {
        //LAB_80bab3a
        FUN_80bbabc(4, 0x855);
      }

      //LAB_80bab42
      FUN_80bb938();
      FUN_80c1a14();
    } else {
      //LAB_80bab4c
      setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80bd898"), 0xc80);

      if(MEMORY.ref(4, r5).get() != 0) {
        if((r0._58.get() & 0x4000) != 0) {
          FUN_80c9008(r5);
        } else {
          //LAB_80bab70
          FUN_80c9018(r5);
        }
      } else {
        //LAB_80bab78
        FUN_80c1a14();
      }

      //LAB_80bab7c
      FUN_80be02c();
      setActorAnimation_(r8, 1);

      //LAB_80bab94
      for(r4 = 0; r4 < MEMORY.ref(4, r5 + 0x14).get(); r4++) {
        FUN_80b8000(MEMORY.ref(2, r5 + 0x24 + r4 * 0x2).get());
      }
    }

    //LAB_80babaa
    CPU.sp().value += 0x58;
    CPU.r10().value = CPU.pop();
    return 0;
  }

  @Method(0x80babdc)
  public static void FUN_80babdc(final int r0) {
    CPU.sp().value -= 0x4;
    setActorAnimation_(getCombatantForUnit(r0).actor_00.deref(), 5);
    final int r6 = CPU.sp().value;
    int r8 = 1;

    //LAB_80babfe
    do {
      MEMORY.ref(2, r6 + 0x2).setu(0xff);
      MEMORY.ref(2, r6).setu(r0);
      FUN_80152b8(r6);
      FUN_80ba918(getCombatantForUnit(r0).actor_00.deref(), 7);
      sleep(2);
      MEMORY.ref(2, r6).setu(r0);
      FUN_80152b8(r6);
      FUN_80ba918(getCombatantForUnit(r0).actor_00.deref(), FUN_80b6cd0(r0));
      sleep(2);
      r8--;
    } while(r8 >= 0);

    FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());
    CPU.sp().value += 0x4;
  }

  /** Mark a unit as dead */
  @Method(0x80bac6c)
  public static void FUN_80bac6c(final int unitId) {
    final BattleStruct82c r5 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    getUnit_(unitId)._12a.set(0);

    //LAB_80bac8a
    for(int i = 0; ; i++) {
      final int r3 = r5.charIds_58.get(i).get();
      if(r3 == unitId) {
        r5.charIds_58.get(i).set(0xfe);
        FUN_80c1ebc(unitId);

        //LAB_80bacd2
        for(int r1 = 0; r1 < 20; r1++) {
          if(r5.turns_2ec.get(r1).unitId_00.get() == unitId) {
            r5.turns_2ec.get(r1).unitId_00.set(0xff);
          }

          //LAB_80bacda
        }
        return;
      }

      //LAB_80bac9c
      if(r3 == 0xff) {
        break;
      }

      //LAB_80bac88
    }

    //LAB_80baca4
    for(int i = 0; ; i++) {
      final int r3 = r5.monsterIds_66.get(i).get();
      if(r3 == unitId) {
        r5.monsterIds_66.get(i).set(0xfe);
        FUN_80c1ebc(unitId);

        //LAB_80bacd2
        for(int r1 = 0; r1 < 20; r1++) {
          if(r5.turns_2ec.get(r1).unitId_00.get() == unitId) {
            r5.turns_2ec.get(r1).unitId_00.set(0xff);
          }

          //LAB_80bacda
        }
        return;
      }

      //LAB_80bacb6
      if(r3 == 0xff) {
        break;
      }
    }

    //LAB_80bace2
  }

  @Method(0x80bace8)
  public static void FUN_80bace8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80bad7c)
  public static int FUN_80bad7c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80bae40)
  public static int FUN_80bae40(int r0, final Ability10 ability) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r6;
    int r8;
    int r10;
    int r11;

    CPU.sp().value -= 0x5c;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
    r3 = 0x3001e74;
    r0 = 0x0;
    r1 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    r3 = ability.target_00.get();
    r8 = r0;
    if(r3 != 0) {
      //LAB_80bae66
      r2 = 0x0;
      if(r3 == 0x2 || r3 == 0x4) {
        //LAB_80bae70
        r2 = 0x1;
      }

      //LAB_80bae72
      r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      if((r3 >= 8 && r2 != 0) || (r3 < 8 && r2 == 0)) {
        //LAB_80baee8
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        r2 = r1 + 0x2;
        r3 = 0x64;
        r3 = MEMORY.ref(2, r2 + r3).get();
        CPU.r12().value = r2;
        if(r3 != 0xff) {
          r4 = r8;
          r3 = r4 << 1;
          r6 = CPU.sp().value + 0x5c;
          r3 = r3 + r6;
          r1 = r3;
          r3 = r4 << 2;
          r3 = r3 + r6;
          r4 = r3;
          r0 = 0x64;
          r1 = r1 - 0xc;
          r4 = r4 - 0x24;

          //LAB_80baf10
          do {
            r2 = MEMORY.ref(2, r2 + r0).get();
            if(r2 != 0xfe) {
              r3 = ability.target_00.get();
              if(r3 != 0x4) {
                MEMORY.ref(4, r4).setu(r2);
                r4 += 0x4;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r2 = 0x1;
                r3 = r3 | 0x180;
                MEMORY.ref(2, r1).setu(r3);
                r8 = r8 + r2;
                r1 = r1 + 0x2;
              } else {
                r6 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                if(r2 == r6) {
                  MEMORY.ref(4, r4).setu(r2);
                  r4 += 0x4;
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  r2 = 0x1;
                  r3 = r3 | 0x180;
                  MEMORY.ref(2, r1).setu(r3);
                  r8 = r8 + r2;
                  r1 = r1 + 0x2;
                }
              }
            }

            //LAB_80baf36
            r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = r3 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
            r0 = r0 + 0x2;
            r2 = CPU.r12().value;
            r3 = MEMORY.ref(2, r2 + r0).get();
          } while(r3 != 0xff);
        }
      } else {
        //LAB_80bae88
        r4 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
        r3 = 0x58;
        r3 = MEMORY.ref(2, r1 + r3).get();
        if(r3 != 0xff) {
          r0 = r8;
          r3 = r0 << 1;
          r2 = CPU.sp().value + 0x5c;
          r3 = r3 + r2;
          r4 = r8;
          r0 = r3;
          r3 = r4 << 2;
          r3 = r3 + r2;
          r4 = r3;
          r1 = r1 + 0x58;
          r0 = r0 - 0xc;
          r4 = r4 - 0x24;

          //LAB_80baeae
          do {
            r6 = 0x0;
            r2 = MEMORY.ref(2, r1 + r6).get();
            if(r2 != 0xfe) {
              r3 = ability.target_00.get();
              if(r3 != 0x4) {
                MEMORY.ref(4, r4).setu(r2);
                r4 += 0x4;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r6 = 0x1;
                r3 = r3 | 0x100;
                MEMORY.ref(2, r0).setu(r3);
                r8 = r8 + r6;
                r0 = r0 + 0x2;
              } else {
                r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                if(r2 == r3) {
                  MEMORY.ref(4, r4).setu(r2);
                  r4 += 0x4;
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  r6 = 0x1;
                  r3 = r3 | 0x100;
                  MEMORY.ref(2, r0).setu(r3);
                  r8 = r8 + r6;
                  r0 = r0 + 0x2;
                }
              }
            }

            //LAB_80baed6
            r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r2 = r2 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
            r1 = r1 + 0x2;
            r6 = 0x0;
            r3 = MEMORY.ref(2, r1 + r6).get();
          } while(r3 != 0xff);
        }
      }
    }

    //LAB_80baf46
    r0 = r8;
    if(r0 == 0) {
      r0 = 0x2;
      r0 = -r0;
    } else {
      //LAB_80baf52
      r1 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
      if(r1 < r8) {
        //LAB_80baf5c
        r2 = CPU.sp().value + 0x38;
        r10 = r2;

        //LAB_80baf60
        do {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          final int r9 = r3 * 0x4;
          final Unit14c r5 = getUnit_(MEMORY.ref(4, r10 + r9).get());
          r0 = ability.effect_03.get();
          r6 = 0x0;

          //LAB_80baf7a
          switch(r0) {
            case 6: // switch 80baf84
            case 7: // switch 80baf84
              //LAB_80bb088
              if(r5._133.get() + 1 <= 4) {
                //LAB_80bb098
                r6 = 0x1;
              }

              //LAB_80bb09a
              if(r5._132.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 8: // switch 80baf84
            case 9: // switch 80baf84
              //LAB_80bb0ac
              if(r5._133.get() - 1 >= -4) {
                r6 = 0x1;
              }
              if(r5._132.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 10: // switch 80baf84
            case 11: // switch 80baf84
              //LAB_80bb0c2
              if(r5._135.get() + 1 <= 0x4) {
                r6 = 0x1;
              }
              if(r5._134.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 12: // switch 80baf84
            case 13: // switch 80baf84
              //LAB_80bb0dc
              if(r5._135.get() - 1 >= -4) {
                r6 = 0x1;
              }

              //LAB_80bb0f2
              if(r5._134.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 14: // switch 80baf84
            case 15: // switch 80baf84
              //LAB_80bb0fa
              if(r5._137.get() + 1 <= 0x4) {
                r6 = 0x1;
              }

              //LAB_80bb10c
              if(r5._136.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 16: // switch 80baf84
            case 17: // switch 80baf84
              //LAB_80bb114
              if(r5._137.get() - 1 >= -4) {
                r6 = 0x1;
              }

              //LAB_80bb12a
              if(r5._136.get() == 0x1) {
                //LAB_80bb0a8
                r6 = r6 + 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 3: // switch 80baf84
              //LAB_80bb132
              if(r5.affliction_131.get() != 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 4: // switch 80baf84
              //LAB_80bb146
              if(r5._138.get() != 0) {
                r6 = 0x1;
              }

              //LAB_80bb154
              if(r5._139.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb160
              if(r5._13a.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb16e
              if(r5._13c.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb17c
              if(r5._13d.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb188
              //LAB_80bb18e
              if(r5._141.get() != 0) {
                //LAB_80bb194
                r6 = r6 + 0x1;
              }

              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 61: // switch 80baf84
            case 62: // switch 80baf84
              //LAB_80bb198
              if(r5.hp_38.get() < r5.maxHp_34.get()) {
                //LAB_80bb1a8
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 33: // switch 80baf84
              //LAB_80bb1ac
              if(r5._133.get() > 0) {
                r6 = 0x1;
              }

              //LAB_80bb1bc
              if(r5._135.get() > 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb1cc
              if(r5._137.get() > 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb1dc
              if(r5.summonBoosts_12c.get(0).get() > 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb1ee
              if(r5.summonBoosts_12c.get(1).get() > 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb1fe
              if(r5.summonBoosts_12c.get(2).get() > 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb210
              if(r5.summonBoosts_12c.get(3).get() > 0) {
                r6 = r6 + 0x1;
              }

              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 64: // switch 80baf84
              //LAB_80bb222
              if(r5._138.get() != 0) {
                r6 = 0x1;
              }

              //LAB_80bb230
              if(r5._139.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb23c
              if(r5._13a.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb24a
              if(r5._13c.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb258
              if(r5._13d.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb264
              if(r5._141.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb270
              if(r5.haunt_140.get() != 0) {
                r6 = r6 + 0x1;
              }

              //LAB_80bb27e
              if(r5.affliction_131.get() != 0) {
                //LAB_80bb194
                r6 = r6 + 0x1;
              }

              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 28: // switch 80baf84
              //LAB_80bb28a
              if(r5._141.get() == 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 18: // switch 80baf84
              //LAB_80bb290
              if(r5.affliction_131.get() == 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 19: // switch 80baf84
              //LAB_80bb29c
              if(r5.affliction_131.get() <= 0x1) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 23: // switch 80baf84
              //LAB_80bb2ac
              if(r5._13b.get() == 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 24: // switch 80baf84
              //LAB_80bb2b2
              if(r5._13c.get() == 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 26: // switch 80baf84
              //LAB_80bb2ba
              //LAB_80bb2c2
              if(r5.haunt_140.get() == 0) {
                r6 = 0x1;
              }
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            case 5: // switch 80baf84
            case 56: // switch 80baf84
            case 57: // switch 80baf84
              //LAB_80bb2c8
              if(r5.hp_38.get() == 0) {
                if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                  r6 = 0x0;
                } else {
                  r6 = 0x64;
                }
              }
              break;

            case 0: // switch 80baf84
            case 1: // switch 80baf84
            case 2: // switch 80baf84
              //LAB_80bb304
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              }
              break;

            default:
              //LAB_80bb142
              if(r5.hp_38.get() == 0 && doesAbilityRevive_(r0) == 0) {
                r6 = 0x0;
              } else {
                r6 = 0x1;
              }
              break;
          }

          //LAB_80bb316
          if(r6 != 0) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            r4 = r10;
            r3 = MEMORY.ref(4, r4 + r9).get();
            r1 = r2 << 2;
            MEMORY.ref(4, r4 + r1).setu(r3);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r2 = CPU.sp().value + 0x50;
            r3 = r4 << 1;
            r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r0 = CPU.sp().value;
            r0 = r0 + 0x20;
            MEMORY.ref(4, r0 + r1).setu(r3);
            r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            r6 = r6 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r6);
          } else {
            r2 = ability.flags_01.get();
            r3 = 0xf;
            r3 = r3 & r2;
            r3 = r3 - 0x1;

            switch(r3) {
              case 2: // switch 80bb330
              case 3: // switch 80bb330
                //LAB_80bb358
                if(r5.hp_38.get() != 0) {
                  r6 = r6 + 0x1;
                }
                break;

              case 9: // switch 80bb330
                //LAB_80bb35e
                if(r5.pp_3a.get() != 0) {
                  r6 = r6 + 0x1;
                }
                break;

              case 0: // switch 80bb330
                //LAB_80bb364
                if(r5.hp_38.get() != 0 && r5.hp_38.get() < r5.maxHp_34.get()) {
                  r6 = r6 + 0x1;
                }
                break;

              case 1: // switch 80bb330
              case 4: // switch 80bb330
              case 5: // switch 80bb330
              case 7: // switch 80bb330
              case 8: // switch 80bb330
                //LAB_80bb376
                if(ability.power_0a.get() != 0 && r5.hp_38.get() != 0) {
                  r6 = r6 + 0x1;
                }
                break;
            }

            //case 6: // switch 80bb330
            //LAB_80bb386
            if(r6 != 0) {
              r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r4 = r10;
              r3 = MEMORY.ref(4, r4 + r9).get();
              r1 = r2 << 2;
              MEMORY.ref(4, r4 + r1).setu(r3);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r2 = CPU.sp().value + 0x50;
              r3 = r4 << 1;
              r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r0 = CPU.sp().value;
              r0 = r0 + 0x20;
              MEMORY.ref(4, r0 + r1).setu(r3);
              r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r6 = r6 + 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r6);
            }
          }

          //LAB_80bb3aa
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r0 = r0 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        } while(r0 < r8);
      }

      //LAB_80bb3b6
      r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      if(r1 == 0) {
        r0 = 0x1;
        r0 = -r0;
      } else {
        //LAB_80bb3c2
        r3 = ability.target_00.get();
        r2 = CPU.sp().value;
        r2 = r2 + 0x20;
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
        if(r3 != 0x1) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get() * rand() >>> 16;
        } else {
          //LAB_80bb3d0
          r3 = ability.range_08.get();
          if(r3 != 0x1) {
            //LAB_80bb54a
            r2 = CPU.sp().value;
            r2 = r2 + 0x20;
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get() * rand() >>> 16;
          } else {
            //LAB_80bb3d8
            r3 = getEnemyStats_(getUnit_(MEMORY.ref(4, CPU.sp().value + 0x1c).get()).id_128.get()).iq_35.get();
            if(r3 == 0x2) {
              //LAB_80bb552
              r3 = CPU.sp().value;
              r3 = r3 + 0x20;
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get() * rand() >>> 16;
            } else {
              //LAB_80bb3f6
              r2 = ability.flags_01.get();
              r3 = 0xf;
              r3 = r3 & r2;
              r3 = r3 - 0x3;
              if((r3 & 0xffff_ffffL) > (0x2 & 0xffff_ffffL)) {
                //LAB_80bb55a
                r4 = CPU.sp().value;
                r4 = r4 + 0x20;
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get() * rand() >>> 16;
              } else {
                //LAB_80bb404
                r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = 0x1;
                r4 = 0x0;
                r1 = -r1;
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
                if(r4 < r6) {
                  r0 = CPU.sp().value;
                  r0 = r0 + 0x20;
                  r6 = r6 - 0x1;
                  MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r6);

                  //LAB_80bb41c
                  do {
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    if(r2 < r3) {
                      r4 = CPU.sp().value;
                      r3 = r2 << 2;
                      r4 = r4 + 0x38;
                      r6 = r3 + r4;
                      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
                      r0 = r3 + 0x4;
                      int r5_0 = r3;
                      r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                      r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                      int r7_0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                      r10 = r0;
                      r3 = r3 - r4;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
                      final int r9_0 = r2;
                      r11 = r3;
                      r7_0 = r7_0 + r10;

                      //LAB_80bb446
                      do {
                        r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                        MEMORY.ref(4, CPU.sp().value).setu(r1);
                        final Unit14c r8_0 = getUnit_(MEMORY.ref(4, r5_0 + r6).get());
                        final Unit14c r6_0 = getUnit_(MEMORY.ref(4, r7_0).get());
                        r3 = getEnemyStats_(getUnit_(MEMORY.ref(4, CPU.sp().value + 0x1c).get()).id_128.get()).iq_35.get();
                        r1 = MEMORY.ref(4, CPU.sp().value).get();
                        if(r3 == 0) {
                          r3 = r8_0.hp_38.get();
                          r0 = r6_0.hp_38.get();
                        } else {
                          //LAB_80bb484
                          r3 = r8_0.maxHp_34.get();
                          r0 = r6_0.maxHp_34.get();
                        }

                        //LAB_80bb48e
                        if(r3 < r0) {
                          r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                          r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                          r2 = MEMORY.ref(4, r5_0 + r3).get();
                          r3 = MEMORY.ref(4, r7_0).get();
                          MEMORY.ref(4, r4).setu(r3);
                          MEMORY.ref(4, r7_0).setu(r2);
                          r2 = MEMORY.ref(4, r9_0 + r5_0).get();
                          r3 = MEMORY.ref(4, r9_0 + r10).get();
                          MEMORY.ref(4, r9_0 + r5_0).setu(r3);
                          MEMORY.ref(4, r9_0 + r10).setu(r2);
                        }

                        //LAB_80bb4aa
                        MEMORY.ref(4, CPU.sp().value + 0x4).addu(0x4);
                        r7_0 += 0x4;
                        r5_0 += 0x4;
                        r10 += 0x4;
                        r11--;
                      } while(r11 != 0);
                    }

                    //LAB_80bb4c4
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                    r0 = r0 + 0x1;
                    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
                  } while(r0 < r2);
                } else {
                  //LAB_80bb4d2
                  r3 = CPU.sp().value;
                  r3 = r3 + 0x20;
                  MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
                }

                //LAB_80bb4d8
                r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                if(r4 == 0x2) {
                  //LAB_80bb4f4
                  r0 = rand();
                  r3 = 0xb;
                  r3 = r3 * r0;
                  r3 = r3 >>> 16;
                  r1 = 0x0;
                  CPU.cmpT(r3, 0x5);
                  if((r3 & 0xffff_ffffL) > (0x5 & 0xffff_ffffL)) {
                    r1 = 0x1;
                  }
                } else {
                  if(r4 <= 0x2) {
                    if(r4 == 0x1) {
                      r1 = 0x0;
                    }
                  } else {
                    //LAB_80bb4e8
                    r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                    if(r6 == 0x3) {
                      //LAB_80bb508
                      r0 = rand();
                      r3 = r0 << 4;
                      r3 = r3 - r0;
                      r1 = r3 >>> 16;
                      if(r1 <= 0x5) {
                        r1 = 0x0;
                      } else if(r1 > 0xa) {
                        r1 = 0x2;
                      } else {
                        r1 = 0x1;
                      }
                    } else if(r6 == 0x4) {
                      //LAB_80bb51c
                      r0 = rand();
                      r3 = r0 << 3;
                      r3 = r3 + r0;
                      r3 = r3 << 1;
                      r1 = r3 >>> 16;
                      if(r1 <= 0x5) {
                        r1 = 0x0;
                      } else {
                        //LAB_80bb530
                        if(r1 <= 0xa) {
                          r1 = 0x1;
                        } else {
                          if(r1 <= 0xe) {
                            //LAB_80bb538
                            r1 = 0x2;
                          } else {
                            //LAB_80bb53c
                            r1 = 0x3;
                          }
                        }
                      }
                    }
                  }
                }

                //LAB_80bb53e
                if(r1 < 0) {
                  //LAB_80bb560
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get() * rand() >>> 16;
                }
              }
            }
          }
        }

        r3 = r1 << 2;
        r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r0 = MEMORY.ref(4, r1 + r3).get();
      }
    }

    //LAB_80bb572
    CPU.sp().value += 0x5c;
    return r0;
  }

  @Method(0x80bb588)
  public static void FUN_80bb588(final int r0) {
    final Unit14c r1 = getUnit_(r0);

    //LAB_80bb59a
    for(int i = 0; i < 4; i++) {
      r1.summonBoosts_12c.get(i).set(0);
    }

    r1.affliction_131.set(0);
    r1._132.set(0);
    r1._133.set(0);
    r1._134.set(0);
    r1._135.set(0);
    r1._136.set(0);
    r1._137.set(0);
    r1._138.set(0);
    r1._139.set(0);
    r1._13a.set(0);
    r1._13b.set(0);
    r1._13c.set(0);
    r1._13d.set(0);
    r1._13e.set(0);
    r1._13f.set(0);
    r1.haunt_140.set(0);
    r1._141.set(0);
    r1.crit_142.set(0);
    r1.reflux_143.set(0);
    r1.kiteTurns_144.set(0);
    r1._145.set(0);
    r1._146.set(0);
    r1._147.set(0);
    r1._148.set(0);
    recalcStats_(r0);
    FUN_80b78e4(r0, getCombatantForUnit(r0));
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
      r1 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      CPU.r10().value = r1;
      CPU.r8().value = r2;
      CPU.r9().value = r3;
      queueVblankNand16_80000(GPU.WINOUT.getAddress(), 4);
      queueVblankOr16(GPU.WINOUT.getAddress(), 0x10);
      GPU.BLDALPHA.setu(0x10);
      MEMORY.ref(4, r7 + 0x4).setu(0xa400);
      MEMORY.ref(4, r7 + 0x8).setu(0);
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

  @Method(0x80bb8d8)
  public static void FUN_80bb8d8() {
    final int r2 = boardWramMallocHead_3001e50.offset(37 * 0x4).get();
    MEMORY.ref(4, r2 + 0x8).setu(1);
  }

  @Method(0x80bb8e8)
  public static void FUN_80bb8e8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80bb928)
  public static void FUN_80bb928(final int r0) {
    MEMORY.ref(4, r0 + 0x16c).or(0x1);
  }

  /** Called when first character finishes attacking and second character is about to attack */
  @Method(0x80bb938)
  public static void FUN_80bb938() {
    final int r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    final int r6 = r3 + 0x6b8;

    //LAB_80bb952
    for(int r7 = 0; r7 < MEMORY.ref(4, r3 + 0x7fc).get(); r7++) {
      //LAB_80bb95a
      final int r5;
      final int r2;
      final int r0;
      switch(MEMORY.ref(1, r6 + r7).getUnsigned()) {
        case 13: // switch 80bb964
          //LAB_80bb99c
          FUN_80bb928(r6);
          break;

        case 12: // switch 80bb964
          //LAB_80bb9aa
          FUN_80bb8e8(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get());
          break;

        case 0: // switch 80bb964
          //LAB_80bb9b6
          FUN_8015120(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get(), 1);
          break;

        case 1: // switch 80bb964
          //LAB_80bb9c4
          FUN_8015120(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get(), 5);
          break;

        case 2: // switch 80bb964
          //LAB_80bb9d2
          FUN_8015120(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get() & 0x1ff, 2);
          break;

        case 3: // switch 80bb964
          //LAB_80bb9de
          FUN_8015120(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get() & 0x3fff, 4);
          break;

        case 6: // switch 80bb964
          //LAB_80bb9f0
          r2 = MEMORY.ref(4, 0x3001ee4).get();
          MEMORY.ref(4, r2 + 0x8).setu(1);
          break;

        case 4: // switch 80bb964
          //LAB_80bb9fa
          r0 = MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get();
          if(r0 >= 0) {
            FUN_80151c8(r0);
          }

          //LAB_80bba08
          FUN_80bb65c();
          FUN_8015118();
          break;

        case 7: // switch 80bb964
          //LAB_80bba0c
          FUN_8015118();
          break;

        case 5: // switch 80bb964
          //LAB_80bba12
          r0 = MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get();
          if(r0 >= 0) {
            FUN_80151c8(r0);
          }

          FUN_8015118();
          break;

        case 8: // switch 80bb964
          //LAB_80bba22
          r0 = MEMORY.ref(4, r6 + 0x168).get();
          if(r0 > 0) {
            playSound_(r0);
          }

          //LAB_80bba32
          FUN_80babdc(MEMORY.ref(4, r6 + 0x40 + r7 * 0x4).get());
          break;

        case 9: // switch 80bb964
          //LAB_80bba42
          r5 = 0x40 + r7 * 0x4;
          FUN_80c24f0(MEMORY.ref(4, r6 + r5).get(), MEMORY.ref(4, r6 + 0x16c).get());
          FUN_80bb588(MEMORY.ref(4, r6 + r5).get());
          FUN_80bace8(MEMORY.ref(4, r6 + r5).get());
          break;

        case 10: // switch 80bb964
          //LAB_80bba62
          FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());
          break;

        case 11: // switch 80bb964
          //LAB_80bba70
          r5 = 0x40 + r7 * 0x4;
          FUN_80b78e4(MEMORY.ref(4, r6 + r5).get(), getCombatantForUnit(MEMORY.ref(4, r6 + r5).get()));
          FUN_80b7aac(MEMORY.ref(4, r6 + r5).get());
          break;
      }

      //LAB_80bba88
    }

    //LAB_80bba98
    FUN_80bdfec();
  }


  @Method(0x80bbabc)
  public static void FUN_80bbabc(final int r0, final int r1) {
    final BattleStruct82c r4 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int r2 = r4._7fc.get();
    r4._6b8.get(r2).set(r0);
    r4.unitIds_6f8.get(r2).set(r1);
    r4._7fc.incr();
  }

  @Method(0x80bbae8)
  public static int FUN_80bbae8(final int r0) {
    if(r0 == 0x3c || r0 == 0x45 || r0 == 0x1f || r0 == 0x20) {
      return 1;
    }

    return 0;
  }

  @Method(0x80bbb0c)
  public static void FUN_80bbb0c(final BattleStruct82c.Sub64 struct, int r1) {
    int r0;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0);
    r5 = 0x14c;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    final BattleStruct82c sp38 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r6 = r1;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(mallocChip(r5));
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(struct.unitId_00.get());
    r4 = struct._4c.get();
    CPU.r10().value = struct._02.get(r6).get();
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r4);
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(struct._1e.get(r6).get());
    CPU.r9().value = struct.element_50.get();
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(struct._2c.get(r6).get());
    final Ability10 ability = getAbility_(r4);
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(getUnit_(MEMORY.ref(4, CPU.sp().value + 0x44).get()).getAddress());
    r7 = getUnit_(CPU.r10().value).getAddress();
    MEMORY.call(0x3001388, MEMORY.ref(4, CPU.sp().value + 0x10).get(), r7, r5); // memcpy
    if(ability.range_08.get() != 0xff) {
      CPU.r11().value = struct._10.get(r6).get();
      if(CPU.r11().value < 0) {
        CPU.r11().value = -CPU.r11().value;
      }
    } else {
      //LAB_80bbbb0
      CPU.r11().value = 0;
    }

    //LAB_80bbbb4
    if(CPU.r9().value != 0x4) {
      r0 = MEMORY.ref(2, r7 + 0x26 + CPU.r9().value * 0x4).get();

      //LAB_80bbbd2
      for(r1 = 0; r1 < 4 && r0 >= MEMORY.ref(2, r7 + 0x24 + r1 * 0x4 + 0x2).get(); r1++) {
        //
      }

      //LAB_80bbbe2
      if(r1 == 4) {
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(-1);
      }

      //LAB_80bbbec
      //LAB_80bbbfa
      for(r1 = 0; r1 < 4 && r0 <= MEMORY.ref(2, r7 + 0x24 + r1 * 0x4 + 0x2).get(); r1++) {
        //
      }

      //LAB_80bbc0a
      if(r1 == 0x4) {
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(1);
      }
    }

    //LAB_80bbc12
    r2 = struct.element_50.get();
    if((r2 & 0xffff_ffffL) < 4) {
      if(struct._48.get() == 0x2) {
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(100);
      } else {
        r3 = r2 << 2;
        r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
        r3 = r3 + 0x48;
        r4 = MEMORY.ref(2, r4 + r3).get();
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
      }
    } else {
      //LAB_80bbc32
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(100);
    }

    //LAB_80bbc3c
    if(struct._48.get() == 0x5 && (r2 & 0xffff_ffffL) < 4) {
      if(MEMORY.ref(4, CPU.sp().value + 0x14).get() > 0) {
        if((MEMORY.ref(4, CPU.sp().value + 0xc).get() - MEMORY.ref(2, r7 + 0x48 + r2 * 0x4 + 0x2).get() + 0x1e) * 0x28f > (lcgRand_() & 0xffff)) {
          FUN_80bbabc(13, 5);
        }
      }
    }

    //LAB_80bbc78
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(ability.flags_01.get() & 0xf);
    r0 = struct._3a.get(r6).get();
    if(r0 == -1) {
      r2 = 0x80c2ab8;
      r3 = ability.effect_03.get();
      r4 = CPU.r11().value;
      r2 = MEMORY.ref(1, r2 + r4).getUnsigned();
      r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      r1 = CPU.r10().value;
      r2 = CPU.r9().value;
      r0 = FUN_8077178(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    }

    //LAB_80bbca6
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r0);
    r3 = ability.effect_03.get();
    r3 = r3 + 0xce;
    r3 = r3 << 24;
    if((r3 & 0xffff_ffffL) <= 0x1000000) {
      //LAB_80bbcba
      r0 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
      r5 = MEMORY.ref(1, r0 + 0x128).getUnsigned();
      CPU.r8().value = FUN_80b7514();
      if(ability.effect_03.get() == 0x33) {
        r5 = FUN_80c1fa8(sp38.entranceId_00.get());
      }

      //LAB_80bbcdc
      if(MEMORY.ref(4, CPU.sp().value + 0x24).get() != 0 && FUN_80b6cdc(r5) != 0 && CPU.r8().value >= 0) {
        r6 = FUN_80c1df4(r5);
        if((r6 & 0x8000) != 0) {
          FUN_80c1f50(r5);
        }

        //LAB_80bbd0c
        loadEnemyUnit_(CPU.r8().value, r5, r6 & 0x7fff);
        r5 = 0;
        if(sp38.monsterIds_66.get(0).get() == 0xfe) {
          sp38.monsterIds_66.get(0).set(CPU.r8().value);
        } else {
          //LAB_80bbd40
          do {
            if(sp38.monsterIds_66.get(r5).get() == 0xff) {
              //LAB_80bbd34
              sp38.monsterIds_66.get(r5).set(CPU.r8().value);
              sp38.monsterIds_66.get(r5 + 1).set(0xff);
              break;
            }
            r5 = r5 + 0x1;
            if(r5 > 0x5) {
              break;
            }
            if(sp38.monsterIds_66.get(r5).get() == 0xfe) {
              sp38.monsterIds_66.get(r5).set(CPU.r8().value);
              break;
            }
          } while(true);
        }

        //LAB_80bbd5e
        FUN_80b7548();
        final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(CPU.r8().value);
        initCombatant(combatant, CPU.r8().value, combatant.x_0c.get() / 0x10000, combatant.z_10.get() / 0x10000);
        loadAllUnitSpritesAndSetAnimations();

        final int[] monsterIds = new int[7];
        final int monsterCount = getBattleMonsters(monsterIds);

        //LAB_80bbd9a
        for(int i = 0; i < monsterCount; i++) {
          FUN_80b8000(monsterIds[i]);
        }

        //LAB_80bbda8
        FUN_80bbabc(0, CPU.r8().value);

        if(MEMORY.ref(4, CPU.sp().value + 0x40).get() != 0x1f7) {
          r1 = 0x8f5;
        } else {
          //LAB_80bbdbc
          r1 = 0x8f3;
        }

        FUN_80bbabc(4, r1);
      } else {
        //LAB_80bbdc0
        if(MEMORY.ref(4, CPU.sp().value + 0x40).get() == 0x1f7) {
          FUN_80bbabc(4, 0x8f4);
        } else {
          //LAB_80bbdd2
          FUN_80bbabc(4, 0x8f6);
        }
      }
    }

    //LAB_80bbdda
    r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
    if(r2 != 0) {
      r2 = ability.effect_03.get();
      r3 = r2;
      if(r3 != 0x35) {
        //LAB_80bbe1e
        r3 = r2;
        if(r3 == 0x23) {
          r0 = 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x34).setu(r0);
        } else {
          //LAB_80bbe2a
          if(r3 == 0x22) {
            r1 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
          } else {
            //LAB_80bbe34
            if(r3 == 0x1b) {
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(1);
            } else {
              //LAB_80bbe6c
              if(r3 == 0x37) {
                r5 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                if(MEMORY.ref(2, r5 + 0x38).get() != 0) {
                  FUN_80bbabc(12, MEMORY.ref(4, CPU.sp().value + 0x44).get());
                }
              } else {
                //LAB_80bbe84
                if(r3 == 0x20) {
                  if(MEMORY.ref(2, r7 + 0x3a).get() != 0) {
                    MEMORY.ref(4, CPU.sp().value + 0x18).setu(10);
                  } else {
                    //LAB_80bbe96
                    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
                  }
                }
              }
            }
          }
        }
      } else {
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
        r2 = 0x0;
        if(sp38.turns_2ec.get(0).unitId_00.get() == CPU.r10().value) {
          MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
        } else {
          //LAB_80bbe02
          do {
            r2 = r2 + 0x1;
            if((r2 & 0xffff_ffffL) > (0x13 & 0xffff_ffffL)) {
              break;
            }
            if(sp38.turns_2ec.get(r2).unitId_00.get() == CPU.r10().value) {
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
              break;
            }
          } while(true);
        }
      }
    }

    //LAB_80bbe9a
    if(MEMORY.ref(4, CPU.sp().value + 0x1c).get() == 0) {
      //LAB_80bbea2
      if(MEMORY.ref(2, r7 + 0x38).get() != 0 || doesAbilityRevive_(ability.effect_03.get()) != 0) {
        //LAB_80bbeb8
        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r3 = r3 + 0x1;

        //LAB_80bbec2
        switch(r3) {
          case 5: // switch 80bbecc
          case 4: // switch 80bbecc
            //LAB_80bbf00
            r1 = MEMORY.ref(2, r7 + 0x3e).getUnsigned();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
            r6 = MEMORY.ref(2, r7 + 0x38).get();
            CPU.r11().value = r1;
            if(r2 != 0) {
              r1 = r1 >>> 1;
              CPU.r11().value = r1;
            }

            //LAB_80bbf12
            CPU.r8().value = 1;

            //LAB_80bbf16
            do {
              r4 = CPU.r9().value;
              if(r4 != 0x4) {
                r3 = r4 << 2;
                r3 = r3 + 0x48;
                r3 = r7 + r3;
                r5 = 0x2;
                r3 = MEMORY.ref(2, r3 + r5).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r3 = r0 - r3;
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
              }

              //LAB_80bbf2c
              r1 = CPU.r8().value;
              if(r1 == 0) {
                r2 = 0x0;
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r2);
              }

              //LAB_80bbf36
              r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r5 = ability.power_0a.get();
              if(r4 == 0x4) {
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r2 = 0x0;
                r0 = MEMORY.ref(2, r1 + 0x3c).getUnsigned();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                r1 = CPU.r11().value;
                r0 = FUN_8077180(r0, r1, r2, r3);
                r1 = 0xa;
                r0 = r0 * r5;
                r0 = divideS(r0, r1);
              } else {
                //LAB_80bbf58
                r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r1 = CPU.r11().value;
                r0 = MEMORY.ref(2, r2 + 0x3c).getUnsigned();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                r2 = r5;
                r0 = FUN_8077180(r0, r1, r2, r3);
              }

              //LAB_80bbf66
              r5 = r0;
              r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              r5 = r5 * r3;
              if(r4 != 0) {
                if(r4 == 0x1) {
                  r3 = r5 << 2;
                  r0 = r3 + r5;
                  if(r0 < 0) {
                    r0 = r0 + 0x3;
                  }

                  //LAB_80bbf80
                  r5 = r0 >> 2;
                } else {
                  //LAB_80bbf84
                  r3 = r5 << 1;
                  r3 = r3 + r5;
                  r2 = r3 >>> 31;
                  r3 = r3 + r2;
                  r5 = r3 >> 1;
                }

                //LAB_80bbf8e
                r0 = MEMORY.ref(1, r7 + 0xf).getUnsigned();
                r1 = 0x5;
                r0 = divideU(r0, r1);
                r0 = r0 << 24;
                r0 = r0 >>> 24;
                r0 = r5 + r0;
                r5 = r0 + 0x6;
                r0 = CPU.r8().value;
                if(r0 == 0) {
                  r1 = 0x0;
                  r0 = 0x6;
                  FUN_80bbabc(r0, r1);
                  r2 = CPU.r10().value;
                  r1 = 0x822;
                  if((r2 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                    r1 = r1 + 0x1;
                  }

                  //LAB_80bbfb6
                  r0 = 0x5;
                  FUN_80bbabc(r0, r1);
                }
              }

              //LAB_80bbfbc
              r0 = lcgRand_();
              r3 = 0x3;
              r4 = 0x12b;
              r3 = r3 & r0;
              r5 = r5 + r3;
              r3 = r7 + r4;
              r3 = MEMORY.ref(1, r3).getUnsigned();
              r3 = r3 << 24;
              r3 = r3 >> 24;
              if(r3 != 0) {
                if(r3 == 0x1) {
                  r3 = r5 >>> 31;
                  r3 = r5 + r3;
                  r5 = r3 >> 1;
                } else {
                  //LAB_80bbfe0
                  r0 = r5;
                  r1 = 0xa;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                }
              }

              //LAB_80bbfea
              if(r5 <= 0) {
                r5 = 0x1;
              }

              //LAB_80bbff0
              r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
              if(r0 != 0) {
                r3 = r6 - 0x1;
                if(r5 < r3) {
                  r5 = r3;
                  if(r5 <= 0) {
                    r5 = 0x1;
                  }
                }
              }

              //LAB_80bc004
              r0 = 0xb7;
              r0 = r0 << 1;
              r0 = readFlag_(r0);
              if(r0 != 0) {
                r3 = struct._48.get();
                if(r3 == 0x5 && r6 <= r5) {
                  r5 = r6 - 0x1;
                }
              }

              //LAB_80bc020
              r3 = 0x1;
              CPU.r8().value = CPU.r8().value + r3;
              r4 = CPU.r8().value;
            } while(r4 < 2);

            //LAB_80bc02c
            r1 = CPU.r10().value;
            r0 = 0x8;
            FUN_80bbabc(r0, r1);
            r1 = CPU.r10().value;
            r0 = 0x0;
            FUN_80bbabc(r0, r1);
            r6 = r6 - r5;
            r1 = r5;
            r0 = 0x1;
            r5 = CPU.r10().value;
            FUN_80bbabc(r0, r1);
            if((r5 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
              r3 = 0x834;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r1 = r0 + r3;
            } else {
              //LAB_80bc054
              r3 = 0x831;
              r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r1 = r2 + r3;
            }

            //LAB_80bc05a
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            if(r6 > 0) {
              r0 = 0xb;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bc066
              r1 = CPU.r10().value;
              r0 = 0x9;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r3 = CPU.r10().value;
              r6 = 0x0;
              CPU.cmpT(r3, 0x7);
              if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
                r1 = 0x824;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bc080
                r1 = 0x825;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }
            }
            r4 = 0x38;
            r3 = MEMORY.ref(2, r7 + r4).get();
            r3 = r3 - r6;
            MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
            r0 = CPU.r10().value;
            MEMORY.ref(2, r7 + 0x38).setu(r6);
            calcHpPpFractions_(r0);
            break;

          case 11: // switch 80bbecc
            //LAB_80bc084
            r3 = ability.power_0a.get();
            if(r3 != 0) {
              //LAB_80bc08e
              r1 = CPU.r9().value;
              r0 = 0x3a;
              r6 = MEMORY.ref(2, r7 + r0).get();
              if(r1 != 0x4) {
                r3 = r1 << 2;
                r3 = r3 + 0x48;
                r3 = r7 + r3;
                r2 = 0x2;
                r3 = MEMORY.ref(2, r3 + r2).get();
                r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r3 = r4 - r3;
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
              }

              //LAB_80bc0a8
              r5 = ability.power_0a.get();
              r2 = 0x80;
              r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
              r2 = r2 << 1;
              r0 = r5;
              r0 = FUN_8077188(r0, r1, r2);
              r2 = 0x80c2ac0;
              r1 = CPU.r11().value;
              r3 = r1 << 2;
              r3 = MEMORY.ref(4, r2 + r3).get();
              r5 = r0;
              r0 = r3;
              r0 = r0 * r5;
              r1 = 0x64;
              r0 = divideS(r0, r1);
              r4 = 0x12b;
              r3 = r7 + r4;
              r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r3 = MEMORY.ref(1, r3).getUnsigned();
              r3 = r3 << 24;
              r3 = r3 >> 24;
              r5 = r0;
              r5 = r5 * r2;
              if(r3 != 0) {
                if(r3 == 0x1) {
                  r3 = r5 >>> 31;
                  r3 = r5 + r3;
                  r5 = r3 >> 1;
                } else {
                  //LAB_80bc0ec
                  r0 = r5;
                  r1 = 0xa;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                }
              }

              //LAB_80bc0f6
              r3 = ability.effect_03.get();
              if(r3 == 0x20 && r5 > r6) {
                r5 = r6;
              }

              //LAB_80bc104
              r1 = CPU.r10().value;
              r0 = 0x8;
              FUN_80bbabc(r0, r1);
              r1 = r5;
              r0 = 0x1;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              CPU.cmpT(r1, 0x7);
              if((r1 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                r1 = 0x82a;
              } else {
                //LAB_80bc126
                r1 = 0x829;
              }

              //LAB_80bc128
              r0 = 0x4;
              r6 = r6 - r5;
              FUN_80bbabc(r0, r1);
              if(r6 <= 0) {
                r6 = 0x0;
              }

              //LAB_80bc136
              r0 = 0xb;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r2 = 0x3a;
              r3 = MEMORY.ref(2, r7 + r2).get();
              r3 = r3 - r6;
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
              r0 = CPU.r10().value;
              MEMORY.ref(2, r7 + 0x3a).setu(r6);
              calcHpPpFractions_(r0);
            }
            break;

          case 2: // switch 80bbecc
            //LAB_80bc150
            r3 = ability.power_0a.get();
            if(r3 != 0) {
              //LAB_80bc15a
              r0 = CPU.r9().value;
              r5 = 0x38;
              r6 = MEMORY.ref(2, r7 + r5).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r5 = r3;
              if(r0 == 0x4) {
                r1 = 0x64;
              }

              //LAB_80bc16a
              r2 = 0x80;
              r2 = r2 << 1;
              r0 = r5;
              r0 = FUN_8077190(r0, r1, r2);
              r2 = 0x80c2ad8;
              r1 = CPU.r11().value;
              r3 = r1 << 2;
              r3 = MEMORY.ref(4, r2 + r3).get();
              r5 = r0;
              r0 = r3;
              r0 = r0 * r5;
              r1 = 0x64;
              r0 = divideS(r0, r1);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r5 = r0;
              r5 = r5 * r2;
              r0 = lcgRand_();
              r3 = 0x3;
              r3 = r3 & r0;
              r5 = r5 + r3;
              r4 = 0x34;
              r3 = MEMORY.ref(2, r7 + r4).get();
              r6 = r6 + r5;
              if(r6 > r3) {
                r6 = r3;
                r5 = 0x38;
                r3 = MEMORY.ref(2, r7 + r5).get();
                r5 = r6 - r3;
              }

              //LAB_80bc1aa
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r0 = 0x34;
              r3 = MEMORY.ref(2, r7 + r0).get();
              if(r6 == r3) {
                r1 = 0x820;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bc1c4
                r1 = r5;
                r0 = 0x1;
                FUN_80bbabc(r0, r1);
                r1 = 0x81d;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bc1d4
              r1 = 0x38;
              r3 = MEMORY.ref(2, r7 + r1).get();
              r3 = r3 - r6;
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
              r0 = CPU.r10().value;
              MEMORY.ref(2, r7 + 0x38).setu(r6);
              calcHpPpFractions_(r0);
            }
            break;

          case 0: // switch 80bbecc
            //LAB_80bc20c
            r3 = ability.power_0a.get();
            if(r3 != 0) {
              //LAB_80bc216
              r4 = CPU.r9().value;
              r3 = 0x3a;
              r6 = MEMORY.ref(2, r7 + r3).get();
              if(r4 != 0x4) {
                r3 = r4 << 2;
                r3 = r3 + 0x48;
                r3 = r7 + r3;
                r5 = 0x2;
                r3 = MEMORY.ref(2, r3 + r5).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r3 = r0 - r3;
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
              }

              //LAB_80bc230
              r5 = ability.power_0a.get();
              r2 = 0x80;
              r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
              r2 = r2 << 1;
              r0 = r5;
              r0 = FUN_8077188(r0, r1, r2);
              r2 = 0x80c2af0;
              r4 = CPU.r11().value;
              r3 = r4 << 2;
              r3 = MEMORY.ref(4, r2 + r3).get();
              r5 = r0;
              r0 = r3;
              r0 = r0 * r5;
              r1 = 0x64;
              r0 = divideS(r0, r1);
              r1 = 0x12b;
              r3 = r7 + r1;
              r5 = r0;
              r3 = MEMORY.ref(1, r3).getUnsigned();
              r3 = r3 << 24;
              r3 = r3 >> 24;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r5 = r5 * r0;
              if(r3 != 0) {
                if(r3 == 0x1) {
                  r3 = r5 >>> 31;
                  r3 = r5 + r3;
                  r5 = r3 >> 1;
                } else {
                  //LAB_80bc274
                  r0 = r5;
                  r1 = 0xa;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                }
              }

              //LAB_80bc27e
              r1 = CPU.r10().value;
              r0 = 0x8;
              FUN_80bbabc(r0, r1);
              r1 = r5;
              r0 = 0x1;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r2 = CPU.r10().value;
              CPU.cmpT(r2, 0x7);
              if((r2 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                r1 = 0x827;
              } else {
                //LAB_80bc2a0
                r1 = 0x826;
              }

              //LAB_80bc2a2
              r0 = 0x4;
              r6 = r6 - r5;
              FUN_80bbabc(r0, r1);
              if(r6 <= 0) {
                r6 = 0x0;
              }

              //LAB_80bc2b0
              r0 = 0xb;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              MEMORY.ref(2, r7 + 0x3a).setu(r6);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 6: // switch 80bbecc
          case 7: // switch 80bbecc
          case 9: // switch 80bbecc
            //LAB_80bc2ba
            r3 = ability.power_0a.get();
            if(r3 != 0) {
              //LAB_80bc2c4
              r0 = 0x1;
              r5 = 0x38;
              r6 = MEMORY.ref(2, r7 + r5).get();
              CPU.r8().value = r0;

              //LAB_80bc2cc
              do {
                r1 = CPU.r9().value;
                if(r1 != 0x4) {
                  r3 = r1 << 2;
                  r3 = r3 + 0x48;
                  r3 = r7 + r3;
                  r2 = 0x2;
                  r3 = MEMORY.ref(2, r3 + r2).get();
                  r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r3 = r4 - r3;
                  MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
                }

                //LAB_80bc2e2
                r5 = CPU.r8().value;
                if(r5 == 0) {
                  r0 = 0x0;
                  MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r0);
                }

                //LAB_80bc2ec
                r3 = struct._48.get();
                r5 = ability.power_0a.get();
                if(r3 == 0x6) {
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                  r1 = 0xfffffe84;
                  r3 = r0 + r1;

                  switch(r3) {
                    case 0: // switch 80bc30c
                    case 6: // switch 80bc30c
                    case 12: // switch 80bc30c
                    case 18: // switch 80bc30c
                      //LAB_80bc364
                      r2 = 0x3;
                      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
                      break;

                    case 1: // switch 80bc30c
                    case 7: // switch 80bc30c
                    case 13: // switch 80bc30c
                    case 19: // switch 80bc30c
                      //LAB_80bc36a
                      r3 = 0x6;
                      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
                      break;

                    case 2: // switch 80bc30c
                    case 8: // switch 80bc30c
                    case 14: // switch 80bc30c
                    case 20: // switch 80bc30c
                      //LAB_80bc370
                      r4 = 0x9;
                      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                      break;

                    case 3: // switch 80bc30c
                    case 9: // switch 80bc30c
                    case 15: // switch 80bc30c
                    case 21: // switch 80bc30c
                      //LAB_80bc376
                      r0 = 0xc;
                      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
                      break;
                  }

                  //LAB_80bc37a
                  r1 = 0x34;
                  r3 = MEMORY.ref(2, r7 + r1).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                  r1 = 0x64;
                  r0 = r2;
                  r0 = r0 * r3;
                  r0 = divideS(r0, r1);
                  r5 = r5 + r0;
                }

                //LAB_80bc38c
                r2 = 0x80;
                r0 = r5;
                r2 = r2 << 1;
                r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                r0 = FUN_8077188(r0, r1, r2);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                r5 = r0;
                r5 = r5 * r3;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                if(r3 == 0x5) {
                  //LAB_80bc3b4
                  r2 = 0x80c2b08;
                  r4 = CPU.r11().value;
                  r3 = r4 << 2;
                  r3 = MEMORY.ref(4, r2 + r3).get();
                  r1 = 0x64;
                  r0 = r3;
                  r0 = r0 * r5;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                } else if(r3 == 0x6) {
                  //LAB_80bc3c4
                  r2 = 0x80c2b38;
                  r1 = CPU.r11().value;
                  r3 = r1 << 2;
                  r3 = MEMORY.ref(4, r2 + r3).get();
                  r1 = 0x64;
                  r0 = r3;
                  r0 = r0 * r5;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                } else if(r3 == 0x8) {
                  //LAB_80bc3bc
                  r2 = 0x80c2b20;
                  r0 = CPU.r11().value;
                  r3 = r0 << 2;
                  r3 = MEMORY.ref(4, r2 + r3).get();
                  r1 = 0x64;
                  r0 = r3;
                  r0 = r0 * r5;
                  r0 = divideS(r0, r1);
                  r5 = r0;
                }

                //LAB_80bc3d8
                r0 = lcgRand_();
                r3 = 0x3;
                r2 = 0x12b;
                r3 = r3 & r0;
                r5 = r5 + r3;
                r3 = r7 + r2;
                r3 = MEMORY.ref(1, r3).getUnsigned();
                r3 = r3 << 24;
                r3 = r3 >> 24;
                if(r3 != 0) {
                  if(r3 == 0x1) {
                    r3 = r5 >>> 31;
                    r3 = r5 + r3;
                    r5 = r3 >> 1;
                  } else {
                    //LAB_80bc3fc
                    r0 = r5;
                    r1 = 0xa;
                    r0 = divideS(r0, r1);
                    r5 = r0;
                  }
                }

                //LAB_80bc406
                r0 = 0xb7;
                r0 = r0 << 1;
                r0 = readFlag_(r0);
                if(r0 != 0) {
                  r3 = struct._48.get();
                  if(r3 == 0x6 && r6 > r5) {
                    r5 = r6;
                  }
                }

                //LAB_80bc422
                r1 = 0x1;
                CPU.r8().value = CPU.r8().value + r1;
                r2 = CPU.r8().value;
              } while(r2 < 2);

              //LAB_80bc42e
              r1 = CPU.r10().value;
              r0 = 0x8;
              FUN_80bbabc(r0, r1);
              r1 = r5;
              r0 = 0x1;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r3 = CPU.r10().value;
              CPU.cmpT(r3, 0x7);
              if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                r3 = 0x834;
                r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = r4 + r3;
              } else {
                //LAB_80bc454
                r3 = 0x831;
                r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = r0 + r3;
              }

              //LAB_80bc45a
              r0 = 0x4;
              r6 = r6 - r5;
              FUN_80bbabc(r0, r1);
              if(r6 <= 0) {
                r1 = CPU.r10().value;
                r0 = 0x9;
                FUN_80bbabc(r0, r1);
                r1 = CPU.r10().value;
                r0 = 0x0;
                FUN_80bbabc(r0, r1);
                r1 = CPU.r10().value;
                r6 = 0x0;
                CPU.cmpT(r1, 0x7);
                if((r1 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                  r1 = 0x825;
                } else {
                  //LAB_80bc482
                  r1 = 0x824;
                }

                //LAB_80bc484
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bc48c
                r0 = 0xb;
                r1 = CPU.r10().value;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bc494
              r2 = 0x38;
              r3 = MEMORY.ref(2, r7 + r2).get();
              r3 = r3 - r6;
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
              r0 = CPU.r10().value;
              MEMORY.ref(2, r7 + 0x38).setu(r6);
              calcHpPpFractions_(r0);
            }
            break;

          case 12: // switch 80bbecc
            //LAB_80bc49a
            r3 = ability.power_0a.get();
            if(r3 != 0) {
              //LAB_80bc4a4
              r0 = CPU.r9().value;
              r5 = 0x3a;
              r6 = MEMORY.ref(2, r7 + r5).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r5 = r3;
              if(r0 == 0x4) {
                r1 = 0x64;
              }

              //LAB_80bc4b4
              r2 = 0x80;
              r2 = r2 << 1;
              r0 = r5;
              r0 = FUN_8077190(r0, r1, r2);
              r2 = 0x80c2b50;
              r1 = CPU.r11().value;
              r3 = r1 << 2;
              r3 = MEMORY.ref(4, r2 + r3).get();
              r5 = r0;
              r0 = r3;
              r0 = r0 * r5;
              r1 = 0x64;
              r0 = divideS(r0, r1);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r5 = r0;
              r5 = r5 * r2;
              r4 = 0x36;
              r3 = MEMORY.ref(2, r7 + r4).get();
              r6 = r6 + r5;
              if(r6 > r3) {
                r6 = r3;
                r5 = 0x3a;
                r3 = MEMORY.ref(2, r7 + r5).get();
                r5 = r6 - r3;
              }

              //LAB_80bc4ea
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
              r0 = 0x36;
              r3 = MEMORY.ref(2, r7 + r0).get();
              if(r6 == r3) {
                r1 = 0x821;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bc504
                r1 = r5;
                r0 = 0x1;
                FUN_80bbabc(r0, r1);
                r1 = 0x81e;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bc514
              MEMORY.ref(2, r7 + 0x3a).setu(r6);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 3: // switch 80bbecc
            //LAB_80bc51e
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            if(r1 != 0) {
              //LAB_80bc526
              r3 = ability.power_0a.get();
              if(r3 != 0) {
                //LAB_80bc530
                r4 = CPU.r9().value;
                r3 = 0x38;
                r6 = MEMORY.ref(2, r7 + r3).get();
                if(r4 != 0x4) {
                  r3 = r4 << 2;
                  r3 = r3 + 0x48;
                  r3 = r7 + r3;
                  r5 = 0x2;
                  r3 = MEMORY.ref(2, r3 + r5).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r3 = r0 - r3;
                  MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
                }

                //LAB_80bc54a
                r5 = ability.power_0a.get();
                r2 = 0x80;
                r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                r2 = r2 << 1;
                r0 = r5;
                r0 = FUN_8077188(r0, r1, r2);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                r5 = r0;
                r5 = r5 * r2;
                r4 = CPU.r11().value;
                r2 = 0x80c2b68;
                r3 = r4 << 2;
                r3 = MEMORY.ref(4, r2 + r3).get();
                r1 = 0x64;
                r0 = r3;
                r0 = r0 * r5;
                r0 = divideS(r0, r1);
                r5 = r0;
                r0 = 0x12b;
                r3 = r7 + r0;
                r3 = MEMORY.ref(1, r3).getUnsigned();
                r3 = r3 << 24;
                r3 = r3 >> 24;
                if(r3 != 0) {
                  if(r3 == 0x1) {
                    r3 = r5 >>> 31;
                    r3 = r5 + r3;
                    r5 = r3 >> 1;
                  } else {
                    //LAB_80bc5d4
                    r0 = r5;
                    r1 = 0xa;
                    r0 = divideS(r0, r1);
                    r5 = r0;
                  }
                }

                //LAB_80bc5de
                r1 = CPU.r10().value;
                r0 = 0x8;
                FUN_80bbabc(r0, r1);
                r1 = r5;
                r0 = 0x1;
                FUN_80bbabc(r0, r1);
                r1 = CPU.r10().value;
                r0 = 0x0;
                FUN_80bbabc(r0, r1);
                r1 = CPU.r10().value;
                CPU.cmpT(r1, 0x7);
                if((r1 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                  r1 = 0x827;
                } else {
                  //LAB_80bc600
                  r1 = 0x826;
                }

                //LAB_80bc602
                r0 = 0x4;
                r6 = r6 - r5;
                FUN_80bbabc(r0, r1);
                if(r6 <= 0) {
                  r1 = CPU.r10().value;
                  r0 = 0x9;
                  FUN_80bbabc(r0, r1);
                  r0 = 0x0;
                  r1 = CPU.r10().value;
                  FUN_80bbabc(r0, r1);
                  r2 = CPU.r10().value;
                  r6 = 0x0;
                  CPU.cmpT(r2, 0x7);
                  if((r2 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                    r1 = 0x825;
                  } else {
                    //LAB_80bc62a
                    r1 = 0x824;
                  }

                  //LAB_80bc62c
                  r0 = 0x4;
                  FUN_80bbabc(r0, r1);
                } else {
                  //LAB_80bc634
                  r0 = 0xb;
                  r1 = CPU.r10().value;
                  FUN_80bbabc(r0, r1);
                }

                //LAB_80bc63c
                r4 = 0x38;
                r3 = MEMORY.ref(2, r7 + r4).get();
                r3 = r3 - r6;
                MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
                r0 = CPU.r10().value;
                MEMORY.ref(2, r7 + 0x38).setu(r6);
                calcHpPpFractions_(r0);
              }
            } else {
              //LAB_80bc64e
              r1 = CPU.r10().value;
              r0 = 0xb;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x854;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }
            break;
        }
      }
    }

    //LAB_80bc666
    r0 = 0x0;
    r1 = CPU.r10().value;
    FUN_80bbabc(r0, r1);
    r0 = ability.effect_03.get();
    r0 = doesAbilityRevive_(r0);
    if(r0 != 0 || MEMORY.ref(2, r7 + 0x38).get() != 0 || FUN_80bbae8(ability.effect_03.get()) != 0) {
      //LAB_80bc690
      r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      if(r0 != 0) {
        //LAB_80bc69a
        r3 = ability.effect_03.get();
        r3 = r3 - 0x3;

        //LAB_80bc6a8
        switch(r3) {
          case 61: // switch 80bc6b0
            //LAB_80bc7bc
            r3 = 0x9c;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r3 = 0x0;
              r1 = 0x88b;
              MEMORY.ref(1, r2).setu(r3);
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc7dc
            r4 = 0x13b;
            r2 = r7 + r4;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r3 = 0x0;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x0;
              r0 = 0x7;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x88d;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc802
            r5 = 0x9e;
            r5 = r5 << 1;
            r3 = r7 + r5;
            r6 = 0x0;
            r0 = 0x13d;
            MEMORY.ref(1, r3).setu(r6);
            r2 = r7 + r0;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r1 = 0x88c;
              MEMORY.ref(1, r2).setu(r6);
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc828
            r1 = 0x141;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r1 = 0x894;
              MEMORY.ref(1, r2).setu(r6);
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc844
            r3 = 0xa0;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r1 = 0x88f;
              MEMORY.ref(1, r2).setu(r6);
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r0 = 0x0;
              r1 = CPU.r10().value;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc862
            r4 = 0x131;
            r5 = r7 + r4;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r5 + r3).get();
            if(r3 != 0) {
              r1 = 0x884;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              MEMORY.ref(1, r5).setu(r6);
            }

            //LAB_80bc878
            r0 = 0x7;
            r1 = 0x0;
            FUN_80bbabc(r0, r1);
            break;

          case 1: // switch 80bc6b0
            //LAB_80bc884
            r5 = 0x9c;
            r5 = r5 << 1;
            r2 = r7 + r5;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r3 = 0x0;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x0;
              r0 = 0x7;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x88b;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc8ac
            r6 = 0x13b;
            r2 = r7 + r6;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              r3 = 0x0;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x0;
              r0 = 0x7;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x88d;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc8d2
            r0 = 0x9e;
            r0 = r0 << 1;
            r3 = r7 + r0;
            r5 = 0x0;
            r1 = 0x13d;
            MEMORY.ref(1, r3).setu(r5);
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              MEMORY.ref(1, r2).setu(r5);
              r1 = 0x0;
              r0 = 0x7;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x88c;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bc900
            r3 = 0x141;
            r2 = r7 + r3;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 != 0) {
              //LAB_80bc90e
              MEMORY.ref(1, r2).setu(r5);
              r1 = 0x0;
              r0 = 0x7;
              FUN_80bbabc(r0, r1);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x894;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }
            break;

          case 58: // switch 80bc6b0
          case 59: // switch 80bc6b0
            //LAB_80bc926
            r4 = MEMORY.ref(2, r7 + 0x38).getUnsigned();
            r3 = ability.effect_03.get();
            r6 = 0x38;
            r5 = MEMORY.ref(2, r7 + r6).get();
            CPU.r8().value = r4;
            r6 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
            r0 = 0x34;
            r2 = MEMORY.ref(2, r7 + r0).get();
            if(r3 == 0x3d) {
              r0 = r2 << 4;
              r0 = r0 - r2;
              r0 = r0 << 2;
            } else {
              //LAB_80bc944
              r0 = r2 << 4;
              r0 = r0 - r2;
              r0 = r0 << 1;
            }

            //LAB_80bc94a
            r1 = 0x64;
            r0 = divideS(r0, r1);
            r5 = r5 + r0;
            r3 = r6 << 16;
            r2 = r3 >> 16;
            if(r5 > r2) {
              r5 = r2;
            }

            //LAB_80bc95c
            r4 = CPU.r8().value;
            r3 = r4 << 16;
            r3 = r3 >> 16;
            r1 = r5 - r3;
            if(r1 != 0 || MEMORY.ref(4, CPU.sp().value + 0x18).get() == 0x1) {
              //LAB_80bc972
              if(r5 == r2) {
                r1 = 0x820;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bc980
                r0 = 0x1;
                FUN_80bbabc(r0, r1);
                r1 = 0x81d;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bc98e
              MEMORY.ref(2, r7 + 0x38).setu(r5);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 60: // switch 80bc6b0
            //LAB_80bc9dc
            r1 = 0x36;
            r6 = MEMORY.ref(2, r7 + r1).get();
            r0 = 0x3a;
            r5 = MEMORY.ref(2, r7 + r0).get();
            r0 = r6 << 3;
            r0 = r0 - r6;
            r1 = 0x64;
            r0 = divideS(r0, r1);
            CPU.r8().value = r5;
            r5 = r5 + r0;
            if(r5 > r6) {
              r5 = r6;
            }

            //LAB_80bc9f8
            r2 = CPU.r8().value;
            r1 = r5 - r2;
            if(r1 != 0 || MEMORY.ref(4, CPU.sp().value + 0x18).get() == 0xb) {
              //LAB_80bca0a
              if(r5 == r6) {
                r1 = 0x821;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bca18
                r0 = 0x1;
                FUN_80bbabc(r0, r1);
                r1 = 0x81e;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bca26
              MEMORY.ref(2, r7 + 0x3a).setu(r5);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 56: // switch 80bc6b0
            //LAB_80bca2a
            r4 = 0x147;
            r5 = 0xa3;
            r2 = r7 + r4;
            r3 = 0x8;
            r5 = r5 << 1;
            MEMORY.ref(1, r2).setu(r3);
            r2 = r7 + r5;
            r3 = 0x5;
            MEMORY.ref(1, r2).setu(r3);
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r3 = r7;
            r3 = r3 + 0x40;
            r1 = MEMORY.ref(2, r3).getUnsigned();
            r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = r3 + 0x40;
            r3 = MEMORY.ref(2, r3).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x877;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            break;

          case 55: // switch 80bc6b0
            //LAB_80bca5c
            r6 = 0x147;
            r0 = 0xa3;
            r2 = r7 + r6;
            r3 = 0xfc;
            r0 = r0 << 1;
            MEMORY.ref(1, r2).setu(r3);
            r2 = r7 + r0;
            r3 = 0x5;
            MEMORY.ref(1, r2).setu(r3);
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = r3 + 0x40;
            r1 = MEMORY.ref(2, r3).getUnsigned();
            r3 = r7;
            r3 = r3 + 0x40;
            r3 = MEMORY.ref(2, r3).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x878;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            break;

          case 6: // switch 80bc6b0
            //LAB_80bca8e
            r1 = 0x133;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcaa8
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcab4
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(2, r7 + 0x3c).getUnsigned();
            r1 = MEMORY.ref(2, r5 + 0x3c).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            r6 = 0x99;
            FUN_80bbabc(r0, r1);
            r6 = r6 << 1;
            r1 = 0x860;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r6;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 5: // switch 80bc6b0
            //LAB_80bcad8
            r0 = 0x133;
            r2 = r7 + r0;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r1 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r1 = -r1;
            if(r3 < r1) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcaf2
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcafe
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(2, r7 + 0x3c).getUnsigned();
            r1 = MEMORY.ref(2, r2 + 0x3c).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x860;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r3 = 0x99;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 4: // switch 80bc6b0
            //LAB_80bcb22
            r4 = 0x133;
            r2 = r7 + r4;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r5 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r5 = -r5;
            if(r3 < r5) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcb3c
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcb48
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = MEMORY.ref(2, r7 + 0x3c).getUnsigned();
            r3 = MEMORY.ref(2, r6 + 0x3c).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x861;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x99;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 3: // switch 80bc6b0
            //LAB_80bcb68
            r1 = 0x133;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcb82
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcb8e
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = MEMORY.ref(2, r7 + 0x3c).getUnsigned();
            r3 = MEMORY.ref(2, r5 + 0x3c).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            r6 = 0x99;
            FUN_80bbabc(r0, r1);
            r6 = r6 << 1;
            r1 = 0x861;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r6;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 10: // switch 80bc6b0
            //LAB_80bcbb2
            r0 = 0x135;
            r2 = r7 + r0;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r1 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r1 = -r1;
            if(r3 < r1) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcbcc
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcbd8
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(2, r7 + 0x3e).getUnsigned();
            r1 = MEMORY.ref(2, r2 + 0x3e).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x862;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r3 = 0x9a;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 9: // switch 80bc6b0
            //LAB_80bcbfc
            r4 = 0x135;
            r2 = r7 + r4;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r5 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r5 = -r5;
            if(r3 < r5) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcc16
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcc22
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(2, r7 + 0x3e).getUnsigned();
            r1 = MEMORY.ref(2, r6 + 0x3e).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x862;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9a;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 8: // switch 80bc6b0
            //LAB_80bcc42
            r1 = 0x135;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcc5c
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcc68
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = MEMORY.ref(2, r7 + 0x3e).getUnsigned();
            r3 = MEMORY.ref(2, r5 + 0x3e).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            r6 = 0x9a;
            FUN_80bbabc(r0, r1);
            r6 = r6 << 1;
            r1 = 0x863;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r6;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 7: // switch 80bc6b0
            //LAB_80bcc8c
            r0 = 0x135;
            r2 = r7 + r0;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r1 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r1 = -r1;
            if(r3 < r1) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcca6
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bccb2
            r0 = CPU.r10().value;
            recalcStats_(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = MEMORY.ref(2, r7 + 0x3e).getUnsigned();
            r3 = MEMORY.ref(2, r2 + 0x3e).getUnsigned();
            r0 = 0x1;
            r1 = r1 - r3;
            FUN_80bbabc(r0, r1);
            r1 = 0x863;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r3 = 0x9a;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 2: // switch 80bc6b0
            //LAB_80bccd6
            r4 = 0x38;
            r3 = MEMORY.ref(2, r7 + r4).get();
            if(r3 == 0) {
              //LAB_80bcce0
              r1 = 0x864;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
              r0 = CPU.r10().value;
              MEMORY.ref(2, r7 + 0x38).setu(r3);
              calcHpPpFractions_(r0);
            }
            break;

          case 53: // switch 80bc6b0
            //LAB_80bccf4
            r5 = 0x38;
            r3 = MEMORY.ref(2, r7 + r5).get();
            if(r3 == 0) {
              //LAB_80bccfe
              r1 = 0x864;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
              r3 = r3 << 16;
              r2 = r3 >> 16;
              r3 = r3 >>> 31;
              r2 = r2 + r3;
              r2 = r2 >> 1;
              MEMORY.ref(2, r7 + 0x38).setu(r2);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 54: // switch 80bc6b0
            //LAB_80bcd16
            r6 = 0x38;
            r3 = MEMORY.ref(2, r7 + r6).get();
            if(r3 == 0) {
              //LAB_80bcd20
              r1 = 0x864;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r1 = 0x34;
              r0 = MEMORY.ref(2, r7 + r1).get();
              r1 = 0xa;
              r0 = r0 << 3;
              r0 = divideS(r0, r1);
              MEMORY.ref(2, r7 + 0x38).setu(r0);
              r0 = CPU.r10().value;
              calcHpPpFractions_(r0);
            }
            break;

          case 0: // switch 80bc6b0
            //LAB_80bcd38
            r2 = 0x131;
            r5 = r7 + r2;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r5 + r3).get();
            if(r3 != 0) {
              r1 = 0x884;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bcd4c
            r3 = 0x0;
            MEMORY.ref(1, r5).setu(r3);
            break;

          case 14: // switch 80bc6b0
            //LAB_80bcd8c
            r3 = 0x137;
            r2 = r7 + r3;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcda6
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            r1 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x4;
            }

            //LAB_80bcdb6
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r6 = 0x137;
            r3 = r5 + r6;
            r2 = 0x0;
            r2 = MEMORY.ref(1, r3 + r2).get();
            r3 = r1 << 24;
            r3 = r3 >> 24;
            r2 = r2 - r3;
            r1 = r2 << 2;
            r1 = r1 + r2;
            r1 = r1 << 2;
            r0 = 0x1;
            FUN_80bbabc(r0, r1);
            r1 = 0x865;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9b;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 13: // switch 80bc6b0
            //LAB_80bcdde
            r1 = 0x137;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 - 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bcdf8
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            r1 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x4;
            }

            //LAB_80bce08
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r6 = 0x137;
            r3 = r5 + r6;
            r2 = 0x0;
            r2 = MEMORY.ref(1, r3 + r2).get();
            r3 = r1 << 24;
            r3 = r3 >> 24;
            r2 = r2 - r3;
            r1 = r2 << 2;
            r1 = r1 + r2;
            r1 = r1 << 2;
            r0 = 0x1;
            FUN_80bbabc(r0, r1);
            r1 = 0x865;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9b;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 12: // switch 80bc6b0
            //LAB_80bce30
            r1 = 0x137;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x1;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bce4a
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            r1 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x4;
            }

            //LAB_80bce5a
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r6 = 0x137;
            r2 = r5 + r6;
            r2 = MEMORY.ref(1, r2).getUnsigned();
            r2 = r2 << 24;
            r2 = r2 >> 24;
            r3 = r1 << 24;
            r3 = r3 >> 24;
            r3 = r3 - r2;
            r1 = r3 << 2;
            r1 = r1 + r3;
            r1 = r1 << 2;
            r0 = 0x1;
            FUN_80bbabc(r0, r1);
            r1 = 0x866;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9b;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 11: // switch 80bc6b0
            //LAB_80bce84
            r1 = 0x137;
            r2 = r7 + r1;
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r3 = r3 + 0x2;
            MEMORY.ref(1, r2).setu(r3);
            r4 = 0x4;
            r3 = r3 << 24;
            r3 = r3 >> 24;
            r4 = -r4;
            if(r3 < r4) {
              r3 = 0xfc;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bce9e
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            r1 = MEMORY.ref(1, r2).getUnsigned();
            if(r3 > 0x4) {
              r3 = 0x4;
              MEMORY.ref(1, r2).setu(r3);
              r1 = 0x4;
            }

            //LAB_80bceae
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r6 = 0x137;
            r2 = r5 + r6;
            r2 = MEMORY.ref(1, r2).getUnsigned();
            r2 = r2 << 24;
            r2 = r2 >> 24;
            r3 = r1 << 24;
            r3 = r3 >> 24;
            r3 = r3 - r2;
            r1 = r3 << 2;
            r1 = r1 + r3;
            r1 = r1 << 2;
            r0 = 0x1;
            FUN_80bbabc(r0, r1);
            r1 = 0x866;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9b;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 15: // switch 80bc6b0
            //LAB_80bced8
            r1 = 0x131;
            r5 = r7 + r1;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r5 + r3).get();
            if(r3 == 0) {
              //LAB_80bcee6
              r1 = 0x867;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r3 = 0x1;
              MEMORY.ref(1, r5).setu(r3);
            }
            break;

          case 16: // switch 80bc6b0
            //LAB_80bcef4
            r2 = 0x131;
            r5 = r7 + r2;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r5 + r3).get();
            if(r3 <= 0x1) {
              //LAB_80bcf02
              r1 = 0x874;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r3 = 0x2;
              MEMORY.ref(1, r5).setu(r3);
            }
            break;

          case 17: // switch 80bc6b0
            //LAB_80bcf10
            r1 = 0x868;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r3 = 0x9c;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 18: // switch 80bc6b0
            //LAB_80bcf20
            r1 = 0x869;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r4 = 0x139;
            r3 = 0x7;
            r2 = r7 + r4;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 19: // switch 80bc6b0
            //LAB_80bcf32
            r5 = 0x9d;
            r1 = 0x86a;
            r0 = 0x4;
            r5 = r5 << 1;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r5;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 20: // switch 80bc6b0
            //LAB_80bcf42
            r6 = 0x13b;
            r1 = 0x86b;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r6;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 21: // switch 80bc6b0
            //LAB_80bcf50
            r1 = 0x86c;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9e;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          //LAB_80bcf5c
          case 22: // switch 80bc6b0
            r1 = CPU.r10().value;
            if((r1 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
              r1 = 0x86d;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bcf6c
              r1 = 0x876;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bcf74
            r2 = 0x13d;
            r1 = r7 + r2;
            r2 = MEMORY.ref(1, r1).getUnsigned();
            r3 = 0x7;
            r3 = r3 | r2;
            MEMORY.ref(1, r1).setu(r3);
            break;

          case 64: // switch 80bc6b0
            //LAB_80bcf7e
            r3 = CPU.r10().value;
            if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
              r1 = 0x86d;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bcf8e
              r1 = 0x876;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bcf96
            r4 = 0x13d;
            r1 = r7 + r4;
            r2 = MEMORY.ref(1, r1).getUnsigned();
            r3 = 0x10;
            r3 = r3 | r2;
            MEMORY.ref(1, r1).setu(r3);
            break;

          case 24: // switch 80bc6b0
            //LAB_80bcfa4
            r5 = 0x95;
            r0 = 0x9;
            r1 = CPU.r10().value;
            r5 = r5 << 1;
            FUN_80bbabc(r0, r1);
            r3 = r7 + r5;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            if(r3 == 0x2) {
              r1 = 0x84f;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bcfbc
              r6 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              if(r6 == 0xdb) {
                r1 = 0x850;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bcfcc
                r1 = 0x84c;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }
            }

            //LAB_80bcfd4
            r3 = 0x0;
            MEMORY.ref(2, r7 + 0x38).setu(r3);
            r0 = CPU.r10().value;
            calcHpPpFractions_(r0);
            break;

          case 26: // switch 80bc6b0
            //LAB_80bcfe0
            r1 = 0x86f;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x9f;
            r0 = r0 << 1;
            r2 = r7 + r0;
            r3 = 0x7;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 27: // switch 80bc6b0
            //LAB_80bcff4
            r1 = 0x870;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r1 = 0x13f;
            r3 = 0x7;
            r2 = r7 + r1;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 28: // switch 80bc6b0
          case 57: // switch 80bc6b0
            //LAB_80bd006
            r3 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r2 = 0x38;
            r6 = MEMORY.ref(2, r3 + r2).get();
            r3 = ability.effect_03.get();
            r2 = r6;
            r5 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            if(r3 == 0x3c) {
              r3 = r5 >>> 31;
              r3 = r5 + r3;
              r5 = r3 >> 1;
            }

            //LAB_80bd01e
            r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r0 = 0x34;
            r3 = MEMORY.ref(2, r1 + r0).get();
            r6 = r6 + r5;
            if(r6 > r3) {
              r6 = r3;
              r5 = r6 - r2;
            }

            //LAB_80bd02e
            r1 = 0x0;
            r0 = 0x7;
            FUN_80bbabc(r0, r1);
            r0 = 0x0;
            r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            FUN_80bbabc(r0, r1);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r2 = 0x34;
            r3 = MEMORY.ref(2, r4 + r2).get();
            if(r6 == r3) {
              r1 = 0x820;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bd052
              r1 = r5;
              r0 = 0x1;
              FUN_80bbabc(r0, r1);
              r1 = 0x81d;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bd062
            r5 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.ref(2, r5 + 0x38).setu(r6);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            calcHpPpFractions_(r0);
            break;

          case 29: // switch 80bc6b0
            //LAB_80bd068
            r0 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r6 = 0x3a;
            r5 = MEMORY.ref(2, r0 + r6).get();
            r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r1 = 0x36;
            r3 = MEMORY.ref(2, r0 + r1).get();
            r2 = r5;
            r5 = r5 + r6;
            if(r5 > r3) {
              r5 = r3;
              r6 = r5 - r2;
            }

            //LAB_80bd080
            r1 = 0x0;
            r0 = 0x7;
            FUN_80bbabc(r0, r1);
            r0 = 0x0;
            r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            FUN_80bbabc(r0, r1);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r2 = 0x36;
            r3 = MEMORY.ref(2, r4 + r2).get();
            if(r5 == r3) {
              r1 = 0x821;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            } else {
              //LAB_80bd0a4
              r1 = r6;
              r0 = 0x1;
              FUN_80bbabc(r0, r1);
              r1 = 0x81e;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }

            //LAB_80bd0b4
            r6 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.ref(2, r6 + 0x3a).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            calcHpPpFractions_(r0);
            break;

          case 66: // switch 80bc6b0
            //LAB_80bd128
            r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r1 = 0xa;
            r0 = divideS(r0, r1);
            r5 = r0;
            r0 = 0x3a;
            r3 = MEMORY.ref(2, r7 + r0).get();
            if(r3 < r5) {
              r5 = r3;
            }

            //LAB_80bd13c
            r3 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r6 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            r2 = 0x3a;
            r1 = MEMORY.ref(2, r3 + r2).get();
            r4 = 0x36;
            r2 = MEMORY.ref(2, r6 + r4).get();
            r3 = r1 + r5;
            if(r3 > r2) {
              r5 = r2 - r1;
            }

            //LAB_80bd150
            if(r5 != 0) {
              //LAB_80bd156
              r0 = 0x1;
              r1 = r5;
              FUN_80bbabc(r0, r1);
              r0 = CPU.r10().value;
              if((r0 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
                r1 = 0x85f;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              } else {
                //LAB_80bd16e
                r1 = 0x85e;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }

              //LAB_80bd176
              r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r1 = r5;
              r0 = addPp_(r0, r1);
            }
            break;

          case 30: // switch 80bc6b0
            //LAB_80bd180
            r1 = 0x133;
            r2 = r7 + r1;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0) {
              r4 = 0x99;
              r3 = 0x0;
              r4 = r4 << 1;
              MEMORY.ref(1, r2).setu(r3);
              r2 = r7 + r4;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bd198
            r5 = 0x135;
            r1 = r7 + r5;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r1 + r3).get();
            if(r3 > 0) {
              r6 = 0x9a;
              r6 = r6 << 1;
              r2 = 0x0;
              r3 = r7 + r6;
              MEMORY.ref(1, r1).setu(r2);
              MEMORY.ref(1, r3).setu(r2);
            }

            //LAB_80bd1b0
            r0 = 0x137;
            r2 = r7 + r0;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0) {
              r1 = 0x9b;
              r3 = 0x0;
              r1 = r1 << 1;
              MEMORY.ref(1, r2).setu(r3);
              r2 = r7 + r1;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bd1c8
            r3 = 0x147;
            r2 = r7 + r3;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 > 0) {
              r3 = 0x0;
              MEMORY.ref(1, r2).setu(r3);
            }

            //LAB_80bd1d8
            r4 = 0x96;
            r4 = r4 << 1;
            r5 = 0x12d;
            r2 = 0x0;
            r3 = r7 + r4;
            r6 = 0x97;
            MEMORY.ref(1, r3).setu(r2);
            r0 = 0x12f;
            r3 = r7 + r5;
            r6 = r6 << 1;
            MEMORY.ref(1, r3).setu(r2);
            r3 = r7 + r6;
            MEMORY.ref(1, r3).setu(r2);
            r3 = r7 + r0;
            MEMORY.ref(1, r3).setu(r2);
            r1 = 0x896;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            break;

          case 23: // switch 80bc6b0
            //LAB_80bd1fa
            r1 = 0x872;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r1 = 0xa0;
            r1 = r1 << 1;
            r2 = r7 + r1;
            r3 = 0x1;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 25: // switch 80bc6b0
            //LAB_80bd20a
            r2 = 0x141;
            r5 = r7 + r2;
            r3 = MEMORY.ref(1, r5).getUnsigned();
            r2 = r3;
            if(r2 == 0) {
              r1 = 0x873;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
              r3 = 0x7;
              MEMORY.ref(1, r5).setu(r3);
            } else {
              //LAB_80bd224
              if((r2 & 0xffff_ffffL) > (0x1 & 0xffff_ffffL)) {
                r3 = r3 + 0xff;
                MEMORY.ref(1, r5).setu(r3);
                r0 = 0x1;
                r1 = MEMORY.ref(1, r5).getUnsigned();
                FUN_80bbabc(r0, r1);
                r1 = 0x875;
                r0 = 0x4;
                FUN_80bbabc(r0, r1);
              }
            }
            break;

          case 63: // switch 80bc6b0
            //LAB_80bd23e
            r1 = 0x87d;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r3 = 0xa2;
            r3 = r3 << 1;
            r2 = r7 + r3;
            r3 = 0x2;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 51: // switch 80bc6b0
            //LAB_80bd24e
            r1 = 0x87e;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + 0x148;
            r5 = CPU.r10().value;
            MEMORY.ref(1, r2).setu(1);
            if((r5 & 0xffff_ffffL) < 8) {
              sp38._43.or(0x2);
            }
            break;

          case 50: // switch 80bc6b0
            //LAB_80bd274
            r6 = 0x145;
            r1 = 0x87f;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r2 = r7 + r6;
            r3 = 0x1;
            MEMORY.ref(1, r2).setu(r3);
            break;

          case 43: // switch 80bc6b0
            //LAB_80bd282
            r1 = 0x881;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r0 = 0x12b;
            r2 = r7 + r0;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 <= 0) {
              //LAB_80bd296
              r3 = 0x1;
              MEMORY.ref(1, r2).setu(r3);
            }
            break;

          case 44: // switch 80bc6b0
            //LAB_80bd29c
            r1 = 0x882;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            r1 = 0x12b;
            r2 = r7 + r1;
            r3 = 0x0;
            r3 = MEMORY.ref(1, r2 + r3).get();
            if(r3 <= 0x1) {
              //LAB_80bd2b0
              r3 = 0x2;
              MEMORY.ref(1, r2).setu(r3);
            }
            break;

          case 42: // switch 80bc6b0
            //LAB_80bd2b6
            r1 = 0x1;
            r1 = -r1;
            r0 = 0x4;
            FUN_80bbabc(r0, r1);
            break;
        }
      }
    }

    //LAB_80bd2c0
    r0 = 0x7;
    r1 = 0x0;
    FUN_80bbabc(r0, r1);
    r2 = 0x38;
    r3 = MEMORY.ref(2, r7 + r2).get();
    if(r3 != 0) {
      r3 = 0x9e;
      r3 = r3 << 1;
      r5 = r7 + r3;
      r3 = MEMORY.ref(1, r5).getUnsigned();
      if(r3 != 0) {
        if((r3 & 0xffff_ffffL) <= (0x6 & 0xffff_ffffL)) {
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          if(r4 > 0) {
            r0 = lcgRand_();
            r3 = 0x3;
            r0 = r0 & r3;
            if(r0 == 0) {
              MEMORY.ref(1, r5).setu(r0);
              r1 = CPU.r10().value;
              r0 = 0x0;
              FUN_80bbabc(r0, r1);
              r1 = 0x883;
              r0 = 0x4;
              FUN_80bbabc(r0, r1);
            }
          }
        }
      }
    }

    //LAB_80bd304
    setMallocAddress(MEMORY.ref(4, CPU.sp().value + 0x10).get());
    recalcStats_(CPU.r10().value);
    FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());

    if(MEMORY.ref(2, r7 + 0x38).get() != 0) {
      FUN_80bbabc(11, CPU.r10().value);
    }

    //LAB_80bd32c
    r6 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
    r0 = 0xa0;
    r0 = r0 << 1;
    r3 = r6 + r0;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    if(r3 != 0) {
      r0 = lcgRand_();
      r3 = 0x3;
      r0 = r0 & r3;
      if(r0 == 0) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        if(r1 > 0) {
          r0 = r1 >> 2;
          if(r0 == 0) {
            r0 = 0x1;
          }

          //LAB_80bd354
          struct._60.add(r0);
        }
      }
    }

    //LAB_80bd35c
    CPU.sp().value += 0x64;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80bd3c8)
  public static boolean abilityHasCost(final int abilityId) {
    if(abilityId == 126) {
      return true;
    }

    //LAB_80bd3d2
    return getAbility_(abilityId).cost_09.get() != 0;
  }

  @Method(0x80bd3e4)
  public static int selectAttackIndex(final ArrayRef<UnsignedByteRef> table) {
    final int rand = lcgRand_() & 0xff;
    int r2 = 0;

    //LAB_80bd404
    for(int r1 = 0; r1 < 8; r1++) {
      r2 = r2 + table.get(r1).get();
      if(r2 > rand) {
        return r1;
      }
    }

    //LAB_80bd414
    return 0;
  }

  @Method(0x80bd424)
  public static void FUN_80bd424(final BattleStruct82c.Turn10 turn, final int r1) {
    int r0;
    int r2;
    int r3;
    int r6;
    int r9;

    final Unit14c r11 = getUnit_(turn.unitId_00.get());
    int sp0c = 0;
    int sp10 = 1;
    int sp08 = 1;
    int selectedAttack = -1;
    if(r11.class_129.get() == 0) {
      //LAB_80bd45e
      if(r1 == 0 || turn._06.get() == 0x4) {
        //LAB_80bd46e
        final EnemyStats54 enemy = getEnemyStats_(r11.id_128.get());

        //LAB_80bd48e
        do {
          switch(enemy.attackPattern_36.get()) {
            case 0: // switch 80bd4a0
              //LAB_80bd4bc
              selectedAttack = selectAttackIndex(evenMoveSelection_80c2b80);
              break;

            case 1: // switch 80bd4a0
              //LAB_80bd4c4
              selectedAttack = selectAttackIndex(rareMoveSelection_80c2b88);
              break;

            case 2: // switch 80bd4a0
              //LAB_80bd4cc
              selectedAttack = selectAttackIndex(veryRareMoveSelection_80c2b90);
              break;

            case 3: // switch 80bd4a0
              //LAB_80bd4da
              r2 = r11._120.get();
              r3 = r2 << 31;
              if(r3 == 0) {
                r11._120.and(~0xe).or((lcgRand_() & 0x7) << 1).or(0x1);
              }
              selectedAttack = r2 << 28 >>> 29;
              if(r1 != 0) {
                r11._120.and(~0xe).or((selectedAttack + 1 & 0x7) << 1);
              }
              break;

            case 4: // switch 80bd4a0
              //LAB_80bd504
              selectedAttack = r11._120.get() << 28 >>> 29;
              if(r1 != 0) {
                r11._120.and(~0xe).or((selectedAttack + 1 & 0x7) << 1);
              }
              break;

            case 5: // switch 80bd4a0
              //LAB_80bd530
              selectedAttack++;
              break;
          }

          //LAB_80bd534
          //case 6: // switch 80bd4a0
          r6 = (enemy._37.get() >> selectedAttack) & 0x1;
          r6 = r6 & sp10;
          r9 = enemy.attacks_38.get(selectedAttack).get();
          turn._06.set(4);
          if(r6 != 0 && r1 != 0) {
            if((r11.items_d8.get(0).get() & 0x1ff) == 0) {
              r6 = 0x0;
              if(enemy.iq_35.get() == 0) {
                turn._06.set(2);
                turn._08.set(0x1fd);
                break;
              }
            }

            //LAB_80bd586
            if(r6 != 0) {
              final Item2c item = getItem_(r11.items_d8.get(0).get());
              if(item.useType_0c.get() != 0x1) {
                r6 = 0x0;
              } else {
                r9 = item.useAbility_28.get();
                turn._06.set(2);
                turn._08.set(0);
                r3 = getAbility_(r9).flags_01.get();
                if(r3 > 0x2 || r3 < 0x1) {
                  //LAB_80bd5b4
                  r6 = 0x0;
                }
              }

              //LAB_80bd5b6
              if(r6 == 0) {
                //LAB_80bd5ba
                sp10 = 0;
              }
            } else {
              sp10 = 0;
            }
          }

          //LAB_80bd5be
          jmp_80bd770:
          if(sp08 != 0) {
            //LAB_80bd5c6
            final Ability10 ability = getAbility_(r9);
            r3 = ability.effect_03.get();
            if(r3 == 0x2e) {
              //LAB_80bd5e4
              turn._06.set(3);
              turn._0a.set(FUN_80b9a70(turn.unitId_00.get()));
            } else if(r3 == 0x2f) {
              //LAB_80bd5ee
              turn._06.set(7);
              turn._0a.set(FUN_80b9a70(turn.unitId_00.get()));
              //LAB_80bd5de
            } else if(r3 == 0x31) {
              //LAB_80bd5f8
              turn._06.set(99);
              turn._0a.set(FUN_80b9a70(turn.unitId_00.get()));
            }

            //LAB_80bd606
            //LAB_80bd61e
            r2 = turn._06.get();
            if(r1 == 0 && r2 != 0x3 && r2 != 0x7) {
              break;
            }

            //LAB_80bd620
            if(r2 != 2) {
              if(!abilityHasCost(r9)) {
                //LAB_80bd674
                r2 = turn._06.get();
              } else {
                turn._06.set(1);
                turn._08.set(r9);

                if(ability.cost_09.get() > r11.pp_3a.get() && enemy.iq_35.get() != 0) {
                  break jmp_80bd770;
                }

                //LAB_80bd658
                if(r11._13d.get() != 0 && enemy.iq_35.get() == 0x2) {
                  break jmp_80bd770;
                }

                //LAB_80bd672
                //LAB_80bd698
                r2 = 0x1;
              }
            }

            //LAB_80bd69a
            if(r2 != 0x63 || r11._148.get() == 0) {
              //LAB_80bd6ae
              if(r1 == 0 || r2 != 0x3 && r2 != 0x7) {
                //LAB_80bd6c4
                if(r2 == 0x4) {
                  turn._08.set(r9);
                  if(r9 == 0x1) {
                    turn._06.set(0);
                  }
                }

                //LAB_80bd6d6
                turn._0c.set(ability.range_08.get());
                r3 = ability.target_00.get();

                //LAB_80bd6ea
                if(r3 == 0x3) {
                  //LAB_80bd74c
                  turn._0a.set(FUN_80b9a70(turn.unitId_00.get()));
                } else if(r3 == 0x2 || r3 == 0x4) {
                  //LAB_80bd6f2
                  r0 = FUN_80bae40(turn.unitId_00.get(), ability);
                  if(r0 == -2) {
                    //LAB_80bd70e
                    r0 = FUN_80bad7c(turn.unitId_00.get() < 8 ? 1 : 0);
                  }

                  //LAB_80bd712
                  if(r0 != -1) {
                    turn._0a.set(r0);
                    sp08 = 0;
                  }
                } else if(r3 == 0x1) {
                  //LAB_80bd722
                  r0 = FUN_80bae40(turn.unitId_00.get(), ability);
                  if(r0 == -2) {
                    //LAB_80bd73e
                    r0 = FUN_80bad7c(turn.unitId_00.get() < 8 ? 1 : 0);
                  }

                  //LAB_80bd742
                  if(r0 != -1) {
                    //LAB_80bd760
                    turn._0a.set(r0);
                    sp08 = 0;
                  }
                } else {
                  //LAB_80bd758
                  turn._0a.set(FUN_80b9a70(turn.unitId_00.get()));
                  sp08 = 0;
                }

                //LAB_80bd766
                if(r1 == 0) {
                  sp08 = 0;
                }
              }
            }
          } else {
            if(r1 == 0) {
              sp08 = 0;
            }
          }

          //LAB_80bd770
          if(sp08 != 0 && sp0c > 0x10) {
            turn._06.set(3);
            sp08 = 0;
          }

          //LAB_80bd784
          sp0c++;
          if(sp08 == 0) {
            break;
          }
        } while(true);
      }
    }

    //LAB_80bd792
  }

  @Method(0x80bd7dc)
  public static void FUN_80bd7dc(final int r0) {
    final BattleStruct82c r1 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    if(r1._800.get() == 0) {
      r1._800.set(1);

      if(r0 != 0) {
        r1._820.set(r0);
      }
    }

    //LAB_80bd7fe
  }

  @Method(0x80bd808)
  public static void FUN_80bd808(final int r0) {
    final BattleStruct82c r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r3._800.set(2);
    r3._7fc.set(0);
    r3._804.set(0);
    r3._808.set(r0);
    r3._654._01.set(0);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80bd898"), 0xc80);
  }

  @Method(0x80bd850)
  public static void FUN_80bd850(final int r0) {
    MEMORY.call(0x3000164, 0x6010000 + vramSlots_3001b10.get(MEMORY.ref(1, r0 + 0x1c).getUnsigned()).vramAddr_02.get(), MEMORY.ref(1, r0 + 0x20).getUnsigned() * MEMORY.ref(1, r0 + 0x21).getUnsigned());
  }

  @Method(0x80bd898)
  public static void FUN_80bd898() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r8;
    int r9;
    int r10;
    int r11;

    CPU.sp().value -= 0x2c;
    final BattleStruct82c sp08 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r3 = sp08._800.get();

    if(r3 != 0) {
      //LAB_80bd8c2
      do {
        do {
          do {
            do {
              do {
                do {
                  r3 = sp08._800.get();
                  if(r3 == 0x4) {
                    CPU.sp().value += 0x2c;
                    return;
                  }

                  //LAB_80bd8d0
                  if(r3 != 0x1) {
                    break;
                  }

                  if(sp08._7f8.get() < sp08._654._01.get()) {
                    sp08._7fc.set(0);
                    sp08._804.set(0);
                    sp08._808.set(0);
                    FUN_80bbb0c(sp08._654, sp08._7f8.get());
                    sp08._7f8.incr();
                    sp08._800.set(2);
                  } else {
                    //LAB_80bd918
                    sp08._800.set(4);
                  }
                } while(true);

                //LAB_80bd91e
                if(r3 != 0x2) {
                  break;
                }

                //LAB_80bd924
                r5 = sp08._804.get();
                if(r5 < sp08._7fc.get()) {
                  //LAB_80bd93a
                  r6 = r5;

                  //LAB_80bd93c
                  do {
                    if(sp08._808.get() != 0) {
                      sp08._808.decr();
                      CPU.sp().value += 0x2c;
                      return;
                    }

                    //LAB_80bd94e
                    //LAB_80bd956
                    switch(sp08._6b8.get(r6).get()) {
                      case 14: // switch 80bd960
                        //LAB_80bd99c
                        playSound_(sp08.unitIds_6f8.get(r6).get());
                        break;

                      case 13: // switch 80bd960
                        //LAB_80bd9a8
                        FUN_80bb928(sp08._6b8.getAddress()); //TODO
                        break;

                      case 0: // switch 80bd960
                        //LAB_80bd9b6
                        FUN_8015120(sp08.unitIds_6f8.get(r6).get(), 1);
                        break;

                      case 1: // switch 80bd960
                        //LAB_80bd9c4
                        FUN_8015120(sp08.unitIds_6f8.get(r6).get(), 5);
                        break;

                      case 2: // switch 80bd960
                        //LAB_80bd9d2
                        FUN_8015120(sp08.unitIds_6f8.get(r6).get() & 0x1ff, 2);
                        break;

                      case 3: // switch 80bd960
                        //LAB_80bd9de
                        FUN_8015120(sp08.unitIds_6f8.get(r6).get() & 0x3fff, 4);
                        break;

                      case 6: // switch 80bd960
                        //LAB_80bd9f0
                        r2 = boardWramMallocHead_3001e50.offset(37 * 0x4).get();
                        MEMORY.ref(4, r2 + 0x8).setu(1);
                        break;

                      case 4: // switch 80bd960
                        //LAB_80bd9fa
                        r0 = sp08.unitIds_6f8.get(r6).get();
                        if(r0 >= 0) {
                          FUN_80151d0(r0);
                        }

                        //LAB_80bda08
                        sp08._800.set(3);
                        accumulatedButtons_3001af8.set(0);
                        break;

                      case 5: // switch 80bd960
                        //LAB_80bda16
                        r0 = sp08.unitIds_6f8.get(r6).get();
                        if(r0 >= 0) {
                          FUN_80151d0(r0);
                        }

                        //LAB_80bda24
                        sp08._800.set(13);
                        break;

                      case 7: // switch 80bd960
                        //LAB_80bda30
                        FUN_8015118();
                        break;

                      case 12: // switch 80bd960
                        //LAB_80bda36
                        FUN_80bb8e8(sp08.unitIds_6f8.get(r6).get());
                        break;

                      case 8: // switch 80bd960
                        //LAB_80bda42
                        r0 = sp08._820.get();
                        if(r0 > 0) {
                          playSound_(r0);
                        }

                        //LAB_80bda52
                        r0 = sp08.unitIds_6f8.get(r6).get();
                        sp08.unitId_81c.set(r0);
                        setActorAnimation_(getCombatantForUnit(r0).actor_00.deref(), 5);
                        sp08._800.set(10);
                        sp08._808.set(0);
                        break;

                      case 9: {
                        //LAB_80bda82
                        r0 = sp08.unitIds_6f8.get(r6).get();
                        sp08.unitId_81c.set(r0);
                        FUN_80c24f0(r0, sp08._824.get());
                        FUN_80bb588(sp08.unitId_81c.get());
                        final Unit14c unit = getUnit_(sp08.unitId_81c.get());

                        //LAB_80bdaca
                        for(r5 = 0; ; r5++) {
                          final Sprite38 sprite = getActorSprite(getCombatantForUnit(sp08.unitId_81c.get()).actor_00.deref(), r5);
                          if(sprite == null) {
                            break;
                          }

                          //LAB_80bdaae
                          if(unit._12a.get() != 0x1) {
                            setSpriteAnimation_(sprite, 4);
                          } else {
                            //LAB_80bdac2
                            setSpriteAnimation_(sprite, 5);
                          }

                          //LAB_80bdac8
                        }

                        if(unit._12a.get() == 0x1) {
                          sp08._800.set(11);
                          sp08._808.set(0);
                        }
                        break;
                      }

                      case 10: // switch 80bd960
                        //LAB_80bdb02
                        FUN_8015130(boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new)._41.get());
                        break;

                      case 11: // switch 80bd960
                        //LAB_80bdb10
                        FUN_80b78e4(sp08.unitIds_6f8.get(r6).get(), getCombatantForUnit(sp08.unitIds_6f8.get(r6).get()));
                        FUN_80ba918(getCombatantForUnit(sp08.unitIds_6f8.get(r6).get()).actor_00.deref(), FUN_80b6cd0(sp08.unitIds_6f8.get(r6).get()));
                        FUN_80b7aac(sp08.unitIds_6f8.get(r6).get());
                        break;
                    }

                    //LAB_80bdb3e
                    r5 = sp08._804.get() + 0x1;
                    sp08._804.set(r5);
                    if(r5 >= sp08._7fc.get()) {
                      break;
                    }
                    r6 = r5;
                    if(sp08._800.get() != 0x2) {
                      break;
                    }
                  } while(true);
                }

                //LAB_80bdb66
                if(sp08._800.get() == 0x2) {
                  //LAB_80bdb74
                  sp08._800.set(1);
                }
              } while(true);

              //LAB_80bdb7a
              if(r3 != 0x3 && r3 != 0xd) {
                break;
              }

              //LAB_80bdb82
              if(FUN_8015048() == 0) {
                CPU.sp().value += 0x2c;
                return;
              }

              //LAB_80bdb8c
              if(sp08._800.get() == 0xd) {
                sp08._800.set(2);
                sp08._808.set(0);
              } else {
                //LAB_80bdb9e
                sp08._800.set(5);
                sp08.vramSlot_818.set(-1);
                sp08._808.set(ticks_3001800.get());
              }
            } while(true);

            //LAB_80bdbe0
            if(r3 != 0x5) {
              break;
            }

            //LAB_80bdbe6
            r10 = 0x80c3734 + (_3001e40.get() >>> 2 & 0x7) * 0x80;
            r3 = boardWramMallocHead_3001e50.offset(37 * 0x4).get();
            r11 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(MEMORY.ref(4, r3 + 0x4).get());
            if(sp08.vramSlot_818.get() == -1) {
              sp08.vramSlot_818.set(sp08.vramSlot_54.get());
            }

            //LAB_80bdc26
            FUN_8015118();
            queueVblankNand16_80000(GPU.WINOUT.getAddress(), 0x4);
            queueVblankOr16(GPU.WINOUT.getAddress(), 0x10);
            sp08._80c.attribs_04.attrib0_00.set(0xa000);
            sp08._80c.attribs_04.attrib1_02.set(0);
            sp08._80c.attribs_04.attrib2_04.set(0);
            sp08._80c.attribs_04.rotationScaling_06.set(0);
            r0 = FUN_80040d0(sp08.vramSlot_818.get(), r10);
            sp08._80c.attribs_04.attrib2_04.and(~0x3ff).or(r0 & 0x3ff);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r8 = MEMORY.ref(2, r11 + 0xc).getUnsigned() * 8 + (MEMORY.ref(2, r4 + 0x4).getUnsigned() >>> 8) + 4;
            sp08._80c.attribs_04.attrib1_02.and(~0x1ff).or(r8 & 0x1ff);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            sp08._80c.attribs_04.y_00.set((MEMORY.ref(2, r1 + 0x6).getUnsigned() >>> 8) + sin(_3001e40.get() << 12) / 0x8000 + MEMORY.ref(2, r11 + 0xe).getUnsigned() * 8 + 6);

            if((heldButtonsLastFrame_3001ae8.get() & 0x2) == 0 && (accumulatedButtons_3001af8.get() & 0x303) == 0 && (((ticks_3001800.get() - sp08._808.get()) & 0xffff_ffffL) <= 10 || (heldButtonsLastFrame_3001ae8.get() & 0x303) == 0)) {
              //LAB_80bdd22
              insertIntoRenderQueue(sp08._80c, 240);
              CPU.sp().value += 0x2c;
              return;
            }

            //LAB_80bdd06
            playSound_(0x6f);
            sp08._800.set(2);
            sp08._808.set(0);
          } while(true);

          //LAB_80bdd2c
          if(r3 != 0xa) {
            break;
          }

          r2 = sp08._808.get();
          if((r2 & 0x1) != 0) {
            r9 = CPU.sp().value + 0x1c;
            if((r2 & 0x2) != 0) {
              MEMORY.ref(2, r9).setu(0xff);
              FUN_80ba918(getCombatantForUnit(sp08.unitId_81c.get()).actor_00.deref(), FUN_80b6cd0(sp08.unitId_81c.get()));
            } else {
              //LAB_80bdd6e
              r0 = sp08.unitId_81c.get();
              MEMORY.ref(2, r9).setu(r0);
              MEMORY.ref(2, r9 + 0x2).setu(0xff);
              FUN_80ba918(getCombatantForUnit(r0).actor_00.deref(), 7);
            }

            //LAB_80bdd90
            FUN_80152b8(r9);
          }

          //LAB_80bdd96
          sp08._808.incr();
          if(sp08._808.get() <= 0x8) {
            CPU.sp().value += 0x2c;
            return;
          }

          //LAB_80bdda8
          sp08._800.set(2);
          sp08._808.set(0);
        } while(true);

        //LAB_80bddb8
      } while(r3 != 0xb);

      //LAB_80bddbe
      r3 = sp08._808.get();
      if(r3 == 0 || r3 >= 0x400) {
        //LAB_80bddd2
        r10 = 6;
        if(r3 == 0 && sp08._824.get() != 0) {
          r0 = FUN_80c2368(getUnit_(sp08.unitId_81c.get()).id_128.get());
          if(r0 >= 0) {
            r0 = r0 - 0x1;
            if(r0 < 0) {
              r0 = 0x0;
            }

            //LAB_80bde0a
            playSound_(r0 + 0x92);
          }

          //LAB_80bde10
          sp08._808.set(0x400);
        }

        //LAB_80bde1c
        if(sp08._808.get() > 0x41d) {
          sp08._808.set(0);
        }

        //LAB_80bde2e
        if(sp08._808.get() == 0) {
          r0 = FUN_80c2368(getUnit_(sp08.unitId_81c.get()).id_128.get());
          if(r0 >= 0) {
            playSound_(r0 + 0x92);
          }
        }

        //LAB_80bde54
        r3 = sp08._808.get();
        if(r3 >= 0x400) {
          r10 = modS((r3 - 0x400) / 8, 5) + 1;
        }

        //LAB_80bde7c
        if(r10 != 0x6 && (sp08._808.get() & 0x7) != 0) {
          sp08._808.incr();
        } else {
          //LAB_80bde94
          r5 = CPU.sp().value + 0xc;

          //LAB_80bdeb0
          for(r6 = 0; ; r6++) {
            final Sprite38 sprite = getActorSprite(getCombatantForUnit(sp08.unitId_81c.get()).actor_00.deref(), r6);
            if(sprite == null) {
              break;
            }

            //LAB_80bde9e
            MEMORY.ref(4, r5 + r6 * 0x4).setu(sprite.getAddress());
            final SpriteLayer18 layer = sprite.layers_28.get(0).deref();
            layer._05.set(r10);
            layer._16.or(0xff);
          }

          sp08._808.incr();
        }
      } else {
        //LAB_80bdeca
        if(r3 == 0x4) {
          FUN_80bac6c(sp08.unitId_81c.get());
          sp08._808.incr();
        } else {
          //LAB_80bdede
          if(r3 > 0x4) {
            final BattleStruct82c.Combatant2c combatant = getCombatantForUnit(sp08.unitId_81c.get());
            combatant._2a.set(1);
            r5 = CPU.sp().value + 0xc;

            //LAB_80bdefe
            for(r2 = 0; ; r2++) {
              final Sprite38 sprite = getActorSprite(combatant.actor_00.deref(), r2);
              if(sprite == null) {
                break;
              }

              //LAB_80bdefa
              MEMORY.ref(4, r5 + r2 * 0x4).setu(sprite.getAddress());
            }

            r3 = sp08._808.get();
            r3 = r3 * 0x4;
            r1 = r3 - 0x14;
            r8 = r1;
            if(r1 > 0x7f) {
              //LAB_80bdf2c
              for(r5 = 0; r5 < r2; r5++) {
                FUN_80bd850(MEMORY.ref(4, CPU.sp().value + 0xc + r5 * 0x4).get());
              }

              //LAB_80bdf3e
              FUN_80b7e60(sp08.unitId_81c.get());
              sp08._800.set(2);
              sp08._808.set(0);
            } else {
              //LAB_80bdf60
              if(r2 > 0) {
                r11 = r3 - 19;
                r9 = r3 - 18;
                r10 = r3 - 17;
                r5 = CPU.sp().value + 0xc;

                //LAB_80bdf7c
                for(int i = 0; i < r2; i++) {
                  FUN_80090f8(MEMORY.ref(4, r5).get(), r8);
                  FUN_80090f8(MEMORY.ref(4, r5).get(), r11);
                  FUN_80090f8(MEMORY.ref(4, r5).get(), r9);
                  FUN_80090f8(MEMORY.ref(4, r5).get(), r10);
                  r5 += 0x4;
                }
              }

              //LAB_80bdfa2
              sp08._808.incr();
            }
          } else {
            //LAB_80bdfb0
            sp08._808.incr();
          }
        }
      }
    }

    //LAB_80bdfb4
    CPU.sp().value += 0x2c;
  }

  @Method(0x80bdfec)
  public static void FUN_80bdfec() {
    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r2._7f8.set(0);
    r2._7fc.set(0);
    r2._800.set(0);
    r2._804.set(0);
    r2._808.set(0);
    r2._820.set(0x86);
    r2._824.set(0);
  }

  @Method(0x80be02c)
  public static void FUN_80be02c() {
    final BattleStruct82c r1 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    if(r1._800.get() == 0) {
      r1._800.set(1);
    }

    //LAB_80be042
    //LAB_80be04c
    while(r1._800.get() != 4) {
      sleep(1);
    }

    //LAB_80be058
    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80bd898"));
    FUN_80bdfec();
  }

  @Method(0x80be070)
  public static int FUN_80be070(final int unitId) {
    //LAB_80be07e
    final int[] ids = new int[8];
    final int count = getUnitIds(unitId > 7 ? 0x2 : 0x1, ids);

    //LAB_80be094
    int r2;
    for(r2 = 0; r2 < count && ids[r2] != unitId; r2++) {
      //
    }

    //LAB_80be0a2
    final int r3 = r2 ^ count;
    return (-r3 | r3) >>> 31;
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
      if(r8.djinn_08.get(r10).turnsRemaining_03.get() == -1) {
        //LAB_80be13c
        int r4;
        for(r4 = 0; r4 < unitCount && unitIds[r4] != r8.djinn_08.get(r10).charId_02.get(); r4++) {
          //
        }

        //LAB_80be14c
        if(r4 != unitCount) {
          if(out != 0) {
            MEMORY.ref(1, out + r8.djinn_08.get(r10).element_00.get()).incr();
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

  @Deprecated // Uses r9 as param
  @Method(0x80be18c)
  public static int FUN_80be18c(final int abilityId) {
    int r0 = abilityId;
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
    CPU.sp().value -= 0x1c;
    r3 = CPU.sp().value + 0x18;
    r1 = CPU.r9().value;
    MEMORY.ref(4, r3).setu(r1);
    CPU.r10().value = r1;
    final Ability10 ability = getAbility_(abilityId);
    r2 = ability.target_00.get();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    r3 = ability.effect_03.get();
    if(r3 == 0x5 || r3 >= 0x5 && r3 <= 0x39 && r3 >= 0x38) {
      //LAB_80be1c0
      r0 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(1);
    }

    //LAB_80be1c4
    if(r2 == 0) {
      //LAB_80be1dc
      r3 = MEMORY.ref(4, CPU.r10().value - 0x4).get();
      MEMORY.ref(1, r3 + 0x10).setu(r2);
      MEMORY.ref(1, r3 + 0x1).setu(1);
      r2 = MEMORY.ref(4, CPU.r10().value - 0x8).get();
      MEMORY.ref(1, r3 + 0x1e).setu(1);
      MEMORY.ref(1, r3 + 0x2).setu(r2);
    } else if(r2 == 0x4) {
      //LAB_80be1f4
      r2 = MEMORY.ref(4, CPU.r10().value - 0x4).get();
      MEMORY.ref(1, r2 + 0x10).setu(0);
      MEMORY.ref(1, r2 + 0x1).setu(1);
      r3 = MEMORY.ref(4, CPU.r10().value - 0x8).get();
      MEMORY.ref(1, r2 + 0x1e).setu(1);
      MEMORY.ref(1, r2 + 0x2).setu(r3);
    } else {
      CPU.r9().value = 0;
      CPU.r11().value = CPU.r10().value - 0xc;

      //LAB_80be210
      for(r6 = 0; ; r6++) {
        r1 = MEMORY.ref(4, CPU.r11().value).get();
        if(MEMORY.ref(2, r1 + 0x58 + r6 * 0x2).get() == 0xff) {
          break;
        }

        //LAB_80be20e
      }

      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r6);
      r3 = 0x64;
      r2 = r1 + 0x2;
      r3 = MEMORY.ref(2, r2 + r3).get();
      r6 = 0x0;
      if(r3 != 0xff) {
        r2 = r2 + 0x64;

        //LAB_80be22e
        do {
          r2 = r2 + 0x2;
          r1 = 0x0;
          r3 = MEMORY.ref(2, r2 + r1).get();
          r6 = r6 + 0x1;
        } while(r3 != 0xff);
      }

      //LAB_80be23a
      r2 = CPU.r10().value - 0x10;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      r2 = MEMORY.ref(4, r2).get();
      r3 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
      r4 = 0xf;
      r4 = r4 & r3;
      r0 = 0xc;
      r3 = MEMORY.ref(2, r2 + r0).get();
      r2 = r4 - r3;
      r3 = r4 + r3;
      r3 = r3 - 0x1;
      r6 = r2 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      if(r6 <= r3) {
        r3 = r6 << 1;
        r7 = r3;
        CPU.r8().value = CPU.r10().value - 0x4;
        r7 = r7 + 0x64;

        //LAB_80be26a
        do {
          if(r6 >= 0) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r3 = MEMORY.ref(4, r2).get();
            r2 = MEMORY.ref(2, r3 + 0xa).getUnsigned();
            r3 = 0x80;
            r3 = r3 & r2;
            if(r3 != 0) {
              r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              if(r6 < r3) {
                r0 = CPU.r11().value;
                r3 = MEMORY.ref(4, r0).get();
                r3 = r3 + 0x2;
                r5 = MEMORY.ref(2, r3 + r7).get();
                if(r5 != 0xfe) {
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  if(r2 != 0 || getUnit_(r5).hp_38.get() != 0) {
                    //LAB_80be2a6
                    r2 = CPU.r8().value;
                    r0 = MEMORY.ref(4, r2).get();
                    r2 = CPU.r9().value;
                    r1 = r0 + 0x2;
                    r2 = r2 + 0x1c;
                    r3 = 0x1;
                    MEMORY.ref(1, r1 + r2).setu(r3);
                    r3 = r6 - r4;
                    r2 = r2 - 0xc;
                    MEMORY.ref(1, r0 + r2).setu(r3);
                    r3 = CPU.r9().value;
                    r0 = 0x1;
                    MEMORY.ref(1, r1 + r3).setu(r5);
                    CPU.r9().value = CPU.r9().value + r0;
                  }
                }
              }
            } else {
              //LAB_80be2c4
              r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              if(r6 < r1) {
                r3 = CPU.r11().value;
                r2 = MEMORY.ref(4, r3).get();
                r3 = r6 << 1;
                r3 = r3 + 0x58;
                r5 = MEMORY.ref(2, r2 + r3).get();
                if(r5 != 0xfe) {
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  if(r1 != 0 || getUnit_(r5).hp_38.get() != 0) {
                    //LAB_80be2f0
                    r3 = CPU.r8().value;
                    r0 = MEMORY.ref(4, r3).get();
                    r2 = CPU.r9().value;
                    r1 = r0 + 0x2;
                    r2 = r2 + 0x1c;
                    r3 = 0x1;
                    MEMORY.ref(1, r1 + r2).setu(r3);
                    r2 = r2 - 0xc;
                    r3 = r6 - r4;
                    MEMORY.ref(1, r0 + r2).setu(r3);
                    r0 = CPU.r9().value;
                    MEMORY.ref(1, r1 + r0).setu(r5);
                    r1 = 0x1;
                    CPU.r9().value = CPU.r9().value + r1;
                  }
                }
              }
            }
          }

          //LAB_80be30c
          r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r6 = r6 + 0x1;
          r7 = r7 + 0x2;
        } while(r6 <= r2);
      } else {
        //LAB_80be318
        CPU.r8().value = CPU.r10().value - 0x4;
      }

      //LAB_80be320
      r0 = CPU.r8().value;
      r3 = MEMORY.ref(4, r0).get();
      r1 = CPU.r9().value;
      r2 = CPU.r9().value;
      MEMORY.ref(1, r3 + 0x1).setu(r1);
      if(r2 <= 0) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = MEMORY.ref(4, r0).get();
        r1 = 0x0;
        r0 = MEMORY.ref(2, r3 + r1).get();
        r1 = 0x1;
        FUN_8015120(r0, r1);
        r0 = 0x816;
        FUN_80151c8(r0);
        r3 = CPU.r10().value - 0x14;
        r3 = MEMORY.ref(4, r3).get();
        r0 = 0x12b;
        r2 = r3 + r0;
        r3 = 0x0;
        r3 = MEMORY.ref(1, r2 + r3).get();
        if(r3 == 0) {
          r3 = 0x1;
          MEMORY.ref(1, r2).setu(r3);
        }

        //LAB_80be358
        r0 = 0x1;
        r0 = -r0;
      }
    }

    //LAB_80be35c
    CPU.sp().value += 0x1c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80be378)
  public static int FUN_80be378(final BattleStruct82c.Turn10 turn, final BattleStruct82c.Sub64 r1_0) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    final int r8;
    int r9;
    int r11;

    CPU.sp().value -= 0x30;
    final Unit14c sp1c = getUnit_(turn.unitId_00.get());
    final int sp24 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();

    //TODO this is really dumb, sp+0x30 is passed into 80be18c via r9 and that function does a negative offsets on it to access these
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(sp1c.getAddress());
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(turn.getAddress());
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(sp24);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(FUN_80b9a44(turn._0a.get()));
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1_0.getAddress());

    FUN_80bdfec();
    r5 = 0x4;
    r1_0.unitId_00.set(turn.unitId_00.get());
    r1_0._01.set(0);
    r1_0.element_50.set(4);
    r1_0._58.set(0);
    r1_0._5c.set(0);
    r1_0._60.set(0);
    FUN_8015118();

    if(sp1c.hp_38.get() == 0) {
      CPU.sp().value += 0x30;
      return -2;
    }

    //LAB_80be3f0
    if(debug_3001f54.get() != 0 && readFlag_(0x16d) != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x100) != 0) {
      if((heldButtonsLastFrame_3001ae8.get() & 0x4) != 0) {
        r8 = 0;
      } else {
        r8 = 1;
      }

      //LAB_80be420
      r6 = 0x64;

      //LAB_80be448
      do {
        if(r8 != 0) {
          r5 = MEMORY.ref(2, sp24 + r6 + 0x2).get();
        } else {
          //LAB_80be456
          r5 = MEMORY.ref(2, sp24 + r6 - 0xc).get();
        }

        //LAB_80be45e
        if(r5 == 0xff) {
          break;
        }

        //LAB_80be424
        if(r5 != 0xfe && addHp_(r5, 0xc0000000) == 0) {
          FUN_80bbabc(8, r5);
          FUN_80bbabc(9, r5);
        }

        //LAB_80be446
        r6 = r6 + 0x2;
      } while(true);

      FUN_80bb938();
      CPU.sp().value += 0x30;
      return -2;
    }

    //LAB_80be46a
    FUN_8015118();
    r3 = sp1c._145.get();
    if(r3 != 0) {
      sp1c._145.set(0);
      FUN_8015120(turn.unitId_00.get(), 1);
      FUN_80151c8(0x880);
      CPU.sp().value += 0x30;
      return -1;
    }

    //LAB_80be498
    r3 = sp1c._13c.get();
    if(r3 != 0) {
      FUN_8015120(turn.unitId_00.get(), 1);
      FUN_80151c8(0x858);
      CPU.sp().value += 0x30;
      return -1;
    }

    //LAB_80be4bc
    r3 = sp1c._13b.get();
    if(r3 != 0) {
      FUN_8015120(turn.unitId_00.get(), 1);
      FUN_80151c8(0x857);
      CPU.sp().value += 0x30;
      return -1;
    }

    //LAB_80be4dc
    r2 = sp1c.curse_130.getUnsigned();
    r3 = 0x1;
    r3 = r3 & r2;
    if(r3 != 0) {
      r3 = turn._06.get();
      if(r3 != 0x3) {
        r0 = lcgRand_();
        r3 = 0x3;
        r0 = r0 & r3;
        if(r0 == 0) {
          FUN_8015120(turn.unitId_00.get(), 1);
          FUN_80151c8(0x859);
          CPU.sp().value += 0x30;
          return -1;
        }
      }
    }

    //LAB_80be51a
    r3 = turn._06.get();
    if(r3 == 0x8) {
      CPU.sp().value += 0x30;
      return -2;
    }

    //LAB_80be528
    r11 = 1;

    //LAB_80be536
    for(r2 = 0; r2 < 14; r2++) {
      r1_0._2c.get(r2).set(0);
    }

    //LAB_80be54e
    for(r2 = 0; r2 < 14; r2++) {
      r1_0._3a.get(r2).set(-1);
    }

    //LAB_80be568
    switch(turn._06.get()) {
      case 99:
        //LAB_80be700
        r3 = turn.unitId_00.get();
        r0 = r3 << 16;
        if((r0 & 0xffff_ffffL) <= 0x70000) {
          FUN_80151c8(0x843);
        } else {
          //LAB_80be718
          r0 = r0 >> 16;
          FUN_8015120(r0, 1);
          FUN_80151c8(0x846);
        }

        //LAB_80be726
        FUN_80bb65c();
        r1_0._54.set(7);
        CPU.sp().value += 0x30;
        return 0;

      case 0:
        //LAB_80be76c
        r0 = FUN_8077160(sp1c);
        r11 = r0;
        CPU.r9().value = CPU.sp().value + 0x30;
        r0 = FUN_80be18c(r11); //TODO takes r9 as param
        if(r0 == -1) {
          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be78c
        if(r11 != 0x1) {
          //LAB_80be794
          FUN_8015120(turn.unitId_00.get(), 1);
          FUN_8015120(getUnitEquippedItemIdOfType_(sp1c, 1), 2);
          r5 = 0x819;
          FUN_80151c8(0x819);
          r5 = r5 + 0x1;
          FUN_80bb8d8();
          FUN_8015120(r11, 4);
          FUN_80151c8(0x81a);
        }
        break;

      case 1: {
        //LAB_80be7d0
        r0 = turn._08.get();
        r11 = r0;
        final Ability10 ability = getAbility_(r11);
        CPU.r9().value = CPU.sp().value + 0x30;
        r0 = FUN_80be18c(r11); //TODO takes r9 as param
        r5 = 0x1;
        if(r0 == -1) {
          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be7f8
        FUN_8015120(turn.unitId_00.get(), 1);
        FUN_8015120(r11, 4);
        FUN_80151c8(0x83e);

        if(sp1c.pp_3a.get() < ability.cost_09.get()) {
          r1_0._5c.set(2);
          r5 = 0x0;
        }

        //LAB_80be82c
        if(sp1c._13d.get() != 0) {
          r1_0._5c.set(1);
          r5 = 0x0;
        }

        //LAB_80be840
        if(r5 != 0) {
          //LAB_80be846
          r5 = 0x0;
          r1_0._5c.set(0);
          sp1c.pp_3a.sub(ability.cost_09.get());
          calcHpPpFractions_(turn.unitId_00.get());

          if(sp1c.pp_3a.get() < 0) {
            sp1c.pp_3a.set(0);
          }

          //LAB_80be874
          r3 = sp1c.maxPp_36.get();
          if(sp1c.pp_3a.get() > r3) {
            //LAB_80be884
            sp1c.pp_3a.set(r3);
          }
        }
        break;
      }

      case 2:
        //LAB_80be888
        r2 = turn._08.get();
        if(r2 < 0) {
          FUN_8015120(turn.unitId_00.get(), 1);
          FUN_80151c8(0x81b);
          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be8a6
        final Item2c item = getItem_(sp1c.items_d8.get(r2).get());
        r11 = item.useAbility_28.get();
        if(r11 == 0) {
          //LAB_80be8dc
          FUN_8015120(turn.unitId_00.get(), 1);
          FUN_80151c8(0x816);
          if(sp1c._12b.get() == 0) {
            //LAB_80be902
            sp1c._12b.set(1);
          }

          CPU.sp().value += 0x30;
          return -1;
        }

        if((sp1c.items_d8.get(turn._08.get()).get() & 0x400) != 0) {
          //LAB_80be8e0
          FUN_8015120(turn.unitId_00.get(), 1);
          FUN_80151c8(0x816);
          if(sp1c._12b.get() == 0) {
            //LAB_80be902
            sp1c._12b.set(1);
          }

          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be908
        CPU.r9().value = CPU.sp().value + 0x30;
        r0 = FUN_80be18c(r11); //TODO takes r9 as param
        if(r0 == -1) {
          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be91e
        FUN_8015120(turn.unitId_00.get(), 1);
        FUN_8015120(sp1c.items_d8.get(turn._08.get()).get(), 2);
        r3 = item.useType_0c.get();
        if(r3 != 2 && r3 != 0) {
          r0 = 0x817;
        } else {
          //LAB_80be94e
          r0 = item.type_02.get();
          if(r0 == 0x3) {
            //LAB_80be966
            r0 = 0x818;
          } else {
            if(r0 > 0x3) {
              //LAB_80be95e
              if(r0 <= 0x8 && r0 >= 0x6) {
                //LAB_80be966
                r0 = 0x818;
              } else {
                //LAB_80be96a
                r0 = 0x817;
              }
            } else {
              if(r0 == 0x1) {
                //LAB_80be966
                r0 = 0x818;
              } else {
                r0 = 0x817;
              }
            }
          }
        }
        FUN_80151c8(r0);
        break;

      case 3:
      case 7:
        //LAB_80be96e
        FUN_8015120(turn.unitId_00.get(), 1);
        FUN_80151c8(0x816);
        CPU.sp().value += 0x30;
        return -1;

      case 4:
        //LAB_80be984
        CPU.r9().value = CPU.sp().value + 0x30;
        r11 = turn._08.get();
        r0 = FUN_80be18c(r11); //TODO takes r9 as param
        if(r0 == -1) {
          CPU.sp().value += 0x30;
          return -1;
        }

        //LAB_80be9a2
        FUN_8015120(turn.unitId_00.get(), 1);
        FUN_8015120(r11, 4);
        if((getAbility_(r11).flags_01.get() & 0xf) == 0x6) {
          r0 = 0x8f1;
        } else {
          //LAB_80be9cc
          r0 = 0x8f0;
        }

        //LAB_80be9ce
        if(r11 == 0x1e8) {
          //LAB_80bea84
          r0 = 0x8fd;
        } else {
          if(r11 > 0x1e8) {
            //LAB_80bea12
            if(r11 == 0x1f4) {
              //LAB_80bea68
              r0 = 0x8f7;
            } else {
              if(r11 > 0x1f4) {
                //LAB_80bea40
                if(r11 == 0x1f7) {
                  //LAB_80bea90
                  r0 = 0x900;
                } else {
                  if(r11 > 0x1f7) {
                    //LAB_80bea52
                    if(r11 == 0x1f8) {
                      //LAB_80bea94
                      r0 = 0x901;
                    } else {
                      if(r11 == 0x1fc) {
                        //LAB_80bea98
                        r0 = 0x902;
                      }
                    }
                  } else {
                    if(r11 == 0x1f5) {
                      //LAB_80bea6c
                      r0 = 0x8f8;
                    }
                  }
                }
              } else {
                if(r11 == 0x1ee) {
                  //LAB_80bea74
                  r0 = 0x8fa;
                } else {
                  if(r11 > 0x1ee) {
                    //LAB_80bea32
                    if(r11 == 0x1ef) {
                      //LAB_80bea8c
                      r0 = 0x8fe;
                    } else {
                      if(r11 == 0x1f3) {
                        //LAB_80bea70
                        r0 = 0x8f9;
                      }
                    }
                  } else {
                    if(r11 == 0x1ec) {
                      //LAB_80bea88
                      r0 = 0x8ff;
                    }
                  }
                }
              }
            }
          } else {
            if(r11 > 0x1b9) {
              //LAB_80bea00
              if(r11 <= 0x1bc) {
                //LAB_80bea7c
                r0 = 0x8f0;
              } else {
                if(r11 == 0x1d8) {
                  //LAB_80bea80
                  r0 = 0x8fc;
                }
              }
            } else {
              if(r11 > 0x1b4) {
                //LAB_80bea78
                r0 = 0x8fb;
              } else {
                if(r11 == 0xe0) {
                  //LAB_80bea64
                  r0 = 0x83e;
                } else {
                  if(r11 >= 0xe0) {
                    //LAB_80be9f2
                    if(r11 > 0x1b2) {
                      //LAB_80be9fc
                      r0 = 0x8f2;
                    }
                  }
                }
              }
            }
          }
        }
        FUN_80151c8(r0);
        break;

      case 5:
        //LAB_80beb08
        r3 = turn._08.get();
        r6 = 0xf;
        r0 = r3 << 16;
        r5 = 0xff;
        r0 = r0 >> 24;
        r1 = r5;
        r1 = r1 & r3;
        r0 = r0 & r6;
        r0 = getDjinnAbility_(r0, r1);
        r11 = r0;
        r0 = turn.unitId_00.get();
        r3 = turn._08.get();
        r1 = r3 << 16;
        r1 = r1 >> 24;
        r2 = r5;
        r1 = r1 & r6;
        r2 = r2 & r3;
        r0 = FUN_8077208(r0, r1, r2);
        if(r0 != 0) {
          //LAB_80bec90
          CPU.r9().value = CPU.sp().value + 0x30;
          r0 = FUN_80be18c(r11); //TODO takes r9 as param
          if(r0 == -1) {
            CPU.sp().value += 0x30;
            return -1;
          }

          //LAB_80beca4
          r0 = turn.unitId_00.get();
          r3 = turn._08.get();
          r1 = r3 << 16;
          r1 = r1 >> 24;
          r2 = r3 & 0xff;
          r1 = r1 & r6;
          FUN_80771c8(r0, r1, r2);
          final Ability10 ability = getAbility_(r11);
          FUN_8015120(turn.unitId_00.get(), 1);
          r0 = r11;
          r1 = 0x4;
          FUN_8015120(r0, r1);
          r0 = 0x83f;
          FUN_80151c8(r0);
          r3 = ability.element_02.get();
          r1_0.element_50.set(r3);
          break;
        }

        //LAB_80beb40
        //LAB_80beb48
        r3 = turn._08.get();
        r1 = r3 << 16;
        r1 = r1 >> 24;
        r2 = r5;
        r1 = r1 & r6;
        r2 = r2 & r3;
        r0 = FUN_8077210(turn.unitId_00.get(), r1, r2);
        if(r0 == 0) {
          //LAB_80bec62
          FUN_8015120(turn.unitId_00.get(), 1);
          r1 = 0x4;
          r0 = r11;
          FUN_8015120(r0, r1);
          r0 = 0x72;
          playSound_(r0);
          r0 = 0x85b;
          FUN_80151c8(r0);
          r0 = 0x3c;
          sleep(r0);
          r0 = 0x1;
          r0 = -r0;
          CPU.sp().value += 0x30;
          return r0;
        }

        //LAB_80beb66
        r1 = 0x0;
        r0 = 0x0;
        FUN_80c10e8(r0, r1);
        r0 = turn.unitId_00.get();
        r3 = turn._08.get();
        r1 = r3 << 16;
        r1 = r1 >> 24;
        r2 = r5;
        r2 = r2 & r3;
        r1 = r1 & r6;
        r0 = setDjinn_(r0, r1, r2);
        r0 = turn.unitId_00.get();
        r3 = turn._08.get();
        r1 = r3 << 16;
        r1 = r1 >> 24;
        r2 = r5;
        r1 = r1 & r6;
        r2 = r2 & r3;
        r0 = recoverDjinn_(r0, r1, r2);
        recalcStats_(turn.unitId_00.get());
        FUN_80bdfec();
        r0 = 0x1e;
        FUN_80bd808(r0);
        FUN_80bbabc(0, turn.unitId_00.get());
        r2 = turn._08.get();
        r3 = r2 << 16;
        r3 = r3 >> 24;
        r3 = r3 & r6;
        r1 = r3 << 2;
        r1 = r1 + r3;
        r3 = r5;
        r3 = r3 & r2;
        r1 = r1 << 2;
        r2 = 0x96;
        r2 = r2 << 1;
        r1 = r1 + r3;
        r1 = r1 + r2;
        r0 = 0x3;
        FUN_80bbabc(r0, r1);
        r1 = 0xaf;
        r0 = 0xe;
        FUN_80bbabc(r0, r1);
        r1 = 0x0;
        r0 = 0xa;
        FUN_80bbabc(r0, r1);
        r1 = 0x897;
        r0 = 0x4;
        FUN_80bbabc(r0, r1);
        FUN_80bbabc(11, turn.unitId_00.get());
        r0 = 0xd4;
        playSound_(r0);
        setActorAnimation_(getCombatantForUnit(turn.unitId_00.get()).actor_00.deref(), 3);
        FUN_8009088(getCombatantForUnit(turn.unitId_00.get()).actor_00.deref(), 32);
        r1 = turn._08.get();
        r1 = r1 << 16;
        r1 = r1 >> 24;
        r1 = r1 & r6;
        r2 = 0x3;
        r3 = 0x0;
        FUN_80c1798(turn.unitId_00.get(), r1, r2, r3);
        FUN_80be02c();

      case 8:
        //LAB_80bec5c
        CPU.sp().value += 0x30;
        return -2;

      case 6:
        //LAB_80becea
        r0 = getSummon_(turn._08.get());
        r8 = CPU.sp().value + 0x18;
        r9 = r0;
        FUN_80be0b4(turn.unitId_00.get(), r8);
        r3 = turn.unitId_00.get();
        r0 = 0x0;
        if((r3 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
          r0 = 0x1;
        }

        //LAB_80bed1a
        final RecoveryQueue10c sp04 = getDjinnRecoveryQueue_(r0);
        r1 = r9;
        r1 = r1 + 0x4;
        r0 = r8;
        r2 = MEMORY.ref(1, r0).getUnsigned();
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r7 = 0x0;
        if((r2 & 0xffff_ffffL) >= (r3 & 0xffff_ffffL)) {
          r5 = 0x4;
          r6 = r8;
          r4 = 0x4;

          //LAB_80bed38
          do {
            r2 = r9;
            r3 = MEMORY.ref(1, r2 + r5).getUnsigned();
            r7 = r7 + 0x1;
            MEMORY.ref(1, r0).setu(r3);
            r4 = r4 + 0x1;
            r0 = r0 + 0x1;
            if(r7 > 0x3) {
              break;
            }
            r6 = r6 + 0x1;
            r1 = r1 + 0x1;
            r2 = MEMORY.ref(1, r6).getUnsigned();
            r3 = MEMORY.ref(1, r1).getUnsigned();
            r5 = r4;
          } while((r2 & 0xffff_ffffL) >= (r3 & 0xffff_ffffL));
        }

        //LAB_80bed56
        r11 = MEMORY.ref(2, r9).getUnsigned();
        CPU.r9().value = CPU.sp().value + 0x30;
        r0 = FUN_80be18c(r11); //TODO takes r9 as param
        r5 = 0x1;
        r5 = -r5;
        if(r0 == r5) {
          CPU.sp().value += 0x30;
          return r0;
        }

        //LAB_80bed70
        if(r7 != 0x4) {
          FUN_8015120(turn.unitId_00.get(), 1);
          r0 = r11;
          r1 = 0x4;
          FUN_8015120(r0, r1);
          r0 = 0x842;
          FUN_80151c8(r0);
          r0 = r5;
          CPU.sp().value += 0x30;
          return r0;
        }

        //LAB_80bed94
        FUN_8015120(turn.unitId_00.get(), 1);
        r1 = 0x4;
        r0 = r11;
        FUN_8015120(r0, r1);
        r0 = 0x841;
        FUN_80151c8(r0);
        r9 = r5;

        //LAB_80bedc4
        for(r7 = 0; r7 < sp04.count_108.get(); r7++) {
          final RecoveryQueue10c.DjinnInfo04 djinnInfo = sp04.djinn_08.get(r7);
          if(djinnInfo.turnsRemaining_03.get() == r9) {
            if(FUN_80be070(djinnInfo.charId_02.get()) != 0) {
              r1 = djinnInfo.element_00.get();
              r2 = MEMORY.ref(1, r8 + r1).getUnsigned();
              if(r2 != 0) {
                djinnInfo.turnsRemaining_03.set(0xfe);
                MEMORY.ref(1, r8 + r1).setu(r2 + 0xff);
              }
            }
          }

          //LAB_80bedee
        }
        break;
    }

    //LAB_80bee00
    if(r11 == 0x1) {
      //LAB_80bee08
      final Unit14c unit = getUnit_(r1_0._02.get(0).get());
      r1_0._4c.set(1);
      r1_0.element_50.set(getUnitElement_(turn.unitId_00.get()));
      r1_0._54.set(2);

      if(sp1c.class_129.get() == 0) {
        r1_0._58.set(0x4000 | FUN_80c23e8(sp1c.id_128.get()));
      } else {
        //LAB_80bee58
        r1_0._58.set(0);

        switch(sp1c.id_128.get()) {
          case 1:
            //LAB_80bee88
            r1_0._58.set(0x4001);
            break;

          case 2:
            //LAB_80bee90
            r1_0._58.set(0x4004);
            break;

          case 3:
            //LAB_80bee98
            r1_0._58.set(0x4004);
            break;

          case 0:
          case 5:
            //LAB_80beea0
            r1_0._58.set(0x4001);
            break;
        }
      }

      //LAB_80beea8
      FUN_8015120(turn.unitId_00.get(), 1);
      FUN_80151c8(0x814);

      if(unit.hp_38.get() != 0 && unit._13c.get() == 0 && unit._13b.get() == 0 && unit._145.get() == 0) {
        r5 = unit._13a.get();
        if(r5 == 0) {
          //LAB_80beebe
          if(sp1c._138.get() != 0 && (lcgRand_() & 0xff) < 0x99) {
            r1_0._1e.get(0).set(0);
          }

          //LAB_80beee0
          if((lcgRand_() & 0x1f) == 0) {
            r1_0._1e.get(0).set(0);
          }
        }
      }

      //LAB_80bef28
      if(readFlag_(0x16e) != 0) {
        r1_0._1e.get(0).set(0);
      }

      //LAB_80bef3c
      if(unit.hp_38.get() != 0) {
        //LAB_80bef46
        if((lcgRand_() & 0x1f) == 0) {
          r1_0._2c.get(0).set(1);
        } else {
          //LAB_80bef88
          r5 = divideS(FUN_80772f8(sp1c) << 16, 200);
          if(r5 > (lcgRand_() & 0xffff)) {
            //LAB_80befa8
            r1_0._2c.get(0).set(1);
          }
        }
      }
    } else {
      //LAB_80befb4
      final Ability10 ability = getAbility_(r11);
      r1_0.element_50.set(ability.element_02.get());
      r1_0._58.set(0);
      r1_0._4c.set(r11);
      r3 = ability.effect_03.get();
      r2 = r3;
      if(r2 == 0x29 || r2 == 0x2a || r2 == 0x2b || r2 == 0x2c || r2 == 0x41 || r2 == 0x44) {
        //LAB_80befe8
        if(r2 == 0x41 || r2 == 0x44) {
          //LAB_80beff2
          r5 = 0x99;
          //LAB_80beff6
        } else if(r2 == 0x29 || r2 == 0x2b) {
          //LAB_80bf000
          r5 = 0x20;
        } else {
          r5 = 0x40;
        }

        //LAB_80bf002
        if(r3 == 0x41 || r3 == 0x29 || r3 == 0x2a) {
          //LAB_80bf010
          r6 = 0x1;
        } else {
          r6 = 0x2;
        }

        //LAB_80bf012
        if((lcgRand_() & 0xff) < r5) {
          //LAB_80bf030
          for(r0 = 0; r0 < r1_0._01.get(); r0++) {
            r1_0._1e.get(r0).add(r6);
          }
        }
      } else {
        //LAB_80bf044
        r3 = r3 + 0xdc;
        r4 = 0x80;
        r3 = r3 << 24;
        r4 = r4 << 19;
        if((r3 & 0xffff_ffffL) <= (r4 & 0xffff_ffffL)) {
          r5 = switch(ability.effect_03.get() - 0x24) {
            case 0 -> 0x3f;
            case 1 -> 0x1f;
            case 2 -> 0xf;
            case 3 -> 0x7;
            case 4 -> 0x3;
            default -> 0;
          };

          //LAB_80bf086
          if((lcgRand_() & r5) == 0) {
            //LAB_80bf0a4
            for(r0 = 0; r0 < r1_0._01.get(); r0++) {
              r1_0._2c.get(r0).set(2);
            }
          }
        } else {
          //LAB_80bf0b4
          if(r11 == 0xb2) {
            //LAB_80bf0ca
            for(r6 = 0; r6 < r1_0._01.get(); r6++) {
              r1_0._3a.get(r6).set(FUN_8077178(turn.unitId_00.get(), r1_0._02.get(r6).get(), ability.element_02.get(), ability.effect_03.get(), 100));
            }
          }
        }
      }

      //LAB_80bf0f8
      if((r11 & 0xffff_ffffL) <= 0x206) {
        r2 = MEMORY.ref(4, 0x80c2da0 + r11 * 0x4).get();
        r3 = r1_0._1e.get(0).get();
        r1_0._58.set(r2);
        if(r3 > 1) {
          r3 = r3 << 12;
          r3 = r2 + r3;
          r3 = r3 - 0x1000;
          r1_0._58.set(r3);
        }
      }

      //LAB_80bf11e
      if((r11 & 0xffff_ffffL) < 0x206 && MEMORY.ref(1, 0x80c2b98 + r11).getUnsigned() != 0) {
        r3 = MEMORY.ref(1, 0x80c2b98 + r11).getUnsigned();
        //LAB_80bf138
      } else if(abilityHasCost(r11)) {
        r3 = 0x3;
        //LAB_80bf14a
      } else if(r1_0._58.get() == 0) {
        //LAB_80bf16a
        r3 = 0x1;
      } else if(sp1c.class_129.get() == 0) {
        r3 = 0x8;
      } else {
        //LAB_80bf166
        r3 = 0x3;
      }

      //LAB_80bf16c
      r1_0._54.set(r3);

      if(doesAbilityRevive_(ability.effect_03.get()) != 0) {
        r1_0._58.or(0x10000);
      }

      //LAB_80bf186
      if(r11 == 0xb2 && r1_0._3a.get(0).get() != 0) {
        r1_0._58.or(0x1000);
      }
    }

    //LAB_80bf1a8
    if(turn._06.get() == 2) {
      r3 = r1_0._54.get();
      if(r3 != 0x5 && r3 != 0x9) {
        r1_0._54.set(4);
      }
    }

    //LAB_80bf1c6
    r1_0._48.set(turn._06.get());

    //LAB_80bf1d4
    //LAB_80bf1d6
    CPU.sp().value += 0x30;
    return 0;
  }

  @Method(0x80bf208)
  public static int FUN_80bf208(final int unitId, final int r1, final int r2) {
    if(r1 <= 0x5 && (getUnit_(unitId).luck_42.get() * 3 - r1 * 5 + r2) * 655 >= (lcgRand_() & 0xffff)) {
      return 1;
    }

    //LAB_80bf23e
    return 0;
  }

  @Method(0x80bf250)
  public static int FUN_80bf250(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int r0;
    if(unit._132.get() == 0) {
      r0 = 0x0;
    } else {
      unit._132.decr();
      if(unit._132.get() == 0) {
        unit._133.set(0);
        r0 = 0x1;
        //LAB_80bf282
      } else if(unit._133.get() < 0 && FUN_80bf208(unitId, unit._132.get(), 30) != 0) {
        unit._133.set(0);
        unit._132.set(0);
        r0 = 0x1;
      } else {
        //LAB_80bf2a4
        r0 = 0x0;
      }
    }

    //LAB_80bf2a6
    return r0;
  }

  @Method(0x80bf574)
  public static int FUN_80bf574(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    if(unit._146.get() != 0) {
      unit._146.decr();
      if(unit._146.get() == 0) {
        unit._147.set(0);
        return 1;
      }
    }

    //LAB_80bf59e
    return 0;
  }

  @Method(0x80bf2b4)
  public static int FUN_80bf2b4(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._134.get() == 0) {
      ret = 0x0;
    } else {
      unit._134.decr();
      if(unit._134.get() == 0) {
        unit._135.set(0);
        ret = 0x1;
        //LAB_80bf2e6
      } else if(unit._135.get() < 0 && FUN_80bf208(unitId, unit._134.get(), 20) != 0) {
        unit._135.set(0);
        unit._134.set(0);
        ret = 0x1;
      } else {
        //LAB_80bf308
        ret = 0x0;
      }
    }

    //LAB_80bf30a
    return ret;
  }

  @Method(0x80bf318)
  public static int FUN_80bf318(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._136.get() == 0) {
      ret = 0x0;
    } else {
      unit._136.decr();
      if(unit._136.get() == 0) {
        unit._137.set(0);
        ret = 0x1;
        //LAB_80bf34a
      } else if(unit._137.get() < 0 && FUN_80bf208(unitId, unit._136.get(), 20) != 0) {
        unit._137.set(0);
        unit._136.set(0);
        ret = 0x1;
      } else {
        //LAB_80bf36c
        ret = 0x0;
      }
    }

    //LAB_80bf36e
    return ret;
  }

  @Method(0x80bf37c)
  public static int FUN_80bf37c(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._138.get() == 0) {
      ret = 0x0;
    } else {
      unit._138.decr();
      if(unit._138.get() != 0) {
        if(FUN_80bf208(unitId, unit._138.get(), 30) != 0) {
          unit._138.set(0);
          ret = 0x1;
        } else {
          //LAB_80bf3b4
          ret = 0x0;
        }
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf3b6
    return ret;
  }

  @Method(0x80bf3bc)
  public static int FUN_80bf3bc(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._139.get() == 0) {
      ret = 0x0;
    } else {
      unit._139.decr();
      if(unit._139.get() != 0) {
        if(FUN_80bf208(unitId, unit._139.get(), 60) != 0) {
          unit._139.set(0);
          ret = 0x1;
        } else {
          //LAB_80bf3f2
          ret = 0x0;
        }
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf3f4
    return ret;
  }

  @Method(0x80bf400)
  public static int FUN_80bf400(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13a.get() == 0) {
      ret = 0x0;
    } else {
      unit._13a.decr();
      if(unit._13a.get() != 0) {
        if(FUN_80bf208(unitId, unit._13a.get(), 70) != 0) {
          unit._13a.set(0);
          ret = 0x1;
        } else {
          //LAB_80bf438
          ret = 0x0;
        }
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf43a
    return ret;
  }

  @Method(0x80bf440)
  public static int FUN_80bf440(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13b.get() == 0) {
      ret = 0x0;
    } else {
      unit._13b.decr();
      if(unit._13b.get() != 0) {
        if(FUN_80bf208(unitId, unit._13b.get(), 40) != 0) {
          unit._13b.set(0);
          ret = 0x1;
        } else {
          //LAB_80bf476
          ret = 0x0;
        }
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf478
    return ret;
  }

  @Method(0x80bf484)
  public static int FUN_80bf484(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13c.get() == 0) {
      ret = 0;
    } else {
      unit._13c.decr();
      if(unit._13c.get() != 0) {
        if(FUN_80bf208(unitId, unit._13c.get(), 50) != 0) {
          unit._13c.set(0);
          ret = 0x1;
        } else {
          //LAB_80bf4bc
          ret = 0x0;
        }
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf4be
    return ret;
  }

  @Method(0x80bf4c4)
  public static int FUN_80bf4c4(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13d.get() == 0) {
      ret = 0x0;
    } else {
      if(unit._13d.get() > 7) {
        unit._13d.sub(8);
      }

      //LAB_80bf4e2
      if((unit._13d.get() & 0x7) != 0) {
        unit._13d.decr();
      }

      //LAB_80bf4f2
      if(unit._13d.get() == 0) {
        ret = 0x1;
      } else if(unit._13d.get() > 7) {
        ret = 0x0;
      } else if(FUN_80bf208(unitId, unit._13d.get(), 30) != 0) {
        unit._13d.set(0);
        ret = 0x1;
      } else {
        //LAB_80bf516
        ret = 0x0;
      }
    }

    //LAB_80bf518
    return ret;
  }

  @Method(0x80bf524)
  public static int FUN_80bf524(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13e.get() == 0) {
      ret = 0x0;
    } else {
      unit._13e.decr();
      if(unit._13e.get() != 0) {
        //LAB_80bf544
        ret = 0x0;
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf546
    return ret;
  }

  @Method(0x80bf54c)
  public static int FUN_80bf54c(final int unitId) {
    final Unit14c unit = getUnit_(unitId);
    final int ret;
    if(unit._13f.get() == 0) {
      ret = 0x0;
    } else {
      unit._13f.decr();
      if(unit._13f.get() != 0) {
        //LAB_80bf56a
        ret = 0x0;
      } else {
        ret = 0x1;
      }
    }

    //LAB_80bf56c
    return ret;
  }

  @Method(0x80bf5a8)
  public static boolean tickRecoveryQueue() {
    final RecoveryQueue10c queue = getDjinnRecoveryQueue_(0);

    //LAB_80bf5ce
    for(int queueIndex = 0; queueIndex < queue.count_108.get(); queueIndex++) {
      if(queue.djinn_08.get(queueIndex).turnsRemaining_03.get() > 0) {
        final Unit14c r0 = getUnit_(queue.djinn_08.get(queueIndex).charId_02.get());
        if(r0.hp_38.get() != 0) {
          queue.djinn_08.get(queueIndex).turnsRemaining_03.decr();
        }
      }

      //LAB_80bf5ee
    }

    //LAB_80bf600
    //LAB_80bf612
    boolean recovered = false;
    for(int queueIndex = 0; queueIndex < queue.count_108.get(); ) {
      if(queue.djinn_08.get(queueIndex).turnsRemaining_03.get() == 0) {
        final int charId = queue.djinn_08.get(queueIndex).charId_02.get();
        setDjinn_(charId, queue.djinn_08.get(queueIndex).element_00.get(), queue.djinn_08.get(queueIndex).djinn_01.get());
        recoverDjinn_(charId, queue.djinn_08.get(queueIndex).element_00.get(), queue.djinn_08.get(queueIndex).djinn_01.get());
        recalcStats_(charId);
        recovered = true;
      } else {
        //LAB_80bf63a
        queueIndex++;
      }

      //LAB_80bf640
    }

    //LAB_80bf64c
    return recovered;
  }

  @Method(0x80bf674)
  public static void FUN_80bf674() {
    // no-op
  }

  @Method(0x80bf678)
  public static void FUN_80bf678() {
    final int r1;
    int r2;
    int r3;
    int r8;
    int r9;
    int r10;
    int r11;

    CPU.sp().value -= 0x30;
    final BattleStruct82c sp08 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r2 = sp08._44.get();
    r11 = (-r2 | r2) >>> 31;
    r11++;
    r9 = 0;

    //LAB_80bf6aa
    while(r9 < r11) {
      final RecoveryQueue10c queue = getDjinnRecoveryQueue_(r9);

      //LAB_80bf6ca
      for(r8 = 0; r8 < queue.count_108.get(); r8++) {
        if(queue.djinn_08.get(r8).turnsRemaining_03.get() > 0) {
          if(getCombatantForUnit(queue.djinn_08.get(r8).charId_02.get()) != null) {
            if(getUnit_(queue.djinn_08.get(r8).charId_02.get()).hp_38.get() != 0) {
              queue.djinn_08.get(r8).turnsRemaining_03.decr();
            }
          }
        }

        //LAB_80bf6f0
      }

      //LAB_80bf700
      //LAB_80bf712
      for(r8 = 0; r8 < queue.count_108.get(); ) {
        if(queue.djinn_08.get(r8).turnsRemaining_03.get() == 0) {
          final int unitId = queue.djinn_08.get(r8).charId_02.get();
          if(getCombatantForUnit(unitId) != null) {
            FUN_80bdfec();
            FUN_80bd808(30);
            FUN_80bbabc(0, unitId);
            FUN_80bbabc(3, queue.djinn_08.get(r8).element_00.get() * 20 + queue.djinn_08.get(r8).djinn_01.get() + 300);
            FUN_80bbabc(14, 175);
            FUN_80bbabc(10, 0);
            FUN_80bbabc(4, 2199);
            FUN_80bbabc(11, unitId);
            playSound_(0xd4);
            setActorAnimation_(getCombatantForUnit(unitId).actor_00.deref(), 3);
            FUN_8009088(getCombatantForUnit(unitId).actor_00.deref(), 0x20);
            setDjinn_(unitId, queue.djinn_08.get(r8).element_00.get(), queue.djinn_08.get(r8).djinn_01.get());
            recoverDjinn_(unitId, queue.djinn_08.get(r8).element_00.get(), queue.djinn_08.get(r8).djinn_01.get());
            recalcStats_(unitId);
            FUN_80c1798(unitId, queue.djinn_08.get(r8).element_00.get(), 3, 0);
            FUN_80be02c();
          }
        } else {
          //LAB_80bf7c0
          r8++;
        }

        //LAB_80bf7c6
      }

      //LAB_80bf7d2
      r9++;
    }

    //LAB_80bf7de
    FUN_80c0774(2, boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new).backgroundPointerTableId_648.get(), 0);
    r3 = 0x80c35bc;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(MEMORY.ref(4, r3).get());
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(MEMORY.ref(4, r3 + 0x4).get());

    if(sp08._44.get() == 0) {
      //LAB_80bf81c
      r3 = CPU.sp().value + 0xc;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
    } else if(sp08._50.get() != 0) {
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(2);
      r2 = CPU.sp().value + 0xc;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      MEMORY.ref(4, r2 + 0x4).setu(1);
    } else {
      //LAB_80bf824
      r1 = CPU.sp().value + 0xc;
      MEMORY.ref(4, CPU.sp().value).setu(r1);
    }

    //LAB_80bf82a
    r9 = 0;
    final int[] unitIds = new int[15];

    //LAB_80bf834
    do {
      r2 = MEMORY.ref(4, CPU.sp().value).get();
      r10 = getUnitIds(MEMORY.ref(4, r2 + r9 * 0x4).get(), unitIds);
      r8 = 0;

      //LAB_80bf84e
      while(r8 < r10) {
        final int unitId = unitIds[r8];
        final Unit14c r7 = getUnit_(unitId);
        if(r7.kiteTurns_144.get() != 0) {
          r7.kiteTurns_144.decr();
        }

        //LAB_80bf870
        final int hp = r7.hp_38.get();
        if(hp != 0) {
          if(r7.recoveryHp_44.get() != 0) {
            final int maxHp = r7.maxHp_34.get();
            if(hp != maxHp) {
              int recovery = r7.recoveryHp_44.get();
              if(hp + recovery > maxHp) {
                recovery = maxHp - hp;
              }

              //LAB_80bf894
              addHp_(unitId, recovery);
              FUN_8015120(unitId, 1);
              FUN_8015120(recovery, 5);

              if(r7.hp_38.get() == r7.maxHp_34.get()) {
                FUN_80151c8(0x820);
              } else {
                //LAB_80bf8c0
                FUN_80151c8(0x81d);
              }

              //LAB_80bf8c6
              playSound_(0xaf);
              FUN_80bb65c();
            }
          }

          //LAB_80bf8d0
          if(r7.recoveryPp_45.get() != 0) {
            final int pp = r7.pp_3a.get();
            final int maxPp = r7.maxPp_36.get();

            if(pp != maxPp) {
              int recovery = r7.recoveryPp_45.get();
              if(pp + recovery > maxPp) {
                recovery = maxPp - pp;
              }

              //LAB_80bf8f0
              addPp_(unitId, recovery);
              FUN_8015120(unitId, 1);
              FUN_8015120(recovery, 5);
              if(r7.pp_3a.get() == r7.maxPp_36.get()) {
                FUN_80151c8(0x821);
              } else {
                //LAB_80bf934
                FUN_80151c8(0x81e);
              }

              //LAB_80bf93a
              playSound_(0xaf);
              FUN_80bb65c();
            }
          }
        }

        //LAB_80bf944
        if(FUN_80bf574(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x889);
          FUN_80bb65c();
        }

        //LAB_80bf96e
        if(FUN_80bf250(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x887);
          FUN_80bb65c();
        }

        //LAB_80bf998
        if(FUN_80bf2b4(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x888);
          FUN_80bb65c();
        }

        //LAB_80bf9c2
        if(FUN_80bf318(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x886);
          FUN_80bb65c();
        }

        //LAB_80bf9ec
        if(FUN_80bf37c(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x88b);
          FUN_80bb65c();
        }

        //LAB_80bfa16
        if(FUN_80bf3bc(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x88a);
          FUN_80bb65c();
        }

        //LAB_80bfa40
        if(FUN_80bf400(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x88e);
          FUN_80bb65c();
        }

        //LAB_80bfa6a
        if(FUN_80bf440(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80b7aac(unitId);
          FUN_80151c8(0x88d);
          FUN_80bb65c();
        }

        //LAB_80bfa9a
        if(FUN_80bf484(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80b7aac(unitId);
          FUN_80151c8(0x883);
          FUN_80bb65c();
        }

        //LAB_80bfaca
        if(FUN_80bf4c4(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x88c);
          FUN_80bb65c();
        }

        //LAB_80bfaf4
        if(FUN_80bf524(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x891);
          FUN_80bb65c();
        }

        //LAB_80bfb1e
        if(FUN_80bf54c(unitId) != 0) {
          FUN_80b78e4(unitId, getCombatantForUnit(unitId));
          FUN_8015120(unitId, 1);
          FUN_80151c8(0x892);
          FUN_80bb65c();
        }

        //LAB_80bfb48
        r8++;
      }

      //LAB_80bfb52
      r9++;
    } while(r9 < 2);

    //LAB_80bfb5e
    CPU.sp().value += 0x30;
  }


  @Method(0x80bfba4)
  public static void FUN_80bfba4(final BattleStruct82c.Sub64 r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;
    int r10;
    int r12;

    CPU.sp().value -= 0x20;
    final int charId = r0.unitId_00.get();
    int sp04 = 0;
    final Unit14c sp08 = getUnit_(charId);
    final RecoveryQueue10c r6 = getDjinnRecoveryQueue_(charId > 7 ? 1 : 0);

    //LAB_80bfbf0
    for(r7 = 0; r7 < r6.count_108.get(); r7++) {
      if(r6.djinn_08.get(r7).charId_02.get() == charId && r6.djinn_08.get(r7).turnsRemaining_03.get() == -1) {
        FUN_80771b8(charId, r6.djinn_08.get(r7).element_00.get(), r6.djinn_08.get(r7).djinn_01.get());
      }

      //LAB_80bfc08
    }

    //LAB_80bfc18
    if(getLivingUnitIds(0x1, null) != 0 && getLivingUnitIds(0x2, null) != 0) {
      sp04 = 1;
    }

    //LAB_80bfc34
    final int sp00 = CPU.sp().value + 0x10;
    r12 = sp00;
    r3 = CPU.sp().value + 0x1c;

    //LAB_80bfc54
    do {
      MEMORY.ref(4, r3).setu(0);
      r3 = r3 - 0x4;
    } while(r3 >= r12);

    //LAB_80bfc6a
    do {
      r12 = -1;

      //LAB_80bfc86
      for(r4 = 0; r4 < r6.count_108.get(); r4++) {
        if(r6.djinn_08.get(r4).turnsRemaining_03.get() == -2) {
          r12 = r6.djinn_08.get(r4).charId_02.get();
          break;
        }
      }

      //LAB_80bfc9e
      if(r12 == -1) {
        break;
      }

      r5 = -1;

      //LAB_80bfcb4
      for(r4 = 0; r4 < r6.count_108.get(); r4++) {
        if(r6.djinn_08.get(r4).charId_02.get() == r12) {
          r3 = r6.djinn_08.get(r4).turnsRemaining_03.get();
          if(r5 < r3) {
            r5 = r3;
          }
        }

        //LAB_80bfcc4
      }

      //LAB_80bfccc
      r5++;
      if(r5 < 2) {
        r5 = 2;
      }

      //LAB_80bfcd4
      //LAB_80bfcee
      for(r4 = 0; r4 < r6.count_108.get(); r4++) {
        if(r6.djinn_08.get(r4).charId_02.get() == r12 && r6.djinn_08.get(r4).turnsRemaining_03.get() == -2) {
          r2 = r6.djinn_08.get(r4).element_00.get();
          r6.djinn_08.get(r4).turnsRemaining_03.set(r5);
          MEMORY.ref(4, sp00 + r2 * 0x4).incr();
          r5++;
        }

        //LAB_80bfd0a
      }
    } while(true);

    //LAB_80bfd18
    if(sp04 != 0) {
      //LAB_80bfd20
      r5 = 0x14c;
      r10 = 0;
      final int r9 = mallocBoard(r5);
      MEMORY.call(0x3001388, r9, sp08.getAddress(), r5); // memcpy
      r7 = -1;

      //LAB_80bfd42
      for(int i = 0; i < 4; i++) {
        r3 = MEMORY.ref(4, sp00 + i * 0x4).get();
        if(r10 < r3) {
          r10 = r3;
          r7 = i;
        }

        //LAB_80bfd4c
      }

      if(r7 >= 0) {
        if(sp08.summonBoosts_12c.get(r7).get() < r10) {
          sp08.summonBoosts_12c.get(r7).set(r10);
        }
      }

      //LAB_80bfd68
      recalcStats_(charId);

      //LAB_80bfd72
      for(int i = 0; i < 4; i++) {
        r5 = sp08.elementalPowerResist_48.get(i).power_00.get() - MEMORY.ref(2, r9 + 0x48 + i * 0x4).get();
        if(r5 > 0) {
          FUN_80bdfec();
          FUN_80bd808(0x19);
          FUN_80bbabc(0, charId);
          FUN_80bbabc(1, r5);
          FUN_80bbabc(14, 0xaf);
          FUN_80bbabc(4, i + 0x879);
          FUN_80bbabc(11, charId);
          playSound_(0xd4);
          setActorAnimation_(getCombatantForUnit(charId).actor_00.deref(), 3);
          FUN_8009088(getCombatantForUnit(charId).actor_00.deref(), 32);
          FUN_80c1798(charId, i, 2, r10 - 1);
          FUN_80be02c();
        }

        //LAB_80bfde8
      }

      setMallocAddress(r9);

      if(sp04 != 0) {
        //LAB_80bfdfe
        FUN_80bdfec();

        if(r0._60.get() != 0) {
          FUN_80bbabc(8, charId);
          FUN_80bbabc(0, charId);
          FUN_80bbabc(1, r0._60.get());
          FUN_80bbabc(4, 0x84b);

          if(addHp_(charId, -r0._60.get()) == 0) {
            FUN_80bbabc(9, charId);
            FUN_80bbabc(0, charId);

            if((charId & 0xffff_ffffL) < 8) {
              r1 = 0x825;
            } else {
              //LAB_80bfe56
              r1 = 0x82b;
            }

            //LAB_80bfe58
            FUN_80bbabc(4, r1);
          } else {
            //LAB_80bfe60
            FUN_80bbabc(11, charId);
          }
        }

        //LAB_80bfe68
        FUN_80bb938();
        FUN_80bdfec();

        if(sp08.affliction_131.get() != 0) {
          r7 = divideS(sp08.affliction_131.get() * sp08.maxHp_34.get(), 10);
          final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
          FUN_80bbabc(8, charId);
          FUN_80bbabc(0, charId);
          FUN_80bbabc(1, r7);
          FUN_80bbabc(4, 0x851);

          if(sp08.affliction_131.get() != 0) {
            r3 = 0x86;
          } else {
            //LAB_80bfec2
            r3 = 0x85;
          }

          //LAB_80bfeca
          struct._820.set(r3);

          if(addHp_(charId, -r7) == 0) {
            FUN_80bbabc(9, charId);
            FUN_80bbabc(0, charId);

            if((charId & 0xffff_ffffL) < 8) {
              r1 = 0x825;
            } else {
              //LAB_80bfef2
              r1 = 0x82b;
            }

            //LAB_80bfef4
            FUN_80bbabc(4, r1);
          } else {
            //LAB_80bfefc
            FUN_80bbabc(11, charId);
          }
        }

        //LAB_80bff04
        FUN_80bb938();
        FUN_80bdfec();

        if(sp08._141.get() != 0) {
          sp08._141.decr();

          if(sp08._141.get() == 0) {
            if(addHp_(charId, 0xc0000000) == 0) {
              FUN_80bbabc(0, charId);
              FUN_80bbabc(4, 0x828);
              FUN_80bbabc(8, charId);
              FUN_80bbabc(9, charId);
              FUN_80bbabc(0, charId);

              if((charId & 0xffff_ffffL) < 8) {
                FUN_80bbabc(4, 0x825);
              } else {
                //LAB_80bff6c
                FUN_80bbabc(4, 0x82b);
              }
            }
          }
        }

        //LAB_80bff74
        FUN_80bb938();
      }
    }

    //LAB_80bff78
    recalcStats_(charId);
    CPU.sp().value += 0x20;
  }
}
