package org.goldensun;

import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;

import javax.annotation.Nullable;

import static org.goldensun.Bios.SvcHalt;
import static org.goldensun.CopiedSegment3000000.intHandlers_30000e0;
import static org.goldensun.GoldenSunVars._2002090;
import static org.goldensun.GoldenSunVars._3001800;
import static org.goldensun.GoldenSunVars._3001804;
import static org.goldensun.GoldenSunVars._3001a10;
import static org.goldensun.GoldenSunVars._3001a20;
import static org.goldensun.GoldenSunVars._3001ac0;
import static org.goldensun.GoldenSunVars._3001ac4;
import static org.goldensun.GoldenSunVars._3001aec;
import static org.goldensun.GoldenSunVars._3001af0;
import static org.goldensun.GoldenSunVars._3001c98;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001ca4;
import static org.goldensun.GoldenSunVars._3001ca8;
import static org.goldensun.GoldenSunVars._3001cb8;
import static org.goldensun.GoldenSunVars._3001cc8;
import static org.goldensun.GoldenSunVars._3001cd0;
import static org.goldensun.GoldenSunVars._3001cd4;
import static org.goldensun.GoldenSunVars._3001cf8;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars._3001d20;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars.heldLAndRTicks_3001f5c;
import static org.goldensun.GoldenSunVars._3007810;
import static org.goldensun.GoldenSunVars._3007ff0;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars._3001b00;
import static org.goldensun.GoldenSunVars._3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars._3001ca0;
import static org.goldensun.GoldenSunVars._3001cb0;
import static org.goldensun.GoldenSunVars._3001cbc;
import static org.goldensun.GoldenSunVars._3001ccc;
import static org.goldensun.GoldenSunVars._3001cfc;
import static org.goldensun.GoldenSunVars.heldButtons_3001d0c;
import static org.goldensun.GoldenSunVars._3001d18;
import static org.goldensun.GoldenSunVars._3001d28;
import static org.goldensun.GoldenSunVars._3001d34;
import static org.goldensun.GoldenSunVars._3001e44;
import static org.goldensun.GoldenSunVars._3001e50;
import static org.goldensun.GoldenSunVars._3001e54;
import static org.goldensun.GoldenSunVars._3001f20;
import static org.goldensun.GoldenSunVars._3001f54;
import static org.goldensun.GoldenSunVars._3001f58;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars._3007800;
import static org.goldensun.GoldenSunVars._3007804;
import static org.goldensun.GoldenSunVars._3007ffc;
import static org.goldensun.GoldenSunVars.ptrTable_8320000;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INPUT;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.Hardware.TIMERS;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun {
  private GoldenSun() { }

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
    if(_3007ff0.deref().get() == 0x68736d53) {
      FUN_800070c(_3007ff0.deref().getAddress());
    }
  }

  @Method(0x800070a)
  public static void FUN_800070a(final int r0, final int r1unused, final int r2unused, final int r3) {
    MEMORY.call(r3, r0);
  }

  @Method(0x800070c)
  public static void FUN_800070c(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r7;
    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);

    r1 = CPU.r8().value;
    r2 = CPU.r9().value;
    r3 = CPU.r10().value;
    r4 = CPU.r11().value;
    CPU.push(r4);
    CPU.push(r3);
    CPU.push(r2);
    CPU.push(r1);
    CPU.push(r0);

    CPU.sp().value -= 0x18;
    r3 = MEMORY.ref(4, r0 + 0x20).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, r0 + 0x24).get();
      FUN_800070a(r0, 0, 0, r3);
      r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    }

    //LAB_8000728
    r3 = MEMORY.ref(4, r0 + 0x28).get();
    FUN_800070a(r0, 0, 0, r3);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r3 = MEMORY.ref(4, r0 + 0x10).get();
    MEMORY.ref(4, CPU.sp().value).setu(r3);
    r5 = MEMORY.ref(4, 0x8000760).get();
    r5 = CPU.addT(r5, r0);
    r4 = MEMORY.ref(1, r0 + 0x4).getUnsigned();
    r7 = CPU.subT(r4, 0x1);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r1 = MEMORY.ref(1, r0 + 0xb).getUnsigned();
      r1 = CPU.subT(r1, r7);
      r2 = CPU.addT(r3, 0x0);
      r2 = CPU.mulT(r2, r1);
      r5 = CPU.addT(r5, r2);
    }

    //LAB_8000748
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r5);
    r4 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r0 = MEMORY.ref(4, r4 + 0x14).get();
    CPU.r9().value = r0;
    r0 = MEMORY.ref(4, r4 + 0x18).get();
    CPU.r12().value = r0;
    r0 = MEMORY.ref(1, r4 + 0x6).getUnsigned();
    r4 = CPU.addT(r4, 0x50);
    MEMORY.call(0x3000659, r0, r1, r2, r3, r4);
  }

  @Method(0x80022ec)
  public static int FUN_80022ec(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  @Method(0x8002dd8)
  public static void FUN_8002dd8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8002df0)
  public static void FUN_8002df0(final int r0) {
    _3001e50.offset(r0 >>> 22 & 0x4).setu(r0);
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

    FUN_8004858();
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

  @Method(0x8002f40)
  public static int getPointerTableEntry(final int index) {
    return ptrTable_8320000.get(index).get();
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

    MEMORY.addFunctions(CopiedSegment3000000.class);

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
        intHandlers_30000e0.get(interruptType).set(getRunnable(CopiedSegment3000000.class, "FUN_8003008"));
      }

      //LAB_80030d8
      INTERRUPTS.INT_MASTER_ENABLE.setu(oldMasterEnable);
    }

    //LAB_80030dc
  }

  @Method(0x80030f8)
  public static void FUN_80030f8(final int r0) {
    System.out.println("Big method");

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
//        SvcHalt();
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
        FUN_80072e4(0x8000000);
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
    throw new RuntimeException("Not implemented");
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
      // So we're just gonna copy a function to the stack and pretend it's normal?
      DMA.channels[3].SAD.setu(0x8002cf4);
      DMA.channels[3].DAD.setu(CPU.sp().value);
      DMA.channels[3].CNT.setu(0x84000000 | size / 4);
      FUN_8007318(0x2002090, r5);
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
      final int r3;
      if(_3001cd4.get() != 0) {
        r3 = 0x80;
      } else {
        //LAB_8003b08
        r3 = 0xc0;
      }

      //LAB_8003b0e
      GPU.BLDCNT.setu(_3001cf8.get() | r3);
      _3001ca0.decr();
      GPU.BLDY.setu(_3001ca8.get() + FUN_80022ec(_3001ac0.get() * (_3001aec.get() - _3001ca8.get()), _3001c98.get()));

      if(_3001ac0.get() == 0) {
        _3001c98.set(0);
      }
    }

    //LAB_8003b68
  }

  @Method(0x8003d04)
  public static void FUN_8003d04() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8003e10)
  public static void FUN_8003e10(final int r0) {
    final int size = 0xe0;
    final int r6 = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8001dc8);
    DMA.channels[3].DAD.setu(r6);
    DMA.channels[3].CNT.setu(0x8400_0000 | size / 4); // 0x38 words, 32-bit, enable

    switch(r6) {
      case 0x3002400 -> MEMORY.addFunctions(CopiedSegment3002400.class);
      default -> throw new RuntimeException("Need to implement overlay");
    }

    FUN_80072fc(r0, 0, 0, 0, 0, 0, r6);
    FUN_8002df0(r6);
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

  @Method(0x8004420)
  public static void FUN_8004420(final int r0) {
    final int r3 = _3001d34.get();
    final int r7 = r0 >> 8;

    if(r3 == 1) {
      int r6 = _3001a20.getAddress();

      //LAB_8004434
      for(int r5 = 20; r5 != 0; r5--) {
        if(MEMORY.ref(1, r6 + 0x5).getUnsigned() == r7) {
          FUN_80072e4(MEMORY.ref(4, r6).get());
        }

        r6 += 0x8;
      }
    }

    //LAB_800444a
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

  @Method(0x8004858)
  public static void FUN_8004858() {
    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(_3001e50.getAddress());
    DMA.channels[3].CNT.setu(0x85000040);
    CPU.sp().value += 0x4;

    _3001e50.setu(0x2030000);
    _3001e54.setu(0x3002000);
  }

  @Method(0x80048b0)
  public static int FUN_80048b0(int r0, int r1) {
    int r2;
    int r3;
    final int r5;
    r5 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, 0x3001e50 + r5).get();
    if(r0 == 0) {
      r3 = CPU.addT(r1, 0x3);
      r3 = CPU.lsrT(r3, 2);
      r0 = MEMORY.ref(4, 0x3001e54).get();
      r1 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r0, r1);
      r2 = CPU.cmpT(r2, 0x30077ff);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = MEMORY.ref(4, 0x3001e50).get();
        r1 = CPU.addT(r0, r1);
        r1 = CPU.cmpT(r1, 0x2040000);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          r0 = 0;
        } else {
          //LAB_80048dc
          MEMORY.ref(4, 0x3001e50).setu(r1);
          MEMORY.ref(4, 0x3001e50 + r5).setu(r0);
        }
      } else {
        //LAB_80048e2
        MEMORY.ref(4, 0x3001e54).setu(r2);
        MEMORY.ref(4, 0x3001e50 + r5).setu(r0);
      }
    }

    //LAB_80048e6
    return r0;
  }

  /** Size param passed in, value returned is a copy destination for code. Maybe a malloc? */
  @Method(0x8004938)
  public static int FUN_8004938(int r0) {
    int r2;
    int r3;

    r3 = (r0 + 0x3) >>> 2;
    r2 = MEMORY.ref(4, 0x3001e54).get();
    r0 = r3 * 0x4;
    r3 = r2 + r0;
    r3 = CPU.cmpT(r3, 0x30077ff);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r2 = MEMORY.ref(4, 0x3001e50).get();
      r0 = r2 + r0;
      r0 = CPU.cmpT(r0, 0x2040000);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        return 0;
      }

      //LAB_800495c
      MEMORY.ref(4, 0x3001e50).setu(r0);
    } else {
      //LAB_8004960
      MEMORY.ref(4, 0x3001e54).setu(r3);
    }

    //LAB_8004962
    //LAB_8004964
    return r2;
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
    Bios.CpuSet(src, dest, lenMode);
  }

  @Method(0x8006868)
  public static void SoundBias0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8006870)
  public static void SoundBias200() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80072e4)
  public static int FUN_80072e4(final int r0) {
    throw new RuntimeException("Not implemented");
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
  public static void FUN_8007318(final int r0, final int r1) {
    MEMORY.call(CPU.sp().value, r0, r1);
  }

  @Method(0x808a008)
  public static void FUN_808a008(final int r0) {
    MEMORY.call(MEMORY.ref(4, 0x808a00c).get(), r0);
  }

  @Method(0x80f9008)
  public static void FUN_80f9008() {
    FUN_80f9438();
  }

  @Method(0x80f9018)
  public static void FUN_80f9018() {
    FUN_80f91e8();
  }

  @Method(0x80f91e8)
  public static void FUN_80f91e8() {
    int r0;
    final int r1;
    int r2;
    int r3;
    int r4;

    r3 = MEMORY.ref(1, 0x2003000).getUnsigned();
    if(r3 != 0) {
      if(r3 == 1) {
        r3 = MEMORY.ref(1, 0x2004214).getUnsigned();
        if(r3 == 0) {
          MEMORY.ref(1, 0x2003000).setu(0);
          MEMORY.ref(2, 0x2003034).setu(0x100);
        }
      } else {
        //LAB_80f920a
        MEMORY.ref(1, 0x2003000).setu(r3 + 0xff);
      }
    }

    //LAB_80f920e
    r2 = MEMORY.ref(2, 0x2003034).get();
    r3 = MEMORY.ref(2, 0x2003008).get();
    r4 = MEMORY.ref(2, 0x2003008).getUnsigned();
    if(r2 != r3) {
      r0 = r2 - r3;
      if(r0 > 0) {
        r3 = r4 + MEMORY.ref(2, 0x2003010).getUnsigned();
      } else {
        //LAB_80f9248
        r3 = r4 - MEMORY.ref(2, 0x2003010).getUnsigned();
      }

      //LAB_80f924e
      MEMORY.ref(2, 0x2003008).setu(r3);
      r4 = MEMORY.ref(2, 0x2003034).getUnsigned();
      r3 = MEMORY.ref(2, 0x2003034).get() - MEMORY.ref(2, 0x2003008).get();
      r3 = r3 ^ r0;

      if(r3 < 0) {
        MEMORY.ref(2, 0x2003008).setu(r4);
      }

      //LAB_80f9268
      FUN_80fb2cc(0x2004290, 0xff, MEMORY.ref(2, 0x2003008).getUnsigned());
    }

    //LAB_80f9272
    r2 = MEMORY.ref(2, 0x2003030).get();
    r3 = MEMORY.ref(2, 0x2003038).get();
    r4 = MEMORY.ref(2, 0x2003038).getUnsigned();

    if(r2 != r3) {
      r0 = r2 - r3;
      if(r0 > 0) {
        r3 = r4 + MEMORY.ref(2, 0x200300c).getUnsigned();
      } else {
        //LAB_80f9292
        r3 = r4 - MEMORY.ref(2, 0x200300c).getUnsigned();
      }

      //LAB_80f9298
      MEMORY.ref(2, 0x2003038).setu(r3);
      r1 = MEMORY.ref(2, 0x2003030).getUnsigned();
      r3 = MEMORY.ref(2, 0x2003030).get() - MEMORY.ref(2, 0x2003038).get();
      r3 = r3 ^ r0;
      if(r3 < 0) {
        MEMORY.ref(2, 0x2003038).setu(r1);
      }

      //LAB_80f92b2
      FUN_80fb2a4(0x2004290, MEMORY.ref(2, 0x2003038).getUnsigned());
      FUN_80fb334(0x2004290, 0xff, (short)(0xf400 + MEMORY.ref(2, 0x2003038).get() * 0xc));
    }

    //LAB_80f92d6
    FUN_80f9c44();
  }

  @Method(0x80f9438)
  public static void FUN_80f9438() {
    FUN_80fa2a0();

    MEMORY.ref(1, 0x200303c).setu(0xff);
    MEMORY.ref(1, 0x2003000).setu(0);
    MEMORY.ref(2, 0x2003034).setu(0x100);
    MEMORY.ref(2, 0x2003008).setu(0x100);
    MEMORY.ref(2, 0x2003010).setu(0x4);
    MEMORY.ref(2, 0x2003030).setu(0x100);
    MEMORY.ref(2, 0x2003038).setu(0x100);
    MEMORY.ref(2, 0x200300c).setu(0x4);
    MEMORY.ref(1, 0x2003014).setu(0);
    MEMORY.ref(1, 0x2003040).setu(0);
    MEMORY.ref(1, 0x2003004).setu(0);

    //LAB_80f94b8
    for(int i = 0; i < 8; i++) {
      MEMORY.ref(2, 0x2003020 + i * 0x2).setu(0);
    }
  }

  @Method(0x80f95e0)
  public static int FUN_80f95e0(final int r0, final int r1) {
    return (int)MEMORY.call(0x80f95e4, r0, r1);
  }

  @Method(0x80f95e4)
  public static int FUN_80f95e4(final int r0, final int r1) {
    final long result80f95e4 = (r0 & 0xffff_ffffL) * (r1 & 0xffff_ffffL);
    final int r2 = (int)result80f95e4;
    final int r3 = (int)(result80f95e4 >>> 32);
    return r3;
  }

  @Method(0x80f9a18)
  public static void FUN_80f9a18(int r0) {
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
    r0 += 0x4;
    MEMORY.ref(4, r0).setu(0);
  }

  @Method(0x80f9a80)
  public static void FUN_80f9a80(int r0) {
    int r1;
    int r2;
    int r3;
    r1 = CPU.movT(0, 0x24);
    r2 = MEMORY.ref(4, 0x80f9ab0).get();

    //LAB_80f9a86
    do {
      r3 = MEMORY.ref(4, r2).get();

      // This if statement was actually a function call but also not really
      if(r2 >>> 25 == 0) {
        r2 = CPU.cmpT(r2, MEMORY.ref(4, 0x80f9ab0).get());
        if(!CPU.cpsr().getCarry() /* unsigned < */ || r2 >>> 14 != 0) {
          //LAB_80f9aaa
          r3 = CPU.movT(0, 0x0);
        }
      }

      MEMORY.ref(4, r0).setu(r3);
      r0 += 0x4;
      r2 = CPU.addT(r2, 0x4);
      r1 = CPU.subT(r1, 0x1);
    } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
  }

  @Method(0x80f9c44)
  public static void FUN_80f9c44() {
    int r1;

    final int r0 = MEMORY.ref(4, 0x3007ff0).get();
    final int r3 = MEMORY.ref(4, r0).get() - 0x68736d53;
    CPU.cmpT(r3, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r1 = MEMORY.ref(1, r0 + 0x4).getUnsigned();
      r1 = CPU.subT(r1, 0x1);
      MEMORY.ref(1, r0 + 0x4).setu(r1);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        MEMORY.ref(1, r0 + 0x4).setu(MEMORY.ref(1, r0 + 0xb).getUnsigned());
        r1 = DMA.channels[1].CNT.get();
        r1 = CPU.lslT(r1, 7);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          DMA.channels[1].CNT.setu(0x84400004);
        }

        //LAB_80f9c6a
        r1 = DMA.channels[2].SAD.get();
        r1 = CPU.lslT(r1, 7);
        if(CPU.cpsr().getCarry()) { // unsigned >=
          DMA.channels[2].SAD.setu(0x80f9c8c);
        }

        //LAB_80f9c74
        DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
        DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);
        DMA.channels[1].CNT.offset(2, 0x2).setu(0xb600);
        DMA.channels[2].CNT.offset(2, 0x2).setu(0xb600);
      }
    }

    //LAB_80f9c84
  }

  @Method(0x80f9c90)
  public static void FUN_80f9c90(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    r2 = MEMORY.ref(4, 0x80f9ef4).get();
    r3 = MEMORY.ref(4, r0 + 0x34).get();
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      return;
    }

    //LAB_80f9c9a
    r3 = CPU.addT(r3, 0x1);
    MEMORY.ref(4, r0 + 0x34).setu(r3);

    r3 = MEMORY.ref(4, r0 + 0x38).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      MEMORY.call(r3, MEMORY.ref(4, r0 + 0x3c).get());
    }

    //LAB_80f9cac
    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r7 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, r7 + 0x4).get();
    CPU.cmpT(r0, 0x0);
    jmp_80f9ed8:
    if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
      //LAB_80f9cc4
      r0 = MEMORY.ref(4, 0x80f9ef0).get();
      r0 = MEMORY.ref(4, r0).get();
      CPU.r8().value = r0;
      r0 = CPU.addT(r7, 0x0);
      FUN_80fab7c(r0);
      r0 = MEMORY.ref(4, r7 + 0x4).get();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
        //LAB_80f9cd8
        r0 = MEMORY.ref(2, r7 + 0x22).getUnsigned();
        r1 = MEMORY.ref(2, r7 + 0x20).getUnsigned();
        r0 = CPU.addT(r0, r1);

        //LAB_80f9e28
        MEMORY.ref(2, r7 + 0x22).setu(r0);
        CPU.cmpT(r0, 0x96);

        //LAB_80f9ce0
        while(CPU.cpsr().getCarry()) { // unsigned >=
          r6 = MEMORY.ref(1, r7 + 0x8).getUnsigned();
          r5 = MEMORY.ref(4, r7 + 0x2c).get();
          r3 = CPU.movT(0, 0x1);
          r4 = CPU.movT(0, 0x0);

          //LAB_80f9ce8
          do {
            r0 = MEMORY.ref(1, r5).getUnsigned();
            r1 = CPU.movT(0, 0x80);
            r1 = CPU.tstT(r1, r0);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_80f9cf2
              CPU.r10().value = r3;
              r4 = CPU.orrT(r4, r3);
              CPU.r11().value = r4;
              r4 = MEMORY.ref(4, r5 + 0x20).get();
              CPU.cmpT(r4, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80f9cfe
                do {
                  r1 = MEMORY.ref(1, r4).getUnsigned();
                  r0 = CPU.movT(0, 0xc7);
                  r0 = CPU.tstT(r0, r1);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = MEMORY.ref(1, r4 + 0x10).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.subT(r0, 0x1);
                      MEMORY.ref(1, r4 + 0x10).setu(r0);
                      if(CPU.cpsr().getZero()) { // ==
                        r0 = CPU.movT(0, 0x40);
                        r1 = CPU.orrT(r1, r0);
                        MEMORY.ref(1, r4).setu(r1);
                      }
                    }
                  } else {
                    //LAB_80f9d1a
                    r0 = CPU.addT(r4, 0x0);
                    FUN_80fa678(r0);
                  }

                  //LAB_80f9d20
                  r4 = MEMORY.ref(4, r4 + 0x34).get();
                  CPU.cmpT(r4, 0x0);
                } while(!CPU.cpsr().getZero()); // !=
              }

              //LAB_80f9d26
              r3 = MEMORY.ref(1, r5).getUnsigned();
              r0 = CPU.movT(0, 0x40);
              r0 = CPU.tstT(r0, r3);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = CPU.addT(r5, 0x0);
                FUN_80fa68c(r0);
                r0 = CPU.movT(0, 0x80);
                MEMORY.ref(1, r5).setu(r0);
                r0 = CPU.movT(0, 0x2);
                MEMORY.ref(1, r5 + 0xf).setu(r0);
                r0 = CPU.movT(0, 0x40);
                MEMORY.ref(1, r5 + 0x13).setu(r0);
                r0 = CPU.movT(0, 0x16);
                MEMORY.ref(1, r5 + 0x19).setu(r0);
                r0 = CPU.movT(0, 0x1);
                r1 = CPU.addT(r5, 0x6);
                MEMORY.ref(1, r1 + 0x1e).setu(r0);
              }

              //LAB_80f9da4
              r0 = MEMORY.ref(1, r5 + 0x1).getUnsigned();
              CPU.cmpT(r0, 0x0);

              jmp_80f9e00:
              {
                //LAB_80f9d4c
                while(CPU.cpsr().getZero()) { // ==
                  r2 = MEMORY.ref(4, r5 + 0x40).get();
                  r1 = MEMORY.ref(1, r2).getUnsigned();
                  CPU.cmpT(r1, 0x80);
                  if(!CPU.cpsr().getCarry()) { // unsigned <
                    r1 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
                  } else {
                    //LAB_80f9d58
                    r2 = CPU.addT(r2, 0x1);
                    MEMORY.ref(4, r5 + 0x40).setu(r2);
                    CPU.cmpT(r1, 0xbd);
                    if(CPU.cpsr().getCarry()) { // unsigned >=
                      MEMORY.ref(1, r5 + 0x7).setu(r1);
                    }
                  }

                  //LAB_80f9d62
                  CPU.cmpT(r1, 0xcf);
                  if(CPU.cpsr().getCarry()) { // unsigned >=
                    r0 = CPU.r8().value;
                    r3 = MEMORY.ref(4, r0 + 0x38).get();
                    r0 = CPU.addT(r1, 0x0);
                    r0 = CPU.subT(r0, 0xcf);
                    r1 = CPU.addT(r7, 0x0);
                    r2 = CPU.addT(r5, 0x0);
                    FUN_80f9ee8(r0, r1, r2, r3);
                  } else {
                    //LAB_80f9d78
                    CPU.cmpT(r1, 0xb0);
                    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
                      r0 = CPU.addT(r1, 0x0);
                      r0 = CPU.subT(r0, 0xb1);
                      MEMORY.ref(1, r7 + 0xa).setu(r0);
                      r3 = CPU.r8().value;
                      r3 = MEMORY.ref(4, r3 + 0x34).get();
                      r0 = CPU.lslT(r0, 2);
                      r3 = MEMORY.ref(4, r3 + r0).get();
                      r0 = CPU.addT(r7, 0x0);
                      r1 = CPU.addT(r5, 0x0);
                      FUN_80f9ee8(r0, r1, r2, r3);
                      r0 = MEMORY.ref(1, r5).getUnsigned();
                      CPU.cmpT(r0, 0x0);
                      if(CPU.cpsr().getZero()) { // ==
                        break jmp_80f9e00;
                      }
                    } else {
                      //LAB_80f9d9a
                      r0 = MEMORY.ref(4, 0x80f9eec).get();
                      r1 = CPU.subT(r1, 0x80);
                      r1 = CPU.addT(r1, r0);
                      r0 = MEMORY.ref(1, r1).getUnsigned();
                      MEMORY.ref(1, r5 + 0x1).setu(r0);
                    }
                  }

                  r0 = MEMORY.ref(1, r5 + 0x1).getUnsigned();
                  CPU.cmpT(r0, 0x0);
                }

                r0 = CPU.subT(r0, 0x1);
                MEMORY.ref(1, r5 + 0x1).setu(r0);
                r1 = MEMORY.ref(1, r5 + 0x19).getUnsigned();
                CPU.cmpT(r1, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = MEMORY.ref(1, r5 + 0x17).getUnsigned();
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = MEMORY.ref(1, r5 + 0x1c).getUnsigned();
                    CPU.cmpT(r0, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = CPU.subT(r0, 0x1);
                      MEMORY.ref(1, r5 + 0x1c).setu(r0);
                    } else {
                      //LAB_80f9dc6
                      r0 = MEMORY.ref(1, r5 + 0x1a).getUnsigned();
                      r0 = CPU.addT(r0, r1);
                      MEMORY.ref(1, r5 + 0x1a).setu(r0);
                      r1 = CPU.addT(r0, 0x0);
                      r0 = CPU.subT(r0, 0x40);
                      r0 = CPU.lslT(r0, 24);
                      if(CPU.cpsr().getNegative()) { // negative
                        r2 = CPU.lslT(r1, 24);
                        r2 = CPU.asrT(r2, 24);
                      } else {
                        //LAB_80f9dda
                        r0 = CPU.movT(0, 0x80);
                        r2 = CPU.subT(r0, r1);
                      }

                      //LAB_80f9dde
                      r0 = MEMORY.ref(1, r5 + 0x17).getUnsigned();
                      r0 = CPU.mulT(r0, r2);
                      r2 = CPU.asrT(r0, 6);
                      r0 = MEMORY.ref(1, r5 + 0x16).getUnsigned();
                      r0 = CPU.eorT(r0, r2);
                      r0 = CPU.lslT(r0, 24);
                      if(!CPU.cpsr().getZero()) { // !=
                        MEMORY.ref(1, r5 + 0x16).setu(r2);
                        r0 = MEMORY.ref(1, r5).getUnsigned();
                        r1 = MEMORY.ref(1, r5 + 0x18).getUnsigned();
                        CPU.cmpT(r1, 0x0);
                        if(CPU.cpsr().getZero()) { // ==
                          r1 = CPU.movT(0, 0xc);
                        } else {
                          //LAB_80f9dfa
                          r1 = CPU.movT(0, 0x3);
                        }

                        //LAB_80f9dfc
                        r0 = CPU.orrT(r0, r1);
                        MEMORY.ref(1, r5).setu(r0);
                      }
                    }
                  }
                }
              }

              //LAB_80f9e00
              r3 = CPU.r10().value;
              r4 = CPU.r11().value;
            }

            //LAB_80f9e04
            r6 = CPU.subT(r6, 0x1);
            if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
              break;
            }
            r0 = CPU.movT(0, 0x50);
            r5 = CPU.addT(r5, r0);
            r3 = CPU.lslT(r3, 1);
          } while(true);

          //LAB_80f9e10
          r0 = MEMORY.ref(4, r7 + 0xc).get();
          r0 = CPU.addT(r0, 0x1);
          MEMORY.ref(4, r7 + 0xc).setu(r0);
          CPU.cmpT(r4, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x80);
            r0 = CPU.lslT(r0, 24);
            MEMORY.ref(4, r7 + 0x4).setu(r0);
            break jmp_80f9ed8;
          }

          //LAB_80f9e22
          MEMORY.ref(4, r7 + 0x4).setu(r4);
          r0 = MEMORY.ref(2, r7 + 0x22).getUnsigned();
          r0 = CPU.subT(r0, 0x96);

          MEMORY.ref(2, r7 + 0x22).setu(r0);
          CPU.cmpT(r0, 0x96);
        }

        //LAB_80f9e30
        r2 = MEMORY.ref(1, r7 + 0x8).getUnsigned();
        r5 = MEMORY.ref(4, r7 + 0x2c).get();

        //LAB_80f9e34
        do {
          r0 = MEMORY.ref(1, r5).getUnsigned();
          r1 = CPU.movT(0, 0x80);
          r1 = CPU.tstT(r1, r0);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = CPU.movT(0, 0xf);
            r1 = CPU.tstT(r1, r0);
            if(!CPU.cpsr().getZero()) { // !=
              CPU.r9().value = r2;
              r0 = CPU.addT(r7, 0x0);
              r1 = CPU.addT(r5, 0x0);
              FUN_80fac44(r0, r1);
              r4 = MEMORY.ref(4, r5 + 0x20).get();
              CPU.cmpT(r4, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_80f9e52
                do {
                  r1 = MEMORY.ref(1, r4).getUnsigned();
                  r0 = CPU.movT(0, 0xc7);
                  r0 = CPU.tstT(r0, r1);
                  if(CPU.cpsr().getZero()) { // ==
                    r0 = CPU.addT(r4, 0x0);
                    FUN_80fa678(r0);
                  } else {
                    //LAB_80f9e62
                    r0 = MEMORY.ref(1, r4 + 0x1).getUnsigned();
                    r6 = CPU.movT(0, 0x7);
                    r6 = CPU.andT(r6, r0);
                    r3 = MEMORY.ref(1, r5).getUnsigned();
                    r0 = CPU.movT(0, 0x3);
                    r0 = CPU.tstT(r0, r3);
                    if(!CPU.cpsr().getZero()) { // !=
                      FUN_80f9f3c(0, 0, 0, 0, r4, r5);
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r0 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                        r1 = CPU.movT(0, 0x1);
                        r0 = CPU.orrT(r0, r1);
                        MEMORY.ref(1, r4 + 0x1d).setu(r0);
                      }
                    }

                    //LAB_80f9e80
                    r3 = MEMORY.ref(1, r5).getUnsigned();
                    r0 = CPU.movT(0, 0xc);
                    r0 = CPU.tstT(r0, r3);
                    if(!CPU.cpsr().getZero()) { // !=
                      r1 = MEMORY.ref(1, r4 + 0x8).getUnsigned();
                      r0 = CPU.movT(0, 0x8);
                      r0 = MEMORY.ref(1, r5 + r0).get();
                      r2 = CPU.addT(r1, r0);
                      if(CPU.cpsr().getNegative()) { // negative
                        r2 = CPU.movT(0, 0x0);
                      }

                      //LAB_80f9e94
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r0 = CPU.r8().value;
                        r3 = MEMORY.ref(4, r0 + 0x30).get();
                        r1 = CPU.addT(r2, 0x0);
                        r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
                        r0 = CPU.addT(r6, 0x0);
                        r0 = FUN_80f9ee8(r0, r1, r2, r3);
                        MEMORY.ref(4, r4 + 0x20).setu(r0);
                        r0 = MEMORY.ref(1, r4 + 0x1d).getUnsigned();
                        r1 = CPU.movT(0, 0x2);
                        r0 = CPU.orrT(r0, r1);
                        MEMORY.ref(1, r4 + 0x1d).setu(r0);
                      } else {
                        //LAB_80f9eb2
                        r1 = CPU.addT(r2, 0x0);
                        r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
                        r0 = MEMORY.ref(4, r4 + 0x24).get();
                        r0 = FUN_80fa1fc(r0, r1, r2);
                        MEMORY.ref(4, r4 + 0x20).setu(r0);
                      }
                    }
                  }

                  //LAB_80f9ebe
                  r4 = MEMORY.ref(4, r4 + 0x34).get();
                  CPU.cmpT(r4, 0x0);
                } while(!CPU.cpsr().getZero()); // !=
              }

              //LAB_80f9ec4
              r0 = MEMORY.ref(1, r5).getUnsigned();
              r1 = CPU.movT(0, 0xf0);
              r0 = CPU.andT(r0, r1);
              MEMORY.ref(1, r5).setu(r0);
              r2 = CPU.r9().value;
            }
          }

          //LAB_80f9ece
          r2 = CPU.subT(r2, 0x1);
          if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
            break;
          }
          r0 = CPU.movT(0, 0x50);
          r5 = CPU.addT(r5, r0);
        } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
      }
    }

    //LAB_80f9ed8
    r0 = MEMORY.ref(4, 0x80f9ef4).get();
    MEMORY.ref(4, r7 + 0x34).setu(r0);
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x80f9ee8)
  public static int FUN_80f9ee8(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x80f9f3c)
  public static void FUN_80f9f3c(int r0, int r1, int r2, int r3, final int r4, final int r5) {
    r1 = MEMORY.ref(1, r4 + 0x12).getUnsigned();
    r0 = CPU.movT(0, 0x14);
    r2 = MEMORY.ref(1, r4 + r0).get();
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.mulT(r3, r1);
    r0 = MEMORY.ref(1, r5 + 0x10).getUnsigned();
    r0 = CPU.mulT(r0, r3);
    r0 = CPU.asrT(r0, 14);
    CPU.cmpT(r0, 0xff);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0xff);
    }

    //LAB_80f9f54
    MEMORY.ref(1, r4 + 0x2).setu(r0);
    r3 = CPU.movT(0, 0x7f);
    r3 = CPU.subT(r3, r2);
    r3 = CPU.mulT(r3, r1);
    r0 = MEMORY.ref(1, r5 + 0x11).getUnsigned();
    r0 = CPU.mulT(r0, r3);
    r0 = CPU.asrT(r0, 14);
    CPU.cmpT(r0, 0xff);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0xff);
    }

    //LAB_80f9f68
    MEMORY.ref(1, r4 + 0x3).setu(r0);
  }

  @Method(0x80fa1fc)
  public static int FUN_80fa1fc(int r0, int r1, int r2) {
    final int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.r12().value = r0;
    r1 = CPU.lslT(r1, 24);
    r6 = CPU.lsrT(r1, 24);
    r7 = CPU.lslT(r2, 24);
    CPU.cmpT(r6, 0xb2);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r6 = CPU.movT(0, 0xb2);
      r7 = CPU.movT(0, 0xff);
      r7 = CPU.lslT(r7, 24);
    }

    //LAB_80fa210
    r3 = MEMORY.ref(4, 0x80fa258).get();
    r0 = CPU.addT(r6, r3);
    r5 = MEMORY.ref(1, r0).getUnsigned();
    r4 = MEMORY.ref(4, 0x80fa25c).get();
    r2 = CPU.movT(0, 0xf);
    r0 = CPU.addT(r5, 0x0);
    r0 = CPU.andT(r0, r2);
    r0 = CPU.lslT(r0, 2);
    r0 = CPU.addT(r0, r4);
    r1 = CPU.lsrT(r5, 4);
    r5 = MEMORY.ref(4, r0).get();
    r5 = CPU.lsrT(r5, r1);
    r0 = CPU.addT(r6, 0x1);
    r0 = CPU.addT(r0, r3);
    r1 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r1, 0x0);
    r0 = CPU.andT(r0, r2);
    r0 = CPU.lslT(r0, 2);
    r0 = CPU.addT(r0, r4);
    r1 = CPU.lsrT(r1, 4);
    r0 = MEMORY.ref(4, r0).get();
    r0 = CPU.lsrT(r0, r1);
    r1 = CPU.r12().value;
    r4 = MEMORY.ref(4, r1 + 0x4).get();
    r0 = CPU.subT(r0, r5);
    r1 = CPU.addT(r7, 0x0);
    r0 = FUN_80f95e0(r0, r1);
    r1 = CPU.addT(r0, 0x0);
    r1 = CPU.addT(r5, r1);
    r0 = CPU.addT(r4, 0x0);
    r0 = FUN_80f95e0(r0, r1);

    return r0;
  }

  @Method(0x80fa2a0)
  public static void FUN_80fa2a0() {
    CpuSet(MEMORY.ref(4, 0x80fa2f4).get() & ~0x1, 0x3007000, 0x4000100);
    FUN_80fa6a0(0x2003050);
    FUN_80fa55c(0x2004090);
    FUN_80fa83c(0x97f800);

    int r5 = 0x80fc624;
    int r6 = 8;

    //LAB_80fa2d2
    do {
      final int r4 = MEMORY.ref(4, r5).get();
      FUN_80fa9e0(r4, MEMORY.ref(4, r5 + 0x4).get(), MEMORY.ref(1, r5 + 0x8).getUnsigned());
      MEMORY.ref(1, r4 + 0xb).setu(MEMORY.ref(2, r5 + 0xa).getUnsigned());
      MEMORY.ref(4, r4 + 0x18).setu(0x2004350);
      r5 += 0xc;
      r6--;
    } while(r6 != 0);

    //LAB_80fa2ee
  }

  @Method(0x80fa55c)
  public static void FUN_80fa55c(int r0) {
    int r1;
    int r2;
    final int r3;
    final int r4;
    final int r5;
    int r6;

    CPU.sp().value -= 0x4;
    r5 = CPU.addT(r0, 0x0);
    r1 = MEMORY.ref(4, 0x80fa624).get();
    r0 = CPU.movT(0, 0x8f);
    MEMORY.ref(2, r1).setu(r0);
    r3 = MEMORY.ref(4, 0x80fa628).get();
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r3).setu(r2); // SOUNDCNT_L
    r0 = MEMORY.ref(4, 0x80fa62c).get();
    r1 = CPU.movT(0, 0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_H
    r0 = CPU.addT(r0, 0x6);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_L
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_L
    r0 = CPU.subT(r0, 0x14);
    r1 = CPU.movT(0, 0x80);
    MEMORY.ref(1, r0).setu(r1); // SOUND1CNT_X
    r0 = CPU.addT(r0, 0x8);
    MEMORY.ref(1, r0).setu(r1); // SOUND2CNT_H
    r0 = CPU.addT(r0, 0x10);
    MEMORY.ref(1, r0).setu(r1); // SOUND4CNT_H
    r0 = CPU.subT(r0, 0xd);
    MEMORY.ref(1, r0).setu(r2); // SOUND3CNT_L
    r0 = CPU.movT(0, 0x77);
    MEMORY.ref(1, r3).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa630).get();
    r4 = MEMORY.ref(4, r0).get();
    r6 = MEMORY.ref(4, r4).get();
    r0 = MEMORY.ref(4, 0x80fa634).get();
    r6 = CPU.cmpT(r6, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r6, 0x1);
      MEMORY.ref(4, r4).setu(r0);
      r1 = MEMORY.ref(4, 0x80fa638).get();
      r0 = MEMORY.ref(4, 0x80fa63c).get();
      MEMORY.ref(4, r1 + 0x20).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa640).get();
      MEMORY.ref(4, r1 + 0x44).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa644).get();
      MEMORY.ref(4, r1 + 0x4c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa648).get();
      MEMORY.ref(4, r1 + 0x70).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa64c).get();
      MEMORY.ref(4, r1 + 0x74).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa650).get();
      MEMORY.ref(4, r1 + 0x78).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa654).get();
      MEMORY.ref(4, r1 + 0x7c).setu(r0);
      r2 = CPU.addT(r1, 0x0);
      r2 = CPU.addT(r2, 0x80);
      r0 = MEMORY.ref(4, 0x80fa658).get();
      MEMORY.ref(4, r2).setu(r0);
      r1 = CPU.addT(r1, 0x84);
      r0 = MEMORY.ref(4, 0x80fa65c).get();
      MEMORY.ref(4, r1).setu(r0);
      MEMORY.ref(4, r4 + 0x1c).setu(r5);
      r0 = MEMORY.ref(4, 0x80fa660).get();
      MEMORY.ref(4, r4 + 0x28).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa664).get();
      MEMORY.ref(4, r4 + 0x2c).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa668).get();
      MEMORY.ref(4, r4 + 0x30).setu(r0);
      r0 = MEMORY.ref(4, 0x80fa66c).get();
      r1 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r4 + 0xc).setu(r0);
      MEMORY.ref(4, CPU.sp().value).setu(r1);
      r2 = MEMORY.ref(4, 0x80fa670).get();
      r0 = CPU.sp().value;
      r1 = CPU.addT(r5, 0x0);
      CpuSet(r0, r1, r2);
      r0 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r5 + 0x1).setu(r0);
      r0 = CPU.movT(0, 0x11);
      MEMORY.ref(1, r5 + 0x1c).setu(r0);
      r1 = CPU.addT(r5, 0x0);
      r1 = CPU.addT(r1, 0x41);
      r0 = CPU.movT(0, 0x2);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0, 0x22);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x25);
      r0 = CPU.movT(0, 0x3);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x1b);
      r0 = CPU.movT(0, 0x44);
      MEMORY.ref(1, r1).setu(r0);
      r1 = CPU.addT(r1, 0x24);
      r0 = CPU.movT(0, 0x4);
      MEMORY.ref(1, r1 + 0x1).setu(r0);
      r0 = CPU.movT(0, 0x88);
      MEMORY.ref(1, r1 + 0x1c).setu(r0);
      MEMORY.ref(4, r4).setu(r6);
    }

    //LAB_80fa61c
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa678)
  public static void FUN_80fa678(final int r0) {
    FUN_80072e8(r0, MEMORY.ref(4, 0x2004088).get());
  }

  @Method(0x80fa68c)
  public static void FUN_80fa68c(final int r0) {
    int r1;
    r1 = MEMORY.ref(4, 0x80fa69c).get();
    r1 = MEMORY.ref(4, r1).get();
    FUN_80072e8(r0, r1);
  }

  @Method(0x80fa6a0)
  public static void FUN_80fa6a0(final int r0) {
    CPU.sp().value -= 0x4;
    MEMORY.ref(4, r0).setu(0);

    if((DMA.channels[1].CNT.get() & 0x2000000) != 0) {
      DMA.channels[1].CNT.setu(0x84400004);
    }

    //LAB_80fa6bc
    if((DMA.channels[2].CNT.get() & 0x2000000) != 0) {
      DMA.channels[2].CNT.setu(0x84400004);
    }

    //LAB_80fa6ca
    DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
    DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);
    MEMORY.ref(2, 0x4000084).setu(0x8f); // SOUNDCNT_X
    MEMORY.ref(2, 0x4000082).setu(0xa90e); // SOUNDCNT_H
    MEMORY.ref(1, 0x4000089).and(0x3f).oru(0x40); // SOUNDBIAS (upper byte)
    DMA.channels[1].SAD.setu(r0 + 0x350);
    DMA.channels[1].DAD.setu(0x40000a0);
    DMA.channels[2].SAD.setu(r0 + 0x980);
    DMA.channels[2].DAD.setu(0x40000a4);
    MEMORY.ref(4, 0x3007ff0).setu(r0);
    MEMORY.ref(4, CPU.sp().value).setu(0);
    CpuSet(CPU.sp().value, r0, 0x50003ec);
    MEMORY.ref(1, r0 + 0x6).setu(0x8);
    MEMORY.ref(1, r0 + 0x7).setu(0xf);
    MEMORY.ref(4, r0 + 0x38).setu(0x80f9f6d);
    MEMORY.ref(4, r0 + 0x28).setu(0x80fb791);
    MEMORY.ref(4, r0 + 0x2c).setu(0x80fb791);
    MEMORY.ref(4, r0 + 0x30).setu(0x80fb791);
    MEMORY.ref(4, r0 + 0x3c).setu(0x80fb791);
    FUN_80f9a80(0x2004000);
    MEMORY.ref(4, r0 + 0x34).setu(0x2004000);
    FUN_80fa798(0x40000);
    MEMORY.ref(4, r0).setu(0x68736d53);
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa798)
  public static void FUN_80fa798(int r0) {
    int r1;
    int r2;
    int r4;
    final int r5;
    final int r6;

    r2 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80fa818).get();
    r4 = MEMORY.ref(4, r0).get();
    r0 = CPU.movT(0, 0xf0);
    r0 = CPU.lslT(r0, 12);
    r0 = CPU.andT(r0, r2);
    r2 = CPU.lsrT(r0, 16);
    r6 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r4 + 0x8).setu(r2);
    r1 = MEMORY.ref(4, 0x80fa81c).get();
    r0 = CPU.subT(r2, 0x1);
    r0 = CPU.lslT(r0, 1);
    r0 = CPU.addT(r0, r1);
    r5 = MEMORY.ref(2, r0).getUnsigned();
    MEMORY.ref(4, r4 + 0x10).setu(r5);
    r0 = CPU.movT(0, 0xc6);
    r0 = CPU.lslT(r0, 3);
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_80022ec(r0, r1);
    MEMORY.ref(1, r4 + 0xb).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa820).get();
    r0 = CPU.mulT(r0, r5);
    r1 = MEMORY.ref(4, 0x80fa824).get();
    r0 = CPU.addT(r0, r1);
    r1 = MEMORY.ref(4, 0x80fa828).get();
    r0 = FUN_80022ec(r0, r1);
    r1 = CPU.addT(r0, 0x0);
    MEMORY.ref(4, r4 + 0x14).setu(r1);
    r0 = CPU.movT(0, 0x80);
    r0 = CPU.lslT(r0, 17);
    r0 = FUN_80022ec(r0, r1);
    r0 = CPU.addT(r0, 0x1);
    r0 = CPU.asrT(r0, 1);
    MEMORY.ref(4, r4 + 0x18).setu(r0);
    r0 = MEMORY.ref(4, 0x80fa82c).get();
    MEMORY.ref(2, r0).setu(r6); // TM0CNT_H
    r4 = MEMORY.ref(4, 0x80fa830).get();
    r0 = MEMORY.ref(4, 0x80fa834).get();
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_80022ec(r0, r1);
    r0 = CPU.negT(r0, r0);
    MEMORY.ref(2, r4).setu(r0); // TM0CNT_L
    FUN_80fa9a4();

    //LAB_80fa7fc
    do {
      r0 = GPU.VCOUNT.getUnsigned();
      CPU.cmpT(r0, 0x9f);
    } while(CPU.cpsr().getZero()); // ==

    //LAB_80fa804
    do {
      r0 = GPU.VCOUNT.getUnsigned();
      CPU.cmpT(r0, 0x9f);
    } while(!CPU.cpsr().getZero()); // !=

    TIMERS.timers[0].CNT_H.setu(0x80); // start timer 0
  }

  @Method(0x80fa83c)
  public static void FUN_80fa83c(int r0) {
    int r1;
    final int r2;
    final int r3;
    int r4;
    final int r5;

    r3 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80fa8c8).get();
    r5 = MEMORY.ref(4, r0).get();
    r1 = MEMORY.ref(4, r5).get();
    r0 = MEMORY.ref(4, 0x80fa8cc).get();
    r1 = CPU.cmpT(r1, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r1, 0x1);
      MEMORY.ref(4, r5).setu(r0);
      r4 = CPU.movT(0, 0xff);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0x7f);
        r4 = CPU.andT(r4, r0);
        MEMORY.ref(1, r5 + 0x5).setu(r4);
      }

      //LAB_80fa85e
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 4);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 8);
        MEMORY.ref(1, r5 + 0x6).setu(r0);
        r4 = CPU.movT(0, 0xc);
        r0 = CPU.addT(r5, 0x0);
        r0 = CPU.addT(r0, 0x50);
        r1 = CPU.movT(0, 0x0);

        //LAB_80fa874
        do {
          MEMORY.ref(1, r0).setu(r1);
          r4 = CPU.subT(r4, 0x1);
          r0 = CPU.addT(r0, 0x40);
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80fa87e
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 8);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.lsrT(r4, 12);
        MEMORY.ref(1, r5 + 0x7).setu(r0);
      }

      //LAB_80fa88c
      r4 = CPU.movT(0, 0xb0);
      r4 = CPU.lslT(r4, 16);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = CPU.movT(0, 0xc0);
        r0 = CPU.lslT(r0, 14);
        r0 = CPU.andT(r0, r4);
        r4 = CPU.lsrT(r0, 14);
        r2 = MEMORY.ref(4, 0x80fa8d0).get();
        r1 = MEMORY.ref(1, r2).getUnsigned();
        r0 = CPU.movT(0, 0x3f);
        r0 = CPU.andT(r0, r1);
        r0 = CPU.orrT(r0, r4);
        MEMORY.ref(1, r2).setu(r0);
      }

      //LAB_80fa8aa
      r4 = CPU.movT(0, 0xf0);
      r4 = CPU.lslT(r4, 12);
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        FUN_80fa928();
        r0 = CPU.addT(r4, 0x0);
        FUN_80fa798(r0);
      }

      //LAB_80fa8be
      r0 = MEMORY.ref(4, 0x80fa8cc).get();
      MEMORY.ref(4, r5).setu(r0);
    }

    //LAB_80fa8c2
  }

  @Method(0x80fa928)
  public static void FUN_80fa928() {
    CPU.sp().value -= 0x4;

    final int r2 = MEMORY.ref(4, 0x3007ff0).get();
    final int r1 = MEMORY.ref(4, r2).get();
    final int r0 = r1 + 0x978c_92ad;
    CPU.cmpT(r0, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      MEMORY.ref(4, r2).setu(r1 + 0xa);

      if((DMA.channels[1].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[1].CNT.setu(0x8440_0004);
      }

      //LAB_80fa952
      if((DMA.channels[2].CNT.get() & 0x200_0000) != 0) {
        DMA.channels[2].CNT.setu(0x8440_0004);
      }

      //LAB_80fa960
      DMA.channels[1].CNT.offset(2, 0x2).setu(0x400);
      DMA.channels[2].CNT.offset(2, 0x2).setu(0x400);

      MEMORY.ref(4, CPU.sp().value).setu(0);
      CpuSet(CPU.sp().value, r2 + 0x350, 0x500_0318);
    }

    //LAB_80fa980
    CPU.sp().value += 0x4;
  }

  @Method(0x80fa9a4)
  public static void FUN_80fa9a4() {
    final int r2 = MEMORY.ref(4, 0x3007ff0).get();
    final int r3 = MEMORY.ref(4, r2).get();

    if(r3 != 0x68736d53) { // Magic number for MP2K? https://github.com/mgba-emu/mgba/blob/master/include/mgba/internal/gba/audio.h
      DMA.channels[1].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      DMA.channels[2].CNT.offset(2, 0x2).setu(0xb600); // Enable, special (sound), 32-bit, repeat
      MEMORY.ref(1, r2 + 0x4).setu(0);
      MEMORY.ref(4, r2).setu(r3 - 0xa);
    }

    //LAB_80fa9cc
  }

  @Method(0x80fa9e0)
  public static void FUN_80fa9e0(int r0, int r1, int r2) {
    int r4;
    final int r5;
    int r6;
    final int r7;

    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r1, 0x0);
    r2 = CPU.lslT(r2, 24);
    r4 = CPU.lsrT(r2, 24);
    CPU.cmpT(r4, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r4, 0x10);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r4 = CPU.movT(0, 0x10);
      }

      //LAB_80fa9f4
      r0 = MEMORY.ref(4, 0x80faa4c).get();
      r5 = MEMORY.ref(4, r0).get();
      r1 = MEMORY.ref(4, r5).get();
      r0 = MEMORY.ref(4, 0x80faa50).get();
      r1 = CPU.cmpT(r1, r0);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, r5).setu(r0);
        r0 = CPU.addT(r7, 0x0);
        FUN_80fa68c(r0);
        MEMORY.ref(4, r7 + 0x2c).setu(r6);
        MEMORY.ref(1, r7 + 0x8).setu(r4);
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 24);
        MEMORY.ref(4, r7 + 0x4).setu(r0);
        CPU.cmpT(r4, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0x0);

          //LAB_80faa1a
          do {
            MEMORY.ref(1, r6).setu(r1);
            r0 = CPU.subT(r4, 0x1);
            r0 = CPU.lslT(r0, 24);
            r4 = CPU.lsrT(r0, 24);
            r6 = CPU.addT(r6, 0x50);
            CPU.cmpT(r4, 0x0);
          } while(!CPU.cpsr().getZero()); // !=
        }

        //LAB_80faa28
        r0 = MEMORY.ref(4, r5 + 0x20).get();
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(4, r7 + 0x38).setu(r0);
          r0 = MEMORY.ref(4, r5 + 0x24).get();
          MEMORY.ref(4, r7 + 0x3c).setu(r0);
          r0 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r5 + 0x20).setu(r0);
        }

        //LAB_80faa38
        MEMORY.ref(4, r5 + 0x24).setu(r7);
        r0 = MEMORY.ref(4, 0x80faa54).get();
        MEMORY.ref(4, r5 + 0x20).setu(r0);
        r0 = MEMORY.ref(4, 0x80faa50).get();
        MEMORY.ref(4, r5).setu(r0);
        MEMORY.ref(4, r7 + 0x34).setu(r0);
      }
    }

    //LAB_80faa44
  }

  @Method(0x80fab7c)
  public static void FUN_80fab7c(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80fac44)
  public static void FUN_80fac44(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80fae58)
  public static void FUN_80fae58(final int r0) {
    //TODO implement
  }

  @Method(0x80fb2a4)
  public static void FUN_80fb2a4(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80fb2cc)
  public static void FUN_80fb2cc(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r4 = CPU.addT(r0, 0x0);
    r1 = CPU.lslT(r1, 16);
    r7 = CPU.lsrT(r1, 16);
    r6 = CPU.lslT(r2, 16);
    r3 = MEMORY.ref(4, r4 + 0x34).get();
    r0 = MEMORY.ref(4, 0x80fb330).get();
    r3 = CPU.cmpT(r3, r0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.addT(r3, 0x1);
      MEMORY.ref(4, r4 + 0x34).setu(r0);
      r2 = MEMORY.ref(1, r4 + 0x8).getUnsigned();
      r1 = MEMORY.ref(4, r4 + 0x2c).get();
      r5 = CPU.movT(0, 0x1);
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = CPU.movT(0, 0x80);
        CPU.r8().value = r0;
        r6 = CPU.lsrT(r6, 18);
        r0 = CPU.movT(0, 0x3);
        CPU.r12().value = r0;

        //LAB_80fb2fc
        do {
          r0 = CPU.addT(r7, 0x0);
          r0 = CPU.andT(r0, r5);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = MEMORY.ref(1, r1).getUnsigned();
            r0 = CPU.r8().value;
            r0 = CPU.andT(r0, r3);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              MEMORY.ref(1, r1 + 0x13).setu(r6);
              r0 = CPU.r12().value;
              r0 = CPU.orrT(r0, r3);
              MEMORY.ref(1, r1).setu(r0);
            }
          }

          //LAB_80fb316
          r2 = CPU.subT(r2, 0x1);
          r1 = CPU.addT(r1, 0x50);
          r5 = CPU.lslT(r5, 1);
          CPU.cmpT(r2, 0x0);
        } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
      }

      //LAB_80fb320
      r0 = MEMORY.ref(4, 0x80fb330).get();
      MEMORY.ref(4, r4 + 0x34).setu(r0);
    }

    //LAB_80fb324
    r3 = CPU.pop();
    r4 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r4;
  }

  @Method(0x80fb334)
  public static void FUN_80fb334(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }
}
