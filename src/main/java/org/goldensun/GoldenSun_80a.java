package org.goldensun;

import org.goldensun.input.Input;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Menua70;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Struct5c;
import org.goldensun.types.Structccc;

import javax.annotation.Nullable;

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
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars._2000460;
import static org.goldensun.GoldenSunVars._2000462;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015068;
import static org.goldensun.GoldenSun_801.FUN_8015080;
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
import static org.goldensun.GoldenSun_801.FUN_8015298;
import static org.goldensun.GoldenSun_801.FUN_80152a8;
import static org.goldensun.GoldenSun_801.FUN_80153e0;
import static org.goldensun.GoldenSun_801.FUN_8015408;
import static org.goldensun.GoldenSun_801.FUN_8015410;
import static org.goldensun.GoldenSun_801.FUN_8015418;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawNumber_;
import static org.goldensun.GoldenSun_807.FUN_8077010;
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
  public static void FUN_80a1038(final int r0) {
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
  public static int FUN_80a10d0(final Pointer<Panel24> r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    final Panel24 panel = r0.derefNullable();
    if(panel != null) {
      if((a5 & 0x100) == 0) {
        //LAB_80a10ee
        FUN_8015270(panel);
      }
      return 0;
    }

    //LAB_80a10f6
    r0.set(addPanel_(r1, r2, r3, a4, a5 & 0xff));

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
  public static void FUN_80a112c(final Panel24 r0, final int r1, final int r2, final int r3) {
    int r5;
    int r6;

    CPU.sp().value -= 0x24;

    int sp14 = 0;
    final Menua70 r10 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r8 = getCharOrMonsterData_(r1);
    final int sp0c = MEMORY.ref(2, r8 + 0xd8 + r2 * 0x2).getUnsigned();
    final int sp10 = getItem_(sp0c & 0x1ff);

    if((r3 & 0x100) == 0) {
      sp14 =FUN_80a10d0(r10.panel_24, 0, 0x5, 0xd, 0xc, 0x102);
    }

    //LAB_80a118e
    final Panel24 r7 = r10.panel_24.deref();
    if((r3 & 0x100) == 0) {
      if(sp14 == 0) {
        sleep(1);
        FUN_8015068(r7, 0, 0, 0x58, 0x20);
      }

      //LAB_80a11b4
      FUN_8015090(r8, r7, 32, 0);

      r6 = CPU.sp().value + 0x1c;
      FUN_80a8b10(r6, 0x1, r1);

      r5 = 0;
      if(MEMORY.ref(1, r6 + 0x1).getUnsigned() != 0) {
        FUN_8015080(0xbd6, r7, 32, 8);
        r5++;
      }

      //LAB_80a11e2
      if(MEMORY.ref(1, r6 + 0x2).getUnsigned() != 0) {
        FUN_8015080(0xbd7, r7, 32, 8 + r5 * 8);
        r5++;
      }

      //LAB_80a11f8
      if(MEMORY.ref(1, r6 + 0x3).getUnsigned() != 0) {
        FUN_8015080(0xbd8, r7, 32, 8 + r5 * 8);
        r5++;
      }

      //LAB_80a120e
      if(MEMORY.ref(1, r6 + 0x4).getUnsigned() != 0) {
        FUN_8015080(0xbd9, r7, 32, 8 + r5 * 8);
        r5++;
      }

      //LAB_80a1224
      if(r5 <= 1) {
        FUN_8015090(0x80af20c, r7, 0x28, 0x10);
        FUN_80150b0(MEMORY.ref(1, r8 + 0xf).getUnsigned(), 0x4, r7, 0x38, 0x10);
      }
    }

    //LAB_80a1248
    if(sp14 == 0) {
      sleep(1);
      FUN_8015068(r7, 0, 0x20, 0x58, 0x50);
    }

    //LAB_80a1266
    FUN_8015278(r7);

    if((r3 & 0x100) == 0) {
      r10._17c.set(FUN_80150d8(r1, 0, 0, r7, 0, 0));
    }

    //LAB_80a1290
    final int r4;
    switch(r3 & 0xff) {
      case 0:
        FUN_8015080(MEMORY.ref(1, r8 + 0x129).getUnsigned() + 0x741, r7, 0, 0x20);
        FUN_80a153c(r8, r7);
        FUN_8015080(0xb0e, r7, 0, 0x40);
        FUN_80150b0(MEMORY.ref(4, r8 + 0x124).get(), 0x8, r7, 0x18, 0x48);
        break;

      case 6:
        FUN_8015080(MEMORY.ref(1, r8 + 0x129).getUnsigned() + 0x741, r7, 0, 0x20);
        FUN_80a153c(r8, r7);
        break;

      case 2:
      case 3:
        if(isEquipped_(r1, sp0c) == 0) {
          FUN_8015080(0xb21, r7, 0, 0x30);
        } else {
          //LAB_80a1346
          r5 = 0x14c;
          r6 = mallocChip(r5);
          MEMORY.call(0x3001388, r6, r8, r5); // memcpy

          if(r10._25c.get() != 0) {
            MEMORY.ref(2, r8 + 0xd8 + r2 * 0x2).and(0xfdff);
          } else {
            //LAB_80a137e
            equipItem_(r1, r2);
          }

          //LAB_80a1386
          FUN_8077010(r1);
          FUN_80a15f0(r8, r6, r7);
          MEMORY.call(0x3001388, r8, r6, 0x14c); // memcpy
          setMallocAddress(r6);
        }
        break;

      case 4:
        r4 = MEMORY.ref(2, sp10 + 0x28).getUnsigned();
        int i = 0;
        int r0_0 = 1;

        //LAB_80a13c0
        while((MEMORY.ref(2, r8 + 0x58 + i * 0x4).getUnsigned() & 0x3fff) != r4) {
          i++;
          if(i > 0x1f) {
            r0_0 = 0;
            break;
          }
        }

        //LAB_80a13d8
        FUN_8015080(r4 + 0x333, r7, 0, 0x30);

        if(r0_0 != 0) {
          FUN_8015080(0xb23, r7, 0, 0x38);
        } else {
          //LAB_80a13ee
          FUN_8015080(0xb22, r7, 0, 0x38);
        }

        //LAB_80a13fe
        break;

      case 8:
        FUN_8015080(0xb1c, r7, 0, 0x28);
        FUN_80150b0(MEMORY.ref(2, r8 + 0x3c).getUnsigned(), 0x3, r7, 0x40, 0x28);
        FUN_8015080(0xb1c, r7, 0, 0x30);
        FUN_80150b0(MEMORY.ref(2, r8 + 0x3e).getUnsigned(), 0x3, r7, 0x40, 0x30);
        FUN_8015080(0xb1c, r7, 0, 0x38);
        FUN_80150b0(MEMORY.ref(2, r8 + 0x40).getUnsigned(), 0x3, r7, 0x40, 0x38);
        FUN_8015080(0xb1f, r7, 0, 0x40);
        FUN_80150b0(MEMORY.ref(1, r8 + 0x42).getUnsigned(), 0x3, r7, 0x40, 0x40);
        break;
    }

    //LAB_80a1490
    CPU.sp().value += 0x24;
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
  public static void FUN_80a153c(final int r0, final Panel24 r1) {
    FUN_8015090(0x80af210, r1, 0, 0x28);
    FUN_8015098(0x80af214, r1, 0x30, 0x28);
    FUN_80a14f0(MEMORY.ref(2, r0 + 0x34).get(), r1, 0x58, 0x28);

    final int r5 = MEMORY.ref(2, r0 + 0x38).get();
    if(r5 < MEMORY.ref(2, r0 + 0x34).get() / 4) {
      FUN_80150b8(0x4);
    }

    //LAB_80a1584
    if(r5 == 0) {
      FUN_80150b8(0x2);
    }

    //LAB_80a158e
    FUN_80a14f0(r5, r1, 0x30, 0x28);
    FUN_80150b8(0xf);
    FUN_8015090(0x80af218, r1, 0, 0x30);
    FUN_8015098(0x80af214, r1, 0x30, 0x30);
    FUN_80a14f0(MEMORY.ref(2, r0 + 0x3a).get(), r1, 0x30, 0x30);
    FUN_80a14f0(MEMORY.ref(2, r0 + 0x36).get(), r1, 0x58, 0x30);
  }

  @Method(0x80a15f0)
  public static void FUN_80a15f0(final int r0, final int r1, final Panel24 r2) {
    throw new RuntimeException("Not implemented");
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

      final Sprite38 r0 = r5._114.get(charSlot).derefNullable();
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
  public static void FUN_80a1a40(final int r0, final int r1) {
    final int r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    final int r6 = MEMORY.ref(4, r5 + 0x10).get();
    final int r4 = MEMORY.ref(4, r5 + 0x14).get();
    final int r2 = MEMORY.ref(1, 0x80af294 + (_3001e40.get() >>> 1 & 0x7)).getUnsigned() + r0 + MEMORY.ref(2, r6 + 0xc).getUnsigned() * 0x8 + 0x8;
    final int r3 = MEMORY.ref(1, 0x80af29d + (_3001e40.get() >>> 1 & 0x7)).getUnsigned() + r1 + MEMORY.ref(2, r6 + 0xe).getUnsigned() * 0x8 + 0x8;
    MEMORY.ref(2, r4 + 0x6).setu(r2);
    MEMORY.ref(2, r4 + 0x16).and(~0x1ff).or(r2 & 0x1ff);
    MEMORY.ref(2, r4 + 0x8).setu(r3);
    MEMORY.ref(1, r4 + 0x14).setu(r3 & 0xffff);
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

  @Method(0x80a1d08)
  public static void FUN_80a1d08(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
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

  @Method(0x80a23c0)
  public static void FUN_80a23c0(final Panel24 r0) {
    drawNumber_(MEMORY.ref(4, 0x2000250).get(), 7, r0, 8, 0);
    FUN_8015080(0xb0b, r0, 0x40, 0);
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
  public static int FUN_80a2680(final int r0, final int r1, final int r2) {
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
    final int r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get() + 0x48;

    //LAB_80a3468
    for(int r1 = 0; r1 < 0x20; r1++) {
      final int r2 = MEMORY.ref(4, r3 + r1 * 0x4).get();

      if(r2 != 0) {
        MEMORY.ref(1, r2 + 0x5).setu(0xd);
      }

      //LAB_80a3470
    }
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

  @Method(0x80a3cf8)
  public static void FUN_80a3cf8(final int r0, final int r1) {
    final Panel24 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).offset(0x10c).deref(4).cast(Panel24::new);
    FUN_8015270(r5);
    FUN_8015080(r1, r5, 0, 0);
  }

  @Method(0x80a3d24)
  public static void FUN_80a3d24(final ArrayRef<UnsignedShortRef> r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);

    //LAB_80a3d3a
    for(int r2 = 0; r2 < 32; r2++) {
      if(r0.get(r2).get() == 0) {
        FUN_80a17c4(r7._48.get(r2).deref());
        r7._48.get(r2).deref()._05.set(0xd);
      }

      //LAB_80a3d52
    }
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
      getAbility_(r6.abilityId_178.get() & 0x3fff);
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
          r7._174.set(0);
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
          r0 = getCharOrMonsterData_(r7._21a.get());
          r3 = r7._218.get();
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
            FUN_80a112c(r7.panel_24.deref(), r7._21a.get(), 0, 0);
            r1 = FUN_80a6ccc(0);
            r5 = 0;
            if(r1 != -1) {
              //LAB_80a5db0
              r3 = r7._268.get();
              r5 = 2;
              if(r3 != 0) {
                //LAB_80a5dc0
                if(r3 == 1) {
                  FUN_80a65e4(r7._21a.get(), r1, 0);
                  FUN_8015278(r7.panel_2c.deref());
                  FUN_80a1d08(0xae2, -1, -1);
                } else {
                  //LAB_80a5dde
                  FUN_80a65e4(r7._21a.get(), r1, 0x1);
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
            r7._21b.set(0x9);
            r5 = 4;
          } else {
            //LAB_80a5e70
            sp00 = 1;
            r11 = 0x1;
            MEMORY.ref(4, sp08).setu(r7._21a.get());
            MEMORY.ref(4, r2).setu(r7.abilityId_178.get() & 0x3fff);
          }
          break;

        case 4:
          r11 = FUN_80a9f10(r7.abilityId_178.get(), r7._21a.get(), r7._21b.get(), 0);
          if(r7._21b.get() == 9) {
            r7._21b.set(r7._21a.get());
            r10 = 9;
          } else {
            r10 = 0;
          }

          //LAB_80a5ec2
          if(r11 != -1) {
            addPp_(r7._21a.get(), -MEMORY.ref(1, getAbility_(r7.abilityId_178.get() & 0x3fff) + 0x9).getUnsigned());
          }

          //LAB_80a5ee4
          FUN_8077010(r7._21a.get());
          if(r11 != -1) {
            FUN_80a112c(r7.panel_24.deref(), r7._21b.get(), 0, 0);
            FUN_80aa460(r7.abilityId_178.get() & 0x3fff);
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
    r7._218.set(FUN_80a68ec(getCharOrMonsterData_(r7.partyMemberIds_208.get(r6).get()), r7._1c8, 0x2, 0x1c8));
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
    int sp0c = getCharOrMonsterData_(r0.get(r10).get());

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
        FUN_80a112c(r7.panel_24.derefNullable(), r0.get(r10).get(), 0, 0);
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
        if(r7._218.get() != 0) {
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
    r7._21a.set(r0.get(r10).get());
    return sp10;
  }

  @Method(0x80a6384)
  public static void FUN_80a6384(final int r0) {
    final Menua70 r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r7._218.set(FUN_80a68ec(getCharOrMonsterData_(r0), r7._1c8, 0x2, 0x1c8));
    FUN_8015270(r7.panel_20.deref());
    FUN_80a1bdc(0x6c, 0x20, 0x8);
    FUN_80a68a8(r7._1c8);

    if(r7._218.get() == 0) {
      FUN_8015080(0xaf2, r7.panel_20.deref(), 0, 0x18);
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
      FUN_8015080(0xae4, r0, 0, -8);
    } else {
      //LAB_80a664e
      FUN_8015080(0xae0, r0, 0, -8);
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
      FUN_8015080(0xae7, r0, 0, 0);

      if(r6 == 0) {
        FUN_8015090(getCharOrMonsterData_(_2000460.get() >>> 10), r0, 0x50, 0);
      }
    } else {
      //LAB_80a66d6
      FUN_8015080(0xae5, r0, 0, 0);
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
      FUN_8015080(0xae8, r0, 0, 0x8);

      if(r6 == 0) {
        FUN_8015090(getCharOrMonsterData_(_2000462.get() >>> 10), r0, 0x50, 0x8);
      }

      //LAB_80a6744
      FUN_80150b8(0xf);
    } else {
      //LAB_80a674c
      FUN_8015080(0xae6, r0, 0, 0x8);
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
  public static int FUN_80a68ec(final int r0, final ArrayRef<UnsignedShortRef> r1, final int r2, final int r3) {
    final int r8 = (r2 ^ 0x2) != 0 ? 4 : 3;

    //LAB_80a691a
    for(int i = 0; i < 0x20; i++) {
      r1.get(i).set(0);
    }

    int r4 = 0;
    if(r2 == 1) {
      //LAB_80a693c
      for(int i = 0; i < 0x20; i++) {
        final int r2_0 = MEMORY.ref(2, r0 + 0x58 + i * 0x4).getUnsigned();
        if(r2_0 != 0) {
          if(MEMORY.ref(1, getAbility_(r2_0 & 0x3fff) + 0xc).getUnsigned() != 0) {
            r1.get(r4).set(MEMORY.ref(2, r0 + 0x58 + i * 0x4).getUnsigned());
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
        for(int i = 0; i < 0x20; i++) {
          final int r2_0 = MEMORY.ref(2, r0 + 0x58 + i * 0x4).getUnsigned();
          if(r2_0 != 0) {
            final int ability = getAbility_(r2_0 & 0x3fff);
            if(r7 == 0 && (MEMORY.ref(1, ability + 0xc).getUnsigned() != 0 || (MEMORY.ref(1, ability + 0x1).getUnsigned() & 0x40) != 0) || r7 == 3 && MEMORY.ref(1, ability + 0xc).getUnsigned() == 0 && (MEMORY.ref(1, ability + 0x1).getUnsigned() & 0x40) == 0) {
              //LAB_80a69d4
              r1.get(r4).set(MEMORY.ref(2, r0 + 0x58 + i * 0x4).getUnsigned());
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
  public static int FUN_80a8b10(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;

    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r1, 0x0);
    r0 = getCharOrMonsterData_(r2);
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r5, 0x4);
    CPU.r12().value = r5;

    //LAB_80a8b24
    do {
      MEMORY.ref(1, r3).setu(0);
      r3 = CPU.subT(r3, 0x1);
      CPU.cmpT(r3, CPU.r12().value);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r3 = MEMORY.ref(2, r2 + 0x38).get();
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r6, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        MEMORY.ref(1, r5).setu(r6);
        r0 = CPU.movT(0, 0x1);
      }
    }

    //LAB_80a8b3e
    r3 = MEMORY.ref(1, r2 + 0x131).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        MEMORY.ref(1, r5 + 0x1).setu(r3);
      } else {
        //LAB_80a8b54
        r3 = CPU.movT(0, 0x1);
        MEMORY.ref(1, r5 + 0x2).setu(r3);
      }

      //LAB_80a8b58
      r0 = CPU.addT(r0, 0x1);
    }

    //LAB_80a8b5a
    r1 = CPU.movT(0, 0x98);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r2, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r5 + 0x3).setu(r3);
      r0 = CPU.addT(r0, 0x1);
    }

    //LAB_80a8b70
    r1 = CPU.movT(0, 0xa0);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r2, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r5 + 0x4).setu(r3);
      r0 = CPU.addT(r0, 0x1);
    }

    //LAB_80a8b82
    return r0;
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
