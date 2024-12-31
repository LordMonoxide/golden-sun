package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Item2c;
import org.goldensun.types.Map194;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Structccc;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSunVars._2000404;
import static org.goldensun.GoldenSunVars._2000406;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.entranceId_2000402;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.mapId_2000400;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

/**
 * Menu overlay?
 */
public final class Decompressed87795e8 {
  private Decompressed87795e8() { }

  @Method(0x2008030)
  public static int FUN_2008030() {
    return 0x2009658;
  }

  @Method(0x200803c)
  public static int FUN_200803c() {
    return 0x2009688;
  }

  @Method(0x2008044)
  public static int FUN_2008044() {
    return 0x200968c;
  }

  @Method(0x200804c)
  public static int FUN_200804c() {
    return 0x20096a4;
  }

  @Method(0x2008054)
  public static void FUN_2008054() {
    int r0;
    int r1;
    int r3;
    int r4;

    FUN_2009364(0);
    GPU.BG2CNT.setu(0x681);
    MEMORY.ref(2, 0x3001ada).setu(0);
    r4 = getPointerTableEntry(26);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(0x5000000);
    DMA.channels[3].CNT.setu(0x84000070);

    decompress(r4 + 0x1c0, tileAttribs_2010000.getAddress());
    DMA.channels[3].SAD.setu(tileAttribs_2010000.getAddress());
    DMA.channels[3].DAD.setu(0x6006800);
    DMA.channels[3].CNT.setu(0x84002580);

    r1 = 0x6003000;
    r3 = 0x1a0;

    //LAB_20080cc
    for(r4 = 0; r4 < 0x14; r4++) {
      //LAB_20080ce
      for(r0 = 0; r0 < 0x1e; r0++) {
        MEMORY.ref(2, r1).setu(r3);
        r3++;
        r1 += 0x2;
      }

      MEMORY.ref(2, r1).setu(0x1ff);
      r1 += 0x2;
      MEMORY.ref(2, r1).setu(0x1ff);
      r1 += 0x2;
    }

    r3 = 0x3001ad0;

    //LAB_20080f8
    for(r4 = 0; r4 < 4; r4++) {
      MEMORY.ref(2, r3 + 0x2).setu(0);
      MEMORY.ref(2, r3).setu(0);
      r3 += 0x4;
    }

    DMA.channels[3].SAD.setu(0x3001ad0);
    DMA.channels[3].DAD.setu(GPU.BG0HOFS.getAddress());
    DMA.channels[3].CNT.setu(0x84000004);

    boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._14.set(0x1400);
    FUN_200949c(playerMapActorIndex_2000434.get())._55.set(0);
  }

  @Method(0x2008154)
  public static void FUN_2008154() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;
    final int r5;
    final int r6;

    r3 = MEMORY.ref(4, 0x20081e0).get();
    r2 = MEMORY.ref(2, r3).getUnsigned();
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(2, r3).setu(r2);
    r4 = MEMORY.ref(4, 0x20081e4).get();
    r2 = CPU.lslT(r2, 16);
    r5 = CPU.lsrT(r2, 17);
    r0 = MEMORY.ref(4, 0x20081e8).get();
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r1 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r0).setu(r0);
    r2 = MEMORY.ref(2, r4).getUnsigned();
    CPU.cmpT(r2, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, 0x1);
      r3 = CPU.addT(r3, r4);
      MEMORY.ref(2, r4).setu(r2);
      r2 = MEMORY.ref(4, 0x20081ec).get();
      r3 = CPU.addT(r3, 0x4);
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = MEMORY.ref(4, 0x20081f0).get();
      MEMORY.ref(4, r3).setu(r2);
      r3 += 0x4;
      r2 = CPU.movT(0x80);
      r2 = CPU.lslT(r2, 10);
      MEMORY.ref(4, r3).setu(r2);
    }

    //LAB_200818e
    MEMORY.ref(2, r0).setu(r1);
    r3 = MEMORY.ref(2, r0).getUnsigned();
    r6 = CPU.addT(r3, 0x0);
    MEMORY.ref(2, r0).setu(r0);
    r3 = MEMORY.ref(2, r4).getUnsigned();
    CPU.cmpT(r3, 0x1f);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r2 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r2, r3);
      r0 = CPU.lslT(r5, 16);
      r3 = CPU.addT(r3, 0x1);
      r1 = CPU.lsrT(r0, 16);
      MEMORY.ref(2, r4).setu(r3);
      r3 = CPU.movT(0x10);
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.subT(r3, r1);
      r2 = CPU.addT(r2, r4);
      r3 = CPU.lslT(r3, 8);
      r2 = CPU.addT(r2, 0x4);
      r3 = CPU.orrT(r3, r1);
      MEMORY.ref(4, r2).setu(r3);
      r2 += 0x4;
      r3 = MEMORY.ref(4, 0x20081f4).get();
      MEMORY.ref(4, r2).setu(r3);
      r2 += 0x4;
      r3 = CPU.movT(0x80);
      r3 = CPU.lslT(r3, 10);
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_20081c4
      r0 = CPU.lslT(r5, 16);
    }

    //LAB_20081c6
    r3 = MEMORY.ref(4, 0x20081e8).get();
    MEMORY.ref(2, r3).setu(r6);
    r3 = CPU.movT(0xf0);
    r3 = CPU.lslT(r3, 12);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      clearTickCallback(getRunnable(Decompressed87795e8.class, "FUN_2008154"));
    }

    //LAB_20081d8
  }

  @Method(0x20081fc)
  public static void FUN_20081fc() {
    if(MEMORY.ref(2, 0x20096b2).get() == 0) {
      final int r4 = MEMORY.ref(2, 0x20096ba).get();
      if(r4 != 0) {
        if(heldButtonsLastFrame_3001ae8.get() == 0) {
          MEMORY.ref(2, 0x20096ba).setu(0);
        }
      } else {
        //LAB_2008220
        if(heldButtonsLastFrame_3001ae8.get() != 0) {
          if(heldButtonsLastFrame_3001ae8.get() == MEMORY.ref(2, 0x20094d4 + MEMORY.ref(2, 0x20096b6).get() * 0x2).getUnsigned()) {
            MEMORY.ref(2, 0x20096b6).incr();
            MEMORY.ref(2, 0x20096ba).setu(1);

            if(MEMORY.ref(2, 0x20094d4 + MEMORY.ref(2, 0x20096b6).get() * 0x2).getUnsigned() == 0) {
              MEMORY.ref(2, 0x20096b2).setu(1);
              playSound(0x6e);
            }
          } else {
            //LAB_2008274
            MEMORY.ref(2, 0x20096b6).setu(r4);
          }
        }
      }
    }

    //LAB_2008276
    if(MEMORY.ref(2, 0x20096b4).get() == 0) {
      final int r4 = MEMORY.ref(2, 0x20096bc).get();
      if(r4 != 0) {
        if(heldButtonsLastFrame_3001ae8.get() == 0) {
          MEMORY.ref(2, 0x20096bc).setu(0);
        }
      } else {
        //LAB_2008298
        if(heldButtonsLastFrame_3001ae8.get() != 0) {
          if(heldButtonsLastFrame_3001ae8.get() == MEMORY.ref(2, 0x20094dc + MEMORY.ref(2, 0x20096b8).get() * 0x2).getUnsigned()) {
            MEMORY.ref(2, 0x20096b8).incr();
            MEMORY.ref(2, 0x20096bc).setu(1);
            if(MEMORY.ref(2, 0x20094dc + MEMORY.ref(2, 0x20096b8).get() * 0x2).getUnsigned() == 0) {
              MEMORY.ref(2, 0x20096b4).setu(1);
              playSound(0x6e);
            }
          } else {
            //LAB_20082ec
            MEMORY.ref(2, 0x20096b8).setu(r4);
          }
        }
      }
    }

    //LAB_20082ee
  }

  @Method(0x20082f4)
  public static void FUN_20082f4(final int r0, final int r1) {
    MEMORY.ref(1, r1 + 0x1).setu(0);
    MEMORY.ref(1, r1 + 0x2).setu(0);

    final int r3;
    if(r0 < 8) {
      r3 = r0 + 0x41;
    } else if(r0 < 0xd) {
      r3 = r0 + 0x42;
    } else if(r0 < 0x18) {
      r3 = r0 + 0x43;
    } else if(r0 < 0x20) {
      r3 = r0 + 0x1a;
    } else if(r0 < 0x2b) {
      r3 = r0 + 0x41;
    } else if(r0 < 0x2d) {
      r3 = r0 + 0x42;
    } else if(r0 < 0x38) {
      r3 = r0 + 0x43;
    } else if(r0 == 0x38) {
      r3 = 0x21;
    } else if(r0 == 0x39) {
      r3 = 0x3f;
    } else if(r0 == 0x3a) {
      r3 = 0x23;
    } else if(r0 == 0x3b) {
      r3 = 0x26;
    } else if(r0 == 0x3c) {
      r3 = 0x24;
    } else if(r0 == 0x3d) {
      r3 = 0x25;
    } else if(r0 == 0x3e) {
      r3 = 0x2b;
    } else {
      r3 = 0x3d;
    }

    //LAB_200837c
    MEMORY.ref(1, r1).setu(r3);
  }

  @Method(0x2008384)
  public static int FUN_2008384() {
    if(FUN_2009454(0x144) == 0 || MEMORY.ref(2, 0x200047e).get() == 2) {
      return 0;
    }

    final int r3 = MEMORY.ref(2, 0x2000400).get() ^ 0x2;
    return -((-r3 | r3) >>> 31);
  }

  /** I can not explain to you how wrong this code probably is */
  @Method(0x20083cc)
  public static void FUN_20083cc() {
    int r0;
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

    CPU.sp().value -= 0x224;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    FUN_2008054();
    setTickCallback(getRunnable(Decompressed87795e8.class, "FUN_20081fc"), 0xc80);
    boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._1c0.set(MEMORY.ref(4, CPU.sp().value + 0x14).get());
    FUN_20094ac();
    FUN_20094bc();

    if(entranceId_2000402.get() == 2) {
      //LAB_2008416
      do {
        FUN_2009394(0x7, 0x5);
        r7 = FUN_20094c4(0x1);
        FUN_20093c4();
        if(r7 != 0) {
          break;
        }
        FUN_2009394(0x8, 0x1);
        MEMORY.ref(1, 0x200044f).setu(0x1);
        r7 = FUN_20093ec();
      } while(r7 == -1);

      //LAB_2008450
      FUN_2009494(0x3c);
      FUN_20094b4();
      playSound(0x11);
      FUN_2009494(0x12c);
      setMapAndEntranceId(0x2, 0x48);
    } else {
      //LAB_20084a0
      MEMORY.ref(1, 0x3001ca0).setu(MEMORY.ref(1, CPU.sp().value + 0x14).getUnsigned());

      jmp_20084a8:
      while(true) {
        r6 = FUN_200940c();
        if(r6 < 0) {
          if(MEMORY.ref(1, 0x3001f54).getUnsigned() != 0) {
            MEMORY.ref(1, 0x200046a).setu(0x1);
            MEMORY.ref(1, 0x3001d08).setu(0x1);
            FUN_20093dc(0xa, 0x1, 0x8);
          }
        }

        //LAB_20084d2
        if(r6 == 0) {
          if(MEMORY.ref(4, CPU.sp().value + 0x14).get() == 0) {
            FUN_2009324(0x1e);
            setTickCallback(getRunnable(Decompressed87795e8.class, "FUN_2008154"), 0xc80);
            FUN_2009324(0x1);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(0x1);
          }
        }

        //LAB_20084f6
        if(r6 > 0) {
          r6 = handleTitleScreenChoiceMenu();
        } else {
          //LAB_2008502
          r6 = 0;
        }

        {
          //LAB_2008504
          if(r6 == 0) { // new game
            FUN_200944c();
            FUN_200941c(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
            r5 = 1;
            r7 = 0;

            //LAB_2008522
            do {
              do {
                FUN_2009324(0x6);
                if(FUN_2009414(r7) != -1) {
                  break;
                }
                if(r7 == 0) {
                  continue jmp_20084a8;
                }
                r7--;
              } while(true);

              //LAB_2008540
              if(MEMORY.ref(2, 0x20096b2).get() != 0) {
                r5 = 0x4;
              }

              //LAB_200854c
              if(MEMORY.ref(2, 0x20096b4).get() != 0) {
                r5 = 0x7;
              }

              //LAB_2008558
              r7++;
            } while(r7 < r5);

            FUN_200947c();
            mapId_2000400.set(0x8);
            entranceId_2000402.set(0x14);
            //LAB_200857a
          } else if(r6 == 1) { // continue
            //LAB_2008580
            if(loadLoadGameMenu(0x1) == -1) {
              continue jmp_20084a8;
            }

            setFlag(0x109);
            FUN_200941c(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());

            if(MEMORY.ref(4, 0x2000240).get() != calculateBuildDate()) {
              mapId_2000400.set(_2000404.get());
              entranceId_2000402.set(_2000406.get());
              clearFlag(0x109);
              //LAB_20085d8
            } else if((heldButtonsLastFrame_3001ae8.get() & 0x208) == 0x208) {
              if(FUN_2008384() != 0) {
                FUN_2009394(0x6, 0x9);
                continue jmp_20084a8;
              }

              //LAB_20085f2
              mapId_2000400.set(_2000404.get());
              entranceId_2000402.set(_2000406.get());
              clearFlag(0x109);
              setFlag(0x13e);
              //LAB_200861e
            } else if(MEMORY.ref(4, 0x2000244).get() != MEMORY.ref(4, 0x2001100).get()) {
              FUN_2009394(0x4, 0x9);
              FUN_2009394(0x5, 0xd);

              if(FUN_2009424(0x1, 0, 0, 0) != 0) {
                FUN_20093c4();
                continue jmp_20084a8;
              }

              //LAB_2008656
              FUN_20093c4();

              if(FUN_2008384() != 0) {
                FUN_2009394(0x6, 0x9);
                continue jmp_20084a8;
              }

              //LAB_200866c
              mapId_2000400.set(_2000404.get());
              entranceId_2000402.set(_2000406.get());
              clearFlag(0x109);
              setFlag(0x13f);
            }

            //LAB_2008696
            clearFlag(0x106);
          } else {
            //LAB_20086a0
            if(r6 == 2) {
              r0 = FUN_20093fc();
              continue jmp_20084a8;
            }

            //LAB_20086aa
            if(r6 == 3) {
              r0 = FUN_2009404();
              continue jmp_20084a8;
            }

            //LAB_2008714
            if(r6 == 4) {
              if(loadLoadGameMenu(0x4) == -1) {
                continue jmp_20084a8;
              }

              //LAB_200872a
              playerMapActorIndex_2000434.set(0);

              if(FUN_2009454(0x952) != 0) {
                FUN_200948c();
                removeChar(0);
                removeChar(1);
                removeChar(2);
                removeChar(3);
                FUN_200946c(0);
                FUN_200946c(1);
                FUN_200946c(2);
                FUN_200946c(3);
              }

              //LAB_2008774
              FUN_200941c(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
              clearFlag(0x109);
              clearFlag(0x106);
              setFlag(0x17e);
              MEMORY.ref(1, 0x3001ca0).setu(0x1);
              setMapAndEntranceId(0xbe, 0x1);
            } else {
              //LAB_20087b2
              if(r6 != 5) {
                continue jmp_20084a8;
              }

              jmp_20087b8:
              while(true) {
                if(loadLoadGameMenu(0x5) == -1) {
                  continue jmp_20084a8;
                }

                //LAB_20087ca
                FUN_200941c(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());

                //LAB_20087dc
                do {
                  do {
                    r6 = FUN_20093d4(0);
                    if(r6 == -1) {
                      continue jmp_20087b8;
                    }
                    if(r6 == 1) {
                      break;
                    }
                    //LAB_20089cc
                    if(r6 != 0) {
                      FUN_2009324(0x12c);
                      continue jmp_20084a8;
                    }

                    jmp_20089d2:
                    while(true) {
                      r6 = FUN_20093d4(0x1);
                      if(r6 != -1) {
                        //LAB_20089e4
                        r5 = CPU.sp().value + 0x15c;
                        r0 = FUN_2008de4(0, r6, r5);
                        CPU.r9().value = r0;
                        r0 = FUN_20092c8(r0, r5);
                        r3 = CPU.r9().value;
                        r0 = CPU.lslT(r0, 16);
                        r3 = CPU.addT(r3, 0x1);
                        r2 = CPU.asrT(r0, 16);
                        r1 = CPU.r9().value;
                        r0 = CPU.lsrT(r0, 24);
                        MEMORY.ref(1, r5 + r1).setu(r0);
                        MEMORY.ref(1, r5 + r3).setu(r2);
                        CPU.r9().value = FUN_20091e4(r5, CPU.r9().value + 0x2, CPU.sp().value + 0x1c);
                        loadUiTextures();
                        FUN_2009384(0x5, 0x4, 0x14, 0xc, 0x2);
                        CPU.r10().value = 0x5;
                        CPU.r11().value = 0;
                        CPU.r8().value = FUN_2009314(CPU.r9().value, 0x32) + 0x1;
                        FUN_2009384(0xa, 0, 0xa, 0x4, 0x2);
                        r5 = MEMORY.ref(4, 0x2008b24).get();
                        MEMORY.ref(4, CPU.sp().value + 0xc).setu(0xa);
                        FUN_20093ac(r5, MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x6, 0x4);
                        r7 = 0x1;
                        if(CPU.r8().value == 1) {
                          FUN_2009384(0x5, 0x10, 0x14, 0x3, 0x2);
                          MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x5);
                          FUN_20093b4(r5 - 0x2, MEMORY.ref(4, CPU.sp().value + 0x10).get(), 0x50, 0);
                        } else {
                          //LAB_2008a82
                          FUN_2009384(0x1, 0x10, 0x1c, 0x3, 0x2);
                          MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x1);
                          FUN_20093b4(r5 - 0x1, MEMORY.ref(4, CPU.sp().value + 0x10).get(), 0, 0);
                        }

                        //LAB_2008a9e
                        FUN_200942c(0x6006000);
                        FUN_200939c(CPU.r10().value);

                        //LAB_2008aaa
                        do {
                          FUN_2009434(0x6002500);
                          if((pressedButtons_3001c94.get() & 0x2) != 0) {
                            //LAB_20089a6
                            playSound(0x71);
                            FUN_200939c(CPU.r10().value);
                            FUN_200938c(CPU.r10().value, 0x2);
                            FUN_200938c(MEMORY.ref(4, CPU.sp().value + 0x10).get(), 0x2);
                            FUN_200938c(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x2);
                            continue jmp_20089d2;
                          }

                          //LAB_2008abe
                          if((pressedButtons_3001c94.get() & 0x1) != 0) {
                            CPU.r11().value += 0x1;
                            r7 = 0x1;
                            if(CPU.r11().value == CPU.r8().value) {
                              //LAB_2008474
                              playSound(0x70);
                              FUN_200939c(CPU.r10().value);
                              FUN_200938c(CPU.r10().value, 0x2);
                              FUN_200938c(MEMORY.ref(4, CPU.sp().value + 0x10).get(), 0x2);
                              FUN_200938c(MEMORY.ref(4, CPU.sp().value + 0xc).get(), 0x2);
                              FUN_2009324(0x1);
                              continue jmp_20084a8;
                            }

                            //LAB_2008ad2
                            playSound(0x6f);
                          } else {
                            //LAB_2008ada
                            if((pressedButtons_3001c94.get() & 0x20) != 0 && CPU.r8().value > 1) {
                              playSound(0x6f);
                              CPU.r11().value = FUN_200931c(CPU.r11().value + CPU.r8().value - 1, CPU.r8().value);
                              r7 = 0x1;
                            } else {
                              //LAB_2008b30
                              if((pressedButtons_3001c94.get() & 0x10) != 0) {
                                if(CPU.r8().value > 1) {
                                  playSound(0x6f);
                                  CPU.r11().value = FUN_200931c(CPU.r11().value + CPU.r8().value + 1, CPU.r8().value);
                                  r7 = 0x1;
                                }
                              }
                            }
                          }

                          //LAB_2008b58
                          if(r7 == 1) {
                            //LAB_2008b5e
                            FUN_200939c(CPU.r10().value);
                            r5 = 0x2;

                            //LAB_2008b68
                            for(r7 = 0; r7 < 4; r7++) {
                              FUN_20093a4(CPU.r10().value, 0, r5, 0x12, r5);
                              r5 += 0x2;
                            }

                            r3 = CPU.r8().value;
                            if(r3 > 1) {
                              r7 = 0;
                              if(r3 != 0) {
                                r5 = -r3 + 0x12;

                                //LAB_2008b92
                                do {
                                  if(r7 == CPU.r11().value) {
                                    r1 = r7 + 0xf30b;
                                  } else {
                                    r1 = r7 + 0xf301;
                                  }

                                  //LAB_2008b9e
                                  FUN_20093e4(CPU.r10().value, r1, r5, -1, 0);
                                  r5++;
                                  r7++;
                                } while(r7 != CPU.r8().value);
                              }

                              //LAB_2008bb4
                              FUN_20093e4(CPU.r10().value, 0xf128, 0x11 - CPU.r8().value, -1, 0);
                              FUN_20093e4(CPU.r10().value, 0xf129, 0x12, -1, 0);
                              r3 = MEMORY.ref(2, CPU.r10().value + 0xe).getUnsigned() >>> 2;
                              boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._ea3.or(0x2 << r3);
                            }

                            //LAB_2008bf2
                            r0 = CPU.r11().value * 50;
                            r6 = r0 + 50;
                            if(r6 > CPU.r9().value) {
                              r6 = CPU.r9().value;
                            }

                            //LAB_2008c02
                            r7 = r0;
                            r4 = 0;

                            //LAB_2008c0a
                            while(r7 != r6) {
                              FUN_20082f4(MEMORY.ref(1, CPU.sp().value + 0x1c + r7).getUnsigned() & 0x3f, CPU.sp().value + 0x18);
                              r0 = FUN_200931c(r7, 0xa);
                              r5 = FUN_200931c(r4, 0xa);
                              r3 = FUN_2009314(r4, 0xa) << 4;
                              if(r0 > 4) {
                                r2 = r5 * 0xc + 0x12;
                              } else {
                                //LAB_2008c4a
                                r2 = r5 * 0xc + 0x8;
                              }

                              //LAB_2008c6c
                              FUN_20093bc(CPU.sp().value + 0x18, CPU.r10().value, r2, r3 + 0x2);
                              r7++;
                              r4++;
                            }

                            //LAB_2008c80
                            r7 = 0;
                          }

                          //LAB_2008c82
                          FUN_2009324(0x1);
                        } while(true);

                        // unreachable break jmp_2008c96;
                      }

                      break;
                    }
                  } while(true);

                  //LAB_20087f2
                  r6 = FUN_2009384(0x6, 0x5, 0x12, 0x8, 0x2);
                  FUN_20093ac(0xc83, r6, 0, 0x4);
                  FUN_20093ac(0xc84, r6, 0, 0x10);
                  FUN_20093ac(0xc86, r6, 0, 0x24);
                  FUN_200936c();
                  FUN_2009324(0xa);

                  r2 = 0x2002224;
                  MEMORY.ref(2, r2).setu(0x30);
                  MEMORY.ref(2, r2 + 0x2).setu(0x30);
                  MEMORY.ref(2, r2 + 0x4).setu(0x30);
                  MEMORY.ref(2, r2 + 0x6).setu(0x30);

                  r3 = 0x2002024;
                  r7 = 0x0;
                  r1 = 0x0;

                  //LAB_200884c
                  do {
                    MEMORY.ref(2, r3).setu(0x30);
                    MEMORY.ref(2, r3 + 0x2).setu(0x30);
                    MEMORY.ref(2, r3 + 0x4).setu(0x30);
                    MEMORY.ref(2, r3 + 0x6).setu(0x30);
                    r3 += 0x18;
                    r1++;
                  } while(r1 != 0x4);

                  jmp_20088e0:
                  {
                    //LAB_200888c
                    while((pressedButtons_3001c94.get() & 0x2) == 0) {
                      if((_3001f64.get() & 0x3) == 0x3) {
                        r3 = MEMORY.ref(4, 0x4000128).get(); // SIOCNT
                        r3 = r3 << 26 >>> 30 ^ 0x1;
                        r2 = 0x2002024 + r3 * 0x18;
                        if(MEMORY.ref(2, r2).getUnsigned() == 0x55 && MEMORY.ref(2, r2 + 0x2).getUnsigned() == 0x56 && MEMORY.ref(2, r2 + 0x4).getUnsigned() == 0x54 && MEMORY.ref(2, r2 + 0x6).getUnsigned() == 0x53) {
                          r7 = 0x1;
                          break jmp_20088e0;
                        }
                      }

                      //LAB_20088c8
                      FUN_2009324(0x1);

                      //LAB_20088ce
                    }

                    playSound(0x71);
                  }

                  //LAB_20088e0
                  FUN_200938c(r6, 0x2);
                  if(r7 == 0) {
                    //LAB_20088ee
                    r6 = FUN_2009384(0x5, 0xa, 0x14, 0x4, 0x2);
                    FUN_20093ac(0xc85, r6, 0, 0x4);
                    FUN_2009324(0xa);
                    FUN_200937c(0x2000000, 0x1004);
                    FUN_2009324(0xa);
                    r5 = 0x0;
                    r4 = 0x1;
                    r7 = 0x0;
                    r5++;
                    if((_3001f64.get() & 0x3) == 0x3) {
                      r5 = 0;
                    }

                    //LAB_2008950
                    //LAB_2008956
                    //LAB_200892a
                    while(MEMORY.ref(4, 0x2002080).get() != 0) {
                      FUN_2009324(0x1);
                      r7++;

                      //LAB_200893a
                      if(r7 >= 600000) {
                        break;
                      }

                      r5++;
                      if((_3001f64.get() & 0x3) == 0x3) {
                        r5 = 0;
                      }

                      //LAB_2008950
                      if(r5 == 0xa) {
                        r4 = 0;
                        break;
                      }

                      //LAB_2008956
                    }

                    //LAB_200895e
                    if(r4 == 0) {
                      FUN_200939c(r6);
                      FUN_20093ac(0xc87, r6, 0, 0x4);

                      //LAB_2008978
                      do {
                        FUN_2009324(0x1);
                      } while((pressedButtons_3001c94.get() & 0x1) == 0);
                    }

                    //LAB_2008986
                    FUN_2009324(0xa);
                    FUN_2009374();
                    FUN_2009324(0xa);
                    FUN_200939c(r6);
                    FUN_200938c(r6, 0x2);
                    continue jmp_20084a8;
                  }
                } while(true);

                // unreachable break;
              }
            }
          }
        }

        break;
      }

      //LAB_2008c96
      boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new)._170.set(999);
      FUN_2009494(0x1e);
      playSound(0x11);
      FUN_20094b4();
      FUN_20094bc();
      FUN_2009494(0x3c);
    }

    //LAB_2008cbe
    CPU.sp().value += 0x224;

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x2008de4)
  public static int FUN_2008de4(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    int r9;
    int r10;
    final int r11;
    int r12;
    int lr;

    CPU.sp().value -= 0x40;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
    r11 = r2;
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(0xb);
    if(r1 == 0) {
      //LAB_2008e12
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(0xad);
    } else if(r1 == 1) {
      //LAB_2008e18
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x27);
    } else if(r1 == 2) {
      //LAB_2008e1e
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(0x9);
    }

    //LAB_2008e22
    //LAB_2008e30
    for(r9 = 0; r9 < MEMORY.ref(4, CPU.sp().value + 0x18).get(); r9++) {
      MEMORY.ref(1, r11 + r9).setu(0);
    }

    //LAB_2008e3e
    r0 = CPU.sp().value + 0x20;
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);

    //LAB_2008e54
    for(r9 = 0; r9 < 8; r9++) {
      MEMORY.ref(4, r0 + r9 * 0x4).setu(0);
    }

    //LAB_2008e68
    for(r9 = 0; r9 < 6; r9++) {
      if(FUN_2009454(MEMORY.ref(2, 0x20096d0 + r9 * 0x2).getUnsigned()) != 0) {
        MEMORY.ref(4, CPU.sp().value + 0x8).oru(0x1 << r9).and(0xff);
      }

      //LAB_2008e84
    }

    r7 = MEMORY.ref(4, CPU.sp().value + 0x4).get();

    //LAB_2008e94
    for(r9 = 0; r9 < 4; r9++) {
      r12 = FUN_200943c(MEMORY.ref(4, 0x20096c0 + r9 + 0x4).get());
      r1 = r12 + 0x10;
      if(MEMORY.ref(2, r1).get() > 1999) {
        MEMORY.ref(2, r1).setu(1999);
        r2 = 1999;
      } else {
        r2 = MEMORY.ref(2, r1).getUnsigned();
      }

      //LAB_2008eb6
      if((short)r2 < 0) {
        MEMORY.ref(2, r1).setu(0);
      }

      //LAB_2008ec0
      if(MEMORY.ref(2, r1 + 0x2).get() > 1999) {
        MEMORY.ref(2, r1 + 0x2).setu(1999);
        r2 = 1999;
      } else {
        r2 = MEMORY.ref(2, r1 + 0x2).getUnsigned();
      }

      //LAB_2008ece
      if((short)r2 < 0) {
        MEMORY.ref(2, r1 + 0x2).setu(0);
      }

      //LAB_2008ed8
      if(MEMORY.ref(2, r1 + 0x8).getUnsigned() > 999) {
        MEMORY.ref(2, r1 + 0x8).setu(999);
      }

      //LAB_2008ee2
      if(MEMORY.ref(2, r1 + 0xa).getUnsigned() > 999) {
        MEMORY.ref(2, r1 + 0xa).setu(999);
      }

      //LAB_2008eea
      if(MEMORY.ref(2, r1 + 0xc).getUnsigned() > 999) {
        MEMORY.ref(2, r1 + 0xc).setu(999);
      }

      //LAB_2008ef2
      if(MEMORY.ref(1, r1 + 0xe).getUnsigned() > 99) {
        MEMORY.ref(1, r1 + 0xe).setu(99);
      }

      //LAB_2008efc
      MEMORY.ref(4, r7).setu(MEMORY.ref(2, r1).get() << 21 | MEMORY.ref(2, r1 + 0x2).get() << 10 | MEMORY.ref(2, r1 + 0x8).getUnsigned());
      MEMORY.ref(4, r7 + 0x4).setu(MEMORY.ref(2, r1 + 0xa).getUnsigned() << 22 | MEMORY.ref(2, r1 + 0xc).getUnsigned() << 12 | MEMORY.ref(1, r1 + 0xe).getUnsigned() << 4);
      r2 = MEMORY.ref(1, r12 + 0xf).getUnsigned();
      if(r2 > 99) {
        MEMORY.ref(1, r12 + 0xf).setu(99);
        r2 = 99;
      }

      //LAB_2008f36
      if(r2 == 0) {
        MEMORY.ref(1, r12 + 0xf).setu(0x1);
      }

      //LAB_2008f42
      MEMORY.ref(4, CPU.sp().value + 0x14).oru(MEMORY.ref(1, r12 + 0xf).getUnsigned() << r9 * 7);

      //LAB_2008f5a
      for(r5 = 0; r5 < 4; r5++) {
        MEMORY.ref(4, CPU.sp().value + 0x10).and(MEMORY.ref(4, r12 + 0xf8 + r5 * 0x4).get() << r5 * 7);
      }

      //LAB_2008f7e
      for(r5 = 0; r5 < 15; r5++) {
        r1 = MEMORY.ref(2, r12 + 0xd8 + r5 * 0x2).getUnsigned() & 0x1ff;

        //LAB_2008f88
        for(r4 = 0; r4 != 8; r4++) {
          if(r1 == MEMORY.ref(2, 0x20096dc + r4 * 0x2).getUnsigned()) {
            MEMORY.ref(4, CPU.sp().value + 0xc).oru(0x1 << r4).and(0xff);
          }
        }
      }

      r7 += 0x8;
    }

    //LAB_2008fba
    if(MEMORY.ref(4, CPU.sp().value + 0x1c).get() == 0) {
      //LAB_2008fc2
      r6 = 0;
      r10 = 0x27;

      //LAB_2008fca
      for(r9 = 0; r9 != 4; r9++) {
        r4 = FUN_200943c(MEMORY.ref(4, 0x20096c0 + r9 * 0x4).get());
        r5 = r10 + r11;

        //LAB_2008fe2
        for(r7 = 0; r7 < 15; r7++) {
          getItem(MEMORY.ref(2, r4 + 0xd8 + r7 * 0x2).getUnsigned());
          r1 = MEMORY.ref(2, r4 + 0xd8 + r7 * 0x2).getUnsigned() & 0x1ff;
          r6++;
          MEMORY.ref(1, r5).addu(r1 >> r6);
          MEMORY.ref(1, r5 + 0x1).addu(r1 << (7 - r6));
          r5++;
          r10++;
          if(r6 == 7) {
            r6 = 0;
            r5++;
            r10++;
          }

          //LAB_2009040
        }
      }

      r10 = 0x6b;
      r6 = -1;

      //LAB_2009060
      for(r9 = 0; r9 < 4; r9++) {
        r8 = FUN_200943c(MEMORY.ref(4, 0x20096c0 + r9 * 0x4).get());
        r0 = r10 + r11;

        //LAB_200907a
        for(lr = 0; lr < 0x17; lr++) {
          r4 = MEMORY.ref(2, 0x20096ec + lr * 0x2).getUnsigned();
          r5 = 0;
          r7 = 0;
          r1 = r8 + 0xd8;

          //LAB_2009086
          do {
            r2 = MEMORY.ref(2, r1).getUnsigned();
            if((r2 & 0x1ff) == r4) {
              r5 = r2 & 0xf800 >>> 11;
            }

            //LAB_200909a
            r1 = r1 + 0x2;
            r7++;
          } while(r7 != 0xf);

          r1 = r5 & 0xffff;
          if(r6 < 0) {
            MEMORY.ref(1, r0).addu(r1 >> -r6);
            r10++;
            r6 += 0x8;
            r0++;
          }

          //LAB_20090c0
          MEMORY.ref(1, r0).addu(r1 << r6);
          r6 -= 5;
          if(r6 == -5) {
            r0++;
            r10++;
            r6 = 0x3;
          }

          //LAB_20090da
        }
      }

      MEMORY.ref(1, r11 + 0xa5).setu(MEMORY.ref(2, 0x2000252).getUnsigned());
      MEMORY.ref(1, r11 + 0xa6).setu(MEMORY.ref(4, 0x2000250).get() >>> 8);
      MEMORY.ref(1, r11 + 0xa7).setu(MEMORY.ref(4, 0x2000250).get());
    }

    //LAB_2009108
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    if(r3 != 2) {
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = ((-r3 | r4) >>> 31) + 0x8;
      r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r0 = r11 + r3;
      r9 = 0;

      //LAB_2009122
      do {
        r2 = MEMORY.ref(4, r4).get();
        MEMORY.ref(1, r0).setu(r2 >>> 24);
        MEMORY.ref(1, r0 + 0x1).setu(r2 >>> 16);
        MEMORY.ref(1, r0 + 0x2).setu(r2 >>> 8);
        MEMORY.ref(1, r0 + 0x3).setu(r2);
        r1 = MEMORY.ref(4, r4 + 0x4).get();
        MEMORY.ref(1, r0 + 0x4).setu(r1 >>> 24);
        MEMORY.ref(1, r0 + 0x5).setu(r1 >>> 16);
        MEMORY.ref(1, r0 + 0x6).setu(r1 >>> 8);
        MEMORY.ref(1, r0 + 0x7).setu(r1);
        r2 = MEMORY.ref(4, r4 + 0x8).get();
        MEMORY.ref(1, r0 + 0x8).setu(r2 >>> 20);
        MEMORY.ref(1, r0 + 0x9).setu(r2 >>> 12);
        MEMORY.ref(1, r0 + 0xa).setu(r2 >>> 4);
        MEMORY.ref(1, r0 + 0xb).setu(r2 << 4);
        MEMORY.ref(1, r0 + 0x7).setu(r1 | r2 >>> 28);
        r1 = MEMORY.ref(4, r4 + 0xc).get();
        MEMORY.ref(1, r0 + 0xb).setu(r2 << 4 | MEMORY.ref(4, r4 + 0xc).get() >>> 28);
        MEMORY.ref(1, r0 + 0xc).setu(r1 >>> 20);
        r9++;
        MEMORY.ref(1, r0 + 0xd).setu(r1 >>> 12);
        MEMORY.ref(1, r0 + 0xe).setu(r1 >>> 4);
        r4 += 0x10;
        r0 += 0xf;
      } while(r9 != 2);
    }

    //LAB_200917c
    MEMORY.ref(1, r11).setu(MEMORY.ref(1, CPU.sp().value + 0x14).getUnsigned());
    r6 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    MEMORY.ref(1, r11 + 0x1).setu(r6 >>> 8);
    MEMORY.ref(1, r11 + 0x2).setu(r6 >>> 16);
    MEMORY.ref(1, r11 + 0x3).setu(r6 >>> 20 & 0xf0 | MEMORY.ref(4, CPU.sp().value + 0x10).get() & 0xf);
    r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
    MEMORY.ref(1, r11 + 0x4).setu(r1 >>> 4);
    MEMORY.ref(1, r11 + 0x5).setu(r1 >>> 12);
    MEMORY.ref(1, r11 + 0x6).setu(r1 >>> 20);
    MEMORY.ref(1, r11 + 0x7).setu(MEMORY.ref(1, CPU.sp().value + 0x8).getUnsigned());

    if(MEMORY.ref(4, CPU.sp().value + 0x1c).get() != 0) {
      MEMORY.ref(1, r11 + 0x8).setu(MEMORY.ref(1, CPU.sp().value + 0xc).getUnsigned());
    }

    //LAB_20091c0
    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    CPU.sp().value += 0x40;

    return r0;
  }

  @Method(0x20091e4)
  public static int FUN_20091e4(int r0, final int r1, int r2) {
    final int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    final int r9;
    int r10;
    int r12;
    int lr;
    final int sp04;

    r9 = r0;
    sp04 = r2;
    r3 = r9 + r1 - 1;
    r5 = MEMORY.ref(1, r3).getUnsigned();
    r10 = 0;

    //LAB_2009214
    for(int i = 0; i < r1 - 1; i++) {
      MEMORY.ref(1, r9 + i).xoru(r5);
    }

    //LAB_2009224
    r0 = sp04;
    r5 = 0;
    r7 = 0;
    r12 = 0;
    lr = 0;

    //LAB_2009236
    do {
      r6 = 0;
      r4 = r9 + r7;

      //LAB_2009240
      for(int i = 0; i < 6 && r7 < r1; i++) {
        r2 = MEMORY.ref(1, r4).getUnsigned() >> 7 - r5 & 0x1;
        r5++;
        if(r5 == 8) {
          r5 = 0;
          r4++;
          r7++;
        }

        //LAB_2009260
        r2 = r2 << (5 - i);
        r6 = r6 | r2;
      }

      //LAB_200926c
      MEMORY.ref(1, r0).setu(r6);
      lr++;
      r10++;
      r0++;
      r12 += r6;
      if(lr == 9) {
        MEMORY.ref(1, r0).setu(r12 & 0x3f);
        r0++;
        r10++;
        r12 = 0;
        lr = 0;
      }

      //LAB_2009292
    } while(r7 != r1);

    //LAB_20092a2
    for(int i = 0; i < r10; i++) {
      MEMORY.ref(1, sp04 + i).addu(i).and(0x3f);
    }

    //LAB_20092b2
    return r10;
  }

  @Method(0x20092c8)
  public static int FUN_20092c8(int r0, int r1) {
    int r2;
    final int r4;
    int r5;

    r4 = r0;
    r5 = 0;
    r0 = 0xffff;

    //LAB_20092da
    while(r5 != r4) {
      r0 = r0 ^ (MEMORY.ref(1, r1).getUnsigned() << 8);
      r2 = 0;

      //LAB_20092e2
      do {
        if((r0 & 0x8000) != 0) {
          r0 = (r0 << 1) + 0xffffefdf;
        } else {
          //LAB_20092f0
          r0 <<= 1;
        }

        //LAB_20092f2
        r2++;
      } while(r2 != 8);

      r5++;
      r1++;
    }

    //LAB_2009300
    return ~r0 & 0xffff;
  }

  @Method(0x2009314)
  public static int FUN_2009314(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  @Method(0x200931c)
  public static int FUN_200931c(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003ac, r0, r1);
  }

  @Method(0x2009324)
  public static void FUN_2009324(final int r0) {
    MEMORY.call(0x80000c0, r0);
  }

  /** {@link GoldenSun#setTickCallback_} */
  @Method(0x200932c)
  public static void setTickCallback(@Nullable final RunnableRef r0, final int r1) {
    MEMORY.call(0x80000d0, r0, r1);
  }

  /** {@link GoldenSun#clearTickCallback_} */
  @Method(0x2009334)
  public static int clearTickCallback(final RunnableRef r0) {
    return (int)MEMORY.call(0x80000d8, r0);
  }

  /** {@link GoldenSun#decompress_} */
  @Method(0x200934c)
  public static int decompress(final int src, final int dest) {
    return (int)MEMORY.call(0x80001a8, src, dest);
  }

  @Method(0x2009354)
  public static void loadUiTextures() {
    MEMORY.call(0x80001f0);
  }

  /** {@link GoldenSun#getPointerTableEntry_} */
  @Method(0x200935c)
  public static int getPointerTableEntry(final int index) {
    return (int)MEMORY.call(0x8000290, index);
  }

  @Method(0x2009364)
  public static void FUN_2009364(final int r0) {
    MEMORY.call(0x8003b70, r0);
  }

  @Method(0x200936c)
  public static void FUN_200936c() {
    MEMORY.call(0x8000300);
  }

  @Method(0x2009374)
  public static void FUN_2009374() {
    MEMORY.call(0x8000370);
  }

  @Method(0x200937c)
  public static int FUN_200937c(final int r0, final int r1) {
    return (int)MEMORY.call(0x8000380, r0, r1);
  }

  @Method(0x2009384)
  public static int FUN_2009384(final int r0, final int r1, final int r2, final int r3, final int a4) {
    return (int)MEMORY.call(0x8015010, r0, r1, r2, r3, a4);
  }

  /** {@link GoldenSun_801#FUN_8015018} TODO busted? r0 is a Panel */
  @Method(0x200938c)
  public static void FUN_200938c(final int r0, final int r1) {
    MEMORY.call(0x8015018, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015040}  */
  @Method(0x2009394)
  public static void FUN_2009394(final int r0, final int r1) {
    MEMORY.call(0x8015040, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015060} TODO busted? r0 is a Panel */
  @Method(0x200939c)
  public static void FUN_200939c(final int r0) {
    MEMORY.call(0x8015060, r0);
  }

  @Method(0x20093a4)
  public static void FUN_20093a4(final int r0, final int r1, final int r2, final int r3, final int a4) {
    MEMORY.call(0x8015070, r0, r1, r2, r3, a4);
  }

  @Method(0x20093ac)
  public static void FUN_20093ac(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015078, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#drawIcon} */
  @Method(0x20093b4)
  public static void FUN_20093b4(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015080, r0, r1, r2, r3);
  }

  @Method(0x20093bc)
  public static void FUN_20093bc(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8015088, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#FUN_8015140} */
  @Method(0x20093c4)
  public static void FUN_20093c4() {
    MEMORY.call(0x8015140);
  }

  /** {@link GoldenSun_801#handleTitleScreenChoiceMenu_} */
  @Method(0x20093cc)
  public static int handleTitleScreenChoiceMenu() {
    return (int)MEMORY.call(0x80151f0);
  }

  @Method(0x20093d4)
  public static int FUN_20093d4(final int r0) {
    return (int)MEMORY.call(0x80151f8, r0);
  }

  @Method(0x20093dc)
  public static void FUN_20093dc(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8015210, r0, r1, r2);
  }

  @Method(0x20093e4)
  public static void FUN_20093e4(final int r0, final int r1, final int r2, final int r3, final int r4) {
    MEMORY.call(0x8015280, r0, r1, r2, r3, r4);
  }

  @Method(0x20093ec)
  public static int FUN_20093ec() {
    return (int)MEMORY.call(0x80152e8);
  }

  /** {@link GoldenSun_801#loadLoadGameMenu_} */
  @Method(0x20093f4)
  public static int loadLoadGameMenu(final int r0) {
    return (int)MEMORY.call(0x80152f0, r0);
  }

  /** {@link GoldenSun_801#FUN_80152f8} */
  @Method(0x20093fc)
  public static int FUN_20093fc() {
    return (int)MEMORY.call(0x80152f8);
  }

  @Method(0x2009404)
  public static int FUN_2009404() {
    return (int)MEMORY.call(0x8015300);
  }

  @Method(0x200940c)
  public static int FUN_200940c() {
    return (int)MEMORY.call(0x8015318);
  }

  @Method(0x2009414)
  public static int FUN_2009414(final int r0) {
    return (int)MEMORY.call(0x8015320, r0);
  }

  /** {@link GoldenSun_801#FUN_8015360} */
  @Method(0x200941c)
  public static void FUN_200941c(final int r0, final int r1) {
    MEMORY.call(0x8015360, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8015390} */
  @Method(0x2009424)
  public static int FUN_2009424(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x8015390, r0, r1, r2, r3);
  }

  @Method(0x200942c)
  public static void FUN_200942c(final int r0) {
    MEMORY.call(0x80153d8, r0);
  }

  @Method(0x2009434)
  public static void FUN_2009434(final int r0) {
    MEMORY.call(0x8015418, r0);
  }

  @Method(0x200943c)
  public static int FUN_200943c(final int r0) {
    return (int)MEMORY.call(0x8077008, r0);
  }

  /** {@link GoldenSun_807#getItem_} */
  @Method(0x2009444)
  public static Item2c getItem(final int itemId) {
    return (Item2c)MEMORY.call(0x8077018, itemId);
  }

  @Method(0x200944c)
  public static void FUN_200944c() {
    MEMORY.call(0x8077098);
  }

  /** {@link GoldenSun_807#readFlag_} */
  @Method(0x2009454)
  public static int FUN_2009454(final int r0) {
    return (int)MEMORY.call(0x80770c0, r0);
  }

  /** {@link GoldenSun_807#setFlag_} */
  @Method(0x200945c)
  public static void setFlag(final int r0) {
    MEMORY.call(0x80770c8, r0);
  }

  /** {@link GoldenSun_807#clearFlag_} */
  @Method(0x2009464)
  public static void clearFlag(final int r0) {
    MEMORY.call(0x80770d0, r0);
  }

  @Method(0x200946c)
  public static int FUN_200946c(final int r0) {
    return (int)MEMORY.call(0x8077150, r0);
  }

  /** {@link GoldenSun_807#removeChar_} */
  @Method(0x2009474)
  public static int removeChar(final int charId) {
    return (int)MEMORY.call(0x8077168, charId);
  }

  /** Called after confirming character names */
  @Method(0x200947c)
  public static void FUN_200947c() {
    MEMORY.call(0x8077270);
  }

  /** {@link GoldenSun_807#calculateBuildDate_} */
  @Method(0x2009484)
  public static int calculateBuildDate() {
    return (int)MEMORY.call(0x8077300);
  }

  @Method(0x200948c)
  public static void FUN_200948c() {
    MEMORY.call(0x8077318);
  }

  @Method(0x2009494)
  public static void FUN_2009494(final int r0) {
    MEMORY.call(0x808a010, r0);
  }

  @Method(0x200949c)
  public static Actor70 FUN_200949c(final int r0) {
    return (Actor70)MEMORY.call(0x808a080, r0);
  }

  /** {@link GoldenSun_808#setMapAndEntranceId_} */
  @Method(0x20094a4)
  public static void setMapAndEntranceId(final int mapId, final int entranceId) {
    MEMORY.call(0x808a238, mapId, entranceId);
  }

  @Method(0x20094ac)
  public static void FUN_20094ac() {
    MEMORY.call(0x808a360);
  }

  /** Called after confirming character names */
  @Method(0x20094b4)
  public static void FUN_20094b4() {
    MEMORY.call(0x808a368);
  }

  @Method(0x20094bc)
  public static void FUN_20094bc() {
    MEMORY.call(0x808a370);
  }

  @Method(0x20094c4)
  public static int FUN_20094c4(final int r0) {
    return (int)MEMORY.call(0x808a4d8, r0);
  }

  /** {@link GoldenSun_80f#playSound_} */
  @Method(0x20094cc)
  public static void playSound(final int r0) {
    MEMORY.call(0x80f9010, r0);
  }
}
