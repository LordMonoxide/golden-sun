package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class ChoiceMenu98 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<Sub14> _00;
  public final Pointer<GraphicsStruct24> _78;

  public final ArrayRef<UnsignedByteRef> _84;

  public final ShortRef _8c;
  public final ShortRef count_8e;
  public final ShortRef _90;
  public final ShortRef _92;
  public final ShortRef _94;

  public ChoiceMenu98(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(ArrayRef.of(Sub14.class, 6, 0x14, Sub14::new));
    this._78 = ref.offset(4, 0x78).cast(Pointer.deferred(4, GraphicsStruct24::new));

    this._84 = ref.offset(1, 0x84).cast(ArrayRef.of(UnsignedByteRef.class, 6, 0x1, UnsignedByteRef::new));

    this._8c = ref.offset(2, 0x8c).cast(ShortRef::new);
    this.count_8e = ref.offset(2, 0x8e).cast(ShortRef::new);
    this._90 = ref.offset(2, 0x90).cast(ShortRef::new);
    this._92 = ref.offset(2, 0x92).cast(ShortRef::new);
    this._94 = ref.offset(2, 0x94).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub14 implements MemoryRef {
    private final Value ref;

    public final RenderPacket0c packet_00;
    public final ShortRef _0c;
    public final ShortRef _0e;

    public final UnsignedShortRef vramSlot_12;

    public Sub14(final Value ref) {
      this.ref = ref;

      this.packet_00 = ref.offset(4, 0x00).cast(RenderPacket0c::new);
      this._0c = ref.offset(2, 0x0c).cast(ShortRef::new);
      this._0e = ref.offset(2, 0x0e).cast(ShortRef::new);

      this.vramSlot_12 = ref.offset(2, 0x12).cast(UnsignedShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
