package org.goldensun;

import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.IntRef;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INPUT;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.Hardware.TIMERS;

public final class GoldenSun {
  private GoldenSun() { }

  @Method(0x80003c0)
  public static void main() {
    int r0;
    int r1;

    r0 = 0x12;
    CPU.cpsr().msr(r0, true, false, false, true);
    final int address80003c8 = 0x80003d0 + 0x28;
    CPU.sp().value = MEMORY.ref(4, address80003c8).getUnsigned();
    r0 = 0x1f;
    CPU.cpsr().msr(r0, true, false, false, true);
    final int address80003d4 = 0x80003dc + 0x18;
    CPU.sp().value = MEMORY.ref(4, address80003d4).getUnsigned();
    final int address80003d8 = 0x80003e0 + 0x1c;
    r1 = MEMORY.ref(4, address80003d8).getUnsigned();
    r0 = 0x80003e4 + 0x38c;
    final int address80003e0 = r1;
    MEMORY.ref(4, address80003e0).setu(r0);
    final int address80003e4 = 0x80003ec + 0x14;
    r1 = MEMORY.ref(4, address80003e4).getUnsigned();
    CPU.lr().value = CPU.pc().value;
    MEMORY.call(r1);
  }

  @Method(0x8000770)
  public static void FUN_8000770() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    r3 = 0x4000000;
    final int address8000774 = r3 + 0x200;
    r2 = MEMORY.ref(4, address8000774).getUnsigned();
    r3 = address8000774;
    final int address8000778 = r3 + 0x8;
    r1 = MEMORY.ref(2, address8000778).getUnsigned();
    r0 = CPU.spsr().get();
    int address8000780 = CPU.sp().value - 0x1c;
    CPU.sp().value = address8000780;
    MEMORY.ref(4, address8000780).setu(r0);
    address8000780 += 0x4;
    MEMORY.ref(4, address8000780).setu(r1);
    address8000780 += 0x4;
    MEMORY.ref(4, address8000780).setu(r2);
    address8000780 += 0x4;
    MEMORY.ref(4, address8000780).setu(r3);
    address8000780 += 0x4;
    address8000780 += 0x4;
    address8000780 += 0x4;
    MEMORY.ref(4, address8000780).setu(CPU.lr().value);
    address8000780 += 0x4;
    r0 = 0x1;
    final int address8000788 = r3 + 0x8;
    MEMORY.ref(2, address8000788).setu(r0);
    r1 = r2 & r2 >>> 16;
    r0 = CPU.andA(r1, 0x2);
    if(!CPU.cpsr().getZero()) { // !=
      final int address8000794 = 0x800079c + 0xb8;
      CPU.r12().value = MEMORY.ref(4, address8000794).getUnsigned();
    }
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.andA(r1, 0x1);
      if(!CPU.cpsr().getZero()) { // !=
        final int address80007a0 = 0x80007a8 + 0xa8;
        CPU.r12().value = MEMORY.ref(4, address80007a0).getUnsigned();
      }
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.andA(r1, 0x4);
        if(!CPU.cpsr().getZero()) { // !=
          final int address80007ac = 0x80007b4 + 0xa4;
          CPU.r12().value = MEMORY.ref(4, address80007ac).getUnsigned();
        }
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.andA(r1, 0x40);
          if(!CPU.cpsr().getZero()) { // !=
            final int address80007b8 = 0x80007c0 + 0xa8;
            CPU.r12().value = MEMORY.ref(4, address80007b8).getUnsigned();
          }
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.andA(r1, 0x80);
            if(!CPU.cpsr().getZero()) { // !=
              final int address80007c4 = 0x80007cc + 0xa0;
              CPU.r12().value = MEMORY.ref(4, address80007c4).getUnsigned();
            }
            if(CPU.cpsr().getZero()) { // ==
              r0 = CPU.andA(r1, 0x10);
              if(!CPU.cpsr().getZero()) { // !=
                final int address80007d0 = 0x80007d8 + 0x88;
                CPU.r12().value = MEMORY.ref(4, address80007d0).getUnsigned();
              }
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.andA(r1, 0x20);
                if(!CPU.cpsr().getZero()) { // !=
                  final int address80007dc = 0x80007e4 + 0x80;
                  CPU.r12().value = MEMORY.ref(4, address80007dc).getUnsigned();
                }
                if(CPU.cpsr().getZero()) { // ==
                  r0 = CPU.andA(r1, 0x1000);
                  CPU.setCFlag(false);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80007e8 = 0x80007f0 + 0x90;
                    CPU.r12().value = MEMORY.ref(4, address80007e8).getUnsigned();
                  }
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.andA(r1, 0x2000);
                    CPU.setCFlag(false);
                    final int address80007f4 = 0x80007fc + 0x88;
                    CPU.r12().value = MEMORY.ref(4, address80007f4).getUnsigned();
                  }
                }
              }
            }
          }
        }
      }
    }

    //LAB_80007f8
    final int address80007f8 = r3 + 0x2;
    MEMORY.ref(2, address80007f8).setu(r0);
    r1 = 0x20c0;
    r2 = r2 & ~r0;
    r1 = r1 & r2;
    final int address8000808 = r3;
    MEMORY.ref(2, address8000808).setu(r1);
    r3 = CPU.cpsr().get();
    r3 = r3 & ~0xdf;
    r3 = r3 | 0x1f;
    CPU.cpsr().msr(r3, true, false, false, true);
    r5 = CPU.lr().value;
    CPU.lr().value = 0x8000828;
    MEMORY.call(CPU.r12().value);
    CPU.lr().value = r5;
    r3 = CPU.cpsr().get();
    r3 = r3 & ~0xdf;
    r3 = r3 | 0x92;
    CPU.cpsr().msr(r3, true, false, false, true);
    int address800083c = CPU.sp().value;
    r0 = MEMORY.ref(4, address800083c).getUnsigned();
    address800083c += 0x4;
    r1 = MEMORY.ref(4, address800083c).getUnsigned();
    address800083c += 0x4;
    r2 = MEMORY.ref(4, address800083c).getUnsigned();
    address800083c += 0x4;
    r3 = MEMORY.ref(4, address800083c).getUnsigned();
    address800083c += 0x4;
    address800083c += 0x4;
    address800083c += 0x4;
    CPU.lr().value = MEMORY.ref(4, address800083c).getUnsigned();
    address800083c += 0x4;
    CPU.sp().value = address800083c;
    final int address8000840 = r3;
    MEMORY.ref(2, address8000840).setu(r2);
    final int address8000844 = r3 + 0x8;
    MEMORY.ref(2, address8000844).setu(r1);
    CPU.spsr().msr(r0, true, false, false, true);
  }

  @Method(0x8000af0)
  public static int FUN_8000af0(int r0, int r1) {
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
      FUN_8000b6c(r0_0, r1_0, r2);
      r0 = r0_0.get();
      r1 = r1_0.get();
    }

    final IntRef r0_0 = new IntRef().set(r0);
    final IntRef r1_0 = new IntRef().set(r1);
    FUN_8000b6c(r0_0, r1_0, r2);
    r0 = r0_0.get();
    r1 = r1_0.get();
    r0 = -r0;
    return r0;
  }

  @Method(0x8000b6c)
  public static void FUN_8000b6c(final IntRef r0_0, final IntRef r1_0, final int r2) {
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

  @Method(0x80022ec)
  public static int FUN_80022ec(final int r0, final int r1) {
    final int r3 = MEMORY.ref(4, 0x80022f0).get();
    return (int)MEMORY.call(r3, r0, r1);
  }

  @Method(0x8002dd8)
  public static void FUN_8002dd8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8002e00)
  public static void FUN_8002e00() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r2 = MEMORY.ref(4, 0x8002e94).get();
    r3 = MEMORY.ref(4, 0x8002e98).get();
    r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
    r3 = CPU.andT(r3, r1);
    MEMORY.ref(2, r2 + 0xa).setu(r3);
    r3 = MEMORY.ref(4, 0x8002e9c).get();
    r1 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
    r3 = CPU.andT(r3, r1);
    MEMORY.ref(2, r2 + 0xa).setu(r3);
    r3 = MEMORY.ref(2, r2 + 0xa).getUnsigned();
    CPU.sp().value -= 0x4;
    r2 = MEMORY.ref(4, 0x8002ea0).get();
    r3 = MEMORY.ref(4, 0x8002ea4).get();
    MEMORY.ref(2, r3).setu(r2); // WAITCNT
    r0 = CPU.sp().value;
    r5 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0xc0);
    MEMORY.ref(4, r0).setu(r5);
    r3 = MEMORY.ref(4, 0x8002ea8).get();
    r1 = CPU.lslT(r1, 18);
    r2 = MEMORY.ref(4, 0x8002eac).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    FUN_8004858();
    FUN_800300c();
    r3 = MEMORY.ref(4, 0x8002eb0).get();
    MEMORY.ref(4, r3).setu(r5);
    r3 = MEMORY.ref(4, 0x8002eb4).get();
    MEMORY.ref(1, r3).setu(r5);
    r3 = MEMORY.ref(4, 0x8002eb8).get();
    MEMORY.ref(1, r3).setu(r5);
    r3 = MEMORY.ref(4, 0x8002ebc).get();
    MEMORY.ref(1, r3).setu(r5);
    FUN_8002f10();
    FUN_800479c();
    FUN_8004760();
    r3 = MEMORY.ref(4, 0x8002e90).get();
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 19);
    MEMORY.ref(2, r2).setu(r3); // DISPCNT
    r0 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(4, 0x8002ec0).get();
    r1 = CPU.movT(0, 0x1);
    FUN_800307c(r0, r1, r2);
    r2 = MEMORY.ref(4, 0x8002ec4).get();
    r3 = MEMORY.ref(4, 0x8002ec8).get();
    MEMORY.ref(2, r3).setu(r2);
    FUN_80f9008();
    FUN_800403c();
    FUN_80040e8();
    r3 = MEMORY.ref(4, 0x8002ecc).get();
    r2 = MEMORY.ref(4, 0x8002ed0).get();
    MEMORY.ref(4, r3).setu(r5);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8002ed4).get();
    r0 = CPU.movT(0, 0xa);
    MEMORY.ref(1, r3).setu(r5);
    FUN_80030f8(r0);
    r0 = CPU.movT(0, 0x0);
    FUN_808a008(r0);
    CPU.sp().value += 0x4;
  }

  @Method(0x8002f10)
  public static void FUN_8002f10() {
    int r0;
    final int r1;
    final int r2;
    int r3;
    final int r4;

    r0 = MEMORY.ref(4, 0x8002f2c).get();
    r0 = FUN_8002f40(r0);
    r4 = MEMORY.ref(4, 0x8002f30).get();
    r3 = MEMORY.ref(4, 0x8002f34).get();
    r1 = CPU.addT(r4, 0x0);
    r2 = MEMORY.ref(4, 0x8002f38).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r4 + 0xc).setu(r3);
  }

  @Method(0x8002f40)
  public static int FUN_8002f40(int r0) {
    final int r3;
    r3 = MEMORY.ref(4, 0x8002f48).get();
    r0 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, r3 + r0).get();
    return r0;
  }

  @Method(0x800300c)
  public static void FUN_800300c() {
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    DMA.channels[3].SAD.setu(0x8000770);
    DMA.channels[3].DAD.setu(0x3000000);
    DMA.channels[3].CNT.setu(0x84000500); // enabled, 32-bit, 0x500 words

    MEMORY.ref(4, 0x3007ffc).setu(0x300_0000);

    DMA.channels[3].SAD.setu(0x8007320);
    DMA.channels[3].DAD.setu(0x30000e0);
    DMA.channels[3].CNT.setu(0x8400000e); // enabled, 32-bit, 0xe words

    MEMORY.addFunctions(CopiedSegment3000000.class);

    GPU.DISPSTAT.setu(0);
    INPUT.KEY_CNT.setu(0xc3ff);
    INTERRUPTS.INT_ENABLE.setu(0x1001);
    INTERRUPTS.INT_MASTER_ENABLE.setu(1);
  }

  @Method(0x800307c)
  public static void FUN_800307c(final int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r1 = CPU.addT(r2, 0x0);
    CPU.cmpT(r0, 0xd);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r3 = MEMORY.ref(4, 0x80030e4).get();
      r2 = MEMORY.ref(2, r3).getUnsigned();
      r6 = CPU.addT(r2, 0x0);
      MEMORY.ref(2, r3).setu(r3);
      r2 = CPU.movT(0, 0x1);
      r4 = MEMORY.ref(4, 0x80030e8).get();
      r3 = MEMORY.ref(2, r4).getUnsigned();
      r2 = CPU.lslT(r2, r0);
      r3 = CPU.bicT(r3, r2);
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.orrT(r3, r2);
      }

      //LAB_800309e
      MEMORY.ref(2, r4).setu(r3);
      CPU.cmpT(r0, 0x2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r4 = CPU.movT(0, 0x8);
        r4 = CPU.lslT(r4, r0);
        r2 = CPU.mvnT(r2, r4);
        CPU.cmpT(r0, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.lslT(r5, 8);
          r4 = CPU.orrT(r4, r3);
          r3 = CPU.movT(0, 0xff);
          r2 = CPU.andT(r2, r3);
        }

        //LAB_80030b6
        r5 = MEMORY.ref(4, 0x80030ec).get();
        r3 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r1, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.orrT(r3, r4);
        }

        //LAB_80030c2
        MEMORY.ref(2, r5).setu(r3); // DISPSTAT
      }

      //LAB_80030c4
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x80030f0).get();
        r3 = CPU.lslT(r0, 2);
        MEMORY.ref(4, r2 + r3).setu(r1);
      } else {
        //LAB_80030d0
        r1 = MEMORY.ref(4, 0x80030f0).get();
        r3 = MEMORY.ref(4, 0x80030f4).get();
        r2 = CPU.lslT(r0, 2);
        MEMORY.ref(4, r1 + r2).setu(r3);
      }

      //LAB_80030d8
      r3 = MEMORY.ref(4, 0x80030e4).get();
      MEMORY.ref(2, r3).setu(r6);
    }

    //LAB_80030dc
  }

  @Method(0x80030f8)
  public static void FUN_80030f8(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    CPU.sp().value -= 0x8;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    CPU.r10().value = CPU.sp().value;
    r1 = MEMORY.ref(4, 0x8003230).get();
    CPU.cmpT(CPU.r10().value, r1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r4 = MEMORY.ref(4, 0x8003234).get();
      r3 = MEMORY.ref(4, 0x8003238).get();
      r1 = CPU.r10().value;
      r2 = CPU.subT(r4, r1);
      r5 = CPU.movT(0, 0x84);
      MEMORY.ref(4, r3).setu(r2);
      r5 = CPU.lslT(r5, 24);
      r2 = CPU.lsrT(r2, 2);
      r3 = MEMORY.ref(4, 0x800323c).get();
      r0 = CPU.r10().value;
      r1 = MEMORY.ref(4, 0x8003240).get();
      r2 = CPU.orrT(r2, r5);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = CPU.subT(r3, 0xc);
      CPU.sp().value = r4;
    }

    //LAB_8003130
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      //LAB_800313c
      r2 = MEMORY.ref(4, 0x8003244).get();
      r1 = CPU.movT(0, 0x1);
      CPU.r11().value = r1;
      CPU.r9().value = r2;

      //LAB_8003144
      do {
        r5 = MEMORY.ref(4, 0x8003248).get();
        r3 = CPU.r11().value;
        r0 = CPU.movT(0, 0xc8);
        MEMORY.ref(1, r5).setu(r3);
        r0 = CPU.lslT(r0, 4);
        FUN_8004420(r0);
        r3 = CPU.movT(0, 0x0);
        r1 = CPU.movT(0, 0x80);
        MEMORY.ref(1, r5).setu(r3);
        r1 = CPU.lslT(r1, 3);
        r0 = CPU.movT(0, 0x34);
        r0 = FUN_80048b0(r0, r1);
        FUN_8003e10(r0);
        r3 = MEMORY.ref(4, 0x800324c).get();
        r1 = CPU.r11().value;
        MEMORY.ref(1, r3).setu(r1);
        r3 = MEMORY.ref(4, 0x8003250).get();
        r3 = MEMORY.ref(1, r3).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, 0x8003254).get();
          r1 = MEMORY.ref(2, r3).getUnsigned();
          CPU.cmpT(r1, 0x9f);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = CPU.subT(r1, 0xa0);
          } else {
            //LAB_800317e
            r1 = CPU.addT(r1, 0x44);
          }

          //LAB_8003180
          r3 = MEMORY.ref(4, 0x8003258).get();
          r0 = MEMORY.ref(4, 0x800325c).get();
          r3 = MEMORY.ref(2, r3).getUnsigned();
          r2 = MEMORY.ref(4, r0).get();
          r3 = CPU.subT(r3, 0x1);
          r3 = CPU.lslT(r3, 8);
          r1 = CPU.addT(r1, r3);
          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r3 = MEMORY.ref(4, 0x8003260).get();
            MEMORY.ref(4, r3).setu(r2);
          } else {
            //LAB_8003198
            r3 = CPU.subT(r2, 0x1);
            MEMORY.ref(4, r0).setu(r3);
          }

          //LAB_800319c
          r2 = MEMORY.ref(4, 0x8003260).get();
          r3 = MEMORY.ref(4, r2).get();
          r3 = CPU.cmpT(r3, r1);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            MEMORY.ref(4, r2).setu(r1);
            r2 = MEMORY.ref(4, 0x800325c).get();
            r3 = CPU.movT(0, 0x1e);
            MEMORY.ref(4, r2).setu(r3);
          }
        }

        //LAB_80031ac
        r3 = MEMORY.ref(4, 0x8003264).get();
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r2 = CPU.addT(r3, 0x0);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(4, 0x8003268).get();
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(4, 0x800326c).get();
            r3 = MEMORY.ref(4, r3).get();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.r9().value;
              MEMORY.ref(2, r3).setu(r2);
            } else {
              //LAB_80031cc
              r1 = CPU.r9().value;
              r3 = MEMORY.ref(2, r1).getUnsigned();
              r2 = CPU.r9().value;
              r3 = CPU.addT(r3, 0x1);
              MEMORY.ref(2, r2).setu(r3);
              r3 = MEMORY.ref(4, 0x8003270).get();
              r2 = MEMORY.ref(2, r2).getUnsigned();
              r2 = CPU.cmpT(r2, r3);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r3 = MEMORY.ref(4, 0x8003274).get();
                r1 = CPU.r11().value;
                MEMORY.ref(1, r3).setu(r1);
              }
            }
          }

          //LAB_80031e4
          r3 = MEMORY.ref(4, 0x800326c).get();
          r2 = CPU.movT(0, 0xc0);
          r3 = MEMORY.ref(4, r3).get();
          r2 = CPU.lslT(r2, 2);
          r3 = CPU.cmpT(r3, r2);
          if(CPU.cpsr().getZero()) { // ==
            r2 = MEMORY.ref(4, 0x8003278).get();
            r3 = MEMORY.ref(2, r2).getUnsigned();
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(2, r2).setu(r3);
            r3 = MEMORY.ref(2, r2).getUnsigned();
            CPU.cmpT(r3, 0xb3);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r3 = MEMORY.ref(4, 0x800322c).get();
              MEMORY.ref(2, r2).setu(r3);
              r3 = MEMORY.ref(4, 0x8003274).get();
              r1 = CPU.r11().value;
              MEMORY.ref(1, r3).setu(r1);
            }
          } else {
            //LAB_800320a
            r2 = MEMORY.ref(4, 0x8003278).get();
            r3 = MEMORY.ref(4, 0x800322c).get();
            MEMORY.ref(2, r2).setu(r3);
          }
        }

        if(true) throw new RuntimeException("I got nothin");
/*
        //LAB_8003210
        r3 = MEMORY.ref(4, 0x800327c).get();
        r3 = MEMORY.ref(1, r3 + 0x0).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_800321a
          r5 = MEMORY.ref(4, 0x8003280).get();
          r2 = CPU.movT(0, 0x80);
          r3 = MEMORY.ref(1, r5 + 0x0).getUnsigned();
          r2 = CPU.lslT(r2, 20);
          r7 = MEMORY.ref(4, 0x8003284).get();
          CPU.r8().value = r2;
          r6 = MEMORY.ref(4, 0x800326c).get();
          LAB_80032e4;
        }
        LAB_800330a;

        //LAB_80032e4
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_8003288
          r3 = MEMORY.ref(4, r6 + 0x0).get();
          CPU.cmpT(r3, 0xc);
          if(!CPU.cpsr().getZero()) { // !=
            LAB_800330a;
          }
          r3 = CPU.r11().value;
          MEMORY.ref(1, r5 + 0x0).setu(r3);
          LAB_8003292;
        }
        r0 = MEMORY.ref(4, 0x800334c).get();
        r3 = MEMORY.ref(4, r0 + 0x0).get();
        r2 = CPU.movT(0, 0x7);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          LAB_800330a;
        }
        r1 = MEMORY.ref(4, r6 + 0x0).get();
        r3 = CPU.movT(0, 0xf0);
        r1 = CPU.andT(r1, r3);
        CPU.cmpT(r1, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          LAB_800330a;
        }
        r3 = MEMORY.ref(4, r0 + 0x0).get();
        r2 = CPU.movT(0, 0x8);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_8003292
          r3 = MEMORY.ref(2, r7 + 0x0).getUnsigned();
          r2 = MEMORY.ref(4, 0x80032c4).get();
          r3 = CPU.andT(r3, r2);
          MEMORY.ref(2, r7 + 0x0).setu(r3);
          r0 = MEMORY.ref(4, 0x80032c8).get();
          r1 = CPU.movT(0, 0x1);

          //LAB_800329e
          do {
            CPU.pc().value = 0x80032a0;
            r0 = CPU.SWI(InstructionSet.THUMB); // 0x2
            r2 = MEMORY.ref(2, r0 + 0x0).getUnsigned();
            r3 = CPU.addT(r1, 0x0);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
          } while(CPU.cpsr().getZero()); // ==

          r0 = FUN_8003538();
          r2 = MEMORY.ref(4, 0x80032cc).get();
          r3 = MEMORY.ref(1, r2 + 0x0).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.movT(0, 0x0);
            MEMORY.ref(1, r2 + 0x0).setu(r3);
            r2 = MEMORY.ref(4, 0x80032d0).get();
            r3 = MEMORY.ref(4, 0x80032d4).get();
            MEMORY.ref(4, r2 + 0x0).setu(r3);
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, 0x8003348).get();
            MEMORY.ref(2, r3 + 0x0).setu(r2);
            r0 = FUN_8007304();
          }

          //LAB_80032e2
          r3 = MEMORY.ref(1, r5 + 0x0).getUnsigned();
          LAB_80032e4;
        }
        MEMORY.ref(1, r5 + 0x0).setu(r1);
        LAB_800330a;
*/

        //LAB_800330a
        r2 = MEMORY.ref(4, 0x8003350).get();
        r1 = MEMORY.ref(4, 0x8003354).get();
        r3 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r1).setu(r3);
        r3 = MEMORY.ref(4, 0x8003340).get();
        r1 = MEMORY.ref(4, 0x8003358).get();
        MEMORY.ref(2, r2).setu(r3);
        r2 = MEMORY.ref(4, 0x8003344).get();
        r3 = MEMORY.ref(2, r1).getUnsigned();
        r3 = CPU.andT(r3, r2);
        MEMORY.ref(2, r1).setu(r3);
        r0 = CPU.movT(0, 0x1);

        //LAB_8003322
        do {
          CPU.pc().value = 0x8003324;
          CPU.SWI(InstructionSet.THUMB); // 0x2 halt
          r2 = MEMORY.ref(2, r1).getUnsigned();
          r3 = CPU.addT(r0, 0x0);
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
        } while(CPU.cpsr().getZero()); // ==

        r0 = CPU.movT(0, 0x34);
        FUN_8002dd8(r0);
        FUN_8003d04();
        r2 = MEMORY.ref(4, 0x800335c).get();
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, r2).setu(r3);
        r2 = MEMORY.ref(4, 0x8003420).get();
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, r2).setu(r3);
        FUN_8003538();
        r3 = MEMORY.ref(4, 0x8003424).get();
        r3 = MEMORY.ref(2, r3).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = FUN_8005fcc();
          r2 = MEMORY.ref(4, 0x8003428).get();
          r3 = MEMORY.ref(1, r2).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2 + 0x8).setu(r3);
          }
        }

        //LAB_8003386
        r1 = MEMORY.ref(4, 0x800342c).get();
        r3 = MEMORY.ref(1, r1).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_8003390
          r3 = MEMORY.ref(4, 0x8003430).get();
          r3 = MEMORY.ref(1, r3).getUnsigned();
          r2 = CPU.addT(r3, 0x0);
          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_800339c
            r4 = CPU.movT(0, 0x80);
            r4 = CPU.lslT(r4, 19);
            r3 = MEMORY.ref(2, r4).getUnsigned();
            r0 = CPU.movT(0, 0xa0);
            r3 = CPU.lslT(r3, 16);
            r0 = CPU.lslT(r0, 19);
            r7 = CPU.asrT(r3, 16);
            r3 = MEMORY.ref(2, r0).getUnsigned();
            r3 = CPU.lslT(r3, 16);
            r3 = CPU.asrT(r3, 16);
            CPU.r8().value = r3;
            r3 = MEMORY.ref(1, r1).getUnsigned();
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              MEMORY.ref(2, r4).setu(r2);
              r3 = MEMORY.ref(4, 0x8003434).get();
              MEMORY.ref(2, r0).setu(r3);
              r1 = CPU.movT(0, 0x0);
              r0 = MEMORY.ref(4, 0x8003438).get();
              r5 = MEMORY.ref(4, 0x800343c).get();
              r4 = CPU.movT(0, 0x1);

              //LAB_80033c6
              do {
                r2 = MEMORY.ref(2, r0).getUnsigned();
                r3 = CPU.addT(r5, 0x0);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(2, r0).setu(r3);

                //LAB_80033ce
                do {
                  CPU.pc().value = 0x80033d0;
                  CPU.SWI(InstructionSet.THUMB); // 0x2 halt
                  r2 = MEMORY.ref(2, r0).getUnsigned();
                  r3 = CPU.addT(r4, 0x0);
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, 0x0);
                } while(CPU.cpsr().getZero()); // ==

                r1 = CPU.addT(r1, 0x1);
                CPU.cmpT(r1, 0x3b);
              } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

              r6 = MEMORY.ref(4, 0x8003440).get();
              r3 = MEMORY.ref(4, 0x8003418).get();
              MEMORY.ref(2, r6).setu(r3);
              r3 = CPU.movT(0, 0xc3);
              r5 = MEMORY.ref(4, 0x8003444).get();
              r3 = CPU.lslT(r3, 8);
              MEMORY.ref(2, r5).setu(r3);
              SoundBias0();
              CPU.pc().value = 0x80033f4;
              CPU.SWI(InstructionSet.THUMB); // 0x3
              SoundBias200();
              r3 = MEMORY.ref(4, 0x8003448).get();
              MEMORY.ref(2, r5).setu(r3);
              r3 = MEMORY.ref(4, 0x800341c).get();
              MEMORY.ref(2, r6).setu(r3);
              r3 = CPU.lslT(r7, 16);
              r2 = CPU.movT(0, 0x80);
              r3 = CPU.lsrT(r3, 16);
              r2 = CPU.lslT(r2, 19);
              MEMORY.ref(2, r2).setu(r3);
              r1 = CPU.r8().value;
              r3 = CPU.lslT(r1, 16);
              r2 = CPU.movT(0, 0xa0);
              r3 = CPU.lsrT(r3, 16);
              r2 = CPU.lslT(r2, 19);
              MEMORY.ref(2, r2).setu(r3);
              r1 = CPU.movT(0, 0x0);
              r0 = MEMORY.ref(4, 0x8003480).get();
              r5 = MEMORY.ref(4, 0x8003484).get();
              r4 = CPU.movT(0, 0x1);

              //LAB_8003454
              do {
                r2 = MEMORY.ref(2, r0).getUnsigned();
                r3 = CPU.addT(r5, 0x0);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(2, r0).setu(r3);

                //LAB_800345c
                do {
                  CPU.pc().value = 0x800345e;
                  CPU.SWI(InstructionSet.THUMB); // 0x2 halt
                  r2 = MEMORY.ref(2, r0).getUnsigned();
                  r3 = CPU.addT(r4, 0x0);
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, 0x0);
                } while(CPU.cpsr().getZero()); // ==

                r1 = CPU.addT(r1, 0x1);
                CPU.cmpT(r1, 0x9);
              } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

              r3 = MEMORY.ref(4, 0x8003488).get();
              r2 = CPU.movT(0, 0x0);
              MEMORY.ref(1, r3).setu(r2);
              r3 = MEMORY.ref(4, 0x800347c).get();
              r2 = CPU.r9().value;
              MEMORY.ref(2, r2).setu(r3);
            } else {
              //LAB_800348c
              r3 = MEMORY.ref(1, r1).getUnsigned();
              r3 = CPU.addT(r3, 0xff);
              MEMORY.ref(1, r1).setu(r3);
            }
          }
        }

        //LAB_8003492
        r2 = MEMORY.ref(4, 0x8003510).get();
        r3 = MEMORY.ref(1, r2).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(1, r2).setu(r3);
          r0 = CPU.movT(0, 0x80);
          r2 = MEMORY.ref(4, 0x8003514).get();
          r3 = MEMORY.ref(4, 0x8003518).get();
          r0 = CPU.lslT(r0, 20);
          MEMORY.ref(4, r2).setu(r3);
          r2 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(4, 0x800351c).get();
          MEMORY.ref(2, r3).setu(r2);
          r0 = FUN_80072e4(r0);
        }

        //LAB_80034b2
        r3 = MEMORY.ref(4, CPU.sp().value).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r3 = CPU.cmpT(r3, r1);
      } while(!CPU.cpsr().getCarry()); // unsigned <
    }

    //LAB_80034c0
    r2 = MEMORY.ref(4, 0x8003520).get();
    r3 = MEMORY.ref(4, r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.r10().value = CPU.sp().value;
      r3 = MEMORY.ref(4, r2).get();
      r2 = CPU.r10().value;
      r2 = CPU.subT(r2, r3);
      CPU.r10().value = r2;
      CPU.sp().value = CPU.r10().value;
      r3 = MEMORY.ref(4, 0x8003520).get();
      r2 = MEMORY.ref(4, r3).get();
      r4 = CPU.movT(0, 0x84);
      r4 = CPU.lslT(r4, 24);
      r2 = CPU.lsrT(r2, 2);
      r3 = MEMORY.ref(4, 0x8003524).get();
      r0 = MEMORY.ref(4, 0x8003528).get();
      r1 = CPU.r10().value;
      r2 = CPU.orrT(r2, r4);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;

      r3 = CPU.subT(r3, 0xc);
      r3 = CPU.movT(0, 0x80);
      r1 = MEMORY.ref(4, 0x8003524).get();
      r3 = CPU.lslT(r3, 24);

      //LAB_80034f0
      do {
        r2 = MEMORY.ref(4, r1 + 0x8).get();
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
      } while(!CPU.cpsr().getZero()); // !=

      r3 = MEMORY.ref(4, 0x8003520).get();
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80034fc
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x8003538)
  public static void FUN_8003538() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8003d04)
  public static void FUN_8003d04() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8003e10)
  public static void FUN_8003e10(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x800403c)
  public static void FUN_800403c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80040e8)
  public static void FUN_80040e8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8004420)
  public static void FUN_8004420(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8004760)
  public static void FUN_8004760() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    CPU.sp().value -= 0x4;
    r3 = MEMORY.ref(4, 0x8004784).get();
    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(r3);
    r1 = MEMORY.ref(4, 0x8004788).get();
    r3 = MEMORY.ref(4, 0x800478c).get();
    r2 = MEMORY.ref(4, 0x8004790).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r2 = MEMORY.ref(4, 0x8004794).get();
    r3 = MEMORY.ref(4, 0x8004788).get();
    MEMORY.ref(4, r2).setu(r3);
    r2 = CPU.movT(0, 0x80);
    r3 = MEMORY.ref(4, 0x8004798).get();
    r2 = CPU.lslT(r2, 3);
    MEMORY.ref(2, r3).setu(r2); // BG0CNT
    CPU.sp().value += 0x4;
  }

  @Method(0x800479c)
  public static void FUN_800479c() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = MEMORY.ref(4, 0x8004800).get();
    r0 = FUN_8002f40(r0);
    r1 = CPU.movT(0, 0xc0);
    r3 = MEMORY.ref(4, 0x8004804).get();
    r1 = CPU.lslT(r1, 19);
    r2 = MEMORY.ref(4, 0x8004808).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2); // DMA to VRAM
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r0 = MEMORY.ref(4, 0x800480c).get();
    r1 = MEMORY.ref(4, 0x8004810).get();
    r2 = MEMORY.ref(4, 0x8004814).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2); // DMA to BG/OBJ palette RAM
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r2 = CPU.movT(0, 0x0);
    r3 = CPU.movT(0, 0xa0);
    r3 = CPU.lslT(r3, 19);
    MEMORY.ref(2, r3).setu(r2);
    r2 = CPU.movT(0, 0x83);
    r3 = MEMORY.ref(4, 0x8004818).get();
    r2 = CPU.lslT(r2, 7);
    MEMORY.ref(2, r3).setu(r2);
    r2 = MEMORY.ref(4, 0x800481c).get();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r2 = CPU.movT(0, 0xc5);
    r2 = CPU.lslT(r2, 6);
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r2 = MEMORY.ref(4, 0x8004820).get();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r2 = MEMORY.ref(4, 0x8004824).get();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r2 = MEMORY.ref(4, 0x8004828).get();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r2 = MEMORY.ref(4, 0x800482c).get();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x8004804).get();
    r0 = MEMORY.ref(4, 0x8004830).get();
    r1 = CPU.addT(r1, 0x20);
    r2 = MEMORY.ref(4, 0x8004834).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
  }

  @Method(0x8004858)
  public static void FUN_8004858() {
    final int r0;
    final int r1;
    final int r2;
    int r3;
    final int r4;

    CPU.sp().value -= 0x4;
    r4 = MEMORY.ref(4, 0x8004878).get();
    r0 = CPU.sp().value;
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r0).setu(r3);
    r1 = CPU.addT(r4, 0x0);
    r3 = MEMORY.ref(4, 0x800487c).get();
    r2 = MEMORY.ref(4, 0x8004880).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = MEMORY.ref(4, 0x8004884).get();
    MEMORY.ref(4, r4 + 0x4).setu(r3);
    r3 = MEMORY.ref(4, 0x8004888).get();
    CPU.sp().value += 0x4;
    MEMORY.ref(4, r4).setu(r3);
  }

  @Method(0x80048b0)
  public static int FUN_80048b0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8005fcc)
  public static int FUN_8005fcc() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006864)
  public static void CpuSet(final int src, final int dest, final int lenMode) {
    Bios.CpuSet(src, dest, lenMode);
  }

  @Method(0x8006868)
  public static void SoundBias0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006870)
  public static void SoundBias200() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80072e4)
  public static int FUN_80072e4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808a008)
  public static void FUN_808a008(final int r0) {
    MEMORY.call(MEMORY.ref(4, 0x808a00c).get(), r0);
  }

  @Method(0x80f9008)
  public static void FUN_80f9008() {
    MEMORY.call(MEMORY.ref(4, 0x80f900c).get());
  }

  @Method(0x80f9438)
  public static void FUN_80f9438() {
    final int r0;
    int r1;
    int r2;
    int r3;
    FUN_80fa2a0();
    r2 = MEMORY.ref(4, 0x80f9488).get();
    r3 = CPU.movT(0, 0xff);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x80f948c).get();
    r1 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r3).setu(r1);
    r2 = MEMORY.ref(4, 0x80f947c).get();
    r3 = MEMORY.ref(4, 0x80f9490).get();
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x80f9494).get();
    r0 = MEMORY.ref(4, 0x80f9480).get();
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x80f9498).get();
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x80f949c).get();
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x80f94a0).get();
    MEMORY.ref(2, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x80f94a4).get();
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x80f94a8).get();
    MEMORY.ref(1, r3).setu(r1);
    r3 = MEMORY.ref(4, 0x80f94ac).get();
    MEMORY.ref(1, r3).setu(r1);
    r3 = MEMORY.ref(4, 0x80f94b0).get();
    r2 = MEMORY.ref(4, 0x80f94b4).get();
    MEMORY.ref(1, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x80f9484).get();
    r3 = CPU.movT(0, 0x7);

    //LAB_80f94b8
    do {
      r3 = CPU.subT(r3, 0x1);
      MEMORY.ref(2, r2).setu(r1);
      r2 = CPU.addT(r2, 0x2);
      CPU.cmpT(r3, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
  }

  @Method(0x80f9a80)
  public static void FUN_80f9a80(int r0) {
    int r1;
    int r2;
    int r3;
    r1 = CPU.movT(0, 0x24);
    r2 = MEMORY.ref(4, 0x80f9ab0).get();

    //LAB_80f9a86
    do {
      r3 = MEMORY.ref(4, r2).get();

      // This if statement was actually a function call but also not really
      if(r2 >>> 25 == 0) {
        r2 = CPU.cmpT(r2, MEMORY.ref(4, 0x80f9ab0).get());
        if(!CPU.cpsr().getCarry() /* unsigned < */ || r2 >>> 14 != 0) {
          //LAB_80f9aaa
          r3 = CPU.movT(0, 0x0);
        }
      }

      MEMORY.ref(4, r0).setu(r3);
      r0 += 0x4;
      r2 = CPU.addT(r2, 0x4);
      r1 = CPU.subT(r1, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
  }

  @Method(0x80fa2a0)
  public static void FUN_80fa2a0() {
    int r0;
    int r1;
    int r2;
    int r4;
    int r5;
    int r6;

    r0 = MEMORY.ref(4, 0x80fa2f4).get();
    r1 = CPU.movT(0, 0x2);
    r1 = CPU.negT(r1, r1);
    r0 = CPU.andT(r0, r1);
    r1 = MEMORY.ref(4, 0x80fa2f8).get();
    r2 = MEMORY.ref(4, 0x80fa2fc).get();
    CpuSet(r0, r1, r2);
    r0 = MEMORY.ref(4, 0x80fa300).get();
    FUN_80fa6a0(r0);
    r0 = MEMORY.ref(4, 0x80fa304).get();
    FUN_80fa55c(r0);
    r0 = MEMORY.ref(4, 0x80fa308).get();
    FUN_80fa83c(r0);
    r0 = MEMORY.ref(4, 0x80fa30c).get();
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r5 = MEMORY.ref(4, 0x80fa310).get();
      r6 = CPU.addT(r0, 0x0);

      //LAB_80fa2d2
      do {
        r4 = MEMORY.ref(4, r5).get();
        r1 = MEMORY.ref(4, r5 + 0x4).get();
        r2 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
        r0 = CPU.addT(r4, 0x0);
        FUN_80fa9e0(r0, r1, r2);
        r0 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
        MEMORY.ref(1, r4 + 0xb).setu(r0);
        r0 = MEMORY.ref(4, 0x80fa314).get();
        MEMORY.ref(4, r4 + 0x18).setu(r0);
        r5 = CPU.addT(r5, 0xc);
        r6 = CPU.subT(r6, 0x1);
        CPU.cmpT(r6, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_80fa2ee
  }

  @Method(0x80fa55c)
  public static void FUN_80fa55c(int r0) {
    int r1;
    int r2;
    final int r3;
    final int r4;
    final int r5;
    int r6;

    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    r1 = MEMORY.ref(4, 0x80fa624).get();
    r0 = CPU.movT(0, 0x8f);
    MEMORY.ref(2, r1).setu(r0);
    r3 = MEMORY.ref(4, 0x80fa628).get();
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r3).setu(r2); // SOUNDCNT_L
    r0 = MEMORY.ref(4, 0x80fa62c).get();
    r1 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_H
    r0 = CPU.addT(r0, 0x6);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_L
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_L
    r0 = CPU.subT(r0, 0x14);
    r1 = CPU.movT(0, 0x80);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_X
    r0 = CPU.addT(r0, 0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_H
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_H
    r0 = CPU.subT(r0, 0xd);
    MEMORY.ref(1, r0).setu(r2); // SOUND3CNT_L
    r0 = CPU.movT(0, 0x77);
    MEMORY.ref(1, r3).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa630).get();
    r4 = MEMORY.ref(4, r0).get();
    r6 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, 0x80fa634).get();
    r6 = CPU.cmpT(r6, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r6, 0x1);
      MEMORY.ref(4, r4).setu(r0);
      r1 = MEMORY.ref(4, 0x80fa638).get();
      r0 = MEMORY.ref(4, 0x80fa63c).get();
      MEMORY.ref(4, r1 + 0x20).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa640).get();
      MEMORY.ref(4, r1 + 0x44).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa644).get();
      MEMORY.ref(4, r1 + 0x4c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa648).get();
      MEMORY.ref(4, r1 + 0x70).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa64c).get();
      MEMORY.ref(4, r1 + 0x74).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa650).get();
      MEMORY.ref(4, r1 + 0x78).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa654).get();
      MEMORY.ref(4, r1 + 0x7c).setu(r0);
      r2 = CPU.addT(r1, 0x0);
      r2 = CPU.addT(r2, 0x80);
      r0 = MEMORY.ref(4, 0x80fa658).get();
      MEMORY.ref(4, r2).setu(r0);
      r1 = CPU.addT(r1, 0x84);
      r0 = MEMORY.ref(4, 0x80fa65c).get();
      MEMORY.ref(4, r1).setu(r0);
      MEMORY.ref(4, r4 + 0x1c).setu(r5);
      r0 = MEMORY.ref(4, 0x80fa660).get();
      MEMORY.ref(4, r4 + 0x28).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa664).get();
      MEMORY.ref(4, r4 + 0x2c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa668).get();
      MEMORY.ref(4, r4 + 0x30).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa66c).get();
      r1 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r4 + 0xc).setu(r0);
      MEMORY.ref(4, CPU.sp().value).setu(r1);
      r2 = MEMORY.ref(4, 0x80fa670).get();
      r0 = CPU.sp().value;
      r1 = CPU.addT(r5, 0x0);
      CpuSet(r0, r1, r2);
      r0 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r5 + 0x1).setu(r0);
      r0 = CPU.movT(0, 0x11);
      MEMORY.ref(1, r5 + 0x1c).setu(r0);
      r1 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r1, 0x41);
      r0 = CPU.movT(0, 0x2);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0, 0x22);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x25);
      r0 = CPU.movT(0, 0x3);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0, 0x44);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x24);
      r0 = CPU.movT(0, 0x4);
      MEMORY.ref(1, r1 + 0x1).setu(r0);
      r0 = CPU.movT(0, 0x88);
      MEMORY.ref(1, r1 + 0x1c).setu(r0);
      MEMORY.ref(4, r4).setu(r6);
    }

    //LAB_80fa61c
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa6a0)
  public static void FUN_80fa6a0(int r0) {
    int r1;
    int r2;
    final int r3;
    final int r4;
    final int r5;

    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5).setu(r3);
    r1 = MEMORY.ref(4, 0x80fa758).get();
    r0 = MEMORY.ref(4, r1).get();
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 18);
    r0 = CPU.andT(r0, r2);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, 0x80fa75c).get();
      MEMORY.ref(4, r1).setu(r0);
    }

    //LAB_80fa6bc
    r1 = MEMORY.ref(4, 0x80fa760).get();
    r0 = MEMORY.ref(4, r1).get();
    r0 = CPU.andT(r0, r2);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, 0x80fa75c).get();
      MEMORY.ref(4, r1).setu(r0);
    }

    //LAB_80fa6ca
    r0 = MEMORY.ref(4, 0x80fa764).get();
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 3);
    r1 = CPU.addT(r2, 0x0);
    MEMORY.ref(2, r0).setu(r1);
    r0 = CPU.addT(r0, 0xc);
    MEMORY.ref(2, r0).setu(r1);
    r1 = MEMORY.ref(4, 0x80fa768).get();
    r0 = CPU.movT(0, 0x8f);
    MEMORY.ref(2, r1).setu(r0); // SOUNDCNT_X
    r1 = CPU.subT(r1, 0x2);
    r2 = MEMORY.ref(4, 0x80fa76c).get();
    r0 = CPU.addT(r2, 0x0);
    MEMORY.ref(2, r1).setu(r0); // SOUNDCNT_H
    r2 = MEMORY.ref(4, 0x80fa770).get();
    r1 = MEMORY.ref(1, r2).getUnsigned(); // SOUNDBIAS (upper byte)
    r0 = CPU.movT(0, 0x3f);
    r0 = CPU.andT(r0, r1);
    r1 = CPU.movT(0, 0x40);
    r0 = CPU.orrT(r0, r1);
    MEMORY.ref(1, r2).setu(r0);
    r1 = MEMORY.ref(4, 0x80fa774).get();
    r2 = CPU.movT(0, 0xd4);
    r2 = CPU.lslT(r2, 2);
    r0 = CPU.addT(r5, r2);
    MEMORY.ref(4, r1).setu(r0);
    r1 = CPU.addT(r1, 0x4);
    r0 = MEMORY.ref(4, 0x80fa778).get();
    MEMORY.ref(4, r1).setu(r0);
    r1 = CPU.addT(r1, 0x8);
    r2 = CPU.movT(0, 0x98);
    r2 = CPU.lslT(r2, 4);
    r0 = CPU.addT(r5, r2);
    MEMORY.ref(4, r1).setu(r0);
    r1 = CPU.addT(r1, 0x4);
    r0 = MEMORY.ref(4, 0x80fa77c).get();
    MEMORY.ref(4, r1).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa780).get();
    MEMORY.ref(4, r0).setu(r5);
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r2 = MEMORY.ref(4, 0x80fa784).get();
    r0 = CPU.sp().value;
    r1 = CPU.addT(r5, 0x0);
    CpuSet(r0, r1, r2);
    r0 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r5 + 0x6).setu(r0);
    r0 = CPU.movT(0, 0xf);
    MEMORY.ref(1, r5 + 0x7).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa788).get();
    MEMORY.ref(4, r5 + 0x38).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa78c).get();
    MEMORY.ref(4, r5 + 0x28).setu(r0);
    MEMORY.ref(4, r5 + 0x2c).setu(r0);
    MEMORY.ref(4, r5 + 0x30).setu(r0);
    MEMORY.ref(4, r5 + 0x3c).setu(r0);
    r4 = MEMORY.ref(4, 0x80fa790).get();
    r0 = CPU.addT(r4, 0x0);
    FUN_80f9a80(r0);
    MEMORY.ref(4, r5 + 0x34).setu(r4);
    r0 = CPU.movT(0, 0x80);
    r0 = CPU.lslT(r0, 11);
    FUN_80fa798(r0);
    r0 = MEMORY.ref(4, 0x80fa794).get();
    MEMORY.ref(4, r5).setu(r0);
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa798)
  public static void FUN_80fa798(int r0) {
    int r1;
    int r2;
    int r4;
    final int r5;
    final int r6;

    r2 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80fa818).get();
    r4 = MEMORY.ref(4, r0).get();
    r0 = CPU.movT(0, 0xf0);
    r0 = CPU.lslT(r0, 12);
    r0 = CPU.andT(r0, r2);
    r2 = CPU.lsrT(r0, 16);
    r6 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r4 + 0x8).setu(r2);
    r1 = MEMORY.ref(4, 0x80fa81c).get();
    r0 = CPU.subT(r2, 0x1);
    r0 = CPU.lslT(r0, 1);
    r0 = CPU.addT(r0, r1);
    r5 = MEMORY.ref(2, r0).getUnsigned();
    MEMORY.ref(4, r4 + 0x10).setu(r5);
    r0 = CPU.movT(0, 0xc6);
    r0 = CPU.lslT(r0, 3);
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_80022ec(r0, r1);
    MEMORY.ref(1, r4 + 0xb).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa820).get();
    r0 = CPU.mulT(r0, r5);
    r1 = MEMORY.ref(4, 0x80fa824).get();
    r0 = CPU.addT(r0, r1);
    r1 = MEMORY.ref(4, 0x80fa828).get();
    r0 = FUN_80022ec(r0, r1);
    r1 = CPU.addT(r0, 0x0);
    MEMORY.ref(4, r4 + 0x14).setu(r1);
    r0 = CPU.movT(0, 0x80);
    r0 = CPU.lslT(r0, 17);
    r0 = FUN_80022ec(r0, r1);
    r0 = CPU.addT(r0, 0x1);
    r0 = CPU.asrT(r0, 1);
    MEMORY.ref(4, r4 + 0x18).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa82c).get();
    MEMORY.ref(2, r0).setu(r6); // TM0CNT_H
    r4 = MEMORY.ref(4, 0x80fa830).get();
    r0 = MEMORY.ref(4, 0x80fa834).get();
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_80022ec(r0, r1);
    r0 = CPU.negT(r0, r0);
    MEMORY.ref(2, r4).setu(r0); // TM0CNT_L
    FUN_80fa9a4();

    //LAB_80fa7fc
    do {
      r0 = GPU.VCOUNT.getUnsigned();
      CPU.cmpT(r0, 0x9f);
    } while(CPU.cpsr().getZero()); // ==

    //LAB_80fa804
    do {
      r0 = GPU.VCOUNT.getUnsigned();
      CPU.cmpT(r0, 0x9f);
    } while(!CPU.cpsr().getZero()); // !=

    TIMERS.timers[0].CNT_H.setu(0x80); // start timer 0
  }

  @Method(0x80fa83c)
  public static void FUN_80fa83c(int r0) {
    int r1;
    final int r2;
    final int r3;
    int r4;
    final int r5;

    r3 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80fa8c8).get();
    r5 = MEMORY.ref(4, r0).get();
    r1 = MEMORY.ref(4, r5).get();
    r0 = MEMORY.ref(4, 0x80fa8cc).get();
    r1 = CPU.cmpT(r1, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r1, 0x1);
      MEMORY.ref(4, r5).setu(r0);
      r4 = CPU.movT(0, 0xff);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0x7f);
        r4 = CPU.andT(r4, r0);
        MEMORY.ref(1, r5 + 0x5).setu(r4);
      }

      //LAB_80fa85e
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 4);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 8);
        MEMORY.ref(1, r5 + 0x6).setu(r0);
        r4 = CPU.movT(0, 0xc);
        r0 = CPU.addT(r5, 0x0);
        r0 = CPU.addT(r0, 0x50);
        r1 = CPU.movT(0, 0x0);

        //LAB_80fa874
        do {
          MEMORY.ref(1, r0).setu(r1);
          r4 = CPU.subT(r4, 0x1);
          r0 = CPU.addT(r0, 0x40);
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80fa87e
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 8);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 12);
        MEMORY.ref(1, r5 + 0x7).setu(r0);
      }

      //LAB_80fa88c
      r4 = CPU.movT(0, 0xb0);
      r4 = CPU.lslT(r4, 16);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0xc0);
        r0 = CPU.lslT(r0, 14);
        r0 = CPU.andT(r0, r4);
        r4 = CPU.lsrT(r0, 14);
        r2 = MEMORY.ref(4, 0x80fa8d0).get();
        r1 = MEMORY.ref(1, r2).getUnsigned();
        r0 = CPU.movT(0, 0x3f);
        r0 = CPU.andT(r0, r1);
        r0 = CPU.orrT(r0, r4);
        MEMORY.ref(1, r2).setu(r0);
      }

      //LAB_80fa8aa
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 12);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_80fa928();
        r0 = CPU.addT(r4, 0x0);
        FUN_80fa798(r0);
      }

      //LAB_80fa8be
      r0 = MEMORY.ref(4, 0x80fa8cc).get();
      MEMORY.ref(4, r5).setu(r0);
    }

    //LAB_80fa8c2
  }

  @Method(0x80fa928)
  public static void FUN_80fa928() {
    CPU.sp().value -= 0x4;

    final int r2 = MEMORY.ref(4, 0x3007ff0).get();
    final int r1 = MEMORY.ref(4, r2).get();
    final int r0 = r1 + 0x978c_92ad;
    CPU.cmpT(r0, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      MEMORY.ref(4, r2).setu(r1 + 0xa);

      if((DMA.channels[1].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[1].CNT.setu(0x8440_0004);
      }

      //LAB_80fa952
      if((DMA.channels[2].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[2].CNT.setu(0x8440_0004);
      }

      //LAB_80fa960
      DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
      DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);

      MEMORY.ref(4, CPU.sp().value).setu(0);
      CpuSet(CPU.sp().value, r2 + 0x350, 0x500_0318);
    }

    //LAB_80fa980
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa9a4)
  public static void FUN_80fa9a4() {
    final int r2 = MEMORY.ref(4, 0x3007ff0).get();
    final int r3 = MEMORY.ref(4, r2).get();

    if(r3 != 0x68736d53) { // Magic number for MP2K? https://github.com/mgba-emu/mgba/blob/master/include/mgba/internal/gba/audio.h
      DMA.channels[1].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      DMA.channels[2].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      MEMORY.ref(1, r2 + 0x4).setu(0);
      MEMORY.ref(4, r2).setu(r3 - 0xa);
    }

    //LAB_80fa9cc
  }

  @Method(0x80fa9e0)
  public static void FUN_80fa9e0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }
}
