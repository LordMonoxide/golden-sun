package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_80022fc;
import static org.goldensun.GoldenSun.FUN_8002304;
import static org.goldensun.GoldenSun.FUN_800231c;
import static org.goldensun.GoldenSun.FUN_8002322;
import static org.goldensun.GoldenSun.FUN_8002dd8;
import static org.goldensun.GoldenSun.FUN_8002df0;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003d28;
import static org.goldensun.GoldenSun.FUN_8003dec;
import static org.goldensun.GoldenSun.FUN_8003f3c;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.FUN_80041d8;
import static org.goldensun.GoldenSun.FUN_8004458;
import static org.goldensun.GoldenSun.FUN_80048b0;
import static org.goldensun.GoldenSun.FUN_80048f4;
import static org.goldensun.GoldenSun.FUN_8004938;
import static org.goldensun.GoldenSun.FUN_8004970;
import static org.goldensun.GoldenSun.FUN_80056cc;
import static org.goldensun.GoldenSun.FUN_8005c68;
import static org.goldensun.GoldenSun.FUN_8005cf8;
import static org.goldensun.GoldenSun.FUN_800fec8;
import static org.goldensun.GoldenSun.FUN_800ff54;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_801 {
  private GoldenSun_801() { }

  @Method(0x8010000)
  public static void FUN_8010000() {
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

    r3 = MEMORY.ref(4, 0x8010210).get();
    r3 = MEMORY.ref(4, r3).get();
    r4 = CPU.movT(0, 0x82);
    r1 = MEMORY.ref(4, r3).get();
    CPU.r8().value = r3;
    r4 = CPU.lslT(r4, 1);
    CPU.sp().value -= 0x8;
    r4 += CPU.r8().value;
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8010024
      r3 = MEMORY.ref(4, r1).get();
      r1 += 0x4;

      r2 = MEMORY.ref(4, 0x8010214).get();
      r7 = CPU.addT(r3, r2);
      r2 = MEMORY.ref(4, r1).get();
      r1 += 0x4;

      r3 = MEMORY.ref(4, r1).get();
      r1 = MEMORY.ref(4, 0x8010218).get();
      r3 = CPU.subT(r3, r2);
      r6 = CPU.addT(r3, r1);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xec);
      r2 = CPU.r8().value;
      r2 = MEMORY.ref(4, r2 + 0x4).get();
      r3 = MEMORY.ref(4, r3).get();
      r0 = CPU.addT(r3, r2);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf4);
      r3 = MEMORY.ref(4, r3).get();
      CPU.r12().value = r2;
      r3 = CPU.subT(r3, r2);
      r2 = MEMORY.ref(4, 0x801021c).get();
      r1 = CPU.addT(r3, r2);
      r3 = CPU.r8().value;
      r2 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf0);
      r5 = MEMORY.ref(4, r2 + 0x8).get();
      r3 = MEMORY.ref(4, r3).get();
      r3 = CPU.addT(r3, r5);
      CPU.lr().value = r3;
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf8);
      r3 = MEMORY.ref(4, r3).get();
      r2 = MEMORY.ref(4, 0x8010220).get();
      r3 = CPU.subT(r3, r5);
      r3 = CPU.addT(r3, r2);
      r0 = CPU.cmpT(r0, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r1 = CPU.addT(r0, 0x0);
      }

      //LAB_801006e
      CPU.cmpT(CPU.lr().value, r3);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.lr().value;
      }

      //LAB_8010074
      r7 = CPU.cmpT(r7, r0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r7 = CPU.addT(r0, 0x0);
      }

      //LAB_801007a
      r7 = CPU.cmpT(r7, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r7 = CPU.addT(r1, 0x0);
      }

      //LAB_8010080
      CPU.cmpT(r6, CPU.lr().value);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r6 = CPU.lr().value;
      }

      //LAB_8010086
      r6 = CPU.cmpT(r6, r3);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r6 = CPU.addT(r3, 0x0);
      }

      //LAB_801008c
      r3 = CPU.r12().value;
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_8004458();
        r5 = CPU.addT(r0, 0x0);
        r0 = FUN_8004458();
        r2 = CPU.r8().value;
        r2 = MEMORY.ref(4, r2 + 0x4).get();
        r1 = CPU.addT(r0, 0x0);
        CPU.lr().value = r2;
        r0 = CPU.lr().value;
        r1 = CPU.subT(r5, r1);
        CPU.r12().value = 0x80100b0;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = CPU.r8().value;
        r7 = CPU.addT(r7, r0);
        r1 = MEMORY.ref(4, r2 + 0xc).get();
        r0 = CPU.lr().value;
        CPU.r12().value = 0x80100bc;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r8().value;
        MEMORY.ref(4, r3 + 0x4).setu(r0);
        r5 = MEMORY.ref(4, r3 + 0x8).get();
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100c4
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_8004458();
        r5 = CPU.addT(r0, 0x0);
        r0 = FUN_8004458();
        r2 = CPU.r8().value;
        r2 = MEMORY.ref(4, r2 + 0x8).get();
        r1 = CPU.addT(r0, 0x0);
        CPU.lr().value = r2;
        r0 = CPU.lr().value;
        r1 = CPU.subT(r5, r1);
        r0 = CPU.lslT(r0, 0);
        CPU.r12().value = 0x80100e8;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = CPU.r8().value;
        r6 = CPU.addT(r6, r0);
        r1 = MEMORY.ref(4, r2 + 0xc).get();
        r0 = CPU.lr().value;
        CPU.r12().value = 0x80100f4;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r8().value;
        MEMORY.ref(4, r3 + 0x8).setu(r0);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100fa
      r1 = CPU.r8().value;
      r1 = CPU.addT(r1, 0xe4);
      r2 = CPU.movT(0, 0xe8);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
      r2 += CPU.r8().value;
      MEMORY.ref(4, r1).setu(r7);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r2).setu(r6);
      CPU.r11().value = r2;
      CPU.r10().value = r3;

      //LAB_8010112
      do {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r1 = MEMORY.ref(4, r4 + 0x10).get();
        r0 = MEMORY.ref(4, r2).get();
        CPU.r12().value = 0x801011c;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r11().value;
        r7 = CPU.addT(r0, 0x0);
        r1 = MEMORY.ref(4, r4 + 0x14).get();
        r0 = MEMORY.ref(4, r3).get();
        CPU.r12().value = 0x8010128;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = MEMORY.ref(4, r4 + 0x18).get();
        r6 = CPU.addT(r0, 0x0);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r4 + 0x20).get();
          r3 = CPU.addT(r3, r2);
          r7 = CPU.addT(r7, r3);
          MEMORY.ref(4, r4 + 0x20).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x28).getUnsigned();
          r2 = MEMORY.ref(4, 0x8010228).get();
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, r2);
          r7 = CPU.andT(r7, r3);
        }

        //LAB_8010142
        r2 = MEMORY.ref(4, r4 + 0x1c).get();
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r4 + 0x24).get();
          r3 = CPU.addT(r3, r2);
          r6 = CPU.addT(r6, r3);
          MEMORY.ref(4, r4 + 0x24).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x2a).getUnsigned();
          r2 = MEMORY.ref(4, 0x8010228).get();
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, r2);
          r6 = CPU.andT(r6, r3);
        }

        //LAB_801015a
        r3 = MEMORY.ref(4, r4 + 0x8).get();
        r7 = CPU.addT(r7, r3);
        r3 = MEMORY.ref(4, r4 + 0xc).get();
        r1 = CPU.addT(r7, 0x0);
        r6 = CPU.addT(r6, r3);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x8010228).get();
          r1 = CPU.addT(r7, r2);
        }

        //LAB_801016c
        r1 = CPU.asrT(r1, 19);
        CPU.r8().value = r1;
        r2 = CPU.addT(r6, 0x0);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x8010228).get();
          r2 = CPU.addT(r6, r3);
        }

        //LAB_801017a
        r1 = MEMORY.ref(4, r4).get();
        r5 = CPU.asrT(r2, 19);
        r3 = CPU.addT(r1, 0x0);
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.eorT(r3, r7);
        r2 = CPU.lslT(r2, 12);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.cmpT(r1, r7);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = CPU.r8().value;
            r1 = CPU.addT(r1, 0x1e);
            r0 = CPU.r10().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          } else {
            //LAB_801019c
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          }

          //LAB_80101a4
          FUN_800ff54(r0, r1, r2);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80101aa
        r1 = MEMORY.ref(4, r4 + 0x4).get();
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.eorT(r3, r6);
        r2 = CPU.lslT(r2, 13);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.cmpT(r1, r6);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r2 = CPU.addT(r5, 0x0);
            r2 = CPU.addT(r2, 0x14);
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          } else {
            //LAB_80101ca
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          }

          //LAB_80101d2
          FUN_800fec8(r0, r1, r2);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80101d8
        r1 = CPU.r10().value;
        r3 = CPU.movT(0, 0x3);
        r3 = CPU.subT(r3, r1);
        r1 = MEMORY.ref(4, 0x801022c).get();
        r3 = CPU.lslT(r3, 2);
        r2 = CPU.asrT(r7, 16);
        MEMORY.ref(2, r1 + r3).setu(r2);
        r2 = CPU.asrT(r6, 16);
        r3 = CPU.addT(r3, r1);
        MEMORY.ref(2, r3 + 0x2).setu(r2);
        r2 = CPU.movT(0, 0x1);
        CPU.r10().value += r2;
        r3 = CPU.r10().value;
        MEMORY.ref(4, r4).setu(r7);
        MEMORY.ref(4, r4 + 0x4).setu(r6);
        r4 = CPU.addT(r4, 0x30);
        CPU.cmpT(r3, 0x2);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
      } while(true);
    }

    //LAB_80101fe
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

  @Method(0x8010230)
  public static void FUN_8010230(int r0, int r1) {
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

    r3 = MEMORY.ref(4, 0x80103f8).get();
    r7 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.addT(r1, 0x0);
    r1 = CPU.movT(0, 0x82);
    CPU.sp().value -= 0x20;
    r1 = CPU.lslT(r1, 1);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r3 = CPU.addT(r3, r1);
    CPU.lr().value = r3;
    r3 = MEMORY.ref(4, 0x80103fc).get();
    r0 = CPU.addT(r0, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = MEMORY.ref(4, 0x8010400).get();
    r3 = CPU.addT(r3, 0xec);
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r7, r2);
    r7 = CPU.cmpT(r7, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.addT(r3, 0x0);
    }

    //LAB_8010266
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf4);
    r3 = MEMORY.ref(4, r3).get();
    r5 = MEMORY.ref(4, 0x8010404).get();
    r3 = CPU.addT(r3, r5);
    r7 = CPU.cmpT(r7, r3);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.addT(r3, 0x0);
    }

    //LAB_8010276
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf0);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = CPU.addT(r3, 0x0);
    }

    //LAB_8010282
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf8);
    r3 = MEMORY.ref(4, r3).get();
    r1 = MEMORY.ref(4, 0x8010408).get();
    r3 = CPU.addT(r3, r1);
    r0 = CPU.cmpT(r0, r3);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.addT(r3, 0x0);
    }

    //LAB_8010292
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = CPU.addT(r2, 0xe4);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    MEMORY.ref(4, r2).setu(r7);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r5 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r3, 0xe8);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, r3).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5);

    //LAB_80102a6
    do {
      r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 1);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r3 = CPU.addT(r1, r2);
      r3 = MEMORY.ref(1, r5 + r3).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        break;
      }

      //LAB_80102b8
      r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r2 = CPU.lr().value;
      r0 = MEMORY.ref(4, r1).get();
      r4 = CPU.movT(0, 0x16);
      r1 = MEMORY.ref(4, r2 + 0x10).get();
      CPU.r12().value = 0x80102c8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r5 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r2 = CPU.lr().value;
      r7 = CPU.addT(r0, 0x0);
      r1 = MEMORY.ref(4, r2 + 0x14).get();
      r0 = MEMORY.ref(4, r5).get();
      r0 = CPU.lslT(r0, 0);
      CPU.r12().value = 0x80102d8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r3 = CPU.lr().value;
      r2 = MEMORY.ref(4, r3 + 0x18).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x20).get();
        r5 = CPU.lr().value;
        r3 = CPU.addT(r3, r2);
        r7 = CPU.addT(r7, r3);
        MEMORY.ref(4, r5 + 0x20).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x28).getUnsigned();
        r1 = MEMORY.ref(4, 0x8010410).get();
        r3 = CPU.lslT(r3, 19);
        r3 = CPU.orrT(r3, r1);
        r7 = CPU.andT(r7, r3);
      }

      //LAB_80102f4
      r3 = CPU.lr().value;
      r2 = MEMORY.ref(4, r3 + 0x1c).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x24).get();
        r5 = CPU.lr().value;
        r3 = CPU.addT(r3, r2);
        r0 = CPU.addT(r0, r3);
        MEMORY.ref(4, r5 + 0x24).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x2a).getUnsigned();
        r1 = MEMORY.ref(4, 0x8010410).get();
        r3 = CPU.lslT(r3, 19);
        r3 = CPU.orrT(r3, r1);
        r0 = CPU.andT(r0, r3);
        r4 = CPU.movT(0, 0x20);
      }

      //LAB_8010312
      r2 = CPU.lr().value;
      r3 = MEMORY.ref(4, r2 + 0x8).get();
      r7 = CPU.addT(r7, r3);
      r3 = MEMORY.ref(4, r2 + 0xc).get();
      r0 = CPU.addT(r0, r3);
      r3 = CPU.movT(0, 0x30);
      CPU.lr().value += r3;
      r1 = CPU.addT(r7, 0x0);
      CPU.cmpT(r7, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r5 = MEMORY.ref(4, 0x8010410).get();
        r1 = CPU.addT(r7, r5);
      }

      //LAB_801032a
      r7 = CPU.asrT(r1, 19);
      r2 = CPU.addT(r0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8010410).get();
        r2 = CPU.addT(r0, r3);
      }

      //LAB_8010336
      r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = CPU.lslT(r5, 11);
      r5 = MEMORY.ref(4, 0x8010414).get();
      r0 = CPU.asrT(r2, 19);
      r5 = CPU.addT(r3, r5);
      r3 = CPU.lsrT(r2, 31);
      r3 = CPU.addT(r0, r3);
      r2 = CPU.movT(0, 0x7f);
      r3 = CPU.asrT(r3, 1);
      r3 = CPU.andT(r3, r2);
      r6 = CPU.lslT(r3, 7);
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.movT(0, 0x1e);
      r4 = CPU.lsrT(r4, 1);
      r3 = CPU.andT(r3, r0);
      CPU.r8().value = r2;
      CPU.r11().value = r4;
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);
      r5 = CPU.lslT(r3, 5);
      CPU.cmpT(CPU.r8().value, CPU.r11().value);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r3 = CPU.lsrT(r1, 31);
        r3 = CPU.addT(r7, r3);
        r3 = CPU.asrT(r3, 1);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        r1 = CPU.movT(0, 0x1e);
        r3 = CPU.movT(0, 0x7f);
        CPU.r9().value = r3;
        CPU.r10().value = r1;

        //LAB_8010370
        do {
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = CPU.r9().value;
          r0 = CPU.addT(r7, 0x0);
          r3 = CPU.r10().value;
          r1 = CPU.movT(0, 0x0);
          r4 = CPU.andT(r4, r2);
          r0 = CPU.andT(r0, r3);
          CPU.r12().value = r1;

          //LAB_8010380
          do {
            r3 = CPU.addT(r6, r4);
            r2 = MEMORY.ref(4, 0x8010418).get();
            r3 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r3, r2);
            r1 = MEMORY.ref(4, r3).get();
            r2 = MEMORY.ref(4, 0x801041c).get();
            r1 = CPU.lslT(r1, 20);
            r1 = CPU.lsrT(r1, 17);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            r3 = CPU.addT(r1, r2);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r2 = CPU.addT(r5, r0);
            r2 = CPU.lslT(r2, 1);
            r2 = CPU.addT(r2, r1);
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r3 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, r2).setu(r3);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r1 = MEMORY.ref(4, 0x8010420).get();
            r3 = CPU.addT(r2, r1);
            r3 = MEMORY.ref(4, r3).get();
            r2 = MEMORY.ref(4, CPU.sp().value).get();
            MEMORY.ref(4, r2 + 0x40).setu(r3);
            r2 = CPU.movT(0, 0x1);
            r3 = CPU.r9().value;
            r4 = CPU.addT(r4, 0x1);
            CPU.r12().value += r2;
            r4 = CPU.andT(r4, r3);
            r0 = CPU.addT(r0, 0x2);
            r1 = CPU.r10().value;
            r3 = CPU.r12().value;
            r0 = CPU.andT(r0, r1);
            CPU.cmpT(r3, 0xf);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

          r3 = CPU.movT(0, 0xfe);
          r3 = CPU.lslT(r3, 6);
          r6 = CPU.addT(r6, 0x80);
          r6 = CPU.andT(r6, r3);
          r3 = CPU.movT(0, 0xf0);
          r5 = CPU.addT(r5, 0x40);
          r3 = CPU.lslT(r3, 2);
          CPU.r8().value += r2;
          r5 = CPU.andT(r5, r3);
          CPU.cmpT(CPU.r8().value, CPU.r11().value);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      }

      //LAB_80103da
      r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = CPU.addT(r5, 0x1);
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5);
      CPU.cmpT(r5, 0x2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        break;
      }
    } while(true);

    //LAB_80103e6
    CPU.sp().value += 0x20;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x80118d8)
  public static void FUN_80118d8(int r0) {
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

    r3 = MEMORY.ref(4, 0x8011970).get();
    r5 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    r4 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.sp().value;
    r1 = CPU.addT(r5, 0x0);
    MEMORY.ref(4, r0).setu(r6);
    r1 = CPU.addT(r1, 0x18);
    r2 = MEMORY.ref(4, 0x8011978).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r1 = MEMORY.ref(2, r4).getUnsigned();
    r2 = MEMORY.ref(4, 0x801197c).get();
    r4 = CPU.addT(r4, 0x2);
    r1 = CPU.cmpT(r1, r2);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xff);
      r2 = CPU.movT(0, 0xfd);
      r3 = CPU.lslT(r3, 8);
      r2 = CPU.lslT(r2, 8);
      CPU.r10().value = r3;
      CPU.r8().value = r2;
      r3 = CPU.movT(0, 0xf);
      r2 = CPU.movT(0, 0x80);
      CPU.lr().value = r3;
      CPU.r12().value = r2;
      r7 = CPU.movT(0, 0x0);

      //LAB_801191a
      do {
        r3 = CPU.addT(r1, 0x0);
        r2 = CPU.r10().value;
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, CPU.r8().value);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.lr().value;
          r2 = CPU.addT(r1, 0x0);
          r2 = CPU.andT(r2, r3);
          r3 = CPU.r12().value;
          r3 = CPU.andT(r3, r1);
          r0 = CPU.movT(0, 0x0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.movT(0, 0x1);
          }

          //LAB_8011936
          r3 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          r3 = CPU.addT(r5, r3);
          r3 = CPU.addT(r3, 0x18);
          MEMORY.ref(4, r3).setu(r4);
          MEMORY.ref(4, r3 + 0x4).setu(r4);
          MEMORY.ref(2, r3 + 0x8).setu(r7);
          MEMORY.ref(2, r3 + 0xa).setu(r0);
          r6 = CPU.addT(r6, 0x1);
        }

        //LAB_801194a
        r1 = MEMORY.ref(2, r4).getUnsigned();
        r2 = MEMORY.ref(4, 0x801197c).get();
        r4 = CPU.addT(r4, 0x2);
        r1 = CPU.cmpT(r1, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8011954
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r0 = MEMORY.ref(4, 0x8011980).get();
      r1 = CPU.lslT(r1, 4);
      r0 = FUN_80041d8(r0, r1);
    }

    //LAB_8011962
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8011a84)
  public static void FUN_8011a84(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;

    r3 = MEMORY.ref(4, 0x8011acc).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    r4 = CPU.addT(r3, 0x0);
    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.sp().value;
    r4 = CPU.addT(r4, 0xd8);
    MEMORY.ref(4, r0).setu(r6);
    r2 = MEMORY.ref(4, 0x8011ad4).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(r2);

    r3 = MEMORY.ref(2, r5).getUnsigned();
    r2 = MEMORY.ref(4, 0x8011ad8).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      MEMORY.ref(4, r4).setu(r5);
      MEMORY.ref(4, r4 + 0x4).setu(r5);
      MEMORY.ref(2, r4 + 0x8).setu(r6);
      MEMORY.ref(2, r4 + 0xa).setu(r6);
      r6 = CPU.movT(0, 0x1);
    }

    //LAB_8011ab4
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r0 = MEMORY.ref(4, 0x8011adc).get();
      r1 = CPU.lslT(r1, 4);
      r0 = FUN_80041d8(r0, r1);
    }

    //LAB_8011ac2
    CPU.sp().value += 0x4;
  }

  @Method(0x8011ce0)
  public static int FUN_8011ce0(int r0, final int r1, final int r2) {
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.lslT(r0, 24);
    r0 = CPU.asrT(r0, 24);
    r0 = CPU.lslT(r0, 19);
    return r0;
  }

  @Method(0x8011f54)
  public static int FUN_8011f54(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8011fc4).get();
    r5 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, r3).get();
    r6 = CPU.addT(r2, 0x0);
    r5 = CPU.asrT(r5, 16);
    r6 = CPU.asrT(r6, 16);
    r2 = MEMORY.ref(4, 0x8011fc8).get();
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x3);
      r2 = CPU.andT(r2, r0);
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r2 = CPU.movT(0, 0x98);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.lslT(r3, 4);
      r3 = CPU.addT(r3, r2);
      r2 = MEMORY.ref(4, r1 + r3).get();
    }

    //LAB_8011f7a
    r3 = CPU.addT(r5, 0x0);
    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0xf);
    }

    //LAB_8011f82
    r1 = CPU.asrT(r3, 4);
    r3 = CPU.addT(r6, 0x0);
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0xf);
    }

    //LAB_8011f8c
    r3 = CPU.asrT(r3, 4);
    r3 = CPU.lslT(r3, 7);
    r3 = CPU.addT(r1, r3);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r2, r3);
    r1 = MEMORY.ref(1, r2 + 0x3).getUnsigned();
    r3 = MEMORY.ref(4, 0x8011fcc).get();
    r1 = CPU.lslT(r1, 2);
    r0 = CPU.addT(r1, r3);
    r2 = CPU.movT(0, 0xf);
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r2, 0x0);
    r4 = MEMORY.ref(4, 0x8011fd0).get();
    r3 = CPU.andT(r3, r0);
    r7 = MEMORY.ref(4, 0x8011fd4).get();
    r5 = CPU.andT(r5, r2);
    r6 = CPU.andT(r6, r2);
    r3 = CPU.lslT(r3, 2);
    r0 = CPU.addT(r1, r7);
    r3 = MEMORY.ref(4, r4 + r3).get();
    r1 = CPU.addT(r5, 0x0);
    r2 = CPU.addT(r6, 0x0);
    return (int)MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x8015000)
  public static void FUN_8015000() {
    MEMORY.call(0x8015f31);
  }

  @Method(0x8015020)
  public static void FUN_8015020(final int r0, final int r1) {
    FUN_801964c(r0, r1);
  }

  @Method(0x8015040)
  public static void FUN_8015040(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015120)
  public static void FUN_8015120(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80151e8)
  public static int FUN_80151e8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015200)
  public static void FUN_8015200(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015208)
  public static void FUN_8015208() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015288)
  public static int FUN_8015288() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015290)
  public static int FUN_8015290() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015318)
  public static int FUN_8015318() {
    return (int)MEMORY.call(0x801f77d);
  }

  @Method(0x8015320)
  public static int FUN_8015320(final int r0) {
    return (int)MEMORY.call(0x8020bd8, r0);
  }

  @Method(0x8015360)
  public static void FUN_8015360(final int r0, final int r1) {
    MEMORY.call(0x801ccc0, r0, r1);
  }

  @Method(0x8015370)
  public static int FUN_8015370(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015e8c)
  public static int FUN_8015e8c() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r4;

    r3 = MEMORY.ref(4, 0x8015eb4).get();
    r2 = MEMORY.ref(4, 0x8015eb8).get();
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.addT(r3, r2);
    r0 = MEMORY.ref(4, r1).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(4, r0).get();
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r4 = MEMORY.ref(4, 0x8015ebc).get();
        r3 = CPU.addT(r3, r4);
        MEMORY.ref(4, r3).setu(r1);
      }

      //LAB_8015ea8
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r1).setu(r2);
      MEMORY.ref(4, r0).setu(r3);
    }

    //LAB_8015eae
    return r0;
  }

  @Method(0x8015ec0)
  public static void FUN_8015ec0(int r0) {
    int r1;
    int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8015eec).get();
    r1 = CPU.movT(0, 0xd3);
    r2 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 3);
    r3 = CPU.addT(r2, r1);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r1 = MEMORY.ref(4, 0x8015ef0).get();
      r3 = CPU.addT(r2, r1);
      r0 = CPU.cmpT(r0, r3);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r1 = CPU.addT(r1, 0x4);
        r3 = CPU.addT(r2, r1);
        r2 = MEMORY.ref(4, r3).get();
        MEMORY.ref(4, r3).setu(r0);
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(4, r2).setu(r0);
        MEMORY.ref(4, r0).setu(r3);
      }
    }

    //LAB_8015ee6
  }

  @Method(0x8015ef4)
  public static void FUN_8015ef4() {
    final int r0;
    int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x8015f24).get();
    r1 = CPU.movT(0, 0xd3);
    r0 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 3);
    r2 = CPU.addT(r0, r1);
    r1 = MEMORY.ref(4, 0x8015f28).get();
    r3 = CPU.addT(r0, r1);
    MEMORY.ref(4, r3).setu(r2);
    r3 = CPU.movT(0, 0x3e);

    //LAB_8015f08
    do {
      r1 = CPU.addT(r2, 0x0);
      r1 = CPU.addT(r1, 0x1c);
      r3 = CPU.subT(r3, 0x1);
      MEMORY.ref(4, r2).setu(r1);
      r2 = CPU.addT(r1, 0x0);
      CPU.cmpT(r3, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r2 = MEMORY.ref(4, 0x8015f2c).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r1).setu(r3);
    r3 = CPU.addT(r0, r2);
    MEMORY.ref(4, r3).setu(r1);
  }

  @Method(0x8015f30)
  public static void FUN_8015f30() {
    final int r0;
    int r1;
    final int r4;
    final int r5;

    CPU.sp().value -= 0x4;
    r4 = FUN_80048f4(0xf, 0x12fc);
    r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x850004bf);

    MEMORY.ref(1, r4 + 0xea3).setu(0x1);
    MEMORY.ref(2, r4 + 0x12b6).setu(0x63);
    MEMORY.ref(1, r4 + 0xea7).setu(0xf);
    MEMORY.ref(4, r5).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000140);

    FUN_8015ef4();
    FUN_8019d0c();
    r1 = CPU.movT(0, 0x90);
    r1 = CPU.lslT(r1, 3);
    r0 = MEMORY.ref(4, 0x8015fb4).get();
    FUN_80041d8(r0, r1);
    FUN_80173f4();
    CPU.sp().value += 0x4;
  }

  /** Called from interrupt handler */
  @Method(0x80160fc)
  public static void FUN_80160fc() {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8016160).get();
    r2 = MEMORY.ref(4, 0x8016164).get();
    r7 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.subT(r2, 0x3);
      r3 = CPU.addT(r7, r2);
      r4 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x8016168).get();
        CPU.r12().value = r3;
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.andT(r3, r4);
        r5 = CPU.addT(r7, 0x0);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.movT(0, 0x3f);
        }

        //LAB_8016126
        r3 = CPU.movT(0, 0x3f);
        r4 = CPU.andT(r4, r3);
        r2 = CPU.movT(0, 0x1);
        r6 = CPU.movT(0, 0x80);
        r4 = CPU.lsrT(r4, 1);
        CPU.lr().value = r2;
        r6 = CPU.lslT(r6, 1);

        //LAB_8016134
        do {
          r3 = CPU.addT(r4, 0x0);
          r2 = CPU.lr().value;
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            DMA.channels[3].SAD.setu(r5);
            DMA.channels[3].DAD.setu(CPU.r12().value);
            DMA.channels[3].CNT.setu(0x84000040);
          }

          //LAB_801614a
          r4 = CPU.lsrT(r4, 1);
          r5 = CPU.addT(r5, r6);
          CPU.r12().value += r6;
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=

        r2 = MEMORY.ref(4, 0x8016174).get();
        r3 = CPU.addT(r7, r2);
        MEMORY.ref(1, r3).setu(r4);
      }
    }

    //LAB_801615a
  }

  @Method(0x8016178)
  public static void FUN_8016178(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r7 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x8016220).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r3;
    r3 = CPU.lslT(r1, 5);
    r3 = CPU.addT(r3, r0);
    r3 = CPU.lslT(r3, 1);
    r6 = CPU.addT(r2, 0x0);
    r2 = CPU.r10().value;
    r5 = CPU.addT(r3, r2);
    r4 = CPU.movT(0, 0xf0);
    r3 = CPU.addT(r1, r7);
    CPU.sp().value -= 0x4;
    CPU.r8().value = r1;
    r4 = CPU.lslT(r4, 8);
    CPU.cmpT(r3, 0x14);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r3 = CPU.movT(0, 0x14);
      r7 = CPU.subT(r3, r1);
    }

    //LAB_80161a6
    CPU.cmpT(r6, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r6 = CPU.movT(0, 0x2);
    }

    //LAB_80161ac
    CPU.cmpT(r6, 0x1e);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r6 = CPU.movT(0, 0x1e);
    }

    //LAB_80161b2
    CPU.cmpT(r7, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r7 = CPU.movT(0, 0x2);
    }

    //LAB_80161b8
    CPU.cmpT(r7, 0x1e);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r7 = CPU.movT(0, 0x1e);
    }

    //LAB_80161be
    r2 = CPU.addT(r6, 0x0);
    r1 = CPU.r8().value;
    r3 = CPU.addT(r7, 0x0);
    MEMORY.ref(4, CPU.sp().value).setu(r4);
    FUN_801e260(r0, r1, r2, r3);
    r2 = CPU.movT(0, 0x0);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r2 = CPU.cmpT(r2, r7);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r0 = MEMORY.ref(4, 0x8016224).get();
      r3 = CPU.movT(0, 0x20);
      r3 = CPU.subT(r3, r6);
      r0 += CPU.r10().value;
      r1 = CPU.lslT(r3, 1);

      //LAB_80161dc
      do {
        r3 = MEMORY.ref(1, r0).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.r8().value;
          r3 = CPU.addT(r4, r2);
          r4 = MEMORY.ref(4, 0x8016228).get();
          CPU.cmpT(r3, 0x10);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            r4 = CPU.movT(0, 0xf0);
            r4 = CPU.lslT(r4, 8);
          }
        }

        //LAB_80161f0
        r3 = CPU.movT(0, 0x0);
        r3 = CPU.cmpT(r3, r6);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_80161f6
          do {
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(2, r5).setu(r4);
            r5 = CPU.addT(r5, 0x2);
            r3 = CPU.cmpT(r3, r6);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }

        //LAB_8016200
        r2 = CPU.addT(r2, 0x1);
        r5 = CPU.addT(r5, r1);
        r2 = CPU.cmpT(r2, r7);
      } while(!CPU.cpsr().getCarry()); // unsigned <
    }

    //LAB_8016208
    r2 = MEMORY.ref(4, 0x801622c).get();
    r3 = CPU.movT(0, 0x1);
    r2 += CPU.r10().value;
    MEMORY.ref(1, r2).setu(r3);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8016230)
  public static void FUN_8016230(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r3 = MEMORY.ref(4, 0x80162c0).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r3;
    r3 = MEMORY.ref(2, r0 + 0xa).getUnsigned();
    r2 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
    CPU.r8().value = r3;
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r0 + 0x1a).setu(r3);
    r3 = CPU.movT(0, 0x8);
    r3 = CPU.andT(r3, r2);
    CPU.sp().value -= 0x4;
    r5 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
    r6 = MEMORY.ref(2, r0 + 0xe).getUnsigned();
    r7 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x20);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.addT(r5, 0x0);
        r1 = CPU.addT(r6, 0x0);
        r2 = CPU.addT(r7, 0x0);
        r3 = CPU.r8().value;
        FUN_80170f8(r0, r1, r2, r3);
        r1 = CPU.movT(0, 0xf0);
        r3 = MEMORY.ref(4, 0x80162c4).get();
        r0 = MEMORY.ref(4, 0x80162c8).get();
        r1 = CPU.lslT(r1, 4);
        r2 = MEMORY.ref(4, 0x80162cc).get();
        MEMORY.call(r3, r0, r1, r2);
      } else {
        //LAB_801627c
        r1 = CPU.movT(0, 0xf0);
        r3 = MEMORY.ref(4, 0x80162c4).get();
        r0 = MEMORY.ref(4, 0x80162c8).get();
        r1 = CPU.lslT(r1, 4);
        r2 = CPU.movT(0, 0x0);
        MEMORY.call(r3, r0, r1, r2);
      }

      //LAB_801628a
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r6, 0x0);
      r2 = CPU.addT(r7, 0x0);
      r3 = CPU.r8().value;
      FUN_8017248(r0, r1, r2, r3);
    } else {
      //LAB_801629c
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r6, 0x0);
      r2 = CPU.addT(r7, 0x0);
      r3 = CPU.r8().value;
      FUN_80170f8(r0, r1, r2, r3);
    }

    //LAB_80162a8
    r2 = MEMORY.ref(4, 0x80162d0).get();
    r3 = CPU.movT(0, 0x1);
    r2 += CPU.r10().value;
    MEMORY.ref(1, r2).setu(r3);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x80162d4)
  public static int FUN_80162d4(final int r0, int r1, final int r2, final int r3, final int a4) {
    int r4;
    final int r7;

    r4 = MEMORY.ref(4, 0x3001e8c).get() + 0x500;
    r7 = r1;
    r1 = 0;

    if((MEMORY.ref(2, r4 + 0x16).getUnsigned() & 0x1) != 0) {
      //LAB_80162fc
      do {
        do {
          r1++;
          r4 += 0x24;
          if(r1 == 8) {
            return 0;
          }

          //LAB_801630a
        } while((MEMORY.ref(2, r4 + 0x16).getUnsigned() & 0x1) != 0);
      } while(MEMORY.ref(2, r4 + 0x1a).get() != 0);
    }

    //LAB_8016318
    MEMORY.ref(2, r4 + 0xe).setu(r7);
    MEMORY.ref(2, r4 + 0x8).setu(r2);
    MEMORY.ref(2, r4 + 0xa).setu(r3);
    MEMORY.ref(2, r4 + 0xc).setu(r0);
    MEMORY.ref(2, r4 + 0x14).setu(0);
    MEMORY.ref(4, r4).setu(0);
    MEMORY.ref(4, r4 + 0x4).setu(r4);
    MEMORY.ref(2, r4 + 0x10).setu(0x1);
    MEMORY.ref(2, r4 + 0x16).setu(0x1);
    FUN_80173ac();

    if((a4 & 0x8) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x8);
    }

    //LAB_8016352
    if((a4 & 0x20) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x20);
    }

    //LAB_8016362
    if((a4 & 0x40) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x40);
    }

    //LAB_8016380
    if((a4 & 0x80) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x80);
    }

    //LAB_8016390
    if((a4 & 0x100) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x100);
    }

    //LAB_80163a4
    if((a4 & 0x2) != 0) {
      MEMORY.ref(2, r4 + 0x16).oru(0x2);
      MEMORY.ref(2, r4 + 0x18).setu(0);
      MEMORY.ref(2, r4 + 0x1a).setu(0x1);
      FUN_8016230(r4);
    } else {
      //LAB_80163ce
      MEMORY.ref(2, r4 + 0x1a).setu(0x8);
      MEMORY.ref(2, r4 + 0x18).setu(0x7);
      FUN_80163ec(r4);
      FUN_80030f8(1);
    }

    //LAB_80163e0
    return r4;
  }

  @Method(0x80163ec)
  public static void FUN_80163ec(final int r0) {
    if((MEMORY.ref(2, r0 + 0x16).getUnsigned() & 0x2) == 0) {
      //LAB_8016402
      while(MEMORY.ref(2, r0 + 0x1a).get() != 0) {
        FUN_80030f8(1);
      }
    }

    //LAB_8016410
  }

  @Method(0x8016418)
  public static void FUN_8016418(int r0, int r1) {
    final int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r5 = CPU.addT(r0, 0x0);
    r7 = CPU.addT(r1, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_8016478(r0);
      r3 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
      MEMORY.ref(2, r5 + 0x1c).setu(r3);
      r3 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
      MEMORY.ref(2, r5 + 0x1e).setu(r3);
      r3 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
      MEMORY.ref(2, r5 + 0x20).setu(r3);
      r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
      r6 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r5 + 0x16).setu(r6);
      MEMORY.ref(2, r5 + 0x22).setu(r3);
      CPU.cmpT(r7, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
        r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
        r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
        r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
        FUN_8016178(r0, r1, r2, r3);
        MEMORY.ref(4, r5).setu(r6);
        MEMORY.ref(4, r5 + 0x4).setu(r6);
        MEMORY.ref(2, r5 + 0x8).setu(r6);
        MEMORY.ref(2, r5 + 0xa).setu(r6);
        MEMORY.ref(2, r5 + 0xc).setu(r6);
        MEMORY.ref(2, r5 + 0xe).setu(r6);
        MEMORY.ref(2, r5 + 0x10).setu(r6);
        MEMORY.ref(2, r5 + 0x12).setu(r6);
        MEMORY.ref(2, r5 + 0x14).setu(r6);
        MEMORY.ref(2, r5 + 0x16).setu(r6);
        MEMORY.ref(2, r5 + 0x18).setu(r6);
        MEMORY.ref(2, r5 + 0x1a).setu(r6);
        MEMORY.ref(2, r5 + 0x1c).setu(r6);
        MEMORY.ref(2, r5 + 0x1e).setu(r6);
        MEMORY.ref(2, r5 + 0x20).setu(r6);
        MEMORY.ref(2, r5 + 0x22).setu(r6);
      } else {
        //LAB_801646c
        r3 = CPU.movT(0, 0x4);
        MEMORY.ref(2, r5 + 0x18).setu(r7);
        MEMORY.ref(2, r5 + 0x1a).setu(r3);
      }
    }

    //LAB_8016472
  }

  @Method(0x8016478)
  public static void FUN_8016478(int r0) {
    final int r2;
    int r3;
    final int r5;
    r5 = CPU.addT(r0, 0x0);
    r2 = MEMORY.ref(2, r5 + 0x16).getUnsigned();
    r3 = CPU.movT(0, 0x8);
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_8016498(r0);
      r0 = CPU.addT(r5, 0x0);
      FUN_80164ac(r0);
    }

    //LAB_8016490
  }

  @Method(0x8016498)
  public static void FUN_8016498(int r0) {
    final int r4 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
    final int r1 = MEMORY.ref(2, r0 + 0xe).getUnsigned();
    final int r2 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
    final int r3 = MEMORY.ref(2, r0 + 0xa).getUnsigned();
    r0 = CPU.addT(r4, 0x0);
    FUN_80170f8(r0, r1, r2, r3);
  }

  @Method(0x80164ac)
  public static void FUN_80164ac(int r0) {
    final int r3 = CPU.addT(r0, 0x0);
    int r5 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, r3).get();
      MEMORY.ref(4, r3 + 0x4).setu(r3);
      MEMORY.ref(4, r3).setu(r5);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_80164c0
        do {
          r5 = MEMORY.ref(4, r0).get();
          FUN_8016594(r0);
          r0 = CPU.addT(r5, 0x0);
          CPU.cmpT(r0, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }
    }

    //LAB_80164cc
  }

  @Method(0x8016584)
  public static void FUN_8016584(final int r0, final int r1) {
    final int r3;

    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, r0 + 0x4).get();
      MEMORY.ref(4, r3).setu(r1);
      MEMORY.ref(4, r0 + 0x4).setu(r1);
    }

    //LAB_8016590
  }

  @Method(0x8016594)
  public static void FUN_8016594(int r0) {
    final int r1;
    int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r0, 0x0);
    FUN_8015ec0(r0);
    r3 = MEMORY.ref(1, r5 + 0x4).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(1, r5 + 0xe).getUnsigned();
      r0 = FUN_8003f3c(r0);
      r3 = MEMORY.ref(1, r5 + 0x4).getUnsigned();
      CPU.cmpT(r3, 0x2);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, 0x80165d0).get();
        r1 = MEMORY.ref(4, r3).get();
        r3 = MEMORY.ref(1, r5 + 0x19).getUnsigned();
        r2 = MEMORY.ref(4, 0x80165d4).get();
        r3 = CPU.lsrT(r3, 4);
        r3 = CPU.lslT(r3, 1);
        r3 = CPU.addT(r3, r2);
        r2 = MEMORY.ref(4, 0x80165cc).get();
        MEMORY.ref(2, r1 + r3).setu(r2);
      }
    }

    //LAB_80165c0
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r5 + 0x5).setu(r3);
  }

  @Method(0x8016868)
  public static void FUN_8016868() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x80168f0).get();
    r2 = CPU.movT(0, 0xc4);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 3);
    r5 = CPU.addT(r3, r2);
    r3 = CPU.movT(0, 0x1);
    r7 = CPU.movT(0, 0x0);
    CPU.r8().value = r3;

    //LAB_801687e
    do {
      r2 = MEMORY.ref(4, r5).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r2 + 0x18).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(2, r2 + 0x16).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            MEMORY.ref(4, r5).setu(r3);
          } else {
            //LAB_8016894
            r6 = MEMORY.ref(2, r2 + 0x12).getUnsigned();
            CPU.cmpT(r6, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.addT(r5, 0x0);
              FUN_8019854(r0);
            } else {
              //LAB_80168a2
              r0 = CPU.addT(r5, 0x0);
              r0 = FUN_80168f4(r0);
              CPU.cmpT(r0, 0x8);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_80168b2
                r3 = MEMORY.ref(4, r5).get();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r3 + 0x14).setu(r2);
              } else {
                CPU.cmpT(r0, 0x9);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_80168b8
                  r0 = MEMORY.ref(4, r5).get();
                  r3 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
                  r1 = CPU.movT(0, 0x2);
                  r1 = CPU.andT(r1, r3);
                  r1 = CPU.lslT(r1, 16);
                  r1 = CPU.lsrT(r1, 16);
                  FUN_8016418(r0, r1);
                  r3 = MEMORY.ref(4, r5).get();
                  r2 = CPU.r8().value;
                  MEMORY.ref(2, r5 + 0x4).setu(r6);
                  MEMORY.ref(2, r5 + 0x6).setu(r6);
                  MEMORY.ref(2, r5 + 0x12).setu(r6);
                  MEMORY.ref(2, r5 + 0x14).setu(r6);
                  MEMORY.ref(2, r5 + 0x16).setu(r6);
                  MEMORY.ref(2, r5 + 0x18).setu(r6);
                  MEMORY.ref(2, r5 + 0x1a).setu(r6);
                  MEMORY.ref(2, r3 + 0x14).setu(r2);
                }
              }
            }
          }
        }
      }

      //LAB_80168dc
      r7 = CPU.addT(r7, 0x1);
      r5 = CPU.addT(r5, 0x28);
      CPU.cmpT(r7, 0x3);
    } while(!CPU.cpsr().getZero()); // !=

    CPU.r8().value = CPU.pop();
  }

  @Method(0x80168f4)
  public static int FUN_80168f4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8016f2c)
  public static void FUN_8016f2c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);

    r3 = MEMORY.ref(4, 0x8016ffc).get();
    r1 = CPU.movT(0, 0xa0);
    r7 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 3);
    r2 = CPU.movT(0, 0x0);
    r5 = CPU.addT(r7, r1);
    CPU.r8().value = r2;

    //LAB_8016f40
    do {
      r6 = MEMORY.ref(2, r5 + 0x16).getUnsigned();
      CPU.cmpT(r6, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r4 = CPU.movT(0, 0x18);
        r3 = MEMORY.ref(2, r5 + r4).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.movT(0, 0x0);
          FUN_8017004(r0, r1);
          r3 = MEMORY.ref(2, r5 + 0x18).getUnsigned();
          r3 = CPU.subT(r3, 0x1);
          MEMORY.ref(2, r5 + 0x18).setu(r3);
        } else {
          //LAB_8016f5e
          r1 = CPU.movT(0, 0x1a);
          r3 = MEMORY.ref(2, r5 + r1).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r5, 0x0);
            FUN_8016230(r0);
          }
        }
      } else {
        //LAB_8016f6e
        r3 = CPU.movT(0, 0x1a);
        r2 = MEMORY.ref(2, r5 + r3).get();
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.movT(0, 0x18);
          r3 = MEMORY.ref(2, r5 + r4).get();
          r3 = CPU.cmpT(r3, r2);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = CPU.movT(0, 0x1c);
            r0 = MEMORY.ref(2, r5 + r1).get();
            r2 = CPU.movT(0, 0x1e);
            r1 = MEMORY.ref(2, r5 + r2).get();
            r3 = CPU.movT(0, 0x20);
            r2 = MEMORY.ref(2, r5 + r3).get();
            r4 = CPU.movT(0, 0x22);
            r3 = MEMORY.ref(2, r5 + r4).get();
            FUN_8016178(r0, r1, r2, r3);
            r1 = CPU.movT(0, 0x1);
            r0 = CPU.addT(r5, 0x0);
            FUN_8017004(r0, r1);
            r3 = MEMORY.ref(2, r5 + 0x18).getUnsigned();
            r1 = MEMORY.ref(4, 0x8017000).get();
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(2, r5 + 0x18).setu(r3);
            r2 = CPU.movT(0, 0x1);
            r3 = CPU.addT(r7, r1);
            MEMORY.ref(1, r3).setu(r2);
          } else {
            //LAB_8016faa
            r3 = CPU.movT(0, 0x1e);
            r1 = MEMORY.ref(2, r5 + r3).get();
            r2 = CPU.movT(0, 0x1c);
            r0 = MEMORY.ref(2, r5 + r2).get();
            r4 = CPU.movT(0, 0x22);
            r3 = MEMORY.ref(2, r5 + r4).get();
            r4 = CPU.movT(0, 0x20);
            r2 = MEMORY.ref(2, r5 + r4).get();
            FUN_8016178(r0, r1, r2, r3);
            r1 = MEMORY.ref(4, 0x8017000).get();
            r3 = CPU.movT(0, 0x1);
            r2 = CPU.addT(r7, r1);
            MEMORY.ref(4, r5).setu(r6);
            MEMORY.ref(4, r5 + 0x4).setu(r6);
            MEMORY.ref(2, r5 + 0x8).setu(r6);
            MEMORY.ref(2, r5 + 0xa).setu(r6);
            MEMORY.ref(2, r5 + 0xc).setu(r6);
            MEMORY.ref(2, r5 + 0xe).setu(r6);
            MEMORY.ref(2, r5 + 0x10).setu(r6);
            MEMORY.ref(2, r5 + 0x12).setu(r6);
            MEMORY.ref(2, r5 + 0x14).setu(r6);
            MEMORY.ref(2, r5 + 0x16).setu(r6);
            MEMORY.ref(2, r5 + 0x18).setu(r6);
            MEMORY.ref(2, r5 + 0x1a).setu(r6);
            MEMORY.ref(2, r5 + 0x1c).setu(r6);
            MEMORY.ref(2, r5 + 0x1e).setu(r6);
            MEMORY.ref(2, r5 + 0x20).setu(r6);
            MEMORY.ref(2, r5 + 0x22).setu(r6);
            MEMORY.ref(1, r2).setu(r3);
          }
        }
      }

      //LAB_8016fe6
      r2 = CPU.movT(0, 0x1);
      CPU.r8().value += r2;
      r3 = CPU.r8().value;
      r5 = CPU.addT(r5, 0x24);
      CPU.cmpT(r3, 0x8);
    } while(!CPU.cpsr().getZero()); // !=

    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x8017004)
  public static void FUN_8017004(int r0, int r1) {
    final int r2;
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

    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r7 = CPU.addT(r0, 0x0);
    r3 = CPU.movT(0, 0x18);
    r6 = MEMORY.ref(2, r7 + r3).get();
    r3 = CPU.movT(0, 0x1a);
    r0 = MEMORY.ref(2, r7 + r3).get();
    r3 = CPU.subT(r0, r6);
    CPU.r10().value = r3;
    r3 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    r1 = CPU.mulT(r1, r6);
    r3 = MEMORY.ref(4, 0x80170c0).get();
    r5 = CPU.sp().value + 0x4;
    r1 = CPU.lslT(r1, 16);
    r0 = CPU.lslT(r0, 17);
    CPU.r8().value = r3;
    MEMORY.ref(4, r5).setu(r1);
    MEMORY.ref(4, r5 + 0x4).setu(r0);
    r0 = (int)MEMORY.call(CPU.r8().value, r0);
    r3 = MEMORY.ref(2, r7 + 0xc).getUnsigned();
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 16);
    r0 = CPU.addT(r0, r3);
    r3 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
    r1 = CPU.r10().value;
    r1 = CPU.mulT(r1, r3);
    r1 = CPU.lslT(r1, 16);
    MEMORY.ref(4, r5).setu(r1);
    CPU.r9().value = r0;
    r0 = MEMORY.ref(4, r5 + 0x4).get();
    r0 = (int)MEMORY.call(CPU.r8().value, r0);
    r3 = MEMORY.ref(2, r7 + 0xa).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    r1 = CPU.mulT(r1, r6);
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 15);
    CPU.r11().value = r0;
    r3 = CPU.movT(0, 0x1a);
    r0 = MEMORY.ref(2, r7 + r3).get();
    r1 = CPU.lslT(r1, 16);
    r0 = CPU.lslT(r0, 17);
    MEMORY.ref(4, r5).setu(r1);
    MEMORY.ref(4, r5 + 0x4).setu(r0);
    r0 = (int)MEMORY.call(CPU.r8().value, r0);
    r3 = MEMORY.ref(2, r7 + 0xe).getUnsigned();
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 16);
    r6 = CPU.addT(r0, r3);
    r3 = MEMORY.ref(2, r7 + 0xa).getUnsigned();
    r1 = CPU.r10().value;
    r1 = CPU.mulT(r1, r3);
    r1 = CPU.lslT(r1, 16);
    MEMORY.ref(4, r5).setu(r1);
    r0 = MEMORY.ref(4, r5 + 0x4).get();
    r0 = (int)MEMORY.call(CPU.r8().value, r0);
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r5 = CPU.asrT(r0, 15);
    r3 = CPU.addT(r5, 0x0);
    r0 = CPU.r9().value;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.r11().value;
    FUN_80170f8(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, CPU.sp().value).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.r9().value;
      MEMORY.ref(2, r7 + 0x1c).setu(r3);
      r3 = CPU.r11().value;
      MEMORY.ref(2, r7 + 0x1e).setu(r6);
      MEMORY.ref(2, r7 + 0x20).setu(r3);
      MEMORY.ref(2, r7 + 0x22).setu(r5);
    }

    //LAB_80170ac
    CPU.sp().value += 0x10;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x80170c4)
  public static int FUN_80170c4(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;

    r4 = CPU.addT(r2, 0x0);
    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.sp().value;
      r2 = CPU.movT(0, 0x81);
      r0 = CPU.addT(r0, 0x2);
      r2 = CPU.lslT(r2, 24);
      MEMORY.ref(2, r0).setu(r1);
      r3 = MEMORY.ref(4, 0x80170f4).get();
      r1 = CPU.addT(r5, 0x0);
      r2 = CPU.orrT(r2, r4);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);

      r3 = CPU.lslT(r4, 1);
      r5 = CPU.addT(r5, r3);
    }

    //LAB_80170e8
    CPU.sp().value += 0x4;
    return r5;
  }

  @Method(0x80170f8)
  public static void FUN_80170f8(int r0, int r1, int r2, int r3) {
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x801717c).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r11().value = r3;
    r3 = CPU.lslT(r1, 5);
    r3 = CPU.addT(r3, r0);
    CPU.r8().value = r2;
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.r11().value;
    r5 = CPU.addT(r3, r2);
    r3 = CPU.r8().value;
    CPU.cmpT(r3, 0x1);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      //LAB_8017122
      CPU.cmpT(r7, 0x1);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        //LAB_8017128
        CPU.cmpT(r3, 0x1e);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_801712e
          CPU.cmpT(r7, 0x1e);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_8017134
            r3 = CPU.addT(r7, 0x0);
            r2 = CPU.r8().value;
            FUN_801e260(r0, r1, r2, r3);
            r3 = MEMORY.ref(4, 0x8017180).get();
            r3 += CPU.r11().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, 0x8017170).get();
            } else {
              //LAB_801714a
              r3 = MEMORY.ref(4, 0x8017174).get();
            }

            //LAB_801714c
            MEMORY.ref(2, r5).setu(r3);
            r5 = CPU.addT(r5, 0x2);
            r2 = CPU.movT(0, 0x2);
            r2 = CPU.negT(r2, r2);
            r2 += CPU.r8().value;
            r0 = CPU.addT(r5, 0x0);
            r1 = MEMORY.ref(4, 0x8017184).get();
            CPU.r10().value = r2;
            r0 = FUN_80170c4(r0, r1, r2);
            r3 = MEMORY.ref(4, 0x8017180).get();
            r3 += CPU.r11().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            r5 = CPU.addT(r0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, 0x8017178).get();
            } else {
              //LAB_8017188
              r3 = MEMORY.ref(4, 0x80171bc).get();
            }

            //LAB_801718a
            MEMORY.ref(2, r5).setu(r3);
            r5 = CPU.addT(r5, 0x2);
            r3 = CPU.movT(0, 0x20);
            r2 = CPU.r8().value;
            r3 = CPU.subT(r3, r2);
            r3 = CPU.lslT(r3, 1);
            r6 = CPU.movT(0, 0x1);
            r7 = CPU.subT(r7, 0x1);
            r5 = CPU.addT(r5, r3);
            r6 = CPU.cmpT(r6, r7);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              CPU.r9().value = r3;

              //LAB_80171a2
              do {
                r3 = MEMORY.ref(4, 0x80171c0).get();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r5).setu(r3);
                r5 = CPU.addT(r5, 0x2);
                CPU.cmpT(r2, 0x2);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.addT(r5, 0x0);
                  r1 = MEMORY.ref(4, 0x80171c4).get();
                  r2 = CPU.r10().value;
                  r0 = FUN_80170c4(r0, r1, r2);
                  r5 = CPU.addT(r0, 0x0);
                }

                //LAB_80171ca
                r3 = MEMORY.ref(4, 0x80171e8).get();
                r6 = CPU.addT(r6, 0x1);
                MEMORY.ref(2, r5).setu(r3);
                r5 = CPU.addT(r5, 0x2);
                r5 += CPU.r9().value;
                r6 = CPU.cmpT(r6, r7);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }

            //LAB_80171d8
            r3 = MEMORY.ref(4, 0x80171f0).get();
            r3 += CPU.r11().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, 0x80171ec).get();
            } else {
              //LAB_80171f4
              r3 = MEMORY.ref(4, 0x8017214).get();
            }

            //LAB_80171f6
            MEMORY.ref(2, r5).setu(r3);
            r5 = CPU.addT(r5, 0x2);
            r0 = CPU.addT(r5, 0x0);
            r1 = MEMORY.ref(4, 0x801721c).get();
            r2 = CPU.r10().value;
            r0 = FUN_80170c4(r0, r1, r2);
            r3 = MEMORY.ref(4, 0x8017220).get();
            r3 += CPU.r11().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            r5 = CPU.addT(r0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, 0x8017218).get();
            } else {
              //LAB_8017224
              r3 = MEMORY.ref(4, 0x8017240).get();
            }

            //LAB_8017226
            MEMORY.ref(2, r5).setu(r3);
            r2 = MEMORY.ref(4, 0x8017244).get();
            r3 = CPU.movT(0, 0x1);
            r2 += CPU.r11().value;
            MEMORY.ref(1, r2).setu(r3);
          }
        }
      }
    }

    //LAB_8017230
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8017248)
  public static void FUN_8017248(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80173ac)
  public static void FUN_80173ac() {
    final int r2 = MEMORY.ref(4, 0x3001e8c).get();
    MEMORY.ref(2, r2 + 0xeae).setu(15);
    MEMORY.ref(2, r2 + 0xea8).setu(10);
    MEMORY.ref(2, r2 + 0x12b0).setu(9);
    MEMORY.ref(2, r2 + 0xeac).setu(0);
    MEMORY.ref(2, r2 + 0xeaa).setu(1);
  }

  @Method(0x80173f4)
  public static void FUN_80173f4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r3 = MEMORY.ref(4, 0x8017444).get();
    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 6);
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x5f);
    r5 = MEMORY.ref(4, r3).get();
    r0 = FUN_8003fa4(r0, r1, r2);
    r2 = MEMORY.ref(4, 0x8017448).get();
    r3 = CPU.addT(r5, r2);
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x801744c).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0x9);
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8017450).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0xa);
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8017454).get();
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r5, r2);
    MEMORY.ref(2, r3).setu(r1);
    r3 = MEMORY.ref(4, 0x8017458).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0xf);
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x801745c).get();
    r5 = CPU.addT(r5, r2);
    MEMORY.ref(2, r5).setu(r1);
    r1 = CPU.movT(0, 0xc8);
    r1 = CPU.lslT(r1, 4);
    r0 = MEMORY.ref(4, 0x8017460).get();
    FUN_80041d8(r0, r1);
  }

  @Method(0x801789c)
  public static void FUN_801789c() {
    FUN_8016f2c();
    FUN_8016868();
    FUN_80191cc();
  }

  @Method(0x80178b0)
  public static int FUN_80178b0(int r0, int r1) {
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
    CPU.sp().value -= 0x184;

    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r3 = MEMORY.ref(4, 0x8017a44).get();
    r5 = CPU.addT(r0, 0x0);
    r6 = MEMORY.ref(4, r3).get();
    r3 = CPU.lslT(r5, 8);
    r3 = CPU.asrT(r3, 16);
    CPU.r10().value = r3;
    r1 = CPU.movT(0, 0xc0);
    r3 = CPU.movT(0, 0xff);
    r5 = CPU.andT(r5, r3);
    r0 = CPU.sp().value + 0x4;
    r3 = MEMORY.ref(4, 0x8017a48).get();
    r1 = CPU.lslT(r1, 1);
    MEMORY.call(r3, r0, r1);
    r0 = MEMORY.ref(4, 0x8017a4c).get();
    r3 = CPU.addT(r6, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.movT(0, 0x8);
      CPU.r9().value = r2;
    } else {
      //LAB_80178f0
      r2 = MEMORY.ref(4, 0x8017a50).get();
      r3 = CPU.addT(r6, r2);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r0 = CPU.movT(0, 0x1);
      CPU.r9().value = r0;
    }

    //LAB_80178fa
    CPU.r11().value = r3;
    r3 = CPU.addT(r5, 0x0);
    r3 = CPU.subT(r3, 0x20);
    r2 = MEMORY.ref(4, 0x8017a54).get();
    r3 = CPU.lslT(r3, 5);
    r7 = CPU.addT(r3, r2);
    r3 = MEMORY.ref(2, r7).getUnsigned();
    r0 = MEMORY.ref(4, 0x8017a58).get();
    CPU.r8().value = r3;
    r3 = CPU.addT(r6, r0);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r7 = CPU.addT(r7, 0x2);
    CPU.cmpT(r3, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.sp().value;
      r5 = MEMORY.ref(4, 0x8017a5c).get();
      r1 = CPU.addT(r1, 0x35);
      r2 = CPU.r9().value;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(r5, r0, r1, r2);
      r1 = CPU.sp().value;
      r1 = CPU.addT(r1, 0x36);
      r2 = CPU.r9().value;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(r5, r0, r1, r2);
      r2 = CPU.r11().value;
      r1 = CPU.sp().value + 0x24;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(r5, r0, r1, r2);
      r1 = CPU.sp().value;
      r2 = CPU.r11().value;
      r1 = CPU.addT(r1, 0x25);
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(r5, r0, r1, r2);
      r2 = CPU.movT(0, 0x1);
      CPU.r8().value += r2;
    } else {
      //LAB_801794c
      r1 = CPU.sp().value;
      r1 = CPU.addT(r1, 0x35);
      r2 = CPU.r9().value;
      r5 = MEMORY.ref(4, 0x8017a5c).get();
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(r5, r0, r1, r2);
      r0 = CPU.addT(r7, 0x0);
      r1 = CPU.sp().value + 0x24;
      r2 = CPU.r11().value;
      MEMORY.call(r5, r0, r1, r2);
    }

    //LAB_8017964
    r0 = CPU.r10().value;
    r3 = CPU.lslT(r0, 16);
    r2 = CPU.lsrT(r3, 16);
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8017a60).get();
      r2 = CPU.lslT(r2, 5);
      r0 = MEMORY.ref(4, 0x8017a58).get();
      r7 = CPU.addT(r2, r3);
      r3 = CPU.movT(0, 0x0);
      r2 = MEMORY.ref(2, r7 + r3).get();
      r3 = CPU.addT(r6, r0);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      CPU.r10().value = r2;
      r7 = CPU.addT(r7, 0x2);
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.sp().value + 0x4;
        r2 = CPU.r8().value;
        r6 = CPU.addT(r3, r2);
        r1 = CPU.addT(r6, 0x0);
        r5 = MEMORY.ref(4, 0x8017a5c).get();
        r1 = CPU.addT(r1, 0x31);
        r2 = CPU.r9().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(r5, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x32);
        r2 = CPU.r9().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(r5, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x20);
        r2 = CPU.r11().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(r5, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r2 = CPU.r11().value;
        r1 = CPU.addT(r1, 0x21);
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(r5, r0, r1, r2);
        r0 = CPU.r10().value;
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r0, 16);
        r2 = CPU.lslT(r2, 9);
        r3 = CPU.addT(r3, r2);
        r3 = CPU.asrT(r3, 16);
        CPU.r10().value = r3;
      } else {
        //LAB_80179ce
        r5 = CPU.sp().value + 0x4;
        r5 += CPU.r8().value;
        r1 = CPU.addT(r5, 0x0);
        r1 = CPU.addT(r1, 0x31);
        r2 = CPU.r9().value;
        r6 = MEMORY.ref(4, 0x8017a5c).get();
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(r6, r0, r1, r2);
        r1 = CPU.addT(r5, 0x0);
        r1 = CPU.addT(r1, 0x20);
        r0 = CPU.addT(r7, 0x0);
        r2 = CPU.r11().value;
        MEMORY.call(r6, r0, r1, r2);
      }

      //LAB_80179ec
      r0 = CPU.r10().value;
      r3 = CPU.lslT(r0, 16);
      r3 = CPU.lsrT(r3, 16);
      CPU.r8().value += r3;
    }

    //LAB_80179f4
    r1 = CPU.sp().value;
    r1 = CPU.addT(r1, 0xb);
    r6 = CPU.movT(0, 0x0);

    //LAB_80179fa
    do {
      r5 = CPU.movT(0, 0x0);

      //LAB_80179fc
      do {
        r4 = CPU.movT(0, 0x0);

        //LAB_80179fe
        do {
          r2 = CPU.movT(0, 0x0);
          r0 = CPU.movT(0, 0x7);

          //LAB_8017a02
          do {
            r3 = MEMORY.ref(1, r1).getUnsigned();
            r2 = CPU.lslT(r2, 4);
            r0 = CPU.subT(r0, 0x1);
            r2 = CPU.addT(r2, r3);
            r1 = CPU.subT(r1, 0x1);
            CPU.cmpT(r0, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          r0 = MEMORY.ref(4, CPU.sp().value).get();
          MEMORY.ref(4, r0).setu(r2);
          r0 += 0x4;

          r4 = CPU.addT(r4, 0x1);
          r3 = CPU.addT(r0, 0x0);
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r1 = CPU.addT(r1, 0x18);
          CPU.cmpT(r4, 0x7);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

        r5 = CPU.addT(r5, 0x1);
        r1 = CPU.subT(r1, 0x78);
        CPU.cmpT(r5, 0x1);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      r6 = CPU.addT(r6, 0x1);
      r1 = CPU.addT(r1, 0x70);
      CPU.cmpT(r6, 0x1);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r0 = CPU.r8().value;

    CPU.sp().value += 0x184;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r0;
  }

  @Method(0x8017aa4)
  public static void FUN_8017aa4(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r3;
    r3 = MEMORY.ref(4, 0x8017aec).get();
    r7 = CPU.addT(r2, 0x0);
    r6 = MEMORY.ref(4, r3).get();
    r3 = CPU.lslT(r7, 16);
    r3 = CPU.asrT(r3, 16);
    r5 = CPU.addT(r0, 0x0);
    CPU.sp().value -= 0x4;
    CPU.r10().value = r1;
    r4 = CPU.movT(0, 0x0);
    CPU.r9().value = r3;
    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_8017aca
      r3 = MEMORY.ref(4, 0x8017af0).get();
      r1 = CPU.addT(r6, r3);
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r2 = CPU.movT(0, 0xeb);
      r2 = CPU.lslT(r2, 4);
      r3 = CPU.lslT(r3, 1);
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r6 + r3).setu(r4);
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r5 = CPU.addT(r6, r2);
      r2 = MEMORY.ref(4, 0x8017ae8).get();
      r3 = CPU.addT(r3, 0x1);
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(2, r1).setu(r3);
    }

    r4 = MEMORY.ref(2, r5).getUnsigned();
    r5 += 0x2;
    if(r4 > 0xff) {
      r4 = 0x40;
    }

    //LAB_8017af4
    while(r4 != 0) {
      CPU.cmpT(r4, 0x1e);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        //LAB_8017b9a
        r3 = CPU.r10().value;
        r2 = MEMORY.ref(2, r3 + 0x16).getUnsigned();
        r3 = CPU.movT(0, 0x8);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(2, r5).getUnsigned();
          CPU.cmpT(r4, 0x20);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            CPU.cmpT(r0, 0x20);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r3 = CPU.addT(r4, 0x0);
              r2 = CPU.addT(r0, 0x0);
              r1 = MEMORY.ref(4, 0x8017c18).get();
              r3 = CPU.subT(r3, 0x20);
              r2 = CPU.subT(r2, 0x20);
              r3 = CPU.lslT(r3, 5);
              r2 = CPU.lslT(r2, 5);
              r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
              r2 = MEMORY.ref(2, r1 + r2).getUnsigned();
              r1 = CPU.movT(0, 0xf0);
              r3 = CPU.addT(r3, r2);
              r3 = CPU.lslT(r3, 16);
              r1 = CPU.lslT(r1, 12);
              r3 = CPU.cmpT(r3, r1);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r3 = CPU.lslT(r0, 8);
                r4 = CPU.orrT(r4, r3);
                r5 = CPU.addT(r5, 0x2);
              }
            }
          }
        }

        //LAB_8017bd4
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r2 = CPU.addT(r7, 0x0);
        r0 = CPU.r10().value;
        r1 = CPU.addT(r4, 0x0);
        r3 = CPU.r8().value;
        r0 = FUN_8018cac(r0, r1, r2, r3);
        r7 = CPU.addT(r7, r0);
      } else {
        switch(r4) {
          case 8:
            r1 = MEMORY.ref(4, 0x8017c0c).get();
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, r1);
            MEMORY.ref(2, r3).setu(r2);
            r5 = CPU.addT(r5, 0x2);
            break;

          case 9:
            r1 = MEMORY.ref(4, 0x8017c10).get();
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, r1);
            MEMORY.ref(2, r3).setu(r2);
            r5 = CPU.addT(r5, 0x2);
            break;

          case 10:
            r1 = MEMORY.ref(4, 0x8017c14).get();
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, r1);
            MEMORY.ref(2, r3).setu(r2);
            r5 = CPU.addT(r5, 0x2);
            break;

          case 11:
          case 12:
          case 17:
          case 29:
            //LAB_8017b84
            r5 = CPU.addT(r5, 0x2);
            break;

          case 7:
            FUN_80173ac();
            break;

          case 3:
            r2 = CPU.movT(0, 0xf);
            r7 = CPU.r9().value;
            CPU.r8().value += r2;
            break;

          case 14:
          case 15:
          case 28:
            r5 = CPU.addT(r5, 0x2);
            r5 = CPU.addT(r5, 0x2);
            break;
        }
      }

      //LAB_8017be6
      r4 = MEMORY.ref(2, r5).getUnsigned();
      r5 += 0x2;
      if(r4 > 0xff) {
        r4 = 0x40;
      }

      //LAB_8017bf0
    }

    //LAB_8017bf6
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8018850)
  public static void FUN_8018850(int r0, int r1, int r2, int r3) {
    final int r4;
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

    CPU.sp().value -= 0x20;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    r6 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x80189f0).get();
    r4 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, 0x80189f4).get();
    r2 = CPU.movT(0, 0x0);
    CPU.r10().value = r2;
    CPU.lr().value = r3;
    r2 = CPU.movT(0, 0x18);
    r3 = CPU.movT(0, 0x10);
    r1 = CPU.movT(0, 0xf);
    r5 = CPU.movT(0, 0x0);
    r2 += CPU.sp().value;
    r3 += CPU.sp().value;
    CPU.r11().value = r1;
    r7 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);
    CPU.r8().value = r2;
    CPU.r12().value = r5;
    CPU.r9().value = r3;

    //LAB_801888a
    do {
      do {
        r2 = CPU.movT(0, 0xeb);
        r3 = CPU.lslT(r0, 1);
        r2 = CPU.lslT(r2, 4);
        r3 = CPU.addT(r3, r2);
        r2 = MEMORY.ref(2, r4 + r3).getUnsigned();
        r3 = MEMORY.ref(4, 0x80189f8).get();
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.andT(r0, r3);
        CPU.cmpT(r2, 0x1f);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_80188c6
          switch(r2) {
            case 3:
              r3 = CPU.r8().value;
              r2 = CPU.r12().value;
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r3 + r2).setu(r5);
              r3 = CPU.r9().value;
              MEMORY.ref(2, r3 + r2).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = CPU.addT(r1, 0x0);
              }

              //LAB_801895a
              r3 = CPU.r10().value;
              CPU.cmpT(r3, 0x2);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r1 = CPU.movT(0, 0x1);
                CPU.r10().value += r1;
                r2 = CPU.r10().value;
                r2 = CPU.lslT(r2, 1);
                CPU.r12().value = r2;
              }

              //LAB_801896a
              r2 = MEMORY.ref(4, 0x80189f4).get();
              r3 = CPU.movT(0, 0xf);
              r5 = CPU.movT(0, 0x0);
              r1 = CPU.movT(0, 0x0);
              CPU.r11().value += r3;
              CPU.lr().value = r2;
              continue;

            case 0xe:
            case 0x1c:
              r3 = MEMORY.ref(4, 0x80189f8).get();
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, r3);

            case 8:
            case 0xa:
            case 0xf:
            case 0x11:
              r3 = MEMORY.ref(4, 0x80189f8).get();
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, r3);
              continue;

            case 9:
              r2 = CPU.movT(0, 0xeb);
              r3 = CPU.lslT(r0, 1);
              r2 = CPU.lslT(r2, 4);
              r3 = CPU.addT(r3, r2);
              r2 = MEMORY.ref(2, r4 + r3).getUnsigned();
              r3 = MEMORY.ref(4, 0x8018a00).get();
              r3 = CPU.addT(r3, r4);
              MEMORY.ref(2, r3).setu(r2);
              r3 = MEMORY.ref(4, 0x80189f8).get();
              r2 = MEMORY.ref(4, 0x80189f4).get();
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, r3);
              CPU.lr().value = r2;
              continue;

            case 0:
            case 1:
              r3 = CPU.r8().value;
              r2 = CPU.r12().value;
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r3 + r2).setu(r5);
              r3 = CPU.r9().value;
              MEMORY.ref(2, r3 + r2).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = CPU.addT(r1, 0x0);
              }

              //LAB_80189b4
              r1 = MEMORY.ref(4, 0x8018a04).get();
              r3 = CPU.addT(r4, r1);
              r3 = MEMORY.ref(1, r3).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r7 = CPU.addT(r7, 0x2);
              }

              //LAB_80189c0
              r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              MEMORY.ref(4, r2).setu(r7);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              r3 = CPU.r11().value;
              MEMORY.ref(4, r1).setu(r3);
              r3 = CPU.addT(r7, 0x0);
              r3 = CPU.addT(r3, 0x13);
              r7 = CPU.lsrT(r3, 3);
              r3 = CPU.lslT(r7, 3);
              r7 = CPU.addT(r3, 0x0);
              r7 = CPU.subT(r7, 0x10);
              CPU.cmpT(r6, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r2 = CPU.movT(0, 0x0);
                r5 = CPU.movT(0, 0x0);

                //LAB_80189de
                do {
                  r1 = CPU.r8().value;
                  r3 = MEMORY.ref(2, r5 + r1).getUnsigned();
                  CPU.cmpT(r3, 0x1);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r3 = MEMORY.ref(4, 0x80189ec).get();
                    MEMORY.ref(2, r6).setu(r3);
                  } else {
                    //LAB_8018a08
                    r1 = CPU.r9().value;
                    r3 = MEMORY.ref(2, r5 + r1).getUnsigned();
                    r0 = CPU.subT(r7, r3);
                    r0 = CPU.subT(r0, 0x4);
                    CPU.cmpT(r0, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r0 = CPU.movT(0, 0x0);
                    }

                    //LAB_8018a16
                    r3 = CPU.r8().value;
                    r1 = MEMORY.ref(2, r5 + r3).getUnsigned();
                    r0 = CPU.lslT(r0, 8);
                    r1 = CPU.subT(r1, 0x1);
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                    r0 = FUN_80022ec(r0, r1);
                    r1 = CPU.movT(0, 0xc0);
                    r1 = CPU.lslT(r1, 4);
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                    r0 = CPU.cmpT(r0, r1);
                    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                      r0 = CPU.movT(0, 0x80);
                      r0 = CPU.lslT(r0, 2);
                    }

                    //LAB_8018a32
                    MEMORY.ref(2, r6).setu(r0);
                  }

                  //LAB_8018a34
                  r6 = CPU.addT(r6, 0x2);
                  r2 = CPU.addT(r2, 0x1);
                  r5 = CPU.addT(r5, 0x2);
                  CPU.cmpT(r2, CPU.r10().value);
                } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
              }

              //LAB_8018a3e
              CPU.sp().value += 0x20;
              r3 = CPU.pop();
              r5 = CPU.pop();
              r6 = CPU.pop();
              r7 = CPU.pop();

              CPU.r8().value = r3;
              CPU.r9().value = r5;
              CPU.r10().value = r6;
              CPU.r11().value = r7;
              return;
          }
        }
        CPU.cmpT(r2, 0x20);
        if(!CPU.cpsr().getZero()) { // !=
          break;
        }
        r1 = CPU.addT(r1, 0x5);
        r5 = CPU.addT(r5, 0x1);
      } while(true);

      //LAB_80188a8
      r3 = MEMORY.ref(4, 0x80189fc).get();
      r2 = CPU.subT(r2, 0x20);
      r2 = CPU.lslT(r2, 5);
      r2 = MEMORY.ref(2, r3 + r2).getUnsigned();
      r3 = MEMORY.ref(4, 0x8018a00).get();
      r3 = CPU.addT(r4, r3);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      CPU.cmpT(r3, 0x1);
      if(r3 == 1 || r3 == 5) {
        //LAB_80188c0
        r2 = CPU.addT(r2, 0x1);
      }

      //LAB_80188c2
      r1 = CPU.addT(r1, r2);
    } while(true);
  }

  @Method(0x8018cac)
  public static int FUN_8018cac(int r0, int r1, int r2, int r3) {
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x90;

    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    r7 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, 0x8018e24).get();
    r2 = MEMORY.ref(4, 0x8018e28).get();
    r6 = MEMORY.ref(4, r1).get();
    r3 = CPU.addT(r6, r2);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r2 = MEMORY.ref(4, 0x8018e2c).get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r3 = CPU.addT(r6, r2);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    CPU.r11().value = r3;
    r3 = MEMORY.ref(4, CPU.sp().value + 0xb0).get();
    CPU.r8().value = r0;
    CPU.cmpT(r3, 0x1);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
      r3 = CPU.movT(0, 0x8);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r1 + 0x58).get();
        r3 = MEMORY.ref(4, r3).get();
        CPU.cmpT(r3, CPU.r8().value);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(4, 0x8018e30).get();
          r0 = getPointerTableEntry(r0);
          r0 = MEMORY.ref(4, 0x8018e34).get();
          r0 = getPointerTableEntry(r0);
          r1 = CPU.movT(0, 0x3);
          CPU.r9().value = r1;
          CPU.cmpT(r7, 0x20);
          if(CPU.cpsr().getZero()) { // ==
            CPU.sp().value += 0x90;
            CPU.r8().value = CPU.pop();
            CPU.r9().value = CPU.pop();
            CPU.r10().value = CPU.pop();
            CPU.r11().value = CPU.pop();
            return r0;
          }
        }

        //LAB_8018d06
        r0 = MEMORY.ref(4, 0x8018e34).get();
        r0 = getPointerTableEntry(r0);
        r2 = CPU.movT(0, 0x4);
        CPU.r10().value = r0;
        CPU.r9().value = r2;
        CPU.cmpT(r7, 0x20);
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.r9().value;
          CPU.sp().value += 0x90;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return r0;
        }

        //LAB_8018d18
        r5 = MEMORY.ref(4, 0x8018e38).get();
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_8004938(r0);
        r2 = CPU.movT(0, 0x84);
        r6 = CPU.addT(r0, 0x0);
        r5 = CPU.lsrT(r5, 2);
        r2 = CPU.lslT(r2, 24);
        r3 = MEMORY.ref(4, 0x8018e3c).get();
        r0 = MEMORY.ref(4, 0x8018e40).get();
        r1 = CPU.addT(r6, 0x0);
        r2 = CPU.orrT(r2, r5);
        MEMORY.ref(4, r3).setu(r0);
        r3 += 0x4;
        MEMORY.ref(4, r3).setu(r1);
        r3 += 0x4;
        MEMORY.ref(4, r3).setu(r2);

        r3 = CPU.r10().value;
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r1 = CPU.addT(r7, 0x0);
        r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r0 = CPU.r8().value;
        r0 = (int)MEMORY.call(r6, r0, r1, r2, r3);
        r5 = CPU.addT(r0, 0x0);
        r0 = CPU.addT(r6, 0x0);
        FUN_8002df0(r0);
        r0 = CPU.addT(r5, 0x0);
        CPU.sp().value += 0x90;
        CPU.r8().value = CPU.pop();
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return r0;
      }
    }

    //LAB_8018d50
    r1 = CPU.movT(0, 0x5);
    CPU.r9().value = r1;
    CPU.cmpT(r7, 0x20);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.r9().value;
    } else {
      //LAB_8018d5a
      r0 = FUN_8015e8c();
      r5 = CPU.addT(r0, 0x0);
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_8018d68
        r2 = MEMORY.ref(4, 0x8018e44).get();
        r3 = CPU.subT(r5, r6);
        r3 = CPU.addT(r3, r2);
        r2 = MEMORY.ref(4, 0x8018e48).get();
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.mulT(r1, r2);
        r3 = CPU.movT(0, 0x1);
        r2 = CPU.movT(0, 0x0);
        MEMORY.ref(1, r5 + 0x5).setu(r3);
        MEMORY.ref(1, r5 + 0x4).setu(r2);
        r3 = MEMORY.ref(4, CPU.sp().value + 0xb0).get();
        CPU.r10().value = r1;
        CPU.cmpT(r3, 0x1);
        if(CPU.cpsr().getZero()) { // ==
          r1 = CPU.movT(0, 0x1);
          r3 = CPU.movT(0, 0x2);
          CPU.r9().value = r1;
          MEMORY.ref(1, r5 + 0x5).setu(r3);
        } else {
          //LAB_8018d8e
          r1 = MEMORY.ref(4, 0x8018e4c).get();
          r3 = CPU.addT(r6, r1);
          r3 = MEMORY.ref(2, r3).getUnsigned();
          CPU.cmpT(r3, 0x3);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_8018dac
            r3 = CPU.movT(0, 0x5);
            MEMORY.ref(1, r5 + 0x5).setu(r3);
          } else {
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
              CPU.cmpT(r3, 0x2);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.movT(0, 0x4);
                MEMORY.ref(1, r5 + 0x5).setu(r3);
                MEMORY.ref(2, r5 + 0xc).setu(r2);
              }
            } else {
              //LAB_8018da2
              CPU.cmpT(r3, 0x4);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8018db2
                r3 = CPU.movT(0, 0x6);
                MEMORY.ref(1, r5 + 0x5).setu(r3);
                r3 = CPU.movT(0, 0x8);
                MEMORY.ref(2, r5 + 0xc).setu(r3);
              } else {
                CPU.cmpT(r3, 0x5);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_8018dbc
                  r3 = CPU.movT(0, 0x7);
                  MEMORY.ref(1, r5 + 0x5).setu(r3);
                  MEMORY.ref(2, r5 + 0xc).setu(r2);
                }
              }
            }
          }

          //LAB_8018dc6
          r1 = CPU.sp().value + 0x10;
          r0 = CPU.addT(r7, 0x0);
          r0 = FUN_80178b0(r0, r1);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x1);
          }

          //LAB_8018dd4
          CPU.r9().value = r0;
        }

        //LAB_8018dd6
        r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
        CPU.cmpT(r3, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(4, 0x8018e50).get();
          r6 = CPU.addT(r6, r2);
          r3 = MEMORY.ref(2, r6).getUnsigned();
          r7 = CPU.addT(r5, 0x0);
          r7 = CPU.addT(r7, 0x10);
          CPU.cmpT(r3, 0x63);
          if(CPU.cpsr().getZero()) { // ==
            r0 = FUN_8004080();
            MEMORY.ref(2, r6).setu(r0);
          }

          //LAB_8018df0
          r3 = CPU.r8().value;
          r2 = MEMORY.ref(2, r3 + 0xc).getUnsigned();
          r1 = MEMORY.ref(4, 0x8018e54).get();
          r3 = MEMORY.ref(2, r3 + 0x8).getUnsigned();
          r3 = CPU.addT(r3, r1);
          r2 = CPU.addT(r2, r3);
          r2 = CPU.lslT(r2, 3);
          r3 = MEMORY.ref(4, 0x8018e20).get();
          r2 = CPU.addT(r2, 0x4);
          r2 = CPU.andT(r2, r3);
          r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
          r3 = MEMORY.ref(4, 0x8018e58).get();
          r3 = CPU.andT(r3, r1);
          r3 = CPU.orrT(r3, r2);
          r2 = CPU.r8().value;
          MEMORY.ref(2, r7 + 0x6).setu(r3);
          r3 = MEMORY.ref(1, r2 + 0xe).getUnsigned();
          r2 = MEMORY.ref(1, r2 + 0xa).getUnsigned();
          r2 = CPU.addT(r2, 0xfe);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 3);
          r3 = CPU.subT(r3, 0x1);
          MEMORY.ref(1, r7 + 0x4).setu(r3);
        } else {
          //LAB_8018e5c
          r3 = MEMORY.ref(4, 0x8018ed4).get();
          r4 = CPU.addT(r6, r3);
          r1 = MEMORY.ref(2, r4).getUnsigned();
          r2 = MEMORY.ref(4, 0x8018ed8).get();
          r1 += CPU.r10().value;
          r1 = CPU.lslT(r1, 5);
          r1 = CPU.addT(r1, r2);
          r3 = MEMORY.ref(4, 0x8018edc).get();
          r0 = CPU.sp().value + 0x10;
          r2 = MEMORY.ref(4, 0x8018ee0).get();
          MEMORY.ref(4, r3).setu(r0);
          r3 += 0x4;
          MEMORY.ref(4, r3).setu(r1);
          r3 += 0x4;
          MEMORY.ref(4, r3).setu(r2);

          r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r1 = CPU.r11().value;
          r3 = CPU.lsrT(r1, 1);
          r1 = CPU.r8().value;
          r3 = CPU.addT(r2, r3);
          r2 = MEMORY.ref(2, r1 + 0xe).getUnsigned();
          r2 = CPU.lslT(r2, 3);
          r3 = CPU.addT(r3, r2);
          r2 = MEMORY.ref(4, 0x8018ee4).get();
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(2, r5 + 0x14).setu(r3);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r2 = CPU.lsrT(r3, 1);
          r2 = CPU.addT(r1, r2);
          r1 = CPU.r8().value;
          r3 = MEMORY.ref(2, r1 + 0xc).getUnsigned();
          r3 = CPU.lslT(r3, 3);
          r2 = CPU.addT(r2, r3);
          r3 = MEMORY.ref(4, 0x8018ed0).get();
          r2 = CPU.addT(r2, 0x2);
          r2 = CPU.orrT(r2, r3);
          MEMORY.ref(2, r5 + 0x16).setu(r2);
          r3 = MEMORY.ref(2, r4).getUnsigned();
          r3 += CPU.r10().value;
          r7 = CPU.addT(r5, 0x0);
          MEMORY.ref(2, r5 + 0x18).setu(r3);
          r7 = CPU.addT(r7, 0x10);
        }

        //LAB_8018eac
        r3 = CPU.movT(0, 0xfe);
        MEMORY.ref(1, r5 + 0xf).setu(r3);
        r3 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
        r3 = CPU.lslT(r3, 23);
        r3 = CPU.lsrT(r3, 23);
        MEMORY.ref(2, r5 + 0x6).setu(r3);
        r3 = MEMORY.ref(1, r7 + 0x4).getUnsigned();
        r2 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r5 + 0x8).setu(r3);
        r3 = CPU.r10().value;
        MEMORY.ref(1, r5 + 0xe).setu(r3);
        MEMORY.ref(4, r5).setu(r2);
        r0 = CPU.r8().value;
        r1 = CPU.addT(r5, 0x0);
        FUN_8016584(r0, r1);

        //LAB_8018ecc
        r0 = CPU.r9().value;
      }
    }

    //LAB_8018ee8
    CPU.sp().value += 0x90;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x801908c)
  public static void FUN_801908c(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    final int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);

    r6 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(1, r6 + 0x5).getUnsigned();
    r7 = CPU.movT(0, 0x80);
    r5 = CPU.addT(r6, 0x0);
    CPU.sp().value -= 0x8;
    r7 = CPU.lslT(r7, 1);
    r5 = CPU.addT(r5, 0x10);
    CPU.cmpT(r3, 0x9);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_80190b6
      r2 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r2, 0x1);
      MEMORY.ref(2, r6 + 0xc).setu(r3);
      r3 = CPU.movT(0, 0x1f);
      r1 = MEMORY.ref(4, 0x8019180).get();
      r3 = CPU.andT(r3, r2);
      r3 = CPU.lslT(r3, 1);
      r7 = MEMORY.ref(2, r1 + r3).getUnsigned();
    } else {
      CPU.cmpT(r3, 0x9);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        CPU.cmpT(r3, 0xa);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_80190c8
          r2 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
          r3 = CPU.addT(r2, 0x1);
          MEMORY.ref(2, r6 + 0xc).setu(r3);
          r3 = CPU.movT(0, 0x1f);
          r1 = MEMORY.ref(4, 0x8019180).get();
          r3 = CPU.andT(r3, r2);
          r3 = CPU.lslT(r3, 1);
          r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
          r7 = CPU.lsrT(r3, 1);
        } else {
          CPU.cmpT(r3, 0xb);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_80190da
            r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
            r0 = CPU.addT(r3, 0x0);
            CPU.cmpT(r0, 0x7);
            if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
              r3 = CPU.addT(r3, 0x1);
              r2 = MEMORY.ref(4, 0x8019180).get();
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.lslT(r0, 2);
              r3 = CPU.addT(r3, 0x20);
              r7 = MEMORY.ref(2, r2 + r3).getUnsigned();
            }
          } else {
            CPU.cmpT(r3, 0xc);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_80190f0
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r1 = CPU.addT(r3, 0x0);
              CPU.cmpT(r1, 0x7);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r3 = CPU.addT(r3, 0x1);
                r2 = MEMORY.ref(4, 0x8019180).get();
                MEMORY.ref(2, r6 + 0xc).setu(r3);
                r3 = CPU.lslT(r1, 2);
                r3 = CPU.addT(r3, 0x20);
                r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                r7 = CPU.lsrT(r3, 1);
              }
            }
          }
        }
      }
    }

    //LAB_8019106
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 1);
    CPU.r8().value = r3;
    CPU.cmpT(r7, CPU.r8().value);
    if(CPU.cpsr().getZero()) { // ==
      r2 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
      r3 = CPU.movT(0, 0x3f);
      r3 = CPU.negT(r3, r3);
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(1, r5 + 0x7).setu(r3);
      r2 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
      r3 = CPU.movT(0, 0x4);
      r3 = CPU.negT(r3, r3);
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(1, r5 + 0x5).setu(r3);
      r2 = MEMORY.ref(4, 0x80191c4).get();
      r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
      r2 = CPU.andT(r2, r3);
      r3 = MEMORY.ref(4, 0x80191c8).get();
      r3 = CPU.andT(r3, r1);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(2, r5 + 0x6).setu(r3);
      r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
    } else {
      //LAB_8019124
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      r4 = MEMORY.ref(4, 0x8019184).get();
      r2 = MEMORY.ref(4, 0x8019188).get();
      r1 = CPU.addT(r7, 0x0);
      r3 = CPU.andT(r3, r4);
      r3 = CPU.orrT(r3, r1);
      r3 = CPU.andT(r3, r2);
      r1 = CPU.lslT(r1, 16);
      r3 = CPU.orrT(r3, r1);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = CPU.sp().value;
      r3 = MEMORY.ref(4, r0 + 0x4).get();
      r3 = CPU.andT(r3, r4);
      MEMORY.ref(4, r0 + 0x4).setu(r3);
      r0 = FUN_8003d28(r0);
      r3 = CPU.movT(0, 0x1f);
      r0 = CPU.andT(r0, r3);
      r2 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
      r3 = CPU.movT(0, 0x3f);
      r3 = CPU.negT(r3, r3);
      r0 = CPU.lslT(r0, 1);
      r3 = CPU.andT(r3, r2);
      r3 = CPU.orrT(r3, r0);
      MEMORY.ref(1, r5 + 0x7).setu(r3);
      CPU.cmpT(r7, CPU.r8().value);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
        r2 = CPU.movT(0, 0x3);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(1, r5 + 0x5).setu(r3);
        r3 = MEMORY.ref(4, 0x801918c).get();
        r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r2 = CPU.addT(r2, r3);
        r3 = MEMORY.ref(4, 0x801917c).get();
        r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        r2 = CPU.andT(r2, r3);
        r3 = MEMORY.ref(4, 0x8019190).get();
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r5 + 0x6).setu(r3);
        r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
        r3 = CPU.addT(r3, 0xf8);
      } else {
        //LAB_8019194
        r2 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
        r3 = CPU.movT(0, 0x4);
        r3 = CPU.negT(r3, r3);
        r3 = CPU.andT(r3, r2);
        r2 = CPU.movT(0, 0x1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(1, r5 + 0x5).setu(r3);
        r2 = MEMORY.ref(4, 0x80191c4).get();
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        r2 = CPU.andT(r2, r3);
        r3 = MEMORY.ref(4, 0x80191c8).get();
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r5 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      }
    }

    //LAB_80191b4
    MEMORY.ref(1, r5 + 0x4).setu(r3);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();

    CPU.r8().value = r3;
  }

  @Method(0x80191cc)
  public static void FUN_80191cc() {
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

    r3 = MEMORY.ref(4, 0x8019270).get();
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.movT(0, 0xa0);
    CPU.r9().value = r3;
    r2 = CPU.lslT(r2, 3);
    r2 += CPU.r9().value;
    r3 = CPU.movT(0, 0x0);
    CPU.sp().value -= 0x18;
    CPU.r10().value = r2;
    CPU.r11().value = r3;

    //LAB_80191ee
    do {
      r3 = CPU.r10().value;
      r2 = MEMORY.ref(2, r3 + 0x16).getUnsigned();
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_80191fc
        r3 = MEMORY.ref(4, 0x8019274).get();
        r2 = CPU.r10().value;
        r3 = MEMORY.ref(4, r3).get();
        r6 = MEMORY.ref(4, r2).get();
        r0 = r3 >>> 2 & 0x7;

        //LAB_8019206
        while(r6 != 0) {
          r2 = CPU.r10().value;
          r3 = MEMORY.ref(2, r2 + 0x12).getUnsigned();
          r7 = CPU.addT(r6, 0x0);
          r7 = CPU.addT(r7, 0x10);
          CPU.cmpT(r3, 0x4);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.movT(0, 0x2);
            MEMORY.ref(2, r6 + 0xc).setu(r3);
            r3 = CPU.movT(0, 0x8);
            MEMORY.ref(1, r6 + 0x5).setu(r3);
          }

          //LAB_801921a
          r3 = MEMORY.ref(1, r6 + 0x5).getUnsigned();

          switch(r3) {
            case 2:
              r1 = MEMORY.ref(4, 0x80192d4).get();
              r1 += CPU.r9().value;
              r3 = MEMORY.ref(2, r1).getUnsigned();
              CPU.cmpT(r3, 0x60);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_8019288
                r3 = MEMORY.ref(4, 0x80192d8).get();
                r2 = CPU.lslT(r0, 7);
                r2 = CPU.addT(r2, r3);
                r0 = MEMORY.ref(2, r1).getUnsigned();
                r1 = CPU.movT(0, 0x80);
                r0 = FUN_8003fa4(r0, r1, r2);
                r3 = MEMORY.ref(4, 0x80192d0).get();
                r2 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
                r0 = CPU.andT(r0, r3);
                r3 = MEMORY.ref(4, 0x80192dc).get();
                r3 = CPU.andT(r3, r2);
                r3 = CPU.orrT(r3, r0);
                MEMORY.ref(2, r7 + 0x8).setu(r3);
                MEMORY.ref(1, r6 + 0xe).setu(r3);
                r3 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                r5 = CPU.movT(0, 0xd);
                r5 = CPU.negT(r5, r5);
                r5 = CPU.andT(r5, r3);
                r3 = CPU.movT(0, 0x11);
                r3 = CPU.negT(r3, r3);
                r5 = CPU.andT(r5, r3);
                r3 = CPU.movT(0, 0x20);
                r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
                r5 = CPU.orrT(r5, r3);
                r3 = CPU.movT(0, 0x3f);
                r4 = CPU.addT(r3, 0x0);
                r5 = CPU.andT(r5, r3);
                r3 = CPU.movT(0, 0x80);
                r4 = CPU.andT(r4, r2);
                r5 = CPU.orrT(r5, r3);
                MEMORY.ref(1, r7 + 0x7).setu(r4);
                MEMORY.ref(1, r7 + 0x5).setu(r5);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                CPU.r8().value = r3;
                r3 = MEMORY.ref(4, 0x8019374).get();
                r2 = MEMORY.ref(4, 0x8019378).get();
                r0 = MEMORY.ref(4, r3).get();
                r1 = CPU.movT(0, 0x50);
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                MEMORY.ref(4, CPU.sp().value).setu(r4);
                r0 = FUN_8002304(r0, r1);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
                r2 = CPU.r8().value;
                r3 = CPU.addT(r2, r3);
                r3 = CPU.addT(r3, 0x2);
                MEMORY.ref(1, r7 + 0x4).setu(r3);
                r3 = CPU.movT(0, 0x4);
                r3 = CPU.negT(r3, r3);
                r4 = MEMORY.ref(4, CPU.sp().value).get();
                r5 = CPU.andT(r5, r3);
                r3 = CPU.subT(r3, 0x3b);
                r3 = CPU.andT(r3, r4);
                MEMORY.ref(1, r7 + 0x5).setu(r5);
                MEMORY.ref(1, r7 + 0x7).setu(r3);
              }
              break;

            case 5:
              r3 = MEMORY.ref(4, 0x8019374).get();
              r3 = MEMORY.ref(4, r3).get();
              r2 = CPU.movT(0, 0x1);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_801931e
                r0 = FUN_8004458();
                r5 = CPU.addT(r0, 0x0);
                r0 = FUN_8004458();
                r2 = CPU.lslT(r5, 1);
                r3 = CPU.lslT(r0, 1);
                r2 = CPU.addT(r2, r5);
                r3 = CPU.addT(r3, r0);
                r3 = CPU.lsrT(r3, 16);
                r2 = CPU.lsrT(r2, 16);
                r1 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r2 = CPU.addT(r2, r3);
                r2 = CPU.lsrT(r2, 1);
                r1 = CPU.addT(r1, r2);
                r3 = MEMORY.ref(4, 0x8019370).get();
                r1 = CPU.subT(r1, 0x1);
                r1 = CPU.andT(r1, r3);
                r2 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r3 = MEMORY.ref(4, 0x801937c).get();
                r3 = CPU.andT(r3, r2);
                r3 = CPU.orrT(r3, r1);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r0 = FUN_8004458();
                r5 = CPU.addT(r0, 0x0);
                r0 = FUN_8004458();
                r2 = CPU.lslT(r5, 1);
                r3 = CPU.lslT(r0, 1);
                r2 = CPU.addT(r2, r5);
                r3 = CPU.addT(r3, r0);
                r2 = CPU.lsrT(r2, 16);
                r3 = CPU.lsrT(r3, 16);
                r1 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r2 = CPU.addT(r2, r3);
                r2 = CPU.lsrT(r2, 1);
                r1 = CPU.addT(r1, r2);
                r1 = CPU.subT(r1, 0x1);
                MEMORY.ref(1, r7 + 0x4).setu(r1);
              }
              break;

            case 6:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
                r3 = CPU.movT(0, 0x3f);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(1, r7 + 0x7).setu(r3);
                r2 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                r3 = CPU.movT(0, 0x4);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(1, r7 + 0x5).setu(r3);
                r2 = MEMORY.ref(4, 0x801963c).get();
                r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, r3);
                r3 = MEMORY.ref(4, 0x8019640).get();
                r3 = CPU.andT(r3, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
                MEMORY.ref(1, r7 + 0x4).setu(r3);
              } else {
                //LAB_8019388
                r1 = MEMORY.ref(4, 0x80193ec).get();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                r2 = CPU.movT(0, 0x80);
                r3 = CPU.andT(r3, r1);
                r2 = CPU.lslT(r2, 2);
                r5 = MEMORY.ref(4, 0x80193f0).get();
                r3 = CPU.orrT(r3, r2);
                r2 = CPU.movT(0, 0x80);
                r2 = CPU.lslT(r2, 18);
                r3 = CPU.andT(r3, r5);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
                r0 = CPU.sp().value + 0x10;
                r3 = MEMORY.ref(4, r0 + 0x4).get();
                r3 = CPU.andT(r3, r1);
                MEMORY.ref(4, r0 + 0x4).setu(r3);
                r0 = FUN_8003d28(r0);
                r3 = CPU.movT(0, 0x1f);
                r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
                r0 = CPU.andT(r0, r3);
                r3 = CPU.movT(0, 0x3f);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                r0 = CPU.lslT(r0, 1);
                r3 = CPU.orrT(r3, r0);
                MEMORY.ref(1, r7 + 0x7).setu(r3);
                r3 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                r2 = CPU.movT(0, 0x3);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(1, r7 + 0x5).setu(r3);
                r3 = MEMORY.ref(4, 0x80193f4).get();
                r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r2 = CPU.addT(r2, r3);
                r3 = MEMORY.ref(4, 0x80193e8).get();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, r3);
                r3 = MEMORY.ref(4, 0x80193f8).get();
                r3 = CPU.andT(r3, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r3 = CPU.addT(r3, 0xfb);
                MEMORY.ref(1, r7 + 0x4).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, r5);
                MEMORY.ref(2, r6 + 0xc).setu(r3);
              }
              break;

            case 7:
              r3 = CPU.movT(0, 0x80);
              r5 = CPU.sp().value + 0x10;
              r3 = CPU.lslT(r3, 1);
              MEMORY.ref(2, r5).setu(r3);
              MEMORY.ref(2, r5 + 0x2).setu(r3);
              r2 = CPU.movT(0, 0xc0);
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r2 = CPU.lslT(r2, 2);
              r3 = CPU.addT(r3, r2);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              MEMORY.ref(2, r5 + 0x4).setu(r3);
              r0 = CPU.addT(r5, 0x0);
              r0 = FUN_8003d28(r0);
              r3 = CPU.movT(0, 0x1f);
              r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
              r0 = CPU.andT(r0, r3);
              r3 = CPU.movT(0, 0x3f);
              r3 = CPU.negT(r3, r3);
              r0 = CPU.lslT(r0, 1);
              r3 = CPU.andT(r3, r2);
              r3 = CPU.orrT(r3, r0);
              r2 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
              MEMORY.ref(1, r7 + 0x7).setu(r3);
              r3 = CPU.movT(0, 0x4);
              r3 = CPU.negT(r3, r3);
              r3 = CPU.andT(r3, r2);
              r2 = CPU.movT(0, 0x1);
              r3 = CPU.orrT(r3, r2);
              MEMORY.ref(1, r7 + 0x5).setu(r3);
              r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
              r3 = CPU.movT(0, 0xe8);
              r3 = CPU.lslT(r3, 8);
              r0 = CPU.addT(r0, r3);
              r0 = FUN_8002322(r0);
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r0 = CPU.asrT(r0, 14);
              r2 = CPU.subT(r2, r0);
              r3 = MEMORY.ref(4, 0x8019474).get();
              r2 = CPU.subT(r2, 0x2);
              r2 = CPU.andT(r2, r3);
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r3 = MEMORY.ref(4, 0x8019478).get();
              r3 = CPU.andT(r3, r1);
              r3 = CPU.orrT(r3, r2);
              r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
              r2 = CPU.movT(0, 0xd0);
              r2 = CPU.lslT(r2, 7);
              MEMORY.ref(2, r7 + 0x6).setu(r3);
              r0 = CPU.addT(r0, r2);
              r0 = FUN_800231c(r0);
              r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r0 = CPU.asrT(r0, 14);
              r3 = CPU.subT(r3, r0);
              r3 = CPU.subT(r3, 0x2);
              MEMORY.ref(1, r7 + 0x4).setu(r3);
              break;

            case 4:
              r3 = MEMORY.ref(4, 0x80194d4).get();
              r3 = MEMORY.ref(4, r3).get();
              r2 = CPU.movT(0, 0x1);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, 0x1);
                MEMORY.ref(2, r6 + 0xc).setu(r3);
              }

              //LAB_801948e
              r4 = MEMORY.ref(4, 0x80194d8).get();
              r0 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r1 = CPU.movT(0, 0x14);
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              r0 = FUN_8002304(r0, r1);
              r4 = MEMORY.ref(4, CPU.sp().value).get();
              r0 = CPU.lslT(r0, 16);
              r0 = CPU.lsrT(r0, 15);
              r3 = MEMORY.ref(1, r4 + r0).get();
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r2 = CPU.addT(r2, r3);
              r3 = MEMORY.ref(4, 0x80194d0).get();
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r2 = CPU.andT(r2, r3);
              r3 = MEMORY.ref(4, 0x80194dc).get();
              r3 = CPU.andT(r3, r1);
              r3 = CPU.orrT(r3, r2);
              MEMORY.ref(2, r7 + 0x6).setu(r3);
              r1 = CPU.movT(0, 0x14);
              r0 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r0 = FUN_8002304(r0, r1);
              r0 = CPU.lslT(r0, 16);
              r0 = CPU.lsrT(r0, 15);
              r4 = MEMORY.ref(4, CPU.sp().value).get();
              r0 = CPU.addT(r0, 0x1);
              r5 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, r4 + r0).getUnsigned();
              r5 = CPU.addT(r5, r3);
              r5 = CPU.subT(r5, 0x2);
              MEMORY.ref(1, r7 + 0x4).setu(r5);
              break;

            case 0x11:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r0 = MEMORY.ref(4, 0x8019540).get();
              r3 = CPU.addT(r3, 0x1);
              r2 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r2);
              r1 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, r0 + r3).getUnsigned();
              r1 = CPU.subT(r1, r3);
              MEMORY.ref(1, r7 + 0x4).setu(r1);
              break;

            case 0xe:
            case 0xf:
            case 0x10:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r0 = MEMORY.ref(4, 0x8019540).get();
              r3 = CPU.addT(r3, 0x1);
              r2 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r2);
              r1 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, r0 + r3).getUnsigned();
              r1 = CPU.addT(r1, r3);
              MEMORY.ref(1, r7 + 0x4).setu(r1);
              break;

            case 0x12:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r4 = MEMORY.ref(4, 0x8019540).get();
              r3 = CPU.addT(r3, 0x1);
              r0 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r0);
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r3 = MEMORY.ref(1, r4 + r3).get();
              r2 = CPU.subT(r2, r3);
              r3 = MEMORY.ref(4, 0x801953c).get();
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r2 = CPU.andT(r2, r3);
              r3 = MEMORY.ref(4, 0x8019544).get();
              r3 = CPU.andT(r3, r1);
              r3 = CPU.orrT(r3, r2);
              MEMORY.ref(2, r7 + 0x6).setu(r3);
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r0 = CPU.andT(r0, r3);
              r2 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, r4 + r0).getUnsigned();
              r2 = CPU.addT(r2, r3);
              MEMORY.ref(1, r7 + 0x4).setu(r2);
              break;

            case 8:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = CPU.movT(0, 0xa0);
                r3 = CPU.lslT(r3, 1);
                r0 = CPU.sp().value + 0x10;
                r2 = CPU.movT(0, 0x0);
                MEMORY.ref(2, r0).setu(r3);
                MEMORY.ref(2, r0 + 0x2).setu(r3);
                MEMORY.ref(2, r0 + 0x4).setu(r2);
                r0 = FUN_8003d28(r0);
                r3 = CPU.movT(0, 0x1f);
                r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
                r0 = CPU.andT(r0, r3);
                r3 = CPU.movT(0, 0x3f);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                r0 = CPU.lslT(r0, 1);
                r3 = CPU.orrT(r3, r0);
                MEMORY.ref(1, r7 + 0x7).setu(r3);
                r3 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                r2 = CPU.movT(0, 0x3);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(1, r7 + 0x5).setu(r3);
                r3 = MEMORY.ref(4, 0x80195a4).get();
                r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r2 = CPU.addT(r2, r3);
                r3 = MEMORY.ref(4, 0x80195a0).get();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, r3);
                r3 = MEMORY.ref(4, 0x80195a8).get();
                r3 = CPU.andT(r3, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r3 = CPU.addT(r3, 0xf8);
                MEMORY.ref(1, r7 + 0x4).setu(r3);
                r2 = MEMORY.ref(4, 0x80195ac).get();
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(2, r6 + 0xc).setu(r3);
              } else {
                //LAB_80195b0
                r2 = MEMORY.ref(1, r7 + 0x7).getUnsigned();
                r3 = CPU.movT(0, 0x3f);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(1, r7 + 0x7).setu(r3);
                r2 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                r3 = CPU.movT(0, 0x4);
                r3 = CPU.negT(r3, r3);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(1, r7 + 0x5).setu(r3);
                r2 = MEMORY.ref(4, 0x801963c).get();
                r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, r3);
                r3 = MEMORY.ref(4, 0x8019640).get();
                r3 = CPU.andT(r3, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
                MEMORY.ref(1, r7 + 0x4).setu(r3);
              }
              break;

            case 9:
            case 0xa:
            case 0xb:
            case 0xc:
              r0 = CPU.addT(r6, 0x0);
              FUN_801908c(r0);
              break;
          }

          //default/end
          //LAB_80195e0
          r3 = MEMORY.ref(1, r6 + 0x5).getUnsigned();
          CPU.cmpT(r3, 0x2);
          if(CPU.cpsr().getZero()) { // ==
            r3 = MEMORY.ref(4, 0x8019644).get();
            r3 += CPU.r9().value;
            r3 = MEMORY.ref(2, r3).getUnsigned();
            CPU.cmpT(r3, 0x60);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = MEMORY.ref(1, r6 + 0xf).getUnsigned();
              r0 = CPU.addT(r7, 0x0);
              FUN_8003dec(r0, r1);
            }
          } else {
            //LAB_80195fa
            CPU.cmpT(r3, 0xd);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = MEMORY.ref(1, r6 + 0xf).getUnsigned();
              r0 = CPU.addT(r7, 0x0);
              FUN_8003dec(r0, r1);
            }
          }

          //LAB_8019606
          r3 = MEMORY.ref(4, 0x8019648).get();
          r3 = MEMORY.ref(4, r3).get();
          r6 = MEMORY.ref(4, r6).get();

          //LAB_801960c
          r0 = r3 >>> 2 & 0x7;
        }
      }

      //LAB_8019618
      r2 = CPU.movT(0, 0x1);
      r3 = CPU.movT(0, 0x24);
      CPU.r11().value += r2;
      CPU.r10().value += r3;
      r3 = CPU.r11().value;
      CPU.cmpT(r3, 0x8);
    } while(!CPU.cpsr().getZero()); // !=

    //LAB_8019628
    CPU.sp().value += 0x18;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x801964c)
  public static void FUN_801964c(final int r0, final int r1) {
    FUN_80196c4(r0, r1, MEMORY.ref(4, 0x8019658).get());
  }


  @Method(0x80196c4)
  public static void FUN_80196c4(int r0, int r1, int r2) {
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.getAddress() + 0xc8;
    r7 = r2;
    r2 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r2;
    CPU.r8().value = r3;
    r3 = CPU.r10().value;
    CPU.sp().value -= 0xc;
    CPU.r9().value = r0;
    r6 = r1;

    if(r3 == 0) {
      r5 = 0x140;
      r1 = FUN_80048b0(0x32, r5);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

      MEMORY.setFunction(r1, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r3 = MEMORY.ref(4, CPU.r8().value).get();
    }

    //LAB_8019706
    r5 = CPU.sp().value;
    r1 = CPU.r9().value;
    r0 = CPU.addT(r5, 0x0);
    CPU.r8().value = r3;
    FUN_8019bac(r0, r1);
    r3 = MEMORY.ref(4, 0x80197b0).get();
    CPU.r9().value = r3;

    //LAB_8019770
    r0 = (int)MEMORY.call(CPU.r8().value, r5);

    //LAB_8019718
    while(r0 != 0) {
      if(r0 == 0xe) {
        //LAB_8019730
        r7 = CPU.subT(r7, 0x3);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r6 = CPU.addT(r6, 0x2);
        r0 += CPU.r9().value;
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r6 = CPU.addT(r6, 0x2);
        r0 += CPU.r9().value;
        //LAB_801972a
      } else if(r0 >= 0x8 && r0 <= 0xc || r0 == 0xf) {
        //LAB_8019750
        r7 = CPU.subT(r7, 0x1);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r2 = MEMORY.ref(4, 0x80197b0).get();
        r6 = CPU.addT(r6, 0x2);
        r0 = CPU.addT(r0, r2);
      } else {
        //LAB_8019766
        r7 = CPU.subT(r7, 0x1);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
      }

      //LAB_801976c
      MEMORY.ref(2, r6).setu(r0);
      r6 = CPU.addT(r6, 0x2);

      r0 = (int)MEMORY.call(CPU.r8().value, r5);
    }

    //LAB_801977a
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x32);
      FUN_8002dd8(r0);
    }

    //LAB_8019786
    CPU.sp().value += 0xc;
    MEMORY.ref(2, r6).setu(0);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8019854)
  public static void FUN_8019854(int r0) {
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

    r5 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(4, r5).get();
    r1 = MEMORY.ref(2, r3 + 0xc).getUnsigned();
    CPU.r9().value = r1;
    r1 = MEMORY.ref(2, r3 + 0xe).getUnsigned();
    CPU.r11().value = r1;
    r1 = MEMORY.ref(2, r3 + 0x8).getUnsigned();
    CPU.sp().value -= 0x8;
    r2 = MEMORY.ref(2, r3 + 0x12).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    r3 = MEMORY.ref(2, r3 + 0xa).getUnsigned();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    CPU.cmpT(r2, 0x4);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.addT(r1, 0x2);
      r6 = CPU.r9().value;
      r7 = CPU.r11().value;
      CPU.r8().value = r1;
      r6 = CPU.subT(r6, 0x1);
      r7 = CPU.subT(r7, 0x1);
      r3 = CPU.addT(r3, 0x2);
      r2 = CPU.r8().value;
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.addT(r7, 0x0);
      CPU.r10().value = r3;
      FUN_80170f8(r0, r1, r2, r3);
      r3 = MEMORY.ref(2, r5 + 0x14).getUnsigned();
      r2 = MEMORY.ref(4, 0x80198d8).get();
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r5 + 0x14).setu(r3);
      r3 = CPU.lslT(r3, 16);
      r2 = CPU.lsrT(r3, 16);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r5).get();
        r0 = CPU.addT(r6, 0x0);
        MEMORY.ref(2, r3 + 0x12).setu(r2);
        r1 = CPU.addT(r7, 0x0);
        r2 = CPU.r8().value;
        r3 = CPU.r10().value;
        FUN_8016178(r0, r1, r2, r3);
        r0 = CPU.r9().value;
        r1 = CPU.r11().value;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = MEMORY.ref(4, CPU.sp().value).get();
        FUN_80170f8(r0, r1, r2, r3);
      }
    }

    //LAB_80198c4
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

  @Method(0x8019bac)
  public static void FUN_8019bac(final int r0, final int r1) {
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    CPU.r10().value = r1;
    final int size = 0x60;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8015570);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8015570.class, "FUN_8015570", int.class, int.class);
    MEMORY.call(addr, CPU.r8().value, CPU.r10().value);
    FUN_8002df0(addr);

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8019d0c)
  public static void FUN_8019d0c() {
    int r0;
    int r1;
    final int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8019d24).get();
    r0 = MEMORY.ref(4, 0x8019d28).get();
    r3 = MEMORY.ref(4, r3).get();
    r2 = MEMORY.ref(4, 0x8019d20).get();
    r1 = CPU.addT(r3, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r1).setu(r2);
    r1 = CPU.addT(r3, r0);
    MEMORY.ref(2, r1).setu(r2);
  }

  @Method(0x8019d2c)
  public static int FUN_8019d2c(final int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;

    r1 = CPU.movT(0, 0x1);
    r1 = CPU.negT(r1, r1);
    r2 = CPU.movT(0, 0x0);
    CPU.cmpT(r0, 0x13);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r4 = MEMORY.ref(4, 0x8019da0).get();
      r5 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r4 + r5).get();
      r3 = CPU.cmpT(r3, r1);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.cmpT(r3, r0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x2);
          r1 = MEMORY.ref(2, r4 + r2).get();
        } else {
          //LAB_8019d4c
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = CPU.lslT(r2, 1);
            r3 = MEMORY.ref(2, r4 + r3).get();
            r5 = CPU.movT(0, 0x1);
            r5 = CPU.negT(r5, r5);
            r3 = CPU.cmpT(r3, r5);
            if(CPU.cpsr().getZero()) { // ==
              return r1;
            }
            r3 = CPU.cmpT(r3, r0);
          } while(!CPU.cpsr().getZero()); // !=

          r2 = CPU.addT(r2, 0x1);
          r3 = CPU.lslT(r2, 1);
          r1 = MEMORY.ref(2, r4 + r3).get();
        }
      }
    } else {
      //LAB_8019d66
      r4 = MEMORY.ref(4, 0x8019da4).get();
      r5 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r4 + r5).get();
      r5 = CPU.movT(0, 0x1);
      r5 = CPU.negT(r5, r5);
      r3 = CPU.cmpT(r3, r5);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.cmpT(r3, r0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x2);
          r1 = MEMORY.ref(2, r4 + r2).get();
        } else {
          //LAB_8019d7e
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = CPU.lslT(r2, 1);
            r3 = MEMORY.ref(2, r4 + r3).get();
            r5 = CPU.movT(0, 0x1);
            r5 = CPU.negT(r5, r5);
            r3 = CPU.cmpT(r3, r5);
            if(CPU.cpsr().getZero()) { // ==
              return r1;
            }
            r3 = CPU.cmpT(r3, r0);
          } while(!CPU.cpsr().getZero()); // !=

          r2 = CPU.addT(r2, 0x1);
          r3 = CPU.lslT(r2, 1);
          r1 = MEMORY.ref(2, r4 + r3).get();
        }

        //LAB_8019d96
        r1 = CPU.addT(r1, 0x80);
      }
    }

    //LAB_8019d98
    return r1;
  }

  @Method(0x8019da8)
  public static int FUN_8019da8(int r0, int r1, int r2, int r3) {
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x8019e40).get();
    r6 = CPU.addT(r2, 0x0);
    CPU.sp().value -= 0x8;
    CPU.r10().value = r0;
    CPU.r11().value = r1;
    r5 = MEMORY.ref(4, r3).get();
    r0 = FUN_8019d2c(r0);
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.negT(r2, r2);
    r0 = CPU.cmpT(r0, r2);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_8019dd4
      r3 = CPU.movT(0, 0x4);
      r2 = MEMORY.ref(4, 0x8019e44).get();
      r3 = CPU.negT(r3, r3);
      CPU.r9().value = r3;
      r3 = CPU.addT(r5, r2);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.r8().value = CPU.r9().value;
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = FUN_80162d4(r6, r7, 0x6, 0x5, 0x2);
        CPU.r8().value = 0;
      } else {
        //LAB_8019dfe
        r5 = FUN_80162d4(r6, r7, 0x5, 0x5, 0x2);
      }

      //LAB_8019e10
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.r8().value;
        r2 = CPU.movT(0, 0x1);
        MEMORY.ref(4, CPU.sp().value).setu(r3);
        r3 = CPU.r9().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
        r2 = CPU.negT(r2, r2);
        r0 = CPU.r10().value;
        r1 = CPU.r11().value;
        r3 = CPU.addT(r5, 0x0);
        FUN_801ec6c(r0, r1, r2, r3);
      }

      //LAB_8019e2a
      r0 = CPU.addT(r5, 0x0);
    }

    //LAB_8019e2c
    CPU.sp().value += 0x8;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r0;
  }

  @Method(0x8019e48)
  public static void FUN_8019e48(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    final int r6;

    r3 = MEMORY.ref(4, 0x8019eac).get();
    r2 = CPU.movT(0, 0xa0);
    r6 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 3);
    r5 = CPU.addT(r6, r2);
    r0 = FUN_8019d2c(r0);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r0 = CPU.cmpT(r0, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(4, 0x8019eb0).get();
      r3 = CPU.addT(r6, r2);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r3 = CPU.cmpT(r3, r0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0x1);
      } else {
        //LAB_8019e78
        r2 = MEMORY.ref(4, 0x8019eb4).get();
        r3 = CPU.addT(r6, r2);
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r3 = CPU.cmpT(r3, r0);
        if(!CPU.cpsr().getZero()) { // !=
          return;
        }
        r3 = CPU.movT(0, 0x0);
      }

      //LAB_8019e84
      r2 = MEMORY.ref(4, 0x8019eb8).get();
      r3 = CPU.lslT(r3, 1);
      r3 = CPU.addT(r3, r2);
      r0 = MEMORY.ref(2, r6 + r3).getUnsigned();
      r1 = CPU.movT(0, 0x0);

      //LAB_8019e8e
      do {
        r2 = MEMORY.ref(4, r5).get();
        r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
        CPU.cmpT(r3, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(1, r2 + 0xe).getUnsigned();
          r3 = CPU.cmpT(r3, r0);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_8019e6e
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.movT(0, 0x2);
            FUN_8016418(r0, r1);
            break;
          }
        }

        //LAB_8019e9c
        r1 = CPU.addT(r1, 0x1);
        r5 = CPU.addT(r5, 0x24);
        CPU.cmpT(r1, 0x8);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8019ea4
  }

  @Method(0x801a4fc)
  public static void FUN_801a4fc(int r0, int r1, int r2, int r3) {
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    r1 = CPU.movT(0, 0xc1);
    r5 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 3);
    r0 = CPU.movT(0, 0x11);
    CPU.r8().value = r3;
    r7 = CPU.addT(r2, 0x0);
    r0 = FUN_80048b0(r0, r1);
    r6 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x801a58c).get();
    r0 = getPointerTableEntry(r0);
    r3 = CPU.addT(r5, 0x0);
    CPU.cmpT(r5, 0x7f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r3 = CPU.subT(r3, 0x70);
    }

    //LAB_801a522
    r3 = CPU.lslT(r3, 1);
    r3 = MEMORY.ref(2, r3 + r0).getUnsigned();
    r1 = MEMORY.ref(4, 0x801a590).get();
    r5 = CPU.addT(r0, r3);
    r3 = CPU.addT(r5, 0x0);
    r2 = CPU.addT(r6, r1);
    r3 = CPU.addT(r3, 0x20);
    MEMORY.ref(4, r2).setu(r3);
    r2 = CPU.movT(0, 0xc0);
    r2 = CPU.lslT(r2, 3);
    r3 = CPU.addT(r6, r2);
    r1 = CPU.subT(r1, 0x2);
    r2 = CPU.movT(0, 0x4);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r6, r1);
    MEMORY.ref(2, r3).setu(r2);
    r0 = CPU.addT(r6, 0x0);
    r1 = CPU.movT(0, 0x0);
    FUN_801a5a4(r0, r1);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_8004080();
      MEMORY.ref(4, r7).setu(r0);
    }

    //LAB_801a556
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 3);
    r1 = CPU.movT(0, 0x80);
    r2 = CPU.addT(r6, r3);
    r0 = MEMORY.ref(4, r7).get();
    r1 = CPU.lslT(r1, 2);
    r0 = FUN_8003fa4(r0, r1, r2);
    r1 = CPU.r8().value;
    MEMORY.ref(4, r1).setu(r0);
    r0 = CPU.movT(0, 0x11);
    FUN_8002dd8(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = MEMORY.ref(4, 0x801a594).get();
    r1 = CPU.lslT(r1, 5);
    r1 = CPU.addT(r1, r2);
    r3 = MEMORY.ref(4, 0x801a598).get();
    r0 = CPU.addT(r5, 0x0);
    r2 = MEMORY.ref(4, 0x801a59c).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);

    CPU.r8().value = CPU.pop();
  }

  @Method(0x801a5a4)
  public static void FUN_801a5a4(final int r0, final int r1) {
    final int size = 0x278;
    DMA.channels[3].SAD.setu(0x8015afc);
    DMA.channels[3].DAD.setu(FUN_80048b0(0x31, size));
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(MEMORY.ref(4, 0x3001f14).get(), CopiedSegment8015afc.class, "FUN_8015afc", int.class, int.class);
    MEMORY.call(MEMORY.ref(4, 0x3001f14).get(), MEMORY.ref(4, r0 + 0x604).get(), r0);
    FUN_8002dd8(0x31);

    final int addr;
    final int r5;
    if(r1 != 0) {
      addr = 0x8015d74;
      r5 = 0x9c;
    } else {
      //LAB_801a5fe
      addr = 0x8015e10;
      r5 = 0x7c;
    }

    //LAB_801a612
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(FUN_80048b0(0x31, r5));
    DMA.channels[3].CNT.setu(0x84000000 | r5 / 4);

    MEMORY.setFunction(MEMORY.ref(4, 0x3001f14).get(), CopiedSegment_8015d74_8015e10.class, "FUN_%x".formatted(addr), int.class, int.class, int.class, int.class);
    MEMORY.call(MEMORY.ref(4, 0x3001f14).get(), r0, r0 + 0x400, MEMORY.ref(2, r0 + 0x600).getUnsigned(), MEMORY.ref(2, r0 + 0x602).getUnsigned());
    FUN_8002dd8(0x31);
  }

  @Method(0x801cc50)
  public static int FUN_801cc50(int r0, int r1, int r2, int r3) {
    final int r4;
    final int r5;
    int r6;
    int r7;

    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r2, 0x0);
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r4 = 0x3000118;
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc64;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r7 = CPU.asrT(r0, 16);
    r2 = CPU.movT(0, 0x2);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r1 = CPU.addT(r6, 0x0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc74;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r6 = CPU.asrT(r0, 16);
    r2 = CPU.movT(0, 0x4);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r1 = CPU.addT(r3, 0x0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc84;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r0 = CPU.asrT(r0, 16);
    CPU.cmpT(r7, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.movT(0, 0x0);
    }

    //LAB_801cc8c
    CPU.cmpT(r7, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.movT(0, 0x1f);
    }

    //LAB_801cc92
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r6 = CPU.movT(0, 0x0);
    }

    //LAB_801cc98
    CPU.cmpT(r6, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r6 = CPU.movT(0, 0x1f);
    }

    //LAB_801cc9e
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_801cca4
    CPU.cmpT(r0, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.movT(0, 0x1f);
    }

    //LAB_801ccaa
    r3 = CPU.lslT(r6, 5);
    r0 = CPU.lslT(r0, 10);
    r0 = CPU.addT(r0, r3);
    r0 = CPU.addT(r7, r0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x801ccc0)
  public static void FUN_801ccc0(int r0, int r1) {
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

    r6 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r0, 0xc);
    r1 = CPU.movT(0, 0x18);
    CPU.sp().value -= 0x8;
    r0 = FUN_80022fc(r0, r1);
    r5 = CPU.addT(r0, 0x0);
    r5 = CPU.lslT(r5, 18);
    r5 = CPU.asrT(r5, 16);
    r2 = MEMORY.ref(4, 0x801cdec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    CPU.r8().value = r2;
    r0 = FUN_80022fc(r0, r1);
    r0 = CPU.lslT(r0, 16);
    r2 = CPU.r8().value;
    r0 = CPU.asrT(r0, 16);
    r6 = CPU.subT(r6, 0x7);
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r6 = CPU.lslT(r6, 16);
    r6 = CPU.asrT(r6, 16);
    r3 = CPU.addT(r3, r6);
    r0 = CPU.addT(r5, 0x0);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r1 = CPU.movT(0, 0x60);
    r0 = CPU.addT(r0, 0x20);
    CPU.r10().value = r3;
    r0 = FUN_80022fc(r0, r1);
    r2 = CPU.r8().value;
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r5 = CPU.addT(r5, 0x40);
    r3 = CPU.addT(r3, r6);
    r3 = CPU.lslT(r3, 16);
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    r7 = CPU.asrT(r3, 16);
    r0 = FUN_80022fc(r0, r1);
    r2 = CPU.r8().value;
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r3 = CPU.addT(r3, r6);
    r3 = CPU.lslT(r3, 16);
    r2 = CPU.r10().value;
    r3 = CPU.asrT(r3, 16);
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = CPU.movT(0, 0x0);
      CPU.r10().value = r2;
    }

    //LAB_801cd30
    r2 = CPU.r10().value;
    CPU.cmpT(r2, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r2 = CPU.movT(0, 0x1f);
      CPU.r10().value = r2;
    }

    //LAB_801cd3a
    CPU.cmpT(r7, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.movT(0, 0x0);
    }

    //LAB_801cd40
    CPU.cmpT(r7, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.movT(0, 0x1f);
    }

    //LAB_801cd46
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
    }

    //LAB_801cd4c
    CPU.cmpT(r3, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x1f);
    }

    //LAB_801cd52
    r5 = CPU.sp().value;
    MEMORY.ref(2, r5 + 0x4).setu(r3);
    r3 = MEMORY.ref(4, 0x801cdf0).get();
    r2 = CPU.r10().value;
    MEMORY.ref(2, r5).setu(r2);
    CPU.r10().value = r3;
    r2 = MEMORY.ref(4, 0x801cdf4).get();
    r1 = CPU.r10().value;
    MEMORY.ref(2, r5 + 0x2).setu(r7);
    r3 = MEMORY.ref(4, 0x801cdf8).get();
    r0 = CPU.addT(r5, 0x0);
    CPU.r9().value = r2;
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r6 = MEMORY.ref(4, 0x801cdfc).get();
    r3 = MEMORY.ref(4, 0x801ce00).get();
    r2 = CPU.addT(r6, 0x0);
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce04).get();
    r3 = CPU.r10().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce08).get();
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x801ce0c).get();
    CPU.r8().value = r3;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.r8().value;
    r3 = CPU.r9().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce10).get();
    r1 = MEMORY.ref(4, 0x801ce14).get();
    MEMORY.ref(2, r3).setu(r0);
    r2 = MEMORY.ref(4, 0x801ce18).get();
    r3 = CPU.r8().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce1c).get();
    r1 = MEMORY.ref(4, 0x801ce20).get();
    MEMORY.ref(2, r3).setu(r0);
    r2 = MEMORY.ref(4, 0x801ce24).get();
    r3 = MEMORY.ref(4, 0x801ce28).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce2c).get();
    r2 = CPU.r10().value;
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce30).get();
    r3 = MEMORY.ref(4, 0x801ce34).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce38).get();
    r2 = CPU.movT(0, 0x80);
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce3c).get();
    r2 = CPU.lslT(r2, 9);
    r3 = MEMORY.ref(4, 0x801ce40).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce44).get();
    CPU.sp().value += 0x8;
    MEMORY.ref(2, r3).setu(r0);
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x801e260)
  public static void FUN_801e260(int r0, int r1, int r2, int r3) {
    int r4;
    final int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r11().value = r3;
    r3 = MEMORY.ref(4, 0x801e304).get();
    r7 = CPU.addT(r2, 0x0);
    r5 = MEMORY.ref(4, r3).get();
    r2 = MEMORY.ref(4, 0x801e308).get();
    r1 = CPU.lslT(r1, 5);
    r3 = CPU.addT(r5, r2);
    r1 = CPU.addT(r1, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r1 = CPU.lslT(r1, 1);
    r6 = CPU.movT(0, 0x0);
    CPU.sp().value -= 0x4;
    r0 = CPU.addT(r1, r5);
    CPU.r8().value = r3;
    CPU.cmpT(r6, CPU.r11().value);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r3 = CPU.movT(0, 0x20);
      r3 = CPU.subT(r3, r7);
      r3 = CPU.lslT(r3, 1);
      MEMORY.ref(4, CPU.sp().value).setu(r3);

      //LAB_801e296
      do {
        r4 = CPU.movT(0, 0x0);
        r4 = CPU.cmpT(r4, r7);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          r3 = MEMORY.ref(4, 0x801e30c).get();
          r2 = MEMORY.ref(4, 0x801e310).get();
          CPU.r9().value = r3;
          r3 = MEMORY.ref(4, 0x801e314).get();
          CPU.r10().value = r2;
          r2 = CPU.movT(0, 0xff);
          CPU.lr().value = r3;
          CPU.r12().value = r2;

          //LAB_801e2ac
          do {
            r3 = MEMORY.ref(2, r0).getUnsigned();
            r2 = CPU.r9().value;
            r2 = CPU.andT(r2, r3);
            r3 = CPU.addT(r2, 0x0);
            r3 = CPU.subT(r3, 0x80);
            r0 = CPU.addT(r0, 0x2);
            if(r3 < 0x80 || CPU.r8().value != 0 && (r2 & 0xffff_ffffL) > (CPU.r10().value & 0xffff_ffffL) && (r2 & 0xffff_ffffL) <= (CPU.lr().value & 0xffff_ffffL)) {
              //LAB_801e2ca
              r3 = CPU.r12().value;
              r2 = CPU.andT(r2, r3);
              r3 = CPU.movT(0, 0x80);
              r2 = CPU.eorT(r2, r3);
              r3 = CPU.movT(0, 0xda);
              r3 = CPU.lslT(r3, 4);
              r2 = CPU.addT(r2, r3);
              r1 = MEMORY.ref(1, r5 + r2).getUnsigned();
              r3 = CPU.movT(0, 0xfc);
              r3 = CPU.andT(r3, r1);
              MEMORY.ref(1, r5 + r2).setu(r3);
            }

            //LAB_801e2e0
            r4 = CPU.addT(r4, 0x1);
            r4 = CPU.cmpT(r4, r7);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }

        //LAB_801e2e6
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        r6 = CPU.addT(r6, 0x1);
        r0 = CPU.addT(r0, r2);
        CPU.cmpT(r6, CPU.r11().value);
      } while(!CPU.cpsr().getCarry()); // unsigned <
    }

    //LAB_801e2f0
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x801e41c)
  public static void FUN_801e41c(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    final int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r10().value = r3;
    r3 = MEMORY.ref(4, 0x801e6d0).get();
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r1, 0x0);
    r5 = CPU.addT(r0, 0x0);
    CPU.r8().value = r2;
    r6 = a4;
    CPU.r9().value = r3;
    CPU.cmpT(r7, CPU.r10().value);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_801e43c
      CPU.cmpT(CPU.r8().value, r6);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_801e442
        CPU.cmpT(CPU.r8().value, r6);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r4 = CPU.r8().value;
          CPU.r8().value = r6;
          r6 = CPU.addT(r4, 0x0);
        }

        //LAB_801e44c
        r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
        r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
        r2 = CPU.r8().value;
        r3 = CPU.subT(r6, r2);
        r0 += CPU.r10().value;
        r2 = CPU.movT(0, 0x1);
        r1 += CPU.r8().value;
        FUN_801e260(r0, r1, r2, r3);
        r3 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
        r2 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
        r3 += CPU.r8().value;
        r3 = CPU.lslT(r3, 5);
        r3 = CPU.addT(r3, r2);
        r3 += CPU.r10().value;
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.r9().value;
        r4 = CPU.r8().value;
        r0 = CPU.addT(r3, r2);
        r4 = CPU.cmpT(r4, r6);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_801e478
          do {
            r1 = MEMORY.ref(2, r0).getUnsigned();
            CPU.cmpT(r4, CPU.r8().value);
            if(CPU.cpsr().getZero()) { // ==
              r2 = MEMORY.ref(4, 0x801e6d4).get();
              r3 = CPU.addT(r1, r2);

              switch(r3) {
                case 1 ->
                  //LAB_801e560
                  r1 = MEMORY.ref(4, 0x801e6f4).get();

                case 5 ->
                  //LAB_801e4d4
                  r1 = MEMORY.ref(4, 0x801e6e0).get();

                case 6, 7, 9, 10, 11, 12, 13, 14 ->
                  //LAB_801e564
                  r1 = MEMORY.ref(4, 0x801e6f8).get();

                case 8 ->
                  //LAB_801e4d0
                  r1 = MEMORY.ref(4, 0x801e6dc).get();
              }
            } else {
              //LAB_801e4d8
              r4 = CPU.cmpT(r4, r6);
              if(CPU.cpsr().getZero()) { // ==
                r2 = MEMORY.ref(4, 0x801e6d4).get();
                r3 = CPU.addT(r1, r2);

                switch(r3) {
                  case 0 ->
                    //LAB_801e560
                    r1 = MEMORY.ref(4, 0x801e6f4).get();

                  case 5 ->
                    //LAB_801e534
                    r1 = MEMORY.ref(4, 0x801e6ec).get();

                  case 6, 7, 8, 9, 10, 12, 13, 14, 15 ->
                    //LAB_801e564
                    r1 = MEMORY.ref(4, 0x801e6f8).get();

                  case 11 ->
                    //LAB_801e530
                    r1 = MEMORY.ref(4, 0x801e6e8).get();
                }
              } else {
                //LAB_801e538
                r2 = MEMORY.ref(4, 0x801e6d4).get();
                r3 = CPU.addT(r1, r2);

                switch(r3) {
                  case 0, 1, 5 ->
                    //LAB_801e560
                    r1 = MEMORY.ref(4, 0x801e6f4).get();
                }
              }
            }

            //LAB_801e566
            r4 = CPU.addT(r4, 0x1);
            MEMORY.ref(2, r0).setu(r1);
            r0 = CPU.addT(r0, 0x40);
            r4 = CPU.cmpT(r4, r6);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }
      }
    } else {
      //LAB_801e572
      CPU.cmpT(CPU.r8().value, r6);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_801e578
        CPU.cmpT(r7, CPU.r10().value);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_801e57e
          CPU.cmpT(r7, CPU.r10().value);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r4 = CPU.addT(r7, 0x0);
            r7 = CPU.r10().value;
            CPU.r10().value = r4;
          }

          //LAB_801e588
          r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
          r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
          r3 = CPU.r10().value;
          r2 = CPU.subT(r3, r7);
          r0 = CPU.addT(r0, r7);
          r3 = CPU.movT(0, 0x1);
          r1 += CPU.r8().value;
          FUN_801e260(r0, r1, r2, r3);
          r3 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
          r2 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
          r3 += CPU.r8().value;
          r3 = CPU.lslT(r3, 5);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.addT(r3, r7);
          r3 = CPU.lslT(r3, 1);
          r2 = CPU.r9().value;
          r4 = CPU.addT(r7, 0x0);
          r0 = CPU.addT(r3, r2);
          CPU.cmpT(r4, CPU.r10().value);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_801e5b4
            do {
              r1 = MEMORY.ref(2, r0).getUnsigned();
              r4 = CPU.cmpT(r4, r7);
              if(CPU.cpsr().getZero()) { // ==
                r2 = MEMORY.ref(4, 0x801e6d4).get();
                r3 = CPU.addT(r1, r2);

                switch(r3) {
                  case 3 ->
                    //LAB_801e6b0
                    r1 = MEMORY.ref(4, 0x801e6f4).get();

                  case 5, 7, 8, 9, 10, 11, 12, 14, 15, 16 ->
                    //LAB_801e6b4
                    r1 = MEMORY.ref(4, 0x801e718).get();

                  case 6 ->
                    //LAB_801e618
                    r1 = MEMORY.ref(4, 0x801e704).get();

                  case 13 ->
                    //LAB_801e614
                    r1 = MEMORY.ref(4, 0x801e700).get();
                }
              } else {
                //LAB_801e61c
                CPU.cmpT(r4, CPU.r10().value);
                if(CPU.cpsr().getZero()) { // ==
                  r2 = MEMORY.ref(4, 0x801e6d4).get();
                  r3 = CPU.addT(r1, r2);

                  switch(r3) {
                    case 2 ->
                      //LAB_801e6b0
                      r1 = MEMORY.ref(4, 0x801e6f4).get();

                    case 5, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17 ->
                      //LAB_801e6b4
                      r1 = MEMORY.ref(4, 0x801e718).get();

                    case 6 ->
                      //LAB_801e680
                      r1 = MEMORY.ref(4, 0x801e710).get();

                    case 14 ->
                      //LAB_801e67c
                      r1 = MEMORY.ref(4, 0x801e70c).get();
                  }
                } else {
                  //LAB_801e684
                  r2 = MEMORY.ref(4, 0x801e6d4).get();
                  r3 = CPU.addT(r1, r2);

                  switch(r3) {
                    case 2, 3, 6 ->
                      //LAB_801e6b0
                      r1 = MEMORY.ref(4, 0x801e6f4).get();

                    case 5 ->
                      //LAB_801e6b4
                      r1 = MEMORY.ref(4, 0x801e718).get();
                  }
                }
              }

              //LAB_801e6b6
              MEMORY.ref(2, r0).setu(r1);
              r0 += 0x2;
              r4++;
            } while(r4 <= CPU.r10().value);
          }
        }
      }
    }

    //LAB_801e6c2
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x801e858)
  public static void FUN_801e858(int r0, int r1, int r2, int r3) {
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x80);
    r0 = CPU.lslT(r0, 2);
    CPU.r8().value = r2;
    CPU.r10().value = r3;
    r7 = CPU.addT(r1, 0x0);
    r0 = FUN_8004970(r0);
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r6 = CPU.addT(r0, 0x0);
    r2 = CPU.addT(r6, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_801e87a
      do {
        r3 = MEMORY.ref(1, r5).getUnsigned();
        MEMORY.ref(2, r2).setu(r3);
        r5 = CPU.addT(r5, 0x1);
        r3 = MEMORY.ref(1, r5).getUnsigned();
        r2 = CPU.addT(r2, 0x2);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_801e888
    r3 = MEMORY.ref(4, 0x801e8a0).get();
    r0 = CPU.addT(r6, 0x0);
    MEMORY.ref(2, r2).setu(r3);
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.r8().value;
    r3 = CPU.r10().value;
    FUN_8017aa4(r0, r1, r2, r3);
    r0 = CPU.addT(r6, 0x0);
    FUN_8002df0(r0);

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x801eadc)
  public static int FUN_801eadc(int r0, int r1, int r2, int r3, final int a4) {
    final int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r0, 0x0);
    CPU.r10().value = r1;
    CPU.r8().value = r2;
    r6 = CPU.addT(r3, 0x0);
    r0 = FUN_8015e8c();
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r7, 0x0);
      FUN_8003f3c(r0);
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_801eb00
      r0 = CPU.r8().value;
      r1 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0xe).getUnsigned();
      r2 = a4;
      r3 = CPU.lslT(r3, 3);
      r1 = CPU.lslT(r1, 3);
      r2 = CPU.addT(r2, r3);
      r1 = CPU.addT(r6, r1);
      r3 = MEMORY.ref(4, 0x801eb5c).get();
      r1 = CPU.addT(r1, 0x8);
      r1 = CPU.andT(r1, r3);
      r2 = CPU.addT(r2, 0x8);
      r3 = CPU.movT(0, 0xff);
      r2 = CPU.andT(r2, r3);
      r3 = CPU.lslT(r1, 16);
      r3 = CPU.orrT(r3, r2);
      r0 = CPU.r10().value;
      r3 = CPU.orrT(r3, r0);
      r0 = MEMORY.ref(4, 0x801eb60).get();
      MEMORY.ref(4, r5 + 0x14).setu(r3);
      r3 = CPU.lslT(r7, 2);
      r3 = CPU.addT(r3, r0);
      r3 = MEMORY.ref(2, r3 + 0x2).getUnsigned();
      r3 = CPU.lsrT(r3, 5);
      MEMORY.ref(4, r5 + 0x18).setu(r3);
      r3 = CPU.movT(0, 0xff);
      MEMORY.ref(1, r5 + 0xf).setu(r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r5).setu(r3);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(2, r5 + 0x6).setu(r1);
      MEMORY.ref(2, r5 + 0x8).setu(r2);
      MEMORY.ref(1, r5 + 0xe).setu(r7);
      MEMORY.ref(1, r5 + 0x4).setu(r3);
      MEMORY.ref(1, r5 + 0x5).setu(r3);
      r0 = CPU.r8().value;
      r1 = CPU.addT(r5, 0x0);
      FUN_8016584(r0, r1);
      r0 = CPU.addT(r5, 0x0);
    }

    //LAB_801eb50
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();

    return r0;
  }

  @Method(0x801ec6c)
  public static void FUN_801ec6c(int r0, int r1, int r2, int r3) {
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.r9().value = r3;
    r3 = MEMORY.ref(4, 0x801ed2c).get();
    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x20);
    CPU.sp().value -= 0x10;
    CPU.r10().value = r1;
    r6 = CPU.addT(r2, 0x0);
    r7 = MEMORY.ref(4, r3).get();
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.movT(0, 0x12);
      }

      //LAB_801ec94
      CPU.cmpT(r5, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.movT(0, 0x13);
      }
    }

    //LAB_801ec9a
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8019d2c(r0);
    r1 = CPU.movT(0, 0x1);
    r5 = CPU.addT(r0, 0x0);
    r1 = CPU.negT(r1, r1);
    r0 = CPU.movT(0, 0x0);
    r5 = CPU.cmpT(r5, r1);
    if(CPU.cpsr().getZero()) { // ==
      CPU.sp().value += 0x10;
      CPU.r8().value = CPU.pop();
      CPU.r9().value = CPU.pop();
      CPU.r10().value = CPU.pop();
      return;
    }
    CPU.cmpT(r6, 0x1);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r2 = MEMORY.ref(4, 0x801ed30).get();
      r3 = CPU.addT(r7, r2);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r2 = MEMORY.ref(4, 0x801ed34).get();
      r6 = CPU.movT(0, 0x1);
      r3 = CPU.cmpT(r3, r2);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(2, r7 + 0x12ec).getUnsigned();
        r6 = CPU.movT(0, 0x0);
        r3 = CPU.cmpT(r3, r2);
        if(!CPU.cpsr().getZero()) { // !=
          CPU.sp().value += 0x10;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          return;
        }
      }
    }

    //LAB_801ecca
    r2 = CPU.movT(0, 0xe);
    r2 = CPU.addT(r2, r6);
    CPU.r8().value = r2;
    r1 = CPU.r8().value;
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.sp().value + 0xc;
    r3 = CPU.sp().value + 0x8;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.r10().value;
    FUN_801a4fc(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    r1 = CPU.movT(0, 0x80);
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r1 = CPU.lslT(r1, 24);
    r2 = CPU.r9().value;
    r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = FUN_801eadc(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.r8().value;
      r1 = CPU.lslT(r2, 4);
      r2 = MEMORY.ref(1, r0 + 0x19).getUnsigned();
      r3 = CPU.movT(0, 0xf);
      r3 = CPU.andT(r3, r2);
      r3 = CPU.orrT(r3, r1);
      MEMORY.ref(1, r0 + 0x19).setu(r3);
      r3 = CPU.movT(0, 0x2);
      MEMORY.ref(1, r0 + 0x4).setu(r3);
    }

    //LAB_801ed0c
    r1 = MEMORY.ref(4, 0x801ed38).get();
    r3 = CPU.lslT(r6, 1);
    r2 = CPU.addT(r3, r1);
    MEMORY.ref(2, r7 + r2).setu(r5);
    r2 = MEMORY.ref(4, 0x801ed3c).get();
    r3 = CPU.addT(r3, r2);
    r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    MEMORY.ref(2, r7 + r3).setu(r2);

    //LAB_801ed1c
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x801f77c)
  public static int FUN_801f77c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;

    r0 = FUN_80056cc();
    r6 = CPU.movT(0, 0x9);
    r5 = CPU.movT(0, 0x0);
    r6 = CPU.negT(r6, r6);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_8005c68();
      r3 = MEMORY.ref(4, 0x801f7d4).get();
      r1 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, 0x801f7d8).get();
      r2 = MEMORY.ref(4, 0x801f7dc).get();
      MEMORY.ref(2, r3).setu(r5);
      r7 = CPU.addT(r3, 0x0);
      r3 = MEMORY.ref(4, 0x801f7e0).get();
      MEMORY.ref(2, r2).setu(r5);
      r4 = MEMORY.ref(4, 0x801f7d0).get();
      r6 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, r3);
      r0 = CPU.movT(0, 0x2);

      //LAB_801f7a8
      do {
        r3 = CPU.movT(0, 0x1);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r7).setu(r4);
          r5 = CPU.addT(r5, 0x1);
        }

        //LAB_801f7b4
        r3 = CPU.movT(0, 0x2);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(r4);
        }

        //LAB_801f7be
        r0 = CPU.subT(r0, 0x1);
        r1 = CPU.addT(r1, 0x40);
        CPU.cmpT(r0, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r3 = MEMORY.ref(4, 0x801f7e4).get();
      r2 = CPU.movT(0, 0x90);
      r3 = MEMORY.ref(4, r3).get();
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.andT(r3, r2);
      r3 = CPU.cmpT(r3, r2);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x801f80c).get();
        r3 = MEMORY.ref(4, 0x801f808).get();
        MEMORY.ref(2, r2).setu(r3);
      }
    }

    //LAB_801f7f6
    FUN_8005cf8();

    if(r6 != 0 && r5 == r6) {
      return r6 + 100;
    }

    //LAB_801f810
    //LAB_801f812
    return r6;
  }
}
