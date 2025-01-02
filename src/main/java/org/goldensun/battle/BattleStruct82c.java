package org.goldensun.battle;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.SpriteLayer18;

public class BattleStruct82c implements MemoryRef {
  private final Value ref;

  public final IntRef entranceId_00;
  public final ArrayRef<ShortRef> _04;
  public final ArrayRef<UnsignedShortRef> _10;
  public final ArrayRef<IntRef> _1c;
  public final ArrayRef<ByteRef> _34;

  public final ShortRef _3c;
  public final ShortRef _3e;
  public final UnsignedByteRef _40;
  public final UnsignedByteRef _41;
  public final UnsignedByteRef _42;

  public final UnsignedByteRef _44;
  public final UnsignedByteRef _45;

  public final UnsignedByteRef _50;
  public final UnsignedByteRef _51;
  public final UnsignedByteRef _52;

  public final IntRef vramSlot_54;
  public final ArrayRef<UnsignedShortRef> charIds_58;
  public final ArrayRef<UnsignedShortRef> monsterIds_66;
  public final ArrayRef<Combatant2c> combatants_74;
  public final ArrayRef<UnsignedByteRef> combatantCharIds_2dc;
  public final ArrayRef<Turn10> turns_2ec;

  public final IntRef _538;

  public final UnsignedShortRef backgroundPointerTableId_648;

  public final UnsignedShortRef _64e;
  public final UnsignedShortRef _650;

  public BattleStruct82c(final Value ref) {
    this.ref = ref;

    this.entranceId_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this._04 = ref.offset(2, 0x04).cast(ArrayRef.of(ShortRef.class, 6, 0x2, ShortRef::new));
    this._10 = ref.offset(2, 0x10).cast(ArrayRef.of(UnsignedShortRef.class, 6, 0x2, UnsignedShortRef::new));
    this._1c = ref.offset(4, 0x1c).cast(ArrayRef.of(IntRef.class, 6, 0x4, IntRef::new));
    this._34 = ref.offset(1, 0x34).cast(ArrayRef.of(ByteRef.class, 6, 0x1, ByteRef::new));

    this._3c = ref.offset(2, 0x3c).cast(ShortRef::new);
    this._3e = ref.offset(2, 0x3e).cast(ShortRef::new);
    this._40 = ref.offset(1, 0x40).cast(UnsignedByteRef::new);
    this._41 = ref.offset(1, 0x41).cast(UnsignedByteRef::new);
    this._42 = ref.offset(1, 0x42).cast(UnsignedByteRef::new);

    this._44 = ref.offset(1, 0x44).cast(UnsignedByteRef::new);
    this._45 = ref.offset(1, 0x45).cast(UnsignedByteRef::new);

    this._50 = ref.offset(1, 0x50).cast(UnsignedByteRef::new);
    this._51 = ref.offset(1, 0x51).cast(UnsignedByteRef::new);
    this._52 = ref.offset(1, 0x52).cast(UnsignedByteRef::new);

    this.vramSlot_54 = ref.offset(4, 0x54).cast(IntRef::new);
    this.charIds_58 = ref.offset(2, 0x58).cast(ArrayRef.of(UnsignedShortRef.class, 7, 0x2, UnsignedShortRef::new));
    this.monsterIds_66 = ref.offset(2, 0x66).cast(ArrayRef.of(UnsignedShortRef.class, 7, 0x2, UnsignedShortRef::new));
    this.combatants_74 = ref.offset(4, 0x74).cast(ArrayRef.of(Combatant2c.class, 14, 0x2c, Combatant2c::new));
    this.combatantCharIds_2dc = ref.offset(1, 0x2dc).cast(ArrayRef.of(UnsignedByteRef.class, 16, 0x1, UnsignedByteRef::new));
    this.turns_2ec = ref.offset(4, 0x2ec).cast(ArrayRef.of(Turn10.class, 20, 0x10, Turn10::new));

    this._538 = ref.offset(4, 0x538).cast(IntRef::new);

    this.backgroundPointerTableId_648 = ref.offset(2, 0x648).cast(UnsignedShortRef::new);

    this._64e = ref.offset(2, 0x64e).cast(UnsignedShortRef::new);
    this._650 = ref.offset(2, 0x650).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class Combatant2c implements MemoryRef {
    private final Value ref;

    public final Pointer<Actor70> actor_00;
    public final UnsignedShortRef spriteDataIndex_04;
    public final UnsignedShortRef spriteDataIndex_06;
    public final UnsignedShortRef spriteDataIndex_08;
    public final UnsignedShortRef spriteDataIndex_0a;
    public final IntRef x_0c;
    public final IntRef z_10;
    public final IntRef _14;
    public final IntRef scale_18;
    public final UnsignedShortRef flags_1c;
    public final UnsignedByteRef _1e;
    public final ByteRef _1f;
    public final Pointer<SpriteLayer18> spriteLayer_20;
    public final Pointer<SpriteLayer18> spriteLayer_24;
    public final ShortRef _28;
    public final ShortRef _2a;

    public Combatant2c(final Value ref) {
      this.ref = ref;

      this.actor_00 = ref.offset(4, 0x00).cast(Pointer.deferred(4, Actor70::new));
      this.spriteDataIndex_04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
      this.spriteDataIndex_06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
      this.spriteDataIndex_08 = ref.offset(2, 0x08).cast(UnsignedShortRef::new);
      this.spriteDataIndex_0a = ref.offset(2, 0x0a).cast(UnsignedShortRef::new);
      this.x_0c = ref.offset(4, 0x0c).cast(IntRef::new);
      this.z_10 = ref.offset(4, 0x10).cast(IntRef::new);
      this._14 = ref.offset(4, 0x14).cast(IntRef::new);
      this.scale_18 = ref.offset(4, 0x18).cast(IntRef::new);
      this.flags_1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
      this._1e = ref.offset(1, 0x1e).cast(UnsignedByteRef::new);
      this._1f = ref.offset(1, 0x1f).cast(ByteRef::new);
      this.spriteLayer_20 = ref.offset(4, 0x20).cast(Pointer.deferred(4, SpriteLayer18::new));
      this.spriteLayer_24 = ref.offset(4, 0x24).cast(Pointer.deferred(4, SpriteLayer18::new));
      this._28 = ref.offset(2, 0x28).cast(ShortRef::new);
      this._2a = ref.offset(2, 0x2a).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Turn10 implements MemoryRef {
    private final Value ref;

    public final ShortRef unitId_00;

    public final UnsignedShortRef agility_04;
    public final ShortRef _06;
    public final ShortRef _08;
    public final ShortRef _0a;

    public Turn10(final Value ref) {
      this.ref = ref;

      this.unitId_00 = ref.offset(2, 0x00).cast(ShortRef::new);

      this.agility_04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
      this._06 = ref.offset(2, 0x06).cast(ShortRef::new);
      this._08 = ref.offset(2, 0x08).cast(ShortRef::new);
      this._0a = ref.offset(2, 0x0a).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
