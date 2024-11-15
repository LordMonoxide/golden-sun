package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.GraphicsStruct24;
import org.goldensun.types.GraphicsStruct28;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.Map194;
import org.goldensun.types.Struct12fc;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSun.FUN_80042c8;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.modU;
import static org.goldensun.GoldenSun.cos;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.FUN_8003d28;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.loadSaveList;
import static org.goldensun.GoldenSun.loadSavePreview;
import static org.goldensun.GoldenSun.unloadSaveList;
import static org.goldensun.GoldenSun.FUN_800fec8;
import static org.goldensun.GoldenSun.FUN_800ff54;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSunVars._2000434;
import static org.goldensun.GoldenSunVars._200044c;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSunVars._3001cd0;
import static org.goldensun.GoldenSunVars._80134fc;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_808.FUN_808a278;
import static org.goldensun.GoldenSun_808.FUN_808a5d0;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_801 {
  private GoldenSun_801() { }

  /** Causes the first map to shake */
  @Method(0x8010000)
  public static void FUN_8010000() {
    final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int r1_0 = r8._00.get();
    if(r1_0 != 0) {
      //LAB_8010024
      int r7 = MEMORY.ref(4, r1_0).get() + 0xff880000;
      int r6 = MEMORY.ref(4, r1_0 + 0x8).get() - MEMORY.ref(4, r1_0 + 0x4).get() + 0xffa00000;
      final int r12 = r8._04.get();
      final int r5 = r8._08.get();
      final int r0 = r8._ec.get() + r12;
      final int lr = r8._f0.get() + r5;
      int r1 = r8._f4.get() - r12 + 0xff100000;
      int r3 = r8._f8.get() - r5 + 0xff600000;

      if(r1 < r0) {
        r1 = r0;
      }

      //LAB_801006e
      if(r3 < lr) {
        r3 = lr;
      }

      //LAB_8010074
      if(r7 < r0) {
        r7 = r0;
      }

      //LAB_801007a
      if(r7 > r1) {
        r7 = r1;
      }

      //LAB_8010080
      if(r6 < lr) {
        r6 = lr;
      }

      //LAB_8010086
      if(r6 > r3) {
        r6 = r3;
      }

      //LAB_801008c
      if(r12 != 0) {
        r7 = r7 + (int)MEMORY.call(0x3000118, r8._04.get(), rand() - rand());
        r8._04.set((int)MEMORY.call(0x3000118, r8._04.get(), r8._0c.get()));
      }

      //LAB_80100c4
      if(r5 != 0) {
        r6 = r6 + (int)MEMORY.call(0x3000118, r8._08.get(), rand() - rand());
        r8._08.set((int)MEMORY.call(0x3000118, r8._08.get(), r8._0c.get()));
      }

      //LAB_80100fa
      r8._e4.set(r7);
      r8._e8.set(r6);

      //LAB_8010112
      for(int r10 = 0; r10 < 3; r10++) {
        final Map194.Sub30 r4 = r8._104.get(r10);
        r7 = (int)MEMORY.call(0x3000118, r8._e4.get(), r4._10.get());
        r6 = (int)MEMORY.call(0x3000118, r8._e8.get(), r4._14.get());

        if(r4._18.get() != 0) {
          r4._20.add(r4._18.get());
          r7 = r7 + r4._20.get() & (r4._28.get() << 19 | 0x7ffff);
        }

        //LAB_8010142
        if(r4._1c.get() != 0) {
          r4._24.add(r4._1c.get());
          r6 = r6 + r4._24.get() & (r4._2a.get() << 19 | 0x7ffff);
        }

        //LAB_801015a
        r7 = r7 + r4._08.get();
        r6 = r6 + r4._0c.get();
        final int r8_0 = r7 / 0x80000;
        final int r5_0 = r6 / 0x80000;

        if(((r4._00.get() ^ r7) & 0x80000) != 0) {
          //LAB_80101a4
          FUN_800ff54(r10, r4._00.get() < r7 ? r8_0 + 30 : r8_0, r5_0);
        }

        //LAB_80101aa
        if(((r4._04.get() ^ r6) & 0x100000) != 0) {
          //LAB_80101d2
          FUN_800fec8(r10, r8_0, r4._04.get() < r6 ? r5_0 + 20 : r5_0);
        }

        //LAB_80101d8
        MEMORY.ref(2, 0x3001ad0 + (3 - r10) * 0x4).setu(r7 >> 16);
        MEMORY.ref(2, 0x3001ad2 + (3 - r10) * 0x4).setu(r6 >> 16);
        r4._00.set(r7);
        r4._04.set(r6);
      }
    }

    //LAB_80101fe
  }

  @Method(0x8010230)
  public static void FUN_8010230(int r0, final int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r11;

    r7 = r0;
    final Map194 sp14 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r0 = r1 - 0x600000;
    r3 = sp14._ec.get();
    r7 = r7 - 0x780000;
    if(r7 < r3) {
      r7 = r3;
    }

    //LAB_8010266
    r3 = sp14._f4.get();
    r3 = r3 - 0xf00000;
    if(r7 > r3) {
      r7 = r3;
    }

    //LAB_8010276
    r3 = sp14._f0.get();
    if(r0 < r3) {
      r0 = r3;
    }

    //LAB_8010282
    r3 = sp14._f8.get();
    r3 = r3 - 0xa00000;
    if(r0 > r3) {
      r0 = r3;
    }

    //LAB_8010292
    sp14._e4.set(r7);
    sp14._e8.set(r0);

    //LAB_80102a6
    for(int sp1c = 0; sp1c < 3; sp1c++) {
      final Map194.Sub30 lr = sp14._104.get(sp1c);
      if(sp14._100.get(sp1c).get() == 0) {
        break;
      }

      //LAB_80102b8
      r4 = 0x16;
      r7 = (int)MEMORY.call(0x3000118, sp14._e4.get(), lr._10.get());
      r0 = (int)MEMORY.call(0x3000118, sp14._e8.get(), lr._14.get());

      r2 = lr._18.get();
      if(r2 != 0) {
        lr._20.add(r2);
        r7 = r7 + lr._20.get() & (lr._28.get() << 19 | 0x7ffff);
      }

      //LAB_80102f4
      r2 = lr._1c.get();
      if(r2 != 0) {
        lr._24.add(r2);
        r0 = r0 + lr._24.get() & (lr._2a.get() << 19 | 0x7ffff);
        r4 = 0x20;
      }

      //LAB_8010312
      r7 = (r7 + lr._08.get()) / 0x80000;
      r0 = (r0 + lr._0c.get()) / 0x80000;
      r6 = (r0 / 2 & 0x7f) * 0x80;
      r11 = r4 >> 1;
      final int sp18 = 0x6002800 + sp1c * 0x800;
      r5 = (r0 & 0x1e) * 0x20;
      final int sp08 = r7 / 2;

      //LAB_8010370
      for(r8 = 0; r8 < r11; r8++) {
        r4 = sp08 & 0x7f;
        r0 = r7 & 0x1e;

        //LAB_8010380
        for(int r12 = 0; r12 < 0x10; r12++) {
          final int sp04 = (MEMORY.ref(4, 0x2010000 + (r6 + r4) * 0x4).get() << 20 >>> 20) * 0x8;
          final int sp00 = sp18 + (r5 + r0) * 0x2;
          MEMORY.ref(4, sp00).setu(MEMORY.ref(4, 0x2020000 + sp04).get());
          MEMORY.ref(4, sp00 + 0x40).setu(MEMORY.ref(4, 0x2020004 + sp04).get());
          r4 = r4 + 1 & 0x7f;
          r0 = r0 + 2 & 0x1e;
        }

        r6 = r6 + 0x80 & 0x3f80;
        r5 = r5 + 0x40 & 0x3c0;
      }

      //LAB_80103da
    }

    //LAB_80103e6
  }

  @Method(0x8010424)
  public static void FUN_8010424(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    int sp04 = 0x2010000 + (r3 * 0x80 + r2) * 0x4;
    int sp08 = 0x2010000 + (r1 * 0x80 + r0) * 0x4;
    final Map194 r2_0 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int[] r9 = new int[6];

    //LAB_801045e
    for(int i = 0; i < 3; i++) {
      r9[i * 2    ] = r2_0._104.get(i)._00.get() >> 20;
      r9[i * 2 + 1] = r2_0._104.get(i)._04.get() >> 20;
    }

    final int sp00 = r3 + a5;
    final int r8 = (0x80 - a4) * 0x4;

    //LAB_801048a
    for(int r7 = r3; r7 < sp00; r7++) {
      final int lr = r2 + a4;
      final int r12 = r7 & 0xf;

      //LAB_80104a2
      for(int r1_0 = r2; r1_0 < lr; r1_0++) {
        final int r5 = MEMORY.ref(4, sp08).get() & 0xfff;
        MEMORY.ref(4, sp04).and(0xffff_f000).oru(r5);
        sp08 += 0x4;
        sp04 += 0x4;
        final int r3_0 = (r1_0 & 0xf) + r12 * 0x20;

        //LAB_80104d0
        for(int i = 0; i < 3; i++) {
          if(r9[i * 2] <= r1_0 && r9[i * 2] + 0x10 > r1_0 && r9[i * 2 + 1] <= r7 && r9[i * 2 + 1] + 0xc > r7) {
            MEMORY.ref(4, 0x6002800 + i * 0x800 + r3_0 * 0x4).setu(MEMORY.ref(4, 0x2020000 + r5 * 0x8).get());
            MEMORY.ref(4, 0x6002840 + i * 0x800 + r3_0 * 0x4).setu(MEMORY.ref(4, 0x2020004 + r5 * 0x8).get());
            break;
          }

          //LAB_8010504
        }

        //LAB_8010512
      }

      //LAB_8010518
      sp08 += r8;
      sp04 += r8;
    }

    //LAB_801052c
  }

  @Method(0x8010704)
  public static void FUN_8010704(int r0, int r1, int r2, int r3, final int a4, final int a5) {
    int r4;
    int r5;
    final int lr;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    lr = r3;
    CPU.r12().value = r2;
    r3 = CPU.lslT(a5, 7);
    r3 = CPU.addT(r3, a4);
    r1 = CPU.lslT(r1, 7);
    CPU.r8().value = 0x2010000;
    r3 = CPU.lslT(r3, 2);
    r1 = CPU.addT(r1, r0);
    r3 += CPU.r8().value;
    r1 = CPU.lslT(r1, 2);
    r2 = lr;
    CPU.r10().value = r3;
    CPU.r8().value += r1;
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r5 = CPU.movT(0, 0x0);

      //LAB_8010732
      do {
        r3 = CPU.lsrT(r5, 7);
        r4 = CPU.r10().value;
        r2 = CPU.r8().value;
        r1 = CPU.addT(r4, r3);
        r0 = CPU.addT(r2, r3);
        r3 = CPU.r12().value;
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r4 = CPU.movT(0, 0x0);

          //LAB_8010748
          do {
            r2 = MEMORY.ref(4, r1).get();
            r3 = MEMORY.ref(4, r0).get();
            r0 += 0x4;

            r2 = CPU.andT(r2, 0xfff);
            r3 = CPU.andT(r3, 0xfffff000);
            r2 = CPU.orrT(r2, r3);
            MEMORY.ref(4, r1).setu(r2);
            r1 += 0x4;

            r2 = CPU.movT(0, 0x80);
            r2 = CPU.lslT(r2, 9);
            r3 = CPU.addT(r4, r2);
            r4 = CPU.addT(r3, 0x0);
            r3 = CPU.lsrT(r4, 16);
            CPU.cmpT(r3, CPU.r12().value);
          } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
        }

        //LAB_8010762
        r4 = CPU.movT(0, 0x80);
        r4 = CPU.lslT(r4, 9);
        r3 = CPU.addT(r5, r4);
        r5 = CPU.addT(r3, 0x0);
        r3 = CPU.lsrT(r5, 16);
        CPU.cmpT(r3, lr);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_8010770
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x801179c)
  public static void FUN_801179c() {
    int r0;
    int r1;
    int r2;
    int r4;

    final Map194 r8 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    //LAB_80117c0
    for(int i = 0; i < 0x10; i++) {
      final Map194.Sub0c r5 = r8._18.get(i);

      if(r5._00.get() != 0 && r5._0a.get() == 0) {
        //LAB_80117cc
        do {
          if(r5._08.get() != 0) {
            //LAB_801186c
            r5._08.decr();
            break;
          }

          r4 = r5._04.get();
          r0 = MEMORY.ref(2, r4).getUnsigned();
          r4 += 0x2;
          if(r0 == 0xffff) {
            r5._04.set(r5._00.get());
          } else {
            //LAB_80117e4
            if((r0 & 0xff00) != 0xfe00) {
              //LAB_8011804
              r2 = MEMORY.ref(2, r4).getUnsigned();
              r4 += 0x2;
              r1 = MEMORY.ref(2, r4).getUnsigned();
              r5._08.set(MEMORY.ref(2, r4 + 0x2).getUnsigned());
              if(r8._16.get() == 0) {
                if(r0 >= 0x600) {
                  r0 = 0x201c000 + r0 * 0x20;
                } else {
                  //LAB_801182e
                  r0 = 0x6004000 + r0 * 0x20;
                }

                r1 = 0x6004000 + r1 * 0x20;
                r2 = r2 * 0x8;
              } else {
                //LAB_801183c
                if(r0 >= 0x200) {
                  r0 = 0x2020000 + r0 * 0x40;
                } else {
                  //LAB_8011852
                  r0 = 0x6008000 + r0 * 0x40;
                }

                //LAB_801185c
                r1 = 0x6008000 + r1 * 0x40;
                r2 = r2 * 0x10;
              }

              //LAB_801185e
              DMA.channels[3].SAD.setu(r0);
              DMA.channels[3].DAD.setu(r1);
              DMA.channels[3].CNT.setu(0x84000000 | r2);

              r5._04.add(0x8);
            } else {
              r2 = r0 & 0xff;
              if(r2 == 0xff) {
                break;
              }
              r5._04.set(r5._00.get() + r2 * 0x4);
            }
          }
        } while(true);
      }

      //LAB_8011872
    }
  }

  @Method(0x80118a8)
  public static void FUN_80118a8(final int r0) {
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._18.get(r0)._0a.set(0);
  }

  @Method(0x80118c0)
  public static void FUN_80118c0(final int r0) {
    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._18.get(r0)._0a.set(0x1);
  }

  @Method(0x80118d8)
  public static void FUN_80118d8(final int r0) {
    final Map194 r5 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5._18.getAddress());
    DMA.channels[3].CNT.setu(0x85000030);

    int r4 = r0;
    int r6 = 0;

    int r1 = MEMORY.ref(2, r4).getUnsigned();
    r4 += 0x2;

    //LAB_801191a
    while(r1 != 0xffff) {
      if((r1 & 0xff00) == 0xfd00) {
        final int r0_0;
        if((r1 & 0x80) != 0) {
          r0_0 = 1;
        } else {
          r0_0 = 0;
        }

        //LAB_8011936
        final Map194.Sub0c r3 = r5._18.get(r1 & 0xf);
        r3._00.set(r4);
        r3._04.set(r4);
        r3._08.set(0);
        r3._0a.set(r0_0);
        r6++;
      }

      //LAB_801194a
      r1 = MEMORY.ref(2, r4).getUnsigned();
      r4 += 0x2;
    }

    //LAB_8011954
    if(r6 != 0) {
      setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801179c"), 0xc80);
    }

    //LAB_8011962
    CPU.sp().value += 0x4;
  }

  @Method(0x80119cc)
  public static void FUN_80119cc() {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Map194.Sub0c r4 = r3._d8;

    if(r4._00.get() != 0 && r4._0a.get() == 0) {
      //LAB_80119e4
      do {
        if(r4._08.get() != 0) {
          //LAB_8011a60
          r4._08.decr();
          break;
        }

        int r0 = r4._04.get();
        final int r1 = MEMORY.ref(2, r0).getUnsigned();
        r0 += 0x2;

        if(r1 == 0xffff) {
          r4._04.set(r4._00.get());
          //LAB_80119fe
        } else if((r1 & 0xff00) == 0xfe00) {
          final int r2 = r1 & 0xff;
          if(r2 == 0xff) {
            break;
          }

          r4._04.set(r4._00.get() + r2 * 0x4);
          //LAB_8011a1e
        } else if((r1 & 0xf000) == 0x3000) {
          GPU.BLDCNT.setu(r1);
          r3._103.set(r1 & 0xff);
          r4._04.add(0x2);
        } else {
          //LAB_8011a3e
          if((r3._103.get() & 0xc0) == 0x40) {
            GPU.BLDALPHA.setu(r1);
          } else {
            //LAB_8011a50
            GPU.BLDY.setu(r1);
          }

          //LAB_8011a52
          r4._08.set(MEMORY.ref(2, r0).getUnsigned());
          r4._04.add(0x4);
        }
      } while(true);
    }

    //LAB_8011a66
  }

  @Method(0x8011a84)
  public static void FUN_8011a84(final int r0) {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final Map194.Sub0c r4 = r3._d8;

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r4.getAddress());
    DMA.channels[3].CNT.setu(0x85000003);
    CPU.sp().value += 0x4;

    if(MEMORY.ref(2, r0).getUnsigned() != 0xffff) {
      r4._00.set(r0);
      r4._04.set(r0);
      r4._08.set(0);
      r4._0a.set(0);
      setTickCallback(getRunnable(GoldenSun_801.class, "FUN_80119cc"), 0xc80);
    }

    //LAB_8011ac2
  }

  @Method(0x8011ce0)
  public static int FUN_8011ce0(int r0, final int r1, final int r2) {
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.lslT(r0, 24);
    r0 = CPU.asrT(r0, 24);
    r0 = CPU.lslT(r0, 19);
    return r0;
  }

  @Method(0x8011cec)
  public static int FUN_8011cec(final int r0, final int r1, int r2) {
    r2 = MEMORY.ref(1, r0).get() << 19;
    return r2 + r1 * ((MEMORY.ref(1, r0 + 0x1).get() << 19) - r2) / 0x10;
  }

  @Method(0x8011f54)
  public static int FUN_8011f54(final int r0, final int r1, final int r2) {
    final int r1_0 = boardWramMallocHead_3001e50.offset(8 * 0x4).get();
    final int r2_0;
    if(r1_0 != 0) {
      r2_0 = MEMORY.ref(4, r1_0, Map194::new)._104.get(r0 & 0x3)._2c.get();
    } else {
      r2_0 = 0x2010000;
    }

    final int r5 = r1 >> 16;
    final int r6 = r2 >> 16;

    //LAB_8011f7a
    final int r1_1 = MEMORY.ref(1, r2_0 + (r6 / 0x10 * 0x80 + r5 / 0x10) * 0x4 + 0x3).getUnsigned() * 0x4;
    return _80134fc.get(MEMORY.ref(1, 0x202c000 + r1_1).getUnsigned() & 0xf).deref().run(0x202c001 + r1_1, r5 & 0xf, r6 & 0xf);
  }

  @Method(0x8012330)
  public static void FUN_8012330(final int r0, final int r1, final int r2) {
    final Map194 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);

    if(r0 >= 0) {
      r3._04.set(r0);
    }

    //LAB_801233c
    if(r1 >= 0) {
      r3._08.set(r1);
    }

    //LAB_8012342
    if(r2 >= 0) {
      r3._0c.set(r2);
    }

    //LAB_8012348
  }

  @Method(0x8015000)
  public static void FUN_8015000() {
    MEMORY.call(0x8015f30);
  }

  @Method(0x8015020)
  public static void FUN_8015020(final int r0, final int r1) {
    FUN_801964c(r0, r1);
  }

  @Method(0x8015038)
  public static GraphicsStruct24 FUN_8015038(final int r0, final int r1, final int r2, final int r3) {
    return (GraphicsStruct24)MEMORY.call(0x8017658, r0, r1, r2, r3);
  }

  @Method(0x8015040)
  public static void FUN_8015040(final int r0, final int r1) {
    MEMORY.call(0x801776c, r0, r1);
  }

  @Method(0x8015048)
  public static int FUN_8015048() {
    return (int)MEMORY.call(0x8017364);
  }

  @Method(0x8015050)
  public static int FUN_8015050(final GraphicsStruct24 r0) {
    return (int)MEMORY.call(0x8017394, r0);
  }

  @Method(0x80150f8)
  public static GraphicsStruct24 FUN_80150f8(final int r0, final int r1, final int r2, final int r3) {
    return (GraphicsStruct24)MEMORY.call(0x8019da8, r0, r1, r2, r3);
  }

  @Method(0x8015100)
  public static void FUN_8015100(final int r0) {
    MEMORY.call(0x8019e48, r0);
  }

  @Method(0x8015108)
  public static int FUN_8015108(final int r0, final int r1, final int r2, final int r3, final int a4) {
    return (int)MEMORY.call(0x80187ac, r0, r1, r2, r3, a4);
  }

  @Method(0x8015110)
  public static int FUN_8015110(final int r0, final int r1, final int r2, final int r3, final int a4) {
    return (int)MEMORY.call(0x80187fc, r0, r1, r2, r3, a4);
  }

  @Method(0x8015120)
  public static void FUN_8015120(final int r0, final int r1) {
    MEMORY.call(0x8019908, r0, r1);
  }

  @Method(0x8015140)
  public static void FUN_8015140() {
    MEMORY.call(0x8019a54);
  }

  @Method(0x80151e0)
  public static int FUN_80151e0(final int r0) {
    return (int)MEMORY.call(0x8019d2c, r0);
  }

  @Method(0x80151e8)
  public static int FUN_80151e8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015200)
  public static void FUN_8015200(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015208)
  public static void FUN_8015208() {
    MEMORY.call(0x801c428);
  }

  @Method(0x8015210)
  public static void FUN_8015210(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8019aa0, r0, r1, r2);
  }

  @Method(0x8015268)
  public static void FUN_8015268(final int r0) {
    MEMORY.call(0x801edec, r0);
  }

  @Method(0x8015288)
  public static int FUN_8015288() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015290)
  public static int FUN_8015290() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015318)
  public static int FUN_8015318() {
    return (int)MEMORY.call(0x801f77d);
  }

  @Method(0x8015320)
  public static int FUN_8015320(final int r0) {
    return (int)MEMORY.call(0x8020bd8, r0);
  }

  @Method(0x8015360)
  public static void FUN_8015360(final int r0, final int r1) {
    MEMORY.call(0x801ccc0, r0, r1);
  }

  @Method(0x8015370)
  public static int FUN_8015370(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun_802#FUN_8028df4} */
  @Method(0x8015390)
  public static int FUN_8015390(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x8028df4, r0, r1, r2, r3);
  }

  @Method(0x8015e8c)
  public static @Nullable GraphicsStruct1c FUN_8015e8c() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final GraphicsStruct1c r0 = r3._d98.derefNullable();
    if(r0 != null) {
      final GraphicsStruct1c r2 = r0._00.derefNullable();
      if(r2 == null) {
        r3._d9c.set(r3._d98);
      }

      //LAB_8015ea8
      r3._d98.setNullable(r2);
      r0._00.clear();
    }

    //LAB_8015eae
    return r0;
  }

  @Method(0x8015ec0)
  public static void FUN_8015ec0(final GraphicsStruct1c r0) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r0.getAddress() >= r2._698.getAddress() && r0.getAddress() < r2._d98.getAddress()) {
      final Pointer<GraphicsStruct1c> r2_0 = r2._d9c.deref();
      r2._d9c.set(r0._00);
      r2_0.set(r0);
      r0._00.clear();
    }

    //LAB_8015ee6
  }

  @Method(0x8015ef4)
  public static void FUN_8015ef4() {
    final Struct12fc r0 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r0._d98.set(r0._698.get(0));

    //LAB_8015f08
    for(int i = 0; i < 0x3f; i++) {
      r0._698.get(i)._00.set(r0._698.get(i + 1));
    }

    r0._698.get(63)._00.clear();
    r0._d9c.set(r0._698.get(63)._00);
  }

  @Method(0x8015f30)
  public static void FUN_8015f30() {
    final Struct12fc addr = MEMORY.ref(4, mallocSlotBoard(15, 0x12fc), Struct12fc::new);

    CPU.sp().value -= 0x4;
    final int r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr.getAddress());
    DMA.channels[3].CNT.setu(0x850004bf);

    MEMORY.ref(4, r5).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(addr._00.getAddress());
    DMA.channels[3].CNT.setu(0x85000140);

    addr._ea3.set(0x1);
    addr._ea7.set(0xf);
    addr.vramSlot_12b6.set(0x63);

    FUN_8015ef4();
    FUN_8019d0c();
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_80160fc"), 0x480);
    FUN_80173f4();
    CPU.sp().value += 0x4;
  }

  /** Called from interrupt handler */
  @Method(0x80160fc)
  public static void FUN_80160fc() {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(r7._ea6.get() == 0) {
      int r4 = r7._ea3.get();
      if(r4 != 0) {
        if((r4 & 0x1) != 0) {
          r4 = 0x3f;
        }

        //LAB_8016126
        r4 = (r4 & 0x3f) >>> 1;

        //LAB_8016134
        for(int i = 0; r4 != 0; i++) {
          if((r4 & 0x1) != 0) {
            // Loads textbox backgrounds into vram
            DMA.channels[3].SAD.setu(r7._00.get(i).getAddress());
            DMA.channels[3].DAD.setu(0x6002000 + i * 0x100);
            DMA.channels[3].CNT.setu(0x84000040);
          }

          //LAB_801614a
          r4 = r4 >>> 1;
        }

        r7._ea3.set(0);
      }
    }

    //LAB_801615a
  }

  /** Clears the textbox render buffer */
  @Method(0x8016178)
  public static void FUN_8016178(final int r0, final int r1, final int r2, final int r3) {
    final Struct12fc r10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r5 = r10._00.getAddress() + (r1 * 0x20 + r0) * 0x2; //TODO

    int r7;
    if(r1 + r3 > 20) {
      r7 = 20 - r1;
    } else {
      r7 = r3;
    }

    //LAB_80161a6
    final int r6 = MathHelper.clamp(r2, 2, 30);
    r7 = MathHelper.clamp(r7, 2, 30);

    //LAB_80161be
    FUN_801e260(r0, r1, r6, r7);

    final int r1_0 = (0x20 - r6) * 0x2;

    //LAB_80161dc
    int r4 = 0xf000;
    for(int r2_0 = 0; r2_0 < r7; r2_0++) {
      if(r10._ea5.get() != 0) {
        if(r1 + r2_0 <= 0x10) {
          r4 = 0xf000;
        } else {
          r4 = 0xf07f;
        }
      }

      //LAB_80161f0
      //LAB_80161f6
      for(int r3_0 = 0; r3_0 < r6; r3_0++) {
        MEMORY.ref(2, r5).setu(r4);
        r5 = r5 + 0x2;
      }

      //LAB_8016200
      r5 = r5 + r1_0;
    }

    //LAB_8016208
    r10._ea3.set(0x1);
  }

  @Method(0x8016230)
  public static void FUN_8016230(final GraphicsStruct24 r0) {
    r0._1a.set(0);

    final Struct12fc r10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r2 = r0._16.get();
    final int r5 = r0._0c.get();
    final int r6 = r0._0e.get();
    final int r7 = r0._08.get();
    final int r8 = r0._0a.get();

    if((r2 & 0x8) != 0) {
      if((r2 & 0x20) != 0) {
        FUN_80170f8(r5, r6, r7, r8);
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0x44444444);
      } else {
        //LAB_801627c
        MEMORY.call(0x3000168, 0x6002500, 0xf00, 0);
      }

      //LAB_801628a
      FUN_8017248(r5, r6, r7, r8, 0);
    } else {
      //LAB_801629c
      FUN_80170f8(r5, r6, r7, r8);
    }

    //LAB_80162a8
    r10._ea3.set(0x1);
  }

  @Method(0x80162d4)
  public static GraphicsStruct24 FUN_80162d4(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final Struct12fc addr = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    for(int i = 0; i < 8; i++) {
      final GraphicsStruct24 struct = addr._500.get(i);

      if((struct._16.get() & 0x1) == 0 && struct._1a.get() == 0) {
        //LAB_8016318
        struct._0e.set(r1);
        struct._08.set(r2);
        struct._0a.set(r3);
        struct._0c.set(r0);
        struct._14.set(0);
        struct._00.clear();
        struct._04.set(struct); // why?
        struct._10.set(0x1);
        struct._16.set(0x1);
        FUN_80173ac();

        if((a4 & 0x8) != 0) {
          struct._16.or(0x8);
        }

        //LAB_8016352
        if((a4 & 0x20) != 0) {
          struct._16.or(0x20);
        }

        //LAB_8016362
        if((a4 & 0x40) != 0) {
          struct._16.or(0x40);
        }

        //LAB_8016380
        if((a4 & 0x80) != 0) {
          struct._16.or(0x80);
        }

        //LAB_8016390
        if((a4 & 0x100) != 0) {
          struct._16.or(0x100);
        }

        //LAB_80163a4
        if((a4 & 0x2) != 0) {
          struct._16.or(0x2);
          struct._18.set(0);
          struct._1a.set(0x1);
          FUN_8016230(struct);
        } else {
          //LAB_80163ce
          struct._18.set(0x7);
          struct._1a.set(0x8);
          FUN_80163ec(struct);
          sleep(1);
        }

        //LAB_80163e0
        return struct;
      }
    }

    return null;
  }

  @Method(0x80163ec)
  public static void FUN_80163ec(final GraphicsStruct24 r0) {
    if((r0._16.get() & 0x2) == 0) {
      //LAB_8016402
      while(r0._1a.get() != 0) {
        sleep(1);
      }
    }

    //LAB_8016410
  }

  @Method(0x8016418)
  public static void FUN_8016418(@Nullable final GraphicsStruct24 r0, final int r1) {
    if(r0 != null) {
      FUN_8016478(r0);
      r0._16.set(0);
      r0._1c.set(r0._0c.get());
      r0._1e.set(r0._0e.get());
      r0._20.set(r0._08.get());
      r0._22.set(r0._0a.get());
      if(r1 != 0) {
        FUN_8016178(r0._0c.get(), r0._0e.get(), r0._08.get(), r0._0a.get());
        r0._00.clear();
        r0._04.clear();
        r0._08.set(0);
        r0._0a.set(0);
        r0._0c.set(0);
        r0._0e.set(0);
        r0._10.set(0);
        r0._12.set(0);
        r0._14.set(0);
        r0._16.set(0);
        r0._18.set(0);
        r0._1a.set(0);
        r0._1c.set(0);
        r0._1e.set(0);
        r0._20.set(0);
        r0._22.set(0);
      } else {
        //LAB_801646c
        r0._18.set(r1);
        r0._1a.set(0x4);
      }
    }

    //LAB_8016472
  }

  @Method(0x8016478)
  public static void FUN_8016478(final GraphicsStruct24 r0) {
    if((r0._16.get() & 0x8) == 0) {
      FUN_8016498(r0);
      FUN_80164ac(r0);
    }

    //LAB_8016490
  }

  @Method(0x8016498)
  public static void FUN_8016498(final GraphicsStruct24 r0) {
    FUN_80170f8(r0._0c.get(), r0._0e.get(), r0._08.get(), r0._0a.get());
  }

  @Method(0x80164ac)
  public static void FUN_80164ac(@Nullable final GraphicsStruct24 r3) {
    if(r3 != null) {
      GraphicsStruct1c r0 = r3._00.derefNullable();
      r3._04.set(r3);
      r3._00.clear();

      //LAB_80164c0
      while(r0 != null) {
        final GraphicsStruct1c r5 = r0._00.derefNullable();
        FUN_8016594(r0);
        r0 = r5;
      }
    }

    //LAB_80164cc
  }

  @Method(0x8016584)
  public static void FUN_8016584(@Nullable final GraphicsStruct24 r0, final GraphicsStruct1c r1) {
    if(r0 != null) {
      final GraphicsStruct24 r3 = r0._04.deref();
      r3._00.set(r1);
      r0._04.setPointer(r1.getAddress()); //TODO huh?
    }

    //LAB_8016590
  }

  @Method(0x8016594)
  public static void FUN_8016594(final GraphicsStruct1c r0) {
    FUN_8015ec0(r0);

    if(r0._04.get() != 0) {
      clearVramSlot(r0.slot_0e.get());

      if(r0._04.get() == 2) {
        final Struct12fc r1 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
        r1._12d0.get(r0.packet_10.attribs_04.getPaletteNumber()).set(999);
      }
    }

    //LAB_80165c0
    r0._05.set(0);
  }

  @Method(0x80165d8)
  public static GraphicsStruct28 FUN_80165d8(final GraphicsStruct24 r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    final ArrayRef<GraphicsStruct28> r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;
    GraphicsStruct28 r0_0 = null;

    //LAB_80165fe
    //LAB_80165f4
    for(int i = 0; i < 3; i++) {
      final GraphicsStruct28 struct = r4.get(i);

      if(struct._00.isNull()) {
        r0_0 = struct;
        break;
      }
    }

    //LAB_8016604
    if(r0_0 == null) {
      return null;
    }

    r0_0._00.set(r0);
    r0_0._04.set(r2 << 8);
    r0_0._06.set(r3 << 8);
    r0_0._12.set(r1);
    r0_0._14.set(0);
    r0_0._16.set(0xf);
    r0_0._18.set(0);
    r0_0._1a.set(0xa);
    r0_0._1e.set(r2 << 8);
    r0_0._20.set(0);
    r0_0._24.set(a5);

    if(a4 != 0) {
      //LAB_8016636
      for(int i = 0; i < 4; i++) {
        r0_0._08.get(i).set(MEMORY.ref(2, a4 + i * 0x2).getUnsigned());
      }
    } else {
      //LAB_801664c
      //LAB_8016654
      for(int i = 0; i < 4; i++) {
        r0_0._08.get(i).set(0);
      }
    }

    //LAB_8016664
    r0_0._10.set(0);

    //LAB_8016668
    return r0_0;
  }

  @Method(0x80167ac)
  public static void FUN_80167ac(final GraphicsStruct28 r0) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r2._eae.set(r0._16.get());
    r2._eac.set(r0._18.get());
    r2._ea8.set(r0._1a.get());
  }

  @Method(0x80167d8)
  public static void FUN_80167d8(final GraphicsStruct28 r0) {
    r0._1c.set(0x2);
  }

  @Method(0x80167e0)
  public static void FUN_80167e0(final int r0) {
    //LAB_8016818
    for(int r7 = 0; r7 < 30; r7++) {
      DMA.channels[3].SAD.setu(0x6002520 + r7 * 0x80 + r0 * 0x18);
      DMA.channels[3].DAD.setu(0x6002520 + r7 * 0x80);
      DMA.channels[3].CNT.setu(0x84000000 | 0x18 - r0 * 0x6);

      MEMORY.call(0x3000168, 0x6002500 + r7 * 0x80 + (0x20 - r0 * 0x6) * 0x4, r0 * 0x18, 0); // memfill
    }
  }

  @Method(0x8016868)
  public static void FUN_8016868() {
    final ArrayRef<GraphicsStruct28> addr = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_801687e
    for(int r7 = 0; r7 < 3; r7++) {
      final GraphicsStruct28 r5 = addr.get(r7);

      final GraphicsStruct24 r2 = r5._00.derefNullable();
      if(r2 != null) {
        if(r2._18.get() == 0 && r2._1a.get() == 0) {
          if(r2._16.get() == 0) {
            r5._00.clear();
          } else {
            //LAB_8016894
            if(r2._12.get() != 0) {
              FUN_8019854(r5);
            } else {
              //LAB_80168a2
              final int r0 = FUN_80168f4(r5);

              if(r0 == 8) {
                //LAB_80168b2
                r5._00.deref()._14.set(0x1); // Without this, "catch" and the "have you got everything" dialogues will not advance
              } else if(r0 == 9) {
                //LAB_80168b8
                final GraphicsStruct24 r0_0 = r5._00.deref();
                FUN_8016418(r0_0, r0_0._16.get() & 0x2);
                r5._04.set(0);
                r5._06.set(0);
                r5._12.set(0);
                r5._14.set(0);
                r5._16.set(0);
                r5._18.set(0);
                r5._1a.set(0);
                r0_0._14.set(0x1);
              }
            }
          }
        }
      }

      //LAB_80168dc
    }
  }

  @Method(0x80168f4)
  public static int FUN_80168f4(final GraphicsStruct28 r6) {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r7;
    int r10;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r3 = _200044c.get();
    r2 = MEMORY.ref(1, 0x807380b + r3).getUnsigned();
    CPU.sp().value -= 0x34;
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2);
    if(r8._ea5.get() != 0) {
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(MathHelper.clamp(_3001cd0.getUnsigned(), 0, 2) * 5 + 3);
    }

    //LAB_8016944
    if(r6._1c.get() != 0) {
      FUN_80167e0(0x1);
      r6._1c.decr();

      CPU.sp().value += 0x34;
      return 0;
    }

    //LAB_8016958
    if(heldButtonsLastFrame_3001ae8.get() == 0 && r6._22.get() != 0) {
      r6._22.decr();

      CPU.sp().value += 0x34;
      return 0;
    }

    //LAB_8016972
    do {
      if(r6._20.get() == 0) {
        r7 = r8.text_eb0.get(r6._12.get()).get();
      } else {
        r7 = 0;
      }

      //LAB_8016988
      jmp_8016ede:
      {
        switch(r7) {
          case 0x3:
            r6._04.set(r6._1e.get());

            if((r6._00.deref()._16.get() & 0x8) == 0) {
              //LAB_8016a42
              r6._06.add(0xf00);

              if(r6._10.get() <= 2) {
                //LAB_8016a56
                r6._10.incr();
              }
            } else if(r6._06.get() > 0xcff) {
              FUN_80167d8(r6);
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            } else {
              //LAB_8016a38
              r6._06.add(0xd00);
            }
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x1:
            if(r8._ea4.get() != 0 && r6._14.get() < 0x384) {
              accumulatedButtons_3001af8.set(0);
            }

            //LAB_8016a9a
            r6._14.set(0x397);
            if(FUN_80199ec(r6) == 0) {
              final GraphicsStruct24 r0_0 = r6._00.deref();
              if(r0_0._08.get() != 0) {
                //LAB_8016ab4
                if(r0_0._0a.get() != 0) {
                  //LAB_8016abc
                  if(r8._12f8.get() == 0) {
                    //LAB_8016ac8
                    FUN_8018cac(r0_0, 0x1, r0_0._08.get() * 4 - 8, r0_0._0a.get() * 8 - 16, 0x1);
                    r8._12f8.set(0x1);
                  }
                }
              }
            } else {
              //LAB_8016afa
              final GraphicsStruct24 r5 = r6._00.deref();
              MEMORY.ref(4, CPU.sp().value + 0x30).setu(r5._0c.get());
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5._08.get());
              MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r5._0e.get());
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5._0a.get());
              r8._12f8.set(0);
              MEMORY.ref(4, CPU.sp().value + 0xc).setu(r6._12.get());
              FUN_8016478(r5);
              r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
              if(r6._24.get() == 0 && (r5._08.get() | r5._0a.get()) != 0) {
                FUN_8016178(r5._0c.get(), r5._0e.get(), r5._08.get(), r5._0a.get());
              }

              //LAB_8016b3c
              r4 = CPU.addT(r4, 0x1);
              r4 = CPU.andT(r4, 0x1ff);
              if(r8.text_eb0.get(r4).get() != 0) {
                if((r5._0a.get() | r5._08.get()) != 0) {
                  r7 = r6._24.get();
                  if(r7 != 0) {
                    FUN_8016178(r5._0c.get(), r5._0e.get(), r5._08.get(), r5._0a.get());
                  } else {
                    //LAB_8016b70
                    FUN_801868c(r4, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24, r6._08, r7);

                    r1 = r5._16.get();
                    if((r1 & 0x80) != 0) {
                      r2 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
                      r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                      if(r3 != r2) {
                        MEMORY.ref(4, CPU.sp().value + 0x2c).subu(r2 - r3);
                      }

                      //LAB_8016bb8
                      if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() < 0) {
                        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r7);
                      }
                    }

                    //LAB_8016bc0
                    if((r1 & 0x100) == 0) {
                      MEMORY.ref(4, CPU.sp().value + 0x30).setu(MEMORY.ref(4, CPU.sp().value + 0x30).get() + (MEMORY.ref(4, CPU.sp().value + 0x1c).get() - MEMORY.ref(4, CPU.sp().value + 0x28).get()) / 4);
                      FUN_801868c(r4, CPU.sp().value + 0x30, CPU.sp().value + 0x2c, CPU.sp().value + 0x28, CPU.sp().value + 0x24, r6._08, 0x2);
                    }

                    //LAB_8016bf6
                    r5._0c.set(MEMORY.ref(4, CPU.sp().value + 0x30).get());
                    r5._0e.set(MEMORY.ref(4, CPU.sp().value + 0x2c).get());
                    r5._08.set(MEMORY.ref(4, CPU.sp().value + 0x28).get());
                    r5._0a.set(MEMORY.ref(4, CPU.sp().value + 0x24).get());
                  }

                  //LAB_8016c06
                  FUN_80170f8(r5._0c.get(), r5._0e.get(), r5._08.get(), r5._0a.get());
                }
              }

              //LAB_8016c12
              r6._04.set(r6._1e.get());
              r6._06.set(0);
              r6._10.set(0);
              clearVramSlot(r8.vramSlot_12b6.get());
              r8.vramSlot_12b6.set(0x63);
            }
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x2:
            if(r8._ea4.get() != 0 && r6._14.get() < 0x384) {
              accumulatedButtons_3001af8.set(0);
            }

            //LAB_8016c46
            if(FUN_80199ec(r6) != 0) {
              //LAB_801696e
              CPU.sp().value += 0x34;
              return 0x9;
            }

            //LAB_8016c52
            r6._14.set(0x397);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x5:
            if(r6._14.get() == 0) {
              r6._14.set(0x14);
            }

            r8._12f6.set(0);
            FUN_801999c(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x6:
            if(r6._14.get() == 0) {
              r6._14.set(0x78);
            }

            //LAB_8016c6c
            r8._12f6.set(0);
            FUN_801999c(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x4:
            if(r6._14.get() == 0) {
              r6._14.set(0x3c);
            }

            //LAB_8016c86
            r8._12f6.set(0);

            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x8:
            r6._12.incr().and(0x1ff);
            r6._16.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x9:
            r6._12.incr().and(0x1ff);
            r6._18.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0xa:
            r6._12.incr().and(0x1ff);
            r6._1a.set(r8.text_eb0.get(r6._12.get()).get());
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x7:
            r6._16.set(0xf);
            r6._18.set(0);
            r6._1a.set(0xa);
            FUN_80167ac(r6);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0xf:
            r6._12.incr().and(0x1ff);
            r6._00.deref()._12.set(r8.text_eb0.get(r6._12.get()).get());
            r6._12.incr().and(0x1ff);
            r6._14.set(0xa);
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;

          case 0x0:
          case 0x1e:
            r6._20.set(0x1);
            CPU.sp().value += 0x34;
            return 0x8;

          case 0xb:
          case 0xc:
          case 0xd:
          case 0xe:
          case 0x10:
          case 0x11:
          case 0x12:
          case 0x13:
          case 0x14:
          case 0x15:
          case 0x16:
          case 0x17:
          case 0x18:
          case 0x19:
          case 0x1a:
          case 0x1b:
          case 0x1c:
          case 0x1d:
            //LAB_8016d64
            if(r8._ea5.get() == 0) {
              //LAB_8016d70
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
            }
            break jmp_8016ede;
        }

        //LAB_8016d76
        r3 = r6._04.get();
        r2 = CPU.addT(r3, 0x0);
        r2 = CPU.addT(r2, 0x80);
        if(r2 < 0) {
          r2 = r3 + 0x17f;
        }

        //LAB_8016d84
        int r5_0 = CPU.asrT(r2, 8);
        r2 = r6._06.get();
        r3 = CPU.addT(r2, 0x0);
        r3 = CPU.addT(r3, 0x80);
        if(r3 < 0) {
          r3 = r2 + 0x17f;
        }

        //LAB_8016d94
        r3 = CPU.asrT(r3, 8);
        CPU.r12().value = r3;
        r3 = _200044c.get();
        r2 = MEMORY.ref(1, 0x807380e + r3).getUnsigned();
        r3 = r8._ea4.get();
        r10 = r2;
        r2 = r6._12.get();
        if(r3 != 0) {
          r5_0 = CPU.addT(r5_0, 0x8);
        }

        //LAB_8016db6
        r3 = CPU.addT(r2, 0x1);
        r3 = CPU.andT(r3, 0x1ff);
        r4 = r8.text_eb0.get(r3).get();
        if(r4 == 0xde) {
          r7 = r7 | 0x4000;
          r6._12.incr().and(0x1ff);
          //LAB_8016dec
        } else if(r4 == 0xdf) {
          r7 = r7 | 0x8000;
          r6._12.incr().and(0x1ff);
        }

        //LAB_8016dfe
        if((r6._00.deref()._16.get() & 0x8) == 0) {
          CPU.cmpT(r7, 0x20);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            CPU.cmpT(r4, 0x20);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r3 = MEMORY.ref(2, 0x8032224 + (r7 - 0x20) * 0x20).getUnsigned() + MEMORY.ref(2, 0x8032224 + (r4 - 0x20) * 0x20).getUnsigned();
              if(r3 >= 0 && r3 < 0x10) {
                r7 = r4 << 8 | r7;
                r6._12.incr().and(0x1ff);
              }
            }
          }
        }

        //LAB_8016e3e
        r4 = FUN_8018cac(r6._00.deref(), r7, r5_0, CPU.r12().value, 0);
        r3 = _200044c.get();
        r3 = MEMORY.ref(1, 0x8073808 + r3).getUnsigned();
        r6._22.set(r3);
        if(r4 != 0) {
          if(r8._12f4.get() != 0) {
            if(r8._12f6.get() == 0) {
              if(r7 != 0x20) {
                FUN_80f9010(r8._12f4.get() + (r7 & 0x3));
                r8._12f6.set(r10);
              }
            } else {
              //LAB_8016eb0
              r8._12f6.decr();
            }
          }

          //LAB_8016eb6
          r0 = r4 << 8;
          if(r7 == 0x20) {
            r0 = r0 + r6._08.get(r6._10.get()).get();
          }

          //LAB_8016ec6
          r6._04.add(r0); //TODO overflowver
        }

        //LAB_8016ecc
        if(r7 == 0x20 && r8._ea5.get() == 0) {
          MEMORY.ref(4, CPU.sp().value + 0x20).setu(0x1);
        }
      }

      //LAB_8016ede
      //NOTE inline decr
      if(r6._14.get() == 0 || r6._14.decr().get() == 0) {
        //LAB_8016ef2
        r6._12.incr().and(0x1ff);
      }

      //LAB_8016efc
      MEMORY.ref(4, CPU.sp().value + 0x20).decr();
    } while(MEMORY.ref(4, CPU.sp().value + 0x20).get() != 0);

    //LAB_8016f08
    //LAB_8016f18
    //LAB_8016f1a
    CPU.sp().value += 0x34;
    return 0;
  }

  @Method(0x8016f2c)
  public static void FUN_8016f2c() {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_8016f40
    for(int i = 0; i < 8; i++) {
      final GraphicsStruct24 r5 = r7._500.get(i);

      if(r5._16.get() != 0) {
        if(r5._18.get() != 0) {
          FUN_8017004(r5, 0);
          r5._18.decr();
          //LAB_8016f5e
        } else if(r5._1a.get() != 0) {
          FUN_8016230(r5);
        }
      } else {
        //LAB_8016f6e
        final int r2 = r5._1a.get();
        if(r2 != 0) {
          if(r5._18.get() != r2) {
            FUN_8016178(r5._1c.get(), r5._1e.get(), r5._20.get(), r5._22.get());
            FUN_8017004(r5, 0x1);
            r5._18.incr();
            r7._ea3.set(0x1);
          } else {
            //LAB_8016faa
            FUN_8016178(r5._1c.get(), r5._1e.get(), r5._20.get(), r5._22.get());
            r5._00.clear();
            r5._04.clear();
            r5._08.set(0);
            r5._0a.set(0);
            r5._0c.set(0);
            r5._0e.set(0);
            r5._10.set(0);
            r5._12.set(0);
            r5._14.set(0);
            r5._16.set(0);
            r5._18.set(0);
            r5._1a.set(0);
            r5._1c.set(0);
            r5._1e.set(0);
            r5._20.set(0);
            r5._22.set(0);
            r7._ea3.set(0x1);
          }
        }
      }

      //LAB_8016fe6
    }
  }

  @Method(0x8017004)
  public static void FUN_8017004(final GraphicsStruct24 r7, int r1) {
    int r0;
    int r3;
    int r5;
    int r6;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);

    CPU.sp().value -= 0x10;
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r6 = r7._18.get();
    r0 = r7._1a.get();
    r3 = r0 - r6;
    CPU.r10().value = r3;
    r1 = r7._08.get() * r6;
    r5 = CPU.sp().value + 0x4;
    r1 = CPU.lslT(r1, 16);
    r0 = CPU.lslT(r0, 17);
    MEMORY.ref(4, r5).setu(r1);
    MEMORY.ref(4, r5 + 0x4).setu(r0);
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
    r3 = r7._0c.get();
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 16);
    r0 = CPU.addT(r0, r3);
    r1 = CPU.r10().value * r7._08.get();
    r1 = CPU.lslT(r1, 16);
    MEMORY.ref(4, r5).setu(r1);
    CPU.r9().value = r0;
    r0 = MEMORY.ref(4, r5 + 0x4).get();
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
    r1 = r7._0a.get() * r6;
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 15);
    CPU.r11().value = r0;
    r0 = r7._1a.get();
    r1 = CPU.lslT(r1, 16);
    r0 = CPU.lslT(r0, 17);
    MEMORY.ref(4, r5).setu(r1);
    MEMORY.ref(4, r5 + 0x4).setu(r0);
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
    r3 = r7._0e.get();
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r0 = CPU.asrT(r0, 16);
    r6 = CPU.addT(r0, r3);
    r1 = CPU.r10().value * r7._0a.get();
    r1 = CPU.lslT(r1, 16);
    MEMORY.ref(4, r5).setu(r1);
    r0 = MEMORY.ref(4, r5 + 0x4).get();
    r0 = (int)MEMORY.call(0x300013c, r0, r1);
    MEMORY.ref(4, r5 + 0x8).setu(r0);
    r5 = CPU.asrT(r0, 15);
    FUN_80170f8(CPU.r9().value, r6, CPU.r11().value, r5);

    if(MEMORY.ref(4, CPU.sp().value).get() != 0) {
      r7._1c.set(CPU.r9().value);
      r7._1e.set(r6);
      r7._20.set(CPU.r11().value);
      r7._22.set(r5);
    }

    //LAB_80170ac
    CPU.sp().value += 0x10;

    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80170c4)
  public static int FUN_80170c4(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;

    r4 = CPU.addT(r2, 0x0);
    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.sp().value;
      r2 = CPU.movT(0, 0x81);
      r0 = CPU.addT(r0, 0x2);
      r2 = CPU.lslT(r2, 24);
      MEMORY.ref(2, r0).setu(r1);
      r3 = MEMORY.ref(4, 0x80170f4).get();
      r1 = CPU.addT(r5, 0x0);
      r2 = CPU.orrT(r2, r4);
      MEMORY.ref(4, r3).setu(r0);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r1);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(r2);

      r3 = CPU.lslT(r4, 1);
      r5 = CPU.addT(r5, r3);
    }

    //LAB_80170e8
    CPU.sp().value += 0x4;
    return r5;
  }

  @Method(0x80170f8)
  public static void FUN_80170f8(final int r0, final int r1, final int r2, final int r3) {
    final Struct12fc r11 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r5 = r11._00.getAddress() + (r1 * 0x20 + r0) * 0x2; //TODO
    if(r2 > 1 && r3 > 1 && r2 <= 30 && r3 <= 30) {
      FUN_801e260(r0, r1, r2, r3);

      //LAB_801714c
      MEMORY.ref(2, r5).setu(r11._ea4.get() != 0 ? 0xf01c : 0xf010);
      r5 = r5 + 0x2;
      r5 = FUN_80170c4(r5, 0xf011f011, r2 - 2);

      //LAB_801718a
      MEMORY.ref(2, r5).setu(r11._ea4.get() != 0 ? 0xf41c : 0xf012);
      r5 = r5 + 0x2;
      final int r9 = (0x20 - r2) * 0x2;
      r5 = r5 + r9;

      //LAB_80171a2
      for(int r6 = 1; r6 < r3 - 1; r6++) {
        MEMORY.ref(2, r5).setu(0xf016);
        r5 = r5 + 0x2;

        if(r2 != 2) {
          r5 = FUN_80170c4(r5, 0xf020f020, r2 - 2);
        }

        //LAB_80171ca
        MEMORY.ref(2, r5).setu(0xf017);
        r5 = r5 + r9 + 0x2;
      }

      //LAB_80171d8
      //LAB_80171f6
      MEMORY.ref(2, r5).setu(r11._ea4.get() != 0 ? 0xf81c : 0xf013);
      r5 = FUN_80170c4(r5 + 0x2, 0xf014f014, r2 - 2);

      //LAB_8017226
      MEMORY.ref(2, r5).setu(r11._ea4.get() != 0 ? 0xfc1c : 0xf015);
      r11._ea3.set(0x1);
    }

    //LAB_8017230
  }

  @Method(0x8017248)
  public static void FUN_8017248(final int r0, final int r1, final int r2, final int r3, final int a4) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8017364)
  public static int FUN_8017364() {
    final ArrayRef<GraphicsStruct28> r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_8017372
    for(int r1 = 0; r1 < 3; r1++) {
      final GraphicsStruct24 r3 = r2.get(r1)._00.derefNullable();
      if(r3 != null) {
        if(r3._14.get() == 0) {
          return 0;
        }
      }

      //LAB_8017380
    }

    //LAB_801738a
    return 1;
  }

  @Method(0x8017394)
  public static int FUN_8017394(final GraphicsStruct24 r0) {
    if(r0._16.get() == 0 && r0._1a.get() == 0) {
      return 1;
    }

    return 0;
  }

  @Method(0x80173ac)
  public static void FUN_80173ac() {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r2._ea8.set(10);
    r2._eaa.set(1);
    r2._eac.set(0);
    r2._eae.set(15);
    r2._12b0.set(9);
  }

  @Method(0x80173f4)
  public static void FUN_80173f4() {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r5._12b8.set(FUN_8003fa4(0x5f, 0x2000, 0));
    r5._12b0.set(0x9);
    r5._ea8.set(0xa);
    r5._eac.set(0);
    r5._eae.set(0xf);
    r5.textOffset_12b2.set(0);
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_801789c"), 0xc80);
  }

  @Method(0x8017658)
  public static GraphicsStruct24 FUN_8017658(final int r0, final int r1, final int r2, final int r3) {
    CPU.sp().value -= 0x24;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
    r8._12f4.set(r3 << 4 >>> 20);
    r8._12f6.set(0);
    final int r10 = FUN_8018038(r0, 0x1);

    if(r8.text_eb0.get(r10).get() == 0) {
      CPU.sp().value += 0x24;
      return null;
    }

    final int r9 = CPU.sp().value + 0x1c;
    FUN_801868c(r10, CPU.sp().value + 0x18, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, MEMORY.ref(2, r9, ArrayRef.of(UnsignedShortRef.class, 8, 0x2, UnsignedShortRef::new)), 0); //TODO
    final int r2_0 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    final int r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();

    if(r2_0 == 0 && r4 == 0) {
      CPU.sp().value += 0x24;
      return null;
    }

    //LAB_80176cc
    int r7 = 0;
    if((r3 & 0x1) == 0) {
      r7 = r7 | 0x2;
    }

    //LAB_80176d8
    if((r3 & 0x8) != 0) {
      r7 = r7 | 0x8;
    }

    //LAB_80176e4
    if((r3 & 0x10) != 0) {
      r7 = r7 | 0x80;
    }

    //LAB_80176f0
    if((r3 & 0x20) != 0) {
      r7 = r7 | 0x100;
    }

    //LAB_80176fe
    final GraphicsStruct24 r6 = FUN_80162d4(MEMORY.ref(4, CPU.sp().value + 0x18).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get(), r2_0, r4, r7);
    if(r6 == null) {
      CPU.sp().value += 0x24;
      return null;
    }

    if(FUN_80165d8(r6, r10, 0, 0, r9, 0) == null) {
      FUN_8016418(r6, 0x1);
      CPU.sp().value += 0x24;
      return null;
    }

    //LAB_8017736
    r8._12fa.set(0);
    r8._12fb.set(0);

    //LAB_8017744
    CPU.sp().value += 0x24;
    return r6;
  }

  @Method(0x801776c)
  public static void FUN_801776c(final int r0, final int r1) {
    int r2;
    int r3;

    CPU.sp().value -= 0x1c;

    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    if((r1 & 0x2) != 0) {
      r8._12f9.set(0x1);
    }

    //LAB_80177a2
    MEMORY.ref(4, CPU.sp().value).setu(CPU.sp().value + 0xc);
    FUN_80187ac(r0, CPU.sp().value + 0x18, CPU.sp().value + 0x14, CPU.sp().value + 0x10, MEMORY.ref(4, CPU.sp().value).get());
    r2 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    MEMORY.ref(4, CPU.sp().value + 0x18).setu((30 - r2) / 2);
    r2 = (8 - MEMORY.ref(4, CPU.sp().value + 0xc).get()) / 2;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu((8 - r2) / 2);

    if((r1 & 0x8) != 0) {
      r3 = r2 + 0x4;
    } else {
      //LAB_80177d2
      if((r1 & 0x40) != 0) {
        r3 = r2 + 0xc;
      } else {
        //LAB_80177e0
        FUN_808a278(_2000434.get(), CPU.sp().value + 0x4);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get() >> 3;
        if(r3 > 9) {
          r3 -= 5;
        } else {
          //LAB_80177fe
          r3 += 4;
        }
      }
    }

    //LAB_8017800
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);

    final GraphicsStruct24 r5 = FUN_8017658(r0, MEMORY.ref(4, CPU.sp().value + 0x18).get(), MEMORY.ref(4, CPU.sp().value + 0x14).get(), r1 & 0x1);
    if(r5 != null) {
      //LAB_8017816
      while(FUN_8017364() == 0) {
        sleep(0x1);
      }

      if((r1 & 0x20) != 0) {
        r8._ea6.set(0x1);
      }

      //LAB_8017838
      if((r1 & 0x4) == 0) {
        FUN_8016418(r5, r1 & 0x1);

        //LAB_801784a
        while(FUN_8017394(r5) == 0) {
          sleep(0x1);
        }
      }
    }

    //LAB_801785a
    r8._12f9.set(0);
    r8._12f4.set(0);
    r8._12f6.set(0);
    sleep(0x3);

    CPU.sp().value += 0x1c;
  }

  @Method(0x801789c)
  public static void FUN_801789c() {
    FUN_8016f2c();
    FUN_8016868();
    FUN_80191cc();
  }

  @Method(0x80178b0)
  public static int FUN_80178b0(final int r0, final int r1) {
    CPU.sp().value -= 0x184;

    int r10 = r0 << 8 >> 16;
    final int r5 = r0 & 0xff;
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.call(0x3000164, CPU.sp().value + 0x4, 0x180);

    final int r9;
    final int r11;
    if(r6._ea4.get() != 0) {
      r9 = 0;
      r11 = 0x8;
    } else {
      //LAB_80178f0
      r9 = 1;
      r11 = r6._eae.get();
    }

    //LAB_80178fa
    int r7 = 0x8032224 + (r5 - 0x20) * 0x20; //TODO
    int r8 = MEMORY.ref(2, r7).getUnsigned();
    r7 = r7 + 0x2;
    if(r6._eac.get() == 1) {
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x35, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x36, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x24, r11);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x25, r11);
      r8++;
    } else {
      //LAB_801794c
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x35, r9);
      MEMORY.call(0x3000214, r7, CPU.sp().value + 0x24, r11);
    }

    //LAB_8017964
    int r2 = r10 & 0xffff;
    if(r2 != 0) {
      r7 = 0x8031e24 + r2 * 0x20; //TODO
      r10 = MEMORY.ref(2, r7).get();
      r7 = r7 + 0x2;
      if(r6._eac.get() == 1) {
        final int r6_0 = CPU.sp().value + 0x4 + r8;
        MEMORY.call(0x3000214, r7, r6_0 + 0x31, r9);
        MEMORY.call(0x3000214, r7, r6_0 + 0x32, r9);
        MEMORY.call(0x3000214, r7, r6_0 + 0x20, r11);
        MEMORY.call(0x3000214, r7, r6_0 + 0x21, r11);
        r10 = (short)(r10 + 1);
      } else {
        //LAB_80179ce
        final int r5_0 = CPU.sp().value + 0x4 + r8;
        MEMORY.call(0x3000214, r7, r5_0 + 0x31, r9);
        MEMORY.call(0x3000214, r7, r5_0 + 0x20, r11);
      }

      //LAB_80179ec
      r8 += r10 & 0xffff;
    }

    //LAB_80179f4
    int r1_0 = CPU.sp().value + 0xb;

    //LAB_80179fa
    int sp00 = r1;
    for(int r6_0 = 0; r6_0 < 2; r6_0++) {
      //LAB_80179fc
      for(int r5_0 = 0; r5_0 < 2; r5_0++) {
        //LAB_80179fe
        for(int r4_0 = 0; r4_0 < 8; r4_0++) {
          r2 = 0;

          //LAB_8017a02
          for(int r0_0 = 7; r0_0 >= 0; r0_0--) {
            r2 = MEMORY.ref(1, r1_0).getUnsigned() + r2 * 0x10;
            r1_0--;
          }

          MEMORY.ref(4, sp00).setu(r2);
          sp00 += 0x4;

          r1_0 += 0x18;
        }

        r1_0 -= 0x78;
      }

      r1_0 += 0x70;
    }

    CPU.sp().value += 0x184;
    return r8;
  }

  @Method(0x8017aa4)
  public static void FUN_8017aa4(@Nullable ArrayRef<UnsignedShortRef> str, final GraphicsStruct24 r1, final int r2, final int r3) {
    int r8 = r3;
    int r7 = r2;
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r5 = 0;
    final int r9 = (short)r7;
    if(str == null) {
      //LAB_8017aca
      r6.text_eb0.get(r6.textOffset_12b2.get()).set(0);
      r6.textOffset_12b2.incr().and(0x1ff);
      str = r6.text_eb0;
    }

    int chr = str.get(r5++).get();
    if(chr > 0xff) {
      chr = 0x40;
    }

    //LAB_8017af4
    while(chr != 0) {
      if(chr > 0x1e) {
        //LAB_8017b9a
        if((r1._16.get() & 0x8) == 0) {
          final int nextChr = str.get(r5).get();
          if(chr > ' ') {
            if(nextChr > ' ') {
              final int r3_0 = MEMORY.ref(2, 0x8032224 + (chr - ' ') * 0x20).getUnsigned() + MEMORY.ref(2, 0x8032224 + (nextChr - ' ') * 0x20).getUnsigned();
              if(r3_0 >= 0 && r3_0 < 0x10) {
                chr = nextChr << 8 | chr;
                r5++;
              }
            }
          }
        }

        //LAB_8017bd4
        r7 = r7 + FUN_8018cac(r1, chr, r7, r8, 0);
      } else {
        switch(chr) {
          case 0x8:
            r6._eae.set(str.get(r5++).get());
            break;

          case 0x9:
            r6._eac.set(str.get(r5++).get());
            break;

          case 0xa:
            r6._ea8.set(str.get(r5++).get());
            break;

          case 0xb:
          case 0xc:
          case 0x11:
          case 0x1d:
            //LAB_8017b84
            r5++;
            break;

          case 0x7:
            FUN_80173ac();
            break;

          case 0x3:
            r7 = r9;
            r8 += 0xf;
            break;

          case 0xe:
          case 0xf:
          case 0x1c:
            r5 += 0x2;
            break;
        }
      }

      //LAB_8017be6
      chr = str.get(r5++).get();
      if(chr > 0xff) {
        chr = 0x40;
      }
    }

    //LAB_8017bf6
  }

  /**
   * Convert number to ascii
   *
   * @param r0 output, pointer to individual digits
   * @param number number to split up into digits
   * @param r2 some kind of offset into the number
   * @return pretty sure it returns the address of the number in ascii
   */
  @Method(0x8017dd4)
  public static int convertNumberToAscii(int r0, final int number, final int r2) {
    int r6 = number;
    final int r7 = r0;
    boolean negative = false;
    if(r6 < 0) {
      if(r2 == 0) {
        negative = true;
      }

      //LAB_8017df4
      r6 = -r6;
    }

    //LAB_8017df6
    MEMORY.ref(1, r7).setu(0x20);

    //LAB_8017e00
    //TODO splitting up a base-10 number into digits, could be useful info
    for(int r5 = r7 + 0xc; r5 > r7; r5--) {
      MEMORY.ref(1, r5).setu(modS(r6, 10) + '0');
      r6 = divideS(r6, 10);
      r5--;
    }

    MEMORY.ref(1, r7 + 0xd).setu(0);
    r0 = 0x1;

    jmp_8017e48:
    {
      // replace 0's with spaces
      if(MEMORY.ref(1, r7 + r0).getUnsigned() == '0') {
        MEMORY.ref(1, r7 + r0).setu(' ');

        //LAB_8017e2a
        do {
          r0++;

          //LAB_8017e2e
          if(r0 == 0xd) {
            break jmp_8017e48;
          }
          if(MEMORY.ref(1, r7 + r0).getUnsigned() != '0') {
            break;
          }
          if(r0 != 0xc) {
            MEMORY.ref(1, r7 + r0).setu(' ');
          }
        } while(true);
      }

      //LAB_8017e40
      // add - if applicable
      if(negative) {
        MEMORY.ref(1, r7 + r0 - 1).setu('-');
      }
    }

    //LAB_8017e48
    if(r2 == 0) {
      r0 = 0;

      //LAB_8017e58
      while(MEMORY.ref(1, r7 + r0).getUnsigned() == ' ') {
        r0++;
        if(r0 == 0xc) {
          break;
        }
      }

      //LAB_8017e66
      r0 = r7 + r0;
    } else {
      //LAB_8017e6a
      //LAB_8017e74
      r0 = r7 - Math.min(r2, 0xc) + 0xd;
    }

    //LAB_8017e7a
    return r0;
  }

  @Method(0x8017e88) //TODO r1 is ASCII char name
  public static int FUN_8017e88(int r0, int r1, int r2, int r3, final int a4, final int a5, final int a6) {
    int r4;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r9;
    final int r10;
    final int lr;

    CPU.sp().value -= 0x20;
    r10 = r0;
    r5 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r2, 0x0);
    r2 = a6;
    r7 = CPU.addT(r3, 0x0);
    r3 = r10;
    r8 = a4;
    lr = r2;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8017edc).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r2 = MEMORY.ref(4, 0x8017ee4).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      r3 = CPU.lslT(r0, 1);
      r1 = MEMORY.ref(4, 0x8017ee0).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r1);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r2);
    }

    //LAB_8017ec8
    r4 = r8;
    if(r4 == 1 || (r4 == 3 && a5 == 0)) {
      //LAB_8017ee8
      r9 = CPU.sp().value;
      r3 = MEMORY.ref(4, 0x8017fa4).get();
      r1 = CPU.movT(0, 0x0);
      r2 = r9;
      CPU.r12().value = r1;
      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r1 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();
      r3 += 0x4;

      MEMORY.ref(4, r2).setu(r1);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);
      r2 += 0x4;

      r4 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r6 = MEMORY.ref(4, r3).get();

      MEMORY.ref(4, r2).setu(r4);
      r2 += 0x4;
      MEMORY.ref(4, r2).setu(r6);

      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r2, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
        r3 = CPU.subT(r3, 0x1);
        CPU.r12().value = r3;
        r5 = CPU.addT(r5, 0x4);
      }

      //LAB_8017f0c
      if(CPU.r12().value == 0) {
        CPU.r12().value = 2;
        if(r2 != 0x41 && r2 != 0x49 && r2 != 0x55 && r2 != 0x45 && r2 != 0x4f) {
          CPU.r12().value = 1;
        }
      }

      //LAB_8017f2e
      r3 = CPU.movT(0, 0x7);
      r6 = CPU.r12().value;
      r6 = CPU.andT(r6, r3);
      r3 = CPU.lslT(r6, 2);
      r1 = r9;
      r4 = MEMORY.ref(4, r1 + r3).get();
      r3 = MEMORY.ref(1, r4).getUnsigned();
      r1 = CPU.lslT(r3, 24);
      r6 = CPU.movT(0, 0x0);
      r4 = CPU.addT(r4, 0x1);
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8017fa8).get();
        CPU.r12().value = r2;

        //LAB_8017f4a
        do {
          r2 = CPU.lslT(r0, 1);
          r3 = CPU.asrT(r1, 24);
          MEMORY.ref(2, r2 + r7).setu(r3);
          r0 = CPU.addT(r0, 0x1);
          r3 = CPU.r12().value;
          r6 = CPU.addT(r6, 0x1);
          r0 = CPU.andT(r0, r3);
          CPU.cmpT(r6, 0x7);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(1, r4).getUnsigned();
          r3 = CPU.lslT(r3, 24);
          r4 = CPU.addT(r4, 0x1);
          r1 = CPU.addT(r3, 0x0);
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }
      r2 = MEMORY.ref(2, r5).getUnsigned();
    } else {
      //LAB_8017f6a
      r3 = MEMORY.ref(2, r5).getUnsigned();
      r2 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r3, 0x1d);
      if(CPU.cpsr().getZero()) { // ==
        r5 = CPU.addT(r5, 0x4);
        r2 = MEMORY.ref(2, r5).getUnsigned();
      }
    }

    //LAB_8017f76
    r3 = CPU.addT(r2, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = MEMORY.ref(4, 0x8017fa8).get();
      r4 = CPU.movT(0, 0x1);
      r1 = CPU.movT(0, 0x0);

      //LAB_8017f82
      do {
        r2 = CPU.lslT(r2, 16);
        r2 = CPU.asrT(r2, 16);
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r2 = CPU.lslT(r2, 16);
        r0 = CPU.addT(r0, 0x1);
        r2 = CPU.lsrT(r2, 16);
        r5 = CPU.addT(r5, 0x2);
        r0 = CPU.andT(r0, r6);
        if(r2 == 'S' || r2 == 's') {
          //LAB_8017f9c
          r2 = lr;
          MEMORY.ref(4, r2).setu(r4); // Name ends in "S"
        } else {
          //LAB_8017fac
          r3 = lr;
          MEMORY.ref(4, r3).setu(r1);
        }

        //LAB_8017fb0
        r2 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8017fb8
    r4 = r8;
    if(r4 == 0x2 || r4 == 0x3 && a5 != 0) {
      //LAB_8017fc8
      r1 = lr;
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(4, 0x8018004).get();
        r3 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r3 + r7).setu(r2);
        r3 = MEMORY.ref(4, 0x8018014).get();
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.andT(r0, r3);
      }

      //LAB_8017fdc
      r2 = MEMORY.ref(4, 0x8018008).get();
      r3 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r3 + r7).setu(r2);
      r3 = MEMORY.ref(4, 0x8018014).get();
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r3);
    }

    //LAB_8017fe8
    r2 = r10;
    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = MEMORY.ref(4, 0x8018014).get();
      r3 = MEMORY.ref(4, 0x801800c).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018010).get();
      r2 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, 0x1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.andT(r0, r1);
      r3 = MEMORY.ref(4, 0x8018034).get();
      r2 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2 + r7).setu(r3);
      r0 = CPU.addT(r0, 0x1);
      r0 = CPU.andT(r0, r1);
    }

    //LAB_8018024
    CPU.sp().value += 0x20;
    return r0;
  }

  @Method(0x8018038)
  public static int FUN_8018038(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r9;
    final int r11;

    CPU.sp().value -= 0x84;
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(r0);
    r11 = r1;
    final Struct12fc sp2c = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x28).setu(0x1);
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
    r6 = sp2c.textOffset_12b2.get();
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0x1);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r6);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0);
    final int r8 = sp2c.text_eb0.getAddress(); //TODO
    int r7 = 0;

    if(MEMORY.ref(4, CPU.sp().value + 0x30).get() == -1) {
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(sp2c._12b4.get());
    } else {
      //LAB_8018092
      r5 = 0x140;
      r1 = mallocSlotChip(50, r5);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

      MEMORY.setFunction(r1, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r9 = boardWramMallocHead_3001e50.offset(50 * 0x4).get();
      final int r10 = CPU.sp().value + 0x38;
      FUN_8019bac(r10, MEMORY.ref(4, CPU.sp().value + 0x30).get());
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(CPU.sp().value + 0x54);

      //LAB_80180c8
      do {
        r0 = (int)MEMORY.call(r9, r10);
        r5 = CPU.addT(r7, 0x0);
        r7 = CPU.addT(r0, 0x0);
        CPU.cmpT(r7, 0xff);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r7 = 0x40;
        }

        //LAB_80180d8
        jmp_8018614:
        if(MEMORY.ref(4, CPU.sp().value + 0x10).get() != 0) {
          //LAB_80180e4
          switch(r7) {
            case 0x12, 0x11, 0x1d, 0x8, 0x9 -> MEMORY.call(r9, r10);

            case 0x16 -> FUN_8019944(0x5, r11);

            case 0x14 -> {
              MEMORY.call(r9, r10);
              FUN_8019944(0x2, r11);
            }

            case 0x15 -> FUN_8019944(0x4, r11);

            case 0x13 -> {
              MEMORY.call(r9, r10);
              FUN_8019944(0x3, r11);
            }

            case 0x0, 0x2, 0x1e -> MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);

            case 0x17 -> FUN_8019944(0x6, r11);

            case 0x1 -> {
              //LAB_8018166
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
              r7 = 0x2;
            }
          }
        } else {
          //LAB_8018188
          if(sp2c._12fa.get() != 0) {
            if(MEMORY.ref(4, CPU.sp().value + 0x28).get() == 0) {
              if(r7 != 0xde && r7 != 0xdf) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu(0x5);
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, 0x1ff);
              }
            }
          }

          //LAB_80181b0
          if(sp2c._12fb.get() != 0) {
            if(MEMORY.ref(4, CPU.sp().value + 0x28).get() == 0) {
              if(r7 != 0xde && r7 != 0xdf) {
                if(r5 <= 0x100) {
                  if(r5 > 0x7f) {
                    if(r5 != 0xde && r5 != 0xdf && r5 != 0x20 && r5 != 0xa5 && r5 != 0xa1 && r5 != 0xa4) {
                      MEMORY.ref(2, r8 + r6 * 0x2).setu(0xde);
                      r6 = CPU.addT(r6, 0x1);
                      r6 = CPU.andT(r6, 0x1ff);
                    }
                  }
                }
              }
            }
          }

          //LAB_801820e
          if(r7 > 0x1f) {
            if(sp2c._12fa.get() != 0 && (r7 == ' ' || MEMORY.ref(4, CPU.sp().value + 0x1c).get() < 0 || MEMORY.ref(4, CPU.sp().value + 0x1c).get() > 0xa)) {
              //LAB_8018228
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(2, r8 + r6 * 0x2).setu('.');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
              MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x1);
              r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              CPU.cmpT(r1, 0xa);
              if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                r7 = ' ';
              }
            }

            //LAB_8018268
            if(r7 == '"') {
              MEMORY.ref(4, CPU.sp().value + 0x24).xor(0x1);
              if(MEMORY.ref(4, CPU.sp().value + 0x24).get() != 0) {
                r7 = 0x8e;
              }
            }

            //LAB_801827a
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x0 || r7 == 0x2) {
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x8 || r7 == 0x9) {
            //LAB_8018320
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu((int)MEMORY.call(r9, r10) - 1);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x10) {
            //LAB_8018486
            r0 = FUN_8077008(_2000434.get());

            //LAB_801849a
            for(r4 = 0; r4 < 15; r4++) {
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(MEMORY.ref(1, r0 + r4).getUnsigned());
            }

            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, 0, 0, CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x11) { // Character name
            //LAB_80184e4
            r0 = FUN_8077008((int)MEMORY.call(r9, r10) - 1);

            //LAB_80184f8
            for(r4 = 0; r4 < 15; r4++) { // Copies Isaac's name
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(MEMORY.ref(1, r0 + r4).getUnsigned());
            }

            //LAB_8018506
            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, 0, 0, CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x12) {
            //LAB_80184aa
            r5 = (int)MEMORY.call(r9, r10) - 1;
            r0 = FUN_8077008(FUN_8019944(0x1, r11));

            //LAB_80184c4
            for(r4 = 0; r4 < 15; r4++) {
              MEMORY.ref(2, CPU.sp().value + 0x54 + r4 * 0x2).setu(MEMORY.ref(1, r0 + r4).getUnsigned());
            }

            r6 = FUN_8017e88(0, CPU.sp().value + 0x54, r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x13) {
            //LAB_80183a6
            r5 = (int)MEMORY.call(r9, r10) - 1;
            FUN_80196c4(FUN_8019944(0x3, r11) + 0x741, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r6 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          //LAB_801828c
          if(r7 == 0x14) {
            //LAB_80183d8
            r5 = (int)MEMORY.call(r9, r10) - 1;
            r2 = FUN_8019944(0x2, r11) & 0x1ff;
            FUN_80196c4(r2 + 0x182, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r6 = FUN_8017e88(0, MEMORY.ref(4, CPU.sp().value + 0xc).get(), r6, r8, r5, MEMORY.ref(4, CPU.sp().value + 0x18).get(), CPU.sp().value + 0x34);
            break jmp_8018614;
          }

          if(r7 == 0x15) {
            //LAB_801840e
            FUN_80196c4(FUN_8019944(0x4, r11) + 0x333, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r0 = CPU.addT(r6, 0x0);

            //LAB_8018432
            while(r2 != 0) {
              MEMORY.ref(2, r8 + r0 * 0x2).setu(r2);
              r1 = CPU.addT(r1, 0x2);
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r0 = CPU.addT(r0, 0x1);
              r0 = CPU.andT(r0, 0x1ff);
            }

            r6 = CPU.addT(r0, 0x0);
            break jmp_8018614;
          }

          if(r7 == 0x16) {
            //LAB_8018344
            r1 = FUN_8019944(0x5, r11);
            r3 = r1;
            if(r1 < 0) {
              r3 = -r1;
            }

            //LAB_8018356
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x1);
            if(r3 <= 1) {
              MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
            }

            //LAB_8018362
            r5 = CPU.sp().value + 0x44;
            r0 = convertNumberToAscii(r5, r1, 0);
            r4 = CPU.subT(r0, r5);
            if(r4 != 0x10) {
              //LAB_8018374
              //LAB_801837c
              r0 = r4 + r5;
              r1 = r0;

              //LAB_8018384
              while(MEMORY.ref(1, r0).getUnsigned() != 0) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu(MEMORY.ref(1, r1).getUnsigned());
                r6++;
                r4++;
                r1++;
                r6 = CPU.andT(r6, 0x1ff);
                if(r4 == 0x10) {
                  break;
                }

                //LAB_801839c
                r0++;
              }
            }
            break jmp_8018614;
          }

          //LAB_80182e6
          if(r7 == 0x17) {
            //LAB_8018448
            FUN_80196c4(FUN_808a5d0(FUN_8019944(0x6, r11), 0x1) + 0x99b, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x18);
            r1 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r0 = r6;

            //LAB_8018470
            while(r2 != 0) {
              MEMORY.ref(2, r8 + r0 * 0x2).setu(r2);
              r1 += 0x2;
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r0 = r0 + 1 & 0x1ff;
            }

            r6 = r0;
            break jmp_8018614;
          }

          //LAB_80182ec
          if(r7 == 0x18) {
            //LAB_8018546
            MEMORY.ref(2, r8 + r6 * 0x2).setu(0x8f);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu('-');
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          //LAB_80182d2
          if(r7 == 0x19) {
            //LAB_8018588
            if(MEMORY.ref(4, CPU.sp().value + 0x18).get() != 0) {
              if(MEMORY.ref(4, CPU.sp().value + 0x34).get() != 0) {
                MEMORY.ref(2, r8 + r6 * 0x2).setu('e');
                r6 = CPU.addT(r6, 0x1);
                r6 = CPU.andT(r6, 0x1ff);
              }

              //LAB_80185a2
              MEMORY.ref(2, r8 + r6 * 0x2).setu('s');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
            }
            break jmp_8018614;
          }

          if(r7 == 0x1a) {
            //LAB_801851e
            r0 = (int)MEMORY.call(r9, r10);
            r0 = CPU.subT(r0, 0x1);
            r0 = CPU.lslT(r0, 1);
            r3 = CPU.lslT(r6, 1);
            r2 = CPU.addT(r0, 0x0);
            r6 = CPU.addT(r6, 0x1);
            r2 = CPU.addT(r2, 0x80);
            r6 = CPU.andT(r6, 0x1ff);
            MEMORY.ref(2, r8 + r3).setu(r2);
            r0 = CPU.addT(r0, 0x81);
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r0);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x1b) {
            //LAB_80185c0
            MEMORY.ref(2, r8 + r6 * 0x2).setu('\'');
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            if(MEMORY.ref(4, CPU.sp().value + 0x34).get() == 0) {
              MEMORY.ref(2, r8 + r6 * 0x2).setu('s');
              r6 = CPU.addT(r6, 0x1);
              r6 = CPU.andT(r6, 0x1ff);
            }
            break jmp_8018614;
          }

          //LAB_80182f4
          if(r7 == 0x1d) {
            //LAB_8018320
            MEMORY.ref(2, r8 + r6 * 0x2).setu(0x1d);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            r0 = (int)MEMORY.call(r9, r10);
            r0 = CPU.addT(r0, 0xffff);
            MEMORY.ref(2, r8 + r6 * 0x2).setu(r0);
            r6 = CPU.addT(r6, 0x1);
            r6 = CPU.andT(r6, 0x1ff);
            break jmp_8018614;
          }

          if(r7 == 0x1e) {
            //LAB_801831a
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
            break jmp_8018614;
          }

          if(r7 == 0x1 || r7 == 0x3) {
            MEMORY.ref(4, CPU.sp().value + 0x28).setu(1);
          }

          //LAB_80185f4
          MEMORY.ref(2, r8 + r6 * 0x2).setu(r7);
          r6 = CPU.addT(r6, 0x1);
          r6 = CPU.andT(r6, 0x1ff);
          if(r7 == 0x73 || r7 == 0x53) {
            //LAB_8018608
            r3 = 1;
          } else {
            //LAB_8018610
            r3 = 0;
          }

          //LAB_8018612
          MEMORY.ref(4, CPU.sp().value + 0x34).setu(r3);
        }

        //LAB_8018614
        MEMORY.ref(4, CPU.sp().value + 0x1c).incr();
      } while(MEMORY.ref(4, CPU.sp().value + 0x14).get() != 0 && MEMORY.ref(4, CPU.sp().value + 0x1c).get() < 0x200);

      //LAB_8018628
      r3 = CPU.lslT(r6, 1);
      r6 = CPU.addT(r6, 0x1);
      MEMORY.ref(2, r8 + r3).setu(r7);
      r6 = CPU.andT(r6, 0x1ff);
      r2 = CPU.lslT(r6, 1);
      MEMORY.ref(2, r8 + r2).setu(0);
      r3 = CPU.addT(r6, 0x1);
      r3 = CPU.andT(r3, 0x1ff);
      sp2c.textOffset_12b2.set(r3);
      freeSlot(50);
      r0 = MEMORY.ref(2, CPU.sp().value + 0x20).getUnsigned();
      sp2c._12b4.set(r0);
    }

    //LAB_801865a
    if(r11 != 0) {
      FUN_80198dc();
    }

    //LAB_8018678
    r0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
    CPU.sp().value += 0x84;
    return r0;
  }

  @Method(0x801868c)
  public static void FUN_801868c(final int r0, final int r1, final int r2, final int r3, final int a4, final ArrayRef<UnsignedShortRef> a5, final int a6) {
    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r10 = 30;
    int r7 = MEMORY.ref(4, r2).get();
    int r6 = MEMORY.ref(4, r1).get();
    if((a6 & 0x2) == 0) {
      if((a6 & 0x1) != 0) {
        FUN_8018a50(r0, r3, a4, a5);
      } else {
        //LAB_80186d6
        FUN_8018850(r0, r3, a4, a5);
      }
    }

    //LAB_80186e0
    if(MEMORY.ref(4, r3).get() != 0 || MEMORY.ref(4, a4).get() != 0) {
      //LAB_80186ee
      if((a6 & 0x2) == 0) {
        MEMORY.ref(4, r3).addu(0x13).shr(3);
        MEMORY.ref(4, a4).addu(0xf).shr(3);
        if(r9._ea4.get() != 0) {
          MEMORY.ref(4, r3).addu(0x2);
          r10 = 29;
        }

        //LAB_8018722
      }

      //LAB_8018724
      final int r3_0 = r6 + MEMORY.ref(4, r3).get();
      if(r3_0 > r10) {
        r6 = Math.max(r6 - (r3_0 - r10), 0);
      }

      //LAB_8018738
      final int r3_1 = r7 + MEMORY.ref(4, a4).get();
      if(r3_1 > 20) {
        r7 = Math.max(r7 - (r3_1 - 20), 0);
      }

      //LAB_801875a
      MEMORY.ref(4, r1).setu(MathHelper.clamp(r6, 0, r10 - MEMORY.ref(4, r3).get()));
      MEMORY.ref(4, r2).setu(MathHelper.clamp(r7, 0, 20 - MEMORY.ref(4, a4).get()));
    }

    //LAB_8018776
  }

  @Method(0x80187ac)
  public static int FUN_80187ac(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r0_0 = FUN_8018038(r0, 0);

    if(r5.text_eb0.get(r0_0).get() == 0) {
      return 0;
    }

    //LAB_80187d6
    FUN_801868c(r0_0, r1, r2, r3, a4, null, 0);
    return 1;
  }

  @Method(0x80187fc)
  public static int FUN_80187fc(final int r0, final int r1, final int r2, final int r3, final int a4) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r0_0 = FUN_8018038(r0, 0);
    if(r5.text_eb0.get(r0_0).get() == 0) {
      return 0;
    }

    //LAB_8018826
    FUN_801868c(r0_0, r1, r2, r3, a4, null, 0x1);

    //LAB_801883e
    return 1;
  }

  @Method(0x8018850)
  public static void FUN_8018850(int chrIndex, int r1, final int r2, @Nullable final ArrayRef<UnsignedShortRef> r6) {
    int r3;
    int r5;
    int r7;
    int r10;
    int r11;
    int r12;

    CPU.sp().value -= 0x20;
    final int sp0c = r1;
    final Struct12fc r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r5 = 0;
    r7 = 0;
    r1 = 0;
    final int r8 = CPU.sp().value + 0x18;
    final int r9 = CPU.sp().value + 0x10;
    r10 = 0;
    r11 = 0xf;
    r12 = 0;

    //LAB_801888a
    do {
      int chr;
      do {
        chr = r4.text_eb0.get(chrIndex).get();
        chrIndex = CPU.addT(chrIndex, 0x1);
        chrIndex = CPU.andT(chrIndex, 0x1ff);
        if(chr < ' ') {
          //LAB_80188c6
          switch(chr) { // textbox control code
            case 3:
              r5++;
              MEMORY.ref(2, r8 + r12).setu(r5);
              MEMORY.ref(2, r9 + r12).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r1;
              }

              //LAB_801895a
              r3 = r10;
              CPU.cmpT(r3, 0x2);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r10++;
                r12 = r10 * 0x2;
              }

              //LAB_801896a
              r5 = 0;
              r1 = 0;
              r11 += 0xf;
              continue;

            case 0xe:
            case 0x1c:
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);

            case 8:
            case 0xa:
            case 0xf:
            case 0x11:
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);
              continue;

            case 9:
              r4._eac.set(r4.text_eb0.get(chrIndex).get());
              chrIndex = CPU.addT(chrIndex, 0x1);
              chrIndex = CPU.andT(chrIndex, 0x1ff);
              continue;

            case 0:
            case 1:
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r8 + r12).setu(r5);
              MEMORY.ref(2, r9 + r12).setu(r1);
              r7 = CPU.cmpT(r7, r1);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r7 = r1;
              }

              //LAB_80189b4
              if(r4._ea4.get() != 0) {
                r7 += 0x2;
              }

              //LAB_80189c0
              MEMORY.ref(4, sp0c).setu(r7);
              MEMORY.ref(4, r2).setu(r11);
              r3 = r7 + 0x13;
              r7 = CPU.lsrT(r3, 3);
              r3 = CPU.lslT(r7, 3);
              r7 = CPU.addT(r3, 0x0);
              r7 = CPU.subT(r7, 0x10);
              if(r6 != null) {
                r5 = 0;

                //LAB_80189de
                for(int r2_0 = 0; r2_0 <= r10; r2_0++) {
                  r3 = MEMORY.ref(2, r8 + r5).getUnsigned();
                  CPU.cmpT(r3, 0x1);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r6.get(r2_0).set(0);
                  } else {
                    //LAB_8018a08
                    //LAB_8018a16
                    int r0_0 = divideS(Math.max(0, r7 - MEMORY.ref(2, r9 + r5).getUnsigned() - 4) << 8, MEMORY.ref(2, r8 + r5).getUnsigned() - 1);
                    CPU.cmpT(r0_0, 0xc00);
                    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                      r0_0 = 0x200;
                    }

                    //LAB_8018a32
                    r6.get(r2_0).set(r0_0);
                  }

                  //LAB_8018a34
                  r5 += 0x2;
                }
              }

              //LAB_8018a3e
              CPU.sp().value += 0x20;
              return;

            default:
              continue;
          }
        }
        if(chr != ' ') {
          break;
        }
        r1 += 0x5;
        r5++; // number of spaces
      } while(true);

      //LAB_80188a8
      int r2_0 = MEMORY.ref(2, 0x8032224 + (chr - ' ') * 0x20).getUnsigned(); //TODO
      if(r4._eac.get() == 1 || r4._eac.get() == 5) {
        //LAB_80188c0
        r2_0++;
      }

      //LAB_80188c2
      r1 += r2_0;
    } while(true);
  }

  @Method(0x8018a50)
  public static void FUN_8018a50(int r0, int r1, int r2, @Nullable final ArrayRef<UnsignedShortRef> array) {
    int r3;
    int r4;
    int r6;
    int r7;
    int r8 = 0;
    final int r9;
    int r10;
    final int r11;
    final int lr;

    CPU.sp().value -= 0x5c;

    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    r1 = CPU.sp().value + 0x1c;
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, r1).setu(0xf);
    MEMORY.ref(4, r1 + 0x4).setu(0xf);
    MEMORY.ref(4, r1 + 0x8).setu(0xf);
    MEMORY.ref(4, r1 + 0xc).setu(0xf);
    MEMORY.ref(4, r1 + 0x10).setu(0xf);
    MEMORY.ref(4, r1 + 0x14).setu(0xf);
    MEMORY.ref(4, r1 + 0x18).setu(0xf);
    MEMORY.ref(4, r1 + 0x1c).setu(0xf);
    MEMORY.ref(4, r1 + 0x20).setu(0xf);
    MEMORY.ref(4, r1 + 0x24).setu(0xf);
    MEMORY.ref(4, r1 + 0x28).setu(0xf);
    MEMORY.ref(4, r1 + 0x2c).setu(0xf);
    MEMORY.ref(4, r1 + 0x30).setu(0xf);
    MEMORY.ref(4, r1 + 0x34).setu(0xf);
    MEMORY.ref(4, r1 + 0x38).setu(0xf);
    MEMORY.ref(4, r1 + 0x3c).setu(0xf);
    lr = r2;
    r9 = CPU.sp().value + 0x14;
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(0);
    r10 = 0;
    r4 = 0;
    r6 = 0;
    r7 = 0;
    CPU.r12().value = 0;
    r11 = CPU.sp().value + 0xc;

    //LAB_8018aa4
    loop:
    do {
      r2 = r5.text_eb0.get(r0).get();
      r0 = r0 + 1 & 0x1ff;
      if(r2 > 0x1f) {
        if(r2 != ' ') {
          //LAB_8018ac2
          r2 = MEMORY.ref(2, 0x8032224 + (r2 - ' ') * 0x20).getUnsigned();
          r3 = r5._eac.get();
          MEMORY.ref(4, CPU.sp().value).setu(r3);
          if(r3 == 1 || r3 == 5) {
            //LAB_8018ada
            r2++;
          }

          //LAB_8018adc
          r4 += r2;
        } else {
          r4 += 0x5;
          r6++;
        }
        continue;
      }

      //LAB_8018ae0
      switch(r2) {
        case 3:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);
          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018b76
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          CPU.cmpT(r3, 0x2);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            r3 = CPU.addT(r3, 0x1);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
            r3 = CPU.lslT(r3, 1);
            CPU.r12().value = r3;
          }

          //LAB_8018b84
          r6 = 0;
          r4 = 0;
          MEMORY.ref(4, r1 + r7 * 0x4).addu(0xf);
          break;

        case 0:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);
          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018ba8
          r7++;
          break loop;

        case 1:
          r6++;
          MEMORY.ref(2, r9 + CPU.r12().value).setu(r6);
          MEMORY.ref(2, r11 + CPU.r12().value).setu(r4);

          if(r7 == 0) {
            CPU.cmpT(r10, r4);
            if(!CPU.cpsr().getCarry()) { // unsigned <
              r10 = r4;
            }
          }

          //LAB_8018bc2
          r7++;
          break;

        case 0xe:
        case 0x1c:
          r0 = r0 + 1 & 0x1ff;
          r0 = r0 + 1 & 0x1ff;
          break;

        case 9:
          r5._eac.set(r5.text_eb0.get(r0).get());
          // fall through

        case 8:
        case 0xa:
        case 0xf:
        case 0x11:
          r0 = r0 + 1 & 0x1ff;
          break;
      }
    } while(true);

    //LAB_8018be6
    if(r5._ea4.get() != 0) {
      r10 += 2;
    }

    //LAB_8018bf4
    //LAB_8018bfe
    for(r4 = 0; r4 < r7; r4++) {
      if(r4 == 0) {
        MEMORY.ref(4, lr).setu(MEMORY.ref(4, r1).get());
      } else {
        //LAB_8018c0a
        r3 = MEMORY.ref(4, lr).get();
        r2 = MEMORY.ref(4, r1 + r4 * 0x4).get();
        r3 = CPU.cmpT(r3, r2);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(4, lr).setu(r2);
        }
      }

      //LAB_8018c18
    }

    //LAB_8018c20
    r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    MEMORY.ref(4, r3).setu(r10);
    r3 = r10 + 0x13;
    r3 = CPU.lsrT(r3, 3);
    r3 = CPU.lslT(r3, 3);
    r3 = CPU.subT(r3, 0x10);
    r10 = r3;
    if(array != null) {
      //LAB_8018c3c
      for(r6 = 0; r6 <= MEMORY.ref(4, CPU.sp().value + 0x4).get(); r6++) {
        if(MEMORY.ref(2, r9 + r6 * 0x2).getUnsigned() <= 1) {
          array.get(r8).set(0);
        } else {
          //LAB_8018c6c
          //LAB_8018c7c
          array.get(r8).set(divideS(Math.max(0, r10 - MEMORY.ref(2, r11 + r6 * 0x2).getUnsigned() - 0x4) << 8, MEMORY.ref(2, r9 + r6 * 0x2).getUnsigned() - 1));
        }

        //LAB_8018c8e
        r8++;
      }
    }

    //LAB_8018c9a
    CPU.sp().value += 0x5c;
  }

  @Method(0x8018cac)
  public static int FUN_8018cac(final GraphicsStruct24 r8, final int r7, final int r2, int r3, final int a4) {
    int r0;
    int r1;
    int r9;
    final int r10;
    final int r11;

    CPU.sp().value -= 0x90;

    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6._12b0.get());
    r11 = r6._ea8.get();
    if(a4 != 1) {
      if((r8._16.get() & 0x8) != 0) {
        if(boardWramMallocHead_3001e50.offset(37 * 0x4).get() == r8.getAddress()) {
          if(r7 == 0x20) {
            CPU.sp().value += 0x90;
            return 0x3;
          }
        }

        //LAB_8018d06
        if(r7 == 0x20) {
          CPU.sp().value += 0x90;
          return 0x4;
        }

        r10 = getPointerTableEntry(19);

        //LAB_8018d18
        final int size = 0x318;
        final int addr = mallocChip(size);
        DMA.channels[3].SAD.setu(0x80155d0); //TODO function
        DMA.channels[3].DAD.setu(addr);
        DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

        final int ret = (int)MEMORY.call(addr, r8, r7, MEMORY.ref(4, CPU.sp().value + 0xc).get(), MEMORY.ref(4, CPU.sp().value + 0x8).get(), r10);
        setMallocAddress(addr);

        CPU.sp().value += 0x90;
        return ret;
      }
    }

    //LAB_8018d50
    r9 = 0x5;
    if(r7 == 0x20) {
      r0 = r9;
    } else {
      //LAB_8018d5a
      final GraphicsStruct1c r5 = FUN_8015e8c();
      r0 = 0;
      if(r5 != null) {
        //LAB_8018d68
        r1 = r5.getAddress() - r6._698.getAddress(); //TODO
        r1 = CPU.mulT(r1, 0xb6db6db7);
        r5._04.set(0);
        r5._05.set(1);
        r10 = r1;
        if(a4 == 1) {
          r9 = 0x1;
          r5._05.set(0x2);
        } else {
          //LAB_8018d8e
          r3 = r6._eac.get();
          if(r3 == 2) {
            r5._05.set(0x4);
            r5._0c.set(0);
          } else if(r3 == 3) {
            //LAB_8018dac
            r5._05.set(0x5);
            //LAB_8018da2
          } else if(r3 == 4) {
            //LAB_8018db2
            r5._05.set(0x6);
            r5._0c.set(0x8);
          } else if(r3 == 5) {
            //LAB_8018dbc
            r5._05.set(0x7);
            r5._0c.set(0);
          }

          //LAB_8018dc6
          r0 = FUN_80178b0(r7, CPU.sp().value + 0x10);
          if(r0 == 0) {
            r0 = 1;
          }

          //LAB_8018dd4
          r9 = r0;
        }

        //LAB_8018dd6
        if(r5._05.get() == 2) {
          if(r6.vramSlot_12b6.get() == 0x63) {
            r6.vramSlot_12b6.set(getFreeVramSlot());
          }

          //LAB_8018df0
          r5.packet_10.attribs_04.attrib1_02.and(~0x1ff).or((r8._0c.get() + (r8._08.get() - 2)) * 8 + 4 & 0x1ff);
          r5.packet_10.attribs_04.y_00.set((r8._0e.get() + (r8._0a.get() - 2)) * 8 - 1);
        } else {
          //LAB_8018e5c
          r1 = r10 + r6._12b8.get();
          DMA.channels[3].SAD.setu(CPU.sp().value + 0x10);
          DMA.channels[3].DAD.setu(0x6010000 + r1 * 0x20);
          DMA.channels[3].CNT.setu(0x84000020);

          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r5.packet_10.attribs_04.attrib0_00.set(MEMORY.ref(4, CPU.sp().value + 0x8).get() + (r11 >>> 1) + r8._0e.get() * 8 - 2);
          r5.packet_10.attribs_04.attrib1_02.set(MEMORY.ref(4, CPU.sp().value + 0xc).get() + (r3 >>> 1) + r8._0c.get() * 8 + 2 | 0x4000);
          r5.packet_10.attribs_04.attrib2_04.set(r10 + r6._12b8.get());
        }

        //LAB_8018eac
        r5._0f.set(0xfe);
        r3 = r5.packet_10.attribs_04.attrib1_02.get();
        r3 = CPU.lslT(r3, 23);
        r3 = CPU.lsrT(r3, 23);
        r5._06.set(r3);
        r5._08.set(r5.packet_10.attribs_04.y_00.get());
        r5.slot_0e.set(r10);
        r5._00.clear();
        FUN_8016584(r8, r5);

        //LAB_8018ecc
        r0 = r9;
      }
    }

    //LAB_8018ee8
    CPU.sp().value += 0x90;
    return r0;
  }

  @Method(0x801908c)
  public static void FUN_801908c(final GraphicsStruct1c r0) {
    CPU.sp().value -= 0x8;

    int r7 = 0x100;
    if(r0._05.get() == 0x9) {
      //LAB_80190b6
      r7 = MEMORY.ref(2, 0x80366f8 + (r0._0c.get() & 0x1f) * 0x2).getUnsigned(); //TODO
      r0._0c.incr();
    } else if(r0._05.get() == 0xa) {
      //LAB_80190c8
      r7 = MEMORY.ref(2, 0x80366f8 + (r0._0c.get() & 0x1f) * 0x2).getUnsigned() >>> 1; //TODO
      r0._0c.incr();
    } else if(r0._05.get() == 0xb) {
      //LAB_80190da
      if(r0._0c.get() < 8) {
        r7 = MEMORY.ref(2, 0x80366f8 + 0x20 + r0._0c.get() * 0x4).getUnsigned(); //TODO
        r0._0c.incr();
      }
    } else if(r0._05.get() == 0xc) {
      //LAB_80190f0
      if(r0._0c.get() < 8) {
        r7 = MEMORY.ref(2, 0x80366f8 + 0x20 + r0._0c.get() * 0x4).getUnsigned() >>> 1; //TODO
        r0._0c.incr();
      }
    }

    //LAB_8019106
    final RenderPacket0c packet = r0.packet_10;
    if(r7 == 0x100) {
      packet.attribs_04.attrib1_02.and(~0x3e00); // mask off upper flags
      packet.attribs_04.flags_01.and(~0x3); // mask off rotation/scaling and double size
      packet.attribs_04.attrib1_02.or(r0._06.get() & 0x1ff); // x
      packet.attribs_04.y_00.set(r0._08.get()); // y
    } else {
      //LAB_8019124
      MEMORY.ref(4, CPU.sp().value).setu(r7 << 16 | r7 & 0xffff);
      MEMORY.ref(4, CPU.sp().value + 0x4).and(~0xffff);
      packet.attribs_04.attrib1_02.and(~0x3e00).or((FUN_8003d28(CPU.sp().value) & 0x1f) << 9); // upper flags

      if(r7 > 0x100) {
        packet.attribs_04.flags_01.or(0x3); // mask off rotation/scaling and double size
        packet.attribs_04.attrib1_02.and(~0x1ff).or(r0._06.get() - 8 & 0x1ff); // x
        packet.attribs_04.y_00.set((r0._08.get() & 0xff) - 8); // y
      } else {
        //LAB_8019194
        packet.attribs_04.flags_01.and(~0x3).or(0x1); // mask off double size and mask on rotation/scaling
        packet.attribs_04.attrib1_02.and(~0x1ff).or(r0._06.get() & 0x1ff); // x
        packet.attribs_04.y_00.set(r0._08.get()); // y
      }
    }

    //LAB_80191b4
    CPU.sp().value += 0x8;
  }

  @Method(0x80191cc)
  public static void FUN_80191cc() {
    CPU.sp().value -= 0x18;

    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_80191ee
    for(int r11 = 0; r11 < 8; r11++) {
      final GraphicsStruct24 r10 = r9._500.get(r11);

      if((r10._16.get() & 0x1) != 0) {
        //LAB_80191fc
        GraphicsStruct1c r6 = r10._00.derefNullable();

        //LAB_8019206
        while(r6 != null) {
          final RenderPacket0c r7 = r6.packet_10;

          if(r10._12.get() == 0x4) {
            r6._0c.set(0x2);
            r6._05.set(0x8);
          }

          //LAB_801921a
          int r5;
          switch(r6._05.get()) {
            case 2:
              if(r9.vramSlot_12b6.get() != 0x60) {
                //LAB_8019288
                //TODO
                final int r2 = 0x80368d4 + (ticks_3001800.get() >>> 2 & 0x7) * 0x80;
                r7.attribs_04.attrib2_04.and(~0x3ff).or(FUN_8003fa4(r9.vramSlot_12b6.get(), 0x80, r2) & 0x3ff);
                r6.slot_0e.set(r7.attribs_04.attrib2_04.get());
                r5 = r7.attribs_04.flags_01.get() & ~0xc & ~0x10 | 0x20;
                r5 = r5 & 0x3f | 0x80;
                r7.attribs_04.flags_01.set(r5);
                r7.attribs_04.attrib1_02.and(~0xc000); // mask off obj size
                r7.attribs_04.y_00.set(r6._08.get() + MEMORY.ref(1, 0x8033e60 + modU(ticks_3001800.get(), 0x50)).getUnsigned() + 2);
                r7.attribs_04.flags_01.set(r5 & ~0x3);
                r7.attribs_04.attrib1_02.and(~0x3e00); // mask off rotation/scaling/flip
              }
              break;

            case 5:
              if((ticks_3001800.get() & 0x1) != 0) {
                //LAB_801931e
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() + ((rand() * 3 >>> 16) + (rand() * 3 >>> 16) >>> 1) - 1 & 0x1ff);
                r7.attribs_04.y_00.set(r6._08.get() + ((rand() * 3 >>> 16) + (rand() * 3 >>> 16) >>> 1) - 1);
              }
              break;

            case 6:
              if(r6._0c.get() == 0) {
                r7.attribs_04.attrib1_02.and(~0x3e00); // mask off rotation/scaling/flip
                r7.attribs_04.flags_01.and(~0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() & 0x1ff);
                r7.attribs_04.y_00.set(r6._08.get());
              } else {
                //LAB_8019388
                MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x2000200);
                MEMORY.ref(4, CPU.sp().value + 0x14).and(~0xffff);
                r7.attribs_04.attrib1_02.and(~0x3e00).or((FUN_8003d28(CPU.sp().value + 0x10) & 0x1f) << 9);
                r7.attribs_04.flags_01.or(0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() - 5 & 0x1ff);
                r7.attribs_04.y_00.set(r6._08.get() - 5);
                r6._0c.decr();
              }
              break;

            case 7:
              r5 = CPU.sp().value + 0x10;
              MEMORY.ref(2, r5).setu(0x100);
              MEMORY.ref(2, r5 + 0x2).setu(0x100);
              r6._0c.add(0x300);
              MEMORY.ref(2, r5 + 0x4).setu(r6._0c.get());
              r7.attribs_04.attrib1_02.and(~0x3e00).or((FUN_8003d28(r5) & 0x1f) << 9);
              r7.attribs_04.flags_01.and(~0x3).or(0x1);
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() - (sin(MEMORY.ref(2, r5 + 0x4).getUnsigned() + 0xe800) >> 14) - 2 & 0x1ff);
              r7.attribs_04.y_00.set(r6._08.get() - (cos(MEMORY.ref(2, r5 + 0x4).getUnsigned() + 0x6800) >> 14) - 2);
              break;

            case 4:
              if((ticks_3001800.get() & 0x1) != 0) {
                r6._0c.incr();
              }

              //LAB_801948e
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() + MEMORY.ref(1, 0x8033eb0 + (modU(r6._0c.get(), 0x14) & 0xffff) * 0x2).get() & 0x1ff);
              r7.attribs_04.y_00.set(r6._08.get() + MEMORY.ref(1, 0x8033eb0 + (modU(r6._0c.get(), 0x14) & 0xffff) * 0x2 + 0x1).getUnsigned() - 2);
              break;

            case 0x11:
              r6._0c.incr();
              r7.attribs_04.y_00.set(r6._08.get() - MEMORY.ref(1, 0x8033ee8 + (r6._0c.get() & 0xf)).getUnsigned()); //TODO
              break;

            case 0xe:
            case 0xf:
            case 0x10:
              r6._0c.incr();
              r7.attribs_04.y_00.set(r6._08.get() + MEMORY.ref(1, 0x8033ee8 + (r6._0c.get() & 0xf)).getUnsigned()); //TODO
              break;

            case 0x12:
              r6._0c.incr();
              r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() - MEMORY.ref(1, 0x8033ee8 + (r6._0c.get() & 0xf)).get() & 0x1ff); //TODO
              r7.attribs_04.y_00.set(r6._08.get() + MEMORY.ref(1, 0x8033ee8 + r6._0c.get() & 0xf).getUnsigned()); //TODO
              break;

            case 8:
              if(r6._0c.get() != 0) {
                MEMORY.ref(2, CPU.sp().value + 0x10).setu(0x140);
                MEMORY.ref(2, CPU.sp().value + 0x12).setu(0x140);
                MEMORY.ref(2, CPU.sp().value + 0x14).setu(0);
                r7.attribs_04.attrib1_02.and(~0x3e00).or((FUN_8003d28(CPU.sp().value + 0x10) & 0x1f) << 9);
                r7.attribs_04.flags_01.or(0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() - 8 & 0x1ff);
                r7.attribs_04.y_00.set(r6._08.get() - 8);
                r6._0c.and(0xffff);
              } else {
                //LAB_80195b0
                r7.attribs_04.attrib1_02.and(~0x3e00);
                r7.attribs_04.flags_01.and(~0x3);
                r7.attribs_04.attrib1_02.and(~0x1ff).or(r6._06.get() & 0x1ff);
                r7.attribs_04.y_00.set(r6._08.get());
              }
              break;

            case 9:
            case 0xa:
            case 0xb:
            case 0xc:
              FUN_801908c(r6);
              break;
          }

          //default/end
          //LAB_80195e0
          if(r6._05.get() == 0x2) {
            if(r9.vramSlot_12b6.get() != 0x60) {
              insertIntoRenderQueue(r7, r6._0f.get());
            }
          } else {
            //LAB_80195fa
            if(r6._05.get() != 0xd) {
              insertIntoRenderQueue(r7, r6._0f.get());
            }
          }

          //LAB_8019606
          r6 = r6._00.derefNullable();

          //LAB_801960c
        }
      }

      //LAB_8019618
    }

    //LAB_8019628
    CPU.sp().value += 0x18;
  }

  @Method(0x801964c)
  public static void FUN_801964c(final int r0, final int r1) {
    FUN_80196c4(r0, r1, 0x7fffffff);
  }

  @Method(0x80196c4)
  public static void FUN_80196c4(int r0, final int r1, final int r2) {
    int r3;
    final int r5;
    int r6;
    int r7;

    r7 = r2;
    r3 = boardWramMallocHead_3001e50.offset(50 * 0x4).get();
    CPU.sp().value -= 0xc;
    r6 = r1;

    if(r3 == 0) {
      final int size = 0x140;
      final int addr = mallocSlotChip(50, size);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

      MEMORY.setFunction(addr, CopiedSegment8015430.class, "FUN_8015430", int.class);

      r3 = addr;
    }

    //LAB_8019706
    r5 = CPU.sp().value;
    FUN_8019bac(r5, r0);

    //LAB_8019770
    r0 = (int)MEMORY.call(r3, r5);

    //LAB_8019718
    while(r0 != 0) {
      if(r0 == 0xe) {
        //LAB_8019730
        r7 -= 0x3;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
        //LAB_801972a
      } else if(r0 >= 0x8 && r0 <= 0xc || r0 == 0xf) {
        //LAB_8019750
        r7--;
        if(r7 <= 0) {
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r6 += 0x2;
        r0 = (int)MEMORY.call(r3, r5) + 0xffff;
      } else {
        //LAB_8019766
        r7--;
        if(r7 <= 0) {
          break;
        }
      }

      //LAB_801976c
      MEMORY.ref(2, r6).setu(r0);
      r6 += 0x2;

      r0 = (int)MEMORY.call(r3, r5);
    }

    //LAB_801977a
    if(r3 == 0) {
      freeSlot(50);
    }

    //LAB_8019786
    CPU.sp().value += 0xc;
    MEMORY.ref(2, r6).setu(0);
  }

  @Method(0x8019854)
  public static void FUN_8019854(final GraphicsStruct28 r0) {
    final GraphicsStruct24 r3 = r0._00.deref();

    if(r3._12.get() == 4) {
      FUN_80170f8(r3._0c.get() - 1, r3._0e.get() - 1, r3._08.get() + 2, r3._0a.get() + 2);
      r0._14.decr();

      if(r0._14.get() == 0) {
        r3._12.set(r0._14.get());
        FUN_8016178(r3._0c.get() - 1, r3._0e.get() - 1, r3._08.get() + 2, r3._0a.get() + 2);
        FUN_80170f8(r3._0c.get(), r3._0e.get(), r3._08.get(), r3._0a.get());
      }
    }

    //LAB_80198c4
  }

  @Method(0x80198dc)
  public static void FUN_80198dc() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_80198ee
    for(int r1 = 0; r1 < 8; r1++) {
      r3._12bc.get(r1).set(0);
      r3._12dc.get(r1).set(0);
    }
  }

  @Method(0x8019908)
  public static void FUN_8019908(final int r0, final int r1) {
    final Struct12fc r1_0 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);

    //LAB_801991c
    for(int i = 0; i < 8; i++) {
      if(r1_0._12dc.get(i).get() == 0) {
        r1_0._12bc.get(i).set(r0);
        r1_0._12dc.get(i).set(r1);
        break;
      }

      //LAB_8019928
    }

    //LAB_8019932
  }

  @Method(0x8019944)
  public static int FUN_8019944(final int r0, final int r1) {
    final Struct12fc r2 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r6 = 0;

    for(int i = 0; i < 8; i++) {
      if(r2._12dc.get(i).get() == r0) {
        r6 = r2._12bc.get(i).get();

        if(r1 != 0) {
          r2._12bc.get(i).set(0);
          r2._12dc.get(i).set(0);
        }
      }
    }

    //LAB_8019988
    return r6;
  }

  @Method(0x801999c)
  public static int FUN_801999c(final GraphicsStruct28 r0) {
    int r5 = 0;
    if(boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._12f9.get() != 0 && FUN_80f9048() == 0) {
      r5 = 1;
    }

    //LAB_80199ba
    if((heldButtonsLastFrame_3001ae8.get() & 0x303) != 0) { // A/B/L/R
      r5 = 1;
    }

    //LAB_80199c8
    if(r5 == 0) {
      //LAB_80199d4
      return 0;
    }

    r0._14.set(0);

    //LAB_80199d6
    return 1;
  }

  @Method(0x80199ec)
  public static int FUN_80199ec(final GraphicsStruct28 r0) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r3 = r5._12f9.get();
    int r6 = 0;

    if(r3 != 0 && FUN_80f9048() == 0) {
      r6 = 1;
    }

    //LAB_8019a0a
    final int input;
    if(r5._ea4.get() != 0) {
      input = accumulatedButtons_3001af8.get();
    } else {
      input = pressedButtons_3001c94.get();
    }

    //LAB_8019a1c
    if((input & 0x303) != 0) { // A/B/L/R
      r6 = 1;
    }

    //LAB_8019a26
    if(r6 == 0) {
      //LAB_8019a32
      return 0;
    }

    r0._14.set(0);

    //LAB_8019a34
    return 1;
  }

  @Method(0x8019a54)
  public static void FUN_8019a54() {
    final ArrayRef<GraphicsStruct28> r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._620;

    //LAB_8019a62
    for(int r6 = 0; r6 < 3; r6++) {
      final GraphicsStruct28 r5 = r3.get(r6);
      final GraphicsStruct24 r0 = r5._00.derefNullable();

      if(r0 != null) {
        if(r0._18.get() == 0 && r0._1a.get() == 0) {
          final int r2 = r0._16.get();
          if(r2 != 0 && r0._14.get() != 0) {
            FUN_8016418(r0, r2 & 0x2);
          }
        }
      }

      //LAB_8019a88
    }

    sleep(0xa);
  }

  @Method(0x8019aa0)
  public static void FUN_8019aa0(final int r0, final int r1, final int r2) {
    CPU.sp().value -= 0x18;
    final Struct12fc r8 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0x8);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x8);
    final int r10 = FUN_8018038(r0, 0x1);

    if(r8.text_eb0.get(r10).get() != 0) { // Address of textbox text ("Isaac, wake up!")
      FUN_80187ac(r0, CPU.sp().value + 0x14, CPU.sp().value + 0x10, CPU.sp().value + 0xc, CPU.sp().value + 0x8);
      final int r2_0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      final int r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
      final int r0_0 = 30 - r2_0 >> 1;
      final int r3 = 15 - r4 >> 1;
      final int r1_0 = r3 + r2;
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0_0);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1_0);

      final GraphicsStruct24 r5;
      if(r1 != 0) {
        r5 = FUN_80162d4(r0_0, r1_0, r2_0, r4, 0);
      } else {
        //LAB_8019b10
        r5 = FUN_80162d4(r0_0, r1_0, 0, 0, 0x2);
        r5._08.set(0);
        r5._0a.set(0);
      }

      //LAB_8019b22
      if(FUN_80165d8(r5, r10, 0, 0, 0, 0) != null) {
        //LAB_8019b46
        //LAB_8019b40
        while(FUN_8017364() == 0) {
          sleep(0x1);
        }

        if(r1 == 0) {
          FUN_8016418(r5, 0);

          //LAB_8019b5c
          while(FUN_8017394(r5) == 0) {
            sleep(0x1);
          }
        } else {
          //LAB_8019b6e
          FUN_8016418(r5, 1);
        }

        //LAB_8019b76
        r8._12f4.set(0);
        r8._12f6.set(0);
      } else {
        FUN_8016418(r5, 0x1);
      }
    }

    //LAB_8019b84
    CPU.sp().value += 0x18;
  }

  @Method(0x8019bac)
  public static void FUN_8019bac(final int r0, final int r1) {
    final int size = 0x60;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8015570);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8015570.class, "FUN_8015570", int.class, int.class);
    MEMORY.call(addr, r0, r1);
    setMallocAddress(addr);
  }

  @Method(0x8019d0c)
  public static void FUN_8019d0c() {
    final Struct12fc r3 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r3._12ec.set(999);
    r3._12ee.set(999);
  }

  @Method(0x8019d2c)
  public static int FUN_8019d2c(final int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;

    r1 = -1;
    r2 = 0;
    CPU.cmpT(r0, 0x13);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r4 = 0x80367e4; //TODO
      r3 = MEMORY.ref(2, r4).get();
      if(r3 != -1) {
        if(r3 == r0) {
          r1 = MEMORY.ref(2, r4 + 0x2).get();
        } else {
          //LAB_8019d4c
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = MEMORY.ref(2, r4 + r2 * 0x2).get();
            if(r3 == -1) {
              return -1;
            }
          } while(r3 != r0);

          r2 = CPU.addT(r2, 0x1);
          r1 = MEMORY.ref(2, r4 + r2 * 0x2).get();
        }
      }
    } else {
      //LAB_8019d66
      r4 = 0x803680c; //TODO
      r3 = MEMORY.ref(2, r4).get();
      if(r3 != -1) {
        if(r3 == r0) {
          r1 = MEMORY.ref(2, r4 + 0x2).get();
        } else {
          //LAB_8019d7e
          do {
            r2 = CPU.addT(r2, 0x2);
            r3 = MEMORY.ref(2, r4 + r2 * 0x2).get();
            if(r3 == -1) {
              return -1;
            }
          } while(r3 != r0);

          r2 = CPU.addT(r2, 0x1);
          r1 = MEMORY.ref(2, r4 + r2 * 0x2).get();
        }

        //LAB_8019d96
        r1 = CPU.addT(r1, 0x80);
      }
    }

    //LAB_8019d98
    return r1;
  }

  @Method(0x8019da8)
  public static GraphicsStruct24 FUN_8019da8(final int r0, final int r1, final int r2, final int r3) {
    if(FUN_8019d2c(r0) == -1) {
      return null;
    }

    //LAB_8019dd4
    final GraphicsStruct24 r5;
    final int r8;
    if(boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea4.get() != 0) {
      r5 = FUN_80162d4(r2, r3, 0x6, 0x5, 0x2);
      r8 = 0;
    } else {
      //LAB_8019dfe
      r5 = FUN_80162d4(r2, r3, 0x5, 0x5, 0x2);
      r8 = -4;
    }

    //LAB_8019e10
    if(r5 != null) {
      FUN_801ec6c(r0, r1, -1, r5, r8, -4);
    }

    //LAB_8019e2a
    //LAB_8019e2c
    return r5;
  }

  @Method(0x8019e48)
  public static void FUN_8019e48(int r0) {
    final Struct12fc r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int r3;

    r0 = FUN_8019d2c(r0);
    if(r0 != -1) {
      if(r6._12ee.get() == r0) {
        r3 = 1;
        //LAB_8019e78
      } else if(r6._12ec.get() == r0) {
        r3 = 0;
      } else {
        return;
      }

      //LAB_8019e84
      r0 = r6._12f0.get(r3).get();

      //LAB_8019e8e
      for(int r1 = 0; r1 < 8; r1++) {
        final GraphicsStruct24 r5 = r6._500.get(r1);
        final GraphicsStruct1c r2 = r5._00.derefNullable();

        // Retail bug: null check added to fix null pointer dereference
        if(r2 != null && r2._04.get() == 2 && r2.slot_0e.get() == r0) {
          //LAB_8019e6e
          FUN_8016418(r5, 0x2);
          break;
        }

        //LAB_8019e9c
      }
    }

    //LAB_8019ea4
  }

  @Method(0x801a4fc)
  public static void FUN_801a4fc(int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    if(r0 < 0 || r0 > 0x7f) {
      r0 -= 0x70;
    }

    final int r6 = mallocSlotChip(17, 0x608);
    final int ptr = getPointerTableEntry(240);

    //LAB_801a522
    final int r5_0 = ptr + MEMORY.ref(2, ptr + r0 * 0x2).getUnsigned();
    MEMORY.ref(4, 0x604 + r6).setu(r5_0 + 0x20);
    MEMORY.ref(2, 0x600 + r6).setu(0x4);
    MEMORY.ref(2, 0x602 + r6).setu(0x4);
    FUN_801a5a4(r6, 0);
    if(a5 == 0) {
      MEMORY.ref(4, r2).setu(getFreeVramSlot());
    }

    //LAB_801a556
    MEMORY.ref(4, r3).setu(FUN_8003fa4(MEMORY.ref(4, r2).get(), 0x200, r6 + 0x400));
    freeSlot(17);
    DMA.channels[3].SAD.setu(r5_0);
    DMA.channels[3].DAD.setu(0x5000200 + a4 * 0x20);
    DMA.channels[3].CNT.setu(0x80000010);
  }

  @Method(0x801a5a4)
  public static void FUN_801a5a4(final int r0, final int r1) {
    final int size1 = 0x278;
    DMA.channels[3].SAD.setu(0x8015afc);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size1));
    DMA.channels[3].CNT.setu(0x84000000 | size1 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment8015afc.class, "FUN_8015afc", int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), MEMORY.ref(4, r0 + 0x604).get(), r0);
    freeSlot(49);

    final int addr;
    final int size2;
    if(r1 != 0) {
      addr = 0x8015d74;
      size2 = 0x9c;
    } else {
      //LAB_801a5fe
      addr = 0x8015e10;
      size2 = 0x7c;
    }

    //LAB_801a612
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(mallocSlotChip(49, size2));
    DMA.channels[3].CNT.setu(0x84000000 | size2 / 4);

    MEMORY.setFunction(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), CopiedSegment_8015d74_8015e10.class, "FUN_%x".formatted(addr), int.class, int.class, int.class, int.class);
    MEMORY.call(boardWramMallocHead_3001e50.offset(49 * 0x4).get(), r0, r0 + 0x400, MEMORY.ref(2, r0 + 0x600).getUnsigned(), MEMORY.ref(2, r0 + 0x602).getUnsigned());
    freeSlot(0x31);
  }

  @Method(0x8011ae0)
  public static void FUN_8011ae0() {
    FUN_80042c8(getRunnable(GoldenSun_801.class, "FUN_80119cc"));
  }

  @Method(0x801c428)
  public static void FUN_801c428() {
    final int addr = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).offset(0x230).get();
    if(addr != 0) {
      final GraphicsStruct24 r0 = MEMORY.ref(4, addr, GraphicsStruct24::new);
      if(r0._16.get() != 0) {
        FUN_8016418(r0, 0x2);
        clearTickCallback(getRunnable(GoldenSun_801.class, "FUN_801c3e8"));
      }
    }

    //LAB_801c44c
  }

  @Method(0x801cc50)
  public static int FUN_801cc50(int r0, int r1, int r2, int r3) {
    final int r4;
    final int r5;
    int r6;
    int r7;

    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r2, 0x0);
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r4 = 0x3000118;
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc64;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r7 = CPU.asrT(r0, 16);
    r2 = CPU.movT(0, 0x2);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r1 = CPU.addT(r6, 0x0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc74;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r6 = CPU.asrT(r0, 16);
    r2 = CPU.movT(0, 0x4);
    r0 = MEMORY.ref(2, r5 + r2).get();
    r1 = CPU.addT(r3, 0x0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lslT(r0, 0);
    CPU.r12().value = 0x801cc84;
    r0 = (int)MEMORY.call(r4, r0, r1);

    r0 = CPU.asrT(r0, 16);
    CPU.cmpT(r7, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.movT(0, 0x0);
    }

    //LAB_801cc8c
    CPU.cmpT(r7, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.movT(0, 0x1f);
    }

    //LAB_801cc92
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r6 = CPU.movT(0, 0x0);
    }

    //LAB_801cc98
    CPU.cmpT(r6, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r6 = CPU.movT(0, 0x1f);
    }

    //LAB_801cc9e
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_801cca4
    CPU.cmpT(r0, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.movT(0, 0x1f);
    }

    //LAB_801ccaa
    r3 = CPU.lslT(r6, 5);
    r0 = CPU.lslT(r0, 10);
    r0 = CPU.addT(r0, r3);
    r0 = CPU.addT(r7, r0);
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x801ccc0)
  public static void FUN_801ccc0(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r6 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r0, 0xc);
    r1 = CPU.movT(0, 0x18);
    CPU.sp().value -= 0x8;
    r0 = modS(r0, r1);
    r5 = CPU.addT(r0, 0x0);
    r5 = CPU.lslT(r5, 18);
    r5 = CPU.asrT(r5, 16);
    r2 = MEMORY.ref(4, 0x801cdec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    CPU.r8().value = r2;
    r0 = modS(r0, r1);
    r0 = CPU.lslT(r0, 16);
    r2 = CPU.r8().value;
    r0 = CPU.asrT(r0, 16);
    r6 = CPU.subT(r6, 0x7);
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r6 = CPU.lslT(r6, 16);
    r6 = CPU.asrT(r6, 16);
    r3 = CPU.addT(r3, r6);
    r0 = CPU.addT(r5, 0x0);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r1 = CPU.movT(0, 0x60);
    r0 = CPU.addT(r0, 0x20);
    CPU.r10().value = r3;
    r0 = modS(r0, r1);
    r2 = CPU.r8().value;
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r5 = CPU.addT(r5, 0x40);
    r3 = CPU.addT(r3, r6);
    r3 = CPU.lslT(r3, 16);
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    r7 = CPU.asrT(r3, 16);
    r0 = modS(r0, r1);
    r2 = CPU.r8().value;
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r3 = CPU.addT(r3, r6);
    r3 = CPU.lslT(r3, 16);
    r2 = CPU.r10().value;
    r3 = CPU.asrT(r3, 16);
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = CPU.movT(0, 0x0);
      CPU.r10().value = r2;
    }

    //LAB_801cd30
    r2 = CPU.r10().value;
    CPU.cmpT(r2, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r2 = CPU.movT(0, 0x1f);
      CPU.r10().value = r2;
    }

    //LAB_801cd3a
    CPU.cmpT(r7, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.movT(0, 0x0);
    }

    //LAB_801cd40
    CPU.cmpT(r7, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.movT(0, 0x1f);
    }

    //LAB_801cd46
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
    }

    //LAB_801cd4c
    CPU.cmpT(r3, 0x1f);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x1f);
    }

    //LAB_801cd52
    r5 = CPU.sp().value;
    MEMORY.ref(2, r5 + 0x4).setu(r3);
    r3 = MEMORY.ref(4, 0x801cdf0).get();
    r2 = CPU.r10().value;
    MEMORY.ref(2, r5).setu(r2);
    CPU.r10().value = r3;
    r2 = MEMORY.ref(4, 0x801cdf4).get();
    r1 = CPU.r10().value;
    MEMORY.ref(2, r5 + 0x2).setu(r7);
    r3 = MEMORY.ref(4, 0x801cdf8).get();
    r0 = CPU.addT(r5, 0x0);
    CPU.r9().value = r2;
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r6 = MEMORY.ref(4, 0x801cdfc).get();
    r3 = MEMORY.ref(4, 0x801ce00).get();
    r2 = CPU.addT(r6, 0x0);
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce04).get();
    r3 = CPU.r10().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce08).get();
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x801ce0c).get();
    CPU.r8().value = r3;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.r8().value;
    r3 = CPU.r9().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce10).get();
    r1 = MEMORY.ref(4, 0x801ce14).get();
    MEMORY.ref(2, r3).setu(r0);
    r2 = MEMORY.ref(4, 0x801ce18).get();
    r3 = CPU.r8().value;
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce1c).get();
    r1 = MEMORY.ref(4, 0x801ce20).get();
    MEMORY.ref(2, r3).setu(r0);
    r2 = MEMORY.ref(4, 0x801ce24).get();
    r3 = MEMORY.ref(4, 0x801ce28).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce2c).get();
    r2 = CPU.r10().value;
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce30).get();
    r3 = MEMORY.ref(4, 0x801ce34).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce38).get();
    r2 = CPU.movT(0, 0x80);
    MEMORY.ref(2, r3).setu(r0);
    r1 = MEMORY.ref(4, 0x801ce3c).get();
    r2 = CPU.lslT(r2, 9);
    r3 = MEMORY.ref(4, 0x801ce40).get();
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_801cc50(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, 0x801ce44).get();
    CPU.sp().value += 0x8;
    MEMORY.ref(2, r3).setu(r0);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x801de5c)
  public static int FUN_801de5c(final ArrayRef<UnsignedShortRef> text, int r1, int r2, int r3) {
    int r0;
    int r4;
    int r5;
    int r6;
    int r8;
    int r9;
    int r10;

    CPU.sp().value -= 0x44;

    int sp10 = r1;
    int sp0c = r2;
    r8 = r3;
    r5 = 0x800;
    r6 = 0;
    final Struct12fc r11 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int sp08 = mallocChip(r5);
    final int sp04 = getPointerTableEntry(19);
    final int sp00 = r11._ea7.get() << 12;

    r10 = CPU.sp().value + 0x14;
    MEMORY.call(0x3000164, r10, 0x10); // memzero

    if(sp00 == 0xf000) {
      r2 = r11._eae.get();
      MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + (r2 & 0xf)).getUnsigned());
      MEMORY.ref(1, r10 + 0x3).setu(0x3);
      MEMORY.call(0x3000168, sp08, r5, 0x4040404); // memfill32
    } else {
      //LAB_801ded4
      MEMORY.ref(1, r10 + 0x1).setu(r11._eae.get() & 0xf);
      MEMORY.ref(1, r10 + 0x3).setu(0x1);
      MEMORY.call(0x3000168, sp08, r5, 0xe0e0e0e); // memfill32
    }

    //LAB_801def6
    if(text != null) {
      //LAB_801defc
      //LAB_801e036
      int chr = text.get(r6).get();
      r6++;

      //LAB_801defe
      while(chr != 0) {
        if(chr > 0x1e) {
          //LAB_801dfb6
          r5 = sp04 + (chr & 0xff) * 0x20;
          r0 = sp08 + r8;
          r9 = 0;

          //LAB_801dfca
          do {
            r2 = MEMORY.ref(4, r5).get();
            r5 += 0x4;
            r4 = 0x3;

            //LAB_801dfce
            do {
              r3 = MEMORY.ref(1, r10 + (r2 & 0xf)).getUnsigned();
              if(r3 != 0) {
                MEMORY.ref(1, r0).setu(r3);
              }
              r0++;

              //LAB_801dfde
              r2 = r2 >>> 4;
              r3 = MEMORY.ref(1, r10 + (r2 & 0xf)).getUnsigned();
              if(r3 != 0) {
                MEMORY.ref(1, r0).setu(r3);
              }
              r0++;

              //LAB_801dff2
              r4--;
              r2 = r2 >>> 4;
            } while(r4 >= 0);

            r9++;
            r0 += 0xf8;
          } while(r9 < 8);

          if(chr == 0xf01d || chr == 0xf01f) {
            //LAB_801e014
            r8 += 0x8;
          } else {
            //LAB_801e01a
            if(chr == 0xf01e) {
              r3 = 0x3;
            } else {
              //LAB_801e024
              if(chr > 0x1f) {
                r3 = MEMORY.ref(1, 0x80370d4 + (chr & 0xff) - 0x20).getUnsigned();
              } else {
                //LAB_801e032
                r3 = 0x1;
              }
            }

            //LAB_801e034
            r8 += r3;
          }
        } else {
          //LAB_801df0a
          switch(chr) {
            case 8:
              r1 = text.get(r6).get();
              r6++;
              r11._eae.set(r1);
              MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + (r1 & 0xf)).getUnsigned());
              break;

            case 7:
            case 9:
            case 10:
              r11._eae.set(0xf);
              MEMORY.ref(1, r10 + 0x1).setu(MEMORY.ref(1, 0x80371b4 + 0xf).getUnsigned());
              break;

            case 3:
              r8 += MEMORY.ref(1, 0x80370d4).getUnsigned();
              break;

            case 14:
            case 15:
            case 0x1c:
              r6++;

            case 11:
            case 12:
            case 0x11:
            case 0x1d:
              r6++;
              break;
          }
        }

        chr = text.get(r6).get();
        r6++;
      }
    }

    //LAB_801e042
    r5 = sp08;
    r0 = r5;
    final int r6_0 = r8 + 0x7 >>> 3;
    r10 = r6_0 * 0x4;
    r8 = r6_0 * 0x8;
    r9 = 0x7;

    //LAB_801e05e
    do {
      r4 = r6_0;

      //LAB_801e06a
      while(r4 != 0) {
        r1 = MEMORY.ref(4, r5).get();
        r2 = MEMORY.ref(4, r5 + 0x4).get();
        r3 = CPU.lslT(r1, 4);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lsrT(r2, 4);
        r2 = CPU.orrT(r2, r3);
        r3 = 0xff00ff0;
        r1 = CPU.andT(r1, r3);
        r2 = CPU.andT(r2, 0xff00ff);
        r3 = CPU.lslT(r1, 8);
        r1 = CPU.orrT(r1, r3);
        r3 = CPU.lsrT(r2, 8);
        r2 = CPU.orrT(r2, r3);
        r3 = CPU.lslT(r1, 4);
        r3 = CPU.lsrT(r3, 16);
        r2 = CPU.lslT(r2, 16);
        r3 = CPU.orrT(r3, r2);
        r4 = CPU.subT(r4, 0x1);
        r5 = CPU.addT(r5, 0x8);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
      }

      //LAB_801e096
      r3 = r0 - r10;
      r0 = r3 + 0x100;
      r3 = r5 - r8;
      r5 = r3 + 0x100;
      r9--;
    } while(r9 >= 0);

    if(r6_0 != 0) {
      //LAB_801e0b6
      r0 = sp08;
      r9 = r6_0;

      //LAB_801e0d0
      do {
        r2 = r11._ea2.get();
        r5 = 0x7f;
        if(r2 != 0) {
          r5 = 0xff;
        }

        //LAB_801e0dc
        r1 = MEMORY.ref(2, sp10).getUnsigned() & 0x3ff;
        r3 = r1 - 0x80;
        if((r3 < 0 || r3 >= 0x80) && (r2 == 0 || r1 < 0x200 || r1 >= 0x280)) {
          //LAB_801e100
          r1 = r11._ea0.get() & r5;
          r4 = 0;
          //LAB_801e112
          while(r11._da0.get(r1).get() != 0) {
            r1++;
            r4++;
            r1 = r1 & r5;
            r4 = CPU.cmpT(r4, r5);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              break;
            }
          }

          //LAB_801e12a
          r11._ea0.set(r5 & 0x1);
          r11._da0.get(r1).set(0x1);
          CPU.cmpT(r1, 0x7f);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r1 = r1 + 0x180;
          } else {
            //LAB_801e190
            r1 = r1 | 0x80;
          }

          //LAB_801e194
          MEMORY.ref(2, sp10).setu(sp00 | r1);
          MEMORY.ref(2, sp0c).setu(sp00 | r1);
        }

        //LAB_801e1a0
        MEMORY.ref(4, 0x6000000 + r1 * 0x20).setu(MEMORY.ref(4, r0).get());
        MEMORY.ref(4, 0x6000004 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x100).get());
        MEMORY.ref(4, 0x6000008 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x200).get());
        MEMORY.ref(4, 0x600000c + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x300).get());
        MEMORY.ref(4, 0x6000010 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x400).get());
        MEMORY.ref(4, 0x6000014 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x500).get());
        MEMORY.ref(4, 0x6000018 + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x600).get());
        MEMORY.ref(4, 0x600001c + r1 * 0x20).setu(MEMORY.ref(4, r0 + 0x700).get());
        sp10 += 0x2;
        sp0c += 0x2;
        r0 += 0x4;
        r9--;
      } while(r9 != 0);
    }

    //LAB_801e22a
    setMallocAddress(sp08);

    CPU.sp().value += 0x44;
    return r6_0;
  }

  @Method(0x801e260)
  public static void FUN_801e260(final int r0, final int r1, final int r2, final int r3) {
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int r0_0 = r5._00.getAddress() + (r0 + r1 * 0x20) * 0x2; //TODO
    final int r8 = r5._ea2.get();
    final int sp00 = (0x20 - r2) * 0x2;

    //LAB_801e296
    for(int r6 = 0; r6 < r3; r6++) {
      //LAB_801e2ac
      for(int r4 = 0; r4 < r2; r4++) {
        final int r2_0 = MEMORY.ref(2, r0_0).getUnsigned() & 0x3ff;
        r0_0 += 0x2;

        if(r2_0 >= 0x80 && r2_0 < 0x100 || r8 != 0 && r2_0 > 0x1ff && r2_0 <= 0x27f) {
          //LAB_801e2ca
          r5._da0.get(r2_0 & 0xff ^ 0x80).and(0xfc);
        }

        //LAB_801e2e0
      }

      //LAB_801e2e6
      r0_0 += sp00;
    }

    //LAB_801e2f0
  }

  @Method(0x801e41c)
  public static void FUN_801e41c(final GraphicsStruct24 r5, int r1, final int r2, int r3, final int a4) {
    int r0;
    int r4;
    int r6;
    int r7;
    int r8;
    int r10;

    r10 = r3;
    final Struct12fc r9 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r7 = r1;
    r8 = r2;
    r6 = a4;
    if(r7 == r10) {
      //LAB_801e43c
      if(r8 != r6) {
        //LAB_801e442
        CPU.cmpT(r8, r6);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r4 = r8;
          r8 = r6;
          r6 = CPU.addT(r4, 0x0);
        }

        //LAB_801e44c
        FUN_801e260(r10 + r5._0c.get(), r8 + r5._0e.get(), 0x1, r6 - r8);
        r4 = r8;
        r0 = r9._00.getAddress() + ((r5._0e.get() + r8) * 0x20 + r5._0c.get() + r10) * 0x2; //TODO
        CPU.cmpT(r4, r6);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          //LAB_801e478
          do {
            r1 = MEMORY.ref(2, r0).getUnsigned();
            r3 = r1 - 0xf009;

            if(r4 == r8) {
              switch(r3) {
                case 1 ->
                  //LAB_801e560
                  r1 = 0xf00d;

                case 5 ->
                  //LAB_801e4d4
                  r1 = 0xf009;

                case 6, 7, 9, 10, 11, 12, 13, 14 ->
                  //LAB_801e564
                  r1 = 0xf00f;

                case 8 ->
                  //LAB_801e4d0
                  r1 = 0xf018;
              }
              //LAB_801e4d8
            } else if(r4 == r6) {
              switch(r3) {
                case 0 ->
                  //LAB_801e560
                  r1 = 0xf00d;

                case 5 ->
                  //LAB_801e534
                  r1 = 0xf00a;

                case 6, 7, 8, 9, 10, 12, 13, 14, 15 ->
                  //LAB_801e564
                  r1 = 0xf00f;

                case 11 ->
                  //LAB_801e530
                  r1 = 0xf019;
              }
            } else {
              //LAB_801e538
              switch(r3) {
                case 0, 1, 5 ->
                  //LAB_801e560
                  r1 = 0xf00d;
              }
            }

            //LAB_801e566
            MEMORY.ref(2, r0).setu(r1);
            r0 += 0x40;
            r4++;
            r4 = CPU.cmpT(r4, r6);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }
      }
    } else {
      //LAB_801e572
      if(r8 == r6) {
        //LAB_801e578
        if(r7 != r10) {
          //LAB_801e57e
          CPU.cmpT(r7, r10);
          if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
            r4 = CPU.addT(r7, 0x0);
            r7 = r10;
            r10 = r4;
          }

          //LAB_801e588
          FUN_801e260(r5._0c.get() + r7, r8 + r5._0e.get(), r10 - r7, 0x1);
          r4 = r7;
          r0 = r9._00.getAddress() + ((r5._0e.get() + r8) * 0x20 + r5._0c.get() + r7) * 0x2; //TODO
          CPU.cmpT(r4, r10);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_801e5b4
            do {
              r1 = MEMORY.ref(2, r0).getUnsigned();
              r3 = r1 - 0xf009;
              if(r4 == r7) {
                switch(r3) {
                  case 3 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5, 7, 8, 9, 10, 11, 12, 14, 15, 16 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;

                  case 6 ->
                    //LAB_801e618
                    r1 = 0xf00b;

                  case 13 ->
                    //LAB_801e614
                    r1 = 0xf01a;
                }
                //LAB_801e61c
              } else if(r4 == r10) {
                switch(r3) {
                  case 2 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;

                  case 6 ->
                    //LAB_801e680
                    r1 = 0xf00c;

                  case 14 ->
                    //LAB_801e67c
                    r1 = 0xf01b;
                }
              } else {
                //LAB_801e684
                switch(r3) {
                  case 2, 3, 6 ->
                    //LAB_801e6b0
                    r1 = 0xf00d;

                  case 5 ->
                    //LAB_801e6b4
                    r1 = 0xf00e;
                }
              }

              //LAB_801e6b6
              MEMORY.ref(2, r0).setu(r1);
              r0 += 0x2;
              r4++;
            } while(r4 <= r10);
          }
        }
      }
    }

    //LAB_801e6c2
  }

  @Method(0x801e7c0)
  public static void FUN_801e7c0(final int r0, final int r1, final int r2, final int r3) {
    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r7.textOffset_12b2.set(0);
    FUN_8018038(r0, 0x1);
    r7.text_eb0.get(r7.textOffset_12b2.get()).set(0);
    r7.textOffset_12b2.incr().and(0x1ff);

    final int r1_0 = (MEMORY.ref(2, r1 + 0xe).getUnsigned() + (r3 >>> 3) + 0x1) * 0x20 + MEMORY.ref(2, r1 + 0xc).getUnsigned() + (r2 >>> 3) + 0x1;
    if(r1_0 >= 0 && r1_0 < 0x280) {
      FUN_801de5c(r7.text_eb0, r7._00.getAddress() + r1_0 * 0x2, 0x6002000 + r1_0 * 0x2, r2 & 0x7);
    }

    //LAB_801e848
  }

  /** Called immediately getting to the title screen with no save data, string is Isaac's name. Possible string buffer overflow. */
  @Method(0x801e858)
  public static void FUN_801e858(final int r0, final GraphicsStruct24 r1, final int r2, final int r3) {
    final ArrayRef<UnsignedShortRef> r6 = MEMORY.ref(2, mallocBoard(0x200), ArrayRef.of(UnsignedShortRef.class, 0x100, 0x2, UnsignedShortRef::new));

    //LAB_801e87a
    int i;
    for(i = 0; MEMORY.ref(1, r0 + i).getUnsigned() != 0; i++) {
      r6.get(i).set(MEMORY.ref(1, r0 + i).getUnsigned());
    }

    //LAB_801e888
    r6.get(i).set(0);
    FUN_8017aa4(r6, r1, r2, r3);
    setMallocAddress(r6.getAddress());
  }

  @Method(0x801eadc)
  public static GraphicsStruct1c FUN_801eadc(final int r0, final int r1, final GraphicsStruct24 r2, final int r3, final int a4) {
    final GraphicsStruct1c r5 = FUN_8015e8c();
    if(r5 == null) {
      clearVramSlot(r0);
      return null;
    }

    //LAB_801eb00
    final int r1_0 = r3 + r2._0c.get() * 0x8 + 0x8 & 0x1ff;
    final int r2_0 = a4 + r2._0e.get() * 0x8 + 0x8 & 0xff;
    r5._00.clear();
    r5.packet_10.attribs_04.attrib0_00.set(r2_0);
    r5.packet_10.attribs_04.attrib1_02.set(r1_0);
    MEMORY.ref(4, r5.packet_10.attribs_04.attrib0_00.getAddress()).oru(r1); //TODO
    r5.packet_10.attribs_04.attrib2_04.set(vramSlots_3001b10.get(r0).vramAddr_02.get() >>> 5);
    r5.packet_10.attribs_04.rotationScaling_06.set(0);
    r5._0f.set(0xff);
    r5._06.set(r1_0);
    r5._08.set(r2_0);
    r5.slot_0e.set(r0);
    r5._04.set(0x1);
    r5._05.set(0x1);
    FUN_8016584(r2, r5);

    //LAB_801eb50
    return r5;
  }

  @Method(0x801ec6c)
  public static void FUN_801ec6c(int r0, final int r1, final int r2, final GraphicsStruct24 r3, final int a4, final int a5) {
    CPU.sp().value -= 0x10;

    final Struct12fc r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    if(FUN_80770c0(0x20) != 0) {
      if(r0 == 0) {
        r0 = 0x12;
      }

      //LAB_801ec94
      if(r0 == 1) {
        r0 = 0x13;
      }
    }

    //LAB_801ec9a
    final int r5 = FUN_8019d2c(r0);
    if(r5 == -1) {
      CPU.sp().value += 0x10;
      return;
    }

    int r6 = r2;
    if(r6 < 0 || r6 > 1) {
      if(r7._12ee.get() == 999) {
        r6 = 1;
      } else if(r7._12ec.get() == 999) {
        r6 = 0;
      } else {
        CPU.sp().value += 0x10;
        return;
      }
    }

    //LAB_801ecca
    final int r8 = 0xe + r6;
    FUN_801a4fc(r5, r1, CPU.sp().value + 0xc, CPU.sp().value + 0x8, r8, 0);

    final GraphicsStruct1c r0_0 = FUN_801eadc(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x80000000, r3, a4, a5);
    if(r0_0 != null) {
      r0_0._18.and(0xfff).or(r8 << 12);
      r0_0._04.set(0x2);
    }

    //LAB_801ed0c
    MEMORY.ref(2, r7._12ec.getAddress() + r6 * 0x2).setu(r5); //TODO huh?
    r7._12f0.get(r6).set(MEMORY.ref(4, CPU.sp().value + 0xc).get());

    //LAB_801ed1c
    CPU.sp().value += 0x10;
  }

  @Method(0x801edec)
  public static void FUN_801edec(final int r0) {
    final int r7 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    if(r7 == 0) {
      CPU.sp().value -= 0x4;
      MEMORY.ref(2, CPU.sp().value + 0x2).setu(0xe0e0);
      DMA.channels[3].SAD.setu(CPU.sp().value + 0x2);
      DMA.channels[3].DAD.setu(r0);
      DMA.channels[3].CNT.setu(0x810000a0);
      CPU.sp().value += 0x4;
    } else {
      //LAB_801ee24
      final int size = 0x214;
      final int addr = mallocChip(size);
      DMA.channels[3].SAD.setu(0x80158e8);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | size / 4);

      MEMORY.setFunction(addr, CopiedSegment80158e8.class, "FUN_80158e8", int.class, int.class);
      MEMORY.call(addr, r0, r7);

      setMallocAddress(addr);
    }

    //LAB_801ee4e
  }

  @Method(0x801f77c)
  public static int FUN_801f77c() {
    int r0;
    int r1;
    int r3;
    int r5;
    int r6;

    r0 = loadSaveList();
    r6 = CPU.movT(0, 0x9);
    r5 = CPU.movT(0, 0x0);
    r6 = CPU.negT(r6, r6);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = loadSavePreview();
      r1 = boardWramMallocHead_3001e50.offset(51 * 0x4).get();
      MEMORY.ref(2, 0x2002010).setu(r5);
      MEMORY.ref(2, 0x200200c).setu(r5);
      r6 = CPU.addT(r0, 0x0);
      r1 = CPU.addT(r1, 0x1070);
      r0 = CPU.movT(0, 0x2);

      //LAB_801f7a8
      do {
        r3 = CPU.movT(0, 0x1);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, 0x2002010).setu(0x1);
          r5 = CPU.addT(r5, 0x1);
        }

        //LAB_801f7b4
        r3 = CPU.movT(0, 0x2);
        r3 = MEMORY.ref(1, r1 + r3).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, 0x200200c).setu(0x1);
        }

        //LAB_801f7be
        r0 = CPU.subT(r0, 0x1);
        r1 = CPU.addT(r1, 0x40);
        CPU.cmpT(r0, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      if((heldButtonsLastFrame_3001ae8.get() & 0x120) != 0x120) { // Left/R
        MEMORY.ref(2, 0x2002010).setu(0);
      }
    }

    //LAB_801f7f6
    unloadSaveList();

    if(r6 != 0 && r5 == r6) {
      return r6 + 100;
    }

    //LAB_801f810
    //LAB_801f812
    return r6;
  }
}
