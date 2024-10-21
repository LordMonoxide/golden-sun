package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.IntRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_800300c} from 8000770 */
public final class CopiedSegment8000770 {
  private CopiedSegment8000770() { }

  public static final ArrayRef<Pointer<RunnableRef>> intHandlers_30000e0 = MEMORY.ref(4, 0x30000e0, ArrayRef.of(Pointer.classFor(RunnableRef.class), 14, 0x4, Pointer.deferred(4, RunnableRef::new)));

  @Method(0x3000000)
  public static void FUN_3000000() {
    final int intEnable = INTERRUPTS.INT_ENABLE.getUnsigned();
    final int intFlags = INTERRUPTS.INT_FLAGS.getUnsigned();
    final int oldSpsr = CPU.spsr().get();
    final int oldMasterEnable = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();

    INTERRUPTS.INT_MASTER_ENABLE.setu(0x1);

    final RunnableRef handler;
    final int currentInterrupts = intFlags & intEnable;
    final int handledInterrupt;
    if((currentInterrupts & 0x2) != 0) { // LCD HBLANK
      handledInterrupt = 0x2;
      handler = intHandlers_30000e0.get(1).deref();
    } else if((currentInterrupts & 0x1) != 0) { // LCD VBLANK
      handledInterrupt = 0x1;
      handler = intHandlers_30000e0.get(0).deref();
    } else if((currentInterrupts & 0x4) != 0) { // LCD VCOUNT
      handledInterrupt = 0x4;
      handler = intHandlers_30000e0.get(2).deref();
    } else if((currentInterrupts & 0x40) != 0) { // Timer 3 overflow
      handledInterrupt = 0x40;
      handler = intHandlers_30000e0.get(6).deref();
    } else if((currentInterrupts & 0x80) != 0) { // Serial comm
      handledInterrupt = 0x80;
      handler = intHandlers_30000e0.get(7).deref();
    } else if((currentInterrupts & 0x10) != 0) { // Timer 1 overflow
      handledInterrupt = 0x10;
      handler = intHandlers_30000e0.get(4).deref();
    } else if((currentInterrupts & 0x20) != 0) { // Timer 2 overflow
      handledInterrupt = 0x20;
      handler = intHandlers_30000e0.get(5).deref();
    } else if((currentInterrupts & 0x1000) != 0) { // Keypad
      handledInterrupt = 0x1000;
      handler = intHandlers_30000e0.get(12).deref();
    } else {
      handledInterrupt = currentInterrupts & 0x2000; // Gamepak
      handler = intHandlers_30000e0.get(13).deref();
    }

    //LAB_3000088
    INTERRUPTS.INT_FLAGS.setu(handledInterrupt);
    INTERRUPTS.INT_ENABLE.setu(intEnable & ~handledInterrupt & 0x20c0);
    CPU.cpsr().msr(CPU.cpsr().get() & ~0xdf | 0x1f, true, false, false, true);
    handler.run();
    CPU.cpsr().msr(CPU.cpsr().get() & ~0xdf | 0x92, true, false, false, true);

    INTERRUPTS.INT_ENABLE.setu(intEnable);
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldMasterEnable);
    CPU.spsr().msr(oldSpsr, true, false, false, true);
  }

  /** Multiplies r0 and r1 and returns the middle 16-48 bits (y tho) (jumps back to r12) */
  @Deprecated
  @Method(0x3000118)
  public static int FUN_3000118(final int r0, final int r1) {
    final long result3000118 = (long)r1 * r0;
    final int lo = (int)result3000118;
    final int hi = (int)(result3000118 >>> 32);
    return hi << 16 | lo >>> 16;
  }

  @Method(0x3000164)
  public static void memzero(final int r0, final int r1) {
    MEMORY.memfill(r0, r1, 0);
  }

  @Method(0x3000168)
  public static void memfill32(final int r0, final int r1, final int r2) {
    for(int i = 0; i < r1; i += 0x4) {
      MEMORY.set(r0 + i, 0x4, r2);
    }
  }

  @Method(0x3000380)
  public static int FUN_3000380(int r0, int r1) {
    int r2;
    CPU.r12().value = r0 ^ r1;

    r2 = CPU.movA(r0, r1);
    if(CPU.cpsr().getNegative()) { // negative
      r2 = -r2;
    }

    r1 = CPU.movA(r0, r0);
    if(CPU.cpsr().getNegative()) { // negative
      r1 = -r1;
    }
    CPU.setCFlag((CPU.r12().value & 0x8000_0000) != 0);
    r0 = CPU.movA(r0, 0);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      final IntRef r0_0 = new IntRef().set(r0);
      final IntRef r1_0 = new IntRef().set(r1);
      FUN_30003fc(r0_0, r1_0, r2);
      r0 = r0_0.get();
      r1 = r1_0.get();
    }

    final IntRef r0_0 = new IntRef().set(r0);
    final IntRef r1_0 = new IntRef().set(r1);
    FUN_30003fc(r0_0, r1_0, r2);
    r0 = r0_0.get();
    r1 = r1_0.get();
    r0 = -r0;
    return r0;
  }

  @Method(0x30003ac)
  public static int FUN_30003ac(int r0, int r1) {
    int r2;

    final int address30003ac = CPU.sp().value - 0x4;
    CPU.sp().value = address30003ac;
    MEMORY.ref(4, address30003ac).setu(CPU.lr().value);
    CPU.r12().value = r0 ^ (r1);

    r2 = CPU.movA(r0, r1);
    if(CPU.cpsr().getNegative()) { // negative
      r2 = -r2;
    }

    r1 = CPU.movA(r0, r0);
    if(CPU.cpsr().getNegative()) { // negative
      r1 = -r1;
    }
    r0 = 0x0;

    final IntRef r0ref = new IntRef().set(r0);
    final IntRef r1ref = new IntRef().set(r1);
    FUN_30003fc(r0ref, r1ref, r2);
    r1 = r1ref.get();
    r0 = r1;

    CPU.r12().value = CPU.movA(r0, CPU.r12().value);
    if(CPU.cpsr().getNegative()) { // negative
      r0 = -r0;
    }
    int address30003d8 = CPU.sp().value;
    CPU.lr().value = MEMORY.ref(4, address30003d8).getUnsigned();
    address30003d8 += 0x4;
    CPU.sp().value = address30003d8;
    return r0;
  }

  @Method(0x30003e0)
  public static int FUN_30003e0(final int r0, final int r1) {
    final IntRef r0ref = new IntRef().set(0);
    final IntRef r1ref = new IntRef().set(r0);
    FUN_30003fc(r0ref, r1ref, r1);
    return r1ref.get();
  }

  @Method(0x30003f0)
  public static int FUN_30003f0(final int r0, final int r1) {
    final IntRef r0ref = new IntRef().set(0);
    final IntRef r1ref = new IntRef().set(r0);
    FUN_30003fc(r0ref, r1ref, r1);
    return r0ref.get();
  }

  @Method(0x30003fc)
  public static void FUN_30003fc(final IntRef r0_0, final IntRef r1_0, final int r2) {
    int r0 = r0_0.get();
    int r1 = r1_0.get();

    CPU.rsbA(r2, r1 >>> 28);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 31);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x80000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 31);
      }
      CPU.rsbA(r2, r1 >>> 30);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x40000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 30);
      }
      CPU.rsbA(r2, r1 >>> 29);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x20000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 29);
      }
      CPU.rsbA(r2, r1 >>> 28);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x10000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 28);
      }
    }

    //LAB_8000ba4
    CPU.rsbA(r2, r1 >>> 24);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 27);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x8000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 27);
      }
      CPU.rsbA(r2, r1 >>> 26);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x4000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 26);
      }
      CPU.rsbA(r2, r1 >>> 25);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x2000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 25);
      }
      CPU.rsbA(r2, r1 >>> 24);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x1000000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 24);
      }
    }

    //LAB_8000bdc
    CPU.rsbA(r2, r1 >>> 20);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 23);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x800000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 23);
      }
      CPU.rsbA(r2, r1 >>> 22);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x400000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 22);
      }
      CPU.rsbA(r2, r1 >>> 21);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x200000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 21);
      }
      CPU.rsbA(r2, r1 >>> 20);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x100000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 20);
      }
    }

    //LAB_8000c14
    CPU.rsbA(r2, r1 >>> 16);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 19);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x80000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 19);
      }
      CPU.rsbA(r2, r1 >>> 18);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x40000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 18);
      }
      CPU.rsbA(r2, r1 >>> 17);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x20000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 17);
      }
      CPU.rsbA(r2, r1 >>> 16);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x10000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 16);
      }
    }

    //LAB_8000c4c
    CPU.rsbA(r2, r1 >>> 12);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 15);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x8000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 15);
      }
      CPU.rsbA(r2, r1 >>> 14);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x4000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 14);
      }
      CPU.rsbA(r2, r1 >>> 13);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x2000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 13);
      }
      CPU.rsbA(r2, r1 >>> 12);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x1000;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 12);
      }
    }

    //LAB_8000c84
    CPU.rsbA(r2, r1 >>> 8);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 11);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x800;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 11);
      }
      CPU.rsbA(r2, r1 >>> 10);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x400;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 10);
      }
      CPU.rsbA(r2, r1 >>> 9);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x200;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 9);
      }
      CPU.rsbA(r2, r1 >>> 8);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x100;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 8);
      }
    }

    //LAB_8000cbc
    CPU.rsbA(r2, r1 >>> 4);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 7);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x80;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 7);
      }
      CPU.rsbA(r2, r1 >>> 6);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x40;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 6);
      }
      CPU.rsbA(r2, r1 >>> 5);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x20;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 5);
      }
      CPU.rsbA(r2, r1 >>> 4);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x10;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 4);
      }
    }

    //LAB_8000cf4
    CPU.rsbA(r2, r1);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      CPU.rsbA(r2, r1 >>> 3);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x8;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 3);
      }
      CPU.rsbA(r2, r1 >>> 2);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x4;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 2);
      }
      CPU.rsbA(r2, r1 >>> 1);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x2;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - (r2 << 1);
      }
      CPU.rsbA(r2, r1);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = r0 | 0x1;
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r1 = r1 - r2;
      }
    }

    r0_0.set(r0);
    r1_0.set(r1);
  }

  /** This code is absolutely fucked, probably handwritten, has a large chunk of what looks like ARM in the middle of the thumb but is broken. I'm just gonna delete most of it and hope we don't need it. */
  @Method(0x3000658)
  public static void FUN_3000658(int r0, final int r1unused, final int r2unused, final int r3unused, int r4) {
    int r3;
    final int r5;
    int r6;

    //LAB_3000658
    do {
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
      r3 = MEMORY.ref(4, r4 + 0x24).get();
      r6 = MEMORY.ref(1, r4).getUnsigned();
      r0 = CPU.movT(0, 0xc7);
      r0 = CPU.tstT(r0, r6);
      if(!CPU.cpsr().getZero()) { // !=
        throw new RuntimeException("?????????????????????????????????");
      }

      //LAB_3000adc
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r0 = CPU.subT(r0, 0x1);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        break;
      }
      r4 = CPU.addT(r4, 0x40);
    } while(true);

    //LAB_3000ae6
    r5 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    r0 = 0x3000b60;
    MEMORY.call(r0, 0, 0, 0, 0, 0, r5);
  }

  @Method(0x3000aec)
  public static void FUN_3000aec(final IntRef r6) {
    int r7;
    r7 = Integer.rotateRight(r6.get(), 16);
    r7 = CPU.addA(r7, r7);
    if(CPU.cpsr().getOverflow()) { // signed overflow
      r6.or(0x4000);
      r6.and(~0x3fc0);
      if(CPU.cpsr().getNegative()) { // negative
        r6.sub(0x40);
      }
    }

    //LAB_3000b04
    r7 = CPU.addA(r6.get(), r6.get());
    if(CPU.cpsr().getOverflow()) { // signed overflow
      r6.or(0x40000000);
      r6.and(~0x3fc00000);
      if(CPU.cpsr().getNegative()) { // negative
        r6.sub(0x400000);
      }
    }
  }

  @Method(0x3000b60)
  public static void FUN_3000b60(final int r0unused, final int r1unused, final int r2unused, final int r3unused, final int r4unused, int r5) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r6;
    int r7;

    r0 = 0x3000b68 + 0x290;
    CPU.r9().value = 0x160;
    CPU.r8().value = 0xff000000;
    CPU.r8().value = CPU.r8().value | CPU.r8().value >>> 16;
    CPU.r10().value = 0x80000000;
    CPU.lr().value = CPU.r10().value | CPU.r10().value >>> 16;

    //LAB_3000b78
    do {
      int address3000b78 = r0;
      r1 = MEMORY.ref(4, address3000b78).getUnsigned();
      address3000b78 += 0x4;
      r2 = MEMORY.ref(4, address3000b78).getUnsigned();
      address3000b78 += 0x4;
      r3 = MEMORY.ref(4, address3000b78).getUnsigned();
      address3000b78 += 0x4;
      r4 = MEMORY.ref(4, address3000b78).getUnsigned();
      address3000b78 += 0x4;
      r0 = address3000b78;
      r6 = r1 ^ r1 << 1;

      r6 = CPU.andA(r6, CPU.lr().value);
      if(CPU.cpsr().getZero()) { // ==
        r6 = r2 ^ r2 << 1;
        r6 = CPU.andA(r6, CPU.lr().value);
      }
      if(CPU.cpsr().getZero()) { // ==
        r6 = r3 ^ r3 << 1;
        r6 = CPU.andA(r6, CPU.lr().value);
      }
      if(CPU.cpsr().getZero()) { // ==
        r6 = r4 ^ r4 << 1;
        r6 = CPU.andA(r6, CPU.lr().value);
      }
      if(!CPU.cpsr().getZero()) { // !=
        final IntRef r6ref = new IntRef();
        r6ref.set(r1);
        FUN_3000aec(r6ref);
        r1 = r6ref.get();
        r6ref.set(r2);
        FUN_3000aec(r6ref);
        r2 = r6ref.get();
        r6ref.set(r3);
        FUN_3000aec(r6ref);
        r3 = r6ref.get();
        r6ref.set(r4);
        FUN_3000aec(r6ref);
        r4 = r6ref.get();
        CPU.lr().value = 0x80000000;
        CPU.lr().value = CPU.lr().value | ((CPU.lr().value >>> 16));
        final int address3000b54 = 0x3000b5c;
        MEMORY.ref(4, address3000b54).setu(CPU.lr().value);
      }
      r6 = CPU.r8().value & Integer.rotateRight(r1, 15);
      r7 = CPU.r8().value & Integer.rotateRight(r2, 15);
      r6 = r7 | r6 >>> 8;
      CPU.r11().value = CPU.r8().value & Integer.rotateRight(r3, 15);
      r7 = CPU.r8().value & Integer.rotateRight(r4, 15);
      r7 = r7 | CPU.r11().value >>> 8;
      CPU.r11().value = r6 & ~(CPU.r10().value >> 15);
      CPU.r11().value = CPU.r11().value | r7 << 16;
      r7 = r7 & CPU.r10().value >> 15;
      r7 = r7 | r6 >>> 16;
      final int address3000bc8 = r5 + 0x630;
      CPU.r12().value = MEMORY.ref(4, address3000bc8).getUnsigned();
      final int address3000bcc = r5 + 0x630;
      MEMORY.ref(4, address3000bcc).setu(CPU.r11().value);
      final int address3000bd0 = r5;
      CPU.r11().value = MEMORY.ref(4, address3000bd0).getUnsigned();
      final int address3000bd4 = r5;
      MEMORY.ref(4, address3000bd4).setu(r7);
      r5 = r5 + 0x4;
      CPU.setCFlag((r4 & 0x1 << 17) != 0);
      r6 = CPU.movA(r0, r4 >> 18);
      r6 = CPU.addA(r6, CPU.r11().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r6 = r6 + 0x28;
      }
      r4 = Integer.rotateRight(r4, 16);
      CPU.setCFlag((r4 & 0x1 << 17) != 0);
      r7 = CPU.movA(r0, r4 >> 18);
      r7 = CPU.addA(r7, CPU.r12().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r7 = r7 + 0x28;
      }
      r4 = CPU.addA(r7, r6 << 16);
      CPU.r11().value = Integer.rotateRight(CPU.r11().value, 16);
      CPU.r12().value = Integer.rotateRight(CPU.r12().value, 16);
      CPU.setCFlag((r2 & 0x1 << 17) != 0);
      r6 = CPU.movA(r0, r2 >> 18);
      r6 = CPU.addA(r6, CPU.r11().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r6 = r6 + 0x28;
      }
      r2 = Integer.rotateRight(r2, 16);
      CPU.setCFlag((r2 & 0x1 << 17) != 0);
      r7 = CPU.movA(r0, r2 >> 18);
      r7 = CPU.addA(r7, CPU.r12().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r7 = r7 + 0x28;
      }
      r2 = CPU.addA(r7, r6 << 16);
      CPU.r11().value = Integer.rotateRight(CPU.r11().value, 8);
      CPU.r12().value = Integer.rotateRight(CPU.r12().value, 8);
      CPU.setCFlag((r3 & 0x1 << 17) != 0);
      r6 = CPU.movA(r0, r3 >> 18);
      r6 = CPU.addA(r6, CPU.r11().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r6 = r6 + 0x28;
      }
      r3 = Integer.rotateRight(r3, 16);
      CPU.setCFlag((r3 & 0x1 << 17) != 0);
      r7 = CPU.movA(r0, r3 >> 18);
      r7 = CPU.addA(r7, CPU.r12().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r7 = r7 + 0x28;
      }
      r3 = CPU.addA(r7, r6 << 16);
      CPU.r11().value = Integer.rotateRight(CPU.r11().value, 16);
      CPU.r12().value = Integer.rotateRight(CPU.r12().value, 16);
      CPU.setCFlag((r1 & 0x1 << 17) != 0);
      r6 = CPU.movA(r0, r1 >> 18);
      r6 = CPU.addA(r6, CPU.r11().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r6 = r6 + 0x28;
      }
      r1 = Integer.rotateRight(r1, 16);
      CPU.setCFlag((r1 & 0x1 << 17) != 0);
      r7 = CPU.movA(r0, r1 >> 18);
      r7 = CPU.addA(r7, CPU.r12().value >> 19);
      if(CPU.cpsr().getNegative()) { // negative
        r7 = r7 + 0x28;
      }
      r1 = CPU.addA(r7, r6 << 16);
      int address3000c70 = r0;
      MEMORY.ref(4, address3000c70).setu(r1);
      address3000c70 += 0x4;
      MEMORY.ref(4, address3000c70).setu(r2);
      address3000c70 += 0x4;
      MEMORY.ref(4, address3000c70).setu(r3);
      address3000c70 += 0x4;
      MEMORY.ref(4, address3000c70).setu(r4);
      address3000c70 += 0x4;
      r0 = address3000c70;
      CPU.r9().value = CPU.subA(CPU.r9().value, 0x4);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >

    CPU.sp().value = CPU.sp().value + 0x1c;
    int address3000c80 = CPU.sp().value;
    CPU.r8().value = MEMORY.ref(4, address3000c80).getUnsigned();
    address3000c80 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address3000c80).getUnsigned();
    address3000c80 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address3000c80).getUnsigned();
    address3000c80 += 0x4;
    CPU.r11().value = MEMORY.ref(4, address3000c80).getUnsigned();
    address3000c80 += 0x4;
    CPU.sp().value = address3000c80;
    int address3000c84 = CPU.sp().value;
    r5 = MEMORY.ref(4, address3000c84).getUnsigned();
    address3000c84 += 0x4;
    r6 = MEMORY.ref(4, address3000c84).getUnsigned();
    address3000c84 += 0x4;
    r7 = MEMORY.ref(4, address3000c84).getUnsigned();
    address3000c84 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address3000c84).getUnsigned();
    address3000c84 += 0x4;
    CPU.sp().value = address3000c84;
  }

  @Method(0x3001388)
  public static void FUN_3001388(final int src, final int dst, final int length) {
    MEMORY.memcpy(src, dst, length);
  }
}
