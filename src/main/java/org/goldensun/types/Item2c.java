package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Item2c implements MemoryRef {
  public static final int TYPE_ITEM_0 = 0;
  public static final int TYPE_WEAPON_1 = 1;
  public static final int TYPE_ARMOUR_2 = 2;
  public static final int TYPE_SHIELD_GLOVES_3 = 3;
  public static final int TYPE_HELMET_4 = 4;
  public static final int TYPE_LEGS_5 = 5;
  /** Equips that grant you psynergy */
  public static final int TYPE_GRANT_6 = 6;
  public static final int TYPE_LUCKY_CHARM_7 = 7;
  public static final int TYPE_RING_8 = 8;
  /** Not used */
  public static final int TYPE_SHIRT_9 = 9;
  /** Not used in GS1 */
  public static final int TYPE_CLASS_10 = 10;
  /** Not used */
  public static final int TYPE_UNUSED_11 = 11;

  public static final int FLAG_CURSED_01 = 0x1;
  public static final int FLAG_CANT_REMOVE_02 = 0x2;
  public static final int FLAG_RARE_04 = 0x4;
  public static final int FLAG_IMPORTANT_08 = 0x8;
  public static final int FLAG_STACKABLE_10 = 0x10;
  /** Can't transfer to GS2 */
  public static final int FLAG_CANT_TRANSFER_20 = 0x20;

  private final Value ref;

  public final UnsignedShortRef price_00;
  public final UnsignedByteRef type_02;
  public final UnsignedByteRef flags_03;
  public final UnsignedShortRef equippable_04;
  public final UnsignedShortRef icon_06;
  public final ShortRef attack_08;
  public final ByteRef defence_0a;
  public final ByteRef unleashRate_0b;
  public final UnsignedByteRef useType_0c;

  public final ArrayRef<EquipEffect04> equipEffect_18;

  public final UnsignedShortRef useAbility_28;

  public Item2c(final Value ref) {
    this.ref = ref;

    this.price_00 = ref.offset(2, 0x00).cast(UnsignedShortRef::new);
    this.type_02 = ref.offset(1, 0x02).cast(UnsignedByteRef::new);
    this.flags_03 = ref.offset(1, 0x03).cast(UnsignedByteRef::new);
    this.equippable_04 = ref.offset(2, 0x04).cast(UnsignedShortRef::new);
    this.icon_06 = ref.offset(2, 0x06).cast(UnsignedShortRef::new);
    this.attack_08 = ref.offset(2, 0x08).cast(ShortRef::new);
    this.defence_0a = ref.offset(1, 0x0a).cast(ByteRef::new);
    this.unleashRate_0b = ref.offset(1, 0x0b).cast(ByteRef::new);
    this.useType_0c = ref.offset(1, 0x0c).cast(UnsignedByteRef::new);

    this.equipEffect_18 = ref.offset(4, 0x18).cast(ArrayRef.of(EquipEffect04.class, 4, 0x4, EquipEffect04::new));

    this.useAbility_28 = ref.offset(2, 0x28).cast(UnsignedShortRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class EquipEffect04 implements MemoryRef {
    private final Value ref;

    public final UnsignedByteRef effect_00;
    public final ByteRef value_01;

    public EquipEffect04(final Value ref) {
      this.ref = ref;

      this.effect_00 = ref.offset(1, 0x00).cast(UnsignedByteRef::new);
      this.value_01 = ref.offset(1, 0x01).cast(ByteRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
