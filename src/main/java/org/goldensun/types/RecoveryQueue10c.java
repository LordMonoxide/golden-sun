package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;

public class RecoveryQueue10c implements MemoryRef {
  private final Value ref;

  public final IntRef _00;

  public final UnboundedArrayRef<DjinnInfo04> _08;

  public final IntRef count_108;

  public RecoveryQueue10c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);

    this.count_108 = ref.offset(4, 0x108).cast(IntRef::new);

    this._08 = ref.offset(1, 0x08).cast(UnboundedArrayRef.of(0x4, DjinnInfo04::new, this.count_108::get));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class DjinnInfo04 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef element_00;
    public final UnsignedByteRef djinn_01;
    public final UnsignedByteRef charId_02;
    public final ByteRef _03;

    public DjinnInfo04(final Value ref) {
      this.ref = ref;

      this.element_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this.djinn_01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
      this.charId_02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
      this._03 = ref.offset(1, 0x03).cast(ByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
