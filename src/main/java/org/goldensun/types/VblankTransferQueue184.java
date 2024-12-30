package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class VblankTransferQueue184 implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef count_00;
  public final UnsignedShortRef _02;
  public final ArrayRef<VblankTransfer0c> queue_04;

  public VblankTransferQueue184(final Value ref) {
    this.ref = ref;

    this.count_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this._02 = ref.offset(2, 0x02).cast(UnsignedShortRef::new);
    this.queue_04 = ref.offset(4, 0x04).cast(ArrayRef.of(VblankTransfer0c.class, 32, 0xc, VblankTransfer0c::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
