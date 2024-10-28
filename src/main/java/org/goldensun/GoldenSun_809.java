package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_80022fc;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_80041d8;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.FUN_8009098;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770c8;
import static org.goldensun.GoldenSun_808.FUN_808ba1c;
import static org.goldensun.GoldenSun_808.FUN_808d394;
import static org.goldensun.GoldenSun_808.FUN_808fefc;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_809 {
  private GoldenSun_809() { }

  @Method(0x80901c0)
  public static void FUN_80901c0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80907b0)
  public static void FUN_80907b0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80908e0)
  public static void FUN_80908e0() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x809093c).get();
    r1 = CPU.movT(0, 0xc4);
    r6 = MEMORY.ref(4, r3).get();
    r0 = CPU.movT(0, 0xa9);
    r1 = CPU.lslT(r1, 5);
    r0 = CPU.lslT(r0, 1);
    r5 = CPU.addT(r6, r1);
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      return;
    }

    //LAB_80908fa
    r2 = MEMORY.ref(4, 0x8090940).get();
    r1 = CPU.addT(r6, r2);
    r3 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(1, r1 + r3).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return;
    }

    //LAB_8090908
    r2 = CPU.addT(r2, 0x1);
    r3 = CPU.addT(r6, r2);
    r2 = MEMORY.ref(1, r3).getUnsigned();
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r2 = CPU.lslT(r2, 24);
    r3 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(1, r1 + r3).get();
    r2 = CPU.asrT(r2, 24);
    r2 = CPU.cmpT(r2, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0xe0);
      r3 = CPU.lslT(r3, 2);
      r4 = MEMORY.ref(4, 0x8090944).get();
      r1 = CPU.addT(r6, r3);
      r0 = CPU.movT(0, 0x0);

      //LAB_8090928
      do {
        r3 = MEMORY.ref(2, r1).getUnsigned();
        r2 = MEMORY.ref(2, r5).getUnsigned();
        r0 = CPU.addT(r0, 0x1);
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r1).setu(r3);
        r5 = CPU.addT(r5, 0x2);
        r1 = CPU.addT(r1, 0x2);
        r0 = CPU.cmpT(r0, r4);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    } else {
      //LAB_8090948
      r1 = CPU.movT(0, 0xe0);
      r2 = CPU.movT(0, 0xe0);
      r1 = CPU.lslT(r1, 2);
      r2 = CPU.lslT(r2, 4);
      r0 = CPU.addT(r6, r1);
      r1 = CPU.addT(r6, r2);
      r2 = CPU.movT(0, 0xa8);
      r3 = MEMORY.ref(4, 0x80909a0).get();
      r2 = CPU.lslT(r2, 4);
      MEMORY.call(r3, r0, r1, r2);
      r3 = MEMORY.ref(4, 0x80909a4).get();
      r2 = CPU.addT(r6, r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r2).setu(r3);
    }

    //LAB_8090966
    r1 = CPU.movT(0, 0xa8);
    r1 = CPU.lslT(r1, 6);
    r3 = CPU.addT(r6, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.eorT(r2, r3);
    r3 = CPU.lslT(r2, 3);
    r3 = CPU.subT(r3, r2);
    r3 = CPU.lslT(r3, 7);
    r2 = CPU.movT(0, 0x8c);
    r3 = CPU.addT(r6, r3);
    r2 = CPU.lslT(r2, 6);
    r4 = CPU.addT(r3, r2);
    r3 = CPU.movT(0, 0xf8);
    r2 = CPU.movT(0, 0xe0);
    r3 = CPU.lslT(r3, 7);
    r0 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 2);
    r7 = MEMORY.ref(4, 0x8090998).get();
    r5 = MEMORY.ref(4, 0x809099c).get();
    CPU.r12().value = r3;
    r0 = CPU.lslT(r0, 1);
    r1 = CPU.addT(r6, r2);

    //LAB_80909a8
    do {
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r2 = CPU.r12().value;
      r2 = CPU.andT(r2, r3);
      r3 = MEMORY.ref(2, r1 + 0x2).getUnsigned();
      r3 = CPU.lslT(r3, 16);
      r3 = CPU.asrT(r3, 21);
      r3 = CPU.andT(r3, r7);
      r2 = CPU.orrT(r2, r3);
      r3 = MEMORY.ref(2, r1 + 0x4).getUnsigned();
      r3 = CPU.lslT(r3, 16);
      r3 = CPU.asrT(r3, 26);
      r3 = CPU.andT(r3, r5);
      r2 = CPU.orrT(r2, r3);
      r0 = CPU.subT(r0, 0x1);
      MEMORY.ref(2, r4).setu(r2);
      r1 = CPU.addT(r1, 0x6);
      r4 = CPU.addT(r4, 0x2);
      CPU.cmpT(r0, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    r3 = CPU.movT(0, 0xa8);
    r3 = CPU.lslT(r3, 6);
    r1 = CPU.addT(r6, r3);
    r3 = MEMORY.ref(1, r1).getUnsigned();
    r2 = CPU.movT(0, 0x1);
    r3 = CPU.eorT(r3, r2);
    MEMORY.ref(1, r1).setu(r3);
    r2 = MEMORY.ref(1, r1).getUnsigned();
    r3 = CPU.lslT(r2, 3);
    r3 = CPU.subT(r3, r2);
    r3 = CPU.lslT(r3, 7);
    r1 = CPU.movT(0, 0x8c);
    r0 = CPU.addT(r6, r3);
    r1 = CPU.lslT(r1, 6);
    r5 = MEMORY.ref(4, 0x8090a4c).get();
    r6 = CPU.addT(r0, r1);
    r4 = MEMORY.ref(4, 0x8090a50).get();
    r3 = MEMORY.ref(2, r4).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r4).setu(r4);
    r2 = MEMORY.ref(2, r5).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r3 = CPU.addT(r3, r5);
      r3 = CPU.addT(r3, 0x4);
      r2 = CPU.addT(r2, 0x1);
      MEMORY.ref(4, r3).setu(r6);
      r3 += 0x4;
      MEMORY.ref(2, r5).setu(r2);
      r2 = CPU.movT(0, 0xa0);
      r2 = CPU.lslT(r2, 19);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x8090a54).get();
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_8090a16
    MEMORY.ref(2, r4).setu(r1);
    r3 = MEMORY.ref(2, r4).getUnsigned();
    r6 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r4).setu(r4);
    r2 = MEMORY.ref(2, r5).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r1 = CPU.movT(0, 0x93);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r5);
      r1 = CPU.lslT(r1, 6);
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(2, r5).setu(r2);
      r2 = CPU.addT(r0, r1);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x8090a58).get();
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x8090a54).get();
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_8090a42
    MEMORY.ref(2, r4).setu(r6);

    //LAB_8090a44
  }

  @Method(0x8090a5c)
  public static void FUN_8090a5c(int r0, int r1, int r2, int r3) {
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

    CPU.r10().value = r1;
    CPU.r8().value = r2;
    r1 = CPU.movT(0, 0xe0);
    r2 = CPU.addT(r3, 0x0);
    r3 = CPU.movT(0, 0x80);
    CPU.sp().value -= 0x28;
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.lslT(r3, 8);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero()) { // ==
      r3 = CPU.movT(0, 0xa0);
      r3 = CPU.lslT(r3, 19);
      r0 = MEMORY.ref(2, r3).getUnsigned();
    }

    //LAB_8090a86
    CPU.cmpT(r2, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.movT(0, 0xe0);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
    } else {
      //LAB_8090a90
      CPU.cmpT(r2, 0x2);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0xa8);
        r3 = CPU.lslT(r3, 3);
        CPU.r8().value += r3;
        r1 = CPU.movT(0, 0xe0);
        r3 = CPU.movT(0, 0xe0);
        r1 = CPU.lslT(r1, 1);
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
        CPU.r10().value += r1;
      }
    }

    //LAB_8090aa4
    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 8);
    r0 = CPU.cmpT(r0, r1);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r2 = MEMORY.ref(4, 0x8090ae8).get();
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.andT(r3, r2);
      r2 = CPU.r8().value;
      MEMORY.ref(2, r2).setu(r3);
      r3 = CPU.movT(0, 0x2);
      r2 = MEMORY.ref(4, 0x8090aec).get();
      CPU.r8().value += r3;
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.andT(r3, r2);
      r1 = CPU.r8().value;
      r3 = CPU.lslT(r3, 5);
      MEMORY.ref(2, r1).setu(r3);
      r3 = MEMORY.ref(4, 0x8090af0).get();
      r2 = CPU.movT(0, 0x2);
      CPU.r8().value += r2;
      r0 = CPU.andT(r0, r3);
      r3 = CPU.lslT(r0, 10);
      r1 = CPU.r8().value;
      MEMORY.ref(2, r1).setu(r3);
      r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = CPU.subT(r3, 0x1);
      CPU.r8().value += r2;
      r2 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r2, r3);
      r2 = CPU.lslT(r2, 1);
      r4 = CPU.movT(0, 0x80);
      r4 = CPU.lslT(r4, 24);
      r0 = CPU.r8().value;
      r2 = CPU.lsrT(r2, 1);
      r3 = MEMORY.ref(4, 0x8090e48).get();
      r0 = CPU.subT(r0, 0x6);
      r1 = CPU.r8().value;
      r2 = CPU.orrT(r2, r4);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
    } else {
      //LAB_8090afe
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 13);
      r0 = CPU.cmpT(r0, r3);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        //LAB_8090f3e
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 14);
        r3 = CPU.andT(r3, r0);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.movT(0, 0x1f);
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
          r1 = CPU.addT(r0, 0x0);
          r2 = CPU.lsrT(r0, 5);
          r0 = CPU.lsrT(r0, 10);
          r1 = CPU.andT(r1, r3);
          CPU.r11().value = r0;
          r2 = CPU.andT(r2, r3);
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
          r1 = CPU.r11().value;
          r1 = CPU.andT(r1, r3);
          MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r2 = CPU.movT(0, 0x0);
          CPU.r9().value = r2;
          CPU.r11().value = r1;
          CPU.cmpT(CPU.r9().value, r3);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            //LAB_8090f6e
            do {
              r1 = CPU.r10().value;
              r4 = MEMORY.ref(2, r1).getUnsigned();
              r3 = CPU.movT(0, 0xf8);
              r0 = CPU.lslT(r4, 11);
              r3 = CPU.lslT(r3, 8);
              r2 = CPU.movT(0, 0x2);
              r0 = CPU.andT(r0, r3);
              r3 = CPU.movT(0, 0xf8);
              r3 = CPU.lslT(r3, 9);
              CPU.r10().value += r2;
              r2 = CPU.lslT(r4, 7);
              r2 = CPU.andT(r2, r3);
              r3 = CPU.movT(0, 0xf8);
              r3 = CPU.lslT(r3, 7);
              r3 = CPU.andT(r3, r4);
              r0 = CPU.addT(r0, r2);
              r0 = CPU.addT(r0, r3);
              r1 = CPU.movT(0, 0x60);
              r3 = MEMORY.ref(4, 0x80910dc).get();
              r0 = (int)MEMORY.call(r3, r0, r1);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              r4 = CPU.addT(r0, 0x0);
              r7 = CPU.addT(r1, 0x0);
              r7 = CPU.mulT(r7, r4);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r0 = CPU.addT(r7, 0x0);
              r6 = CPU.addT(r2, 0x0);
              r6 = CPU.mulT(r6, r4);
              r5 = CPU.r11().value;
              r5 = CPU.mulT(r5, r4);
              r0 = FUN_80912a8(r0);
              r7 = CPU.addT(r0, 0x0);
              r0 = CPU.addT(r6, 0x0);
              r0 = FUN_80912a8(r0);
              r6 = CPU.addT(r0, 0x0);
              r0 = CPU.addT(r5, 0x0);
              r0 = FUN_80912a8(r0);
              r3 = CPU.r8().value;
              r1 = CPU.r8().value;
              r2 = CPU.r8().value;
              r5 = CPU.addT(r0, 0x0);
              MEMORY.ref(2, r3).setu(r5);
              MEMORY.ref(2, r1 + 0x2).setu(r6);
              MEMORY.ref(2, r2 + 0x4).setu(r7);
              r1 = CPU.movT(0, 0x1);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r3 = CPU.movT(0, 0x6);
              CPU.r9().value += r1;
              CPU.r8().value += r3;
              CPU.cmpT(CPU.r9().value, r2);
            } while(!CPU.cpsr().getCarry()); // unsigned <
          }
        } else {
          //LAB_8090fde
          r3 = CPU.movT(0, 0x80);
          r3 = CPU.lslT(r3, 15);
          r3 = CPU.andT(r3, r0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_8090fea
            r3 = CPU.movT(0, 0x1f);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
            r1 = CPU.addT(r0, 0x0);
            r2 = CPU.lsrT(r0, 5);
            r0 = CPU.lsrT(r0, 10);
            r1 = CPU.andT(r1, r3);
            CPU.r11().value = r0;
            r2 = CPU.andT(r2, r3);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
            r1 = CPU.r11().value;
            r1 = CPU.andT(r1, r3);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r2 = CPU.movT(0, 0x0);
            CPU.r9().value = r2;
            CPU.r11().value = r1;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8091010
              r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r1 = CPU.addT(r1, r2);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
              r1 = CPU.lslT(r2, 16);
              r2 = CPU.r11().value;
              r3 = CPU.lslT(r3, 16);
              r2 = CPU.lslT(r2, 16);
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);

              //LAB_8091028
              do {
                r3 = CPU.r10().value;
                r4 = MEMORY.ref(2, r3).getUnsigned();
                r2 = CPU.movT(0, 0x1f);
                r6 = CPU.addT(r4, 0x0);
                r0 = CPU.lsrT(r4, 5);
                r6 = CPU.andT(r6, r2);
                r0 = CPU.andT(r0, r2);
                r3 = CPU.lsrT(r4, 10);
                r1 = CPU.movT(0, 0x2);
                r3 = CPU.andT(r3, r2);
                CPU.r10().value += r1;
                r0 = CPU.addT(r6, r0);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                r0 = CPU.addT(r0, r3);
                r1 += CPU.r11().value;
                r3 = MEMORY.ref(4, 0x80910dc).get();
                r0 = CPU.lslT(r0, 4);
                r0 = (int)MEMORY.call(r3, r0, r1);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r4 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r4);
                r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r0 = CPU.lsrT(r0, 4);
                r0 = CPU.lslT(r0, 16);
                r1 = CPU.asrT(r2, 4);
                CPU.r12().value = 0x8091064;
                r0 = (int)MEMORY.call(0x3000118, r0, r1);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r7 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r1, 0x0);
                r0 = CPU.mulT(r0, r4);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r0 = CPU.lsrT(r0, 4);
                r0 = CPU.lslT(r0, 16);
                r1 = CPU.asrT(r2, 4);
                CPU.r12().value = 0x8091078;
                r0 = (int)MEMORY.call(0x3000118, r0, r1);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.r11().value;
                r0 = CPU.mulT(r0, r4);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r0 = CPU.lsrT(r0, 4);
                r1 = CPU.asrT(r3, 4);
                r0 = CPU.lslT(r0, 16);
                CPU.r12().value = 0x809108c;
                r0 = (int)MEMORY.call(0x3000118, r0, r1);
                r5 = CPU.addT(r0, 0x0);
                r0 = CPU.lsrT(r7, 16);
                r0 = FUN_8091294(r0);
                r7 = CPU.addT(r0, 0x0);
                r0 = CPU.lsrT(r6, 16);
                r0 = FUN_8091294(r0);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.lsrT(r5, 16);
                r0 = FUN_8091294(r0);
                r1 = MEMORY.ref(4, 0x80910e4).get();
                r5 = CPU.addT(r0, 0x0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r1 = MEMORY.ref(4, 0x80910e4).get();
                r2 = CPU.movT(0, 0x2);
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                CPU.r8().value += r2;
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r1 = CPU.movT(0, 0x1);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x2);
                CPU.r9().value += r1;
                CPU.r8().value += r3;
                CPU.cmpT(CPU.r9().value, r2);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
          } else {
            r3 = CPU.movT(0, 0x80);
            r3 = CPU.lslT(r3, 16);
            r3 = CPU.andT(r3, r0);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.movT(0, 0x0);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              CPU.r9().value = r3;
              CPU.cmpT(CPU.r9().value, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r5 = MEMORY.ref(4, 0x8091108).get();
                r0 = MEMORY.ref(4, 0x809110c).get();
                r2 = MEMORY.ref(4, 0x8091110).get();
                r1 = CPU.r8().value;

                //LAB_8091114
                do {
                  r3 = CPU.r10().value;
                  r4 = MEMORY.ref(2, r3).getUnsigned();
                  r3 = CPU.movT(0, 0x2);
                  CPU.r10().value += r3;
                  r3 = CPU.addT(r4, 0x0);
                  r3 = CPU.andT(r3, r5);
                  MEMORY.ref(2, r1).setu(r3);
                  r3 = CPU.addT(r4, 0x0);
                  r3 = CPU.andT(r3, r0);
                  r3 = CPU.lslT(r3, 5);
                  r4 = CPU.andT(r4, r2);
                  MEMORY.ref(2, r1 + 0x2).setu(r3);
                  r3 = CPU.lslT(r4, 10);
                  MEMORY.ref(2, r1 + 0x4).setu(r3);
                  r3 = CPU.movT(0, 0x1);
                  CPU.r9().value += r3;
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                  r1 = CPU.addT(r1, 0x6);
                  CPU.cmpT(CPU.r9().value, r3);
                } while(!CPU.cpsr().getCarry()); // unsigned <
              }
            } else {
              //LAB_809113e
              CPU.cmpT(r2, 0x2);
              if(CPU.cpsr().getZero()) { // ==
                r1 = CPU.movT(0, 0xa8);
                r1 = CPU.lslT(r1, 3);
                r0 = CPU.addT(r0, r1);
              }

              //LAB_8091148
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r2 = CPU.lslT(r3, 1);
              r2 = CPU.addT(r2, r3);
              r4 = CPU.movT(0, 0x84);
              r4 = CPU.lslT(r4, 24);
              r2 = CPU.lsrT(r2, 1);
              r3 = MEMORY.ref(4, 0x8091170).get();
              r1 = CPU.r8().value;
              r2 = CPU.orrT(r2, r4);
              MEMORY.ref(4, r3).setu(r0);
              r3 += 0x4;
              MEMORY.ref(4, r3).setu(r1);
              r3 += 0x4;
              MEMORY.ref(4, r3).setu(r2);
            }
          }
        }
      } else {
        //LAB_8090b08
        r1 = MEMORY.ref(4, 0x8090e4c).get();
        r0 = CPU.addT(r0, r1);

        //LAB_8090b12
        switch(r0) {
          case 0:
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r2;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090b44
              r6 = MEMORY.ref(4, 0x8090e54).get();
              r5 = CPU.r8().value;

              //LAB_8090b48
              do {
                r1 = CPU.r10().value;
                r4 = MEMORY.ref(2, r1).getUnsigned();
                r3 = CPU.movT(0, 0xf8);
                r0 = CPU.lslT(r4, 11);
                r3 = CPU.lslT(r3, 8);
                r2 = CPU.movT(0, 0x2);
                r0 = CPU.andT(r0, r3);
                r3 = CPU.movT(0, 0xf8);
                r3 = CPU.lslT(r3, 9);
                CPU.r10().value += r2;
                r2 = CPU.lslT(r4, 7);
                r2 = CPU.andT(r2, r3);
                r3 = CPU.movT(0, 0xf8);
                r3 = CPU.lslT(r3, 7);
                r3 = CPU.andT(r3, r4);
                r0 = CPU.addT(r0, r2);
                r0 = CPU.addT(r0, r3);
                r1 = CPU.movT(0, 0x7);
                r0 = (int)MEMORY.call(r6, r0, r1);
                r4 = CPU.addT(r0, 0x0);
                MEMORY.ref(2, r5).setu(r4);
                MEMORY.ref(2, r5 + 0x2).setu(r4);
                MEMORY.ref(2, r5 + 0x4).setu(r4);
                r3 = CPU.movT(0, 0x1);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                CPU.r9().value += r3;
                r5 = CPU.addT(r5, 0x6);
                CPU.cmpT(CPU.r9().value, r1);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 1:
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r2;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090b92
              r1 = CPU.movT(0, 0x1f);
              r2 = MEMORY.ref(4, 0x8090e58).get();
              CPU.r11().value = r1;

              //LAB_8090b98
              do {
                r3 = CPU.r10().value;
                r4 = MEMORY.ref(2, r3).getUnsigned();
                r1 = CPU.movT(0, 0x2);
                r6 = CPU.addT(r4, 0x0);
                r3 = CPU.r11().value;
                r0 = CPU.lsrT(r4, 5);
                r6 = CPU.andT(r6, r3);
                r0 = CPU.andT(r0, r3);
                CPU.r10().value += r1;
                r3 = CPU.lsrT(r4, 10);
                r1 = CPU.r11().value;
                r3 = CPU.andT(r3, r1);
                r0 = CPU.addT(r6, r0);
                r0 = CPU.addT(r0, r3);
                MEMORY.ref(4, CPU.sp().value).setu(r2);
                r3 = MEMORY.ref(4, 0x8090e54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = (int)MEMORY.call(r3, r0, r1);
                r4 = CPU.addT(r0, 0x0);
                r3 = CPU.lslT(r4, 2);
                r6 = CPU.addT(r3, 0x5);
                r3 = CPU.lslT(r4, 1);
                r3 = CPU.addT(r3, r4);
                r5 = CPU.addT(r3, 0x5);
                r7 = CPU.addT(r5, 0x0);
                r2 = MEMORY.ref(4, CPU.sp().value).get();
                CPU.cmpT(r6, 0x7);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r6 = CPU.movT(0, 0x8);
                }

                //LAB_8090bd4
                CPU.cmpT(r5, 0x7);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r7 = CPU.movT(0, 0x8);
                  CPU.cmpT(r5, 0x7);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r5 = CPU.movT(0, 0x8);
                  }
                }

                //LAB_8090be0
                CPU.cmpT(r6, 0x1c);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r6 = CPU.movT(0, 0x1c);
                }

                //LAB_8090be6
                CPU.cmpT(r7, 0x1c);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r7 = CPU.movT(0, 0x1c);
                }

                //LAB_8090bec
                CPU.cmpT(r5, 0x1c);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r5 = CPU.movT(0, 0x1c);
                }

                //LAB_8090bf2
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r1 = CPU.movT(0, 0x1);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                CPU.r9().value += r1;
                CPU.cmpT(CPU.r9().value, r3);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 2:
            r1 = CPU.movT(0, 0x0);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r1;
            CPU.cmpT(CPU.r9().value, r2);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090c2e
              r3 = CPU.movT(0, 0x1f);
              CPU.r11().value = r3;

              //LAB_8090c32
              do {
                r1 = CPU.r10().value;
                r4 = MEMORY.ref(2, r1).getUnsigned();
                r3 = CPU.r11().value;
                r6 = CPU.addT(r4, 0x0);
                r6 = CPU.andT(r6, r3);
                r7 = CPU.lsrT(r4, 5);
                r5 = CPU.lsrT(r4, 10);
                r7 = CPU.andT(r7, r3);
                r5 = CPU.andT(r5, r3);
                r3 = CPU.addT(r6, 0x0);
                r3 = CPU.orrT(r3, r7);
                r2 = CPU.movT(0, 0x2);
                r3 = CPU.orrT(r3, r5);
                CPU.r10().value += r2;
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = CPU.lsrT(r6, 1);
                  r1 = CPU.movT(0, 0x3);
                  r0 = CPU.addT(r7, 0x0);
                  r6 = CPU.subT(r6, r3);
                  r0 = FUN_80022ec(r0, r1);
                  r6 = CPU.addT(r6, 0xa);
                  r7 = CPU.subT(r7, r0);
                  r0 = CPU.addT(r6, 0x0);
                  r0 = FUN_8091294(r0);
                  r7 = CPU.addT(r7, 0x8);
                  r6 = CPU.addT(r0, 0x0);
                  r0 = CPU.addT(r7, 0x0);
                  r0 = FUN_8091294(r0);
                  r5 = CPU.subT(r5, 0x7);
                  r7 = CPU.addT(r0, 0x0);
                  r0 = CPU.addT(r5, 0x0);
                  r0 = FUN_8091294(r0);
                  r5 = CPU.addT(r0, 0x0);
                }

                //LAB_8090c7e
                r2 = MEMORY.ref(4, 0x8090e5c).get();
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                r2 = CPU.movT(0, 0x2);
                MEMORY.ref(2, r1).setu(r3);
                CPU.r8().value += r2;
                r2 = MEMORY.ref(4, 0x8090e58).get();
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                r2 = CPU.movT(0, 0x2);
                MEMORY.ref(2, r1).setu(r3);
                CPU.r8().value += r2;
                r2 = MEMORY.ref(4, 0x8090e60).get();
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x1);
                r2 = CPU.movT(0, 0x2);
                CPU.r9().value += r3;
                CPU.r8().value += r2;
                CPU.cmpT(CPU.r9().value, r1);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 3:
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r2;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090cc0
              r1 = MEMORY.ref(4, 0x8090e60).get();
              CPU.r11().value = r1;

              //LAB_8090cc4
              do {
                r2 = CPU.r10().value;
                r4 = MEMORY.ref(2, r2).getUnsigned();
                r1 = CPU.movT(0, 0x1f);
                r6 = CPU.addT(r4, 0x0);
                r3 = CPU.movT(0, 0x2);
                r7 = CPU.lsrT(r4, 5);
                r5 = CPU.lsrT(r4, 10);
                r6 = CPU.andT(r6, r1);
                CPU.r10().value += r3;
                r7 = CPU.andT(r7, r1);
                r5 = CPU.andT(r5, r1);
                CPU.cmpT(r6, 0x9);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r6 = CPU.movT(0, 0xa);
                }

                //LAB_8090ce0
                CPU.cmpT(r7, 0xf);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r7 = CPU.movT(0, 0x10);
                }

                //LAB_8090ce6
                CPU.cmpT(r5, 0xf);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r5 = CPU.movT(0, 0x10);
                }

                //LAB_8090cec
                CPU.cmpT(r6, 0x1c);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r6 = CPU.movT(0, 0x1c);
                }

                //LAB_8090cf2
                CPU.cmpT(r7, 0x18);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r7 = CPU.movT(0, 0x18);
                }

                //LAB_8090cf8
                CPU.cmpT(r5, 0x1a);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r5 = CPU.movT(0, 0x1a);
                }

                //LAB_8090cfe
                r0 = CPU.addT(r6, 0x0);
                r0 = FUN_8091294(r0);
                r7 = CPU.addT(r7, 0x2);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r7, 0x0);
                r0 = FUN_8091294(r0);
                r5 = CPU.addT(r5, 0x2);
                r7 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r5, 0x0);
                r0 = FUN_8091294(r0);
                r5 = CPU.addT(r0, 0x0);
                r2 = CPU.r11().value;
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r2 = CPU.movT(0, 0x2);
                r1 = CPU.r11().value;
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                CPU.r8().value += r2;
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x1);
                r2 = CPU.movT(0, 0x2);
                CPU.r9().value += r3;
                CPU.r8().value += r2;
                CPU.cmpT(CPU.r9().value, r1);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 4:
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r2;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090d5a
              r1 = MEMORY.ref(4, 0x8090e5c).get();
              CPU.r11().value = r1;

              //LAB_8090d5e
              do {
                r2 = CPU.r10().value;
                r4 = MEMORY.ref(2, r2).getUnsigned();
                r1 = CPU.movT(0, 0x1f);
                r6 = CPU.addT(r4, 0x0);
                r7 = CPU.lsrT(r4, 5);
                r5 = CPU.lsrT(r4, 10);
                r6 = CPU.andT(r6, r1);
                r7 = CPU.andT(r7, r1);
                r5 = CPU.andT(r5, r1);
                r0 = CPU.addT(r6, r7);
                r1 = CPU.movT(0, 0x3);
                r3 = CPU.movT(0, 0x2);
                r0 = CPU.addT(r0, r5);
                CPU.r10().value += r3;
                r0 = FUN_80022ec(r0, r1);
                r0 = FUN_8091294(r0);
                r3 = CPU.asrT(r6, 1);
                r6 = CPU.addT(r3, r0);
                r3 = CPU.asrT(r7, 1);
                r7 = CPU.addT(r3, r0);
                r3 = CPU.asrT(r5, 1);
                r5 = CPU.addT(r3, r0);
                r0 = CPU.addT(r6, 0x0);
                r0 = FUN_8091294(r0);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r7, 0x0);
                r0 = FUN_8091294(r0);
                r7 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r5, 0x0);
                r0 = FUN_8091294(r0);
                r5 = CPU.addT(r0, 0x0);
                r2 = CPU.r11().value;
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2 + 0x2).setu(r3);
                r1 = CPU.r11().value;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                MEMORY.ref(2, r2 + 0x4).setu(r3);
                r1 = CPU.movT(0, 0x1);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x6);
                CPU.r9().value += r1;
                CPU.r8().value += r3;
                CPU.cmpT(CPU.r9().value, r2);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 5:
            r3 = CPU.movT(0, 0x0);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r3;
            CPU.cmpT(CPU.r9().value, r1);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090ddc
              r2 = CPU.movT(0, 0x1f);
              CPU.r11().value = r2;

              //LAB_8090de0
              do {
                r3 = CPU.r10().value;
                r4 = MEMORY.ref(2, r3).getUnsigned();
                r2 = CPU.r11().value;
                r7 = CPU.lsrT(r4, 5);
                r5 = CPU.lsrT(r4, 10);
                r6 = CPU.addT(r4, 0x0);
                r7 = CPU.andT(r7, r2);
                r5 = CPU.andT(r5, r2);
                r6 = CPU.andT(r6, r2);
                r3 = CPU.asrT(r7, 3);
                r2 = CPU.asrT(r5, 3);
                r3 = CPU.addT(r3, r2);
                r6 = CPU.addT(r6, r3);
                r1 = CPU.movT(0, 0x2);
                r0 = CPU.addT(r6, 0x0);
                CPU.r10().value += r1;
                r0 = FUN_8091294(r0);
                r1 = CPU.movT(0, 0x3);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r7, 0x0);
                r0 = FUN_80022ec(r0, r1);
                r1 = CPU.movT(0, 0x3);
                r7 = CPU.subT(r7, r0);
                r0 = CPU.addT(r5, 0x0);
                r0 = FUN_80022ec(r0, r1);
                r1 = MEMORY.ref(4, 0x8090e60).get();
                r5 = CPU.subT(r5, r0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1 + 0x2).setu(r3);
                r2 = MEMORY.ref(4, 0x8090e58).get();
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2 + 0x4).setu(r3);
                r1 = CPU.movT(0, 0x1);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x6);
                CPU.r9().value += r1;
                CPU.r8().value += r3;
                CPU.cmpT(CPU.r9().value, r2);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          case 6:
            r3 = CPU.movT(0, 0x0);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r3;
            CPU.cmpT(CPU.r9().value, r1);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090e70
              r2 = CPU.movT(0, 0x1f);
              CPU.r11().value = r2;

              //LAB_8090e74
              do {
                r3 = CPU.r10().value;
                r4 = MEMORY.ref(2, r3).getUnsigned();
                r2 = CPU.r11().value;
                r6 = CPU.addT(r4, 0x0);
                r7 = CPU.lsrT(r4, 5);
                r6 = CPU.andT(r6, r2);
                r7 = CPU.andT(r7, r2);
                r1 = CPU.movT(0, 0x2);
                r3 = CPU.lsrT(r6, 1);
                r5 = CPU.lsrT(r4, 10);
                r0 = CPU.addT(r7, 0x0);
                CPU.r10().value += r1;
                r1 = CPU.movT(0, 0x3);
                r5 = CPU.andT(r5, r2);
                r6 = CPU.subT(r6, r3);
                r0 = FUN_80022ec(r0, r1);
                r6 = CPU.addT(r6, 0x6);
                r7 = CPU.subT(r7, r0);
                r0 = CPU.addT(r6, 0x0);
                r0 = FUN_8091294(r0);
                r7 = CPU.addT(r7, 0x4);
                r6 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r7, 0x0);
                r0 = FUN_8091294(r0);
                r5 = CPU.subT(r5, 0x6);
                r7 = CPU.addT(r0, 0x0);
                r0 = CPU.addT(r5, 0x0);
                r0 = FUN_8091294(r0);
                r2 = MEMORY.ref(4, 0x8090ee4).get();
                r5 = CPU.addT(r0, 0x0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r2 = MEMORY.ref(4, 0x8090ee8).get();
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2 + 0x2).setu(r3);
                r2 = MEMORY.ref(4, 0x8090eec).get();
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                MEMORY.ref(2, r1 + 0x4).setu(r3);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r3 = CPU.movT(0, 0x1);
                r2 = CPU.movT(0, 0x6);
                CPU.r9().value += r3;
                CPU.r8().value += r2;
                CPU.cmpT(CPU.r9().value, r1);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;

          default:
            //LAB_8090ef0
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            CPU.r9().value = r2;
            CPU.cmpT(CPU.r9().value, r3);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              //LAB_8090efc
              r5 = MEMORY.ref(4, 0x8090f08).get();
              r0 = MEMORY.ref(4, 0x8090f0c).get();
              r2 = MEMORY.ref(4, 0x8090f10).get();
              r1 = CPU.r8().value;

              //LAB_8090f14
              do {
                r3 = CPU.r10().value;
                r4 = MEMORY.ref(2, r3).getUnsigned();
                r3 = CPU.movT(0, 0x2);
                CPU.r10().value += r3;
                r3 = CPU.addT(r4, 0x0);
                r3 = CPU.andT(r3, r5);
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.addT(r4, 0x0);
                r3 = CPU.andT(r3, r0);
                r3 = CPU.lslT(r3, 5);
                r4 = CPU.andT(r4, r2);
                MEMORY.ref(2, r1 + 0x2).setu(r3);
                r3 = CPU.lslT(r4, 10);
                MEMORY.ref(2, r1 + 0x4).setu(r3);
                r3 = CPU.movT(0, 0x1);
                CPU.r9().value += r3;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                r1 = CPU.addT(r1, 0x6);
                CPU.cmpT(CPU.r9().value, r3);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }
            break;
        }
      }
    }

    //LAB_809115e
    CPU.sp().value += 0x28;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x8091174)
  public static void FUN_8091174() {
    final int addr = mallocSlotBoard(32, 0x2a04);

    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x85000a81);
    CPU.sp().value += 0x4;

    DMA.channels[3].SAD.setu(0x5000000);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000070);

    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(addr + 0x1c0);
    DMA.channels[3].CNT.setu(0x84000070);

    FUN_8090a5c(0x10000, addr, addr + 0xe00, 0);
    FUN_80041d8(0x80908e1, 0xc8f);
  }

  @Method(0x8091200)
  public static void FUN_8091200(final int r0, int r1) {
    final int r2;
    int r3;
    final int r4;
    r3 = MEMORY.ref(4, 0x809121c).get();
    r4 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xe0);
      r3 = CPU.lslT(r3, 4);
      r2 = CPU.addT(r1, r3);
      r3 = CPU.addT(r4, 0x0);
      FUN_8090a5c(r0, r1, r2, r3);
    }

    //LAB_8091218
  }

  @Method(0x8091220)
  public static void FUN_8091220(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091240)
  public static void FUN_8091240(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091254)
  public static void FUN_8091254(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091294)
  public static int FUN_8091294(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80912a8)
  public static int FUN_80912a8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809163c)
  public static void FUN_809163c(final int r0) {
    if(MEMORY.ref(4, 0x3001ebc).deref(4).offset(0x1cc).get() == 0 && r0 != 0) {
      FUN_80030f8(r0);
    }

    //LAB_8091656
  }

  @Method(0x8091660)
  public static void FUN_8091660() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80919d8)
  public static int FUN_80919d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091a58)
  public static int FUN_8091a58(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091dc8)
  public static void FUN_8091dc8() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r5;
    r3 = MEMORY.ref(4, 0x8091df0).get();
    r2 = CPU.movT(0, 0xe0);
    r5 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r5, r2);
    r2 = CPU.addT(r2, 0x8);
    r0 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r5, r2);
    r1 = MEMORY.ref(4, r3).get();
    FUN_808fefc(r0, r1);
    r3 = CPU.movT(0, 0xe3);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r2).setu(r3);
  }

  @Method(0x8091e20)
  public static void FUN_8091e20() {
    final int r0;
    int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8091e38).get();
    r2 = CPU.movT(0, 0xe4);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r0 = MEMORY.ref(4, r3).get();
    FUN_80030f8(r0);
  }

  @Method(0x8091e3c)
  public static void FUN_8091e3c(final int r0, final int r1) {
    final int r3 = MEMORY.ref(4, 0x3001ebc).get() + 0x170;
    MEMORY.ref(2, r3).setu(999);
    MEMORY.ref(2, 0x2000400).setu(r0);
    MEMORY.ref(2, 0x2000402).setu(r1);
  }

  @Method(0x8092054)
  public static int FUN_8092054(final int r0) {
    return FUN_808ba1c(r0);
  }

  @Method(0x8093a6c)
  public static void FUN_8093a6c(final int r0, int r1) {
    switch(r1 - 1) {
      case 0 -> r1 = 0x809fe00;
      case 1 -> r1 = 0x809fd44;
      case 2 -> r1 = 0x809fe10;
      case 3 -> r1 = 0x809fecc;
      case 4 -> r1 = 0x809ff18;
      case 5 -> {
        MEMORY.ref(4, r0 + 0x68).setu(FUN_8092054(MEMORY.ref(4, 0x2000434).get()));
        r1 = 0x809ff2c;
      }
    }

    //LAB_8093ac6
    FUN_8009098(r0, r1);
  }

  /** NOTE returns r8 */
  @Method(0x80941e0)
  public static void FUN_80941e0(final int r0) {

  }

  @Method(0x8094428)
  public static int FUN_8094428() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80955b0)
  public static void FUN_80955b0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095680)
  public static void FUN_8095680() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095778)
  public static void FUN_8095778(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r1 = MEMORY.ref(4, 0x809586c).get();
    r0 = CPU.movT(0, 0x8d);
    r0 = CPU.lslT(r0, 2);
    r7 = CPU.addT(r1, r0);
    r3 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(2, r7 + r3).get();
    r2 = MEMORY.ref(2, r7).getUnsigned();
    r3 = CPU.movT(0, 0xf0);
    r6 = MEMORY.ref(4, 0x8095870).get();
    r3 = CPU.lslT(r3, 8);
    r0 = CPU.r8().value;
    r5 = CPU.andT(r5, r3);
    r6 = CPU.andT(r6, r2);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, 0x8095874).get();
        r2 = MEMORY.ref(4, 0x8095878).get();
        r6 = CPU.andT(r6, r3);
        r3 = CPU.addT(r6, r2);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r0);
          r1 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r1).get();
          if(r2 <= 0 || r2 == MEMORY.ref(4, 0x8095880).get()) {
            //LAB_80957c0
            r0 = CPU.addT(r6, 0x0);
            r0 = CPU.subT(r0, 0xac);
            FUN_80770c8(r0);
            MEMORY.ref(2, r7).setu(r5);
          }
        }
      } else {
        //LAB_80957cc
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 5);
        r5 = CPU.cmpT(r5, r0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x1);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.addT(r6, 0x0);
            FUN_80770c8(r0);
          }

          //LAB_80957e6
          r1 = CPU.r8().value;
          MEMORY.ref(2, r7).setu(r1);
        }
      }
    } else {
      //LAB_80957ec
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r2 = MEMORY.ref(4, 0x8095874).get();
        r0 = MEMORY.ref(4, 0x8095878).get();
        r6 = CPU.andT(r6, r2);
        r3 = CPU.addT(r6, r0);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r6 = CPU.andT(r6, r2);
          r2 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = MEMORY.ref(4, 0x8095878).get();
            r5 = CPU.addT(r6, r1);
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.movT(0, 0x14);
            r0 = FUN_80022ec(r0, r1);
            r1 = CPU.movT(0, 0x14);
            CPU.r8().value = r0;
            r0 = CPU.addT(r5, 0x0);
            r0 = FUN_80022fc(r0, r1);
            r5 = CPU.movT(0, 0x7);
            r7 = CPU.addT(r0, 0x0);

            //LAB_8095826
            jmp_8095854:
            {
              do {
                do {
                  r5++;

                  //LAB_8095828
                  if(r5 > 0x41) {
                    break jmp_8095854;
                  }
                  r0 = FUN_808d394(r5);
                } while(r0 == 0);

                r2 = CPU.movT(0, 0x2);
                r3 = MEMORY.ref(2, r0 + r2).get();
                r0 = MEMORY.ref(4, 0x8095878).get();
                r3 = CPU.subT(r3, 0x30);
                r2 = CPU.addT(r6, r0);
                r3 = CPU.cmpT(r3, r2);
              } while(!CPU.cpsr().getZero()); // !=

              r0 = CPU.movT(0, 0x28);
              FUN_80030f8(r0);
              r1 = CPU.r8().value;
              r0 = CPU.addT(r5, 0x0);
              r2 = CPU.addT(r7, 0x0);
              FUN_80955b0(r0, r1, r2);
            }

            //LAB_8095854
            r1 = MEMORY.ref(4, 0x809586c).get();
          }
        }
      }

      //LAB_8095856
      r3 = CPU.movT(0, 0x8d);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r1, r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_8095860
    CPU.r8().value = CPU.pop();
  }

  @Method(0x8099810)
  public static void FUN_8099810() {
    final int r0;
    int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x8099830).get();
    r2 = CPU.movT(0, 0x93);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r0 = MEMORY.ref(4, 0x8099834).get();
      r1 = CPU.lslT(r1, 4);
      FUN_80041d8(r0, r1);
    }

    //LAB_809982c
  }

  @Method(0x809c138)
  public static void FUN_809c138(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809c3a4)
  public static void FUN_809c3a4() {
    throw new RuntimeException("Not implemented");
  }
}
