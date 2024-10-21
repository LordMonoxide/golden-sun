package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_8002fb0} from 8002d5c */
public final class CopiedSegment8002d5c {
  private CopiedSegment8002d5c() { }

  /** This seems to rewrite function pointers in decomperssed THUMB code */
  @Method(0x3002000)
  public static void FUN_3002000(int r0, int r1) {
    final int r2;
    int r3;
    final int r4;
    final int r5;
    final int r6;

    r1 = r1 + r1;
    r2 = r0 + r1;
    r0 = r0 + 0x2;
    r6 = r0;
    r4 = 0x1f;
    r5 = 0x1e;

    //LAB_300201c
    do {
      CPU.cmpA(r0, r2);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        break;
      }

      final int address3002024 = r0;
      CPU.r12().value = MEMORY.ref(2, address3002024).getUnsigned();
      r0 = address3002024 + 0x2;
      CPU.cmpA(r4, CPU.r12().value >>> 11);
      if(CPU.cpsr().getZero()) { // ==
        final int address3002030 = r0 - 0x4;
        r3 = MEMORY.ref(2, address3002030).getUnsigned();
        CPU.cmpA(r5, r3 >>> 11);
        if(CPU.cpsr().getZero()) { // ==
          CPU.r12().value = CPU.r12().value & ~0xf800;
          r3 = r3 & ~0xf800;
          CPU.r12().value = CPU.r12().value | r3 << 11;
          CPU.r12().value = CPU.r12().value << 1;
          r3 = r0 - r6;
          CPU.r12().value = CPU.r12().value - r3;
          r3 = CPU.r12().value >>> 12;
          r3 = r3 & ~0xf800;
          r3 = r3 | 0xf000;
          CPU.r12().value = CPU.r12().value >>> 1;
          CPU.r12().value = CPU.r12().value | 0xf800;
          final int address3002068 = r0 - 0x4;
          MEMORY.ref(2, address3002068).setu(r3);
          final int address300206c = r0 - 0x2;
          MEMORY.ref(2, address300206c).setu(CPU.r12().value);
        }
      }
    } while(true);

    //LAB_3002074
  }
}
