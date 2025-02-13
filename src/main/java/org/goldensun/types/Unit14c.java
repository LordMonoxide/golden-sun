package org.goldensun.types;

import org.goldensun.memory.Value;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.ByteRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.MemoryRef;
import org.goldensun.memory.types.ShortRef;
import org.goldensun.memory.types.UnsignedByteRef;
import org.goldensun.memory.types.UnsignedShortRef;

public class Unit14c implements MemoryRef {
  public static final int REMOVED_FROM_FIELD = 0xfe;

  private final Value ref;

  public final ArrayRef<UnsignedByteRef> name_00;
  public final UnsignedByteRef level_0f;
  public final ShortRef baseMaxHp_10;
  public final ShortRef baseMaxPp_12;
  /** .14 */
  public final ShortRef fractionHp_14;
  /** .14 */
  public final ShortRef fractionPp_16;
  public final UnsignedShortRef baseAttack_18;
  public final UnsignedShortRef baseDefence_1a;
  public final UnsignedShortRef baseAgility_1c;
  public final UnsignedByteRef baseLuck_1e;
  public final UnsignedByteRef baseTurns_1f;
  public final UnsignedByteRef baseRecoveryHp_20;
  public final UnsignedByteRef baseRecoveryPp_21;

  public final ArrayRef<PowerResist04> powerResist_24;
  public final ShortRef maxHp_34;
  public final ShortRef maxPp_36;
  public final ShortRef hp_38;
  public final ShortRef pp_3a;
  public final UnsignedShortRef attack_3c;
  public final UnsignedShortRef defence_3e;
  public final UnsignedShortRef agility_40;
  public final UnsignedByteRef luck_42;
  public final UnsignedByteRef turns_43;
  public final UnsignedByteRef recoveryHp_44;
  public final UnsignedByteRef recoveryPp_45;

  public final ArrayRef<PowerResist04> elementalPowerResist_48;
  public final ArrayRef<IntRef> psynergy_58;
  /**
   * Item IDs + flags
   * <ul>
   *   <li>0x200 - ?</li>
   *   <li>0x400 - broken</li>
   * </ul>
   */
  public final ArrayRef<UnsignedShortRef> items_d8;
  public final Djinn28 djinn_f8;
  public final IntRef _120;
  public final IntRef exp_124;
  public final UnsignedByteRef id_128;
  public final UnsignedByteRef class_129;
  public final UnsignedByteRef _12a;
  public final ByteRef _12b;
  public final ArrayRef<ByteRef> summonBoosts_12c;
  public final ByteRef curse_130;
  /** 1 for poison, 2 for venom; every increase adds 10% damage in battle */
  public final ByteRef affliction_131;
  public final UnsignedByteRef _132;
  public final ByteRef _133;
  public final UnsignedByteRef _134;
  public final ByteRef _135;
  public final UnsignedByteRef _136;
  public final ByteRef _137;
  public final UnsignedByteRef _138;
  public final UnsignedByteRef _139;
  public final UnsignedByteRef _13a;
  public final UnsignedByteRef _13b;
  public final UnsignedByteRef _13c;
  public final UnsignedByteRef _13d;
  public final UnsignedByteRef _13e;
  public final UnsignedByteRef _13f;
  public final UnsignedByteRef haunt_140;
  public final UnsignedByteRef _141;
  /** Unleash/crit rate */
  public final UnsignedByteRef crit_142;
  public final UnsignedByteRef reflux_143;
  /** Starts at 2, decrements every round */
  public final UnsignedByteRef kiteTurns_144;
  public final UnsignedByteRef _145;
  public final UnsignedByteRef _146;
  public final ByteRef _147;
  public final UnsignedByteRef _148;

  public Unit14c(final Value ref) {
    this.ref = ref;

    this.name_00 = ref.offset(1, 0x00).cast(ArrayRef.of(UnsignedByteRef.class, 15, 0x1, UnsignedByteRef::new));
    this.level_0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this.baseMaxHp_10 = ref.offset(2, 0x10).cast(ShortRef::new);
    this.baseMaxPp_12 = ref.offset(2, 0x12).cast(ShortRef::new);
    this.fractionHp_14 = ref.offset(2, 0x14).cast(ShortRef::new);
    this.fractionPp_16 = ref.offset(2, 0x16).cast(ShortRef::new);
    this.baseAttack_18 = ref.offset(2, 0x18).cast(UnsignedShortRef::new);
    this.baseDefence_1a = ref.offset(2, 0x1a).cast(UnsignedShortRef::new);
    this.baseAgility_1c = ref.offset(2, 0x1c).cast(UnsignedShortRef::new);
    this.baseLuck_1e = ref.offset(1, 0x1e).cast(UnsignedByteRef::new);
    this.baseTurns_1f = ref.offset(1, 0x1f).cast(UnsignedByteRef::new);
    this.baseRecoveryHp_20 = ref.offset(1, 0x20).cast(UnsignedByteRef::new);
    this.baseRecoveryPp_21 = ref.offset(1, 0x21).cast(UnsignedByteRef::new);

    this.powerResist_24 = ref.offset(2, 0x24).cast(ArrayRef.of(PowerResist04.class, 4, 0x4, PowerResist04::new));
    this.maxHp_34 = ref.offset(2, 0x34).cast(ShortRef::new);
    this.maxPp_36 = ref.offset(2, 0x36).cast(ShortRef::new);
    this.hp_38 = ref.offset(2, 0x38).cast(ShortRef::new);
    this.pp_3a = ref.offset(2, 0x3a).cast(ShortRef::new);
    this.attack_3c = ref.offset(2, 0x3c).cast(UnsignedShortRef::new);
    this.defence_3e = ref.offset(2, 0x3e).cast(UnsignedShortRef::new);
    this.agility_40 = ref.offset(2, 0x40).cast(UnsignedShortRef::new);
    this.luck_42 = ref.offset(1, 0x42).cast(UnsignedByteRef::new);
    this.turns_43 = ref.offset(1, 0x43).cast(UnsignedByteRef::new);
    this.recoveryHp_44 = ref.offset(1, 0x44).cast(UnsignedByteRef::new);
    this.recoveryPp_45 = ref.offset(1, 0x45).cast(UnsignedByteRef::new);

    this.elementalPowerResist_48 = ref.offset(2, 0x48).cast(ArrayRef.of(PowerResist04.class, 4, 0x4, PowerResist04::new));
    this.psynergy_58 = ref.offset(2, 0x58).cast(ArrayRef.of(IntRef.class, 32, 0x4, IntRef::new));
    this.items_d8 = ref.offset(2, 0xd8).cast(ArrayRef.of(UnsignedShortRef.class, 15, 0x2, UnsignedShortRef::new));
    this.djinn_f8 = ref.offset(4, 0xf8).cast(Djinn28::new);
    this._120 = ref.offset(4, 0x120).cast(IntRef::new);
    this.exp_124 = ref.offset(4, 0x124).cast(IntRef::new);
    this.id_128 = ref.offset(1, 0x128).cast(UnsignedByteRef::new);
    this.class_129 = ref.offset(1, 0x129).cast(UnsignedByteRef::new);
    this._12a = ref.offset(1, 0x12a).cast(UnsignedByteRef::new);
    this._12b = ref.offset(1, 0x12b).cast(ByteRef::new);
    this.summonBoosts_12c = ref.offset(1, 0x12c).cast(ArrayRef.of(ByteRef.class, 4, 0x1, ByteRef::new));
    this.curse_130 = ref.offset(1, 0x130).cast(ByteRef::new);
    this.affliction_131 = ref.offset(1, 0x131).cast(ByteRef::new);
    this._132 = ref.offset(1, 0x132).cast(UnsignedByteRef::new);
    this._133 = ref.offset(1, 0x133).cast(ByteRef::new);
    this._134 = ref.offset(1, 0x134).cast(UnsignedByteRef::new);
    this._135 = ref.offset(1, 0x135).cast(ByteRef::new);
    this._136 = ref.offset(1, 0x136).cast(UnsignedByteRef::new);
    this._137 = ref.offset(1, 0x137).cast(ByteRef::new);
    this._138 = ref.offset(1, 0x138).cast(UnsignedByteRef::new);
    this._139 = ref.offset(1, 0x139).cast(UnsignedByteRef::new);
    this._13a = ref.offset(1, 0x13a).cast(UnsignedByteRef::new);
    this._13b = ref.offset(1, 0x13b).cast(UnsignedByteRef::new);
    this._13c = ref.offset(1, 0x13c).cast(UnsignedByteRef::new);
    this._13d = ref.offset(1, 0x13d).cast(UnsignedByteRef::new);
    this._13e = ref.offset(1, 0x13e).cast(UnsignedByteRef::new);
    this._13f = ref.offset(1, 0x13f).cast(UnsignedByteRef::new);
    this.haunt_140 = ref.offset(1, 0x140).cast(UnsignedByteRef::new);
    this._141 = ref.offset(1, 0x141).cast(UnsignedByteRef::new);
    this.crit_142 = ref.offset(1, 0x142).cast(UnsignedByteRef::new);
    this.reflux_143 = ref.offset(1, 0x143).cast(UnsignedByteRef::new);
    this.kiteTurns_144 = ref.offset(1, 0x144).cast(UnsignedByteRef::new);
    this._145 = ref.offset(1, 0x145).cast(UnsignedByteRef::new);
    this._146 = ref.offset(1, 0x146).cast(UnsignedByteRef::new);
    this._147 = ref.offset(1, 0x147).cast(ByteRef::new);
    this._148 = ref.offset(1, 0x148).cast(UnsignedByteRef::new);
  }

  @Override
  public int getAddress() {
    return this.ref.getAddress();
  }

  public static class PowerResist04 implements MemoryRef {
    private final Value ref;

    public final ShortRef power_00;
    public final ShortRef resist_02;

    public PowerResist04(final Value ref) {
      this.ref = ref;

      this.power_00 = ref.offset(2, 0x00).cast(ShortRef::new);
      this.resist_02 = ref.offset(2, 0x02).cast(ShortRef::new);
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }

  public static class Djinn28 implements MemoryRef {
    private final Value ref;

    public final ArrayRef<IntRef> standby_00;
    public final ArrayRef<IntRef> set_10;
    public final ArrayRef<UnsignedByteRef> standbyCounts_20;
    public final ArrayRef<UnsignedByteRef> setCounts_24;

    public Djinn28(final Value ref) {
      this.ref = ref;

      this.standby_00 = ref.offset(2, 0x00).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
      this.set_10 = ref.offset(4, 0x10).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
      this.standbyCounts_20 = ref.offset(1, 0x20).cast(ArrayRef.of(UnsignedByteRef.class, 4, 0x1, UnsignedByteRef::new));
      this.setCounts_24 = ref.offset(1, 0x24).cast(ArrayRef.of(UnsignedByteRef.class, 4, 0x1, UnsignedByteRef::new));
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
