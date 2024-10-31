package org.goldensun;

import org.goldensun.memory.Method;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

/** Maybe the game engine */
public final class Decompressed8787e04 {
  private Decompressed8787e04() { }

  @Method(0x2008088)
  public static int FUN_2008088() {
    return 0x2009fd0;
  }

  @Method(0x20080b8)
  public static int FUN_20080b8() {
    int r0;
    int r2;
    int r3;
    final int r5;

    r3 = MEMORY.ref(4, 0x20080fc).get();
    r2 = CPU.movT(0, 0xe1);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x13);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, 0x2008100).get();
    } else {
      //LAB_20080ce
      r0 = MEMORY.ref(4, 0x2008104).get();
      r0 = FUN_20098ec(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = MEMORY.ref(4, 0x2008108).get();
      } else {
        //LAB_20080dc
        r0 = MEMORY.ref(4, 0x200810c).get();
        r0 = FUN_20098ec(r0);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r5 = MEMORY.ref(4, 0x2008110).get();
        } else {
          //LAB_20080ea
          r5 = MEMORY.ref(4, 0x2008114).get();
        }
      }

      //LAB_20080ec
      r0 = CPU.addT(r5, 0x0);
      FUN_200991c(r0);
      r0 = CPU.addT(r5, 0x0);
    }

    //LAB_20080f4
    return r0;
  }

  @Method(0x2008160)
  public static int FUN_2008160() {
    final int r0;
    if(MEMORY.ref(2, 0x2000402).get() == 19) {
      if(FUN_20098ec(0x950) != 0) {
        r0 = 0x200ac5c;
      } else {
        //LAB_2008182
        r0 = 0x200ab9c;
      }
      //LAB_2008186
    } else if(FUN_20098ec(0x834) != 0) {
      r0 = 0x200a5a8;
      //LAB_2008194
    } else if(FUN_20098ec(0x87a) != 0) {
      r0 = 0x200a980;
      //LAB_20081a2
    } else if(FUN_20098ec(0x815) != 0) {
      r0 = 0x200a800;
    } else {
      //LAB_20081b0
      r0 = 0x200a6b0;
    }

    //LAB_20081b2
    return r0;
  }

  @Method(0x20083f8)
  public static int FUN_20083f8() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r5;

    r3 = MEMORY.ref(4, 0x2008558).get();
    r2 = CPU.movT(0, 0xe1);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x13);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, 0x200855c).get();
      FUN_20098fc(r0);
      r3 = MEMORY.ref(4, 0x2008560).get();
      r2 = CPU.movT(0, 0xe0);
      r3 = MEMORY.ref(4, r3).get();
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r2 = CPU.addT(r2, 0x49);
      MEMORY.ref(4, r3).setu(r2);
    } else {
      //LAB_2008420
      r0 = MEMORY.ref(4, 0x2008564).get();
      r0 = FUN_20098ec(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0xb);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
        r0 = CPU.movT(0, 0xc);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
        r0 = CPU.movT(0, 0xd);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
        r0 = CPU.movT(0, 0xe);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
        r0 = CPU.movT(0, 0xf);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
        r0 = CPU.movT(0, 0x10);
        r1 = CPU.movT(0, 0x0);
        r2 = CPU.movT(0, 0x0);
        FUN_2009974(r0, r1, r2);
      } else {
        //LAB_2008468
        FUN_20093b4();
      }

      //LAB_200846c
      r0 = CPU.movT(0, 0xd);
      r1 = CPU.movT(0, 0x1);
      FUN_20099fc(r0, r1);
      r0 = MEMORY.ref(4, 0x2008568).get();
      r0 = FUN_20098ec(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0x11);
        r0 = FUN_200992c(r0);
        r1 = CPU.movT(0, 0x0);
        FUN_20098a4(r0, r1);
        r3 = MEMORY.ref(4, 0x2008558).get();
        r2 = CPU.movT(0, 0xe1);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.addT(r3, r2);
        r3 = MEMORY.ref(2, r3).getUnsigned();
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.subT(r3, 0x6);
        r3 = CPU.lslT(r3, 16);
        r2 = CPU.lslT(r2, 9);
        r3 = CPU.cmpT(r3, r2);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = MEMORY.ref(4, 0x200856c).get();
          r0 = FUN_20098ec(r0);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(4, 0x2008570).get();
            r0 = FUN_20098ec(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.movT(0, 0xc);
              FUN_2009884(r0);
            }
          } else {
            //LAB_20084bc
            r0 = CPU.movT(0, 0xb);
            FUN_2009884(r0);
            r0 = CPU.movT(0, 0x8);
            r0 = FUN_200992c(r0);
            r1 = CPU.movT(0, 0x0);
            FUN_20098a4(r0, r1);
            r0 = CPU.movT(0, 0x8);
            r1 = CPU.movT(0, 0xa);
            FUN_200997c(r0, r1);
          }
        }
      } else {
        //LAB_20084d8
        r3 = MEMORY.ref(4, 0x2008558).get();
        r2 = CPU.movT(0, 0xe1);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.addT(r3, r2);
        r2 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r3 + r2).get();
        CPU.cmpT(r3, 0x15);
        if(CPU.cpsr().getZero()) { // ==
          FUN_2008a0c();
        } else {
          //LAB_20084ee
          CPU.cmpT(r3, 0x14);
          if(CPU.cpsr().getZero()) { // ==
            r0 = MEMORY.ref(4, 0x2008564).get();
            FUN_20098f4(r0);
            FUN_2008578();
          } else {
            //LAB_20084fe
            CPU.cmpT(r3, 0x16);
            if(CPU.cpsr().getZero()) { // ==
              FUN_20093e4();
            } else {
              //LAB_2008508
              r5 = MEMORY.ref(4, 0x2008560).get();
              r2 = CPU.movT(0, 0xe0);
              r3 = MEMORY.ref(4, r5).get();
              r2 = CPU.lslT(r2, 1);
              r3 = CPU.addT(r3, r2);
              r2 = CPU.addT(r2, 0x49);
              MEMORY.ref(4, r3).setu(r2);
              r0 = MEMORY.ref(4, 0x2008564).get();
              r0 = FUN_20098ec(r0);
              CPU.cmpT(r0, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                FUN_2009a3c();
                r3 = MEMORY.ref(4, r5 + 0xc).get();
                r2 = MEMORY.ref(4, 0x2008574).get();
                r3 = CPU.addT(r3, r2);
                r2 = CPU.movT(0, 0x1);
                MEMORY.ref(2, r3).setu(r2);
                FUN_2009a4c();
                r0 = CPU.movT(0, 0x1e);
                FUN_2009814(r0);
                FUN_2009a5c();
                FUN_2009a6c();
                FUN_2009a54();
              } else {
                //LAB_2008546
                FUN_200986c();
                r0 = CPU.movT(0, 0x1);
                FUN_2009814(r0);
              }
            }
          }
        }
      }
    }

    //LAB_2008550
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x2008578)
  public static void FUN_2008578() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r9;
    final int r10;

    r2 = boardWramMallocHead_3001e50.offset(27 * 0x4).getAddress();
    r9 = r2;
    r3 = MEMORY.ref(4, r2).get();
    r2 = CPU.subT(r2, 0x4c);
    r7 = MEMORY.ref(4, r2).get();
    r2 = CPU.movT(0, 0xf0);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r0 = CPU.movT(0, 0x11);
    r6 = MEMORY.ref(4, r3).get();
    r0 = FUN_200992c(r0);
    r0 = MEMORY.ref(4, r0 + 0x50).get();
    r8 = r0;
    FUN_200990c();
    FUN_2009974(0xb, 0, 0);
    FUN_2009974(0xc, 0, 0);
    FUN_2009974(0xd, 0, 0);
    FUN_2009974(0xe, 0, 0);
    FUN_2009974(0xf, 0, 0);
    FUN_2009974(0x10, 0, 0);
    FUN_20098a4(FUN_200992c(0), 0);
    FUN_200997c(0, 0x12);
    r10 = 0;
    MEMORY.ref(2, r8 + 0x1e).setu(0x555);
    r0 = FUN_200992c(0x11) + 0x55;
    MEMORY.ref(1, r0).setu(0);
    FUN_20098a4(FUN_200992c(0x11), 0);
    FUN_2009974(0x11, 0x2400000, 0x28a0000);
    FUN_2009884(0x7);
    FUN_2009974(0x8, 0x2160000, 0x2b00000);
    FUN_20098b4();
    FUN_20099f4(0x8);
    r5 = 0xe52;
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.addT(r5, 0x0);
    r2 = CPU.movT(0, 0x0);
    FUN_20098dc(r0, r1, r2);
    r0 = CPU.movT(0, 0x28);
    FUN_2009904(r0);
    r0 = CPU.movT(0, 0x80);
    r1 = CPU.movT(0, 0x80);
    r2 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 9);
    r2 = CPU.lslT(r2, 9);
    r0 = CPU.lslT(r0, 9);
    FUN_20098ac(r0, r1, r2);
    FUN_20099f4(0x8);
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.addT(r5, 0x1);
    r2 = CPU.movT(0, 0x0);
    FUN_20098dc(r0, r1, r2);
    FUN_20098bc();
    r0 = CPU.movT(0, 0x28);
    FUN_2009904(r0);
    r2 = CPU.addT(r7, 0x0);
    r3 = CPU.movT(0, 0xa4);
    r2 = CPU.addT(r2, 0xec);
    r3 = CPU.lslT(r3, 17);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.movT(0, 0x96);
    r2 = CPU.addT(r2, 0x4);
    r3 = CPU.lslT(r3, 18);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.movT(0, 0x9c);
    r2 = CPU.addT(r2, 0x4);
    r3 = CPU.lslT(r3, 18);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.movT(0, 0xcc);
    r2 = CPU.addT(r2, 0x4);
    r3 = CPU.lslT(r3, 18);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.movT(0, 0x8d);
    r3 = CPU.lslT(r3, 18);
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = r10;
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = MEMORY.ref(4, 0x20089cc).get();
    MEMORY.ref(4, r6 + 0x10).setu(r3);
    FUN_200986c();
    r0 = CPU.movT(0, 0x1);
    FUN_2009814(r0);
    r2 = r9;
    r1 = MEMORY.ref(4, r2).get();
    r3 = CPU.movT(0, 0xe0);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.addT(r3, 0x49);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.subT(r3, 0x41);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.movT(0, 0x40);
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009a3c();
    r2 = r9;
    r3 = MEMORY.ref(4, r2 + 0xc).get();
    r2 = MEMORY.ref(4, 0x20089d0).get();
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r3).setu(r2);
    FUN_2009a4c();
    r0 = CPU.movT(0, 0x1e);
    FUN_2009814(r0);
    r5 = CPU.addT(r5, 0x2);
    FUN_2009a5c();
    FUN_2009a6c();
    FUN_2009a54();
    r1 = CPU.movT(0, 0x4);
    r0 = CPU.movT(0, 0x8);
    FUN_2009984(r0, r1);
    r0 = CPU.addT(r5, 0x0);
    FUN_20099c4(r0);
    r2 = CPU.movT(0, 0x3c);
    r0 = MEMORY.ref(4, 0x20089d4).get();
    r1 = CPU.movT(0, 0x0);
    FUN_20099dc(r0, r1, r2);
    r1 = CPU.movT(0, 0x2);
    r0 = CPU.movT(0, 0x0);
    FUN_200999c(r0, r1);
    r0 = CPU.movT(0, 0x28);
    FUN_2009904(r0);
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.movT(0, 0x8);
    FUN_200999c(r0, r1);
    r0 = CPU.movT(0, 0x28);
    FUN_2009904(r0);
    r2 = CPU.movT(0, 0x14);
    r0 = MEMORY.ref(4, 0x20089d4).get();
    r1 = CPU.movT(0, 0x0);
    FUN_20099dc(r0, r1, r2);
    r1 = CPU.movT(0, 0x2);
    r0 = CPU.movT(0, 0x0);
    FUN_200999c(r0, r1);
    r0 = CPU.movT(0, 0x7);
    FUN_200988c(r0);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r0 = CPU.movT(0, 0x8);
    FUN_2009884(r0);
    r1 = CPU.movT(0, 0x80);
    r2 = CPU.movT(0, 0x80);
    r2 = CPU.lslT(r2, 8);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 9);
    FUN_2009934(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x13);
    FUN_200997c(r0, r1);
    r1 = MEMORY.ref(4, 0x20089d8).get();
    r2 = MEMORY.ref(4, 0x20089dc).get();
    r0 = CPU.movT(0, 0x0);
    FUN_200995c(r0, r1, r2);
    r0 = CPU.movT(0, 0x8);
    FUN_200988c(r0);
    r0 = CPU.movT(0, 0x9);
    FUN_2009884(r0);
    r2 = CPU.movT(0, 0xaa);
    r1 = MEMORY.ref(4, 0x20089e0).get();
    r2 = CPU.lslT(r2, 2);
    r0 = CPU.movT(0, 0x0);
    FUN_200995c(r0, r1, r2);
    r0 = CPU.movT(0, 0x1e);
    FUN_2009904(r0);
    r1 = CPU.movT(0, 0xd0);
    r2 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 8);
    r0 = CPU.movT(0, 0x8);
    FUN_20099ec(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r0 = FUN_200992c(r0);
    r1 = CPU.movT(0, 0x1);
    FUN_20098a4(r0, r1);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x4);
    r2 = CPU.movT(0, 0x0);
    FUN_200998c(r0, r1, r2);
    r2 = MEMORY.ref(4, 0x20089e4).get();
    r0 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(4, 0x20089e8).get();
    FUN_200996c(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x3);
    FUN_20099fc(r0, r1);
    r1 = CPU.movT(0, 0x80);
    r2 = CPU.movT(0, 0x28);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 7);
    FUN_20099ec(r0, r1, r2);
    r1 = CPU.movT(0, 0x4);
    r0 = CPU.movT(0, 0x8);
    FUN_2009984(r0, r1);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r0 = MEMORY.ref(4, 0x20089d4).get();
    r1 = CPU.movT(0, 0x0);
    FUN_20099d4(r0, r1);
    FUN_20097e4();
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.movT(0, 0x2);
    FUN_2009994(r0, r1);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x14);
    r0 = MEMORY.ref(4, 0x20089d4).get();
    FUN_20099dc(r0, r1, r2);
    r0 = CPU.movT(0, 0x8);
    r0 = FUN_200992c(r0);
    r0 = CPU.addT(r0, 0x5a);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r5 = CPU.movT(0, 0xfe);
    r3 = CPU.addT(r5, 0x0);
    r3 = CPU.andT(r3, r2);
    r2 = CPU.movT(0, 0xaa);
    r2 = CPU.lslT(r2, 2);
    MEMORY.ref(1, r0).setu(r3);
    r1 = MEMORY.ref(4, 0x20089ec).get();
    r0 = CPU.movT(0, 0x8);
    FUN_200996c(r0, r1, r2);
    r0 = CPU.movT(0, 0x1);
    FUN_2009904(r0);
    r0 = CPU.movT(0, 0x8);
    r0 = FUN_200992c(r0);
    r0 = CPU.addT(r0, 0x5a);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r6 = CPU.movT(0, 0x1);
    r3 = CPU.orrT(r3, r6);
    MEMORY.ref(1, r0).setu(r3);
    r0 = CPU.movT(0, 0xa);
    FUN_2009904(r0);
    r1 = CPU.movT(0, 0x2);
    r0 = CPU.movT(0, 0x8);
    FUN_200999c(r0, r1);
    r0 = CPU.movT(0, 0x0);
    r0 = FUN_200992c(r0);
    r1 = CPU.movT(0, 0xe2);
    FUN_20098c4(r0, r1);
    r0 = CPU.movT(0, 0x21);
    FUN_20098f4(r0);
    r0 = CPU.movT(0, 0x7e);
    FUN_2009aac(r0);
    r1 = CPU.movT(0, 0x7);
    r0 = CPU.movT(0, 0x0);
    FUN_20099b4(r0, r1);
    r0 = CPU.movT(0, 0xa);
    FUN_2009904(r0);
    r1 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    FUN_20099b4(r0, r1);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r0 = CPU.movT(0, 0x8);
    r0 = FUN_200992c(r0);
    r0 = CPU.addT(r0, 0x5a);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r2 = CPU.movT(0, 0xac);
    r5 = CPU.andT(r5, r3);
    r1 = MEMORY.ref(4, 0x20089f0).get();
    r2 = CPU.lslT(r2, 2);
    MEMORY.ref(1, r0).setu(r5);
    r0 = CPU.movT(0, 0x8);
    FUN_200996c(r0, r1, r2);
    r0 = CPU.movT(0, 0x1);
    FUN_2009904(r0);
    r0 = CPU.movT(0, 0x8);
    r0 = FUN_200992c(r0);
    r0 = CPU.addT(r0, 0x5a);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.orrT(r3, r6);
    MEMORY.ref(1, r0).setu(r3);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r1 = CPU.movT(0, 0xc0);
    r2 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.lslT(r1, 9);
    r2 = CPU.lslT(r2, 8);
    FUN_2009934(r0, r1, r2);
    r1 = CPU.movT(0, 0xc0);
    r2 = CPU.movT(0, 0xc0);
    r2 = CPU.lslT(r2, 8);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 9);
    FUN_2009934(r0, r1, r2);
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.movT(0, 0x8);
    FUN_2009a14(r0, r1);
    r0 = CPU.movT(0, 0x0);
    r0 = FUN_200992c(r0);
    r0 = CPU.addT(r0, 0x23);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r5 = MEMORY.ref(4, 0x20089f4).get();
    r6 = CPU.orrT(r6, r3);
    r1 = CPU.addT(r5, 0x0);
    MEMORY.ref(1, r0).setu(r6);
    r0 = CPU.movT(0, 0x8);
    FUN_200993c(r0, r1);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r1 = CPU.addT(r5, 0x0);
    r0 = CPU.movT(0, 0x0);
    FUN_200993c(r0, r1);
    r0 = CPU.movT(0, 0x8);
    FUN_2009944(r0);
    r0 = CPU.movT(0, 0x8);
    r1 = MEMORY.ref(4, 0x20089f8).get();
    r2 = MEMORY.ref(4, 0x20089fc).get();
    FUN_200996c(r0, r1, r2);
    r1 = CPU.movT(0, 0xcc);
    r2 = MEMORY.ref(4, 0x20089fc).get();
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.lslT(r1, 1);
    FUN_200996c(r0, r1, r2);
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.movT(0, 0x1);
    FUN_200997c(r0, r1);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x1);
    FUN_200997c(r0, r1);
    r1 = CPU.movT(0, 0x80);
    r0 = CPU.movT(0, 0x8);
    r1 = CPU.lslT(r1, 7);
    r2 = CPU.movT(0, 0xa);
    FUN_20099ec(r0, r1, r2);
    r1 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(4, 0x2008a00).get();
    FUN_20099cc(r0, r1);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);
    r0 = FUN_2009924(r0, r1);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = r9;
      r2 = MEMORY.ref(4, r3).get();
      r3 = CPU.movT(0, 0xec);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r2, r3);
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_200895a
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r2 = CPU.movT(0, 0x14);
    r0 = MEMORY.ref(4, 0x2008a00).get();
    r1 = CPU.movT(0, 0x0);
    FUN_20099dc(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x3);
    FUN_200997c(r0, r1);
    r1 = CPU.movT(0, 0x3);
    r0 = CPU.movT(0, 0x8);
    FUN_2009984(r0, r1);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r1 = MEMORY.ref(4, 0x2008a04).get();
    r0 = CPU.movT(0, 0x8);
    FUN_200993c(r0, r1);
    r1 = MEMORY.ref(4, 0x2008a08).get();
    r0 = CPU.movT(0, 0x0);
    FUN_200993c(r0, r1);
    r0 = CPU.movT(0, 0x14);
    FUN_2009904(r0);
    r2 = r9;
    r1 = MEMORY.ref(4, r2).get();
    r3 = CPU.movT(0, 0xe0);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.addT(r3, 0x41);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.subT(r3, 0x39);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.movT(0, 0x10);
    MEMORY.ref(4, r2).setu(r3);
    FUN_2009a64();
    FUN_2009a6c();
    r0 = CPU.movT(0, 0x14);
    FUN_2009a34(r0);
  }

  @Method(0x2008a0c)
  public static void FUN_2008a0c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x20093b4)
  public static void FUN_20093b4() {
    FUN_200987c(0x16, 0x55, 0x19, 0x55, 0x2, 0x2);
    FUN_200989c(0x19, 0xf, 0x2, 0x2, 0x19, 0x19);
  }

  @Method(0x20097e4)
  public static void FUN_20097e4() {
    int r0;
    int r1;

    r0 = CPU.movT(0, 0x94);
    r1 = CPU.movT(0, 0x1);
    FUN_2009a7c(r0, r1);
    r1 = CPU.movT(0, 0x11);
    r0 = CPU.movT(0, 0x8);
    FUN_2009a84(r0, r1);
    FUN_2009a9c();
    r0 = CPU.movT(0, 0x1);
    FUN_2009a74(r0);
    FUN_2009a8c();
    FUN_2009a94();
  }

  @Method(0x2009814)
  public static void FUN_2009814(final int r0) {
    MEMORY.call(0x80000c0, r0);
  }

  @Method(0x20093e4)
  public static void FUN_20093e4() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x200986c)
  public static void FUN_200986c() {
    MEMORY.call(0x8009128);
  }

  @Method(0x200987c)
  public static void FUN_200987c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8009180, r0, r1, r2, r3, a4, a5);
  }

  @Method(0x2009884)
  public static void FUN_2009884(final int r0) {
    MEMORY.call(0x8009188, r0);
  }

  @Method(0x200989c)
  public static void FUN_200989c(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80091c0, r0, r1, r2, r3, a4, a5);
  }

  @Method(0x20098a4)
  public static void FUN_20098a4(final int r0, final int r1) {
    MEMORY.call(0x80091e0, r0, r1);
  }

  @Method(0x20098ac)
  public static void FUN_20098ac(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80091f0, r0, r1, r2);
  }

  @Method(0x200988c)
  public static void FUN_200988c(final int r0) {
    MEMORY.call(0x8009190, r0);
  }

  @Method(0x20098b4)
  public static void FUN_20098b4() {
    MEMORY.call(0x8009208);
  }

  @Method(0x20098bc)
  public static void FUN_20098bc() {
    MEMORY.call(0x8009210);
  }

  @Method(0x20098c4)
  public static void FUN_20098c4(final int r0, final int r1) {
    MEMORY.call(0x8009228, r0, r1);
  }

  @Method(0x20098dc)
  public static void FUN_20098dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  @Method(0x20098ec)
  public static int FUN_20098ec(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  @Method(0x20098f4)
  public static void FUN_20098f4(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  @Method(0x20098fc)
  public static void FUN_20098fc(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  @Method(0x2009904)
  public static void FUN_2009904(final int r0) {
    MEMORY.call(0x808a010, r0);
  }

  @Method(0x200990c)
  public static void FUN_200990c() {
    MEMORY.call(0x808a018);
  }

  @Method(0x200991c)
  public static void FUN_200991c(final int r0) {
    MEMORY.call(0x808a03c, r0);
  }

  @Method(0x2009924)
  public static int FUN_2009924(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  @Method(0x200992c)
  public static int FUN_200992c(final int r0) {
    return (int)MEMORY.call(0x808a080, r0);
  }

  @Method(0x2009934)
  public static void FUN_2009934(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a090, r0, r1, r2);
  }

  @Method(0x200993c)
  public static void FUN_200993c(final int r0, final int r1) {
    MEMORY.call(0x808a098, r0, r1);
  }

  @Method(0x2009944)
  public static void FUN_2009944(final int r0) {
    MEMORY.call(0x808a0a0, r0);
  }

  @Method(0x200995c)
  public static void FUN_200995c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0c0, r0, r1, r2);
  }

  @Method(0x200996c)
  public static void FUN_200996c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0d0, r0, r1, r2);
  }

  @Method(0x2009974)
  public static void FUN_2009974(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a0f0, r0, r1, r2);
  }

  @Method(0x200997c)
  public static void FUN_200997c(final int r0, final int r1) {
    MEMORY.call(0x808a100, r0, r1);
  }

  @Method(0x2009984)
  public static void FUN_2009984(final int r0, final int r1) {
    MEMORY.call(0x808a110, r0, r1);
  }

  @Method(0x200998c)
  public static void FUN_200998c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a128, r0, r1, r2);
  }

  @Method(0x2009994)
  public static void FUN_2009994(final int r0, final int r1) {
    MEMORY.call(0x808a130, r0, r1);
  }

  @Method(0x200999c)
  public static void FUN_200999c(final int r0, final int r1) {
    MEMORY.call(0x808a138, r0, r1);
  }

  @Method(0x20099b4)
  public static void FUN_20099b4(final int r0, final int r1) {
    MEMORY.call(0x808a158, r0, r1);
  }

  @Method(0x20099c4)
  public static void FUN_20099c4(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  @Method(0x20099cc)
  public static void FUN_20099cc(final int r0, final int r1) {
    MEMORY.call(0x808a178, r0, r1);
  }

  @Method(0x20099d4)
  public static void FUN_20099d4(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  @Method(0x20099dc)
  public static void FUN_20099dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a188, r0, r1, r2);
  }

  @Method(0x20099ec)
  public static void FUN_20099ec(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a1b8, r0, r1, r2);
  }

  @Method(0x20099f4)
  public static void FUN_20099f4(final int r0) {
    MEMORY.call(0x808a1d8, r0);
  }

  @Method(0x20099fc)
  public static void FUN_20099fc(final int r0, final int r1) {
    MEMORY.call(0x808a1e0, r0, r1);
  }

  @Method(0x2009a14)
  public static void FUN_2009a14(final int r0, final int r1) {
    MEMORY.call(0x808a200, r0, r1);
  }

  @Method(0x2009a34)
  public static void FUN_2009a34(final int r0) {
    MEMORY.call(0x808a248, r0);
  }

  @Method(0x2009a3c)
  public static void FUN_2009a3c() {
    MEMORY.call(0x808a2c8);
  }

  @Method(0x2009a4c)
  public static void FUN_2009a4c() {
    MEMORY.call(0x808a2d8);
  }

  @Method(0x2009a54)
  public static void FUN_2009a54() {
    MEMORY.call(0x808a2e0);
  }

  @Method(0x2009a5c)
  public static void FUN_2009a5c() {
    MEMORY.call(0x808a360);
  }

  @Method(0x2009a64)
  public static void FUN_2009a64() {
    MEMORY.call(0x808a368);
  }

  @Method(0x2009a6c)
  public static void FUN_2009a6c() {
    MEMORY.call(0x808a370);
  }

  @Method(0x2009a74)
  public static void FUN_2009a74(final int r0) {
    MEMORY.call(0x808a420, r0);
  }

  @Method(0x2009a7c)
  public static void FUN_2009a7c(final int r0, final int r1) {
    MEMORY.call(0x808a428, r0, r1);
  }

  @Method(0x2009a84)
  public static void FUN_2009a84(final int r0, final int r1) {
    MEMORY.call(0x808a430, r0, r1);
  }

  @Method(0x2009a8c)
  public static void FUN_2009a8c() {
    MEMORY.call(0x808a438);
  }

  @Method(0x2009a94)
  public static void FUN_2009a94() {
    MEMORY.call(0x808a440);
  }

  @Method(0x2009a9c)
  public static void FUN_2009a9c() {
    MEMORY.call(0x808a448);
  }

  @Method(0x2009aac)
  public static void FUN_2009aac(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
