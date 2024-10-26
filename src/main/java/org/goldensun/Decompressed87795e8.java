package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

/**
 * Menu overlay?
 */
public final class Decompressed87795e8 {
  private Decompressed87795e8() { }

  @Method(0x2008030)
  public static int FUN_2008030() {
    return 0x2009658;
  }

  @Method(0x2008044)
  public static int FUN_2008044() {
    return 0x200968c;
  }

  @Method(0x200804c)
  public static int FUN_200804c() {
    return 0x20096a4;
  }

  @Method(0x2008054)
  public static void FUN_2008054() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r0 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(4, 0x200809c).get();
    FUN_2009364(r0);
    r2 = MEMORY.ref(4, 0x20080a0).get();
    r3 = MEMORY.ref(4, 0x2008098).get();
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x20080a4).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r2 + 0xa).setu(r3);
    r0 = CPU.addT(r5, 0x0);
    r0 = getPointerTableEntry(r0);
    r1 = CPU.movT(0, 0xa0);
    r6 = MEMORY.ref(4, 0x20080a8).get();
    r4 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 19);
    r2 = MEMORY.ref(4, 0x20080b0).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r2 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 1);
    r4 = CPU.addT(r4, r2);
    r0 = CPU.addT(r4, 0x0);
    r1 = MEMORY.ref(4, 0x20080b4).get();
    decompress(r0, r1);
    r0 = MEMORY.ref(4, 0x20080b4).get();
    r1 = MEMORY.ref(4, 0x20080b8).get();
    r2 = MEMORY.ref(4, 0x20080bc).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r3 = CPU.movT(0, 0xd0);
    r1 = MEMORY.ref(4, 0x2008138).get();
    r3 = CPU.lslT(r3, 1);
    r4 = CPU.movT(0, 0x0);

    //LAB_20080cc
    do {
      r0 = CPU.movT(0, 0x0);

      //LAB_20080ce
      do {
        r2 = CPU.addT(r3, 0x0);
        r5 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r2, 16);
        r5 = CPU.lslT(r5, 9);
        r3 = CPU.addT(r3, r5);
        r0 = CPU.addT(r0, 0x1);
        MEMORY.ref(2, r1).setu(r2);
        r3 = CPU.asrT(r3, 16);
        r1 = CPU.addT(r1, 0x2);
        CPU.cmpT(r0, 0x1d);
      } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

      MEMORY.ref(2, r1).setu(r6);
      r4 = CPU.addT(r4, 0x1);
      r1 = CPU.addT(r1, 0x2);
      MEMORY.ref(2, r1).setu(r6);
      r1 = CPU.addT(r1, 0x2);
      CPU.cmpT(r4, 0x13);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r3 = MEMORY.ref(4, 0x200813c).get();
    r4 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x0);

    //LAB_20080f8
    do {
      r4 = CPU.addT(r4, 0x1);
      MEMORY.ref(2, r3 + 0x2).setu(r2);
      MEMORY.ref(2, r3).setu(r2);
      r3 = CPU.addT(r3, 0x4);
      CPU.cmpT(r4, 0x3);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r0 = MEMORY.ref(4, 0x200813c).get();
    r1 = MEMORY.ref(4, 0x2008144).get();
    r2 = MEMORY.ref(4, 0x2008148).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r3 = MEMORY.ref(4, 0x200814c).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = CPU.movT(0, 0xa0);
    r3 = CPU.lslT(r3, 5);
    MEMORY.ref(2, r2 + 0x14).setu(r3);
    r3 = MEMORY.ref(4, 0x2008150).get();
    r2 = CPU.movT(0, 0xfa);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r0 = MEMORY.ref(4, r3).get();
    r0 = FUN_200949c(r0);
    r5 = MEMORY.ref(4, 0x2008134).get();
    r0 = CPU.addT(r0, 0x55);
    MEMORY.ref(1, r0).setu(r5);
  }

  @Method(0x20081fc)
  public static void FUN_20081fc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r1 = MEMORY.ref(4, 0x2008260).get();
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r1 + r2).get();
    CPU.r12().value = r1;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r5 = MEMORY.ref(4, 0x2008264).get();
      r3 = CPU.movT(0, 0x0);
      r4 = MEMORY.ref(2, r5 + r3).get();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x2008268).get();
        r3 = MEMORY.ref(4, r3).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          MEMORY.ref(2, r5).setu(r3);
        }
      } else {
        //LAB_2008220
        r6 = MEMORY.ref(4, 0x2008268).get();
        r3 = MEMORY.ref(4, r6).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, 0x200826c).get();
          r2 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r1 + r2).get();
          r7 = MEMORY.ref(4, 0x2008270).get();
          r3 = CPU.lslT(r3, 1);
          r2 = MEMORY.ref(2, r7 + r3).getUnsigned();
          r3 = MEMORY.ref(4, r6).get();
          r0 = MEMORY.ref(2, r1).getUnsigned();
          r3 = CPU.cmpT(r3, r2);
          if(CPU.cpsr().getZero()) { // ==
            r2 = MEMORY.ref(4, 0x200825c).get();
            r3 = CPU.addT(r0, 0x1);
            MEMORY.ref(2, r1).setu(r3);
            MEMORY.ref(2, r5).setu(r2);
            r3 = CPU.lslT(r3, 16);
            r3 = CPU.asrT(r3, 15);
            r3 = MEMORY.ref(2, r7 + r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.r12().value;
              MEMORY.ref(2, r3).setu(r2);
              r0 = CPU.movT(0, 0x6e);
              FUN_20094cc(r0);
            }
          } else {
            //LAB_2008274
            MEMORY.ref(2, r1).setu(r4);
          }
        }
      }
    }

    //LAB_2008276
    r1 = MEMORY.ref(4, 0x20082d8).get();
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r1 + r2).get();
    CPU.r12().value = r1;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r5 = MEMORY.ref(4, 0x20082dc).get();
      r3 = CPU.movT(0, 0x0);
      r4 = MEMORY.ref(2, r5 + r3).get();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x20082e0).get();
        r3 = MEMORY.ref(4, r3).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          MEMORY.ref(2, r5).setu(r3);
        }
      } else {
        //LAB_2008298
        r6 = MEMORY.ref(4, 0x20082e0).get();
        r3 = MEMORY.ref(4, r6).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, 0x20082e4).get();
          r2 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r1 + r2).get();
          r7 = MEMORY.ref(4, 0x20082e8).get();
          r3 = CPU.lslT(r3, 1);
          r2 = MEMORY.ref(2, r7 + r3).getUnsigned();
          r3 = MEMORY.ref(4, r6).get();
          r0 = MEMORY.ref(2, r1).getUnsigned();
          r3 = CPU.cmpT(r3, r2);
          if(CPU.cpsr().getZero()) { // ==
            r2 = MEMORY.ref(4, 0x20082d4).get();
            r3 = CPU.addT(r0, 0x1);
            MEMORY.ref(2, r1).setu(r3);
            MEMORY.ref(2, r5).setu(r2);
            r3 = CPU.lslT(r3, 16);
            r3 = CPU.asrT(r3, 15);
            r3 = MEMORY.ref(2, r7 + r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.r12().value;
              MEMORY.ref(2, r3).setu(r2);
              r0 = CPU.movT(0, 0x6e);
              FUN_20094cc(r0);
            }
          } else {
            //LAB_20082ec
            MEMORY.ref(2, r1).setu(r4);
          }
        }
      }
    }

    //LAB_20082ee
  }

  @Method(0x20082f4)
  public static void FUN_20082f4(final int r0, final int r1) {
    int r3;

    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r1 + 0x1).setu(r3);
    MEMORY.ref(1, r1 + 0x2).setu(r3);
    CPU.cmpT(r0, 0x7);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.addT(r3, 0x41);
    } else {
      //LAB_2008306
      CPU.cmpT(r0, 0xc);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r3 = CPU.addT(r0, 0x0);
        r3 = CPU.addT(r3, 0x42);
      } else {
        //LAB_2008310
        CPU.cmpT(r0, 0x17);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = CPU.addT(r0, 0x0);
          r3 = CPU.addT(r3, 0x43);
        } else {
          //LAB_200831a
          CPU.cmpT(r0, 0x1f);
          if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
            r3 = CPU.addT(r0, 0x0);
            r3 = CPU.addT(r3, 0x1a);
          } else {
            //LAB_2008324
            CPU.cmpT(r0, 0x2a);
            if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
              r3 = CPU.addT(r0, 0x0);
              r3 = CPU.addT(r3, 0x41);
            } else {
              //LAB_200832e
              CPU.cmpT(r0, 0x2c);
              if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                r3 = CPU.addT(r0, 0x0);
                r3 = CPU.addT(r3, 0x42);
              } else {
                //LAB_2008338
                CPU.cmpT(r0, 0x37);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r3 = CPU.addT(r0, 0x0);
                  r3 = CPU.addT(r3, 0x43);
                } else {
                  //LAB_2008342
                  CPU.cmpT(r0, 0x38);
                  if(CPU.cpsr().getZero()) { // ==
                    r3 = CPU.movT(0, 0x21);
                  } else {
                    //LAB_200834a
                    CPU.cmpT(r0, 0x39);
                    if(CPU.cpsr().getZero()) { // ==
                      r3 = CPU.movT(0, 0x3f);
                    } else {
                      //LAB_2008352
                      CPU.cmpT(r0, 0x3a);
                      if(CPU.cpsr().getZero()) { // ==
                        r3 = CPU.movT(0, 0x23);
                      } else {
                        //LAB_200835a
                        CPU.cmpT(r0, 0x3b);
                        if(CPU.cpsr().getZero()) { // ==
                          r3 = CPU.movT(0, 0x26);
                        } else {
                          //LAB_2008362
                          CPU.cmpT(r0, 0x3c);
                          if(CPU.cpsr().getZero()) { // ==
                            r3 = CPU.movT(0, 0x24);
                          } else {
                            //LAB_200836a
                            CPU.cmpT(r0, 0x3d);
                            if(CPU.cpsr().getZero()) { // ==
                              r3 = CPU.movT(0, 0x25);
                            } else {
                              //LAB_2008372
                              CPU.cmpT(r0, 0x3e);
                              if(CPU.cpsr().getZero()) { // ==
                                r3 = CPU.movT(0, 0x2b);
                              } else {
                                //LAB_200837a
                                r3 = CPU.movT(0, 0x3d);
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
        }
      }
    }

    //LAB_200837c
    MEMORY.ref(1, r1).setu(r3);
  }

  @Method(0x2008384)
  public static int FUN_2008384() {
    int r0;
    int r1;
    int r2;
    int r3;

    r0 = CPU.movT(0, 0xa2);
    r0 = CPU.lslT(r0, 1);
    r0 = FUN_2009454(r0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_2008396
      r1 = MEMORY.ref(4, 0x20083c0).get();
      r2 = MEMORY.ref(4, 0x20083c4).get();
      r3 = CPU.addT(r2, r1);
      r1 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r1).get();
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x2);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.movT(0, 0xe0);
        r1 = CPU.lslT(r1, 1);
        r3 = CPU.addT(r2, r1);
        r2 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r3 + r2).get();
        r2 = MEMORY.ref(4, 0x20083c8).get();
        r3 = CPU.eorT(r3, r2);
        r0 = CPU.negT(r0, r3);
        r0 = CPU.orrT(r0, r3);
        r0 = CPU.lsrT(r0, 31);
        r0 = CPU.negT(r0, r0);
      }
    }

    //LAB_20083bc
    return r0;
  }

  /** I can not explain to you how wrong this code probably is */
  @Method(0x20083cc)
  public static void FUN_20083cc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r5 = MEMORY.ref(4, 0x20086b4).get();
    r0 = CPU.movT(0, 0x0);
    CPU.sp().value += r5;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    FUN_2008054();
    r1 = CPU.movT(0, 0xc8);
    r1 = CPU.lslT(r1, 4);
    r0 = MEMORY.ref(4, 0x20086b8).get();
    FUN_200932c(r0, r1);
    r3 = MEMORY.ref(4, 0x20086bc).get();
    r1 = CPU.movT(0, 0xe0);
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, r1);
    MEMORY.ref(4, r3).setu(r2);
    FUN_20094ac();
    FUN_20094bc();
    r3 = MEMORY.ref(4, 0x20086c0).get();
    r0 = CPU.movT(0, 0xe1);
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r0);
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r1).get();
    CPU.cmpT(r3, 0x2);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_2008416
      do {
        r5 = MEMORY.ref(4, 0x20086c4).get();
        r1 = CPU.movT(0, 0x5);
        r0 = CPU.addT(r5, 0x0);
        FUN_2009394(r0, r1);
        r0 = CPU.movT(0, 0x1);
        r0 = FUN_20094c4(r0);
        r7 = CPU.addT(r0, 0x0);
        FUN_20093c4();
        CPU.cmpT(r7, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          break;
        }
        r0 = CPU.addT(r5, 0x1);
        r1 = CPU.movT(0, 0x1);
        FUN_2009394(r0, r1);
        r3 = MEMORY.ref(4, 0x20086c0).get();
        r2 = MEMORY.ref(4, 0x20086c8).get();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.movT(0, 0x1);
        MEMORY.ref(1, r3).setu(r2);
        r0 = FUN_20093ec();
        r3 = CPU.movT(0, 0x1);
        r7 = CPU.addT(r0, 0x0);
        r3 = CPU.negT(r3, r3);
        r7 = CPU.cmpT(r7, r3);
      } while(CPU.cpsr().getZero()); // ==

      //LAB_2008450
      r0 = CPU.movT(0, 0x3c);
      FUN_2009494(r0);
      FUN_20094b4();
      r0 = CPU.movT(0, 0x11);
      FUN_20094cc(r0);
      r0 = CPU.movT(0, 0x96);
      r0 = CPU.lslT(r0, 1);
      FUN_2009494(r0);
      r0 = MEMORY.ref(4, 0x20086cc).get();
      r1 = CPU.movT(0, 0x48);
      FUN_20094a4(r0, r1);
    } else {
      //LAB_20084a0
      r0 = CPU.sp().value + 0x14;
      r3 = MEMORY.ref(4, 0x20086d0).get();
      r0 = MEMORY.ref(1, r0).getUnsigned();
      MEMORY.ref(1, r3).setu(r0);

      jmp_20084a8:
      while(true) {
        r0 = FUN_200940c();
        r6 = CPU.addT(r0, 0x0);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x20086d4).get();
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = MEMORY.ref(4, 0x20086d8).get();
            r3 = MEMORY.ref(4, 0x20086c0).get();
            r2 = CPU.movT(0, 0x1);
            r3 = CPU.addT(r3, r1);
            MEMORY.ref(1, r3).setu(r2);
            r3 = MEMORY.ref(4, 0x20086dc).get();
            r0 = MEMORY.ref(4, 0x20086e0).get();
            MEMORY.ref(1, r3).setu(r2);
            r1 = CPU.movT(0, 0x1);
            r2 = CPU.movT(0, 0x8);
            FUN_20093dc(r0, r1, r2);
          }
        }

        //LAB_20084d2
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x1e);
            FUN_2009324(r0);
            r1 = CPU.movT(0, 0xc8);
            r1 = CPU.lslT(r1, 4);
            r0 = MEMORY.ref(4, 0x20086e4).get();
            FUN_200932c(r0, r1);
            r0 = CPU.movT(0, 0x1);
            FUN_2009324(r0);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
          }
        }

        //LAB_20084f6
        CPU.cmpT(r6, 0x0);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r0 = FUN_20093cc();
          r6 = CPU.addT(r0, 0x0);
        } else {
          //LAB_2008502
          r6 = CPU.movT(0, 0x0);
        }

        {
          //LAB_2008504
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            FUN_200944c();
            r2 = MEMORY.ref(4, 0x20086c0).get();
            r0 = MEMORY.ref(4, 0x20086e8).get();
            r1 = MEMORY.ref(4, 0x20086ec).get();
            r3 = CPU.addT(r2, r0);
            r2 = CPU.addT(r2, r1);
            r0 = MEMORY.ref(1, r3).getUnsigned();
            r1 = MEMORY.ref(1, r2).getUnsigned();
            FUN_200941c(r0, r1);
            r5 = CPU.movT(0, 0x1);
            r7 = CPU.movT(0, 0x0);

            //LAB_2008522
            do {
              do {
                r0 = CPU.movT(0, 0x6);
                FUN_2009324(r0);
                r0 = CPU.addT(r7, 0x0);
                r0 = FUN_2009414(r0);
                r2 = CPU.movT(0, 0x1);
                r6 = CPU.addT(r0, 0x0);
                r2 = CPU.negT(r2, r2);
                r6 = CPU.cmpT(r6, r2);
                if(!CPU.cpsr().getZero()) { // !=
                  break;
                }
                CPU.cmpT(r7, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  continue jmp_20084a8;
                }
                r7 = CPU.subT(r7, 0x1);
              } while(true);

              //LAB_2008540
              r3 = MEMORY.ref(4, 0x20086f0).get();
              r0 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r0).get();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = CPU.movT(0, 0x4);
              }

              //LAB_200854c
              r3 = MEMORY.ref(4, 0x20086f4).get();
              r1 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r1).get();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = CPU.movT(0, 0x7);
              }

              //LAB_2008558
              r7 = CPU.addT(r7, 0x1);
              r7 = CPU.cmpT(r7, r5);
            } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <

            FUN_200947c();
            r1 = MEMORY.ref(4, 0x20086c0).get();
            r0 = CPU.movT(0, 0xe0);
            r3 = MEMORY.ref(4, 0x20086f8).get();
            r0 = CPU.lslT(r0, 1);
            r2 = CPU.addT(r1, r0);
            MEMORY.ref(2, r2).setu(r3);
            r3 = CPU.movT(0, 0xe1);
            r3 = CPU.lslT(r3, 1);
            r2 = CPU.addT(r1, r3);
            r3 = CPU.movT(0, 0x14);
            MEMORY.ref(2, r2).setu(r3);
          } else {
            //LAB_200857a
            CPU.cmpT(r6, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_2008580
              r0 = CPU.movT(0, 0x1);
              r0 = FUN_20093f4(r0);
              r6 = CPU.addT(r0, 0x0);
              r0 = CPU.movT(0, 0x1);
              r0 = CPU.negT(r0, r0);
              r6 = CPU.cmpT(r6, r0);
              if(CPU.cpsr().getZero()) { // ==
                continue jmp_20084a8;
              }
              r0 = MEMORY.ref(4, 0x20086fc).get();
              FUN_200945c(r0);
              r5 = MEMORY.ref(4, 0x20086c0).get();
              r1 = MEMORY.ref(4, 0x20086e8).get();
              r2 = MEMORY.ref(4, 0x20086ec).get();
              r3 = CPU.addT(r5, r1);
              r0 = MEMORY.ref(1, r3).getUnsigned();
              r3 = CPU.addT(r5, r2);
              r1 = MEMORY.ref(1, r3).getUnsigned();
              FUN_200941c(r0, r1);
              r0 = FUN_2009484();
              r3 = MEMORY.ref(4, r5).get();
              r3 = CPU.cmpT(r3, r0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = CPU.movT(0, 0xe2);
                r0 = CPU.lslT(r0, 1);
                r3 = CPU.addT(r5, r0);
                r1 = CPU.movT(0, 0xe0);
                r2 = MEMORY.ref(2, r3).getUnsigned();
                r1 = CPU.lslT(r1, 1);
                r3 = CPU.addT(r5, r1);
                MEMORY.ref(2, r3).setu(r2);
                r2 = CPU.movT(0, 0xe3);
                r2 = CPU.lslT(r2, 1);
                r3 = CPU.addT(r5, r2);
                r0 = CPU.subT(r0, 0x2);
                r3 = MEMORY.ref(2, r3).getUnsigned();
                r2 = CPU.addT(r5, r0);
                MEMORY.ref(2, r2).setu(r3);
                r0 = CPU.subT(r0, 0xb9);
                FUN_2009464(r0);
              } else {
                //LAB_20085d8
                r3 = MEMORY.ref(4, 0x2008700).get();
                r2 = CPU.movT(0, 0x82);
                r3 = MEMORY.ref(4, r3).get();
                r2 = CPU.lslT(r2, 2);
                r3 = CPU.andT(r3, r2);
                r3 = CPU.cmpT(r3, r2);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = FUN_2008384();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = MEMORY.ref(4, 0x2008704).get();
                    r1 = CPU.movT(0, 0x9);
                    FUN_2009394(r0, r1);
                    continue jmp_20084a8;
                  }

                  //LAB_20085f2
                  r1 = CPU.movT(0, 0xe2);
                  r1 = CPU.lslT(r1, 1);
                  r3 = CPU.addT(r5, r1);
                  r0 = CPU.movT(0, 0xe0);
                  r2 = MEMORY.ref(2, r3).getUnsigned();
                  r0 = CPU.lslT(r0, 1);
                  r3 = CPU.addT(r5, r0);
                  MEMORY.ref(2, r3).setu(r2);
                  r1 = CPU.addT(r1, 0x2);
                  r3 = CPU.addT(r5, r1);
                  r3 = MEMORY.ref(2, r3).getUnsigned();
                  r0 = CPU.addT(r0, 0x2);
                  r2 = CPU.addT(r5, r0);
                  MEMORY.ref(2, r2).setu(r3);
                  r0 = CPU.subT(r0, 0xb9);
                  FUN_2009464(r0);
                  r0 = CPU.movT(0, 0x9f);
                  r0 = CPU.lslT(r0, 1);
                  FUN_200945c(r0);
                } else {
                  //LAB_200861e
                  r3 = MEMORY.ref(4, 0x2008708).get();
                  r1 = CPU.movT(0, 0x80);
                  r1 = CPU.lslT(r1, 1);
                  r3 = CPU.addT(r3, r1);
                  r2 = MEMORY.ref(4, r5 + 0x4).get();
                  r3 = MEMORY.ref(4, r3).get();
                  r2 = CPU.cmpT(r2, r3);
                  if(!CPU.cpsr().getZero()) { // !=
                    r6 = MEMORY.ref(4, 0x200870c).get();
                    r1 = CPU.movT(0, 0x9);
                    r0 = CPU.addT(r6, 0x0);
                    FUN_2009394(r0, r1);
                    r0 = CPU.addT(r6, 0x1);
                    r1 = CPU.movT(0, 0xd);
                    FUN_2009394(r0, r1);
                    r0 = CPU.movT(0, 0x1);
                    r1 = CPU.movT(0, 0x0);
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.movT(0, 0x0);
                    r0 = FUN_2009424(r0, r1, r2, r3);
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      FUN_20093c4();
                      continue jmp_20084a8;
                    }

                    //LAB_2008656
                    FUN_20093c4();
                    r0 = FUN_2008384();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.addT(r6, 0x2);
                      r1 = CPU.movT(0, 0x9);
                      FUN_2009394(r0, r1);
                      continue jmp_20084a8;
                    }

                    //LAB_200866c
                    r2 = CPU.movT(0, 0xe2);
                    r2 = CPU.lslT(r2, 1);
                    r3 = CPU.addT(r5, r2);
                    r0 = CPU.movT(0, 0xe0);
                    r2 = MEMORY.ref(2, r3).getUnsigned();
                    r0 = CPU.lslT(r0, 1);
                    r3 = CPU.addT(r5, r0);
                    r1 = CPU.movT(0, 0xe3);
                    MEMORY.ref(2, r3).setu(r2);
                    r1 = CPU.lslT(r1, 1);
                    r3 = CPU.addT(r5, r1);
                    r3 = MEMORY.ref(2, r3).getUnsigned();
                    r0 = CPU.addT(r0, 0x2);
                    r2 = CPU.addT(r5, r0);
                    MEMORY.ref(2, r2).setu(r3);
                    r0 = CPU.subT(r0, 0xb9);
                    FUN_2009464(r0);
                    r0 = MEMORY.ref(4, 0x2008710).get();
                    FUN_200945c(r0);
                  }
                }
              }

              //LAB_2008696
              r0 = CPU.movT(0, 0x83);
              r0 = CPU.lslT(r0, 1);
              FUN_2009464(r0);
            } else {
              //LAB_20086a0
              CPU.cmpT(r6, 0x2);
              if(CPU.cpsr().getZero()) { // ==
                r0 = FUN_20093fc();
                continue jmp_20084a8;
              }

              //LAB_20086aa
              CPU.cmpT(r6, 0x3);
              if(CPU.cpsr().getZero()) { // ==
                r0 = FUN_2009404();
                continue jmp_20084a8;
              }

              //LAB_2008714
              CPU.cmpT(r6, 0x4);
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.movT(0, 0x4);
                r0 = FUN_20093f4(r0);
                r1 = CPU.movT(0, 0x1);
                r6 = CPU.addT(r0, 0x0);
                r1 = CPU.negT(r1, r1);
                r6 = CPU.cmpT(r6, r1);
                if(CPU.cpsr().getZero()) { // ==
                  continue jmp_20084a8;
                }

                //LAB_200872a
                r5 = MEMORY.ref(4, 0x2008864).get();
                r2 = CPU.movT(0, 0xfa);
                r2 = CPU.lslT(r2, 1);
                r3 = CPU.addT(r5, r2);
                r2 = CPU.movT(0, 0x0);
                MEMORY.ref(4, r3).setu(r2);
                r0 = MEMORY.ref(4, 0x2008868).get();
                r0 = FUN_2009454(r0);
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  FUN_200948c();
                  r0 = CPU.movT(0, 0x0);
                  r0 = FUN_2009474(r0);
                  r0 = CPU.movT(0, 0x1);
                  r0 = FUN_2009474(r0);
                  r0 = CPU.movT(0, 0x2);
                  r0 = FUN_2009474(r0);
                  r0 = CPU.movT(0, 0x3);
                  r0 = FUN_2009474(r0);
                  r0 = CPU.movT(0, 0x0);
                  r0 = FUN_200946c(r0);
                  r0 = CPU.movT(0, 0x1);
                  r0 = FUN_200946c(r0);
                  r0 = CPU.movT(0, 0x2);
                  r0 = FUN_200946c(r0);
                  r0 = CPU.movT(0, 0x3);
                  r0 = FUN_200946c(r0);
                }

                //LAB_2008774
                r0 = MEMORY.ref(4, 0x200886c).get();
                r1 = MEMORY.ref(4, 0x2008870).get();
                r3 = CPU.addT(r5, r0);
                r0 = MEMORY.ref(1, r3).getUnsigned();
                r3 = CPU.addT(r5, r1);
                r1 = MEMORY.ref(1, r3).getUnsigned();
                FUN_200941c(r0, r1);
                r0 = MEMORY.ref(4, 0x2008874).get();
                FUN_2009464(r0);
                r0 = CPU.movT(0, 0x83);
                r0 = CPU.lslT(r0, 1);
                FUN_2009464(r0);
                r0 = CPU.movT(0, 0xbf);
                r0 = CPU.lslT(r0, 1);
                FUN_200945c(r0);
                r2 = MEMORY.ref(4, 0x2008878).get();
                r3 = CPU.movT(0, 0x1);
                MEMORY.ref(1, r2).setu(r3);
                r0 = MEMORY.ref(4, 0x200887c).get();
                r1 = CPU.movT(0, 0x1);
                FUN_20094a4(r0, r1);
              } else {
                //LAB_20087b2
                CPU.cmpT(r6, 0x5);
                if(!CPU.cpsr().getZero()) { // !=
                  continue jmp_20084a8;
                }

                jmp_20087b8:
                while(true) {
                  r0 = CPU.movT(0, 0x5);
                  r0 = FUN_20093f4(r0);
                  r2 = CPU.movT(0, 0x1);
                  r6 = CPU.addT(r0, 0x0);
                  r2 = CPU.negT(r2, r2);
                  r6 = CPU.cmpT(r6, r2);
                  if(CPU.cpsr().getZero()) { // ==
                    continue jmp_20084a8;
                  }

                  //LAB_20087ca
                  r2 = MEMORY.ref(4, 0x2008864).get();
                  r0 = MEMORY.ref(4, 0x200886c).get();
                  r1 = MEMORY.ref(4, 0x2008870).get();
                  r3 = CPU.addT(r2, r0);
                  r2 = CPU.addT(r2, r1);
                  r0 = MEMORY.ref(1, r3).getUnsigned();
                  r1 = MEMORY.ref(1, r2).getUnsigned();
                  FUN_200941c(r0, r1);

                  //LAB_20087dc
                  do {
                    do {
                      r0 = CPU.movT(0, 0x0);
                      r0 = FUN_20093d4(r0);
                      r2 = CPU.movT(0, 0x1);
                      r6 = CPU.addT(r0, 0x0);
                      r2 = CPU.negT(r2, r2);
                      r6 = CPU.cmpT(r6, r2);
                      if(CPU.cpsr().getZero()) { // ==
                        continue jmp_20087b8;
                      }
                      CPU.cmpT(r6, 0x1);
                      if(CPU.cpsr().getZero()) { // ==
                        break;
                      }
                      //LAB_20089cc
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r0 = CPU.movT(0, 0x96);
                        r0 = CPU.lslT(r0, 1);
                        FUN_2009324(r0);
                        continue jmp_20084a8;
                      }

                      jmp_20089d2:
                      while(true) {
                        r0 = CPU.movT(0, 0x1);
                        r0 = FUN_20093d4(r0);
                        r6 = CPU.addT(r0, 0x0);
                        r0 = CPU.movT(0, 0x1);
                        r0 = CPU.negT(r0, r0);
                        r6 = CPU.cmpT(r6, r0);
                        if(!CPU.cpsr().getZero()) { // !=
                          //LAB_20089e4
                          r5 = CPU.sp().value + 0x15c;
                          r2 = CPU.addT(r5, 0x0);
                          r1 = CPU.addT(r6, 0x0);
                          r0 = CPU.movT(0, 0x0);
                          r0 = FUN_2008de4(r0, r1, r2);
                          r1 = CPU.addT(r5, 0x0);
                          CPU.r9().value = r0;
                          r0 = FUN_20092c8(r0, r1);
                          r3 = CPU.r9().value;
                          r0 = CPU.lslT(r0, 16);
                          r3 = CPU.addT(r3, 0x1);
                          r2 = CPU.asrT(r0, 16);
                          r1 = CPU.r9().value;
                          r0 = CPU.lsrT(r0, 24);
                          MEMORY.ref(1, r5 + r1).setu(r0);
                          MEMORY.ref(1, r5 + r3).setu(r2);
                          r2 = CPU.movT(0, 0x2);
                          CPU.r9().value += r2;
                          r1 = CPU.r9().value;
                          r2 = CPU.sp().value + 0x1c;
                          r0 = CPU.addT(r5, 0x0);
                          r0 = FUN_20091e4(r0, r1, r2);
                          CPU.r9().value = r0;
                          loadUiTextures();
                          r6 = CPU.movT(0, 0x2);
                          r2 = CPU.movT(0, 0x14);
                          r1 = CPU.movT(0, 0x4);
                          r3 = CPU.movT(0, 0xc);
                          r0 = CPU.movT(0, 0x5);
                          MEMORY.ref(4, CPU.sp().value).setu(r6);
                          FUN_2009384(r0, r1, r2, r3);
                          r3 = CPU.movT(0, 0x0);
                          r1 = CPU.movT(0, 0x32);
                          CPU.r10().value = r0;
                          r0 = CPU.r9().value;
                          CPU.r11().value = r3;
                          r0 = FUN_2009314(r0, r1);
                          r0 = CPU.addT(r0, 0x1);
                          CPU.r8().value = r0;
                          r1 = CPU.movT(0, 0x0);
                          r2 = CPU.movT(0, 0xa);
                          r3 = CPU.movT(0, 0x4);
                          r0 = CPU.movT(0, 0xa);
                          MEMORY.ref(4, CPU.sp().value).setu(r6);
                          FUN_2009384(r0, r1, r2, r3);
                          r5 = MEMORY.ref(4, 0x2008b24).get();
                          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                          r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                          r0 = CPU.addT(r5, 0x0);
                          r2 = CPU.movT(0, 0x6);
                          r3 = CPU.movT(0, 0x4);
                          FUN_20093ac(r0, r1, r2, r3);
                          r0 = CPU.r8().value;
                          r7 = CPU.movT(0, 0x1);
                          CPU.cmpT(r0, 0x1);
                          if(CPU.cpsr().getZero()) { // ==
                            r1 = CPU.movT(0, 0x10);
                            r2 = CPU.movT(0, 0x14);
                            r3 = CPU.movT(0, 0x3);
                            r0 = CPU.movT(0, 0x5);
                            MEMORY.ref(4, CPU.sp().value).setu(r6);
                            FUN_2009384(r0, r1, r2, r3);
                            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
                            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                            r0 = CPU.subT(r5, 0x2);
                            r2 = CPU.movT(0, 0x50);
                            r3 = CPU.movT(0, 0x0);
                            FUN_20093b4(r0, r1, r2, r3);
                          } else {
                            //LAB_2008a82
                            r1 = CPU.movT(0, 0x10);
                            r2 = CPU.movT(0, 0x1c);
                            r3 = CPU.movT(0, 0x3);
                            r0 = CPU.movT(0, 0x1);
                            MEMORY.ref(4, CPU.sp().value).setu(r6);
                            FUN_2009384(r0, r1, r2, r3);
                            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
                            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                            r0 = CPU.subT(r5, 0x1);
                            r2 = CPU.movT(0, 0x0);
                            r3 = CPU.movT(0, 0x0);
                            FUN_20093b4(r0, r1, r2, r3);
                          }

                          //LAB_2008a9e
                          r0 = MEMORY.ref(4, 0x2008b28).get();
                          FUN_200942c(r0);
                          r0 = CPU.r10().value;
                          FUN_200939c(r0);

                          //LAB_2008aaa
                          do {
                            r0 = MEMORY.ref(4, 0x2008b2c).get();
                            FUN_2009434(r0);
                            r1 = MEMORY.ref(4, 0x2008b08).get();
                            r2 = MEMORY.ref(4, r1).get();
                            r3 = CPU.movT(0, 0x2);
                            r2 = CPU.andT(r2, r3);
                            CPU.cmpT(r2, 0x0);
                            if(!CPU.cpsr().getZero()) { // !=
                              //LAB_20089a6
                              r0 = CPU.movT(0, 0x71);
                              FUN_20094cc(r0);
                              r0 = CPU.r10().value;
                              FUN_200939c(r0);
                              r0 = CPU.r10().value;
                              r1 = CPU.movT(0, 0x2);
                              FUN_200938c(r0, r1);
                              r1 = CPU.movT(0, 0x2);
                              r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                              FUN_200938c(r0, r1);
                              r1 = CPU.movT(0, 0x2);
                              r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                              FUN_200938c(r0, r1);
                              continue jmp_20089d2;
                            }

                            //LAB_2008abe
                            r2 = MEMORY.ref(4, r1).get();
                            r3 = CPU.movT(0, 0x1);
                            r2 = CPU.andT(r2, r3);
                            CPU.cmpT(r2, 0x0);
                            if(!CPU.cpsr().getZero()) { // !=
                              CPU.r11().value += r3;
                              r7 = CPU.movT(0, 0x1);
                              CPU.cmpT(CPU.r11().value, CPU.r8().value);
                              if(CPU.cpsr().getZero()) { // ==
                                //LAB_2008474
                                r0 = CPU.movT(0, 0x70);
                                FUN_20094cc(r0);
                                r0 = CPU.r10().value;
                                FUN_200939c(r0);
                                r0 = CPU.r10().value;
                                r1 = CPU.movT(0, 0x2);
                                FUN_200938c(r0, r1);
                                r1 = CPU.movT(0, 0x2);
                                r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                                FUN_200938c(r0, r1);
                                r1 = CPU.movT(0, 0x2);
                                r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                                FUN_200938c(r0, r1);
                                r0 = CPU.movT(0, 0x1);
                                FUN_2009324(r0);
                                continue jmp_20084a8;
                              }

                              //LAB_2008ad2
                              r0 = CPU.movT(0, 0x6f);
                              FUN_20094cc(r0);
                            } else {
                              //LAB_2008ada
                              r3 = MEMORY.ref(4, 0x2008b08).get();
                              r2 = MEMORY.ref(4, r3).get();
                              r3 = CPU.movT(0, 0x20);
                              r2 = CPU.andT(r2, r3);
                              if(r2 != 0 && CPU.r8().value > 1) {
                                r0 = CPU.movT(0, 0x6f);
                                FUN_20094cc(r0);
                                r0 = CPU.r11().value;
                                r0 += CPU.r8().value;
                                r0 = CPU.subT(r0, 0x1);
                                r1 = CPU.r8().value;
                                r0 = FUN_200931c(r0, r1);
                                r7 = CPU.movT(0, 0x1);
                                CPU.r11().value = r0;
                              } else {
                                //LAB_2008b30
                                r1 = MEMORY.ref(4, 0x2008cd8).get();
                                r2 = MEMORY.ref(4, r1).get();
                                r3 = CPU.movT(0, 0x10);
                                r2 = CPU.andT(r2, r3);
                                CPU.cmpT(r2, 0x0);
                                if(!CPU.cpsr().getZero()) { // !=
                                  r2 = CPU.r8().value;
                                  CPU.cmpT(r2, 0x1);
                                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                                    r0 = CPU.movT(0, 0x6f);
                                    FUN_20094cc(r0);
                                    r0 = CPU.r11().value;
                                    r0 += CPU.r8().value;
                                    r0 = CPU.addT(r0, 0x1);
                                    r1 = CPU.r8().value;
                                    r0 = FUN_200931c(r0, r1);
                                    r7 = CPU.movT(0, 0x1);
                                    CPU.r11().value = r0;
                                  }
                                }
                              }
                            }

                            //LAB_2008b58
                            CPU.cmpT(r7, 0x1);
                            if(CPU.cpsr().getZero()) { // ==
                              //LAB_2008b5e
                              r0 = CPU.r10().value;
                              FUN_200939c(r0);
                              r7 = CPU.movT(0, 0x0);
                              r5 = CPU.movT(0, 0x2);

                              //LAB_2008b68
                              do {
                                r2 = CPU.addT(r5, 0x0);
                                r0 = CPU.r10().value;
                                r1 = CPU.movT(0, 0x0);
                                r3 = CPU.movT(0, 0x12);
                                r7 = CPU.addT(r7, 0x1);
                                MEMORY.ref(4, CPU.sp().value).setu(r5);
                                FUN_20093a4(r0, r1, r2, r3);
                                r5 = CPU.addT(r5, 0x2);
                                CPU.cmpT(r7, 0x4);
                              } while(!CPU.cpsr().getZero()); // !=

                              r3 = CPU.r8().value;
                              CPU.cmpT(r3, 0x1);
                              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                                r7 = CPU.movT(0, 0x0);
                                CPU.cmpT(r3, 0x0);
                                if(!CPU.cpsr().getZero()) { // !=
                                  r3 = CPU.negT(r3, r3);
                                  r5 = CPU.addT(r3, 0x0);
                                  r6 = CPU.movT(0, 0x0);
                                  r5 = CPU.addT(r5, 0x12);

                                  //LAB_2008b92
                                  do {
                                    r0 = MEMORY.ref(4, 0x2008cdc).get();
                                    r1 = CPU.addT(r7, r0);
                                    CPU.cmpT(r7, CPU.r11().value);
                                    if(CPU.cpsr().getZero()) { // ==
                                      r2 = MEMORY.ref(4, 0x2008ce0).get();
                                      r1 = CPU.addT(r7, r2);
                                    }

                                    //LAB_2008b9e
                                    r3 = CPU.movT(0, 0x1);
                                    r2 = CPU.addT(r5, 0x0);
                                    r0 = CPU.r10().value;
                                    r3 = CPU.negT(r3, r3);
                                    r7 = CPU.addT(r7, 0x1);
                                    MEMORY.ref(4, CPU.sp().value).setu(r6);
                                    r5 = CPU.addT(r5, 0x1);
                                    FUN_20093e4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                                    CPU.cmpT(r7, CPU.r8().value);
                                  } while(!CPU.cpsr().getZero()); // !=
                                }

                                //LAB_2008bb4
                                r3 = CPU.r8().value;
                                r2 = CPU.movT(0, 0x11);
                                r2 = CPU.subT(r2, r3);
                                r3 = CPU.movT(0, 0x1);
                                r5 = CPU.movT(0, 0x0);
                                r0 = CPU.r10().value;
                                r1 = MEMORY.ref(4, 0x2008ce4).get();
                                r3 = CPU.negT(r3, r3);
                                MEMORY.ref(4, CPU.sp().value).setu(r5);
                                FUN_20093e4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                                r3 = CPU.movT(0, 0x1);
                                r0 = CPU.r10().value;
                                r1 = MEMORY.ref(4, 0x2008ce8).get();
                                r2 = CPU.movT(0, 0x12);
                                r3 = CPU.negT(r3, r3);
                                MEMORY.ref(4, CPU.sp().value).setu(r5);
                                FUN_20093e4(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                                r3 = MEMORY.ref(4, 0x2008cec).get();
                                r2 = CPU.r10().value;
                                r1 = MEMORY.ref(4, r3).get();
                                r0 = MEMORY.ref(4, 0x2008cf0).get();
                                r3 = MEMORY.ref(2, r2 + 0xe).getUnsigned();
                                r1 = CPU.addT(r1, r0);
                                r3 = CPU.lsrT(r3, 2);
                                r2 = CPU.movT(0, 0x2);
                                r2 = CPU.lslT(r2, r3);
                                r3 = MEMORY.ref(1, r1).getUnsigned();
                                r2 = CPU.orrT(r2, r3);
                                MEMORY.ref(1, r1).setu(r2);
                              }

                              //LAB_2008bf2
                              r3 = CPU.movT(0, 0x32);
                              r0 = CPU.r11().value;
                              r0 = CPU.mulT(r0, r3);
                              r6 = CPU.addT(r0, 0x0);
                              r6 = CPU.addT(r6, 0x32);
                              CPU.cmpT(r6, CPU.r9().value);
                              if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                                r6 = CPU.r9().value;
                              }

                              //LAB_2008c02
                              r7 = CPU.addT(r0, 0x0);
                              r4 = CPU.movT(0, 0x0);
                              r7 = CPU.cmpT(r7, r6);
                              if(!CPU.cpsr().getZero()) { // !=
                                //LAB_2008c0a
                                do {
                                  r3 = CPU.sp().value + 0x1c;
                                  r3 = MEMORY.ref(1, r3 + r7).getUnsigned();
                                  r0 = CPU.movT(0, 0x3f);
                                  r0 = CPU.andT(r0, r3);
                                  r1 = CPU.sp().value + 0x18;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                                  FUN_20082f4(r0, r1);
                                  r0 = CPU.addT(r7, 0x0);
                                  r1 = CPU.movT(0, 0xa);
                                  r0 = FUN_200931c(r0, r1);
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                                  CPU.cmpT(r0, 0x4);
                                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                                    r0 = CPU.addT(r4, 0x0);
                                    r1 = CPU.movT(0, 0xa);
                                    r0 = FUN_200931c(r0, r1);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                                    r5 = CPU.addT(r0, 0x0);
                                    r1 = CPU.movT(0, 0xa);
                                    r0 = CPU.addT(r4, 0x0);
                                    r0 = FUN_2009314(r0, r1);
                                    r2 = CPU.lslT(r5, 1);
                                    r3 = CPU.addT(r0, 0x0);
                                    r2 = CPU.addT(r2, r5);
                                    r2 = CPU.lslT(r2, 2);
                                    r3 = CPU.lslT(r3, 4);
                                    r2 = CPU.addT(r2, 0x12);
                                  } else {
                                    //LAB_2008c4a
                                    r0 = CPU.addT(r4, 0x0);
                                    r1 = CPU.movT(0, 0xa);
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                                    r0 = FUN_200931c(r0, r1);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                                    r5 = CPU.addT(r0, 0x0);
                                    r1 = CPU.movT(0, 0xa);
                                    r0 = CPU.addT(r4, 0x0);
                                    r0 = FUN_2009314(r0, r1);
                                    r2 = CPU.lslT(r5, 1);
                                    r3 = CPU.addT(r0, 0x0);
                                    r2 = CPU.addT(r2, r5);
                                    r2 = CPU.lslT(r2, 2);
                                    r3 = CPU.lslT(r3, 4);
                                    r2 = CPU.addT(r2, 0x8);
                                  }

                                  //LAB_2008c6c
                                  r3 = CPU.addT(r3, 0x2);
                                  r0 = CPU.sp().value + 0x18;
                                  r1 = CPU.r10().value;
                                  FUN_20093bc(r0, r1, r2, r3);
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                                  r7 = CPU.addT(r7, 0x1);
                                  r4 = CPU.addT(r4, 0x1);
                                  r7 = CPU.cmpT(r7, r6);
                                } while(!CPU.cpsr().getZero()); // !=
                              }

                              //LAB_2008c80
                              r7 = CPU.movT(0, 0x0);
                            }

                            //LAB_2008c82
                            r0 = CPU.movT(0, 0x1);
                            FUN_2009324(r0);
                          } while(true);

                          // unreachable break jmp_2008c96;
                        }

                        break;
                      }
                    } while(true);

                    //LAB_20087f2
                    r3 = CPU.movT(0, 0x2);
                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                    r1 = CPU.movT(0, 0x5);
                    r2 = CPU.movT(0, 0x12);
                    r3 = CPU.movT(0, 0x8);
                    r0 = CPU.movT(0, 0x6);
                    FUN_2009384(r0, r1, r2, r3);
                    r5 = MEMORY.ref(4, 0x2008880).get();
                    r6 = CPU.addT(r0, 0x0);
                    r1 = CPU.addT(r6, 0x0);
                    r0 = CPU.addT(r5, 0x0);
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.movT(0, 0x4);
                    FUN_20093ac(r0, r1, r2, r3);
                    r0 = CPU.addT(r5, 0x1);
                    r1 = CPU.addT(r6, 0x0);
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.movT(0, 0x10);
                    r5 = CPU.addT(r5, 0x3);
                    FUN_20093ac(r0, r1, r2, r3);
                    r0 = CPU.addT(r5, 0x0);
                    r1 = CPU.addT(r6, 0x0);
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.movT(0, 0x24);
                    FUN_20093ac(r0, r1, r2, r3);
                    FUN_200936c();
                    r0 = CPU.movT(0, 0xa);
                    FUN_2009324(r0);
                    r2 = MEMORY.ref(4, 0x2008884).get();
                    r3 = MEMORY.ref(4, 0x2008860).get();
                    MEMORY.ref(2, r2).setu(r3);
                    MEMORY.ref(2, r2 + 0x2).setu(r3);
                    MEMORY.ref(2, r2 + 0x4).setu(r3);
                    MEMORY.ref(2, r2 + 0x6).setu(r3);
                    r2 = MEMORY.ref(4, 0x2008860).get();
                    r3 = MEMORY.ref(4, 0x2008888).get();
                    r7 = CPU.movT(0, 0x0);
                    r5 = CPU.movT(0, 0x3);
                    r1 = CPU.movT(0, 0x0);

                    //LAB_200884c
                    do {
                      r1 = CPU.addT(r1, 0x1);
                      MEMORY.ref(2, r3).setu(r2);
                      MEMORY.ref(2, r3 + 0x2).setu(r2);
                      MEMORY.ref(2, r3 + 0x4).setu(r2);
                      MEMORY.ref(2, r3 + 0x6).setu(r2);
                      r3 = CPU.addT(r3, 0x18);
                      CPU.cmpT(r1, 0x4);
                    } while(!CPU.cpsr().getZero()); // !=

                    r3 = MEMORY.ref(4, 0x2008b08).get();
                    r2 = MEMORY.ref(4, r3).get();
                    r3 = CPU.movT(0, 0x2);
                    r2 = CPU.andT(r2, r3);
                    CPU.cmpT(r2, 0x0);

                    jmp_20088e0:
                    {
                      //LAB_200888c
                      while(CPU.cpsr().getZero()) { // ==
                        r3 = MEMORY.ref(4, 0x2008afc).get();
                        r2 = MEMORY.ref(2, r3).getUnsigned();
                        r3 = CPU.addT(r5, 0x0);
                        r3 = CPU.andT(r3, r2);
                        r3 = CPU.cmpT(r3, r5);
                        if(CPU.cpsr().getZero()) { // ==
                          r3 = MEMORY.ref(4, 0x2008b00).get();
                          r3 = MEMORY.ref(4, r3).get();
                          r3 = CPU.lslT(r3, 26);
                          r2 = CPU.movT(0, 0x1);
                          r3 = CPU.lsrT(r3, 30);
                          r3 = CPU.eorT(r3, r2);
                          r2 = CPU.lslT(r3, 1);
                          r2 = CPU.addT(r2, r3);
                          r3 = MEMORY.ref(4, 0x2008b04).get();
                          r2 = CPU.lslT(r2, 3);
                          r2 = CPU.addT(r2, r3);
                          r3 = MEMORY.ref(2, r2).getUnsigned();
                          CPU.cmpT(r3, 0x55);
                          if(CPU.cpsr().getZero()) { // ==
                            r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
                            CPU.cmpT(r3, 0x56);
                            if(CPU.cpsr().getZero()) { // ==
                              r3 = MEMORY.ref(2, r2 + 0x4).getUnsigned();
                              CPU.cmpT(r3, 0x54);
                              if(CPU.cpsr().getZero()) { // ==
                                r3 = MEMORY.ref(2, r2 + 0x6).getUnsigned();
                                CPU.cmpT(r3, 0x53);
                                if(CPU.cpsr().getZero()) { // ==
                                  r7 = CPU.movT(0, 0x1);
                                  break jmp_20088e0;
                                }
                              }
                            }
                          }
                        }

                        //LAB_20088c8
                        r0 = CPU.movT(0, 0x1);
                        FUN_2009324(r0);

                        //LAB_20088ce
                        r3 = MEMORY.ref(4, 0x2008b08).get();
                        r2 = MEMORY.ref(4, r3).get();
                        r3 = CPU.movT(0, 0x2);
                        r2 = CPU.andT(r2, r3);
                        CPU.cmpT(r2, 0x0);
                      }

                      r0 = CPU.movT(0, 0x71);
                      FUN_20094cc(r0);
                    }

                    //LAB_20088e0
                    r0 = CPU.addT(r6, 0x0);
                    r1 = CPU.movT(0, 0x2);
                    FUN_200938c(r0, r1);
                    CPU.cmpT(r7, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      //LAB_20088ee
                      r3 = CPU.movT(0, 0x2);
                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                      r1 = CPU.movT(0, 0xa);
                      r2 = CPU.movT(0, 0x14);
                      r3 = CPU.movT(0, 0x4);
                      r0 = CPU.movT(0, 0x5);
                      FUN_2009384(r0, r1, r2, r3);
                      r6 = CPU.addT(r0, 0x0);
                      r2 = CPU.movT(0, 0x0);
                      r3 = CPU.movT(0, 0x4);
                      r1 = CPU.addT(r6, 0x0);
                      r0 = MEMORY.ref(4, 0x2008b0c).get();
                      FUN_20093ac(r0, r1, r2, r3);
                      r0 = CPU.movT(0, 0xa);
                      FUN_2009324(r0);
                      r1 = MEMORY.ref(4, 0x2008b10).get();
                      r0 = MEMORY.ref(4, 0x2008b14).get();
                      FUN_200937c(r0, r1);
                      r0 = CPU.movT(0, 0xa);
                      FUN_2009324(r0);
                      r5 = CPU.movT(0, 0x0);
                      r1 = CPU.movT(0, 0x3);
                      r4 = CPU.movT(0, 0x1);
                      r7 = CPU.movT(0, 0x0);
                      r3 = MEMORY.ref(4, 0x2008b18).get();
                      r7 = CPU.cmpT(r7, r3);
                      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                        r3 = MEMORY.ref(4, 0x2008afc).get();
                        r2 = MEMORY.ref(2, r3).getUnsigned();
                        r3 = CPU.addT(r1, 0x0);
                        r3 = CPU.andT(r3, r2);
                        r5 = CPU.addT(r5, 0x1);
                        r3 = CPU.cmpT(r3, r1);
                        if(CPU.cpsr().getZero()) { // ==
                          r5 = CPU.movT(0, 0x0);
                        }

                        //LAB_2008950
                        CPU.cmpT(r5, 0xa);
                        if(CPU.cpsr().getZero()) { // ==
                          r4 = CPU.movT(0, 0x0);
                        } else {
                          //LAB_2008956
                          r3 = MEMORY.ref(4, 0x2008b1c).get();
                          r3 = MEMORY.ref(4, r3).get();
                          CPU.cmpT(r3, 0x0);

                          //LAB_200892a
                          while(!CPU.cpsr().getZero()) { // !=
                            r0 = CPU.movT(0, 0x1);
                            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
                            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                            FUN_2009324(r0);
                            r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                            r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                            r7 = CPU.addT(r7, 0x1);

                            //LAB_200893a
                            r3 = MEMORY.ref(4, 0x2008b18).get();
                            r7 = CPU.cmpT(r7, r3);
                            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                              break;
                            }
                            r3 = MEMORY.ref(4, 0x2008afc).get();
                            r2 = MEMORY.ref(2, r3).getUnsigned();
                            r3 = CPU.addT(r1, 0x0);
                            r3 = CPU.andT(r3, r2);
                            r5 = CPU.addT(r5, 0x1);
                            r3 = CPU.cmpT(r3, r1);
                            if(CPU.cpsr().getZero()) { // ==
                              r5 = CPU.movT(0, 0x0);
                            }

                            //LAB_2008950
                            CPU.cmpT(r5, 0xa);
                            if(CPU.cpsr().getZero()) { // ==
                              r4 = CPU.movT(0, 0x0);
                              break;
                            }

                            //LAB_2008956
                            r3 = MEMORY.ref(4, 0x2008b1c).get();
                            r3 = MEMORY.ref(4, r3).get();
                            CPU.cmpT(r3, 0x0);
                          }
                        }
                      }

                      //LAB_200895e
                      CPU.cmpT(r4, 0x0);
                      if(CPU.cpsr().getZero()) { // ==
                        r0 = CPU.addT(r6, 0x0);
                        FUN_200939c(r0);
                        r0 = MEMORY.ref(4, 0x2008b20).get();
                        r1 = CPU.addT(r6, 0x0);
                        r2 = CPU.movT(0, 0x0);
                        r3 = CPU.movT(0, 0x4);
                        FUN_20093ac(r0, r1, r2, r3);
                        r7 = MEMORY.ref(4, 0x2008b08).get();
                        r5 = CPU.movT(0, 0x1);

                        //LAB_2008978
                        do {
                          r0 = CPU.movT(0, 0x1);
                          FUN_2009324(r0);
                          r3 = MEMORY.ref(4, r7).get();
                          r3 = CPU.andT(r3, r5);
                          CPU.cmpT(r3, 0x0);
                        } while(CPU.cpsr().getZero()); // ==
                      }

                      //LAB_2008986
                      r0 = CPU.movT(0, 0xa);
                      FUN_2009324(r0);
                      FUN_2009374();
                      r0 = CPU.movT(0, 0xa);
                      FUN_2009324(r0);
                      r0 = CPU.addT(r6, 0x0);
                      FUN_200939c(r0);
                      r0 = CPU.addT(r6, 0x0);
                      r1 = CPU.movT(0, 0x2);
                      FUN_200938c(r0, r1);
                      continue jmp_20084a8;
                    }
                  } while(true);

                  // unreachable break;
                }
              }
            }
          }
        }

        break;
      }

      //LAB_2008c96
      r3 = MEMORY.ref(4, 0x2008cf4).get();
      r0 = CPU.movT(0, 0xb8);
      r3 = MEMORY.ref(4, r3).get();
      r2 = MEMORY.ref(4, 0x2008cf8).get();
      r0 = CPU.lslT(r0, 1);
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r3).setu(r2);
      r0 = CPU.movT(0, 0x1e);
      FUN_2009494(r0);
      r0 = CPU.movT(0, 0x11);
      FUN_20094cc(r0);
      FUN_20094b4();
      FUN_20094bc();
      r0 = CPU.movT(0, 0x3c);
      FUN_2009494(r0);
    }

    //LAB_2008cbe
    r0 = CPU.movT(0, 0x0);
    r3 = CPU.movT(0, 0x89);
    r3 = CPU.lslT(r3, 2);
    CPU.sp().value += r3;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x2008de4)
  public static int FUN_2008de4(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x40;
    r0 = CPU.movT(0, 0xb);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
    CPU.r11().value = r2;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    CPU.cmpT(r1, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_2008e18
      r3 = CPU.movT(0, 0x27);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    } else {
      CPU.cmpT(r1, 0x1);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        CPU.cmpT(r1, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_2008e12
          r2 = CPU.movT(0, 0xad);
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
        }
      } else {
        //LAB_2008e0a
        r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        CPU.cmpT(r1, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_2008e1e
          r4 = CPU.movT(0, 0x9);
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
        }
      }
    }

    //LAB_2008e22
    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r6 = CPU.movT(0, 0x0);
    CPU.r9().value = r6;
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.r11().value;

      //LAB_2008e30
      do {
        MEMORY.ref(1, r3).setu(r2);
        r1 = CPU.movT(0, 0x1);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        CPU.r9().value += r1;
        r3 = CPU.addT(r3, 0x1);
        CPU.cmpT(CPU.r9().value, r4);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_2008e3e
    r0 = CPU.sp().value;
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.addT(r0, 0x20);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    CPU.r9().value = r6;
    r2 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r0, 0x0);

    //LAB_2008e54
    do {
      r1 = CPU.movT(0, 0x1);
      CPU.r9().value += r1;
      r4 = CPU.r9().value;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      CPU.cmpT(r4, 0x8);
    } while(!CPU.cpsr().getZero()); // !=

    r6 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(4, 0x2009028).get();
    CPU.r9().value = r6;
    r6 = CPU.movT(0, 0x1);

    //LAB_2008e68
    do {
      r0 = MEMORY.ref(2, r5).getUnsigned();
      r5 = CPU.addT(r5, 0x2);
      r0 = FUN_2009454(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = CPU.addT(r6, 0x0);
        r0 = CPU.r9().value;
        r3 = CPU.lslT(r3, r0);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lslT(r1, 24);
        r3 = CPU.lsrT(r3, 24);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
      }

      //LAB_2008e84
      r2 = CPU.movT(0, 0x1);
      CPU.r9().value += r2;
      r3 = CPU.r9().value;
      CPU.cmpT(r3, 0x6);
    } while(!CPU.cpsr().getZero()); // !=

    r4 = CPU.movT(0, 0x0);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.r9().value = r4;

    //LAB_2008e94
    do {
      r2 = MEMORY.ref(4, 0x200902c).get();
      r6 = CPU.r9().value;
      r3 = CPU.lslT(r6, 2);
      r0 = MEMORY.ref(4, r2 + r3).get();
      r0 = FUN_200943c(r0);
      CPU.r12().value = r0;
      r1 = CPU.r12().value;
      r1 = CPU.addT(r1, 0x10);
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r1 + r0).get();
      r0 = MEMORY.ref(4, 0x2009030).get();
      r2 = MEMORY.ref(2, r1).getUnsigned();
      r3 = CPU.cmpT(r3, r0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        MEMORY.ref(2, r1).setu(r0);
        r2 = CPU.addT(r0, 0x0);
      }

      //LAB_2008eb6
      r3 = CPU.lslT(r2, 16);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r1).setu(r3);
      }

      //LAB_2008ec0
      r4 = CPU.movT(0, 0x2);
      r3 = MEMORY.ref(2, r1 + r4).get();
      r2 = MEMORY.ref(2, r1 + 0x2).getUnsigned();
      r3 = CPU.cmpT(r3, r0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        MEMORY.ref(2, r1 + 0x2).setu(r0);
        r2 = CPU.addT(r0, 0x0);
      }

      //LAB_2008ece
      r3 = CPU.lslT(r2, 16);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r1 + 0x2).setu(r3);
      }

      //LAB_2008ed8
      r3 = MEMORY.ref(2, r1 + 0x8).getUnsigned();
      r2 = MEMORY.ref(4, 0x2009034).get();
      r3 = CPU.cmpT(r3, r2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        MEMORY.ref(2, r1 + 0x8).setu(r2);
      }

      //LAB_2008ee2
      r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
      r3 = CPU.cmpT(r3, r2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        MEMORY.ref(2, r1 + 0xa).setu(r2);
      }

      //LAB_2008eea
      r3 = MEMORY.ref(2, r1 + 0xc).getUnsigned();
      r3 = CPU.cmpT(r3, r2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        MEMORY.ref(2, r1 + 0xc).setu(r2);
      }

      //LAB_2008ef2
      r3 = MEMORY.ref(1, r1 + 0xe).getUnsigned();
      CPU.cmpT(r3, 0x63);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r3 = CPU.movT(0, 0x63);
        MEMORY.ref(1, r1 + 0xe).setu(r3);
      }

      //LAB_2008efc
      r3 = CPU.movT(0, 0x0);
      r2 = MEMORY.ref(2, r1 + r3).get();
      r4 = CPU.movT(0, 0x2);
      r3 = MEMORY.ref(2, r1 + r4).get();
      r2 = CPU.lslT(r2, 21);
      r3 = CPU.lslT(r3, 10);
      r2 = CPU.orrT(r2, r3);
      r3 = MEMORY.ref(2, r1 + 0x8).getUnsigned();
      r2 = CPU.orrT(r2, r3);
      MEMORY.ref(4, r7).setu(r2);
      r3 = MEMORY.ref(2, r1 + 0xc).getUnsigned();
      r2 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
      r3 = CPU.lslT(r3, 12);
      r2 = CPU.lslT(r2, 22);
      r2 = CPU.orrT(r2, r3);
      r3 = MEMORY.ref(1, r1 + 0xe).getUnsigned();
      r3 = CPU.lslT(r3, 4);
      r2 = CPU.orrT(r2, r3);
      r6 = CPU.r9().value;
      MEMORY.ref(4, r7 + 0x4).setu(r2);
      r0 = CPU.lslT(r6, 3);
      r6 = CPU.r12().value;
      r2 = MEMORY.ref(1, r6 + 0xf).getUnsigned();
      r3 = CPU.addT(r2, 0x0);
      CPU.cmpT(r3, 0x63);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r3 = CPU.movT(0, 0x63);
        MEMORY.ref(1, r6 + 0xf).setu(r3);
        r2 = CPU.movT(0, 0x63);
      }

      //LAB_2008f36
      r3 = CPU.addT(r2, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0x1);
        r1 = CPU.r12().value;
        MEMORY.ref(1, r1 + 0xf).setu(r3);
      }

      //LAB_2008f42
      r2 = CPU.r12().value;
      r3 = MEMORY.ref(1, r2 + 0xf).getUnsigned();
      r4 = CPU.r9().value;
      r2 = CPU.subT(r0, r4);
      r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r3 = CPU.lslT(r3, r2);
      r6 = CPU.orrT(r6, r3);
      r2 = CPU.r12().value;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r6);
      r5 = CPU.movT(0, 0x0);
      r2 = CPU.addT(r2, 0xf8);
      r1 = CPU.movT(0, 0x0);

      //LAB_2008f5a
      do {
        r3 = MEMORY.ref(4, r2).get();
        r2 += 0x4;

        r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r3 = CPU.lslT(r3, r1);
        r0 = CPU.addT(r0, r3);
        r5 = CPU.addT(r5, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
        r1 = CPU.addT(r1, 0x7);
        CPU.cmpT(r5, 0x4);
      } while(!CPU.cpsr().getZero()); // !=

      r1 = MEMORY.ref(4, 0x2009038).get();
      r2 = MEMORY.ref(4, 0x200903c).get();
      r3 = CPU.movT(0, 0x1);
      r0 = CPU.r12().value;
      r5 = CPU.movT(0, 0x0);
      CPU.r8().value = r1;
      CPU.lr().value = r2;
      CPU.r10().value = r3;
      r0 = CPU.addT(r0, 0xd8);

      //LAB_2008f7e
      do {
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r1 = CPU.r8().value;
        r4 = CPU.movT(0, 0x0);
        r1 = CPU.andT(r1, r3);
        r2 = CPU.lr().value;

        //LAB_2008f88
        do {
          r3 = MEMORY.ref(2, r2).getUnsigned();
          r2 = CPU.addT(r2, 0x2);
          r1 = CPU.cmpT(r1, r3);
          if(CPU.cpsr().getZero()) { // ==
            r6 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = CPU.r10().value;
            r3 = CPU.lslT(r3, r4);
            r6 = CPU.orrT(r6, r3);
            r3 = CPU.lslT(r6, 24);
            r3 = CPU.lsrT(r3, 24);
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
          }

          //LAB_2008f9e
          r4 = CPU.addT(r4, 0x1);
          CPU.cmpT(r4, 0x8);
        } while(!CPU.cpsr().getZero()); // !=

        r5 = CPU.addT(r5, 0x1);
        r0 = CPU.addT(r0, 0x2);
        CPU.cmpT(r5, 0xf);
      } while(!CPU.cpsr().getZero()); // !=

      r0 = CPU.movT(0, 0x1);
      CPU.r9().value += r0;
      r1 = CPU.r9().value;
      r7 = CPU.addT(r7, 0x8);
      CPU.cmpT(r1, 0x4);
    } while(!CPU.cpsr().getZero()); // !=

    //LAB_2008fba
    r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_2008fc2
      r3 = CPU.movT(0, 0x27);
      r6 = CPU.movT(0, 0x0);
      CPU.r10().value = r3;
      CPU.r9().value = r6;

      //LAB_2008fca
      do {
        r4 = CPU.r9().value;
        r3 = MEMORY.ref(4, 0x200902c).get();
        r2 = CPU.lslT(r4, 2);
        r0 = MEMORY.ref(4, r3 + r2).get();
        r0 = FUN_200943c(r0);
        r5 = CPU.r10().value;
        r4 = CPU.addT(r0, 0x0);
        r0 = CPU.movT(0, 0xd8);
        r7 = CPU.movT(0, 0x0);
        CPU.r8().value = r0;
        r5 += CPU.r11().value;

        //LAB_2008fe2
        do {
          r1 = CPU.r8().value;
          r0 = MEMORY.ref(2, r1 + r4).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = FUN_2009444(r0);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          r2 = CPU.r8().value;
          r1 = MEMORY.ref(2, r2 + r4).getUnsigned();
          r3 = MEMORY.ref(4, 0x2009024).get();
          r1 = CPU.andT(r1, r3);
          r0 = CPU.addT(r6, 0x1);
          r3 = MEMORY.ref(1, r5).getUnsigned();
          r2 = CPU.addT(r1, 0x0);
          r2 = CPU.asrT(r2, r0);
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(1, r5).setu(r3);
          r3 = CPU.movT(0, 0x7);
          r3 = CPU.subT(r3, r6);
          r1 = CPU.lslT(r1, r3);
          r3 = MEMORY.ref(1, r5 + 0x1).getUnsigned();
          r3 = CPU.addT(r3, r1);
          MEMORY.ref(1, r5 + 0x1).setu(r3);
          r6 = CPU.addT(r0, 0x0);
          r3 = CPU.movT(0, 0x1);
          r5 = CPU.addT(r5, 0x1);
          CPU.r10().value += r3;
          CPU.cmpT(r6, 0x7);
          if(CPU.cpsr().getZero()) { // ==
            r6 = CPU.movT(0, 0x0);
            r5 = CPU.addT(r5, 0x1);
            CPU.r10().value += r3;
          }

          //LAB_2009040
          r0 = CPU.movT(0, 0x2);
          r7 = CPU.addT(r7, 0x1);
          CPU.r8().value += r0;
          CPU.cmpT(r7, 0xf);
        } while(!CPU.cpsr().getZero()); // !=

        r1 = CPU.movT(0, 0x1);
        CPU.r9().value += r1;
        r2 = CPU.r9().value;
        CPU.cmpT(r2, 0x4);
      } while(!CPU.cpsr().getZero()); // !=

      r3 = CPU.movT(0, 0x6b);
      r6 = CPU.movT(0, 0x1);
      r4 = CPU.movT(0, 0x0);
      CPU.r10().value = r3;
      r6 = CPU.negT(r6, r6);
      CPU.r9().value = r4;

      //LAB_2009060
      do {
        r3 = MEMORY.ref(4, 0x20091d4).get();
        r0 = CPU.r9().value;
        r2 = CPU.lslT(r0, 2);
        r0 = MEMORY.ref(4, r3 + r2).get();
        r0 = FUN_200943c(r0);
        r2 = MEMORY.ref(4, 0x20091d8).get();
        CPU.r8().value = r0;
        r1 = CPU.movT(0, 0x0);
        r0 = CPU.r10().value;
        CPU.lr().value = r1;
        CPU.r12().value = r2;
        r0 += CPU.r11().value;

        //LAB_200907a
        do {
          r3 = CPU.r12().value;
          r1 = CPU.r8().value;
          r4 = MEMORY.ref(2, r3).getUnsigned();
          r5 = CPU.movT(0, 0x0);
          r7 = CPU.movT(0, 0x0);
          r1 = CPU.addT(r1, 0xd8);

          //LAB_2009086
          do {
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = MEMORY.ref(4, 0x20091dc).get();
            r3 = CPU.andT(r3, r2);
            r1 = CPU.addT(r1, 0x2);
            r3 = CPU.cmpT(r3, r4);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.movT(0, 0xf8);
              r3 = CPU.lslT(r3, 8);
              r3 = CPU.andT(r3, r2);
              r5 = CPU.lsrT(r3, 11);
            }

            //LAB_200909a
            r7 = CPU.addT(r7, 0x1);
            CPU.cmpT(r7, 0xf);
          } while(!CPU.cpsr().getZero()); // !=

          r2 = CPU.lslT(r5, 16);
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = CPU.lsrT(r2, 16);
            r3 = CPU.negT(r3, r6);
            r2 = CPU.addT(r1, 0x0);
            r2 = CPU.asrT(r2, r3);
            r3 = MEMORY.ref(1, r0).getUnsigned();
            r4 = CPU.movT(0, 0x1);
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(1, r0).setu(r3);
            CPU.r10().value += r4;
            r0 = CPU.addT(r0, 0x1);
            r6 = CPU.addT(r6, 0x8);
          } else {
            //LAB_20090be
            r1 = CPU.lsrT(r2, 16);
          }

          //LAB_20090c0
          r3 = MEMORY.ref(1, r0).getUnsigned();
          r1 = CPU.lslT(r1, r6);
          r3 = CPU.addT(r3, r1);
          r1 = CPU.movT(0, 0x5);
          r6 = CPU.subT(r6, 0x5);
          r1 = CPU.negT(r1, r1);
          MEMORY.ref(1, r0).setu(r3);
          r6 = CPU.cmpT(r6, r1);
          if(CPU.cpsr().getZero()) { // ==
            r2 = CPU.movT(0, 0x1);
            r0 = CPU.addT(r0, 0x1);
            CPU.r10().value += r2;
            r6 = CPU.movT(0, 0x3);
          }

          //LAB_20090da
          r4 = CPU.movT(0, 0x1);
          CPU.lr().value += r4;
          r3 = CPU.movT(0, 0x2);
          r1 = CPU.lr().value;
          CPU.r12().value += r3;
          CPU.cmpT(r1, 0x17);
        } while(!CPU.cpsr().getZero()); // !=

        CPU.r9().value += r4;
        r2 = CPU.r9().value;
        CPU.cmpT(r2, 0x4);
      } while(!CPU.cpsr().getZero()); // !=

      r2 = MEMORY.ref(4, 0x20091e0).get();
      r1 = CPU.r11().value;
      r3 = MEMORY.ref(2, r2 + 0x12).getUnsigned();
      r1 = CPU.addT(r1, 0xa5);
      MEMORY.ref(1, r1).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x10).get();
      r1 = CPU.addT(r1, 0x1);
      r3 = CPU.lsrT(r3, 8);
      MEMORY.ref(1, r1).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x10).get();
      r1 = CPU.addT(r1, 0x1);
      MEMORY.ref(1, r1).setu(r3);
    }

    //LAB_2009108
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    CPU.cmpT(r3, 0x2);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = CPU.negT(r3, r3);
      r3 = CPU.orrT(r3, r4);
      r3 = CPU.lsrT(r3, 31);
      r3 = CPU.addT(r3, 0x8);
      r6 = CPU.movT(0, 0x0);
      r1 = CPU.r11().value;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      CPU.r9().value = r6;
      r0 = CPU.addT(r3, r1);

      //LAB_2009122
      do {
        r2 = MEMORY.ref(4, r4).get();
        r3 = CPU.lsrT(r2, 24);
        MEMORY.ref(1, r0).setu(r3);
        r3 = CPU.lsrT(r2, 16);
        MEMORY.ref(1, r0 + 0x1).setu(r3);
        r3 = CPU.lsrT(r2, 8);
        MEMORY.ref(1, r0 + 0x2).setu(r3);
        MEMORY.ref(1, r0 + 0x3).setu(r2);
        r1 = MEMORY.ref(4, r4 + 0x4).get();
        r3 = CPU.lsrT(r1, 24);
        MEMORY.ref(1, r0 + 0x4).setu(r3);
        r3 = CPU.lsrT(r1, 16);
        MEMORY.ref(1, r0 + 0x5).setu(r3);
        r3 = CPU.lsrT(r1, 8);
        MEMORY.ref(1, r0 + 0x7).setu(r1);
        MEMORY.ref(1, r0 + 0x6).setu(r3);
        r2 = MEMORY.ref(4, r4 + 0x8).get();
        r3 = CPU.lsrT(r2, 28);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lsrT(r2, 20);
        MEMORY.ref(1, r0 + 0x8).setu(r3);
        r3 = CPU.lsrT(r2, 12);
        MEMORY.ref(1, r0 + 0x9).setu(r3);
        r3 = CPU.lsrT(r2, 4);
        r2 = CPU.lslT(r2, 4);
        MEMORY.ref(1, r0 + 0xb).setu(r2);
        MEMORY.ref(1, r0 + 0xa).setu(r3);
        MEMORY.ref(1, r0 + 0x7).setu(r1);
        r1 = MEMORY.ref(4, r4 + 0xc).get();
        r3 = CPU.lsrT(r1, 28);
        r2 = CPU.orrT(r2, r3);
        MEMORY.ref(1, r0 + 0xb).setu(r2);
        r3 = CPU.lsrT(r1, 20);
        r2 = CPU.movT(0, 0x1);
        MEMORY.ref(1, r0 + 0xc).setu(r3);
        CPU.r9().value += r2;
        r3 = CPU.lsrT(r1, 12);
        MEMORY.ref(1, r0 + 0xd).setu(r3);
        r1 = CPU.lsrT(r1, 4);
        r3 = CPU.r9().value;
        MEMORY.ref(1, r0 + 0xe).setu(r1);
        r4 = CPU.addT(r4, 0x10);
        r0 = CPU.addT(r0, 0xf);
        CPU.cmpT(r3, 0x2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_200917c
    r4 = CPU.sp().value + 0x14;
    r4 = MEMORY.ref(1, r4).getUnsigned();
    r6 = CPU.r11().value;
    MEMORY.ref(1, r6).setu(r4);
    r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r0 = CPU.r11().value;
    r3 = CPU.lsrT(r6, 8);
    MEMORY.ref(1, r0 + 0x1).setu(r3);
    r3 = CPU.lsrT(r6, 16);
    MEMORY.ref(1, r0 + 0x2).setu(r3);
    r2 = CPU.lsrT(r6, 20);
    r3 = CPU.movT(0, 0xf0);
    r2 = CPU.andT(r2, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    r1 = CPU.movT(0, 0xf);
    r3 = CPU.andT(r3, r1);
    r2 = CPU.orrT(r2, r3);
    MEMORY.ref(1, r0 + 0x3).setu(r2);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    r3 = CPU.lsrT(r1, 4);
    MEMORY.ref(1, r0 + 0x4).setu(r3);
    r3 = CPU.lsrT(r1, 12);
    MEMORY.ref(1, r0 + 0x5).setu(r3);
    r3 = CPU.lsrT(r1, 20);
    MEMORY.ref(1, r0 + 0x6).setu(r3);
    r2 = CPU.sp().value + 0x8;
    r2 = MEMORY.ref(1, r2).getUnsigned();
    MEMORY.ref(1, r0 + 0x7).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = CPU.sp().value + 0xc;
      r4 = MEMORY.ref(1, r4).getUnsigned();
      MEMORY.ref(1, r0 + 0x8).setu(r4);
    }

    //LAB_20091c0
    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    CPU.sp().value += 0x40;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;

    return r0;
  }

  @Method(0x20091e4)
  public static int FUN_20091e4(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    CPU.r9().value = r0;
    CPU.r8().value = r1;
    CPU.sp().value -= 0x8;
    r3 = CPU.r9().value;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 += CPU.r8().value;
    r3 = CPU.subT(r3, 0x1);
    r5 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.r8().value;
    r2 = CPU.movT(0, 0x0);
    r3 = CPU.subT(r3, 0x1);
    CPU.r10().value = r2;
    r1 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.r12().value = r3;
      r4 = CPU.r9().value;

      //LAB_2009214
      do {
        r2 = MEMORY.ref(1, r4).getUnsigned();
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.eorT(r3, r2);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(1, r4).setu(r3);
        r4 = CPU.addT(r4, 0x1);
        CPU.cmpT(r1, CPU.r12().value);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_2009224
    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r3 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x5);
    r5 = CPU.movT(0, 0x0);
    r7 = CPU.movT(0, 0x0);
    CPU.r12().value = r3;
    CPU.lr().value = r3;
    CPU.r11().value = r2;
    r0 += CPU.r10().value;

    //LAB_2009236
    do {
      r3 = CPU.r9().value;
      r6 = CPU.movT(0, 0x0);
      r1 = CPU.movT(0, 0x0);
      r4 = CPU.addT(r7, r3);
      r1--; // Subtract one so we don't have to jump to 2009242

      //LAB_2009240
      do {
        r1 = CPU.addT(r1, 0x1);

        //LAB_2009242
        CPU.cmpT(r1, 0x6);
        if(CPU.cpsr().getZero()) { // ==
          break;
        }
        r2 = MEMORY.ref(1, r4).getUnsigned();
        r3 = CPU.movT(0, 0x7);
        r3 = CPU.subT(r3, r5);
        r2 = CPU.asrT(r2, r3);
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r5 = CPU.addT(r5, 0x1);
        r3 = CPU.movT(0, 0x1);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r5, 0x8);
        if(CPU.cpsr().getZero()) { // ==
          r5 = CPU.movT(0, 0x0);
          r4 = CPU.addT(r4, 0x1);
          r7 = CPU.addT(r7, 0x1);
        }

        //LAB_2009260
        r3 = CPU.r11().value;
        r3 = CPU.subT(r3, r1);
        r2 = CPU.lslT(r2, r3);
        r6 = CPU.orrT(r6, r2);
        CPU.cmpT(r7, CPU.r8().value);
      } while(!CPU.cpsr().getZero()); // !=

      //LAB_200926c
      r2 = CPU.movT(0, 0x1);
      CPU.lr().value += r2;
      r3 = CPU.lr().value;
      MEMORY.ref(1, r0).setu(r6);
      CPU.r10().value += r2;
      r0 = CPU.addT(r0, 0x1);
      CPU.r12().value += r6;
      CPU.cmpT(r3, 0x9);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0x3f);
        r2 = CPU.r12().value;
        r2 = CPU.andT(r2, r3);
        MEMORY.ref(1, r0).setu(r2);
        r3 = CPU.movT(0, 0x1);
        r2 = CPU.movT(0, 0x0);
        r0 = CPU.addT(r0, 0x1);
        CPU.r10().value += r3;
        CPU.r12().value = r2;
        CPU.lr().value = r2;
      }

      //LAB_2009292
      CPU.cmpT(r7, CPU.r8().value);
    } while(!CPU.cpsr().getZero()); // !=

    r3 = CPU.r10().value;
    r1 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r0 = CPU.movT(0, 0x3f);

      //LAB_20092a2
      do {
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r3 = CPU.addT(r3, r1);
        r3 = CPU.andT(r3, r0);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(1, r2).setu(r3);
        r2 = CPU.addT(r2, 0x1);
        CPU.cmpT(r1, CPU.r10().value);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_20092b2
    r0 = CPU.r10().value;
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;

    return r0;
  }

  @Method(0x20092c8)
  public static int FUN_20092c8(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    final int r6;
    int r7;

    r4 = CPU.addT(r0, 0x0);
    r5 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(4, 0x200930c).get();
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r7 = CPU.movT(0, 0x80);
      r6 = MEMORY.ref(4, 0x2009310).get();
      r7 = CPU.lslT(r7, 8);

      //LAB_20092da
      do {
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.lslT(r3, 8);
        r0 = CPU.eorT(r0, r3);
        r2 = CPU.movT(0, 0x0);

        //LAB_20092e2
        do {
          r3 = CPU.addT(r0, 0x0);
          r3 = CPU.andT(r3, r7);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.lslT(r0, 1);
            r0 = CPU.addT(r3, r6);
          } else {
            //LAB_20092f0
            r0 = CPU.lslT(r0, 1);
          }

          //LAB_20092f2
          r2 = CPU.addT(r2, 0x1);
          CPU.cmpT(r2, 0x8);
        } while(!CPU.cpsr().getZero()); // !=

        r5 = CPU.addT(r5, 0x1);
        r1 = CPU.addT(r1, 0x1);
        r5 = CPU.cmpT(r5, r4);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_2009300
    r0 = CPU.mvnT(r0, r0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x2009314)
  public static int FUN_2009314(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  @Method(0x200931c)
  public static int FUN_200931c(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003ac, r0, r1);
  }

  @Method(0x2009324)
  public static void FUN_2009324(final int r0) {
    MEMORY.call(0x80000c0, r0);
  }

  @Method(0x200932c)
  public static void FUN_200932c(final int r0, final int r1) {
    MEMORY.call(0x80000d0, r0, r1);
  }

  @Method(0x200934c)
  public static int decompress(final int r0, final int r1) {
    return (int)MEMORY.call(0x80001a8, r0, r1);
  }

  @Method(0x2009354)
  public static void loadUiTextures() {
    MEMORY.call(0x80001f0);
  }

  @Method(0x200935c)
  public static int getPointerTableEntry(final int r0) {
    return (int)MEMORY.call(0x8000290, r0);
  }

  @Method(0x2009364)
  public static void FUN_2009364(final int r0) {
    MEMORY.call(0x8003b70, r0);
  }

  @Method(0x200936c)
  public static void FUN_200936c() {
    MEMORY.call(0x8000300);
  }

  @Method(0x2009374)
  public static void FUN_2009374() {
    MEMORY.call(0x8000370);
  }

  @Method(0x200937c)
  public static int FUN_200937c(final int r0, final int r1) {
    return (int)MEMORY.call(0x8000380, r0, r1);
  }

  @Method(0x2009384)
  public static int FUN_2009384(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x8015010, r0, r1, r2, r3);
  }

  @Method(0x200938c)
  public static void FUN_200938c(final int r0, final int r1) {
    MEMORY.call(0x8015018, r0, r1);
  }

  @Method(0x2009394)
  public static void FUN_2009394(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  @Method(0x200939c)
  public static void FUN_200939c(final int r0) {
    MEMORY.call(0x8015060, r0);
  }

  @Method(0x20093a4)
  public static void FUN_20093a4(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015070, r0, r1, r2, r3);
  }

  @Method(0x20093ac)
  public static void FUN_20093ac(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015078, r0, r1, r2, r3);
  }

  @Method(0x20093b4)
  public static void FUN_20093b4(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015080, r0, r1, r2, r3);
  }

  @Method(0x20093bc)
  public static void FUN_20093bc(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015088, r0, r1, r2, r3);
  }

  @Method(0x20093c4)
  public static void FUN_20093c4() {
    MEMORY.call(0x8015140);
  }

  @Method(0x20093cc)
  public static int FUN_20093cc() {
    return (int)MEMORY.call(0x80151f0);
  }

  @Method(0x20093d4)
  public static int FUN_20093d4(final int r0) {
    return (int)MEMORY.call(0x80151f8, r0);
  }

  @Method(0x20093dc)
  public static void FUN_20093dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  @Method(0x20093e4)
  public static void FUN_20093e4(final int r0, final int r1, final int r2, final int r3, final int r4) {
    MEMORY.call(0x8015280, r0, r1, r2, r3, r4);
  }

  @Method(0x20093ec)
  public static int FUN_20093ec() {
    return (int)MEMORY.call(0x80152e8);
  }

  @Method(0x20093f4)
  public static int FUN_20093f4(final int r0) {
    return (int)MEMORY.call(0x80152f0, r0);
  }

  @Method(0x20093fc)
  public static int FUN_20093fc() {
    return (int)MEMORY.call(0x80152f8);
  }

  @Method(0x2009404)
  public static int FUN_2009404() {
    return (int)MEMORY.call(0x8015300);
  }

  @Method(0x200940c)
  public static int FUN_200940c() {
    return (int)MEMORY.call(0x8015318);
  }

  @Method(0x2009414)
  public static int FUN_2009414(final int r0) {
    return (int)MEMORY.call(0x8015320, r0);
  }

  @Method(0x200941c)
  public static void FUN_200941c(final int r0, final int r1) {
    MEMORY.call(0x8015360, r0, r1);
  }

  @Method(0x2009424)
  public static int FUN_2009424(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x8015390, r0, r1, r2, r3);
  }

  @Method(0x200942c)
  public static void FUN_200942c(final int r0) {
    MEMORY.call(0x80153d8, r0);
  }

  @Method(0x2009434)
  public static void FUN_2009434(final int r0) {
    MEMORY.call(0x8015418, r0);
  }

  @Method(0x200943c)
  public static int FUN_200943c(final int r0) {
    return (int)MEMORY.call(0x8077008, r0);
  }

  @Method(0x2009444)
  public static int FUN_2009444(final int r0) {
    return (int)MEMORY.call(0x8077018, r0);
  }

  @Method(0x200944c)
  public static void FUN_200944c() {
    MEMORY.call(0x8077098);
  }

  @Method(0x2009454)
  public static int FUN_2009454(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  @Method(0x200945c)
  public static void FUN_200945c(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  @Method(0x2009464)
  public static void FUN_2009464(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  @Method(0x200946c)
  public static int FUN_200946c(final int r0) {
    return (int)MEMORY.call(0x8077150, r0);
  }

  @Method(0x2009474)
  public static int FUN_2009474(final int r0) {
    return (int)MEMORY.call(0x8077168, r0);
  }

  @Method(0x200947c)
  public static void FUN_200947c() {
    MEMORY.call(0x8077270);
  }

  @Method(0x2009484)
  public static int FUN_2009484() {
    return (int)MEMORY.call(0x8077300);
  }

  @Method(0x200948c)
  public static void FUN_200948c() {
    MEMORY.call(0x8077318);
  }

  @Method(0x2009494)
  public static void FUN_2009494(final int r0) {
    MEMORY.call(0x808a010, r0);
  }

  @Method(0x200949c)
  public static int FUN_200949c(final int r0) {
    return (int)MEMORY.call(0x808a080, r0);
  }

  @Method(0x20094a4)
  public static void FUN_20094a4(final int r0, final int r1) {
    MEMORY.call(0x808a238, r0, r1);
  }

  @Method(0x20094ac)
  public static void FUN_20094ac() {
    MEMORY.call(0x808a360);
  }

  @Method(0x20094b4)
  public static void FUN_20094b4() {
    MEMORY.call(0x808a368);
  }

  @Method(0x20094bc)
  public static void FUN_20094bc() {
    MEMORY.call(0x808a370);
  }

  @Method(0x20094c4)
  public static int FUN_20094c4(final int r0) {
    return (int)MEMORY.call(0x808a4d8, r0);
  }

  @Method(0x20094cc)
  public static void FUN_20094cc(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
