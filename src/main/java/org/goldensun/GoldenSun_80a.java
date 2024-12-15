package org.goldensun;

import org.goldensun.input.Input;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedShortRef;
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

import static org.goldensun.GoldenSun.FUN_800352c;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8009290;
import static org.goldensun.GoldenSun.FUN_8009298;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.disableMapTickCallbacks;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.enableMapTickCallbacks;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars._2000460;
import static org.goldensun.GoldenSunVars._2000462;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015068;
import static org.goldensun.GoldenSun_801.FUN_8015070;
import static org.goldensun.GoldenSun_801.FUN_8015078;
import static org.goldensun.GoldenSun_801.drawIcon;
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
import static org.goldensun.GoldenSun_801.FUN_8015270;
import static org.goldensun.GoldenSun_801.FUN_8015278;
import static org.goldensun.GoldenSun_801.FUN_8015280;
import static org.goldensun.GoldenSun_801.FUN_8015298;
import static org.goldensun.GoldenSun_801.FUN_80152a8;
import static org.goldensun.GoldenSun_801.FUN_80153e0;
import static org.goldensun.GoldenSun_801.FUN_8015408;
import static org.goldensun.GoldenSun_801.FUN_8015410;
import static org.goldensun.GoldenSun_801.FUN_8015418;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawNumber_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.addItem_;
import static org.goldensun.GoldenSun_807.takeItem_;
import static org.goldensun.GoldenSun_807.breakItem_;
import static org.goldensun.GoldenSun_807.addArtifact_;
import static org.goldensun.GoldenSun_807.FUN_80772c0;
import static org.goldensun.GoldenSun_807.addPp_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.equipItem_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.isEquipped_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a288;
import static org.goldensun.GoldenSun_808.FUN_808a488;
import static org.goldensun.GoldenSun_808.FUN_808a490;
import static org.goldensun.GoldenSun_808.FUN_808a548;
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

  /** {@link GoldenSun_80a#FUN_80a7478} */
  @Method(0x80a1010)
  public static int FUN_80a1010() {
    return (int)MEMORY.call(0x80a7478);
  }

  /** {@link GoldenSun_80a#FUN_80a17c4} */
  @Method(0x80a1038)
  public static void FUN_80a1038(@Nullable final GraphicsStruct1c r0) {
    MEMORY.call(0x80a17c4, r0);
  }

  /** {@link GoldenSun_80a#FUN_80aa56c} */
  @Method(0x80a1040)
  public static int FUN_80a1040() {
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
        FUN_8015270(panel);
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
    final Unit14c chr = getCharOrMonsterData_(charId);
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
        drawIcon(0xbd6, panel, 32, 8);
        iconCount++;
      }

      //LAB_80a11e2
      if(afflictions[2]) {
        drawIcon(0xbd7, panel, 32, 8 + iconCount * 8);
        iconCount++;
      }

      //LAB_80a11f8
      if(afflictions[3]) {
        drawIcon(0xbd8, panel, 32, 8 + iconCount * 8);
        iconCount++;
      }

      //LAB_80a120e
      if(afflictions[4]) {
        drawIcon(0xbd9, panel, 32, 8 + iconCount * 8);
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
        drawIcon(chr.class_129.get() + 0x741, panel, 0, 32);
        FUN_80a153c(chr, panel);
        drawIcon(0xb0e, panel, 0, 64);
        FUN_80150b0(chr.exp_124.get(), 8, panel, 24, 72);
        break;

      case 6:
        drawIcon(chr.class_129.get() + 0x741, panel, 0, 32);
        FUN_80a153c(chr, panel);
        break;

      case 2: // draw equipment differences
      case 3:
        if(isEquipped_(charId, itemId) == 0) {
          drawIcon(0xb21, panel, 0, 48);
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
        drawIcon(r4 + 0x333, panel, 0, 48);

        if(r0_0 != 0) {
          drawIcon(0xb23, panel, 0, 56);
        } else {
          //LAB_80a13ee
          drawIcon(0xb22, panel, 0, 56);
        }

        //LAB_80a13fe
        break;

      case 8: // draw char stats
        drawIcon(0xb1c, panel, 0, 40);
        FUN_80150b0(chr.attack_3c.get(), 3, panel, 64, 40);
        drawIcon(0xb1d, panel, 0, 48);
        FUN_80150b0(chr.defence_3e.get(), 3, panel, 64, 48);
        drawIcon(0xb20, panel, 0, 56);
        FUN_80150b0(chr.agility_40.get(), 3, panel, 64, 56);
        drawIcon(0xb1f, panel, 0, 64);
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
    drawIcon(0xb1c, panel, 0, 32);
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
    drawIcon(0xb1d, panel, 0, 48);
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
    drawIcon(0xb20, panel, 0, 64);
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

    FUN_8003fa4(slot, 0x80, 0x80aea4c);
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
    r0_0._0f.set(0xfe);

    // Retail NPE
    if(!r0._14.get(1).isNull()) {
      r0._14.get(1).deref()._0f.set(0xff);
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

      final Sprite38 r0 = r5.charSpriteIds_114.get(charSlot).derefNullable();
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
    FUN_8015270(r5);
    FUN_8015278(r5);
    if(r2 == -1) {
      drawIcon(r0, r5, 0, 0);
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
        FUN_8015270(r5);
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
    drawIcon(0xb0b, r0, 0x40, 0);
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
    FUN_8015408(0, 0, 30, 20);
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
      r0._180.set(MEMORY.ref(4, CPU.sp().value + 0xc).get() << 10 | MEMORY.ref(4, CPU.sp().value + 0x4).get() & 0x1ff);
      r0._19a.set(MEMORY.ref(2, r5 + 0x174).getUnsigned());
    }

    //LAB_80a25c2
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    FUN_8015278(MEMORY.ref(4, MEMORY.ref(4, r5 + 0x24).get(), Panel24::new));
    r6._ea6.set(0x1);
    FUN_80a34c0();
    FUN_8015408(0, 0, 0x1e, 0x14);
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
          FUN_8015270(r9.panel_2c.deref());
          FUN_80a23c0(r9.panel_2c.deref());

          if(FUN_80a355c(0) == -1) {
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(-1);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(1);
          }

          //LAB_80a2740
          FUN_8015270(r9.panel_2c.deref());
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
              r9.itemCount_218.set(getCharItems(getCharOrMonsterData_(r9._21a.get(0).get()), r9.items_1c8));
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

        case 2:
          FUN_80a345c();
          FUN_80a4e68();
          FUN_80a4e20();
          FUN_8015270(r9.panel_10c.deref());
          FUN_80a51d0();
          drawIcon(0xadb, r9.panel_10c.deref(), 16, 16);

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
          r9.itemCount_218.set(getCharItems(getCharOrMonsterData_(r9._21a.get(0).get()), r9.items_1c8));
          FUN_80a3e28(r9.items_1c8, 0);
          r9._222.set(0x1);
          break;

        case 6:
          FUN_80a4e68();
          FUN_80a4e20();
          FUN_8015270(r9.panel_10c.deref());
          FUN_80a51d0();
          drawIcon(0xadc, r9.panel_10c.deref(), 16, 16);

          CPU.r8().value = 0x4;
          if(FUN_80a38d0(0x1) != -1) {
            break;
          }

          //LAB_80a29dc
          FUN_80a3ef0(r9._21a.get(0).get(), r9._174.get(0).get(), 0, r9._21a.get(0).get());
          CPU.r8().value = 0x9;
          break;

        case 5:
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
          FUN_8015068(r9.panel_34.deref(), 0, 0x48, 0x78, 0x60);
          FUN_8015270(r9.panel_10c.deref());
          r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r0 = FUN_80a524c(r0);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r7 = r9._21a.get(0).get();
            r0 = CPU.addT(r6, 0x1);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r5 = CPU.addT(r0, 0x0);

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
            FUN_8015270(r9.panel_10c.deref());
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
          final Unit14c sp0c = getCharOrMonsterData_(r9._21a.get(0).get());
          final Unit14c sp08 = getCharOrMonsterData_(r9._21a.get(1).get());
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
            FUN_8015270(r9.panel_10c.deref());
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
          r9.itemCount_218.set(getCharItems(getCharOrMonsterData_(r9._21a.get(0).get()), r9.items_1c8));
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
          getCharOrMonsterData_(r9._21a.get(0).get()).items_d8.get(r9._174.get(0).get()).and(~0x200);
          recalcStats_(r9._21a.get(0).get());
          FUN_80772c0(r9._21a.get(0).get());
          CPU.r10().value = 0;
          r9._14.get(0).deref()._05.set(0xd);
          r9.itemCount_218.set(getCharItems(getCharOrMonsterData_(r9._21a.get(0).get()), r9.items_1c8));
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
          FUN_8015270(r9.panel_24.deref());
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
    throw new RuntimeException("Not implemented");
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
    final int r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    FUN_80a195c();
    FUN_80a345c();
    sleep(1);
    final int r2 = MEMORY.ref(4, r5 + 0x17c).get();
    MEMORY.ref(1, r2 + 0x5).setu(0xd);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x10, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x20, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x10c, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x24, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x28, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x2c, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x30, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x34, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x38, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x3c, Pointer.deferred(4, Panel24::new)), 0x1);
    FUN_80a1114(MEMORY.ref(4, r5 + 0x40, Pointer.deferred(4, Panel24::new)), 0x1);
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
    r7.itemCount_218.set(getCharItems(getCharOrMonsterData_(r7.partyMemberIds_208.get(r6).get()), r7.items_1c8));

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
    Unit14c sp10 = getCharOrMonsterData_(charIds.get(charSlot).get());

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
    drawIcon(0xb87, r10.panel_28.derefNullable(), 0, 0);
    drawIcon(0xb88, r10.panel_28.derefNullable(), 0, 0);
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
          sp10 = getCharOrMonsterData_(charIds.get(charSlot).get());
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
    FUN_8015270(menu.panel_20.deref());
    FUN_80a9a5c(menu.panel_20.deref(), charId, 0);
  }

  @Method(0x80a38d0)
  public static int FUN_80a38d0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a3c08)
  public static void FUN_80a3c08() {
    if((_3001e40.get() & 0x1f) == 0) {
      final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

      //LAB_80a3c26
      for(int r7 = 0; r7 < r6.partyMemberCount_219.get(); r7++) {
        if(isEquipped_(r6.partyMemberIds_208.get(r7).get(), r6.abilityId_178.get(0).get() & 0x1ff) != 0) {
          setSpriteAnimation_(r6.charSpriteIds_114.get(r7).deref(), 3);
        } else {
          //LAB_80a3c68
          setSpriteAnimation_(r6.charSpriteIds_114.get(r7).deref(), 1);
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
      setSpriteAnimation_(menu.charSpriteIds_114.get(r5).deref(), 1);
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
  public static void FUN_80a3cf8(final int r0, final int r1) {
    final Panel24 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).offset(0x10c).deref(4).cast(Panel24::new);
    FUN_8015270(r5);
    drawIcon(r1, r5, 0, 0);
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
    final Unit14c charData = getCharOrMonsterData_(charId);
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
  public static int FUN_80a3d9c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
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
    menu.itemCount_218.set(getCharItems(getCharOrMonsterData_(charId), menu.items_1c8));
    FUN_8015270(menu.panel_20.deref());
    FUN_80a1cb0(r1);
    FUN_80a3e28(menu.items_1c8, 0);

    if(getCharItemCount(charId) == 0) {
      drawIcon(0xad7, menu.panel_20.deref(), 8, 24);
    }

    //LAB_80a3eda
  }

  @Method(0x80a3ef0)
  public static void FUN_80a3ef0(final int r0, final int itemSlot, final int r2, final int r3) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    int r10 = 0;
    Unit14c r11 = getCharOrMonsterData_(r0);
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
        r11 = getCharOrMonsterData_(r3);
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
        MEMORY.call(0x3001388, r11, addr, 0x14c);
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
        r11 = getCharOrMonsterData_(r3);
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
    final Unit14c charData = getCharOrMonsterData_(r7);
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
      FUN_8015270(menu.panel_34.deref());
      final Panel24 r5_0 = menu.panel_10c.deref();
      FUN_80a4eb8();
      FUN_8015270(r5_0);
      FUN_8015070(r5_0, 0, 0x3, 0x10, 0x3);
      FUN_80a51d0();
      drawItemActions(actions, r5_0);
      FUN_8015270(menu.panel_2c.deref());
      drawIcon((menu.abilityId_178.get(0).get() & 0x1ff) + 0x75, menu.panel_2c.deref(), 0, 0);
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
    drawIcon(0xb33, panel, 0, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x1).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4612
    drawIcon(0xb34, panel, 32, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x3).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4632
    drawIcon(0xb35, panel, 0, 32);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x5).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4652
    drawIcon(0xb36, panel, 80, 32);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x2).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4672
    drawIcon(0xb37, panel, 80, 24);
    FUN_80150b8(0xf);
    if(MEMORY.ref(1, actions + 0x4).get() == -1) {
      FUN_80150b8(0xe);
    }

    //LAB_80a4692
    drawIcon(0xb38, panel, 32, 32);
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
    final int r8 = getAbility_(item.useAbility_28.get() & 0x3fff);
    if(item.useAbility_28.get() != 0) {
      if(item.type_02.get() == 0) {
        r7 = 0x1;
      } else if(item.useType_0c.get() != 3 && isEquipped_(r0, r6) != 0) {
        //LAB_80a4708
        r7 = 0x1;
      }

      //LAB_80a470a
      if(r7 == 1) {
        int r2 = MEMORY.ref(1, r8 + 0x1).getUnsigned();
        int r3;
        if((r2 & 0x40) != 0) {
          r2 = MEMORY.ref(1, r8 + 0x8).getUnsigned() ^ 0xff;
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

  @Method(0x80a4800)
  public static int FUN_80a4800(final int r0) {
    throw new RuntimeException("Not implemented");
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

  @Method(0x80a4f08)
  public static int FUN_80a4f08(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
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
    FUN_8015090(getCharOrMonsterData_(r7._21a.get(0).get()).name_00.getAddress(), r7.panel_10c.deref(), 16, 0);
    drawIcon((r7.abilityId_178.get(0).get() & 0x1ff) + 0x182, r7.panel_10c.deref(), 16, 8);
  }

  @Method(0x80a524c)
  public static int FUN_80a524c(final int r0) {
    throw new RuntimeException("Not implemented");
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
    FUN_8003fa4(slot1, 0x80, 0x80aebcc);

    final int slot2 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x394).setu(slot2);
    FUN_8003fa4(slot2, 0x80, 0x80aeb4c);
  }

  @Method(0x80a5578)
  public static int FUN_80a5578(final int r0, final int r1) {
    final Menua70 r8 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r7 = getCharItemCount(r8._21a.get(r1).get());
    final Unit14c r11 = getCharOrMonsterData_(r8._21a.get(r1).get());
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
    FUN_8015270(r7.panel_2c.deref());
    sleep(1);
    final int r2_0 = r7.items_1c8.get(MEMORY.ref(4, r2 + 0x18).get()).get();
    if(r2_0 != 0) {
      drawIcon((r2_0 & 0x1ff) + 0x75, r7.panel_2c.deref(), 0, 0);
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
    FUN_8015270(r0);
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
      drawIcon((r3.items_1c8.get(r7 + i).get() & 0x1ff) + 0x182, r3.panel_20.deref(), 0x18, i * 16 + 8);
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
          final Unit14c r9 = getCharOrMonsterData_(r7._21a.get(r11).get());
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
                  drawIcon(0xb89, sp24, 0, 0x58);
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
                r0_0._0f.set(0xfa);
              }

              //LAB_80a58c2
              //LAB_80a58d0
              for(r5 = 0; r5 < r7.partyMemberCount_219.get(); r5++) {
                setSpriteAnimation_(r7.charSpriteIds_114.get(r5).deref(), 1);
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
                  setSpriteAnimation_(r7.charSpriteIds_114.get(r5).deref(), 0x3);
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
                  r7.itemCount_218.set(getCharItems(getCharOrMonsterData_(r7._21a.get(r11).get()), r7.items_1c8));
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
    FUN_8015408(0, 0, 30, 20);
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
      r5._17e.set(MEMORY.ref(4, CPU.sp().value + 0xc).get() << 10 | MEMORY.ref(4, CPU.sp().value + 0x4).get());
    }

    //LAB_80a5c46
    FUN_8015278(r6.panel_24.deref());
    boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea6.set(0x1);
    FUN_80a34c0();
    FUN_8015408(0, 0, 0x1e, 0x14);
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
        case 0:
          r7._174.get(0).set(0);
          FUN_80a3cf8(0, 0xae9);

          if(FUN_80a602c(0) == -1) {
            sp00 = 1;
            r11 = -1;
          }

          //LAB_80a5d2a
          FUN_8015270(r7.panel_2c.deref());
          r5 = 1;
          break;

        case 1:
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

        case 3:
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

        case 2:
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
            addPp_(r7._21a.get(0).get(), -MEMORY.ref(1, getAbility_(r7.abilityId_178.get(0).get() & 0x3fff) + 0x9).getUnsigned());
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
    final int r5 = getAbility_(MEMORY.ref(2, r3).getUnsigned() & 0x3fff);

    if(FUN_808a488(MEMORY.ref(1, r5 + 0xc).getUnsigned()) != 0) {
      return 0;
    }

    //LAB_80a6006
    if(MEMORY.ref(1, r5 + 0x8).getUnsigned() == 0xff) {
      return 2;
    }

    r3 = MEMORY.ref(1, r5).getUnsigned() ^ 0x2;

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
    r7.itemCount_218.set(FUN_80a68ec(getCharOrMonsterData_(r7.partyMemberIds_208.get(r6).get()), r7.items_1c8, 0x2, 0x1c8));
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
    Unit14c sp0c = getCharOrMonsterData_(r0.get(r10).get());

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
        sp0c = getCharOrMonsterData_(r0.get(r10).get());
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
          FUN_8015270(r7.panel_2c.deref());
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
        final int r5 = (byte)FUN_80a68ec(sp0c, MEMORY.ref(4, r6, ArrayRef.of(UnsignedShortRef.class, 0x20, 0x2, UnsignedShortRef::new)), 0x1, r3);
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
    r7.itemCount_218.set(FUN_80a68ec(getCharOrMonsterData_(r0), r7.items_1c8, 0x2, 0x1c8));
    FUN_8015270(r7.panel_20.deref());
    FUN_80a1bdc(0x6c, 0x20, 0x8);
    FUN_80a68a8(r7.items_1c8);

    if(r7.itemCount_218.get() == 0) {
      drawIcon(0xaf2, r7.panel_20.deref(), 0, 0x18);
    }

    //LAB_80a63cc
  }

  @Method(0x80a63e4)
  public static int FUN_80a63e4(final int r0) {
    throw new RuntimeException("Not implemented");
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

    if(_2000460.get() != 0 && _2000462.get() != 0) {
      drawIcon(0xae4, r0, 0, -8);
    } else {
      //LAB_80a664e
      drawIcon(0xae0, r0, 0, -8);
    }

    //LAB_80a665c
    FUN_8015108((_2000460.get() & 0x3ff) + 0x333, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    CPU.cmpT(MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xa);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r6 = 0;
    } else {
      r6 = 1;
    }

    //LAB_80a6698
    if(_2000460.get() != 0) {
      FUN_8015120(_2000460.get() & 0x3ff, 0x4);
      drawIcon(0xae7, r0, 0, 0);

      if(r6 == 0) {
        FUN_8015090(getCharOrMonsterData_(_2000460.get() >>> 10).name_00.getAddress(), r0, 0x50, 0);
      }
    } else {
      //LAB_80a66d6
      drawIcon(0xae5, r0, 0, 0);
    }

    //LAB_80a66e2
    FUN_8015108((_2000462.get() & 0x3ff) + 0x333, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8, CPU.sp().value + 0x4);
    CPU.cmpT(MEMORY.ref(4, CPU.sp().value + 0x8).get(), 0xa);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r6 = 0;
    } else {
      r6 = 1;
    }

    //LAB_80a670a
    if(_2000462.get() != 0) {
      FUN_8015120(_2000462.get() & 0x3ff, 0x4);
      drawIcon(0xae8, r0, 0, 0x8);

      if(r6 == 0) {
        FUN_8015090(getCharOrMonsterData_(_2000462.get() >>> 10).name_00.getAddress(), r0, 0x50, 0x8);
      }

      //LAB_80a6744
      FUN_80150b8(0xf);
    } else {
      //LAB_80a674c
      drawIcon(0xae6, r0, 0, 0x8);
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
  public static int FUN_80a68ec(final Unit14c r0, final ArrayRef<UnsignedShortRef> r1, final int r2, final int r3) {
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
          if(MEMORY.ref(1, getAbility_(r2_0 & 0x3fff) + 0xc).getUnsigned() != 0) {
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
            final int ability = getAbility_(r2_0 & 0x3fff);
            if(r7 == 0 && (MEMORY.ref(1, ability + 0xc).getUnsigned() != 0 || (MEMORY.ref(1, ability + 0x1).getUnsigned() & 0x40) != 0) || r7 == 3 && MEMORY.ref(1, ability + 0xc).getUnsigned() == 0 && (MEMORY.ref(1, ability + 0x1).getUnsigned() & 0x40) == 0) {
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

  @Method(0x80a6ccc)
  public static int FUN_80a6ccc(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a7478)
  public static int FUN_80a7478() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a8b10)
  public static int getAfflictions(final boolean[] out, final boolean showDead, final int charId) {
    final Unit14c charData = getCharOrMonsterData_(charId);

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
    getCharOrMonsterData_(charId);
    FUN_80a9cbc();
    FUN_80a345c();
    drawIcon(0xb24, panel, 0, 0);
    drawIcon(0xb25, panel, 0, 32);
    drawIcon(0xb26, panel, 0, 16);
    drawIcon(0xb27, panel, 0, 48);
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
          drawIcon(r5 + 0x182, r0, 8, 8);
        } else if(r3 == 2) {
          //LAB_80a9b4e
          drawIcon(r5 + 0x182, r0, 8, 56);
        } else if(r3 == 3) {
          //LAB_80a9b5e
          drawIcon(r5 + 0x182, r0, 8, 40);
        } else if(r3 == 4) {
          //LAB_80a9b6e
          drawIcon(r5 + 0x182, r0, 8, 24);
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

  @Method(0x80a9f10)
  public static int FUN_80a9f10(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80aa460)
  public static void FUN_80aa460(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80aa56c)
  public static int FUN_80aa56c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80ae8dc)
  public static void FUN_80ae8dc() {
    final int r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    clearVramSlot(MEMORY.ref(2, r5 + 0x392).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x394).getUnsigned());
  }
}
