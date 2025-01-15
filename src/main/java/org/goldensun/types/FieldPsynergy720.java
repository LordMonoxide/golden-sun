package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class FieldPsynergy720 implements MemoryRef {
  private final Value ref;

  public final IntRef angle_00;
  /** Set to target pos if target, otherwise caster pos */
  public final Vec3 pos_04;
  public final Pointer<Actor70> caster_10;
  public final Pointer<Actor70> target_14;

  public final ShortRef casterMapActorIndex_18;
  public final ShortRef targetMapActorIndex_1a;
  public final UnsignedShortRef abilityId_1c;
  public final UnsignedShortRef fieldPsynergyId_1e;
  public final ByteRef _20;
  public final UnsignedByteRef _21;
  public final UnsignedByteRef _22;
  public final UnsignedByteRef _23;
  public final Pointer<RunnableRef> _24;

  public final ByteRef _34;
  public final ByteRef _35;

  public final Pointer<ConsumerRef<Actor70>> _38;
  public final IntRef targetScriptPtr_3c;

  public final UnsignedByteRef _44;
  public final ByteRef _45;
  public final UnsignedShortRef vramSlot_46;

  public final ShortRef _4a;
  public final IntRef _4c;
  public final IntRef _50;
  public final IntRef _54;
  public final ArrayRef<Sub58> _58;

  public final ByteRef _71c;

  public FieldPsynergy720(final Value ref) {
    this.ref = ref;

    this.angle_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this.pos_04 = ref.offset(4, 0x04).cast(Vec3::new);
    this.caster_10 = ref.offset(4, 0x10).cast(Pointer.deferred(4, Actor70::new));
    this.target_14 = ref.offset(4, 0x14).cast(Pointer.deferred(4, Actor70::new));

    this.casterMapActorIndex_18 = ref.offset(2, 0x18).cast(ShortRef::new);
    this.targetMapActorIndex_1a = ref.offset(2, 0x1a).cast(ShortRef::new);
    this.abilityId_1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
    this.fieldPsynergyId_1e = ref.offset(2, 0x1e).cast(UnsignedShortRef::new);
    this._20 = ref.offset(1, 0x20).cast(ByteRef::new);
    this._21 = ref.offset(1, 0x21).cast(UnsignedByteRef::new);
    this._22 = ref.offset(1, 0x22).cast(UnsignedByteRef::new);
    this._23 = ref.offset(1, 0x23).cast(UnsignedByteRef::new);
    this._24 = ref.offset(4, 0x24).cast(Pointer.deferred(4, RunnableRef::new));

    this._34 = ref.offset(1, 0x34).cast(ByteRef::new);
    this._35 = ref.offset(1, 0x35).cast(ByteRef::new);

    this._38 = ref.offset(4, 0x38).cast(Pointer.deferred(4, ConsumerRef::new));
    this.targetScriptPtr_3c = ref.offset(4, 0x3c).cast(IntRef::new);

    this._44 = ref.offset(1, 0x44).cast(UnsignedByteRef::new);
    this._45 = ref.offset(1, 0x45).cast(ByteRef::new);
    this.vramSlot_46 = ref.offset(2, 0x46).cast(UnsignedShortRef::new);

    this._4a = ref.offset(2, 0x4a).cast(ShortRef::new);
    this._4c = ref.offset(4, 0x4c).cast(IntRef::new);
    this._50 = ref.offset(4, 0x50).cast(IntRef::new);
    this._54 = ref.offset(4, 0x54).cast(IntRef::new);
    this._58 = ref.offset(4, 0x58).cast(ArrayRef.of(Sub58.class, 24, 0x48, Sub58::new));

    this._71c = ref.offset(1, 0x71c).cast(ByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Sub58 implements MemoryRef {
    private final Value ref;

    public final Pointer<Sprite38> sprite_00;
    public final IntRef _04;
    public final IntRef _08;
    public final IntRef _0c;
    public final IntRef _10;
    public final IntRef _14;
    public final IntRef _18;
    public final IntRef _1c;
    public final IntRef _20;
    public final IntRef _24;
    public final IntRef _28;
    public final IntRef _2c;
    public final UnsignedShortRef _30;
    public final ShortRef _32;
    public final Pointer<ConsumerRef<Sub58>> _34;
    public final ShortRef _38;
    public final ShortRef _3a;

    public final ByteRef _40;
    public final ByteRef _41;
    public final ByteRef _42;
    public final ByteRef _43;
    public final ByteRef _44;
    public final ByteRef _45;
    public final ByteRef _46;
    public final UnsignedByteRef _47;

    public Sub58(final Value ref) {
      this.ref = ref;

      this.sprite_00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, Sprite38::new));
      this._04 = ref.offset(4, 0x04).cast(IntRef::new);
      this._08 = ref.offset(4, 0x08).cast(IntRef::new);
      this._0c = ref.offset(4, 0x0c).cast(IntRef::new);
      this._10 = ref.offset(4, 0x10).cast(IntRef::new);
      this._14 = ref.offset(4, 0x14).cast(IntRef::new);
      this._18 = ref.offset(4, 0x18).cast(IntRef::new);
      this._1c = ref.offset(4, 0x1c).cast(IntRef::new);
      this._20 = ref.offset(4, 0x20).cast(IntRef::new);
      this._24 = ref.offset(4, 0x24).cast(IntRef::new);
      this._28 = ref.offset(4, 0x28).cast(IntRef::new);
      this._2c = ref.offset(4, 0x2c).cast(IntRef::new);
      this._30 = ref.offset(2, 0x30).cast(UnsignedShortRef::new);
      this._32 = ref.offset(2, 0x32).cast(ShortRef::new);
      this._34 = ref.offset(4, 0x34).cast(Pointer.deferred(4, ConsumerRef::new));
      this._38 = ref.offset(2, 0x38).cast(ShortRef::new);
      this._3a = ref.offset(2, 0x3a).cast(ShortRef::new);

      this._40 = ref.offset(1, 0x40).cast(ByteRef::new);
      this._41 = ref.offset(1, 0x41).cast(ByteRef::new);
      this._42 = ref.offset(1, 0x42).cast(ByteRef::new);
      this._43 = ref.offset(1, 0x43).cast(ByteRef::new);
      this._44 = ref.offset(1, 0x44).cast(ByteRef::new);
      this._45 = ref.offset(1, 0x45).cast(ByteRef::new);
      this._46 = ref.offset(1, 0x46).cast(ByteRef::new);
      this._47 = ref.offset(1, 0x47).cast(UnsignedByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
