package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.GraphicsStruct24;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class Decompressed877dd1c {
  private Decompressed877dd1c() { }

  @Method(0x20080e8)
  public static int FUN_20080e8() {
    return 0x200d0e4;
  }

  @Method(0x20080f0)
  public static int FUN_20080f0() {
    return 0;
  }

  @Method(0x20080f4)
  public static int FUN_20080f4() {
    return 0x200d27c;
  }

  @Method(0x20080fc)
  public static int FUN_20080fc() {
    return 0x200d2b8;
  }

  @Method(0x2008104)
  public static int FUN_2008104() {
    return 0x200d558;
  }

  @Method(0x200810c)
  public static void FUN_200810c() {
    FUN_200c6e4(0x210);
    FUN_200c6ac(0x28, 0x54, 0x7, 0x4, 0xa, 0x54);
  }

  @Method(0x2008434)
  public static int FUN_2008434() {
    FUN_200c8a4(0xaa);
    FUN_200c78c(0x17, 0, 0);

    if(FUN_200c6dc(0x109) != 0) {
      FUN_200c6ec(0x205);
      FUN_200c6ec(0x206);
    }

    //LAB_2008462
    if(FUN_200c6dc(0x830) != 0) {
      FUN_200c78c(0xb, 0x14e0000, 0x3a40000);
      FUN_2008ec4();
    }

    //LAB_2008480
    if(FUN_200c6dc(0x831) != 0) {
      FUN_200c78c(0xc, 0xe00000, 0x3680000);
      FUN_20090a4();
    }

    //LAB_200849c
    if(FUN_200c6dc(0x832) != 0) {
      FUN_200c78c(0xd, 0x400000, 0x2bf0000);
      FUN_20092f0();
    }

    //LAB_20084b6
    if(FUN_200c6dc(0x833) != 0) {
      FUN_200c78c(0xe, 0x1b00000, 0x47b0000);
      FUN_2009498();
    }

    //LAB_20084d0
    getActor(0xb)._59.or(0x4);
    getActor(0xc)._59.or(0x4);
    getActor(0xd)._59.or(0x4);
    getActor(0xe)._59.or(0x4);
    getActor(0xf)._59.or(0x4);
    getActor(0x10)._59.or(0x4);
    getActor(0x11)._59.or(0x4);
    getActor(0x12)._59.or(0x4);

    if(FUN_200c6dc(0x837) != 0) {
      FUN_200c78c(0x16, 0, 0);
    }

    //LAB_2008556
    final Actor70 actor19 = getActor(19);
    actor19._18.set(0x20000);
    actor19._1c.set(0x20000);

    if(FUN_200c6dc(0x838) != 0) {
      FUN_200c78c(0x13, 0x720000, 0x14d0000);
    } else {
      //LAB_200857c
      FUN_200c744(0x13, 0x200c9f4);
    }

    //LAB_2008584
    if(FUN_200c6dc(0x841) != 0) {
      //LAB_2008590
      FUN_200c0f0();
      FUN_200c78c(0x9, 0xa50000, 0x4cd0000);
      final Actor70 actor9 = getActor(9);
      actor9.angle_06.set(0xe000);
      actor9._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      actor9._66.set(0x1);
      FUN_200c744(0x9, 0x200cec8);
      FUN_200c78c(0x1a, 0xa50000, 0x4e60000);
      final Actor70 actor26 = getActor(26);
      actor26.angle_06.set(0xe000);
      actor26._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      actor26._66.set(0x2);
      FUN_200c744(0x1a, 0x200cec8);
      FUN_200c78c(0x16, 0x980000, 0x5050000);
      final Actor70 actor22 = getActor(22);
      actor22.angle_06.set(0xe000);
      actor22._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      actor22._66.set(0x3);
      FUN_200c744(0x16, 0x200cec8);
      FUN_200c78c(0x8, 0xb80000, 0x5180000);
      final Actor70 actor8 = getActor(8);
      actor8.angle_06.set(0xe000);
      actor8._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      actor8._66.set(4);
      FUN_200c744(0x8, 0x200cec8);
      setActorAnimationIfLoaded_(0x8, 0x6);
      getActor(0x16).flags_23.and(0xfe);
      getActor(0x8).flags_23.and(0xfe);
      setTickCallback(getRunnable(Decompressed877dd1c.class, "FUN_200c5b8"), 0xc80);
      FUN_200c78c(0x18, 0, 0);
      FUN_200c78c(0x19, 0, 0);
      FUN_200c78c(0x17, 0, 0);
      FUN_200c78c(0x13, 0, 0);

      if(FUN_200c6dc(0x842) != 0) {
        //LAB_20086dc
        FUN_200c78c(0x16, 0, 0);
      }
      //LAB_20086e0
    } else if(FUN_200c6dc(0x83a) != 0) {
      //LAB_20086ec
      FUN_200c78c(0xa, 0xc00000, 0x4be0000);
      FUN_200c7fc(0xa, 0x2000, 0);
      setActorAnimationIfLoaded_(0xa, 0x5);
      getActor(10)._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      FUN_200c744(0xa, 0x200cec8);
      FUN_200c78c(0x18, 0xe30000, 0x4be0000);
      FUN_200c7fc(0x18, 0x4000, 0);
      setActorAnimationIfLoaded_(0x18, 0x6);
      getActor(24)._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      FUN_200c744(0x18, 0x200cec8);
      FUN_200c78c(0x19, 0xf70000, 0x4be0000);
      FUN_200c7fc(0x19, 0x4000, 0);
      setActorAnimationIfLoaded_(0x19, 0x6);
      getActor(25)._64.set(FUN_200c634(rand(), 0x5a) + 0x3c);
      FUN_200c744(0x19, 0x200cec8);
      FUN_200c78c(0x17, 0xf30000, 0x4fd0000);
      FUN_200c7fc(0x17, 0xc000, 0);
      FUN_200c6b4(getActor(23), 0);
      FUN_200c78c(0x11, 0, 0);
      FUN_200c78c(0x12, 0, 0);
    } else {
      //LAB_2008840
      FUN_200c78c(0x11, 0, 0);
      FUN_200c78c(0x12, 0, 0);
    }

    //LAB_2008854
    if(MEMORY.ref(2, 0x2000240 + 0x1c2).get() != 0xf || FUN_200c6dc(0x87b) != 0) {
      //LAB_200886e
      FUN_200c84c();
      FUN_200c854();
    }

    //LAB_2008876
    if(FUN_200c6dc(0x210) != 0) {
      FUN_200810c();
    }

    //LAB_2008886
    FUN_200c6e4(0x834);
    FUN_200c6ac(0x1d, 0x18, 0x1, 0x2, 0x1a, 0x2e);
    FUN_200c6ac(0x1d, 0x19, 0x1, 0x1, 0x1b, 0x2e);
    FUN_200c6ac(0x1d, 0x19, 0x1, 0x1, 0x1c, 0x2e);
    FUN_200c6ac(0x13, 0x5a, 0x1, 0x1, 0x14, 0x58);
    FUN_200c6ac(0x13, 0x5a, 0x1, 0x1, 0x14, 0x59);

    final Actor70 actor21 = getActor(21);
    actor21._55.set(0);
    actor21.pos_08.setY(0xc00000);
    actor21._59.set(0x8);
    FUN_200c6b4(actor21, 0);

    sleep(1);

    if(FUN_200c6dc(0x87b) == 0 && MEMORY.ref(2, 0x2000240 + 0x1c2).get() == 0xf) {
      FUN_2008a10();
    } else {
      //LAB_2008930
      setActorAnimationIfLoaded_(0x17, 0x7);

      if(FUN_200c6dc(0x837) == 0) {
        FUN_200c6fc();
        FUN_200c814(0x16, 0x101);
        FUN_200c78c(0x16, 0x1900000, 0x2630000);
        FUN_200c78c(0x15, 0x1a80000, 0x2730000);
        FUN_200c774(0x16, 0x190, 0x26b);
        FUN_200c77c(0x15, 0x1a8, 0x26b);
        setActorAnimationIfLoaded_(0x15, 0x2);
        setActorAnimationIfLoaded_(0x16, 0x5);
        FUN_200c704();
      } else {
        //LAB_2008994
        FUN_200c6fc();
        FUN_200c78c(0x15, 0x1a80000, 0x2730000);
        FUN_200c77c(0x15, 0x1a8, 0x26b);
        setActorAnimationIfLoaded_(0x15, 0x3);
        FUN_200c704();
      }

      //LAB_20089bc
      final int r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).get();
      MEMORY.ref(4, r1 + 0x1c0).setu(0x100);
      MEMORY.ref(4, r1 + 0x1c8).setu(0x18);
      FUN_200c884();
      FUN_200c88c();
      FUN_200c86c();
    }

    //LAB_20089de
    return 0;
  }

  @Method(0x2008a10)
  public static void FUN_2008a10() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    FUN_200c6fc();
    FUN_200c84c();
    FUN_200c854();
    FUN_200c864();
    sleep(60);
    r0 = CPU.movT(0, 0x80);
    r1 = CPU.movT(0, 0x80);
    r0 = CPU.lslT(r0, 7);
    r1 = CPU.lslT(r1, 4);
    FUN_200c81c(r0, r1);
    r0 = CPU.movT(0, 0x9e);
    r1 = CPU.movT(0, 0xa0);
    r2 = CPU.movT(0, 0xdc);
    r3 = CPU.movT(0, 0x1);
    r0 = CPU.lslT(r0, 17);
    r1 = CPU.lslT(r1, 16);
    r2 = CPU.lslT(r2, 18);
    FUN_200c824(r0, r1, r2, r3);
    r1 = CPU.movT(0, 0x93);
    r2 = CPU.movT(0, 0xd9);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.lslT(r1, 17);
    r2 = CPU.lslT(r2, 18);
    FUN_200c78c(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x0);
    FUN_200c78c(r0, r1, r2);
    r3 = MEMORY.ref(4, 0x2008d10).get();
    r1 = MEMORY.ref(4, r3).get();
    r3 = CPU.movT(0, 0xe0);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.subT(r3, 0xc0);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.addT(r3, 0xc8);
    r2 = CPU.addT(r1, r3);
    r3 = CPU.movT(0, 0x10);
    MEMORY.ref(4, r2).setu(r3);
    FUN_200c884();
    FUN_200c88c();
    FUN_200c86c();
    r0 = CPU.movT(0, 0x9e);
    FUN_200c8b4(r0);
    r2 = CPU.movT(0, 0x2c);
    r0 = MEMORY.ref(4, 0x2008d14).get();
    r1 = CPU.movT(0, 0x32);
    FUN_200c68c(r0, r1, r2);
    r0 = CPU.movT(0, 0x16);
    r1 = MEMORY.ref(4, 0x2008d18).get();
    FUN_200c814(r0, r1);
    r0 = CPU.movT(0, 0x9);
    r1 = MEMORY.ref(4, 0x2008d1c).get();
    r2 = MEMORY.ref(4, 0x2008d20).get();
    FUN_200c73c(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(4, 0x2008d1c).get();
    r2 = MEMORY.ref(4, 0x2008d20).get();
    FUN_200c73c(r0, r1, r2);
    r0 = CPU.movT(0, 0xa);
    r1 = MEMORY.ref(4, 0x2008d1c).get();
    r2 = MEMORY.ref(4, 0x2008d20).get();
    FUN_200c73c(r0, r1, r2);
    r1 = CPU.movT(0, 0xab);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 17);
    r2 = MEMORY.ref(4, 0x2008d24).get();
    FUN_200c78c(r0, r1, r2);
    r1 = CPU.movT(0, 0xab);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x2008d28).get();
    FUN_200c77c(r0, r1, r2);
    FUN_200c8ac();
    r1 = CPU.movT(0, 0x94);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x2008d28).get();
    FUN_200c774(r0, r1, r2);
    r1 = CPU.movT(0, 0xab);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 17);
    r2 = MEMORY.ref(4, 0x2008d24).get();
    FUN_200c78c(r0, r1, r2);
    r1 = CPU.movT(0, 0xab);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x2008d2c).get();
    FUN_200c774(r0, r1, r2);
    r1 = CPU.movT(0, 0xab);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x2008d28).get();
    FUN_200c77c(r0, r1, r2);
    r1 = CPU.movT(0, 0x9f);
    r2 = MEMORY.ref(4, 0x2008d28).get();
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 1);
    FUN_200c77c(r0, r1, r2);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x1);
    setActorAnimationIfLoaded_(r0, r1);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x1);
    FUN_200c7b4(r0, r1);
    r1 = CPU.movT(0, 0xc0);
    r2 = CPU.movT(0, 0x3c);
    r1 = CPU.lslT(r1, 8);
    r0 = CPU.movT(0, 0x9);
    FUN_200c7fc(r0, r1, r2);
    r5 = MEMORY.ref(4, 0x2008d30).get();
    r0 = CPU.addT(r5, 0x0);
    FUN_200c7d4(r0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7e4(r0, r1);
    r1 = CPU.movT(0, 0x93);
    r2 = MEMORY.ref(4, 0x2008d34).get();
    r1 = CPU.lslT(r1, 1);
    r0 = CPU.movT(0, 0xa);
    FUN_200c77c(r0, r1, r2);
    r0 = CPU.movT(0, 0x28);
    FUN_200c6f4(r0);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x4);
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7e4(r0, r1);
    r1 = CPU.movT(0, 0x9);
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    FUN_200c7c4(r0, r1, r2);
    r0 = CPU.movT(0, 0x28);
    FUN_200c6f4(r0);
    r1 = CPU.movT(0, 0x80);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.lslT(r1, 7);
    r2 = CPU.movT(0, 0x0);
    FUN_200c7fc(r0, r1, r2);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x14);
    FUN_200c7ec(r0, r1, r2);
    r0 = CPU.movT(0, 0x9);
    r1 = MEMORY.ref(4, 0x2008d18).get();
    r2 = CPU.movT(0, 0x14);
    FUN_200c80c(r0, r1, r2);
    r1 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 8);
    r2 = CPU.movT(0, 0xa);
    FUN_200c7fc(r0, r1, r2);
    r2 = CPU.movT(0, 0xa);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7ec(r0, r1, r2);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x4);
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7e4(r0, r1);
    r1 = CPU.movT(0, 0x81);
    r1 = CPU.lslT(r1, 1);
    r0 = CPU.movT(0, 0x9);
    FUN_200c814(r0, r1);
    r0 = CPU.movT(0, 0x1e);
    FUN_200c6f4(r0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x32);
    FUN_200c7fc(r0, r1, r2);
    r1 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 8);
    r2 = CPU.movT(0, 0xa);
    FUN_200c7fc(r0, r1, r2);
    r1 = CPU.movT(0, 0xc0);
    r2 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 9);
    r2 = CPU.lslT(r2, 8);
    FUN_200c73c(r0, r1, r2);
    r0 = CPU.movT(0, 0x9);
    r1 = MEMORY.ref(4, 0x2008d38).get();
    r2 = MEMORY.ref(4, 0x2008d3c).get();
    FUN_200c77c(r0, r1, r2);
    r1 = CPU.movT(0, 0xe0);
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.lslT(r1, 8);
    FUN_200c7fc(r0, r1, r2);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7e4(r0, r1);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x2);
    FUN_200c7b4(r0, r1);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7e4(r0, r1);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x4);
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0xa);
    FUN_200c7ec(r0, r1, r2);
    r1 = CPU.movT(0, 0x80);
    r2 = CPU.movT(0, 0xa);
    r1 = CPU.lslT(r1, 6);
    r0 = CPU.movT(0, 0x9);
    r5 = CPU.addT(r5, 0x8);
    FUN_200c7fc(r0, r1, r2);
    r0 = CPU.addT(r5, 0x0);
    FUN_200c7d4(r0);
    r0 = CPU.movT(0, 0x9);
    FUN_200c7dc(r0);
    r1 = CPU.movT(0, 0x97);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x2008d28).get();
    FUN_200c77c(r0, r1, r2);
    r1 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.lslT(r1, 8);
    r2 = CPU.movT(0, 0x0);
    FUN_200c7fc(r0, r1, r2);

    //LAB_2008c5c
    //LAB_2008c72
    while(FUN_200c724(0, 0) == 1) {
      r1 = CPU.movT(0, 0x1);
      r0 = CPU.movT(0, 0x9);
      FUN_200c7b4(r0, r1);
      r0 = MEMORY.ref(4, 0x2008d40).get();
      FUN_200c7d4(r0);
      r0 = CPU.movT(0, 0x9);
      FUN_200c7dc(r0);
    }

    r1 = CPU.movT(0, 0x3);
    r0 = CPU.movT(0, 0x9);
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r0 = MEMORY.ref(4, 0x2008d44).get();
    FUN_200c7d4(r0);
    r2 = CPU.movT(0, 0xa);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    FUN_200c7ec(r0, r1, r2);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x3);
    setActorAnimationAndWaitUntilFinished(r0, r1);
    r1 = CPU.movT(0, 0xc0);
    r2 = CPU.movT(0, 0xc0);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.lslT(r1, 9);
    r2 = CPU.lslT(r2, 8);
    FUN_200c73c(r0, r1, r2);
    r1 = MEMORY.ref(4, 0x2008d48).get();
    r2 = MEMORY.ref(4, 0x2008d4c).get();
    r0 = CPU.movT(0, 0xa);
    FUN_200c774(r0, r1, r2);
    r0 = CPU.movT(0, 0xa);
    FUN_200c6f4(r0);
    r0 = CPU.movT(0, 0x9);
    r1 = MEMORY.ref(4, 0x2008d48).get();
    r2 = MEMORY.ref(4, 0x2008d4c).get();
    FUN_200c77c(r0, r1, r2);
    r0 = CPU.movT(0, 0x9);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x0);
    FUN_200c78c(r0, r1, r2);
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x0);
    FUN_200c78c(r0, r1, r2);
    r0 = CPU.movT(0, 0xa);
    r1 = CPU.movT(0, 0x1);
    setActorAnimationIfLoaded_(r0, r1);
    r0 = CPU.movT(0, 0x15);
    r1 = CPU.movT(0, 0x2);
    setActorAnimationIfLoaded_(r0, r1);
    r1 = CPU.movT(0, 0x5);
    r0 = CPU.movT(0, 0x16);
    setActorAnimationIfLoaded_(r0, r1);
    r0 = MEMORY.ref(4, 0x2008d50).get();
    FUN_200c6ec(r0);
    r0 = MEMORY.ref(4, 0x2008d54).get();
    FUN_200c6e4(r0);
    r0 = MEMORY.ref(4, 0x2008d58).get();
    FUN_200c6e4(r0);
    FUN_200c704();
  }

  @Method(0x2008ec4)
  public static void FUN_2008ec4() {
    FUN_200c6ac(0x1d, 0x40, 0x1, 0x1, 0x15, 0x39);
    FUN_200c6ac(0x1d, 0x40, 0x1, 0x1, 0x15, 0x3a);
    FUN_200c6ac(0x1d, 0x40, 0x1, 0x1, 0x16, 0x3a);
    FUN_200c6ac(0x1d, 0x40, 0x1, 0x1, 0x14, 0x3a);
    FUN_200c6ac(0x1c, 0x14, 0x1, 0x1, 0x14, 0x39);
  }

  @Method(0x20090a4)
  public static void FUN_20090a4() {
    FUN_200c6ac(0x1d, 0x17, 0x1, 0x1, 0xf, 0x35);
    FUN_200c6ac(0x1d, 0x17, 0x1, 0x1, 0xe, 0x35);
    FUN_200c6ac(0x1d, 0x17, 0x1, 0x1, 0xd, 0x35);
    FUN_200c6ac(0x1a, 0x14, 0x2, 0x1, 0xe, 0x34);
    FUN_200c6ac(0x19, 0x15, 0x1, 0x1, 0xd, 0x36);
    FUN_200c6ac(0x19, 0x15, 0x1, 0x1, 0xf, 0x36);
    FUN_200c6ac(0xe, 0x35, 0x1, 0x1, 0xe, 0x36);
    FUN_200c6ac(0xd, 0x37, 0x1, 0x1, 0xf, 0x37);
  }

  @Method(0x20092f0)
  public static void FUN_20092f0() {
    FUN_200c6ac(0x1d, 0x16, 0x1, 0x1, 0x3, 0x2a);
    FUN_200c6ac(0x1d, 0x15, 0x1, 0x1, 0x2, 0x2a);
    FUN_200c6ac(0x1d, 0x15, 0x1, 0x1, 0x4, 0x2a);
    FUN_200c6ac(0x17, 0x14, 0x3, 0x1, 0x2, 0x2b);
  }

  @Method(0x2009498)
  public static void FUN_2009498() {
    FUN_200c6ac(0x1d, 0x14, 0x1, 0x1, 0x1a, 0x47);
    FUN_200c6ac(0x1d, 0x14, 0x1, 0x1, 0x1a, 0x46);
    FUN_200c6ac(0x1d, 0x14, 0x1, 0x1, 0x1b, 0x46);
    FUN_200c6ac(0x1c, 0x15, 0x1, 0x1, 0x1c, 0x47);
    FUN_200c6ac(0x1c, 0x16, 0x1, 0x1, 0x1b, 0x48);
  }

  @Method(0x200c0f0)
  public static void FUN_200c0f0() {
    FUN_200c694(0x10, 0x60, 0xb, 0x49, 0x6, 0x3);
    FUN_200c694(0x10, 0x60, 0x22, 0x44, 0xe, 0xa);
    FUN_200c694(0x10, 0x60, 0x40, 0x44, 0x7, 0x7);
    FUN_200c694(0x9, 0x5f, 0xb, 0x49, 0x6, 0x3);
    FUN_200c694(0x28, 0x5e, 0x22, 0x44, 0xe, 0xa);
    FUN_200c694(0x36, 0x5e, 0x40, 0x44, 0x8, 0x7);
    FUN_200c694(0x48, 0x4b, 0x48, 0x4c, 0x1, 0x1);
    FUN_200c694(0x48, 0x4b, 0x4a, 0x4c, 0x1, 0x1);
    FUN_200c6ac(0x7, 0x4b, 0x1, 0x1, 0x6, 0x4b);
    FUN_200c6ac(0x8, 0x46, 0x3, 0x1, 0x8, 0x47);
    FUN_200c6ac(0x8, 0x46, 0x2, 0x1, 0x48, 0x48);
    FUN_200c6ac(0x8, 0x46, 0x2, 0x1, 0x9, 0x49);
    FUN_200c6ac(0xb, 0x42, 0x1, 0x1, 0x8, 0x49);
    FUN_200c6ac(0xc, 0x42, 0x1, 0x4, 0xb, 0x49);
    FUN_200c6ac(0x19, 0x0, 0x1, 0x1, 0x6, 0x4a);
    FUN_200c684();
  }

  /** {@link CopiedSegment8000770#FUN_30003e0} */
  @Method(0x200c634)
  public static int FUN_200c634(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e0, r0, r1);
  }

  /** {@link GoldenSun#sleep_} */
  @Method(0x200c63c)
  public static void sleep(final int frames) {
    MEMORY.call(0x80000c0, frames);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200c644)
  public static void setTickCallback(@Nullable final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80000d0, callback, classAndPriority);
  }

  /** {@link GoldenSun#rand_} */
  @Method(0x200c654)
  public static int rand() {
    return (int)MEMORY.call(0x80000f8);
  }

  /** {@link GoldenSun#FUN_800fe9c} */
  @Method(0x200c684)
  public static void FUN_200c684() {
    MEMORY.call(0x800fe9c);
  }

  /** {@link GoldenSun#FUN_8009178} */
  @Method(0x200c68c)
  public static void FUN_200c68c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8009178, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8010424} */
  @Method(0x200c694)
  public static void FUN_200c694(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8010424, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#FUN_8010704} */
  @Method(0x200c6ac)
  public static void FUN_200c6ac(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8010704, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun#FUN_80091e0} */
  @Method(0x200c6b4)
  public static void FUN_200c6b4(final Actor70 r0, final int r1) {
    MEMORY.call(0x80091e0, r0, r1);
  }

  /** {@link GoldenSun_807#FUN_8079338} */
  @Method(0x200c6dc)
  public static int FUN_200c6dc(final int r0) {
    return (int)MEMORY.call(0x8079338, r0);
  }

  /** {@link GoldenSun_807#FUN_80770c8} */
  @Method(0x200c6e4)
  public static void FUN_200c6e4(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#FUN_8079374} */
  @Method(0x200c6ec)
  public static void FUN_200c6ec(final int r0) {
    MEMORY.call(0x8079374, r0);
  }

  /** {@link GoldenSun_808#FUN_808a010} */
  @Method(0x200c6f4)
  public static void FUN_200c6f4(final int r0) {
    MEMORY.call(0x808a010, r0);
  }

  /** {@link GoldenSun_808#FUN_808a018} */
  @Method(0x200c6fc)
  public static void FUN_200c6fc() {
    MEMORY.call(0x808a018);
  }

  /** {@link GoldenSun_808#FUN_808a020} */
  @Method(0x200c704)
  public static void FUN_200c704() {
    MEMORY.call(0x808a020);
  }

  /** {@link GoldenSun_808#FUN_808a070} */
  @Method(0x200c724)
  public static int FUN_200c724(final int r0, final int r1) {
    return (int)MEMORY.call(0x808a070, r0, r1);
  }

  /** {@link GoldenSun_809#getActor_} */
  @Method(0x200c72c)
  public static Actor70 getActor(final int actorIndex) {
    return (Actor70)MEMORY.call(0x8092054, actorIndex);
  }

  /** {@link GoldenSun_808#FUN_808a090} */
  @Method(0x200c73c)
  public static void FUN_200c73c(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a090, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_809207c} */
  @Method(0x200c744)
  public static void FUN_200c744(final int actorIndex, final int r1) {
    MEMORY.call(0x809207c, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a0c8} */
  @Method(0x200c774)
  public static void FUN_200c774(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0c8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0d0} */
  @Method(0x200c77c)
  public static void FUN_200c77c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a0d0, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a0f0} */
  @Method(0x200c78c)
  public static void FUN_200c78c(final int actorIndex, final int x, final int z) {
    MEMORY.call(0x808a0f0, actorIndex, x, z);
  }

  /** {@link GoldenSun_809#setActorAnimationIfLoaded} */
  @Method(0x200c794)
  public static void setActorAnimationIfLoaded_(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x80924d4, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#setActorAnimationAndWaitUntilFinished_} */
  @Method(0x200c79c)
  public static void setActorAnimationAndWaitUntilFinished(final int actorIndex, final int animationIndex) {
    MEMORY.call(0x808a110, actorIndex, animationIndex);
  }

  /** {@link GoldenSun_808#FUN_808a138} */
  @Method(0x200c7b4)
  public static void FUN_200c7b4(final int actorIndex, final int r1) {
    MEMORY.call(0x808a138, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a150} */
  @Method(0x200c7c4)
  public static void FUN_200c7c4(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a150, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a170} */
  @Method(0x200c7d4)
  public static void FUN_200c7d4(final int r0) {
    MEMORY.call(0x808a170, r0);
  }

  /** {@link GoldenSun_808#FUN_808a178} */
  @Method(0x200c7dc)
  public static GraphicsStruct24 FUN_200c7dc(final int r0) {
    return (GraphicsStruct24)MEMORY.call(0x808a178, r0);
  }

  /** {@link GoldenSun_808#FUN_808a180} */
  @Method(0x200c7e4)
  public static void FUN_200c7e4(final int r0, final int r1) {
    MEMORY.call(0x808a180, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a188} */
  @Method(0x200c7ec)
  public static void FUN_200c7ec(final int r0, final int r1, final int r2) {
    MEMORY.call(0x808a188, r0, r1, r2);
  }

  /** {@link GoldenSun_809#FUN_8092adc} */
  @Method(0x200c7fc)
  public static void FUN_200c7fc(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x8092adc, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1e8} */
  @Method(0x200c80c)
  public static void FUN_200c80c(final int actorIndex, final int r1, final int r2) {
    MEMORY.call(0x808a1e8, actorIndex, r1, r2);
  }

  /** {@link GoldenSun_808#FUN_808a1f0} */
  @Method(0x200c814)
  public static void FUN_200c814(final int actorIndex, final int r1) {
    MEMORY.call(0x808a1f0, actorIndex, r1);
  }

  /** {@link GoldenSun_808#FUN_808a208} */
  @Method(0x200c81c)
  public static void FUN_200c81c(final int r0, final int r1) {
    MEMORY.call(0x808a208, r0, r1);
  }

  /** {@link GoldenSun_808#FUN_808a210} */
  @Method(0x200c824)
  public static void FUN_200c824(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x808a210, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_808#FUN_808a2c0} */
  @Method(0x200c84c)
  public static void FUN_200c84c() {
    MEMORY.call(0x808a2c0);
  }

  /** {@link GoldenSun_808#FUN_808a2c8} */
  @Method(0x200c854)
  public static void FUN_200c854() {
    MEMORY.call(0x808a2c8);
  }

  /** {@link GoldenSun_808#FUN_808a2d8} */
  @Method(0x200c864)
  public static void FUN_200c864() {
    MEMORY.call(0x808a2d8);
  }

  /** {@link GoldenSun_808#FUN_808a2e0} */
  @Method(0x200c86c)
  public static void FUN_200c86c() {
    MEMORY.call(0x808a2e0);
  }

  /** {@link GoldenSun_808#FUN_808a360} */
  @Method(0x200c884)
  public static void FUN_200c884() {
    MEMORY.call(0x808a360);
  }

  /** {@link GoldenSun_808#FUN_808a370} */
  @Method(0x200c88c)
  public static void FUN_200c88c() {
    MEMORY.call(0x808a370);
  }

  /** {@link GoldenSun_808#FUN_808a5e0} */
  @Method(0x200c8a4)
  public static void FUN_200c8a4(final int r0) {
    MEMORY.call(0x808a5e0, r0);
  }

  /** {@link GoldenSun_808#FUN_808a5e8} */
  @Method(0x200c8ac)
  public static void FUN_200c8ac() {
    MEMORY.call(0x808a5e8);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x200c8b4)
  public static void FUN_200c8b4(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
