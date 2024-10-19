package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_8019bac} from 8015570 */
public final class CopiedSegment8015570 {
  private CopiedSegment8015570() { }

  @Method(0x3002140)
  public static int FUN_3002140(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    r3 = r1 >>> 8;
    final int address3002144 = 0x300214c + 0x50;
    CPU.r12().value = MEMORY.ref(4, address3002144).getUnsigned();
    CPU.r12().value = CPU.r12().value + (r3 << 3);
    int address300214c = CPU.r12().value;
    r2 = MEMORY.ref(4, address300214c).getUnsigned();
    address300214c += 0x4;
    r4 = MEMORY.ref(4, address300214c).getUnsigned();
    address300214c += 0x4;
    CPU.r12().value = address300214c;
    r1 = CPU.andA(r1, 0xff);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_3002158
      do {
        do {
          final int address3002158 = r4;
          r3 = MEMORY.ref(1, address3002158).getUnsigned();
          r4 = r4 + 0x1;
          r2 = r2 + r3;
          CPU.cmpA(r3, 0xff);
        } while(CPU.cpsr().getZero()); // ==
        r1 = CPU.subA(r1, 0x1);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_3002170
    r3 = 0x1;
    r4 = CPU.andA(r2, 0x3);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = CPU.rsbA(r3, r4 << 3);
      r2 = r2 & ~0x3;
      final int address3002184 = r2;
      r3 = MEMORY.ref(4, address3002184).getUnsigned();
      r2 = r2 + 0x4;
      r3 = (CPU.cpsr().getCarry() ? 0x8000_0000 : 0) | r3 >>> 1;
      r3 = r3 >>> r4;
    }

    //LAB_3002190
    r1 = 0x0;
    int address3002194 = r0;
    MEMORY.ref(4, address3002194).setu(r1);
    address3002194 += 0x4;
    MEMORY.ref(4, address3002194).setu(r2);
    address3002194 += 0x4;
    MEMORY.ref(4, address3002194).setu(r3);
    address3002194 += 0x4;
    r0 = address3002194;
    return r0;
  }
}
