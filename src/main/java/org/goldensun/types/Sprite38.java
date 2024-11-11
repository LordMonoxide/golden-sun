package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Sprite38 implements MemoryRef {
  private final Value ref;

  public final RenderPacket0c packet_00;
  public final RenderPacket0c shadowPacket_0c;
  public final IntRef scale_18;
  public final UnsignedByteRef slot_1c;
  public final UnsignedByteRef _1d;
  public final UnsignedShortRef rotation_1e;
  public final UnsignedByteRef width_20;
  public final UnsignedByteRef height_21;
  public final ByteRef x_22;
  public final ByteRef y_23;
  public final UnsignedByteRef _24;
  public final UnsignedByteRef _25;
  public final UnsignedByteRef _26;
  /** Count of elements in {@link #layers_28} */
  public final UnsignedByteRef layerCount_27;
  public final UnboundedArrayRef<Pointer<SpriteLayer18>> layers_28;

  public Sprite38(final Value ref) {
    this.ref = ref;

    this.packet_00 = ref.offset(4, 0x00).cast(RenderPacket0c::new);
    this.shadowPacket_0c = ref.offset(4, 0x0c).cast(RenderPacket0c::new);
    this.scale_18 = ref.offset(4, 0x18).cast(IntRef::new);
    this.slot_1c = ref.offset(1, 0x1c).cast(UnsignedByteRef::new);
    this._1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);
    this.rotation_1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this.width_20 = ref.offset(1, 0x20).cast(UnsignedByteRef::new);
    this.height_21 = ref.offset(1, 0x21).cast(UnsignedByteRef::new);
    this.x_22 = ref.offset(1, 0x22).cast(ByteRef::new);
    this.y_23 = ref.offset(1, 0x23).cast(ByteRef::new);
    this._24 = ref.offset(1, 0x24).cast(UnsignedByteRef::new);
    this._25 = ref.offset(1, 0x25).cast(UnsignedByteRef::new);
    this._26 = ref.offset(1, 0x26).cast(UnsignedByteRef::new);
    this.layerCount_27 = ref.offset(1, 0x27).cast(UnsignedByteRef::new);
    this.layers_28 = ref.offset(4, 0x28).cast(UnboundedArrayRef.of(0x4, Pointer.deferred(4, SpriteLayer18::new)));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
