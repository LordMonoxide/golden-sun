package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Copied by {@link GoldenSun#FUN_8005394} from 8002808 */
public final class CopiedSegment8002808 {
  private CopiedSegment8002808() { }

  /**
   * This code was really strange, there were a bunch of if/else branches where the else branch
   * could never run, but the else branches were called from other spots. I just moved the else
   * branches to where they were being called from.
   */
  @Method(0x3006000)
  public static int FUN_3006000(int r0, int r1) {
    int r2;
    int r4;
    int r5;
    int r6;
    int r7;

    final int address3006000 = r0;
    r2 = MEMORY.ref(1, address3006000).getUnsigned();
    r0 = r0 + 0x1;
    CPU.cmpA(r2, 0x2);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = 0x4;
      return r0;
    }
    int address3006010 = CPU.sp().value - 0x20;
    CPU.sp().value = address3006010;
    address3006010 += 0x4;
    address3006010 += 0x4;
    address3006010 += 0x4;
    MEMORY.ref(4, address3006010).setu(CPU.r8().value);
    address3006010 += 0x4;
    MEMORY.ref(4, address3006010).setu(CPU.r9().value);
    address3006010 += 0x4;
    MEMORY.ref(4, address3006010).setu(CPU.r10().value);
    address3006010 += 0x4;
    MEMORY.ref(4, address3006010).setu(CPU.r11().value);
    address3006010 += 0x4;
    MEMORY.ref(4, address3006010).setu(CPU.lr().value);

    CPU.r12().value = 0x300601c + 0x24;
    int address3006018 = CPU.r12().value;
    CPU.r10().value = MEMORY.ref(4, address3006018).getUnsigned();
    address3006018 += 0x4;
    CPU.r11().value = MEMORY.ref(4, address3006018).getUnsigned();

    CPU.r12().value = 0xf;
    r1 = r1 - 0x1;
    CPU.r9().value = r1 + 0x21;
    r2 = CPU.andA(r0, 0x1);
    r4 = r2 << 3;
    if(!CPU.cpsr().getZero()) { // !=
      final int address3006030 = r0;
      r2 = MEMORY.ref(1, address3006030).getUnsigned();
      r0 = r0 + 0x1;
    }
    r4 = CPU.subA(r4, 0x10);
    if(CPU.cpsr().getNegative()) { // negative
      final int address30062e0 = r0 + 0x2;
      final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
      r0 = address30062e0;
      r4 = r4 + 0x10;
      r2 = r2 | r3 << r4;
    }

    //LAB_3006108
    do {
      CPU.setCFlag((r2 & 0x1) != 0);
      r2 = CPU.movA(r0, r2 >>> 1);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        //LAB_30060c0
        int address30060c0 = CPU.sp().value - 0x8;
        CPU.sp().value = address30060c0;
        address30060c0 += 0x4;
        MEMORY.ref(4, address30060c0).setu(CPU.r9().value);

        CPU.setCFlag((r2 & 0x1) != 0);
        r2 = CPU.movA(r0, r2 >>> 1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_3006080
          CPU.setCFlag((r2 & 0x1) != 0);
          r2 = CPU.movA(r0, r2 >>> 1);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            //LAB_3006048
            CPU.r8().value = r2 & 0xf;
            CPU.r9().value = 0x3006300;
            FUN_3006300(CPU.r8().value);
            r5 = CPU.r8().value;

            CPU.r8().value = r2 & 0xf0;
            CPU.r9().value = 0x3006300;
            FUN_3006300(CPU.r8().value >>> 4);
            r5 = r5 | CPU.r8().value << 4;

            r2 = r2 >>> 8;
            r4 -= 0xb;
          } else {
            CPU.r8().value = r2 & 0x7;
            CPU.r9().value = 0x3006300;
            FUN_3006300(CPU.r8().value);
            r5 = CPU.r8().value;

            CPU.r8().value = r2 & 0x38;
            CPU.r9().value = 0x3006300;
            FUN_3006300(CPU.r8().value >>> 3);
            r5 = r5 | CPU.r8().value << 4;

            r2 = r2 >>> 6;
            r4 -= 0x9;
          }
        } else {
          CPU.r8().value = r2 & 0x3;
          CPU.r9().value = 0x3006300;
          FUN_3006300(CPU.r8().value);
          r5 = CPU.r8().value;

          CPU.r8().value = r2 & 0xc;
          CPU.r9().value = 0x3006300;
          FUN_3006300(CPU.r8().value >>> 2);
          r5 = r5 | CPU.r8().value << 4;

          r2 = r2 >>> 4;
          r4 -= 0x6;
        }
        if(r4 < 0) {
          final int address30062e0 = r0 + 0x2;
          final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
          r0 = address30062e0;
          r4 = r4 + 0x10;
          r2 = r2 | r3 << r4;
        }

        //LAB_3006100
        final int address3006100 = r1 + 0x1;
        MEMORY.ref(1, address3006100).setu(r5);
        r1 = address3006100;
        int address3006104 = CPU.sp().value;
        address3006104 += 0x4;
        CPU.r9().value = MEMORY.ref(4, address3006104).getUnsigned();
        address3006104 += 0x4;
        CPU.sp().value = address3006104;
        continue;
      }
      CPU.setCFlag((r2 & 0x1) != 0);
      r2 = CPU.movA(r0, r2 >>> 1);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r4 = CPU.subA(r4, 0x2);
        r5 = 0x1;
      } else {
        CPU.setCFlag((r2 & 0x1) != 0);
        r2 = CPU.movA(r0, r2 >>> 1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_3006188
          r4 = CPU.subA(r4, 0x3);
          r5 = 0x2;
        } else {
          CPU.setCFlag((r2 & 0x1) != 0);
          r2 = CPU.movA(r0, r2 >>> 1);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            //LAB_3006194
            r4 = CPU.subA(r4, 0x4);
            r5 = 0x3;
            if(CPU.cpsr().getNegative()) { // negative
              final int address30062e0 = r0 + 0x2;
              final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
              r0 = address30062e0;
              r4 = r4 + 0x10;
              r2 = r2 | r3 << r4;
            }
          } else {
            CPU.setCFlag((r2 & 0x1) != 0);
            r2 = CPU.movA(r0, r2 >>> 1);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_30061a4
              r4 = CPU.subA(r4, 0x5);
              r5 = 0x4;
              if(CPU.cpsr().getNegative()) { // negative
                final int address30062e0 = r0 + 0x2;
                final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
                r0 = address30062e0;
                r4 = r4 + 0x10;
                r2 = r2 | r3 << r4;
              }
            } else {
              CPU.setCFlag((r2 & 0x1) != 0);
              r2 = CPU.movA(r0, r2 >>> 1);
              if(CPU.cpsr().getCarry()) { // unsigned >=
                //LAB_3006150
                r5 = CPU.andA(r2, 0x3);
                r2 = r2 >>> 2;
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_300616c
                  r5 = CPU.andA(r2, 0x7f);
                  if(CPU.cpsr().getZero()) { // ==
                    CPU.r9().value = CPU.r9().value - 0x21;
                    r0 = r1 - CPU.r9().value;
                    int address30062f8 = CPU.sp().value;
                    address30062f8 += 0x4;
                    address30062f8 += 0x4;
                    address30062f8 += 0x4;
                    CPU.r8().value = MEMORY.ref(4, address30062f8).getUnsigned();
                    address30062f8 += 0x4;
                    CPU.r9().value = MEMORY.ref(4, address30062f8).getUnsigned();
                    address30062f8 += 0x4;
                    CPU.r10().value = MEMORY.ref(4, address30062f8).getUnsigned();
                    address30062f8 += 0x4;
                    CPU.r11().value = MEMORY.ref(4, address30062f8).getUnsigned();
                    address30062f8 += 0x4;
                    CPU.lr().value = MEMORY.ref(4, address30062f8).getUnsigned();
                    address30062f8 += 0x4;
                    CPU.sp().value = address30062f8;
                    return r0;
                  }
                  r5 = r5 + 0x9;
                  r2 = r2 >>> 7;
                  r4 = CPU.subA(r4, 0xf);
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address30062e0 = r0 + 0x2;
                    final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
                    r0 = address30062e0;
                    r4 = r4 + 0x10;
                    r2 = r2 | r3 << r4;
                  }
                } else {
                  r5 = r5 + 0x6;
                  r4 = CPU.subA(r4, 0x8);
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address30062e0 = r0 + 0x2;
                    final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
                    r0 = address30062e0;
                    r4 = r4 + 0x10;
                    r2 = r2 | r3 << r4;
                  }
                }
              } else {
                CPU.setCFlag((r2 & 0x1) != 0);
                r2 = CPU.movA(r0, r2 >>> 1);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  //LAB_30061b4
                  r4 = CPU.subA(r4, 0x7);
                  r5 = 0x5;
                  if(CPU.cpsr().getNegative()) { // negative
                    if(CPU.cpsr().getNegative()) { // negative
                      final int address30062e0 = r0 + 0x2;
                      final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
                      r0 = address30062e0;
                      r4 = r4 + 0x10;
                      r2 = r2 | r3 << r4;
                    } else {
                      r4 = CPU.subA(r4, 0x2);
                      r5 = 0x1;
                    }
                  }
                } else {
                  r4 = CPU.subA(r4, 0x7);
                  r5 = 0x6;
                  if(CPU.cpsr().getNegative()) { // negative
                    final int address30062e0 = r0 + 0x2;
                    final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
                    r0 = address30062e0;
                    r4 = r4 + 0x10;
                    r2 = r2 | r3 << r4;
                  }
                }
              }
            }
          }
        }
      }

      //LAB_30061cc
      CPU.setCFlag((r2 & 0x1) != 0);
      r2 = CPU.movA(r0, r2 >>> 1);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        //LAB_3006210
        r6 = r1 - CPU.r9().value;
        CPU.cmpA(r6, 0x800);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          r6 = Integer.rotateRight(r2, 12);
          r2 = r2 >>> 12;
          r6 = r6 >>> 20;
          r6 = r6 + 0x20;
          r4 = CPU.subA(r4, 0xd);
        } else {
          //LAB_3006234
          r7 = 0xb;
          CPU.setCFlag((r6 & 0x1 << 10) != 0);
          r6 = CPU.movA(r0, r6 << 22);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r7 = r7 - 0x1;
            CPU.setCFlag((r6 & 0x1 << 31) != 0);
            r6 = CPU.movA(r0, r6 << 1);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r7 = r7 - 0x1;
              CPU.setCFlag((r6 & 0x1 << 31) != 0);
              r6 = CPU.movA(r0, r6 << 1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r7 - 0x1;
                CPU.setCFlag((r6 & 0x1 << 31) != 0);
                r6 = CPU.movA(r0, r6 << 1);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  r7 = r7 - 0x1;
                  CPU.setCFlag((r6 & 0x1 << 31) != 0);
                  r6 = CPU.movA(r0, r6 << 1);
                  if(!CPU.cpsr().getCarry()) { // unsigned <
                    r7 = r7 - 0x1;
                    CPU.setCFlag((r6 & 0x1 << 31) != 0);
                    r6 = CPU.movA(r0, r6 << 1);
                    if(!CPU.cpsr().getCarry()) { // unsigned <
                      r7 = r7 - 0x1;
                      CPU.setCFlag((r6 & 0x1 << 31) != 0);
                      r6 = CPU.movA(r0, r6 << 1);
                      if(!CPU.cpsr().getCarry()) { // unsigned <
                        r7 = r7 - 0x1;
                        CPU.setCFlag((r6 & 0x1 << 31) != 0);
                        r6 = CPU.movA(r0, r6 << 1);
                        if(!CPU.cpsr().getCarry()) { // unsigned <
                          r7 = r7 - 0x1;
                          CPU.setCFlag((r6 & 0x1 << 31) != 0);
                          r6 = CPU.movA(r0, r6 << 1);
                          if(!CPU.cpsr().getCarry()) { // unsigned <
                            r7 = r7 - 0x1;
                            CPU.setCFlag((r6 & 0x1 << 31) != 0);
                            r6 = CPU.movA(r0, r6 << 1);
                            if(!CPU.cpsr().getCarry()) { // unsigned <
                              r7 = r7 - 0x1;
                              CPU.setCFlag((r6 & 0x1 << 31) != 0);
                              r6 = CPU.movA(r0, r6 << 1);
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

          //LAB_30062bc
          r6 = 0x1;
          r6 = (r6 << r7) - r6;
          r6 = r2 & r6;
          r6 = r6 + 0x20;
          r2 = r2 >>> r7;
          r4 = r4 - 0x1;
          r4 = CPU.subA(r4, r7);
        }
      } else {
        r6 = r2 & 0x1f;
        r4 = CPU.subA(r4, 0x6);
        r2 = r2 >>> 5;
      }

      //LAB_30061e0
      if(CPU.cpsr().getNegative()) { // negative
        final int address30062e0 = r0 + 0x2;
        final int r3 = MEMORY.ref(2, address30062e0).getUnsigned();
        r0 = address30062e0;
        r4 = r4 + 0x10;
        r2 = r2 | r3 << r4;
      }
      final int address30061e4 = r1 - r6;
      r7 = MEMORY.ref(1, address30061e4).getUnsigned();
      final int address30061e8 = r1 + 0x1;
      MEMORY.ref(1, address30061e8).setu(r7);
      r1 = address30061e8;

      //LAB_30061ec
      do {
        final int address30061ec = r1 - r6;
        r7 = MEMORY.ref(1, address30061ec).getUnsigned();
        final int address30061f0 = r1 + 0x1;
        MEMORY.ref(1, address30061f0).setu(r7);
        r1 = address30061f0;
        r5 = CPU.subA(r5, 0x1);
        if(CPU.cpsr().getZero()) { // ==
          break;
        }
        final int address30061fc = r1 - r6;
        r7 = MEMORY.ref(1, address30061fc).getUnsigned();
        final int address3006200 = r1 + 0x1;
        MEMORY.ref(1, address3006200).setu(r7);
        r1 = address3006200;
        r5 = CPU.subA(r5, 0x1);
      } while(!CPU.cpsr().getZero()); // !=
    } while(true);
  }

  @Method(0x3006300)
  public static void FUN_3006300(final int val) {
    switch(val) {
      case 0 ->
        CPU.r8().value = CPU.r12().value & CPU.r11().value;

      case 1 -> {
        CPU.r9().value = CPU.r11().value >>> 8;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 28;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 4;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 24);
      }

      case 2 -> {
        CPU.r9().value = CPU.r11().value >>> 12;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 24;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 8;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 20);
      }

      case 3 -> {
        CPU.r9().value = CPU.r11().value >>> 16;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 20;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 12;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 16);
      }

      case 4 -> {
        CPU.r9().value = CPU.r11().value >>> 20;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 16;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 16;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 12);
      }

      case 5 -> {
        CPU.r9().value = CPU.r11().value >>> 24;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 12;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 20;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 8);
      }

      case 6 -> {
        CPU.r9().value = CPU.r11().value >>> 28;
        CPU.r9().value = CPU.r9().value | CPU.r11().value << 8;
        CPU.r8().value = CPU.r12().value & CPU.r11().value >>> 24;
        CPU.r11().value = CPU.r8().value | Integer.rotateRight(CPU.r9().value, 4);
      }

      case 7 -> {
        CPU.r11().value = Integer.rotateRight(CPU.r11().value, 28);
        CPU.r8().value = CPU.r12().value & CPU.r11().value;
      }

      case 8 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value;
        CPU.r9().value = CPU.r10().value & ~0xf;
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 9 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 4;
        CPU.r9().value = CPU.r10().value >>> 8;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 28;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 24);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 10 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 8;
        CPU.r9().value = CPU.r10().value >>> 12;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 24;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 20);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 11 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 12;
        CPU.r9().value = CPU.r10().value >>> 16;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 20;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 16);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 12 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 16;
        CPU.r9().value = CPU.r10().value >>> 20;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 16;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 12);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 13 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 20;
        CPU.r9().value = CPU.r10().value >>> 24;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 12;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 8);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 14 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 24;
        CPU.r9().value = CPU.r10().value >>> 28;
        CPU.r9().value = CPU.r9().value | CPU.r10().value << 8;
        CPU.r9().value = Integer.rotateRight(CPU.r9().value, 4);
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }

      case 15 -> {
        CPU.r8().value = CPU.r12().value & CPU.r10().value >>> 28;
        CPU.r9().value = CPU.r10().value << 4;
        CPU.r10().value = CPU.r9().value | CPU.r11().value >>> 28;
        CPU.r11().value = CPU.r8().value | CPU.r11().value << 4;
      }
    }
  }
}
