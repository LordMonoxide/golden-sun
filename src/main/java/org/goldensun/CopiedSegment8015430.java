package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun_801#FUN_80196c4} from 8015430 */
public final class CopiedSegment8015430 {
  private CopiedSegment8015430() { }

  public static int FUN_8015430(final int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.sp().value = CPU.sp().value - 0x8;
    int address3002004 = r0;
    r1 = MEMORY.ref(4, address3002004).getUnsigned();
    address3002004 += 0x4;
    r2 = MEMORY.ref(4, address3002004).getUnsigned();
    address3002004 += 0x4;
    r3 = MEMORY.ref(4, address3002004).getUnsigned();

    r4 = r1 >>> 8;

    int address3002014 = 0x803842c + r4 * 0x8;
    r4 = MEMORY.ref(4, address3002014).getUnsigned();
    address3002014 += 0x4;
    r5 = MEMORY.ref(4, address3002014).getUnsigned();

    r5 = MEMORY.ref(2, r5 + (r1 & 0xff) * 0x2).getUnsigned();
    r4 = r4 + r5;
    r5 = r4;
    CPU.r12().value = 0x1;
    r6 = CPU.andA(r4, 0x3);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = CPU.rsbA(CPU.r12().value, r6 << 3);
      r4 = r4 & ~0x3;
      CPU.r12().value = MEMORY.ref(4, r4).getUnsigned();
      r4 = r4 + 0x4;
      CPU.r12().value = (CPU.cpsr().getCarry() ? 0x8000_0000 : 0) | CPU.r12().value >>> 1;
      CPU.r12().value = CPU.r12().value >>> r6;
      r6 = 0x0;
    }

    //LAB_3002050
    do {
      CPU.setCFlag((CPU.r12().value & 0x1) != 0);
      CPU.r12().value = CPU.movA(0, CPU.r12().value >>> 1);
      if(CPU.cpsr().getZero()) { // ==
        CPU.r12().value = MEMORY.ref(4, r4).getUnsigned();
        r4 = r4 + 0x4;
      }
      if(CPU.cpsr().getZero()) { // ==
        final boolean oldCarry3002058 = CPU.cpsr().getCarry();
        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
        CPU.r12().value = CPU.movA(0, (oldCarry3002058 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
      }
      if(CPU.cpsr().getCarry()) { // unsigned >=
        break;
      }
      CPU.setCFlag((r3 & 0x1) != 0);
      r3 = CPU.movA(0, r3 >>> 1);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        continue;
      }
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r2).getUnsigned();
        r2 = r2 + 0x4;
      }
      if(CPU.cpsr().getZero()) { // ==
        final boolean oldCarry300206c = CPU.cpsr().getCarry();
        CPU.setCFlag((r3 & 0x1) != 0);
        r3 = CPU.movA(0, (oldCarry300206c ? 0x8000_0000 : 0) | r3 >>> 1);
      }
      if(!CPU.cpsr().getCarry()) { // unsigned <
        continue;
      }
      r1 = 0x0;

      //LAB_3002078
      do {
        do {
          jmp_30020e0:
          do {
            jmp_30020c0:
            do {
              do {
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  break jmp_30020e0;
                }
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  break;
                }
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  //LAB_30020a0
                  r1 = r1 + 0x1;
                  break;
                }
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  break jmp_30020c0;
                }
                r1 = r1 + 0x4;
              } while(true);

              //LAB_30020a4
              if(!CPU.cpsr().getZero()) { // !=
                r6 = r6 + 0x1;
              }
              if(CPU.cpsr().getZero()) { // ==
                CPU.r12().value = MEMORY.ref(4, r4).getUnsigned();
                r4 = r4 + 0x4;
                final boolean oldCarry30020b0 = CPU.cpsr().getCarry();
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(0, (oldCarry30020b0 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  r1 = r1 + 0x2;
                }
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  r6 = r6 + 0x1;
                }
              }
            } while(true);

            //LAB_30020c0
            r1 = r1 + 0x2;
            if(!CPU.cpsr().getZero()) { // !=
              r6 = r6 + 0x1;
            }
            if(CPU.cpsr().getZero()) { // ==
              CPU.r12().value = MEMORY.ref(4, r4).getUnsigned();
              r4 = r4 + 0x4;
              final boolean oldCarry30020d0 = CPU.cpsr().getCarry();
              CPU.setCFlag((CPU.r12().value & 0x1) != 0);
              CPU.r12().value = CPU.movA(0, (oldCarry30020d0 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r1 = r1 + 0x2;
              }
              if(CPU.cpsr().getCarry()) { // unsigned >=
                r6 = r6 + 0x1;
              }
            }
          } while(true);

          //LAB_30020e0
          if(!CPU.cpsr().getZero()) { // !=
            break;
          }

          //LAB_30020f4
          CPU.r12().value = MEMORY.ref(4, r4).getUnsigned();
          r4 = r4 + 0x4;
          final boolean oldCarry30020f8 = CPU.cpsr().getCarry();
          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
          CPU.r12().value = CPU.movA(0, (oldCarry30020f8 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
          if(CPU.cpsr().getCarry()) { // unsigned >=
            break;
          }
          r1 = r1 + 0x1;
        } while(true);

        //LAB_30020e4
        r6 = r6 + 0x1;
        r1 = CPU.subA(r1, 0x1);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
    } while(true);

    //LAB_3002108
    CPU.setCFlag((r6 & 0x1) != 0);
    r1 = CPU.movA(0, r6 >>> 1);
    r6 = r6 + r1;
    r6 = r5 - r6;
    final int address3002114 = r6 - 0x1;
    r5 = MEMORY.ref(1, address3002114).getUnsigned();
    final int address3002118 = r6 - 0x2;
    r6 = MEMORY.ref(1, address3002118).getUnsigned();
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r1 = r5 & 0xf;
    }
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r1 = r6 | r1 << 8;
    }
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r1 = r5 << 4;
    }
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r1 = r1 | r6 >>> 4;
    }
    int address300212c = r0;
    MEMORY.ref(4, address300212c).setu(r1);
    address300212c += 0x4;
    MEMORY.ref(4, address300212c).setu(r2);
    address300212c += 0x4;
    MEMORY.ref(4, address300212c).setu(r3);

    int address3002134 = CPU.sp().value;
    address3002134 += 0x4;
    address3002134 += 0x4;
    CPU.sp().value = address3002134;
    return r1;
  }
}
