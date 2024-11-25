package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.CString;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SaveStruct1100 implements MemoryRef {
  private final Value ref;

  public final ArrayRef<UnsignedByteRef> _00;
  public final ArrayRef<UnsignedByteRef> _10;
  public final ArrayRef<UnsignedShortRef> _20;
  public final Sub10 _40;
  public final Value _50;

  public final ArrayRef<Preview40> _1040;

  public SaveStruct1100(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(1, 0x00).cast(ArrayRef.of(UnsignedByteRef.class, 0x10, 0x1, UnsignedByteRef::new));
    this._10 = ref.offset(1, 0x10).cast(ArrayRef.of(UnsignedByteRef.class, 0x10, 0x1, UnsignedByteRef::new));
    this._20 = ref.offset(2, 0x20).cast(ArrayRef.of(UnsignedShortRef.class, 0x10, 0x2, UnsignedShortRef::new));
    this._40 = ref.offset(4, 0x40).cast(Sub10::new);
    this._50 = ref.offset(4, 0x50);

    this._1040 = ref.offset(4, 0x1040).cast(ArrayRef.of(Preview40.class, 3, 0x40, Preview40::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub10 implements MemoryRef {
    private final Value ref;

    public final CString camelot_00;
    public final UnsignedByteRef _07;
    public final UnsignedShortRef checksum_08;
    public final UnsignedShortRef _0a;

    public Sub10(final Value ref) {
      this.ref = ref;

      this.camelot_00 = ref.offset(1, 0x00).cast(CString.maxLength(7));
      this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
      this.checksum_08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
      this._0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Preview40 implements MemoryRef {
    private final Value ref;

    public final CString name_10;
    public final UnsignedByteRef level_1c;
    public final UnsignedByteRef class_1d;
    public final UnsignedShortRef location_1e;
    public final IntRef time_20;
    public final IntRef coins_24;
    public final ArrayRef<ByteRef> djinnCounts_28;
    public final ArrayRef<ByteRef> charIds;

    public final ByteRef _31;
    public final ByteRef _32;
    public final ByteRef _33;
    public final UnsignedByteRef _34;
    public final UnsignedByteRef _35;
    public final UnsignedShortRef buildDate_36;
    public final IntRef _38;

    public Preview40(final Value ref) {
      this.ref = ref;

      this.name_10 = ref.offset(1, 0x10).cast(CString.maxLength(0xc));
      this.level_1c = ref.offset(1, 0x1c).cast(UnsignedByteRef::new);
      this.class_1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);
      this.location_1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
      this.time_20 = ref.offset(4, 0x20).cast(IntRef::new);
      this.coins_24 = ref.offset(4, 0x24).cast(IntRef::new);
      this.djinnCounts_28 = ref.offset(1, 0x28).cast(ArrayRef.of(ByteRef.class, 4, 0x1, ByteRef::new));
      this.charIds = ref.offset(1, 0x2c).cast(ArrayRef.of(ByteRef.class, 4, 0x1, ByteRef::new));

      this._31 = ref.offset(1, 0x31).cast(ByteRef::new);
      this._32 = ref.offset(1, 0x32).cast(ByteRef::new);
      this._33 = ref.offset(1, 0x33).cast(ByteRef::new);
      this._34 = ref.offset(1, 0x34).cast(UnsignedByteRef::new);
      this._35 = ref.offset(1, 0x35).cast(UnsignedByteRef::new);
      this.buildDate_36 = ref.offset(2, 0x36).cast(UnsignedShortRef::new);
      this._38 = ref.offset(4, 0x38).cast(IntRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
