package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.types.Item2c;
import org.goldensun.types.RecoveryQueue10c;
import org.goldensun.types.Unit14c;

import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSunVars._2000500;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSunVars.djinnRecoveryQueue_200024c;
import static org.goldensun.GoldenSunVars.items_807b6a8;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars.lastSaveSlot_2002004;
import static org.goldensun.GoldenSunVars.runButton_200045c;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars.framesSinceInput_3001d24;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_801.FUN_8015020;
import static org.goldensun.GoldenSun_801.FUN_8015028;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.MathHelper.clamp;
import static org.goldensun.input.Input.BUTTON_B;

public final class GoldenSun_807 {
  private GoldenSun_807() { }

  /** {@link GoldenSun_807#getDjinnRecoveryQueue} */
  @Method(0x8077000)
  public static RecoveryQueue10c getDjinnRecoveryQueue_(final int inPvp) {
    return (RecoveryQueue10c)MEMORY.call(0x8077330, inPvp);
  }

  /** {@link GoldenSun_807#getCharOrMonsterData} */
  @Method(0x8077008)
  public static Unit14c getCharOrMonsterData_(final int id) {
    return (Unit14c)MEMORY.call(0x8077394, id);
  }

  /** {@link GoldenSun_807#recalcStats} */
  @Method(0x8077010)
  public static void recalcStats_(final int charId) {
    MEMORY.call(0x8077428, charId);
  }

  /** {@link GoldenSun_807#getItem} */
  @Method(0x8077018)
  public static Item2c getItem_(final int itemId) {
    return (Item2c)MEMORY.call(0x8078414, itemId);
  }

  /**
   * {@link GoldenSun_807#addItem}
   * @return item slot
   */
  @Method(0x8077028)
  public static int addItem_(final int charId, final int itemId) {
    return (int)MEMORY.call(0x8078588, charId, itemId);
  }

  /** {@link GoldenSun_807#giveItem} */
  @Method(0x8077030)
  public static int giveItem_(final int itemId) {
    return (int)MEMORY.call(0x8078618, itemId);
  }

  /** {@link GoldenSun_807#equipItem} */
  @Method(0x8077050)
  public static int equipItem_(final int charId, final int itemSlot) {
    return (int)MEMORY.call(0x8078708, charId, itemSlot);
  }

  /** {@link GoldenSun_807#takeItem} */
  @Method(0x8077058)
  public static int takeItem_(final int charId, final int itemSlot) {
    return (int)MEMORY.call(0x80788c4, charId, itemSlot);
  }

  /** {@link GoldenSun_807#breakItem} */
  @Method(0x8077060)
  public static int breakItem_(final int charId, final int itemSlot) {
    return (int)MEMORY.call(0x8078a34, charId, itemSlot);
  }

  /** {@link GoldenSun_807#FUN_8078870} */
  @Method(0x8077078)
  public static int FUN_8077078(final Unit14c unit, final int itemType) {
    return (int)MEMORY.call(0x8078870, unit, itemType);
  }

  /** {@link GoldenSun_807#getAbility} */
  @Method(0x8077080)
  public static int getAbility_(final int r0) {
    return (int)MEMORY.call(0x8078b9c, r0);
  }

  /** {@link GoldenSun_807#hasAbility} */
  @Method(0x8077090)
  public static int hasAbility_(final int charOrMonsterId, final int ability) {
    return (int)MEMORY.call(0x8078bc0, charOrMonsterId, ability);
  }

  @Method(0x8077098)
  public static void FUN_8077098() {
    FUN_8077d38();
  }

  /** {@link GoldenSun_807#readFlag} */
  @Method(0x80770c0)
  public static int readFlag_(final int r0) {
    return (int)MEMORY.call(0x8079338, r0);
  }

  /** {@link GoldenSun_807#setFlag} */
  @Method(0x80770c8)
  public static void setFlag_(final int r0) {
    MEMORY.call(0x8079358, r0);
  }

  /** {@link GoldenSun_807#clearFlag} */
  @Method(0x80770d0)
  public static void clearFlag_(final int r0) {
    MEMORY.call(0x8079374, r0);
  }

  /** {@link GoldenSun_807#FUN_80793b8} */
  @Method(0x80770e0)
  public static int FUN_80770e0(final int r0) {
    return (int)MEMORY.call(0x80793b8, r0);
  }

  /** {@link GoldenSun_807#addHp} */
  @Method(0x8077118)
  public static int addHp_(final int charId, final int amount) {
    return (int)MEMORY.call(0x80783a4, charId, amount);
  }

  /** {@link GoldenSun_807#addPp} */
  @Method(0x8077120)
  public static int addPp_(final int charId, final int amount) {
    return (int)MEMORY.call(0x80783dc, charId, amount);
  }

  /** {@link GoldenSun_807#FUN_8079460} */
  @Method(0x8077140)
  public static int FUN_8077140(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x8079460, r0, r1, r2);
  }

  /** {@link GoldenSun_807#getCharCount} */
  @Method(0x8077148)
  public static int getCharCount_() {
    return (int)MEMORY.call(0x80795fc);
  }

  /** {@link GoldenSun_807#addChar} */
  @Method(0x8077150)
  public static int addChar_(final int charId) {
    return (int)MEMORY.call(0x807961c, charId);
  }

  /** {@link GoldenSun_807#getPartyMemberIds} */
  @Method(0x8077158)
  public static int getPartyMemberIds_(final int out) {
    return (int)MEMORY.call(0x80796c4, out);
  }

  /** {@link GoldenSun_807#removeChar} */
  @Method(0x8077168)
  public static int removeChar_(final int charId) {
    return (int)MEMORY.call(0x8079664, charId);
  }

  /** {@link GoldenSun_807#FUN_8079c5c} */
  @Method(0x8077190)
  public static int FUN_8077190(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x8079c5c, r0, r1, r2);
  }

  /** {@link GoldenSun_807#FUN_80773d8} */
  @Method(0x8077198)
  public static int FUN_8077198(final int r0) {
    return (int)MEMORY.call(0x80773d8, r0);
  }

  /** {@link GoldenSun_807#lcgRand} */
  @Method(0x80771a0)
  public static int lcgRand_() {
    return (int)MEMORY.call(0x8079bc4);
  }

  /** {@link GoldenSun_807#setDjinn} */
  @Method(0x80771b0)
  public static int setDjinn_(final int charId, final int element, final int djinn) {
    return (int)MEMORY.call(0x807a2e4, charId, element, djinn);
  }

  /** {@link GoldenSun_807#recoverDjinn} */
  @Method(0x80771c0)
  public static int recoverDjinn_(final int charId, final int element, final int djinn) {
    return (int)MEMORY.call(0x807a3a8, charId, element, djinn);
  }

  /** {@link GoldenSun_807#FUN_807a458} */
  @Method(0x80771c8)
  public static void FUN_80771c8(final int charId, final int element, final int djinn) {
    MEMORY.call(0x807a458, charId, element, djinn);
  }

  /** {@link GoldenSun_807#FUN_80797d4} */
  @Method(0x80771e0)
  public static int FUN_80771e0(final int r0) {
    return (int)MEMORY.call(0x80797d4, r0);
  }

  /** {@link GoldenSun_807#FUN_807a5b0} */
  @Method(0x80771e8)
  public static int FUN_80771e8(final int r0, final int r1) {
    return (int)MEMORY.call(0x807a5b0, r0, r1);
  }

  /** {@link GoldenSun_807#FUN_807a2bc} */
  @Method(0x8077208)
  public static int FUN_8077208(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x807a2bc, r0, r1, r2);
  }

  /** {@link GoldenSun_807#FUN_807a1f8} */
  @Method(0x8077210)
  public static int FUN_8077210(final int charId, final int element, final int djinn) {
    return (int)MEMORY.call(0x807a1f8, charId, element, djinn);
  }

  /** {@link GoldenSun_807#isEquipped} */
  @Method(0x8077218)
  public static int isEquipped_(final int charId, final int itemId) {
    return (int)MEMORY.call(0x807842c, charId, itemId);
  }

  /** {@link GoldenSun_807#FUN_80787dc} */
  @Method(0x8077228)
  public static int FUN_8077228(final int charId, final int itemType) {
    return (int)MEMORY.call(0x80787dc, charId, itemType);
  }

  /** {@link GoldenSun_807#FUN_8079700} */
  @Method(0x8077230)
  public static int FUN_8077230(final int amount) {
    return (int)MEMORY.call(0x8079700, amount);
  }

  /** {@link GoldenSun_807#addArtifact} */
  @Method(0x8077240)
  public static int addArtifact_(final int r0, final int r1) {
    return (int)MEMORY.call(0x8078ad0, r0, r1);
  }

  /** {@link GoldenSun_807#FUN_8077f40} */
  @Method(0x8077270)
  public static void FUN_8077270() {
    MEMORY.call(0x8077f40);
  }

  /** {@link GoldenSun_807#getDjinnCount} */
  @Method(0x8077290)
  public static int getDjinnCount_(final int r0) {
    return (int)MEMORY.call(0x807a5bc, r0);
  }

  /** {@link GoldenSun_807#FUN_8079ef8} */
  @Method(0x80772b8)
  public static int FUN_80772b8(final int r0) {
    return (int)MEMORY.call(0x8079ef8, r0);
  }

  /** {@link GoldenSun_807#FUN_8078bf0} */
  @Method(0x80772c0)
  public static int FUN_80772c0(final int r0) {
    return (int)MEMORY.call(0x8078bf0, r0);
  }

  /** {@link GoldenSun_807#FUN_8077348} */
  @Method(0x80772c8)
  public static int FUN_80772c8() {
    return (int)MEMORY.call(0x8077348);
  }

  /** {@link GoldenSun_807#FUN_8077c10} */
  @Method(0x80772f0)
  public static void FUN_80772f0() {
    MEMORY.call(0x8077c10);
  }

  /** {@link GoldenSun_807#calculateBuildDate} */
  @Method(0x8077300)
  public static int calculateBuildDate_() {
    return (int)MEMORY.call(0x8077cb8);
  }

  /** This is the djinn recovery queue (in a PvP battle, char slot 3 is actually replaced with the enemy's queue) */
  @Method(0x8077330)
  public static RecoveryQueue10c getDjinnRecoveryQueue(final int inPvp) {
    if(inPvp == 0) {
      //LAB_807733e
      return djinnRecoveryQueue_200024c;
    }

    //LAB_8077340
    return MEMORY.ref(4, getCharOrMonsterData(0x83).getAddress(), RecoveryQueue10c::new);
  }

  @Method(0x8077348)
  public static int FUN_8077348() {
    final int r7 = getCharCount();

    if(r7 == 0) {
      return 0;
    }

    //LAB_8077368
    int r6 = 0;
    for(int r5 = 0; r5 < r7; r5++) {
      r6 += getCharOrMonsterData(charIds_2000438.get(r5).get()).level_0f.get();
    }

    //LAB_807737e
    //LAB_8077388
    return divideS(r6, r7);
  }

  @Method(0x8077394)
  public static Unit14c getCharOrMonsterData(final int id) {
    if(id >= 0 && id < 8) {
      return _2000500.get(id);
    }

    //LAB_80773a8
    if(id < 0x80 || id > 0x85) {
      return null;
    }

    final int r2 = boardWramMallocHead_3001e50.offset(54 * 0x4).get();
    if(r2 == 0) {
      //LAB_80773c6
      return null;
    }

    //LAB_80773c8
    return MEMORY.ref(4, r2 + (id - 0x80) * 0x14c, Unit14c::new); //TODO
  }

  @Method(0x80773d8)
  public static int FUN_80773d8(int r0) {
    final int r3;

    r0 = CPU.subT(r0, 0x8);
    CPU.cmpT(r0, 0xf9);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0x0);
    }

    //LAB_80773e2
    r3 = CPU.movT(0x54);
    r0 = CPU.mulT(r0, r3);
    r0 = CPU.addT(r0, 0x8080ec8); //TODO
    return r0;
  }

  @Method(0x8077428)
  public static void recalcStats(final int charId) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x4;
    r6 = mallocBoard(0x60);
    final Unit14c r7 = getCharOrMonsterData(charId);
    MEMORY.ref(4, r6).setu(r7.baseMaxHp_10.get());
    MEMORY.ref(4, r6 + 0x4).setu(r7.baseMaxPp_12.get());
    MEMORY.ref(4, r6 + 0x8).setu(r7.baseAttack_18.get());
    MEMORY.ref(4, r6 + 0xc).setu(r7.baseDefence_1a.get());
    MEMORY.ref(4, r6 + 0x10).setu(r7.baseAgility_1c.get());
    MEMORY.ref(4, r6 + 0x18).setu(r7.baseLuck_1e.get());
    MEMORY.ref(4, r6 + 0x1c).setu(r7.baseTurns_1f.get() & 0xf);
    MEMORY.ref(4, r6 + 0x20).setu(r7.baseRecoveryHp_20.get());
    MEMORY.ref(4, r6 + 0x24).setu(r7.baseRecoveryPp_21.get());

    //LAB_8077482
    for(r5 = 0; r5 < 4; r5++) {
      MEMORY.ref(4, r6 + 0x28 + r5 * 0x8).setu(r7.powerResist_24.get(r5).power_00.get());
      MEMORY.ref(4, r6 + 0x28 + r5 * 0x8 + 0x4).setu(r7.powerResist_24.get(r5).resist_02.get());
    }

    //LAB_80774be
    if(Math.abs(r7.fractionHp_14.get() * r7.maxHp_34.get() / 0x4000 - r7.hp_38.get()) > 1) {
      r7.fractionHp_14.set(0x4000);
      r7.fractionPp_16.set(0x4000);
      r7.hp_38.set(r7.maxHp_34.get());
      r7.pp_3a.set(r7.maxPp_36.get());
    } else if(Math.abs(r7.fractionPp_16.get() * r7.maxPp_36.get() / 0x4000 - r7.pp_3a.get()) > 1) {
      //LAB_80774f0
      r7.fractionHp_14.set(0x4000);
      r7.fractionPp_16.set(0x4000);
      r7.hp_38.set(r7.maxHp_34.get());
      r7.pp_3a.set(r7.maxPp_36.get());
    }

    //LAB_8077500
    int r0 = r7.curse_130.get() & ~0x3;
    if((r0 & 0x4) != 0) {
      r7.curse_130.set(r0 | 0x1);
    } else {
      r7.curse_130.set(r0);
    }

    //LAB_8077522
    if(r7.kiteTurns_144.get() != 0) {
      MEMORY.ref(4, r6 + 0x1c).incr();
    }

    //LAB_8077534
    r7.crit_142.set(0);
    r7.reflux_143.set(0);
    if(r7.class_129.get() != 0) {
      //LAB_807754e
      //LAB_8077550
      for(r5 = 0; r5 < 15; r5++) {
        final int itemId = r7.items_d8.get(r5).get();
        if((itemId & 0x200) != 0) {
          //LAB_8077564
          final Item2c item = getItem(itemId);
          MEMORY.ref(4, r6 + 0x58).setu(item.getAddress());
          if((item.flags_03.get() & Item2c.FLAG_CURSED_01) != 0) {
            r7.curse_130.or(0x3);
          }

          //LAB_8077584
          MEMORY.ref(4, r6 + 0x8).addu(item.attack_08.get());
          MEMORY.ref(4, r6 + 0xc).addu(item.defence_0a.get());
          CPU.r8().value = 0;

          //LAB_807759e
          do {
            MEMORY.ref(4, r6 + 0x48).setu(item.equipEffect_18.get(CPU.r8().value).effect_00.get());
            MEMORY.ref(4, r6 + 0x54).setu(item.equipEffect_18.get(CPU.r8().value).value_01.get());

            //LAB_80775b8
            switch(MEMORY.ref(4, r6 + 0x48).get()) {
              case 1 -> MEMORY.ref(4, r6).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 2 -> MEMORY.ref(4, r6 + 0x20).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 3 -> MEMORY.ref(4, r6 + 0x4).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 4 -> MEMORY.ref(4, r6 + 0x24).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 5 -> MEMORY.ref(4, r6 + 0x10).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 6 -> MEMORY.ref(4, r6 + 0x18).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0xf -> MEMORY.ref(4, r6 + 0x28).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x10 -> MEMORY.ref(4, r6 + 0x30).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x11 -> MEMORY.ref(4, r6 + 0x38).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x12 -> MEMORY.ref(4, r6 + 0x40).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x13 -> MEMORY.ref(4, r6 + 0x2c).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x14 -> MEMORY.ref(4, r6 + 0x34).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x15 -> MEMORY.ref(4, r6 + 0x3c).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x16 -> MEMORY.ref(4, r6 + 0x44).addu(MEMORY.ref(4, r6 + 0x54).get());
              case 0x17 -> r7.crit_142.add(MEMORY.ref(4, r6 + 0x54).get());
              case 0x18 -> r7.reflux_143.add(MEMORY.ref(4, r6 + 0x54).get());
              case 0x19 -> r7.curse_130.or(0x8);
              case 0x1a -> MEMORY.ref(4, r6 + 0x1c).addu(MEMORY.ref(4, r6 + 0x54).get());
            }

            //LAB_80776fc
            CPU.r8().value++;
          } while(CPU.r8().value < 4);
        }

        //LAB_8077708
      }

      //LAB_8077710
      if((r7.curse_130.get() & 0x8) != 0) {
        r7.curse_130.and(~0x9);
      }

      //LAB_8077728
      //LAB_8077732
      for(r4 = 0; r4 < 4; r4++) {
        CPU.r10().value = r7.djinn_f8.djinn_10.get(r4).get();

        //LAB_807773a
        for(r5 = 0; r5 < 20; r5++) {
          if((CPU.r10().value & 0x1 << r5) != 0) {
            r0 = FUN_807a0cc(r4, r5);
            MEMORY.ref(4, r6).addu(MEMORY.ref(1, r0 + 0x4).get());
            MEMORY.ref(4, r6 + 0x4).addu(MEMORY.ref(1, r0 + 0x5).get());
            MEMORY.ref(4, r6 + 0x8).addu(MEMORY.ref(1, r0 + 0x6).get());
            MEMORY.ref(4, r6 + 0xc).addu(MEMORY.ref(1, r0 + 0x7).get());
            MEMORY.ref(4, r6 + 0x10).addu(MEMORY.ref(1, r0 + 0x8).get());
            MEMORY.ref(4, r6 + 0x18).addu(MEMORY.ref(1, r0 + 0x9).get());
          }

          //LAB_807778e
        }
      }

      r5 = getClass(r7.class_129.get());
      MEMORY.ref(4, r6).setu(divideS(MEMORY.ref(1, r5 + 0x8).getUnsigned() * MEMORY.ref(4, r6).get(), 10));
      MEMORY.ref(4, r6 + 0x4).setu(divideS(MEMORY.ref(1, r5 + 0x9).getUnsigned() * MEMORY.ref(4, r6 + 0x4).get(), 10));
      MEMORY.ref(4, r6 + 0x8).setu(divideS(MEMORY.ref(1, r5 + 0xa).getUnsigned() * MEMORY.ref(4, r6 + 0x8).get(), 10));
      MEMORY.ref(4, r6 + 0xc).setu(divideS(MEMORY.ref(1, r5 + 0xb).getUnsigned() * MEMORY.ref(4, r6 + 0xc).get(), 10));
      MEMORY.ref(4, r6 + 0x10).setu(divideS(MEMORY.ref(1, r5 + 0xc).getUnsigned() * MEMORY.ref(4, r6 + 0x10).get(), 10));
      MEMORY.ref(4, r6 + 0x18).setu(divideS(MEMORY.ref(1, r5 + 0xd).getUnsigned() * MEMORY.ref(4, r6 + 0x18).get(), 10));

      //LAB_807780c
      for(r5 = 0; r5 < 15; r5++) {
        final int itemId = r7.items_d8.get(r5).get();
        if((itemId & 0x200) != 0) {
          final Item2c item = getItem(itemId);
          MEMORY.ref(4, r6 + 0x58).setu(item.getAddress());

          //LAB_807782a
          for(CPU.r8().value = 0; CPU.r8().value < 4; CPU.r8().value++) {
            MEMORY.ref(4, r6 + 0x48).setu(item.equipEffect_18.get(CPU.r8().value).effect_00.get());
            MEMORY.ref(4, r6 + 0x54).setu(item.equipEffect_18.get(CPU.r8().value).value_01.get());

            switch(MEMORY.ref(4, r6 + 0x48).get()) {
              case 14 -> MEMORY.ref(4, r6).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6).get(), 10));
              case 15 -> MEMORY.ref(4, r6 + 0x20).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x20).get(), 10));
              case 16 -> MEMORY.ref(4, r6 + 0x4).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x4).get(), 10));
              case 17 -> MEMORY.ref(4, r6 + 0x24).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x24).get(), 10));
              case 18 -> MEMORY.ref(4, r6 + 0x8).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x8).get(), 10));
              case 19 -> MEMORY.ref(4, r6 + 0xc).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0xc).get(), 10));
              case 20 -> MEMORY.ref(4, r6 + 0x10).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x10).get(), 10));
              case 21 -> MEMORY.ref(4, r6 + 0x18).setu(divideS(MEMORY.ref(4, r6 + 0x54).get() * MEMORY.ref(4, r6 + 0x18).get(), 10));
            }

            //LAB_80778fa
          }
        }

        //LAB_8077904
      }
    }

    //LAB_807790c
    r3 = r7._133.get();
    r2 = MEMORY.ref(4, r6 + 0x8).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077922
    r3 = CPU.asrT(r3, 3);
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = r7._135.get();
    r2 = MEMORY.ref(4, r6 + 0xc).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_807793c
    r3 = CPU.asrT(r3, 3);
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = r7._147.get();
    r2 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077956
    r3 = CPU.asrT(r3, 3);
    MEMORY.ref(4, r6 + 0x10).setu(r3);

    //LAB_8077964
    for(r5 = 0; r5 < 4; r5++) {
      r3 = r7.summonBoosts_12c.get(r5).get();
      MEMORY.ref(4, r6 + 0x28 + r5 * 0x8).addu((r3 * r3 + r3) * 5);
    }

    //LAB_807798c
    for(r5 = 0; r5 < 4; r5++) {
      MEMORY.ref(4, r6 + 0x2c + r5 * 0x8).addu(r7._137.get() * 20);
    }

    if(r7.class_129.get() != 0) {
      r0 = switch(r7.id_128.get()) {
        case 0 -> readFlag(0x110);
        case 1, 5 -> readFlag(0x112);
        case 2 -> readFlag(0x113);
        case 3 -> readFlag(0x111);
        default -> 1;
      };

      //LAB_8077a28
      if(r0 != 0) {
        MEMORY.ref(4, r6 + 0x24).addu(0x4);
      }
    }

    //LAB_8077a32
    r3 = MEMORY.ref(4, r6 + 0x8).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x8).setu(r3);
    }

    //LAB_8077a3c
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x8).setu(999);
    }

    //LAB_8077a44
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0xc).setu(r3);
    }

    //LAB_8077a4e
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0xc).setu(999);
    }

    //LAB_8077a54
    r3 = MEMORY.ref(4, r6 + 0x10).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x10).setu(r3);
    }

    //LAB_8077a5e
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x10).setu(999);
    }

    //LAB_8077a64
    r3 = MEMORY.ref(4, r6 + 0x18).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a6e
    CPU.cmpT(r3, 0x63);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0x63);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a76
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a80
    CPU.cmpT(r3, 0x2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0x2);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a88
    r3 = MEMORY.ref(4, r6 + 0x20).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x20).setu(r3);
    }

    //LAB_8077a92
    r3 = CPU.cmpT(r3, 10000);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x20).setu(10000);
    }

    //LAB_8077a9a
    r3 = MEMORY.ref(4, r6 + 0x24).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aa4
    CPU.cmpT(r3, 0xc8);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0xc8);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aac
    r2 = CPU.movT(0xc8);
    CPU.r12().value = r2;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.addT(r6, 0x0);
    r5 = CPU.movT(0x0);
    r0 = CPU.movT(0x0);
    r4 = CPU.movT(0x2c);
    r2 = CPU.addT(r2, 0x28);
    r1 = CPU.addT(r1, 0x2c);

    //LAB_8077abe
    do {
      r3 = MEMORY.ref(4, r2).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r2).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ac8
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_8077ad0
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r1).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ada
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r6 + r4).setu(r3);
      }

      //LAB_8077ae2
      r5 = CPU.addT(r5, 0x1);
      r1 = CPU.addT(r1, 0x8);
      r4 = CPU.addT(r4, 0x8);
      r2 = CPU.addT(r2, 0x8);
      CPU.cmpT(r5, 0x3);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r7.attack_3c.set(MEMORY.ref(4, r6 + 0x8).get());
    r7.defence_3e.set(MEMORY.ref(4, r6 + 0xc).get());
    r7.agility_40.set(MEMORY.ref(4, r6 + 0x10).get());
    r7.luck_42.set(MEMORY.ref(4, r6 + 0x18).get());
    r7.turns_43.set(MEMORY.ref(4, r6 + 0x1c).get());
    r7.recoveryHp_44.set(MEMORY.ref(4, r6 + 0x20).get());
    r7.recoveryPp_45.set(MEMORY.ref(4, r6 + 0x24).get());

    //LAB_8077b26
    for(r5 = 0; r5 < 4; r5++) {
      r7.elementalPowerResist_48.get(r5).power_00.set(MEMORY.ref(4, r6 + 0x28 + r5 * 0x8).get());
      r7.elementalPowerResist_48.get(r5).resist_02.set(MEMORY.ref(4, r6 + 0x28 + r5 * 0x8 + 0x4).get());
    }

    r3 = r7.class_129.get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = 1999;
    } else {
      r1 = 9999;
    }

    //LAB_8077b46
    r2 = r7.maxHp_34.get();
    r3 = MEMORY.ref(4, r6).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6).setu(r3);
    }

    //LAB_8077b54
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077b5c
    r7.maxHp_34.set(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = r7.fractionHp_14.get();
      r3 = MEMORY.ref(4, r6).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.addT(r2, 0x3fff);
      }

      //LAB_8077b76
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0x0);
      }

      //LAB_8077b7e
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077b84
      r3 = r7.hp_38.get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0x1);
        }
      }

      //LAB_8077b92
      r7.hp_38.set(r2);
    }

    //LAB_8077b94
    r2 = r7.maxPp_36.get();
    r3 = MEMORY.ref(4, r6 + 0x4).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0x0);
      MEMORY.ref(4, r6 + 0x4).setu(r3);
    }

    //LAB_8077ba2
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x4).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077baa
    r7.maxPp_36.set(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = r7.fractionPp_16.get();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8077c0c).get();
        r2 = CPU.addT(r2, r3);
      }

      //LAB_8077bc4
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0x0);
      }

      //LAB_8077bcc
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077bd2
      r3 = r7.pp_3a.get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0x1);
        }
      }

      //LAB_8077be0
      r7.pp_3a.set(r2);
    }

    //LAB_8077be2
    setMallocAddress(r6);
    CPU.sp().value += 0x4;

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8077c10)
  public static void FUN_8077c10() {
    clearFlag(0x167);

    //LAB_8077c44
    for(int charIndex = 0; charIndex < getCharCount(); charIndex++) {
      final Unit14c charData = getCharOrMonsterData(charIds_2000438.get(charIndex).get());

      //LAB_8077c52
      for(int r1 = 0; r1 < 15; r1++) {
        if((charData.items_d8.get(r1).get() & 0x200) != 0) {
          final Item2c item = getItem(charData.items_d8.get(r1).get());

          //LAB_8077c70
          for(int r6 = 0; r6 < 4; r6++) {
            if(item.equipEffect_18.get(r6).effect_00.get() == 0x1b) {
              setFlag(0x167);
            }

            //LAB_8077c86
          }
        }

        //LAB_8077c8c
      }
    }

    //LAB_8077c9e
  }

  @Method(0x8077cb8)
  public static int calculateBuildDate() {
    int r0;
    int r2;
    int r3;
    int r4;
    int r5;

    r0 = getPointerTableEntry(2);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r5 = CPU.addT(r3, 0xfffffe20);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r5, r3);
    r5 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r4 = CPU.addT(r3, 0xfffffe20);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r4, r3);
    r4 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r3, 0xfffffe20);
    r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
    r5 = CPU.subT(r5, 0x30);
    r3 = CPU.addT(r2, r3);
    r2 = CPU.addT(r3, 0x0);
    r4 = CPU.subT(r4, 0x30);
    r3 = CPU.lslT(r5, 4);
    r3 = CPU.addT(r3, r4);
    r2 = CPU.subT(r2, 0x30);
    r3 = CPU.lslT(r3, 6);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0x80);
    r3 = CPU.lslT(r3, 16);
    r2 = CPU.lslT(r2, 21);
    r2 = CPU.orrT(r2, r3);
    r3 = debug_3001f54.get();
    r0 = CPU.asrT(r2, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.orrT(r0, 0xffff8000);
    }

    //LAB_8077d1e
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x8077d38)
  public static void FUN_8077d38() {
    CPU.sp().value -= 0x8;
    final int r5 = CPU.sp().value + 0x4;

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000240);
    DMA.channels[3].CNT.setu(0x850000b0);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2001000);
    DMA.channels[3].CNT.setu(0x850003e1);

    //LAB_8077d66
    while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
      DebugHelper.sleep(0);
    }

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000040);
    DMA.channels[3].CNT.setu(0x85000080);

    MEMORY.ref(1, 0x2001104).setu(0xff);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000500);
    DMA.channels[3].CNT.setu(0x85000298);

    FUN_8078ee8();
    MEMORY.ref(2, 0x2000450).setu(0x1);
    MEMORY.ref(2, 0x2000452).setu(0x2);
    MEMORY.ref(2, 0x2000454).setu(0x4);
    MEMORY.ref(2, 0x2000456).setu(0x8);
    MEMORY.ref(2, 0x2000458).setu(0x200);
    MEMORY.ref(2, 0x200045a).setu(0x100);
    runButton_200045c.set(BUTTON_B);
    MEMORY.ref(2, 0x2000460).setu(0);
    MEMORY.ref(2, 0x2000462).setu(0);
    playerMapActorIndex_2000434.set(0);
    addChar(0);
    MEMORY.ref(4, 0x2000250).setu(0);
    _200044c.set(0x1);
    MEMORY.ref(1, 0x200044a).setu(0x1);
    MEMORY.ref(1, 0x200044b).setu(0x1);
    MEMORY.ref(1, 0x2000445).setu(0);
    MEMORY.ref(1, 0x2000446).setu(0x8);
    MEMORY.ref(4, 0x2000240).setu(0);
    MEMORY.ref(4, 0x20004f8).setu(calculateBuildDate());
    _3001c9c.set(0);
    _3001d08.set(0);
    MEMORY.ref(4, 0x2000244).setu(0);
    MEMORY.ref(1, 0x200046a).setu(_3001d08.get());
    framesSinceInput_3001d24.set(0);
    lastSaveSlot_2002004.set(-1);
    MEMORY.ref(1, 0x200035d).setu(0x4);
    MEMORY.ref(1, 0x200035e).setu(0x4);
    MEMORY.ref(1, 0x200035f).setu(0x4);
    MEMORY.ref(1, 0x2000360).setu(0x8);
    MEMORY.ref(1, 0x2000361).setu(0x8);
    MEMORY.ref(1, 0x2000362).setu(0x8);
    MEMORY.ref(1, 0x2000363).setu(0x10);
    MEMORY.ref(1, 0x2000364).setu(0x10);
    MEMORY.ref(1, 0x2000365).setu(0x10);
    MEMORY.ref(1, 0x2000366).setu(0x20);
    MEMORY.ref(1, 0x2000367).setu(0x20);
    MEMORY.ref(1, 0x2000368).setu(0x20);
    MEMORY.ref(1, 0x2000369).setu(0x40);
    MEMORY.ref(1, 0x200036a).setu(0x40);
    MEMORY.ref(1, 0x200036b).setu(0x40);

    CPU.sp().value += 0x8;
  }

  @Method(0x807822c)
  public static void FUN_807822c(int r0) {
    int r1;
    int r3;

    final Unit14c r5 = getCharOrMonsterData(r0);
    r0 = r5.hp_38.get();
    r1 = r5.maxHp_34.get();
    r0 = CPU.lslT(r0, 14);
    r0 = divideS(r0, r1);
    r3 = CPU.movT(0x80);
    r3 = CPU.lslT(r3, 7);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.movT(0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r3 = CPU.addT(r0, 0x0);
      }
    }

    //LAB_8078252
    r5.fractionHp_14.set(r3);
    r3 = CPU.lslT(r3, 16);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r5.hp_38.get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0x1);
        r5.fractionHp_14.set(r3);
      }
    }

    //LAB_8078266
    r0 = r5.pp_3a.get();
    r1 = r5.maxPp_36.get();
    r0 = CPU.lslT(r0, 14);
    r0 = divideS(r0, r1);
    r3 = CPU.movT(0x80);
    r3 = CPU.lslT(r3, 7);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.movT(0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r3 = CPU.addT(r0, 0x0);
      }
    }

    //LAB_8078284
    r5.fractionPp_16.set(r3);
    r3 = CPU.lslT(r3, 16);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r5.pp_3a.get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0x1);
        r5.fractionPp_16.set(r3);
      }
    }

    //LAB_8078298
  }

  @Method(0x80783a4)
  public static int addHp(final int charId, final int amount) {
    final Unit14c r6 = getCharOrMonsterData(charId);
    r6.hp_38.set(clamp(r6.hp_38.get() + amount, 0, r6.maxHp_34.get()));
    FUN_807822c(charId);
    return r6.hp_38.get();
  }

  @Method(0x80783dc)
  public static int addPp(final int charId, final int amount) {
    final Unit14c r6 = getCharOrMonsterData(charId);
    r6.pp_3a.set(clamp(r6.pp_3a.get() + amount, 0, r6.maxPp_36.get()));
    FUN_807822c(charId);
    return r6.pp_3a.get();
  }

  @Method(0x8078414)
  public static Item2c getItem(final int itemId) {
    return items_807b6a8.get(itemId & 0x1ff);
  }

  @Method(0x807842c)
  public static int isEquipped(final int charId, final int itemId) {
    final Unit14c charData = getCharOrMonsterData(charId);
    if(charData.id_128.get() > 7) {
      return 0;
    }

    //LAB_807844e
    final Item2c item = getItem(itemId);
    return item.equippable_04.get() >> charData.id_128.get() & 0x1;
  }

  /** @return item slot */
  @Method(0x8078588)
  public static int addItem(final int charId, final int itemId) {
    final Unit14c r6 = getCharOrMonsterData(charId);
    final Item2c item = getItem(itemId);
    if((item.flags_03.get() & Item2c.FLAG_STACKABLE_10) != 0) {
      //LAB_80785b8
      int i;
      for(i = 0; i < 15 && ((r6.items_d8.get(i).get() ^ itemId) & 0x1ff) != 0; i++) {
        // no-op
      }

      //LAB_80785ca
      if(i != 15) {
        final int r1 = r6.items_d8.get(i).get();
        final int r3 = r1 >>> 11;
        if(r3 > 28) {
          return -1;
        }
        final int r2 = r3 + 0x1;
        r6.items_d8.get(i).set(r1 & 0x7ff | r2 << 11);
        return i;
      }
    }

    //LAB_80785ee
    //LAB_80785f6
    for(int i = 0; i < 15; i++) {
      if(r6.items_d8.get(i).get() == 0) {
        //LAB_80785ea
        r6.items_d8.get(i).set(itemId);
        return i;
      }
    }

    //LAB_8078606
    //LAB_807860a
    return -1;
  }

  @Method(0x8078618)
  public static int giveItem(final int itemId) {
    CPU.sp().value -= 0x18;

    final int r3 = CPU.sp().value + 0x4;
    final int r7 = getPartyMemberIds(r3);

    //LAB_8078634
    for(int r6 = 0; r6 < r7; r6++) {
      final int r5 = MEMORY.ref(2, r3 + r6 * 0x2).get();
      if(addItem(r5, itemId) >= 0) {
        CPU.sp().value += 0x18;
        return r5;
      }

      //LAB_807864e
    }

    //LAB_8078654
    //LAB_8078658
    CPU.sp().value += 0x18;
    return -1;
  }

  @Method(0x8078708)
  public static int equipItem(final int charId, final int itemSlot) {
    final Unit14c r7 = getCharOrMonsterData(charId);
    final int r5 = r7.items_d8.get(itemSlot).get();

    if(isEquipped(charId, r5) == 0) {
      return -1;
    }

    //LAB_807873c
    if((r5 & 0x200) != 0) {
      return 0;
    }

    final int r8 = getItem(r5).type_02.get();
    if(r8 != 6) {
      //LAB_8078764
      int r6;
      for(r6 = 0; r6 < 15; r6++) {
        if((r7.items_d8.get(r6).get() & 0x200) != 0 && getItem(r7.items_d8.get(r6).get()).type_02.get() == r8) {
          break;
        }

        //LAB_8078760
      }

      //LAB_807877e
      if(r6 != 15) {
        if((getItem(r7.items_d8.get(r6).get()).flags_03.get() & Item2c.FLAG_CANT_REMOVE_02) != 0) {
          return -1;
        }

        //LAB_807879e
        r7.items_d8.get(r6).and(~0x200);
      }
    }

    //LAB_80787a6
    r7.items_d8.get(itemSlot).or(0x200);
    FUN_8078bf0(charId);
    recalcStats(charId);
    return 0;
  }

  @Method(0x8078870)
  public static int FUN_8078870(final Unit14c unit, final int itemType) {
    //LAB_807888a
    for(int r6 = 0; r6 < 15; r6++) {
      if((unit.items_d8.get(r6).get() & 0x200) != 0 && getItem(unit.items_d8.get(r6).get()).type_02.get() == itemType) {
        return unit.items_d8.get(r6).get() & 0x1ff;
      }

      //LAB_80788a8
    }

    return 0;
  }

  @Method(0x80788c4)
  public static int takeItem(final int charId, final int itemSlot) {
    final Unit14c charData = getCharOrMonsterData(charId);
    final int r3 = charData.items_d8.get(itemSlot).get();
    int r6 = -1;
    if(r3 != 0) {
      if((r3 & 0xf800) != 0) {
        charData.items_d8.get(itemSlot).sub(0x800);
        r6 = 1;
      } else {
        //LAB_80788f4
        charData.items_d8.get(itemSlot).set(0);
        int r5 = 0;

        //LAB_8078902
        for(int i = 0; i < 15; i++) {
          final int itemId = charData.items_d8.get(i).get();
          if(itemId != 0) {
            charData.items_d8.get(r5).set(itemId);
            r5++;
          }

          //LAB_8078912
        }

        //LAB_8078926
        for(int i = r5; i < 15; i++) {
          charData.items_d8.get(i).set(0);
        }

        //LAB_8078938
        r6 = 2;
      }
    }

    //LAB_807893a
    recalcStats(charId);
    return r6;
  }

  @Method(0x8078a34)
  public static int breakItem(final int charId, final int itemSlot) {
    final Unit14c charData = getCharOrMonsterData(charId);

    if(charData.items_d8.get(itemSlot).get() == 0) {
      return -1;
    }

    //LAB_8078a4e
    charData.items_d8.get(itemSlot).or(0x400);

    //LAB_8078a56
    return 0;
  }

  @Method(0x8078aa0)
  public static int FUN_8078aa0(final int r0, final int r1) {
    if(r0 >= 0x80) {
      return 0;
    }

    //LAB_8078ac2
    MEMORY.ref(1, 0x2000380 + r0).setu(MathHelper.clamp(MEMORY.ref(1, 0x2000380 + r0).getUnsigned() + r1, 0, 99));
    return MEMORY.ref(1, 0x2000380 + r0).get();
  }

  @Method(0x8078ad0)
  public static int addArtifact(final int r0, final int r1) {
    final int r0_0 = MEMORY.ref(1, 0x807b490 + (r0 & 0x1ff)).getUnsigned();

    if(r0_0 == 0) {
      return 0;
    }

    return FUN_8078aa0(r0_0 - 1, r1);
  }

  @Method(0x8078b9c)
  public static int getAbility(int r0) {
    r0 = r0 & 0x3fff;

    if(r0 >= 0x208) {
      r0 = 0;
    }

    //LAB_8078bac
    return 0x807ee58 + r0 * 0x10;
  }

  @Method(0x8078bc0)
  public static int hasAbility(final int charOrMonsterId, final int ability) {
    final Unit14c r0 = getCharOrMonsterData(charOrMonsterId);

    //LAB_8078bce
    for(int r2 = 0; r2 < 0x20; r2++) {
      if((r0.psynergy_58.get(r2).get() & 0x3fff) == ability) {
        return 1;
      }

      //LAB_8078bdc
    }

    //LAB_8078be4
    return 0;
  }

  @Method(0x8078bf0)
  public static int FUN_8078bf0(int r0) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;
    int r10;
    int lr;

    final Unit14c r9 = getCharOrMonsterData(r0);

    if(r9.class_129.get() == 0) {
      return 0;
    }

    final int cls = getClass(r9.class_129.get());

    //LAB_8078c2c
    for(r5 = 0; r5 < 32; r5++) {
      if((r9.psynergy_58.get(r5).get() & 0x8000) != 0) {
        r9.psynergy_58.get(r5).set(0);
      }
    }

    //LAB_8078c54
    for(r5 = 0; r5 < 32; r5++) {
      if((r9.psynergy_58.get(r5).get() & 0x4000) != 0) {
        r9.psynergy_58.get(r5).set(0);
      }
    }

    r5 = 0x1f;

    //LAB_8078c6e
    for(r4 = 0x1f; r4 >= 0; r4--) {
      r2 = r9.psynergy_58.get(r4).get();
      if(r2 != 0) {
        //LAB_8078c7e
        r9.psynergy_58.get(r5).set(r2);
        r5--;
      }

      //LAB_8078c86
    }

    //LAB_8078c94
    for(; r5 >= 0; r5--) {
      r9.psynergy_58.get(r5).set(0);
    }

    //LAB_8078ca4
    r5 = 0;
    r10 = 0x10;
    lr = cls + r10;
    r7 = lr;

    //LAB_8078cb8
    do {
      if(MEMORY.ref(1, r7).getUnsigned() != 0) {
        r2 = r9.level_0f.get();
        r3 = MEMORY.ref(1, lr + 0x1).getUnsigned();
        r2 = CPU.cmpT(r2, r3);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          //LAB_8078cdc
          for(r4 = 0; r4 < 32 && r9.psynergy_58.get(r4).get() != MEMORY.ref(1, cls + r10).getUnsigned(); r4++) {
            // no-op
          }

          //LAB_8078cf0
          if(r4 == 32) {
            //LAB_8078d06
            for(r4 = 0; r4 < 32; r4++) {
              if(r9.psynergy_58.get(r4).get() == 0) {
                r9.psynergy_58.get(r4).set(MEMORY.ref(1, r7).getUnsigned() | 0x8000);
                break;
              }
            }

            //LAB_8078d20
            if(r4 == 32) {
              break;
            }
          }
        }
      }

      //LAB_8078d24
      lr += 0x4;
      r7 += 0x4;
      r10 += 0x4;
      r5++;
    } while(r5 < 16);

    //LAB_8078d32
    //LAB_8078d38
    for(r5 = 0; r5 < 15; r5++) {
      final int itemId = r9.items_d8.get(r5).get();
      if(itemId != 0 && (itemId & 0x200) != 0) {
        final Item2c item = getItem(itemId);
        if(item.useType_0c.get() == 3) {
          r0 = item.useAbility_28.get();

          //LAB_8078d78
          for(r4 = 0; r4 < 32 && (r9.psynergy_58.get(r4).get() & 0x3fff) != r0; r4++) {
            // no-op
          }

          //LAB_8078d8a
          if(r4 == 32) {
            for(r4 = 0; r4 < 32; r4++) {
              if(r9.psynergy_58.get(r4).get() == 0) {
                r9.psynergy_58.get(r4).set(r0 | 0x4000);
                break;
              }
            }

            //LAB_8078dc0
            if(r4 == 32) {
              break;
            }
          }
        }
      }

      //LAB_8078dc4
    }

    //LAB_8078dce
    r5 = 0;

    //LAB_8078dd4
    for(r4 = 0; r4 < 32; r4++) {
      final int psynergyId = r9.psynergy_58.get(r4).get();
      if(psynergyId != 0) {
        //LAB_8078de8
        r9.psynergy_58.get(r5).set(psynergyId);
        r5++;
      }

      //LAB_8078df0
    }

    //LAB_8078e04
    for(; r5 < 32; r5++) {
      r9.psynergy_58.get(r5).set(0);
    }

    //LAB_8078e14
    //LAB_8078e16
    return 0;
  }

  @Method(0x8078ed8)
  public static int FUN_8078ed8(final int r0) {
    return 0x80844ec + r0 * 0xb4; //TODO
  }

  @Method(0x8078ee8)
  public static void FUN_8078ee8() {
    CPU.sp().value -= 0x20;
    int r10 = CPU.sp().value;

    //LAB_8078efe
    for(int r6 = 0; r6 < 8; r6++) {
      final Unit14c r7 = getCharOrMonsterData(r6);
      FUN_8015020(0x66 + r6, r10);

      //LAB_8078f24
      for(int r5 = 0; r5 < 14 && MEMORY.ref(2, r10 + r5 * 0x2).getUnsigned() != 0; r5++) {
        r7.name_00.get(r5).set(MEMORY.ref(2, r10 + r5 * 0x2).getUnsigned());
      }

      //LAB_8078f38
      r7.name_00.get(14).set(0);
    }

    //LAB_8078f4e
    int r8 = 0x807b690;
    int r0;
    while((r0 = MEMORY.ref(4, r8).get()) != -1) {
      final Unit14c r7 = getCharOrMonsterData(r0);
      if(r7 != null) {
        r7.id_128.set(MEMORY.ref(4, r8).get());
        r10 = FUN_8078ed8(r7.id_128.get());

        //LAB_8078f74
        for(int r5 = 0; r5 < 15; r5++) {
          r7.items_d8.get(r5).set(0);
        }

        //LAB_8078f9c
        for(int r5 = 0; r5 < 13; r5++) {
          equipItem(MEMORY.ref(4, r8).get(), addItem(MEMORY.ref(4, r8).get(), MEMORY.ref(2, r10 + 0x98 + r5 * 0x2).getUnsigned() & 0x1ff));
        }

        FUN_8079ae8(MEMORY.ref(4, r8).get());
        r7.fractionHp_14.set(0x4000);
        r7.fractionPp_16.set(0x4000);
        FUN_80792fc(MEMORY.ref(4, r8).get(), MEMORY.ref(1, r10 + 0x96).getUnsigned());
        recalcStats(MEMORY.ref(4, r8).get());
      }

      //LAB_8078fe2
      r8 += 0x4;
    }

    //LAB_8078ff4
    CPU.sp().value += 0x20;
  }

  /** Called after confirming character names */
  @Method(0x8077f40)
  public static void FUN_8077f40() {
    setFlag(0x20);
    FUN_8079ae8(0);
    FUN_8079ae8(1);
    FUN_8079ae8(5);
    recalcStats(0);
    recalcStats(1);
    recalcStats(5);
  }

  @Method(0x80787dc)
  public static int FUN_80787dc(final int charId, final int itemType) {
    final Unit14c r7 = getCharOrMonsterData(charId);

    //LAB_80787fc
    for(int r6 = 0; r6 < 15; r6++) {
      if((r7.items_d8.get(r6).get() & 0x200) != 0 && getItem(r7.items_d8.get(r6).get()).type_02.get() == itemType) {
        return r6;
      }

      //LAB_80787f8
    }

    //LAB_807881e
    return -1;
  }

  @Method(0x8079008)
  public static int FUN_8079008(final int r0, final int r1) {
    final Unit14c r2 = getCharOrMonsterData(r0);
    if(r2.class_129.get() == 0) {
      return -1;
    }

    if(r1 <= 0) {
      return 0;
    }

    if(r1 > 99) {
      return -1;
    }

    final int r3 = r2.id_128.get();
    if(r3 > 7) {
      //LAB_8079048
      return -1;
    }

    //LAB_807904c
    return MEMORY.ref(4, 0x807a830 + (r3 * 99 + r1 - 1) * 0x4).get(); //TODO
  }

  @Method(0x807905c)
  public static int FUN_807905c(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r7;

    final int r6 = r1;
    final int r11 = r0;
    final Unit14c r10 = getCharOrMonsterData(r11);
    final int r9 = mallocBoard(0x2c);
    MEMORY.ref(4, r9).setu(r10.class_129.get());
    r1 = r10.level_0f.get();
    MEMORY.ref(4, r9 + 0x4).setu(r1);
    MEMORY.ref(2, r6).setu(r1);
    MEMORY.ref(2, r6 + 0x2).setu(0xffff);
    MEMORY.ref(2, r6 + 0x4).setu(0);
    MEMORY.ref(2, r6 + 0x6).setu(0);
    MEMORY.ref(2, r6 + 0x8).setu(0);
    MEMORY.ref(2, r6 + 0xa).setu(0);
    MEMORY.ref(2, r6 + 0xc).setu(0);
    MEMORY.ref(2, r6 + 0xe).setu(0);
    CPU.cmpT(r1, 0x62);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      //LAB_80790a6
      r10.level_0f.incr();
      r3 = CPU.addT(r1, 0x1);
      MEMORY.ref(2, r6).setu(r3);
      r0 = FUN_8079008(r11, r10.level_0f.get());
      r0 = CPU.cmpT(r0, -1);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = r10.exp_124.get();
        r3 = CPU.cmpT(r3, r0);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          r10.exp_124.set(r0);
        }
      }

      //LAB_80790ce
      r1 = FUN_8078ed8(r11);
      r3 = MEMORY.ref(2, r6).get();
      MEMORY.ref(4, r9 + 0x8).setu(r1);
      r0 = MEMORY.ref(2, r6).getUnsigned();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x50);
        r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
        r2 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x5c);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x4).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x68);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x74);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x8).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x80);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0xa).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xc).setu(r3);
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.addT(r3, 0x8c);
        r2 = MEMORY.ref(1, r3).getUnsigned();
        r3 = MEMORY.ref(2, r6 + 0xe).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xe).setu(r3);
      }

      //LAB_807912c
      r0 = CPU.lslT(r0, 16);
      r0 = CPU.asrT(r0, 16);
      r1 = CPU.movT(0x14);
      r0 = divideS(r0, r1);
      r0 = CPU.lslT(r0, 16);
      r5 = CPU.asrT(r0, 16);
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r5 = CPU.movT(0x0);
      }

      //LAB_8079140
      CPU.cmpT(r5, 0x4);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r5 = CPU.movT(0x4);
      }

      //LAB_8079146
      r0 = CPU.lslT(r5, 1);
      final int r8 = r0;
      r1 = MEMORY.ref(4, r9 + 0x8).get();
      r2 = MEMORY.ref(2, r8 + 0x52 + r1).get();
      r3 = MEMORY.ref(2, r8 + 0x50 + r1).get();
      r7 = CPU.subT(r2, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0x14);
      r0 = divideU(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x4).setu(r3);
      r2 = MEMORY.ref(4, r9 + 0x8).get();
      r1 = MEMORY.ref(2, r8 + 0x5e + r2).get();
      r3 = MEMORY.ref(2, r8 + 0x5c + r2).get();
      r7 = CPU.subT(r1, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0x14);
      r0 = divideU(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x6).setu(r3);
      r2 = MEMORY.ref(4, r9 + 0x8).get();
      r1 = MEMORY.ref(2, r8 + 0x6a + r2).getUnsigned();
      r3 = MEMORY.ref(2, r8 + 0x68 + r2).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0x14);
      r0 = divideU(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r2 = MEMORY.ref(4, r9 + 0x8).get();
      MEMORY.ref(2, r6 + 0x8).setu(r3);
      r1 = MEMORY.ref(2, r8 + 0x76 + r2).getUnsigned();
      r3 = MEMORY.ref(2, r8 + 0x74 + r2).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0x14);
      r0 = divideU(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0xa).setu(r3);
      r2 = MEMORY.ref(4, r9 + 0x8).get();
      r1 = MEMORY.ref(2, r8 + 0x82 + r2).getUnsigned();
      r3 = MEMORY.ref(2, r8 + 0x80 + r2).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r0 = divideU(r0, 20);
      r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r2 = MEMORY.ref(4, r9 + 0x8).get();
      MEMORY.ref(2, r6 + 0xc).setu(r3);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x8d);
      r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x1);
      r3 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r0 = divideU(r0, 20);
      MEMORY.ref(2, r6 + 0xe).addu(r0);
      r10.baseMaxHp_10.add(MEMORY.ref(2, r6 + 0x4).get());
      r10.baseMaxPp_12.add(MEMORY.ref(2, r6 + 0x6).get());
      r10.baseAttack_18.add(MEMORY.ref(2, r6 + 0x8).getUnsigned());
      r10.baseDefence_1a.add(MEMORY.ref(2, r6 + 0xa).getUnsigned());
      r10.baseAgility_1c.add(MEMORY.ref(2, r6 + 0xc).getUnsigned());
      r10.baseLuck_1e.add(MEMORY.ref(2, r6 + 0xe).get());
      r10.baseTurns_1f.set(1);
      r10.baseRecoveryHp_20.set(0);
      r10.baseRecoveryPp_21.set(0);
      FUN_8078bf0(r11);
      recalcStats(r11);
    }

    //LAB_80792a4
    setMallocAddress(r9);
    return r6;
  }

  @Method(0x80792fc)
  public static void FUN_80792fc(final int r0, final int r1) {
    CPU.sp().value -= 0x10;
    int r5 = getCharOrMonsterData(r0).level_0f.get();

    //LAB_8079318
    for(; r5 < r1; r5++) {
      FUN_807905c(r0, CPU.sp().value);
    }

    //LAB_8079326
    recalcStats(r0);
    CPU.sp().value += 0x10;
  }

  @Method(0x8079338)
  public static int readFlag(final int r0) {
    final int r3 = MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).getUnsigned() & 0x1 << (r0 & 0x7); //TODO
    return (-r3 | r3) >>> 31;
  }

  @Method(0x8079358)
  public static void setFlag(final int r0) {
    MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).oru(0x1 << (r0 & 0x7)); //TODO
  }

  @Method(0x8079374)
  public static void clearFlag(final int r0) {
    MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).and(~(0x1 << (r0 & 0x7))); //TODO
  }

  @Method(0x80793b8)
  public static int FUN_80793b8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8079460)
  public static int FUN_8079460(int r0, int r1, final int r2) {
    int r3;
    final int r4;
    int r5;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.r11().value = r1;
    r5 = CPU.r11().value - 0x8;
    CPU.sp().value -= 0x24;
    CPU.r9().value = r0;
    CPU.r8().value = r2;
    if(CPU.r9().value < 0x80) {
      r0 = 0x0;
    } else {
      //LAB_8079482
      r0 = 0x0;
      if(CPU.r9().value <= 0x86) {
        //LAB_807948c
        if((r5 & 0xffff_ffffL) <= (0xf2 & 0xffff_ffffL)) {
          //LAB_8079492
          final Unit14c r6 = getCharOrMonsterData(CPU.r9().value);
          MEMORY.call(0x3000164, r6.getAddress(), 0x14c);
          if((r5 & 0xffff_ffffL) > (0xa4 & 0xffff_ffffL)) {
            r5 = 0x0;
          }

          //LAB_80794aa
          r7 = 0x8080ec8 + r5 * 0x54;
          r6.level_0f.set(MEMORY.ref(1, r7 + 0xf).getUnsigned());
          r3 = MEMORY.ref(2, r7 + 0x10).getUnsigned();
          r6.baseMaxHp_10.set(r3);
          r6.hp_38.set(r3);
          r6.maxHp_34.set(r3);
          r3 = MEMORY.ref(2, r7 + 0x12).getUnsigned();
          r6.baseMaxPp_12.set(r3);
          r6.pp_3a.set(r3);
          r6.maxPp_36.set(r3);
          r6.fractionHp_14.set(0x4000);
          r6.fractionPp_16.set(0x4000);
          r6.baseAttack_18.set(MEMORY.ref(2, r7 + 0x14).getUnsigned());
          r6.baseDefence_1a.set(MEMORY.ref(2, r7 + 0x16).getUnsigned());
          r6.baseAgility_1c.set(MEMORY.ref(2, r7 + 0x18).getUnsigned());
          r6.baseLuck_1e.set(MEMORY.ref(1, r7 + 0x1a).getUnsigned());
          r6.baseTurns_1f.set(MEMORY.ref(1, r7 + 0x1b).getUnsigned());
          r6.baseRecoveryHp_20.set(MEMORY.ref(1, r7 + 0x1c).getUnsigned());
          r3 = MEMORY.ref(1, r7 + 0x1d).getUnsigned();
          r4 = CPU.sp().value + 0x4;
          r6.baseRecoveryPp_21.set(r3);
          FUN_8015028(r5 + 0x28f, r4, 0xf);

          //LAB_8079514
          for(r5 = 0; r5 < 14 && MEMORY.ref(2, r4 + r5 * 0x2).getUnsigned() != 0; r5++) {
            r6.name_00.get(r5).set(MEMORY.ref(2, r4 + r5 * 0x2).getUnsigned());
          }

          //LAB_8079528
          if(CPU.r8().value < 9) {
            r6.name_00.get(r5).set('1' + CPU.r8().value);
            r5++;
          }

          //LAB_8079534
          r6.name_00.get(r5).set(0);
          r6.name_00.get(14).set(0);
          CPU.r8().value = 0;
          CPU.r10().value = 40;
          CPU.lr().value = r7 + 0x28;
          CPU.r12().value = r7 + 0x30;
          r0 = 0;

          //LAB_8079552
          for(r5 = 0; r5 < 4; r5++) {
            if(MEMORY.ref(2, CPU.lr().value).getUnsigned() != 0) {
              r1 = MEMORY.ref(1, CPU.r12().value).getUnsigned();

              //LAB_807956e
              while(r1 != 0) {
                if(CPU.r8().value < 15) {
                  r6.items_d8.get(r0).set(MEMORY.ref(2, r7 + CPU.r10().value).getUnsigned());
                  r0++;
                  CPU.r8().value++;
                }

                //LAB_8079580
                r1--;
              }
            }

            //LAB_8079586
            CPU.lr().value += 0x2;
            CPU.r10().value += 0x2;
            CPU.r12().value++;
          }

          r6._120.set(MEMORY.ref(4, r7 + 0x20).get());
          r6.class_129.set(0);
          r6.id_128.set(CPU.r11().value);
          FUN_80798e0(CPU.r9().value, r6.powerResist_24);
          recalcStats(CPU.r9().value);
          r6._12a.set(1);

          r3 = r6.id_128.get();
          if(r3 >= 0x9e && r3 <= 0xab) {
            r6._12a.set(2);
          }

          //LAB_80795d8
          r0 = 0x1;
        }
      }
    }

    //LAB_80795da
    CPU.sp().value += 0x24;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80795fc)
  public static int getCharCount() {
    int charCount = 0;

    //LAB_8079602
    for(int flagIndex = 0; flagIndex < 8; flagIndex++) {
      if(readFlag(flagIndex) != 0) {
        charCount++;
      }

      //LAB_807960e
    }

    return charCount;
  }

  @Method(0x807961c)
  public static int addChar(final int charId) {
    final int charCount = getCharCount();
    setFlag(charId);

    //LAB_807963a
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      if(charIds_2000438.get(charSlot).get() == charId) {
        //LAB_807964a
        return charCount;
      }
    }

    //LAB_8079650
    charIds_2000438.get(charCount).set(charId);

    //LAB_807965a
    return charCount + 1;
  }

  @Method(0x8079664)
  public static int removeChar(final int charId) {
    final int r6 = getCharCount();
    clearFlag(charId);

    //LAB_8079688
    int r1;
    for(r1 = 0; r1 < r6 && charIds_2000438.get(r1).get() != charId; r1++) {
      // no-op
    }

    //LAB_8079696
    //LAB_80796a8
    for(int i = r1; i < r6 - 1; i++) {
      charIds_2000438.get(i).set(charIds_2000438.get(i + 1).get());
    }

    //LAB_80796b4
    return getCharCount();
  }

  /**
   * @param out array of shorts, character IDs
   * @return party count
   */
  @Method(0x80796c4)
  public static int getPartyMemberIds(final int out) {
    if(out == 0) {
      return 0;
    }

    final int charCount = getCharCount();

    //LAB_80796e0
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      MEMORY.ref(2, out + charSlot * 0x2).setu(charIds_2000438.get(charSlot).get());
    }

    //LAB_80796ee
    MEMORY.ref(2, out + charCount * 0x2).setu(0xff);

    //LAB_80796f2
    return charCount;
  }

  @Method(0x8079700)
  public static int FUN_8079700(final int amount) {
    final int r3 = clamp(MEMORY.ref(4, 0x2000250).get() + amount, 0, 999999);
    MEMORY.ref(4, 0x2000250).setu(r3);
    return r3;
  }

  @Method(0x80797d4)
  public static int FUN_80797d4(final int r0) {
    if((r0 & 0xffff_ffffL) > (0xf & 0xffff_ffffL)) {
      return 0;
    }

    //LAB_80797de
    return 0x8084a9c + r0 * 0x8;
  }

  @Method(0x80797ec)
  public static int FUN_80797ec(int r0, final int r1) {
    r0 = CPU.lslT(r0, 2);
    r0 = CPU.addT(r0, r1);
    r0 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, 0x8088db8 + r0).get(); //TODO
    return r0;
  }

  @Method(0x80797fc)
  public static int FUN_80797fc(final int r0, final Unit14c.Djinn28 r1, final int[] r2) {
    if(r0 < 8) {
      //LAB_8079838
      //LAB_807983e
      for(int r5 = 0; r5 < 4; r5++) {
        r2[r5] = r1.djinnCounts_24.get(r5).get() * 10;
      }

      //LAB_8079856
      for(int r5 = 0; r5 < 4; r5++) {
        r2[r5] += MEMORY.ref(1, FUN_8078ed8(r0) + 0x90 + r5 + 0x2).getUnsigned();
      }
    } else {
      int r1_0 = MEMORY.ref(1, FUN_80773d8(r0) + 0x34).getUnsigned();
      if(r1_0 > 43) {
        r1_0 = 0;
      }

      //LAB_8079814
      //LAB_8079824
      for(int r5 = 0; r5 < 4; r5++) {
        r2[r5] = MEMORY.ref(1, 0x8088e38 + r1_0 * 0x18 + 0x4 + r5).getUnsigned() * 10;
      }
    }

    //LAB_8079870
    return 0;
  }

  @Method(0x80798e0)
  public static void FUN_80798e0(int r0, final ArrayRef<Unit14c.PowerResist04> r1) {
    final Unit14c r2 = getCharOrMonsterData(r0);
    if(r2.class_129.get() == 0) {
      r0 = MEMORY.ref(1, FUN_80773d8(r2.id_128.get()) + 0x34).getUnsigned();
      if(r0 > 43) {
        r0 = 0;
      }

      //LAB_8079914
      //LAB_8079926
      for(int r7 = 0; r7 < 4; r7++) {
        r1.get(r7).power_00.set(MEMORY.ref(2, 0x8088e38 + r0 * 0x18 + 0x8 + r7 * 0x4).get());
        r1.get(r7).resist_02.set(MEMORY.ref(2, 0x8088e38 + r0 * 0x18 + 0x8 + r7 * 0x4 + 0x2).get());
      }
    } else {
      //LAB_8079932
      final int[] r8 = new int[4];
      FUN_80797fc(r2.id_128.get(), r2.djinn_f8, r8);

      //LAB_8079950
      for(int r7 = 0; r7 < 4; r7++) {
        final int r6 = modS(r8[r7], 10);
        r0 = clamp(divideS(r8[r7], 10), 0, 15);
        r1.get(r7).power_00.set(MEMORY.ref(2, 0x8088df8 + r0 * 0x4).getUnsigned() + r6);
        r1.get(r7).resist_02.set(MEMORY.ref(2, 0x8088df8 + r0 * 0x4 + 0x2).getUnsigned() + r6);
      }
    }

    //LAB_8079994
  }

  @Method(0x80799b0)
  public static int FUN_80799b0(final int r0, final Unit14c.Djinn28 r1) {
    if(r0 > 7) {
      return 0;
    }

    final int[] r6 = new int[4];
    FUN_80797fc(r0, r1, r6);

    if(readFlag(0x20) != 0x0) {
      if(r0 == 0) {
        return 0xc8;
      }

      if(r0 == 1) {
        return 0xc9;
      }
    }

    //LAB_80799ee
    if(r0 == 5) {
      return 0xca;
    }

    int r12 = -1;
    int r5 = -1;

    //LAB_8079a04
    for(int i = 0; i < 4; i++) {
      if(r12 < r6[i]) {
        r12 = r6[i];
        r5 = i;
      }

      //LAB_8079a0e
    }

    int r4 = -1;
    r12 = -1;

    //LAB_8079a1e
    for(int i = 0; i < 4; i++) {
      if(i != r5) {
        if(r12 < r6[i]) {
          r12 = r6[i];
          r4 = i;
        }
      }

      //LAB_8079a2c
    }

    //LAB_8079a46
    final int r11 = FUN_80797ec(r5, r6[r4] > 9 ? r4 : r5);

    //LAB_8079a60
    int r8 = -1;
    for(int i = 0xca; i >= 0; i--) {
      if(MEMORY.ref(4, 0x8084b1c + i * 0x54).get() == r11) {
        //LAB_8079a82
        for(r4 = 0; r4 < 4 && r6[r4] >= MEMORY.ref(1, 0x8084b1c + i * 0x54 + 0x4 + r4).getUnsigned() * 10; r4++) {
          // no-op
        }

        //LAB_8079a9e
        if(r4 == 4) {
          //LAB_8079a42
          r8 = i;
          break;
        }
      }

      //LAB_8079aa2
    }

    //LAB_8079aac
    if(r8 == -1) {
      r8 = 0;
    }

    //LAB_8079ab8
    //LAB_8079aba
    return r8;
  }

  @Method(0x8079ae8)
  public static void FUN_8079ae8(final int r0) {
    final Unit14c r6 = getCharOrMonsterData(r0);
    r6.class_129.set(FUN_80799b0(r6.id_128.get(), r6.djinn_f8));
    FUN_8078bf0(r0);
    FUN_80798e0(r0, r6.powerResist_24);
  }

  @Method(0x8079ad8)
  public static int getClass(final int r0) {
    return 0x8084b1c + r0 * 0x54;
  }

  @Method(0x8079b24)
  public static int FUN_8079b24(final int r0, final int r1) {
    final int r5 = 0x8089258;
    final int r6 = MathHelper.clamp(r0, MEMORY.ref(2, r5 + 0x10).get(), MEMORY.ref(2, r5).get());

    //LAB_8079b48
    //LAB_8079b5c
    int r1_0;
    for(r1_0 = 0; r1_0 < 5 && r6 <= MEMORY.ref(2, r5 + r1_0 * 4).get(); r1_0++) {
      // no-op
    }

    //LAB_8079b78
    int ret;
    if(r1_0 == 5) {
      ret = MEMORY.ref(2, r5 + r1_0 * 4 - 0x2).get();
    } else {
      //LAB_8079b82
      ret = divideS((r6 - MEMORY.ref(2, r5 + r1_0 * 4).get()) * (MEMORY.ref(2, r5 + r1_0 * 4 - 0x2).get() - MEMORY.ref(2, r5 + r1_0 * 4 + 0x2).get()), MEMORY.ref(2, r5 + r1_0 * 4 - 0x4).get() - MEMORY.ref(2, r5 + r1_0 * 4).get()) + MEMORY.ref(2, r5 + r1_0 * 4 + 0x2).get();
    }

    //LAB_8079b9e
    if(r1 == 1) {
      ret /= 2;
    }

    //LAB_8079bae
    return ret + 0x100;
  }

  @Method(0x8079bc4)
  public static int lcgRand() {
    final int r2 = MEMORY.ref(4, 0x20023a8).get();
    final int r0 = r2 * 0x41c64e6d + 0x3039;
    MEMORY.ref(4, 0x20023a8).setu(r0);
    return r0 << 8 >>> 16;
  }

  @Method(0x8079c5c)
  public static int FUN_8079c5c(final int r0, final int r1, final int r2) {
    return r2 * r0 * FUN_8079b24(r1 * 0x2 - 0xc8, 0) / 0x10000;
  }

  @Method(0x807a0cc)
  public static int FUN_807a0cc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x807a1f8)
  public static int FUN_807a1f8(final int charId, final int element, final int djinn) {
    final Unit14c unit = getCharOrMonsterData(charId);
    if(unit.djinn_f8.djinnCounts_20.get(element).get() == 0) {
      return 0;
    }

    if(unit.djinn_f8.djinnCounts_24.get(element).get() > 9) {
      unit.djinn_f8.djinnCounts_24.get(element).set(10);
      return 0;
    }

    //LAB_807a222
    if((unit.djinn_f8.djinn_00.get(element).get() & 0x1 << djinn) == 0 || (unit.djinn_f8.djinn_10.get(element).get() & 0x1 << djinn) != 0) {
      return 0;
    }

    //LAB_807a24a
    final RecoveryQueue10c recoveryQueue = getDjinnRecoveryQueue(charId > 7 ? 1 : 0);

    //LAB_807a26e
    int r4;
    for(r4 = 0; r4 < recoveryQueue.count_108.get() && element != recoveryQueue._08.get(r4).element_00.get() || djinn != recoveryQueue._08.get(r4).djinn_01.get(); r4++) {
      // no-op
    }

    //LAB_807a28c
    if(r4 == recoveryQueue.count_108.get()) {
      return 1;
    }

    final int ret;
    final int r3 = recoveryQueue._08.get(r4)._03.get();
    if(r3 <= 0 && r3 != -2) {
      //LAB_807a2ae
      ret = 1;
    } else {
      //LAB_807a2b2
      ret = 0;
    }

    //LAB_807a2b4
    return ret;
  }

  @Method(0x807a2bc)
  public static int FUN_807a2bc(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x807a2e4)
  public static int setDjinn(final int charId, final int element, final int djinn) {
    final Unit14c unit = getCharOrMonsterData(charId);
    final int r10 = FUN_807a1f8(charId, element, djinn);
    if(r10 == 0 || (unit.djinn_f8.djinn_00.get(element).get() & 0x1 << djinn) == 0) {
      //LAB_807a340
      return 0;
    }

    unit.djinn_f8.djinn_10.get(element).or(0x1 << djinn);
    unit.djinn_f8.djinnCounts_24.get(element).incr();
    FUN_8079ae8(charId);
    return r10;
  }

  @Method(0x807a3a8)
  public static int recoverDjinn(final int charId, final int element, final int djinn) {
    final RecoveryQueue10c r3 = getDjinnRecoveryQueue(charId > 7 ? 1 : 0);

    if(r3.count_108.get() <= 0) {
      return 0;
    }

    //LAB_807a3fe
    int r4;
    for(r4 = 0; r4 < r3.count_108.get() && element != r3._08.get(r4).element_00.get() || djinn != r3._08.get(r4).djinn_01.get(); r4++) {
      // no-op
    }

    if(r4 == r3.count_108.get()) {
      return 0;
    }

    //LAB_807a422
    //LAB_807a438
    for(; r4 < r3.count_108.get() - 1; r4++) {
      MEMORY.memcpy(r3._08.get(r4).getAddress(), r3._08.get(r4 + 1).getAddress(), 0x4);
    }

    r3.count_108.decr();

    //LAB_807a448
    return 1;
  }

  @Method(0x807a5b0)
  public static int FUN_807a5b0(final int r0, final int r1) {
    return MEMORY.ref(2, FUN_807a0cc(r0, r1)).getUnsigned();
  }

  /**
   * @param type -1 for all
   */
  @Method(0x807a5bc)
  public static int getDjinnCount(final int type) {
    CPU.sp().value -= 0x24;

    final int r6 = CPU.sp().value + 0x4;
    final int count = getPartyMemberIds(r6);
    int djinnCount = 0;

    //LAB_807a5d4
    for(int i = 0; i < count; i++) {
      final Unit14c r2 = getCharOrMonsterData(MEMORY.ref(2, r6 + i * 0x2).getUnsigned());
      if(type == -1) {
        djinnCount += r2.djinn_f8.djinnCounts_20.get(0).get() + r2.djinn_f8.djinnCounts_20.get(1).get() + r2.djinn_f8.djinnCounts_20.get(2).get() + r2.djinn_f8.djinnCounts_20.get(3).get();
      } else {
        //LAB_807a60c
        djinnCount += r2.djinn_f8.djinnCounts_20.get(type).get();
      }

      //LAB_807a614
    }

    //LAB_807a61c
    CPU.sp().value += 0x24;
    return djinnCount;
  }
}
