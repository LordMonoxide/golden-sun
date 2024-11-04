package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment80158e8 {
  private CopiedSegment80158e8() { }

  public static void FUN_80158e8(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    int address80158e8 = CPU.sp().value - 0x1c;
    CPU.sp().value = address80158e8;
    address80158e8 += 0x4;
    address80158e8 += 0x4;
    address80158e8 += 0x4;
    MEMORY.ref(4, address80158e8).setu(CPU.r8().value);
    address80158e8 += 0x4;
    MEMORY.ref(4, address80158e8).setu(CPU.r9().value);
    address80158e8 += 0x4;
    MEMORY.ref(4, address80158e8).setu(CPU.r10().value);
    address80158e8 += 0x4;
    MEMORY.ref(4, address80158e8).setu(CPU.lr().value);
    address80158e8 += 0x4;
    CPU.r10().value = r1;
    r1 = 0x0;

    //LAB_80158f4
    do {
      r7 = 0x0;
      CPU.lr().value = 0;
      CPU.r8().value = 0;
      r2 = 0;
      CPU.r12().value = 0;
      r4 = 0;
      r5 = 0;
      r6 = 0;
      r0 = r0 + 0x2;
      CPU.r9().value = r1 + 0x1;
      r1 = 0;

      //LAB_8015920
      do {
        final int address8015920 = CPU.r10().value;
        r3 = MEMORY.ref(2, address8015920).getUnsigned();
        CPU.r10().value = address8015920 + 0x2;
        if(r3 != 0) {
          if(r5 == 0) {
            switch(r3) {
              case 0xf010:
                CPU.lr().value = r6 << 3;
                CPU.r12().value = CPU.lr().value + 0x8;
                CPU.r8().value = CPU.lr().value + 0x1;
                r7 = CPU.lr().value;
                r4 = r7 + 0x7;
                r2 = CPU.r12().value;
                r5 = r5 + 0x1;
                break;

              case 0xf013:
                CPU.lr().value = r6 << 3;
                CPU.r12().value = CPU.lr().value + 0x8;
                CPU.r8().value = CPU.lr().value;
                r7 = CPU.lr().value + 0x1;
                r4 = CPU.r12().value;
                r2 = CPU.lr().value + 0x7;
                r5 = r5 + 0x1;
                break;

              case 0xf007:
              case 0xf016:
              case 0xf01a:
                CPU.lr().value = r6 << 3;
                CPU.r12().value = CPU.lr().value + 0x8;
                r7 = CPU.lr().value;
                CPU.r8().value = r7;
                r2 = CPU.r12().value;
                r4 = r2;
                r5 = r5 + 0x1;
                break;
            }

            //LAB_80159f4
          } else {
            //LAB_80159f8
            switch(r3) {
              case 0xf012:
                CPU.r12().value = r1 + 0x8;
                r4 = r1 + 0x7;
                r2 = CPU.r12().value;
                break;

              case 0xf015:
                CPU.r12().value = r1 + 0x8;
                r4 = CPU.r12().value;
                r2 = r1 + 0x7;
                break;

              case 0xf007:
              case 0xf017:
              case 0xf01b:
                r2 = r1 + 0x8;
                CPU.r12().value = r2;
                r4 = r2;
                break;
            }
          }
        }

        //LAB_8015a8c
        r1 = r1 + 0x8;
        r6 = r6 + 0x1;
        CPU.cmpA(r6, 0x1d);
      } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

      r3 = r4 + (CPU.r8().value << 8);
      final int address8015aa0 = r0;
      MEMORY.ref(2, address8015aa0).setu(r3);
      r0 = address8015aa0 + 0x2;
      r3 = CPU.r12().value + (CPU.lr().value << 8);
      r0 = r0 + 0x2;
      final int address8015aac = r0;
      MEMORY.ref(2, address8015aac).setu(r3);
      r0 = address8015aac + 0x2;
      r0 = r0 + 0x2;
      final int address8015ab4 = r0;
      MEMORY.ref(2, address8015ab4).setu(r3);
      r0 = address8015ab4 + 0x2;
      r0 = r0 + 0x2;
      final int address8015abc = r0;
      MEMORY.ref(2, address8015abc).setu(r3);
      r0 = address8015abc + 0x2;
      CPU.r10().value = CPU.r10().value + 0x4;
      r0 = r0 + 0x2;
      final int address8015ac8 = r0;
      MEMORY.ref(2, address8015ac8).setu(r3);
      r0 = address8015ac8 + 0x2;
      r1 = CPU.r9().value;
      r0 = r0 + 0x2;
      final int address8015ad4 = r0;
      MEMORY.ref(2, address8015ad4).setu(r3);
      r0 = address8015ad4 + 0x2;
      CPU.cmpA(r1, 0x13);
      r0 = r0 + 0x2;
      final int address8015ae0 = r0;
      MEMORY.ref(2, address8015ae0).setu(r3);
      r0 = address8015ae0 + 0x2;
      r3 = r2 + (r7 << 8);
      r0 = r0 + 0x2;
      final int address8015aec = r0;
      MEMORY.ref(2, address8015aec).setu(r3);
      r0 = address8015aec + 0x2;
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    int address8015af4 = CPU.sp().value;
    address8015af4 += 0x4;
    address8015af4 += 0x4;
    address8015af4 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address8015af4).getUnsigned();
    address8015af4 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address8015af4).getUnsigned();
    address8015af4 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address8015af4).getUnsigned();
    address8015af4 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address8015af4).getUnsigned();
    address8015af4 += 0x4;
    CPU.sp().value = address8015af4;
  }
}
