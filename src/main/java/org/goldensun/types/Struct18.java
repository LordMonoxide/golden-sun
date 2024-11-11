package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;

public class Struct18 implements MemoryRef {
  private final Value ref;

  public final ShortRef _00;
  public final ShortRef _02;
  public final UnsignedByteRef _04;
  public final UnsignedByteRef _05;
  public final UnsignedByteRef _06;
  public final UnsignedByteRef _07;
  public final IntRef _08;
  /** TODO ptr */
  public final IntRef _0c;
  public final IntRef _10;
  public final UnsignedByteRef _14;
  public final UnsignedByteRef _15;
  public final UnsignedByteRef _16;
  public final UnsignedByteRef _17;

  public Struct18(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(2, 0x00).cast(ShortRef::new);
    this._02 = ref.offset(2, 0x02).cast(ShortRef::new);
    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);
    this._05 = ref.offset(1, 0x05).cast(UnsignedByteRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
    this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
    this._08 = ref.offset(4, 0x08).cast(IntRef::new);
    this._0c = ref.offset(4, 0x0c).cast(IntRef::new);
    this._10 = ref.offset(4, 0x10).cast(IntRef::new);
    this._14 = ref.offset(1, 0x14).cast(UnsignedByteRef::new);
    this._15 = ref.offset(1, 0x15).cast(UnsignedByteRef::new);
    this._16 = ref.offset(1, 0x16).cast(UnsignedByteRef::new);
    this._17 = ref.offset(1, 0x17).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
