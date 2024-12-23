package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Menua70;
import org.goldensun.types.Panel24;
import org.goldensun.types.RecoveryQueue10c;
import org.goldensun.types.Structccc;
import org.goldensun.types.Unit14c;

import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.charIds_2000438;
import static org.goldensun.GoldenSun_801.FUN_8015018;
import static org.goldensun.GoldenSun_801.FUN_8015038;
import static org.goldensun.GoldenSun_801.FUN_8015048;
import static org.goldensun.GoldenSun_801.FUN_80150b0;
import static org.goldensun.GoldenSun_801.FUN_80150f8;
import static org.goldensun.GoldenSun_801.FUN_8015120;
import static org.goldensun.GoldenSun_801.FUN_8015140;
import static org.goldensun.GoldenSun_801.FUN_80153b0;
import static org.goldensun.GoldenSun_801.addPanel_;
import static org.goldensun.GoldenSun_801.drawIcon;
import static org.goldensun.GoldenSun_807.FUN_8077230;
import static org.goldensun.GoldenSun_807.FUN_807822c;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getCharCount_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.getPartyMemberIds_;
import static org.goldensun.GoldenSun_807.recalcStats_;
import static org.goldensun.GoldenSun_807.setDjinn_;
import static org.goldensun.GoldenSun_807.recoverDjinn_;
import static org.goldensun.GoldenSun_808.FUN_808a360;
import static org.goldensun.GoldenSun_808.FUN_808a368;
import static org.goldensun.GoldenSun_808.FUN_808a370;
import static org.goldensun.GoldenSun_808.FUN_808e118;
import static org.goldensun.GoldenSun_809.FUN_80915ac;
import static org.goldensun.GoldenSun_809.getMapActor_;
import static org.goldensun.GoldenSun_80a.FUN_80a1038;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80b {
  private GoldenSun_80b() { }

  /** {@link GoldenSun_80b#FUN_80b0278} */
  @Method(0x80b0008)
  public static int FUN_80b0008(final int r0, final int r1) {
    return (int)MEMORY.call(0x80b0278, r0, r1);
  }

  /** {@link GoldenSun_80b#FUN_80b3284} */
  @Method(0x80b0018)
  public static int FUN_80b0018(final int r0, final int mapActorIndex) {
    return (int)MEMORY.call(0x80b3284, r0, mapActorIndex);
  }

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

  @Method(0x80b010c)
  public static void FUN_80b010c() {
    int r0;

    CPU.sp().value -= 0x4;
    final int r5 = mallocSlotChip(55, 0xa70);
    FUN_808e118();
    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x8500029c);
    MEMORY.ref(1, r5 + 0x3a8).setu(12);
    MEMORY.ref(1, r5 + 0x3a7).setu(getPartyMemberIds_(r5 + 0x36e));
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x390).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3940);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x392).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3b40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x394).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3bc0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x396).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b39c0);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x39a).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3a40);
    r0 = getFreeVramSlot();
    MEMORY.ref(2, r5 + 0x398).setu(r0);
    FUN_8003fa4(r0, 0x80, 0x80b3ac0);
    setTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b00f4"), 0xc80);
    CPU.sp().value += 0x4;
  }

  @Method(0x80b0204)
  public static void FUN_80b0204() {
    final int r5 = MEMORY.ref(4, 0x3001f2c).get();
    clearTickCallback(getRunnable(GoldenSun_80b.class, "FUN_80b00f4"));
    FUN_8015140();
    clearVramSlot(MEMORY.ref(2, r5 + 0x390).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x392).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x394).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x396).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x398).getUnsigned());
    clearVramSlot(MEMORY.ref(2, r5 + 0x39a).getUnsigned());
    freeSlot(55);
  }

  @Method(0x80b0278)
  public static int FUN_80b0278(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b04c4)
  public static void FUN_80b04c4() {
    //LAB_80b04ce
    while(FUN_80f9048() != 0) {
      //LAB_80b04c8
      sleep(1);
    }
  }

  @Method(0x80b04dc)
  public static void FUN_80b04dc(final int r0) {
    int r5 = r0;
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r7 = FUN_80915ac(r6._3a4.get());
    FUN_8015140();

    final int r1 = r6._3a9.get();
    if(r1 == 2) {
      r5 = r5 + 0x2b;
    }

    //LAB_80b050a
    if(r1 == 0) {
      r5 = r5 + 0x56;
    }

    //LAB_80b0516
    if(r6._3ac.get() != 0) {
      r5 = r5 + 0xb1;
    }

    //LAB_80b052e
    FUN_8015038(r5, 5, 0, r7 << 16 | 0x22);

    //LAB_80b0546
    while(FUN_8015048() == 0) {
      //LAB_80b0540
      sleep(1);
    }

    sleep(1);
  }

  @Method(0x80b0634)
  public static int FUN_80b0634(final int defaultOption) {
    final GraphicsStruct1c r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new)._380.deref();
    final int r6 = r3._05.get();
    FUN_80a1038(r3);
    final int ret = FUN_80153b0(7, 5, defaultOption);
    r3._05.set(r6);
    return ret;
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

  @Method(0x80b10cc)
  public static void FUN_80b10cc() {
    final Menua70 r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final Panel24 r5 = r3.panel_0c.derefNullable();

    if(r5 != null) {
      drawIcon(0xc8a, r5, 0, 0);
      FUN_80150b0(MEMORY.ref(4, 0x2000250).get(), 6, r5, 32, 8);
    }

    //LAB_80b10f8
  }

  @Method(0x80b3210)
  public static int FUN_80b3210(final int r0) {
    final Menua70 r6 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    final int r10 = MEMORY.ref(1, 0x80b4ab6 + r0).get();
    int r2 = 0;

    //LAB_80b323e
    for(int r7 = 0; r7 < r6._3a7.get(); r7++) {
      if(getCharOrMonsterData_(MEMORY.ref(2, r6._36c.getAddress() + r7 * 0x2 + 0x2).get()).hp_38.get() != 0) { //TODO
        r2++;
      }
    }

    //LAB_80b3266
    return r10 * r2;
  }

  @Method(0x80b3284)
  public static int FUN_80b3284(final int r0, final int mapActorIndex) {
    FUN_80b010c();
    final Menua70 r5 = boardWramMallocHead_3001e50.offset(55 * 0x4).deref(4).cast(Menua70::new);
    r5._3a9.set(1);
    if(r0 == 5) {
      r5._3ac.set(1);
    }

    //LAB_80b32ae
    r5._3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
    Panel24 r8 = FUN_80150f8(r5._3a4.get(), 0, 0, 0);
    final int r6 = FUN_80b3210(r0);
    FUN_8015120(r6, 5);
    FUN_80b04dc(0xd1c);
    r5.panel_0c.set(addPanel_(0, 16, 12, 4, 2));
    FUN_80b10cc();

    if(FUN_80b0634(0) != 0) {
      FUN_80b04dc(0xd1f);
      FUN_8015018(r5.panel_0c.deref(), 2);
      //LAB_80b330e
    } else if((r6 & 0xffff_ffffL) > (MEMORY.ref(4, 0x2000250).get() & 0xffff_ffffL)) {
      FUN_80b04dc(0xd1e);
      FUN_8015018(r5.panel_0c.deref(), 2);
    } else {
      //LAB_80b3328
      FUN_8015018(r5.panel_0c.deref(), 2);
      FUN_80b04dc(0xd1d);
      FUN_8015018(r8, 2);
      FUN_80b3398(r6);
      r5._3a4.set(getMapActor_(mapActorIndex).sprite_50.deref().layers_28.get(0).deref().spriteDataIndex_00.get());
      r8 = FUN_80150f8(r5._3a4.get(), 0, 0, 0);
      FUN_80b04dc(0xd20);
    }

    //LAB_80b336a
    FUN_8015018(r8, 2);
    FUN_80b0204();
    return 0;
  }

  @Method(0x80b3398)
  public static void FUN_80b3398(final int r0) {
    CPU.sp().value -= 0x10;
    final int r8 = CPU.sp().value;
    final int r7 = getPartyMemberIds_(r8);
    FUN_8077230(-r0);

    //LAB_80b33c0
    for(int r5 = 0; r5 < r7; r5++) {
      final Unit14c unit = getCharOrMonsterData_(MEMORY.ref(2, r8 + r5 * 0x2).get());
      if(unit.hp_38.get() != 0) {
        unit.hp_38.set(unit.maxHp_34.get());
        unit.pp_3a.set(unit.maxPp_36.get());
        FUN_807822c(MEMORY.ref(2, r8 + r5 * 0x2).get());
      }
    }

    //LAB_80b33e8
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    r1._1c0.set(0x209);
    r1._1c8.set(60);
    sleep(20);
    FUN_808a368();
    FUN_808a370();
    playSound_(0x56);
    FUN_80b04c4();
    sleep(10);
    FUN_808a360();
    FUN_808a370();
    sleep(30);
    r1._1c8.set(16);
    CPU.sp().value += 0x10;
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
