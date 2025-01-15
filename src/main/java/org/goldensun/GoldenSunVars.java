package org.goldensun;

import org.goldensun.battle.ActorProperties08;
import org.goldensun.battle.Camera4c;
import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.EnemyStats54;
import org.goldensun.input.Input;
import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.BiFunctionRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.FunctionRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.SupplierRef;
import org.goldensun.memory.types.TriConsumerRef;
import org.goldensun.memory.types.TriFunctionRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Ability10;
import org.goldensun.types.ChoiceMenu98;
import org.goldensun.types.Class54;
import org.goldensun.types.FieldPsynergy720;
import org.goldensun.types.FieldPsynergyRange04;
import org.goldensun.types.Matrix30;
import org.goldensun.types.VblankTransferQueue184;
import org.goldensun.types.Item2c;
import org.goldensun.types.Map194;
import org.goldensun.types.Menua70;
import org.goldensun.types.RecoveryQueue10c;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.RotationScaling08;
import org.goldensun.types.SoundStruct0c;
import org.goldensun.types.SoundStructFb0;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SramTypeStruct;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Struct5c;
import org.goldensun.types.Structccc;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.Unit14c;
import org.goldensun.types.VramSlot04;
import org.goldensun.types.Struct0c;
import org.goldensun.types.Actor70;
import org.goldensun.types.TickCallback08;
import org.goldensun.weather.LightningStruct1f88;
import org.goldensun.weather.PaletteStruct2a04;

import static org.goldensun.Hardware.MEMORY;

public final class GoldenSunVars {
  private GoldenSunVars() { }

  public static final RecoveryQueue10c djinnRecoveryQueue_200024c = MEMORY.ref(4, 0x200024c, RecoveryQueue10c::new);

  public static final ShortRef mapId_2000400 = MEMORY.ref(2, 0x2000400, ShortRef::new);
  public static final ShortRef entranceId_2000402 = MEMORY.ref(2, 0x2000402, ShortRef::new);
  public static final ShortRef _2000404 = MEMORY.ref(2, 0x2000404, ShortRef::new);
  public static final ShortRef _2000406 = MEMORY.ref(2, 0x2000406, ShortRef::new);
  public static final UnsignedShortRef _2000408 = MEMORY.ref(2, 0x2000408, UnsignedShortRef::new);
  public static final UnsignedShortRef _200040a = MEMORY.ref(2, 0x200040a, UnsignedShortRef::new);
  public static final ShortRef _200040c = MEMORY.ref(2, 0x200040c, ShortRef::new);
  public static final ShortRef _200040e = MEMORY.ref(2, 0x200040e, ShortRef::new);
  public static final ShortRef _2000410 = MEMORY.ref(2, 0x2000410, ShortRef::new);
  public static final ShortRef _2000412 = MEMORY.ref(2, 0x2000412, ShortRef::new);
  public static final ShortRef _2000414 = MEMORY.ref(2, 0x2000414, ShortRef::new);
  public static final ShortRef _2000416 = MEMORY.ref(2, 0x2000416, ShortRef::new);

  /** This is an index into a table which affects which map background is loaded? */
  public static final ShortRef _200041a = MEMORY.ref(2, 0x200041a, ShortRef::new);
  public static final IntRef _200041c = MEMORY.ref(4, 0x200041c, IntRef::new);
  public static final IntRef _2000420 = MEMORY.ref(4, 0x2000420, IntRef::new);
  public static final IntRef _2000424 = MEMORY.ref(4, 0x2000424, IntRef::new);
  public static final IntRef _2000428 = MEMORY.ref(4, 0x2000428, IntRef::new);
  public static final UnsignedShortRef _200042c = MEMORY.ref(2, 0x200042c, UnsignedShortRef::new);
  public static final ShortRef _200042e = MEMORY.ref(2, 0x200042e, ShortRef::new);
  public static final ShortRef _2000430 = MEMORY.ref(2, 0x2000430, ShortRef::new);
  /** Maybe a position type - 0 is normal, 1 is on ladder, 2 is ? */
  public static final UnsignedByteRef _2000432 = MEMORY.ref(1, 0x2000432, UnsignedByteRef::new);

  /** A specific actor index, maybe the player? */
  public static final IntRef playerMapActorIndex_2000434 = MEMORY.ref(4, 0x2000434, IntRef::new);
  public static final ArrayRef<UnsignedByteRef> charIds_2000438 = MEMORY.ref(1, 0x2000438, ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));

  public static final UnsignedByteRef _2000445 = MEMORY.ref(1, 0x2000445, UnsignedByteRef::new);
  public static final UnsignedByteRef _2000446 = MEMORY.ref(1, 0x2000446, UnsignedByteRef::new);

  public static final UnsignedByteRef _200044a = MEMORY.ref(1, 0x200044a, UnsignedByteRef::new);

  public static final UnsignedByteRef _200044c = MEMORY.ref(1, 0x200044c, UnsignedByteRef::new);

  /** {@link Input#BUTTON_A} */
  public static final UnsignedShortRef interactButton_2000450 = MEMORY.ref(2, 0x2000450, UnsignedShortRef::new);

  /** {@link Input#BUTTON_SELECT} */
  public static final UnsignedShortRef menuButton_2000454 = MEMORY.ref(2, 0x2000454, UnsignedShortRef::new);
  /** {@link Input#BUTTON_START} */
  public static final UnsignedShortRef systemMenuButton_2000456 = MEMORY.ref(2, 0x2000456, UnsignedShortRef::new);
  /** {@link Input#BUTTON_L} */
  public static final UnsignedShortRef psynergy1Button_2000458 = MEMORY.ref(2, 0x2000458, UnsignedShortRef::new);
  /** {@link Input#BUTTON_R} */
  public static final UnsignedShortRef psynergy2Button_200045a = MEMORY.ref(2, 0x200045a, UnsignedShortRef::new);
  /** {@link Input#BUTTON_B} */
  public static final UnsignedShortRef runButton_200045c = MEMORY.ref(2, 0x200045c, UnsignedShortRef::new);
  public static final ShortRef _200045e = MEMORY.ref(2, 0x200045e, ShortRef::new);
  public static final UnsignedShortRef boundPsynergy1_2000460 = MEMORY.ref(2, 0x2000460, UnsignedShortRef::new);
  public static final UnsignedShortRef boundPsynergy2_2000462 = MEMORY.ref(2, 0x2000462, UnsignedShortRef::new);
  public static final UnsignedByteRef _2000464 = MEMORY.ref(1, 0x2000464, UnsignedByteRef::new);

  public static final ShortRef _200046c = MEMORY.ref(2, 0x200046c, ShortRef::new);
  public static final ShortRef _200046e = MEMORY.ref(2, 0x200046e, ShortRef::new);
  public static final ShortRef _2000470 = MEMORY.ref(2, 0x2000470, ShortRef::new);
  public static final ShortRef _2000472 = MEMORY.ref(2, 0x2000472, ShortRef::new);
  public static final ShortRef _2000474 = MEMORY.ref(2, 0x2000474, ShortRef::new);
  public static final ShortRef _2000476 = MEMORY.ref(2, 0x2000476, ShortRef::new);
  public static final IntRef _2000478 = MEMORY.ref(4, 0x2000478, IntRef::new);
  public static final UnsignedShortRef _200047c = MEMORY.ref(2, 0x200047c, UnsignedShortRef::new);
  public static final ShortRef _200047e = MEMORY.ref(2, 0x200047e, ShortRef::new);

  public static final ShortRef _2000480 = MEMORY.ref(2, 0x2000480, ShortRef::new);
  public static final ShortRef _2000482 = MEMORY.ref(2, 0x2000482, ShortRef::new);

  public static final ShortRef _200048a = MEMORY.ref(2, 0x200048a, ShortRef::new);
  public static final ShortRef _200048c = MEMORY.ref(2, 0x200048c, ShortRef::new);

  public static final ShortRef _20004a4 = MEMORY.ref(2, 0x20004a4, ShortRef::new);

  public static final ArrayRef<Unit14c> units_2000500 = MEMORY.ref(4, 0x2000500, ArrayRef.of(Unit14c.class, 8, 0x14c, Unit14c::new));

  public static final ShortRef lastSaveSlot_2002004 = MEMORY.ref(2, 0x2002004, ShortRef::new);

  public static final VblankTransferQueue184 vblankTransferQueue_2002090 = MEMORY.ref(4, 0x2002090, VblankTransferQueue184::new);

  public static final SoundStructFb0 _2003050 = MEMORY.ref(4, 0x2003050, SoundStructFb0::new);

  // These are the main interface for map code
  public static final Pointer<RunnableRef> init_2008004 = MEMORY.ref(4, 0x2008004, Pointer.deferred(4, RunnableRef::new));
  public static final Pointer<SupplierRef<Integer>> getRooms_200800c = MEMORY.ref(4, 0x200800c, Pointer.deferred(4, SupplierRef::new));
  public static final Pointer<SupplierRef<Integer>> getTransitions_2008014 = MEMORY.ref(4, 0x2008014, Pointer.deferred(4, SupplierRef::new));
  public static final Pointer<SupplierRef<Integer>> getActors_200801c = MEMORY.ref(4, 0x200801c, Pointer.deferred(4, SupplierRef::new));
  public static final Pointer<SupplierRef<Integer>> getEvents_2008024 = MEMORY.ref(4, 0x2008024, Pointer.deferred(4, SupplierRef::new));
  public static final Pointer<SupplierRef<Integer>> getLadders_200802c = MEMORY.ref(4, 0x200802c, Pointer.deferred(4, SupplierRef::new));

  /** Should always point to {@link GoldenSun#FUN_8006af8} */
  public static final Pointer<TriFunctionRef<Integer, Integer, Integer, Integer>> _2004c00 = MEMORY.ref(4, 0x2004c00, Pointer.deferred(4, TriFunctionRef::new));
  /** Should always point to {@link GoldenSun#writeSectorSst} */
  public static final Pointer<BiFunctionRef<Integer, Integer, Integer>> writeSectorPtr_2004c04 = MEMORY.ref(4, 0x2004c04, Pointer.deferred(4, BiFunctionRef::new));
  public static final IntRef _2004c08 = MEMORY.ref(4, 0x2004c08, IntRef::new);
  public static final UnsignedShortRef _2004c0c = MEMORY.ref(2, 0x2004c0c, UnsignedShortRef::new);

  public static final IntRef _2004c10 = MEMORY.ref(4, 0x2004c10, IntRef::new);
  public static final IntRef _2004c14 = MEMORY.ref(4, 0x2004c14, IntRef::new);
  public static final IntRef _2004c18 = MEMORY.ref(4, 0x2004c18, IntRef::new);
  public static final Pointer<FunctionRef<Integer, Integer>> readOneByteFromPtr_2004c1c = MEMORY.ref(4, 0x2004c1c, Pointer.deferred(4, FunctionRef::new));

  public static final UnsignedByteRef timerIndex_2004c20 = MEMORY.ref(1, 0x2004c20, UnsignedByteRef::new);

  public static final ShortRef _2004c22 = MEMORY.ref(2, 0x2004c22, ShortRef::new);
  public static final UnsignedByteRef _2004c24 = MEMORY.ref(1, 0x2004c24, UnsignedByteRef::new);

  public static final IntRef timerCntLPtr_2004c28 = MEMORY.ref(4, 0x2004c28, IntRef::new);
  public static final IntRef oldInterrupts_2004c2c = MEMORY.ref(4, 0x2004c2c, IntRef::new);

  public static final UnboundedArrayRef<TileAttributes04> tileAttribs_2010000 = MEMORY.ref(4, 0x2010000, UnboundedArrayRef.of(0x4, TileAttributes04::new));

  public static final Matrix30 transforms_3000350 = MEMORY.ref(4, 0x3000350, Matrix30::new);

  public static final ArrayRef<Pointer<RenderPacket0c>> packets_3001400 = MEMORY.ref(4, 0x3001400, ArrayRef.of(Pointer.classFor(RenderPacket0c.class), 0x100, 0x4, Pointer.deferred(4, RenderPacket0c::new)));
  public static final IntRef ticks_3001800 = MEMORY.ref(4, 0x3001800, IntRef::new);

  public static final ArrayRef<UnsignedByteRef> _3001810 = MEMORY.ref(1, 0x3001810, ArrayRef.of(UnsignedByteRef.class, 0x200, 1, UnsignedByteRef::new));
  public static final UnsignedByteRef _3001a10 = MEMORY.ref(1, 0x3001a10, UnsignedByteRef::new);

  public static final ArrayRef<TickCallback08> tickCallbacks_3001a20 = MEMORY.ref(4, 0x3001a20, ArrayRef.of(TickCallback08.class, 20, 0x8, TickCallback08::new));
  public static final UnsignedByteRef _3001ac0 = MEMORY.ref(1, 0x3001ac0, UnsignedByteRef::new);

  public static final Value _3001ac4 = MEMORY.ref(1, 0x3001ac4);

  public static final IntRef heldButtonsLastFrame_3001ae8 = MEMORY.ref(4, 0x3001ae8, IntRef::new);
  public static final UnsignedByteRef _3001aec = MEMORY.ref(1, 0x3001aec, UnsignedByteRef::new);

  public static final IntRef _3001af0 = MEMORY.ref(4, 0x3001af0, IntRef::new);

  /** Unknown use, buttons pressed this frame are or'd with the current value */
  public static final IntRef accumulatedButtons_3001af8 = MEMORY.ref(4, 0x3001af8, IntRef::new);
  public static final IntRef _3001afc = MEMORY.ref(4, 0x3001afc, IntRef::new);
  public static final IntRef _3001b00 = MEMORY.ref(4, 0x3001b00, IntRef::new);
  /** Maybe held buttons */
  public static final IntRef pressedButtons_3001b04 = MEMORY.ref(4, 0x3001b04, IntRef::new);

  public static final ArrayRef<VramSlot04> vramSlots_3001b10 = MEMORY.ref(4, 0x3001b10, ArrayRef.of(VramSlot04.class, 0x60, 0x4, VramSlot04::new));
  // Ends at 1c90

  /** Buttons that were pressed this frame */
  public static final IntRef pressedButtons_3001c94 = MEMORY.ref(4, 0x3001c94, IntRef::new);
  public static final UnsignedByteRef _3001c98 = MEMORY.ref(1, 0x3001c98, UnsignedByteRef::new);

  public static final IntRef _3001c9c = MEMORY.ref(4, 0x3001c9c, IntRef::new);
  public static final UnsignedByteRef _3001ca0 = MEMORY.ref(1, 0x3001ca0, UnsignedByteRef::new);

  public static final IntRef _3001ca4 = MEMORY.ref(4, 0x3001ca4, IntRef::new);
  public static final UnsignedByteRef _3001ca8 = MEMORY.ref(1, 0x3001ca8, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001cb0 = MEMORY.ref(2, 0x3001cb0, UnsignedShortRef::new);

  public static final IntRef seed_3001cb4 = MEMORY.ref(4, 0x3001cb4, IntRef::new);
  public static final UnsignedByteRef _3001cb8 = MEMORY.ref(1, 0x3001cb8, UnsignedByteRef::new);

  public static final Value _3001cbc = MEMORY.ref(4, 0x3001cbc);
  public static final IntRef _3001cc0 = MEMORY.ref(4, 0x3001cc0, IntRef::new);
  public static final IntRef matrixStackDepth_3001cc4 = MEMORY.ref(4, 0x3001cc4, IntRef::new);

  public static final UnsignedShortRef _3001ccc = MEMORY.ref(2, 0x3001ccc, UnsignedShortRef::new);

  public static final Value _3001cd0 = MEMORY.ref(2, 0x3001cd0);

  public static final UnsignedByteRef _3001cd4 = MEMORY.ref(1, 0x3001cd4, UnsignedByteRef::new);

  public static final IntRef _3001cf4 = MEMORY.ref(4, 0x3001cf4, IntRef::new);
  public static final UnsignedShortRef blendConfig_3001cf8 = MEMORY.ref(2, 0x3001cf8, UnsignedShortRef::new);

  /** TODO function ptr */
  public static final IntRef _3001cfc = MEMORY.ref(4, 0x3001cfc, IntRef::new);
  public static final UnsignedByteRef rotationScalingCount_3001d00 = MEMORY.ref(1, 0x3001d00, UnsignedByteRef::new);

  public static final IntRef _3001d04 = MEMORY.ref(4, 0x3001d04, IntRef::new);
  public static final UnsignedByteRef _3001d08 = MEMORY.ref(1, 0x3001d08, UnsignedByteRef::new);

  /** Buttons that are currently pressed (this frame, or held from a previous frame) */
  public static final IntRef heldButtons_3001d0c = MEMORY.ref(4, 0x3001d0c, IntRef::new);

  public static final UnsignedByteRef _3001d18 = MEMORY.ref(1, 0x3001d18, UnsignedByteRef::new);

  public static final IntRef _3001d1c = MEMORY.ref(4, 0x3001d1c, IntRef::new);
  public static final UnsignedByteRef _3001d20 = MEMORY.ref(1, 0x3001d20, UnsignedByteRef::new);

  public static final UnsignedShortRef framesSinceInput_3001d24 = MEMORY.ref(2, 0x3001d24, UnsignedShortRef::new);

  public static final UnsignedShortRef vblankOccurred_3001d28 = MEMORY.ref(2, 0x3001d28, UnsignedShortRef::new);

  /** TODO ptr */
  public static final IntRef _3001d2c = MEMORY.ref(4, 0x3001d2c, IntRef::new);

  public static final UnsignedByteRef tickCallbacksInitialized_3001d34 = MEMORY.ref(1, 0x3001d34, UnsignedByteRef::new);

  public static final ArrayRef<RotationScaling08> rotationScaling_3001d40 = MEMORY.ref(2, 0x3001d40, ArrayRef.of(RotationScaling08.class, 0x20, 0x8, RotationScaling08::new));
  public static final IntRef _3001e40 = MEMORY.ref(4, 0x3001e40, IntRef::new);
  public static final UnsignedByteRef _3001e44 = MEMORY.ref(1, 0x3001e44, UnsignedByteRef::new);

  /**
   * <ul>
   *   <li>4 - Array of 64 {@link Sprite38}</li>
   *   <li>5 - Array of 64 {@link Actor70}</li>
   *   <li>6 - {@link Struct5c}</li>
   *   <li>7 - </li>
   *   <li>8 - {@link Map194}</li>
   *   <li>9 - {@link BattleStruct82c}</li>
   *   <li>12 - {@link Camera4c}</li>
   *   <li>15 - {@link Struct12fc}</li>
   *   <li>27 - {@link Structccc}</li>
   *   <li>30 - {@link LightningStruct1f88}</li>
   *   <li>32 - {@link PaletteStruct2a04}</li>
   *   <li>54 - Array of ?? {@link Unit14c}</li>
   *   <li>55 - {@link Menua70}</li>
   *   <li>56 - {@link FieldPsynergy720}</li>
   *   <li>58 - {@link ChoiceMenu98}</li>
   * </ul>
   */
  public static final Value boardWramMallocHead_3001e50 = MEMORY.ref(4, 0x3001e50);
  public static final Value chipWramMallocHead_3001e54 = MEMORY.ref(4, 0x3001e54);

  public static final UnsignedByteRef debug_3001f54 = MEMORY.ref(1, 0x3001f54, UnsignedByteRef::new);

  public static final UnsignedByteRef _3001f58 = MEMORY.ref(1, 0x3001f58, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001f64 = MEMORY.ref(2, 0x3001f64, UnsignedShortRef::new);

  public static final IntRef _3007800 = MEMORY.ref(4, 0x3007800, IntRef::new);
  public static final Value _3007804 = MEMORY.ref(4, 0x3007804);

  public static final IntRef _3007810 = MEMORY.ref(4, 0x3007810, IntRef::new);

  public static final Pointer<SoundStructFb0> _3007ff0 = MEMORY.ref(4, 0x3007ff0, Pointer.deferred(4, SoundStructFb0::new));

  public static final IntRef _3007ffc = MEMORY.ref(4, 0x3007ffc, IntRef::new);

  public static final ArrayRef<Pointer<SramTypeStruct>> _8007a0c = MEMORY.ref(4, 0x8007a0c, ArrayRef.of(Pointer.classFor(SramTypeStruct.class), 5, 0x4, Pointer.deferred(4, SramTypeStruct::new)));

  public static final Matrix30 _8013190 = MEMORY.ref(4, 0x8013190, Matrix30::new);

  /**
   * <ul>
   *   <li>{@link GoldenSun_801#FUN_8011ce0}</li>
   *   <li>{@link GoldenSun_801#FUN_8011cec}</li>
   *   <li>{@link GoldenSun_801#FUN_8011d10}</li>
   *   <li>{@link GoldenSun_801#FUN_8011d34}</li>
   *   <li>{@link GoldenSun_801#FUN_8011d60}</li>
   *   <li>{@link GoldenSun_801#FUN_8011d94}</li>
   *   <li>{@link GoldenSun_801#FUN_8011ddc}</li>
   *   <li>{@link GoldenSun_801#FUN_8011e2c}</li>
   *   <li>{@link GoldenSun_801#FUN_8011e50}</li>
   *   <li>{@link GoldenSun_801#FUN_8011e6c}</li>
   *   <li>{@link GoldenSun_801#FUN_8011e88}</li>
   *   <li>{@link GoldenSun_801#FUN_8011ed0}</li>
   *   <li>{@link GoldenSun_801#FUN_8011f14}</li>
   *   <li>{@link GoldenSun_801#FUN_8011f28}</li>
   *   <li>{@link GoldenSun_801#FUN_8011f3c}</li>
   *   <li>{@link GoldenSun_801#FUN_8011f48}</li>
   * </ul>
   */
  public static final ArrayRef<Pointer<TriFunctionRef<Integer, Integer, Integer, Integer>>> _80134fc = MEMORY.ref(4, 0x80134fc, ArrayRef.of(Pointer.classFor(TriFunctionRef.classFor(Integer.class, Integer.class, Integer.class, Integer.class)), 16, 0x4, Pointer.deferred(4, TriFunctionRef::new)));

  /**
   * <ul>
   *   <li>{@link GoldenSun#FUN_800d654}</li>
   *   <li>{@link GoldenSun#FUN_800d674}</li>
   *   <li>{@link GoldenSun#FUN_800d9f0}</li>
   *   <li>{@link GoldenSun#FUN_800da18}</li>
   *   <li>{@link GoldenSun#FUN_800da40}</li>
   *   <li>{@link GoldenSun#FUN_800da78}</li>
   *   <li>{@link GoldenSun#FUN_800daa0}</li>
   *   <li>{@link GoldenSun#FUN_800dac0}</li>
   *   <li>{@link GoldenSun#FUN_800dd70}</li>
   *   <li>{@link GoldenSun#FUN_800df04}</li>
   *   <li>{@link GoldenSun#FUN_800dcdc}</li>
   *   <li>{@link GoldenSun#FUN_800daf0}</li>
   *   <li>{@link GoldenSun#FUN_800d710}</li>
   *   <li>{@link GoldenSun#FUN_800d760}</li>
   *   <li>{@link GoldenSun#FUN_800d780}</li>
   *   <li>{@link GoldenSun#FUN_800d7b4}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7f8}</li>
   *   <li>{@link GoldenSun#FUN_800d820}</li>
   *   <li>{@link GoldenSun#FUN_800d850}</li>
   *   <li>{@link GoldenSun#FUN_800d880}</li>
   *   <li>{@link GoldenSun#FUN_800e9a0}</li>
   *   <li>{@link GoldenSun#FUN_800e9dc}</li>
   *   <li>{@link GoldenSun#FUN_800ea18}</li>
   *   <li>{@link GoldenSun#handleMovement}</li>
   *   <li>{@link GoldenSun#FUN_800f7f4}</li>
   *   <li>{@link GoldenSun#FUN_800f2f8}</li>
   *   <li>{@link GoldenSun#FUN_800d8e8}</li>
   *   <li>{@link GoldenSun#FUN_800d8c4}</li>
   *   <li>{@link GoldenSun#FUN_800d8f4}</li>
   *   <li>{@link GoldenSun#FUN_800d900}</li>
   *   <li>{@link GoldenSun#FUN_800ca2c}</li>
   *   <li>{@link GoldenSun#FUN_800ca44}</li>
   *   <li>{@link GoldenSun#FUN_800ca58}</li>
   *   <li>{@link GoldenSun#FUN_800d6a4}</li>
   *   <li>{@link GoldenSun#FUN_800f7dc}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   *   <li>{@link GoldenSun#FUN_800d7e8}</li>
   * </ul>
   */
  public static final ArrayRef<Pointer<FunctionRef<Actor70, Integer>>> _8013624 = MEMORY.ref(4, 0x8013624, ArrayRef.of(Pointer.classFor(FunctionRef.classFor(Actor70.class, Integer.class)), 47, 0x4, Pointer.deferred(4, FunctionRef::new)));
  /**
   * <ul>
   *   <li>{@link GoldenSun#FUN_800e220}</li>
   *   <li>{@link GoldenSun#FUN_800e24c}</li>
   *   <li>{@link GoldenSun#FUN_800e280}</li>
   *   <li>{@link GoldenSun#FUN_800e280}</li>
   *   <li>{@link GoldenSun#FUN_800e280}</li>
   *   <li>{@link GoldenSun#FUN_800e2b0}</li>
   *   <li>{@link GoldenSun#FUN_800e2dc}</li>
   *   <li>{@link GoldenSun#FUN_800e308}</li>
   *   <li>{@link GoldenSun#FUN_800e334}</li>
   *   <li>{@link GoldenSun#FUN_800e364}</li>
   *   <li>{@link GoldenSun#FUN_800e390}</li>
   *   <li>{@link GoldenSun#FUN_800e390}</li>
   *   <li>{@link GoldenSun#FUN_800e3bc}</li>
   *   <li>{@link GoldenSun#FUN_800e3e8}</li>
   *   <li>{@link GoldenSun#FUN_800e414}</li>
   *   <li>{@link GoldenSun#FUN_800e440}</li>
   *   <li>{@link GoldenSun#FUN_800e46c}</li>
   *   <li>{@link GoldenSun#FUN_800e498}</li>
   *   <li>{@link GoldenSun#FUN_800e4c4}</li>
   *   <li>{@link GoldenSun#FUN_800e4f0}</li>
   *   <li>{@link GoldenSun#FUN_800e51c}</li>
   *   <li>{@link GoldenSun#FUN_800e548}</li>
   *   <li>{@link GoldenSun#FUN_800e574}</li>
   *   <li>{@link GoldenSun#FUN_800e5a0}</li>
   *   <li>{@link GoldenSun#FUN_800e5cc}</li>
   *   <li>{@link GoldenSun#FUN_800e5f8}</li>
   *   <li>{@link GoldenSun#FUN_800e634}</li>
   *   <li>{@link GoldenSun#FUN_800e670}</li>
   *   <li>{@link GoldenSun#FUN_800e6ac}</li>
   *   <li>{@link GoldenSun#FUN_800e6e4}</li>
   *   <li>{@link GoldenSun#FUN_800e720}</li>
   *   <li>{@link GoldenSun#FUN_800e75c}</li>
   *   <li>{@link GoldenSun#FUN_800e798}</li>
   *   <li>{@link GoldenSun#FUN_800e7d4}</li>
   *   <li>{@link GoldenSun#FUN_800e810}</li>
   *   <li>{@link GoldenSun#FUN_800e850}</li>
   *   <li>{@link GoldenSun#FUN_800e890}</li>
   *   <li>{@link GoldenSun#FUN_800e8d0}</li>
   *   <li>{@link GoldenSun#FUN_800e8fc}</li>
   *   <li>{@link GoldenSun#FUN_800e928}</li>
   *   <li>{@link GoldenSun#FUN_800e964}</li>
   * </ul>
   */
  public static final ArrayRef<Pointer<TriConsumerRef<Actor70, Integer, Integer>>> _80136e0 = MEMORY.ref(4, 0x80136e0, ArrayRef.of(Pointer.classFor(TriConsumerRef.classFor(Actor70.class, Integer.class, Integer.class)), 41, 0x4, Pointer.deferred(4, TriConsumerRef::new)));

  public static final UnboundedArrayRef<Struct0c> _8013784 = MEMORY.ref(4, 0x8013784, UnboundedArrayRef.of(0xc, Struct0c::new));

  public static final ArrayRef<Item2c> items_807b6a8 = MEMORY.ref(4, 0x807b6a8, ArrayRef.of(Item2c.class, 0x1ff, 0x2c, Item2c::new));

  public static final ArrayRef<Ability10> abilities_807ee58 = MEMORY.ref(4, 0x807ee58, ArrayRef.of(Ability10.class, 520, 0x10, Ability10::new));

  public static final ArrayRef<EnemyStats54> enemyStats_8080ec8 = MEMORY.ref(4, 0x8080ec8, ArrayRef.of(EnemyStats54.class, 250, 0x54, EnemyStats54::new));

  public static final UnboundedArrayRef<Class54> classes_8084b1c = MEMORY.ref(4, 0x8084b1c, UnboundedArrayRef.of(0x54, Class54::new));

  public static final ArrayRef<FieldPsynergyRange04> fieldPsynergyRanges_809e686 = MEMORY.ref(2, 0x809e686, ArrayRef.of(FieldPsynergyRange04.class, 12, 0x2, 0x4, FieldPsynergyRange04::new));

  public static final Matrix30 _80c2a7c = MEMORY.ref(4, 0x80c2a7c, Matrix30::new);

  /** Selects all moves equally */
  public static final ArrayRef<UnsignedByteRef> evenMoveSelection_80c2b80 = MEMORY.ref(1, 0x80c2b80, ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));
  /** Weighted towards lower moves */
  public static final ArrayRef<UnsignedByteRef> rareMoveSelection_80c2b88 = MEMORY.ref(1, 0x80c2b88, ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));
  /** Heavily weighted towards lower moves */
  public static final ArrayRef<UnsignedByteRef> veryRareMoveSelection_80c2b90 = MEMORY.ref(1, 0x80c2b90, ArrayRef.of(UnsignedByteRef.class, 8, 0x1, UnsignedByteRef::new));

  public static final ArrayRef<ActorProperties08> actorProperties_80c7420 = MEMORY.ref(4, 0x80c7420, ArrayRef.of(ActorProperties08.class, 170, 0x8, ActorProperties08::new));

  /**
   * <ul start="0">
   *   <li>{@link GoldenSun_80d#FUN_80da2ac}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e2538}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e302c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dd2ac}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dd9c0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dab74}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c91dc}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d3c80}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c972c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d33c0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9fc8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80da6cc}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d4ce8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80db6d4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d45ec}</li>
   *   <li>{@link GoldenSun_80d#FUN_80ddde0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80db264}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d41a4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de974}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d3854}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8960}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8948}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8954}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d896c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf2a0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9194}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9ab8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91a0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9ac4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91ac}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9ad0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5258}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5280}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ce85c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5298}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d528c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d59b0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d05fc}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ce4e8}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cfef4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5c48}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d85d0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d82b0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8954}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8954}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9194}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9ac4}</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80e#FUN_80e89ec}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ceb30}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e698c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80ecedc}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cb1a4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de980}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e90a8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dd2b8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de9bc}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e94b8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de9f0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ce034}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e99c0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d1350}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dea3c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d52b0}</li>
   *   <li>{@link GoldenSun_80e#FUN_80ecee8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d52bc}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d0ad4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d0ee0}</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91b8}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf2a0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dd77c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e1040}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8948}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dea24}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8954}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e0c84}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8994}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf2ac}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d9194}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91a0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d89a0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91c4}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e6638}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91ac}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d91d0}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e6948}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d05fc}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e28f4}</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80e#FUN_80e0564}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dfe2c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e08c0}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e01e4}</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80c#FUN_80c9c60}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c9c6c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c9c78}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de98c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c9c84}</li>
   *   <li>{@link GoldenSun_80c#FUN_80c9c90}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de9b0}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de998}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ceb3c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf8a4}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e28f4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dfa18}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d52a4}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca57c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dfa24}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf8b0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca588}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e291c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca594}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e294c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80ed104}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e2928}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf8c8}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca594}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5ac}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5b8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dfa30}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5c4}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e2934}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e294c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf8d4}</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5d0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5dc}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e2940}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5e8}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5a0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca5f4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d45f8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dfa3c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf8bc}</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80e#FUN_80e291c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e2928}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca1f0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ccebc}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5298}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf88c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cefe0}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca1e4}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cf898}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ceb48}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d8960}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cefd4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d5c48}</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80d#FUN_80db6c8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80de9a4}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ccc20}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ccc2c}</li>
   *   <li>{@link GoldenSun_80e#FUN_80e732c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80d244c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80ca600}</li>
   *   <li>{@link GoldenSun_80e#FUN_80eceac}</li>
   *   <li>{@link GoldenSun_80e#FUN_80ece7c}</li>
   *   <li>{@link GoldenSun_80c#FUN_80cefec}</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>null</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbbdc}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbbe8}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dea30}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbbf4}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbc00}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbc0c}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbc18}</li>
   *   <li>{@link GoldenSun_80d#FUN_80dbc24}</li>
   * </ul>
   */
  public static final ArrayRef<Pointer<ConsumerRef<Integer>>> _80ee2b4 = MEMORY.ref(4, 0x80ee2b4, ArrayRef.of(Pointer.classFor(ConsumerRef.classFor(Integer.class)), 407, 0x4, Pointer.deferred(4, ConsumerRef::new)));

  /**
   * <ol start="0">
   *   <li>0x1</li>
   *   <li>0x2</li>
   *   <li>0x4</li>
   *   <li>0x8</li>
   *   <li>0x10</li>
   *   <li>0x20</li>
   *   <li>0x40</li>
   *   <li>0x80</li>
   *   <li>0xc01 - 0x100</li>
   *   <li>0xc02 - 0x200</li>
   *   <li>0xb01 - 0x400</li>
   *   <li>0xb02 - 0x800</li>
   *   <li>0xa01 - 0x1000</li>
   *   <li>0xa02 - 0x2000</li>
   *   <li>0x901 - 0x4000</li>
   *   <li>0x902 - 0x8000</li>
   * </ol>
   */
  public static final ArrayRef<UnsignedShortRef> subOperands_80ef034 = MEMORY.ref(2, 0x80ef034, ArrayRef.of(UnsignedShortRef.class, 16, 0x2, UnsignedShortRef::new));

  public static final ArrayRef<SoundStruct0c> _80fc624 = MEMORY.ref(4, 0x80fc624, ArrayRef.of(SoundStruct0c.class, 8, 0xc, SoundStruct0c::new));

  public static final ArrayRef<IntRef> ptrTable_8320000 = MEMORY.ref(4, 0x8320000, ArrayRef.of(IntRef.class, 975, 0x4, IntRef::new));
}
