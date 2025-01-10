package org.goldensun.battle;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class EnemyStats54 implements MemoryRef {
  private final Value ref;

  public final UnsignedByteRef level_0f;
  public final UnsignedShortRef hp_10;
  public final UnsignedShortRef pp_12;
  public final UnsignedShortRef attack_14;
  public final UnsignedShortRef defense_16;
  public final UnsignedShortRef agility_18;
  public final UnsignedByteRef luck_1a;
  public final UnsignedByteRef turns_1b;
  public final UnsignedByteRef regenHp_1c;
  public final UnsignedByteRef regenPp_1d;

  public final IntRef _20;

  public final ArrayRef<UnsignedShortRef> itemIds_28;
  public final ArrayRef<UnsignedByteRef> itemCounts_30;
  public final UnsignedByteRef elementalStatsIndex_34;
  public final UnsignedByteRef iq_35;
  public final UnsignedByteRef attackPattern_36;
  public final UnsignedByteRef _37;
  public final ArrayRef<UnsignedShortRef> attacks_38;
  public final ArrayRef<UnsignedByteRef> weaknesses_48;

  public final UnsignedShortRef coins_4c;
  public final ShortRef item_4e;
  public final ShortRef itemChance_50;
  public final UnsignedShortRef exp_52;

  public EnemyStats54(final Value ref) {
    this.ref = ref;

    this.level_0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this.hp_10 = ref.offset(2, 0x10).cast(UnsignedShortRef::new);
    this.pp_12 = ref.offset(2, 0x12).cast(UnsignedShortRef::new);
    this.attack_14 = ref.offset(2, 0x14).cast(UnsignedShortRef::new);
    this.defense_16 = ref.offset(2, 0x16).cast(UnsignedShortRef::new);
    this.agility_18 = ref.offset(2, 0x18).cast(UnsignedShortRef::new);
    this.luck_1a = ref.offset(1, 0x1a).cast(UnsignedByteRef::new);
    this.turns_1b = ref.offset(1, 0x1b).cast(UnsignedByteRef::new);
    this.regenHp_1c = ref.offset(1, 0x1c).cast(UnsignedByteRef::new);
    this.regenPp_1d = ref.offset(1, 0x1d).cast(UnsignedByteRef::new);

    this._20 = ref.offset(4, 0x20).cast(IntRef::new);

    this.itemIds_28 = ref.offset(2, 0x28).cast(ArrayRef.of(UnsignedShortRef.class, 4, 0x2, UnsignedShortRef::new));
    this.itemCounts_30 = ref.offset(1, 0x30).cast(ArrayRef.of(UnsignedByteRef.class, 4, 0x1, UnsignedByteRef::new));
    this.elementalStatsIndex_34 = ref.offset(1, 0x34).cast(UnsignedByteRef::new);
    this.iq_35 = ref.offset(1, 0x35).cast(UnsignedByteRef::new);
    this.attackPattern_36 = ref.offset(1, 0x36).cast(UnsignedByteRef::new);
    this._37 = ref.offset(1, 0x37).cast(UnsignedByteRef::new);
    this.attacks_38 = ref.offset(2, 0x38).cast(ArrayRef.of(UnsignedShortRef.class, 8, 0x2, UnsignedShortRef::new));
    this.weaknesses_48 = ref.offset(1, 0x48).cast(ArrayRef.of(UnsignedByteRef.class, 3, 0x1, UnsignedByteRef::new));

    this.coins_4c = ref.offset(2, 0x4c).cast(UnsignedShortRef::new);
    this.item_4e = ref.offset(2, 0x4e).cast(ShortRef::new);
    this.itemChance_50 = ref.offset(2, 0x50).cast(ShortRef::new);
    this.exp_52 = ref.offset(2, 0x52).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }
}
