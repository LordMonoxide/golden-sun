package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

/** Hold textbox text */
public class Struct12fc implements MemoryRef {
  private final Value ref;

  /** GPU data */
  public final ArrayRef<ArrayRef<UnsignedShortRef>> _00;
  public final ArrayRef<Panel24> _500;
  public final ArrayRef<GraphicsStruct28> _620;
  public final ArrayRef<GraphicsStruct1c> _698;
  public final Pointer<GraphicsStruct1c> _d98;
  public final Pointer<Pointer<GraphicsStruct1c>> _d9c;
  public final ArrayRef<UnsignedByteRef> _da0;
  public final UnsignedShortRef _ea0;
  public final UnsignedByteRef _ea2;
  public final UnsignedByteRef _ea3;
  public final UnsignedByteRef _ea4;
  public final UnsignedByteRef _ea5;
  public final UnsignedByteRef _ea6;
  public final UnsignedByteRef _ea7;
  public final UnsignedShortRef _ea8;
  public final UnsignedShortRef _eaa;
  public final UnsignedShortRef _eac;
  public final UnsignedShortRef _eae;
  public final ArrayRef<UnsignedShortRef> text_eb0;
  public final UnsignedShortRef _12b0;
  public final UnsignedShortRef textOffset_12b2;
  public final UnsignedShortRef _12b4;
  public final UnsignedShortRef vramSlot_12b6;
  public final UnsignedShortRef _12b8;

  public final ArrayRef<IntRef> _12bc;
  public final ArrayRef<UnsignedShortRef> _12dc;

  /** TODO ??? random overlap? */
  public final UnboundedArrayRef<UnsignedShortRef> _12d0;

  public final UnsignedShortRef _12ec;
  public final UnsignedShortRef _12ee;
  public final ArrayRef<UnsignedShortRef> _12f0;
  public final UnsignedShortRef _12f4;
  public final UnsignedShortRef _12f6;
  public final UnsignedByteRef _12f8;
  public final UnsignedByteRef _12f9;
  public final UnsignedByteRef _12fa;
  public final UnsignedByteRef _12fb;

  public Struct12fc(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(2, 0x00).cast(ArrayRef.of(ArrayRef.classFor(UnsignedShortRef.class), 5, 0x100, ArrayRef.of(UnsignedShortRef.class, 0x80, 0x2, UnsignedShortRef::new)));
    this._500 = ref.offset(4, 0x500).cast(ArrayRef.of(Panel24.class, 8, 0x24, Panel24::new));
    this._620 = ref.offset(4, 0x620).cast(ArrayRef.of(GraphicsStruct28.class, 3, 0x28, GraphicsStruct28::new));
    this._698 = ref.offset(4, 0x698).cast(ArrayRef.of(GraphicsStruct1c.class, 64, 0x1c, GraphicsStruct1c::new));
    this._d98 = ref.offset(4, 0xd98).cast(Pointer.deferred(4, GraphicsStruct1c::new));
    this._d9c = ref.offset(4, 0xd9c).cast(Pointer.deferred(4, Pointer.deferred(4, GraphicsStruct1c::new)));
    this._da0 = ref.offset(1, 0xda0).cast(ArrayRef.of(UnsignedByteRef.class, 0x100, 0x1, UnsignedByteRef::new));
    this._ea0 = ref.offset(2, 0xea0).cast(UnsignedShortRef::new);
    this._ea2 = ref.offset(1, 0xea2).cast(UnsignedByteRef::new);
    this._ea3 = ref.offset(1, 0xea3).cast(UnsignedByteRef::new);
    this._ea4 = ref.offset(1, 0xea4).cast(UnsignedByteRef::new);
    this._ea5 = ref.offset(1, 0xea5).cast(UnsignedByteRef::new);
    this._ea6 = ref.offset(1, 0xea6).cast(UnsignedByteRef::new);
    this._ea7 = ref.offset(1, 0xea7).cast(UnsignedByteRef::new);
    this._ea8 = ref.offset(2, 0xea8).cast(UnsignedShortRef::new);
    this._eaa = ref.offset(2, 0xeaa).cast(UnsignedShortRef::new);
    this._eac = ref.offset(2, 0xeac).cast(UnsignedShortRef::new);
    this._eae = ref.offset(2, 0xeae).cast(UnsignedShortRef::new);
    this.text_eb0 = ref.offset(2, 0xeb0).cast(ArrayRef.of(UnsignedShortRef.class, 0x200, 0x2, UnsignedShortRef::new));
    this._12b0 = ref.offset(2, 0x12b0).cast(UnsignedShortRef::new);
    this.textOffset_12b2 = ref.offset(2, 0x12b2).cast(UnsignedShortRef::new);
    this._12b4 = ref.offset(2, 0x12b4).cast(UnsignedShortRef::new);
    this.vramSlot_12b6 = ref.offset(2, 0x12b6).cast(UnsignedShortRef::new);
    this._12b8 = ref.offset(2, 0x12b8).cast(UnsignedShortRef::new);

    this._12bc = ref.offset(4, 0x12bc).cast(ArrayRef.of(IntRef.class, 8, 0x4, IntRef::new));
    this._12dc = ref.offset(2, 0x12dc).cast(ArrayRef.of(UnsignedShortRef.class, 8, 0x2, UnsignedShortRef::new));

    this._12d0 = ref.offset(2, 0x12d0).cast(UnboundedArrayRef.of(0x2, UnsignedShortRef::new));

    this._12ec = ref.offset(2, 0x12ec).cast(UnsignedShortRef::new);
    this._12ee = ref.offset(2, 0x12ee).cast(UnsignedShortRef::new);
    this._12f0 = ref.offset(2, 0x12f0).cast(ArrayRef.of(UnsignedShortRef.class, 2, 0x2, UnsignedShortRef::new));
    this._12f4 = ref.offset(2, 0x12f4).cast(UnsignedShortRef::new);
    this._12f6 = ref.offset(2, 0x12f6).cast(UnsignedShortRef::new);
    this._12f8 = ref.offset(1, 0x12f8).cast(UnsignedByteRef::new);
    this._12f9 = ref.offset(1, 0x12f9).cast(UnsignedByteRef::new);
    this._12fa = ref.offset(1, 0x12fa).cast(UnsignedByteRef::new);
    this._12fb = ref.offset(1, 0x12fb).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
