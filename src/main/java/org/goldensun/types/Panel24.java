package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Panel24 implements MemoryRef {
  private final Value ref;

  public final Pointer<GraphicsStruct1c> _00;
  public final Pointer<Panel24> _04;
  public final UnsignedShortRef w_08;
  public final UnsignedShortRef h_0a;
  public final UnsignedShortRef x_0c;
  public final UnsignedShortRef y_0e;
  public final UnsignedShortRef _10;
  public final UnsignedShortRef _12;
  public final UnsignedShortRef _14;
  public final UnsignedShortRef flags_16;
  public final ShortRef _18;
  public final ShortRef _1a;
  public final ShortRef currentX_1c;
  public final ShortRef currentY_1e;
  public final ShortRef currentW_20;
  public final ShortRef currentH_22;

  public Panel24(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, GraphicsStruct1c::new));
    this._04 = ref.offset(4, 0x04).cast(Pointer.deferred(4, Panel24::new));
    this.w_08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
    this.h_0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
    this.x_0c = ref.offset(2, 0x0c).cast(UnsignedShortRef::new);
    this.y_0e = ref.offset(2, 0x0e).cast(UnsignedShortRef::new);
    this._10 = ref.offset(2, 0x10).cast(UnsignedShortRef::new);
    this._12 = ref.offset(2, 0x12).cast(UnsignedShortRef::new);
    this._14 = ref.offset(2, 0x14).cast(UnsignedShortRef::new);
    this.flags_16 = ref.offset(2, 0x16).cast(UnsignedShortRef::new);
    this._18 = ref.offset(2, 0x18).cast(ShortRef::new);
    this._1a = ref.offset(2, 0x1a).cast(ShortRef::new);
    this.currentX_1c = ref.offset(2, 0x1c).cast(ShortRef::new);
    this.currentY_1e = ref.offset(2, 0x1e).cast(ShortRef::new);
    this.currentW_20 = ref.offset(2, 0x20).cast(ShortRef::new);
    this.currentH_22 = ref.offset(2, 0x22).cast(ShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
