package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.TriFunctionRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SramTypeStruct implements MemoryRef {
  private final Value ref;

  public final IntRef _00;
  public final IntRef _04;
  public final IntRef _08;
  public final Pointer<TriFunctionRef<Integer, Integer, Integer, Integer>> _0c;
  public final IntRef _10;
  public final Value _14;
  public final UnsignedShortRef _28;

  public SramTypeStruct(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._04 = ref.offset(4, 0x04).cast(IntRef::new);
    this._08 = ref.offset(4, 0x08).cast(IntRef::new);
    this._0c = ref.offset(4, 0x0c).cast(Pointer.deferred(4, TriFunctionRef::new));
    this._10 = ref.offset(4, 0x10).cast(IntRef::new);
    this._14 = ref.offset(4, 0x14);
    this._28 = ref.offset(2, 0x28).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
