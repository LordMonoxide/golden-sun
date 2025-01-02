package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ConsumerRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Actor70 implements MemoryRef {
  private final Value ref;

  public final IntRef scriptPtr_00;
  public final ShortRef scriptPos_04;
  public final ShortRef angle_06;
  public final Vec3 pos_08;
  public final IntRef _14;
  public final IntRef scale_18;
  public final IntRef _1c;
  public final UnsignedShortRef radius_20;
  public final UnsignedByteRef layer_22;
  public final UnsignedByteRef flags_23;
  public final Vec3 velocity_24;
  public final IntRef velocityScalar_30;
  public final IntRef acceleration_34;
  public final Vec3 dest_38;
  public final IntRef _44;
  public final IntRef _48;
  public final IntRef _4c;
  /** TODO sometimes a pointer to 4 pointers to {@link Sprite38}, see {@link #spriteType_54} */
  public final Pointer<Sprite38> sprite_50;
  /**
   * <ul>
   *   <li>0 - none</li>
   *   <li>1 - regular sprite</li>
   *   <li>2 - multiple sprites</li>
   * </ul>
   */
  public final UnsignedByteRef spriteType_54;
  public final UnsignedByteRef _55;
  public final UnsignedByteRef _56;
  public final UnsignedByteRef _57;
  public final UnsignedByteRef _58;
  public final UnsignedByteRef _59;
  public final UnsignedByteRef _5a;
  public final UnsignedByteRef _5b;
  public final UnsignedByteRef _5c;
  public final UnsignedByteRef _5d;
  public final ShortRef _5e;
  public final UnsignedByteRef _60;
  public final UnsignedByteRef _61;
  public final UnsignedByteRef _62;
  public final UnsignedByteRef _63;
  public final ShortRef _64;
  public final ShortRef _66;
  public final Pointer<Actor70> _68;
  public final Pointer<ConsumerRef<Actor70>> _6c;

  public Actor70(final Value ref) {
    this.ref = ref;

    this.scriptPtr_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this.scriptPos_04 = ref.offset(2, 0x04).cast(ShortRef::new);
    this.angle_06 = ref.offset(2, 0x06).cast(ShortRef::new);
    this.pos_08 = ref.offset(4, 0x08).cast(Vec3::new);
    this._14 = ref.offset(4, 0x14).cast(IntRef::new);
    this.scale_18 = ref.offset(4, 0x18).cast(IntRef::new);
    this._1c = ref.offset(4, 0x1c).cast(IntRef::new);
    this.radius_20 = ref.offset(2, 0x20).cast(UnsignedShortRef::new);
    this.layer_22 = ref.offset(1, 0x22).cast(UnsignedByteRef::new);
    this.flags_23 = ref.offset(1, 0x23).cast(UnsignedByteRef::new);
    this.velocity_24 = ref.offset(4, 0x24).cast(Vec3::new);
    this.velocityScalar_30 = ref.offset(4, 0x30).cast(IntRef::new);
    this.acceleration_34 = ref.offset(4, 0x34).cast(IntRef::new);
    this.dest_38 = ref.offset(4, 0x38).cast(Vec3::new);
    this._44 = ref.offset(4, 0x44).cast(IntRef::new);
    this._48 = ref.offset(4, 0x48).cast(IntRef::new);
    this._4c = ref.offset(4, 0x4c).cast(IntRef::new);
    this.sprite_50 = ref.offset(4, 0x50).cast(Pointer.deferred(4, Sprite38::new));
    this.spriteType_54 = ref.offset(1, 0x54).cast(UnsignedByteRef::new);
    this._55 = ref.offset(1, 0x55).cast(UnsignedByteRef::new);
    this._56 = ref.offset(1, 0x56).cast(UnsignedByteRef::new);
    this._57 = ref.offset(1, 0x57).cast(UnsignedByteRef::new);
    this._58 = ref.offset(1, 0x58).cast(UnsignedByteRef::new);
    this._59 = ref.offset(1, 0x59).cast(UnsignedByteRef::new);
    this._5a = ref.offset(1, 0x5a).cast(UnsignedByteRef::new);
    this._5b = ref.offset(1, 0x5b).cast(UnsignedByteRef::new);
    this._5c = ref.offset(1, 0x5c).cast(UnsignedByteRef::new);
    this._5d = ref.offset(1, 0x5d).cast(UnsignedByteRef::new);
    this._5e = ref.offset(2, 0x5e).cast(ShortRef::new);
    this._60 = ref.offset(1, 0x60).cast(UnsignedByteRef::new);
    this._61 = ref.offset(1, 0x61).cast(UnsignedByteRef::new);
    this._62 = ref.offset(1, 0x62).cast(UnsignedByteRef::new);
    this._63 = ref.offset(1, 0x63).cast(UnsignedByteRef::new);
    this._64 = ref.offset(2, 0x64).cast(ShortRef::new);
    this._66 = ref.offset(2, 0x66).cast(ShortRef::new);
    this._68 = ref.offset(4, 0x68).cast(Pointer.deferred(4, Actor70::new));
    this._6c = ref.offset(4, 0x6c).cast(Pointer.deferred(4, ConsumerRef::new));
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
