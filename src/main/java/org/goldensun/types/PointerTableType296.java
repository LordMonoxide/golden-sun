package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.RelativePointer;
import org.goldensun.memory.types.UnsignedByteRef;

public class PointerTableType296 implements MemoryRef {
  private final Value ref;

  public final UnsignedByteRef _00;
  public final UnsignedByteRef _01;
  public final UnsignedByteRef _02;
  public final UnsignedByteRef _03;
  public final UnsignedByteRef _04;
  public final UnsignedByteRef _05;
  public final UnsignedByteRef _06;
  public final UnsignedByteRef _07;
  public final UnsignedByteRef _08;
  public final UnsignedByteRef _09;

  public final ArrayRef<Sub08> _0c;
  /** Relative pointer from 0, compressed data */
  public final RelativePointer<UnsignedByteRef> _24;
  /** Relative pointer from 0, compressed data */
  public final RelativePointer<UnsignedByteRef> _28;
  /** Relative pointer from 0, compressed data */
  public final RelativePointer<UnsignedByteRef> _2c;
  /** Relative pointer from 0, compressed data */
  public final RelativePointer<UnsignedByteRef> _30;
  /** Relative pointer from 0, compressed data */
  public final RelativePointer<UnsignedByteRef> _34;
  /** Relative pointer from 0 */
  public final RelativePointer<UnsignedByteRef> _38;

  public PointerTableType296(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
    this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    this._02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
    this._03 = ref.offset(1, 0x03).cast(UnsignedByteRef::new);
    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);
    this._05 = ref.offset(1, 0x05).cast(UnsignedByteRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
    this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);
    this._09 = ref.offset(1, 0x09).cast(UnsignedByteRef::new);

    this._0c = ref.offset(4, 0x0c).cast(ArrayRef.of(Sub08.class, 3, 0xc, Sub08::new));
    this._24 = ref.offset(4, 0x24).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
    this._28 = ref.offset(4, 0x28).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
    this._2c = ref.offset(4, 0x2c).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
    this._30 = ref.offset(4, 0x30).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
    this._34 = ref.offset(4, 0x34).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
    this._38 = ref.offset(4, 0x38).cast(RelativePointer.deferred(1, ref.getAddress(), UnsignedByteRef::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub08 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef _00;
    public final UnsignedByteRef _01;
    public final ByteRef _02;
    public final ByteRef _03;
    public final ByteRef _04;
    public final ByteRef _05;
    public final UnsignedByteRef _06;
    public final UnsignedByteRef _07;

    public Sub08(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
      this._02 = ref.offset(1, 0x02).cast(ByteRef::new);
      this._03 = ref.offset(1, 0x03).cast(ByteRef::new);
      this._04 = ref.offset(1, 0x04).cast(ByteRef::new);
      this._05 = ref.offset(1, 0x05).cast(ByteRef::new);
      this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
      this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
