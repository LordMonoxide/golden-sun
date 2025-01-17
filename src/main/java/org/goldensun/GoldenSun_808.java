package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.input.Input;
import org.goldensun.maps.Map121Overlay_87d0e88;
import org.goldensun.maps.Map132Overlay_87ced6c;
import org.goldensun.maps.Map15Overlay_878de18;
import org.goldensun.maps.Map19Overlay_878dee8;
import org.goldensun.maps.Map3Overlay_877dd1c;
import org.goldensun.maps.Map4Overlay_8780898;
import org.goldensun.maps.Map5Overlay_8784360;
import org.goldensun.maps.Map6Overlay_878603c;
import org.goldensun.maps.Map7Overlay_8786f0c;
import org.goldensun.maps.Map8Overlay_8787e04;
import org.goldensun.maps.Map9Overlay_87892c8;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.EventStruct0c;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.FieldPsynergyRange04;
import org.goldensun.types.Map194;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Structccc;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.Unit14c;
import org.goldensun.types.VblankTransfer0c;
import org.goldensun.types.Vec3;

import static org.goldensun.CopiedSegment8000770.FUN_300013c;
import static org.goldensun.CopiedSegment8000770.FUN_3000380;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.GoldenSun.FUN_8004760;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.FUN_80090a0;
import static org.goldensun.GoldenSun.FUN_80090a8;
import static org.goldensun.GoldenSun.FUN_80090b0;
import static org.goldensun.GoldenSun.FUN_80090b8;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_8009118;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009130;
import static org.goldensun.GoldenSun.FUN_8009138;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_80091e0;
import static org.goldensun.GoldenSun.FUN_8009230;
import static org.goldensun.GoldenSun.FUN_8009238;
import static org.goldensun.GoldenSun.FUN_8009268;
import static org.goldensun.GoldenSun.addLayerToSpriteIfRegularSprite_;
import static org.goldensun.GoldenSun.addLayerToSprite_;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.atan2;
import static org.goldensun.GoldenSun.clearActor_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearTickCallbacks;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.decompressPointerTableEntry;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.fadeInBrightness;
import static org.goldensun.GoldenSun.fadeOutBrightness;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getHeight_;
import static org.goldensun.GoldenSun.initActors_;
import static org.goldensun.GoldenSun.initMemoryAllocator;
import static org.goldensun.GoldenSun.initVramSlots;
import static org.goldensun.GoldenSun.loadActor_;
import static org.goldensun.GoldenSun.loadMap_;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.moveActorTo_;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.rotVec3;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setActorPosition_;
import static org.goldensun.GoldenSun.setActorSpriteScript_;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars._2000404;
import static org.goldensun.GoldenSunVars._2000406;
import static org.goldensun.GoldenSunVars._2000408;
import static org.goldensun.GoldenSunVars._200040a;
import static org.goldensun.GoldenSunVars._200040c;
import static org.goldensun.GoldenSunVars._200040e;
import static org.goldensun.GoldenSunVars._2000410;
import static org.goldensun.GoldenSunVars._2000412;
import static org.goldensun.GoldenSunVars._2000414;
import static org.goldensun.GoldenSunVars._2000416;
import static org.goldensun.GoldenSunVars._200041a;
import static org.goldensun.GoldenSunVars._200041c;
import static org.goldensun.GoldenSunVars._2000420;
import static org.goldensun.GoldenSunVars._2000424;
import static org.goldensun.GoldenSunVars._2000428;
import static org.goldensun.GoldenSunVars._200042c;
import static org.goldensun.GoldenSunVars._2000430;
import static org.goldensun.GoldenSunVars._2000432;
import static org.goldensun.GoldenSunVars._2000445;
import static org.goldensun.GoldenSunVars._2000446;
import static org.goldensun.GoldenSunVars._200045e;
import static org.goldensun.GoldenSunVars._2000464;
import static org.goldensun.GoldenSunVars._200046c;
import static org.goldensun.GoldenSunVars._200046e;
import static org.goldensun.GoldenSunVars._2000470;
import static org.goldensun.GoldenSunVars._2000472;
import static org.goldensun.GoldenSunVars._2000474;
import static org.goldensun.GoldenSunVars._2000478;
import static org.goldensun.GoldenSunVars._200047c;
import static org.goldensun.GoldenSunVars._200047e;
import static org.goldensun.GoldenSunVars._2000480;
import static org.goldensun.GoldenSunVars._2000482;
import static org.goldensun.GoldenSunVars._200048a;
import static org.goldensun.GoldenSunVars._200048c;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.fieldPsynergyRanges_809e686;
import static org.goldensun.GoldenSunVars.getActors_200801c;
import static org.goldensun.GoldenSunVars.getEvents_2008024;
import static org.goldensun.GoldenSunVars.getLadders_200802c;
import static org.goldensun.GoldenSunVars.getRooms_200800c;
import static org.goldensun.GoldenSunVars.getTransitions_2008014;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.init_2008004;
import static org.goldensun.GoldenSunVars.mapId_2000400;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.GoldenSunVars.vblankTransferQueue_2002090;
import static org.goldensun.GoldenSun_801.FUN_8015000;
import static org.goldensun.GoldenSun_801.FUN_8015040;
import static org.goldensun.GoldenSun_801.FUN_8015058;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015128;
import static org.goldensun.GoldenSun_801.FUN_8015138;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_8015200;
import static org.goldensun.GoldenSun_801.FUN_8015208;
import static org.goldensun.GoldenSun_801.FUN_8015250;
import static org.goldensun.GoldenSun_801.FUN_8015268;
import static org.goldensun.GoldenSun_801.FUN_8015288;
import static org.goldensun.GoldenSun_801.FUN_8015290;
import static org.goldensun.GoldenSun_801.FUN_8015360;
import static org.goldensun.GoldenSun_801.FUN_8015370;
import static org.goldensun.GoldenSun_801.handleIngameMenus_;
import static org.goldensun.GoldenSun_807.FUN_8077098;
import static org.goldensun.GoldenSun_807.addCoins_;
import static org.goldensun.GoldenSun_807.addHp_;
import static org.goldensun.GoldenSun_807.addPp_;
import static org.goldensun.GoldenSun_807.cacheEncounterRateBoost_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getAverageCharLevel_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.giveItem_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_807.takeItem_;
import static org.goldensun.GoldenSun_809.FUN_80901c0;
import static org.goldensun.GoldenSun_809.FUN_80907b0;
import static org.goldensun.GoldenSun_809.FUN_8091200;
import static org.goldensun.GoldenSun_809.FUN_8091220;
import static org.goldensun.GoldenSun_809.FUN_8091240;
import static org.goldensun.GoldenSun_809.FUN_80915dc;
import static org.goldensun.GoldenSun_809.FUN_809163c;
import static org.goldensun.GoldenSun_809.FUN_80916b0;
import static org.goldensun.GoldenSun_809.FUN_8091750;
import static org.goldensun.GoldenSun_809.FUN_8091858;
import static org.goldensun.GoldenSun_809.FUN_80919d8;
import static org.goldensun.GoldenSun_809.FUN_8091a58;
import static org.goldensun.GoldenSun_809.FUN_8091d84;
import static org.goldensun.GoldenSun_809.FUN_809202c;
import static org.goldensun.GoldenSun_809.FUN_8092708;
import static org.goldensun.GoldenSun_809.FUN_8092848;
import static org.goldensun.GoldenSun_809.FUN_8092b94;
import static org.goldensun.GoldenSun_809.FUN_8092f84;
import static org.goldensun.GoldenSun_809.FUN_8093874;
import static org.goldensun.GoldenSun_809.FUN_8093a6c;
import static org.goldensun.GoldenSun_809.FUN_8093c00;
import static org.goldensun.GoldenSun_809.FUN_8093e28;
import static org.goldensun.GoldenSun_809.FUN_8093fa0;
import static org.goldensun.GoldenSun_809.FUN_80941e0;
import static org.goldensun.GoldenSun_809.FUN_8094354;
import static org.goldensun.GoldenSun_809.FUN_8094368;
import static org.goldensun.GoldenSun_809.FUN_8094428;
import static org.goldensun.GoldenSun_809.FUN_8095680;
import static org.goldensun.GoldenSun_809.FUN_8095778;
import static org.goldensun.GoldenSun_809.FUN_8096810;
import static org.goldensun.GoldenSun_809.FUN_8096960;
import static org.goldensun.GoldenSun_809.FUN_8096ab0;
import static org.goldensun.GoldenSun_809.FUN_8096af0;
import static org.goldensun.GoldenSun_809.FUN_8096b28;
import static org.goldensun.GoldenSun_809.FUN_8096c80;
import static org.goldensun.GoldenSun_809.FUN_8097174;
import static org.goldensun.GoldenSun_809.FUN_8097194;
import static org.goldensun.GoldenSun_809.FUN_809728c;
import static org.goldensun.GoldenSun_809.FUN_8099810;
import static org.goldensun.GoldenSun_809.FUN_809ade8;
import static org.goldensun.GoldenSun_809.FUN_809c138;
import static org.goldensun.GoldenSun_809.FUN_809c3a4;
import static org.goldensun.GoldenSun_809.allocatePaletteModifier;
import static org.goldensun.GoldenSun_809.calculatePaletteModificationSteps;
import static org.goldensun.GoldenSun_809.initFieldPsynergy;
import static org.goldensun.GoldenSun_809.setFieldPsynergyTargetAndCaster;
import static org.goldensun.GoldenSun_809.stopPlayerAndSetIdle;
import static org.goldensun.GoldenSun_80b.loadBattle_;
import static org.goldensun.GoldenSun_80b.tickRecoveryQueue_;
import static org.goldensun.GoldenSun_80f.FUN_80f4000;
import static org.goldensun.GoldenSun_80f.FUN_80f6000;
import static org.goldensun.GoldenSun_80f.FUN_80f9070;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getConsumer;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_808 {
  private GoldenSun_808() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(GoldenSun_808.class);

  /** {@link GoldenSun_808#FUN_808a8e4} */
  @Method(0x808a008)
  public static void FUN_808a008(final int r0) {
    MEMORY.call(0x808a8e4, r0);
  }

  /** {@link GoldenSun_809#FUN_809163c} */
  @Method(0x808a010)
  public static void FUN_808a010(final int sleepFrames) {
    MEMORY.call(0x809163c, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_80916b0} */
  @Method(0x808a018)
  public static void FUN_808a018() {
    MEMORY.call(0x80916b0);
  }

  /** {@link GoldenSun_809#FUN_8091750} */
  @Method(0x808a020)
  public static void FUN_808a020() {
    MEMORY.call(0x8091750);
  }

  /** {@link GoldenSun_809#FUN_80917ac} */
  @Method(0x808a030)
  public static void FUN_808a030(final int r0) {
    MEMORY.call(0x80917ac, r0);
  }

  /** {@link GoldenSun_808#FUN_808b868} */
  @Method(0x808a038)
  public static void FUN_808a038(final int r0) {
    MEMORY.call(0x808b868, r0);
  }

  /** {@link GoldenSun_809#FUN_80917d0} */
  @Method(0x808a048)
  public static void FUN_808a048(final int charId, final int r1) {
    MEMORY.call(0x80917d0, charId, r1);
  }

  /** {@link GoldenSun_809#FUN_80917f4} */
  @Method(0x808a050)
  public static void FUN_808a050(final int r0, final int r1) {
    MEMORY.call(0x80917f4, r0, r1);
  }

  /** {@link GoldenSun_809#removeCharAndHealRemainingChars} */
  @Method(0x808a058)
  public static void removeCharAndHealRemainingChars_(final int charId) {
    MEMORY.call(0x8091890, charId);
  }

  /** {@link GoldenSun_809#FUN_8091a58} */
  @Method(0x808a060)
  public static int FUN_808a060(final int r0, final int r1) {
    return (int)MEMORY.call(0x8091a58, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8091c7c} */
  @Method(0x808a070)
  public static int FUN_808a070(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x8091c7c, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#getMapActor_} */
  @Method(0x808a080)
  public static Actor70 getMapActor_(final int mapActorIndex) {
    return (Actor70)MEMORY.call(0x8092054, mapActorIndex);
  }

  /** {@link GoldenSun_809#FUN_8092924} */
  @Method(0x808a088)
  public static void FUN_808a088(final int mapActorIndex) {
    MEMORY.call(0x8092924, mapActorIndex);
  }

  /** {@link GoldenSun_809#setActorVelocityScalerAndAcceleration} */
  @Method(0x808a090)
  public static void setActorVelocityScalerAndAcceleration_(final int mapActorIndex, final int velocityScaler, final int acceleration) {
    MEMORY.call(0x8092064, mapActorIndex, velocityScaler, acceleration);
  }

  /** {@link GoldenSun_809#FUN_809207c} */
  @Method(0x808a098)
  public static void FUN_808a098(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x809207c, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_809#FUN_80920e8} */
  @Method(0x808a0a0)
  public static void FUN_808a0a0(final int actorIndex) {
    MEMORY.call(0x80920e8, actorIndex);
  }

  /** {@link GoldenSun_809#FUN_80920a0} */
  @Method(0x808a0a8)
  public static void FUN_808a0a8(final int mapActorIndex) {
    MEMORY.call(0x80920a0, mapActorIndex);
  }

  /** {@link GoldenSun_809#FUN_80920fc} */
  @Method(0x808a0b0)
  public static void FUN_808a0b0(final int mapActorIndex, final int spriteScript) {
    MEMORY.call(0x80920fc, mapActorIndex, spriteScript);
  }

  /** {@link GoldenSun_809#FUN_8092128} */
  @Method(0x808a0b8)
  public static void FUN_808a0b8(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x8092128, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_809#FUN_8092158} */
  @Method(0x808a0c0)
  public static void FUN_808a0c0(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x8092158, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_809#FUN_809218c} */
  @Method(0x808a0c8)
  public static void FUN_808a0c8(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x809218c, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_809#FUN_80921c4} */
  @Method(0x808a0d0)
  public static void FUN_808a0d0(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x80921c4, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_809#FUN_8092208} */
  @Method(0x808a0d8)
  public static void FUN_808a0d8(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8092208, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_809228c} */
  @Method(0x808a0e0)
  public static void FUN_808a0e0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x809228c, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_80923c4} */
  @Method(0x808a0e8)
  public static void FUN_808a0e8(final int mapActorIndex) {
    MEMORY.call(0x80923c4, mapActorIndex);
  }

  /** {@link GoldenSun_809#moveActorToPosition} */
  @Method(0x808a0f0)
  public static void moveActorToPosition_(final int mapActorIndex, final int x, final int z) {
    MEMORY.call(0x80923e4, mapActorIndex, x, z);
  }

  /** {@link GoldenSun_809#setActorAnimationIfLoaded} */
  @Method(0x808a100)
  public static void setActorAnimationIfLoaded_(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x80924d4, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_809#setActorAnimationAndWaitUntilFinished} */
  @Method(0x808a110)
  public static void setActorAnimationAndWaitUntilFinished_(final int mapActorIndex, final int animationIndex) {
    MEMORY.call(0x8092548, mapActorIndex, animationIndex);
  }

  /** {@link GoldenSun_809#waitForActorAnimationToChange} */
  @Method(0x808a118)
  public static void waitForActorAnimationToChange_(final int actorIndex) {
    MEMORY.call(0x8092504, actorIndex);
  }

  /** {@link GoldenSun_809#FUN_8092560} */
  @Method(0x808a128)
  public static void FUN_808a128(final int mapActorIndex, final int velocityY, final int sleepFrames) {
    MEMORY.call(0x8092560, mapActorIndex, velocityY, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_809259c} */
  @Method(0x808a130)
  public static void FUN_808a130(final int mapActorIndex, final int r1) {
    MEMORY.call(0x809259c, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_80925cc} */
  @Method(0x808a138)
  public static void FUN_808a138(final int mapActorIndex, final int r1) {
    MEMORY.call(0x80925cc, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_809280c} */
  @Method(0x808a148)
  public static void FUN_808a148(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x809280c, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_8092848} */
  @Method(0x808a150)
  public static void FUN_808a150(final int mapActorIndex1, final int mapActorIndex2, final int sleepFrames) {
    MEMORY.call(0x8092848, mapActorIndex1, mapActorIndex2, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_8092950} */
  @Method(0x808a158)
  public static void FUN_808a158(final int mapActorIndex, final int r1) {
    MEMORY.call(0x8092950, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_80929d8} */
  @Method(0x808a160)
  public static void FUN_808a160(final Actor70 r0, final int r1) {
    MEMORY.call(0x80929d8, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8092a1c} */
  @Method(0x808a168)
  public static void FUN_808a168(final int mapActorIndex1, final int mapActorIndex2AndFlags, final int r2) {
    MEMORY.call(0x8092a1c, mapActorIndex1, mapActorIndex2AndFlags, r2);
  }

  /** {@link GoldenSun_809#FUN_8092b94} */
  @Method(0x808a170)
  public static void FUN_808a170(final int r0) {
    MEMORY.call(0x8092b94, r0);
  }

  /** {@link GoldenSun_809#FUN_8092c40} */
  @Method(0x808a178)
  public static Panel24 FUN_808a178(final int mapActorIndex) {
    return (Panel24)MEMORY.call(0x8092c40, mapActorIndex);
  }

  /** {@link GoldenSun_809#FUN_8092f84} */
  @Method(0x808a180)
  public static void FUN_808a180(final int mapActorIndex, final int r1) {
    MEMORY.call(0x8092f84, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_8093040} */
  @Method(0x808a188)
  public static void FUN_808a188(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x8093040, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_8093054} */
  @Method(0x808a190)
  public static int FUN_808a190(final int mapActorIndex, final int r1) {
    return (int)MEMORY.call(0x8093054, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_8092adc} */
  @Method(0x808a1b8)
  public static void FUN_808a1b8(final int mapActorIndex, final int r1, final int sleepFrames) {
    MEMORY.call(0x8092adc, mapActorIndex, r1, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_80931ec} */
  @Method(0x808a1d0)
  public static void FUN_808a1d0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5, final int a6, final int a7, final int a8, final int a9) {
    MEMORY.call(0x80931ec, r0, r1, r2, r3, a4, a5, a6, a7, a8, a9);
  }

  /** {@link GoldenSun_809#FUN_8093304} */
  @Method(0x808a1d8)
  public static void FUN_808a1d8(final int r0) {
    MEMORY.call(0x8093304, r0);
  }

  /** {@link GoldenSun_809#setActorPriority} */
  @Method(0x808a1e0)
  public static void setActorPriority_(final int mapActorIndex, final int priority) {
    MEMORY.call(0x8092b08, mapActorIndex, priority);
  }

  /** {@link GoldenSun_809#FUN_80937b8} */
  @Method(0x808a1e8)
  public static void FUN_808a1e8(final int mapActorIndex, final int animationAndFlags, final int sleepFrames) {
    MEMORY.call(0x80937b8, mapActorIndex, animationAndFlags, sleepFrames);
  }

  /** {@link GoldenSun_809#FUN_8093874} */
  @Method(0x808a1f0)
  public static void FUN_808a1f0(final int mapActorIndex, final int r1) {
    MEMORY.call(0x8093874, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_809335c} */
  @Method(0x808a200)
  public static void FUN_808a200(final int actorIndex, final int r1) {
    MEMORY.call(0x809335c, actorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_80933d4} */
  @Method(0x808a208)
  public static void FUN_808a208(final int velocityScalar, final int acceleration) {
    MEMORY.call(0x80933d4, velocityScalar, acceleration);
  }

  /** {@link GoldenSun_809#FUN_80933f8} */
  @Method(0x808a210)
  public static void FUN_808a210(final int x, final int y, final int z, final int r3) {
    MEMORY.call(0x80933f8, x, y, z, r3);
  }

  /** {@link GoldenSun_809#FUN_8093530} */
  @Method(0x808a218)
  public static void FUN_808a218() {
    MEMORY.call(0x8093530);
  }

  /** {@link GoldenSun_809#FUN_8093500} */
  @Method(0x808a220)
  public static void FUN_808a220(final int mapActorIndex, final int r1) {
    MEMORY.call(0x8093500, mapActorIndex, r1);
  }

  /** {@link GoldenSun_809#FUN_8093554} */
  @Method(0x808a228)
  public static Actor70 FUN_808a228() {
    return (Actor70)MEMORY.call(0x8093554);
  }

  /** {@link GoldenSun_809#setMapAndEntranceId} */
  @Method(0x808a238)
  public static void setMapAndEntranceId_(final int mapId, final int entranceId) {
    MEMORY.call(0x8091e3c, mapId, entranceId);
  }

  /** {@link GoldenSun_809#FUN_8091e9c} */
  @Method(0x808a248)
  public static void FUN_808a248(final int r0) {
    MEMORY.call(0x8091e9c, r0);
  }

  /** {@link GoldenSun_809#startEncounter} */
  @Method(0x808a250)
  public static void startEncounter_(final int encounterSet, final int encounterId) {
    MEMORY.call(0x8091eb0, encounterSet, encounterId);
  }

  /** {@link GoldenSun_809#FUN_8091f90} */
  @Method(0x808a260)
  public static void FUN_808a260(final int r0, final int r1) {
    MEMORY.call(0x8091f90, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8091fa8} */
  @Method(0x808a268)
  public static void FUN_808a268(final int r0, final int r1) {
    MEMORY.call(0x8091fa8, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8094154} */
  @Method(0x808a278)
  public static void FUN_808a278(final int actorIndex, final int r1) {
    MEMORY.call(0x8094154, actorIndex, r1);
  }

  /** {@link GoldenSun_808#getInteractedTileType} */
  @Method(0x808a280)
  public static int getInteractedTileType_() {
    return (int)MEMORY.call(0x808ce74);
  }

  /** {@link GoldenSun_808#FUN_808b398} */
  @Method(0x808a288)
  public static int FUN_808a288(final int r0) {
    return (int)MEMORY.call(0x808b398, r0);
  }

  /** {@link GoldenSun_809#FUN_8093e28} */
  @Method(0x808a2a8)
  public static int FUN_808a2a8() {
    return (int)MEMORY.call(0x8093e28);
  }

  /** {@link GoldenSun_809#FUN_8093fa0} */
  @Method(0x808a2b0)
  public static int FUN_808a2b0() {
    return (int)MEMORY.call(0x8093fa0);
  }

  /** {@link GoldenSun_809#allocateRain} */
  @Method(0x808a2c0)
  public static void FUN_808a2c0() {
    MEMORY.call(0x8094ac8);
  }

  /** {@link GoldenSun_809#allocateLightning} */
  @Method(0x808a2c8)
  public static void FUN_808a2c8() {
    MEMORY.call(0x8095160);
  }

  /** {@link GoldenSun_809#FUN_8095214} */
  @Method(0x808a2d0)
  public static void FUN_808a2d0() {
    MEMORY.call(0x8095214);
  }

  /** {@link GoldenSun_809#FUN_8095240} */
  @Method(0x808a2d8)
  public static void FUN_808a2d8() {
    MEMORY.call(0x8095240);
  }

  /** {@link GoldenSun_809#FUN_8095268} */
  @Method(0x808a2e0)
  public static void FUN_808a2e0() {
    MEMORY.call(0x8095268);
  }

  /** {@link GoldenSun_809#FUN_809509c} */
  @Method(0x808a2f8)
  public static void FUN_808a2f8() {
    MEMORY.call(0x809509c);
  }

  /** {@link GoldenSun_809#FUN_8091200} */
  @Method(0x808a330)
  public static void FUN_808a330(final int r0, final int r1) {
    MEMORY.call(0x8091200, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_8091220} */
  @Method(0x808a338)
  public static void FUN_808a338(final int r0, final int r1) {
    MEMORY.call(0x8091220, r0, r1);
  }

  /** {@link GoldenSun_809#calculatePaletteModificationSteps} */
  @Method(0x808a348)
  public static void FUN_808a348(final int r0) {
    MEMORY.call(0x8091254, r0);
  }

  /** {@link GoldenSun_809#FUN_8091dc8} */
  @Method(0x808a360)
  public static void FUN_808a360() {
    MEMORY.call(0x8091dc8);
  }

  /** {@link GoldenSun_809#FUN_8091df4} Called after confirming character names */
  @Method(0x808a368)
  public static void FUN_808a368() {
    MEMORY.call(0x8091df4);
  }

  /** {@link GoldenSun_809#FUN_8091e20} */
  @Method(0x808a370)
  public static void FUN_808a370() {
    MEMORY.call(0x8091e20);
  }

  /** {@link GoldenSun_808#FUN_808f1c0} */
  @Method(0x808a398)
  public static void FUN_808a398(final int r0, final int r1) {
    MEMORY.call(0x808f1c0, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808edac} */
  @Method(0x808a3c0)
  public static void FUN_808a3c0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808edac, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_8091494} */
  @Method(0x808a408)
  public static void FUN_808a408(final Actor70 r0) {
    MEMORY.call(0x8091494, r0);
  }

  /** {@link GoldenSun_809#FUN_80967e4} */
  @Method(0x808a420)
  public static void FUN_808a420(final int r0) {
    MEMORY.call(0x80967e4, r0);
  }

  /** {@link GoldenSun_809#initFieldPsynergy} */
  @Method(0x808a428)
  public static void FUN_808a428(final int r0, final int r1) {
    MEMORY.call(0x8096fb0, r0, r1);
  }

  /** {@link GoldenSun_809#setFieldPsynergyTargetAndCaster} */
  @Method(0x808a430)
  public static void setFieldPsynergyTargetAndCaster_(final int casterMapActorIndex, final int targetMapActorIndex) {
    MEMORY.call(0x80970f8, casterMapActorIndex, targetMapActorIndex);
  }

  /** {@link GoldenSun_809#FUN_8097174} */
  @Method(0x808a438)
  public static void FUN_808a438() {
    MEMORY.call(0x8097174);
  }

  /** {@link GoldenSun_809#FUN_8097194} */
  @Method(0x808a440)
  public static void FUN_808a440() {
    MEMORY.call(0x8097194);
  }

  /** {@link GoldenSun_809#FUN_809728c} */
  @Method(0x808a448)
  public static void FUN_808a448() {
    MEMORY.call(0x809728c);
  }

  /** {@link GoldenSun_808#FUN_808e118} */
  @Method(0x808a460)
  public static void FUN_808a460() {
    MEMORY.call(0x808e118);
  }

  /** {@link GoldenSun_808#FUN_808e96c} */
  @Method(0x808a488)
  public static int FUN_808a488(final int fieldPsynergyId) {
    return (int)MEMORY.call(0x808e96c, fieldPsynergyId);
  }

  /** {@link GoldenSun_808#FUN_808e990} */
  @Method(0x808a490)
  public static int FUN_808a490(final int r0) {
    return (int)MEMORY.call(0x808e990, r0);
  }

  /** {@link GoldenSun_808#FUN_808b248} */
  @Method(0x808a4a0)
  public static int FUN_808a4a0() {
    return (int)MEMORY.call(0x808b248);
  }

  /** {@link GoldenSun_808#addPpToAll} */
  @Method(0x808a4c0)
  public static void addPpToAll_(final int amount) {
    MEMORY.call(0x808c2dc, amount);
  }

  /** {@link GoldenSun_808#FUN_808acc4} */
  @Method(0x808a4f0)
  public static void FUN_808a4f0() {
    MEMORY.call(0x808acc4);
  }

  /** {@link GoldenSun_809#FUN_809b804} */
  @Method(0x808a500)
  public static void FUN_808a500(final FieldPsynergy720.Sub48 r0) {
    MEMORY.call(0x809b804, r0);
  }

  /** {@link GoldenSun_809#FUN_809ba34} */
  @Method(0x808a508)
  public static int FUN_808a508(final FieldPsynergy720.Sub48 r0) {
    return (int)MEMORY.call(0x809ba34, r0);
  }

  /** {@link GoldenSun_809#FUN_809ba5c} */
  @Method(0x808a510)
  public static void FUN_808a510(final FieldPsynergy720.Sub48 r0, final int r1, final int r2) {
    MEMORY.call(0x809ba5c, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_809ba7c} */
  @Method(0x808a520)
  public static void FUN_808a520(final FieldPsynergy720.Sub48 r0, final ConsumerRef<FieldPsynergy720.Sub48> r1) {
    MEMORY.call(0x809ba7c, r0, r1);
  }

  /** {@link GoldenSun_809#FUN_809ba90} */
  @Method(0x808a528)
  public static void FUN_808a528(final FieldPsynergy720.Sub48 inst, final int r1, final int r2, final int r3) {
    MEMORY.call(0x809ba90, inst, r1, r2, r3);
  }

  /** {@link GoldenSun_809#clearFieldPsynergyInstance} */
  @Method(0x808a530)
  public static void clearFieldPsynergyInstance(final FieldPsynergy720.Sub48 r0) {
    MEMORY.call(0x809bb34, r0);
  }

  /** {@link GoldenSun_809#FUN_80915ac} */
  @Method(0x808a540)
  public static int FUN_808a540(final int r0) {
    return (int)MEMORY.call(0x80915ac, r0);
  }

  /** {@link GoldenSun_809#FUN_8091858} */
  @Method(0x808a548)
  public static void FUN_808a548() {
    MEMORY.call(0x8091858);
  }

  /** {@link GoldenSun_809#FUN_80920c0} */
  @Method(0x808a588)
  public static void FUN_808a588(final int mapActorIndex0, final int mapActorIndex1) {
    MEMORY.call(0x80920c0, mapActorIndex0, mapActorIndex1);
  }

  /** {@link GoldenSun_808#FUN_808ba38} */
  @Method(0x808a5b0)
  public static void FUN_808a5b0() {
    MEMORY.call(0x808ba38);
  }

  /** {@link GoldenSun_808#getRoomNameStringId} */
  @Method(0x808a5d0)
  public static int getRoomNameStringId_(final int roomId, final int r1) {
    return (int)MEMORY.call(0x808b158, roomId, r1);
  }

  /** {@link GoldenSun_809#FUN_8091ff0} */
  @Method(0x808a5e0)
  public static void FUN_808a5e0(final int r0) {
    MEMORY.call(0x8091ff0, r0);
  }

  /** {@link GoldenSun_809#FUN_809202c} */
  @Method(0x808a5e8)
  public static void FUN_808a5e8() {
    MEMORY.call(0x809202c);
  }

  /** {@link GoldenSun_808#FUN_808b3d0} */
  @Method(0x808a5f0)
  public static int FUN_808a5f0(final int r0, final int r1) {
    return (int)MEMORY.call(0x808b3d0, r0, r1);
  }

  @Method(0x808a5f8)
  public static void FUN_808a5f8(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r7 = mapId_2000400.get();
    r1 = 999;
    r6 = getTransitions_2008014.deref().run();
    CPU.r9().value = 0;

    if(CPU.r8().value != r1) {
      do {
        r5 = MEMORY.ref(4, r6).get();
        r6 += 0x4;
      } while((r5 & 0xffff_f000) != 0);

      //LAB_808a638
      while((r5 & 0xfff) != 0x1ff) {
        if((r5 & 0xfff) == r7) {
          CPU.r10().value = r6;

          r3 = MEMORY.ref(4, r6).get();
          r6 += 0x4;

          r7 = (r3 & 0xff000) >>> 12;
          r5 = r3 & 0xfff;
          r2 = (r3 & 0xff00000) >>> 20;
          if((r3 & 0x10000000) != 0) {
            r0 = MEMORY.ref(4, r6).get();
            r6 += 0x4;
          } else {
            r0 = 0;
          }

          r1 = MEMORY.ref(4, CPU.r10().value).get() & 0x1ff;

          //LAB_808a640
          //LAB_808a648
          while(r2 != 0 && r5 != 0x1ff) {
            if((r2 == 0xff || r2 == CPU.r8().value) && (r0 == 0 || readFlag_(r0) == 0)) {
              //LAB_808a654
              r1 = r5;
              CPU.r9().value = r7;
              break;
            }

            //LAB_808a65a
            r3 = MEMORY.ref(4, r6).get();
            r6 += 0x4;

            r7 = (r3 & 0xff000) >>> 12;
            r5 = r3 & 0xfff;
            r2 = (r3 & 0xff00000) >>> 20;
            if((r3 & 0x10000000) != 0) {
              r0 = MEMORY.ref(4, r6).get();
              r6 += 0x4;
            } else {
              r0 = 0;
            }

            //LAB_808a67c
          }

          //LAB_808a686
          break;
        }

        //LAB_808a68e
        do {
          r5 = MEMORY.ref(4, r6).get();
          r6 += 0x4;
        } while((r5 & 0xffff_f000) != 0);
      }

      //LAB_808a6a2
      if(r1 != 999) {
        mapId_2000400.set(r1);
        entranceId_2000402.set(CPU.r9().value);
      }
    }

    //LAB_808a6bc
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x808a6e4)
  public static void FUN_808a6e4(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;

    MEMORY.ref(2, 0x2000476).setu(r0);

    if(r0 == -1) {
      //LAB_808a6f8
      final Unit14c r6 = getUnit_(playerMapActorIndex_2000434.get());
      if(r6.hp_38.get() == 0) {
        r6.hp_38.set(1);
        r5 = 0x4000;
        r0 = divideS(0x4000, r6.maxHp_34.get());
        if(r0 <= 0x4000) {
          r5 = 0x0;
          if(r0 >= 0) {
            r5 = r0;
          }
        }

        //LAB_808a72e
        r3 = r5 << 16;
        r6.fractionHp_14.set(r5);
        if(r3 == 0 && r6.hp_38.get() != 0) {
          r6.fractionHp_14.set(1);
        }

        //LAB_808a742
        r0 = divideS(r6.pp_3a.get() << 14, r6.maxPp_36.get());
        r3 = 0x4000;
        if(r0 <= 0x4000) {
          r3 = 0x0;
          if(r0 >= 0) {
            r3 = r0;
          }
        }

        //LAB_808a760
        r6.fractionPp_16.set(r3);
        r3 = r3 << 16;
        if(r3 == 0 && r6.pp_3a.get() != 0) {
          r6.fractionPp_16.set(1);
        }
      }

      //LAB_808a774
      if(readFlag_(0x20) != 0) {
        r5 = 0x0;

        //LAB_808a780
        do {
          final Unit14c r6_0 = getUnit_(r5);
          r1 = r6_0.maxHp_34.get();
          r3 = r6_0.maxPp_36.get();
          r6_0.hp_38.set(r1);
          r6_0.pp_3a.set(r3);
          r1 = r1 << 16;
          r1 = r1 >> 16;
          r0 = r1 << 14;
          r0 = divideS(r0, r1);
          r3 = 0x4000;
          if(r0 <= 0x4000) {
            r3 = 0x0;
            if(r0 >= 0) {
              r3 = r0;
            }
          }

          //LAB_808a7aa
          r6_0.fractionHp_14.set(r3);
          r3 = r3 << 16;
          if(r3 == 0 && r6_0.hp_38.get() != 0) {
            r6_0.fractionHp_14.set(1);
          }

          //LAB_808a7be
          r0 = divideS(r6_0.pp_3a.get() << 14, r6_0.maxPp_36.get());
          r3 = 0x4000;
          if(r0 <= 0x4000) {
            r3 = 0x0;
            if(r0 >= 0) {
              r3 = r0;
            }
          }

          //LAB_808a7dc
          r6_0.fractionPp_16.set(r3);
          r3 = r3 << 16;
          if(r3 == 0 && r6_0.pp_3a.get() != 0) {
            r6_0.fractionPp_16.set(1);
          }

          //LAB_808a7f0
          r5 = r5 + 0x1;
        } while(r5 <= 0x1);
      }

      //LAB_808a7f6
      r2 = MEMORY.ref(2, 0x2000412).get();
      r0 = MEMORY.ref(2, 0x2000414).get();
      if(r2 == -1) {
        if(r0 == -1) {
          MEMORY.ref(2, 0x2000400).setu(MEMORY.ref(2, 0x2000404).getUnsigned());
          MEMORY.ref(2, 0x2000402).setu(MEMORY.ref(2, 0x2000406).getUnsigned());
          return;
        }

        //LAB_808a83e
        r2 = MEMORY.ref(2, 0x2000408).getUnsigned();
      }
    } else {
      //LAB_808a846
      r2 = MEMORY.ref(2, 0x200040e).get();
      r0 = MEMORY.ref(2, 0x2000410).get();
      if(r2 == -1) {
        if(r0 == r2) {
          //LAB_808a89e
          MEMORY.ref(2, 0x2000400).setu(MEMORY.ref(2, 0x2000408).getUnsigned());
          MEMORY.ref(2, 0x2000402).setu(MEMORY.ref(2, 0x200040a).getUnsigned());
          setFlag_(0x109);
          return;
        }

        //LAB_808a866
        r2 = MEMORY.ref(2, 0x2000408).getUnsigned();
      }
    }

    //LAB_808a874
    MEMORY.ref(2, 0x2000400).setu(r2);

    if(r0 != -1) {
      MEMORY.ref(2, 0x2000402).setu(r0);
    } else {
      //LAB_808a88a
      MEMORY.ref(2, 0x2000402).setu(MEMORY.ref(2, 0x200040a).getUnsigned());
    }

    //LAB_808a8c2
  }

  @Method(0x808a8d0)
  public static int getAreaIndexForRoom(final int roomId) {
    return MEMORY.ref(1, 0x809f1a8 + roomId * 0x8 + 0x2).get();
  }

  @Method(0x808a8e4)
  public static void FUN_808a8e4(int r0) {
    int r5;
    int r6;

    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(0);

    CPU.r11().value = 0x809f1a8; //TODO

    if(debug_3001f54.get() == 0) {
      FUN_8077098();
      mapId_2000400.set(0);
      entranceId_2000402.set(2);
    } else if(r0 == 1) {
      mapId_2000400.set(5);
      entranceId_2000402.set(1);
    } else if(r0 == 2) {
      mapId_2000400.set(1);
      entranceId_2000402.set(1);
    } else {
      //LAB_808a932
      FUN_8077098();
      mapId_2000400.set(0);
      entranceId_2000402.set(2);
    }

    //LAB_808a94c
    FUN_8015360(_2000445.get(), _2000446.get());
    initVramSlots();
    clearTickCallbacks();
    clearTickCallbacks();
    CPU.r9().value = 0x50001c0;

    //LAB_808a96e
    do {
      if(readFlag_(0x101) != 0) {
        clearFlag_(0x101);
      } else {
        //LAB_808a9a8
        playSound_(0x120);
      }

      //LAB_808a9b0
      CPU.r10().value = CPU.r11().value + mapId_2000400.get() * 0x8;
      r6 = entranceId_2000402.get();
      DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);
      clearTickCallbacks();
      setInterruptHandler(1, 0, null);
      setInterruptHandler(2, 0, null);
      initMemoryAllocator();
      FUN_8004760();
      initVramSlots();

      final int mapId = mapId_2000400.get();
      if(mapId > 0x1fa) {
        if(mapId == 0x1fb) {
          //LAB_808aa9e
          r6 = 0;
        } else if(mapId == 0x1fc) {
          //LAB_808aa6e
          r5 = mallocChip(0x40);
          DMA.channels[3].SAD.setu(CPU.r9().value);
          DMA.channels[3].DAD.setu(r5);
          DMA.channels[3].CNT.setu(0x84000010);
          r6 = FUN_80f6000(r6);
          DMA.channels[3].SAD.setu(r5);
          DMA.channels[3].DAD.setu(CPU.r9().value);
          DMA.channels[3].CNT.setu(0x84000010);
          setMallocAddress(r5);
        } else if(mapId == 0x1fd) {
          //LAB_808aa52
          r5 = mallocChip(0x40);
          DMA.channels[3].SAD.setu(CPU.r9().value);
          DMA.channels[3].DAD.setu(r5);
          DMA.channels[3].CNT.setu(0x84000010);
          r6 = FUN_80f4000(r6);
          DMA.channels[3].SAD.setu(r5);
          DMA.channels[3].DAD.setu(CPU.r9().value);
          DMA.channels[3].CNT.setu(0x84000010);
          setMallocAddress(r5);
        } else if(mapId == 0x1fe) {
          r6 = loadBattle_(r6); // Starting battle?
        }

        //LAB_808aaa0
        FUN_808a6e4(r6);
      } else {
        //LAB_808aaa8
        FUN_808ab74(mapId_2000400.get(), readFlag_(0x109));
        FUN_808b090();
        if(readFlag_(0x109) == 0) {
          if(readFlag_(0x11a) != 0) {
            clearFlag_(0x11a);
          } else {
            if(readFlag_(0x11b) == 0) {
              FUN_808acc4();
            } else {
              //LAB_808aae6
              clearFlag_(0x11a);
            }
          }
        } else {
          //LAB_808aaf0
          r0 = _200045e.get();
          if(r0 != -1) {
            playSound_(r0);
          } else {
            //LAB_808ab06
            FUN_808acc4();
          }
        }

        //LAB_808ab0a
        _200041a.set(MEMORY.ref(2, CPU.r10().value + 0x4).getUnsigned());
        decompressMap();
        FUN_808a5f8(mapLoop(r6));
      }
    } while(true);
  }

  @Method(0x808ab48)
  public static void decompressMap() {
    LOGGER.info("Loading map %d", mapId_2000400.get());
    decompressPointerTableEntry(MEMORY.ref(2, 0x809f1a8 + mapId_2000400.get() * 0x8).get(), 0x2008000);

    switch(mapId_2000400.get()) {
      // Camelot intro
      case 0 -> { }
      // Title screen
      case 1 -> { }
      case 3 -> MEMORY.addFunctions(Map3Overlay_877dd1c.class);
      case 4 -> MEMORY.addFunctions(Map4Overlay_8780898.class);
      case 5 -> MEMORY.addFunctions(Map5Overlay_8784360.class);
      case 6 -> MEMORY.addFunctions(Map6Overlay_878603c.class);
      case 7 -> MEMORY.addFunctions(Map7Overlay_8786f0c.class);
      case 8 -> MEMORY.addFunctions(Map8Overlay_8787e04.class);
      case 9 -> MEMORY.addFunctions(Map9Overlay_87892c8.class);
      case 15 -> MEMORY.addFunctions(Map15Overlay_878de18.class);
      case 16, 19 -> MEMORY.addFunctions(Map19Overlay_878dee8.class);
      case 121 -> MEMORY.addFunctions(Map121Overlay_87d0e88.class);
      case 132 -> MEMORY.addFunctions(Map132Overlay_87ced6c.class);
      default -> throw new RuntimeException("Unimplemented map " + mapId_2000400.get());
    }
  }

  @Method(0x808ab74)
  public static void FUN_808ab74(final int r0, final int r1) {
    final int r6 = MEMORY.ref(1, 0x809f1a8 + mapId_2000400.get() * 0x8 + 0x2).get(); //TODO
    if(r1 == 0) {
      //LAB_808ab94
      for(int r5 = 0x200; r5 < 0x300; r5++) {
        clearFlag_(r5);
      }

      if(r6 != _200040c.get()) {
        //LAB_808abb6
        for(int r5 = 0x300; r5 < 0x400; r5++) {
          clearFlag_(r5);
        }

        setFlag_(0x12f);
        _2000478.set(0);
        _2000472.set(0);
        clearFlag_(0x110);
        clearFlag_(0x111);
        clearFlag_(0x112);
        clearFlag_(0x113);
        _2000480.set(mapId_2000400.get());
        _2000482.set(entranceId_2000402.get());
      }

      //LAB_808ac16
      //LAB_808ac18
      for(int r5 = 0x80; r5 < 0xe0; r5++) {
        clearFlag_(r5);
      }

      clearFlag_(0x16c);
      clearFlag_(0x144);
      clearFlag_(0x161);
      clearFlag_(0x123);
      clearFlag_(0x11c);
      _200045e.set(-1);
    }

    //LAB_808ac54
    _200040c.set(r6);
    setFlag_((r6 & 0x7f) + 0x180);

    final int r2 = MEMORY.ref(1, 0x809f1a8 + mapId_2000400.get() * 0x8 + 0x3).get();
    _200047e.set(r2);
    if(r2 == 2) {
      setFlag_(0x123);
    }

    //LAB_808ac8e
    cacheEncounterRateBoost_();
  }

  @Method(0x808acc4)
  public static void FUN_808acc4() {
    playSound_(_2000430.get());
  }

  @Method(0x808ace0)
  public static void FUN_808ace0(int r0) {
    final Structccc r10 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r5 = 0x809d170;
    int r7 = 0;
    int sp04 = 0;
    if(r0 != 0) {
      //LAB_808ad34
      while(MEMORY.ref(2, r5).get() != -1) {
        if(MEMORY.ref(2, r5).get() == mapId_2000400.get()) {
          int r3 = MEMORY.ref(2, r5 + 0x2).get();
          if(r3 == -1 || r3 == entranceId_2000402.get()) {
            //LAB_808ad48
            r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
            if((r0 & 0x7fff) == 0x7fff || readFlag_(r0 << 17 >> 17) == 0) {
              //LAB_808ad62
              r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
              r3 = CPU.lslT(r3, 24);
              r3 = CPU.asrT(r3, 31);
              r3 = CPU.lslT(r3, 16);
              r3 = CPU.asrT(r3, 16);
              r7 = MEMORY.ref(2, r5 + 0x6).get();
              sp04 = r3;
              break;
            }
          }
        }

        //LAB_808ad74
        r5 += 0x8;
      }
    }

    //LAB_808ad80
    r10._1a0.get(0).set(0);

    //LAB_808ad88
    for(int r3 = 1; r3 < 8; r3++) {
      r10._1a0.get(r3).set(r7);
      if(r7 != 0) {
        r7++;
      }

      //LAB_808ad92
    }

    if(sp04 != 0) {
      r10._1a0.get(0).set(r10._1a0.get(1).get());
      r10._1a0.get(1).set(0);
    }

    //LAB_808adb0
    r10._1a8.set(0);
    r10._1ac.set(0x100000);
    FUN_808b25c();
  }

  @Method(0x808adf0)
  public static int FUN_808adf0(final Vec3 r0) {
    CPU.sp().value -= 0x4;
    int r5 = 0x809d7a8;
    final int r6 = FUN_8009268(r0, CPU.sp().value);
    int r10 = 0;
    //LAB_808ae1a
    while(MEMORY.ref(2, r5).get() != -1) {
      if(MEMORY.ref(2, r5).get() == MEMORY.ref(4, CPU.sp().value).get()) {
        final int r3 = MEMORY.ref(2, r5 + 0x2).get();
        if(r3 == -1 || r3 == r6) {
          //LAB_808ae32
          final int r0_0 = MEMORY.ref(2, r5 + 0x4).get();
          if(r0_0 == -1 || readFlag_(r0_0) == 0) {
            //LAB_808ae42
            r10 = MEMORY.ref(2, r5 + 0x6).get();
            break;
          }
        }
      }

      //LAB_808ae4a
      r5 += 0x8;
    }

    //LAB_808ae56
    FUN_808b2b0(r6);

    CPU.sp().value += 0x4;
    return r10;
  }

  @Method(0x808ae74)
  public static int getRandomEncounterId(final int encounterSet, final int encounterRate) {
    final Structccc r11 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //BUGFIX: r9 was set inside the if statement but used after it. If flag 0x15f was set, it'd use Isaac's Z coord as a pointer
    final int r9 = 0x809c610 + encounterSet * 0x1c;

    if(readFlag_(0x15f) == 0) {
      //LAB_808ae9a
      if(readFlag_(0x160) != 0 || readFlag_(0x161) != 0 || encounterSet == 0 || _200048c.get() != 0) {
        return 0;
      }

      //LAB_808aecc
      int r7 = MEMORY.ref(2, r9).getUnsigned();
      if(r7 == 0) {
        return 0;
      }

      //LAB_808aee2
      if(readFlag_(5) != 0 && getUnit_(5).exp_124.get() > 130) {
        return 0;
      }

      //LAB_808aefe
      final int r0_0 = MathHelper.clamp(getAverageCharLevel_() - MEMORY.ref(2, r9 + 0x2).getUnsigned(), 0, 5);
      if(r0_0 > 0 && MEMORY.ref(4, 0x2000484).get() != 0) {
        //LAB_808af26
        return 0;
      }

      //LAB_808af2a
      r7 += r0_0 * 5;

      if(r11._1a8.get() == 0) {
        r11._1a8.set((rand() - rand() + rand() - rand()) / 2);
      }

      //LAB_808af66
      _2000478.add(mul16(FUN_300013c((r7 << 20) + (r7 - 1) * 0x10 * r11._1a8.get(), 0x100000), encounterRate));

      if(_2000478.get() < r11._1ac.get()) {
        return 0;
      }
    }

    //LAB_808afa0
    r11._1a8.set(0);
    int r5 = 0;

    //LAB_808afb2
    for(int i = 0; i < 8; i++) {
      r5 += MEMORY.ref(1, r9 + 0x14 + i).getUnsigned();
    }

    if(r5 == 0) {
      return 0;
    }

    int r0_0 = (r5 * rand() >>> 16);

    //LAB_808afdc
    int i;
    for(i = 0; i < 8 && r0_0 >= 0; i++) {
      r0_0 -= MEMORY.ref(1, r9 + 0x14 + i).getUnsigned();
    }

    //LAB_808afec
    final int encounter = MEMORY.ref(2, r9 + 0x4 + i * 0x2).getUnsigned();
    FUN_808b320(encounterSet, i);

    //LAB_808affc
    return encounter;
  }

  @Method(0x808b02c)
  public static int FUN_808b02c(final int r0, final int encounterRate) {
    return getRandomEncounterId(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1a0.get(r0).get(), encounterRate);
  }

  @Method(0x808b048)
  public static int FUN_808b048(final Vec3 r0, final int encounterRate) {
    return getRandomEncounterId(FUN_808adf0(r0), encounterRate);
  }

  @Method(0x808b05c)
  public static int getEncounterId(final int encounterSet, final int encounterIndex) {
    return MEMORY.ref(2, 0x809c610 + encounterSet * 0x1c + 0x4 + encounterIndex * 0x2).getUnsigned();
  }

  @Method(0x808b090)
  public static void FUN_808b090() {
    int r10 = 0x12;
    final int r11 = mapId_2000400.get();
    int r5 = 0x809d9f0;
    final int r7 = entranceId_2000402.get();
    int r1 = MEMORY.ref(2, r5).getUnsigned();
    final int r9 = MEMORY.ref(2, 0x200040c).get();

    //LAB_808b0da
    while((short)r1 != -1) {
      if((MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) != 0 && (short)r1 == r11 || (MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) == 0 && (short)r1 == r9) {
        //LAB_808b0f6
        final int r2 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        if((r2 & 0x7fff) == 0x7fff || r2 << 17 >> 17 == r7) {
          //LAB_808b108
          final int r0 = MEMORY.ref(2, r5 + 0x4).get();
          if(r0 == -1 || readFlag_(r0) != 0) {
            //LAB_808b118
            r10 = MEMORY.ref(2, r5 + 0x6).get();
            break;
          }
        }
      }

      //LAB_808b122
      r5 += 0x8;
      r1 = MEMORY.ref(2, r5).getUnsigned();
    }

    //LAB_808b132
    _2000430.set(r10);
  }

  @Method(0x808b158)
  public static int getRoomNameStringId(final int roomId, final int r1) {
    int r5 = 0x809ddd8;
    final int r12 = getAreaIndexForRoom(roomId);

    //LAB_808b182
    int r1_0;
    while((r1_0 = MEMORY.ref(2, r5).get()) != -1) {
      int r2 = MEMORY.ref(1, r5 + 0x3).getUnsigned();
      if(((r2 & 0x80) == 0 || r1_0 == roomId) && ((r2 & 0x80) != 0 || r1_0 == r12)) {
        //LAB_808b19e
        r2 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        if((r2 & 0x7fff) == 0x7fff) {
          return MEMORY.ref(4, r5 + 0x4).get();
        }
        int r3 = CPU.lslT(r2, 17);
        r3 = CPU.asrT(r3, 17);
        if(r3 == r1) {
          //LAB_808b1b0
          return MEMORY.ref(4, r5 + 0x4).get();
        }
      }

      //LAB_808b1b6
      r5 += 0x8;
    }

    //LAB_808b1c4
    return 0;
  }

  @Method(0x808b1d8)
  public static void FUN_808b1d8() {
    final int r6 = mapId_2000400.get();
    final int r5 = entranceId_2000402.get();
    int r2 = 0x809e1d8;

    //LAB_808b20e
    while(MEMORY.ref(2, r2).get() != -1) {
      if(MEMORY.ref(2, r2).get() == r6) {
        final int r3 = MEMORY.ref(2, r2 + 0x2).get();
        if(r3 == -1 || r3 == r5) {
          //LAB_808b222
          _2000404.set(MEMORY.ref(2, r2 + 0x4).getUnsigned());
          _2000406.set(MEMORY.ref(2, r2 + 0x6).getUnsigned());
          break;
        }
      }

      //LAB_808b22c
      r2 += 0x8;
    }

    //LAB_808b238
  }

  @Method(0x808b248)
  public static int FUN_808b248() {
    return _2000416.get();
  }

  @Method(0x808b25c)
  public static void FUN_808b25c() {
    int r1 = 0; // r1 undefined when if statement conditions are false

    int r4 = 0x809e270;
    int r2 = MEMORY.ref(4, r4).get();
    r4 += 0x4;

    //LAB_808b27e
    while(r2 != 0 && r2 != mapId_2000400.get()) {
      if((r2 & 0x80000000) != 0) {
        r1 = r2 & 0xffff;
      }

      //LAB_808b28a
      r2 = MEMORY.ref(4, r4).get();
      r4 += 0x4;
    }

    //LAB_808b294
    _2000416.set(r1);
  }

  @Method(0x808b2b0)
  public static void FUN_808b2b0(final int r0) {
    final int r2 = switch(r0) {
      case 1 -> 0x38;
      case 2 -> 0x3a;
      case 3 -> 0x3c;
      case 4, 7 -> 0x36;
      case 5, 6 -> 0x37;
      default -> 0x39;
    };

    //LAB_808b2f2
    _2000416.set(r2);
  }

  @Method(0x808b320)
  public static void FUN_808b320(final int encounterSet, final int encounterIndex) {
    final int r7 = encounterSet * 0x10 + encounterIndex & 0xffff;

    int r6 = 0; // conditionally undefined
    if(readFlag_(0x16c) != 0) {
      r6 = 0x12;
    } else {
      //LAB_808b33c
      int r5 = 0x809e488;
      int r1_0 = MEMORY.ref(2, r5).getUnsigned();
      r5 += 0x2;

      //LAB_808b35a
      while(r1_0 != 0 && r1_0 != r7) {
        if((r1_0 & 0x8000) != 0) {
          r6 = r1_0 & 0xfff;
        }

        //LAB_808b368
        r1_0 = MEMORY.ref(2, r5).getUnsigned();
        r5 += 0x2;
      }
    }

    //LAB_808b37a
    MEMORY.ref(2, 0x200042e).setu(r6);
  }

  @Method(0x808b398)
  public static int FUN_808b398(final int r0) {
    if(r0 <= 8) {
      if(readFlag_(0x20) != 0) {
        if(r0 == 0) {
          return 0x12;
        }

        //LAB_808b3b0
        if(r0 == 1) {
          return 0x13;
        }
      } else if(readFlag_(0x21) != 0 && r0 == 0) {
        return 0x11;
      }
    }

    //LAB_808b3c8
    return r0;
  }

  @Method(0x808b3d0)
  public static int FUN_808b3d0(int r0, final int r1) {
    if(r0 <= 8) {
      if(r1 != 0) {
        if(r0 == 0) {
          r0 = 0x12;
        }

        //LAB_808b3e0
        if(r0 == 1) {
          r0 = 0x13;
        }
      }
    }

    //LAB_808b3e6
    return r0;
  }

  @Method(0x808b3ec)
  public static void loadActorSet(final int actorSet, final int startingMapActorIndex) {
    final Structccc r9 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r7 = actorSet;
    int r11 = startingMapActorIndex;

    //LAB_808b418
    for(int i = 0; i < 4; i++) {
      final int r3 = r9.actorSets_00.get(i).get();
      if(r3 == r7) {
        break;
      }
      if(r3 == 0) {
        r9.actorSets_00.get(i).set(r7);
        break;
      }
    }

    //LAB_808b42e
    //LAB_808b618
    int r3;
    while((r3 = MEMORY.ref(2, r7).get()) != -1 && r11 < 66) {
      //LAB_808b43a
      int sp04 = 0;
      if(r3 < 8) {
        sp04 = r3;
        //LAB_808b446
      } else if(r3 < 9990) {
        sp04 = r11;
        r11++;
      }

      //LAB_808b454
      final int r5 = MEMORY.ref(2, r7 + 0x2).get();
      if(FUN_808d428(r5) != 0) {
        //LAB_808b464
        if(r5 < 0x30 || r5 > 0x7f || r9._19e.get() == 3 || FUN_808d428(r5 + 0x50) != 0) {
          //LAB_808b488
          final int r10 = FUN_808b398(MEMORY.ref(2, r7).get());

          Actor70 r6 = getMapActor(sp04);
          Sprite38 r8;
          if(r6 == null) {
            r6 = loadActor_(r10, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0xc).get(), MEMORY.ref(4, r7 + 0x10).get());
            if((MEMORY.ref(1, r7 + 0x17).getUnsigned() & 0x1) != 0) {
              final Actor70 r0_0 = getMapActor(sp04 - 1);
              if(r0_0.spriteType_54.get() == 1 && r6.spriteType_54.get() == 1) {
                final Sprite38 r0_1 = r0_0.sprite_50.deref();
                r0_1._1d.or(0x1);
                final int slot = r0_1.slot_1c.get();
                r8 = r6.sprite_50.deref();
                r8._1d.or(0x1);
                clearVramSlot(r8.slot_1c.get());
                r8.slot_1c.set(slot);
              }
            }

            //LAB_808b4f6
            if(readFlag_(0x21) != 0 && r10 >= 18 && r10 < 20) {
              addLayerToSpriteIfRegularSprite_(r6, 226);
            }
            //LAB_808b512
          } else if(readFlag_(0x109) == 0) {
            setActorPosition_(r6, MEMORY.ref(4, r7 + 0x8).get(), MEMORY.ref(4, r7 + 0xc).get(), MEMORY.ref(4, r7 + 0x10).get());
          }

          //LAB_808b528
          if(r6 != null) {
            setActorAnimation_(r6, 1);

            if(r6.spriteType_54.get() == 1) {
              r8 = r6.sprite_50.derefNullable();
              if(r8 != null) {
                r8.anim_24.set(modU(rand(), 30));
              }
            }

            //LAB_808b556
            r6.angle_06.set(MEMORY.ref(2, r7 + 0x14).getUnsigned());
            r6._59.set(1);
            FUN_8093a6c(r6, MEMORY.ref(4, r7 + 0x4).get());
            setActorAnimation_(r6, 1);
            r6._64.set(r6.pos_08.getX() / 0x10000);
            r6._66.set(r6.pos_08.getZ() / 0x10000);

            if(r6.pos_08.getY() != 0) {
              r6._55.set(4);
              r6.pos_08.y_04.add(0x8000);
            }

            //LAB_808b5ac
            if(r9._19e.get() == 3) {
              r6._55.and(~0x1);

              if(readFlag_(0x21) == 0) {
                r8 = r6.sprite_50.deref();
                r8.scale_18.set(mul16(r8.scale_18.get(), 0xc000));
              }
            } else {
              //LAB_808b5e6
              final int height = getHeight_(0, r6.pos_08.getX(), r6.pos_08.getZ());
              r6._14.set(height);
              r6.pos_08.y_04.add(height);
            }

            //LAB_808b5f8
            r6.flags_23.set(0x1);
          }

          //LAB_808b600
          r9.actors_14.get(sp04).setNullable(r6);
        }
      }

      //LAB_808b60a
      r7 += 0x18;
    }

    //LAB_808b624
  }

  @Method(0x808b674)
  public static void loadMapActors(final int actors) {
    final Structccc r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int playerMapActorIndex = playerMapActorIndex_2000434.get();

    final int playerActorSet = r8._200.getAddress(); //TODO
    MEMORY.ref(4, playerActorSet).setu(MEMORY.ref(4, 0x809f810).get());
    MEMORY.ref(4, playerActorSet + 0x4).setu(MEMORY.ref(4, 0x809f814).get());
    MEMORY.ref(4, playerActorSet + 0x8).setu(MEMORY.ref(4, 0x809f818).get());
    MEMORY.ref(4, playerActorSet + 0xc).setu(MEMORY.ref(4, 0x809f81c).get());
    MEMORY.ref(4, playerActorSet + 0x10).setu(MEMORY.ref(4, 0x809f820).get());
    MEMORY.ref(4, playerActorSet + 0x14).setu(MEMORY.ref(4, 0x809f824).get());

    final int r2 = r8._218.getAddress(); //TODO
    MEMORY.ref(4, r2).setu(MEMORY.ref(4, 0x809f828).get());
    MEMORY.ref(4, r2 + 0x4).setu(MEMORY.ref(4, 0x809f82c).get());
    MEMORY.ref(4, r2 + 0x8).setu(MEMORY.ref(4, 0x809f830).get());
    MEMORY.ref(4, r2 + 0xc).setu(MEMORY.ref(4, 0x809f834).get());
    MEMORY.ref(4, r2 + 0x10).setu(MEMORY.ref(4, 0x809f838).get());
    MEMORY.ref(4, r2 + 0x14).setu(MEMORY.ref(4, 0x809f83c).get());

    //LAB_808b6b6
    for(int i = 0; i < 4; i++) {
      r8.actorSets_00.get(i).set(0);
    }

    clearMapActors();
    MEMORY.ref(2, playerActorSet).setu(playerMapActorIndex);
    MEMORY.ref(2, playerActorSet + 0x2).setu(0xffff);
    MEMORY.ref(4, playerActorSet + 0xc).setu(0);
    MEMORY.ref(4, playerActorSet + 0x8).setu(_200041c.get());
    MEMORY.ref(4, playerActorSet + 0x10).setu(_2000424.get());
    MEMORY.ref(2, playerActorSet + 0x14).setu(_2000428.get());
    loadActorSet(playerActorSet, playerMapActorIndex);
    loadActorSet(actors, 8);

    final Actor70 playerActor = r8.actors_14.get(playerMapActorIndex).deref();
    playerActor.layer_22.set(_200042c.get());

    final int r3 = (playerActor.pos_08.getX() / 0x100000 + playerActor.pos_08.getZ() / 0x100000 * 0x80);

    if(_2000420.get() != 0 && tileAttribs_2010000.get(r3).getType() == 0xfd && MEMORY.ref(1, 0x200fe00 + r3 + 0x2).getUnsigned() == 0xfd) {
      _2000432.set(0x1);
      playerActor.pos_08.y_04.add(getHeight_(0, playerActor.pos_08.getX(), playerActor.pos_08.getZ() - 0x100000) - 0x200000);
      playerActor._14.set(playerActor.pos_08.getY());
      playerActor._55.set(0);
      FUN_80091e0(playerActor, 0);
      setActorAnimation_(playerActor, 12);
    } else {
      //LAB_808b7b8
      _2000432.set(0);
    }

    //LAB_808b7c4
    final Actor70 r6 = loadActor_(0x8000, playerActor.pos_08.getX(), playerActor.pos_08.getY(), playerActor.pos_08.getZ());
    r6._14.set(playerActor._14.get());
    FUN_80090e0(r6, playerActor);

    if(r8._19e.get() == 3) {
      final SpriteLayer18 r0_0 = addLayerToSprite_(playerActor.sprite_50.deref(), 23);
      r0_0._05.set(0xf);
      r0_0._06.set(0x9);
    }

    //LAB_808b7fc
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._00.set(r6.pos_08);
    r8.actor_1e0.set(r6);
  }

  @Method(0x808b824)
  public static int FUN_808b824() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r0 = 7;

    //LAB_808b832
    for(int r2 = 8; r2 < 66; r2++) {
      if(!r1.actors_14.get(r2).isNull()) {
        r0 = r2;
      }

      //LAB_808b83a
    }

    r0++;
    if(r0 == 66) {
      r0 = -1;
    }

    //LAB_808b84a
    return r0;
  }

  @Method(0x808b868)
  public static void FUN_808b868(final int r0) {
    final Map194 r6 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    clearFlag_(0x164);
    setFlag_(0x165);

    //LAB_808b894
    int r5 = r0;
    while(MEMORY.ref(2, r5).get() != -1) {
      if(MEMORY.ref(2, r5 + 0x2).get() == 0) {
        final int r2 = MEMORY.ref(4, r5 + 0x8).get();
        final int r1 = MEMORY.ref(4, r5 + 0x10).get();

        if(r2 >= r6._ec.get() && r2 <= r6._f4.get() && r1 >= r6._f0.get() && r1 <= r6._f8.get()) {
          MEMORY.ref(2, r5 + 0x2).setu(0x164);
        } else {
          //LAB_808b8cc
          MEMORY.ref(2, r5 + 0x2).setu(0x165);
        }
      }

      //LAB_808b8ce
      r5 += 0x18;
    }

    //LAB_808b8d8
  }

  @Method(0x808b8e8)
  public static void FUN_808b8e8() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Actor70 r2 = r1.actor_1e0.deref();
    final int r9 = r2.pos_08.getX() - 0xa00000;
    final int r10 = r2.pos_08.getX() + 0xa00000;
    final int r8 = r2.pos_08.getZ() - 0xc80000;
    final int r7 = r2.pos_08.getZ() + 0x640000;

    //LAB_808b92c
    for(int r6 = 8; r6 < 66; r6++) {
      final Pointer<Actor70> r5 = r1.actors_14.get(r6);
      if(!r5.isNull()) {
        final Actor70 r0 = r5.deref();
        if(r0.pos_08.getX() != 0 || r0.pos_08.getZ() != 0) {
          //LAB_808b93e
          if(r0.pos_08.getX() < r9 || r0.pos_08.getX() > r10 || r0.pos_08.getZ() < r8 || r0.pos_08.getZ() > r7) {
            //LAB_808b94e
            r0.spriteType_54.set(1);
            r0.sprite_50.deref()._1d.and(~0x1);
            clearActor_(r0);
            r5.clear();
          }
        }
      }

      //LAB_808b968
    }
  }

  @Method(0x808b98c)
  public static void FUN_808b98c() {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    //LAB_808b9a6
    for(int r7 = 8; r7 < 66; r7++) {
      final Actor70 r0 = r5.actors_14.get(r7).derefNullable();
      if(r0 != null) {
        r0.spriteType_54.set(1);
        r0.sprite_50.deref()._1d.and(~0x1);
        clearActor_(r0);
        r5.actors_14.get(r7).clear();
      }

      //LAB_808b9c6
    }

    final int r6 = r5.actorSets_00.get(1).get();
    r5.actorSets_00.get(1).set(0);
    r5.actorSets_00.get(2).set(0);
    r5.actorSets_00.get(3).set(0);

    if(r6 != 0) {
      loadActorSet(r6, FUN_808b824());
    }

    //LAB_808b9e8
  }

  @Method(0x808b9f8)
  public static void clearMapActors() {
    MEMORY.memfill(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actors_14.getAddress(), 0x108, 0);
  }

  @Method(0x808ba1c)
  public static Actor70 getMapActor(final int index) {
    if(index < 0 || index >= 0xc0) { //TODO this check seems wrong, should be 66
      return null;
    }

    return boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actors_14.get(index).derefNullable();
  }

  @Method(0x808ba38)
  public static void FUN_808ba38() {
    int r7 = 0x2001124;
    int r8 = 0;
    int r6 = 0x2001104;

    final int actorCount;
    if(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._19e.get() == 3) {
      actorCount = 8;
    } else {
      actorCount = 66;
    }

    //LAB_808ba84
    //LAB_808ba8c
    for(int actorIndex = 0; actorIndex < actorCount; actorIndex++) {
      final Actor70 actor = getMapActor(actorIndex);
      if(actor != null) {
        MEMORY.ref(1, r6).setu(actorIndex);
        DMA.channels[3].SAD.setu(actor.getAddress());
        DMA.channels[3].DAD.setu(r7);
        DMA.channels[3].CNT.setu(0x8400001c);

        final int anim;
        final int r1;
        final int r0;
        if(actor.spriteType_54.get() == 1) {
          final Sprite38 r2 = actor.sprite_50.deref();
          anim = r2.anim_24.get();
          r1 = r2._26.get();
          r0 = r2.packet_00.attribs_04.attrib2_04.get() << 20 >>> 30;
        } else {
          //LAB_808bac4
          anim = 0;
          r1 = 0;
          r0 = 0;
        }

        //LAB_808baca
        MEMORY.ref(1, r7 + 0xe00 + r8).setu(anim);
        MEMORY.ref(1, r7 + 0xe20 + r8).setu(r1);
        MEMORY.ref(1, r7 + 0xe40 + r8).setu(r0);
        r8++;
        r6++;
        r7 += 0x70;
        if(r8 > 0x1f) {
          break;
        }
      }

      //LAB_808baea
    }

    //LAB_808baf2
    if(r8 < 0x20) {
      int r5 = 0x20 - r8;

      //LAB_808bafe
      do {
        MEMORY.ref(1, r6).setu(0xff);
        r6++;
        r5--;
      } while(r5 != 0);
    }

    //LAB_808bb08
  }

  @Method(0x808bb2c)
  public static void FUN_808bb2c() {
    int r1;
    int r2;
    int r3;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = 0x2001124;
    CPU.r10().value = CPU.r8().value - 0x20;
    CPU.sp().value -= 0x8;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(CPU.r8().value + 0xe00);
    MEMORY.ref(4, CPU.sp().value).setu(CPU.r8().value + 0xe20);
    CPU.r11().value = CPU.r8().value + 0xe40;
    r7 = MEMORY.ref(1, CPU.r10().value).getUnsigned();
    CPU.r9().value = 0;
    CPU.r10().value = CPU.r8().value - 0x1f;
    CPU.cmpT(r7, 0xff);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_808bb74
      do {
        final Actor70 r5 = getMapActor(r7);
        if(r5 != null) {
          final Sprite38 r6 = r5.sprite_50.deref();
          DMA.channels[3].SAD.setu(CPU.r8().value);
          DMA.channels[3].DAD.setu(r5.getAddress());
          DMA.channels[3].CNT.setu(0x8400001c);

          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r1 = MEMORY.ref(1, r3).getUnsigned();
          if(r1 != 0) {
            setActorAnimation_(r5, r1);
          }

          //LAB_808bb9c
          r2 = MEMORY.ref(4, CPU.sp().value).get();
          FUN_80091e0(r5, MEMORY.ref(1, r2).getUnsigned());
          r1 = (MEMORY.ref(1, CPU.r11().value).getUnsigned() & 0x3) << 10;
          r6.packet_00.attribs_04.attrib2_04.and(~0xc00).or(r1);
          r6.shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(r1);
          r5.sprite_50.set(r6);
          if(r7 == playerMapActorIndex_2000434.get()) {
            final Actor70 r2_0 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).actor_1e0.deref();
            r3 = r5.pos_08.getY();
            r2_0._14.set(r3);
            r2_0.pos_08.setY(r3);
            boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._00.deref().setY(r3);
            FUN_8009140(r5);
          }
        }

        //LAB_808bbf2
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r1 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.r8().value += 0x70;
        r3 = CPU.addT(r3, 0x1);
        CPU.r9().value++;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        CPU.r11().value++;
        if(CPU.r9().value > 0x1f) {
          break;
        }
        r7 = MEMORY.ref(1, CPU.r10().value).getUnsigned();
        CPU.r10().value++;
      } while(r7 != 0xff);
    }

    //LAB_808bc18
    CPU.sp().value += 0x8;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808bc44)
  public static void FUN_808bc44() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._16c.set(0);
    r1._16e.set(0);
    r1._170.set(0);
    r1.menuPressed_172.set(0);
    r1.interactPressed_174.set(0);
    r1.systemMenuPressed_176.set(0);
    r1.interactedActor_178.set(0);
    r1.interactedTileType_17a.set(0);
    r1.encounterId_17c.set(0);
    r1.usedAbility_17e.set(0);
    r1.usedItem_180.set(0);
    r1._182.set(0);
  }

  @Method(0x808bc9c)
  public static int wasActionPerformed() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    return r1._16c.get() + r1._16e.get() + r1._170.get() + r1.menuPressed_172.get() + r1.interactPressed_174.get() + r1.systemMenuPressed_176.get() + r1.interactedActor_178.get() * 2 + r1.interactedTileType_17a.get() + r1.encounterId_17c.get() + r1.usedAbility_17e.get() + r1.usedItem_180.get() + r1._182.get();
  }

  @Method(0x808bd24)
  public static int getTileTypeInFrontOfPlayer() {
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Actor70 player = r6.actors_14.get(playerMapActorIndex_2000434.get()).derefNullable();

    if(player == null) {
      return 0;
    }

    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Vec3 rotatedPos = new Vec3();
    rotatedPos.set(player.pos_08);
    rotVec3(0x10_0000, player.angle_06.get(), rotatedPos);

    final TileAttributes04 tile;
    if(r6._19e.get() == 3) {
      tile = MEMORY.ref(4, 0x2020000 + ((rotatedPos.getZ() / 0x200000 & 0x1f) * 32 + (rotatedPos.getX() / 0x200000 & 0x1f)) * 0x4, TileAttributes04::new); //TODO
    } else {
      //LAB_808bd98
      tile = r7.layers_104.get(0).tiles_2c.deref().get(rotatedPos.getZ() / 0x100000 * 128 + rotatedPos.getX() / 0x100000);
    }

    //LAB_808bdc0
    //LAB_808bdc2
    return tile.getType();
  }

  @Method(0x808bde0)
  public static void handleLadders(final int x, final int y, final int z) {
    int ladders = getLadders_200802c.deref().run();
    if(ladders != 0) {
      final Structccc sp00 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
      //LAB_808be16
      int minX;
      while((minX = MEMORY.ref(2, ladders).get()) != -1) {
        final int minY = MEMORY.ref(2, ladders + 0x2).get();
        final int minZ = MEMORY.ref(2, ladders + 0x4).get();
        final int maxX = MEMORY.ref(2, ladders + 0x6).get();
        final int maxY = MEMORY.ref(2, ladders + 0x8).get();
        final int maxZ = MEMORY.ref(2, ladders + 0xa).get();
        final int sp04 = MEMORY.ref(2, ladders + 0xe).get();
        if(FUN_808d428(MEMORY.ref(2, ladders + 0xc).get()) != 0) {
          if(y >= minY << 16 && y < maxY << 16) {
            if(x >= minX << 16 && x < maxX << 16) {
              if(z >= minZ << 16 && z < maxZ << 16) {
                sp00._170.set(sp04);
                playSound_(0x7b);
                stopPlayerAndSetIdle();
                break;
              }
            }
          }
        }

        //LAB_808be90
        ladders += 0x10;
      }
    }

    //LAB_808bea4
  }

  @Method(0x808bec0)
  public static void FUN_808bec0(final int layer, final int x, final int y, final int z) {
    final Structccc r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Map194 sp14 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Actor70 player = r8.actors_14.get(playerMapActorIndex_2000434.get()).derefNullable();
    if(r8 != null) {
      final int[] sp0x1c = new int[8];

      //LAB_808bf02
      final int charCount = getCharCount_();

      //LAB_808bf16
      for(int charSlot = 0; charSlot < charCount; charSlot++) {
        sp0x1c[charSlot] = getUnit_(charIds_2000438.get(charSlot).get()).hp_38.get();
      }

      //LAB_808bf2c
      final UnboundedArrayRef<TileAttributes04> tiles;
      if(r8._19e.get() == 3) {
        tiles = MEMORY.ref(4, 0x2020000 + ((z / 0x200000 & 0x1f) * 0x20 + (x / 0x200000 & 0x1f)) * 0x4, UnboundedArrayRef.of(0x4, TileAttributes04::new)); //TODO
        //LAB_808bf64
      } else if(layer >= 0 && layer < 3) {
        tiles = sp14.layers_104.get(layer).tiles_2c.deref().slice(z / 0x100000 * 0x80 + x / 0x100000);
      } else {
        //LAB_808bf7c
        tiles = tileAttribs_2010000.slice(z / 0x100000 * 0x80 + x / 0x100000);
      }

      //LAB_808bf9e
      r8.oldTiles_1bc.setNullable(r8.tiles_1b8.derefNullable());
      r8.tiles_1b8.set(tiles); // called every frame

      final int tileType = tiles.get(0).getType();

      if(tileType != 0) {
        handleLadders(x, y, z);
      }

      //LAB_808bfc0
      if(tileType > 0 && tileType < 0xf0) {
        r8._16c.set(tileType);
      }

      //LAB_808bfce
      if(tileType >= 0xfc && tileType < 0xff) {
        r8._16e.set(tileType);
      }

      //LAB_808bfde
      int tookDamage = 0;
      final int r4 = 0x2000240;
      if(MEMORY.ref(1, r4 + 0x1f2).getUnsigned() == 0) {
        //LAB_808bfee
        if(player != null) {
          //LAB_808bff6
          if(player.dest_38.getX() != 0x80000000) {
            //LAB_808c002
            int encounterRate = player.velocityScalar_30.get();

            // Double encounter rate flag
            if(readFlag_(0x167) != 0) {
              encounterRate *= 2;
            }

            //LAB_808c012
            final int r7;
            int encounterId;
            if(r8._19e.get() == 3) {
              encounterId = FUN_808b048(player.pos_08, encounterRate);
              r7 = 0x1;
            } else {
              //LAB_808c034
              if(tileType > 0xef && tileType < 0xf2) {
                encounterId = tileType - 0xef;
              } else {
                //LAB_808c04c
                encounterId = 0;
              }

              //LAB_808c058
              r7 = r8._1a0.get(encounterId).get();
              encounterId = FUN_808b02c(encounterId, encounterRate);
            }

            //LAB_808c062
            r8.encounterId_17c.set(encounterId);

            int recoverStep = mul16(r8._1b0.get(), player.velocityScalar_30.get());
            if(r7 == 0) {
              recoverStep /= 2;
            }

            //LAB_808c082
            r8.movementEffectCounter_1b4.add(recoverStep);
            if(r8.movementEffectCounter_1b4.get() > 0xffff) {
              addPpToAll(r8.movementEffectCounter_1b4.get() / 0x10000);
              r8.movementEffectCounter_1b4.and(0xffff);
              if(tickRecoveryQueue_()) {
                playSound_(0x8b);
              }

              //LAB_808c0b8
              FUN_8091858();
              tookDamage = applyPoisonAndVenomInWorld();
            }

            //LAB_808c0c2
            if(MEMORY.ref(2, r4 + 0x22e).get() == 0 && tileType == 0xfa) {
              if(r8.oldTiles_1bc.deref().get(0).getType() == 0xfa) {
                MEMORY.ref(2, r4 + 0x232).addu(player.velocityScalar_30.get() / 0x10000);
              } else {
                //LAB_808c128
                MEMORY.ref(2, r4 + 232).setu(MEMORY.ref(2, r4 + 0x22c).get() / 2);
              }
            }

            //LAB_808c140
            if(MEMORY.ref(4, r4 + 0x244).get() != 0 && MEMORY.ref(2, r4 + 0x23e).get() != 2) {
              MEMORY.ref(4, r4 + 0x244).subu(player.velocityScalar_30.get());
              if(MEMORY.ref(4, r4 + 0x244).get() <= 0) {
                MEMORY.ref(4, r4 + 0x244).setu(0x1);
                if(r8.usedAbility_17e.get() == 0) {
                  r8.usedAbility_17e.set(0x2096);
                }
              }
            }
          }
        }
      }

      //LAB_808c17a
      if(MEMORY.ref(2, r4 + 0x22e).get() == 1) {
        MEMORY.ref(2, r4 + 0x232).incr();
        if(MEMORY.ref(2, r4 + 0x232).get() == MEMORY.ref(2, r4 + 0x22c).get() / 2) {
          FUN_8093874(playerMapActorIndex_2000434.get(), 0x101);
        }

        //LAB_808c1b6
        if(MEMORY.ref(2, r4 + 0x232).get() == MEMORY.ref(2, r4 + 0x22c).get()) {
          FUN_8093874(playerMapActorIndex_2000434.get(), 0x100);
        }
      }

      //LAB_808c1d0
      if(MEMORY.ref(2, r4 + 0x232).get() >= MEMORY.ref(2, r4 + 0x22c).get()) {
        final int r1_0 = MEMORY.ref(2, r4 + 0x230).get();
        MEMORY.ref(2, r4 + 0x232).setu(0);
        FUN_808c30c(-(r1_0 & 0xff), r1_0 & 0x100);
        tookDamage++;
      }

      //LAB_808c20e
      if(tookDamage != 0) {
        r8._184.set(0);
        r8._186.set(0);
        player.velocity_24.setY(0x40000);
        FUN_8093874(playerMapActorIndex_2000434.get(), 0x102);

        //LAB_808c258
        for(int charSlot = 0; charSlot < charCount; charSlot++) {
          final Unit14c charData = getUnit_(MEMORY.ref(1, r4 + 0x1f8 + charSlot).getUnsigned());
          if(charData.hp_38.get() > 0) {
            r8._186.incr();
            //LAB_808c26e
          } else if(sp0x1c[charSlot] != 0) {
            MEMORY.ref(2, r8._188.getAddress() + r8._184.get() * 0x2).setu(MEMORY.ref(1, r4 + 0x1f8 + charSlot).getUnsigned()); //TODO
            r8._182.set(-1);
            r8._184.incr();
            charData.affliction_131.set(0);
          }

          //LAB_808c2a2
        }
      }
    }

    //LAB_808c2ac
  }

  @Method(0x808c2dc)
  public static void addPpToAll(final int amount) {
    //LAB_808c2f2
    for(int i = 0; i < getCharCount_(); i++) {
      addPp_(charIds_2000438.get(i).get(), amount);
    }

    //LAB_808c302
  }

  @Method(0x808c30c)
  public static void FUN_808c30c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c3a4)
  public static int applyPoisonAndVenomInWorld() {
    int effectType = 0;

    //LAB_808c3ba
    for(int i = 0; i < getCharCount_(); i++) {
      final Unit14c unit = getUnit_(charIds_2000438.get(i).get());
      final int affliction = unit.affliction_131.get();
      int r1;
      if(affliction == 1) { // poison
        //LAB_808c3d4
        r1 = -divideS(unit.maxHp_34.get() + 10, 20);
        if(r1 == 0) {
          r1 = -1;
        }

        //LAB_808c3ea
        if(effectType < 1) {
          effectType = 1;
        }
      } else if(affliction == 2) { // venom
        //LAB_808c3f2
        r1 = -divideS(unit.maxHp_34.get() + 5, 10);
        if(r1 == 0) {
          r1 = -1;
        }

        //LAB_808c408
        if(effectType < 2) {
          effectType = 2;
        }
      } else {
        //LAB_808c410
        r1 = 0;
      }

      //LAB_808c412
      addHp_(charIds_2000438.get(i).get(), r1);
    }

    //LAB_808c420
    if(effectType != 0) {
      FUN_8091220(0x1ff, 0);
      calculatePaletteModificationSteps(4);
      playSound_(0x85);
    }

    //LAB_808c438
    return effectType;
  }

  /** Pressing start as soon as you gain control of the player */
  @Method(0x808c44c)
  public static void FUN_808c44c() {
    final Structccc r5 = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);
    if(r5._19e.get() == 3) {
      final int r0 = mallocSlotBoard(31, 0x540);
      if(r0 != 0 && MEMORY.ref(1, r0 + 0x53d).get() != 0) {
        MEMORY.ref(1, r0 + 0x53a).setu(0);
        MEMORY.ref(1, r0 + 0x53b).setu(0);
        MEMORY.ref(1, r0 + 0x53c).setu(0x1);
        MEMORY.ref(1, r0 + 0x53d).setu(0);
      }

      //LAB_808c498
      r5.actor_1e0.deref()._5b.set(0x1);
      FUN_8009230();
    }

    //LAB_808c4aa
  }

  @Method(0x808c4c0)
  public static void FUN_808c4c0() {
    final Structccc r5 = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);
    if(r5._19e.get() == 3) {
      FUN_8009238();
      r5.actor_1e0.deref()._5b.set(0);
    }

    //LAB_808c4ec
  }

  @Method(0x808c4f8)
  public static int mapLoop(int r0) {
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;
    final int r9;

    final Structccc r8 = MEMORY.ref(4, mallocSlotBoard(27, 0xccc), Structccc::new);
    MEMORY.memfill(r8.getAddress(), 0xccc, 0);

    clearFlag_(0x103);
    _2000408.set(mapId_2000400.get());
    _200040a.set(entranceId_2000402.get());
    _200040e.set(-1);
    _2000410.set(-1);
    _2000412.set(-1);
    _2000414.set(-1);
    clearTickCallbacks();
    FUN_8095778(0);
    r0 = _200041a.get();
    if(r0 == 1) {
      FUN_8009118();
      _2000464.set(1);
      FUN_808ace0(0);
      r6 = 3;
    } else {
      //LAB_808c598
      loadMap_(r0);
      FUN_808ace0(1);
      r6 = 2;
    }

    //LAB_808c5a4
    r8._19e.set(r6);
    initActors_(r6);
    FUN_8015000();
    FUN_808bc44();
    r8.events_10.setPointer(getEvents_2008024.deref().run());
    loadRooms();
    loadMapActors(getActors_200801c.deref().run());

    if(readFlag_(0x109) != 0) {
      FUN_808bb2c();
    }

    //LAB_808c5e2
    if(_2000474.get() != 0) {
      FUN_8095680();
    }

    //LAB_808c5f6
    if(r6 == 3) {
      FUN_8009130();
      FUN_8009138(_200041c.get(), _2000424.get());
    } else {
      //LAB_808c614
      FUN_8009128();
    }

    //LAB_808c618
    loadChests();
    allocatePaletteModifier();
    FUN_8091200(0x10000, 0);
    r8._1c0.set(0x100);
    r8._1c8.set(0x10);
    r8._1c6.set(0);
    r8._1b0.set(0x199);
    r8.movementEffectCounter_1b4.set(0);

    if(_200047e.get() == 2) {
      r8._1b0.set(0);
      setFlag_(0x144);
    }

    //LAB_808c678
    r8.oldTiles_1bc.set(tileAttribs_2010000);

    if(readFlag_(0x109) == 0) {
      FUN_808b1d8();
      _200046c.set(0x10);
      _200046e.set(0);
      _2000470.set(1);
      _200048a.set(-1);
      _200048c.set(0);
    }

    //LAB_808c6bc
    FUN_8099810();
    r8.soundId_cc8.set(-1);
    init_2008004.deref().run();
    r0 = r8._170.get();
    if(r0 != 0) {
      r7 = r0;
      r8._170.set(0);
    } else {
      //LAB_808c6ec
      clearFlag_(0x109);

      if(wasActionPerformed() == 0) {
        if(r8._1c6.get() == 0) {
          FUN_808fefc(r8._1c0.get(), r8._1c8.get());
          r8._1c6.set(0x1);
          MEMORY.ref(2, 0x5000000).setu(0);

          if(FUN_8094428() == 0) {
            sleep((r8._1c8.get() + 1) / 2);
          }
        }

        //LAB_808c72e
        if(readFlag_(0x12f) != 0) {
          clearFlag_(0x12f);
          FUN_8015200();
        }

        //LAB_808c750
        if(_2000474.get() != 0) {
          FUN_8095778(_2000474.get());
          _2000474.set(0);
        }

        //LAB_808c76a
        if(_200047c.get() != 0) {
          FUN_808c44c();

          if(FUN_80919d8(_200047c.get()) == 0) {
            FUN_8091a58(_200047c.get(), 0);
          }

          //LAB_808c78c
          FUN_808c4c0();
          _200047c.set(0);
        }
      }

      //LAB_808c794
      r9 = 0x2000240;

      //LAB_808c79c
      outer:
      do {
        setFlag_(0x104);
        final Actor70 r10 = r8.actors_14.get(playerMapActorIndex_2000434.get()).deref();
        FUN_8009140(r10);
        MEMORY.ref(4, r9 + 0x1dc).setu(r10.pos_08.getX());
        MEMORY.ref(4, r9 + 0x1e0).setu(0);
        MEMORY.ref(4, r9 + 0x1e4).setu(r10.pos_08.getZ());
        MEMORY.ref(4, r9 + 0x1e8).setu(r10.angle_06.get());
        _200042c.set(r10.layer_22.get());

        //LAB_808c838
        while(wasActionPerformed() != 0) {
          r5 = r8._170.get();
          if(r5 != 0) {
            //LAB_808c6e4
            r7 = r5;
            r8._170.set(0);
            break outer;
          }

          //LAB_808c848
          if(r8._182.get() != 0) {
            //LAB_808c858
            r8._cb6.set(0x1);

            r0 = r8._182.get();
            if(r0 != -1) {
              //LAB_808c9d4
              if(r0 == -0x378) {
                stopPlayerAndSetIdle();
                FUN_809c138(0x1b);
                //LAB_808c9e6
              } else if(r0 == -0x379) {
                stopPlayerAndSetIdle();
                FUN_809c3a4();
              } else {
                //LAB_808c9f6
                FUN_808d7d8(r0);
              }
            } else {
              //LAB_808c86e
              stopPlayerAndSetIdle();
              FUN_808c44c();

              //LAB_808c894
              for(r6 = 0; r6 < r8._184.get(); r6++) {
                setActorAnimation_(r10, 0x16);
                FUN_8015120(MEMORY.ref(2, r8._188.getAddress() + r6 * 0x2).get(), 0x1); //TODO
                FUN_8015040(0x91a, 0x1);
              }

              //LAB_808c8c0
              if(r8._186.get() != 0) {
                //LAB_808c9c0
                FUN_808c4c0();
              } else {
                //LAB_808c8d0
                if(playerMapActorIndex_2000434.get() != 0) {
                  //LAB_808c900
                  setActorAnimation_(r10, 0x13);
                } else if(readFlag_(0x20) != 0) {
                  setActorAnimation_(r10, 0x15);
                } else {
                  //LAB_808c8ec
                  setActorAnimation_(r10, 0x25);
                }

                //LAB_808c908
                playSound_(0x3b);
                FUN_8015040(0x91b, 0x1);
                final Unit14c charData = getUnit_(playerMapActorIndex_2000434.get());
                charData.hp_38.set(0x1);
                r5 = MathHelper.clamp(divideS(0x4000, charData.maxHp_34.get()), 0, 0x4000);

                //LAB_808c950
                if(r5 == 0 && charData.hp_38.get() != 0) {
                  charData.fractionHp_14.set(1);
                } else {
                  charData.fractionHp_14.set(r5);
                }

                //LAB_808c964
                r3 = MathHelper.clamp(divideS(charData.pp_3a.get() << 14, charData.maxPp_36.get()), 0, 0x4000);

                //LAB_808c988
                if(r3 == 0 && charData.pp_3a.get() != 0) {
                  charData.fractionPp_16.set(1);
                } else {
                  charData.fractionPp_16.set(r3);
                }

                //LAB_808c99c
                MEMORY.ref(2, r9 + 0x1c0).setu(MEMORY.ref(2, r9 + 0x1c4).getUnsigned());
                entranceId_2000402.set(MEMORY.ref(2, r9 + 0x1c6).getUnsigned());
                FUN_808c4c0();
                r7 = 999;
                break outer;
              }
            }

            //LAB_808c9fa
            r8._cb6.set(0);
            r8._182.set(0);
            //LAB_808ca0e
          } else if(r8.encounterId_17c.get() != 0) {
            stopPlayerAndSetIdle();
            FUN_808ba38();
            MEMORY.ref(2, r9 + 0x21e).setu(0xffff);
            MEMORY.ref(2, r9 + 0x1c0).setu(0x1fe);
            entranceId_2000402.set(r8.encounterId_17c.get());
            r8._170.set(999);
            FUN_80941e0();
            r8._1a8.set(0);
            r8.encounterId_17c.set(0);
            _2000478.set(0);
            //LAB_808ca5e
          } else if(r8._16c.get() != 0) {
            r8._cb6.set(0x1);
            FUN_808d828(r8._16c.get());
            r8._cb6.set(0);
            r8._16c.set(0);
            //LAB_808ca86
          } else if(r8._16e.get() != 0) {
            FUN_808d8f0(r8._16e.get());
            r8._16e.set(0);
            //LAB_808cac4
          } else if(r8.interactPressed_174.get() != 0) {
            // Pressing interact button

            FUN_8015208();
            final int closestActor = getClosestActorInFront(playerMapActorIndex_2000434.get());

            if(closestActor != -1 && FUN_808d5a4(closestActor) != null) {
              r8.interactedActor_178.set(closestActor | 0x1000);
              r8.menuPressed_172.set(0);
            } else {
              //LAB_808cb1c
              final int interactedTileType = getInteractedTileType();
              if(interactedTileType != 0) {
                r8.interactedTileType_17a.set(interactedTileType);
                r8.menuPressed_172.set(0);
              } else {
                //LAB_808cb3a
                r8.menuPressed_172.set(1);
              }
            }

            //LAB_808cb44
            r8.interactPressed_174.set(0);
            //LAB_808cb4c
          } else if(r8.menuPressed_172.get() != 0) {
            FUN_8015208();
            stopPlayerAndSetIdle();
            playSound_(0x6f);
            FUN_808c44c();
            setFlag_(0x106);

            if(debug_3001f54.get() == 0 || (heldButtonsLastFrame_3001ae8.get() & 0x2) == 0 || (heldButtonsLastFrame_3001ae8.get() & 0x4) == 0) {
              //LAB_808cb98
              if(readFlag_(0x107) != 0) {
                r8._182.set(0xfa);
              } else {
                //LAB_808cbae
                r8._cc0.set(0);
                handleIngameMenus_();
                r8._cc0.set(0x1);
              }
            } else {
              FUN_8015290();
            }

            //LAB_808cbbe
            FUN_808c4c0();
            clearFlag_(0x106);
            cacheEncounterRateBoost_();
            r8.menuPressed_172.set(0);
            //LAB_808cbe4
          } else if(r8.interactedActor_178.get() != 0) {
            FUN_808c44c();
            interactWithActor(r8.interactedActor_178.get() & 0xfff);
            FUN_808c4c0();
            r8.interactedActor_178.set(0);
            //LAB_808cc02
          } else if(r8.interactedTileType_17a.get() != 0) {
            FUN_808c44c();
            interactWithTile(r8.interactedTileType_17a.get());
            FUN_808c4c0();
            r8.interactedTileType_17a.set(0);
            //LAB_808cc24
          } else if(r8.usedAbility_17e.get() != 0) {
            FUN_8015208();
            FUN_808c44c();
            usePsynergy(r8.usedAbility_17e.get());
            FUN_808c4c0();
            r8.usedAbility_17e.set(0);
            //LAB_808cc4a
          } else if(r8.usedItem_180.get() != 0) {
            FUN_808c44c();
            FUN_808e23c(r8.usedItem_180.get(), r8._19a.get());
            FUN_808c4c0();
            r8.usedItem_180.set(0);
            //LAB_808cc76
          } else if(r8.systemMenuPressed_176.get() != 0) {
            playSound_(0x6f);
            stopPlayerAndSetIdle();
            FUN_808c44c();
            setFlag_(0x106);

            if(debug_3001f54.get() != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x2) != 0) {
              FUN_8015288();
              //LAB_808ccb4
            } else if(debug_3001f54.get() != 0 && (heldButtonsLastFrame_3001ae8.get() & 0x200) != 0) {
              FUN_808d0c8();
              //LAB_808ccce
            } else if(readFlag_(0x107) != 0) {
              r8._182.set(0xfa);
            } else {
              //LAB_808cce4
              FUN_808e118();
              FUN_8015208();
              MEMORY.ref(2, r9 + 0x21e).setu(FUN_80f9070());
              if(readFlag_(0x17e) == 0) {
                final int r5_0 = MEMORY.ref(4, 0x3001e68).get();
                r0 = 0;

                //LAB_808cd0e
                for(r2 = 0; r2 < 0x200; r2++) {
                  if(_3001810.get(r2).get() == 0xff) {
                    r0++;
                  }

                  //LAB_808cd18
                }

                if(r0 < 0x88) {
                  MEMORY.ref(2, r5_0 + 0x4).setu(0x1);
                  sleep(0x1);
                }

                //LAB_808cd30
                FUN_8015370();
                MEMORY.ref(2, r5_0 + 0x4).setu(0);
              } else {
                //LAB_808cd58
                FUN_8015040(0xc2f, 0x1);
              }
            }

            //LAB_808cd60
            FUN_808c4c0();
            clearFlag_(0x106);
            r8.systemMenuPressed_176.set(0);
          }

          //LAB_808cd76
        }

        //LAB_808cd80
        clearFlag_(0x104);

        final Actor70 player = r8.actors_14.get(playerMapActorIndex_2000434.get()).derefNullable();
        if(player != null) {
          r3 = _2000432.get();
          if(r3 == 2) {
            FUN_80090b8(player);
            //LAB_808cdb0
          } else if(r3 == 1) {
            FUN_80090b0(player);
            //LAB_808cdbc
          } else if(r8._19e.get() == 3) {
            FUN_80090a8(player);
          } else {
            //LAB_808cdd2
            FUN_80090a0(player);
          }
        }

        //LAB_808cdd8
        //LAB_808cdda
        do {
          sleep(1);
          if(debug_3001f54.get() == 0 || readFlag_(0x163) == 0) {
            //LAB_808cdfe
            FUN_808bec0(player.layer_22.get(), player.pos_08.getX(), player.pos_08.getY(), player.pos_08.getZ());
          }

          //LAB_808ce12
        } while(wasActionPerformed() == 0);
      } while(true);
    }

    //LAB_808ce1c
    if(r8._1c6.get() != 0) {
      FUN_80901c0(r8._1c0.get(), r8._1c8.get());
      r8._1c6.set(0);
      sleep(r8._1c8.get());
    }

    //LAB_808ce46
    freeSlot(27);

    return r7;
  }

  @Method(0x808ce74)
  public static int getInteractedTileType() {
    final Actor70 player = getMapActor(playerMapActorIndex_2000434.get());
    if(player == null) {
      return 0;
    }

    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    final Vec3 reach = new Vec3();
    reach.set(player.pos_08);
    rotVec3(0x100000, player.angle_06.get() & 0xffff, reach);

    final TileAttributes04 tile;
    if(r6._19e.get() == 3) {
      tile = MEMORY.ref(4, 0x2020000 + ((reach.getZ() / 0x200000 & 0x1f) * 0x20 + (reach.getX() / 0x200000 & 0x1f)) * 0x4, TileAttributes04::new); //TODO
    } else {
      //LAB_808cef2
      tile = r8.layers_104.get(0).tiles_2c.deref().get(reach.getZ() / 0x100000 * 0x80 + reach.getX() / 0x100000);
    }

    //LAB_808cf1a
    final int r6_0 = tile.getType();
    if(r6_0 <= 0xf7) {
      final int height = getHeight_(player.layer_22.get(), reach.getX(), reach.getZ());
      if(height < player.pos_08.getY() || height > player.pos_08.getY() + 0x400000) {
        return 0;
      }
    } else {
      //LAB_808cf46
      if(FUN_808d48c(0x3, r6_0) == null) {
        return 0;
      }
    }

    //LAB_808cf52
    //LAB_808cf54
    return r6_0;
  }

  @Method(0x808cf78)
  public static void loadRooms() {
    int r0;
    int r3;
    int r5;
    int r10;

    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r5 = getRooms_200800c.deref().run();
    r10 = 0;

    // Subtract 0x18 so we don't have to jump over the initial increment
    r5 -= 0x18;

    //LAB_808cfa8;
    //LAB_808cfa6
    jmp_808cfc8:
    {
      do {
        do {
          r5 += 0x18;

          //LAB_808cfa8
          r3 = MEMORY.ref(2, r5).get();
          if(r3 == -1) {
            break jmp_808cfc8;
          }
        } while(r3 != entranceId_2000402.get());

        r0 = MEMORY.ref(2, r5 + 0x2).get();
      } while(r0 != -1 && readFlag_(r0) == 0);

      //LAB_808cfc4
      r10 = 0x1;
    }

    //LAB_808cfc8
    if(r10 == 0) {
      r5 = getRooms_200800c.deref().run();
    }

    //LAB_808cfd8
    if(readFlag_(0x109) == 0) {
      _200041c.set(MEMORY.ref(2, r5 + 0x4).get() << 16);
      _2000420.set(MEMORY.ref(2, r5 + 0x6).get() << 16);
      _2000424.set(MEMORY.ref(2, r5 + 0x8).get() << 16);
      _2000428.set(MEMORY.ref(2, r5 + 0xa).getUnsigned());
      _200042c.set(0);
    }

    //LAB_808d020
    r3 = MEMORY.ref(2, r5 + 0xe).get();
    if(r3 != -1) {
      r7._ec.set(r3 << 16);
    }

    //LAB_808d03a
    r3 = MEMORY.ref(2, r5 + 0x10).get();
    if(r3 != -1) {
      r7._f0.set(r3 << 16);
    }

    //LAB_808d050
    r3 = MEMORY.ref(2, r5 + 0x12).get();
    if(r3 != -1) {
      r7._f4.set(r3 << 16);
    }

    //LAB_808d066
    r0 = MEMORY.ref(2, r5 + 0x14).get();
    if(r0 != -1) {
      r7._f8.set(r0 << 16);
    }

    //LAB_808d07c
    if(r7._ec.get() > r7._f4.get() - 0xf00000) {
      r7._ec.set(r7._f4.get() - 0xf00000);
    }

    //LAB_808d090
    if(r7._f0.get() > r7._f8.get() - 0xa00000) {
      r7._f0.set(r7._f8.get() - 0xa00000);
    }

    //LAB_808d0a4
  }

  @Method(0x808d0c8)
  public static void FUN_808d0c8() {
    throw new RuntimeException("Not implemented");
  }

  /** Opening cutscene when leaving house */
  @Method(0x808d394)
  public static int FUN_808d394(final int r0) {
    final Structccc r7 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r6 = 8;

    //LAB_808d3a8
    int r0_0 = 0; // always set in loop but java still requires an initializer
    for(int r12 = 0; r12 < 4; r12++) {
      r0_0 = r7.actorSets_00.get(r12).get();

      if(r0_0 != 0) {
        if(r0 > 7) {
          //LAB_808d3d6
          //LAB_808d3e6
          while(MEMORY.ref(2, r0_0).get() != -1) {
            if(MEMORY.ref(2, r0_0).get() > 7) {
              if(r6 == r0) {
                if(MEMORY.ref(2, r0_0).get() == -1) {
                  r0_0 = 0;
                }

                return r0_0;
              }
              r6++;
            }

            //LAB_808d3f6
            r0_0 += 0x18;
          }
        } else {
          //LAB_808d3c0
          while(MEMORY.ref(2, r0_0).get() != -1) {
            if(MEMORY.ref(2, r0_0).get() == r0) {
              if(MEMORY.ref(2, r0_0).get() == -1) {
                r0_0 = 0;
              }

              return r0_0;
            }
            r0_0 += 0x18;
          }
        }
      }

      //LAB_808d404
    }

    //LAB_808d410
    if(MEMORY.ref(2, r0_0).get() == -1) {
      r0_0 = 0;
    }

    //LAB_808d41e
    return r0_0;
  }

  @Method(0x808d428)
  public static int FUN_808d428(final int flag) {
    if(flag == -1) {
      return 1;
    }

    //LAB_808d436
    if((flag & 0x1000) != 0) {
      return readFlag_(flag);
    }

    //LAB_808d446
    //LAB_808d454
    return readFlag_(flag) != 0 ? 0 : 1;
  }

  @Method(0x808d458)
  public static int FUN_808d458(final int r0, final int r1) {
    if((r0 & 0xf) != 3) {
      return 0;
    }

    //LAB_808d466
    if((r0 & 0x1ff) == 3) {
      return 0;
    }

    final int r3 = r1 & 0xfff00000 ^ 0x500000;

    //LAB_808d480
    return (-r3 | r3) >>> 31;
  }

  @Method(0x808d48c)
  public static EventStruct0c FUN_808d48c(final int r0, final int r1) {
    final Structccc r7 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final UnboundedArrayRef<EventStruct0c> events = r7.events_10.deref();
    final int r8 = getMapActor(playerMapActorIndex_2000434.get()).angle_06.get() & 0xffff;
    int r5;

    //LAB_808d4c4
    for(int i = 0; events.get(i)._00.get() != -1; i++) {
      final EventStruct0c r6 = events.get(i);
      r5 = r6._00.get();

      jmp_808d560:
      if((r5 & 0xf) == r0) {
        if(r6._04_b.get() == r1) {
          if(FUN_808d458(r5, r6.callback_08.get()) == 0 && FUN_808d428(r6._06.get()) == 0) {
            break jmp_808d560;
          }

          //LAB_808d4ec
          int r4 = 0;
          final int r0_0 = (r5 & 0x800) != 0 ? 0x2 : 0xc;

          //LAB_808d4fc
          final int r3 = r5 & 0x600;
          if(r3 == 0x200) {
            if(r7._19c.get() > r0_0) {
              r4 = 0x1;
            }
          } else {
            if(r3 <= 0x200) {
              if(r3 == 0) {
                r4 = 0x1;
              }
            } else {
              //LAB_808d516
              if(r3 == 0x400 || r3 == 0x600 && r7._19c.get() > r0_0) {
                //LAB_808d542
                if(((r5 & 0xf000) - r8 + 0x1fff & 0xffff) < 0x3fff) {
                  //LAB_808d558
                  r4 = 0x1;
                }
              }
            }
          }

          //LAB_808d55a
          if(r4 != 0) {
            return r6;
          }
        }
      }

      //LAB_808d560
    }

    //LAB_808d56e
    //LAB_808d570
    return null;
  }

  @Method(0x808d5a4)
  public static EventStruct0c FUN_808d5a4(final int mapActorIndex) {
    final EventStruct0c event1 = FUN_808d48c(0, mapActorIndex);
    if(_200048a.get() != mapActorIndex) {
      return event1;
    }

    final EventStruct0c event2 = FUN_808d48c(7, _200048a.get());
    if(event2 == null) {
      //LAB_808d5ca
      return event1;
    }

    //LAB_808d5cc
    return event2;
  }

  /** I'm not confident in this restructure */
  @Method(0x808d5dc)
  public static int interactWithActor(int r0) {
    final int r7 = r0;
    final int r11 = FUN_808d394(r7);
    int r9 = -1;
    final Actor70 r8 = getMapActor_(r7);
    int sp00 = 0;
    int r10 = 0;

    jmp_808d794:
    {
      EventStruct0c r6;
      if(_200048a.get() != r7) {
        //LAB_808d678
        r6 = FUN_808d48c(0, r7);
      } else {
        r10 = 1;
        if((r6 = FUN_808d48c(7, r7)) == null) {
          if((r6 = FUN_808d48c(0, r7)) == null) {
            return r9;
          }
          sp00 = 1;

          //LAB_808d63e
          if(r6.callback_08.get() >= 0x10000) {
            final int r5 = FUN_80915dc(r7) * 0x2 + (rand() * 2 >>> 16) + 0xe0b;
            FUN_80916b0();
            FUN_8092b94(r5);
            FUN_8092f84(r7, 0);
            FUN_8091750();
            break jmp_808d794;
          }
        }
      }

      //LAB_808d682
      if(r6 != null) {
        //LAB_808d688
        if(r6.callback_08.get() != 0) {
          int sp04 = 0;

          //LAB_808d690
          int r3;
          if(r10 == 0) {
            r8._5b.set(1);
            FUN_8009088(r8, 0);
            sp04 = r8.angle_06.get() & 0xffff;
            r3 = MEMORY.ref(1, r11 + 0x16).getUnsigned();
            if(r3 < 2 || r3 == 3) {
              //LAB_808d6c2
              final Actor70 player = getMapActor_(playerMapActorIndex_2000434.get());
              player.dest_38.set(player.pos_08);
              player.velocity_24.zero();
              FUN_8092848(r7, playerMapActorIndex_2000434.get(), 0);
            }
          }

          //LAB_808d6f0
          if(r6.callback_08.get() < 0x10000) {
            FUN_8015058(sp00);
            FUN_80916b0();
            FUN_8092b94(r6.callback_08.get());
            FUN_8092f84(r7, 0);
            FUN_8091750();
          } else {
            //LAB_808d716
            stopPlayerAndSetIdle();
            LOGGER.info("Calling event %s param %x", r6.callback_08, r7);
            MEMORY.call(r6.callback_08.get(), r7);
          }

          //LAB_808d722
          if(r10 == 0) {
            r3 = r8.scriptPos_04.get();
            final int r2 = r8.scriptPtr_00.get();
            if(MEMORY.ref(4, r2 + r3 * 0x4).get() == 0x10) {
              r0 = MEMORY.ref(1, r11 + 0x16).get();
              if(r0 == 3) {
                r8.parent_68.set(getMapActor_(playerMapActorIndex_2000434.get()));
                r8._5a.or(0x1);
                FUN_8093a6c(r8, 0x809ff40);
                //LAB_808d76a
              } else if(r0 == 1) {
                r8._64.set(sp04);
                setActorSpriteScript_(r8, 0x809fc1c);
              }
            }

            //LAB_808d780
            r8._5b.set(0);
            FUN_8009088(r8, 16);
          }

          //LAB_808d790
          r9 = 0;
        }
      }
    }

    //LAB_808d794
    if(r10 != 0) {
      FUN_809ade8(_200048a.get());
      _200048a.set(-1);
    }

    //LAB_808d7ac
    //LAB_808d7ae
    return r9;
  }

  @Method(0x808d7d8)
  public static int FUN_808d7d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d828)
  public static int FUN_808d828(final int r0) {
    final Structccc r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int r7 = -1;

    final EventStruct0c r5 = FUN_808d48c(0x2, r0);
    if(r5 != null && r5.callback_08.get() != 0) {
      if((r5._00.get() & 0x200) != 0) {
        r8._19c.set(0);
      }

      final int r1 = r5.callback_08.get();

      //LAB_808d864
      if(r1 < 0x10000) {
        FUN_80916b0();
        FUN_8092b94(r1);
        FUN_8092f84(-1, 0); // -1 as the first param might be a retail bug?
        FUN_8091750();
      } else {
        //LAB_808d886
        LOGGER.info("Calling event %07x param %x", r1, r0);
        MEMORY.call(r1, r0); // call event function
      }
      r7 = 0;
    } else {
      //LAB_808d88e
      final EventStruct0c r5_0 = FUN_808d48c(0x1, r0);
      if(r5_0 != null) {
        final int r2 = r5_0._00.get() & 0x30;
        if(r2 == 0) {
          //LAB_808d8b4
          playSound_(0x7b);
        } else if(r2 == 0x20) {
          //LAB_808d8bc
          playSound_(0x80);
          FUN_8094354();
        } else if(r2 == 0x30) {
          //LAB_808d8c8
          playSound_(0x81);
          FUN_8094368();
        }

        //LAB_808d8d2
        r8._170.set(r5_0.callback_08.get());
        r7 = 0;
      }
    }

    //LAB_808d8de
    return r7;
  }

  /** Seems to trigger when approaching a jumpable gap */
  @Method(0x808d8f0)
  public static int FUN_808d8f0(final int r0) {
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);

    if(r0 == 0xf9) {
      //LAB_808d93e
      if(r5._19c.get() > 0xc) {
        FUN_8093c00();
        r5._19c.set(0);
      }
      return 0;
    }

    if(r0 == 0xfc) {
      //LAB_808d918
      if(r5._19c.get() > 0xc && (heldButtonsLastFrame_3001ae8.get() & Input.BUTTON_DOWN) != 0x0) {
        FUN_8092708(playerMapActorIndex_2000434.get(), 6, 0);
        r5._19c.set(0);
      }
      return 0;
    }

    //LAB_808d90e
    if(r0 == 0xfd) {
      //LAB_808d956
      if(r5._19c.get() > 0xc) {
        if((heldButtonsLastFrame_3001ae8.get() & Input.BUTTON_DOWN) != 0x0) {
          FUN_8093e28();
          //LAB_808d976
        } else if((heldButtonsLastFrame_3001ae8.get() & Input.BUTTON_UP) != 0x0) {
          FUN_8093fa0();
        }

        //LAB_808d984
        r5._19c.set(0);
      }
      return 0;
    }

    if(r0 == 0xfe) {
      //LAB_808d93e
      if(r5._19c.get() > 0xc) {
        FUN_8093c00();
        r5._19c.set(0);
      }
      return 0;
    }

    //LAB_808d98e
    return 0;
  }

  @Method(0x808d9a4)
  public static int interactWithTile(final int r0) {
    int r1;
    int r2;
    final int r3;
    int r5;
    int r8;
    int r10;
    final int r11;

    r8 = r0;
    r5 = r8 - 0xf2;
    CPU.cmpT(r5, 0x5);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      stopPlayerAndSetIdle();
      r8 = MEMORY.ref(1, 0x809e680 + r5).getUnsigned();
      FUN_8015040(r8 + 0x928, 0x1);
      FUN_8015040(r8 + 0x948, 0x1);
    } else {
      //LAB_808d9e6
      final EventStruct0c r7 = FUN_808d48c(0x3, r8);
      if(r7 != null) {
        //LAB_808d9f6
        r5 = (r7._00.get() >> 4) & 0x1f;
        r10 = r7._06.get();
        if((r7._04_s.get() & 0x400) == 0 && r5 != 0) {
          stopPlayerAndSetIdle();
          FUN_8015040(r5 + 0x928, 0x1);
          setFlag_(0x142);
        } else {
          //LAB_808da2c
          clearFlag_(0x142);
        }

        //LAB_808da34
        r2 = r7.callback_08.get();
        if((r2 & 0xf000000) != 0) {
          //LAB_808da4e
          if(FUN_808d428(r10) != 0) {
            LOGGER.info("Calling event %07x param %x", r2, playerMapActorIndex_2000434.get());
            MEMORY.call(r2, playerMapActorIndex_2000434.get());
          }

          //LAB_808da68
          if(readFlag_(0x142) != 0) {
            //LAB_808da76
            FUN_8015040(r5 + 0x948, 0x1);
          }
        } else if((r2 & 0xfff00000) == 0x400000) {
          //LAB_808da82
          if(FUN_808d428(r10) != 0) {
            FUN_8015040(r7._08_s.get(), 0x1);
          } else {
            //LAB_808da90
            FUN_8015040(0x976, 0x1);
          }

          //LAB_808da92
        } else {
          //LAB_808da9a
          FUN_80916b0();

          if(FUN_808d428(r10) != 0) {
            //LAB_808daaa
            r1 = r7.callback_08.get();
            if((r1 & 0xf0000) == 0x10000 && playerMapActorIndex_2000434.get() < 8) {
              r2 = 0;
            } else {
              r2 = 1;
            }

            //LAB_808dac2
            if(r2 == 0) {
              //LAB_808dd3c
              FUN_8015040(0x96f, 0x1);
            } else {
              //LAB_808dac8
              r11 = 0x1ff;
              if((r7._00.get() & 0x1ff) == 0x13) {
                FUN_808ece0(r8);
                r1 = r7.callback_08.get();
              }

              //LAB_808dadc
              r3 = r1 & 0xfff00000;
              if(r3 == 0x300000) {
                if((r7._00.get() & r11) == 0x13) {
                  FUN_808ed1c(r8);
                }

                //LAB_808daf8
                final Actor70 r6 = FUN_808ed4c(r8);
                FUN_808f0d8(r6);
                playSound_(0x53);
                FUN_8015120(r7._08_s.get(), 0x5);
                FUN_8015040(0x970, 0x3);
                addPpToAll(999);
                FUN_8015128(0x1);
                playSound_(0x7e);
                FUN_8015040(0x971, 0x1);
                FUN_8015138();
                setActorAnimation_(r6, 0x2);
                playSound_(0xf6);
                FUN_809163c(0x1e);
                FUN_8015040(0x972, 0x1);
                FUN_808ed78(r8);

                if(r10 != -1) {
                  //LAB_808db6a
                  setFlag_(r10);
                }
              } else {
                //LAB_808db98
                if(r3 == 0x500000) {
                  if((r7._00.get() & r11) == 0x13) {
                    FUN_808ec8c(r8);
                  }

                  //LAB_808dbb4
                  if(r10 != -1) {
                    r10 |= 0x1000;
                    MEMORY.ref(2, 0x2000474).setu(r10);
                  }

                  //LAB_808dbd0
                  boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).encounterId_17c.set(getEncounterId(0x63, r7._08_s.get()));
                  MEMORY.ref(1, 0x200046b).setu(0x2);
                  FUN_808b320(0x63, r7._08_s.get());
                  playSound_(MEMORY.ref(2, 0x200042e).get());
                  FUN_8015040(0x973, 0x1);
                  //LAB_808dc18
                } else if(r3 == 0x200000) {
                  final Actor70 actor = FUN_808ef70(playerMapActorIndex_2000434.get(), 0);
                  sleep(30);

                  if((r7._00.get() & r11) == 0x13) {
                    FUN_808ed1c(r8);
                  }

                  //LAB_808dc48
                  FUN_808f0d8(actor);
                  playSound_(0x53);
                  FUN_8015120(r7._08_s.get(), 0x5);
                  FUN_8015040(0x969, 0x3);
                  addCoins_(r7._08_s.get());

                  if(r10 != -1) {
                    setFlag_(r10);
                  }

                  //LAB_808dc78
                  clearActor_(actor);
                } else {
                  //LAB_808dc80
                  final Actor70 r9 = FUN_808ef70(playerMapActorIndex_2000434.get(), r1 & 0xfff);
                  sleep(30);
                  final int r6 = giveItem_(r7._08_s.get());
                  if(r6 == -1) {
                    FUN_8015120(r7.callback_08.get() & 0xfff, 0x2);
                    FUN_8015040(0x968, 0x1);
                    FUN_8015040(0x96c, 0x1);
                    clearActorIfNotNull(r9);

                    if((r7._00.get() & r11) == 0x13) {
                      FUN_808ec50(r8);
                    }
                  } else {
                    //LAB_808dcde
                    if((r7._00.get() & r11) == 0x13) {
                      FUN_808ed1c(r8);
                    }

                    //LAB_808dcee
                    FUN_808f0d8(r9);
                    playSound_(0x53);
                    FUN_8015120(r7.callback_08.get() & 0xffff, 0x2);

                    if(r6 == playerMapActorIndex_2000434.get()) {
                      FUN_8015040(0x96a, 0x3);
                    } else {
                      //LAB_808dd16
                      FUN_8015120(r6, 0x1);
                      FUN_8015040(0x96b, 0x3);
                    }

                    //LAB_808dd26
                    if(r10 != -1) {
                      setFlag_(r10);
                    }

                    //LAB_808dd34
                    clearActor_(r9);
                  }
                }
              }
            }
          } else {
            //LAB_808dd46
            FUN_8015040(r5 + 0x948, 0x1);
          }

          //LAB_808dd50
          FUN_8091750();
          FUN_809202c();
        }
      } else {
        //LAB_808dd5a
        FUN_8015040(0x92d, 0x1);
        FUN_8015040(0x94d, 0x1);
      }

      //LAB_808dd6a
      clearFlag_(0x142);
    }

    //LAB_808dd72
    return 0;
  }

  @Method(0x808ddb8)
  public static int getFieldPsynergyRange(final int fieldPsynergyId) {
    for(int i = 0; i < fieldPsynergyRanges_809e686.length(); i++) {
      final FieldPsynergyRange04 range = fieldPsynergyRanges_809e686.get(i);

      if(range.fieldPsynergyId_00.get() == fieldPsynergyId) {
        return range.range_02.get();
      }
    }

    return 16;
  }

  /** Gets the closest actor that is in front of the passed in actor */
  @Method(0x808ddec)
  public static int getClosestActorInFront(final int mapActorIndex) {
    int closestActor = -1;
    int closestDistance = 32;
    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      //LAB_808de16
      for(int otherMapActorIndex = 0; otherMapActorIndex < 67; otherMapActorIndex++) {
        if(otherMapActorIndex != mapActorIndex) {
          final Actor70 otherActor = getMapActor(otherMapActorIndex);
          if(otherActor != null) {
            if((otherActor._59.get() & 0x8) == 0 && Math.abs(otherActor.pos_08.getY() - actor.pos_08.getY()) < 0x300000) {
              //LAB_808de50
              final int dx = (otherActor.pos_08.getX() - actor.pos_08.getX()) / 0x10000;
              final int dy = (otherActor.pos_08.getY() - actor.pos_08.getY()) / 0x10000;
              final int dz = (otherActor.pos_08.getZ() - actor.pos_08.getZ()) / 0x10000;
              int distance = sqrt(dx * dx + dy * dy + dz * dz);
              if((otherActor._59.get() & 0x4) != 0) {
                distance = divideS(distance * 10, 13);
              }

              //LAB_808deb2
              if(distance < closestDistance) {
                final int angle = atan2(otherActor.pos_08.getZ() - actor.pos_08.getZ(), otherActor.pos_08.getX() - actor.pos_08.getX());

                if(distance < 0xc || Math.abs((short)(angle - actor.angle_06.get())) < 0x3000) {
                  //LAB_808dee2
                  closestActor = otherMapActorIndex;
                  closestDistance = distance;
                }
              }
            }
          }
        }

        //LAB_808dee8
      }
    }

    //LAB_808def2
    return closestActor;
  }

  @Method(0x808df1c)
  public static int findFieldPsynergyTarget(final int mapActorIndex, final int fieldPsynergyId) {
    int closestMapActorIndex = -1;
    int closestDistance = getFieldPsynergyRange(fieldPsynergyId); // get max distance

    final Actor70 actor = getMapActor(mapActorIndex);
    if(actor != null) {
      //LAB_808df4c
      final int r11 = actor.angle_06.get() + 0x2000 & 0xc000;

      //LAB_808df60
      for(int otherMapActorIndex = 0; otherMapActorIndex < 67; otherMapActorIndex++) {
        if(otherMapActorIndex != mapActorIndex) {
          final Actor70 otherActor = getMapActor(otherMapActorIndex);
          if(otherActor != null) {
            if((otherActor._59.get() & 0x8) == 0) {
              final int maxHeightDifference = switch(fieldPsynergyId) {
                case 13 -> 0x300000;
                case 5 -> 0x400000;
                case 2 -> 0x100000;
                default -> 0x80000;
              };

              //LAB_808dfa4
              //LAB_808dfb4
              if(Math.abs(actor.pos_08.getY() - otherActor.pos_08.getY()) <= maxHeightDifference) {
                //LAB_808dfba
                final int dx = (otherActor.pos_08.getX() - actor.pos_08.getX()) / 0x10000;
                final int dz = (otherActor.pos_08.getZ() - actor.pos_08.getZ()) / 0x10000;
                int distance = sqrt(dx * dx + dz * dz);
                if((otherActor._59.get() & 0x10) != 0) {
                  distance = divideS(distance * 2, 3);
                }

                //LAB_808e006
                if(distance < closestDistance) {
                  final int angle = atan2(otherActor.pos_08.getZ() - actor.pos_08.getZ(), otherActor.pos_08.getX() - actor.pos_08.getX()) & 0xffff;

                  int maxAngleDelta;
                  if(distance > 19) {
                    maxAngleDelta = 0x1000;
                  } else {
                    maxAngleDelta = 0x1800;
                  }

                  //LAB_808e02c
                  if(fieldPsynergyId == 2) {
                    maxAngleDelta = 0x2000;
                  }

                  //LAB_808e036
                  if(distance < 12) {
                    closestMapActorIndex = otherMapActorIndex;
                    closestDistance = distance;
                  } else if(Math.abs((short)(angle - r11)) < maxAngleDelta) {
                    //LAB_808e04c
                    closestMapActorIndex = otherMapActorIndex;
                    closestDistance = distance;
                  }
                }
              }
            }
          }
        }

        //LAB_808e052
      }
    }

    //LAB_808e05c
    return closestMapActorIndex;
  }

  @Method(0x808e0b0)
  public static void FUN_808e0b0(final Actor70 r0, final int r1) {
    if((r0.spriteType_54.get() & 0xf) == 1) {
      final int r4;
      if(r1 == 0) {
        r4 = MEMORY.ref(1, 0x809e6b8 + (_3001e40.get() >>> 1 & 0x7)).getUnsigned();
      } else {
        r4 = r1 - 1;
      }

      //LAB_808e0d8
      //LAB_808e0e8
      final Sprite38 r12 = r0.sprite_50.deref();
      for(int i = 0; i < r12.layerCount_27.get(); i++) {
        final SpriteLayer18 r2 = r12.layers_28.get(i).derefNullable();
        if(r2 != null && r2.dataPtr_10.get() != 0 && r2._05.get() != 0xf) {
          r2._05.set(r4);
        }

        //LAB_808e0fc
      }

      //LAB_808e102
      r12._25.set(1);
    }
  }

  @Method(0x808e118)
  public static void FUN_808e118() {
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r3._cb6.set(0);
    if(r3._cb8.get() != 0) {
      FUN_808e5d8(0x2090);
    }

    //LAB_808e138
  }

  @Method(0x808e14c)
  public static int FUN_808e14c(int r0) {
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    CPU.r8().value = r0;
    int r6 = r3.events_10.deref().getAddress(); //TODO
    CPU.sp().value -= 0x4;
    CPU.r11().value = getMapActor(playerMapActorIndex_2000434.get()).angle_06.get();
    CPU.r9().value = getClosestActorInFront(playerMapActorIndex_2000434.get());
    CPU.r8().value = CPU.r8().value & 0x1ff;
    CPU.r10().value = getTileTypeInFrontOfPlayer();
    int r1 = MEMORY.ref(4, r6).get();

    //LAB_808e224
    r0 = 0x0;
    //LAB_808e196
    while(r1 != -1) {
      final int r2 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      if((r1 & 0xf) == 4) {
        if(FUN_808d428(MEMORY.ref(2, r6 + 0x6).get()) != 0) {
          if((r2 & 0x800) == 0 || ((MEMORY.ref(2, r6 + 0x4).get() & 0xf000) - CPU.r11().value + 0x17ff & 0xffff) < 0x2fff) {
            //LAB_808e1f2
            if(CPU.r8().value == 0 || MEMORY.ref(1, r6 + 0x1).getUnsigned() == CPU.r8().value) {
              //LAB_808e200
              if((MEMORY.ref(4, r6).get() & 0x10) == 0) {
                //LAB_808e210
                r0 = r6;
                if((r2 & 0xff) == CPU.r10().value) {
                  break;
                }
              } else {
                if((r2 & 0xff) == CPU.r9().value) {
                  r0 = r6;
                  break;
                }
              }
            }
          }
        }
      }

      //LAB_808e216
      r6 = r6 + 0xc;
      r1 = MEMORY.ref(4, r6).get();
    }

    //LAB_808e226
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x808e23c)
  public static int FUN_808e23c(final int r0, final int r1) {
    int sp00 = -1;
    final int r2 = r0 & 0x3ff;
    int r10 = r0 >> 10 & 0xf;
    int r7 = 0;
    if(r10 == 0xf) {
      r10 = 0;

      //LAB_808e28a
      for(int charSlot = 0; charSlot < getCharCount_(); charSlot++) {
        int r4 = 0;
        final Unit14c unit = getUnit_(charIds_2000438.get(charSlot).get());

        //LAB_808e296
        for(int itemSlot = 0; itemSlot < 15; itemSlot++) {
          if((unit.items_d8.get(itemSlot).get() & 0x1ff) == r2) {
            r4++;
          }

          //LAB_808e2a4
        }

        if(r7 < r4) {
          r10 = charIds_2000438.get(charSlot).get();
          r7 = r4;
        }

        //LAB_808e2b4
      }
    } else {
      //LAB_808e2be
      final Unit14c unit = getUnit_(r10);

      //LAB_808e2ca
      for(int itemSlot = 0; itemSlot < 15; itemSlot++) {
        if((unit.items_d8.get(itemSlot).get() & 0x1ff) == r2) {
          r7++;
        }

        //LAB_808e2d8
      }
    }

    //LAB_808e2de
    if(r7 == 0) {
      FUN_8015040(0x927, 1);
      return -1;
    }

    //LAB_808e2f0
    int r6 = FUN_808e14c(r2);
    if(r6 != 0 && MEMORY.ref(4, r6 + 0x8).get() != 0x0) {
      clearFlag_(0x143);
      clearFlag_(0x142);

      if((MEMORY.ref(2, r6 + 0x4).getUnsigned() & 0x400) == 0) {
        FUN_8015120(r10, 1);
        FUN_8015120(r2, 2);
        FUN_8015040(0x91c, 1);
      }

      //LAB_808e334
      final int r3 = MEMORY.ref(4, r6 + 0x8).get();
      if(r3 < 0x10000) {
        final int r5 = getClosestActorInFront(playerMapActorIndex_2000434.get());
        FUN_80916b0();
        FUN_8092b94(MEMORY.ref(4, r6 + 0x8).get());
        FUN_8092f84(r5, 0);
        FUN_8091750();
      } else {
        //LAB_808e366
        MEMORY.call(r3, r2, r10, r1);
      }

      //LAB_808e370
      sp00 = 0;
    } else {
      //LAB_808e376
      clearFlag_(0x143);
      setFlag_(0x142);
      final int r5 = getItem_(r2).useAbility_28.get();
      final Structccc r8 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
      if(r5 != 0) {
        setFlag_(0x145);
        clearFlag_(0x142);
        if(r5 == 0x95) {
          if(readFlag_(0x144) == 0) {
            FUN_8015120(r2, 2);
            FUN_8015040(0x924, 13);
            r6 = FUN_8091d84(1);
            FUN_8015140();

            if(r6 != 0) {
              return 0;
            }

            mapId_2000400.set(_2000480.get());
            entranceId_2000402.set(_2000482.get());
            r8._170.set(999);
          }
        }

        //LAB_808e3fc
        FUN_8015120(r10, 1);
        FUN_8015120(r2, 2);
        FUN_8015040(0x91c, 1);
        initFieldPsynergy(r5, 0);
        r8.fieldPsynergyInUse_cc6.set(1);
        FUN_8096810();
        r8.fieldPsynergyInUse_cc6.set(0);
        FUN_8097194();
        if((getItem_(r2).useType_0c.get() & 0x1) != 0x0) {
          setFlag_(0x143);
        }
      }
    }

    //LAB_808e448
    if(readFlag_(0x142) != 0) {
      FUN_8015040(0x927, 1);
    }

    //LAB_808e45c
    if(readFlag_(0x143) != 0) {
      takeItem_(r10, r1);
    }

    //LAB_808e46e
    //LAB_808e470
    return sp00;
  }

  @Method(0x808e4b4)
  public static EventStruct0c FUN_808e4b4(final int r0, final int fieldPsynergyId, final IntRef targetOut) {
    final UnboundedArrayRef<EventStruct0c> events = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).events_10.deref();
    final int playerAngle = getMapActor(playerMapActorIndex_2000434.get()).angle_06.get() & 0xffff;
    final int target = findFieldPsynergyTarget(playerMapActorIndex_2000434.get(), fieldPsynergyId);

    if(targetOut != null) {
      targetOut.set(target);
    }

    final int sp04 = getTileTypeInFrontOfPlayer();
    final int r11;
    if(r0 == 0x70000005) {
      r11 = 1;
    } else {
      r11 = 0;
    }

    //LAB_808e502
    //LAB_808e50c
    for(int i = 0; events.get(i)._00.get() != -1; i++) {
      final EventStruct0c event = events.get(i);
      final int r2_0 = event._04_s.get();
      if((event._00.get() & 0xf) == 5) {
        if(FUN_808d428(event._06.get()) != 0) {
          if((r2_0 & 0x800) == 0 || ((r2_0 & 0xf000) - playerAngle + 0x17ff & 0xffff) < 0x2fff) {
            //LAB_808e56a
            if(getAbility_(event._01.get()).fieldPsynergyId_0c.get() == fieldPsynergyId) {
              if(r11 != 0 || (event._00.get() & 0x7000000f) == r0) {
                //LAB_808e58e
                if((event._00.get() & 0x80) != 0) {
                  return event;
                }
                if((event._00.get() & 0x10) != 0) {
                  if((r2_0 & 0xff) == target) {
                    return event;
                  }
                } else {
                  //LAB_808e5a6
                  if((r2_0 & 0xff) == sp04) {
                    return event;
                  }
                }
              }
            }
          }
        }
      }

      //LAB_808e5ae
    }

    //LAB_808e5bc
    return null;
  }

  @Method(0x808e5d8)
  public static int FUN_808e5d8(final int r0) {
    final int r8 = r0 & 0x3ff;
    final int r5 = r0 >>> 10 & 0xf;
    final int fieldPsynergyId = getAbility_(r8).fieldPsynergyId_0c.get();

    final Actor70 unused = getMapActor(playerMapActorIndex_2000434.get());

    final IntRef target = new IntRef();
    final EventStruct0c r11 = FUN_808e4b4(0x30000005, fieldPsynergyId, target);
    final EventStruct0c r10 = FUN_808e4b4(0x20000005, fieldPsynergyId, target);
    initFieldPsynergy(r8, 0);
    setFieldPsynergyTargetAndCaster(playerMapActorIndex_2000434.get(), target.get());
    FUN_8096b28(r11, r5, target.get());
    FUN_8096af0();
    FUN_8097174();
    FUN_8096b28(r10, r5, target.get());
    FUN_8097194();

    return 0;
  }

  @Method(0x808e680)
  public static int usePsynergy(final int r0) {
    final int abilityId = r0 & 0x3ff;
    final Structccc r10 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final int fieldPsynergyId = getAbility_(abilityId).fieldPsynergyId_0c.get();
    int r6 = r0 >>> 10 & 0xf;
    final Actor70 unused = getMapActor(playerMapActorIndex_2000434.get());
    int sp00 = 0;
    stopPlayerAndSetIdle();
    clearFlag_(0x145);
    if(r6 == 0xf) {
      r6 = 0x0;
    }

    //LAB_808e6d4
    if(readFlag_(0x17e) != 0x0) {
      FUN_8015120(r6, 0x1);
      FUN_8015120(abilityId, 0x4);
      FUN_8015040(0x91f, 0x1);
      return 0;
    }

    //LAB_808e6fa
    if(r10._19e.get() == 0x3 && abilityId == 0x90) {
      FUN_8015120(r6, 0x1);
      FUN_8015120(0x90, 0x4);
      FUN_8015040(0x91f, 0x1);
      return 0;
    }

    //LAB_808e71a
    if(abilityId == 0x95) {
      if(readFlag_(0x144) != 0) {
        FUN_8015120(r6, 0x1);
        FUN_8015120(0x95, 0x4);
        FUN_8015040(0x921, 0x1);
        return 0;
      }

      //LAB_808e740
      FUN_8015120(0x95, 0x4);
      FUN_8015040(0x920, 0xd);
      final int r5 = FUN_8091d84(0x1);
      FUN_8015140();
      if(r5 != 0) {
        return 0;
      }

      //LAB_808e764
      mapId_2000400.set(_2000480.get());
      entranceId_2000402.set(_2000482.get());
      r10._170.set(999);
      sp00 = 1;
    }

    //LAB_808e78e
    if((r0 & 0x2000) != 0) {
      return FUN_808e5d8(r0);
    }

    //LAB_808e7a2
    if(r6 < 8) {
      final int cost = getAbility_(abilityId).cost_09.get();
      if(getUnit_(r6).pp_3a.get() < cost) {
        FUN_8015120(r6, 0x1);
        FUN_8015120(abilityId, 0x4);
        FUN_8015040(0x91e, 0x1);

        if(sp00 != 0x0) {
          //LAB_808e7dc
          r10._170.set(0);
        }
        return 0;
      }

      //LAB_808e7e6
      addPp_(r6, -cost);
    }

    //LAB_808e7ee
    final EventStruct0c sp04 = FUN_808e4b4(0x10000005, fieldPsynergyId, null);
    final EventStruct0c r8 = FUN_808e4b4(5, fieldPsynergyId, null);
    final EventStruct0c r7 = FUN_808e4b4(0x50000005, fieldPsynergyId, null);
    int targetMapActorId = -1;
    setFlag_(0x140);
    setFlag_(0x141);
    if(sp04 != null || r8 != null || r7 != null) {
      //LAB_808e83a
      targetMapActorId = findFieldPsynergyTarget(playerMapActorIndex_2000434.get(), fieldPsynergyId);
      if(r8 != null && (r8._04_s.get() & 0x400) != 0x0) {
        clearFlag_(0x140);
        clearFlag_(0x141);
      }
    } else {
      //LAB_808e86e
      clearFlag_(0x141);
    }

    //LAB_808e874
    if(r10._19e.get() == 0x3) {
      FUN_808b8e8();
    }

    //LAB_808e886
    initFieldPsynergy(abilityId, 0);
    r10.fieldPsynergyInUse_cc6.set(1);
    setFieldPsynergyTargetAndCaster(playerMapActorIndex_2000434.get(), targetMapActorId);
    FUN_809728c();
    FUN_8096b28(sp04, r6, targetMapActorId);

    if(readFlag_(0x140) != 0) {
      if(readFlag_(0x141) != 0) {
        FUN_8096960();
      } else {
        //LAB_808e8d0
        FUN_8096810();
      }
    }

    //LAB_808e8d4
    FUN_8097174();
    FUN_8096b28(r8, r6, targetMapActorId);

    if(readFlag_(0x140) != 0x0) {
      FUN_8096ab0();
    }

    //LAB_808e8f4
    clearFlag_(0x140);
    clearFlag_(0x141);
    r10.fieldPsynergyInUse_cc6.set(0);
    FUN_8097194();

    if(r10._19e.get() == 0x3) {
      FUN_808b98c();
    }

    //LAB_808e91e
    return 0;
  }

  @Method(0x808e96c)
  public static int FUN_808e96c(final int fieldPsynergyId) {
    return FUN_808e4b4(0x70000005, fieldPsynergyId & 0xffff, null) != null ? 1 : 0;
  }

  @Method(0x808e990)
  public static int FUN_808e990(final int r0) {
    final int r3 = FUN_808e14c(r0 & 0xffff);
    return (-r3 | r3) >>> 31;
  }

  @Method(0x808e9a8)
  public static void FUN_808e9a8(final Actor70 r0) {
    final int ret = getHeight_(0, r0.pos_08.getX(), r0.pos_08.getZ());
    r0.pos_08.setY(ret);
    r0._14.set(ret);
  }

  @Method(0x808e9c0)
  public static void loadChests() {
    int r2;
    int r5;
    int r6;
    int r7;
    int r10;
    int r11;

    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    int sp00 = 0;
    r10 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._10.get();
    MEMORY.memfill(r3.chests_11c.getAddress(), 0x50, 0);

    jmp_808ebe2:
    if(r10 != 0x0) {
      //LAB_808e9fc
      r7 = MEMORY.ref(1, r10).getUnsigned();
      r10++;
      r5 = MEMORY.ref(1, r10).getUnsigned();
      r10++;

      //LAB_808ea12
      while(r7 != 0xff || r5 != 0xff) {
        final int sp04 = MEMORY.ref(1, r10).getUnsigned();
        r10++;

        if(sp04 >= 100 && sp04 < 240) {
          //LAB_808ea26
          r6 = getEvents_2008024.deref().run();
          if(MEMORY.ref(4, r6).get() != -1) {
            //LAB_808ea3c
            r11 = r7 << 20;
            r7 = r5 << 20;

            //LAB_808ea48
            for(; (r2 = MEMORY.ref(4, r6).get()) != -1; r6 += 0xc) {
              if(MEMORY.ref(2, r6 + 0x4).get() != sp04) {
                continue;
              }

              //LAB_808ea54
              final Actor70 r5_0;
              if((r2 & 0x1ff) == 0x13) {
                r5_0 = loadActor_(20, r11 + 0x80000, 0, r7 + 0x80000);
                if(r5_0 == null) {
                  continue;
                }

                //LAB_808ea74
                FUN_808e9a8(r5_0);
                FUN_80091e0(r5_0, 0);

                if(readFlag_(MEMORY.ref(2, r6 + 0x6).get()) != 0) {
                  if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) == 0x500000) {
                    clearActor_(r5_0);
                    continue;
                  }

                  //LAB_808eaa2
                  setActorAnimation_(r5_0, 2);
                }

                //LAB_808eaaa
                FUN_8009140(r5_0);
              } else {
                //LAB_808eb02
                if((r2 & 0x1ff) != 0x3) {
                  continue;
                }
                if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) != 0x300000) {
                  continue;
                }
                if(readFlag_(MEMORY.ref(2, r6 + 0x6).get()) != 0) {
                  continue;
                }
                r5_0 = loadActor_(28, r11 + 0x80000, 0, r7 + 0x80000);
                if(r5_0 == null) {
                  continue;
                }
                FUN_808e9a8(r5_0);
                FUN_80091e0(r5_0, 0);
                FUN_8009140(r5_0);
                setActorAnimation_(r5_0, 1);
              }

              r5_0._64.set(r5_0.pos_08.getX() / 0x10000);
              r5_0._66.set(r5_0.pos_08.getZ() / 0x10000);
              r5_0.flags_23.set(1);
              r5_0._59.set(1);
              final Structccc.Chest08 chest = r3.chests_11c.get(sp00);
              chest.actor_00.set(r5_0);
              chest._04.set(MEMORY.ref(2, r6 + 0x4).getUnsigned());
              chest.x_06.set(r5_0.pos_08.getX() / 0x100000);
              chest.z_07.set(r5_0.pos_08.getZ() / 0x100000);
              sp00++;
              if(sp00 < 10) {
                break;
              }
              break jmp_808ebe2;

              //LAB_808ebb8
            }
          }
        }

        //LAB_808ebc8
        r7 = MEMORY.ref(1, r10).getUnsigned();
        r10++;
        r5 = MEMORY.ref(1, r10).getUnsigned();
        r10++;
      }
    }

    //LAB_808ebe2
  }

  @Method(0x808ec14)
  public static int FUN_808ec14(final int r0) {
    final ArrayRef<Structccc.Chest08> r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c;

    for(int r1 = 0; r1 < 10; r1++) {
      if(r2.get(r1)._04.get() == r0) {
        return r1;
      }
    }

    //LAB_808ec40
    return -1;
  }

  @Method(0x808ec50)
  public static void FUN_808ec50(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 != -1) {
      final Actor70 actor = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();
      if(actor != null) {
        setActorAnimation_(actor, 0x5);
      }

      //LAB_808ec78
      playSound_(0x7d);
      sleep(12);
    }

    //LAB_808ec84
  }

  @Method(0x808ec8c)
  public static void FUN_808ec8c(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 != -1) {
      final Actor70 r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();

      sleep(18);

      if(r5 != null) {
        setActorAnimation_(r5, 0x7);
      }

      //LAB_808ecbc
      playSound_(0x92);

      if(r5 != null) {
        r5.velocity_24.setY(0x80000);
        FUN_80091e0(r5, 0x1);
      }
    }

    //LAB_808ecd4
  }

  @Method(0x808ece0)
  public static void FUN_808ece0(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 != -1) {
      final Actor70 actor = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();
      if(actor != null) {
        setActorAnimation_(actor, 0x4);
      }

      //LAB_808ed08
      playSound_(0x7c);
      sleep(12);
    }

    //LAB_808ed14
  }

  @Method(0x808ed1c)
  public static void FUN_808ed1c(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 != -1) {
      final Actor70 actor = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();
      if(actor != null) {
        setActorAnimation_(actor, 2);
      }
    }

    //LAB_808ed44
  }

  @Method(0x808ed4c)
  public static Actor70 FUN_808ed4c(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 == -1) {
      return null;
    }

    //LAB_808ed5e
    //LAB_808ed6e
    return boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();
  }

  @Method(0x808ed78)
  public static void FUN_808ed78(final int r0) {
    final int r0_0 = FUN_808ec14(r0);
    if(r0_0 != -1) {
      final Actor70 actor = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new).chests_11c.get(r0_0).actor_00.derefNullable();
      if(actor != null) {
        actor.spriteType_54.set(0);
      }
    }

    //LAB_808eda2
  }

  @Method(0x808edac)
  public static void FUN_808edac(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  /** Opening chest */
  @Method(0x808eee4)
  public static void FUN_808eee4(final Actor70 r0) {
    CPU.sp().value -= 0xc;
    final int r3 = r0.velocity_24.getY() + 0xff;
    if((r3 & 0xffff_ffffL) < 0x1ff) {
      r0._55.set(0);
    }

    //LAB_808eefe
    if(rand() * 100 >>> 16 < 10) {
      final Vec3 r6 = new Vec3();
      r6.set(r0.pos_08);
      rotVec3(rand() * 0x10, rand(), r6);
      final Actor70 r5 = FUN_8096c80(0x11d, r6.getX(), r6.getY(), r6.getZ());
      if(r5 != null) {
        setActorSpriteScript_(r5, 0x809e87c);
        setActorAnimation_(r5, 0);
        r5.sprite_50.deref().packet_00.attribs_04.attrib2_04.and(~0xc00).or(0x400);
      }
    }

    //LAB_808ef60
    CPU.sp().value += 0xc;
  }

  /** Opening chest */
  @Method(0x808ef70)
  public static Actor70 FUN_808ef70(final int r0, final int r1) {
    final Structccc r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    final Actor70 r7 = r6.actors_14.get(r0).derefNullable();

    if(r7 == null) {
      return null;
    }

    //LAB_808ef92
    final Vec3 r5 = new Vec3();
    r5.set(r7.pos_08);
    rotVec3(0x100000, r7.angle_06.get() & 0xffff, r5);
    if(r6._cb8.get() != 0x0) {
      final ArrayRef<Actor70> actors = boardWramMallocHead_3001e50.offset(5 * 0x4).deref(4).cast(ArrayRef.of(Actor70.class, 64, 0x70, Actor70::new));

      //LAB_808efd4
      for(int actorIndex = 0; actorIndex < 64; actorIndex++) {
        final Actor70 actor = actors.get(actorIndex);
        if(actor.scriptPtr_00.get() != 0 && (actor._6c.getPointer() == 0x808f28c || actor.scriptPtr_00.get() == 0x809e87c)) {
          clearActor_(actor);
        }

        //LAB_808eff6
      }
    }

    //LAB_808effe
    sleep(3);
    final Actor70 actor = loadActor_(0x16, (r5.getX() & 0xfff00000) + 0x80000, 0x100000, (r5.getZ() & 0xfff00000) + 0x80000);
    if(actor == null) {
      return null;
    }

    setActorSpriteScript_(actor, 0x809e6c0);
    final Sprite38 sprite = actor.sprite_50.deref();
    sprite._26.set(0);
    sprite.layerCount_27.set(0);
    sprite.packet_00.attribs_04.flags_01.and(~0x20);
    sprite.packet_00.attribs_04.attrib2_04.and(0xfff).and(~0xc00).or(0x400);
    actor.velocity_24.setY(0x20000);
    actor._48.set(0x4000);

    final int addr = mallocSlotChip(17, 0x608);
    FUN_8015250(r1);
    sprite.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(allocateSpriteSlot(sprite.slot_1c.get(), 0x80, addr + 0x400) & 0x3ff);
    freeSlot(17);
    actor._6c.set(getConsumer(GoldenSun_808.class, "FUN_808eee4", Actor70.class));
    return actor;
  }

  @Method(0x808f0c8)
  public static void clearActorIfNotNull(final Actor70 actor) {
    if(actor != null) {
      clearActor_(actor);
    }

    //LAB_808f0d2
  }

  @Method(0x808f0d8)
  public static void FUN_808f0d8(final Actor70 r0) {
    if(r0 != null) {
      final Actor70 r5 = getMapActor(playerMapActorIndex_2000434.get());
      r0.velocityScalar_30.set(0x20000);
      r0.acceleration_34.set(0x10000);
      r0._55.set(0);
      moveActorTo_(r0, r5.pos_08.getX(), r5.pos_08.getY() + 0x240000, r5.pos_08.getZ());
      sleep(3);
      setActorAnimation_(r5, 28);
      r5.angle_06.set(0x4000);
    }

    //LAB_808f132
  }

  @Method(0x808f1c0)
  public static void FUN_808f1c0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808f498)
  public static void FUN_808f498() {
    int r0 = boardWramMallocHead_3001e50.offset(31 * 0x4).get();
    final int r2 = MEMORY.ref(1, r0 + 0x539).getUnsigned();
    DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);
    GPU.DISPCNT.oru(0x6000);
    r0 = r0 + r2 * 0x284;
    GPU.WININ.setu(MEMORY.ref(2, r0).getUnsigned());
    GPU.WINOUT.setu(MEMORY.ref(2, r0 + 0x2).getUnsigned());
    GPU.WIN0H.setu(MEMORY.ref(2, r0 + 0x4).getUnsigned());
    GPU.WIN1H.setu(MEMORY.ref(2, r0 + 0x6).getUnsigned());
    GPU.WIN0V.setu(0xa0);
    GPU.WIN1V.setu(0xa0);
    DMA.channels[0].SAD.setu(r0 + 0x8);
    DMA.channels[0].DAD.setu(GPU.WIN0H.getAddress());
    DMA.channels[0].CNT.setu(0xa6600001);
  }

  @Method(0x808f52c)
  public static void FUN_808f52c() {
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
    r3 = 0x3001e70;
    r6 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x5c).get();
    CPU.sp().value -= 0x18;
    r0 = 0x53c;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r4 = r3 + r0;
    r2 = 0x0;
    r2 = MEMORY.ref(1, r4 + r2).get();
    if(r2 != 0x0) {
      r5 = 0x53d;
      r1 = r3 + r5;
      r3 = 0x0;
      r3 = MEMORY.ref(1, r1 + r3).get();
      r0 = MEMORY.ref(1, r1).getUnsigned();
      if(r3 >= r2) {
        r3 = 0x0;
        MEMORY.ref(1, r4).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = 0x53e;
        r3 = r7 + r0;
        r2 = 0x0;
        r2 = MEMORY.ref(1, r3 + r2).get();
        if(r2 == 0x0) {
          r1 = 0x53b;
          r3 = r7 + r1;
          r3 = MEMORY.ref(1, r3).getUnsigned();
          r3 = r3 << 24;
          r3 = r3 >> 24;
          if(r3 == 0x40) {
            r1 = 0x80;
            r1 = r1 << 19;
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = 0x81ff;
          } else {
            //LAB_808f588
            r1 = 0x80;
            r1 = r1 << 19;
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = 0x9fff;
          }

          //LAB_808f590
          r3 = r3 & r2;
          MEMORY.ref(2, r1).setu(r3);
          clearTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"));
          clearTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"));
          r2 = 0x40000b0;
          r3 = 0xc5ff;
          r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
          r3 = r3 & r1;
          MEMORY.ref(2, r2 + 0xa).setu(r3);
          r3 = 0x7fff;
          r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
          r3 = r3 & r1;
          MEMORY.ref(2, r2 + 0xa).setu(r3);
          CPU.sp().value += 0x18;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return;
        }

        //LAB_808f5b8
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = 0xa5;
        r7 = r7 << 3;
        r3 = r5 + r7;
        MEMORY.ref(2, r3).setu(r2);
      } else {
        //LAB_808f5c4
        r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = 0x53b;
        r3 = r2 + r5;
        r2 = 0x0;
        r2 = MEMORY.ref(1, r3 + r2).get();
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r3 = 0x53a;
        r5 = r7 + r3;
        r3 = 0x0;
        r3 = MEMORY.ref(1, r5 + r3).get();
        r2 = r2 - r3;
        r3 = r0 + 0x1;
        MEMORY.ref(1, r1).setu(r3);
        r3 = r3 << 24;
        r3 = r3 >> 24;
        r0 = r3;
        r0 = r0 * r2;
        r1 = 0x0;
        r1 = MEMORY.ref(1, r4 + r1).get();
        r0 = FUN_3000380(r0, r1);
        r3 = 0x0;
        r3 = MEMORY.ref(1, r5 + r3).get();
        r5 = 0x52a;
        r3 = r3 + r0;
        r2 = r7 + r5;
        MEMORY.ref(2, r2).setu(r3);
      }
    }

    //LAB_808f5fc
    r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r0 = 0x539;
    r3 = r7 + r0;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r2 = 0x1;
    r2 = r2 ^ r3;
    r3 = r2 << 2;
    r3 = r3 + r2;
    r3 = r3 << 5;
    r3 = r3 + r2;
    r3 = r3 << 2;
    r4 = r7 + r3;
    r0 = r4 + 0x4;
    FUN_8015268(r0);
    r1 = 0xa5;
    r1 = r1 << 3;
    r3 = r7 + r1;
    r3 = MEMORY.ref(2, r3).getUnsigned();

    //LAB_808f62e
    switch(r3) {
      case 0: // switch 808f638
        //LAB_808f770
        r3 = 0x7f7f;
        MEMORY.ref(2, r4).setu(r3);
        r3 = 0x1;
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = 0x52a;
        r3 = r2 + r5;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r2 = 0x20;
        r3 = r5;
        r3 = r3 & r2;
        r4 = r4 + 0x2;
        if(r3 != 0x0) {
          r3 = 0x1f;
          r3 = r3 & r5;
          r5 = r2 - r3;
        } else {
          //LAB_808f7e4
          r3 = 0x1f;
          r5 = r5 & r3;
        }

        //LAB_808f7e8
        r3 = 0x809e8ac;
        r5 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r7 = 0x0;
        r3 = 0xf1;
        CPU.r8().value = r7;
        r6 = r3 - r5;

        //LAB_808f7f4
        do {
          r0 = rand();
          r3 = r6;
          r3 = r3 * r0;
          r0 = 0x1;
          r3 = r3 >>> 16;
          r2 = r3 << 8;
          r3 = r3 + r5;
          CPU.r8().value = CPU.r8().value + r0;
          r2 = r2 | r3;
          r1 = CPU.r8().value;
          MEMORY.ref(2, r4).setu(r2);
          r4 = r4 + 0x4;
        } while((r1 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 1: // switch 808f638
        //LAB_808f818
        r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = 0x52a;
        r3 = r2 + r5;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r3 = 0x1f;
        r3 = r3 & r5;
        r2 = r3 << 3;
        r2 = r2 - r3;
        r3 = 0x809f840;
        r2 = r2 << 2;
        r2 = r2 + r3;
        r3 = 0x20;
        r3 = r3 & r5;
        if(r3 != 0x0) {
          r3 = MEMORY.ref(2, r2).getUnsigned();
          MEMORY.ref(2, r4).setu(r3);
          r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
        } else {
          //LAB_808f83e
          r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
          MEMORY.ref(2, r4).setu(r3);
          r3 = MEMORY.ref(2, r2).getUnsigned();
        }

        //LAB_808f844
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r4 = r4 + 0x2;
        r7 = 0x0;
        r2 = r2 + 0x4;
        CPU.r8().value = r7;
        CPU.r10().value = r2;

        //LAB_808f852
        do {
          r2 = CPU.r10().value;
          r7 = MEMORY.ref(2, r2).getUnsigned();
          r0 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
          if(r7 != 0x0) {
            if(r0 != 0x0) {
              r1 = 0x0;
              CPU.r9().value = r1;
              if(CPU.r9().value < r7) {
                //LAB_808f868
                do {
                  r2 = 0x1;
                  CPU.r9().value = CPU.r9().value + r2;
                  MEMORY.ref(2, r4).setu(r0);
                  r4 = r4 + 0x4;
                } while(CPU.r9().value < r7);
              }
            } else {
              //LAB_808f876
              r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
              r6 = MEMORY.ref(1, r2 + 0x6).getUnsigned();
              CPU.r11().value = r3;
              r0 = MEMORY.ref(1, r2 + 0x7).getUnsigned();
              r3 = MEMORY.ref(1, r2 + 0x5).getUnsigned();
              if(r7 != 0x0) {
                r5 = CPU.r11().value;
                r5 = r3 - r5;
                r0 = r0 - r6;
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                r2 = 0x0;
                r3 = 0x0;
                CPU.r9().value = r7;

                //LAB_808f894
                do {
                  r0 = r3;
                  r1 = r7;
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                  r0 = divideS(r0, r1);
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                  r5 = r0;
                  r1 = r7;
                  r0 = r2;
                  r0 = divideS(r0, r1);
                  r5 = r5 + CPU.r11().value;
                  r0 = r6 + r0;
                  r5 = r5 << 8;
                  r5 = r5 + r0;
                  MEMORY.ref(2, r4).setu(r5);
                  r5 = 0x1;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                  r5 = -r5;
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                  CPU.r9().value = CPU.r9().value + r5;
                  r2 = r2 + r0;
                  r0 = CPU.r9().value;
                  r4 = r4 + 0x4;
                  r3 = r3 + r1;
                } while(r0 != 0x0);
              }
            }
          }

          //LAB_808f8d4
          r2 = 0x1;
          CPU.r8().value = CPU.r8().value + r2;
          r1 = 0x8;
          r3 = CPU.r8().value;
          CPU.r10().value = CPU.r10().value + r1;
        } while((r3 & 0xffff_ffffL) <= (0x2 & 0xffff_ffffL));
        break;

      case 2: // switch 808f638
        //LAB_808f8e4
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = 0x52a;
        r3 = r5 + r7;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r5 = r3 - 0x1;
        r3 = 0x20;
        r3 = r3 & r5;
        if(r3 != 0x0) {
          r3 = 0x1;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x7f7f;
        } else {
          //LAB_808f914
          r3 = 0x7f7f;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x1;
        }

        //LAB_808f91a
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r4 = r4 + 0x2;
        r3 = 0x1f;
        r5 = r5 & r3;
        r0 = 0x0;
        CPU.r8().value = r0;
        r5 = r5 << 4;

        //LAB_808f92a
        do {
          r0 = rand();
          r0 = r0 << 4;
          r0 = r0 >>> 16;
          r0 = r5 + r0;
          if((r0 & 0xffff_ffffL) > (0xff & 0xffff_ffffL)) {
            r0 = 0xff;
          }

          //LAB_808f948
          r1 = 0x1;
          CPU.r8().value = CPU.r8().value + r1;
          r2 = CPU.r8().value;
          MEMORY.ref(2, r4).setu(r0);
          r4 = r4 + 0x4;
        } while((r2 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 3: // switch 808f638
        //LAB_808f958
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = 0x52a;
        r2 = 0x7f7f;
        r3 = r5 + r7;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r3 = 0x1;
        MEMORY.ref(2, r4).setu(r2);
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r4 = r4 + 0x2;
        if((r5 & 0xffff_ffffL) > (0x20 & 0xffff_ffffL)) {
          MEMORY.ref(2, r4).setu(r3);
          r4 = r4 + 0x2;
          r3 = 0x40;
          MEMORY.ref(2, r4).setu(r2);
          r5 = r3 - r5;
          r4 = r4 + 0x2;
        }

        //LAB_808f97c
        r3 = r5 << 2;
        r5 = r3 + r5;
        r3 = r5;
        r3 = r3 * r5;
        r0 = 0x0;
        r3 = r3 << 16;
        CPU.r11().value = r3;
        CPU.r8().value = r0;

        //LAB_808f9a0
        do {
          r5 = CPU.r8().value;
          r5 = r5 - 0x50;
          r0 = r5;
          r0 = r0 * r5;
          r1 = CPU.r11().value;
          r0 = r0 << 16;
          r0 = r1 - r0;
          r0 = sqrt(r0);
          r3 = 0x78;
          r0 = r0 >> 8;
          r6 = r3 - r0;
          r0 = r0 + 0x78;
          if(r6 < 0x0) {
            r6 = 0x0;
          }

          //LAB_808f9c4
          if(r0 < 0x0) {
            r0 = 0x0;
          }

          //LAB_808f9ca
          if(r6 > 0xf0) {
            r6 = 0xf0;
          }

          //LAB_808f9d0
          if(r0 > 0xf0) {
            r0 = 0xf0;
          }

          //LAB_808f9d6
          r3 = r6 << 8;
          r2 = 0x1;
          r3 = r3 + r0;
          CPU.r8().value = CPU.r8().value + r2;
          MEMORY.ref(2, r4).setu(r3);
          r3 = CPU.r8().value;
          r4 = r4 + 0x4;
        } while((r3 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 4: // switch 808f638
        //LAB_808f9ea
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r7 = 0x52a;
        r3 = r5 + r7;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r3 = 0x20;
        r3 = r3 & r5;
        if(r3 != 0x0) {
          r3 = 0x1;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x7f7f;
        } else {
          //LAB_808fa10
          r3 = 0x7f7f;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x1;
        }

        //LAB_808fa16
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r4 = r4 + 0x2;
        r3 = 0x1f;
        r3 = r3 & r5;
        r2 = r3 << 4;
        r2 = r2 - r3;
        r2 = r2 << 4;
        r5 = r2 >>> 5;
        r3 = 0xf0;
        r3 = r3 - r5;
        r0 = 0x0;
        r3 = r3 << 8;
        CPU.r8().value = r0;
        r3 = r3 + 0xf0;

        //LAB_808fa40
        do {
          r1 = 0x2;
          CPU.r8().value = CPU.r8().value + r1;
          r2 = CPU.r8().value;
          MEMORY.ref(2, r4).setu(r5);
          MEMORY.ref(2, r4 + 0x4).setu(r3);
          r4 = r4 + 0x8;
        } while((r2 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 7: // switch 808f638
        //LAB_808fa52
        r2 = r6;
        r2 = r2 + 0xe4;
        r3 = 0xffff0000;
        r5 = MEMORY.ref(4, r2).get();
        r6 = MEMORY.ref(4, r2 + 0x4).get();
        r5 = r5 & r3;
        r6 = r6 & r3;
        r7 = 0xfa;
        r3 = 0x2000240;
        r7 = r7 << 1;
        r3 = r3 + r7;
        final Actor70 actor = getMapActor(MEMORY.ref(4, r3).get());
        r3 = actor.pos_08.getX();
        r3 = r3 - r5;
        if(r3 < 0x0) {
          r1 = 0xffff;
          r3 = r3 + r1;
        }

        //LAB_808fa7e
        r2 = actor.pos_08.getY();
        r7 = r3 >> 16;
        r3 = actor.pos_08.getZ();
        r3 = r3 - r2;
        r0 = r3 - r6;
        if(r0 < 0x0) {
          r2 = 0xffff;
          r0 = r0 + r2;
        }

        //LAB_808fa90
        r3 = r0 >> 16;
        r3 = r3 - 0x10;
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        CPU.r10().value = r3;
        r0 = 0x536;
        r3 = 0x3001e40;
        r3 = MEMORY.ref(4, r3).get();
        r3 = r5 + r0;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = 0x534;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r4 + 0x2;
        r2 = 0x52a;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r2;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r2 = 0x20;
        r3 = r5;
        r3 = r3 & r2;
        r4 = r4 + 0x2;
        if(r3 == 0x0) {
          r3 = 0x1f;
          r3 = r3 & r5;
          r5 = r2 - r3;
        } else {
          //LAB_808fac8
          r3 = 0x1f;
          r5 = r5 & r3;
        }

        //LAB_808facc
        r3 = 0x3001e40;
        r3 = MEMORY.ref(4, r3).get();
        r2 = 0x1;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          r5 = 0x0;
        }

        //LAB_808fada
        r3 = r5 << 2;
        r5 = r3 + r5;
        r3 = r5;
        r3 = r3 * r5;
        r3 = r3 << 16;
        CPU.r11().value = r3;
        r3 = 0x0;
        CPU.r8().value = r3;

        //LAB_808faee
        do {
          r0 = CPU.r8().value;
          r1 = CPU.r10().value;
          r5 = r0 - r1;
          r3 = r5;
          r3 = r3 * r5;
          r0 = r3 << 1;
          r0 = r0 + r3;
          r2 = CPU.r11().value;
          r0 = r0 << 15;
          r0 = r2 - r0;
          r0 = sqrt(r0);
          r0 = r0 >> 8;
          r6 = r7 - r0;
          r0 = r7 + r0;
          if(r6 < 0x0) {
            r6 = 0x0;
          }

          //LAB_808fb16
          if(r0 < 0x0) {
            r0 = 0x0;
          }

          //LAB_808fb1c
          if(r6 > 0xf0) {
            r6 = 0xf0;
          }

          //LAB_808fb22
          if(r0 > 0xf0) {
            r0 = 0xf0;
          }

          //LAB_808fb28
          r3 = r6 << 8;
          r3 = r3 + r0;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x1;
          CPU.r8().value = CPU.r8().value + r3;
          r5 = CPU.r8().value;
          r4 = r4 + 0x4;
        } while((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 8: // switch 808f638
        //LAB_808fb3c
        r1 = r6;
        r1 = r1 + 0xe4;
        r3 = 0xffff0000;
        r2 = MEMORY.ref(4, r1).get();
        r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r1 = MEMORY.ref(4, r1 + 0x4).get();
        r0 = 0x52c;
        r2 = r2 & r3;
        r1 = r1 & r3;
        r3 = r7 + r0;
        r3 = MEMORY.ref(4, r3).get();
        r3 = r3 - r2;
        if(r3 < 0x0) {
          r2 = 0xffff;
          r3 = r3 + r2;
        }

        //LAB_808fb5c
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = 0xa6;
        r0 = r0 << 3;
        r7 = r3 >> 16;
        r3 = r5 + r0;
        r3 = MEMORY.ref(4, r3).get();
        r1 = r3 - r1;
        if(r1 < 0x0) {
          r2 = 0xffff;
          r1 = r1 + r2;
        }

        //LAB_808fb72
        r3 = r1 >> 16;
        r3 = r3 - 0x10;
        r2 = r3 << 1;
        CPU.r10().value = r3;
        r3 = 0x3001e40;
        r3 = MEMORY.ref(4, r3).get();
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r0 = 0x534;
        r3 = r3 - r2;
        CPU.r9().value = r3;
        r3 = r5 + r0;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = 0x536;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r4 + 0x2;
        r2 = 0x52a;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r2;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r2 = 0x20;
        r3 = r5;
        r3 = r3 & r2;
        r4 = r4 + 0x2;
        if(r3 != 0x0) {
          r3 = 0x1f;
          r3 = r3 & r5;
          r5 = r2 - r3;
        } else {
          //LAB_808fbb0
          r3 = 0x1f;
          r5 = r5 & r3;
        }

        //LAB_808fbb4
        r3 = r5 << 2;
        r5 = r3 + r5;
        r3 = r5;
        r3 = r3 * r5;
        r3 = r3 << 16;
        CPU.r11().value = r3;
        r3 = 0x0;
        CPU.r8().value = r3;

        //LAB_808fbc4
        do {
          r0 = CPU.r8().value;
          r1 = CPU.r10().value;
          r5 = r0 - r1;
          r3 = r5;
          r3 = r3 * r5;
          r0 = r3 << 1;
          r0 = r0 + r3;
          r2 = CPU.r11().value;
          r0 = r0 << 15;
          r0 = r2 - r0;
          r0 = sqrt(r0);
          r0 = r0 >> 8;
          r6 = r7 - r0;
          r0 = r7 + r0;
          if(r6 < r0) {
            r3 = 0x1f;
            r5 = CPU.r9().value;
            r1 = 0x809e8ce;
            r3 = r3 & r5;
            r3 = MEMORY.ref(1, r1 + r3).get();
            r6 = r6 - r3;
            r0 = r0 + r3;
            if(r6 >= r0) {
              r6 = 0xf0;
              r0 = 0xf0;
            }
          }

          //LAB_808fc02
          if(r6 < 0x0) {
            r6 = 0x0;
          }

          //LAB_808fc08
          if(r0 < 0x0) {
            r0 = 0x0;
          }

          //LAB_808fc0e
          if(r6 > 0xf0) {
            r6 = 0xf0;
          }

          //LAB_808fc14
          if(r0 > 0xf0) {
            r0 = 0xf0;
          }

          //LAB_808fc1a
          r3 = r6 << 8;
          r3 = r3 + r0;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x1;
          CPU.r8().value = CPU.r8().value + r3;
          r2 = 0x2;
          r5 = CPU.r8().value;
          r4 = r4 + 0x4;
          CPU.r9().value = CPU.r9().value + r2;
        } while((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 9: // switch 808f638
        //LAB_808fc32
        r2 = r6;
        r2 = r2 + 0xe4;
        r3 = 0xffff0000;
        r5 = MEMORY.ref(4, r2).get();
        r6 = MEMORY.ref(4, r2 + 0x4).get();
        r5 = r5 & r3;
        r6 = r6 & r3;
        r7 = 0xfa;
        r3 = 0x2000240;
        r7 = r7 << 1;
        r3 = r3 + r7;
        final Actor70 r0_0 = getMapActor(MEMORY.ref(4, r3).get());
        r3 = r0_0.pos_08.getX();
        r3 = r3 - r5;
        if(r3 < 0x0) {
          r3 = r3 + 0xffff;
        }

        //LAB_808fc5e
        r2 = r0_0.pos_08.getY();
        r7 = r3 >> 16;
        r3 = r0_0.pos_08.getZ();
        r3 = r3 - r2;
        r0 = r3 - r6;
        if(r0 < 0x0) {
          r0 = r0 + 0xffff;
        }

        //LAB_808fc70
        r3 = r0 >> 16;
        r3 = r3 - 0x10;
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        CPU.r10().value = r3;
        r3 = r5 + 0x534;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = 0x536;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r4 + 0x2;
        r2 = 0x52a;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r2;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r2 = 0x20;
        r3 = r5;
        r3 = r3 & r2;
        r4 = r4 + 0x2;
        if(r3 != 0x0) {
          r3 = 0x1f;
          r3 = r3 & r5;
          r5 = r2 - r3;
        } else {
          //LAB_808fca8
          r3 = 0x1f;
          r5 = r5 & r3;
        }

        //LAB_808fcac
        r3 = r5 << 2;
        r5 = r3 + r5;
        r3 = r5;
        r3 = r3 * r5;
        r3 = r3 << 16;
        CPU.r11().value = r3;
        r3 = 0x0;
        CPU.r8().value = r3;

        //LAB_808fcc0
        do {
          r0 = CPU.r8().value;
          r1 = CPU.r10().value;
          r5 = r0 - r1;
          r3 = r5;
          r3 = r3 * r5;
          r0 = r3 << 1;
          r0 = r0 + r3;
          r2 = CPU.r11().value;
          r0 = r0 << 15;
          r0 = r2 - r0;
          r0 = sqrt(r0);
          r0 = r0 >> 8;
          r6 = r7 - r0;
          r0 = r7 + r0;
          if(r6 < 0x0) {
            r6 = 0x0;
          }

          //LAB_808fce8
          if(r0 < 0x0) {
            r0 = 0x0;
          }

          //LAB_808fcee
          if(r6 > 0xf0) {
            r6 = 0xf0;
          }

          //LAB_808fcf4
          if(r0 > 0xf0) {
            r0 = 0xf0;
          }

          //LAB_808fcfa
          r3 = r6 << 8;
          r3 = r3 + r0;
          MEMORY.ref(2, r4).setu(r3);
          r3 = 0x1;
          CPU.r8().value = CPU.r8().value + r3;
          r5 = CPU.r8().value;
          r4 = r4 + 0x4;
        } while((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        break;

      case 77: // switch 808f638
        //LAB_808fd0e
        r2 = r6;
        r2 = r2 + 0xe4;
        r3 = 0xffff0000;
        r5 = MEMORY.ref(4, r2).get();
        r6 = MEMORY.ref(4, r2 + 0x4).get();
        r5 = r5 & r3;
        r6 = r6 & r3;
        r7 = 0xfa;
        r3 = 0x2000240;
        r7 = r7 << 1;
        r3 = r3 + r7;
        final Actor70 r0_1 = getMapActor(MEMORY.ref(4, r3).get());
        r3 = r0_1.pos_08.getX();
        r3 = r3 - r5;
        if(r3 < 0x0) {
          r1 = 0xffff;
          r3 = r3 + r1;
        }

        //LAB_808fd3a
        r2 = r0_1.pos_08.getY();
        r7 = r3 >> 16;
        r3 = r0_1.pos_08.getZ();
        r3 = r3 - r2;
        r0 = r3 - r6;
        if(r0 < 0x0) {
          r2 = 0xffff;
          r0 = r0 + r2;
        }

        //LAB_808fd4c
        r3 = r0 >> 16;
        r3 = r3 - 0x8;
        r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        CPU.r10().value = r3;
        r3 = r5 + 0x534;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r1 = 0x536;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r4 + 0x2;
        MEMORY.ref(2, r4).setu(r3);
        r3 = r5 + 0x52a;
        r5 = MEMORY.ref(2, r3).getUnsigned();
        r3 = r5 & 0x20;
        r4 = r4 + 0x2;
        if(r3 != 0x0) {
          r3 = r5 & 0x1f;
          r5 = 0x20 - r3;
        } else {
          //LAB_808fdac
          r5 = r5 & 0x1f;
        }

        //LAB_808fdb0
        r3 = r5 << 2;
        r5 = r3 + r5;
        r3 = r5 * r5;
        r3 = r3 << 16;
        CPU.r11().value = r3;
        CPU.r8().value = 0;

        //LAB_808fdc4
        do {
          r5 = CPU.r8().value - CPU.r10().value;
          r0 = sqrt(CPU.r11().value - r5 * r5 * 0xc000) >> 8;
          r6 = r7 - r0;
          r0 = r7 + r0;
          if(r6 < 0x0) {
            r6 = 0x0;
          }

          //LAB_808fdec
          if(r0 < 0x0) {
            r0 = 0x0;
          }

          //LAB_808fdf2
          if(r6 > 0xf0) {
            r6 = 0xf0;
          }

          //LAB_808fdf8
          if(r0 > 0xf0) {
            r0 = 0xf0;
          }

          //LAB_808fdfe
          r3 = r6 << 8;
          r3 = r3 + r0;
          MEMORY.ref(2, r4).setu(r3);
          r4 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 160);
        break;
    }

    //LAB_808fe10
    r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    MEMORY.ref(1, r7 + 0x539).xor(0x1);

    //LAB_808fe1e
    CPU.sp().value += 0x18;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808fecc)
  public static int FUN_808fecc() {
    final int r4 = mallocSlotBoard(31, 0x540);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000150);
    CPU.sp().value += 0x4;

    return r4;
  }

  @Method(0x808fefc)
  public static void FUN_808fefc(final int r0, final int r1) {
    final Map194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int r6 = r0 & 0xff;

    //LAB_808ff1c
    switch(r0 >> 8 & 0xff) {
      case 0: {
        fadeOutBrightness(0);
        fadeInBrightness(r1);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
          final VblankTransfer0c r2_0 = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          r2_0.src_00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0.dst_04.set(GPU.DISPCNT.getAddress());
          r2_0.cnt_08.set(0x20000);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_809019a
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        break;
      }

      case 1: {
        FUN_8091220(0x8000, MEMORY.ref(2, 0x5000000).getUnsigned());
        calculatePaletteModificationSteps(r1);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
          final VblankTransfer0c r2_0 = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          r2_0.src_00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0.dst_04.set(GPU.DISPCNT.getAddress());
          r2_0.cnt_08.set(0x20000);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_808ff98
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        FUN_8091240(0);
        break;
      }

      case 2: {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        setTickCallback(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        sleep(0x1);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
          final VblankTransfer0c r2_0 = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          r2_0.src_00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0.dst_04.set(GPU.DISPCNT.getAddress());
          r2_0.cnt_08.set(0x20000);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_8090018
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(1, r5 + 0x53a).setu(0);
        MEMORY.ref(1, r5 + 0x53b).setu(0x20);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
        break;
      }

      case 3: {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);

        FUN_80907b0(0xf);
        sleep(0x1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_8090658"), 0xc80);

        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
          final VblankTransfer0c r2_0 = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          r2_0.src_00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0.dst_04.set(GPU.DISPCNT.getAddress());
          r2_0.cnt_08.set(0x20000);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_809009e
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        MEMORY.ref(1, r5 + 0x53a).setu(0);
        MEMORY.ref(1, r5 + 0x53b).setu(0x20);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
        break;
      }

      case 4:
        final int r5 = FUN_808fecc();
        r7._100.get(0).set(0x50);
        r7._100.get(0).set(0);
        r7._100.get(0).set(0x50);
        r7._103.set(0);
        sleep(0x1);
        setTickCallback(getRunnable(GoldenSun_809.class, "FUN_%x".formatted(r6 == 0 ? 0x80903bc : 0x8090488)), 0xc80);
        setInterruptHandler(0x1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
        MEMORY.ref(1, r5 + 0x53a).setu(0x50);
        MEMORY.ref(1, r5 + 0x53b).setu(0);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);

        // fall through

      default: {
        //LAB_8090168
        final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
        INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

        if(vblankTransferQueue_2002090.count_00.get() < 0x20) {
          final VblankTransfer0c r2_0 = vblankTransferQueue_2002090.queue_04.get(vblankTransferQueue_2002090.count_00.get());
          r2_0.src_00.set(r7._14.get() | GPU.DISPCNT.getUnsigned());
          r2_0.dst_04.set(GPU.DISPCNT.getAddress());
          r2_0.cnt_08.set(0x20000);
          vblankTransferQueue_2002090.count_00.incr();
        }

        //LAB_809019a
        INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
        break;
      }
    }

    //LAB_809019c
  }
}
