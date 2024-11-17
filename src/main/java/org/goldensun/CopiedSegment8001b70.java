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
    int r12;
    int lr;

    final int address8001b70 = CPU.sp().value - 0x14;
    CPU.sp().value = address8001b70;
    MEMORY.ref(4, address8001b70).setu(r1);

    //LAB_8001b74
    jmp_8001b74:
    do {
      do {
        do {
          lr = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
          lr = lr << 24;
          if(lr != 0) {
            break;
          }
          r2 = CPU.andA(r0, 0x3);
          // These can be misaligned
          r4 = MEMORY.ref(4, r0 & ~0x3).getUnsigned();
          r5 = MEMORY.ref(4, r0 + 0x4 & ~0x3).getUnsigned();
          r0 = r0 + 0x8;

          if(r2 != 0) {
            r6 = MEMORY.ref(4, r0 & ~0x3).getUnsigned();
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
        do {
          r12 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
          r3 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
          r2 = r12 & 0xf0;
          r3 = r1 - r3;
          r4 = r3 - (r2 << 4);
          r12 = CPU.andA(r12, 0xf);
          if(r12 != 0) {
            // Can't be a memcpy because of overlap
            for(int i = 0; i < r12 + 1; i++) {
              MEMORY.set(r1, 1, MEMORY.get(r4, 1));
              r1++;
              r4++;
            }

            CPU.setCFlag((lr & 0x1 << 31) != 0);
            lr = CPU.movA(r0, lr << 1);
            while(!CPU.cpsr().getCarry()) { // unsigned <
              MEMORY.ref(1, r1).setu(MEMORY.ref(1, r0).getUnsigned());
              r0 = r0 + 0x1;
              r1 = r1 + 0x1;
              CPU.setCFlag((lr & 0x1 << 31) != 0);
              lr = CPU.movA(r0, lr << 1);
            }
            if(CPU.cpsr().getZero()) { // ==
              continue jmp_8001b74;
            }
            continue;
          }

          break;
        } while(true);

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
          address8001dbc += 0x4;
          CPU.sp().value = address8001dbc;
          r0 = r1 - r0;
          return r0;
        }
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;
        r3 = r3 + 0x10;
        r12 = r3 & 0xf;

        //LAB_8001d24
        do {
          // Can't be a memcpy because of overlap
          for(int i = 0; i < r12 + 1; i++) {
            MEMORY.set(r1, 1, MEMORY.get(r4, 1));
            r1++;
            r4++;
          }

          r3 = CPU.subA(r3, 0x10);
          r12 = 15; // When looping back it does the full 16 copies
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

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
        if(CPU.cpsr().getZero()) { // ==
          continue jmp_8001b74;
        }
      } while(true);
    } while(true);
  }
}
