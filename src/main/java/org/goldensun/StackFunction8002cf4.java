package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class StackFunction8002cf4 {
  private StackFunction8002cf4() { }

  public static void FUN_8002cf4(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;

    CPU.sp().value = CPU.sp().value - 0x4;
    r0 = r0 + 0x4;

    //LAB_8002cfc
    do {
      int address8002cfc = r0;
      r2 = MEMORY.ref(4, address8002cfc).getUnsigned();
      address8002cfc += 0x4;
      r3 = MEMORY.ref(4, address8002cfc).getUnsigned();
      address8002cfc += 0x4;
      r4 = MEMORY.ref(4, address8002cfc).getUnsigned();
      address8002cfc += 0x4;
      r0 = address8002cfc;
      CPU.r12().value = CPU.andA(r4, 0x30000);
      CPU.setCFlag(false);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_8002d4c
        CPU.r12().value = 0x4000000;
        CPU.r12().value = CPU.r12().value + 0xd4;
        int address8002d54 = CPU.r12().value;
        MEMORY.ref(4, address8002d54).setu(r2);
        address8002d54 += 0x4;
        MEMORY.ref(4, address8002d54).setu(r3);
        address8002d54 += 0x4;
        MEMORY.ref(4, address8002d54).setu(r4);
      } else {
        CPU.tstA(r4, 0xc0000);
        CPU.setCFlag(false);
        if(!CPU.cpsr().getZero()) { // !=
          CPU.cmpA(CPU.r12().value, 0x20000);
          if(CPU.r12().value < 0x20000) {
            r5 = MEMORY.ref(1, r3).getUnsigned();
          } else if(CPU.r12().value == 0x20000) {
            r5 = MEMORY.ref(2, r3).getUnsigned();
          } else {
            r5 = MEMORY.ref(4, r3).getUnsigned();
          }
          CPU.tstA(r4, 0x40000);
          CPU.setCFlag(false);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = r5 | (r2);
          }
          if(CPU.cpsr().getZero()) { // ==
            r2 = r5 & (~r2);
          }
        }

        //LAB_8002d2c
        CPU.cmpA(CPU.r12().value, 0x20000);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(1, r3).setu(r2);
        }
        if(CPU.cpsr().getZero()) { // ==
          MEMORY.ref(2, r3).setu(r2);
        }
        if(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()) { // >
          MEMORY.ref(4, r3).setu(r2);
        }
      }

      //LAB_8002d3c
      r1 = CPU.subA(r1, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getOverflow()); // >

    int address8002d44 = CPU.sp().value;
    address8002d44 += 0x4;
    CPU.sp().value = address8002d44;
  }
}
