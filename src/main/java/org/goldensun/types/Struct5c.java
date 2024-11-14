package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Struct5c implements MemoryRef {
  private final Value ref;

  public final UnsignedShortRef _00;

  public final ShortRef _04;
  public final UnsignedByteRef _06;
  public final UnsignedByteRef _07;

  public final IntRef _18;
  public final ArrayRef<Sub08> _1c;

  public Struct5c(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);

    this._04 = ref.offset(2, 0x04).cast(ShortRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
    this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);

    this._18 = ref.offset(4, 0x18).cast(IntRef::new);
    this._1c = ref.offset(4, 0x1c).cast(ArrayRef.of(Sub08.class, 8, 0x8, Sub08::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub08 implements MemoryRef {
    private final Value ref;

    public final IntRef _00;
    public final IntRef _04;

    public Sub08(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(4, 0x00).cast(IntRef::new);
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
