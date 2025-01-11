package org.goldensun;

import org.goldensun.battle.AssembledFunction;
import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.Camera4c;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Unit14c;
import org.goldensun.types.Vec3;

import static org.goldensun.CopiedSegment8000770.memfill32;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.FUN_8005268;
import static org.goldensun.GoldenSun.FUN_8009088;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.rotateMatrixX;
import static org.goldensun.GoldenSun.rotateMatrixY;
import static org.goldensun.GoldenSun.rotateMatrixZ;
import static org.goldensun.GoldenSun.setActorAnimation_;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.subOperands_80ef034;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_80b.FUN_80b5030;
import static org.goldensun.GoldenSun_80b.FUN_80b5048;
import static org.goldensun.GoldenSun_80b.FUN_80b5058;
import static org.goldensun.GoldenSun_80b.FUN_80b5070;
import static org.goldensun.GoldenSun_80b.FUN_80b5088;
import static org.goldensun.GoldenSun_80b.FUN_80b50a8;
import static org.goldensun.GoldenSun_80b.FUN_80b50b0;
import static org.goldensun.GoldenSun_80b.FUN_80b50e8;
import static org.goldensun.GoldenSun_80b.getActorSprite_;
import static org.goldensun.GoldenSun_80b.getCombatantForUnit_;
import static org.goldensun.GoldenSun_80b.loadBattleBackground_;
import static org.goldensun.GoldenSun_80c.FUN_80c9048;
import static org.goldensun.GoldenSun_80c.FUN_80cd104;
import static org.goldensun.GoldenSun_80c.FUN_80cd52c;
import static org.goldensun.GoldenSun_80c.FUN_80cd594;
import static org.goldensun.GoldenSun_80c.FUN_80cdb24;
import static org.goldensun.GoldenSun_80c.FUN_80cdbc0;
import static org.goldensun.GoldenSun_80c.FUN_80cdd14;
import static org.goldensun.GoldenSun_80c.FUN_80cdd58;
import static org.goldensun.GoldenSun_80c.FUN_80cef64;
import static org.goldensun.GoldenSun_80d.FUN_80d4604;
import static org.goldensun.GoldenSun_80d.FUN_80d52a4;
import static org.goldensun.GoldenSun_80d.FUN_80d6750;
import static org.goldensun.GoldenSun_80d.FUN_80d67dc;
import static org.goldensun.GoldenSun_80d.FUN_80d6888;
import static org.goldensun.GoldenSun_80d.FUN_80d9ac4;
import static org.goldensun.GoldenSun_80d.FUN_80dbb24;
import static org.goldensun.GoldenSun_80d.FUN_80dea70;
import static org.goldensun.GoldenSun_80d.FUN_80df9d0;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80e {
  private GoldenSun_80e() { }

  @Method(0x80e0524)
  public static void FUN_80e0524(final int pointerTableIndex, final int dst, final int r2, final int r3) {
    int r6 = getPointerTableEntry(pointerTableIndex);
    if(r3 != 0) {
      MEMORY.call(0x3001388, 0x5000000, r6, 0x80); // memcpy
    }

    //LAB_80e0548
    if(r2 != 0) {
      r6 += 0x80;
    }

    //LAB_80e054e
    decompress(r6, dst);
  }

  @Method(0x80e155c)
  public static void FUN_80e155c(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r3 = 0x3001eec;
    r6 = r0;
    r7 = r1;
    r0 = 0x77a8;
    r1 = MEMORY.ref(4, r3).get();
    r0 = r0 + r1;
    r3 = MEMORY.ref(4, r0).get();
    CPU.r8().value = r0;
    if(r3 > 0) {
      r0 = rand();
      r6 = r6 - 0x1;
      r6 = r6 & r0;
      r0 = rand();
      r5 = r7 >>> 31;
      r5 = r7 + r5;
      r2 = r7 - 0x1;
      r5 = r5 >> 1;
      r2 = r2 & r0;
      r2 = r2 - r5;
      r1 = 0x3001ad0;
      r3 = r2;
      r6 = r6 - r5;
      r3 = r3 + 0x20;
      MEMORY.ref(2, r1 + 0x4).setu(r6);
      MEMORY.ref(2, r1 + 0x6).setu(r3);
      r1 = 0x3001ce0;
      r3 = 0x78;
      r6 = r3 - r6;
      r3 = r3 - r2;
      MEMORY.ref(4, r1 + 0xc).setu(r6);
      MEMORY.ref(4, r1 + 0x10).setu(r3);
      r2 = CPU.r8().value;
      r3 = MEMORY.ref(4, r2).get();
      r3 = r3 - 0x1;
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_80e15b0
      r0 = 0x77a0;
      r3 = r1 + r0;
      r3 = MEMORY.ref(4, r3).get();
      r2 = 0x3001ad0;
      r0 = r0 + 0x4;
      MEMORY.ref(2, r2 + 0x4).setu(r3);
      r3 = r1 + r0;
      r3 = MEMORY.ref(4, r3).get();
      MEMORY.ref(2, r2 + 0x6).setu(r3);
      r2 = 0x3001ce0;
      r3 = 0x78;
      MEMORY.ref(4, r2 + 0xc).setu(r3);
      MEMORY.ref(4, r2 + 0x10).setu(r3);
    }

    //LAB_80e15ca
    r3 = CPU.pop();
    CPU.r8().value = r3;
  }

  @Method(0x80e15e8)
  public static void FUN_80e15e8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80e38b8)
  public static void FUN_80e38b8(int r0, int r1, final int r2) {
    int r3;
    final int r4;
    final int r5;
    final int r6;

    r4 = r0;
    r3 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, r4 + 0xc).get();
    r3 = r3 + r0;
    r5 = r1;
    MEMORY.ref(4, r4).setu(r3);
    r1 = MEMORY.ref(4, r4 + 0x10).get();
    r3 = MEMORY.ref(4, r4 + 0x4).get();
    r3 = r3 + r1;
    MEMORY.ref(4, r4 + 0x4).setu(r3);
    r6 = MEMORY.ref(4, r4 + 0x14).get();
    r3 = MEMORY.ref(4, r4 + 0x8).get();
    r3 = r3 + r6;
    MEMORY.ref(4, r4 + 0x8).setu(r3);
    r3 = r5;
    r3 = r3 * r0;
    r1 = r1 + r2;
    MEMORY.ref(4, r4 + 0x10).setu(r1);
    if(r3 < 0) {
      r3 = r3 + 0x3f;
    }

    //LAB_80e38e4
    r1 = r1 * r5;
    r3 = r3 >> 6;
    MEMORY.ref(4, r4 + 0xc).setu(r3);
    if(r1 < 0) {
      r1 = r1 + 0x3f;
    }

    //LAB_80e38f0
    r3 = r1 >> 6;
    r1 = r5;
    r1 = r1 * r6;
    MEMORY.ref(4, r4 + 0x10).setu(r3);
    if(r1 < 0) {
      r1 = r1 + 0x3f;
    }

    //LAB_80e38fe
    r3 = r1 >> 6;
    MEMORY.ref(4, r4 + 0x14).setu(r3);
  }

  @Method(0x80e3908)
  public static void FUN_80e3908(int r0, int r1, final int r2) {
    int r3;
    final int r4;
    final int r5;

    r4 = r0;
    r3 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, r4 + 0xc).get();
    r3 = r3 + r0;
    r5 = r1;
    MEMORY.ref(4, r4).setu(r3);
    r1 = MEMORY.ref(4, r4 + 0x10).get();
    r3 = MEMORY.ref(4, r4 + 0x4).get();
    r3 = r3 + r1;
    MEMORY.ref(4, r4 + 0x4).setu(r3);
    r3 = r5;
    r3 = r3 * r0;
    r1 = r1 + r2;
    MEMORY.ref(4, r4 + 0x10).setu(r1);
    if(r3 < 0) {
      r3 = r3 + 0x3f;
    }

    //LAB_80e392c
    r1 = r1 * r5;
    r3 = r3 >> 6;
    MEMORY.ref(4, r4 + 0xc).setu(r3);
    if(r1 < 0) {
      r1 = r1 + 0x3f;
    }

    //LAB_80e3938
    r3 = r1 >> 6;
    MEMORY.ref(4, r4 + 0x10).setu(r3);
  }

  @Method(0x80e3944)
  public static int FUN_80e3944(final Vec3 r0, final Vec3 r1) {
    final int ret = FUN_8005268(r0, r1);
    r1.y_04.sub(0x10);
    return ret;
  }

  @Method(0x80e3958)
  public static void FUN_80e3958(final int unitId, final Vec3 r1) {
    FUN_80e3994(unitId, r1);
    r1.y_04.sub(0x10);
  }

  @Method(0x80e396c)
  public static void FUN_80e396c(final int unitId, final Vec3 r1) {
    FUN_80b50b0(unitId, r1);
    r1.y_04.sub(0x10);
  }

  @Method(0x80e3980)
  public static void FUN_80e3980(final int r0, final Vec3 r1) {
    FUN_80b50a8(r0, r1);
    r1.y_04.sub(0x10);
  }

  @Method(0x80e3994)
  public static int FUN_80e3994(final int unitId, final Vec3 r1) {
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    final Actor70 actor = getCombatantForUnit_(unitId).actor_00.deref();
    final Sprite38 sprite = getActorSprite_(actor, 0);
    initMatrixStack();
    FUN_80051d8(camera._00, camera._0c);
    final int r6 = (int)MEMORY.call(0x3000118, FUN_8005268(actor.pos_08, r1), sprite.scale_18.get());
    r1.y_04.sub((int)MEMORY.call(0x3000118, r6, FUN_80b5070(unitId) >> 17));
    return 0;
  }

  @Method(0x80e3a3c)
  public static void FUN_80e3a3c(final int r0) {
    mallocSlotBoard(41, 0x60e);
    mallocSlotChip(39, 0x782c);
    mallocSlotChip(40, 0x4000);
    final int r3 = MEMORY.ref(4, r0).get();
    if(r3 >= 100 && r3 <= 135) {
      FUN_80e47b8(r0, r3 - 100);
      //LAB_80e3a6c
    } else if(r3 > 199) {
      FUN_80e40a4(r0);
    } else {
      //LAB_80e3a78
      FUN_80e3aa0(r0);
    }

    //LAB_80e3a7e
    freeSlot(40);
    freeSlot(39);
    freeSlot(41);
  }

  @Method(0x80e3aa0)
  public static void FUN_80e3aa0(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;
    final int r8;
    int r9;
    int r10;

    CPU.sp().value -= 0x5c;
    final int r11 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    final int sp2c = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final int sp24 = boardWramMallocHead_3001e50.offset(41 * 0x4).get();
    final Camera4c sp20 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    final int sp1c = MEMORY.ref(4, r0).get();
    MEMORY.ref(4, r11 + 0x7828).setu(r0);
    final Unit14c sp18 = getUnit_(MEMORY.ref(4, r0 + 0x8).get());
    sleep(1);
    FUN_80c9048();
    FUN_80cdd58();
    GPU.BG1CNT.setu(0x1f80);
    sleep(1);

    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    if(sp1c == 0x5) {
      if(r3 == 0) {
        FUN_80ed408(46, 7, 7, 11, 3);
        FUN_80ed408(47, 7, 7, 11, 2);
      } else {
        //LAB_80e3b36
        FUN_80ed408(46, 7, 7, 15, 3);
        FUN_80ed408(47, 7, 7, 15, 2);
      }
    } else {
      //LAB_80e3b58
      if(r3 == 0) {
        FUN_80ed408(46, 7, 7, 3, 3);
        FUN_80ed408(47, 7, 7, 3, 2);
      } else {
        //LAB_80e3b80
        FUN_80ed408(46, 7, 7, 7, 3);
        FUN_80ed408(47, 7, 7, 7, 2);
      }
    }

    //LAB_80e3ba0
    final int sp10 = CPU.sp().value + 0x30;
    MEMORY.ref(4, sp10).setu(boardWramMallocHead_3001e50.offset(46 * 0x4).get());
    MEMORY.ref(4, sp10 + 0x4).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    sleep(1);

    if(sp1c == 0x5) {
      //LAB_80e3bf0
      FUN_80e0524(181, r11, 1, 1);
    } else if(sp1c == 0x4) {
      FUN_80e0524(107, r11, 1, 1);
      //LAB_80e3bc6
    } else if(sp1c == 0x3) {
      FUN_80e0524(197, r11, 0, 0);
      //LAB_80e3bda
    } else if(sp1c == 0x2) {
      //LAB_80e3bfe
      FUN_80e0524(182, r11, 1, 1);
    } else if(sp1c >= 0 && sp1c < 0x2) {
      FUN_80e0524(181, r11, 1, 1);
    }

    //LAB_80e3c0a
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    if(MEMORY.ref(4, r3 + 0x8).get() > 0x7) {
      MEMORY.call(0x3001388, 0x5000000, getPointerTableEntry(142), 0x80); // memcpy
    } else {
      //LAB_80e3c2c
      MEMORY.call(0x3001388, 0x5000000, getPointerTableEntry(74), 0x80); // memcpy
    }

    //LAB_80e3c40
    sleep(1);
    FUN_80e0524(118, sp24, 0, 0);
    FUN_80e0524(153, 0x2010000, 1, 0);
    MEMORY.ref(4, r11 + 0x7780).setu(2);
    MEMORY.ref(4, r11 + 0x7784).setu(50);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    GPU.BG1CNT.setu(0x1f81);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final Vec3 sp0x44 = new Vec3();
    FUN_80e3958(MEMORY.ref(2, r3 + 0x24).get(), sp0x44);

    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    if(MEMORY.ref(4, r3 + 0x4).get() == 0) {
      r3 = 0x60;
    } else {
      //LAB_80e3ce4
      r3 = 0x20;
    }

    //LAB_80e3cea
    int sp28 = r3 - sp0x44.getX();

    if(sp28 > 0) {
      sp28 = 0;
    }

    //LAB_80e3cf8
    if(sp28 < -128) {
      sp28 = -128;
    }

    //LAB_80e3d04
    sp0x44.x_00.add(sp28);
    r2 = 0x3001ad0;
    MEMORY.ref(2, r2 + 0x4).setu(sp28);
    MEMORY.ref(2, r2 + 0x6).setu(80);
    sleep(1);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final Actor70 r6 = getCombatantForUnit_(MEMORY.ref(2, r3 + 0x24).get()).actor_00.deref();
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    r8 = FUN_80b5070(MEMORY.ref(2, r3 + 0x24).get()) / 2;

    //LAB_80e3d4e
    for(r10 = 0; r10 < 0x40; r10++) {
      r5 = r11 + 0x7080 + r10 * 0x1c;
      MEMORY.ref(4, r5).setu(r6.pos_08.getX());
      MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r8);
      MEMORY.ref(4, r5 + 0x8).setu(r6.pos_08.getZ());
      MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) * 0x400);
      MEMORY.ref(4, r5 + 0x10).setu(((rand() & 0xff) - 0x20) * 0x400);
      MEMORY.ref(4, r5 + 0x14).setu(((rand() & 0xff) - 0x7f) * 0x400);

      if(MEMORY.ref(4, r5).get() > 0) {
        MEMORY.ref(4, r5 + 0xc).neg();
      }

      //LAB_80e3d8a
      MEMORY.ref(4, r5 + 0xc).neg();
      MEMORY.ref(4, r5 + 0x18).setu(r10 + 0x10);
    }

    final Vec3 sp0x50 = new Vec3();
    r9 = 0;

    //LAB_80e3db2
    do {
      if(r9 == 0x5) {
        if(FUN_80b5058(sp18.id_128.get()) != 0) {
          FUN_80b50e8(0x86);
        } else {
          //LAB_80e3dd2
          FUN_80b50e8(0x85);
        }
      }

      //LAB_80e3dd8
      if(r9 == 0x4) {
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        FUN_80b5088(MEMORY.ref(2, r3 + 0x24).get(), 0);
      }

      //LAB_80e3dee
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      FUN_80e396c(MEMORY.ref(4, r3 + 0x8).get(), sp0x50);
      r0 = sp0x50.getY();
      sp0x50.y_04.add(0x10);

      if(sp1c == 0x4) {
        if(r9 <= 0xb) {
          //LAB_80e3e14
          r3 = MEMORY.ref(4, r11 + 0x7828).get();
          if(MEMORY.ref(4, r3 + 0x4).get() == 0) {
            MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r11 + (5 - r9 / 2) * 0x300, sp0x50.getX() + sp28 - 0x30, r0 + 0x8, 48, 16);
          } else {
            //LAB_80e3e4c
            MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r11 + (5 - r9 / 2) * 0x300, sp0x50.getX() + sp28, r0 + 0x8, 48, 16);
          }
        }
      } else {
        //LAB_80e3e7a
        if(sp1c >= 0 && sp1c < 3 || sp1c == 0x5) {
          //LAB_80e3e84
          if(r9 <= 0xb) {
            r3 = MEMORY.ref(4, r11 + 0x7828).get();
            if(MEMORY.ref(4, r3 + 0x4).get() == 0) {
              MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r11 + r9 / 2 * 0xd80, sp0x50.getX() + sp28 - 0x30, r0 - 0x18, 48, 72);
            } else {
              //LAB_80e3ec0
              MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r11 + r9 / 2 * 0xd80, sp0x50.getX() + sp28, r0 - 0x18, 48, 72);
            }
          }
        } else {
          //LAB_80e3eee
          if(r9 <= 0x11) {
            r5 = divideS(r9, 3);
            r3 = MEMORY.ref(4, r11 + 0x7828).get();
            if(MEMORY.ref(4, r3 + 0x4).get() == 0) {
              r1 = MEMORY.ref(2, 0x80eedbe + r5 * 0x2).getUnsigned() + r11;
              r2 = sp0x50.getX() + MEMORY.ref(1, 0x80eedca + r5).getUnsigned() + sp28 - 0x3a;
              r4 = MEMORY.ref(1, 0x80eedb8 + r5).getUnsigned();
              MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r1, r2, sp0x50.getY() - (r4 >>> 1), MEMORY.ref(1, 0x80eedb2 + r5).getUnsigned(), r4);
            } else {
              //LAB_80e3f3a
              r1 = MEMORY.ref(2, 0x80eedbe + r5 * 0x2).getUnsigned() + r11;
              r2 = sp0x50.getX() - MEMORY.ref(1, 0x80eedca + r5).getUnsigned() + sp28;
              r4 = MEMORY.ref(1, 0x80eedb2 + r5).getUnsigned();
              r0 = MEMORY.ref(1, 0x80eedb8 + r5).getUnsigned();
              MEMORY.call(MEMORY.ref(4, sp10 + 0x4).get(), sp2c, r1, r2 - r4 + 0x3a, sp0x50.getY() - (r0 >>> 1), r4, r0);
            }
          }
        }
      }

      //LAB_80e3f6e
      if(r9 >= 4 && r9 < 16) {
        MEMORY.call(MEMORY.ref(4, sp10).get(), sp2c, 0x2010000 + (r9 - 4) / 2 * 0x780, sp0x44.getX() - 0x10, sp0x44.getY() - 0x18, 40, 48);
      }

      //LAB_80e3fa0
      initMatrixStack();
      FUN_80051d8(sp20._00, sp20._0c);

      if(r9 >= 4 && r9 < 32) {
        final Vec3 sp0x38 = new Vec3();

        //LAB_80e3fba
        for(r10 = 0; r10 < 0x40; r10++) {
          r7 = r11 + 0x7080 + r10 / 2 * 0x1c;
          r5 = MEMORY.ref(4, r7 + 0x18).get();
          if(r5 > 0) {
            FUN_8005268(MEMORY.ref(4, r7, Vec3::new), sp0x38);
            r5 = r5 >> 3;
            r5 = r5 + 0x2;
            r4 = r5 * 0x2;
            r3 = r4 - 0x2;
            MEMORY.call(MEMORY.ref(4, sp10 + (r10 / 2 & 0x1) * 0x4).get(), sp2c, sp24 + MEMORY.ref(2, 0x80ede5c + r3).getUnsigned(), sp0x38.getX() + sp28 - r5, sp0x38.getY() - r5, r4, r4);
            FUN_80e38b8(r7, 60, -0x400);
            MEMORY.ref(4, r7 + 0x18).decr();
          }

          //LAB_80e4024
        }
      }

      //LAB_80e402e
      MEMORY.ref(4, r11 + 0x7824).setu(1);
      sleep(1);
      r9++;
    } while(r9 != 0x20);

    //LAB_80e4048
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    r3 = 0x3001ad0;
    MEMORY.ref(2, r3 + 0x6).setu(r9);
    FUN_80cdd14();
    CPU.sp().value += 0x5c;
  }

  @Method(0x80e40a4)
  public static void FUN_80e40a4(int r0) {
    int r1;
    final int r2;
    int r3;
    int r5;
    int r6;
    int r7;
    int r9;
    int r10;
    final int r11;

    r1 = r0;
    r11 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    CPU.sp().value -= 0x70;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(boardWramMallocHead_3001e50.offset(41 * 0x4).get());
    final Camera4c sp28 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);

    if(MEMORY.ref(4, r1).get() <= 0xc7) {
      r6 = 0x0;
    } else {
      r6 = 0x1;
    }

    //LAB_80e40d6
    MEMORY.ref(4, r11 + 0x7828).setu(r1);
    FUN_80b5030(MEMORY.ref(4, r1 + 0x8).get(), MEMORY.ref(4, r1 + 0xc).get(), 130);
    sleep(1);
    FUN_80cdd58();
    GPU.BG1CNT.setu(0x1f80);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    if(r3 == 0) {
      FUN_80ed408(46, 7, 7, 3, 3);
      FUN_80ed408(47, 7, 7, 3, 2);
    } else {
      //LAB_80e4130
      FUN_80ed408(46, 7, 7, 7, 3);
      FUN_80ed408(47, 7, 7, 7, 2);
    }

    //LAB_80e4150
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(MEMORY.ref(4, 0x3001f08).get());
    final int sp10 = CPU.sp().value + 0x38;
    MEMORY.ref(4, sp10 + 0x4).setu(MEMORY.ref(4, 0x3001f0c).get());
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    FUN_80b5030(MEMORY.ref(4, r3 + 0x8).get(), MEMORY.ref(4, r3 + 0xc).get(), 130);
    sleep(1);
    FUN_80e0524(73, r11, 1, 0);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    FUN_80b5030(MEMORY.ref(4, r3 + 0x8).get(), MEMORY.ref(4, r3 + 0xc).get(), 130);
    sleep(1);
    FUN_80e0524(74, 0x2010000, 1, 1);
    r2 = MEMORY.ref(4, r11 + 0x7828).get();
    if(MEMORY.ref(4, r2 + 0x8).get() > 0x7) {
      MEMORY.call(0x3001388, 0x5000000, getPointerTableEntry(142), 0x80); // memcpy
    }

    //LAB_80e41c4
    FUN_80b5030(MEMORY.ref(4, r2 + 0x8).get(), MEMORY.ref(4, r2 + 0xc).get(), 130);
    sleep(1);
    FUN_80e0524(118, MEMORY.ref(4, CPU.sp().value + 0x2c).get(), 0, 0);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    FUN_80b5030(MEMORY.ref(4, r3 + 0x8).get(), MEMORY.ref(4, r3 + 0xc).get(), 130);
    sleep(1);
    MEMORY.ref(4, r11 + 0x7780).setu(1);
    MEMORY.ref(4, r11 + 0x7784).setu(0);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);

    final Vec3 sp0x64 = new Vec3();
    if(r6 == 0x1) {
      //LAB_80e4214
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      final Actor70 r8 = getCombatantForUnit_(MEMORY.ref(4, r3 + 0x8).get()).actor_00.deref();
      r10 = 0;
      r5 = r11 + 0x7080;

      //LAB_80e422e
      do {
        MEMORY.ref(4, r5).setu((rand() & 0x3f) + 0x10);
        MEMORY.ref(4, r5 + 0x4).setu(0);
        MEMORY.ref(4, r5 + 0x8).setu(0);
        MEMORY.ref(4, r5 + 0xc).setu(rand() & 0xffff);
        MEMORY.ref(4, r5 + 0x10).setu(rand() & 0xffff);
        MEMORY.ref(4, r5 + 0x14).setu(rand() & 0xffff);
        r5 = r5 + 0x1c;
        r10++;
      } while(r10 != 0x40);

      FUN_8009088(r8, 0);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(r8.velocity_24.getX());
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r8.velocity_24.getY());
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r8.velocity_24.getZ());
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r8._48.get());
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r8.acceleration_34.get());
      r8.velocity_24.zero();
      r8.acceleration_34.set(0);
      r8._48.set(0);
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      FUN_80e396c(MEMORY.ref(4, r3 + 0x8).get(), sp0x64);
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(r10 - sp0x64.getX());
      r1 = MEMORY.ref(2, CPU.sp().value + 0x30).getUnsigned();
      MEMORY.ref(2, 0x3001ad0 + 0x4).setu(r1);
      MEMORY.ref(2, 0x3001ad0 + 0x6).setu(80);
      MEMORY.ref(4, r11 + 0x77b4).setu(24);
      MEMORY.ref(4, r11 + 0x77b8).setu(0);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"), 0xc80);
      playSound_(0xd4);
      r9 = 0;

      //LAB_80e42de
      do {
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        FUN_80b5030(MEMORY.ref(4, r3 + 0x8).get(), MEMORY.ref(4, r3 + 0xc).get(), 130);
        r10 = 0;
        r6 = r11 + 0x7080;

        //LAB_80e42f8
        do {
          if(MEMORY.ref(4, r6).get() >= 0) {
            if(r9 >= r10 / 4) {
              r7 = (r10 & 0x1) + 5;
              initMatrixStack();
              rotateMatrixZ(MEMORY.ref(4, r6 + 0x14).get());
              rotateMatrixX(MEMORY.ref(4, r6 + 0xc).get());
              rotateMatrixY(MEMORY.ref(4, r6 + 0x10).get());
              final Vec3 sp0x4c = new Vec3();
              FUN_80e3944(MEMORY.ref(4, r6, Vec3::new), sp0x4c);
              sp0x4c.x_00.add(0x40);
              sp0x4c.y_04.add(MEMORY.ref(4, CPU.sp().value + 0x68).get() + 0x18);

              if(sp0x4c.getZ() < -60) {
                sp0x4c.setZ(-60);
              }

              //LAB_80e4352
              if(sp0x4c.getZ() > 60) {
                sp0x4c.setZ(60);
              }

              //LAB_80e435a
              sp0x4c.z_08.add(60);
              MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), MEMORY.ref(4, CPU.sp().value + 0x2c).get() + MEMORY.ref(2, 0x80ede5a + r7 * 0x2).getUnsigned(), sp0x4c.getX() - r7, sp0x4c.getY() - r7, r7 * 0x2, r7 * 0x2);
              MEMORY.ref(4, r6).subu(0x4);
            }
          }

          //LAB_80e4384
          r6 = r6 + 0x1c;
          r10++;
        } while(r10 != 0x40);

        MEMORY.ref(4, r11 + 0x7824).setu(1);
        sleep(1);
        r9++;
      } while(r9 != 0x20);

      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
      FUN_8009088(r8, 0x10);
      r8.velocity_24.setX(MEMORY.ref(4, CPU.sp().value + 0x24).get());
      r8.velocity_24.setY(MEMORY.ref(4, CPU.sp().value + 0x20).get());
      r8.velocity_24.setZ(MEMORY.ref(4, CPU.sp().value + 0x1c).get());
      r8.acceleration_34.set(MEMORY.ref(4, CPU.sp().value + 0x18).get());
      r8._48.set(MEMORY.ref(4, CPU.sp().value + 0x14).get());
    }

    //LAB_80e43d2
    r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    MEMORY.call(0x3000164, r0, 0x4000); // memzero
    MEMORY.call(0x3000164, 0x6004000, 0x4000); // memzero;
    MEMORY.ref(4, r11 + 0x7780).setu(2);
    MEMORY.ref(4, r11 + 0x7784).setu(75);
    GPU.BG1CNT.setu(0x1f81);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final Vec3 sp0x58 = new Vec3();
    FUN_80e396c(MEMORY.ref(2, r3 + 0x24).get(), sp0x58);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    if(r3 == 0) {
      r3 = 0x20;
    } else {
      //LAB_80e4474
      r3 = 0x60;
    }

    //LAB_80e4478
    r3 = r3 - sp0x58.getX();
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);

    if(MEMORY.ref(4, CPU.sp().value + 0x30).get() > 0) {
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
    }

    //LAB_80e4486
    if(MEMORY.ref(4, CPU.sp().value + 0x30).get() < -128) {
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(-128);
    }

    //LAB_80e4492
    sp0x58.x_00.add(MEMORY.ref(4, CPU.sp().value + 0x30).get());
    MEMORY.ref(2, 0x3001ad0 + 0x6).setu(80);
    MEMORY.ref(2, 0x3001ad0 + 0x4).setu(MEMORY.ref(2, CPU.sp().value + 0x30).getUnsigned());
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r3 + 0x24).get()).actor_00.deref();
    final int r8_0 = FUN_80b5070(MEMORY.ref(2, r3 + 0x24).get()) / 2;
    r10 = 0;
    r5 = r11 + 0x7080;

    //LAB_80e44d4
    do {
      MEMORY.ref(4, r5).setu(actor.pos_08.getX());
      MEMORY.ref(4, r5 + 0x4).setu(actor.pos_08.getY() + r8_0);
      MEMORY.ref(4, r5 + 0x8).setu(actor.pos_08.getZ());
      MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) << 10);
      MEMORY.ref(4, r5 + 0x10).setu((rand() & 0xff) << 10);
      MEMORY.ref(4, r5 + 0x14).setu((rand() & 0xff) - 0x7f << 10);

      if(MEMORY.ref(4, r5).get() > 0) {
        MEMORY.ref(4, r5 + 0xc).neg();
      }

      //LAB_80e450e
      MEMORY.ref(4, r5 + 0x18).setu(r10 + 0x10);
      r5 = r5 + 0x1c;
      r10++;
    } while(r10 != 0x40);

    r9 = 0;

    //LAB_80e452a
    do {
      if(r9 == 0x5) {
        FUN_80b50e8(0x86);
      }

      //LAB_80e4536
      if(r9 == 0x4) {
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        FUN_80b5088(MEMORY.ref(2, r3 + 0x24).get(), 0);
      }

      //LAB_80e454c
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      FUN_80e396c(MEMORY.ref(4, r3 + 0x8).get(), sp0x64);
      sp0x64.y_04.add(16);
      if(r9 < 2) {
        MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), r11, 0, 0, 120, 120);
        //LAB_80e4576
      } else if(r9 < 4) {
        MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), r11 + 0x3840, 0, 0, 120, 120);
        //LAB_80e458e
      } else if(r9 < 6) {
        MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), 0x2010000, 0, 0, 120, 120);
        //LAB_80e45aa
      } else if(r9 < 8) {
        MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), 0x2013840, 0, 0, 120, 120);
      }

      //LAB_80e45c4
      initMatrixStack();
      FUN_80051d8(sp28._00, sp28._0c);

      if(r9 >= 4 && r9 < 32) {
        final Vec3 sp0x40 = new Vec3();
        r10 = 0;

        //LAB_80e45e2
        do {
          r7 = r11 + 0x7080 + r10 / 2 * 0x1c;
          int r6_0 = MEMORY.ref(4, r7 + 0x18).get();
          if(r6_0 > 0) {
            FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x40);
            sp0x40.x_00.add(MEMORY.ref(4, CPU.sp().value + 0x30).get());
            r6_0 = r6_0 / 8 + 0x2;
            sp0x40.y_04.add(0x10);
            MEMORY.call(MEMORY.ref(4, sp10 + (r10 / 2 & 0x1) * 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x34).get(), MEMORY.ref(4, CPU.sp().value + 0x2c).get() + MEMORY.ref(2, 0x80ede5a + r6_0 * 0x2).getUnsigned(), sp0x40.getX() - r6_0, sp0x40.getY() - r6_0, r6_0 * 0x2, r6_0 * 0x2);
            FUN_80e38b8(r7, 60, -1024);
            MEMORY.ref(4, r7 + 0x18).decr();
          }

          //LAB_80e4650
          r10++;
        } while(r10 != 0x40);
      }

      //LAB_80e465a
      MEMORY.ref(4, r11 + 0x7824).setu(1);
      sleep(1);
      r9++;
    } while(r9 != 0x20);

    //LAB_80e4674
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    MEMORY.ref(2, 0x3001ad0 + 0x6).setu(r9);
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);

    //LAB_80e469c
    for(r9 = 0; r9 < 7; r9++) {
      FUN_80b5048(struct.backgroundPointerTableId_648.get(), 6 - r9);
      sleep(1);
    }

    FUN_80cdd14();
    CPU.sp().value += 0x70;
  }

  @Method(0x80e46f0)
  public static void FUN_80e46f0(final int pointerTableEntryIndex) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x80;
    CPU.r8().value = 0x5000000;
    MEMORY.memcpy(CPU.sp().value, getPointerTableEntry(pointerTableEntryIndex), 0x80);
    r2 = CPU.sp().value;
    MEMORY.ref(2, r2).setu(0);
    CPU.r12().value = 0;
    CPU.lr().value = r2;
    r6 = 0x0;

    //LAB_80e472c
    do {
      r1 = CPU.r8().value;
      r3 = MEMORY.ref(2, r1).getUnsigned();
      r1 = CPU.lr().value;
      r5 = r3 & 0x1f;
      r3 = r3 << 16;
      r2 = r3 >>> 21;
      r0 = r3 >>> 26;
      r3 = MEMORY.ref(2, r6 + r1).getUnsigned();
      r1 = r3 & 0x1f;
      r3 = r3 << 16;
      r4 = r3 >>> 21;
      r3 = r3 >>> 26;
      r2 = r2 & 0x1f;
      r0 = r0 & 0x1f;
      r4 = r4 & 0x1f;
      r3 = r3 & 0x1f;
      if(r5 < r1) {
        r5 = r5 + 0x1;
        //LAB_80e4758
      } else if(r5 > r1) {
        r5 = r5 - 0x1;
      }

      //LAB_80e475e
      if(r2 < r4) {
        r2 = r2 + 0x1;
        //LAB_80e4766
      } else if(r2 > r4) {
        r2 = r2 - 0x1;
      }

      //LAB_80e476c
      if(r0 < r3) {
        r0 = r0 + 0x1;
        //LAB_80e4774
      } else if(r0 > r3) {
        r0 = r0 - 0x1;
      }

      //LAB_80e477a
      r2 = r2 << 5;
      r3 = r0 << 10;
      r3 = r3 | r2;
      r3 = r3 | r5;
      r2 = CPU.lr().value;
      MEMORY.ref(2, r6 + r2).setu(r3);
      CPU.r12().value++;
      r6 = r6 + 0x2;
      CPU.r8().value += 2;
    } while(CPU.r12().value != 0x40);

    MEMORY.memcpy(0x5000000, CPU.sp().value, 0x80);
    CPU.sp().value += 0x80;
    CPU.r8().value = CPU.pop();
  }

  /** Saturos using heat flash in first battle */
  @Method(0x80e47b8)
  public static void FUN_80e47b8(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r9;
    int r10;
    int r11;

    final Vec3 sp0x70 = new Vec3();
    final Vec3 sp0x7c = new Vec3();
    final Vec3 sp0x94 = new Vec3();

    CPU.sp().value -= 0xb8;
    MEMORY.ref(4, CPU.sp().value + 0x60).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x64).setu(r0);
    r0 = MEMORY.ref(4, 0x3001eec).get();
    MEMORY.ref(4, CPU.sp().value + 0x5c).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x58).setu(MEMORY.ref(4, 0x3001ef0).get());
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    r3 = MEMORY.ref(4, 0x3001ef4).get();
    r2 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
    MEMORY.ref(4, r0 + 0x7828).setu(r2);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r3 == 0xb || r3 == 0x8 || r3 == 0x20) {
      //LAB_80e47fa
      r0 = 0x0;
      FUN_80cdb24(r0);
    } else {
      //LAB_80e480c
      r0 = 0x0;
      FUN_80cd594(r0);
    }

    //LAB_80e4812
    r2 = 0x4000052;
    r3 = 0x1010;
    MEMORY.ref(2, r2).setu(r3);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r0 = 0x73;
    r2 = 0x0;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0x96;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r2 = 0x1;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0x99;
    r1 = 0x2010000;
    r2 = 0x1;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0xa2;
    r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r0 = r0 << 7;
    r3 = 0x90;
    r1 = r5 + r0;
    r3 = r3 << 1;
    r0 = 0x2010000;
    r2 = 0x28;
    FUN_80df9d0(r0, r1, r2);

    //LAB_80e486c
    r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r1 == 0x5 || r1 == 0x17) {
      //LAB_80e4876
      r0 = 0x7d;
      r1 = 0x2010000;
      r2 = 0x1;
      r3 = 0x0;
      FUN_80e0524(r0, r1, r2, r3);
    } else {
      //LAB_80e487a
      r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r2 == 0xc) {
        r0 = 0xa9;
        r1 = 0x2010000;
        r2 = 0x1;
        r3 = 0x0;
        FUN_80e0524(r0, r1, r2, r3);
      } else {
        //LAB_80e4884
        r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r3 == 0x6 || r3 == 0x1b) {
          //LAB_80e488e
          r0 = 0xce;
          r1 = 0x2010000;
          r2 = 0x1;
          r3 = 0x0;
          FUN_80e0524(r0, r1, r2, r3);
          r0 = 0xc4;
          r1 = 0x2010c56;
          r2 = 0x1;
          r3 = 0x0;
          FUN_80e0524(r0, r1, r2, r3);
        } else {
          //LAB_80e48a0
          r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
          if(r5 == 0x1f) {
            r0 = 0x79;
            r1 = 0x2010000;
            r2 = 0x1;
            r3 = 0x1;
            FUN_80e0524(r0, r1, r2, r3);
          } else {
            //LAB_80e48aa
            r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r0 == 0x8) {
              r0 = 0xc3;
              r1 = 0x2010000;
              r2 = 0x1;
              r3 = 0x1;
              FUN_80e0524(r0, r1, r2, r3);
            } else {
              //LAB_80e48be
              r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if(r1 == 0xe) {
                r0 = 0x6f;
                r1 = 0x2010000;
                r2 = 0x1;
                r3 = 0x0;
                FUN_80e0524(r0, r1, r2, r3);
              } else {
                //LAB_80e48c8
                r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                if(r2 == 0x1e) {
                  r0 = 0xce;
                  r1 = 0x2010000;
                  r2 = 0x1;
                  r3 = 0x0;
                  FUN_80e0524(r0, r1, r2, r3);
                } else {
                  //LAB_80e48d2
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                  if(r3 == 0x10) {
                    r0 = 0xb8;
                    r1 = 0x2010000;
                    r2 = 0x1;
                    r3 = 0x0;
                    FUN_80e0524(r0, r1, r2, r3);
                  } else {
                    //LAB_80e48dc
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                    if(r5 == 0x14) {
                      r0 = 0xb4;
                      r1 = 0x2010000;
                      r2 = 0x1;
                      r3 = 0x0;
                      FUN_80e0524(r0, r1, r2, r3);
                    } else {
                      //LAB_80e48e6
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                      r3 = r3 - 0x21;
                      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                        r0 = 0x53;
                        r1 = 0x2010000;
                        r2 = 0x1;
                        r3 = 0x0;
                        FUN_80e0524(r0, r1, r2, r3);
                      } else {
                        //LAB_80e48fc
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                        if(r0 != 0xb && r0 != 0x20) {
                          r0 = 0x9e;
                          r1 = 0x2010000;
                          r2 = 0x1;
                          r3 = 0x0;
                          FUN_80e0524(r0, r1, r2, r3);
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

    //LAB_80e4912
    //LAB_80e491a
    r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    switch(r1) {
      case 0: // switch 80e4924
      case 4: // switch 80e4924
      case 7: // switch 80e4924
      case 8: // switch 80e4924
      case 9: // switch 80e4924
      case 10: // switch 80e4924
      case 11: // switch 80e4924
      case 12: // switch 80e4924
      case 13: // switch 80e4924
      case 33: // switch 80e4924
        //LAB_80e4ab8
        r0 = 0x94;
        r1 = 0x2013c56;
        r2 = 0x1;
        r3 = 0x1;
        FUN_80e0524(r0, r1, r2, r3);
        break;

      case 2: // switch 80e4924
      case 14: // switch 80e4924
      case 15: // switch 80e4924
      case 16: // switch 80e4924
      case 17: // switch 80e4924
      case 18: // switch 80e4924
      case 19: // switch 80e4924
        //LAB_80e4abc
        r0 = 0x92;
        r1 = 0x2013c56;
        r2 = 0x1;
        r3 = 0x1;
        FUN_80e0524(r0, r1, r2, r3);
        break;

      case 3: // switch 80e4924
      case 5: // switch 80e4924
      case 20: // switch 80e4924
      case 21: // switch 80e4924
      case 22: // switch 80e4924
      case 23: // switch 80e4924
      case 24: // switch 80e4924
      case 25: // switch 80e4924
      case 34: // switch 80e4924
      case 35: // switch 80e4924
        //LAB_80e4ac0
        r0 = 0x8e;
        r1 = 0x2013c56;
        r2 = 0x1;
        r3 = 0x1;
        FUN_80e0524(r0, r1, r2, r3);
        break;

      case 1: // switch 80e4924
      case 6: // switch 80e4924
      case 26: // switch 80e4924
      case 27: // switch 80e4924
      case 28: // switch 80e4924
      case 29: // switch 80e4924
      case 30: // switch 80e4924
      case 31: // switch 80e4924
      case 32: // switch 80e4924
        //LAB_80e4ac4
        r0 = 0x90;
        r1 = 0x2013c56;
        r2 = 0x1;
        r3 = 0x1;
        FUN_80e0524(r0, r1, r2, r3);
        break;

      case 100: // switch 80e4924
        //LAB_80e4ad2
        r0 = 0x92;
        r1 = 0x2013c56;
        r2 = 0x1;
        r3 = 0x1;
        FUN_80e0524(r0, r1, r2, r3);
        break;
    }

    //LAB_80e4ade
    r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r5 = 0xef;
    r5 = r5 << 7;
    r2 = r3 + r5;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r0 == 0xc) {
      r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r3 = 0x7784;
      r2 = r1 + r3;
      r3 = 0x4b;
    } else {
      //LAB_80e4b4c
      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r0 = 0x7784;
      r3 = 0x32;
      r2 = r5 + r0;
    }

    //LAB_80e4b54
    MEMORY.ref(4, r2).setu(r3);
    r1 = 0x90;
    r1 = r1 << 3;
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r5 = r1 + 0x7828;
    r3 = MEMORY.ref(4, r5).get();
    final Vec3 sp0xa0 = new Vec3();
    FUN_80e396c(MEMORY.ref(2, r3 + 0x24).get(), sp0xa0);
    r3 = MEMORY.ref(4, r5).get();
    r0 = MEMORY.ref(4, r3 + 0x8).get();
    final Vec3 sp0xac = new Vec3();
    FUN_80e396c(r0, sp0xac);
    r3 = MEMORY.ref(4, r5).get();
    r0 = MEMORY.ref(4, r3 + 0x4).get();
    r1 = CPU.sp().value + 0x68;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r1);
    FUN_80cef64(r0, r1);
    r0 = 0x77b4;
    r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r2 = r3 + r0;
    r3 = 0x18;
    MEMORY.ref(4, r2).setu(r3);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r3 = 0x77b8;
    r2 = r1 + r3;
    r3 = 0x0;
    MEMORY.ref(4, r2).setu(r3);
    r3 = MEMORY.ref(4, r5).get();
    final Actor70 actor = getCombatantForUnit_(MEMORY.ref(4, r3 + 0x8).get()).actor_00.deref();
    r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r6 = 0xffff;
    r10 = 0;
    r8 = 0;
    r5 = r0 + 0x7080;

    //LAB_80e4bc4
    do {
      r0 = rand();
      r3 = 0x3f;
      r3 = r3 & r0;
      r3 = r3 + 0x20;
      r2 = r8;
      MEMORY.ref(4, r5).setu(r3);
      MEMORY.ref(4, r5 + 0x4).setu(r2);
      MEMORY.ref(4, r5 + 0x8).setu(r2);
      r0 = rand();
      r0 = r0 & r6;
      MEMORY.ref(4, r5 + 0xc).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      r0 = rand();
      r3 = 0x1;
      r0 = r0 & r6;
      r10 = r10 + r3;
      MEMORY.ref(4, r5 + 0x14).setu(r0);
      r0 = r10;
      r5 = r5 + 0x1c;
    } while(r0 != 0x40);

    FUN_8009088(actor, 0);
    r3 = actor.pos_08.getX();
    sp0x94.setX(r3);
    r3 = actor.pos_08.getY();
    r2 = 0xa0;
    r2 = r2 << 15;
    r3 = r3 + r2;
    sp0x94.setY(r3);
    r3 = actor.pos_08.getZ();
    sp0x94.setZ(r3);
    r3 = actor.velocity_24.getX();
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
    r5 = actor.velocity_24.getY();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r5);
    r0 = actor.velocity_24.getZ();
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
    r1 = actor.acceleration_34.get();
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
    r2 = actor._48.get();
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
    actor.velocity_24.zero();
    actor.acceleration_34.set(0);
    actor._48.set(0);
    r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
    r0 = 0x7828;
    r3 = r5 + r0;
    r3 = MEMORY.ref(4, r3).get();
    r0 = MEMORY.ref(4, r3 + 0x8).get();
    FUN_80e396c(r0, sp0xac);
    r3 = sp0xac.getX();
    r2 = r3 >>> 31;
    r3 = r3 + r2;
    r3 = r3 >> 1;
    sp0xac.setX(r3);
    r0 = 0xd4;
    playSound_(r0);
    r2 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x54).setu(r2);

    //LAB_80e4c64
    do {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r1 = 0xe1;
      r5 = 0x0;
      r1 = r1 << 7;
      r9 = r5;
      r10 = r5;
      r6 = r0 + r1;

      //LAB_80e4c72
      do {
        r3 = MEMORY.ref(4, r6).get();
        if(r3 >= 0x0) {
          r3 = r10;
          if(r3 < 0x0) {
            r3 = r3 + 0x3;
          }

          //LAB_80e4c80
          r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
          r3 = r3 >> 2;
          if(r2 >= r3) {
            r3 = 0x5;
            r11 = r3;
            initMatrixStack();
            r0 = MEMORY.ref(4, r6 + 0x14).get();
            rotateMatrixZ(r0);
            r0 = MEMORY.ref(4, r6 + 0xc).get();
            rotateMatrixX(r0);
            r0 = MEMORY.ref(4, r6 + 0x10).get();
            rotateMatrixY(r0);
            FUN_80e3944(MEMORY.ref(4, r6, Vec3::new), sp0x7c);
            r3 = sp0x7c.getX();
            r2 = r3 >>> 31;
            r3 = r3 + r2;
            r2 = sp0xac.getX();
            r3 = r3 >> 1;
            r3 = r3 + r2;
            sp0x7c.setX(r3);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r1 <= 0x7) {
              r3 = sp0x7c.getY();
              r2 = sp0xac.getY();
              r3 = r3 + r2;
              r3 = r3 - 0x8;
            } else {
              //LAB_80e4ccc
              r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if(r2 == 0x23) {
                r3 = sp0x7c.getY();
                r2 = sp0xac.getY();
                r3 = r3 + r2;
                r3 = r3 + 0x2c;
              } else {
                //LAB_80e4cde
                r3 = sp0x7c.getY();
                r2 = sp0xac.getY();
                r3 = r3 + r2;
                r3 = r3 + 0xc;
              }
            }

            //LAB_80e4ce8
            sp0x7c.setY(r3);
            r2 = 0x3c;
            r3 = sp0x7c.getZ();
            r2 = -r2;
            if(r3 < r2) {
              sp0x7c.setZ(r2);
              r3 = r2;
            }

            //LAB_80e4cf8
            if(r3 > 0x3c) {
              r3 = 0x3c;
              sp0x7c.setZ(r3);
            }

            //LAB_80e4d00
            r3 = r3 + 0x3c;
            sp0x7c.setZ(r3);
            r2 = 0x80ede48;
            r3 = 0xa;
            r3 = r3 - 0x2;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r3 = sp0x7c.getY();
            r1 = r2 + r1;
            r0 = 0xa;
            r2 = sp0x7c.getX();
            r5 = r11;
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r5 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
            r3 = r3 - 0x5;
            r2 = r2 - 0x2;
            r4 = MEMORY.ref(4, r5 + 0x4).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r3 = MEMORY.ref(4, r6).get();
            r3 = r3 - 0x4;
            MEMORY.ref(4, r6).setu(r3);
          }

          //LAB_80e4d30
          r0 = 0x1;
          r9 = r9 + r0;
        }

        //LAB_80e4d34
        r1 = 0x1;
        r10 = r10 + r1;
        r2 = r10;
        r6 = r6 + 0x1c;
      } while(r2 != 0x40);

      r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r3 <= 0x7) {
        r5 = r9;
        if(r5 <= 0x3f) {
          initMatrixStack();
          FUN_80051d8(camera._00, camera._0c);
          FUN_80e3944(sp0x94, sp0x7c);
          r2 = sp0x7c.getX();
          r3 = r2 >>> 31;
          r2 = r2 + r3;
          r3 = sp0x7c.getY();
          r2 = r2 >> 1;
          r1 = 0x14;
          sp0x7c.setX(r2);
          MEMORY.ref(4, CPU.sp().value).setu(r1);
          r1 = 0x28;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
          r2 = r2 - 0xa;
          r3 = r3 - 0x4;
          r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          r1 = 0x2013c56;
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }
      }

      //LAB_80e4d8a
      r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r1 = 0x7824;
      r3 = 0x1;
      r2 = r0 + r1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
      r2 = r2 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x54).setu(r2);
    } while(r2 != 0x20);

    //LAB_80e4da6
    r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r3 == 0xb) {
      r3 = 0x100;
      r2 = 0x4000020;
      MEMORY.ref(2, r2).setu(r3);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r0 = 0x7828;
      r3 = r5 + r0;
      r3 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      if(r3 == 0x0) {
        r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
        r3 = sp0xa0.getX();
        r3 = r5 - r3;
        r2 = r2 + 0x8;
        r3 = r3 << 8;
        MEMORY.ref(4, r2).setu(r3);
      } else {
        //LAB_80e4dcc
        r2 = sp0xa0.getX();
        r3 = 0x60;
        r1 = 0x4000028;
        r3 = r3 - r2;
        r3 = r3 << 8;
        MEMORY.ref(4, r1).setu(r3);
      }
    } else {
      //LAB_80e4e0c
      r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r1 == 0x20) {
        r2 = 0x4000020;
        r3 = 0x100;
        MEMORY.ref(2, r2).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
        r5 = 0x7828;
        r3 = r2 + r5;
        r3 = MEMORY.ref(4, r3).get();
        r3 = MEMORY.ref(4, r3 + 0x4).get();
        if(r3 == 0x0) {
          r0 = 0xff800000;
          r1 = 0xc0;
          r1 = r1 << 12;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r0);
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r1);
        } else {
          //LAB_80e4e44
          r2 = 0x80;
          r3 = 0xfff40000;
          r2 = r2 << 12;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r2);
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
        }

        //LAB_80e4e4e
        r5 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
        r2 = 0x4000028;
        r3 = r5 >> 16;
        r3 = r3 << 8;
        MEMORY.ref(4, r2).setu(r3);
      }
    }

    //LAB_80e4e58
    r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r0 == 0x8) {
      r2 = 0x4000020;
      r3 = 0x100;
      MEMORY.ref(2, r2).setu(r3);
      r2 = sp0xa0.getX();
      r3 = 0x40;
      r1 = 0x4000028;
      r3 = r3 - r2;
      r3 = r3 << 8;
      MEMORY.ref(4, r1).setu(r3);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r0 = 0xef;
      r0 = r0 << 7;
      r1 = 0x7784;
      r2 = r5 + r0;
      r3 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      r6 = 0x0;
      r3 = r5 + r1;
      r1 = 0x80;
      MEMORY.ref(4, r3).setu(r6);
      r1 = r1 << 7;
      r0 = 0x6004000;
      MEMORY.memfill(r0, r1, 0);
      r1 = 0x80;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
      r1 = r1 << 7;
      MEMORY.memfill(r0, r1, 0);
      r3 = 0x4000050;
      MEMORY.ref(2, r3).setu(r6);
    }

    //LAB_80e4ec0
    r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r2 == 0x1f) {
      r3 = 0x100;
      r2 = 0x4000020;
      MEMORY.ref(2, r2).setu(r3);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r0 = 0x7828;
      r3 = r5 + r0;
      r3 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      if(r3 == 0x0) {
        r2 = sp0xa0.getX();
        r3 = 0x20;
      } else {
        //LAB_80e4ef4
        r2 = sp0xa0.getX();
        r3 = 0x60;
      }

      //LAB_80e4efa
      r1 = 0x4000028;
      r3 = r3 - r2;
      r3 = r3 << 8;
      MEMORY.ref(4, r1).setu(r3);
    }

    //LAB_80e4f02
    r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
    if(r0 == 0xf || r0 == 0x11 || r0 == 0x18 || r0 == 0x1a) {
      //LAB_80e4f14
      r1 = 0x80;
      r1 = r1 << 7;
      r0 = 0x6004000;
      MEMORY.memfill(r0, r1, 0);
      r1 = 0x80;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
      r1 = r1 << 7;
      MEMORY.memfill(r0, r1, 0);
      r2 = 0x7828;
      r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
      r3 = r1 + r2;
      r2 = MEMORY.ref(4, r3).get();
      r3 = 0x0;
      MEMORY.ref(4, r2 + 0x1c).setu(r3);
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
      clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
      freeSlot(47);
      freeSlot(46);
      setActorAnimation_(actor, 3);
      r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r3 == 0xf) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        r1 = 0x9;
        FUN_80dea70(r0, r1);
      }

      //LAB_80e4f64
      r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r5 == 0x18) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        FUN_80d52a4(r0);
      }

      //LAB_80e4f70
      r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
      if(r0 == 0x1a) {
        //LAB_80e4f7a
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        r1 = 0x8;
        FUN_80dea70(r0, r1);
      }
    } else {
      //LAB_80e4f86
      r1 = 0x10;
      FUN_8009088(actor, r1);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      actor.velocity_24.setX(r1);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      actor.velocity_24.setY(r2);
      r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
      actor.velocity_24.setZ(r3);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      actor.acceleration_34.set(r5);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      actor._48.set(r0);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();

      if(r1 == 0x23) {
        r1 = 0x80;
        r1 = r1 << 7;
        r0 = 0x6004000;
        MEMORY.memfill(r0, r1, 0);
        r1 = 0x80;
        r1 = r1 << 7;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
        MEMORY.memfill(r0, r1, 0);
        r5 = 0x7828;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
        r3 = r2 + r5;
        r2 = MEMORY.ref(4, r3).get();
        r3 = 0x0;
        MEMORY.ref(4, r2 + 0x1c).setu(r3);
        clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
        clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
        r0 = 0x2f;
        freeSlot(r0);
        r0 = 0x2e;
        freeSlot(r0);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        r3 = 0x3;
        MEMORY.ref(4, r0 + 0x18).setu(r3);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x64).get();
        r1 = 0x2;
        FUN_80d4604(r0, r1);
      } else {
        //LAB_80e4ff4
        r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
        r2 = 0x7828;
        r3 = r1 + r2;
        r3 = MEMORY.ref(4, r3).get();
        final Actor70 sp1c = getCombatantForUnit_(MEMORY.ref(2, r3 + 0x24).get()).actor_00.deref();
        r0 = CPU.sp().value + 0x88;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        r3 = sp0x94.getX();
        r0 = sp1c.pos_08.getX();
        r1 = 0x6;
        r0 = r0 - r3;
        r0 = divideS(r0, r1);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        MEMORY.ref(4, r3).setu(r0);
        r0 = sp1c.pos_08.getY();
        r3 = sp0x94.getY();
        r2 = 0xf0;
        r2 = r2 << 13;
        r0 = r0 - r3;
        r0 = r0 + r2;
        r1 = 0x6;
        r0 = divideS(r0, r1);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        MEMORY.ref(4, r3 + 0x4).setu(r0);
        r0 = sp1c.pos_08.getZ();
        r3 = sp0x94.getZ();
        r1 = 0x6;
        r0 = r0 - r3;
        r0 = divideS(r0, r1);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        MEMORY.ref(4, r1 + 0x8).setu(r0);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
        r0 = 0x7098;
        r2 = 0x0;
        r10 = r2;
        r3 = r5 + r0;

        //LAB_80e5058
        do {
          r1 = 0x1;
          r10 = r10 + r1;
          r5 = r10;
          MEMORY.ref(4, r3).setu(r2);
          r3 = r3 + 0x1c;
        } while(r5 != 0x40);

        r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r0 != 0xe) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
          r2 = 0x7828;
          r3 = r1 + r2;
          r3 = MEMORY.ref(4, r3).get();
          r5 = 0x24;
          r0 = MEMORY.ref(2, r3 + r5).get();
          r0 = FUN_80b5070(r0);
          r3 = r0 >>> 31;
          r0 = r0 + r3;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
          r2 = 0xe1;
          r7 = r0 >> 1;
          r2 = r2 << 7;
          r0 = 0x0;
          r10 = r0;
          r6 = 0xff;
          r5 = r1 + r2;

          //LAB_80e5090
          do {
            r3 = sp1c.pos_08.getX();
            MEMORY.ref(4, r5 + 0x4).setu(r7);
            MEMORY.ref(4, r5).setu(r3);
            r3 = sp1c.pos_08.getZ();
            MEMORY.ref(4, r5 + 0x8).setu(r3);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r1 == 0x1f) {
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x7f;
              r0 = r0 << 12;
              MEMORY.ref(4, r5 + 0xc).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x40;
              r0 = r0 << 10;
            } else {
              //LAB_80e50d8
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x7f;
              r0 = r0 << 12;
              MEMORY.ref(4, r5 + 0xc).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x40;
              r0 = r0 << 12;
            }

            //LAB_80e50ee
            MEMORY.ref(4, r5 + 0x10).setu(r0);
            r0 = rand();
            r0 = r0 & r6;
            r0 = r0 - 0x7f;
            r0 = r0 << 12;
            MEMORY.ref(4, r5 + 0x14).setu(r0);
            r2 = r10;
            r3 = r2 >>> 31;
            r3 = r3 + r10;
            r3 = r3 >> 1;
            r3 = r3 + 0x20;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
            r3 = 0x1;
            r10 = r10 + r3;
            r0 = r10;
            r5 = r5 + 0x1c;
          } while(r0 != 0x20);
        }

        //LAB_80e5114
        r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r1 == 0xb) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
          r0 = 0xab;
          r2 = 0x1;
          r3 = 0x1;
          FUN_80e0524(r0, r1, r2, r3);
          r2 = 0x1;
          r3 = 0x0;
          r0 = 0xac;
          r1 = 0x2010000;
          FUN_80e0524(r0, r1, r2, r3);
          r2 = 0x4000052;
          r3 = 0xe10;
          MEMORY.ref(2, r2).setu(r3);
        }

        //LAB_80e5138
        r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r2 == 0x20) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
          r0 = 0xad;
          r2 = 0x1;
          r3 = 0x1;
          FUN_80e0524(r0, r1, r2, r3);
          r2 = 0x1;
          r3 = 0x0;
          r0 = 0xae;
          r1 = 0x2010000;
          FUN_80e0524(r0, r1, r2, r3);
          r2 = 0x4000052;
          r3 = 0xe10;
          MEMORY.ref(2, r2).setu(r3);
        }

        //LAB_80e517c
        r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r3 != 0x7 && r3 != 0xd && r3 != 0x12 && r3 != 0xb && r3 != 0x20 && r3 != 0x13) {
          r7 = 0x0;
          if(r3 != 0xc) {
            r7 = 0xa0;
            r7 = r7 << 13;
          }

          //LAB_80e51a0
          r5 = 0x0;
          r10 = r5;
          r5 = 0x2014000;
          r6 = 0xff;

          //LAB_80e51a8
          do {
            r3 = sp1c.pos_08.getX();
            MEMORY.ref(4, r5 + 0x4).setu(r7);
            MEMORY.ref(4, r5).setu(r3);
            r3 = sp1c.pos_08.getZ();
            MEMORY.ref(4, r5 + 0x8).setu(r3);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r1 == 0x5 || r1 == 0x17) {
              //LAB_80e51be
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x7f;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0xc).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0x10).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x7f;
              r0 = r0 << 11;
            } else {
              //LAB_80e51e0
              r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if(r2 == 0x19) {
                r0 = rand();
                r0 = r0 & r6;
                r0 = r0 - 0x7f;
                r0 = r0 << 11;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r3 = 0x7f;
                r3 = r3 & r0;
                r3 = r3 << 10;
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r0 = rand();
                r0 = r0 & r6;
                r0 = r0 - 0x7f;
                r0 = r0 << 11;
              } else {
                //LAB_80e520a
                r0 = rand();
                r0 = r0 & r6;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r3 = 0x7f;
                r3 = r3 & r0;
                r3 = r3 << 10;
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r0 = rand();
                r0 = r0 & r6;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
              }
            }

            //LAB_80e522c
            MEMORY.ref(4, r5 + 0x14).setu(r0);
            r3 = 0x0;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
            r3 = 0x1;
            r10 = r10 + r3;
            r0 = r10;
            r5 = r5 + 0x1c;
          } while(r0 != 0x40);
        }

        //LAB_80e523e
        r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        r1 = r1 - 0x2;
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if((r1 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r2 == 0xc || r2 == 0x16 || r2 == 0x1d || r2 == 0x1c) {
          //LAB_80e525a
          r1 = 0x90;
          r1 = r1 << 3;
          setTickCallback(getRunnable(GoldenSun_80d.class, "FUN_80dbb9c"), r1);
        }

        //LAB_80e5264
        r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        r3 = r3 - 0x4;
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if((r3 & 0xffff_ffffL) <= (0x2 & 0xffff_ffffL) || r5 == 0x17 || r5 == 0x1e || r5 == 0x1b || r5 == 0x21 || r5 == 0x22 || r5 == 0x64) {
          //LAB_80e5288
          r0 = 0x20;
          MEMORY.ref(4, CPU.sp().value + 0x40).setu(r0);
        } else {
          //LAB_80e528e
          r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
          if((r1 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL) || r1 == 0x8 || r1 == 0x9 || r1 == 0xa || r1 == 0x16 || r1 == 0x19 || r1 == 0x1d || r1 == 0x1f || r1 == 0xe) {
            //LAB_80e52b4
            r2 = 0x30;
            MEMORY.ref(4, CPU.sp().value + 0x40).setu(r2);
          } else {
            //LAB_80e52ba
            r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            r3 = 0x14;
            MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
            if(r5 != 0x15) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if(r0 == 0xb || r0 == 0x20 || r0 == 0x14) {
                //LAB_80e52d2
                r1 = 0x28;
                MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
              } else {
                //LAB_80e52d8
                r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                if(r2 == 0x1c) {
                  r5 = 0x40;
                  MEMORY.ref(4, CPU.sp().value + 0x40).setu(r5);
                } else {
                  r3 = 0x50;
                  MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
                  if(r2 == 0xc) {
                    //LAB_80e52e6
                    r5 = 0x40;
                    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r5);
                  }
                }
              }
            }
          }
        }

        //LAB_80e52ea
        r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r0 = 0x0;
        MEMORY.ref(4, CPU.sp().value + 0x54).setu(r0);
        if(r1 != 0x0) {
          //LAB_80e52f8
          do {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r2 != 0xb) {
              if(r2 != 0x20) {
                r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r5 = 0xd3;
                r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                r5 = r5 << 7;
                r0 = 0x0;
                r7 = 0x80;
                r6 = r3 + r5;
                r10 = r0;
                r7 = r7 << 11;
                r5 = r1 << 12;

                //LAB_80e5316
                do {
                  r0 = r5;
                  r0 = sin(r0);
                  r0 = r0 << 2;
                  r0 = r7 - r0;
                  r3 = 0x1;
                  r0 = r0 >> 10;
                  r2 = 0x80;
                  r10 = r10 + r3;
                  MEMORY.ref(4, r6).setu(r0);
                  r6 += 0x4;
                  r2 = r2 << 4;
                  r0 = r10;
                  r5 = r5 + r2;
                } while(r0 != 0xa0);
              }
            }

            //LAB_80e5334
            r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            if(r1 <= 0x2) {
              r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
              r5 = 0x7828;
              r3 = r2 + r5;
              r3 = MEMORY.ref(4, r3).get();
              r0 = MEMORY.ref(4, r3 + 0x8).get();
              FUN_80e396c(r0, sp0xac);
              r3 = sp0xac.getX();
              r2 = r3 >>> 31;
              r3 = r3 + r2;
              r3 = r3 >> 1;
              sp0xac.setX(r3);
              r3 = sp0xac.getY();
              r3 = r3 + 0x10;
              sp0xac.setY(r3);
            }

            //LAB_80e535c
            r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r1 != 0xb && r1 != 0x8 && r1 != 0x20 && r1 != 0x21 && r1 != 0x22) {
              r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r2 <= 0xb) {
                r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r0 = 0x7828;
                r3 = r5 + r0;
                r3 = MEMORY.ref(4, r3).get();
                r3 = MEMORY.ref(4, r3 + 0x4).get();
                if(r3 == 0x0) {
                  r3 = r2 >>> 31;
                  r3 = r2 + r3;
                  r3 = r3 >> 1;
                  r1 = r3 << 3;
                  r1 = r1 - r3;
                  r1 = r1 << 2;
                  r1 = r1 - r3;
                  r0 = 0x30;
                  r2 = sp0xac.getX();
                  r3 = sp0xac.getY();
                  r1 = r1 << 7;
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                  r0 = 0x48;
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                  r1 = r5 + r1;
                  r2 = r2 - 0x20;
                  r3 = r3 - 0x28;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                } else {
                  //LAB_80e53b4
                  r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                  r3 = r5 >>> 31;
                  r3 = r5 + r3;
                  r3 = r3 >> 1;
                  r1 = r3 << 3;
                  r1 = r1 - r3;
                  r1 = r1 << 2;
                  r1 = r1 - r3;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                  r1 = r1 << 7;
                  r2 = sp0xac.getX();
                  r1 = r0 + r1;
                  r3 = sp0xac.getY();
                  r0 = 0x30;
                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                  r0 = 0x48;
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                  r3 = r3 - 0x28;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                }
              }
            }

            //LAB_80e53e2
            r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();

            //LAB_80e53ea
            switch(r5) {
              case 33: // switch 80e53f4
                //LAB_80e547c
                r0 = 0x53;
                FUN_80e46f0(r0);
                break;

              case 14: // switch 80e53f4
                //LAB_80e5484
                r0 = 0x6f;
                FUN_80e46f0(r0);
                break;

              case 31: // switch 80e53f4
                //LAB_80e548c
                r0 = 0x79;
                FUN_80e46f0(r0);
                break;

              case 8: // switch 80e53f4
                //LAB_80e5494
                r0 = 0xc3;
                FUN_80e46f0(r0);
                break;

              case 0: // switch 80e53f4
              case 10: // switch 80e53f4
                //LAB_80e549c
                r0 = 0x8d;
                FUN_80e46f0(r0);
                break;

              case 12: // switch 80e53f4
              case 13: // switch 80e53f4
              case 25: // switch 80e53f4
                //LAB_80e54a4
                r0 = 0xbb;
                FUN_80e46f0(r0);
                break;

              case 18: // switch 80e53f4
                //LAB_80e54ac
                r0 = 0xb9;
                FUN_80e46f0(r0);
                break;

              case 19: // switch 80e53f4
                //LAB_80e54b4
                r0 = 0xc0;
                FUN_80e46f0(r0);
                break;

              case 2: // switch 80e53f4
              case 29: // switch 80e53f4
                //LAB_80e54bc
                r0 = 0xa4;
                FUN_80e46f0(r0);
                break;

              case 1: // switch 80e53f4
              case 28: // switch 80e53f4
                //LAB_80e54c4
                r0 = 0xa3;
                FUN_80e46f0(r0);
                break;

              case 3: // switch 80e53f4
              case 20: // switch 80e53f4
              case 22: // switch 80e53f4
                //LAB_80e5504
                r0 = 0xb4;
                FUN_80e46f0(r0);
                break;

              case 9: // switch 80e53f4
                //LAB_80e550c
                r0 = 0xa0;
                FUN_80e46f0(r0);
                break;

              case 5: // switch 80e53f4
              case 23: // switch 80e53f4
                //LAB_80e5514
                r0 = 0x7d;
                FUN_80e46f0(r0);
                break;
            }

            //LAB_80e551a
            r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r1 != 0xb) {
              if(r1 != 0x8) {
                if(r1 != 0x20) {
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                  r2 = r2 - 0x4;
                  if((r2 & 0xffff_ffffL) <= (0xb & 0xffff_ffffL)) {
                    r3 = r2 >>> 31;
                    r3 = r2 + r3;
                    r3 = r3 >> 1;
                    r1 = r3 << 4;
                    r1 = r1 - r3;
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                    r1 = r1 << 6;
                    r1 = r2 + r1;
                    r3 = 0xa2;
                    r2 = sp0xa0.getX();
                    r3 = r3 << 7;
                    r1 = r1 + r3;
                    r3 = r2 >>> 31;
                    r2 = r2 + r3;
                    r3 = sp0xac.getY();
                    r0 = 0x14;
                    MEMORY.ref(4, CPU.sp().value).setu(r0);
                    r0 = 0x30;
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                    r2 = r2 >> 1;
                    r2 = r2 - 0x8;
                    r3 = r3 - 0x18;
                    r4 = MEMORY.ref(4, r5 + 0x4).get();
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                  }

                  //LAB_80e556a
                  initMatrixStack();
                  FUN_80051d8(camera._00, camera._0c);
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                  if(r0 > 0x3) {
                    r1 = 0x0;
                    r10 = r1;

                    //LAB_80e5588
                    do {
                      r5 = r10;
                      r3 = r5 >>> 31;
                      r3 = r3 + r10;
                      r7 = r3 >> 1;
                      r3 = r7 << 3;
                      r3 = r3 - r7;
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                      r3 = r3 << 2;
                      r1 = 0xe1;
                      r3 = r0 + r3;
                      r1 = r1 << 7;
                      r1 = r1 + r3;
                      r5 = MEMORY.ref(4, r1 + 0x18).get();
                      r8 = r1;
                      if(r5 > 0x0) {
                        FUN_80e3944(MEMORY.ref(4, r8, Vec3::new), sp0x70);
                        r2 = sp0x70.getX();
                        r5 = r5 >> 4;
                        r3 = r2 >>> 31;
                        r5 = r5 + 0x1;
                        r2 = r2 + r3;
                        r4 = r5 << 1;
                        r2 = r2 >> 1;
                        r1 = 0x80ede48;
                        sp0x70.setX(r2);
                        r3 = r4 - 0x2;
                        r1 = MEMORY.ref(2, r1 + r3).getUnsigned();
                        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                        r1 = r3 + r1;
                        r3 = r5 >>> 31;
                        r3 = r5 + r3;
                        r3 = r3 >> 1;
                        r2 = r2 - r3;
                        r3 = sp0x70.getY();
                        r0 = 0x1;
                        r3 = r3 - r5;
                        MEMORY.ref(4, CPU.sp().value).setu(r5);
                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                        r5 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                        r0 = r0 & r7;
                        r0 = r0 << 2;
                        r4 = MEMORY.ref(4, r0 + r5).get();
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        r0 = r8;
                        r1 = 0x3c;
                        r2 = 0xfffff000;
                        FUN_80e38b8(r0, r1, r2);
                        r0 = r8;
                        r3 = MEMORY.ref(4, r0 + 0x18).get();
                        r3 = r3 - 0x1;
                        MEMORY.ref(4, r0 + 0x18).setu(r3);
                      }

                      //LAB_80e55fe
                      r1 = 0x1;
                      r10 = r10 + r1;
                      r2 = r10;
                    } while(r2 != 0x80);
                  }
                }
              }
            }

            //LAB_80e5608
            r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r3 == 0x7 || r3 == 0xd || r3 == 0x12 || r3 == 0x13) {
              //LAB_80e561c
              r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r5 == 0x32) {
                r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r1 = 0x7828;
                r3 = r0 + r1;
                r3 = MEMORY.ref(4, r3).get();
                r0 = MEMORY.ref(4, r3 + 0x8).get();
                r3 = 0x1;
                r2 = 0x0;
                r3 = -r3;
                MEMORY.ref(4, CPU.sp().value).setu(r2);
                r1 = 0x7;
                r2 = r3;
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              }

              //LAB_80e563c
              r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r2 == 0x4f) {
                r0 = 0x7828;
                r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r3 = r5 + r0;
                r3 = MEMORY.ref(4, r3).get();
                r0 = MEMORY.ref(4, r3 + 0x8).get();
                r3 = 0x1;
                r2 = 0x0;
                r3 = -r3;
                MEMORY.ref(4, CPU.sp().value).setu(r2);
                r1 = 0x0;
                r2 = r3;
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              }

              //LAB_80e565c
              r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r1 == 0xc) {
                r2 = 0x0;
                r5 = 0x2014000;
                r10 = r2;
                r6 = 0xff;

                //LAB_80e566a
                do {
                  r3 = sp1c.pos_08.getX();
                  MEMORY.ref(4, r5).setu(r3);
                  r3 = 0xa0;
                  r3 = r3 << 13;
                  MEMORY.ref(4, r5 + 0x4).setu(r3);
                  r3 = sp1c.pos_08.getZ();
                  MEMORY.ref(4, r5 + 0x8).setu(r3);
                  r0 = rand();
                  r0 = r0 & r6;
                  r0 = r0 - 0x80;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r5 + 0xc).setu(r0);
                  r0 = rand();
                  r0 = r0 & r6;
                  r0 = r0 - 0x80;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r5 + 0x10).setu(r0);
                  r0 = rand();
                  r1 = 0x1;
                  r0 = r0 & r6;
                  r0 = r0 - 0x80;
                  r10 = r10 + r1;
                  r0 = r0 << 10;
                  r3 = 0x0;
                  r2 = r10;
                  MEMORY.ref(4, r5 + 0x14).setu(r0);
                  MEMORY.ref(4, r5 + 0x18).setu(r3);
                  r5 = r5 + 0x1c;
                } while(r2 != 0x40);
              }

              //LAB_80e56ae
              r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r3 > 0xb) {
                //LAB_80e56b8
                r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r1 = 0x7828;
                r5 = r0 + r1;
                r3 = MEMORY.ref(4, r5).get();
                final Actor70 actor1 = getCombatantForUnit_(MEMORY.ref(4, r3 + 0x8).get()).actor_00.deref();
                r3 = MEMORY.ref(4, r5).get();
                r0 = MEMORY.ref(4, r3 + 0x8).get();
                r0 = FUN_80b5070(r0);
                r3 = r0 >>> 31;
                r0 = r0 + r3;
                r0 = r0 >> 1;
                r2 = 0x0;
                r7 = 0x2014000;
                r11 = r0;
                r10 = r2;

                //LAB_80e56e6
                do {
                  r3 = MEMORY.ref(4, r7 + 0x18).get();
                  if(r3 >= 0x0) {
                    r0 = r10;
                    r5 = 0x1;
                    r5 = r5 & r0;
                    FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x70);
                    r2 = sp0x70.getX();
                    r5 = r5 + 0x6;
                    r0 = r5 << 1;
                    r2 = r2 >> 1;
                    r1 = 0x80ede48;
                    sp0x70.setX(r2);
                    r3 = r0 - 0x2;
                    r1 = MEMORY.ref(2, r1 + r3).getUnsigned();
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                    r1 = r3 + r1;
                    r3 = r5 >>> 1;
                    r2 = r2 - r3;
                    r3 = sp0x70.getY();
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                    r3 = r3 - r5;
                    MEMORY.ref(4, CPU.sp().value).setu(r5);
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                    r0 = r7;
                    r1 = 0x3e;
                    r2 = 0x0;
                    FUN_80e38b8(r0, r1, r2);
                    r3 = r10;
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                    r3 = r3 + 0x16;
                    if(r5 > r3) {
                      r0 = actor1.pos_08.getX();
                      r3 = MEMORY.ref(4, r7).get();
                      r1 = actor1.pos_08.getY();
                      r0 = r0 - r3;
                      r3 = MEMORY.ref(4, r7 + 0x4).get();
                      r1 = r1 + r11;
                      r1 = r1 - r3;
                      r3 = actor1.pos_08.getZ();
                      r2 = MEMORY.ref(4, r7 + 0x8).get();
                      r3 = r3 - r2;
                      r4 = r3 >> 8;
                      r3 = MEMORY.ref(4, r7 + 0xc).get();
                      r0 = r0 >> 8;
                      r3 = r3 + r0;
                      MEMORY.ref(4, r7 + 0xc).setu(r3);
                      r3 = MEMORY.ref(4, r7 + 0x10).get();
                      r1 = r1 >> 8;
                      r3 = r3 + r1;
                      MEMORY.ref(4, r7 + 0x10).setu(r3);
                      r3 = MEMORY.ref(4, r7 + 0x14).get();
                      r3 = r3 + r4;
                      MEMORY.ref(4, r7 + 0x14).setu(r3);
                      r3 = 0xfff;
                      r2 = 0x1ffe;
                      r0 = r0 + r3;
                      if((r0 & 0xffff_ffffL) <= (r2 & 0xffff_ffffL)) {
                        r3 = r4 + r3;
                        if((r3 & 0xffff_ffffL) <= (r2 & 0xffff_ffffL)) {
                          r3 = 0x1;
                          r3 = -r3;
                          MEMORY.ref(4, r7 + 0x18).setu(r3);
                        }
                      }
                    }
                  }

                  //LAB_80e577e
                  r5 = 0x1;
                  r10 = r10 + r5;
                  r0 = r10;
                  r7 = r7 + 0x1c;
                } while(r0 != 0x20);
              }
            } else {
              //LAB_80e57b4
              r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if(r1 != 0x15) {
                //LAB_80e57be
                if(r1 == 0x6 || r1 == 0x1b) {
                  //LAB_80e57c8
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                  r3 = r3 - 0x6;
                  if((r3 & 0xffff_ffffL) <= (0xd & 0xffff_ffffL)) {
                    r2 = 0x0;
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                    r10 = r2;

                    //LAB_80e57d6
                    do {
                      r3 = r5 >>> 31;
                      r3 = r5 + r3;
                      r2 = 0x3;
                      r3 = r3 >> 1;
                      r3 = r3 & r2;
                      r2 = r3 << 1;
                      r2 = r2 + r3;
                      r1 = r2 << 4;
                      r1 = r1 - r2;
                      r3 = 0x2010c56;
                      r2 = sp0xa0.getX();
                      r1 = r1 << 6;
                      r1 = r1 + r3;
                      r3 = r2 >>> 31;
                      r2 = r2 + r3;
                      r3 = 0x18;
                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                      r2 = r2 >> 1;
                      r3 = 0x68;
                      r2 = r2 - 0x8;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                      r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                      r3 = 0x0;
                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      r1 = 0x1;
                      r10 = r10 + r1;
                      r2 = r10;
                      r5 = r5 + 0x3;
                    } while(r2 != 0x2);
                  }

                  //LAB_80e5818
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                  r3 = r3 - 0x8;
                  if((r3 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL)) {
                    //LAB_80e5824
                    r5 = 0x80edeca;
                    r0 = 0x80eded0;
                    r3 = 0x0;
                    r10 = r3;
                    r11 = r5;
                    r9 = r0;

                    //LAB_80e5832
                    do {
                      r8 = r10;
                      r1 = r8;
                      r1 = r1 & 0x3;
                      r8 = r1;
                      r0 = rand();
                      r3 = 0xffff;
                      r5 = r0;
                      r5 = r5 & r3;
                      r0 = r5;
                      r0 = sin(r0);
                      r3 = sp0xa0.getX();
                      r6 = r0;
                      r2 = r3 >>> 31;
                      r3 = r3 + r2;
                      r6 = r6 << 3;
                      r1 = r8;
                      r3 = r3 >> 1;
                      r0 = r11;
                      r6 = r6 >> 16;
                      r6 = r6 + r3;
                      r3 = MEMORY.ref(1, r0 + r1).getUnsigned();
                      r0 = r5;
                      r3 = r3 >>> 1;
                      r6 = r6 - r3;
                      r0 = cos(r0);
                      r2 = r9;
                      r5 = r0;
                      r0 = r8;
                      r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
                      r5 = r5 << 5;
                      r3 = r3 >>> 1;
                      r0 = 0x2f;
                      r5 = r5 >> 16;
                      r5 = r5 - r3;
                      freeSlot(r0);
                      r0 = 0x2e;
                      freeSlot(r0);
                      r0 = rand();
                      r3 = 0x80eedd0;
                      r0 = r0 & 0x3;
                      r2 = MEMORY.ref(1, r3 + r0).getUnsigned();
                      r3 = 0x3 | r2;
                      r2 = 0x2;
                      MEMORY.ref(4, CPU.sp().value).setu(r2);
                      r1 = 0x7;
                      r2 = 0x7;
                      r0 = 0x2f;
                      r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                      r2 = 0x80edebe;
                      r1 = r8;
                      r3 = r1 << 1;
                      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
                      r2 = 0x2010000;
                      r0 = r11;
                      r1 = r1 + r2;
                      r2 = r8;
                      r3 = MEMORY.ref(1, r0 + r2).getUnsigned();
                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                      r0 = r9;
                      r3 = MEMORY.ref(1, r0 + r2).getUnsigned();
                      r2 = 0x3001f0c;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                      r5 = r5 + 0x38;
                      r4 = MEMORY.ref(4, r2).get();
                      r3 = r5;
                      r2 = r6;
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      r0 = 0x2f;
                      freeSlot(r0);
                      r0 = 0x7828;
                      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                      r3 = r5 + r0;
                      r3 = MEMORY.ref(4, r3).get();
                      r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                      r0 = MEMORY.ref(4, r3 + 0x4).get();
                      FUN_80cef64(r0, r1);
                      r1 = 0x1;
                      r10 = r10 + r1;
                      r2 = r10;
                    } while(r2 != 0x3);
                  }
                } else {
                  //LAB_80e58f2
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                  if(r3 == 0xe) {
                    //LAB_80e58fa
                    r0 = 0x2f;
                    freeSlot(r0);
                    r0 = 0x2e;
                    freeSlot(r0);
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                    if((r5 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
                      //LAB_80e590e
                      r3 = sp0xa0.getX();
                      r2 = r3 >>> 31;
                      r3 = r3 + r2;
                      r3 = r3 >> 1;
                      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
                      r3 = r5 << 5;
                      r3 = r3 - 0xe8;
                      r11 = r3;
                      r3 = r5 << 4;
                      r1 = r11;
                      r7 = r3 - 0x30;
                      if(r1 > 0x0) {
                        r2 = 0x0;
                        r11 = r2;
                      }

                      //LAB_80e5930
                      if(r7 > 0x68) {
                        //LAB_80e5934
                        do {
                          r7 = r7 - 0x68;
                        } while(r7 > 0x68);
                      }

                      //LAB_80e593a
                      r3 = 0x2;
                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                      r1 = 0x7;
                      r2 = 0x7;
                      r3 = 0x3;
                      r0 = 0x2f;
                      r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                      r3 = 0x3001e50;
                      r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                      r8 = r3;
                      r5 = 0xbc;
                      r1 = r11;
                      r8 = r8 + r5;
                      r1 = r1 + r7;
                      r6 = 0x11;
                      r5 = 0x68;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
                      MEMORY.ref(4, CPU.sp().value).setu(r6);
                      r9 = r1;
                      r0 = r0 - 0x8;
                      r10 = r0;
                      r2 = r8;
                      r3 = r9;
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                      r4 = MEMORY.ref(4, r2).get();
                      r3 = r3 - 0x68;
                      r1 = 0x2010000;
                      r2 = r10;
                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      r5 = r5 - r7;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
                      MEMORY.ref(4, CPU.sp().value).setu(r6);
                      r3 = r8;
                      r4 = MEMORY.ref(4, r3).get();
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                      r1 = 0x2010000;
                      r2 = r10;
                      r3 = r9;
                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      r0 = 0x22;
                      MEMORY.ref(4, CPU.sp().value).setu(r0);
                      r0 = 0x41;
                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                      r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                      r3 = r11;
                      r5 = r8;
                      r1 = 0x20106e8;
                      r2 = r2 - 0x11;
                      r3 = r3 + 0x2f;
                      r4 = MEMORY.ref(4, r5).get();
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      r0 = 0x2f;
                      freeSlot(r0);
                      r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                      if(r0 == 0x8) {
                        r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                        r2 = 0x77a8;
                        r3 = r1 + r2;
                        MEMORY.ref(4, r3).setu(r0);
                      }

                      //LAB_80e59be
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                      if(r3 > 0x1) {
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                        r1 = 0xe1;
                        r5 = 0x0;
                        r1 = r1 << 7;
                        r10 = r5;
                        r7 = 0x0;
                        r6 = 0xff;
                        r5 = r0 + r1;

                        //LAB_80e59d4
                        do {
                          r3 = MEMORY.ref(4, r5 + 0x18).get();
                          if(r3 == 0x0) {
                            r3 = sp1c.pos_08.getX();
                            MEMORY.ref(4, r5).setu(r3);
                            r3 = 0xa0;
                            r3 = r3 << 13;
                            MEMORY.ref(4, r5 + 0x4).setu(r3);
                            r3 = sp1c.pos_08.getZ();
                            MEMORY.ref(4, r5 + 0x8).setu(r3);
                            r0 = rand();
                            r0 = r0 & r6;
                            r0 = r0 - 0x7f;
                            r0 = r0 << 12;
                            MEMORY.ref(4, r5 + 0xc).setu(r0);
                            r0 = rand();
                            r0 = r0 & r6;
                            r0 = r0 - 0x40;
                            r0 = r0 << 10;
                            MEMORY.ref(4, r5 + 0x10).setu(r0);
                            r0 = rand();
                            r0 = r0 & r6;
                            r0 = r0 - 0x7f;
                            r0 = r0 << 12;
                            MEMORY.ref(4, r5 + 0x14).setu(r0);
                            r0 = r10;
                            r3 = r0 >>> 31;
                            r3 = r3 + r10;
                            r3 = r3 >> 1;
                            r3 = r3 + 0x20;
                            r7 = r7 + 0x1;
                            MEMORY.ref(4, r5 + 0x18).setu(r3);
                            if(r7 == 0x4) {
                              break;
                            }
                          }

                          //LAB_80e5a20
                          r1 = 0x1;
                          r10 = r10 + r1;
                          r2 = r10;
                          r5 = r5 + 0x1c;
                        } while(r2 != 0x40);
                      }
                    }
                    r0 = 0x7828;
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                    r3 = r5 + r0;
                    r3 = MEMORY.ref(4, r3).get();
                    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                    r0 = MEMORY.ref(4, r3 + 0x4).get();
                    FUN_80cef64(r0, r1);
                  } else {
                    //LAB_80e5a2e
                    r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                    if(r1 == 0x1f) {
                      r0 = 0x2f;
                      freeSlot(r0);
                      r0 = 0x2e;
                      freeSlot(r0);
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                      r3 = r3 - 0x4;
                      if((r3 & 0xffff_ffffL) <= (0x13 & 0xffff_ffffL)) {
                        r5 = sp0xa0.getX();
                        r3 = r5 >>> 31;
                        r0 = 0x2;
                        r5 = r5 + r3;
                        r3 = 0x30;
                        MEMORY.ref(4, CPU.sp().value).setu(r0);
                        r9 = r3;
                        r10 = r0;
                        r1 = 0x7;
                        r2 = 0x7;
                        r3 = 0x3;
                        r0 = 0x2f;
                        r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                        r3 = r9;
                        r1 = 0x18;
                        r6 = 0x3001e50;
                        MEMORY.ref(4, CPU.sp().value).setu(r1);
                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                        r5 = r5 >> 1;
                        r6 = r6 + 0xbc;
                        r2 = r5;
                        r4 = MEMORY.ref(4, r6).get();
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                        r2 = r2 - 0x18;
                        r8 = r1;
                        r1 = 0x2010000;
                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        r0 = 0x2f;
                        freeSlot(r0);
                        r0 = r10;
                        MEMORY.ref(4, CPU.sp().value).setu(r0);
                        r1 = 0x7;
                        r2 = 0x7;
                        r3 = 0x7;
                        r0 = 0x2f;
                        r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                        r1 = r8;
                        r2 = r9;
                        MEMORY.ref(4, CPU.sp().value).setu(r1);
                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                        r4 = MEMORY.ref(4, r6).get();
                        r1 = 0x2010000;
                        r2 = r5;
                        r3 = 0x30;
                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        r0 = 0x2f;
                        freeSlot(r0);
                      }

                      //LAB_80e5ab6
                      r0 = 0x7828;
                      r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                      r3 = r5 + r0;
                      r3 = MEMORY.ref(4, r3).get();
                      r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                      r0 = MEMORY.ref(4, r3 + 0x4).get();
                      FUN_80cef64(r0, r1);
                    } else {
                      //LAB_80e5afc
                      r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                      if(r1 == 0x1e) {
                        r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                        if(r2 > 0xf) {
                          r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                          r2 = 0x20;
                          r1 = 0x1000;
                          r3 = 0x4000052;
                          r2 = r2 - r5;
                          r2 = r2 | r1;
                          MEMORY.ref(2, r3).setu(r2);
                        }

                        //LAB_80e5b16
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                        if(r0 > 0x5) {
                          //LAB_80e5b20
                          r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                          r6 = sp0xa0.getX();
                          r0 = r0 >>> 31;
                          r0 = r2 + r0;
                          r3 = r6 >>> 31;
                          r1 = 0x3;
                          r0 = r0 >> 1;
                          r6 = r6 + r3;
                          r0 = modS(r0, r1);
                          r5 = r0 << 2;
                          r5 = r5 + r0;
                          r3 = r5 << 9;
                          r6 = r6 >> 1;
                          r1 = 0x2010c56;
                          r6 = r6 - 0x14;
                          r9 = r3;
                          r0 = 0x28;
                          r2 = 0x20;
                          r1 = r1 + r9;
                          r10 = r0;
                          MEMORY.ref(4, CPU.sp().value).setu(r0);
                          r8 = r2;
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                          r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                          r2 = r6;
                          r3 = 0x10;
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                          r3 = 0x2012a56;
                          r5 = r5 << 8;
                          r5 = r5 + r3;
                          r0 = r10;
                          r1 = r8;
                          MEMORY.ref(4, CPU.sp().value).setu(r0);
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                          r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                          r1 = r5;
                          r2 = r6;
                          r3 = 0x30;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                          r2 = 0x2011156;
                          r3 = r10;
                          r9 = r9 + r2;
                          r5 = r8;
                          MEMORY.ref(4, CPU.sp().value).setu(r3);
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
                          r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                          r1 = r9;
                          r2 = r6;
                          r3 = 0x50;
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        }
                      } else {
                        //LAB_80e5bac
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                        if(r0 == 0x5 || r0 == 0x17) {
                          //LAB_80e5bb6
                          r1 = 0x0;
                          r7 = 0x2014000;
                          r10 = r1;

                          //LAB_80e5bc2
                          do {
                            r5 = r10;
                            r3 = r5 >>> 31;
                            r3 = r3 + r10;
                            r3 = r3 >> 1;
                            r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                            r3 = r3 + 0x4;
                            if(r0 >= r3) {
                              r3 = MEMORY.ref(4, r7 + 0x18).get();
                              if(r3 <= 0xb) {
                                r5 = r3 >>> 31;
                                r5 = r3 + r5;
                                FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x70);
                                r2 = sp0x70.getX();
                                r1 = 0x2010000;
                                r3 = r2 >>> 31;
                                r5 = r5 >> 1;
                                r2 = r2 + r3;
                                r5 = r5 << 11;
                                r3 = sp0x70.getY();
                                r2 = r2 >> 1;
                                r5 = r5 + r1;
                                r1 = 0x20;
                                sp0x70.setX(r2);
                                MEMORY.ref(4, CPU.sp().value).setu(r1);
                                r1 = 0x40;
                                r3 = r3 - 0x20;
                                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                r2 = r2 - 0x10;
                                r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                r1 = r5;
                                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                r2 = 0x80;
                                r0 = r7;
                                r1 = 0x3c;
                                r2 = r2 << 5;
                                FUN_80e38b8(r0, r1, r2);
                                r3 = MEMORY.ref(4, r7 + 0x18).get();
                                r3 = r3 + 0x1;
                                MEMORY.ref(4, r7 + 0x18).setu(r3);
                              }
                            }

                            //LAB_80e5c22
                            r2 = 0x1;
                            r10 = r10 + r2;
                            r3 = r10;
                            r7 = r7 + 0x1c;
                          } while(r3 != 0x10);
                        } else {
                          //LAB_80e5c32
                          r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                          if(r5 != 0x4) {
                            //LAB_80e5c3a
                            if(r5 == 0xb) {
                              //LAB_80e5c40
                              r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                              r5 = r0 << 9;
                              r0 = r5;
                              r0 = sin(r0);
                              r0 = r5;
                              r0 = cos(r0);
                              r0 = r0 << 2;
                              r3 = sp0xa0.getY() >> 16;
                              r0 = r0 >> 16;
                              r3 = r3 + r0;
                              r5 = r3;
                              r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                              r5 = r5 + 0x10;
                              if(r3 <= 0x3) {
                                r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                r2 = 0x7828;
                                r3 = r0 + r2;
                                r3 = MEMORY.ref(4, r3).get();
                                r2 = MEMORY.ref(4, r3 + 0x4).get();
                                r1 = 0x80eedd4;
                                r3 = r2 << 3;
                                r3 = r3 - r2;
                                r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
                                r3 = 0x80eede2;
                                r1 = 0x39;
                                r3 = MEMORY.ref(1, r3).getUnsigned();
                                MEMORY.ref(4, CPU.sp().value).setu(r1);
                                r1 = 0x62;
                                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                r3 = r5 + r3;
                                r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                              } else {
                                //LAB_80e5c92
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                if(r3 <= 0x7) {
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                  r2 = 0x7828;
                                  r3 = r0 + r2;
                                  r3 = MEMORY.ref(4, r3).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r1 = 0x80eedd4;
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
                                  r3 = 0x80eede2;
                                  r1 = 0x39;
                                  r3 = MEMORY.ref(1, r3).getUnsigned();
                                  MEMORY.ref(4, CPU.sp().value).setu(r1);
                                  r1 = 0x62;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }

                                //LAB_80e5cc2
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                r0 = 0x15d2;
                                r1 = r3 + r0;
                                r0 = 0x7828;
                                r6 = r3 + r0;
                                r3 = MEMORY.ref(4, r6).get();
                                r2 = 0x80eedd4;
                                r8 = r2;
                                r2 = MEMORY.ref(4, r3 + 0x4).get();
                                r3 = r2 << 3;
                                r3 = r3 - r2;
                                r7 = 0x80eede2;
                                r3 = r3 + 0x1;
                                r0 = r8;
                                r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
                                r3 = MEMORY.ref(1, r7 + 0x1).getUnsigned();
                                r0 = 0x63;
                                MEMORY.ref(4, CPU.sp().value).setu(r0);
                                r0 = 0x45;
                                r3 = r5 + r3;
                                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0x4;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r1 = 0x80;
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  r1 = r1 << 7;
                                  r2 = 0x3f3f3f3f;
                                  memfill32(r0, r1, r2);
                                }

                                //LAB_80e5d0a
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0x6;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                  r3 = 0x3081;
                                  r1 = r2 + r3;
                                  r3 = MEMORY.ref(4, r6).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r3 = r3 + 0x2;
                                  r0 = r8;
                                  r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
                                  r3 = MEMORY.ref(1, r7 + 0x2).getUnsigned();
                                  r0 = 0x80;
                                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                                  r0 = 0x5b;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }

                                //LAB_80e5d3a
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0x8;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r3 = MEMORY.ref(4, r6).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r3 = r3 + 0x3;
                                  r1 = r8;
                                  r2 = MEMORY.ref(1, r1 + r3).getUnsigned();
                                  r3 = MEMORY.ref(1, r7 + 0x3).getUnsigned();
                                  r1 = 0x80;
                                  MEMORY.ref(4, CPU.sp().value).setu(r1);
                                  r1 = 0x5b;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  r1 = 0x2010000;
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }

                                //LAB_80e5d66
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0xa;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r3 = MEMORY.ref(4, r6).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r3 = r3 + 0x4;
                                  r0 = r8;
                                  r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
                                  r3 = MEMORY.ref(1, r7 + 0x4).getUnsigned();
                                  r0 = 0x80;
                                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                                  r0 = 0x3b;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                  r1 = 0x2012d80;
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }

                                //LAB_80e5d92
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0xc;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r3 = MEMORY.ref(4, r6).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r3 = r3 + 0x5;
                                  r0 = r8;
                                  r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
                                  r3 = MEMORY.ref(1, r7 + 0x5).getUnsigned();
                                  r0 = 0x7a;
                                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                                  r0 = 0x1d;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                  r1 = 0x2014b00;
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }

                                //LAB_80e5dbe
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0xe;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  //LAB_80e5dc8
                                  r3 = MEMORY.ref(4, r6).get();
                                  r2 = MEMORY.ref(4, r3 + 0x4).get();
                                  r3 = r2 << 3;
                                  r3 = r3 - r2;
                                  r3 = r3 + 0x6;
                                  r0 = r8;
                                  r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
                                  r3 = MEMORY.ref(1, r7 + 0x6).getUnsigned();
                                  r0 = 0x4c;
                                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                                  r0 = 0x19;
                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                  r1 = 0x20158d2;
                                  r3 = r5 + r3;
                                  r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                }
                              }
                            } else {
                              //LAB_80e5e28
                              r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                              if(r1 == 0x20) {
                                //LAB_80e5e30
                                r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                                r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r2 = r2 + r3;
                                MEMORY.ref(4, CPU.sp().value + 0x48).setu(r2);
                                if(r5 > 0x6) {
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                                  r3 = r3 << 1;
                                  r3 = r3 + r0;
                                  r3 = r3 << 4;
                                  if(r3 < 0x0) {
                                    r3 = r3 + 0x3f;
                                  }

                                  //LAB_80e5e4c
                                  r3 = r3 >> 6;
                                  MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
                                }

                                //LAB_80e5e50
                                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                                r2 = 0x4000028;
                                r3 = r1 >> 16;
                                r3 = r3 << 8;
                                MEMORY.ref(4, r2).setu(r3);
                                r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r1 = r1 - 0x10;
                                if((r1 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL)) {
                                  r2 = 0x10;
                                  r2 = r2 - r1;
                                  r1 = 0x1000;
                                  r3 = 0x4000052;
                                  r2 = r2 | r1;
                                  MEMORY.ref(2, r3).setu(r2);
                                }

                                //LAB_80e5e6e
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                r3 = r3 - 0x4;
                                if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                  r1 = 0x80;
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                  r1 = r1 << 7;
                                  r2 = 0x3f3f3f3f;
                                  memfill32(r0, r1, r2);
                                }

                                //LAB_80e5e84
                                r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                if(r2 <= 0x3) {
                                  r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                  r0 = 0x7828;
                                  r3 = r5 + r0;
                                  r3 = MEMORY.ref(4, r3).get();
                                  r3 = MEMORY.ref(4, r3 + 0x4).get();

                                  //LAB_80e5eb4
                                  if(r3 == 0x1) {
                                    r3 = 0x50;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x68;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r1 = r5;
                                    r2 = 0x0;
                                  } else {
                                    //LAB_80e5eca
                                    r3 = 0x50;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x68;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                    r2 = 0x30;
                                  }

                                  //LAB_80e5eda
                                  r3 = 0x18;
                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                } else {
                                  //LAB_80e5ee2
                                  r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  if(r1 <= 0x7) {
                                    r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                    r5 = 0x7828;
                                    r3 = r2 + r5;
                                    r3 = MEMORY.ref(4, r3).get();
                                    r3 = MEMORY.ref(4, r3 + 0x4).get();
                                    if(r3 == 0x1) {
                                      r3 = 0x50;
                                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                                      r3 = 0x68;
                                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                      r1 = r2;
                                      r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                      r2 = 0x0;
                                      r3 = 0x18;
                                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                    } else {
                                      //LAB_80e5f0e
                                      r3 = 0x50;
                                      MEMORY.ref(4, CPU.sp().value).setu(r3);
                                      r3 = 0x68;
                                      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                      r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                      r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                      r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                      r2 = 0x30;
                                      r3 = 0x18;
                                      MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                    }
                                  }

                                  //LAB_80e5f24
                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                  r1 = 0x7828;
                                  r3 = r0 + r1;
                                  r3 = MEMORY.ref(4, r3).get();
                                  r3 = MEMORY.ref(4, r3 + 0x4).get();
                                  if(r3 == 0x1) {
                                    r3 = 0x50;
                                    r2 = 0xf0;
                                    r2 = r2 << 5;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x68;
                                    r1 = r0 + r2;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x10;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  } else {
                                    //LAB_80e5f4e
                                    r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                    r5 = 0xf0;
                                    r5 = r5 << 5;
                                    r1 = r3 + r5;
                                    r3 = 0x50;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x68;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x20;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }

                                  //LAB_80e5f6a
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  r3 = r3 - 0x6;
                                  if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                    r3 = 0x80;
                                    r2 = 0xfa;
                                    r2 = r2 << 6;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x5b;
                                    r1 = r0 + r2;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x0;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }

                                  //LAB_80e5f8e
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  r3 = r3 - 0x8;
                                  if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                    r3 = 0x80;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x5b;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r1 = 0x2010000;
                                    r2 = 0x0;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }

                                  //LAB_80e5fac
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  r3 = r3 - 0xa;
                                  if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                    r3 = 0x80;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x3b;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r1 = 0x2012d80;
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x0;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }

                                  //LAB_80e5fca
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  r3 = r3 - 0xc;
                                  if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                    r3 = 0x80;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x1d;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r1 = 0x2014b00;
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x0;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }

                                  //LAB_80e5fe8
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                  r3 = r3 - 0xe;
                                  if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                    //LAB_80e5ff2
                                    r3 = 0x80;
                                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                                    r3 = 0x1a;
                                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                                    r1 = 0x2015980;
                                    r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                    r2 = 0x0;
                                    r3 = 0x10;
                                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                  }
                                }
                              } else {
                                //LAB_80e600a
                                r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                if(r3 == 0x14) {
                                  r5 = 0x0;
                                  r10 = r5;

                                  //LAB_80e6014
                                  do {
                                    r3 = r10;
                                    r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                    r5 = r10;
                                    r3 = r3 + 0x6;
                                    r5 = r5 + 0x1;
                                    if(r0 >= r3) {
                                      r3 = r3 + 0xc;
                                      if(r0 < r3) {
                                        r1 = r10;
                                        r3 = r0 - r1;
                                        r3 = r3 - 0x6;
                                        r2 = r3 >>> 31;
                                        r3 = r3 + r2;
                                        r4 = r3 >> 1;
                                        r2 = sp0xa0.getX();
                                        r7 = 0x80ede9f;
                                        r3 = r2 >>> 31;
                                        r2 = r2 + r3;
                                        r3 = MEMORY.ref(1, r7 + r4).getUnsigned();
                                        r2 = r2 >> 1;
                                        r3 = r3 >>> 1;
                                        r6 = r2 - r3;
                                        r3 = 0x1;
                                        r3 = r3 & r1;
                                        if(r3 != 0x0) {
                                          r3 = r5 >>> 31;
                                          r3 = r5 + r3;
                                          r3 = r3 >> 1;
                                          r2 = r3 << 1;
                                          r2 = r2 + r3;
                                          r6 = r6 + r2;
                                        } else {
                                          //LAB_80e605c
                                          r5 = r10;
                                          r5 = r5 + 0x1;
                                          r3 = r5 >>> 31;
                                          r3 = r5 + r3;
                                          r3 = r3 >> 1;
                                          r2 = r3 << 1;
                                          r2 = r2 + r3;
                                          r6 = r6 - r2;
                                        }

                                        //LAB_80e606c
                                        r1 = r10;
                                        r0 = 0x1;
                                        if(r1 != 0x0) {
                                          r3 = r10;
                                          r3 = r3 - 0x1;
                                          r2 = 0x3;
                                          r3 = r3 & r2;
                                          r0 = 0x0;
                                          if(r3 > 0x1) {
                                            r0 = 0x1;
                                          }
                                        }

                                        //LAB_80e6084
                                        r2 = 0x80edeb2;
                                        r3 = r4 << 1;
                                        r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
                                        r2 = 0x2010000;
                                        r3 = 0x80edeab;
                                        r1 = r1 + r2;
                                        r2 = MEMORY.ref(1, r7 + r4).getUnsigned();
                                        r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
                                        MEMORY.ref(4, CPU.sp().value).setu(r2);
                                        r2 = 0x80edea5;
                                        r2 = MEMORY.ref(1, r2 + r4).getUnsigned();
                                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
                                        r2 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                                        r0 = r0 << 2;
                                        r4 = MEMORY.ref(4, r0 + r2).get();
                                        r3 = r3 + 0x30;
                                        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                        r2 = r6;
                                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                      } else {
                                        //LAB_80e60ae
                                        r5 = r10;
                                        r5 = r5 + 0x1;
                                      }
                                    }

                                    //LAB_80e60b2
                                    r10 = r5;
                                  } while(r5 != 0xc);
                                } else {
                                  //LAB_80e60ba
                                  r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                  if(r3 == 0x10) {
                                    //LAB_80e60c2
                                    r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                    if(r5 == 0x0) {
                                      r0 = 0x0;
                                      r6 = 0xffff;
                                      r5 = 0x2014000;
                                      r10 = r0;
                                      r7 = 0x0;

                                      //LAB_80e60d2
                                      do {
                                        r0 = rand();
                                        r3 = 0x7f;
                                        r3 = r3 & r0;
                                        r3 = r3 + 0x20;
                                        MEMORY.ref(4, r5).setu(r3);
                                        MEMORY.ref(4, r5 + 0x4).setu(r7);
                                        MEMORY.ref(4, r5 + 0x8).setu(r7);
                                        r0 = rand();
                                        r0 = r0 & r6;
                                        MEMORY.ref(4, r5 + 0xc).setu(r0);
                                        r0 = rand();
                                        r0 = r0 & r6;
                                        MEMORY.ref(4, r5 + 0x10).setu(r0);
                                        r0 = rand();
                                        r1 = 0x1;
                                        r10 = r10 + r1;
                                        r0 = r0 & r6;
                                        r2 = r10;
                                        MEMORY.ref(4, r5 + 0x14).setu(r0);
                                        r5 = r5 + 0x1c;
                                      } while(r2 != 0x40);

                                      r2 = 0x20146e4;
                                      r3 = 0x9f;
                                      MEMORY.ref(4, r2 + 0x4).setu(r3);
                                    }

                                    //LAB_80e610c
                                    r3 = 0x0;
                                    r7 = 0x2014000;
                                    r10 = r3;

                                    //LAB_80e611c
                                    do {
                                      r3 = MEMORY.ref(4, r7).get();
                                      if(r3 >= 0x0) {
                                        r1 = r10;
                                        r3 = r1 >>> 31;
                                        r3 = r3 + r10;
                                        r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                        r3 = r3 >> 1;
                                        if(r2 >= r3) {
                                          r5 = 0x3;
                                          r5 = r5 & r1;
                                          initMatrixStack();
                                          r0 = MEMORY.ref(4, r7 + 0xc).get();
                                          rotateMatrixX(r0);
                                          r0 = MEMORY.ref(4, r7 + 0x10).get();
                                          rotateMatrixY(r0);
                                          FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x70);
                                          r2 = sp0x70.getX();
                                          r3 = r2 >>> 31;
                                          r2 = r2 + r3;
                                          r3 = sp0xa0.getX();
                                          r1 = r3 >>> 31;
                                          r3 = r3 + r1;
                                          r3 = r3 >> 1;
                                          r2 = r2 >> 1;
                                          r2 = r2 + r3;
                                          sp0x70.setX(r2);
                                          r3 = sp0x70.getY();
                                          r1 = sp0xa0.getY();
                                          r3 = r3 + r1;
                                          r1 = r3;
                                          r1 = r1 + 0x20;
                                          sp0x70.setY(r1);
                                          r1 = 0x80eedea;
                                          r0 = 0x8;
                                          r5 = r5 << 1;
                                          r1 = MEMORY.ref(2, r1 + r5).getUnsigned();
                                          MEMORY.ref(4, CPU.sp().value).setu(r0);
                                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                          r5 = 0x2010000;
                                          r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                                          r3 = r3 + 0x1c;
                                          r4 = MEMORY.ref(4, r0 + 0x4).get();
                                          r1 = r1 + r5;
                                          r2 = r2 - 0x4;
                                          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                          r3 = MEMORY.ref(4, r7).get();
                                          r3 = r3 - 0x6;
                                          MEMORY.ref(4, r7).setu(r3);
                                          if(r3 < 0x0) {
                                            r3 = 0x7;
                                            r1 = r10;
                                            r3 = r3 & r1;
                                            if(r3 == 0x0 || r1 == 0x3f) {
                                              //LAB_80e61a6
                                              r0 = 0x85;
                                              playSound_(r0);
                                              r5 = 0x7828;
                                              r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                              r3 = r2 + r5;
                                              r3 = MEMORY.ref(4, r3).get();
                                              r1 = 0x24;
                                              r0 = MEMORY.ref(2, r3 + r1).get();
                                              r3 = 0x4;
                                              MEMORY.ref(4, CPU.sp().value).setu(r3);
                                              r1 = 0x7;
                                              r2 = 0x5;
                                              r3 = 0x0;
                                              FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                                            }
                                          }
                                        }
                                      }

                                      //LAB_80e61c6
                                      r2 = 0x1;
                                      r10 = r10 + r2;
                                      r3 = r10;
                                      r7 = r7 + 0x1c;
                                    } while(r3 != 0x40);
                                  } else {
                                    //LAB_80e61d4
                                    r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                    if(r5 == 0x8) {
                                      r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                      r3 = r3 - 0x5;
                                      if((r3 & 0xffff_ffffL) <= (0x2c & 0xffff_ffffL)) {
                                        //LAB_80e61e4
                                        r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                        if(r0 > 0x19) {
                                          r2 = r0 << 2;
                                          r3 = 0xc4;
                                          r1 = r3 - r2;
                                        } else {
                                          //LAB_80e61f2
                                          r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                          r3 = r1 << 4;
                                          r1 = r3;
                                          r1 = r1 - 0x40;
                                        }

                                        //LAB_80e61fa
                                        if(r1 > 0x60) {
                                          r1 = 0x60;
                                        }

                                        //LAB_80e6200
                                        r2 = 0x20;
                                        r3 = 0x68;
                                        r3 = r3 - r1;
                                        MEMORY.ref(4, CPU.sp().value).setu(r2);
                                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                        r4 = MEMORY.ref(4, CPU.sp().value + 0x68).get();
                                        r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                        r1 = 0x2010000;
                                        r2 = 0x30;
                                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                      }
                                    } else {
                                      //LAB_80e6218
                                      r3 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                      r3 = r3 - 0x21;
                                      if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
                                        r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                        if(r2 <= 0x5) {
                                          //LAB_80e6228
                                          r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                                          r0 = 0x7828;
                                          r3 = r5 + r0;
                                          r3 = MEMORY.ref(4, r3).get();
                                          r3 = MEMORY.ref(4, r3 + 0x4).get();
                                          if(r3 == 0x0) {
                                            r1 = sp0xa0.getX();
                                            r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                            r3 = r1 >>> 31;
                                            r1 = r1 + r3;
                                            r3 = 0x6;
                                            r3 = r3 - r5;
                                            r2 = r3 << 1;
                                            r2 = r2 + r3;
                                            r3 = r2 << 1;
                                            r1 = r1 >> 1;
                                            r1 = r1 + r3;
                                          } else {
                                            //LAB_80e6288
                                            r1 = sp0xa0.getX();
                                            r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                            r3 = r1 >>> 31;
                                            r1 = r1 + r3;
                                            r3 = 0x6;
                                            r3 = r3 - r5;
                                            r2 = r3 << 1;
                                            r2 = r2 + r3;
                                            r3 = r2 << 1;
                                            r1 = r1 >> 1;
                                            r1 = r1 - r3;
                                          }

                                          //LAB_80e62a2
                                          r3 = sp0xa0.getY();
                                          r2 = r2 << 2;
                                          r3 = r3 - r2;
                                          r3 = r3 + 0x18;
                                          r2 = r1;
                                          r1 = 0x20;
                                          MEMORY.ref(4, CPU.sp().value).setu(r1);
                                          r1 = 0x40;
                                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                                          r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                                          r2 = r2 - 0x10;
                                          r4 = MEMORY.ref(4, r1 + 0x4).get();
                                          r3 = r3 - 0x20;
                                          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                          r1 = 0x2010000;
                                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                        }
                                      } else {
                                        //LAB_80e62cc
                                        r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                        if(r2 == 0xc) {
                                          r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                          if(r3 > 0x2f) {
                                            r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                            r2 = 0x40;
                                            r1 = 0x1000;
                                            r3 = 0x4000052;
                                            r2 = r2 - r5;
                                            r2 = r2 | r1;
                                            MEMORY.ref(2, r3).setu(r2);
                                          }

                                          //LAB_80e62e6
                                          r0 = 0x0;
                                          r1 = 0x3;
                                          r2 = 0x1;
                                          r7 = 0x2014000;
                                          r10 = r0;
                                          r9 = r1;
                                          r8 = r2;

                                          //LAB_80e6308
                                          do {
                                            r0 = r10;
                                            r1 = 0x3;
                                            r0 = modS(r0, r1);
                                            r5 = r0;
                                            FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x70);
                                            r2 = sp0x70.getX();
                                            r3 = r2 >>> 31;
                                            r2 = r2 + r3;
                                            r2 = r2 >> 1;
                                            sp0x70.setX(r2);
                                            r0 = 0x18;
                                            r4 = r10;
                                            r3 = r8;
                                            r1 = r5 << 3;
                                            r4 = r4 & r3;
                                            r1 = r1 + r5;
                                            r3 = sp0x70.getY();
                                            r5 = 0x2010000;
                                            MEMORY.ref(4, CPU.sp().value).setu(r0);
                                            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                            r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                                            r4 = r4 << 2;
                                            r1 = r1 << 6;
                                            r4 = MEMORY.ref(4, r4 + r0).get();
                                            r1 = r1 + r5;
                                            r2 = r2 - 0xc;
                                            r3 = r3 - 0xc;
                                            r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                            r3 = r10;
                                            r1 = r9;
                                            r3 = r3 & r1;
                                            r3 = r3 + 0xb;
                                            r2 = r8;
                                            r2 = r2 << r3;
                                            r0 = r7;
                                            r1 = 0x3c;
                                            FUN_80e38b8(r0, r1, r2);
                                            r3 = MEMORY.ref(4, r7 + 0x18).get();
                                            r2 = 0x1;
                                            r3 = r3 + 0x1;
                                            r10 = r10 + r2;
                                            MEMORY.ref(4, r7 + 0x18).setu(r3);
                                            r3 = r10;
                                            r7 = r7 + 0x1c;
                                          } while(r3 != 0x10);
                                        } else {
                                          //LAB_80e6374
                                          r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                          if(r5 != 0x64) {
                                            r0 = 0x0;
                                            r7 = 0x2014000;
                                            r10 = r0;

                                            //LAB_80e6386
                                            do {
                                              r3 = r10;
                                              r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
                                              r3 = r3 + 0x4;
                                              if(r2 >= r3) {
                                                r5 = MEMORY.ref(4, r7 + 0x18).get();
                                                if(r5 <= 0x17) {
                                                  if(r5 < 0x0) {
                                                    r5 = r5 + 0x3;
                                                  }

                                                  //LAB_80e639c
                                                  FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x70);
                                                  r2 = sp0x70.getX();
                                                  r3 = r2 >>> 31;
                                                  r2 = r2 + r3;
                                                  r5 = r5 >> 2;
                                                  r2 = r2 >> 1;
                                                  r3 = r10;
                                                  r0 = 0x18;
                                                  r4 = 0x1;
                                                  sp0x70.setX(r2);
                                                  r4 = r4 & r3;
                                                  r1 = r5 << 3;
                                                  r3 = sp0x70.getY();
                                                  MEMORY.ref(4, CPU.sp().value).setu(r0);
                                                  r0 = 0x30;
                                                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                                                  r1 = r1 + r5;
                                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                                                  r5 = 0x2010000;
                                                  r4 = r4 << 2;
                                                  r1 = r1 << 7;
                                                  r1 = r1 + r5;
                                                  r4 = MEMORY.ref(4, r4 + r0).get();
                                                  r2 = r2 - 0xc;
                                                  r3 = r3 - 0x18;
                                                  r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                                                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                                                  r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                                                  if(r1 == 0x19) {
                                                    r2 = 0x80;
                                                    r0 = r7;
                                                    r1 = 0x3c;
                                                    r2 = r2 << 3;
                                                    FUN_80e38b8(r0, r1, r2);
                                                  } else {
                                                    //LAB_80e63f0
                                                    r2 = 0x80;
                                                    r0 = r7;
                                                    r1 = 0x3c;
                                                    r2 = r2 << 5;
                                                    FUN_80e38b8(r0, r1, r2);
                                                  }

                                                  //LAB_80e63fc
                                                  r3 = MEMORY.ref(4, r7 + 0x18).get();
                                                  r3 = r3 + 0x1;
                                                  MEMORY.ref(4, r7 + 0x18).setu(r3);
                                                }
                                              }

                                              //LAB_80e6402
                                              r2 = 0x1;
                                              r10 = r10 + r2;
                                              r3 = r10;
                                              r7 = r7 + 0x1c;
                                            } while(r3 != 0x10);
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
                  }
                }
              }
            }

            //LAB_80e640e
            r5 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
            if(r5 <= 0x7) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r0 <= 0x5) {
                FUN_80e3944(sp0x94, sp0x70);
                r2 = sp0x70.getX();
                r3 = r2 >>> 31;
                r2 = r2 + r3;
                r2 = r2 >> 1;
                r0 = 0x14;
                sp0x70.setX(r2);
                r3 = sp0x70.getY();
                MEMORY.ref(4, CPU.sp().value).setu(r0);
                r0 = 0x28;
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                r5 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                r1 = 0x2013c56;
                r2 = r2 - 0xa;
                r3 = r3 - 0x4;
                r4 = MEMORY.ref(4, r5 + 0x4).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r3 = sp0x94.getX();
                r2 = MEMORY.ref(4, r1).get();
                r3 = r3 + r2;
                sp0x94.setX(r3);
                r3 = sp0x94.getY();
                r2 = MEMORY.ref(4, r1 + 0x4).get();
                r3 = r3 + r2;
                sp0x94.setY(r3);
                r3 = sp0x94.getZ();
                r2 = MEMORY.ref(4, r1 + 0x8).get();
                r3 = r3 + r2;
                sp0x94.setZ(r3);
              }
            }

            //LAB_80e6464
            r2 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            if(r2 == 0x3) {
              r0 = 0x1;
              r0 = -r0;
              FUN_80b50e8(r0);
            }

            //LAB_80e6472
            r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            if(r3 == 0x4) {
              r0 = 0x86;
              playSound_(r0);
            }

            //LAB_80e647e
            r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            if(r5 == 0x6) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
              if((r0 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r1 == 0x7 || r1 == 0xd || r1 == 0x12 || r1 == 0x13 || r1 == 0x17 || r1 == 0x22 || r1 == 0x64) {
                //LAB_80e64a8
                r2 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r5 = 0x7828;
                r3 = r2 + r5;
                r3 = MEMORY.ref(4, r3).get();
                r1 = 0x24;
                r0 = MEMORY.ref(2, r3 + r1).get();
                r1 = 0x4;
                FUN_80b5088(r0, r1);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r5 = r5 - 0x80;
                r2 = r3 + r5;
                r3 = 0x8;
                MEMORY.ref(4, r2).setu(r3);
              } else {
                //LAB_80e64c2
                r0 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                if(r0 == 0x14 || r0 == 0xe || r0 == 0x21) {
                  //LAB_80e64d0
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                  r2 = 0x7828;
                  r3 = r1 + r2;
                  r3 = MEMORY.ref(4, r3).get();
                  r1 = 0x1;
                  r5 = 0x24;
                  r0 = MEMORY.ref(2, r3 + r5).get();
                  FUN_80b5088(r0, r1);
                  r1 = 0x77a8;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                  r3 = 0x2;
                  r2 = r0 + r1;
                  MEMORY.ref(4, r2).setu(r3);
                } else {
                  //LAB_80e64ec
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
                  if(r2 == 0x1e || r2 == 0x8) {
                    //LAB_80e64f6
                    r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                    r0 = 0x7828;
                    r3 = r5 + r0;
                    r3 = MEMORY.ref(4, r3).get();
                    r1 = 0x24;
                    r0 = MEMORY.ref(2, r3 + r1).get();
                    r1 = 0x3;
                    FUN_80b5088(r0, r1);
                    r3 = 0x77a8;
                    r2 = r5 + r3;
                    r3 = 0x8;
                    MEMORY.ref(4, r2).setu(r3);
                  }
                }
              }

              //LAB_80e6510
              r5 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
              if(r5 == 0x6) {
                r0 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
                r1 = 0x7828;
                r3 = r0 + r1;
                r3 = MEMORY.ref(4, r3).get();
                r2 = 0x24;
                r0 = MEMORY.ref(2, r3 + r2).get();
                r3 = 0x4;
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r1 = 0x7;
                r2 = 0x5;
                r3 = 0x0;
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              }
            }

            //LAB_80e6530
            r3 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            if(r3 == 0xe) {
              r0 = 0x7828;
              r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
              r3 = r5 + r0;
              r3 = MEMORY.ref(4, r3).get();
              r1 = 0x24;
              r0 = MEMORY.ref(2, r3 + r1).get();
              r3 = 0x4;
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              r1 = 0x7;
              r2 = 0x5;
              r3 = 0x0;
              FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            }

            //LAB_80e6550
            r1 = 0x8;
            r0 = 0x8;
            FUN_80e155c(r0, r1);
            FUN_80cd52c();
            r5 = 0x7824;
            r3 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
            r2 = r3 + r5;
            r3 = 0x1;
            r0 = 0x1;
            MEMORY.ref(4, r2).setu(r3);
            sleep(r0);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r0 = r0 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x54).setu(r0);
          } while(r0 != r1);
        }

        //LAB_80e657c
        r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
        if(r2 == 0x15) {
          r1 = 0x80;
          r1 = r1 << 7;
          r0 = 0x6004000;
          MEMORY.memfill(r0, r1, 0);
          r1 = 0x80;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x58).get();
          r1 = r1 << 7;
          MEMORY.memfill(r0, r1, 0);
          r0 = 0x7828;
          r5 = MEMORY.ref(4, CPU.sp().value + 0x5c).get();
          r3 = r5 + r0;
          r2 = MEMORY.ref(4, r3).get();
          r3 = 0x0;
          MEMORY.ref(4, r2 + 0x1c).setu(r3);
          clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
          clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
          freeSlot(47);
          freeSlot(46);
          FUN_80d9ac4(MEMORY.ref(4, CPU.sp().value + 0x64).get());
        } else {
          //LAB_80e65c4
          r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x60).get();
          if((r1 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r2 == 0xc || r2 == 0x16 || r2 == 0x1c || r2 == 0x1d) {
            //LAB_80e65dc
            clearTickCallback(getRunnable(GoldenSun_80d.class, "FUN_80dbb9c"));
          }

          //LAB_80e65e2
          clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
          freeSlot(47);
          freeSlot(46);
          FUN_80cdbc0();
        }
      }
    }

    //LAB_80e65f8
    CPU.sp().value += 0xb8;
  }

  @Method(0x80e6d3c)
  public static void FUN_80e6d3c(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    CPU.r10().value = r2;
    r2 = MEMORY.ref(4, r3).get();
    r3 = 0x80edab8;
    r4 = MEMORY.ref(4, r3 + 0x4).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x20;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
    r3 = 0x80edac0;
    r4 = MEMORY.ref(4, r3 + 0x4).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r9().value = r1;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
    r1 = CPU.sp().value + 0x10;
    r3 = 0x0;
    MEMORY.ref(4, r1 + 0xc).setu(r3);
    r3 = 0xff;
    r3 = r3 << 16;
    MEMORY.ref(4, r1 + 0x4).setu(r3);
    if(r0 == 0) {
      //LAB_80e6d88
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r7 = r1;
      r6 = r2 + r3;

      //LAB_80e6d94
      do {
        r0 = r5;
        r1 = 0x3;
        r0 = modS(r0, r1);
        r0 = r0 << 21;
        r0 = r0 + CPU.r9().value;
        MEMORY.ref(4, r7).setu(r0);
        r0 = divideS(r5, 3);
        r0 = r0 << 21;
        r0 = r0 + CPU.r10().value;
        MEMORY.ref(4, r7 + 0x8).setu(r0);
        drawSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new), r7, CPU.r8().value, 0);
        r6 += 0x4;
        r5++;
      } while(r5 < 9);
    } else if(r0 == 0x1) {
      //LAB_80e6dc4
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6dd0
      do {
        r3 = 0x80eee1e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        r3 = r3 - 0x100000;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee2a;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        r3 = r3 - 0x200000;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 12);
    } else if(r0 == 0x2) {
      //LAB_80e6e00
      r3 = CPU.sp().value + 0x8;
      CPU.r8().value = r3;
      r3 = 0x77d8;
      r5 = 0x0;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6e0c
      do {
        r3 = 0x80eee36;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        r3 = r3 + 0x100000;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee3e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 8);
    } else if(r0 == 0x3) {
      //LAB_80e6e3a
      r3 = 0x77d8;
      r5 = 0x0;
      CPU.r8().value = CPU.sp().value;
      r6 = r1;
      r7 = r2 + r3;

      //LAB_80e6e44
      do {
        r3 = 0x80eee46;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r9().value;
        MEMORY.ref(4, r6).setu(r3);
        r3 = 0x80eee4e;
        r3 = MEMORY.ref(1, r3 + r5).getUnsigned();
        r3 = r3 << 16;
        r3 = r3 + CPU.r10().value;
        MEMORY.ref(4, r6 + 0x8).setu(r3);
        drawSprite_(MEMORY.ref(4, r7).deref(4).cast(Sprite38::new), r6, CPU.r8().value, 0);
        r7 += 0x4;
        r5++;
      } while(r5 < 8);
    }

    //LAB_80e6e6a
    CPU.sp().value += 0x20;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x80ed408)
  public static int FUN_80ed408(final int mallocSlot, final int op1, final int op2, final int branch1, final int branch2) {
    int size = 0x3;

    if(branch2 == 0x3) {
      size += 0x3;
    }

    //LAB_80ed42c
    if((branch1 & 0xc) == 0x4) {
      size += 0x3;
    }

    //LAB_80ed438
    if((branch1 & 0xc) == 0x8) {
      size += 0x4;
    }

    //LAB_80ed43e
    if((branch1 & 0xc) == 0xc) {
      size += 0x3;
    }

    //LAB_80ed444
    if((branch1 & 0xc) == 0) {
      size++;
    }

    //LAB_80ed44a
    if((branch1 & 0x2) != 0) {
      size += 0x7;
    }

    //LAB_80ed456
    size += 0x2;

    if((branch1 & 0x1) == 0) {
      size++;
    }

    //LAB_80ed464
    if((branch1 & 0x1) != 0) {
      size += 0x2;
      size += 0x2;
      size += 0x5;
    }

    //LAB_80ed46e
    size += 0x9;

    if((branch1 & 0x1) == 0) {
      size++;
    }

    //LAB_80ed47c
    size += 0x9;

    if((branch1 & 0x1) == 0) {
      size++;
    }

    //LAB_80ed484
    size += 0x3;

    if(branch2 == 0x1) {
      //LAB_80ed49c
      size += 0x4;
    } else if(branch2 == 0x2) {
      //LAB_80ed49c
      size += 0x4;
    } else if(branch2 == 0x3) {
      //LAB_80ed4a0
      size += 0x6;
    } else {
      //LAB_80ed498
      size += 0x2;
    }

    //LAB_80ed4a2
    size += 0x3;

    if((branch1 & 0x1) == 0) {
      size += 0x2;
    }

    //LAB_80ed4b0
    size += 0x2;

    if(branch2 == 0x1) {
      //LAB_80ed4d0
      size += 0x19;
    } else if(branch2 == 0x2) {
      //LAB_80ed4d4
      size += 0x20;
    } else if(branch2 == 0x3) {
      //LAB_80ed4d8
      size += 0x1c;
    } else {
      //LAB_80ed4c4
      //LAB_80ed4c6
      size += 0x10;
    }

    //LAB_80ed4da
    size++;

    if((branch1 & 0x1) == 0) {
      size += 0x2;
    }

    //LAB_80ed4e8
    size += 0x5;
    if(branch2 == 0x1) {
      //LAB_80ed500
      size += 0x4;
    } else if(branch2 == 0x2) {
      //LAB_80ed500
      size += 0x4;
    } else if(branch2 == 0x3) {
      //LAB_80ed504
      size += 0x6;
    } else {
      //LAB_80ed4fc
      size += 0x2;
    }

    //LAB_80ed506
    final int addr = mallocSlotChip(mallocSlot, (size + 0x8) * 0x4);
    int dst = addr;

    //         080edcc4 e0 4f 2d e9     stmdb      sp!,{r5,r6,r7,r8,r9,r10,r11,lr}
    //         080edcc8 20 40 8d e2     add        r4,sp,#0x20
    //         080edccc 30 00 94 e8     ldmia      r4,{r4,r5}
    DMA.channels[3].SAD.setu(0x80edcc4);
    DMA.channels[3].DAD.setu(dst);
    DMA.channels[3].CNT.setu(0x84000003);
    dst += 0xc;

    if(branch2 == 0x3) {
      //         080edcb8 40 a0 a0 e3     mov        r10,#0x40
      //         080edcbc 0a a4 8a e1     orr        r10,r10,r10, lsl #0x8
      //         080edcc0 0a a8 8a e1     orr        r10,r10,r10, lsl #0x10
      DMA.channels[3].SAD.setu(0x80edcb8);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000003);
      dst += 0xc;
    }

    //LAB_80ed534
    if((branch1 & 0xc) == 0x4) {
      //         080edcd0 04 60 81 e0     add        r6,r1,r4
      //         080edcd4 01 10 46 e2     sub        r1,r6,#0x1
      //         080edcd8 84 60 a0 e1     mov        r6,r4, lsl #0x1
      DMA.channels[3].SAD.setu(0x80edcd0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000003);
      dst += 0xc;
    }

    //LAB_80ed54c
    if((branch1 & 0xc) == 0x8) {
      //         080edcdc 01 60 45 e2     sub        r6,r5,#0x1
      //         080edce0 96 14 21 e0     mla        r1,r6,r4,r1
      //         080edce4 00 60 64 e2     rsb        r6,r4,#0x0
      //         080edce8 86 60 a0 e1     mov        r6,r6, lsl #0x1
      DMA.channels[3].SAD.setu(0x80edcdc);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000004);
      dst += 0x10;
    }

    //LAB_80ed560
    if((branch1 & 0xc) == 0xc) {
      //         080edcec 94 15 21 e0     mla        r1,r4,r5,r1
      //         080edcf0 01 10 41 e2     sub        r1,r1,#0x1
      //         080edcf4 00 60 a0 e3     mov        r6,#0x0
      DMA.channels[3].SAD.setu(0x80edcec);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000003);
      dst += 0xc;
    }

    //LAB_80ed574
    if((branch1 & 0xc) == 0) {
      //         080edcf8 00 60 a0 e3     mov        r6,#0x0
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edcf8).get());
      dst += 0x4;
    }

    //LAB_80ed57e
    if((branch1 & 0x2) != 0) {
      //         080edcfc 00 c0 73 e2     rsbs       r12,r3,#0x0
      //         080edd00 03 50 85 50     addpl      r5,r5,r3
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edcfc).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd00).get());
      dst += 0x4;

      final int r3_0;
      if((branch1 & 0x8) != 0) {
        //         080edd04 93 14 21 50     mlapl      r1,r3,r4,r1
        r3_0 = MEMORY.ref(4, 0x80edd04).get();
      } else {
        //LAB_80ed59e
        //         080edd08 9c 14 21 50     mlapl      r1,r12,r4,r1
        r3_0 = MEMORY.ref(4, 0x80edd08).get();
      }

      //LAB_80ed5a0
      MEMORY.ref(4, dst).setu(r3_0);
      dst += 0x4;
      //         080edd0c 00 30 a0 53     movpl      r3,#0x0
      //         080edd10 05 c0 83 e0     add        r12,r3,r5
      //         080edd14 00 00 5c e3     cmp        r12,#0x0
      //         080edd18 00 50 63 c2     rsbgt      r5,r3,#0x0
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd0c).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd10).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd14).get() + (0x1 << op2)); // operand
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd18).get() + (0x1 << op2)); // operand
      dst += 0x4;
    }

    //LAB_80ed5bc
    //         080edd1c 00 00 55 e3     cmp        r5,#0x0
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd1c).get());
    dst += 0x4;

    final int checkpoint0 = dst;
    //         080edd20 00 00 00 da     ble        LAB_080edd28
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd20).get());
    dst += 0x4;

    if((branch1 & 0x1) == 0) {
      //         080edd24 00 20 02 e2     and        r2,r2,#0x0
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd24).get() + (0x1 << op1) - 1); // operand
      dst += 0x4;
    }

    //LAB_80ed5de
    if((branch1 & 0x1) != 0) {
      //         080edd28 00 c0 72 e2     rsbs       r12,r2,#0x0
      //         080edd2c 02 40 84 50     addpl      r4,r4,r2
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd28).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd2c).get());
      dst += 0x4;

      if((branch1 & 0x4) != 0) {
        //         080edd30 02 60 86 50     addpl      r6,r6,r2
        //         080edd34 02 10 81 50     addpl      r1,r1,r2
        MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd30).get());
        dst += 0x4;
        MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd34).get());
      } else {
        //LAB_80ed5fe
        //         080edd38 02 60 46 50     subpl      r6,r6,r2
        //         080edd3c 02 10 41 50     subpl      r1,r1,r2
        MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd38).get());
        dst += 0x4;
        MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd3c).get());
      }

      //LAB_80ed604
      dst += 0x4;

      //         080edd40 00 20 a0 53     movpl      r2,#0x0
      //         080edd44 04 c0 82 e0     add        r12,r2,r4
      //         080edd48 00 c0 5c e2     subs       r12,r12,#0x0
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd40).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd44).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd48).get() + subOperands_80ef034.get(op1).get());
      dst += 0x4;

      final int r3_0;
      if((branch1 & 0x4) != 0) {
        //         080edd4c 0c 60 46 c0     subgt      r6,r6,r12
        r3_0 = MEMORY.ref(4, 0x80edd4c).get();
      } else {
        //LAB_80ed62a
        //         080edd50 0c 60 86 c0     addgt      r6,r6,r12
        r3_0 = MEMORY.ref(4, 0x80edd50).get();
      }

      //LAB_80ed62c
      MEMORY.ref(4, dst).setu(r3_0);
      dst += 0x4;
      //         080edd54 00 40 62 c2     rsbgt      r4,r2,#0x0
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd54).get() + subOperands_80ef034.get(op1).get());
      dst += 0x4;
    }

    //LAB_80ed638
    //         080edd58 00 00 54 e3     cmp        r4,#0x0
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd58).get());
    dst += 0x4;

    final int checkpoint1 = dst;
    //         080edd5c 00 00 00 da     ble        LAB_080edd64
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd5c).get());
    dst += 0x4;

    //         080edd60 07 70 12 e2     ands       r7,r2,#0x7
    //         080edd64 03 00 00 0a     beq        LAB_080edd78
    //         080edd68 08 70 67 e2     rsb        r7,r7,#0x8
    //         080edd6c 07 40 54 e0     subs       r4,r4,r7
    //         080edd70 07 70 84 b0     addlt      r7,r4,r7
    //         080edd74 00 40 a0 b3     movlt      r4,#0x0
    DMA.channels[3].SAD.setu(0x80edd60);
    DMA.channels[3].DAD.setu(dst);
    DMA.channels[3].CNT.setu(0x84000006);
    dst += 0x18;

    //         080edd78 a2 c1 a0 e1     mov        r12,r2, lsr #0x3
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd78).get());
    dst += 0x4;

    if((branch1 & 0x1) == 0) {
      //         080edd7c 10 b0 6c e2     rsb        r11,r12,#0x10
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd7c).get());
      dst += 0x4;
    }

    //LAB_80ed666
    //         080edd80 07 20 02 e2     and        r2,r2,#0x7
    //         080edd84 0c 23 82 e0     add        r2,r2,r12, lsl #0x6
    //         080edd88 02 00 80 e0     add        r0,r0,r2
    //         080edd8c 83 31 a0 e1     mov        r3,r3, lsl #0x3
    //         080edd90 85 21 83 e0     add        r2,r3,r5, lsl #0x3
    DMA.channels[3].SAD.setu(0x80edd80);
    DMA.channels[3].DAD.setu(dst);
    DMA.channels[3].CNT.setu(0x84000005);
    dst += 0x14;

    final int checkpoint2 = dst;
    //         080edd94 38 c0 03 e2     and        r12,r3,#0x38
    //         080edd98 00 ed 03 e2     and        lr,r3,#0x0
    //         080edd9c 0e c0 8c e1     orr        r12,r12,lr
    //         080edda0 0c 90 80 e0     add        r9,r0,r12
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd94).get());
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd98).get() + (0x1 << op2 - 3) - 1); // operand
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edd9c).get() + (op1 - 3 << 7)); // shift amount
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edda0).get());
    dst += 0x4;

    if((branch1 & 0x1) == 0) {
      //         080edda4 0b e0 a0 e1     mov        lr,r11
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edda4).get());
      dst += 0x4;
    }

    //LAB_80ed6a8
    //         080edda8 00 00 57 e3     cmp        r7,#0x0
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edda8).get());
    dst += 0x4;

    final int checkpoint3 = dst;
    //         080eddac 00 00 00 0a     beq        LAB_080eddb4
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddac).get());
    dst += 0x4;

    final int r3_0;
    if((branch1 & 0x4) != 0) {
      //         080eddb0 07 c0 41 e0     sub        r12,r1,r7
      r3_0 = MEMORY.ref(4, 0x80eddb0).get();
    } else {
      //LAB_80ed6c2
      //         080eddb4 07 c0 81 e0     add        r12,r1,r7
      r3_0 = MEMORY.ref(4, 0x80eddb4).get();
    }

    //LAB_80ed6c4
    MEMORY.ref(4, dst).setu(r3_0);
    dst += 0x4;

    final int checkpoint4 = dst;
    if(branch2 == 0x1) {
      //LAB_80ed6fc
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edb10 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edb14 00 00 55 e3     cmp        r5,#0x0
        //         080edb18 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb1c 01 90 89 e2     add        r9,r9,#0x1
        r0 = 0x80edb10;
      } else {
        //LAB_80ed70c
        //         080edb00 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb04 00 00 55 e3     cmp        r5,#0x0
        //         080edb08 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb0c 01 90 89 e2     add        r9,r9,#0x1
        r0 = 0x80edb00;
      }

      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000004);
      dst += 0x10;
    } else if(branch2 == 0x2) {
      //LAB_80ed712
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edbf8 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edbfc 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edc00 08 00 55 e1     cmp        r5,r8
        //         080edc04 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r0 = 0x80edbf8;
      } else {
        //LAB_80ed722
        //         080edbe8 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffff9
        //         080edbec 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edbf0 08 00 55 e1     cmp        r5,r8
        //         080edbf4 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r0 = 0x80edbe8;
      }

      //LAB_80ed726
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000004);
      dst += 0x10;
    } else if(branch2 == 0x3) {
      //LAB_80ed732
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edca0 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edca4 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edca8 08 50 85 e0     add        r5,r5,r8
        //         080edcac 3f 00 55 e3     cmp        r5,#0x3f
        //         080edcb0 3f 50 a0 23     movcs      r5,#0x3f
        //         080edcb4 01 50 49 e5     strb       r5,[r9,#-0x1]
        r0 = 0x80edca0;
      } else {
        //LAB_80ed742
        //         080edc88 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffff9
        //         080edc8c 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edc90 08 50 85 e0     add        r5,r5,r8
        //         080edc94 3f 00 55 e3     cmp        r5,#0x3f
        //         080edc98 3f 50 a0 23     movcs      r5,#0x3f
        //         080edc9c 01 50 49 e5     strb       r5,[r9,#-0x1]
        r0 = 0x80edc88;
      }

      //LAB_80ed746
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000006);
      dst += 0x18;
    } else {
      //LAB_80ed6dc
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edaf0 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edaf4 01 50 c9 e4     strb       r5,[r9],#0x1
        r0 = 0x80edaf0;
      } else {
        //LAB_80ed6ec
        //         080edaf8 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edafc 01 50 c9 e4     strb       r5,[r9],#0x1
        r0 = 0x80edaf8;
      }

      //LAB_80ed6f0
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000002);
      dst += 0x8;
    }

    //LAB_80ed750
    //         080eddc8 0c 00 51 e1     cmp        r1,r12
    //         080eddcc 00 00 00 1a     bne        LAB_080eddd4
    //         080eddd0 38 90 89 e2     add        r9,r9,#0x38
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddc8).get());
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddcc).get() + (checkpoint4 - dst - 8 >>> 2 & 0xffffff));
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddd0).get());
    dst += 0x4;

    if((branch1 & 0x1) == 0) {
      //         080eddd4 01 e0 5e e2     subs       lr,lr,#0x1
      //         080eddd8 01 9b 49 02     subeq      r9,r9,#0x400
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddd4).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddd8).get());
      dst += 0x4;
    }

    //LAB_80ed77c
    MEMORY.ref(4, checkpoint3).or(dst - checkpoint3 - 8 >>> 2 & 0xffffff);

    //         080edddc a4 c1 b0 e1     movs       r12,r4, lsr #0x3
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edddc).get());
    dst += 0x4;

    final int checkpoint5 = dst;
    //         080edde0 00 00 00 0a     beq        LAB_080edde8
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80edde0).get());
    dst += 0x4;
    final int checkpoint6 = dst;

    if(branch2 == 0x1) {
      //LAB_80ed7de
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edb84 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edb88 00 00 55 e3     cmp        r5,#0x0
        //         080edb8c 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb90 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edb94 00 00 55 e3     cmp        r5,#0x0
        //         080edb98 01 50 c9 15     strbne     r5,[r9,#0x1]
        //         080edb9c 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edba0 00 00 55 e3     cmp        r5,#0x0
        //         080edba4 02 50 c9 15     strbne     r5,[r9,#0x2]
        //         080edba8 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edbac 00 00 55 e3     cmp        r5,#0x0
        //         080edbb0 03 50 c9 15     strbne     r5,[r9,#0x3]
        //         080edbb4 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edbb8 00 00 55 e3     cmp        r5,#0x0
        //         080edbbc 04 50 c9 15     strbne     r5,[r9,#0x4]
        //         080edbc0 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edbc4 00 00 55 e3     cmp        r5,#0x0
        //         080edbc8 05 50 c9 15     strbne     r5,[r9,#0x5]
        //         080edbcc 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffb
        //         080edbd0 00 00 55 e3     cmp        r5,#0x0
        //         080edbd4 06 50 c9 15     strbne     r5,[r9,#0x6]
        //         080edbd8 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edbdc 00 00 55 e3     cmp        r5,#0x0
        //         080edbe0 07 50 c9 15     strbne     r5,[r9,#0x7]
        //         080edbe4 08 90 89 e2     add        r9,r9,#0x8
        r0 = 0x80edb84;
      } else {
        //LAB_80ed7ee
        //         080edb20 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb24 00 00 55 e3     cmp        r5,#0x0
        //         080edb28 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb2c 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb30 00 00 55 e3     cmp        r5,#0x0
        //         080edb34 01 50 c9 15     strbne     r5,[r9,#0x1]
        //         080edb38 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb3c 00 00 55 e3     cmp        r5,#0x0
        //         080edb40 02 50 c9 15     strbne     r5,[r9,#0x2]
        //         080edb44 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb48 00 00 55 e3     cmp        r5,#0x0
        //         080edb4c 03 50 c9 15     strbne     r5,[r9,#0x3]
        //         080edb50 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb54 00 00 55 e3     cmp        r5,#0x0
        //         080edb58 04 50 c9 15     strbne     r5,[r9,#0x4]
        //         080edb5c 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb60 00 00 55 e3     cmp        r5,#0x0
        //         080edb64 05 50 c9 15     strbne     r5,[r9,#0x5]
        //         080edb68 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb6c 00 00 55 e3     cmp        r5,#0x0
        //         080edb70 06 50 c9 15     strbne     r5,[r9,#0x6]
        //         080edb74 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb78 00 00 55 e3     cmp        r5,#0x0
        //         080edb7c 07 50 c9 15     strbne     r5,[r9,#0x7]
        //         080edb80 08 90 89 e2     add        r9,r9,#0x8
        r0 = 0x80edb20;
      }

      //LAB_80ed7f2
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000019);
      dst += 0x64;
    } else if(branch2 == 0x2) {
      //LAB_80ed7fe
      final int r4_0;
      if((branch1 & 0x4) != 0) {
        //         080edc48 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edc4c 04 80 99 e4     ldr        r8,[r9],#0x4
        //         080edc50 ff a0 08 e2     and        r10,r8,#0xff
        //         080edc54 0a 00 55 e1     cmp        r5,r10
        //         080edc58 04 50 49 c5     strbgt     r5,[r9,#-0x4]
        //         080edc5c 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edc60 ff ac 08 e2     and        r10,r8,#0xff00
        //         080edc64 2a 04 55 e1     cmp        r5,r10, lsr #0x8
        //         080edc68 03 50 49 c5     strbgt     r5,[r9,#-0x3]
        //         080edc6c 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffb
        //         080edc70 ff a8 08 e2     and        r10,r8,#0xff0000
        //         080edc74 2a 08 55 e1     cmp        r5,r10, lsr #0x10
        //         080edc78 02 50 49 c5     strbgt     r5,[r9,#-0x2]
        //         080edc7c 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edc80 28 0c 55 e1     cmp        r5,r8, lsr #0x18
        //         080edc84 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r4_0 = 0x80edc48;
      } else {
        //LAB_80ed80c
        //         080edc08 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffff9
        //         080edc0c 04 80 99 e4     ldr        r8,[r9],#0x4
        //         080edc10 ff a0 08 e2     and        r10,r8,#0xff
        //         080edc14 0a 00 55 e1     cmp        r5,r10
        //         080edc18 04 50 49 c5     strbgt     r5,[r9,#-0x4]
        //         080edc1c 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffffa
        //         080edc20 ff ac 08 e2     and        r10,r8,#0xff00
        //         080edc24 2a 04 55 e1     cmp        r5,r10, lsr #0x8
        //         080edc28 03 50 49 c5     strbgt     r5,[r9,#-0x3]
        //         080edc2c 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffffb
        //         080edc30 ff a8 08 e2     and        r10,r8,#0xff0000
        //         080edc34 2a 08 55 e1     cmp        r5,r10, lsr #0x10
        //         080edc38 02 50 49 c5     strbgt     r5,[r9,#-0x2]
        //         080edc3c 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edc40 28 0c 55 e1     cmp        r5,r8, lsr #0x18
        //         080edc44 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r4_0 = 0x80edc08;
      }

      //LAB_80ed80e
      DMA.channels[3].SAD.setu(r4_0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000010);
      dst += 0x40;

      // Same thing copied again
      DMA.channels[3].SAD.setu(r4_0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000010);
      dst += 0x40;
    } else if(branch2 == 0x3) {
      //LAB_80ed88c
      final int r4_0;
      if((branch1 & 0x4) != 0) {
        //         080eefdc 00 80 99 e5     ldr        r8,[r9,#0x0]
        //         080eefe0 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080eefe4 05 80 88 e0     add        r8,r8,r5
        //         080eefe8 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080eefec 05 84 88 e0     add        r8,r8,r5, lsl #0x8
        //         080eeff0 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080eeff4 05 88 88 e0     add        r8,r8,r5, lsl #0x10
        //         080eeff8 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080eeffc 05 8c 88 e0     add        r8,r8,r5, lsl #0x18
        //         080ef000 0a 50 08 e0     and        r5,r8,r10
        //         080ef004 0a 80 c8 e1     bic        r8,r8,r10
        //         080ef008 25 53 45 e0     sub        r5,r5,r5, lsr #0x6
        //         080ef00c 05 80 88 e1     orr        r8,r8,r5
        //         080ef010 04 80 89 e4     str        r8,[r9],#0x4
        r4_0 = 0x80eefdc;
      } else {
        //LAB_80ed89a
        //         080eefa4 00 80 99 e5     ldr        r8,[r9,#0x0]
        //         080eefa8 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080eefac 05 80 88 e0     add        r8,r8,r5
        //         080eefb0 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080eefb4 05 84 88 e0     add        r8,r8,r5, lsl #0x8
        //         080eefb8 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080eefbc 05 88 88 e0     add        r8,r8,r5, lsl #0x10
        //         080eefc0 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080eefc4 05 8c 88 e0     add        r8,r8,r5, lsl #0x18
        //         080eefc8 0a 50 08 e0     and        r5,r8,r10
        //         080eefcc 0a 80 c8 e1     bic        r8,r8,r10
        //         080eefd0 25 53 45 e0     sub        r5,r5,r5, lsr #0x6
        //         080eefd4 05 80 88 e1     orr        r8,r8,r5
        //         080eefd8 04 80 89 e4     str        r8,[r9],#0x4
        r4_0 = 0x80eefa4;
      }

      //LAB_80ed89c
      DMA.channels[3].SAD.setu(r4_0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x8400000e);
      dst += 0x38;

      // Copy the same thing again
      DMA.channels[3].SAD.setu(r4_0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x8400000e);
      dst += 0x38;
    } else {
      //LAB_80ed7ae
      //LAB_80ed7be
      for(int r4_0 = 0; r4_0 < 8; r4_0++) {
        final int r0;
        if((branch1 & 0x4) != 0) {
          //         080edaf0 01 50 51 e4     ldrb       r5,[r1],#-0x1
          //         080edaf4 01 50 c9 e4     strb       r5,[r9],#0x1
          r0 = 0x80edaf0;
        } else {
          //LAB_80ed7c8
          //         080edaf8 01 50 d1 e4     ldrb       r5,[r1],#0x1
          //         080edafc 01 50 c9 e4     strb       r5,[r9],#0x1
          r0 = 0x80edaf8;
        }

        //LAB_80ed7cc
        DMA.channels[3].SAD.setu(r0);
        DMA.channels[3].DAD.setu(dst);
        DMA.channels[3].CNT.setu(0x84000002);
        dst += 0x8;
      }
    }

    //LAB_80ed8b6
    //         080eddf4 38 90 89 e2     add        r9,r9,#0x38
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddf4).get());
    dst += 0x4;

    if((branch1 & 0x1) == 0) {
      //         080eddf8 01 e0 5e e2     subs       lr,lr,#0x1
      //         080eddfc 01 9b 49 02     subeq      r9,r9,#0x400
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddf8).get());
      dst += 0x4;
      MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80eddfc).get());
      dst += 0x4;
    }

    //LAB_80ed8ce
    //         080ede00 01 c0 5c e2     subs       r12,r12,#0x1
    //         080ede04 00 00 00 1a     bne        LAB_080ede0c
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede00).get());
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede04).get() + (checkpoint6 - dst - 8 >>> 2 & 0xffffff));
    dst += 0x4;

    MEMORY.ref(4, checkpoint5).or(dst - checkpoint5 - 8 >>> 2 & 0xffffff);

    //         080ede08 07 c0 14 e2     ands       r12,r4,#0x7
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede08).get());
    dst += 0x4;

    final int checkpoint7 = dst;
    //         080ede0c 00 00 00 0a     beq        LAB_080ede14
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede0c).get());
    dst += 0x4;

    final int r3_1;
    if((branch1 & 0x4) != 0) {
      //         080ede10 0c c0 41 e0     sub        r12,r1,r12
      r3_1 = MEMORY.ref(4, 0x80ede10).get();
    } else {
      //LAB_80ed910
      //         080ede14 0c c0 81 e0     add        r12,r1,r12
      r3_1 = MEMORY.ref(4, 0x80ede14).get();
    }

    //LAB_80ed912
    MEMORY.ref(4, dst).setu(r3_1);
    dst += 0x4;
    final int checkpoint8 = dst;

    if(branch2 == 0x1) {
      //LAB_80ed94a
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edb10 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edb14 00 00 55 e3     cmp        r5,#0x0
        //         080edb18 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb1c 01 90 89 e2     add        r9,r9,#0x1
        r0 = 0x80edb10;
      } else {
        //LAB_80ed95a
        //         080edb00 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edb04 00 00 55 e3     cmp        r5,#0x0
        //         080edb08 00 50 c9 15     strbne     r5,[r9,#0x0]
        //         080edb0c 01 90 89 e2     add        r9,r9,#0x1
        r0 = 0x80edb00;
      }

      //LAB_80ed974
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000004);
      dst += 0x10;
    } else if((branch2 & 0xffff_ffffL) < 1) {
      //LAB_80ed92a
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edaf0 01 50 51 e4     ldrb       r5,[r1],#-0x1
        //         080edaf4 01 50 c9 e4     strb       r5,[r9],#0x1
        r0 = 0x80edaf0;
      } else {
        //LAB_80ed93a
        //         080edaf8 01 50 d1 e4     ldrb       r5,[r1],#0x1
        //         080edafc 01 50 c9 e4     strb       r5,[r9],#0x1
        r0 = 0x80edaf8;
      }

      //LAB_80ed93e
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000002);
      dst += 0x8;
    } else if(branch2 == 0x2) {
      //LAB_80ed960
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edbf8 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edbfc 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edc00 08 00 55 e1     cmp        r5,r8
        //         080edc04 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r0 = 0x80edbf8;
      } else {
        //LAB_80ed970
        //         080edbe8 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffff9
        //         080edbec 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edbf0 08 00 55 e1     cmp        r5,r8
        //         080edbf4 01 50 49 c5     strbgt     r5,[r9,#-0x1]
        r0 = 0x80edbe8;
      }

      //LAB_80ed974
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000004);
      dst += 0x10;
    } else if(branch2 == 0x3) {
      //LAB_80ed980
      final int r0;
      if((branch1 & 0x4) != 0) {
        //         080edca0 01 50 51 e4     ldrb       r5,[r1],#-0x1=>DAT_fffffffa
        //         080edca4 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edca8 08 50 85 e0     add        r5,r5,r8
        //         080edcac 3f 00 55 e3     cmp        r5,#0x3f
        //         080edcb0 3f 50 a0 23     movcs      r5,#0x3f
        //         080edcb4 01 50 49 e5     strb       r5,[r9,#-0x1]
        r0 = 0x80edca0;
      } else {
        //LAB_80ed990
        //         080edc88 01 50 d1 e4     ldrb       r5,[r1],#0x1=>DAT_fffffff9
        //         080edc8c 01 80 d9 e4     ldrb       r8,[r9],#0x1
        //         080edc90 08 50 85 e0     add        r5,r5,r8
        //         080edc94 3f 00 55 e3     cmp        r5,#0x3f
        //         080edc98 3f 50 a0 23     movcs      r5,#0x3f
        //         080edc9c 01 50 49 e5     strb       r5,[r9,#-0x1]
        r0 = 0x80edc88;
      }

      //LAB_80ed994
      DMA.channels[3].SAD.setu(r0);
      DMA.channels[3].DAD.setu(dst);
      DMA.channels[3].CNT.setu(0x84000006);
      dst += 0x18;
    }

    //LAB_80ed99e
    //         080ede28 0c 00 51 e1     cmp        r1,r12
    //         080ede2c 00 00 00 1a     bne        LAB_080ede34
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede28).get());
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede2c).get() + (checkpoint8 - dst - 8 >>> 2 & 0xffffff));
    dst += 0x4;

    MEMORY.ref(4, checkpoint7).or(dst - checkpoint7 - 8 >>> 2 & 0xffffff);

    //         080ede30 06 10 81 e0     add        r1,r1,r6
    //         080ede34 08 30 83 e2     add        r3,r3,#0x8
    //         080ede38 02 00 53 e1     cmp        r3,r2
    DMA.channels[3].SAD.setu(0x80ede30);
    DMA.channels[3].DAD.setu(dst);
    DMA.channels[3].CNT.setu(0x84000003);
    dst += 0xc;

    //         080ede3c 00 00 00 1a     bne        LAB_080ede44
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede3c).get() + (checkpoint2 - dst - 8 >>> 2 & 0xffffff));
    dst += 0x4;

    MEMORY.ref(4, checkpoint0).or(dst - checkpoint0 - 8 >>> 2 & 0xffffff);
    MEMORY.ref(4, checkpoint1).or(dst - checkpoint1 - 8);

    //         080ede40 e0 4f bd e8     ldmia      sp!,{r5,r6,r7,r8,r9,r10,r11,lr}
    //         080ede44 1e ff 2f e1     bx         lr
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede40).get());
    dst += 0x4;
    MEMORY.ref(4, dst).setu(MEMORY.ref(4, 0x80ede44).get());

    final AssembledFunction assembledFunction = new AssembledFunction(op1, op2, branch1, branch2);
    try {
      MEMORY.setFunction(addr, assembledFunction.getClass().getMethod("run", int.class, int.class, int.class, int.class, int.class, int.class), assembledFunction, false);
    } catch(final NoSuchMethodException e) {
      throw new RuntimeException(e);
    }

    return 1;
  }

  @Method(0x80e6eac)
  public static void FUN_80e6eac(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x24;
    r5 = 0x3001eec;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
    r3 = r5;
    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    CPU.r11().value = r1;
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.r11().value;
    r4 = 0xa0;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    r4 = r4 << 14;
    r3 = r2;
    r3 = r3 + r4;
    CPU.r11().value = r3;
    r3 = r3 >>> 31;
    r3 = r3 + CPU.r11().value;
    r3 = r3 >> 1;
    r1 = MEMORY.ref(4, r5 + 0x8).get();
    CPU.r11().value = r3;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    GPU.BG2PA.setu(0x80);
    GPU.BG2X.setu(0);
    CPU.r10().value = r0;
    GPU.BLDCNT.setu(0x3f46);
    FUN_80ed408(46, 7, 7, 3, 2);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(MEMORY.ref(4, r5 + 0x1c).get());
    FUN_80ed408(47, 7, 7, 3, 3);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(MEMORY.ref(4, r5 + 0x20).get());
    FUN_80e0524(115, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0, 0);
    FUN_80e0524(94, CPU.r10().value, 1, 0);
    FUN_80e0524(95, CPU.r10().value + 0x59d8, 0, 0);
    MEMORY.ref(4, CPU.r10().value + 0x7780).setu(2);
    MEMORY.ref(4, CPU.r10().value + 0x7784).setu(50);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    CPU.r8().value = 0;
    r7 = CPU.r10().value + 0x7080;

    //LAB_80e6f7c
    do {
      r0 = rand();
      r6 = 0xff;
      r2 = 0x80;
      r2 = r2 << 1;
      r6 = r6 & r0;
      r6 = r6 + r2;
      r0 = rand();
      r3 = 0xffff;
      r5 = r0;
      r5 = r5 & r3;
      r3 = CPU.r11().value;
      MEMORY.ref(4, r7).setu(r3);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = r5;
      MEMORY.ref(4, r7 + 0x4).setu(r4);
      r0 = sin(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 7;
      MEMORY.ref(4, r7 + 0xc).setu(r3);
      r0 = r5;
      r0 = cos(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 6;
      r3 = -r3;
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r0 = rand();
      r3 = 0xf;
      r3 = r3 & r0;
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r3 = r3 + 0x10;
      r1 = CPU.r8().value;
      MEMORY.ref(4, r7 + 0x18).setu(r3);
      r7 = r7 + 0x1c;
    } while(r1 != 0x40);

    r5 = 0x772c;
    r2 = 0x0;
    CPU.r8().value = r2;
    r6 = 0x0;
    r5 = r5 + CPU.r10().value;

    //LAB_80e6fdc
    do {
      r3 = CPU.r11().value;
      MEMORY.ref(4, r5).setu(r3);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = r6;
      MEMORY.ref(4, r5 + 0x4).setu(r4);
      r0 = sin(r0);
      r0 = r0 << 5;
      r0 = r0 >> 6;
      MEMORY.ref(4, r5 + 0xc).setu(r0);
      r0 = r6;
      r0 = cos(r0);
      r0 = r0 << 5;
      r0 = r0 >> 5;
      r0 = -r0;
      r1 = 0x1;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      CPU.r8().value = CPU.r8().value + r1;
      r0 = 0x5555;
      r2 = CPU.r8().value;
      r6 = r6 + r0;
      r5 = r5 + 0x1c;
    } while(r2 != 0x3);

    r3 = 0x0;
    r7 = 0x2010000;
    CPU.r8().value = r3;

    //LAB_80e7014
    do {
      r0 = rand();
      r6 = 0xff;
      r6 = r6 & r0;
      r0 = rand();
      r4 = CPU.r11().value;
      MEMORY.ref(4, r7).setu(r4);
      r3 = 0xffff;
      r5 = r0;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = r5 & r3;
      MEMORY.ref(4, r7 + 0x4).setu(r0);
      r0 = r5;
      r0 = sin(r0);
      r6 = r6 + 0x20;
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 6;
      MEMORY.ref(4, r7 + 0xc).setu(r3);
      r0 = r5;
      r0 = cos(r0);
      r3 = r6;
      r3 = r3 * r0;
      r3 = r3 >> 5;
      r3 = -r3;
      MEMORY.ref(4, r7 + 0x10).setu(r3);
      r0 = rand();
      r3 = 0xf;
      r1 = 0x1;
      r3 = r3 & r0;
      CPU.r8().value = CPU.r8().value + r1;
      r3 = r3 + 0x14;
      r2 = CPU.r8().value;
      MEMORY.ref(4, r7 + 0x18).setu(r3);
      r7 = r7 + 0x1c;
    } while(r2 != 0x40);

    r7 = 0x0;

    //LAB_80e7068
    do {
      if(r7 == 0x4) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80e7072
      if(r7 == 0x20) {
        r0 = 0xd4;
        playSound_(r0);
      }

      //LAB_80e707c
      if(r7 <= 0x2f) {
        r0 = r7;
        r0 = r0 - 0x8;
        r1 = 0x5;
        r0 = divideS(r0, r1);
        r4 = r0;
        if(r4 < 0) {
          r4 = 0x0;
        }

        //LAB_80e7092
        r2 = 0x80eee66;
        r3 = r4 << 1;
        r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
        r3 = CPU.r11().value;
        r2 = r3 >> 16;
        r3 = 0x80eee56;
        r5 = MEMORY.ref(1, r3 + r4).getUnsigned();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r3 = r5 >>> 1;
        r2 = r2 - r3;
        r3 = r0 >> 16;
        r0 = 0x80eee5e;
        r4 = MEMORY.ref(1, r0 + r4).getUnsigned();
        r0 = r4 >>> 1;
        r3 = r3 - r0;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
        r1 = r1 + CPU.r10().value;
        MEMORY.ref(4, CPU.sp().value).setu(r5);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
      }

      //LAB_80e70be
      r6 = 0xe1;
      r0 = 0x0;
      r6 = r6 << 7;
      CPU.r8().value = r0;
      r6 = r6 + CPU.r10().value;

      //LAB_80e70c8
      do {
        r1 = CPU.r8().value;
        r3 = r1 >>> 31;
        r3 = r3 + CPU.r8().value;
        r3 = r3 >> 1;
        if(r7 > r3) {
          r3 = MEMORY.ref(4, r6 + 0x18).get();
          if(r3 > 0) {
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r0 = r6;
            r1 = 0x3c;
            r2 = 0x0;
            FUN_80e3908(r0, r1, r2);
            r4 = MEMORY.ref(4, r6 + 0x18).get();
            if(r4 < 0) {
              r4 = r4 + 0xf;
            }

            //LAB_80e70f0
            r4 = r4 >> 4;
            r4 = r4 + 0x3;
            r3 = 0x2;
            r2 = MEMORY.ref(2, r6 + r3).get();
            r5 = r4 << 1;
            r0 = 0x6;
            r3 = MEMORY.ref(2, r6 + r0).get();
            r0 = 0x80ede48;
            r1 = r5 - 0x2;
            r1 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = r0 + r1;
            r0 = r4 >>> 31;
            r0 = r4 + r0;
            r0 = r0 >> 1;
            r2 = r2 - r0;
            r3 = r3 - r4;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }

        //LAB_80e711e
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r6 = r6 + 0x1c;
      } while(r1 != 0x1e);

      r3 = 0x80ede48;
      r2 = 0x0;
      r6 = 0x2010000;
      CPU.r8().value = r2;
      CPU.r9().value = r3;

      //LAB_80e7134
      do {
        if(r7 > 0x23) {
          r3 = MEMORY.ref(4, r6 + 0x18).get();
          if(r3 > 0) {
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r0 = r6;
            r1 = 0x3c;
            r2 = 0x0;
            FUN_80e3908(r0, r1, r2);
            r4 = MEMORY.ref(4, r6 + 0x18).get();
            if(r4 < 0) {
              r4 = r4 + 0xf;
            }

            //LAB_80e7154
            r4 = r4 >> 4;
            r4 = r4 + 0x1;
            r5 = r4 << 1;
            r0 = 0x2;
            r2 = MEMORY.ref(2, r6 + r0).get();
            r1 = 0x6;
            r3 = MEMORY.ref(2, r6 + r1).get();
            r0 = CPU.r9().value;
            r1 = r5 - 0x2;
            r1 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = r0 + r1;
            r0 = r4 >>> 31;
            r0 = r4 + r0;
            r0 = r0 >> 1;
            r2 = r2 - r0;
            r3 = r3 - r4;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }
        }

        //LAB_80e7182
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r6 = r6 + 0x1c;
      } while(r1 != 0x3c);

      r5 = 0x772c;
      r2 = 0x0;
      r6 = r7;
      CPU.r8().value = r2;
      r6 = r6 - 0x24;
      r5 = r5 + CPU.r10().value;

      //LAB_80e719a
      do {
        if((r6 & 0xffff_ffffL) <= (0x1b & 0xffff_ffffL)) {
          r2 = 0x0;
          r0 = r5;
          r1 = 0x40;
          FUN_80e3908(r0, r1, r2);
          r1 = 0x7;
          r0 = r6;
          r0 = divideS(r0, r1);
          r1 = r0 << 3;
          r1 = r1 + r0;
          r1 = r1 << 5;
          r0 = 0x59d8;
          r1 = r1 + CPU.r10().value;
          r3 = 0x2;
          r2 = MEMORY.ref(2, r5 + r3).get();
          r1 = r1 + r0;
          r4 = 0x6;
          r3 = MEMORY.ref(2, r5 + r4).get();
          r0 = 0xc;
          MEMORY.ref(4, CPU.sp().value).setu(r0);
          r0 = 0x18;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r2 = r2 - 0x6;
          r3 = r3 - 0xc;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
        }

        //LAB_80e71d8
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r5 = r5 + 0x1c;
      } while(r1 != 0x3);

      if(r7 <= 0x23) {
        r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        FUN_80e6d3c(r0, r1, r2);
      }

      //LAB_80e71f2
      MEMORY.ref(4, CPU.r10().value + 0x7824).setu(1);
      sleep(1);
      r7++;
    } while(r7 < 0x48);

    //LAB_80e7208
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    MEMORY.call(0x3000164, 0x6004000, 0x4000);
    freeSlot(47);
    freeSlot(46);
    CPU.sp().value += 0x24;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80e7320)
  public static void FUN_80e7320(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80e823c)
  public static void FUN_80e823c(int r0) {
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
    r3 = 0x3001ef0;
    r1 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x54;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    r2 = r3 - 0x4;
    r2 = MEMORY.ref(4, r2).get();
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r2);
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
    r3 = 0x7828;
    r5 = r2 + r3;
    MEMORY.ref(4, r5).setu(r0);
    r0 = 0x0;
    FUN_80cd594(r0);
    FUN_80c9048();
    r2 = 0x0;
    r3 = 0xa0;
    r3 = r3 << 19;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 + 0x2;
    MEMORY.ref(2, r3).setu(r2);
    r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = 0xef;
    r7 = r7 << 7;
    r2 = r6 + r7;
    r3 = 0x0;
    r1 = 0x90;
    MEMORY.ref(4, r2).setu(r3);
    r1 = r1 << 3;
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
    r1 = 0x0;
    r0 = 0x1;
    FUN_80cd104(r0, r1);
    r0 = MEMORY.ref(4, r5).get();
    FUN_80d6750(r0);
    r1 = 0x17b;
    r0 = 0x9;
    r2 = 0x2;
    FUN_80dbb24(r0, r1, r2);
    r1 = 0xd;
    r0 = 0x0;
    r1 = -r1;
    r6 = 0x77fc;
    CPU.r8().value = r0;
    r7 = r1;

    //LAB_80e82ca
    do {
      final Sprite38 sprite = loadSprite_(390);
      r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
      MEMORY.ref(4, r6 + r2).setu(sprite != null ? sprite.getAddress() : 0);
      if(sprite != null) {
        sprite._26.set(0);
        setSpriteAnimation_(sprite, modS(CPU.r8().value, 3));
        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = MEMORY.ref(4, r6 + r3).get();
        r3 = MEMORY.ref(1, r1 + 0x9).getUnsigned();
        r2 = 0x4;
        r3 = r3 & r7;
        r3 = r3 | r2;
        MEMORY.ref(1, r1 + 0x9).setu(r3);
      }

      //LAB_80e8302
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r1 = CPU.r8().value;
      r6 = r6 + 0x4;
    } while(r1 != 0x6);

    FUN_80ed408(46, 7, 7, 3, 2);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(boardWramMallocHead_3001e50.offset(46 * 0x4).get());
    FUN_80ed408(47, 7, 7, 3, 3);
    r2 = CPU.sp().value + 0x3c;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    MEMORY.ref(4, r2 + 0x4).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    MEMORY.ref(2, 0x4000048).setu(0x2737);
    MEMORY.ref(2, 0x4000040).setu(240);
    MEMORY.ref(2, 0x4000046).setu(0x1088);
    sleep(1);
    loadBattleBackground_(1, 60, 0);
    FUN_80cd104(1, 1);
    FUN_80e0524(115, MEMORY.ref(4, CPU.sp().value + 0x24).get(), 0, 0);
    FUN_80e0524(192, MEMORY.ref(4, CPU.sp().value + 0x2c).get(), 1, 1);
    GPU.DISPCNT.setu(0x7741);
    GPU.BG2PA.setu(0x80);
    GPU.BLDALPHA.setu(0x1010);
    GPU.BLDCNT.setu(0x3f44);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    MEMORY.ref(4, r7 + 0x7780).setu(2);
    MEMORY.ref(4, r7 + 0x7784).setu(50);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0xbc0000);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x5c0000);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x5c0000);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0xa00000);
    CPU.r8().value = 0;
    r6 = 0x0;
    r5 = r0 + 0x7080;

    //LAB_80e8410
    do {
      r0 = rand();
      r3 = 0x7f;
      r3 = r3 & r0;
      r3 = r3 << 16;
      MEMORY.ref(4, r5).setu(r3);
      r3 = 0x1;
      r2 = 0xfff00000;
      CPU.r8().value = CPU.r8().value + r3;
      r0 = CPU.r8().value;
      MEMORY.ref(4, r5 + 0x4).setu(r7);
      MEMORY.ref(4, r5 + 0xc).setu(r6);
      MEMORY.ref(4, r5 + 0x10).setu(r6);
      MEMORY.ref(4, r5 + 0x18).setu(r6);
      r7 = r7 + r2;
      r5 = r5 + 0x1c;
    } while(r0 != 0x6);

    r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r7 = 0x7140;
    r1 = 0x0;
    CPU.r8().value = r1;
    r2 = 0x18;
    r3 = r6 + r7;

    //LAB_80e8440
    do {
      r0 = 0x1;
      CPU.r8().value = CPU.r8().value + r0;
      r1 = CPU.r8().value;
      MEMORY.ref(4, r3).setu(r2);
      r3 = r3 + 0x1c;
    } while(r1 != 0x3a);

    r2 = 0x0;
    CPU.r8().value = r2;
    r1 = 0x1;
    r2 = 0x80;
    r3 = 0x2010018;
    r1 = -r1;
    r2 = r2 << 3;

    //LAB_80e845c
    do {
      r6 = 0x1;
      CPU.r8().value = CPU.r8().value + r6;
      MEMORY.ref(4, r3).setu(r1);
      r3 = r3 + 0x1c;
    } while(CPU.r8().value != r2);

    r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r0 = 0x77b4;
    r1 = 0x77b8;
    r2 = r7 + r0;
    r3 = 0x18;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0x0;
    r2 = r7 + r1;
    MEMORY.ref(4, r2).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
    r3 = 0x3001b04;
    r3 = MEMORY.ref(4, r3).get();
    r2 = 0x3;
    r3 = r3 & r2;
    if(r3 == 0) {
      //LAB_80e848a
      r2 = CPU.sp().value;
      r3 = CPU.sp().value;
      r2 = r2 + 0x44;
      r3 = r3 + 0x34;
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);

      //LAB_80e8496
      do {
        r6 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r6 == 0x5e) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84a2
        r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r7 == 0x88) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84ae
        r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r0 == 0xb2) {
          r0 = 0x9c;
          playSound_(r0);
        }

        //LAB_80e84ba
        r2 = 0x82;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r2 = r2 << 1;
        if(r1 == r2) {
          r0 = 0x91;
          playSound_(r0);
        }

        //LAB_80e84ca
        r3 = 0x80edac8;
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x38).setu(r4);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0x60;
        if((r3 & 0xffff_ffffL) <= (0x9b & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r6 = 0x77a8;
          r2 = r3 + r6;
          r3 = 0x1;
          MEMORY.ref(4, r2).setu(r3);
        } else {
          //LAB_80e84e4
          r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r0 = 0xfffffefc;
          r3 = r7 + r0;
          if((r3 & 0xffff_ffffL) <= (0x3 & 0xffff_ffffL)) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = 0x77a8;
            r2 = r1 + r3;
            r3 = 0x1;
            MEMORY.ref(4, r2).setu(r3);
          }
        }

        //LAB_80e84f8
        r3 = 0x0;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r1 = 0x77d8;
        MEMORY.ref(4, CPU.sp().value + 0x50).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r7 = 0xffe00000;
        CPU.r8().value = r3;
        r6 = r0 + r1;

        //LAB_80e850a
        do {
          r3 = 0x80eeed8;
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r3 = r3 << 16;
          r3 = r3 + r0;
          r3 = r3 + r7;
          MEMORY.ref(4, r5).setu(r3);
          r3 = 0x80eeee1;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
          r3 = r3 << 16;
          r3 = r3 + r1;
          r3 = r3 + r7;
          MEMORY.ref(4, r5 + 0x8).setu(r3);
          r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          drawSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new), r5, r2, 0);
          r6 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 7);

        r6 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r6 <= 0x5a) {
          r5 = r6 << 9;
          r0 = r5;
          r0 = sin(r0);
          r7 = 0x9c;
          r0 = r0 << 4;
          r7 = r7 << 16;
          r7 = r0 + r7;
          r0 = r5;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
          r0 = cos(r0);
          r1 = 0xb8;
          r0 = r0 << 4;
          r1 = r1 << 15;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
        }

        //LAB_80e8566
        r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r2 <= 0xc4) {
          r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x0;
          CPU.r8().value = r3;
          r6 = 0x5b;
          CPU.r10().value = r7;

          //LAB_80e8576
          do {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            if(r0 >= r6) {
              r3 = r6 + 0x4;
              if(r0 < r3) {
                r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r2 = 0x80;
                r2 = r2 << 12;
                r2 = r1 + r2;
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
              }
            }

            //LAB_80e858c
            r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r6 + 0x3;
            if(r7 == r3) {
              r5 = 0x7128;
              r0 = 0xff;
              r7 = 0x0;
              CPU.r9().value = r0;
              r5 = r5 + CPU.r10().value;

              //LAB_80e859e
              do {
                r3 = 0x80;
                r3 = r3 << 15;
                MEMORY.ref(4, r5).setu(r3);
                r3 = 0xc0;
                r3 = r3 << 15;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r1 = CPU.r9().value;
                r0 = r0 & r1;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r2 = CPU.r9().value;
                r0 = r0 & r2;
                r0 = r0 - 0x7f;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0x10).setu(r0);
                r0 = rand();
                r3 = 0xf;
                r3 = r3 & r0;
                r7 = r7 + 0x1;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
                r5 = r5 + 0x1c;
              } while(r7 != 0x4);
            }

            //LAB_80e85d8
            r3 = r6;
            r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r3 + 0x14;
            if(r7 >= r3) {
              r3 = r3 + 0x10;
              if(r7 < r3) {
                r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r1 = 0xfffe0000;
                r1 = r0 + r1;
                MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
              }
            }

            //LAB_80e85f0
            r3 = 0x1;
            CPU.r8().value = CPU.r8().value + r3;
            r2 = 0xe0;
            r7 = CPU.r8().value;
            r6 = r6 + 0x28;
            CPU.r10().value = CPU.r10().value + r2;
          } while(r7 != 0x3);
        }

        //LAB_80e8600
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0xf4;
        if((r3 & 0xffff_ffffL) <= (0x7 & 0xffff_ffffL)) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r1 = 0xffff0000;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
        }

        //LAB_80e8610
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r3 = r3 - 0xfc;
        if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r3 = r3 - 0xfa;
          r3 = r3 << 16;
          r3 = r2 - r3;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
        }

        //LAB_80e8624
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r6 = 0x103;
        if(r3 <= r6) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r3 = 0xff;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = r3 << 24;
          r2 = 0x77f4;
          MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
          r3 = r0 + r3;
          MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
          r3 = r1 + r2;
          r7 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(r7);
          drawSprite_(MEMORY.ref(4, r3).deref(4).cast(Sprite38::new), CPU.sp().value + 0x44, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
          MEMORY.ref(4, CPU.sp().value + 0x44).setu(MEMORY.ref(4, CPU.sp().value + 0x14).get() + 0x200000);
          r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get() + 0x77f8;
          drawSprite_(MEMORY.ref(4, r3).deref(4).cast(Sprite38::new), CPU.sp().value + 0x44, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
        }

        //LAB_80e866e
        r6 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = 0x0;
        MEMORY.ref(4, r6 + 0x4).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r0 = 0xe1;
        r0 = r0 << 7;
        CPU.r8().value = r3;
        CPU.r11().value = r6;
        r5 = r7 + r0;
        CPU.r9().value = r7;

        //LAB_80e8682
        do {
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          if(r3 != 0x2) {
            //LAB_80e868a
            r3 = MEMORY.ref(4, r5).get();
            r1 = CPU.r11().value;
            MEMORY.ref(4, r1).setu(r3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r2 = CPU.r8().value;
            MEMORY.ref(4, r1 + 0x8).setu(r3);
            r3 = r2 << 2;
            r7 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = r3 + 0x77fc;
            drawSprite_(MEMORY.ref(4, r7 + r3).deref(4).cast(Sprite38::new), r1, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0);
            r3 = MEMORY.ref(4, r5).get();
            r2 = MEMORY.ref(4, r5 + 0xc).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5).setu(r3);
            r2 = MEMORY.ref(4, r5 + 0x10).get();
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5 + 0x4).setu(r3);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            if(r0 > 0x60) {
              r1 = 0x80;
              r1 = r1 << 7;
              r3 = r2 + r1;
              MEMORY.ref(4, r5 + 0x10).setu(r3);
            }

            //LAB_80e86c6
            r2 = 0xf0;
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r2 = r2 << 15;
            if(r3 > r2) {
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r3 = r3 + 0x1;
              MEMORY.ref(4, r5 + 0x18).setu(r3);
              if(r3 == 0x1) {
                r3 = MEMORY.ref(4, r5 + 0x10).get();
                r3 = -r3;
                r2 = r3 >>> 31;
                r3 = r3 + r2;
                r3 = r3 >> 1;
                r6 = 0x73c8;
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r3 = 0xff;
                r7 = 0x0;
                CPU.r10().value = r3;
                r6 = r6 + CPU.r9().value;

                //LAB_80e86f0
                do {
                  r3 = MEMORY.ref(4, r5).get();
                  r2 = r3 >>> 31;
                  r3 = r3 + r2;
                  r3 = r3 >> 1;
                  MEMORY.ref(4, r6).setu(r3);
                  r0 = 0xffe00000;
                  r3 = MEMORY.ref(4, r5 + 0x4).get();
                  r3 = r3 + r0;
                  MEMORY.ref(4, r6 + 0x4).setu(r3);
                  r0 = rand();
                  r1 = CPU.r10().value;
                  r0 = r0 & r1;
                  r0 = r0 - 0x7f;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r6 + 0xc).setu(r0);
                  r0 = rand();
                  r2 = CPU.r10().value;
                  r0 = r0 & r2;
                  r0 = r0 - 0x7f;
                  r0 = r0 << 10;
                  MEMORY.ref(4, r6 + 0x10).setu(r0);
                  r0 = rand();
                  r3 = 0xf;
                  r3 = r3 & r0;
                  r7 = r7 + 0x1;
                  MEMORY.ref(4, r6 + 0x18).setu(r3);
                  r6 = r6 + 0x1c;
                } while(r7 != 0x2);
              } else {
                //LAB_80e8788
                r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                if(r3 <= 0xc7) {
                  r3 = 0x0;
                  MEMORY.ref(4, r5 + 0x4).setu(r3);
                  MEMORY.ref(4, r5 + 0x10).setu(r3);
                  MEMORY.ref(4, r5 + 0x18).setu(r3);
                }
              }
            }
          }

          //LAB_80e8796
          r7 = 0x1;
          CPU.r8().value = CPU.r8().value + r7;
          r6 = 0x38;
          r0 = CPU.r8().value;
          r5 = r5 + 0x1c;
          CPU.r9().value = CPU.r9().value + r6;
        } while(r0 != 0x6);

        //LAB_80e87a8
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r3 = 0x7128;
        r1 = 0x0;
        CPU.r8().value = r1;
        r5 = r2 + r3;

        //LAB_80e87b2
        do {
          r0 = MEMORY.ref(4, r5 + 0x18).get();
          if(r0 >= 0) {
            if((r0 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
              r1 = 0x6;
              r0 = divideS(r0, r1);
              r3 = 0x80eeeea;
              r0 = r0 + 0x3;
              r0 = r0 << 1;
              r1 = MEMORY.ref(2, r3 + r0).getUnsigned();
              r3 = 0x80eeef8;
              r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
              r4 = MEMORY.ref(2, r3 + r0).getUnsigned();
              r7 = 0x2;
              r2 = MEMORY.ref(2, r5 + r7).get();
              r1 = r6 + r1;
              r6 = 0x6;
              r3 = MEMORY.ref(2, r5 + r6).get();
              r0 = r4 >>> 1;
              r2 = r2 - r0;
              r3 = r3 - r0;
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_80e87ec
            r0 = r5;
            r1 = 0x3c;
            r2 = 0xffffc000;
            FUN_80e3908(r0, r1, r2);
            r3 = MEMORY.ref(4, r5 + 0x18).get();
            r3 = r3 + 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
          }

          //LAB_80e87fc
          r7 = 0x1;
          CPU.r8().value = CPU.r8().value + r7;
          r0 = CPU.r8().value;
          r5 = r5 + 0x1c;
        } while(r0 != 0x38);

        r2 = 0x82;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r2 = r2 << 1;
        if(r1 == r2) {
          r3 = 0x0;
          CPU.r8().value = r3;
          r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = 0x7828;
          r3 = MEMORY.ref(4, r6 + r3).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          if(r3 != 0) {
            r7 = 0x7828;
            r5 = r6 + r7;
            r6 = 0x24;

            //LAB_80e8828
            do {
              r3 = MEMORY.ref(4, r5).get();
              r0 = MEMORY.ref(2, r3 + r6).get();
              r1 = 0x4;
              FUN_80b5088(r0, r1);
              r3 = MEMORY.ref(4, r5).get();
              r0 = MEMORY.ref(2, r3 + r6).get();
              r3 = 0x8;
              r2 = 0x1;
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              r1 = 0x7;
              r3 = CPU.r8().value;
              r2 = -r2;
              FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              r3 = 0x1;
              CPU.r8().value = CPU.r8().value + r3;
              r3 = MEMORY.ref(4, r5).get();
              r3 = MEMORY.ref(4, r3 + 0x14).get();
              r6 = r6 + 0x2;
            } while(CPU.r8().value != r3);
          }

          //LAB_80e8854
          r6 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r7 = 0x77a8;
          r3 = 0x8;
          r2 = r6 + r7;
          MEMORY.ref(4, r2).setu(r3);
          r1 = 0x82;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r1 = r1 << 1;
          if(r0 == r1) {
            r2 = 0x0;
            r7 = 0x2010000;
            CPU.r8().value = r2;

            //LAB_80e886e
            do {
              r0 = rand();
              r5 = 0x3ff;
              r5 = r5 & r0;
              r0 = rand();
              r3 = 0xffff;
              r6 = r0;
              r6 = r6 & r3;
              r3 = 0x80;
              r3 = r3 << 14;
              MEMORY.ref(4, r7).setu(r3);
              r3 = 0xb8;
              r3 = r3 << 15;
              MEMORY.ref(4, r7 + 0x4).setu(r3);
              r0 = r6;
              r0 = sin(r0);
              r5 = r5 + 0x20;
              r3 = r5;
              r3 = r3 * r0;
              r3 = r3 >> 7;
              MEMORY.ref(4, r7 + 0xc).setu(r3);
              r0 = r6;
              r0 = cos(r0);
              r3 = r5;
              r3 = r3 * r0;
              r3 = r3 << 1;
              r3 = -r3;
              r3 = r3 >> 7;
              MEMORY.ref(4, r7 + 0x10).setu(r3);
              r0 = rand();
              r3 = 0xf;
              r3 = r3 & r0;
              r3 = r3 + 0x20;
              MEMORY.ref(4, r7 + 0x18).setu(r3);
              r6 = 0x80;
              r3 = 0x1;
              CPU.r8().value = CPU.r8().value + r3;
              r6 = r6 << 2;
              r7 = r7 + 0x1c;
            } while(CPU.r8().value != r6);
          }
        }

        //LAB_80e88c8
        r0 = 0x80ede48;
        r7 = 0x0;
        r6 = 0x2010000;
        CPU.r8().value = r7;
        CPU.r10().value = r0;

        //LAB_80e88d2
        do {
          r0 = MEMORY.ref(4, r6 + 0x18).get();
          if(r0 >= 0) {
            r0 = r0 >> 3;
            r0 = r0 + 0x1;
            r5 = r0 << 1;
            r1 = CPU.r8().value;
            r3 = r5 - 0x2;
            r2 = CPU.r10().value;
            r4 = 0x1;
            r4 = r4 & r1;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r1 = r3 + r1;
            r3 = r0 >>> 31;
            r7 = 0x2;
            r2 = MEMORY.ref(2, r6 + r7).get();
            r3 = r0 + r3;
            r3 = r3 >> 1;
            r2 = r2 - r3;
            r7 = 0x6;
            r3 = MEMORY.ref(2, r6 + r7).get();
            MEMORY.ref(4, CPU.sp().value).setu(r0);
            r3 = r3 - r0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r4 = r4 << 2;
            r4 = MEMORY.ref(4, r4 + r0).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r2 = 0x80;
            r0 = r6;
            r1 = 0x3e;
            r2 = r2 << 5;
            FUN_80e3908(r0, r1, r2);
            r3 = MEMORY.ref(4, r6 + 0x18).get();
            r3 = r3 - 0x1;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
          }

          //LAB_80e8922
          r1 = 0x1;
          r2 = 0x80;
          CPU.r8().value = CPU.r8().value + r1;
          r2 = r2 << 2;
          r6 = r6 + 0x1c;
        } while(CPU.r8().value != r2);

        r0 = 0x8;
        r1 = 0x8;
        FUN_80e155c(r0, r1);
        FUN_80cd52c();
        r6 = 0x7824;
        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r2 = r3 + r6;
        r3 = 0x1;
        r0 = 0x1;
        MEMORY.ref(4, r2).setu(r3);
        sleep(r0);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r0 = 0xa0;
        r7 = r7 + 0x1;
        r0 = r0 << 1;
        MEMORY.ref(4, CPU.sp().value + 0x28).setu(r7);
        if(r7 == r0) {
          break;
        }
        r3 = 0x3001b04;
        r3 = MEMORY.ref(4, r3).get();
        r2 = 0x3;
        r3 = r3 & r2;
        if(r3 != 0) {
          break;
        }
      } while(true);
    }

    //LAB_80e8968
    r0 = 0x86;
    FUN_80b50e8(r0);
    FUN_80d67dc();
    r3 = 0x77d8;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
    r1 = 0x0;
    CPU.r8().value = r1;
    r5 = r2 + r3;

    //LAB_80e897c
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      CPU.r8().value++;
    } while(CPU.r8().value < 15);

    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0x54;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ea0d8)
  public static void FUN_80ea0d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80eb754)
  public static void FUN_80eb754(int r0) {
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
    r5 = 0x3001ef0;
    r1 = MEMORY.ref(4, r5).get();
    CPU.sp().value -= 0xb0;
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r1);
    r3 = r5 - 0x4;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r3);
    r4 = 0x7828;
    r2 = MEMORY.ref(4, r5 + 0x4).get();
    r6 = r3 + r4;
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r2);
    MEMORY.ref(4, r6).setu(r0);
    r0 = 0x0;
    FUN_80cd594(r0);
    FUN_80c9048();
    r2 = 0x400000c;
    r3 = 0x784;
    MEMORY.ref(2, r2).setu(r3);
    r2 = 0x0;
    r3 = 0xa0;
    r3 = r3 << 19;
    MEMORY.ref(2, r3).setu(r2);
    r3 = r3 + 0x2;
    MEMORY.ref(2, r3).setu(r2);
    r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r0 = 0xef;
    r0 = r0 << 7;
    r3 = 0x0;
    r7 = r7 + r0;
    MEMORY.ref(4, r7).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r0 = 0x1;
    r1 = 0x0;
    FUN_80cd104(r0, r1);
    r1 = 0x175;
    r0 = 0x9;
    r2 = 0x1;
    FUN_80dbb24(r0, r1, r2);
    r2 = 0x3001ce0;
    r3 = 0xf0;
    MEMORY.ref(4, r2 + 0x10).setu(r3);
    r0 = MEMORY.ref(4, r6).get();
    FUN_80d6750(r0);
    r2 = 0x4000048;
    r3 = 0x2737;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0xca;
    r2 = r2 - 0x8;
    MEMORY.ref(2, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r2 = 0x0;
    r1 = 0x3a;
    r0 = 0x1;
    loadBattleBackground_(r0, r1, r2);
    r0 = 0x1;
    r1 = 0x1;
    FUN_80cd104(r0, r1);
    r0 = 0x73;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
    r2 = 0x0;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r0 = 0x95;
    r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r2 = 0x1;
    r3 = 0x1;
    FUN_80e0524(r0, r1, r2, r3);
    r3 = 0x7741;
    r2 = 0x80;
    r2 = r2 << 19;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x80;
    r2 = r2 + 0x20;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x100e;
    r2 = r2 + 0x32;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x3f44;
    r1 = 0x0;
    r2 = r2 - 0x2;
    MEMORY.ref(2, r2).setu(r3);
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r1);
    r3 = 0x3001ad0;
    r3 = MEMORY.ref(2, r3 + 0x4).getUnsigned();
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
    r5 = MEMORY.ref(4, r5 + 0x10).get();
    r2 = 0x1;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r5);
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    MEMORY.ref(4, r7).setu(r2);
    r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r7 = 0x7784;
    r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
    r3 = r4 + r7;
    MEMORY.ref(4, r3).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    r3 = 0xe1;
    MEMORY.ref(4, r1 + 0x10).setu(r2);
    r3 = r3 << 7;
    r2 = 0x0;
    CPU.r8().value = r2;
    r6 = 0x1f;
    r5 = r4 + r3;

    //LAB_80eb8a6
    do {
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 + 0x10;
      MEMORY.ref(4, r5).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 + 0x30;
      r0 = r0 << 16;
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 - 0x10;
      r0 = r0 << 16;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      r0 = rand();
      r1 = 0x30;
      r0 = modU(r0, r1);
      r4 = 0x1;
      CPU.r8().value = CPU.r8().value + r4;
      r0 = r0 + 0x2;
      r7 = CPU.r8().value;
      MEMORY.ref(4, r5 + 0x18).setu(r0);
      r5 = r5 + 0x1c;
    } while(r7 != 0x40);

    FUN_80ed408(46, 7, 7, 3, 3);
    MEMORY.ref(4, CPU.sp().value + 0x48).setu(boardWramMallocHead_3001e50.offset(46 * 0x4).get());
    CPU.r11().value = 0;
    GPU.BG2CNT.setu(0x786);

    //LAB_80ebc56
    do {
      r7 = CPU.r11().value;
      if(r7 == 0x78) {
        break;
      }
      r0 = 0x0;
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
      if(r7 == 0) {
        r0 = 0x88;
        playSound_(r0);
      }

      //LAB_80ebc6a
      r1 = CPU.r11().value;
      if(r1 == 0x1a) {
        r0 = 0x8d;
        playSound_(r0);
      }

      //LAB_80ebc76
      r2 = CPU.r11().value;
      if(r2 == 0x28) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc82
      r3 = CPU.r11().value;
      if(r3 == 0x48) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc8e
      r4 = CPU.r11().value;
      if(r4 == 0x68) {
        r0 = 0x9a;
        playSound_(r0);
      }

      //LAB_80ebc9a
      r3 = 0x3001b04;
      r3 = MEMORY.ref(4, r3).get();
      r2 = 0x3;
      r3 = r3 & r2;
      if(r3 != 0) {
        //LAB_80ebca8
        r7 = CPU.r11().value;
        if(r7 > 0x10) {
          break;
        }
      }

      //LAB_80eb914
      r3 = CPU.r11().value;
      r3 = r3 - 0x18;
      if((r3 & 0xffff_ffffL) <= (0x1f & 0xffff_ffffL)) {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r1 = r1 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
      }

      //LAB_80eb922
      r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      if(r2 > 0x18) {
        r3 = 0x18;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
      }

      //LAB_80eb92c
      r4 = CPU.r11().value;
      if(r4 <= 0x87) {
        r7 = 0x3001ad0;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = MEMORY.ref(2, r7 + 0x4).getUnsigned();
        r1 = r7;
        r3 = r3 - r0;
        MEMORY.ref(2, r1 + 0x4).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r2 = r2 + r0;
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r2);
      }

      //LAB_80eb944
      r3 = CPU.r11().value;
      if(r3 <= 0x95) {
        r3 = 0x80edad8;
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        r7 = CPU.r11().value;
        MEMORY.ref(4, CPU.sp().value + 0x5c).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x60).setu(r4);
        r4 = 0x0;
        CPU.r10().value = r4;
        if(r7 > 0x67) {
          r0 = 0xfffff980;
          r3 = r7 << 4;
          r0 = r0 + r3;
          CPU.r10().value = r0;
        }

        //LAB_80eb966
        r3 = CPU.r11().value;
        r3 = r3 - 0x8;
        if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          r3 = r1 + r2;
          r3 = r3 - 0x8;
          MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
        }

        //LAB_80eb978
        r3 = CPU.r11().value;
        if(r3 > 0x7) {
          r5 = 0x60;
          if(r3 <= 0x68) {
            r5 = 0x20;
          }

          //LAB_80eb986
          r4 = CPU.r11().value;
          r7 = 0xffffe000;
          r3 = r4 << 10;
          r0 = r3 + r7;
          r3 = 0xffff;
          r1 = 0x80;
          r0 = r0 & r3;
          r1 = r1 << 8;
          if(r0 > r1) {
            r2 = 0xffff8000;
            r0 = r0 + r2;
          }

          //LAB_80eb99e
          r0 = sin(r0);
          r3 = r5;
          r3 = r3 * r0;
          r3 = r3 >> 16;
          MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
          r4 = CPU.r11().value;
          r3 = 0x1f;
          r3 = r3 & r4;
          if(r3 == 0x8) {
            r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r0 = 0x77a8;
            r3 = 0x4;
            r2 = r7 + r0;
            MEMORY.ref(4, r2).setu(r3);
          }
        }

        //LAB_80eb9be
        r3 = CPU.sp().value + 0xa0;
        r2 = 0x0;
        MEMORY.ref(4, r3 + 0xc).setu(r2);
        r2 = 0xff;
        r2 = r2 << 16;
        MEMORY.ref(4, r3 + 0x4).setu(r2);
        r6 = r3;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r3 = 0x77d8;
        r1 = 0x0;
        CPU.r8().value = r1;
        r7 = CPU.sp().value + 0x5c;
        r5 = r2 + r3;

        //LAB_80eb9d8
        do {
          r3 = 0x80eef56;
          r4 = CPU.r8().value;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r1 = CPU.r10().value;
          r3 = r0 + r3;
          r3 = r3 - r1;
          r3 = r3 << 16;
          r3 = r3 + 0xe00000;
          MEMORY.ref(4, r6).setu(r3);
          r3 = 0x80eef5f;
          r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r3 = r3 - r4;
          r3 = r3 << 16;
          r3 = r3 + 0x480000;
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          drawSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new), r6, r7, 0);
          r5 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 9);
      }

      //LAB_80eba18
      r3 = CPU.r11().value;
      if(r3 <= 0x1a) {
        r7 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r3 << 3;
        r7 = r7 + 0x4;
        CPU.r10().value = r3;
        if(r7 > 0xa) {
          r7 = 0xa;
        }

        //LAB_80eba2c
        r4 = CPU.r10().value;
        if(r4 > 0x40) {
          r0 = 0x40;
          CPU.r10().value = r0;
        }

        //LAB_80eba36
        r1 = 0x0;
        r2 = CPU.r10().value;
        CPU.r8().value = r1;
        if(r2 != 0x0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 << 1;
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r3);
          r3 = r3 + r4;
          r3 = r3 << 2;
          r3 = r3 + 0x30;
          MEMORY.ref(4, CPU.sp().value + 0x24).setu(r3);
          r3 = r7 >>> 31;
          r3 = r7 + r3;
          r3 = r3 >> 1;
          r0 = r7 << 1;
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
          CPU.r9().value = r0;

          //LAB_80eba5c
          do {
            r1 = CPU.r8().value;
            r6 = r1 << 10;
            r0 = r6;
            r0 = sin(r0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r3 + 0x8;
            r5 = r3;
            r5 = r5 * r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            r5 = r5 >> 16;
            r0 = r6;
            r5 = r5 + r2;
            r0 = cos(r0);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r3 = r4;
            r3 = r3 * r0;
            r2 = CPU.r9().value;
            r0 = 0x80ede48;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
            r2 = r2 - 0x2;
            r1 = MEMORY.ref(2, r0 + r2).getUnsigned();
            r5 = r5 + 0x60;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r3 = r3 >> 16;
            r5 = r5 - r4;
            r0 = CPU.r9().value;
            r3 = r3 + 0x40;
            r1 = r2 + r1;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r3 = r3 - r7;
            MEMORY.ref(4, CPU.sp().value).setu(r7);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
            r2 = r5;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r0 = 0x1;
            CPU.r8().value = CPU.r8().value + r0;
          } while(CPU.r8().value != CPU.r10().value);
        }
      }

      //LAB_80ebab0
      r1 = CPU.r11().value;
      if(r1 == 0x18) {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r4 = 0xef;
        r4 = r4 << 7;
        r2 = r3 + r4;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
        r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r0 = 0x7784;
        r3 = 0x32;
        r2 = r7 + r0;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80ebacc
      r1 = CPU.r11().value;
      if(r1 == 0x1c) {
        r2 = 0x400000c;
        r3 = 0x784;
        MEMORY.ref(2, r2).setu(r3);
      }

      //LAB_80ebad8
      r2 = CPU.r11().value;
      if(r2 > 0x11) {
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r7 = 0xe1;
        r3 = 0x0;
        r7 = r7 << 7;
        CPU.r8().value = r3;
        r6 = 0x1f;
        r5 = r4 + r7;

        //LAB_80ebaec
        do {
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          if(r3 == 0) {
            r1 = 0x3;
            r0 = CPU.r8().value;
            r0 = modS(r0, r1);
            r0 = r0 + 0x1;
            r4 = r0 << 1;
            r2 = 0x80ede48;
            r3 = r4 - 0x2;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r7 = 0x6;
            r3 = MEMORY.ref(2, r5 + r7).get();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r3 = r3 - r0;
            r1 = r2 + r1;
            r2 = MEMORY.ref(4, r5).get();
            MEMORY.ref(4, CPU.sp().value).setu(r0);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r3 = MEMORY.ref(4, r5).get();
            r3 = r3 + 0x2;
            r2 = MEMORY.ref(4, r5 + 0x10).get();
            MEMORY.ref(4, r5).setu(r3);
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r3 = r3 + r2;
            MEMORY.ref(4, r5 + 0x4).setu(r3);
            r3 = r2 << 1;
            r3 = r3 + r2;
            r3 = r3 << 4;
            if(r3 < 0) {
              r3 = r3 + 0x3f;
            }

            //LAB_80ebb72
            r3 = r3 >> 6;
            MEMORY.ref(4, r5 + 0x10).setu(r3);
          } else {
            //LAB_80ebb78
            r3 = r3 - 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
          }

          //LAB_80ebb7c
          r3 = MEMORY.ref(4, r5).get();
          if(r3 > 0x80 || MEMORY.ref(4, r5 + 0x18).get() == 0x1) {
            //LAB_80ebb88
            r0 = rand();
            r7 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r0 = r0 & r6;
            r0 = r0 + r7;
            r0 = r0 + 0xac;
            MEMORY.ref(4, r5).setu(r0);
            r0 = rand();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r0 = r0 & r6;
            r0 = r0 - r1;
            r0 = r0 + 0x38;
            r0 = r0 << 16;
            MEMORY.ref(4, r5 + 0x4).setu(r0);
            r0 = rand();
            r0 = r0 & r6;
            r0 = r0 - 0x10;
            r0 = r0 << 15;
            MEMORY.ref(4, r5 + 0x10).setu(r0);
          }

          //LAB_80ebbb2
          r2 = 0x1;
          CPU.r8().value = CPU.r8().value + r2;
          r3 = CPU.r8().value;
          r5 = r5 + 0x1c;
        } while(r3 != 0x30);
      }

      //LAB_80ebbbe
      r4 = CPU.r11().value;
      if(r4 > 0x1f) {
        r3 = CPU.r11().value;
        r3 = r3 - 0x20;
        r2 = r3 >>> 31;
        r3 = r3 + r2;
        r5 = r3 >> 1;
        if(r5 > 0x28) {
          r5 = 0x28;
        }

        //LAB_80ebbd4
        r7 = 0x0;
        CPU.r8().value = r7;
        r6 = 0x0;
        r7 = 0x78;

        //LAB_80ebbdc
        do {
          r0 = rand();
          r3 = 0x3;
          r0 = r0 & r3;
          r1 = r0 << 1;
          r1 = r1 + r0;
          r3 = 0x30;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r1 = r1 << 9;
          r3 = 0x20;
          r1 = r0 + r1;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r3 = r6;
          r2 = r7 - r5;
          r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1;
          CPU.r8().value = CPU.r8().value + r0;
          r1 = CPU.r8().value;
          r6 = r6 + 0x12;
        } while(r1 != 0x6);
      }

      //LAB_80ebc0e
      r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r4 = 0x77a8;
      r2 = r3 + r4;
      r3 = MEMORY.ref(4, r2).get();
      if(r3 > 0) {
        r3 = r3 - 0x1;
        MEMORY.ref(4, r2).setu(r3);
        r0 = rand();
        r3 = 0x7;
        r7 = 0x3001ad0;
        r0 = r0 & r3;
        r0 = r0 + 0x1c;
        MEMORY.ref(2, r7 + 0x6).setu(r0);
      } else {
        //LAB_80ebc3c
        r0 = 0x3001ad0;
        r3 = 0x20;
        MEMORY.ref(2, r0 + 0x6).setu(r3);
      }

      //LAB_80ebc42
      r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x7824;
      r2 = r1 + r3;
      r3 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r4 = 0x1;
      CPU.r11().value = CPU.r11().value + r4;
    } while(true);

    //LAB_80ebcb0
    r0 = CPU.sp().value + 0x38;
    r3 = 0x3001ad0;
    r0 = MEMORY.ref(2, r0).getUnsigned();
    MEMORY.ref(2, r3 + 0x4).setu(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
    r2 = 0x0;
    MEMORY.ref(4, r1 + 0x10).setu(r2);
    FUN_80d67dc();
    r2 = 0x4000040;
    r3 = 0xf0;
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r4 = 0x77d8;
    r2 = 0x0;
    CPU.r8().value = r2;
    r0 = 0xc;
    r1 = r3 + r4;

    //LAB_80ebcd4
    do {
      r2 = MEMORY.ref(4, r1).get();
      r1 += 0x4;
      r3 = MEMORY.ref(1, r2 + 0x9).getUnsigned();
      r7 = 0x1;
      r3 = r3 | r0;
      CPU.r8().value = CPU.r8().value + r7;
      MEMORY.ref(1, r2 + 0x9).setu(r3);
      r2 = CPU.r8().value;
    } while(r2 != 0x9);

    r4 = CPU.sp().value;
    r4 = r4 + 0x74;
    r3 = 0xe0;
    r2 = CPU.sp().value;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
    r1 = 0x0;
    r3 = r4;
    r2 = r2 + 0x82;

    //LAB_80ebd14
    do {
      MEMORY.ref(1, r3).setu(r1);
      r3 = r3 + 0x1;
    } while(r3 != r2);

    r7 = CPU.sp().value;
    r7 = r7 + 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7);
    r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r7 = 0x1f;
    r6 = CPU.sp().value + 0x94;

    //LAB_80ebd28
    do {
      r0 = rand();
      r0 = r0 & r7;
      MEMORY.ref(1, r5).setu(r0);
      r5 = r5 + 0x1;
    } while(r5 != r6);

    r0 = 0x0;
    r2 = 0xa0;
    r3 = 0x2010018;
    CPU.r8().value = r0;
    r1 = 0x0;
    r2 = r2 << 1;

    //LAB_80ebd42
    do {
      r4 = 0x1;
      CPU.r8().value = CPU.r8().value + r4;
      MEMORY.ref(4, r3).setu(r1);
      r3 = r3 + 0x1c;
    } while(CPU.r8().value != r2);

    r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
    r0 = 0xef;
    r0 = r0 << 7;
    r1 = 0x7784;
    r2 = r7 + r0;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = r7 + r1;
    r3 = 0x4b;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x400000c;
    r3 = 0x784;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0x1010;
    r2 = r2 + 0x46;
    MEMORY.ref(2, r2).setu(r3);
    r3 = 0xfffffe20;
    r2 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
    CPU.r11().value = r2;

    //LAB_80ebd76
    do {
      r4 = CPU.r11().value;
      if(r4 <= 0x17) {
        r3 = 0x80edae0;
        r7 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r4 = MEMORY.ref(4, r3 + 0x4).get();
        r3 = MEMORY.ref(4, r3).get();
        r7 = r7 - 0x10;
        r0 = CPU.r11().value;
        MEMORY.ref(4, CPU.sp().value + 0x54).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x58).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r7);
        if(r0 <= 0x8) {
          r1 = 0x80;
          r3 = r0 << 11;
          r1 = r1 << 7;
          r2 = 0x80;
          r0 = r3 + r1;
          r2 = r2 << 8;
          if(r0 > r2) {
            r4 = 0xffffc000;
            r0 = r3 + r4;
          }

          //LAB_80ebdc4
          r0 = sin(r0);
          r0 = r0 << 6;
        } else {
          //LAB_80ebdcc
          r7 = CPU.r11().value;
          r1 = 0x80;
          r3 = r7 << 11;
          r1 = r1 << 7;
          r2 = 0x80;
          r0 = r3 + r1;
          r2 = r2 << 8;
          if(r0 > r2) {
            r4 = 0xffffc000;
            r0 = r3 + r4;
          }

          //LAB_80ebde2
          r0 = sin(r0);
          r0 = r0 << 5;
        }

        //LAB_80ebde8
        r4 = r0 >> 16;
        r3 = CPU.sp().value + 0x64;
        r2 = 0x0;
        MEMORY.ref(4, r3 + 0xc).setu(r2);
        r2 = 0xff;
        r2 = r2 << 16;
        MEMORY.ref(4, r3 + 0x4).setu(r2);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r1 = 0x77d8;
        r7 = 0x0;
        CPU.r8().value = r7;
        r6 = r3;
        r7 = CPU.sp().value + 0x54;
        r5 = r0 + r1;

        //LAB_80ebe04
        do {
          r3 = 0x80eef56;
          r2 = CPU.r8().value;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r3 = r0 + r3;
          r3 = r3 << 16;
          MEMORY.ref(4, r6).setu(r3);
          r3 = 0x80eef5f;
          r3 = MEMORY.ref(1, r3 + r2).getUnsigned();
          r3 = r3 - r4;
          r3 = r3 << 16;
          r3 = r3 + 0x480000;
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          drawSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new), r6, r7, 0);
          r5 += 0x4;
          CPU.r8().value++;
        } while(CPU.r8().value < 9);
      }

      //LAB_80ebe3c
      r4 = CPU.r11().value;
      if(r4 == 0x8) {
        r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(4, r7 + 0x77a8).setu(r4);
        playSound_(0x91);
      }

      //LAB_80ebe50
      if(CPU.r11().value == 0xb) {
        playSound_(0x91);
      }

      //LAB_80ebe5c
      if(CPU.r11().value == 0x2e) {
        playSound_(0x89);
      }

      //LAB_80ebe68
      r2 = 0x7828;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x0;
      CPU.r8().value = r3;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        r0 = 0x0;
        r7 = 0x24;
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        CPU.r9().value = r7;

        //LAB_80ebe80
        do {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          r4 = CPU.r8().value;
          r3 = MEMORY.ref(1, r1 + r4).getUnsigned();
          if(r3 == 0x0) {
            r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r3 = MEMORY.ref(4, r7 + r2).get();
            r5 = CPU.sp().value + 0x94;
            r1 = CPU.r9().value;
            r0 = MEMORY.ref(2, r3 + r1).get();
            FUN_80e3980(r0, MEMORY.ref(4, r5, Vec3::new));
            r3 = MEMORY.ref(4, r5).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            if(r3 > r4) {
              r7 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = 0x1;
              r0 = CPU.r8().value;
              MEMORY.ref(1, r7 + r0).setu(r3);
              r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r2 = 0x2010000;
              CPU.r10().value = r5;
              r6 = 0x0;
              r7 = 0xff;
              r5 = r1 + r2;

              //LAB_80ebeb6
              do {
                r4 = CPU.r10().value;
                r3 = MEMORY.ref(4, r4).get();
                r3 = r3 << 15;
                MEMORY.ref(4, r5).setu(r3);
                r3 = MEMORY.ref(4, r4 + 0x4).get();
                r3 = r3 - 0x10;
                r3 = r3 << 16;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r0 = r0 & r7;
                r0 = r0 - 0x80;
                r0 = r0 << 10;
                MEMORY.ref(4, r5 + 0xc).setu(r0);
                r0 = rand();
                r0 = r0 & r7;
                r0 = r0 - 0xc0;
                r3 = r0 << 11;
                r2 = MEMORY.ref(4, r5 + 0xc).get();
                MEMORY.ref(4, r5 + 0x10).setu(r3);
                r3 = MEMORY.ref(4, r5).get();
                r2 = r2 << 2;
                r3 = r3 + r2;
                MEMORY.ref(4, r5).setu(r3);
                r3 = MEMORY.ref(4, r5 + 0x4).get();
                r0 = r0 << 13;
                r3 = r3 + r0;
                MEMORY.ref(4, r5 + 0x4).setu(r3);
                r0 = rand();
                r3 = 0xf;
                r3 = r3 & r0;
                r3 = r3 + 0x8;
                r6 = r6 + 0x1;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
                r5 = r5 + 0x1c;
              } while(r6 != 0x20);

              r7 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
              r0 = 0x7828;
              r3 = r7 + r0;
              r3 = MEMORY.ref(4, r3).get();
              r1 = CPU.r9().value;
              r0 = MEMORY.ref(2, r3 + r1).get();
              r1 = 0x1;
              FUN_80b5088(r0, r1);
              r0 = 0x86;
              playSound_(r0);
            }
          }

          //LAB_80ebf1c
          r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r7 = 0xe0;
          r7 = r7 << 2;
          r4 = r4 + r7;
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r4);
          r2 = 0x7828;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          r3 = 0x2;
          CPU.r9().value = CPU.r9().value + r3;
          r3 = MEMORY.ref(4, r1 + r2).get();
          r0 = 0x1;
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          CPU.r8().value = CPU.r8().value + r0;
        } while(CPU.r8().value != r3);
      }

      //LAB_80ebf3a
      r2 = 0x0;
      r5 = 0x2010000;
      CPU.r8().value = r2;
      r7 = 0x3;
      r6 = 0x6;

      //LAB_80ebf44
      do {
        r3 = MEMORY.ref(4, r5 + 0x18).get();
        if(r3 > 0) {
          r3 = 0x80ede48;
          r1 = MEMORY.ref(2, r3 + 0x4).getUnsigned();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r4 = 0x2;
          r2 = MEMORY.ref(2, r5 + r4).get();
          r1 = r3 + r1;
          r0 = 0x6;
          r3 = MEMORY.ref(2, r5 + r0).get();
          r2 = r2 - 0x1;
          r3 = r3 - 0x3;
          MEMORY.ref(4, CPU.sp().value).setu(r7);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0x10).get();
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          r3 = MEMORY.ref(4, r5 + 0x18).get();
          r3 = r3 - 0x1;
          MEMORY.ref(4, r5 + 0x18).setu(r3);
        }

        //LAB_80ebf80
        r0 = 0x1;
        CPU.r8().value = CPU.r8().value + r0;
        r1 = CPU.r8().value;
        r5 = r5 + 0x1c;
      } while(r1 != 0xc0);

      r2 = CPU.r11().value;
      if(r2 == 0x30) {
        r0 = 0x88;
        playSound_(r0);
      }

      //LAB_80ebf98
      r3 = CPU.r11().value;
      if(r3 > 0x28) {
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r7 = 0xef;
        r7 = r7 << 7;
        r0 = 0x7784;
        r2 = r4 + r7;
        r3 = 0x0;
        r6 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        MEMORY.ref(4, r2).setu(r3);
        r2 = r4 + r0;
        r3 = 0x4b;
        r1 = 0x0;
        r5 = 0x8;
        MEMORY.ref(4, r2).setu(r3);
        CPU.r8().value = r1;
        r5 = -r5;

        //LAB_80ebfbc
        do {
          r0 = rand();
          r3 = 0x3;
          r0 = r0 & r3;
          r1 = r0 << 1;
          r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r1 = r1 + r0;
          r4 = CPU.r8().value;
          r1 = r1 << 9;
          r1 = r2 + r1;
          r2 = MEMORY.ref(1, r3 + r4).getUnsigned();
          r3 = 0x30;
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          r2 = r2 - r6;
          r3 = 0x20;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r2 = r2 + 0x78;
          r3 = r5;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
          r7 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
          MEMORY.call(r7, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r0 = 0x1;
          CPU.r8().value = CPU.r8().value + r0;
          r1 = CPU.r8().value;
          r5 = r5 + 0x8;
        } while(r1 != 0x10);
      }

      //LAB_80ebff6
      r2 = CPU.r11().value;
      if(r2 > 0x40) {
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r4 = 0xef;
        r4 = r4 << 7;
        r2 = r3 + r4;
        r3 = 0x2;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80ec008
      r7 = CPU.r11().value;
      if(r7 == 0x3a) {
        r3 = 0x7828;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        r3 = MEMORY.ref(4, r1 + r3).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r0 = 0x0;
        CPU.r8().value = r0;
        if(r3 != 0) {
          r2 = 0x7828;
          r6 = 0x24;
          r5 = r1 + r2;

          //LAB_80ec024
          do {
            r3 = MEMORY.ref(4, r5).get();
            r0 = MEMORY.ref(2, r3 + r6).get();
            r3 = 0x0;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            r1 = 0xe;
            r3 = r3 - 0x1;
            r2 = 0x5;
            FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            r3 = MEMORY.ref(4, r5).get();
            r7 = 0x1;
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            CPU.r8().value = CPU.r8().value + r7;
            r6 = r6 + 0x2;
          } while(CPU.r8().value != r3);
        }
      }

      //LAB_80ec044
      r0 = 0x8;
      r1 = 0x8;
      FUN_80e155c(r0, r1);
      FUN_80cd52c();
      r1 = 0x7824;
      r0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
      r3 = 0x1;
      r2 = r0 + r1;
      MEMORY.ref(4, r2).setu(r3);
      r0 = 0x1;
      sleep(r0);
      r3 = 0x1;
      r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      CPU.r11().value = CPU.r11().value + r3;
      r2 = r2 + 0xc;
      r4 = CPU.r11().value;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    } while(r4 != 0x60);

    //LAB_80ec072
    FUN_80b50e8(0x86);
    CPU.r8().value = 0;
    r6 = MEMORY.ref(4, CPU.sp().value + 0x4c).get() + 0x77d8;

    //LAB_80ec082
    do {
      clearSprite_(MEMORY.ref(4, r6).deref(4).cast(Sprite38::new));
      r6 += 0x4;
      CPU.r8().value++;
    } while(CPU.r8().value < 9);

    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0xb0;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80ec100)
  public static void FUN_80ec100(final int r0) {
    throw new RuntimeException("Not implemented");
  }
}
