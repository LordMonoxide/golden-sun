package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment_8015d74_8015e10 {
  private CopiedSegment_8015d74_8015e10() { }

  public static void FUN_8015d74(int r0, int r1, final int r2, int r3) {
    int r5;

    int address8015d74 = CPU.sp().value - 0x18;
    CPU.sp().value = address8015d74;
    address8015d74 += 0x4;
    address8015d74 += 0x4;
    address8015d74 += 0x4;
    MEMORY.ref(4, address8015d74).setu(CPU.r8().value);
    address8015d74 += 0x4;
    MEMORY.ref(4, address8015d74).setu(CPU.r9().value);
    address8015d74 += 0x4;
    MEMORY.ref(4, address8015d74).setu(CPU.r10().value);

    //LAB_8015d80
    do {
      CPU.r10().value = r0 + (r2 << 3);

      //LAB_8015d84
      do {
        CPU.r9().value = r1 + 0x20;

        //LAB_8015d88
        do {
          int address8015d88 = r0;
          r5 = MEMORY.ref(4, address8015d88).getUnsigned();
          address8015d88 += 0x4;
          CPU.r12().value = MEMORY.ref(4, address8015d88).getUnsigned();

          r5 = r5 | r5 >>> 4;
          r5 = r5 & 0xff00ff;
          r5 = r5 | r5 >>> 8;
          r5 = r5 & 0xffff;
          CPU.r12().value = CPU.r12().value | CPU.r12().value >>> 4;
          CPU.r12().value = CPU.r12().value & 0xff00ff;
          CPU.r12().value = CPU.r12().value | CPU.r12().value >>> 8;
          CPU.r12().value = r5 | CPU.r12().value << 16;
          r5 = CPU.r12().value | CPU.r12().value >>> 1;
          r5 = r5 | r5 >>> 2;
          r5 = r5 & 0x11111111;
          r5 = CPU.rsbA(r5, r5 << 4);

          CPU.r8().value = CPU.mvnA(r0, r5);
          if(!CPU.cpsr().getZero()) { // !=
            CPU.r8().value = MEMORY.ref(4, r1).getUnsigned();
            CPU.r8().value = CPU.r8().value & ~r5;
            CPU.r12().value = CPU.r12().value | CPU.r8().value;
          }
          MEMORY.ref(4, r1).setu(CPU.r12().value);
          r1 = r1 + 0x4;
          r0 = r0 + (r2 << 3);
          CPU.cmpA(r1, CPU.r9().value);
        } while(!CPU.cpsr().getZero()); // !=

        r0 = r0 - (r2 << 6);
        r0 = r0 + 0x8;
        CPU.cmpA(r0, CPU.r10().value);
      } while(!CPU.cpsr().getZero()); // !=

      r0 = r0 + (r2 << 6);
      r0 = r0 - (r2 << 3);
      r3 = CPU.subA(r3, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    int address8015dfc = CPU.sp().value;
    address8015dfc += 0x4;
    address8015dfc += 0x4;
    address8015dfc += 0x4;
    CPU.r8().value = MEMORY.ref(4, address8015dfc).getUnsigned();
    address8015dfc += 0x4;
    CPU.r9().value = MEMORY.ref(4, address8015dfc).getUnsigned();
    address8015dfc += 0x4;
    CPU.r10().value = MEMORY.ref(4, address8015dfc).getUnsigned();
    address8015dfc += 0x4;
    CPU.sp().value = address8015dfc;
  }

  @Method(0x8015e10)
  public static void FUN_8015e10(int r0, int r1, final int r2, int r3) {
    int r5;

    int address8015e10 = CPU.sp().value - 0x18;
    CPU.sp().value = address8015e10;
    address8015e10 += 0x4;
    address8015e10 += 0x4;
    address8015e10 += 0x4;
    MEMORY.ref(4, address8015e10).setu(CPU.r8().value);
    address8015e10 += 0x4;
    MEMORY.ref(4, address8015e10).setu(CPU.r9().value);
    address8015e10 += 0x4;
    MEMORY.ref(4, address8015e10).setu(CPU.r10().value);

    //LAB_8015e1c
    do {
      CPU.r10().value = r0 + (r2 << 3);

      //LAB_8015e20
      do {
        CPU.r9().value = r1 + 0x20;

        //LAB_8015e24
        do {
          int address8015e24 = r0;
          r5 = MEMORY.ref(4, address8015e24).getUnsigned();
          address8015e24 += 0x4;
          CPU.r12().value = MEMORY.ref(4, address8015e24).getUnsigned();

          r5 = r5 | r5 >>> 4;
          r5 = r5 & 0xff00ff;
          r5 = r5 | r5 >>> 8;
          r5 = r5 & 0xffff;
          CPU.r12().value = CPU.r12().value | CPU.r12().value >>> 4;
          CPU.r12().value = CPU.r12().value & 0xff00ff;
          CPU.r12().value = CPU.r12().value | CPU.r12().value >>> 8;
          CPU.r12().value = r5 | CPU.r12().value << 16;
          final int address8015e48 = r1;
          MEMORY.ref(4, address8015e48).setu(CPU.r12().value);
          r1 = r1 + 0x4;
          r0 = r0 + (r2 << 3);
          CPU.cmpA(r1, CPU.r9().value);
        } while(!CPU.cpsr().getZero()); // !=

        r0 = r0 - (r2 << 6);
        r0 = r0 + 0x8;
        CPU.cmpA(r0, CPU.r10().value);
      } while(!CPU.cpsr().getZero()); // !=

      r0 = r0 + (r2 << 6);
      r0 = r0 - (r2 << 3);
      r3 = CPU.subA(r3, 0x1);
    } while(!CPU.cpsr().getZero()); // !=

    int address8015e78 = CPU.sp().value;
    address8015e78 += 0x4;
    address8015e78 += 0x4;
    address8015e78 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address8015e78).getUnsigned();
    address8015e78 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address8015e78).getUnsigned();
    address8015e78 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address8015e78).getUnsigned();
    address8015e78 += 0x4;
    CPU.sp().value = address8015e78;
  }
}
