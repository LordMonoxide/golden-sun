package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class GraphicsStruct implements MemoryRef {
  private final Value ref;

  public final Pointer<GraphicsStruct> _00;
  public final UnsignedByteRef _04;
  public final UnsignedByteRef _05;
  public final UnsignedShortRef _06;
  public final UnsignedShortRef _08;

  public final UnsignedShortRef _0c;

  public final UnsignedByteRef slot_0e;
  public final UnsignedByteRef _0f;
  public final RenderPacket0c packet_10;
  public final UnsignedByteRef _14;
  public final UnsignedByteRef _15;
  /** Overlaps {@link #_17} */
  public final UnsignedShortRef _16;
  /** Overlaps {@link #_16} */
  public final UnsignedByteRef _17;
  public final UnsignedShortRef _18;

  public final UnsignedShortRef _1c;

  public GraphicsStruct(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, GraphicsStruct::new));
    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);
    this._05 = ref.offset(1, 0x05).cast(UnsignedByteRef::new);
    this._06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
    this._08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);

    this._0c = ref.offset(2, 0x0c).cast(UnsignedShortRef::new);

    this.slot_0e = ref.offset(1, 0x0e).cast(UnsignedByteRef::new);
    this._0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this.packet_10 = ref.offset(4, 0x10).cast(RenderPacket0c::new);
    this._14 = ref.offset(1, 0x14).cast(UnsignedByteRef::new);
    this._15 = ref.offset(1, 0x15).cast(UnsignedByteRef::new);
    this._16 = ref.offset(2, 0x16).cast(UnsignedShortRef::new);
    this._17 = ref.offset(1, 0x17).cast(UnsignedByteRef::new);
    this._18 = ref.offset(2, 0x18).cast(UnsignedShortRef::new);

    this._1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
