package org.goldensun;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class CopiedSegment8015afc {
  private CopiedSegment8015afc() { }

  public static void FUN_8015afc(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;

    r2 = 0xfedcba98;
    r3 = 0x76543210;

    r5 = 0xf;
    CPU.r12().value = 0x1;
    r6 = CPU.andA(r0, 0x3);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = CPU.rsbA(CPU.r12().value, r6 << 3);
      r0 = r0 & ~0x3;
      CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
      r0 = r0 + 0x4;
      CPU.r12().value = (CPU.cpsr().getCarry() ? 0x8000_0000 : 0) | CPU.r12().value >>> 1;
      CPU.r12().value = CPU.r12().value >>> r6;
    }

    // Hack for complicated jump
    boolean skip = false;

    CPU.setCFlag((CPU.r12().value & 0x1) != 0);
    CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r6 = r3 & r5;
    } else {
      skip = true;
    }

    //LAB_8015b44
    do {
      if(!skip) {
        MEMORY.ref(1, r1).setu(r6);
        r1 = r1 + 0x1;
        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
        CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(1, r1).setu(r6);
          r1 = r1 + 0x1;

          //LAB_8015b54
          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
          CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r6 = r3 & r5;
            continue;
          }
        }
      }

      skip = false;

      //LAB_8015b5c
      if(CPU.cpsr().getZero()) { // ==
        CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
        r0 = r0 + 0x4;
        final boolean oldCarry8015b60 = CPU.cpsr().getCarry();
        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
        CPU.r12().value = CPU.movA(r0, (oldCarry8015b60 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
      }
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r6 = r3 & r5;
      } else {
        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
        CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
        if(CPU.cpsr().getZero()) { // ==
          CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
          r0 = r0 + 0x4;
          final boolean oldCarry8015b70 = CPU.cpsr().getCarry();
          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
          CPU.r12().value = CPU.movA(r0, (oldCarry8015b70 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
        }
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_8015d10
          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
          CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
          if(CPU.cpsr().getZero()) { // ==
            CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
            r0 = r0 + 0x4;
            final boolean oldCarry8015d18 = CPU.cpsr().getCarry();
            CPU.setCFlag((CPU.r12().value & 0x1) != 0);
            CPU.r12().value = CPU.movA(r0, (oldCarry8015d18 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
          }
          if(CPU.cpsr().getCarry()) { // unsigned >=
            CPU.setCFlag((CPU.r12().value & 0x1) != 0);
            CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
            if(CPU.cpsr().getZero()) { // ==
              CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
              r0 = r0 + 0x4;
              final boolean oldCarry8015d28 = CPU.cpsr().getCarry();
              CPU.setCFlag((CPU.r12().value & 0x1) != 0);
              CPU.r12().value = CPU.movA(r0, (oldCarry8015d28 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
            }
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r4 = r3 >>> 12;
              r4 = r4 | r3 << 24;
              r6 = r5 & r3 >>> 8;
              r3 = r6 | Integer.rotateRight(r4, 20);
            } else {
              //LAB_8015d44
              r4 = r3 >>> 16;
              r4 = r4 | r3 << 20;
              r6 = r5 & r3 >>> 12;
              r3 = r6 | Integer.rotateRight(r4, 16);
            }
          } else {
            //LAB_8015d58
            r4 = r3 >>> 8;
            r4 = r4 | r3 << 28;
            r6 = r5 & r3 >>> 4;
            r3 = r6 | Integer.rotateRight(r4, 24);
          }
        } else {
          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
          CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
          if(CPU.cpsr().getZero()) { // ==
            CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
            r0 = r0 + 0x4;
            final boolean oldCarry8015b80 = CPU.cpsr().getCarry();
            CPU.setCFlag((CPU.r12().value & 0x1) != 0);
            CPU.r12().value = CPU.movA(r0, (oldCarry8015b80 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
          }
          if(!CPU.cpsr().getCarry()) { // unsigned <
            //LAB_8015cd8
            CPU.setCFlag((CPU.r12().value & 0x1) != 0);
            CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
            if(CPU.cpsr().getZero()) { // ==
              CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
              r0 = r0 + 0x4;
              final boolean oldCarry8015ce0 = CPU.cpsr().getCarry();
              CPU.setCFlag((CPU.r12().value & 0x1) != 0);
              CPU.r12().value = CPU.movA(r0, (oldCarry8015ce0 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
            }
            if(CPU.cpsr().getCarry()) { // unsigned >=
              r4 = r3 >>> 24;
              r4 = r4 | r3 << 12;
              r6 = r5 & r3 >>> 20;
              r3 = r6 | Integer.rotateRight(r4, 8);
            } else {
              //LAB_8015cfc
              r4 = r3 >>> 20;
              r4 = r4 | r3 << 16;
              r6 = r5 & r3 >>> 16;
              r3 = r6 | Integer.rotateRight(r4, 12);
            }
          } else {
            CPU.setCFlag((CPU.r12().value & 0x1) != 0);
            CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
            if(CPU.cpsr().getZero()) { // ==
              CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
              r0 = r0 + 0x4;
              final boolean oldCarry8015b90 = CPU.cpsr().getCarry();
              CPU.setCFlag((CPU.r12().value & 0x1) != 0);
              CPU.r12().value = CPU.movA(r0, (oldCarry8015b90 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
            }
            if(CPU.cpsr().getCarry()) { // unsigned >=
              //LAB_8015bac
              CPU.setCFlag((CPU.r12().value & 0x1) != 0);
              CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
              if(CPU.cpsr().getZero()) { // ==
                CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                r0 = r0 + 0x4;
                final boolean oldCarry8015bb4 = CPU.cpsr().getCarry();
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(r0, (oldCarry8015bb4 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
              }
              if(CPU.cpsr().getCarry()) { // unsigned >=
                //LAB_8015be4
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getZero()) { // ==
                  CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                  r0 = r0 + 0x4;
                  final boolean oldCarry8015bec = CPU.cpsr().getCarry();
                  CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                  CPU.r12().value = CPU.movA(r0, (oldCarry8015bec ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                }
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  //LAB_8015c08
                  CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                  CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                  if(CPU.cpsr().getZero()) { // ==
                    CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                    r0 = r0 + 0x4;
                  }
                  if(CPU.cpsr().getZero()) { // ==
                    final boolean oldCarry8015c10 = CPU.cpsr().getCarry();
                    CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                    CPU.r12().value = CPU.movA(r0, (oldCarry8015c10 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                  }
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    //LAB_8015c50
                    CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                    CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                    if(CPU.cpsr().getZero()) { // ==
                      CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                      r0 = r0 + 0x4;
                    }
                    if(CPU.cpsr().getZero()) { // ==
                      final boolean oldCarry8015c58 = CPU.cpsr().getCarry();
                      CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                      CPU.r12().value = CPU.movA(r0, (oldCarry8015c58 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                    }
                    if(CPU.cpsr().getCarry()) { // unsigned >=
                      //LAB_8015c74
                      CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                      CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                      if(CPU.cpsr().getZero()) { // ==
                        CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                        r0 = r0 + 0x4;
                      }
                      if(CPU.cpsr().getZero()) { // ==
                        final boolean oldCarry8015c7c = CPU.cpsr().getCarry();
                        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                        CPU.r12().value = CPU.movA(r0, (oldCarry8015c7c ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                      }
                      if(CPU.cpsr().getCarry()) { // unsigned >=
                        //LAB_8015cbc
                        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                        CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                        if(CPU.cpsr().getZero()) { // ==
                          CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                          r0 = r0 + 0x4;
                        }
                        if(CPU.cpsr().getZero()) { // ==
                          final boolean oldCarry8015cc4 = CPU.cpsr().getCarry();
                          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                          CPU.r12().value = CPU.movA(r0, (oldCarry8015cc4 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                        }
                        if(CPU.cpsr().getCarry()) { // unsigned >=
                          //LAB_8015d6c
                          return;
                        }
                        r6 = r5 & r2 >>> 28;
                        r4 = r2 << 4;
                      } else {
                        CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                        CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                        if(CPU.cpsr().getZero()) { // ==
                          CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                          r0 = r0 + 0x4;
                          final boolean oldCarry8015c8c = CPU.cpsr().getCarry();
                          CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                          CPU.r12().value = CPU.movA(r0, (oldCarry8015c8c ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                        }
                        if(!CPU.cpsr().getCarry()) { // unsigned <
                          r6 = r5 & r2 >>> 20;
                          r4 = r2 >>> 24;
                          r4 = r4 | r2 << 12;
                          r4 = Integer.rotateRight(r4, 8);
                        } else {
                          //LAB_8015ca8
                          r6 = r5 & r2 >>> 24;
                          r4 = r2 >>> 28;
                          r4 = r4 | r2 << 8;
                          r4 = Integer.rotateRight(r4, 4);
                        }
                      }
                    } else {
                      r6 = r5 & r2 >>> 16;
                      r4 = r2 >>> 20;
                      r4 = r4 | r2 << 16;
                      r4 = Integer.rotateRight(r4, 12);
                    }
                  } else {
                    CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                    CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                    if(CPU.cpsr().getZero()) { // ==
                      CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                      r0 = r0 + 0x4;
                      final boolean oldCarry8015c20 = CPU.cpsr().getCarry();
                      CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                      CPU.r12().value = CPU.movA(r0, (oldCarry8015c20 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                    }
                    if(!CPU.cpsr().getCarry()) { // unsigned <
                      r6 = r5 & r2 >>> 8;
                      r4 = r2 >>> 12;
                      r4 = r4 | r2 << 24;
                      r4 = Integer.rotateRight(r4, 20);
                    } else {
                      //LAB_8015c3c
                      r6 = r5 & r2 >>> 12;
                      r4 = r2 >>> 16;
                      r4 = r4 | r2 << 20;
                      r4 = Integer.rotateRight(r4, 16);
                    }
                  }
                } else {
                  r6 = r5 & r2 >>> 4;
                  r4 = r2 >>> 8;
                  r4 = r4 | r2 << 28;
                  r4 = Integer.rotateRight(r4, 24);
                }
                r2 = r4 | r3 >>> 28;
                r3 = r6 | r3 << 4;
              } else {
                CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                CPU.r12().value = CPU.movA(r0, CPU.r12().value >>> 1);
                if(CPU.cpsr().getZero()) { // ==
                  CPU.r12().value = MEMORY.ref(4, r0).getUnsigned();
                  r0 = r0 + 0x4;
                  final boolean oldCarry8015bc4 = CPU.cpsr().getCarry();
                  CPU.setCFlag((CPU.r12().value & 0x1) != 0);
                  CPU.r12().value = CPU.movA(r0, (oldCarry8015bc4 ? 0x8000_0000 : 0) | CPU.r12().value >>> 1);
                }
                if(CPU.cpsr().getCarry()) { // unsigned >=
                  //LAB_8015bd8
                  r6 = r5 & r2;
                  r4 = r2 & ~0xf;
                  r2 = r4 | r3 >>> 28;
                  r3 = r6 | r3 << 4;
                } else {
                  r3 = Integer.rotateRight(r3, 28);
                }
              }
              r6 = r5 & r3;
            } else {
              r4 = r3 >>> 28;
              r4 = r4 | r3 << 8;
              r6 = r5 & r3 >>> 24;
              r3 = r6 | Integer.rotateRight(r4, 4);
            }
          }
        }
      }
    } while(true);
  }
}
