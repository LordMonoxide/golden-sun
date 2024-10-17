package org.goldensun;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

import static org.goldensun.Hardware.MEMORY;

public final class GoldenSunVars {
  private GoldenSunVars() { }

  public static final IntRef _2002090 = MEMORY.ref(4, 0x2002090, IntRef::new);

  public static final IntRef _3001800 = MEMORY.ref(4, 0x3001800, IntRef::new);
  public static final IntRef _3001804 = MEMORY.ref(4, 0x3001804, IntRef::new);

  public static final Value _3001a10 = MEMORY.ref(1, 0x3001a10);

  /** Array of 20 0x8-byte structs */
  @Deprecated
  public static final Value _3001a20 = MEMORY.ref(1, 0x3001a20);

  public static final UnsignedByteRef _3001ac0 = MEMORY.ref(1, 0x3001ac0, UnsignedByteRef::new);

  public static final Value _3001ac4 = MEMORY.ref(1, 0x3001ac4);

  public static final IntRef heldButtonsLastFrame_3001ae8 = MEMORY.ref(4, 0x3001ae8, IntRef::new);
  public static final UnsignedByteRef _3001aec = MEMORY.ref(1, 0x3001aec, UnsignedByteRef::new);

  public static final IntRef _3001af0 = MEMORY.ref(4, 0x3001af0, IntRef::new);

  /** Unknown use, buttons pressed this frame are or'd with the current value */
  public static final IntRef accumulatedButtons_3001af8 = MEMORY.ref(4, 0x3001af8, IntRef::new);

  public static final IntRef _3001b00 = MEMORY.ref(4, 0x3001b00, IntRef::new);
  public static final IntRef _3001b04 = MEMORY.ref(4, 0x3001b04, IntRef::new);

  /** Buttons that were pressed this frame */
  public static final IntRef pressedButtons_3001c94 = MEMORY.ref(4, 0x3001c94, IntRef::new);
  public static final UnsignedByteRef _3001c98 = MEMORY.ref(1, 0x3001c98, UnsignedByteRef::new);

  public static final IntRef _3001c9c = MEMORY.ref(4, 0x3001c9c, IntRef::new);
  public static final UnsignedByteRef _3001ca0 = MEMORY.ref(1, 0x3001ca0, UnsignedByteRef::new);

  public static final IntRef _3001ca4 = MEMORY.ref(4, 0x3001ca4, IntRef::new);
  public static final UnsignedByteRef _3001ca8 = MEMORY.ref(1, 0x3001ca8, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001cb0 = MEMORY.ref(2, 0x3001cb0, UnsignedShortRef::new);

  public static final UnsignedByteRef _3001cb8 = MEMORY.ref(1, 0x3001cb8, UnsignedByteRef::new);

  public static final Value _3001cbc = MEMORY.ref(4, 0x3001cbc);

  public static final UnsignedByteRef _3001cc8 = MEMORY.ref(1, 0x3001cc8, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001ccc = MEMORY.ref(2, 0x3001ccc, UnsignedShortRef::new);

  public static final Value _3001cd0 = MEMORY.ref(2, 0x3001cd0);

  public static final UnsignedByteRef _3001cd4 = MEMORY.ref(1, 0x3001cd4, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001cf8 = MEMORY.ref(2, 0x3001cf8, UnsignedShortRef::new);

  public static final IntRef _3001cfc = MEMORY.ref(4, 0x3001cfc, IntRef::new);

  public static final UnsignedByteRef _3001d08 = MEMORY.ref(1, 0x3001d08, UnsignedByteRef::new);

  /** Buttons that are currently pressed (this frame, or held from a previous frame) */
  public static final IntRef heldButtons_3001d0c = MEMORY.ref(4, 0x3001d0c, IntRef::new);

  public static final UnsignedByteRef _3001d18 = MEMORY.ref(1, 0x3001d18, UnsignedByteRef::new);

  public static final UnsignedByteRef _3001d20 = MEMORY.ref(1, 0x3001d20, UnsignedByteRef::new);

  public static final UnsignedShortRef _3001d28 = MEMORY.ref(2, 0x3001d28, UnsignedShortRef::new);

  public static final UnsignedByteRef _3001d34 = MEMORY.ref(1, 0x3001d34, UnsignedByteRef::new);

  public static final IntRef _3001e40 = MEMORY.ref(4, 0x3001e40, IntRef::new);
  public static final UnsignedByteRef _3001e44 = MEMORY.ref(1, 0x3001e44, UnsignedByteRef::new);

  public static final Value _3001e50 = MEMORY.ref(4, 0x3001e50);
  public static final Value _3001e54 = MEMORY.ref(4, 0x3001e54);

  public static final IntRef _3001f20 = MEMORY.ref(4, 0x3001f20, IntRef::new);

  public static final UnsignedByteRef _3001f54 = MEMORY.ref(1, 0x3001f54, UnsignedByteRef::new);

  public static final UnsignedByteRef _3001f58 = MEMORY.ref(1, 0x3001f58, UnsignedByteRef::new);

  public static final UnsignedShortRef heldLAndRTicks_3001f5c = MEMORY.ref(2, 0x3001f5c, UnsignedShortRef::new);

  public static final Value _3001f64 = MEMORY.ref(2, 0x3001f64);

  public static final IntRef _3007800 = MEMORY.ref(4, 0x3007800, IntRef::new);
  public static final Value _3007804 = MEMORY.ref(4, 0x3007804);

  public static final IntRef _3007810 = MEMORY.ref(4, 0x3007810, IntRef::new);

  /** TODO pointer to struct */
  public static final Pointer<IntRef> _3007ff0 = MEMORY.ref(4, 0x3007ff0, Pointer.deferred(4, IntRef::new));

  public static final IntRef _3007ffc = MEMORY.ref(4, 0x3007ffc, IntRef::new);

  public static final ArrayRef<IntRef> ptrTable_8320000 = MEMORY.ref(4, 0x8320000, ArrayRef.of(IntRef.class, 975, 0x4, IntRef::new));
}
