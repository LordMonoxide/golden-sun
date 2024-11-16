package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.divideU;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSunVars._2000434;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars.framesSinceInput_3001d24;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_801.FUN_8015020;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_807 {
  private GoldenSun_807() { }

  /** {@link GoldenSun_807#FUN_8077330} */
  @Method(0x8077000)
  public static int FUN_8077000(final int r0) {
    return (int)MEMORY.call(0x8077330, r0);
  }

  @Method(0x8077008)
  public static int FUN_8077008(final int r0) {
    return (int)MEMORY.call(0x8077394, r0);
  }

  /** {@link GoldenSun_807#FUN_8077428} */
  @Method(0x8077010)
  public static void FUN_8077010(final int r0) {
    MEMORY.call(0x8077428, r0);
  }

  @Method(0x8077080)
  public static int FUN_8077080(final int r0) {
    return (int)MEMORY.call(0x8078b9c, r0);
  }

  /** {@link GoldenSun_807#FUN_8078bc0} */
  @Method(0x8077090)
  public static int FUN_8077090(final int r0, final int r1) {
    return (int)MEMORY.call(0x8078bc0, r0, r1);
  }

  @Method(0x8077098)
  public static void FUN_8077098() {
    FUN_8077d38();
  }

  /** {@link GoldenSun_807#FUN_8079338} */
  @Method(0x80770c0)
  public static int FUN_80770c0(final int r0) {
    return (int)MEMORY.call(0x8079338, r0);
  }

  /** {@link GoldenSun_807#FUN_8079358} */
  @Method(0x80770c8)
  public static void FUN_80770c8(final int r0) {
    MEMORY.call(0x8079358, r0);
  }

  @Method(0x80770d0)
  public static void FUN_80770d0(final int r0) {
    MEMORY.call(0x8079374, r0);
  }

  /** {@link GoldenSun_807#FUN_80783dc} */
  @Method(0x8077120)
  public static int FUN_8077120(final int r0, final int r1) {
    return (int)MEMORY.call(0x80783dc, r0, r1);
  }

  /** {@link GoldenSun_807#FUN_80795fc} */
  @Method(0x8077148)
  public static int FUN_8077148() {
    return (int)MEMORY.call(0x80795fc);
  }

  /** {@link GoldenSun_807#FUN_807a2e4} */
  @Method(0x80771b0)
  public static int FUN_80771b0(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x807a2e4, r0, r1, r2);
  }

  /** {@link GoldenSun_807#FUN_807a3a8} */
  @Method(0x80771c0)
  public static int FUN_80771c0(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x807a3a8, r0, r1, r2);
  }

  @Method(0x8077270)
  public static void FUN_8077270() {
    MEMORY.call(0x8077f40);
  }

  /** {@link GoldenSun_807#FUN_8077c10} */
  @Method(0x80772f0)
  public static void FUN_80772f0() {
    MEMORY.call(0x8077c10);
  }

  @Method(0x8077330)
  public static int FUN_8077330(final int r0) {
    if(r0 == 0) {
      //LAB_807733e
      return 0x200024c;
    }

    //LAB_8077340
    return FUN_8077394(0x83);
  }

  @Method(0x8077394)
  public static int FUN_8077394(final int r0) {
    final int r2;
    final int r3;

    if(r0 >= 0 && r0 < 8) {
      return 0x2000500 + 0x14c * r0;
    }

    //LAB_80773a8
    r3 = r0 + 0x80;
    CPU.cmpT(r3, 0x5);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      return 0;
    }

    r2 = boardWramMallocHead_3001e50.offset(54 * 0x4).get();
    if(r2 == 0) {
      //LAB_80773c6
      return 0;
    }

    //LAB_80773c8
    return r2 + 0x14c * r0 - 0xa600;
  }

  @Method(0x80773d8)
  public static int FUN_80773d8(int r0) {
    final int r3;

    r0 = CPU.subT(r0, 0x8);
    CPU.cmpT(r0, 0xf9);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80773e2
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r0 = CPU.addT(r0, 0x8080ec8); //TODO
    return r0;
  }

  @Method(0x8077428)
  public static void FUN_8077428(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r5 = CPU.addT(r0, 0x0);
    CPU.sp().value -= 0x4;
    r0 = mallocBoard(0x60);
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
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r4);
    r3 = CPU.addT(r7, 0x143);
    MEMORY.ref(1, r3).setu(r4);
    r3 = CPU.addT(r7, 0x129);
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
                r1 = CPU.addT(r7, 0x143);
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

      r3 = CPU.addT(r7, 0x129);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r0 = FUN_8079ad8(r0);
      r5 = CPU.addT(r0, 0x0);
      r2 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
      r3 = MEMORY.ref(4, r6).get();
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r6).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xa).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x8).get();
      MEMORY.ref(4, r6 + 0x4).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xb).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0xc).get();
      MEMORY.ref(4, r6 + 0x8).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xc).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x10).get();
      MEMORY.ref(4, r6 + 0xc).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xd).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x18).get();
      MEMORY.ref(4, r6 + 0x10).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = divideS(r0, r1);
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
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6).setu(r0);
              }

              case 8 -> {
                r2 = MEMORY.ref(4, r6 + 0x20).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0x20).setu(r0);
              }

              case 9 -> {
                r2 = MEMORY.ref(4, r6 + 0x4).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0x4).setu(r0);
              }

              case 0xa -> {
                r2 = MEMORY.ref(4, r6 + 0x24).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0x24).setu(r0);
              }

              case 0xb -> {
                r2 = MEMORY.ref(4, r6 + 0x8).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0x8).setu(r0);
              }

              case 0xc -> {
                r2 = MEMORY.ref(4, r6 + 0xc).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0xc).setu(r0);
              }

              case 0xd -> {
                r2 = MEMORY.ref(4, r6 + 0x10).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
                MEMORY.ref(4, r6 + 0x10).setu(r0);
              }

              case 0xe -> {
                r2 = MEMORY.ref(4, r6 + 0x18).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = divideS(r0, r1);
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
    r3 = CPU.addT(r7, 0x133);
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
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = CPU.addT(r7, 0x135);
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
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = CPU.addT(r7, 0x147);
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

    r5 = CPU.movT(0, 0x3);
    r0 = CPU.addT(r7, 0x137);
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

    r3 = CPU.addT(r7, 0x129);
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
          r0 = FUN_8079338(0x113);
        }

        case 3 -> {
          r0 = FUN_8079338(0x111);
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
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x8).setu(999);
    }

    //LAB_8077a44
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0xc).setu(r3);
    }

    //LAB_8077a4e
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0xc).setu(999);
    }

    //LAB_8077a54
    r3 = MEMORY.ref(4, r6 + 0x10).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x10).setu(r3);
    }

    //LAB_8077a5e
    r3 = CPU.cmpT(r3, 999);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x10).setu(999);
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
    r3 = CPU.cmpT(r3, 10000);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x20).setu(10000);
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

    r3 = CPU.addT(r7, 0x129);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = 1999;
    } else {
      r1 = 9999;
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
        r2 = CPU.addT(r2, 0x3fff);
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
    setMallocAddress(r6);
    CPU.sp().value += 0x4;

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
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

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    FUN_8079374(0x167);
    CPU.r10().value = FUN_80795fc();
    CPU.r8().value = 0;
    CPU.cmpT(CPU.r8().value, CPU.r10().value);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      CPU.r9().value = 0x2000438;
      CPU.r11().value = 0x200;

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
            r0 = FUN_8078414(MEMORY.ref(2, r2 + r7).getUnsigned());
            r5 = CPU.addT(r0, 0x0);
            r5 = CPU.addT(r5, 0x18);
            r6 = CPU.movT(0, 0x3);

            //LAB_8077c70
            do {
              r3 = MEMORY.ref(1, r5).getUnsigned();
              r5 = CPU.addT(r5, 0x4);
              CPU.cmpT(r3, 0x1b);
              if(CPU.cpsr().getZero()) { // ==
                FUN_8079358(0x167);
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

        CPU.r8().value++;
        CPU.r9().value++;
        CPU.cmpT(CPU.r8().value, CPU.r10().value);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_8077c9e
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
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
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r5 = CPU.addT(r3, 0xfffffe20);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r5, r3);
    r5 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r4 = CPU.addT(r3, 0xfffffe20);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r4, r3);
    r4 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r3, 0xfffffe20);
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
    r3 = debug_3001f54.get();
    r0 = CPU.asrT(r2, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.orrT(r0, 0xffff8000);
    }

    //LAB_8077d1e
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x8077d38)
  public static void FUN_8077d38() {
    CPU.sp().value -= 0x8;
    final int r5 = CPU.sp().value + 0x4;

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000240);
    DMA.channels[3].CNT.setu(0x850000b0);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2001000);
    DMA.channels[3].CNT.setu(0x850003e1);

    //LAB_8077d66
    while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
      DebugHelper.sleep(0);
    }

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000040);
    DMA.channels[3].CNT.setu(0x85000080);

    MEMORY.ref(1, 0x2001104).setu(0xff);

    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(0x2000500);
    DMA.channels[3].CNT.setu(0x85000298);

    MEMORY.ref(4, CPU.sp().value).setu(0);
    FUN_8078ee8();
    MEMORY.ref(2, 0x2000450).setu(0x1);
    MEMORY.ref(2, 0x2000452).setu(0x2);
    MEMORY.ref(2, 0x2000454).setu(0x4);
    MEMORY.ref(2, 0x2000456).setu(0x8);
    MEMORY.ref(2, 0x2000458).setu(0x200);
    MEMORY.ref(2, 0x200045a).setu(0x100);
    MEMORY.ref(2, 0x200045c).setu(0x2);
    int r4 = MEMORY.ref(4, CPU.sp().value).get();
    MEMORY.ref(2, 0x2000460).setu(r4);
    MEMORY.ref(2, 0x2000462).setu(r4);
    _2000434.set(r4);
    FUN_807961c(0);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    MEMORY.ref(4, 0x2000250).setu(r4);
    _200044c.set(0x1);
    MEMORY.ref(1, 0x200044a).setu(0x1);
    MEMORY.ref(1, 0x200044b).setu(0x1);
    MEMORY.ref(1, 0x2000445).setu(0);
    MEMORY.ref(1, 0x2000446).setu(0x8);
    MEMORY.ref(4, 0x2000240).setu(r4);
    MEMORY.ref(4, 0x20004f8).setu(FUN_8077cb8());
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    _3001c9c.set(r4);
    _3001d08.set(0);
    MEMORY.ref(4, 0x2000244).setu(r4);
    MEMORY.ref(1, 0x200046a).setu(_3001d08.get());
    framesSinceInput_3001d24.set(r4);
    MEMORY.ref(2, 0x2002004).setu(0xffffffff);
    MEMORY.ref(1, 0x200035d).setu(0x4);
    MEMORY.ref(1, 0x200035e).setu(0x4);
    MEMORY.ref(1, 0x200035f).setu(0x4);
    MEMORY.ref(1, 0x2000360).setu(0x8);
    MEMORY.ref(1, 0x2000361).setu(0x8);
    MEMORY.ref(1, 0x2000362).setu(0x8);
    MEMORY.ref(1, 0x2000363).setu(0x10);
    MEMORY.ref(1, 0x2000364).setu(0x10);
    MEMORY.ref(1, 0x2000365).setu(0x10);
    MEMORY.ref(1, 0x2000366).setu(0x20);
    MEMORY.ref(1, 0x2000367).setu(0x20);
    MEMORY.ref(1, 0x2000368).setu(0x20);
    MEMORY.ref(1, 0x2000369).setu(0x40);
    MEMORY.ref(1, 0x200036a).setu(0x40);
    MEMORY.ref(1, 0x200036b).setu(0x40);

    CPU.sp().value += 0x8;
  }

  @Method(0x807822c)
  public static void FUN_807822c(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;

    r0 = FUN_8077394(r0);
    r5 = CPU.addT(r0, 0x0);
    r2 = CPU.movT(0, 0x38);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r3 = CPU.movT(0, 0x34);
    r1 = MEMORY.ref(2, r5 + r3).get();
    r0 = CPU.lslT(r0, 14);
    r0 = divideS(r0, r1);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 7);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.movT(0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r3 = CPU.addT(r0, 0x0);
      }
    }

    //LAB_8078252
    MEMORY.ref(2, r5 + 0x14).setu(r3);
    r3 = CPU.lslT(r3, 16);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.movT(0, 0x38);
      r3 = MEMORY.ref(2, r5 + r2).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0x1);
        MEMORY.ref(2, r5 + 0x14).setu(r3);
      }
    }

    //LAB_8078266
    r3 = CPU.movT(0, 0x3a);
    r0 = MEMORY.ref(2, r5 + r3).get();
    r2 = CPU.movT(0, 0x36);
    r1 = MEMORY.ref(2, r5 + r2).get();
    r0 = CPU.lslT(r0, 14);
    r0 = divideS(r0, r1);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 7);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.movT(0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        r3 = CPU.addT(r0, 0x0);
      }
    }

    //LAB_8078284
    MEMORY.ref(2, r5 + 0x16).setu(r3);
    r3 = CPU.lslT(r3, 16);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.movT(0, 0x3a);
      r3 = MEMORY.ref(2, r5 + r2).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0x1);
        MEMORY.ref(2, r5 + 0x16).setu(r3);
      }
    }

    //LAB_8078298
  }

  @Method(0x80783dc)
  public static int FUN_80783dc(final int r0, final int r1) {
    final int r6 = FUN_8077394(r0);
    MEMORY.ref(2, r6 + 0x3a).setu(MathHelper.clamp(MEMORY.ref(2, r6 + 0x3a).get() + r1, 0, MEMORY.ref(2, r6 + 0x36).get()));
    FUN_807822c(r0);
    return MEMORY.ref(2, r6 + 0x3a).get();
  }

  @Method(0x8078414)
  public static int FUN_8078414(int r0) {
    final int r2;
    final int r3;
    r2 = CPU.movT(0, 0x2c);
    r3 = CPU.andT(r0, 0x1ff);
    r0 = CPU.addT(r3, 0x0);
    r0 = CPU.mulT(r0, r2);
    r0 = CPU.addT(0x807b6a8, r0); //TODO
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

  @Method(0x8078b9c)
  public static int FUN_8078b9c(int r0) {
    int r3;

    r3 = MEMORY.ref(4, 0x8078bb8).get();
    r0 = CPU.andT(r0, r3);
    r3 = CPU.movT(0, 0x82);
    r3 = CPU.lslT(r3, 2);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8078bac
    r3 = MEMORY.ref(4, 0x8078bbc).get();
    r0 = CPU.lslT(r0, 4);
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x8078bc0)
  public static int FUN_8078bc0(int r0, int r1) {
    int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r1 = MEMORY.ref(4, 0x8078bec).get();
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.addT(r0, 0x58);

    //LAB_8078bce
    do {
      r3 = MEMORY.ref(2, r0).getUnsigned();
      r3 = CPU.andT(r3, r1);
      r0 = CPU.addT(r0, 0x4);
      r3 = CPU.cmpT(r3, r5);
      if(CPU.cpsr().getZero()) { // ==
        return 1;
      }

      //LAB_8078bdc
      r2 = CPU.addT(r2, 0x1);
      CPU.cmpT(r2, 0x1f);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    //LAB_8078be4
    return 0;
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
    int lr;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x8;
    r0 = FUN_8077394(r0);
    CPU.r9().value = r0;
    r0 = CPU.movT(0, 0x58);
    r5 = CPU.r9().value + 0x129;
    r0 += CPU.r9().value;
    CPU.r8().value = r0;
    r0 = MEMORY.ref(1, r5).getUnsigned();
    r0 = FUN_8079ad8(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r4 = CPU.movT(0, 0x80);
    r4 = CPU.lslT(r4, 8);
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
          MEMORY.ref(2, r2).setu(0);
        }

        //LAB_8078c36
        r5 = CPU.subT(r5, 0x1);
        r2 = CPU.addT(r2, 0x4);
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r4 = CPU.movT(0, 0x80);
      r4 = CPU.lslT(r4, 7);
      r2 = CPU.r8().value;
      r5 = CPU.movT(0, 0x1f);

      //LAB_8078c54
      do {
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.andT(r3, r4);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(0);
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
        r3 += CPU.r8().value;

        //LAB_8078c94
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r3).setu(0);
          r3 = CPU.subT(r3, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
      }

      //LAB_8078ca4
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r1 = CPU.movT(0, 0x80);
      r2 = CPU.addT(r2, 0x10);
      r1 = CPU.lslT(r1, 8);
      lr = r2;
      r3 = CPU.movT(0, 0x10);
      r5 = CPU.movT(0, 0x0);
      CPU.r11().value = r1;
      CPU.r10().value = r3;
      r7 = lr;

      //LAB_8078cb8
      do {
        r3 = MEMORY.ref(1, r7).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.r9().value;
          r1 = lr;
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
        lr += r2;
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
          r3 = CPU.andT(r2, 0x200);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = FUN_8078414(r0);
            r3 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r2 = CPU.r8().value;
              r6 = MEMORY.ref(2, r2).getUnsigned();
              r0 = MEMORY.ref(2, r0 + 0x28).getUnsigned();
              r3 = CPU.andT(r6, 0x3fff);
              CPU.r12().value = r0;
              r4 = CPU.movT(0, 0x0);
              CPU.cmpT(r3, CPU.r12().value);
              if(!CPU.cpsr().getZero()) { // !=
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
                  r3 = CPU.andT(r2, 0x3fff);
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
                  r3 = r0 | 0x4000;
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

                  r3 = r0 | 0x4000;
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
        r3 = CPU.movT(0, 0x20);
        r5 = CPU.subT(r3, r5);

        //LAB_8078e04
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r2).setu(0);
          r2 = CPU.addT(r2, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8078e14
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8078e16
    CPU.sp().value += 0x8;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r0;
  }

  @Method(0x8078ed8)
  public static int FUN_8078ed8(int r0) {
    final int r3 = CPU.movT(0, 0xb4);
    r0 = CPU.mulT(r0, r3);
    r0 = 0x80844ec + r0; //TODO
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

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x20;
    CPU.r10().value = CPU.sp().value;
    CPU.r8().value = 0x807b690; //TODO
    r6 = CPU.movT(0, 0x0);
    CPU.r9().value = CPU.r10().value;

    //LAB_8078efe
    do {
      r0 = CPU.addT(r6, 0x0);
      r0 = FUN_8077394(r0);
      r7 = CPU.addT(r0, 0x0);
      r1 = CPU.r9().value;
      r0 = CPU.addT(r6, 0x66);
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
          CPU.r10().value = r0;
          r5 = CPU.movT(0, 0xe);
          r3 = CPU.addT(r3, 0xf4);

          //LAB_8078f74
          do {
            r5 = CPU.subT(r5, 0x1);
            MEMORY.ref(2, r3).setu(0);
            r3 = CPU.subT(r3, 0x2);
            CPU.cmpT(r5, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          r6 = CPU.r10().value;
          r5 = CPU.movT(0, 0x0);
          r6 = CPU.addT(r6, 0x98);
          CPU.r9().value = 0x1ff;

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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  /** Called after confirming character names */
  @Method(0x8077f40)
  public static void FUN_8077f40() {
    FUN_8079358(0x20);
    FUN_8079ae8(0);
    FUN_8079ae8(1);
    FUN_8079ae8(5);
    FUN_8077428(0);
    FUN_8077428(1);
    FUN_8077428(5);
  }

  @Method(0x8079008)
  public static int FUN_8079008(int r0, final int r1) {
    int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r2, 0x129);
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
    r3 = CPU.lslT(r3, 2);
    r3 = CPU.subT(r3, 0x4);
    r0 = MEMORY.ref(4, 0x807a830 + r3).get(); //TODO

    //LAB_807904c
    return r0;
  }

  @Method(0x807905c)
  public static int FUN_807905c(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r6 = CPU.addT(r1, 0x0);
    CPU.r11().value = r0;
    r0 = FUN_8077394(r0);
    CPU.r10().value = r0;
    r0 = mallocBoard(0x2c);
    r3 = CPU.r10().value + 0x129;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r9().value = r0;
    MEMORY.ref(4, r0).setu(r3);
    r0 = CPU.r10().value;
    r1 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
    r2 = CPU.r9().value;
    MEMORY.ref(4, r2 + 0x4).setu(r1);
    MEMORY.ref(2, r6).setu(r1);
    MEMORY.ref(2, r6 + 0x2).setu(0xffff);
    MEMORY.ref(2, r6 + 0x4).setu(0);
    MEMORY.ref(2, r6 + 0x6).setu(0);
    MEMORY.ref(2, r6 + 0x8).setu(0);
    MEMORY.ref(2, r6 + 0xa).setu(0);
    MEMORY.ref(2, r6 + 0xc).setu(0);
    MEMORY.ref(2, r6 + 0xe).setu(0);
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
      r0 = divideS(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = divideU(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = divideU(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = divideU(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = divideU(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = divideU(r0, r1);
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
      r0 = rand();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r1 = CPU.movT(0, 0x14);
      r0 = CPU.addT(r0, r7);
      r0 = divideU(r0, r1);
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
    setMallocAddress(r0);
    r0 = CPU.addT(r6, 0x0);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
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
  public static int FUN_8079338(final int r0) {
    final int r3 = MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).getUnsigned() & 0x1 << (r0 & 0x7); //TODO
    return (-r3 | r3) >>> 31;
  }

  @Method(0x8079358)
  public static void FUN_8079358(final int r0) {
    MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).oru(0x1 << (r0 & 0x7)); //TODO
  }

  @Method(0x8079374)
  public static void FUN_8079374(final int r0) {
    MEMORY.ref(1, 0x2000040 + (r0 << 20 >>> 23)).and(~(0x1 << (r0 & 0x7))); //TODO
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
    r0 = 0x2000240;
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
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
    r0 = CPU.addT(r0, r1);
    r0 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, 0x8088db8 + r0).get(); //TODO
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
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(r3, 0x8088e38); //TODO
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

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x14;
    CPU.r9().value = r1;
    r0 = FUN_8077394(r0);
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r2, 0x129);
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
      r3 = CPU.addT(r3, r0);
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(0x8088e38, r3);
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
      r4 = CPU.movT(0, 0x0);
      CPU.r10().value = 0x8088df8;
      r7 = CPU.movT(0, 0x3);

      //LAB_8079950
      do {
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r4 + r1).get();
        r1 = CPU.movT(0, 0xa);
        r0 = CPU.addT(r5, 0x0);
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = modS(r0, r1);
        r1 = CPU.movT(0, 0xa);
        r6 = CPU.addT(r0, 0x0);
        r0 = CPU.addT(r5, 0x0);
        r0 = divideS(r0, r1);
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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80799b0)
  public static int FUN_80799b0(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    final int lr;

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
          CPU.r10().value = 0x8084b1c; //TODO
          lr = CPU.r10().value;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          r5 = 0x4248;
          CPU.r11().value = r0;
          CPU.r9().value = r6;
          r0 = CPU.movT(0, 0xca);
          r7 = lr + 0x424c;

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
                r2 = lr;
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
  public static void FUN_8079ae8(final int r0) {
    final int r6 = FUN_8077394(r0);
    MEMORY.ref(1, r6 + 0x129).setu(FUN_80799b0(MEMORY.ref(1, r6 + 0x128).getUnsigned(), r6 + 0xf8));
    FUN_8078bf0(r0);
    FUN_80798e0(r0, r6 + 0x24);
  }

  @Method(0x8079ad8)
  public static int FUN_8079ad8(int r0) {
    final int r3;
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r0 = 0x8084b1c + r0;
    return r0;
  }

  @Method(0x807a0cc)
  public static int FUN_807a0cc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x807a1f8)
  public static int FUN_807a1f8(int r0, int r1, int r2) {
    int r3;
    int r4;
    final int r5;
    final int r6;
    final int r7;

    r5 = CPU.addT(r1, 0x0);
    r6 = CPU.addT(r2, 0x0);
    r7 = CPU.addT(r0, 0x0);
    r0 = FUN_8077394(r0);
    r2 = CPU.movT(0, 0x8c);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r5, r2);
    r3 = MEMORY.ref(1, r0 + r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return 0;
    }
    r3 = CPU.movT(0, 0x8e);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r5, r3);
    r3 = MEMORY.ref(1, r0 + r2).getUnsigned();
    CPU.cmpT(r3, 0x9);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r3 = CPU.movT(0, 0xa);
      MEMORY.ref(1, r0 + r2).setu(r3);
      return 0;
    }

    //LAB_807a222
    r1 = CPU.lslT(r5, 2);
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xf8);
    r2 = CPU.movT(0, 0x1);
    r3 = MEMORY.ref(4, r0 + r3).get();
    r2 = CPU.lslT(r2, r6);
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return 0;
    }
    r4 = CPU.movT(0, 0x84);
    r4 = CPU.lslT(r4, 1);
    r3 = CPU.addT(r1, r4);
    r3 = MEMORY.ref(4, r0 + r3).get();
    r3 = CPU.andT(r3, r2);
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      return r0;
    }
    CPU.cmpT(r7, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x1);
    }

    //LAB_807a24a
    r0 = FUN_8077330(r0);
    r2 = CPU.movT(0, 0x84);
    r3 = CPU.addT(r0, 0x0);
    r2 = CPU.lslT(r2, 1);
    r1 = CPU.addT(r3, 0x0);
    r3 = CPU.addT(r3, r2);
    r3 = MEMORY.ref(4, r3).get();
    r4 = CPU.movT(0, 0x0);
    r1 = CPU.addT(r1, 0x8);
    r4 = CPU.cmpT(r4, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = MEMORY.ref(1, r1).getUnsigned();
      if(r5 != r3 || r6 != MEMORY.ref(1, r1 + 0x1).getUnsigned()) {
        //LAB_807a26e
        do {
          r2 = CPU.movT(0, 0x80);
          r2 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r1, r2);
          r3 = MEMORY.ref(4, r3).get();
          r4 = CPU.addT(r4, 0x1);
          r4 = CPU.cmpT(r4, r3);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            break;
          }
          r2 = CPU.lslT(r4, 2);
          r3 = MEMORY.ref(1, r1 + r2).getUnsigned();
        } while(r5 != r3 || r6 != MEMORY.ref(1, r1 + r2 + 0x1).getUnsigned());
      }
    }

    //LAB_807a28c
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r1, r2);
    r3 = MEMORY.ref(4, r3).get();
    if(r4 == r3) {
      return 1;
    }
    r3 = MEMORY.ref(1, r1 + r4 * 0x4 + 0x3).get();
    if(r3 <= 0 && r3 != -2) {
      //LAB_807a2ae
      r0 = 1;
    } else {
      //LAB_807a2b2
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_807a2b4
    return r0;
  }

  @Method(0x807a2e4)
  public static int FUN_807a2e4(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r1, 0x0);
    CPU.r8().value = r2;
    r0 = FUN_8077394(r0);
    r1 = CPU.addT(r6, 0x0);
    r5 = CPU.addT(r0, 0x0);
    r2 = CPU.r8().value;
    r0 = CPU.addT(r7, 0x0);
    r0 = FUN_807a1f8(r0, r1, r2);
    CPU.r10().value = r0;
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.lslT(r6, 2);
      r3 = CPU.addT(r2, 0x0);
      r3 = CPU.addT(r3, 0xf8);
      r1 = CPU.movT(0, 0x1);
      r0 = CPU.r8().value;
      r3 = MEMORY.ref(4, r5 + r3).get();
      r1 = CPU.lslT(r1, r0);
      r3 = CPU.andT(r3, r1);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0x84);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r2, r3);
        r3 = MEMORY.ref(4, r5 + r2).get();
        r3 = CPU.orrT(r3, r1);
        MEMORY.ref(4, r5 + r2).setu(r3);
        r0 = CPU.movT(0, 0x8e);
        r0 = CPU.lslT(r0, 1);
        r2 = CPU.addT(r6, r0);
        r3 = MEMORY.ref(1, r5 + r2).getUnsigned();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(1, r5 + r2).setu(r3);
        r0 = CPU.addT(r7, 0x0);
        FUN_8079ae8(r0);
        r0 = CPU.r10().value;
      } else {
        //LAB_807a32a
        r0 = CPU.movT(0, 0x0);
      }
    } else {
      //LAB_807a340
      r0 = CPU.r10().value;
    }

    //LAB_807a342
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0;
  }

  @Method(0x807a3a8)
  public static int FUN_807a3a8(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;
    final int r8;
    int r9;
    final int r10;
    final int r12;
    final int lr;

    r8 = r1;
    r1 = CPU.movT(0, 0x0);
    r10 = r2;
    r9 = r1;
    r3 = CPU.movT(0, 0x0);
    CPU.cmpT(r0, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r3 = CPU.movT(0, 0x1);
    }

    //LAB_807a3c2
    r0 = CPU.addT(r3, 0x0);
    r0 = FUN_8077330(r0);
    r1 = CPU.movT(0, 0x84);
    r3 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r2 = CPU.movT(0, 0x8);
    r2 = CPU.addT(r2, r3);
    r7 = CPU.addT(r3, r1);
    r12 = r2;
    r2 = MEMORY.ref(4, r7).get();
    r4 = CPU.movT(0, 0x0);
    r0 = CPU.addT(r0, 0x9);
    r5 = CPU.movT(0, 0x0);
    r1 = r12;
    CPU.cmpT(r9, r2);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = MEMORY.ref(1, r1).getUnsigned();
      lr = r3;
      r6 = r9;
      if(r8 == lr && r10 == MEMORY.ref(1, r0).getUnsigned()) {
        r3 = CPU.subT(r2, 0x1);
        r1 = CPU.movT(0, 0x1);
        MEMORY.ref(4, r7).setu(r3);
        r9 = r1;
      } else {
        //LAB_807a3fe
        do {
          r2 = MEMORY.ref(4, r7).get();
          r4 = CPU.addT(r4, 0x1);
          r0 = CPU.addT(r0, 0x4);
          r1 = CPU.addT(r1, 0x4);
          r5 = CPU.addT(r5, 0x4);
          r4 = CPU.cmpT(r4, r2);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            return r9;
          }
          r3 = MEMORY.ref(1, r1).getUnsigned();
          r6 = CPU.addT(r5, 0x0);
        } while(r8 != r3 || r10 != MEMORY.ref(1, r0).getUnsigned());

        r3 = CPU.subT(r2, 0x1);
        MEMORY.ref(4, r7).setu(r3);
        r2 = CPU.movT(0, 0x1);
        r9 = r2;
      }

      //LAB_807a422
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 1);
      r3 += r12;
      r3 = MEMORY.ref(4, r3).get();
      r4 = CPU.cmpT(r4, r3);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x80);
        r2 = CPU.lslT(r2, 1);
        r2 += r12;
        r1 = r12;
        r3 = CPU.addT(r6, 0x4);
        r3 = MEMORY.ref(4, r1 + r3).get();
        MEMORY.ref(4, r1 + r6).setu(r3);
        r3 = MEMORY.ref(4, r2).get();
        r4 = CPU.addT(r4, 0x1);
        r4 = CPU.cmpT(r4, r3);

        //LAB_807a436
        //LAB_807a438
        while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r6 = CPU.lslT(r4, 2);
          r1 = r12;
          r3 = CPU.addT(r6, 0x4);
          r3 = MEMORY.ref(4, r1 + r3).get();
          MEMORY.ref(4, r1 + r6).setu(r3);
          r3 = MEMORY.ref(4, r2).get();
          r4 = CPU.addT(r4, 0x1);
          r4 = CPU.cmpT(r4, r3);
        }
      }
    }

    //LAB_807a448
    return r9;
  }
}
