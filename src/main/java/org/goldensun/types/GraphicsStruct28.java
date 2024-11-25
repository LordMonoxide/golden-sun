package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedShortRef;

public class GraphicsStruct28 implements MemoryRef {
  private final Value ref;

  public final Pointer<Panel24> _00;
  public final UnsignedShortRef _04;
  public final UnsignedShortRef _06;
  public final ArrayRef<UnsignedShortRef> _08;
  public final UnsignedShortRef _10;
  public final UnsignedShortRef _12;
  public final UnsignedShortRef _14;
  public final UnsignedShortRef _16;
  public final UnsignedShortRef _18;
  public final UnsignedShortRef _1a;
  public final UnsignedShortRef _1c;
  public final UnsignedShortRef _1e;
  public final UnsignedShortRef _20;
  public final UnsignedShortRef _22;
  public final UnsignedShortRef _24;

  public GraphicsStruct28(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, Panel24::new));
    this._04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this._06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
    this._08 = ref.offset(2, 0x08).cast(ArrayRef.of(UnsignedShortRef.class, 4, 0x2, UnsignedShortRef::new));
    this._10 = ref.offset(2, 0x10).cast(UnsignedShortRef::new);
    this._12 = ref.offset(2, 0x12).cast(UnsignedShortRef::new);
    this._14 = ref.offset(2, 0x14).cast(UnsignedShortRef::new);
    this._16 = ref.offset(2, 0x16).cast(UnsignedShortRef::new);
    this._18 = ref.offset(2, 0x18).cast(UnsignedShortRef::new);
    this._1a = ref.offset(2, 0x1a).cast(UnsignedShortRef::new);
    this._1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
    this._1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this._20 = ref.offset(2, 0x20).cast(UnsignedShortRef::new);
    this._22 = ref.offset(2, 0x22).cast(UnsignedShortRef::new);
    this._24 = ref.offset(2, 0x24).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
