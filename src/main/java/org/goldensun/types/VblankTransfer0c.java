package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;

public class VblankTransfer0c implements MemoryRef {
  private final Value ref;

  /** TODO pointer */
  public final IntRef src_00;
  /** TODO pointer */
  public final IntRef dst_04;
  public final IntRef cnt_08;

  public VblankTransfer0c(final Value ref) {
    this.ref = ref;

    this.src_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this.dst_04 = ref.offset(4, 0x04).cast(IntRef::new);
    this.cnt_08 = ref.offset(4, 0x08).cast(IntRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
