package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_800fac8} from 800a37c */
public final class CopiedSegment800a37c {
  private CopiedSegment800a37c() { }

  @Method(0x3002000)
  public static int FUN_3002000(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int address3002000 = CPU.sp().value - 0x10;
    CPU.sp().value = address3002000;
    address3002000 += 0x4;
    address3002000 += 0x4;
    address3002000 += 0x4;
    MEMORY.ref(4, address3002000).setu(CPU.r8().value);

    r5 = 0xff000000;
    r5 = r5 | r5 >>> 4;
    r4 = r5 | r5 >>> 8;
    r4 = r4 + 0x1;
    r6 = 0x4000;

    //LAB_3002018
    do {
      final int address3002018 = r0 + 0x2;
      CPU.r12().value = MEMORY.ref(2, address3002018).getUnsigned();
      r0 = address3002018;
      CPU.cmpA(r5, CPU.r12().value << 20);
      if(CPU.cpsr().getZero()) { // ==
        CPU.r12().value = CPU.r12().value + r4;
        CPU.cmpA(r4, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = r4 + 0x1;
        }
      }

      //LAB_3002030
      final int address3002030 = r1 + 0x4;
      MEMORY.ref(2, address3002030).setu(CPU.r12().value);
      r1 = address3002030;
      r6 = CPU.subA(r6, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    r0 = r2 + 0x4000;
    r1 = r1 - 0x10000;
    r1 = r1 + 0x2;
    r5 = 0xff;
    r5 = r5 | r5 << 16;
    CPU.r8().value = 0x1000;

    //LAB_3002054
    do {
      final int address3002054 = r2;
      r4 = MEMORY.ref(4, address3002054).getUnsigned();
      r2 = r2 + 0x4;
      final int address3002058 = r0;
      CPU.r12().value = MEMORY.ref(4, address3002058).getUnsigned();
      r0 = r0 + 0x4;
      r3 = r4 & r5;
      r6 = CPU.r12().value & r5;
      r3 = r3 | r6 << 8;
      r7 = r4 & r5 << 8;
      r6 = CPU.r12().value & r5 << 8;
      r7 = r6 | r7 >>> 8;
      final int address3002074 = r1 + 0x4;
      MEMORY.ref(2, address3002074).setu(r3);
      r1 = address3002074;
      final int address3002078 = r1 + 0x4;
      MEMORY.ref(2, address3002078).setu(r7);
      r1 = address3002078;
      r3 = Integer.rotateRight(r3, 16);
      r7 = Integer.rotateRight(r7, 16);
      final int address3002084 = r1 + 0x4;
      MEMORY.ref(2, address3002084).setu(r3);
      r1 = address3002084;
      final int address3002088 = r1 + 0x4;
      MEMORY.ref(2, address3002088).setu(r7);
      r1 = address3002088;
      CPU.r8().value = CPU.subA(CPU.r8().value, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    int address3002094 = CPU.sp().value;
    address3002094 += 0x4;
    address3002094 += 0x4;
    address3002094 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address3002094).getUnsigned();
    address3002094 += 0x4;
    CPU.sp().value = address3002094;
    return r0;
  }
}
