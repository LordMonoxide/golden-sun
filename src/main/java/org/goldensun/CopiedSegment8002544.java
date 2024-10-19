package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_8005340} from 8002544 */
public final class CopiedSegment8002544 {
  private CopiedSegment8002544() { }

  @Method(0x3002000)
  public static int FUN_3002000(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    int address3002000 = CPU.sp().value - 0x14;
    CPU.sp().value = address3002000;
    address3002000 += 0x4;
    address3002000 += 0x4;
    address3002000 += 0x4;
    MEMORY.ref(4, address3002000).setu(CPU.r9().value);
    address3002000 += 0x4;
    MEMORY.ref(4, address3002000).setu(CPU.lr().value);
    address3002000 += 0x4;
    final int address3002004 = r0;
    r2 = MEMORY.ref(1, address3002004).getUnsigned();
    r0 = r0 + 0x1;
    CPU.cmpA(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //r0 = FUN_3002244(); //TODO JUMP
      throw new RuntimeException("?");
    }

    r1 = r1 - 0x1;
    CPU.r9().value = r1 + 0x21;
    r2 = CPU.andA(r0, 0x1);
    r4 = (r2 << 3);
    if(!CPU.cpsr().getZero()) { // !=
      final int address3002020 = r0;
      r2 = MEMORY.ref(1, address3002020).getUnsigned();
      r0 = r0 + 0x1;
    }
    r4 = CPU.subA(r4, 0x10);
    if(CPU.cpsr().getNegative()) { // negative
      final int address3002224 = r0 + 0x2;
      r3 = MEMORY.ref(2, address3002224).getUnsigned();
      r0 = address3002224;
      r4 = r4 + 0x10;
      r2 = r2 | ((r3 << r4));
    }

    //LAB_3002048
    while(true) {
      CPU.setCFlag((r2 & 0x1 << 0) != 0);
      r2 = CPU.movA(r0, (r2 >>> 1));

      //LAB_3002030
      while(CPU.cpsr().getCarry()) { // unsigned >=
        final int address3002030 = r1 + 0x1;
        MEMORY.ref(1, address3002030).setu(r2);
        r1 = address3002030;
        r2 = (r2 >>> 8);
        r4 = CPU.subA(r4, 0x9);
        if(CPU.cpsr().getNegative()) { // negative
          final int address300203c = r0 + 0x2;
          r3 = MEMORY.ref(2, address300203c).getUnsigned();
          r0 = address300203c;
          r4 = r4 + 0x10;
          r2 = r2 | ((r3 << r4));
        }

        CPU.setCFlag((r2 & 0x1 << 0) != 0);
        r2 = CPU.movA(r0, (r2 >>> 1));
      }

      CPU.setCFlag((r2 & 0x1 << 0) != 0);
      r2 = CPU.movA(r0, (r2 >>> 1));
      if(!CPU.cpsr().getCarry()) { // unsigned <
        //LAB_3002104
        r4 = CPU.subA(r4, 0x2);
        r5 = 0x2;
      } else {
        CPU.setCFlag((r2 & 0x1 << 0) != 0);
        r2 = CPU.movA(r0, (r2 >>> 1));
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_30020c8
          r4 = CPU.subA(r4, 0x3);
          r5 = 0x3;
        } else {
          CPU.setCFlag((r2 & 0x1 << 0) != 0);
          r2 = CPU.movA(r0, (r2 >>> 1));
          if(!CPU.cpsr().getCarry()) { // unsigned <
            //LAB_30020d4
            r4 = CPU.subA(r4, 0x4);
            r5 = 0x4;
            if(CPU.cpsr().getNegative()) { // negative
              final int address3002224 = r0 + 0x2;
              r3 = MEMORY.ref(2, address3002224).getUnsigned();
              r0 = address3002224;
              r4 = r4 + 0x10;
              r2 = r2 | ((r3 << r4));
            }
          } else {
            CPU.setCFlag((r2 & 0x1 << 0) != 0);
            r2 = CPU.movA(r0, (r2 >>> 1));
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_30020e4
              r4 = CPU.subA(r4, 0x5);
              r5 = 0x5;
              if(CPU.cpsr().getNegative()) { // negative
                final int address3002224 = r0 + 0x2;
                r3 = MEMORY.ref(2, address3002224).getUnsigned();
                r0 = address3002224;
                r4 = r4 + 0x10;
                r2 = r2 | ((r3 << r4));
              }
            } else {
              CPU.setCFlag((r2 & 0x1 << 0) != 0);
              r2 = CPU.movA(r0, (r2 >>> 1));
              if(!CPU.cpsr().getCarry()) { // unsigned <
                CPU.setCFlag((r2 & 0x1 << 0) != 0);
                r2 = CPU.movA(r0, (r2 >>> 1));
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  //LAB_30020f4
                  r4 = CPU.subA(r4, 0x7);
                  r5 = 0x6;
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address3002224 = r0 + 0x2;
                    r3 = MEMORY.ref(2, address3002224).getUnsigned();
                    r0 = address3002224;
                    r4 = r4 + 0x10;
                    r2 = r2 | ((r3 << r4));
                  }
                } else {
                  r4 = CPU.subA(r4, 0x7);
                  r5 = 0x7;
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address3002224 = r0 + 0x2;
                    r3 = MEMORY.ref(2, address3002224).getUnsigned();
                    r0 = address3002224;
                    r4 = r4 + 0x10;
                    r2 = r2 | ((r3 << r4));
                  }
                }
              } else {
                //LAB_3002090
                r5 = CPU.andA(r2, 0x3);
                r2 = (r2 >>> 2);
                if(!CPU.cpsr().getZero()) { // !=
                  r5 = r5 + 0x7;
                  r4 = CPU.subA(r4, 0x8);
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address3002224 = r0 + 0x2;
                    r3 = MEMORY.ref(2, address3002224).getUnsigned();
                    r0 = address3002224;
                    r4 = r4 + 0x10;
                    r2 = r2 | ((r3 << r4));
                  }
                } else {
                  //LAB_30020ac
                  r5 = CPU.andA(r2, 0x7f);
                  if(CPU.cpsr().getZero()) { // ==
                    CPU.r9().value = CPU.r9().value - 0x21;
                    r0 = r1 - (CPU.r9().value);
                    int address300223c = CPU.sp().value;
                    r5 = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    r6 = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    r7 = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    CPU.r9().value = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    CPU.lr().value = MEMORY.ref(4, address300223c).getUnsigned();
                    address300223c += 0x4;
                    CPU.sp().value = address300223c;
                    return r0;
                  }
                  r5 = r5 + 0xa;
                  r2 = (r2 >>> 7);
                  r4 = CPU.subA(r4, 0xf);
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address3002224 = r0 + 0x2;
                    r3 = MEMORY.ref(2, address3002224).getUnsigned();
                    r0 = address3002224;
                    r4 = r4 + 0x10;
                    r2 = r2 | ((r3 << r4));
                  }
                }
              }
            }
          }
        }
      }

      //LAB_300210c
      CPU.setCFlag((r2 & 0x1 << 0) != 0);
      r2 = CPU.movA(0, (r2 >>> 1));
      if(!CPU.cpsr().getCarry()) { // unsigned <
        //LAB_3002154
        r6 = r1 - (CPU.r9().value);
        CPU.cmpA(r6, 0x800);
        CPU.setCFlag(false);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          r6 = Integer.rotateRight(r2, 12);
          r2 = (r2 >>> 12);
          r6 = (r6 >>> 20);
          r6 = r6 + 0x20;
          r4 = CPU.subA(r4, 0xd);
        } else {
          //LAB_3002178
          r7 = 0xb;
          CPU.setCFlag((r6 & 0x1 << 10) != 0);
          r6 = CPU.movA(0, (r6 << 22));
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r7 = r7 - 0x1;
            CPU.setCFlag((r6 & 0x1 << 31) != 0);
            r6 = CPU.movA(0, (r6 << 1));
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r7 = r7 - 0x1;
              CPU.setCFlag((r6 & 0x1 << 31) != 0);
              r6 = CPU.movA(0, (r6 << 1));
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r7 - 0x1;
                CPU.setCFlag((r6 & 0x1 << 31) != 0);
                r6 = CPU.movA(0, (r6 << 1));
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  r7 = r7 - 0x1;
                  CPU.setCFlag((r6 & 0x1 << 31) != 0);
                  r6 = CPU.movA(0, (r6 << 1));
                  if(!CPU.cpsr().getCarry()) { // unsigned <
                    r7 = r7 - 0x1;
                    CPU.setCFlag((r6 & 0x1 << 31) != 0);
                    r6 = CPU.movA(0, (r6 << 1));
                    if(!CPU.cpsr().getCarry()) { // unsigned <
                      r7 = r7 - 0x1;
                      CPU.setCFlag((r6 & 0x1 << 31) != 0);
                      r6 = CPU.movA(0, (r6 << 1));
                      if(!CPU.cpsr().getCarry()) { // unsigned <
                        r7 = r7 - 0x1;
                        CPU.setCFlag((r6 & 0x1 << 31) != 0);
                        r6 = CPU.movA(0, (r6 << 1));
                        if(!CPU.cpsr().getCarry()) { // unsigned <
                          r7 = r7 - 0x1;
                          CPU.setCFlag((r6 & 0x1 << 31) != 0);
                          r6 = CPU.movA(0, (r6 << 1));
                          if(!CPU.cpsr().getCarry()) { // unsigned <
                            r7 = r7 - 0x1;
                            CPU.setCFlag((r6 & 0x1 << 31) != 0);
                            r6 = CPU.movA(0, (r6 << 1));
                            if(!CPU.cpsr().getCarry()) { // unsigned <
                              r7 = r7 - 0x1;
                              CPU.setCFlag((r6 & 0x1 << 31) != 0);
                              r6 = CPU.movA(0, (r6 << 1));
                              if(!CPU.cpsr().getCarry()) { // unsigned <
                                r7 = r7 - 0x1;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          //LAB_3002200
          r6 = 0x1;
          r6 = ((r6 << r7)) - r6;
          r6 = r2 & (r6);
          r6 = r6 + 0x20;
          r2 = (r2 >>> r7);
          r4 = r4 - 0x1;
          r4 = CPU.subA(r4, r7);
        }
      } else {
        r6 = r2 & 0x1f;
        r4 = CPU.subA(r4, 0x6);
        r2 = (r2 >>> 5);
      }

      //LAB_3002120
      if(CPU.cpsr().getNegative()) { // negative
        final int address3002120 = r0 + 0x2;
        r3 = MEMORY.ref(2, address3002120).getUnsigned();
        r0 = address3002120;
        r4 = r4 + 0x10;
        r2 = r2 | ((r3 << r4));
      }
      CPU.setCFlag((r5 & 0x1 << 0) != 0);
      r5 = CPU.movA(r0, (r5 >>> 1));
      if(CPU.cpsr().getCarry()) { // unsigned >=
        final int address3002130 = r1 - r6;
        r7 = MEMORY.ref(1, address3002130).getUnsigned();
        final int address3002134 = r1 + 0x1;
        MEMORY.ref(1, address3002134).setu(r7);
        r1 = address3002134;
      }

      //LAB_3002138
      do {
        final int address3002138 = r1 - r6;
        r7 = MEMORY.ref(1, address3002138).getUnsigned();
        final int address300213c = r1 + 0x1;
        MEMORY.ref(1, address300213c).setu(r7);
        r1 = address300213c;
        final int address3002140 = r1 - r6;
        r7 = MEMORY.ref(1, address3002140).getUnsigned();
        final int address3002144 = r1 + 0x1;
        MEMORY.ref(1, address3002144).setu(r7);
        r1 = address3002144;
        r5 = CPU.subA(r5, 0x1);
      } while(!CPU.cpsr().getZero()); // !=
    }
  }
}
