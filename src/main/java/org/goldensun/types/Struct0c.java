package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedShortRef;

/** A bunch of pointer table entries (relative to entry 0x128) */
public class Struct0c implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef _00;
  public final UnsignedShortRef compressedPalette_02;
  public final UnsignedShortRef _04;
  public final UnsignedShortRef _06;
  public final UnsignedShortRef _08;
  public final UnsignedShortRef _0a;

  public Struct0c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this.compressedPalette_02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
    this._04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this._06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
    this._08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
    this._0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
