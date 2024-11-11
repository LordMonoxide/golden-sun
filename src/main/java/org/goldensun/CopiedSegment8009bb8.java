package org.goldensun;

import java.util.Arrays;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment8009bb8 {
  private CopiedSegment8009bb8() { }

  private static int _8009d90;
  private static final byte[] _8009d9c = new byte[0xe0];

  public static void FUN_8009bb8(int r0, int r1, int r2) {
    // Initialize state to what it would be after copy
    _8009d90 = 0;
    Arrays.fill(_8009d9c, (byte)0);

    int r3;
    int r4;

    //LAB_8009cd0
    switch(r2) {
      case 0:
        //LAB_8009bc0
        r4 = 0xff;
        r2 = r0 & 0x3;
        // This can be misaligned, no$ seems to simply truncate the misalignment
        r3 = MEMORY.ref(4, r0 & ~0x3).getUnsigned();
        r0 += 0x4;

        int i = r2;

        //LAB_8009bd8
        do {
          do {
            for(; i < 3; i++) {
              r2 = r4 & r3 >>> i * 8;
              if(r2 == 0) {
                return;
              }
              CPU.r12().value = CPU.subA(r2, 0xdf);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r1 = r1 + CPU.r12().value;
              } else {
                MEMORY.ref(1, r1).setu(r2);
                r1 = r1 + 0x1;
              }
            }

            // This can be misaligned, no$ seems to simply truncate the misalignment
            r3 = MEMORY.ref(4, r0 & ~0x3).getUnsigned();
            r0 = r0 + 0x4;
            r2 = r3 & r3 >>> 16;
            CPU.setCFlag((r2 & 0x1 << 7) != 0);
            r2 = CPU.andA(r2, r2 >>> 8);
            i = 0;
          } while(CPU.cpsr().getZero()); // ==

          //LAB_8009c38
          do {
            r2 = CPU.andA(r4, r3);
            CPU.r12().value = CPU.subA(r2, 0xdf);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r1 = r1 + CPU.r12().value;
            } else {
              MEMORY.ref(1, r1).setu(r2);
              r1 = r1 + 0x1;
            }
            CPU.setCFlag((r3 & 0x1 << 7) != 0);
            r2 = CPU.andA(r4, r3 >>> 8);
            CPU.r12().value = CPU.subA(r2, 0xdf);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r1 = r1 + CPU.r12().value;
            } else {
              MEMORY.ref(1, r1).setu(r2);
              r1 = r1 + 0x1;
            }
            CPU.setCFlag((r3 & 0x1 << 15) != 0);
            r2 = CPU.andA(r4, r3 >>> 16);
            CPU.r12().value = CPU.subA(r2, 0xdf);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r1 = r1 + CPU.r12().value;
            } else {
              MEMORY.ref(1, r1).setu(r2);
              r1 = r1 + 0x1;
            }
            CPU.setCFlag((r3 & 0x1 << 23) != 0);
            r2 = CPU.andA(r4, r3 >>> 24);
            CPU.r12().value = CPU.subA(r2, 0xdf);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r1 = r1 + CPU.r12().value;
            } else {
              MEMORY.ref(1, r1).setu(r2);
              r1 = r1 + 0x1;
            }
            // This can be misaligned, no$ seems to simply truncate the misalignment
            r3 = MEMORY.ref(4, r0 & ~0x3).getUnsigned();
            r0 += 0x4;
            r2 = r3 & r3 >>> 16;
            CPU.setCFlag((r2 & 0x1 << 7) != 0);
            r2 = CPU.andA(r2, r2 >>> 8);
          } while(!CPU.cpsr().getZero()); // !=
        } while(true);

        // unconditional loop, can't get here/fall through

      case 7, 8:
        //LAB_8009cac
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;

        //LAB_8009cb4
        while(r3 != 0) {
          r3 = CPU.subA(r3, 0xdf);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + r3;
          } else {
            MEMORY.ref(1, r1).setu(0xf);
            r1 = r1 + 0x1;
          }

          r3 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
        }
        break;

      case 9, 10, 11, 12:
        //LAB_8009cfc
        r2 = r2 - 0x2;

        // fall through

      case 1, 2, 3, 4, 5, 6:
        //LAB_8009d00
        if(_8009d90 != r2) {
          _8009d90 = r2;
          MEMORY.getBytes(0x80091b8 + r2 * 0x100, _8009d9c, 0, 0xe0);
        }

        //LAB_8009d64
        //LAB_8009d70
        do {
          while(true) {
            r3 = MEMORY.ref(1, r0).getUnsigned();
            r0 = r0 + 0x1;
            r4 = CPU.subA(r3, 0xdf);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              //LAB_8009d6c
              r1 = r1 + r4;
              continue;
            }
            break;
          }
          if(r3 != 0) {
            MEMORY.ref(1, r1).setu(_8009d9c[r3] & 0xff);
            r1 = r1 + 0x1;
          }
        } while(r3 != 0);
        break;

      case 13:
        //LAB_8009c90
        r2 = MEMORY.ref(4, 0x3001c90).getUnsigned();
        r2 = MEMORY.ref(1, r2).getUnsigned();
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;

        //LAB_8009cb4
        while(r3 != 0) {
          r3 = CPU.subA(r3, 0xdf);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + r3;
          } else {
            MEMORY.ref(1, r1).setu(r2);
            r1 = r1 + 0x1;
          }

          r3 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
        }
        break;

      case 14:
        //LAB_8009ca4
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;

        //LAB_8009cb4
        while(r3 != 0) {
          r3 = CPU.subA(r3, 0xdf);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + r3;
          } else {
            MEMORY.ref(1, r1).setu(0x1);
            r1 = r1 + 0x1;
          }

          r3 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
        }
        break;

      case 15:
        //LAB_8009c9c
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r0 = r0 + 0x1;

        //LAB_8009cb4
        while(r3 != 0) {
          r3 = CPU.subA(r3, 0xdf);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + r3;
          } else {
            MEMORY.ref(1, r1).setu(0);
            r1 = r1 + 0x1;
          }

          r3 = MEMORY.ref(1, r0).getUnsigned();
          r0 = r0 + 0x1;
        }
        break;
    }
  }
}
