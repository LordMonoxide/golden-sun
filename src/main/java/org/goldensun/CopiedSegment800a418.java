package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment800a418 {
  private CopiedSegment800a418() { }

  public static void FUN_800a418(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    r1 = CPU.bicA(r1, 0x7);
    if(CPU.cpsr().getZero()) { // ==
      return;
    }

    r2 = CPU.bicA(r2, 0x7);
    int address800a424 = CPU.sp().value - 0x1c;
    CPU.sp().value = address800a424;
    address800a424 += 0x4;
    address800a424 += 0x4;
    address800a424 += 0x4;
    MEMORY.ref(4, address800a424).setu(CPU.r8().value);
    address800a424 += 0x4;
    MEMORY.ref(4, address800a424).setu(CPU.r9().value);
    address800a424 += 0x4;
    MEMORY.ref(4, address800a424).setu(CPU.r10().value);
    address800a424 += 0x4;
    MEMORY.ref(4, address800a424).setu(CPU.r11().value);
    address800a424 += 0x4;

    //LAB_800a428
    do {
      CPU.r12().value = r1;

      //LAB_800a42c
      do {
        int address800a42c = r0;
        r4 = MEMORY.ref(4, address800a42c).getUnsigned();
        address800a42c += 0x4;
        r5 = MEMORY.ref(4, address800a42c).getUnsigned();
        address800a42c += 0x4;
        r0 = r0 + r1;
        int address800a434 = r0;
        r6 = MEMORY.ref(4, address800a434).getUnsigned();
        address800a434 += 0x4;
        r7 = MEMORY.ref(4, address800a434).getUnsigned();
        address800a434 += 0x4;
        r0 = r0 + r1;
        int address800a43c = r0;
        CPU.r8().value = MEMORY.ref(4, address800a43c).getUnsigned();
        address800a43c += 0x4;
        CPU.r9().value = MEMORY.ref(4, address800a43c).getUnsigned();
        address800a43c += 0x4;
        r0 = r0 + r1;
        int address800a444 = r0;
        CPU.r10().value = MEMORY.ref(4, address800a444).getUnsigned();
        address800a444 += 0x4;
        CPU.r11().value = MEMORY.ref(4, address800a444).getUnsigned();
        address800a444 += 0x4;
        r0 = r0 + r1;
        int address800a44c = r3;
        MEMORY.ref(4, address800a44c).setu(r4);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(r5);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(r6);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(r7);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(CPU.r8().value);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(CPU.r9().value);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(CPU.r10().value);
        address800a44c += 0x4;
        MEMORY.ref(4, address800a44c).setu(CPU.r11().value);
        address800a44c += 0x4;
        r3 = address800a44c;
        int address800a450 = r0;
        r4 = MEMORY.ref(4, address800a450).getUnsigned();
        address800a450 += 0x4;
        r5 = MEMORY.ref(4, address800a450).getUnsigned();
        address800a450 += 0x4;
        r0 = r0 + r1;
        int address800a458 = r0;
        r6 = MEMORY.ref(4, address800a458).getUnsigned();
        address800a458 += 0x4;
        r7 = MEMORY.ref(4, address800a458).getUnsigned();
        address800a458 += 0x4;
        r0 = r0 + r1;
        int address800a460 = r0;
        CPU.r8().value = MEMORY.ref(4, address800a460).getUnsigned();
        address800a460 += 0x4;
        CPU.r9().value = MEMORY.ref(4, address800a460).getUnsigned();
        address800a460 += 0x4;
        r0 = r0 + r1;
        int address800a468 = r0;
        CPU.r10().value = MEMORY.ref(4, address800a468).getUnsigned();
        address800a468 += 0x4;
        CPU.r11().value = MEMORY.ref(4, address800a468).getUnsigned();
        address800a468 += 0x4;
        r0 = address800a468;
        r0 = r0 + r1;
        int address800a470 = r3;
        MEMORY.ref(4, address800a470).setu(r4);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(r5);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(r6);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(r7);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(CPU.r8().value);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(CPU.r9().value);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(CPU.r10().value);
        address800a470 += 0x4;
        MEMORY.ref(4, address800a470).setu(CPU.r11().value);
        address800a470 += 0x4;
        r3 = address800a470;
        CPU.r12().value = CPU.subA(CPU.r12().value, 0x8);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()) { // >
          r0 = r0 - (r1 << 3);
        }
      } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >

      r0 = r0 - r1;
      r2 = CPU.subA(r2, 0x8);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >

    int address800a48c = CPU.sp().value;
    address800a48c += 0x4;
    address800a48c += 0x4;
    address800a48c += 0x4;
    CPU.r8().value = MEMORY.ref(4, address800a48c).getUnsigned();
    address800a48c += 0x4;
    CPU.r9().value = MEMORY.ref(4, address800a48c).getUnsigned();
    address800a48c += 0x4;
    CPU.r10().value = MEMORY.ref(4, address800a48c).getUnsigned();
    address800a48c += 0x4;
    CPU.r11().value = MEMORY.ref(4, address800a48c).getUnsigned();
    address800a48c += 0x4;
    CPU.sp().value = address800a48c;
  }
}
