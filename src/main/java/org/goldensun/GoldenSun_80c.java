package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.Unit14c;
import org.goldensun.types.Vec3;

import static org.goldensun.GoldenSun.FUN_800387c;
import static org.goldensun.GoldenSun.FUN_800393c;
import static org.goldensun.GoldenSun.FUN_80039fc;
import static org.goldensun.GoldenSun.FUN_80049ac;
import static org.goldensun.GoldenSun.FUN_8004bd4;
import static org.goldensun.GoldenSun.FUN_8004c1c;
import static org.goldensun.GoldenSun.FUN_8004cb4;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.FUN_8005258;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSun_801.FUN_8015128;
import static org.goldensun.GoldenSun_807.FUN_80770e0;
import static org.goldensun.GoldenSun_807.FUN_8077140;
import static org.goldensun.GoldenSun_807.FUN_8077198;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_80b.FUN_80b5028;
import static org.goldensun.GoldenSun_80b.FUN_80b5038;
import static org.goldensun.GoldenSun_80b.FUN_80b5048;
import static org.goldensun.GoldenSun_80b.FUN_80b595c;
import static org.goldensun.GoldenSun_80b.FUN_80b6a60;
import static org.goldensun.GoldenSun_80b.FUN_80b6c08;
import static org.goldensun.GoldenSun_80b.FUN_80b7b6c;
import static org.goldensun.GoldenSun_80b.FUN_80b7dd0;
import static org.goldensun.GoldenSun_80d.FUN_80d6888;
import static org.goldensun.GoldenSun_80e.FUN_80ed408;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80c {
  private GoldenSun_80c() { }

  @Method(0x80c0098)
  public static void FUN_80c0098(int r0) {
    int r2 = 0x3020100;

    //LAB_80c00a0
    for(int r3 = 0; r3 < 64; r3++) {
      MEMORY.ref(4, r0).setu(r2);
      r0 += 0x4;
      r2 += 0x4040404;
    }

    r2 = 0x3020100;

    //LAB_80c00b0
    for(int r3 = 0; r3 < 56; r3++) {
      MEMORY.ref(4, r0).setu(r2);
      r0 += 0x4;
      r2 += 0x4040404;
    }

    MEMORY.call(0x3000168, r0, 0x220, -1); // memfill32
  }

  @Method(0x80c00d8)
  public static void FUN_80c00d8(final int r0) {
    MEMORY.call(0x3000168, r0, 0x100, -1); // memfill32
    MEMORY.call(0x3000168, r0 + 0x100, 0x80, 0x3ff03ff); // memfill32

    int r2 = 0x2010200;
    int r6 = r0 + 0x180;

    //LAB_80c0102
    for(int r3 = 0; r3 < 240; r3++) {
      MEMORY.ref(4, r6).setu(r2);
      r6 += 0x4;
      r2 += 0x20002;
    }

    MEMORY.call(0x3000168, r6, 0x280, 0x3ff03ff); // memfill32
  }

  @Method(0x80c0130)
  public static void FUN_80c0130() {
    final int r3 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    if(MEMORY.ref(4, r3 + 0x8).get() == 0x2) {
      final int r4 = boardWramMallocHead_3001e50.offset(10 * 0x4).get();
      final int r0 = r4 + MEMORY.ref(4, r4).get() * 0x140;
      GPU.BG2CNT.setu(MEMORY.ref(2, r0 + 0x20).getUnsigned());
      DMA.channels[0].SAD.setu(r0 + 0x22);
      DMA.channels[0].DAD.setu(GPU.BG2CNT.getAddress());
      DMA.channels[0].CNT.setu(0xa2600001);
      DMA.channels[3].SAD.setu(r4 + 0x10);
      DMA.channels[3].DAD.setu(GPU.BG2PA.getAddress());
      DMA.channels[3].CNT.setu(0x84000004);
    }
  }

  @Method(0x80c01bc)
  public static void FUN_80c01bc() {
    final int r0;
    final int r1;
    int r2;
    int r3;
    final int r4;

    r3 = 0x3001ef8;
    r0 = MEMORY.ref(4, r3).get();
    r3 = r3 - 0x78;
    r1 = MEMORY.ref(4, r0).get();
    r4 = MEMORY.ref(4, r3).get();
    r2 = 0x34 - r1;
    if(r2 > 0x20) {
      r2 = 0x20;
    }

    //LAB_80c01d2
    if(r2 < 0) {
      r2 = 0x0;
    }

    //LAB_80c01d8
    r3 = 0x3001ad0;
    MEMORY.ref(2, r3 + 0x2).setu(r2);
    if((r1 & 0xffff_ffffL) <= (0x50 & 0xffff_ffffL)) {
      r2 = r1 << 1;
      r2 = r2 + r1;
      r3 = r2 << 4;
      r3 = r3 - r2;
      r2 = 0xaf80;
      r3 = r3 << 3;
      r3 = r3 + r2;
      MEMORY.ref(2, r4 + 0x36).setu(r3);
    }

    //LAB_80c01f0
    r3 = MEMORY.ref(4, r0).get();
    r2 = r3 + 0x1;
    MEMORY.ref(4, r0).setu(r2);
    if((r2 & 0xffff_ffffL) <= 80) {
      FUN_80c0cec(0, 0, 0, 0xb4 - r2);
    } else {
      //LAB_80c020a
      FUN_80c0cec(0, 0, 0, 100);
    }

    //LAB_80c0216
  }

  @Method(0x80c0228)
  public static void FUN_80c0228() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r3 = 0x3001ef8;
    r3 = MEMORY.ref(4, r3).get();
    r0 = MEMORY.ref(4, r3).get();
    if((r0 & 0xffff_ffffL) < 80) {
      r3 = r0 & 0x7;
      r4 = r3 + 0xf081;
      r3 = r0;
      if(r0 < 0) {
        r3 = r0 + 0x7;
      }

      //LAB_80c0244
      r3 = r3 >> 3;
      r2 = 0xd - r3;
      r5 = 0x6006000;
      r3 = r2 << 6;
      r1 = 0x0;
      r2 = r3 + r5;

      //LAB_80c0252
      do {
        r1 = r1 + 0x1;
        MEMORY.ref(2, r2).setu(r4);
        r2 = r2 + 0x2;
      } while(r1 != 0x20);

      r4 = r4 | 0x800;
      r3 = r0;
      if(r3 < 0) {
        r3 = r3 + 0x7;
      }

      //LAB_80c026a
      r3 = r3 >> 3;
      r2 = r3;
      r2 = r2 + 0xd;
      if((r2 & 0xffff_ffffL) <= 20) {
        r0 = 0x6006000;
        r3 = r2 << 6;
        r1 = 0x0;
        r2 = r3 + r0;

        //LAB_80c027c
        do {
          r1 = r1 + 0x1;
          MEMORY.ref(2, r2).setu(r4);
          r2 = r2 + 0x2;
        } while(r1 != 0x20);
      }
    }

    //LAB_80c0286
  }

  @Method(0x80c0298)
  public static void FUN_80c0298() {
    GPU.BG0VOFS.setu(0);
  }

  @Method(0x80c02a4)
  public static void FUN_80c02a4(int r0, int r1) {
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x94;
    MEMORY.ref(4, CPU.sp().value).setu(r0);
    r6 = 0x3001f00;
    r5 = r1;
    r0 = 0x2a;
    r1 = 0x4;
    r7 = MEMORY.ref(4, r6).get();
    r0 = mallocSlotChip(r0, r1);
    r1 = 0x15b;
    CPU.r11().value = r0;
    CPU.cmpT(r5, r1);
    if(r5 != r1) {
      //LAB_80c02ce
      r2 = 0x80c5b30;
      CPU.r12().value = r2;
      r3 = 0x40000d4;
      r0 = CPU.r12().value;
      r1 = 0x6005020;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0x20;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0x40;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0x60;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0x80;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0xa0;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r0 = CPU.r12().value;
      r0 = r0 + 0xc0;
      r1 = r1 + 0x20;
      r2 = 0x84000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r3 = r3 - 0xd4;
      r2 = 0x1;
      MEMORY.ref(2, r3).setu(r2);
      r3 = 0x33333333;
      r4 = CPU.sp().value + 0x90;
      r5 = 0x0;
      MEMORY.ref(4, r7 + 0xc).setu(r2);
      MEMORY.ref(4, r7 + 0x8).setu(r2);
      MEMORY.ref(4, r7 + 0x10).setu(r5);
      r0 = r4;
      MEMORY.ref(4, r4).setu(r3);
      r1 = r1 - 0xe0;
      r3 = 0x40000d4;
      r2 = 0x85000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      MEMORY.ref(4, r4).setu(r5);
      r0 = r4;
      r1 = 0x6005100;
      r2 = 0x85000008;
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r3 = r3 - 0xc;
      r2 = 0x400000a;
      r3 = 0xc04;
      r1 = 0x4000008;
      MEMORY.ref(2, r2).setu(r3);
      r2 = 0x2;
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r3 = r3 | r2;
      MEMORY.ref(2, r1).setu(r3);
      r3 = 0x2;
      MEMORY.ref(4, r7 + 0x8).setu(r3);
      r2 = 0x6006000;
      r6 = 0x0;

      //LAB_80c036a
      do {
        r1 = 0xf080;
        if((r6 & 0xffff_ffffL) > (0x14 & 0xffff_ffffL)) {
          r1 = 0xf088;
        }

        //LAB_80c0372
        r3 = 0x0;

        //LAB_80c03b8
        do {
          r3 = r3 + 0x1;
          MEMORY.ref(2, r2).setu(r1);
          r2 = r2 + 0x2;
          CPU.cmpT(r3, 0x1f);
        } while((r3 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL));

        r6 = r6 + 0x1;
      } while((r6 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL));

      r6 = 0x3001ad0;
      r3 = 0x0;
      r5 = 0x20;
      CPU.r9().value = r3;
      r3 = 0x8;
      MEMORY.ref(2, r6 + 0x2).setu(r5);
      MEMORY.ref(2, r6 + 0x6).setu(r5);
      MEMORY.ref(2, r6 + 0x4).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r1 = 0xf0;
      r3 = 0x4000040;
      r2 = 0x88;
      MEMORY.ref(2, r3).setu(r1);
      r3 = r3 + 0x4;
      MEMORY.ref(2, r3).setu(r2);
      r3 = r3 - 0x2;
      MEMORY.ref(2, r3).setu(r1);
      r3 = r3 + 0x4;
      MEMORY.ref(2, r3).setu(r2);
      r2 = 0x4000048;
      r3 = 0x3537;
      MEMORY.ref(2, r2).setu(r3);
      r3 = 0x3f21;
      r2 = r2 + 0x2;
      r0 = 0x80;
      MEMORY.ref(2, r2).setu(r3);
      r0 = r0 << 19;
      r1 = 0x7741;
      FUN_800387c(r0, r1);
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x0;
      r3 = 0xb4;
      FUN_80c0cec(r0, r1, r2, r3);
      r2 = CPU.r11().value;
      r1 = CPU.r9().value;
      MEMORY.ref(4, r2).setu(r1);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c01bc"), 0xc80);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0228"), 0x480);
      setInterruptHandler(2, 32, getRunnable(GoldenSun_80c.class, "FUN_80c0298"));
      MEMORY.ref(2, r6 + 0x2).setu(r5);
      r0 = 0x1;
      sleep(r0);
      r3 = 0x3001e74;
      r3 = MEMORY.ref(4, r3).get();
      r3 = r3 + 0x41;
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r5 = 0x4000008;
      FUN_8015128(r0);
      r0 = 0x14;
      sleep(r0);
      r0 = r5;
      r1 = 0x2;
      FUN_80039fc(r0, r1);
      r1 = 0x0;
      r0 = r5;
      FUN_800393c(r0, r1);
      r0 = MEMORY.ref(4, CPU.sp().value).get();
      FUN_80b595c(r0);
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c01bc"));
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0228"));
      MEMORY.ref(2, r6 + 0x2).setu(CPU.r9().value);
      setInterruptHandler(2, 0, null);
    } else {
      //LAB_80c04c8
      r3 = r6;
      r3 = r3 - 0x8c;
      r3 = MEMORY.ref(4, r3).get();
      CPU.r10().value = r3;
      r3 = 0x1;
      MEMORY.ref(4, r7 + 0xc).setu(r3);
      r3 = 0x0;
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r1 = CPU.sp().value + 0x20;
      r0 = 0x3;
      r0 = FUN_80b6c08(r0, r1);
      r6 = 0x0;
      CPU.r8().value = r0;
      if(r0 != 0) {
        //LAB_80c04e8
        do {
          r5 = r6 + 0x78;
          if(r6 <= 0x7) {
            r5 = r6;
          }

          //LAB_80c04f2
          r7 = FUN_80b7dd0(r5);
          r3 = getCharOrMonsterData_(r5)._128.get();
          if(r3 != 0x94) {
            r3 = 0xb333;
            MEMORY.ref(4, r7 + 0x18).setu(r3);
          }

          //LAB_80c0510
          r6 = r6 + 0x1;
        } while(r6 != CPU.r8().value);
      }

      //LAB_80c0516
      r1 = 0x2002090;
      r0 = 0x4000208;
      r3 = MEMORY.ref(2, r0).getUnsigned();
      r4 = r3;
      MEMORY.ref(2, r0).setu(r0);
      r2 = MEMORY.ref(2, r1).getUnsigned();
      if(r2 < 32) {
        r3 = r2 << 1;
        r3 = r3 + r2;
        r3 = r3 << 2;
        r2 = r2 + 0x1;
        r3 = r3 + r1;
        MEMORY.ref(2, r1).setu(r2);
        r2 = 0x6041;
        r3 = r3 + 0x4;
        MEMORY.ref(4, r3).setu(r2);
        r3 += 0x4;
        r2 = 0x80;
        r2 = r2 << 19;
        MEMORY.ref(4, r3).setu(r2);
        r3 += 0x4;
        r2 = 0x80;
        r2 = r2 << 10;
        MEMORY.ref(4, r3).setu(r2);
      }

      //LAB_80c0544
      MEMORY.ref(2, r0).setu(r4);
      r0 = 0x1;
      sleep(r0);
      r3 = 0xc9;
      r2 = 0x21;
      r3 = r3 << 3;
      r6 = CPU.sp().value + 0x60;
      r3 = r3 + CPU.r10().value;
      r1 = 0x0;
      CPU.r8().value = r1;
      MEMORY.ref(2, r3).setu(r2);
      r1 = r6;
      r0 = 0x2;
      r5 = CPU.sp().value + 0x3c;
      r0 = FUN_80b6c08(r0, r1);
      r2 = 0xff;
      MEMORY.ref(4, r5 + 0x14).setu(r0);
      CPU.r10().value = r2;
      r0 = r0 << 1;
      r3 = CPU.r10().value;
      r0 = r0 + 0x24;
      MEMORY.ref(2, r5 + r0).setu(r3);
      r1 = 0x0;
      r0 = r6;
      FUN_80b7b6c(r0, r1);
      r0 = r5;
      FUN_80c9028(r0);
      r3 = 0x64;
      r0 = 0x0;
      r1 = 0x0;
      r2 = 0x0;
      FUN_80c0cec(r0, r1, r2, r3);
      r1 = CPU.r8().value;
      r2 = CPU.r11().value;
      MEMORY.ref(4, r2).setu(r1);
      setInterruptHandler(2, 32, getRunnable(GoldenSun_80c.class, "FUN_80c0298"));
      sleep(1);
      sleep(20);
      r3 = 0x3001e74;
      r3 = MEMORY.ref(4, r3).get();
      r5 = 0x4000008;
      r3 = r3 + 0x41;
      r0 = MEMORY.ref(1, r3).getUnsigned();
      FUN_8015128(r0);
      r0 = r5;
      r1 = 0x2;
      FUN_80039fc(r0, r1);
      r0 = r5;
      r1 = 0x0;
      FUN_800393c(r0, r1);
      r2 = 0x4000050;
      r3 = 0x3f40;
      MEMORY.ref(2, r2).setu(r3);
      r3 = CPU.sp().value + 0x4;
      CPU.r8().value = r3;
      r1 = CPU.r8().value;
      r0 = 0x3;
      r0 = FUN_80b6c08(r0, r1);
      r7 = r0;
      r3 = r7 << 1;
      r2 = CPU.r10().value;
      r1 = CPU.r8().value;
      MEMORY.ref(2, r1 + r3).setu(r2);
      r0 = CPU.r8().value;
      r1 = 0x0;
      FUN_80b7b6c(r0, r1);
      r0 = 0x1;
      r1 = CPU.r8().value;
      r0 = FUN_80b6c08(r0, r1);
      r7 = r0;
      r6 = 0x0;
      if(r7 != 0) {
        r5 = CPU.r8().value;

        //LAB_80c0630
        do {
          r0 = MEMORY.ref(2, r5).getUnsigned();
          r1 = 0x1;
          r6 = r6 + 0x1;
          r5 = r5 + 0x2;
          FUN_80c0f98(r0, r1);
        } while(r6 != r7);
      }

      //LAB_80c0640
      r3 = 0x4000052;
      r5 = 0x1000;
      r6 = 0x0;
      CPU.r10().value = r3;

      //LAB_80c0648
      do {
        r3 = r6;
        r3 = r3 | r5;
        r1 = CPU.r10().value;
        MEMORY.ref(2, r1).setu(r3);
        r0 = 0x1;
        r6 = r6 + 0x1;
        sleep(r0);
      } while(r6 != 0x10);

      r6 = 0x0;
      if(r7 != 0) {
        r5 = CPU.r8().value;

        //LAB_80c0670
        do {
          r0 = MEMORY.ref(2, r5).getUnsigned();
          r1 = 0x0;
          r6 = r6 + 0x1;
          r5 = r5 + 0x2;
          FUN_80c0f98(r0, r1);
        } while(r6 != r7);
      }

      //LAB_80c0680
      r0 = MEMORY.ref(4, CPU.sp().value).get();
      FUN_80b595c(r0);
      r2 = 0x3001ad0;
      MEMORY.ref(2, r2 + 0x2).setu(0);
      sleep(1);
      setInterruptHandler(2, 0, null);
    }

    //LAB_80c069c
    setInterruptHandler(2, 0, null);
    GPU.BG1CNT.setu(0x1f83);
    sleep(1);
    GPU.BG1CNT.setu(0x1f83);
    GPU.BG0CNT.and(~0x2);
    r2 = 0x3001ad0;
    MEMORY.ref(2, r2 + 0x4).setu(8);
    GPU.DISPCNT.setu(0x1541);
    freeSlot(42);
    CPU.sp().value += 0x94;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80c08a8)
  public static void FUN_80c08a8() {
    CPU.sp().value -= 0x4;
    final int r1 = mallocSlotBoard(10, 0x2a0);
    final int r0 = CPU.sp().value;
    final int r5 = MEMORY.ref(4, 0x3001f00).get();
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(0x850000a8);
    MEMORY.ref(4, r5 + 0x8).setu(0);
    CPU.sp().value += 0x4;
  }

  @Method(0x80c08e0)
  public static void FUN_80c08e0() {
    freeSlot(10);
  }

  @Method(0x80c08ec)
  public static void FUN_80c08ec(final int r0, final int r1, final int r2) {
    final int r10 = boardWramMallocHead_3001e50.offset(44 * 0x4).get();
    final int r8 = getPointerTableEntry(r1);
    final int r6 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();

    final int addr = mallocSlotChip(49, 0x230);
    DMA.channels[3].SAD.setu(0x80b5138);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x8400008c);
    MEMORY.setFunction(addr, GoldenSun_80b.class, "FUN_80b5138", int.class, int.class);

    final int r3 = boardWramMallocHead_3001e50.offset(49 * 0x4).get();
    MEMORY.call(r3, r8 + 0x100, 0x6008000);
    freeSlot(49);

    DMA.channels[3].SAD.setu(r8);
    DMA.channels[3].DAD.setu(r6 + 0x544);
    DMA.channels[3].CNT.setu(0x84000040);

    if(r2 >= 0) {
      MEMORY.ref(4, r6 + 0x644).setu(0x10000 - r2 * 0x444);
      FUN_80c1724(r6 + 0x544, 0x50000c0, 0x10000 - r2 * 0x444, 0x80);
    }

    //LAB_80c0974
    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(0x50000a0);
    DMA.channels[3].CNT.setu(0x80000010);
    MEMORY.ref(2, 0x50000bc).setu(MEMORY.ref(2, 0x50001e8).getUnsigned());
    FUN_80c0098(0x6003800);
    FUN_80c00d8(0x600f800);
    MEMORY.call(0x3000164, 0x600ffc0, 0x40); // memzero

    if(MEMORY.ref(4, r10 + 0x8).get() == 0) {
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c0130"), 0x4ff);
    }

    //LAB_80c09ae
    MEMORY.ref(4, r10 + 0x8).setu(r0);

    if(r0 == 1) {
      GPU.BG1CNT.setu(0x1f83);
    }

    //LAB_80c09be
  }

  @Method(0x80c0a24)
  public static void FUN_80c0a24(int r0, int r1, int r2, int r3, final int a4) {
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r3 = 0x3001f00;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    r2 = r3;
    r2 = r2 - 0x88;
    r2 = MEMORY.ref(4, r2).get();
    CPU.r10().value = r0;
    r0 = 0x80;
    r1 = MEMORY.ref(4, r3).get();
    r0 = r0 << 4;
    CPU.r9().value = r2;
    r3 = r3 - 0x80;
    r2 = 0x0;
    r3 = MEMORY.ref(4, r3).get();
    CPU.r11().value = r0;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r2 = 0x80;
    r2 = r2 << 9;
    if(a4 >= r2) {
      r0 = 0x80;
      r0 = r0 << 6;
      MEMORY.ref(4, CPU.sp().value).setu(r0);
      r0 = 0x36;
      r2 = MEMORY.ref(2, r3 + r0).get();
      r2 = -r2;
      r3 = r2 << 1;
      r3 = r3 + r2;
      r2 = 0xd0;
      r2 = r2 << 7;
      r2 = r2 + r3;
      CPU.r11().value = r2;
    }

    //LAB_80c0a78
    r3 = CPU.r9().value;
    if(r3 != 0) {
      //LAB_80c0a80
      r0 = MEMORY.ref(4, r1 + 0x8).get();
      if(r0 == 0x1 || MEMORY.ref(4, r1 + 0xc).get() == 0x1) {
        //LAB_80c0a8c
        r3 = MEMORY.ref(4, r1 + 0x10).get();
        if(r3 == 0) {
          r2 = 0x3001ad0;
          r1 = CPU.r11().value;
          r3 = r1 >> 8;
          MEMORY.ref(2, r2 + 0x4).setu(r3);
        }
      }

      //LAB_80c0a9a
      if(r0 == 0x2) {
        //LAB_80c0aa0
        r3 = CPU.r9().value;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0x1;
        r2 = r2 ^ r3;
        r3 = r2 << 2;
        r3 = r3 + r2;
        r3 = r3 << 6;
        r1 = 0x80;
        r3 = r3 + CPU.r9().value;
        r1 = r1 << 9;
        r7 = r3;
        r0 = (int)MEMORY.call(0x300013c, a4, r1);
        r6 = CPU.r9().value;
        r6 = r6 + 0x10;
        r5 = r0 >> 8;
        r3 = 0x0;
        MEMORY.ref(2, r6).setu(r5);
        MEMORY.ref(2, r6 + 0x2).setu(r3);
        MEMORY.ref(2, r6 + 0x4).setu(r3);
        MEMORY.ref(2, r6 + 0x6).setu(r5);
        CPU.lr().value = r0;
        r0 = 0xffff0000;
        r3 = a4 + r0;
        CPU.r8().value = r3;
        r7 = r7 + 0x20;
        r0 = CPU.r10().value;
        r1 = CPU.r8().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r1 = r0;
        r0 = CPU.lr().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = r0;
        r1 = CPU.r8().value;
        r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r0 = r0 << 0;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r1 = r0;
        r0 = CPU.lr().value;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = 0x7fff;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = r3 + r2;
        r3 = r3 >> 8;
        r3 = r3 + r1;
        r3 = r3 + CPU.r11().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        r0 = r0 + r2;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = 0xfffff000;
        r0 = r0 >> 8;
        r0 = r0 + r2;
        r5 = r5 << 16;
        r1 = 0x80;
        r0 = r0 + r3;
        r5 = r5 >> 16;
        r1 = r1 << 7;
        MEMORY.ref(4, r6 + 0xc).setu(r0);
        r1 = r1 - r0;
        r2 = 0x300013c;
        r0 = r5;
        r0 = (int)MEMORY.call(r2, r0, r1);
        r0 = r0 >> 16;
        r6 = r0 + 0x1;
        r0 = 0x16b;
        r5 = 0x0;
        r0 = readFlag_(r0);
        if(r0 == 0) {
          r3 = 0x3f8e;

          //LAB_80c0b40
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r3);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL));
        }

        //LAB_80c0b4a
        if((r6 & 0xffff_ffffL) > (0x88 & 0xffff_ffffL)) {
          r6 = 0x88;
        }

        //LAB_80c0b50
        if((r5 & 0xffff_ffffL) < (r6 & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value).get();
          r2 = r3 << 16;
          r3 = 0x478a;
          r2 = r2 >>> 16;
          r2 = r2 | r3;

          //LAB_80c0b5e
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r2);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) < (r6 & 0xffff_ffffL));
        }

        //LAB_80c0b94
        if((r5 & 0xffff_ffffL) <= (0x87 & 0xffff_ffffL)) {
          r0 = MEMORY.ref(4, CPU.sp().value).get();
          r3 = 0x478e;
          r2 = r0 << 16;
          r2 = r2 >>> 16;
          r2 = r2 | r3;

          //LAB_80c0ba2
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r2);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0x87 & 0xffff_ffffL));
        }

        //LAB_80c0bac
        if((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL)) {
          r3 = 0x3f8e;

          //LAB_80c0bb2
          do {
            r5 = r5 + 0x1;
            MEMORY.ref(2, r7).setu(r3);
            r7 = r7 + 0x2;
          } while((r5 & 0xffff_ffffL) <= (0x9f & 0xffff_ffffL));
        }

        //LAB_80c0bc8
        r1 = CPU.r9().value;
        r3 = MEMORY.ref(4, r1).get();
        r2 = 0x1;
        r3 = r3 ^ r2;
        MEMORY.ref(4, r1).setu(r3);
      }
    }

    //LAB_80c0bd2
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80c0cec)
  public static void FUN_80c0cec(final int r0, final int r1, int r2, int r3) {
    final int r8 = boardWramMallocHead_3001e50.offset(12 * 0x4).get();
    r3 = r3 << 16;
    CPU.sp().value -= 0x28;
    final int r10 = r8 + 0xc;
    final int r7 = divideS(r3, 100);
    MEMORY.ref(4, r10).setu(r0);
    MEMORY.ref(4, r10 + 0x4).setu(r1);
    MEMORY.ref(4, r10 + 0x8).setu(r2);
    final Vec3 r9 = new Vec3();
    r9.zero();
    FUN_8005258(0x1fe0000, (int)MEMORY.call(0x300013c, 0x1fe0000, 0xc000), 0x3fc0000);
    FUN_80049ac();
    FUN_8004cb4(r10);
    FUN_8004c1c(MEMORY.ref(2, r8 + 0x36).get());
    FUN_8004bd4(MEMORY.ref(2, r8 + 0x34).get());
    MEMORY.call(0x3000250, new Vec3().set(0, 0, 0x1fe0000), r8);
    r3 = 0x3001ce0;
    MEMORY.ref(4, r3 + 0xc).setu(120);
    MEMORY.ref(4, r3 + 0x10).setu(120);
    FUN_80049ac();
    FUN_80051d8(r8, r10);
    int r6 = CPU.sp().value + 0x10;
    FUN_8005268(r9, r6);
    r2 = 120 - MEMORY.ref(4, r6).get() << 8;
    r3 = 120 - MEMORY.ref(4, r6 + 0x4).get() << 8;
    r6 = r7 * 0x1fe;
    FUN_80c0a24(0x780000, 0x780000, r2, r3, r7);
    FUN_8005258(r6, (int)MEMORY.call(0x300013c, r6, 0xc000), r7 * 0x3fc);
    CPU.sp().value += 0x28;
  }

  @Method(0x80c0f98)
  public static void FUN_80c0f98(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    r5 = r1;
    r0 = FUN_80b7dd0(r0);
    if(r0 != 0) {
      r0 = MEMORY.ref(4, r0).get();
      if(r0 != 0) {
        r3 = r0 + 0x54;
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r2 = r3 & 0xf;
        if(r2 == 0x1) {
          //LAB_80c0fbe
          r4 = MEMORY.ref(4, r0 + 0x50).get();
          r2 = 0xd;
          r3 = 0x3;
          r1 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
          r2 = -r2;
          r5 = r5 & r3;
          r3 = r2;
          r0 = r5 << 2;
          r3 = r3 & r1;
          r3 = r3 | r0;
          MEMORY.ref(1, r4 + 0x5).setu(r3);
          r3 = MEMORY.ref(1, r4 + 0x11).getUnsigned();
          r2 = r2 & r3;
          r2 = r2 | r0;
          MEMORY.ref(1, r4 + 0x11).setu(r2);
        } else {
          if(r2 == 0x2) {
            //LAB_80c0fde
            r3 = 0x3;
            r5 = r5 & r3;
            r1 = MEMORY.ref(4, r0 + 0x50).get();
            r0 = r5 << 2;
            r5 = 0xd;
            r6 = 0x0;
            r5 = -r5;

            //LAB_80c0fec
            do {
              r4 = MEMORY.ref(4, r1).get();
              r1 += 0x4;
              if(r4 == 0) {
                break;
              }
              r2 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
              r3 = r5;
              r3 = r3 & r2;
              r3 = r3 | r0;
              r2 = MEMORY.ref(1, r4 + 0x11).getUnsigned();
              MEMORY.ref(1, r4 + 0x5).setu(r3);
              r3 = r5;
              r3 = r3 & r2;
              r3 = r3 | r0;
              r6 = r6 + 0x1;
              MEMORY.ref(1, r4 + 0x11).setu(r3);
            } while(r6 < 4);
          }
        }
      }
    }

    //FUN_80c100c
  }

  @Method(0x80c1054)
  public static void FUN_80c1054() {
    CPU.sp().value -= 0x1c;
    int r5 = CPU.sp().value;
    final int r0 = FUN_80b6c08(3, r5);
    if(r0 > 0) {
      final int r7 = r5;
      int r6 = 0x0;
      r5 = r0;

      //LAB_80c106c
      do {
        FUN_80c0f98(MEMORY.ref(2, r6 + r7).get(), 0);
        r6 = r6 + 0x2;
        r5 = r5 - 0x1;
      } while(r5 != 0);
    }

    //LAB_80c107c
    CPU.sp().value += 0x1c;
  }

  @Method(0x80c1084)
  public static void FUN_80c1084() {
    int r0;
    int r1;
    int r2;
    int r3;

    r3 = 0x3001e74;
    r0 = MEMORY.ref(4, r3).get();
    if(r0 != 0) {
      if(MEMORY.ref(2, r0 + 0x650).getUnsigned() != 0) {
        GPU.BLDCNT.setu(0x3f90);
        GPU.BLDALPHA.setu(0x10);
        r0 = r0 + 0x64e;
        r2 = 0x80c5c10;
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r3 = MEMORY.ref(1, r2 + r3).get();
        GPU.BLDY.setu(r3);
        r2 = MEMORY.ref(2, r0).getUnsigned();
        r1 = r2 + 0x1;
        r1 = r1 & 0xf;
        if((r2 & 0xffff_ffffL) > (0xe & 0xffff_ffffL)) {
          r1 = r1 | 0x10;
        }

        //LAB_80c10c4
        MEMORY.ref(2, r0).setu(r1);
      }
    }
  }

  @Method(0x80c10e8)
  public static void FUN_80c10e8(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001e74;
    CPU.sp().value -= 0x1c;
    CPU.r8().value = r0;
    CPU.r10().value = r1;
    r5 = MEMORY.ref(4, r3).get();
    if(r1 == 0) {
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1084"));
      GPU.BLDY.setu(CPU.r10().value);
      FUN_80c1054();
      sleep(1);
      r0 = 0x4000050;
      r1 = 0x0;
      FUN_800387c(r0, r1);
    }

    //LAB_80c1122
    if(r5 != 0) {
      r2 = CPU.r10().value;
      if(r2 != 0) {
        MEMORY.ref(2, r5 + 0x650).setu(CPU.r10().value);
        MEMORY.ref(2, r5 + 0x64e).setu(0);
        GPU.BLDY.setu(0);
        GPU.BLDALPHA.setu(0x10);
        r5 = CPU.sp().value;
        r1 = r5;
        r0 = 0x3;
        r0 = FUN_80b6c08(r0, r1);
        r6 = 0x0;
        r7 = r0;
        if((r6 & 0xffff_ffffL) < (r7 & 0xffff_ffffL)) {
          r2 = 0x1;
          CPU.r11().value = r5;
          CPU.r9().value = r2;
          r5 = 0x0;

          //LAB_80c1162
          do {
            r3 = CPU.r11().value;
            r0 = MEMORY.ref(2, r5 + r3).get();
            r2 = CPU.r9().value;
            r1 = CPU.r10().value;
            r1 = r1 & r2;
            r6 = r6 + 0x1;
            FUN_80c0f98(r0, r1);
            r5 = r5 + 0x2;
          } while((r6 & 0xffff_ffffL) < (r7 & 0xffff_ffffL));
        }

        //LAB_80c1178
        r3 = CPU.r8().value;
        if(r3 != 0) {
          r0 = MEMORY.ref(2, r3).getUnsigned();
          r1 = 0x2;
          r6 = 0x0;
          CPU.r8().value = CPU.r8().value + r1;
          if(r0 != 0xff) {
            r7 = 0x1;
            r5 = r7;
            r2 = CPU.r10().value;
            r5 = r5 & r2;

            //LAB_80c1192
            do {
              r1 = r5;
              r1 = r1 ^ r7;
              r6 = r6 + 0x1;
              FUN_80c0f98(r0, r1);
              if((r6 & 0xffff_ffffL) > (0xd & 0xffff_ffffL)) {
                break;
              }
              r3 = CPU.r8().value;
              r0 = MEMORY.ref(2, r3).getUnsigned();
              r1 = 0x2;
              CPU.r8().value = CPU.r8().value + r1;
            } while(r0 != 0xff);
          }
        }

        //LAB_80c11ac
        r0 = 0x1;
        sleep(r0);
        r0 = 0x4000050;
        r1 = 0x0;
        FUN_800387c(r0, r1);
        setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80c1084"), 0x480);
      }
    }

    //LAB_80c11c4
    CPU.sp().value += 0x1c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80c1724)
  public static int FUN_80c1724(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);
    r7 = r0;
    r0 = r2;
    r2 = 0x80;
    r2 = r2 << 9;
    r6 = r1;
    if(r0 > r2) {
      r0 = r2;
    }

    //LAB_80c173a
    if(r3 > 0) {
      r1 = 0x1f;
      CPU.r8().value = r1;
      r2 = 0xf8;
      r1 = 0xf8;
      r2 = r2 << 2;
      r1 = r1 << 7;
      CPU.lr().value = r2;
      CPU.r12().value = r1;
      r5 = r3;

      //LAB_80c1750
      do {
        r4 = MEMORY.ref(2, r7).getUnsigned();
        r2 = CPU.r8().value;
        r3 = r4;
        r3 = r3 & r2;
        r1 = CPU.lr().value;
        r2 = r4;
        r2 = r2 & r1;
        r3 = r3 * r0;
        r1 = CPU.r12().value;
        r2 = r2 * r0;
        r1 = r1 & r4;
        r1 = r1 * r0;
        r4 = r3 >>> 16;
        r3 = CPU.r8().value;
        r4 = r4 & r3;
        r2 = r2 >>> 16;
        r3 = CPU.lr().value;
        r2 = r2 & r3;
        r4 = r4 | r2;
        r1 = r1 >>> 16;
        r2 = CPU.r12().value;
        r1 = r1 & r2;
        r4 = r4 | r1;
        r5 = r5 - 0x1;
        MEMORY.ref(2, r6).setu(r4);
        r7 = r7 + 0x2;
        r6 = r6 + 0x2;
      } while(r5 != 0);
    }

    //LAB_80c178a
    CPU.r8().value = CPU.pop();
    return 0;
  }

  @Method(0x80c1a34)
  public static int FUN_80c1a34(final int r0) {
    final int r10 = 0x80c5c38 + r0 * 0x10;
    int r9 = 0;
    int r11 = 0;

    //LAB_80c1a5e
    int r7;
    for(r7 = 0; r7 < 5 && MEMORY.ref(1, r10 + 0x6 + r7).getUnsigned() == 0; r7++) {
      //
    }

    //LAB_80c1a6c
    if(r7 == 5) {
      return -1;
    }

    //LAB_80c1a76
    //LAB_80c1a7e
    for(int i = 0; i < 5; i++) {
      if(MEMORY.ref(1, r10 + 0xb + i).getUnsigned() != 0) {
        final int r6 = MEMORY.ref(1, r10 + 0x1 + i).getUnsigned();
        final int r5 = FUN_8077198(r6 + 0x8);
        if(r5 != 0) {
          if(MEMORY.ref(1, r5 + 0xf).getUnsigned() > 3 && readFlag_(0x174) == 0 && readFlag_(0x608 + r6) == 0) {
            //LAB_80c1ad8
            return -2;
          }

          //LAB_80c1abe
          r11 += MEMORY.ref(1, r5 + 0xf).getUnsigned();
          r9++;
        }
      }

      //LAB_80c1ac6
    }

    if(r9 == 0) {
      return -3;
    }

    //LAB_80c1ade
    //LAB_80c1ae6
    return divideS(r11, r9);
  }

  @Method(0x80c1afc)
  public static int FUN_80c1afc(int r0) {
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
    r2 = 0x0;
    CPU.r11().value = r0;
    r0 = 0x80;
    CPU.sp().value -= 0x10;
    CPU.r9().value = r2;
    r0 = mallocBoard(r0);
    r5 = CPU.sp().value;
    r3 = 0x0;
    CPU.r10().value = r0;
    r0 = r5;
    CPU.r8().value = r3;
    r0 = FUN_80b6a60(r0);
    r7 = r0;
    if(r7 > 0) {
      r6 = r5;
      r5 = r7;

      //LAB_80c1b30
      do {
        r3 = getCharOrMonsterData_(MEMORY.ref(2, r6).getUnsigned()).level_0f.get();
        r5 = r5 - 0x1;
        r6 = r6 + 0x2;
        CPU.r8().value = CPU.r8().value + r3;
      } while(r5 != 0);
    }

    //LAB_80c1b42
    r1 = r7;
    r0 = CPU.r8().value;
    r0 = divideS(r0, r1);
    CPU.r8().value = r0;
    r0 = 0xfe;
    r0 = r0 << 2;
    r0 = FUN_80770e0(r0);
    r0 = r0 << 24;
    r0 = r0 >> 24;
    CPU.r8().value = CPU.r8().value + r0;
    r7 = CPU.r8().value;
    if(r7 <= 0) {
      r2 = 0x1;
      CPU.r8().value = r2;
    }

    //LAB_80c1b64
    r3 = CPU.r8().value;
    if(r3 > 0x63) {
      r7 = 0x63;
      CPU.r8().value = r7;
    }

    //LAB_80c1b6e
    r1 = 0xffff;
    r2 = CPU.r10().value;
    r5 = 0x1f;

    //LAB_80c1b74
    do {
      r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
      r5 = r5 - 0x1;
      r3 = r3 | r1;
      MEMORY.ref(2, r2 + 0x2).setu(r3);
      r2 = r2 + 0x4;
    } while(r5 >= 0);

    r7 = 0x80c73f8;
    r5 = 0x0;
    r6 = 0x0;

    //LAB_80c1b94
    do {
      r0 = MEMORY.ref(2, r6 + r7).getUnsigned();
      r0 = FUN_8077198(r0);
      r0 = MEMORY.ref(2, r6 + r7).getUnsigned();
      r2 = 0xc0;
      r2 = r2 << 3;
      r0 = r0 + r2;
      r5 = r5 + 0x1;
      clearFlag_(r0);
      r6 = r6 + 0x2;
    } while((r5 & 0xffff_ffffL) <= (0x13 & 0xffff_ffffL));

    r5 = 0x0;

    //LAB_80c1bb0
    do {
      r0 = r5;
      r0 = FUN_80c1a34(r0);
      if(r0 >= 0) {
        r3 = CPU.r8().value;
        r3 = r3 + 0x3;
        if(r0 <= r3) {
          r6 = 0x1;
          r3 = 0x3e7;
          r6 = -r6;
          r4 = 0x0;
          r1 = CPU.r10().value;

          //LAB_80c1bcc
          do {
            r7 = 0x2;
            r2 = MEMORY.ref(2, r1 + r7).get();
            if(r2 < r3) {
              r3 = r2;
              r6 = r4;
            }

            //LAB_80c1bd8
            r4 = r4 + 0x1;
            r1 = r1 + 0x4;
          } while(r4 <= 0x1f);

          if(r6 >= 0) {
            r3 = r6 << 2;
            r3 = r3 + CPU.r10().value;
            r2 = 0x1;
            MEMORY.ref(2, r3 + 0x2).setu(r0);
            MEMORY.ref(2, r3).setu(r5);
            CPU.r9().value = CPU.r9().value + r2;
          }
        }
      }

      //LAB_80c1bf0
      r3 = 0x17b;
      r5 = r5 + 0x1;
    } while((r5 & 0xffff_ffffL) <= (r3 & 0xffff_ffffL));

    r7 = CPU.r9().value;
    if(r7 > 0x20) {
      r2 = 0x20;
      CPU.r9().value = r2;
    }

    //LAB_80c1c02
    r3 = CPU.r9().value;
    if(r3 != 0) {
      r0 = rand();
      r3 = CPU.r9().value;
      r3 = r3 * r0;
      r3 = r3 >>> 16;
      r3 = r3 << 2;
      r3 = r3 + CPU.r10().value;
      r7 = 0x0;
      r5 = MEMORY.ref(2, r3 + r7).get();
      r2 = 0x2;
      r3 = MEMORY.ref(2, r3 + r2).get();
      r7 = CPU.r8().value;
      r3 = r7 - r3;
      r2 = CPU.r11().value;
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_80c1c28
      r3 = CPU.r9().value;
      r7 = CPU.r11().value;
      MEMORY.ref(4, r7).setu(r3);
      r5 = 0x1;
    }

    //LAB_80c1c30
    r0 = CPU.r10().value;
    setMallocAddress(r0);
    r0 = r5;
    CPU.sp().value += 0x10;
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

  @Method(0x80c1c54)
  public static int FUN_80c1c54(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0xc;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
    CPU.r10().value = r1;
    CPU.r9().value = mallocBoard(0x24);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    final Unit14c r7 = getCharOrMonsterData_(r0);
    MEMORY.call(0x3001388, CPU.r9().value, r7.baseMaxHp_10.getAddress(), 0x24); // memcpy
    r1 = CPU.r10().value;
    r3 = r1 << 1;
    r3 = r3 + CPU.r10().value;
    r5 = r7.baseMaxHp_10.get();
    r0 = r3 << 5;
    r1 = 0xa;
    r0 = r0 + CPU.r10().value;
    CPU.r11().value = r3;
    r0 = divideS(r0, r1);
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r2 = 0x0;
    r3 = MEMORY.ref(2, r0 + r2).get();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1cb6
    r1 = 0x270f;
    CPU.r8().value = r1;
    if(r5 > CPU.r8().value) {
      r5 = CPU.r8().value;
    }

    //LAB_80c1cc0
    r3 = CPU.r10().value;
    r3 = r3 << 4;
    r7.baseMaxHp_10.set(r5);
    r1 = CPU.r10().value;
    r0 = r3 - r1;
    r1 = 0xa;
    r5 = r7.baseMaxPp_12.get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = divideS(r0, r1);
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r2 = 0x2;
    r3 = MEMORY.ref(2, r0 + r2).get();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1cee
    if(r5 > CPU.r8().value) {
      r5 = CPU.r8().value;
    }

    //LAB_80c1cf4
    r1 = CPU.r10().value;
    r1 = r1 << 5;
    r2 = CPU.r10().value;
    r0 = r1 - r2;
    r0 = r0 << 2;
    r7.baseMaxPp_12.set(r5);
    CPU.r8().value = r1;
    r0 = r0 - r2;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    r5 = r7.baseAttack_18.get();
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r3 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d22
    r6 = 0x3e7;
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d2a
    r0 = CPU.r8().value;
    r7.baseAttack_18.set(r5);
    r1 = 0xa;
    r0 = r0 + CPU.r10().value;
    r0 = divideS(r0, r1);
    r1 = CPU.r9().value;
    r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
    r5 = r7.baseDefence_1a.get();
    r5 = r5 + r0;
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d4e
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d54
    r2 = CPU.r11().value;
    r0 = r2 << 4;
    r7.baseDefence_1a.set(r5);
    r1 = 0xa;
    r0 = r0 + CPU.r11().value;
    r0 = divideS(r0, r1);
    r5 = r7.baseAgility_1c.get();
    r5 = r5 + r0;
    r0 = CPU.r9().value;
    r3 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
    r0 = r3 << 3;
    r0 = r0 - r3;
    r1 = 0xa;
    r0 = divideS(r0, r1);
    if(r5 < r0) {
      r5 = r0;
    }

    //LAB_80c1d7a
    if(r5 > r6) {
      r5 = r6;
    }

    //LAB_80c1d80
    r1 = 0x14;
    r7.baseAgility_1c.set(r5);
    CPU.r8().value = r1;

    //LAB_80c1d8a
    for(r4 = 0; r4 < 4; r4++) {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r2 = r7.powerResist_24.get(r4).power_00.get();
      r1 = CPU.r10().value;
      r3 = r0 - r1;
      r5 = r2 + r3;
      r1 = CPU.r9().value;
      r2 = CPU.r8().value;
      r3 = MEMORY.ref(2, r2 + r1).get();
      r0 = r3 << 3;
      r0 = r0 - r3;
      r0 = divideS(r0, 10);
      if(r5 < r0) {
        r5 = r0;
      }

      //LAB_80c1dae
      if(r5 > 200) {
        r5 = 200;
      }

      //LAB_80c1db4
      r7.powerResist_24.get(r4).power_00.set(r5);
      CPU.r8().value += 0x4;
    }

    r7.level_0f.add(CPU.r10().value);
    recalcStats_(MEMORY.ref(4, CPU.sp().value + 0x8).get());
    r0 = CPU.r9().value;
    setMallocAddress(r0);
    CPU.sp().value += 0xc;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80c1df4)
  public static int FUN_80c1df4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;
    final int r7;

    r3 = 0x3001e74;
    r5 = MEMORY.ref(4, r3).get();
    r6 = r5;
    r6 = r6 + 0x40;
    r4 = MEMORY.ref(1, r6).getUnsigned();
    r1 = 0x0;
    if(r1 < r4) {
      r3 = MEMORY.ref(2, r5 + 0x10).getUnsigned();
      if(r3 != r0) {
        r2 = r5;
        r2 = r2 + 0x10;

        //LAB_80c1e12
        do {
          r1 = r1 + 0x1;
          if(r1 >= r4) {
            break;
          }
          r2 = r2 + 0x2;
          r3 = MEMORY.ref(2, r2).getUnsigned();
        } while(r3 != r0);
      }
    }

    //LAB_80c1e20
    if(r1 != r4) {
      r6 = r1;
      r6 = r6 + 0x34;
      r3 = MEMORY.ref(1, r5 + r6).get();
      r4 = 0x0;
      if(r3 < 0) {
        r3 = 0x1;
        MEMORY.ref(1, r5 + r6).setu(r3);
        r3 = r1 << 2;
        r3 = r3 + 0x1c;
        r2 = 0x3;
        MEMORY.ref(4, r5 + r3).setu(r2);
        r0 = 0x8001;
      } else {
        //LAB_80c1e40
        r7 = r1 << 2;

        //LAB_80c1e46
        while(r4 <= 0x1f) {
          r0 = MEMORY.ref(1, r5 + r6).get();
          r1 = 0x9;
          r0 = r0 + 0x1;
          r0 = modS(r0, r1);
          r3 = r7;
          MEMORY.ref(1, r5 + r6).setu(r0);
          r3 = r3 + 0x1c;
          r0 = r0 << 24;
          r0 = r0 >> 24;
          r2 = 0x1;
          r3 = MEMORY.ref(4, r5 + r3).get();
          r2 = r2 << r0;
          r3 = r3 & r2;
          if(r3 == 0) {
            break;
          }

          //LAB_80c1e44
          r4 = r4 + 0x1;
        }

        //LAB_80c1e6e
        r3 = MEMORY.ref(1, r5 + r6).get();
        r1 = r7;
        r1 = r1 + 0x1c;
        r2 = 0x1;
        r2 = r2 << r3;
        r3 = MEMORY.ref(4, r5 + r1).get();
        r3 = r3 | r2;
        MEMORY.ref(4, r5 + r1).setu(r3);
        r0 = MEMORY.ref(1, r5 + r6).get();
      }
    } else {
      //LAB_80c1e82
      if(r4 <= 0x4) {
        r1 = 0x1;
        r2 = r4;
        r1 = -r1;
        r2 = r2 + 0x34;
        r3 = r1;
        MEMORY.ref(1, r5 + r2).setu(r3);
        r3 = r4 << 1;
        r3 = r3 + 0x10;
        MEMORY.ref(2, r5 + r3).setu(r0);
        r3 = r4 << 2;
        r3 = r3 + 0x1c;
        r2 = 0x0;
        MEMORY.ref(4, r5 + r3).setu(r2);
        r3 = r4 + 0x1;
        MEMORY.ref(1, r6).setu(r3);
        r0 = 0x9;
      } else {
        //LAB_80c1ea8
        r0 = 0x1;
        r0 = -r0;
      }
    }

    //LAB_80c1eac
    return r0;
  }

  @Method(0x80c1f50)
  public static void FUN_80c1f50(final int r0) {
    //LAB_80c1f58
    for(int r5 = 0; r5 < 6; r5++) {
      final Unit14c r2 = getCharOrMonsterData_(r5 + 0x80);
      if(r2._12a.get() == 1) {
        if(r2._128.get() == r0) {
          //LAB_80c1f86
          int i = 0;
          do {
            if(r2.name_00.get(i).get() == 0) {
              r2.name_00.get(i).set('1');
              r2.name_00.get(i + 1).set(0);
              return;
            }
            i++;
            if(i > 13) {
              return;
            }
          } while(true);
        }
      }

      //LAB_80c1f9a
    }

    //LAB_80c1fa0
  }

  @Method(0x80c1ffc)
  public static int FUN_80c1ffc(int r0) {
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
    r3 = 0x3001e74;
    CPU.sp().value -= 0x7c;
    r3 = MEMORY.ref(4, r3).get();
    r5 = r0;
    r0 = CPU.sp().value;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    r2 = 0x0;
    r0 = r0 + 0x60;
    r3 = r3 + 0x40;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
    MEMORY.ref(1, r3).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
    r0 = 0x173;
    r0 = readFlag_(r0);
    if(r0 != 0) {
      r0 = CPU.sp().value + 0x20;
      r0 = FUN_80c1afc(r0);
      r5 = r0;
    }

    //LAB_80c2034
    r1 = 0xbe;
    r1 = r1 << 1;
    if((r5 & 0xffff_ffffL) >= (r1 & 0xffff_ffffL)) {
      r5 = 0x1;
    }

    //LAB_80c203e
    r2 = 0x80c5c38;
    r3 = r5 << 4;
    r3 = r3 + r2;
    r4 = r3;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r4 = r4 + 0x2;
    r3 = MEMORY.ref(1, r4 + 0x4).getUnsigned();
    r1 = 0x0;
    if(r3 == 0) {
      r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r2 = r2 + 0x6;

      //LAB_80c2056
      do {
        r1 = r1 + 0x1;
        r2 = r2 + 0x1;
        if(r1 > 0x4) {
          break;
        }
      } while(MEMORY.ref(1, r2).getUnsigned() == 0);
    }

    //LAB_80c2064
    if(r1 == 0x5) {
      r2 = 0x80c5c48;
      r4 = r2;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
      r4 = r4 + 0x2;
    }

    //LAB_80c2070
    r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r0 = r0 + 0x1;
    r5 = 0x0;
    r3 = 0x6;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
    CPU.r11().value = r3;
    r7 = 0x0;
    r5 = r4 + 0x4;

    //LAB_80c2082
    do {
      r3 = MEMORY.ref(1, r5).getUnsigned();
      if(r3 != 0) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r0 = MEMORY.ref(1, r1 + r7).getUnsigned();
        r0 = r0 + 0x8;
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_80c23c0(r0);
        r3 = -r0;
        r3 = r3 | r0;
        r2 = 0x2;
        r3 = r3 >>> 31;
        r3 = r2 - r3;
        r2 = MEMORY.ref(1, r5).getUnsigned();
        r3 = r3 * r2;
        r2 = CPU.r11().value;
        r2 = r2 - r3;
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.r11().value = r2;
      }

      //LAB_80c20aa
      r7 = r7 + 0x1;
      r5 = r5 + 0x1;
    } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));

    r3 = CPU.sp().value;
    r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = r3 + 0x38;
    r5 = r5 + 0xb;
    r4 = r4 + 0x4;
    r0 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    r7 = 0x0;
    r6 = CPU.sp().value + 0x4c;
    CPU.r9().value = r5;
    CPU.r10().value = r4;
    CPU.r8().value = r0;

    //LAB_80c20ca
    do {
      r1 = CPU.r10().value;
      r2 = MEMORY.ref(1, r1).getUnsigned();
      r3 = 0x1;
      r1 = CPU.r9().value;
      r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r5 = CPU.r8().value;
      CPU.r10().value = CPU.r10().value + r3;
      r3 = MEMORY.ref(1, r1).getUnsigned();
      MEMORY.ref(4, r5 + r0).setu(r2);
      r5 = 0x1;
      CPU.r9().value = CPU.r9().value + r5;
      r5 = r3 - r2;
      if(r5 > 0) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r0 = MEMORY.ref(1, r1 + r7).getUnsigned();
        r0 = r0 + 0x8;
        r0 = FUN_80c23c0(r0);
        r1 = -r0;
        r1 = r1 | r0;
        r1 = r1 >>> 31;
        r3 = 0x2;
        r1 = r3 - r1;
        r0 = CPU.r11().value;
        r0 = divideS(r0, r1);
        if(r0 < r5) {
          r5 = r0;
        }

        //LAB_80c2106
        r0 = rand();
        r3 = r5 + 0x1;
        r3 = r3 * r0;
        r2 = CPU.r8().value;
        r3 = r3 >>> 16;
        MEMORY.ref(4, r2 + r6).setu(r3);
      } else {
        //LAB_80c2116
        r3 = 0x0;
        r5 = CPU.r8().value;
        MEMORY.ref(4, r5 + r6).setu(r3);
      }

      //LAB_80c211c
      r0 = 0x4;
      r7 = r7 + 0x1;
      CPU.r8().value = CPU.r8().value + r0;
    } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));

    r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r1 = r6;

    //LAB_80c212a
    do {
      r2 = 0x0;
      CPU.r8().value = r2;
      r7 = 0x0;
      r5 = 0x0;

      //LAB_80c2132
      do {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = MEMORY.ref(1, r0 + r7).getUnsigned();
        r0 = r3;
        r3 = MEMORY.ref(4, r5 + r6).get();
        r0 = r0 + 0x8;
        if(r3 != 0) {
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = FUN_80c23c0(r0);
          r3 = -r0;
          r3 = r3 | r0;
          r3 = r3 >>> 31;
          r2 = r3;
          r3 = 0x2;
          r2 = r3 - r2;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          if(r2 > CPU.r11().value) {
            r3 = 0x0;
            MEMORY.ref(4, r5 + r6).setu(r3);
          } else {
            //LAB_80c2162
            r3 = MEMORY.ref(4, r5 + r4).get();
            r3 = r3 + 0x1;
            MEMORY.ref(4, r5 + r4).setu(r3);
            r3 = MEMORY.ref(4, r5 + r1).get();
            r3 = r3 - 0x1;
            MEMORY.ref(4, r5 + r1).setu(r3);
            r3 = CPU.r11().value;
            r3 = r3 - r2;
            r0 = 0x1;
            CPU.r11().value = r3;
            CPU.r8().value = r0;
          }
        }

        //LAB_80c2178
        r7 = r7 + 0x1;
        r5 = r5 + 0x4;
      } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));

      r2 = CPU.r8().value;
    } while(r2 != 0);

    r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r2 = r2 + 0x42;
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(1, r2).getUnsigned();
    if(r3 == 0) {
      //LAB_80c219e
      r0 = CPU.sp().value + 0x24;
      CPU.r8().value = r0;
      r7 = 0x0;
      r3 = CPU.r8().value;

      //LAB_80c21a6
      do {
        MEMORY.ref(4, r3).setu(r7);
        r3 += 0x4;
        r7 = r7 + 0x1;
      } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));

      r7 = 0x0;
      r6 = CPU.r8().value;

      //LAB_80c21b2
      do {
        r0 = rand();
        r5 = r0 << 2;
        r5 = r5 + r0;
        r0 = rand();
        r3 = r0 << 2;
        r3 = r3 + r0;
        r5 = r5 >>> 16;
        r3 = r3 >>> 16;
        r5 = r5 << 2;
        r3 = r3 << 2;
        r1 = MEMORY.ref(4, r6 + r5).get();
        r2 = MEMORY.ref(4, r6 + r3).get();
        r7 = r7 + 0x1;
        MEMORY.ref(4, r6 + r5).setu(r2);
        MEMORY.ref(4, r6 + r3).setu(r1);
        CPU.cmpT(r7, 0x9);
      } while((r7 & 0xffff_ffffL) <= (0x9 & 0xffff_ffffL));

      r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r6 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r7 = 0x0;
      r4 = CPU.r8().value;
      CPU.r12().value = r1;
      r0 = r2 << 1;

      //LAB_80c21e6
      do {
        r2 = MEMORY.ref(4, r4).get();
        r1 = r2 << 2;
        r3 = MEMORY.ref(4, r6 + r1).get();
        if(r3 > 0) {
          r5 = CPU.r12().value;
          r3 = MEMORY.ref(1, r5 + r2).getUnsigned();
          r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r1 = MEMORY.ref(4, r2 + r1).get();
          r3 = r3 + 0x8;
          r2 = r0 + r5;

          //LAB_80c21fe
          do {
            MEMORY.ref(2, r2).setu(r3);
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = r1 - 0x1;
            r5 = r5 + 0x1;
            r2 = r2 + 0x2;
            r0 = r0 + 0x2;
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
          } while(r1 != 0);
        }

        //LAB_80c2210
        r7 = r7 + 0x1;
        r4 = r4 + 0x4;
      } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));
    } else {
      if(r3 == 0x1) {
        //LAB_80c221a
        r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r0 = 0x24;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r0 = r0 + CPU.sp().value;
        r3 = r1 << 1;
        r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        CPU.r8().value = r0;
        r6 = r3 + r2;

        //LAB_80c222a
        do {
          r5 = 0x0;
          r7 = 0x0;
          r1 = r4;
          r2 = CPU.sp().value + 0x24;

          //LAB_80c2232
          do {
            r3 = MEMORY.ref(4, r1).get();
            r1 += 0x4;
            if(r3 != 0) {
              MEMORY.ref(4, r2).setu(r7);
              r2 += 0x4;
              r5 = r5 + 0x1;
            }

            //LAB_80c223c
            r7 = r7 + 0x1;
          } while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL));

          if(r5 == 0) {
            break;
          }
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = rand();
          r3 = r5;
          r3 = r3 * r0;
          r3 = r3 >>> 16;
          r3 = r3 << 2;
          r5 = CPU.r8().value;
          r2 = MEMORY.ref(4, r5 + r3).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = MEMORY.ref(1, r0 + r2).getUnsigned();
          r3 = r3 + 0x8;
          MEMORY.ref(2, r6).setu(r3);
          r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r1 = r1 + 0x1;
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          r2 = r2 << 2;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = r3 - 0x1;
          r6 = r6 + 0x2;
          MEMORY.ref(4, r4 + r2).setu(r3);
        } while(true);
      } else {
        r7 = 0x0;

        //LAB_80c22b0
        while((r7 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL)) {
          //LAB_80c2284
          r5 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r3 = r7 << 2;
          r2 = MEMORY.ref(4, r5 + r3).get();
          if(r2 > 0) {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(1, r0 + r7).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r1 = r3;
            r3 = r5 << 1;
            r1 = r1 + 0x8;
            r3 = r3 + r0;

            //LAB_80c229e
            do {
              MEMORY.ref(2, r3).setu(r1);
              r5 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              r2 = r2 - 0x1;
              r5 = r5 + 0x1;
              r3 = r3 + 0x2;
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(r5);
            } while(r2 != 0);
          }

          //LAB_80c22ae
          r7 = r7 + 0x1;
        }
      }
    }

    //LAB_80c22b4
    r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r3 = 0x0;
    r2 = r0 << 1;
    MEMORY.ref(2, r2 + r1).setu(r3);
    r5 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r3 = 0x6;
    MEMORY.ref(2, r5 + 0x3c).setu(r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r2 = 0x0;
    MEMORY.ref(2, r0 + 0x3e).setu(r2);

    //LAB_80c22d8
    for(r7 = 128; r7 < 134; r7++) {
      MEMORY.call(0x3000164, getCharOrMonsterData_(r7).getAddress(), 0x14c); // memzero
    }

    r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r3 = MEMORY.ref(2, r1).getUnsigned();
    r7 = 0x0;
    if(r3 != 0) {
      r2 = 0x0;

      //LAB_80c22f8
      do {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r6 = r2 + r3;
        r0 = MEMORY.ref(2, r6).getUnsigned();
        r1 = 0x1;
        r0 = FUN_80c1df4(r0);
        r3 = 0x80;
        r4 = r0;
        r3 = r3 << 8;
        r3 = r3 & r4;
        if(r3 != 0) {
          r0 = MEMORY.ref(2, r6).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          FUN_80c1f50(r0);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80c231a
        FUN_8077140(r7 + 0x80, MEMORY.ref(2, r6).getUnsigned(), r4 & 0x7fff);

        r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        if(r1 != 0) {
          FUN_80c1c54(r7 + 0x80, r1);
        }

        //LAB_80c233c
        r7 = r7 + 0x1;
        if((r7 & 0xffff_ffffL) > (0x5 & 0xffff_ffffL)) {
          break;
        }

        r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r2 = r7 * 0x2;
      } while(MEMORY.ref(2, r5 + r2).getUnsigned() != 0);
    }

    //LAB_80c234e
    r0 = r7;
    CPU.sp().value += 0x7c;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x80c2384)
  public static int FUN_80c2384(final int r0) {
    if((r0 & 0xffff_ffffL) > 171) {
      return MEMORY.ref(2, 0x80c7420).getUnsigned();
    }

    //LAB_80c2390
    return MEMORY.ref(2, 0x80c7420 + r0 * 0x8).getUnsigned();
  }

  @Method(0x80c23a0)
  public static int FUN_80c23a0(final int r0) {
    if((r0 & 0xffff_ffffL) > 171) {
      return MEMORY.ref(2, 0x80c7420).getUnsigned();
    }

    //LAB_80c23ac
    return MEMORY.ref(1, 0x80c7420 + r0 * 0x8 + 0x3).getUnsigned() << 27 >>> 28;
  }

  @Method(0x80c23c0)
  public static int FUN_80c23c0(final int r0) {
    int r1;
    int r2;
    int r3;

    if((r0 & 0xffff_ffffL) >= 170) {
      return 0;
    }

    //LAB_80c23ca
    r3 = 0x80c7420;
    r2 = r0 << 3;
    r2 = r2 + r3;
    r3 = MEMORY.ref(1, r2 + 0x2).getUnsigned();
    r3 = r3 << 31;
    r1 = 0x0;
    if(r3 != 0) {
      r1 = 0x1;
    }

    //LAB_80c23dc
    return r1;
  }

  @Method(0x80c24b0)
  public static void FUN_80c24b0() {
    int r0;
    final int r1;
    int r3;

    r0 = boardWramMallocHead_3001e50.offset(9 * 0x4).get();
    r1 = r0 + 0x530;
    r3 = 0x200047c;
    MEMORY.ref(2, r3).setu(0);
    MEMORY.ref(4, r1).setu(0);
    MEMORY.ref(4, r1 + 0x4).setu(0);
    MEMORY.ref(4, r1 + 0x8).setu(0);
    r3 = 0x3;
    r0 = r0 + 0x542;

    //LAB_80c24d4
    do {
      r3 = r3 - 0x1;
      MEMORY.ref(2, r0).setu(0);
      r0 = r0 - 0x2;
    } while(r3 >= 0);
  }

  @Method(0x80c2724)
  public static void FUN_80c2724() {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun_80d#FUN_80d6578} */
  @Method(0x80c9010)
  public static void FUN_80c9010(final int r0) {
    MEMORY.call(0x80d6578, r0);
  }

  /** {@link GoldenSun_80c#FUN_80cbc0c} */
  @Method(0x80c9028)
  public static void FUN_80c9028(final int r0) {
    MEMORY.call(0x80cbc0c, r0);
  }

  @Method(0x80c9048)
  public static void FUN_80c9048() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;

    r2 = 0x4000050;
    r3 = 0x0;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x100e;
    r2 = r2 + 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r1 = 0xf0;
    r3 = 0x4000040;
    r2 = 0x1088;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 - 0x2;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r2 = 0x4000048;
    r3 = 0x3537;
    r1 = 0x2002090;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f21;
    r2 = r2 + 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0x4000208;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r4 = r3;
    MEMORY.ref(2, r0).setu(r0);
    r2 = MEMORY.ref(2, r1).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r1;
      MEMORY.ref(2, r1).setu(r2);
      r2 = 0x7741;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80c90d4
    MEMORY.ref(2, r0).setu(r4);
    r0 = 0x1;
    sleep(r0);
  }

  @Method(0x80cd104)
  public static void FUN_80cd104(int r0, int r1) {
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
    CPU.sp().value -= 0x88;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    r3 = 0x3001ef0;
    r1 = MEMORY.ref(4, r3).get();
    r3 = r3 - 0x4;
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.sp().value + 0x8;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    CPU.r11().value = r2;
    r3 = CPU.sp().value + 0x88;
    r7 = r0;
    CPU.r9().value = r1;
    r6 = 0x3f;
    r5 = CPU.r11().value;
    CPU.r8().value = r3;

    //LAB_80cd130
    do {
      r0 = rand();
      r0 = r0 & r6;
      MEMORY.ref(1, r5).setu(r0);
      r5 = r5 + 0x1;
    } while(r5 != CPU.r8().value);

    if(r7 == 0x1) {
      r1 = 0x0;
      r2 = 0x1;
      CPU.r8().value = r1;
      CPU.r10().value = r2;
      r5 = 0x0;

      //LAB_80cd14c
      do {
        CPU.r8().value = CPU.r8().value + CPU.r10().value;
        r3 = 0x1;
        CPU.r10().value = CPU.r10().value + r3;
        if(r5 != CPU.r8().value) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          CPU.r12().value = CPU.r11().value;
          r4 = 0x7;
          r7 = r3 - r1;

          //LAB_80cd15e
          do {
            r6 = 0x0;
            r0 = CPU.r12().value;

            //LAB_80cd162
            do {
              r3 = MEMORY.ref(1, r0).getUnsigned();
              r1 = r5 - r3;
              r0 = r0 + 0x1;
              if(r1 >= 0x0) {
                if(r1 <= 0x7f) {
                  r2 = r6;
                  if(r6 < 0) {
                    r2 = r6 + 0x7;
                  }

                  //LAB_80cd178
                  r2 = r2 >> 3;
                  r3 = r1;
                  if(r1 < 0) {
                    r3 = r1 + 0x7;
                  }

                  //LAB_80cd182
                  r3 = r3 >> 3;
                  r2 = r2 << 4;
                  r2 = r2 + r3;
                  r3 = r6;
                  r3 = r3 & r4;
                  r2 = r2 << 3;
                  r2 = r2 + r3;
                  r1 = r1 & r4;
                  r2 = r2 << 3;
                  r2 = r2 + r1;
                  r3 = CPU.r9().value;
                  MEMORY.ref(1, r3 + r2).setu(r7);
                }
              }

              //LAB_80cd19a
              r6 = r6 + 0x1;
            } while(r6 != 0x80);

            r5 = r5 + 0x1;
          } while(r5 != CPU.r8().value);
        }

        //LAB_80cd1a6
        r1 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = 0x7824;
        r2 = r1 + r3;
        r3 = 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r0 = 0x1;
        sleep(r0);
        r1 = 0x80;
        r1 = r1 << 1;
      } while(CPU.r8().value <= r1);
    } else {
      //LAB_80cd1c0
      r2 = 0x0;
      r3 = 0x1;
      CPU.r8().value = r2;
      CPU.r10().value = r3;
      r6 = 0x0;

      //LAB_80cd1ca
      do {
        r1 = CPU.r10().value;
        r3 = r1 >>> 31;
        r3 = r3 + CPU.r10().value;
        r3 = r3 >> 1;
        r2 = 0x4;
        CPU.r8().value = CPU.r8().value + r3;
        CPU.r10().value = CPU.r10().value + r2;
        if(r6 != CPU.r8().value) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = 0x1;
          CPU.r12().value = CPU.r11().value;
          r4 = 0x7;
          r7 = r3 - r1;

          //LAB_80cd1e6
          do {
            r5 = 0x0;
            r0 = CPU.r12().value;

            //LAB_80cd1ea
            do {
              r3 = MEMORY.ref(1, r0).getUnsigned();
              r1 = r6 - r3;
              r0 = r0 + 0x1;
              if(r1 >= 0) {
                if(r1 <= 0x7f) {
                  r2 = r1;
                  if(r1 < 0) {
                    r2 = r1 + 0x7;
                  }

                  //LAB_80cd200
                  r2 = r2 >> 3;
                  r3 = r5;
                  if(r5 < 0) {
                    r3 = r5 + 0x7;
                  }

                  //LAB_80cd20a
                  r3 = r3 >> 3;
                  r2 = r2 << 4;
                  r2 = r2 + r3;
                  r1 = r1 & r4;
                  r2 = r2 << 3;
                  r2 = r2 + r1;
                  r3 = r5;
                  r3 = r3 & r4;
                  r2 = r2 << 3;
                  r2 = r2 + r3;
                  r3 = CPU.r9().value;
                  MEMORY.ref(1, r3 + r2).setu(r7);
                }
              }

              //LAB_80cd222
              r5 = r5 + 0x1;
            } while(r5 != 0x80);

            r6 = r6 + 0x1;
          } while(r6 != CPU.r8().value);
        }

        //LAB_80cd22e
        r1 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = 0x7824;
        r2 = r1 + r3;
        r3 = 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r0 = 0x1;
        sleep(r0);
        r1 = CPU.r8().value;
      } while(r1 <= 0xbf);
    }

    //LAB_80cd244
    CPU.sp().value += 0x88;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80cd508)
  public static void FUN_80cd508() {
    int r0;
    final int r1;
    int r3;

    r3 = 0x3001eec;
    r0 = MEMORY.ref(4, r3).get();
    r3 = 0x7818;
    r1 = 0x8;
    r0 = r0 + r3;
    r3 = 0x3000164;
    MEMORY.call(r3, r0, r1); // memzero
  }

  @Method(0x80cd52c)
  public static void FUN_80cd52c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    r1 = 0x1;
    r6 = MEMORY.ref(4, r3).get();
    r3 = 0x7818;
    r1 = -r1;
    CPU.sp().value -= 0x8;
    r4 = 0x0;
    CPU.r8().value = r1;
    r7 = 0x24;
    r5 = r6 + r3;

    //LAB_80cd546
    do {
      r2 = MEMORY.ref(1, r5).getUnsigned();
      r3 = r2;
      if(r3 != 0) {
        r3 = r3 + 0xff;
        MEMORY.ref(1, r5).setu(r3);
        r3 = r3 << 24;
        r2 = r3 >>> 24;
        if(r2 == 0) {
          r1 = 0x7828;
          r3 = r6 + r1;
          r3 = MEMORY.ref(4, r3).get();
          r0 = MEMORY.ref(2, r3 + r7).get();
          MEMORY.ref(4, CPU.sp().value).setu(r2);
          r1 = 0x0;
          r2 = CPU.r8().value;
          r3 = CPU.r8().value;
          FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
        }
      }

      //LAB_80cd572
      r4 = r4 + 0x1;
      r7 = r7 + 0x2;
      r5 = r5 + 0x1;
    } while(r4 != 0x8);

    CPU.sp().value += 0x8;
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80cd594)
  public static void FUN_80cd594(int r0) {
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
    r3 = 0x3001eec;
    r2 = MEMORY.ref(4, r3).get();
    CPU.r9().value = r2;
    r2 = r3;
    r2 = r2 - 0x78;
    r2 = MEMORY.ref(4, r2).get();
    CPU.r10().value = r2;
    r2 = MEMORY.ref(4, r3 + 0x4).get();
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r3 = MEMORY.ref(4, r3 + 0x14).get();
    CPU.r11().value = r3;
    r7 = r0;
    FUN_80cd508();
    r2 = CPU.r11().value;
    r3 = 0x1;
    MEMORY.ref(4, r2 + 0xc).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r3 = 0x0;
    r2 = 0x4000050;
    r6 = 0x2002090;
    MEMORY.ref(2, r2).setu(r3);
    r5 = 0x4000208;
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      MEMORY.ref(2, r6).setu(r2);
      r2 = 0x7741;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cd61c
    MEMORY.ref(2, r5).setu(r1);
    r2 = 0x3001ad0;
    r3 = 0x0;
    CPU.r8().value = r3;
    r3 = 0x20;
    MEMORY.ref(2, r2 + 0x6).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r3 = 0xc9;
    r3 = r3 << 3;
    r3 = r3 + CPU.r10().value;
    r1 = MEMORY.ref(2, r3).getUnsigned();
    r0 = 0x1;
    r2 = 0x0;
    FUN_80b5038(r0, r1, r2);
    r3 = 0x77b4;
    r2 = CPU.r8().value;
    r3 = r3 + CPU.r9().value;
    MEMORY.ref(4, r3).setu(r2);
    r3 = 0x77b8;
    r1 = 0xc8;
    r3 = r3 + CPU.r9().value;
    MEMORY.ref(4, r3).setu(r2);
    r1 = r1 << 4;
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"), r1);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      MEMORY.ref(2, r6).setu(r2);
      r2 = 0x7341;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cd680
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x784;
    r3 = 0x400000c;
    r7 = r7 | r2;
    MEMORY.ref(2, r3).setu(r7);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      MEMORY.ref(2, r6).setu(r2);
      r2 = 0x7341;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cd6d8
    MEMORY.ref(2, r5).setu(r1);
    r0 = 0x0;
    r1 = 0x0;
    r2 = 0x0;
    r3 = 0x64;
    FUN_80b5028(r0, r1, r2, r3);
    r3 = CPU.r8().value;
    r2 = CPU.r11().value;
    MEMORY.ref(4, r2 + 0xc).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r3 = 0x3f44;
    r2 = 0x4000050;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x100e;
    r2 = r2 + 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x4000028;
    r2 = CPU.r8().value;
    MEMORY.ref(4, r3).setu(r2);
    r2 = 0x400002c;
    r3 = 0xfffff000;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0x80;
    r2 = r2 - 0xc;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x4000022;
    r2 = CPU.r8().value;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 + 0x2;
    MEMORY.ref(2, r3).setu(r2);
    r2 = 0x4000026;
    r3 = 0x100;
    r1 = 0xf0;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x4000040;
    r2 = 0x1088;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 - 0x2;
    MEMORY.ref(2, r3).setu(r1);
    r3 = r3 + 0x4;
    MEMORY.ref(2, r3).setu(r2);
    r2 = 0x4000048;
    r3 = 0x3537;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f21;
    r2 = r2 + 0x2;
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(2, r5).getUnsigned();
    r1 = r3;
    MEMORY.ref(2, r5).setu(r5);
    r2 = MEMORY.ref(2, r6).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r6;
      MEMORY.ref(2, r6).setu(r2);
      r2 = 0x7741;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cd7b2
    MEMORY.ref(2, r5).setu(r1);
    r5 = 0x0;
    r3 = 0x6003800;
    r2 = 0x80;
    CPU.r8().value = r3;
    r3 = 0x80;
    r2 = r2 << 1;
    r3 = r3 << 2;
    CPU.r12().value = r5;
    r7 = 0x0;
    CPU.r10().value = r2;
    CPU.lr().value = r3;
    r6 = 0x0;

    //LAB_80cd7cc
    do {
      r2 = CPU.r10().value;
      r4 = 0x0;
      r0 = r6 + r2;
      r1 = r7 << 1;

      //LAB_80cd7d4
      do {
        r3 = r0;
        r3 = r3 | r1;
        r3 = r3 << 16;
        r3 = r3 >> 16;
        CPU.r11().value = r3;
        r3 = CPU.r8().value;
        r2 = r5 + r3;
        r4 = r4 + 0x1;
        r3 = CPU.r11().value;
        MEMORY.ref(2, r2).setu(r3);
        r0 = r0 + CPU.lr().value;
        r1 = r1 + 0x2;
        r5 = r5 + 0x2;
      } while(r4 != 0x8);

      r2 = 0x80;
      r3 = 0x1;
      r2 = r2 << 5;
      CPU.r12().value = CPU.r12().value + r3;
      r6 = r6 + r2;
      r2 = CPU.r12().value;
      r7 = r7 + 0x8;
    } while(r2 != 0x10);

    r1 = 0x80;
    r0 = MEMORY.ref(4, CPU.sp().value).get();
    r5 = 0x3000164;
    r1 = r1 << 7;
    MEMORY.call(r5, r0, r1);
    r1 = 0x80;
    r1 = r1 << 7;
    r0 = 0x6004000;
    MEMORY.call(r5, r0, r1);
    r3 = 0x77a8;
    r1 = 0x3001ad0;
    r3 = r3 + CPU.r9().value;
    r6 = 0x0;
    r2 = 0x77a0;
    MEMORY.ref(4, r3).setu(r6);
    r3 = MEMORY.ref(2, r1 + 0x4).getUnsigned();
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x77a4;
    r3 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80cdbc0)
  public static void FUN_80cdbc0() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    r0 = 0x121;
    r5 = MEMORY.ref(4, r3).get();
    r3 = r3 - 0x78;
    r7 = MEMORY.ref(4, r3).get();
    playSound_(r0);
    r2 = 0x77a0;
    r3 = r5 + r2;
    r6 = 0x3001ad0;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(2, r6 + 0x4).setu(r3);
    r3 = 0x77a4;
    r5 = r5 + r3;
    r3 = MEMORY.ref(4, r5).get();
    r2 = 0x3001ce0;
    MEMORY.ref(2, r6 + 0x6).setu(r3);
    r3 = 0x78;
    MEMORY.ref(4, r2 + 0xc).setu(r3);
    MEMORY.ref(4, r2 + 0x10).setu(r3);
    r2 = 0x400000c;
    r3 = 0x787;
    r1 = 0x80;
    MEMORY.ref(2, r2).setu(r3);
    r1 = r1 << 7;
    r3 = 0x3000164;
    r0 = 0x6004000;
    MEMORY.call(r3, r0, r1);
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
    r1 = 0x2002090;
    r3 = 0x20;
    MEMORY.ref(2, r6 + 0x6).setu(r3);
    r0 = 0x4000208;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r4 = r3;
    MEMORY.ref(2, r0).setu(r0);
    r2 = MEMORY.ref(2, r1).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r1;
      MEMORY.ref(2, r1).setu(r2);
      r2 = 0x7341;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cdc6e
    MEMORY.ref(2, r0).setu(r4);
    r2 = 0x4000050;
    r3 = 0x0;
    r0 = 0x1;
    MEMORY.ref(2, r2).setu(r3);
    sleep(r0);
    r2 = 0xc9;
    r2 = r2 << 3;
    r3 = r7 + r2;
    r1 = MEMORY.ref(2, r3).getUnsigned();
    r2 = 0x7;
    r0 = 0x2;
    FUN_80b5038(r0, r1, r2);
    r0 = 0x1;
    sleep(r0);
    r3 = 0xc9;
    r3 = r3 << 3;
    r2 = 0x15;
    r6 = 0x0;
    r7 = r7 + r3;
    r5 = 0x0;
    CPU.r8().value = r2;

    //LAB_80cdcb0
    do {
      r3 = CPU.r8().value;
      r1 = r3 - r5;
      r0 = MEMORY.ref(2, r7).getUnsigned();
      FUN_80b5048(r0, r1);
      r6 = r6 + 0x1;
      r0 = 0x1;
      sleep(r0);
      r5 = r5 + 0x3;
    } while(r6 != 0x8);

    r1 = 0x2002090;
    r0 = 0x4000208;
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r4 = r3;
    MEMORY.ref(2, r0).setu(r0);
    r2 = MEMORY.ref(2, r1).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r2 << 1;
      r3 = r3 + r2;
      r3 = r3 << 2;
      r2 = r2 + 0x1;
      r3 = r3 + r1;
      MEMORY.ref(2, r1).setu(r2);
      r2 = 0x7541;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 19;
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = 0x80;
      r2 = r2 << 10;
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_80cdcf6
    MEMORY.ref(2, r0).setu(r4);
    r0 = 0x1;
    sleep(r0);
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80cde90)
  public static void FUN_80cde90(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r6 = r3;
    r3 = 0x3001ef0;
    r5 = r1;
    r3 = MEMORY.ref(4, r3).get();
    r4 = r2;
    r1 = r6 - r5;
    r2 = 0x80;
    CPU.r8().value = r0;
    r7 = r4 - r0;
    CPU.r10().value = r1;
    CPU.r9().value = r2;
    CPU.r11().value = r3;
    if(r5 < 0) {
      r5 = 0x0;
    }

    //LAB_80cdebe
    if(r5 > 0x7f) {
      r5 = 0x7f;
    }

    //LAB_80cdec4
    if(r6 < 0) {
      r6 = 0x0;
    }

    //LAB_80cdeca
    if(r6 > 0x7f) {
      r6 = 0x7f;
    }

    //LAB_80cded0
    r2 = r7;
    if(r7 < 0) {
      r2 = -r7;
    }

    //LAB_80cded8
    r3 = CPU.r10().value;
    if(r3 < 0) {
      r3 = -r3;
    }

    //LAB_80cdee0
    if(r2 < r3) {
      r3 = CPU.r10().value;
      if(r3 < 0) {
        CPU.r12().value = CPU.r8().value;
        CPU.r8().value = r4;
        r4 = CPU.r12().value;
        CPU.r12().value = r5;
        r1 = CPU.r8().value;
        r5 = r6;
        r6 = CPU.r12().value;
        r7 = r4 - r1;
      }

      //LAB_80cdefa
      r1 = r6 - r5;
      r0 = r7 << 8;
      if(r7 < 0) {
        r2 = CPU.r8().value;
        r3 = r2 - r4;
        r0 = r3 << 8;
      }

      //LAB_80cdf08
      if(r1 < 0) {
        r1 = r5 - r6;
      }

      //LAB_80cdf0e
      r0 = divideS(r0, r1);
      CPU.r12().value = r0;
      r0 = r5;
      r1 = CPU.r8().value;
      CPU.cmpT(r0, r6);
      if(r0 != r6) {
        r3 = 0x80;
        r5 = 0xfffffeff;
        r3 = r3 << 1;
        r4 = 0x7;
        CPU.lr().value = r3;
        CPU.r8().value = r5;

        //LAB_80cdf28
        do {
          r2 = r0 >>> 3;
          r3 = r1 >>> 3;
          r2 = r2 << 4;
          r2 = r2 + r3;
          r3 = r0;
          r3 = r3 & r4;
          r2 = r2 << 3;
          r2 = r2 + r3;
          r3 = r1;
          r3 = r3 & r4;
          r2 = r2 << 3;
          r5 = CPU.r11().value;
          r2 = r2 + r3;
          r3 = MEMORY.ref(1, r5 + r2).getUnsigned();
          r5 = a4;
          if(r3 < r5) {
            r3 = CPU.r11().value;
            MEMORY.ref(1, r3 + r2).setu(r5);
          }

          //LAB_80cdf4e
          CPU.r9().value = CPU.r9().value + CPU.r12().value;
          r3 = CPU.r9().value;
          r5 = CPU.lr().value;
          r3 = r3 & r5;
          if(r3 != 0) {
            if(r7 > 0) {
              r1 = r1 + 0x1;
            } else {
              //LAB_80cdf62
              r1 = r1 - 0x1;
            }

            //LAB_80cdf64
            r2 = CPU.r9().value;
            r3 = CPU.r8().value;
            r2 = r2 & r3;
            CPU.r9().value = r2;
          }

          //LAB_80cdf6c
          r0 = r0 + 0x1;
          CPU.cmpT(r0, r6);
        } while(r0 != r6);
      }
    } else {
      //LAB_80cdf74
      if(r7 < 0) {
        CPU.r12().value = CPU.r8().value;
        CPU.r8().value = r4;
        r4 = CPU.r12().value;
        CPU.r12().value = r5;
        r5 = r6;
        r6 = CPU.r12().value;
        r2 = r6 - r5;
        r1 = CPU.r8().value;
        CPU.r10().value = r2;
        r7 = r4 - r1;
        r1 = CPU.r10().value;
      } else {
        //LAB_80cdf90
        r1 = r6 - r5;
      }

      //LAB_80cdf92
      r0 = r1 << 8;
      if(r1 < 0) {
        r3 = r5 - r6;
        r0 = r3 << 8;
      }

      //LAB_80cdf9c
      if(r7 >= 0) {
        r1 = r7;
        r0 = divideS(r0, r1);
        CPU.r12().value = r0;
      } else {
        //LAB_80cdfae
        r3 = CPU.r8().value;
        r1 = r3 - r4;
        r0 = divideS(r0, r1);
        CPU.r12().value = r0;
      }

      //LAB_80cdfbc
      r0 = CPU.r8().value;
      r1 = r5;
      if(r0 != r4) {
        r6 = 0xfffffeff;
        r7 = 0x80;
        r5 = 0x7;
        r7 = r7 << 1;
        CPU.lr().value = r6;

        //LAB_80cdfce
        do {
          r2 = r1 >>> 3;
          r3 = r0 >>> 3;
          r2 = r2 << 4;
          r2 = r2 + r3;
          r3 = r1;
          r3 = r3 & r5;
          r2 = r2 << 3;
          r2 = r2 + r3;
          r3 = r0;
          r3 = r3 & r5;
          r2 = r2 << 3;
          r6 = CPU.r11().value;
          r2 = r2 + r3;
          r3 = MEMORY.ref(1, r6 + r2).getUnsigned();
          r6 = a4;
          if(r3 < r6) {
            r3 = CPU.r11().value;
            MEMORY.ref(1, r3 + r2).setu(r6);
          }

          //LAB_80cdff4
          CPU.r9().value = CPU.r9().value + CPU.r12().value;
          r3 = CPU.r9().value;
          r3 = r3 & r7;
          if(r3 != 0) {
            r6 = CPU.r10().value;
            if(r6 > 0) {
              r1 = r1 + 0x1;
            } else {
              //LAB_80ce008
              r1 = r1 - 0x1;
            }

            //LAB_80ce00a
            r2 = CPU.r9().value;
            r3 = CPU.lr().value;
            r2 = r2 & r3;
            CPU.r9().value = r2;
          }

          //LAB_80ce012
          r0 = r0 + 0x1;
          CPU.cmpT(r0, r4);
        } while(r0 != r4);
      }
    }

    //LAB_80ce018
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80cef64)
  public static void FUN_80cef64(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;

    CPU.sp().value -= 0x4;
    r6 = r1;
    if(r0 == 0) {
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x7;
      r2 = 0x7;
      r3 = 0x3;
      r0 = 0x2e;
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = 0x3001e50;
      r3 = r5;
      r3 = r3 + 0xb8;
      r3 = MEMORY.ref(4, r3).get();
      r0 = 0x2f;
      MEMORY.ref(4, r6).setu(r3);
      r1 = 0x7;
      r3 = 0x3;
      r2 = 0x7;
      r5 = r5 + 0xbc;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
    } else {
      //LAB_80cef96
      r3 = 0x2;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r1 = 0x7;
      r2 = 0x7;
      r3 = 0x7;
      r0 = 0x2e;
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = 0x3001e50;
      r3 = r5;
      r3 = r3 + 0xb8;
      r3 = MEMORY.ref(4, r3).get();
      MEMORY.ref(4, r6).setu(r3);
      r3 = 0x3;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = 0x2f;
      r3 = 0x7;
      r1 = 0x7;
      r2 = 0x7;
      r5 = r5 + 0xbc;
    }

    //LAB_80cefbe
    FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r3 = MEMORY.ref(4, r5).get();
    MEMORY.ref(4, r6 + 0x4).setu(r3);
    CPU.sp().value += 0x4;
  }
}
