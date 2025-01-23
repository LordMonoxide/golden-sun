package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.Camera4c;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.Vec3;

import static org.goldensun.CopiedSegment8000770.memfill32;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.popMatrix;
import static org.goldensun.GoldenSun.pushMatrix;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.rotateMatrixX;
import static org.goldensun.GoldenSun.rotateMatrixY;
import static org.goldensun.GoldenSun.rotateMatrixZ;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.translateMatrix;
import static org.goldensun.GoldenSunVars._80ee2b4;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_80b.FUN_80b5070;
import static org.goldensun.GoldenSun_80b.FUN_80b5078;
import static org.goldensun.GoldenSun_80b.FUN_80b5088;
import static org.goldensun.GoldenSun_80b.FUN_80b50e8;
import static org.goldensun.GoldenSun_80b.FUN_80b5100;
import static org.goldensun.GoldenSun_80b.getActorSprite_;
import static org.goldensun.GoldenSun_80b.getCombatantForUnit_;
import static org.goldensun.GoldenSun_80b.loadBattleBackground_;
import static org.goldensun.GoldenSun_80b.loadUnitSprites_;
import static org.goldensun.GoldenSun_80c.FUN_80cd52c;
import static org.goldensun.GoldenSun_80c.FUN_80cd594;
import static org.goldensun.GoldenSun_80c.FUN_80cdbc0;
import static org.goldensun.GoldenSun_80c.FUN_80cef64;
import static org.goldensun.GoldenSun_80e.FUN_80e0524;
import static org.goldensun.GoldenSun_80e.FUN_80e155c;
import static org.goldensun.GoldenSun_80e.FUN_80e15e8;
import static org.goldensun.GoldenSun_80e.FUN_80e38b8;
import static org.goldensun.GoldenSun_80e.FUN_80e3908;
import static org.goldensun.GoldenSun_80e.FUN_80e3944;
import static org.goldensun.GoldenSun_80e.FUN_80e396c;
import static org.goldensun.GoldenSun_80e.FUN_80e6d3c;
import static org.goldensun.GoldenSun_80e.FUN_80e6eac;
import static org.goldensun.GoldenSun_80e.FUN_80e7320;
import static org.goldensun.GoldenSun_80e.FUN_80e823c;
import static org.goldensun.GoldenSun_80e.FUN_80ea0d8;
import static org.goldensun.GoldenSun_80e.FUN_80eb754;
import static org.goldensun.GoldenSun_80e.FUN_80ec100;
import static org.goldensun.GoldenSun_80e.FUN_80ed408;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_80d {
  private GoldenSun_80d() { }

  @Method(0x80d1714)
  public static void FUN_80d1714(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d2458)
  public static void FUN_80d2458(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d2d98)
  public static void FUN_80d2d98(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r9;
    int r11;

    CPU.sp().value -= 0x3c;
    final int sp30 = MEMORY.ref(4, 0x3001ef0).get();
    final int sp2c = MEMORY.ref(4, 0x3001eec).get();
    final int sp28 = MEMORY.ref(4, 0x3001ef4).get();
    MEMORY.ref(4, sp2c + 0x7828).setu(r0);
    FUN_80cd594(0);
    GPU.BLDALPHA.setu(0x1010);
    final int sp24 = CPU.sp().value + 0x34;
    FUN_80cef64(0, sp24);
    r5 = getPointerTableEntry(110);
    MEMORY.call(0x3001388, 0x5000000, r5, 0x80); // memcpy
    decompress(r5 + 0x80, sp2c);
    decompress(getPointerTableEntry(133) + 0x80, sp2c + 0x6e4);
    decompress(getPointerTableEntry(115), sp28);
    MEMORY.ref(4, sp2c + 0x7780).setu(2);
    MEMORY.ref(4, sp2c + 0x7784).setu(75);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    int sp20 = 0x580000;
    int sp14 = -0x100000;
    int sp18 = -0x40000;
    int sp10 = 0;
    int sp1c = 0x1000000;
    r3 = sp2c + 0x7098;

    //LAB_80d2e7e
    for(r8 = 0; r8 < 0x40; r8++) {
      MEMORY.ref(4, r3).setu(-1);
      r3 = r3 + 0x1c;
    }

    r5 = sp2c + 0x7320;

    //LAB_80d2e96
    for(r8 = 0; r8 < 0x10; r8++) {
      MEMORY.ref(4, r5).setu(rand() & 0x7f);
      MEMORY.ref(4, r5 + 0x4).setu((rand() & 0x7) + 0x38);
      MEMORY.ref(4, r5 + 0x18).setu(-(rand() & 0xf));
      r5 = r5 + 0x1c;
    }

    r3 = 0x2010018;

    //LAB_80d2ed2
    for(r8 = 0; r8 < 0x400; r8++) {
      MEMORY.ref(4, r3).setu(-1);
      r3 = r3 + 0x1c;
    }

    FUN_80d6750(MEMORY.ref(4, sp2c + 0x7828).get());
    sleep(1);
    FUN_80dbb24(12, 380, 2);
    r9 = 0;

    //LAB_80d2f00
    do {
      if((pressedButtons_3001b04.get() & 0x3) != 0 && r9 > 0x20 && r9 <= 0x61) {
        r9 = 0x62;
      }

      //LAB_80d2f1a
      if(r9 == 120) {
        FUN_80b50e8(0x86);
      }

      //LAB_80d2f26
      if(r9 < 0x10) {
        sp10 += 0x2;
      }

      //LAB_80d2f32
      if(r9 < 100) {
        sp1c += sp14;
        sp20 += sp18;
        sp14 = sp14 * 58 / 64;
        sp18 = sp18 * 56 / 64;
        if(sp1c < 0x780000) {
          sp14 += 0x8000;
        }
      }

      //LAB_80d2f7c
      FUN_80e6d3c(1, sp1c, sp20);

      if(r9 == 0x1c) {
        r7 = 0x2010000;
        r8 = 0;

        //LAB_80d2f96
        do {
          if(MEMORY.ref(4, r7 + 0x18).get() == -1) {
            r6 = rand() & 0x3f;
            r5 = rand() & 0xffff;
            MEMORY.ref(4, r7).setu(r6 * sin(r5) / 8 + 0x200000);
            MEMORY.ref(4, r7 + 0x4).setu(r6 * cos(r5) / 4 + 0x600000);
            MEMORY.ref(4, r7 + 0xc).setu((rand() & 0x3f) - 32 << 14);
            MEMORY.ref(4, r7 + 0x10).setu(-(rand() & 0x3f) - 8 << 13);
            MEMORY.ref(4, r7 + 0x18).setu(0);
          }

          //LAB_80d2ffe
          r7 = r7 + 0x1c;
          r8++;
        } while(r8 != 0x100);
      }

      //LAB_80d300c
      if(r9 >= 32 && r9 < 80) {
        r7 = 0x2010000;
        r11 = 0;

        //LAB_80d3022
        for(r8 = 0; r8 < 0x400; r8++) {
          if(MEMORY.ref(4, r7 + 0x18).get() == -1) {
            r6 = rand() & 0x3f;
            r5 = rand() & 0xffff;
            MEMORY.ref(4, r7).setu(r6 * sin(r5) / 8 + 0x200000);
            MEMORY.ref(4, r7 + 0x4).setu(r6 * cos(r5) / 4 + 0x600000);
            MEMORY.ref(4, r7 + 0xc).setu((rand() & 0x3f) - 32 << 14);
            MEMORY.ref(4, r7 + 0x10).setu(-(rand() & 0x3f) - 8 << 13);
            MEMORY.ref(4, r7 + 0x18).setu(0);
            r11++;
            if(r11 == 0x10) {
              break;
            }
          }

          //LAB_80d3094
          r7 = r7 + 0x1c;
        }
      }

      //LAB_80d30a2
      if(r9 == 0) {
        playSound_(0xa4);
      }

      //LAB_80d30ae
      if(r9 == 0x20) {
        playSound_(0x91);
      }

      //LAB_80d30ba
      if(r9 == 0x50) {
        playSound_(0x90);
      }

      //LAB_80d30c6
      if(r9 >= 32 && r9 < 80) {
        r6 = 0x80ee1ac;
        r7 = r9 * 0x10 - 0x100;

        //LAB_80d30e6
        for(r8 = 0; r8 < 3; r8++) {
          r5 = modS(r7, 104);
          MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x34).get(), sp30, sp2c + 0x6e4, MEMORY.ref(1, r6).getUnsigned() - 0x11, MEMORY.ref(1, r6 + 0x1).getUnsigned() - r5 - 104, 34, 104);
          MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x34).get(), sp30, sp2c + 0x6e4, MEMORY.ref(1, r6).getUnsigned() - 0x11, MEMORY.ref(1, r6 + 0x1).getUnsigned() - r5, 34, r5);
          r6 = r6 + 0x2;
          r7 = r7 + 0x19;
        }
      }

      //LAB_80d3132
      if(r9 < 96) {
        //LAB_80d3140
        for(r8 = 0; r8 < 5; r8++) {
          MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x34).get(), sp30, sp2c, r8 * 32 + (r9 / 4 & 0x1f) - 32, 120 - sp10, 32, 32);
        }
      }

      //LAB_80d3172
      r2 = 0x0;
      r5 = 0x2010000;
      r8 = r2;

      //LAB_80d3178
      do {
        if(MEMORY.ref(4, r5 + 0x18).get() >= 0) {
          //LAB_80d3180
          r0 = modS(r8, 3);
          r3 = MEMORY.ref(4, r5 + 0x10).get();
          r4 = r0 + 0x2;
          if(r3 > 0) {
            r4 = r4 + 0x2;
          }

          //LAB_80d3192
          r7 = r9;
          if(r7 > 0x44) {
            if(r4 <= 0x5) {
              r4 = 0x6;
            }
          }

          //LAB_80d319e
          r0 = r9;
          if(r0 > 0x46) {
            if(r4 <= 0x6) {
              r4 = 0x7;
            }
          }

          //LAB_80d31ec
          r1 = r9;
          if(r1 > 0x48) {
            if(r4 <= 0x7) {
              r4 = 0x8;
            }
          }

          //LAB_80d31f8
          r2 = r9;
          if(r2 > 0x4a) {
            if(r4 <= 0x8) {
              r4 = 0x9;
            }
          }

          //LAB_80d3204
          r7 = r9;
          if(r7 > 0x4c) {
            r4 = 0xa;
          }

          //LAB_80d320c
          r6 = 0x4;
          if(r3 <= 0) {
            r6 = 0x0;
          }

          //LAB_80d3214
          r0 = r4 << 1;
          r2 = 0x80ede48;
          r3 = r0 - 0x2;
          r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
          r1 = sp28 + r1;
          r2 = MEMORY.ref(2, r5 + 0x2).get();
          r3 = r4 >>> 31;
          r3 = r4 + r3;
          r3 = r3 >> 1;
          r2 = r2 - r3;
          MEMORY.call(MEMORY.ref(4, sp24 + r6).get(), sp30, r1, r2, MEMORY.ref(2, r5 + 0x6).get() - r4, r4, r0);
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r1 = MEMORY.ref(4, r5 + 0x10).get();
          r3 = MEMORY.ref(4, r5 + 0x4).get();
          r3 = r3 + r1;
          MEMORY.ref(4, r5 + 0x4).setu(r3);
          if(r9 > 0x50) {
            r3 = r1 - 0x8000;
          } else {
            //LAB_80d325c
            r3 = 0x80ee1b4;
            r2 = r8 & 0x3;
            r2 = r2 << 2;
            r3 = MEMORY.ref(4, r3 + r2).get();
            r3 = r1 + r3;
          }

          //LAB_80d326a
          MEMORY.ref(4, r5 + 0x10).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r2 * 62 / 64;
          MEMORY.ref(4, r5 + 0xc).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0x10).get();
          r2 = r2 * 62 / 64;
          MEMORY.ref(4, r5 + 0x10).setu(r2);
          MEMORY.ref(4, r5 + 0x18).incr();
          if(MEMORY.ref(4, r5 + 0x10).get() > 0 && MEMORY.ref(2, r5 + 0x6).get() > 0x68) {
            MEMORY.ref(4, r5 + 0x18).setu(-1);
          }
        }

        //LAB_80d32a8
        r5 = r5 + 0x1c;
        r8++;
      } while(r8 != 0x400);

      //LAB_80d32b8
      if(r9 < 80) {
        r3 = MEMORY.ref(4, sp2c + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r8 = 0;
        if(r3 != 0) {
          r7 = sp2c + 0x7828;
          r4 = 0x24;

          //LAB_80d32d4
          do {
            if(r9 > 29) {
              r6 = modS(r9, 12);
              if(r6 == 0) {
                r3 = MEMORY.ref(4, r7).get();
                final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r3 + r4).get()).actor_00.deref();
                r3 = MEMORY.ref(4, r7).get();
                FUN_80d6888(MEMORY.ref(2, r3 + r4).get(), 7, 5, -1, 0);
                actor.velocity_24.setY(0x48000);
                actor._48.set(0xab85);
              }

              //LAB_80d3314
              if(r6 == 0x6) {
                r3 = MEMORY.ref(4, r7).get();
                FUN_80d6888(MEMORY.ref(2, r3 + r4).get(), 0, 5, -1, 0);
              }
            }

            //LAB_80d332e
            r3 = MEMORY.ref(4, r7).get();
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            r8++;
            r4 = r4 + 0x2;
          } while(r8 != r3);
        }
      }

      //LAB_80d333c
      MEMORY.ref(4, sp2c + 0x7824).setu(1);
      sleep(1);
      r9++;
    } while(r9 != 0x7c);

    //LAB_80d3358
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    FUN_80e6eac(1, sp1c, sp20);
    r5 = sp2c + 0x77d8;
    r8 = 0;

    //LAB_80d337e
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      r8++;
    } while(r8 < 12);

    FUN_80cdbc0();
    CPU.sp().value += 0x3c;
  }

  @Method(0x80d4604)
  public static void FUN_80d4604(int r0, int r1) {
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
    CPU.sp().value -= 0x50;
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r1);
    CPU.r9().value = MEMORY.ref(4, 0x3001eec).get();
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(MEMORY.ref(4, 0x3001ef0).get());
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(MEMORY.ref(4, 0x3001ef4).get());
    MEMORY.ref(4, CPU.r9().value + 0x7828).setu(r0);

    if(MEMORY.ref(4, CPU.sp().value + 0x38).get() == 0) {
      FUN_80cd594(1);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(60);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(48);
      //LAB_80d4642
    } else if(MEMORY.ref(4, CPU.sp().value + 0x38).get() == 0x1) {
      FUN_80cd594(0);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(60);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(64);
    } else {
      //LAB_80d4660
      FUN_80cd594(0);
      r3 = MEMORY.ref(4, CPU.r9().value + 0x7828).get();
      final Vec3 sp0x44 = new Vec3();
      FUN_80e396c(MEMORY.ref(4, r3 + 0x8).get(), sp0x44);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(sp0x44.getX() / 2);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(sp0x44.getY() + 48);
    }

    //LAB_80d4682
    GPU.BLDALPHA.setu(0x1010);
    MEMORY.ref(4, CPU.sp().value).setu(2);
    FUN_80ed408(46, 7, 7, 3, 2);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(MEMORY.ref(4, 0x3001f08).get());
    FUN_80ed408(47, 7, 7, 3, 3);
    r3 = MEMORY.ref(4, 0x3001f0c).get();
    r0 = CPU.sp().value + 0x3c;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    MEMORY.ref(4, r0 + 0x4).setu(r3);
    FUN_80e0524(125, CPU.r9().value, 1, 1);
    FUN_80e0524(115, MEMORY.ref(4, CPU.sp().value + 0x28).get(), 0, 0);

    if(MEMORY.ref(4, CPU.sp().value + 0x38).get() == 0x1) {
      MEMORY.memcpy(0x5000000, getPointerTableEntry(135), 0x80);
      //LAB_80d46fe
    } else if(MEMORY.ref(4, CPU.sp().value + 0x38).get() == 0x2) {
      MEMORY.memcpy(0x5000000, getPointerTableEntry(196), 0x80);
    }

    //LAB_80d4718
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
    r3 = CPU.r9().value + 0x7828;
    r3 = MEMORY.ref(4, r3).get();
    r2 = MEMORY.ref(4, r3 + 0x18).get();
    if(MEMORY.ref(2, 0x80ee262 + r2 * 10 + 2).getUnsigned() != 0) {
      //LAB_80d4736
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(CPU.r9().value);

      //LAB_80d473a
      do {
        r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        CPU.r10().value = 0;
        r7 = r2 + 0x7080;

        //LAB_80d4746
        do {
          r6 = CPU.r10().value * 2;
          r5 = rand() & 0xffff;
          MEMORY.ref(4, r7).setu(r6 * sin(r5));
          MEMORY.ref(4, r7 + 0x4).setu(-(r6 * cos(r5)));
          MEMORY.ref(4, r7 + 0x18).setu(CPU.r10().value / 2 + 25);
          r7 = r7 + 0x1c;
          CPU.r10().value++;
        } while(CPU.r10().value != 0x10);

        r0 = 0x0;
        CPU.r10().value = r0;
        r0 = 0x7828;
        r2 = CPU.r9().value;
        r3 = MEMORY.ref(4, r2 + r0).get();
        r2 = MEMORY.ref(4, r3 + 0x18).get();
        r3 = r2 << 2;
        r1 = 0x80ee262;
        r3 = r3 + r2;
        r3 = r3 << 1;
        r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
        r4 = r1;
        if(r3 != 0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
          r3 = r3 << 16;
          CPU.r11().value = r3;

          //LAB_80d47a8
          do {
            r1 = CPU.r9().value;
            r5 = r1 + r0;
            r3 = MEMORY.ref(4, r5).get();
            r2 = MEMORY.ref(4, r3 + 0x18).get();
            r3 = r2 << 2;
            r3 = r3 + r2;
            r3 = r3 << 1;
            r3 = MEMORY.ref(2, r4 + r3).getUnsigned();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r2 = r3;
            r2 = r2 * r0;
            r2 = r2 + CPU.r10().value;
            r3 = r2 << 3;
            r3 = r3 - r2;
            r1 = 0x2010000;
            r3 = r3 << 2;
            r6 = r3 + r1;
            MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
            r0 = rand();
            r3 = 0x3ff;
            r3 = r3 & r0;
            r3 = r3 + 0x20;
            CPU.r8().value = r3;
            r0 = rand();
            r3 = 0xffff;
            r5 = MEMORY.ref(4, r5).get();
            r7 = r0;
            r7 = r7 & r3;
            r3 = MEMORY.ref(4, r5 + 0x4).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            if(r3 == 0x1) {
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r2 = r3 << 2;
              r2 = r2 + r3;
              r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r2 = r2 + r3;
              r2 = r2 << 1;
              r2 = r2 + 0x4;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r3 = MEMORY.ref(2, r4 + r2).getUnsigned();
              r3 = r0 - r3;
              r3 = r3 + 0x1c;
            } else {
              //LAB_80d4804
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
              r2 = r3 << 2;
              r2 = r2 + r3;
              r2 = r2 + r1;
              r2 = r2 << 1;
              r2 = r2 + 0x4;
              r3 = MEMORY.ref(2, r4 + r2).getUnsigned();
              r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r3 = r2 + r3;
              r3 = r3 - 0x1c;
            }

            //LAB_80d481a
            r3 = r3 << 16;
            MEMORY.ref(4, r6).setu(r3);
            r3 = CPU.r11().value;
            MEMORY.ref(4, r6 + 0x4).setu(r3);
            r0 = r7;
            r0 = sin(r0);
            r3 = CPU.r8().value;
            r3 = r3 * r0;
            r3 = r3 >> 6;
            MEMORY.ref(4, r6 + 0xc).setu(r3);
            r0 = r7;
            r0 = cos(r0);
            r3 = CPU.r8().value;
            r3 = r3 * r0;
            r3 = r3 << 1;
            r3 = -r3;
            r3 = r3 >> 6;
            MEMORY.ref(4, r6 + 0x10).setu(r3);
            r0 = rand();
            r3 = 0x7;
            r3 = r3 & r0;
            r0 = 0x1;
            CPU.r10().value = CPU.r10().value + r0;
            r0 = 0x7828;
            r3 = r3 + 0x20;
            r2 = CPU.r9().value;
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r3 = MEMORY.ref(4, r2 + r0).get();
            r2 = MEMORY.ref(4, r3 + 0x18).get();
            r3 = r2 << 2;
            r1 = 0x80ee262;
            r3 = r3 + r2;
            r3 = r3 << 1;
            r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
            r4 = r1;
          } while(CPU.r10().value != r3);
        }

        //LAB_80d486a
        r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r0 = 0xe0;
        r0 = r0 << 1;
        r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = r3 + r0;
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
        r2 = r2 + 0x1;
        r3 = 0x7828;
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(r2);
        r3 = r3 + CPU.r9().value;
        r3 = MEMORY.ref(4, r3).get();
        r2 = MEMORY.ref(4, r3 + 0x18).get();
        r3 = r2 << 2;
        r3 = r3 + r2;
        r3 = r3 << 1;
        r3 = r3 + 0x2;
        r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
        r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      } while(r0 != r3);
    }

    //LAB_80d4894
    r2 = 0xef;
    r2 = r2 << 7;
    r2 = r2 + CPU.r9().value;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x7784;
    r3 = 0x4b;
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r1 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1);
    r0 = 0x7828;
    r2 = CPU.r9().value;
    r3 = MEMORY.ref(4, r2 + r0).get();
    r2 = MEMORY.ref(4, r3 + 0x18).get();
    r3 = r2 << 2;
    r3 = r3 + r2;
    r1 = 0x80ee262;
    r3 = r3 << 1;
    r3 = r3 + 0x2;
    r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
    r2 = 0x1ffffff9;
    if(r3 != r2) {
      //LAB_80d48d0
      r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
      r1 = 0x7828;
      r3 = r3 - 0x1;
      r1 = r1 + CPU.r9().value;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);

      //LAB_80d48dc
      do {
        r3 = 0x3001e80;
        r1 = MEMORY.ref(4, r3).get();
        r3 = CPU.r9().value;
        r2 = MEMORY.ref(4, r3 + r0).get();
        r3 = MEMORY.ref(4, r2 + 0x18).get();
        if(r3 == 0x2) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          if(r0 <= 0x33) {
            r3 = MEMORY.ref(4, r2 + 0x4).get();
            if(r3 == 0) {
              r3 = MEMORY.ref(2, r1 + 0x36).getUnsigned();
              r2 = 0x80;
              r2 = r2 << 1;
              r3 = r3 + r2;
            } else {
              //LAB_80d4900
              r3 = MEMORY.ref(2, r1 + 0x36).getUnsigned();
              r0 = 0xffffff00;
              r3 = r3 + r0;
            }

            //LAB_80d4906
            MEMORY.ref(2, r1 + 0x36).setu(r3);
          }
        }

        //LAB_80d4908
        r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r3 = MEMORY.ref(4, r1).get();
        r3 = MEMORY.ref(4, r3 + 0x18).get();
        if(r3 == 0x3 && MEMORY.ref(4, CPU.sp().value + 0x2c).get() == 0x4) {
          memfill32(MEMORY.ref(4, CPU.sp().value + 0x34).get(), 0x4000, 0x3f3f3f3f);
        }

        //LAB_80d4926
        r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL)) {
          if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() == 0x2) {
            FUN_80b50e8(0x91);
          }
        } else {
          //LAB_80d493a
          if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() == 0x2) {
            playSound_(0x91);
          }

          //LAB_80d4946
          if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() == 0x18) {
            FUN_80b50e8(0x86);
          }
        }

        //LAB_80d4952
        MEMORY.ref(4, CPU.sp().value + 0x30).setu(0);
        r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
        r3 = MEMORY.ref(4, r0).get();
        r2 = MEMORY.ref(4, r3 + 0x18).get();
        r3 = r2 << 2;
        r3 = r3 + r2;
        r3 = r3 << 1;
        r1 = 0x80ee262;
        r3 = r3 + 0x2;
        r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
        if(r3 != 0) {
          //LAB_80d496e
          r2 = CPU.r9().value;
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);

          //LAB_80d4972
          do {
            r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = r3 << 3;
            CPU.r11().value = r3;
            if(r0 == CPU.r11().value) {
              r2 = 0x77a8;
              r3 = 0xc;
              r2 = r2 + CPU.r9().value;
              MEMORY.ref(4, r2).setu(r3);
            }

            //LAB_80d4986
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            if(r1 >= CPU.r11().value) {
              //LAB_80d498e
              r3 = CPU.r11().value;
              r3 = r3 + 0x2;
              if(r1 < r3) {
                r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                r2 = MEMORY.ref(4, r3).get();
                r3 = MEMORY.ref(4, r2 + 0x4).get();
                if(r3 == 0x1) {
                  r2 = MEMORY.ref(4, r2 + 0x18).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                  r3 = r2 << 2;
                  r3 = r3 + r2;
                  r3 = r3 + r0;
                  r1 = 0x80ee262;
                  r3 = r3 << 1;
                  r3 = r3 + 0x4;
                  r2 = MEMORY.ref(2, r1 + r3).getUnsigned();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                  r2 = r3 - r2;
                  r3 = 0x20;
                  MEMORY.ref(4, CPU.sp().value).setu(r3);
                  r3 = 0x40;
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                  r2 = r2 + 0xc;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                  r1 = CPU.r9().value;
                  r3 = r3 - 0x20;
                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                } else {
                  //LAB_80d4a18
                  r2 = MEMORY.ref(4, r2 + 0x18).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                  r3 = r2 << 2;
                  r3 = r3 + r2;
                  r3 = r3 + r0;
                  r1 = 0x80ee262;
                  r3 = r3 << 1;
                  r3 = r3 + 0x4;
                  r2 = MEMORY.ref(2, r1 + r3).getUnsigned();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                  r2 = r3 + r2;
                  r3 = 0x20;
                  MEMORY.ref(4, CPU.sp().value).setu(r3);
                  r3 = 0x40;
                  MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                  r2 = r2 - 0x2c;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                  r1 = CPU.r9().value;
                  r3 = r3 - 0x20;
                  MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                }
              }

              //LAB_80d4a46
              r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
              if(r0 >= CPU.r11().value) {
                r2 = 0x80ee262;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                r0 = 0xe1;
                r1 = 0x0;
                r0 = r0 << 7;
                CPU.r10().value = r1;
                CPU.r8().value = r2;
                r5 = r3 + r0;

                //LAB_80d4a5c
                do {
                  r1 = 0x6;
                  r3 = MEMORY.ref(2, r5 + r1).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                  r7 = r3 + r2;
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r2 = MEMORY.ref(4, r3).get();
                  r3 = MEMORY.ref(4, r2 + 0x4).get();
                  if(r3 == 0x1) {
                    r2 = MEMORY.ref(4, r2 + 0x18).get();
                    r0 = 0x2;
                    r1 = MEMORY.ref(2, r5 + r0).get();
                    r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                    r1 = r1 + r3;
                    r3 = r2 << 2;
                    r3 = r3 + r2;
                    r3 = r3 + r0;
                    r3 = r3 << 1;
                    r3 = r3 + 0x4;
                    r2 = CPU.r8().value;
                    r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
                    r1 = r1 - r3;
                    r6 = r1;
                    r6 = r6 + 0x1c;
                  } else {
                    //LAB_80d4a90
                    r2 = MEMORY.ref(4, r2 + 0x18).get();
                    r3 = 0x2;
                    r1 = MEMORY.ref(2, r5 + r3).get();
                    r3 = r2 << 2;
                    r3 = r3 + r2;
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                    r3 = r3 + r2;
                    r3 = r3 << 1;
                    r1 = r1 + r0;
                    r3 = r3 + 0x4;
                    r0 = CPU.r8().value;
                    r3 = MEMORY.ref(2, r0 + r3).getUnsigned();
                    r1 = r1 + r3;
                    r6 = r1;
                    r6 = r6 - 0x1c;
                  }

                  //LAB_80d4ab0
                  r0 = MEMORY.ref(4, r5 + 0x18).get();
                  if((r0 & 0xffff_ffffL) <= (0x11 & 0xffff_ffffL)) {
                    r1 = 0x3;
                    r0 = divideS(r0, r1);
                    r2 = 0x80ee294;
                    r1 = MEMORY.ref(1, r2 + r0).getUnsigned();
                    r0 = 0x20;
                    MEMORY.ref(4, CPU.sp().value).setu(r0);
                    r1 = r1 << 11;
                    r0 = 0x40;
                    r2 = r6;
                    r3 = r7;
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                    r1 = r1 + CPU.r9().value;
                    r2 = r2 - 0x10;
                    r3 = r3 - 0x20;
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                    r0 = MEMORY.ref(4, r5 + 0x18).get();
                  }

                  //LAB_80d4ade
                  if(r0 > 0) {
                    r3 = r0 - 0x1;
                  } else {
                    //LAB_80d4ae6
                    r3 = 0x1;
                    r3 = -r3;
                  }

                  //LAB_80d4aea
                  MEMORY.ref(4, r5 + 0x18).setu(r3);
                  r3 = 0x1;
                  CPU.r10().value = CPU.r10().value + r3;
                  r0 = CPU.r10().value;
                  r5 = r5 + 0x1c;
                } while(r0 != 0xc);
              }
            }

            //LAB_80d4af8
            r3 = CPU.r11().value;
            r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            r3 = r3 + 0x5;
            if(r1 > r3) {
              r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              r7 = 0xfffff000;
              if(r2 != 0x2) {
                r7 = 0x80;
                r7 = r7 << 5;
              }

              //LAB_80d4b0e
              r4 = 0x7828;
              r3 = 0x0;
              r2 = CPU.r9().value;
              CPU.r10().value = r3;
              r3 = MEMORY.ref(4, r2 + r4).get();
              r2 = MEMORY.ref(4, r3 + 0x18).get();
              r1 = 0x80ee262;
              r3 = r2 << 2;
              r3 = r3 + r2;
              r0 = r1;
              r3 = r3 << 1;
              r3 = MEMORY.ref(2, r0 + r3).getUnsigned();
              if(r3 != 0) {
                //LAB_80d4b2a
                do {
                  r2 = CPU.r9().value;
                  r3 = MEMORY.ref(4, r2 + r4).get();
                  r2 = MEMORY.ref(4, r3 + 0x18).get();
                  r3 = r2 << 2;
                  r3 = r3 + r2;
                  r3 = r3 << 1;
                  r3 = MEMORY.ref(2, r0 + r3).getUnsigned();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                  r2 = r3;
                  r2 = r2 * r0;
                  r2 = r2 + CPU.r10().value;
                  r3 = r2 << 3;
                  r3 = r3 - r2;
                  r2 = 0x2010000;
                  r3 = r3 << 2;
                  r6 = r3 + r2;
                  r3 = MEMORY.ref(4, r6 + 0x18).get();
                  if(r3 > 0) {
                    r0 = r6;
                    r2 = r7;
                    r1 = 0x3c;
                    FUN_80e3908(r0, r1, r2);
                    r3 = MEMORY.ref(4, r6 + 0x18).get();
                    r0 = 0xd8;
                    r2 = MEMORY.ref(4, r6 + 0x4).get();
                    r3 = r3 - 0x1;
                    r0 = r0 << 15;
                    MEMORY.ref(4, r6 + 0x18).setu(r3);
                    if(r2 > r0) {
                      r3 = MEMORY.ref(4, r6 + 0x10).get();
                      r3 = -r3;
                      r2 = r3 >>> 31;
                      r3 = r3 + r2;
                      r3 = r3 >> 1;
                      MEMORY.ref(4, r6 + 0x10).setu(r3);
                    } else {
                      //LAB_80d4b78
                      r0 = MEMORY.ref(4, r6).get();
                      r1 = 0x7effff;
                      if((r0 & 0xffff_ffffL) <= (r1 & 0xffff_ffffL) && r2 >= 0) {
                        r2 = r2 >> 16;
                        r6 = r0 >> 16;
                        r1 = 0x5;
                        r0 = r3;
                        CPU.r8().value = r2;
                        r0 = divideS(r0, r1);
                        r0 = r0 + 0x1;
                        r2 = CPU.r10().value;
                        r4 = 0x1;
                        r5 = r0 << 1;
                        r4 = r4 & r2;
                        r2 = 0x80ede48;
                        r3 = r5 - 0x2;
                        r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
                        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
                        r1 = r3 + r1;
                        r3 = r0 >>> 31;
                        r3 = r0 + r3;
                        r3 = r3 >> 1;
                        r2 = CPU.r8().value;
                        r2 = r2 - r0;
                        MEMORY.ref(4, CPU.sp().value).setu(r0);
                        r6 = r6 - r3;
                        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r5);
                        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                        CPU.r8().value = r2;
                        r4 = r4 << 2;
                        r4 = MEMORY.ref(4, r4 + r3).get();
                        r0 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                        r2 = r6;
                        r3 = CPU.r8().value;
                        MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                      }
                    }

                    //LAB_80d4bc8
                    r1 = 0x80ee262;
                  }

                  //LAB_80d4bca
                  r4 = 0x7828;
                  r2 = CPU.r9().value;
                  r3 = MEMORY.ref(4, r2 + r4).get();
                  r2 = MEMORY.ref(4, r3 + 0x18).get();
                  r3 = r2 << 2;
                  r0 = 0x1;
                  r3 = r3 + r2;
                  CPU.r10().value = CPU.r10().value + r0;
                  r3 = r3 << 1;
                  r0 = r1;
                  r3 = MEMORY.ref(2, r0 + r3).getUnsigned();
                } while(CPU.r10().value != r3);
              }
            }

            //LAB_80d4be4
            r2 = 0x7828;
            r3 = 0x0;
            r0 = CPU.r9().value;
            CPU.r10().value = r3;
            r3 = MEMORY.ref(4, r0 + r2).get();
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            if(r3 != 0) {
              r7 = CPU.r11().value;
              r7 = r7 + 0x6;
              r6 = 0x24;

              //LAB_80d4bfa
              do {
                r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                if(r1 == r7) {
                  r3 = CPU.r9().value;
                  r5 = r3 + r2;
                  r3 = MEMORY.ref(4, r5).get();
                  r0 = MEMORY.ref(2, r3 + r6).get();
                  r3 = 0xa;
                  MEMORY.ref(4, CPU.sp().value).setu(r3);
                  r1 = 0x7;
                  r2 = 0x5;
                  r3 = CPU.r10().value;
                  FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                  r3 = MEMORY.ref(4, r5).get();
                  r1 = 0x4;
                  r0 = MEMORY.ref(2, r3 + r6).get();
                  FUN_80b5088(r0, r1);
                }

                //LAB_80d4c20
                r2 = 0x7828;
                r3 = 0x1;
                r0 = CPU.r9().value;
                CPU.r10().value = CPU.r10().value + r3;
                r3 = MEMORY.ref(4, r0 + r2).get();
                r3 = MEMORY.ref(4, r3 + 0x14).get();
                r6 = r6 + 0x2;
              } while(CPU.r10().value != r3);
            }

            //LAB_80d4c32
            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r2 = 0xe0;
            r2 = r2 << 1;
            r1 = r1 + r2;
            r3 = r3 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
            MEMORY.ref(4, CPU.sp().value + 0x30).setu(r3);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r3 = MEMORY.ref(4, r0).get();
            r2 = MEMORY.ref(4, r3 + 0x18).get();
            r3 = r2 << 2;
            r3 = r3 + r2;
            r3 = r3 << 1;
            r1 = 0x80ee262;
            r3 = r3 + 0x2;
            r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
            r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
          } while(r2 != r3);
        }

        //LAB_80d4c5c
        r1 = 0x10;
        r0 = 0x10;
        FUN_80e155c(r0, r1);
        FUN_80cd52c();
        r2 = 0x7824;
        r3 = 0x1;
        r2 = r2 + CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r0 = 0x1;
        sleep(r0);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r3 = r3 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
        r0 = 0x7828;
        r1 = CPU.r9().value;
        r3 = MEMORY.ref(4, r1 + r0).get();
        r2 = MEMORY.ref(4, r3 + 0x18).get();
        r3 = r2 << 2;
        r3 = r3 + r2;
        r3 = r3 << 1;
        r2 = 0x80ee262;
        r3 = r3 + 0x2;
        r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r3 = r3 << 3;
        r3 = r3 + 0x38;
      } while(r1 != r3);
    }

    //LAB_80d4c9c
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0x50;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80d52a4)
  public static void FUN_80d52a4(final int r0) {
    FUN_80d52c8(r0, 5);
  }

  @Method(0x80d52c8)
  public static void FUN_80d52c8(int r0, int r1) {
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
    CPU.sp().value -= 0x74;

    CPU.r8().value = r1;
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    CPU.r9().value = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(16);
    MEMORY.ref(4, CPU.r9().value + 0x7828).setu(r0);
    FUN_80cd594(0);
    FUN_80e0524(158, CPU.r9().value, 1, 1);

    if(CPU.r8().value == 0) {
      r0 = 160;
      //LAB_80d530a
    } else if(CPU.r8().value == 1) {
      r0 = 187;
      //LAB_80d5314
    } else if(CPU.r8().value == 2) {
      r0 = 163;
      //LAB_80d531e
    } else if(CPU.r8().value == 3) {
      r0 = 192;
      //LAB_80d5328
    } else if(CPU.r8().value == 4) {
      r0 = 187;
      //LAB_80d5332
    } else if(CPU.r8().value == 5) {
      FUN_80e0524(183, CPU.r9().value, 1, 0);
      r0 = 183;
      //LAB_80d5340
    } else if(CPU.r8().value == 7) {
      MEMORY.ref(4, CPU.sp().value + 0x34).setu(24);
      FUN_80e0524(183, CPU.r9().value, 1, 0);
      r0 = 141;
    } else {
      //LAB_80d535a
      MEMORY.ref(4, CPU.sp().value + 0x34).setu(32);
      FUN_80e0524(205, CPU.r9().value, 1, 0);
      r0 = 205;
    }

    //LAB_80d536e
    MEMORY.memcpy(0x5000000, getPointerTableEntry(r0), 0x80);

    if(CPU.r8().value == 4) {
      FUN_80e0524(170, CPU.r9().value, 1, 1);
    }

    //LAB_80d5392
    if(CPU.r8().value == 3) {
      FUN_80e0524(206, CPU.r9().value + 0x2580, 1, 0);
    }

    //LAB_80d53a8
    r5 = 0x2010000;
    CPU.r11().value = 0;

    //LAB_80d53b0
    do {
      if(CPU.r8().value >= 0 && CPU.r8().value < 2 || CPU.r8().value == 4 || CPU.r8().value == 5 || CPU.r8().value == 6 || CPU.r8().value == 7) {
        //LAB_80d53c6
        MEMORY.ref(4, r5).setu((rand() & 0xff) - 0x7f << 15);
        MEMORY.ref(4, r5 + 0x4).setu((rand() & 0xff) - 0x7f << 14);
        MEMORY.ref(4, r5 + 0x8).setu((rand() & 0xff) - 0x7f << 15);
      } else {
        //LAB_80d53ea
        MEMORY.ref(4, r5).setu((rand() & 0xff) - 0x7f << 13);
        MEMORY.ref(4, r5 + 0x4).setu((rand() & 0xff) - 0xff << 13);
        MEMORY.ref(4, r5 + 0x8).setu((rand() & 0xff) - 0x7f << 13);
      }

      //LAB_80d540c
      MEMORY.ref(4, r5 + 0x18).setu(0);
      r5 += 0x1c;
      CPU.r11().value++;
    } while(CPU.r11().value != 0x200);

    if(CPU.r8().value >= 0 && CPU.r8().value < 2 || CPU.r8().value == 4 || CPU.r8().value == 5 || CPU.r8().value == 6 || CPU.r8().value == 7) {
      //LAB_80d5436
      r3 = MEMORY.ref(4, CPU.r9().value + 0x7828).get();
      MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0x40 + MEMORY.ref(4, r3 + 0x14).get() * 0x8);
    } else {
      //LAB_80d5444
      r3 = MEMORY.ref(4, CPU.r9().value + 0x7828).get();
      MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0x20 + MEMORY.ref(4, r3 + 0x14).get() * 0x8);
    }

    //LAB_80d5450
    if((CPU.r8().value < 0 || CPU.r8().value > 1) && CPU.r8().value != 3) {
      setTickCallback(getRunnable(GoldenSun_80d.class, "FUN_80dbb9c"), 0x480);
    }

    //LAB_80d5466
    r2 = 0xef;
    r2 = r2 << 7;
    r2 = r2 + CPU.r9().value;
    r3 = 0x2;
    MEMORY.ref(4, r2).setu(r3);
    r2 = 0x7784;
    r3 = 0x4b;
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r0 = 0x8e;
    playSound_(r0);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r0);
    if(r1 != 0) {
      //LAB_80d5494
      r1 = r1 - 0x20;
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);

      //LAB_80d5498
      do {
        final Camera4c sp30 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
        if(CPU.r8().value == 0x7) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r3 = r3 - 0x2e;
          if(r4 == r3) {
            r3 = 0x7828;
            r3 = r3 + CPU.r9().value;
            r3 = MEMORY.ref(4, r3).get();
            r2 = 0x24;
            r1 = MEMORY.ref(2, r3 + r2).get();
            r0 = MEMORY.ref(4, r3 + 0x8).get();
            r2 = 0x10;
            r3 = 0x0;
            FUN_80b5078(r0, r1, r2, r3);
          }

          //LAB_80d54c2
          r3 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          if(r3 == r4) {
            r0 = 0x86;
            FUN_80b50e8(r0);
            r3 = 0x7828;
            r3 = r3 + CPU.r9().value;
            r3 = MEMORY.ref(4, r3).get();
            r1 = 0x24;
            r0 = MEMORY.ref(2, r3 + r1).get();
            r1 = 0x4;
            FUN_80b5088(r0, r1);
            r2 = 0x77a8;
            r3 = 0x8;
            r2 = r2 + CPU.r9().value;
            MEMORY.ref(4, r2).setu(r3);
          }
        } else {
          //LAB_80d5538
          r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
          if(r2 == r3) {
            r0 = 0x85;
            FUN_80b50e8(r0);
          }
        }

        //LAB_80d5546
        r6 = 0xd3;
        r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r6 = r6 << 7;
        r4 = 0x0;
        r7 = 0x80;
        r6 = r6 + CPU.r9().value;
        CPU.r11().value = r4;
        r7 = r7 << 11;
        r5 = r0 << 12;

        //LAB_80d5558
        do {
          r0 = r5;
          r0 = sin(r0);
          r2 = 0x1;
          r0 = r0 << 2;
          r0 = r7 - r0;
          r1 = 0x80;
          CPU.r11().value = CPU.r11().value + r2;
          r0 = r0 >> 10;
          r1 = r1 << 4;
          r3 = CPU.r11().value;
          MEMORY.ref(4, r6).setu(r0);
          r6 += 0x4;
          r5 = r5 + r1;
        } while(r3 != 0xa0);

        MEMORY.ref(4, CPU.sp().value + 0x38).setu(0);
        r3 = MEMORY.ref(4, CPU.r9().value + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        if(r3 != 0) {
          //LAB_80d5588
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(CPU.sp().value + 0x48);
          final Vec3 sp0x5c = new Vec3();
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(0x3001e50);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(36);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);

          //LAB_80d55a6
          do {
            r5 = CPU.r9().value + 0x7828;
            r3 = MEMORY.ref(4, r5).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            final Actor70 sp2c = getCombatantForUnit_(MEMORY.ref(2, r3 + r1).get()).actor_00.deref();
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(MEMORY.ref(4, CPU.sp().value + 0x38).get() * 8);
            if(CPU.r8().value == 0x3) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
              if(r1 > r0) {
                r3 = r0;
                r3 = r3 + 0x20;
                if(r1 < r3) {
                  r3 = MEMORY.ref(4, r5).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                  final Vec3 sp0x50 = new Vec3();
                  FUN_80e396c(MEMORY.ref(2, r3 + r2).get(), sp0x50);
                  r2 = 0x80eded0;
                  r7 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                  r0 = 0x0;
                  r1 = CPU.r8().value;
                  CPU.r11().value = r0;
                  r7 = r7 & r1;
                  CPU.r10().value = r2;

                  //LAB_80d55f2
                  do {
                    r0 = rand();
                    r3 = 0xffff;
                    r2 = r0;
                    r2 = r2 & r3;
                    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r2);
                    r0 = rand();
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    r5 = 0x1f;
                    r5 = r5 & r0;
                    r0 = r2;
                    r0 = sin(r0);
                    r6 = sp0x50.getX();
                    r5 = r5 + 0x4;
                    r3 = r6 >>> 31;
                    r6 = r6 + r3;
                    r3 = r5;
                    r3 = r3 * r0;
                    r4 = 0x80edeca;
                    r3 = r3 >> 17;
                    r6 = r6 >> 1;
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    r6 = r6 + r3;
                    r3 = MEMORY.ref(1, r4 + r7).getUnsigned();
                    r0 = r2;
                    r3 = r3 >>> 1;
                    r6 = r6 - r3;
                    r0 = cos(r0);
                    r3 = r5;
                    r3 = r3 * r0;
                    r5 = sp0x50.getY();
                    r3 = r3 >> 16;
                    r0 = CPU.r10().value;
                    r5 = r5 - r3;
                    r3 = MEMORY.ref(1, r0 + r7).getUnsigned();
                    r3 = r3 >>> 1;
                    r5 = r5 - r3;
                    r0 = rand();
                    r3 = 0x80ee2ae;
                    r1 = 0x3;
                    r0 = r0 & r1;
                    r2 = MEMORY.ref(1, r3 + r0).getUnsigned();
                    r3 = 0x3;
                    r3 = r3 | r2;
                    r2 = 0x2;
                    MEMORY.ref(4, CPU.sp().value).setu(r2);
                    r1 = 0x7;
                    r2 = 0x7;
                    r0 = 0x2f;
                    r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                    r2 = 0x80edebe;
                    r4 = 0x80edeca;
                    r3 = r7 << 1;
                    r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
                    r3 = MEMORY.ref(1, r4 + r7).getUnsigned();
                    MEMORY.ref(4, CPU.sp().value).setu(r3);
                    r0 = CPU.r10().value;
                    r3 = MEMORY.ref(1, r0 + r7).getUnsigned();
                    r2 = 0x96;
                    r2 = r2 << 6;
                    r1 = r1 + CPU.r9().value;
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                    r1 = r1 + r2;
                    r2 = 0x3001f0c;
                    r5 = r5 + 0x10;
                    r4 = MEMORY.ref(4, r2).get();
                    r3 = r5;
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                    r2 = r6;
                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                    r0 = 0x2f;
                    freeSlot(r0);
                    r3 = 0x1;
                    CPU.r11().value = CPU.r11().value + r3;
                    r4 = CPU.r11().value;
                  } while(r4 != 0x2);
                }
              }
            }

            //LAB_80d569a
            r3 = 0x3;
            r1 = 0x7;
            r2 = 0x7;
            r0 = 0x2e;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r3 = r3 + 0xb8;
            r3 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, CPU.sp().value + 0x48).setu(r3);
            r3 = 0x2;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            r2 = 0x7;
            r1 = 0x7;
            r3 = 0x3;
            r0 = 0x2f;
            FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            r0 = 0x3001f0c;
            r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
            r3 = MEMORY.ref(4, r0).get();
            MEMORY.ref(4, r1 + 0x4).setu(r3);
            initMatrixStack();
            FUN_80051d8(sp30._00, sp30._0c);
            sp0x5c.set(sp2c.pos_08.getX(), 0x140000, sp2c.pos_08.getZ());
            translateMatrix(sp0x5c);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            if(r0 > r1) {
              //LAB_80d56f6
              r5 = r0 << 9;
              rotateMatrixY(r5);
              r2 = CPU.r8().value;
              if((r2 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r2 == 0x4) {
                //LAB_80d5708
                rotateMatrixX(r5);
              }

              //LAB_80d570e
              r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
              r3 = 0x0;
              CPU.r11().value = r3;
              if(r4 != 0) {
                //LAB_80d571a
                r0 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r2 = r0 << 6;
                r3 = r0 << 9;
                r3 = r3 - r2;
                r1 = 0x2010000;
                r3 = r3 << 2;
                r7 = r3 + r1;

                //LAB_80d5728
                do {
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                  r3 = r3 + CPU.r11().value;
                  if(r2 > r3) {
                    //LAB_80d5734
                    r3 = MEMORY.ref(4, r7).get();
                    r3 = r3 >> 8;
                    r0 = r3;
                    r0 = r0 * r3;
                    r3 = MEMORY.ref(4, r7 + 0x4).get();
                    r3 = r3 >> 8;
                    r2 = r3;
                    r2 = r2 * r3;
                    r3 = MEMORY.ref(4, r7 + 0x8).get();
                    r3 = r3 >> 8;
                    r4 = r3;
                    r4 = r4 * r3;
                    r0 = r0 + r2;
                    r3 = r4;
                    r0 = r0 + r3;
                    r0 = sqrt(r0);
                    r0 = r0 >> 9;
                    CPU.r10().value = r0;
                    if(r0 != 0) {
                      //LAB_80d5762
                      r3 = MEMORY.ref(4, r7 + 0x18).get();
                      if(r3 <= 0x17) {
                        //LAB_80d576a
                        r1 = r3;
                        if(r1 < 0) {
                          r1 = r1 + 0x3;
                        }

                        //LAB_80d5772
                        final Vec3 sp0x68 = new Vec3();
                        r6 = r1 >> 2;
                        FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x68);
                        r3 = sp0x68.getX();
                        r0 = CPU.r8().value;
                        r2 = r3 >> 1;
                        sp0x68.setX(r2);
                        if(r0 == 0x5 || r0 == 0x7) {
                          //LAB_80d578e
                          r1 = r6 << 1;
                          r1 = r1 + r6;
                          r0 = 0x28;
                          r1 = r1 << 3;
                          r3 = sp0x68.getY();
                          r1 = r1 + r6;
                          MEMORY.ref(4, CPU.sp().value).setu(r0);
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                          r1 = r1 << 6;
                          r4 = MEMORY.ref(4, r0 + 0x4).get();
                          r1 = r1 + CPU.r9().value;
                          r2 = r2 - 0x14;
                          r3 = r3 - 0x14;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                          //LAB_80d57b2
                        } else if(CPU.r8().value == 0x6) {
                          r1 = 0xc;
                          r3 = sp0x68.getY();
                          MEMORY.ref(4, CPU.sp().value).setu(r1);
                          r1 = 0x18;
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                          r1 = 0xc0;
                          r1 = r1 << 4;
                          r4 = MEMORY.ref(4, r0 + 0x4).get();
                          r2 = r2 - 0x6;
                          r3 = r3 - 0xc;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                          r1 = r1 + CPU.r9().value;
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                          //LAB_80d57d8
                        } else if(CPU.r8().value == 0x4) {
                          r1 = 0x16;
                          r3 = sp0x68.getY();
                          MEMORY.ref(4, CPU.sp().value).setu(r1);
                          r1 = 0x2a;
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                          r2 = r2 - 0xb;
                          r4 = MEMORY.ref(4, r0 + 0x4).get();
                          r3 = r3 - 0x15;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                          r1 = CPU.r9().value;
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        } else {
                          //LAB_80d57fa
                          r1 = CPU.r11().value;
                          r3 = 0x3;
                          r3 = r3 & r1;
                          r4 = -r3;
                          r0 = 0x18;
                          r4 = r4 | r3;
                          r1 = r6 << 3;
                          r3 = sp0x68.getY();
                          MEMORY.ref(4, CPU.sp().value).setu(r0);
                          r0 = 0x30;
                          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
                          r4 = r4 >>> 31;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
                          r1 = r1 + r6;
                          r4 = r4 << 2;
                          r1 = r1 << 7;
                          r4 = MEMORY.ref(4, r4 + r0).get();
                          r1 = r1 + CPU.r9().value;
                          r2 = r2 - 0xc;
                          r3 = r3 - 0x18;
                          r0 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                        }

                        //LAB_80d5828
                        r1 = CPU.r8().value;
                        if((r1 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r1 == 0x4 || r1 == 0x5 || r1 == 0x6) {
                          //LAB_80d583a
                          r5 = MEMORY.ref(4, r7).get();
                          r1 = CPU.r10().value;
                          r0 = r5;
                          r0 = divideS(r0, r1);
                          r5 = r5 - r0;
                          MEMORY.ref(4, r7).setu(r5);
                          r5 = MEMORY.ref(4, r7 + 0x4).get();
                          r1 = CPU.r10().value;
                          r0 = r5;
                          r0 = divideS(r0, r1);
                          r5 = r5 - r0;
                          MEMORY.ref(4, r7 + 0x4).setu(r5);
                          r5 = MEMORY.ref(4, r7 + 0x8).get();
                          r1 = CPU.r10().value;
                          r0 = r5;
                          r0 = divideS(r0, r1);
                          r5 = r5 - r0;
                          MEMORY.ref(4, r7 + 0x8).setu(r5);
                        } else {
                          //LAB_80d5866
                          r3 = MEMORY.ref(4, r7 + 0x4).get();
                          r2 = 0x80;
                          r2 = r2 << 9;
                          r3 = r3 + r2;
                          MEMORY.ref(4, r7 + 0x4).setu(r3);
                        }

                        //LAB_80d5870
                        r3 = MEMORY.ref(4, r7 + 0x18).get();
                        r3 = r3 + 0x1;
                        MEMORY.ref(4, r7 + 0x18).setu(r3);
                        if(r3 == 0x18) {
                          r3 = CPU.r8().value;
                          if((r3 & 0xffff_ffffL) <= (0x1 & 0xffff_ffffL) || r3 == 0x4 || r3 == 0x5 || r3 == 0x6) {
                            //LAB_80d588c
                            r3 = 0x0;
                            MEMORY.ref(4, r7 + 0x18).setu(r3);
                          } else {
                            //LAB_80d58bc
                            r0 = rand();
                            r4 = 0xff;
                            r0 = r0 & r4;
                            r0 = r0 - 0x7f;
                            r0 = r0 << 13;
                            MEMORY.ref(4, r7).setu(r0);
                            r0 = rand();
                            r1 = 0xff;
                            r0 = r0 & r1;
                            r0 = r0 - 0xff;
                            r0 = r0 << 12;
                            MEMORY.ref(4, r7 + 0x4).setu(r0);
                            r0 = rand();
                            r2 = 0xff;
                            r0 = r0 & r2;
                            r0 = r0 - 0x7f;
                            r0 = r0 << 13;
                            MEMORY.ref(4, r7 + 0x8).setu(r0);
                          }
                        }
                      }
                    }
                  }

                  //LAB_80d58e6
                  r3 = 0x1;
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x34).get();
                  CPU.r11().value = CPU.r11().value + r3;
                  r7 = r7 + 0x1c;
                } while(CPU.r11().value != r4);
              }
            }

            //LAB_80d58f4
            r0 = 0x2f;
            freeSlot(r0);
            r0 = 0x2e;
            freeSlot(r0);
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r3 = r3 + 0x10;
            if(r0 == r3) {
              r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
              r2 = r1 - r0;
              if(r2 > 0x1f) {
                r2 = 0x1f;
              }

              //LAB_80d5914
              r3 = 0x7828;
              r3 = r3 + CPU.r9().value;
              r3 = MEMORY.ref(4, r3).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
              r0 = MEMORY.ref(2, r3 + r4).get();
              MEMORY.ref(4, CPU.sp().value).setu(r2);
              r1 = 0x7;
              r2 = 0x5;
              r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
              FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
            }

            //LAB_80d592a
            r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
            r2 = r2 + 0x2;
            r3 = r3 + 0x8;
            r4 = r4 + 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
            MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
            MEMORY.ref(4, CPU.sp().value + 0x38).setu(r4);
            r0 = CPU.r9().value;
            r3 = MEMORY.ref(4, r0 + 0x7828).get();
            r3 = MEMORY.ref(4, r3 + 0x14).get();
          } while(r4 != r3);
        }

        //LAB_80d594a
        r1 = 0x10;
        r0 = 0x10;
        FUN_80e155c(r0, r1);
        FUN_80cd52c();
        r2 = 0x7824;
        r3 = 0x1;
        r2 = r2 + CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r0 = 0x1;
        sleep(r0);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r1 = r1 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x40).setu(r1);
      } while(r1 != r2);
    }

    //LAB_80d5972
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r3 = CPU.r8().value;
    if((r3 & 0xffff_ffffL) > (0x1 & 0xffff_ffffL) && r3 != 0x3) {
      clearTickCallback(getRunnable(GoldenSun_80d.class, "FUN_80dbb9c"));
    }

    //LAB_80d5988
    FUN_80cdbc0();
    CPU.sp().value += 0x74;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80d6578)
  public static void FUN_80d6578(final int r0) {
    mallocSlotChip(41, 0x302);
    mallocSlotChip(39, 0x782c);
    mallocSlotChip(40, 0x4000);

    switch(MEMORY.ref(4, r0).get()) {
      case 1 -> FUN_80e823c(r0);
      case 2 -> FUN_80d2d98(r0);
      case 3 -> FUN_80eb754(r0);
      case 4 -> FUN_80dc968(r0);
      case 5 -> FUN_80d6970(r0);
      case 6 -> FUN_80ec100(r0);
      case 7 -> FUN_80d2458(r0);
      case 8 -> FUN_80d1714(r0);
      case 9 -> FUN_80ea0d8(r0);
      case 10 -> FUN_80d765c(r0);
      case 0, 11 -> FUN_80e7320(r0);
      case 12 -> FUN_80e15e8(r0);
    }

    //LAB_80d663a
    freeSlot(40);
    freeSlot(39);
    freeSlot(41);
  }

  @Method(0x80d6660)
  public static void FUN_80d6660(final int r0) {
    mallocSlotChip(41, 0x302);
    mallocSlotChip(39, 0x782c);
    mallocSlotChip(40, 0x4000);

    final int r3 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    MEMORY.ref(4, r3 + 0x7828).setu(r0);

    final int r2 = MEMORY.ref(4, r0).get();
    if(r2 == 0) {
      MEMORY.ref(4, r0 + 0x18).setu(0);
    } else {
      //LAB_80d6692
      _80ee2b4.get(r2 - 1).deref().run(r0);
    }

    //LAB_80d66a0
    freeSlot(40);
    freeSlot(39);
    freeSlot(41);
  }

  @Method(0x80d6750)
  public static void FUN_80d6750(final int r0) {
    final int r3 = MEMORY.ref(2, r0 + 0x24).get();
    final int[] ids = new int[15];
    int count = 0;

    if(r3 > 0x7f) {
      //LAB_80d676a
      for(int r6 = 0; r6 < 6; r6++) {
        if(getUnit_(r6 + 0x80).hp_38.get() > 0) {
          ids[count] = r6 + 0x80;
          count++;
        }

        //LAB_80d6786
      }
    } else {
      //LAB_80d678e
      //LAB_80d679a
      for(int r6 = 0; r6 < 8; r6++) {
        if(getUnit_(r6).hp_38.get() > 0) {
          ids[count] = r6;
          count++;
        }

        //LAB_80d67b2
      }
    }

    //LAB_80d67b8
    ids[count] = 0xff;
    loadUnitSprites_(ids, 0);
  }

  @Method(0x80d67dc)
  public static void FUN_80d67dc() {
    final int r6 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    GPU.DISPCNT.setu(1);
    MEMORY.ref(2, 0x3001ad0 + 0x6).setu(32);
    CPU.sp().value -= 0x4;
    loadBattleBackground_(1, r2.backgroundPointerTableId_648.get(), 24);

    final int r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r6);
    DMA.channels[3].CNT.setu(0x85001000);

    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x6004000);
    DMA.channels[3].CNT.setu(0x85001000);

    sleep(1);
    GPU.BLDALPHA.setu(0x100e);
    GPU.BLDCNT.setu(0x3f46);
    GPU.DISPCNT.setu(0x7741);
    MEMORY.ref(4, 0x3001ce0 + 0x10).setu(120);
    CPU.sp().value += 0x4;
  }

  @Method(0x80d6888)
  public static void FUN_80d6888(final int unitId, final int r1, final int spriteAnimation, final int r3, final int a4) {
    final BattleStruct82c.Combatant2c r8 = getCombatantForUnit_(unitId);
    final int sp08 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    int sp04 = 0;

    //LAB_80d6936
    Sprite38 sprite;
    while((sprite = getActorSprite_(r8.actor_00.deref(), sp04)) != null) {
      //LAB_80d68b2
      if(r3 != -1) {
        MEMORY.ref(1, sp08 + 0x7818 + r3).setu(a4);
      }

      //LAB_80d68c6
      if(r8._2a.get() == 0) {
        if(r1 != -1) {
          //LAB_80d68e6
          for(int layerIndex = 0; layerIndex < sprite.layerCount_27.get(); layerIndex++) {
            final SpriteLayer18 r5 = sprite.layers_28.get(layerIndex).derefNullable();
            if(r5 != null && r5.getAddress() != r8.spriteLayer_24.getPointer() && r5.getAddress() != r8.spriteLayer_20.getPointer()) {
              if(r1 == 0) {
                r5._05.set(FUN_80b5100(unitId));
              } else {
                //LAB_80d690e
                r5._05.set(r1);
              }

              //LAB_80d6912
              r5._16.set(0xff);
            }

            //LAB_80d6916
          }
        }

        //LAB_80d6920
        if(spriteAnimation != -1) {
          setSpriteAnimation_(sprite, spriteAnimation);
        }
      }

      //LAB_80d6930
      sp04++;
    }
  }

  @Method(0x80d6970)
  public static void FUN_80d6970(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    final int r9;
    int r10;
    int r11;

    r1 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    r3 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
    r9 = r1;
    MEMORY.ref(4, r9 + 0x7828).setu(r0);
    FUN_80dbb24(8, 375, 1);
    r10 = 0;
    r2 = 0x2010000;

    //LAB_80d69a6
    do {
      MEMORY.ref(1, r2).setu(r10 & 0x7f);
      r2++;
      r10++;
    } while(r10 != 0x400);

    r10 = 0;
    r11 = 0;

    //LAB_80d69c0
    do {
      //LAB_80d69c4
      for(r7 = 0; r7 < 0x80; r7++) {
        r0 = 0x2010000 + r11 + (rand() & 0x7f);
        r5 = 0x2010000 + r11 + (rand() & 0x7f);
        MEMORY.ref(1, r0).setu(MEMORY.ref(1, r5).getUnsigned());
        MEMORY.ref(1, r5).setu(MEMORY.ref(1, r0).getUnsigned());
      }

      r11 += 0x80;
      r10++;
    } while(r10 != 0x8);

    FUN_80cd594(0);
    GPU.BG2PA.setu(0x100);
    GPU.BLDCNT.setu(0);
    FUN_80e0524(178, r9, 1, 1);
    FUN_80ed408(46, 7, 7, 3, 1);
    r3 = boardWramMallocHead_3001e50.offset(46 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
    FUN_80ed408(47, 7, 7, 7, 1);
    r2 = CPU.sp().value + 0x44;
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
    MEMORY.ref(4, r2 + 0x4).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    MEMORY.ref(4, r9 + 0x7780).setu(1);
    MEMORY.ref(4, r9 + 0x7784).setu(0);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    GPU.BG2X.setu(-0x2000);
    r10 = 0;
    r8 = -90;
    r6 = 0x0;
    r5 = r9 + 0x7080;

    //LAB_80d6aa8
    do {
      if(r10 < 5) {
        MEMORY.ref(4, r5).setu(r6);
        r0 = (rand() & 0x7) + 104;
      } else {
        //LAB_80d6aba
        MEMORY.ref(4, r5).setu(r8);
        r0 = (rand() & 0x7) + 108;
      }

      //LAB_80d6ac6
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      MEMORY.ref(4, r5 + 0x10).setu((rand() & 0x7) + 4);
      MEMORY.ref(4, r5 + 0x18).setu((rand() & 0xf) + 16);
      r8 = r8 + 20;
      r6 = r6 + 0x14;
      r5 = r5 + 0x1c;
      r10++;
    } while(r10 != 0x10);

    r10 = 0;
    r5 = r9 + 0x7240;

    //LAB_80d6af8
    do {
      MEMORY.ref(4, r5).setu((rand() & 0x3f) + 32);
      MEMORY.ref(4, r5 + 0x4).setu((rand() & 0x1f) + 64);
      MEMORY.ref(4, r5 + 0x18).setu(-(rand() & 0x7) - 8);
      r5 = r5 + 0x1c;
      r10++;
    } while(r10 != 0x10);

    r10 = 0;
    r5 = r9 + 0x7400;

    //LAB_80d6b36
    do {
      MEMORY.ref(4, r5).setu(0x800000);
      MEMORY.ref(4, r5 + 0x4).setu(0x400000);
      MEMORY.ref(4, r5 + 0xc).setu(-((rand() & 0xff) + 200) << 9);
      MEMORY.ref(4, r5 + 0x10).setu(0);
      MEMORY.ref(4, r5 + 0x18).setu(0);
      r5 = r5 + 0x1c;
      r10++;
    } while(r10 != 0x10);

    FUN_80d6750(MEMORY.ref(4, r9 + 0x7828).get());
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(-0x400000);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0);

    if((pressedButtons_3001b04.get() & 0x3) != 0) {
      r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      if(r4 > 0xbe && r4 <= 0x11d) {
        MEMORY.memfill(MEMORY.ref(4, CPU.sp().value + 0x40).get(), 0x4000, 0);
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0x11e);
      }
    }

    //LAB_80d6ba4
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0xe0) {
      MEMORY.ref(4, r9 + 0x7780).setu(0);
    }

    //LAB_80d6bb4
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    initMatrixStack();
    FUN_80051d8(camera._00, camera._0c);

    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0x1f) {
      MEMORY.ref(4, r9 + 0x77a8).setu(8);
      playSound_(0x9d);
      r3 = MEMORY.ref(4, r9 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r10 = 0;
      if(r3 != 0) {
        r6 = 0x24;
        r5 = r9 + 0x7828;

        //LAB_80d6bec
        do {
          r3 = MEMORY.ref(4, r5).get();
          FUN_80b5088(MEMORY.ref(2, r3 + r6).get(), 6);
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r6 = r6 + 0x2;
          r10++;
        } while(r10 != r3);
      }
    }

    //LAB_80d6c04
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0x48) {
      playSound_(0x88);
    }

    //LAB_80d6c10
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0x8c) {
      playSound_(0x9c);
    }

    //LAB_80d6c1c
    r1 = MEMORY.ref(4, CPU.sp().value + 0x34).get() + 0x4000;
    r3 = MEMORY.ref(4, CPU.sp().value + 0x38).get() + r1;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(r3);
    if(r3 > 0x400000) {
      MEMORY.ref(4, CPU.sp().value + 0x38).setu(0x400000);
    }

    //LAB_80d6c36
    FUN_80e6d3c(2, 0x800000, MEMORY.ref(4, CPU.sp().value + 0x38).get());
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x30;
    if((r0 & 0xffff_ffffL) <= (0x30 & 0xffff_ffffL)) {
      r0 = divideS(r0, 24);
      r0 = modS(r0, 3);
      r6 = 0x80ee910;
      r5 = r0 << 1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, r9 + 0x77e4).deref(4).cast(Sprite38::new), r1);
      r5 = r5 + 0x1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, r9 + 0x77e8).deref(4).cast(Sprite38::new), r1);
    }

    //LAB_80d6c76
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0x48;
    if((r3 & 0xffff_ffffL) <= (0x37 & 0xffff_ffffL)) {
      r10 = 0;
      r6 = r9 + 0x7400;

      //LAB_80d6c88
      do {
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r10 + 0x48;
        if(r1 >= r3) {
          r5 = MEMORY.ref(4, r6 + 0x4).get();
          if(r5 < 0x680000) {
            r0 = r1 + r10;
            if(r0 < 0x0) {
              r0 = r0 + 0x3;
            }

            //LAB_80d6ca4
            r0 = r0 >> 2;
            r0 = modS(r0, 5);
            r4 = 0x80ee916;
            r1 = r0 << 1;
            r1 = MEMORY.ref(2, r4 + r1).getUnsigned();
            r4 = 0x80ee920;
            r2 = MEMORY.ref(2, r6 + 0x2).get();
            r3 = r5 >> 16;
            r5 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r4 = r5 >>> 1;
            r2 = r2 - r4;
            r4 = 0x80ee925;
            r4 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r0 = r4 >>> 1;
            r1 = r1 + r9;
            r3 = r3 - r0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            FUN_80e3908(r6, 0x40, 0x1000);
          }
        }

        //LAB_80d6ce2
        r6 += 0x1c;
        r10++;
      } while(r10 != 0x10);
    }

    //LAB_80d6cee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r1 == 0x80) {
      r10 = 0;
      r5 = r9 + 0x7240;

      //LAB_80d6cfe
      do {
        MEMORY.ref(4, r5).setu(modU(rand(), 0x60) << 16);
        MEMORY.ref(4, r5 + 0x4).setu((rand() & 0x7) + 0x58 << 16);
        MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) - 0x80 << 11);
        MEMORY.ref(4, r5 + 0x10).setu(-(rand() & 0xff) << 11);
        MEMORY.ref(4, r5 + 0x18).setu(-(rand() & 0xf) - 0x10);
        r5 += 0x1c;
        r10++;
      } while(r10 != 0x30);

      GPU.BG2X.setu(0);
    }

    //LAB_80d6d52
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x80;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    if((r0 & 0xffff_ffffL) <= (0x60 & 0xffff_ffffL)) {
      //LAB_80d6d5e
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
      if(r0 > 0x50) {
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0x50);
      } else {
        //LAB_80d6db8
        MEMORY.ref(4, r9 + 0x77a8).setu(2);
      }

      //LAB_80d6dc0
      r7 = r9 + 0x7080;
      r10 = 0;

      //LAB_80d6dca
      do {
        r3 = MEMORY.ref(4, r7 + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        if(r4 > r3) {
          //LAB_80d6dd4
          r11 = r9;
          if(r10 > 0x5) {
            r11 = r9 + 0x6c0;
          }

          //LAB_80d6de4
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r2 = r4 - r3;
          r3 = MEMORY.ref(4, r7 + 0x10).get();
          r0 = r3 * r2;
          MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0);
          r6 = r0;
          if(r0 > 0xb8) {
            //LAB_80d6df6
            do {
              r6 = r6 - 0x40;
            } while(r6 > 0xb8);
          }

          //LAB_80d6dfc
          if(r6 <= 0x77) {
            r3 = MEMORY.ref(4, r7 + 0x4).get();
            r2 = MEMORY.ref(4, r7).get();
            MEMORY.ref(4, CPU.sp().value).setu(0x18);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(0x8);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r3 = r3 - r6 - 0x8;
            r4 = MEMORY.ref(4, r1 + (r10 & 0x1) * 0x4).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            MEMORY.call(r4, r0, r11, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }

          //LAB_80d6e24
          MEMORY.ref(4, CPU.sp().value + 0x20).setu((r10 & 0x1) * 0x4);
          r8 = 0;

          //LAB_80d6e32
          do {
            r1 = MEMORY.ref(4, r7 + 0x4).get();
            r3 = r8 << 6;
            r2 = r1 - r6;
            r5 = r2 + r3;
            r3 = -0x40;
            r2 = 0x0;
            r0 = 0x40;
            if(r5 >= r3) {
              if(r5 < 0) {
                r2 = -r5;
                r3 = r2 << 1;
                r0 = r5;
                r3 = r3 + r2;
                r2 = r3 << 3;
                r0 = r0 + 0x40;
                r5 = 0x0;
              }

              //LAB_80d6e5a
              r3 = r5 + r0;
              if(r3 > r1) {
                r3 = r3 - r1;
                r0 = r0 - r3;
              }

              //LAB_80d6e64
              r1 = r11 + r2;
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(0x18);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              r1 = r1 + 0xc0;
              r4 = MEMORY.ref(4, r0 + r3).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r5, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_80d6e80
            r8++;
          } while(r8 != 0x3);

          r6 = r10 & 0x1;
          if(r6 != 0) {
            r5 = MEMORY.ref(4, r7 + 0x4).get();
            r8 = (r5 - MEMORY.ref(4, CPU.sp().value + 0x28).get() & 0x7f) - 0x10;
            r1 = modS(r10, 3);
            r4 = MEMORY.ref(1, 0x80ee930 + r1).getUnsigned();
            r3 = r8 + r4;
            CPU.r12().value = r4;
            if(r3 > r5) {
              r3 = r3 - r5;
              r4 = r4 - r3;
            }

            //LAB_80d6ebc
            if(r4 > 0) {
              r3 = r1 << 1;
              r1 = MEMORY.ref(2, 0x80ee92a + r3).getUnsigned();
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(CPU.r12().value);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = r6 << 2;
              r4 = MEMORY.ref(4, r3 + r0).get();
              r1 = r1 + r9;
              r2 = r2 + 0x8;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r8, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }
        }

        //LAB_80d6ee0
        r7 += 0x1c;
        r10++;
      } while(r10 != 0xa);
    }

    //LAB_80d6eee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r1 & 0xffff_ffffL) <= (0x5f & 0xffff_ffffL)) {
      r10 = 0;
      r5 = r9 + 0x7400;

      //LAB_80d6f00
      do {
        if(MEMORY.ref(4, r5 + 0x18).get() >= 0) {
          r0 = modS(r10, 5);
          r3 = r0 << 1;
          r1 = MEMORY.ref(2, 0x80ee934 + r3).getUnsigned();
          r2 = MEMORY.ref(2, r5 + 0x2).get();
          r3 = MEMORY.ref(2, r5 + 0x6).get();
          r4 = MEMORY.ref(1, 0x80ee93e + r0).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r0 = MEMORY.ref(1, 0x80ee943 + r0).getUnsigned();
          r1 = r1 + r9;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r3 = MEMORY.ref(4, r5).get();
          r2 = MEMORY.ref(4, r5 + 0xc).get();
          r3 = r3 + r2;
          MEMORY.ref(4, r5).setu(r3);
          r2 = MEMORY.ref(4, r5 + 0x4).get();
          r3 = MEMORY.ref(4, r5 + 0x10).get();
          r2 = r2 + r3;
          r3 = r3 + 0x4000;
          MEMORY.ref(4, r5 + 0x4).setu(r2);
          MEMORY.ref(4, r5 + 0x10).setu(r3);
          if((r2 & 0xffff_ffffL) > 0x780000) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            if(r2 <= 0x9f) {
              MEMORY.ref(4, r5).setu(modU(rand(), 0x60) << 16);
              MEMORY.ref(4, r5 + 0x4).setu((rand() & 0x7) + 0x58 << 16);
              MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) - 0x80 << 11);
              MEMORY.ref(4, r5 + 0x10).setu(-(rand() & 0xff) << 11);
            }
          }

          //LAB_80d6f8c
        }

        //LAB_80d6f8e
        MEMORY.ref(4, r5 + 0x18).incr();
        r5 += 0x1c;
        r10++;
      } while(r10 != 0x20);
    }

    //LAB_80d6f9e
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xe0;
    if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
      if((MEMORY.ref(4, CPU.sp().value + 0x3c).get() & 0x3) == 0) {
        r4 = 0x5000000;
        r10 = 0;

        //LAB_80d6fbc
        do {
          r3 = MEMORY.ref(2, r4).getUnsigned();
          r7 = r3 & 0x1f;
          r3 = r3 << 16;
          r6 = r3 >>> 21 & 0x1f;
          r5 = r3 >>> 26 & 0x1f;
          r0 = r7 + r6 + r5;
          r0 = divideS(r0, 3);
          if(r7 > r0) {
            r7 = r7 - 0x1;
          }

          //LAB_80d7000
          if(r7 < r0) {
            r7 = r7 + 0x1;
          }

          //LAB_80d7006
          if(r6 > r0) {
            r6 = r6 - 0x1;
          }

          //LAB_80d700c
          if(r6 < r0) {
            r6 = r6 + 0x1;
          }

          //LAB_80d7012
          if(r5 > r0) {
            r5 = r5 - 0x1;
          }

          //LAB_80d7018
          if(r5 < r0) {
            r5 = r5 + 0x1;
          }

          //LAB_80d701e
          MEMORY.ref(2, r4).setu(r5 << 10 | r6 << 5 | r7);
          r4 += 0x2;
          r10++;
        } while(r10 != 0x40);
      }
    }

    //LAB_80d7034
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r3 & 0xffff_ffffL) <= (0xac & 0xffff_ffffL)) {
      r3 = MEMORY.ref(4, r9 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r10 = 0;
      if(r3 != 0) {
        final Vec3 sp0x4c = new Vec3();
        final Vec3 sp0x58 = new Vec3();
        r11 = 0;

        //LAB_80d7052
        do {
          r2 = MEMORY.ref(4, r9 + 0x7828).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r10 * 0x2).get()).actor_00.deref();
          sp0x58.set(actor.pos_08);
          FUN_80e3944(sp0x58, sp0x4c);
          r5 = r9 + 0x7240 + r11 * 0x1c;
          r7 = 0x0;

          //LAB_80d7088
          do {
            r0 = MEMORY.ref(4, r5 + 0x18).get();
            if(r0 == 0) {
              MEMORY.ref(4, r5).setu(sp0x4c.getX() + (rand() & 0xf) - 8);
              MEMORY.ref(4, r5 + 0x4).setu(sp0x4c.getY() + (rand() & 0xf) - 40);
            }

            //LAB_80d70b0
            if((r0 & 0xffff_ffffL) < 5) {
              r1 = MEMORY.ref(2, 0x80ee948 + r0 * 0x2).getUnsigned();
              r0 = MEMORY.ref(1, 0x80ee952 + r0).getUnsigned();
              r4 = r0 >>> 1;
              MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x44).get(), MEMORY.ref(4, CPU.sp().value + 0x40).get(), r1 + r9, MEMORY.ref(4, r5).get() - r4, MEMORY.ref(4, r5 + 0x4).get() - r4, r0, r0);
              r0 = MEMORY.ref(4, r5 + 0x18).get();
            }

            //LAB_80d70d8
            r3 = r0 + 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
            if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() <= 0xc7 && r3 == 0x5) {
              MEMORY.ref(4, r5 + 0x18).setu(-(rand() & 0x7));
            }

            //LAB_80d70f2
            r7 = r7 + 0x1;
            r5 = r5 + 0x1c;
          } while(r7 != 0x6);

          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r11 += 6;
          r10++;
        } while(r10 != r3);
      }
    }

    //LAB_80d710e
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 > 0xe8) {
      r6 = r0 * 0x2 - 0x1f0;
      r10 = 0;
      CPU.r12().value = 0;
      r4 = r6;

      //LAB_80d7124
      do {
        r7 = 0x0;

        //LAB_80d7126
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r0 = r4 & 0x7;
            r3 = r0 << 5;
            r3 = r3 + r10;
            r1 = 0x2010000;
            r3 = r3 << 2;
            r3 = r3 + r7;
            r3 = r3 + r1;
            r1 = MEMORY.ref(1, r3).getUnsigned();
            r3 = r4;
            if(r4 < 0) {
              r3 = r4 + 0x7;
            }

            //LAB_80d7146
            r3 = r3 >> 3;
            r2 = r1;
            if(r1 < 0) {
              r2 = r1 + 0x7;
            }

            //LAB_80d7150
            r2 = r2 >> 3;
            r3 = r3 << 4;
            r3 = r3 + r2;
            r3 = r3 << 3;
            r3 = r3 + r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = r1 & 0x7;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            r0 = CPU.r12().value;
            MEMORY.ref(1, r3).setu(r0);
          }

          //LAB_80d7168
          r7++;
        } while(r7 != 0x4);

        r10++;
        r4++;
      } while(r10 != 0x20);

      CPU.lr().value = 0;
      r10 = 0;
      r4 = r6 + 0x1;

      //LAB_80d7184
      do {
        r7 = 0x0;
        CPU.r12().value = r4;

        //LAB_80d7188
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r0 = CPU.r12().value & 0x7;
            r3 = r0 << 5;
            r3 = r3 + r10;
            r1 = 0x2010000;
            r3 = r3 << 2;
            r3 = r3 + r7;
            r3 = r3 + r1;
            r1 = MEMORY.ref(1, r3).getUnsigned();
            r3 = CPU.r12().value;
            if(r3 < 0) {
              r3 = r3 + 0x7;
            }

            //LAB_80d71a8
            r3 = r3 >> 3;
            r2 = r1;
            if(r1 < 0) {
              r2 = r1 + 0x7;
            }

            //LAB_80d71b2
            r2 = r2 >> 3;
            r3 = r3 << 4;
            r3 = r3 + r2;
            r3 = r3 << 3;
            r3 = r3 + r0;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = r1 & 0x7;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            MEMORY.ref(1, r3).setu(CPU.lr().value);
          }

          //LAB_80d71ca
          r7 = r7 + 0x1;
        } while(r7 != 0x4);

        r4++;
        r10++;
      } while(r10 != 0x20);
    }

    //LAB_80d71dc
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xa1;
    if((r3 & 0xffff_ffffL) <= (0x3e & 0xffff_ffffL)) {
      r10 = 0;
      r3 = MEMORY.ref(4, r9 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d71f4
        do {
          if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() > 0xa0 + r10 * 0x8) {
            r2 = MEMORY.ref(4, r9 + 0x7828).get();
            final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r10 * 0x2).get()).actor_00.deref();
            actor.pos_08.y_04.add(0x80000);
            if(actor.pos_08.getY() > 0x800000) {
              actor.pos_08.setY(0x800000);
            }

            //LAB_80d7226
            r5 = 0x0;
            actor._48.set(0);

            //LAB_80d7250
            do {
              final Sprite38 sprite = getActorSprite_(actor, r5);
              if(sprite == null) {
                break;
              }

              //LAB_80d7248
              setSpriteAnimation_(sprite, 5);
              r5 = r5 + 0x1;
            } while(true);
          }

          //LAB_80d725c
          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r10++;
        } while(r10 != r3);
      }
    }

    //LAB_80d726c
    r3 = MEMORY.ref(4, r9 + 0x7828).get();
    r3 = MEMORY.ref(4, r3 + 0x14).get();
    r10 = 0;
    if(r3 != 0) {
      r6 = 0x24;
      r5 = 0x11e;

      //LAB_80d7284
      do {
        if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == r5) {
          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r3 + r6).get()).actor_00.deref();
          actor.pos_08.setY(0x600000);
          actor._48.set(0xab85);
        }

        //LAB_80d72a0
        if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == r5 + 0x10) {
          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          FUN_80d6888(MEMORY.ref(2, r3 + r6).get(), 7, -1, r10, 8);
          playSound_(0x86);
          MEMORY.ref(4, r9 + 0x77a8).setu(8);
        }

        //LAB_80d72cc
        r3 = MEMORY.ref(4, r9 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r6 = r6 + 0x2;
        r5 = r5 + 0x5;
        r10++;
      } while(r10 != r3);
    }

    //LAB_80d72e0
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0x12e) {
      //LAB_80d72ec
      freeSlot(47);
      freeSlot(46);
      FUN_80e0524(152, r9, 1, 0);
      FUN_80e0524(192, r9 + 0x1680, 1, 1);
      FUN_80ed408(46, 7, 7, 3, 2);
      r3 = boardWramMallocHead_3001e50.offset(46 * 0x4).get();
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
      FUN_80ed408(47, 7, 7, 7, 2);
      r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = boardWramMallocHead_3001e50.offset(47 * 0x4).get();
      MEMORY.ref(4, r4 + 0x4).setu(r3);
      GPU.BLDCNT.setu(0x3f46);
      GPU.BG2PA.setu(0x80);
      GPU.BG2X.setu(0);
      MEMORY.ref(4, r9 + 0x7780).setu(2);
      MEMORY.ref(4, r9 + 0x7784).setu(75);
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
      r3 = MEMORY.ref(4, r9 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r10 = 0;

      if(r3 != 0) {
        //LAB_80d73b0
        do {
          r2 = MEMORY.ref(4, r9 + 0x7828).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r10 * 0x2).get()).actor_00.deref();
          r6 = r9 + 0x7080 + r10 * 0x118;

          //LAB_80d73da
          for(r7 = 0; r7 < 10; r7++) {
            MEMORY.ref(4, r6).setu(actor.pos_08.getX());
            MEMORY.ref(4, r6 + 0x4).setu(0x140000);
            MEMORY.ref(4, r6 + 0x8).setu(actor.pos_08.getZ());
            MEMORY.ref(4, r6 + 0xc).setu(sin(r7 * 0x3334) * 4);
            MEMORY.ref(4, r6 + 0x10).setu((rand() & 0x7fff) + 0x10000);
            MEMORY.ref(4, r6 + 0x14).setu(cos(r7 * 0x3334) * 4);
            MEMORY.ref(4, r6 + 0x18).setu(0);
            r6 = r6 + 0x1c;
          }

          r10++;
          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
        } while(r10 != r3);
      }
    }

    //LAB_80d7430
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() > 0x12d) {
      //LAB_80d743a
      r10 = 0;
      r3 = MEMORY.ref(4, r9 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d744c
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(MEMORY.ref(4, CPU.sp().value + 0x3c).get() - 0x12e);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x12e);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
        final Vec3 sp0x4c = new Vec3();
        final Vec3 sp0x58 = new Vec3();

        //LAB_80d746a
        do {
          if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() >= MEMORY.ref(4, CPU.sp().value + 0x10).get() && MEMORY.ref(4, CPU.sp().value + 0x3c).get() < MEMORY.ref(4, CPU.sp().value + 0xc).get() + 0x13a) {
            r2 = MEMORY.ref(4, r9 + 0x7828).get();
            final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r10 * 0x2).get()).actor_00.deref();
            sp0x58.set(actor.pos_08.getX(), 0, actor.pos_08.getZ());
            FUN_80e3944(sp0x58, sp0x4c);
            sp0x4c.x_00.div(2);
            r5 = r9 + MEMORY.ref(4, CPU.sp().value + 0x14).get() / 2 * 0x1e0;
            MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x44).get(), MEMORY.ref(4, CPU.sp().value + 0x40).get(), r5, sp0x4c.getX() - 20, sp0x4c.getY() - 24, 20, 24);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            MEMORY.call(MEMORY.ref(4, r1 + 0x4).get(), MEMORY.ref(4, CPU.sp().value + 0x40).get(), r5, sp0x4c.getX(), sp0x4c.getY() - 24, 20, 24);
          }

          //LAB_80d74f8
          if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() >= MEMORY.ref(4, CPU.sp().value + 0x10).get() + 0x6) {
            r7 = 0x0;
            r5 = r9 + 0x7080 + (MEMORY.ref(4, CPU.sp().value + 0xc).get() + r10) * 0x38;

            //LAB_80d7520
            do {
              FUN_80e3944(MEMORY.ref(4, r5, Vec3::new), sp0x4c);
              sp0x4c.x_00.div(2);
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              if((r3 & 0xffff_ffffL) < 27) {
                r4 = MEMORY.ref(2, 0x80ee966 + 0xc).getUnsigned();
                r0 = r4 >>> 1;
                MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x44).get(), MEMORY.ref(4, CPU.sp().value + 0x40).get(), r9 + MEMORY.ref(2, 0x80ee958 + 0xc).getUnsigned(), sp0x4c.getX() - r0, sp0x4c.getY() - r0, r4, r4);
              }

              //LAB_80d7556
              FUN_80e3908(r5, 60, 0x1000);
              MEMORY.ref(4, r5 + 0x18).incr();
              r5 += 0x1c;
              r7++;
            } while(r7 != 0x5);
          }

          //LAB_80d7570
          MEMORY.ref(4, CPU.sp().value + 0x14).subu(0x4);
          MEMORY.ref(4, CPU.sp().value + 0x10).addu(0x4);
          MEMORY.ref(4, CPU.sp().value + 0xc).addu(0x4);
          r3 = MEMORY.ref(4, r9 + 0x7828).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r10++;
        } while(r10 != r3);
      }
    }

    //LAB_80d7594
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() <= 0x7f) {
      FUN_80e155c(4, 16);
      //LAB_80d75a4
    } else if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() <= 0x12d) {
      FUN_80e155c(2, 2);
    } else {
      //LAB_80d75b6
      FUN_80e155c(4, 8);
    }

    //LAB_80d75be
    FUN_80cd52c();
    MEMORY.ref(4, r9 + 0x7824).setu(1);
    sleep(1);
    MEMORY.ref(4, CPU.sp().value + 0x3c).incr();
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() != 0x16e) {
      FUN_80d6b76();
    }

    //LAB_80d75e2
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    FUN_80b50e8(0x86);
    FUN_80e6eac(2, 0x800000, MEMORY.ref(4, CPU.sp().value + 0x38).get());
    r10 = 0;
    r5 = r9 + 0x77d8;

    //LAB_80d760e
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      r10++;
    } while(r10 < 8);

    FUN_80cdbc0();
    CPU.sp().value += 0x64;
  }

  @Method(0x80d6b76)
  public static void FUN_80d6b76() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d765c)
  public static void FUN_80d765c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d9ac4)
  public static void FUN_80d9ac4(final int r0) {
    FUN_80d9ae8(r0, 1);
  }

  @Method(0x80d9ae8)
  public static void FUN_80d9ae8(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;

    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(r1);
    r1 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    MEMORY.ref(4, r1 + 0x7828).setu(r0);
    FUN_80cd594(0);
    GPU.BG2PA.setu(0x100);

    if(MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0) {
      FUN_80e0524(156, MEMORY.ref(4, CPU.sp().value + 0x30).get(), 1, 1);
    } else {
      //LAB_80d9b40
      FUN_80e0524(155, MEMORY.ref(4, CPU.sp().value + 0x30).get(), 1, 1);
    }

    //LAB_80d9b4c
    if(MEMORY.ref(4, CPU.sp().value + 0x34).get() != 0 && MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0x1) {
      r0 = 0xb7;
    } else {
      //LAB_80d9b5c
      r0 = 0xbb;
    }

    //LAB_80d9b5e
    MEMORY.memcpy(0x5000000, getPointerTableEntry(r0), 0x80);
    FUN_80e0524(157, MEMORY.ref(4, CPU.sp().value + 0x30).get() + 0x2580, 0, 0);
    r0 = 0x2b8;
    CPU.r9().value = 1;
    r4 = 0x39;

    //LAB_80d9b8e
    do {
      r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
      r1 = r3 + 0x2580;
      r3 = r0 + r3;
      CPU.r12().value = r4;
      r3 = r3 + 0x2580;

      //LAB_80d9ba0
      do {
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r1 = r1 + 0x1;
        if(r2 > CPU.r12().value) {
          r2 = CPU.r12().value;
        }

        //LAB_80d9baa
        if(r2 < 0) {
          r2 = 0x0;
        }

        //LAB_80d9bb0
        MEMORY.ref(1, r3).setu(r2);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
        r5 = r5 + 0x1;
        r3 = r3 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r5);
      } while(r5 != 0x2b8);

      CPU.r9().value++;
      r0 = r0 + 0x2b8;
      r4 = r4 - 0x7;
    } while(CPU.r9().value != 0x8);

    r5 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    r3 = r5 + 0x7828;
    r3 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    if(r3 == 0x1) {
      GPU.BG2X.setu(-0x7000);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(-112);
    } else {
      //LAB_80d9bec
      GPU.BG2X.setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(0);
    }

    //LAB_80d9bf4
    r5 = 0x2010000;
    CPU.r9().value = 0;
    r7 = 0xc0;

    //LAB_80d9bfc
    do {
      final int angle = rand() & 0xffff;
      MEMORY.ref(4, r5).setu(0);
      if(MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0) {
        MEMORY.ref(4, r5 + 0x4).setu((CPU.r9().value & 0x1f) / 4 * 0x60000 - 0xa0000);
        MEMORY.ref(4, r5 + 0x8).setu(CPU.r9().value % 4 * 0x20000 - 0x20000);
      } else {
        //LAB_80d9c42
        MEMORY.ref(4, r5 + 0x4).setu((CPU.r9().value & 0x1f) / 4 * 0x60000 - 0xa0000);
        MEMORY.ref(4, r5 + 0x8).setu(CPU.r9().value % 4 * 0x80000 - 0x100000);
      }

      //LAB_80d9c72
      r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
      r3 = MEMORY.ref(4, r2 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      if(r3 == 0x1) {
        r3 = 0x20000;
      } else {
        //LAB_80d9c88
        r3 = -0x20000;
      }

      //LAB_80d9c8a
      MEMORY.ref(4, r5 + 0xc).setu(r3);
      MEMORY.ref(4, r5 + 0x10).setu((r7 * cos(angle) >> 6) + 0x10000);
      MEMORY.ref(4, r5 + 0x14).setu(r7 * sin(angle) >> 6);
      MEMORY.ref(4, r5 + 0x18).setu(rand() & 0xff);
      r5 = r5 + 0x1c;
      CPU.r9().value++;
    } while(CPU.r9().value != 0x200);

    r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    r5 = r0 + 0x7828;
    r3 = MEMORY.ref(4, r5).get();
    r2 = CPU.sp().value + 0x38;
    r0 = MEMORY.ref(4, r3 + 0x4).get();
    r1 = r2;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r2);
    FUN_80cef64(r0, r1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    MEMORY.ref(4, r3 + 0x7780).setu(2);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    MEMORY.ref(4, r1 + 0x7784).setu(50);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
    r3 = MEMORY.ref(4, r5).get();
    r3 = MEMORY.ref(4, r3 + 0x14).get();
    r3 = r3 << 2;
    if(r3 != -64) {
      //LAB_80d9d10
      do {
        final Camera4c sp18 = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
        if(MEMORY.ref(4, CPU.sp().value + 0x28).get() == 0x48) {
          FUN_80b50e8(0);
        }

        //LAB_80d9d22
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r3 = MEMORY.ref(4, r5 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        if(r3 != 0) {
          //LAB_80d9d34
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(MEMORY.ref(4, CPU.sp().value + 0x28).get() - 24);
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
          CPU.r8().value = MEMORY.ref(4, CPU.sp().value + 0x28).get();

          //LAB_80d9d48
          do {
            r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r2 = MEMORY.ref(4, r0 + 0x7828).get();
            final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r1 * 0x2).get()).actor_00.deref();
            if(CPU.r8().value > 0) {
              //LAB_80d9d62
              initMatrixStack();
              FUN_80051d8(sp18._00, sp18._0c);
              final Vec3 sp0x40 = new Vec3();
              sp0x40.set(actor.pos_08.getX(), 0x140000, actor.pos_08.getZ());
              initMatrixStack();
              FUN_80051d8(sp18._00, sp18._0c);
              translateMatrix(sp0x40);
              final Vec3 sp0x58 = new Vec3();
              final Vec3 sp0x4c = new Vec3();
              sp0x58.zero();
              FUN_80e3944(sp0x58, sp0x4c);
              final int r6 = sp0x4c.getX() + MEMORY.ref(4, CPU.sp().value + 0x20).get();
              if(MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0) {
                if(CPU.r8().value <= 0x1a) {
                  MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x2c).get(), MEMORY.ref(4, CPU.sp().value + 0x30).get() + modS(CPU.r8().value / 4, 7) * 0x3c0, r6 - 12, sp0x4c.getY() - 20, 24, 40);
                }
              } else {
                //LAB_80d9e2c
                r3 = CPU.r8().value;
                if(r3 <= 0x17) {
                  r0 = CPU.r8().value;
                  if(r3 < 0) {
                    r0 = r0 + 0x3;
                  }

                  //LAB_80d9e3a
                  r1 = 0x6;
                  r0 = r0 >> 2;
                  r0 = modS(r0, r1);
                  r1 = r0 << 1;
                  r1 = r1 + r0;
                  r1 = r1 << 3;
                  r1 = r1 + r0;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                  r1 = r1 << 6;
                  r1 = r0 + r1;
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r4 = MEMORY.ref(4, r0 + 0x4).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
                  MEMORY.call(r4, r0, r1, r6 - 20, sp0x4c.getY() - 20, 40, 40);
                }
              }

              //LAB_80d9e68
              r1 = CPU.r8().value;
              if(r1 == 0x18) {
                r0 = 0x8f;
                playSound_(r0);
              }

              //LAB_80d9e74
              r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              if((r2 & 0xffff_ffffL) <= (0x24 & 0xffff_ffffL)) {
                r3 = CPU.r8().value;
                r1 = 0x0;
                if(r3 > 0x1c) {
                  r3 = r2;
                  if(r2 < 0) {
                    r3 = CPU.r8().value;
                    r3 = r3 - 0x15;
                  }

                  //LAB_80d9e8c
                  r1 = r3 >> 2;
                  if(r1 > 0x7) {
                    r1 = 0x7;
                  }
                }

                //LAB_80d9e94
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1 * 0x2b8);
                CPU.r9().value = 0;
                r7 = 0x2010000 + MEMORY.ref(4, CPU.sp().value + 0x8).get();

                //LAB_80d9eaa
                do {
                  r5 = CPU.r9().value % 4 * 3 + modS((MEMORY.ref(4, r7 + 0x18).get() + CPU.r8().value) / 8, 3);
                  FUN_80e3944(MEMORY.ref(4, r7, Vec3::new), sp0x4c);
                  MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x38).get(), MEMORY.ref(4, CPU.sp().value + 0x2c).get(), MEMORY.ref(4, CPU.sp().value + 0x30).get() + MEMORY.ref(4, CPU.sp().value + 0x10).get() + MEMORY.ref(2, 0x80eea08 + r5 * 0x2).getUnsigned() + 0x2580, sp0x4c.getX() + MEMORY.ref(4, CPU.sp().value + 0x20).get(), sp0x4c.getY(), MEMORY.ref(1, 0x80eea20 + r5).getUnsigned(), MEMORY.ref(1, 0x80eea2c + r5).getUnsigned());
                  FUN_80e38b8(r7, 60, 0);
                  r7 = r7 + 0x1c;
                  CPU.r9().value++;
                } while(CPU.r9().value != 0x18);
              }
            }

            //LAB_80d9f2c
            MEMORY.ref(4, CPU.sp().value + 0xc).subu(0x4);
            MEMORY.ref(4, CPU.sp().value + 0x8).addu(0x380);
            MEMORY.ref(4, CPU.sp().value + 0x24).incr();
            CPU.r8().value -= 4;
            r5 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
            r3 = MEMORY.ref(4, r5 + 0x7828).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r3 = MEMORY.ref(4, r3 + 0x14).get();
          } while(r0 != r3);
        }

        //LAB_80d9f58
        r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        MEMORY.ref(4, r1 + 0x7824).setu(1);
        sleep(1);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        r5 = r5 + 0x1;
        MEMORY.ref(4, CPU.sp().value + 0x28).setu(r5);
        r3 = MEMORY.ref(4, r1 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        r3 = r3 << 2;
        r3 = r3 + 0x40;
      } while(r5 != r3);
    }

    //LAB_80d9f82
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0x64;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
  }

  /**
   * Table 80ee2b4
   * Flare
   */
  @Method(0x80d9fc8)
  public static void FUN_80d9fc8(int r0) {
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
    CPU.r8().value = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    CPU.sp().value -= 0x14;
    r5 = CPU.r8().value + 0x7828;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    MEMORY.ref(4, r5).setu(r0);
    FUN_80cd594(0);
    GPU.BLDCNT.setu(0x3f46);
    GPU.BLDALPHA.setu(0x100e);
    r0 = 0xb4;
    r1 = CPU.r8().value;
    r2 = 0x1;
    r3 = 0x1;
    FUN_80e0524(r0, r1, r2, r3);
    r3 = 0x3;
    r2 = 0x7;
    r0 = 0x2e;
    r1 = 0x7;
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r6 = boardWramMallocHead_3001e50.offset(46 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r6);
    r3 = MEMORY.ref(4, r5).get();
    r2 = 0x24;
    r3 = MEMORY.ref(2, r3 + r2).get();
    if(r3 > 0x7f) {
      r3 = 0x0;
      r4 = 0x1;
      CPU.r11().value = r3;
      CPU.r10().value = r4;
    } else {
      //LAB_80da04a
      r1 = 0x1;
      r0 = 0x40;
      r1 = -r1;
      CPU.r11().value = r0;
      CPU.r10().value = r1;
    }

    //LAB_80da054
    r5 = 0xe1;
    r2 = 0x0;
    r5 = r5 << 7;
    r6 = 0xffffc000;
    CPU.r9().value = r2;
    r7 = 0x0;
    r5 = r5 + CPU.r8().value;

    //LAB_80da062
    do {
      r0 = r6;
      r0 = sin(r0);
      r0 = r0 << 5;
      r0 = r0 >> 16;
      r3 = CPU.r10().value;
      r3 = r3 * r0;
      r3 = r3 + CPU.r11().value;
      r3 = r3 + 0x14;
      MEMORY.ref(4, r5).setu(r3);
      r0 = r6;
      r0 = cos(r0);
      r0 = r0 << 4;
      r0 = r0 >> 16;
      r4 = 0x1;
      r0 = r0 + 0x28;
      r3 = 0x80;
      CPU.r9().value = CPU.r9().value + r4;
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      r3 = r3 << 5;
      r0 = CPU.r9().value;
      MEMORY.ref(4, r5 + 0x18).setu(r7);
      r6 = r6 + r3;
      r7 = r7 - 0x4;
      r5 = r5 + 0x1c;
    } while(r0 != 0x9);

    r2 = 0xef;
    r2 = r2 << 7;
    r3 = 0x2;
    r2 = r2 + CPU.r8().value;
    MEMORY.ref(4, r2).setu(r3);
    r3 = 0x7828;
    r3 = r3 + CPU.r8().value;
    r3 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x18).get();
    if(r3 == 0x2) {
      r2 = 0x7784;
      r3 = 0x4b;
    } else {
      //LAB_80da0b6
      r2 = 0x7784;
      r3 = 0x32;
    }

    //LAB_80da0ba
    r2 = r2 + CPU.r8().value;
    MEMORY.ref(4, r2).setu(r3);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r0 = 0x88;
    playSound_(r0);
    r1 = 0x0;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);

    //LAB_80da0d2
    do {
      r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      if(r2 == 0x18) {
        r0 = 0x85;
        FUN_80b50e8(r0);
      }

      //LAB_80da0de
      r6 = 0xe1;
      r3 = 0x0;
      r6 = r6 << 7;
      CPU.r9().value = r3;
      r6 = r6 + CPU.r8().value;

      //LAB_80da0e8
      do {
        r3 = MEMORY.ref(4, r6 + 0x18).get();
        if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
          r2 = r3;
          if(r3 < 0x0) {
            r2 = r3 + 0x3;
          }

          //LAB_80da0f6
          r5 = r2 >> 2;
          r0 = 0x80edeb2;
          r2 = 0x80ede9f;
          r4 = r5 << 1;
          r1 = MEMORY.ref(2, r0 + r4).getUnsigned();
          CPU.r10().value = r4;
          r4 = MEMORY.ref(1, r2 + r5).getUnsigned();
          r2 = MEMORY.ref(4, r6).get();
          r3 = r4 >>> 1;
          r2 = r2 - r3;
          r3 = 0x80edeab;
          r0 = MEMORY.ref(1, r3 + r5).getUnsigned();
          CPU.r11().value = r3;
          r3 = MEMORY.ref(4, r6 + 0x4).get();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r4 = 0x80edea5;
          r3 = r3 + r0;
          r7 = 0x7828;
          r0 = MEMORY.ref(1, r4 + r5).getUnsigned();
          r1 = r1 + CPU.r8().value;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r7 = r7 + CPU.r8().value;
          MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          r2 = MEMORY.ref(4, r7).get();
          r3 = MEMORY.ref(4, r2 + 0x18).get();
          if(r3 != 0x0) {
            r3 = 0x80ede9f;
            r0 = 0x80edeb2;
            r4 = MEMORY.ref(1, r3 + r5).getUnsigned();
            r2 = CPU.r10().value;
            r1 = MEMORY.ref(2, r0 + r2).getUnsigned();
            r2 = MEMORY.ref(4, r6).get();
            r3 = r4 >>> 1;
            r2 = r2 - r3;
            r3 = CPU.r11().value;
            r0 = MEMORY.ref(1, r3 + r5).getUnsigned();
            r3 = MEMORY.ref(4, r6 + 0x4).get();
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r4 = 0x80edea5;
            r3 = r3 + r0;
            r0 = MEMORY.ref(1, r4 + r5).getUnsigned();
            r1 = r1 + CPU.r8().value;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r3 = r3 - 0x10;
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r2 = MEMORY.ref(4, r7).get();
          }

          //LAB_80da160
          r3 = MEMORY.ref(4, r2 + 0x18).get();
          if(r3 == 0x2) {
            r3 = 0x80ede9f;
            r0 = 0x80edeb2;
            r4 = MEMORY.ref(1, r3 + r5).getUnsigned();
            r2 = CPU.r10().value;
            r1 = MEMORY.ref(2, r0 + r2).getUnsigned();
            r2 = MEMORY.ref(4, r6).get();
            r3 = r4 >>> 1;
            r2 = r2 - r3;
            r3 = CPU.r11().value;
            r0 = MEMORY.ref(1, r3 + r5).getUnsigned();
            r3 = MEMORY.ref(4, r6 + 0x4).get();
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r4 = 0x80edea5;
            r3 = r3 + r0;
            r0 = MEMORY.ref(1, r4 + r5).getUnsigned();
            r3 = r3 - 0x20;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            r1 = r1 + CPU.r8().value;
            r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }

          //LAB_80da192
          r3 = MEMORY.ref(4, r6 + 0x18).get();
        }

        //LAB_80da194
        r0 = 0x1;
        CPU.r9().value = CPU.r9().value + r0;
        r3 = r3 + 0x1;
        r1 = CPU.r9().value;
        MEMORY.ref(4, r6 + 0x18).setu(r3);
        r6 = r6 + 0x1c;
      } while(r1 != 0x9);

      r2 = 0x0;
      CPU.r9().value = r2;
      r2 = 0x7828;
      r4 = CPU.r8().value;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0x0) {
        r6 = 0x24;
        r5 = 0x10;

        //LAB_80da1b8
        do {
          r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          if(r0 == r5) {
            r1 = CPU.r8().value;
            r3 = MEMORY.ref(4, r1 + r2).get();
            r0 = MEMORY.ref(2, r3 + r6).get();
            r3 = 0xc;
            MEMORY.ref(4, CPU.sp().value).setu(r3);
            r1 = 0xa;
            r2 = 0x5;
            r3 = CPU.r9().value;
            FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          }

          //LAB_80da1d2
          r2 = 0x7828;
          r3 = 0x1;
          r4 = CPU.r8().value;
          CPU.r9().value = CPU.r9().value + r3;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r6 = r6 + 0x2;
          r5 = r5 + 0x8;
        } while(CPU.r9().value != r3);
      }

      //LAB_80da1e6
      FUN_80cd52c();
      r2 = 0x7824;
      r3 = 0x1;
      r2 = r2 + CPU.r8().value;
      r0 = 0x1;
      MEMORY.ref(4, r2).setu(r3);
      sleep(r0);
      r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r0 = r0 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    } while(r0 != 0x50);

    //LAB_80da204
    freeSlot(46);
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    FUN_80cdbc0();
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  /**
   * Table 80ee2b4
   * Mad blast
   */
  @Method(0x80db6d4)
  public static void FUN_80db6d4(final int r0) {
    FUN_80db6e0(r0, 0);
  }

  @Method(0x80db6e0)
  public static void FUN_80db6e0(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    final Vec3 sp0x2c = new Vec3();

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x38;
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
    CPU.r10().value = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    r5 = CPU.r10().value + 0x7828;
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    MEMORY.ref(4, r5).setu(r0);
    FUN_80cd594(1);
    r2 = 0x1;
    r0 = 0xc0;
    r1 = CPU.r10().value;
    r3 = 0x0;
    FUN_80e0524(r0, r1, r2, r3);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    if(r2 == 0x1) {
      r3 = 0x0;
      r0 = 0xa0;
      CPU.r8().value = r3;
      r0 = r0 << 19;

      //LAB_80db722
      do {
        r4 = CPU.r8().value;
        r3 = r4 >>> 31;
        r3 = r3 + CPU.r8().value;
        r3 = r3 >> 1;
        r1 = r3 << 5;
        r2 = r3 << 10;
        r2 = r2 | r1;
        r1 = 0x1;
        r2 = r2 | r3;
        CPU.r8().value = CPU.r8().value + r1;
        MEMORY.ref(2, r0).setu(r2);
        r2 = CPU.r8().value;
        r0 = r0 + 0x2;
      } while(r2 != 0x40);

      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
    } else {
      //LAB_80db744
      r0 = 0x96;
      r0 = getPointerTableEntry(r0);
      r1 = r0;
      r0 = 0xa0;
      r0 = r0 << 19;
      r2 = 0x80;
      MEMORY.memcpy(r0, r1, r2);
      r3 = MEMORY.ref(4, r5).get();
      r3 = MEMORY.ref(4, r3 + 0x18).get();
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r3);
    }

    //LAB_80db75e
    r5 = 0xe1;
    r3 = 0x0;
    r5 = r5 << 7;
    CPU.r8().value = r3;
    r7 = 0x0;
    r6 = 0x3f;
    r5 = r5 + CPU.r10().value;

    //LAB_80db76c
    do {
      r3 = 0x7828;
      r3 = r3 + CPU.r10().value;
      r3 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      if(r3 == 0x1) {
        r3 = 0xc8;
        r3 = r3 << 14;
      } else {
        //LAB_80db77e
        r3 = 0xffce0000;
      }

      //LAB_80db780
      MEMORY.ref(4, r5).setu(r3);
      MEMORY.ref(4, r5 + 0x4).setu(r7);
      MEMORY.ref(4, r5 + 0x8).setu(r7);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 - 0x20;
      r0 = r0 << 13;
      MEMORY.ref(4, r5 + 0xc).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 + 0x10;
      r0 = r0 << 12;
      MEMORY.ref(4, r5 + 0x10).setu(r0);
      r0 = rand();
      r0 = r0 & r6;
      r0 = r0 - 0x20;
      r4 = 0x1;
      r0 = r0 << 13;
      CPU.r8().value = CPU.r8().value + r4;
      MEMORY.ref(4, r5 + 0x14).setu(r0);
      r0 = CPU.r8().value;
      MEMORY.ref(4, r5 + 0x18).setu(r7);
      r5 = r5 + 0x1c;
    } while(r0 != 0x20);

    r1 = 0x0;
    r5 = 0x2010000;
    CPU.r8().value = r1;
    r6 = 0x0;
    r7 = 0x3f;

    //LAB_80db7c2
    do {
      r3 = 0x7828;
      r3 = r3 + CPU.r10().value;
      r3 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4).get();
      if(r3 == 0x1) {
        r3 = 0xc8;
        r3 = r3 << 14;
      } else {
        //LAB_80db7d4
        r3 = 0xffce0000;
      }

      //LAB_80db7d6
      MEMORY.ref(4, r5).setu(r3);
      MEMORY.ref(4, r5 + 0x4).setu(r6);
      MEMORY.ref(4, r5 + 0x8).setu(r6);
      r0 = rand();
      r0 = r0 & r7;
      r0 = r0 - 0x20;
      r0 = r0 << 13;
      MEMORY.ref(4, r5 + 0xc).setu(r0);
      r0 = rand();
      r3 = 0x1f;
      r3 = r3 & r0;
      r3 = r3 + 0x8;
      r3 = r3 << 13;
      MEMORY.ref(4, r5 + 0x10).setu(r3);
      r0 = rand();
      r0 = r0 & r7;
      r0 = r0 - 0x20;
      r2 = 0x1;
      r3 = 0x80;
      r0 = r0 << 13;
      CPU.r8().value = CPU.r8().value + r2;
      r3 = r3 << 3;
      MEMORY.ref(4, r5 + 0x14).setu(r0);
      MEMORY.ref(4, r5 + 0x18).setu(r6);
      r5 = r5 + 0x1c;
    } while(CPU.r8().value != r3);

    r5 = 0x2;
    r1 = 0x7;
    r2 = 0x7;
    r3 = 0x3;
    r0 = 0x2e;
    MEMORY.ref(4, CPU.sp().value).setu(r5);
    r0 = FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
    r3 = 0x3001e50;
    r3 = r3 + 0xb8;
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
    r3 = 0xef;
    r3 = r3 << 7;
    r2 = 0x7784;
    r3 = r3 + CPU.r10().value;
    MEMORY.ref(4, r3).setu(r5);
    r2 = r2 + CPU.r10().value;
    r3 = 0x4b;
    r1 = 0x90;
    MEMORY.ref(4, r2).setu(r3);
    r1 = r1 << 3;
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r1 = r1 << 1;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    r2 = r1 + r3;
    r0 = 0x80eeae2;
    r1 = r2 + 0x2;
    r3 = MEMORY.ref(1, r0 + r1).getUnsigned();
    r4 = 0x0;
    CPU.r9().value = r4;
    if(r3 != 0x0) {
      //LAB_80db85e
      r4 = r2;
      r4 = r4 + 0x1;
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
      CPU.r11().value = r0;

      //LAB_80db86a
      do {
        final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
        initMatrixStack();
        FUN_80051d8(camera._00, camera._0c);
        r0 = CPU.r9().value;
        if(r0 == 0x2) {
          r0 = 0x90;
          playSound_(r0);
        }

        //LAB_80db888
        r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r6 = 0x80eeae2;
        r5 = r1 + r2;
        r3 = r5 + 0x2;
        r3 = MEMORY.ref(1, r6 + r3).getUnsigned();
        r3 = r3 - 0x30;
        if(CPU.r9().value == r3) {
          r0 = 0x85;
          FUN_80b50e8(r0);
        }

        //LAB_80db8a0
        r3 = 0x0;
        CPU.r8().value = r3;
        r3 = MEMORY.ref(1, r6 + r5).getUnsigned();
        if(r3 != 0x0) {
          r6 = 0x2010000;

          //LAB_80db8ac
          do {
            r3 = MEMORY.ref(4, r6 + 0x4).get();
            if(r3 >= 0x0) {
              FUN_80e3944(MEMORY.ref(4, r6, Vec3::new), sp0x2c);
              r2 = sp0x2c.getX();
              r3 = 0x7828;
              r2 = r2 >> 1;
              r3 = r3 + CPU.r10().value;
              sp0x2c.setX(r2);
              r3 = MEMORY.ref(4, r3).get();
              r3 = MEMORY.ref(4, r3 + 0x4).get();
              r3 = r3 << 5;
              r2 = r2 + r3;
              r2 = r2 - 0x10;
              sp0x2c.setX(r2);
              r2 = sp0x2c.getZ();
              if(r2 <= 0x9f) {
                r3 = 0xa0;
                sp0x2c.setZ(r3);
                r2 = 0xa0;
              }

              //LAB_80db8de
              r3 = 0x31f;
              if(r2 > r3) {
                sp0x2c.setZ(r3);
                r2 = r3;
              }

              //LAB_80db8e8
              r3 = r2;
              r3 = r3 - 0xa0;
              if(r3 < 0x0) {
                r3 = r3 + 0x3f;
              }

              //LAB_80db8f2
              r3 = r3 >> 6;
              r0 = 0x9;
              r0 = r0 - r3;
              r4 = r0 << 1;
              r2 = 0x80ede48;
              r3 = r4 - 0x2;
              r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r3 = CPU.r8().value;
              r2 = 0x1;
              r2 = r2 & r3;
              r3 = r2 << 1;
              r3 = r3 + r2;
              r3 = r3 << 7;
              r3 = r3 + r2;
              r3 = r3 << 1;
              r1 = r1 + r3;
              r2 = 0xc8;
              r2 = r2 << 6;
              r3 = r0 >>> 31;
              r1 = r1 + CPU.r10().value;
              r1 = r1 + r2;
              r3 = r0 + r3;
              r2 = sp0x2c.getX();
              r3 = r3 >> 1;
              r2 = r2 - r3;
              r3 = sp0x2c.getY();
              MEMORY.ref(4, CPU.sp().value).setu(r0);
              r3 = r3 - r0;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r0 = r6;
              r1 = 0x40;
              r2 = 0xffffe000;
              FUN_80e38b8(r0, r1, r2);
            }

            //LAB_80db93e
            r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r1 = CPU.r11().value;
            r0 = 0x1;
            r3 = MEMORY.ref(1, r1 + r2).getUnsigned();
            CPU.r8().value = CPU.r8().value + r0;
            r6 = r6 + 0x1c;
          } while(CPU.r8().value != r3);
        }

        //LAB_80db94e
        r3 = CPU.r9().value;
        if(r3 > 0x2) {
          r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = CPU.r11().value;
          r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
          r4 = 0x0;
          CPU.r8().value = r4;
          if(r3 != 0x0) {
            r6 = 0xe1;
            r6 = r6 << 7;
            r6 = r6 + CPU.r10().value;

            //LAB_80db968
            do {
              if(CPU.r8().value < CPU.r9().value) {
                r3 = MEMORY.ref(4, r6 + 0x4).get();
                if(r3 >= 0x0) {
                  FUN_80e3944(MEMORY.ref(4, r6, Vec3::new), sp0x2c);
                  r2 = sp0x2c.getX();
                  r3 = 0x7828;
                  r2 = r2 >> 1;
                  r3 = r3 + CPU.r10().value;
                  sp0x2c.setX(r2);
                  r3 = MEMORY.ref(4, r3).get();
                  r3 = MEMORY.ref(4, r3 + 0x4).get();
                  r3 = r3 << 5;
                  r2 = r2 + r3;
                  r7 = r2;
                  r7 = r7 - 0x10;
                  sp0x2c.setX(r7);
                  r0 = MEMORY.ref(4, r6 + 0x18).get();
                  if((r0 & 0xffff_ffffL) <= (0x14 & 0xffff_ffffL)) {
                    r1 = 0x3;
                    r0 = divideS(r0, r1);
                    r3 = 0x80eeaec;
                    r0 = r0 << 1;
                    r1 = MEMORY.ref(2, r3 + r0).getUnsigned();
                    r3 = 0x80eeafa;
                    r4 = MEMORY.ref(2, r3 + r0).getUnsigned();
                    r3 = sp0x2c.getY();
                    r0 = r4 >>> 1;
                    r2 = r7 - r0;
                    r3 = r3 - r0;
                    MEMORY.ref(4, CPU.sp().value).setu(r4);
                    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                    r1 = r1 + CPU.r10().value;
                    r0 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                    MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
                    r0 = MEMORY.ref(4, r6 + 0x18).get();
                  }

                  //LAB_80db9c2
                  if(r0 <= 0x14) {
                    r3 = r0 + 0x1;
                    MEMORY.ref(4, r6 + 0x18).setu(r3);
                  }

                  //LAB_80db9ca
                  r2 = 0xffffe000;
                  r0 = r6;
                  r1 = 0x40;
                  FUN_80e38b8(r0, r1, r2);
                  r2 = 0x80eeae2;
                }
              }

              //LAB_80db9d6
              r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
              r0 = 0x1;
              r3 = MEMORY.ref(1, r2 + r1).getUnsigned();
              CPU.r8().value = CPU.r8().value + r0;
              r6 = r6 + 0x1c;
            } while(CPU.r8().value != r3);
          }
        }

        //LAB_80db9e4
        r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        if(r2 == 0x0) {
          r2 = 0x7828;
          r3 = 0x0;
          r2 = r2 + CPU.r10().value;
          CPU.r8().value = r3;
          r3 = MEMORY.ref(4, r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          if(r3 != 0x0) {
            r5 = r2;
            r6 = 0x24;

            //LAB_80db9fe
            do {
              r3 = CPU.r8().value;
              r3 = r3 + 0x6;
              if(CPU.r9().value == r3) {
                r3 = MEMORY.ref(4, r5).get();
                r0 = MEMORY.ref(2, r3 + r6).get();
                r3 = 0xa;
                r1 = 0x7;
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r2 = 0x5;
                r3 = CPU.r8().value;
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
                r3 = MEMORY.ref(4, r5).get();
                r0 = MEMORY.ref(2, r3 + r6).get();
                r1 = 0x2;
                FUN_80b5088(r0, r1);
              }

              //LAB_80dba22
              r3 = MEMORY.ref(4, r5).get();
              r2 = 0x1;
              r3 = MEMORY.ref(4, r3 + 0x14).get();
              CPU.r8().value = CPU.r8().value + r2;
              r6 = r6 + 0x2;
            } while(CPU.r8().value != r3);
          }
        } else {
          //LAB_80dba78
          r2 = 0x7828;
          r3 = 0x0;
          r4 = CPU.r10().value;
          CPU.r8().value = r3;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          if(r3 != 0x0) {
            r5 = 0x24;

            //LAB_80dba8a
            do {
              r3 = CPU.r8().value;
              r3 = r3 + 0x6;
              if(CPU.r9().value == r3) {
                r0 = CPU.r10().value;
                r3 = MEMORY.ref(4, r0 + r2).get();
                r0 = MEMORY.ref(2, r3 + r5).get();
                r3 = 0xa;
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r1 = 0x7;
                r2 = 0x5;
                r3 = CPU.r8().value;
                FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
              }

              //LAB_80dbaa6
              r2 = 0x1;
              CPU.r8().value = CPU.r8().value + r2;
              r2 = 0x7828;
              r4 = CPU.r10().value;
              r3 = MEMORY.ref(4, r4 + r2).get();
              r3 = MEMORY.ref(4, r3 + 0x14).get();
              r5 = r5 + 0x2;
            } while(CPU.r8().value != r3);
          }
        }

        //LAB_80dbab8
        r0 = CPU.r9().value;
        if(r0 == 0x2) {
          r2 = 0x77a8;
          r3 = 0x6;
          r2 = r2 + CPU.r10().value;
          MEMORY.ref(4, r2).setu(r3);
        }

        //LAB_80dbac6
        r1 = 0x10;
        r0 = 0x10;
        FUN_80e155c(r0, r1);
        FUN_80cd52c();
        r3 = 0x7824;
        r2 = 0x1;
        r3 = r3 + CPU.r10().value;
        MEMORY.ref(4, r3).setu(r2);
        r0 = 0x1;
        sleep(r0);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
        r2 = CPU.r11().value;
        r1 = 0x1;
        r3 = MEMORY.ref(1, r2 + r4).getUnsigned();
        CPU.r9().value = CPU.r9().value + r1;
      } while(CPU.r9().value != r3);
    }

    //LAB_80dbaf0
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0x38;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  /**
   * Sprites are stored in struct 39 array at 0x77d8. Each sprite
   * will have its animation set to its index.
   *
   * @param count number of sprites to load
   * @param spriteDataIndex which sprite to load into each
   * @param priority sprite priority
   */
  @Method(0x80dbb24)
  public static void FUN_80dbb24(final int count, final int spriteDataIndex, final int priority) {
    final int r7 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();

    //LAB_80dbb50
    for(int r6 = 0; r6 < count; r6++) {
      final Sprite38 sprite = loadSprite_(spriteDataIndex);
      MEMORY.ref(4, r7 + 0x77d8 + r6 * 0x4).setu(sprite != null ? sprite.getAddress() : 0);
      if(sprite != null) {
        sprite._26.set(0);
        setSpriteAnimation_(sprite, r6);
        sprite.packet_00.attribs_04.attrib2_04.and(~0xc00).or((priority & 0x3) << 10);
      }

      //LAB_80dbb78
    }

    //LAB_80dbb80
  }

  @Method(0x80dbb9c)
  public static void FUN_80dbb9c() {
    DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff);
    DMA.channels[0].CNT.offset(2, 0x2).and(0x7fff);
    DMA.channels[0].SAD.setu(boardWramMallocHead_3001e50.offset(39 * 0x4).get() + 0x6980);
    DMA.channels[0].DAD.setu(GPU.BG2X.getAddress());
    DMA.channels[0].CNT.setu(0xa6600001);
  }

  @Method(0x80dc968)
  public static void FUN_80dc968(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80de2f8)
  public static void FUN_80de2f8(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r10;

    CPU.sp().value -= 0x6c;
    r6 = r2;
    MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r3);
    r5 = r1;
    r1 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(boardWramMallocHead_3001e50.offset(40 * 0x4).get());
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(boardWramMallocHead_3001e50.offset(41 * 0x4).get());
    MEMORY.ref(4, r1 + 0x7828).setu(r0);
    FUN_80cd594(0);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    MEMORY.ref(4, r3 + 0x77b4).setu(24);
    MEMORY.ref(4, r3 + 0x77b8).setu(0);
    if(r5 > 0x3) {
      r5 = r5 - 0x4;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(84);
    } else {
      //LAB_80de34a
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(64);
    }

    //LAB_80de34e
    if(r5 == 0x0) {
      //LAB_80de362
      r0 = 0x94;
    } else if(r5 == 0x1) {
      //LAB_80de366
      r0 = 0x92;
    } else if(r5 == 0x2) {
      //LAB_80de36a
      r0 = 0x8e;
    } else {
      //LAB_80de36e
      r0 = 0x90;
    }

    //LAB_80de370
    r5 = getPointerTableEntry(r0);
    MEMORY.memcpy(0x5000000, r5, 0x80);
    decompress(r5 + 0x80, MEMORY.ref(4, CPU.sp().value + 0x28).get());
    FUN_80e0524(115, MEMORY.ref(4, CPU.sp().value + 0x18).get(), 0, 0);

    if(r6 == 0x1) {
      FUN_80ed408(46, 7, 7, 7, 3);
      FUN_80ed408(47, 7, 7, 7, 2);
    } else {
      //LAB_80de3c0
      FUN_80ed408(46, 7, 7, 3, 3);
      FUN_80ed408(47, 7, 7, 3, 2);
    }

    //LAB_80de3de
    r4 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(boardWramMallocHead_3001e50.offset(46 * 0x4).get());
    r3 = MEMORY.ref(4, r4 + 0x7828).get();
    final Actor70 r9 = getCombatantForUnit_(MEMORY.ref(4, r3 + 0x8).get()).actor_00.deref();
    final Actor70 sp10 = getCombatantForUnit_(MEMORY.ref(2, r3 + 0x24).get()).actor_00.deref();
    r7 = 0x2010000;
    r8 = 0;

    //LAB_80de416
    do {
      r6 = rand() & 0xffff;
      r5 = (rand() & 0xff) + 0x80;
      MEMORY.ref(4, r7).setu(0);
      MEMORY.ref(4, r7 + 0x8).setu(0);
      MEMORY.ref(4, r7 + 0x4).setu((rand() & 0x1f) + 20 << 16);
      MEMORY.ref(4, r7 + 0xc).setu((r5 + 0x80) * sin(r6) >> 5);
      MEMORY.ref(4, r7 + 0x10).setu(0);
      MEMORY.ref(4, r7 + 0x14).setu(r5 * cos(r6) >> 5);
      MEMORY.ref(4, r7 + 0x18).setu(0);
      r7 = r7 + 0x1c;
      r8++;
    } while(r8 != 0x40);

    r7 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
    MEMORY.ref(4, r7 + 0x7780).setu(2);
    MEMORY.ref(4, r7 + 0x7784).setu(75);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    final Vec3 sp0x60 = new Vec3();
    sp0x60.setX(r9.pos_08.getX());
    sp0x60.setY(0);
    sp0x60.setZ(r9.pos_08.getZ());
    r1 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();

    r5 = CPU.sp().value + 0x54;

    switch(r1) {
      case 0: // switch 80de4b0
        //LAB_80de4c4
        MEMORY.ref(4, r5).setu(sp10.pos_08.getX());
        MEMORY.ref(4, r5 + 0x4).setu(0x3c0000);
        MEMORY.ref(4, r5 + 0x8).setu(sp10.pos_08.getZ());
        break;

      case 1: // switch 80de4b0
        //LAB_80de4d8
        MEMORY.ref(4, r5).setu(sp10.pos_08.getX());
        MEMORY.ref(4, r5 + 0x4).setu(0x3c0000);
        MEMORY.ref(4, r5 + 0x8).setu(0);
        break;

      case 2: // switch 80de4b0
        //LAB_80de4de
        MEMORY.ref(4, r5).setu(r9.pos_08.getX());
        MEMORY.ref(4, r5 + 0x4).setu(0x3c0000);
        MEMORY.ref(4, r5 + 0x8).setu(r9.pos_08.getZ());
        break;

      case 3: // switch 80de4b0
        //LAB_80de4f2
        MEMORY.ref(4, r5).setu(r9.pos_08.getX());
        MEMORY.ref(4, r5 + 0x4).setu(0x3c0000);
        MEMORY.ref(4, r5 + 0x8).setu(0);
        break;

      case 4: // switch 80de4b0
        //LAB_80de506
        MEMORY.ref(4, r5).setu(0);
        MEMORY.ref(4, r5 + 0x4).setu(0x3c0000);
        MEMORY.ref(4, r5 + 0x8).setu(0);
        break;
    }

    //LAB_80de55a
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(CPU.sp().value + 0x48);
    r0 = divideS(MEMORY.ref(4, r5).get() - sp0x60.getX(), 40);
    r7 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    MEMORY.ref(4, r7).setu(r0);
    MEMORY.ref(4, r7 + 0x4).setu(divideS(MEMORY.ref(4, r5 + 0x4).get() - sp0x60.getY(), 40));
    MEMORY.ref(4, r7 + 0x8).setu(divideS(MEMORY.ref(4, r5 + 0x8).get() - sp0x60.getZ(), 40));
    r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r10 = 0;
    if(r4 != 0) {
      //LAB_80de59e
      do {
        final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
        if(r10 > 0x4b) {
          GPU.BLDALPHA.setu(0xa8 - r10 * 0x2 | 0x1000);
        }

        //LAB_80de5b6
        if(r10 == 0x8) {
          playSound_(0xd4);
        }

        //LAB_80de5d4
        initMatrixStack();
        FUN_80051d8(camera._00, camera._0c);
        r3 = r10 - 0x6;
        if((r3 & 0xffff_ffffL) < 40) {
          r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          sp0x60.x_00.add(MEMORY.ref(4, r4).get());
          sp0x60.y_04.add(MEMORY.ref(4, r4 + 0x4).get());
          sp0x60.z_08.add(MEMORY.ref(4, r4 + 0x8).get());
        }

        //LAB_80de608
        translateMatrix(sp0x60);

        if(r10 == 0) {
          r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r3 = MEMORY.ref(4, r2 + 0x7828).get();
          FUN_80d6888(MEMORY.ref(4, r3 + 0x8).get(), 7, -1, -1, 0);
        }

        //LAB_80de62e
        if(r10 == 0x18) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r3 = MEMORY.ref(4, r1 + 0x7828).get();
          FUN_80d6888(MEMORY.ref(4, r3 + 0x8).get(), 0, -1, -1, 0);
        }

        //LAB_80de64e
        r4 = -r10;
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
        r7 = r4 << 8;
        r8 = 0;
        int r9_0 = r10 << 8;
        r6 = 0x2010000;

        //LAB_80de662
        do {
          if(r10 >= r8 / 8) {
            //LAB_80de672
            if(MEMORY.ref(4, r6 + 0x18).get() == 0) {
              //LAB_80de67a
              pushMatrix();

              r3 = r8 & 0x3;
              if(r3 == 0) {
                //LAB_80de69c
                rotateMatrixY(r9_0);
              } else if(r3 == 0x1) {
                //LAB_80de6a4
                rotateMatrixX(r7);
              } else if(r3 == 0x2) {
                //LAB_80de6ac
                rotateMatrixZ(r7);
              } else if(r3 == 0x3) {
                //LAB_80de6b4
                rotateMatrixX(r7);
                rotateMatrixZ(r7);
              }

              //LAB_80de6c0
              final Vec3 sp0x30 = new Vec3();
              FUN_80e3944(MEMORY.ref(4, r6, Vec3::new), sp0x30);
              sp0x30.x_00.div(2);
              popMatrix();

              if(sp0x30.getZ() < 250) {
                sp0x30.setZ(250);
              }

              //LAB_80de6e0
              if(sp0x30.getZ() > 634) {
                sp0x30.setZ(634);
              }

              //LAB_80de6ea
              r0 = 8 - (sp0x30.getZ() - 250) / 64;
              r4 = r0 * 2;
              MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x20).get(), MEMORY.ref(4, CPU.sp().value + 0x24).get(), MEMORY.ref(4, CPU.sp().value + 0x18).get() + MEMORY.ref(2, 0x80ede48 + r4 - 2).getUnsigned(), sp0x30.getX() - r0 / 2, sp0x30.getY() - r0, r0, r4);
              FUN_80e38b8(r6, 60, 0);

              if(r10 >= r8 / 8 + 24) {
                r5 = -MEMORY.ref(4, r6).get() >> 7;
                r4 = -MEMORY.ref(4, r6 + 0x8).get() >> 7;
                r2 = MEMORY.ref(4, r6 + 0x10).get() + (-MEMORY.ref(4, r6 + 0x4).get() >> 7);
                r1 = MEMORY.ref(4, r6 + 0xc).get() + r5;
                r0 = MEMORY.ref(4, r6 + 0x14).get() + r4;
                MEMORY.ref(4, r6 + 0xc).setu(r1 * 62 / 64);
                MEMORY.ref(4, r6 + 0x10).setu(r2 * 62 / 64);
                MEMORY.ref(4, r6 + 0x14).setu(r0 * 62 / 64);
                r3 = r5 + 0x7ff;
                if((r3 & 0xffff_ffffL) < 0xfff) {
                  r3 = r4 + 0x7ff;
                  if((r3 & 0xffff_ffffL) < 0xfff) {
                    MEMORY.ref(4, r6 + 0x18).setu(-1);
                  }
                }
              }
            }
          }

          //LAB_80de7a4
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r1 = r10;
          r7 = r7 + r4 * 32;
          r9_0 = r9_0 + r1 * 32;
          r6 = r6 + 0x1c;
          r8++;
        } while(r8 != 0x20);

        //LAB_80de7be
        r3 = r10 - 0x36;
        if((r3 & 0xffff_ffffL) <= (0xf & 0xffff_ffffL)) {
          final Vec3 sp0x30 = new Vec3();
          final Vec3 sp0x3c = new Vec3();
          sp0x3c.set(sin(r1 << 10) << 2, 0, 0);
          FUN_80e3944(sp0x3c, sp0x30);
          MEMORY.ref(4, a4).setu(sp0x30.getX());
          MEMORY.ref(4, a5).setu(sp0x30.getY());
          sp0x30.x_00.div(2);
          MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x1c).get(), MEMORY.ref(4, CPU.sp().value + 0x24).get(), MEMORY.ref(4, CPU.sp().value + 0x28).get(), sp0x30.getX() - 10, sp0x30.getY() - 20, 20, 40);
        }

        //LAB_80de80c
        if(r10 == 0x40) {
          r2 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r8 = 0;
          r7 = r2 + 0x7080;

          //LAB_80de81e
          do {
            r6 = rand() & 0xffff;
            r5 = (rand() & 0xff) + 0x80;
            MEMORY.ref(4, r7).setu(MEMORY.ref(4, a4).get() << 15);
            MEMORY.ref(4, r7 + 0x4).setu(MEMORY.ref(4, a5).get() << 16);
            MEMORY.ref(4, r7 + 0xc).setu(r5 * sin(r6) >> 6);
            MEMORY.ref(4, r7 + 0x10).setu(r5 * cos(r6) >> 5);
            MEMORY.ref(4, r7 + 0x18).setu((rand() & 0xf) + 0x8);
            r8++;
            r7 = r7 + 0x1c;
          } while(r8 != 0x40);
        }

        //LAB_80de876
        if(r10 > 0x3f) {
          r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
          r6 = 0x80ede48;
          r8 = 0;
          r5 = r1 + 0x7080;

          //LAB_80de88a
          do {
            r0 = MEMORY.ref(4, r5 + 0x18).get();
            if(r0 >= 0) {
              r0 = r0 >> 3;
              r0 = r0 + 0x2;
              r4 = r0 << 1;
              r3 = r4 - 0x2;
              r1 = MEMORY.ref(2, r6 + r3).getUnsigned();
              r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r1 = r3 + r1;
              r2 = MEMORY.ref(2, r5 + 0x2).get();
              r3 = r0 / 2;
              r2 = r2 - r3;
              r3 = MEMORY.ref(2, r5 + 0x6).get();
              r3 = r3 - r0;
              MEMORY.call(MEMORY.ref(4, CPU.sp().value + 0x1c).get(), MEMORY.ref(4, CPU.sp().value + 0x24).get(), r1, r2, r3, r0, r4);
              FUN_80e3908(r5, 60, 0);
              MEMORY.ref(4, r5 + 0x18).decr();
            }

            //LAB_80de8cc
            r5 = r5 + 0x1c;
            r8++;
          } while(r8 != 0x40);
        }

        //LAB_80de8d8
        r3 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
        MEMORY.ref(4, r3 + 0x7824).setu(1);
        sleep(1);
        r10++;
      } while(r10 != MEMORY.ref(4, CPU.sp().value + 0x14).get());
    }

    //LAB_80de8f4
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(47);
    freeSlot(46);
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd4b4"));
    MEMORY.memfill(0x6004000, 0x4000, 0);
    MEMORY.memfill(MEMORY.ref(4, CPU.sp().value + 0x24).get(), 0x4000, 0);
    GPU.BLDALPHA.setu(0x1010);
    CPU.sp().value += 0x6c;
  }

  @Method(0x80dea70)
  public static void FUN_80dea70(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;
    final int r8;
    int r9;
    int r10;

    CPU.sp().value -= 0x9c;
    r5 = r0;
    final int sp84 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    final Camera4c sp6c = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    r8 = r1;
    final int sp68 = boardWramMallocHead_3001e50.offset(41 * 0x4).get();
    int sp64 = 0;
    final int r11 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    MEMORY.ref(4, r11 + 0x7828).setu(r5);
    int sp5c = MEMORY.ref(4, r5 + 0x18).get();

    if(r8 == 0xa) {
      FUN_80cd594(0);
    } else {
      //LAB_80deab8
      FUN_80cd594(1);
    }

    //LAB_80deabe
    r2 = MEMORY.ref(4, r11 + 0x7828).get();
    if(MEMORY.ref(4, r2 + 0x1c).get() == 0x1) {
      FUN_80de2f8(r5, 1, MEMORY.ref(4, r2 + 0x4).get(), 2, CPU.sp().value + 0x8c, CPU.sp().value + 0x88);
    }

    //LAB_80deae0
    if(r8 == 0x5) {
      if(MEMORY.ref(4, r2 + 0x4).get() == 0x1) {
        FUN_80ed408(46, 7, 7, 7, 2);
      } else {
        //LAB_80deaf0
        FUN_80ed408(46, 7, 7, 3, 2);
      }
    } else {
      //LAB_80deb02
      if(MEMORY.ref(4, r2 + 0x4).get() == 0x1) {
        FUN_80ed408(46, 7, 7, 7, 3);
      } else {
        //LAB_80deb1a
        FUN_80ed408(46, 7, 7, 3, 3);
      }
    }

    //LAB_80deb28
    final int sp70 = MEMORY.ref(4, 0x3001f08).get();
    FUN_80e0524(115, sp68, 0, 0);

    if(r8 == 0 || r8 == 0x5 || r8 == 0x8) {
      //LAB_80deb4a
      if(r8 == 0x5) {
        //LAB_80deb50
        sp5c = 2;
      }

      //LAB_80deb54
      if(r8 == 0x8) {
        sp5c = 0;
      }

      //LAB_80deb5e
      if(sp5c == 0) {
        FUN_80e0524(127, r11 + 0x1000, 1, 1);
        //LAB_80deb6c
      } else if(sp5c == 0x1) {
        FUN_80e0524(128, r11 + 0x1000, 1, 1);
      } else {
        //LAB_80deb84
        FUN_80e0524(129, r11 + 0x1000, 1, 1);
      }

      //LAB_80deb94
      if(r8 == 0x5) {
        MEMORY.memcpy(0x5000000, getPointerTableEntry(185), 0x80);
      }

      //LAB_80debae
      FUN_80e0524(199, r11 + 0x2000, 1, 0);

      if(r8 == 0x5) {
        MEMORY.memcpy(0x5000000, getPointerTableEntry(185), 0x80);
      }

      //LAB_80debd8
      MEMORY.ref(4, r11 + 0x7780).setu(2);
      MEMORY.ref(4, r11 + 0x7784).setu(75);
      //LAB_80debe8
    } else if(r8 == 0x1) {
      FUN_80e0524(93, r11, 1, 1);
      GPU.BLDCNT.setu(0);
      MEMORY.ref(4, r11 + 0x7780).setu(r8);
      MEMORY.ref(4, r11 + 0x7784).setu(0);
      //LAB_80dec4c
    } else if(r8 == 0x2) {
      MEMORY.memcpy(0x5000000, getPointerTableEntry(127), 0x80);
      FUN_80e0524(92, r11, 0, 0);
      MEMORY.ref(4, r11 + 0x7780).setu(r8);
      MEMORY.ref(4, r11 + 0x7784).setu(50);
      //LAB_80dec84
    } else {
      if(r8 >= 3 && r8 < 5 || r8 == 0xb) {
        //LAB_80dec92
        FUN_80e0524(91, r11, 1, 1);
        //LAB_80dec9c
      } else if(r8 == 0x6) {
        FUN_80e0524(104, r11, 1, 1);
      } else {
        //LAB_80decac
        FUN_80e0524(184, r11, 1, 1);
        FUN_80e0524(146, r11 + 0x65c0, 1, 0);
      }

      //LAB_80decc2
      MEMORY.ref(4, r11 + 0x7780).setu(2);
      MEMORY.ref(4, r11 + 0x7784).setu(50);
    }

    //LAB_80decd6
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), 0x480);
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final Actor70 r6 = getCombatantForUnit_(MEMORY.ref(4, r3 + 0x8).get()).actor_00.deref();
    r1 = 0x80eebec;
    r3 = r8 * 0x5;
    final int sp58 = MEMORY.ref(1, r1 + r3).getUnsigned();
    r10 = MEMORY.ref(1, r1 + r3 + 0x1).getUnsigned();
    final int sp50 = MEMORY.ref(1, r1 + r3 + 0x2).getUnsigned();
    final int sp4c = MEMORY.ref(1, r1 + r3 + 0x3).getUnsigned();
    r3 = MEMORY.ref(4, r11 + 0x7828).get();
    final int sp48 = FUN_80b5070(MEMORY.ref(4, r3 + 0x8).get());
    r5 = MEMORY.ref(4, r11 + 0x7828).get();
    if(MEMORY.ref(4, r5 + 0x14).get() * sp58 > 0x3f) {
      MEMORY.ref(4, r5 + 0x14).setu(1);
    }

    //LAB_80ded2c
    int sp80 = 0;
    if(MEMORY.ref(4, r5 + 0x14).get() != 0) {
      //LAB_80ded38
      int sp18 = 0;
      int sp14 = 0x24;

      //LAB_80ded46
      do {
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        final Actor70 r7_0 = getCombatantForUnit_(MEMORY.ref(2, r3 + sp14).get()).actor_00.deref();
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        final int sp40 = FUN_80b5070(MEMORY.ref(2, r3 + sp14).get());
        int sp7c = 0;
        if(sp58 != 0) {
          //LAB_80ded6e
          r9 = sp48 / 2;
          r5 = r11 + 0x7080 + sp18 * 0x1c;

          //LAB_80ded88
          do {
            MEMORY.ref(4, r5).setu(r6.pos_08.getX());
            if(r8 == 0x7) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + ((rand() & 0xf) << 16) + 0x3a0000);
              //LAB_80deda8
            } else if(r8 == 0xa) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9);
              //LAB_80dedb4
            } else if(r8 == 0x6) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9);
              //LAB_80dedc0
            } else if(r8 == 0x9) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9 + (0x10 - (rand() & 0x1f) << 16));
              //LAB_80dedd4
            } else if(r8 >= 3 && r8 < 5) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9 + (0x10 - (rand() & 0x1f) << 16));
              //LAB_80dedea
            } else if(r8 == 0xb) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9 + (0x20 - (rand() & 0x3f) << 16));
              //LAB_80dee08
            } else if(r8 == 0x5) {
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + r9);
            } else {
              //LAB_80dee14
              MEMORY.ref(4, r5 + 0x4).setu(r6.pos_08.getY() + sp48);
            }

            //LAB_80dee1c
            MEMORY.ref(4, r5 + 0x8).setu(r6.pos_08.getZ());
            MEMORY.ref(4, r5 + 0xc).setu(divideS(r7_0.pos_08.getX() - MEMORY.ref(4, r5).get(), r10));

            if(r8 == 0x7) {
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + ((rand() & 0x3f) << 16) - MEMORY.ref(4, r5 + 0x4).get() - 0xc0000, r10));
              //LAB_80dee4e
            } else if(r8 == 0x8) {
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + ((rand() & 0x7) << 16) - MEMORY.ref(4, r5 + 0x4).get() + 0x160000, r10));
              //LAB_80dee70
            } else if(r8 == 0x9) {
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + (0x40 - (rand() & 0x3f) << 16) - MEMORY.ref(4, r5 + 0x4).get(), r10));
              //LAB_80dee8a
            } else if(r8 == 0xa) {
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + ((rand() & 0x1f) << 16) - MEMORY.ref(4, r5 + 0x4).get() + 0x40000, r10));
              //LAB_80deeac
            } else if(r8 >= 3 && r8 < 5 || r8 == 0xb || r8 == 0x5) {
              //LAB_80deebe
              MEMORY.ref(4, r5 + 0x10).setu(0);
              //LAB_80deec4
            } else if(r8 == 0x6) {
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + sp40 / 2 + ((rand() & 0xf) << 16) - MEMORY.ref(4, r5 + 0x4).get(), r10));
            } else {
              //LAB_80deee6
              MEMORY.ref(4, r5 + 0x10).setu(divideS(r7_0.pos_08.getY() + sp40 - ((rand() & 0xf) << 16) - MEMORY.ref(4, r5 + 0x4).get(), r10));
            }

            //LAB_80def06
            MEMORY.ref(4, r5 + 0x14).setu(divideS(r7_0.pos_08.getZ() - MEMORY.ref(4, r5 + 0x8).get(), r10));
            MEMORY.ref(4, r5 + 0x18).setu(0);
            r5 = r5 + 0x1c;
            sp7c++;
          } while(sp7c != sp58);
        }

        //LAB_80def28
        sp14 += 0x2;
        sp18 += sp58;
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        sp80++;
      } while(sp80 != r3);
    }

    //LAB_80def48
    sp80 = 0;
    r3 = 0x2010018;

    //LAB_80def54
    do {
      MEMORY.ref(4, r3).setu(0);
      r3 = r3 + 0x1c;
      sp80++;
    } while(sp80 != 0x400);

    if(r8 == 0x6) {
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get() * sp4c + sp50 * sp58 + 0x20;
    } else {
      //LAB_80defbc
      r3 = MEMORY.ref(4, r11 + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get() * sp4c + sp50 * sp58 + 0x10;
    }

    //LAB_80defd4
    final int sp60 = r3;
    int sp78 = 0;

    if(sp60 != 0) {
      //LAB_80defe4
      //LAB_80defea
      do {
        if(sp64 > 0) {
          sp64--;
        }

        //LAB_80deff4
        if(r8 == 0x6) {
          if(sp78 == 0x4) {
            playSound_(0x88);
          }

          //LAB_80df006
          if(sp78 == 0x20) {
            FUN_80b50e8(0x86);
          }
          //LAB_80df014
        } else if(r8 == 0x7) {
          if(sp78 == 0x30) {
            FUN_80b50e8(0x85);
          }
          //LAB_80df028
        } else if(r8 != 0x5) {
          if(sp78 == 0x10) {
            FUN_80b50e8(0x85);
          }
        }

        //LAB_80df03a
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x1c).get();
        if(r3 == 0x1) {
          r5 = sp78 << 11;
          r10 = (-sin(r5) << 2 >> 16) + MEMORY.ref(4, CPU.sp().value + 0x8c).get() / 2 - 10;
          int r6_0 = (cos(r5) << 1 >> 16) + MEMORY.ref(4, CPU.sp().value + 0x88).get() - 24;

          if(sp78 > 0x45) {
            r6_0 = r6_0 - sp78 * 0x2 + 0x8a;
          }

          //LAB_80df084
          r3 = MEMORY.ref(4, r11 + 0x7828).get();
          if(MEMORY.ref(4, r3 + 0x4).get() == 0x1) {
            FUN_80ed408(47, 7, 7, 7, 3);
          } else {
            //LAB_80df09e
            FUN_80ed408(47, 7, 7, 3, 3);
          }

          //LAB_80df0ac
          r5 = MEMORY.ref(4, 0x3001f0c).get();
          if(sp78 <= 0x3) {
            MEMORY.call(r5, sp84, r11 + 0x65c0, r10, r6_0, 20, 40);
          }

          //LAB_80df0d0
          MEMORY.call(r5, sp84, r11 + 0x65c0, r10, r6_0, 20, 40);
          freeSlot(47);
        }

        //LAB_80df0ec
        initMatrixStack();
        FUN_80051d8(sp6c._00, sp6c._0c);
        int sp3c = 0;
        sp80 = 0;
        r3 = MEMORY.ref(4, r11 + 0x7828).get();
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        if(r3 != 0) {
          //LAB_80df10c
          int sp20 = 0x24;
          int sp1c = 0;

          //LAB_80df112
          do {
            r3 = MEMORY.ref(4, r11 + 0x7828).get();
            final Actor70 sp38 = getCombatantForUnit_(MEMORY.ref(2, r3 + sp20).get()).actor_00.deref();
            int sp7c = 0;

            if(sp58 != 0) {
              //LAB_80df12e
              int sp28 = 0x2010000 + sp3c * 0x1c;
              int sp24 = 0;

              //LAB_80df142
              do {
                if(sp24 + sp1c < sp78) {
                  //LAB_80df150
                  r2 = sp58 * sp80 + sp7c;
                  final int r6_0 = r11 + 0x7080 + r2 * 0x1c;
                  final Vec3 sp0x90 = new Vec3();
                  FUN_80e3944(MEMORY.ref(4, r6_0, Vec3::new), sp0x90);
                  sp0x90.x_00.div(2);
                  MEMORY.ref(4, r6_0).addu(MEMORY.ref(4, r6_0 + 0xc).get());
                  MEMORY.ref(4, r6_0 + 0x4).addu(MEMORY.ref(4, r6_0 + 0x10).get());
                  MEMORY.ref(4, r6_0 + 0x8).addu(MEMORY.ref(4, r6_0 + 0x14).get());
                  if(r8 == 0x6) {
                    r5 = 0x2013800;
                    r2 = 0x0;
                    r1 = 0x200;

                    //LAB_80df1a4
                    do {
                      if(MEMORY.ref(4, r5 + 0x18).get() == 0) {
                        MEMORY.ref(4, r5).setu(sp0x90.getX() << 16);
                        MEMORY.ref(4, r5 + 0x4).setu(sp0x90.getY() << 16);
                        MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) - 0x80 << 11);
                        MEMORY.ref(4, r5 + 0x10).setu((rand() & 0xff) - 0x80 << 11);
                        MEMORY.ref(4, r5 + 0x18).setu((rand() & 0x7) + 0x20);
                        r2++;
                        if(r2 == 0x2) {
                          break;
                        }
                      }

                      //LAB_80df1f2
                      r1 = r1 + 0x1;
                      r5 = r5 + 0x1c;
                    } while(r1 != 0x400);
                  }

                  //LAB_80df1fe
                  if(MEMORY.ref(4, r6_0 + 0x18).get() == 0) {
                    //LAB_80df206
                    r1 = sp38.pos_08.getX();
                    r2 = MEMORY.ref(4, r6_0).get();

                    //LAB_80df218
                    if(r1 < 0 && r2 >>> 31 != 0 || r1 >= 0 && ~r2 >>> 31 != 0) {
                      //LAB_80df222
                      r3 = r2;
                      if(r3 < 0) {
                        r3 = -r3;
                      }

                      //LAB_80df22a
                      r2 = r1;
                      if(r2 < 0) {
                        r2 = -r2;
                      }

                      //LAB_80df232
                      if(r3 >= r2) {
                        //LAB_80df238
                        int sp34 = 0;
                        MEMORY.ref(4, r6_0 + 0x18).setu(1);

                        if(r8 == 0x5) {
                          FUN_80b50e8(0x86);
                          //LAB_80df252
                        } else if(r8 != 0x6 && sp64 == 0) {
                          sp64 = 8;
                          playSound_(0x84);
                        }

                        //LAB_80df26c
                        if(r8 == 0x2) {
                          r5 = (rand() & 0x1f) + 0x20 << 12;
                          if((rand() & 0x1) != 0) {
                            r3 = MEMORY.ref(4, r6_0 + 0x10).get() + r5;
                          } else {
                            //LAB_80df294
                            r3 = MEMORY.ref(4, r6_0 + 0x10).get() - r5;
                          }

                          //LAB_80df298
                          MEMORY.ref(4, r6_0 + 0x10).setu(r3);
                          MEMORY.ref(4, r6_0 + 0xc).neg();
                        }

                        //LAB_80df2a0
                        MEMORY.ref(4, sp28 + 0x18).setu(1);
                        MEMORY.ref(4, sp28).setu(sp0x90.getX());
                        MEMORY.ref(4, sp28 + 0x4).setu(sp0x90.getY());
                        MEMORY.ref(4, sp28 + 0x8).setu(0);

                        if(r8 != 0x7) {
                          MEMORY.ref(4, r11 + 0x77a8).setu(2);
                        }

                        //LAB_80df2be
                        r3 = MEMORY.ref(4, r11 + 0x7828).get();
                        FUN_80d6888(MEMORY.ref(2, r3 + sp20).get(), 7, 5, sp80, 8);

                        if(r8 != 0x7 && r8 != 0x9 && r8 != 0xa) {
                          if(r8 == 0x5) {
                            FUN_80b5088(MEMORY.ref(2, r3 + sp20).get(), 4);
                          } else {
                            //LAB_80df310
                            FUN_80b5088(MEMORY.ref(2, r3 + sp20).get(), 5);
                          }
                        }

                        //LAB_80df31c
                        r2 = 0x5 ^ r8;
                        r2 = 0xc - ((-r2 | r2) >>> 31);
                        r5 = 0x2010af0;
                        r1 = 0x64;
                        r10 = r8 * 0x5 + 0x4;

                        //LAB_80df33e
                        do {
                          if(MEMORY.ref(4, r5 + 0x18).get() == 0) {
                            MEMORY.ref(4, r5).setu(sp0x90.getX() << 16);
                            MEMORY.ref(4, r5 + 0x4).setu(sp0x90.getY() << 16);
                            MEMORY.ref(4, r5 + 0xc).setu((rand() & 0xff) - 0x80 << r2);
                            MEMORY.ref(4, r5 + 0x10).setu((rand() & 0xff) - 0x80 << r2);
                            MEMORY.ref(4, r5 + 0x18).setu((rand() & 0x7) + 0x10);
                            sp34++;
                            if(sp34 == MEMORY.ref(1, 0x80eebec + r10).getUnsigned()) {
                              break;
                            }
                          }

                          //LAB_80df39c
                          r1 = r1 + 0x1;
                          r5 = r5 + 0x1c;
                        } while(r1 != 0x200);
                      }
                    }
                  }

                  //LAB_80df3a8
                  if(r8 == 0 || r8 == 0x5 || r8 == 0x8) {
                    //LAB_80df3b6
                    r3 = MEMORY.ref(4, r11 + 0x7828).get();
                    if(MEMORY.ref(4, r3 + 0x4).get() == 0x1) {
                      FUN_80ed408(47, 7, 7, 7, 2);
                    } else {
                      //LAB_80df3d4
                      FUN_80ed408(47, 7, 7, 3, 2);
                    }

                    //LAB_80df3e4
                    r0 = MEMORY.ref(1, 0x80eebe9 + sp5c).getUnsigned();
                    MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, r11 + 0x1000, sp0x90.getX() - 0x10, sp0x90.getY() - r0, 32, r0);
                    freeSlot(47);
                    r3 = MEMORY.ref(4, r11 + 0x7828).get();
                    if(MEMORY.ref(4, r3 + 0x4).get() == 0x1) {
                      FUN_80ed408(47, 7, 7, 15, 2);
                    } else {
                      //LAB_80df42c
                      FUN_80ed408(47, 7, 7, 11, 2);
                    }

                    //LAB_80df43c
                    MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, r11 + 0x1000, sp0x90.getX() - 0x10, sp0x90.getY(), 32, MEMORY.ref(1, 0x80eebe9 + sp5c).getUnsigned());
                    freeSlot(47);
                    //LAB_80df466
                  } else if(r8 == 0x1) {
                    r0 = MEMORY.ref(4, r6_0).get();
                    if(r0 < 0) {
                      r0 = -r0;
                    }

                    //LAB_80df474
                    r1 = sp38.pos_08.getX();
                    if(r1 < 0) {
                      r1 = -r1;
                    }

                    //LAB_80df47e
                    if(r0 <= r1) {
                      MEMORY.call(sp70, sp84, modS(sp78, 6) * 0x300 + r11, sp0x90.getX() - 0x10, sp0x90.getY() - 0xc, 32, 24);
                    }
                    //LAB_80df4a6
                  } else if(r8 == 0x7 || r8 == 0x9 || r8 == 0xa) {
                    //LAB_80df4b4
                    MEMORY.call(sp70, sp84, MEMORY.ref(2, 0x80eec52 + (sp7c & 0x3) * 0x2).getUnsigned() + r11, sp0x90.getX() - 0x4, sp0x90.getY() - 0x4, 8, 8);
                    //LAB_80df4d4
                  } else if(r8 == 0x2) {
                    MEMORY.call(sp70, sp84, modS(sp7c, 6) * 0x80 + r11, sp0x90.getX() - 0x4, sp0x90.getY() - 0x8, 8, 16);
                    //LAB_80df4fc
                  } else if(r8 == 0x3) {
                    MEMORY.call(sp70, sp84, r11 + 0x60, sp0x90.getX() - 0x9, sp0x90.getY() - 0x7, 18, 13);
                    //LAB_80df51a
                  } else if(r8 == 0x4) {
                    MEMORY.call(sp70, sp84, r11, sp0x90.getX() - 0x6, sp0x90.getY() - 0x4, 12, 8);
                    //LAB_80df53c
                  } else if(r8 == 0xb) {
                    MEMORY.call(sp70, sp84, r11 + 0x14a, sp0x90.getX() - 0xf, sp0x90.getY() - 0xc, 29, 23);
                  } else {
                    //LAB_80df562
                    MEMORY.call(sp70, sp84, r11, sp0x90.getX() - 0x14, sp0x90.getY() - 0x20, 40, 64);
                  }
                }

                //LAB_80df57c
                sp24 += sp50;
                sp28 += 0x1c;
                sp3c++;
                sp7c++;
              } while(sp7c != sp58);
            }

            //LAB_80df59e
            sp20 += 0x2;
            sp1c += sp4c;
            r3 = MEMORY.ref(4, r11 + 0x7828).get();
            r3 = MEMORY.ref(4, r3 + 0x14).get();
            sp80++;
          } while(sp80 != r3);
        }

        //LAB_80df5c0
        if(r8 == 0 || r8 == 0x5 || r8 == 0x8) {
          //LAB_80df5d0
          sp80 = 0;
          r3 = MEMORY.ref(4, r11 + 0x7828).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get() * sp58;
          if(r3 != 0) {
            //LAB_80df5e6
            r7 = 0x2010000;
            r9 = 0x80eec44;
            r10 = 0x80eec28;

            //LAB_80df5f0
            do {
              if(MEMORY.ref(4, r7 + 0x18).get() == 0x1) {
                //LAB_80df5f8
                final int r6_0 = MEMORY.ref(4, r7 + 0x8).get() / 2;
                if((sp80 & 0x1) == 0) {
                  FUN_80ed408(47, 7, 7, 3, 2);
                  r1 = MEMORY.ref(2, r9 + r6_0 * 0x2).getUnsigned();
                  r4 = MEMORY.ref(1, r10 + r6_0).getUnsigned();
                  MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, r1 + r11, MEMORY.ref(4, r7).get() - r4, MEMORY.ref(4, r7 + 0x4).get() - MEMORY.ref(1, 0x80eec3d + r6_0).getUnsigned(), r4, MEMORY.ref(1, 0x80eec2f + r6_0).getUnsigned());
                  freeSlot(47);
                  FUN_80ed408(47, 7, 7, 15, 2);
                  MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, MEMORY.ref(2, r9 + r6_0 * 0x2).getUnsigned() + r11, MEMORY.ref(4, r7).get(), MEMORY.ref(4, r7 + 0x4).get() + MEMORY.ref(1, 0x80eec36 + r6_0).getUnsigned() - MEMORY.ref(1, 0x80eec3d + r6_0).getUnsigned(), MEMORY.ref(1, r10 + r6_0).getUnsigned(), MEMORY.ref(1, 0x80eec2f + r6_0).getUnsigned());
                  freeSlot(47);
                } else {
                  //LAB_80df6bc
                  FUN_80ed408(47, 7, 7, 3, 2);
                  r1 = MEMORY.ref(2, r9 + r6_0 * 0x2).getUnsigned() + r11 + 0x128a;
                  r2 = MEMORY.ref(4, r7).get() - MEMORY.ref(1, 0x80eec3d + r6_0).getUnsigned();
                  r4 = MEMORY.ref(1, r10 + r6_0).getUnsigned();
                  MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, r1, r2, MEMORY.ref(4, r7 + 0x4).get() - r4, MEMORY.ref(1, 0x80eec2f + r6_0).getUnsigned(), r4);
                  freeSlot(47);
                  FUN_80ed408(47, 7, 7, 15, 2);
                  MEMORY.call(boardWramMallocHead_3001e50.offset(47 * 0x4).get(), sp84, MEMORY.ref(2, r9 + r6_0 * 0x2).getUnsigned() + r11 + 0x128a, MEMORY.ref(4, r7).get() + MEMORY.ref(1, 0x80eec36 + r6_0).getUnsigned() - MEMORY.ref(1, 0x80eec3d + r6_0).getUnsigned(), MEMORY.ref(4, r7 + 0x4).get(), MEMORY.ref(1, 0x80eec2f + r6_0).getUnsigned(), MEMORY.ref(1, r10 + r6_0).getUnsigned());
                  freeSlot(47);
                }

                //LAB_80df74a
                MEMORY.ref(4, r7 + 0x8).incr();
                if(MEMORY.ref(4, r7 + 0x8).get() == 0xc) {
                  MEMORY.ref(4, r7 + 0x18).setu(0);
                }
              }

              //LAB_80df758
              sp80++;
              r3 = MEMORY.ref(4, r11 + 0x7828).get();
              r3 = MEMORY.ref(4, r3 + 0x14).get() * sp58;
              r7 = r7 + 0x1c;
            } while(sp80 != r3);
          }
        }

        //LAB_80df772
        sp80 = 100;
        r5 = 0x2010af0;

        //LAB_80df778
        do {
          r0 = MEMORY.ref(4, r5 + 0x18).get();
          if(r0 > 0) {
            r0 = r0 >> 3;
            r0 = r0 + 0x1;
            r4 = r0 << 1;
            r2 = 0x80ede48;
            r3 = r4 - 0x2;
            r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
            r1 = sp68 + r1;
            r2 = MEMORY.ref(2, r5 + 0x2).get();
            r3 = r0 / 2;
            r2 = r2 - r3;
            MEMORY.call(sp70, sp84, r1, r2, MEMORY.ref(2, r5 + 0x6).get() - r0, r0, r4);
            FUN_80e3908(r5, 60, 0x1000);

            if(MEMORY.ref(4, r5 + 0x4).get() > 0x700000) {
              r3 = MEMORY.ref(4, r5 + 0x10).get();
              r3 = -r3;
              r2 = r3 >>> 31;
              r3 = r3 + r2;
              r3 = r3 >> 1;
              MEMORY.ref(4, r5 + 0x10).setu(r3);
            }

            //LAB_80df7ce
            MEMORY.ref(4, r5 + 0x18).decr();
          }

          //LAB_80df7d4
          r5 = r5 + 0x1c;
          sp80++;
        } while(sp80 != 0x200);

        r5 = 0x2013800;

        //LAB_80df7e8
        do {
          r0 = MEMORY.ref(4, r5 + 0x18).get();
          if(r0 > 0) {
            r0 = r0 >> 4;
            r0 = r0 + 0x1;
            r4 = r0 << 1;
            r3 = r4 - 0x2;
            r1 = MEMORY.ref(2, 0x80ede48 + r3).getUnsigned();
            r1 = sp68 + r1;
            r3 = r0 / 2;
            MEMORY.call(sp70, sp84, r1, MEMORY.ref(2, r5 + 0x2).get() - r3, MEMORY.ref(2, r5 + 0x6).get() - r0, r0, r4);
            FUN_80e3908(r5, 60, ~0x4000);
            MEMORY.ref(4, r5 + 0x18).decr();
          }

          //LAB_80df82a
          r5 = r5 + 0x1c;
          sp80++;
        } while(sp80 != 0x400);

        FUN_80e155c(4, 4);
        FUN_80cd52c();
        MEMORY.ref(4, r11 + 0x7824).setu(1);
        sleep(1);
        sp78++;
      } while(sp78 != sp60);
    }

    //LAB_80df864
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    freeSlot(46);
    FUN_80cdbc0();
    CPU.sp().value += 0x9c;
  }

  @Method(0x80df9d0)
  public static void FUN_80df9d0(final int r0, final int r1, final int r2) {
    //LAB_80df9e6
    for(int r7 = 0; r7 < 0x120; r7++) {
      //LAB_80df9f2
      for(int i = 0; i < 40; i++) {
        MEMORY.ref(1, r1 + r2 * r7 / 2 + i / 2).setu(MEMORY.ref(1, r0 + r2 * r7 + i).getUnsigned());
      }
    }
  }
}
