package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct24;
import org.goldensun.types.Struct194;
import org.goldensun.types.Struct38;
import org.goldensun.types.Struct70;

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
    if(MEMORY.ref(2, 0x2000402).get() == 0x13) {
      return 0x200a518;
    }

    //LAB_20080ce
    final int r5;
    if(FUN_20098ec(0x87a) != 0) {
      r5 = 0x200a410;
      //LAB_20080dc
    } else if(FUN_20098ec(0x815) != 0) {
      r5 = 0x200a338;
    } else {
      //LAB_20080ea
      r5 = 0x200a218;
    }

    //LAB_20080ec
    FUN_200991c(r5);

    //LAB_20080f4
    return r5;
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
    int r3;

    if(MEMORY.ref(2, 0x2000402).get() == 0x13) {
      FUN_20098fc(0x12f);
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x1c0).setu(0x209);
    } else {
      //LAB_2008420
      if(FUN_20098ec(0x834) != 0) {
        FUN_2009974(0xb, 0, 0);
        FUN_2009974(0xc, 0, 0);
        FUN_2009974(0xd, 0, 0);
        FUN_2009974(0xe, 0, 0);
        FUN_2009974(0xf, 0, 0);
        FUN_2009974(0x10, 0, 0);
      } else {
        //LAB_2008468
        FUN_20093b4();
      }

      //LAB_200846c
      FUN_20099fc(0xd, 0x1);

      if(FUN_20098ec(0x87a) != 0) {
        FUN_20098a4(FUN_200992c(0x11), 0);
        r3 = MEMORY.ref(2, 0x2000402).getUnsigned();
        r3 = CPU.subT(r3, 0x6);
        r3 = CPU.lslT(r3, 16);
        r3 = CPU.cmpT(r3, 0x10000);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          if(FUN_20098ec(0x109) != 0) {
            if(FUN_20098ec(0x203) != 0) {
              FUN_2009884(0xc);
            }
          } else {
            //LAB_20084bc
            FUN_2009884(0xb);
            FUN_20098a4(FUN_200992c(0x8), 0);
            FUN_200997c(0x8, 0xa);
          }
        }
      } else {
        //LAB_20084d8
        r3 = MEMORY.ref(2, 0x2000402).get();
        if(r3 == 0x15) {
          FUN_2008a0c();
          //LAB_20084ee
        } else if(r3 == 0x14) {
          FUN_20098f4(0x834);
          FUN_2008578();
          //LAB_20084fe
        } else if(r3 == 0x16) {
          FUN_20093e4();
        } else {
          //LAB_2008508
          boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x1c0).setu(0x209);

          if(FUN_20098ec(0x834) != 0) {
            FUN_2009a3c();
            boardWramMallocHead_3001e50.offset(120 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
            FUN_2009a4c();
            FUN_2009814(0x1e);
            FUN_2009a5c();
            FUN_2009a6c();
            FUN_2009a54();
          } else {
            //LAB_2008546
            FUN_200986c();
            FUN_2009814(0x1);
          }
        }
      }
    }

    //LAB_2008550
    return 0;
  }

  @Method(0x2008578)
  public static void FUN_2008578() {
    final int r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    final Struct194 r7 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Struct194::new);
    final int r6 = MEMORY.ref(4, r3 + 0x1e0).get();
    final Struct38 r8 = FUN_200992c(0x11)._50.deref();
    FUN_200990c();
    FUN_2009974(0xb, 0, 0);
    FUN_2009974(0xc, 0, 0);
    FUN_2009974(0xd, 0, 0);
    FUN_2009974(0xe, 0, 0);
    FUN_2009974(0xf, 0, 0);
    FUN_2009974(0x10, 0, 0);
    FUN_20098a4(FUN_200992c(0), 0);
    FUN_200997c(0, 0x12);
    r8._1e.set(0x555);
    FUN_200992c(0x11)._55.set(0);
    FUN_20098a4(FUN_200992c(0x11), 0);
    FUN_2009974(0x11, 0x2400000, 0x28a0000);
    FUN_2009884(0x7);
    FUN_2009974(0x8, 0x2160000, 0x2b00000);
    FUN_20098b4();
    FUN_20099f4(0x8);
    FUN_20098dc(0xe52, 0x1, 0);
    FUN_2009904(0x28);
    FUN_20098ac(0x10000, 0x10000, 0x10000);
    FUN_20099f4(0x8);
    FUN_20098dc(0xe53, 0x1, 0);
    FUN_20098bc();
    FUN_2009904(0x28);
    r7._ec.set(0x1480000);
    r7._f0.set(0x2580000);
    r7._f4.set(0x2700000);
    r7._f8.set(0x3300000);
    MEMORY.ref(4, r6 + 0x8).setu(0x2340000);
    MEMORY.ref(4, r6 + 0xc).setu(0);
    MEMORY.ref(4, r6 + 0x10).setu(0x2b30000);
    FUN_200986c();
    FUN_2009814(0x1);
    int r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    MEMORY.ref(4, r1 + 0x1c0).setu(0x209);
    MEMORY.ref(4, r1 + 0x1c8).setu(0x40);
    FUN_2009a3c();
    boardWramMallocHead_3001e50.offset(30 * 0x4).deref(4).offset(2, 0x1f84).setu(0x1);
    FUN_2009a4c();
    FUN_2009814(0x1e);
    FUN_2009a5c();
    FUN_2009a6c();
    FUN_2009a54();
    FUN_2009984(0x8, 0x4);
    FUN_20099c4(0xe54);
    FUN_20099dc(0x9008, 0, 0x3c);
    FUN_200999c(0, 0x2);
    FUN_2009904(0x28);
    FUN_200999c(0x8, 0x1);
    FUN_2009904(0x28);
    FUN_20099dc(0x9008, 0, 0x14);
    FUN_200999c(0, 0x2);
    FUN_200988c(0x7);
    FUN_2009904(0x14);
    FUN_2009884(0x8);
    FUN_2009934(0, 0x10000, 0x8000);
    FUN_200997c(0, 0x13);
    FUN_200995c(0, 0x22d, 0x2a7);
    FUN_200988c(0x8);
    FUN_2009884(0x9);
    FUN_200995c(0, 0x22b, 0x2a8);
    FUN_2009904(0x1e);
    FUN_20099ec(0x8, 0xd000, 0);
    FUN_20098a4(FUN_200992c(0), 0x1);
    FUN_200998c(0, 0x4, 0);
    FUN_200996c(0, 0x21f, 0x2a2);
    FUN_20099fc(0, 0x3);
    FUN_20099ec(0, 0x4000, 0x28);
    FUN_2009984(0x8, 0x4);
    FUN_2009904(0x14);
    FUN_20099d4(0x9008, 0);
    FUN_20097e4();
    FUN_2009994(0x8, 0x2);
    FUN_20099dc(0x9008, 0, 0x14);
    FUN_200992c(0x8)._5a.and(0xfe);
    FUN_200996c(0x8, 0x21e, 0x2a8);
    FUN_2009904(0x1);
    FUN_200992c(0x8)._5a.or(0x1);
    FUN_2009904(0xa);
    FUN_200999c(0x8, 0x2);
    FUN_20098c4(FUN_200992c(0), 0xe2);
    FUN_20098f4(0x21);
    FUN_2009aac(0x7e);
    FUN_20099b4(0, 0x7);
    FUN_2009904(0xa);
    FUN_20099b4(0, 0);
    FUN_2009904(0x14);
    FUN_200992c(0x8)._5a.add(0xfe);
    FUN_200996c(0x8, 0x216, 0x2b0);
    FUN_2009904(0x1);
    FUN_200992c(0x8)._5a.or(0x1);
    FUN_2009904(0x14);
    FUN_2009934(0x8, 0x18000, 0xc000);
    FUN_2009934(0, 0x18000, 0xc000);
    FUN_2009a14(0x8, 0x1);
    FUN_200992c(0)._23.or(0x1);
    FUN_200993c(0x8, 0x2009ab4);
    FUN_2009904(0x14);
    FUN_200993c(0, 0x2009ab4);
    FUN_2009944(0x8);
    FUN_200996c(0x8, 0x1a3, 0x295);
    FUN_200996c(0x8, 0x198, 0x295);
    FUN_200997c(0x8, 0x1);
    FUN_200997c(0, 0x1);
    FUN_20099ec(0x8, 0x4000, 0xa);
    FUN_20099cc(0x8008);

    if(FUN_2009924(0, 0) == 0) {
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(2, 0x1d8).incr();
    }

    //LAB_200895a
    FUN_2009904(0x14);
    FUN_20099dc(0x8008, 0, 0x14);
    FUN_200997c(0, 0x3);
    FUN_2009984(0x8, 0x3);
    FUN_2009904(0x14);
    FUN_200993c(0x8, 0x2009b04);
    FUN_200993c(0, 0x2009b34);
    FUN_2009904(0x14);
    r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
    MEMORY.ref(4, r1 + 0x1c0).setu(0x201);
    MEMORY.ref(4, r1 + 0x1c8).setu(0x10);
    FUN_2009a64();
    FUN_2009a6c();
    FUN_2009a34(0x14);
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
    FUN_2009a7c(0x94, 0x1);
    FUN_2009a84(0x8, 0x11);
    FUN_2009a9c();
    FUN_2009a74(0x1);
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
  public static void FUN_20098a4(final Struct70 r0, final int r1) {
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
  public static void FUN_20098c4(final Struct70 r0, final int r1) {
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
  public static Struct70 FUN_200992c(final int r0) {
    return (Struct70)MEMORY.call(0x808a080, r0);
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
  public static GraphicsStruct24 FUN_20099cc(final int r0) {
    return (GraphicsStruct24)MEMORY.call(0x808a178, r0);
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
