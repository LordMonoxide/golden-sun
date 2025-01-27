package org.goldensun;

import org.goldensun.input.Input;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.Ability10;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Item2c;
import org.goldensun.types.Menua70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Struct5c;
import org.goldensun.types.Structccc;
import org.goldensun.types.Unit14c;

import javax.annotation.Nullable;

import static org.goldensun.CopiedSegment8000770.memfill32;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.GoldenSun.FUN_800352c;
import static org.goldensun.GoldenSun.FUN_80040d0;
import static org.goldensun.GoldenSun.FUN_80045e8;
import static org.goldensun.GoldenSun.FUN_8009290;
import static org.goldensun.GoldenSun.FUN_8009298;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.disableMapTickCallbacks;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.enableMapTickCallbacks;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.boundPsynergy1_2000460;
import static org.goldensun.GoldenSunVars.boundPsynergy2_2000462;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_8015060;
import static org.goldensun.GoldenSun_801.FUN_8015068;
import static org.goldensun.GoldenSun_801.FUN_8015070;
import static org.goldensun.GoldenSun_801.FUN_8015078;
import static org.goldensun.GoldenSun_801.FUN_8015090;
import static org.goldensun.GoldenSun_801.FUN_8015098;
import static org.goldensun.GoldenSun_801.FUN_80150b0;
import static org.goldensun.GoldenSun_801.FUN_80150b8;
import static org.goldensun.GoldenSun_801.FUN_80150c8;
import static org.goldensun.GoldenSun_801.FUN_80150d0;
import static org.goldensun.GoldenSun_801.FUN_80150d8;
import static org.goldensun.GoldenSun_801.FUN_80150e0;
import static org.goldensun.GoldenSun_801.FUN_8015108;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015278;
import static org.goldensun.GoldenSun_801.FUN_8015280;
import static org.goldensun.GoldenSun_801.FUN_8015298;
import static org.goldensun.GoldenSun_801.FUN_80152a8;
import static org.goldensun.GoldenSun_801.FUN_80153c8;
import static org.goldensun.GoldenSun_801.FUN_80153d0;
import static org.goldensun.GoldenSun_801.FUN_80153d8;
import static org.goldensun.GoldenSun_801.FUN_80153e0;
import static org.goldensun.GoldenSun_801.FUN_8015410;
import static org.goldensun.GoldenSun_801.FUN_8015418;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawIcon_;
import static org.goldensun.GoldenSun_801.drawNumber_;
import static org.goldensun.GoldenSun_801.drawPanelBackground_;
import static org.goldensun.GoldenSun_807.FUN_8077190;
import static org.goldensun.GoldenSun_807.FUN_80771a8;
import static org.goldensun.GoldenSun_807.FUN_80771b8;
import static org.goldensun.GoldenSun_807.FUN_80771c8;
import static org.goldensun.GoldenSun_807.FUN_80771d0;
import static org.goldensun.GoldenSun_807.isDjinnSet_;
import static org.goldensun.GoldenSun_807.FUN_8077210;
import static org.goldensun.GoldenSun_807.FUN_80772c0;
import static org.goldensun.GoldenSun_807.addArtifact_;
import static org.goldensun.GoldenSun_807.addItem_;
import static org.goldensun.GoldenSun_807.addPp_;
import static org.goldensun.GoldenSun_807.breakItem_;
import static org.goldensun.GoldenSun_807.calcHpPpFractions;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.equipItem_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.isEquipped_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.recoverDjinn_;
import static org.goldensun.GoldenSun_807.setDjinn_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_807.takeItem_;
import static org.goldensun.GoldenSun_808.FUN_808a288;
import static org.goldensun.GoldenSun_808.FUN_808a488;
import static org.goldensun.GoldenSun_808.FUN_808a490;
import static org.goldensun.GoldenSun_808.FUN_808a548;
import static org.goldensun.GoldenSun_80b.FUN_80b0040;
import static org.goldensun.GoldenSun_80b.tickRecoveryQueue_;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80a {
  private GoldenSun_80a() { }

  /** {@link GoldenSun_80a#handleItemMenu} */
  @Method(0x80a1000)
  public static int handleItemMenu_() {
    return (int)MEMORY.call(0x80a24d0);
  }

  /** {@link GoldenSun_80a#handlePsynergyMenu} */
  @Method(0x80a1008)
  public static int handlePsynergyMenu_() {
    return (int)MEMORY.call(0x80a5b94);
  }

  /** {@link GoldenSun_80a#handleStatusMenu} */
  @Method(0x80a1010)
  public static int handleStatusMenu_() {
    return (int)MEMORY.call(0x80a7478);
  }

  /** {@link GoldenSun_80a#FUN_80a1870} */
  @Method(0x80a1028)
  public static void FUN_80a1028(final Panel24 r0, final int x, final int y, final int r3) {
    MEMORY.call(0x80a1870, r0, x, y, r3);
  }

  /** {@link GoldenSun_80a#FUN_80a195c} */
  @Method(0x80a1030)
  public static void FUN_80a1030() {
    MEMORY.call(0x80a195c);
  }

  /** {@link GoldenSun_80a#FUN_80a17c4} */
  @Method(0x80a1038)
  public static void FUN_80a1038(@Nullable final GraphicsStruct1c r0) {
    MEMORY.call(0x80a17c4, r0);
  }

  /** {@link GoldenSun_80a#handleDjinnMenu} */
  @Method(0x80a1040)
  public static int handleDjinnMenu_() {
    return (int)MEMORY.call(0x80aa56c);
  }

  @Method(0x80a1050)
  public static void FUN_80a1050() {
    enableMapTickCallbacks();
    FUN_8009298();
    clearFlag_(0x166);
    clearFlag_(0x152);
  }

  @Method(0x80a1070)
  public static void FUN_80a1070() {
    setFlag_(0x152);
    setFlag_(0x166);
    FUN_8009290();
    disableMapTickCallbacks();
  }

  @Method(0x80a1090)
  public static void FUN_80a1090() {
    final Menua70 r4 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4.getAddress());
    DMA.channels[3].CNT.setu(0x8500029c);
    CPU.sp().value += 0x4;

    r4._1c.get(0).set(-1);
    r4._1e.get(0).set(0x1);
    r4._1e.get(1).set(0x1);
    r4._112.set(0x1);
    r4._113.set(0x1);
  }

  @Method(0x80a10d0)
  public static int FUN_80a10d0(final Pointer<Panel24> panelRef, final int x, final int y, final int w, final int h, final int flags) {
    final Panel24 panel = panelRef.derefNullable();
    if(panel != null) {
      if((flags & 0x100) == 0) {
        //LAB_80a10ee
        drawPanelBackground_(panel);
      }
      return 0;
    }

    //LAB_80a10f6
    panelRef.set(addPanel_(x, y, w, h, flags & 0xff));

    //LAB_80a110c
    return 1;
  }

  @Method(0x80a1114)
  public static void FUN_80a1114(final Pointer<Panel24> r0, final int r1) {
    final Panel24 panel = r0.derefNullable();
    if(panel != null) {
      FUN_8015018(panel, r1);
      r0.clear();
    }

    //LAB_80a1126
  }

  @Method(0x80a112c)
  public static void drawCharInfoPanel(final Panel24 r0, final int charId, final int itemSlot, final int mode) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Unit14c chr = getUnit_(charId);
    final int itemId = chr.items_d8.get(itemSlot).get();
    final Item2c item = getItem_(itemId & 0x1ff);

    final int sp14;
    if((mode & 0x100) == 0) {
      sp14 = FUN_80a10d0(menu.panel_24, 0, 5, 13, 12, 0x102);
    } else {
      sp14 = 0;
    }

    //LAB_80a118e
    final Panel24 panel = menu.panel_24.deref();
    if((mode & 0x100) == 0) {
      if(sp14 == 0) {
        sleep(1);
        FUN_8015068(panel, 0, 0, 88, 32);
      }

      //LAB_80a11b4
      FUN_8015090(chr.name_00.getAddress(), panel, 32, 0);

      final boolean[] afflictions = new boolean[5];
      getAfflictions(afflictions, true, charId);

      int iconCount = 0;
      if(afflictions[1]) {
        drawIcon_(0xbd6, panel, 32, 8);
        iconCount++;
      }

      //LAB_80a11e2
      if(afflictions[2]) {
        drawIcon_(0xbd7, panel, 32, 8 + iconCount * 8);
        iconCount++;
      }

      //LAB_80a11f8
      if(afflictions[3]) {
        drawIcon_(0xbd8, panel, 32, 8 + iconCount * 8);
        iconCount++;
      }

      //LAB_80a120e
      if(afflictions[4]) {
        drawIcon_(0xbd9, panel, 32, 8 + iconCount * 8);
        iconCount++;
      }

      //LAB_80a1224
      if(iconCount <= 1) {
        FUN_8015090(0x80af20c, panel, 40, 16);
        FUN_80150b0(chr.level_0f.get(), 4, panel, 56, 16);
      }
    }

    //LAB_80a1248
    if(sp14 == 0) {
      sleep(1);
      FUN_8015068(panel, 0, 32, 88, 80);
    }

    //LAB_80a1266
    FUN_8015278(panel);

    if((mode & 0x100) == 0) {
      menu._17c.set(FUN_80150d8(charId, 0, 0, panel, 0, 0));
    }

    //LAB_80a1290
    final int r4;
    switch(mode & 0xff) {
      case 0: // draw char info
        drawIcon_(chr.class_129.get() + 0x741, panel, 0, 32);
        FUN_80a153c(chr, panel);
        drawIcon_(0xb0e, panel, 0, 64);
        FUN_80150b0(chr.exp_124.get(), 8, panel, 24, 72);
        break;

      case 6:
        drawIcon_(chr.class_129.get() + 0x741, panel, 0, 32);
        FUN_80a153c(chr, panel);
        break;

      case 2: // draw equipment differences
      case 3:
        if(isEquipped_(charId, itemId) == 0) {
          drawIcon_(0xb21, panel, 0, 48);
        } else {
          //LAB_80a1346
          final Unit14c charData2 = MEMORY.ref(4, mallocChip(0x14c), Unit14c::new);
          MEMORY.call(0x3001388, charData2.getAddress(), chr.getAddress(), 0x14c); // memcpy

          if(menu._25c.get() != 0) {
            chr.items_d8.get(itemSlot).and(~0x200);
          } else {
            //LAB_80a137e
            equipItem_(charId, itemSlot);
          }

          //LAB_80a1386
          recalcStats_(charId);
          drawEquipmentComparison(chr, charData2, panel);
          MEMORY.call(0x3001388, chr.getAddress(), charData2.getAddress(), 0x14c); // memcpy
          setMallocAddress(charData2.getAddress());
        }
        break;

      case 4:
        r4 = item.useAbility_28.get();
        int i = 0;
        int r0_0 = 1;

        //LAB_80a13c0
        while((chr.psynergy_58.get(i).get() & 0x3fff) != r4) {
          i++;
          if(i > 0x1f) {
            r0_0 = 0;
            break;
          }
        }

        //LAB_80a13d8
        drawIcon_(r4 + 0x333, panel, 0, 48);

        if(r0_0 != 0) {
          drawIcon_(0xb23, panel, 0, 56);
        } else {
          //LAB_80a13ee
          drawIcon_(0xb22, panel, 0, 56);
        }

        //LAB_80a13fe
        break;

      case 8: // draw char stats
        drawIcon_(0xb1c, panel, 0, 40);
        FUN_80150b0(chr.attack_3c.get(), 3, panel, 64, 40);
        drawIcon_(0xb1d, panel, 0, 48);
        FUN_80150b0(chr.defence_3e.get(), 3, panel, 64, 48);
        drawIcon_(0xb20, panel, 0, 56);
        FUN_80150b0(chr.agility_40.get(), 3, panel, 64, 56);
        drawIcon_(0xb1f, panel, 0, 64);
        FUN_80150b0(chr.luck_42.get(), 3, panel, 64, 64);
        break;
    }

    //LAB_80a1490
  }

  @Method(0x80a14f0)
  public static void FUN_80a14f0(int r0, final Panel24 r1, final int r2, final int r3) {
    final int r7 = r0;
    int r5 = 1;

    //LAB_80a1506
    while(r5 < 16 && (r0 = divideS(r0, 10)) > 9) {
      r5++;
    }

    //LAB_80a1516
    r5++;
    drawNumber_(r7, r5, r1, r2 - r5 * 8, r3);
  }

  @Method(0x80a153c)
  public static void FUN_80a153c(final Unit14c unit, final Panel24 panel) {
    FUN_8015090(0x80af210, panel, 0, 0x28);
    FUN_8015098(0x80af214, panel, 0x30, 0x28);
    FUN_80a14f0(unit.maxHp_34.get(), panel, 0x58, 0x28);

    final int r5 = unit.hp_38.get();
    if(r5 < unit.maxHp_34.get() / 4) {
      FUN_80150b8(0x4);
    }

    //LAB_80a1584
    if(r5 == 0) {
      FUN_80150b8(0x2);
    }

    //LAB_80a158e
    FUN_80a14f0(r5, panel, 0x30, 0x28);
    FUN_80150b8(0xf);
    FUN_8015090(0x80af218, panel, 0, 0x30);
    FUN_8015098(0x80af214, panel, 0x30, 0x30);
    FUN_80a14f0(unit.pp_3a.get(), panel, 0x30, 0x30);
    FUN_80a14f0(unit.maxPp_36.get(), panel, 0x58, 0x30);
  }

  @Method(0x80a15f0)
  public static void drawEquipmentComparison(final Unit14c before, final Unit14c after, final Panel24 panel) {
    drawIcon_(0xb1c, panel, 0, 32);
    drawNumber_(after.attack_3c.get(), 0x3, panel, 16, 40);

    if(before.attack_3c.get() != after.attack_3c.get()) {
      drawNumber_(before.attack_3c.get(), 0x3, panel, 64, 40);

      if(before.attack_3c.get() > after.attack_3c.get()) {
        drawComparisonArrow(panel, 44, 36, 0);
      } else {
        //LAB_80a164c
        drawComparisonArrow(panel, 44, 36, 1);
      }
    }

    //LAB_80a1658
    drawIcon_(0xb1d, panel, 0, 48);
    drawNumber_(after.defence_3e.get(), 3, panel, 16, 56);

    if(before.defence_3e.get() != after.defence_3e.get()) {
      drawNumber_(before.defence_3e.get(), 3, panel, 64, 56);

      if(before.defence_3e.get() > after.defence_3e.get()) {
        drawComparisonArrow(panel, 44, 52, 0);
      } else {
        //LAB_80a16a4
        drawComparisonArrow(panel, 44, 52, 1);
      }
    }

    //LAB_80a16b0
    drawIcon_(0xb20, panel, 0, 64);
    drawNumber_(after.agility_40.get(), 3, panel, 16, 72);

    if(before.agility_40.get() != after.agility_40.get()) {
      drawNumber_(before.agility_40.get(), 3, panel, 64, 72);

      if(before.agility_40.get() > after.agility_40.get()) {
        drawComparisonArrow(panel, 44, 68, 0);
      } else {
        //LAB_80a1704
        drawComparisonArrow(panel, 44, 68, 1);
      }
    }

    //LAB_80a1710
  }

  @Method(0x80a1778)
  public static GraphicsStruct1c FUN_80a1778(final Panel24 panel, final int x, final int y) {
    final int slot = getFreeVramSlot();
    if(slot == 0) {
      return null;
    }

    allocateSpriteSlot(slot, 0x80, 0x80aea4c);
    return FUN_80150c8(slot, 0x40000000, panel, x, y);
  }

  @Method(0x80a17c4)
  public static void FUN_80a17c4(@Nullable final GraphicsStruct1c r0) {
    if(r0 != null) {
      r0._05.set(0x1);
      r0.packet_10.attribs_04.attrib1_02.and(~0x1ff).or(r0.x_06.get() & 0x1ff);
      r0.packet_10.attribs_04.y_00.set(r0.y_08.get() & 0xff);
      r0.packet_10.attribs_04.flags_01.and(~0x3);
      r0.packet_10.attribs_04.attrib1_02.and(~0x3e00);
    }

    //LAB_80a17f6
  }

  @Method(0x80a1804)
  public static void FUN_80a1804(final Menua70 r0, final int r1) {
    FUN_80150e0(0, r1, 0);
  }

  @Method(0x80a1814)
  public static Panel24 FUN_80a1814(final Menua70 r0) {
    r0.panel_10.clear();
    FUN_80a10d0(r0.panel_10, 0, 0, 0xd, 0x5, 0x2);
    final Panel24 r6 = r0.panel_10.deref();
    final GraphicsStruct1c r0_0 = FUN_80a1778(r6, -8, 0xb);
    r0_0._05.set(0xd);
    r0._1c.get(0).set(-1);
    r0._1c.get(1).set(0);
    r0._14.get(0).set(r0_0);
    r0_0.z_0f.set(0xfe);

    // Retail NPE
    if(!r0._14.get(1).isNull()) {
      r0._14.get(1).deref().z_0f.set(0xff);
    }

    return r6;
  }

  @Method(0x80a1870)
  public static void FUN_80a1870(final Panel24 r0, final int x, final int y, final int r3) {
    CPU.sp().value -= 0x1c;

    final int r10 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    final int sp00 = CPU.sp().value;
    final int charCount = getPartyMemberIds_(sp00);
    MEMORY.ref(1, r10 + 0x1e).setu(charCount);

    //LAB_80a18b8
    int charSlot;
    for(charSlot = 0; charSlot < charCount; charSlot++) {
      final Sprite38 sprite = loadSprite_(FUN_808a288(MEMORY.ref(2, sp00 + charSlot * 0x2).getUnsigned()));
      if(sprite != null) {
        final int r6 = r10 + 0x114 + charSlot * 0x4;
        final int r7 = r10 + 0x134 + charSlot * 0x2;
        MEMORY.ref(4, r6).setu(sprite.getAddress());
        MEMORY.ref(2, r7).setu((x + r0.x_0c.get()) * 0x8 + (r3 + 16) * charSlot);
        MEMORY.ref(2, r7 + 0x10).setu((y + r0.y_0e.get()) * 0x8 + 0x10);
        MEMORY.ref(4, r6 + 0x40).setu(0x10000);
        sprite.packet_00.attribs_04.attrib2_04.and(~0xc00);
        sprite._26.set(0);
        setSpriteAnimation_(sprite, 1);
      }

      //LAB_80a190e
    }

    //LAB_80a191c
    //LAB_80a1930
    for(; charSlot < 8; charSlot++) {
      MEMORY.ref(4, r10 + 0x114 + charSlot * 0x4).setu(0);
    }

    //LAB_80a1938
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"), 0xc80);

    CPU.sp().value += 0x1c;
  }

  @Method(0x80a195c)
  public static void FUN_80a195c() {
    CPU.sp().value -= 0x1c;
    final int r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).get() + 0x114;
    final int r5 = getPartyMemberIds_(CPU.sp().value);

    //LAB_80a197a
    for(int i = 0; i < r5; i++) {
      final Sprite38 r0 = MEMORY.ref(4, r6 + i * 0x4).deref(4).cast(Sprite38::new);

      if(r0 != null) {
        clearSprite_(r0);
      }

      //LAB_80a1984
    }

    //LAB_80a198a
    clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"));
    CPU.sp().value += 0x1c;
  }

  @Method(0x80a19a0)
  public static void FUN_80a19a0() {
    CPU.sp().value -= 0x1c;
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int charCount = getCharCount_();
    final int r8 = CPU.sp().value + 0x4;
    final int r6 = CPU.sp().value + 0xc;

    //LAB_80a19d0
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      final int r1 = 0x1e20000 - (r5._144.get(charSlot).get() << 16);

      final Sprite38 r0 = r5.charSprites_114.get(charSlot).derefNullable();
      if(r0 != null) {
        r0.packet_00.attribs_04.attrib2_04.and(~0xc00);
        MEMORY.ref(4, r8).setu(r5._154.get(charSlot).get());
        MEMORY.ref(4, r8 + 0x4).setu(r5._154.get(charSlot).get());
        MEMORY.ref(4, r6).setu(r5._134.get(charSlot).get() << 16);
        MEMORY.ref(4, r6 + 0x4).setu(r1);
        MEMORY.ref(4, r6 + 0x8).setu((r5._144.get(charSlot).get() << 16) + r1);
        MEMORY.ref(4, r6 + 0xc).setu(0);
        drawSprite_(r0, r6, r8, 0x4000);
      }

      //LAB_80a1a24
    }

    //LAB_80a1a2e
    CPU.sp().value += 0x1c;
  }

  @Method(0x80a1a40)
  public static void FUN_80a1a40(final int x, final int y) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Panel24 panel = menu.panel_10.deref();
    final GraphicsStruct1c r4 = menu._14.get(0).deref();
    r4.x_06.set(MEMORY.ref(1, 0x80af294 + (_3001e40.get() >>> 1 & 0x7)).getUnsigned() + x + panel.x_0c.get() * 8 + 8);
    r4.y_08.set(MEMORY.ref(1, 0x80af29d + (_3001e40.get() >>> 1 & 0x7)).getUnsigned() + y + panel.y_0e.get() * 8 + 8);
    r4.packet_10.attribs_04.attrib1_02.and(~0x1ff).or(r4.x_06.get() & 0x1ff);
    r4.packet_10.attribs_04.y_00.set(r4.y_08.get() & 0xff);
  }

  @Method(0x80a1ac0)
  public static void FUN_80a1ac0(int r0, final int r1) {
    final Menua70 r10 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r3 = r10._222.get();
    int r8 = r1;
    int r9 = 0x2;
    if(r3 != 0) {
      r10._222.set(0);
    } else {
      //LAB_80a1af4
      final GraphicsStruct1c r7 = r10._14.get(0).deref();
      r3 = r7.packet_10.attribs_04.attrib1_02.get();
      r3 = CPU.lslT(r3, 23);
      r3 = CPU.lsrT(r3, 23);
      r3 = CPU.addT(r3, 0x40);
      r7.x_06.set(r3);
      r7.y_08.set(r7.packet_10.attribs_04.y_00.get() + 0x40);
      r8 += 0x40;
      r0 = r0 + 0x40;
      if(r7.x_06.get() - 8 > 0) {
        r7.x_06.sub(8);
      }

      //LAB_80a1b1e
      if(r7.y_08.get() - 8 > 0) {
        r7.y_08.sub(8);
      }

      //LAB_80a1b30
      int r5 = r7.x_06.get();
      r0 = CPU.lslT(r0, 4);
      r5 = CPU.lslT(r5, 4);
      r0 = CPU.subT(r0, r5);
      r0 = CPU.addT(r0, 0x1);
      r0 = divideS(r0, 2);
      final int r11 = r0;
      int r6 = r7.y_08.get() * 0x10;
      r0 = r8 * 0x10 - r6 + 1;
      r0 = divideS(r0, 2);
      r8 = r0;

      //LAB_80a1b56
      do {
        r5 += r11;
        r6 += r8;

        final Panel24 panel = r10.panel_10.deref();
        final int x = panel.x_0c.get() * 8 + r5 / 16 - 56;
        r7.x_06.set(x);
        r7.packet_10.attribs_04.attrib1_02.and(~0x1ff).or(x & 0x1ff);
        final int y = panel.y_0e.get() * 8 + r6 / 16 - 56;
        r7.y_08.set(y);
        r7.packet_10.attribs_04.y_00.set(y & 0xffff);

        r9--;
        if(r9 == 0) {
          break;
        }
        sleep(1);
      } while(true);
    }

    //LAB_80a1bb6
  }

  @Method(0x80a1bdc)
  public static void FUN_80a1bdc(final int r0, final int r1, final int r2) {
    final ArrayRef<Pointer<GraphicsStruct1c>> r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a1bfa
    for(int r6 = 0; r6 < 0x20; r6++) {
      if(!r5.get(r6).isNull()) {
        FUN_80a1c2c(r5.get(r6), r6, r0, r1, r2);
      }
    }
  }

  @Method(0x80a1c2c)
  public static void FUN_80a1c2c(final Pointer<GraphicsStruct1c> r0, final int r1, final int r2, final int r3, final int a4) {
    int r6 = r1;
    if(r6 > 0x1f) {
      r6 = 0;
    }

    //LAB_80a1c3e
    final GraphicsStruct1c r5 = r0.deref();
    r5.y_08.set(r3 + divideS(r6, a4) * 0x10);
    r5.x_06.set(r2 + modS(r6, a4) * 0x10);
    FUN_80a17c4(r5);
  }

  @Method(0x80a1c6c)
  public static void FUN_80a1c6c(final Pointer<GraphicsStruct1c> r0, final int r1, final int x, final int y, final int a4) {
    int r6 = r1;
    if(r6 > 15) {
      r6 = 0;
    }

    //LAB_80a1c7e
    final GraphicsStruct1c r5 = r0.deref();
    r5.x_06.set(modS(r6, a4) * 24 + x);
    r5.y_08.set(divideS(r6, a4) * 16 + y);
    FUN_80a17c4(r5);
  }

  @Method(0x80a1cb0)
  public static void FUN_80a1cb0(final int r0) {
    final ArrayRef<Pointer<GraphicsStruct1c>> r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a1cd6
    for(int r6 = 0; r6 < 15; r6++) {
      if(!r5.get(r6).isNull()) {
        FUN_80a1c6c(r5.get(r6), r6, 0x74, r0 != 1 ? 0x28 : 0x38, 0x5);
      }
    }
  }

  @Method(0x80a1d08)
  public static void FUN_80a1d08(final int r0, final int r1, final int r2) {
    CPU.sp().value -= 0x18;

    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r7._14.get(0).deref()._05.set(0xd);

    final Panel24 r5;
    if(r2 != -1) {
      FUN_8015108(r0, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8);
      if(FUN_80a10d0(r7.panel_3c, r1, r2, MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0x102) == 0) {
        setPanelMetrics(r7.panel_3c.deref(), r1, r2, MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
      }

      //LAB_80a1d68
      r5 = r7.panel_3c.deref();
    } else {
      //LAB_80a1d6c
      r5 = r7.panel_2c.deref();
    }

    //LAB_80a1d6e
    drawPanelBackground_(r5);
    FUN_8015278(r5);
    if(r2 == -1) {
      drawIcon_(r0, r5, 0, 0);
    } else {
      //LAB_80a1d90
      FUN_8015078(r0, r5, 0, 0);
    }

    //LAB_80a1d9c
    if(r1 != -1) {
      sleep(1);

      //LAB_80a1db0
      do {
        sleep(1);
      } while((pressedButtons_3001c94.get() & 0x1) == 0 && (pressedButtons_3001c94.get() & 0x2) == 0 && (pressedButtons_3001c94.get() & 0x8) == 0);

      //LAB_80a1dd4
      if(r2 == -1) {
        drawPanelBackground_(r5);
      }

      //LAB_80a1de2
      FUN_8015278(r5);
    } else {
      //LAB_80a1df4
      setFlag_(0x151);
    }

    //LAB_80a1dfa
    r7._222.set(0x1);
    r7._14.get(0).deref()._05.set(0x1);
    if(r2 != -1) {
      FUN_80a1114(r7.panel_3c, 0x1);
    }

    //LAB_80a1e28
    CPU.sp().value += 0x18;
  }

  @Method(0x80a1e38)
  public static int FUN_80a1e38(final ArrayRef<UnsignedShortRef> r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a1fd4)
  public static int FUN_80a1fd4(int r0, int r1, int r2, int r3, final int a4) {
    final int r4;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.r8().value = r1;
    r5 = r0;
    r7 = r2;
    r2 = CPU.r8().value;
    r6 = r3;
    CPU.r10().value = a4;
    r0 = -1;
    if(r2 != 0) {
      //LAB_80a1ff6
      FUN_8015418(0x6002500);
      CPU.r9().value = divideS(CPU.r8().value, r7);

      if(modS(CPU.r8().value, r7) != 0) {
        CPU.r9().value++;
      }

      //LAB_80a2016
      if(r5 != 0) {
        r4 = pressedButtons_3001b04.get() & 0x10;
        r1 = pressedButtons_3001b04.get() & 0x20;
        r5 = pressedButtons_3001b04.get() & 0x40;
        r2 = pressedButtons_3001b04.get();
        r3 = 0x80;
      } else {
        //LAB_80a2034
        r4 = pressedButtons_3001b04.get() & 0x80;
        r1 = pressedButtons_3001b04.get() & 0x40;
        r5 = pressedButtons_3001b04.get() & 0x20;
        r2 = pressedButtons_3001b04.get();
        r3 = 0x10;
      }

      //LAB_80a204c
      r2 = r2 & r3;
      if(r5 == 0) {
        //LAB_80a2084
        if(r2 != 0) {
          playSound_(0x6f);
          MEMORY.ref(4, CPU.r10().value).incr();
          if(MEMORY.ref(4, CPU.r10().value).get() > CPU.r9().value - 1) {
            MEMORY.ref(4, CPU.r10().value).setu(r5);
          }

          //LAB_80a20a2
          r1 = CPU.r10().value;
          r3 = MEMORY.ref(4, r1).get();
          r0 = r7;
          r0 = r0 * r3;
          r3 = MEMORY.ref(4, r6).get();
          r2 = CPU.r8().value;
          r3 = r3 + r0;
          r2 = r2 - 0x1;
          CPU.cmpT(r3, r2);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r2 = CPU.r8().value;
            r3 = r2 - r0;

            //LAB_80a20ba
            r3 = r3 - 0x1;
            r1 = r7 - 0x1;
            MEMORY.ref(4, r6).setu(r3);
            CPU.cmpT(r3, r1);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              MEMORY.ref(4, r6).setu(r1);
            }
          }

          //LAB_80a20c6
          FUN_800352c();
          r0 = 0x1;
        } else {
          //LAB_80a20ce
          CPU.cmpT(r1, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = 0x6f;
            playSound_(r0);
            r3 = MEMORY.ref(4, r6).get();
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6).setu(r3);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r2 = r7 - 0x1;
              MEMORY.ref(4, r6).setu(r2);
              r1 = CPU.r10().value;
              r3 = MEMORY.ref(4, r1).get();
              r3 = r3 * r7;
              r1 = CPU.r8().value;
              r3 = r1 - r3;
              r3 = r3 - 0x1;
              MEMORY.ref(4, r6).setu(r3);
              CPU.cmpT(r3, r2);
              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                MEMORY.ref(4, r6).setu(r2);
              }
            }
            r0 = 0x0;
          } else {
            //LAB_80a20fc
            r0 = 0x1;
            r0 = -r0;
            CPU.cmpT(r4, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = 0x6f;
              playSound_(r0);
              r2 = MEMORY.ref(4, r6).get();
              r2 = r2 + 0x1;
              MEMORY.ref(4, r6).setu(r2);
              r1 = CPU.r10().value;
              r3 = MEMORY.ref(4, r1).get();
              r3 = r3 * r7;
              r1 = CPU.r8().value;
              r3 = r1 - r3;
              r0 = 0x0;
              CPU.cmpT(r2, r3);
              if(CPU.cpsr().getZero()) { // ==
                MEMORY.ref(4, r6).setu(r0);
              }

              //LAB_80a2122
              r3 = MEMORY.ref(4, r6).get();
              r2 = r7 - 0x1;
              CPU.cmpT(r3, r2);
              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                MEMORY.ref(4, r6).setu(r0);
              }

              //LAB_80a212c
              r0 = 0x0;
            }
          }
        }
      } else {
        r0 = 0x6f;
        playSound_(r0);
        r1 = CPU.r10().value;
        r3 = MEMORY.ref(4, r1).get();
        r3 = r3 - 0x1;
        MEMORY.ref(4, r1).setu(r3);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = CPU.r9().value;
          r3 = r3 - 0x1;
          MEMORY.ref(4, r1).setu(r3);
        }

        //LAB_80a206a
        r2 = CPU.r10().value;
        r3 = MEMORY.ref(4, r2).get();
        r0 = r7;
        r0 = r0 * r3;
        r3 = MEMORY.ref(4, r6).get();
        r2 = CPU.r8().value;
        r3 = r3 + r0;
        r2 = r2 - 0x1;
        CPU.cmpT(r3, r2);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r1 = CPU.r8().value;
          r3 = r1 - r0;
          r3 = r3 - 0x1;
          r1 = r7 - 0x1;
          MEMORY.ref(4, r6).setu(r3);
          CPU.cmpT(r3, r1);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            MEMORY.ref(4, r6).setu(r1);
          }
        }
        FUN_800352c();
        r0 = 0x1;
      }
    }

    //LAB_80a212e
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0;
  }

  @Method(0x80a2144)
  public static void FUN_80a2144(final int r0) {
    final int r5 = 0x5000000 + r0 * 0x20;
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x80000010);
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x84000008);

    final int colour = MEMORY.ref(2, r5 + 0x8).getUnsigned();
    MEMORY.ref(2, r5 + 0x8).setu(Math.min((colour >>> 10 & 0x1f) + 9, 0x1f) << 10 | Math.min((colour >>> 5 & 0x1f) + 9, 0x1f) << 5 | Math.min((colour & 0x1f) + 9, 0x1f));
  }

  @Method(0x80a21b0)
  public static void FUN_80a21b0(final Panel24 r0, final int r1, final int r2, final int r3, final int a4) {
    int r8 = divideS(r1, r2);
    if(modS(r1, r2) != 0) {
      r8++;
    }

    //LAB_80a21e8
    int r7 = a4 - r8;
    if(r8 > 1) {
      int r5 = 0;
      FUN_8015280(r0, 0xf128, r7 - 1, -1, 0);

      //LAB_80a2208
      while(r5 < r8) {
        if(r5 == r3) {
          FUN_8015280(r0, 0x31 + r5, r7, -1, 2);
        } else {
          //LAB_80a221e
          FUN_8015280(r0, 0x31 + r5, r7, -1, 3);
        }

        //LAB_80a222e
        r5++;
        r7++;
      }

      //LAB_80a223a
      FUN_8015280(r0, 0xf129, r7, -1, 0);
    }

    //LAB_80a224c
  }

  @Method(0x80a2268)
  public static void FUN_80a2268(final Panel24 r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r5;
    int r6;
    r6 = r3;
    final Struct12fc r12 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r1 = r1 + r0.x_0c.get() + 1;
    r2 = r2 + r0.y_0e.get() + 1;
    r5 = a4;
    if(r1 < 0) {
      r6 = r6 + r1;
      r1 = 0x0;
    }

    //LAB_80a228c
    r3 = r1 + r6;
    if(r3 > 0x1d) {
      r3 = 0x1e;
      r6 = r3 - r1;
    }

    //LAB_80a2296
    if(r2 < 0) {
      r5 = r5 + r2;
      r2 = 0x0;
    }

    //LAB_80a229e
    r3 = r2 + r5;
    if(r3 > 0x1d) {
      r5 = 0x14 - r2;
    }

    //LAB_80a22a8
    if(r6 > 0 && r5 > 0) {
      r1 = r2 * 0x40 + r1 * 0x2;

      //LAB_80a22b6
      while(r5 != 0) {
        //LAB_80a22c2
        for(int i = 0; i < r6; i++) {
          MEMORY.ref(2, r12._00.getAddress() + r1 + i * 0x2).and(~0x1000).oru(a5 << 12);
        }

        //LAB_80a22d2
        r5 = r5 - 0x1;
        r1 = r1 + 0x40;
      }

      r12._ea3.set(1);
    }

    //LAB_80a22e2
  }

  @Method(0x80a22f4)
  public static void FUN_80a22f4() {
    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(0x50001c0);
    DMA.channels[3].CNT.setu(0x80000010);
    DMA.channels[3].SAD.setu(0x50001e8);
    DMA.channels[3].DAD.setu(0x50001dc);
    DMA.channels[3].CNT.setu(0x80000001);
  }

  @Method(0x80a2324)
  public static void FUN_80a2324(final int r0, final int r1, final Panel24 r2, final int x, final int y) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80a233e
    for(int r6 = 0; r6 < 0x20; r6++) {
      final GraphicsStruct1c r5 = r8._48.get(r6).derefNullable();
      if(r5 != null) {
        r5._05.set(0xd);
      }

      //LAB_80a2346
    }

    int r6 = r1;
    int r7 = y;
    GraphicsStruct1c r5;

    //LAB_80a237a
    while(r6 < r0 + r1 && (r5 = r8._48.get(r6).derefNullable()) != null && r6 < r8.itemCount_218.get()) {
      r5.x_06.set(x);
      r5.y_08.set(r7);
      FUN_80a17c4(r5);
      r5._05.set(0x1);
      r7 += 0x10;
      r6++;
    }

    //LAB_80a23ac
  }

  @Method(0x80a23c0)
  public static void FUN_80a23c0(final Panel24 r0) {
    drawNumber_(MEMORY.ref(4, 0x2000250).get(), 7, r0, 8, 0);
    drawIcon_(0xb0b, r0, 0x40, 0);
  }

  @Method(0x80a23f4)
  public static void setPanelMetrics(@Nullable final Panel24 panel, final int x, final int y, final int w, final int h) {
    if(panel != null) {
      panel.w_08.set(w);
      panel.h_0a.set(h);
      panel.x_0c.set(x);
      panel.y_0e.set(y);
    }

    //LAB_80a2404
  }

  @Method(0x80a2438)
  public static int FUN_80a2438(final int soundId) {
    playSound_(soundId);
    return 1;
  }

  @Method(0x80a2444)
  public static void FUN_80a2444() {
    if((pressedButtons_3001c94.get() & Input.BUTTON_START) != 0) {
      playSound_(0x71);
      setFlag_(0x150);
      clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a2444"));
    }

    //LAB_80a2466
  }

  @Method(0x80a2474)
  public static void FUN_80a2474() {
    clearFlag_(0x150);
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a2444"), 0xc80);
  }

  @Method(0x80a2490)
  public static void FUN_80a2490() {
    if(readFlag_(0x150) == 0) {
      clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a2444"));
    }

    //LAB_80a24a4
  }

  @Method(0x80a24d0)
  public static int handleItemMenu() {
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);

    CPU.r9().value = 0x2000;
    CPU.sp().value -= 0x10;
    final int r7 = mallocBoard(CPU.r9().value);
    final int r5 = mallocSlotChip(55, 0xa70);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(0x1);
    drawPanelBackground_(0, 0, 30, 20);
    sleep(1);
    FUN_80a1090();
    MEMORY.ref(1, r5 + 0x219).setu(getPartyMemberIds_(r5 + 0x208));
    FUN_80a3354();
    FUN_80a5534();
    FUN_80a2144(0xe);
    FUN_8015418(0x6002500);
    MEMORY.ref(4, r5 + 0x10c).setu(addPanel_(0xd, 0, 0x11, 0x3, 0x2).getAddress());
    FUN_80a1070();
    MEMORY.call(0x3001388, r7, 0x6004000, CPU.r9().value);
    MEMORY.call(0x3000168, 0x6004000, CPU.r9().value, 0x33333333);
    FUN_80153e0(0x1);
    FUN_80a2474();
    CPU.r10().value = FUN_80a2680(CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    FUN_80a2490();

    if(CPU.r10().value == 1) {
      final Structccc r0 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
      r0.usedItem_180.set(MEMORY.ref(4, CPU.sp().value + 0xc).get() << 10 | MEMORY.ref(4, CPU.sp().value + 0x4).get() & 0x1ff);
      r0._19a.set(MEMORY.ref(2, r5 + 0x174).getUnsigned());
    }

    //LAB_80a25c2
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    FUN_8015278(MEMORY.ref(4, MEMORY.ref(4, r5 + 0x24).get(), Panel24::new));
    r6._ea6.set(0x1);
    FUN_80a34c0();
    drawPanelBackground_(0, 0, 0x1e, 0x14);
    FUN_80ae8dc();
    freeSlot(55);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(0);
    FUN_80152a8();
    FUN_80153e0(0);
    MEMORY.call(0x3001388, 0x6004000, r7, CPU.r9().value);
    r6._ea6.set(0);
    setMallocAddress(r7);
    sleep(1);
    FUN_80a1050();
    sleep(1);
    FUN_8015410(0, 0, 0x1e, 0x14);
    r6._ea6.set(0);
    FUN_808a548();
    final int r0 = CPU.r10().value;

    CPU.sp().value += 0x10;
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();

    return r0;
  }

  @Method(0x80a2680)
  public static int FUN_80a2680(int r0, int r1, int r2) {
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x28;

    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
    r1 = CPU.movT(0x0);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
    final Menua70 r9 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    CPU.r8().value = r1;

    //LAB_80a3252
    do {
      r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        break;
      }
      r0 = CPU.movT(0xa8);
      r0 = CPU.lslT(r0, 1);
      r0 = readFlag_(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        break;
      }

      //LAB_80a26aa
      switch(CPU.r8().value) {
        case 0: // inv char select
          r9._174.get(0).set(0);
          FUN_80a4ee0();
          FUN_80a4e44();

          if(!r9._21c.isNull()) {
            r9._21c.deref()._05.set(0xd);
          }

          FUN_80a3cf8(0, 0xad8);
          drawPanelBackground_(r9.panel_2c.deref());
          FUN_80a23c0(r9.panel_2c.deref());

          if(FUN_80a355c(0) == -1) {
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(-1);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(1);
          }

          //LAB_80a2740
          drawPanelBackground_(r9.panel_2c.deref());
          FUN_80a345c();
          CPU.r8().value = 1;
          break;

        case 1: // inv item select
          CPU.r8().value = 0;
          if(getCharItemCount(r9._21a.get(0).get()) == 0) {
            break;
          }

          //LAB_80a2766
          FUN_80a4ee0();
          FUN_80a4e44();
          r9._21c.deref()._05.set(0xd);
          r9._14.get(0).deref()._05.set(0x1);
          FUN_80a3cf8(0, 0xad9);
          r0 = FUN_80a5788(0);
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
          CPU.r8().value = 0;
          if(r0 == -1) {
            break;
          }

          //LAB_80a27a2
          r9._25d.set(-1);
          CPU.r8().value = 0x9;
          break;

        case 9: // inv choose what to do with item
          r7 = FUN_80a414c();
          r5 = -1;
          if(r7 == -1) {
            CPU.r8().value = 0x1;
            r9._222.set(CPU.r8().value);
          }

          //LAB_80a27cc
          if(r7 == 0) {
            if(FUN_808a490(r9.abilityId_178.get(0).get() & 0x1ff) != 0) {
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x1);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              MEMORY.ref(4, r1).setu(r9._21a.get(0).get());
              r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              MEMORY.ref(4, r2).setu(0);
              r2 = r9.abilityId_178.get(0).get();
              r3 = MEMORY.ref(4, 0x80a2a18).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r3 = CPU.andT(r3, r2);
              MEMORY.ref(4, r1).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x1);
              break;
            }

            //LAB_80a280c
            r6 = FUN_80a46b4(r9._21a.get(0).get(), r9.abilityId_178.get(0).get());
            if(r6 == 1) {
              CPU.r8().value = 0x2;
            }

            //LAB_80a2826
            if(r6 == 2) {
              FUN_80a32b8();
              FUN_8015278(r9.panel_2c.deref());
              FUN_80a1d08(0xbef + r9._25a.get(), 0, r5);
              r9._14.get(0).deref()._05.set(0xd);
              r9.itemCount_218.set(getCharItems(getUnit_(r9._21a.get(0).get()), r9.items_1c8));
              FUN_80a3e28(r9.items_1c8, 0);
              CPU.r8().value = 0;
            }

            //LAB_80a287c
            r3 = CPU.addT(r6, 0x1);
            CPU.cmpT(r3, 0x1);
            if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x1);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              MEMORY.ref(4, r2).setu(r9._21a.get(0).get());
              r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              MEMORY.ref(4, r1).setu(r9._21a.get(1).get());
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              MEMORY.ref(4, r1).setu(r9.abilityId_178.get(0).get() & 0x1ff);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x1);
            }
          }

          //LAB_80a28a8
          if(r7 == 1) {
            CPU.r8().value = 0x3;
          }

          //LAB_80a28b0
          if(r7 == 3) {
            CPU.r8().value = 0x6;
          }

          //LAB_80a28b8
          if(r7 == 5) {
            CPU.r8().value = 0x5;
          }

          //LAB_80a28c0
          if(r7 == 4) {
            CPU.r8().value = 0xb;
          }

          //LAB_80a28c8
          if(r7 == 2) {
            CPU.r8().value = 0xa;
          }

          break;

        case 2: // item use
          FUN_80a345c();
          FUN_80a4e68();
          FUN_80a4e20();
          drawPanelBackground_(r9.panel_10c.deref());
          FUN_80a51d0();
          drawIcon_(0xadb, r9.panel_10c.deref(), 16, 16);

          if(FUN_80a38d0(0) == -1) {
            CPU.r8().value = 0x9;
            break;
          }

          if(FUN_80a3ce4(r9.abilityId_178.get(0).get() & 0x1ff) != 0) {
            r7 = 8;
          } else {
            r7 = 0;
          }

          //LAB_80a2926
          r6 = FUN_80a32b8();
          drawCharInfoPanel(r9.panel_24.deref(), r9._21a.get(1).get(), 0, r7);

          if(r6 != -1) {
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xbef + r9._25a.get(), 0, -1);
            r9._14.get(0).deref()._05.set(0xd);
            FUN_80a4754();
            CPU.r8().value = 1;
          }

          //LAB_80a296e
          r9.itemCount_218.set(getCharItems(getUnit_(r9._21a.get(0).get()), r9.items_1c8));
          FUN_80a3e28(r9.items_1c8, 0);
          r9._222.set(0x1);
          break;

        case 6:
          FUN_80a4e68();
          FUN_80a4e20();
          drawPanelBackground_(r9.panel_10c.deref());
          FUN_80a51d0();
          drawIcon_(0xadc, r9.panel_10c.deref(), 16, 16);

          CPU.r8().value = 0x4;
          if(FUN_80a38d0(0x1) != -1) {
            break;
          }

          //LAB_80a29dc
          FUN_80a3ef0(r9._21a.get(0).get(), r9._174.get(0).get(), 0, r9._21a.get(0).get());
          CPU.r8().value = 0x9;
          break;

        case 5: // drop item
          FUN_80a345c();
          r6 = 0;
          if((getItem_(r9.abilityId_178.get(0).get() & 0x1ff).flags_03.get() & Item2c.FLAG_STACKABLE_10) != 0) {
            r5 = r9.abilityId_178.get(0).get() >>> 11;
            if(r5 > 0) {
              FUN_80a51d0();
              r6 = FUN_80a4f08(0, r5 + 1, 1);
            }
          }

          //LAB_80a2a6a
          CPU.r8().value = 0x9;
          if(r6 == -1) {
            break;
          }

          //LAB_80a2a7a
          r9._21a.get(1).set(0);
          FUN_8015298(2, r9.abilityId_178.get(0).get() & 0x1ff | r6 << 11, r9._21c.deref().slot_0e.get(), 0);
          r9._21c.deref()._05.set(0x1);
          r9._21c.deref().x_06.set(120);
          r9._21c.deref().y_08.set(28);
          FUN_80a17c4(r9._21c.deref());
          FUN_8015068(r9.panel_34.deref(), 0, 72, 120, 96);
          drawPanelBackground_(r9.panel_10c.deref());

          if(FUN_80a524c(MEMORY.ref(4, CPU.sp().value + 0x14).get()) == 0) {
            r7 = r9._21a.get(0).get();
            r0 = r6 + 1;
            if(r0 > 0) {
              r5 = r0;

              //LAB_80a2afe
              do {
                takeItem_(r7, r9._174.get(0).get());
                addArtifact_(r9.abilityId_178.get(0).get() & 0x1ff, 0x1);
                r5--;
              } while(r5 != 0);
            }

            //LAB_80a2b24
            recalcStats_(r7);
            FUN_80a4e44();
            FUN_80a3e88(r9._21a.get(0).get(), 0);
            r9._21c.deref()._05.set(0xd);
            r9._14.get(0).deref()._05.set(0xd);
            sleep(1);
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xb7d, 0xe, 0xd);
            r9._222.set(0x1);
            r3 = 0x1;
          } else {
            //LAB_80a2b6e
            r3 = 0x9;
          }

          //LAB_80a2b70
          CPU.r8().value = r3;
          recalcStats_(r9._21a.get(0).get());
          r9._21c.deref()._05.set(0xd);
          FUN_808a548();
          break;

        case 4:
          CPU.r10().value = 0;

          if((getItem_(r9.abilityId_178.get(0).get() & 0x1ff).flags_03.get() & Item2c.FLAG_STACKABLE_10) != 0) {
            r5 = FUN_80a3d9c(r9._21a.get(1).get(), r9.abilityId_178.get(0).get() & 0x1ff);
            if(r5 == 0x1e) {
              CPU.r10().value = 0x1;
            }

            //LAB_80a2bc8
            if(getCharItemCount(r9._21a.get(1).get()) == 0xf && r5 == 0) {
              CPU.r8().value = 0x7;
              break;
            }

            //LAB_80a2bd6
            r3 = r9.abilityId_178.get(0).get();
            r1 = CPU.r10().value;
            r3 = CPU.lsrT(r3, 11);
            r3 = CPU.addT(r3, 0x1);
            if(r1 == 0) {
              r2 = CPU.lslT(r3, 24);
              r1 = CPU.asrT(r2, 24);
              r3 = CPU.addT(r5, r1);
              if(r3 > 0x1e) {
                r1 = 0x1e - r5;
              }

              //LAB_80a2bf6
              if(r2 > 0x1000000) {
                r6 = FUN_80a4f08(0, r1, 0);
              } else {
                //LAB_80a2c0a
                r6 = 0;
              }

              //LAB_80a2c0c
              if(r6 == -1) {
                CPU.r8().value = 0x6;
                break;
              }

              //LAB_80a2c16
              r6 = CPU.addT(r6, 0x1);
              //LAB_80a2c22
              for(r7 = 0; r7 < r6; r7++) {
                r5 = addItem_(r9._21a.get(1).get(), r9.abilityId_178.get(0).get() & 0x5ff);
                if(r5 != -1) {
                  takeItem_(r9._21a.get(0).get(), r9._174.get(0).get());
                  r9._174.get(1).set(r5);
                } else {
                  //LAB_80a2c5e
                  CPU.r10().value = 0x1;
                }

                //LAB_80a2c62
              }
            }
          } else {
            //LAB_80a2c6a
            r6 = addItem_(r9._21a.get(1).get(), r9.abilityId_178.get(0).get() & 0x5ff);
            if(r6 == -1) {
              //LAB_80a2c8a
              CPU.r8().value = 0x7;
              break;
            }

            //LAB_80a2c90
            r9._174.get(1).set(r6);
            r6 = takeItem_(r9._21a.get(0).get(), r9._174.get(0).get());
            if(r6 == -1) {
              CPU.r10().value = 0x1;
            }
          }

          //LAB_80a2cb4
          recalcStats_(r9._21a.get(0).get());
          recalcStats_(r9._21a.get(1).get());
          FUN_80772c0(r9._21a.get(0).get());
          FUN_80772c0(r9._21a.get(1).get());

          if(CPU.r10().value == 0) {
            r9._21a.get(0).set(r9._21a.get(1).get());
            r9.abilityId_178.get(0).and(0x1ff);
            FUN_80a4e90();
            drawPanelBackground_(r9.panel_10c.deref());
            FUN_80a51d0();
            r6 = FUN_80a5388(0);
          } else {
            r6 = 1;
          }

          //LAB_80a2d0a
          if(readFlag_(0x150) != 0) {
            break;
          }

          //LAB_80a2d18
          FUN_80a3e88(r9._21a.get(1).get(), 0x1);
          r9._14.get(0).deref()._05.set(0xd);
          sleep(1);

          if(CPU.r10().value == 1) {
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xb85, 0xf, 0xe);
          } else {
            //LAB_80a2d40
            FUN_8015278(r9.panel_2c.deref());

            if(r6 == 1) {
              FUN_80a1d08(0xb7f, 0xf, 0xe);
            } else {
              //LAB_80a2d58
              FUN_80a3ef0(r9._21a.get(1).get(), r9._174.get(1).get(), 0, r9._21a.get(1).get());
              FUN_80a1d08(0xb7c, 0xf, 0xe);

              if((getItem_(r9.abilityId_178.get(0).get()).flags_03.get() & Item2c.FLAG_CURSED_01) != 0) {
                //LAB_80a2d8e
                playSound_(0x67);
                FUN_8015278(r9.panel_2c.deref());
                FUN_80a1d08(0xb7c, 0xe, 0xe);
              }
            }
          }

          FUN_808a548();
          CPU.r8().value = 0;
          break;

        case 7:
          CPU.r10().value = 0;
          FUN_80a4ee0();
          FUN_80a4e44();
          FUN_80a3cf8(0, 0xadd);
          r0 = FUN_80a5788(0x1);
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);

          if(r0 == -1) {
            //LAB_80a2df0
            CPU.r8().value = 0x6;
            break;
          }

          //LAB_80a2dfc
          final Unit14c sp0c = getUnit_(r9._21a.get(0).get());
          final Unit14c sp08 = getUnit_(r9._21a.get(1).get());
          r5 = 0x14c;
          CPU.r11().value = mallocChip(r5);
          CPU.r8().value = mallocChip(r5);
          MEMORY.call(0x3001388, CPU.r11().value, sp0c.getAddress(), r5); // memcpy
          MEMORY.call(0x3001388, CPU.r8().value, sp08.getAddress(), r5); // memcpy
          r7 = 0;

          //LAB_80a2e5e
          while(r7 < 30) {
            r6 = takeItem_(r9._21a.get(0).get(), r9._174.get(0).get());
            if(r6 == 2) {
              break;
            }
            if(r6 == -1) {
              CPU.r10().value = 0x1;
              break;
            }

            //LAB_80a2e58
            r7++;
          }

          //LAB_80a2e82
          r7++;
          r5 = 0;

          //LAB_80a2e8a
          while(r5 < 30) {
            if((r9.abilityId_178.get(1).get() & 0x200) != 0 && (getItem_(r9.abilityId_178.get(1).get() & 0x1ff).flags_03.get() & Item2c.FLAG_CANT_REMOVE_02) != 0) {
              CPU.r10().value = 0x1;
            }

            //LAB_80a2eb0
            r6 = takeItem_(r9._21a.get(1).get(), r9._174.get(1).get());
            if(r6 == 2) {
              break;
            }
            if(r6 == -1) {
              //LAB_80a2df6
              CPU.r10().value = 0x1;
              break;
            }

            //LAB_80a2ee0
            r5++;
          }

          //LAB_80a2eea
          r3 = CPU.addT(r5, 0x1);
          r3 = CPU.lslT(r3, 24);
          r5 = CPU.lsrT(r3, 24);

          //LAB_80a2f08
          while(r7 != 0) {
            r6 = addItem_(r9._21a.get(1).get(), r9.abilityId_178.get(0).get() & 0x5ff);
            if(r6 == -1) {
              CPU.r10().value = 0x1;
              break;
            }

            //LAB_80a2ef8
            r9._174.get(1).set(r6);
            r7--;
          }

          //LAB_80a2f50
          while(r5 != 0) {
            r6 = addItem_(r9._21a.get(0).get(), r9.abilityId_178.get(1).get() & 0x5ff);
            if(r6 == -1) {
              CPU.r10().value = 0x1;
              break;
            }

            //LAB_80a2f40
            r9._174.get(0).set(r6);
            r5--;
          }

          //LAB_80a2f78
          sleep(1);

          if(CPU.r10().value == 1) {
            MEMORY.call(0x3001388, sp0c.getAddress(), CPU.r11().value, 0x14c); // memcpy
            MEMORY.call(0x3001388, sp08.getAddress(), CPU.r8().value, 0x14c); // memcpy
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xb84, 0xf, 0xe);
          } else {
            //LAB_80a2fac
            recalcStats_(r9._21a.get(0).get());
            recalcStats_(r9._21a.get(1).get());
            FUN_80772c0(r9._21a.get(0).get());
            FUN_80772c0(r9._21a.get(1).get());
            FUN_80a4e68();
            FUN_80a4e90();
            FUN_80a3480();
            drawPanelBackground_(r9.panel_10c.deref());
            r9._21a.get(0).set(r9._21a.get(1).get());
            r9.abilityId_178.get(0).and(0x1ff);
            FUN_80a51d0();
            r6 = FUN_80a5388(0);

            if(readFlag_(0x150) == 0) {
              FUN_8015278(r9.panel_2c.deref());
              FUN_80a4e20();
              FUN_80a3e88(r9._21a.get(1).get(), 0x1);

              if(r6 == 0) {
                FUN_80a3ef0(r9._21a.get(1).get(), r9._174.get(1).get(), 0, r9._21a.get(1).get());
                r6 = MEMORY.ref(4, 0x80a32a4).get();
                FUN_80a1d08(r6, 0xf, 0xe);

                if((getItem_(r9.abilityId_178.get(0).get()).flags_03.get() & Item2c.FLAG_CURSED_01) != 0) {
                  playSound_(0x67);
                  FUN_8015278(r9.panel_2c.deref());
                  FUN_80a1d08(r6 + 0x7, 0xe, 0xe);
                }
              } else {
                //LAB_80a306e
                FUN_80a1d08(0xb81, 0xf, 0xe);
              }
            }
          }

          //LAB_80a3078
          setMallocAddress(CPU.r8().value);
          setMallocAddress(CPU.r11().value);
          FUN_808a548();
          CPU.r8().value = 0;
          break;

        case 3:
          r6 = equipItem_(r9._21a.get(0).get(), r9._174.get(0).get());
          CPU.r8().value = 0x1;
          if(r6 == -1) {
            break;
          }

          //LAB_80a30b2
          if(r6 == -2) {
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xb82, 0, -1);
            CPU.r8().value = 0x1;
            break;
          }

          //LAB_80a30d2
          recalcStats_(r9._21a.get(0).get());
          FUN_80772c0(r9._21a.get(0).get());
          r9._14.get(0).deref()._05.set(0xd);
          r9.itemCount_218.set(getCharItems(getUnit_(r9._21a.get(0).get()), r9.items_1c8));
          FUN_80a3e28(r9.items_1c8, 0);
          sleep(1);
          FUN_80a3ef0(r9._21a.get(0).get(), r9._174.get(0).get(), 0, r9._21a.get(0).get());
          FUN_8015278(r9.panel_2c.deref());
          FUN_80a1d08(0xb7c, 0xf, 0x8);

          if((getItem_(r9.abilityId_178.get(0).get()).flags_03.get() & Item2c.FLAG_CURSED_01) != 0) {
            playSound_(0x67);
            FUN_8015278(r9.panel_2c.deref());
            FUN_80a1d08(0xb83, 0xe, 0x8);
          }

          CPU.r8().value = 0x1;
          break;

        case 11:
          getUnit_(r9._21a.get(0).get()).items_d8.get(r9._174.get(0).get()).and(~0x200);
          recalcStats_(r9._21a.get(0).get());
          FUN_80772c0(r9._21a.get(0).get());
          CPU.r10().value = 0;
          r9._14.get(0).deref()._05.set(0xd);
          r9.itemCount_218.set(getCharItems(getUnit_(r9._21a.get(0).get()), r9.items_1c8));
          FUN_80a3e28(r9.items_1c8, 0);
          sleep(1);
          r9._25c.set(0x1);
          FUN_80a3ef0(r9._21a.get(0).get(), r9._174.get(0).get(), 0, r9._21a.get(0).get());
          r9._25c.set(CPU.r10().value);
          FUN_8015278(r9.panel_2c.deref());
          FUN_80a1d08(0xb80, 0xe, 0x8);
          FUN_808a548();
          CPU.r8().value = 0x1;
          break;

        case 10:
          r9._14.get(0).deref()._05.set(0xd);
          FUN_80a4800(r9.abilityId_178.get(0).get());
          drawPanelBackground_(r9.panel_24.deref());
          FUN_80a3ef0(r9._21a.get(0).get(), r9._174.get(0).get(), 0, r9._21a.get(0).get());
          r9._14.get(0).deref()._05.set(0x1);
          CPU.r8().value = 0x9;
          break;

        case 12:
          r6 = FUN_80a4f08(0, 0x1e, 0);
          CPU.r8().value = 0x1;
          break;

        case 8:
          break;

        default:
          //LAB_80a324e
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x1);
          break;
      }
    } while(true);

    //LAB_80a3268
    if(readFlag_(0x150) != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(-1);
    }

    //LAB_80a327a
    r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();

    CPU.sp().value += 0x28;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80a32b8)
  public static int FUN_80a32b8() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r6 = FUN_80a9e48(r5._174.get(0).get(), r5._21a.get(0).get(), r5._21a.get(1).get());
    final int r0;
    if(r6 == -1) {
      playSound_(0x72);
      FUN_8015278(r5.panel_2c.derefNullable());
      FUN_80a1d08(0xbef + r5._25a.get(), r6, r6);
      r5._222.set(0x1);
      r0 = r6;
    } else {
      //LAB_80a3312
      FUN_80aa448(r5.abilityId_178.get(0).get() & 0x1ff);
      recalcStats_(r5._21a.get(0).get());
      recalcStats_(r5._21a.get(1).get());
      r0 = 1;
    }

    //LAB_80a3332
    return r0;
  }

  @Method(0x80a3354)
  public static void FUN_80a3354() {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    CPU.sp().value -= 0x4;
    final Panel24 r0 = FUN_80a1814(r7);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    FUN_80a1870(r0, 0x2, 0x2, 0x8);

    //LAB_80a337a
    for(int r2 = 0; r2 < 4; r2++) {
      r7._144.get(r2).set(0x1e);
    }

    final Panel24 panel = addPanel_(0, 17, 30, 3, 0x2);
    r7.panel_24.clear();
    r7.panel_28.clear();
    r7.panel_2c.set(panel);
    r7.panel_20.clear();
    r7._110.set(0);
    r7._111.set(0);
    r7._112.set(8);
    r7._113.set(2);
    CPU.sp().value += 0x4;
  }

  @Method(0x80a33d4)
  public static void FUN_80a33d4(final Menua70 r0, final Panel24 r1) {
    //LAB_80a33ec
    for(int i = 0; i < 8; i++) {
      r0._48.get(i).set(FUN_80150d0(0x2, i, r1, 0xf8, 0xa8));
    }

    //LAB_80a340e
    for(int i = 8; i < 16; i++) {
      r0._48.get(i).set(FUN_80150d0(0x2, i, r1, 0x100, 0xa8));
    }

    //LAB_80a3432
    for(int i = 16; i < 32; i++) {
      r0._48.get(i).set(FUN_80150d0(0x2, i, r1, 0x100, 0xa8));
    }
  }

  @Method(0x80a345c)
  public static void FUN_80a345c() {
    final ArrayRef<Pointer<GraphicsStruct1c>> r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a3468
    for(int r1 = 0; r1 < 0x20; r1++) {
      final GraphicsStruct1c r2 = r3.get(r1).derefNullable();

      if(r2 != null) {
        r2._05.set(0xd);
      }

      //LAB_80a3470
    }
  }

  @Method(0x80a3480)
  public static void FUN_80a3480() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a34c0)
  public static void FUN_80a34c0() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    FUN_80a195c();
    FUN_80a345c();
    sleep(1);

    final GraphicsStruct1c r2 = r5._17c.derefNullable();
    if(r2 != null) { //BUGFIX: NPE
      r2._05.set(0xd);
    }

    FUN_80a1114(r5.panel_10, 0x1);
    FUN_80a1114(r5.panel_20, 0x1);
    FUN_80a1114(r5.panel_10c, 0x1);
    FUN_80a1114(r5.panel_24, 0x1);
    FUN_80a1114(r5.panel_28, 0x1);
    FUN_80a1114(r5.panel_2c, 0x1);
    FUN_80a1114(r5.panel_30, 0x1);
    FUN_80a1114(r5.panel_34, 0x1);
    FUN_80a1114(r5.panel_38, 0x1);
    FUN_80a1114(r5.panel_3c, 0x1);
    FUN_80a1114(r5.panel_40, 0x1);
  }

  @Method(0x80a355c)
  public static int FUN_80a355c(final int r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r6;
    final int r5 = r7._1c.get(r0).get();
    FUN_8015278(r7.panel_2c.derefNullable());
    r7._1e.get(r0).set(r7.partyMemberCount_219.get());
    if(r5 == -1) {
      r7._1c.get(r0).set(0);
      r6 = 0;
    } else {
      //LAB_80a3594
      FUN_80a1ac0(r5 * 24 - 10, 16);
      r6 = r5;
    }

    //LAB_80a35a2
    r7.itemCount_218.set(getCharItems(getUnit_(r7.partyMemberIds_208.get(r6).get()), r7.items_1c8));

    final int r8 = FUN_80a35f8(r7.partyMemberIds_208);
    FUN_80a17c4(r7._14.get(r0).derefNullable());
    sleep(1);

    return r8;
  }

  @Method(0x80a35f8)
  public static int FUN_80a35f8(final ArrayRef<UnsignedShortRef> charIds) {
    final Menua70 r10 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int charSlot = r10._1c.get(0).get();
    final int sp18 = r10._1e.get(0).get();
    int sp14 = 0;
    int sp0c = 0;
    int sp08 = 0;
    Unit14c sp10 = getUnit_(charIds.get(charSlot).get());

    if(FUN_80a10d0(r10.panel_20, 0xd, 0x3, 0x11, 0xa, 0x2) != 0) {
      FUN_80a33d4(r10, r10.panel_20.deref());
    }

    //LAB_80a3658
    if(FUN_80a10d0(r10.panel_28, 0xd, 0xd, 0x11, 0x4, 0x2) != 0) {
      final GraphicsStruct1c r0_0 = FUN_80150d0(0x2, 0, r10.panel_28.deref(), 0, sp14);
      r10._21c.set(r0_0);
      r0_0._05.set(0xd);
    }

    //LAB_80a368e
    drawIcon_(0xb87, r10.panel_28.derefNullable(), 0, 0);
    drawIcon_(0xb88, r10.panel_28.derefNullable(), 0, 0);
    r10._14.get(0).deref()._05.set(1);

    if(readFlag_(0x150) == 0) {
      //LAB_80a36b4
      int r11 = 1;
      while(true) {
        charSlot = modS(sp18 + charSlot, sp18);
        FUN_80a1a40(charSlot * 24 - 10, 16);
        if(r11 != 0) {
          sp0c = 0;
          r11 = 0;
          sp10 = getUnit_(charIds.get(charSlot).get());
          if(sp08 != 0) {
            r10.itemCount_218.set(getCharItems(sp10, r10.items_1c8));
            FUN_80a38a8(charIds.get(charSlot).get());
            drawCharInfoPanel(r10.panel_24.derefNullable(), charIds.get(charSlot).get(), 0, 8);
          } else {
            //LAB_80a3728
            FUN_80a3e88(charIds.get(charSlot).get(), 0);
            drawCharInfoPanel(r10.panel_24.derefNullable(), charIds.get(charSlot).get(), 0, 0);
          }

          //LAB_80a373c
          //LAB_80a3746
          for(int i = 0; i < 4; i++) {
            r10._144.get(i).set(0x1e);
          }

          r10._144.get(charSlot).set(0x1a);
        }

        //LAB_80a375c
        sleep(1);

        if((pressedButtons_3001c94.get() & Input.BUTTON_A) != 0) {
          if((heldButtonsLastFrame_3001ae8.get() & Input.BUTTON_L) != 0) {
            sp0c = (sp0c + 4) % 4 & 0xff;
            FUN_80a1e38(sp10.items_d8, sp0c);
            sp0c = sp0c + 1 & 0xff;
            FUN_80a3e88(charIds.get(charSlot).get(), 0);
            playSound_(0x70);
          } else {
            //LAB_80a37d0
            if(getCharItemCount(charIds.get(charSlot).get()) != 0) {
              playSound_(0x70);
              sp14 = charIds.get(charSlot).get();
              break;
            }

            //LAB_80a37ea
            playSound_(0x72);
          }
        }

        //LAB_80a37f0
        if((pressedButtons_3001c94.get() & Input.BUTTON_B) != 0) {
          playSound_(0x71);
          sp14 = -1;
          break;
        }

        //LAB_80a3808
        if((pressedButtons_3001c94.get() & Input.BUTTON_R) != 0) {
          sp08 = 1;
          r11 = 1;
        }

        //LAB_80a381a
        if((heldButtonsLastFrame_3001ae8.get() & Input.BUTTON_R) == 0 && sp08 == 1) {
          sp08 = 0;
          r11 = 1;
        }

        //LAB_80a3832
        if((pressedButtons_3001b04.get() & Input.BUTTON_LEFT) != 0) {
          playSound_(0x6f);
          charSlot--;
          r11 = 1;
        }

        //LAB_80a384e
        if((pressedButtons_3001b04.get() & Input.BUTTON_RIGHT) != 0) {
          playSound_(0x6f);
          charSlot++;
          r11 = 1;
        }

        //LAB_80a3864
      }
    }

    //LAB_80a3876
    r10._1c.get(0).set(charSlot);
    final int r2 = charIds.get(charSlot).get();
    r10._08.set(r2);
    r10._21a.get(0).set(r2);

    return sp14;
  }

  @Method(0x80a38a8)
  public static void FUN_80a38a8(final int charId) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    FUN_80a9cbc();
    drawPanelBackground_(menu.panel_20.deref());
    FUN_80a9a5c(menu.panel_20.deref(), charId, 0);
  }

  @Method(0x80a38d0)
  public static int FUN_80a38d0(final int r0) {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Panel24 r8 = r6.panel_20.deref();
    final int sp14 = r6.partyMemberCount_219.get();
    int sp0c = 0;
    int sp08 = 0;
    int r10 = r6._1c.get(1).get();
    int sp10 = 1;
    setPanelMetrics(r8, 13, 5, 17, 12);
    drawPanelBackground_(r8);
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a3c08"), 0xc80);

    //LAB_80a3ba0
    do {
      if(readFlag_(0x150) != 0) {
        //LAB_80a3bae
        break;
      }

      //LAB_80a3944
      if(sp10 != 0) {
        //LAB_80a394c
        sp10 = 0;
        r10 = modS(r10 + sp14, sp14);

        final GraphicsStruct1c r5 = r6._14.get(1).derefNullable();
        if(r5 != null) { // retail bug: NPE
          r5.x_06.set((r6.panel_10.deref().x_0c.get() + r10 * 3) * 8 - 2);
          r5.packet_10.attribs_04.attrib1_02.and(~0x1ff).or(r5.x_06.get() & 0x1ff);
        }

        if(r0 == 1) {
          FUN_80a3e88(r6.partyMemberIds_208.get(r10).get(), 1);
          FUN_8015070(r8, 0, 9, 16, 9);
          FUN_8015068(r8, 0, 72, 120, 80);

          if(r10 != r6._1c.get(0).get()) {
            final int r5_0 = FUN_80a3d9c(r6.partyMemberIds_208.get(r10).get(), r6.abilityId_178.get(0).get() & 0x1ff);
            if(r5_0 != 0) {
              FUN_80150b0(r5_0, 2, r8, 8, 72);
              drawIcon_(0xb2f, r8, 24, 72);
            } else {
              //LAB_80a3a14
              drawIcon_(0xb31, r8, 16, 72);
            }

            //LAB_80a3a20
            if(getCharItemCount(r6.partyMemberIds_208.get(r10).get()) == 15 && r5_0 == 0) {
              drawIcon_(0xb30, r8, 0, 72);
            }
          }

          //LAB_80a3a40
          FUN_80a3ef0(r6._21a.get(0).get(), r6._174.get(0).get(), 0, r6.partyMemberIds_208.get(r10).get());
        }

        //LAB_80a3a5c
        if(r0 == 0x0) {
          if(FUN_80a3ce4(r6.abilityId_178.get(0).get() & 0x1ff) != 0) {
            drawCharInfoPanel(r6.panel_24.deref(), r6.partyMemberIds_208.get(r10).get(), r6._174.get(0).get(), 8);
          } else {
            //LAB_80a3aa4
            drawCharInfoPanel(r6.panel_24.deref(), r6.partyMemberIds_208.get(r10).get(), r6._174.get(0).get(), 0);
          }

          //LAB_80a3abc
          if(readFlag_(0x151) == 0 && sp08 == 0) {
            drawPanelBackground_(r6.panel_2c.deref());
            drawIcon_(0x75 + (r6.abilityId_178.get(0).get() & 0x1ff), r6.panel_2c.deref(), 0, 0);
            sp08 = 1;
          } else {
            //LAB_80a3af2
            clearFlag_(0x151);
          }
        }
      }

      //LAB_80a3b0e
      FUN_80a1a40(r10 * 24 - 10, 16);
      sleep(1);

      if((pressedButtons_3001c94.get() & 0x1) == 0) {
        //LAB_80a3b58
        if((pressedButtons_3001c94.get() & 0x2) != 0) {
          playSound_(0x71);
          sp0c = -1;
          break;
        }

        //LAB_80a3b6e
        if((pressedButtons_3001b04.get() & 0x20) != 0) {
          playSound_(0x6f);
          sp10 = 1;
          r10--;
        }

        //LAB_80a3b8a
        if((pressedButtons_3001b04.get() & 0x10) != 0) {
          playSound_(0x6f);
          sp10 = 1;
          r10++;
        }
      } else if(r0 == 0x1 && r10 == r6._1c.get(0).get()) {
        playSound_(0x72);
      } else {
        //LAB_80a3b44
        playSound_(0x70);
        sp0c = r6.partyMemberIds_208.get(r10).get();
        break;
      }
    } while(true);

    //LAB_80a3bb4
    r6._1c.get(1).set(r10);

    final GraphicsStruct1c r5_0 = r6._14.get(1).derefNullable();
    FUN_80a17c4(r5_0);

    if(r5_0 != null) { // retail bug: NPE
      r5_0._05.set(13);
    }

    FUN_80a3c98();
    sleep(1);
    r6._1c.get(1).set(r10);
    r6._08.set(r6.partyMemberIds_208.get(r10).get());
    r6._21a.get(1).set(r6.partyMemberIds_208.get(r10).get());
    return (byte)sp0c;
  }

  @Method(0x80a3c08)
  public static void FUN_80a3c08() {
    if((_3001e40.get() & 0x1f) == 0) {
      final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

      //LAB_80a3c26
      for(int r7 = 0; r7 < r6.partyMemberCount_219.get(); r7++) {
        if(isEquipped_(r6.partyMemberIds_208.get(r7).get(), r6.abilityId_178.get(0).get() & 0x1ff) != 0) {
          setSpriteAnimation_(r6.charSprites_114.get(r7).deref(), 3);
        } else {
          //LAB_80a3c68
          setSpriteAnimation_(r6.charSprites_114.get(r7).deref(), 1);
        }

        //LAB_80a3c78
      }
    }

    //LAB_80a3c8c
  }

  @Method(0x80a3c98)
  public static void FUN_80a3c98() {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80a3caa
    for(int r5 = 0; r5 < menu.partyMemberCount_219.get(); r5++) {
      setSpriteAnimation_(menu.charSprites_114.get(r5).deref(), 1);
    }

    //LAB_80a3ccc
    clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a3c08"));
  }

  @Method(0x80a3ce4)
  public static int FUN_80a3ce4(final int r0) {
    if(r0 > 0xc4 || r0 <= 0xc0) {
      return 0;
    }

    return 1;
  }

  @Method(0x80a3cf8)
  public static void FUN_80a3cf8(final int r0, final int iconId) {
    final Panel24 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).offset(0x10c).deref(4).cast(Panel24::new);
    drawPanelBackground_(r5);
    drawIcon_(iconId, r5, 0, 0);
  }

  @Method(0x80a3d24)
  public static void FUN_80a3d24(final ArrayRef<UnsignedShortRef> items) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80a3d3a
    for(int r2 = 0; r2 < 32; r2++) {
      if(items.get(r2).get() == 0) {
        FUN_80a17c4(menu._48.get(r2).deref());
        menu._48.get(r2).deref()._05.set(0xd);
      }

      //LAB_80a3d52
    }
  }

  @Method(0x80a3d6c)
  public static int getCharItemCount(final int charId) {
    final Unit14c charData = getUnit_(charId);
    int count = 0;

    //LAB_80a3d7a
    for(int i = 0; i < 15; i++) {
      if((charData.items_d8.get(i).get() & 0x1ff) != 0) {
        count++;
      }

      //LAB_80a3d88
    }

    return count;
  }

  @Method(0x80a3d9c)
  public static int FUN_80a3d9c(final int charId, final int itemId) {
    final ArrayRef<UnsignedShortRef> items = getUnit_(charId).items_d8;

    //LAB_80a3dac
    for(int i = 0; i < 15; i++) {
      final int currentItemId = items.get(i).get();
      if(currentItemId != 0 && (currentItemId & 0x1ff) == itemId) {
        return ((currentItemId & 0xf800) >>> 11) + 1;
      }

      //LAB_80a3dca
    }

    //LAB_80a3dd0
    return 0;
  }

  @Method(0x80a3ddc)
  public static int getCharItems(final Unit14c unit, final ArrayRef<UnsignedShortRef> items) {
    //LAB_80a3de8
    for(int i = 0; i < 32; i++) {
      items.get(i).set(0);
    }

    int itemCount = 0;

    //LAB_80a3dfe
    for(int i = 0; i < 15; i++) {
      final int itemId = unit.items_d8.get(i).get();
      if(itemId != 0) {
        items.get(itemCount).set(itemId);
        itemCount++;
      }

      //LAB_80a3e18
    }

    return itemCount;
  }

  @Method(0x80a3e28)
  public static void FUN_80a3e28(final ArrayRef<UnsignedShortRef> items, final int r1) {
    final ArrayRef<Pointer<GraphicsStruct1c>> r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a3e40
    for(int r7 = 0; r7 < 15; r7++) {
      final int itemId = items.get(r7).get();
      if(itemId != 0) {
        if(r1 == 0) {
          FUN_8015298(0x2, itemId, r5.get(r7).deref().slot_0e.get(), 0);
        } else {
          //LAB_80a3e5c
          FUN_8015298(0x7, itemId, r5.get(r7).deref().slot_0e.get(), 0);
        }
      }

      //LAB_80a3e68
    }

    FUN_80a3d24(items);
  }

  @Method(0x80a3e88)
  public static void FUN_80a3e88(final int charId, final int r1) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    menu.itemCount_218.set(getCharItems(getUnit_(charId), menu.items_1c8));
    drawPanelBackground_(menu.panel_20.deref());
    FUN_80a1cb0(r1);
    FUN_80a3e28(menu.items_1c8, 0);

    if(getCharItemCount(charId) == 0) {
      drawIcon_(0xad7, menu.panel_20.deref(), 8, 24);
    }

    //LAB_80a3eda
  }

  @Method(0x80a3ef0)
  public static void FUN_80a3ef0(final int r0, final int itemSlot, final int r2, final int r3) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r10 = 0;
    Unit14c r11 = getUnit_(r0);
    final int itemId = r11.items_d8.get(itemSlot).get();
    if(r2 == 1) {
      r10 = 0x100;
    }

    //LAB_80a3f2a
    switch(getItem_(itemId & 0x1ff).type_02.get()) {
      case Item2c.TYPE_WEAPON_1:
      case Item2c.TYPE_ARMOUR_2:
      case Item2c.TYPE_SHIELD_GLOVES_3:
      case Item2c.TYPE_HELMET_4:
      case Item2c.TYPE_LEGS_5:
      case Item2c.TYPE_LUCKY_CHARM_7:
      case Item2c.TYPE_RING_8:
      case Item2c.TYPE_SHIRT_9: {
        //LAB_00a3f6c
        if(r0 == r3) {
          r10 = r10 | 0x2;
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, itemSlot, r10);
          break;
        }

        //LAB_80a3f74
        r11 = getUnit_(r3);
        final int addr = mallocChip(0x14c);
        MEMORY.call(0x3001388, addr, r11.getAddress(), 0x14c); // memcpy
        if(FUN_80a40ac(r3) != 0) {
          int addedItemSlot = addItem_(r3, itemId & ~0x200);
          if(addedItemSlot != -1) {
            r10 = r10 | 0x2;
          } else {
            //LAB_80a3fc4
            addedItemSlot = itemSlot;
          }

          //LAB_80a3fca
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, addedItemSlot, r10);
        } else {
          //LAB_80a3fd2
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, itemSlot, r10);
        }

        //LAB_80a3fde
        MEMORY.call(0x3001388, r11.getAddress(), addr, 0x14c); // memcpy
        setMallocAddress(addr);
        break;
      }

      case Item2c.TYPE_GRANT_6: {
        //LAB_00a3ff4
        if(r3 == r0) {
          r10 = r10 | 0x4;
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, itemSlot, r10);
          break;
        }

        //LAB_80a400e
        r11 = getUnit_(r3);
        final int addr = mallocChip(0x14c);
        MEMORY.call(0x3001388, addr, r11, 0x14c);
        if(FUN_80a40ac(r3) != 0) {
          int addedItemSlot = addItem_(r3, itemId);
          if(addedItemSlot != -1) {
            r10 = r10 | 0x4;
          } else {
            //LAB_80a4058
            addedItemSlot = itemSlot;
          }

          //LAB_80a405e
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, addedItemSlot, r10);
        } else {
          //LAB_80a4066
          drawCharInfoPanel(r7.panel_24.derefNullable(), r3, itemSlot, r10);
        }

        //LAB_80a4072
        MEMORY.call(0x3001388, r11, addr, 0x14c);
        setMallocAddress(addr);
        break;
      }
    }
  }

  @Method(0x80a40ac)
  public static int FUN_80a40ac(int r0) {
    int r1;
    int r2;
    int r5;
    int r6;
    final int r7;
    r7 = r0;
    final Unit14c charData = getUnit_(r7);
    r1 = 0;
    r6 = 0;

    //LAB_80a4102
    do {
      r2 = charData.items_d8.get(r6).get();
      if(r2 == 0) {
        r0 = 1;
        break;
      }

      //LAB_80a40c0
      if((r2 & 0x200) == 0) {
        final int r3 = r2 >>> 11;
        r2 = r3 + 0x1;
        if(r3 == 0) {
          r2 = 0x1;
        }

        //LAB_80a40d4
        //LAB_80a40da
        for(r5 = 0; r5 < r2; r5++) {
          r1 = takeItem_(r7, r6);
        }

        //LAB_80a40f0
        if(r1 == 2) {
          //LAB_80a4106
          r0 = 1;
        } else {
          r0 = 0;
        }
        break;
      }

      //LAB_80a40f8
      r6++;
      if(r6 > 14) {
        r0 = r1;
        break;
      }
    } while(true);

    //LAB_80a410a
    return r0;
  }

  @Method(0x80a4110)
  public static int FUN_80a4110(final int r0, final int r1) {
    if(r0 > 2 || r1 > 2 || r0 < 0 || r1 < 0) {
      //LAB_80a4122
      return 0;
    }

    //LAB_80a4126
    return MEMORY.ref(4, 0x80af2e4 + (r1 * 0x3 + r0) * 0x4).get();
  }

  @Method(0x80a413c)
  public static int FUN_80a413c(final int r0, final int r1) {
    if(r1 != 0) {
      return 38;
    }

    //LAB_80a4146
    return 30;
  }

  @Method(0x80a414c)
  public static int FUN_80a414c() {
    CPU.sp().value -= 0x10;
    int r10 = 0;
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r8 = 0;
    int r9 = 1;

    final int actions = CPU.sp().value + 0x8;
    getItemActions(actions);
    int r7 = 0;
    if(menu._220.get() != 1) {
      FUN_80a345c();
      drawPanelBackground_(menu.panel_34.deref());
      final Panel24 r5_0 = menu.panel_10c.deref();
      FUN_80a4eb8();
      drawPanelBackground_(r5_0);
      FUN_8015070(r5_0, 0, 0x3, 0x10, 0x3);
      FUN_80a51d0();
      drawItemActions(actions, r5_0);
      drawPanelBackground_(menu.panel_2c.deref());
      drawIcon_((menu.abilityId_178.get(0).get() & 0x1ff) + 0x75, menu.panel_2c.deref(), 0, 0);
    }

    //LAB_80a41e0
    menu._220.set(r10);

    final int r5 = menu._25d.get();
    if(r5 == -1) {
      if(MEMORY.ref(1, actions + 0x2).get() == 1) {
        r7 = 2;
        r8 = 0;
      }

      //LAB_80a4206
      if(MEMORY.ref(1, actions + 0x3).get() == 1) {
        r7 = 0;
        r8 = 1;
      }

      //LAB_80a4216
      if(MEMORY.ref(1, actions + 0x1).get() == 1) {
        r7 = 1;
        r8 = 0;
      }

      //LAB_80a4226
      if(MEMORY.ref(1, actions + 0x4).get() == 1) {
        r7 = 1;
        r8 = 1;
      }

      //LAB_80a4236
      if(MEMORY.ref(1, actions).get() == 1) {
        r7 = 0;
        r8 = 0;
      }
    } else {
      //LAB_80a4258
      r7 = (byte)modS(r5, 3);
      r8 = (byte)divideS(r5, 3);
      r10 = r8 * 3 + r7;
    }

    //LAB_80a427a
    FUN_80a1ac0(FUN_80a4110(r7, r8), FUN_80a413c(r7, r8));

    //LAB_80a4436
    while(readFlag_(0x150) == 0) {
      //LAB_80a4296
      if(r9 != 0) {
        r9 = 0;
        r7 = modS(r7 + 3, 3);
        r8 = (r8 + 2) % 2;
        r10 = r8 * 3 + r7;
        FUN_80a3c98();

        if(r10 > 2) {
          menu._25c.set(1);
          FUN_80a3ef0(menu._21a.get(0).get(), menu._174.get(0).get(), 0, menu._21a.get(0).get());
          if(r10 == 3) {
            setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a3c08"), 0xc80);
          }
          //LAB_80a42fc
        } else if(r10 != 0) {
          menu._25c.set(0);
          FUN_80a3ef0(menu._21a.get(0).get(), menu._174.get(0).get(), 0, menu._21a.get(0).get());
        } else {
          //LAB_80a4320
          drawCharInfoPanel(menu.panel_24.derefNullable(), menu._21a.get(0).get(), 0, 0);
        }
      }

      //LAB_80a4330
      FUN_80a1a40(FUN_80a4110(r7, r8), FUN_80a413c(r7, r8));
      sleep(1);

      if((pressedButtons_3001c94.get() & Input.BUTTON_A) != 0) {
        if(MEMORY.ref(1, actions + r10).get() == -1) {
          playSound_(0x72);
        } else {
          //LAB_80a4372
          switch(r10) {
            case 0:
              //LAB_00a4398
              playSound_(0xae);
              break;

            case 1:
              //LAB_00a43a0
              playSound_(0xaf);
              break;

            case 2:
            case 3:
            case 5:
              //LAB_00a43a8
              playSound_(0x70);
              break;

            case 4:
              //LAB_00a43b0
              playSound_(0x75);
              break;

            default:
              //LAB_80a43b8
              playSound_(0x70);
              break;
          }

          //LAB_80a43be
          menu._25d.set(r10);
          break;
        }
      }

      //LAB_80a43c8
      if((pressedButtons_3001c94.get() & Input.BUTTON_B) != 0) {
        //LAB_80a4248
        playSound_(0x71);
        r10 = -1;
        menu._25d.set(r10);
        break;
      }

      //LAB_80a43d4
      if((pressedButtons_3001b04.get() & Input.BUTTON_UP) != 0) {
        r8--;
        r9 = 1;
        playSound_(0x6f);
        //LAB_80a43f0
      } else if((pressedButtons_3001b04.get() & Input.BUTTON_DOWN) != 0) {
        r8++;
        r9 = 1;
        playSound_(0x6f);
        //LAB_80a4408
      } else if((pressedButtons_3001b04.get() & Input.BUTTON_RIGHT) != 0) {
        r7++;
        r9 = 1;
        playSound_(0x6f);
        //LAB_80a4420
      } else if((pressedButtons_3001b04.get() & Input.BUTTON_LEFT) != 0) {
        r7--;
        r9 = 1;
        playSound_(0x6f);
      }
    }

    //LAB_80a4446
    menu._25c.set(0);
    FUN_80a3c98();
    CPU.sp().value += 0x10;
    return r10;
  }

  @Method(0x80a448c)
  public static void getItemActions(final int out) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Item2c item = getItem_(menu.abilityId_178.get(0).get() & 0x1ff);

    if(item.type_02.get() == 0) {
      MEMORY.ref(1, out).setu(1);
      MEMORY.ref(1, out + 0x1).setu(-1);
    } else {
      //LAB_80a44bc
      MEMORY.ref(1, out).setu(-1);
      MEMORY.ref(1, out + 0x1).setu(1);
    }

    //LAB_80a44c6
    if(FUN_80a46b4(menu._21a.get(0).get(), menu.abilityId_178.get(0).get()) != -1) {
      MEMORY.ref(1, out).setu(1);
    } else {
      //LAB_80a44e8
      MEMORY.ref(1, out).setu(-1);
    }

    //LAB_80a44ea
    if((menu.abilityId_178.get(0).get() & 0x400) != 0) {
      MEMORY.ref(1, out).setu(-1);
    }

    //LAB_80a4506
    if(isEquipped_(menu._21a.get(0).get(), menu.abilityId_178.get(0).get() & 0x1ff) == 0) {
      MEMORY.ref(1, out + 0x1).setu(-1);
    }

    //LAB_80a4520
    MEMORY.ref(1, out + 0x3).setu(1);
    MEMORY.ref(1, out + 0x5).setu(1);
    MEMORY.ref(1, out + 0x2).setu(1);

    if((menu.abilityId_178.get(0).get() & 0x200) != 0) {
      MEMORY.ref(1, out + 0x4).setu(1);
      MEMORY.ref(1, out + 0x1).setu(-1);
    } else {
      //LAB_80a4540
      MEMORY.ref(1, out + 0x4).setu(-1);
    }

    //LAB_80a4548
    if((item.flags_03.get() & Item2c.FLAG_CANT_REMOVE_02) != 0) {
      MEMORY.ref(1, out + 0x4).setu(-1);
      if((menu.abilityId_178.get(0).get() & 0x200) != 0) {
        MEMORY.ref(1, out + 0x3).setu(-1);
        MEMORY.ref(1, out + 0x5).setu(-1);
      }
    }

    //LAB_80a4572
    if(FUN_808a490(menu.abilityId_178.get(0).get() & 0x1ff) != 0) {
      MEMORY.ref(1, out).setu(1);
    }

    //LAB_80a458a
    if(menu.partyMemberCount_219.get() <= 1) {
      MEMORY.ref(1, out + 0x3).setu(-1);
    }

    //LAB_80a459c
    if((item.flags_03.get() & Item2c.FLAG_IMPORTANT_08) != 0) {
      MEMORY.ref(1, out + 0x5).setu(-1);
    }

    //LAB_80a45b0
  }

  @Method(0x80a45cc)
  public static void drawItemActions(final int actions, final Panel24 panel) {
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a45f0
    drawIcon_(0xb33, panel, 0, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x1).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4612
    drawIcon_(0xb34, panel, 32, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x3).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4632
    drawIcon_(0xb35, panel, 0, 32);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x5).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4652
    drawIcon_(0xb36, panel, 80, 32);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x2).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4672
    drawIcon_(0xb37, panel, 80, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x4).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4692
    drawIcon_(0xb38, panel, 32, 32);
    FUN_80150b8(0xf);
  }

  @Method(0x80a46b4)
  public static int FUN_80a46b4(final int r0, final int r1) {
    final int r6 = r1 & 0x1ff;
    final Item2c item = getItem_(r1 & 0x1ff);
    int r7 = -1;
    if(FUN_808a490(r6) != 0) {
      return 0;
    }

    //LAB_80a46de
    final Ability10 ability = getAbility_(item.useAbility_28.get() & 0x3fff);
    if(item.useAbility_28.get() != 0) {
      if(item.type_02.get() == 0) {
        r7 = 0x1;
      } else if(item.useType_0c.get() != 3 && isEquipped_(r0, r6) != 0) {
        //LAB_80a4708
        r7 = 0x1;
      }

      //LAB_80a470a
      if(r7 == 1) {
        int r2 = ability.flags_01.get();
        int r3;
        if((r2 & 0x40) != 0) {
          r2 = ability.range_08.get() ^ 0xff;
          r7 = (-r2 | r2) >>> 31;
          r3 = 0x2;
        } else {
          //LAB_80a472c
          r3 = r2 & 0x80;
          r7 = (-r3 | r3) >>> 31;
          r3 = 0x0;
        }

        //LAB_80a473a
        r7 = r3 - r7;
      }
    }

    //LAB_80a473c
    //LAB_80a473e
    return r7;
  }

  @Method(0x80a4754)
  public static void FUN_80a4754() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    if(getItem_(r5.abilityId_178.get(0).get() & 0x1ff).useType_0c.get() == 2 && rand() < 0x2000) {
      breakItem_(r5._21a.get(0).get(), r5._174.get(0).get());
      playSound_(0x8a);
      FUN_80a1d08(0xb86, 0, -1);
    }

    //LAB_80a479e
  }

  /** Item details */
  @Method(0x80a4800)
  public static int FUN_80a4800(final int r0) {
    int r10 = 1;
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    menu._21c.deref()._05.set(13);
    final Panel24 panel = addPanel_(0, 0, 30, 10, 0x2);
    clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"));
    menu._17c.deref()._05.set(13);
    FUN_80a22f4();
    sleep(1);

    //LAB_80a487c
    int r6 = 0;
    do {
      if(readFlag_(0x150) != 0) {
        break;
      }

      if(r10 != 0) {
        r10 = 0;
        r6 = modS(r6 + 5, 5);
        FUN_80a4924(panel, r0);
      }

      //LAB_80a48a4
      if((pressedButtons_3001c94.get() & 0x1) != 0) {
        break;
      }
      if((pressedButtons_3001c94.get() & 0x2) != 0) {
        r6 = -1;
        break;
      }

      //LAB_80a4854
      if((pressedButtons_3001b04.get() & 0x40) != 0) {
        r6--;
        r10 = 1;
      }

      //LAB_80a4866
      if((pressedButtons_3001b04.get() & 0x80) != 0) {
        r6++;
        r10 = 1;
      }

      //LAB_80a4876
      sleep(1);
    } while(true);

    //LAB_80a48be
    drawPanelBackground_(panel);
    sleep(1);
    FUN_8015018(panel, 1);
    drawPanelBackground_(menu.panel_10.deref());
    FUN_80a2144(14);
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"), 0xc80);
    menu._17c.deref()._05.set(1);
    drawPanelBackground_(13, 0, 17, 10);
    return r6;
  }

  @Method(0x80a4924)
  public static void FUN_80a4924(final Panel24 panel, int r1) {
    int r5 = 0;
    final int r11 = r1;
    int sp08 = r5;
    final Item2c r10 = getItem_(r1 & 0x1ff);

    if(r10.type_02.get() != 0) {
      r1 = 0;

      jmp_80a497a:
      {
        if(r10.attack_08.get() == 0 && r10.defence_0a.get() == 0) {
          int r9 = 0;

          //LAB_80a495e
          do {
            if(r9 > 3) {
              break jmp_80a497a;
            }
            if(r10.equipEffect_18.get(r9).effect_00.get() != 0) {
              break;
            }
            r9++;
          } while(r10.useType_0c.get() != 3);
        }

        //LAB_80a4978
        r1 = 1;
      }

      //LAB_80a497a
      if(r1 == 1) {
        drawIcon_(0xb6d, panel, 16, 0);
        r5 = 1;
      }

      //LAB_80a498c
      if(r10.attack_08.get() != 0) {
        drawIcon_(0xaf7, panel, 0, r5 * 8);
        FUN_80a4db4(r10.attack_08.get(), 3, panel, 64, r5 * 8);
        r5++;
      }

      //LAB_80a49c2
      if(r10.defence_0a.get() != 0) {
        drawIcon_(0xaf8, panel, 0, r5 * 8);
        FUN_80a4db4(r10.defence_0a.get(), 0x3, panel, 0x40, r5 * 8);
        r5++;
      }
    }

    //LAB_80a49f8
    //LAB_80a49fc
    for(int r9 = 0; r9 < 4; r9++) {
      if(r10.equipEffect_18.get(r9).effect_00.get() != 0) {
        //LAB_80a4a0e
        final int r7 = r10.equipEffect_18.get(r9).value_01.get();
        final int r3;
        final int r2;

        switch(r10.equipEffect_18.get(r9).effect_00.get()) {
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 26:
            //LAB_80a4a94
            drawIcon_(0xb3b + r10.equipEffect_18.get(r9).effect_00.get(), panel, 0, r5 * 8);
            FUN_80a4db4(r7, 3, panel, 0x40, r5 * 8);
            break;

          case 15:
          case 16:
          case 17:
          case 18:
          case 19:
          case 20:
          case 21:
          case 22:
            //LAB_80a4aaa
            r2 = r10.equipEffect_18.get(r9).effect_00.get();
            r3 = r2 - 0xf;
            r1 = r3;
            if(r1 < 0) {
              r1 = r2 - 0xc;
            }

            //LAB_80a4ac0
            r1 = r1 >> 2;
            r1 = r1 << 2;
            r1 = r3 - r1;
            r1 = r1 << 24;
            r1 = r1 >>> 24;
            FUN_8015280(panel, r1 + 1, 0, r5, 0x2);
            drawIcon_(0xb3b + r10.equipEffect_18.get(r9).effect_00.get(), panel, 8, r5 * 8);
            FUN_80a4db4(r7, 3, panel, 64, r5 * 8);
            break;

          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          case 12:
          case 13:
          case 14:
            //LAB_80a4b06
            drawIcon_(0xb3b + r10.equipEffect_18.get(r9).effect_00.get(), panel, 0, r5 * 8);
            FUN_8015098(0x80af21c, panel, 64, r5 * 8);

            final int r0;
            if(r7 > 9) {
              FUN_80150b0(1, 1, panel, 72, r5 * 8);
              FUN_8015098(0x80af220, panel, 80, r5 * 8);
              r0 = r7 - 10;
            } else {
              //LAB_80a4b50
              FUN_80150b0(0, 1, panel, 72, r5 * 8);
              FUN_8015098(0x80af220, panel, 80, r5 * 8);
              r0 = r7;
            }

            //LAB_80a4b6c
            FUN_80150b0(r0, 1, panel, 88, r5 * 8);
            break;

          case 23:
          case 25:
          case 27:
            //LAB_80a4b7a
            drawIcon_(r10.equipEffect_18.get(r9).effect_00.get() + 0xb3b, panel, 0, r5 * 8);
            break;

          default:
            //LAB_80a4b94
            break;
        }

        //LAB_80a4b96
        r5++;
      }

      //LAB_80a4b9e
    }

    //LAB_80a4baa
    if((r10.flags_03.get() & 0x1) != 0) {
      drawIcon_(0xb76, panel, 0, r5 * 8);
      r5++;
    }

    //LAB_80a4bca
    final int useType = r10.useType_0c.get();
    if(useType == 3) {
      drawIcon_(0xb65, panel, 0, r5 * 8);
      sp08 = 1;
      r5++;
    }

    //LAB_80a4bf2
    if(useType != 4 && useType != 0) {
      if(sp08 == 0) {
        drawIcon_(0xb6e, panel, 16, r5 * 8);
        r5++;
      }

      //LAB_80a4c18
      if(useType == 1) {
        //LAB_80a4c2a
        drawIcon_(0xb63, panel, 0, r5 * 8);
        r5++;
      } else if(useType == 2) {
        //LAB_80a4c40
        if((r11 & 0x400) != 0x0) {
          drawIcon_(0xb73, panel, 0, r5 * 8);
          r5++;
          drawIcon_(0xb74, panel, 0, r5 * 8);
          r5++;
        } else {
          //LAB_80a4cb0
          drawIcon_(0xb71, panel, 0, r5 * 8);
          r5++;
          drawIcon_(0xb72, panel, 0, r5 * 8);
          r5++;
        }

        //LAB_80a4cda
      }
    }

    //LAB_80a4cdc
    if((r10.useType_0c.get() & 0x10) != 0) {
      if(r5 != 0) {
        r5++;
      }

      //LAB_80a4cf4
      drawIcon_(0xb6f, panel, 16, r5 * 8);
      r5++;
      FUN_8015120(((r11 & 0xf800) >>> 11) + 1, 5);
      drawIcon_(0xb70, panel, 0, r5 * 8);
      r5++;
    }

    //LAB_80a4d3c
    r1 = 0;
    if(r5 == 0) {
      if((r10.flags_03.get() & 0x4) != 0) {
        drawIcon_(0xb69, panel, 0, 0);
        r1 = 1;
      }

      //LAB_80a4d5c
      if(r1 == 0) {
        if((r10.useType_0c.get() & 0x8) != 0) {
          drawIcon_(0xb6a, panel, 0, 0);
          r1 = 1;
        }

        //LAB_80a4d7a
        if(r1 == 0) {
          drawIcon_(0xb6c, panel, 0, 0);
        }
      }
    }

    //LAB_80a4d8a
  }

  @Method(0x80a4db4)
  public static void FUN_80a4db4(final int number, final int r1, final Panel24 panel, final int x, final int y) {
    FUN_80150b0(number, 3, panel, x, y);

    int digits = 1;

    if(Math.abs(number) > 9) {
      digits = 2;
    }

    //LAB_80a4dda
    if(Math.abs(number) > 99) {
      digits = 3;
    }

    //LAB_80a4de8
    if(number > 0) {
      FUN_8015098(0x80af224, panel, x - digits * 8 + 16, y);
    } else {
      //LAB_80a4dfe
      FUN_8015098(0x80af228, panel, x - digits * 8 + 16, y);
    }

    //LAB_80a4e0e
  }

  @Method(0x80a4e20)
  public static void FUN_80a4e20() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_20.derefNullable(), 13, 5, 17, 10);
  }

  @Method(0x80a4e44)
  public static void FUN_80a4e44() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_20.derefNullable(), 13, 3, 17, 10);
  }

  @Method(0x80a4e68)
  public static void FUN_80a4e68() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_10c.derefNullable(), 13, 0, 17, 5);
  }

  @Method(0x80a4e90)
  public static void FUN_80a4e90() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_10c.derefNullable(), 13, 0, 17, 6);
  }

  @Method(0x80a4eb8)
  public static void FUN_80a4eb8() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_10c.derefNullable(), 13, 0, 17, 7);
  }

  @Method(0x80a4ee0)
  public static void FUN_80a4ee0() {
    setPanelMetrics(boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new).panel_10c.derefNullable(), 13, 0, 17, 3);
  }

  /** Drop item */
  @Method(0x80a4f08)
  public static int FUN_80a4f08(final int r0, final int r1, final int r2) {
    final Menua70 r9 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r10 = mallocSlotBoard(14, 0x400);
    int sp08 = 0;
    int sp0c = 1;
    final Panel24 r7 = r9.panel_10c.deref();
    FUN_80a4eb8();
    drawPanelBackground_(r7);
    int r8 = r0;

    if(r2 == 0) {
      sp08 = FUN_80a3d9c(r9._21a.get(1).get(), r9.abilityId_178.get(0).get() & 0x1ff);
    }

    //LAB_80a4f6a
    final int sp04 = FUN_80a3d9c(r9._21a.get(0).get(), r9.abilityId_178.get(0).get() & 0x1ff);
    final int sp10 = getFreeVramSlot();
    if(sp10 != 0x60) {
      //LAB_80a4f8e
      allocateSpriteSlot(sp10, 0x100, 0);
      FUN_80150c8(sp10, 0x40004000, r7, 48, 32);
      final GraphicsStruct1c r0_0 = FUN_80150c8(sp10, 0x40004000, r7, 80, 32);
      final int r2_0 = (r0_0.packet_10.attribs_04.attrib2_04.get() & 0x3ff) + 4 & 0x3ff;
      r0_0.packet_10.attribs_04.attrib2_04.and(~0x3ff).or(r2_0);
      FUN_80a1ac0(0x80, 0x28);

      //LAB_80a516e
      while(readFlag_(0x150) == 0) {
        //LAB_80a4ff4
        if(sp0c != 0x0) {
          //LAB_80a4ffc
          sp0c = 0;
          r8 = modS(r8 + r1, r1);
          drawPanelBackground_(r7);
          drawIcon_(0xade, r7, 0x20, 0);
          DMA.channels[3].SAD.setu(0x80af08c);
          DMA.channels[3].DAD.setu(r10);
          DMA.channels[3].CNT.setu(0x84000040);
          FUN_80b0040(0x1e, 0xe, r10);
          FUN_80b0040(r1 + r0, 0, r10);
          FUN_80b0040(r0 + r8 + 1, 0xa, r10);
          FUN_80b0040(r0, 0x2, r10);
          allocateSpriteSlot(sp10, 0x100, r10);
          FUN_80150b0(r8 + 1, 0x2, r7, 0x20, 0x20);
          drawIcon_(0x182 + (r9.abilityId_178.get(0).get() & 0x1ff), r7, 0x10, 0x8);
          FUN_80150b0(sp04 - r8 - 1, 0x2, r7, 0x10, 0x18);

          if(r2 != 0x0) {
            //LAB_80a50c4
            FUN_80150b0(sp08 + r8 + 1, 0x2, r7, 0x50, 0x18);
          }

          //LAB_80a50d6
          FUN_8015090(getUnit_(r9._21a.get(0).get()).name_00.getAddress(), r7, 0x10, 0x10);

          if(r2 == 0x0) {
            FUN_8015090(getUnit_(r9._21a.get(1).get()).name_00.getAddress(), r7, 0x50, 0x10);
          }
        }

        //LAB_80a5104
        if((pressedButtons_3001c94.get() & 0x1) != 0x0) {
          playSound_(0x70);
          break;
        }

        //LAB_80a5118
        if((pressedButtons_3001c94.get() & 0x2) != 0x0) {
          r8 = -1;
          playSound_(0x71);
          break;
        }

        //LAB_80a5130
        FUN_80a1a40(0x80, 0x28);

        if((pressedButtons_3001b04.get() & 0x20) != 0x0) {
          r8--;
          sp0c = 1;
          playSound_(0x6f);
        }

        //LAB_80a5152
        if((pressedButtons_3001b04.get() & 0x10) != 0x0) {
          r8++;
          sp0c = 1;
          playSound_(0x6f);
        }

        //LAB_80a5168
        sleep(1);
      }
    }

    //LAB_80a517c
    drawPanelBackground_(r7);
    FUN_8015278(r7);
    freeSlot(14);
    r9._21c.deref()._05.set(0xd);

    if(readFlag_(0x150) != 0x0) {
      r8 = -1;
    }

    //LAB_80a51ac
    return r8;
  }

  @Method(0x80a51d0)
  public static void FUN_80a51d0() {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final GraphicsStruct1c r3 = r7._21c.deref();
    FUN_8015298(2, r7.abilityId_178.get(0).get(), r3.slot_0e.get(), 0);
    r3._05.set(0x1);
    r3.x_06.set(0x70);
    r3.y_08.set(0x8);
    FUN_80a17c4(r3);
    FUN_8015090(getUnit_(r7._21a.get(0).get()).name_00.getAddress(), r7.panel_10c.deref(), 16, 0);
    drawIcon_((r7.abilityId_178.get(0).get() & 0x1ff) + 0x182, r7.panel_10c.deref(), 16, 8);
  }

  @Method(0x80a524c)
  public static int FUN_80a524c(final int r0) {
    final Panel24 r7 = addPanel_(13, 3, 17, 10, 0x2);
    drawIcon_(0x182 + (r0 & 0x1ff), r7, 24, 0);
    drawIcon_(0xad4, r7, 0, 16);
    drawIcon_(0xad5, r7, 0, 24);
    drawIcon_(0xb2c, r7, 24, 40);
    drawIcon_(0xb2d, r7, 24, 56);
    int r6 = 1;
    int r8 = 1;
    FUN_80a1ac0(104, 86);

    //LAB_80a5306
    while(readFlag_(0x150) == 0) {
      if(r8 != 0) {
        r8 = 0;
        r6 = modS(r6 + 2, 2);
      }

      //LAB_80a5326
      if((pressedButtons_3001c94.get() & 0x1) != 0) {
        playSound_(0x70);
        break;
      }

      //LAB_80a533a
      if((pressedButtons_3001c94.get() & 0x2) != 0) {
        playSound_(0x71);
        r6 = 1;
        break;
      }

      //LAB_80a52c8
      FUN_80a1a40(104, 70 + r6 * 16);
      if((pressedButtons_3001b04.get() & 0x40) != 0) {
        r8 = 1;
        playSound_(0x6f);
        r6--;
      }

      //LAB_80a52ea
      if((pressedButtons_3001b04.get() & 0x80) != 0) {
        r8 = 1;
        playSound_(0x6f);
        r6++;
      }

      //LAB_80a5300
      sleep(1);
    }

    //LAB_80a534c
    if(readFlag_(0x150) != 0) {
      r6 = 1;
    }

    //LAB_80a535a
    FUN_8015018(r7, 1);
    return r6;
  }

  @Method(0x80a5388)
  public static int FUN_80a5388(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a5534)
  public static void FUN_80a5534() {
    final int r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();

    final int slot1 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x392).setu(slot1);
    allocateSpriteSlot(slot1, 0x80, 0x80aebcc);

    final int slot2 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x394).setu(slot2);
    allocateSpriteSlot(slot2, 0x80, 0x80aeb4c);
  }

  @Method(0x80a5578)
  public static int FUN_80a5578(final int r0, final int r1) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r7 = getCharItemCount(r8._21a.get(r1).get());
    final Unit14c r11 = getUnit_(r8._21a.get(r1).get());
    int r6 = r8._260.get(r8._21a.get(r1).get()).get();
    if(r6 + 0x1 > r7) {
      r6 = r7 - 0x1;
    }

    //LAB_80a55be
    final int r9 = divideS(r6, 5);
    final int r8_0 = modS(r6, 5);
    int r5 = divideS(r7, 5);
    if(modS(r7, 5) != 0) {
      r5 = r5 + 0x1;
    }

    //LAB_80a55ea
    MEMORY.ref(4, r0).setu(r11.getAddress());
    MEMORY.ref(4, r0 + 0x8).setu(r9);
    MEMORY.ref(4, r0 + 0xc).setu(r5);
    MEMORY.ref(4, r0 + 0x10).setu(r8_0);
    MEMORY.ref(4, r0 + 0x14).setu(r7);
    MEMORY.ref(4, r0 + 0x18).setu(r6);
    return 1;
  }

  @Method(0x80a5614)
  public static int FUN_80a5614(final Panel24 r0, final int r1, final int r2) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    MEMORY.ref(4, r2 + 0x18).setu(MEMORY.ref(4, r2 + 0x8).get() * 5 + MEMORY.ref(4, r2 + 0x10).get());
    drawPanelBackground_(r7.panel_2c.deref());
    sleep(1);
    final int r2_0 = r7.items_1c8.get(MEMORY.ref(4, r2 + 0x18).get()).get();
    if(r2_0 != 0) {
      drawIcon_((r2_0 & 0x1ff) + 0x75, r7.panel_2c.deref(), 0, 0);
    }

    //LAB_80a5664
    //LAB_80a566c
    for(int r6 = 0; r6 < 5; r6++) {
      if(r6 == MEMORY.ref(4, r2 + 0x10).get()) {
        FUN_80a2268(r7.panel_20.deref(), 0x1, r6 * 2 + 1, 0xe, 0x1, 0xe);
      } else {
        //LAB_80a5688
        FUN_80a2268(r7.panel_20.deref(), 0x1, r6 * 2 + 1, 0xe, 0x1, 0xf);
      }

      //LAB_80a569c
    }

    sleep(1);
    return 1;
  }

  @Method(0x80a56c8)
  public static int FUN_80a56c8(final Panel24 r0, final int r1, final int r2) {
    final Menua70 r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    drawPanelBackground_(r0);
    FUN_8015070(r0, 0, 0xb, 0x10, 0xb);
    final int r7 = MEMORY.ref(4, r2 + 0x8).get() * 5;
    int r8 = MEMORY.ref(4, r2 + 0x14).get() - r7 & 0xff;
    if(r8 > 5) {
      r8 = 5;
    }

    //LAB_80a5708
    FUN_80a2324(0x5, r7, r0, 116, 34);
    FUN_80a21b0(r0, MEMORY.ref(4, r2 + 0x14).get(), 0x5, MEMORY.ref(4, r2 + 0x8).get(), 0xf);

    //LAB_80a573c
    for(int i = 0; i < r8; i++) {
      drawIcon_((r3.items_1c8.get(r7 + i).get() & 0x1ff) + 0x182, r3.panel_20.deref(), 0x18, i * 16 + 8);
    }

    //LAB_80a5770
    return 1;
  }

  @Method(0x80a5788)
  public static int FUN_80a5788(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r8;
    int r10;
    final int r11;

    CPU.sp().value -= 0x58;
    r11 = r0;
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int sp20 = 0;
    int sp14 = 0;
    r7._25c.set(sp20);
    FUN_80a10d0(r7.panel_34, 0xd, 0x3, 0x11, 0xe, 0x2);
    final Panel24 sp24 = r7.panel_34.deref();
    int sp18 = 0;
    r8 = CPU.sp().value + 0x28;

    //LAB_80a5aba
    jmp_80a5aba:
    do {
      if(sp18 == 0) {
        if(readFlag_(0x150) == 0) {
          final Unit14c r9 = getUnit_(r7._21a.get(r11).get());
          r7.itemCount_218.set(getCharItems(r9, r7.items_1c8));
          FUN_80a3e28(r7.items_1c8, 0);
          r7._21c.deref()._05.set(0xd);
          FUN_80a5578(r8, r11);
          FUN_80a1a40(0x62, MEMORY.ref(4, r8 + 0x18).get() * 0x10 + 0x24);
          r10 = 1;
          MEMORY.ref(4, CPU.sp().value + 0x1c).setu(1);

          //LAB_80a5aac
          do {
            if(readFlag_(0x150) != 0) {
              continue jmp_80a5aba;
            }

            //LAB_80a5810
            FUN_80a1a40(0x62, MEMORY.ref(4, r8 + 0x10).get() * 0x10 + 0x24);
            if(r10 != 0) {
              r10 = 0;
              if(r9.items_d8.get(sp14).get() != 0) {
                FUN_80a17c4(r7._48.get(sp14).deref());
              }

              //LAB_80a5840
              if(MEMORY.ref(4, CPU.sp().value + 0x1c).get() != 0) {
                sleep(1);
                FUN_80a56c8(sp24, 0, r8);
                if(r11 == 0) {
                  drawIcon_(0xb89, sp24, 0, 0x58);
                }

                //LAB_80a5868
                MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
              }

              //LAB_80a586c
              FUN_80a5614(sp24, CPU.sp().value + 0x44, r8);
              r7.abilityId_178.get(r11).set(r7.items_1c8.get(MEMORY.ref(4, r8 + 0x18).get()).get());
              FUN_80a3ef0(r7._21a.get(r11).get(), MEMORY.ref(4, r8 + 0x18).get(), 0, r7._21a.get(r11).get());
              r2 = MEMORY.ref(4, r8 + 0x18).get();
              if(r7.items_1c8.get(r2).get() != 0) {
                final GraphicsStruct1c r0_0 = r7._48.get(r2).deref();
                r0_0._05.set(0x9);
                r0_0.rotation_0c.set(0);
                r0_0.z_0f.set(0xfa);
              }

              //LAB_80a58c2
              //LAB_80a58d0
              for(r5 = 0; r5 < r7.partyMemberCount_219.get(); r5++) {
                setSpriteAnimation_(r7.charSprites_114.get(r5).deref(), 1);
              }
            }

            //LAB_80a58ec
            if((_3001e40.get() & 0x1f) == 0) {
              //LAB_80a5904
              for(r5 = 0; r5 < r7.partyMemberCount_219.get(); r5++) {
                r0 = r7.partyMemberIds_208.get(r5).get();
                r3 = r7.items_1c8.get(MEMORY.ref(4, r8 + 0x18).get()).get();
                r0 = isEquipped_(r0, r3 & 0x1ff);
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  setSpriteAnimation_(r7.charSprites_114.get(r5).deref(), 0x3);
                }

                //LAB_80a5938
              }
            }

            //LAB_80a595c
            sleep(1);
            sp14 = MEMORY.ref(4, r8 + 0x18).get();
            r0 = FUN_80a1fd4(0, MEMORY.ref(4, r8 + 0x14).get(), 5, CPU.sp().value + 0x38, CPU.sp().value + 0x30);
            if(r0 == 1) {
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(1);
              r10 = 1;
            }

            //LAB_80a5984
            if(r0 == 0) {
              r10 = 1;
            }

            //LAB_80a598c
            if(r0 == -1) {
              r10 = 0;
            }

            //LAB_80a5998
            if((pressedButtons_3001c94.get() & 0x1) != 0) {
              if(r7.items_1c8.get(MEMORY.ref(4, r8 + 0x18).get()).get() != 0) {
                //LAB_80a57e2
                playSound_(0xad);
                sp20 = r7.items_1c8.get(MEMORY.ref(4, r8 + 0x18).get()).get();
                sp18 = 0x1;
                continue jmp_80a5aba;
              }
            }

            //LAB_80a59b8
            if((pressedButtons_3001c94.get() & 0x2) != 0) {
              //LAB_80a57fe
              playSound_(0x71);
              sp20 = -1;
              sp18 = 1;
              continue jmp_80a5aba;
            }

            //LAB_80a59c4
            if((pressedButtons_3001b04.get() & 0x100) != 0 || (pressedButtons_3001b04.get() & 0x200) != 0) {
              //LAB_80a59dc
              if(r11 == 1) {
                playSound_(0x72);
                sleep(1);
              } else {
                //LAB_80a59f0
                playSound_(0x6f);
                r7._260.get(r7._21a.get(r11).get()).set(MEMORY.ref(4, r8 + 0x18).get());
                r5 = r7._1c.get(r11).get();

                //LAB_80a5a1c
                do {
                  if((pressedButtons_3001b04.get() & 0x100) != 0) {
                    r5 = r5 + 0x1;
                  } else {
                    //LAB_80a5a2e
                    r5 = r5 - 0x1;
                  }

                  //LAB_80a5a30
                  r1 = r7.partyMemberCount_219.get();
                  r5 = modS(r5 + r1, r1);
                  r6 = r5;
                  r7._08.set(r7.partyMemberIds_208.get(r5).get());
                  r7._21a.get(r11).set(r7.partyMemberIds_208.get(r5).get());
                  r7._1c.get(r11).set(r5);
                  r7.itemCount_218.set(getCharItems(getUnit_(r7._21a.get(r11).get()), r7.items_1c8));
                } while(r7.itemCount_218.get() == 0);

                //LAB_80a5a7c
                for(r5 = 0; r5 < 4; r5++) {
                  r7._144.get(r5).set(0x1e);
                }

                r7._144.get(r6).set(0x1a);
                continue jmp_80a5aba;
              }
            }
          } while(true);
        }
      }

      break;
    } while(true);

    //LAB_80a5b20
    FUN_8015068(sp24, 0, 88, 120, 96);
    FUN_80a17c4(r7._44._00.derefNullable());
    r7._174.get(r11).set(MEMORY.ref(4, r8 + 0x18).get());
    r7._260.get(r7._21a.get(r11).get()).set(MEMORY.ref(4, r8 + 0x18).get());
    r7.abilityId_178.get(r11).set(sp20);
    if(readFlag_(0x150) != 0) {
      sp20 = -1;
    }

    //LAB_80a5b78
    sleep(1);

    CPU.sp().value += 0x58;
    return sp20;
  }

  @Method(0x80a5b94)
  public static int handlePsynergyMenu() {
    CPU.sp().value -= 0x10;
    final Menua70 r6 = MEMORY.ref(4, mallocSlotChip(55, 0xa70), Menua70::new);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(0x1);
    drawPanelBackground_(0, 0, 30, 20);
    sleep(1);
    FUN_80a1090();
    r6.partyMemberCount_219.set(getPartyMemberIds_(r6.partyMemberIds_208.getAddress()));
    FUN_80a3354();
    MEMORY.ref(4, CPU.sp().value).setu(0x2);
    r6.panel_10c.set(addPanel_(0xd, 0, 0x11, 0x3, 0x2));
    FUN_80a2144(0xe);
    FUN_8015418(0x6002500);
    FUN_80a2474();
    final int r7 = FUN_80a5cc0(CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    FUN_80a2490();

    if(r7 == 1) {
      final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
      getAbility_(r6.abilityId_178.get(0).get() & 0x3fff);
      r5.usedAbility_17e.set(MEMORY.ref(4, CPU.sp().value + 0xc).get() << 10 | MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_80a5c46
    FUN_8015278(r6.panel_24.deref());
    boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea6.set(0x1);
    FUN_80a34c0();
    drawPanelBackground_(0, 0, 30, 20);
    freeSlot(55);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(0);
    sleep(1);
    FUN_8015410(0, 0, 0x1e, 0x14);
    boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea6.set(0);
    FUN_808a548();
    CPU.sp().value += 0x10;

    return r7;
  }

  @Method(0x80a5cc0)
  public static int FUN_80a5cc0(int r0, int r1, final int r2) {
    int r5 = 0;
    final int sp08 = r0;
    int sp00 = 0;
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r11 = 0;

    //LAB_80a5ce0
    while(sp00 == 0 && readFlag_(0x150) == 0) {
      //LAB_80a5ce6
      final int r10;
      int r3;
      switch(r5) {
        case 0: // char select
          r7._174.get(0).set(0);
          FUN_80a3cf8(0, 0xae9);

          if(FUN_80a602c(0) == -1) {
            sp00 = 1;
            r11 = -1;
          }

          //LAB_80a5d2a
          drawPanelBackground_(r7.panel_2c.deref());
          r5 = 1;
          break;

        case 1: // psynergy select
          sleep(1);
          r3 = r7.itemCount_218.get();
          r5 = 0;

          if(r3 != 0) {
            //LAB_80a5d54
            r3 = r7._268.get();
            if(r3 == 0) {
              //LAB_80a5d70
              FUN_80a3cf8(0, 0xaea);
            } else if(r3 == 1) {
              //LAB_80a5d74
              FUN_80a3cf8(0, 0xaf1);
            } else if(r3 == 2) {
              //LAB_80a5d7e
              FUN_80a3cf8(0, 0xaf0);
            }

            //LAB_80a5d86
            FUN_80a9cbc();
            drawCharInfoPanel(r7.panel_24.deref(), r7._21a.get(0).get(), 0, 0);
            r1 = FUN_80a6ccc(0);
            r5 = 0;
            if(r1 != -1) {
              //LAB_80a5db0
              r3 = r7._268.get();
              r5 = 2;
              if(r3 != 0) {
                //LAB_80a5dc0
                if(r3 == 1) {
                  FUN_80a65e4(r7._21a.get(0).get(), r1, 0);
                  FUN_8015278(r7.panel_2c.deref());
                  FUN_80a1d08(0xae2, -1, -1);
                } else {
                  //LAB_80a5dde
                  FUN_80a65e4(r7._21a.get(0).get(), r1, 0x1);
                  FUN_8015278(r7.panel_2c.deref());
                  FUN_80a1d08(0xae3, -1, -1);
                }

                //LAB_80a5df6
                r5 = 0;
              }
            }
          }
          break;

        case 3: // psynergy character select (e.g. heal)
          FUN_80a3cf8(0, 0xaeb);
          r10 = FUN_80a63e4(0);
          if(r10 == -1) {
            //LAB_80a5e16
            r7._220.or(0x1);
            r5 = 1;
          } else {
            r5 = 4;
          }
          break;

        case 2: // psynergy selected
          r0 = FUN_80a5fe0();
          if(r0 == 1) {
            //LAB_80a5e2a
            r5 = 3;
            //LAB_80a5e2e
          } else if(r0 == 2) {
            r7._21a.get(1).set(0x9);
            r5 = 4;
          } else {
            //LAB_80a5e70
            sp00 = 1;
            r11 = 0x1;
            MEMORY.ref(4, sp08).setu(r7._21a.get(0).get());
            MEMORY.ref(4, r2).setu(r7.abilityId_178.get(0).get() & 0x3fff);
          }
          break;

        case 4:
          r11 = FUN_80a9f10(r7.abilityId_178.get(0).get(), r7._21a.get(0).get(), r7._21a.get(1).get(), 0);
          if(r7._21a.get(1).get() == 9) {
            r7._21a.get(1).set(r7._21a.get(0).get());
            r10 = 9;
          } else {
            r10 = 0;
          }

          //LAB_80a5ec2
          if(r11 != -1) {
            addPp_(r7._21a.get(0).get(), -getAbility_(r7.abilityId_178.get(0).get() & 0x3fff).cost_09.get());
          }

          //LAB_80a5ee4
          recalcStats_(r7._21a.get(0).get());
          if(r11 != -1) {
            drawCharInfoPanel(r7.panel_24.deref(), r7._21a.get(1).get(), 0, 0);
            FUN_80aa460(r7.abilityId_178.get(0).get() & 0x3fff);
            FUN_8015278(r7.panel_2c.deref());
            FUN_80a1d08(r7._25a.get() + 0xbef, 0, -1);
          } else {
            //LAB_80a5f22
            playSound_(0x72);
            FUN_8015278(r7.panel_2c.deref());
            FUN_80a1d08(r7._25a.get() + 0xbef, -1, -1);
          }

          //LAB_80a5f42
          if(r11 != -1) {
            r11 = 1;
            r7._220.or(0x1);
            r5 = 1;
          } else {
            //LAB_80a5f60
            r7._222.set(0x1);

            if(r10 != 9) {
              r5 = 3;
            } else {
              //LAB_80a5f72
              r7._220.or(0x1);
              r5 = 1;
            }
          }
          break;

        default:
          //LAB_80a5fa0
          sp00 = 1;
          break;
      }

      //LAB_80a5fa4
    }

    //LAB_80a5fb8
    if(readFlag_(0x150) != 0) {
      r11 = -1;
    }

    //LAB_80a5fca
    return r11;
  }

  @Method(0x80a5fe0)
  public static int FUN_80a5fe0() {
    int r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get() + 0x178;
    final Ability10 ability = getAbility_(MEMORY.ref(2, r3).getUnsigned() & 0x3fff);

    if(FUN_808a488(ability.fieldPsynergyId_0c.get()) != 0) {
      return 0;
    }

    //LAB_80a6006
    if(ability.range_08.get() == 0xff) {
      return 2;
    }

    r3 = ability.target_00.get() ^ 0x2;

    //LAB_80a601e
    return 1 - ((-r3 | r3) >>> 31);
  }

  @Method(0x80a602c)
  public static int FUN_80a602c(final int r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final GraphicsStruct1c r0_0 = r7._14.get(r0).deref();
    r0_0._05.set(1);
    r0_0.rotation_0c.set(0);
    final GraphicsStruct1c r2 = r7._21c.derefNullable();

    // Retail NPE
    if(r2 != null) {
      r2._05.set(0xd);
    }

    final int r1 = r7._1c.get(r0).get();
    r7._1e.get(r0).set(r7.partyMemberCount_219.get());

    final int r6;
    if(r1 == -1) {
      r6 = 0;
      r7._1c.get(r0).set(0);
    } else {
      //LAB_80a607c
      r6 = r1 * 2;
      FUN_80a1ac0(r1 * 0x18 - 0xa, 0x10);
    }

    //LAB_80a608a
    r7.itemCount_218.set(FUN_80a68ec(getUnit_(r7.partyMemberIds_208.get(r6).get()), r7.items_1c8, 0x2));
    final int r5 = FUN_80a60d4(r7.partyMemberIds_208);
    FUN_80a17c4(r7._14.get(r0).deref());
    sleep(1);

    return r5;
  }

  @Method(0x80a60d4)
  public static int FUN_80a60d4(final ArrayRef<UnsignedShortRef> r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int sp18 = r7._1e.get(0).get();
    int sp14 = 1;
    int sp10 = 0;
    int sp08 = 0;
    int r10 = r7._1c.get(0).get();
    r7._268.set(sp10);
    Unit14c sp0c = getUnit_(r0.get(r10).get());

    if(FUN_80a10d0(r7.panel_20, 0xd, 0x3, 0x11, 0xa, 0x2) != 0) {
      FUN_80a33d4(r7, r7.panel_20.deref());
    }

    //LAB_80a613e
    if(FUN_80a10d0(r7.panel_28, 0xd, 0xd, 0x11, 0x4, 0x2) != 0) {
      final GraphicsStruct1c r0_0 = FUN_80150d0(0x2, 0, r7.panel_28.deref(), 0, sp10);
      r7._21c.set(r0_0);
      r0_0._05.set(0xd);
    }

    //LAB_80a6174
    //LAB_80a6184
    while(readFlag_(0x150) == 0) {
      if(sp14 != 0) {
        sp14 = 0;
        r10 = modS(sp18 + r10, sp18);
        sp0c = getUnit_(r0.get(r10).get());
        FUN_80a6384(r0.get(r10).get());
        drawCharInfoPanel(r7.panel_24.derefNullable(), r0.get(r10).get(), 0, 0);
        FUN_80a6614(r7.panel_28.deref());
        FUN_80a1804(r7, r0.get(r10).get());

        //LAB_80a61dc
        for(int i = 0; i < 4; i++) {
          r7._144.get(i).set(0x1e);
        }

        r7._144.get(r10).set(0x1a);

        if(readFlag_(0x151) == 0 && sp08 == 0) {
          FUN_8015278(r7.panel_2c.deref());
          drawPanelBackground_(r7.panel_2c.deref());
          FUN_80a23c0(r7.panel_2c.deref());
          sp08 = 1;
        } else {
          //LAB_80a6228
          clearFlag_(0x151);
        }
      }

      //LAB_80a6230
      //LAB_80a6236
      FUN_80a1a40(r10 * 0x18 - 0xa, 0x10);
      sleep(1);

      if((pressedButtons_3001c94.get() & Input.BUTTON_A) != 0) {
        if(r7.itemCount_218.get() != 0) {
          playSound_(0x70);
          sp10 = r0.get(r10).get();
          break;
        }

        //LAB_80a6272
        playSound_(0x72);
      }

      //LAB_80a627a
      if((pressedButtons_3001c94.get() & Input.BUTTON_L) != 0 || (pressedButtons_3001c94.get() & Input.BUTTON_R) != 0) {
        //LAB_80a6294
        sp10 = r0.get(r10).get();
        final int r3;
        if((pressedButtons_3001c94.get() & Input.BUTTON_L) != 0) {
          r3 = 1;
        } else {
          //LAB_80a62ac
          r3 = 2;
        }

        r7._268.set(r3);

        //LAB_80a62b2
        final int r6 = mallocChip(0x40);
        final int r5 = (byte)FUN_80a68ec(sp0c, MEMORY.ref(4, r6, ArrayRef.of(UnsignedShortRef.class, 0x20, 0x2, UnsignedShortRef::new)), 0x1);
        setMallocAddress(r6);

        if(r5 != 0) {
          //LAB_80a62e4
          playSound_(0x70);
          break;
        }

        r7._268.set(r5);
        playSound_(0x72);
      }

      //LAB_80a62ec
      if((pressedButtons_3001c94.get() & Input.BUTTON_B) != 0) {
        playSound_(0x71);
        sp10 = -1;
        break;
      }

      //LAB_80a6306
      if((pressedButtons_3001b04.get() & Input.BUTTON_LEFT) != 0) {
        playSound_(0x6f);
        sp14 = 1;
        r10--;
      }

      //LAB_80a6322
      if((pressedButtons_3001b04.get() & Input.BUTTON_RIGHT) != 0) {
        playSound_(0x6f);
        sp14 = 1;
        r10++;
      }

      //LAB_80a6338
      //LAB_80a6346
    }

    //LAB_80a634c
    r7._1c.get(0).set(r10);
    r7._08.set(r0.get(r10).get());
    r7._21a.get(0).set(r0.get(r10).get());
    return sp10;
  }

  @Method(0x80a6384)
  public static void FUN_80a6384(final int r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r7.itemCount_218.set(FUN_80a68ec(getUnit_(r0), r7.items_1c8, 0x2));
    drawPanelBackground_(r7.panel_20.deref());
    FUN_80a1bdc(0x6c, 0x20, 0x8);
    FUN_80a68a8(r7.items_1c8);

    if(r7.itemCount_218.get() == 0) {
      drawIcon_(0xaf2, r7.panel_20.deref(), 0, 0x18);
    }

    //LAB_80a63cc
  }

  @Method(0x80a63e4)
  public static int FUN_80a63e4(final int r0) {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r8 = r6._1c.get(1).get();
    final int r11 = r6.partyMemberCount_219.get();
    int sp04 = 0;
    int sp00 = 0;
    int r9 = 1;
    FUN_80a1ac0(r8 * 24 - 10, 16);

    //LAB_80a6582
    //LAB_80a6590
    while(readFlag_(0x150) == 0) {

      //LAB_80a6440
      if(r9 != 0) {
        r9 = 0;
        r8 = modS(r8 + r11, r11);

        final GraphicsStruct1c r5 = r6._14.get(1).derefNullable();
        if(r5 != null) { //BUGFIX: NPE
          r5.x_06.set(r6.panel_10.deref().x_0c.get() * 8 + r8 * 24 - 2);
          r5.packet_10.attribs_04.attrib1_02.and(~0x1ff).or(r5.x_06.get() & 0x1ff);
        }

        if(r0 != 0) {
          //LAB_80a64a0
          drawCharInfoPanel(r6.panel_24.deref(), r6.partyMemberIds_208.get(r8).get(), 0, 0);
          FUN_80a1804(r6, r6.partyMemberIds_208.get(r8).get());

          if(readFlag_(0x151) == 0 && sp00 == 0) {
            drawPanelBackground_(r6.panel_2c.deref());
            drawIcon_(0x53a + (r6.abilityId_178.get(0).get() & 0x3fff), r6.panel_2c.deref(), 0, 0);
            sp00 = 1;
          } else {
            //LAB_80a64ea
            clearFlag_(0x151);
          }
        }
      }

      //LAB_80a6506
      FUN_80a1a40(r8 * 24 - 10, 16);
      sleep(1);

      if((pressedButtons_3001c94.get() & 0x1) != 0) {
        playSound_(0x70);
        sp04 = r6.partyMemberIds_208.get(r8).get();
        break;
      }

      //LAB_80a6538
      if((pressedButtons_3001c94.get() & 0x2) != 0) {
        playSound_(0x71);
        sp04 = -1;
        break;
      }

      //LAB_80a6550
      if((pressedButtons_3001b04.get() & 0x20) != 0) {
        playSound_(0x6f);
        r8--;
        r9 = 1;
      }

      //LAB_80a656c
      if((pressedButtons_3001b04.get() & 0x10) != 0) {
        playSound_(0x6f);
        r8++;
        r9 = 1;
      }
    }

    //LAB_80a6596
    final GraphicsStruct1c r5 = r6._14.get(1).derefNullable();
    r6._1c.get(1).set(r8);
    FUN_80a17c4(r5);

    if(r5 != null) { //BUGFIX: NPE
      r5._05.set(13);
    }

    sleep(1);
    r6._1c.get(1).set(r8);
    r6._08.set(r6.partyMemberIds_208.get(r8).get());
    r6._21a.get(1).set(r6.partyMemberIds_208.get(r8).get());
    return sp04;
  }

  @Method(0x80a65e4)
  public static int FUN_80a65e4(final int r0, final int r1, final int r2) {
    final int r3;
    if(r2 == 0) {
      r3 = 0x2000460;
    } else {
      //LAB_80a65fa
      r3 = 0x2000462;
    }

    //LAB_80a65fe
    MEMORY.ref(2, r3).setu(r0 << 10 | r1 & 0x3fff);
    return 1;
  }

  @Method(0x80a6614)
  public static int FUN_80a6614(final Panel24 r0) {
    int r6;

    CPU.sp().value -= 0x14;

    if(boundPsynergy1_2000460.get() != 0 && boundPsynergy2_2000462.get() != 0) {
      drawIcon_(0xae4, r0, 0, -8);
    } else {
      //LAB_80a664e
      drawIcon_(0xae0, r0, 0, -8);
    }

    //LAB_80a665c
    FUN_8015108((boundPsynergy1_2000460.get() & 0x3ff) + 0x333, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    CPU.cmpT(MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xa);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r6 = 0;
    } else {
      r6 = 1;
    }

    //LAB_80a6698
    if(boundPsynergy1_2000460.get() != 0) {
      FUN_8015120(boundPsynergy1_2000460.get() & 0x3ff, 0x4);
      drawIcon_(0xae7, r0, 0, 0);

      if(r6 == 0) {
        FUN_8015090(getUnit_(boundPsynergy1_2000460.get() >>> 10).name_00.getAddress(), r0, 0x50, 0);
      }
    } else {
      //LAB_80a66d6
      drawIcon_(0xae5, r0, 0, 0);
    }

    //LAB_80a66e2
    FUN_8015108((boundPsynergy2_2000462.get() & 0x3ff) + 0x333, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    CPU.cmpT(MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xa);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r6 = 0;
    } else {
      r6 = 1;
    }

    //LAB_80a670a
    if(boundPsynergy2_2000462.get() != 0) {
      FUN_8015120(boundPsynergy2_2000462.get() & 0x3ff, 0x4);
      drawIcon_(0xae8, r0, 0, 0x8);

      if(r6 == 0) {
        FUN_8015090(getUnit_(boundPsynergy2_2000462.get() >>> 10).name_00.getAddress(), r0, 0x50, 0x8);
      }

      //LAB_80a6744
      FUN_80150b8(0xf);
    } else {
      //LAB_80a674c
      drawIcon_(0xae6, r0, 0, 0x8);
    }

    //LAB_80a6758
    CPU.sp().value += 0x14;
    return 1;
  }

  @Method(0x80a68a8)
  public static void FUN_80a68a8(final ArrayRef<UnsignedShortRef> r0) {
    final ArrayRef<Pointer<GraphicsStruct1c>> r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a68bc
    for(int r7 = 0; r7 < 0x20; r7++) {
      final int r1 = r0.get(r7).get();

      if(r1 != 0) {
        FUN_8015298(0x4, r1, r6.get(r7).deref().slot_0e.get(), 0);
      }

      //LAB_80a68d0
    }

    FUN_80a3d24(r0);
  }

  @Method(0x80a68ec)
  public static int FUN_80a68ec(final Unit14c r0, final ArrayRef<UnsignedShortRef> r1, final int r2) {
    final int r8 = (r2 ^ 0x2) != 0 ? 4 : 3;

    //LAB_80a691a
    for(int i = 0; i < 0x20; i++) {
      r1.get(i).set(0);
    }

    int r4 = 0;
    if(r2 == 1) {
      //LAB_80a693c
      for(int i = 0; i < 32; i++) {
        final int r2_0 = r0.psynergy_58.get(i).get();
        if(r2_0 != 0) {
          if(getAbility_(r2_0 & 0x3fff).fieldPsynergyId_0c.get() != 0) {
            r1.get(r4).set(r0.psynergy_58.get(i).get());
            r4++;
          }
        }

        //LAB_80a6966
      }
    } else {
      //LAB_80a6970
      //LAB_80a697a
      for(int r7 = 0; r7 < r8; r7++) {
        //LAB_80a6986
        for(int i = 0; i < 32; i++) {
          final int r2_0 = r0.psynergy_58.get(i).get();
          if(r2_0 != 0) {
            final Ability10 ability = getAbility_(r2_0 & 0x3fff);
            if(r7 == 0 && (ability.fieldPsynergyId_0c.get() != 0 || (ability.flags_01.get() & 0x40) != 0) || r7 == 3 && ability.fieldPsynergyId_0c.get() == 0 && (ability.flags_01.get() & 0x40) == 0) {
              //LAB_80a69d4
              r1.get(r4).set(r0.psynergy_58.get(i).get());
              r4++;
            }
          }

          //LAB_80a69dc
        }
      }
    }

    //LAB_80a69ea
    return r4;
  }

  @Method(0x80a6a00)
  public static int FUN_80a6a00(final int r0, final int r1) {
    final int r3;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r10;

    r6 = MEMORY.ref(4, 0x3001f2c).get();
    final Unit14c r11 = getUnit_(MEMORY.ref(1, r6 + 0x218 + r1 + 0x2).getUnsigned());
    r7 = MEMORY.ref(1, r6 + 0x218).getUnsigned();
    r3 = MEMORY.ref(1, r6 + 0x218 + r1 + 0x2).getUnsigned();
    r6 = MEMORY.ref(1, r6 + 0x260 + r3).get();
    if(r6 > r7 - 1) {
      r6 = r7 - 1;
    }

    //LAB_80a6a42
    r10 = divideS(r6, 5);
    r8 = modS(r6, 5);

    r5 = divideS(r7, 5);
    if(modS(r7, 5) != 0x0) {
      r5 = r5 + 0x1;
    }

    //LAB_80a6a6e
    MEMORY.ref(4, r0).setu(r11.getAddress());
    MEMORY.ref(4, r0 + 0x8).setu(r10);
    MEMORY.ref(4, r0 + 0xc).setu(r5);
    MEMORY.ref(4, r0 + 0x10).setu(r8);
    MEMORY.ref(4, r0 + 0x14).setu(r7);
    MEMORY.ref(4, r0 + 0x18).setu(r6);
    return 1;
  }

  @Method(0x80a6a98)
  public static int FUN_80a6a98(final Panel24 r0, final int r1, final int r2) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    MEMORY.ref(4, r2 + 0x18).setu(MEMORY.ref(4, r2 + 0x8).get() * 5 + MEMORY.ref(4, r2 + 0x10).get());
    if(readFlag_(0x151) == 0) {
      drawPanelBackground_(r7.panel_2c.deref());
      sleep(1);
      final int itemId = r7.items_1c8.get(MEMORY.ref(4, r2 + 0x18).get()).get();
      if(itemId != 0) {
        drawIcon_(0x53a + (itemId & 0x1ff), r7.panel_2c.deref(), 0, 0);
      }
    } else {
      //LAB_80a6af4
      clearFlag_(0x2ff);
    }

    //LAB_80a6afa
    //LAB_80a6b02
    for(int r6 = 0; r6 < 5; r6++) {
      if(r6 == MEMORY.ref(4, r2 + 0x10).get()) {
        FUN_80a2268(r7.panel_20.deref(), 0, 1 + r6 * 2, 15, 1, 14);
      } else {
        //LAB_80a6b20
        FUN_80a2268(r7.panel_20.deref(), 0, 1 + r6 * 2, 15, 1, 15);
      }

      //LAB_80a6b32
    }

    sleep(1);
    return 1;
  }

  @Method(0x80a6b64)
  public static int FUN_80a6b64(final Panel24 r0, final int r1, final int r2) {
    final Menua70 r10 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    drawPanelBackground_(r0);
    FUN_8015070(r0, 0, 11, 16, 11);
    if((r10._220.get() & 0x2) != 0) {
      drawIcon_(0xae1, r0, 0, 88);
    } else {
      //LAB_80a6bb0
      drawIcon_(0xb89, r0, 0, 88);
    }

    //LAB_80a6bbc
    final int r5 = MEMORY.ref(4, r2 + 0x8).get() * 5;
    int r11 = MEMORY.ref(4, r2 + 0x14).get() - r5;
    if(r11 > 5) {
      r11 = 5;
    }

    //LAB_80a6bd4
    FUN_80a2324(5, r5, r0, 112, 34);
    FUN_80a21b0(r0, MEMORY.ref(4, r2 + 0x14).get(), 5, MEMORY.ref(4, r2 + 0x8).get(), 15);
    drawIcon_(0xaed, r0, 96, 0);

    //LAB_80a6c12
    for(int r9 = 0; r9 < r11; r9++) {
      final Unit14c unit = getUnit_(r10._21a.get(0).get());
      final Ability10 r7 = getAbility_(r10.items_1c8.get(r5 + r9).get() & 0x3fff);
      if(r7.cost_09.get() > unit.pp_3a.get()) {
        FUN_80150b8(2);
        //LAB_80a6c3e
      } else if(FUN_80a735c(r10.items_1c8.get(r5 + r9).get() & 0x3fff) != 0) {
        FUN_80150b8(4);
      } else {
        //LAB_80a6c56
        FUN_80150b8(15);
      }

      //LAB_80a6c5c
      drawIcon_(0x333 + (r10.items_1c8.get(r5 + r9).get() & 0x3fff), r0, 16, r9 * 16 + 8);
      drawNumber_(r7.cost_09.get(), 2, r0, 104, r9 * 16 + 8);
      FUN_80150b8(15);
    }

    //LAB_80a6c9c
    return 1;
  }

  @Method(0x80a6ccc)
  public static int FUN_80a6ccc(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r9;

    CPU.sp().value -= 0x64;
    final int sp30 = r0;
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    r7._14.get(sp30).deref()._05.set(13);
    FUN_80a10d0(r7.panel_34, 13, 3, 17, 14, 2);
    final Panel24 r8 = r7.panel_34.deref();
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
    r4 = CPU.sp().value + 0x34;

    //LAB_80a72cc
    while(MEMORY.ref(4, CPU.sp().value + 0x24).get() == 0 && readFlag_(0x150) == 0) {
      //LAB_80a6d28
      final Unit14c sp20 = getUnit_(r7._21a.get(sp30).get());

      if(r7._268.get() != 0x0) {
        r7.itemCount_218.set(FUN_80a68ec(sp20, r7.items_1c8, 1));
      } else {
        //LAB_80a6db2
        r7.itemCount_218.set(FUN_80a68ec(sp20, r7.items_1c8, 2));
      }

      //LAB_80a6dbe
      FUN_80a68a8(r7.items_1c8);
      FUN_80a6a00(r4, sp30);
      MEMORY.ref(4, CPU.sp().value + 0x28).setu(1);
      r7._14.get(sp30).deref()._05.set(1);
      r6 = readFlag_(0x150);

      //LAB_80a6dfe
      r9 = 1;
      while(r6 == 0x0) {
        r1 = MEMORY.ref(4, r4 + 0x10).get();
        r1 = r1 << 4;
        r1 = r1 + 0x24;
        FUN_80a1a40(88, r1);

        if(r9 != 0) {
          r9 = 0;

          r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          if(r7.items_1c8.get(r1).get() != 0x0) {
            FUN_80a17c4(r7._48.get(r1).deref());
          }

          //LAB_80a6e34
          if(MEMORY.ref(4, CPU.sp().value + 0x28).get() != 0x0) {
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
            sleep(1);
            FUN_80a6b64(r8, 0, r4);
          }

          //LAB_80a6e54
          r1 = CPU.sp().value + 0x50;
          FUN_80a6a98(r8, r1, r4);
          r3 = MEMORY.ref(4, r4 + 0x18).get();
          r7.abilityId_178.get(sp30).set(r7.items_1c8.get(r3).get());
          r7._21c.deref()._05.set(13);
          r2 = MEMORY.ref(4, r4 + 0x18).get();
          if(r7.items_1c8.get(r2).get() != 0x0) {
            final GraphicsStruct1c struct = r7._48.get(r2).deref();
            struct._05.set(9);
            struct.rotation_0c.set(r6);
            struct.z_0f.set(250);
          }

          //LAB_80a6ea0
          //LAB_80a6eae
          for(r5 = 0; r5 < r7.partyMemberCount_219.get(); r5++) {
            setSpriteAnimation_(r7.charSprites_114.get(r5).deref(), 1);
          }
        }

        //LAB_80a6ece
        sleep(1);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(MEMORY.ref(4, r4 + 0x18).get());

        if((heldButtonsLastFrame_3001ae8.get() & 0x4) == 0x0) {
          r0 = FUN_80a1fd4(0, MEMORY.ref(4, r4 + 0x14).get(), 5, CPU.sp().value + 0x44, CPU.sp().value + 0x3c);
        } else {
          //LAB_80a6efc
          r0 = -1;
        }

        //LAB_80a6f00
        if(r0 == 0x1) {
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(1);
          r9 = 1;
        }

        //LAB_80a6f0a
        if(r0 == 0x0) {
          r9 = 1;
        }

        //LAB_80a6f12
        if(r0 == -1) {
          r9 = 0;
        }

        jmp_80a72b8:
        {
          //LAB_80a6f1e
          if(r7._268.get() == 0x0) {
            //LAB_80a6f2c
            if((pressedButtons_3001c94.get() & 0x4) != 0x0) {
              if(MEMORY.ref(4, CPU.sp().value + 0x18).get() == 0x0) {
                r3 = MEMORY.ref(4, r4 + 0x18).get();
                if(getAbility_(r7.items_1c8.get(r3).get() & 0x3fff).fieldPsynergyId_0c.get() == 0x0) {
                  playSound_(0x72);
                } else {
                  //LAB_80a6f78
                  playSound_(0xae);
                  MEMORY.ref(4, CPU.sp().value + 0x18).setu(1);
                  r7._220.or(0x2);
                  FUN_8015068(r8, 0, 88, 120, 96);
                  drawIcon_(0xae1, r8, 0, 88);
                }

                //LAB_80a6fae
              }
            }

            //LAB_80a6fb0
            if((heldButtonsLastFrame_3001ae8.get() & 0x4) == 0x0) {
              //LAB_80a6fcc
              if(MEMORY.ref(4, CPU.sp().value + 0x18).get() == 0x1) {
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
                r7._220.and(~0x2);
                FUN_8015068(r8, 0, 88, 120, 96);
                drawIcon_(0xb89, r8, 0, 88);
              }
            }
          }

          //LAB_80a7010
          if((pressedButtons_3001c94.get() & 0x1) != 0x0) {
            if(r7._268.get() != 0x0) {
              //LAB_80a6d54
              playSound_(0x82);
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get());
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
              break;
            }

            //LAB_80a702a
            r3 = r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get();
            if(r3 != 0x0) {
              if(FUN_80a735c(r3) != 0x0) {
                playSound_(0x72);
                break jmp_80a72b8;
              }

              //LAB_80a704a
              r3 = MEMORY.ref(4, r4 + 0x18).get();
              r2 = getAbility_(r7.items_1c8.get(r3).get() & 0x3fff).cost_09.get();
              if(r2 > sp20.pp_3a.get()) {
                playSound_(0x72);
              } else {
                //LAB_80a707c
                playSound_(0xad);
                r3 = MEMORY.ref(4, r4 + 0x18).get();
                MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7.items_1c8.get(r3).get());
                MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
                break;
              }
            }
          }

          //LAB_80a709a
          if((pressedButtons_3001c94.get() & 0x2) != 0x0) {
            //LAB_80a6d58
            playSound_(0x71);
            MEMORY.ref(4, CPU.sp().value + 0x2c).setu(-1);
            MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
            break;
          }

          //LAB_80a70a8
          if((pressedButtons_3001b04.get() & 0x100) != 0x0 || (pressedButtons_3001b04.get() & 0x200) != 0x0) {
            //LAB_80a70c2
            if((heldButtonsLastFrame_3001ae8.get() & 0x4) == 0x0) {
              //LAB_80a70d0
              r3 = r7._268.get();
              r5 = (-r3 | r3) >>> 31;
              r5 = 2 - r5;
              playSound_(0x6f);
              r7._260.get(r7._21a.get(sp30).get()).set(MEMORY.ref(4, r4 + 0x18).get());
              r6 = r7._1c.get(sp30).get();
              r5 = r5 << 24;

              //LAB_80a710c
              do {
                if((pressedButtons_3001b04.get() & 0x100) != 0x0) {
                  r6 = r6 + 0x1;
                } else {
                  //LAB_80a7128
                  r6 = r6 - 0x1;
                }

                //LAB_80a712a
                r6 = modS(r6 + r7.partyMemberCount_219.get(), r7.partyMemberCount_219.get());
                r7._08.set(r7.partyMemberIds_208.get(r6).get());
                r7._21a.get(0).set(r7.partyMemberIds_208.get(r6).get());
                r7.itemCount_218.set(FUN_80a68ec(getUnit_(r7._21a.get(0).get()), r7.items_1c8, r5 >> 24));
              } while(r7.itemCount_218.get() == 0x0);

              r7._1c.get(sp30).set(r6);
              r5 = 0x0;

              //LAB_80a717c
              do {
                r7._144.get(r5).set(30);
                r3 = r5 + 0x1;
                r3 = r3 << 24;
                r5 = r3 >>> 24;
              } while((r5 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL));

              r7._144.get(r6).set(26);
              drawCharInfoPanel(r7.panel_24.deref(), r7.partyMemberIds_208.get(r6).get(), 0, 0);
              FUN_80a1804(r7, r7.partyMemberIds_208.get(r6).get());
              break;
            }
          }

          //LAB_80a71c8
          if((pressedButtons_3001c94.get() & 0x200) != 0x0 && (heldButtonsLastFrame_3001ae8.get() & 0x4) != 0x0) {
            if(getAbility_(r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get() & 0x3fff).fieldPsynergyId_0c.get() == 0x0) {
              playSound_(0x72);
            } else {
              //LAB_80a7214
              playSound_(0x82);

              if(FUN_80a65e4(r7._21a.get(sp30).get(), r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get(), 0) != 0x0) {
                //LAB_80a6d6e
                MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get());
                r7._268.set(1);
                MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
                break;
              }
            }
          }

          //LAB_80a7244
          if((pressedButtons_3001c94.get() & 0x100) != 0x0 && (heldButtonsLastFrame_3001ae8.get() & 0x4) != 0x0) {
            if(getAbility_(r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get() & 0x3fff).fieldPsynergyId_0c.get() == 0x0) {
              //LAB_80a727c
              playSound_(0x72);
              //LAB_80a7290
            } else if(FUN_80a65e4(r7._21a.get(sp30).get(), r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get(), 1) != 0x0) {
              //LAB_80a6d8a
              playSound_(0x82);
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7.items_1c8.get(MEMORY.ref(4, r4 + 0x18).get()).get());
              r7._268.set(2);
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(1);
              break;
            }
          }
        }

        //LAB_80a72b8
        r6 = readFlag_(0x150);
      }
    }

    //LAB_80a72e4
    r7._220.and(~0x2);
    FUN_80a17c4(r7._44._00.derefNullable());
    r7._174.get(sp30).set(MEMORY.ref(4, r4 + 0x18).get());
    r7._260.get(r7._21a.get(sp30).get()).set(MEMORY.ref(4, r4 + 0x18).get());
    r7.abilityId_178.get(sp30).set(MEMORY.ref(2, CPU.sp().value + 0x2c).getUnsigned());
    if(readFlag_(0x150) != 0x0) {
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(-1);
    }

    //LAB_80a733e
    sleep(1);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    CPU.sp().value += 0x64;
    return r0;
  }

  @Method(0x80a735c)
  public static int FUN_80a735c(final int r0) {
    final Ability10 ability = getAbility_(r0 & 0x3fff);

    if(ability.fieldPsynergyId_0c.get() != 0 || (ability.flags_01.get() & 0xc0) == 0xc0) {
      return 0;
    }

    return 1;
  }

  @Method(0x80a7478)
  public static int handleStatusMenu() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a8b10)
  public static int getAfflictions(final boolean[] out, final boolean showDead, final int charId) {
    final Unit14c charData = getUnit_(charId);

    //LAB_80a8b24
    for(int i = 0; i < 5; i++) {
      out[i] = false;
    }

    int count = 0;
    if(charData.hp_38.get() == 0 && showDead) {
      out[0] = true;
      count++;
    }

    //LAB_80a8b3e
    final int r3 = charData.affliction_131.get();
    if(r3 != 0) {
      if(r3 == 1) {
        out[1] = true;
      } else {
        //LAB_80a8b54
        out[2] = true;
      }

      //LAB_80a8b58
      count++;
    }

    //LAB_80a8b5a
    if(charData.curse_130.get() != 0) {
      out[3] = true;
      count++;
    }

    //LAB_80a8b70
    if(charData.haunt_140.get() != 0) {
      out[4] = true;
      count++;
    }

    //LAB_80a8b82
    return count;
  }

  @Method(0x80a9a5c)
  public static void FUN_80a9a5c(final Panel24 panel, final int charId, final int r2) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    getUnit_(charId);
    FUN_80a9cbc();
    FUN_80a345c();
    drawIcon_(0xb24, panel, 0, 0);
    drawIcon_(0xb25, panel, 0, 32);
    drawIcon_(0xb26, panel, 0, 16);
    drawIcon_(0xb27, panel, 0, 48);
    FUN_80a9aec(panel, r8.items_1c8);

    if(r2 == 0) {
      sleep(1);
      FUN_80a3e28(r8.items_1c8, 0x1);
      FUN_80a9c18(r8.items_1c8);
    }

    //LAB_80a9ad8
  }

  @Method(0x80a9aec)
  public static void FUN_80a9aec(final Panel24 r0, final ArrayRef<UnsignedShortRef> r1) {
    //LAB_80a9b00
    for(int i = 0; i < 15; i++) {
      final int r0_0 = r1.get(i).get();
      if((r0_0 & 0x200) != 0) {
        final int r5 = r0_0 & 0x1ff;
        final int r3 = getItem_(r5).type_02.get();
        if(r3 == 1) {
          //LAB_80a9b3e
          drawIcon_(r5 + 0x182, r0, 8, 8);
        } else if(r3 == 2) {
          //LAB_80a9b4e
          drawIcon_(r5 + 0x182, r0, 8, 56);
        } else if(r3 == 3) {
          //LAB_80a9b5e
          drawIcon_(r5 + 0x182, r0, 8, 40);
        } else if(r3 == 4) {
          //LAB_80a9b6e
          drawIcon_(r5 + 0x182, r0, 8, 24);
        }
      }

      //LAB_80a9b7c
    }
  }

  @Method(0x80a9c18)
  public static void FUN_80a9c18(final ArrayRef<UnsignedShortRef> r0) {
    FUN_80a9cbc();

    final ArrayRef<Pointer<GraphicsStruct1c>> r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a9c36
    for(int i = 0; i < 15; i++) {
      final int r2 = r0.get(i).get();
      if(r2 != 0 && (r2 & 0x200) != 0) {
        final GraphicsStruct1c r5 = r7.get(i).derefNullable();
        if(r5 != null) {
          final int itemType = getItem_(r2 & 0x1ff).type_02.get();
          if(itemType == 1) {
            //LAB_80a9c84
            r5.x_06.set(216);
            r5.y_08.set(32);
          } else if(itemType == 2) {
            //LAB_80a9c88
            r5.x_06.set(216);
            r5.y_08.set(80);
          } else if(itemType == 3) {
            //LAB_80a9c8c
            r5.x_06.set(216);
            r5.y_08.set(64);
          } else if(itemType == 4) {
            r5.x_06.set(216);
            r5.y_08.set(48);
          }

          //LAB_80a9c96
          FUN_80a17c4(r5);
        }
      }

      //LAB_80a9ca0
    }
  }

  @Method(0x80a9cbc)
  public static void FUN_80a9cbc() {
    final ArrayRef<Pointer<GraphicsStruct1c>> r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._48;

    //LAB_80a9cd2
    for(int r6 = 0; r6 < 0x20; r6++) {
      final GraphicsStruct1c r0 = r5.get(r6).derefNullable();

      if(r0 != null) {
        r0.x_06.set(0xf8);
        r0.y_08.set(0xa8);
        FUN_80a17c4(r0);
      }

      //LAB_80a9ce2
    }
  }

  @Method(0x80a9e48)
  public static int FUN_80a9e48(final int itemSlot, final int charId, final int r2) {
    final Unit14c charData = getUnit_(charId);
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int itemId = charData.items_d8.get(itemSlot).get() & 0x1ff;

    if(FUN_80a9f10(getItem_(itemId).useAbility_28.get() & 0x3fff, charId, r2, 1) == -1) {
      return -1;
    }

    final Item2c item = getItem_(itemId);
    final int useType = item.useType_0c.get();
    if(useType == 1) {
      takeItem_(charId, itemSlot);
      menu.itemCount_218.set(getCharItems(charData, menu.items_1c8));
    }

    //LAB_80a9ed6
    if(useType == 4) {
      if(itemId == 0xb8) {
        itemId = 0xb9;
      }

      //LAB_80a9ee6
      charData.items_d8.get(itemSlot).set(itemId);
    }

    //LAB_80a9eec
    //LAB_80a9eee
    return 0;
  }

  @Method(0x80aa448)
  public static void FUN_80aa448(final int itemId) {
    FUN_80aa460(getItem_(itemId).useAbility_28.get() & 0x3fff);
  }

  @Method(0x80ae99c)
  public static int drawComparisonArrow(final Panel24 panel, final int x, final int y, final int isGreater) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80ae9b6
    final GraphicsStruct1c r0_0 = FUN_80150c8(isGreater == 0 ? menu.downArrow_392.get() : menu.upArrow_394.get(), 0x40000000, panel, x, y);
    if(r0_0 == null) {
      return -1;
    }

    //LAB_80ae9d2
    r0_0._04.set(0);
    r0_0.rotation_0c.set(0);
    r0_0._05.set(1);

    //LAB_80ae9de
    return 1;
  }

  /** Using an herb */
  @Method(0x80a9f10)
  public static int FUN_80a9f10(final int abilityId, int r1, final int r2, final int r3) {
    final int sp0c = r1;
    int r10 = r2;
    final Ability10 ability = getAbility_(abilityId);
    final int sp04 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    int r9 = 0;
    int r7 = 0;
    int r8 = 0;

    //LAB_80a9f4a
    Unit14c r5 = getUnit_(r10 != 9 ? r10 : 0);

    //LAB_80a9f66
    for(int sp00 = 0; sp00 < MEMORY.ref(1, sp04 + 0x219).getUnsigned(); sp00++) {
      if(ability.range_08.get() == 0xff) {
        r10 = MEMORY.ref(2, sp04 + 0x208 + sp00 * 0x2).getUnsigned();
        r5 = getUnit_(r10);
      }

      //LAB_80a9f84
      int r6 = ability.power_0a.get();

      switch((ability.flags_01.get() & 0xf) - 1) {
        case 0:
          //LAB_80a9fcc
          if(r3 == 0) {
            if(ability.element_02.get() != 0x4) {
              r1 = getUnit_(sp0c).elementalPowerResist_48.get(ability.element_02.get()).power_00.get();
            } else {
              //LAB_80a9fec
              r1 = 100;
            }

            //LAB_80a9fee
            r6 = FUN_8077190(r6, r1, 0x100);
          }

          //LAB_80a9ffa
          if(r5.hp_38.get() <= 0) {
            if(r8 == 0x0) {
              //LAB_80aa00c
              r7 = 0x2;
            }
          } else {
            //LAB_80aa010
            if(r5.hp_38.get() == r5.maxHp_34.get()) {
              if(r8 == 0x0) {
                //LAB_80aa022
                r7 = 0x4;
              }
            } else {
              //LAB_80aa026
              r5.hp_38.add(r6);
              if(r5.hp_38.get() > r5.maxHp_34.get()) {
                r6 = r6 - (r5.hp_38.get() - r5.maxHp_34.get());
                r5.hp_38.set(r5.maxHp_34.get());
                if(r8 == 0x0) {
                  r7 = 0x0;
                }
              } else {
                //LAB_80aa042
                if(r8 == 0x0) {
                  r7 = 0x1;
                }
              }

              //LAB_80aa04a
              calcHpPpFractions(r10);
              r9 = 1;
              if(ability.range_08.get() == 0xff) {
                //LAB_80aa05e
                r8 = 1;
                r7 = 0x3;
              }
            }
          }
          break;

        case 8:
          //LAB_80aa066
          final int rand = rand() * 4 >>> 16;
          final int offset;
          if(rand == 0) {
            offset = -1;
          } else {
            //LAB_80aa078
            offset = (rand ^ 0x1) != 0 ? 0 : 1;
          }

          //LAB_80aa086
          switch((abilityId & 0x3fff) - 0x104) {
            case 0:
              //LAB_80aa0b4
              r5.baseMaxHp_10.add(r6 + offset);
              r7 = 0x10;
              r9 = 1;
              break;

            case 1:
              //LAB_80aa0c4
              r5.baseMaxPp_12.add(r6 + offset);
              r7 = 0x11;
              r9 = 1;
              break;

            case 4:
              //LAB_80aa0d4
              r5.baseAgility_1c.add(r6 + offset);
              r7 = 0x12;
              r9 = 1;
              break;

            case 5:
              //LAB_80aa0e4
              r5.baseLuck_1e.add(r6);
              r7 = 0x13;
              r9 = 1;
              break;

            case 2:
              //LAB_80aa0f2
              r5.baseAttack_18.add(r6 + offset);
              FUN_8015120(3, 5);
              r7 = 0x14;
              r9 = 1;
              break;

            case 3:
              //LAB_80aa10a
              r5.baseDefence_1a.add(r6 + offset);
              FUN_8015120(4, 5);
              r7 = 0x15;
              r9 = 1;
              break;

            case 10:
              //LAB_80aa122
              if(r5.pp_3a.get() == r5.maxPp_36.get()) {
                if(r8 == 0x0) {
                  r7 = 0x7;
                }
              } else {
                //LAB_80aa13c
                r5.pp_3a.add(r6);
                if(r5.pp_3a.get() > r5.maxPp_36.get()) {
                  r6 = r6 - (r5.pp_3a.get() - r5.maxPp_36.get());
                  r5.pp_3a.set(r5.maxPp_36.get());
                  if(r8 == 0x0) {
                    r7 = 0x5;
                  }
                } else {
                  //LAB_80aa158
                  if(r8 == 0x0) {
                    r7 = 0x6;
                  }
                }

                //LAB_80aa160
                calcHpPpFractions(r10);
                r9 = 1;
                if(ability.range_08.get() == 0xff) {
                  r8 = 1;
                  r7 = 8;
                }
              }
              break;
          }

          break;
      }

      //case 1: // switch 80a9fa0
      //case 2: // switch 80a9fa0
      //case 3: // switch 80a9fa0
      //case 4: // switch 80a9fa0
      //case 5: // switch 80a9fa0
      //case 6: // switch 80a9fa0
      //case 7: // switch 80a9fa0
      //case 9: // switch 80a9fa0
      //LAB_80aa178
      switch(ability.effect_03.get() - 1) {
        case 0:
          //LAB_80aa270
          if(r5.hp_38.get() <= 0) {
            //LAB_80aa284
            if(r8 == 0x0) {
              //LAB_80aa28c
              r7 = 0x2;
            }
          } else {
            if(r5.hp_38.get() == r5.maxHp_34.get()) {
              //LAB_80aa284
              if(r8 == 0x0) {
                //LAB_80aa28c
                r7 = 0x2;
              }
            } else {
              //LAB_80aa2ac
              r5.hp_38.add(r6);
              if(r5.hp_38.get() > r5.maxHp_34.get()) {
                r5.hp_38.set(r5.maxHp_34.get());
                if(r8 == 0x0) {
                  r7 = 0x0;
                }
              } else {
                //LAB_80aa2c4
                if(r8 == 0x0) {
                  r7 = 0x1;
                }
              }

              calcHpPpFractions(r10);
              r9 = 1;
            }
          }
          break;

        case 1:
          //LAB_80aa2ce
          if(r5.pp_3a.get() == r5.maxPp_36.get()) {
            if(r8 == 0x0) {
              r7 = 0x7;
            }
          } else {
            //LAB_80aa2e8
            r5.pp_3a.add(r6);
            if(r5.pp_3a.get() > r5.maxPp_36.get()) {
              r5.pp_3a.set(r5.maxPp_36.get());
              if(r8 == 0x0) {
                r7 = 0x5;
              }
            } else {
              //LAB_80aa300
              if(r8 == 0x0) {
                r7 = 0x6;
              }
            }

            //LAB_80aa308
            calcHpPpFractions(r10);
            r9 = 1;
          }
          break;

        case 4:
          //LAB_80aa314
          if(r5.hp_38.get() == 0) {
            r5.hp_38.set(r5.maxHp_34.get());
            calcHpPpFractions(r10);
            r9 = 1;
            if(r8 == 0x0) {
              r7 = 0xc;
            }
          } else {
            //LAB_80aa334
            if(r8 == 0x0) {
              r7 = 0xd;
            }
          }
          break;

        case 55:
          //LAB_80aa33e
          if(r5.hp_38.get() != 0) {
            if(r8 == 0x0) {
              r7 = 0xd;
            }
          } else {
            r5.hp_38.set(r5.maxHp_34.get() / 2);
            calcHpPpFractions(r10);
            if(r8 == 0x0) {
              r7 = 0xc;
            }
          }
          break;

        case 56:
          //LAB_80aa358
          if(r5.hp_38.get() != 0) {
            //LAB_80aa380
            if(r8 == 0x0) {
              r7 = 0xd;
            }
          } else {
            r5.hp_38.set(divideS(r5.maxHp_34.get() * 7, 10));
            calcHpPpFractions(r10);
            if(r8 == 0x0) {
              r7 = 0xc;
            }
          }
          break;

        case 2:
          //LAB_80aa38a
          if(r5.affliction_131.get() != 0) {
            r5.affliction_131.set(0);
            r9 = 1;
            if(r8 == 0x0) {
              r7 = 0xa;
            }
          } else {
            //LAB_80aa3a8
            if(r8 == 0x0) {
              r7 = 0xb;
            }
          }
          break;
      }

      //LAB_80aa3b0
      if(ability.range_08.get() != 0xff) {
        break;
      }
    }

    //LAB_80aa3d6
    if(r9 == 0) {
      MEMORY.ref(2, sp04 + 0x25a).setu(r7);
      return -1;
    }

    //LAB_80aa3ea
    //LAB_80aa3fc
    for(int sp00 = 0; sp00 < MEMORY.ref(1, sp04 + 0x219).getUnsigned(); sp00++) {
      recalcStats_(MEMORY.ref(2, sp04 + 0x208 + sp00 * 0x2).getUnsigned());
    }

    //LAB_80aa420
    MEMORY.ref(2, sp04 + 0x25a).setu(r7);

    //LAB_80aa42a
    return 0;
  }

  @Method(0x80aa460)
  public static void FUN_80aa460(final int abilityId) {
    final Ability10 r0 = getAbility_(abilityId);
    final int r3 = r0.flags_01.get();
    final int r2 = r3 & 0xf;
    if(r2 == 0x1) {
      //LAB_80aa476
      FUN_80a2438(0x7e);
      FUN_80a2438(0x7e);
    } else if(r2 == 0xb) {
      //LAB_80aa47c
      FUN_80a2438(0x7e);
    } else {
      //LAB_80aa484
      switch(r0.effect_03.get()) {
        case 5: // switch 80aa494
          //LAB_80aa514
          FUN_80a2438(0x52);
          break;

        case 3: // switch 80aa494
          //LAB_80aa51c
          FUN_80a2438(0x54);
          break;

        default: // switch 80aa494
          //LAB_80aa524
          FUN_80a2438(0x5b);
          break;
      }
    }

    //LAB_80aa52a
  }

  @Method(0x80aa538)
  public static int FUN_80aa538(final int r0, final int r1) {
    return modS(r0 + r1, r1);
  }

  @Method(0x80aa544)
  public static void FUN_80aa544(int r0) {
    int r1;
    int r2;
    int r3;

    r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    r3 = r3 + 0x134;
    r0 = r0 + 0x3d;
    r1 = 0x20;
    r2 = 0x3;

    //LAB_80aa556
    do {
      r2 = r2 - 0x1;
      MEMORY.ref(2, r3).setu(r1);
      MEMORY.ref(2, r3 + 0x10).setu(r0);
      r1 = r1 + 0x38;
      r3 = r3 + 0x2;
    } while(r2 >= 0x0);
  }

  @Method(0x80aa56c)
  public static int handleDjinnMenu() {
    final Menua70 r7 = MEMORY.ref(4, mallocSlotChip(55, 0xa70), Menua70::new);
    final int r9 = _200044c.get();
    _200044c.set(2);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(1);
    drawPanelBackground_(0, 0, 30, 20);
    sleep(1);
    FUN_80a1090();
    final int r8 = mallocBoard(0x2130);
    r7._184.set(r8);
    MEMORY.ref(4, r8 + 0x2128).setu(0);
    MEMORY.ref(4, r8 + 0x212c).setu(0);
    if(readFlag_(0x16e) != 0) {
      final int r3;
      if(readFlag_(0x16f) == 0) {
        if(readFlag_(0x171) == 0) {
          r3 = 0x1;
        } else {
          //LAB_80aa5fa
          r3 = 0xe;
        }
      } else {
        //LAB_80aa5fe
        if(readFlag_(0x171) == 0) {
          r3 = 0x1b;
        } else {
          //LAB_80aa628
          r3 = 0x1c;
        }
      }

      //LAB_80aa62a
      MEMORY.ref(4, r8 + 0x212c).setu(r3);
    }

    //LAB_80aa62c
    FUN_80a1070();
    FUN_80153e0(1);
    FUN_8015418(0x6002500);
    r7.partyMemberCount_219.set(getPartyMemberIds_(r7.partyMemberIds_208.getAddress()));
    FUN_80ae88c();
    FUN_80a3354();
    FUN_80aa544(0);
    FUN_80a2144(14);
    r7.panel_10c.set(addPanel_(13, 0, 17, 5, 2));
    r7.abilityId_178.get(0).set(0xff);
    r7._1c.get(0).set(0);
    r7._1c.get(1).set(0);
    r7._174.get(0).set(0);
    r7._174.get(1).set(0);
    FUN_80ad508();
    FUN_80aa768();
    FUN_80ad658();
    FUN_80ae8dc();
    sleep(1);
    FUN_80a34c0();
    drawPanelBackground_(0, 0, 30, 20);
    boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.set(0);
    FUN_80152a8();
    FUN_80153e0(0);
    MEMORY.memcpy(0x6004000, r8 + 0xa8, 0x2000);
    MEMORY.memcpy(0x5000080, r8 + 0x20a8, 0x80);
    sleep(1);
    FUN_80a1050();
    FUN_8015410(0, 0, 30, 20);
    setMallocAddress(r7._184.get());
    freeSlot(55);
    FUN_808a548();
    _200044c.set(r9);
    return 1;
  }

  @Method(0x80aa768)
  public static int FUN_80aa768() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final GraphicsStruct1c struct = r7._14.get(0).deref();
    struct._05.set(13);
    struct.rotation_0c.set(0);
    CPU.r8().value = 0;
    FUN_80aad10();
    sleep(1);
    r4 = 0;
    r5 = 0x2;
    CPU.r10().value = 0;

    //LAB_80aa798
    do {
      //LAB_80aa79e
      switch(r5) {
        case 0: // switch 80aa7a8
          //LAB_80aa7e8
          if(r4 < 0x0) {
            //LAB_80aa7ee
            CPU.r10().value = -1;
            CPU.r8().value = 1;
          }
          r5 = 0x2;
          break;

        case 2: // switch 80aa7a8
          //LAB_80aa7fa
          FUN_80aa544(0);
          FUN_80ad5b4(1, 0, 200, 0);
          r4 = FUN_80ab5e4(0);
          r5 = 0xf;
          if(r4 != 0xa) {
            //LAB_80aa81c
            r5 = 0x0;
            if(r4 >= 0x0) {
              //LAB_80aa824
              r7._174.get(1).set(r7._1c.get(0).get());
              r5 = 0xa;
              if(r4 != 0x7) {
                //LAB_80aa838
                r5 = 0x3;
              }
            }
          }
          break;

        case 10: // switch 80aa7a8
          //LAB_80aa83c
          r7._08.set(r7.partyMemberIds_208.get(r7._1c.get(0).get()).get());
          r7._21a.get(0).set(r7.partyMemberIds_208.get(r7._1c.get(0).get()).get());
          r4 = FUN_80ae2f4();
          if(r4 == -2) {
            //LAB_80aa864
            CPU.r8().value = 1;
          }
          r5 = 0x2;
          break;

        case 15: // switch 80aa7a8
          //LAB_80aa86a
          r4 = FUN_80ab314();
          if(r4 == -2) {
            //LAB_80aa87a
            CPU.r8().value = 1;
          }
          r5 = 0x2;
          break;

        case 8: // switch 80aa7a8
          //LAB_80aa880
          r5 = 0x0;
          if(r7.itemCount_218.get() != 0) {
            //LAB_80aa890
            r4 = FUN_80ab5e4(1);
            if(r4 == -2) {
              CPU.r8().value = 1;
            }

            //LAB_80aa8a4
            r5 = 0x4;
            if(r4 >= 0x0) {
              //LAB_80aa8ac
              r5 = 0x9;
            }
          }
          break;

        case 3: // switch 80aa7a8
          //LAB_80aa8b0
          FUN_80aafb8(r7._184.get());
          FUN_80aa544(-8);
          r7._08.set(r7.partyMemberIds_208.get(r7._1c.get(0).get()).get());
          r7._21a.get(0).set(r7.partyMemberIds_208.get(r7._1c.get(0).get()).get());
          FUN_80ad5b4(0, r7._1c.get(0).get() * 0x38 + 0x30, 54, 0);
          r4 = FUN_80ab5e4(1);

          //LAB_80aa90a
          for(r1 = 0; r1 < r7.partyMemberCount_219.get(); r1++) {
            r7._144.get(r1).add(0x8);
          }

          //LAB_80aa91a
          if(r4 == -2) {
            CPU.r8().value = 1;
          }

          //LAB_80aa926
          if(r4 < 0x0) {
            r5 = 0x2;
          } else {
            //LAB_80aa92c
            r3 = r4 - 0x3;
            if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r4 == 0x8 || r4 == 0x9) {
              //LAB_80aa93a
              r7._21a.get(1).set(r7.partyMemberIds_208.get(r7._1c.get(1).get()).get());
            }

            //LAB_80aa94e
            if(r4 < 0x0) {
              r5 = 0x2;
              //LAB_80aa954
            } else if(r4 == 0x1) {
              r5 = 0x5;
              //LAB_80aa95c
            } else if(r4 == 0x2) {
              r5 = 0x6;
              //LAB_80aa964
            } else if(r4 == 0x3) {
              r7._220.set(2);
              r5 = 0x7;
              //LAB_80aa976
            } else if(r4 == 0x4) {
              r7._220.set(2);
              r5 = 0x9;
              //LAB_80aa988
            } else if(r4 == 0x5) {
              r5 = 0xb;
              //LAB_80aa990
            } else if(r4 == 0x6) {
              r5 = 0xc;
              //LAB_80aa998
            } else if(r4 == 0x8) {
              r7._220.set(2);
              r5 = 0xd;
              //LAB_80aa9aa
            } else if(r4 == 0x9) {
              //LAB_80aa9b0
              r7._220.set(2);
              r5 = 0xe;
            }
          }
          break;

        case 7: // switch 80aa7a8
          //LAB_80aa9be
          r4 = FUN_80ad6d4(1);
          if(r4 == -2) {
            CPU.r8().value = 1;
          }

          //LAB_80aa9d2
          r5 = 0x3;
          if(r4 < 0x0) {
            break;
          }

          // fall through

        case 13: // switch 80aa7a8
          //LAB_80aa9da
          playSound_(0x7e);
          r1 = r7._256.get(0).get();
          r2 = r7._254.get(0).get();
          r3 = r7._21a.get(1).get();
          r0 = r7._21a.get(0).get();
          r0 = FUN_80771d0(r0, r1, r2, r3);
          r4 = r0;
          recalcStats_(r7._21a.get(0).get());
          recalcStats_(r7._21a.get(1).get());
          r7._14.get(0).deref()._05.set(13);
          FUN_8015278(r7.panel_30.derefNullable());
          FUN_80aaf58(r7._184.get());
          r0 = modU(r7._174.get(1).get(), 10);
          CPU.r12().value = 0;
          r0 = r0 << 16;
          r6 = r7.abilityId_178.get(0).get();
          r0 = r0 >>> 16;
          r1 = 0x0;
          r5 = r0;
          r5 = r5 + 0xa0;

          //LAB_80aaa4e
          do {
            r2 = r7._184.get();
            r3 = MEMORY.ref(1, r2 + r5).get();
            if(r1 >= r3) {
              break;
            }
            if(r6 == MEMORY.ref(1, r2 + (r0 * 0xa + r1) * 0x2).getUnsigned()) {
              CPU.r12().value = r1;
              break;
            }

            //LAB_80aaa4c
            r1 = r1 + 0x1;
          } while(true);

          //LAB_80aaa6e
          r1 = CPU.r12().value;
          r3 = r1 << 2;
          r3 = r3 + CPU.r12().value;
          r3 = r3 << 1;
          r3 = r0 + r3;
          r7._174.get(0).set(r3);
          r7._14.get(0).deref()._05.set(1);
          r5 = 0x0;
          break;

        case 6: // switch 80aa7a8
          //LAB_80aaaa4
          r4 = FUN_80ad6d4(2);
          if(r4 == -2) {
            CPU.r8().value = 1;
          }

          //LAB_80aaab8
          r5 = 0x3;
          if(r4 < 0x0) {
            break;
          }

          // fall through

        case 12: // switch 80aa7a8
          //LAB_80aaac0
          playSound_(0xaf);
          r1 = r7._256.get(0).get();
          r2 = r7._254.get(0).get();
          r0 = r7._21a.get(0).get();
          FUN_80771b8(r0, r1, r2);
          r2 = r7._254.get(0).get();
          r1 = r7._256.get(0).get();
          r0 = r7._21a.get(0).get();
          FUN_80771c8(r0, r1, r2);
          if(true)throw new RuntimeException("Something wrong here, r4 set to r0 but previous call doesn't return a value");
          r4 = r0;
          recalcStats_(r7._21a.get(0).get());
          r7._14.get(0).deref()._05.set(13);
          FUN_8015278(r7.panel_30.deref());
          r7._14.get(0).deref()._05.set(1);
          r5 = 0x2;
          break;

        case 9: // switch 80aa7a8
          //LAB_80aaaec
          r4 = FUN_80ad6d4(0);
          if(r4 == -2) {
            CPU.r8().value = 1;
          }

          //LAB_80aab00
          r5 = 0x3;
          if(r4 < 0x0) {
            break;
          }

          // fall through

        case 14: // switch 80aa7a8
          //LAB_80aab08
          playSound_(0x7e);
          r1 = r7._256.get(0).get();
          r2 = r7._254.get(0).get();
          r3 = r7._21a.get(1).get();
          r0 = r7._21a.get(0).get();
          FUN_80771d0(r0, r1, r2, r3);
          r1 = r7._256.get(1).get();
          r2 = r7._254.get(1).get();
          r0 = r7._21a.get(1).get();
          r3 = r7._21a.get(0).get();
          r0 = FUN_80771d0(r0, r1, r2, r3);
          r4 = r0;
          recalcStats_(r7._21a.get(0).get());
          recalcStats_(r7._21a.get(1).get());
          FUN_80aaf58(r7._184.get());
          r0 = modU(r7._174.get(1).get(), 10);
          CPU.r12().value = 0;
          r0 = r0 << 16;
          r6 = r7.abilityId_178.get(0).get();
          r0 = r0 >>> 16;
          r1 = 0x0;
          r5 = r0;
          r5 = r5 + 0xa0;

          //LAB_80aab84
          do {
            r2 = r7._184.get();
            r3 = MEMORY.ref(1, r2 + r5).get();
            if(r1 >= r3) {
              break;
            }
            r3 = r0 << 2;
            r3 = r3 + r0;
            r3 = r3 << 1;
            r3 = r3 + r1;
            r3 = r3 << 1;
            r3 = MEMORY.ref(1, r2 + r3).getUnsigned();
            if(r6 == r3) {
              CPU.r12().value = r1;
              break;
            }

            //LAB_80aab82
            r1 = r1 + 0x1;
          } while(true);

          //LAB_80aaba4
          r1 = CPU.r12().value;
          r3 = r1 << 2;
          r3 = r3 + CPU.r12().value;
          r3 = r3 << 1;
          r3 = r0 + r3;
          r7._174.get(0).set(r3);
          r7._14.get(0).deref()._05.set(1);
          r5 = 0x2;
          break;

        case 4: // switch 80aa7a8
          //LAB_80aabc0
          if(r4 == -1) {
            CPU.r10().value = -1;
            r5 = 0x2;
          } else {
            //LAB_80aabcc
            r2 = r7._220.get();
            if((r2 & 0x1) != 0) {
              r5 = 0x8;
              //LAB_80aabe0
            } else if((r2 & 0x2) != 0) {
              r5 = 0x7;
            }
          }
          break;

        case 5: // switch 80aa7a8
          //LAB_80aabec
          r4 = FUN_80ad6d4(3);
          if(r4 == -2) {
            CPU.r8().value = 1;
          }

          //LAB_80aac00
          r5 = 0x3;
          if(r4 < 0x0) {
            break;
          }

          // fall through

        case 11: // switch 80aa7a8
          //LAB_80aac06
          playSound_(0x8b);
          r1 = r7._256.get(0).get();
          r2 = r7._254.get(0).get();
          r0 = r7._21a.get(0).get();
          setDjinn_(r0, r1, r2);
          r2 = r7._254.get(0).get();
          r1 = r7._256.get(0).get();
          r0 = r7._21a.get(0).get();
          r0 = recoverDjinn_(r0, r1, r2);
          r4 = r0;
          recalcStats_(r7._21a.get(0).get());
          r7._14.get(0).deref()._05.set(13);
          FUN_8015278(r7.panel_30.derefNullable());
          r7._14.get(0).deref()._05.set(1);
          r5 = 0x2;
          break;

        default:
          //LAB_80aac52
          CPU.r8().value = 1;
      }

      //LAB_80aac56
    } while(CPU.r8().value == 0);

    //LAB_80aac5e
    r0 = CPU.r10().value;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0;
  }

  @Method(0x80aac84)
  public static void FUN_80aac84(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    r1 = 0x0;
    r5 = r0;
    r3 = 0xf;
    CPU.r12().value = r1;
    r7 = 0x1f;

    //LAB_80aac90
    do {
      r3 = r3 << 4;
      r6 = 0x0;
      CPU.lr().value = r3;

      //LAB_80aac96
      do {
        r2 = CPU.lr().value;
        r3 = r2 + r6;
        r1 = 0xa0;
        r1 = r1 << 19;
        r0 = r3 << 1;
        r3 = r0 + r1;
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r4 = r3 >>> 10;
        r4 = r4 & r7;
        r2 = r3 >>> 5;
        r1 = r7;
        r2 = r2 & r7;
        r1 = r1 & r3;
        r4 = r4 + r5;
        r2 = r2 + r5;
        r1 = r1 + r5;
        if(r4 > 0x1f) {
          r4 = 0x1f;
        }

        //LAB_80aacbc
        if(r2 > 0x1f) {
          r2 = 0x1f;
        }

        //LAB_80aacc2
        if(r1 > 0x1f) {
          r1 = 0x1f;
        }

        //LAB_80aacc8
        if(r4 < 0x0) {
          r4 = 0x0;
        }

        //LAB_80aacce
        if(r2 < 0x0) {
          r2 = 0x0;
        }

        //LAB_80aacd4
        if(r1 < 0x0) {
          r1 = 0x0;
        }

        //LAB_80aacda
        r2 = r2 << 5;
        r3 = r4 << 10;
        r3 = r3 | r2;
        r3 = r3 | r1;
        r1 = 0x4ffffe0;
        r6 = r6 + 0x1;
        r2 = r0 + r1;
        MEMORY.ref(2, r2).setu(r3);
      } while(r6 <= 0xf);

      r2 = CPU.r12().value;
      r3 = 0x5;
      if(r2 != 0x0) {
        r5 = 0xc;
        r3 = 0x7;
        r5 = -r5;
      }

      //LAB_80aacfc
      r1 = 0x1;
      CPU.r12().value = CPU.r12().value + r1;
      r2 = CPU.r12().value;
    } while(r2 <= 0x2);
  }

  @Method(0x80aad10)
  public static void FUN_80aad10() {
    final Menua70 r0 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r8 = r0._184.get();
    FUN_80a10d0(r0.panel_30, 0, 5, 30, 15, 0x2);
    sleep(1);
    MEMORY.memcpy(r8 + 0xa8, 0x6004000, 0x2000);
    MEMORY.memcpy(r8 + 0x20a8, 0x5000080, 0x80);
    memfill32(0x6004000, 0x2000, 0x33333333);
    memfill32(0x5000080, 0x80, 0x55555555);
    FUN_80153d8(0x6005000);
    MEMORY.memcpy(0x60052c0, 0x80af26c, 0x20);
    DMA.channels[3].SAD.setu(FUN_80045e8());
    DMA.channels[3].DAD.setu(0x50000a0);
    DMA.channels[3].CNT.setu(0x80000010);
    MEMORY.ref(2, 0x50000bc).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(0x50000e0);
    DMA.channels[3].CNT.setu(0x80000010);
    FUN_80aac84(8);
    MEMORY.ref(2, 0x50000e8).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());
    MEMORY.ref(2, 0x50000c8).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());
    FUN_80aafb8(r8);
  }

  @Method(0x80aae14)
  public static int FUN_80aae14(final ArrayRef<IntRef> r0, final ArrayRef<IntRef> r1, final int r2, final int r3, final int a4) {
    int sp00 = 0;
    int r11 = 0;

    //LAB_80aae46
    int r10;
    for(r10 = 0; r10 < 32 && r1.get(r10).get() != 0; r10++) {
      MEMORY.ref(2, r2 + r10 * 0x2).setu(r1.get(r10).get() & 0x3fff);

      //LAB_80aae6a
      int r4;
      for(r4 = 0; r4 < 32 && ((r1.get(r10).get() ^ r0.get(r4).get()) & 0x3fff) != 0; r4++) {
        //
      }

      //LAB_80aae7e
      if(r4 == 0x20) {
        MEMORY.ref(2, r2 + r10 * 0x2).or(0x8000);
        r11++;
      }

      //LAB_80aae9c
    }

    //LAB_80aaeac
    //LAB_80aaec4
    for(int r9 = 0; r9 < 32 && r0.get(r9).get() != 0; r9++) {
      //LAB_80aaedc
      int r4;
      for(r4 = 0; r4 < 32 && ((r0.get(r9).get() ^ r1.get(r4).get()) & 0x3fff) != 0; r4++) {
        //
      }

      //LAB_80aaef0
      if(r4 == 0x20) {
        MEMORY.ref(2, r2 + r10 * 0x2).setu(r0.get(r9).get() & 0x3fff | 0x4000);
        sp00++;
        r10++;
      }

      //LAB_80aaf1a
    }

    //LAB_80aaf38
    MEMORY.ref(4, r3).setu(r11);
    MEMORY.ref(4, a4).setu(sp00);
    return r10;
  }

  @Method(0x80aaf58)
  public static void FUN_80aaf58(final int r0) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80aaf7e
    for(int r4 = 0; r4 < r8.partyMemberCount_219.get(); r4++) {
      MEMORY.ref(1, r0 + 0xa0 + r4).setu(FUN_80ac8fc(r0 + r4 * 0x14, r8.partyMemberIds_208.get(r4).get(), -1));
    }

    //LAB_80aafa2
  }

  @Method(0x80aafb8)
  public static void FUN_80aafb8(final int r0) {
    final Menua70 r9 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int sp20 = MEMORY.ref(4, 0x3001e8c).get();
    MEMORY.ref(1, sp20 + 0xea6).setu(1);

    //LAB_80aaff8
    int sp2c;
    for(sp2c = 0; sp2c < r9.partyMemberCount_219.get(); sp2c++) {
      MEMORY.ref(1, r0 + 0xa0 + sp2c).setu(FUN_80ac8fc(r0 + sp2c * 0x14, r9.partyMemberIds_208.get(sp2c).get(), -1));
    }

    //LAB_80ab01e
    drawPanelBackground_(r9.panel_30.deref());
    drawIcon_(0xbad, r9.panel_30.deref(), 0, 80);

    //LAB_80ab046
    int sp10 = 160;
    int sp0c = 0;
    int sp08 = 0;
    int sp04 = r0;

    //LAB_80ab054
    for(int sp28 = 0; sp28 < r9.partyMemberCount_219.get(); sp28++) {
      int sp1c = 0;

      //LAB_80ab05a
      for(int sp24 = 0; sp24 < 4; sp24++) {
        //LAB_80ab06a
        int r10 = sp1c * 8 + 16;
        int r5 = sp04;

        //LAB_80ab080
        for(sp2c = 0; sp2c < MEMORY.ref(1, r0 + sp10).get(); sp2c++) {
          final int r4 = MEMORY.ref(2, r5).getUnsigned();
          if(sp24 == (r4 & 0xe0) >>> 5) {
            if((r4 & 0x8000) == 0) {
              FUN_80150b8(2);
            }

            //LAB_80ab0b4
            int r8 = 0;
            if(FUN_8077210((r4 & 0xf00) >>> 8, (r4 & 0xe0) >>> 5, r4 & 0x1f) != 0) {
              r8 = 1;
            } else if(isDjinnSet_((r4 & 0xf00) >>> 8, (r4 & 0xe0) >>> 5, r4 & 0x1f) != 0) {
              //LAB_80ab0f0
              r8 = 1;
            }

            //LAB_80ab0f4
            if(r8 == 0) {
              FUN_80150b8(4);
            }

            //LAB_80ab100
            FUN_8015280(r9.panel_30.deref(), 0x5001 + ((MEMORY.ref(2, r5).getUnsigned() & 0xe0) >>> 5), sp08 + 1, sp1c + 2, 0);
            final int r2 = MEMORY.ref(2, r5).getUnsigned();
            drawIcon_(0x45f + ((r2 & 0xe0) >>> 5) * 20 + (r2 & 0x1f), r9.panel_30.deref(), 16 + sp0c, r10);
            sp1c++;
            r10 += 0x8;
            FUN_80150b8(15);
          }

          //LAB_80ab156
          r5 += 0x2;
        }

        //LAB_80ab16a
      }

      //LAB_80ab176
      sp10++;
      sp0c += 0x38;
      sp08 += 0x7;
      sp04 += 0x14;
    }

    //LAB_80ab1a2
    FUN_8015070(r9.panel_30.deref(), 0, 10, 28, 10);
    boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea3.set(1);
    MEMORY.ref(1, sp20 + 0xea6).setu(0);
  }

  @Method(0x80ab1f4)
  public static void FUN_80ab1f4(final Panel24 r0, final int x, final int y, final int r3, final int a4, final int a5) {
    FUN_80153c8(r0.x_0c.get() + x + 1, r0.y_0e.get() + y + 1, r3, a4, a5);
  }

  @Method(0x80ab21c)
  public static void FUN_80ab21c(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x4;
    r5 = r3;
    r4 = r0;
    r0 = r1;
    CPU.r10().value = a4;
    CPU.r9().value = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r3 = CPU.r10().value;
    r3 = r3 << 12;
    r7 = r2;
    CPU.r10().value = r3;
    if(r4 < 0x0) {
      r7 = r7 + r4;
      r4 = 0x0;
    }

    //LAB_80ab24c
    r3 = r4 + r7;
    if(r3 > 0x1d) {
      r3 = 0x1e;
      r7 = r3 - r4;
    }

    //LAB_80ab256
    if(r0 < 0x0) {
      r5 = r5 + r0;
      r0 = 0x0;
    }

    //LAB_80ab25e
    r3 = r0 + r5;
    if(r3 > 0x1d) {
      r3 = 0x14;
      r5 = r3 - r0;
    }

    //LAB_80ab268
    if(r7 > 0x0 && r5 > 0x0) {
      r6 = 0xea3;
      r2 = r0 << 6;
      r3 = r4 << 1;
      r2 = r2 + r3;
      r6 = r6 + CPU.r9().value;
      r1 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      CPU.r8().value = r6;
      CPU.r11().value = r1;

      //LAB_80ab282
      do {
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        r1 = r7;
        r4 = r4 + CPU.r9().value;
        if(r1 != 0x0) {
          r6 = 0xffff0fff;
          r3 = 0xf;
          CPU.lr().value = r3;
          CPU.r12().value = r6;

          //LAB_80ab294
          do {
            r2 = MEMORY.ref(2, r4).getUnsigned();
            r6 = CPU.lr().value;
            r3 = r2 >>> 12;
            r3 = r3 & r6;
            if(r3 == 0xf) {
              r3 = CPU.r12().value;
              r2 = r2 & r3;
              r6 = CPU.r10().value;
              r2 = r2 | r6;
              MEMORY.ref(2, r4).setu(r2);
            }

            //LAB_80ab2aa
            r1 = r1 - 0x1;
            r4 = r4 + 0x2;
          } while(r1 != 0x0);
        }

        //LAB_80ab2b2
        r3 = r0 >>> 2;
        r1 = CPU.r8().value;
        r2 = CPU.r11().value;
        r2 = r2 << r3;
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r2 = r2 | r3;
        MEMORY.ref(1, r1).setu(r2);
        r5 = r5 - 0x1;
        r3 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = r3 + 0x40;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r0 = r0 + 0x1;
      } while(r5 != 0x0);
    }

    //LAB_80ab2ce
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ab2ec)
  public static void FUN_80ab2ec(final Panel24 r0, final int x, final int y, final int r3, final int a4, final int a5) {
    FUN_80ab21c(r0.x_0c.get() + x + 1, r0.y_0e.get() + y + 1, r3, a4, a5);
  }

  @Method(0x80ab314)
  public static int FUN_80ab314() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80ab5e4)
  public static int FUN_80ab5e4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;
    int r11;

    CPU.sp().value -= 0x6c;
    final int sp50 = r0;
    final Menua70 sp4c = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(1);
    final int r9 = sp4c._184.get();
    r5 = sp4c._174.get(sp50).get();
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(modU(r5, 10) & 0xffff);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(CPU.sp().value + 0x64);
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(divideU(r5, 10) & 0xffff);
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(-1);
    r3 = CPU.sp().value + 0x6b;
    CPU.r12().value = MEMORY.ref(4, CPU.sp().value + 0x1c).get();

    //LAB_80ab656
    do {
      MEMORY.ref(1, r3).setu(0);
      r3 = r3 - 0x1;
    } while(r3 >= CPU.r12().value);

    if(sp50 == 0x0) {
      r0 = r9;
      FUN_80aafb8(r0);
      r0 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r0);
      r3 = sp4c.partyMemberCount_219.get();
      if(sp50 < r3) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r2 = r9;
        r4 = 0x4;
        r2 = r2 + 0xa0;

        //LAB_80ab684
        do {
          r3 = MEMORY.ref(1, r2).getUnsigned();
          r3 = r3 << 24;
          r2 = r2 + 0x1;
          if(r3 == 0x0) {
            MEMORY.ref(1, r1).setu(r4);
          }

          //LAB_80ab690
          r5 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r5 = r5 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r5);
          r3 = sp4c.partyMemberCount_219.get();
          r1 = r1 + 0x1;
        } while(r5 < r3);
      }

      //LAB_80ab69e
      r7 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      r0 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7);
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r0);
      r3 = sp4c.partyMemberCount_219.get();
      if(r0 < r3) {
        //LAB_80ab6b4
        do {
          r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          r3 = MEMORY.ref(1, r7 + r0).get();
          if(r3 == 0x4) {
            r0 = r0 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
            r1 = sp4c.partyMemberCount_219.get();
            r0 = FUN_80aa538(r0, r1);
            MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
          }

          //LAB_80ab6ca
          r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r1 = r1 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
          r3 = sp4c.partyMemberCount_219.get();
        } while(r1 < r3);
      }
    } else {
      //LAB_80ab6d8
      r5 = CPU.sp().value + 0x54;
      r1 = sp4c._1c.get(0).get();
      r0 = r5;
      FUN_80ae714(r0, r1);
      r3 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
      r3 = sp4c.partyMemberCount_219.get();
      r1 = 0x0;
      if(r1 < r3) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r1 = r9;
        r1 = r1 + 0xa0;
        r2 = r0;
        r6 = 0x7;

        //LAB_80ab704
        do {
          r3 = sp4c._1c.get(0).get();
          r7 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          if(r7 == r3) {
            MEMORY.ref(1, r2).setu(r6);
          } else {
            //LAB_80ab714
            r7 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r3 = MEMORY.ref(1, r5 + r7).getUnsigned();
            if(r3 != 0x0) {
              r3 = 0x0;
              MEMORY.ref(1, r2).setu(r3);
            } else {
              //LAB_80ab722
              r3 = 0x3;
              MEMORY.ref(1, r2).setu(r3);
              r3 = 0x0;
              r3 = MEMORY.ref(1, r1 + r3).get();
              if(r3 == 0x0) {
                r3 = 0x7;
                MEMORY.ref(1, r0).setu(r3);
              }
            }
          }

          //LAB_80ab732
          r3 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r3 = r3 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
          r7 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r3 = sp4c.partyMemberCount_219.get();
          r0 = r0 + 0x1;
          r1 = r1 + 0x1;
          r2 = r2 + 0x1;
        } while(r7 < r3);
      }
    }

    //LAB_80ab746
    if(sp50 == 0x1) {
      r6 = sp4c._174.get(0).get();
      r1 = 0xa;
      r0 = r6;
      r0 = modU(r0, r1);
      r1 = 0xa;
      r5 = r0;
      r0 = r6;
      r0 = divideU(r0, r1);
      r5 = r5 << 16;
      r5 = r5 >>> 16;
      r2 = r0;
      r6 = r5 << 3;
      r6 = r6 - r5;
      r2 = r2 << 16;
      r6 = r6 + 0x1;
      r3 = 0xe;
      r2 = r2 >>> 16;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      r2 = r2 + 0x2;
      r1 = r6;
      r3 = 0x6;
      MEMORY.ref(4, CPU.sp().value).setu(sp50);
      FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = 0x7;
      r1 = r6;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r2 = 0x2;
      r3 = 0x6;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      FUN_80ab2ec(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      r3 = sp4c.partyMemberCount_219.get();
      r5 = 0x0;
      if(r5 < r3) {
        r6 = 0x8;

        //LAB_80ab7b0
        do {
          r3 = sp4c._1c.get(0).get();
          if(r5 == r3) {
            r3 = sp4c.abilityId_178.get(0).get();
            r2 = 0x8000;
            r3 = r3 & r2;
            if(r3 != 0x0) {
              r0 = 0xbb0;
            } else {
              //LAB_80ab7ce
              r0 = 0xbaf;
            }
          } else {
            //LAB_80ab7d2
            r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r2 = MEMORY.ref(1, r3 + r5).getUnsigned();
            r3 = 0x2;
            r3 = r3 & r2;
            if(r3 != 0x0) {
              r0 = 0xbae;
            } else {
              //LAB_80ab7fc
              r0 = 0xbb1;
            }
          }

          //LAB_80ab7fe
          r2 = r6;
          r3 = 0x8;
          drawIcon_(r0, sp4c.panel_30.deref(), r2, r3);
          r3 = sp4c.partyMemberCount_219.get();
          r5 = r5 + 0x1;
          r6 = r6 + 0x38;
        } while(r5 < r3);
      }
    }

    //LAB_80ab818
    drawPanelBackground_(sp4c.panel_10c.deref());
    sp4c._14.get(0).deref()._05.set(1);
    r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    r5 = r5 << 3;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);

    //LAB_80ab834
    do {
      r7 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
      if(r7 != 0x0) {
        //LAB_80ab83c
        r1 = 0x1;
        r0 = 0x0;
        r1 = -r1;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r1);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = 0x1;
        r3 = r3 & r2;
        r10 = r7;
        if(r3 == 0x0) {
          r7 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r7);
        }

        //LAB_80ab85a
        final Panel24 r6_0 = sp4c.panel_10.deref();
        final Unit14c r5_0 = getUnit_(sp4c.partyMemberIds_208.get(MEMORY.ref(4, CPU.sp().value + 0x38).get()).get());
        drawPanelBackground_(r6_0);
        FUN_8015090(r5_0.name_00.getAddress(), r6_0, 0, 0);
        drawIcon_(0x741 + r5_0.class_129.get(), r6_0, 0, 8);
        FUN_8015090(0x80af28c, r6_0, 48, 0);
        FUN_80150b0(r5_0.level_0f.get(), 2, r6_0, 72, MEMORY.ref(4, CPU.sp().value + 0x48).get());

        if(sp50 == 0x0) {
          drawIcon_(0xba9, r6_0, 0, 16);
        }

        //LAB_80ab8c4
        r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        if(r3 != -1) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get() * 10;
          r3 = r3 + MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 << 1;
          r1 = r9;
          r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
        }

        //LAB_80ab8e2
        drawPanelBackground_(sp4c.panel_10c.deref());
        if(sp50 == 0x1) {
          r0 = sp4c._21a.get(0).get();
          r1 = 0x1;
          FUN_8015120(r0, r1);
          r4 = 0xbb2;
          r0 = r4;
          r3 = 0x0;
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
          drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
          r2 = sp4c.abilityId_178.get(0).get();
          r3 = r2 & 0xe0;
          r3 = r3 >>> 5;
          r0 = r3 << 2;
          r0 = r0 + r3;
          r3 = 0x1f;
          r3 = r3 & r2;
          r0 = r0 << 2;
          r1 = 0x96;
          r0 = r0 + r3;
          r1 = r1 << 1;
          r0 = r0 + r1;
          r1 = 0x4;
          FUN_8015120(r0, r1);
          r3 = sp4c.abilityId_178.get(0).get();
          r5 = r3 & 0xe0;
          r3 = 0x5001;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          r5 = r5 >>> 5;
          r5 = r5 + r3;
          r3 = 0x0;
          MEMORY.ref(4, CPU.sp().value).setu(r1);
          r2 = 0x6;
          r1 = r5;
          FUN_8015280(sp4c.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r0 = r4 + 0x1;
          r3 = 0x0;
          r2 = 0x38;
          drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r4 = r4 + 0x2;
          r0 = r4;
          r2 = 0x0;
          r3 = 0x8;
          drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
        }

        //LAB_80ab980
        r5 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        if(r5 == -1) {
          r1 = 0x0;
          r2 = 0xc8;
          r3 = 0x0;
          FUN_80ad5b4(sp50, r1, r2, r3);
        } else {
          //LAB_80ab994
          if(sp50 == 0x0) {
            //LAB_80ab99c
            r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            if(r0 != 0x0) {
              r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              if(r1 == 0x0) {
                r0 = 0xb98;
                r2 = 0x0;
                r3 = 0x0;
                drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
              } else {
                //LAB_80ab9b8
                r0 = 0xb99;
                r2 = 0x0;
                r3 = 0x0;
                drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
              }

              //LAB_80ab9c6
              r5 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
              r3 = 0xf0;
              r3 = r3 << 4;
              r3 = r3 & r5;
              r6 = r3 >>> 8;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
              r3 = 0xe0;
              r3 = r3 & r5;
              r7 = 0x1f;
              r7 = r7 & r0;
              r5 = r3 >>> 5;
              r0 = r6;
              r1 = r5;
              r2 = r7;
              r0 = FUN_8077210(r0, r1, r2);
              if(r0 != 0x0 || isDjinnSet_(r6, r5, r7) != 0x0) {
                //LAB_80ab9f8
                r0 = r6;
                r1 = r5;
                r2 = r7;
                r0 = FUN_8077210(r0, r1, r2);
                if(r0 != 0x0) {
                  r1 = r5;
                  r2 = 0x1;
                  r0 = FUN_80ad608(sp50, r1, r2);
                } else {
                  //LAB_80aba12
                  r1 = r5;
                  r2 = 0x2;
                  r0 = FUN_80ad608(sp50, r1, r2);
                }

                //LAB_80aba1c
                r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r1 = r2 - r3;
                r1 = r1 << 3;
                r1 = r1 + 0x30;
                r2 = 0x3e;
                r3 = 0x0;
                FUN_80ad5b4(sp50, r1, r2, r3);
              } else {
                //LAB_80aba32
                r0 = 0xb9e;
                r3 = 0x10;
                r2 = 0x0;
                drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
                r1 = r5;
                r2 = 0x1;
                r0 = FUN_80ad608(sp50, r1, r2);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r1 = r2 - r3;
                r1 = r1 << 3;
                r1 = r1 + 0x30;
                r2 = 0x3e;
                r3 = 0x1;
                FUN_80ad5b4(sp50, r1, r2, r3);
              }

              //LAB_80aba64
              r5 = r10;
              r3 = r5 >>> 1;
            } else {
              //LAB_80aba6a
              r4 = 0xb9a;
              r0 = r4;
              r2 = 0x0;
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              drawIcon_(r0, sp4c.panel_10c.deref(), r2, r3);
              r3 = 0xf0;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
              r3 = r3 << 4;
              r3 = r3 & r0;
              r5 = r3 >>> 8;
              r3 = 0xe0;
              r3 = r3 & r0;
              r6 = 0x1f;
              r7 = r3 >>> 5;
              r6 = r6 & r0;
              r1 = r7;
              r0 = r5;
              r2 = r6;
              r0 = FUN_8077210(r0, r1, r2);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              if(r0 != 0x0 || isDjinnSet_(r5, r7, r6) != 0x0) {
                //LAB_80abab0
                r0 = r5;
                r1 = r7;
                r2 = r6;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8077210(r0, r1, r2);
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  drawIcon_(r4 + 0x3, sp4c.panel_10c.deref(), 0, 16);
                  FUN_80ad608(0, r7, 1);
                } else {
                  //LAB_80abadc
                  drawIcon_(r4 + 0x2, sp4c.panel_10c.deref(), 0, 16);
                  FUN_80ad608(0, r7, 2);
                }

                //LAB_80abaf4
                r5 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r7 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r1 = r5 - r7;
                r1 = r1 << 3;
                r1 = r1 + 0x30;
                r2 = 0x3e;
                r3 = 0x0;
                FUN_80ad5b4(sp50, r1, r2, r3);
              } else {
                //LAB_80abb0a
                drawIcon_(r4 + 0x4, sp4c.panel_10c.deref(), 0, 16);
                FUN_80ad608(0, r7, 1);
                FUN_80ad5b4(0, (MEMORY.ref(4, CPU.sp().value + 0x18).get() - MEMORY.ref(4, CPU.sp().value + 0x38).get()) * 0x8 + 0x30, 62, 1);
              }

              //LAB_80abb36
              r7 = r10;
              r3 = r7 >>> 1;
            }

            //LAB_80abb3a
            if(r3 != 0x0) {
              r1 = 0x0;
              FUN_80ad5f4(sp50, r1);
            }
          } else {
            //LAB_80abb7c
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = 0xf0;
            r3 = r3 << 4;
            r3 = r3 & r0;
            r6 = r3 >>> 8;
            r3 = 0xe0;
            r3 = r3 & r0;
            r7 = 0x1f;
            r7 = r7 & r0;
            r5 = r3 >>> 5;
            r0 = r6;
            r1 = r5;
            r2 = r7;
            r0 = FUN_8077210(r0, r1, r2);
            if(r0 != 0x0 || isDjinnSet_(r6, r5, r7) != 0x0) {
              //LAB_80abbac
              r0 = r6;
              r1 = r5;
              r2 = r7;
              r0 = FUN_8077210(r0, r1, r2);
              if(r0 != 0x0) {
                r1 = r5;
                r2 = 0x1;
                r0 = FUN_80ad608(sp50, r1, r2);
              } else {
                //LAB_80abbc6
                r1 = r5;
                r2 = 0x2;
                r0 = FUN_80ad608(sp50, r1, r2);
              }

              //LAB_80abbd0
              r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r1 = r2 - r3;
              r1 = r1 << 3;
              r1 = r1 + 0x30;
              r2 = 0x36;
              r3 = 0x0;
              FUN_80ad5b4(sp50, r1, r2, r3);
            } else {
              //LAB_80abbe6
              r1 = r5;
              r2 = 0x1;
              r0 = FUN_80ad608(sp50, r1, r2);
              r5 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r7 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r1 = r5 - r7;
              r1 = r1 << 3;
              r1 = r1 + 0x30;
              r2 = 0x36;
              r3 = 0x1;
              FUN_80ad5b4(sp50, r1, r2, r3);
            }

            //LAB_80abc04
            r0 = r10;
            r3 = r0 >>> 1;
            if(r3 != 0x0) {
              r1 = 0x0;
              FUN_80ad5f4(sp50, r1);
            }
          }
        }

        //LAB_80abc14
        FUN_8015278(sp4c.panel_30.deref());
        if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() != -1) {
          drawIcon_(0xbad, sp4c.panel_30.deref(), 0, 80);
          FUN_8015068(sp4c.panel_30.deref(), 0, 96, 224, 104);
          r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          drawIcon_(0x666 + ((r7 & 0xe0) >>> 5) * 0x14 + (r7 & 0x1f), sp4c.panel_30.deref(), 0, 96);
        }

        //LAB_80abc66
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r0 + r1).getUnsigned();
        r3 = r2 & 0x1;
        if(r3 == 0x0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r1 = r3 - r1;
          r3 = 0xe;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r1 = r1 + 0x1;
          r2 = r2 + 0x2;
          r3 = 0x6;
          MEMORY.ref(4, CPU.sp().value).setu(1);
          FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_80abc90
        r3 = 0x3001e8c;
        r7 = 0xea3;
        r3 = MEMORY.ref(4, r3).get();
        r3 = r3 + r7;
        MEMORY.ref(1, r3).setu(1);
      }

      //LAB_80abc9a
      r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r2 = MEMORY.ref(1, r0 + r1).getUnsigned();
      r3 = 0x1;
      r3 = r3 & r2;
      if(r3 != 0x0) {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r0 = r2 - r1;
        r0 = r0 << 3;
        r0 = r0 - 0x8;
        r1 = 0x34;
        FUN_80a1a40(r0, r1);
      } else {
        //LAB_80abcb8
        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r7 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r0 = r3 - r5;
        r0 = r0 << 3;
        r1 = r7 << 3;
        r0 = r0 - 0x8;
        r1 = r1 + 0x3c;
        FUN_80a1a40(r0, r1);
      }

      //LAB_80abccc
      r0 = 0x1;
      sleep(r0);
      r3 = 0x3001ae8;
      r2 = 0x80;
      r3 = MEMORY.ref(4, r3).get();
      r2 = r2 << 1;
      r3 = r3 & r2;
      if(r3 == 0x0 || (accumulatedButtons_3001af8.get() & r2) != 0) {
        //LAB_80abcea
        r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        if(r0 != 0x0) {
          r1 = 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r1);
        }

        //LAB_80abcf4
        r2 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
      }

      //LAB_80abcfa
      r3 = 0x3001b04;
      r3 = MEMORY.ref(4, r3).get();
      r11 = r3;
      r3 = 0x3001c94;
      r4 = MEMORY.ref(4, r3).get();
      r3 = 0x212c;
      r3 = r3 + r9;
      r1 = MEMORY.ref(4, r3).get();
      if(r1 != 0x0) {
        //LAB_80abd10
        r2 = 0x2128;
        r2 = r2 + r9;
        r3 = MEMORY.ref(4, r2).get();
        r3 = r3 + 0x1;
        r4 = 0x0;
        MEMORY.ref(4, r2).setu(r3);
        r3 = r1 - 0x1;
        r11 = r4;

        //LAB_80abd26
        Panel24 panel;
        switch(r3) {
          case 27: // switch 80abd30
            //LAB_80abda0
            r1 = 0x3001c94;
            r2 = MEMORY.ref(4, r1).get();
            r3 = 0x1;
            r2 = r2 & r3;
            if(r2 == 0x0) {
              r6 = r1;

              //LAB_80abdb0
              do {
                r0 = 0x96;
                r1 = 0x1a;
                FUN_80a1a40(r0, r1);
                r0 = 0x1;
                sleep(r0);
                r3 = MEMORY.ref(4, r6).get();
                r3 = r3 & 0x1;
              } while(r3 == 0x0);
            }

            //LAB_80abdc6
            r4 = 0x2;
            r11 = r4;
            break;

          case 26: // switch 80abd30
            //LAB_80abdcc
            r3 = 0x2128;
            r3 = r3 + r9;
            r3 = MEMORY.ref(4, r3).get();
            if(r3 == 0x3c) {
              //LAB_80abdd8
              panel = FUN_8015038(0xc4c, 9, 9, 1);
              _200044c.set(1);

              //LAB_80abdfa
              do {
                r0 = FUN_8015048();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80abdf4
                r0 = 0x1;
                sleep(r0);
              } while(true);

              FUN_8015018(panel, 1);
              r0 = r9;
              FUN_80aafb8(r0);
              r0 = 0x1;
              sleep(r0);
              panel = FUN_8015038(0xc4d, 9, 9, 1);
              _200044c.set(1);

              //LAB_80abe38
              do {
                r0 = FUN_8015048();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80abe32
                r0 = 0x1;
                sleep(r0);
              } while(true);

              FUN_8015018(panel, 1);
              r0 = r9;
              FUN_80aafb8(r0);
              r2 = 0x2128;
              r3 = 0x0;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              tickRecoveryQueue_();
              tickRecoveryQueue_();
              tickRecoveryQueue_();
              r1 = 0x0;
              r2 = 0x0;
              r0 = 0x0;
              r0 = FUN_80771b8(r0, r1, r2);
              r1 = 0x0;
              r2 = 0x0;
              r0 = 0x0;
              FUN_80771c8(r0, r1, r2);
              r0 = 0x0;
              recalcStats_(r0);
              r0 = 0x2;
              r11 = r0;
              r4 = 0x2;
            }
            break;

          case 0: // switch 80abd30
            //LAB_80abe82
            r3 = 0x2128;
            r3 = r3 + r9;
            r3 = MEMORY.ref(4, r3).get();
            if(r3 == 0x3c) {
              //LAB_80abe8e
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              panel = FUN_8015038(0xc40, 9, 9, 1);
              _200044c.set(1);

              //LAB_80abeb4
              do {
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8015048();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80abeac
                r0 = 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                sleep(r0);
              } while(true);

              FUN_8015018(panel, 1);
              r0 = r9;
              FUN_80aafb8(r0);
              r2 = 0x2128;
              r3 = 0x0;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r3 = 0x2;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            }
            break;

          case 1: // switch 80abd30
          case 3: // switch 80abd30
          case 7: // switch 80abd30
          case 8: // switch 80abd30
          case 21: // switch 80abd30
            //LAB_80abede
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x5a) {
              //LAB_80abeea
              r3 = 0x1;
              r11 = r3;
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r2 = r2 + r9;
              r3 = MEMORY.ref(4, r2).get();
              r3 = r3 + 0x1;
              r4 = 0x1;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 2: // switch 80abd30
            //LAB_80abefc
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x5a) {
              //LAB_80abf08
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r2 = r2 + r9;
              r3 = 0x4;
              r11 = 0x10;
              r4 = 0x10;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 5: // switch 80abd30
          case 6: // switch 80abd30
            //LAB_80abf1c
            r3 = 0x2128;
            r3 = r3 + r9;
            r3 = MEMORY.ref(4, r3).get();
            if(r3 == 0x3c) {
              //LAB_80abf28
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              panel = FUN_8015038(0xc41, 9, 9, 1);
              _200044c.set(1);

              //LAB_80abf4e
              do {
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8015048();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80abf46
                r0 = 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                sleep(r0);
              } while(true);

              FUN_8015018(panel, 1);
              FUN_80aafb8(r9);
              r2 = 0x2128;
              r3 = 0x0;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r3 = 0x8;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            }
            break;

          case 12: // switch 80abd30
            //LAB_80abf78
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x28) {
              //LAB_80abf84
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r2 = r2 + r9;
              r3 = MEMORY.ref(4, r2).get();
              r0 = 0x2;
              r3 = r3 + 0x1;
              r11 = r0;
              r4 = 0x2;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 13: // switch 80abd30
          case 15: // switch 80abd30
          case 16: // switch 80abd30
            //LAB_80abf9a
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x28) {
              //LAB_80abfa6
              MEMORY.ref(4, r2).setu(0);
              MEMORY.ref(4, r9 + 0x212c).incr();
            }
            break;

          case 14: // switch 80abd30
            //LAB_80abff8
            r3 = MEMORY.ref(4, r9 + 0x2128).get();
            if(r3 == 0x3c) {
              //LAB_80ac004
              _200044c.set(1);
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              panel = FUN_8015038(0xc44, 9, 9, 1);
              FUN_80a1ac0(2, 146);

              //LAB_80ac032
              do {
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8015048();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80ac02a
                r0 = 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                sleep(r0);
              } while(true);

              r1 = 0x3001c94;
              r2 = MEMORY.ref(4, r1).get();
              r3 = 0x1;
              r2 = r2 & r3;
              if(r2 == 0x0) {
                r7 = r1;
                r6 = 0x1;

                //LAB_80ac050
                do {
                  r0 = 0x2;
                  r1 = 0x92;
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                  FUN_80a1a40(r0, r1);
                  r0 = 0x1;
                  sleep(r0);
                  r3 = MEMORY.ref(4, r7).get();
                  r3 = r3 & r6;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                } while(r3 == 0x0);
              }

              //LAB_80ac06a
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              FUN_8015018(panel, 1);
              FUN_80aafb8(r9);
              sleep(1);
              panel = FUN_8015038(0xc45, 9, 9, 1);

              //LAB_80ac098
              do {
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8015048();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80ac090
                r0 = 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                sleep(r0);
              } while(true);

              r1 = 0x3001c94;
              r2 = MEMORY.ref(4, r1).get();
              r3 = 0x1;
              r2 = r2 & r3;
              if(r2 == 0x0) {
                r7 = r1;
                r6 = 0x1;

                //LAB_80ac0b6
                do {
                  r0 = 0x2;
                  r1 = 0x92;
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                  FUN_80a1a40(r0, r1);
                  r0 = 0x1;
                  sleep(r0);
                  r3 = MEMORY.ref(4, r7).get();
                  r3 = r3 & r6;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                } while(r3 == 0x0);
              }

              //LAB_80ac0d0
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              FUN_8015018(panel, 1);
              FUN_80aafb8(r9);
              sleep(1);
              panel = FUN_8015038(0xc46, 9, 9, 1);

              //LAB_80ac0fe
              do {
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                r0 = FUN_8015048();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80ac0f6
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                sleep(1);
              } while(true);

              r1 = 0x3001c94;
              r2 = MEMORY.ref(4, r1).get();
              r3 = 0x1;
              r2 = r2 & r3;
              if(r2 == 0x0) {
                r7 = r1;
                r6 = 0x1;

                //LAB_80ac11c
                do {
                  r0 = 0x2;
                  r1 = 0x92;
                  MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                  FUN_80a1a40(r0, r1);
                  r0 = 0x1;
                  sleep(r0);
                  r3 = MEMORY.ref(4, r7).get();
                  r3 = r3 & r6;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                } while(r3 == 0x0);
              }

              //LAB_80ac136
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              FUN_8015018(panel, 1);
              r0 = r9;
              FUN_80aafb8(r0);
              r0 = 0x1;
              sleep(r0);
              r2 = 0x2128;
              r3 = 0x0;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r3 = 0x10;
              r2 = r2 + r9;
              MEMORY.ref(4, r2).setu(r3);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            }
            break;

          case 17: // switch 80abd30
          case 19: // switch 80abd30
            //LAB_80ac160
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x5a) {
              r3 = 0x1;
              r11 = r3;
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r3 = 0x15;
              r2 = r2 + r9;
              r4 = 0x1;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 20: // switch 80abd30
            //LAB_80ac17e
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x5a) {
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r2 = r2 + r9;
              r3 = 0x16;
              r11 = 0x20;
              r4 = 0x20;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 23: // switch 80abd30
            //LAB_80ac19c
            r2 = 0x2128;
            r2 = r2 + r9;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x3c) {
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = 0x212c;
              r3 = 0x19;
              r2 = r2 + r9;
              r7 = 0x2;
              MEMORY.ref(4, r2).setu(r3);
              r11 = r7;
              r4 = 0x2;
            }
            break;
        }
      }

      //LAB_80ac1b8
      if(sp50 == 0x0) {
        //LAB_80ac1c0
        r3 = 0x80;
        r3 = r3 << 1;
        r3 = r3 & r4;
        if(r3 != 0x0) {
          //LAB_80ac1cc
          r2 = 0x1;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r2 = -r2;
          if(r1 == r2) {
            r0 = 0x72;
            playSound_(r0);
            continue;
          }

          //LAB_80ac1d8
          r3 = 0x0;
          r5 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
          r3 = 0xf0;
          r3 = r3 << 4;
          r3 = r3 & r5;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r7 = r3 >>> 8;
          r3 = 0xe0;
          r3 = r3 & r5;
          r6 = 0x1f;
          r5 = r3 >>> 5;
          r6 = r6 & r0;
          r1 = r5;
          r0 = r7;
          r2 = r6;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
          r0 = FUN_8077210(r0, r1, r2);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          if(r0 != 0x0) {
            r1 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
          } else {
            r0 = r7;
            r1 = r5;
            r2 = r6;
            r0 = isDjinnSet_(r0, r1, r2);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            if(r0 != 0x0) {
              //LAB_80ac214
              r1 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
            }
          }

          //LAB_80ac218
          r2 = 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
          r2 = 0x3001af8;
          r3 = 0x0;
          MEMORY.ref(4, r2).setu(r3);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          if(r3 == 0x0) {
            playSound_(0x72);
            FUN_8015278(sp4c.panel_30.deref());
            FUN_8015068(sp4c.panel_30.deref(), 0, 80, 216, 104);
            FUN_8015078(0xbbe, sp4c.panel_30.deref(), 0, 96);
            MEMORY.ref(4, CPU.sp().value + 0x48).setu(1);
            continue;
          }

          //LAB_80ac25a
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r3 = r0 >>> 15;
          if(r3 != 0x0) {
            r0 = 0xaf;
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
            playSound_(r0);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r5 = (r1 & 0xf00) >>> 8;
            r6 = (r1 & 0xe0) >>> 5;
            r3 = r1 & 0x1f;
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
            FUN_80771b8(r5, r6, r3);
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            FUN_80771c8(r5, r6, r3);
          } else {
            //LAB_80ac298
            r0 = 0x8b;
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
            playSound_(r0);
            r5 = 0xf0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r5 = r5 << 4;
            r6 = 0xe0;
            r5 = r5 & r2;
            r6 = r6 & r2;
            r3 = 0x1f;
            r3 = r3 & r2;
            r5 = r5 >>> 8;
            r6 = r6 >>> 5;
            r2 = r3;
            r1 = r6;
            r0 = r5;
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
            r0 = setDjinn_(r0, r1, r2);
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = r5;
            r1 = r6;
            r2 = r3;
            r0 = recoverDjinn_(r0, r1, r2);
          }

          //LAB_80ac2cc
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r0 = 0xf0;
          r0 = r0 << 4;
          r0 = r0 & r3;
          r0 = r0 >>> 8;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
          recalcStats_(r0);
          r0 = r9;
          FUN_80aafb8(r0);
          r5 = 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r5);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        }

        //LAB_80ac2ea
        if(sp50 == 0x0) {
          r3 = 0x80;
          r3 = r3 << 2;
          r3 = r3 & r4;
          if(r3 != 0x0) {
            r0 = 0x70;
            r5 = 0x7;
            playSound_(r0);
            break;
          }
        }
      }

      //LAB_80ac304
      if((r4 & 0x1) != 0 || sp50 == 0x1 && (r4 & 0x100) != 0) {
        //LAB_80ac320
        r1 = 0x1;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = 0x1;
        r3 = r3 & r2;
        if(r3 == 0x0) {
          r0 = 0x1;
          r7 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r0 = -r0;
          if(r7 == r0) {
            //LAB_80ac33c
            r0 = 0x72;
            playSound_(r0);
            continue;
          }

          //LAB_80ac36c
          r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r3 = 0xf0;
          r3 = r3 << 4;
          r3 = r3 & r2;
          r7 = r3 >>> 8;
          r3 = 0xe0;
          r3 = r3 & r2;
          r5 = 0x1f;
          r1 = 0x0;
          r6 = r3 >>> 5;
          r5 = r5 & r2;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
          r0 = r7;
          r1 = r6;
          r2 = r5;
          r0 = FUN_8077210(r0, r1, r2);
          if(r0 != 0x0) {
            r3 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
          } else {
            r0 = r7;
            r1 = r6;
            r2 = r5;
            r0 = isDjinnSet_(r0, r1, r2);
            if(r0 != 0x0) {
              //LAB_80ac3a0
              r3 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
            }
          }
        }

        //LAB_80ac3a4
        r5 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
        if(r5 == 0x0) {
          playSound_(0x72);
          FUN_8015278(sp4c.panel_30.deref());
          FUN_8015068(sp4c.panel_30.deref(), 0, 80, 216, 104);
          FUN_8015078(0xbbe, sp4c.panel_30.deref(), 0, 96);
          continue;
        }

        //LAB_80ac3d8
        if(sp50 != 0x1) {
          r5 = 0x1;
        } else {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
          r3 = r2 & 0x1;
          r5 = 0x4;
          if(r3 != 0x0) {
            r7 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
            r3 = sp4c._1c.get(0).get();
            if(r7 == r3) {
              r2 = sp4c.abilityId_178.get(0).get();
              r3 = 0x80;
              r3 = r3 << 8;
              r3 = r3 & r2;
              r5 = 0x2;
              if(r3 == 0x0) {
                r5 = 0x1;
              }
            } else {
              //LAB_80ac410
              r5 = 0x3;
            }
          }
        }

        //LAB_80ac416
        r0 = 0x70;
        playSound_(r0);
        break;
      }

      //LAB_80ac41e
      r3 = 0x8;
      r3 = r3 & r4;
      if(r3 != 0x0) {
        r0 = 0x71;
        r5 = 0x2;
        playSound_(r0);
        r5 = -r5;
        break;
      }

      //LAB_80ac42c
      r3 = 0x2;
      r3 = r3 & r4;
      if(r3 != 0x0) {
        r0 = 0x71;
        r5 = 0x1;
        playSound_(r0);
        r5 = -r5;
        break;
      }

      //LAB_80ac440
      if(sp50 == 0x0) {
        //LAB_80ac448
        r3 = 0x4;
        r3 = r3 & r4;
        if(r3 != 0x0) {
          //LAB_80ac452
          r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          if(r2 != 0x0) {
            //LAB_80ac45a
            r5 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
            r5 = r5 ^ 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x20).setu(r5);
            if(r5 != 0x0) {
              r0 = 0x8b;
              playSound_(r0);
            } else {
              //LAB_80ac46e
              r0 = 0xaf;
              playSound_(r0);
            }

            //LAB_80ac474
            r7 = 0x0;
            MEMORY.ref(4, CPU.sp().value + 0x44).setu(r7);
            r3 = sp4c.partyMemberCount_219.get();
            if(r7 < r3) {
              //LAB_80ac486
              r2 = 0xa0;
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);

              //LAB_80ac48e
              do {
                r5 = 0x0;
                MEMORY.ref(4, CPU.sp().value + 0x40).setu(r5);
                r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r0 = r9;
                r3 = MEMORY.ref(1, r7 + r0).get();
                if(r5 < r3) {
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                  r3 = r1 << 1;
                  r3 = r3 + r9;
                  r10 = r3;

                  //LAB_80ac4a4
                  do {
                    r2 = r10;
                    r7 = MEMORY.ref(2, r2).getUnsigned();
                    r3 = 0x2;
                    r0 = 0xf0;
                    r0 = r0 << 4;
                    r10 = r10 + r3;
                    r3 = r7;
                    r3 = r3 & r0;
                    r4 = r3 >>> 8;
                    r5 = 0x0;
                    r1 = 0xe0;
                    r3 = r7;
                    r3 = r3 & r1;
                    r8 = r5;
                    r6 = r3 >>> 5;
                    r5 = r7 & 0x1f;
                    r0 = r4;
                    r1 = r6;
                    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
                    r0 = FUN_8077210(r0, r1, r5);
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    if(r0 != 0x0) {
                      r3 = 0x1;
                      r8 = r3;
                    } else {
                      r0 = r4;
                      r1 = r6;
                      r0 = isDjinnSet_(r0, r1, r5);
                      if(r0 != 0x0) {
                        //LAB_80ac4e8
                        r3 = 0x1;
                        r8 = r3;
                      }
                    }

                    //LAB_80ac4ec
                    r5 = r8;
                    if(r5 != 0x0) {
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                      if(r0 != 0x0) {
                        r3 = r7 >>> 15;
                        if(r3 == 0x0) {
                          r1 = 0xf0;
                          r1 = r1 << 4;
                          r2 = 0xe0;
                          r5 = r7;
                          r6 = r7;
                          r5 = r5 & r1;
                          r6 = r6 & r2;
                          r3 = 0x1f;
                          r3 = r3 & r7;
                          r5 = r5 >>> 8;
                          r6 = r6 >>> 5;
                          r2 = r3;
                          r1 = r6;
                          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
                          setDjinn_(r5, r1, r2);
                          r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                          r1 = r6;
                          r2 = r3;
                          recoverDjinn_(r5, r1, r2);
                          recalcStats_(r5);
                        }
                      } else {
                        //LAB_80ac534
                        r3 = r7 >>> 15;
                        if(r3 != 0x0) {
                          r3 = 0xf0;
                          r3 = r3 << 4;
                          r0 = 0xe0;
                          r5 = r7;
                          r6 = r7;
                          r5 = r5 & r3;
                          r6 = r6 & r0;
                          r3 = 0x1f;
                          r3 = r3 & r7;
                          r5 = r5 >>> 8;
                          r6 = r6 >>> 5;
                          r2 = r3;
                          r1 = r6;
                          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
                          FUN_80771b8(r5, r1, r2);
                          r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                          r1 = r6;
                          r2 = r3;
                          FUN_80771c8(r5, r1, r2);
                          recalcStats_(r5);
                        }
                      }
                    }

                    //LAB_80ac56e
                    r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                    r1 = r1 + 0x1;
                    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                    r5 = r9;
                    r3 = MEMORY.ref(1, r2 + r5).get();
                  } while(r1 < r3);
                }

                //LAB_80ac57e
                r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                r7 = r7 + 0x1;
                r0 = r0 + 0xa;
                r1 = r1 + 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
                MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
                r3 = sp4c.partyMemberCount_219.get();
              } while(r1 < r3);
            }

            //LAB_80ac59e
            r0 = r9;
            FUN_80aafb8(r0);
            r7 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x48).setu(r7);
          } else {
            //LAB_80ac5aa
            r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
            r1 = r2 - r3;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r3 = 0x1;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            r3 = 0xf;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r1 = r1 + 0x1;
            r2 = r2 + 0x2;
            r3 = 0x6;
            FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r0 = 0x70;
            r5 = 0xa;
            playSound_(r0);
            break;
          }
        }
      }

      //LAB_80ac5d2
      r3 = 0x40;
      r5 = r11;
      r3 = r3 & r5;
      if(r3 != 0x0) {
        r0 = 0x6f;
        playSound_(r0);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r5 = 0x4;
        r2 = MEMORY.ref(1, r7 + r0).getUnsigned();
        r3 = r5;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          continue;
        }

        //LAB_80ac5f6
        r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r1 = r2 - r3;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = 0xf;
        r2 = r2 + 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r1 = r1 + 0x1;
        r3 = 0x6;
        r6 = 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r6);
        FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r7 + r0).getUnsigned();
        r3 = r5;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          continue;
        }

        //LAB_80ac624
        r3 = r6;
        r3 = r3 & r2;
        r1 = 0x1;
        if(r3 != 0x0) {
          r3 = 0x2;
          r3 = -r3;
          r3 = r3 & r2;
          r1 = 0x0;
          MEMORY.ref(1, r7 + r0).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
          //LAB_80ac63c
        } else if(MEMORY.ref(4, CPU.sp().value + 0x30).get() == 0 && (r2 & 0x2) != 0) {
          r3 = r2;
          r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r7 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          r3 = r3 | r1;
          r0 = 0x2;
          MEMORY.ref(1, r5 + r7).setu(r3);
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
          continue;
        }

        //LAB_80ac65c
        r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r1 = r1 - 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
        r3 = r3 + 0xa0;
        r2 = r9;
        r1 = MEMORY.ref(1, r2 + r3).get();
        if(r1 == 0x0) {
          r1 = 0x1;
        }

        //LAB_80ac670
        r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r0 = FUN_80aa538(r0, r1);
        r3 = 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
        continue;
      }

      //LAB_80ac682
      r3 = 0x80;
      r5 = r11;
      r3 = r3 & r5;
      if(r3 != 0x0) {
        r0 = 0x6f;
        playSound_(r0);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r5 = 0x4;
        r2 = MEMORY.ref(1, r7 + r0).getUnsigned();
        r3 = r5;
        r3 = r3 & r2;
        if(r3 == 0x0) {
          //LAB_80ac6a6
          r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          r1 = r2 - r3;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = 0xf;
          r1 = r1 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r2 = r2 + 0x2;
          r3 = 0x6;
          r6 = 0x1;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r7 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          r7 = r7 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x30).setu(r7);
          r3 = r3 + 0xa0;
          r0 = r9;
          r1 = MEMORY.ref(1, r0 + r3).get();
          if(r1 == 0x0) {
            r1 = 0x1;
          }

          //LAB_80ac6d8
          r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r0 = FUN_80aa538(r0, r1);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
          MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
          r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
          r3 = r6;
          r3 = r3 & r2;
          if(r3 != 0 && (r5 & r2) == 0) {
            r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
            r3 = ~0x1 & r2;
            r7 = 0x0;
            MEMORY.ref(1, r1 + r5).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x30).setu(r7);
          } else {
            //LAB_80ac710
            r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            if(r0 == 0x0) {
              r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
              r3 = 0x2;
              r3 = r3 & r2;
              if(r3 != 0x0) {
                r3 = 0x1;
                r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r3 = r3 | r2;
                MEMORY.ref(1, r1 + r5).setu(r3);
              }
            }
          }

          //LAB_80ac72c
          r7 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r0 = 0x2;
          MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7);
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
        }
        continue;
      }

      //LAB_80ac738
      r3 = 0x20;
      r1 = r11;
      r3 = r3 & r1;
      if(r3 != 0x0) {
        r0 = 0x6f;
        playSound_(r0);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = 0x4;
        r3 = r3 & r2;
        if(r3 == 0x0) {
          r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r1 = r2 - r5;
          r3 = 0x1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r3 = 0xf;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r1 = r1 + 0x1;
          r2 = r2 + 0x2;
          r3 = 0x6;
          FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_80ac772
        r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r3 = r3 - 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
        r1 = sp4c.partyMemberCount_219.get();
        r0 = r3;
        r0 = FUN_80aa538(r0, r1);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
        if(sp50 == 0x0) {
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r2);
          r3 = sp4c.partyMemberCount_219.get();
          if(0 < r3) {
            //LAB_80ac798
            do {
              r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r3 = MEMORY.ref(1, r7 + r0).get();
              if(r3 == 0x4) {
                r0 = r0 - 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
                r1 = sp4c.partyMemberCount_219.get();
                r0 = FUN_80aa538(r0, r1);
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
              }

              //LAB_80ac7ae
              r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r1 = r1 + 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
              r3 = sp4c.partyMemberCount_219.get();
            } while(r1 < r3);
          }
        }
      } else {
        //LAB_80ac7bc
        r3 = 0x10;
        r1 = r11;
        r3 = r3 & r1;
        if(r3 == 0x0) {
          continue;
        }

        //LAB_80ac7ca
        r0 = 0x6f;
        playSound_(r0);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r5 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r2 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = 0x4;
        r3 = r3 & r2;
        if(r3 == 0x0) {
          r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r1 = r2 - r5;
          r3 = 0x1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r3 = 0xf;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r1 = r1 + 0x1;
          r2 = r2 + 0x2;
          r3 = 0x6;
          FUN_80ab1f4(sp4c.panel_30.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_80ac7fa
        r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r3 = r3 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
        r1 = sp4c.partyMemberCount_219.get();
        r0 = r3;
        r0 = FUN_80aa538(r0, r1);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
        if(sp50 == 0x0) {
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r2);
          r3 = sp4c.partyMemberCount_219.get();
          if(0 < r3) {
            //LAB_80ac820
            do {
              r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r3 = MEMORY.ref(1, r7 + r0).get();
              if(r3 == 0x4) {
                r0 = r0 + 0x1;
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
                r1 = sp4c.partyMemberCount_219.get();
                r0 = FUN_80aa538(r0, r1);
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r0);
              }

              //LAB_80ac836
              r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r1 = r1 + 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
              r3 = sp4c.partyMemberCount_219.get();
            } while(r1 < r3);
          }
        }
      }

      //LAB_80ac842
      r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(r2);
      r3 = r3 + 0xa0;
      r5 = r9;
      r1 = MEMORY.ref(1, r5 + r3).get();
      if(r1 == 0x0) {
        r1 = 0x1;
      }

      //LAB_80ac854
      r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      r0 = FUN_80aa538(r0, r1);
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r7 = 0x2;
      r0 = r0 << 3;
      MEMORY.ref(4, CPU.sp().value + 0x48).setu(r7);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
      break;
    } while(true);

    //LAB_80ac86a
    r1 = CPU.sp().value + 0x38;
    r2 = MEMORY.ref(1, r1).getUnsigned();
    sp4c._1c.get(sp50).set(r2);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = 0x1;
    r3 = -r3;
    if(r2 != r3) {
      r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r3 = r2 * 10;
      r3 = r3 + MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r3 = r3 << 1;
      r0 = r9;
      r2 = MEMORY.ref(2, r0 + r3).getUnsigned();
      sp4c.abilityId_178.get(sp50).set(r2);
      sp4c._254.get(sp50).set(r2 & 0x1f);
      sp4c._256.get(sp50).set((r2 & 0xe0) >>> 5);
      sp4c._258.get(sp50).set((r2 & 0xf00) >>> 8);
    }

    //LAB_80ac8cc
    r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    r3 = r1 << 2;
    r3 = r3 + r1;
    r7 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    r3 = r3 << 1;
    r3 = r7 + r3;
    sp4c._174.get(sp50).set(r3);
    CPU.sp().value += 0x6c;
    return r5;
  }

  @Method(0x80ac8fc)
  public static int FUN_80ac8fc(final int r0, final int unitId, final int r2) {
    final Unit14c r10 = getUnit_(unitId);
    int r7 = 0;
    if(r2 == -1) {
      //LAB_80ac934
      for(int r8 = 0; r8 < 4; r8++) {
        //LAB_80ac946
        for(int i = 0; i < 20; i++) {
          if((r10.djinn_f8.set_10.get(r8).get() & 0x1 << i) != 0) {
            MEMORY.ref(2, r0 + r7 * 0x2).setu(unitId << 8 | r8 << 5 | i | 0xffff8000);
            r7++;
            //LAB_80ac960
          } else if((r10.djinn_f8.standby_00.get(r8).get() & 0x1 << i) != 0) {
            MEMORY.ref(2, r0 + r7 * 0x2).setu(unitId << 8 | r8 << 5 | i);
            r7++;
          }

          //LAB_80ac97c
        }
      }
    } else {
      //LAB_80ac994
      //LAB_80ac9b8
      for(int i = 0; i < 20; i++) {
        if((r10.djinn_f8.set_10.get(r2).get() & 0x1 << i) != 0) {
          MEMORY.ref(2, r0 + r7 * 0x2).setu(r2 << 5 | i | 0xffff8000);
          r7++;
          //LAB_80ac9ce
        } else if((r10.djinn_f8.standby_00.get(r2).get() & 0x1 << i) != 0) {
          MEMORY.ref(2, r0 + r7 * 0x2).setu(r2 << 5 | i);
          r7++;
        }

        //LAB_80ac9e4
      }
    }

    //LAB_80ac9ea
    return r7;
  }

  @Method(0x80aca04)
  public static int FUN_80aca04(final int r0, final int r1) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    if(r0 == 0) {
      FUN_80acab8(r7.panel_34.deref(), 0, 0, r7._258.get(1).get(), 1, 0, 2, r1, 1);
      FUN_80acab8(r7.panel_24.deref(), 0, 0, r7._258.get(0).get(), 0, 1, 2, r1, 0);
    } else {
      //LAB_80aca5a
      FUN_80acab8(r7.panel_34.deref(), 0, 0, r7._21a.get(1).get(), 1, 0, 2, r1, 1);
      FUN_80acab8(r7.panel_24.deref(), 0, 0, r7._21a.get(0).get(), 0, 0, 1, r1, 0);
    }

    //LAB_80aca98
    return 1;
  }

  @Method(0x80acab8)
  public static int FUN_80acab8(final Panel24 r9, int r1, int r2, int r3, final int a4, final int a5, final int a6, final int a7, final int a8) {
    int r0;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;
    int r11;
    int r12;
    final int lr;

    CPU.sp().value -= 0xac;
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
    Unit14c sp34 = getUnit_(r3);
    r1 = 0x95;
    r3 = 0x3001f2c;
    r4 = MEMORY.ref(4, r3).get();
    r1 = r1 << 2;
    r0 = r4 + 0x2;
    r3 = a4 + r1;
    r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r2);
    r3 = MEMORY.ref(1, r4 + r3).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
    r3 = 0xbc;
    r3 = r3 << 1;
    r12 = r3;
    r5 = a4 << 1;
    r5 = r5 + r12;
    r2 = 0x80;
    lr = r0;
    r2 = r2 << 8;
    r3 = r2 & MEMORY.ref(2, r4 + r5).getUnsigned();
    r3 = r3 << 16;
    r3 = r3 >>> 16;
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
    r1 = a5 + r1;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(MEMORY.ref(1, lr + r1).getUnsigned());
    r1 = MEMORY.ref(1, r4 + r1).getUnsigned();
    r6 = a5 << 1;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
    r6 = r6 + r12;
    r3 = MEMORY.ref(2, r4 + r6).getUnsigned();
    r2 = r2 & r3;
    r2 = r2 << 16;
    r2 = r2 >>> 16;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);

    final Unit14c sp30 = MEMORY.ref(4, mallocChip(0x14c), Unit14c::new);
    MEMORY.memcpy(sp30.getAddress(), sp34.getAddress(), 0x14c);

    if(a7 == 0x0) {
      //LAB_80acb44
      if(a6 == 0x3) {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r2 = r2 << 3;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r11 = r2;
        r7 = r3 << 3;
        r5 = r11;
        r1 = 0x38;
        r5 = r5 + 0x50;
        r1 = r1 + r7;
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        r10 = r1;
        r3 = r5;
        r1 = 0x3;
        FUN_80150b0(sp34.maxHp_34.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        r1 = 0x40;
        r1 = r1 + r7;
        r8 = r1;
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        r3 = r5;
        r1 = 0x3;
        FUN_80150b0(sp34.maxPp_36.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        r5 = r5 - 0x20;
        r1 = r10;
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        r3 = r5;
        r1 = 0x3;
        FUN_80150b0(sp34.hp_38.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        r1 = r8;
        MEMORY.ref(4, CPU.sp().value).setu(r1);
        r3 = r5;
        r1 = 0x3;
        FUN_80150b0(sp34.pp_3a.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        r6 = r11;
        r6 = r6 + 0x48;
        r2 = r6;
        r3 = r10;
        FUN_8015090(0x80af290, r9, r2, r3);
        r2 = r6;
        r3 = r8;
        FUN_8015090(0x80af290, r9, r2, r3);
      } else {
        //LAB_80acbd2
        r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r1 = r1 << 3;
        r7 = r2 << 3;
        r11 = r1;
        r5 = r11;
        r3 = r7;
        r5 = r5 + 0x30;
        r3 = r3 + 0x38;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r1 = 0x3;
        r3 = r5;
        FUN_80150b0(sp34.hp_38.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        r3 = r7;
        r3 = r3 + 0x40;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r1 = 0x3;
        r3 = r5;
        FUN_80150b0(sp34.pp_3a.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
      }

      //LAB_80acc0c
      r5 = r11;
      r3 = r7;
      r5 = r5 + 0x30;
      r3 = r3 + 0x48;
      r1 = 0x3;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r3 = r5;
      FUN_80150b0(sp34.attack_3c.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
      r3 = r7;
      r3 = r3 + 0x50;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x3;
      r3 = r5;
      FUN_80150b0(sp34.defence_3e.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
      r3 = r7;
      r3 = r3 + 0x58;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x3;
      r3 = r5;
      FUN_80150b0(sp34.agility_40.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
      r2 = r7;
      r2 = r2 + 0x60;
      r3 = r11;
      MEMORY.ref(4, CPU.sp().value).setu(r2);
      r3 = r3 + 0x38;
      r1 = 0x2;
      FUN_80150b0(sp34.luck_42.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
    }

    //LAB_80acc66
    if(a6 == 0x0) {
      //LAB_80acc82
      r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = 0x1f;
      r5 = r5 & r2;
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      r2 = r5;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      FUN_80771a8(r0, r1, r2);
      r2 = r5;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      setDjinn_(r0, r1, r2);
    } else if(a6 == 0x1) {
      //LAB_80acc9e
      r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
      r3 = 0x1f;
      r0 = r0 & r3;
      MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
      FUN_80771b8(r0, r1, r2);
    } else if(a6 == 0x2) {
      //LAB_80accb2
      r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      if(r1 != 0x0) {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = 0x1f;
        r2 = r2 & r3;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        MEMORY.ref(4, CPU.sp().value + 0x28).setu(r2);
        FUN_80771b8(r0, r1, r2);
      }

      //LAB_80accc8
      r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = 0x1f;
      r5 = r5 & r3;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      r2 = r5;
      FUN_80771a8(r0, r1, r2);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      if(r0 != 0x0) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r2 = r5;
        setDjinn_(r0, r1, r2);
      }
    } else if(a6 == 0x4) {
      //LAB_80accea
      r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = 0x1f;
      r5 = r5 & r1;
      r2 = r5;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      FUN_80771a8(r0, r1, r2);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      if(r2 != 0x0) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r2 = r5;
        setDjinn_(r0, r1, r2);
      }
    }

    //LAB_80acd0a
    recalcStats_(MEMORY.ref(4, CPU.sp().value + 0x38).get());
    sp34 = getUnit_(MEMORY.ref(4, CPU.sp().value + 0x38).get());
    if(a7 == 0x0) {
      r11 = MEMORY.ref(4, CPU.sp().value + 0x40).get() * 8;
      r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r7 = r1 << 3;
      r6 = r11 + 0x28;
      r5 = r7 + 0x10;
      FUN_8015090(sp34.name_00.getAddress(), r9, r6, r7);
      FUN_8015090(0x80af28c, r9, r6, r5);
      FUN_80150b0(sp34.level_0f.get(), 2, r9, r11 + 0x58, r5);
      drawIcon_(0x8ae, r9, r11, r7 + 0x38);
      drawIcon_(0x8af, r9, r11, r7 + 0x40);
      drawIcon_(0x8b0, r9, r11, r7 + 0x48);
      drawIcon_(0x8b1, r9, r11, r7 + 0x50);
      drawIcon_(0x8b2, r9, r11, r7 + 0x58);
      drawIcon_(0x8b3, r9, r11, r7 + 0x60);
      drawIcon_(0x741 + sp30.class_129.get(), r9, r11, r7 + 0x20);
    }

    //LAB_80acdca
    if(a7 == 0x0) {
      //LAB_80acdd2
      r1 = sp30.class_129.get();
      r3 = sp34.class_129.get();
      r12 = r1;
      if(r12 != r3) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r3 = r1 << 3;
        r2 = r2 << 3;
        r3 = r3 + 0x30;
        r11 = r2;
        drawIcon_(0x741 + sp34.class_129.get(), r9, r2, r3);
        FUN_8015280(r9, 0xf296, MEMORY.ref(4, CPU.sp().value + 0x40).get() + 2, 5, a7);
        r1 = sp30.class_129.get();
        r3 = sp34.class_129.get();
      } else {
        //LAB_80ace38
        r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r0 = r0 << 3;
        r11 = r0;
      }

      //LAB_80ace3e
      r12 = r1;
      r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
      if(r12 != r3) {
        r2 = r2 + 0x5;
      }

      //LAB_80ace48
      r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r1 = r1 + 0x5;
      r8 = r1;
      r10 = 0;
      r7 = r2 + 0x1;
      r5 = r2;

      //LAB_80ace5e
      for(r4 = 0; r4 < 4; r4++) {
        FUN_8015280(r9, 0x5001 + r4, r5, r8, r10);
        FUN_8015280(r9, 0xf030 + sp34.djinn_f8.setCounts_24.get(r4).get(), r7, r8, r10);
        r7 = r7 + 0x2;
        r5 = r5 + 0x2;
      }

      r8 = r11 + 0x46;
      if(sp34.hp_38.get() != sp30.hp_38.get()) {
        FUN_80150b0(sp34.hp_38.get(), 4, r9, r11 + 0x48, MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8 + 0x38);
        r2 = sp34.hp_38.get();
        if(r2 > sp30.hp_38.get()) {
          FUN_80ae9f0(r9, r8, r2 + 0x38, 0);
        } else {
          //LAB_80acede
          FUN_80ae9f0(r9, r8, r2 + 0x38, 1);
        }
      }

      //LAB_80aceea
      if(sp34.pp_3a.get() != sp30.pp_3a.get()) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r2 = r1 << 3;
        r5 = r2;
        r3 = r11;
        r3 = r3 + 0x48;
        r1 = 0x4;
        r5 = r5 + 0x40;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        FUN_80150b0(sp34.pp_3a.get(), r1, r9, r3, MEMORY.ref(4, CPU.sp().value).get());
        if(sp34.pp_3a.get() > sp30.pp_3a.get()) {
          r1 = r8;
          r2 = r5;
          r3 = 0x0;
          FUN_80ae9f0(r9, r1, r2, r3);
        } else {
          //LAB_80acf2e
          r1 = r8;
          r2 = r5;
          r3 = 0x1;
          FUN_80ae9f0(r9, r1, r2, r3);
        }
      }

      //LAB_80acf3a
      if(sp34.attack_3c.get() != sp30.attack_3c.get()) {
        r5 = MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8 + 0x48;
        FUN_80150b0(sp34.attack_3c.get(), 4, r9, r11 + 0x48, r5);
        if(sp34.attack_3c.get() > sp30.attack_3c.get()) {
          r1 = r8;
          r2 = r5;
          r3 = 0x0;
          FUN_80ae9f0(r9, r1, r2, r3);
        } else {
          //LAB_80acf78
          r1 = r8;
          r2 = r5;
          r3 = 0x1;
          FUN_80ae9f0(r9, r1, r2, r3);
        }
      }

      //LAB_80acf84
      if(sp34.defence_3e.get() != sp30.defence_3e.get()) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r2 = r1 << 3;
        r5 = r2;
        r3 = r11;
        r3 = r3 + 0x48;
        r5 = r5 + 0x50;
        r1 = 0x4;
        FUN_80150b0(sp34.defence_3e.get(), r1, r9, r3, r5);
        if(sp34.defence_3e.get() > sp30.defence_3e.get()) {
          r1 = r8;
          r2 = r5;
          r3 = 0x0;
          FUN_80ae9f0(r9, r1, r2, r3);
        } else {
          //LAB_80acfc2
          r1 = r8;
          r2 = r5;
          r3 = 0x1;
          FUN_80ae9f0(r9, r1, r2, r3);
        }
      }

      //LAB_80acfce
      if(sp34.agility_40.get() != sp30.agility_40.get()) {
        FUN_80150b0(sp34.agility_40.get(), 4, r9, 72 + r11, 88 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8);

        if(sp34.agility_40.get() > sp30.agility_40.get()) {
          FUN_80ae9f0(r9, r8, 88 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8, 0);
        } else {
          //LAB_80ad00c
          FUN_80ae9f0(r9, r8, 88 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8, 1);
        }
      }

      //LAB_80ad018
      if(sp34.luck_42.get() != sp30.luck_42.get()) {
        FUN_80150b0(sp34.luck_42.get(), 2, r9, 88 + r11, 96 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8);

        if(sp34.luck_42.get() > sp30.luck_42.get()) {
          FUN_80ae9f0(r9, r8, 96 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8, 0);
        } else {
          //LAB_80ad056
          FUN_80ae9f0(r9, r8, 96 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8, 1);
        }
      }
    }

    //LAB_80ad062
    if(a7 > 0) {
      //LAB_80ad06a
      r2 = a6 ^ 0x3;
      r10 = (-r2 | r2) >>> 31;
      r10 = 6 - r10;
      r3 = a7 - 0x1;
      r8 = r10 * r3;
      r5 = CPU.sp().value + 0x4c;
      r0 = FUN_80aae14(sp30.psynergy_58, sp34.psynergy_58, r5, CPU.sp().value + 0x48, CPU.sp().value + 0x44);
      r0 = r0 << 24;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
      r3 = r0 >> 24;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
      r0 = r0 << 3;
      r2 = 0x0;
      r1 = 0x0;
      r11 = r0;
      if(r8 < r3) {
        if(r1 < r10) {
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
          r3 = r8 * 2;
          r7 = r3 + r5;

          //LAB_80ad0c4
          do {
            r6 = r2 << 24;
            r2 = r6 >> 23;
            FUN_80ae958(r9, r11, 4 + (MEMORY.ref(4, CPU.sp().value + 0x3c).get() + r2) * 8, MEMORY.ref(2, r7).getUnsigned() & 0x3fff);

            r2 = MEMORY.ref(2, r7).getUnsigned();
            if((r2 & 0x8000) != 0) {
              FUN_80150b8(4);
              //LAB_80ad0f0
            } else if((r2 & 0x4000) != 0) {
              FUN_80150b8(2);
            } else {
              //LAB_80ad114
              FUN_80150b8(15);
            }

            //LAB_80ad11a
            r6 = r6 >> 24;
            r3 = MEMORY.ref(2, r7).getUnsigned();
            r5 = MEMORY.ref(4, CPU.sp().value + 0x3c).get() + r6 * 2;
            drawIcon_(0x333 + (r3 & 0x3fff), r9, 16 + MEMORY.ref(4, CPU.sp().value + 0x14).get(), 8 + r5 * 8);
            drawNumber_(getAbility_(MEMORY.ref(2, r7).getUnsigned()).cost_09.get(), 2, r9, 88 + MEMORY.ref(4, CPU.sp().value + 0x14).get(), 8 + r5 * 8);
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = r0 + 0x1000000;
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r6 = r6 + 0x1;
            r1 = r3 >>> 24;
            r6 = r6 << 24;
            r8++;
            r3 = r0 >> 24;
            r2 = r6 >>> 24;
            r7 = r7 + 0x2;
            if(r8 >= r3) {
              break;
            }
            r3 = r1 << 24;
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
            r3 = r3 >> 24;
          } while(r3 < r10);
        } else {
          //LAB_80ad17c
          r11 = MEMORY.ref(4, CPU.sp().value + 0x40).get() * 8;
        }
      }

      //LAB_80ad182
      FUN_80150b8(15);
      drawIcon_(0xaed, r9, 88 + r11, MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8);

      if(a6 != 3) {
        r5 = 0;

        if(MEMORY.ref(4, CPU.sp().value + 0x48).get() != 0) {
          FUN_80150b8(4);
          drawIcon_(0xba2, r9, r11, 88 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8);
          r5++;
        }

        //LAB_80ad1be
        if(MEMORY.ref(4, CPU.sp().value + 0x44).get() != 0) {
          FUN_80150b8(2);
          drawIcon_(0xba3, r9, r11, 88 + (MEMORY.ref(4, CPU.sp().value + 0x3c).get() + r5) * 8);
          r5++;
        }

        //LAB_80ad1de
        if(r5 == 0) {
          drawIcon_(0xba8, r9, r11, 88 + MEMORY.ref(4, CPU.sp().value + 0x3c).get() * 8);
        }

        //LAB_80ad1f0
        FUN_80150b8(15);
        FUN_8015070(r9, 0, 11, 13, 11);
      }

      //LAB_80ad206
      boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea3.set(1);
    }

    //LAB_80ad212
    if(a7 == 0) {
      FUN_80150d8(MEMORY.ref(4, CPU.sp().value + 0x38).get(), 0, a8, r9, 0, 0);
    }

    //LAB_80ad228
    MEMORY.memcpy(sp34.getAddress(), sp30.getAddress(), 0x14c);
    setMallocAddress(sp30.getAddress());
    CPU.sp().value += 0xac;
    return 1;
  }

  @Method(0x80ad40c)
  public static void FUN_80ad40c() {
    CPU.sp().value -= 0x24;
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    FUN_8015418(0x6002500);
    final int r11 = CPU.sp().value + 0xc;

    //LAB_80ad44c
    for(int sp08 = 0; sp08 < 4; sp08++) {
      final Sprite38 r6 = r8._224.get(sp08).derefNullable();

      if(r6 != null) {
        final int r10 = 0x1e20000 - (r8._144.get(sp08).get() << 16);
        r6.packet_00.attribs_04.attrib2_04.and(~0xc00);

        final int r5 = r8._244.get(sp08).get();
        if(r5 < 0) {
          MEMORY.ref(4, r11).setu(-r5);
          MEMORY.ref(4, r11 + 0x4).setu(-r5);
        } else {
          //LAB_80ad488
          final int r0 = r5 + divideS(0x10000 - r5, 3);
          MEMORY.ref(4, r11).setu(r0);
          MEMORY.ref(4, r11 + 0x4).setu(r0);
          r8._244.get(sp08).set(MEMORY.ref(4, r11).get());
        }

        //LAB_80ad4a4
        final int r1 = CPU.sp().value + 0x14;
        MEMORY.ref(4, r1).setu(r8._234.get(sp08).get() << 16);
        MEMORY.ref(4, r1 + 0x4).setu(r10);
        MEMORY.ref(4, r1 + 0x8).setu((r8._23c.get(sp08).get() << 16) + r10);
        MEMORY.ref(4, r1 + 0xc).setu(0);

        final int r3;
        if(r8._23c.get(sp08).get() >= 0) {
          r3 = 0x4000;
        } else {
          r3 = 0x8000;
        }

        //LAB_80ad4d0
        drawSprite_(r6, r1, r11, r3);
      }

      //LAB_80ad4d8
    }

    CPU.sp().value += 0x24;
  }

  @Method(0x80ad508)
  public static void FUN_80ad508() {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80ad51e
    for(int i = 0; i < 4; i++) {
      final Sprite38 r0 = r6._224.get(i).derefNullable();
      if(r0 != null) {
        clearSprite_(r0);
        r6._224.get(i).clear();
      }

      //LAB_80ad52e
    }

    //LAB_80ad54c
    for(int i = 0; i < 4; i++) {
      final Sprite38 r5 = loadSprite_(MEMORY.ref(4, 0x80af304 + i * 0x4).get());
      if(r5 != null) {
        setSpriteAnimation_(r5, 2);
      }

      //LAB_80ad568
      r6._224.get(i).setNullable(r5);
      r6._234.get(i).set(0x10);
      r6._23c.get(i).set(0xc8);
      r6._244.get(i).set(0x10000);
    }

    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80ad40c"), 0xc80);
  }

  @Method(0x80ad5b4)
  public static void FUN_80ad5b4(final int index, final int r1, final int r2, final int r3) {
    final Menua70 r4 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    if(!r4._224.get(index).isNull()) {
      r4._234.get(index).set(r1);
      r4._23c.get(index).set(r3 != 0 ? r2 | ~0x7fff : r2);
    }
  }

  @Method(0x80ad5f4)
  public static void FUN_80ad5f4(final int index, final int val) {
    boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._244.get(index).set(val);
  }

  @Method(0x80ad608)
  public static int FUN_80ad608(final int r0, final int r1, final int r2) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Sprite38 sprite1 = r7._224.get(r0).derefNullable();
    if(sprite1 != null) {
      clearSprite_(sprite1);
      r7._224.get(r0).clear();
    }

    //LAB_80ad62c
    final Sprite38 sprite2 = loadSprite_(MEMORY.ref(4, 0x80af304 + r1 * 0x4).get());
    if(sprite2 != null) {
      setSpriteAnimation_(sprite2, r2);
    }

    //LAB_80ad642
    r7._224.get(r0).setNullable(sprite2);
    return 1;
  }

  @Method(0x80ad658)
  public static void FUN_80ad658() {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80ad66c
    for(int r7 = 0; r7 < 4; r7++) {
      final Sprite38 r0 = r6._224.get(r7).derefNullable();
      if(r0 != null) {
        clearSprite_(r0);
        r6._224.get(r7).clear();
      }

      //LAB_80ad67a
    }

    clearTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80ad40c"));
  }

  @Method(0x80ad6d4)
  public static int FUN_80ad6d4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;
    final int r11;

    CPU.sp().value -= 0x88;
    final Menua70 r9 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r1 = 0x1;
    r2 = 0x0;
    r3 = 0x2;
    r11 = r0;
    r0 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x64).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x60).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x58).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x5c).setu(r2);
    r9._14.get(0).deref()._05.set(13);
    r0 = CPU.sp().value + 0x80;
    MEMORY.ref(4, CPU.sp().value + 0x80).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    MEMORY.ref(4, r0 + 0x4).setu(0);

    //LAB_80ad71a
    for(r2 = 0; r2 < 4; r2++) {
      r9._144.get(r2).set(200);
    }

    r9._134.get(r9._1c.get(1).get()).set(120);
    r9._144.get(r9._1c.get(1).get()).set(32);
    r9._134.get(r9._1c.get(0).get()).set(16);
    r9._144.get(r9._1c.get(0).get()).set(32);
    FUN_8015278(r9.panel_30.deref());
    sleep(1);
    FUN_80a1114(r9.panel_10c, 1);
    r3 = 0x5;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = 0x2;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r1 = 0x0;
    r2 = 0x0;
    r3 = 0x1e;
    r0 = FUN_80a10d0(r9.panel_10c, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    r1 = CPU.sp().value;
    r7 = 0x1;
    r1 = r1 + 0x78;
    r2 = r11;
    MEMORY.ref(4, CPU.sp().value + 0x78).setu(r7);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
    MEMORY.ref(4, r1 + 0x4).setu(r7);
    if((r2 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
      //LAB_80ad7c2
      MEMORY.ref(4, CPU.sp().value + 0x54).setu(mallocBoard(0x60));
      final Unit14c unit1 = MEMORY.ref(4, mallocBoard(0x14c), Unit14c::new);
      MEMORY.ref(4, CPU.sp().value + 0x4c).setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x48).setu(0);
      r6 = r9._21a.get(0).get();
      MEMORY.ref(4, CPU.sp().value + 0x50).setu(r9._256.get(0).get());
      r8 = r9._254.get(0).get() & 0x1f;
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r9.abilityId_178.get(0).get() & 0x8000);
      final Unit14c unit2 = getUnit_(r6);
      MEMORY.memcpy(unit1.getAddress(), unit2.getAddress(), 0x14c);
      FUN_80771b8(r6, MEMORY.ref(4, CPU.sp().value + 0x50).get(), r8);

      if(r11 == 0x0) {
        r3 = r9._256.get(1).get();
        MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
        r2 = r9._254.get(1).get() & 0x1f;
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(r2);
        FUN_80771a8(r6, MEMORY.ref(4, CPU.sp().value + 0x4c).get(), r2);

        if((r9.abilityId_178.get(1).get() & 0x8000) != 0) {
          setDjinn_(r6, MEMORY.ref(4, CPU.sp().value + 0x4c).get(), MEMORY.ref(4, CPU.sp().value + 0x48).get());
        }
      }

      //LAB_80ad870
      recalcStats_(r6);
      MEMORY.ref(4, CPU.sp().value + 0x78).setu(FUN_80aae14(unit1.psynergy_58, unit2.psynergy_58, MEMORY.ref(4, CPU.sp().value + 0x54).get(), CPU.sp().value + 0x74, CPU.sp().value + 0x70));
      MEMORY.memcpy(unit2.getAddress(), unit1.getAddress(), 0x14c);
      r6 = r9._21a.get(1).get();
      final Unit14c unit3 = getUnit_(r6);
      MEMORY.memcpy(unit1.getAddress(), unit3.getAddress(), 0x14c);

      if(r11 == 0x0) {
        FUN_80771b8(r6, MEMORY.ref(4, CPU.sp().value + 0x4c).get(), MEMORY.ref(4, CPU.sp().value + 0x48).get());
      }

      //LAB_80ad8d2
      FUN_80771a8(r6, MEMORY.ref(4, CPU.sp().value + 0x50).get(), r8);

      if(MEMORY.ref(4, CPU.sp().value + 0x44).get() != 0x0) {
        setDjinn_(r6, MEMORY.ref(4, CPU.sp().value + 0x50).get(), r8);
      }

      //LAB_80ad8ec
      recalcStats_(r6);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      MEMORY.ref(4, r4 + 0x4).setu(FUN_80aae14(unit1.psynergy_58, unit3.psynergy_58, MEMORY.ref(4, CPU.sp().value + 0x54).get(), CPU.sp().value + 0x74, CPU.sp().value + 0x70));
      MEMORY.memcpy(unit3.getAddress(), unit1.getAddress(), 0x14c);
      setMallocAddress(unit1.getAddress());
      setMallocAddress(MEMORY.ref(4, CPU.sp().value + 0x54).get());
    } else {
      //LAB_80ad922
      r3 = r11;
      r3 = r3 - 0x2;
      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(mallocBoard(0x60));
        final Unit14c unit1 = MEMORY.ref(4, mallocBoard(0x14c), Unit14c::new);
        r6 = r9._21a.get(0).get();
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r9._256.get(0).get());
        r8 = r9._254.get(0).get() & 0x1f;
        r3 = r11 ^ 0x3;
        r5 = (-r3 | r3) >>> 31;
        r5 = r7 - r5;
        final Unit14c unit2 = getUnit_(r6);
        MEMORY.memcpy(unit1.getAddress(), unit2.getAddress(), 0x14c);
        FUN_80771b8(r6, MEMORY.ref(4, CPU.sp().value + 0x30).get(), r8);

        if(r5 != 0x0) {
          setDjinn_(r6, MEMORY.ref(4, CPU.sp().value + 0x30).get(), r8);
        }

        //LAB_80ad998
        recalcStats_(r6);
        r0 = FUN_80aae14(unit1.psynergy_58, unit2.psynergy_58, MEMORY.ref(4, CPU.sp().value + 0x34).get(), CPU.sp().value + 0x6c, CPU.sp().value + 0x68);
        MEMORY.ref(4, CPU.sp().value + 0x78).setu(r0);
        MEMORY.memcpy(unit2.getAddress(), unit1.getAddress(), 0x14c);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        MEMORY.ref(4, r0 + 0x4).setu(MEMORY.ref(4, CPU.sp().value + 0x78).get());
        MEMORY.ref(4, CPU.sp().value + 0x58).setu(0);
        setMallocAddress(unit1.getAddress());
        r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
        setMallocAddress(r0);
      }
    }

    //LAB_80ad9d8
    r0 = MEMORY.ref(4, CPU.sp().value + 0x78).get();
    r1 = 0x5;
    r0 = r0 - 0x1;
    r0 = divideS(r0, r1);
    r0 = r0 + 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x78).setu(r0);
    if(r0 == 0x0) {
      r3 = 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x78).setu(r3);
    }

    //LAB_80ad9ee
    r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r0 = MEMORY.ref(4, r2 + 0x4).get();
    r1 = 0x5;
    r0 = r0 - 0x1;
    r0 = divideS(r0, r1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r0 = r0 + 0x1;
    MEMORY.ref(4, r3 + 0x4).setu(r0);
    if(r0 == 0x0) {
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = 0x1;
      MEMORY.ref(4, r4 + 0x4).setu(r3);
    }

    //LAB_80ada0a
    r5 = 0x2;
    r6 = 0xf;
    r1 = 0x0;
    r2 = 0x5;
    r3 = 0xf;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_80a10d0(r9.panel_24, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
    r2 = 0x5;
    r3 = 0xf;
    r1 = 0xf;
    MEMORY.ref(4, CPU.sp().value).setu(r6);
    FUN_80a10d0(r9.panel_34, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    drawPanelBackground_(r9.panel_10c.deref());
    r2 = r11;
    if(r2 == 0x2) {
      r0 = 0xba5;
      r2 = 0x60;
      r3 = 0x0;
      drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
      r0 = 0xbc1;
      r2 = 0x60;
      r3 = 0x10;
      drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
    } else {
      //LAB_80ada4e
      r3 = r11;
      if(r3 == 0x3) {
        r0 = 0xba4;
        r2 = 0x60;
        r3 = 0x0;
        drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
        r0 = 0xbc1;
        r2 = 0x60;
        r3 = 0x10;
        drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
      } else {
        //LAB_80ada6e
        r4 = r11;
        if(r4 == 0x0) {
          r0 = 0xba7;
          r2 = 0x80;
          r3 = 0x0;
          drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
          r0 = 0xbc1;
          r2 = 0x80;
          r3 = 0x8;
          drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
        } else {
          //LAB_80ada8e
          r0 = 0xba6;
          r2 = 0x80;
          r3 = 0x0;
          drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
          r0 = 0xbc1;
          r2 = 0x80;
          r3 = 0x8;
          drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
        }
      }
    }

    //LAB_80adaa6
    r1 = 0x1;
    r2 = r11;
    r2 = r2 ^ r1;
    r0 = 0x80;
    r3 = -r2;
    r0 = r0 << 8;
    r3 = r3 | r2;
    r8 = r0;
    r2 = r9.abilityId_178.get(0).get();
    r5 = r3 >>> 31;
    r3 = r8;
    r3 = r3 & r2;
    r5 = r1 - r5;
    if(r3 == 0x0) {
      r0 = 0x2;
      FUN_80150b8(r0);
      r2 = r9.abilityId_178.get(0).get();
    }

    //LAB_80adad2
    r3 = 0xe0;
    r3 = r3 & r2;
    r3 = r3 >>> 5;
    r0 = r3 << 2;
    r0 = r0 + r3;
    r3 = 0x1f;
    r3 = r3 & r2;
    r1 = 0x45f;
    r0 = r0 << 2;
    r0 = r0 + r3;
    r0 = r0 + r1;
    r3 = r5 << 3;
    r2 = 0x30;
    drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
    r3 = r9.abilityId_178.get(0).get();
    r1 = 0xe0;
    r1 = r1 & r3;
    r2 = 0x5001;
    r3 = 0x0;
    r1 = r1 >>> 5;
    r1 = r1 + r2;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r2 = 0x5;
    r10 = r3;
    r3 = r5;
    FUN_8015280(r9.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r0 = 0xf;
    FUN_80150b8(r0);
    r4 = r11;
    if(r4 == 0x0) {
      r2 = r9.abilityId_178.get(1).get();
      r3 = r8;
      r3 = r3 & r2;
      if(r3 == 0x0) {
        r0 = 0x2;
        FUN_80150b8(r0);
        r2 = r9.abilityId_178.get(1).get();
      }

      //LAB_80adb38
      r3 = 0xe0;
      r3 = r3 & r2;
      r3 = r3 >>> 5;
      r0 = r3 << 2;
      r0 = r0 + r3;
      r3 = 0x1f;
      r3 = r3 & r2;
      r1 = 0x45f;
      r0 = r0 << 2;
      r0 = r0 + r3;
      r0 = r0 + r1;
      r2 = 0x30;
      r3 = 0x10;
      drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
      r3 = r9.abilityId_178.get(1).get();
      r1 = 0xe0;
      r1 = r1 & r3;
      r2 = 0x5001;
      r3 = r11;
      r1 = r1 >>> 5;
      r1 = r1 + r2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r2 = 0x5;
      r3 = 0x2;
      FUN_8015280(r9.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r0 = 0xf;
      FUN_80150b8(r0);
    } else {
      //LAB_80adbba
      r3 = r11;
      r3 = r3 - 0x2;
      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
        r2 = r9.abilityId_178.get(0).get();
        r3 = r8;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          r0 = 0x2;
          FUN_80150b8(r0);
          r2 = r9.abilityId_178.get(0).get();
        }

        //LAB_80adbd4
        r3 = 0xe0;
        r3 = r3 & r2;
        r3 = r3 >>> 5;
        r0 = r3 << 2;
        r0 = r0 + r3;
        r3 = 0x1f;
        r4 = 0x45f;
        r3 = r3 & r2;
        r0 = r0 << 2;
        r0 = r0 + r3;
        r0 = r0 + r4;
        r2 = 0x30;
        r3 = 0x10;
        drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
        r3 = r9.abilityId_178.get(0).get();
        r1 = 0xe0;
        r1 = r1 & r3;
        r2 = 0x5001;
        r3 = r10;
        r1 = r1 >>> 5;
        r1 = r1 + r2;
        r2 = 0x5;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r3 = 0x2;
        FUN_8015280(r9.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
        r0 = 0xf;
        FUN_80150b8(r0);
        r4 = r10;
        r1 = 0xf296;
        r2 = 0x7;
        r3 = 0x1;
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        FUN_8015280(r9.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      }
    }

    //LAB_80adc24
    do {
      r3 = 0x3001e8c;
      r3 = MEMORY.ref(4, r3).get();
      r10 = r3;
      r6 = r9._184.get();
      r3 = 0x3001c94;
      r3 = MEMORY.ref(4, r3).get();
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
      r3 = 0x3001b04;
      r3 = MEMORY.ref(4, r3).get();
      r0 = 0x212c;
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
      r5 = r6 + r0;
      r3 = MEMORY.ref(4, r5).get();
      if(r3 != 0x0) {
        //LAB_80adc4a
        r0 = 0x80;
        r0 = r0 << 2;
        r0 = mallocBoard(r0);
        r1 = 0x0;
        r3 = 0x2128;
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
        r2 = r6 + r3;
        r3 = MEMORY.ref(4, r2).get();
        r3 = r3 + 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r3 = MEMORY.ref(4, r5).get();
        r3 = r3 - 0x5;
        r8 = r0;

        //LAB_80adc6e
        switch(r3) {
          case 0: // switch 80adc78
          case 7: // switch 80adc78
          case 18: // switch 80adc78
            //LAB_80adcc4
            r4 = 0x2128;
            r2 = r6 + r4;
            r3 = MEMORY.ref(4, r2).get();
            if(r3 == 0x64) {
              //LAB_80adcd0
              r0 = 0x1;
              r1 = 0x212c;
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(r0);
              r3 = 0x0;
              MEMORY.ref(4, r2).setu(r3);
              r2 = r6 + r1;
              r3 = MEMORY.ref(4, r2).get();
              r3 = r3 + 0x1;
              MEMORY.ref(4, r2).setu(r3);
            }
            break;

          case 5: // switch 80adc78
            //LAB_80adce6
            r2 = 0x2128;
            r3 = r6 + r2;
            r3 = MEMORY.ref(4, r3).get();
            if(r3 == 0x3c) {
              //LAB_80adcf2
              r2 = 0x80;
              r1 = r10;
              r0 = r8;
              r2 = r2 << 2;
              MEMORY.memcpy(r0, r1, r2);
              final Panel24 r7_0 = FUN_8015038(0xc43, 8, 0, 1);
              r9._14.get(0).deref()._05.set(1);
              r0 = 0x2;
              r1 = 0x60;
              FUN_80a1ac0(r0, r1);
              r3 = 0x2000240;
              r0 = 0x83;
              r0 = r0 << 2;
              r3 = r3 + r0;
              MEMORY.ref(1, r3).setu(1);

              //LAB_80add30
              do {
                r0 = FUN_8015048();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80add2a
                r0 = 0x1;
                sleep(r0);
              } while(true);

              r1 = 0x1;
              FUN_8015018(r7_0, r1);
              r2 = 0x80;
              r1 = r8;
              r2 = r2 << 2;
              r0 = r10;
              MEMORY.memcpy(r0, r1, r2);
              FUN_80152a8();
              r2 = 0xea3;
              r3 = 0x1;
              r2 = r2 + r10;
              MEMORY.ref(1, r2).setu(r3);
              r2 = 0x2128;
              MEMORY.ref(4, CPU.sp().value + 0x60).setu(r3);
              r1 = 0x0;
              r3 = r6 + r2;
              MEMORY.ref(4, r3).setu(r1);
              r3 = 0x212c;
              r2 = r6 + r3;
              r3 = 0xb;
              MEMORY.ref(4, r2).setu(r3);
              r9._14.get(0).deref()._05.set(13);
            }
            break;

          case 6: // switch 80adc78
            //LAB_80add72
            r0 = 0x2128;
            r3 = r6 + r0;
            r3 = MEMORY.ref(4, r3).get();
            if(r3 == 0x3c) {
              r2 = 0x80;
              r1 = r10;
              r0 = r8;
              r2 = r2 << 2;
              MEMORY.memcpy(r0, r1, r2);
              final Panel24 r7_0 = FUN_8015038(0xc42, 8, 0, 1);
              r9._14.get(0).deref()._05.set(1);
              r0 = 0x6a;
              r1 = 0x38;
              FUN_80a1ac0(r0, r1);
              r3 = 0x2000240;
              r2 = 0x83;
              r2 = r2 << 2;
              r3 = r3 + r2;
              MEMORY.ref(1, r3).setu(1);

              //LAB_80addba
              do {
                r0 = FUN_8015048();
                if(r0 != 0x0) {
                  break;
                }

                //LAB_80addb4
                r0 = 0x1;
                sleep(r0);
              } while(true);

              r1 = 0x1;
              FUN_8015018(r7_0, r1);
              r2 = 0x80;
              r1 = r8;
              r2 = r2 << 2;
              r0 = r10;
              MEMORY.memcpy(r0, r1, r2);
              FUN_80152a8();
              r2 = 0xea3;
              r3 = 0x1;
              r2 = r2 + r10;
              MEMORY.ref(1, r2).setu(r3);
              r0 = 0x1;
              sleep(r0);
              r4 = 0x2128;
              r3 = 0x1;
              r0 = 0x212c;
              MEMORY.ref(4, CPU.sp().value + 0x60).setu(r3);
              r5 = 0x0;
              r3 = r6 + r4;
              MEMORY.ref(4, r3).setu(r5);
              r2 = r6 + r0;
              r3 = 0xc;
              MEMORY.ref(4, r2).setu(r3);
              r9._14.get(0).deref()._05.set(13);
            }
            break;
        }

        //LAB_80ade06
        r0 = r8;
        setMallocAddress(r0);
      }

      //LAB_80ade0c
      r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r2 != 0x0) {
        //LAB_80ade14
        r3 = 0x1;
        r4 = r11;
        r8 = r3;
        if((r4 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
          r3 = 0x18;
          r1 = 0x80;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r2 = 0x10;
          r3 = 0xe0;
          FUN_8015068(r9.panel_10c.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          if(r0 == 0x1) {
            r0 = 0xba1;
            r2 = 0x80;
            r3 = 0x10;
            drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
          } else {
            //LAB_80ade48
            r1 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
            r2 = r1 ^ 0x2;
            r3 = (-r2 | r2) >>> 31;
            r0 = r9._21a.get(r3).get();
            r1 = 0x1;
            FUN_8015120(r0, r1);
            r0 = 0xba0;
            r2 = 0x80;
            r3 = 0x10;
            drawIcon_(r0, r9.panel_10c.deref(), r2, r3);
          }
        }

        //LAB_80ade78
        r2 = 0xea6;
        r3 = 0x1;
        r2 = r2 + r10;
        MEMORY.ref(1, r2).setu(r3);
        FUN_8015060(r9.panel_24.deref());
        FUN_8015060(r9.panel_34.deref());
        r4 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        r3 = r4 >>> 1;
        if(r3 != 0x0) {
          r0 = 0x1;
          sleep(r0);
        }

        //LAB_80ade9e
        if(r11 == 0x3) {
          r1 = 0x0;
          r7 = 0x0;
          r8 = r1;
          //LAB_80adeac
        } else if(r11 == 0x2) {
          r3 = 0x0;
          r7 = 0x1;
          r8 = r3;
        } else {
          //LAB_80adeba
          r7 = 0x2;
        }

        //LAB_80adebc
        r4 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
        if(r4 != 0x0) {
          if(r4 != 0x1) {
            r0 = r11;
            r1 = 0x0;
            FUN_80aca04(r0, r1);
          } else {
            //LAB_80aded0
            r0 = r11;
            if(r0 == 0x1) {
              r7 = 0x4;
            }

            //LAB_80aded8
            r2 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
            r3 = r9._21a.get(1).get();
            r5 = 0x0;
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r1 = 0x0;
            r2 = 0x0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r7);
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
            FUN_80acab8(r9.panel_24.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get());
            r4 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = r9._21a.get(1).get();
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r7);
            r2 = MEMORY.ref(4, r1 + 0x4).get();
            r2 = r2 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
            r1 = 0x0;
            r2 = 0x0;
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
            FUN_80acab8(r9.panel_34.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get());
          }
        } else {
          //LAB_80adf64
          r2 = r11;
          if(r2 == 0x1) {
            r3 = 0x0;
            r7 = 0x1;
            r8 = r3;
          }

          //LAB_80adf70
          r1 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          r2 = r8;
          r3 = r9._258.get(0).get();
          r6 = 0x1;
          MEMORY.ref(4, CPU.sp().value).setu(r1);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
          r2 = 0x0;
          r1 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r7);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r6);
          FUN_80acab8(r9.panel_24.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get());
          r2 = MEMORY.ref(4, CPU.sp().value + 0x80).get();
          r1 = r8;
          r2 = r2 + 0x1;
          r4 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          r3 = r9._258.get(0).get();
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
          r1 = 0x0;
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r7);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r6);
          FUN_80acab8(r9.panel_34.deref(), r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x10).get());
        }

        //LAB_80adfb4
        r2 = 0xea6;
        r3 = 0x0;
        r2 = r2 + r10;
        MEMORY.ref(1, r2).setu(r3);
      }

      //LAB_80adfbc
      r2 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
      if(r2 <= 0x1) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r4 = r2 << 2;
        final Panel24 r7_0 = r9.panel_34.deref();
        r3 = r4 + r0;
        r2 = MEMORY.ref(4, r3).get();
        if(r2 > 0x1) {
          r5 = 0x0;
          if(r5 < r2) {
            r6 = r3;

            //LAB_80adfda
            do {
              r2 = 0xf031;
              r1 = r5 + r2;
              if(r5 > 0x9) {
                r1 = 0xf030;
              }

              //LAB_80adfe4
              r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = MEMORY.ref(4, r4 + r0).get();
              if(r5 == r3) {
                r2 = 0xfffff000;
                r1 = r1 + r2;
              }

              //LAB_80adff0
              r3 = MEMORY.ref(4, r6).get();
              r2 = r7_0.w_08.get();
              r2 = r2 - r3;
              r2 = r2 + r5;
              r3 = 0x0;
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              r2 = r2 - 0x2;
              r3 = r3 - 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
              FUN_8015280(r7_0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              r3 = MEMORY.ref(4, r6).get();
              r5 = r5 + 0x1;
              r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            } while(r5 < r3);
          }

          //LAB_80ae012
          r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r2 = r7_0.w_08.get();
          r3 = MEMORY.ref(4, r4 + r0).get();
          r6 = 0x1;
          r6 = -r6;
          r2 = r2 - r3;
          r5 = 0x0;
          r3 = r6;
          r1 = 0xf128;
          r2 = r2 - 0x3;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          FUN_8015280(r7_0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r2 = r7_0.w_08.get();
          r1 = 0xf129;
          r2 = r2 - 0x2;
          r3 = r6;
          MEMORY.ref(4, CPU.sp().value).setu(r5);
          FUN_8015280(r7_0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r1 = 0xea3;
          r2 = r7_0.y_0e.get();
          r1 = r1 + r10;
          r2 = r2 >>> 2;
          r3 = 0x2;
          r3 = r3 << r2;
          r2 = MEMORY.ref(1, r1).getUnsigned();
          r3 = r3 | r2;
          MEMORY.ref(1, r1).setu(r3);
        }
      }

      //LAB_80ae050
      r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r1 = r1 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x5c).setu(r1);
      r0 = r1;
      r1 = 0x3c;
      r0 = modS(r0, r1);
      r6 = r0 - 0x5;
      if(r6 < 0x0) {
        r6 = 0x0;
      }

      //LAB_80ae066
      if(r6 > 0x1d) {
        r6 = 0x1d;
      }

      //LAB_80ae06c
      r5 = 0xffff4000;
      r0 = 0x0;
      r1 = r5;
      FUN_80ad5f4(r0, r1);
      r0 = 0x1;
      r1 = r5;
      FUN_80ad5f4(r0, r1);
      r2 = r11;
      if((r2 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
        r1 = 0x1e;
        r0 = r6;
        r0 = modS(r0, r1);
        r3 = r0;
        r0 = r3 << 4;
        r0 = r0 + r3;
        r0 = r0 << 4;
        r0 = r0 + r3;
        r0 = r0 << 2;
        r0 = sin(r0);
        r1 = r0;
        r0 = 0x10;
        r0 = mul16(r0, r1);
        r3 = 0x6;
        r5 = -r0;
        r3 = -r3;
        if(r5 < r3) {
          r5 = r3;
        }

        //LAB_80ae0b4
        if(r5 > 0xc) {
          r5 = 0xc;
        }

        //LAB_80ae0ba
        r0 = r6;
        r1 = 0x23;
        r0 = modS(r0, r1);
        r6 = r0 << 1;
        r1 = r6;
        r2 = r5;
        r3 = 0x0;
        r1 = r1 + 0x22;
        r2 = r2 + 0x14;
        r0 = 0x0;
        FUN_80ad5b4(r0, r1, r2, r3);
        r3 = r11;
        if(r3 == 0x0) {
          r1 = 0x63;
          r2 = 0x24;
          r1 = r1 - r6;
          r2 = r2 - r5;
          r0 = 0x1;
          r3 = 0x0;
          FUN_80ad5b4(r0, r1, r2, r3);
        }
      } else {
        //LAB_80ae0ec
        r0 = 0x0;
        r1 = 0x20;
        r2 = 0x1e;
        r3 = 0x0;
        FUN_80ad5b4(r0, r1, r2, r3);
      }

      //LAB_80ae0f8
      r4 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r4 != 0x0) {
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x60).setu(r0);
        r1 = 0x2;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        r0 = FUN_80aa538(r0, r1);
        MEMORY.ref(4, CPU.sp().value + 0x64).setu(r0);
      }

      //LAB_80ae10c
      r1 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
      r0 = r1 << 3;
      r0 = r0 - r1;
      r0 = r0 << 3;
      r0 = r0 + 0x50;
      r1 = 0x10;
      FUN_80a1a40(r0, r1);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r3 = 0x3;
      r3 = r3 & r2;
      if(r3 == 0x0) {
        r3 = 0x4;
        r3 = r3 & r2;
        if(r3 != 0x0) {
          r1 = 0x80af26c;
          r0 = 0x60052c0;
          r2 = 0x20;
          MEMORY.memcpy(r0, r1, r2);
        } else {
          //LAB_80ae13c
          r0 = 0x60052c0;
          r1 = 0x20;
          r2 = 0x44444444;
          memfill32(r0, r1, r2);
        }
      }

      //LAB_80ae148
      r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = 0x1;
      r3 = r3 & r4;
      if(r3 != 0x0) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        if(r0 != 0x0) {
          playSound_(0x71);
          r7 = -1;
        } else {
          //LAB_80adb7a
          r7 = 1;
        }
        break;
      }

      //LAB_80ae166
      r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = 0x8;
      r3 = r3 & r1;
      if(r3 != 0x0) {
        //LAB_80adbb4
        r0 = 0x71;
        playSound_(r0);
        r7 = -2;
        break;
      }

      //LAB_80ae172
      r3 = 0x2;
      r3 = r3 & r1;
      if(r3 != 0x0) {
        playSound_(0x71);
        r7 = -1;
        break;
      }
      r3 = 0x80;
      r3 = r3 << 1;
      r3 = r3 & r1;
      if(r3 != 0x0) {
        r2 = r11;
        if((r2 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          r1 = 0x3;
          r0 = r0 + 0x1;
          r0 = modS(r0, r1);
          r3 = 0x2;
          MEMORY.ref(4, CPU.sp().value + 0x58).setu(r0);
          r0 = 0x6f;
          MEMORY.ref(4, CPU.sp().value + 0x60).setu(r3);
          playSound_(r0);
        }
      } else {
        //LAB_80ae1a2
        r4 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r3 = 0x20;
        r3 = r3 & r4;
        if(r3 != 0x0) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          if(r0 <= 0x1) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = r0 << 2;
            r5 = r3 + r1;
            r0 = MEMORY.ref(4, r5).get();
            r0 = r0 - 0x1;
            MEMORY.ref(4, r5).setu(r0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r1 = MEMORY.ref(4, r3 + r2).get();
            r0 = FUN_80aa538(r0, r1);
            MEMORY.ref(4, r5).setu(r0);
            r0 = 0x6f;
            playSound_(r0);
            FUN_800352c();
            r3 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x60).setu(r3);
          }
        } else {
          //LAB_80ae1d8
          r4 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
          r3 = 0x10;
          r3 = r3 & r4;
          if(r3 != 0x0) {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
            if(r0 <= 0x1) {
              r0 = 0x6f;
              playSound_(r0);
              FUN_800352c();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
              r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = r1 << 2;
              r5 = r3 + r2;
              r0 = MEMORY.ref(4, r5).get();
              r0 = r0 + 0x1;
              MEMORY.ref(4, r5).setu(r0);
              r4 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x60).setu(r4);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r1 = MEMORY.ref(4, r3 + r2).get();
              r0 = FUN_80aa538(r0, r1);
              MEMORY.ref(4, r5).setu(r0);
            }
          }
        }
      }

      //LAB_80ae20e
      r0 = 0x1;
      sleep(r0);
    } while(true);

    //LAB_80ae216
    r1 = 0x0;
    r0 = 0x0;
    FUN_80ad5f4(r0, r1);
    r1 = 0x0;
    r0 = 0x1;
    FUN_80ad5f4(r0, r1);
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"), 0xc80);
    r3 = 0x3001e8c;
    r2 = MEMORY.ref(4, r3).get();
    r6 = 0xea6;
    r8 = r3;
    r3 = 0x1;
    r4 = 0x0;
    MEMORY.ref(1, r2 + r6).setu(r3);
    r1 = 0x1;
    r10 = r4;
    FUN_80a1114(r9.panel_10c, r1);
    r0 = 0x1;
    sleep(r0);
    r3 = 0x5;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = 0x2;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r2 = 0x0;
    r3 = 0x11;
    r1 = 0xd;
    FUN_80a10d0(r9.panel_10c, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
    FUN_80a1114(r9.panel_24, 1);
    FUN_80a1114(r9.panel_34, 1);
    drawPanelBackground_(r9.panel_30.deref());

    //BUGFIX: NPE
    if(!r9.panel_28.isNull()) {
      drawPanelBackground_(r9.panel_28.deref());
    }

    drawPanelBackground_(r9.panel_10.deref());
    r4 = r8;
    r3 = MEMORY.ref(4, r4).get();
    r0 = r10;
    r3 = r3 + r6;
    MEMORY.ref(1, r3).setu(r0);
    r0 = 0x1;
    sleep(r0);
    r0 = r7;
    CPU.sp().value += 0x88;
    return r0;
  }

  @Method(0x80ae2f4)
  public static int FUN_80ae2f4() {
    int r0;
    int r2;
    final int r3;
    int r5;
    final int r7;
    final int r11;

    CPU.sp().value -= 0x54;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(1);
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
    final Menua70 r9 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r9._14.get(0).deref()._05.set(13);
    r3 = CPU.sp().value + 0x4c;
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(0);
    MEMORY.ref(4, r3 + 0x4).setu(0);

    //LAB_80ae33c
    for(r2 = 0; r2 < 4; r2++) {
      r9._144.get(r2).set(200);
    }

    FUN_8015278(r9.panel_30.derefNullable());
    sleep(1);
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(1);
    r11 = CPU.sp().value + 0x44;
    MEMORY.ref(4, r11 + 0x4).setu(1);
    r5 = mallocBoard(0x60);
    final Unit14c r1 = getUnit_(r9._21a.get(0).get());
    r0 = FUN_80aae14(r1.psynergy_58, r1.psynergy_58, r5, CPU.sp().value + 0x40, CPU.sp().value + 0x3c);
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r0);
    MEMORY.ref(4, r11 + 0x4).setu(r0);
    setMallocAddress(r5);

    r0 = divideS(MEMORY.ref(4, CPU.sp().value + 0x44).get() - 1, 6) + 1;
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r0);
    if(r0 == 0) {
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(1);
    }

    //LAB_80ae3b2
    r0 = divideS(MEMORY.ref(4, r11 + 0x4).get() - 1, 6) + 1;
    MEMORY.ref(4, r11 + 0x4).setu(r0);
    if(r0 == 0) {
      MEMORY.ref(4, r11 + 0x4).setu(1);
    }

    //LAB_80ae3ca
    FUN_80a10d0(r9.panel_24, 0, 5, 15, 15, 0x2);
    FUN_80a10d0(r9.panel_34, 15, 5, 15, 15, 0x2);
    drawPanelBackground_(r9.panel_10c.deref());
    drawPanelBackground_(r9.panel_10.deref());
    drawIcon_(0xbaa, r9.panel_10.deref(), 0, 0);
    drawIcon_(0xbac, r9.panel_10.deref(), 0, 16);

    //LAB_80ae43c
    do {
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(MEMORY.ref(4, 0x3001e8c).get());
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(MEMORY.ref(4, 0x3001c94).get());
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(MEMORY.ref(4, 0x3001b04).get());

      if(MEMORY.ref(4, CPU.sp().value + 0x34).get() != 0) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        MEMORY.ref(1, r0 + 0xea6).setu(1);
        FUN_8015060(r9.panel_24.deref());
        FUN_8015060(r9.panel_34.deref());
        FUN_80acab8(r9.panel_24.deref(), 0, 0, r9._258.get(0).get(), 0, 0, 3, 0, 1);
        FUN_80acab8(r9.panel_34.deref(), 0, 0, r9._258.get(0).get(), 0, 0, 3, MEMORY.ref(4, CPU.sp().value + 0x4c).get() + 1, 1);
        MEMORY.ref(1, r0 + 0xea6).setu(0);
      }

      //LAB_80ae4b6
      if(MEMORY.ref(4, r11).get() > 1) {
        final Panel24 r6 = r9.panel_34.deref();

        //LAB_80ae4ce
        for(r5 = 0; r5 < MEMORY.ref(4, r11).get(); r5++) {
          int r1_0;
          if(r5 > 0x9) {
            r1_0 = 0xf030;
          } else {
            r1_0 = r5 + 0xf031;
          }

          //LAB_80ae4d8
          if(r5 == MEMORY.ref(4, r3).get()) {
            r1_0 = r1_0 - 0x1000;
          }

          //LAB_80ae4e6
          FUN_8015280(r6, r1_0, r6.w_08.get() - MEMORY.ref(4, r11).get() + r5 - 2, -1, 0);
        }

        //LAB_80ae506
        FUN_8015280(r6, 0xf128, r6.w_08.get() - MEMORY.ref(4, r11).get() - 3, -1, 0);
        FUN_8015280(r6, 0xf129, r6.w_08.get() - 2, -1, 0);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        MEMORY.ref(1, r0 + 0xea3).or(0x2 << (r6.y_0e.get() >>> 2));
      }

      //LAB_80ae54a
      MEMORY.ref(4, CPU.sp().value + 0x30).incr();
      FUN_80ad5b4(0, 32, 200, 0);

      if(MEMORY.ref(4, CPU.sp().value + 0x34).get() != 0) {
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(FUN_80aa538(MEMORY.ref(4, CPU.sp().value + 0x38).get(), 2));
      }

      //LAB_80ae57a
      if((MEMORY.ref(4, CPU.sp().value + 0x30).get() & 0x3) == 0) {
        if((MEMORY.ref(4, CPU.sp().value + 0x30).get() & 0x4) != 0) {
          MEMORY.memcpy(0x60052c0, 0x80af26c, 0x20);
        } else {
          //LAB_80ae59c
          memfill32(0x60052c0, 0x20, 0x44444444);
        }
      }

      //LAB_80ae5a8
      if((MEMORY.ref(4, CPU.sp().value + 0x20).get() & 0x8) != 0) {
        playSound_(0x71);
        r7 = -2;
        break;
      }

      //LAB_80ae5b8
      if((MEMORY.ref(4, CPU.sp().value + 0x20).get() & 0x303) != 0) {
        playSound_(0x71);
        r7 = -1;
        break;
      }

      //LAB_80ae5ce
      if((MEMORY.ref(4, CPU.sp().value + 0x1c).get() & 0x20) != 0) {
        MEMORY.ref(4, r3).decr();
        MEMORY.ref(4, r3).setu(FUN_80aa538(MEMORY.ref(4, r3).get(), MEMORY.ref(4, r11).get()));
        playSound_(0x6f);
        FUN_800352c();
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(1);
        //LAB_80ae5fe
      } else if((MEMORY.ref(4, CPU.sp().value + 0x1c).get() & 0x10) != 0) {
        MEMORY.ref(4, r3).incr();
        playSound_(0x6f);
        FUN_800352c();
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(1);
        MEMORY.ref(4, r3).setu(FUN_80aa538(MEMORY.ref(4, r3).get(), MEMORY.ref(4, r11).get()));
      }

      //LAB_80ae630
      sleep(1);
    } while(true);

    //LAB_80ae638
    setTickCallback(getRunnable(GoldenSun_80a.class, "FUN_80a19a0"), 0xc80);
    final Struct12fc struct = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    struct._ea6.set(1);
    FUN_80a1114(r9.panel_10c, 1);
    sleep(1);
    FUN_80a10d0(r9.panel_10c, 13, 0, 17, 5, 0x2);
    FUN_80a1114(r9.panel_24, 1);
    FUN_80a1114(r9.panel_34, 1);
    drawPanelBackground_(r9.panel_30.deref());
    drawPanelBackground_(r9.panel_28.deref());
    drawPanelBackground_(r9.panel_10.deref());
    struct._ea6.set(0);
    sleep(1);
    CPU.sp().value += 0x54;
    return r7;
  }

  @Method(0x80ae714)
  public static int FUN_80ae714(final int r0, final int r1) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r2 = 0;

    //LAB_80ae734
    for(int r6 = 0; r6 < r8.partyMemberCount_219.get(); r6++) {
      MEMORY.ref(1, r0 + r6).setu(0);

      if(r6 != r1 && FUN_80ae778(r1, r6) == 0) {
        MEMORY.ref(1, r0 + r6).setu(1);
        r2++;
      }

      //LAB_80ae752
    }

    //LAB_80ae760
    return r2;
  }

  @Method(0x80ae778)
  public static int FUN_80ae778(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;
    r7 = CPU.sp().value;
    r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    r5 = r0;
    r0 = r7;
    r6 = r1;
    CPU.r8().value = r3;
    FUN_80ae7fc(r0);
    r3 = MEMORY.ref(1, r7 + r5).getUnsigned();
    r3 = r3 - 0x1;
    MEMORY.ref(1, r7 + r5).setu(r3);
    r3 = MEMORY.ref(1, r7 + r6).getUnsigned();
    r2 = 0x219;
    r3 = r3 + 0x1;
    MEMORY.ref(1, r7 + r6).setu(r3);
    r2 = r2 + CPU.r8().value;
    r3 = 0x1;
    CPU.r10().value = r3;
    r3 = MEMORY.ref(1, r2).getUnsigned();
    r5 = 0x0;
    if((r5 & 0xffff_ffffL) < (r3 & 0xffff_ffffL)) {
      CPU.r12().value = r3;
      r0 = r2;
      CPU.lr().value = CPU.r12().value;

      //LAB_80ae7b6
      do {
        r1 = r5;
        if((r5 & 0xffff_ffffL) < (CPU.r12().value & 0xffff_ffffL)) {
          r6 = MEMORY.ref(1, r0).getUnsigned();
          r4 = r7;

          //LAB_80ae7c0
          do {
            r3 = r1 + 0x1;
            r3 = r3 << 24;
            r1 = r3 >>> 24;
            if((r1 & 0xffff_ffffL) >= (r6 & 0xffff_ffffL)) {
              break;
            }
            r3 = MEMORY.ref(1, r4 + r5).get();
            r2 = MEMORY.ref(1, r4 + r1).get();
            r3 = r3 - r2;
            r3 = r3 + 0x1;
            if((r3 & 0xffff_ffffL) > (0x2 & 0xffff_ffffL)) {
              r3 = 0x0;
              CPU.r10().value = r3;
              break;
            }
          } while(true);
        }

        //LAB_80ae7da
        r3 = r5 + 0x1;
        r3 = r3 << 24;
        r5 = r3 >>> 24;
      } while((r5 & 0xffff_ffffL) < (CPU.lr().value & 0xffff_ffffL));
    }

    //LAB_80ae7e4
    r0 = CPU.r10().value;
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0;
  }

  @Method(0x80ae7fc)
  public static void FUN_80ae7fc(final int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.r10().value = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    r3 = 0x219;
    r3 = r3 + CPU.r10().value;
    r2 = 0x0;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r8().value = r2;
    CPU.r11().value = r0;
    if(CPU.r8().value < r3) {
      r7 = 0x82;
      r3 = 0x1;
      r7 = r7 << 2;
      CPU.r9().value = r3;
      r7 = r7 + CPU.r10().value;

      //LAB_80ae82a
      do {
        final Unit14c unit = getUnit_(MEMORY.ref(2, r7).getUnsigned());
        r4 = 0x0;

        //LAB_80ae836
        for(r6 = 0; r6 < 4; r6++) {
          r5 = unit.djinn_f8.set_10.get(r6).get();
          r1 = 0x0;

          //LAB_80ae83a
          do {
            r2 = CPU.r9().value;
            r2 = r2 << r1;
            r3 = r5;
            r3 = r3 & r2;
            if(r3 != 0 || (unit.djinn_f8.standby_00.get(r6).get() & r2) != 0) {
              //LAB_80ae84e
              r4 = r4 + 0x1;
            }

            //LAB_80ae850
            r1 = r1 + 0x1;
          } while(r1 <= 0x13);
        }

        r3 = CPU.r8().value;
        r2 = CPU.r11().value;
        MEMORY.ref(1, r2 + r3).setu(r4);
        r3 = 0x219;
        r3 = r3 + CPU.r10().value;
        r2 = 0x1;
        r3 = MEMORY.ref(1, r3).getUnsigned();
        CPU.r8().value = CPU.r8().value + r2;
        r7 = r7 + 0x2;
      } while(CPU.r8().value < r3);
    }

    //LAB_80ae874
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ae88c)
  public static void FUN_80ae88c() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    final int slot1 = getFreeVramSlot();
    r5.downArrow_392.set(slot1);
    if(slot1 != -1) {
      allocateSpriteSlot(slot1, 0x80, 0x80aed4c);
    }

    //LAB_80ae8ac
    final int slot2 = getFreeVramSlot();
    r5.upArrow_394.set(slot2);
    if(slot2 != -1) {
      allocateSpriteSlot(slot2, 0x80, 0x80aedcc);
    }
  }

  @Method(0x80ae8dc)
  public static void FUN_80ae8dc() {
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    clearVramSlot(r5.downArrow_392.get());
    clearVramSlot(r5.upArrow_394.get());
  }

  @Method(0x80ae908)
  public static int FUN_80ae908(final int r0, final int vramSlot) {
    CPU.sp().value -= 0xc;
    int r5 = mallocSlotBoard(17, 0x608);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(vramSlot);
    FUN_80153d0(r0, 0, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 1);
    r5 = FUN_80040d0(vramSlot, r5 + 0x400);
    freeSlot(17);
    CPU.sp().value += 0xc;
    return r5;
  }

  @Method(0x80ae958)
  public static void FUN_80ae958(final Panel24 panel, final int x, final int y, final int r3) {
    final int slot = getFreeVramSlot();
    if(slot != 0x60) {
      FUN_80ae908(r3, slot);
      FUN_80150c8(slot, 0x40000000, panel, x, y);
    }

    //LAB_80ae98c
  }

  @Method(0x80ae9f0)
  public static int FUN_80ae9f0(final Panel24 r0, final int r1, final int r2, final int r3) {
    final Menua70 menu = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    final GraphicsStruct1c struct;
    if(r3 == 0) {
      struct = FUN_80150c8(menu.downArrow_392.get(), 0x40000000, r0, r1, r2 - 3);
    } else {
      //LAB_80aea0c
      struct = FUN_80150c8(menu.upArrow_394.get(), 0x40000000, r0, r1, r2 - 4);
    }

    //LAB_80aea16
    if(struct == null) {
      return -1;
    }

    //LAB_80aea2e
    struct._04.set(0);
    struct._05.set(1);
    struct.rotation_0c.set(0);
    return 1;
  }
}
