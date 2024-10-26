package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_80022f4;
import static org.goldensun.GoldenSun.FUN_80022fc;
import static org.goldensun.GoldenSun.FUN_8002df0;
import static org.goldensun.GoldenSun.FUN_8004458;
import static org.goldensun.GoldenSun.FUN_8004970;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun_801.FUN_8015020;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_807 {
  private GoldenSun_807() { }

  @Method(0x8077008)
  public static int FUN_8077008(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8077098)
  public static void FUN_8077098() {
    FUN_8077d38();
  }

  @Method(0x80770c0)
  public static int FUN_80770c0(final int r0) {
    return (int)MEMORY.call(0x8079339, r0);
  }

  @Method(0x80770c8)
  public static void FUN_80770c8(final int r0) {
    MEMORY.call(0x8079359, r0);
  }

  @Method(0x80770d0)
  public static void FUN_80770d0(final int r0) {
    MEMORY.call(0x8079375, r0);
  }

  @Method(0x80772f0)
  public static void FUN_80772f0() {
    MEMORY.call(0x8077c11);
  }

  @Method(0x8077394)
  public static int FUN_8077394(int r0) {
    int r2;
    int r3;

    r2 = MEMORY.ref(4, 0x80773cc).get();
    CPU.cmpT(r0, 0x7);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r3 = CPU.movT(0, 0xa6);
      r3 = CPU.lslT(r3, 1);
      r3 = CPU.mulT(r3, r0);
      r0 = CPU.addT(r3, r2);
      return r0;
    }

    //LAB_80773a8
    r3 = CPU.addT(r0, 0x0);
    r3 = CPU.subT(r3, 0x80);
    CPU.cmpT(r3, 0x5);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      return 0;
    }

    r3 = MEMORY.ref(4, 0x80773d0).get();
    r2 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_80773c6
      return 0;
    }

    r3 = CPU.movT(0, 0xa6);
    r3 = CPU.lslT(r3, 1);
    r3 = CPU.mulT(r3, r0);
    r3 = CPU.addT(r2, r3);
    r2 = MEMORY.ref(4, 0x80773d4).get();
    r0 = CPU.addT(r3, r2);

    //LAB_80773c8
    return r0;
  }

  @Method(0x80773d8)
  public static int FUN_80773d8(int r0) {
    int r3;

    r0 = CPU.subT(r0, 0x8);
    CPU.cmpT(r0, 0xf9);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80773e2
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r3 = MEMORY.ref(4, 0x80773f0).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x8077428)
  public static void FUN_8077428(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x60);
    CPU.sp().value -= 0x4;
    r0 = FUN_8004970(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8077394(r0);
    r7 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x10);
    r3 = MEMORY.ref(2, r7 + r0).get();
    MEMORY.ref(4, r6).setu(r3);
    r1 = CPU.movT(0, 0x12);
    r3 = MEMORY.ref(2, r7 + r1).get();
    MEMORY.ref(4, r6 + 0x4).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x18).getUnsigned();
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x1a).getUnsigned();
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
    MEMORY.ref(4, r6 + 0x10).setu(r3);
    r3 = MEMORY.ref(1, r7 + 0x1e).getUnsigned();
    MEMORY.ref(4, r6 + 0x18).setu(r3);
    r2 = MEMORY.ref(1, r7 + 0x1f).getUnsigned();
    r3 = CPU.movT(0, 0xf);
    r3 = CPU.andT(r3, r2);
    MEMORY.ref(4, r6 + 0x1c).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x20);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    MEMORY.ref(4, r6 + 0x20).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x21);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.addT(r6, 0x0);
    MEMORY.ref(4, r6 + 0x24).setu(r3);
    r1 = CPU.addT(r1, 0x24);
    r2 = CPU.addT(r2, 0x28);
    r5 = CPU.movT(0, 0x3);

    //LAB_8077482
    do {
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r1 + r0).get();
      MEMORY.ref(4, r2).setu(r3);
      r0 = CPU.movT(0, 0x2);
      r3 = MEMORY.ref(2, r1 + r0).get();
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r2 + 0x4).setu(r3);
      r1 = CPU.addT(r1, 0x4);
      r2 = CPU.addT(r2, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r1 = CPU.movT(0, 0x34);
    r2 = MEMORY.ref(2, r7 + r1).get();
    r0 = CPU.movT(0, 0x14);
    r3 = MEMORY.ref(2, r7 + r0).get();
    r3 = CPU.mulT(r3, r2);
    r2 = CPU.addT(r3, 0x0);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r1 = MEMORY.ref(4, 0x80776e4).get();
      r2 = CPU.addT(r3, r1);
    }

    //LAB_80774ac
    r0 = CPU.asrT(r2, 14);
    r2 = CPU.movT(0, 0x38);
    r1 = MEMORY.ref(2, r7 + r2).get();
    r2 = CPU.subT(r0, r1);

    //LAB_80774be
    if(r2 > 1 || r2 < 0 && r1 - r0 > 1) {
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 7);
      MEMORY.ref(2, r7 + 0x14).setu(r3);
      MEMORY.ref(2, r7 + 0x16).setu(r3);
      r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
      MEMORY.ref(2, r7 + 0x38).setu(r3);
      r3 = MEMORY.ref(2, r7 + 0x36).getUnsigned();
      MEMORY.ref(2, r7 + 0x3a).setu(r3);
    } else {
      //LAB_80774c4
      r3 = CPU.movT(0, 0x36);
      r2 = MEMORY.ref(2, r7 + r3).get();
      r0 = CPU.movT(0, 0x16);
      r3 = MEMORY.ref(2, r7 + r0).get();
      r3 = CPU.mulT(r3, r2);
      r2 = CPU.addT(r3, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r1 = MEMORY.ref(4, 0x80776e4).get();
        r2 = CPU.addT(r3, r1);
      }

      //LAB_80774d8
      r0 = CPU.asrT(r2, 14);
      r2 = CPU.movT(0, 0x3a);
      r1 = MEMORY.ref(2, r7 + r2).get();
      r2 = CPU.subT(r0, r1);

      //LAB_80774ea
      if(r2 > 1 || r2 < 0 && r1 - r0 > 1) {
        //LAB_80774f0
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 7);
        MEMORY.ref(2, r7 + 0x14).setu(r3);
        MEMORY.ref(2, r7 + 0x16).setu(r3);
        r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
        MEMORY.ref(2, r7 + 0x38).setu(r3);
        r3 = MEMORY.ref(2, r7 + 0x36).getUnsigned();
        MEMORY.ref(2, r7 + 0x3a).setu(r3);
      }
    }

    //LAB_8077500
    r3 = CPU.movT(0, 0x98);
    r3 = CPU.lslT(r3, 1);
    r1 = CPU.addT(r7, r3);
    r3 = MEMORY.ref(1, r1).getUnsigned();
    r0 = CPU.movT(0, 0x4);
    r0 = CPU.negT(r0, r0);
    r0 = CPU.andT(r0, r3);
    r3 = CPU.movT(0, 0x4);
    r3 = CPU.andT(r3, r0);
    r4 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r1).setu(r0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x1);
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(1, r1).setu(r3);
    }

    //LAB_8077522
    r0 = CPU.movT(0, 0xa2);
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, r6 + 0x1c).get();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077534
    r1 = CPU.movT(0, 0xa1);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x80776e8).get();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r4);
    r0 = MEMORY.ref(4, 0x80776ec).get();
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r4);
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_807754e
      r5 = CPU.movT(0, 0x0);

      //LAB_8077550
      do {
        r3 = CPU.lslT(r5, 1);
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.addT(r1, 0xd8);
        r2 = MEMORY.ref(2, r7 + r1).getUnsigned();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 2);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_8077564
          r0 = MEMORY.ref(2, r7 + r1).getUnsigned();
          r0 = FUN_8078414(r0);
          r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
          r3 = CPU.movT(0, 0x1);
          r3 = CPU.andT(r3, r2);
          MEMORY.ref(4, r6 + 0x58).setu(r0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = CPU.movT(0, 0x98);
            r2 = CPU.lslT(r2, 1);
            r1 = CPU.addT(r7, r2);
            r2 = MEMORY.ref(1, r1).getUnsigned();
            r3 = CPU.movT(0, 0x3);
            r3 = CPU.orrT(r3, r2);
            MEMORY.ref(1, r1).setu(r3);
          }

          //LAB_8077584
          r1 = MEMORY.ref(4, r6 + 0x58).get();
          r3 = CPU.movT(0, 0x8);
          r2 = MEMORY.ref(2, r1 + r3).get();
          r3 = MEMORY.ref(4, r6 + 0x8).get();
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          r2 = CPU.movT(0, 0xa);
          r2 = MEMORY.ref(1, r1 + r2).get();
          r3 = MEMORY.ref(4, r6 + 0xc).get();
          r3 = CPU.addT(r3, r2);
          r0 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r6 + 0xc).setu(r3);
          CPU.r8().value = r0;

          //LAB_807759e
          do {
            r1 = CPU.r8().value;
            r2 = MEMORY.ref(4, r6 + 0x58).get();
            r3 = CPU.lslT(r1, 2);
            r3 = CPU.addT(r3, 0x18);
            r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
            r2 = CPU.addT(r2, r3);
            r3 = CPU.movT(0, 0x1);
            r3 = MEMORY.ref(1, r2 + r3).get();
            MEMORY.ref(4, r6 + 0x48).setu(r1);
            MEMORY.ref(4, r6 + 0x54).setu(r3);

            //LAB_80775b8
            switch(r1) {
              case 1 -> {
                r3 = MEMORY.ref(4, r6).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6).setu(r3);
              }

              case 2 -> {
                r3 = MEMORY.ref(4, r6 + 0x20).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x20).setu(r3);
              }

              case 3 -> {
                r3 = MEMORY.ref(4, r6 + 0x4).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x4).setu(r3);
              }

              case 4 -> {
                r3 = MEMORY.ref(4, r6 + 0x24).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x24).setu(r3);
              }

              case 5 -> {
                r3 = MEMORY.ref(4, r6 + 0x10).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x10).setu(r3);
              }

              case 6 -> {
                r3 = MEMORY.ref(4, r6 + 0x18).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x18).setu(r3);
              }

              case 0xf -> {
                r3 = MEMORY.ref(4, r6 + 0x28).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x28).setu(r3);
              }

              case 0x10 -> {
                r3 = MEMORY.ref(4, r6 + 0x30).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x30).setu(r3);
              }

              case 0x11 -> {
                r3 = MEMORY.ref(4, r6 + 0x38).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x38).setu(r3);
              }

              case 0x12 -> {
                r3 = MEMORY.ref(4, r6 + 0x40).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x40).setu(r3);
              }

              case 0x13 -> {
                r3 = MEMORY.ref(4, r6 + 0x2c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x2c).setu(r3);
              }

              case 0x14 -> {
                r3 = MEMORY.ref(4, r6 + 0x34).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x34).setu(r3);
              }

              case 0x15 -> {
                r3 = MEMORY.ref(4, r6 + 0x3c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x3c).setu(r3);
              }

              case 0x16 -> {
                r3 = MEMORY.ref(4, r6 + 0x44).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x44).setu(r3);
              }

              case 0x17 -> {
                r2 = CPU.movT(0, 0xa1);
                r2 = CPU.lslT(r2, 1);
                r1 = CPU.addT(r7, r2);
                r3 = MEMORY.ref(1, r1).getUnsigned();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(1, r1).setu(r3);
              }

              case 0x18 -> {
                r3 = MEMORY.ref(4, 0x80776e8).get();
                r1 = CPU.addT(r7, r3);
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = MEMORY.ref(1, r1).getUnsigned();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(1, r1).setu(r3);
              }

              case 0x19 -> {
                r0 = CPU.movT(0, 0x98);
                r0 = CPU.lslT(r0, 1);
                r3 = CPU.addT(r7, r0);
                r1 = MEMORY.ref(1, r3).getUnsigned();
                r2 = CPU.movT(0, 0x8);
                r2 = CPU.orrT(r2, r1);
                MEMORY.ref(1, r3).setu(r2);
              }

              case 0x1a -> {
                r3 = MEMORY.ref(4, r6 + 0x1c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x1c).setu(r3);
              }
            }

            //LAB_80776fc
            r1 = CPU.movT(0, 0x1);
            CPU.r8().value += r1;
            r2 = CPU.r8().value;
            CPU.cmpT(r2, 0x3);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              break;
            }
          } while(true);
        }

        //LAB_8077708
        r5 = CPU.addT(r5, 0x1);
        CPU.cmpT(r5, 0xe);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break;
        }
      } while(true);

      //LAB_8077710
      r3 = CPU.movT(0, 0x98);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.addT(r7, r3);
      r2 = MEMORY.ref(1, r1).getUnsigned();
      r3 = CPU.movT(0, 0x8);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xa);
        r3 = CPU.negT(r3, r3);
        r3 = CPU.andT(r3, r2);
        MEMORY.ref(1, r1).setu(r3);
      }

      //LAB_8077728
      r0 = CPU.movT(0, 0x84);
      r0 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, r7);
      r4 = CPU.movT(0, 0x0);
      CPU.r8().value = r0;

      //LAB_8077732
      do {
        r1 = CPU.r8().value;
        r1 = MEMORY.ref(4, r1).get();
        r5 = CPU.movT(0, 0x0);
        CPU.r10().value = r1;

        //LAB_807773a
        do {
          r3 = CPU.movT(0, 0x1);
          r3 = CPU.lslT(r3, r5);
          r2 = CPU.r10().value;
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r4, 0x0);
            r1 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r0 = FUN_807a0cc(r0, r1);
            r3 = MEMORY.ref(4, r6).get();
            r2 = CPU.movT(0, 0x4);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6).setu(r3);
            r2 = CPU.movT(0, 0x5);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x4).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x4).setu(r3);
            r2 = CPU.movT(0, 0x6);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x8).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x8).setu(r3);
            r2 = CPU.movT(0, 0x7);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0xc).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0xc).setu(r3);
            r2 = CPU.movT(0, 0x8);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x10).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x10).setu(r3);
            r2 = CPU.movT(0, 0x9);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x18).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r4 = MEMORY.ref(4, CPU.sp().value).get();
          }

          //LAB_807778e
          r5 = CPU.addT(r5, 0x1);
          CPU.cmpT(r5, 0x13);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

        r3 = CPU.movT(0, 0x4);
        r4 = CPU.addT(r4, 0x1);
        CPU.r8().value += r3;
        CPU.cmpT(r4, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      r0 = MEMORY.ref(4, 0x80779fc).get();
      r3 = CPU.addT(r7, r0);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r0 = FUN_8079ad8(r0);
      r5 = CPU.addT(r0, 0x0);
      r2 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
      r3 = MEMORY.ref(4, r6).get();
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r6).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xa).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x8).get();
      MEMORY.ref(4, r6 + 0x4).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xb).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0xc).get();
      MEMORY.ref(4, r6 + 0x8).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xc).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x10).get();
      MEMORY.ref(4, r6 + 0xc).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xd).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x18).get();
      MEMORY.ref(4, r6 + 0x10).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      MEMORY.ref(4, r6 + 0x18).setu(r0);
      r5 = CPU.movT(0, 0x0);

      //LAB_807780c
      do {
        r3 = CPU.lslT(r5, 1);
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.addT(r1, 0xd8);
        r2 = MEMORY.ref(2, r7 + r1).getUnsigned();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 2);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = MEMORY.ref(2, r7 + r1).getUnsigned();
          r0 = FUN_8078414(r0);
          r1 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r6 + 0x58).setu(r0);
          CPU.r8().value = r1;

          //LAB_807782a
          do {
            r0 = CPU.r8().value;
            r2 = MEMORY.ref(4, r6 + 0x58).get();
            r3 = CPU.lslT(r0, 2);
            r3 = CPU.addT(r3, 0x18);
            r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
            r2 = CPU.addT(r2, r3);
            r3 = CPU.movT(0, 0x1);
            r3 = MEMORY.ref(1, r2 + r3).get();
            MEMORY.ref(4, r6 + 0x48).setu(r1);
            r1 = CPU.subT(r1, 0x7);
            MEMORY.ref(4, r6 + 0x54).setu(r3);

            switch(r1) {
              case 7 -> {
                r2 = MEMORY.ref(4, r6).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6).setu(r0);
              }

              case 8 -> {
                r2 = MEMORY.ref(4, r6 + 0x20).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x20).setu(r0);
              }

              case 9 -> {
                r2 = MEMORY.ref(4, r6 + 0x4).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x4).setu(r0);
              }

              case 0xa -> {
                r2 = MEMORY.ref(4, r6 + 0x24).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x24).setu(r0);
              }

              case 0xb -> {
                r2 = MEMORY.ref(4, r6 + 0x8).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x8).setu(r0);
              }

              case 0xc -> {
                r2 = MEMORY.ref(4, r6 + 0xc).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0xc).setu(r0);
              }

              case 0xd -> {
                r2 = MEMORY.ref(4, r6 + 0x10).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x10).setu(r0);
              }

              case 0xe -> {
                r2 = MEMORY.ref(4, r6 + 0x18).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x18).setu(r0);
              }
            }

            //LAB_80778fa
            r1 = CPU.movT(0, 0x1);
            CPU.r8().value += r1;
            r2 = CPU.r8().value;
            CPU.cmpT(r2, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
        }

        //LAB_8077904
        r5 = CPU.addT(r5, 0x1);
        CPU.cmpT(r5, 0xe);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break;
        }
      } while(true);
    }

    //LAB_807790c
    r0 = MEMORY.ref(4, 0x8077a04).get();
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0x8).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077922
    r3 = CPU.asrT(r3, 3);
    r1 = MEMORY.ref(4, 0x8077a08).get();
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = CPU.addT(r7, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0xc).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_807793c
    r3 = CPU.asrT(r3, 3);
    r2 = MEMORY.ref(4, 0x8077a0c).get();
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077956
    r3 = CPU.asrT(r3, 3);
    MEMORY.ref(4, r6 + 0x10).setu(r3);
    r3 = CPU.movT(0, 0x96);
    r3 = CPU.lslT(r3, 1);
    r4 = CPU.movT(0, 0x28);
    r5 = CPU.movT(0, 0x3);
    r0 = CPU.addT(r7, r3);

    //LAB_8077964
    do {
      r3 = MEMORY.ref(1, r0).getUnsigned();
      r3 = CPU.lslT(r3, 24);
      r3 = CPU.asrT(r3, 24);
      r2 = CPU.addT(r3, 0x0);
      r2 = CPU.mulT(r2, r3);
      r2 = CPU.addT(r2, r3);
      r1 = CPU.lslT(r2, 2);
      r3 = MEMORY.ref(4, r4 + r6).get();
      r1 = CPU.addT(r1, r2);
      r3 = CPU.addT(r3, r1);
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r4 + r6).setu(r3);
      r0 = CPU.addT(r0, 0x1);
      r4 = CPU.addT(r4, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r1 = MEMORY.ref(4, 0x8077a10).get();
    r5 = CPU.movT(0, 0x3);
    r0 = CPU.addT(r7, r1);
    r1 = CPU.movT(0, 0x2c);

    //LAB_807798c
    do {
      r3 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(1, r0 + r3).get();
      r2 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, r3);
      r3 = MEMORY.ref(4, r1 + r6).get();
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.addT(r3, r2);
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r1 + r6).setu(r3);
      r1 = CPU.addT(r1, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r2 = MEMORY.ref(4, 0x80779fc).get();
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x94);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r7, r1);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r0 = CPU.movT(0, 0x0);

      switch(r3) {
        case 0 -> {
          r0 = CPU.movT(0, 0x88);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }

        case 1 -> {
          r0 = CPU.movT(0, 0x89);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }

        case 2 -> {
          r0 = MEMORY.ref(4, 0x8077a18).get();
          r0 = FUN_8079338(r0);
        }

        case 3 -> {
          r0 = MEMORY.ref(4, 0x8077a1c).get();
          r0 = FUN_8079338(r0);
        }

        case 5 -> {
          r0 = CPU.movT(0, 0x89);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }
      }

      //LAB_8077a28
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r6 + 0x24).get();
        r3 = CPU.addT(r3, 0x4);
        MEMORY.ref(4, r6 + 0x24).setu(r3);
      }
    }

    //LAB_8077a32
    r3 = MEMORY.ref(4, r6 + 0x8).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x8).setu(r3);
    }

    //LAB_8077a3c
    r2 = MEMORY.ref(4, 0x8077bf8).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x8).setu(r2);
    }

    //LAB_8077a44
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0xc).setu(r3);
    }

    //LAB_8077a4e
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0xc).setu(r2);
    }

    //LAB_8077a54
    r3 = MEMORY.ref(4, r6 + 0x10).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x10).setu(r3);
    }

    //LAB_8077a5e
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x10).setu(r2);
    }

    //LAB_8077a64
    r3 = MEMORY.ref(4, r6 + 0x18).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a6e
    CPU.cmpT(r3, 0x63);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x63);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a76
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a80
    CPU.cmpT(r3, 0x2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x2);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a88
    r3 = MEMORY.ref(4, r6 + 0x20).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x20).setu(r3);
    }

    //LAB_8077a92
    r2 = MEMORY.ref(4, 0x8077bfc).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x20).setu(r2);
    }

    //LAB_8077a9a
    r3 = MEMORY.ref(4, r6 + 0x24).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aa4
    CPU.cmpT(r3, 0xc8);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0xc8);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aac
    r2 = CPU.movT(0, 0xc8);
    CPU.r12().value = r2;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.addT(r6, 0x0);
    r5 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    r4 = CPU.movT(0, 0x2c);
    r2 = CPU.addT(r2, 0x28);
    r1 = CPU.addT(r1, 0x2c);

    //LAB_8077abe
    do {
      r3 = MEMORY.ref(4, r2).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r2).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ac8
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_8077ad0
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r1).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ada
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r6 + r4).setu(r3);
      }

      //LAB_8077ae2
      r5 = CPU.addT(r5, 0x1);
      r1 = CPU.addT(r1, 0x8);
      r4 = CPU.addT(r4, 0x8);
      r2 = CPU.addT(r2, 0x8);
      CPU.cmpT(r5, 0x3);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r3 = MEMORY.ref(4, r6 + 0x8).get();
    MEMORY.ref(2, r7 + 0x3c).setu(r3);
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    MEMORY.ref(2, r7 + 0x3e).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r2 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = CPU.addT(r3, 0x40);
    MEMORY.ref(2, r3).setu(r2);
    r2 = CPU.addT(r7, 0x0);
    r3 = MEMORY.ref(4, r6 + 0x18).get();
    r2 = CPU.addT(r2, 0x42);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r2 = MEMORY.ref(4, r6 + 0x20).get();
    r3 = CPU.addT(r3, 0x44);
    MEMORY.ref(1, r3).setu(r2);
    r2 = CPU.addT(r7, 0x0);
    r3 = MEMORY.ref(4, r6 + 0x24).get();
    r2 = CPU.addT(r2, 0x45);
    MEMORY.ref(1, r2).setu(r3);
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0x48);
    r2 = CPU.addT(r2, 0x28);
    r5 = CPU.movT(0, 0x3);

    //LAB_8077b26
    do {
      r3 = MEMORY.ref(4, r2).get();
      MEMORY.ref(2, r1).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x4).get();
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(2, r1 + 0x2).setu(r3);
      r2 = CPU.addT(r2, 0x8);
      r1 = CPU.addT(r1, 0x4);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r0 = MEMORY.ref(4, 0x8077c00).get();
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r1 = MEMORY.ref(4, 0x8077c04).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = MEMORY.ref(4, 0x8077c08).get();
    }

    //LAB_8077b46
    r3 = CPU.movT(0, 0x34);
    r2 = MEMORY.ref(2, r7 + r3).get();
    r3 = MEMORY.ref(4, r6).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6).setu(r3);
    }

    //LAB_8077b54
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077b5c
    MEMORY.ref(2, r7 + 0x34).setu(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0x14);
      r2 = MEMORY.ref(2, r7 + r0).get();
      r3 = MEMORY.ref(4, r6).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8077c0c).get();
        r2 = CPU.addT(r2, r3);
      }

      //LAB_8077b76
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x0);
      }

      //LAB_8077b7e
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077b84
      r0 = CPU.movT(0, 0x38);
      r3 = MEMORY.ref(2, r7 + r0).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x1);
        }
      }

      //LAB_8077b92
      MEMORY.ref(2, r7 + 0x38).setu(r2);
    }

    //LAB_8077b94
    r3 = CPU.movT(0, 0x36);
    r2 = MEMORY.ref(2, r7 + r3).get();
    r3 = MEMORY.ref(4, r6 + 0x4).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x4).setu(r3);
    }

    //LAB_8077ba2
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x4).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077baa
    MEMORY.ref(2, r7 + 0x36).setu(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0x16);
      r2 = MEMORY.ref(2, r7 + r0).get();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8077c0c).get();
        r2 = CPU.addT(r2, r3);
      }

      //LAB_8077bc4
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x0);
      }

      //LAB_8077bcc
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077bd2
      r0 = CPU.movT(0, 0x3a);
      r3 = MEMORY.ref(2, r7 + r0).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x1);
        }
      }

      //LAB_8077be0
      MEMORY.ref(2, r7 + 0x3a).setu(r2);
    }

    //LAB_8077be2
    r0 = CPU.addT(r6, 0x0);
    FUN_8002df0(r0);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8077c10)
  public static void FUN_8077c10() {
    int r0;
    int r1;
    int r2;
    int r3;
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

    r0 = MEMORY.ref(4, 0x8077cb0).get();
    CPU.sp().value -= 0x8;
    FUN_8079374(r0);
    r0 = FUN_80795fc();
    CPU.r10().value = r0;
    r0 = CPU.movT(0, 0x0);
    CPU.r8().value = r0;
    CPU.cmpT(CPU.r8().value, CPU.r10().value);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = MEMORY.ref(4, 0x8077cb4).get();
      r2 = CPU.movT(0, 0xfc);
      r2 = CPU.lslT(r2, 1);
      r2 = CPU.addT(r2, r3);
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 2);
      CPU.r9().value = r2;
      CPU.r11().value = r3;

      //LAB_8077c44
      do {
        r2 = CPU.r9().value;
        r0 = MEMORY.ref(1, r2).getUnsigned();
        r0 = FUN_8077394(r0);
        r2 = CPU.movT(0, 0xd8);
        r7 = CPU.addT(r0, 0x0);
        r1 = CPU.movT(0, 0xe);

        //LAB_8077c52
        do {
          r3 = MEMORY.ref(2, r2 + r7).getUnsigned();
          r0 = CPU.r11().value;
          r3 = CPU.andT(r3, r0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(2, r2 + r7).getUnsigned();
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r0 = FUN_8078414(r0);
            r5 = CPU.addT(r0, 0x0);
            r2 = MEMORY.ref(4, CPU.sp().value).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r5 = CPU.addT(r5, 0x18);
            r6 = CPU.movT(0, 0x3);

            //LAB_8077c70
            do {
              r3 = MEMORY.ref(1, r5).getUnsigned();
              r5 = CPU.addT(r5, 0x4);
              CPU.cmpT(r3, 0x1b);
              if(CPU.cpsr().getZero()) { // ==
                r0 = MEMORY.ref(4, 0x8077cb0).get();
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                MEMORY.ref(4, CPU.sp().value).setu(r2);
                FUN_8079358(r0);
                r2 = MEMORY.ref(4, CPU.sp().value).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              }

              //LAB_8077c86
              r6 = CPU.subT(r6, 0x1);
              CPU.cmpT(r6, 0x0);
            } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
          }

          //LAB_8077c8c
          r1 = CPU.subT(r1, 0x1);
          r2 = CPU.addT(r2, 0x2);
          CPU.cmpT(r1, 0x0);
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

        r2 = CPU.movT(0, 0x1);
        CPU.r8().value += r2;
        CPU.r9().value += r2;
        CPU.cmpT(CPU.r8().value, CPU.r10().value);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_8077c9e
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x8077cb8)
  public static int FUN_8077cb8() {
    int r0;
    final int r1;
    int r2;
    int r3;
    int r4;
    int r5;

    r0 = getPointerTableEntry(2);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.lslT(r2, 2);
    r1 = MEMORY.ref(4, 0x8077d2c).get();
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r5 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r5, r3);
    r5 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r4 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r4, r3);
    r4 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
    r5 = CPU.subT(r5, 0x30);
    r3 = CPU.addT(r2, r3);
    r2 = CPU.addT(r3, 0x0);
    r4 = CPU.subT(r4, 0x30);
    r3 = CPU.lslT(r5, 4);
    r3 = CPU.addT(r3, r4);
    r2 = CPU.subT(r2, 0x30);
    r3 = CPU.lslT(r3, 6);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 16);
    r2 = CPU.lslT(r2, 21);
    r2 = CPU.orrT(r2, r3);
    r3 = MEMORY.ref(4, 0x8077d30).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r0 = CPU.asrT(r2, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8077d34).get();
      r0 = CPU.orrT(r0, r3);
    }

    //LAB_8077d1e
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x8077d38)
  public static void FUN_8077d38() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    CPU.sp().value -= 0x8;
    r5 = CPU.sp().value + 0x4;
    r4 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077df0).get();
    r2 = MEMORY.ref(4, 0x8077df4).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    MEMORY.ref(4, r5).setu(r4);
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077df8).get();
    r2 = MEMORY.ref(4, 0x8077dfc).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.movT(0, 0x80);
    r2 = MEMORY.ref(4, 0x8077dec).get();
    r3 = CPU.lslT(r3, 24);

    //LAB_8077d66
    do {
      r4 = MEMORY.ref(4, r2 + 0x8).get();
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077e00).get();
    r2 = MEMORY.ref(4, 0x8077e04).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = MEMORY.ref(4, 0x8077df8).get();
    r1 = CPU.movT(0, 0x82);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r3, r1);
    r2 = CPU.movT(0, 0xff);
    MEMORY.ref(1, r3).setu(r2);
    r0 = CPU.addT(r5, 0x0);
    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r1 = MEMORY.ref(4, 0x8077e08).get();
    r2 = MEMORY.ref(4, 0x8077e0c).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    MEMORY.ref(4, CPU.sp().value).setu(r4);
    FUN_8078ee8();
    r7 = MEMORY.ref(4, 0x8077df0).get();
    r3 = CPU.movT(0, 0x84);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r2).setu(r3);
    r1 = MEMORY.ref(4, 0x8077de4).get();
    r2 = MEMORY.ref(4, 0x8077e10).get();
    CPU.r10().value = r1;
    r3 = CPU.addT(r7, r2);
    r1 = CPU.movT(0, 0x2);
    MEMORY.ref(2, r3).setu(r1);
    r3 = CPU.movT(0, 0x85);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = MEMORY.ref(4, 0x8077de8).get();
    CPU.r8().value = r3;
    r3 = CPU.movT(0, 0x4);
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8077e14).get();
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x8);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.movT(0, 0x86);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.subT(r3, 0x18);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.addT(r3, 0x1a);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 1);
    MEMORY.ref(2, r2).setu(r3);
    r2 = CPU.movT(0, 0x87);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(2, r3).setu(r1);
    r1 = CPU.movT(0, 0x88);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r1 = CPU.lslT(r1, 2);
    r3 = CPU.addT(r7, r1);
    r2 = CPU.addT(r2, 0x6);
    MEMORY.ref(2, r3).setu(r4);
    r1 = CPU.subT(r1, 0x2c);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(2, r3).setu(r4);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(4, r3).setu(r4);
    r0 = CPU.movT(0, 0x0);
    r0 = FUN_807961c(r0);
    r2 = CPU.movT(0, 0x83);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r5 = MEMORY.ref(4, 0x8077e78).get();
    r2 = CPU.lslT(r2, 2);
    r1 = MEMORY.ref(4, 0x8077e80).get();
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(4, r7 + 0x10).setu(r4);
    r2 = CPU.subT(r2, 0x1);
    MEMORY.ref(1, r3).setu(r5);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r5);
    r1 = CPU.subT(r1, 0x5);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r5);
    r6 = MEMORY.ref(4, 0x8077e7c).get();
    r3 = CPU.addT(r7, r1);
    r2 = CPU.r10().value;
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    MEMORY.ref(4, r7).setu(r4);
    r0 = FUN_8077cb8();
    r2 = CPU.movT(0, 0xae);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(4, r3).setu(r0);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r3 = MEMORY.ref(4, 0x8077e84).get();
    MEMORY.ref(4, r3).setu(r4);
    r3 = MEMORY.ref(4, 0x8077ee4).get();
    r1 = CPU.r10().value;
    MEMORY.ref(1, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x8077ee8).get();
    r2 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(4, r7 + 0x4).setu(r4);
    MEMORY.ref(1, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x8077eec).get();
    r2 = MEMORY.ref(4, 0x8077ef0).get();
    MEMORY.ref(2, r3).setu(r4);
    r3 = MEMORY.ref(4, 0x8077ee0).get();
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8077ef4).get();
    r1 = CPU.r8().value;
    r3 = CPU.addT(r7, r2);
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(1, r3).setu(r1);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x8077ef8).get();
    r2 = CPU.r8().value;
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r1 = CPU.addT(r1, 0x1);
    r2 = MEMORY.ref(4, 0x8077efc).get();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    r1 = CPU.addT(r1, 0x2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r6);
    r2 = CPU.addT(r2, 0x2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    r1 = CPU.addT(r1, 0x2);
    r3 = CPU.addT(r7, r2);
    r2 = CPU.movT(0, 0x10);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r2 = CPU.movT(0, 0x93);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r7, r2);
    r1 = CPU.addT(r1, 0x2);
    r2 = CPU.movT(0, 0x20);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x8077f3c).get();
    r1 = CPU.addT(r1, 0x2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x40);
    MEMORY.ref(1, r2).setu(r3);
    r2 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r2 = CPU.addT(r7, r1);
    MEMORY.ref(1, r2).setu(r3);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8078414)
  public static int FUN_8078414(int r0) {
    final int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8078424).get();
    r2 = CPU.movT(0, 0x2c);
    r3 = CPU.andT(r3, r0);
    r0 = CPU.addT(r3, 0x0);
    r0 = CPU.mulT(r0, r2);
    r3 = MEMORY.ref(4, 0x8078428).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x807842c)
  public static int FUN_807842c(int r0, final int r1) {
    int r3;
    final int r5;
    int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8078414(r0);
    r3 = CPU.movT(0, 0x94);
    r3 = CPU.lslT(r3, 1);
    r6 = CPU.addT(r6, r3);
    r3 = MEMORY.ref(1, r6).getUnsigned();
    r0 = MEMORY.ref(2, r0 + 0x4).getUnsigned();
    CPU.cmpT(r3, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_807844e
      r3 = MEMORY.ref(1, r6).getUnsigned();
      r0 = CPU.asrT(r0, r3);
      r3 = CPU.movT(0, 0x1);
      r0 = CPU.andT(r0, r3);
    }

    //LAB_8078456
    return r0;
  }

  @Method(0x8078588)
  public static int FUN_8078588(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    final int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8078414(r0);
    r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
    r3 = CPU.movT(0, 0x10);
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xd8);
      r3 = MEMORY.ref(2, r6 + r3).getUnsigned();
      r2 = MEMORY.ref(4, 0x8078610).get();
      r3 = CPU.eorT(r3, r5);
      r3 = CPU.andT(r3, r2);
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.addT(r2, 0x0);
        r2 = CPU.addT(r6, 0x0);
        r2 = CPU.addT(r2, 0xd8);

        //LAB_80785b8
        do {
          r0 = CPU.addT(r0, 0x1);
          CPU.cmpT(r0, 0xe);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r2 = CPU.addT(r2, 0x2);
          r3 = MEMORY.ref(2, r2).getUnsigned();
          r3 = CPU.eorT(r3, r5);
          r3 = CPU.andT(r3, r1);
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80785ca
      CPU.cmpT(r0, 0xf);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.lslT(r0, 1);
        r4 = CPU.addT(r3, 0x0);
        r4 = CPU.addT(r4, 0xd8);
        r1 = MEMORY.ref(2, r6 + r4).getUnsigned();
        r3 = CPU.lsrT(r1, 11);
        r2 = CPU.addT(r3, 0x1);
        CPU.cmpT(r2, 0x1d);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r0 = CPU.movT(0, 0x1);
          r0 = CPU.negT(r0, r0);
          return r0;
        }
        r3 = MEMORY.ref(4, 0x8078614).get();
        r2 = CPU.lslT(r2, 11);
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r6 + r4).setu(r3);
        return r0;
      }
    }

    //LAB_80785ee
    r2 = CPU.addT(r6, 0x0);
    r0 = CPU.movT(0, 0x0);
    r2 = CPU.addT(r2, 0xd8);
    r1 = CPU.movT(0, 0xd8);

    //LAB_80785f6
    do {
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r2 = CPU.addT(r2, 0x2);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_80785ea
        MEMORY.ref(2, r6 + r1).setu(r5);
        return r0;
      }
      r0 = CPU.addT(r0, 0x1);
      r1 = CPU.addT(r1, 0x2);
      CPU.cmpT(r0, 0xe);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    //LAB_8078606
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.negT(r0, r0);

    //LAB_807860a
    return r0;
  }

  @Method(0x8078708)
  public static int FUN_8078708(int r0, int r1) {
    int r2;
    int r3;
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

    r5 = CPU.addT(r1, 0x0);
    CPU.r10().value = r0;
    r0 = FUN_8077394(r0);
    r5 = CPU.lslT(r5, 1);
    CPU.r11().value = r5;
    r3 = CPU.r11().value;
    r7 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r3, 0xd8);
    r5 = MEMORY.ref(2, r7 + r3).getUnsigned();
    r0 = CPU.r10().value;
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_807842c(r0, r1);
    CPU.cmpT(r0, 0x0);

    jmp_80787cc:
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
    } else {
      //LAB_807873c
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.andT(r3, r2);
      CPU.r9().value = r2;
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_8078414(r0);
        r0 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
        CPU.r8().value = r0;
        CPU.cmpT(r0, 0x6);
        if(!CPU.cpsr().getZero()) { // !=
          r6 = CPU.movT(0, 0x0);
          r5 = CPU.movT(0, 0xd8);

          //LAB_8078764
          while(true) {
            CPU.cmpT(r6, 0xe);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              break;
            }
            r3 = MEMORY.ref(2, r5 + r7).getUnsigned();
            r2 = CPU.r9().value;
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_8078760
              r5 = CPU.addT(r5, 0x2);
              r6 = CPU.addT(r6, 0x1);
              continue;
            }
            r0 = MEMORY.ref(2, r5 + r7).getUnsigned();
            r0 = FUN_8078414(r0);
            r3 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
            CPU.cmpT(r3, CPU.r8().value);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_8078760
              r5 = CPU.addT(r5, 0x2);
              r6 = CPU.addT(r6, 0x1);
              continue;
            }

            break;
          }

          //LAB_807877e
          CPU.cmpT(r6, 0xf);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.lslT(r6, 1);
            r6 = CPU.addT(r3, 0x0);
            r6 = CPU.addT(r6, 0xd8);
            r0 = MEMORY.ref(2, r7 + r6).getUnsigned();
            r0 = FUN_8078414(r0);
            r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
            r3 = CPU.movT(0, 0x2);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.movT(0, 0x2);
              r0 = CPU.negT(r0, r0);
              break jmp_80787cc;
            }

            //LAB_807879e
            r2 = MEMORY.ref(2, r7 + r6).getUnsigned();
            r3 = MEMORY.ref(4, 0x80787c8).get();
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r7 + r6).setu(r3);
          }
        }

        //LAB_80787a6
        r3 = CPU.r11().value;
        r3 = CPU.addT(r3, 0xd8);
        r2 = MEMORY.ref(2, r7 + r3).getUnsigned();
        r1 = MEMORY.ref(4, 0x80787c4).get();
        r2 = CPU.orrT(r2, r1);
        MEMORY.ref(2, r7 + r3).setu(r2);
        r0 = CPU.r10().value;
        FUN_8078bf0(r0);
        r0 = CPU.r10().value;
        FUN_8077428(r0);
        r0 = CPU.movT(0, 0x0);
      }
    }

    //LAB_80787cc
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x8078bf0)
  public static int FUN_8078bf0(int r0) {
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

    CPU.sp().value -= 0x8;
    r0 = FUN_8077394(r0);
    r5 = MEMORY.ref(4, 0x8078c50).get();
    CPU.r9().value = r0;
    r0 = CPU.movT(0, 0x58);
    r5 += CPU.r9().value;
    r0 += CPU.r9().value;
    CPU.r8().value = r0;
    r0 = MEMORY.ref(1, r5).getUnsigned();
    r0 = FUN_8079ad8(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r4 = CPU.movT(0, 0x80);
    r4 = CPU.lslT(r4, 8);
    r1 = MEMORY.ref(4, 0x8078c4c).get();
    r2 = CPU.r8().value;
    r5 = CPU.movT(0, 0x1f);
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8078c2c
      do {
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.andT(r3, r4);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(r1);
        }

        //LAB_8078c36
        r5 = CPU.subT(r5, 0x1);
        r2 = CPU.addT(r2, 0x4);
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r4 = CPU.movT(0, 0x80);
      r1 = MEMORY.ref(4, 0x8078c4c).get();
      r4 = CPU.lslT(r4, 7);
      r2 = CPU.r8().value;
      r5 = CPU.movT(0, 0x1f);

      //LAB_8078c54
      do {
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.andT(r3, r4);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(r1);
        }

        //LAB_8078c5e
        r5 = CPU.subT(r5, 0x1);
        r2 = CPU.addT(r2, 0x4);
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r1 = CPU.r8().value;
      r4 = CPU.movT(0, 0x1f);
      r5 = CPU.movT(0, 0x1f);
      r1 = CPU.addT(r1, 0x7c);

      //LAB_8078c6e
      do {
        r3 = CPU.lslT(r4, 2);
        r0 = CPU.r8().value;
        r2 = MEMORY.ref(2, r3 + r0).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r4 = CPU.subT(r4, 0x1);
        } else {
          //LAB_8078c7e
          MEMORY.ref(2, r1).setu(r2);
          r4 = CPU.subT(r4, 0x1);
          r1 = CPU.subT(r1, 0x4);
          r5 = CPU.subT(r5, 0x1);
        }

        //LAB_8078c86
        CPU.cmpT(r4, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // <
        r3 = CPU.lslT(r5, 2);
        r2 = MEMORY.ref(4, 0x8078ca0).get();
        r3 += CPU.r8().value;

        //LAB_8078c94
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r3).setu(r2);
          r3 = CPU.subT(r3, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
      }

      //LAB_8078ca4
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r1 = CPU.movT(0, 0x80);
      r2 = CPU.addT(r2, 0x10);
      r1 = CPU.lslT(r1, 8);
      CPU.lr().value = r2;
      r3 = CPU.movT(0, 0x10);
      r5 = CPU.movT(0, 0x0);
      CPU.r11().value = r1;
      CPU.r10().value = r3;
      r7 = CPU.lr().value;

      //LAB_8078cb8
      do {
        r3 = MEMORY.ref(1, r7).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.r9().value;
          r1 = CPU.lr().value;
          r2 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
          r3 = MEMORY.ref(1, r1 + 0x1).getUnsigned();
          r2 = CPU.cmpT(r2, r3);
          if(CPU.cpsr().getCarry()) { // unsigned >=
            r2 = CPU.r8().value;
            r6 = MEMORY.ref(2, r2).getUnsigned();
            r3 = MEMORY.ref(1, r1).getUnsigned();
            CPU.r12().value = r6;
            r4 = CPU.movT(0, 0x0);
            CPU.cmpT(CPU.r12().value, r3);
            if(!CPU.cpsr().getZero()) { // !=
              CPU.r12().value = CPU.r10().value;
              r1 = CPU.r8().value;

              //LAB_8078cdc
              do {
                r4 = CPU.addT(r4, 0x1);
                CPU.cmpT(r4, 0x1f);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  break;
                }
                r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r1 = CPU.addT(r1, 0x4);
                r0 = CPU.r12().value;
                r2 = MEMORY.ref(2, r1).getUnsigned();
                r3 = MEMORY.ref(1, r3 + r0).getUnsigned();
                r2 = CPU.cmpT(r2, r3);
              } while(!CPU.cpsr().getZero()); // !=
            }

            //LAB_8078cf0
            CPU.cmpT(r4, 0x20);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.addT(r6, 0x0);
              r4 = CPU.movT(0, 0x0);
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r3 = MEMORY.ref(1, r7).getUnsigned();
                r1 = CPU.r11().value;
                r3 = CPU.orrT(r3, r1);
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
              } else {
                //LAB_8078d06
                while(true) {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x1f);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r3 = CPU.lslT(r4, 2);
                    r0 = CPU.r8().value;
                    r2 = CPU.addT(r3, r0);
                    r3 = MEMORY.ref(2, r2).getUnsigned();
                    CPU.cmpT(r3, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      continue;
                    }
                    r3 = MEMORY.ref(1, r7).getUnsigned();
                    r1 = CPU.r11().value;
                    r3 = CPU.orrT(r3, r1);

                    //LAB_8078d1e
                    MEMORY.ref(2, r2).setu(r3);
                  }

                  break;
                }
              }

              //LAB_8078d20
              CPU.cmpT(r4, 0x20);
              if(CPU.cpsr().getZero()) { // ==
                break;
              }
            }
          }
        }

        //LAB_8078d24
        r2 = CPU.movT(0, 0x4);
        r5 = CPU.addT(r5, 0x1);
        CPU.lr().value += r2;
        r7 = CPU.addT(r7, 0x4);
        CPU.r10().value += r2;
        CPU.cmpT(r5, 0xf);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      //LAB_8078d32
      r3 = CPU.movT(0, 0xd8);
      r5 = CPU.movT(0, 0x0);
      CPU.r10().value = r3;

      //LAB_8078d38
      do {
        r0 = CPU.r10().value;
        r1 = CPU.r9().value;
        r2 = MEMORY.ref(2, r0 + r1).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, 0x8078d68).get();
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = FUN_8078414(r0);
            r3 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r2 = CPU.r8().value;
              r6 = MEMORY.ref(2, r2).getUnsigned();
              r3 = MEMORY.ref(4, 0x8078d6c).get();
              r0 = MEMORY.ref(2, r0 + 0x28).getUnsigned();
              r3 = CPU.andT(r3, r6);
              CPU.r12().value = r0;
              r4 = CPU.movT(0, 0x0);
              CPU.cmpT(r3, CPU.r12().value);
              if(!CPU.cpsr().getZero()) { // !=
                r7 = MEMORY.ref(4, 0x8078da4).get();
                r1 = CPU.r8().value;

                //LAB_8078d78
                do {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x1f);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    break;
                  }
                  r1 = CPU.addT(r1, 0x4);
                  r2 = MEMORY.ref(2, r1).getUnsigned();
                  r3 = CPU.addT(r7, 0x0);
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, CPU.r12().value);
                } while(!CPU.cpsr().getZero()); // !=
              }

              //LAB_8078d8a
              CPU.cmpT(r4, 0x20);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.addT(r6, 0x0);
                r4 = CPU.movT(0, 0x0);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r3 = MEMORY.ref(4, 0x8078da0).get();
                  r3 = CPU.orrT(r3, r0);
                  r0 = CPU.r8().value;
                  MEMORY.ref(2, r0).setu(r3);
                } else {
                  //LAB_8078da8
                  do {
                    r4 = CPU.addT(r4, 0x1);
                    CPU.cmpT(r4, 0x1f);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      break;
                    }
                    r3 = CPU.lslT(r4, 2);
                    r1 = CPU.r8().value;
                    r2 = CPU.addT(r3, r1);
                    r3 = MEMORY.ref(2, r2).getUnsigned();
                    CPU.cmpT(r3, 0x0);
                  } while(!CPU.cpsr().getZero()); // !=

                  r3 = MEMORY.ref(4, 0x8078de4).get();
                  r3 = CPU.orrT(r3, r0);
                  MEMORY.ref(2, r2).setu(r3);
                }

                //LAB_8078dc0
                CPU.cmpT(r4, 0x20);
                if(CPU.cpsr().getZero()) { // ==
                  break;
                }
              }
            }
          }
        }

        //LAB_8078dc4
        r2 = CPU.movT(0, 0x2);
        r5 = CPU.addT(r5, 0x1);
        CPU.r10().value += r2;
        CPU.cmpT(r5, 0xe);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      //LAB_8078dce
      r4 = CPU.movT(0, 0x0);
      r5 = CPU.movT(0, 0x0);
      r1 = CPU.r8().value;

      //LAB_8078dd4
      do {
        r3 = CPU.lslT(r4, 2);
        r0 = CPU.r8().value;
        r2 = MEMORY.ref(2, r3 + r0).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r4 = CPU.addT(r4, 0x1);
        } else {
          //LAB_8078de8
          MEMORY.ref(2, r1).setu(r2);
          r4 = CPU.addT(r4, 0x1);
          r1 = CPU.addT(r1, 0x4);
          r5 = CPU.addT(r5, 0x1);
        }

        //LAB_8078df0
        CPU.cmpT(r4, 0x1f);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      CPU.cmpT(r5, 0x1f);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // >
        r3 = CPU.lslT(r5, 2);
        r0 = CPU.r8().value;
        r2 = CPU.addT(r3, r0);
        r1 = MEMORY.ref(4, 0x8078e10).get();
        r3 = CPU.movT(0, 0x20);
        r5 = CPU.subT(r3, r5);

        //LAB_8078e04
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r2).setu(r1);
          r2 = CPU.addT(r2, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8078e14
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8078e16
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

  @Method(0x8078ed8)
  public static int FUN_8078ed8(int r0) {
    final int r3 = CPU.movT(0, 0xb4);
    r0 = CPU.mulT(r0, r3);
    final int r2 = MEMORY.ref(4, 0x8078ee4).get();
    r0 = CPU.addT(r0, r2);
    return r0;
  }

  @Method(0x8078ee8)
  public static void FUN_8078ee8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    CPU.sp().value -= 0x20;
    r1 = MEMORY.ref(4, 0x8078f90).get();
    CPU.r10().value = CPU.sp().value;
    CPU.r8().value = r1;
    r6 = CPU.movT(0, 0x0);
    CPU.r9().value = CPU.r10().value;

    //LAB_8078efe
    do {
      r0 = CPU.addT(r6, 0x0);
      r0 = FUN_8077394(r0);
      r7 = CPU.addT(r0, 0x0);
      r0 = MEMORY.ref(4, 0x8078f94).get();
      r1 = CPU.r9().value;
      r0 = CPU.addT(r6, r0);
      FUN_8015020(r0, r1);
      r2 = CPU.r9().value;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      MEMORY.ref(1, r7).setu(r3);
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r5 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.r10().value;
        r2 = CPU.addT(r7, 0x0);
        r0 = CPU.movT(0, 0x0);

        //LAB_8078f24
        do {
          r5 = CPU.addT(r5, 0x1);
          r0 = CPU.addT(r0, 0x2);
          CPU.cmpT(r5, 0xd);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(2, r0 + r1).getUnsigned();
          r2 = CPU.addT(r2, 0x1);
          MEMORY.ref(1, r2).setu(r3);
          r3 = MEMORY.ref(2, r0 + r1).getUnsigned();
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8078f38
      r3 = CPU.movT(0, 0x0);
      r6 = CPU.addT(r6, 0x1);
      MEMORY.ref(1, r7 + 0xe).setu(r3);
      CPU.cmpT(r6, 0x7);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r3 = CPU.r8().value;
    r1 = CPU.movT(0, 0x1);
    r0 = MEMORY.ref(4, r3).get();
    r1 = CPU.negT(r1, r1);
    r0 = CPU.cmpT(r0, r1);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8078f4e
      do {
        r0 = FUN_8077394(r0);
        r7 = CPU.addT(r0, 0x0);
        CPU.cmpT(r7, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.r8().value;
          r1 = CPU.movT(0, 0x94);
          r2 = MEMORY.ref(4, r3).get();
          r1 = CPU.lslT(r1, 1);
          r3 = CPU.addT(r7, r1);
          MEMORY.ref(1, r3).setu(r2);
          r0 = MEMORY.ref(1, r3).getUnsigned();
          r0 = FUN_8078ed8(r0);
          r3 = CPU.addT(r7, 0x0);
          r2 = MEMORY.ref(4, 0x8078f8c).get();
          CPU.r10().value = r0;
          r5 = CPU.movT(0, 0xe);
          r3 = CPU.addT(r3, 0xf4);

          //LAB_8078f74
          do {
            r5 = CPU.subT(r5, 0x1);
            MEMORY.ref(2, r3).setu(r2);
            r3 = CPU.subT(r3, 0x2);
            CPU.cmpT(r5, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          r2 = MEMORY.ref(4, 0x8078f98).get();
          r6 = CPU.r10().value;
          r5 = CPU.movT(0, 0x0);
          r6 = CPU.addT(r6, 0x98);
          CPU.r9().value = r2;

          //LAB_8078f9c
          do {
            r3 = CPU.r8().value;
            r0 = MEMORY.ref(4, r3).get();
            r3 = MEMORY.ref(2, r6).getUnsigned();
            r1 = CPU.r9().value;
            r1 = CPU.andT(r1, r3);
            r0 = FUN_8078588(r0, r1);
            r2 = CPU.r8().value;
            r1 = CPU.addT(r0, 0x0);
            r5 = CPU.addT(r5, 0x1);
            r0 = MEMORY.ref(4, r2).get();
            r6 = CPU.addT(r6, 0x2);
            r0 = FUN_8078708(r0, r1);
            CPU.cmpT(r5, 0xc);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

          r3 = CPU.r8().value;
          r0 = MEMORY.ref(4, r3).get();
          FUN_8079ae8(r0);
          r3 = CPU.movT(0, 0x80);
          r3 = CPU.lslT(r3, 7);
          MEMORY.ref(2, r7 + 0x16).setu(r3);
          MEMORY.ref(2, r7 + 0x14).setu(r3);
          r3 = CPU.r10().value;
          r1 = CPU.r8().value;
          r3 = CPU.addT(r3, 0x96);
          r0 = MEMORY.ref(4, r1).get();
          r1 = MEMORY.ref(1, r3).getUnsigned();
          FUN_80792fc(r0, r1);
          r2 = CPU.r8().value;
          r0 = MEMORY.ref(4, r2).get();
          FUN_8077428(r0);
        }

        //LAB_8078fe2
        r3 = CPU.movT(0, 0x4);
        CPU.r8().value += r3;
        r1 = CPU.r8().value;
        r3 = MEMORY.ref(4, r1).get();
        r2 = CPU.movT(0, 0x1);
        r2 = CPU.negT(r2, r2);
        r0 = CPU.addT(r3, 0x0);
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8078ff4
    CPU.sp().value += 0x20;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x8079008)
  public static int FUN_8079008(int r0, int r1) {
    int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r1 = MEMORY.ref(4, 0x8079054).get();
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r2, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return -1;
    }

    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      return 0;
    }

    CPU.cmpT(r5, 0x63);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      return -1;
    }

    r3 = CPU.movT(0, 0x94);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r2, r3);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    CPU.cmpT(r3, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      //LAB_8079048
      return -1;
    }

    r2 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.lslT(r3, 5);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.addT(r3, r5);
    r1 = MEMORY.ref(4, 0x8079058).get();
    r3 = CPU.lslT(r3, 2);
    r3 = CPU.subT(r3, 0x4);
    r0 = MEMORY.ref(4, r1 + r3).get();

    //LAB_807904c
    return r0;
  }

  @Method(0x807905c)
  public static int FUN_807905c(int r0, int r1) {
    int r2;
    int r3;
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

    r6 = CPU.addT(r1, 0x0);
    CPU.r11().value = r0;
    r0 = FUN_8077394(r0);
    CPU.r10().value = r0;
    r0 = CPU.movT(0, 0x2c);
    r0 = FUN_8004970(r0);
    r3 = MEMORY.ref(4, 0x80792bc).get();
    r3 += CPU.r10().value;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r9().value = r0;
    MEMORY.ref(4, r0).setu(r3);
    r0 = CPU.r10().value;
    r1 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
    r2 = CPU.r9().value;
    r3 = MEMORY.ref(4, 0x80792c0).get();
    MEMORY.ref(4, r2 + 0x4).setu(r1);
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r6).setu(r1);
    MEMORY.ref(2, r6 + 0x2).setu(r3);
    MEMORY.ref(2, r6 + 0x4).setu(r2);
    MEMORY.ref(2, r6 + 0x6).setu(r2);
    MEMORY.ref(2, r6 + 0x8).setu(r2);
    MEMORY.ref(2, r6 + 0xa).setu(r2);
    MEMORY.ref(2, r6 + 0xc).setu(r2);
    MEMORY.ref(2, r6 + 0xe).setu(r2);
    CPU.cmpT(r1, 0x62);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      //LAB_80790a6
      r3 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(1, r0 + 0xf).setu(r3);
      r3 = CPU.addT(r1, 0x1);
      MEMORY.ref(2, r6).setu(r3);
      r1 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
      r0 = CPU.r11().value;
      r0 = FUN_8079008(r0, r1);
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.negT(r3, r3);
      r0 = CPU.cmpT(r0, r3);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.movT(0, 0x92);
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r10().value;
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.cmpT(r3, r0);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(4, r2).setu(r0);
        }
      }

      //LAB_80790ce
      r0 = CPU.r11().value;
      r0 = FUN_8078ed8(r0);
      r2 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r6 + r2).get();
      r1 = CPU.addT(r0, 0x0);
      r0 = CPU.r9().value;
      MEMORY.ref(4, r0 + 0x8).setu(r1);
      r0 = MEMORY.ref(2, r6).getUnsigned();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x50);
        r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
        r2 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x5c);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x4).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x68);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x74);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x8).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x80);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0xa).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xc).setu(r3);
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.addT(r3, 0x8c);
        r2 = MEMORY.ref(1, r3).getUnsigned();
        r3 = MEMORY.ref(2, r6 + 0xe).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xe).setu(r3);
      }

      //LAB_807912c
      r0 = CPU.lslT(r0, 16);
      r0 = CPU.asrT(r0, 16);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022ec(r0, r1);
      r0 = CPU.lslT(r0, 16);
      r5 = CPU.asrT(r0, 16);
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r5 = CPU.movT(0, 0x0);
      }

      //LAB_8079140
      CPU.cmpT(r5, 0x4);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r5 = CPU.movT(0, 0x4);
      }

      //LAB_8079146
      r0 = CPU.lslT(r5, 1);
      CPU.r8().value = r0;
      r3 = CPU.r9().value;
      r1 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x52);
      r2 = MEMORY.ref(2, r1 + r3).get();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r1 + r3).get();
      r7 = CPU.subT(r2, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x4).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x5e);
      r1 = MEMORY.ref(2, r2 + r3).get();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).get();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x6).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x6a);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r0 = CPU.r9().value;
      r2 = MEMORY.ref(4, r0 + 0x8).get();
      MEMORY.ref(2, r6 + 0x8).setu(r3);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x76);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0xa).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x82);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r0 = CPU.r9().value;
      r2 = MEMORY.ref(4, r0 + 0x8).get();
      MEMORY.ref(2, r6 + 0xc).setu(r3);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x8d);
      r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x1);
      r3 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r1 = CPU.movT(0, 0x14);
      r0 = CPU.addT(r0, r7);
      r0 = FUN_80022f4(r0, r1);
      r2 = CPU.r10().value;
      r3 = MEMORY.ref(2, r2 + 0x10).getUnsigned();
      r1 = MEMORY.ref(2, r6 + 0xe).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r1 = CPU.addT(r1, r0);
      r3 = CPU.addT(r3, r2);
      r0 = CPU.r10().value;
      MEMORY.ref(2, r0 + 0x10).setu(r3);
      r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0x12).getUnsigned();
      r3 = CPU.addT(r3, r2);
      r2 = CPU.r10().value;
      MEMORY.ref(2, r2 + 0x12).setu(r3);
      r3 = MEMORY.ref(2, r2 + 0x18).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r0 + 0x18).setu(r3);
      r2 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0x1a).getUnsigned();
      r3 = CPU.addT(r3, r2);
      r2 = CPU.r10().value;
      MEMORY.ref(2, r2 + 0x1a).setu(r3);
      r3 = MEMORY.ref(2, r2 + 0x1c).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r0 + 0x1c).setu(r3);
      r3 = MEMORY.ref(1, r0 + 0x1e).getUnsigned();
      r3 = CPU.addT(r3, r1);
      MEMORY.ref(1, r0 + 0x1e).setu(r3);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r0 + 0x1f).setu(r3);
      r3 = CPU.r10().value;
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.addT(r3, 0x20);
      MEMORY.ref(1, r3).setu(r2);
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(2, r6 + 0xe).setu(r1);
      MEMORY.ref(1, r3).setu(r2);
      r0 = CPU.r11().value;
      FUN_8078bf0(r0);
      r0 = CPU.r11().value;
      FUN_8077428(r0);
    }

    //LAB_80792a4
    r0 = CPU.r9().value;
    FUN_8002df0(r0);
    r0 = CPU.addT(r6, 0x0);
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

  @Method(0x80792fc)
  public static void FUN_80792fc(int r0, int r1) {
    final int r3;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x10;
    r6 = CPU.addT(r0, 0x0);
    CPU.r8().value = r1;
    r0 = FUN_8077394(r0);
    r5 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
    CPU.cmpT(r5, CPU.r8().value);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.r8().value;
      r7 = CPU.sp().value;
      r5 = CPU.subT(r3, r5);

      //LAB_8079318
      do {
        r0 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r7, 0x0);
        r5 = CPU.subT(r5, 0x1);
        FUN_807905c(r0, r1);
        CPU.cmpT(r5, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8079326
    r0 = CPU.addT(r6, 0x0);
    FUN_8077428(r0);
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
  }

  @Method(0x8079338)
  public static int FUN_8079338(int r0) {
    int r2;
    int r3;
    r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.lslT(r2, r3);
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(4, 0x8079354).get();
    r3 = MEMORY.ref(1, r3 + r0).getUnsigned();
    r3 = CPU.andT(r3, r2);
    r0 = CPU.negT(r0, r3);
    r0 = CPU.orrT(r0, r3);
    r0 = CPU.lsrT(r0, 31);
    return r0;
  }

  @Method(0x8079358)
  public static void FUN_8079358(int r0) {
    int r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    int r2 = CPU.movT(0, 0x1);
    final int r1 = MEMORY.ref(4, 0x8079370).get();
    r2 = CPU.lslT(r2, r3);
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(1, r1 + r0).getUnsigned();
    r2 = CPU.orrT(r2, r3);
    MEMORY.ref(1, r1 + r0).setu(r2);
  }

  @Method(0x8079374)
  public static void FUN_8079374(int r0) {
    final int r1;
    int r2;
    int r3;
    r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.lslT(r2, r3);
    r1 = MEMORY.ref(4, 0x807938c).get();
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(1, r1 + r0).getUnsigned();
    r3 = CPU.bicT(r3, r2);
    MEMORY.ref(1, r1 + r0).setu(r3);
  }

  @Method(0x80795fc)
  public static int FUN_80795fc() {
    int r0;
    int r5;
    int r6;

    r6 = CPU.movT(0, 0x0);
    r5 = CPU.movT(0, 0x0);

    //LAB_8079602
    do {
      r0 = CPU.addT(r5, 0x0);
      r0 = FUN_8079338(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r6 = CPU.addT(r6, 0x1);
      }

      //LAB_807960e
      r5 = CPU.addT(r5, 0x1);
      CPU.cmpT(r5, 0x7);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r0 = CPU.addT(r6, 0x0);
    return r0;
  }

  @Method(0x807961c)
  public static int FUN_807961c(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = CPU.addT(r0, 0x0);
    r0 = FUN_80795fc();
    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r6, 0x0);
    FUN_8079358(r0);
    r2 = CPU.movT(0, 0x0);
    r2 = CPU.cmpT(r2, r5);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = MEMORY.ref(4, 0x8079660).get();
      r3 = CPU.movT(0, 0xfc);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.addT(r0, r3);

      //LAB_807963a
      do {
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r1 = CPU.addT(r1, 0x1);
        r3 = CPU.cmpT(r3, r6);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_807964a
          return r5;
        }
        r2 = CPU.addT(r2, 0x1);
        r2 = CPU.cmpT(r2, r5);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    } else {
      //LAB_807964e
      r0 = MEMORY.ref(4, 0x8079660).get();
    }

    //LAB_8079650
    r1 = CPU.movT(0, 0xfc);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r2, r1);
    MEMORY.ref(1, r0 + r3).setu(r6);
    r0 = CPU.addT(r5, 0x1);

    //LAB_807965a
    return r0;
  }

  @Method(0x80797ec)
  public static int FUN_80797ec(int r0, final int r1) {
    r0 = CPU.lslT(r0, 2);
    final int r3 = MEMORY.ref(4, 0x80797f8).get();
    r0 = CPU.addT(r0, r1);
    r0 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, r3 + r0).get();
    return r0;
  }

  @Method(0x80797fc)
  public static int FUN_80797fc(int r0, int r1, int r2) {
    int r3;
    int r5;
    int r6;
    final int r7;

    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r2, 0x0);
    CPU.cmpT(r7, 0x7);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = FUN_80773d8(r0);
      r0 = CPU.addT(r0, 0x34);
      r1 = MEMORY.ref(1, r0).getUnsigned();
      CPU.cmpT(r1, 0x2b);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r1 = CPU.movT(0, 0x0);
      }

      //LAB_8079814
      r3 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r3, r1);
      r2 = MEMORY.ref(4, 0x8079878).get();
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(r3, r2);
      r5 = CPU.movT(0, 0x0);
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.addT(r3, 0x4);

      //LAB_8079824
      do {
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r3, r2);
        r3 = CPU.lslT(r3, 1);
        r5 = CPU.addT(r5, 0x1);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
        CPU.cmpT(r5, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    } else {
      //LAB_8079838
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.addT(r1, 0x24);
      r5 = CPU.movT(0, 0x3);

      //LAB_807983e
      do {
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r3, r2);
        r3 = CPU.lslT(r3, 1);
        r5 = CPU.subT(r5, 0x1);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      CPU.cmpT(r7, 0x7);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r5 = CPU.movT(0, 0x0);

        //LAB_8079856
        do {
          r0 = CPU.addT(r7, 0x0);
          r0 = FUN_8078ed8(r0);
          r3 = CPU.addT(r5, 0x0);
          r3 = CPU.addT(r3, 0x90);
          r0 = CPU.addT(r0, 0x2);
          r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
          r3 = MEMORY.ref(4, r6).get();
          r5 = CPU.addT(r5, 0x1);
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(4, r6).setu(r3);
          r6 += 0x4;
          CPU.cmpT(r5, 0x3);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
      }
    }

    //LAB_8079870
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x80798e0)
  public static void FUN_80798e0(int r0, int r1) {
    int r2;
    int r4;
    int r3;
    int r6;
    int r5;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    CPU.sp().value -= 0x14;
    CPU.r9().value = r1;
    r0 = FUN_8077394(r0);
    r2 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80799a4).get();
    r3 = CPU.addT(r2, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.movT(0, 0x94);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r2, r1);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r0 = FUN_80773d8(r0);
      r0 = CPU.addT(r0, 0x34);
      r0 = MEMORY.ref(1, r0).getUnsigned();
      CPU.cmpT(r0, 0x2b);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = CPU.movT(0, 0x0);
      }

      //LAB_8079914
      r3 = CPU.lslT(r0, 1);
      r2 = MEMORY.ref(4, 0x80799a8).get();
      r3 = CPU.addT(r3, r0);
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(r3, r2);
      r2 = CPU.addT(r3, 0x0);
      r7 = CPU.movT(0, 0x0);
      r1 = CPU.r9().value;
      r2 = CPU.addT(r2, 0x8);

      //LAB_8079926
      do {
        r3 = MEMORY.ref(4, r2).get();
        r2 += 0x4;
        r7 = CPU.addT(r7, 0x1);
        MEMORY.ref(4, r1).setu(r3);
        r1 += 0x4;
        CPU.cmpT(r7, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    } else {
      //LAB_8079932
      r0 = CPU.movT(0, 0x94);
      r0 = CPU.lslT(r0, 1);
      r3 = CPU.addT(r2, r0);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.sp().value + 0x4;
      r1 = CPU.addT(r2, 0x0);
      CPU.r8().value = r3;
      r1 = CPU.addT(r1, 0xf8);
      r2 = CPU.r8().value;
      FUN_80797fc(r0, r1, r2);
      r0 = MEMORY.ref(4, 0x80799ac).get();
      r4 = CPU.movT(0, 0x0);
      CPU.r10().value = r0;
      r7 = CPU.movT(0, 0x3);

      //LAB_8079950
      do {
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r4 + r1).get();
        r1 = CPU.movT(0, 0xa);
        r0 = CPU.addT(r5, 0x0);
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_80022fc(r0, r1);
        r1 = CPU.movT(0, 0xa);
        r6 = CPU.addT(r0, 0x0);
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80022ec(r0, r1);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.cmpT(r0, 0xf);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r0 = CPU.movT(0, 0xf);
        }

        //LAB_8079970
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r0 = CPU.movT(0, 0x0);
        }

        //LAB_8079976
        r2 = CPU.lslT(r0, 2);
        r3 = CPU.r9().value;
        r0 = CPU.r10().value;
        r1 = CPU.addT(r4, r3);
        r3 = MEMORY.ref(2, r0 + r2).getUnsigned();
        r3 = CPU.addT(r3, r6);
        MEMORY.ref(2, r1).setu(r3);
        r2 += CPU.r10().value;
        r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
        r7 = CPU.subT(r7, 0x1);
        r3 = CPU.addT(r3, r6);
        MEMORY.ref(2, r1 + 0x2).setu(r3);
        r4 = CPU.addT(r4, 0x4);
        CPU.cmpT(r7, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
    }

    //LAB_8079994
    CPU.sp().value += 0x14;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x80799b0)
  public static int FUN_80799b0(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r2 = CPU.movT(0, 0x1);
    r5 = CPU.addT(r0, 0x0);
    r2 = CPU.negT(r2, r2);
    CPU.sp().value -= 0x14;
    CPU.r8().value = r2;
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r5, 0x7);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r6 = CPU.sp().value + 0x4;
      r0 = CPU.addT(r5, 0x0);
      r2 = CPU.addT(r6, 0x0);
      FUN_80797fc(r0, r1, r2);
      r0 = CPU.movT(0, 0x20);
      r0 = FUN_8079338(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        if(r5 == 0) {
          CPU.sp().value += 0x14;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return 0xc8;
        }

        if(r5 == 1) {
          CPU.sp().value += 0x14;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return 0xc9;
        }
      }

      //LAB_80799ee
      r0 = 0xca;
      if(r5 != 5) {
        r0 = CPU.movT(0, 0x1);
        r0 = CPU.negT(r0, r0);
        CPU.cmpT(CPU.r8().value, r0);
        if(CPU.cpsr().getZero()) { // ==
          CPU.r12().value = CPU.r8().value;
          r5 = CPU.r8().value;
          r0 = CPU.movT(0, 0x0);
          r2 = CPU.addT(r6, 0x0);

          //LAB_8079a04
          do {
            r3 = MEMORY.ref(4, r2).get();
            r2 += 0x4;

            CPU.cmpT(CPU.r12().value, r3);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              CPU.r12().value = r3;
              r5 = CPU.addT(r0, 0x0);
            }

            //LAB_8079a0e
            r0 = CPU.addT(r0, 0x1);
            CPU.cmpT(r0, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

          r4 = CPU.movT(0, 0x1);
          r4 = CPU.negT(r4, r4);
          CPU.r12().value = r4;
          r0 = CPU.movT(0, 0x0);
          r2 = CPU.addT(r6, 0x0);

          //LAB_8079a1e
          do {
            r0 = CPU.cmpT(r0, r5);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, r2).get();
              CPU.cmpT(CPU.r12().value, r3);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                CPU.r12().value = r3;
                r4 = CPU.addT(r0, 0x0);
              }
            }

            //LAB_8079a2c
            r0 = CPU.addT(r0, 0x1);
            r2 = CPU.addT(r2, 0x4);
            CPU.cmpT(r0, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

          r3 = CPU.lslT(r4, 2);
          r3 = MEMORY.ref(4, r6 + r3).get();
          r1 = CPU.addT(r5, 0x0);
          CPU.cmpT(r3, 0x9);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = CPU.addT(r4, 0x0);
          }

          r0 = CPU.addT(r5, 0x0);
          r0 = FUN_80797ec(r0, r1);
          r3 = MEMORY.ref(4, 0x8079acc).get();
          r7 = MEMORY.ref(4, 0x8079ad0).get();
          CPU.r10().value = r3;
          CPU.lr().value = CPU.r10().value;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          r5 = MEMORY.ref(4, 0x8079ad4).get();
          CPU.r11().value = r0;
          CPU.r9().value = r6;
          r0 = CPU.movT(0, 0xca);
          r7 += CPU.lr().value;

          //LAB_8079a60
          do {
            r6 = CPU.r10().value;
            r3 = MEMORY.ref(4, r5 + r6).get();
            CPU.cmpT(r3, CPU.r11().value);
            if(CPU.cpsr().getZero()) { // ==
              r3 = MEMORY.ref(1, r7).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              r2 = CPU.lslT(r3, 2);
              r2 = CPU.addT(r2, r3);
              r3 = MEMORY.ref(4, r1).get();
              r2 = CPU.lslT(r2, 1);
              r4 = CPU.movT(0, 0x0);
              r3 = CPU.cmpT(r3, r2);
              if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                r2 = CPU.lr().value;
                r3 = CPU.addT(r5, r2);
                CPU.r12().value = CPU.r9().value;
                r1 = CPU.addT(r3, 0x4);

                //LAB_8079a82
                do {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x3);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    break;
                  }
                  r1 = CPU.addT(r1, 0x1);
                  r3 = MEMORY.ref(1, r1).getUnsigned();
                  r2 = CPU.lslT(r3, 2);
                  r2 = CPU.addT(r2, r3);
                  r3 = CPU.movT(0, 0x4);
                  CPU.r12().value += r3;
                  r6 = CPU.r12().value;
                  r3 = MEMORY.ref(4, r6).get();
                  r2 = CPU.lslT(r2, 1);
                  r3 = CPU.cmpT(r3, r2);
                } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
              }

              //LAB_8079a9e
              CPU.cmpT(r4, 0x4);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8079a42
                CPU.r8().value = r0;
                break;
              }
            }

            //LAB_8079aa2
            r0 = CPU.subT(r0, 0x1);
            r7 = CPU.subT(r7, 0x54);
            r5 = CPU.subT(r5, 0x54);
            CPU.cmpT(r0, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          //LAB_8079aac
          r1 = CPU.movT(0, 0x1);
          r1 = CPU.negT(r1, r1);
          CPU.cmpT(CPU.r8().value, r1);
          if(CPU.cpsr().getZero()) { // ==
            r2 = CPU.movT(0, 0x0);
            CPU.r8().value = r2;
          }

          //LAB_8079ab8
          r0 = CPU.r8().value;
        }
      }
    }

    //LAB_8079aba
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }


  @Method(0x8079ae8)
  public static void FUN_8079ae8(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r5 = CPU.addT(r0, 0x0);
    r0 = FUN_8077394(r0);
    r2 = CPU.movT(0, 0x94);
    r6 = CPU.addT(r0, 0x0);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r6, r2);
    r1 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0xf8);
    r0 = MEMORY.ref(1, r3).getUnsigned();
    r0 = FUN_80799b0(r0, r1);
    r2 = MEMORY.ref(4, 0x8079b20).get();
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(1, r3).setu(r0);
    r0 = CPU.addT(r5, 0x0);
    FUN_8078bf0(r0);
    r1 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0x24);
    r0 = CPU.addT(r5, 0x0);
    FUN_80798e0(r0, r1);
  }

  @Method(0x8079ad8)
  public static int FUN_8079ad8(int r0) {
    int r3;
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r3 = MEMORY.ref(4, 0x8079ae4).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x807a0cc)
  public static int FUN_807a0cc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }
}
