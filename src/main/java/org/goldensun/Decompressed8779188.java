package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

/** 0x652 bytes */
public final class Decompressed8779188 {
  private Decompressed8779188() { }

  @Method(0x2008030)
  public static int FUN_2008030() {
    return MEMORY.ref(4, 0x2008034).get();
  }

  @Method(0x2008044)
  public static int FUN_2008044() {
    return MEMORY.ref(4, 0x2008048).get();
  }

  @Method(0x200804c)
  public static int FUN_200804c() {
    return MEMORY.ref(4, 0x2008050).get();
  }

  @Method(0x2008054)
  public static int FUN_2008054() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r2 = MEMORY.ref(4, 0x20081a0).get();
    r1 = CPU.movT(0, 0xe1);
    r1 = CPU.lslT(r1, 1);
    r5 = CPU.addT(r2, r1);
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r5 + r1).get();
    CPU.cmpT(r3, 0xa);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.movT(0, 0xfa);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r2, r1);
      r0 = MEMORY.ref(4, r3).get();
      r0 = FUN_20085b0(r0);
      r3 = CPU.movT(0, 0x0);
      r0 = CPU.addT(r0, 0x55);
      MEMORY.ref(1, r0).setu(r3);
      r0 = CPU.movT(0, 0x4b);
      FUN_20085f0(r0);
      r0 = CPU.movT(0, 0x0);
      FUN_20082e8();
      r0 = CPU.movT(0, 0x78);
      FUN_2008538(r0);
      r2 = MEMORY.ref(4, 0x20081a4).get();
      r3 = MEMORY.ref(4, r2).get();
      r5 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r6 = CPU.addT(r2, 0x0);

        //LAB_2008096
        do {
          r0 = CPU.movT(0, 0x1);
          FUN_2008538(r0);
          r2 = MEMORY.ref(4, 0x20081a8).get();
          r5 = CPU.addT(r5, 0x1);
          r5 = CPU.cmpT(r5, r2);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(4, r6).get();
          CPU.cmpT(r3, 0x0);
        } while(CPU.cpsr().getZero()); // ==
      }

      //LAB_20080aa
      r0 = MEMORY.ref(4, 0x20081ac).get();
      r1 = CPU.movT(0, 0x2);
      FUN_20085b8(r0, r1);
    } else {
      //LAB_20080b4
      CPU.cmpT(r3, 0x9);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.movT(0, 0x43);
        FUN_20085f0(r0);
        r0 = CPU.movT(0, 0x0);
        r0 = FUN_20085d0();
        r0 = CPU.movT(0, 0x11);
        FUN_20085f0(r0);
        r0 = CPU.movT(0, 0x3c);
        FUN_2008588(r0);
        FUN_2008590();
        r0 = CPU.movT(0, 0xf0);
        FUN_20085a8(r0);
        r0 = CPU.movT(0, 0x13);
        FUN_20085f0(r0);
        r0 = MEMORY.ref(4, 0x20081b0).get();
        r1 = CPU.movT(0, 0x2);
        FUN_20085b8(r0, r1);
      } else {
        //LAB_20080ea
        r0 = MEMORY.ref(4, 0x20081b4).get();
        FUN_2008580(r0);
        r1 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r5 + r1).get();
        CPU.cmpT(r3, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_20080f8
          do {
            r0 = CPU.movT(0, 0x13);
            FUN_20085f0(r0);
            r0 = CPU.movT(0, 0x0);
            r0 = FUN_20085e0(r0);
            r0 = CPU.movT(0, 0x0);
            r0 = FUN_20085e8();
            r0 = FUN_2008598();
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
              break;
            }
            r0 = CPU.movT(0, 0x46);
            FUN_20085f0(r0);
            r0 = CPU.movT(0, 0x1);
            r0 = FUN_20085d8(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              break;
            }
            r0 = CPU.movT(0, 0x11);
            FUN_20085f0(r0);
            r0 = CPU.movT(0, 0x1e);
            FUN_2008588(r0);
            FUN_2008590();
            r2 = MEMORY.ref(4, 0x20081b8).get();
            r3 = MEMORY.ref(4, r2).get();
            r5 = CPU.movT(0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r6 = CPU.addT(r2, 0x0);

              //LAB_200813e
              do {
                r0 = CPU.movT(0, 0x1);
                r5 = CPU.addT(r5, 0x1);
                FUN_2008538(r0);
                CPU.cmpT(r5, 0x77);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  break;
                }
                r3 = MEMORY.ref(4, r6).get();
                CPU.cmpT(r3, 0x0);
              } while(CPU.cpsr().getZero()); // ==
            }
          } while(true);

          //LAB_2008152
          r0 = MEMORY.ref(4, 0x20081b0).get();
          r1 = CPU.movT(0, 0x1);
          FUN_20085b8(r0, r1);
        } else {
          //LAB_200815c
          r0 = CPU.movT(0, 0x40);
          FUN_20085f0(r0);
          r0 = CPU.movT(0, 0x0);
          r0 = FUN_20085d8(r0);
          FUN_20085a0();
          r0 = MEMORY.ref(4, 0x20081bc).get();
          r1 = CPU.movT(0, 0x10);
          FUN_20085b8(r0, r1);
          r0 = CPU.movT(0, 0x11);
          FUN_20085f0(r0);
        }

        //LAB_200817a
        r0 = CPU.movT(0, 0x11);
        FUN_20085f0(r0);
        r0 = CPU.movT(0, 0x1e);
        FUN_2008588(r0);
        FUN_2008590();
        r0 = CPU.movT(0, 0x3c);
        FUN_20085a8(r0);
        r0 = CPU.movT(0, 0x13);
        FUN_20085f0(r0);
      }
    }

    //LAB_2008196
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x20081c0)
  public static void FUN_20081c0() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r0 = CPU.movT(0, 0xa4);
    r0 = CPU.lslT(r0, 3);
    r0 = FUN_2008548(r0);
    r6 = MEMORY.ref(4, 0x2008224).get();
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r6 + r2).get();
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.negT(r2, r2);
    r5 = CPU.addT(r0, 0x0);
    r3 = CPU.cmpT(r3, r2);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_2008568();
      MEMORY.ref(2, r6).setu(r0);
    }

    //LAB_20081e0
    r0 = MEMORY.ref(4, 0x2008228).get();
    r0 = getPointerTableEntry(r0);
    r1 = CPU.addT(r5, 0x0);
    decompress(r0, r1);
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x2008230).get();
    r2 = MEMORY.ref(4, 0x2008234).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r2 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0xa0);
    r2 = CPU.addT(r2, 0x20);
    r1 = CPU.lslT(r1, 3);
    r3 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r6 + r3).get();
    FUN_2008560(r0, r1, r2);
    r2 = CPU.movT(0, 0x80);
    r1 = MEMORY.ref(4, 0x200822c).get();
    r2 = CPU.lslT(r2, 24);

    //LAB_200820e
    do {
      r3 = MEMORY.ref(4, r1 + 0x8).get();
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    r0 = CPU.addT(r5, 0x0);
    FUN_2008550(r0);
  }

  @Method(0x20082e8)
  public static void FUN_20082e8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    FUN_2008454();
    r0 = CPU.movT(0, 0x1e);
    FUN_20085a8(r0);
    r2 = MEMORY.ref(4, 0x2008320).get();
    r3 = MEMORY.ref(4, 0x200831c).get();
    r0 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r2).setu(r3);
    FUN_20081c0();
    r1 = CPU.movT(0, 0xc8);
    r1 = CPU.lslT(r1, 4);
    r0 = MEMORY.ref(4, 0x2008324).get();
    r0 = FUN_2008540(r0, r1);
    r7 = MEMORY.ref(4, 0x2008328).get();
    r5 = MEMORY.ref(4, 0x200832c).get();
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r7).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r7);
      MEMORY.ref(2, r7).setu(r2);
      r2 = CPU.movT(0, 0xaa);
      r3 = CPU.addT(r3, 0x4);
      r2 = CPU.lslT(r2, 5);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 19);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 10);
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_2008350
    MEMORY.ref(2, r5).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r7).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r7);
      MEMORY.ref(2, r7).setu(r2);
      r2 = MEMORY.ref(4, 0x200843c).get();
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x2008440).get();
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 10);
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200837a
    MEMORY.ref(2, r5).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r7).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r7);
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(2, r7).setu(r2);
      r2 = CPU.movT(0, 0x10);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x2008444).get();
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 10);
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_20083a4
    MEMORY.ref(2, r5).setu(r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r7).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r7);
      MEMORY.ref(2, r7).setu(r2);
      r2 = MEMORY.ref(4, 0x2008448).get();
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x200844c).get();
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 10);
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_20083ce
    MEMORY.ref(2, r5).setu(r1);
    r0 = CPU.movT(0, 0x78);
    FUN_20085a8(r0);
    r6 = CPU.movT(0, 0x0);

    //LAB_20083d8
    do {
      r3 = MEMORY.ref(2, r5).getUnsigned();
      r1 = CPU.addT(r3, 0x0);
      MEMORY.ref(2, r5).setu(r5);
      r3 = MEMORY.ref(2, r7).getUnsigned();
      CPU.cmpT(r3, 0x1f);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r2 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r2, r3);
        r2 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r3, 0x1);
        r2 = CPU.addT(r7, r2);
        MEMORY.ref(2, r7).setu(r3);
        r3 = CPU.movT(0, 0x10);
        r2 = CPU.addT(r2, 0x4);
        r3 = CPU.subT(r3, r6);
        MEMORY.ref(4, r2).setu(r3);
        r2 += 0x4;
        r3 = MEMORY.ref(4, 0x2008444).get();
        MEMORY.ref(4, r2).setu(r3);
        r2 += 0x4;
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 10);
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_2008402
      MEMORY.ref(2, r5).setu(r1);
      r0 = CPU.movT(0, 0x3);
      r6 = CPU.addT(r6, 0x1);
      FUN_2008538(r0);
      CPU.cmpT(r6, 0x10);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r6 = MEMORY.ref(4, 0x2008450).get();
    r3 = CPU.movT(0, 0xe0);
    r1 = MEMORY.ref(4, r6).get();
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r1, r3);
    r5 = CPU.movT(0, 0xe4);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r2).setu(r3);
    r5 = CPU.lslT(r5, 1);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(4, r1 + r5).setu(r3);
    FUN_20085c0();
    FUN_20085c8();
    r2 = MEMORY.ref(4, r6).get();
    r3 = CPU.movT(0, 0x3c);
    MEMORY.ref(4, r2 + r5).setu(r3);
  }

  @Method(0x2008454)
  public static void FUN_2008454() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r0 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(4, 0x200849c).get();
    FUN_2008588(r0);
    r2 = MEMORY.ref(4, 0x20084a0).get();
    r3 = MEMORY.ref(4, 0x2008498).get();
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x20084a4).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r2 + 0xa).setu(r3);
    r0 = CPU.addT(r5, 0x0);
    r0 = getPointerTableEntry(r0);
    r1 = CPU.movT(0, 0xa0);
    r6 = MEMORY.ref(4, 0x20084a8).get();
    r4 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 19);
    r2 = MEMORY.ref(4, 0x20084b0).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r3 = CPU.movT(0, 0xe0);
    r3 = CPU.lslT(r3, 1);
    r4 = CPU.addT(r4, r3);
    r0 = CPU.addT(r4, 0x0);
    r1 = MEMORY.ref(4, 0x20084b4).get();
    decompress(r0, r1);
    r0 = MEMORY.ref(4, 0x20084b4).get();
    r1 = MEMORY.ref(4, 0x20084b8).get();
    r2 = MEMORY.ref(4, 0x20084bc).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r3 = CPU.movT(0, 0xd0);
    r1 = MEMORY.ref(4, 0x2008520).get();
    r3 = CPU.lslT(r3, 1);
    r4 = CPU.movT(0, 0x0);

    //LAB_20084cc
    do {
      r0 = CPU.movT(0, 0x0);

      //LAB_20084ce
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

    r3 = MEMORY.ref(4, 0x2008524).get();
    r4 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x0);

    //LAB_20084f8
    do {
      r4 = CPU.addT(r4, 0x1);
      MEMORY.ref(2, r3 + 0x2).setu(r2);
      MEMORY.ref(2, r3).setu(r2);
      r3 = CPU.addT(r3, 0x4);
      CPU.cmpT(r4, 0x3);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r0 = MEMORY.ref(4, 0x2008524).get();
    r1 = MEMORY.ref(4, 0x200852c).get();
    r2 = MEMORY.ref(4, 0x2008530).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r3 = MEMORY.ref(4, 0x2008534).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = CPU.movT(0, 0xa0);
    r3 = CPU.lslT(r3, 5);
    MEMORY.ref(2, r2 + 0x14).setu(r3);
  }

  @Method(0x2008538)
  public static void FUN_2008538(final int r0) {
    MEMORY.call(0x80000c1, r0);
  }

  @Method(0x2008540)
  public static int FUN_2008540(final int r0, final int r1) {
    return (int)MEMORY.call(0x80000d1, r0, r1);
  }

  @Method(0x2008548)
  public static int FUN_2008548(final int r0) {
    return (int)MEMORY.call(0x8000171, r0);
  }

  @Method(0x2008550)
  public static void FUN_2008550(final int r0) {
    MEMORY.call(0x8000179, r0);
  }

  @Method(0x2008558)
  public static int decompress(final int src, final int dst) {
    return (int)MEMORY.call(0x80001a9, src, dst);
  }

  @Method(0x2008560)
  public static int FUN_2008560(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x80001c9, r0, r1, r2);
  }

  @Method(0x2008568)
  public static int FUN_2008568() {
    return (int)MEMORY.call(0x80001d1);
  }

  @Method(0x2008578)
  public static int getPointerTableEntry(final int r0) {
    return (int)MEMORY.call(0x8000291, r0);
  }

  @Method(0x2008580)
  public static void FUN_2008580(final int r0) {
    MEMORY.call(0x8000299, r0);
  }

  @Method(0x2008588)
  public static void FUN_2008588(final int r0) {
    MEMORY.call(0x80002a9, r0);
  }

  @Method(0x2008590)
  public static void FUN_2008590() {
    MEMORY.call(0x80002d1);
  }

  @Method(0x2008598)
  public static int FUN_2008598() {
    return (int)MEMORY.call(0x8015319);
  }

  @Method(0x20085a0)
  public static void FUN_20085a0() {
    MEMORY.call(0x8077279);
  }

  @Method(0x20085a8)
  public static void FUN_20085a8(final int r0) {
    MEMORY.call(0x808a011, r0);
  }

  @Method(0x20085b0)
  public static int FUN_20085b0(final int r0) {
    return (int)MEMORY.call(0x808a081, r0);
  }

  @Method(0x20085b8)
  public static void FUN_20085b8(final int r0, final int r1) {
    MEMORY.call(0x808a239, r0, r1);
  }

  @Method(0x20085c0)
  public static void FUN_20085c0() {
    MEMORY.call(0x808a361);
  }

  @Method(0x20085c8)
  public static void FUN_20085c8() {
    MEMORY.call(0x808a371);
  }

  @Method(0x20085d0)
  public static int FUN_20085d0() {
    return (int)MEMORY.call(0x80f0001);
  }

  @Method(0x20085d8)
  public static int FUN_20085d8(final int r0) {
    return (int)MEMORY.call(0x80f2001, r0);
  }

  @Method(0x20085e0)
  public static int FUN_20085e0(final int r0) {
    return (int)MEMORY.call(0x80f2019, r0);
  }

  @Method(0x20085e8)
  public static int FUN_20085e8() {
    return (int)MEMORY.call(0x80f2021);
  }

  @Method(0x20085f0)
  public static void FUN_20085f0(final int r0) {
    MEMORY.call(0x80f9011, r0);
  }
}
