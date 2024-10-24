package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SoundStruct0c implements MemoryRef {
  private final Value ref;

  public final Pointer<SoundStruct> _00;
  public final Pointer<UnboundedArrayRef<SoundStruct50>> _04;
  public final UnsignedByteRef _08;

  public final UnsignedShortRef _0a;

  public SoundStruct0c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, SoundStruct::new));
    this._04 = ref.offset(4, 0x04).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x50, SoundStruct50::new)));
    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);

    this._0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
