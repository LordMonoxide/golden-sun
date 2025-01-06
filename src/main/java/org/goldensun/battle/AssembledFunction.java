package org.goldensun.battle;

import org.goldensun.GoldenSun_80e;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** This function is assembled in-memory by {@link GoldenSun_80e#FUN_80ed408} */
public class AssembledFunction {
  private final int op1;
  private final int op2;
  private final int branch1;
  private final int branch2;

  public AssembledFunction(final int op1, final int op2, final int branch1, final int branch2) {
    this.op1 = op1;
    this.op2 = op2;
    this.branch1 = branch1;
    this.branch2 = branch2;
  }

  public void run(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    int r6 = 0;
    int r7;

    int address80edcc4 = CPU.sp().value - 0x20;
    CPU.sp().value = address80edcc4;
    address80edcc4 += 0x4;
    address80edcc4 += 0x4;
    address80edcc4 += 0x4;
    MEMORY.ref(4, address80edcc4).setu(CPU.r8().value);
    address80edcc4 += 0x4;
    MEMORY.ref(4, address80edcc4).setu(CPU.r9().value);
    address80edcc4 += 0x4;
    MEMORY.ref(4, address80edcc4).setu(CPU.r10().value);
    address80edcc4 += 0x4;
    MEMORY.ref(4, address80edcc4).setu(CPU.r11().value);
    address80edcc4 += 0x4;
    MEMORY.ref(4, address80edcc4).setu(CPU.lr().value);

    r4 = a4;
    r5 = a5;

    if(this.branch2 == 0x3) {
      CPU.r10().value = 0x40;
      CPU.r10().value = CPU.r10().value | CPU.r10().value << 8;
      CPU.r10().value = CPU.r10().value | CPU.r10().value << 16;
    }

    if((this.branch1 & 0xc) == 0x4) {
      r6 = r1 + r4;
      r1 = r6 - 0x1;
      r6 = r4 << 1;
    }

    if((this.branch1 & 0xc) == 0x8) {
      r6 = r5 - 0x1;
      r1 = r6 * r4 + r1;
      r6 = -r4;
      r6 = r6 << 1;
    }

    if((this.branch1 & 0xc) == 0xc) {
      r1 = r4 * r5 + r1;
      r1 = r1 - 0x1;
      r6 = 0x0;
    }

    if((this.branch1 & 0xc) == 0) {
      r6 = 0x0;
    }

    if((this.branch1 & 0x2) != 0) {
      CPU.r12().value = CPU.rsbA(r3, 0x0);
      if(!CPU.cpsr().getNegative()) { // positive or 0
        r5 = r5 + r3;
      }

      if((this.branch1 & 0x8) != 0) {
        if(!CPU.cpsr().getNegative()) { // positive or 0
          r1 = r3 * r4 + r1;
        }
      } else {
        //LAB_80ed59e
        if(!CPU.cpsr().getNegative()) { // positive or 0
          r1 = CPU.r12().value * r4 + r1;
        }
      }

      if(!CPU.cpsr().getNegative()) { // positive or 0
        r3 = 0x0;
      }
      CPU.r12().value = r3 + r5;
      CPU.cmpA(CPU.r12().value, 0x1 << this.op2);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r5 = (0x1 << this.op2) - r3;
      }
    }

    CPU.cmpA(r5, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      if((this.branch1 & 0x1) == 0) {
        r2 = r2 & (0x1 << this.op1) - 1;
      }

      if((this.branch1 & 0x1) != 0) {
        CPU.r12().value = CPU.rsbA(r2, 0x0);
        if(!CPU.cpsr().getNegative()) { // positive or 0
          r4 = r4 + r2;
        }

        if((this.branch1 & 0x4) != 0) {
          if(!CPU.cpsr().getNegative()) { // positive or 0
            r6 = r6 + r2;
          }
          if(!CPU.cpsr().getNegative()) { // positive or 0
            r1 = r1 + r2;
          }
        } else {
          //LAB_80ed5fe
          if(!CPU.cpsr().getNegative()) { // positive or 0
            r6 = r6 - r2;
          }
          if(!CPU.cpsr().getNegative()) { // positive or 0
            r1 = r1 - r2;
          }
        }

        if(!CPU.cpsr().getNegative()) { // positive or 0
          r2 = 0x0;
        }
        CPU.r12().value = r2 + r4;
        CPU.r12().value = CPU.subA(CPU.r12().value, 0x1 << this.op1);

        if((this.branch1 & 0x4) != 0) {
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r6 = r6 - CPU.r12().value;
          }
        } else {
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r6 = r6 + CPU.r12().value;
          }
        }

        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r4 = (0x1 << this.op1) - r2;
        }
      }

      CPU.cmpA(r4, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r7 = CPU.andA(r2, 0x7);
        if(!CPU.cpsr().getZero()) { // !=
          r7 = 0x8 - r7;
          r4 = CPU.subA(r4, r7);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r7 = r4 + r7;
          }
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r4 = 0x0;
          }
        }

        //LAB_080edd78
        CPU.r12().value = r2 >>> 3;

        if((this.branch1 & 0x1) == 0) {
          CPU.r11().value = 0x10 - CPU.r12().value;
        }

        r2 = r2 & 0x7;
        r2 = r2 + (CPU.r12().value << 6);
        r0 = r0 + r2;
        r3 = r3 << 3;
        r2 = r3 + (r5 << 3);

        //CHECKPOINT2
        do {
          CPU.r12().value = r3 & 0x38;
          CPU.lr().value = r3 & (0x1 << this.op2 - 3) - 1;
          CPU.r12().value = CPU.r12().value | CPU.lr().value << this.op1 - 3;
          CPU.r9().value = r0 + CPU.r12().value;

          if((this.branch1 & 0x1) == 0) {
            CPU.lr().value = CPU.r11().value;
          }

          //LAB_80ed6a8
          CPU.cmpA(r7, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            if((this.branch1 & 0x4) != 0) {
              CPU.r12().value = r1 - r7;
            } else {
              //LAB_80ed6c2
              CPU.r12().value = r1 + r7;
            }

            //CHECKPOINT4
            do {
              if(this.branch2 == 0x1) {
                //LAB_80ed6fc
                if((this.branch1 & 0x4) != 0) {
                  final int address80edb10 = r1;
                  r5 = MEMORY.ref(1, address80edb10).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb18 = CPU.r9().value;
                    MEMORY.ref(1, address80edb18).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x1;
                } else {
                  //LAB_80ed70c
                  final int address80edb00 = r1;
                  r5 = MEMORY.ref(1, address80edb00).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb08 = CPU.r9().value;
                    MEMORY.ref(1, address80edb08).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x1;
                }
              } else if(this.branch2 == 0x2) {
                //LAB_80ed712
                if((this.branch1 & 0x4) != 0) {
                  final int address80edbf8 = r1;
                  r5 = MEMORY.ref(1, address80edbf8).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edbfc = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edbfc).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  CPU.cmpA(r5, CPU.r8().value);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    final int address80edc04 = CPU.r9().value - 0x1;
                    MEMORY.ref(1, address80edc04).setu(r5);
                  }
                } else {
                  //LAB_80ed722
                  final int address80edbe8 = r1;
                  r5 = MEMORY.ref(1, address80edbe8).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edbec = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edbec).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  CPU.cmpA(r5, CPU.r8().value);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    final int address80edbf4 = CPU.r9().value - 0x1;
                    MEMORY.ref(1, address80edbf4).setu(r5);
                  }
                }
              } else if(this.branch2 == 0x3) {
                //LAB_80ed732
                if((this.branch1 & 0x4) != 0) {
                  final int address80edca0 = r1;
                  r5 = MEMORY.ref(1, address80edca0).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edca4 = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edca4).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  r5 = r5 + CPU.r8().value;
                  CPU.cmpA(r5, 0x3f);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r5 = 0x3f;
                  }
                  final int address80edcb4 = CPU.r9().value - 0x1;
                  MEMORY.ref(1, address80edcb4).setu(r5);
                } else {
                  //LAB_80ed742
                  final int address80edc88 = r1;
                  r5 = MEMORY.ref(1, address80edc88).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edc8c = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edc8c).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  r5 = r5 + CPU.r8().value;
                  CPU.cmpA(r5, 0x3f);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r5 = 0x3f;
                  }
                  final int address80edc9c = CPU.r9().value - 0x1;
                  MEMORY.ref(1, address80edc9c).setu(r5);
                }
              } else {
                //LAB_80ed6dc
                if((this.branch1 & 0x4) != 0) {
                  final int address80edaf0 = r1;
                  r5 = MEMORY.ref(1, address80edaf0).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edaf4 = CPU.r9().value;
                  MEMORY.ref(1, address80edaf4).setu(r5);
                  CPU.r9().value = CPU.r9().value + 0x1;
                } else {
                  //LAB_80ed6ec
                  final int address80edaf8 = r1;
                  r5 = MEMORY.ref(1, address80edaf8).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edafc = CPU.r9().value;
                  MEMORY.ref(1, address80edafc).setu(r5);
                  CPU.r9().value = CPU.r9().value + 0x1;
                }
              }

              CPU.cmpA(r1, CPU.r12().value);
            } while(!CPU.cpsr().getZero()); // !=

            CPU.r9().value = CPU.r9().value + 0x38;

            if((this.branch1 & 0x1) == 0) {
              CPU.lr().value = CPU.subA(CPU.lr().value, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                CPU.r9().value = CPU.r9().value - 0x400;
              }
            }
          }

          //CHECKPOINT3
          CPU.setCFlag((r4 & 0x1 << 2) != 0);
          CPU.r12().value = CPU.movA(r0, r4 >>> 3);

          if(!CPU.cpsr().getZero()) { // !=
            //CHECKPOINT6
            do {
              if(this.branch2 == 0x1) {
                //LAB_80ed7de
                if((this.branch1 & 0x4) != 0) {
                  final int address80edb84 = r1;
                  r5 = MEMORY.ref(1, address80edb84).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb8c = CPU.r9().value;
                    MEMORY.ref(1, address80edb8c).setu(r5);
                  }
                  final int address80edb90 = r1;
                  r5 = MEMORY.ref(1, address80edb90).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb98 = CPU.r9().value + 0x1;
                    MEMORY.ref(1, address80edb98).setu(r5);
                  }
                  final int address80edb9c = r1;
                  r5 = MEMORY.ref(1, address80edb9c).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edba4 = CPU.r9().value + 0x2;
                    MEMORY.ref(1, address80edba4).setu(r5);
                  }
                  final int address80edba8 = r1;
                  r5 = MEMORY.ref(1, address80edba8).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edbb0 = CPU.r9().value + 0x3;
                    MEMORY.ref(1, address80edbb0).setu(r5);
                  }
                  final int address80edbb4 = r1;
                  r5 = MEMORY.ref(1, address80edbb4).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edbbc = CPU.r9().value + 0x4;
                    MEMORY.ref(1, address80edbbc).setu(r5);
                  }
                  final int address80edbc0 = r1;
                  r5 = MEMORY.ref(1, address80edbc0).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edbc8 = CPU.r9().value + 0x5;
                    MEMORY.ref(1, address80edbc8).setu(r5);
                  }
                  final int address80edbcc = r1;
                  r5 = MEMORY.ref(1, address80edbcc).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edbd4 = CPU.r9().value + 0x6;
                    MEMORY.ref(1, address80edbd4).setu(r5);
                  }
                  final int address80edbd8 = r1;
                  r5 = MEMORY.ref(1, address80edbd8).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edbe0 = CPU.r9().value + 0x7;
                    MEMORY.ref(1, address80edbe0).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x8;
                } else {
                  final int address80edb20 = r1;
                  r5 = MEMORY.ref(1, address80edb20).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb28 = CPU.r9().value;
                    MEMORY.ref(1, address80edb28).setu(r5);
                  }
                  final int address80edb2c = r1;
                  r5 = MEMORY.ref(1, address80edb2c).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb34 = CPU.r9().value + 0x1;
                    MEMORY.ref(1, address80edb34).setu(r5);
                  }
                  final int address80edb38 = r1;
                  r5 = MEMORY.ref(1, address80edb38).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb40 = CPU.r9().value + 0x2;
                    MEMORY.ref(1, address80edb40).setu(r5);
                  }
                  final int address80edb44 = r1;
                  r5 = MEMORY.ref(1, address80edb44).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb4c = CPU.r9().value + 0x3;
                    MEMORY.ref(1, address80edb4c).setu(r5);
                  }
                  final int address80edb50 = r1;
                  r5 = MEMORY.ref(1, address80edb50).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb58 = CPU.r9().value + 0x4;
                    MEMORY.ref(1, address80edb58).setu(r5);
                  }
                  final int address80edb5c = r1;
                  r5 = MEMORY.ref(1, address80edb5c).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb64 = CPU.r9().value + 0x5;
                    MEMORY.ref(1, address80edb64).setu(r5);
                  }
                  final int address80edb68 = r1;
                  r5 = MEMORY.ref(1, address80edb68).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb70 = CPU.r9().value + 0x6;
                    MEMORY.ref(1, address80edb70).setu(r5);
                  }
                  final int address80edb74 = r1;
                  r5 = MEMORY.ref(1, address80edb74).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb7c = CPU.r9().value + 0x7;
                    MEMORY.ref(1, address80edb7c).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x8;
                }
              } else if(this.branch2 == 0x2) {
                //LAB_80ed7fe
                for(int i = 0; i < 2; i++) {
                  if((this.branch1 & 0x4) != 0) {
                    final int address80edc48 = r1;
                    r5 = MEMORY.ref(1, address80edc48).getUnsigned();
                    r1 = r1 - 0x1;
                    final int address80edc4c = CPU.r9().value;
                    CPU.r8().value = MEMORY.ref(4, address80edc4c).getUnsigned();
                    CPU.r9().value = CPU.r9().value + 0x4;
                    CPU.r10().value = CPU.r8().value & 0xff;
                    CPU.cmpA(r5, CPU.r10().value);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc58 = CPU.r9().value - 0x4;
                      MEMORY.ref(1, address80edc58).setu(r5);
                    }
                    final int address80edc5c = r1;
                    r5 = MEMORY.ref(1, address80edc5c).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r10().value = CPU.r8().value & 0xff00;
                    CPU.cmpA(r5, CPU.r10().value >>> 8);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc68 = CPU.r9().value - 0x3;
                      MEMORY.ref(1, address80edc68).setu(r5);
                    }
                    final int address80edc6c = r1;
                    r5 = MEMORY.ref(1, address80edc6c).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r10().value = CPU.r8().value & 0xff0000;
                    CPU.cmpA(r5, CPU.r10().value >>> 16);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc78 = CPU.r9().value - 0x2;
                      MEMORY.ref(1, address80edc78).setu(r5);
                    }
                    final int address80edc7c = r1;
                    r5 = MEMORY.ref(1, address80edc7c).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.cmpA(r5, CPU.r8().value >>> 24);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc84 = CPU.r9().value - 0x1;
                      MEMORY.ref(1, address80edc84).setu(r5);
                    }
                  } else {
                    //LAB_80ed80c
                    final int address80edc08 = r1;
                    r5 = MEMORY.ref(1, address80edc08).getUnsigned();
                    r1 = r1 + 0x1;
                    final int address80edc0c = CPU.r9().value;
                    CPU.r8().value = MEMORY.ref(4, address80edc0c).getUnsigned();
                    CPU.r9().value = CPU.r9().value + 0x4;
                    CPU.r10().value = CPU.r8().value & 0xff;
                    CPU.cmpA(r5, CPU.r10().value);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc18 = CPU.r9().value - 0x4;
                      MEMORY.ref(1, address80edc18).setu(r5);
                    }
                    final int address80edc1c = r1;
                    r5 = MEMORY.ref(1, address80edc1c).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r10().value = CPU.r8().value & 0xff00;
                    CPU.cmpA(r5, CPU.r10().value >>> 8);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc28 = CPU.r9().value - 0x3;
                      MEMORY.ref(1, address80edc28).setu(r5);
                    }
                    final int address80edc2c = r1;
                    r5 = MEMORY.ref(1, address80edc2c).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r10().value = CPU.r8().value & 0xff0000;
                    CPU.cmpA(r5, CPU.r10().value >>> 16);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc38 = CPU.r9().value - 0x2;
                      MEMORY.ref(1, address80edc38).setu(r5);
                    }
                    final int address80edc3c = r1;
                    r5 = MEMORY.ref(1, address80edc3c).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.cmpA(r5, CPU.r8().value >>> 24);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      final int address80edc44 = CPU.r9().value - 0x1;
                      MEMORY.ref(1, address80edc44).setu(r5);
                    }
                  }
                }
              } else if(this.branch2 == 0x3) {
                //LAB_80ed88c
                for(int i = 0; i < 2; i++) {
                  if((this.branch1 & 0x4) != 0) {
                    final int address80eefdc = CPU.r9().value;
                    CPU.r8().value = MEMORY.ref(4, address80eefdc).getUnsigned();
                    final int address80eefe0 = r1;
                    r5 = MEMORY.ref(1, address80eefe0).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r8().value = CPU.r8().value + r5;
                    final int address80eefe8 = r1;
                    r5 = MEMORY.ref(1, address80eefe8).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 8);
                    final int address80eeff0 = r1;
                    r5 = MEMORY.ref(1, address80eeff0).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 16);
                    final int address80eeff8 = r1;
                    r5 = MEMORY.ref(1, address80eeff8).getUnsigned();
                    r1 = r1 - 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 24);
                    r5 = CPU.r8().value & CPU.r10().value;
                    CPU.r8().value = CPU.r8().value & ~CPU.r10().value;
                    r5 = r5 - (r5 >>> 6);
                    CPU.r8().value = CPU.r8().value | r5;
                    final int address80ef010 = CPU.r9().value;
                    MEMORY.ref(4, address80ef010).setu(CPU.r8().value);
                    CPU.r9().value = CPU.r9().value + 0x4;
                  } else {
                    //LAB_80ed89a
                    final int address80eefa4 = CPU.r9().value;
                    CPU.r8().value = MEMORY.ref(4, address80eefa4).getUnsigned();
                    final int address80eefa8 = r1;
                    r5 = MEMORY.ref(1, address80eefa8).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r8().value = CPU.r8().value + r5;
                    final int address80eefb0 = r1;
                    r5 = MEMORY.ref(1, address80eefb0).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 8);
                    final int address80eefb8 = r1;
                    r5 = MEMORY.ref(1, address80eefb8).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 16);
                    final int address80eefc0 = r1;
                    r5 = MEMORY.ref(1, address80eefc0).getUnsigned();
                    r1 = r1 + 0x1;
                    CPU.r8().value = CPU.r8().value + (r5 << 24);
                    r5 = CPU.r8().value & CPU.r10().value;
                    CPU.r8().value = CPU.r8().value & ~CPU.r10().value;
                    r5 = r5 - (r5 >>> 6);
                    CPU.r8().value = CPU.r8().value | r5;
                    final int address80eefd8 = CPU.r9().value;
                    MEMORY.ref(4, address80eefd8).setu(CPU.r8().value);
                    CPU.r9().value = CPU.r9().value + 0x4;
                  }
                }
              } else {
                //LAB_80ed7ae
                //LAB_80ed7be
                for(int r4_0 = 0; r4_0 < 8; r4_0++) {
                  if((this.branch1 & 0x4) != 0) {
                    final int address80edaf0 = r1;
                    r5 = MEMORY.ref(1, address80edaf0).getUnsigned();
                    r1 = r1 - 0x1;
                    final int address80edaf4 = CPU.r9().value;
                    MEMORY.ref(1, address80edaf4).setu(r5);
                    CPU.r9().value = CPU.r9().value + 0x1;
                  } else {
                    final int address80edaf8 = r1;
                    r5 = MEMORY.ref(1, address80edaf8).getUnsigned();
                    r1 = r1 + 0x1;
                    final int address80edafc = CPU.r9().value;
                    MEMORY.ref(1, address80edafc).setu(r5);
                    CPU.r9().value = CPU.r9().value + 0x1;
                  }
                }
              }

              CPU.r9().value = CPU.r9().value + 0x38;

              if((this.branch1 & 0x1) == 0) {
                CPU.lr().value = CPU.subA(CPU.lr().value, 0x1);
                if(CPU.cpsr().getZero()) { // ==
                  CPU.r9().value = CPU.r9().value - 0x400;
                }
              }

              CPU.r12().value = CPU.subA(CPU.r12().value, 0x1);
            } while(!CPU.cpsr().getZero()); // !=
          }

          //CHECKPOINT5
          CPU.r12().value = CPU.andA(r4, 0x7);
          if(!CPU.cpsr().getZero()) { // !=
            if((this.branch1 & 0x4) != 0) {
              CPU.r12().value = r1 - CPU.r12().value;
            } else {
              //LAB_80ed910
              CPU.r12().value = r1 + CPU.r12().value;
            }

            //CHECKPOINT8
            do {
              if(this.branch2 == 0x1) {
                //LAB_80ed94a
                if((this.branch1 & 0x4) != 0) {
                  final int address80edb10 = r1;
                  r5 = MEMORY.ref(1, address80edb10).getUnsigned();
                  r1 = r1 - 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb18 = CPU.r9().value;
                    MEMORY.ref(1, address80edb18).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x1;
                } else {
                  //LAB_80ed95a
                  final int address80edb00 = r1;
                  r5 = MEMORY.ref(1, address80edb00).getUnsigned();
                  r1 = r1 + 0x1;
                  CPU.cmpA(r5, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    final int address80edb08 = CPU.r9().value;
                    MEMORY.ref(1, address80edb08).setu(r5);
                  }
                  CPU.r9().value = CPU.r9().value + 0x1;
                }
              } else if((this.branch2 & 0xffff_ffffL) < 1) {
                //LAB_80ed92a
                if((this.branch1 & 0x4) != 0) {
                  final int address80edaf0 = r1;
                  r5 = MEMORY.ref(1, address80edaf0).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edaf4 = CPU.r9().value;
                  MEMORY.ref(1, address80edaf4).setu(r5);
                  CPU.r9().value = CPU.r9().value + 0x1;
                } else {
                  //LAB_80ed93a
                  final int address80edaf8 = r1;
                  r5 = MEMORY.ref(1, address80edaf8).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edafc = CPU.r9().value;
                  MEMORY.ref(1, address80edafc).setu(r5);
                  CPU.r9().value = CPU.r9().value + 0x1;
                }
              } else if(this.branch2 == 0x2) {
                //LAB_80ed960
                if((this.branch1 & 0x4) != 0) {
                  final int address80edbf8 = r1;
                  r5 = MEMORY.ref(1, address80edbf8).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edbfc = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edbfc).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  CPU.cmpA(r5, CPU.r8().value);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    final int address80edc04 = CPU.r9().value - 0x1;
                    MEMORY.ref(1, address80edc04).setu(r5);
                  }
                } else {
                  //LAB_80ed970
                  final int address80edbe8 = r1;
                  r5 = MEMORY.ref(1, address80edbe8).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edbec = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edbec).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  CPU.cmpA(r5, CPU.r8().value);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    final int address80edbf4 = CPU.r9().value - 0x1;
                    MEMORY.ref(1, address80edbf4).setu(r5);
                  }
                }
              } else if(this.branch2 == 0x3) {
                //LAB_80ed980
                if((this.branch1 & 0x4) != 0) {
                  final int address80edca0 = r1;
                  r5 = MEMORY.ref(1, address80edca0).getUnsigned();
                  r1 = r1 - 0x1;
                  final int address80edca4 = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edca4).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  r5 = r5 + CPU.r8().value;
                  CPU.cmpA(r5, 0x3f);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r5 = 0x3f;
                  }
                  final int address80edcb4 = CPU.r9().value - 0x1;
                  MEMORY.ref(1, address80edcb4).setu(r5);
                } else {
                  //LAB_80ed990
                  final int address80edc88 = r1;
                  r5 = MEMORY.ref(1, address80edc88).getUnsigned();
                  r1 = r1 + 0x1;
                  final int address80edc8c = CPU.r9().value;
                  CPU.r8().value = MEMORY.ref(1, address80edc8c).getUnsigned();
                  CPU.r9().value = CPU.r9().value + 0x1;
                  r5 = r5 + CPU.r8().value;
                  CPU.cmpA(r5, 0x3f);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r5 = 0x3f;
                  }
                  final int address80edc9c = CPU.r9().value - 0x1;
                  MEMORY.ref(1, address80edc9c).setu(r5);
                }
              }

              CPU.cmpA(r1, CPU.r12().value);
            } while(!CPU.cpsr().getZero()); // !=
          }

          //CHECKPOINT7
          r1 = r1 + r6;
          r3 = r3 + 0x8;
          CPU.cmpA(r3, r2);
        } while(!CPU.cpsr().getZero()); // !=
      }
    }

    //CHECKPOINT0
    //CHECKPOINT1
    int address80ede40 = CPU.sp().value;
    address80ede40 += 0x4;
    address80ede40 += 0x4;
    address80ede40 += 0x4;
    CPU.r8().value = MEMORY.ref(4, address80ede40).getUnsigned();
    address80ede40 += 0x4;
    CPU.r9().value = MEMORY.ref(4, address80ede40).getUnsigned();
    address80ede40 += 0x4;
    CPU.r10().value = MEMORY.ref(4, address80ede40).getUnsigned();
    address80ede40 += 0x4;
    CPU.r11().value = MEMORY.ref(4, address80ede40).getUnsigned();
    address80ede40 += 0x4;
    CPU.lr().value = MEMORY.ref(4, address80ede40).getUnsigned();
    address80ede40 += 0x4;
    CPU.sp().value = address80ede40;
  }
}
