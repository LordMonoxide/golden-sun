package org.goldensun;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.FunctionRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.TriConsumerRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.GraphicsStruct184;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.SoundStruct0c;
import org.goldensun.types.SoundStructFb0;
import org.goldensun.types.Struct04;
import org.goldensun.types.Struct08;
import org.goldensun.types.Struct0c;

import static org.goldensun.Hardware.MEMORY;

public final class GoldenSunVars {
  private GoldenSunVars() { }

  public static final GraphicsStruct184 _2002090 = MEMORY.ref(4, 0x2002090, GraphicsStruct184::new);

  public static final SoundStructFb0 _2003050 = MEMORY.ref(4, 0x2003050, SoundStructFb0::new);

  public static final ArrayRef<Pointer<RenderPacket0c>> packets_3001400 = MEMORY.ref(4, 0x3001400, ArrayRef.of(Pointer.classFor(RenderPacket0c.class), 0x100, 0x4, Pointer.deferred(4, RenderPacket0c::new)));
  public static final IntRef ticks_3001800 = MEMORY.ref(4, 0x3001800, IntRef::new);
  public static final IntRef _3001804 = MEMORY.ref(4, 0x3001804, IntRef::new);

  public static final ArrayRef<UnsignedByteRef> _3001810 = MEMORY.ref(1, 0x3001810, ArrayRef.of(UnsignedByteRef.class, 0x200, 1, UnsignedByteRef::new));
  public static final Value _3001a10 = MEMORY.ref(1, 0x3001a10);

  public static final ArrayRef<Struct08> _3001a20 = MEMORY.ref(4, 0x3001a20, ArrayRef.of(Struct08.class, 20, 0x8, Struct08::new));
  public static final UnsignedByteRef _3001ac0 = MEMORY.ref(1, 0x3001ac0, UnsignedByteRef::new);

  public static final Value _3001ac4 = MEMORY.ref(1, 0x3001ac4);

  public static final IntRef heldButtonsLastFrame_3001ae8 = MEMORY.ref(4, 0x3001ae8, IntRef::new);
  public static final UnsignedByteRef _3001aec = MEMORY.ref(1, 0x3001aec, UnsignedByteRef::new);

  public static final IntRef _3001af0 = MEMORY.ref(4, 0x3001af0, IntRef::new);

  /** Unknown use, buttons pressed this frame are or'd with the current value */
  public static final IntRef accumulatedButtons_3001af8 = MEMORY.ref(4, 0x3001af8, IntRef::new);
  public static final IntRef _3001afc = MEMORY.ref(4, 0x3001afc, IntRef::new);
  public static final IntRef _3001b00 = MEMORY.ref(4, 0x3001b00, IntRef::new);
  public static final IntRef _3001b04 = MEMORY.ref(4, 0x3001b04, IntRef::new);

  public static final ArrayRef<Struct04> _3001b10 = MEMORY.ref(4, 0x3001b10, ArrayRef.of(Struct04.class, 0x60, 0x4, Struct04::new));
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

  public static final UnsignedByteRef _3001cc8 = MEMORY.ref(1, 0x3001cc8, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001ccc = MEMORY.ref(2, 0x3001ccc, UnsignedShortRef::new);

  public static final Value _3001cd0 = MEMORY.ref(2, 0x3001cd0);

  public static final UnsignedByteRef _3001cd4 = MEMORY.ref(1, 0x3001cd4, UnsignedByteRef::new);

  public static final IntRef _3001cf4 = MEMORY.ref(4, 0x3001cf4, IntRef::new);
  public static final UnsignedShortRef blendConfig_3001cf8 = MEMORY.ref(2, 0x3001cf8, UnsignedShortRef::new);

  public static final IntRef _3001cfc = MEMORY.ref(4, 0x3001cfc, IntRef::new);
  public static final UnsignedByteRef rotationScalingCount_3001d00 = MEMORY.ref(1, 0x3001d00, UnsignedByteRef::new);

  public static final IntRef _3001d04 = MEMORY.ref(4, 0x3001d04, IntRef::new);
  public static final UnsignedByteRef _3001d08 = MEMORY.ref(1, 0x3001d08, UnsignedByteRef::new);

  /** Buttons that are currently pressed (this frame, or held from a previous frame) */
  public static final IntRef heldButtons_3001d0c = MEMORY.ref(4, 0x3001d0c, IntRef::new);

  public static final UnsignedByteRef _3001d18 = MEMORY.ref(1, 0x3001d18, UnsignedByteRef::new);

  public static final IntRef _3001d1c = MEMORY.ref(4, 0x3001d1c, IntRef::new);
  public static final UnsignedByteRef _3001d20 = MEMORY.ref(1, 0x3001d20, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001d24 = MEMORY.ref(2, 0x3001d24, UnsignedShortRef::new);

  public static final UnsignedShortRef _3001d28 = MEMORY.ref(2, 0x3001d28, UnsignedShortRef::new);

  public static final UnsignedByteRef _3001d34 = MEMORY.ref(1, 0x3001d34, UnsignedByteRef::new);

  public static final ArrayRef<UnsignedShortRef> rotationScaling_3001d40 = MEMORY.ref(2, 0x3001d40, ArrayRef.of(UnsignedShortRef.class, 0x80, 0x2, UnsignedShortRef::new));
  public static final IntRef _3001e40 = MEMORY.ref(4, 0x3001e40, IntRef::new);
  public static final UnsignedByteRef _3001e44 = MEMORY.ref(1, 0x3001e44, UnsignedByteRef::new);

  public static final Value boardWramMallocHead_3001e50 = MEMORY.ref(4, 0x3001e50);
  public static final Value chipWramMallocHead_3001e54 = MEMORY.ref(4, 0x3001e54);

  public static final UnsignedByteRef _3001f54 = MEMORY.ref(1, 0x3001f54, UnsignedByteRef::new);

  public static final UnsignedByteRef _3001f58 = MEMORY.ref(1, 0x3001f58, UnsignedByteRef::new);

  public static final UnsignedShortRef heldLAndRTicks_3001f5c = MEMORY.ref(2, 0x3001f5c, UnsignedShortRef::new);

  public static final Value _3001f64 = MEMORY.ref(2, 0x3001f64);

  public static final IntRef _3007800 = MEMORY.ref(4, 0x3007800, IntRef::new);
  public static final Value _3007804 = MEMORY.ref(4, 0x3007804);

  public static final IntRef _3007810 = MEMORY.ref(4, 0x3007810, IntRef::new);

  public static final Pointer<SoundStructFb0> _3007ff0 = MEMORY.ref(4, 0x3007ff0, Pointer.deferred(4, SoundStructFb0::new));

  public static final IntRef _3007ffc = MEMORY.ref(4, 0x3007ffc, IntRef::new);

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
   *   <li>{@link GoldenSun#FUN_800ebec}</li>
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
  public static final ArrayRef<Pointer<FunctionRef<Integer, Integer>>> _8013624 = MEMORY.ref(4, 0x8013624, ArrayRef.of(Pointer.classFor(FunctionRef.classFor(Integer.class, Integer.class)), 47, 0x4, Pointer.deferred(4, FunctionRef::new)));
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
  public static final ArrayRef<Pointer<TriConsumerRef<Integer, Integer, Integer>>> _80136e0 = MEMORY.ref(4, 0x80136e0, ArrayRef.of(Pointer.classFor(TriConsumerRef.classFor(Integer.class, Integer.class, Integer.class)), 41, 0x4, Pointer.deferred(4, TriConsumerRef::new)));

  public static final UnboundedArrayRef<Struct0c> _8013784 = MEMORY.ref(4, 0x8013784, UnboundedArrayRef.of(0xc, Struct0c::new));

  public static final ArrayRef<SoundStruct0c> _80fc624 = MEMORY.ref(4, 0x80fc624, ArrayRef.of(SoundStruct0c.class, 8, 0xc, SoundStruct0c::new));

  public static final ArrayRef<IntRef> ptrTable_8320000 = MEMORY.ref(4, 0x8320000, ArrayRef.of(IntRef.class, 975, 0x4, IntRef::new));
}
