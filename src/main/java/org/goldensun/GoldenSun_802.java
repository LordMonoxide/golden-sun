package org.goldensun;

import org.goldensun.memory.Method;
import org.goldensun.types.GraphicsStruct;
import org.goldensun.types.GraphicsStruct24;

import static org.goldensun.GoldenSun.setMallocSlot;
import static org.goldensun.GoldenSun.FUN_80030f8;
import static org.goldensun.GoldenSun.FUN_8003fa4;
import static org.goldensun.GoldenSun.FUN_8004080;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.loadUiTextures;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars._3001b04;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSun_801.FUN_80162d4;
import static org.goldensun.GoldenSun_801.FUN_8016418;
import static org.goldensun.GoldenSun_801.FUN_8016478;
import static org.goldensun.GoldenSun_801.FUN_8018850;
import static org.goldensun.GoldenSun_801.FUN_8019d2c;
import static org.goldensun.GoldenSun_801.FUN_8019da8;
import static org.goldensun.GoldenSun_801.FUN_8019e48;
import static org.goldensun.GoldenSun_801.FUN_801e41c;
import static org.goldensun.GoldenSun_801.FUN_801e858;
import static org.goldensun.GoldenSun_801.FUN_801eadc;
import static org.goldensun.GoldenSun_807.FUN_8077008;
import static org.goldensun.GoldenSun_80b.FUN_80b0020;
import static org.goldensun.GoldenSun_80b.FUN_80b0028;
import static org.goldensun.GoldenSun_80b.FUN_80b0030;
import static org.goldensun.GoldenSun_80b.FUN_80b0038;
import static org.goldensun.GoldenSun_80f.FUN_80f9010;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.MEMORY;

public final class GoldenSun_802 {
  private GoldenSun_802() { }

  /** Maybe decompressing a graphic and uploading to VRAM */
  @Method(0x80209d0)
  public static void FUN_80209d0(final GraphicsStruct24 r0_0, final int r1) {
    final int r10 = mallocBoard(0x300);
    decompress(r1, r10);
    int r3 = r0_0._0c.get() + r0_0._0e.get() * 0x20;
    final int r4 = r0_0._0a.get(); // maybe height
    int r7 = r10;
    int r0 = 0x6002000 + r3 * 0x2;
    int r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).get() + r3 * 0x2;
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
    setMallocSlot(r10);
  }

  @Method(0x8020a60)
  public static void FUN_8020a60(final GraphicsStruct24 r0, int r1, int r2, final int r3, final int a4, final int a5) {
    final int r12 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
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
      int r4 = r12 + r1;

      //LAB_8020aba
      for(int i = 0; i < r6; i++) {
        MEMORY.ref(2, r4).and(~0x1000).oru(a5 << 12);
        r4 += 0x2;
      }

      //LAB_8020aca
      r1 += 0x40;
    }

    MEMORY.ref(1, r12 + 0xea3).setu(0x1);

    //LAB_8020ada
  }

  @Method(0x8020b14)
  public static int FUN_8020b14(final int r0) {
    final int r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    CPU.sp().value -= 0x8;
    int r1 = 0;

    //LAB_8020b2a
    while(MEMORY.ref(1, r0 + r1).getUnsigned() != 0) {
      MEMORY.ref(2, r4 + 0xeb0 + r1 * 0x2).setu(MEMORY.ref(1, r0 + r1).getUnsigned());
      r1++;
    }

    //LAB_8020b3a
    MEMORY.ref(2, r4 + 0xeb0 + r1 * 0x2).setu(0);
    FUN_8018850(0, CPU.sp().value + 0x4, CPU.sp().value, null);
    final int ret = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.sp().value += 0x8;
    return ret;
  }

  @Method(0x8020b64)
  public static void FUN_8020b64(final GraphicsStruct24 r0, int r1) {
    CPU.sp().value -= 0x14;
    int r2 = MEMORY.ref(1, r1).getUnsigned();
    int r4 = 0;

    //LAB_8020b78
    while(r2 != 0) {
      MEMORY.ref(1, CPU.sp().value + r4).setu(r2);
      r1++;
      r2 = MEMORY.ref(1, r1).getUnsigned();
      r4++;
    }

    //LAB_8020b8e
    MEMORY.ref(1, CPU.sp().value + r4).setu(0x8);
    r4++;
    MEMORY.ref(1, CPU.sp().value + r4).setu(0x2);
    r4++;
    if(r4 < 7) {
      r2 = r4 + CPU.sp().value;
      r4 = 7 - r4;

      //LAB_8020ba6
      while(r4 != 0) {
        MEMORY.ref(1, r2).setu(0x5f);
        r2++;
        r4--;
      }

      r4 = 7;
    }

    //LAB_8020bb2
    MEMORY.ref(1, CPU.sp().value + r4).setu(0x8);
    r4++;
    MEMORY.ref(1, CPU.sp().value + r4).setu(0xf);
    r4++;
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
    final int sp10 = boardWramMallocHead_3001e50.offset(15 * 0x4).get();
    int sp0c = 0x1;
    r9 = 0x1;
    loadUiTextures();
    final GraphicsStruct24 r8 = FUN_80162d4(0x3, 0x6, 0x18, 0x9, 0x2);
    final GraphicsStruct24 sp28 = FUN_80162d4(0x8, 0x3, 0x8, 0x3, 0x2);
    FUN_8019da8(FUN_8019d2c(sp2c), 0, 3, 1);
    FUN_80209d0(r8, 0x8073864);
    FUN_801e41c(r8, 0x12, 0, 0x12, 0x7);
    MEMORY.ref(1, sp10 + 0xea3).setu(sp0c);
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
    r5 = FUN_8004080();
    if(r5 < 0x60) {
      FUN_8003fa4(r5, 0x80, 0x80310a4); //TODO
      final GraphicsStruct struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
      MEMORY.ref(4, CPU.sp().value + 0x40).setu(struct.getAddress()); //TODO
      FUN_80b0038(CPU.sp().value + 0x40, 0x8c + r8._0c.get() * 0x8, 0x34 + r8._0e.get() * 0x8);
    }

    //LAB_8020ce2
    //LAB_8020ce6
    r5 = FUN_8004080();
    if(r5 < 0x60) {
      FUN_8003fa4(r5, 0x80, 0x80317e4); //TODO
      final GraphicsStruct struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
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
        FUN_80030f8(0x1);
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

        if((_3001b04.get() & 0x40) != 0) {
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
        if((_3001b04.get() & 0x80) != 0) {
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
        if((_3001b04.get() & 0x20) != 0) {
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
        if((_3001b04.get() & 0x10) != 0) {
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
          r5 = _3001b04.get() & 0x2;
          if(r5 == 0) {
            //LAB_8020fa6
            if((_3001b04.get() & 0x1) == 0) {
              continue;
            }

            //LAB_8020fb2
            FUN_80f9010(0x70);

            if(r6 != 0x12) {
              //LAB_8020fe6
              r3 = (r8._0e.get() + r7 + 1) * 0x20 + r8._0c.get() + r6 + 1;
              r3 = MEMORY.ref(1, sp10 + r3 * 0x2).getUnsigned();
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
                FUN_80030f8(0xa);
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
    FUN_80030f8(0x1);
    CPU.sp().value += 0x60;

    return sp24;
  }
}
