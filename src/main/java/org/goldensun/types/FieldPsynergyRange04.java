package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class FieldPsynergyRange04 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef fieldPsynergyId_00;
  public final UnsignedShortRef range_02;

  public FieldPsynergyRange04(final Value ref) {
    this.ref = ref;

    this.fieldPsynergyId_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this.range_02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
