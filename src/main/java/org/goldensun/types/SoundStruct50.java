package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SoundStruct50 implements MemoryRef {
  private final Value ref;

  public final UnsignedByteRef _00;
  public final UnsignedByteRef _01;
  public final UnsignedByteRef _02;

  public final ByteRef _04;
  public final UnsignedByteRef _05;
  public final UnsignedByteRef _06;
  public final UnsignedByteRef _07;
  public final ByteRef _08;
  public final ByteRef _09;
  public final ByteRef _0a;
  public final ByteRef _0b;
  public final ByteRef _0c;
  public final UnsignedByteRef _0d;
  public final ByteRef _0e;
  public final UnsignedByteRef _0f;
  public final UnsignedByteRef _10;
  public final UnsignedByteRef _11;
  public final UnsignedByteRef _12;
  public final UnsignedByteRef _13;
  public final ByteRef _14;
  public final ByteRef _15;
  public final ByteRef _16;
  public final UnsignedByteRef _17;
  public final UnsignedByteRef _18;
  public final UnsignedByteRef _19;
  public final ByteRef _1a;
  public final UnsignedByteRef _1b;
  public final UnsignedByteRef _1c;
  public final UnsignedByteRef _1d;
  public final UnsignedShortRef _1e;
  public final Pointer<SoundStructFb0.Sub40> _20;
  public final UnsignedByteRef _24;

  public final IntRef _28;
  public final IntRef _2c;

  /** TODO ptr */
  public final IntRef _40;
  public final UnboundedArrayRef<IntRef> _44;

  public SoundStruct50(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
    this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
    this._02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);

    this._04 = ref.offset(1, 0x04).cast(ByteRef::new);
    this._05 = ref.offset(1, 0x05).cast(UnsignedByteRef::new);
    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
    this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
    this._08 = ref.offset(1, 0x08).cast(ByteRef::new);
    this._09 = ref.offset(1, 0x09).cast(ByteRef::new);
    this._0a = ref.offset(1, 0x0a).cast(ByteRef::new);
    this._0b = ref.offset(1, 0x0b).cast(ByteRef::new);
    this._0c = ref.offset(1, 0x0c).cast(ByteRef::new);
    this._0d = ref.offset(1, 0x0d).cast(UnsignedByteRef::new);
    this._0e = ref.offset(1, 0x0e).cast(ByteRef::new);
    this._0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this._10 = ref.offset(1, 0x10).cast(UnsignedByteRef::new);
    this._11 = ref.offset(1, 0x11).cast(UnsignedByteRef::new);
    this._12 = ref.offset(1, 0x12).cast(UnsignedByteRef::new);
    this._13 = ref.offset(1, 0x13).cast(UnsignedByteRef::new);
    this._14 = ref.offset(1, 0x14).cast(ByteRef::new);
    this._15 = ref.offset(1, 0x15).cast(ByteRef::new);
    this._16 = ref.offset(1, 0x16).cast(ByteRef::new);
    this._17 = ref.offset(1, 0x17).cast(UnsignedByteRef::new);
    this._18 = ref.offset(1, 0x18).cast(UnsignedByteRef::new);
    this._19 = ref.offset(1, 0x19).cast(UnsignedByteRef::new);
    this._1a = ref.offset(1, 0x1a).cast(ByteRef::new);
    this._1b = ref.offset(1, 0x1b).cast(UnsignedByteRef::new);
    this._1c = ref.offset(1, 0x1c).cast(UnsignedByteRef::new);
    this._1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);
    this._1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this._20 = ref.offset(4, 0x20).cast(Pointer.deferred(4, SoundStructFb0.Sub40::new));
    this._24 = ref.offset(1, 0x24).cast(UnsignedByteRef::new);

    this._28 = ref.offset(4, 0x28).cast(IntRef::new);
    this._2c = ref.offset(4, 0x2c).cast(IntRef::new);

    this._40 = ref.offset(4, 0x40).cast(IntRef::new);
    this._44 = ref.offset(4, 0x44).cast(UnboundedArrayRef.of(0x4, IntRef::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
