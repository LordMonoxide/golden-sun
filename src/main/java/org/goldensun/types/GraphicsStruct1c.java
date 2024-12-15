package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class GraphicsStruct1c implements MemoryRef {
  private final Value ref;

  public final Pointer<GraphicsStruct1c> _00;
  public final UnsignedByteRef _04;
  public final UnsignedByteRef _05;
  public final ShortRef x_06;
  public final ShortRef y_08;

  public final UnsignedShortRef rotation_0c;

  public final UnsignedByteRef slot_0e;
  public final UnsignedByteRef _0f;
  public final RenderPacket0c packet_10;

  public GraphicsStruct1c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, GraphicsStruct1c::new));
    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);
    this._05 = ref.offset(1, 0x05).cast(UnsignedByteRef::new);
    this.x_06 = ref.offset(2, 0x06).cast(ShortRef::new);
    this.y_08 = ref.offset(2, 0x08).cast(ShortRef::new);

    this.rotation_0c = ref.offset(2, 0x0c).cast(UnsignedShortRef::new);

    this.slot_0e = ref.offset(1, 0x0e).cast(UnsignedByteRef::new);
    this._0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this.packet_10 = ref.offset(4, 0x10).cast(RenderPacket0c::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
