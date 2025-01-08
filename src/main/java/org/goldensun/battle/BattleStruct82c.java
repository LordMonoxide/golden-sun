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
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.SpriteLayer18;

public class BattleStruct82c implements MemoryRef {
  private final Value ref;

  public final IntRef entranceId_00;
  public final ArrayRef<ShortRef> unitIds_04;
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

  public final IntRef _530;
  public final IntRef _534;
  public final IntRef _538;
  public final ArrayRef<UnsignedShortRef> _53c;
  public final ArrayRef<UnsignedShortRef> _544;
  public final IntRef _644;
  public final UnsignedShortRef backgroundPointerTableId_648;

  public final UnsignedShortRef _64e;
  public final UnsignedShortRef _650;

  public final Sub64 _654;
  public final ArrayRef<UnsignedByteRef> _6b8;
  public final ArrayRef<IntRef> unitIds_6f8;
  public final IntRef _7f8;
  public final IntRef _7fc;
  public final IntRef _800;
  public final IntRef _804;
  public final IntRef _808;
  public final RenderPacket0c _80c;
  public final IntRef vramSlot_818;
  public final IntRef unitId_81c;
  public final IntRef _820;
  public final IntRef _824;

  public BattleStruct82c(final Value ref) {
    this.ref = ref;

    this.entranceId_00 = ref.offset(4, 0x00).cast(IntRef::new);
    this.unitIds_04 = ref.offset(2, 0x04).cast(ArrayRef.of(ShortRef.class, 6, 0x2, ShortRef::new));
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

    this._530 = ref.offset(4, 0x530).cast(IntRef::new);
    this._534 = ref.offset(4, 0x534).cast(IntRef::new);
    this._538 = ref.offset(4, 0x538).cast(IntRef::new);
    this._53c = ref.offset(2, 0x53c).cast(ArrayRef.of(UnsignedShortRef.class, 4, 0x2, UnsignedShortRef::new));
    this._544 = ref.offset(4, 0x544).cast(ArrayRef.of(UnsignedShortRef.class, 0x80, 0x2, UnsignedShortRef::new));
    this._644 = ref.offset(4, 0x644).cast(IntRef::new);
    this.backgroundPointerTableId_648 = ref.offset(2, 0x648).cast(UnsignedShortRef::new);

    this._64e = ref.offset(2, 0x64e).cast(UnsignedShortRef::new);
    this._650 = ref.offset(2, 0x650).cast(UnsignedShortRef::new);

    this._654 = ref.offset(4, 0x654).cast(Sub64::new);
    this._6b8 = ref.offset(1, 0x6b8).cast(ArrayRef.of(UnsignedByteRef.class, 64, 0x1, UnsignedByteRef::new));
    this.unitIds_6f8 = ref.offset(4, 0x6f8).cast(ArrayRef.of(IntRef.class, 64, 0x4, IntRef::new));
    this._7f8 = ref.offset(4, 0x7f8).cast(IntRef::new);
    this._7fc = ref.offset(4, 0x7fc).cast(IntRef::new);
    this._800 = ref.offset(4, 0x800).cast(IntRef::new);
    this._804 = ref.offset(4, 0x804).cast(IntRef::new);
    this._808 = ref.offset(4, 0x808).cast(IntRef::new);
    this._80c = ref.offset(4, 0x80c).cast(RenderPacket0c::new);
    this.vramSlot_818 = ref.offset(4, 0x818).cast(IntRef::new);
    this.unitId_81c = ref.offset(4, 0x81c).cast(IntRef::new);
    this._820 = ref.offset(4, 0x820).cast(IntRef::new);
    this._824 = ref.offset(4, 0x824).cast(IntRef::new);
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
    public final ShortRef _0c;

    public Turn10(final Value ref) {
      this.ref = ref;

      this.unitId_00 = ref.offset(2, 0x00).cast(ShortRef::new);

      this.agility_04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
      this._06 = ref.offset(2, 0x06).cast(ShortRef::new);
      this._08 = ref.offset(2, 0x08).cast(ShortRef::new);
      this._0a = ref.offset(2, 0x0a).cast(ShortRef::new);
      this._0c = ref.offset(2, 0x0c).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Sub64 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef unitId_00;
    public final UnsignedByteRef _01;
    public final ArrayRef<UnsignedByteRef> _02;
    public final ArrayRef<UnsignedByteRef> _10;
    public final ArrayRef<ByteRef> _1e;
    public final ArrayRef<ByteRef> _2c;
    public final ArrayRef<ByteRef> _3a;

    public final ShortRef _48;

    public final IntRef _4c;
    public final IntRef _50;
    public final IntRef _54;
    public final IntRef _58;
    public final IntRef _5c;
    public final IntRef _60;

    public Sub64(final Value ref) {
      this.ref = ref;

      this.unitId_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this._01 = ref.offset(1, 0x01).cast(UnsignedByteRef::new);
      this._02 = ref.offset(1, 0x02).cast(ArrayRef.of(UnsignedByteRef.class, 14, 0x1, UnsignedByteRef::new));
      this._10 = ref.offset(1, 0x10).cast(ArrayRef.of(UnsignedByteRef.class, 14, 0x1, UnsignedByteRef::new));
      this._1e = ref.offset(1, 0x1e).cast(ArrayRef.of(ByteRef.class, 14, 0x1, ByteRef::new));
      this._2c = ref.offset(1, 0x2c).cast(ArrayRef.of(ByteRef.class, 14, 0x1, ByteRef::new));
      this._3a = ref.offset(1, 0x3a).cast(ArrayRef.of(ByteRef.class, 14, 0x1, ByteRef::new));

      this._48 = ref.offset(2, 0x48).cast(ShortRef::new);

      this._4c = ref.offset(4, 0x4c).cast(IntRef::new);
      this._50 = ref.offset(4, 0x50).cast(IntRef::new);
      this._54 = ref.offset(4, 0x54).cast(IntRef::new);
      this._58 = ref.offset(4, 0x58).cast(IntRef::new);
      this._5c = ref.offset(4, 0x5c).cast(IntRef::new);
      this._60 = ref.offset(4, 0x60).cast(IntRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
