package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.PointerTableType296;
import org.goldensun.types.SoundStructFb0;
import org.goldensun.types.Struct0c;

import javax.annotation.Nullable;

import static org.goldensun.Bios.SvcHalt;
import static org.goldensun.CopiedSegment8000770.intHandlers_30000e0;
import static org.goldensun.CopiedSegment8000770.memzero;
import static org.goldensun.GoldenSunVars._2002090;
import static org.goldensun.GoldenSunVars._3001800;
import static org.goldensun.GoldenSunVars._3001804;
import static org.goldensun.GoldenSunVars._3001a10;
import static org.goldensun.GoldenSunVars._3001a20;
import static org.goldensun.GoldenSunVars._3001ac0;
import static org.goldensun.GoldenSunVars._3001ac4;
import static org.goldensun.GoldenSunVars._3001aec;
import static org.goldensun.GoldenSunVars._3001af0;
import static org.goldensun.GoldenSunVars._3001b00;
import static org.goldensun.GoldenSunVars._3001b04;
import static org.goldensun.GoldenSunVars._3001c98;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001ca0;
import static org.goldensun.GoldenSunVars._3001ca4;
import static org.goldensun.GoldenSunVars._3001ca8;
import static org.goldensun.GoldenSunVars._3001cb0;
import static org.goldensun.GoldenSunVars._3001cb8;
import static org.goldensun.GoldenSunVars._3001cbc;
import static org.goldensun.GoldenSunVars._3001cc8;
import static org.goldensun.GoldenSunVars._3001ccc;
import static org.goldensun.GoldenSunVars._3001cd0;
import static org.goldensun.GoldenSunVars._3001cd4;
import static org.goldensun.GoldenSunVars._3001cfc;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars._3001d18;
import static org.goldensun.GoldenSunVars._3001d20;
import static org.goldensun.GoldenSunVars._3001d28;
import static org.goldensun.GoldenSunVars._3001d34;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001e44;
import static org.goldensun.GoldenSunVars._3001f20;
import static org.goldensun.GoldenSunVars._3001f54;
import static org.goldensun.GoldenSunVars._3001f58;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars._3007800;
import static org.goldensun.GoldenSunVars._3007804;
import static org.goldensun.GoldenSunVars._3007810;
import static org.goldensun.GoldenSunVars._3007ff0;
import static org.goldensun.GoldenSunVars._3007ffc;
import static org.goldensun.GoldenSunVars._8013784;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.blendConfig_3001cf8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.chipWramMallocHead_3001e54;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.heldButtons_3001d0c;
import static org.goldensun.GoldenSunVars.heldLAndRTicks_3001f5c;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.ptrTable_8320000;
import static org.goldensun.GoldenSun_801.FUN_8010000;
import static org.goldensun.GoldenSun_801.FUN_8010230;
import static org.goldensun.GoldenSun_801.FUN_80118d8;
import static org.goldensun.GoldenSun_801.FUN_8011a84;
import static org.goldensun.GoldenSun_801.FUN_8011f54;
import static org.goldensun.GoldenSun_807.FUN_80770c0;
import static org.goldensun.GoldenSun_807.FUN_80770d0;
import static org.goldensun.GoldenSun_808.FUN_808a008;
import static org.goldensun.GoldenSun_80f.FUN_80f9008;
import static org.goldensun.GoldenSun_80f.FUN_80f9018;
import static org.goldensun.GoldenSun_818.FUN_8185000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GATE;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INPUT;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun {
  private GoldenSun() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(GoldenSun.class);

  @Method(0x80000c0)
  public static void FUN_80000c0(final int r0) {
    MEMORY.call(0x80030f8, r0);
  }

  @Method(0x80000d0)
  public static void FUN_80000d0(final int r0, final int r1) {
    MEMORY.call(0x80041d8, r0, r1);
  }

  @Method(0x80001a8)
  public static int FUN_80001a8(final int r0, final int r1) {
    return (int)MEMORY.call(0x8005340, r0, r1);
  }

  @Method(0x8000290)
  public static int FUN_8000290(final int r0) {
    return (int)MEMORY.call(0x8002f40, r0);
  }

  @Method(0x8000298)
  public static void FUN_8000298(final int r0) {
    MEMORY.call(0x8002f3d, r0);
  }

  @Method(0x80002a8)
  public static void FUN_80002a8(final int r0) {
    MEMORY.call(0x8003b71, r0);
  }

  @Method(0x80002d0)
  public static void FUN_80002d0() {
    MEMORY.call(0x8003ce1);
  }

  @Method(0x80003c0)
  public static void main() {
    CPU.cpsr().msr(0x12, true, false, false, true);
    CPU.sp().value = 0x3007fa0;
    CPU.cpsr().msr(0x1f, true, false, false, true);
    CPU.sp().value = 0x3007f00;

    _3007ffc.set(0x8000770);
    FUN_8002e00();
  }

  @Method(0x80006fc)
  public static void FUN_80006fc() {
    if(_3007ff0.deref()._00.get() == 0x68736d53) {
      FUN_800070c(_3007ff0.deref());
    }
  }

  @Method(0x800070a)
  public static void FUN_800070a(final int r0, final int r1unused, final int r2unused, final int r3) {
    MEMORY.call(r3, r0);
  }

  @Method(0x800070c)
  public static void FUN_800070c(final SoundStructFb0 r0) {
    final int r3;
    final int r4;
    int r5;
    final int r7;
    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x18;

    if(!r0._20.isNull()) {
      r0._20.deref().run(r0._24.deref());
    }

    //LAB_8000728
    r0._28.deref().run(r0);

    r3 = r0._10.get();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r5 = r0._350.getAddress(); //TODO
    r4 = r0._04.get();
    r7 = CPU.subT(r4, 0x1);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r5 = r5 + r3 * (r0._0b.get() - r7);
    }

    //LAB_8000748
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
    CPU.r9().value = r0._14.get();
    CPU.r12().value = r0._18.get();
    MEMORY.call(0x3000658, r0._06.get(), 0, 0, 0, r0._50);
  }

  @Method(0x80022ec)
  public static int FUN_80022ec(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  @Method(0x80022f4)
  public static int FUN_80022f4(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003f0, r0, r1);
  }

  @Method(0x80022fc)
  public static int FUN_80022fc(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003ac, r0, r1);
  }

  @Method(0x8002304)
  public static int FUN_8002304(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e1, r0, r1);
  }

  @Method(0x800231c)
  public static int FUN_800231c(int r0) {
    int r1;
    r1 = CPU.movT(0, 0x40);
    r1 = CPU.lslT(r1, 8);
    r0 = CPU.addT(r0, r1);
    return FUN_8002322(r0); // falls through to this method
  }

  @Method(0x8002322)
  public static int FUN_8002322(int r0) {
    int r1;
    int r2;
    int r3;

    r0 = CPU.addT(r0, 0x20);
    r1 = CPU.lslT(r0, 18);
    r1 = CPU.lsrT(r1, 24);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.lsrT(r0, 14);
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.andT(r0, r2);
      r0 = CPU.lslT(r0, 16);
      r2 = CPU.lsrT(r2, 2);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = CPU.negT(r0, r0);
      }

      //LAB_800231a
      return r0;
    }
    r2 = CPU.lsrT(r0, 15);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.subT(r3, r1);
    }

    //LAB_8002334
    r1 = CPU.lslT(r1, 1);
    r3 = 0x8002344;
    r0 = MEMORY.ref(2, r3 + r1).getUnsigned();
    r2 = CPU.lsrT(r2, 1);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r0 = CPU.negT(r0, r0);
    }

    //LAB_8002342
    return r0;
  }

  @Method(0x8002dd8)
  public static void FUN_8002dd8(final int r0) {
    final int r1 = boardWramMallocHead_3001e50.offset(r0 * 0x4).get();
    final int r3 = CPU.lsrT(r1, 22);
    if(!CPU.cpsr().getZero()) { // !=
      boardWramMallocHead_3001e50.offset(r0 * 0x4).setu(0);
      boardWramMallocHead_3001e50.offset(r3 & 0x4).setu(r1);
    }

    //LAB_8002dec
  }

  @Method(0x8002df0)
  public static void FUN_8002df0(final int r0) {
    boardWramMallocHead_3001e50.offset(r0 >>> 22 & 0x4).setu(r0);
  }

  @Method(0x8002e00)
  public static void FUN_8002e00() {
    final int r0;

    DMA.channels[0].CNT.offset(2, 0x2).and(~0b11_1010_0000_0000); // Disable repeat, DRQ, set timing to immediate
    DMA.channels[0].CNT.offset(2, 0x2).and(~0b1000_0000_0000_0000); // Disable

    INTERRUPTS.WAITCNT.setu(0x4014);

    // Zero on-chip WRAM
    CPU.sp().value -= 0x4;
    r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(0x3000000);
    DMA.channels[3].CNT.setu(0x85001e00);

    initMemoryAllocator();
    FUN_800300c();
    _2002090.set(0);
    _3001ac4.setu(0);
    _3001f54.set(0);
    _3001f58.set(0);
    FUN_8002f10();
    loadUiTextures();
    FUN_8004760();
    GPU.DISPCNT.setu(0x140);
    setInterruptHandler(0, 1, getRunnable(GoldenSun.class, "vblankInterruptHandler"));
    INPUT.KEY_CNT.setu(0xc00f);
    FUN_80f9008();
    FUN_800403c();
    FUN_80040e8();
    _3007800.set(0);
    _3001d18.set(1);
    _3001ca0.set(0);
    FUN_80030f8(10);
    FUN_808a008(0);
    CPU.sp().value += 0x4;
  }

  @Method(0x8002f10)
  public static void FUN_8002f10() {
    final int addr = getPointerTableEntry(2); // 0x8320fa0
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(_3007804.getAddress());
    DMA.channels[3].CNT.setu(0x84000003); // 3 32-bit words

    _3007810.set(0);
  }

  @Method(0x8002f3c)
  public static void FUN_8002f3c(final int r0) {
    // no-op
  }

  @Method(0x8002f40)
  public static int getPointerTableEntry(final int index) {
    return ptrTable_8320000.get(index).get();
  }

  @Method(0x8002fb0)
  public static void FUN_8002fb0(final int pointerTableEntry, final int dst) {
    final int decompressedSize = decompress(getPointerTableEntry(pointerTableEntry), dst);

    final int size = 0x7c;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8002d5c);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3002000 -> MEMORY.addFunctions(CopiedSegment8002d5c.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    MEMORY.call(addr, dst, decompressedSize); // Update function pointers in decompressed THUMB code
    FUN_8002df0(addr);
  }

  @Method(0x8003008)
  public static void defaultInterruptHandler() {
    // no-op
  }

  @Method(0x800300c)
  public static void FUN_800300c() {
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);

    DMA.channels[3].SAD.setu(0x8000770);
    DMA.channels[3].DAD.setu(0x3000000);
    DMA.channels[3].CNT.setu(0x84000500); // enabled, 32-bit, 0x500 words

    _3007ffc.set(0x3000000);

    // Interrupt handler vector
    DMA.channels[3].SAD.setu(0x8007320);
    DMA.channels[3].DAD.setu(intHandlers_30000e0.getAddress());
    DMA.channels[3].CNT.setu(0x8400000e); // enabled, 32-bit, 0xe words

    MEMORY.addFunctions(CopiedSegment8000770.class);

    GPU.DISPSTAT.setu(0);
    INPUT.KEY_CNT.setu(0xc3ff);
    INTERRUPTS.INT_ENABLE.setu(0x1001);
    INTERRUPTS.INT_MASTER_ENABLE.setu(1);
  }

  @Method(0x800307c)
  public static void setInterruptHandler(final int interruptType, final int vcountSetting, @Nullable final RunnableRef callback) {
    if(interruptType <= 13) {
      final int oldMasterEnable = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
      INTERRUPTS.INT_MASTER_ENABLE.setu(0x208); // why?

      final int interruptMask = 0x1 << interruptType;
      int newIntEnable = INTERRUPTS.INT_ENABLE.getUnsigned() & ~interruptMask;
      if(callback != null) {
        newIntEnable = newIntEnable | interruptMask;
      }

      //LAB_800309e
      INTERRUPTS.INT_ENABLE.setu(newIntEnable);

      if(interruptType <= 2) { // GPU interrupt
        int dispStatMaskOn = 0x8 << interruptType;
        int dispStatMaskOff = ~dispStatMaskOn;
        if(interruptType == 2) {
          dispStatMaskOn = vcountSetting << 8 | dispStatMaskOn;
          dispStatMaskOff = dispStatMaskOff & 0xff;
        }

        //LAB_80030b6
        int newDispStat = GPU.DISPSTAT.getUnsigned() & dispStatMaskOff;
        if(callback != null) {
          newDispStat = newDispStat | dispStatMaskOn;
        }

        //LAB_80030c2
        GPU.DISPSTAT.setu(newDispStat);
      }

      //LAB_80030c4
      if(callback != null) {
        intHandlers_30000e0.get(interruptType).set(callback);
      } else {
        //LAB_80030d0
        intHandlers_30000e0.get(interruptType).set(getRunnable(GoldenSun.class, "defaultInterruptHandler"));
      }

      //LAB_80030d8
      INTERRUPTS.INT_MASTER_ENABLE.setu(oldMasterEnable);
    }

    //LAB_80030dc
  }

  @Method(0x80030f8)
  public static void FUN_80030f8(final int r0) {
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x8;
    CPU.r10().value = CPU.sp().value;
    CPU.cmpT(CPU.r10().value, 0x30079ff);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      final int r2 = 0x3007a00 - CPU.r10().value;
      _3001804.set(r2);
      DMA.channels[3].SAD.setu(CPU.r10().value);
      DMA.channels[3].DAD.setu(0x20023b0);
      DMA.channels[3].CNT.setu(0x84000000 | r2 / 4);
      CPU.sp().value = 0x3007a00;
    }

    //LAB_8003130
    //LAB_800313c
    CPU.r11().value = 1;
    CPU.r9().value = 0x3001d24;

    //LAB_8003144
    for(MEMORY.ref(4, CPU.sp().value).setu(0); MEMORY.ref(4, CPU.sp().value).get() < r0; MEMORY.ref(4, CPU.sp().value).incr()) {
      _3001a10.setu(CPU.r11().value);
      FUN_8004420(0xc80);
      _3001a10.setu(0);
      FUN_8003e10(FUN_80048b0(0x34, 0x400));
      _3001e44.set(CPU.r11().value);

      if(_3001f58.get() != 0) {
        int r1 = GPU.VCOUNT.getUnsigned();
        if(r1 >= 159) {
          r1 -= 160;
        } else {
          //LAB_800317e
          r1 += 68;
        }

        //LAB_8003180
        r1 += _3001ccc.get() - 1 << 8;

        if(_3001af0.get() == 0) {
          _3001ca4.set(0);
        } else {
          //LAB_8003198
          _3001af0.decr();
        }

        //LAB_800319c
        if((_3001ca4.get() & 0xffff_ffffL) < (r1 & 0xffff_ffffL)) {
          _3001ca4.set(r1);
          _3001af0.set(30);
        }
      }

      //LAB_80031ac
      if(_3001ca0.get() == 0) {
        if(_3001d08.get() != 0) {
          if(heldButtonsLastFrame_3001ae8.get() != 0) {
            MEMORY.ref(2, CPU.r9().value).setu(_3001ca0.get());
          } else {
            //LAB_80031cc
            MEMORY.ref(2, CPU.r9().value).incr();

            if(MEMORY.ref(2, CPU.r9().value).getUnsigned() > 10800) {
              _3001cc8.set(CPU.r11().value);
            }
          }
        }

        //LAB_80031e4
        // Hold L+R
        if(heldButtonsLastFrame_3001ae8.get() == 0x300) {
          heldLAndRTicks_3001f5c.incr();

          if(heldLAndRTicks_3001f5c.get() >= 180) {
            heldLAndRTicks_3001f5c.set(0);
            _3001cc8.set(CPU.r11().value);
          }
        } else {
          //LAB_800320a
          heldLAndRTicks_3001f5c.set(0);
        }
      }

      //LAB_8003210
      jmp_800330a:
      if(_3001f54.get() != 0) {
        //LAB_800321a
        CPU.r8().value = 0x8000000;

        //LAB_80032e4
        //LAB_8003288
        while(_3001d20.get() == 0) {
          // Start+select held
          if(heldButtonsLastFrame_3001ae8.get() != 0xc) {
            break jmp_800330a;
          }
          _3001d20.set(CPU.r11().value);

          //LAB_8003292
          _3001d28.and(0xfffe);

          //LAB_800329e
          do {
            CPU.pc().value = 0x80032a0;
            SvcHalt();
          } while((_3001d28.get() & 0x1) == 0);

          FUN_8003538();

          if(_3001cb8.get() != 0) {
            _3001cb8.set(0);
            _3007800.set(0x19670704);
            INTERRUPTS.INT_MASTER_ENABLE.setu(0);
            //r0 = FUN_8007304(r0, r1, r2, r3, r4, r5, r6, r7);
            throw new RuntimeException("?");
          }

          //LAB_80032e2
        }

        if((_3001b04.get() & 0x7) != 0) {
          break jmp_800330a;
        }

        if((heldButtonsLastFrame_3001ae8.get() & 0xf0) != 0) { // Direction buttons
          break jmp_800330a;
        }

        if((_3001b04.get() & 0x8) == 0) {
          throw new RuntimeException("How do we do this jump?");
          //LAB_8003292;
        }

        _3001d20.set(0);
      }

      //LAB_800330a
      _3001cd0.setu(_3001ccc.get());
      _3001ccc.set(0);
      _3001d28.and(0xfffe);

      //LAB_8003322
      do {
        CPU.pc().value = 0x8003324;
        SvcHalt();
      } while((_3001d28.get() & 0x1) == 0);

      FUN_8002dd8(0x34);
      FUN_8003d04();
      _3001e40.incr();
      _3001c9c.incr();
      FUN_8003538();

      if(_3001cb0.get() != 0) {
        FUN_8005fcc();

        if(MEMORY.ref(1, 0x2002240).getUnsigned() != 0) {
          MEMORY.ref(1, 0x2002248).setu(1);
        }
      }

      //LAB_8003386
      if(_3001cc8.get() != 0) {
        //LAB_8003390
        if(_3001ca0.get() == 0) {
          //LAB_800339c
          final int oldDispCnt = GPU.DISPCNT.getUnsigned();
          final int oldPalette = MEMORY.ref(2, 0x5000000).get();

          if(_3001cc8.get() == 1) {
            GPU.DISPCNT.setu(_3001ca0.get());
            MEMORY.ref(2, 0x5000000).setu(0x7fff);

            //LAB_80033c6
            for(int i = 0; i < 60; i++) {
              _3001d28.and(0xfffe);

              //LAB_80033ce
              do {
                CPU.pc().value = 0x80033d0;
                SvcHalt();
              } while((_3001d28.get() & 0x1) == 0);
            }

            MEMORY.ref(2, 0x2002000).setu(1);
            INPUT.KEY_CNT.setu(0xc300);
            SoundBias0();
            CPU.pc().value = 0x80033f4;
            CPU.SWI(InstructionSet.THUMB); // 0x2 stop/sleep
            SoundBias200();
            INPUT.KEY_CNT.setu(0xc00f);
            MEMORY.ref(2, 0x2002000).setu(0);
            GPU.DISPCNT.setu(oldDispCnt);
            MEMORY.ref(2, 0x5000000).setu(oldPalette);

            //LAB_8003454
            for(int i = 0; i < 10; i++) {
              _3001d28.and(0xfffe);

              //LAB_800345c
              do {
                CPU.pc().value = 0x800345e;
                SvcHalt();
              } while((_3001d28.get() & 0x1) == 0);
            }

            _3001cc8.set(0);
            MEMORY.ref(2, CPU.r9().value).setu(0);
          } else {
            //LAB_800348c
            _3001cc8.decr();
          }
        }
      }

      //LAB_8003492
      if(_3001cb8.get() != 0) {
        _3001cb8.set(0);
        _3007800.set(0x19670704);
        INTERRUPTS.INT_MASTER_ENABLE.setu(0);
        MEMORY.call(0x8000000);
      }

      //LAB_80034b2
    }

    //LAB_80034c0
    if(_3001804.get() != 0) {
      CPU.r10().value = CPU.sp().value - _3001804.get();
      CPU.sp().value = CPU.r10().value;
      DMA.channels[3].SAD.setu(0x20023b0);
      DMA.channels[3].DAD.setu(CPU.r10().value);
      DMA.channels[3].CNT.setu(0x84000000 | _3001804.get() / 4);

      //LAB_80034f0
      while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
        DebugHelper.sleep(1);
      }

      _3001804.set(0);
    }

    //LAB_80034fc
    CPU.sp().value += 0x8;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8003538)
  public static void FUN_8003538() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;

    r4 = MEMORY.ref(4, 0x800362c).get();
    r0 = MEMORY.ref(4, r4).get();
    r5 = CPU.movT(0, 0x0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r2 = MEMORY.ref(4, 0x8003630).get();
      r3 = MEMORY.ref(4, 0x8003634).get();
      r2 = MEMORY.ref(4, r2).get();
      MEMORY.ref(4, r3).setu(r2);
      r1 = MEMORY.ref(4, r3).get();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = CPU.movT(0, 0x6);
        MEMORY.ref(4, r4).setu(r3);
      } else {
        //LAB_8003558
        r3 = CPU.movT(0, 0x13);
        MEMORY.ref(4, r4).setu(r3);
      }
    } else {
      //LAB_800355e
      r3 = MEMORY.ref(4, 0x8003634).get();
      MEMORY.ref(4, r3).setu(r5);
      r1 = MEMORY.ref(4, r3).get();
    }

    //LAB_8003564
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x40);
      r3 = CPU.andT(r3, r1);
      r2 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.movT(0, 0x1);
      }

      //LAB_8003574
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.andT(r3, r1);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.addT(r2, 0x1);
      }

      //LAB_800357e
      r3 = CPU.movT(0, 0x20);
      r3 = CPU.andT(r3, r1);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.addT(r2, 0x1);
      }

      //LAB_8003588
      r3 = CPU.movT(0, 0x10);
      r3 = CPU.andT(r3, r1);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.addT(r2, 0x1);
      }

      //LAB_8003592
      r0 = MEMORY.ref(4, 0x8003638).get();
      MEMORY.ref(4, r0).setu(r1);
      CPU.cmpT(r2, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_80035b8
        r2 = MEMORY.ref(4, 0x800363c).get();
        r3 = CPU.movT(0, 0xf0);
        r1 = CPU.andT(r1, r3);
        MEMORY.ref(4, r2).setu(r1);
      } else {
        CPU.cmpT(r2, 0x1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_80035b0
          r2 = MEMORY.ref(4, 0x800363c).get();
          r3 = CPU.movT(0, 0x30);
          MEMORY.ref(4, r2).setu(r3);
        } else {
          CPU.cmpT(r2, 0x2);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_80035c2
            r1 = MEMORY.ref(4, 0x800363c).get();
            r3 = MEMORY.ref(4, r1).get();
            r2 = MEMORY.ref(4, r0).get();
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.movT(0, 0x30);
              MEMORY.ref(4, r1).setu(r3);
            }

            //LAB_80035d2
            r3 = MEMORY.ref(4, r1).get();
            r2 = MEMORY.ref(4, 0x8003644).get();
            r3 = CPU.eorT(r3, r2);
            r2 = MEMORY.ref(4, r0).get();
            r2 = CPU.andT(r2, r3);
            MEMORY.ref(4, r0).setu(r2);
          } else {
            CPU.cmpT(r2, 0x3);
            if(!CPU.cpsr().getZero()) { // !=
              r2 = MEMORY.ref(4, 0x800363c).get();
              r3 = CPU.movT(0, 0x30);
              MEMORY.ref(4, r2).setu(r3);
              r2 = MEMORY.ref(4, 0x8003640).get();
            } else {
              //LAB_80035e0
              r4 = MEMORY.ref(4, 0x800363c).get();
              r3 = MEMORY.ref(4, r4).get();
              r2 = CPU.movT(0, 0x30);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = CPU.movT(0, 0x30);
              }

              //LAB_80035ee
              r3 = MEMORY.ref(4, r4).get();
              r2 = CPU.movT(0, 0xc0);
              r3 = CPU.andT(r3, r2);
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = CPU.movT(0, 0xc0);
              }

              //LAB_80035fa
              r2 = MEMORY.ref(4, 0x8003644).get();
              r2 = CPU.eorT(r2, r5);
              r1 = CPU.andT(r1, r2);
              MEMORY.ref(4, r4).setu(r1);
            }

            //LAB_8003602
            r3 = MEMORY.ref(4, r0).get();
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(4, r0).setu(r3);
          }
        }
      }
    } else {
      //LAB_800360a
      r3 = MEMORY.ref(4, 0x8003638).get();
      MEMORY.ref(4, r3).setu(r1);
    }

    //LAB_800360e
    r1 = MEMORY.ref(4, 0x8003630).get();
    r0 = MEMORY.ref(4, 0x8003648).get();
    r3 = MEMORY.ref(4, r1).get();
    r2 = MEMORY.ref(4, r0).get();
    r3 = CPU.eorT(r3, r2);
    r2 = MEMORY.ref(4, r1).get();
    r4 = MEMORY.ref(4, 0x800364c).get();
    r3 = CPU.andT(r3, r2);
    MEMORY.ref(4, r4).setu(r3);
    r3 = MEMORY.ref(4, r1).get();
    MEMORY.ref(4, r0).setu(r3);
  }

  @Method(0x8003650)
  public static void vblankInterruptHandler() {
    DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);

    if(_3001cb0.get() != 0) {
      _3001f64.setu(FUN_8006088(0x2002220, 0x2002020));
      FUN_800655c();
    }

    //LAB_800367e
    FUN_80f9018();
    FUN_8003adc();

    if(_3001e44.get() != 0) {
      if(_3001d18.get() != 0) {
        DMA.channels[3].SAD.setu(_3001f20.get());
        DMA.channels[3].DAD.setu(0x7000000); // OAM
        DMA.channels[3].CNT.setu(0x84000100);
      }

      //LAB_80036a8
      DMA.channels[3].SAD.setu(0x3001ad0);
      DMA.channels[3].DAD.setu(GPU.BG0HOFS.getAddress());
      DMA.channels[3].CNT.setu(0x84000004);
      FUN_8003a7c();
      _3001e44.set(0);
    }

    //LAB_80036bc
    if(_3001cfc.get() != 0) {
      _3001cfc.set(0);
      //FUN_80072ec(r0, r1, r2);
      throw new RuntimeException("What should r0 be here?");
    }

    //LAB_80036cc
    FUN_8004420(0x480);

    final int pressedButtons = 0x3ff ^ INPUT.KEY_INPUT.getUnsigned();
    final int pressedThisFrame = pressedButtons & ~heldButtonsLastFrame_3001ae8.get();
    pressedButtons_3001c94.set(pressedThisFrame);
    accumulatedButtons_3001af8.or(pressedThisFrame);
    heldButtonsLastFrame_3001ae8.set(pressedButtons);

    if(pressedButtons == 0) {
      _3001b00.set(19);
      _3001b04.set(0);
      //LAB_8003768
    } else if((pressedButtons & (heldButtons_3001d0c.get() ^ 0xffff)) != 0) {
      _3001b00.set(-1);
      _3001b04.set(pressedButtons);
      //LAB_8003786
    } else if(_3001b00.get() > 0) {
      _3001b00.decr();
    }

    //LAB_8003792
    heldButtons_3001d0c.set(pressedButtons);
    _3001800.incr();
    _3001ccc.incr();
    _3001d28.set(1);
    FUN_80006fc();
  }

  @Method(0x80037d4)
  public static int FUN_80037d4(int r0) {
    final int r1;
    int r2;
    final int r3;

    CPU.cmpT(r0, 0x4);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80037dc
    r3 = CPU.movT(0, 0x98);
    r2 = CPU.addT(r0, 0x0);
    r2 = CPU.mulT(r2, r3);
    r0 = MEMORY.ref(4, 0x80037f8).get();
    r0 = CPU.addT(r2, r0);
    r1 = MEMORY.ref(4, 0x8003800).get();
    r2 = MEMORY.ref(4, 0x8003804).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x8003a7c)
  public static void FUN_8003a7c() {
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);
    final int r7 = CPU.sp().value;
    final int r5 = MEMORY.ref(2, 0x2002090).getUnsigned();
    if(r5 != 0) {
      final int size = 0x68;
      CPU.r10().value = 0;
      CPU.r8().value = CPU.sp().value;
      CPU.sp().value -= size;
      // So we're just gonna copy an entire function to the stack and pretend that's normal?
      DMA.channels[3].SAD.setu(0x8002cf4);
      DMA.channels[3].DAD.setu(CPU.sp().value);
      DMA.channels[3].CNT.setu(0x84000000 | size / 4);

      MEMORY.setFunction(CPU.sp().value, StackFunction8002cf4.class, "FUN_8002cf4", int.class, int.class);
      callStackFunction(0x2002090, r5);

      MEMORY.ref(2, 0x2002090).setu(CPU.r10().value);
      CPU.sp().value = CPU.r8().value;
    }

    //LAB_8003abc
    CPU.sp().value = r7;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8003adc)
  public static void FUN_8003adc() {
    if(_3001c98.get() != 0) {
      final int blendMode;
      if(_3001cd4.get() != 0) {
        blendMode = 0x80; // additive
      } else {
        //LAB_8003b08
        blendMode = 0xc0; // subtractive
      }

      //LAB_8003b0e
      GPU.BLDCNT.setu(blendConfig_3001cf8.get() | blendMode);
      _3001ac0.decr();
      GPU.BLDY.setu(_3001ca8.get() + FUN_80022ec(_3001ac0.get() * (_3001aec.get() - _3001ca8.get()), _3001c98.get()));

      if(_3001ac0.get() == 0) {
        _3001c98.set(0);
      }
    }

    //LAB_8003b68
  }

  @Method(0x8003b70)
  public static void FUN_8003b70(final int r0) {
    _3001cd4.set(0);
    blendConfig_3001cf8.set(0x3e); // bg1/2/3/obj/bd 1st target pixel
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0x10);
    _3001c98.set(r0);
    _3001ac0.set(r0);
  }

  @Method(0x8003bb4)
  public static void FUN_8003bb4(final int r0) {
    _3001cd4.set(0);
    blendConfig_3001cf8.set(0x3e); // bg1/2/3/obj/bd 1st target pixel
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0);
    _3001c98.set(r0);
    _3001ac0.set(r0);
  }

  @Method(0x8003c3c)
  public static void FUN_8003c3c(final int r0) {
    final int r1;
    int r2;
    int r3;
    r2 = MEMORY.ref(4, 0x8003c64).get();
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8003c68).get();
    r3 = MEMORY.ref(4, 0x8003c60).get();
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8003c6c).get();
    r1 = MEMORY.ref(4, 0x8003c70).get();
    r3 = MEMORY.ref(1, r2).getUnsigned();
    MEMORY.ref(1, r1).setu(r3);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8003c74).get();
    MEMORY.ref(1, r3).setu(r0);
    r2 = MEMORY.ref(4, 0x8003c78).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    MEMORY.ref(1, r2).setu(r3);
  }

  @Method(0x8003ce0)
  public static void FUN_8003ce0() {
    int r0;
    final int r2;
    int r3;
    final int r5;

    r2 = MEMORY.ref(4, 0x8003d00).get();
    r3 = MEMORY.ref(1, r2).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // ==
      r5 = CPU.addT(r2, 0x0);

      //LAB_8003cec
      do {
        r0 = CPU.movT(0, 0x1);
        FUN_80030f8(r0);
        r3 = MEMORY.ref(1, r5).getUnsigned();
        CPU.cmpT(r3, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8003cf8
  }

  @Method(0x8003d04)
  public static void FUN_8003d04() {
    MEMORY.ref(1, 0x3001d00).setu(0);
    memzero(0x3001400, 0x400);
  }

  @Method(0x8003d28)
  public static int FUN_8003d28(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8003dec)
  public static void FUN_8003dec(final int r0, int r1) {
    int r2;
    int r3;
    CPU.cmpT(r1, 0xff);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r1 = CPU.movT(0, 0xff);
    }

    //LAB_8003df4
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r1 = CPU.movT(0, 0x0);
    }

    //LAB_8003dfa
    r2 = MEMORY.ref(4, 0x8003e0c).get();
    r3 = CPU.lslT(r1, 2);
    r3 = CPU.addT(r3, r2);
    r2 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, r3).setu(r0);
    MEMORY.ref(4, r0).setu(r2);
  }

  @Method(0x8003e10)
  public static void FUN_8003e10(final int r0) {
    final int size = 0xe0;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8001dc8);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x8400_0000 | size / 4); // 0x38 words, 32-bit, enable

    MEMORY.setFunction(addr, CopiedSegment8001dc8.class, "FUN_3002400", int.class);
    MEMORY.call(addr, r0);

    FUN_8002df0(addr);
  }

  @Method(0x8003e58)
  public static int FUN_8003e58(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    final int r5;
    final int r6;
    final int r7;

    r6 = CPU.addT(r0, 0x0);
    r5 = CPU.lsrT(r1, 6);
    CPU.cmpT(r6, 0x5f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
      return r0;
    }

    //LAB_8003e68
    r1 = MEMORY.ref(4, 0x8003ecc).get();
    r2 = MEMORY.ref(4, 0x8003ed0).get();
    CPU.r12().value = r1;
    r4 = CPU.movT(0, 0x0);
    CPU.lr().value = r2;
    r7 = CPU.r12().value;

    //LAB_8003e74
    do {
      r3 = CPU.movT(0, 0x80);
      r0 = CPU.movT(0, 0x1);
      r3 = CPU.lslT(r3, 2);
      r0 = CPU.negT(r0, r0);
      r4 = CPU.cmpT(r4, r3);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        return r0;
      }
      r3 = MEMORY.ref(1, r7 + r4).getUnsigned();
      CPU.cmpT(r3, 0xff);

      jmp_8003eb2:
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.addT(r4, 0x0);
        r1 = CPU.addT(r5, r0);
        r0 = CPU.cmpT(r0, r1);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          r2 = CPU.addT(r0, r7);

          //LAB_8003e90
          do {
            r3 = MEMORY.ref(1, r2).getUnsigned();
            r2 = CPU.addT(r2, 0x1);
            CPU.cmpT(r3, 0xff);
            if(!CPU.cpsr().getZero()) { // !=
              break jmp_8003eb2;
            }
            r4 = CPU.addT(r4, 0x1);
            r4 = CPU.cmpT(r4, r1);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }

        //LAB_8003e9e
        r2 = CPU.movT(0, 0x0);
        r2 = CPU.cmpT(r2, r5);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          //LAB_8003ea4
          do {
            r3 = CPU.addT(r0, r2);
            r1 = CPU.r12().value;
            r2 = CPU.addT(r2, 0x1);
            MEMORY.ref(1, r1 + r3).setu(r6);
            r2 = CPU.cmpT(r2, r5);
          } while(!CPU.cpsr().getCarry()); // unsigned <
        }
        break;
      }

      //LAB_8003eb2
      r2 = CPU.r12().value;
      r3 = MEMORY.ref(1, r2 + r4).getUnsigned();
      r1 = CPU.lr().value;
      r3 = CPU.lslT(r3, 2);
      r3 = MEMORY.ref(2, r1 + r3).getUnsigned();
      r3 = CPU.lsrT(r3, 6);
      r4 = CPU.addT(r4, r3);
    } while(true);

    //LAB_8003ec2
    r0 = CPU.lslT(r0, 6);

    //LAB_8003ec4
    return r0;
  }

  @Method(0x8003f04)
  public static int FUN_8003f04(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r4 = CPU.movT(0, 0x0);
    CPU.cmpT(r0, 0x5f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
      return r0;
    }
    r1 = CPU.movT(0, 0x80);
    r2 = MEMORY.ref(4, 0x8003f38).get();
    r5 = CPU.movT(0, 0xff);
    r1 = CPU.lslT(r1, 2);

    //LAB_8003f14
    do {
      r3 = MEMORY.ref(1, r2).getUnsigned();
      r3 = CPU.cmpT(r3, r0);
      if(CPU.cpsr().getZero()) { // ==
        MEMORY.ref(1, r2).setu(r5);
        r4 = CPU.addT(r4, 0x1);
      }

      //LAB_8003f1e
      r1 = CPU.subT(r1, 0x1);
      r2 = CPU.addT(r2, 0x1);
      CPU.cmpT(r1, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8003f2a
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
      return r0;
    }

    //LAB_8003f30
    r0 = CPU.movT(0, 0x0);

    //LAB_8003f32
    return r0;
  }

  @Method(0x8003f3c)
  public static int FUN_8003f3c(int r0) {
    int r2;
    int r3;
    final int r5;
    final int r6;

    r3 = MEMORY.ref(4, 0x8003f70).get();
    r2 = CPU.lslT(r0, 2);
    r5 = CPU.addT(r2, r3);
    CPU.cmpT(r0, 0x5f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
      return r0;
    }

    //LAB_8003f4e
    r3 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
    r6 = MEMORY.ref(4, 0x8003f74).get();
    r3 = CPU.cmpT(r3, r6);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = FUN_8003f04(r0);
      r3 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
      r2 = CPU.addT(r6, 0x0);
      r2 = CPU.orrT(r2, r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r5 + 0x2).setu(r2);
      MEMORY.ref(2, r5).setu(r3);
    }

    //LAB_8003f66
    r0 = CPU.movT(0, 0x0);

    //LAB_8003f68
    return r0;
  }

  @Method(0x8003f78)
  public static int FUN_8003f78(int r0) {
    final int r2;
    int r3;
    final int r5;

    r3 = MEMORY.ref(4, 0x8003fa0).get();
    r2 = CPU.lslT(r0, 2);
    r5 = CPU.addT(r2, r3);
    CPU.cmpT(r0, 0x5f);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
    } else {
      //LAB_8003f8a
      r3 = MEMORY.ref(2, r5).getUnsigned();
      CPU.cmpT(r3, 0x10);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = FUN_8003f04(r0);
        r3 = CPU.movT(0, 0x1);
        MEMORY.ref(2, r5).setu(r3);
      }

      //LAB_8003f98
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8003f9a
    return r0;
  }

  @Method(0x8003fa4)
  public static int FUN_8003fa4(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);
    r5 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(4, 0x800402c).get();
    CPU.r8().value = r2;
    r2 = CPU.lslT(r5, 2);
    r6 = CPU.addT(r1, 0x0);
    r7 = CPU.addT(r2, r3);
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r5, 0x5f);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 6);
      r6 = CPU.cmpT(r6, r2);
      if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
        r3 = MEMORY.ref(2, r7).getUnsigned();
        CPU.cmpT(r3, 0x10);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.addT(r6, 0x0);
          r0 = FUN_8003e58(r0, r1);
          r5 = CPU.addT(r0, 0x0);
        } else {
          r3 = CPU.cmpT(r3, r6);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_8003fd6
            r5 = MEMORY.ref(2, r7 + 0x2).getUnsigned();
          } else {
            r0 = CPU.addT(r5, 0x0);
            r0 = FUN_8003f3c(r0);
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.addT(r6, 0x0);
            r0 = FUN_8003e58(r0, r1);
            r5 = CPU.addT(r0, 0x0);
          }
        }

        //LAB_8003fe4
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.negT(r3, r3);
        r5 = CPU.cmpT(r5, r3);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = MEMORY.ref(4, 0x8004030).get();
          r1 = CPU.addT(r5, r2);
          r2 = CPU.r8().value;
          MEMORY.ref(2, r7).setu(r6);
          MEMORY.ref(2, r7 + 0x2).setu(r5);
          CPU.cmpT(r2, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            CPU.cmpT(CPU.r8().value, r3);
            if(CPU.cpsr().getZero()) { // ==
              r0 = CPU.addT(r1, 0x0);
              r3 = MEMORY.ref(4, 0x8004034).get();
              r1 = CPU.addT(r6, 0x0);
              MEMORY.call(r3, r0, r1);
            } else {
              //LAB_800400a
              r4 = CPU.movT(0, 0x84);
              r2 = CPU.lsrT(r6, 2);
              r4 = CPU.lslT(r4, 24);
              r0 = CPU.r8().value;
              r2 = CPU.orrT(r2, r4);
              DMA.channels[3].SAD.setu(r0);
              DMA.channels[3].DAD.setu(r1);
              DMA.channels[3].CNT.setu(r2);
            }
          }

          //LAB_800401a
          r0 = CPU.lsrT(r5, 5);
        } else {
          //LAB_800401e
          r0 = CPU.movT(0, 0x0);
        }
      }
    }

    //LAB_8004020
    r3 = CPU.pop();

    CPU.r8().value = r3;
    return r0;
  }

  @Method(0x800403c)
  public static void FUN_800403c() {
    //LAB_8004046
    MEMORY.memfill(0x3001810, 0x200, 0xff);

    //LAB_800406c
    for(int i = 0; i < 0x60; i++) {
      final int r2 = 0x3001b10 + i * 0x4;
      MEMORY.ref(2, r2).setu(0);
      MEMORY.ref(2, r2 + 0x2).oru(0xffff);
    }
  }

  @Method(0x8004080)
  public static int FUN_8004080() {
    int r1 = 0x3001b10;
    int r2 = 0;

    //LAB_8004094
    while(MEMORY.ref(2, r1 + 0x2).getUnsigned() != 0xffff) {
      r2++;
      r1 += 0x4;
      if(r2 > 0x5f) {
        return 0x60;
      }
    }

    //LAB_80040a6
    return r2;
  }

  @Method(0x80040e8)
  public static void FUN_80040e8() {
    _3001d34.set(0);
    _3001a10.setu(0);

    //LAB_80040fc
    for(int i = 0; i < 20; i++) {
      final int r1 = _3001a20.offset(i * 0x8).getAddress();
      MEMORY.ref(4, r1).setu(0);
      MEMORY.ref(2, r1 + 0x4).oru(0xffff);
      MEMORY.ref(1, r1 + 0x6).setu(0);
    }

    _3001d34.set(1);

    //LAB_8004128
  }

  @Method(0x8004144)
  public static void FUN_8004144() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;

    CPU.sp().value -= 0x8;
    r4 = CPU.movT(0, 0x13);

    //LAB_800414e
    do {
      r2 = MEMORY.ref(4, 0x8004194).get();

      //LAB_8004150
      r1 = CPU.addT(r2, 0x0);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = CPU.addT(r4, 0x0);

        //LAB_8004158
        do {
          r3 = CPU.movT(0, 0xc);
          r2 = MEMORY.ref(2, r1 + r3).get();
          r5 = CPU.movT(0, 0x4);
          r3 = MEMORY.ref(2, r1 + r5).get();
          r2 = CPU.cmpT(r2, r3);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r3 = CPU.addT(r1, 0x0);
            r2 = CPU.sp().value;
            r5 = MEMORY.ref(4, r3).get();
            r3 += 0x4;
            r6 = MEMORY.ref(4, r3).get();
            r3 += 0x4;
            MEMORY.ref(4, r2).setu(r5);
            r2 += 0x4;
            MEMORY.ref(4, r2).setu(r6);
            r2 = CPU.addT(r1, 0x0);
            r1 = CPU.addT(r3, 0x0);
            r5 = MEMORY.ref(4, r3).get();
            r3 += 0x4;
            r6 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, r2).setu(r5);
            r2 += 0x4;
            MEMORY.ref(4, r2).setu(r6);
            r2 += 0x4;
            r3 = CPU.sp().value;
            r5 = MEMORY.ref(4, r3).get();
            r3 += 0x4;
            r6 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, r2).setu(r5);
            r2 += 0x4;
            MEMORY.ref(4, r2).setu(r6);
          } else {
            //LAB_800417c
            r1 = CPU.addT(r1, 0x8);
          }

          //LAB_800417e
          r0 = CPU.subT(r0, 0x1);
          CPU.cmpT(r0, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8004184
      r4 = CPU.subT(r4, 0x1);
      CPU.cmpT(r4, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

    CPU.sp().value += 0x8;
  }

  @Method(0x80041d8)
  public static int FUN_80041d8(int r0, final int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;

    r3 = MEMORY.ref(4, 0x8004230).get();
    r5 = CPU.movT(0, 0x1);
    r4 = MEMORY.ref(4, 0x8004234).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r5 = CPU.negT(r5, r5);
    r3 = MEMORY.ref(4, 0x8004238).get();
    r2 = MEMORY.ref(2, r3).getUnsigned();
    r6 = CPU.addT(r2, 0x0);
    MEMORY.ref(2, r3).setu(r3);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(4, r4).get();
    r3 = CPU.cmpT(r3, r0);

    jmp_800420c:
    if(CPU.cpsr().getZero()) { // ==
      MEMORY.ref(2, r4 + 0x4).setu(r1);
      r5 = CPU.movT(0, 0x0);
    } else {
      //LAB_80041fa
      do {
        r2 = CPU.addT(r2, 0x1);
        r4 = CPU.addT(r4, 0x8);
        CPU.cmpT(r2, 0x13);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break jmp_800420c;
        }
        r3 = MEMORY.ref(4, r4).get();
        r3 = CPU.cmpT(r3, r0);
      } while(!CPU.cpsr().getZero()); // !=

      MEMORY.ref(2, r4 + 0x4).setu(r1);
      r5 = CPU.addT(r2, 0x0);
    }

    //LAB_800420c
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r4 = MEMORY.ref(4, 0x8004234).get();
    r5 = CPU.cmpT(r5, r3);

    jmp_8004254:
    if(CPU.cpsr().getZero()) { // ==
      r3 = MEMORY.ref(4, r4).get();
      r2 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_800423c
        do {
          r2 = CPU.addT(r2, 0x1);
          r4 = CPU.addT(r4, 0x8);
          CPU.cmpT(r2, 0x13);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break jmp_8004254;
          }
          r3 = MEMORY.ref(4, r4).get();
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=

        r3 = MEMORY.ref(4, 0x8004260).get();
        MEMORY.ref(4, r4).setu(r0);
        MEMORY.ref(2, r4 + 0x4).setu(r1);
        MEMORY.ref(1, r4 + 0x6).setu(r3);
        r5 = CPU.addT(r2, 0x0);
      } else {
        r3 = MEMORY.ref(4, 0x800422c).get();
        MEMORY.ref(4, r4).setu(r0);
        MEMORY.ref(2, r4 + 0x4).setu(r1);
        MEMORY.ref(1, r4 + 0x6).setu(r3);
        r5 = CPU.movT(0, 0x0);
      }
    }

    //LAB_8004254
    FUN_8004144();
    r3 = MEMORY.ref(4, 0x8004264).get();
    MEMORY.ref(2, r3).setu(r6);
    r0 = CPU.addT(r5, 0x0);

    //LAB_8004268
    return r0;
  }

  @Method(0x8004420)
  public static void FUN_8004420(final int r0) {
    final int r3 = _3001d34.get();
    final int r7 = r0 >> 8;

    if(r3 == 1) {
      int r6 = _3001a20.getAddress();

      //LAB_8004434
      for(int r5 = 20; r5 != 0; r5--) {
        if(MEMORY.ref(1, r6 + 0x5).getUnsigned() == r7) {
          MEMORY.call(MEMORY.ref(4, r6).get());
        }

        r6 += 0x8;
      }
    }

    //LAB_800444a
  }

  @Method(0x8004458)
  public static int FUN_8004458() {
    final int r1 = MEMORY.ref(4, 0x8004470).get();
    int r3 = MEMORY.ref(4, 0x8004474).get();
    final int r2 = MEMORY.ref(4, r1).get();
    int r0 = CPU.addT(r2, 0x0);
    r0 = CPU.mulT(r0, r3);
    r3 = MEMORY.ref(4, 0x8004478).get();
    r0 = CPU.addT(r0, r3);
    MEMORY.ref(4, r1).setu(r0);
    r0 = CPU.lslT(r0, 8);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x80044d0)
  public static int FUN_80044d0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80045d4)
  public static int FUN_80045d4(final int r0) {
    return (int)MEMORY.call(0x30001d8, r0) << 8;
  }

  @Method(0x8004760)
  public static void FUN_8004760() {
    CPU.sp().value -= 0x4;

    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(0x6002000);
    DMA.channels[3].CNT.setu(0x85000140);

    _3001cbc.setu(0x6002000);

    GPU.BG0CNT.setu(0x400); // Screen base block 8kb

    CPU.sp().value += 0x4;
  }

  @Method(0x800479c)
  public static void loadUiTextures() {
    // Font and UI
    final int addr = getPointerTableEntry(19);
    DMA.channels[3].SAD.setu(addr);
    DMA.channels[3].DAD.setu(0x6000000);
    DMA.channels[3].CNT.setu(0x84000800);

    // Palette stuff (looks like UI background colour palette)
    DMA.channels[3].SAD.setu(0x800777c);
    DMA.channels[3].DAD.setu(0x50001e0);
    DMA.channels[3].CNT.setu(0x80000010); // 16 16-bit words

    // Black background colour
    MEMORY.ref(2, 0x5000000).setu(0);

    // Overriding some of the UI background colours?
    MEMORY.ref(2, 0x50001e8).setu(0x4180);
    MEMORY.ref(2, 0x50001ea).setu(0x3960);
    MEMORY.ref(2, 0x50001ec).setu(0x3140);
    MEMORY.ref(2, 0x50001ee).setu(0x2920);
    MEMORY.ref(2, 0x50001f0).setu(0x49A0);
    MEMORY.ref(2, 0x50001f2).setu(0x51c0);
    MEMORY.ref(2, 0x50001f4).setu(0x59e0);

    // Foreground palettes
    DMA.channels[3].SAD.setu(0x800779c);
    DMA.channels[3].DAD.setu(0x5000200);
    DMA.channels[3].CNT.setu(0x800000e0);
  }

  @Method(0x8004838)
  public static void FUN_8004838() {
    DMA.channels[3].SAD.setu(0x800779c);
    DMA.channels[3].DAD.setu(0x5000200);
    DMA.channels[3].CNT.setu(0x800000e0);
  }

  @Method(0x8004858)
  public static void initMemoryAllocator() {
    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(boardWramMallocHead_3001e50.getAddress());
    DMA.channels[3].CNT.setu(0x85000040);
    CPU.sp().value += 0x4;

    boardWramMallocHead_3001e50.setu(0x2030000);
    chipWramMallocHead_3001e54.setu(0x3002000);
  }

  /** Something related to memory allocation */
  @Method(0x80048b0)
  public static int FUN_80048b0(final int r0, int size) {
    int r2;

    int addr = MEMORY.ref(4, 0x3001e50 + r0 * 0x4).get();
    if(addr != 0) {
      return addr;
    }

    size = size + 0x3 & ~0x3;
    addr = chipWramMallocHead_3001e54.get();
    r2 = addr + size;
    if(r2 < 0x3007800) {
      //LAB_80048e2
      chipWramMallocHead_3001e54.setu(r2);
      MEMORY.ref(4, 0x3001e50 + r0 * 0x4).setu(addr);
      return addr;
    }

    addr = boardWramMallocHead_3001e50.get();
    r2 = addr + size;
    if(r2 < 0x2040000) {
      //LAB_80048dc
      boardWramMallocHead_3001e50.setu(r2);
      MEMORY.ref(4, 0x3001e50 + r0 * 0x4).setu(addr);
      return addr;
    }

    //LAB_80048e6
    return 0;
  }

  @Method(0x80048f4)
  public static int FUN_80048f4(int r0, int r1) {
    final int r2;
    final int r5;

    r5 = r0 * 0x4;
    r0 = boardWramMallocHead_3001e50.offset(r5).get();
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = boardWramMallocHead_3001e50.get();
      r1 = (r1 + 0x3) / 0x4 * 0x4;
      r2 = r0 + r1;
      CPU.cmpT(r2, 0x2040000);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = boardWramMallocHead_3001e50.offset(0x4).get();
        r1 = r0 + r1;
        CPU.cmpT(r1, 0x30077ff);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          return 0;
        }

        //LAB_8004920
        boardWramMallocHead_3001e50.offset(0x4).setu(r1);
        boardWramMallocHead_3001e50.offset(r5).setu(r0);
      } else {
        //LAB_8004926
        boardWramMallocHead_3001e50.setu(r2);
        boardWramMallocHead_3001e50.offset(r5).setu(r0);
      }
    }

    //LAB_800492a
    return r0;
  }

  /** Maybe malloc */
  @Method(0x8004938)
  public static int FUN_8004938(int size) {
    size = size + 0x3 & ~0x3;

    int currentAddr = chipWramMallocHead_3001e54.get();
    int newAddr = currentAddr + size;
    if(newAddr < 0x3007800) {
      chipWramMallocHead_3001e54.setu(newAddr);
      return currentAddr;
    }

    currentAddr = boardWramMallocHead_3001e50.get();
    newAddr = currentAddr + size;
    if(newAddr < 0x2040000) {
      boardWramMallocHead_3001e50.setu(newAddr);
      return currentAddr;
    }

    return 0;
  }

  @Method(0x8004970)
  public static int FUN_8004970(int r0) {
    int r2;
    int r3;

    r3 = CPU.addT(r0, 0x3);
    r3 = CPU.lsrT(r3, 2);
    r2 = boardWramMallocHead_3001e50.get();
    r0 = CPU.lslT(r3, 2);
    r3 = CPU.addT(r2, r0);
    r3 = CPU.cmpT(r3, 0x2040000);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r2 = chipWramMallocHead_3001e54.get();
      r0 = CPU.addT(r2, r0);
      r0 = CPU.cmpT(r0, 0x30077ff);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        return 0;
      }

      //LAB_8004994
      chipWramMallocHead_3001e54.setu(r0);
    } else {
      //LAB_8004998
      boardWramMallocHead_3001e50.setu(r3);
    }

    //LAB_800499a
    //LAB_800499c
    return r2;
  }

  @Method(0x8005340)
  public static int decompress(final int src, final int dst) {
    // Copy decompression routine into system memory
    final int size = 0x2c4;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8002544);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    LOGGER.info("Copying function 0x8002544 to 0x%x", addr);
    MEMORY.setFunction(addr, Decompressor.class, "decompress", int.class, int.class);

    // Decompress
    final int decompressedSize = (int)MEMORY.call(addr, src, dst);

    FUN_8002df0(addr);

    if(src == 0x8779188 && dst == 0x2008000) {
      MEMORY.addFunctions(Decompressed8779188.class);
    } else if(src == 0x87795e8 && dst == 0x2008000) {
      MEMORY.addFunctions(Decompressed87795e8.class);
    }

    return decompressedSize;
  }

  @Method(0x8005394)
  public static int FUN_8005394(final int r0, final int r1) {
    final int size = 0x4ec;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8002808);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3006000 -> MEMORY.addFunctions(CopiedSegment8002808.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    final int ret = (int)MEMORY.call(addr, r0, r1);
    FUN_8002df0(addr);

    return ret;
  }

  @Method(0x80056cc)
  public static int FUN_80056cc() {
    int r0;
    int r1;
    int r2;
    int r5;
    int r6;
    int r7;

    CPU.sp().value -= 0x18;

    final int r11 = FUN_80048f4(0x33, 0x1100);
    r0 = CPU.sp().value + 0x4;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r11);
    DMA.channels[3].CNT.setu(0x85000440);

    FUN_80069c8(2, 0x30000f4);
    r7 = 0;

    //LAB_8005704
    //LAB_800570c
    while((short)FUN_8006910() != 0) {
      FUN_80030f8(1);
      r7++;

      if(r7 > 7) {
        //LAB_800571c
        CPU.sp().value += 0x18;
        return 1;
      }
    }

    //LAB_800572c
    MEMORY.ref(4, CPU.sp().value).setu(r11 + 0x40);
    final int r8 = CPU.sp().value + 0x8;
    r6 = r11;
    r7 = 0;
    int r9 = r6 + 0x20;
    int r10 = r6 + 0x10;

    //LAB_8005748
    do {
      MEMORY.ref(1, r6).setu(0);
      MEMORY.ref(1, r10).setu(0x10);
      MEMORY.ref(2, r9).setu(0);
      r5 = FUN_80058ac(r7);
      DMA.channels[3].SAD.setu(MEMORY.ref(4, CPU.sp().value).get());
      DMA.channels[3].DAD.setu(CPU.sp().value + 0x8);
      DMA.channels[3].CNT.setu(0x84000004);

      //LAB_800576c
      while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
        DebugHelper.sleep(0);
      }

      r0 = FUN_8005c08(r8, 0x8005794, 7); // strcmp? r1 is CAMELOT

      if(r0 == 0) {
        MEMORY.ref(2, r9).setu(MEMORY.ref(2, r8 + 0xa).getUnsigned());
        r2 = MEMORY.ref(1, r8 + 0x7).getUnsigned();
        if(r2 < 16) {
          if(r5 == 0) {
            MEMORY.ref(1, r6).setu(1);
            MEMORY.ref(1, r10).setu(r2);
            r1 = r11;
            r0 = r1 + 0x20;

            //LAB_80057c8
            while(r5 < r7) {
              if(MEMORY.ref(1, r1 + 0x10).getUnsigned() == r2) {
                if(MEMORY.ref(2, r0).getUnsigned() < MEMORY.ref(2, r8 + 0xa).getUnsigned()) {
                  MEMORY.ref(1, r1).setu(0);
                } else {
                  //LAB_80057de
                  MEMORY.ref(1, r6).setu(0);
                }
              }

              //LAB_80057e0
              r5++;
              r1++;
              r0 += 0x2;
            }
          }
        }
      }

      //LAB_80057ea
      r7++;
      r6++;
      r9 += 0x2;
      r10++;
    } while(r7 < 16);

    //LAB_80057fc
    CPU.sp().value += 0x18;
    return 0;
  }

  @Method(0x80058ac)
  public static int FUN_80058ac(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;

    r3 = MEMORY.ref(4, 0x80058f8).get();
    r5 = MEMORY.ref(4, r3).get();
    r0 = CPU.lslT(r0, 16);
    r5 = CPU.addT(r5, 0x40);
    r3 = CPU.movT(0, 0x80);
    r2 = CPU.addT(r5, 0x0);
    r0 = CPU.lsrT(r0, 16);
    r3 = CPU.lslT(r3, 5);
    r1 = CPU.movT(0, 0x0);
    CPU.sp().value -= 0x10;
    FUN_8006ba8(r0, r1, r2, r3);
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.sp().value;
    r2 = MEMORY.ref(4, 0x8005900).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r2 = CPU.movT(0, 0x80);
    r1 = MEMORY.ref(4, 0x80058fc).get();
    r2 = CPU.lslT(r2, 24);

    //LAB_80058d8
    do {
      r3 = MEMORY.ref(4, r1 + 0x8).get();
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    r0 = FUN_8005ae0();
    r3 = CPU.sp().value;
    r3 = MEMORY.ref(2, r3 + 0x8).getUnsigned();
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    r0 = CPU.subT(r0, r3);
    CPU.sp().value += 0x10;
    return r0;
  }

  @Method(0x8005ae0)
  public static int FUN_8005ae0() {
    int r0;
    int r1;
    int r2;
    int r3;
    final int r4;

    r3 = MEMORY.ref(4, 0x8005b1c).get();
    r3 = MEMORY.ref(4, r3).get();
    r4 = MEMORY.ref(4, 0x8005b20).get();
    r2 = CPU.addT(r3, 0x0);
    r0 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.addT(r2, 0x50);

    //LAB_8005af0
    do {
      r3 = MEMORY.ref(1, r2).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x1).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x2).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x3).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x5).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x6).getUnsigned();
      r0 = CPU.addT(r0, r3);
      r3 = MEMORY.ref(1, r2 + 0x7).getUnsigned();
      r1 = CPU.addT(r1, 0x8);
      r0 = CPU.addT(r0, r3);
      r2 = CPU.addT(r2, 0x8);
      r1 = CPU.cmpT(r1, r4);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    return r0;
  }

  @Method(0x8005b24)
  public static int FUN_8005b24(final int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;

    r2 = MEMORY.ref(4, 0x3001f1c).get();
    r1 = r2 + 0x20;
    r5 = 0x10;
    int r0_0 = 0;

    //LAB_8005b38
    for(r4 = 0; r4 < 16; r4++) {
      if(MEMORY.ref(1, r2).getUnsigned() != 0) {
        if(r0 == MEMORY.ref(1, r2 + 0x10).getUnsigned()) {
          r3 = MEMORY.ref(2, r1).getUnsigned();
          if(r0_0 < r3) {
            r0_0 = r3;
            r5 = r4;
          }
        }
      }

      //LAB_8005b4e
      r1 += 0x2;
      r2++;
    }

    return r5;
  }

  @Method(0x8005c08)
  public static int FUN_8005c08(int r0, int r1, int len) {
    //LAB_8005c16
    if(len == 0) {
      return 0;
    }

    //LAB_8005c10
    int r2;
    while((r2 = MEMORY.ref(1, r0).getUnsigned() - MEMORY.ref(1, r1).getUnsigned()) == 0) {
      len--;
      r0++;
      r1++;

      if(len == 0) {
        break;
      }
    }

    //LAB_8005c24
    return r2;
  }

  @Method(0x8005c68)
  public static int FUN_8005c68() {
    int r0;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x4;
    r5 = MEMORY.ref(4, 0x3001f1c).get() + 0x1040;
    CPU.r8().value = 0;
    r7 = CPU.sp().value;
    CPU.r10().value = 0;

    //LAB_8005c86
    for(r6 = 0; r6 < 3; r6++) {
      MEMORY.ref(4, r7).setu(CPU.r10().value);
      DMA.channels[3].SAD.setu(r7);
      DMA.channels[3].DAD.setu(r5);
      DMA.channels[3].CNT.setu(0x85000010);

      r0 = FUN_8005b24(r6);
      if(r0 < 16) {
        FUN_8006ba8(r0 & 0xffff, 0, r5, 0x40);
        CPU.r8().value++;
      }

      //LAB_8005cb2
      r0 = FUN_8005b24(r6 + 3);
      if(r0 < 16) {
        FUN_8006ba8(r0 & 0xffff, 0x110, r5 + 0x38, 0x4);
      } else {
        //LAB_8005cd0
        MEMORY.ref(4, r5 + 0x38).setu(CPU.r10().value);
      }

      //LAB_8005cd4
      r5 += 0x40;
    }

    r0 = CPU.r8().value;
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();

    return r0;
  }

  @Method(0x8005cf8)
  public static void FUN_8005cf8() {
    setInterruptHandler(5, 0, null);
    FUN_8002dd8(0x33);
  }

  @Method(0x8005fcc)
  public static int FUN_8005fcc() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006088)
  public static int FUN_8006088(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x800655c)
  public static void FUN_800655c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006864)
  public static void CpuSet(final int src, final int dest, final int lenMode) {
    GATE.acquire();
    Bios.CpuSet(src, dest, lenMode);
    GATE.release();
  }

  @Method(0x8006868)
  public static void SoundBias0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006870)
  public static void SoundBias200() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006878)
  public static int FUN_8006878() {
    int r0;
    int r1;
    int r2;
    int r4;
    final int r5;

    CPU.sp().value -= 0x44;
    FUN_8006ac0(CPU.sp().value);
    r5 = CPU.sp().value + 0x1;
    MEMORY.ref(1, 0xe005555).setu(0xaa);
    MEMORY.ref(1, 0xe002aaa).setu(0x55);
    MEMORY.ref(1, 0xe005555).setu(0x90);
    r1 = CPU.sp().value + 0x40;
    MEMORY.ref(2, r1).setu(20000);

    //LAB_80068ac
    //TODO wait loop?
    while(MEMORY.ref(2, r1).getUnsigned() != 0) {
      MEMORY.ref(2, r1).decr();
    }

    r0 = MEMORY.ref(4, 0x80068e8).get();
    r0 = (int)MEMORY.call(r5, r0);
    r0 = CPU.lslT(r0, 24);
    r4 = CPU.lsrT(r0, 16);
    r0 = CPU.movT(0, 0xe0);
    r0 = CPU.lslT(r0, 20);
    r0 = (int)MEMORY.call(r5, r0);
    r0 = CPU.lslT(r0, 24);
    r0 = CPU.lsrT(r0, 24);
    r4 = CPU.orrT(r4, r0);
    r2 = MEMORY.ref(4, 0x80068ec).get();
    r0 = CPU.movT(0, 0xaa);
    MEMORY.ref(1, r2).setu(r0);
    r1 = MEMORY.ref(4, 0x80068f0).get();
    r0 = CPU.movT(0, 0x55);
    MEMORY.ref(1, r1).setu(r0);
    r0 = CPU.movT(0, 0xf0);
    MEMORY.ref(1, r2).setu(r0);
    r1 = CPU.sp().value + 0x40;
    r2 = MEMORY.ref(4, 0x80068f4).get();
    r0 = CPU.addT(r2, 0x0);
    MEMORY.ref(2, r1).setu(r0);
    r0 = MEMORY.ref(2, r1).getUnsigned();
    CPU.cmpT(r0, 0x0);

    //LAB_80068f8
    while(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(2, r1).getUnsigned();
      r0 = CPU.subT(r0, 0x1);
      MEMORY.ref(2, r1).setu(r0);
      r0 = MEMORY.ref(2, r1).getUnsigned();
      CPU.cmpT(r0, 0x0);
    }

    r0 = CPU.addT(r4, 0x0);
    CPU.sp().value += 0x44;
    return r0;
  }

  @Method(0x8006910)
  public static int FUN_8006910() {
    INTERRUPTS.WAITCNT.and(0xfffc).oru(0x3);
    final int r3 = FUN_8006878() & 0xffff;
    int r2 = 0x8007a0c;
    int r4 = 0;

    //LAB_800693e
    if(MEMORY.ref(4, r2).deref(4).offset(1, 0x28).getUnsigned() == 0) {
      r4 = 1;
    } else {
      //LAB_800693c
      while(r3 != MEMORY.ref(4, r2).deref(4).offset(2, 0x28).getUnsigned()) {
        r2 += 0x4;

        if(MEMORY.ref(4, r2).deref(4).offset(1, 0x28).getUnsigned() == 0) {
          r4 = 1;
          break;
        }
      }
    }

    //LAB_8006952
    MEMORY.ref(4, 0x2004c04).setu(MEMORY.ref(4, r2).deref(4).get());
    MEMORY.ref(4, 0x2004c10).setu(MEMORY.ref(4, r2).deref(4).offset(0x04).get());
    MEMORY.ref(4, 0x2004c14).setu(MEMORY.ref(4, r2).deref(4).offset(0x08).get());
    MEMORY.ref(4, 0x2004c00).setu(MEMORY.ref(4, r2).deref(4).offset(0x0c).get());
    MEMORY.ref(4, 0x2004c18).setu(MEMORY.ref(4, r2).deref(4).offset(0x10).get());
    MEMORY.ref(4, 0x2004c08).setu(MEMORY.ref(4, r2).get() + 0x14);

    return r4;
  }

  @Method(0x80069c8)
  public static int FUN_80069c8(int r0, int r1) {
    final int r2;
    final int r3;
    r2 = CPU.addT(r1, 0x0);
    r0 = CPU.lslT(r0, 24);
    r1 = CPU.lsrT(r0, 24);
    CPU.cmpT(r1, 0x3);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r0 = MEMORY.ref(4, 0x80069ec).get();
      MEMORY.ref(1, r0).setu(r1);
      r1 = MEMORY.ref(4, 0x80069f0).get();
      r0 = MEMORY.ref(1, r0).getUnsigned();
      r0 = CPU.lslT(r0, 2);
      r3 = MEMORY.ref(4, 0x80069f4).get();
      r0 = CPU.addT(r0, r3);
      MEMORY.ref(4, r1).setu(r0);
      r0 = MEMORY.ref(4, 0x80069f8).get();
      MEMORY.ref(4, r2).setu(r0);
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_80069fc
      r0 = CPU.movT(0, 0x1);
    }

    //LAB_80069fe
    return r0;
  }

  @Method(0x8006abc)
  public static int FUN_8006abc(final int r0) {
    return MEMORY.ref(1, r0).getUnsigned();
  }

  /** Copies {@link #FUN_8006abc} to r0 */
  @Method(0x8006ac0)
  public static void FUN_8006ac0(final int r0) {
    MEMORY.ref(4, 0x2004c1c).setu(r0 + 0x1);

    //LAB_8006ae4
    for(int i = 0; i < 2; i++) {
      MEMORY.ref(2, r0 + i * 0x2).setu(MEMORY.ref(2, 0x8006abc + i * 0x2).getUnsigned());
    }

    MEMORY.setFunction(r0, GoldenSun.class, "FUN_8006abc", int.class);
  }

  @Method(0x8006ba8)
  public static void FUN_8006ba8(int r0, int r1, int r2, int r3) {
    int r4;
    final int r5;
    final int r6;
    final int r7;

    CPU.sp().value -= 0x80;
    r5 = CPU.addT(r1, 0x0);
    r6 = CPU.addT(r2, 0x0);
    r7 = CPU.addT(r3, 0x0);
    r0 = CPU.lslT(r0, 16);
    r4 = CPU.lsrT(r0, 16);
    r2 = MEMORY.ref(4, 0x8006bd8).get();
    r0 = MEMORY.ref(2, r2).getUnsigned();
    r1 = MEMORY.ref(4, 0x8006bdc).get();
    r0 = CPU.andT(r0, r1);
    r1 = CPU.movT(0, 0x3);
    r0 = CPU.orrT(r0, r1);
    MEMORY.ref(2, r2).setu(r0);
    r3 = MEMORY.ref(4, 0x8006be0).get();
    r0 = CPU.movT(0, 0x1);
    r3 = CPU.eorT(r3, r0);
    r2 = CPU.sp().value;
    r0 = MEMORY.ref(4, 0x8006be4).get();
    r1 = MEMORY.ref(4, 0x8006be0).get();
    r0 = CPU.subT(r0, r1);
    r0 = CPU.lslT(r0, 15);
    r1 = CPU.lsrT(r0, 16);

    //LAB_8006be8
    while(r1 != 0) {
      r0 = MEMORY.ref(2, r3).getUnsigned();
      MEMORY.ref(2, r2).setu(r0);
      r3 = CPU.addT(r3, 0x2);
      r2 = CPU.addT(r2, 0x2);
      r0 = CPU.subT(r1, 0x1);
      r0 = CPU.lslT(r0, 16);
      r1 = CPU.lsrT(r0, 16);
      r1 = CPU.lsrT(r0, 16);
    }

    r3 = CPU.sp().value;
    r3 = CPU.addT(r3, 0x1);
    r0 = MEMORY.ref(4, 0x8006c20).get();
    r0 = MEMORY.ref(1, r0 + 0x1c).getUnsigned();
    r4 = CPU.lslT(r4, r0);
    r0 = CPU.addT(r4, 0x0);
    r2 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 20);
    r1 = CPU.addT(r5, r2);
    r0 = CPU.addT(r0, r1);
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.addT(r7, 0x0);
    MEMORY.call(r3, r0, r1, r2);
    CPU.sp().value += 0x80;
  }

  @Method(0x80072e8)
  public static void FUN_80072e8(final int r0, final int r1) {
    MEMORY.call(r1, r0);
  }

  @Method(0x80072ec)
  public static void FUN_80072ec(final int r0, final int r1, final int r2) {
    MEMORY.call(r2, r0, r1);
  }

  @Method(0x80072fc)
  public static void FUN_80072fc(final int r0, final int r1, final int r2, final int r3, final int r4, final int r5, final int r6) {
    MEMORY.call(r6, r0);
  }

  @Method(0x8007304)
  public static void FUN_8007304(final int r0, final int r1, final int r2, final int r3, final int r4, final int r5, final int r6, final int r7) {
    MEMORY.call(CPU.r8().value, r0);
  }

  @Method(0x8007318)
  public static void callStackFunction(final int r0, final int r1) {
    MEMORY.call(CPU.sp().value, r0, r1);
  }

  @Method(0x8009048)
  public static int FUN_8009048(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009078)
  public static void FUN_8009078(final int r0) {
    MEMORY.call(0x800c005, r0);
  }

  @Method(0x8009080)
  public static void FUN_8009080(final int r0, final int r1) {
    MEMORY.call(0x800c301, r0, r1);
  }

  @Method(0x8009098)
  public static void FUN_8009098(final int r0, final int r1) {
    MEMORY.call(0x800c2d9, r0, r1);
  }

  @Method(0x80090a0)
  public static void FUN_80090a0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80090a8)
  public static void FUN_80090a8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80090b0)
  public static void FUN_80090b0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80090b8)
  public static void FUN_80090b8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80090c8)
  public static int FUN_80090c8(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x800c151, r0, r1, r2, r3);
  }

  @Method(0x80090d0)
  public static int FUN_80090d0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80090e0)
  public static void FUN_80090e0(final int r0, final int r1) {
    MEMORY.call(0x800c4bd, r0, r1);
  }

  @Method(0x80090f0)
  public static void FUN_80090f0(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009110)
  public static int FUN_8009110(final int r0) {
    return (int)MEMORY.call(0x800fb39, r0);
  }

  @Method(0x8009118)
  public static void FUN_8009118() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009128)
  public static void FUN_8009128() {
    MEMORY.call(0x800fe9d);
  }

  @Method(0x8009130)
  public static void FUN_8009130() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009138)
  public static void FUN_8009138(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009140)
  public static void FUN_8009140(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80091a8)
  public static int FUN_80091a8(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x8011f55, r0, r1, r2);
  }

  @Method(0x80091e0)
  public static void FUN_80091e0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009228)
  public static void FUN_8009228(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x800aa0c)
  public static int FUN_800aa0c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x800b168)
  public static void FUN_800b168(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r7 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r0, 0x20);
    r0 = MEMORY.ref(1, r0).getUnsigned();
    CPU.sp().value -= 0x44;
    r0 = CPU.lsrT(r0, 1);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
    r0 = CPU.addT(r7, 0x0);
    r0 = CPU.addT(r0, 0x21);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.lsrT(r0, 1);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
    r4 = CPU.movT(0, 0x8);
    r0 = CPU.movT(0, 0x4);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    r4 = MEMORY.ref(4, r2).get();
    r2 += 0x4;

    r0 = MEMORY.ref(4, r1).get();
    r1 += 0x4;

    r2 = MEMORY.ref(4, r2).get();
    CPU.r9().value = r2;
    r2 = MEMORY.ref(4, r1).get();
    r1 += 0x4;

    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    CPU.r8().value = r4;
    r3 = CPU.lslT(r3, 16);
    r4 = MEMORY.ref(4, r1).get();
    r1 += 0x4;

    r3 = CPU.lsrT(r3, 16);
    r6 = MEMORY.ref(4, r1).get();
    CPU.r10().value = r0;
    r1 = CPU.addT(r3, 0x0);
    r0 = CPU.addT(r7, 0x0);
    CPU.r11().value = r4;
    r0 = FUN_800aa0c(r0, r1);
    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x0);

    jmp_800b222:
    {
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(2, r7 + 0x1e).getUnsigned();
      } else {
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 9);
        CPU.cmpT(CPU.r8().value, r0);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = MEMORY.ref(2, r7 + 0x1e).getUnsigned();
        } else {
          CPU.cmpT(CPU.r9().value, CPU.r8().value);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = MEMORY.ref(2, r7 + 0x1e).getUnsigned();
          } else {
            r2 = MEMORY.ref(2, r7 + 0x1e).getUnsigned();
            r3 = CPU.addT(r2, 0x0);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r1 = CPU.movT(0, 0x0);
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
              MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
              break jmp_800b222;
            }
          }
        }
      }

      //LAB_800b1dc
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
      r0 = CPU.sp().value + 0x24;
      r3 = MEMORY.ref(4, r0 + 0x4).get();
      r4 = MEMORY.ref(4, 0x800b2c8).get();
      r3 = CPU.andT(r3, r4);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(4, r0 + 0x4).setu(r3);
      r1 = CPU.r8().value;
      r3 = CPU.lslT(r1, 8);
      r1 = MEMORY.ref(4, CPU.sp().value + 0x24).get();
      r3 = CPU.lsrT(r3, 16);
      r2 = CPU.r9().value;
      r1 = CPU.andT(r1, r4);
      r1 = CPU.orrT(r1, r3);
      r3 = CPU.lslT(r2, 8);
      r2 = MEMORY.ref(4, 0x800b2cc).get();
      r3 = CPU.lsrT(r3, 16);
      r3 = CPU.lslT(r3, 16);
      r1 = CPU.andT(r1, r2);
      r1 = CPU.orrT(r1, r3);
      MEMORY.ref(4, CPU.sp().value + 0x24).setu(r1);
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(2, r0).getUnsigned();
        r3 = CPU.negT(r3, r3);
        r3 = CPU.lslT(r3, 16);
        r2 = CPU.addT(r4, 0x0);
        r3 = CPU.lsrT(r3, 16);
        r2 = CPU.andT(r2, r1);
        r2 = CPU.orrT(r2, r3);
        MEMORY.ref(4, CPU.sp().value + 0x24).setu(r2);
      }

      //LAB_800b21c
      r0 = FUN_8003d28(r0);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
    }

    //LAB_800b222
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 9);
    if(CPU.r8().value > r3 || CPU.r9().value > r3) {
      //LAB_800b22e
      r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
      r3 = CPU.movT(0, 0x3);
      r4 = CPU.lslT(r4, 1);
      r0 = CPU.lslT(r0, 1);
      r1 = CPU.movT(0, 0x10);
      r2 = CPU.movT(0, 0x8);
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r4);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r1);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r2);
    }

    //LAB_800b246
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r4 = MEMORY.ref(4, 0x800b2d0).get();
    r3 = CPU.cmpT(r3, r4);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r0 = CPU.movT(0, 0x1);
      MEMORY.ref(4, CPU.sp().value).setu(r0);
      r4 = CPU.movT(0, 0x0);
    } else {
      //LAB_800b256
      r1 = CPU.r11().value;
      r3 = CPU.asrT(r1, 17);
      r3 = CPU.addT(r3, 0xa);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r4 = CPU.movT(0, 0x2);
    }

    //LAB_800b260
    r2 = CPU.r11().value;
    r3 = CPU.subT(r2, r6);
    r0 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r3 = CPU.asrT(r3, 16);
    r6 = CPU.subT(r3, r0);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x26);
    r2 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.movT(0, 0x1);
    r1 = CPU.r10().value;
    r3 = CPU.andT(r3, r2);
    r5 = CPU.asrT(r1, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r6, 0x9f);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r0 = CPU.addT(r7, 0x0);
        r0 = CPU.addT(r0, 0xc);
        r2 = MEMORY.ref(1, r0 + 0x5).getUnsigned();
        r3 = CPU.movT(0, 0x4);
        r3 = CPU.negT(r3, r3);
        r3 = CPU.andT(r3, r2);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(1, r0 + 0x5).setu(r3);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r3 = CPU.movT(0, 0x1f);
        r1 = MEMORY.ref(1, r0 + 0x7).getUnsigned();
        r2 = CPU.andT(r2, r3);
        r3 = CPU.movT(0, 0x3f);
        r3 = CPU.negT(r3, r3);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(1, r0 + 0x7).setu(r3);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
        r3 = MEMORY.ref(4, 0x800b2c4).get();
        r2 = CPU.subT(r5, r1);
        r2 = CPU.andT(r2, r3);
        r1 = MEMORY.ref(2, r0 + 0x6).getUnsigned();
        r3 = MEMORY.ref(4, 0x800b2d4).get();
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r0 + 0x6).setu(r3);
        MEMORY.ref(1, r0 + 0x4).setu(r6);
        r1 = CPU.addT(r4, 0x0);
        FUN_8003dec(r0, r1);
      } else {
        //LAB_800b2d8
        r2 = CPU.r10().value;
        r5 = CPU.asrT(r2, 16);
      }
    }

    //LAB_800b2dc
    r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
    r2 = CPU.subT(r5, r3);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x22);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r4 = CPU.r8().value;
    r4 = CPU.mulT(r4, r3);
    r0 = MEMORY.ref(4, 0x800b368).get();
    r3 = CPU.addT(r4, 0x0);
    r3 = CPU.addT(r3, r0);
    r3 = CPU.asrT(r3, 16);
    r4 = CPU.addT(r2, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    r2 = CPU.r11().value;
    r1 = CPU.subT(r2, r3);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r1 = CPU.asrT(r1, 16);
    r1 = CPU.subT(r1, r2);
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = MEMORY.ref(1, r2).getUnsigned();
    r2 = CPU.addT(r7, 0x0);
    r2 = CPU.addT(r2, 0x23);
    r2 = MEMORY.ref(1, r2).getUnsigned();
    r2 = CPU.lslT(r2, 24);
    r2 = CPU.asrT(r2, 24);
    r3 = CPU.lsrT(r3, 1);
    r3 = CPU.subT(r3, r2);
    r2 = CPU.r9().value;
    r2 = CPU.mulT(r2, r3);
    r3 = CPU.addT(r2, 0x0);
    r3 = CPU.addT(r3, r0);
    r3 = CPU.asrT(r3, 16);
    r6 = CPU.subT(r1, r3);
    CPU.cmpT(r4, 0xef);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      CPU.cmpT(r6, 0x9f);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r3 = MEMORY.ref(4, 0x800b364).get();
        r0 = CPU.addT(r7, 0x0);
        r2 = MEMORY.ref(2, r0 + 0x6).getUnsigned();
        r4 = CPU.andT(r4, r3);
        r3 = MEMORY.ref(4, 0x800b36c).get();
        r3 = CPU.andT(r3, r2);
        r3 = CPU.orrT(r3, r4);
        MEMORY.ref(2, r0 + 0x6).setu(r3);
        MEMORY.ref(1, r0 + 0x4).setu(r6);
        r2 = MEMORY.ref(1, r0 + 0x5).getUnsigned();
        r3 = CPU.movT(0, 0x4);
        r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = CPU.negT(r3, r3);
        r3 = CPU.andT(r3, r2);
        r3 = CPU.orrT(r3, r4);
        MEMORY.ref(1, r0 + 0x5).setu(r3);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r3 = CPU.movT(0, 0x1f);
        r1 = CPU.andT(r1, r3);
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
        r3 = CPU.movT(0, 0x3f);
        r2 = MEMORY.ref(1, r0 + 0x7).getUnsigned();
        r3 = CPU.negT(r3, r3);
        r1 = CPU.lslT(r1, 1);
        r3 = CPU.andT(r3, r2);
        r3 = CPU.orrT(r3, r1);
        MEMORY.ref(1, r0 + 0x7).setu(r3);
        r1 = MEMORY.ref(4, CPU.sp().value).get();
        FUN_8003dec(r0, r1);
      }
    }

    //LAB_800b374
    CPU.sp().value += 0x44;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x800b798)
  public static int FUN_800b798(final int r0) {
    int r2 = MEMORY.ref(4, 0x3001e68).get() + 0x1c;

    //LAB_800b7a4
    for(int i = 0; i < 8; i++) {
      if(MEMORY.ref(4, r2).get() == r0) {
        return MEMORY.ref(4, r2 + 0x4).get();
      }

      //LAB_800b7ae
      r2 += 0x8;
    }

    //LAB_800b7b8
    return 0;
  }

  @Method(0x800b8ac)
  public static void FUN_800b8ac(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    final int r6;
    int r7;

    CPU.push(CPU.r8().value);

    r6 = CPU.addT(r0, 0x0);
    r5 = MEMORY.ref(4, r6 + 0x28).get();
    CPU.r8().value = r1;
    r7 = CPU.movT(0, 0x0);
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.addT(r6, 0x0);
      r3 = CPU.addT(r3, 0x28);

      //LAB_800b8c2
      do {
        r7 = CPU.addT(r7, 0x1);
        CPU.cmpT(r7, 0x3);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break;
        }
        r3 = CPU.addT(r3, 0x4);
        r5 = MEMORY.ref(4, r3).get();
        CPU.cmpT(r5, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_800b8d0
    CPU.cmpT(r7, 0x4);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
    } else {
      //LAB_800b8da
      r0 = CPU.r8().value;
      r0 = FUN_800bbc0(r0);
      r5 = CPU.addT(r0, 0x0);
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.lslT(r7, 2);
        r3 = CPU.addT(r3, 0x28);
        r0 = CPU.r8().value;
        MEMORY.ref(4, r6 + r3).setu(r5);
        r0 = FUN_8185000(r0);
        r2 = CPU.movT(0, 0x27);
        r2 = CPU.addT(r2, r6);
        r3 = MEMORY.ref(1, r2).getUnsigned();
        CPU.r12().value = r2;
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(1, r0).getUnsigned();
          r3 = CPU.addT(r6, 0x0);
          r3 = CPU.addT(r3, 0x20);
          MEMORY.ref(1, r3).setu(r2);
          r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
          r2 = CPU.addT(r6, 0x0);
          r2 = CPU.addT(r2, 0x21);
          MEMORY.ref(1, r2).setu(r3);
          r3 = MEMORY.ref(2, r0 + 0x2).getUnsigned();
          r3 = CPU.lslT(r3, 8);
          MEMORY.ref(4, r6 + 0x18).setu(r3);
          r3 = MEMORY.ref(1, r0 + 0x7).getUnsigned();
          r2 = CPU.addT(r2, 0x2);
          MEMORY.ref(1, r2).setu(r3);
          r1 = CPU.addT(r6, 0x0);
          r3 = MEMORY.ref(1, r0 + 0x6).getUnsigned();
          r1 = CPU.addT(r1, 0x22);
          MEMORY.ref(1, r1).setu(r3);
        }

        //LAB_800b924
        r2 = CPU.r12().value;
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r7 = CPU.cmpT(r7, r3);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.addT(r7, 0x1);
          MEMORY.ref(1, r2).setu(r3);
        }

        //LAB_800b930
        r0 = CPU.addT(r5, 0x0);
      }
    }

    //LAB_800b932
    r3 = CPU.pop();

    CPU.r8().value = r3;
  }

  @Method(0x800ba30)
  public static int FUN_800ba30(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r7 = CPU.addT(r0, 0x0);
    r2 = CPU.movT(0, 0x24);
    r6 = CPU.addT(r1, 0x0);
    r3 = CPU.movT(0, 0x7f);
    r2 = CPU.addT(r2, r7);
    r4 = CPU.movT(0, 0x80);
    r4 = CPU.andT(r4, r6);
    r6 = CPU.andT(r6, r3);
    r3 = MEMORY.ref(1, r2).getUnsigned();
    CPU.sp().value -= 0x8;
    CPU.r10().value = r2;
    r3 = CPU.cmpT(r3, r6);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x27);
      r3 = CPU.addT(r3, r7);
      r1 = CPU.movT(0, 0x0);
      CPU.r8().value = r3;

      r2 = CPU.r8().value;
      r3 = MEMORY.ref(1, r2).getUnsigned();
      r1 = CPU.cmpT(r1, r3);

      //LAB_800ba5c
      while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = CPU.lslT(r1, 2);
        r3 = CPU.addT(r3, 0x28);
        r5 = MEMORY.ref(4, r7 + r3).get();
        CPU.cmpT(r5, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r5 + 0xc).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = CPU.movT(0, 0x0);
            r0 = MEMORY.ref(2, r5 + r2).get();
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r0 = FUN_8185000(r0);
            r3 = MEMORY.ref(1, r0 + 0x5).getUnsigned();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r4 = MEMORY.ref(4, CPU.sp().value).get();
            r6 = CPU.cmpT(r6, r3);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r2 = MEMORY.ref(4, r5 + 0xc).get();
              r3 = CPU.lslT(r6, 2);
              r2 = MEMORY.ref(4, r3 + r2).get();
              r3 = MEMORY.ref(1, r0 + 0x4).getUnsigned();
              MEMORY.ref(1, r5 + 0x4).setu(r3);
              r3 = CPU.movT(0, 0x10);
              MEMORY.ref(4, r5 + 0x10).setu(r2);
              MEMORY.ref(1, r5 + 0x15).setu(r3);
              CPU.cmpT(r4, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                MEMORY.ref(1, r5 + 0x14).setu(r4);
                MEMORY.ref(2, r5 + 0x2).setu(r4);
              }

              //LAB_800ba9a
              CPU.cmpT(r1, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r3 = MEMORY.ref(1, r0 + 0x7).getUnsigned();
                r2 = CPU.addT(r7, 0x0);
                r2 = CPU.addT(r2, 0x23);
                MEMORY.ref(1, r2).setu(r3);
                r3 = MEMORY.ref(1, r0 + 0x6).getUnsigned();
                r2 = CPU.subT(r2, 0x1);
                MEMORY.ref(1, r2).setu(r3);
              }
            }
          }
        }

        //LAB_800baac
        r1 = CPU.addT(r1, 0x1);

        //LAB_800baae
        r2 = CPU.r8().value;
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r1 = CPU.cmpT(r1, r3);
      }

      r3 = CPU.r10().value;
      MEMORY.ref(1, r3).setu(r6);
    }

    //LAB_800baba
    r0 = CPU.movT(0, 0x0);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;

    return r0;
  }

  @Method(0x800bb20)
  public static void FUN_800bb20(final int r0) {
    final int r6;
    final int r7;
    if(r0 == 3) {
      r7 = FUN_80048f4(0x4, 0xe00);
      r6 = FUN_80048f4(0x3, 0x600);
    } else {
      //LAB_800bb40
      r7 = FUN_80048b0(0x4, 0xe00);
      r6 = FUN_80048b0(0x3, 0x600);
    }

    //LAB_800bb56
    FUN_8004838();

    CPU.sp().value -= 0x4;

    final int r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r7);
    DMA.channels[3].CNT.setu(0x85000380);

    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r6);
    DMA.channels[3].CNT.setu(0x85000180);

    FUN_8003fa4(0x5d, 0x80, 0x8012f20);

    final int size = 0x7c;
    DMA.channels[3].SAD.setu(0x800a418);
    DMA.channels[3].DAD.setu(FUN_80048b0(0x35, size));
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    CPU.sp().value += 0x4;
  }

  @Method(0x800bbc0)
  public static int FUN_800bbc0(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    r7 = CPU.r8().value;
    CPU.push(r7);

    CPU.sp().value -= 0x4;
    r4 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value).setu(r4);
    r7 = CPU.addT(r0, 0x0);
    r0 = FUN_8185000(r0);
    r3 = MEMORY.ref(4, 0x800bbe8).get();
    r6 = CPU.addT(r0, 0x0);
    r2 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(1, r6).getUnsigned();
    r5 = CPU.movT(0, 0x0);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
      r1 = CPU.movT(0, 0x0);

      //LAB_800bbec
      //LAB_800bbf6
      jmp_800bbfc:
      {
        while(r3 != 0) {
          r1 = CPU.addT(r1, 0x1);
          r2 = CPU.addT(r2, 0x18);
          CPU.cmpT(r1, 0x3f);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break jmp_800bbfc;
          }

          r3 = MEMORY.ref(1, r2 + 0x4).getUnsigned();
        }

        r4 = CPU.addT(r2, 0x0);
      }

      //LAB_800bbfc
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x800bc34).get();
        r0 = MEMORY.ref(4, r6 + 0xc).get();
        r5 = CPU.addT(r4, 0x0);
        CPU.r8().value = r3;
        MEMORY.ref(2, r5).setu(r7);
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.addT(r7, 0x0);
          r0 = FUN_800b798(r0);
        }

        //LAB_800bc14
        r2 = MEMORY.ref(4, r6 + 0x10).get();
        MEMORY.ref(4, r5 + 0x8).setu(r0);
        MEMORY.ref(4, r5 + 0xc).setu(r2);
        r3 = MEMORY.ref(1, r6 + 0xa).getUnsigned();
        MEMORY.ref(1, r5 + 0x7).setu(r3);
        r3 = CPU.movT(0, 0xff);
        MEMORY.ref(1, r5 + 0x16).setu(r3);
        r3 = MEMORY.ref(4, r2).get();
        MEMORY.ref(4, r5 + 0x10).setu(r3);
        r3 = CPU.r8().value;
        MEMORY.ref(1, r5 + 0x14).setu(r3);
        r3 = MEMORY.ref(1, r6 + 0x4).getUnsigned();
        MEMORY.ref(1, r5 + 0x4).setu(r3);
        r3 = CPU.r8().value;
        MEMORY.ref(1, r5 + 0x5).setu(r3);
      }
    }

    //LAB_800bc38
    r0 = CPU.addT(r5, 0x0);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();

    CPU.r8().value = r3;

    return r0;
  }

  @Method(0x800bc70)
  public static int FUN_800bc70(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    CPU.r8().value = 0;
    CPU.r10().value = r0;
    r0 = FUN_8185000(r0);
    r7 = CPU.addT(r0, 0x0);
    r0 = FUN_8004080();
    r3 = MEMORY.ref(4, 0x800bda8).get();
    r5 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(1, r7).getUnsigned();
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_800bc98
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x20);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r2 = CPU.movT(0, 0x0);

      //LAB_800bca2
      //LAB_800bcb0
      jmp_800bcb6:
      {
        while(r3 != 0) {
          r2 = CPU.addT(r2, 0x1);
          r5 = CPU.addT(r5, 0x38);
          CPU.cmpT(r2, 0x3f);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break jmp_800bcb6;
          }
          r3 = CPU.addT(r5, 0x0);
          r3 = CPU.addT(r3, 0x20);
          r3 = MEMORY.ref(1, r3).getUnsigned();
        }

        CPU.r8().value = r5;
      }

      //LAB_800bcb6
      r2 = CPU.r8().value;
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r6, 0x60);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r6, 0x0);
          r1 = CPU.movT(0, 0x0);
          r2 = CPU.movT(0, 0x0);
          r0 = FUN_8003fa4(r0, r1, r2);
          CPU.r12().value = r0;
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x0);
          } else {
            //LAB_800bcd6
            r3 = CPU.movT(0, 0x0);
            r2 = CPU.r8().value;
            r1 = CPU.r8().value;
            MEMORY.ref(1, r1 + 0x1c).setu(r6);
            MEMORY.ref(2, r2 + 0x1e).setu(r3);
            r2 = CPU.addT(r2, 0x26);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2).setu(r3);
            r3 = MEMORY.ref(1, r7).getUnsigned();
            r2 = MEMORY.ref(1, r7 + 0x1).getUnsigned();
            r3 = CPU.lslT(r3, 8);
            r0 = CPU.addT(r3, r2);
            r3 = CPU.movT(0, 0x81);
            r3 = CPU.lslT(r3, 5);
            r4 = MEMORY.ref(4, 0x800bdac).get();
            r0 = CPU.cmpT(r0, r3);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.cmpT(r0, r3);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r3 = CPU.movT(0, 0x81);
                r4 = CPU.movT(0, 0x80);
                r3 = CPU.lslT(r3, 4);
                r4 = CPU.lslT(r4, 8);
                r0 = CPU.cmpT(r0, r3);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.cmpT(r0, r3);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r3 = CPU.subT(r3, 0x8);
                    r4 = CPU.movT(0, 0x0);
                    r0 = CPU.cmpT(r0, r3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r4 = CPU.movT(0, 0x0);
                    }
                  } else {
                    //LAB_800bd12
                    r1 = MEMORY.ref(4, 0x800bdb0).get();
                    r4 = CPU.movT(0, 0x80);
                    r4 = CPU.lslT(r4, 7);
                    r0 = CPU.cmpT(r0, r1);
                    if(!CPU.cpsr().getZero()) { // !=
                      r2 = MEMORY.ref(4, 0x800bdb4).get();
                      r4 = CPU.movT(0, 0x80);
                      r4 = CPU.lslT(r4, 23);
                      r0 = CPU.cmpT(r0, r2);
                      if(!CPU.cpsr().getZero()) { // !=
                        r4 = CPU.movT(0, 0x0);
                      }
                    }
                  }
                }
              } else {
                //LAB_800bd28
                r3 = CPU.movT(0, 0x81);
                r3 = CPU.lslT(r3, 6);
                r4 = MEMORY.ref(4, 0x800bdb8).get();
                r0 = CPU.cmpT(r0, r3);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = CPU.cmpT(r0, r3);
                  if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                    r3 = CPU.subT(r3, 0x30);
                    r4 = MEMORY.ref(4, 0x800bdbc).get();
                    r0 = CPU.cmpT(r0, r3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r1 = MEMORY.ref(4, 0x800bdc0).get();
                      r4 = CPU.movT(0, 0x80);
                      r4 = CPU.lslT(r4, 24);
                      r0 = CPU.cmpT(r0, r1);
                      if(!CPU.cpsr().getZero()) { // !=
                        r4 = CPU.movT(0, 0x0);
                      }
                    }
                  } else {
                    //LAB_800bd4a
                    r2 = MEMORY.ref(4, 0x800bdc4).get();
                    r4 = MEMORY.ref(4, 0x800bdc8).get();
                    r0 = CPU.cmpT(r0, r2);
                    if(!CPU.cpsr().getZero()) { // !=
                      r3 = MEMORY.ref(4, 0x800bdcc).get();
                      r4 = CPU.movT(0, 0xc0);
                      r4 = CPU.lslT(r4, 24);
                      r0 = CPU.cmpT(r0, r3);
                      if(!CPU.cpsr().getZero()) { // !=
                        r4 = CPU.movT(0, 0x0);
                      }
                    }
                  }
                }
              }
            }

            //LAB_800bd5e
            r2 = CPU.r8().value;
            r1 = CPU.movT(0, 0x0);
            r3 = CPU.movT(0, 0x80);
            MEMORY.ref(4, r2).setu(r1);
            r2 += 0x4;

            r3 = CPU.lslT(r3, 6);
            r4 = CPU.orrT(r4, r3);
            r0 = CPU.movT(0, 0x80);
            MEMORY.ref(4, r2).setu(r4);
            r2 += 0x4;

            r0 = CPU.lslT(r0, 4);
            r3 = CPU.r12().value;
            r3 = CPU.orrT(r3, r0);
            MEMORY.ref(4, r2).setu(r3);
            r2 += 0x4;

            r3 = CPU.movT(0, 0xc0);
            MEMORY.ref(4, r2).setu(r1);
            r2 += 0x4;

            r3 = CPU.lslT(r3, 7);
            MEMORY.ref(4, r2).setu(r3);
            r2 += 0x4;

            r1 = CPU.movT(0, 0xbb);
            r3 = MEMORY.ref(4, 0x800bdd0).get();
            r1 = CPU.lslT(r1, 1);
            r3 = CPU.addT(r3, r1);
            r3 = MEMORY.ref(2, r3).getUnsigned();
            r3 = CPU.lsrT(r3, 5);
            r3 = CPU.orrT(r3, r0);
            MEMORY.ref(4, r2).setu(r3);
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.r10().value;
            FUN_800b8ac(r0, r1);
            r2 = CPU.movT(0, 0x1);
            r2 = CPU.negT(r2, r2);
            r0 = CPU.r8().value;
          }
        }
      }
    }

    //LAB_800bd9c
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;

    return r0;
  }

  @Method(0x800c004)
  public static void FUN_800c004(final int r0) {
    final int r8 = FUN_80048f4(0x6, 0x5c);
    final int r6 = FUN_80048f4(0x5, 0x1c00);
    FUN_800bb20(r0);

    CPU.sp().value -= 0x4;

    final int r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r6);
    DMA.channels[3].CNT.setu(0x85000700);

    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r8);
    DMA.channels[3].CNT.setu(0x85000017);

    CPU.sp().value += 0x4;

    CPU.cmpT(r0, 0x4);
    if(CPU.cpsr().getZero()) { // ==
      FUN_80041d8(0x800d341, 0xc8a);
    } else {
      //LAB_800c056
      FUN_80041d8(0x800cacd, 0xc8a);
    }

    //LAB_800c05e
    CPU.cmpT(r0 - 3, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      FUN_80041d8(0x800c881, 0xc80);
    } else {
      //LAB_800c070
      FUN_80041d8(0x800c62d, 0xc80);
      MEMORY.ref(4, 0x3001d1c).setu(0);
      MEMORY.ref(4, 0x3001cc0).setu(0);
    }

    //LAB_800c084
    MEMORY.ref(1, r8 + 0x6).setu(0xf);
    MEMORY.ref(1, r8 + 0x7).setu(0);
  }

  @Method(0x800c0cc)
  public static int FUN_800c0cc() {
    int r2 = MEMORY.ref(4, 0x3001e64).get();
    int r1 = 0;

    //LAB_800c0da
    //LAB_800c0e4
    while(MEMORY.ref(4, r2).get() != 0) {
      r1++;
      r2 += 0x70;
      if(r1 > 0x3f) {
        return 0;
      }
    }

    //LAB_800c0ea
    return r2;
  }

  @Method(0x800c150)
  public static int FUN_800c150(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x8;
    r7 = CPU.addT(r0, 0x0);
    CPU.r11().value = r3;
    CPU.r9().value = r1;
    MEMORY.ref(4, CPU.sp().value).setu(r2);
    r0 = FUN_800c0cc(); //TODO does nothing but return a value? Why?
    r3 = CPU.addT(r7, 0x0);
    CPU.cmpT(r7, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = MEMORY.ref(4, 0x800c1c8).get();
      r3 = CPU.addT(r7, r2);
    }

    //LAB_800c176
    r5 = CPU.asrT(r3, 12);
    r3 = MEMORY.ref(4, 0x800c1c8).get();
    r7 = CPU.andT(r7, r3);
    r0 = FUN_800c0cc();
    r6 = CPU.addT(r0, 0x0);
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_800c188
      r3 = CPU.movT(0, 0x10);
      MEMORY.ref(2, r6 + 0x20).setu(r3);
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_800c196
        r0 = CPU.addT(r7, 0x0);
        r0 = FUN_800bc70(r0);
        r5 = CPU.addT(r0, 0x0);
        CPU.cmpT(r5, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = CPU.addT(r6, 0x0);
          r3 = CPU.movT(0, 0x1);
          r2 = CPU.addT(r2, 0x54);
          MEMORY.ref(1, r2).setu(r3);
          r0 = CPU.addT(r7, 0x0);
          MEMORY.ref(4, r6 + 0x50).setu(r5);
          r0 = FUN_8185000(r0);
          r3 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
          r3 = CPU.lsrT(r3, 1);
          MEMORY.ref(2, r6 + 0x20).setu(r3);
        } else {
          //LAB_800c1ba
          r2 = CPU.addT(r6, 0x0);
          r3 = MEMORY.ref(4, 0x800c1c4).get();
          r2 = CPU.addT(r2, 0x54);
          MEMORY.ref(1, r2).setu(r3);
        }
      } else {
        CPU.cmpT(r5, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_800c1cc
          r3 = MEMORY.ref(4, 0x800c290).get();
          r1 = MEMORY.ref(4, r3).get();
          r0 = CPU.addT(r1, 0x0);
          r0 = CPU.addT(r0, 0x18);
          r3 = MEMORY.ref(4, r0).get();
          r2 = CPU.lslT(r3, 2);
          r1 = CPU.addT(r1, r2);
          r3 = CPU.addT(r3, 0x1);
          MEMORY.ref(4, r0).setu(r3);
          CPU.r10().value = r1;
          r3 = CPU.addT(r6, 0x0);
          r4 = CPU.movT(0, 0x8);
          r4 += CPU.r10().value;
          r3 = CPU.addT(r3, 0x54);
          MEMORY.ref(1, r3).setu(r5);
          CPU.r8().value = r4;
          r0 = CPU.sp().value + 0x4;
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r0).setu(r3);
          MEMORY.ref(4, r6 + 0x50).setu(r4);
          r3 = MEMORY.ref(4, 0x800c294).get();
          r1 = CPU.r8().value;
          r2 = MEMORY.ref(4, 0x800c298).get();
          MEMORY.ref(4, r3).setu(r0);
          r3 += 0x4;
          MEMORY.ref(4, r3).setu(r1);
          r3 += 0x4;
          MEMORY.ref(4, r3).setu(r2);

          r0 = CPU.addT(r7, 0x0);
          r0 = FUN_800bc70(r0);
          r5 = CPU.addT(r0, 0x0);
          CPU.cmpT(r5, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r7, 0x0);
            r0 = FUN_8185000(r0);
            r3 = MEMORY.ref(1, r0 + 0x9).getUnsigned();
            r3 = CPU.lsrT(r3, 1);
            r2 = CPU.r8().value;
            MEMORY.ref(2, r6 + 0x20).setu(r3);
            r3 = CPU.movT(0, 0xc);
            r3 += CPU.r10().value;
            MEMORY.ref(4, r2).setu(r5);
            CPU.r8().value = r3;
          }

          //LAB_800c220
          r0 = CPU.addT(r7, 0x1);
          r0 = FUN_800bc70(r0);
          r5 = CPU.addT(r0, 0x0);
          CPU.cmpT(r5, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r4 = CPU.r8().value;
            MEMORY.ref(4, r4).setu(r5);
          }
        }
      }

      //LAB_800c230
      CPU.cmpT(r6, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.addT(r6, 0x0);
        r1 = CPU.r9().value;
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = CPU.r11().value;
        FUN_800d130(r0, r1, r2, r3);
        r3 = MEMORY.ref(4, 0x800c29c).get();
        MEMORY.ref(4, r6).setu(r3);
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 10);
        MEMORY.ref(4, r6 + 0x30).setu(r3);
        r3 = CPU.movT(0, 0x55);
        r3 = CPU.addT(r3, r6);
        CPU.r12().value = r3;
        r2 = CPU.movT(0, 0x80);
        r2 = CPU.lslT(r2, 9);
        r1 = CPU.movT(0, 0x0);
        r3 = CPU.movT(0, 0x3);
        r4 = CPU.r12().value;
        MEMORY.ref(2, r6 + 0x4).setu(r1);
        MEMORY.ref(4, r6 + 0x18).setu(r2);
        MEMORY.ref(4, r6 + 0x1c).setu(r2);
        MEMORY.ref(4, r6 + 0x34).setu(r2);
        r0 = MEMORY.ref(4, 0x800c28c).get();
        MEMORY.ref(1, r4).setu(r3);
        MEMORY.ref(4, r6 + 0x48).setu(r2);
        r3 = CPU.addT(r6, 0x0);
        r2 = CPU.movT(0, 0x80);
        r2 = CPU.lslT(r2, 7);
        r3 = CPU.addT(r3, 0x59);
        MEMORY.ref(4, r6 + 0x44).setu(r2);
        MEMORY.ref(1, r3).setu(r0);
        r0 = CPU.addT(r6, 0x0);
        r0 = CPU.addT(r0, 0x5a);
        r3 = CPU.movT(0, 0x1);
        MEMORY.ref(1, r0).setu(r3);
        MEMORY.ref(4, r6 + 0x4c).setu(r1);
        r1 = CPU.r9().value;
        MEMORY.ref(2, r6 + 0x6).setu(r2);
        CPU.cmpT(r1, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x800c2a0).get();
          r1 = CPU.addT(r1, r2);
        }

        //LAB_800c2a4
        r3 = CPU.addT(r6, 0x0);
        r3 = CPU.addT(r3, 0x64);
        r2 = CPU.asrT(r1, 16);
        MEMORY.ref(2, r3).setu(r2);
        r3 = CPU.r11().value;
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r4 = MEMORY.ref(4, 0x800c2d4).get();
          r3 = CPU.addT(r3, r4);
        }

        //LAB_800c2b6
        r2 = CPU.addT(r6, 0x0);
        r3 = CPU.asrT(r3, 16);
        r2 = CPU.addT(r2, 0x66);
        MEMORY.ref(2, r2).setu(r3);
      }
    }

    //LAB_800c2be
    r0 = CPU.addT(r6, 0x0);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;

    return r0;
  }

  @Method(0x800c2d8)
  public static void FUN_800c2d8(final int r0, final int r1) {
    int r2;
    final int r3;

    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r0 + 0x4).setu(r2);
      r3 = MEMORY.ref(4, 0x800c2f8).get();
      r2 = CPU.addT(r0, 0x0);
      r2 = CPU.addT(r2, 0x5b);
      MEMORY.ref(4, r0).setu(r1);
      MEMORY.ref(1, r2).setu(r3);
      r2 = CPU.addT(r2, 0x2);
      MEMORY.ref(1, r2).setu(r3);
      r2 = CPU.subT(r2, 0x6);
      MEMORY.ref(1, r2).setu(r3);
    }

    //LAB_800c2fc
  }

  @Method(0x800c300)
  public static void FUN_800c300(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;
    final int r7;

    r7 = CPU.addT(r1, 0x0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.addT(r3, 0x54);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r2 = CPU.movT(0, 0xf);
      r2 = CPU.andT(r2, r3);
      CPU.cmpT(r2, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_800c31c
        r0 = MEMORY.ref(4, r0 + 0x50).get();
        r1 = CPU.addT(r7, 0x0);
        r0 = FUN_800ba30(r0, r1);
      } else {
        CPU.cmpT(r2, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_800c326
          r5 = MEMORY.ref(4, r0 + 0x50).get();
          r6 = CPU.movT(0, 0x3);

          //LAB_800c32a
          do {
            r0 = MEMORY.ref(4, r5).get();
            r5 += 0x4;

            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = CPU.addT(r7, 0x0);
              r0 = FUN_800ba30(r0, r1);
            }

            //LAB_800c336
            r6 = CPU.subT(r6, 0x1);
            CPU.cmpT(r6, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
        }
      }
    }

    //LAB_800c33c
  }

  @Method(0x800c4bc)
  public static void FUN_800c4bc(final int r0, int r1) {
    int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, 0x800c4e8).get();
    r5 = CPU.addT(r0, 0x0);
    FUN_800c2d8(r0, r1);
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 8);
      MEMORY.ref(4, r5 + 0x34).setu(r3);
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 11);
      r2 = CPU.addT(r5, 0x0);
      MEMORY.ref(4, r5 + 0x30).setu(r3);
      r2 = CPU.addT(r2, 0x64);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r5 + 0x68).setu(r6);
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_800c4e2
  }

  @Method(0x800c62c)
  public static void FUN_800c62c() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r6 = MEMORY.ref(4, 0x800c850).get();
    r0 = MEMORY.ref(4, r6).get();
    CPU.sp().value -= 0x50;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    r2 = CPU.addT(r0, 0x0);
    r2 = CPU.addT(r2, 0xe4);
    r1 = MEMORY.ref(4, r2).get();
    r3 = MEMORY.ref(4, 0x800c854).get();
    r1 = CPU.andT(r1, r3);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    r2 = MEMORY.ref(4, r2 + 0x4).get();
    r2 = CPU.andT(r2, r3);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
    r3 = CPU.addT(r6, 0x0);
    r3 = CPU.subT(r3, 0x8);
    r3 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r5 = MEMORY.ref(4, 0x800c858).get();
    r0 = CPU.movT(0, 0x34);
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_80048b0(r0, r1);
    r2 = CPU.movT(0, 0x84);
    r5 = CPU.lsrT(r5, 2);
    r2 = CPU.lslT(r2, 24);
    r1 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(4, 0x800c85c).get();
    r0 = MEMORY.ref(4, 0x800c860).get();
    r2 = CPU.orrT(r2, r5);
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;

    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.movT(0, 0x0);
    r6 = CPU.subT(r6, 0xc);
    r6 = MEMORY.ref(4, r6).get();
    r2 = MEMORY.ref(4, CPU.sp().value).get();
    CPU.r10().value = r6;
    MEMORY.ref(2, r2).setu(r3);
    r4 = CPU.movT(0, 0x3f);
    r3 = MEMORY.ref(4, 0x800c864).get();
    r0 = CPU.movT(0, 0x54);
    r0 += CPU.r10().value;
    r7 = CPU.r10().value;
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
    CPU.r11().value = r3;
    CPU.r8().value = r0;
    r7 = CPU.addT(r7, 0x8);

    //LAB_800c696
    do {
      r1 = CPU.r10().value;
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);

      jmp_800c822:
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_800c6a0
        r1 = MEMORY.ref(4, r7).get();
        if(r1 != 0 || MEMORY.ref(4, r7 + 0x8).get() != 0) {
          //LAB_800c6ae
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(1, r2).getUnsigned();
          r6 = CPU.movT(0, 0xf);
          r6 = CPU.andT(r6, r3);
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            break jmp_800c822;
          }

          //LAB_800c6bc
          CPU.cmpT(r6, 0x1);
          if(!CPU.cpsr().getZero()) { // !=
            break jmp_800c822;
          }

          //LAB_800c6c2
          r0 = MEMORY.ref(4, CPU.sp().value).get();
          r4 = CPU.movT(0, 0x4);
          r3 = MEMORY.ref(2, r0 + r4).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(1, r2 + 0x8).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r5 = MEMORY.ref(4, r7 + 0x48).get();
              r0 = MEMORY.ref(1, r5 + 0x1c).getUnsigned();
              r5 = CPU.addT(r5, 0x25);
              r0 = FUN_8003f78(r0);
              MEMORY.ref(1, r5).setu(r6);
              break jmp_800c822;
            }
          }

          //LAB_800c6e0
          r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r0 = MEMORY.ref(4, r7 + 0x8).get();
          r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r6 = CPU.subT(r0, r3);
          r3 = MEMORY.ref(4, r7 + 0x4).get();
          r2 = CPU.subT(r1, r2);
          CPU.r9().value = r2;
          r2 = CPU.subT(r6, r3);
          r3 = MEMORY.ref(4, 0x800c868).get();
          r4 = MEMORY.ref(4, 0x800c86c).get();
          r3 += CPU.r9().value;
          r5 = MEMORY.ref(4, r7 + 0x48).get();
          r3 = CPU.cmpT(r3, r4);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_800c6fe
            r3 = MEMORY.ref(4, 0x800c870).get();
            r2 = CPU.cmpT(r2, r3);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r4 = MEMORY.ref(4, 0x800c874).get();
              r2 = CPU.cmpT(r2, r4);
              if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                r3 = MEMORY.ref(1, r7 + 0x1a).getUnsigned();
                r2 = CPU.movT(0, 0x22);
                r2 += CPU.r10().value;
                CPU.r12().value = r2;
                r2 = CPU.lslT(r3, 1);
                r2 = CPU.addT(r2, r3);
                r3 = CPU.movT(0, 0x98);
                r3 = CPU.lslT(r3, 1);
                r2 = CPU.lslT(r2, 4);
                r2 = CPU.addT(r2, r3);
                r4 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
                r3 = CPU.asrT(r0, 20);
                r3 = CPU.lslT(r3, 7);
                r1 = CPU.asrT(r1, 20);
                r1 = CPU.addT(r1, r3);
                r3 = MEMORY.ref(4, r4 + r2).get();
                r1 = CPU.lslT(r1, 2);
                r2 = MEMORY.ref(1, r7 + 0x1b).getUnsigned();
                r1 = CPU.addT(r3, r1);
                r0 = CPU.movT(0, 0x23);
                r3 = CPU.movT(0, 0x1);
                r0 += CPU.r10().value;
                r3 = CPU.andT(r3, r2);
                CPU.lr().value = r0;
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r4 = MEMORY.ref(4, r1).get();
                  r3 = CPU.lslT(r4, 16);
                  r0 = CPU.lsrT(r3, 30);
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r2 = CPU.movT(0, 0xd);
                    r1 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
                    r2 = CPU.negT(r2, r2);
                    r3 = CPU.addT(r2, 0x0);
                    r0 = CPU.lslT(r0, 2);
                    r3 = CPU.andT(r3, r1);
                    r3 = CPU.orrT(r3, r0);
                    MEMORY.ref(1, r5 + 0x9).setu(r3);
                    r3 = MEMORY.ref(1, r5 + 0x15).getUnsigned();
                    r2 = CPU.andT(r2, r3);
                    r2 = CPU.orrT(r2, r0);
                    MEMORY.ref(1, r5 + 0x15).setu(r2);
                  }
                } else {
                  //LAB_800c762
                  r4 = MEMORY.ref(4, r1).get();
                }

                //LAB_800c764
                r3 = CPU.lslT(r4, 18);
                r1 = CPU.lsrT(r3, 30);
                CPU.cmpT(r1, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = CPU.addT(r1, 0x0);
                  r3 = CPU.addT(r3, 0xff);
                  r1 = CPU.r12().value;
                  MEMORY.ref(1, r1).setu(r3);
                }

                //LAB_800c774
                r0 = MEMORY.ref(4, r7 + 0x10).get();
                r1 = MEMORY.ref(4, r5 + 0x18).get();
                CPU.r12().value = 0x800c77c;
                MEMORY.call(CPU.r11().value);
                MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
                r0 = MEMORY.ref(4, r7 + 0x14).get();
                r1 = MEMORY.ref(4, r5 + 0x18).get();
                r0 = CPU.lslT(r0, 0);
                CPU.r12().value = 0x800c788;
                MEMORY.call(CPU.r11().value);
                r2 = CPU.movT(0, 0x14);
                r1 = CPU.sp().value + 0x1c;
                r2 += CPU.sp().value;
                r3 = CPU.r9().value;
                MEMORY.ref(4, r2 + 0x4).setu(r0);
                MEMORY.ref(4, r1).setu(r3);
                CPU.r12().value = r2;
                r2 = MEMORY.ref(4, r7 + 0x4).get();
                MEMORY.ref(4, r1 + 0x8).setu(r6);
                MEMORY.ref(4, r1 + 0x4).setu(r2);
                r4 = MEMORY.ref(4, r7 + 0xc).get();
                MEMORY.ref(4, r1 + 0xc).setu(r4);
                r3 = CPU.lr().value;
                r0 = MEMORY.ref(1, r3).getUnsigned();
                r3 = CPU.movT(0, 0x2);
                r3 = CPU.andT(r3, r0);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = MEMORY.ref(4, 0x800c878).get();
                  r2 = CPU.addT(r2, r3);
                  MEMORY.ref(4, r1 + 0x4).setu(r2);
                  r2 = CPU.addT(r6, r3);
                  r3 = CPU.addT(r4, r3);
                  MEMORY.ref(4, r1 + 0x8).setu(r2);
                  MEMORY.ref(4, r1 + 0xc).setu(r3);
                  r4 = CPU.lr().value;
                  r0 = MEMORY.ref(1, r4).getUnsigned();
                }

                //LAB_800c7be
                r3 = CPU.movT(0, 0x4);
                r3 = CPU.andT(r3, r0);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r3 = MEMORY.ref(4, r1 + 0x4).get();
                  r2 = CPU.movT(0, 0xa0);
                  r2 = CPU.lslT(r2, 17);
                  r3 = CPU.addT(r3, r2);
                  MEMORY.ref(4, r1 + 0x4).setu(r3);
                  r3 = MEMORY.ref(4, r1 + 0x8).get();
                  r3 = CPU.addT(r3, r2);
                  MEMORY.ref(4, r1 + 0x8).setu(r3);
                  r3 = MEMORY.ref(4, r1 + 0xc).get();
                  r3 = CPU.addT(r3, r2);
                  MEMORY.ref(4, r1 + 0xc).setu(r3);
                }

                //LAB_800c7dc
                r0 = CPU.r10().value;
                r3 = MEMORY.ref(2, r0 + 0x6).getUnsigned();
                r2 = CPU.r12().value;
                r0 = CPU.addT(r5, 0x0);
                FUN_800b168(r0, r1, r2, r3);
                break jmp_800c822;
              }
            }
          }

          //LAB_800c7ea
          r1 = CPU.r8().value;
          r3 = MEMORY.ref(1, r1 + 0x8).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            break jmp_800c822;
          }
          r2 = MEMORY.ref(1, r5 + 0x1d).getUnsigned();
          r6 = CPU.movT(0, 0x1);
        } else {
          //LAB_800c7f8
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(1, r2).getUnsigned();
          r6 = CPU.movT(0, 0xf);
          r6 = CPU.andT(r6, r3);
          CPU.cmpT(r6, 0x1);
          if(!CPU.cpsr().getZero()) { // !=
            break jmp_800c822;
          }
          r3 = MEMORY.ref(1, r2 + 0x8).getUnsigned();
          r5 = MEMORY.ref(4, r7 + 0x48).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            break jmp_800c822;
          }
          r2 = MEMORY.ref(1, r5 + 0x1d).getUnsigned();
        }

        //LAB_800c80e
        r3 = CPU.addT(r6, 0x0);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = MEMORY.ref(1, r5 + 0x1c).getUnsigned();
          r0 = FUN_8003f78(r0);
          r3 = CPU.addT(r5, 0x0);
          r3 = CPU.addT(r3, 0x25);
          MEMORY.ref(1, r3).setu(r6);
        }
      }

      //LAB_800c822
      r3 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r4 = CPU.movT(0, 0x70);
      r3 = CPU.subT(r3, 0x1);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(r3);
      CPU.r8().value += r4;
      r7 = CPU.addT(r7, 0x70);
      CPU.r10().value += r4;
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        break;
      }
    } while(true);

    //LAB_800c836
    r0 = CPU.movT(0, 0x34);
    FUN_8002dd8(r0);
    CPU.sp().value += 0x50;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x800cacc)
  public static void FUN_800cacc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r3 = MEMORY.ref(4, 0x800cd80).get();
    r6 = MEMORY.ref(4, r3).get();
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.addT(r6, 0x0);
    CPU.sp().value -= 0x30;
    r0 = CPU.movT(0, 0x3f);
    r1 = CPU.addT(r1, 0x55);
    r2 = CPU.addT(r2, 0x56);
    MEMORY.ref(4, CPU.sp().value + 0x20).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
    MEMORY.ref(4, CPU.sp().value).setu(r2);

    //LAB_800caf0
    do {
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
      r2 = MEMORY.ref(4, r6).get();
      CPU.cmpT(r2, 0x0);

      jmp_800d0fe:
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_800cafc
        r3 = MEMORY.ref(4, r6 + 0x6c).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r6, 0x0);
          MEMORY.call(r3, r0);
          r2 = MEMORY.ref(4, r6).get();
        }

        //LAB_800cb0a
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_800cb10
          r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = MEMORY.ref(1, r4 + 0x6).getUnsigned();
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_800cb1a
            r0 = MEMORY.ref(4, CPU.sp().value).get();
            r4 = CPU.movT(0, 0x8);
            r3 = MEMORY.ref(2, r0 + r4).get();
            r1 = MEMORY.ref(2, r0 + 0x8).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.subT(r1, 0x1);
              MEMORY.ref(2, r0 + 0x8).setu(r3);
            } else {
              //LAB_800cb2c
              r5 = MEMORY.ref(4, 0x800cd84).get();

              //LAB_800cb36
              do {
                r4 = CPU.movT(0, 0x4);
                r3 = MEMORY.ref(2, r6 + r4).get();
                r3 = CPU.lslT(r3, 2);
                r3 = MEMORY.ref(4, r2 + r3).get();
                r1 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
                CPU.cmpT(r3, 0x3f);
                if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                  r3 = CPU.addT(r1, 0x1);
                  MEMORY.ref(2, r6 + 0x4).setu(r3);
                  r2 = MEMORY.ref(4, r6).get();
                  continue;
                }
                r3 = CPU.lslT(r3, 2);
                r3 = MEMORY.ref(4, r5 + r3).get();
                r0 = CPU.addT(r6, 0x0);
                r0 = (int)MEMORY.call(r3, r0);
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r2 = MEMORY.ref(4, r6).get();
                  continue;
                }

                break;
              } while(true);
              r3 = MEMORY.ref(4, r6).get();
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                break jmp_800d0fe;
              }
            }

            //LAB_800cb5a
            r0 = MEMORY.ref(4, r6 + 0x8).get();
            MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
            r1 = MEMORY.ref(4, r6 + 0xc).get();
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
            r2 = MEMORY.ref(4, r6 + 0x10).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
            r3 = MEMORY.ref(1, r4 + 0xc).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_800cb70
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              r3 = MEMORY.ref(1, r4).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_800cb7a
                r0 = CPU.movT(0, 0x80);
                r3 = MEMORY.ref(4, r6 + 0x38).get();
                r0 = CPU.lslT(r0, 24);
                r3 = CPU.cmpT(r3, r0);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_800cb86
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r0 = CPU.subT(r3, r1);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r2 = MEMORY.ref(4, 0x800cd88).get();
                    r0 = CPU.addT(r0, r2);
                  }

                  //LAB_800cb92
                  r3 = MEMORY.ref(4, r6 + 0x3c).get();
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  r0 = CPU.asrT(r0, 16);
                  CPU.r8().value = r0;
                  r0 = CPU.subT(r3, r4);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r1 = MEMORY.ref(4, 0x800cd88).get();
                    r0 = CPU.addT(r0, r1);
                  }

                  //LAB_800cba4
                  r3 = MEMORY.ref(4, r6 + 0x40).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  r0 = CPU.asrT(r0, 16);
                  CPU.r11().value = r0;
                  r0 = CPU.subT(r3, r2);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r3 = MEMORY.ref(4, 0x800cd88).get();
                    r0 = CPU.addT(r0, r3);
                  }

                  //LAB_800cbb6
                  r0 = CPU.asrT(r0, 16);
                  CPU.r9().value = r0;
                  r4 = CPU.r8().value;
                  r1 = CPU.r11().value;
                  r0 = CPU.r8().value;
                  r0 = CPU.mulT(r0, r4);
                  r3 = CPU.r11().value;
                  r3 = CPU.mulT(r3, r1);
                  r4 = CPU.r9().value;
                  r2 = CPU.r9().value;
                  r2 = CPU.mulT(r2, r4);
                  r0 = CPU.addT(r0, r3);
                  r0 = CPU.addT(r0, r2);
                  r3 = MEMORY.ref(4, 0x800cd8c).get();
                  r0 = (int)MEMORY.call(r3, r0);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = MEMORY.ref(4, r6 + 0x38).get();
                    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
                    r1 = MEMORY.ref(4, r6 + 0x3c).get();
                    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
                    r2 = MEMORY.ref(4, r6 + 0x40).get();
                    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
                  } else {
                    //LAB_800cbe8
                    r1 = MEMORY.ref(4, r6 + 0x34).get();
                    r3 = MEMORY.ref(4, 0x800cd90).get();
                    r0 = CPU.lslT(r0, 16);
                    r0 = (int)MEMORY.call(r3, r0, r1);
                    r5 = CPU.addT(r0, 0x0);
                    r3 = CPU.r8().value;
                    r3 = CPU.mulT(r3, r5);
                    r0 = MEMORY.ref(4, r6 + 0x24).get();
                    r0 = CPU.addT(r0, r3);
                    r3 = CPU.r11().value;
                    r3 = CPU.mulT(r3, r5);
                    r2 = CPU.r9().value;
                    r2 = CPU.mulT(r2, r5);
                    r1 = MEMORY.ref(4, r6 + 0x28).get();
                    r1 = CPU.addT(r1, r3);
                    r3 = MEMORY.ref(4, r6 + 0x2c).get();
                    r4 = MEMORY.ref(4, 0x800cd94).get();
                    r3 = CPU.addT(r3, r2);
                    CPU.r10().value = r0;
                    MEMORY.ref(4, r6 + 0x28).setu(r1);
                    r7 = CPU.addT(r1, 0x0);
                    MEMORY.ref(4, r6 + 0x24).setu(r0);
                    MEMORY.ref(4, r6 + 0x2c).setu(r3);
                    CPU.r9().value = r3;
                    CPU.r8().value = r4;
                    r1 = CPU.r10().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cc24;
                    r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                    r3 = CPU.addT(r0, 0x0);
                    r1 = CPU.addT(r7, 0x0);
                    r0 = CPU.addT(r7, 0x0);
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cc30;
                    r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                    r4 = CPU.addT(r0, 0x0);
                    r1 = CPU.r9().value;
                    r0 = CPU.r9().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cc3c;
                    r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                    r3 = CPU.addT(r3, r4);
                    r3 = CPU.addT(r3, r0);
                    r0 = CPU.addT(r3, 0x0);
                    r0 = FUN_80045d4(r0);
                    r1 = MEMORY.ref(4, r6 + 0x30).get();
                    r0 = CPU.cmpT(r0, r1);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      //LAB_800cc4e
                      r2 = MEMORY.ref(4, 0x800cd90).get();
                      r0 = (int)MEMORY.call(r2);
                      r5 = CPU.addT(r0, 0x0);
                      r1 = CPU.addT(r5, 0x0);
                      r0 = CPU.r10().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cc60;
                      r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                      MEMORY.ref(4, r6 + 0x24).setu(r0);
                      r1 = CPU.addT(r5, 0x0);
                      r0 = CPU.addT(r7, 0x0);
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cc6c;
                      r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                      MEMORY.ref(4, r6 + 0x28).setu(r0);
                      r1 = CPU.addT(r5, 0x0);
                      r0 = CPU.r9().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cc78;
                      r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                      MEMORY.ref(4, r6 + 0x2c).setu(r0);
                    }
                  }
                } else {
                  //LAB_800cc7c
                  r3 = MEMORY.ref(4, r6 + 0x24).get();
                  r0 = MEMORY.ref(4, r6 + 0x2c).get();
                  r4 = MEMORY.ref(4, r6 + 0x28).get();
                  CPU.r8().value = r3;
                  CPU.r9().value = r0;
                  CPU.r11().value = r4;
                  r7 = MEMORY.ref(4, 0x800cd94).get();
                  r0 = CPU.r8().value;
                  r1 = CPU.r8().value;
                  r0 = CPU.lslT(r0, 0);
                  CPU.r12().value = 0x800cc94;
                  r0 = (int)MEMORY.call(r7, r0, r1);
                  r3 = CPU.addT(r0, 0x0);
                  r1 = CPU.r11().value;
                  r0 = CPU.r11().value;
                  r0 = CPU.lslT(r0, 0);
                  CPU.r12().value = 0x800cca0;
                  r0 = (int)MEMORY.call(r7, r0, r1);
                  r4 = CPU.addT(r0, 0x0);
                  r1 = CPU.r9().value;
                  r0 = CPU.r9().value;
                  r0 = CPU.lslT(r0, 0);
                  CPU.r12().value = 0x800ccac;
                  r0 = (int)MEMORY.call(r7, r0, r1);
                  r3 = CPU.addT(r3, r4);
                  r3 = CPU.addT(r3, r0);
                  r0 = CPU.addT(r3, 0x0);
                  r0 = FUN_80045d4(r0);
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r3 = MEMORY.ref(4, r6 + 0x34).get();
                    r1 = CPU.subT(r0, r3);
                    CPU.cmpT(r1, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r1 = CPU.movT(0, 0x0);
                    }

                    //LAB_800ccc4
                    r3 = MEMORY.ref(4, 0x800cd90).get();
                    r0 = (int)MEMORY.call(r3, r0, r1);
                    r5 = CPU.addT(r0, 0x0);
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.r8().value;
                    CPU.r12().value = 0x800ccd4;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    MEMORY.ref(4, r6 + 0x24).setu(r0);
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.r11().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cce0;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    MEMORY.ref(4, r6 + 0x28).setu(r0);
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.r9().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800ccec;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    MEMORY.ref(4, r6 + 0x2c).setu(r0);
                  } else {
                    //LAB_800ccf0
                    MEMORY.ref(4, r6 + 0x24).setu(r0);
                    MEMORY.ref(4, r6 + 0x28).setu(r0);
                    MEMORY.ref(4, r6 + 0x2c).setu(r0);
                  }
                }
              } else {
                //LAB_800ccf8
                r1 = CPU.movT(0, 0x80);
                r3 = MEMORY.ref(4, r6 + 0x38).get();
                r1 = CPU.lslT(r1, 24);
                r3 = CPU.cmpT(r3, r1);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_800cd04
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r0 = CPU.subT(r3, r2);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r3 = MEMORY.ref(4, 0x800cd88).get();
                    r0 = CPU.addT(r0, r3);
                  }

                  //LAB_800cd10
                  r3 = MEMORY.ref(4, r6 + 0x40).get();
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  r0 = CPU.asrT(r0, 16);
                  CPU.r8().value = r0;
                  r0 = CPU.subT(r3, r4);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r1 = MEMORY.ref(4, 0x800cd88).get();
                    r0 = CPU.addT(r0, r1);
                  }

                  //LAB_800cd22
                  r0 = CPU.asrT(r0, 16);
                  CPU.r9().value = r0;
                  r2 = CPU.r8().value;
                  r4 = CPU.r9().value;
                  r3 = CPU.r9().value;
                  r3 = CPU.mulT(r3, r4);
                  r0 = CPU.r8().value;
                  r0 = CPU.mulT(r0, r2);
                  r0 = CPU.addT(r0, r3);
                  r3 = MEMORY.ref(4, 0x800cd8c).get();
                  r0 = (int)MEMORY.call(r3, r0);
                  r1 = MEMORY.ref(4, 0x800cd98).get();
                  r0 = CPU.lslT(r0, 16);
                  r0 = CPU.cmpT(r0, r1);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r3 = MEMORY.ref(4, r6 + 0x38).get();
                    r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                    r2 = CPU.subT(r3, r2);
                    r3 = MEMORY.ref(4, r6 + 0x40).get();
                    CPU.r8().value = r2;
                    r4 = CPU.subT(r3, r4);
                    CPU.r9().value = r4;
                    r0 = CPU.r8().value;
                    r4 = MEMORY.ref(4, 0x800cd94).get();
                    r1 = CPU.r8().value;
                    CPU.r12().value = 0x800cd5c;
                    r0 = (int)MEMORY.call(r4, r0, r1);
                    r3 = CPU.addT(r0, 0x0);
                    r1 = CPU.r9().value;
                    r0 = CPU.r9().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cd68;
                    r0 = (int)MEMORY.call(r4, r0, r1);
                    r3 = CPU.addT(r3, r0);
                    r0 = CPU.addT(r3, 0x0);
                    r0 = FUN_80045d4(r0);
                  }

                  //LAB_800cd70
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = MEMORY.ref(4, r6 + 0x38).get();
                    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
                    r1 = MEMORY.ref(4, r6 + 0x40).get();
                    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
                  } else {
                    //LAB_800cd9c
                    r2 = MEMORY.ref(4, 0x800d050).get();
                    r1 = MEMORY.ref(4, r6 + 0x34).get();
                    CPU.r11().value = r2;
                    r0 = (int)MEMORY.call(CPU.r11().value, r0, r1);
                    r5 = CPU.addT(r0, 0x0);
                    r7 = MEMORY.ref(4, 0x800d054).get();
                    r0 = CPU.r8().value;
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cdb4;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    r4 = MEMORY.ref(4, r6 + 0x24).get();
                    r4 = CPU.addT(r4, r0);
                    MEMORY.ref(4, r6 + 0x24).setu(r4);
                    r0 = CPU.r9().value;
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cdc4;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    r3 = MEMORY.ref(4, r6 + 0x2c).get();
                    CPU.r10().value = r4;
                    r3 = CPU.addT(r3, r0);
                    MEMORY.ref(4, r6 + 0x2c).setu(r3);
                    CPU.r9().value = r3;
                    r0 = CPU.r10().value;
                    r1 = CPU.r10().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cdd8;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    r3 = CPU.addT(r0, 0x0);
                    r1 = CPU.r9().value;
                    r0 = CPU.r9().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800cde4;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    r3 = CPU.addT(r3, r0);
                    r0 = CPU.addT(r3, 0x0);
                    r0 = FUN_80045d4(r0);
                    r1 = MEMORY.ref(4, r6 + 0x30).get();
                    r0 = CPU.cmpT(r0, r1);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      r0 = (int)MEMORY.call(CPU.r11().value, r0, r1);
                      r5 = CPU.addT(r0, 0x0);
                      r1 = CPU.addT(r5, 0x0);
                      r0 = CPU.r10().value;
                      CPU.r12().value = 0x800ce00;
                      r0 = (int)MEMORY.call(r7, r0, r1);
                      MEMORY.ref(4, r6 + 0x24).setu(r0);
                      r1 = CPU.addT(r5, 0x0);
                      r0 = CPU.r9().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800ce0c;
                      r0 = (int)MEMORY.call(r7, r0, r1);
                      MEMORY.ref(4, r6 + 0x2c).setu(r0);
                    }
                  }
                } else {
                  //LAB_800ce0e
                  r3 = MEMORY.ref(4, r6 + 0x24).get();
                  r4 = MEMORY.ref(4, r6 + 0x2c).get();
                  CPU.r8().value = r3;
                  CPU.r9().value = r4;
                  r7 = MEMORY.ref(4, 0x800d054).get();
                  r0 = CPU.r8().value;
                  r1 = CPU.r8().value;
                  CPU.r12().value = 0x800ce20;
                  r0 = (int)MEMORY.call(r7, r0, r1);
                  r3 = CPU.addT(r0, 0x0);
                  r1 = CPU.r9().value;
                  r0 = CPU.r9().value;
                  r0 = CPU.lslT(r0, 0);
                  CPU.r12().value = 0x800ce2c;
                  r0 = (int)MEMORY.call(r7, r0, r1);
                  r3 = CPU.addT(r3, r0);
                  r0 = CPU.addT(r3, 0x0);
                  r0 = FUN_80045d4(r0);
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r3 = MEMORY.ref(4, r6 + 0x34).get();
                    r1 = CPU.subT(r0, r3);
                    CPU.cmpT(r1, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r1 = CPU.movT(0, 0x0);
                    }

                    //LAB_800ce42
                    r3 = MEMORY.ref(4, 0x800d050).get();
                    r0 = (int)MEMORY.call(r3, r0, r1);
                    r5 = CPU.addT(r0, 0x0);
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.r8().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800ce54;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                    MEMORY.ref(4, r6 + 0x24).setu(r0);
                    r1 = CPU.addT(r5, 0x0);
                    r0 = CPU.r9().value;
                    r0 = CPU.lslT(r0, 0);
                    CPU.r12().value = 0x800ce60;
                    r0 = (int)MEMORY.call(r7, r0, r1);
                  } else {
                    //LAB_800ce62
                    MEMORY.ref(4, r6 + 0x24).setu(r0);
                  }

                  //LAB_800ce64
                  MEMORY.ref(4, r6 + 0x2c).setu(r0);
                }

                //LAB_800ce66
                r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r2 = MEMORY.ref(1, r0).getUnsigned();
                r3 = CPU.movT(0, 0x1);
                r3 = CPU.andT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  //LAB_800ce74
                  r3 = MEMORY.ref(4, r6 + 0x24).get();
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  r1 = CPU.addT(r1, r3);
                  r3 = MEMORY.ref(4, r6 + 0x2c).get();
                  r2 = CPU.addT(r2, r3);
                  r3 = CPU.addT(r6, 0x0);
                  r3 = CPU.addT(r3, 0x22);
                  r0 = MEMORY.ref(1, r3).getUnsigned();
                  CPU.r10().value = r1;
                  CPU.r9().value = r2;
                  r0 = FUN_8011f54(r0, r1, r2);
                  MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
                  r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  r3 = MEMORY.ref(4, r6 + 0x14).get();
                  r7 = CPU.subT(r0, r3);
                  r3 = CPU.subT(r0, r4);
                  r0 = MEMORY.ref(4, 0x800d058).get();
                  r3 = CPU.cmpT(r3, r0);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    r4 = CPU.addT(r4, r7);
                    MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
                  }

                  //LAB_800cea2
                  CPU.cmpT(r7, 0x0);
                  if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                    r7 = CPU.negT(r7, r7);
                  }

                  //LAB_800cea8
                  r3 = MEMORY.ref(4, r6 + 0x34).get();
                  r2 = CPU.lsrT(r3, 31);
                  r3 = CPU.addT(r3, r2);
                  r3 = CPU.asrT(r3, 1);
                  r7 = CPU.cmpT(r7, r3);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    r7 = CPU.addT(r3, 0x0);
                  }

                  //LAB_800ceb6
                  r3 = CPU.lslT(r7, 1);
                  r7 = CPU.addT(r3, r7);
                  CPU.cmpT(r7, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r1 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                    r2 = MEMORY.ref(1, r1).getUnsigned();
                    r3 = CPU.movT(0, 0x10);
                    r3 = CPU.andT(r3, r2);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getZero()) { // ==
                      r2 = MEMORY.ref(4, r6 + 0x24).get();
                      r0 = MEMORY.ref(4, 0x800d054).get();
                      r3 = MEMORY.ref(4, r6 + 0x28).get();
                      r4 = MEMORY.ref(4, r6 + 0x2c).get();
                      CPU.r8().value = r2;
                      CPU.r10().value = r0;
                      CPU.r11().value = r3;
                      CPU.r9().value = r4;
                      r0 = CPU.r8().value;
                      r1 = CPU.r8().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cee4;
                      r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                      r3 = CPU.addT(r0, 0x0);
                      r1 = CPU.r11().value;
                      r0 = CPU.r11().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cef0;
                      r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                      r4 = CPU.addT(r0, 0x0);
                      r1 = CPU.r9().value;
                      r0 = CPU.r9().value;
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cefc;
                      r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                      r3 = CPU.addT(r3, r4);
                      r3 = CPU.addT(r3, r0);
                      r0 = CPU.addT(r3, 0x0);
                      r0 = FUN_80045d4(r0);
                      CPU.cmpT(r0, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r1 = CPU.subT(r0, r7);
                        CPU.cmpT(r1, 0x0);
                        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                          r1 = CPU.movT(0, 0x0);
                        }

                        //LAB_800cf12
                        r3 = MEMORY.ref(4, 0x800d050).get();
                        r0 = (int)MEMORY.call(r3, r0, r1);
                        r5 = CPU.addT(r0, 0x0);
                        r1 = CPU.addT(r5, 0x0);
                        r0 = CPU.r8().value;
                        r0 = CPU.lslT(r0, 0);
                        CPU.r12().value = 0x800cf24;
                        r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                        MEMORY.ref(4, r6 + 0x24).setu(r0);
                        r1 = CPU.addT(r5, 0x0);
                        r0 = CPU.r11().value;
                        r0 = CPU.lslT(r0, 0);
                        CPU.r12().value = 0x800cf30;
                        r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                        MEMORY.ref(4, r6 + 0x28).setu(r0);
                        r1 = CPU.addT(r5, 0x0);
                        r0 = CPU.r9().value;
                        r0 = CPU.lslT(r0, 0);
                        CPU.r12().value = 0x800cf3c;
                        r0 = (int)MEMORY.call(CPU.r10().value, r0, r1);
                        MEMORY.ref(4, r6 + 0x2c).setu(r0);
                      }
                    }
                  }

                  //LAB_800cf3e
                  r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                  MEMORY.ref(4, r6 + 0x14).setu(r1);
                }

                //LAB_800cf42
                r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r2 = MEMORY.ref(1, r3).getUnsigned();
                r3 = CPU.movT(0, 0x2);
                r3 = CPU.andT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r4 = MEMORY.ref(4, r6 + 0x14).get();
                  r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                  MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
                  r0 = CPU.cmpT(r0, r4);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    r3 = MEMORY.ref(4, r6 + 0x28).get();
                    r2 = MEMORY.ref(4, r6 + 0x48).get();
                    r3 = CPU.subT(r3, r2);
                    MEMORY.ref(4, r6 + 0x28).setu(r3);
                  } else {
                    //LAB_800cf60
                    r0 = MEMORY.ref(4, r6 + 0x28).get();
                    CPU.cmpT(r0, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r1);
                      r3 = MEMORY.ref(4, 0x800d054).get();
                      r1 = MEMORY.ref(4, r6 + 0x44).get();
                      r0 = CPU.lslT(r0, 0);
                      CPU.r12().value = 0x800cf74;
                      r0 = (int)MEMORY.call(r3, r0, r1);
                      r3 = CPU.negT(r3, r0);
                      r2 = CPU.addT(r3, 0x0);
                      MEMORY.ref(4, r6 + 0x28).setu(r3);
                      CPU.cmpT(r2, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r2 = CPU.addT(r0, 0x0);
                      }

                      //LAB_800cf80
                      r3 = MEMORY.ref(4, r6 + 0x48).get();
                      r2 = CPU.cmpT(r2, r3);
                      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                        r3 = CPU.movT(0, 0x0);

                        //LAB_800cf88
                        MEMORY.ref(4, r6 + 0x28).setu(r3);
                      }
                    }
                  }
                }

                //LAB_800cf8a
                r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
                r2 = MEMORY.ref(1, r3).getUnsigned();
                r3 = CPU.movT(0, 0x4);
                r3 = CPU.andT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r1 = MEMORY.ref(4, r6 + 0x44).get();
                  r3 = CPU.movT(0, 0x3f);
                  r1 = CPU.andT(r1, r3);
                  r3 = CPU.movT(0, 0x8);
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r2 = MEMORY.ref(4, 0x800d05c).get();
                    r3 = CPU.lsrT(r1, 1);
                    r3 = CPU.lslT(r3, 2);
                    r2 = MEMORY.ref(4, r2 + r3).get();
                    r3 = MEMORY.ref(4, r6 + 0x48).get();
                    r3 = CPU.mulT(r3, r2);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r3 = CPU.addT(r3, 0xf);
                    }

                    //LAB_800cfb6
                    r3 = CPU.asrT(r3, 4);
                  } else {
                    //LAB_800cfba
                    r2 = MEMORY.ref(4, 0x800d05c).get();
                    r3 = CPU.lsrT(r1, 1);
                    r3 = CPU.lslT(r3, 2);
                    r2 = MEMORY.ref(4, r2 + r3).get();
                    r3 = MEMORY.ref(4, r6 + 0x48).get();
                    r3 = CPU.mulT(r3, r2);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r3 = CPU.addT(r3, 0x3f);
                    }

                    //LAB_800cfcc
                    r3 = CPU.asrT(r3, 6);
                  }

                  //LAB_800cfce
                  MEMORY.ref(4, r6 + 0x28).setu(r3);
                  r3 = MEMORY.ref(4, r6 + 0x44).get();
                  r3 = CPU.addT(r3, 0x1);
                  MEMORY.ref(4, r6 + 0x44).setu(r3);
                }
              }
            }

            //LAB_800cfd6
            r3 = MEMORY.ref(4, r6 + 0x24).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            r4 = CPU.addT(r4, r3);
            MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r4);
            r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r3 = MEMORY.ref(4, r6 + 0x28).get();
            r0 = CPU.addT(r0, r3);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r0);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            r3 = MEMORY.ref(4, r6 + 0x2c).get();
            r1 = CPU.addT(r1, r3);
            MEMORY.ref(4, CPU.sp().value + 0x14).setu(r1);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r2 = MEMORY.ref(1, r3 + 0x4).getUnsigned();
            r3 = CPU.movT(0, 0x80);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r1 = CPU.sp().value + 0x24;
              MEMORY.ref(4, r1 + 0x4).setu(r0);
              MEMORY.ref(4, r1).setu(r4);
              r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
              r0 = CPU.addT(r6, 0x0);
              MEMORY.ref(4, r1 + 0x8).setu(r4);
              r0 = FUN_800d924(r0, r1);
              CPU.cmpT(r0, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_800d018
                r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                MEMORY.ref(1, r1 + 0xb).setu(r0);
              } else {
                r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r3 = MEMORY.ref(1, r0 + 0xb).getUnsigned();
                r3 = CPU.addT(r3, 0x1);
                MEMORY.ref(1, r0 + 0xb).setu(r3);
                break jmp_800d0fe;
              }
            }

            //LAB_800d01c
            r1 = MEMORY.ref(4, CPU.sp().value).get();
            r3 = MEMORY.ref(1, r1).getUnsigned();
            CPU.cmpT(r3, 0x11);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_800d042
              r2 = MEMORY.ref(4, r6 + 0x3c).get();
              r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
              r3 = CPU.cmpT(r3, r2);
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.movT(0, 0x1);
                MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
              } else {
                r3 = MEMORY.ref(4, r6 + 0xc).get();
                r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
                r3 = CPU.subT(r3, r2);
                r2 = CPU.subT(r4, r2);
                r3 = CPU.eorT(r3, r2);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                  //LAB_800d076
                  r0 = CPU.movT(0, 0x1);
                  MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                }
              }
            } else {
              CPU.cmpT(r3, 0x11);
              if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                CPU.cmpT(r3, 0x10);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_800d034
                  r2 = MEMORY.ref(4, r6 + 0x38).get();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                  r3 = CPU.cmpT(r3, r2);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.movT(0, 0x1);
                    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                  } else {
                    r3 = MEMORY.ref(4, r6 + 0x8).get();
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                    r3 = CPU.subT(r3, r2);
                    r2 = CPU.subT(r4, r2);
                    r3 = CPU.eorT(r3, r2);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      r0 = CPU.movT(0, 0x1);
                      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                    }
                  }
                }
              } else {
                //LAB_800d02e
                CPU.cmpT(r3, 0x12);
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_800d060
                  r2 = MEMORY.ref(4, r6 + 0x40).get();
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                  r3 = CPU.cmpT(r3, r2);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.movT(0, 0x1);
                    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                  } else {
                    r3 = MEMORY.ref(4, r6 + 0x10).get();
                    r4 = MEMORY.ref(4, CPU.sp().value + 0x14).get();

                    //LAB_800d06c
                    r3 = CPU.subT(r3, r2);
                    r2 = CPU.subT(r4, r2);
                    r3 = CPU.eorT(r3, r2);
                    CPU.cmpT(r3, 0x0);
                    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                      //LAB_800d076
                      r0 = CPU.movT(0, 0x1);
                      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
                    }
                  }
                }
              }
            }

            //LAB_800d07a
            r2 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            CPU.cmpT(r2, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r3 = MEMORY.ref(1, r4 + 0x3).getUnsigned();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = MEMORY.ref(4, r6 + 0x38).get();
                MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r0);
                r2 = MEMORY.ref(4, r6 + 0x40).get();
                r3 = CPU.movT(0, 0x0);
                MEMORY.ref(4, r6 + 0x24).setu(r3);
                MEMORY.ref(4, CPU.sp().value + 0x14).setu(r2);
                MEMORY.ref(4, r6 + 0x2c).setu(r3);
                r3 = MEMORY.ref(1, r4).getUnsigned();
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r4 = MEMORY.ref(4, r6 + 0x3c).get();
                  MEMORY.ref(4, CPU.sp().value + 0x18).setu(r4);
                  MEMORY.ref(4, r6 + 0x28).setu(r3);
                }
              }

              //LAB_800d0a2
              r3 = CPU.movT(0, 0x80);
              r3 = CPU.lslT(r3, 24);
              MEMORY.ref(4, r6 + 0x38).setu(r3);
              MEMORY.ref(4, r6 + 0x3c).setu(r3);
              MEMORY.ref(4, r6 + 0x40).setu(r3);
              r3 = CPU.movT(0, 0x0);
              MEMORY.ref(1, r1).setu(r3);
            }

            //LAB_800d0b0
            r0 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
            MEMORY.ref(4, r6 + 0x8).setu(r0);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            MEMORY.ref(4, r6 + 0xc).setu(r1);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
            MEMORY.ref(4, r6 + 0x10).setu(r2);
            r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r2 = MEMORY.ref(1, r3 + 0x5).getUnsigned();
            r3 = CPU.movT(0, 0x1);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r4 = MEMORY.ref(4, r6 + 0x24).get();
              MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r4);
              r0 = MEMORY.ref(4, r6 + 0x2c).get();
              MEMORY.ref(4, CPU.sp().value + 0x14).setu(r0);
              if(r4 != 0 || r0 != 0) {
                //LAB_800d0d8
                r0 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                r0 = FUN_80044d0(r0, r1);
                r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
                r0 = CPU.subT(r0, r3);
                r0 = CPU.lslT(r0, 16);
                r2 = CPU.movT(0, 0x80);
                r0 = CPU.asrT(r0, 16);
                r2 = CPU.lslT(r2, 5);
                r0 = CPU.cmpT(r0, r2);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  r0 = CPU.addT(r2, 0x0);
                }

                //LAB_800d0f2
                r2 = MEMORY.ref(4, 0x800d12c).get();
                r0 = CPU.cmpT(r0, r2);
                if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                  r0 = CPU.addT(r2, 0x0);
                }

                //LAB_800d0fa
                r3 = CPU.addT(r3, r0);
                MEMORY.ref(2, r6 + 0x6).setu(r3);
              }
            }
          }
        }
      }

      //LAB_800d0fe
      r1 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r3 = MEMORY.ref(4, CPU.sp().value).get();
      r1 = CPU.subT(r1, 0x1);
      r2 = CPU.addT(r2, 0x70);
      r3 = CPU.addT(r3, 0x70);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(r1);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
      MEMORY.ref(4, CPU.sp().value).setu(r3);
      r6 = CPU.addT(r6, 0x70);
      CPU.cmpT(r1, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        break;
      }
    } while(true);

    //LAB_800d118
    CPU.sp().value += 0x30;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x800d130)
  public static void FUN_800d130(final int r0, final int r1, final int r2, int r3) {
    MEMORY.ref(4, r0 + 0x10).setu(r3);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 24);
    MEMORY.ref(4, r0 + 0x38).setu(r3);
    MEMORY.ref(4, r0 + 0x3c).setu(r3);
    MEMORY.ref(4, r0 + 0x40).setu(r3);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r0 + 0x8).setu(r1);
    MEMORY.ref(4, r0 + 0xc).setu(r2);
    MEMORY.ref(4, r0 + 0x24).setu(r3);
    MEMORY.ref(4, r0 + 0x28).setu(r3);
    MEMORY.ref(4, r0 + 0x2c).setu(r3);
  }

  @Method(0x800d654)
  public static int FUN_800d654(int r0) {
    int r2;
    int r3;
    r2 = CPU.movT(0, 0x4);
    r3 = MEMORY.ref(2, r0 + r2).get();
    r2 = MEMORY.ref(4, r0).get();
    r3 = CPU.lslT(r3, 2);
    r3 = CPU.addT(r3, r2);
    r3 = MEMORY.ref(4, r3 + 0x4).get();
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.subT(r3, 0x1);
    r2 = CPU.addT(r2, 0x5e);
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(2, r0 + 0x4).getUnsigned();
    r3 = CPU.addT(r3, 0x2);
    MEMORY.ref(2, r0 + 0x4).setu(r3);
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x800d6d8)
  public static int FUN_800d6d8(int r0, int r1) {
    int r2;
    int r3;
    final int r4;

    r2 = CPU.addT(r0, 0x0);
    r2 = CPU.addT(r2, 0x5e);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r2).setu(r3);
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_800d6ec
      r3 = MEMORY.ref(4, 0x800d708).get();
      r4 = MEMORY.ref(4, 0x800d70c).get();
      r2 = MEMORY.ref(4, r0).get();
      r1 = CPU.andT(r1, r3);
      r0 = CPU.movT(0, 0x0);

      //LAB_800d6f6
      do {
        r3 = MEMORY.ref(4, r2).get();
        r2 += 0x4;

        r3 = CPU.cmpT(r3, r1);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_800d6e8
          r0 = CPU.addT(r0, 0x1);
          return r0;
        }
        r0 = CPU.addT(r0, 0x1);
        r0 = CPU.cmpT(r0, r4);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    }

    //LAB_800d702
    r0 = CPU.movT(0, 0x0);

    //LAB_800d704
    return r0;
  }

  @Method(0x800d710)
  public static int FUN_800d710(int r0) {
    final int r1;
    int r2;
    int r3;
    int r4;
    final int r5;

    r5 = CPU.addT(r0, 0x0);
    r3 = CPU.movT(0, 0x4);
    r2 = MEMORY.ref(2, r5 + r3).get();
    r3 = MEMORY.ref(4, r5).get();
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.addT(r3, 0x4);
    r4 = MEMORY.ref(4, r3).get();
    r3 += 0x4;

    r1 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, 0x800d75c).get();
    r4 = CPU.cmpT(r4, r3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = FUN_800d6d8(r0, r1);
      MEMORY.ref(2, r5 + 0x4).setu(r0);
    } else {
      r0 = CPU.addT(r5, 0x0);
      r0 = CPU.addT(r0, 0x5d);
      r2 = MEMORY.ref(1, r0).getUnsigned();
      r2 = CPU.addT(r2, 0x1);
      MEMORY.ref(1, r0).setu(r2);
      r3 = CPU.lslT(r4, 16);
      r2 = CPU.lslT(r2, 24);
      r2 = CPU.lsrT(r2, 24);
      r3 = CPU.asrT(r3, 16);
      r2 = CPU.cmpT(r2, r3);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_800d6d8(r0, r1);
        MEMORY.ref(2, r5 + 0x4).setu(r0);
      } else {
        //LAB_800d74a
        r3 = CPU.movT(0, 0x0);
        MEMORY.ref(1, r0).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
        r3 = CPU.addT(r3, 0x3);
        MEMORY.ref(2, r5 + 0x4).setu(r3);
      }
    }

    //LAB_800d754
    r0 = CPU.movT(0, 0x1);
    return r0;
  }

  @Method(0x800d7e8)
  public static int FUN_800d7e8(final int r0) {
    int r3 = MEMORY.ref(4, 0x800d7f4).get();
    MEMORY.ref(4, r0).setu(r3);
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r0 + 0x4).setu(r3);
    return 0;
  }

  @Method(0x800d924)
  public static int FUN_800d924(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    r3 = MEMORY.ref(4, 0x800d988).get();
    r5 = MEMORY.ref(4, r3).get();
    r6 = CPU.addT(r5, 0x0);
    CPU.sp().value -= 0x4;
    r7 = CPU.addT(r0, 0x0);
    CPU.r8().value = r1;
    r4 = CPU.movT(0, 0x0);
    r6 = CPU.addT(r6, 0x59);

    //LAB_800d93a
    do {
      r3 = MEMORY.ref(4, r5).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = MEMORY.ref(1, r6).getUnsigned();
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r5 = CPU.cmpT(r5, r7);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = MEMORY.ref(2, r5 + 0x20).getUnsigned();
            r3 = MEMORY.ref(2, r7 + 0x20).getUnsigned();
            r0 = CPU.addT(r5, 0x0);
            r0 = CPU.addT(r0, 0x8);
            r1 = CPU.subT(r1, 0x2);
            r3 = CPU.subT(r3, 0x2);
            r2 = CPU.r8().value;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r0 = FUN_800eba0(r0, r1, r2, r3);
            r4 = MEMORY.ref(4, CPU.sp().value).get();
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
              r0 = CPU.movT(0, 0x1);
              r0 = CPU.negT(r0, r0);

              CPU.sp().value += 0x4;
              CPU.r8().value = CPU.pop();
              return r0;
            }
          }
        }
      }

      //LAB_800d96e
      r4 = CPU.addT(r4, 0x1);
      r6 = CPU.addT(r6, 0x70);
      r5 = CPU.addT(r5, 0x70);
      CPU.cmpT(r4, 0x3f);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r0 = CPU.movT(0, 0x0);

    //LAB_800d97a
    CPU.sp().value += 0x4;
    CPU.r8().value = CPU.pop();
    return r0;
  }

  @Method(0x800daf0)
  public static int FUN_800daf0(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r3 = MEMORY.ref(4, 0x800dcc0).get();
    r1 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xec);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.movT(0, 0xf0);
    r2 = CPU.lslT(r2, 15);
    CPU.r8().value = r0;
    r7 = CPU.addT(r3, r2);
    r0 = MEMORY.ref(4, r0 + 0x68).get();
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xf0);
    r2 = MEMORY.ref(4, r0 + 0xc).get();
    r3 = MEMORY.ref(4, r3).get();
    r4 = CPU.movT(0, 0xc0);
    r3 = CPU.addT(r3, r2);
    r4 = CPU.lslT(r4, 15);
    r6 = CPU.addT(r3, r4);
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xf4);
    r3 = MEMORY.ref(4, r3).get();
    r5 = MEMORY.ref(4, 0x800dcc4).get();
    r4 = CPU.addT(r3, r5);
    r3 = CPU.addT(r1, 0x0);
    r3 = CPU.addT(r3, 0xf8);
    r3 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r3, r2);
    r2 = MEMORY.ref(4, 0x800dcc8).get();
    r1 = CPU.addT(r3, r2);
    r2 = CPU.r8().value;
    r2 = CPU.addT(r2, 0x55);
    r3 = CPU.movT(0, 0x0);
    CPU.sp().value -= 0x8;
    MEMORY.ref(1, r2).setu(r3);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_800db48
      r3 = MEMORY.ref(4, r0).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_800db50
        r3 = MEMORY.ref(4, r0 + 0x8).get();
        r5 = MEMORY.ref(4, r0 + 0xc).get();
        CPU.r11().value = r3;
        r0 = MEMORY.ref(4, r0 + 0x10).get();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 24);
        r2 = CPU.r8().value;
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
        MEMORY.ref(4, r2 + 0x38).setu(r3);
        MEMORY.ref(4, r2 + 0x3c).setu(r3);
        MEMORY.ref(4, r2 + 0x40).setu(r3);
        CPU.cmpT(CPU.r11().value, r7);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          CPU.r11().value = r7;
        }

        //LAB_800db6c
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r3 = CPU.cmpT(r3, r6);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r6);
        }

        //LAB_800db74
        CPU.cmpT(CPU.r11().value, r4);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          CPU.r11().value = r4;
        }

        //LAB_800db7a
        r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r4 = CPU.cmpT(r4, r1);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
        }

        //LAB_800db82
        r3 = CPU.r8().value;
        r3 = CPU.addT(r3, 0x64);
        r2 = CPU.movT(0, 0x0);
        r3 = MEMORY.ref(2, r3 + r2).get();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.r8().value;
          r3 = CPU.r11().value;
          MEMORY.ref(4, r4 + 0x8).setu(r3);
          MEMORY.ref(4, r4 + 0xc).setu(r5);
          r5 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          MEMORY.ref(4, r4 + 0x10).setu(r5);
        } else {
          //LAB_800db9c
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(4, r2 + 0x8).get();
          r4 = CPU.r11().value;
          r0 = CPU.subT(r4, r3);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r2 = MEMORY.ref(4, 0x800dccc).get();
            r0 = CPU.addT(r0, r2);
          }

          //LAB_800dbac
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(4, r2 + 0x10).get();
          r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r0 = CPU.asrT(r0, 16);
          CPU.r10().value = r0;
          r0 = CPU.subT(r4, r3);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r2 = MEMORY.ref(4, 0x800dccc).get();
            r0 = CPU.addT(r0, r2);
          }

          //LAB_800dbc0
          r6 = CPU.asrT(r0, 16);
          r3 = CPU.r10().value;
          r0 = CPU.r10().value;
          r0 = CPU.mulT(r0, r3);
          r3 = CPU.addT(r6, 0x0);
          r3 = CPU.mulT(r3, r6);
          r0 = CPU.addT(r0, r3);
          r3 = MEMORY.ref(4, 0x800dcd0).get();
          r0 = (int)MEMORY.call(r3, r0);
          r4 = CPU.r8().value;
          r3 = MEMORY.ref(4, r4 + 0x8).get();
          r2 = CPU.r11().value;
          r2 = CPU.subT(r2, r3);
          r3 = MEMORY.ref(4, r4 + 0xc).get();
          r5 = CPU.subT(r5, r3);
          CPU.r9().value = r5;
          r3 = MEMORY.ref(4, r4 + 0x10).get();
          r5 = CPU.movT(0, 0x80);
          r4 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r7 = CPU.lslT(r0, 16);
          r5 = CPU.lslT(r5, 15);
          CPU.r10().value = r2;
          r6 = CPU.subT(r4, r3);
          r7 = CPU.cmpT(r7, r5);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r4 = MEMORY.ref(4, 0x800dcd4).get();
            r0 = CPU.r10().value;
            r1 = CPU.r10().value;
            r0 = CPU.lslT(r0, 0);
            CPU.r12().value = 0x800dc00;
            MEMORY.call(r4, r0, r1);
            r3 = CPU.addT(r0, 0x0);
            r1 = CPU.addT(r6, 0x0);
            r0 = CPU.addT(r6, 0x0);
            r0 = CPU.lslT(r0, 0);
            CPU.r12().value = 0x800dc0c;
            MEMORY.call(r4, r0, r1);
            r3 = CPU.addT(r3, r0);
            r0 = CPU.addT(r3, 0x0);
            r0 = FUN_80045d4(r0);
            r7 = CPU.addT(r0, 0x0);
          }

          //LAB_800dc16
          r1 = CPU.addT(r7, 0x0);
          CPU.cmpT(r7, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = CPU.addT(r7, 0x7);
          }

          //LAB_800dc1e
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(4, r2 + 0x30).get();
          r5 = CPU.asrT(r1, 3);
          r5 = CPU.cmpT(r5, r3);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r5 = CPU.addT(r3, 0x0);
          }

          //LAB_800dc2a
          r3 = CPU.movT(0, 0x80);
          r3 = CPU.lslT(r3, 7);
          r7 = CPU.cmpT(r7, r3);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r5 = CPU.r8().value;
            r4 = CPU.r11().value;
            MEMORY.ref(4, r5 + 0x8).setu(r4);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            MEMORY.ref(4, r5 + 0x10).setu(r2);
          } else {
            //LAB_800dc3e
            r7 = CPU.cmpT(r7, r5);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r3 = MEMORY.ref(4, 0x800dcd8).get();
              r1 = CPU.r10().value;
              CPU.r11().value = r3;
              r0 = CPU.addT(r7, 0x0);
              r0 = (int)MEMORY.call(CPU.r11().value, r0, r1);
              r3 = MEMORY.ref(4, 0x800dcd4).get();
              r1 = CPU.addT(r5, 0x0);
              r0 = CPU.lslT(r0, 0);
              CPU.r12().value = 0x800dc58;
              MEMORY.call(r3, r0, r1);
              r1 = CPU.addT(r6, 0x0);
              MEMORY.ref(4, CPU.sp().value).setu(r3);
              CPU.r10().value = r0;
              r0 = CPU.addT(r7, 0x0);
              r0 = (int)MEMORY.call(CPU.r11().value, r0, r1);
              r1 = CPU.addT(r5, 0x0);
              r3 = MEMORY.ref(4, CPU.sp().value).get();
              CPU.r12().value = 0x800dc6c;
              MEMORY.call(r3, r0, r1);
              r6 = CPU.addT(r0, 0x0);
            }

            //LAB_800dc6e
            r4 = CPU.r8().value;
            r3 = MEMORY.ref(4, r4 + 0x8).get();
            r3 += CPU.r10().value;
            MEMORY.ref(4, r4 + 0x8).setu(r3);
            r3 = MEMORY.ref(4, r4 + 0x10).get();
            r3 = CPU.addT(r3, r6);
            MEMORY.ref(4, r4 + 0x10).setu(r3);
          }

          //LAB_800dc7c
          r3 = CPU.r9().value;
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r3 = CPU.negT(r3, r3);
          }

          //LAB_800dc84
          r5 = CPU.movT(0, 0x80);
          r5 = CPU.lslT(r5, 8);
          r3 = CPU.cmpT(r3, r5);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r3 = CPU.r9().value;
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r3 = CPU.addT(r3, 0x3);
            }

            //LAB_800dc94
            r3 = CPU.asrT(r3, 2);
            CPU.r9().value = r3;
          }

          //LAB_800dc98
          r2 = CPU.r8().value;
          r3 = MEMORY.ref(4, r2 + 0xc).get();
          r3 += CPU.r9().value;
          MEMORY.ref(4, r2 + 0xc).setu(r3);
        }
      }
    }

    //LAB_800dca0
    r4 = CPU.r8().value;
    r3 = MEMORY.ref(2, r4 + 0x4).getUnsigned();
    r5 = CPU.r8().value;
    r3 = CPU.addT(r3, 0x1);
    r0 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r5 + 0x4).setu(r3);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;

    return r0;
  }

  @Method(0x800eba0)
  public static int FUN_800eba0(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;

    r4 = MEMORY.ref(4, r0).get();
    r0 += 0x4;

    r5 = MEMORY.ref(4, r2).get();
    r2 += 0x4;

    r4 = CPU.subT(r4, r5);
    r6 = CPU.asrT(r4, 16);
    r5 = MEMORY.ref(4, r2).get();
    r2 += 0x4;

    r4 = MEMORY.ref(4, r0).get();
    r0 += 0x4;

    r2 = MEMORY.ref(4, r2).get();
    r0 = MEMORY.ref(4, r0).get();
    r1 = CPU.addT(r1, r3);
    r3 = CPU.movT(0, 0x80);
    r4 = CPU.subT(r4, r5);
    r0 = CPU.subT(r0, r2);
    r3 = CPU.lslT(r3, 15);
    r4 = CPU.asrT(r4, 16);
    r0 = CPU.asrT(r0, 16);
    r6 = CPU.cmpT(r6, r3);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r0 = CPU.cmpT(r0, r3);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r2 = CPU.addT(r4, 0x0);
        r2 = CPU.mulT(r2, r4);
        r3 = CPU.addT(r6, 0x0);
        r3 = CPU.mulT(r3, r6);
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r0, 0x0);
        r2 = CPU.mulT(r2, r0);
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.mulT(r2, r1);
        r0 = CPU.movT(0, 0x0);
        r3 = CPU.cmpT(r3, r2);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          return r0;
        }
      }
    }

    //LAB_800ebe2
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.negT(r0, r0);

    //LAB_800ebe6
    return r0;
  }

  @Method(0x800f9f4)
  public static void FUN_800f9f4(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;

    r3 = CPU.subT(r0, 0x1);
    r2 = CPU.lsrT(r3, 31);
    r3 = CPU.addT(r3, r2);
    r4 = CPU.asrT(r3, 1);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.andT(r3, r0);
    r6 = MEMORY.ref(4, 0x800fa80).get();
    r5 = MEMORY.ref(4, 0x800fa84).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x800fa88).get();
      r3 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_800fa38
        r6 = MEMORY.ref(4, 0x800fa80).get();
        r1 = CPU.movT(0, 0x0);
        r7 = CPU.movT(0, 0x0);
        r0 = CPU.addT(r4, r6);
        r1 = CPU.cmpT(r1, r4);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          //LAB_800fa44
          do {
            r3 = MEMORY.ref(1, r6).getUnsigned();
            r2 = MEMORY.ref(1, r0).getUnsigned();
            r3 = CPU.lslT(r3, 8);
            r3 = CPU.orrT(r3, r2);
            r3 = CPU.eorT(r3, r7);
            r1 = CPU.addT(r1, 0x1);
            MEMORY.ref(2, r5).setu(r3);
            r0 = CPU.addT(r0, 0x1);
            r6 = CPU.addT(r6, 0x1);
            r5 = CPU.addT(r5, 0x2);
            r7 = CPU.addT(r3, 0x0);
            r1 = CPU.cmpT(r1, r4);
          } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
        }
      } else {
        CPU.cmpT(r3, 0x1);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          //LAB_800fa1c
          CPU.cmpT(r3, 0x2);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_800fa60
            r2 = CPU.movT(0, 0x0);
            CPU.cmpT(r4, 0x0);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              r1 = CPU.addT(r4, 0x0);

              //LAB_800fa68
              do {
                r3 = MEMORY.ref(2, r6).getUnsigned();
                r1 = CPU.subT(r1, 0x1);
                r3 = CPU.eorT(r3, r2);
                MEMORY.ref(2, r5).setu(r3);
                r6 = CPU.addT(r6, 0x2);
                r5 = CPU.addT(r5, 0x2);
                r2 = CPU.addT(r3, 0x0);
                CPU.cmpT(r1, 0x0);
              } while(!CPU.cpsr().getZero()); // !=
            }
          }
        } else {
          CPU.cmpT(r3, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_800fa22
            r1 = CPU.movT(0, 0x0);
            r1 = CPU.cmpT(r1, r4);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              //LAB_800fa28
              do {
                r3 = MEMORY.ref(2, r6).getUnsigned();
                r1 = CPU.addT(r1, 0x1);
                MEMORY.ref(2, r5).setu(r3);
                r6 = CPU.addT(r6, 0x2);
                r5 = CPU.addT(r5, 0x2);
                r1 = CPU.cmpT(r1, r4);
              } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
            }
          }
        }
      }
    }

    //LAB_800fa7a
  }

  @Method(0x800fac8)
  public static void FUN_800fac8() {
    final int r8 = FUN_8004970(0x8000);
    MEMORY.call(0x3001388, r8, 0x2010000, 0x8000); // memcpy

    final int size = 0x9c;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x800a37c);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3002000 -> MEMORY.addFunctions(CopiedSegment800a37c.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    MEMORY.call(addr, 0x2018000, 0x2010000, r8);
    FUN_8002df0(addr);
    FUN_8002df0(r8);
  }

  @Method(0x800fb38)
  public static int FUN_800fb38(int r0) {
    int r1;
    int r2;
    int r4;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0xc;

    GPU.DISPCNT.and(0xc1ff);

    FUN_8003bb4(0);

    final Struct0c sp0x08 = _8013784.get(r0);

    CPU.r8().value = FUN_80048f4(0x8, 0x194);
    MEMORY.call(0x3000164, CPU.r8().value, 0x194);

    final PointerTableType296 r5 = MEMORY.ref(4, getPointerTableEntry(296 + sp0x08._00.get()), PointerTableType296::new);
    FUN_800f9f4(decompress(r5.getAddress() + r5._24.get(), 0x2010001));
    decompress(r5.getAddress() + r5._28.get(), 0x202c000);
    decompress(r5.getAddress() + r5._2c.get(), 0x2010000);
    FUN_800fac8();

    r0 = r5._30.get();
    if(r0 != 0) {
      decompress(r5.getAddress() + r0, 0x202d000);
      FUN_80118d8(0x202d000);
    }

    //LAB_800fbc8
    r0 = r5._34.get();
    if(r0 != 0) {
      decompress(r5.getAddress() + r0, 0x202de00);
      FUN_8011a84(0x202de00);
    }

    //LAB_800fbde
    MEMORY.ref(4, CPU.r8().value + 0x10).setu(r5.getAddress() + r5._38.get());
    MEMORY.ref(4, CPU.r8().value + 0xec).setu(r5._00.get() << 19);
    MEMORY.ref(4, CPU.r8().value + 0xf0).setu(r5._01.get() << 19);
    MEMORY.ref(4, CPU.r8().value + 0xf4).setu(r5._02.get() << 19);
    MEMORY.ref(4, CPU.r8().value + 0xf8).setu(r5._03.get() << 19);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(CPU.r8().value + 0xe4);
    MEMORY.ref(4, CPU.sp().value + 0x4).deref(4).setu(0);
    MEMORY.ref(4, CPU.sp().value).setu(CPU.r8().value + 0xe8);
    MEMORY.ref(4, CPU.r8().value + 0xe8).setu(0);
    MEMORY.ref(1, CPU.r8().value + 0x100).setu(r5._04.get());
    MEMORY.ref(1, CPU.r8().value + 0x101).setu(r5._05.get());
    MEMORY.ref(1, CPU.r8().value + 0x102).setu(r5._06.get());

    //LAB_800fc48
    for(int i = 0; i < 3; i++) {
      final PointerTableType296.Sub08 r6 = r5._0c.get(i);
      r7 = CPU.r8().value + 0x104 + i * 0x30;
      CPU.lr().value = r6._00.get() << 19;
      CPU.r10().value = r6._01.get() << 19;
      MEMORY.ref(4, r7 + 0x8).setu(CPU.lr().value);
      MEMORY.ref(4, r7 + 0xc).setu(CPU.r10().value);
      MEMORY.ref(4, r7 + 0x18).setu(r6._04.get() << 12);
      MEMORY.ref(4, r7 + 0x1c).setu(r6._05.get() << 12);
      MEMORY.ref(2, r7 + 0x28).setu(r6._06.get());
      MEMORY.ref(2, r7 + 0x2a).setu(r6._07.get());
      MEMORY.ref(4, r7 + 0x20).setu(0);
      MEMORY.ref(4, r7 + 0x24).setu(0);
      r0 = r6._00.get() >>> 1;
      r2 = r6._01.get() >>> 1 << 7;
      r1 = r6._02.get() << 12;
      r4 = r6._03.get() << 12;
      MEMORY.ref(4, r7 + 0x10).setu(r1);
      MEMORY.ref(4, r7 + 0x14).setu(r4);
      MEMORY.ref(4, r7 + 0x2c).setu(0x2010000 + (r2 + r0) * 0x4);

      MEMORY.ref(4, r7).setu((int)MEMORY.call(0x3000118, MEMORY.ref(4, CPU.sp().value + 0x4).deref(4).get(), r1) + CPU.lr().value);
      MEMORY.ref(4, r7 + 0x4).setu((int)MEMORY.call(0x3000118, MEMORY.ref(4, CPU.sp().value).deref(4).get(), r4) + CPU.r10().value);
    }

    MEMORY.ref(2, CPU.r8().value + 0x14).setu(0x1000);

    r1 = CPU.r8().value + 0x100;
    if(MEMORY.ref(1, r1).getUnsigned() != 0) {
      MEMORY.ref(2, CPU.r8().value + 0x14).setu(0x1800);
    }

    //LAB_800fcde
    r0 = CPU.r8().value + 0x101;
    if(MEMORY.ref(1, r0).getUnsigned() != 0) {
      MEMORY.ref(2, CPU.r8().value + 0x14).oru(0x400);
    }

    //LAB_800fcf4
    CPU.r12().value = CPU.r8().value + 0x102;
    if(MEMORY.ref(1, CPU.r12().value).getUnsigned() != 0) {
      MEMORY.ref(2, CPU.r8().value + 0x14).oru(0x200);
    }

    //LAB_800fd0e
    GPU.BG3CNT.setu(0x500 | MEMORY.ref(1, r1).getUnsigned() | r5._07.get() << 2);
    GPU.BG2CNT.setu(0x600 | MEMORY.ref(1, r0).getUnsigned() | r5._08.get() << 2);
    GPU.BG1CNT.setu(0x700 | MEMORY.ref(1, CPU.r12().value).getUnsigned() | r5._09.get() << 2);

    if(FUN_80770c0(0x170) != 0) {
      FUN_80770d0(0x170);
    } else {
      //LAB_800fd98
      r7 = FUN_8004938(0x4000);
      if(r7 != 0) {
        CPU.r10().value = MEMORY.ref(2, 0x5000000).get();

        r0 = getPointerTableEntry(296 + sp0x08._02.get());
        decompress(r0, r7);
        MEMORY.ref(2, r7).setu(CPU.r10().value);
        MEMORY.call(0x3001388, 0x5000000, r7, 0x1c0); // memcpy

        r0 = getPointerTableEntry(296 + sp0x08._04.get());
        FUN_8005394(r0, r7);
        MEMORY.call(0x3001388,  0x6004000, r7, 0x4000); // memcpy

        r0 = getPointerTableEntry(296 + sp0x08._06.get());
        FUN_8005394(r0, r7);
        MEMORY.call(0x3001388, 0x6008000, r7, 0x4000); // memcpy

        r0 = getPointerTableEntry(296 + sp0x08._08.get());
        FUN_8005394(r0, r7);
        MEMORY.call(0x3001388, 0x600c000, r7, 0x4000); // memcpy

        r0 = getPointerTableEntry(296 + sp0x08._0a.get());
        FUN_8005394(r0, 0x2028000);
        FUN_8002df0(r7);
      }
    }

    //LAB_800fe42
    GPU.MOSAIC.setu(0);
    GPU.BLDCNT.setu(0);
    GPU.DISPCNT.setu(0x140);
    FUN_80041d8(0x8010001, 0xc85);
    CPU.sp().value += 0xc;

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();

    return 2;
  }

  @Method(0x800fe9c)
  public static void FUN_800fe9c() {
    int r0;
    int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x800fec4).get();
    r3 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x0);
    r1 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r2 = MEMORY.ref(4, r3).get();
      r3 += 0x4;
      r1 = MEMORY.ref(4, r3).get();
    }

    //LAB_800feb4
    r1 = CPU.subT(r1, r2);
    FUN_8010230(r0, r1);
    FUN_8010000();
  }

  @Method(0x800fec8)
  public static void FUN_800fec8(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);

    r3 = MEMORY.ref(4, 0x800ff44).get();
    r0 = CPU.lslT(r0, 11);
    r3 = CPU.addT(r3, r0);
    CPU.r12().value = r3;
    r3 = CPU.lsrT(r2, 31);
    r3 = CPU.addT(r2, r3);
    r4 = CPU.movT(0, 0x7f);
    r3 = CPU.asrT(r3, 1);
    r3 = CPU.andT(r3, r4);
    r0 = CPU.movT(0, 0x1e);
    r2 = CPU.andT(r2, r0);
    r7 = CPU.lslT(r3, 7);
    r3 = CPU.lsrT(r1, 31);
    r2 = CPU.lslT(r2, 5);
    r3 = CPU.addT(r1, r3);
    CPU.r10().value = r2;
    r5 = CPU.asrT(r3, 1);
    r6 = CPU.movT(0, 0x7f);
    r2 = CPU.movT(0, 0x1e);
    r5 = CPU.andT(r5, r4);
    r0 = CPU.andT(r0, r1);
    r4 = CPU.movT(0, 0x0);
    CPU.r8().value = r6;
    CPU.lr().value = r2;

    //LAB_800ff00
    do {
      r3 = CPU.addT(r7, r5);
      r6 = MEMORY.ref(4, 0x800ff48).get();
      r3 = CPU.lslT(r3, 2);
      r3 = CPU.addT(r3, r6);
      r1 = MEMORY.ref(4, r3).get();
      r2 = MEMORY.ref(4, 0x800ff4c).get();
      r1 = CPU.lslT(r1, 20);
      r1 = CPU.lsrT(r1, 17);
      r6 = CPU.r10().value;
      r3 = CPU.addT(r1, r2);
      r2 = CPU.addT(r6, r0);
      r3 = MEMORY.ref(4, r3).get();
      r2 = CPU.lslT(r2, 1);
      r2 += CPU.r12().value;
      r6 = MEMORY.ref(4, 0x800ff50).get();
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.addT(r1, r6);
      r3 = MEMORY.ref(4, r3).get();
      r5 = CPU.addT(r5, 0x1);
      MEMORY.ref(4, r2 + 0x40).setu(r3);
      r0 = CPU.addT(r0, 0x2);
      r2 = CPU.r8().value;
      r3 = CPU.lr().value;
      r4 = CPU.addT(r4, 0x1);
      r5 = CPU.andT(r5, r2);
      r0 = CPU.andT(r0, r3);
      CPU.cmpT(r4, 0xf);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x800ff54)
  public static void FUN_800ff54(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r3 = MEMORY.ref(4, 0x800fff0).get();
    r0 = CPU.lslT(r0, 11);
    r3 = CPU.addT(r3, r0);
    CPU.lr().value = r3;
    r3 = CPU.lsrT(r2, 31);
    r3 = CPU.addT(r2, r3);
    r4 = CPU.movT(0, 0x7f);
    r3 = CPU.asrT(r3, 1);
    r3 = CPU.andT(r3, r4);
    r6 = CPU.lslT(r3, 7);
    r3 = CPU.lsrT(r1, 31);
    r0 = CPU.movT(0, 0x1e);
    r3 = CPU.addT(r1, r3);
    r2 = CPU.andT(r2, r0);
    r7 = CPU.asrT(r3, 1);
    CPU.r9().value = r1;
    r5 = CPU.lslT(r2, 5);
    r7 = CPU.andT(r7, r4);
    r2 = CPU.movT(0, 0x1);
    r4 = CPU.r9().value;
    r4 = CPU.andT(r4, r0);
    CPU.r12().value = r2;
    r3 = CPU.r12().value;
    CPU.r9().value = r4;
    r2 = CPU.movT(0, 0xf0);
    r4 = CPU.movT(0, 0xfe);
    r3 = CPU.andT(r3, r1);
    r4 = CPU.lslT(r4, 6);
    r2 = CPU.lslT(r2, 2);
    CPU.r12().value = r3;
    r0 = CPU.movT(0, 0x0);
    CPU.r10().value = r4;
    CPU.r8().value = r2;

    //LAB_800ffa0
    do {
      r3 = CPU.addT(r6, r7);
      r4 = MEMORY.ref(4, 0x800fff4).get();
      r3 = CPU.lslT(r3, 2);
      r3 = CPU.addT(r3, r4);
      r1 = MEMORY.ref(4, r3).get();
      r1 = CPU.lslT(r1, 20);
      r1 = CPU.lsrT(r1, 18);
      r3 = MEMORY.ref(4, 0x800fff8).get();
      r1 += CPU.r12().value;
      r1 = CPU.lslT(r1, 1);
      r4 = CPU.r9().value;
      r2 = CPU.addT(r1, r3);
      r3 = CPU.addT(r5, r4);
      r3 += CPU.r12().value;
      r2 = MEMORY.ref(2, r2).getUnsigned();
      r3 = CPU.lslT(r3, 1);
      r3 += CPU.lr().value;
      r4 = MEMORY.ref(4, 0x800fffc).get();
      MEMORY.ref(2, r3).setu(r2);
      r2 = CPU.addT(r1, r4);
      r2 = MEMORY.ref(2, r2).getUnsigned();
      r3 = CPU.addT(r3, 0x40);
      MEMORY.ref(2, r3).setu(r2);
      r6 = CPU.addT(r6, 0x80);
      r2 = CPU.r10().value;
      r5 = CPU.addT(r5, 0x40);
      r3 = CPU.r8().value;
      r0 = CPU.addT(r0, 0x1);
      r6 = CPU.andT(r6, r2);
      r5 = CPU.andT(r5, r3);
      CPU.cmpT(r0, 0xa);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }
}
