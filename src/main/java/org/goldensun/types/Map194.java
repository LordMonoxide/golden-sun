package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Map194 implements MemoryRef {
  private final Value ref;

  /** TODO pointer */
  public final IntRef _00;
  public final IntRef _04;
  public final IntRef _08;
  public final IntRef _0c;
  /** TODO pointer to something */
  public final IntRef _10;
  public final UnsignedShortRef _14;
  public final UnsignedByteRef _16;
  public final UnsignedByteRef _17;
  public final ArrayRef<Sub0c> _18;
  /** Kinda weird, but it looks like this isn't part of the previous array... not 100% sure it's the same class but the memory layout matches */
  public final Sub0c _d8;
  public final IntRef _e4;
  public final IntRef _e8;
  public final IntRef _ec;
  public final IntRef _f0;
  public final IntRef _f4;
  public final IntRef _f8;

  public final ArrayRef<UnsignedByteRef> _100;
  public final UnsignedByteRef _103;
  public final ArrayRef<Sub30> _104;

  public Map194(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._04 = ref.offset(4, 0x04).cast(IntRef::new);
    this._08 = ref.offset(4, 0x08).cast(IntRef::new);
    this._0c = ref.offset(4, 0x0c).cast(IntRef::new);
    this._10 = ref.offset(4, 0x10).cast(IntRef::new);
    this._14 = ref.offset(2, 0x14).cast(UnsignedShortRef::new);
    this._16 = ref.offset(1, 0x16).cast(UnsignedByteRef::new);
    this._17 = ref.offset(1, 0x17).cast(UnsignedByteRef::new);
    this._18 = ref.offset(4, 0x18).cast(ArrayRef.of(Sub0c.class, 0x10, 0xc, Sub0c::new));
    this._d8 = ref.offset(4, 0xd8).cast(Sub0c::new);
    this._e4 = ref.offset(4, 0xe4).cast(IntRef::new);
    this._e8 = ref.offset(4, 0xe8).cast(IntRef::new);
    this._ec = ref.offset(4, 0xec).cast(IntRef::new);
    this._f0 = ref.offset(4, 0xf0).cast(IntRef::new);
    this._f4 = ref.offset(4, 0xf4).cast(IntRef::new);
    this._f8 = ref.offset(4, 0xf8).cast(IntRef::new);

    this._100 = ref.offset(1, 0x100).cast(ArrayRef.of(UnsignedByteRef.class, 3, 0x1, UnsignedByteRef::new));
    this._103 = ref.offset(1, 0x103).cast(UnsignedByteRef::new);
    this._104 = ref.offset(4, 0x104).cast(ArrayRef.of(Sub30.class, 3, 0x30, Sub30::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub0c implements MemoryRef {
    private final Value ref;

    public final IntRef _00;
    /** TODO ptr */
    public final IntRef _04;
    public final UnsignedShortRef _08;
    public final UnsignedShortRef _0a;

    public Sub0c(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(4, 0x00).cast(IntRef::new);
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
      this._08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
      this._0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Sub30 implements MemoryRef {
    private final Value ref;

    public final IntRef _00;
    public final IntRef _04;
    public final IntRef _08;
    public final IntRef _0c;
    public final IntRef _10;
    public final IntRef _14;
    public final IntRef _18;
    public final IntRef _1c;
    public final IntRef _20;
    public final IntRef _24;
    public final UnsignedShortRef _28;
    public final UnsignedShortRef _2a;
    public final IntRef _2c;

    public Sub30(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(4, 0x00).cast(IntRef::new);
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
      this._08 = ref.offset(4, 0x08).cast(IntRef::new);
      this._0c = ref.offset(4, 0x0c).cast(IntRef::new);
      this._10 = ref.offset(4, 0x10).cast(IntRef::new);
      this._14 = ref.offset(4, 0x14).cast(IntRef::new);
      this._18 = ref.offset(4, 0x18).cast(IntRef::new);
      this._1c = ref.offset(4, 0x1c).cast(IntRef::new);
      this._20 = ref.offset(4, 0x20).cast(IntRef::new);
      this._24 = ref.offset(4, 0x24).cast(IntRef::new);
      this._28 = ref.offset(2, 0x28).cast(UnsignedShortRef::new);
      this._2a = ref.offset(2, 0x2a).cast(UnsignedShortRef::new);
      this._2c = ref.offset(4, 0x2c).cast(IntRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
