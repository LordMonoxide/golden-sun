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
  private final Value ref;

  public final ArrayRef<UnsignedByteRef> name_00;
  public final UnsignedByteRef level_0f;
  public final ShortRef baseMaxHp_10;
  public final ShortRef baseMaxPp_12;
  /** .14 */
  public final ShortRef fractionHp_14;
  /** .14 */
  public final ShortRef fractionMp_16;
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

  public final IntRef exp_124;
  public final UnsignedByteRef _128;
  public final UnsignedByteRef class_129;
  public final UnsignedByteRef _12a;

  public final ArrayRef<ByteRef> summonBoosts_12c;
  public final ByteRef curse_130;
  /** 1 for poison, 2 for venom; every increase adds 10% damage in battle */
  public final ByteRef affliction_131;

  public final ByteRef _133;

  public final ByteRef _135;

  public final ByteRef _137;

  public final UnsignedByteRef haunt_140;

  /** Unleash/crit rate */
  public final UnsignedByteRef crit_142;
  public final UnsignedByteRef reflux_143;
  /** Starts at 2, decrements every round */
  public final UnsignedByteRef kiteTurns_144;

  public final ByteRef _147;

  public Unit14c(final Value ref) {
    this.ref = ref;

    this.name_00 = ref.offset(1, 0x00).cast(ArrayRef.of(UnsignedByteRef.class, 15, 0x1, UnsignedByteRef::new));
    this.level_0f = ref.offset(1, 0x0f).cast(UnsignedByteRef::new);
    this.baseMaxHp_10 = ref.offset(2, 0x10).cast(ShortRef::new);
    this.baseMaxPp_12 = ref.offset(2, 0x12).cast(ShortRef::new);
    this.fractionHp_14 = ref.offset(2, 0x14).cast(ShortRef::new);
    this.fractionMp_16 = ref.offset(2, 0x16).cast(ShortRef::new);
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

    this.exp_124 = ref.offset(4, 0x124).cast(IntRef::new);
    this._128 = ref.offset(1, 0x128).cast(UnsignedByteRef::new);
    this.class_129 = ref.offset(1, 0x129).cast(UnsignedByteRef::new);
    this._12a = ref.offset(1, 0x12a).cast(UnsignedByteRef::new);

    this.summonBoosts_12c = ref.offset(1, 0x12c).cast(ArrayRef.of(ByteRef.class, 4, 0x1, ByteRef::new));
    this.curse_130 = ref.offset(1, 0x130).cast(ByteRef::new);
    this.affliction_131 = ref.offset(1, 0x131).cast(ByteRef::new);

    this._133 = ref.offset(1, 0x133).cast(ByteRef::new);

    this._135 = ref.offset(1, 0x135).cast(ByteRef::new);

    this._137 = ref.offset(1, 0x137).cast(ByteRef::new);

    this.haunt_140 = ref.offset(1, 0x140).cast(UnsignedByteRef::new);

    this.crit_142 = ref.offset(1, 0x142).cast(UnsignedByteRef::new);
    this.reflux_143 = ref.offset(1, 0x143).cast(UnsignedByteRef::new);
    this.kiteTurns_144 = ref.offset(1, 0x144).cast(UnsignedByteRef::new);

    this._147 = ref.offset(1, 0x147).cast(ByteRef::new);
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

    /** One of these is ready, one is not ready */
    public final ArrayRef<IntRef> djinn_00;
    /** One of these is ready, one is not ready */
    public final ArrayRef<IntRef> djinn_10;
    /** One of these is ready, one is not ready */
    public final ArrayRef<UnsignedByteRef> djinnCounts_20;
    /** One of these is ready, one is not ready */
    public final ArrayRef<UnsignedByteRef> djinnCounts_24;

    public Djinn28(final Value ref) {
      this.ref = ref;

      this.djinn_00 = ref.offset(2, 0xf8).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
      this.djinn_10 = ref.offset(4, 0x108).cast(ArrayRef.of(IntRef.class, 4, 0x4, IntRef::new));
      this.djinnCounts_20 = ref.offset(1, 0x118).cast(ArrayRef.of(UnsignedByteRef.class, 4, 0x1, UnsignedByteRef::new));
      this.djinnCounts_24 = ref.offset(1, 0x11c).cast(ArrayRef.of(UnsignedByteRef.class, 4, 0x1, UnsignedByteRef::new));
    }

    @Override
    public int getAddress() {
      return this.ref.getAddress();
    }
  }
}
