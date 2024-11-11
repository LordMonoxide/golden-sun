package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class GraphicsStructBig implements MemoryRef {
  private final Value ref;

  /** 0xa80 bytes */
  public final ArrayRef<Sub06> _380;
  /** 0xa80 bytes */
  public final ArrayRef<Sub06> _e00;
  /** 0xa80 bytes */
  public final ArrayRef<Sub06> _1880;
  public final ArrayRef<ArrayRef<ArrayRef<UnsignedShortRef>>> _2300;
  public final UnsignedByteRef _2a00;
  public final ByteRef _2a01;
  public final ByteRef _2a02;

  public GraphicsStructBig(final Value ref) {
    this.ref = ref;

    this._380 = ref.offset(2, 0x380).cast(ArrayRef.of(Sub06.class, 0x1c0, 0x6, Sub06::new));
    this._e00 = ref.offset(2, 0xe00).cast(ArrayRef.of(Sub06.class, 0x1c0, 0x6, Sub06::new));
    this._1880 = ref.offset(2, 0x1880).cast(ArrayRef.of(Sub06.class, 0x1c0, 0x6, Sub06::new));
    this._2300 = ref.offset(2, 0x2300).cast(ArrayRef.of(ArrayRef.classFor(ArrayRef.classFor(UnsignedShortRef.class)), 2, 0x380, ArrayRef.of(ArrayRef.classFor(UnsignedShortRef.class), 2, 0x1c0, ArrayRef.of(UnsignedShortRef.class, 0xe0, 0x2, UnsignedShortRef::new))));
    this._2a00 = ref.offset(1, 0x2a00).cast(UnsignedByteRef::new);
    this._2a01 = ref.offset(1, 0x2a01).cast(ByteRef::new);
    this._2a02 = ref.offset(1, 0x2a02).cast(ByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub06 implements MemoryRef {
    private final Value ref;

    public final UnsignedShortRef _00;
    public final ShortRef _02;
    public final ShortRef _04;

    public Sub06(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
      this._02 = ref.offset(2, 0x02).cast(ShortRef::new);
      this._04 = ref.offset(2, 0x04).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
