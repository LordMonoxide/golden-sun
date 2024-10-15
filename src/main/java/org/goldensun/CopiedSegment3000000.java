package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.IntRef;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_800300c} from 8000770 */
public final class CopiedSegment3000000 {
  private CopiedSegment3000000() { }

  @Method(0x3000000)
  public static void FUN_3000000() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    r3 = 0x4000000;
    final int address3000004 = r3 + 0x200;
    r2 = MEMORY.ref(4, address3000004).getUnsigned();
    r3 = address3000004;
    final int address3000008 = r3 + 0x8;
    r1 = MEMORY.ref(2, address3000008).getUnsigned();
    r0 = CPU.spsr().get();
    int address3000010 = CPU.sp().value - 0x1c;
    CPU.sp().value = address3000010;
    MEMORY.ref(4, address3000010).setu(r0);
    address3000010 += 0x4;
    MEMORY.ref(4, address3000010).setu(r1);
    address3000010 += 0x4;
    MEMORY.ref(4, address3000010).setu(r2);
    address3000010 += 0x4;
    MEMORY.ref(4, address3000010).setu(r3);
    address3000010 += 0x4;
    address3000010 += 0x4;
    address3000010 += 0x4;
    MEMORY.ref(4, address3000010).setu(CPU.lr().value);
    address3000010 += 0x4;
    r0 = 0x1;
    final int address3000018 = r3 + 0x8;
    MEMORY.ref(2, address3000018).setu(r0);
    r1 = r2 & ((r2 >>> 16));
    r0 = CPU.andA(r1, 0x2);
    if(!CPU.cpsr().getZero()) { // !=
      final int address3000024 = 0x300002c + 0xb8;
      CPU.r12().value = MEMORY.ref(4, address3000024).getUnsigned();
    }
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.andA(r1, 0x1);
      if(!CPU.cpsr().getZero()) { // !=
        final int address3000030 = 0x3000038 + 0xa8;
        CPU.r12().value = MEMORY.ref(4, address3000030).getUnsigned();
      }
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.andA(r1, 0x4);
        if(!CPU.cpsr().getZero()) { // !=
          final int address300003c = 0x3000044 + 0xa4;
          CPU.r12().value = MEMORY.ref(4, address300003c).getUnsigned();
        }
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.andA(r1, 0x40);
          if(!CPU.cpsr().getZero()) { // !=
            final int address3000048 = 0x3000050 + 0xa8;
            CPU.r12().value = MEMORY.ref(4, address3000048).getUnsigned();
          }
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.andA(r1, 0x80);
            if(!CPU.cpsr().getZero()) { // !=
              final int address3000054 = 0x300005c + 0xa0;
              CPU.r12().value = MEMORY.ref(4, address3000054).getUnsigned();
            }
            if(CPU.cpsr().getZero()) { // ==
              r0 = CPU.andA(r1, 0x10);
              if(!CPU.cpsr().getZero()) { // !=
                final int address3000060 = 0x3000068 + 0x88;
                CPU.r12().value = MEMORY.ref(4, address3000060).getUnsigned();
              }
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.andA(r1, 0x20);
                if(!CPU.cpsr().getZero()) { // !=
                  final int address300006c = 0x3000074 + 0x80;
                  CPU.r12().value = MEMORY.ref(4, address300006c).getUnsigned();
                }
                if(CPU.cpsr().getZero()) { // ==
                  r0 = CPU.andA(r1, 0x1000);
                  CPU.setCFlag(false);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address3000078 = 0x3000080 + 0x90;
                    CPU.r12().value = MEMORY.ref(4, address3000078).getUnsigned();
                  }
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.andA(r1, 0x2000);
                    CPU.setCFlag(false);
                    final int address3000084 = 0x300008c + 0x88;
                    CPU.r12().value = MEMORY.ref(4, address3000084).getUnsigned();
                  }
                }
              }
            }
          }
        }
      }
    }

    //LAB_3000088
    final int address3000088 = r3 + 0x2;
    MEMORY.ref(2, address3000088).setu(r0);
    r1 = 0x20c0;
    r2 = r2 & (~r0);
    r1 = r1 & (r2);
    final int address3000098 = r3;
    MEMORY.ref(2, address3000098).setu(r1);
    r3 = CPU.cpsr().get();
    r3 = r3 & ~0xdf;
    r3 = r3 | 0x1f;
    CPU.cpsr().msr(r3, true, false, false, true);
    r5 = CPU.lr().value;
    CPU.lr().value = 0x30000b8;
    MEMORY.call(CPU.r12().value);
    CPU.lr().value = r5;
    r3 = CPU.cpsr().get();
    r3 = r3 & ~0xdf;
    r3 = r3 | 0x92;
    CPU.cpsr().msr(r3, true, false, false, true);
    int address30000cc = CPU.sp().value;
    r0 = MEMORY.ref(4, address30000cc).getUnsigned();
    address30000cc += 0x4;
    r1 = MEMORY.ref(4, address30000cc).getUnsigned();
    address30000cc += 0x4;
    r2 = MEMORY.ref(4, address30000cc).getUnsigned();
    address30000cc += 0x4;
    r3 = MEMORY.ref(4, address30000cc).getUnsigned();
    address30000cc += 0x4;
    address30000cc += 0x4;
    address30000cc += 0x4;
    CPU.lr().value = MEMORY.ref(4, address30000cc).getUnsigned();
    address30000cc += 0x4;
    CPU.sp().value = address30000cc;
    final int address30000d0 = r3;
    MEMORY.ref(2, address30000d0).setu(r2);
    final int address30000d4 = r3 + 0x8;
    MEMORY.ref(2, address30000d4).setu(r1);
    CPU.spsr().msr(r0, true, false, false, true);
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
}
