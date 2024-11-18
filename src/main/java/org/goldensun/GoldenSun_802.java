package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.GraphicsStruct24;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.Struct12fc;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSun.FUN_8005920;
import static org.goldensun.GoldenSun.FUN_8009288;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.FUN_8003d28;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.loadSaveList;
import static org.goldensun.GoldenSun.loadSavePreview;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.FUN_80053e8;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.loadUiTextures;
import static org.goldensun.GoldenSun.unloadSaveList;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_80162d4;
import static org.goldensun.GoldenSun_801.FUN_8016418;
import static org.goldensun.GoldenSun_801.FUN_8016478;
import static org.goldensun.GoldenSun_801.FUN_8016498;
import static org.goldensun.GoldenSun_801.FUN_8017364;
import static org.goldensun.GoldenSun_801.FUN_801776c;
import static org.goldensun.GoldenSun_801.FUN_8018850;
import static org.goldensun.GoldenSun_801.FUN_8019a54;
import static org.goldensun.GoldenSun_801.FUN_8019d2c;
import static org.goldensun.GoldenSun_801.FUN_8019da8;
import static org.goldensun.GoldenSun_801.FUN_8019e48;
import static org.goldensun.GoldenSun_801.FUN_801ccc0;
import static org.goldensun.GoldenSun_801.FUN_801d4cc;
import static org.goldensun.GoldenSun_801.FUN_801db70;
import static org.goldensun.GoldenSun_801.FUN_801e41c;
import static org.goldensun.GoldenSun_801.FUN_801e74c;
import static org.goldensun.GoldenSun_801.FUN_801e7c0;
import static org.goldensun.GoldenSun_801.FUN_801e858;
import static org.goldensun.GoldenSun_801.FUN_801eadc;
import static org.goldensun.GoldenSun_801.FUN_801f818;
import static org.goldensun.GoldenSun_801.FUN_801fd84;
import static org.goldensun.GoldenSun_801.FUN_801fd98;
import static org.goldensun.GoldenSun_801.FUN_801fda8;
import static org.goldensun.GoldenSun_801.FUN_801fe2c;
import static org.goldensun.GoldenSun_801.FUN_801ff14;
import static org.goldensun.GoldenSun_801.FUN_801ffd8;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_807.FUN_8077300;
import static org.goldensun.GoldenSun_808.FUN_808a5b0;
import static org.goldensun.GoldenSun_80b.FUN_80b0020;
import static org.goldensun.GoldenSun_80b.FUN_80b0028;
import static org.goldensun.GoldenSun_80b.FUN_80b0030;
import static org.goldensun.GoldenSun_80b.FUN_80b0038;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_802 {
  private GoldenSun_802() { }

  @Method(0x8020088)
  public static void FUN_8020088() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8020150)
  public static void FUN_8020150(final GraphicsStruct24 r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8020198)
  public static void FUN_8020198(final GraphicsStruct24 r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8020244)
  public static int FUN_8020244(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;
    int r8;
    final int r9;
    int r11;

    r9 = r1;
    r8 = r0;
    CPU.sp().value -= 0x28;
    r5 = mallocSlotChip(55, 0xa70);
    r7 = boardWramMallocHead_3001e50.offset(51 * 0x4).get();
    GraphicsStruct24 sp20 = null;
    GraphicsStruct24 sp1c = null;
    GraphicsStruct24 sp18 = null;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(1);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(boardWramMallocHead_3001e50.offset(15 * 0x4).get()); //TODO
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(FUN_8077300());
    if(r8 < 0) {
      r8 = 0;
    }

    //LAB_802028a
    if(r9 == 1) {
      r6 = 0;

      //LAB_802029e
      //LAB_80202bc
      while(MEMORY.ref(1, r7 + r8 * 0x40 + 0x105c).getUnsigned() == 0 || MEMORY.ref(1, r7 + r8 * 0x40 + 0x1070 + 0x1).get() != 0) {
        r8++;
        if(r8 == 3) {
          r8 = 0;
        }

        //LAB_80202ac
        r6++;
        if(r6 > 2) {
          break;
        }
      }
      if(r6 == 3) {
        r5 = -2;
        CPU.sp().value += 0x28;
        return r5;
      }
    } else {
      //LAB_80202d2
      CPU.cmpT(r9, 0x4);
      if(CPU.cpsr().getZero()) { // ==
        r3 = r8;
        r1 = MEMORY.ref(4, 0x8020580).get();
        r2 = CPU.lslT(r3, 6);
        r3 = CPU.addT(r2, r1);
        r3 = MEMORY.ref(1, r7 + r3).getUnsigned();
        r6 = CPU.movT(0, 0x0);

        //LAB_80202e6
        //LAB_8020304
        while(r3 == 0 || MEMORY.ref(1, r7 + r2 + r1 + 0x14 + 0x2).get() == 0) {
          r2 = CPU.movT(0, 0x1);
          r8 += r2;
          r3 = r8;
          CPU.cmpT(r3, 0x3);
          if(CPU.cpsr().getZero()) { // ==
            r1 = CPU.movT(0, 0x0);
            r8 = r1;
          }

          //LAB_80202f4
          r6 = CPU.addT(r6, 0x1);
          CPU.cmpT(r6, 0x2);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = r8;
          r1 = MEMORY.ref(4, 0x8020580).get();
          r2 = CPU.lslT(r3, 6);
          r3 = CPU.addT(r2, r1);
          r3 = MEMORY.ref(1, r7 + r3).getUnsigned();
        }
        CPU.cmpT(r6, 0x3);
        if(CPU.cpsr().getZero()) { // ==
          r5 = CPU.movT(0, 0x2);
          r5 = CPU.negT(r5, r5);
          CPU.sp().value += 0x28;
          return r5;
        }
      } else {
        //LAB_802031a
        if(r9 == 5) {
          r6 = 0;

          //LAB_802032e
          //LAB_802034c
          while(MEMORY.ref(1, r7 + 0x105c + r8 * 0x40).getUnsigned() == 0 || MEMORY.ref(1, r7 + r8 * 0x40 + 0x1070 + 0x1).get() == 0) {
            r8++;
            if(r8 == 3) {
              r8 = 0;
            }

            //LAB_802033c
            r6++;
            if(r6 > 2) {
              break;
            }
          }
          if(r6 == 3) {
            r5 = -2;
            CPU.sp().value += 0x28;
            return r5;
          }
        } else {
          //LAB_8020362
          if(r9 != 0) {
            r2 = r8 * 0x40;
            r6 = 0;
            if(MEMORY.ref(1, r7 + 0x105c + r2).getUnsigned() == 0) {
              r2 = r7 + 0x105c + r2;

              //LAB_802037c
              do {
                r8++;
                r2 += 0x40;
                if(r8 == 3) {
                  r2 = r7 + 0x105c;
                  r8 = 0;
                }

                //LAB_802038e
                r6++;
                if(r6 > 2) {
                  break;
                }
              } while(MEMORY.ref(1, r2).getUnsigned() == 0);
            }

            //LAB_802039a
            if(r6 == 3) {
              r5 = -2;
              CPU.sp().value += 0x28;
              return r5;
            }
          }
        }
      }
    }

    //LAB_80203b0
    r0 = CPU.sp().value + 0x24;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x8500029c);

    FUN_801fd84();
    final GraphicsStruct24 r10 = FUN_80162d4(0x1, 0x2, 0x1c, 0x7, 0x2);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r7 + 0x1040);
    r11 = 0;
    r6 = 0x2;
    r5 = r7 + 0x105c;

    //LAB_80203e8
    do {
      if(MEMORY.ref(1, r5).getUnsigned() == 0) {
        FUN_801e74c(0, r10, 0xa, r11);
      } else {
        //LAB_80203f2
        r3 = MEMORY.ref(2, r5 + 0x1a).getUnsigned();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = CPU.cmpT(r3, r1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          FUN_801e74c(0x1, r10, 0xa, r11);
        } else {
          //LAB_80203fe
          if(MEMORY.ref(4, r5 + 0x4).get() != MEMORY.ref(4, r5 + 0x1c).get()) {
            FUN_801e74c(0x3, r10, 0xa, r11);
          } else {
            //LAB_802040a
            if(r9 == 0x5 && MEMORY.ref(1, r5 + 0x15).get() == 0) {
              FUN_801e74c(0x2, r10, 0xa, r11);
            } else {
              //LAB_8020426
              FUN_801e858(MEMORY.ref(4, CPU.sp().value + 0x14).get() + 0x10, r10, 0xc, r11);
              FUN_801e74c(MEMORY.ref(2, r5 + 0x2).getUnsigned() + 0x99b, r10, 0x3e, r11);
              r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get() + 0xea3;
              MEMORY.ref(1, r2).setu(0x1);
            }
          }
        }
      }

      //LAB_802044e
      r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r2 = CPU.movT(0, 0x10);
      r3 = CPU.addT(r3, 0x40);
      r6 = CPU.subT(r6, 0x1);
      r11 += r2;
      r5 = CPU.addT(r5, 0x40);
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
      CPU.cmpT(r6, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    FUN_801e41c(r10, 0, 0x2, 0x1b, 0x2);
    FUN_801e41c(r10, 0, 0x4, 0x1b, 0x4);
    GraphicsStruct1c sp10 = FUN_8021620(r9, r10, 0x48 ,-0x18);
    r11 = 0x2;

    //LAB_8020494
    do {
      r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_802049c
        r2 = MEMORY.ref(4, 0x8020580).get();
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
        r5 = r8 * 0x40;
        r3 = CPU.addT(r5, r2);
        r3 = MEMORY.ref(1, r7 + r3).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_80204b0
          r1 = MEMORY.ref(4, 0x80205a4).get();
          r3 = CPU.addT(r5, r1);
          r0 = MEMORY.ref(1, r7 + r3).getUnsigned();
          r3 = CPU.addT(r7, r3);
          FUN_801ccc0(r0, MEMORY.ref(1, r3 + 0x1).getUnsigned());
          if(sp20 == null) {
            sp20 = FUN_80162d4(0x1, 0xa, 0xe, 0x9, r11);
          }

          //LAB_80204d6
          r3 = CPU.addT(r7, r5);
          r6 = r3 + 0x1040;
          FUN_8020198(sp20, r6);
          sleep(1);
          if(sp1c == null) {
            sp1c = FUN_80162d4(0x10, 0xa, 0xd, 0x3, r11);
          }

          //LAB_8020504
          FUN_801ff14();
          FUN_801fe2c(sp1c, 0, 0, r6);
          sleep(1);
          r1 = MEMORY.ref(4, 0x80205a8).get();
          r3 = CPU.addT(r5, r1);
          r1 = CPU.addT(r1, 0x1);
          r2 = MEMORY.ref(1, r7 + r3).get();
          r3 = CPU.addT(r5, r1);
          r3 = MEMORY.ref(1, r7 + r3).get();
          r1 = CPU.addT(r1, 0x1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r5, r1);
          r3 = MEMORY.ref(1, r7 + r3).get();
          r1 = CPU.addT(r1, 0x1);
          r2 = CPU.addT(r2, r3);
          r3 = CPU.addT(r5, r1);
          r3 = MEMORY.ref(1, r7 + r3).get();
          r2 = CPU.cmnT(r2, r3);
          if(!CPU.cpsr().getZero()) { // !=
            if(sp18 == null) {
              sp18 = FUN_80162d4(0x10, 0xe, 0xd, 0x5, r11);
            }

            //LAB_8020552
            FUN_8020150(sp18, r6);
            FUN_8020088();
            FUN_801ffd8(sp18, 0, 0);
          } else {
            //LAB_802056a
            FUN_8020088();
            FUN_8016418(sp18, 0x2);
            sp18 = null;
          }
        } else {
          //LAB_80205ac
          r2 = MEMORY.ref(4, 0x80207a8).get();
          r1 = MEMORY.ref(4, 0x80207ac).get();
          r3 = CPU.addT(r2, r1);
          r0 = MEMORY.ref(1, r3).getUnsigned();
          r3 = MEMORY.ref(4, 0x80207b0).get();
          r2 = CPU.addT(r2, r3);
          r1 = MEMORY.ref(1, r2).getUnsigned();
          FUN_801ccc0(r0, r1);
          FUN_8020088();
          FUN_801ff14();
          FUN_8016418(sp18, 0x2);
          FUN_8016418(sp1c, 0x2);
          FUN_8016418(sp20, 0x2);
          sp18 = null;
          sp1c = null;
          sp20 = null;
        }

        //LAB_80205e6
        FUN_8016498(r10);
        FUN_801e41c(r10, 0, 0x2, 0x1b, r11);
        FUN_801e41c(r10, 0, 0x4, 0x1b, 0x4);
        FUN_801fda8(r10, 0, r8 * 2, 0x1a, 0x1);
      }

      //LAB_802061e
      FUN_80216b4(sp10);
      sleep(1);
      r1 = MEMORY.ref(4, 0x80207b4).get();
      r2 = MEMORY.ref(4, r1).get();
      r3 = CPU.movT(0, 0x40);
      r2 = CPU.andT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_80f9010(0x6f);
        r1 = CPU.movT(0, 0x1);
        MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
        r8 = modS(r8 + 0x2, 0x3);

        //LAB_8020642
        //LAB_8020696
        while(r9 != 0) {
          r2 = r8 * 0x40;
          if(MEMORY.ref(1, r7 + 0x105c + r2).getUnsigned() != 0) {
            if(r9 != 1 || MEMORY.ref(1, r7 + r2 + 0x1070 + 0x1).get() == 0) {
              if(r9 != 4 || MEMORY.ref(1, r7 + r2 + 0x1070 + 0x2).get() != 0) {
                if(r9 != 5 || MEMORY.ref(1, r7 + r2 + 0x1070 + 0x1).get() != 0) {
                  break;
                }
              }
            }
          }
        }
      } else {
        //LAB_80206aa
        r2 = MEMORY.ref(4, r1).get();
        r3 = CPU.movT(0, 0x80);
        r2 = CPU.andT(r2, r3);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          FUN_80f9010(0x6f);
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x1);
          r8 = modS(r8 + 0x4, 0x3);

          //LAB_80206c0
          while(r9 != 0) {
            r1 = r8;
            r2 = CPU.lslT(r1, 6);
            r1 = MEMORY.ref(4, 0x80207b8).get();
            r3 = CPU.addT(r2, r1);
            r3 = MEMORY.ref(1, r7 + r3).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              if(r9 != 1 || MEMORY.ref(1, r7 + r2 + r1 + 0x14 + 0x1).get() == 0) {
                //LAB_80206e4
                if(r9 != 4 || MEMORY.ref(1, r7 + r2 + 0x1070 + 0x2).get() != 0) {
                  //LAB_80206fa
                  if(r9 != 5) {
                    break;
                  }

                  //LAB_8020702
                  r1 = MEMORY.ref(4, 0x80207bc).get();
                  r3 = CPU.addT(r2, r1);
                  r3 = CPU.addT(r7, r3);
                  r3 = MEMORY.ref(1, r3 + 0x1).getUnsigned();
                  r3 = CPU.lslT(r3, 24);
                  r3 = CPU.asrT(r3, 24);
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    break;
                  }
                }
              }
            }

            //LAB_8020714
            r8 = modS(r8 + 0x4, 0x3);
          }
        } else {
          //LAB_8020728
          r2 = MEMORY.ref(4, 0x80207c0).get();
          r3 = MEMORY.ref(4, r2).get();
          r1 = r11;
          r3 = CPU.andT(r3, r1);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_80203a4
            FUN_80f9010(0x71);
            r5 = -1;
            break;
          }

          //LAB_8020736
          r3 = MEMORY.ref(4, r2).get();
          r2 = CPU.movT(0, 0x1);
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_8020742
            FUN_80f9010(0x70);
            r5 = r8;
            break;
          }
        }
      }
    } while(true);

    //LAB_802074a
    FUN_8020088();
    FUN_801ff14();
    FUN_8016418(sp18, 0x2);
    FUN_8016418(sp1c, 0x2);
    FUN_8016418(sp20, 0x2);
    FUN_8016418(r10, 0x2);
    FUN_801fd98();
    freeSlot(55);
    r3 = MEMORY.ref(4, 0x80207a8).get();
    r1 = MEMORY.ref(4, 0x80207ac).get();
    r2 = CPU.addT(r3, r1);
    r0 = MEMORY.ref(1, r2).getUnsigned();
    r2 = MEMORY.ref(4, 0x80207b0).get();
    r3 = CPU.addT(r3, r2);
    FUN_801ccc0(r0, MEMORY.ref(1, r3).getUnsigned());
    sleep(1);

    //LAB_8020794
    CPU.sp().value += 0x28;
    return r5;
  }

  /** Save game menu */
  @Method(0x80207c4)
  public static int FUN_80207c4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;
    int r8;

    r8 = 0;
    r0 = loadSaveList();
    r6 = CPU.addT(r0, 0x0);
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, 0x80208c0).get();
      r1 = CPU.movT(0, 0x1);
      FUN_801776c(r0, r1);
      r3 = CPU.movT(0, 0x9);
      r3 = CPU.negT(r3, r3);
      r8 = r3;
    } else {
      //LAB_80207e8
      loadSavePreview();
      r3 = MEMORY.ref(4, 0x80208c4).get();
      r5 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, 0x80208c8).get();
      r1 = CPU.movT(0, 0x0);
      r2 = CPU.movT(0, 0x0);
      r0 = MEMORY.ref(2, r3 + r2).get();
      r0 = FUN_8020244(r0, r1);
      r3 = CPU.movT(0, 0x1);
      r7 = CPU.addT(r0, 0x0);
      r3 = CPU.negT(r3, r3);
      r7 = CPU.cmpT(r7, r3);
      if(CPU.cpsr().getZero()) { // ==
        r8 = r7;
      } else {
        //LAB_802080a
        r2 = MEMORY.ref(4, 0x80208cc).get();
        r3 = CPU.lslT(r7, 6);
        r3 = CPU.addT(r3, r2);
        r3 = MEMORY.ref(1, r5 + r3).getUnsigned();
        if(r3 != 0) {
          FUN_801776c(0x14, 0xd);

          //LAB_8020820
          //LAB_8020826
          while(FUN_8017364() == 0) {
            sleep(1);
          }

          if(FUN_8028df4(1, 0, 0, 1) != 0) {
            FUN_8019a54();
            unloadSaveList();
            return r8;
          }

          //LAB_8020844
          FUN_8019a54();
        }

        //LAB_8020848
        r3 = MEMORY.ref(4, 0x80208c8).get();
        r0 = CPU.movT(0, 0x55);
        MEMORY.ref(2, r3).setu(r7);
        FUN_80f9010(r0);
        r0 = MEMORY.ref(4, 0x80208d4).get();
        r1 = CPU.movT(0, 0xd);
        FUN_801776c(r0, r1);

        //LAB_802085c
        //LAB_8020862
        while(FUN_8017364() == 0) {
          r0 = CPU.movT(0, 0x1);
          sleep(r0);
        }

        FUN_801f818();
        FUN_808a5b0();
        r5 = MEMORY.ref(4, 0x80208d8).get();
        r0 = CPU.addT(r7, 0x0);
        r1 = CPU.addT(r5, 0x0);
        r0 = FUN_8005920(r0, r1);
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 5);
        r5 = CPU.addT(r5, r3);
        r6 = CPU.addT(r0, 0x0);
        r1 = CPU.addT(r5, 0x0);
        r0 = CPU.addT(r7, 0x3);
        r0 = FUN_8005920(r0, r1);
        r6 = CPU.orrT(r6, r0);
        FUN_8019a54();
        CPU.cmpT(r6, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = MEMORY.ref(4, 0x80208dc).get();
          r1 = CPU.movT(0, 0x1);
          FUN_801776c(r0, r1);
          r2 = CPU.movT(0, 0x3);
          r2 = CPU.negT(r2, r2);
          r8 = r2;
        } else {
          //LAB_80208a6
          r0 = MEMORY.ref(4, 0x80208e0).get();
          r1 = CPU.movT(0, 0x9);
          FUN_801776c(r0, r1);
        }
      }
    }

    //LAB_80208ae
    unloadSaveList();
    return r8;
  }

  /** Maybe decompressing a graphic and uploading to VRAM (uploads name entry keyboard to GPU) */
  @Method(0x80209d0)
  public static void FUN_80209d0(final GraphicsStruct24 r0_0, final int r1) {
    final int r10 = mallocBoard(0x300);
    decompress(r1, r10);
    int r3 = r0_0._0c.get() + r0_0._0e.get() * 0x20;
    final int r4 = r0_0._0a.get(); // maybe height
    int r7 = r10;
    int r0 = 0x6002000 + r3 * 0x2;
    int r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._00.getAddress() + r3 * 0x2; //TODO
    final int r2 = r0_0._08.get(); // maybe width

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
    setMallocAddress(r10);
  }

  @Method(0x8020a60)
  public static void FUN_8020a60(final GraphicsStruct24 r0, int r1, int r2, final int r3, final int a4, final int a5) {
    final Struct12fc r12 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r1 = r1 + r0._0c.get() + 0x1;
    r2 = r2 + r0._0e.get() + 0x1;

    int r6 = r3;
    if(r1 < 0) {
      r6 = r6 + r1;
      r1 = 0;
    }

    //LAB_8020a84
    if(r1 + r6 > 0x1d) {
      r6 = 0x1e - r1;
    }

    //LAB_8020a8e
    int r5 = a4;
    if(r2 < 0) {
      r5 = r5 + r2;
      r2 = 0;
    }

    //LAB_8020a96
    if(r2 + r5 > 0x1d) {
      r5 = 0x14 - r2;
    }

    //LAB_8020aa0
    if(r6 <= 0 || r5 <= 0) {
      return;
    }

    r1 = r2 * 0x40 + r1 * 0x2;

    //LAB_8020aae
    for(int n = 0; n < r5; n++) {
      int r4 = r12._00.getAddress() + r1; //TODO

      //LAB_8020aba
      for(int i = 0; i < r6; i++) {
        MEMORY.ref(2, r4).and(~0x1000).oru(a5 << 12);
        r4 += 0x2;
      }

      //LAB_8020aca
      r1 += 0x40;
    }

    r12._ea3.set(0x1);

    //LAB_8020ada
  }

  @Method(0x8020b14)
  public static int FUN_8020b14(final int r0) {
    final Struct12fc r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    CPU.sp().value -= 0x8;
    int r1 = 0;

    //LAB_8020b2a
    while(MEMORY.ref(1, r0 + r1).getUnsigned() != 0) {
      r4.text_eb0.get(r1).set(MEMORY.ref(1, r0 + r1).getUnsigned());
      r1++;
    }

    //LAB_8020b3a
    r4.text_eb0.get(r1).set(0);
    FUN_8018850(0, CPU.sp().value + 0x4, CPU.sp().value, null);
    final int ret = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.sp().value += 0x8;
    return ret;
  }

  @Method(0x8020b64)
  public static void FUN_8020b64(final GraphicsStruct24 r0, int r1) {
    CPU.sp().value -= 0x14;
    int r2;
    int r4 = 0;

    //LAB_8020b78
    while((r2 = MEMORY.ref(1, r1++).getUnsigned()) != 0) {
      MEMORY.ref(1, CPU.sp().value + r4++).setu(r2);
    }

    //LAB_8020b8e
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x8);
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x2);

    if(r4 < 7) {
      r2 = CPU.sp().value + r4;
      r4 = 7 - r4;

      //LAB_8020ba6
      while(r4 != 0) {
        MEMORY.ref(1, r2++).setu(0x5f);
        r4--;
      }

      r4 = 7;
    }

    //LAB_8020bb2
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x8);
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0xf);
    MEMORY.ref(1, CPU.sp().value + r4).setu(0);
    FUN_801e858(CPU.sp().value, r0, 0, -2);
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
    int r9;

    CPU.sp().value -= 0x60;
    int sp24 = 0;
    int sp20 = 0;
    int sp1c = 0;
    final int sp18 = CPU.sp().value + 0x51;
    final int sp2c = r0;
    final int sp14 = FUN_8077008(r0);
    final Struct12fc sp10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int sp0c = 0x1;
    r9 = 0x1;
    loadUiTextures();
    final GraphicsStruct24 r8 = FUN_80162d4(0x3, 0x6, 0x18, 0x9, 0x2);
    final GraphicsStruct24 sp28 = FUN_80162d4(0x8, 0x3, 0x8, 0x3, 0x2);
    FUN_8019da8(FUN_8019d2c(sp2c), 0, 3, 1);
    FUN_80209d0(r8, 0x8073864); // Upload name entry keyboard to GPU
    FUN_801e41c(r8, 0x12, 0, 0x12, 0x7); // I think this adds the inside borders to the name entry box
    sp10._ea3.set(sp0c);
    MEMORY.ref(1, CPU.sp().value + 0x50).setu(sp24);
    r1 = sp18;
    r2 = sp14;

    //LAB_8020c74
    do {
      r3 = MEMORY.ref(1, r2).getUnsigned();
      MEMORY.ref(1, r1).setu(r3);
      if(r3 != 0) {
        sp20++;
        sp1c++;
      }

      //LAB_8020c8c
      r2++;
      r1++;
    } while(r1 < CPU.sp().value + 0x5f);

    MEMORY.ref(1, sp18 + 0xe).setu(0);
    FUN_8020b64(sp28, sp14);
    r6 = 0x12;
    r7 = 0x5;
    r5 = getFreeVramSlot();
    if(r5 < 0x60) {
      FUN_8003fa4(r5, 0x80, 0x80310a4); //TODO
      final GraphicsStruct1c struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
      MEMORY.ref(4, CPU.sp().value + 0x40).setu(struct.getAddress()); //TODO
      FUN_80b0038(CPU.sp().value + 0x40, 0x8c + r8._0c.get() * 0x8, 0x34 + r8._0e.get() * 0x8);
    }

    //LAB_8020ce2
    //LAB_8020ce6
    r5 = getFreeVramSlot();
    if(r5 < 0x60) {
      FUN_8003fa4(r5, 0x80, 0x80317e4); //TODO
      final GraphicsStruct1c struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(struct.getAddress()); //TODO
      struct._0f.set(0xff);
      struct.packet_10.attribs_04.attrib2_04.and(~0xc00);
      FUN_80b0038(CPU.sp().value + 0x30, FUN_8020b14(sp18) + 0x46, 0x16);
    }

    //LAB_8020d68
    //LAB_8020d6c
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(0x50001c0);
    DMA.channels[3].CNT.setu(0x84000008);

    MEMORY.ref(2, 0x50001c8).setu(0x6318);
    int sp08 = sp20 + sp18;

    jmp_8021034:
    {
      //LAB_8020d86
      do {
        if(r6 == 0x12 && (r7 == 0x4 || r7 == 0x5)) {
          r5 = 0x3;
        } else {
          r5 = 0x1;
        }

        //LAB_8020db0
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xe);
        sleep(0x1);
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xf);
        if(r9 != 0) {
          r9 = 0;
          FUN_80b0030(CPU.sp().value + 0x40, (r8._0c.get() + r6) * 0x8 - 0x7, (r8._0e.get() + r7) * 0x8 + 0xf, 0x3);
        }

        //LAB_8020e02
        if(sp0c != 0) {
          sp0c = 0;
          FUN_80b0030(CPU.sp().value + 0x30, FUN_8020b14(sp18) + 0x46, 0x16, 0x3);
        }

        //LAB_8020e20
        FUN_80b0020(CPU.sp().value + 0x40);
        FUN_80b0028(CPU.sp().value + 0x30);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r0 = ticks_3001800.get() >>> 1;
        MEMORY.ref(2, r5 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r5 + 0x6).getUnsigned() + MEMORY.ref(1, 0x80371f6 + (r0& 0x7)).get() & 0x1ff);
        MEMORY.ref(1, r5 + 0x14).setu(MEMORY.ref(1, r5 + 0x8).getUnsigned() + MEMORY.ref(1, 0x80371f6 + (r0 + 0x5 & 0x7)).getUnsigned());

        if((pressedButtons_3001b04.get() & 0x40) != 0) {
          FUN_80f9010(0x6f);
          r9 = 0x1;
          r7--;
          if(r6 == 0x12) {
            //LAB_8020e9c
            r7 = 0x5 - ((-(0x3 ^ r7) | 0x3 ^ r7) >>> 31);
          } else if(r7 == -1) {
            r7 = 0x5;
          }
        }

        //LAB_8020eaa
        if((pressedButtons_3001b04.get() & 0x80) != 0) {
          FUN_80f9010(0x6f);
          r9 = 0x1;
          r7++;
          if(r6 == 0x12) {
            //LAB_8020ecc
            r7 = 0x4 + ((-(0x6 ^ r7) | 0x6 ^ r7) >>> 31);
          } else if(r7 == 0x6) {
            r7 = 0;
          }
        }

        //LAB_8020ed8
        if((pressedButtons_3001b04.get() & 0x20) != 0) {
          FUN_80f9010(0x6f);
          r6--;
          r9 = 0x1;
          if(r6 == -1) {
            r3 = r7 - 0x4;
            r6 = 0x12;
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = 0x10;
            }
          } else {
            //LAB_8020f02
            if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
              //LAB_8020f0e
              r6--;
            }
          }
        }

        //LAB_8020f12
        if((pressedButtons_3001b04.get() & 0x10) != 0) {
          FUN_80f9010(0x6f);
          r6++;
          r9 = 0x1;
          if(r6 == 0x13) {
            r6 = 0;
            //LAB_8020f30
          } else if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
            //LAB_8020f3c
            r6++;
          }

          //LAB_8020f3e
          if(r6 == 0x12) {
            r3 = r7 - 0x4;
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = 0;
            }
          }
        }

        //LAB_8020f4a
        if((pressedButtons_3001c94.get() & 0x8) != 0) { // Start
          FUN_80f9010(0x6f);
          r9 = 0x1;
          r6 = 0x12;
          r7 = 0x5;
        }

        jmp_8020f76:
        {
          //LAB_8020f64
          r5 = pressedButtons_3001b04.get() & 0x2;
          if(r5 == 0) {
            //LAB_8020fa6
            if((pressedButtons_3001b04.get() & 0x1) == 0) {
              continue;
            }

            //LAB_8020fb2
            FUN_80f9010(0x70);

            if(r6 != 0x12) {
              //LAB_8020fe6
              r3 = (r8._0e.get() + r7 + 1) * 0x20 + r8._0c.get() + r6 + 1;
              r3 = MEMORY.ref(1, sp10._00.getAddress() + r3 * 0x2).getUnsigned(); //TODO
              if(sp1c != 0x5) {
                //LAB_8021006
                MEMORY.ref(1, sp08).setu(r3);
                sp08++;
                MEMORY.ref(1, sp08).setu(r5);
                sp1c++;
                if(sp1c == 0x5) {
                  r6 = 0x12;
                  r7 = 0x5;
                  r9 = 0x1;
                }

                //LAB_8021020
                FUN_8016478(sp28);
                FUN_8020b64(sp28, sp18);
                sp0c = 0x1;
              }
              continue;
            }

            if(r7 == 0x5) {
              if(sp1c == 0) {
                //LAB_8020d34
                r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                MEMORY.ref(1, r2 + 0x5).setu(0xd);
                FUN_8016478(sp28);
                FUN_8020b64(sp28, sp14);
                sleep(0xa);
              } else {
                //LAB_8020fc8
                //LAB_8020fce
                for(r0 = 0; r0 < 15; r0++) {
                  MEMORY.ref(1, sp14 + r0).setu(MEMORY.ref(1, sp18 + r0).getUnsigned());
                }
              }
              break jmp_8021034;
            }

            //LAB_8020fde
            if(r7 == 0x4) {
              //LAB_8020fe4
              break jmp_8020f76;
            }
            continue;
          }
          FUN_80f9010(0x71);
        }

        //LAB_8020f76
        if(sp1c != 0) {
          sp1c--;
          sp08--;
          MEMORY.ref(1, sp08).setu(0);
          FUN_8016478(sp28);
          FUN_8020b64(sp28, sp18);
          sp0c = 0x1;
          continue;
        }

        break;
      } while(true);

      //LAB_8020f9e
      sp24 = -1;
    }

    //LAB_8021034
    FUN_8016418(r8, 0x2);
    FUN_8016418(sp28, 0x2);
    FUN_8019e48(sp2c);
    sleep(0x1);
    CPU.sp().value += 0x60;

    return sp24;
  }

  @Method(0x80215e0)
  public static void FUN_80215e0(final int textureIndex, final int slot) {
    final int dest = mallocSlotBoard(14, 0x400);
    if(slot < 0x60) {
      FUN_80053e8(MEMORY.ref(4, 0x8031864 + textureIndex * 0x4).get(), dest);
      FUN_8003fa4(slot, 0x200, dest);
      freeSlot(14);
    }

    //LAB_8021614
  }

  @Method(0x8021620)
  public static GraphicsStruct1c FUN_8021620(final int r0, final GraphicsStruct24 r1, final int r2, final int r3) {
    final int slot = getFreeVramSlot();

    if(slot >= 0x60) {
      return null;
    }

    FUN_80215e0(r0, slot);
    final GraphicsStruct1c r8 = FUN_801eadc(slot, 0x80004000, r1, r2, r3);
    r8._0f.set(0xfd);

    final GraphicsStruct1c r0_0 = FUN_801eadc(slot, 0x80004000, r1, r2 + 0x20, r3);
    r0_0._0f.set(0xfd);

    final int r1_0 = r0_0.packet_10.attribs_04.attrib2_04.get();
    r0_0.packet_10.attribs_04.attrib2_04.set(r1_0 & ~0x3ff | (r1_0 & 0x3ff) + 0x8 & 0x3ff);

    //LAB_80216a0
    return r8;
  }

  @Method(0x80216b4)
  public static void FUN_80216b4(final GraphicsStruct1c r0) {
    r0._14.set((r0._08.get() & 0xff) + MEMORY.ref(1, 0x8037226 + (ticks_3001800.get() >>> 2 & 0x7)).getUnsigned());
    final GraphicsStruct1c r0_0 = r0._00.deref();
    r0_0._14.set((r0._08.get() & 0xff) + MEMORY.ref(1, 0x8037226 + (ticks_3001800.get() >>> 2 & 0x7)).getUnsigned());
  }

  @Method(0x80216e8)
  public static void FUN_80216e8(final int r0, final int r1, final int r2) {
    final int r5 = mallocSlotBoard(14, 0x400);
    final int r2_0 = getPointerTableEntry(241);
    if(r1 < 0x60) {
      FUN_80053e8(r2_0 + MEMORY.ref(2, r2_0 + r0 * 0x2).getUnsigned(), r5);

      if(r2 != 0) {
        FUN_8009288(r5, 0x300);
      }

      //LAB_802172e
      FUN_8003fa4(r1, 0x400, r5);
      freeSlot(14);
    }

    //LAB_802173e
  }

  @Nullable
  @Method(0x8021750)
  public static GraphicsStruct1c FUN_8021750(final int r0, final int r1, final GraphicsStruct24 r2, final int r3, final int a4) {
    final int r5 = getFreeVramSlot();

    if(r5 == 0x60) {
      return null;
    }

    FUN_80216e8(r0, r5, r1);
    final GraphicsStruct1c r0_0 = FUN_801eadc(r5, 0x80000000, r2, r3, a4);
    r0_0._0f.set(0xfb);
    r0_0._15.or(0x20);

    //LAB_8021796
    return r0_0;
  }

  @Method(0x80217a4)
  public static void FUN_80217a4(final int r0) {
    int r1;
    int r3;
    final int r5;

    r1 = MEMORY.ref(4, 0x8037230 + (ticks_3001800.get() >>> 1 & 0x7) * 0x4).get();
    CPU.sp().value -= 0x8;
    r5 = r0;
    r1 = r1 / 0x100;
    if(r5 != 0) {
      r1 = r1 & 0xffff;
      r3 = MEMORY.ref(4, CPU.sp().value).get() & ~0xffff | r1;
      r3 = r3 & 0xffff;
      r1 = r1 << 16;
      r3 = r3 | r1;
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x4).and(~0xffff);
      MEMORY.ref(1, r5 + 0x17).and(~0x3e).or((FUN_8003d28(CPU.sp().value) & 0x1f) << 1);
      MEMORY.ref(1, r5 + 0x15).oru(0x3);
      MEMORY.ref(2, r5 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r5 + 0x6).getUnsigned() + 0xfff0 & 0x1ff);
      MEMORY.ref(1, r5 + 0x14).setu(MEMORY.ref(1, r5 + 0x8).getUnsigned() + 0xf0);
      MEMORY.ref(1, r5 + 0xf).setu(0xfc);
    }

    //LAB_8021840
    CPU.sp().value += 0x8;
  }

  @Method(0x8028194)
  public static void FUN_8028194() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x8028498).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r8().value = r3;
    r3 = MEMORY.ref(4, 0x802849c).get();
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.movT(0, 0x1f);
    r3 = CPU.lslT(r3, 1);
    r1 = MEMORY.ref(4, 0x80284a0).get();
    r3 = CPU.andT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r7 = MEMORY.ref(2, r1 + r3).getUnsigned();
    r0 = MEMORY.ref(4, 0x80284a4).get();
    r3 = CPU.addT(r7, r0);
    CPU.sp().value -= 0xc;
    r6 = CPU.r8().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r7, 0x0);
      r3 = CPU.subT(r3, 0xfd);
    }

    //LAB_80281c4
    r1 = CPU.movT(0, 0x98);
    r3 = CPU.asrT(r3, 2);
    r1 = CPU.lslT(r1, 1);
    r4 = MEMORY.ref(4, 0x80284a8).get();
    r7 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r1 = CPU.lslT(r7, 16);
    r3 = CPU.andT(r3, r4);
    r2 = MEMORY.ref(4, 0x80284ac).get();
    r1 = CPU.lsrT(r1, 16);
    r3 = CPU.orrT(r3, r1);
    r3 = CPU.andT(r3, r2);
    r1 = CPU.lslT(r1, 16);
    r3 = CPU.orrT(r3, r1);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    r0 = CPU.sp().value + 0x4;
    r3 = MEMORY.ref(4, r0 + 0x4).get();
    r3 = CPU.andT(r3, r4);
    MEMORY.ref(4, r0 + 0x4).setu(r3);
    r0 = FUN_8003d28(r0);
    r2 = CPU.movT(0, 0x8e);
    r2 += CPU.r8().value;
    r4 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r2 + r4).get();
    r5 = CPU.movT(0, 0x0);
    CPU.r9().value = r0;
    CPU.r10().value = r2;
    r5 = CPU.cmpT(r5, r3);
    if(!CPU.cpsr().getCarry()) { // unsigned <
      r4 = MEMORY.ref(4, 0x80284b0).get();

      //LAB_8028202
      do {
        r0 = CPU.movT(0, 0xc);
        r2 = MEMORY.ref(2, r6 + r0).get();
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.r8().value;
          r3 = CPU.addT(r3, 0x8c);
          r1 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r1).get();
          r5 = CPU.cmpT(r5, r3);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.lslT(r7, 3);
            r3 = CPU.subT(r3, r7);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r0 = MEMORY.ref(4, 0x80284b4).get();
              r3 = CPU.addT(r3, r0);
            }

            //LAB_8028222
            r3 = CPU.asrT(r3, 9);
            r3 = CPU.addT(r2, r3);
            r2 = CPU.movT(0, 0xe);
            r1 = MEMORY.ref(2, r6 + r2).get();
            r3 = CPU.subT(r3, 0x14);
            CPU.r12().value = r3;
            CPU.cmpT(r1, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.lslT(r7, 1);
              r3 = CPU.addT(r3, r7);
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                r3 = CPU.addT(r3, 0xff);
              }

              //LAB_802823c
              r3 = CPU.asrT(r3, 8);
              r3 = CPU.addT(r1, r3);
              r1 = CPU.addT(r3, 0x0);
              r1 = CPU.subT(r1, 0x14);
            } else {
              //LAB_8028246
              r3 = CPU.lslT(r7, 4);
              r3 = CPU.subT(r3, r7);
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                r3 = CPU.addT(r3, 0xff);
              }

              //LAB_8028250
              r3 = CPU.asrT(r3, 8);
              r1 = CPU.addT(r3, 0x0);
              r1 = CPU.subT(r1, 0x1e);
              r3 = CPU.movT(0, 0xff);
              r1 = CPU.andT(r1, r3);
            }

            //LAB_802825a
            r0 = CPU.addT(r6, 0x0);
            r3 = CPU.movT(0, 0x0);
            r2 = CPU.r9().value;
            MEMORY.ref(4, r0).setu(r3);
            r0 += 0x4;

            r3 = CPU.lslT(r2, 25);
            r3 = CPU.orrT(r3, r1);
            r1 = CPU.r12().value;
            r2 = CPU.lslT(r1, 16);
            r3 = CPU.orrT(r3, r2);
            r2 = MEMORY.ref(4, 0x80284b8).get();
            r3 = CPU.orrT(r3, r2);
            MEMORY.ref(4, r0).setu(r3);
            r0 += 0x4;

            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r3 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r3, r4);
            r3 = MEMORY.ref(2, r3 + 0x2).getUnsigned();
            r3 = CPU.lsrT(r3, 5);
            MEMORY.ref(4, r0).setu(r3);
            r1 = CPU.movT(0, 0xf6);
          } else {
            //LAB_8028282
            r0 = CPU.addT(r6, 0x0);
            r3 = CPU.movT(0, 0xe);
            r1 = MEMORY.ref(2, r6 + r3).get();
            r3 = CPU.movT(0, 0x0);
            MEMORY.ref(4, r0).setu(r3);
            r0 += 0x4;

            r3 = CPU.lslT(r2, 16);
            r1 = CPU.orrT(r1, r3);
            r3 = MEMORY.ref(4, 0x80284bc).get();
            r1 = CPU.orrT(r1, r3);
            r3 = MEMORY.ref(2, r6 + 0x12).getUnsigned();
            r3 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r3, r4);
            r3 = MEMORY.ref(2, r3 + 0x2).getUnsigned();
            MEMORY.ref(4, r0).setu(r1);
            r0 += 0x4;

            r3 = CPU.lsrT(r3, 5);
            MEMORY.ref(4, r0).setu(r3);
            r1 = CPU.movT(0, 0xf5);
          }

          //LAB_80282a4
          MEMORY.ref(4, CPU.sp().value).setu(r4);
          insertIntoRenderQueue(MEMORY.ref(4, r6, RenderPacket0c::new), r1);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80282ae
        r1 = CPU.r10().value;
        r0 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r1 + r0).get();
        r5 = CPU.addT(r5, 0x1);
        r6 = CPU.addT(r6, 0x14);
        r5 = CPU.cmpT(r5, r3);
      } while(!CPU.cpsr().getCarry()); // unsigned <
    }

    final int lr;

    //LAB_80282bc
    r3 = CPU.r8().value;
    r3 = CPU.addT(r3, 0x94);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_80283ae
      r3 = MEMORY.ref(4, 0x80284c0).get();
      r1 = MEMORY.ref(4, r3).get();
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.r10().value;
        r4 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r0 + r4).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = MEMORY.ref(4, 0x80284c4).get();
          r3 = CPU.addT(r1, r2);
          r2 = MEMORY.ref(1, r3).getUnsigned();
          r3 = CPU.lslT(r2, 2);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 5);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          r1 = CPU.addT(r1, r3);
          r3 = CPU.movT(0, 0x8c);
          r3 += CPU.r8().value;
          r4 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r4).get();
          CPU.r12().value = r3;
          r3 = CPU.lslT(r2, 2);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          lr = r1;
          r1 = CPU.addT(r3, 0x0);
          r2 = CPU.r8().value;
          r1 = CPU.addT(r1, 0xc);
          r6 = CPU.lslT(r7, 1);
          r0 = MEMORY.ref(2, r2 + r1).get();
          r4 = MEMORY.ref(4, 0x80284c8).get();
          r3 = CPU.addT(r6, r7);
          r2 = CPU.lslT(r3, 2);
          r3 = CPU.addT(r2, r4);
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r4 = CPU.addT(r4, 0xff);
            r3 = CPU.addT(r2, r4);
          }

          //LAB_80283fe
          r3 = CPU.asrT(r3, 8);
          r2 = CPU.subT(r0, r3);
          r2 = CPU.lslT(r2, 8);
          r3 = CPU.addT(r0, r3);
          r2 = CPU.addT(r2, r3);
          r0 = CPU.addT(r2, 0x0);
          r2 = CPU.r8().value;
          r3 = CPU.addT(r2, r1);
          r4 = CPU.movT(0, 0x2);
          r2 = MEMORY.ref(2, r3 + r4).get();
          r4 = MEMORY.ref(4, 0x80284cc).get();
          r1 = CPU.lslT(r7, 5);
          r3 = CPU.addT(r1, r4);
          r0 = CPU.addT(r0, 0x17);
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r4 = MEMORY.ref(4, 0x80284d0).get();
            r3 = CPU.addT(r1, r4);
          }

          //LAB_8028422
          r3 = CPU.asrT(r3, 9);
          r3 = CPU.subT(r2, r3);
          r2 = CPU.subT(r3, 0x1);
          r3 = CPU.lslT(r2, 2);
          r3 += lr;
          r5 = CPU.addT(r2, 0x0);
          r1 = CPU.addT(r3, 0x6);
          CPU.cmpT(r5, 0x87);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            r4 = CPU.movT(0, 0xff);

            //LAB_8028436
            do {
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r3 = CPU.addT(r4, 0x0);
              r3 = CPU.andT(r3, r2);
              r3 = CPU.orrT(r3, r0);
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r1).setu(r3);
              r1 = CPU.addT(r1, 0x4);
              CPU.cmpT(r5, 0x87);
            } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
          }

          //LAB_8028448
          r2 = CPU.r8().value;
          r1 = CPU.movT(0, 0xc);
          r0 = MEMORY.ref(2, r2 + r1).get();
          r1 = CPU.r12().value;
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r1 + r4).get();
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r3 = CPU.addT(r6, r7);
            r2 = MEMORY.ref(4, 0x80284c8).get();
            r1 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r1, r2);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r4 = MEMORY.ref(4, 0x80284d4).get();
              r3 = CPU.addT(r1, r4);
            }

            //LAB_8028468
            r3 = CPU.asrT(r3, 8);
            r0 = CPU.subT(r0, r3);
          }

          //LAB_802846c
          r1 = MEMORY.ref(4, 0x80284d8).get();
          r0 = CPU.lslT(r0, 8);
          r1 += lr;
          r5 = CPU.movT(0, 0x88);
          r4 = CPU.movT(0, 0xff);

          //LAB_8028476
          do {
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = CPU.addT(r4, 0x0);
            r3 = CPU.andT(r3, r2);
            r3 = CPU.orrT(r3, r0);
            r5 = CPU.addT(r5, 0x1);
            MEMORY.ref(2, r1).setu(r3);
            r1 = CPU.addT(r1, 0x4);
            CPU.cmpT(r5, 0x9f);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }
      }
    } else {
      r3 = MEMORY.ref(4, 0x80284c0).get();
      r1 = MEMORY.ref(4, r3).get();
      CPU.cmpT(r1, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_80282d2
        r0 = CPU.r10().value;
        r4 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r0 + r4).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_80282de
          r2 = MEMORY.ref(4, 0x80284c4).get();
          r3 = CPU.addT(r1, r2);
          r2 = MEMORY.ref(1, r3).getUnsigned();
          r3 = CPU.lslT(r2, 2);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 5);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          r1 = CPU.addT(r1, r3);
          r3 = CPU.movT(0, 0x8c);
          r3 += CPU.r8().value;
          r4 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r4).get();
          lr = r3;
          r3 = CPU.lslT(r2, 2);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          CPU.r10().value = r1;
          r1 = CPU.addT(r3, 0x0);
          r4 = CPU.lslT(r7, 1);
          r2 = CPU.r8().value;
          r1 = CPU.addT(r1, 0xc);
          r0 = MEMORY.ref(2, r2 + r1).get();
          CPU.r12().value = r4;
          r3 = CPU.addT(r4, r7);
          r4 = MEMORY.ref(4, 0x80284c8).get();
          r3 = CPU.lslT(r3, 2);
          r2 = CPU.addT(r3, r4);
          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r4 = CPU.addT(r4, 0xff);
            r2 = CPU.addT(r3, r4);
          }

          //LAB_802831e
          r2 = CPU.asrT(r2, 8);
          r3 = CPU.subT(r0, r2);
          r3 = CPU.lslT(r3, 8);
          r2 = CPU.addT(r0, r2);
          r3 = CPU.addT(r3, r2);
          r2 = CPU.r8().value;
          r0 = CPU.addT(r3, 0x0);
          r3 = CPU.addT(r2, r1);
          r4 = CPU.movT(0, 0x2);
          r3 = MEMORY.ref(2, r3 + r4).get();
          r1 = MEMORY.ref(4, 0x80284cc).get();
          r2 = CPU.lslT(r7, 5);
          r4 = CPU.addT(r3, 0x0);
          r3 = CPU.addT(r2, r1);
          r0 = CPU.addT(r0, 0x17);
          r4 = CPU.addT(r4, 0x18);
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = MEMORY.ref(4, 0x80284d0).get();
            r3 = CPU.addT(r2, r1);
          }

          //LAB_8028346
          r3 = CPU.asrT(r3, 9);
          r3 = CPU.addT(r4, r3);
          r1 = CPU.r10().value;
          r4 = CPU.addT(r3, 0x1);
          r5 = CPU.movT(0, 0x18);
          r1 = CPU.addT(r1, 0x66);
          r5 = CPU.cmpT(r5, r4);
          if(!CPU.cpsr().getCarry()) { // unsigned <
            r6 = CPU.movT(0, 0xff);

            //LAB_8028358
            do {
              r2 = MEMORY.ref(2, r1).getUnsigned();
              r3 = CPU.addT(r6, 0x0);
              r3 = CPU.andT(r3, r2);
              r3 = CPU.orrT(r3, r0);
              r5 = CPU.addT(r5, 0x1);
              MEMORY.ref(2, r1).setu(r3);
              r1 = CPU.addT(r1, 0x4);
              r5 = CPU.cmpT(r5, r4);
            } while(!CPU.cpsr().getCarry()); // unsigned <
          }

          //LAB_802836a
          r3 = CPU.r8().value;
          r1 = lr;
          r2 = CPU.movT(0, 0xc);
          r0 = MEMORY.ref(2, r3 + r2).get();
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r1 + r4).get();
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r2 = CPU.r12().value;
            r3 = CPU.addT(r2, r7);
            r4 = MEMORY.ref(4, 0x80284c8).get();
            r1 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r1, r4);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r2 = MEMORY.ref(4, 0x80284d4).get();
              r3 = CPU.addT(r1, r2);
            }

            //LAB_802838c
            r3 = CPU.asrT(r3, 8);
            r0 = CPU.subT(r0, r3);
          }

          //LAB_8028390
          r1 = CPU.r10().value;
          r0 = CPU.lslT(r0, 8);
          r1 = CPU.addT(r1, 0x6);
          r5 = CPU.movT(0, 0x0);
          r4 = CPU.movT(0, 0xff);

          //LAB_802839a
          do {
            r2 = MEMORY.ref(2, r1).getUnsigned();
            r3 = CPU.addT(r4, 0x0);
            r3 = CPU.andT(r3, r2);
            r3 = CPU.orrT(r3, r0);
            r5 = CPU.addT(r5, 0x1);
            MEMORY.ref(2, r1).setu(r3);
            r1 = CPU.addT(r1, 0x4);
            CPU.cmpT(r5, 0x17);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=
        }
      }
    }

    //LAB_8028488
    CPU.sp().value += 0xc;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x80284dc)
  public static int FUN_80284dc() {
    final int r5 = mallocSlotBoard(58, 0x98);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x85000026);
    CPU.sp().value += 0x4;

    setTickCallback(getRunnable(GoldenSun_802.class, "FUN_8028194"), 0xc76);
    return r5;
  }

  @Method(0x802851c)
  public static void FUN_802851c() {
    final int r5 = boardWramMallocHead_3001e50.offset(58 * 0x4).get();
    clearTickCallback(getRunnable(GoldenSun_802.class, "FUN_8028194"));

    final int r0 = MEMORY.ref(4, r5 + 0x78).get();
    if(r0 != 0) {
      FUN_8016418(MEMORY.ref(4, r0, GraphicsStruct24::new), 0x2); //TODO
    }

    //LAB_8028534
    //LAB_8028546
    for(int r6 = 0; r6 < MEMORY.ref(2, r5 + 0x8e).get(); r6++) {
      clearVramSlot(MEMORY.ref(2, r5 + 0x12 + r6 * 0x14).getUnsigned());
    }

    //LAB_8028558
    freeSlot(58);
    sleep(0x1);
  }

  /** Handles yes/no dialogue selection */
  @Method(0x8028574)
  public static int FUN_8028574(final int r0) {
    final int r8 = boardWramMallocHead_3001e50.offset(58 * 0x4).get();
    MEMORY.ref(2, r8 + 0x8c).setu(r0);

    //LAB_8028598
    jmp_8028672:
    do {
      FUN_8016478(MEMORY.ref(4, r8 + 0x78).deref(4).cast(GraphicsStruct24::new));

      int r0_0 = MEMORY.ref(2, r8 + 0x92).get();
      if(r0_0 != 0) {
        r0_0 = r0_0 + MEMORY.ref(2, r8 + 0x8c).get();
      } else {
        //LAB_80285c0
        final int r3 = MEMORY.ref(2, r8 + 0x8c).get() + 0x84;
        r0_0 = MEMORY.ref(1, r8 + r3).getUnsigned() + 0x1f;
      }

      //LAB_80285d0
      FUN_801e7c0(r0_0, MEMORY.ref(4, r8 + 0x78).get(), 0, 0);

      //LAB_80285e6
      do {
        sleep(1);

        if((pressedButtons_3001c94.get() & 0x1) != 0) {
          break jmp_8028672;
        }

        if((pressedButtons_3001c94.get() & 0x2) != 0 || (pressedButtons_3001c94.get() & 0x8) != 0) {
          //LAB_80285b4
          FUN_80f9010(0x71);
          return -1;
        }

        if((pressedButtons_3001b04.get() & 0x20) != 0 || (pressedButtons_3001b04.get() & 0x40) != 0) {
          //LAB_8028620
          FUN_80f9010(0x6f);

          MEMORY.ref(2, r8 + 0x8c).decr();
          if(MEMORY.ref(2, r8 + 0x8c).get() < 0) {
            MEMORY.ref(2, r8 + 0x8c).setu(MEMORY.ref(2, r8 + 0x8e).getUnsigned() - 1);
          }

          break;
        }

        //LAB_802863e
        if((pressedButtons_3001b04.get() & 0x10) != 0 || (pressedButtons_3001b04.get() & 0x80) != 0) {
          //LAB_8028652
          FUN_80f9010(0x6f);

          MEMORY.ref(2, r8 + 0x8c).incr();
          if(MEMORY.ref(2, r8 + 0x8c).get() >= MEMORY.ref(2, r8 + 0x8e).get()) {
            MEMORY.ref(2, r8 + 0x8c).setu(0);
          }

          break;
        }
      } while(true);
    } while(true);

    //LAB_8028672
    FUN_80f9010(0x70);

    //LAB_802867e
    return MEMORY.ref(2, r8 + 0x8c).get();
  }

  @Method(0x802875c)
  public static void FUN_802875c(final int slot, final int r1) {
    final int r6 = mallocChip(0x400);
    final int r0_0 = getPointerTableEntry(241);
    FUN_80053e8(r0_0 + MEMORY.ref(2, r0_0 + r1 * 0x2).getUnsigned(), r6);
    FUN_8003fa4(slot, 0x400, r6);
    setMallocAddress(r6);
  }

  @Method(0x80287a8)
  public static void FUN_80287a8(final int r0) {
    final int r8 = boardWramMallocHead_3001e50.offset(58 * 0x4).get();
    final int r7 = MEMORY.ref(2, r8 + 0x8e).get();
    if(r7 <= 5) {
      MEMORY.ref(2, r8 + 0x8e).incr();
      final int slot = getFreeVramSlot();
      FUN_802875c(slot, r0);
      final int r5 = r8 + r7 * 0x14;
      MEMORY.ref(2, r5 + 0xc).setu(r7 * 0x18 + 0x20);
      MEMORY.ref(2, r5 + 0xe).setu(0x88);
      MEMORY.ref(2, r5 + 0x12).setu(slot);
      MEMORY.ref(1, r8 + 0x84 + r7).setu(r0);
    }

    //LAB_80287f8
  }

  @Method(0x8028808)
  public static void FUN_8028808(final int r0, final int r1, final int r2) {
    final int r7 = boardWramMallocHead_3001e50.offset(58 * 0x4).get();
    MEMORY.ref(2, r7 + 0x90).setu(r1 + 0x2);
    MEMORY.ref(2, r7 + 0x92).setu(r2);
    MEMORY.ref(2, r7 + 0x94).setu(r0);
    final int r0_0 = 0xf - (MEMORY.ref(2, r7 + 0x8e).get() * 3 + divideS(MEMORY.ref(2, r7 + 0x90).get() * 2, 0x3)) / 2;

    //LAB_8028868
    for(int i = 0; i < MEMORY.ref(2, r7 + 0x8e).get(); i++) {
      final int r2_0 = r7 + i * 0x14;
      MEMORY.ref(2, r2_0 + 0xc).setu(r0_0 + i * 0x3 << 3);
      MEMORY.ref(2, r2_0 + 0xe).setu(r0 << 3);
    }

    //LAB_802887e
    MEMORY.ref(4, r7 + 0x78).setu(FUN_80162d4(r0_0, r0, MEMORY.ref(2, r7 + 0x90).get(), 0x3, 0x2).getAddress()); //TODO
  }

  @Method(0x8028df4)
  public static int FUN_8028df4(final int r0, final int r1, final int r2, final int r3) {
    int r5 = r2;
    int r6 = r3;
    int r8 = 0;

    FUN_80284dc();

    if(r5 == 0) {
      r5 = 0x3;
    }

    //LAB_8028e12
    if(r0 != 0) {
      r8 = 0x11;
    }

    //LAB_8028e1a
    FUN_80287a8(0x5); // Load yes/no face
    FUN_80287a8(0x6);
    FUN_8028808(r8, r5, r1);
    r6 = FUN_8028574(r6);
    FUN_802851c();

    if(r6 == -1) {
      r6 = 1;
    }

    //LAB_8028e46
    return r6;
  }

  @Method(0x8029504)
  public static int FUN_8029504() {
    //LAB_8029506
    do {
      int r5;
      do {
        r5 = FUN_801db70();
        if(r5 == -1) {
          return -1;
        }

        if(r5 != 0) {
          break;
        }

        final int r0 = FUN_80207c4();
        if(r0 != -1) {
          return r0;
        }
      } while(true);

      //LAB_8029524
      if(r5 == 1) {
        FUN_801776c(0xc2a, 0x1);
        MEMORY.ref(1, 0x3001cc8).setu(1);
        break;
      }

      //LAB_8029536
      if(r5 != 2) {
        break;
      }
    } while(FUN_801d4cc() == -1);

    //LAB_8029542
    //LAB_8029544
    return 0;
  }
}
