package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.battle.Camera4c;
import org.goldensun.memory.Method;
import org.goldensun.types.Actor70;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;

import static org.goldensun.GoldenSun.initMatrixStack;
import static org.goldensun.GoldenSun.FUN_80051d8;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.loadSprite_;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setSpriteAnimation_;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_80b.loadUnitSprites_;
import static org.goldensun.GoldenSun_80b.loadBattleBackground_;
import static org.goldensun.GoldenSun_80b.FUN_80b5088;
import static org.goldensun.GoldenSun_80b.getCombatantForUnit_;
import static org.goldensun.GoldenSun_80b.getActorSprite_;
import static org.goldensun.GoldenSun_80b.FUN_80b50e8;
import static org.goldensun.GoldenSun_80b.FUN_80b5100;
import static org.goldensun.GoldenSun_80c.FUN_80cd52c;
import static org.goldensun.GoldenSun_80c.FUN_80cd594;
import static org.goldensun.GoldenSun_80c.FUN_80cdbc0;
import static org.goldensun.GoldenSun_80c.FUN_80cef64;
import static org.goldensun.GoldenSun_80e.FUN_80e0524;
import static org.goldensun.GoldenSun_80e.FUN_80e155c;
import static org.goldensun.GoldenSun_80e.FUN_80e15e8;
import static org.goldensun.GoldenSun_80e.FUN_80e3908;
import static org.goldensun.GoldenSun_80e.FUN_80e3944;
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

  @Method(0x80d6578)
  public static void FUN_80d6578(int r0) {
    int r1;
    final int r3;
    final int r5;

    r5 = r0;
    r1 = 0x302;
    r0 = 0x29;
    mallocSlotChip(r0, r1);
    r1 = 0x782c;
    r0 = 0x27;
    mallocSlotChip(r0, r1);
    r1 = 0x80;
    r1 = r1 << 7;
    r0 = 0x28;
    mallocSlotChip(r0, r1);
    r3 = MEMORY.ref(4, r5).get();

    switch(r3) {
      case 1:
        //LAB_80d65dc
        r0 = r5;
        FUN_80e823c(r0);
        break;

      case 2:
        //LAB_80d65e4
        r0 = r5;
        FUN_80d2d98(r0);
        break;

      case 3:
        //LAB_80d65ec
        r0 = r5;
        FUN_80eb754(r0);
        break;

      case 4:
        //LAB_80d65f4
        r0 = r5;
        FUN_80dc968(r0);
        break;

      case 5:
        //LAB_80d65fc
        r0 = r5;
        FUN_80d6970(r0);
        break;

      case 6:
        //LAB_80d6604
        r0 = r5;
        FUN_80ec100(r0);
        break;

      case 7:
        //LAB_80d660c
        r0 = r5;
        FUN_80d2458(r0);
        break;

      case 8:
        //LAB_80d6614
        r0 = r5;
        FUN_80d1714(r0);
        break;

      case 9:
        //LAB_80d661c
        r0 = r5;
        FUN_80ea0d8(r0);
        break;

      case 10:
        //LAB_80d6624
        r0 = r5;
        FUN_80d765c(r0);
        break;

      case 0:
      case 11:
        //LAB_80d662c
        r0 = r5;
        FUN_80e7320(r0);
        break;

      case 12:
        //LAB_80d6634
        r0 = r5;
        FUN_80e15e8(r0);
        break;
    }

    //LAB_80d663a
    r0 = 0x28;
    freeSlot(r0);
    r0 = 0x27;
    freeSlot(r0);
    r0 = 0x29;
    freeSlot(r0);
  }

  @Method(0x80d6750)
  public static void FUN_80d6750(final int r0) {
    final int r3 = MEMORY.ref(2, r0 + 0x24).get();
    final int[] ids = new int[15];
    int count = 0;

    if(r3 > 0x7f) {
      //LAB_80d676a
      for(int r6 = 0; r6 < 6; r6++) {
        if(getCharOrMonsterData_(r6 + 0x80).hp_38.get() > 0) {
          ids[count] = r6 + 0x80;
          count++;
        }

        //LAB_80d6786
      }
    } else {
      //LAB_80d678e
      //LAB_80d679a
      for(int r6 = 0; r6 < 8; r6++) {
        if(getCharOrMonsterData_(r6).hp_38.get() > 0) {
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
    final int r6 = MEMORY.ref(4, 0x3001ef0).get();
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
  public static void FUN_80d6888(final int r0, final int r1, int r2, int r3, final int a4) {
    final int r11 = r3;
    final int sp0c = r2;
    final BattleStruct82c.Combatant2c r8 = getCombatantForUnit_(r0);
    r3 = 0x3001eec;
    r3 = MEMORY.ref(4, r3).get();
    final int sp08 = r3;
    int sp04 = 0;

    //LAB_80d6936
    Sprite38 r7;
    while((r7 = getActorSprite_(r8.actor_00.deref(), sp04)) != null) {
      //LAB_80d68b2
      if(r11 != -1) {
        MEMORY.ref(1, sp08 + r11 + 0x7818).setu(a4);
      }

      //LAB_80d68c6
      if(r8._2a.get() == 0) {
        if(r1 != -1) {
          //LAB_80d68e6
          for(r2 = 0; r2 < r7.layerCount_27.get(); r2++) {
            final SpriteLayer18 r5 = r7.layers_28.get(r2).derefNullable();
            if(r5 != null && r5.getAddress() != r8.spriteLayer_24.getPointer() && r5.getAddress() != r8.spriteLayer_20.getPointer()) {
              if(r1 == 0) {
                r5._05.set(FUN_80b5100(r0));
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
        if(sp0c != -1) {
          setSpriteAnimation_(r7, sp0c);
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

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r1 = boardWramMallocHead_3001e50.offset(39 * 0x4).get();
    r3 = boardWramMallocHead_3001e50.offset(40 * 0x4).get();
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x40).setu(r3);
    CPU.r9().value = r1;
    MEMORY.ref(4, CPU.r9().value + 0x7828).setu(r0);
    FUN_80dbb24(8, 375, 1);
    CPU.r10().value = 0;
    r2 = 0x2010000;

    //LAB_80d69a6
    do {
      MEMORY.ref(1, r2).setu(CPU.r10().value & 0x7f);
      r2++;
      CPU.r10().value++;
    } while(CPU.r10().value != 0x400);

    CPU.r10().value = 0;
    CPU.r11().value = 0;

    //LAB_80d69c0
    do {
      //LAB_80d69c4
      for(r7 = 0; r7 < 0x80; r7++) {
        r0 = 0x2010000 + CPU.r11().value + (rand() & 0x7f);
        r5 = 0x2010000 + CPU.r11().value + (rand() & 0x7f);
        MEMORY.ref(1, r0).setu(MEMORY.ref(1, r5).getUnsigned());
        MEMORY.ref(1, r5).setu(MEMORY.ref(1, r0).getUnsigned());
      }

      CPU.r11().value += 0x80;
      CPU.r10().value++;
    } while(CPU.r10().value != 0x8);

    FUN_80cd594(0);
    GPU.BG2PA.setu(0x100);
    GPU.BLDCNT.setu(0);
    FUN_80e0524(178, CPU.r9().value, 1, 1);
    FUN_80ed408(46, 7, 7, 3, 1);
    r3 = boardWramMallocHead_3001e50.offset(46 * 0x4).get();
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
    FUN_80ed408(47, 7, 7, 7, 1);
    r2 = CPU.sp().value + 0x44;
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
    MEMORY.ref(4, r2 + 0x4).setu(boardWramMallocHead_3001e50.offset(47 * 0x4).get());
    MEMORY.ref(4, CPU.r9().value + 0x7780).setu(1);
    MEMORY.ref(4, CPU.r9().value + 0x7784).setu(0);
    setTickCallback(getRunnable(GoldenSun_80c.class, "FUN80cd260"), 0x480);
    GPU.BG2X.setu(-0x2000);
    CPU.r10().value = 0;
    CPU.r8().value = -90;
    r6 = 0x0;
    r5 = CPU.r9().value + 0x7080;

    //LAB_80d6aa8
    do {
      if(CPU.r10().value < 5) {
        MEMORY.ref(4, r5).setu(r6);
        r0 = (rand() & 0x7) + 104;
      } else {
        //LAB_80d6aba
        MEMORY.ref(4, r5).setu(CPU.r8().value);
        r0 = (rand() & 0x7) + 108;
      }

      //LAB_80d6ac6
      MEMORY.ref(4, r5 + 0x4).setu(r0);
      MEMORY.ref(4, r5 + 0x10).setu((rand() & 0x7) + 4);
      MEMORY.ref(4, r5 + 0x18).setu((rand() & 0xf) + 16);
      CPU.r8().value = CPU.r8().value + 20;
      r6 = r6 + 0x14;
      r5 = r5 + 0x1c;
      CPU.r10().value++;
    } while(CPU.r10().value != 0x10);

    CPU.r10().value = 0;
    r5 = CPU.r9().value + 0x7240;

    //LAB_80d6af8
    do {
      MEMORY.ref(4, r5).setu((rand() & 0x3f) + 32);
      MEMORY.ref(4, r5 + 0x4).setu((rand() & 0x1f) + 64);
      MEMORY.ref(4, r5 + 0x18).setu(-(rand() & 0x7) - 8);
      r5 = r5 + 0x1c;
      CPU.r10().value++;
    } while(CPU.r10().value != 0x10);

    CPU.r10().value = 0;
    r5 = CPU.r9().value + 0x7400;

    //LAB_80d6b36
    do {
      MEMORY.ref(4, r5).setu(0x800000);
      MEMORY.ref(4, r5 + 0x4).setu(0x400000);
      MEMORY.ref(4, r5 + 0xc).setu(-((rand() & 0xff) + 200) << 9);
      MEMORY.ref(4, r5 + 0x10).setu(0);
      MEMORY.ref(4, r5 + 0x18).setu(0);
      r5 = r5 + 0x1c;
      CPU.r10().value++;
    } while(CPU.r10().value != 0x10);

    FUN_80d6750(MEMORY.ref(4, CPU.r9().value + 0x7828).get());
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(-0x400000);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0);

    if((pressedButtons_3001b04.get() & 0x3) != 0) {
      r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      if(r4 > 0xbe && r4 <= 0x11d) {
        MEMORY.call(0x3000164, MEMORY.ref(4, CPU.sp().value + 0x40).get(), 0x4000);
        MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0x11e);
      }
    }

    //LAB_80d6ba4
    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0xe0) {
      MEMORY.ref(4, CPU.r9().value + 0x7780).setu(0);
    }

    //LAB_80d6bb4
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    initMatrixStack();
    FUN_80051d8(camera._00, camera._0c);

    if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == 0x1f) {
      MEMORY.ref(4, CPU.r9().value + 0x77a8).setu(8);
      playSound_(0x9d);
      r3 = MEMORY.ref(4, CPU.r9().value + 0x7828).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      CPU.r10().value = 0;
      if(r3 != 0) {
        r6 = 0x24;
        r5 = CPU.r9().value + 0x7828;

        //LAB_80d6bec
        do {
          r3 = MEMORY.ref(4, r5).get();
          FUN_80b5088(MEMORY.ref(2, r3 + r6).get(), 6);
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r6 = r6 + 0x2;
          CPU.r10().value++;
        } while(CPU.r10().value != r3);
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
    r1 = 0x80;
    r0 = 0x2;
    r1 = r1 << 16;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    FUN_80e6d3c(r0, r1, r2);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x30;
    if((r0 & 0xffff_ffffL) <= (0x30 & 0xffff_ffffL)) {
      r1 = 0x18;
      r0 = divideS(r0, r1);
      r1 = 0x3;
      r0 = modS(r0, r1);
      r6 = 0x80ee910;
      r5 = r0;
      r5 = r5 << 1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, CPU.r9().value + 0x77e4).deref(4).cast(Sprite38::new), r1);
      r5 = r5 + 0x1;
      r1 = MEMORY.ref(1, r6 + r5).getUnsigned();
      setSpriteAnimation_(MEMORY.ref(4, CPU.r9().value + 0x77e8).deref(4).cast(Sprite38::new), r1);
    }

    //LAB_80d6c76
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0x48;
    if((r3 & 0xffff_ffffL) <= (0x37 & 0xffff_ffffL)) {
      r6 = 0xe8;
      r0 = 0x0;
      r6 = r6 << 7;
      CPU.r10().value = r0;
      r6 = r6 + CPU.r9().value;

      //LAB_80d6c88
      do {
        r3 = CPU.r10().value;
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = r3 + 0x48;
        if(r1 >= r3) {
          r5 = MEMORY.ref(4, r6 + 0x4).get();
          r2 = 0x67ffff;
          if(r5 <= r2) {
            r0 = r1;
            r0 = r0 + CPU.r10().value;
            if(r0 < 0x0) {
              r0 = r0 + 0x3;
            }

            //LAB_80d6ca4
            r1 = 0x5;
            r0 = r0 >> 2;
            r0 = modS(r0, r1);
            r4 = 0x80ee916;
            r1 = r0 << 1;
            r1 = MEMORY.ref(2, r4 + r1).getUnsigned();
            r4 = 0x80ee920;
            r3 = 0x2;
            r2 = MEMORY.ref(2, r6 + r3).get();
            r3 = r5 >> 16;
            r5 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r4 = r5 >>> 1;
            r2 = r2 - r4;
            r4 = 0x80ee925;
            r4 = MEMORY.ref(1, r4 + r0).getUnsigned();
            r0 = r4 >>> 1;
            r1 = r1 + CPU.r9().value;
            r3 = r3 - r0;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
            MEMORY.ref(4, CPU.sp().value).setu(r5);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            r2 = 0x80;
            r0 = r6;
            r1 = 0x40;
            r2 = r2 << 5;
            FUN_80e3908(r0, r1, r2);
          }
        }

        //LAB_80d6ce2
        r4 = 0x1;
        CPU.r10().value = CPU.r10().value + r4;
        r0 = CPU.r10().value;
        r6 = r6 + 0x1c;
      } while(r0 != 0x10);
    }

    //LAB_80d6cee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r1 == 0x80) {
      r5 = 0x7240;
      r2 = 0x0;
      CPU.r10().value = r2;
      r6 = 0xff;
      r5 = r5 + CPU.r9().value;

      //LAB_80d6cfe
      do {
        r0 = rand();
        r1 = 0x60;
        r0 = modU(r0, r1);
        r0 = r0 << 16;
        MEMORY.ref(4, r5).setu(r0);
        r0 = rand();
        r3 = 0x7;
        r3 = r3 & r0;
        r3 = r3 + 0x58;
        r3 = r3 << 16;
        MEMORY.ref(4, r5 + 0x4).setu(r3);
        r0 = rand();
        r0 = r0 & r6;
        r0 = r0 - 0x80;
        r0 = r0 << 11;
        MEMORY.ref(4, r5 + 0xc).setu(r0);
        r0 = rand();
        r0 = r0 & r6;
        r0 = -r0;
        r0 = r0 << 11;
        MEMORY.ref(4, r5 + 0x10).setu(r0);
        r0 = rand();
        r3 = 0xf;
        r3 = r3 & r0;
        r3 = -r3;
        r3 = r3 - 0x10;
        MEMORY.ref(4, r5 + 0x18).setu(r3);
        r3 = 0x1;
        CPU.r10().value = CPU.r10().value + r3;
        r4 = CPU.r10().value;
        r5 = r5 + 0x1c;
      } while(r4 != 0x30);

      r2 = 0x4000028;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
    }

    //LAB_80d6d52
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r0 = r0 - 0x80;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    if((r0 & 0xffff_ffffL) <= (0x60 & 0xffff_ffffL)) {
      //LAB_80d6d5e
      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0);
      if(r0 > 0x50) {
        r1 = 0x50;
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r1);
      } else {
        //LAB_80d6db8
        r2 = 0x77a8;
        r3 = 0x2;
        r2 = r2 + CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_80d6dc0
      r7 = 0xe1;
      r2 = 0x0;
      r7 = r7 << 7;
      CPU.r10().value = r2;
      r7 = r7 + CPU.r9().value;

      //LAB_80d6dca
      do {
        r3 = MEMORY.ref(4, r7 + 0x18).get();
        r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        if(r4 > r3) {
          //LAB_80d6dd4
          r0 = CPU.r10().value;
          CPU.r11().value = CPU.r9().value;
          if(r0 > 0x5) {
            r1 = 0xd8;
            r1 = r1 << 3;
            r1 = r1 + CPU.r9().value;
            CPU.r11().value = r1;
          }

          //LAB_80d6de4
          r4 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
          r2 = r4 - r3;
          r3 = MEMORY.ref(4, r7 + 0x10).get();
          r0 = r3;
          r0 = r0 * r2;
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
            r1 = 0x1;
            r0 = CPU.r10().value;
            r0 = r0 & r1;
            r1 = 0x18;
            r3 = MEMORY.ref(4, r7 + 0x4).get();
            r2 = MEMORY.ref(4, r7).get();
            MEMORY.ref(4, CPU.sp().value).setu(r1);
            r1 = 0x8;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
            r0 = r0 << 2;
            r3 = r3 - r6;
            r4 = MEMORY.ref(4, r0 + r1).get();
            r3 = r3 - 0x8;
            r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
            r1 = CPU.r11().value;
            MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
          }

          //LAB_80d6e24
          r3 = CPU.r10().value;
          r4 = 0x1;
          r3 = r3 & r4;
          r3 = r3 << 2;
          r2 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
          CPU.r8().value = r2;

          //LAB_80d6e32
          do {
            r1 = MEMORY.ref(4, r7 + 0x4).get();
            r0 = CPU.r8().value;
            r3 = r0 << 6;
            r2 = r1 - r6;
            r5 = r2 + r3;
            r3 = 0x40;
            r3 = -r3;
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
              r4 = CPU.r11().value;
              r3 = 0x18;
              r1 = r4 + r2;
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
              r1 = r1 + 0xc0;
              r4 = MEMORY.ref(4, r0 + r3).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r3 = r5;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }

            //LAB_80d6e80
            r4 = 0x1;
            CPU.r8().value = CPU.r8().value + r4;
            r0 = CPU.r8().value;
          } while(r0 != 0x3);

          r6 = CPU.r10().value;
          r6 = r6 & r4;
          if(r6 != 0) {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x28).get();
            r5 = MEMORY.ref(4, r7 + 0x4).get();
            r2 = 0x7f;
            r3 = r5 - r1;
            r3 = r3 & r2;
            r3 = r3 - 0x10;
            r1 = 0x3;
            r0 = CPU.r10().value;
            CPU.r8().value = r3;
            r0 = modS(r0, r1);
            r3 = 0x80ee930;
            r1 = r0;
            r4 = MEMORY.ref(1, r3 + r1).getUnsigned();
            r2 = CPU.r8().value;
            r3 = r2 + r4;
            CPU.r12().value = r4;
            if(r3 > r5) {
              r3 = r3 - r5;
              r4 = r4 - r3;
            }

            //LAB_80d6ebc
            if(r4 > 0) {
              r2 = 0x80ee92a;
              r3 = r1 << 1;
              r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r3 = CPU.r12().value;
              r2 = MEMORY.ref(4, r7).get();
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
              r3 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              r0 = r6 << 2;
              r4 = MEMORY.ref(4, r0 + r3).get();
              r1 = r1 + CPU.r9().value;
              r2 = r2 + 0x8;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r3 = CPU.r8().value;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }
        }

        //LAB_80d6ee0
        r4 = 0x1;
        CPU.r10().value = CPU.r10().value + r4;
        r0 = CPU.r10().value;
        r7 = r7 + 0x1c;
      } while(r0 != 0xa);
    }

    //LAB_80d6eee
    r1 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r1 & 0xffff_ffffL) <= (0x5f & 0xffff_ffffL)) {
      r5 = 0xe8;
      r2 = 0x0;
      r5 = r5 << 7;
      CPU.r10().value = r2;
      r6 = 0xff;
      r5 = r5 + CPU.r9().value;

      //LAB_80d6f00
      do {
        r3 = MEMORY.ref(4, r5 + 0x18).get();
        if(r3 >= 0) {
          r1 = 0x5;
          r0 = CPU.r10().value;
          r0 = modS(r0, r1);
          r2 = 0x80ee934;
          r3 = r0 << 1;
          r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
          r3 = 0x2;
          r2 = MEMORY.ref(2, r5 + r3).get();
          r4 = 0x6;
          r3 = MEMORY.ref(2, r5 + r4).get();
          r4 = 0x80ee93e;
          r4 = MEMORY.ref(1, r4 + r0).getUnsigned();
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          r4 = 0x80ee943;
          r0 = MEMORY.ref(1, r4 + r0).getUnsigned();
          r1 = r1 + CPU.r9().value;
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
          r0 = 0x80;
          r0 = r0 << 7;
          r1 = 0xf0;
          r2 = r2 + r3;
          r1 = r1 << 15;
          r3 = r3 + r0;
          MEMORY.ref(4, r5 + 0x4).setu(r2);
          MEMORY.ref(4, r5 + 0x10).setu(r3);
          if((r2 & 0xffff_ffffL) > (r1 & 0xffff_ffffL)) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            if(r2 <= 0x9f) {
              r0 = rand();
              r1 = 0x60;
              r0 = modU(r0, r1);
              r0 = r0 << 16;
              MEMORY.ref(4, r5).setu(r0);
              r0 = rand();
              r3 = 0x7;
              r3 = r3 & r0;
              r3 = r3 + 0x58;
              r3 = r3 << 16;
              MEMORY.ref(4, r5 + 0x4).setu(r3);
              r0 = rand();
              r0 = r0 & r6;
              r0 = r0 - 0x80;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0xc).setu(r0);
              r0 = rand();
              r0 = r0 & r6;
              r0 = -r0;
              r0 = r0 << 11;
              MEMORY.ref(4, r5 + 0x10).setu(r0);
            }
          }

          //LAB_80d6f8c
          r3 = MEMORY.ref(4, r5 + 0x18).get();
        }

        //LAB_80d6f8e
        r3 = r3 + 0x1;
        MEMORY.ref(4, r5 + 0x18).setu(r3);
        r3 = 0x1;
        CPU.r10().value = CPU.r10().value + r3;
        r4 = CPU.r10().value;
        r5 = r5 + 0x1c;
      } while(r4 != 0x20);
    }

    //LAB_80d6f9e
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xe0;
    if((r3 & 0xffff_ffffL) <= (0x17 & 0xffff_ffffL)) {
      r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r3 = 0x3;
      r3 = r3 & r0;
      if(r3 == 0) {
        r2 = 0x1f;
        r4 = 0xa0;
        r1 = 0x0;
        r4 = r4 << 19;
        CPU.r10().value = r1;
        CPU.r8().value = r2;

        //LAB_80d6fbc
        do {
          r3 = MEMORY.ref(2, r4).getUnsigned();
          r7 = 0x1f;
          r7 = r7 & r3;
          r3 = r3 << 16;
          r0 = CPU.r8().value;
          r6 = r3 >>> 21;
          r5 = r3 >>> 26;
          r6 = r6 & r0;
          r5 = r5 & r0;
          r0 = r7 + r6;
          r0 = r0 + r5;
          r1 = 0x3;
          MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
          r0 = divideS(r0, r1);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
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
          r2 = r6 << 5;
          r3 = r5 << 10;
          r1 = 0x1;
          r3 = r3 | r2;
          CPU.r10().value = CPU.r10().value + r1;
          r3 = r3 | r7;
          r2 = CPU.r10().value;
          MEMORY.ref(2, r4).setu(r3);
          r4 = r4 + 0x2;
        } while(r2 != 0x40);
      }
    }

    //LAB_80d7034
    r3 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
    if((r3 & 0xffff_ffffL) <= (0xac & 0xffff_ffffL)) {
      r2 = 0x7828;
      r0 = CPU.r9().value;
      r3 = MEMORY.ref(4, r0 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r4 = 0x0;
      CPU.r10().value = r4;
      if(r3 != 0) {
        r1 = CPU.sp().value + 0x4c;
        CPU.r8().value = r1;
        r6 = CPU.sp().value + 0x58;
        CPU.r11().value = r4;

        //LAB_80d7052
        do {
          r2 = MEMORY.ref(4, CPU.r9().value + r2).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + CPU.r10().value * 0x2).get()).actor_00.deref();
          MEMORY.ref(4, r6).setu(actor.pos_08.getX());
          MEMORY.ref(4, r6 + 0x4).setu(actor.pos_08.getY());
          MEMORY.ref(4, r6 + 0x8).setu(actor.pos_08.getZ());
          FUN_80e3944(r6, CPU.r8().value);
          r2 = CPU.r11().value;
          r7 = 0x0;
          r5 = CPU.r9().value + r2 * 0x1c + 0x7240;

          //LAB_80d7088
          do {
            r0 = MEMORY.ref(4, r5 + 0x18).get();
            if(r0 == 0) {
              MEMORY.ref(4, r5).setu(MEMORY.ref(4, CPU.sp().value + 0x4c).get() + (rand() & 0xf) - 8);
              MEMORY.ref(4, r5 + 0x4).setu(MEMORY.ref(4, CPU.sp().value + 0x50).get() + (rand() & 0xf) - 40);
            }

            //LAB_80d70b0
            if((r0 & 0xffff_ffffL) < 5) {
              r2 = 0x80ee948;
              r3 = r0 << 1;
              r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
              r3 = 0x80ee952;
              r0 = MEMORY.ref(1, r3 + r0).getUnsigned();
              r2 = MEMORY.ref(4, r5).get();
              r3 = MEMORY.ref(4, r5 + 0x4).get();
              r4 = r0 >>> 1;
              r2 = r2 - r4;
              r3 = r3 - r4;
              MEMORY.ref(4, CPU.sp().value).setu(r0);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r1 = r1 + CPU.r9().value;
              r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r0 = MEMORY.ref(4, r5 + 0x18).get();
            }

            //LAB_80d70d8
            r3 = r0 + 0x1;
            MEMORY.ref(4, r5 + 0x18).setu(r3);
            r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            if(r4 <= 0xc7) {
              if(r3 == 0x5) {
                r0 = rand();
                r3 = 0x7;
                r3 = r3 & r0;
                r3 = -r3;
                MEMORY.ref(4, r5 + 0x18).setu(r3);
              }
            }

            //LAB_80d70f2
            r7 = r7 + 0x1;
            r5 = r5 + 0x1c;
          } while(r7 != 0x6);

          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r1 = 0x1;
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          r0 = 0x6;
          CPU.r10().value = CPU.r10().value + r1;
          CPU.r11().value = CPU.r11().value + r0;
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d710e
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 > 0xe8) {
      r1 = 0xfffffe10;
      r3 = r0 << 1;
      r6 = r3 + r1;
      r2 = 0x0;
      r3 = 0x0;
      CPU.r10().value = r2;
      CPU.r12().value = r3;
      r4 = r6;

      //LAB_80d7124
      do {
        r7 = 0x0;

        //LAB_80d7126
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r5 = 0x7;
            r0 = r4;
            r0 = r0 & r5;
            r3 = r0 << 5;
            r3 = r3 + CPU.r10().value;
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
            r1 = r1 & r5;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            r0 = CPU.r12().value;
            MEMORY.ref(1, r3).setu(r0);
          }

          //LAB_80d7168
          r7 = r7 + 0x1;
        } while(r7 != 0x4);

        r1 = 0x1;
        CPU.r10().value = CPU.r10().value + r1;
        r2 = CPU.r10().value;
        r4 = r4 + 0x1;
      } while(r2 != 0x20);

      r4 = 0x0;
      r3 = 0x0;
      CPU.lr().value = r4;
      CPU.r10().value = r3;
      r4 = r6 + 0x1;

      //LAB_80d7184
      do {
        r7 = 0x0;
        CPU.r12().value = r4;

        //LAB_80d7188
        do {
          if((r4 & 0xffff_ffffL) <= (0x7f & 0xffff_ffffL)) {
            r5 = 0x7;
            r0 = CPU.r12().value;
            r0 = r0 & r5;
            r3 = r0 << 5;
            r3 = r3 + CPU.r10().value;
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
            r1 = r1 & r5;
            r3 = r3 << 3;
            r3 = r3 + r1;
            r3 = r2 + r3;
            r0 = CPU.lr().value;
            MEMORY.ref(1, r3).setu(r0);
          }

          //LAB_80d71ca
          r7 = r7 + 0x1;
        } while(r7 != 0x4);

        r1 = 0x1;
        CPU.r10().value = CPU.r10().value + r1;
        r2 = CPU.r10().value;
        r4 = r4 + 0x1;
      } while(r2 != 0x20);
    }

    //LAB_80d71dc
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 - 0xa1;
    if((r3 & 0xffff_ffffL) <= (0x3e & 0xffff_ffffL)) {
      r2 = 0x7828;
      r3 = 0x0;
      r4 = CPU.r9().value;
      CPU.r10().value = r3;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d71f4
        do {
          r0 = CPU.r10().value;
          r3 = r0 << 3;
          r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 + 0xa0;
          if(r1 > r3) {
            r2 = MEMORY.ref(4, CPU.r9().value + r2).get();
            final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + r0 * 0x2).get()).actor_00.deref();
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
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
          CPU.r10().value++;
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d726c
    r2 = 0x7828;
    r1 = CPU.r9().value;
    r3 = MEMORY.ref(4, r1 + r2).get();
    r3 = MEMORY.ref(4, r3 + 0x14).get();
    r0 = 0x0;
    CPU.r10().value = r0;
    if(r3 != 0) {
      r5 = 0x8f;
      r7 = 0x8;
      r6 = 0x24;
      r5 = r5 << 1;

      //LAB_80d7284
      do {
        if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == r5) {
          r3 = MEMORY.ref(4, CPU.r9().value + r2).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r3 + r6).get()).actor_00.deref();
          actor.pos_08.setY(0x600000);
          actor._48.set(0xab85);
        }

        //LAB_80d72a0
        if(MEMORY.ref(4, CPU.sp().value + 0x3c).get() == r5 + 0x10) {
          r3 = 0x7828;
          r3 = r3 + CPU.r9().value;
          r3 = MEMORY.ref(4, r3).get();
          r2 = 0x1;
          r0 = MEMORY.ref(2, r3 + r6).get();
          r1 = 0x7;
          r3 = CPU.r10().value;
          r2 = -r2;
          MEMORY.ref(4, CPU.sp().value).setu(r7);
          FUN_80d6888(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
          r0 = 0x86;
          playSound_(r0);
          r3 = 0x77a8;
          r3 = r3 + CPU.r9().value;
          MEMORY.ref(4, r3).setu(r7);
        }

        //LAB_80d72cc
        r2 = 0x7828;
        r1 = CPU.r9().value;
        r3 = MEMORY.ref(4, r1 + r2).get();
        r0 = 0x1;
        r3 = MEMORY.ref(4, r3 + 0x14).get();
        CPU.r10().value = CPU.r10().value + r0;
        r6 = r6 + 0x2;
        r5 = r5 + 0x5;
      } while(CPU.r10().value != r3);
    }

    //LAB_80d72e0
    r3 = 0x97;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r3 = r3 << 1;
    if(r2 == r3) {
      //LAB_80d72ec
      r0 = 0x2f;
      freeSlot(r0);
      r0 = 0x2e;
      freeSlot(r0);
      r0 = 0x98;
      r1 = CPU.r9().value;
      r2 = 0x1;
      r3 = 0x0;
      FUN_80e0524(r0, r1, r2, r3);
      r1 = 0xb4;
      r1 = r1 << 5;
      r0 = 0xc0;
      r1 = r1 + CPU.r9().value;
      r2 = 0x1;
      r3 = 0x1;
      FUN_80e0524(r0, r1, r2, r3);
      r6 = 0x2;
      r1 = 0x7;
      r2 = 0x7;
      r3 = 0x3;
      r0 = 0x2e;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = 0x3001e50;
      r3 = r5;
      r3 = r3 + 0xb8;
      r3 = MEMORY.ref(4, r3).get();
      r1 = 0x7;
      MEMORY.ref(4, CPU.sp().value + 0x44).setu(r3);
      r2 = 0x7;
      r3 = 0x7;
      r0 = 0x2f;
      MEMORY.ref(4, CPU.sp().value).setu(r6);
      FUN_80ed408(r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get());
      r5 = r5 + 0xbc;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = MEMORY.ref(4, r5).get();
      r2 = 0x4000050;
      MEMORY.ref(4, r4 + 0x4).setu(r3);
      r3 = 0x3f46;
      MEMORY.ref(2, r2).setu(r3);
      r3 = 0x80;
      r2 = r2 - 0x30;
      MEMORY.ref(2, r2).setu(r3);
      r2 = r2 + 0x8;
      r3 = 0x0;
      MEMORY.ref(4, r2).setu(r3);
      r3 = 0xef;
      r3 = r3 << 7;
      r2 = 0x7784;
      r3 = r3 + CPU.r9().value;
      MEMORY.ref(4, r3).setu(r6);
      r2 = r2 + CPU.r9().value;
      r3 = 0x4b;
      r1 = 0x90;
      MEMORY.ref(4, r2).setu(r3);
      r1 = r1 << 3;
      setTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"), r1);
      r2 = 0x7828;
      r1 = CPU.r9().value;
      r3 = MEMORY.ref(4, r1 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      r0 = 0x0;
      CPU.r10().value = r0;

      if(r3 != 0) {
        //LAB_80d73b0
        do {
          r2 = MEMORY.ref(4, CPU.r9().value + r2).get();
          final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + 0x24 + CPU.r10().value * 0x2).get()).actor_00.deref();
          r6 = CPU.r9().value + CPU.r10().value * 0x118 + 0x7080;
          r7 = 0x0;

          //LAB_80d73da
          do {
            MEMORY.ref(4, r6).setu(actor.pos_08.getX());
            MEMORY.ref(4, r6 + 0x4).setu(0x140000);
            MEMORY.ref(4, r6 + 0x8).setu(actor.pos_08.getZ());
            r3 = 0x3334;
            r5 = r7;
            r5 = r5 * r3;
            r0 = r5;
            r0 = sin(r0);
            r0 = r0 << 2;
            MEMORY.ref(4, r6 + 0xc).setu(r0);
            r0 = rand();
            r3 = 0x7fff;
            r1 = 0x80;
            r3 = r3 & r0;
            r1 = r1 << 9;
            r3 = r3 + r1;
            MEMORY.ref(4, r6 + 0x10).setu(r3);
            r0 = r5;
            r0 = cos(r0);
            r7 = r7 + 0x1;
            r0 = r0 << 2;
            r3 = 0x0;
            MEMORY.ref(4, r6 + 0x14).setu(r0);
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r6 = r6 + 0x1c;
          } while(r7 != 0xa);

          r2 = 0x1;
          CPU.r10().value = CPU.r10().value + r2;
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d7430
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r1 = 0x12d;
    if(r0 > r1) {
      //LAB_80d743a
      r2 = 0x0;
      CPU.r10().value = r2;
      r2 = 0x7828;
      r4 = CPU.r9().value;
      r3 = MEMORY.ref(4, r4 + r2).get();
      r3 = MEMORY.ref(4, r3 + 0x14).get();
      if(r3 != 0) {
        //LAB_80d744c
        r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
        r3 = 0xfffffed2;
        r0 = CPU.sp().value;
        r0 = r0 + 0x4c;
        r3 = r1 + r3;
        r4 = 0x97;
        r1 = CPU.sp().value;
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
        r4 = r4 << 1;
        r0 = 0x0;
        r1 = r1 + 0x58;
        MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
        MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);

        //LAB_80d746a
        do {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          if(r3 >= r4) {
            r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r1 = 0x9d;
            r1 = r1 << 1;
            r4 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
            r3 = r0 + r1;
            if(r4 < r3) {
              r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r1 = CPU.r9().value;
              r4 = CPU.r10().value;
              r2 = MEMORY.ref(4, r1 + r2).get();
              r3 = r4 << 1;
              r3 = r3 + 0x24;
              r6 = r0 >>> 31;
              r6 = r0 + r6;
              final Actor70 actor = getCombatantForUnit_(MEMORY.ref(2, r2 + r3).get()).actor_00.deref();
              r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              MEMORY.ref(4, r4).setu(actor.pos_08.getX());
              MEMORY.ref(4, r4 + 0x4).setu(0);
              MEMORY.ref(4, r4 + 0x8).setu(actor.pos_08.getZ());
              r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              CPU.r8().value = r0;
              r1 = CPU.r8().value;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              r0 = FUN_80e3944(r0, r1);
              r6 = r6 >> 1;
              r1 = CPU.r8().value;
              r2 = MEMORY.ref(4, r1).get();
              r5 = r6 << 4;
              r5 = r5 - r6;
              r3 = MEMORY.ref(4, r1 + 0x4).get();
              r2 = r2 >> 1;
              r5 = r5 << 5;
              MEMORY.ref(4, r1).setu(r2);
              r5 = r5 + CPU.r9().value;
              r4 = 0x14;
              r0 = 0x18;
              r2 = r2 - 0x14;
              r3 = r3 - 0x18;
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
              r1 = r5;
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              r1 = CPU.r8().value;
              r4 = 0x14;
              r0 = 0x18;
              r3 = MEMORY.ref(4, r1 + 0x4).get();
              r2 = MEMORY.ref(4, r1).get();
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
              MEMORY.ref(4, CPU.sp().value).setu(r4);
              r3 = r3 - 0x18;
              r4 = MEMORY.ref(4, r1 + 0x4).get();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
              r1 = r5;
              MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
            }
          }

          //LAB_80d74f8
          r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
          r3 = r3 + 0x6;
          if(r2 >= r3) {
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r3 = CPU.sp().value + 0x4c;
            r2 = r2 + CPU.r10().value;
            CPU.r8().value = r3;
            r3 = r2 << 3;
            r3 = r3 - r2;
            r3 = r3 << 3;
            r4 = 0xe1;
            r3 = r3 + CPU.r9().value;
            r4 = r4 << 7;
            r0 = 0xc;
            r7 = 0x0;
            r6 = CPU.r8().value;
            r5 = r3 + r4;
            CPU.r11().value = r0;

            //LAB_80d7520
            do {
              r0 = r5;
              r1 = r6;
              r0 = FUN_80e3944(r0, r1);
              r3 = MEMORY.ref(4, r6).get();
              r2 = r3 >> 1;
              MEMORY.ref(4, r6).setu(r2);
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              CPU.cmpT(r3, 0x1a);
              if((r3 & 0xffff_ffffL) <= (0x1a & 0xffff_ffffL)) {
                r3 = 0x80ee958;
                r4 = CPU.r11().value;
                r1 = MEMORY.ref(2, r3 + r4).getUnsigned();
                r3 = 0x80ee966;
                r4 = MEMORY.ref(2, r3 + r4).getUnsigned();
                r3 = CPU.r8().value;
                r3 = MEMORY.ref(4, r3 + 0x4).get();
                r0 = r4 >>> 1;
                r2 = r2 - r0;
                r3 = r3 - r0;
                MEMORY.ref(4, CPU.sp().value).setu(r4);
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r4);
                r1 = r1 + CPU.r9().value;
                r4 = MEMORY.ref(4, CPU.sp().value + 0x44).get();
                r0 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
                MEMORY.call(r4, r0, r1, r2, r3, MEMORY.ref(4, CPU.sp().value).get(), MEMORY.ref(4, CPU.sp().value + 0x4).get());
              }

              //LAB_80d7556
              r2 = 0x80;
              r0 = r5;
              r1 = 0x3c;
              r2 = r2 << 5;
              FUN_80e3908(r0, r1, r2);
              r3 = MEMORY.ref(4, r5 + 0x18).get();
              r7 = r7 + 0x1;
              r3 = r3 + 0x1;
              MEMORY.ref(4, r5 + 0x18).setu(r3);
              r5 = r5 + 0x1c;
            } while(r7 != 0x5);
          }

          //LAB_80d7570
          r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          r0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
          r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
          r4 = r4 - 0x4;
          r2 = 0x1;
          r0 = r0 + 0x4;
          r1 = r1 + 0x4;
          MEMORY.ref(4, CPU.sp().value + 0x14).setu(r4);
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
          CPU.r10().value = CPU.r10().value + r2;
          r2 = 0x7828;
          r4 = CPU.r9().value;
          r3 = MEMORY.ref(4, r4 + r2).get();
          r3 = MEMORY.ref(4, r3 + 0x14).get();
        } while(CPU.r10().value != r3);
      }
    }

    //LAB_80d7594
    r0 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    if(r0 <= 0x7f) {
      r0 = 0x4;
      r1 = 0x10;
      FUN_80e155c(r0, r1);
    } else {
      //LAB_80d75a4
      r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
      r2 = 0x12d;
      if(r1 <= r2) {
        r0 = 0x2;
        r1 = 0x2;
        FUN_80e155c(r0, r1);
      } else {
        //LAB_80d75b6
        r0 = 0x4;
        r1 = 0x8;
        FUN_80e155c(r0, r1);
      }
    }

    //LAB_80d75be
    FUN_80cd52c();
    r2 = 0x7824;
    r3 = 0x1;
    r2 = r2 + CPU.r9().value;
    MEMORY.ref(4, r2).setu(r3);
    r0 = 0x1;
    sleep(r0);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
    r4 = 0xb7;
    r3 = r3 + 0x1;
    r4 = r4 << 1;
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(r3);
    if(r3 != r4) {
      FUN_80d6b76();
    }

    //LAB_80d75e2
    clearTickCallback(getRunnable(GoldenSun_80c.class, "FUN_80cd260"));
    r0 = 0x2f;
    freeSlot(r0);
    r0 = 0x2e;
    freeSlot(r0);
    r0 = 0x86;
    FUN_80b50e8(r0);
    r1 = 0x80;
    r0 = 0x2;
    r1 = r1 << 16;
    r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
    r5 = 0x77d8;
    FUN_80e6eac(r0, r1, r2);
    r0 = 0x0;
    CPU.r10().value = r0;
    r5 = r5 + CPU.r9().value;

    //LAB_80d760e
    do {
      clearSprite_(MEMORY.ref(4, r5).deref(4).cast(Sprite38::new));
      r5 += 0x4;
      CPU.r10().value++;
    } while(CPU.r10().value < 8);

    FUN_80cdbc0();
    CPU.sp().value += 0x64;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80d6b76)
  public static void FUN_80d6b76() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80d765c)
  public static void FUN_80d765c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80dc968)
  public static void FUN_80dc968(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80dbb24)
  public static void FUN_80dbb24(final int r0, final int r1, int r2) {
    final int r3;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r3 = 0x3001eec;
    CPU.r8().value = r0;
    CPU.r9().value = r1;
    r7 = MEMORY.ref(4, r3).get();
    r6 = 0x0;
    if(r0 != 0) {
      r2 = r2 & 0x3;
      r2 = r2 << 2;
      r5 = 0x77d8;
      CPU.r10().value = r2;

      //LAB_80dbb50
      do {
        final Sprite38 sprite = loadSprite_(CPU.r9().value);
        MEMORY.ref(4, r5 + r7).setu(sprite != null ? sprite.getAddress() : 0);
        if(sprite != null) {
          sprite._26.set(0);
          setSpriteAnimation_(sprite, r6);
          r2 = MEMORY.ref(4, r5 + r7).get();
          MEMORY.ref(1, r2 + 0x9).and(~0xc).or(CPU.r10().value);
        }

        //LAB_80dbb78
        r6 = r6 + 0x1;
        r5 = r5 + 0x4;
      } while(r6 != CPU.r8().value);
    }

    //LAB_80dbb80
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }
}
