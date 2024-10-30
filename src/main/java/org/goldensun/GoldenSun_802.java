package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSun.setMallocSlot;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.loadUiTextures;
import static org.goldensun.GoldenSunVars._3001800;
import static org.goldensun.GoldenSunVars._3001b04;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_80162d4;
import static org.goldensun.GoldenSun_801.FUN_8016418;
import static org.goldensun.GoldenSun_801.FUN_8016478;
import static org.goldensun.GoldenSun_801.FUN_8018850;
import static org.goldensun.GoldenSun_801.FUN_8019d2c;
import static org.goldensun.GoldenSun_801.FUN_8019da8;
import static org.goldensun.GoldenSun_801.FUN_8019e48;
import static org.goldensun.GoldenSun_801.FUN_801e41c;
import static org.goldensun.GoldenSun_801.FUN_801e858;
import static org.goldensun.GoldenSun_801.FUN_801eadc;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_80b.FUN_80b0020;
import static org.goldensun.GoldenSun_80b.FUN_80b0028;
import static org.goldensun.GoldenSun_80b.FUN_80b0030;
import static org.goldensun.GoldenSun_80b.FUN_80b0038;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_802 {
  private GoldenSun_802() { }

  /** Maybe decompressing a graphic and uploading to VRAM */
  @Method(0x80209d0)
  public static void FUN_80209d0(final int r0_0, final int r1) {
    final int r10 = mallocBoard(0x300);
    decompress(r1, r10);
    int r3 = MEMORY.ref(2, r0_0 + 0xc).getUnsigned() + MEMORY.ref(2, r0_0 + 0xe).getUnsigned() * 0x20;
    final int r4 = MEMORY.ref(2, r0_0 + 0xa).getUnsigned(); // maybe height
    int r7 = r10;
    int r0 = 0x6002000 + r3 * 0x2;
    int r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get() + r3 * 0x2;
    final int r2 = MEMORY.ref(2, r0_0 + 0x8).getUnsigned(); // maybe width

    //LAB_8020a14
    for(int i = 0; i < r4; i++) {
      //LAB_8020a1a
      for(int n = 0; n < r2; n++) {
        r3 = MEMORY.ref(2, r7).get();
        MEMORY.ref(2, r0).setu(r3);
        MEMORY.ref(2, r6).setu(r3);
        r7 += 0x2;
        r0 += 0x2;
        r6 += 0x2;
      }

      //LAB_8020a32
      r3 = (32 - r2) * 2;
      r0 += r3;
      r6 += r3;
    }

    //LAB_8020a44
    setMallocSlot(r10);
  }

  @Method(0x8020a60)
  public static void FUN_8020a60(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    int r6;
    int r7;

    r6 = CPU.addT(r3, 0x0);
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    CPU.r12().value = r3;
    r3 = MEMORY.ref(2, r0 + 0xc).getUnsigned();
    r3 = CPU.addT(r1, r3);
    r1 = CPU.addT(r3, 0x1);
    r3 = MEMORY.ref(2, r0 + 0xe).getUnsigned();
    r7 = a5;
    r3 = CPU.addT(r2, r3);
    r5 = a4;
    r2 = CPU.addT(r3, 0x1);
    r7 = CPU.lslT(r7, 12);
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r6 = CPU.addT(r6, r1);
      r1 = CPU.movT(0, 0x0);
    }

    //LAB_8020a84
    r3 = CPU.addT(r1, r6);
    CPU.cmpT(r3, 0x1d);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x1e);
      r6 = CPU.subT(r3, r1);
    }

    //LAB_8020a8e
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r5 = CPU.addT(r5, r2);
      r2 = CPU.movT(0, 0x0);
    }

    //LAB_8020a96
    r3 = CPU.addT(r2, r5);
    CPU.cmpT(r3, 0x1d);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x14);
      r5 = CPU.subT(r3, r2);
    }

    //LAB_8020aa0
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      return;
    }
    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      return;
    }
    r2 = CPU.lslT(r2, 6);
    r3 = CPU.lslT(r1, 1);
    r1 = CPU.addT(r2, r3);

    //LAB_8020aae
    do {
      r3 = CPU.r12().value;
      r0 = CPU.addT(r6, 0x0);
      r4 = CPU.addT(r1, r3);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_8020aba
        do {
          r3 = MEMORY.ref(2, r4).getUnsigned();
          r3 = CPU.andT(r3, 0xffffefff);
          r3 = CPU.orrT(r3, r7);
          r0 = CPU.subT(r0, 0x1);
          MEMORY.ref(2, r4).setu(r3);
          r4 = CPU.addT(r4, 0x2);
          CPU.cmpT(r0, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8020aca
      r5 = CPU.subT(r5, 0x1);
      r1 = CPU.addT(r1, 0x40);
      CPU.cmpT(r5, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    MEMORY.ref(1, CPU.r12().value + 0xea3).setu(0x1);

    //LAB_8020ada
  }

  @Method(0x8020b14)
  public static int FUN_8020b14(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    r3 = MEMORY.ref(1, r0).getUnsigned();
    CPU.sp().value -= 0x8;
    r1 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xeb);
      r3 = CPU.lslT(r3, 4);
      r2 = CPU.addT(r4, r3);

      //LAB_8020b2a
      do {
        r3 = MEMORY.ref(1, r0).getUnsigned();
        MEMORY.ref(2, r2).setu(r3);
        r0 = CPU.addT(r0, 0x1);
        r3 = MEMORY.ref(1, r0).getUnsigned();
        r2 = CPU.addT(r2, 0x2);
        r1 = CPU.addT(r1, 0x1);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8020b3a
    r2 = CPU.movT(0, 0xeb);
    r3 = CPU.lslT(r1, 1);
    r2 = CPU.lslT(r2, 4);
    r3 = CPU.addT(r3, r2);
    r1 = CPU.sp().value + 0x4;
    MEMORY.ref(2, r4 + r3).setu(0);
    r0 = CPU.movT(0, 0x0);
    r2 = CPU.sp().value;
    r3 = CPU.movT(0, 0x0);
    FUN_8018850(r0, r1, r2, r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.sp().value += 0x8;
    return r0;
  }

  @Method(0x8020b64)
  public static void FUN_8020b64(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r2 = MEMORY.ref(1, r1).getUnsigned();
    r3 = CPU.addT(r2, 0x0);
    CPU.sp().value -= 0x14;
    r6 = CPU.addT(r0, 0x0);
    r4 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.sp().value;
      r5 = CPU.addT(r0, 0x0);

      //LAB_8020b78
      do {
        MEMORY.ref(1, r5).setu(r2);
        r1 = CPU.addT(r1, 0x1);
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r2 = CPU.addT(r3, 0x0);
        r3 = CPU.addT(r2, 0x0);
        r5 = CPU.addT(r5, 0x1);
        r4 = CPU.addT(r4, 0x1);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    } else {
      //LAB_8020b8c
      r0 = CPU.sp().value;
    }

    //LAB_8020b8e
    r3 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r0 + r4).setu(r3);
    r4 = CPU.addT(r4, 0x1);
    r3 = CPU.movT(0, 0x2);
    MEMORY.ref(1, r0 + r4).setu(r3);
    r4 = CPU.addT(r4, 0x1);
    CPU.cmpT(r4, 0x6);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.movT(0, 0x7);
      r2 = CPU.addT(r4, r0);
      r1 = CPU.movT(0, 0x5f);
      r4 = CPU.subT(r3, r4);

      //LAB_8020ba6
      do {
        r4 = CPU.subT(r4, 0x1);
        MEMORY.ref(1, r2).setu(r1);
        r2 = CPU.addT(r2, 0x1);
        CPU.cmpT(r4, 0x0);
      } while(!CPU.cpsr().getZero()); // !=

      r4 = CPU.movT(0, 0x7);
    }

    //LAB_8020bb2
    r3 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r0 + r4).setu(r3);
    r4 = CPU.addT(r4, 0x1);
    r3 = CPU.movT(0, 0xf);
    MEMORY.ref(1, r0 + r4).setu(r3);
    r4 = CPU.addT(r4, 0x1);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r0 + r4).setu(r3);
    r3 = CPU.movT(0, 0x2);
    r3 = CPU.negT(r3, r3);
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.movT(0, 0x0);
    FUN_801e858(r0, r1, r2, r3);
    CPU.sp().value += 0x14;
  }

  @Method(0x8020bd8)
  public static int FUN_8020bd8(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;
    final int r8;
    int r9;
    final int r10;
    final int r11;

    CPU.sp().value -= 0x60;
    r2 = CPU.sp().value;
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.addT(r2, 0x51);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
    r6 = CPU.sp().value + 0x50;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
    r0 = FUN_8077008(r0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    r9 = r3;
    loadUiTextures();
    r0 = FUN_80162d4(0x3, 0x6, 0x18, 0x9, 0x2);
    r8 = r0;
    r0 = FUN_80162d4(0x8, 0x3, 0x8, 0x3, 0x2);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = FUN_8019d2c(r0);
    r0 = FUN_8019da8(r0, 0, 3, 1);
    FUN_80209d0(r8, 0x8073864);
    r3 = CPU.movT(0, 0x7);
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    FUN_801e41c(r8, 0x12, 0, 0x12, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get() + 0xea3;
    r1 = MEMORY.ref(1, CPU.sp().value + 0xc).getUnsigned();
    r2 = MEMORY.ref(1, CPU.sp().value + 0x24).getUnsigned();
    MEMORY.ref(1, r3).setu(r1);
    MEMORY.ref(1, r6).setu(r2);
    r0 = CPU.sp().value;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r0 = CPU.addT(r0, 0x5e);

    //LAB_8020c74
    do {
      r3 = MEMORY.ref(1, r2).getUnsigned();
      r2 = CPU.addT(r2, 0x1);
      MEMORY.ref(1, r1).setu(r3);
      r1 = CPU.addT(r1, 0x1);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r3 = CPU.addT(r3, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
      }

      //LAB_8020c8c
      r1 = CPU.cmpT(r1, r0);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r1 + 0xe).setu(r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    FUN_8020b64(r0, r1);
    r0 = FUN_8004080();
    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x12);
    r7 = CPU.movT(0, 0x5);
    CPU.cmpT(r5, 0x5f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r1 = CPU.movT(0, 0x80);
      r0 = FUN_8003fa4(r0, r1, 0x80310a4); //TODO
      r1 = CPU.movT(0, 0x80);
      r3 = CPU.movT(0, 0x0);
      r1 = CPU.lslT(r1, 23);
      r0 = CPU.addT(r5, 0x0);
      r2 = r8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = FUN_801eadc(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r2 = CPU.sp().value + 0x40;
      r5 = CPU.addT(r0, 0x0);
      MEMORY.ref(4, r2).setu(r5);
      r3 = r8;
      r11 = r2;
      r1 = MEMORY.ref(2, r3 + 0xc).getUnsigned();
      r2 = MEMORY.ref(2, r3 + 0xe).getUnsigned();
      r1 = CPU.lslT(r1, 3);
      r2 = CPU.lslT(r2, 3);
      r1 = CPU.addT(r1, 0x8c);
      r2 = CPU.addT(r2, 0x34);
      r0 = r11;
      FUN_80b0038(r0, r1, r2);
    } else {
      //LAB_8020ce2
      r1 = CPU.sp().value + 0x40;
      r11 = r1;
    }

    //LAB_8020ce6
    r0 = FUN_8004080();
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x5f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r1 = CPU.movT(0, 0x80);
      r0 = FUN_8003fa4(r0, r1, 0x80317e4); //TODO
      r1 = CPU.movT(0, 0x80);
      r1 = CPU.lslT(r1, 23);
      r3 = CPU.movT(0, 0x0);
      r0 = CPU.addT(r5, 0x0);
      r2 = r8;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r0 = FUN_801eadc(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r2 = CPU.movT(0, 0x30);
      r5 = CPU.addT(r0, 0x0);
      r2 += CPU.sp().value;
      MEMORY.ref(4, r2).setu(r5);
      r3 = CPU.movT(0, 0xff);
      MEMORY.ref(1, r5 + 0xf).setu(r3);
      r10 = r2;
      r3 = CPU.movT(0, 0xd);
      r2 = MEMORY.ref(1, r5 + 0x19).getUnsigned();
      r3 = CPU.negT(r3, r3);
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(1, r5 + 0x19).setu(r3);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      r0 = FUN_8020b14(r0);
      r1 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, 0x46);
      r0 = r10;
      r2 = CPU.movT(0, 0x16);
      FUN_80b0038(r0, r1, r2);
    } else {
      //LAB_8020d68
      r1 = CPU.sp().value + 0x30;
      r10 = r1;
    }

    //LAB_8020d6c
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(0x50001c0);
    DMA.channels[3].CNT.setu(0x84000008);

    MEMORY.ref(2, 0x50001c8).setu(0x6318);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
    r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r2 = CPU.addT(r2, r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);

    jmp_8021034:
    {
      //LAB_8020d86
      do {
        r5 = CPU.movT(0, 0x1);
        CPU.cmpT(r6, 0x12);
        if(CPU.cpsr().getZero()) { // ==
          CPU.cmpT(r7, 0x4);
          if(CPU.cpsr().getZero()) { // ==
            r5 = CPU.movT(0, 0x3);
          }

          //LAB_8020d92
          CPU.cmpT(r7, 0x5);
          if(CPU.cpsr().getZero()) { // ==
            r5 = CPU.movT(0, 0x3);
          }
        }

        //LAB_8020db0
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xe);
        FUN_80030f8(0x1);
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xf);
        r3 = r9;
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0x0);
          r2 = r8;
          r9 = r1;
          r1 = MEMORY.ref(2, r2 + 0xc).getUnsigned();
          r2 = MEMORY.ref(2, r2 + 0xe).getUnsigned();
          r1 = CPU.addT(r1, r6);
          r2 = CPU.addT(r2, r7);
          r1 = CPU.lslT(r1, 3);
          r2 = CPU.lslT(r2, 3);
          r1 = CPU.subT(r1, 0x7);
          r2 = CPU.addT(r2, 0xf);
          r0 = r11;
          r3 = CPU.movT(0, 0x3);
          FUN_80b0030(r0, r1, r2, r3);
        }

        //LAB_8020e02
        r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
          r0 = FUN_8020b14(r0);
          r1 = CPU.addT(r0, 0x0);
          r1 = CPU.addT(r1, 0x46);
          r0 = r10;
          r2 = CPU.movT(0, 0x16);
          r3 = CPU.movT(0, 0x3);
          FUN_80b0030(r0, r1, r2, r3);
        }

        //LAB_8020e20
        r0 = r11;
        FUN_80b0020(r0);
        r0 = r10;
        FUN_80b0028(r0);
        r0 = _3001800.get();
        r3 = r10;
        r5 = MEMORY.ref(4, r3).get();
        r2 = CPU.movT(0, 0x7);
        r0 = CPU.lsrT(r0, 1);
        r0 = CPU.andT(r0, r2);
        r3 = MEMORY.ref(1, 0x80371f6 + r0).get(); //TODO
        r1 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        r1 = CPU.addT(r1, r3);
        r1 = CPU.andT(r1, 0x1ff);
        r3 = MEMORY.ref(2, r5 + 0x16).getUnsigned();
        r3 = CPU.andT(r3, ~0x1ff);
        r3 = CPU.orrT(r3, r1);
        r0 = CPU.addT(r0, 0x5);
        r1 = CPU.movT(0, 0x7);
        r0 = CPU.andT(r0, r1);
        MEMORY.ref(2, r5 + 0x16).setu(r3);
        r2 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
        r3 = MEMORY.ref(1, 0x80371f6 + r0).getUnsigned(); //TODO
        r2 = CPU.addT(r2, r3);
        MEMORY.ref(1, r5 + 0x14).setu(r2);
        r2 = _3001b04.get();
        r3 = CPU.movT(0, 0x40);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.movT(0, 0x6f);
          FUN_80f9010(r0);
          r2 = CPU.movT(0, 0x1);
          r9 = r2;
          r7 = CPU.subT(r7, 0x1);
          CPU.cmpT(r6, 0x12);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.movT(0, 0x1);
            r3 = CPU.negT(r3, r3);
            r7 = CPU.cmpT(r7, r3);
            if(CPU.cpsr().getZero()) { // ==
              r7 = CPU.movT(0, 0x5);
            }
          } else {
            //LAB_8020e9c
            r3 = CPU.movT(0, 0x3);
            r3 = CPU.eorT(r3, r7);
            r2 = CPU.negT(r2, r3);
            r2 = CPU.orrT(r2, r3);
            r7 = CPU.lsrT(r2, 31);
            r3 = CPU.movT(0, 0x5);
            r7 = CPU.subT(r3, r7);
          }
        }

        //LAB_8020eaa
        r2 = _3001b04.get();
        r3 = CPU.movT(0, 0x80);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.movT(0, 0x6f);
          FUN_80f9010(r0);
          r1 = CPU.movT(0, 0x1);
          r9 = r1;
          r7 = CPU.addT(r7, 0x1);
          CPU.cmpT(r6, 0x12);
          if(!CPU.cpsr().getZero()) { // !=
            CPU.cmpT(r7, 0x6);
            if(CPU.cpsr().getZero()) { // ==
              r7 = CPU.movT(0, 0x0);
            }
          } else {
            //LAB_8020ecc
            r2 = CPU.movT(0, 0x6);
            r2 = CPU.eorT(r2, r7);
            r3 = CPU.negT(r3, r2);
            r3 = CPU.orrT(r3, r2);
            r7 = CPU.lsrT(r3, 31);
            r7 = CPU.addT(r7, 0x4);
          }
        }

        //LAB_8020ed8
        r2 = _3001b04.get();
        r3 = CPU.movT(0, 0x20);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.movT(0, 0x6f);
          FUN_80f9010(r0);
          r3 = CPU.movT(0, 0x1);
          r2 = CPU.movT(0, 0x1);
          r6 = CPU.subT(r6, 0x1);
          r3 = CPU.negT(r3, r3);
          r9 = r2;
          r6 = CPU.cmpT(r6, r3);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.subT(r7, 0x4);
            r6 = CPU.movT(0, 0x12);
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = CPU.movT(0, 0x10);
            }
          } else {
            //LAB_8020f02
            if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
              //LAB_8020f0e
              r6 = CPU.subT(r6, 0x1);
            }
          }
        }

        //LAB_8020f12
        r2 = _3001b04.get();
        r3 = CPU.movT(0, 0x10);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.movT(0, 0x6f);
          FUN_80f9010(r0);
          r6 = CPU.addT(r6, 0x1);
          r1 = CPU.movT(0, 0x1);
          r9 = r1;
          CPU.cmpT(r6, 0x13);
          if(CPU.cpsr().getZero()) { // ==
            r6 = CPU.movT(0, 0x0);
          } else {
            //LAB_8020f30
            if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
              //LAB_8020f3c
              r6 = CPU.addT(r6, 0x1);
            }
          }

          //LAB_8020f3e
          CPU.cmpT(r6, 0x12);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.subT(r7, 0x4);
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = CPU.movT(0, 0x0);
            }
          }
        }

        //LAB_8020f4a
        if((pressedButtons_3001c94.get() & 0x8) != 0) { // Start
          r0 = CPU.movT(0, 0x6f);
          FUN_80f9010(r0);
          r2 = CPU.movT(0, 0x1);
          r9 = r2;
          r6 = CPU.movT(0, 0x12);
          r7 = CPU.movT(0, 0x5);
        }

        jmp_8020f76:
        {
          //LAB_8020f64
          r5 = _3001b04.get();
          r3 = CPU.movT(0, 0x2);
          r5 = CPU.andT(r5, r3);
          CPU.cmpT(r5, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_8020fa6
            r3 = _3001b04.get();
            r1 = CPU.movT(0, 0x1);
            r3 = CPU.andT(r3, r1);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              continue;
            }

            //LAB_8020fb2
            r0 = CPU.movT(0, 0x70);
            FUN_80f9010(r0);
            CPU.cmpT(r6, 0x12);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_8020fe6
              r3 = r8;
              r2 = MEMORY.ref(2, r3 + 0xc).getUnsigned();
              r3 = MEMORY.ref(2, r3 + 0xe).getUnsigned();
              r3 = CPU.addT(r3, r7);
              r2 = CPU.addT(r2, r6);
              r3 = CPU.addT(r3, 0x1);
              r2 = CPU.addT(r2, 0x1);
              r3 = CPU.lslT(r3, 5);
              r3 = CPU.addT(r3, r2);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r3 = CPU.lslT(r3, 1);
              r3 = MEMORY.ref(1, r3 + r1).getUnsigned();
              CPU.cmpT(r2, 0x5);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_8021006
                r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r2 = CPU.addT(r2, 0x1);
                MEMORY.ref(1, r1).setu(r3);
                r1 = CPU.addT(r1, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
                MEMORY.ref(1, r1).setu(r5);
                MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
                CPU.cmpT(r2, 0x5);
                if(CPU.cpsr().getZero()) { // ==
                  r2 = CPU.movT(0, 0x1);
                  r6 = CPU.movT(0, 0x12);
                  r7 = CPU.movT(0, 0x5);
                  r9 = r2;
                }

                //LAB_8021020
                r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                FUN_8016478(r0);
                r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                FUN_8020b64(r0, r1);
                r3 = CPU.movT(0, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
              }
              continue;
            }
            CPU.cmpT(r7, 0x5);
            if(CPU.cpsr().getZero()) { // ==
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              CPU.cmpT(r2, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8020d34
                r3 = r10;
                r2 = MEMORY.ref(4, r3).get();
                r3 = CPU.movT(0, 0xd);
                MEMORY.ref(1, r2 + 0x5).setu(r3);
                r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                FUN_8016478(r0);
                r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                FUN_8020b64(r0, r1);
                r0 = CPU.movT(0, 0xa);
                FUN_80030f8(r0);
              } else {
                //LAB_8020fc8
                r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r0 = CPU.movT(0, 0x0);

                //LAB_8020fce
                do {
                  r3 = MEMORY.ref(1, r1).getUnsigned();
                  r0 = CPU.addT(r0, 0x1);
                  MEMORY.ref(1, r2).setu(r3);
                  r1 = CPU.addT(r1, 0x1);
                  r2 = CPU.addT(r2, 0x1);
                  CPU.cmpT(r0, 0xe);
                } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
              }
              break jmp_8021034;
            }

            //LAB_8020fde
            CPU.cmpT(r7, 0x4);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_8020fe4
              break jmp_8020f76;
            }
            continue;
          }
          r0 = CPU.movT(0, 0x71);
          FUN_80f9010(r0);
        }

        //LAB_8020f76
        r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r3 = CPU.subT(r3, 0x1);
          MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
          r1 = CPU.subT(r1, 0x1);
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
          MEMORY.ref(1, r1).setu(r3);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          FUN_8016478(r0);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          FUN_8020b64(r0, r1);
          r2 = CPU.movT(0, 0x1);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
          continue;
        }

        break;
      } while(true);

      //LAB_8020f9e
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.negT(r3, r3);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
    }

    //LAB_8021034
    r0 = r8;
    r1 = CPU.movT(0, 0x2);
    FUN_8016418(r0, r1);
    r1 = CPU.movT(0, 0x2);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    FUN_8016418(r0, r1);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    FUN_8019e48(r0);
    r0 = CPU.movT(0, 0x1);
    FUN_80030f8(r0);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
    CPU.sp().value += 0x60;

    return r0;
  }
}
