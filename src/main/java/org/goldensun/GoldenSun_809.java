package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.FUN_80022ec;
import static org.goldensun.GoldenSun.FUN_80022fc;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003b70;
import static org.goldensun.GoldenSun.FUN_8003bb4;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.FUN_80041d8;
import static org.goldensun.GoldenSun.FUN_800447c;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_8009080;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.FUN_80090e0;
import static org.goldensun.GoldenSun.FUN_8009128;
import static org.goldensun.GoldenSun.FUN_8009140;
import static org.goldensun.GoldenSun.FUN_8009148;
import static org.goldensun.GoldenSun.FUN_8009150;
import static org.goldensun.GoldenSun.FUN_8009158;
import static org.goldensun.GoldenSun.FUN_80091a8;
import static org.goldensun.GoldenSun.FUN_8009240;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.FUN_8009098;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars._3001f54;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015040;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_8015050;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015100;
import static org.goldensun.GoldenSun_801.FUN_8015108;
import static org.goldensun.GoldenSun_801.FUN_8015110;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80151e0;
import static org.goldensun.GoldenSun_801.FUN_8015208;
import static org.goldensun.GoldenSun_807.FUN_8077080;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770c8;
import static org.goldensun.GoldenSun_807.FUN_80770d0;
import static org.goldensun.GoldenSun_808.FUN_808ba1c;
import static org.goldensun.GoldenSun_808.FUN_808d394;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_808.FUN_808fecc;
import static org.goldensun.GoldenSun_808.FUN_808fefc;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.GoldenSun_818.FUN_8185000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_809 {
  private GoldenSun_809() { }

  @Method(0x80901c0)
  public static void FUN_80901c0(final int r0, final int r1) {

    final int r2 = (r0 >> 8) & 0xff;
    final int r6 = r0 & 0xff;

    switch(r2) {
      case 0 -> {
        FUN_8003bb4(0);
        FUN_8003b70(r1);
      }

      case 1 -> {
        FUN_8091200(0x8000, 0);
        FUN_8091254(r1);
      }

      case 2 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        MEMORY.ref(2, r5 + 0x534).setu(0x3f);
        MEMORY.ref(2, r5 + 0x536).setu(0x1);
        FUN_80041d8(getRunnable(GoldenSun_808.class, "FUN_808f52c"), 0xc80);
        FUN_80041d8(getRunnable(GoldenSun_808.class, "FUN_808f498"), 0x480);
        FUN_80030f8(0x1);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53B).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 3 -> {
        final int r5 = FUN_808fecc();
        MEMORY.ref(2, r5 + 0x528).setu(r6);
        MEMORY.ref(2, r5 + 0x52a).setu(0x20);
        FUN_80907b0(0);
        FUN_80030f8(1);
        FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_8090658"), 0xc80);
        MEMORY.ref(1, r5 + 0x53a).setu(0x20);
        MEMORY.ref(1, r5 + 0x53b).setu(0x40);
        MEMORY.ref(1, r5 + 0x53c).setu(r1);
        MEMORY.ref(1, r5 + 0x53d).setu(0);
      }

      case 4 -> {
        final int r5 = FUN_808fecc();
        if(r6 == 0) {
          FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_80903bc"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(r6);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(r6);
        } else {
          //LAB_8090322
          FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_8090488"), 0xc80);
          setInterruptHandler(1, 0, getRunnable(GoldenSun_809.class, "FUN_8090584"));
          MEMORY.ref(1, r5 + 0x53a).setu(0);
          MEMORY.ref(1, r5 + 0x53b).setu(0x50);
          MEMORY.ref(1, r5 + 0x53c).setu(r1);
          MEMORY.ref(1, r5 + 0x53d).setu(0);
        }
      }
    }

    //LAB_8090352
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

    r1 = CPU.movT(0, 0xc4);
    r6 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
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
    r2 = 0x2a01;
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
      r4 = 0x53f;
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
      r2 = CPU.lslT(r2, 4);
      MEMORY.call(0x3001388, r0, r1, r2);
      r3 = 0x2a01;
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
    r7 = 0x3e0;
    r5 = 0x1f;
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
    r6 = CPU.addT(r0, r1);
    r3 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    r2 = MEMORY.ref(2, 0x2002090).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = 0x2002090 + r2 * 0xc + 0x4;
      r2++;
      MEMORY.ref(2, 0x2002090).setu(r2);
      MEMORY.ref(4, r3).setu(r6);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x5000000);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x84000070);
    }

    //LAB_8090a16
    INTERRUPTS.INT_MASTER_ENABLE.setu(r1);
    r3 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    r6 = CPU.addT(r3, 0x0);
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    r2 = MEMORY.ref(2, 0x2002090).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r1 = CPU.movT(0, 0x93);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, 0x2002090);
      r1 = CPU.lslT(r1, 6);
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(2, 0x2002090).setu(r2);
      r2 = CPU.addT(r0, r1);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x5000200);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x84000070);
    }

    //LAB_8090a42
    INTERRUPTS.INT_MASTER_ENABLE.setu(r6);

    //LAB_8090a44
  }

  @Method(0x809088c)
  public static void FUN_809088c(int r0, int r1, int r2, int r3) {
    int r5;
    int r6;
    int r7;

    CPU.sp().value -= 0x4;
    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r1, 0x0);
    r5 = CPU.addT(r2, 0x0);
    final int r8 = r3;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r2 = 0x53f;

      //LAB_80908a8
      do {
        r1 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r7 + r1).get();
        r1 = CPU.movT(0, 0x0);
        r0 = MEMORY.ref(2, r6 + r1).get();
        MEMORY.ref(4, CPU.sp().value).setu(r2);
        r0 = CPU.subT(r0, r3);
        r1 = r8;
        r0 = (int)MEMORY.call(0x3000380, r0, r1);
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        r2 = CPU.subT(r2, 0x1);
        MEMORY.ref(2, r5).setu(r0);
        r7 = CPU.addT(r7, 0x2);
        r6 = CPU.addT(r6, 0x2);
        r5 = CPU.addT(r5, 0x2);
        CPU.cmpT(r2, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
    }

    //LAB_80908ca
    CPU.sp().value += 0x4;
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
      r2 = 0x7c00;
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.andT(r3, r2);
      r2 = CPU.r8().value;
      MEMORY.ref(2, r2).setu(r3);
      r3 = CPU.movT(0, 0x2);
      r2 = 0x3e0;
      CPU.r8().value += r3;
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.andT(r3, r2);
      r1 = CPU.r8().value;
      r3 = CPU.lslT(r3, 5);
      MEMORY.ref(2, r1).setu(r3);
      r3 = 0x1f;
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
      r0 = CPU.subT(r0, 0x6);
      r1 = CPU.r8().value;
      r2 = CPU.orrT(r2, r4);
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(r2);
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
                r0 = CPU.lslT(r0, 4);
                r0 = (int)MEMORY.call(0x3000380, r0, r1);
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
                r5 = CPU.addT(r0, 0x0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r3 = CPU.movT(0, 0x2);
                CPU.r8().value += r3;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
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
                r5 = 0x7c00;
                r0 = 0x3e0;
                r2 = 0x1f;
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
              r1 = CPU.r8().value;
              r2 = CPU.orrT(r2, r4);
              DMA.channels[3].SAD.setu(r0);
              DMA.channels[3].DAD.setu(r1);
              DMA.channels[3].CNT.setu(r2);
            }
          }
        }
      } else {
        //LAB_8090b08
        r1 = 0xfffeffff;
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
                r0 = (int)MEMORY.call(0x3000380, r0, r1);
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
              r2 = 0x809e96e;
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
                r1 = CPU.movT(0, 0xa);
                r0 = (int)MEMORY.call(0x3000380, r0, r1);
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
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, 0x809e9ae + r3).getUnsigned();
                r1 = CPU.r8().value;
                r2 = CPU.movT(0, 0x2);
                MEMORY.ref(2, r1).setu(r3);
                CPU.r8().value += r2;
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, 0x809e96e + r3).getUnsigned();
                r1 = CPU.r8().value;
                r2 = CPU.movT(0, 0x2);
                MEMORY.ref(2, r1).setu(r3);
                CPU.r8().value += r2;
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
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
              CPU.r11().value = 0x809e92e;

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
              CPU.r11().value = 0x809e9ae;

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
                r5 = CPU.subT(r5, r0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1 + 0x2).setu(r3);
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, 0x809e96e + r3).getUnsigned();
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
                r5 = CPU.addT(r0, 0x0);
                r3 = CPU.lslT(r5, 1);
                r3 = MEMORY.ref(2, 0x809e9ae + r3).getUnsigned();
                r1 = CPU.r8().value;
                MEMORY.ref(2, r1).setu(r3);
                r3 = CPU.lslT(r7, 1);
                r3 = MEMORY.ref(2, 0x809e96e + r3).getUnsigned();
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2 + 0x2).setu(r3);
                r3 = CPU.lslT(r6, 1);
                r3 = MEMORY.ref(2, 0x809e92e + r3).getUnsigned();
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
              r5 = 0x7c00;
              r0 = 0x3e0;
              r2 = 0x1f;
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
    FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_80908e0"), 0xc8f);
  }

  @Method(0x8091200)
  public static void FUN_8091200(final int r0, int r1) {
    final int r2;
    int r3;
    final int r4;
    r4 = CPU.addT(r1, 0x0);
    r1 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
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
  public static void FUN_8091254(int r0) {
    final int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;

    r4 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.addT(r4, 0x2a01);
      r2 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r3).setu(r5);
      r3 = CPU.addT(r4, 0x2a02);
      MEMORY.ref(1, r3).setu(r2);
      r3 = CPU.movT(0, 0xe0);
      r3 = CPU.lslT(r3, 4);
      r2 = CPU.movT(0, 0xe0);
      r1 = CPU.addT(r4, r3);
      r3 = CPU.movT(0, 0xc4);
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.lslT(r3, 5);
      r0 = CPU.addT(r4, r2);
      r2 = CPU.addT(r4, r3);
      r3 = CPU.addT(r5, 0x0);
      FUN_809088c(r0, r1, r2, r3);
    }

    //LAB_8091286
  }

  @Method(0x8091294)
  public static int FUN_8091294(final int r0) {
    return MathHelper.clamp(r0, 0, 0x1f);
  }

  @Method(0x80912a8)
  public static int FUN_80912a8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091560)
  public static int FUN_8091560(int r0) {
    int r1;
    final int r2;
    int r3;

    r2 = CPU.addT(r0, 0x0);
    r0 = 0x809e9f0;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_809156e
      do {
        r1 = CPU.addT(r1, 0x1);
        r0 = CPU.addT(r0, 0x4);
        CPU.cmpT(r1, 0x81);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_809157c
    return r0;
  }

  @Method(0x80915ac)
  public static int FUN_80915ac(final int r0) {
    if(MEMORY.ref(1, 0x200044a).getUnsigned() == 0) {
      return 0;
    }

    final int r0_0 = MEMORY.ref(1, FUN_8091560(r0) + 0x2).getUnsigned();
    if(r0_0 == 0xff) {
      //LAB_80915c4
      return 0;
    }

    //LAB_80915c8
    //LAB_80915ce
    return r0_0 + 0x100;
  }

  @Method(0x80915ec)
  public static void FUN_80915ec() {
    final int r1;
    int r2;
    int r3;

    r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r3 = _3001f54.get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x80);
      r3 = pressedButtons_3001c94.get();
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xe6);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r1, r3);
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_8091612
      r3 = pressedButtons_3001c94.get();
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xe6);
        r3 = CPU.lslT(r3, 1);
        r2 = CPU.addT(r1, r3);
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.negT(r3, r3);
        MEMORY.ref(4, r2).setu(r3);
      }
    }

    //LAB_809162a
  }

  @Method(0x809163c)
  public static void FUN_809163c(final int r0) {
    if(boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x1cc).get() == 0 && r0 != 0) {
      FUN_80030f8(r0);
    }

    //LAB_8091656
  }

  @Method(0x8091660)
  public static void FUN_8091660() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r2 = CPU.movT(0, 0xfa);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(0x2000240, r2);
    r0 = MEMORY.ref(4, r3).get();
    r0 = FUN_808ba1c(r0);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 9);
    MEMORY.ref(4, r0 + 0x30).setu(r3);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 8);
    MEMORY.ref(4, r0 + 0x34).setu(r3);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 24);
    MEMORY.ref(4, r0 + 0x38).setu(r3);
    MEMORY.ref(4, r0 + 0x40).setu(r3);
    r2 = CPU.movT(0, 0xf9);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r0 + 0x24).setu(r3);
    MEMORY.ref(4, r0 + 0x2c).setu(r3);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(0x2000240, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.movT(0, 0xc);
      FUN_8009080(r0, r1);
    } else {
      //LAB_809169e
      r1 = CPU.movT(0, 0x1);
      FUN_8009080(r0, r1);
    }

    //LAB_80916a4
  }

  @Method(0x80916b0)
  public static void FUN_80916b0() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_8015208();
    FUN_8091660();
    r2 = 0xcb6;
    r3 = CPU.addT(r6, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_808e118();
    }

    //LAB_80916ce
    r2 = 0xcc2;
    r5 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r6, r2);
    r2 = CPU.addT(r2, 0x2);
    MEMORY.ref(2, r3).setu(r5);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(2, r3).setu(r5);
    r3 = CPU.movT(0, 0xe4);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x10);
    MEMORY.ref(4, r2).setu(r3);
    r2 = CPU.movT(0, 0xe6);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(4, r3).setu(r5);
    r3 = CPU.movT(0, 0xed);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    MEMORY.ref(2, r2).setu(0xffff);
    r3 = CPU.movT(0, 0xee);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.movT(0, 0xef);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r6, r3);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r1 = CPU.movT(0, 0xc8);
    MEMORY.ref(2, r2).setu(r3);
    r1 = CPU.lslT(r1, 4);
    FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_80915ec"), r1);
    r0 = CPU.movT(0, 0x99);
    r0 = CPU.lslT(r0, 1);
    FUN_80770d0(r0);
    r2 = CPU.movT(0, 0xfa);
    r2 = CPU.lslT(r2, 1);
    r3 = MEMORY.ref(4, 0x2000240 + r2).get();
    MEMORY.ref(4, r6 + r2).setu(r3);
    r2 = CPU.addT(r2, 0x4);
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(4, r3).setu(r5);
  }

  @Method(0x80919d8)
  public static int FUN_80919d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091a58)
  public static int FUN_8091a58(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091c7c)
  public static int FUN_8091c7c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091dc8)
  public static void FUN_8091dc8() {
    final int r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_808fefc(MEMORY.ref(4, r5 + 0x1c0).get(), MEMORY.ref(4, r5 + 0x1c8).get());
    MEMORY.ref(2, r5 + 0x1c6).setu(0x1);
  }

  /** Called after confirming character names */
  @Method(0x8091df4)
  public static void FUN_8091df4() {
    final int r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    FUN_80901c0(MEMORY.ref(4, r5 + 0x1c0).get(), MEMORY.ref(4, r5 + 0x1c8).get());
    MEMORY.ref(2, r5 + 0x1c6).setu(0);
  }

  @Method(0x8091e20)
  public static void FUN_8091e20() {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x1c8;
    FUN_80030f8(MEMORY.ref(4, r3).get());
  }

  @Method(0x8091e3c)
  public static void FUN_8091e3c(final int r0, final int r1) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x170;
    MEMORY.ref(2, r3).setu(999);
    MEMORY.ref(2, 0x2000400).setu(r0);
    MEMORY.ref(2, 0x2000402).setu(r1);
  }

  @Method(0x8091e9c)
  public static void FUN_8091e9c(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x170;
    MEMORY.ref(2, r3).setu(r0);
  }

  @Method(0x8092054)
  public static int FUN_8092054(final int r0) {
    return FUN_808ba1c(r0);
  }

  @Method(0x8092064)
  public static void FUN_8092064(int r0, final int r1, final int r2) {
    final int r6 = CPU.addT(r1, 0x0);
    final int r5 = CPU.addT(r2, 0x0);
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      MEMORY.ref(4, r0 + 0x34).setu(r5);
      MEMORY.ref(4, r0 + 0x30).setu(r6);
    }

    //LAB_8092076
  }

  @Method(0x809207c)
  public static void FUN_809207c(int r0, int r1) {
    final int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, 0x5a);
      r2 = MEMORY.ref(1, r1).getUnsigned();
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(1, r1).setu(r3);
      r1 = CPU.addT(r5, 0x0);
      FUN_8093a6c(r0, r1);
    }

    //LAB_809209a
  }

  @Method(0x80920e8)
  public static void FUN_80920e8(int r0) {
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_8009148(r0);
    }

    //LAB_80920f6
  }

  @Method(0x8092158)
  public static void FUN_8092158(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r2, 0x0);
    r0 = FUN_808ba1c(r0);
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.addT(r5, 0x0);
      r2 = CPU.addT(r2, 0x5b);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r2).setu(r3);
      FUN_8009140(r0);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.lslT(r6, 16);
      r2 = MEMORY.ref(4, r5 + 0xc).get();
      r3 = CPU.lslT(r7, 16);
      FUN_8009150(r0, r1, r2, r3);
      r0 = CPU.addT(r5, 0x0);
      FUN_8009158(r0);
    }

    //LAB_8092186
  }

  @Method(0x80921c4)
  public static void FUN_80921c4(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r2, 0x0);
    r0 = FUN_808ba1c(r0);
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.addT(r5, 0x0);
      r2 = CPU.addT(r2, 0x5b);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r2).setu(r3);
      FUN_8009140(r0);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x2);
      FUN_8009080(r0, r1);
      r1 = CPU.lslT(r6, 16);
      r2 = MEMORY.ref(4, r5 + 0xc).get();
      r3 = CPU.lslT(r7, 16);
      r0 = CPU.addT(r5, 0x0);
      FUN_8009150(r0, r1, r2, r3);
      r0 = CPU.addT(r5, 0x0);
      FUN_8009158(r0);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x1);
      FUN_8009080(r0, r1);
    }

    //LAB_8092202
  }

  @Method(0x80923e4)
  public static void FUN_80923e4(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;
    final int r7;

    r6 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r2, 0x0);
    r0 = FUN_808ba1c(r0);
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_8009140(r0);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r5 + 0x24).setu(r3);
      MEMORY.ref(4, r5 + 0x28).setu(r3);
      MEMORY.ref(4, r5 + 0x2c).setu(r3);
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 24);
      MEMORY.ref(4, r5 + 0x3c).setu(r3);
      MEMORY.ref(4, r5 + 0x38).setu(r3);
      MEMORY.ref(4, r5 + 0x8).setu(r6);
      MEMORY.ref(4, r5 + 0x10).setu(r7);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x55);
      r2 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.addT(r3, 0x22);
        r1 = CPU.addT(r6, 0x0);
        r0 = MEMORY.ref(1, r3).getUnsigned();
        CPU.cmpT(r1, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r1 = CPU.addT(r1, 0xffff);
        }

        //LAB_809242a
        r2 = CPU.addT(r7, 0x0);
        r1 = CPU.asrT(r1, 16);
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = CPU.addT(r2, 0xffff);
        }

        //LAB_8092436
        r2 = CPU.asrT(r2, 16);
        r0 = FUN_80091a8(r0, r1, r2);
        r3 = MEMORY.ref(4, r5 + 0xc).get();
        r2 = MEMORY.ref(4, r5 + 0x14).get();
        r0 = CPU.lslT(r0, 16);
        r3 = CPU.subT(r3, r2);
        r3 = CPU.addT(r3, r0);
        MEMORY.ref(4, r5 + 0xc).setu(r3);
        MEMORY.ref(4, r5 + 0x14).setu(r0);
      }
    }

    //LAB_809244a
  }

  @Method(0x80924d4)
  public static void FUN_80924d4(final int r0, final int r1) {
    final int r0_0 = FUN_808ba1c(r0);
    if(r0_0 != 0) {
      FUN_8009080(r0_0, r1);
    }

    //LAB_80924e6
  }

  @Method(0x8092504)
  public static void FUN_8092504(int r0) {
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    CPU.sp().value -= 0x4;
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.addT(r3, 0x54);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r0 + 0x50).get();
        r6 = CPU.addT(r3, 0x0);
        r6 = CPU.addT(r6, 0x24);
        r3 = MEMORY.ref(1, r6).getUnsigned();
        r7 = CPU.sp().value;
        r5 = CPU.movT(0, 0x0);
        MEMORY.ref(4, r7).setu(r3);

        CPU.cmpT(r5, 0x59);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r0 = CPU.movT(0, 0x1);
          FUN_80030f8(r0);
          r2 = MEMORY.ref(1, r6).getUnsigned();
          r3 = MEMORY.ref(4, r7).get();
          r3 = CPU.cmpT(r3, r2);

          //LAB_809252a
          while(CPU.cpsr().getZero()) { // ==
            r5 = CPU.addT(r5, 0x1);

            //LAB_809252c
            CPU.cmpT(r5, 0x59);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              break;
            }
            FUN_80030f8(0x1);
            r2 = MEMORY.ref(1, r6).getUnsigned();
            r3 = MEMORY.ref(4, r7).get();
            r3 = CPU.cmpT(r3, r2);
          }
        }
      }
    }

    //LAB_809253e
    CPU.sp().value += 0x4;
  }

  @Method(0x8092548)
  public static void FUN_8092548(final int r0, final int r1) {
    FUN_80924d4(r0, r1);
    FUN_8092504(r0);
  }

  @Method(0x8092560)
  public static void FUN_8092560(int r0, int r1, int r2) {
    int r3;
    final int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r6 = CPU.addT(r2, 0x0);
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, 0x55);
      r3 = MEMORY.ref(1, r1).getUnsigned();
      r2 = CPU.movT(0, 0x2);
      r2 = CPU.orrT(r2, r3);
      r3 = CPU.lslT(r5, 16);
      MEMORY.ref(1, r1).setu(r2);
      MEMORY.ref(4, r0 + 0x28).setu(r3);
      CPU.cmpT(r5, 0x5);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        FUN_80f9010(0x99);
      } else {
        //LAB_809258a
        FUN_80f9010(0x98);
      }

      //LAB_8092590
      FUN_809163c(r6);
    }

    //LAB_8092596
  }

  @Method(0x809259c)
  public static void FUN_809259c(int r0, int r1) {
    int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_808ba1c(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        CPU.cmpT(r5, 0x3);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r5 = CPU.movT(0, 0x3);
        }

        //LAB_80925b2
        r1 = CPU.movT(0, 0x3);
        r1 = CPU.subT(r1, r5);
        r1 = CPU.lslT(r1, 7);
        r1 = CPU.addT(r1, 0x809ebfc);
        FUN_8009098(r0, r1);
      }
    }

    //LAB_80925c0
  }

  @Method(0x80925cc)
  public static void FUN_80925cc(final int r0, final int r1) {
    FUN_809259c(r0, r1);
    FUN_80920e8(r0);
  }

  @Method(0x8092950)
  public static void FUN_8092950(int r0, final int r1) {
    r0 = FUN_808ba1c(r0);
    if(r0 != 0) {
      if((r1 & 0x100) != 0) {
        MEMORY.ref(4, r0 + 0x6c).setu(0x8092981);
      } else {
        //LAB_809296c
        MEMORY.ref(4, r0 + 0x6c).setu(0);
        FUN_80929d8(r0, r1);
      }
    }

    //LAB_8092974
  }

  @Method(0x80929d8)
  public static void FUN_80929d8(int r0, final int r1) {
    int r2;
    int r3;
    int r4;

    r3 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r3, 0x54);
    r2 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.movT(0, 0xf);
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x1);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, r0 + 0x50).get();
      CPU.r12().value = r0;
      r3 = CPU.r12().value;
      r3 = CPU.addT(r3, 0x27);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r4 = CPU.r12().value;
        r4 = CPU.addT(r4, 0x28);
        r0 = CPU.addT(r3, 0x0);

        //LAB_80929fc
        do {
          r2 = MEMORY.ref(4, r4).get();
          r4 += 0x4;

          CPU.cmpT(r2, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(4, r2 + 0x10).get();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              MEMORY.ref(1, r2 + 0x5).setu(r1);
            }
          }

          //LAB_8092a0a
          r0 = CPU.subT(r0, 0x1);
          CPU.cmpT(r0, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8092a10
      r2 = CPU.r12().value;
      r2 = CPU.addT(r2, 0x25);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r2).setu(r3);
    }

    //LAB_8092a18
  }

  @Method(0x8092adc)
  public static void FUN_8092adc(int r0, final int r1, final int r2) {
    r0 = FUN_808ba1c(r0);
    if(r0 != 0) {
      MEMORY.ref(2, r0 + 0x64).setu(r1);
      FUN_8009098(r0, 0x809fc1c);
      FUN_809163c(r2);
    }

    //LAB_8092afc
  }

  @Method(0x8092b08)
  public static void FUN_8092b08(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_808ba1c(r0);
    r6 = CPU.addT(r0, 0x0);
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x54);
      r2 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.movT(0, 0xf);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r1 = MEMORY.ref(4, r6 + 0x50).get();
        r2 = CPU.movT(0, 0xd);
        r0 = MEMORY.ref(1, r1 + 0x9).getUnsigned();
        r3 = CPU.movT(0, 0x3);
        r2 = CPU.negT(r2, r2);
        r5 = CPU.andT(r5, r3);
        r3 = CPU.addT(r2, 0x0);
        r4 = CPU.lslT(r5, 2);
        r3 = CPU.andT(r3, r0);
        r3 = CPU.orrT(r3, r4);
        MEMORY.ref(1, r1 + 0x9).setu(r3);
        r3 = MEMORY.ref(1, r1 + 0x15).getUnsigned();
        r2 = CPU.andT(r2, r3);
        r2 = CPU.orrT(r2, r4);
        MEMORY.ref(1, r1 + 0x15).setu(r2);
        r1 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r1, 0x23);
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.movT(0, 0xfe);
        r3 = CPU.andT(r3, r2);
        MEMORY.ref(1, r1).setu(r3);
      }
    }

    //LAB_8092b4e
  }

  @Method(0x8092b94)
  public static void FUN_8092b94(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get() + 0x1d8;
    MEMORY.ref(2, r3).setu(r0);
  }

  @Method(0x8092ba8)
  public static int FUN_8092ba8(final int r0) {
    final int r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x14 + (r0 & 0xfff) * 0x4).get();

    if(r2 == 0 || MEMORY.ref(1, r2 + 0x54).getUnsigned() != 1) {
      return -1;
    }

    //LAB_8092bd2
    return MEMORY.ref(4, r2 + 0x50).deref(4).offset(0x28).deref(2).get();
  }

  @Method(0x8092c40)
  public static int FUN_8092c40(int r0) {
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
    CPU.sp().value -= 0x40;

    MEMORY.ref(4, CPU.sp().value + 0x20).setu(boardWramMallocHead_3001e50.offset(15 * 0x4).get());
    r6 = r0;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(boardWramMallocHead_3001e50.offset(27 * 0x4).get());
    CPU.r10().value = 0;
    CPU.r9().value = 0;
    r0 = FUN_8092ba8(r6);
    CPU.r11().value = 0xf000;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x4);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    CPU.r11().value = CPU.r11().value & r6;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r3 = r1 + 0x1d8;
    r1 = MEMORY.ref(2, r3).get();
    r6 = r6 & 0xfff;
    CPU.r8().value = r1;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    r0 = FUN_808ba1c(r6);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    MEMORY.ref(4, r1 + 0x1f4).setu(r6);
    r5 = 0;
    r7 = 0;
    r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    if(MEMORY.ref(4, r1 + 0x1cc).get() == 0) {
      //LAB_8092cb6
      if(r0 != 0) {
        r3 = MEMORY.ref(2, r1 + 0x19e).get();
        if(r3 == 3) {
          r5 = CPU.sp().value + 0x34;
          r1 = CPU.addT(r5, 0x0);
          r0 = CPU.addT(r0, 0x8);
          r0 = FUN_8005268(r0, r1);
          r3 = MEMORY.ref(4, r5).get();
          r4 = CPU.asrT(r3, 3);
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r5 = CPU.asrT(r3, 3);
          r7 = CPU.movT(0, 0x1);
          r5 = CPU.subT(r5, 0x2);
        } else {
          //LAB_8092cde
          r5 = CPU.sp().value + 0x34;
          r1 = CPU.addT(r5, 0x0);
          r0 = CPU.addT(r6, 0x0);
          r0 = FUN_8094154(r0, r1);
          r0 = CPU.mvnT(r0, r0);
          r3 = CPU.negT(r3, r0);
          r3 = CPU.orrT(r3, r0);
          r7 = CPU.lsrT(r3, 31);
          r3 = MEMORY.ref(4, r5).get();
          r4 = CPU.asrT(r3, 3);
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r5 = CPU.asrT(r3, 3);
        }
      } else {
        //LAB_8092ce6
        CPU.cmpT(r6, 0x7);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = MEMORY.ref(4, 0x8092f7c).get();
          r2 = CPU.movT(0, 0xfa);
          r2 = CPU.lslT(r2, 1);
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r6);
          r5 = CPU.addT(r3, r2);
          r0 = MEMORY.ref(4, r5).get();
          r0 = FUN_808ba1c(r0);
          r2 = CPU.movT(0, 0xcf);
          r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r2 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r1, r2);
          r1 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r1).get();
          CPU.cmpT(r3, 0x3);
          if(CPU.cpsr().getZero()) { // ==
            r5 = CPU.sp().value + 0x34;
            r1 = CPU.addT(r5, 0x0);
            r0 = CPU.addT(r0, 0x8);
            r0 = FUN_8005268(r0, r1);
            r3 = MEMORY.ref(4, r5).get();
            r4 = CPU.asrT(r3, 3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r7 = CPU.movT(0, 0x1);
          } else {
            //LAB_8092d1e
            r0 = MEMORY.ref(4, r5).get();
            r5 = CPU.sp().value + 0x34;
            r1 = CPU.addT(r5, 0x0);

            //LAB_8092d24
            r0 = FUN_8094154(r0, r1);
            r0 = CPU.mvnT(r0, r0);
            r3 = CPU.negT(r3, r0);
            r3 = CPU.orrT(r3, r0);
            r7 = CPU.lsrT(r3, 31);
            r3 = MEMORY.ref(4, r5).get();
            r4 = CPU.asrT(r3, 3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
          }

          //LAB_8092d36
          r5 = CPU.asrT(r3, 3);
        }
      }

      //LAB_8092d38
      CPU.cmpT(r7, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0xf);
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
        r3 = CPU.movT(0, 0xa);
      } else {
        //LAB_8092d44
        r3 = CPU.movT(0, 0x0);
        r0 = CPU.sp().value + 0x24;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
        r2 = CPU.sp().value + 0x2c;
        r3 = CPU.sp().value + 0x28;
        MEMORY.ref(4, CPU.sp().value).setu(r0);
        r1 = CPU.sp().value + 0x30;
        r0 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
        r0 = FUN_8015110(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r2 = CPU.lsrT(r3, 31);
        r3 = CPU.addT(r3, r2);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = CPU.asrT(r3, 1);
        r3 = CPU.subT(r4, r3);
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 7);
        r2 = CPU.r11().value;
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r3 = CPU.subT(r5, r3);
          r3 = CPU.subT(r3, 0x1);
        } else {
          //LAB_8092d7e
          r1 = CPU.r11().value;
          r3 = CPU.lsrT(r1, 15);
          if(r3 == 0 && r5 <= 8) {
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r3 = CPU.subT(r5, r3);
            r3 = CPU.subT(r3, 0x1);
          } else {
            //LAB_8092d92
            r3 = CPU.addT(r5, 0x4);
          }
        }
      }

      //LAB_8092d94
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      r1 = MEMORY.ref(4, 0x8092f80).get();
      r3 = CPU.addT(r2, r1);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.movT(0, 0x5);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
      }

      //LAB_8092da6
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 5);
      r1 = CPU.r11().value;
      r3 = CPU.andT(r3, r1);
      r6 = CPU.addT(r4, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r3 = CPU.subT(r6, r2);
        r6 = CPU.subT(r3, 0x2);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r6 = CPU.movT(0, 0x0);
        }
      } else {
        //LAB_8092dc2
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 6);
        r1 = CPU.r11().value;
        r3 = CPU.andT(r3, r1);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r6 = CPU.addT(r6, 0x2);
          r3 = CPU.addT(r6, r2);
          CPU.cmpT(r3, 0x1d);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r3 = CPU.movT(0, 0x1d);
            r6 = CPU.subT(r3, r2);
          }
        } else {
          //LAB_8092dde
          CPU.cmpT(r6, 0xf);
          if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = CPU.subT(r6, r1);
            r6 = CPU.subT(r3, 0x2);
            CPU.cmpT(r6, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r6 = CPU.addT(r4, 0x2);
            }
          } else {
            //LAB_8092df0
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r6 = CPU.addT(r6, 0x2);
            r3 = CPU.addT(r6, r2);
            CPU.cmpT(r3, 0x1d);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r3 = CPU.subT(r4, r2);
              r6 = CPU.subT(r3, 0x2);
            }
          }
        }
      }

      //LAB_8092dfe
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      r0 = FUN_80151e0(r0);
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.negT(r3, r3);
      r7 = CPU.addT(r0, 0x0);
      CPU.r10().value = r3;
      CPU.cmpT(r7, CPU.r10().value);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.sp().value;
        r1 = CPU.movT(0, 0x30);
        r2 = CPU.movT(0, 0x2c);
        r1 += CPU.sp().value;
        r2 += CPU.sp().value;
        r3 = CPU.addT(r3, 0x28);
        r7 = CPU.sp().value + 0x24;
        r0 = CPU.r8().value;
        CPU.r9().value = r1;
        CPU.r11().value = r2;
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        MEMORY.ref(4, CPU.sp().value).setu(r7);
        r0 = FUN_8015110(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = CPU.subT(r2, 0x5);
        CPU.r8().value = CPU.r10().value;
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
        r2 = CPU.cmpT(r2, r5);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r3 = CPU.addT(r2, r3);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
        }

        //LAB_8092e3e
        r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r3 = CPU.addT(r2, r3);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
        } else {
          //LAB_8092e4c
          r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r3 = CPU.addT(r3, 0x5);
          CPU.cmpT(r3, 0x13);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = CPU.subT(r2, 0x5);
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
          }
        }

        //LAB_8092e58
        r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r2 = CPU.cmpT(r2, r3);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r0 = CPU.movT(0, 0x1);
          r1 = CPU.r9().value;
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r0 = CPU.negT(r0, r0);
          r2 = CPU.r11().value;
          r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r0 = FUN_8015108(r0, r1, r2, r3, r7);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
          r1 = CPU.movT(0, 0x1);
          r5 = CPU.subT(r5, r3);
          r1 = CPU.negT(r1, r1);
          r5 = CPU.addT(r5, 0x1);
          CPU.r8().value = r1;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r5);
        }
        //LAB_8092e80
      } else if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() < r5) {
        r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        r0 = FUN_8015108(CPU.r8().value, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24);
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r5 - MEMORY.ref(4, CPU.sp().value + 0x24).get() + 1);
        CPU.r8().value = r7;
      }

      //LAB_8092ea2
      if(r6 < 0) {
        r6 = 0;
      } else {
        //LAB_8092eaa
        r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        if(r6 + r2 > 0x1d) {
          r6 = 0x1d - r2;
        }
      }

      //LAB_8092eb6
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      if(MEMORY.ref(1, r1 + 0xea4).getUnsigned() != 0) {
        FUN_80030f8(0x8);

        if(MEMORY.ref(4, CPU.sp().value + 0x14).get() != 0) {
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get() + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
          r3 = 0x12;
        } else {
          //LAB_8092edc
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x2;
        }
      } else {
        //LAB_8092ee6
        r0 = FUN_80915ac(MEMORY.ref(4, CPU.sp().value + 0x18).get());

        if(MEMORY.ref(4, CPU.sp().value + 0x14).get() != 0) {
          r3 = r0 << 16 | 0x11;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get() + MEMORY.ref(4, CPU.sp().value + 0x2c).get() - 1;
        } else {
          //LAB_8092f04
          r3 = r0 << 16 | 0x1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        }

        //LAB_8092f0e
      }

      //LAB_8092f10
      CPU.r10().value = FUN_8015038(CPU.r8().value, MEMORY.ref(4, CPU.sp().value + 0x30).get(), r2, r3).getAddress(); //TODO
      CPU.r9().value = FUN_80150f8(MEMORY.ref(4, CPU.sp().value + 0x18).get(), 0, r6, MEMORY.ref(4, CPU.sp().value + 0x10).get()).getAddress(); //TODO

      //LAB_8092f34
      //LAB_8092f2e
      while(FUN_8015048() == 0) {
        FUN_80030f8(1);
      }
    }

    //LAB_8092f3c
    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r2 = CPU.movT(0, 0xfc);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r1, r2);
    r1 = CPU.r10().value;
    MEMORY.ref(4, r3).setu(r1);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r1 = CPU.movT(0, 0xfe);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r2, r1);
    r2 = CPU.r9().value;
    MEMORY.ref(4, r3).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r1 = CPU.subT(r1, 0x24);
    r2 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(2, r2).getUnsigned();
    r3 = CPU.addT(r3, 0x1);
    r0 = CPU.r10().value;
    MEMORY.ref(2, r2).setu(r3);

    CPU.sp().value += 0x40;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();

    return r0;
  }

  @Method(0x8092f84)
  public static void FUN_8092f84(int r0, final int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;
    int r8;
    final int r9;
    final int r10;

    r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r7 = CPU.addT(r0, 0x0);
    r9 = r3;
    r0 = FUN_8092c40(r0);
    r10 = r0;
    r0 = CPU.movT(0, 0x1);
    FUN_80030f8(r0);
    r0 = CPU.addT(r7, 0x0);
    r0 = FUN_8092ba8(r0);
    r5 = CPU.movT(0, 0x0);
    r8 = r0;
    CPU.cmpT(r7, 0x7);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r6 = CPU.andT(0xfff, r7);
      r0 = CPU.addT(r6, 0x0);
      r0 = FUN_808d394(r0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r8 = r6;
      }
    }

    //LAB_8092fc0
    r0 = r8;
    FUN_8015100(r0);
    r3 = CPU.movT(0, 0xe6);
    r3 = CPU.lslT(r3, 1);
    r3 += r9;
    r3 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = r10;
      r0 = FUN_8015050(r0);
      CPU.cmpT(r0, 0x0);

      //LAB_8092fd4
      while(CPU.cpsr().getZero()) { // ==
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r3 = CPU.movT(0, 0x96);
        r5 = CPU.addT(r5, 0x1);
        r3 = CPU.lslT(r3, 2);
        r5 = CPU.cmpT(r5, r3);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          FUN_8015140();
        } else {
          r2 = heldButtonsLastFrame_3001ae8.get();
          r3 = CPU.movT(0, 0x4);
          r2 = CPU.andT(r2, r3);
          CPU.cmpT(r2, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = heldButtonsLastFrame_3001ae8.get();
            r3 = CPU.addT(r3, 0xfc);
            r2 = CPU.andT(r2, r3);
            CPU.cmpT(r2, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r2 = heldButtonsLastFrame_3001ae8.get();
              r3 = CPU.movT(0, 0x80);
              r3 = CPU.lslT(r3, 2);
              r2 = CPU.andT(r2, r3);
              CPU.cmpT(r2, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r3 = heldButtonsLastFrame_3001ae8.get();
                r2 = CPU.movT(0, 0x1);
                r3 = CPU.andT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_8093010
                  FUN_8015140();
                }
              }
            }
          }
        }

        //LAB_8093014
        r0 = r10;
        r0 = FUN_8015050(r0);
        CPU.cmpT(r0, 0x0);
      }
    }

    //LAB_809301e
    r0 = CPU.movT(0, 0x1);
    FUN_80030f8(r0);
  }

  @Method(0x8093040)
  public static void FUN_8093040(final int r0, final int r1, final int r2) {
    FUN_8092f84(r0, r1);
    FUN_809163c(r2);
  }

  @Method(0x8093304)
  public static void FUN_8093304(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;

    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 24);
    r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r0 = CPU.cmpT(r0, r1);
    if(CPU.cpsr().getZero()) { // ==
      r2 = 0x12f4;
      r1 = 0x12f6;
      r3 = CPU.addT(r5, r2);
      r2 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r3).setu(r2);
    } else {
      //LAB_809331e
      r0 = FUN_8092ba8(r0);
      r0 = FUN_80915ac(r0);
      r3 = 0x2000240;
      r1 = CPU.movT(0, 0x83);
      r1 = CPU.lslT(r1, 2);
      r3 = CPU.addT(r3, r1);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r1 = 0x12f4;
      r2 = MEMORY.ref(1, 0x809fc28 + r3).getUnsigned();
      r3 = CPU.addT(r5, r1);
      r1 = CPU.addT(r1, 0x2);
      MEMORY.ref(2, r3).setu(r0);
    }

    //LAB_809333c
    r3 = CPU.addT(r5, r1);
    MEMORY.ref(2, r3).setu(r2);
  }

  @Method(0x809335c)
  public static void FUN_809335c(int r0, int r1) {
    int r2;
    int r3;
    final int r5;
    final int r6;
    int r7;
    final int r8;
    final int r10;

    r10 = r1;
    r0 = FUN_808ba1c(r0);
    r1 = 0xccc;
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x1b);
    r0 = mallocSlotBoard(r0, r1);
    r3 = CPU.movT(0, 0xf0);
    r8 = r0;
    r3 = CPU.lslT(r3, 1);
    r3 += r8;
    r5 = MEMORY.ref(4, r3).get();
    r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r7 = CPU.addT(r5, 0x0);
      r7 = CPU.addT(r7, 0x8);
      MEMORY.ref(4, r3).setu(r7);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r6, 0x0);
      FUN_80090e0(r0, r1);
      r2 = r10;
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r6 + 0x8).get();
        MEMORY.ref(4, r7).setu(r3);
        r3 = MEMORY.ref(4, r6 + 0xc).get();
        MEMORY.ref(4, r5 + 0xc).setu(r3);
        r3 = MEMORY.ref(4, r6 + 0x10).get();
        r0 = CPU.movT(0, 0x1);
        MEMORY.ref(4, r5 + 0x10).setu(r3);
        FUN_80030f8(r0);
        r3 = CPU.movT(0, 0xcf);
        r3 = CPU.lslT(r3, 1);
        r3 += r8;
        r2 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r3 + r2).get();
        CPU.cmpT(r3, 0x3);
        if(!CPU.cpsr().getZero()) { // !=
          FUN_8009128();
        }
      }
    }

    //LAB_80933be
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

  @Method(0x8094154)
  public static int FUN_8094154(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_808ba1c(r0);
    r4 = CPU.addT(r0, 0x0);
    CPU.cmpT(r4, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
    } else {
      //LAB_8094168
      r3 = MEMORY.ref(4, 0x80941d0).get();
      r3 = MEMORY.ref(4, r3).get();
      r3 = CPU.addT(r3, 0xe4);
      r1 = MEMORY.ref(4, 0x80941d4).get();
      r0 = MEMORY.ref(4, r3).get();
      r2 = MEMORY.ref(4, r3 + 0x4).get();
      r3 = MEMORY.ref(4, r4 + 0x10).get();
      r2 = CPU.andT(r2, r1);
      r0 = CPU.andT(r0, r1);
      r1 = MEMORY.ref(4, r4 + 0x8).get();
      r3 = CPU.subT(r3, r2);
      r2 = MEMORY.ref(4, r4 + 0xc).get();
      r1 = CPU.subT(r1, r0);
      r6 = CPU.subT(r3, r2);
      r2 = CPU.addT(r5, 0x0);
      r5 = CPU.addT(r5, 0x4);
      CPU.cmpT(r1, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x80941d8).get();
        r1 = CPU.addT(r1, r3);
      }

      //LAB_8094190
      r3 = CPU.asrT(r1, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.addT(r6, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = MEMORY.ref(4, 0x80941d8).get();
        r3 = CPU.addT(r3, r2);
      }

      //LAB_809419e
      r3 = CPU.asrT(r3, 16);
      MEMORY.ref(4, r5).setu(r3);
      r3 = CPU.addT(r4, 0x0);
      r3 = CPU.addT(r3, 0x54);
      r2 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.movT(0, 0xf);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, r4 + 0x50).get();
        r3 = MEMORY.ref(4, r3 + 0x28).get();
        r2 = CPU.movT(0, 0x0);
        r0 = MEMORY.ref(2, r3 + r2).get();
        r0 = FUN_8185000(r0);
        r3 = MEMORY.ref(4, r5).get();
        r2 = CPU.movT(0, 0x8);
        r2 = MEMORY.ref(1, r0 + r2).get();
        r3 = CPU.subT(r3, r2);
        MEMORY.ref(4, r5).setu(r3);
      }

      //LAB_80941c6
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80941c8
    return r0;
  }

  /** NOTE returns r8 */
  @Method(0x80941e0)
  public static void FUN_80941e0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8094428)
  public static int FUN_8094428() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80949a8)
  public static void FUN_80949a8() {
    final int r6 = boardWramMallocHead_3001e50.offset(30 * 0x4).get();
    final int r7 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();

    if(MEMORY.ref(2, r6 + 0x1f80).get() >= 0) {
      if(FUN_80770c0(0x166) != 0) {
        MEMORY.ref(2, r6 + 0x1f80).setu(0x80);
      }

      //LAB_80949ce
      final int r3 = (short)MEMORY.ref(2, r6 + 0x1f80).getUnsigned();
      MEMORY.ref(2, r6 + 0x1f80).decr();

      switch(r3) {
        case 0:
          if(MEMORY.ref(2, r6 + 0x1f82).get() != 0) {
            MEMORY.ref(2, r6 + 0x1f80).setu((rand() * 400 >>> 16) - (rand() * 100 >>> 16) + 150);
            if(MEMORY.ref(2, r6 + 0x1f84).get() != 0) {
              FUN_80f9010(0xac);
            } else {
              //LAB_8094a5c
              FUN_80f9010(0xab);
            }
          }

        case 5:
        case 10:
          //LAB_8094a62
          FUN_8091200(r6, 0x1);
          DMA.channels[3].SAD.setu(r6 + 0x1500);
          DMA.channels[3].DAD.setu(r7 + 0x1880);
          DMA.channels[3].CNT.setu(0x840002a0);

          MEMORY.ref(1, r7 + 0x2a01).setu(0xc);
          MEMORY.ref(1, r7 + 0x2a02).setu(0);
          break;

        case 1:
        case 6:
        case 11:
          FUN_8091200(r6 + 0xa80, 0x1);
          MEMORY.ref(1, r7 + 0x2a01).setu(0x1);
          MEMORY.ref(1, r7 + 0x2a02).setu(0);
          break;
      }
    }

    //LAB_8094aa2
  }

  @Method(0x8095160)
  public static void FUN_8095160() {
    final int r5 = mallocSlotBoard(0x1e, 0x1f88);
    final int r3 = boardWramMallocHead_3001e50.offset(32 * 0x4).get();

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x850007e2);
    CPU.sp().value += 0x4;

    FUN_8090a5c(0x10003, r3, r5, 0x1);
    FUN_8090a5c(0x10005, r3, r5 + 0xa80, 0x1);
    FUN_809088c(r5 + 0xa80, r5, r5 + 0x1500, 0xc);
    FUN_8090a5c(r5, 0, r3 + 0xe00, 0x1);

    MEMORY.ref(2, r5 + 0x1f80).setu(0x258);
    MEMORY.ref(2, r5).setu(0x1);

    FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_80949a8"), 0xc80);
  }

  @Method(0x8095240)
  public static void FUN_8095240() {
    final int r0 = mallocSlotBoard(30, 0x1f88);
    MEMORY.ref(2, r0 + 0x1f80).setu(0xc);
    MEMORY.ref(2, r0 + 0x1f82).setu(0);
  }

  @Method(0x8095268)
  public static void FUN_8095268() {
    final int r0 = mallocSlotBoard(30, 0x1f88);
    MEMORY.ref(2, r0 + 0x1f80).setu(0x80);
    MEMORY.ref(2, r0 + 0x1f82).setu(0x1);
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
    r1 = 0x2000240;
    r0 = CPU.movT(0, 0x8d);
    r0 = CPU.lslT(r0, 2);
    r7 = CPU.addT(r1, r0);
    r3 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(2, r7 + r3).get();
    r2 = MEMORY.ref(2, r7).getUnsigned();
    r3 = CPU.movT(0, 0xf0);
    r6 = 0xfff;
    r3 = CPU.lslT(r3, 8);
    r0 = CPU.r8().value;
    r5 = CPU.andT(r5, r3);
    r6 = CPU.andT(r6, r2);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = 0x7ff;
        r2 = -300;
        r6 = CPU.andT(r6, r3);
        r3 = CPU.addT(r6, r2);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = 0x236;
          r3 = CPU.addT(r1, r0);
          r1 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r1).get();
          if(r2 <= 0 || r2 == 999) {
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
          r2 = 0x236;
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
        r2 = 0x7ff;
        r0 = -300;
        r6 = CPU.andT(r6, r2);
        r3 = CPU.addT(r6, r0);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r6 = CPU.andT(r6, r2);
          r2 = 0x236;
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = -300;
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
                r0 = -300;
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
            r1 = 0x2000240;
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

  @Method(0x80967e4)
  public static void FUN_80967e4(final int r0) {
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_8096810();
    } else {
      //LAB_80967f0
      CPU.cmpT(r0, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        FUN_8096960();
      } else {
        //LAB_80967fa
        CPU.cmpT(r0, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          FUN_8096ab0();
        } else {
          //LAB_8096804
          CPU.cmpT(r0, 0x3);
          if(CPU.cpsr().getZero()) { // ==
            FUN_8096af0();
          }
        }
      }
    }

    //LAB_809680c
  }

  @Method(0x8096810)
  public static void FUN_8096810() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096960)
  public static void FUN_8096960() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096ab0)
  public static void FUN_8096ab0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096af0)
  public static void FUN_8096af0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8096c24)
  public static int FUN_8096c24() {
    int r0 = 0;

    //LAB_8096c2e
    for(int i = 0; i < 0x200; i++) {
      if(_3001810.get(i).get() == 0xff) {
        r0++;
      }

      //LAB_8096c38
    }

    return r0;
  }

  @Method(0x8096cdc)
  public static void FUN_8096cdc(int r0, int r1, int r2) {
    int r3;
    int r5;
    final int r6;
    final int r7;
    final int r8;
    final int r10;

    r7 = CPU.addT(r1, 0x0);
    r8 = r0;
    r6 = CPU.addT(r2, 0x0);
    r5 = CPU.movT(0, 0x0);
    r10 = 0x200048a;

    //LAB_8096cf0
    do {
      r0 = CPU.addT(r5, 0x0);
      r0 = FUN_808ba1c(r0);
      r1 = r10;
      r2 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r1 + r2).get();
      r5 = CPU.cmpT(r5, r3);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          CPU.cmpT(r0, r8);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.addT(r0, 0x0);
            r3 = CPU.addT(r3, 0x5b);
            MEMORY.ref(1, r3).setu(r7);
            r1 = CPU.addT(r6, 0x0);
            FUN_8009088(r0, r1);
          }
        }
      }

      //LAB_8096d14
      r5 = CPU.addT(r5, 0x1);
      CPU.cmpT(r5, 0x42);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
  }

  @Method(0x8096fb0)
  public static void FUN_8096fb0(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;
    final int r7;
    final int r8;
    final int r9;
    final int r10;

    r8 = r0;
    r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    r10 = r2;
    r6 = MEMORY.ref(1, r10 + 0xcc6).get();
    CPU.sp().value -= 0x4;
    r9 = r1;
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r5 = mallocSlotChip(56, 0x720);
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(r5);
      DMA.channels[3].CNT.setu(0x850001c8);
    } else {
      //LAB_8097004
      r5 = MEMORY.ref(4, 0x3001f30).get();
    }

    //LAB_8097006
    r3 = r8;
    MEMORY.ref(2, r5 + 0x1c).setu(r3);
    r0 = r8;
    r0 = FUN_8077080(r0);
    r3 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
    MEMORY.ref(2, r5 + 0x1e).setu(r3);
    r6 = MEMORY.ref(1, r10 + 0xcc6).get();
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_8096c24();
      r2 = CPU.addT(r5, 0x0);
      r3 = 0x200 - r0;
      r2 = CPU.addT(r2, 0x4a);
      MEMORY.ref(2, r2).setu(r3);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x21);
      r4 = r9;
      MEMORY.ref(1, r3).setu(r4);
      r0 = CPU.movT(0, 0x1);
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(1, r3).setu(r0);
      r3 = CPU.subT(r3, 0x2);
      MEMORY.ref(1, r3).setu(r0);
      r3 = CPU.addT(r3, 0x3);
      MEMORY.ref(1, r3).setu(r0);
      r3 = CPU.addT(r5, 0x71c);
      MEMORY.ref(1, r3).setu(r0);
      r3 = MEMORY.ref(4, r7 + 0x4).get();
      MEMORY.ref(4, r5 + 0x4c).setu(r3);
      r3 = MEMORY.ref(4, r7 + 0x8).get();
      MEMORY.ref(4, r5 + 0x50).setu(r3);
      r3 = MEMORY.ref(4, r7 + 0xc).get();
      MEMORY.ref(4, r5 + 0x54).setu(r3);
      CPU.r12().value = 0x2000240;
      r3 = CPU.movT(0, 0xed);
      r3 = CPU.lslT(r3, 1);
      r3 += CPU.r12().value;
      r1 = MEMORY.ref(2, r3).getUnsigned();
      r4 = CPU.movT(0, 0x0);
      r2 = MEMORY.ref(2, r3 + r4).get();
      r3 = MEMORY.ref(4, 0x80970e8).get();
      r2 = CPU.cmpT(r2, r3);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.addT(r3, 0x45);
        MEMORY.ref(1, r3).setu(r0);
      }

      //LAB_8097086
      r3 = CPU.lslT(r1, 16);
      r3 = CPU.asrT(r3, 16);
      r3 = CPU.cmpT(r3, 0x37);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.addT(r3, 0x45);
        MEMORY.ref(1, r3).setu(r0);
      }

      //LAB_8097096
      r3 = CPU.movT(0, 0xfa);
      r3 = CPU.lslT(r3, 1);
      r3 += CPU.r12().value;
      r1 = CPU.movT(0, 0x1);
      r0 = MEMORY.ref(4, r3).get();
      r1 = CPU.negT(r1, r1);
      FUN_80970f8(r0, r1);
      r2 = CPU.movT(0, 0x1e);
      r3 = MEMORY.ref(2, r5 + r2).get();
      CPU.cmpT(r3, 0x8);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xcc);
        r3 = CPU.lslT(r3, 4);
        r3 += r10;
        MEMORY.ref(2, r3).setu(r6);
      }

      //LAB_80970b6
      r0 = FUN_8004080();
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x46);
      MEMORY.ref(2, r3).setu(r0);
      r1 = CPU.movT(0, 0x80);
      r0 = CPU.lslT(r0, 16);
      r1 = CPU.lslT(r1, 1);
      r0 = CPU.asrT(r0, 16);
      FUN_8003fa4(r0, r1, 0x809c410);
      r1 = CPU.movT(0, 0xc8);
      r1 = CPU.lslT(r1, 4);
      FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_8096f8c"), r1);
    }

    //LAB_80970d8
    CPU.sp().value += 0x4;
  }

  @Method(0x80970f8)
  public static void FUN_80970f8(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    final int r7;

    r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    MEMORY.ref(2, r6 + 0x18).setu(r0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.asrT(r0, 16);
    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_808ba1c(r0);
    MEMORY.ref(2, r6 + 0x1a).setu(r5);
    r5 = CPU.lslT(r5, 16);
    r7 = CPU.addT(r0, 0x0);
    r5 = CPU.asrT(r5, 16);
    MEMORY.ref(4, r6 + 0x10).setu(r7);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_808ba1c(r0);
    r3 = MEMORY.ref(2, r7 + 0x6).getUnsigned();
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 6);
    r1 = CPU.addT(r3, r2);
    r3 = CPU.movT(0, 0xc0);
    r3 = CPU.lslT(r3, 8);
    r1 = CPU.andT(r1, r3);
    MEMORY.ref(4, r6 + 0x14).setu(r0);
    MEMORY.ref(4, r6).setu(r1);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, r0 + 0x6c).get();
      MEMORY.ref(4, r6 + 0x38).setu(r3);
      r3 = MEMORY.ref(4, r0).get();
      MEMORY.ref(4, r6 + 0x3c).setu(r3);
      r3 = MEMORY.ref(4, r0 + 0x50).get();
      r3 = MEMORY.ref(4, r3 + 0x28).get();
      r2 = MEMORY.ref(1, r3 + 0x5).getUnsigned();
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x44);
      MEMORY.ref(1, r3).setu(r2);
      r3 = MEMORY.ref(4, r0 + 0x8).get();
      MEMORY.ref(4, r6 + 0x4).setu(r3);
      r3 = MEMORY.ref(4, r0 + 0x10).get();
      MEMORY.ref(4, r6 + 0xc).setu(r3);
      r3 = MEMORY.ref(4, r0 + 0xc).get();
      MEMORY.ref(4, r6 + 0x8).setu(r3);
    } else {
      //LAB_8097152
      r3 = MEMORY.ref(4, r7 + 0x8).get();
      MEMORY.ref(4, r6 + 0x4).setu(r3);
      r3 = MEMORY.ref(4, r7 + 0x10).get();
      MEMORY.ref(4, r6 + 0xc).setu(r3);
      r3 = MEMORY.ref(4, r7 + 0xc).get();
      r0 = CPU.movT(0, 0x80);
      MEMORY.ref(4, r6 + 0x8).setu(r3);
      r0 = CPU.lslT(r0, 13);
      r2 = CPU.addT(r6, 0x4);
      FUN_800447c(r0, r1, r2);
    }

    //LAB_8097168
  }

  @Method(0x8097174)
  public static void FUN_8097174() {
    int r0;
    final int r1;
    int r3;

    r3 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    r3 = MEMORY.ref(4, r3).get();
    r0 = MEMORY.ref(4, r3 + 0x10).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r0 + 0x6c).setu(r3);
    r1 = CPU.movT(0, 0x0);
    FUN_8009240(r0, r1);
    r0 = CPU.movT(0, 0x1);
    FUN_80030f8(r0);
  }

  @Method(0x8097194)
  public static void FUN_8097194() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809728c)
  public static void FUN_809728c() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;
    final int r7;
    final int r8;
    final int r10;

    r6 = boardWramMallocHead_3001e50.offset(56 * 0x4).get();
    r5 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x14);
    r10 = r3;
    r2 = CPU.movT(0, 0x1c);
    r7 = MEMORY.ref(2, r6 + r2).get();
    FUN_8009080(r0, r1);
    r3 = MEMORY.ref(4, r5 + 0x8).get();
    MEMORY.ref(4, r5 + 0x38).setu(r3);
    r3 = MEMORY.ref(4, r5 + 0xc).get();
    MEMORY.ref(4, r5 + 0x3c).setu(r3);
    r3 = MEMORY.ref(4, r5 + 0x10).get();
    MEMORY.ref(4, r5 + 0x40).setu(r3);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5 + 0x24).setu(r3);
    MEMORY.ref(4, r5 + 0x28).setu(r3);
    MEMORY.ref(4, r5 + 0x2c).setu(r3);
    r3 = CPU.movT(0, 0x22);
    r3 = CPU.addT(r3, r6);
    r8 = r3;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0xd4);
      FUN_80f9010(r0);
      MEMORY.ref(4, r5 + 0x6c).setu(0x8096f15);
    }

    //LAB_80972da
    r3 = CPU.addT(r6, 0x0);
    r3 = CPU.addT(r3, 0x23);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x1);
      r2 = CPU.movT(0, 0x0);
      FUN_8096cdc(r0, r1, r2);
      r0 = CPU.addT(r7, 0x0);
      r1 = CPU.movT(0, 0x4);
      FUN_8015120(r0, r1);
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x21);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.lslT(r3, 24);
      r3 = CPU.asrT(r3, 24);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_8015040(0x926, MEMORY.ref(1, r6 + 0x71c).get());
      } else {
        //LAB_8097318
        FUN_8015040(0x926, MEMORY.ref(1, r6 + 0x71c).get());
      }

      //LAB_8097326
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x0);
      r2 = CPU.movT(0, 0x10);
      FUN_8096cdc(r0, r1, r2);
    }

    //LAB_8097330
    r0 = CPU.movT(0, 0xa0);
    r0 = CPU.lslT(r0, 1);
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = r8;
      r3 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(1, r2 + r3).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x809737c).get();
        MEMORY.ref(4, r5 + 0x6c).setu(r3);
      }

      //LAB_809734a
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x15);
      FUN_8009080(r0, r1);
    } else {
      //LAB_8097354
      FUN_8097174();
    }

    //LAB_8097358
    MEMORY.ref(1, r10 + 0xcc7).setu(0x1);
  }

  @Method(0x8099810)
  public static void FUN_8099810() {
    int r1;
    int r2;
    int r3;

    r2 = CPU.movT(0, 0x93);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(0x2000240, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r1 = CPU.lslT(r1, 4);
      FUN_80041d8(getRunnable(GoldenSun_809.class, "FUN_8099678"), r1);
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
