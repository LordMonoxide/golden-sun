package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun_807.FUN_8077000;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_807.FUN_8077010;
import static org.goldensun.GoldenSun_807.FUN_80771b0;
import static org.goldensun.GoldenSun_807.FUN_80771c0;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  @Method(0x80b0020)
  public static void FUN_80b0020(final int r0) {
    MEMORY.call(0x80b08b8, r0);
  }

  @Method(0x80b0028)
  public static void FUN_80b0028(final int r0) {
    MEMORY.call(0x80b0958, r0);
  }

  @Method(0x80b0030)
  public static void FUN_80b0030(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80b09fc, r0, r1, r2, r3);
  }

  @Method(0x80b0038)
  public static void FUN_80b0038(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b0a20, r0, r1, r2);
  }

  @Method(0x80b08b8)
  public static void FUN_80b08b8(int r0) {
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

    r7 = CPU.addT(r0, 0x0);
    CPU.cmpT(r7, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xd);
      r1 = MEMORY.ref(1, r7 + r1).get();
      CPU.r10().value = r1;
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, r7).get();
        r6 = MEMORY.ref(1, r7 + 0xc).getUnsigned();
        CPU.r8().value = r2;
        r6 = CPU.addT(r6, 0x1);
        r1 = CPU.movT(0, 0x4);
        r2 = MEMORY.ref(2, r7 + r1).get();
        r1 = CPU.movT(0, 0x8);
        r3 = MEMORY.ref(2, r7 + r1).get();
        MEMORY.ref(1, r7 + 0xc).setu(r6);
        r6 = CPU.lslT(r6, 24);
        r3 = CPU.subT(r3, r2);
        r6 = CPU.asrT(r6, 24);
        r0 = CPU.addT(r6, 0x0);
        r0 = CPU.mulT(r0, r3);
        r1 = CPU.r10().value;
        r0 = divideS(r0, r1);
        r5 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
        r3 = CPU.r8().value;
        r5 = CPU.addT(r5, r0);
        MEMORY.ref(2, r3 + 0x6).setu(r5);
        r2 = MEMORY.ref(4, 0x80b0934).get();
        r3 = MEMORY.ref(4, 0x80b0938).get();
        r1 = CPU.r8().value;
        r5 = CPU.andT(r5, r3);
        CPU.r9().value = r2;
        r3 = MEMORY.ref(4, 0x80b093c).get();
        r2 = MEMORY.ref(2, r1 + 0x16).getUnsigned();
        r3 = CPU.andT(r3, r2);
        r3 = CPU.orrT(r3, r5);
        r2 = CPU.r8().value;
        MEMORY.ref(2, r2 + 0x16).setu(r3);
        r1 = CPU.movT(0, 0x6);
        r2 = MEMORY.ref(2, r7 + r1).get();
        r1 = CPU.movT(0, 0xa);
        r3 = MEMORY.ref(2, r7 + r1).get();
        r3 = CPU.subT(r3, r2);
        r0 = CPU.addT(r6, 0x0);
        r0 = CPU.mulT(r0, r3);
        r1 = CPU.r10().value;
        r0 = divideS(r0, r1);
        r5 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
        r2 = CPU.r8().value;
        r5 = CPU.addT(r5, r0);
        MEMORY.ref(2, r2 + 0x8).setu(r5);
        MEMORY.ref(1, r2 + 0x14).setu(r5);
        CPU.cmpT(r6, CPU.r10().value);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.r9().value;
          MEMORY.ref(1, r7 + 0xd).setu(r3);
          MEMORY.ref(1, r7 + 0xc).setu(r3);
        }
      }
    }

    //LAB_80b094a
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x80b0958)
  public static void FUN_80b0958(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;

    r5 = CPU.addT(r0, 0x0);
    r4 = MEMORY.ref(4, r5).get();
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x8);
      r3 = MEMORY.ref(2, r5 + r1).get();
      r2 = MEMORY.ref(2, r4 + 0x6).getUnsigned();
      r0 = CPU.subT(r2, r3);
      r3 = CPU.addT(r0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.addT(r0, 0x3);
      }

      //LAB_80b0972
      r3 = CPU.asrT(r3, 2);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.negT(r3, r3);
      }

      //LAB_80b097a
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.subT(r2, r3);
        } else {
          //LAB_80b0986
          r1 = MEMORY.ref(4, 0x80b09f0).get();
          r3 = CPU.addT(r2, r1);
        }
        MEMORY.ref(2, r4 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r4 + 0x6).getUnsigned();
        r2 = MEMORY.ref(4, 0x80b09f4).get();
        r1 = MEMORY.ref(2, r4 + 0x16).getUnsigned();
        r2 = CPU.andT(r2, r3);
        r3 = MEMORY.ref(4, 0x80b09f8).get();
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r4 + 0x16).setu(r3);
      } else {
        //LAB_80b098c
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.addT(r2, r3);
          } else {
            //LAB_80b0998
            r3 = CPU.addT(r2, 0x1);
          }

          //LAB_80b099a
          MEMORY.ref(2, r4 + 0x6).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x6).getUnsigned();
          r2 = MEMORY.ref(4, 0x80b09f4).get();
          r1 = MEMORY.ref(2, r4 + 0x16).getUnsigned();
          r2 = CPU.andT(r2, r3);
          r3 = MEMORY.ref(4, 0x80b09f8).get();
          r3 = CPU.andT(r3, r1);
          r3 = CPU.orrT(r3, r2);
          MEMORY.ref(2, r4 + 0x16).setu(r3);
        }
      }

      //LAB_80b09ac
      r1 = CPU.movT(0, 0xa);
      r3 = MEMORY.ref(2, r5 + r1).get();
      r2 = MEMORY.ref(2, r4 + 0x8).getUnsigned();
      r0 = CPU.subT(r2, r3);
      r3 = CPU.addT(r0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.addT(r0, 0x3);
      }

      //LAB_80b09bc
      r3 = CPU.asrT(r3, 2);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.negT(r3, r3);
      }

      //LAB_80b09c4
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.subT(r2, r3);
        } else {
          //LAB_80b09d0
          r1 = MEMORY.ref(4, 0x80b09f0).get();
          r3 = CPU.addT(r2, r1);
        }
        MEMORY.ref(2, r4 + 0x8).setu(r3);
        r3 = MEMORY.ref(2, r4 + 0x8).getUnsigned();
        MEMORY.ref(1, r4 + 0x14).setu(r3);
      } else {
        //LAB_80b09d6
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.addT(r2, r3);
          } else {
            //LAB_80b09e2
            r3 = CPU.addT(r2, 0x1);
          }

          //LAB_80b09e4
          MEMORY.ref(2, r4 + 0x8).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x8).getUnsigned();
          MEMORY.ref(1, r4 + 0x14).setu(r3);
        }
      }
    }

    //LAB_80b09ea
  }

  @Method(0x80b09fc)
  public static void FUN_80b09fc(final int r0, final int r1, final int r2, final int r3) {
    final int r5 = MEMORY.ref(4, r0).get();
    int r4 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
    final int r6 = MEMORY.ref(4, 0x80b0a14).get();
    MEMORY.ref(2, r0 + 0x4).setu(r4);
    r4 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0x6).setu(r4);
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(1, r0 + 0xd).setu(r3);
    MEMORY.ref(1, r0 + 0xc).setu(r6);
  }

  @Method(0x80b0a20)
  public static void FUN_80b0a20(final int r0, final int r1, final int r2) {
    final int r5 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r5 + 0x6).setu(r1);
    MEMORY.ref(2, r5 + 0x8).setu(r2);
    MEMORY.ref(1, r5 + 0x14).setu(r2 & 0xffff);
    MEMORY.ref(2, r5 + 0x16).and(0xfffffe00).oru(r1 & 0x1ff);
    MEMORY.ref(1, r0 + 0xd).setu(0x1);
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0x4).setu(r1);
    MEMORY.ref(1, r0 + 0xc).setu(0);
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(2, r0 + 0x6).setu(r2);
  }

  @Method(0x80b50a0)
  public static int FUN_80b50a0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun_80b#FUN_80bf5a8} */
  @Method(0x80b50f8)
  public static int FUN_80b50f8() {
    return (int)MEMORY.call(0x80bf5a8);
  }

  @Method(0x80bf5a8)
  public static int FUN_80bf5a8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x4;

    r0 = CPU.movT(0, 0x0);
    r0 = FUN_8077000(r0);
    r1 = CPU.movT(0, 0x84);
    r3 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r7 = CPU.addT(r3, 0x0);
    r3 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.movT(0, 0x0);
    r7 = CPU.addT(r7, 0x8);
    CPU.r8().value = r2;
    r2 = CPU.cmpT(r2, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r5 = CPU.addT(r7, 0x0);

      //LAB_80bf5ce
      do {
        r3 = CPU.movT(0, 0x3);
        r3 = MEMORY.ref(1, r5 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r0 = MEMORY.ref(1, r5 + 0x2).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r2);
          r0 = FUN_8077008(r0);
          r1 = CPU.movT(0, 0x38);
          r3 = MEMORY.ref(2, r0 + r1).get();
          r2 = MEMORY.ref(4, CPU.sp().value).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(1, r5 + 0x3).getUnsigned();
            r3 = CPU.subT(r3, 0x1);
            MEMORY.ref(1, r5 + 0x3).setu(r3);
          }
        }

        //LAB_80bf5ee
        r1 = CPU.movT(0, 0x80);
        r3 = CPU.movT(0, 0x1);
        r1 = CPU.lslT(r1, 1);
        CPU.r8().value += r3;
        r3 = CPU.addT(r7, r1);
        r3 = MEMORY.ref(4, r3).get();
        r5 = CPU.addT(r5, 0x4);
        CPU.cmpT(CPU.r8().value, r3);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_80bf600
    r1 = CPU.movT(0, 0x80);
    r3 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 1);
    CPU.r8().value = r3;
    r3 = CPU.addT(r7, r1);
    r3 = MEMORY.ref(4, r3).get();
    CPU.cmpT(CPU.r8().value, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r6 = CPU.addT(r7, 0x0);

      //LAB_80bf612
      do {
        r3 = CPU.movT(0, 0x3);
        r3 = MEMORY.ref(1, r6 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r5 = MEMORY.ref(1, r6 + 0x2).getUnsigned();
          r1 = MEMORY.ref(1, r6).getUnsigned();
          r2 = MEMORY.ref(1, r6 + 0x1).getUnsigned();
          r0 = CPU.addT(r5, 0x0);
          FUN_80771b0(r0, r1, r2);
          r2 = MEMORY.ref(1, r6 + 0x1).getUnsigned();
          r1 = MEMORY.ref(1, r6).getUnsigned();
          r0 = CPU.addT(r5, 0x0);
          FUN_80771c0(r0, r1, r2);
          r0 = CPU.addT(r5, 0x0);
          FUN_8077010(r0);
          r2 = CPU.movT(0, 0x1);
        } else {
          //LAB_80bf63a
          r3 = CPU.movT(0, 0x1);
          r6 = CPU.addT(r6, 0x4);
          CPU.r8().value += r3;
        }

        //LAB_80bf640
        r1 = CPU.movT(0, 0x80);
        r1 = CPU.lslT(r1, 1);
        r3 = CPU.addT(r7, r1);
        r3 = MEMORY.ref(4, r3).get();
        CPU.cmpT(CPU.r8().value, r3);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_80bf64c
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();

    return r2;
  }
}
