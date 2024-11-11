package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** TODO this code probably isn't right */
public final class CopiedSegment8001b70 {
  private CopiedSegment8001b70() { }

  public static int FUN_8001b70(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int lr;

    int address8001b70 = CPU.sp().value - 0x14;
    CPU.sp().value = address8001b70;
    address8001b70 += 0x4;
    address8001b70 += 0x4;
    address8001b70 += 0x4;
    address8001b70 += 0x4;
    address8001b70 += 0x4;

    //LAB_8001b74
    do {
      do {
        do {
          lr = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
          lr = lr << 24;
          if(lr != 0) {
            break;
          }

          r2 = r0 & 0x3;
          r4 = MEMORY.ref(4, r0).getUnsigned();
          r5 = MEMORY.ref(4, r0 + 0x4).getUnsigned();
          r0 = r0 + 0x8;

          if(r2 != 0) {
            r6 = MEMORY.ref(4, r0).getUnsigned();
            r2 = r2 * 8;
            r7 = 32 - r2;
            r4 = r4 >>> r2 | r5 << r7;
            r5 = r5 >>> r2 | r6 << r7;
          }

          //LAB_8001bac
          MEMORY.ref(1, r1).setu(r4);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r4 >>> 8);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r4 >>> 16);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r4 >>> 24);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r5);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r5 >>> 8);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r5 >>> 16);
          r1 = r1 + 0x1;
          MEMORY.ref(1, r1).setu(r5 >>> 24);
          r1 = r1 + 0x1;
        } while(true);

        //LAB_8001c2c
        lr = lr | 0x800000;
        CPU.setCFlag((lr & 0x1 << 31) != 0);
        lr = CPU.movA(r0, lr << 1);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          break;
        }

        //LAB_8001c38
        do {
          MEMORY.ref(1, r1).setu(MEMORY.ref(1, r0).getUnsigned());
          r0 = r0 + 0x1;
          r1 = r1 + 0x1;
          CPU.setCFlag((lr & 0x1 << 31) != 0);
          lr = CPU.movA(r0, lr << 1);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      } while(CPU.cpsr().getZero()); // ==

      //LAB_8001c4c
      do {
        CPU.r12().value = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;
        r2 = CPU.r12().value & 0xf0;
        r3 = r1 - r3;
        r4 = r3 - (r2 << 4);
        CPU.r12().value = CPU.andA(CPU.r12().value, 0xf);

        if(CPU.cpsr().getZero()) { // ==
          //LAB_8001d04
          CPU.cmpA(r4, r1);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_8001dbc
            int address8001dbc = CPU.sp().value;
            r0 = MEMORY.ref(4, address8001dbc).getUnsigned();
            address8001dbc += 0x4;
            address8001dbc += 0x4;
            address8001dbc += 0x4;
            address8001dbc += 0x4;
            CPU.r12().value = MEMORY.ref(4, address8001dbc).getUnsigned();
            address8001dbc += 0x4;
            CPU.sp().value = address8001dbc;
            r0 = r1 - r0;
            return r0;
          }
          r3 = MEMORY.ref(1, r0).getUnsigned() + 0x10;
          r0 = r0 + 0x1;

          MEMORY.memcpy(r1, r4, r3 & 0xf);
          r4 += r3 & 0xf;
          r1 += r3 & 0xf;

          //LAB_8001d24
          do {
            MEMORY.memcpy(r1, r4, 0x10);
            r4 = r4 + 0x10;
            r1 = r1 + 0x10;
            r3 = CPU.subA(r3, 0x10);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
        } else {
          switch(CPU.r12().value) {
            case 0xf:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 0xe:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 0xd:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 0xc:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 0xb:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 0xa:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 9:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 8:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 7:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 6:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 5:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 4:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 3:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 2:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;

            case 1:
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
              r4 = r4 + 0x1;
              r1 = r1 + 0x1;
          }

          MEMORY.ref(1, r1).setu(MEMORY.ref(1, r4).getUnsigned());
          r4 = r4 + 0x1;
          r1 = r1 + 0x1;
        }
        CPU.setCFlag((lr & 0x1 << 31) != 0);
        lr = CPU.movA(r0, lr << 1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          do {
            MEMORY.ref(1, r1).setu(MEMORY.ref(1, r0).getUnsigned());
            r0 = r0 + 0x1;
            r1 = r1 + 0x1;
            CPU.setCFlag((lr & 0x1 << 31) != 0);
            lr = CPU.movA(r0, lr << 1);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }
      } while(!CPU.cpsr().getZero()); // !=
    } while(true);
  }
}
