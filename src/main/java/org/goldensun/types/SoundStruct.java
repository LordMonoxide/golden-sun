package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SoundStruct implements MemoryRef {
  private final Value ref;

  public final IntRef _00;
  public final IntRef _04;
  public final UnsignedByteRef _08;
  public final UnsignedByteRef _09;
  public final UnsignedByteRef _0a;
  public final UnsignedByteRef _0b;
  public final IntRef _0c;

  public final IntRef _18;
  public final UnsignedShortRef _1c;
  public final UnsignedShortRef _1e;
  public final UnsignedShortRef _20;
  public final UnsignedShortRef _22;
  public final UnsignedShortRef _24;
  public final UnsignedShortRef _26;
  public final ShortRef _28;

  public final Pointer<UnboundedArrayRef<SoundStruct50>> _2c;
  public final IntRef _30;
  /** Magic */
  public final IntRef _34;
  public final Pointer<ConsumerRef<SoundStruct>> _38;
  public final Pointer<SoundStruct> _3c;

  public SoundStruct(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._04 = ref.offset(4, 0x04).cast(IntRef::new);
    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);
    this._09 = ref.offset(1, 0x09).cast(UnsignedByteRef::new);
    this._0a = ref.offset(1, 0x0a).cast(UnsignedByteRef::new);
    this._0b = ref.offset(1, 0x0b).cast(UnsignedByteRef::new);
    this._0c = ref.offset(4, 0x0c).cast(IntRef::new);

    this._18 = ref.offset(4, 0x18).cast(IntRef::new);
    this._1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
    this._1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this._20 = ref.offset(2, 0x20).cast(UnsignedShortRef::new);
    this._22 = ref.offset(2, 0x22).cast(UnsignedShortRef::new);
    this._24 = ref.offset(2, 0x24).cast(UnsignedShortRef::new);
    this._26 = ref.offset(2, 0x26).cast(UnsignedShortRef::new);
    this._28 = ref.offset(2, 0x28).cast(ShortRef::new);

    this._2c = ref.offset(4, 0x2c).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x50, SoundStruct50::new)));
    this._30 = ref.offset(4, 0x30).cast(IntRef::new);
    this._34 = ref.offset(4, 0x34).cast(IntRef::new);
    this._38 = ref.offset(4, 0x38).cast(Pointer.deferred(4, ConsumerRef::new));
    this._3c = ref.offset(4, 0x3c).cast(Pointer.deferred(4, SoundStruct::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
