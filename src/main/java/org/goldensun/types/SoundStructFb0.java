package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.BiConsumerRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.TriConsumerRef;
import org.goldensun.memory.types.TriFunctionRef;
import org.goldensun.memory.types.UnboundedArrayRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class SoundStructFb0 implements MemoryRef {
  private final Value ref;

  /** Magic? "Smsh"/"MP2K" */
  public final IntRef _00;

  public final UnsignedByteRef _04;

  public final UnsignedByteRef _06;
  public final UnsignedByteRef _07;
  public final UnsignedByteRef _08;

  public final UnsignedByteRef _0b;

  public final IntRef _10;
  public final IntRef _14;
  public final IntRef _18;
  public final Pointer<UnboundedArrayRef<Sub40>> _1c;
  public final Pointer<ConsumerRef<SoundStruct>> _20;
  public final Pointer<SoundStruct> _24;
  public final Pointer<ConsumerRef<SoundStructFb0>> _28;
  public final Pointer<BiConsumerRef<Integer, Integer>> _2c;
  public final Pointer<TriFunctionRef<Integer, Integer, Integer, Integer>> _30;
  public final Pointer<UnboundedArrayRef<Pointer<BiConsumerRef<SoundStruct, SoundStruct50>>>> _34;
  public final Pointer<TriConsumerRef<Integer, SoundStruct, SoundStruct50>> _38;
  public final Pointer<RunnableRef> _3c;

  public final UnboundedArrayRef<Sub40> _50;

  public final Value _350;
  public final Value _980;

  public SoundStructFb0(final Value ref) {
    this.ref = ref;

    this._00 = ref.offset(4, 0x00).cast(IntRef::new);

    this._04 = ref.offset(1, 0x04).cast(UnsignedByteRef::new);

    this._06 = ref.offset(1, 0x06).cast(UnsignedByteRef::new);
    this._07 = ref.offset(1, 0x07).cast(UnsignedByteRef::new);
    this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);

    this._0b = ref.offset(1, 0x0b).cast(UnsignedByteRef::new);

    this._10 = ref.offset(4, 0x10).cast(IntRef::new);
    this._14 = ref.offset(4, 0x14).cast(IntRef::new);
    this._18 = ref.offset(4, 0x18).cast(IntRef::new);
    this._1c = ref.offset(4, 0x1c).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x40, Sub40::new)));
    this._20 = ref.offset(4, 0x20).cast(Pointer.deferred(4, ConsumerRef::new));
    this._24 = ref.offset(4, 0x24).cast(Pointer.deferred(4, SoundStruct::new));
    this._28 = ref.offset(4, 0x28).cast(Pointer.deferred(4, ConsumerRef::new));
    this._2c = ref.offset(4, 0x2c).cast(Pointer.deferred(4, BiConsumerRef::new));
    this._30 = ref.offset(4, 0x30).cast(Pointer.deferred(4, TriFunctionRef::new));
    this._34 = ref.offset(4, 0x34).cast(Pointer.deferred(4, UnboundedArrayRef.of(0x4, Pointer.deferred(4, BiConsumerRef::new))));
    this._38 = ref.offset(4, 0x38).cast(Pointer.deferred(4, TriConsumerRef::new));
    this._3c = ref.offset(4, 0x3c).cast(Pointer.deferred(4, RunnableRef::new));

    this._50 = ref.offset(4, 0x50).cast(UnboundedArrayRef.of(0x40, Sub40::new));

    this._350 = ref.offset(4, 0x350);
    this._980 = ref.offset(4, 0x980);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub40 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef _00;
    public final UnsignedByteRef _01;
    public final UnsignedByteRef _02;
    public final UnsignedByteRef _03;
    public final IntRef _04;
    public final UnsignedByteRef _08;

    public final UnsignedShortRef _0c;

    public final UnsignedByteRef _10;
    public final UnsignedByteRef _11;
    public final UnsignedByteRef _12;
    public final UnsignedByteRef _13;
    public final ByteRef _14;

    public final UnsignedByteRef _1d;
    public final UnsignedByteRef _1e;
    public final UnsignedByteRef _1f;
    public final IntRef _20;
    public final IntRef _24;

    public final Pointer<SoundStruct50> _2c;
    public final Pointer<Sub40> _30;
    public final Pointer<Sub40> _34;

    public Sub40(final Value ref) {
      this.ref = ref;

      this._00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
      this._02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
      this._03 = ref.offset(1, 0x03).cast(UnsignedByteRef::new);
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
      this._08 = ref.offset(1, 0x08).cast(UnsignedByteRef::new);

      this._0c = ref.offset(2, 0x0c).cast(UnsignedShortRef::new);

      this._10 = ref.offset(1, 0x10).cast(UnsignedByteRef::new);
      this._11 = ref.offset(1, 0x11).cast(UnsignedByteRef::new);
      this._12 = ref.offset(1, 0x12).cast(UnsignedByteRef::new);
      this._13 = ref.offset(1, 0x13).cast(UnsignedByteRef::new);
      this._14 = ref.offset(1, 0x14).cast(ByteRef::new);

      this._1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);
      this._1e = ref.offset(1, 0x1e).cast(UnsignedByteRef::new);
      this._1f = ref.offset(1, 0x1f).cast(UnsignedByteRef::new);
      this._20 = ref.offset(4, 0x20).cast(IntRef::new);
      this._24 = ref.offset(4, 0x24).cast(IntRef::new);

      this._2c = ref.offset(4, 0x2c).cast(Pointer.deferred(4, SoundStruct50::new));
      this._30 = ref.offset(4, 0x30).cast(Pointer.deferred(4, Sub40::new));
      this._34 = ref.offset(4, 0x34).cast(Pointer.deferred(4, Sub40::new));
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
