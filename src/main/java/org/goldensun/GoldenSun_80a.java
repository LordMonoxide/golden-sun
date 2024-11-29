package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.Pointer;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Panel24;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Struct5c;
import org.goldensun.types.Structccc;

import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8009290;
import static org.goldensun.GoldenSun.FUN_8009298;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.disableMapTickCallbacks;
import static org.goldensun.GoldenSun.enableMapTickCallbacks;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_80150c8;
import static org.goldensun.GoldenSun_801.FUN_8015270;
import static org.goldensun.GoldenSun_801.FUN_8015278;
import static org.goldensun.GoldenSun_801.FUN_80152a8;
import static org.goldensun.GoldenSun_801.FUN_80153e0;
import static org.goldensun.GoldenSun_801.FUN_8015408;
import static org.goldensun.GoldenSun_801.FUN_8015410;
import static org.goldensun.GoldenSun_801.FUN_8015418;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.setFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a288;
import static org.goldensun.GoldenSun_808.FUN_808a548;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80a {
  private GoldenSun_80a() { }

  /** {@link GoldenSun_80a#FUN_80a24d0} */
  @Method(0x80a1000)
  public static int FUN_80a1000() {
    return (int)MEMORY.call(0x80a24d0);
  }

  /** {@link GoldenSun_80a#FUN_80a5b94} */
  @Method(0x80a1008)
  public static int FUN_80a1008() {
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
    final int r4 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x8500029c);
    CPU.sp().value += 0x4;

    MEMORY.ref(1, r4 + 0x1c).setu(0xff);
    MEMORY.ref(1, r4 + 0x1e).setu(0x1);
    MEMORY.ref(1, r4 + 0x1f).setu(0x1);
    MEMORY.ref(1, r4 + 0x112).setu(0x1);
    MEMORY.ref(1, r4 + 0x113).setu(0x1);
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
  public static void FUN_80a17c4(final int r0) {
    if(r0 != 0) {
      MEMORY.ref(1, r0 + 0x5).setu(0x1);
      MEMORY.ref(2, r0 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r0 + 0x6).getUnsigned() & 0x1ff);
      MEMORY.ref(1, r0 + 0x14).setu(MEMORY.ref(2, r0 + 0x8).getUnsigned());
      MEMORY.ref(1, r0 + 0x17).and(~0x3e);
      MEMORY.ref(1, r0 + 0x15).and(~0x3);
    }

    //LAB_80a17f6
  }

  @Method(0x80a1814)
  public static Panel24 FUN_80a1814(final int r0) {
    MEMORY.ref(4, r0 + 0x10).setu(0);
    FUN_80a10d0(MEMORY.ref(4, r0 + 0x10, Pointer.deferred(4, Panel24::new)), 0, 0, 0xd, 0x5, 0x2);
    final Panel24 r6 = MEMORY.ref(4, r0 + 0x10).deref(4).cast(Panel24::new);
    final GraphicsStruct1c r0_0 = FUN_80a1778(r6, -8, 0xb);
    r0_0._05.set(0xd);
    MEMORY.ref(1, r0 + 0x1c).setu(0xff);
    MEMORY.ref(1, r0 + 0x1d).setu(0);
    MEMORY.ref(4, r0 + 0x14).setu(r0_0.getAddress());
    r0_0._0f.set(0xfe);
    final int r2 = MEMORY.ref(4, r0 + 0x18).get();
    MEMORY.ref(1, r2 + 0xf).setu(-1);
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
  public static int FUN_80a24d0() {
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
    final int r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    CPU.sp().value -= 0x4;
    final Panel24 r0 = FUN_80a1814(r7);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    FUN_80a1870(r0, 0x2, 0x2, 0x8);

    //LAB_80a337a
    for(int r2 = 0; r2 < 4; r2++) {
      MEMORY.ref(2, r7 + 0x144 + r2 * 0x2).setu(0x1e);
    }

    MEMORY.ref(4, r7 + 0x28).setu(0);
    MEMORY.ref(4, r7 + 0x24).setu(0);
    final Panel24 panel = addPanel_(0, 17, 30, 3, 0x2);
    MEMORY.ref(4, r7 + 0x2c).setu(panel.getAddress());
    MEMORY.ref(4, r7 + 0x20).setu(0);
    MEMORY.ref(1, r7 + 0x110).setu(0);
    MEMORY.ref(1, r7 + 0x111).setu(0);
    MEMORY.ref(1, r7 + 0x112).setu(0x8);
    MEMORY.ref(1, r7 + 0x113).setu(0x2);
    CPU.sp().value += 0x4;
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
  public static int FUN_80a5b94() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80a7478)
  public static int FUN_80a7478() {
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
