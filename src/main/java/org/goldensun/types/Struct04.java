package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Struct04 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef _00;
  public final UnsignedShortRef _02;

  public Struct04(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this._02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
