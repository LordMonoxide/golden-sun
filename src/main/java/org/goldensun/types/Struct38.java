package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Struct38 implements MemoryRef {
  private final Value ref;

  public final RenderPacket0c _00;
  public final RenderPacket0c _0c;
  public final IntRef _18;
  public final UnsignedByteRef _1c;
  public final UnsignedByteRef _1d;
  public final UnsignedShortRef _1e;
  public final UnsignedByteRef _20;
  public final UnsignedByteRef _21;
  public final ByteRef _22;
  public final ByteRef _23;
  public final UnsignedByteRef _24;
  public final UnsignedByteRef _25;
  public final UnsignedByteRef _26;
  /** Count of elements in {@link #_28} */
  public final UnsignedByteRef _27;
  public final UnboundedArrayRef<Pointer<Struct18>> _28;

  public Struct38(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(RenderPacket0c::new);
    this._0c = ref.offset(4, 0x0c).cast(RenderPacket0c::new);
    this._18 = ref.offset(4, 0x18).cast(IntRef::new);
    this._1c = ref.offset(1, 0x1c).cast(UnsignedByteRef::new);
    this._1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);
    this._1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this._20 = ref.offset(1, 0x20).cast(UnsignedByteRef::new);
    this._21 = ref.offset(1, 0x21).cast(UnsignedByteRef::new);
    this._22 = ref.offset(1, 0x22).cast(ByteRef::new);
    this._23 = ref.offset(1, 0x23).cast(ByteRef::new);
    this._24 = ref.offset(1, 0x24).cast(UnsignedByteRef::new);
    this._25 = ref.offset(1, 0x25).cast(UnsignedByteRef::new);
    this._26 = ref.offset(1, 0x26).cast(UnsignedByteRef::new);
    this._27 = ref.offset(1, 0x27).cast(UnsignedByteRef::new);
    this._28 = ref.offset(4, 0x28).cast(UnboundedArrayRef.of(0x4, Pointer.deferred(4, Struct18::new)));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
