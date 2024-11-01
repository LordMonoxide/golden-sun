package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_80022fc;
import static org.goldensun.GoldenSun.FUN_8002304;
import static org.goldensun.GoldenSun.FUN_800231c;
import static org.goldensun.GoldenSun.FUN_8002322;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003d28;
import static org.goldensun.GoldenSun.FUN_8003dec;
import static org.goldensun.GoldenSun.FUN_8003f3c;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.FUN_80041d8;
import static org.goldensun.GoldenSun.FUN_8004278;
import static org.goldensun.GoldenSun.FUN_80056cc;
import static org.goldensun.GoldenSun.FUN_8005c68;
import static org.goldensun.GoldenSun.FUN_8005cf8;
import static org.goldensun.GoldenSun.FUN_800fec8;
import static org.goldensun.GoldenSun.FUN_800ff54;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocSlot;
import static org.goldensun.GoldenSunVars._3001800;
import static org.goldensun.GoldenSunVars._3001b10;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_808.FUN_808a5d0;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

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

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    CPU.r8().value = r3;
    r1 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x8;
    r4 = CPU.r8().value + 0x104;
    if(r1 != 0) {
      //LAB_8010024
      r7 = MEMORY.ref(4, r1).get() + 0xff880000;
      r6 = MEMORY.ref(4, r1 + 0x8).get() - MEMORY.ref(4, r1 + 0x4).get() + 0xffa00000;
      r2 = MEMORY.ref(4, CPU.r8().value + 0x4).get();
      r0 = MEMORY.ref(4, CPU.r8().value + 0xec).get() + r2;
      CPU.r12().value = r2;
      r1 = MEMORY.ref(4, CPU.r8().value + 0xf4).get() - r2 + 0xff100000;
      r5 = MEMORY.ref(4, CPU.r8().value + 0x8).get();
      int lr = MEMORY.ref(4, CPU.r8().value + 0xf0).get() + r5;
      r3 = MEMORY.ref(4, CPU.r8().value + 0xf8).get() - r5 + 0xff600000;

      if(r1 < r0) {
        r1 = r0;
      }

      //LAB_801006e
      if(r3 < lr) {
        r3 = lr;
      }

      //LAB_8010074
      if(r7 < r0) {
        r7 = r0;
      }

      //LAB_801007a
      if(r7 > r1) {
        r7 = r1;
      }

      //LAB_8010080
      if(r6 < lr) {
        r6 = lr;
      }

      //LAB_8010086
      if(r6 > r3) {
        r6 = r3;
      }

      //LAB_801008c
      if(CPU.r12().value != 0) {
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r5 = rand();
        r1 = rand();
        lr = MEMORY.ref(4, CPU.r8().value + 0x4).get();
        r0 = (int)MEMORY.call(0x3000118, lr, r5 - r1);
        r7 = r7 + r0;
        r0 = (int)MEMORY.call(0x3000118, lr, MEMORY.ref(4, CPU.r8().value + 0xc).get());
        MEMORY.ref(4, CPU.r8().value + 0x4).setu(r0);
        r5 = MEMORY.ref(4, CPU.r8().value + 0x8).get();
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100c4
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r5 = rand();
        r1 = rand();
        lr = MEMORY.ref(4, CPU.r8().value + 0x8).get();
        r0 = (int)MEMORY.call(0x3000118, lr, r5 - r1);
        r6 = r6 + r0;
        r0 = (int)MEMORY.call(0x3000118, lr, MEMORY.ref(4, CPU.r8().value + 0xc).get());
        MEMORY.ref(4, CPU.r8().value + 0x8).setu(r0);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100fa
      r1 = CPU.r8().value + 0xe4;
      r2 = CPU.r8().value + 0xe8;
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
      MEMORY.ref(4, r1).setu(r7);
      MEMORY.ref(4, r2).setu(r6);
      CPU.r11().value = r2;
      CPU.r10().value = 0;

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
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, 0x7ffff);
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
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, 0x7ffff);
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
          r1 = CPU.addT(r7, 0x7ffff);
        }

        //LAB_801016c
        r1 = CPU.asrT(r1, 19);
        CPU.r8().value = r1;
        r2 = CPU.addT(r6, 0x0);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = CPU.addT(r6, 0x7ffff);
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
        if(((r1 ^ r6) & 0x100000) != 0) {
          r1 = CPU.cmpT(r1, r6);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r2 = r5 + 0x14;
          } else {
            //LAB_80101ca
            r2 = r5;
          }
          MEMORY.ref(4, CPU.sp().value).setu(r4);

          //LAB_80101d2
          FUN_800fec8(CPU.r10().value, CPU.r8().value, r2);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80101d8
        r1 = CPU.r10().value;
        r3 = CPU.movT(0, 0x3);
        r3 = CPU.subT(r3, r1);
        r3 = CPU.lslT(r3, 2);
        r2 = CPU.asrT(r7, 16);
        MEMORY.ref(2, 0x3001ad0 + r3).setu(r2);
        r2 = CPU.asrT(r6, 16);
        r3 = CPU.addT(r3, 0x3001ad0);
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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8010230)
  public static void FUN_8010230(int r0, int r1) {
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

    r7 = CPU.addT(r0, 0x0);
    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    r0 = CPU.addT(r1, 0x0);
    r1 = CPU.movT(0, 0x82);
    CPU.sp().value -= 0x20;
    r1 = CPU.lslT(r1, 1);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r3 = CPU.addT(r3, r1);
    int lr = r3;
    r0 = CPU.addT(r0, 0xffa00000);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xec);
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r7, 0xff880000);
    r7 = CPU.cmpT(r7, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.addT(r3, 0x0);
    }

    //LAB_8010266
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf4);
    r3 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r3, 0xff100000);
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
    r3 = CPU.addT(r3, 0xff600000);
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
      r2 = lr;
      r0 = MEMORY.ref(4, r1).get();
      r4 = CPU.movT(0, 0x16);
      r1 = MEMORY.ref(4, r2 + 0x10).get();
      CPU.r12().value = 0x80102c8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r5 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r7 = CPU.addT(r0, 0x0);
      r1 = MEMORY.ref(4, r2 + 0x14).get();
      r0 = MEMORY.ref(4, r5).get();
      r0 = CPU.lslT(r0, 0);
      CPU.r12().value = 0x80102d8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r3 = lr;
      r2 = MEMORY.ref(4, r3 + 0x18).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x20).get();
        r5 = lr;
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
      r3 = lr;
      r2 = MEMORY.ref(4, r3 + 0x1c).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x24).get();
        r5 = lr;
        r3 = CPU.addT(r3, r2);
        r0 = CPU.addT(r0, r3);
        MEMORY.ref(4, r5 + 0x24).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x2a).getUnsigned();
        r3 = CPU.lslT(r3, 19);
        r3 = CPU.orrT(r3, 0x7ffff);
        r0 = CPU.andT(r0, r3);
        r4 = CPU.movT(0, 0x20);
      }

      //LAB_8010312
      r2 = lr;
      r3 = MEMORY.ref(4, r2 + 0x8).get();
      r7 = CPU.addT(r7, r3);
      r3 = MEMORY.ref(4, r2 + 0xc).get();
      r0 = CPU.addT(r0, r3);
      r3 = CPU.movT(0, 0x30);
      lr += r3;
      r1 = CPU.addT(r7, 0x0);
      CPU.cmpT(r7, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r1 = CPU.addT(r7, 0x7ffff);
      }

      //LAB_801032a
      r7 = CPU.asrT(r1, 19);
      r2 = CPU.addT(r0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.addT(r0, 0x7ffff);
      }

      //LAB_8010336
      r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = CPU.lslT(r5, 11);
      r0 = CPU.asrT(r2, 19);
      r5 = CPU.addT(r3, 0x6002800);
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
            r3 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r3, 0x2010000);
            r1 = MEMORY.ref(4, r3).get();
            r1 = CPU.lslT(r1, 20);
            r1 = CPU.lsrT(r1, 17);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            r3 = CPU.addT(r1, 0x2020000);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r2 = CPU.addT(r5, r0);
            r2 = CPU.lslT(r2, 1);
            r2 = CPU.addT(r2, r1);
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r3 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, r2).setu(r3);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r3 = CPU.addT(r2, 0x2020004);
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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8010424)
  public static void FUN_8010424(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r4 = CPU.addT(r3, 0x0);
    CPU.r11().value = r2;
    r1 = CPU.lslT(r1, 7);
    r3 = CPU.lslT(r4, 7);
    r2 = MEMORY.ref(4, 0x8010540).get();
    r1 = CPU.addT(r1, r0);
    r3 += CPU.r11().value;
    r1 = CPU.lslT(r1, 2);
    r3 = CPU.lslT(r3, 2);
    CPU.sp().value -= 0x24;
    r3 = CPU.addT(r3, r2);
    r1 = CPU.addT(r1, r2);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    r3 = MEMORY.ref(4, 0x8010544).get();
    r0 = CPU.movT(0, 0x82);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.lslT(r0, 1);
    r2 = CPU.addT(r3, r0);
    r0 = CPU.sp().value + 0xc;
    CPU.r9().value = r0;
    r6 = CPU.movT(0, 0x2);

    //LAB_801045e
    do {
      r3 = MEMORY.ref(4, r2).get();
      r3 = CPU.asrT(r3, 20);
      MEMORY.ref(4, r0).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x4).get();
      r6 = CPU.subT(r6, 0x1);
      r3 = CPU.asrT(r3, 20);
      MEMORY.ref(4, r0 + 0x4).setu(r3);
      r2 = CPU.addT(r2, 0x30);
      r0 = CPU.addT(r0, 0x8);
      CPU.cmpT(r6, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r3 = a5;
    r7 = CPU.addT(r4, 0x0);
    r3 = CPU.addT(r7, r3);
    r7 = CPU.cmpT(r7, r3);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r1 = a4;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.subT(r3, r1);
      r3 = CPU.lslT(r3, 2);
      CPU.r8().value = r3;

      //LAB_801048a
      do {
        r2 = a4;
        r1 = CPU.r11().value;
        r3 = CPU.addT(r1, r2);
        r1 = CPU.cmpT(r1, r3);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          CPU.r12().value = r7;
          r4 = CPU.r12().value;
          CPU.lr().value = r3;
          r3 = CPU.movT(0, 0xf);
          r4 = CPU.andT(r4, r3);
          CPU.r10().value = r3;
          CPU.r12().value = r4;

          //LAB_80104a2
          do {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r5 = MEMORY.ref(4, r2).get();
            r2 += 0x4;
            r0 = CPU.addT(r2, 0x0);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
            r3 = MEMORY.ref(4, 0x8010548).get();
            r2 = MEMORY.ref(4, 0x801054c).get();
            r5 = CPU.andT(r5, r3);
            r3 = MEMORY.ref(4, r4).get();
            r3 = CPU.andT(r3, r2);
            r3 = CPU.orrT(r3, r5);
            MEMORY.ref(4, r4).setu(r3);
            r4 += 0x4;
            r2 = CPU.addT(r1, 0x0);
            r0 = CPU.addT(r4, 0x0);
            r3 = CPU.r10().value;
            r4 = CPU.r12().value;
            r2 = CPU.andT(r2, r3);
            r3 = CPU.lslT(r4, 5);
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r6 = CPU.movT(0, 0x0);
            r0 = CPU.r9().value;
            r4 = CPU.lslT(r3, 2);

            //LAB_80104d0
            do {
              r3 = MEMORY.ref(4, r0).get();
              r3 = CPU.cmpT(r3, r1);
              if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                r3 = CPU.addT(r3, 0x10);
                r3 = CPU.cmpT(r3, r1);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r3 = MEMORY.ref(4, r0 + 0x4).get();
                  r3 = CPU.cmpT(r3, r7);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r3 = CPU.addT(r3, 0xc);
                    r3 = CPU.cmpT(r3, r7);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      r3 = CPU.lslT(r5, 3);
                      r2 = MEMORY.ref(4, 0x8010550).get();
                      r5 = MEMORY.ref(4, 0x8010554).get();
                      r0 = CPU.addT(r4, r2);
                      r2 = CPU.addT(r3, r5);
                      r2 = MEMORY.ref(4, r2).get();
                      MEMORY.ref(4, r0).setu(r2);
                      r0 = MEMORY.ref(4, 0x8010558).get();
                      r2 = CPU.addT(r3, r0);
                      r3 = MEMORY.ref(4, 0x801055c).get();
                      r0 = CPU.addT(r4, r3);
                      r3 = MEMORY.ref(4, r2).get();
                      MEMORY.ref(4, r0).setu(r3);
                      break;
                    }
                  }
                }
              }

              //LAB_8010504
              r2 = CPU.movT(0, 0x80);
              r2 = CPU.lslT(r2, 4);
              r6 = CPU.addT(r6, 0x1);
              r4 = CPU.addT(r4, r2);
              r0 = CPU.addT(r0, 0x8);
              CPU.cmpT(r6, 0x2);
            } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

            //LAB_8010512
            r1 = CPU.addT(r1, 0x1);
            CPU.cmpT(r1, CPU.lr().value);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }

        //LAB_8010518
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r5 = MEMORY.ref(4, CPU.sp().value).get();
        r3 += CPU.r8().value;
        r4 += CPU.r8().value;
        r7 = CPU.addT(r7, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
        r7 = CPU.cmpT(r7, r5);
      } while(!CPU.cpsr().getCarry()); // unsigned <
    }

    //LAB_801052c
    CPU.sp().value += 0x24;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8010704)
  public static void FUN_8010704(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;

    CPU.lr().value = r3;
    CPU.r12().value = r2;
    r3 = CPU.lslT(a5, 7);
    r3 = CPU.addT(r3, a4);
    r1 = CPU.lslT(r1, 7);
    CPU.r8().value = 0x2010000;
    r3 = CPU.lslT(r3, 2);
    r1 = CPU.addT(r1, r0);
    r3 += CPU.r8().value;
    r1 = CPU.lslT(r1, 2);
    r2 = CPU.lr().value;
    CPU.r10().value = r3;
    CPU.r8().value += r1;
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r5 = CPU.movT(0, 0x0);

      //LAB_8010732
      do {
        r3 = CPU.lsrT(r5, 7);
        r4 = CPU.r10().value;
        r2 = CPU.r8().value;
        r1 = CPU.addT(r4, r3);
        r0 = CPU.addT(r2, r3);
        r3 = CPU.r12().value;
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r4 = CPU.movT(0, 0x0);

          //LAB_8010748
          do {
            r2 = MEMORY.ref(4, r1).get();
            r3 = MEMORY.ref(4, r0).get();
            r2 = CPU.andT(r2, 0xfff);
            r3 = CPU.andT(r3, 0xfffff000);
            r2 = CPU.orrT(r2, r3);
            MEMORY.ref(4, r1).setu(r2);
            r2 = CPU.movT(0, 0x80);
            r2 = CPU.lslT(r2, 9);
            r3 = CPU.addT(r4, r2);
            r4 = CPU.addT(r3, 0x0);
            r3 = CPU.lsrT(r4, 16);
            CPU.cmpT(r3, CPU.r12().value);
          } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
        }

        //LAB_8010762
        r4 = CPU.movT(0, 0x80);
        r4 = CPU.lslT(r4, 9);
        r3 = CPU.addT(r5, r4);
        r5 = CPU.addT(r3, 0x0);
        r3 = CPU.lsrT(r5, 16);
        CPU.cmpT(r3, CPU.lr().value);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_8010770
  }

  @Method(0x801179c)
  public static void FUN_801179c() {
    int r0;
    int r1;
    int r2;
    int r4;
    int r5;

    final int r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    r5 = r8 + 0x18;

    //LAB_80117c0
    for(int i = 0; i < 0x10; i++) {
      if(MEMORY.ref(4, r5).get() != 0 && MEMORY.ref(2, r5 + 0xa).getUnsigned() == 0) {
        //LAB_80117cc
        do {
          r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
          if(r2 != 0) {
            //LAB_801186c
            MEMORY.ref(2, r5 + 0x8).setu(r2 + 0xffff);
            break;
          }

          r4 = MEMORY.ref(4, r5 + 0x4).get();
          r0 = MEMORY.ref(2, r4).getUnsigned();
          r4 += 0x2;
          if(r0 == 0xffff) {
            MEMORY.ref(4, r5 + 0x4).setu(MEMORY.ref(4, r5).get());
          } else {
            //LAB_80117e4
            if((r0 & 0xff00) != 0xfe00) {
              //LAB_8011804
              r2 = MEMORY.ref(2, r4).getUnsigned();
              r4 += 0x2;
              r1 = MEMORY.ref(2, r4).getUnsigned();
              MEMORY.ref(2, r5 + 0x8).setu(MEMORY.ref(2, r4 + 0x2).getUnsigned());
              if(MEMORY.ref(1, r8 + 0x16).getUnsigned() == 0) {
                if(r0 >= 0x600) {
                  r0 = 0x201c000 + r0 * 0x20;
                } else {
                  //LAB_801182e
                  r0 = 0x6004000 + r0 * 0x20;
                }

                r1 = 0x6004000 + r1 * 0x20;
                r2 = r2 * 0x8;
              } else {
                //LAB_801183c
                if(r0 >= 0x200) {
                  r0 = 0x2020000 + r0 * 0x40;
                } else {
                  //LAB_8011852
                  r0 = 0x6008000 + r0 * 0x40;
                }

                //LAB_801185c
                r1 = 0x6008000 + r1 * 0x40;
                r2 = r2 * 0x10;
              }

              //LAB_801185e
              DMA.channels[3].SAD.setu(r0);
              DMA.channels[3].DAD.setu(r1);
              DMA.channels[3].CNT.setu(0x84000000 | r2);

              MEMORY.ref(4, r5 + 0x4).addu(0x8);
            } else {
              r2 = r0 & 0xff;
              if(r2 == 0xff) {
                break;
              }
              MEMORY.ref(4, r5 + 0x4).setu(MEMORY.ref(4, r5).get() + r2 * 0x4);
            }
          }
        } while(true);
      }

      //LAB_8011872
      r5 += 0xc;
    }
  }

  @Method(0x80118a8)
  public static void FUN_80118a8(final int r0) {
    final int r2 = boardWramMallocHead_3001e50.offset(8 * 0x4).get() + r0 * 0xc;
    MEMORY.ref(2, r2 + 0x22).setu(0);
  }

  @Method(0x80118c0)
  public static void FUN_80118c0(final int r0) {
    int r3 = MEMORY.ref(4, 0x80118d4).get();
    int r2 = MEMORY.ref(4, r3).get();
    r3 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r0);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r2, r3);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r2 + 0x22).setu(r3);
  }

  @Method(0x80118d8)
  public static void FUN_80118d8(final int r0) {
    final int r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5 + 0x18);
    DMA.channels[3].CNT.setu(0x85000030);

    int r4 = r0;
    int r6 = 0;

    int r1 = MEMORY.ref(2, r4).getUnsigned();
    r4 += 0x2;

    //LAB_801191a
    while(r1 != 0xffff) {
      if((r1 & 0xff00) == 0xfd00) {
        final int r0_0;
        if((r1 & 0x80) != 0) {
          r0_0 = 1;
        } else {
          r0_0 = 0;
        }

        //LAB_8011936
        final int r3 = r5 + (r1 & 0xf) * 0xc + 0x18;
        MEMORY.ref(4, r3).setu(r4);
        MEMORY.ref(4, r3 + 0x4).setu(r4);
        MEMORY.ref(2, r3 + 0x8).setu(0);
        MEMORY.ref(2, r3 + 0xa).setu(r0_0);
        r6++;
      }

      //LAB_801194a
      r1 = MEMORY.ref(2, r4).getUnsigned();
      r4 += 0x2;
    }

    //LAB_8011954
    if(r6 != 0) {
      FUN_80041d8(getRunnable(GoldenSun_801.class, "FUN_801179c"), 0xc80);
    }

    //LAB_8011962
    CPU.sp().value += 0x4;
  }

  @Method(0x80119cc)
  public static void FUN_80119cc() {
    final int r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final int r4 = r3 + 0xd8;

    if(MEMORY.ref(4, r4).get() != 0 && MEMORY.ref(2, r4 + 0xa).getUnsigned() == 0) {
      //LAB_80119e4
      do {
        int r2 = MEMORY.ref(2, r4 + 0x8).getUnsigned();

        if(r2 != 0) {
          //LAB_8011a60
          MEMORY.ref(2, r4 + 0x8).setu(r2 + 0xffff);
          break;
        }

        int r0 = MEMORY.ref(4, r4 + 0x4).get();
        final int r1 = MEMORY.ref(2, r0).getUnsigned();
        r0 += 0x2;

        if(r1 == 0xffff) {
          MEMORY.ref(4, r4 + 0x4).setu(MEMORY.ref(4, r4).get());
          //LAB_80119fe
        } else if((r1 & 0xff00) == 0xfe00) {
          r2 = r1 & 0xff;
          if(r2 == 0xff) {
            break;
          }

          MEMORY.ref(4, r4 + 0x4).setu(MEMORY.ref(4, r4).get() + r2 * 0x4);
          //LAB_8011a1e
        } else if((r1 & 0xf000) == 0x3000) {
          GPU.BLDCNT.setu(r1);
          MEMORY.ref(1, r3 + 0x103).setu(r1);
          MEMORY.ref(4, r4 + 0x4).addu(0x2);
        } else {
          //LAB_8011a3e
          if((MEMORY.ref(1, r3 + 0x103).getUnsigned() & 0xc0) == 0x40) {
            GPU.BLDALPHA.setu(r1);
          } else {
            //LAB_8011a50
            GPU.BLDY.setu(r1);
          }

          //LAB_8011a52
          MEMORY.ref(2, r4 + 0x8).setu(MEMORY.ref(2, r0).getUnsigned());
          MEMORY.ref(4, r4 + 0x4).addu(0x4);
        }
      } while(true);
    }

    //LAB_8011a66
  }

  @Method(0x8011a84)
  public static void FUN_8011a84(int r0) {
    int r1;
    int r3;
    int r4;
    final int r5;
    int r6;

    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    CPU.sp().value -= 0x4;
    r4 = CPU.addT(r3, 0x0);
    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.sp().value;
    r4 = CPU.addT(r4, 0xd8);
    MEMORY.ref(4, r0).setu(r6);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000003);

    r3 = MEMORY.ref(2, r5).getUnsigned();
    r3 = CPU.cmpT(r3, 0xffff);
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
      r1 = CPU.lslT(r1, 4);
      FUN_80041d8(getRunnable(GoldenSun_801.class, "FUN_80119cc"), r1);
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

    r5 = CPU.addT(r1, 0x0);
    r1 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    r6 = CPU.addT(r2, 0x0);
    r5 = CPU.asrT(r5, 16);
    r6 = CPU.asrT(r6, 16);
    r2 = 0x2010000;
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
    r1 = CPU.lslT(r1, 2);
    r0 = CPU.addT(r1, 0x202c000);
    r2 = CPU.movT(0, 0xf);
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r2, 0x0);
    r3 = CPU.andT(r3, r0);
    r5 = CPU.andT(r5, r2);
    r6 = CPU.andT(r6, r2);
    r3 = CPU.lslT(r3, 2);
    r0 = CPU.addT(r1, 0x202c001);
    r3 = MEMORY.ref(4, 0x80134fc + r3).get();
    r1 = CPU.addT(r5, 0x0);
    r2 = CPU.addT(r6, 0x0);
    return (int)MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x8012330)
  public static void FUN_8012330(final int r0, final int r1, final int r2) {
    int r3;

    r3 = MEMORY.ref(4, 0x801234c).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
      MEMORY.ref(4, r3 + 0x4).setu(r0);
    }

    //LAB_801233c
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
      MEMORY.ref(4, r3 + 0x8).setu(r1);
    }

    //LAB_8012342
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
      MEMORY.ref(4, r3 + 0xc).setu(r2);
    }

    //LAB_8012348
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

  @Method(0x8015050)
  public static int FUN_8015050(final int r0) {
    return (int)MEMORY.call(0x8017394, r0);
  }

  @Method(0x8015100)
  public static void FUN_8015100(final int r0) {
    MEMORY.call(0x8019e48, r0);
  }

  @Method(0x8015120)
  public static void FUN_8015120(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015140)
  public static void FUN_8015140() {
    MEMORY.call(0x8019a54);
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
    MEMORY.call(0x801c428);
  }

  @Method(0x8015210)
  public static void FUN_8015210(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8019aa0, r0, r1, r2);
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
    final int r2;
    int r3;

    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r1 = r3 + 0xd98;
    r0 = MEMORY.ref(4, r1).get();
    if(r0 != 0) {
      r2 = MEMORY.ref(4, r0).get();
      if(r2 == 0) {
        r3 = CPU.addT(r3, 0xd9c);
        MEMORY.ref(4, r3).setu(r1);
      }

      //LAB_8015ea8
      MEMORY.ref(4, r1).setu(r2);
      MEMORY.ref(4, r0).setu(0);
    }

    //LAB_8015eae
    return r0;
  }

  @Method(0x8015ec0)
  public static void FUN_8015ec0(int r0) {
    int r1;
    int r2;
    int r3;
    r1 = CPU.movT(0, 0xd3);
    r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r1 = CPU.lslT(r1, 3);
    r3 = CPU.addT(r2, r1);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r3 = CPU.addT(r2, 0xd98);
      r0 = CPU.cmpT(r0, r3);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r1 = CPU.addT(0xd98, 0x4);
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

    r0 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r2 = r0 + 0x698;
    MEMORY.ref(4, r0 + 0xd98).setu(r2);
    r3 = 0x3e;

    //LAB_8015f08
    do {
      r1 = r2 + 0x1c;
      MEMORY.ref(4, r2).setu(r1);
      r2 = r1;
      r3--;
    } while(r3 >= 0);

    MEMORY.ref(4, r1).setu(0);
    MEMORY.ref(4, r0 + 0xd9c).setu(r1);
  }

  @Method(0x8015f30)
  public static void FUN_8015f30() {
    CPU.sp().value -= 0x4;
    final int addr = mallocSlotBoard(15, 0x12fc);
    final int r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x850004bf);

    MEMORY.ref(1, addr + 0xea3).setu(0x1);
    MEMORY.ref(2, addr + 0x12b6).setu(0x63);
    MEMORY.ref(1, addr + 0xea7).setu(0xf);
    MEMORY.ref(4, r5).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x85000140);

    FUN_8015ef4();
    FUN_8019d0c();
    FUN_80041d8(getRunnable(GoldenSun_801.class, "FUN_80160fc"), 0x480);
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

    r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r3 = CPU.addT(r7, 0xea6);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.subT(0xea6, 0x3);
      r3 = CPU.addT(r7, r2);
      r4 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.r12().value = 0x6002000;
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

        r3 = CPU.addT(r7, 0xea3);
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

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r3, 0x0);
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
      r3 = CPU.movT(0, 0x20);
      r3 = CPU.subT(r3, r6);
      r0 = CPU.r10().value + 0xea5;
      r1 = CPU.lslT(r3, 1);

      //LAB_80161dc
      do {
        r3 = MEMORY.ref(1, r0).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.r8().value;
          r3 = CPU.addT(r4, r2);
          CPU.cmpT(r3, 0x10);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            r4 = 0xf000;
          } else {
            r4 = 0xf07f;
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
    r3 = CPU.movT(0, 0x1);
    r2 = CPU.r10().value + 0xea3;
    MEMORY.ref(1, r2).setu(r3);
    CPU.sp().value += 0x4;

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8016230)
  public static void FUN_8016230(int r0) {
    final int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
      if((r2 & 0x20) != 0) {
        FUN_80170f8(r5, r6, r7, CPU.r8().value);
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0x44444444);
      } else {
        //LAB_801627c
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0);
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

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80162d4)
  public static int FUN_80162d4(final int r0, int r1, final int r2, final int r3, final int a4) {
    int r4;
    final int r7;

    r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).get() + 0x500;
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
        r1 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
        r3 = MEMORY.ref(1, r5 + 0x19).getUnsigned();
        r3 = CPU.lsrT(r3, 4);
        r3 = CPU.lslT(r3, 1);
        r3 = CPU.addT(r3, 0x12d0);
        MEMORY.ref(2, r1 + r3).setu(999);
      }
    }

    //LAB_80165c0
    MEMORY.ref(1, r5 + 0x5).setu(0);
  }

  @Method(0x80165d8)
  public static int FUN_80165d8(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    final int r6;
    final int r7;

    r7 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x8016648).get();
    CPU.r12().value = r1;
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.movT(0, 0xc4);
    r1 = CPU.lslT(r1, 3);
    r4 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(4, r4).get();
    r6 = CPU.addT(r0, 0x0);
    r5 = a4;
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);

    //LAB_80165fe
    CPU.cmpT(r3, 0x0);

    //LAB_80165f4
    jmp_8016604:
    {
      while(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.addT(r1, 0x1);
        r4 = CPU.addT(r4, 0x28);
        CPU.cmpT(r1, 0x3);
        if(CPU.cpsr().getZero()) { // ==
          break jmp_8016604;
        }
        r3 = MEMORY.ref(4, r4).get();
        CPU.cmpT(r3, 0x0);
      }
      r0 = CPU.addT(r4, 0x0);
    }

    //LAB_8016604
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.lslT(r2, 8);
      MEMORY.ref(2, r0 + 0x1e).setu(r3);
      MEMORY.ref(2, r0 + 0x4).setu(r3);
      r3 = CPU.lslT(r7, 8);
      MEMORY.ref(2, r0 + 0x6).setu(r3);
      r3 = CPU.r12().value;
      MEMORY.ref(2, r0 + 0x12).setu(r3);
      r3 = CPU.movT(0, 0xf);
      MEMORY.ref(2, r0 + 0x16).setu(r3);
      r3 = CPU.movT(0, 0xa);
      MEMORY.ref(2, r0 + 0x1a).setu(r3);
      r3 = a5;
      r2 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r0).setu(r6);
      MEMORY.ref(2, r0 + 0x14).setu(r2);
      MEMORY.ref(2, r0 + 0x18).setu(r2);
      MEMORY.ref(2, r0 + 0x20).setu(r2);
      MEMORY.ref(2, r0 + 0x24).setu(r3);
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.addT(r0, 0x0);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.addT(r2, 0x8);

        //LAB_8016636
        do {
          r3 = MEMORY.ref(2, r5).getUnsigned();
          r1 = CPU.addT(r1, 0x1);
          MEMORY.ref(2, r2).setu(r3);
          r5 = CPU.addT(r5, 0x2);
          r2 = CPU.addT(r2, 0x2);
          CPU.cmpT(r1, 0x3);
        } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
      } else {
        //LAB_801664c
        r3 = CPU.addT(r0, 0x0);
        r2 = MEMORY.ref(4, 0x8016660).get();
        r1 = CPU.movT(0, 0x0);
        r3 = CPU.addT(r3, 0x8);

        //LAB_8016654
        do {
          r1 = CPU.addT(r1, 0x1);
          MEMORY.ref(2, r3).setu(r2);
          r3 = CPU.addT(r3, 0x2);
          CPU.cmpT(r1, 0x3);
        } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
      }

      //LAB_8016664
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r0 + 0x10).setu(r3);
    }

    //LAB_8016668

    return r0;
  }

  @Method(0x80167ac)
  public static void FUN_80167ac(final int r0) {
    int r3 = MEMORY.ref(4, 0x80167cc).get();
    int r4 = MEMORY.ref(4, 0x80167d0).get();
    int r2 = MEMORY.ref(4, r3).get();
    int r1 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
    r3 = CPU.addT(r2, r4);
    MEMORY.ref(2, r3).setu(r1);
    r4 = CPU.subT(r4, 0x2);
    r1 = MEMORY.ref(2, r0 + 0x18).getUnsigned();
    r3 = CPU.addT(r2, r4);
    MEMORY.ref(2, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x80167d4).get();
    r3 = MEMORY.ref(2, r0 + 0x1a).getUnsigned();
    r2 = CPU.addT(r2, r1);
    MEMORY.ref(2, r2).setu(r3);
  }

  @Method(0x80167d8)
  public static void FUN_80167d8(final int r0) {
    MEMORY.ref(2, r0 + 0x1c).setu(0x2);
  }

  @Method(0x80167e0)
  public static void FUN_80167e0(int r0) {
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

    r3 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r0);
    r6 = MEMORY.ref(4, 0x8016858).get();
    r1 = CPU.lslT(r3, 1);
    r3 = CPU.lslT(r3, 3);
    CPU.r8().value = r3;
    r5 = CPU.addT(r3, r6);
    r3 = MEMORY.ref(4, 0x801685c).get();
    CPU.sp().value -= 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r3 = CPU.movT(0, 0x20);
    r2 = CPU.movT(0, 0x18);
    r4 = CPU.movT(0, 0x84);
    r3 = CPU.subT(r3, r1);
    r2 = CPU.subT(r2, r1);
    r4 = CPU.lslT(r4, 24);
    r3 = CPU.lslT(r3, 2);
    CPU.r9().value = r2;
    CPU.r11().value = r4;
    CPU.r10().value = r3;
    r7 = CPU.movT(0, 0x1d);

    //LAB_8016818
    do {
      r2 = CPU.r9().value;
      r4 = CPU.r11().value;
      r2 = CPU.orrT(r2, r4);
      DMA.channels[3].SAD.setu(r5);
      DMA.channels[3].DAD.setu(r6);
      DMA.channels[3].CNT.setu(r2);

      r0 = MEMORY.ref(4, CPU.sp().value).get();
      r3 = MEMORY.ref(4, 0x8016864).get();
      r0 += CPU.r10().value;
      r1 = CPU.r8().value;
      r2 = CPU.movT(0, 0x0);
      MEMORY.call(r3, r0, r1, r2);
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      r7 = CPU.subT(r7, 0x1);
      r3 = CPU.addT(r3, 0x80);
      r6 = CPU.addT(r6, 0x80);
      r5 = CPU.addT(r5, 0x80);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      CPU.cmpT(r7, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

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

    r2 = CPU.movT(0, 0xc4);
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
  public static int FUN_80168f4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x8016a5c).get();
    r1 = MEMORY.ref(4, 0x8016a60).get();
    r3 = MEMORY.ref(4, r3).get();
    r6 = CPU.addT(r0, 0x0);
    CPU.r8().value = r3;
    r0 = CPU.movT(0, 0x83);
    r3 = MEMORY.ref(4, r1).get();
    r3 = MEMORY.ref(4, 0x8016a64).get();
    r0 = CPU.lslT(r0, 2);
    r3 = CPU.addT(r3, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r2 = MEMORY.ref(4, 0x8016a68).get();
    r2 = MEMORY.ref(1, r2 + r3).getUnsigned();
    CPU.sp().value -= 0x34;
    r3 = MEMORY.ref(4, 0x8016a6c).get();
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
    r3 += CPU.r8().value;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8016a70).get();
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r2 = CPU.addT(r3, 0x0);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x0);
      }

      //LAB_8016936
      CPU.cmpT(r2, 0x2);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.movT(0, 0x2);
      }

      //LAB_801693c
      r3 = CPU.lslT(r2, 2);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.addT(r3, 0x3);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
    }

    //LAB_8016944
    r3 = MEMORY.ref(2, r6 + 0x1c).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0x1);
      FUN_80167e0(r0);
      r3 = MEMORY.ref(2, r6 + 0x1c).getUnsigned();
      r3 = CPU.subT(r3, 0x1);
      MEMORY.ref(2, r6 + 0x1c).setu(r3);

      r0 = CPU.movT(0, 0x0);
      CPU.sp().value += 0x34;
      CPU.r8().value = CPU.pop();
      CPU.r9().value = CPU.pop();
      CPU.r10().value = CPU.pop();
      CPU.r11().value = CPU.pop();
      return r0;
    }

    //LAB_8016958
    r3 = MEMORY.ref(4, r1).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = MEMORY.ref(2, r6 + 0x22).getUnsigned();
      r3 = CPU.addT(r2, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = MEMORY.ref(4, 0x8016a74).get();
        r3 = CPU.addT(r2, r1);
        MEMORY.ref(2, r6 + 0x22).setu(r3);

        r0 = CPU.movT(0, 0x0);
        CPU.sp().value += 0x34;
        CPU.r8().value = CPU.pop();
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return r0;
      }
    }

    //LAB_8016972
    do {
      r3 = MEMORY.ref(2, r6 + 0x20).getUnsigned();
      r7 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
        r2 = CPU.movT(0, 0xeb);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.lslT(r2, 4);
        r3 = CPU.addT(r3, r2);
        r4 = CPU.r8().value;
        r7 = MEMORY.ref(2, r4 + r3).getUnsigned();
      }

      //LAB_8016988
      jmp_8016ede:
      {
        switch(r7) {
          case 3:
            r3 = MEMORY.ref(2, r6 + 0x1e).getUnsigned();
            MEMORY.ref(2, r6 + 0x4).setu(r3);
            r3 = MEMORY.ref(4, r6).get();
            r2 = MEMORY.ref(2, r3 + 0x16).getUnsigned();
            r3 = CPU.movT(0, 0x8);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r3 = MEMORY.ref(4, 0x8016a7c).get();
              r2 = CPU.cmpT(r2, r3);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r0 = CPU.addT(r6, 0x0);
                FUN_80167d8(r0);
                r0 = CPU.movT(0, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
              } else {
                //LAB_8016a38
                r1 = CPU.movT(0, 0xd0);
                r1 = CPU.lslT(r1, 4);
                r3 = CPU.addT(r2, r1);
                MEMORY.ref(2, r6 + 0x6).setu(r3);
              }
            } else {
              //LAB_8016a42
              r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r2 = CPU.movT(0, 0xf0);
              r2 = CPU.lslT(r2, 4);
              r3 = CPU.addT(r3, r2);
              r2 = MEMORY.ref(2, r6 + 0x10).getUnsigned();
              MEMORY.ref(2, r6 + 0x6).setu(r3);
              r3 = CPU.addT(r2, 0x0);
              CPU.cmpT(r3, 0x2);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                //LAB_8016a56
                r3 = CPU.addT(r2, 0x1);
                MEMORY.ref(2, r6 + 0x10).setu(r3);
              }
            }
            break;

          case 1:
            r3 = MEMORY.ref(4, 0x8016ad0).get();
            r3 += CPU.r8().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r4 = CPU.movT(0, 0xe1);
              r3 = MEMORY.ref(2, r6 + 0x14).getUnsigned();
              r4 = CPU.lslT(r4, 2);
              r3 = CPU.cmpT(r3, r4);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r2 = MEMORY.ref(4, 0x8016ad4).get();
                r3 = CPU.movT(0, 0x0);
                MEMORY.ref(4, r2).setu(r3);
              }
            }

            //LAB_8016a9a
            r3 = MEMORY.ref(4, 0x8016ad8).get();
            r0 = CPU.addT(r6, 0x0);
            r7 = MEMORY.ref(4, 0x8016acc).get();
            MEMORY.ref(2, r6 + 0x14).setu(r3);
            r0 = FUN_80199ec(r0);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r0 = MEMORY.ref(4, r6).get();
              r3 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_8016ab4
                r3 = MEMORY.ref(2, r0 + 0xa).getUnsigned();
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_8016abc
                  r7 = MEMORY.ref(4, 0x8016adc).get();
                  r7 += CPU.r8().value;
                  r3 = MEMORY.ref(1, r7).getUnsigned();
                  CPU.cmpT(r3, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    //LAB_8016ac8
                    r2 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
                    r3 = MEMORY.ref(2, r0 + 0xa).getUnsigned();
                    r2 = CPU.lslT(r2, 2);
                    r3 = CPU.lslT(r3, 3);
                    r5 = CPU.movT(0, 0x1);
                    r2 = CPU.subT(r2, 0x8);
                    r3 = CPU.subT(r3, 0x10);
                    r1 = CPU.movT(0, 0x1);
                    r0 = FUN_8018cac(r0, r1, r2, r3, r5);
                    MEMORY.ref(1, r7).setu(r5);
                  }
                }
              }
            } else {
              //LAB_8016afa
              r5 = MEMORY.ref(4, r6).get();
              r3 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
              r0 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
              MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
              r3 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
              r3 = MEMORY.ref(4, 0x8016cb8).get();
              r1 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
              r4 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
              r3 += CPU.r8().value;
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
              r0 = CPU.addT(r5, 0x0);
              MEMORY.ref(1, r3).setu(r7);
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
              FUN_8016478(r0);
              r3 = MEMORY.ref(2, r6 + 0x24).getUnsigned();
              r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
                r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
                r3 = CPU.orrT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
                  r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
                  r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
                  r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
                  FUN_8016178(r0, r1, r2, r3);
                  r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                }
              }

              //LAB_8016b3c
              r3 = MEMORY.ref(4, 0x8016cbc).get();
              r4 = CPU.addT(r4, 0x1);
              r4 = CPU.andT(r4, r3);
              r2 = CPU.movT(0, 0xeb);
              r3 = CPU.lslT(r4, 1);
              r2 = CPU.lslT(r2, 4);
              r3 = CPU.addT(r3, r2);
              r0 = CPU.r8().value;
              r3 = MEMORY.ref(2, r0 + r3).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
                r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
                r3 = CPU.orrT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r7 = MEMORY.ref(2, r6 + 0x24).getUnsigned();
                  CPU.cmpT(r7, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
                    r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
                    r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
                    r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
                    FUN_8016178(r0, r1, r2, r3);
                  } else {
                    //LAB_8016b70
                    r1 = CPU.sp().value + 0x30;
                    CPU.r11().value = r1;
                    r0 = CPU.movT(0, 0x24);
                    r1 = CPU.movT(0, 0x8);
                    r0 += CPU.sp().value;
                    r1 = CPU.addT(r1, r6);
                    r2 = CPU.sp().value;
                    r3 = CPU.sp().value;
                    r3 = CPU.addT(r3, 0x28);
                    r2 = CPU.addT(r2, 0x2c);
                    MEMORY.ref(4, CPU.sp().value).setu(r0);
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                    CPU.r9().value = r0;
                    CPU.r10().value = r1;
                    r0 = CPU.addT(r4, 0x0);
                    r1 = CPU.r11().value;
                    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
                    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
                    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
                    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r7);
                    FUN_801868c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
                    r1 = MEMORY.ref(2, r5 + 0x16).getUnsigned();
                    r3 = CPU.movT(0, 0x80);
                    r3 = CPU.andT(r3, r1);
                    r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                    CPU.cmpT(r3, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                      r3 = CPU.cmpT(r3, r2);
                      if(!CPU.cpsr().getZero()) { // !=
                        r2 = CPU.subT(r2, r3);
                        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                        r3 = CPU.subT(r3, r2);
                        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
                      }

                      //LAB_8016bb8
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7);
                      }
                    }

                    //LAB_8016bc0
                    r3 = CPU.movT(0, 0x80);
                    r3 = CPU.lslT(r3, 1);
                    r3 = CPU.andT(r3, r1);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getZero()) { // ==
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                      r3 = CPU.subT(r0, r3);
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r3 = CPU.addT(r3, 0x3);
                      }

                      //LAB_8016bd6
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                      r3 = CPU.asrT(r3, 2);
                      r2 = CPU.addT(r2, r3);
                      r1 = CPU.r9().value;
                      r3 = CPU.movT(0, 0x2);
                      MEMORY.ref(4, CPU.sp().value + 0x30).setu(r2);
                      r2 = CPU.r10().value;
                      MEMORY.ref(4, CPU.sp().value).setu(r1);
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
                      r0 = CPU.addT(r4, 0x0);
                      r1 = CPU.r11().value;
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                      FUN_801868c(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
                    }

                    //LAB_8016bf6
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                    MEMORY.ref(2, r5 + 0xc).setu(r3);
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                    MEMORY.ref(2, r5 + 0xe).setu(r3);
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                    MEMORY.ref(2, r5 + 0x8).setu(r3);
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                    MEMORY.ref(2, r5 + 0xa).setu(r3);
                  }

                  //LAB_8016c06
                  r0 = MEMORY.ref(2, r5 + 0xc).getUnsigned();
                  r1 = MEMORY.ref(2, r5 + 0xe).getUnsigned();
                  r2 = MEMORY.ref(2, r5 + 0x8).getUnsigned();
                  r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
                  FUN_80170f8(r0, r1, r2, r3);
                }
              }

              //LAB_8016c12
              r3 = MEMORY.ref(2, r6 + 0x1e).getUnsigned();
              r2 = CPU.movT(0, 0x0);
              r5 = MEMORY.ref(4, 0x8016cc0).get();
              MEMORY.ref(2, r6 + 0x4).setu(r3);
              MEMORY.ref(2, r6 + 0x6).setu(r2);
              MEMORY.ref(2, r6 + 0x10).setu(r2);
              r5 += CPU.r8().value;
              r0 = MEMORY.ref(2, r5).getUnsigned();
              r0 = FUN_8003f3c(r0);
              r3 = CPU.movT(0, 0x63);
              MEMORY.ref(2, r5).setu(r3);
            }
            break;

          case 2:
            r3 = MEMORY.ref(4, 0x8016cc4).get();
            r3 += CPU.r8().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r4 = CPU.movT(0, 0xe1);
              r3 = MEMORY.ref(2, r6 + 0x14).getUnsigned();
              r4 = CPU.lslT(r4, 2);
              r3 = CPU.cmpT(r3, r4);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r2 = MEMORY.ref(4, 0x8016cc8).get();
                r3 = CPU.movT(0, 0x0);
                MEMORY.ref(4, r2).setu(r3);
              }
            }

            //LAB_8016c46
            r0 = CPU.addT(r6, 0x0);
            r0 = FUN_80199ec(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_801696e
              r0 = CPU.movT(0, 0x9);
              CPU.sp().value += 0x34;
              CPU.r8().value = CPU.pop();
              CPU.r9().value = CPU.pop();
              CPU.r10().value = CPU.pop();
              CPU.r11().value = CPU.pop();
              return r0;
            }

            //LAB_8016c52
            r3 = MEMORY.ref(4, 0x8016ccc).get();
            MEMORY.ref(2, r6 + 0x14).setu(r3);
            break;

          case 5:
            r3 = MEMORY.ref(2, r6 + 0x14).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.movT(0, 0x14);
              MEMORY.ref(2, r6 + 0x14).setu(r3);
            }
            r2 = MEMORY.ref(4, 0x8016cd0).get();
            r3 = CPU.movT(0, 0x0);
            r2 += CPU.r8().value;
            MEMORY.ref(2, r2).setu(r3);
            r0 = CPU.addT(r6, 0x0);
            r0 = FUN_801999c(r0);
            break;

          case 6:
            r3 = MEMORY.ref(2, r6 + 0x14).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.movT(0, 0x78);
              MEMORY.ref(2, r6 + 0x14).setu(r3);
            }

            //LAB_8016c6c
            r2 = MEMORY.ref(4, 0x8016cd0).get();
            r3 = CPU.movT(0, 0x0);
            r2 += CPU.r8().value;
            MEMORY.ref(2, r2).setu(r3);
            r0 = CPU.addT(r6, 0x0);
            r0 = FUN_801999c(r0);
            break;

          case 4:
            r3 = MEMORY.ref(2, r6 + 0x14).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.movT(0, 0x3c);
              MEMORY.ref(2, r6 + 0x14).setu(r3);
            }

            //LAB_8016c86
            r2 = MEMORY.ref(4, 0x8016cd0).get();
            r3 = CPU.movT(0, 0x0);
            r2 += CPU.r8().value;
            MEMORY.ref(2, r2).setu(r3);
            break;

          case 8:
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r2 = MEMORY.ref(4, 0x8016cb4).get();
            r3 = CPU.addT(r3, 0x1);
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r6 + 0x12).setu(r3);
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r0 = CPU.movT(0, 0xeb);
            r0 = CPU.lslT(r0, 4);
            r3 = CPU.lslT(r3, 1);
            r3 = CPU.addT(r3, r0);
            r1 = CPU.r8().value;
            r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
            r0 = CPU.addT(r6, 0x0);
            MEMORY.ref(2, r6 + 0x16).setu(r3);
            FUN_80167ac(r0);
            break;

          case 9:
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r2 = MEMORY.ref(4, 0x8016cf8).get();
            r3 = CPU.addT(r3, 0x1);
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r6 + 0x12).setu(r3);
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r2 = CPU.movT(0, 0xeb);
            r3 = CPU.lslT(r3, 1);
            r2 = CPU.lslT(r2, 4);
            r3 = CPU.addT(r3, r2);
            r4 = CPU.r8().value;
            r3 = MEMORY.ref(2, r4 + r3).getUnsigned();
            r0 = CPU.addT(r6, 0x0);
            MEMORY.ref(2, r6 + 0x18).setu(r3);
            FUN_80167ac(r0);
            break;

          case 10:
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r2 = MEMORY.ref(4, 0x8016d2c).get();
            r3 = CPU.addT(r3, 0x1);
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r6 + 0x12).setu(r3);
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r0 = CPU.movT(0, 0xeb);
            r0 = CPU.lslT(r0, 4);
            r3 = CPU.lslT(r3, 1);
            r3 = CPU.addT(r3, r0);
            r1 = CPU.r8().value;
            r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
            r0 = CPU.addT(r6, 0x0);
            MEMORY.ref(2, r6 + 0x1a).setu(r3);
            FUN_80167ac(r0);
            break;

          case 7:
            r3 = CPU.movT(0, 0x0);
            r2 = CPU.movT(0, 0xf);
            MEMORY.ref(2, r6 + 0x18).setu(r3);
            r0 = CPU.addT(r6, 0x0);
            r3 = CPU.movT(0, 0xa);
            MEMORY.ref(2, r6 + 0x16).setu(r2);
            MEMORY.ref(2, r6 + 0x1a).setu(r3);
            FUN_80167ac(r0);
            break;

          case 15:
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r0 = MEMORY.ref(4, 0x8016d60).get();
            r3 = CPU.addT(r3, 0x1);
            r3 = CPU.andT(r3, r0);
            MEMORY.ref(2, r6 + 0x12).setu(r3);
            r2 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r4 = CPU.movT(0, 0xeb);
            r3 = CPU.lslT(r2, 1);
            r4 = CPU.lslT(r4, 4);
            r3 = CPU.addT(r3, r4);
            r4 = CPU.r8().value;
            r3 = MEMORY.ref(2, r4 + r3).getUnsigned();
            r1 = MEMORY.ref(4, r6).get();
            r2 = CPU.addT(r2, 0x1);
            MEMORY.ref(2, r1 + 0x12).setu(r3);
            r2 = CPU.andT(r2, r0);
            r3 = CPU.movT(0, 0xa);
            MEMORY.ref(2, r6 + 0x14).setu(r3);
            MEMORY.ref(2, r6 + 0x12).setu(r2);
            break;

          case 0:
          case 30:
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(2, r6 + 0x20).setu(r3);
            r0 = CPU.movT(0, 0x8);
            CPU.sp().value += 0x34;
            CPU.r8().value = CPU.pop();
            CPU.r9().value = CPU.pop();
            CPU.r10().value = CPU.pop();
            CPU.r11().value = CPU.pop();
            return r0;

          case 11:
          case 12:
          case 13:
          case 14:
          case 16:
          case 17:
          case 18:
          case 19:
          case 20:
          case 21:
          case 22:
          case 23:
          case 24:
          case 25:
          case 26:
          case 27:
          case 28:
          case 29:
            //LAB_8016d64
            r3 = MEMORY.ref(4, 0x8016dd4).get();
            r3 += CPU.r8().value;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_8016d70
              r0 = CPU.movT(0, 0x1);
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
            }
            break jmp_8016ede;
        }

        //LAB_8016d76
        r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
        r2 = CPU.addT(r3, 0x0);
        r2 = CPU.addT(r2, 0x80);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = MEMORY.ref(4, 0x8016dd8).get();
          r2 = CPU.addT(r3, r1);
        }

        //LAB_8016d84
        r5 = CPU.asrT(r2, 8);
        r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        r3 = CPU.addT(r3, 0x80);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r4 = MEMORY.ref(4, 0x8016dd8).get();
          r3 = CPU.addT(r2, r4);
        }

        //LAB_8016d94
        r3 = CPU.asrT(r3, 8);
        CPU.r12().value = r3;
        r0 = CPU.movT(0, 0x83);
        r3 = MEMORY.ref(4, 0x8016ddc).get();
        r0 = CPU.lslT(r0, 2);
        r3 = CPU.addT(r3, r0);
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r2 = MEMORY.ref(4, 0x8016de0).get();
        r2 = MEMORY.ref(1, r2 + r3).getUnsigned();
        r3 = MEMORY.ref(4, 0x8016de4).get();
        r3 += CPU.r8().value;
        r3 = MEMORY.ref(1, r3).getUnsigned();
        CPU.r10().value = r2;
        r2 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r5 = CPU.addT(r5, 0x8);
        }

        //LAB_8016db6
        r3 = CPU.addT(r2, 0x1);
        r2 = MEMORY.ref(4, 0x8016de8).get();
        r1 = CPU.movT(0, 0xeb);
        r3 = CPU.andT(r3, r2);
        r3 = CPU.lslT(r3, 1);
        r1 = CPU.lslT(r1, 4);
        r3 = CPU.addT(r3, r1);
        r0 = CPU.r8().value;
        r4 = MEMORY.ref(2, r0 + r3).getUnsigned();
        CPU.cmpT(r4, 0xde);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.movT(0, 0x80);
          r3 = CPU.lslT(r3, 7);
          r7 = CPU.orrT(r7, r3);
          r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
          r3 = CPU.addT(r3, 0x1);
          r3 = CPU.andT(r3, r2);
          MEMORY.ref(2, r6 + 0x12).setu(r3);
        } else {
          //LAB_8016dec
          CPU.cmpT(r4, 0xdf);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.movT(0, 0x80);
            r3 = CPU.lslT(r3, 8);
            r7 = CPU.orrT(r7, r3);
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r3 = CPU.addT(r3, 0x1);
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r6 + 0x12).setu(r3);
          }
        }

        //LAB_8016dfe
        r0 = MEMORY.ref(4, r6).get();
        r2 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
        r3 = CPU.movT(0, 0x8);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          CPU.cmpT(r7, 0x20);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            CPU.cmpT(r4, 0x20);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r3 = CPU.addT(r7, 0x0);
              r2 = CPU.addT(r4, 0x0);
              r1 = MEMORY.ref(4, 0x8016e70).get();
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
                r3 = CPU.lslT(r4, 8);
                r7 = CPU.orrT(r7, r3);
                r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
                r2 = MEMORY.ref(4, 0x8016e6c).get();
                r3 = CPU.addT(r3, 0x1);
                r3 = CPU.andT(r3, r2);
                MEMORY.ref(2, r6 + 0x12).setu(r3);
              }
            }
          }
        }

        //LAB_8016e3e
        r2 = CPU.addT(r5, 0x0);
        r3 = CPU.r12().value;
        r1 = CPU.addT(r7, 0x0);
        r0 = FUN_8018cac(r0, r1, r2, r3, 0);
        r3 = MEMORY.ref(4, 0x8016e74).get();
        r4 = CPU.addT(r0, 0x0);
        r0 = CPU.movT(0, 0x83);
        r0 = CPU.lslT(r0, 2);
        r3 = CPU.addT(r3, r0);
        r2 = MEMORY.ref(4, 0x8016e78).get();
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r3 = MEMORY.ref(1, r2 + r3).getUnsigned();
        MEMORY.ref(2, r6 + 0x22).setu(r3);
        CPU.cmpT(r4, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, 0x8016e7c).get();
          r1 += CPU.r8().value;
          r3 = MEMORY.ref(2, r1).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r5 = MEMORY.ref(4, 0x8016eac).get();
            r5 += CPU.r8().value;
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r2, 0x0);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              CPU.cmpT(r7, 0x20);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(2, r1).getUnsigned();
                r3 = CPU.movT(0, 0x3);
                r3 = CPU.andT(r3, r7);
                r0 = CPU.addT(r0, r3);
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
                FUN_80f9010(r0);
                r1 = CPU.r10().value;
                MEMORY.ref(2, r5).setu(r1);
                r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              }
            } else {
              //LAB_8016eb0
              r0 = MEMORY.ref(4, 0x8016f10).get();
              r3 = CPU.addT(r2, r0);
              MEMORY.ref(2, r5).setu(r3);
            }
          }

          //LAB_8016eb6
          r0 = CPU.lslT(r4, 8);
          CPU.cmpT(r7, 0x20);
          if(CPU.cpsr().getZero()) { // ==
            r3 = MEMORY.ref(2, r6 + 0x10).getUnsigned();
            r3 = CPU.lslT(r3, 1);
            r3 = CPU.addT(r3, 0x8);
            r3 = MEMORY.ref(2, r6 + r3).getUnsigned();
            r0 = CPU.addT(r0, r3);
          }

          //LAB_8016ec6
          r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
          r3 = CPU.addT(r3, r0);
          MEMORY.ref(2, r6 + 0x4).setu(r3);
        }

        //LAB_8016ecc
        CPU.cmpT(r7, 0x20);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(4, 0x8016f14).get();
          r3 += CPU.r8().value;
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = CPU.movT(0, 0x1);
            MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
          }
        }
      }

      //LAB_8016ede
      //NOTE inline decr
      if(MEMORY.ref(2, r6 + 0x14).getUnsigned() == 0 || MEMORY.ref(2, r6 + 0x14).decr().getUnsigned() == 0) {
        //LAB_8016ef2
        r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
        r2 = MEMORY.ref(4, 0x8016f0c).get();
        r3 = CPU.addT(r3, 0x1);
        r3 = CPU.andT(r3, r2);
        MEMORY.ref(2, r6 + 0x12).setu(r3);
      }

      //LAB_8016efc
      r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      r0 = CPU.subT(r0, 0x1);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
      CPU.cmpT(r0, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    //LAB_8016f08
    //LAB_8016f18
    r0 = CPU.movT(0, 0x0);

    //LAB_8016f1a
    CPU.sp().value += 0x34;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
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

    r1 = CPU.movT(0, 0xa0);
    r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(2, r5 + 0x18).setu(r3);
            r2 = CPU.movT(0, 0x1);
            r3 = CPU.addT(r7, 0xea3);
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
            r3 = CPU.movT(0, 0x1);
            r2 = CPU.addT(r7, 0xea3);
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
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

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
    r5 = CPU.sp().value + 0x4;
    r1 = CPU.lslT(r1, 16);
    r0 = CPU.lslT(r0, 17);
    MEMORY.ref(4, r5).setu(r1);
    MEMORY.ref(4, r5 + 0x4).setu(r0);
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
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
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
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
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
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
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
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
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

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
  public static void FUN_80170f8(int r0, final int r1, int r2, int r3) {
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r3, 0x0);
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
            r3 = CPU.r11().value + 0xea4;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = 0xf01c;
            } else {
              //LAB_801714a
              r3 = 0xf010;
            }

            //LAB_801714c
            MEMORY.ref(2, r5).setu(r3);
            r5 = CPU.addT(r5, 0x2);
            r2 = CPU.movT(0, 0x2);
            r2 = CPU.negT(r2, r2);
            r2 += CPU.r8().value;
            r0 = CPU.addT(r5, 0x0);
            CPU.r10().value = r2;
            r0 = FUN_80170c4(r0, 0xf011f011, r2);
            r3 = CPU.r11().value + 0xea4;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            r5 = CPU.addT(r0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = 0xf41c;
            } else {
              //LAB_8017188
              r3 = 0xf012;
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
                r2 = CPU.r8().value;
                MEMORY.ref(2, r5).setu(0xf016);
                r5 = CPU.addT(r5, 0x2);
                CPU.cmpT(r2, 0x2);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.addT(r5, 0x0);
                  r2 = CPU.r10().value;
                  r0 = FUN_80170c4(r0, 0xf020f020, r2);
                  r5 = CPU.addT(r0, 0x0);
                }

                //LAB_80171ca
                r6 = CPU.addT(r6, 0x1);
                MEMORY.ref(2, r5).setu(0xf017);
                r5 = CPU.addT(r5, 0x2);
                r5 += CPU.r9().value;
                r6 = CPU.cmpT(r6, r7);
              } while(!CPU.cpsr().getCarry()); // unsigned <
            }

            //LAB_80171d8
            r3 = CPU.r11().value + 0xea4;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = 0xf81c;
            } else {
              //LAB_80171f4
              r3 = 0xf013;
            }

            //LAB_80171f6
            MEMORY.ref(2, r5).setu(r3);
            r5 = CPU.addT(r5, 0x2);
            r0 = CPU.addT(r5, 0x0);
            r2 = CPU.r10().value;
            r0 = FUN_80170c4(r0, 0xf014f014, r2);
            r3 = CPU.r11().value + 0xea4;
            r3 = MEMORY.ref(1, r3).getUnsigned();
            r5 = CPU.addT(r0, 0x0);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = 0xfc1c;
            } else {
              //LAB_8017224
              r3 = 0xf015;
            }

            //LAB_8017226
            MEMORY.ref(2, r5).setu(r3);
            r3 = CPU.movT(0, 0x1);
            r2 = CPU.r11().value + 0xea3;
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

  @Method(0x8017364)
  public static int FUN_8017364() {
    int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x8017390).get();
    r1 = CPU.movT(0, 0xc4);
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 3);
    r2 = CPU.addT(r3, r1);
    r1 = CPU.movT(0, 0x0);

    //LAB_8017372
    do {
      r3 = MEMORY.ref(4, r2).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(2, r3 + 0x14).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          return 0;
        }
      }

      //LAB_8017380
      r1 = CPU.addT(r1, 0x1);
      r2 = CPU.addT(r2, 0x28);
      CPU.cmpT(r1, 0x3);
    } while(!CPU.cpsr().getZero()); // !=

    //LAB_801738a
    return 1;
  }

  @Method(0x8017394)
  public static int FUN_8017394(final int r0) {
    if(MEMORY.ref(2, r0 + 0x16).getUnsigned() == 0 && MEMORY.ref(2, r0 + 0x1a).get() == 0) {
      return 1;
    }

    return 0;
  }

  @Method(0x80173ac)
  public static void FUN_80173ac() {
    final int r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    MEMORY.ref(2, r2 + 0xeae).setu(15);
    MEMORY.ref(2, r2 + 0xea8).setu(10);
    MEMORY.ref(2, r2 + 0x12b0).setu(9);
    MEMORY.ref(2, r2 + 0xeac).setu(0);
    MEMORY.ref(2, r2 + 0xeaa).setu(1);
  }

  @Method(0x80173f4)
  public static void FUN_80173f4() {
    final int r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    MEMORY.ref(2, r5 + 0x12b8).setu(FUN_8003fa4(0x5f, 0x2000, 0));
    MEMORY.ref(2, r5 + 0x12b0).setu(0x9);
    MEMORY.ref(2, r5 + 0xea8).setu(0xa);
    MEMORY.ref(2, r5 + 0xeac).setu(0);
    MEMORY.ref(2, r5 + 0xeae).setu(0xf);
    MEMORY.ref(2, r5 + 0x12b2).setu(0);
    FUN_80041d8(getRunnable(GoldenSun_801.class, "FUN_801789c"), 0xc80);
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
    r5 = CPU.addT(r0, 0x0);
    r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r3 = CPU.lslT(r5, 8);
    r3 = CPU.asrT(r3, 16);
    CPU.r10().value = r3;
    r1 = CPU.movT(0, 0xc0);
    r3 = CPU.movT(0, 0xff);
    r5 = CPU.andT(r5, r3);
    r0 = CPU.sp().value + 0x4;
    r1 = CPU.lslT(r1, 1);
    MEMORY.call(0x3000164, r0, r1);
    r3 = CPU.addT(r6, 0xea4);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.movT(0, 0x8);
      CPU.r9().value = r2;
    } else {
      //LAB_80178f0
      r3 = CPU.addT(r6, 0xeae);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      r0 = CPU.movT(0, 0x1);
      CPU.r9().value = r0;
    }

    //LAB_80178fa
    CPU.r11().value = r3;
    r3 = CPU.addT(r5, 0x0);
    r3 = CPU.subT(r3, 0x20);
    r3 = CPU.lslT(r3, 5);
    r7 = CPU.addT(r3, 0x8032224); //TODO
    r3 = MEMORY.ref(2, r7).getUnsigned();
    CPU.r8().value = r3;
    r3 = CPU.addT(r6, 0xeac);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r7 = CPU.addT(r7, 0x2);
    CPU.cmpT(r3, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.sp().value;
      r1 = CPU.addT(r1, 0x35);
      r2 = CPU.r9().value;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(0x3000214, r0, r1, r2);
      r1 = CPU.sp().value;
      r1 = CPU.addT(r1, 0x36);
      r2 = CPU.r9().value;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(0x3000214, r0, r1, r2);
      r2 = CPU.r11().value;
      r1 = CPU.sp().value + 0x24;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(0x3000214, r0, r1, r2);
      r1 = CPU.sp().value;
      r2 = CPU.r11().value;
      r1 = CPU.addT(r1, 0x25);
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(0x3000214, r0, r1, r2);
      r2 = CPU.movT(0, 0x1);
      CPU.r8().value += r2;
    } else {
      //LAB_801794c
      r1 = CPU.sp().value;
      r1 = CPU.addT(r1, 0x35);
      r2 = CPU.r9().value;
      r0 = CPU.addT(r7, 0x0);
      MEMORY.call(0x3000214, r0, r1, r2);
      r0 = CPU.addT(r7, 0x0);
      r1 = CPU.sp().value + 0x24;
      r2 = CPU.r11().value;
      MEMORY.call(0x3000214, r0, r1, r2);
    }

    //LAB_8017964
    r0 = CPU.r10().value;
    r3 = CPU.lslT(r0, 16);
    r2 = CPU.lsrT(r3, 16);
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.lslT(r2, 5);
      r7 = CPU.addT(r2, 0x8031e24); //TODO
      r2 = MEMORY.ref(2, r7).get();
      r3 = CPU.addT(r6, 0xeac);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      CPU.r10().value = r2;
      r7 = CPU.addT(r7, 0x2);
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.sp().value + 0x4;
        r2 = CPU.r8().value;
        r6 = CPU.addT(r3, r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x31);
        r2 = CPU.r9().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(0x3000214, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x32);
        r2 = CPU.r9().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(0x3000214, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x20);
        r2 = CPU.r11().value;
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(0x3000214, r0, r1, r2);
        r1 = CPU.addT(r6, 0x0);
        r2 = CPU.r11().value;
        r1 = CPU.addT(r1, 0x21);
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(0x3000214, r0, r1, r2);
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
        r0 = CPU.addT(r7, 0x0);
        MEMORY.call(0x3000214, r0, r1, r2);
        r1 = CPU.addT(r5, 0x0);
        r1 = CPU.addT(r1, 0x20);
        r0 = CPU.addT(r7, 0x0);
        r2 = CPU.r11().value;
        MEMORY.call(0x3000214, r0, r1, r2);
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
    r7 = CPU.addT(r2, 0x0);
    r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
      r1 = CPU.addT(r6, 0x12b2);
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r2 = CPU.movT(0, 0xeb);
      r2 = CPU.lslT(r2, 4);
      r3 = CPU.lslT(r3, 1);
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r6 + r3).setu(r4);
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r5 = CPU.addT(r6, r2);
      r3 = CPU.addT(r3, 0x1);
      r3 = CPU.andT(r3, 0x1ff);
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
              r3 = CPU.subT(r3, 0x20);
              r2 = CPU.subT(r2, 0x20);
              r3 = CPU.lslT(r3, 5);
              r2 = CPU.lslT(r2, 5);
              r3 = MEMORY.ref(2, 0x8032224 + r3).getUnsigned(); //TODO
              r2 = MEMORY.ref(2, 0x8032224 + r2).getUnsigned();
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
        r0 = FUN_8018cac(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
        r7 = CPU.addT(r7, r0);
      } else {
        switch(r4) {
          case 8:
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, 0xeae);
            MEMORY.ref(2, r3).setu(r2);
            r5 = CPU.addT(r5, 0x2);
            break;

          case 9:
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, 0xeac);
            MEMORY.ref(2, r3).setu(r2);
            r5 = CPU.addT(r5, 0x2);
            break;

          case 10:
            r2 = MEMORY.ref(2, r5).getUnsigned();
            r3 = CPU.addT(r6, 0xea8);
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

  @Method(0x8017dd4)
  public static int FUN_8017dd4(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;
    int r8;
    int r9;

    r3 = CPU.movT(0, 0x0);
    r6 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r0, 0x0);
    r8 = r2;
    r9 = r3;
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0x1);
        r9 = r3;
      }

      //LAB_8017df4
      r6 = CPU.negT(r6, r6);
    }

    //LAB_8017df6
    r3 = CPU.movT(0, 0x20);
    r5 = CPU.addT(r7, 0x0);
    MEMORY.ref(1, r7).setu(r3);
    r5 = CPU.addT(r5, 0xc);
    CPU.r10().value = r7;

    //LAB_8017e00
    do {
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.movT(0, 0xa);
      r0 = FUN_80022fc(r0, r1);
      r0 = CPU.addT(r0, 0x30);
      MEMORY.ref(1, r5).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r6, 0x0);
      r0 = FUN_80022ec(r0, r1);
      r5 = CPU.subT(r5, 0x1);
      r6 = CPU.addT(r0, 0x0);
      CPU.cmpT(r5, CPU.r10().value);
    } while(!CPU.cpsr().getZero()); // !=

    r0 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r7 + 0xd).setu(r0);
    r1 = CPU.movT(0, 0x20);
    r0 = CPU.movT(0, 0x1);
    r4 = CPU.movT(0, 0x2d);
    r2 = CPU.addT(r7, 0x0);

    jmp_8017e48:
    if(r0 != 0xd) {
      r3 = MEMORY.ref(1, r2 + 0x1).getUnsigned();
      if(r3 == 0x30) {
        if(r0 != 0xc) {
          MEMORY.ref(1, r2 + 0x1).setu(r1);
        }

        //LAB_8017e2a
        do {
          r2 = CPU.addT(r2, 0x1);
          r0 = CPU.addT(r0, 0x1);

          //LAB_8017e2e
          if(r0 == 0xd) {
            break jmp_8017e48;
          }
          r3 = MEMORY.ref(1, r2 + 0x1).getUnsigned();
          if(r3 != 0x30) {
            break;
          }
          if(r0 != 0xc) {
            MEMORY.ref(1, r2 + 0x1).setu(r1);
          }
        } while(true);
      }

      //LAB_8017e40
      r3 = r9;
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(1, r2).setu(r4);
      }
    }

    //LAB_8017e48
    r3 = r8;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = MEMORY.ref(1, r7).getUnsigned();
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x20);
      if(CPU.cpsr().getZero()) { // ==
        r2 = CPU.addT(r7, 0x0);

        //LAB_8017e58
        do {
          r0 = CPU.addT(r0, 0x1);
          CPU.cmpT(r0, 0xc);
          if(CPU.cpsr().getZero()) { // ==
            break;
          }
          r2 = CPU.addT(r2, 0x1);
          r3 = MEMORY.ref(1, r2).getUnsigned();
          CPU.cmpT(r3, 0x20);
        } while(CPU.cpsr().getZero()); // ==
      }

      //LAB_8017e66
      r0 = CPU.addT(r7, r0);
    } else {
      //LAB_8017e6a
      CPU.cmpT(r3, 0xc);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r3 = CPU.movT(0, 0xc);
        r8 = r3;
      }

      //LAB_8017e74
      r0 = CPU.subT(r7, r3);
      r0 = CPU.addT(r0, 0xd);
    }

    //LAB_8017e7a
    return r0;
  }

  @Method(0x8017e88)
  public static int FUN_8017e88(int r0, int r1, int r2, int r3, final int a4, final int a5, final int a6) {
    int r4;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r9;
    final int r10;
    final int lr;

    CPU.sp().value -= 0x20;
    r10 = r0;
    r5 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r2, 0x0);
    r2 = a6;
    r7 = CPU.addT(r3, 0x0);
    r3 = r10;
    r8 = a4;
    lr = r2;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8017edc).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r2 = MEMORY.ref(4, 0x8017ee4).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      r3 = CPU.lslT(r0, 1);
      r1 = MEMORY.ref(4, 0x8017ee0).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
    }

    //LAB_8017ec8
    r4 = r8;
    if(r4 == 1 || (r4 == 3 && a5 == 0)) {
      //LAB_8017ee8
      r9 = CPU.sp().value;
      r3 = MEMORY.ref(4, 0x8017fa4).get();
      r1 = CPU.movT(0, 0x0);
      r2 = r9;
      CPU.r12().value = r1;
      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();

      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);

      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r2, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        r3 = CPU.subT(r3, 0x1);
        CPU.r12().value = r3;
        r5 = CPU.addT(r5, 0x4);
      }

      //LAB_8017f0c
      if(CPU.r12().value == 0) {
        CPU.r12().value = 2;
        if(r2 != 0x41 && r2 != 0x49 && r2 != 0x55 && r2 != 0x45 && r2 != 0x4f) {
          CPU.r12().value = 1;
        }
      }

      //LAB_8017f2e
      r3 = CPU.movT(0, 0x7);
      r6 = CPU.r12().value;
      r6 = CPU.andT(r6, r3);
      r3 = CPU.lslT(r6, 2);
      r1 = r9;
      r4 = MEMORY.ref(4, r1 + r3).get();
      r3 = MEMORY.ref(1, r4).getUnsigned();
      r1 = CPU.lslT(r3, 24);
      r6 = CPU.movT(0, 0x0);
      r4 = CPU.addT(r4, 0x1);
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8017fa8).get();
        CPU.r12().value = r2;

        //LAB_8017f4a
        do {
          r2 = CPU.lslT(r0, 1);
          r3 = CPU.asrT(r1, 24);
          MEMORY.ref(2, r2 + r7).setu(r3);
          r0 = CPU.addT(r0, 0x1);
          r3 = CPU.r12().value;
          r6 = CPU.addT(r6, 0x1);
          r0 = CPU.andT(r0, r3);
          CPU.cmpT(r6, 0x7);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r3 = CPU.lslT(r3, 24);
          r4 = CPU.addT(r4, 0x1);
          r1 = CPU.addT(r3, 0x0);
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }
      r2 = MEMORY.ref(2, r5).getUnsigned();
    } else {
      //LAB_8017f6a
      r3 = MEMORY.ref(2, r5).getUnsigned();
      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r3, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.addT(r5, 0x4);
        r2 = MEMORY.ref(2, r5).getUnsigned();
      }
    }

    //LAB_8017f76
    r3 = CPU.addT(r2, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = MEMORY.ref(4, 0x8017fa8).get();
      r4 = CPU.movT(0, 0x1);
      r1 = CPU.movT(0, 0x0);

      //LAB_8017f82
      do {
        r2 = CPU.lslT(r2, 16);
        r2 = CPU.asrT(r2, 16);
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r2 = CPU.lslT(r2, 16);
        r0 = CPU.addT(r0, 0x1);
        r2 = CPU.lsrT(r2, 16);
        r5 = CPU.addT(r5, 0x2);
        r0 = CPU.andT(r0, r6);
        if(r2 == 0x53 || r2 == 0x73) {
          //LAB_8017f9c
          r2 = lr;
          MEMORY.ref(4, r2).setu(r4);
        } else {
          //LAB_8017fac
          r3 = lr;
          MEMORY.ref(4, r3).setu(r1);
        }

        //LAB_8017fb0
        r2 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8017fb8
    r4 = r8;
    if(r4 == 0x2 || r4 == 0x3 && a5 != 0) {
      //LAB_8017fc8
      r1 = lr;
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8018004).get();
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r3 = MEMORY.ref(4, 0x8018014).get();
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.andT(r0, r3);
      }

      //LAB_8017fdc
      r2 = MEMORY.ref(4, 0x8018008).get();
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r2);
      r3 = MEMORY.ref(4, 0x8018014).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r3);
    }

    //LAB_8017fe8
    r2 = r10;
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = MEMORY.ref(4, 0x8018014).get();
      r3 = MEMORY.ref(4, 0x801800c).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018010).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018034).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r1);
    }

    //LAB_8018024
    CPU.sp().value += 0x20;
    return r0;
  }

  @Method(0x8018038)
  public static int FUN_8018038(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    final int r8;
    final int r9;
    int r10;
    final int r11;

    CPU.sp().value -= 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    r0 = MEMORY.ref(4, 0x8018170).get();
    r11 = r1;
    r1 = MEMORY.ref(4, r0).get();
    r2 = CPU.movT(0, 0x1);
    r3 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(4, 0x8018174).get();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
    r3 = CPU.addT(r1, r5);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
    r2 = CPU.movT(0, 0xeb);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
    r6 = CPU.addT(r3, 0x0);
    r2 = CPU.lslT(r2, 4);
    r5 = CPU.movT(0, 0x1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    r10 = r0;
    r7 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.addT(r1, r2);
    r5 = CPU.negT(r5, r5);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r7);
    r8 = r1;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
    r3 = CPU.cmpT(r3, r5);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r1 = MEMORY.ref(4, 0x8018178).get();
      r3 = CPU.addT(r0, r1);
      r3 = MEMORY.ref(2, r3).getUnsigned();
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
    } else {
      //LAB_8018092
      r5 = 0x140;
      r1 = mallocSlotChip(50, r5);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

      MEMORY.setFunction(r1, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r3 = r10;
      r2 = CPU.sp().value + 0x38;
      r3 = CPU.addT(r3, 0x8c);
      r3 = MEMORY.ref(4, r3).get();
      r10 = r2;
      r0 = r10;
      r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      r9 = r3;
      FUN_8019bac(r0, r1);
      r3 = CPU.sp().value;
      r3 = CPU.addT(r3, 0x54);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);

      //LAB_80180c8
      do {
        r0 = r10;
        r0 = (int)MEMORY.call(r9, r0);
        r5 = CPU.addT(r7, 0x0);
        r7 = CPU.addT(r0, 0x0);
        CPU.cmpT(r7, 0xff);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r7 = CPU.movT(0, 0x40);
        }

        //LAB_80180d8
        r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        CPU.cmpT(r0, 0x0);
        jmp_8018614:
        if(!CPU.cpsr().getZero()) { // !=
          CPU.cmpT(r7, 0x1f);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_80180e4
            CPU.cmpT(r7, 0x12);
            if(CPU.cpsr().getZero()) { // ==
              r0 = r10;
              r0 = (int)MEMORY.call(r9, r0);
            } else {
              CPU.cmpT(r7, 0x12);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                //LAB_801810e
                CPU.cmpT(r7, 0x16);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_8018142
                  r0 = CPU.movT(0, 0x5);
                  r1 = r11;
                  r0 = FUN_8019944(r0, r1);
                } else {
                  CPU.cmpT(r7, 0x16);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    CPU.cmpT(r7, 0x14);
                    if(CPU.cpsr().getZero()) { // ==
                      //LAB_8018146
                      r0 = r10;
                      r0 = (int)MEMORY.call(r9, r0);
                      r0 = CPU.movT(0, 0x2);
                    } else {
                      CPU.cmpT(r7, 0x14);
                      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                        //LAB_8018150
                        r0 = CPU.movT(0, 0x4);
                      } else {
                        r0 = r10;
                        r0 = (int)MEMORY.call(r9, r0);
                        r0 = CPU.movT(0, 0x3);
                      }
                    }
                    r1 = r11;
                    r0 = FUN_8019944(r0, r1);
                  } else {
                    //LAB_8018128
                    CPU.cmpT(r7, 0x1d);
                    if(CPU.cpsr().getZero()) { // ==
                      r0 = r10;
                      r0 = (int)MEMORY.call(r9, r0);
                    } else {
                      CPU.cmpT(r7, 0x1d);
                      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                        //LAB_8018136
                        CPU.cmpT(r7, 0x1e);
                        if(CPU.cpsr().getZero()) { // ==
                          //LAB_801813c
                          r1 = CPU.movT(0, 0x0);
                          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
                        }
                      } else {
                        CPU.cmpT(r7, 0x17);
                        if(CPU.cpsr().getZero()) { // ==
                          //LAB_8018154
                          r0 = CPU.movT(0, 0x6);
                          r1 = r11;
                          r0 = FUN_8019944(r0, r1);
                        }
                      }
                    }
                  }
                }
              } else {
                CPU.cmpT(r7, 0x9);
                if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                  //LAB_8018102
                  CPU.cmpT(r7, 0x10);
                  if(!CPU.cpsr().getZero()) { // !=
                    //LAB_8018108
                    CPU.cmpT(r7, 0x11);
                    if(CPU.cpsr().getZero()) { // ==
                      r0 = r10;
                      r0 = (int)MEMORY.call(r9, r0);
                    }
                  }
                } else {
                  CPU.cmpT(r7, 0x8);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r0 = r10;
                    r0 = (int)MEMORY.call(r9, r0);
                  } else {
                    CPU.cmpT(r7, 0x1);
                    if(CPU.cpsr().getZero()) { // ==
                      //LAB_8018166
                      r2 = CPU.movT(0, 0x0);
                      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
                      r7 = CPU.movT(0, 0x2);
                    } else {
                      CPU.cmpT(r7, 0x1);
                      if(r7 < 1 || r7 == 2) {
                        r1 = CPU.movT(0, 0x0);
                        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
                      }
                    }
                  }
                }
              }
            }
          }
        } else {
          //LAB_8018188
          r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r1 = MEMORY.ref(4, 0x80181d0).get();
          r3 = CPU.addT(r0, r1);
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            CPU.cmpT(r2, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              CPU.cmpT(r7, 0xde);
              if(!CPU.cpsr().getZero()) { // !=
                CPU.cmpT(r7, 0xdf);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = MEMORY.ref(4, 0x80181cc).get();
                  r2 = CPU.lslT(r6, 1);
                  r0 = r8;
                  r1 = MEMORY.ref(4, 0x80181d4).get();
                  r6 = CPU.addT(r6, 0x1);
                  MEMORY.ref(2, r2 + r0).setu(r3);
                  r6 = CPU.andT(r6, r1);
                }
              }
            }
          }

          //LAB_80181b0
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r0 = MEMORY.ref(4, 0x80181d8).get();
          r3 = CPU.addT(r2, r0);
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            CPU.cmpT(r1, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              CPU.cmpT(r7, 0xde);
              if(!CPU.cpsr().getZero()) { // !=
                CPU.cmpT(r7, 0xdf);
                if(!CPU.cpsr().getZero()) { // !=
                  r2 = CPU.movT(0, 0x80);
                  r2 = CPU.lslT(r2, 1);
                  r5 = CPU.cmpT(r5, r2);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    CPU.cmpT(r5, 0x7f);
                    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                      CPU.cmpT(r5, 0xde);
                      if(!CPU.cpsr().getZero()) { // !=
                        CPU.cmpT(r5, 0xdf);
                        if(!CPU.cpsr().getZero()) { // !=
                          CPU.cmpT(r5, 0x20);
                          if(!CPU.cpsr().getZero()) { // !=
                            CPU.cmpT(r5, 0xa5);
                            if(!CPU.cpsr().getZero()) { // !=
                              CPU.cmpT(r5, 0xa1);
                              if(!CPU.cpsr().getZero()) { // !=
                                CPU.cmpT(r5, 0xa4);
                                if(!CPU.cpsr().getZero()) { // !=
                                  r3 = MEMORY.ref(4, 0x801822c).get();
                                  r2 = CPU.lslT(r6, 1);
                                  r5 = r8;
                                  r0 = MEMORY.ref(4, 0x8018230).get();
                                  r6 = CPU.addT(r6, 0x1);
                                  MEMORY.ref(2, r2 + r5).setu(r3);
                                  r6 = CPU.andT(r6, r0);
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

          //LAB_801820e
          CPU.cmpT(r7, 0x1f);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r2 = MEMORY.ref(4, 0x8018234).get();
            r3 = CPU.addT(r1, r2);
            r3 = MEMORY.ref(1, r3).getUnsigned();
            if(r3 != 0 && (r7 == 0x20 || MEMORY.ref(4, CPU.sp().value + 0x1c).get() < 0 || MEMORY.ref(4, CPU.sp().value + 0x1c).get() > 0xa)) {
              //LAB_8018228
              r0 = MEMORY.ref(4, 0x8018230).get();
              r3 = CPU.lslT(r6, 1);
              r2 = MEMORY.ref(4, 0x8018264).get();
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, r0);
              r5 = r8;
              MEMORY.ref(2, r3 + r5).setu(r2);
              r3 = CPU.lslT(r6, 1);
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, r0);
              r1 = r8;
              MEMORY.ref(2, r3 + r1).setu(r2);
              r3 = CPU.lslT(r6, 1);
              MEMORY.ref(2, r3 + r5).setu(r2);
              r6 = CPU.addT(r6, 0x1);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r6 = CPU.andT(r6, r0);
              r0 = CPU.movT(0, 0x1);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
              CPU.cmpT(r1, 0xa);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r7 = CPU.movT(0, 0x20);
              }
            }

            //LAB_8018268
            CPU.cmpT(r7, 0x22);
            if(CPU.cpsr().getZero()) { // ==
              r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r3 = CPU.movT(0, 0x1);
              r2 = CPU.eorT(r2, r3);
              MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
              CPU.cmpT(r2, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r7 = CPU.movT(0, 0x8e);
              }
            }

            //LAB_801827a
            r0 = MEMORY.ref(4, 0x801856c).get();
            r3 = CPU.lslT(r6, 1);
            r5 = r8;
            r6 = CPU.addT(r6, 0x1);
            r1 = CPU.movT(0, 0x0);
            MEMORY.ref(2, r3 + r5).setu(r7);
            r6 = CPU.andT(r6, r0);
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
            break jmp_8018614;
          }

          //LAB_801828c
          CPU.cmpT(r7, 0x14);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_80183d8
            r0 = r10;
            r0 = (int)MEMORY.call(r9, r0);
            r1 = r11;
            r5 = CPU.subT(r0, 0x1);
            r0 = CPU.movT(0, 0x2);
            r0 = FUN_8019944(r0, r1);
            r2 = CPU.addT(r0, 0x0);
            r0 = MEMORY.ref(4, 0x801856c).get();
            r2 = CPU.andT(r2, r0);
            r0 = MEMORY.ref(4, 0x8018578).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = CPU.addT(r2, r0);
            r2 = CPU.movT(0, 0x18);
            FUN_80196c4(r0, r1, r2);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = CPU.sp().value + 0x34;
            r0 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, r1, r3);
            r6 = CPU.addT(r0, 0x0);
            break jmp_8018614;
          }

          //LAB_8018292
          CPU.cmpT(r7, 0x14);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            CPU.cmpT(r7, 0x9);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              //LAB_80182b4
              CPU.cmpT(r7, 0x11);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_80184e4
                r0 = r10;
                r0 = (int)MEMORY.call(r9, r0);
                r2 = CPU.subT(r0, 0x1);
                r0 = CPU.addT(r2, 0x0);
                r0 = FUN_8077008(r0);
                r1 = CPU.sp().value + 0x54;
                r2 = CPU.addT(r1, 0x0);
                r4 = CPU.movT(0, 0x0);

                //LAB_80184f8
                do {
                  r3 = MEMORY.ref(1, r0).getUnsigned();
                  r4 = CPU.addT(r4, 0x1);
                  MEMORY.ref(2, r2).setu(r3);
                  r0 = CPU.addT(r0, 0x1);
                  r2 = CPU.addT(r2, 0x2);
                  CPU.cmpT(r4, 0xe);
                } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

                //LAB_8018506
                r0 = FUN_8017e88(0, r1, r6, r8, 0, 0, CPU.sp().value + 0x34);
                r6 = CPU.addT(r0, 0x0);
                break jmp_8018614;
              }

              //LAB_80182ba
              CPU.cmpT(r7, 0x11);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                //LAB_80182c6
                CPU.cmpT(r7, 0x12);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_80184aa
                  r0 = r10;
                  r0 = (int)MEMORY.call(r9, r0);
                  r1 = r11;
                  r5 = CPU.subT(r0, 0x1);
                  r0 = CPU.movT(0, 0x1);
                  r0 = FUN_8019944(r0, r1);
                  r0 = FUN_8077008(r0);
                  r1 = CPU.sp().value + 0x54;
                  r2 = CPU.addT(r1, 0x0);
                  r4 = CPU.movT(0, 0x0);

                  //LAB_80184c4
                  do {
                    r3 = MEMORY.ref(1, r0).getUnsigned();
                    r4 = CPU.addT(r4, 0x1);
                    MEMORY.ref(2, r2).setu(r3);
                    r0 = CPU.addT(r0, 0x1);
                    r2 = CPU.addT(r2, 0x2);
                    CPU.cmpT(r4, 0xe);
                  } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

                  r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  r3 = CPU.sp().value + 0x34;
                  r0 = FUN_8017e88(0, r1, r6, r8, r5, r2, r3);
                  r6 = CPU.addT(r0, 0x0);
                  break jmp_8018614;
                }

                //LAB_80182cc
                CPU.cmpT(r7, 0x13);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_80183a6
                  r0 = r10;
                  r0 = (int)MEMORY.call(r9, r0);
                  r1 = r11;
                  r5 = CPU.subT(r0, 0x1);
                  r0 = CPU.movT(0, 0x3);
                  r0 = FUN_8019944(r0, r1);
                  r2 = CPU.addT(r0, 0x0);
                  r0 = MEMORY.ref(4, 0x8018574).get();
                  r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                  r0 = CPU.addT(r2, r0);
                  r2 = CPU.movT(0, 0x18);
                  FUN_80196c4(r0, r1, r2);
                  r0 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
                  r6 = CPU.addT(r0, 0x0);
                  break jmp_8018614;
                }
              } else {
                CPU.cmpT(r7, 0x10);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_8018486
                  r3 = MEMORY.ref(4, 0x8018584).get();
                  r0 = CPU.movT(0, 0xfa);
                  r0 = CPU.lslT(r0, 1);
                  r3 = CPU.addT(r3, r0);
                  r0 = MEMORY.ref(4, r3).get();
                  r0 = FUN_8077008(r0);
                  r1 = CPU.sp().value + 0x54;
                  r2 = CPU.addT(r1, 0x0);
                  r4 = CPU.movT(0, 0x0);

                  //LAB_801849a
                  do {
                    r3 = MEMORY.ref(1, r0).getUnsigned();
                    r4 = CPU.addT(r4, 0x1);
                    MEMORY.ref(2, r2).setu(r3);
                    r0 = CPU.addT(r0, 0x1);
                    r2 = CPU.addT(r2, 0x2);
                    CPU.cmpT(r4, 0xe);
                  } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
                  r0 = FUN_8017e88(0, r1, r6, r8, 0, 0, CPU.sp().value + 0x34);
                  r6 = CPU.addT(r0, 0x0);
                  break jmp_8018614;
                }
              }
            } else {
              CPU.cmpT(r7, 0x8);
              if(CPU.cpsr().getCarry()) { // unsigned >=
                //LAB_8018320
                r0 = MEMORY.ref(4, 0x801856c).get();
                r3 = CPU.lslT(r6, 1);
                r5 = r8;
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, r0);
                MEMORY.ref(2, r3 + r5).setu(r7);
                r0 = r10;
                r0 = (int)MEMORY.call(r9, r0);
                r1 = MEMORY.ref(4, 0x8018570).get();
                r3 = CPU.lslT(r6, 1);
                r0 = CPU.addT(r0, r1);
                r2 = r8;
                MEMORY.ref(2, r3 + r2).setu(r0);
                r3 = MEMORY.ref(4, 0x801856c).get();
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, r3);
                break jmp_8018614;
              }
              CPU.cmpT(r7, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                r1 = CPU.movT(0, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
              } else {
                //LAB_80182a4
                CPU.cmpT(r7, 0x1);
                if(!CPU.cpsr().getCarry()) { // unsigned <
                  r3 = CPU.movT(0, 0x0);
                  MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
                  break jmp_8018614;
                }
                CPU.cmpT(r7, 0x2);
                if(CPU.cpsr().getZero()) { // ==
                  r3 = CPU.movT(0, 0x0);
                  MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
                  break jmp_8018614;
                }
                CPU.cmpT(r7, 0x3);
                if(CPU.cpsr().getZero()) { // ==
                  r1 = CPU.movT(0, 0x1);
                  MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
                }
              }
            }
          } else {
            //LAB_80182d2
            CPU.cmpT(r7, 0x19);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_8018588
              r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              CPU.cmpT(r2, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = MEMORY.ref(4, 0x80185b4).get();
                  r2 = CPU.lslT(r6, 1);
                  r5 = r8;
                  r0 = MEMORY.ref(4, 0x80185bc).get();
                  r6 = CPU.addT(r6, 0x1);
                  MEMORY.ref(2, r2 + r5).setu(r3);
                  r6 = CPU.andT(r6, r0);
                }

                //LAB_80185a2
                r3 = MEMORY.ref(4, 0x80185b8).get();
                r2 = CPU.lslT(r6, 1);
                r1 = r8;
                MEMORY.ref(2, r2 + r1).setu(r3);
                r2 = MEMORY.ref(4, 0x80185bc).get();
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, r2);
              }
              break jmp_8018614;
            }

            //LAB_80182d8
            CPU.cmpT(r7, 0x19);
            if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
              CPU.cmpT(r7, 0x16);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8018344
                r1 = r11;
                r0 = CPU.movT(0, 0x5);
                r0 = FUN_8019944(r0, r1);
                r1 = CPU.addT(r0, 0x0);
                r3 = CPU.addT(r1, 0x0);
                CPU.cmpT(r1, 0x0);
                if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                  r3 = CPU.negT(r3, r1);
                }

                //LAB_8018356
                r5 = CPU.movT(0, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);
                CPU.cmpT(r3, 0x1);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r0 = CPU.movT(0, 0x0);
                  MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
                }

                //LAB_8018362
                r5 = CPU.sp().value + 0x44;
                r0 = CPU.addT(r5, 0x0);
                r2 = CPU.movT(0, 0x0);
                r0 = FUN_8017dd4(r0, r1, r2);
                r4 = CPU.subT(r0, r5);
                CPU.cmpT(r4, 0x10);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_8018374
                  r3 = MEMORY.ref(1, r5 + r4).getUnsigned();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    //LAB_801837c
                    r1 = MEMORY.ref(4, 0x801856c).get();
                    r0 = CPU.addT(r4, r5);
                    CPU.r12().value = r1;
                    r1 = CPU.addT(r0, 0x0);

                    //LAB_8018384
                    do {
                      r3 = MEMORY.ref(1, r1).getUnsigned();
                      r2 = CPU.lslT(r6, 1);
                      r5 = r8;
                      MEMORY.ref(2, r2 + r5).setu(r3);
                      r6 = CPU.addT(r6, 0x1);
                      r2 = CPU.r12().value;
                      r4 = CPU.addT(r4, 0x1);
                      r1 = CPU.addT(r1, 0x1);
                      r6 = CPU.andT(r6, r2);
                      CPU.cmpT(r4, 0x10);
                      if(CPU.cpsr().getZero()) { // ==
                        break;
                      }

                      //LAB_801839c
                      r0 = CPU.addT(r0, 0x1);
                      r3 = MEMORY.ref(1, r0).getUnsigned();
                      CPU.cmpT(r3, 0x0);
                    } while(!CPU.cpsr().getZero()); // !=
                  }
                }
                break jmp_8018614;
              }
              CPU.cmpT(r7, 0x16);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                //LAB_801840e
                r1 = r11;
                r0 = CPU.movT(0, 0x4);
                r0 = FUN_8019944(r0, r1);
                r2 = CPU.addT(r0, 0x0);
                r0 = MEMORY.ref(4, 0x801857c).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r0 = CPU.addT(r2, r0);
                r2 = CPU.movT(0, 0x18);
                FUN_80196c4(r0, r1, r2);
                r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r2 = MEMORY.ref(2, r1).getUnsigned();
                r3 = CPU.addT(r2, 0x0);
                r0 = CPU.addT(r6, 0x0);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r4 = MEMORY.ref(4, 0x801856c).get();

                  //LAB_8018432
                  do {
                    r3 = CPU.lslT(r0, 1);
                    r5 = r8;
                    MEMORY.ref(2, r3 + r5).setu(r2);
                    r1 = CPU.addT(r1, 0x2);
                    r2 = MEMORY.ref(2, r1).getUnsigned();
                    r0 = CPU.addT(r0, 0x1);
                    r3 = CPU.addT(r2, 0x0);
                    r0 = CPU.andT(r0, r4);
                    CPU.cmpT(r3, 0x0);
                  } while(!CPU.cpsr().getZero()); // !=
                }
                r6 = CPU.addT(r0, 0x0);
                break jmp_8018614;
              }

              //LAB_80182e6
              CPU.cmpT(r7, 0x17);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8018448
                r1 = r11;
                r0 = CPU.movT(0, 0x6);
                r0 = FUN_8019944(r0, r1);
                r1 = CPU.movT(0, 0x1);
                r0 = FUN_808a5d0(r0, r1);
                r3 = MEMORY.ref(4, 0x8018580).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r0 = CPU.addT(r0, r3);
                r2 = CPU.movT(0, 0x18);
                FUN_80196c4(r0, r1, r2);
                r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r2 = MEMORY.ref(2, r1).getUnsigned();
                r3 = CPU.addT(r2, 0x0);
                r0 = CPU.addT(r6, 0x0);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r4 = MEMORY.ref(4, 0x801856c).get();

                  //LAB_8018470
                  do {
                    r3 = CPU.lslT(r0, 1);
                    r5 = r8;
                    MEMORY.ref(2, r3 + r5).setu(r2);
                    r1 = CPU.addT(r1, 0x2);
                    r2 = MEMORY.ref(2, r1).getUnsigned();
                    r0 = CPU.addT(r0, 0x1);
                    r3 = CPU.addT(r2, 0x0);
                    r0 = CPU.andT(r0, r4);
                    CPU.cmpT(r3, 0x0);
                  } while(!CPU.cpsr().getZero()); // !=
                }
                r6 = CPU.addT(r0, 0x0);
                break jmp_8018614;
              }

              //LAB_80182ec
              CPU.cmpT(r7, 0x18);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8018546
                r3 = MEMORY.ref(4, 0x8018564).get();
                r0 = MEMORY.ref(4, 0x801856c).get();
                r2 = CPU.lslT(r6, 1);
                r5 = r8;
                r6 = CPU.addT(r6, 0x1);
                MEMORY.ref(2, r2 + r5).setu(r3);
                r6 = CPU.andT(r6, r0);
                r3 = MEMORY.ref(4, 0x8018568).get();
                r2 = CPU.lslT(r6, 1);
                r1 = r8;
                r6 = CPU.addT(r6, 0x1);
                MEMORY.ref(2, r2 + r1).setu(r3);
                r6 = CPU.andT(r6, r0);
                break jmp_8018614;
              }

              //LAB_80182f2
            } else {
              //LAB_80182f4
              CPU.cmpT(r7, 0x1d);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8018320
                r0 = MEMORY.ref(4, 0x801856c).get();
                r3 = CPU.lslT(r6, 1);
                r5 = r8;
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, r0);
                MEMORY.ref(2, r3 + r5).setu(r7);
                r0 = r10;
                r0 = (int)MEMORY.call(r9, r0);
                r1 = MEMORY.ref(4, 0x8018570).get();
                r3 = CPU.lslT(r6, 1);
                r0 = CPU.addT(r0, r1);
                r2 = r8;
                MEMORY.ref(2, r3 + r2).setu(r0);
                r3 = MEMORY.ref(4, 0x801856c).get();
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, r3);
                break jmp_8018614;
              }
              CPU.cmpT(r7, 0x1d);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                CPU.cmpT(r7, 0x1a);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_801851e
                  r0 = r10;
                  r0 = (int)MEMORY.call(r9, r0);
                  r0 = CPU.subT(r0, 0x1);
                  r0 = CPU.lslT(r0, 1);
                  r1 = MEMORY.ref(4, 0x801856c).get();
                  r3 = CPU.lslT(r6, 1);
                  r2 = CPU.addT(r0, 0x0);
                  r6 = CPU.addT(r6, 0x1);
                  r2 = CPU.addT(r2, 0x80);
                  r6 = CPU.andT(r6, r1);
                  r5 = r8;
                  MEMORY.ref(2, r3 + r5).setu(r2);
                  r0 = CPU.addT(r0, 0x81);
                  r3 = CPU.lslT(r6, 1);
                  r2 = r8;
                  r6 = CPU.addT(r6, 0x1);
                  MEMORY.ref(2, r3 + r2).setu(r0);
                  r6 = CPU.andT(r6, r1);
                  break jmp_8018614;
                }

                //LAB_8018302
                CPU.cmpT(r7, 0x1b);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_80185c0
                  r2 = MEMORY.ref(4, 0x80185e4).get();
                  r3 = CPU.lslT(r6, 1);
                  r5 = r8;
                  MEMORY.ref(2, r3 + r5).setu(r2);
                  r1 = MEMORY.ref(4, 0x80185ec).get();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                  r6 = CPU.addT(r6, 0x1);
                  r6 = CPU.andT(r6, r1);
                  CPU.cmpT(r3, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r3 = MEMORY.ref(4, 0x80185e8).get();
                    r2 = CPU.lslT(r6, 1);
                    r0 = r8;
                    r6 = CPU.addT(r6, 0x1);
                    MEMORY.ref(2, r2 + r0).setu(r3);
                    r6 = CPU.andT(r6, r1);
                  }
                  break jmp_8018614;
                }

                //LAB_8018308
              } else {
                //LAB_801830a
                CPU.cmpT(r7, 0x1e);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_801831a
                  r3 = CPU.movT(0, 0x0);
                  MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
                  break jmp_8018614;
                }
                r2 = CPU.movT(0, 0x1);
                r2 = CPU.negT(r2, r2);
                r7 = CPU.cmpT(r7, r2);
                if(CPU.cpsr().getZero()) { // ==
                  break jmp_8018614;
                }
              }
            }
          }

          //LAB_80185f4
          r3 = CPU.lslT(r6, 1);
          r2 = r8;
          MEMORY.ref(2, r3 + r2).setu(r7);
          r3 = MEMORY.ref(4, 0x801860c).get();
          r6 = CPU.addT(r6, 0x1);
          r6 = CPU.andT(r6, r3);
          if(r7 == 0x73 || r7 == 0x53) {
            //LAB_8018608
            r3 = CPU.movT(0, 0x1);
          } else {
            //LAB_8018610
            r3 = CPU.movT(0, 0x0);
          }

          //LAB_8018612
          MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        }

        //LAB_8018614
        r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r5 = CPU.addT(r5, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5);
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          break;
        }
        r1 = MEMORY.ref(4, 0x801866c).get();
        r5 = CPU.cmpT(r5, r1);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
      } while(true);

      //LAB_8018628
      r1 = MEMORY.ref(4, 0x801866c).get();
      r3 = CPU.lslT(r6, 1);
      r2 = r8;
      r6 = CPU.addT(r6, 0x1);
      MEMORY.ref(2, r3 + r2).setu(r7);
      r6 = CPU.andT(r6, r1);
      r3 = MEMORY.ref(4, 0x8018668).get();
      r2 = CPU.lslT(r6, 1);
      r5 = r8;
      MEMORY.ref(2, r2 + r5).setu(r3);
      r3 = CPU.addT(r6, 0x1);
      r3 = CPU.andT(r3, r1);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r1 = MEMORY.ref(4, 0x8018670).get();
      r2 = CPU.addT(r0, r1);
      MEMORY.ref(2, r2).setu(r3);
      freeSlot(50);
      r5 = MEMORY.ref(4, 0x8018674).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      r0 = CPU.sp().value + 0x20;
      r0 = MEMORY.ref(2, r0).getUnsigned();
      r3 = CPU.addT(r2, r5);
      MEMORY.ref(2, r3).setu(r0);
    }

    //LAB_801865a
    r1 = r11;
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_80198dc();
    }

    //LAB_8018678
    r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
    CPU.sp().value += 0x84;
    return r0;
  }

  @Method(0x801868c)
  public static void FUN_801868c(int r0, int r1, int r2, int r3, final int a4, final int a5, final int a6) {
    final int r4;
    final int r5;
    int r6;
    int r7;
    final int r8;
    final int r9;
    int r10;
    final int r11;

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r5 = CPU.addT(r3, 0x0);
    r3 = MEMORY.ref(4, 0x8018788).get();
    r2 = a4;
    r3 = MEMORY.ref(4, r3).get();
    r8 = r2;
    r9 = r3;
    r2 = CPU.movT(0, 0x1e);
    r3 = MEMORY.ref(4, CPU.sp().value).get();
    r10 = r2;
    r2 = a6;
    r7 = MEMORY.ref(4, r3).get();
    r3 = CPU.movT(0, 0x2);
    r3 = CPU.andT(r3, r2);
    r11 = r1;
    r4 = a5;
    r6 = MEMORY.ref(4, r1).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.addT(r5, 0x0);
        r2 = r8;
        r3 = CPU.addT(r4, 0x0);
        FUN_8018a50(r0, r1, r2, r3);
      } else {
        //LAB_80186d6
        r1 = CPU.addT(r5, 0x0);
        r2 = r8;
        r3 = CPU.addT(r4, 0x0);
        FUN_8018850(r0, r1, r2, r3);
      }
    }

    //LAB_80186e0
    r1 = MEMORY.ref(4, r5).get();
    if(r1 != 0 || MEMORY.ref(4, r8).get() != 0) {
      //LAB_80186ee
      r2 = a6;
      r3 = CPU.movT(0, 0x2);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.addT(r3, 0x13);
        r3 = CPU.lsrT(r3, 3);
        MEMORY.ref(4, r5).setu(r3);
        r0 = r8;
        r3 = MEMORY.ref(4, r0).get();
        r3 = CPU.addT(r3, 0xf);
        r3 = CPU.lsrT(r3, 3);
        MEMORY.ref(4, r0).setu(r3);
        r3 = MEMORY.ref(4, 0x801878c).get();
        r3 += r9;
        r3 = MEMORY.ref(1, r3).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r5).get();
          r2 = CPU.movT(0, 0x1d);
          r3 = CPU.addT(r3, 0x2);
          MEMORY.ref(4, r5).setu(r3);
          r10 = r2;
          r1 = CPU.addT(r3, 0x0);
        } else {
          //LAB_8018722
          r1 = MEMORY.ref(4, r5).get();
        }
      }

      //LAB_8018724
      r3 = CPU.addT(r6, r1);
      CPU.cmpT(r3, r10);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = r10;
        r3 = CPU.subT(r3, r0);
        r3 = CPU.subT(r6, r3);
        r6 = CPU.addT(r3, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r6 = CPU.movT(0, 0x0);
        }
      }

      //LAB_8018738
      r3 = r8;
      r2 = MEMORY.ref(4, r3).get();
      r3 = CPU.addT(r7, r2);
      CPU.cmpT(r3, 0x14);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.subT(r3, 0x14);
        r3 = CPU.subT(r7, r3);
        r7 = CPU.addT(r3, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r7 = CPU.movT(0, 0x0);
        }
      }

      //LAB_801874e
      CPU.cmpT(r6, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r6 = CPU.movT(0, 0x0);
      }

      //LAB_8018754
      CPU.cmpT(r7, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r7 = CPU.movT(0, 0x0);
      }

      //LAB_801875a
      r0 = r10;
      r3 = CPU.subT(r0, r1);
      r6 = CPU.cmpT(r6, r3);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r6 = CPU.addT(r3, 0x0);
      }

      //LAB_8018764
      r3 = CPU.movT(0, 0x14);
      r2 = CPU.subT(r3, r2);
      r7 = CPU.cmpT(r7, r2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r7 = CPU.addT(r2, 0x0);
      }

      //LAB_801876e
      r2 = r11;
      MEMORY.ref(4, r2).setu(r6);
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      MEMORY.ref(4, r3).setu(r7);
    }

    //LAB_8018776
    CPU.sp().value += 0x4;
  }

  @Method(0x80187ac)
  public static int FUN_80187ac(int r0, int r1, int r2, int r3, final int a4) {
    final int r5;
    final int r6;
    final int r7;

    final int r8 = r3;
    r3 = MEMORY.ref(4, 0x80187f8).get();
    r6 = CPU.addT(r1, 0x0);
    r1 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r2, 0x0);
    CPU.sp().value -= 0xc;
    r0 = FUN_8018038(r0, r1);
    r2 = CPU.movT(0, 0xeb);
    r3 = CPU.lslT(r0, 1);
    r2 = CPU.lslT(r2, 4);
    r3 = CPU.addT(r3, r2);
    r3 = MEMORY.ref(2, r5 + r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_80187d6
      FUN_801868c(r0, r6, r7, r8, a4, 0, 0);
      r0 = CPU.movT(0, 0x1);
    }

    //LAB_80187ec
    CPU.sp().value += 0xc;
    return r0;
  }

  @Method(0x8018850)
  public static void FUN_8018850(int r0, int r1, int r2, int r3) {
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x20;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    r6 = CPU.addT(r3, 0x0);
    r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r2 = CPU.movT(0, 0x0);
    CPU.r10().value = r2;
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
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.andT(r0, 0x1ff);
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
              r3 = CPU.movT(0, 0xf);
              r5 = CPU.movT(0, 0x0);
              r1 = CPU.movT(0, 0x0);
              CPU.r11().value += r3;
              continue;

            case 0xe:
            case 0x1c:
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, 0x1ff);

            case 8:
            case 0xa:
            case 0xf:
            case 0x11:
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, 0x1ff);
              continue;

            case 9:
              r2 = CPU.movT(0, 0xeb);
              r3 = CPU.lslT(r0, 1);
              r2 = CPU.lslT(r2, 4);
              r3 = CPU.addT(r3, r2);
              r2 = MEMORY.ref(2, r4 + r3).getUnsigned();
              r3 = CPU.addT(0xeac, r4);
              MEMORY.ref(2, r3).setu(r2);
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, 0x1ff);
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
              r3 = CPU.addT(r4, 0xea4);
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
                    MEMORY.ref(2, r6).setu(0);
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

              CPU.r8().value = CPU.pop();
              CPU.r9().value = CPU.pop();
              CPU.r10().value = CPU.pop();
              CPU.r11().value = CPU.pop();
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
      r2 = CPU.subT(r2, 0x20);
      r2 = CPU.lslT(r2, 5);
      r2 = MEMORY.ref(2, 0x8032224 + r2).getUnsigned(); //TODO
      r3 = CPU.addT(r4, 0xeac);
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

  @Method(0x8018a50)
  public static void FUN_8018a50(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8018cac)
  public static int FUN_8018cac(int r0, int r1, int r2, int r3, final int a4) {
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
    r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r3 = CPU.addT(r6, 0x12b0);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r3 = CPU.addT(r6, 0xea8);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    CPU.r11().value = r3;
    r3 = a4;
    CPU.r8().value = r0;
    CPU.cmpT(r3, 0x1);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
      r3 = CPU.movT(0, 0x8);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = boardWramMallocHead_3001e50.offset(37 * 0x4).get();
        CPU.cmpT(r3, CPU.r8().value);
        if(CPU.cpsr().getZero()) { // ==
          r0 = getPointerTableEntry(20);
          r0 = getPointerTableEntry(19);
          CPU.r9().value = 0x3;
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
        r0 = getPointerTableEntry(19);
        CPU.r10().value = r0;
        CPU.r9().value = 0x4;
        CPU.cmpT(r7, 0x20);
        if(CPU.cpsr().getZero()) { // ==
          CPU.sp().value += 0x90;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return 0x4;
        }

        //LAB_8018d18
        r5 = 0x318;
        final int addr = mallocChip(r5);
        DMA.channels[3].SAD.setu(0x80155d0); //TODO function
        DMA.channels[3].DAD.setu(addr);
        DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

        MEMORY.ref(4, CPU.sp().value).setu(CPU.r10().value); //TODO fifth param
        r5 = (int)MEMORY.call(addr, CPU.r8().value, r7, MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get());
        setMallocSlot(addr);

        CPU.sp().value += 0x90;
        CPU.r8().value = CPU.pop();
        CPU.r9().value = CPU.pop();
        CPU.r10().value = CPU.pop();
        CPU.r11().value = CPU.pop();
        return r5;
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
        r3 = CPU.subT(r5, r6);
        r3 = CPU.addT(r3, 0xfffff968);
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.mulT(r1, 0xb6db6db7);
        r3 = CPU.movT(0, 0x1);
        r2 = CPU.movT(0, 0x0);
        MEMORY.ref(1, r5 + 0x5).setu(r3);
        MEMORY.ref(1, r5 + 0x4).setu(r2);
        r3 = a4;
        CPU.r10().value = r1;
        CPU.cmpT(r3, 0x1);
        if(CPU.cpsr().getZero()) { // ==
          r1 = CPU.movT(0, 0x1);
          r3 = CPU.movT(0, 0x2);
          CPU.r9().value = r1;
          MEMORY.ref(1, r5 + 0x5).setu(r3);
        } else {
          //LAB_8018d8e
          r3 = CPU.addT(r6, 0xeac);
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
          r6 = CPU.addT(r6, 0x12b6);
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
          r3 = MEMORY.ref(2, r3 + 0x8).getUnsigned();
          r3 = CPU.addT(r3, 0xfffe);
          r2 = CPU.addT(r2, r3);
          r2 = CPU.lslT(r2, 3);
          r2 = CPU.addT(r2, 0x4);
          r2 = CPU.andT(r2, 0x1ff);
          r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
          r3 = CPU.andT(0xfffffe00, r1);
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
          r4 = r6 + 0x12b8;
          r1 = CPU.r10().value + MEMORY.ref(2, r4).getUnsigned();
          DMA.channels[3].SAD.setu(CPU.sp().value + 0x10);
          DMA.channels[3].DAD.setu(0x6010000 + r1 * 0x20);
          DMA.channels[3].CNT.setu(0x84000020);

          r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r1 = CPU.r11().value;
          r3 = CPU.lsrT(r1, 1);
          r1 = CPU.r8().value;
          r3 = CPU.addT(r2, r3);
          r2 = MEMORY.ref(2, r1 + 0xe).getUnsigned();
          r2 = CPU.lslT(r2, 3);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.addT(r3, 0xfffe);
          MEMORY.ref(2, r5 + 0x14).setu(r3);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r2 = CPU.lsrT(r3, 1);
          r2 = CPU.addT(r1, r2);
          r1 = CPU.r8().value;
          r3 = MEMORY.ref(2, r1 + 0xc).getUnsigned();
          r3 = CPU.lslT(r3, 3);
          r2 = CPU.addT(r2, r3);
          r2 = CPU.addT(r2, 0x2);
          r2 = CPU.orrT(r2, 0x4000);
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
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r8().value);

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
      r3 = CPU.andT(r3, r2);
      r3 = CPU.lslT(r3, 1);
      r7 = MEMORY.ref(2, 0x80366f8 + r3).getUnsigned(); //TODO
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
          r3 = CPU.andT(r3, r2);
          r3 = CPU.lslT(r3, 1);
          r3 = MEMORY.ref(2, 0x80366f8 + r3).getUnsigned(); //TODO
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
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.lslT(r0, 2);
              r3 = CPU.addT(r3, 0x20);
              r7 = MEMORY.ref(2, 0x80366f8 + r3).getUnsigned(); //TODO
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
                MEMORY.ref(2, r6 + 0xc).setu(r3);
                r3 = CPU.lslT(r1, 2);
                r3 = CPU.addT(r3, 0x20);
                r3 = MEMORY.ref(2, 0x80366f8 + r3).getUnsigned(); //TODO
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
      r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
      r2 = CPU.andT(0x1ff, r3);
      r3 = CPU.andT(~0x1ff, r1);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(2, r5 + 0x6).setu(r3);
      r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
    } else {
      //LAB_8019124
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      r1 = CPU.addT(r7, 0x0);
      r3 = CPU.andT(r3, ~0xffff);
      r3 = CPU.orrT(r3, r1);
      r3 = CPU.andT(r3, 0xffff);
      r1 = CPU.lslT(r1, 16);
      r3 = CPU.orrT(r3, r1);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = CPU.sp().value;
      r3 = MEMORY.ref(4, r0 + 0x4).get();
      r3 = CPU.andT(r3, ~0xffff);
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
        r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r2 = CPU.addT(r2, 0xfff8);
        r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        r2 = CPU.andT(r2, 0x1ff);
        r3 = CPU.andT(~0x1ff, r1);
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
        r3 = CPU.andT(~0x1ff, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r5 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      }
    }

    //LAB_80191b4
    MEMORY.ref(1, r5 + 0x4).setu(r3);
    CPU.sp().value += 0x8;

    CPU.r8().value = CPU.pop();
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

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
        r2 = CPU.r10().value;
        r3 = _3001800.get();
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
              r1 = CPU.r9().value + 0x12b6;
              r3 = MEMORY.ref(2, r1).getUnsigned();
              CPU.cmpT(r3, 0x60);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_8019288
                r2 = CPU.lslT(r0, 7);
                r2 = CPU.addT(r2, 0x80368d4); //TODO
                r0 = MEMORY.ref(2, r1).getUnsigned();
                r1 = CPU.movT(0, 0x80);
                r0 = FUN_8003fa4(r0, r1, r2);
                r2 = MEMORY.ref(2, r7 + 0x8).getUnsigned();
                r0 = CPU.andT(r0, 0x3ff);
                r3 = CPU.andT(~0x3ff, r2);
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
                r0 = _3001800.get();
                r1 = CPU.movT(0, 0x50);
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(0x8033e60); //TODO
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
              r3 = _3001800.get();
              r2 = CPU.movT(0, 0x1);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_801931e
                r0 = rand();
                r5 = CPU.addT(r0, 0x0);
                r0 = rand();
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
                r1 = CPU.subT(r1, 0x1);
                r1 = CPU.andT(r1, 0x1ff);
                r2 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r3 = CPU.andT(~0x1ff, r2);
                r3 = CPU.orrT(r3, r1);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r0 = rand();
                r5 = CPU.addT(r0, 0x0);
                r0 = rand();
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
                r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(0x1ff, r3);
                r3 = CPU.andT(~0x1ff, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
                MEMORY.ref(1, r7 + 0x4).setu(r3);
              } else {
                //LAB_8019388
                r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                r2 = CPU.movT(0, 0x80);
                r3 = CPU.andT(r3, ~0xffff);
                r2 = CPU.lslT(r2, 2);
                r3 = CPU.orrT(r3, r2);
                r2 = CPU.movT(0, 0x80);
                r2 = CPU.lslT(r2, 18);
                r3 = CPU.andT(r3, 0xffff);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
                r0 = CPU.sp().value + 0x10;
                r3 = MEMORY.ref(4, r0 + 0x4).get();
                r3 = CPU.andT(r3, ~0xffff);
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
                r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r2 = CPU.addT(r2, 0xfffb);
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, 0x1ff);
                r3 = CPU.andT(~0x1ff, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r3 = CPU.addT(r3, 0xfb);
                MEMORY.ref(1, r7 + 0x4).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, 0xffff);
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
              r2 = CPU.subT(r2, 0x2);
              r2 = CPU.andT(r2, 0x1ff);
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r3 = CPU.andT(~0x1ff, r1);
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
              r3 = _3001800.get();
              r2 = CPU.movT(0, 0x1);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, 0x1);
                MEMORY.ref(2, r6 + 0xc).setu(r3);
              }

              //LAB_801948e
              r0 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r1 = CPU.movT(0, 0x14);
              MEMORY.ref(4, CPU.sp().value).setu(0x8033eb0); //TODO
              r0 = FUN_8002304(r0, r1);
              r4 = MEMORY.ref(4, CPU.sp().value).get();
              r0 = CPU.lslT(r0, 16);
              r0 = CPU.lsrT(r0, 15);
              r3 = MEMORY.ref(1, r4 + r0).get();
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r2 = CPU.addT(r2, r3);
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r2 = CPU.andT(r2, 0x1ff);
              r3 = CPU.andT(~0x1ff, r1);
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
              r3 = CPU.addT(r3, 0x1);
              r2 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r2);
              r1 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, 0x8033ee8 + r3).getUnsigned(); //TODO
              r1 = CPU.subT(r1, r3);
              MEMORY.ref(1, r7 + 0x4).setu(r1);
              break;

            case 0xe:
            case 0xf:
            case 0x10:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r3 = CPU.addT(r3, 0x1);
              r2 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r2);
              r1 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, 0x8033ee8 + r3).getUnsigned(); //TODO
              r1 = CPU.addT(r1, r3);
              MEMORY.ref(1, r7 + 0x4).setu(r1);
              break;

            case 0x12:
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r3 = CPU.addT(r3, 0x1);
              r0 = CPU.movT(0, 0xf);
              MEMORY.ref(2, r6 + 0xc).setu(r3);
              r3 = CPU.andT(r3, r0);
              r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
              r3 = MEMORY.ref(1, 0x8033ee8 + r3).get(); //TODO
              r2 = CPU.subT(r2, r3);
              r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
              r2 = CPU.andT(r2, 0x1ff);
              r3 = CPU.andT(~0x1ff, r1);
              r3 = CPU.orrT(r3, r2);
              MEMORY.ref(2, r7 + 0x6).setu(r3);
              r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
              r0 = CPU.andT(r0, r3);
              r2 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
              r3 = MEMORY.ref(1, 0x8033ee8 + r0).getUnsigned(); //TODO
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
                r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r2 = CPU.addT(r2, 0xfff8);
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(r2, 0x1ff);
                r3 = CPU.andT(~0x1ff, r1);
                r3 = CPU.orrT(r3, r2);
                MEMORY.ref(2, r7 + 0x6).setu(r3);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r3 = CPU.addT(r3, 0xf8);
                MEMORY.ref(1, r7 + 0x4).setu(r3);
                r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
                r3 = CPU.addT(r3, 0xffff);
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
                r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r1 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
                r2 = CPU.andT(0x1ff, r3);
                r3 = CPU.andT(~0x1ff, r1);
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
            r3 = CPU.r9().value + 0x12b6;
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
          r3 = _3001800.get();
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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x801964c)
  public static void FUN_801964c(final int r0, final int r1) {
    FUN_80196c4(r0, r1, 0x7fffffff);
  }

  @Method(0x80196c4)
  public static void FUN_80196c4(int r0, final int r1, final int r2) {
    int r3;
    final int r5;
    int r6;
    int r7;

    r7 = r2;
    r3 = boardWramMallocHead_3001e50.offset(50 * 0x4).get();
    CPU.sp().value -= 0xc;
    r6 = r1;

    if(r3 == 0) {
      final int size = 0x140;
      final int addr = mallocSlotChip(50, size);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

      MEMORY.setFunction(addr, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r3 = addr;
    }

    //LAB_8019706
    r5 = CPU.sp().value;
    FUN_8019bac(r5, r0);

    //LAB_8019770
    r0 = (int)MEMORY.call(r3, r5);

    //LAB_8019718
    while(r0 != 0) {
      if(r0 == 0xe) {
        //LAB_8019730
        r7 -= 0x3;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
        //LAB_801972a
      } else if(r0 >= 0x8 && r0 <= 0xc || r0 == 0xf) {
        //LAB_8019750
        r7--;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
      } else {
        //LAB_8019766
        r7--;
        if(r7 <= 0) {
          break;
        }
      }

      //LAB_801976c
      MEMORY.ref(2, r6).setu(r0);
      r6 += 0x2;

      r0 = (int)MEMORY.call(r3, r5);
    }

    //LAB_801977a
    if(r3 == 0) {
      freeSlot(50);
    }

    //LAB_8019786
    CPU.sp().value += 0xc;
    MEMORY.ref(2, r6).setu(0);
  }

  @Method(0x8019854)
  public static void FUN_8019854(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

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
      r3 = CPU.addT(r3, 0xffff);
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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80198dc)
  public static void FUN_80198dc() {
    final int r0;
    int r1;
    int r2;
    int r3;
    int r4;

    r3 = MEMORY.ref(4, 0x8019900).get();
    r4 = MEMORY.ref(4, 0x8019904).get();
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.addT(r3, r4);
    r4 = CPU.subT(r4, 0x20);
    r1 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r3, r4);

    //LAB_80198ee
    do {
      r1 = CPU.addT(r1, 0x1);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(2, r2).setu(r0);
      r2 = CPU.addT(r2, 0x2);
      CPU.cmpT(r1, 0x8);
    } while(!CPU.cpsr().getZero()); // !=
  }

  @Method(0x8019944)
  public static int FUN_8019944(int r0, int r1) {
    final int r2;
    int r3;
    int r4;
    final int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8019990).get();
    r4 = MEMORY.ref(4, 0x8019994).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(2, r4 + r2).getUnsigned();
    r5 = CPU.addT(r0, 0x0);
    r7 = CPU.addT(r1, 0x0);
    r1 = CPU.movT(0, 0x0);
    r6 = CPU.movT(0, 0x0);
    CPU.r12().value = r1;
    r0 = MEMORY.ref(4, 0x8019998).get();
    r3 = CPU.cmpT(r3, r5);
    if(CPU.cpsr().getZero()) { // ==
      r6 = MEMORY.ref(4, r0 + r2).get();
      CPU.cmpT(r7, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, r0 + r2).setu(r1);
        MEMORY.ref(2, r4 + r2).setu(r1);
      }
    } else {
      //LAB_801996a
      do {
        r1 = CPU.addT(r1, 0x1);
        r0 = CPU.addT(r0, 0x4);
        r4 = CPU.addT(r4, 0x2);
        CPU.cmpT(r1, 0x7);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          return r6;
        }
        r3 = MEMORY.ref(2, r4 + r2).getUnsigned();
        r3 = CPU.cmpT(r3, r5);
      } while(!CPU.cpsr().getZero()); // !=

      r6 = MEMORY.ref(4, r0 + r2).get();
      CPU.cmpT(r7, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.r12().value;
        MEMORY.ref(4, r0 + r2).setu(r3);
        r3 = CPU.r12().value;
        MEMORY.ref(2, r4 + r2).setu(r3);
      }
    }

    //LAB_8019988
    return r6;
  }

  @Method(0x801999c)
  public static int FUN_801999c(int r0) {
    int r3;
    int r5;
    final int r6;
    int r2;

    r3 = MEMORY.ref(4, 0x80199dc).get();
    r2 = MEMORY.ref(4, 0x80199e0).get();
    r3 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r3, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r6 = CPU.addT(r0, 0x0);
    r5 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = FUN_80f9048();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.movT(0, 0x1);
      }
    }

    //LAB_80199ba
    r3 = MEMORY.ref(4, 0x80199e4).get();
    r2 = MEMORY.ref(4, 0x80199e8).get();
    r3 = MEMORY.ref(4, r3).get();
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r5 = CPU.movT(0, 0x1);
    }

    //LAB_80199c8
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r6 + 0x14).setu(r3);
      r0 = CPU.movT(0, 0x1);
    } else {
      //LAB_80199d4
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80199d6
    return r0;
  }

  @Method(0x80199ec)
  public static int FUN_80199ec(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8019a3c).get();
    r1 = MEMORY.ref(4, 0x8019a40).get();
    r5 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r5, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = FUN_80f9048();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r6 = CPU.movT(0, 0x1);
      }
    }

    //LAB_8019a0a
    r3 = MEMORY.ref(4, 0x8019a44).get();
    r1 = MEMORY.ref(4, 0x8019a48).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r5, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8019a4c).get();
      r2 = MEMORY.ref(4, r3).get();
    }

    //LAB_8019a1c
    r3 = MEMORY.ref(4, 0x8019a50).get();
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = CPU.movT(0, 0x1);
    }

    //LAB_8019a26
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r7 + 0x14).setu(r3);
      r0 = CPU.movT(0, 0x1);
    } else {
      //LAB_8019a32
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8019a34
    return r0;
  }

  @Method(0x8019a54)
  public static void FUN_8019a54() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r3 = MEMORY.ref(4, 0x8019a9c).get();
    r2 = CPU.movT(0, 0xc4);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 3);
    r5 = CPU.addT(r3, r2);
    r6 = CPU.movT(0, 0x0);

    //LAB_8019a62
    do {
      r0 = MEMORY.ref(4, r5).get();
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r0 + 0x18).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
          r3 = CPU.addT(r2, 0x0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(2, r0 + 0x14).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = CPU.movT(0, 0x2);
              r1 = CPU.andT(r1, r2);
              r1 = CPU.lslT(r1, 16);
              r1 = CPU.lsrT(r1, 16);
              FUN_8016418(r0, r1);
            }
          }
        }
      }

      //LAB_8019a88
      r6 = CPU.addT(r6, 0x1);
      r5 = CPU.addT(r5, 0x28);
      CPU.cmpT(r6, 0x3);
    } while(!CPU.cpsr().getZero()); // !=

    r0 = CPU.movT(0, 0xa);
    FUN_80030f8(r0);
  }

  @Method(0x8019aa0)
  public static void FUN_8019aa0(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;
    final int r6;
    int r7;
    final int r8;
    final int r9;
    final int r10;

    r3 = MEMORY.ref(4, 0x8019b94).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x18;
    r8 = r3;
    r6 = CPU.addT(r1, 0x0);
    r3 = CPU.movT(0, 0x8);
    r1 = CPU.movT(0, 0x1);
    r9 = r2;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    r7 = CPU.addT(r0, 0x0);
    r0 = FUN_8018038(r0, r1);
    r2 = CPU.movT(0, 0xeb);
    r2 = CPU.lslT(r2, 4);
    r3 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r2);
    r2 = r8;
    r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
    r5 = CPU.movT(0, 0x0);
    r10 = r0;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_80187ac(r7, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8);
      r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r3 = CPU.movT(0, 0x1e);
      r3 = CPU.subT(r3, r2);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r0 = CPU.asrT(r3, 1);
      r3 = CPU.movT(0, 0xf);
      r3 = CPU.subT(r3, r4);
      r3 = CPU.asrT(r3, 1);
      r7 = r9;
      r1 = CPU.addT(r3, r7);
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
      CPU.cmpT(r6, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = FUN_80162d4(r0, r1, r2, r4, r5);
        r5 = CPU.addT(r0, 0x0);
      } else {
        //LAB_8019b10
        r0 = FUN_80162d4(r0, r1, 0, 0, 0x2);
        r5 = CPU.addT(r0, 0x0);
        MEMORY.ref(2, r5 + 0x8).setu(r6);
        MEMORY.ref(2, r5 + 0xa).setu(r6);
      }

      //LAB_8019b22
      r0 = CPU.addT(r5, 0x0);
      r1 = r10;
      r0 = FUN_80165d8(r0, r1, 0, 0, 0, 0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_8019b46
        r0 = FUN_8017364();
        CPU.cmpT(r0, 0x0);

        //LAB_8019b40
        while(CPU.cpsr().getZero()) { // ==
          r0 = CPU.movT(0, 0x1);
          FUN_80030f8(r0);
          r0 = FUN_8017364();
          CPU.cmpT(r0, 0x0);
        }

        CPU.cmpT(r6, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.movT(0, 0x0);
          FUN_8016418(r0, r1);
          r0 = CPU.addT(r5, 0x0);
          r0 = FUN_8017394(r0);
          CPU.cmpT(r0, 0x0);

          //LAB_8019b5c
          while(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x1);
            FUN_80030f8(r0);

            //LAB_8019b62
            r0 = CPU.addT(r5, 0x0);
            r0 = FUN_8017394(r0);
            CPU.cmpT(r0, 0x0);
          }
        } else {
          //LAB_8019b6e
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.movT(0, 0x1);
          FUN_8016418(r0, r1);
        }

        //LAB_8019b76
        r3 = MEMORY.ref(4, 0x8019b98).get();
        r2 = CPU.movT(0, 0x0);
        r3 += r8;
        MEMORY.ref(2, r3).setu(r2);
        r3 = MEMORY.ref(4, 0x8019b9c).get();
        r3 += r8;
        MEMORY.ref(2, r3).setu(r2);
      } else {
        r0 = CPU.addT(r5, 0x0);
        r1 = CPU.movT(0, 0x1);
        FUN_8016418(r0, r1);
      }
    }

    //LAB_8019b84
    CPU.sp().value += 0x18;
  }

  @Method(0x8019bac)
  public static void FUN_8019bac(final int r0, final int r1) {
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    CPU.r10().value = r1;
    final int size = 0x60;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8015570);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8015570.class, "FUN_8015570", int.class, int.class);
    MEMORY.call(addr, CPU.r8().value, CPU.r10().value);
    setMallocSlot(addr);

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8019d0c)
  public static void FUN_8019d0c() {
    final int r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    MEMORY.ref(2, r3 + 0x12ec).setu(999);
    MEMORY.ref(2, r3 + 0x12ee).setu(999);
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
      r4 = 0x80367e4; //TODO
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
      r4 = 0x803680c; //TODO
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
  public static int FUN_8019da8(final int r0, final int r1, final int r2, final int r3) {
    if(FUN_8019d2c(r0) == -1) {
      return 0;
    }

    //LAB_8019dd4
    final int r5;
    final int r8;
    if(boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).offset(1, 0xea4).getUnsigned() != 0) {
      r5 = FUN_80162d4(r2, r3, 0x6, 0x5, 0x2);
      r8 = 0;
    } else {
      //LAB_8019dfe
      r5 = FUN_80162d4(r2, r3, 0x5, 0x5, 0x2);
      r8 = -4;
    }

    //LAB_8019e10
    if(r5 != 0) {
      FUN_801ec6c(r0, r1, -1, r5, r8, -4);
    }

    //LAB_8019e2a
    //LAB_8019e2c
    return r5;
  }

  @Method(0x8019e48)
  public static void FUN_8019e48(int r0) {
    final int r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    int r5 = r6 + 0x500;
    final int r3;

    r0 = FUN_8019d2c(r0);
    if(r0 != -1) {
      if(MEMORY.ref(2, r6 + 0x12ee).getUnsigned() == r0) {
        r3 = 1;
        //LAB_8019e78
      } else if(MEMORY.ref(2, r6 + 0x12ec).getUnsigned() == r0) {
        r3 = 0;
      } else {
        return;
      }

      //LAB_8019e84
      r0 = MEMORY.ref(2, r6 + 0x12f0 + r3 * 0x2).getUnsigned();

      //LAB_8019e8e
      for(int r1 = 0; r1 < 8; r1++) {
        final int r2 = MEMORY.ref(4, r5).get();

        // Retail bug: null check added to fix null pointer dereference
        if(r2 != 0 && MEMORY.ref(1, r2 + 0x4).getUnsigned() == 2 && MEMORY.ref(1, r2 + 0xe).getUnsigned() == r0) {
          //LAB_8019e6e
          FUN_8016418(r5, 0x2);
          break;
        }

        //LAB_8019e9c
        r5 += 0x24;
      }
    }

    //LAB_8019ea4
  }

  @Method(0x801a4fc)
  public static void FUN_801a4fc(int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    if(r0 < 0 || r0 > 0x7f) {
      r0 -= 0x70;
    }

    final int r6 = mallocSlotChip(17, 0x608);
    final int ptr = getPointerTableEntry(240);

    //LAB_801a522
    final int r5_0 = ptr + MEMORY.ref(2, ptr + r0 * 0x2).getUnsigned();
    MEMORY.ref(4, 0x604 + r6).setu(r5_0 + 0x20);
    MEMORY.ref(2, 0x600 + r6).setu(0x4);
    MEMORY.ref(2, 0x602 + r6).setu(0x4);
    FUN_801a5a4(r6, 0);
    if(a5 == 0) {
      MEMORY.ref(4, r2).setu(FUN_8004080());
    }

    //LAB_801a556
    MEMORY.ref(4, r3).setu(FUN_8003fa4(MEMORY.ref(4, r2).get(), 0x200, r6 + 0x400));
    freeSlot(17);
    DMA.channels[3].SAD.setu(r5_0);
    DMA.channels[3].DAD.setu(0x5000200 + a4 * 0x20);
    DMA.channels[3].CNT.setu(0x80000010);
  }

  @Method(0x801a5a4)
  public static void FUN_801a5a4(final int r0, final int r1) {
    final int size1 = 0x278;
    DMA.channels[3].SAD.setu(0x8015afc);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size1));
    DMA.channels[3].CNT.setu(0x84000000 | size1 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment8015afc.class, "FUN_8015afc", int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), MEMORY.ref(4, r0 + 0x604).get(), r0);
    freeSlot(49);

    final int addr;
    final int size2;
    if(r1 != 0) {
      addr = 0x8015d74;
      size2 = 0x9c;
    } else {
      //LAB_801a5fe
      addr = 0x8015e10;
      size2 = 0x7c;
    }

    //LAB_801a612
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size2));
    DMA.channels[3].CNT.setu(0x84000000 | size2 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment_8015d74_8015e10.class, "FUN_%x".formatted(addr), int.class, int.class, int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), r0, r0 + 0x400, MEMORY.ref(2, r0 + 0x600).getUnsigned(), MEMORY.ref(2, r0 + 0x602).getUnsigned());
    freeSlot(0x31);
  }

  @Method(0x801c428)
  public static void FUN_801c428() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x801c450).get();
    r2 = CPU.movT(0, 0x8c);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r0 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(2, r0 + 0x16).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.movT(0, 0x2);
        FUN_8016418(r0, r1);
        r0 = MEMORY.ref(4, 0x801c454).get();
        FUN_8004278(r0);
      }
    }

    //LAB_801c44c
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

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

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

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
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
    r7 = CPU.addT(r2, 0x0);
    r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r1 = CPU.lslT(r1, 5);
    r3 = CPU.addT(r5, 0xea2);
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
          CPU.r9().value = 0x3ff;
          CPU.r10().value = 0x1ff;
          CPU.lr().value = 0x27f;
          CPU.r12().value = 0xff;

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
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
              r3 = CPU.addT(r1, 0xffff0ff7);

              switch(r3) {
                case 1 ->
                  //LAB_801e560
                  r1 = 0xf00d;

                case 5 ->
                  //LAB_801e4d4
                  r1 = 0xf009;

                case 6, 7, 9, 10, 11, 12, 13, 14 ->
                  //LAB_801e564
                  r1 = 0xf00f;

                case 8 ->
                  //LAB_801e4d0
                  r1 = 0xf018;
              }
            } else {
              //LAB_801e4d8
              r4 = CPU.cmpT(r4, r6);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.addT(r1, 0xffff0ff7);

                switch(r3) {
                  case 0 ->
                    //LAB_801e560
                    r1 = 0xf00d;

                  case 5 ->
                    //LAB_801e534
                    r1 = 0xf00a;

                  case 6, 7, 8, 9, 10, 12, 13, 14, 15 ->
                    //LAB_801e564
                    r1 = 0xf00f;

                  case 11 ->
                    //LAB_801e530
                    r1 = 0xf019;
                }
              } else {
                //LAB_801e538
                r3 = CPU.addT(r1, 0xffff0ff7);

                switch(r3) {
                  case 0, 1, 5 ->
                    //LAB_801e560
                    r1 = 0xf00d;
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
                r3 = CPU.addT(r1, 0xffff0ff7);

                switch(r3) {
                  case 3 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5, 7, 8, 9, 10, 11, 12, 14, 15, 16 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;

                  case 6 ->
                    //LAB_801e618
                    r1 = 0xf00b;

                  case 13 ->
                    //LAB_801e614
                    r1 = 0xf01a;
                }
              } else {
                //LAB_801e61c
                CPU.cmpT(r4, CPU.r10().value);
                if(CPU.cpsr().getZero()) { // ==
                  r3 = CPU.addT(r1, 0xffff0ff7);

                  switch(r3) {
                    case 2 ->
                      //LAB_801e6b0
                      r1 = 0xf00d;

                    case 5, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17 ->
                      //LAB_801e6b4
                      r1 = 0xf00e;

                    case 6 ->
                      //LAB_801e680
                      r1 = 0xf00c;

                    case 14 ->
                      //LAB_801e67c
                      r1 = 0xf01b;
                  }
                } else {
                  //LAB_801e684
                  r3 = CPU.addT(r1, 0xffff0ff7);

                  switch(r3) {
                    case 2, 3, 6 ->
                      //LAB_801e6b0
                      r1 = 0xf00d;

                    case 5 ->
                      //LAB_801e6b4
                      r1 = 0xf00e;
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
    CPU.r8().value = r2;
    CPU.r10().value = r3;
    r7 = CPU.addT(r1, 0x0);
    r0 = mallocBoard(0x200);
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
    r0 = CPU.addT(r6, 0x0);
    MEMORY.ref(2, r2).setu(0);
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.r8().value;
    r3 = CPU.r10().value;
    FUN_8017aa4(r0, r1, r2, r3);
    r0 = CPU.addT(r6, 0x0);
    setMallocSlot(r0);

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
      r1 = CPU.addT(r1, 0x8);
      r1 = CPU.andT(r1, 0x1ff);
      r2 = CPU.addT(r2, 0x8);
      r3 = CPU.movT(0, 0xff);
      r2 = CPU.andT(r2, r3);
      r3 = CPU.lslT(r1, 16);
      r3 = CPU.orrT(r3, r2);
      r0 = CPU.r10().value;
      r3 = CPU.orrT(r3, r0);
      MEMORY.ref(4, r5 + 0x14).setu(r3);
      r3 = _3001b10.get(r7)._02.get();
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
  public static void FUN_801ec6c(int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    CPU.sp().value -= 0x10;

    final int r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    if(FUN_80770c0(0x20) != 0) {
      if(r0 == 0) {
        r0 = 0x12;
      }

      //LAB_801ec94
      if(r0 == 1) {
        r0 = 0x13;
      }
    }

    //LAB_801ec9a
    final int r5 = FUN_8019d2c(r0);
    if(r5 == -1) {
      CPU.sp().value += 0x10;
      return;
    }

    int r6 = r2;
    if(r6 < 0 || r6 > 1) {
      if(MEMORY.ref(2, r7 + 0x12ee).getUnsigned() == 999) {
        r6 = 1;
      } else if(MEMORY.ref(2, r7 + 0x12ec).getUnsigned() == 999) {
        r6 = 0;
      } else {
        CPU.sp().value += 0x10;
        return;
      }
    }

    //LAB_801ecca
    final int r8 = 0xe + r6;
    FUN_801a4fc(r5, r1, CPU.sp().value + 0xc, CPU.sp().value + 0x8, r8, 0);

    final int r0_0 = FUN_801eadc(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x80000000, r3, a4, a5);
    if(r0_0 != 0) {
      MEMORY.ref(1, r0_0 + 0x19).and(0xf).oru(r8 << 4);
      MEMORY.ref(1, r0_0 + 0x4).setu(0x2);
    }

    //LAB_801ed0c
    MEMORY.ref(2, r7 + 0x12ec + r6 * 0x2).setu(r5);
    MEMORY.ref(2, r7 + 0x12f0 + r6 * 0x2).setu(MEMORY.ref(4, CPU.sp().value + 0xc).get());

    //LAB_801ed1c
    CPU.sp().value += 0x10;
  }

  @Method(0x801f77c)
  public static int FUN_801f77c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;

    r0 = FUN_80056cc();
    r6 = CPU.movT(0, 0x9);
    r5 = CPU.movT(0, 0x0);
    r6 = CPU.negT(r6, r6);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_8005c68();
      r1 = boardWramMallocHead_3001e50.offset(51 * 0x4).get();
      MEMORY.ref(2, 0x2002010).setu(r5);
      MEMORY.ref(2, 0x200200c).setu(r5);
      r6 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, 0x1070);
      r0 = CPU.movT(0, 0x2);

      //LAB_801f7a8
      do {
        r3 = CPU.movT(0, 0x1);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, 0x2002010).setu(0x1);
          r5 = CPU.addT(r5, 0x1);
        }

        //LAB_801f7b4
        r3 = CPU.movT(0, 0x2);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, 0x200200c).setu(0x1);
        }

        //LAB_801f7be
        r0 = CPU.subT(r0, 0x1);
        r1 = CPU.addT(r1, 0x40);
        CPU.cmpT(r0, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      if((heldButtonsLastFrame_3001ae8.get() & 0x120) != 0x120) { // Left/R
        MEMORY.ref(2, 0x2002010).setu(0);
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
