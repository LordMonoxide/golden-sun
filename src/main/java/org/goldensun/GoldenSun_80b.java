package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.RecoveryQueue10c;
import org.goldensun.types.Unit14c;

import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.setDjinn_;
import static org.goldensun.GoldenSun_807.recoverDjinn_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  /** {@link GoldenSun_80b#FUN_80b08b8} */
  @Method(0x80b0020)
  public static void FUN_80b0020(final int r0) {
    MEMORY.call(0x80b08b8, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b0958} */
  @Method(0x80b0028)
  public static void FUN_80b0028(final int r0) {
    MEMORY.call(0x80b0958, r0);
  }

  /** {@link GoldenSun_80b#FUN_80b09fc} */
  @Method(0x80b0030)
  public static void FUN_80b0030(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x80b09fc, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_80b#FUN_80b0a20} */
  @Method(0x80b0038)
  public static void FUN_80b0038(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b0a20, r0, r1, r2);
  }

  /** {@link GoldenSun_80b#FUN_80b06c0} */
  @Method(0x80b0040)
  public static void FUN_80b0040(final int r0, final int r1, final int r2) {
    MEMORY.call(0x80b06c0, r0, r1, r2);
  }
  @Method(0x80b06c0)
  public static void FUN_80b06c0(int r0, int r1, final int r2) {
    int r3;
    int r4;

    r3 = r1 << 4;
    r1 = r3 + 0x1;
    if(r0 > 0x0) {
      r4 = 0x80b4100;

      //LAB_80b06cc
      do {
        r3 = MEMORY.ref(2, r4).getUnsigned();
        r0 = r0 - 0x1;
        r3 = r2 + r3;
        r4 = r4 + 0x2;
        MEMORY.ref(1, r3 + 0x4).setu(r1);
        MEMORY.ref(1, r3 + 0x8).setu(r1);
        MEMORY.ref(1, r3 + 0xc).setu(r1);
        MEMORY.ref(1, r3 + 0x10).setu(r1);
        MEMORY.ref(1, r3 + 0x14).setu(r1);
        MEMORY.ref(1, r3 + 0x18).setu(r1);
      } while(r0 != 0x0);
    }
  }

  @Method(0x80b08b8)
  public static void FUN_80b08b8(final int r0) {
    if(r0 != 0) {
      final int r10 = MEMORY.ref(1, r0 + 0xd).get();
      if(r10 != 0) {
        final int r8 = MEMORY.ref(4, r0).get();
        MEMORY.ref(1, r0 + 0xc).incr();
        MEMORY.ref(2, r8 + 0x6).setu(MEMORY.ref(2, r0 + 0x4).getUnsigned() + divideS(MEMORY.ref(1, r0 + 0xc).get() * MEMORY.ref(2, r0 + 0x8).get() - MEMORY.ref(2, r0 + 0x4).get(), CPU.r10().value));
        MEMORY.ref(2, r8 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r8 + 0x6).getUnsigned() & 0x1ff);
        final int r5 = MEMORY.ref(2, r0 + 0x6).getUnsigned() + divideS(MEMORY.ref(1, r0 + 0xc).get() * (MEMORY.ref(2, r0 + 0xa).get() - MEMORY.ref(2, r0 + 0x6).get()), CPU.r10().value);
        MEMORY.ref(2, r8 + 0x8).setu(r5);
        MEMORY.ref(1, r8 + 0x14).setu(r5);

        if(MEMORY.ref(1, r0 + 0xc).get() == r10) {
          MEMORY.ref(1, r0 + 0xd).setu(0);
          MEMORY.ref(1, r0 + 0xc).setu(0);
        }
      }
    }

    //LAB_80b094a
  }

  @Method(0x80b0958)
  public static void FUN_80b0958(int r0) {
    int r2;
    int r3;
    final int r4;
    final int r5;

    r5 = r0;
    r4 = MEMORY.ref(4, r5).get();
    if(r4 != 0) {
      r2 = MEMORY.ref(2, r4 + 0x6).getUnsigned();
      r0 = r2 - MEMORY.ref(2, r5 + 0x8).get();
      r3 = Math.abs(r0 / 4);

      //LAB_80b097a
      if(r0 > 0) {
        if(r3 != 0) {
          r3 = r2 - r3;
        } else {
          //LAB_80b0986
          r3 = r2 - 1;
        }

        MEMORY.ref(2, r4 + 0x6).setu(r3);
        MEMORY.ref(2, r4 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r4 + 0x6).getUnsigned() & 0x1ff);
      } else {
        //LAB_80b098c
        if(r0 < 0) {
          if(r3 != 0) {
            r3 = r2 + r3;
          } else {
            //LAB_80b0998
            r3 = r2 + 1;
          }

          //LAB_80b099a
          MEMORY.ref(2, r4 + 0x6).setu(r3);
          MEMORY.ref(2, r4 + 0x16).and(~0x1ff).oru(MEMORY.ref(2, r4 + 0x6).getUnsigned() & 0x1ff);
        }
      }

      //LAB_80b09ac
      r2 = MEMORY.ref(2, r4 + 0x8).getUnsigned();
      r0 = r2 - MEMORY.ref(2, r5 + 0xa).get();
      r3 = Math.abs(r0 / 4);

      //LAB_80b09c4
      if(r0 > 0) {
        if(r3 != 0) {
          r3 = r2 - r3;
        } else {
          //LAB_80b09d0
          r3 = r2 - 1;
        }

        MEMORY.ref(2, r4 + 0x8).setu(r3);
        MEMORY.ref(1, r4 + 0x14).setu(MEMORY.ref(2, r4 + 0x8).getUnsigned());
      } else {
        //LAB_80b09d6
        if(r0 < 0) {
          if(r3 != 0) {
            r3 = r2 + r3;
          } else {
            //LAB_80b09e2
            r3 = r2 + 1;
          }

          //LAB_80b09e4
          MEMORY.ref(2, r4 + 0x8).setu(r3);
          MEMORY.ref(1, r4 + 0x14).setu(MEMORY.ref(2, r4 + 0x8).getUnsigned());
        }
      }
    }

    //LAB_80b09ea
  }

  @Method(0x80b09fc)
  public static void FUN_80b09fc(final int r0, final int r1, final int r2, final int r3) {
    final int r5 = MEMORY.ref(4, r0).get();
    MEMORY.ref(2, r0 + 0x4).setu(MEMORY.ref(2, r5 + 0x6).getUnsigned());
    MEMORY.ref(2, r0 + 0x6).setu(MEMORY.ref(2, r5 + 0x8).getUnsigned());
    MEMORY.ref(2, r0 + 0x8).setu(r1);
    MEMORY.ref(2, r0 + 0xa).setu(r2);
    MEMORY.ref(1, r0 + 0xd).setu(r3);
    MEMORY.ref(1, r0 + 0xc).setu(0);
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

  /** {@link GoldenSun_80b#FUN_80b6a60} */
  @Method(0x80b50c8)
  public static int FUN_80b50c8(final int r0) {
    return (int)MEMORY.call(0x80b6a60, r0);
  }

  /** {@link GoldenSun_80b#FUN_80bf5a8} */
  @Method(0x80b50f8)
  public static int FUN_80b50f8() {
    return (int)MEMORY.call(0x80bf5a8);
  }

  /** {@link GoldenSun_80b#FUN_80be0b4} */
  @Method(0x80b5130)
  public static int FUN_80b5130(final int r0, final int r1) {
    return (int)MEMORY.call(0x80be0b4, r0, r1);
  }

  @Method(0x80b6a60)
  public static int FUN_80b6a60(final int r0) {
    final int r3 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).offset(1, 0x44).getUnsigned();
    final int maxCharCount;
    if(r3 != 0) {
      maxCharCount = 3;
    } else {
      maxCharCount = 4;
    }

    //LAB_80b6a7a
    final int charCount = Math.min(maxCharCount, getCharCount_());

    //LAB_80b6a86
    //LAB_80b6a98
    for(int charSlot = 0; charSlot < charCount; charSlot++) {
      final int charId = charIds_2000438.get(charSlot).get();

      if(r0 != 0) {
        MEMORY.ref(2, r0 + charSlot * 0x2).setu(charId);
      }

      //LAB_80b6aa4
      getCharOrMonsterData_(charId)._12a.set(2);
    }

    //LAB_80b6abc
    if(r0 != 0) {
      MEMORY.ref(2, r0 + charCount * 0x2).setu(0xff);
    }

    //LAB_80b6ac4
    return charCount;
  }

  @Method(0x80be0b4)
  public static int FUN_80be0b4(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80bf5a8)
  public static int FUN_80bf5a8() {
    final RecoveryQueue10c queue = getDjinnRecoveryQueue_(0);
    int r2 = 0;

    //LAB_80bf5ce
    for(int r8 = 0; r8 < queue.count_108.get(); r8++) {
      if(queue._08.get(r8)._03.get() > 0) {
        final Unit14c r0 = getCharOrMonsterData_(queue._08.get(r8).charId_02.get());
        if(r0.hp_38.get() != 0) {
          queue._08.get(r8)._03.decr();
        }
      }

      //LAB_80bf5ee
    }

    //LAB_80bf600
    //LAB_80bf612
    for(int r8 = 0; r8 < queue.count_108.get(); ) {
      if(queue._08.get(r8)._03.get() == 0) {
        final int charId = queue._08.get(r8).charId_02.get();
        setDjinn_(charId, queue._08.get(r8).element_00.get(), queue._08.get(r8).djinn_01.get());
        recoverDjinn_(charId, queue._08.get(r8).element_00.get(), queue._08.get(r8).djinn_01.get());
        recalcStats_(charId);
        r2 = 1;
      } else {
        //LAB_80bf63a
        r8++;
      }

      //LAB_80bf640
    }

    //LAB_80bf64c
    return r2;
  }
}
