package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.UnsignedByteRef;

public class Class54 implements MemoryRef {
  private final Value ref;

  public final UnsignedByteRef _08;
  public final UnsignedByteRef _09;
  public final UnsignedByteRef _0a;
  public final UnsignedByteRef _0b;
  public final UnsignedByteRef _0c;
  public final UnsignedByteRef _0d;

  public final ArrayRef<Sub04> abilities_10;
  public final ArrayRef<UnsignedByteRef> weaknesses_50;

  public Class54(final Value ref) {
    this.ref = ref;

    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);
    this._09 = ref.offset(1, 0x09).cast(UnsignedByteRef::new);
    this._0a = ref.offset(1, 0x0a).cast(UnsignedByteRef::new);
    this._0b = ref.offset(1, 0x0b).cast(UnsignedByteRef::new);
    this._0c = ref.offset(1, 0x0c).cast(UnsignedByteRef::new);
    this._0d = ref.offset(1, 0x0d).cast(UnsignedByteRef::new);

    this.abilities_10 = ref.offset(4, 0x10).cast(ArrayRef.of(Sub04.class, 16, 0x4, Sub04::new));
    this.weaknesses_50 = ref.offset(1, 0x50).cast(ArrayRef.of(UnsignedByteRef.class, 3, 0x1, UnsignedByteRef::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub04 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef ability_00;
    public final UnsignedByteRef level_01;

    public Sub04(final Value ref) {
      this.ref = ref;

      this.ability_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this.level_01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
