package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.cpu.InstructionSet;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.PointerTableType296;
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
import static org.goldensun.GoldenSunVars._8013784;
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
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.chipWramMallocHead_3001e54;
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

  private static final Logger LOGGER = LogManager.getFormatterLogger(GoldenSun.class);

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

    MEMORY.call(addr, dst, decompressedSize);
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

  @Method(0x8003bb4)
  public static void FUN_8003bb4(final int r0) {
    _3001cd4.set(0);
    _3001cf8.set(0x3e);
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0);
    _3001c98.set(r0);
    _3001ac0.set(_3001c98.get());
  }

  @Method(0x8003d04)
  public static void FUN_8003d04() {
    MEMORY.ref(1, 0x3001d00).setu(0);
    memzero(0x3001400, 0x400);
  }

  @Method(0x8003e10)
  public static void FUN_8003e10(final int r0) {
    final int size = 0xe0;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8001dc8);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x8400_0000 | size / 4); // 0x38 words, 32-bit, enable

    switch(addr) {
      case 0x3002400 -> MEMORY.addFunctions(CopiedSegment8001dc8.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    FUN_80072fc(r0, 0, 0, 0, 0, 0, addr);
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
    final int r1;
    int r2;
    int r3;
    int r4;

    r1 = MEMORY.ref(4, 0x80049a0).get();
    r3 = CPU.addT(r0, 0x3);
    r3 = CPU.lsrT(r3, 2);
    r2 = MEMORY.ref(4, r1).get();
    r0 = CPU.lslT(r3, 2);
    r4 = CPU.movT(0, 0x81);
    r3 = CPU.addT(r2, r0);
    r4 = CPU.lslT(r4, 18);
    r3 = CPU.cmpT(r3, r4);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r2 = MEMORY.ref(4, r1 + 0x4).get();
      r3 = MEMORY.ref(4, 0x80049a4).get();
      r0 = CPU.addT(r2, r0);
      r0 = CPU.cmpT(r0, r3);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        return 0;
      }

      //LAB_8004994
      MEMORY.ref(4, r1 + 0x4).setu(r0);
    } else {
      //LAB_8004998
      MEMORY.ref(4, r1).setu(r3);
    }

    //LAB_800499a
    r0 = CPU.addT(r2, 0x0);

    //LAB_800499c
    return r0;
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

  @Method(0x8010000)
  public static void FUN_8010000() {
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

    r3 = MEMORY.ref(4, 0x8010210).get();
    r3 = MEMORY.ref(4, r3).get();
    r4 = CPU.movT(0, 0x82);
    r1 = MEMORY.ref(4, r3).get();
    CPU.r8().value = r3;
    r4 = CPU.lslT(r4, 1);
    CPU.sp().value -= 0x8;
    r4 += CPU.r8().value;
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8010024
      r3 = MEMORY.ref(4, r1).get();
      r1 += 0x4;

      r2 = MEMORY.ref(4, 0x8010214).get();
      r7 = CPU.addT(r3, r2);
      r2 = MEMORY.ref(4, r1).get();
      r1 += 0x4;

      r3 = MEMORY.ref(4, r1).get();
      r1 = MEMORY.ref(4, 0x8010218).get();
      r3 = CPU.subT(r3, r2);
      r6 = CPU.addT(r3, r1);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xec);
      r2 = CPU.r8().value;
      r2 = MEMORY.ref(4, r2 + 0x4).get();
      r3 = MEMORY.ref(4, r3).get();
      r0 = CPU.addT(r3, r2);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf4);
      r3 = MEMORY.ref(4, r3).get();
      CPU.r12().value = r2;
      r3 = CPU.subT(r3, r2);
      r2 = MEMORY.ref(4, 0x801021c).get();
      r1 = CPU.addT(r3, r2);
      r3 = CPU.r8().value;
      r2 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf0);
      r5 = MEMORY.ref(4, r2 + 0x8).get();
      r3 = MEMORY.ref(4, r3).get();
      r3 = CPU.addT(r3, r5);
      CPU.lr().value = r3;
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0xf8);
      r3 = MEMORY.ref(4, r3).get();
      r2 = MEMORY.ref(4, 0x8010220).get();
      r3 = CPU.subT(r3, r5);
      r3 = CPU.addT(r3, r2);
      r0 = CPU.cmpT(r0, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r1 = CPU.addT(r0, 0x0);
      }

      //LAB_801006e
      CPU.cmpT(CPU.lr().value, r3);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.lr().value;
      }

      //LAB_8010074
      r7 = CPU.cmpT(r7, r0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r7 = CPU.addT(r0, 0x0);
      }

      //LAB_801007a
      r7 = CPU.cmpT(r7, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r7 = CPU.addT(r1, 0x0);
      }

      //LAB_8010080
      CPU.cmpT(r6, CPU.lr().value);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r6 = CPU.lr().value;
      }

      //LAB_8010086
      r6 = CPU.cmpT(r6, r3);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r6 = CPU.addT(r3, 0x0);
      }

      //LAB_801008c
      r3 = CPU.r12().value;
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_8004458();
        r5 = CPU.addT(r0, 0x0);
        r0 = FUN_8004458();
        r2 = CPU.r8().value;
        r2 = MEMORY.ref(4, r2 + 0x4).get();
        r1 = CPU.addT(r0, 0x0);
        CPU.lr().value = r2;
        r0 = CPU.lr().value;
        r1 = CPU.subT(r5, r1);
        CPU.r12().value = 0x80100b0;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = CPU.r8().value;
        r7 = CPU.addT(r7, r0);
        r1 = MEMORY.ref(4, r2 + 0xc).get();
        r0 = CPU.lr().value;
        CPU.r12().value = 0x80100bc;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r8().value;
        MEMORY.ref(4, r3 + 0x4).setu(r0);
        r5 = MEMORY.ref(4, r3 + 0x8).get();
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100c4
      CPU.cmpT(r5, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_8004458();
        r5 = CPU.addT(r0, 0x0);
        r0 = FUN_8004458();
        r2 = CPU.r8().value;
        r2 = MEMORY.ref(4, r2 + 0x8).get();
        r1 = CPU.addT(r0, 0x0);
        CPU.lr().value = r2;
        r0 = CPU.lr().value;
        r1 = CPU.subT(r5, r1);
        r0 = CPU.lslT(r0, 0);
        CPU.r12().value = 0x80100e8;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = CPU.r8().value;
        r6 = CPU.addT(r6, r0);
        r1 = MEMORY.ref(4, r2 + 0xc).get();
        r0 = CPU.lr().value;
        CPU.r12().value = 0x80100f4;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r8().value;
        MEMORY.ref(4, r3 + 0x8).setu(r0);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
      }

      //LAB_80100fa
      r1 = CPU.r8().value;
      r1 = CPU.addT(r1, 0xe4);
      r2 = CPU.movT(0, 0xe8);
      MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
      r2 += CPU.r8().value;
      MEMORY.ref(4, r1).setu(r7);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r2).setu(r6);
      CPU.r11().value = r2;
      CPU.r10().value = r3;

      //LAB_8010112
      do {
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        r1 = MEMORY.ref(4, r4 + 0x10).get();
        r0 = MEMORY.ref(4, r2).get();
        CPU.r12().value = 0x801011c;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r3 = CPU.r11().value;
        r7 = CPU.addT(r0, 0x0);
        r1 = MEMORY.ref(4, r4 + 0x14).get();
        r0 = MEMORY.ref(4, r3).get();
        CPU.r12().value = 0x8010128;
        r0 = (int)MEMORY.call(0x3000118, r0, r1);
        r2 = MEMORY.ref(4, r4 + 0x18).get();
        r6 = CPU.addT(r0, 0x0);
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r4 + 0x20).get();
          r3 = CPU.addT(r3, r2);
          r7 = CPU.addT(r7, r3);
          MEMORY.ref(4, r4 + 0x20).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x28).getUnsigned();
          r2 = MEMORY.ref(4, 0x8010228).get();
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, r2);
          r7 = CPU.andT(r7, r3);
        }

        //LAB_8010142
        r2 = MEMORY.ref(4, r4 + 0x1c).get();
        CPU.cmpT(r2, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, r4 + 0x24).get();
          r3 = CPU.addT(r3, r2);
          r6 = CPU.addT(r6, r3);
          MEMORY.ref(4, r4 + 0x24).setu(r3);
          r3 = MEMORY.ref(2, r4 + 0x2a).getUnsigned();
          r2 = MEMORY.ref(4, 0x8010228).get();
          r3 = CPU.lslT(r3, 19);
          r3 = CPU.orrT(r3, r2);
          r6 = CPU.andT(r6, r3);
        }

        //LAB_801015a
        r3 = MEMORY.ref(4, r4 + 0x8).get();
        r7 = CPU.addT(r7, r3);
        r3 = MEMORY.ref(4, r4 + 0xc).get();
        r1 = CPU.addT(r7, 0x0);
        r6 = CPU.addT(r6, r3);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r2 = MEMORY.ref(4, 0x8010228).get();
          r1 = CPU.addT(r7, r2);
        }

        //LAB_801016c
        r1 = CPU.asrT(r1, 19);
        CPU.r8().value = r1;
        r2 = CPU.addT(r6, 0x0);
        CPU.cmpT(r6, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r3 = MEMORY.ref(4, 0x8010228).get();
          r2 = CPU.addT(r6, r3);
        }

        //LAB_801017a
        r1 = MEMORY.ref(4, r4).get();
        r5 = CPU.asrT(r2, 19);
        r3 = CPU.addT(r1, 0x0);
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.eorT(r3, r7);
        r2 = CPU.lslT(r2, 12);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.cmpT(r1, r7);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r1 = CPU.r8().value;
            r1 = CPU.addT(r1, 0x1e);
            r0 = CPU.r10().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          } else {
            //LAB_801019c
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          }

          //LAB_80101a4
          FUN_800ff54(r0, r1, r2);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80101aa
        r1 = MEMORY.ref(4, r4 + 0x4).get();
        r2 = CPU.movT(0, 0x80);
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.eorT(r3, r6);
        r2 = CPU.lslT(r2, 13);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.cmpT(r1, r6);
          if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
            r2 = CPU.addT(r5, 0x0);
            r2 = CPU.addT(r2, 0x14);
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          } else {
            //LAB_80101ca
            r0 = CPU.r10().value;
            r1 = CPU.r8().value;
            r2 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
          }

          //LAB_80101d2
          FUN_800fec8(r0, r1, r2);
          r4 = MEMORY.ref(4, CPU.sp().value).get();
        }

        //LAB_80101d8
        r1 = CPU.r10().value;
        r3 = CPU.movT(0, 0x3);
        r3 = CPU.subT(r3, r1);
        r1 = MEMORY.ref(4, 0x801022c).get();
        r3 = CPU.lslT(r3, 2);
        r2 = CPU.asrT(r7, 16);
        MEMORY.ref(2, r1 + r3).setu(r2);
        r2 = CPU.asrT(r6, 16);
        r3 = CPU.addT(r3, r1);
        MEMORY.ref(2, r3 + 0x2).setu(r2);
        r2 = CPU.movT(0, 0x1);
        CPU.r10().value += r2;
        r3 = CPU.r10().value;
        MEMORY.ref(4, r4).setu(r7);
        MEMORY.ref(4, r4 + 0x4).setu(r6);
        r4 = CPU.addT(r4, 0x30);
        CPU.cmpT(r3, 0x2);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          break;
        }
      } while(true);
    }

    //LAB_80101fe
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x8010230)
  public static void FUN_8010230(int r0, int r1) {
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

    r3 = MEMORY.ref(4, 0x80103f8).get();
    r7 = CPU.addT(r0, 0x0);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.addT(r1, 0x0);
    r1 = CPU.movT(0, 0x82);
    CPU.sp().value -= 0x20;
    r1 = CPU.lslT(r1, 1);
    MEMORY.ref(4, CPU.sp().value + 0x14).setu(r3);
    r3 = CPU.addT(r3, r1);
    CPU.lr().value = r3;
    r3 = MEMORY.ref(4, 0x80103fc).get();
    r0 = CPU.addT(r0, r3);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = MEMORY.ref(4, 0x8010400).get();
    r3 = CPU.addT(r3, 0xec);
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r7, r2);
    r7 = CPU.cmpT(r7, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r7 = CPU.addT(r3, 0x0);
    }

    //LAB_8010266
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf4);
    r3 = MEMORY.ref(4, r3).get();
    r5 = MEMORY.ref(4, 0x8010404).get();
    r3 = CPU.addT(r3, r5);
    r7 = CPU.cmpT(r7, r3);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r7 = CPU.addT(r3, 0x0);
    }

    //LAB_8010276
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf0);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = CPU.addT(r3, 0x0);
    }

    //LAB_8010282
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r3 = CPU.addT(r3, 0xf8);
    r3 = MEMORY.ref(4, r3).get();
    r1 = MEMORY.ref(4, 0x8010408).get();
    r3 = CPU.addT(r3, r1);
    r0 = CPU.cmpT(r0, r3);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = CPU.addT(r3, 0x0);
    }

    //LAB_8010292
    r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r2 = CPU.addT(r2, 0xe4);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(r2);
    MEMORY.ref(4, r2).setu(r7);
    r3 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
    r5 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r3, 0xe8);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
    MEMORY.ref(4, r3).setu(r0);
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5);

    //LAB_80102a6
    do {
      r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 1);
      r5 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
      r3 = CPU.addT(r1, r2);
      r3 = MEMORY.ref(1, r5 + r3).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        break;
      }

      //LAB_80102b8
      r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
      r2 = CPU.lr().value;
      r0 = MEMORY.ref(4, r1).get();
      r4 = CPU.movT(0, 0x16);
      r1 = MEMORY.ref(4, r2 + 0x10).get();
      CPU.r12().value = 0x80102c8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r5 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r2 = CPU.lr().value;
      r7 = CPU.addT(r0, 0x0);
      r1 = MEMORY.ref(4, r2 + 0x14).get();
      r0 = MEMORY.ref(4, r5).get();
      r0 = CPU.lslT(r0, 0);
      CPU.r12().value = 0x80102d8;
      r0 = (int)MEMORY.call(0x3000118, r0, r1);
      r3 = CPU.lr().value;
      r2 = MEMORY.ref(4, r3 + 0x18).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x20).get();
        r5 = CPU.lr().value;
        r3 = CPU.addT(r3, r2);
        r7 = CPU.addT(r7, r3);
        MEMORY.ref(4, r5 + 0x20).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x28).getUnsigned();
        r1 = MEMORY.ref(4, 0x8010410).get();
        r3 = CPU.lslT(r3, 19);
        r3 = CPU.orrT(r3, r1);
        r7 = CPU.andT(r7, r3);
      }

      //LAB_80102f4
      r3 = CPU.lr().value;
      r2 = MEMORY.ref(4, r3 + 0x1c).get();
      CPU.cmpT(r2, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r3 + 0x24).get();
        r5 = CPU.lr().value;
        r3 = CPU.addT(r3, r2);
        r0 = CPU.addT(r0, r3);
        MEMORY.ref(4, r5 + 0x24).setu(r3);
        r3 = MEMORY.ref(2, r5 + 0x2a).getUnsigned();
        r1 = MEMORY.ref(4, 0x8010410).get();
        r3 = CPU.lslT(r3, 19);
        r3 = CPU.orrT(r3, r1);
        r0 = CPU.andT(r0, r3);
        r4 = CPU.movT(0, 0x20);
      }

      //LAB_8010312
      r2 = CPU.lr().value;
      r3 = MEMORY.ref(4, r2 + 0x8).get();
      r7 = CPU.addT(r7, r3);
      r3 = MEMORY.ref(4, r2 + 0xc).get();
      r0 = CPU.addT(r0, r3);
      r3 = CPU.movT(0, 0x30);
      CPU.lr().value += r3;
      r1 = CPU.addT(r7, 0x0);
      CPU.cmpT(r7, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r5 = MEMORY.ref(4, 0x8010410).get();
        r1 = CPU.addT(r7, r5);
      }

      //LAB_801032a
      r7 = CPU.asrT(r1, 19);
      r2 = CPU.addT(r0, 0x0);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8010410).get();
        r2 = CPU.addT(r0, r3);
      }

      //LAB_8010336
      r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r3 = CPU.lslT(r5, 11);
      r5 = MEMORY.ref(4, 0x8010414).get();
      r0 = CPU.asrT(r2, 19);
      r5 = CPU.addT(r3, r5);
      r3 = CPU.lsrT(r2, 31);
      r3 = CPU.addT(r0, r3);
      r2 = CPU.movT(0, 0x7f);
      r3 = CPU.asrT(r3, 1);
      r3 = CPU.andT(r3, r2);
      r6 = CPU.lslT(r3, 7);
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.movT(0, 0x1e);
      r4 = CPU.lsrT(r4, 1);
      r3 = CPU.andT(r3, r0);
      CPU.r8().value = r2;
      CPU.r11().value = r4;
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(r5);
      r5 = CPU.lslT(r3, 5);
      CPU.cmpT(CPU.r8().value, CPU.r11().value);
      if(!CPU.cpsr().getCarry()) { // unsigned <
        r3 = CPU.lsrT(r1, 31);
        r3 = CPU.addT(r7, r3);
        r3 = CPU.asrT(r3, 1);
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
        r1 = CPU.movT(0, 0x1e);
        r3 = CPU.movT(0, 0x7f);
        CPU.r9().value = r3;
        CPU.r10().value = r1;

        //LAB_8010370
        do {
          r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r2 = CPU.r9().value;
          r0 = CPU.addT(r7, 0x0);
          r3 = CPU.r10().value;
          r1 = CPU.movT(0, 0x0);
          r4 = CPU.andT(r4, r2);
          r0 = CPU.andT(r0, r3);
          CPU.r12().value = r1;

          //LAB_8010380
          do {
            r3 = CPU.addT(r6, r4);
            r2 = MEMORY.ref(4, 0x8010418).get();
            r3 = CPU.lslT(r3, 2);
            r3 = CPU.addT(r3, r2);
            r1 = MEMORY.ref(4, r3).get();
            r2 = MEMORY.ref(4, 0x801041c).get();
            r1 = CPU.lslT(r1, 20);
            r1 = CPU.lsrT(r1, 17);
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            r3 = CPU.addT(r1, r2);
            r1 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
            r2 = CPU.addT(r5, r0);
            r2 = CPU.lslT(r2, 1);
            r2 = CPU.addT(r2, r1);
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r3 = MEMORY.ref(4, r3).get();
            MEMORY.ref(4, r2).setu(r3);
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r1 = MEMORY.ref(4, 0x8010420).get();
            r3 = CPU.addT(r2, r1);
            r3 = MEMORY.ref(4, r3).get();
            r2 = MEMORY.ref(4, CPU.sp().value).get();
            MEMORY.ref(4, r2 + 0x40).setu(r3);
            r2 = CPU.movT(0, 0x1);
            r3 = CPU.r9().value;
            r4 = CPU.addT(r4, 0x1);
            CPU.r12().value += r2;
            r4 = CPU.andT(r4, r3);
            r0 = CPU.addT(r0, 0x2);
            r1 = CPU.r10().value;
            r3 = CPU.r12().value;
            r0 = CPU.andT(r0, r1);
            CPU.cmpT(r3, 0xf);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

          r3 = CPU.movT(0, 0xfe);
          r3 = CPU.lslT(r3, 6);
          r6 = CPU.addT(r6, 0x80);
          r6 = CPU.andT(r6, r3);
          r3 = CPU.movT(0, 0xf0);
          r5 = CPU.addT(r5, 0x40);
          r3 = CPU.lslT(r3, 2);
          CPU.r8().value += r2;
          r5 = CPU.andT(r5, r3);
          CPU.cmpT(CPU.r8().value, CPU.r11().value);
        } while(!CPU.cpsr().getCarry()); // unsigned <
      }

      //LAB_80103da
      r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
      r5 = CPU.addT(r5, 0x1);
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r5);
      CPU.cmpT(r5, 0x2);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        break;
      }
    } while(true);

    //LAB_80103e6
    CPU.sp().value += 0x20;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x80118d8)
  public static void FUN_80118d8(int r0) {
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

    r3 = MEMORY.ref(4, 0x8011970).get();
    r5 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    r4 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.sp().value;
    r1 = CPU.addT(r5, 0x0);
    MEMORY.ref(4, r0).setu(r6);
    r1 = CPU.addT(r1, 0x18);
    r2 = MEMORY.ref(4, 0x8011978).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(r2);

    r1 = MEMORY.ref(2, r4).getUnsigned();
    r2 = MEMORY.ref(4, 0x801197c).get();
    r4 = CPU.addT(r4, 0x2);
    r1 = CPU.cmpT(r1, r2);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xff);
      r2 = CPU.movT(0, 0xfd);
      r3 = CPU.lslT(r3, 8);
      r2 = CPU.lslT(r2, 8);
      CPU.r10().value = r3;
      CPU.r8().value = r2;
      r3 = CPU.movT(0, 0xf);
      r2 = CPU.movT(0, 0x80);
      CPU.lr().value = r3;
      CPU.r12().value = r2;
      r7 = CPU.movT(0, 0x0);

      //LAB_801191a
      do {
        r3 = CPU.addT(r1, 0x0);
        r2 = CPU.r10().value;
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, CPU.r8().value);
        if(CPU.cpsr().getZero()) { // ==
          r3 = CPU.lr().value;
          r2 = CPU.addT(r1, 0x0);
          r2 = CPU.andT(r2, r3);
          r3 = CPU.r12().value;
          r3 = CPU.andT(r3, r1);
          r0 = CPU.movT(0, 0x0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.movT(0, 0x1);
          }

          //LAB_8011936
          r3 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r3, r2);
          r3 = CPU.lslT(r3, 2);
          r3 = CPU.addT(r5, r3);
          r3 = CPU.addT(r3, 0x18);
          MEMORY.ref(4, r3).setu(r4);
          MEMORY.ref(4, r3 + 0x4).setu(r4);
          MEMORY.ref(2, r3 + 0x8).setu(r7);
          MEMORY.ref(2, r3 + 0xa).setu(r0);
          r6 = CPU.addT(r6, 0x1);
        }

        //LAB_801194a
        r1 = MEMORY.ref(2, r4).getUnsigned();
        r2 = MEMORY.ref(4, 0x801197c).get();
        r4 = CPU.addT(r4, 0x2);
        r1 = CPU.cmpT(r1, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8011954
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r0 = MEMORY.ref(4, 0x8011980).get();
      r1 = CPU.lslT(r1, 4);
      r0 = FUN_80041d8(r0, r1);
    }

    //LAB_8011962
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8011a84)
  public static void FUN_8011a84(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;

    r3 = MEMORY.ref(4, 0x8011acc).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.sp().value -= 0x4;
    r4 = CPU.addT(r3, 0x0);
    r5 = CPU.addT(r0, 0x0);
    r6 = CPU.movT(0, 0x0);
    r0 = CPU.sp().value;
    r4 = CPU.addT(r4, 0xd8);
    MEMORY.ref(4, r0).setu(r6);
    r2 = MEMORY.ref(4, 0x8011ad4).get();
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(r2);

    r3 = MEMORY.ref(2, r5).getUnsigned();
    r2 = MEMORY.ref(4, 0x8011ad8).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      MEMORY.ref(4, r4).setu(r5);
      MEMORY.ref(4, r4 + 0x4).setu(r5);
      MEMORY.ref(2, r4 + 0x8).setu(r6);
      MEMORY.ref(2, r4 + 0xa).setu(r6);
      r6 = CPU.movT(0, 0x1);
    }

    //LAB_8011ab4
    CPU.cmpT(r6, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0xc8);
      r0 = MEMORY.ref(4, 0x8011adc).get();
      r1 = CPU.lslT(r1, 4);
      r0 = FUN_80041d8(r0, r1);
    }

    //LAB_8011ac2
    CPU.sp().value += 0x4;
  }

  @Method(0x8011ce0)
  public static int FUN_8011ce0(int r0, final int r1, final int r2) {
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.lslT(r0, 24);
    r0 = CPU.asrT(r0, 24);
    r0 = CPU.lslT(r0, 19);
    return r0;
  }

  @Method(0x8011f54)
  public static int FUN_8011f54(int r0, int r1, int r2) {
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8011fc4).get();
    r5 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, r3).get();
    r6 = CPU.addT(r2, 0x0);
    r5 = CPU.asrT(r5, 16);
    r6 = CPU.asrT(r6, 16);
    r2 = MEMORY.ref(4, 0x8011fc8).get();
    CPU.cmpT(r1, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x3);
      r2 = CPU.andT(r2, r0);
      r3 = CPU.lslT(r2, 1);
      r3 = CPU.addT(r3, r2);
      r2 = CPU.movT(0, 0x98);
      r2 = CPU.lslT(r2, 1);
      r3 = CPU.lslT(r3, 4);
      r3 = CPU.addT(r3, r2);
      r2 = MEMORY.ref(4, r1 + r3).get();
    }

    //LAB_8011f7a
    r3 = CPU.addT(r5, 0x0);
    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0xf);
    }

    //LAB_8011f82
    r1 = CPU.asrT(r3, 4);
    r3 = CPU.addT(r6, 0x0);
    CPU.cmpT(r6, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0xf);
    }

    //LAB_8011f8c
    r3 = CPU.asrT(r3, 4);
    r3 = CPU.lslT(r3, 7);
    r3 = CPU.addT(r1, r3);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r2, r3);
    r1 = MEMORY.ref(1, r2 + 0x3).getUnsigned();
    r3 = MEMORY.ref(4, 0x8011fcc).get();
    r1 = CPU.lslT(r1, 2);
    r0 = CPU.addT(r1, r3);
    r2 = CPU.movT(0, 0xf);
    r0 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r2, 0x0);
    r4 = MEMORY.ref(4, 0x8011fd0).get();
    r3 = CPU.andT(r3, r0);
    r7 = MEMORY.ref(4, 0x8011fd4).get();
    r5 = CPU.andT(r5, r2);
    r6 = CPU.andT(r6, r2);
    r3 = CPU.lslT(r3, 2);
    r0 = CPU.addT(r1, r7);
    r3 = MEMORY.ref(4, r4 + r3).get();
    r1 = CPU.addT(r5, 0x0);
    r2 = CPU.addT(r6, 0x0);
    return (int)MEMORY.call(r3, r0, r1, r2);
  }

  @Method(0x8015000)
  public static void FUN_8015000() {
    MEMORY.call(0x8015f31);
  }

  @Method(0x8015020)
  public static void FUN_8015020(final int r0, final int r1) {
    FUN_801964c(r0, r1);
  }

  @Method(0x8015040)
  public static void FUN_8015040(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015120)
  public static void FUN_8015120(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
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
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015288)
  public static int FUN_8015288() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015290)
  public static int FUN_8015290() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015360)
  public static void FUN_8015360(final int r0, final int r1) {
    MEMORY.call(0x801ccc0, r0, r1);
  }

  @Method(0x8015370)
  public static int FUN_8015370(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8015ef4)
  public static void FUN_8015ef4() {
    final int r0;
    int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x8015f24).get();
    r1 = CPU.movT(0, 0xd3);
    r0 = MEMORY.ref(4, r3).get();
    r1 = CPU.lslT(r1, 3);
    r2 = CPU.addT(r0, r1);
    r1 = MEMORY.ref(4, 0x8015f28).get();
    r3 = CPU.addT(r0, r1);
    MEMORY.ref(4, r3).setu(r2);
    r3 = CPU.movT(0, 0x3e);

    //LAB_8015f08
    do {
      r1 = CPU.addT(r2, 0x0);
      r1 = CPU.addT(r1, 0x1c);
      r3 = CPU.subT(r3, 0x1);
      MEMORY.ref(4, r2).setu(r1);
      r2 = CPU.addT(r1, 0x0);
      CPU.cmpT(r3, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r2 = MEMORY.ref(4, 0x8015f2c).get();
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r1).setu(r3);
    r3 = CPU.addT(r0, r2);
    MEMORY.ref(4, r3).setu(r1);
  }

  @Method(0x8015f30)
  public static void FUN_8015f30() {
    final int r0;
    int r1;
    final int r4;
    final int r5;

    CPU.sp().value -= 0x4;
    r4 = FUN_80048f4(0xf, 0x12fc);
    r5 = CPU.sp().value;
    MEMORY.ref(4, r5).setu(0);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x850004bf);

    MEMORY.ref(1, r4 + 0xea3).setu(0x1);
    MEMORY.ref(2, r4 + 0x12b6).setu(0x63);
    MEMORY.ref(1, r4 + 0xea7).setu(0xf);
    MEMORY.ref(4, r5).setu(0xf000f000);
    DMA.channels[3].SAD.setu(r5);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000140);

    FUN_8015ef4();
    FUN_8019d0c();
    r1 = CPU.movT(0, 0x90);
    r1 = CPU.lslT(r1, 3);
    r0 = MEMORY.ref(4, 0x8015fb4).get();
    FUN_80041d8(r0, r1);
    FUN_80173f4();
    CPU.sp().value += 0x4;
  }

  /** Called from interrupt handler */
  @Method(0x80160fc)
  public static void FUN_80160fc() {
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    final int r7;

    r3 = MEMORY.ref(4, 0x8016160).get();
    r2 = MEMORY.ref(4, 0x8016164).get();
    r7 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.subT(r2, 0x3);
      r3 = CPU.addT(r7, r2);
      r4 = MEMORY.ref(1, r3).getUnsigned();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, 0x8016168).get();
        CPU.r12().value = r3;
        r3 = CPU.movT(0, 0x1);
        r3 = CPU.andT(r3, r4);
        r5 = CPU.addT(r7, 0x0);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r4 = CPU.movT(0, 0x3f);
        }

        //LAB_8016126
        r3 = CPU.movT(0, 0x3f);
        r4 = CPU.andT(r4, r3);
        r2 = CPU.movT(0, 0x1);
        r6 = CPU.movT(0, 0x80);
        r4 = CPU.lsrT(r4, 1);
        CPU.lr().value = r2;
        r6 = CPU.lslT(r6, 1);

        //LAB_8016134
        do {
          r3 = CPU.addT(r4, 0x0);
          r2 = CPU.lr().value;
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            DMA.channels[3].SAD.setu(r5);
            DMA.channels[3].DAD.setu(CPU.r12().value);
            DMA.channels[3].CNT.setu(0x84000040);
          }

          //LAB_801614a
          r4 = CPU.lsrT(r4, 1);
          r5 = CPU.addT(r5, r6);
          CPU.r12().value += r6;
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=

        r2 = MEMORY.ref(4, 0x8016174).get();
        r3 = CPU.addT(r7, r2);
        MEMORY.ref(1, r3).setu(r4);
      }
    }

    //LAB_801615a
  }

  @Method(0x80173f4)
  public static void FUN_80173f4() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;

    r3 = MEMORY.ref(4, 0x8017444).get();
    r1 = CPU.movT(0, 0x80);
    r1 = CPU.lslT(r1, 6);
    r2 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x5f);
    r5 = MEMORY.ref(4, r3).get();
    r0 = FUN_8003fa4(r0, r1, r2);
    r2 = MEMORY.ref(4, 0x8017448).get();
    r3 = CPU.addT(r5, r2);
    MEMORY.ref(2, r3).setu(r0);
    r3 = MEMORY.ref(4, 0x801744c).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0x9);
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8017450).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0xa);
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8017454).get();
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r5, r2);
    MEMORY.ref(2, r3).setu(r1);
    r3 = MEMORY.ref(4, 0x8017458).get();
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0xf);
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x801745c).get();
    r5 = CPU.addT(r5, r2);
    MEMORY.ref(2, r5).setu(r1);
    r1 = CPU.movT(0, 0xc8);
    r1 = CPU.lslT(r1, 4);
    r0 = MEMORY.ref(4, 0x8017460).get();
    FUN_80041d8(r0, r1);
  }

  @Method(0x801964c)
  public static void FUN_801964c(final int r0, final int r1) {
    FUN_80196c4(r0, r1, MEMORY.ref(4, 0x8019658).get());
  }


  @Method(0x80196c4)
  public static void FUN_80196c4(int r0, int r1, int r2) {
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r3 = boardWramMallocHead_3001e50.getAddress() + 0xc8;
    r7 = r2;
    r2 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r2;
    CPU.r8().value = r3;
    r3 = CPU.r10().value;
    CPU.sp().value -= 0xc;
    CPU.r9().value = r0;
    r6 = r1;

    if(r3 == 0) {
      r5 = 0x140;
      r1 = FUN_80048b0(0x32, r5);
      DMA.channels[3].SAD.setu(0x8015430);
      DMA.channels[3].DAD.setu(r1);
      DMA.channels[3].CNT.setu(0x84000000 | r5 / 0x4);

      switch(r1) {
        case 0x3002000 -> MEMORY.addFunctions(CopiedSegment8015430.class);
        default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(r1));
      }

      r3 = MEMORY.ref(4, CPU.r8().value).get();
    }

    //LAB_8019706
    r5 = CPU.sp().value;
    r1 = CPU.r9().value;
    r0 = CPU.addT(r5, 0x0);
    CPU.r8().value = r3;
    FUN_8019bac(r0, r1);
    r3 = MEMORY.ref(4, 0x80197b0).get();
    CPU.r9().value = r3;

    //LAB_8019770
    r0 = (int)MEMORY.call(CPU.r8().value, r5);

    //LAB_8019718
    while(r0 != 0) {
      if(r0 == 0xe) {
        //LAB_8019730
        r7 = CPU.subT(r7, 0x3);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r6 = CPU.addT(r6, 0x2);
        r0 += CPU.r9().value;
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r6 = CPU.addT(r6, 0x2);
        r0 += CPU.r9().value;
        //LAB_801972a
      } else if(r0 >= 0x8 && r0 <= 0xc || r0 == 0xf) {
        //LAB_8019750
        r7 = CPU.subT(r7, 0x1);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
        MEMORY.ref(2, r6).setu(r0);
        r0 = (int)MEMORY.call(CPU.r8().value, r5);
        r2 = MEMORY.ref(4, 0x80197b0).get();
        r6 = CPU.addT(r6, 0x2);
        r0 = CPU.addT(r0, r2);
      } else {
        //LAB_8019766
        r7 = CPU.subT(r7, 0x1);
        CPU.cmpT(r7, 0x0);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          break;
        }
      }

      //LAB_801976c
      MEMORY.ref(2, r6).setu(r0);
      r6 = CPU.addT(r6, 0x2);

      r0 = (int)MEMORY.call(CPU.r8().value, r5);
    }

    //LAB_801977a
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x32);
      FUN_8002dd8(r0);
    }

    //LAB_8019786
    CPU.sp().value += 0xc;
    MEMORY.ref(2, r6).setu(0);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8019bac)
  public static void FUN_8019bac(final int r0, final int r1) {
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    CPU.r10().value = r1;
    final int size = 0x60;
    final int addr = FUN_8004938(size);
    DMA.channels[3].SAD.setu(0x8015570);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3002140 -> MEMORY.addFunctions(CopiedSegment8015570.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    MEMORY.call(addr, CPU.r8().value, CPU.r10().value);
    FUN_8002df0(addr);

    CPU.r8().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x8019d0c)
  public static void FUN_8019d0c() {
    int r0;
    int r1;
    final int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8019d24).get();
    r0 = MEMORY.ref(4, 0x8019d28).get();
    r3 = MEMORY.ref(4, r3).get();
    r2 = MEMORY.ref(4, 0x8019d20).get();
    r1 = CPU.addT(r3, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r1).setu(r2);
    r1 = CPU.addT(r3, r0);
    MEMORY.ref(2, r1).setu(r2);
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

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r6 = CPU.addT(r1, 0x0);
    r0 = CPU.addT(r0, 0xc);
    r1 = CPU.movT(0, 0x18);
    CPU.sp().value -= 0x8;
    r0 = FUN_80022fc(r0, r1);
    r5 = CPU.addT(r0, 0x0);
    r5 = CPU.lslT(r5, 18);
    r5 = CPU.asrT(r5, 16);
    r2 = MEMORY.ref(4, 0x801cdec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    CPU.r8().value = r2;
    r0 = FUN_80022fc(r0, r1);
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
    r0 = FUN_80022fc(r0, r1);
    r2 = CPU.r8().value;
    r3 = MEMORY.ref(1, r2 + r0).getUnsigned();
    r5 = CPU.addT(r5, 0x40);
    r3 = CPU.addT(r3, r6);
    r3 = CPU.lslT(r3, 16);
    r0 = CPU.addT(r5, 0x0);
    r1 = CPU.movT(0, 0x60);
    r7 = CPU.asrT(r3, 16);
    r0 = FUN_80022fc(r0, r1);
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
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x8077008)
  public static int FUN_8077008(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8077098)
  public static void FUN_8077098() {
    FUN_8077d38();
  }

  @Method(0x80770c0)
  public static int FUN_80770c0(final int r0) {
    return (int)MEMORY.call(0x8079339, r0);
  }

  @Method(0x80770c8)
  public static void FUN_80770c8(final int r0) {
    MEMORY.call(0x8079359, r0);
  }

  @Method(0x80770d0)
  public static void FUN_80770d0(final int r0) {
    MEMORY.call(0x8079375, r0);
  }

  @Method(0x80772f0)
  public static void FUN_80772f0() {
    MEMORY.call(0x8077c11);
  }

  @Method(0x8077394)
  public static int FUN_8077394(int r0) {
    int r2;
    int r3;

    r2 = MEMORY.ref(4, 0x80773cc).get();
    CPU.cmpT(r0, 0x7);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      r3 = CPU.movT(0, 0xa6);
      r3 = CPU.lslT(r3, 1);
      r3 = CPU.mulT(r3, r0);
      r0 = CPU.addT(r3, r2);
      return r0;
    }

    //LAB_80773a8
    r3 = CPU.addT(r0, 0x0);
    r3 = CPU.subT(r3, 0x80);
    CPU.cmpT(r3, 0x5);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      return 0;
    }

    r3 = MEMORY.ref(4, 0x80773d0).get();
    r2 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r2, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      //LAB_80773c6
      return 0;
    }

    r3 = CPU.movT(0, 0xa6);
    r3 = CPU.lslT(r3, 1);
    r3 = CPU.mulT(r3, r0);
    r3 = CPU.addT(r2, r3);
    r2 = MEMORY.ref(4, 0x80773d4).get();
    r0 = CPU.addT(r3, r2);

    //LAB_80773c8
    return r0;
  }

  @Method(0x80773d8)
  public static int FUN_80773d8(int r0) {
    int r3;

    r0 = CPU.subT(r0, 0x8);
    CPU.cmpT(r0, 0xf9);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_80773e2
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r3 = MEMORY.ref(4, 0x80773f0).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x8077428)
  public static void FUN_8077428(int r0) {
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

    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x60);
    CPU.sp().value -= 0x4;
    r0 = FUN_8004970(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8077394(r0);
    r7 = CPU.addT(r0, 0x0);
    r0 = CPU.movT(0, 0x10);
    r3 = MEMORY.ref(2, r7 + r0).get();
    MEMORY.ref(4, r6).setu(r3);
    r1 = CPU.movT(0, 0x12);
    r3 = MEMORY.ref(2, r7 + r1).get();
    MEMORY.ref(4, r6 + 0x4).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x18).getUnsigned();
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x1a).getUnsigned();
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = MEMORY.ref(2, r7 + 0x1c).getUnsigned();
    MEMORY.ref(4, r6 + 0x10).setu(r3);
    r3 = MEMORY.ref(1, r7 + 0x1e).getUnsigned();
    MEMORY.ref(4, r6 + 0x18).setu(r3);
    r2 = MEMORY.ref(1, r7 + 0x1f).getUnsigned();
    r3 = CPU.movT(0, 0xf);
    r3 = CPU.andT(r3, r2);
    MEMORY.ref(4, r6 + 0x1c).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x20);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    MEMORY.ref(4, r6 + 0x20).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r3 = CPU.addT(r3, 0x21);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.addT(r6, 0x0);
    MEMORY.ref(4, r6 + 0x24).setu(r3);
    r1 = CPU.addT(r1, 0x24);
    r2 = CPU.addT(r2, 0x28);
    r5 = CPU.movT(0, 0x3);

    //LAB_8077482
    do {
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r1 + r0).get();
      MEMORY.ref(4, r2).setu(r3);
      r0 = CPU.movT(0, 0x2);
      r3 = MEMORY.ref(2, r1 + r0).get();
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r2 + 0x4).setu(r3);
      r1 = CPU.addT(r1, 0x4);
      r2 = CPU.addT(r2, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r1 = CPU.movT(0, 0x34);
    r2 = MEMORY.ref(2, r7 + r1).get();
    r0 = CPU.movT(0, 0x14);
    r3 = MEMORY.ref(2, r7 + r0).get();
    r3 = CPU.mulT(r3, r2);
    r2 = CPU.addT(r3, 0x0);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r1 = MEMORY.ref(4, 0x80776e4).get();
      r2 = CPU.addT(r3, r1);
    }

    //LAB_80774ac
    r0 = CPU.asrT(r2, 14);
    r2 = CPU.movT(0, 0x38);
    r1 = MEMORY.ref(2, r7 + r2).get();
    r2 = CPU.subT(r0, r1);

    //LAB_80774be
    if(r2 > 1 || r2 < 0 && r1 - r0 > 1) {
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 7);
      MEMORY.ref(2, r7 + 0x14).setu(r3);
      MEMORY.ref(2, r7 + 0x16).setu(r3);
      r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
      MEMORY.ref(2, r7 + 0x38).setu(r3);
      r3 = MEMORY.ref(2, r7 + 0x36).getUnsigned();
      MEMORY.ref(2, r7 + 0x3a).setu(r3);
    } else {
      //LAB_80774c4
      r3 = CPU.movT(0, 0x36);
      r2 = MEMORY.ref(2, r7 + r3).get();
      r0 = CPU.movT(0, 0x16);
      r3 = MEMORY.ref(2, r7 + r0).get();
      r3 = CPU.mulT(r3, r2);
      r2 = CPU.addT(r3, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r1 = MEMORY.ref(4, 0x80776e4).get();
        r2 = CPU.addT(r3, r1);
      }

      //LAB_80774d8
      r0 = CPU.asrT(r2, 14);
      r2 = CPU.movT(0, 0x3a);
      r1 = MEMORY.ref(2, r7 + r2).get();
      r2 = CPU.subT(r0, r1);

      //LAB_80774ea
      if(r2 > 1 || r2 < 0 && r1 - r0 > 1) {
        //LAB_80774f0
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 7);
        MEMORY.ref(2, r7 + 0x14).setu(r3);
        MEMORY.ref(2, r7 + 0x16).setu(r3);
        r3 = MEMORY.ref(2, r7 + 0x34).getUnsigned();
        MEMORY.ref(2, r7 + 0x38).setu(r3);
        r3 = MEMORY.ref(2, r7 + 0x36).getUnsigned();
        MEMORY.ref(2, r7 + 0x3a).setu(r3);
      }
    }

    //LAB_8077500
    r3 = CPU.movT(0, 0x98);
    r3 = CPU.lslT(r3, 1);
    r1 = CPU.addT(r7, r3);
    r3 = MEMORY.ref(1, r1).getUnsigned();
    r0 = CPU.movT(0, 0x4);
    r0 = CPU.negT(r0, r0);
    r0 = CPU.andT(r0, r3);
    r3 = CPU.movT(0, 0x4);
    r3 = CPU.andT(r3, r0);
    r4 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r1).setu(r0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.movT(0, 0x1);
      r3 = CPU.addT(r0, 0x0);
      r3 = CPU.orrT(r3, r2);
      MEMORY.ref(1, r1).setu(r3);
    }

    //LAB_8077522
    r0 = CPU.movT(0, 0xa2);
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, r6 + 0x1c).get();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077534
    r1 = CPU.movT(0, 0xa1);
    r1 = CPU.lslT(r1, 1);
    r2 = MEMORY.ref(4, 0x80776e8).get();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r4);
    r0 = MEMORY.ref(4, 0x80776ec).get();
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r4);
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_807754e
      r5 = CPU.movT(0, 0x0);

      //LAB_8077550
      do {
        r3 = CPU.lslT(r5, 1);
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.addT(r1, 0xd8);
        r2 = MEMORY.ref(2, r7 + r1).getUnsigned();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 2);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          //LAB_8077564
          r0 = MEMORY.ref(2, r7 + r1).getUnsigned();
          r0 = FUN_8078414(r0);
          r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
          r3 = CPU.movT(0, 0x1);
          r3 = CPU.andT(r3, r2);
          MEMORY.ref(4, r6 + 0x58).setu(r0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r2 = CPU.movT(0, 0x98);
            r2 = CPU.lslT(r2, 1);
            r1 = CPU.addT(r7, r2);
            r2 = MEMORY.ref(1, r1).getUnsigned();
            r3 = CPU.movT(0, 0x3);
            r3 = CPU.orrT(r3, r2);
            MEMORY.ref(1, r1).setu(r3);
          }

          //LAB_8077584
          r1 = MEMORY.ref(4, r6 + 0x58).get();
          r3 = CPU.movT(0, 0x8);
          r2 = MEMORY.ref(2, r1 + r3).get();
          r3 = MEMORY.ref(4, r6 + 0x8).get();
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(4, r6 + 0x8).setu(r3);
          r2 = CPU.movT(0, 0xa);
          r2 = MEMORY.ref(1, r1 + r2).get();
          r3 = MEMORY.ref(4, r6 + 0xc).get();
          r3 = CPU.addT(r3, r2);
          r0 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r6 + 0xc).setu(r3);
          CPU.r8().value = r0;

          //LAB_807759e
          do {
            r1 = CPU.r8().value;
            r2 = MEMORY.ref(4, r6 + 0x58).get();
            r3 = CPU.lslT(r1, 2);
            r3 = CPU.addT(r3, 0x18);
            r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
            r2 = CPU.addT(r2, r3);
            r3 = CPU.movT(0, 0x1);
            r3 = MEMORY.ref(1, r2 + r3).get();
            MEMORY.ref(4, r6 + 0x48).setu(r1);
            MEMORY.ref(4, r6 + 0x54).setu(r3);

            //LAB_80775b8
            switch(r1) {
              case 1 -> {
                r3 = MEMORY.ref(4, r6).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6).setu(r3);
              }

              case 2 -> {
                r3 = MEMORY.ref(4, r6 + 0x20).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x20).setu(r3);
              }

              case 3 -> {
                r3 = MEMORY.ref(4, r6 + 0x4).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x4).setu(r3);
              }

              case 4 -> {
                r3 = MEMORY.ref(4, r6 + 0x24).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x24).setu(r3);
              }

              case 5 -> {
                r3 = MEMORY.ref(4, r6 + 0x10).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x10).setu(r3);
              }

              case 6 -> {
                r3 = MEMORY.ref(4, r6 + 0x18).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x18).setu(r3);
              }

              case 0xf -> {
                r3 = MEMORY.ref(4, r6 + 0x28).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x28).setu(r3);
              }

              case 0x10 -> {
                r3 = MEMORY.ref(4, r6 + 0x30).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x30).setu(r3);
              }

              case 0x11 -> {
                r3 = MEMORY.ref(4, r6 + 0x38).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x38).setu(r3);
              }

              case 0x12 -> {
                r3 = MEMORY.ref(4, r6 + 0x40).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x40).setu(r3);
              }

              case 0x13 -> {
                r3 = MEMORY.ref(4, r6 + 0x2c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x2c).setu(r3);
              }

              case 0x14 -> {
                r3 = MEMORY.ref(4, r6 + 0x34).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x34).setu(r3);
              }

              case 0x15 -> {
                r3 = MEMORY.ref(4, r6 + 0x3c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x3c).setu(r3);
              }

              case 0x16 -> {
                r3 = MEMORY.ref(4, r6 + 0x44).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x44).setu(r3);
              }

              case 0x17 -> {
                r2 = CPU.movT(0, 0xa1);
                r2 = CPU.lslT(r2, 1);
                r1 = CPU.addT(r7, r2);
                r3 = MEMORY.ref(1, r1).getUnsigned();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(1, r1).setu(r3);
              }

              case 0x18 -> {
                r3 = MEMORY.ref(4, 0x80776e8).get();
                r1 = CPU.addT(r7, r3);
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = MEMORY.ref(1, r1).getUnsigned();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(1, r1).setu(r3);
              }

              case 0x19 -> {
                r0 = CPU.movT(0, 0x98);
                r0 = CPU.lslT(r0, 1);
                r3 = CPU.addT(r7, r0);
                r1 = MEMORY.ref(1, r3).getUnsigned();
                r2 = CPU.movT(0, 0x8);
                r2 = CPU.orrT(r2, r1);
                MEMORY.ref(1, r3).setu(r2);
              }

              case 0x1a -> {
                r3 = MEMORY.ref(4, r6 + 0x1c).get();
                r2 = MEMORY.ref(4, r6 + 0x54).get();
                r3 = CPU.addT(r3, r2);
                MEMORY.ref(4, r6 + 0x1c).setu(r3);
              }
            }

            //LAB_80776fc
            r1 = CPU.movT(0, 0x1);
            CPU.r8().value += r1;
            r2 = CPU.r8().value;
            CPU.cmpT(r2, 0x3);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              break;
            }
          } while(true);
        }

        //LAB_8077708
        r5 = CPU.addT(r5, 0x1);
        CPU.cmpT(r5, 0xe);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break;
        }
      } while(true);

      //LAB_8077710
      r3 = CPU.movT(0, 0x98);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.addT(r7, r3);
      r2 = MEMORY.ref(1, r1).getUnsigned();
      r3 = CPU.movT(0, 0x8);
      r3 = CPU.andT(r3, r2);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.movT(0, 0xa);
        r3 = CPU.negT(r3, r3);
        r3 = CPU.andT(r3, r2);
        MEMORY.ref(1, r1).setu(r3);
      }

      //LAB_8077728
      r0 = CPU.movT(0, 0x84);
      r0 = CPU.lslT(r0, 1);
      r0 = CPU.addT(r0, r7);
      r4 = CPU.movT(0, 0x0);
      CPU.r8().value = r0;

      //LAB_8077732
      do {
        r1 = CPU.r8().value;
        r1 = MEMORY.ref(4, r1).get();
        r5 = CPU.movT(0, 0x0);
        CPU.r10().value = r1;

        //LAB_807773a
        do {
          r3 = CPU.movT(0, 0x1);
          r3 = CPU.lslT(r3, r5);
          r2 = CPU.r10().value;
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r4, 0x0);
            r1 = CPU.addT(r5, 0x0);
            MEMORY.ref(4, CPU.sp().value).setu(r4);
            r0 = FUN_807a0cc(r0, r1);
            r3 = MEMORY.ref(4, r6).get();
            r2 = CPU.movT(0, 0x4);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6).setu(r3);
            r2 = CPU.movT(0, 0x5);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x4).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x4).setu(r3);
            r2 = CPU.movT(0, 0x6);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x8).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x8).setu(r3);
            r2 = CPU.movT(0, 0x7);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0xc).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0xc).setu(r3);
            r2 = CPU.movT(0, 0x8);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x10).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x10).setu(r3);
            r2 = CPU.movT(0, 0x9);
            r2 = MEMORY.ref(1, r0 + r2).get();
            r3 = MEMORY.ref(4, r6 + 0x18).get();
            r3 = CPU.addT(r3, r2);
            MEMORY.ref(4, r6 + 0x18).setu(r3);
            r4 = MEMORY.ref(4, CPU.sp().value).get();
          }

          //LAB_807778e
          r5 = CPU.addT(r5, 0x1);
          CPU.cmpT(r5, 0x13);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

        r3 = CPU.movT(0, 0x4);
        r4 = CPU.addT(r4, 0x1);
        CPU.r8().value += r3;
        CPU.cmpT(r4, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      r0 = MEMORY.ref(4, 0x80779fc).get();
      r3 = CPU.addT(r7, r0);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r0 = FUN_8079ad8(r0);
      r5 = CPU.addT(r0, 0x0);
      r2 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
      r3 = MEMORY.ref(4, r6).get();
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      MEMORY.ref(4, r6).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xa).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x8).get();
      MEMORY.ref(4, r6 + 0x4).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xb).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0xc).get();
      MEMORY.ref(4, r6 + 0x8).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xc).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x10).get();
      MEMORY.ref(4, r6 + 0xc).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      r2 = MEMORY.ref(1, r5 + 0xd).getUnsigned();
      r3 = MEMORY.ref(4, r6 + 0x18).get();
      MEMORY.ref(4, r6 + 0x10).setu(r0);
      r1 = CPU.movT(0, 0xa);
      r0 = CPU.addT(r2, 0x0);
      r0 = CPU.mulT(r0, r3);
      r0 = FUN_80022ec(r0, r1);
      MEMORY.ref(4, r6 + 0x18).setu(r0);
      r5 = CPU.movT(0, 0x0);

      //LAB_807780c
      do {
        r3 = CPU.lslT(r5, 1);
        r1 = CPU.addT(r3, 0x0);
        r1 = CPU.addT(r1, 0xd8);
        r2 = MEMORY.ref(2, r7 + r1).getUnsigned();
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 2);
        r3 = CPU.andT(r3, r2);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = MEMORY.ref(2, r7 + r1).getUnsigned();
          r0 = FUN_8078414(r0);
          r1 = CPU.movT(0, 0x0);
          MEMORY.ref(4, r6 + 0x58).setu(r0);
          CPU.r8().value = r1;

          //LAB_807782a
          do {
            r0 = CPU.r8().value;
            r2 = MEMORY.ref(4, r6 + 0x58).get();
            r3 = CPU.lslT(r0, 2);
            r3 = CPU.addT(r3, 0x18);
            r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
            r2 = CPU.addT(r2, r3);
            r3 = CPU.movT(0, 0x1);
            r3 = MEMORY.ref(1, r2 + r3).get();
            MEMORY.ref(4, r6 + 0x48).setu(r1);
            r1 = CPU.subT(r1, 0x7);
            MEMORY.ref(4, r6 + 0x54).setu(r3);

            switch(r1) {
              case 7 -> {
                r2 = MEMORY.ref(4, r6).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6).setu(r0);
              }

              case 8 -> {
                r2 = MEMORY.ref(4, r6 + 0x20).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x20).setu(r0);
              }

              case 9 -> {
                r2 = MEMORY.ref(4, r6 + 0x4).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x4).setu(r0);
              }

              case 0xa -> {
                r2 = MEMORY.ref(4, r6 + 0x24).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x24).setu(r0);
              }

              case 0xb -> {
                r2 = MEMORY.ref(4, r6 + 0x8).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x8).setu(r0);
              }

              case 0xc -> {
                r2 = MEMORY.ref(4, r6 + 0xc).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0xc).setu(r0);
              }

              case 0xd -> {
                r2 = MEMORY.ref(4, r6 + 0x10).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x10).setu(r0);
              }

              case 0xe -> {
                r2 = MEMORY.ref(4, r6 + 0x18).get();
                r3 = MEMORY.ref(4, r6 + 0x54).get();
                r1 = CPU.movT(0, 0xa);
                r0 = CPU.addT(r3, 0x0);
                r0 = CPU.mulT(r0, r2);
                r0 = FUN_80022ec(r0, r1);
                MEMORY.ref(4, r6 + 0x18).setu(r0);
              }
            }

            //LAB_80778fa
            r1 = CPU.movT(0, 0x1);
            CPU.r8().value += r1;
            r2 = CPU.r8().value;
            CPU.cmpT(r2, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
        }

        //LAB_8077904
        r5 = CPU.addT(r5, 0x1);
        CPU.cmpT(r5, 0xe);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          break;
        }
      } while(true);
    }

    //LAB_807790c
    r0 = MEMORY.ref(4, 0x8077a04).get();
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0x8).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077922
    r3 = CPU.asrT(r3, 3);
    r1 = MEMORY.ref(4, 0x8077a08).get();
    MEMORY.ref(4, r6 + 0x8).setu(r3);
    r3 = CPU.addT(r7, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0xc).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_807793c
    r3 = CPU.asrT(r3, 3);
    r2 = MEMORY.ref(4, 0x8077a0c).get();
    MEMORY.ref(4, r6 + 0xc).setu(r3);
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.lslT(r3, 24);
    r3 = CPU.asrT(r3, 24);
    r2 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = CPU.addT(r3, 0x8);
    r3 = CPU.mulT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.addT(r3, 0x7);
    }

    //LAB_8077956
    r3 = CPU.asrT(r3, 3);
    MEMORY.ref(4, r6 + 0x10).setu(r3);
    r3 = CPU.movT(0, 0x96);
    r3 = CPU.lslT(r3, 1);
    r4 = CPU.movT(0, 0x28);
    r5 = CPU.movT(0, 0x3);
    r0 = CPU.addT(r7, r3);

    //LAB_8077964
    do {
      r3 = MEMORY.ref(1, r0).getUnsigned();
      r3 = CPU.lslT(r3, 24);
      r3 = CPU.asrT(r3, 24);
      r2 = CPU.addT(r3, 0x0);
      r2 = CPU.mulT(r2, r3);
      r2 = CPU.addT(r2, r3);
      r1 = CPU.lslT(r2, 2);
      r3 = MEMORY.ref(4, r4 + r6).get();
      r1 = CPU.addT(r1, r2);
      r3 = CPU.addT(r3, r1);
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r4 + r6).setu(r3);
      r0 = CPU.addT(r0, 0x1);
      r4 = CPU.addT(r4, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r1 = MEMORY.ref(4, 0x8077a10).get();
    r5 = CPU.movT(0, 0x3);
    r0 = CPU.addT(r7, r1);
    r1 = CPU.movT(0, 0x2c);

    //LAB_807798c
    do {
      r3 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(1, r0 + r3).get();
      r2 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r2, r3);
      r3 = MEMORY.ref(4, r1 + r6).get();
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.addT(r3, r2);
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(4, r1 + r6).setu(r3);
      r1 = CPU.addT(r1, 0x8);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r2 = MEMORY.ref(4, 0x80779fc).get();
    r3 = CPU.addT(r7, r2);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x94);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r7, r1);
      r3 = MEMORY.ref(1, r3).getUnsigned();
      r0 = CPU.movT(0, 0x0);

      switch(r3) {
        case 0 -> {
          r0 = CPU.movT(0, 0x88);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }

        case 1 -> {
          r0 = CPU.movT(0, 0x89);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }

        case 2 -> {
          r0 = MEMORY.ref(4, 0x8077a18).get();
          r0 = FUN_8079338(r0);
        }

        case 3 -> {
          r0 = MEMORY.ref(4, 0x8077a1c).get();
          r0 = FUN_8079338(r0);
        }

        case 5 -> {
          r0 = CPU.movT(0, 0x89);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_8079338(r0);
        }
      }

      //LAB_8077a28
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = MEMORY.ref(4, r6 + 0x24).get();
        r3 = CPU.addT(r3, 0x4);
        MEMORY.ref(4, r6 + 0x24).setu(r3);
      }
    }

    //LAB_8077a32
    r3 = MEMORY.ref(4, r6 + 0x8).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x8).setu(r3);
    }

    //LAB_8077a3c
    r2 = MEMORY.ref(4, 0x8077bf8).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x8).setu(r2);
    }

    //LAB_8077a44
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0xc).setu(r3);
    }

    //LAB_8077a4e
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0xc).setu(r2);
    }

    //LAB_8077a54
    r3 = MEMORY.ref(4, r6 + 0x10).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x10).setu(r3);
    }

    //LAB_8077a5e
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x10).setu(r2);
    }

    //LAB_8077a64
    r3 = MEMORY.ref(4, r6 + 0x18).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a6e
    CPU.cmpT(r3, 0x63);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x63);
      MEMORY.ref(4, r6 + 0x18).setu(r3);
    }

    //LAB_8077a76
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a80
    CPU.cmpT(r3, 0x2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x2);
      MEMORY.ref(4, r6 + 0x1c).setu(r3);
    }

    //LAB_8077a88
    r3 = MEMORY.ref(4, r6 + 0x20).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x20).setu(r3);
    }

    //LAB_8077a92
    r2 = MEMORY.ref(4, 0x8077bfc).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x20).setu(r2);
    }

    //LAB_8077a9a
    r3 = MEMORY.ref(4, r6 + 0x24).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aa4
    CPU.cmpT(r3, 0xc8);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0xc8);
      MEMORY.ref(4, r6 + 0x24).setu(r3);
    }

    //LAB_8077aac
    r2 = CPU.movT(0, 0xc8);
    CPU.r12().value = r2;
    r1 = CPU.addT(r6, 0x0);
    r2 = CPU.addT(r6, 0x0);
    r5 = CPU.movT(0, 0x0);
    r0 = CPU.movT(0, 0x0);
    r4 = CPU.movT(0, 0x2c);
    r2 = CPU.addT(r2, 0x28);
    r1 = CPU.addT(r1, 0x2c);

    //LAB_8077abe
    do {
      r3 = MEMORY.ref(4, r2).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r2).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ac8
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r2).setu(r3);
      }

      //LAB_8077ad0
      r3 = MEMORY.ref(4, r1).get();
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        MEMORY.ref(4, r1).setu(r0);
        r3 = CPU.addT(r0, 0x0);
      }

      //LAB_8077ada
      CPU.cmpT(r3, 0xc8);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r3 = CPU.r12().value;
        MEMORY.ref(4, r6 + r4).setu(r3);
      }

      //LAB_8077ae2
      r5 = CPU.addT(r5, 0x1);
      r1 = CPU.addT(r1, 0x8);
      r4 = CPU.addT(r4, 0x8);
      r2 = CPU.addT(r2, 0x8);
      CPU.cmpT(r5, 0x3);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r3 = MEMORY.ref(4, r6 + 0x8).get();
    MEMORY.ref(2, r7 + 0x3c).setu(r3);
    r3 = MEMORY.ref(4, r6 + 0xc).get();
    MEMORY.ref(2, r7 + 0x3e).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r2 = MEMORY.ref(4, r6 + 0x10).get();
    r3 = CPU.addT(r3, 0x40);
    MEMORY.ref(2, r3).setu(r2);
    r2 = CPU.addT(r7, 0x0);
    r3 = MEMORY.ref(4, r6 + 0x18).get();
    r2 = CPU.addT(r2, 0x42);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, r6 + 0x1c).get();
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r3 = CPU.addT(r7, 0x0);
    r2 = MEMORY.ref(4, r6 + 0x20).get();
    r3 = CPU.addT(r3, 0x44);
    MEMORY.ref(1, r3).setu(r2);
    r2 = CPU.addT(r7, 0x0);
    r3 = MEMORY.ref(4, r6 + 0x24).get();
    r2 = CPU.addT(r2, 0x45);
    MEMORY.ref(1, r2).setu(r3);
    r1 = CPU.addT(r7, 0x0);
    r2 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0x48);
    r2 = CPU.addT(r2, 0x28);
    r5 = CPU.movT(0, 0x3);

    //LAB_8077b26
    do {
      r3 = MEMORY.ref(4, r2).get();
      MEMORY.ref(2, r1).setu(r3);
      r3 = MEMORY.ref(4, r2 + 0x4).get();
      r5 = CPU.subT(r5, 0x1);
      MEMORY.ref(2, r1 + 0x2).setu(r3);
      r2 = CPU.addT(r2, 0x8);
      r1 = CPU.addT(r1, 0x4);
      CPU.cmpT(r5, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    r0 = MEMORY.ref(4, 0x8077c00).get();
    r3 = CPU.addT(r7, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r1 = MEMORY.ref(4, 0x8077c04).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = MEMORY.ref(4, 0x8077c08).get();
    }

    //LAB_8077b46
    r3 = CPU.movT(0, 0x34);
    r2 = MEMORY.ref(2, r7 + r3).get();
    r3 = MEMORY.ref(4, r6).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6).setu(r3);
    }

    //LAB_8077b54
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077b5c
    MEMORY.ref(2, r7 + 0x34).setu(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0x14);
      r2 = MEMORY.ref(2, r7 + r0).get();
      r3 = MEMORY.ref(4, r6).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8077c0c).get();
        r2 = CPU.addT(r2, r3);
      }

      //LAB_8077b76
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x0);
      }

      //LAB_8077b7e
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077b84
      r0 = CPU.movT(0, 0x38);
      r3 = MEMORY.ref(2, r7 + r0).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x1);
        }
      }

      //LAB_8077b92
      MEMORY.ref(2, r7 + 0x38).setu(r2);
    }

    //LAB_8077b94
    r3 = CPU.movT(0, 0x36);
    r2 = MEMORY.ref(2, r7 + r3).get();
    r3 = MEMORY.ref(4, r6 + 0x4).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(4, r6 + 0x4).setu(r3);
    }

    //LAB_8077ba2
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      MEMORY.ref(4, r6 + 0x4).setu(r1);
      r3 = CPU.addT(r1, 0x0);
    }

    //LAB_8077baa
    MEMORY.ref(2, r7 + 0x36).setu(r3);
    r3 = CPU.lslT(r3, 16);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.cmpT(r2, r3);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.movT(0, 0x16);
      r2 = MEMORY.ref(2, r7 + r0).get();
      r3 = MEMORY.ref(4, r6 + 0x4).get();
      r2 = CPU.mulT(r2, r3);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r3 = MEMORY.ref(4, 0x8077c0c).get();
        r2 = CPU.addT(r2, r3);
      }

      //LAB_8077bc4
      r2 = CPU.asrT(r2, 14);
      CPU.cmpT(r2, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r2 = CPU.movT(0, 0x0);
      }

      //LAB_8077bcc
      r2 = CPU.cmpT(r2, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.addT(r1, 0x0);
      }

      //LAB_8077bd2
      r0 = CPU.movT(0, 0x3a);
      r3 = MEMORY.ref(2, r7 + r0).get();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r2, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = CPU.movT(0, 0x1);
        }
      }

      //LAB_8077be0
      MEMORY.ref(2, r7 + 0x3a).setu(r2);
    }

    //LAB_8077be2
    r0 = CPU.addT(r6, 0x0);
    FUN_8002df0(r0);
    CPU.sp().value += 0x4;
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8077c10)
  public static void FUN_8077c10() {
    int r0;
    int r1;
    int r2;
    int r3;
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

    r0 = MEMORY.ref(4, 0x8077cb0).get();
    CPU.sp().value -= 0x8;
    FUN_8079374(r0);
    r0 = FUN_80795fc();
    CPU.r10().value = r0;
    r0 = CPU.movT(0, 0x0);
    CPU.r8().value = r0;
    CPU.cmpT(CPU.r8().value, CPU.r10().value);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = MEMORY.ref(4, 0x8077cb4).get();
      r2 = CPU.movT(0, 0xfc);
      r2 = CPU.lslT(r2, 1);
      r2 = CPU.addT(r2, r3);
      r3 = CPU.movT(0, 0x80);
      r3 = CPU.lslT(r3, 2);
      CPU.r9().value = r2;
      CPU.r11().value = r3;

      //LAB_8077c44
      do {
        r2 = CPU.r9().value;
        r0 = MEMORY.ref(1, r2).getUnsigned();
        r0 = FUN_8077394(r0);
        r2 = CPU.movT(0, 0xd8);
        r7 = CPU.addT(r0, 0x0);
        r1 = CPU.movT(0, 0xe);

        //LAB_8077c52
        do {
          r3 = MEMORY.ref(2, r2 + r7).getUnsigned();
          r0 = CPU.r11().value;
          r3 = CPU.andT(r3, r0);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(2, r2 + r7).getUnsigned();
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
            MEMORY.ref(4, CPU.sp().value).setu(r2);
            r0 = FUN_8078414(r0);
            r5 = CPU.addT(r0, 0x0);
            r2 = MEMORY.ref(4, CPU.sp().value).get();
            r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            r5 = CPU.addT(r5, 0x18);
            r6 = CPU.movT(0, 0x3);

            //LAB_8077c70
            do {
              r3 = MEMORY.ref(1, r5).getUnsigned();
              r5 = CPU.addT(r5, 0x4);
              CPU.cmpT(r3, 0x1b);
              if(CPU.cpsr().getZero()) { // ==
                r0 = MEMORY.ref(4, 0x8077cb0).get();
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
                MEMORY.ref(4, CPU.sp().value).setu(r2);
                FUN_8079358(r0);
                r2 = MEMORY.ref(4, CPU.sp().value).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              }

              //LAB_8077c86
              r6 = CPU.subT(r6, 0x1);
              CPU.cmpT(r6, 0x0);
            } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
          }

          //LAB_8077c8c
          r1 = CPU.subT(r1, 0x1);
          r2 = CPU.addT(r2, 0x2);
          CPU.cmpT(r1, 0x0);
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

        r2 = CPU.movT(0, 0x1);
        CPU.r8().value += r2;
        CPU.r9().value += r2;
        CPU.cmpT(CPU.r8().value, CPU.r10().value);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    }

    //LAB_8077c9e
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x8077cb8)
  public static int FUN_8077cb8() {
    int r0;
    final int r1;
    int r2;
    int r3;
    int r4;
    int r5;

    r0 = getPointerTableEntry(2);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.lslT(r2, 2);
    r1 = MEMORY.ref(4, 0x8077d2c).get();
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r5 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r5, r3);
    r5 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r0, 0x1);
    r4 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    r0 = CPU.addT(r0, 0x1);
    r2 = MEMORY.ref(1, r0).getUnsigned();
    r3 = CPU.addT(r4, r3);
    r4 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r3, r1);
    r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
    r5 = CPU.subT(r5, 0x30);
    r3 = CPU.addT(r2, r3);
    r2 = CPU.addT(r3, 0x0);
    r4 = CPU.subT(r4, 0x30);
    r3 = CPU.lslT(r5, 4);
    r3 = CPU.addT(r3, r4);
    r2 = CPU.subT(r2, 0x30);
    r3 = CPU.lslT(r3, 6);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 16);
    r2 = CPU.lslT(r2, 21);
    r2 = CPU.orrT(r2, r3);
    r3 = MEMORY.ref(4, 0x8077d30).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    r0 = CPU.asrT(r2, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = MEMORY.ref(4, 0x8077d34).get();
      r0 = CPU.orrT(r0, r3);
    }

    //LAB_8077d1e
    r0 = CPU.lslT(r0, 16);
    r0 = CPU.lsrT(r0, 16);
    return r0;
  }

  @Method(0x8077d38)
  public static void FUN_8077d38() {
    int r0;
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

    CPU.sp().value -= 0x8;
    r5 = CPU.sp().value + 0x4;
    r4 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077df0).get();
    r2 = MEMORY.ref(4, 0x8077df4).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    MEMORY.ref(4, r5).setu(r4);
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077df8).get();
    r2 = MEMORY.ref(4, 0x8077dfc).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.movT(0, 0x80);
    r2 = MEMORY.ref(4, 0x8077dec).get();
    r3 = CPU.lslT(r3, 24);

    //LAB_8077d66
    do {
      r4 = MEMORY.ref(4, r2 + 0x8).get();
      r4 = CPU.andT(r4, r3);
      CPU.cmpT(r4, 0x0);
    } while(!CPU.cpsr().getZero()); // !=

    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r0 = CPU.addT(r5, 0x0);
    r1 = MEMORY.ref(4, 0x8077e00).get();
    r2 = MEMORY.ref(4, 0x8077e04).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    r3 = MEMORY.ref(4, 0x8077df8).get();
    r1 = CPU.movT(0, 0x82);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r3, r1);
    r2 = CPU.movT(0, 0xff);
    MEMORY.ref(1, r3).setu(r2);
    r0 = CPU.addT(r5, 0x0);
    MEMORY.ref(4, r5).setu(r4);
    r3 = MEMORY.ref(4, 0x8077dec).get();
    r1 = MEMORY.ref(4, 0x8077e08).get();
    r2 = MEMORY.ref(4, 0x8077e0c).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;
    r3 = CPU.subT(r3, 0xc);
    MEMORY.ref(4, CPU.sp().value).setu(r4);
    FUN_8078ee8();
    r7 = MEMORY.ref(4, 0x8077df0).get();
    r3 = CPU.movT(0, 0x84);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x1);
    MEMORY.ref(2, r2).setu(r3);
    r1 = MEMORY.ref(4, 0x8077de4).get();
    r2 = MEMORY.ref(4, 0x8077e10).get();
    CPU.r10().value = r1;
    r3 = CPU.addT(r7, r2);
    r1 = CPU.movT(0, 0x2);
    MEMORY.ref(2, r3).setu(r1);
    r3 = CPU.movT(0, 0x85);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = MEMORY.ref(4, 0x8077de8).get();
    CPU.r8().value = r3;
    r3 = CPU.movT(0, 0x4);
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x8077e14).get();
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x8);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.movT(0, 0x86);
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.subT(r3, 0x18);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.addT(r3, 0x1a);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 1);
    MEMORY.ref(2, r2).setu(r3);
    r2 = CPU.movT(0, 0x87);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(2, r3).setu(r1);
    r1 = CPU.movT(0, 0x88);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r1 = CPU.lslT(r1, 2);
    r3 = CPU.addT(r7, r1);
    r2 = CPU.addT(r2, 0x6);
    MEMORY.ref(2, r3).setu(r4);
    r1 = CPU.subT(r1, 0x2c);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(2, r3).setu(r4);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(4, r3).setu(r4);
    r0 = CPU.movT(0, 0x0);
    r0 = FUN_807961c(r0);
    r2 = CPU.movT(0, 0x83);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r5 = MEMORY.ref(4, 0x8077e78).get();
    r2 = CPU.lslT(r2, 2);
    r1 = MEMORY.ref(4, 0x8077e80).get();
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(4, r7 + 0x10).setu(r4);
    r2 = CPU.subT(r2, 0x1);
    MEMORY.ref(1, r3).setu(r5);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r5);
    r1 = CPU.subT(r1, 0x5);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r5);
    r6 = MEMORY.ref(4, 0x8077e7c).get();
    r3 = CPU.addT(r7, r1);
    r2 = CPU.r10().value;
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    MEMORY.ref(4, r7).setu(r4);
    r0 = FUN_8077cb8();
    r2 = CPU.movT(0, 0xae);
    r2 = CPU.lslT(r2, 2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(4, r3).setu(r0);
    r4 = MEMORY.ref(4, CPU.sp().value).get();
    r3 = MEMORY.ref(4, 0x8077e84).get();
    MEMORY.ref(4, r3).setu(r4);
    r3 = MEMORY.ref(4, 0x8077ee4).get();
    r1 = CPU.r10().value;
    MEMORY.ref(1, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x8077ee8).get();
    r2 = MEMORY.ref(1, r3).getUnsigned();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(4, r7 + 0x4).setu(r4);
    MEMORY.ref(1, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x8077eec).get();
    r2 = MEMORY.ref(4, 0x8077ef0).get();
    MEMORY.ref(2, r3).setu(r4);
    r3 = MEMORY.ref(4, 0x8077ee0).get();
    MEMORY.ref(2, r2).setu(r3);
    r2 = MEMORY.ref(4, 0x8077ef4).get();
    r1 = CPU.r8().value;
    r3 = CPU.addT(r7, r2);
    r2 = CPU.addT(r2, 0x1);
    MEMORY.ref(1, r3).setu(r1);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r1);
    r1 = MEMORY.ref(4, 0x8077ef8).get();
    r2 = CPU.r8().value;
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r1 = CPU.addT(r1, 0x1);
    r2 = MEMORY.ref(4, 0x8077efc).get();
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    r1 = CPU.addT(r1, 0x2);
    r3 = CPU.addT(r7, r2);
    MEMORY.ref(1, r3).setu(r6);
    r2 = CPU.addT(r2, 0x2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r6);
    r1 = CPU.addT(r1, 0x2);
    r3 = CPU.addT(r7, r2);
    r2 = CPU.movT(0, 0x10);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r2 = CPU.movT(0, 0x93);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r7, r2);
    r1 = CPU.addT(r1, 0x2);
    r2 = CPU.movT(0, 0x20);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = CPU.addT(r7, r1);
    MEMORY.ref(1, r3).setu(r2);
    r3 = MEMORY.ref(4, 0x8077f3c).get();
    r1 = CPU.addT(r1, 0x2);
    r2 = CPU.addT(r7, r3);
    r3 = CPU.movT(0, 0x40);
    MEMORY.ref(1, r2).setu(r3);
    r2 = CPU.addT(r7, r1);
    r1 = CPU.addT(r1, 0x1);
    MEMORY.ref(1, r2).setu(r3);
    r2 = CPU.addT(r7, r1);
    MEMORY.ref(1, r2).setu(r3);
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x8078414)
  public static int FUN_8078414(int r0) {
    final int r2;
    int r3;
    r3 = MEMORY.ref(4, 0x8078424).get();
    r2 = CPU.movT(0, 0x2c);
    r3 = CPU.andT(r3, r0);
    r0 = CPU.addT(r3, 0x0);
    r0 = CPU.mulT(r0, r2);
    r3 = MEMORY.ref(4, 0x8078428).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x807842c)
  public static int FUN_807842c(int r0, final int r1) {
    int r3;
    final int r5;
    int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8078414(r0);
    r3 = CPU.movT(0, 0x94);
    r3 = CPU.lslT(r3, 1);
    r6 = CPU.addT(r6, r3);
    r3 = MEMORY.ref(1, r6).getUnsigned();
    r0 = MEMORY.ref(2, r0 + 0x4).getUnsigned();
    CPU.cmpT(r3, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_807844e
      r3 = MEMORY.ref(1, r6).getUnsigned();
      r0 = CPU.asrT(r0, r3);
      r3 = CPU.movT(0, 0x1);
      r0 = CPU.andT(r0, r3);
    }

    //LAB_8078456
    return r0;
  }

  @Method(0x8078588)
  public static int FUN_8078588(int r0, int r1) {
    int r2;
    int r3;
    int r4;
    final int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r6 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r5, 0x0);
    r0 = FUN_8078414(r0);
    r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
    r3 = CPU.movT(0, 0x10);
    r3 = CPU.andT(r3, r2);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xd8);
      r3 = MEMORY.ref(2, r6 + r3).getUnsigned();
      r2 = MEMORY.ref(4, 0x8078610).get();
      r3 = CPU.eorT(r3, r5);
      r3 = CPU.andT(r3, r2);
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.addT(r2, 0x0);
        r2 = CPU.addT(r6, 0x0);
        r2 = CPU.addT(r2, 0xd8);

        //LAB_80785b8
        do {
          r0 = CPU.addT(r0, 0x1);
          CPU.cmpT(r0, 0xe);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r2 = CPU.addT(r2, 0x2);
          r3 = MEMORY.ref(2, r2).getUnsigned();
          r3 = CPU.eorT(r3, r5);
          r3 = CPU.andT(r3, r1);
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80785ca
      CPU.cmpT(r0, 0xf);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.lslT(r0, 1);
        r4 = CPU.addT(r3, 0x0);
        r4 = CPU.addT(r4, 0xd8);
        r1 = MEMORY.ref(2, r6 + r4).getUnsigned();
        r3 = CPU.lsrT(r1, 11);
        r2 = CPU.addT(r3, 0x1);
        CPU.cmpT(r2, 0x1d);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r0 = CPU.movT(0, 0x1);
          r0 = CPU.negT(r0, r0);
          return r0;
        }
        r3 = MEMORY.ref(4, 0x8078614).get();
        r2 = CPU.lslT(r2, 11);
        r3 = CPU.andT(r3, r1);
        r3 = CPU.orrT(r3, r2);
        MEMORY.ref(2, r6 + r4).setu(r3);
        return r0;
      }
    }

    //LAB_80785ee
    r2 = CPU.addT(r6, 0x0);
    r0 = CPU.movT(0, 0x0);
    r2 = CPU.addT(r2, 0xd8);
    r1 = CPU.movT(0, 0xd8);

    //LAB_80785f6
    do {
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r2 = CPU.addT(r2, 0x2);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        //LAB_80785ea
        MEMORY.ref(2, r6 + r1).setu(r5);
        return r0;
      }
      r0 = CPU.addT(r0, 0x1);
      r1 = CPU.addT(r1, 0x2);
      CPU.cmpT(r0, 0xe);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    //LAB_8078606
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.negT(r0, r0);

    //LAB_807860a
    return r0;
  }

  @Method(0x8078708)
  public static int FUN_8078708(int r0, int r1) {
    int r2;
    int r3;
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

    r5 = CPU.addT(r1, 0x0);
    CPU.r10().value = r0;
    r0 = FUN_8077394(r0);
    r5 = CPU.lslT(r5, 1);
    CPU.r11().value = r5;
    r3 = CPU.r11().value;
    r7 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r3, 0xd8);
    r5 = MEMORY.ref(2, r7 + r3).getUnsigned();
    r0 = CPU.r10().value;
    r1 = CPU.addT(r5, 0x0);
    r0 = FUN_807842c(r0, r1);
    CPU.cmpT(r0, 0x0);

    jmp_80787cc:
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0x1);
      r0 = CPU.negT(r0, r0);
    } else {
      //LAB_807873c
      r2 = CPU.movT(0, 0x80);
      r2 = CPU.lslT(r2, 2);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.andT(r3, r2);
      CPU.r9().value = r2;
      r0 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_8078414(r0);
        r0 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
        CPU.r8().value = r0;
        CPU.cmpT(r0, 0x6);
        if(!CPU.cpsr().getZero()) { // !=
          r6 = CPU.movT(0, 0x0);
          r5 = CPU.movT(0, 0xd8);

          //LAB_8078764
          while(true) {
            CPU.cmpT(r6, 0xe);
            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
              break;
            }
            r3 = MEMORY.ref(2, r5 + r7).getUnsigned();
            r2 = CPU.r9().value;
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_8078760
              r5 = CPU.addT(r5, 0x2);
              r6 = CPU.addT(r6, 0x1);
              continue;
            }
            r0 = MEMORY.ref(2, r5 + r7).getUnsigned();
            r0 = FUN_8078414(r0);
            r3 = MEMORY.ref(1, r0 + 0x2).getUnsigned();
            CPU.cmpT(r3, CPU.r8().value);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_8078760
              r5 = CPU.addT(r5, 0x2);
              r6 = CPU.addT(r6, 0x1);
              continue;
            }

            break;
          }

          //LAB_807877e
          CPU.cmpT(r6, 0xf);
          if(!CPU.cpsr().getZero()) { // !=
            r3 = CPU.lslT(r6, 1);
            r6 = CPU.addT(r3, 0x0);
            r6 = CPU.addT(r6, 0xd8);
            r0 = MEMORY.ref(2, r7 + r6).getUnsigned();
            r0 = FUN_8078414(r0);
            r2 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
            r3 = CPU.movT(0, 0x2);
            r3 = CPU.andT(r3, r2);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.movT(0, 0x2);
              r0 = CPU.negT(r0, r0);
              break jmp_80787cc;
            }

            //LAB_807879e
            r2 = MEMORY.ref(2, r7 + r6).getUnsigned();
            r3 = MEMORY.ref(4, 0x80787c8).get();
            r3 = CPU.andT(r3, r2);
            MEMORY.ref(2, r7 + r6).setu(r3);
          }
        }

        //LAB_80787a6
        r3 = CPU.r11().value;
        r3 = CPU.addT(r3, 0xd8);
        r2 = MEMORY.ref(2, r7 + r3).getUnsigned();
        r1 = MEMORY.ref(4, 0x80787c4).get();
        r2 = CPU.orrT(r2, r1);
        MEMORY.ref(2, r7 + r3).setu(r2);
        r0 = CPU.r10().value;
        FUN_8078bf0(r0);
        r0 = CPU.r10().value;
        FUN_8077428(r0);
        r0 = CPU.movT(0, 0x0);
      }
    }

    //LAB_80787cc
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x8078bf0)
  public static int FUN_8078bf0(int r0) {
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

    CPU.sp().value -= 0x8;
    r0 = FUN_8077394(r0);
    r5 = MEMORY.ref(4, 0x8078c50).get();
    CPU.r9().value = r0;
    r0 = CPU.movT(0, 0x58);
    r5 += CPU.r9().value;
    r0 += CPU.r9().value;
    CPU.r8().value = r0;
    r0 = MEMORY.ref(1, r5).getUnsigned();
    r0 = FUN_8079ad8(r0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
    r3 = MEMORY.ref(1, r5).getUnsigned();
    r4 = CPU.movT(0, 0x80);
    r4 = CPU.lslT(r4, 8);
    r1 = MEMORY.ref(4, 0x8078c4c).get();
    r2 = CPU.r8().value;
    r5 = CPU.movT(0, 0x1f);
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8078c2c
      do {
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.andT(r3, r4);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(r1);
        }

        //LAB_8078c36
        r5 = CPU.subT(r5, 0x1);
        r2 = CPU.addT(r2, 0x4);
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r4 = CPU.movT(0, 0x80);
      r1 = MEMORY.ref(4, 0x8078c4c).get();
      r4 = CPU.lslT(r4, 7);
      r2 = CPU.r8().value;
      r5 = CPU.movT(0, 0x1f);

      //LAB_8078c54
      do {
        r3 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.andT(r3, r4);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          MEMORY.ref(2, r2).setu(r1);
        }

        //LAB_8078c5e
        r5 = CPU.subT(r5, 0x1);
        r2 = CPU.addT(r2, 0x4);
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      r1 = CPU.r8().value;
      r4 = CPU.movT(0, 0x1f);
      r5 = CPU.movT(0, 0x1f);
      r1 = CPU.addT(r1, 0x7c);

      //LAB_8078c6e
      do {
        r3 = CPU.lslT(r4, 2);
        r0 = CPU.r8().value;
        r2 = MEMORY.ref(2, r3 + r0).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r4 = CPU.subT(r4, 0x1);
        } else {
          //LAB_8078c7e
          MEMORY.ref(2, r1).setu(r2);
          r4 = CPU.subT(r4, 0x1);
          r1 = CPU.subT(r1, 0x4);
          r5 = CPU.subT(r5, 0x1);
        }

        //LAB_8078c86
        CPU.cmpT(r4, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // <
        r3 = CPU.lslT(r5, 2);
        r2 = MEMORY.ref(4, 0x8078ca0).get();
        r3 += CPU.r8().value;

        //LAB_8078c94
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r3).setu(r2);
          r3 = CPU.subT(r3, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
      }

      //LAB_8078ca4
      r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
      r1 = CPU.movT(0, 0x80);
      r2 = CPU.addT(r2, 0x10);
      r1 = CPU.lslT(r1, 8);
      CPU.lr().value = r2;
      r3 = CPU.movT(0, 0x10);
      r5 = CPU.movT(0, 0x0);
      CPU.r11().value = r1;
      CPU.r10().value = r3;
      r7 = CPU.lr().value;

      //LAB_8078cb8
      do {
        r3 = MEMORY.ref(1, r7).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.r9().value;
          r1 = CPU.lr().value;
          r2 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
          r3 = MEMORY.ref(1, r1 + 0x1).getUnsigned();
          r2 = CPU.cmpT(r2, r3);
          if(CPU.cpsr().getCarry()) { // unsigned >=
            r2 = CPU.r8().value;
            r6 = MEMORY.ref(2, r2).getUnsigned();
            r3 = MEMORY.ref(1, r1).getUnsigned();
            CPU.r12().value = r6;
            r4 = CPU.movT(0, 0x0);
            CPU.cmpT(CPU.r12().value, r3);
            if(!CPU.cpsr().getZero()) { // !=
              CPU.r12().value = CPU.r10().value;
              r1 = CPU.r8().value;

              //LAB_8078cdc
              do {
                r4 = CPU.addT(r4, 0x1);
                CPU.cmpT(r4, 0x1f);
                if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                  break;
                }
                r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r1 = CPU.addT(r1, 0x4);
                r0 = CPU.r12().value;
                r2 = MEMORY.ref(2, r1).getUnsigned();
                r3 = MEMORY.ref(1, r3 + r0).getUnsigned();
                r2 = CPU.cmpT(r2, r3);
              } while(!CPU.cpsr().getZero()); // !=
            }

            //LAB_8078cf0
            CPU.cmpT(r4, 0x20);
            if(CPU.cpsr().getZero()) { // ==
              r3 = CPU.addT(r6, 0x0);
              r4 = CPU.movT(0, 0x0);
              CPU.cmpT(r3, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r3 = MEMORY.ref(1, r7).getUnsigned();
                r1 = CPU.r11().value;
                r3 = CPU.orrT(r3, r1);
                r2 = CPU.r8().value;
                MEMORY.ref(2, r2).setu(r3);
              } else {
                //LAB_8078d06
                while(true) {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x1f);
                  if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                    r3 = CPU.lslT(r4, 2);
                    r0 = CPU.r8().value;
                    r2 = CPU.addT(r3, r0);
                    r3 = MEMORY.ref(2, r2).getUnsigned();
                    CPU.cmpT(r3, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      continue;
                    }
                    r3 = MEMORY.ref(1, r7).getUnsigned();
                    r1 = CPU.r11().value;
                    r3 = CPU.orrT(r3, r1);

                    //LAB_8078d1e
                    MEMORY.ref(2, r2).setu(r3);
                  }

                  break;
                }
              }

              //LAB_8078d20
              CPU.cmpT(r4, 0x20);
              if(CPU.cpsr().getZero()) { // ==
                break;
              }
            }
          }
        }

        //LAB_8078d24
        r2 = CPU.movT(0, 0x4);
        r5 = CPU.addT(r5, 0x1);
        CPU.lr().value += r2;
        r7 = CPU.addT(r7, 0x4);
        CPU.r10().value += r2;
        CPU.cmpT(r5, 0xf);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      //LAB_8078d32
      r3 = CPU.movT(0, 0xd8);
      r5 = CPU.movT(0, 0x0);
      CPU.r10().value = r3;

      //LAB_8078d38
      do {
        r0 = CPU.r10().value;
        r1 = CPU.r9().value;
        r2 = MEMORY.ref(2, r0 + r1).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = MEMORY.ref(4, 0x8078d68).get();
          r3 = CPU.andT(r3, r2);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(2, r0 + r1).getUnsigned();
            r0 = FUN_8078414(r0);
            r3 = MEMORY.ref(1, r0 + 0xc).getUnsigned();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r2 = CPU.r8().value;
              r6 = MEMORY.ref(2, r2).getUnsigned();
              r3 = MEMORY.ref(4, 0x8078d6c).get();
              r0 = MEMORY.ref(2, r0 + 0x28).getUnsigned();
              r3 = CPU.andT(r3, r6);
              CPU.r12().value = r0;
              r4 = CPU.movT(0, 0x0);
              CPU.cmpT(r3, CPU.r12().value);
              if(!CPU.cpsr().getZero()) { // !=
                r7 = MEMORY.ref(4, 0x8078da4).get();
                r1 = CPU.r8().value;

                //LAB_8078d78
                do {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x1f);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    break;
                  }
                  r1 = CPU.addT(r1, 0x4);
                  r2 = MEMORY.ref(2, r1).getUnsigned();
                  r3 = CPU.addT(r7, 0x0);
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, CPU.r12().value);
                } while(!CPU.cpsr().getZero()); // !=
              }

              //LAB_8078d8a
              CPU.cmpT(r4, 0x20);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.addT(r6, 0x0);
                r4 = CPU.movT(0, 0x0);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r3 = MEMORY.ref(4, 0x8078da0).get();
                  r3 = CPU.orrT(r3, r0);
                  r0 = CPU.r8().value;
                  MEMORY.ref(2, r0).setu(r3);
                } else {
                  //LAB_8078da8
                  do {
                    r4 = CPU.addT(r4, 0x1);
                    CPU.cmpT(r4, 0x1f);
                    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                      break;
                    }
                    r3 = CPU.lslT(r4, 2);
                    r1 = CPU.r8().value;
                    r2 = CPU.addT(r3, r1);
                    r3 = MEMORY.ref(2, r2).getUnsigned();
                    CPU.cmpT(r3, 0x0);
                  } while(!CPU.cpsr().getZero()); // !=

                  r3 = MEMORY.ref(4, 0x8078de4).get();
                  r3 = CPU.orrT(r3, r0);
                  MEMORY.ref(2, r2).setu(r3);
                }

                //LAB_8078dc0
                CPU.cmpT(r4, 0x20);
                if(CPU.cpsr().getZero()) { // ==
                  break;
                }
              }
            }
          }
        }

        //LAB_8078dc4
        r2 = CPU.movT(0, 0x2);
        r5 = CPU.addT(r5, 0x1);
        CPU.r10().value += r2;
        CPU.cmpT(r5, 0xe);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      //LAB_8078dce
      r4 = CPU.movT(0, 0x0);
      r5 = CPU.movT(0, 0x0);
      r1 = CPU.r8().value;

      //LAB_8078dd4
      do {
        r3 = CPU.lslT(r4, 2);
        r0 = CPU.r8().value;
        r2 = MEMORY.ref(2, r3 + r0).getUnsigned();
        r3 = CPU.addT(r2, 0x0);
        CPU.cmpT(r3, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r4 = CPU.addT(r4, 0x1);
        } else {
          //LAB_8078de8
          MEMORY.ref(2, r1).setu(r2);
          r4 = CPU.addT(r4, 0x1);
          r1 = CPU.addT(r1, 0x4);
          r5 = CPU.addT(r5, 0x1);
        }

        //LAB_8078df0
        CPU.cmpT(r4, 0x1f);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      CPU.cmpT(r5, 0x1f);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // >
        r3 = CPU.lslT(r5, 2);
        r0 = CPU.r8().value;
        r2 = CPU.addT(r3, r0);
        r1 = MEMORY.ref(4, 0x8078e10).get();
        r3 = CPU.movT(0, 0x20);
        r5 = CPU.subT(r3, r5);

        //LAB_8078e04
        do {
          r5 = CPU.subT(r5, 0x1);
          MEMORY.ref(2, r2).setu(r1);
          r2 = CPU.addT(r2, 0x4);
          CPU.cmpT(r5, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8078e14
      r0 = CPU.movT(0, 0x0);
    }

    //LAB_8078e16
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

  @Method(0x8078ed8)
  public static int FUN_8078ed8(int r0) {
    final int r3 = CPU.movT(0, 0xb4);
    r0 = CPU.mulT(r0, r3);
    final int r2 = MEMORY.ref(4, 0x8078ee4).get();
    r0 = CPU.addT(r0, r2);
    return r0;
  }

  @Method(0x8078ee8)
  public static void FUN_8078ee8() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    CPU.sp().value -= 0x20;
    r1 = MEMORY.ref(4, 0x8078f90).get();
    CPU.r10().value = CPU.sp().value;
    CPU.r8().value = r1;
    r6 = CPU.movT(0, 0x0);
    CPU.r9().value = CPU.r10().value;

    //LAB_8078efe
    do {
      r0 = CPU.addT(r6, 0x0);
      r0 = FUN_8077394(r0);
      r7 = CPU.addT(r0, 0x0);
      r0 = MEMORY.ref(4, 0x8078f94).get();
      r1 = CPU.r9().value;
      r0 = CPU.addT(r6, r0);
      FUN_8015020(r0, r1);
      r2 = CPU.r9().value;
      r3 = MEMORY.ref(2, r2).getUnsigned();
      MEMORY.ref(1, r7).setu(r3);
      r3 = MEMORY.ref(2, r2).getUnsigned();
      r5 = CPU.movT(0, 0x0);
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r1 = CPU.r10().value;
        r2 = CPU.addT(r7, 0x0);
        r0 = CPU.movT(0, 0x0);

        //LAB_8078f24
        do {
          r5 = CPU.addT(r5, 0x1);
          r0 = CPU.addT(r0, 0x2);
          CPU.cmpT(r5, 0xd);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break;
          }
          r3 = MEMORY.ref(2, r0 + r1).getUnsigned();
          r2 = CPU.addT(r2, 0x1);
          MEMORY.ref(1, r2).setu(r3);
          r3 = MEMORY.ref(2, r0 + r1).getUnsigned();
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_8078f38
      r3 = CPU.movT(0, 0x0);
      r6 = CPU.addT(r6, 0x1);
      MEMORY.ref(1, r7 + 0xe).setu(r3);
      CPU.cmpT(r6, 0x7);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r3 = CPU.r8().value;
    r1 = CPU.movT(0, 0x1);
    r0 = MEMORY.ref(4, r3).get();
    r1 = CPU.negT(r1, r1);
    r0 = CPU.cmpT(r0, r1);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_8078f4e
      do {
        r0 = FUN_8077394(r0);
        r7 = CPU.addT(r0, 0x0);
        CPU.cmpT(r7, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r3 = CPU.r8().value;
          r1 = CPU.movT(0, 0x94);
          r2 = MEMORY.ref(4, r3).get();
          r1 = CPU.lslT(r1, 1);
          r3 = CPU.addT(r7, r1);
          MEMORY.ref(1, r3).setu(r2);
          r0 = MEMORY.ref(1, r3).getUnsigned();
          r0 = FUN_8078ed8(r0);
          r3 = CPU.addT(r7, 0x0);
          r2 = MEMORY.ref(4, 0x8078f8c).get();
          CPU.r10().value = r0;
          r5 = CPU.movT(0, 0xe);
          r3 = CPU.addT(r3, 0xf4);

          //LAB_8078f74
          do {
            r5 = CPU.subT(r5, 0x1);
            MEMORY.ref(2, r3).setu(r2);
            r3 = CPU.subT(r3, 0x2);
            CPU.cmpT(r5, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          r2 = MEMORY.ref(4, 0x8078f98).get();
          r6 = CPU.r10().value;
          r5 = CPU.movT(0, 0x0);
          r6 = CPU.addT(r6, 0x98);
          CPU.r9().value = r2;

          //LAB_8078f9c
          do {
            r3 = CPU.r8().value;
            r0 = MEMORY.ref(4, r3).get();
            r3 = MEMORY.ref(2, r6).getUnsigned();
            r1 = CPU.r9().value;
            r1 = CPU.andT(r1, r3);
            r0 = FUN_8078588(r0, r1);
            r2 = CPU.r8().value;
            r1 = CPU.addT(r0, 0x0);
            r5 = CPU.addT(r5, 0x1);
            r0 = MEMORY.ref(4, r2).get();
            r6 = CPU.addT(r6, 0x2);
            r0 = FUN_8078708(r0, r1);
            CPU.cmpT(r5, 0xc);
          } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

          r3 = CPU.r8().value;
          r0 = MEMORY.ref(4, r3).get();
          FUN_8079ae8(r0);
          r3 = CPU.movT(0, 0x80);
          r3 = CPU.lslT(r3, 7);
          MEMORY.ref(2, r7 + 0x16).setu(r3);
          MEMORY.ref(2, r7 + 0x14).setu(r3);
          r3 = CPU.r10().value;
          r1 = CPU.r8().value;
          r3 = CPU.addT(r3, 0x96);
          r0 = MEMORY.ref(4, r1).get();
          r1 = MEMORY.ref(1, r3).getUnsigned();
          FUN_80792fc(r0, r1);
          r2 = CPU.r8().value;
          r0 = MEMORY.ref(4, r2).get();
          FUN_8077428(r0);
        }

        //LAB_8078fe2
        r3 = CPU.movT(0, 0x4);
        CPU.r8().value += r3;
        r1 = CPU.r8().value;
        r3 = MEMORY.ref(4, r1).get();
        r2 = CPU.movT(0, 0x1);
        r2 = CPU.negT(r2, r2);
        r0 = CPU.addT(r3, 0x0);
        r3 = CPU.cmpT(r3, r2);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8078ff4
    CPU.sp().value += 0x20;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x8079008)
  public static int FUN_8079008(int r0, int r1) {
    int r2;
    int r3;
    final int r5;

    r5 = CPU.addT(r1, 0x0);
    r0 = FUN_8077394(r0);
    r1 = MEMORY.ref(4, 0x8079054).get();
    r2 = CPU.addT(r0, 0x0);
    r3 = CPU.addT(r2, r1);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return -1;
    }

    CPU.cmpT(r5, 0x0);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      return 0;
    }

    CPU.cmpT(r5, 0x63);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      return -1;
    }

    r3 = CPU.movT(0, 0x94);
    r3 = CPU.lslT(r3, 1);
    r0 = CPU.addT(r2, r3);
    r3 = MEMORY.ref(1, r0).getUnsigned();
    CPU.cmpT(r3, 0x7);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      //LAB_8079048
      return -1;
    }

    r2 = CPU.addT(r3, 0x0);
    r3 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.lslT(r3, 5);
    r3 = CPU.addT(r3, r2);
    r3 = CPU.addT(r3, r5);
    r1 = MEMORY.ref(4, 0x8079058).get();
    r3 = CPU.lslT(r3, 2);
    r3 = CPU.subT(r3, 0x4);
    r0 = MEMORY.ref(4, r1 + r3).get();

    //LAB_807904c
    return r0;
  }

  @Method(0x807905c)
  public static int FUN_807905c(int r0, int r1) {
    int r2;
    int r3;
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

    r6 = CPU.addT(r1, 0x0);
    CPU.r11().value = r0;
    r0 = FUN_8077394(r0);
    CPU.r10().value = r0;
    r0 = CPU.movT(0, 0x2c);
    r0 = FUN_8004970(r0);
    r3 = MEMORY.ref(4, 0x80792bc).get();
    r3 += CPU.r10().value;
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r9().value = r0;
    MEMORY.ref(4, r0).setu(r3);
    r0 = CPU.r10().value;
    r1 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
    r2 = CPU.r9().value;
    r3 = MEMORY.ref(4, 0x80792c0).get();
    MEMORY.ref(4, r2 + 0x4).setu(r1);
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(2, r6).setu(r1);
    MEMORY.ref(2, r6 + 0x2).setu(r3);
    MEMORY.ref(2, r6 + 0x4).setu(r2);
    MEMORY.ref(2, r6 + 0x6).setu(r2);
    MEMORY.ref(2, r6 + 0x8).setu(r2);
    MEMORY.ref(2, r6 + 0xa).setu(r2);
    MEMORY.ref(2, r6 + 0xc).setu(r2);
    MEMORY.ref(2, r6 + 0xe).setu(r2);
    CPU.cmpT(r1, 0x62);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      //LAB_80790a6
      r3 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(1, r0 + 0xf).setu(r3);
      r3 = CPU.addT(r1, 0x1);
      MEMORY.ref(2, r6).setu(r3);
      r1 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
      r0 = CPU.r11().value;
      r0 = FUN_8079008(r0, r1);
      r3 = CPU.movT(0, 0x1);
      r3 = CPU.negT(r3, r3);
      r0 = CPU.cmpT(r0, r3);
      if(!CPU.cpsr().getZero()) { // !=
        r2 = CPU.movT(0, 0x92);
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r10().value;
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.cmpT(r3, r0);
        if(!CPU.cpsr().getCarry()) { // unsigned <
          MEMORY.ref(4, r2).setu(r0);
        }
      }

      //LAB_80790ce
      r0 = CPU.r11().value;
      r0 = FUN_8078ed8(r0);
      r2 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r6 + r2).get();
      r1 = CPU.addT(r0, 0x0);
      r0 = CPU.r9().value;
      MEMORY.ref(4, r0 + 0x8).setu(r1);
      r0 = MEMORY.ref(2, r6).getUnsigned();
      CPU.cmpT(r3, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x50);
        r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
        r2 = MEMORY.ref(2, r2).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x5c);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x4).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x68);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x6).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x74);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0x8).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
        r3 = CPU.addT(r3, r2);
        r2 = CPU.addT(r1, 0x0);
        r2 = CPU.addT(r2, 0x80);
        r2 = MEMORY.ref(2, r2).getUnsigned();
        MEMORY.ref(2, r6 + 0xa).setu(r3);
        r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xc).setu(r3);
        r3 = CPU.addT(r1, 0x0);
        r3 = CPU.addT(r3, 0x8c);
        r2 = MEMORY.ref(1, r3).getUnsigned();
        r3 = MEMORY.ref(2, r6 + 0xe).getUnsigned();
        r3 = CPU.addT(r3, r2);
        MEMORY.ref(2, r6 + 0xe).setu(r3);
      }

      //LAB_807912c
      r0 = CPU.lslT(r0, 16);
      r0 = CPU.asrT(r0, 16);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022ec(r0, r1);
      r0 = CPU.lslT(r0, 16);
      r5 = CPU.asrT(r0, 16);
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r5 = CPU.movT(0, 0x0);
      }

      //LAB_8079140
      CPU.cmpT(r5, 0x4);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r5 = CPU.movT(0, 0x4);
      }

      //LAB_8079146
      r0 = CPU.lslT(r5, 1);
      CPU.r8().value = r0;
      r3 = CPU.r9().value;
      r1 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x52);
      r2 = MEMORY.ref(2, r1 + r3).get();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r1 + r3).get();
      r7 = CPU.subT(r2, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x4).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x5e);
      r1 = MEMORY.ref(2, r2 + r3).get();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).get();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0x6).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x6a);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r0 = CPU.r9().value;
      r2 = MEMORY.ref(4, r0 + 0x8).get();
      MEMORY.ref(2, r6 + 0x8).setu(r3);
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x76);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(2, r6 + 0xa).setu(r3);
      r3 = CPU.r9().value;
      r2 = MEMORY.ref(4, r3 + 0x8).get();
      r3 = CPU.r8().value;
      r3 = CPU.addT(r3, 0x82);
      r1 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x2);
      r3 = MEMORY.ref(2, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r0 = CPU.addT(r0, r7);
      r1 = CPU.movT(0, 0x14);
      r0 = FUN_80022f4(r0, r1);
      r3 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r3, r0);
      r0 = CPU.r9().value;
      r2 = MEMORY.ref(4, r0 + 0x8).get();
      MEMORY.ref(2, r6 + 0xc).setu(r3);
      r3 = CPU.addT(r5, 0x0);
      r3 = CPU.addT(r3, 0x8d);
      r1 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r3 = CPU.subT(r3, 0x1);
      r3 = MEMORY.ref(1, r2 + r3).getUnsigned();
      r7 = CPU.subT(r1, r3);
      r0 = FUN_8004458();
      r3 = CPU.addT(r0, 0x0);
      r0 = CPU.lslT(r3, 2);
      r0 = CPU.addT(r0, r3);
      r0 = CPU.lslT(r0, 2);
      r0 = CPU.lsrT(r0, 16);
      r1 = CPU.movT(0, 0x14);
      r0 = CPU.addT(r0, r7);
      r0 = FUN_80022f4(r0, r1);
      r2 = CPU.r10().value;
      r3 = MEMORY.ref(2, r2 + 0x10).getUnsigned();
      r1 = MEMORY.ref(2, r6 + 0xe).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
      r1 = CPU.addT(r1, r0);
      r3 = CPU.addT(r3, r2);
      r0 = CPU.r10().value;
      MEMORY.ref(2, r0 + 0x10).setu(r3);
      r2 = MEMORY.ref(2, r6 + 0x6).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0x12).getUnsigned();
      r3 = CPU.addT(r3, r2);
      r2 = CPU.r10().value;
      MEMORY.ref(2, r2 + 0x12).setu(r3);
      r3 = MEMORY.ref(2, r2 + 0x18).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0x8).getUnsigned();
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r0 + 0x18).setu(r3);
      r2 = MEMORY.ref(2, r6 + 0xa).getUnsigned();
      r3 = MEMORY.ref(2, r0 + 0x1a).getUnsigned();
      r3 = CPU.addT(r3, r2);
      r2 = CPU.r10().value;
      MEMORY.ref(2, r2 + 0x1a).setu(r3);
      r3 = MEMORY.ref(2, r2 + 0x1c).getUnsigned();
      r2 = MEMORY.ref(2, r6 + 0xc).getUnsigned();
      r3 = CPU.addT(r3, r2);
      MEMORY.ref(2, r0 + 0x1c).setu(r3);
      r3 = MEMORY.ref(1, r0 + 0x1e).getUnsigned();
      r3 = CPU.addT(r3, r1);
      MEMORY.ref(1, r0 + 0x1e).setu(r3);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r0 + 0x1f).setu(r3);
      r3 = CPU.r10().value;
      r2 = CPU.movT(0, 0x0);
      r3 = CPU.addT(r3, 0x20);
      MEMORY.ref(1, r3).setu(r2);
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(2, r6 + 0xe).setu(r1);
      MEMORY.ref(1, r3).setu(r2);
      r0 = CPU.r11().value;
      FUN_8078bf0(r0);
      r0 = CPU.r11().value;
      FUN_8077428(r0);
    }

    //LAB_80792a4
    r0 = CPU.r9().value;
    FUN_8002df0(r0);
    r0 = CPU.addT(r6, 0x0);
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

  @Method(0x80792fc)
  public static void FUN_80792fc(int r0, int r1) {
    final int r3;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    CPU.sp().value -= 0x10;
    r6 = CPU.addT(r0, 0x0);
    CPU.r8().value = r1;
    r0 = FUN_8077394(r0);
    r5 = MEMORY.ref(1, r0 + 0xf).getUnsigned();
    CPU.cmpT(r5, CPU.r8().value);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r3 = CPU.r8().value;
      r7 = CPU.sp().value;
      r5 = CPU.subT(r3, r5);

      //LAB_8079318
      do {
        r0 = CPU.addT(r6, 0x0);
        r1 = CPU.addT(r7, 0x0);
        r5 = CPU.subT(r5, 0x1);
        FUN_807905c(r0, r1);
        CPU.cmpT(r5, 0x0);
      } while(!CPU.cpsr().getZero()); // !=
    }

    //LAB_8079326
    r0 = CPU.addT(r6, 0x0);
    FUN_8077428(r0);
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
  }

  @Method(0x8079338)
  public static int FUN_8079338(int r0) {
    int r2;
    int r3;
    r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.lslT(r2, r3);
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(4, 0x8079354).get();
    r3 = MEMORY.ref(1, r3 + r0).getUnsigned();
    r3 = CPU.andT(r3, r2);
    r0 = CPU.negT(r0, r3);
    r0 = CPU.orrT(r0, r3);
    r0 = CPU.lsrT(r0, 31);
    return r0;
  }

  @Method(0x8079358)
  public static void FUN_8079358(int r0) {
    int r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    int r2 = CPU.movT(0, 0x1);
    final int r1 = MEMORY.ref(4, 0x8079370).get();
    r2 = CPU.lslT(r2, r3);
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(1, r1 + r0).getUnsigned();
    r2 = CPU.orrT(r2, r3);
    MEMORY.ref(1, r1 + r0).setu(r2);
  }

  @Method(0x8079374)
  public static void FUN_8079374(int r0) {
    final int r1;
    int r2;
    int r3;
    r3 = CPU.movT(0, 0x7);
    r3 = CPU.andT(r3, r0);
    r2 = CPU.movT(0, 0x1);
    r2 = CPU.lslT(r2, r3);
    r1 = MEMORY.ref(4, 0x807938c).get();
    r3 = CPU.lslT(r0, 20);
    r0 = CPU.lsrT(r3, 23);
    r3 = MEMORY.ref(1, r1 + r0).getUnsigned();
    r3 = CPU.bicT(r3, r2);
    MEMORY.ref(1, r1 + r0).setu(r3);
  }

  @Method(0x80795fc)
  public static int FUN_80795fc() {
    int r0;
    int r5;
    int r6;

    r6 = CPU.movT(0, 0x0);
    r5 = CPU.movT(0, 0x0);

    //LAB_8079602
    do {
      r0 = CPU.addT(r5, 0x0);
      r0 = FUN_8079338(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r6 = CPU.addT(r6, 0x1);
      }

      //LAB_807960e
      r5 = CPU.addT(r5, 0x1);
      CPU.cmpT(r5, 0x7);
    } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

    r0 = CPU.addT(r6, 0x0);
    return r0;
  }

  @Method(0x807961c)
  public static int FUN_807961c(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r6 = CPU.addT(r0, 0x0);
    r0 = FUN_80795fc();
    r5 = CPU.addT(r0, 0x0);
    r0 = CPU.addT(r6, 0x0);
    FUN_8079358(r0);
    r2 = CPU.movT(0, 0x0);
    r2 = CPU.cmpT(r2, r5);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r0 = MEMORY.ref(4, 0x8079660).get();
      r3 = CPU.movT(0, 0xfc);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.addT(r0, r3);

      //LAB_807963a
      do {
        r3 = MEMORY.ref(1, r1).getUnsigned();
        r1 = CPU.addT(r1, 0x1);
        r3 = CPU.cmpT(r3, r6);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_807964a
          return r5;
        }
        r2 = CPU.addT(r2, 0x1);
        r2 = CPU.cmpT(r2, r5);
      } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
    } else {
      //LAB_807964e
      r0 = MEMORY.ref(4, 0x8079660).get();
    }

    //LAB_8079650
    r1 = CPU.movT(0, 0xfc);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r2, r1);
    MEMORY.ref(1, r0 + r3).setu(r6);
    r0 = CPU.addT(r5, 0x1);

    //LAB_807965a
    return r0;
  }

  @Method(0x80797ec)
  public static int FUN_80797ec(int r0, final int r1) {
    r0 = CPU.lslT(r0, 2);
    final int r3 = MEMORY.ref(4, 0x80797f8).get();
    r0 = CPU.addT(r0, r1);
    r0 = CPU.lslT(r0, 2);
    r0 = MEMORY.ref(4, r3 + r0).get();
    return r0;
  }

  @Method(0x80797fc)
  public static int FUN_80797fc(int r0, int r1, int r2) {
    int r3;
    int r5;
    int r6;
    final int r7;

    r7 = CPU.addT(r0, 0x0);
    r6 = CPU.addT(r2, 0x0);
    CPU.cmpT(r7, 0x7);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = FUN_80773d8(r0);
      r0 = CPU.addT(r0, 0x34);
      r1 = MEMORY.ref(1, r0).getUnsigned();
      CPU.cmpT(r1, 0x2b);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r1 = CPU.movT(0, 0x0);
      }

      //LAB_8079814
      r3 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r3, r1);
      r2 = MEMORY.ref(4, 0x8079878).get();
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(r3, r2);
      r5 = CPU.movT(0, 0x0);
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.addT(r3, 0x4);

      //LAB_8079824
      do {
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r3, r2);
        r3 = CPU.lslT(r3, 1);
        r5 = CPU.addT(r5, 0x1);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
        CPU.cmpT(r5, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    } else {
      //LAB_8079838
      r0 = CPU.addT(r6, 0x0);
      r1 = CPU.addT(r1, 0x24);
      r5 = CPU.movT(0, 0x3);

      //LAB_807983e
      do {
        r2 = MEMORY.ref(1, r1).getUnsigned();
        r3 = CPU.lslT(r2, 2);
        r3 = CPU.addT(r3, r2);
        r3 = CPU.lslT(r3, 1);
        r5 = CPU.subT(r5, 0x1);
        r1 = CPU.addT(r1, 0x1);
        MEMORY.ref(4, r0).setu(r3);
        r0 += 0x4;
        CPU.cmpT(r5, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

      CPU.cmpT(r7, 0x7);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r5 = CPU.movT(0, 0x0);

        //LAB_8079856
        do {
          r0 = CPU.addT(r7, 0x0);
          r0 = FUN_8078ed8(r0);
          r3 = CPU.addT(r5, 0x0);
          r3 = CPU.addT(r3, 0x90);
          r0 = CPU.addT(r0, 0x2);
          r2 = MEMORY.ref(1, r0 + r3).getUnsigned();
          r3 = MEMORY.ref(4, r6).get();
          r5 = CPU.addT(r5, 0x1);
          r3 = CPU.addT(r3, r2);
          MEMORY.ref(4, r6).setu(r3);
          r6 += 0x4;
          CPU.cmpT(r5, 0x3);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
      }
    }

    //LAB_8079870
    r0 = CPU.movT(0, 0x0);
    return r0;
  }

  @Method(0x80798e0)
  public static void FUN_80798e0(int r0, int r1) {
    int r2;
    int r4;
    int r3;
    int r6;
    int r5;
    int r7;

    r7 = CPU.r10().value;
    r6 = CPU.r9().value;
    r5 = CPU.r8().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    CPU.sp().value -= 0x14;
    CPU.r9().value = r1;
    r0 = FUN_8077394(r0);
    r2 = CPU.addT(r0, 0x0);
    r0 = MEMORY.ref(4, 0x80799a4).get();
    r3 = CPU.addT(r2, r0);
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r1 = CPU.movT(0, 0x94);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r2, r1);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r0 = FUN_80773d8(r0);
      r0 = CPU.addT(r0, 0x34);
      r0 = MEMORY.ref(1, r0).getUnsigned();
      CPU.cmpT(r0, 0x2b);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = CPU.movT(0, 0x0);
      }

      //LAB_8079914
      r3 = CPU.lslT(r0, 1);
      r2 = MEMORY.ref(4, 0x80799a8).get();
      r3 = CPU.addT(r3, r0);
      r3 = CPU.lslT(r3, 3);
      r3 = CPU.addT(r3, r2);
      r2 = CPU.addT(r3, 0x0);
      r7 = CPU.movT(0, 0x0);
      r1 = CPU.r9().value;
      r2 = CPU.addT(r2, 0x8);

      //LAB_8079926
      do {
        r3 = MEMORY.ref(4, r2).get();
        r2 += 0x4;
        r7 = CPU.addT(r7, 0x1);
        MEMORY.ref(4, r1).setu(r3);
        r1 += 0x4;
        CPU.cmpT(r7, 0x3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=
    } else {
      //LAB_8079932
      r0 = CPU.movT(0, 0x94);
      r0 = CPU.lslT(r0, 1);
      r3 = CPU.addT(r2, r0);
      r0 = MEMORY.ref(1, r3).getUnsigned();
      r3 = CPU.sp().value + 0x4;
      r1 = CPU.addT(r2, 0x0);
      CPU.r8().value = r3;
      r1 = CPU.addT(r1, 0xf8);
      r2 = CPU.r8().value;
      FUN_80797fc(r0, r1, r2);
      r0 = MEMORY.ref(4, 0x80799ac).get();
      r4 = CPU.movT(0, 0x0);
      CPU.r10().value = r0;
      r7 = CPU.movT(0, 0x3);

      //LAB_8079950
      do {
        r1 = CPU.r8().value;
        r5 = MEMORY.ref(4, r4 + r1).get();
        r1 = CPU.movT(0, 0xa);
        r0 = CPU.addT(r5, 0x0);
        MEMORY.ref(4, CPU.sp().value).setu(r4);
        r0 = FUN_80022fc(r0, r1);
        r1 = CPU.movT(0, 0xa);
        r6 = CPU.addT(r0, 0x0);
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80022ec(r0, r1);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        CPU.cmpT(r0, 0xf);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          r0 = CPU.movT(0, 0xf);
        }

        //LAB_8079970
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
          r0 = CPU.movT(0, 0x0);
        }

        //LAB_8079976
        r2 = CPU.lslT(r0, 2);
        r3 = CPU.r9().value;
        r0 = CPU.r10().value;
        r1 = CPU.addT(r4, r3);
        r3 = MEMORY.ref(2, r0 + r2).getUnsigned();
        r3 = CPU.addT(r3, r6);
        MEMORY.ref(2, r1).setu(r3);
        r2 += CPU.r10().value;
        r3 = MEMORY.ref(2, r2 + 0x2).getUnsigned();
        r7 = CPU.subT(r7, 0x1);
        r3 = CPU.addT(r3, r6);
        MEMORY.ref(2, r1 + 0x2).setu(r3);
        r4 = CPU.addT(r4, 0x4);
        CPU.cmpT(r7, 0x0);
      } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
    }

    //LAB_8079994
    CPU.sp().value += 0x14;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
  }

  @Method(0x80799b0)
  public static int FUN_80799b0(int r0, int r1) {
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

    r2 = CPU.movT(0, 0x1);
    r5 = CPU.addT(r0, 0x0);
    r2 = CPU.negT(r2, r2);
    CPU.sp().value -= 0x14;
    CPU.r8().value = r2;
    r0 = CPU.movT(0, 0x0);
    CPU.cmpT(r5, 0x7);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r6 = CPU.sp().value + 0x4;
      r0 = CPU.addT(r5, 0x0);
      r2 = CPU.addT(r6, 0x0);
      FUN_80797fc(r0, r1, r2);
      r0 = CPU.movT(0, 0x20);
      r0 = FUN_8079338(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        if(r5 == 0) {
          CPU.sp().value += 0x14;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return 0xc8;
        }

        if(r5 == 1) {
          CPU.sp().value += 0x14;
          CPU.r8().value = CPU.pop();
          CPU.r9().value = CPU.pop();
          CPU.r10().value = CPU.pop();
          CPU.r11().value = CPU.pop();
          return 0xc9;
        }
      }

      //LAB_80799ee
      r0 = 0xca;
      if(r5 != 5) {
        r0 = CPU.movT(0, 0x1);
        r0 = CPU.negT(r0, r0);
        CPU.cmpT(CPU.r8().value, r0);
        if(CPU.cpsr().getZero()) { // ==
          CPU.r12().value = CPU.r8().value;
          r5 = CPU.r8().value;
          r0 = CPU.movT(0, 0x0);
          r2 = CPU.addT(r6, 0x0);

          //LAB_8079a04
          do {
            r3 = MEMORY.ref(4, r2).get();
            r2 += 0x4;

            CPU.cmpT(CPU.r12().value, r3);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              CPU.r12().value = r3;
              r5 = CPU.addT(r0, 0x0);
            }

            //LAB_8079a0e
            r0 = CPU.addT(r0, 0x1);
            CPU.cmpT(r0, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

          r4 = CPU.movT(0, 0x1);
          r4 = CPU.negT(r4, r4);
          CPU.r12().value = r4;
          r0 = CPU.movT(0, 0x0);
          r2 = CPU.addT(r6, 0x0);

          //LAB_8079a1e
          do {
            r0 = CPU.cmpT(r0, r5);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, r2).get();
              CPU.cmpT(CPU.r12().value, r3);
              if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                CPU.r12().value = r3;
                r4 = CPU.addT(r0, 0x0);
              }
            }

            //LAB_8079a2c
            r0 = CPU.addT(r0, 0x1);
            r2 = CPU.addT(r2, 0x4);
            CPU.cmpT(r0, 0x3);
          } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

          r3 = CPU.lslT(r4, 2);
          r3 = MEMORY.ref(4, r6 + r3).get();
          r1 = CPU.addT(r5, 0x0);
          CPU.cmpT(r3, 0x9);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = CPU.addT(r4, 0x0);
          }

          r0 = CPU.addT(r5, 0x0);
          r0 = FUN_80797ec(r0, r1);
          r3 = MEMORY.ref(4, 0x8079acc).get();
          r7 = MEMORY.ref(4, 0x8079ad0).get();
          CPU.r10().value = r3;
          CPU.lr().value = CPU.r10().value;
          MEMORY.ref(4, CPU.sp().value).setu(r6);
          r5 = MEMORY.ref(4, 0x8079ad4).get();
          CPU.r11().value = r0;
          CPU.r9().value = r6;
          r0 = CPU.movT(0, 0xca);
          r7 += CPU.lr().value;

          //LAB_8079a60
          do {
            r6 = CPU.r10().value;
            r3 = MEMORY.ref(4, r5 + r6).get();
            CPU.cmpT(r3, CPU.r11().value);
            if(CPU.cpsr().getZero()) { // ==
              r3 = MEMORY.ref(1, r7).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              r2 = CPU.lslT(r3, 2);
              r2 = CPU.addT(r2, r3);
              r3 = MEMORY.ref(4, r1).get();
              r2 = CPU.lslT(r2, 1);
              r4 = CPU.movT(0, 0x0);
              r3 = CPU.cmpT(r3, r2);
              if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                r2 = CPU.lr().value;
                r3 = CPU.addT(r5, r2);
                CPU.r12().value = CPU.r9().value;
                r1 = CPU.addT(r3, 0x4);

                //LAB_8079a82
                do {
                  r4 = CPU.addT(r4, 0x1);
                  CPU.cmpT(r4, 0x3);
                  if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                    break;
                  }
                  r1 = CPU.addT(r1, 0x1);
                  r3 = MEMORY.ref(1, r1).getUnsigned();
                  r2 = CPU.lslT(r3, 2);
                  r2 = CPU.addT(r2, r3);
                  r3 = CPU.movT(0, 0x4);
                  CPU.r12().value += r3;
                  r6 = CPU.r12().value;
                  r3 = MEMORY.ref(4, r6).get();
                  r2 = CPU.lslT(r2, 1);
                  r3 = CPU.cmpT(r3, r2);
                } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
              }

              //LAB_8079a9e
              CPU.cmpT(r4, 0x4);
              if(CPU.cpsr().getZero()) { // ==
                //LAB_8079a42
                CPU.r8().value = r0;
                break;
              }
            }

            //LAB_8079aa2
            r0 = CPU.subT(r0, 0x1);
            r7 = CPU.subT(r7, 0x54);
            r5 = CPU.subT(r5, 0x54);
            CPU.cmpT(r0, 0x0);
          } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

          //LAB_8079aac
          r1 = CPU.movT(0, 0x1);
          r1 = CPU.negT(r1, r1);
          CPU.cmpT(CPU.r8().value, r1);
          if(CPU.cpsr().getZero()) { // ==
            r2 = CPU.movT(0, 0x0);
            CPU.r8().value = r2;
          }

          //LAB_8079ab8
          r0 = CPU.r8().value;
        }
      }
    }

    //LAB_8079aba
    CPU.sp().value += 0x14;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
    return r0;
  }

  @Method(0x8079ae8)
  public static void FUN_8079ae8(int r0) {
    int r1;
    int r2;
    int r3;
    final int r5;
    final int r6;

    r5 = CPU.addT(r0, 0x0);
    r0 = FUN_8077394(r0);
    r2 = CPU.movT(0, 0x94);
    r6 = CPU.addT(r0, 0x0);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r6, r2);
    r1 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0xf8);
    r0 = MEMORY.ref(1, r3).getUnsigned();
    r0 = FUN_80799b0(r0, r1);
    r2 = MEMORY.ref(4, 0x8079b20).get();
    r3 = CPU.addT(r6, r2);
    MEMORY.ref(1, r3).setu(r0);
    r0 = CPU.addT(r5, 0x0);
    FUN_8078bf0(r0);
    r1 = CPU.addT(r6, 0x0);
    r1 = CPU.addT(r1, 0x24);
    r0 = CPU.addT(r5, 0x0);
    FUN_80798e0(r0, r1);
  }

  @Method(0x8079ad8)
  public static int FUN_8079ad8(int r0) {
    int r3;
    r3 = CPU.movT(0, 0x54);
    r0 = CPU.mulT(r0, r3);
    r3 = MEMORY.ref(4, 0x8079ae4).get();
    r0 = CPU.addT(r0, r3);
    return r0;
  }

  @Method(0x807a0cc)
  public static int FUN_807a0cc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808a008)
  public static void FUN_808a008(final int r0) {
    MEMORY.call(0x808a8e5, r0);
  }

  @Method(0x808a5f8)
  public static void FUN_808a5f8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808a6e4)
  public static void FUN_808a6e4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808a8e4)
  public static void FUN_808a8e4(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.lr().value);
    CPU.push(0);
    CPU.push(0);
    CPU.push(0);

    r7 = CPU.r11().value;
    r6 = CPU.r10().value;
    r5 = CPU.r9().value;
    CPU.push(r7);
    CPU.push(r6);
    CPU.push(r5);

    r7 = CPU.r8().value;
    CPU.push(r7);

    r3 = MEMORY.ref(4, 0x808a980).get();
    r1 = MEMORY.ref(4, 0x808a984).get();
    r3 = MEMORY.ref(1, r3).getUnsigned();
    CPU.r11().value = r1;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_8077098();
      r1 = MEMORY.ref(4, 0x808a988).get();
      r4 = CPU.movT(0, 0xe0);
      r3 = MEMORY.ref(4, 0x808a994).get();
      r4 = CPU.lslT(r4, 1);
      r0 = CPU.movT(0, 0xe1);
      r2 = CPU.addT(r1, r4);
      r0 = CPU.lslT(r0, 1);
      MEMORY.ref(2, r2).setu(r3);
      r2 = CPU.addT(r1, r0);
      r3 = CPU.movT(0, 0x2);
      MEMORY.ref(2, r2).setu(r3);
    } else {
      CPU.cmpT(r0, 0x1);
      if(CPU.cpsr().getZero()) { // ==
        r1 = MEMORY.ref(4, 0x808a988).get();
        r4 = CPU.movT(0, 0xe0);
        r2 = MEMORY.ref(4, 0x808a98c).get();
        r4 = CPU.lslT(r4, 1);
        r3 = CPU.addT(r1, r4);
        MEMORY.ref(2, r3).setu(r2);
        r2 = CPU.movT(0, 0xe1);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.addT(r1, r2);
        MEMORY.ref(2, r3).setu(r0);
      } else {
        //LAB_808a918
        CPU.cmpT(r0, 0x2);
        if(CPU.cpsr().getZero()) { // ==
          r1 = MEMORY.ref(4, 0x808a988).get();
          r4 = CPU.movT(0, 0xe0);
          r3 = MEMORY.ref(4, 0x808a990).get();
          r4 = CPU.lslT(r4, 1);
          r0 = CPU.movT(0, 0xe1);
          r2 = CPU.addT(r1, r4);
          r0 = CPU.lslT(r0, 1);
          MEMORY.ref(2, r2).setu(r3);
          r2 = CPU.addT(r1, r0);
          r3 = CPU.movT(0, 0x1);
        } else {
          //LAB_808a932
          FUN_8077098();
          r1 = MEMORY.ref(4, 0x808a988).get();
          r4 = CPU.movT(0, 0xe0);
          r3 = MEMORY.ref(4, 0x808a994).get();
          r4 = CPU.lslT(r4, 1);
          r0 = CPU.movT(0, 0xe1);
          r2 = CPU.addT(r1, r4);
          r0 = CPU.lslT(r0, 1);
          MEMORY.ref(2, r2).setu(r3);
          r2 = CPU.addT(r1, r0);
          r3 = CPU.movT(0, 0x2);
        }

        //LAB_808a94a
        MEMORY.ref(2, r2).setu(r3);
      }
    }

    //LAB_808a94c
    r3 = MEMORY.ref(4, 0x808a988).get();
    r1 = MEMORY.ref(4, 0x808a998).get();
    r2 = CPU.addT(r3, r1);
    r0 = MEMORY.ref(1, r2).getUnsigned();
    r2 = MEMORY.ref(4, 0x808a99c).get();
    r3 = CPU.addT(r3, r2);
    r1 = MEMORY.ref(1, r3).getUnsigned();
    FUN_8015360(r0, r1);
    FUN_800403c();
    FUN_80040e8();
    FUN_80040e8();
    r3 = MEMORY.ref(4, 0x808a9a0).get();
    CPU.r9().value = r3;

    //LAB_808a96e
    do {
      r0 = MEMORY.ref(4, 0x808a9a4).get();
      r0 = FUN_80770c0(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r0 = MEMORY.ref(4, 0x808a9a4).get();
        FUN_80770d0(r0);
      } else {
        //LAB_808a9a8
        r0 = CPU.movT(0, 0x90);
        r0 = CPU.lslT(r0, 1);
        FUN_80f9010(r0);
      }

      //LAB_808a9b0
      r7 = MEMORY.ref(4, 0x808aa10).get();
      r4 = CPU.movT(0, 0xe0);
      r4 = CPU.lslT(r4, 1);
      r4 = CPU.addT(r4, r7);
      r0 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r4 + r0).get();
      r1 = CPU.movT(0, 0xe1);
      r3 = CPU.lslT(r3, 3);
      r3 += CPU.r11().value;
      r1 = CPU.lslT(r1, 1);
      CPU.r10().value = r3;
      r3 = CPU.addT(r7, r1);
      r1 = MEMORY.ref(4, 0x808aa14).get();
      r2 = CPU.movT(0, 0x0);
      r6 = MEMORY.ref(2, r3 + r2).get();
      r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
      r2 = MEMORY.ref(4, 0x808aa08).get();
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(2, r1 + 0xa).setu(r3);
      r2 = MEMORY.ref(4, 0x808aa0c).get();
      r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
      r3 = CPU.andT(r3, r2);
      MEMORY.ref(2, r1 + 0xa).setu(r3);
      CPU.r8().value = r4;
      r3 = MEMORY.ref(2, r1 + 0xa).getUnsigned();
      FUN_80040e8();
      r0 = CPU.movT(0, 0x1);
      r1 = CPU.movT(0, 0x0);
      setInterruptHandler(r0, r1, null);
      r0 = CPU.movT(0, 0x2);
      r1 = CPU.movT(0, 0x0);
      setInterruptHandler(r0, r1, null);
      initMemoryAllocator();
      FUN_8004760();
      FUN_800403c();
      r0 = CPU.r8().value;
      r1 = CPU.movT(0, 0xfd);
      r4 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r0 + r4).get();
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.cmpT(r3, r1);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r2 = CPU.movT(0, 0xfe);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.cmpT(r3, r2);
        if(CPU.cpsr().getZero()) { // ==
          //LAB_808aa6e
          r5 = FUN_8004938(0x40);
          DMA.channels[3].SAD.setu(CPU.r9().value);
          DMA.channels[3].DAD.setu(r5);
          DMA.channels[3].CNT.setu(0x84000010);
          r6 = FUN_80f6000(r6);
          DMA.channels[3].SAD.setu(r5);
          DMA.channels[3].DAD.setu(CPU.r9().value);
          DMA.channels[3].CNT.setu(0x84000010);
          FUN_8002df0(r5);
        } else {
          r3 = CPU.cmpT(r3, r2);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            //LAB_808aa3a
            r4 = MEMORY.ref(4, 0x808ab2c).get();
            r3 = CPU.cmpT(r3, r4);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = CPU.movT(0, 0xff);
              r0 = CPU.lslT(r0, 1);
              r3 = CPU.cmpT(r3, r0);
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.addT(r6, 0x0);
                r0 = FUN_80b50a0(r0);
                r6 = CPU.addT(r0, 0x0);
              }
            } else {
              //LAB_808aa52
              r5 = FUN_8004938(0x40);
              DMA.channels[3].SAD.setu(CPU.r9().value);
              DMA.channels[3].DAD.setu(r5);
              DMA.channels[3].CNT.setu(0x84000010);
              r6 = FUN_80f4000(r6);
              DMA.channels[3].SAD.setu(r5);
              DMA.channels[3].DAD.setu(CPU.r9().value);
              DMA.channels[3].CNT.setu(0x84000010);
              FUN_8002df0(r5);
            }
          } else {
            r2 = CPU.subT(r2, 0x1);
            r3 = CPU.cmpT(r3, r2);
            if(CPU.cpsr().getZero()) { // ==
              //LAB_808aa9e
              r6 = CPU.movT(0, 0x0);
            }
          }
        }

        //LAB_808aaa0
        r0 = CPU.addT(r6, 0x0);
        FUN_808a6e4(r0);
      } else {
        //LAB_808aaa8
        r5 = MEMORY.ref(4, 0x808ab38).get();
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80770c0(r0);
        r3 = CPU.r8().value;
        r1 = CPU.addT(r0, 0x0);
        r2 = CPU.movT(0, 0x0);
        r0 = MEMORY.ref(2, r3 + r2).get();
        FUN_808ab74(r0, r1);
        FUN_808b090();
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.movT(0, 0x8d);
          r0 = CPU.lslT(r0, 1);
          r0 = FUN_80770c0(r0);
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.movT(0, 0x8d);
            r0 = CPU.lslT(r0, 1);
            FUN_80770d0(r0);
          } else {
            r0 = MEMORY.ref(4, 0x808ab3c).get();
            r0 = FUN_80770c0(r0);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              FUN_808acc4();
            } else {
              //LAB_808aae6
              r0 = CPU.movT(0, 0x8d);
              r0 = CPU.lslT(r0, 1);
              FUN_80770d0(r0);
            }
          }
        } else {
          //LAB_808aaf0
          r4 = MEMORY.ref(4, 0x808ab40).get();
          r3 = CPU.addT(r7, r4);
          r2 = CPU.movT(0, 0x1);
          r1 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(2, r3 + r1).get();
          r2 = CPU.negT(r2, r2);
          r0 = CPU.cmpT(r0, r2);
          if(!CPU.cpsr().getZero()) { // !=
            FUN_80f9010(r0);
          } else {
            //LAB_808ab06
            FUN_808acc4();
          }
        }

        //LAB_808ab0a
        r4 = CPU.r10().value;
        r3 = MEMORY.ref(4, 0x808ab44).get();
        r0 = CPU.movT(0, 0xed);
        r2 = MEMORY.ref(2, r4 + 0x4).getUnsigned();
        r0 = CPU.lslT(r0, 1);
        r3 = CPU.addT(r3, r0);
        MEMORY.ref(2, r3).setu(r2);
        FUN_808ab48();
        r0 = CPU.addT(r6, 0x0);
        r0 = FUN_808c4f8(r0);
        FUN_808a5f8(r0);
      }
    } while(true);
  }

  @Method(0x808ab48)
  public static void FUN_808ab48() {
    FUN_8002fb0(MEMORY.ref(2, 0x809f1a8 + MEMORY.ref(2, 0x2000400).get() * 0x8).get(), 0x2008000);
  }

  @Method(0x808ab74)
  public static void FUN_808ab74(int r0, int r1) {
    int r2;
    int r3;
    int r5;
    int r6;

    r5 = MEMORY.ref(4, 0x808ac98).get();
    r2 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r5, r2);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    r2 = MEMORY.ref(4, 0x808ac9c).get();
    r3 = CPU.lslT(r3, 3);
    r3 = CPU.addT(r3, r2);
    r6 = CPU.movT(0, 0x2);
    r6 = MEMORY.ref(1, r3 + r6).get();
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r5 = CPU.movT(0, 0x80);
      r5 = CPU.lslT(r5, 2);

      //LAB_808ab94
      do {
        r0 = CPU.addT(r5, 0x0);
        FUN_80770d0(r0);
        r3 = MEMORY.ref(4, 0x808aca0).get();
        r5 = CPU.addT(r5, 0x1);
        r5 = CPU.cmpT(r5, r3);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      r3 = MEMORY.ref(4, 0x808ac98).get();
      r1 = CPU.movT(0, 0xe6);
      r1 = CPU.lslT(r1, 1);
      r3 = CPU.addT(r3, r1);
      r2 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r3 + r2).get();
      r6 = CPU.cmpT(r6, r3);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = CPU.movT(0, 0xc0);
        r5 = CPU.lslT(r5, 2);

        //LAB_808abb6
        do {
          r0 = CPU.addT(r5, 0x0);
          FUN_80770d0(r0);
          r3 = MEMORY.ref(4, 0x808aca4).get();
          r5 = CPU.addT(r5, 0x1);
          r5 = CPU.cmpT(r5, r3);
        } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

        r0 = MEMORY.ref(4, 0x808aca8).get();
        FUN_80770c8(r0);
        r5 = MEMORY.ref(4, 0x808ac98).get();
        r1 = CPU.movT(0, 0x8e);
        r1 = CPU.lslT(r1, 2);
        r2 = CPU.movT(0, 0x0);
        r3 = CPU.addT(r5, r1);
        r1 = CPU.subT(r1, 0x6);
        MEMORY.ref(4, r3).setu(r2);
        r0 = CPU.movT(0, 0x88);
        r3 = CPU.addT(r5, r1);
        MEMORY.ref(2, r3).setu(r2);
        r0 = CPU.lslT(r0, 1);
        FUN_80770d0(r0);
        r0 = MEMORY.ref(4, 0x808acac).get();
        FUN_80770d0(r0);
        r0 = CPU.movT(0, 0x89);
        r0 = CPU.lslT(r0, 1);
        FUN_80770d0(r0);
        r0 = MEMORY.ref(4, 0x808acb0).get();
        FUN_80770d0(r0);
        r2 = CPU.movT(0, 0xe0);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.addT(r5, r2);
        r1 = CPU.movT(0, 0x90);
        r2 = MEMORY.ref(2, r3).getUnsigned();
        r1 = CPU.lslT(r1, 2);
        r3 = CPU.addT(r5, r1);
        MEMORY.ref(2, r3).setu(r2);
        r2 = CPU.movT(0, 0xe1);
        r2 = CPU.lslT(r2, 1);
        r3 = CPU.addT(r5, r2);
        r2 = MEMORY.ref(2, r3).getUnsigned();
        r1 = CPU.addT(r1, 0x2);
        r3 = CPU.addT(r5, r1);
        MEMORY.ref(2, r3).setu(r2);
      }

      //LAB_808ac16
      r5 = CPU.movT(0, 0x80);

      //LAB_808ac18
      do {
        r0 = CPU.addT(r5, 0x0);
        r5 = CPU.addT(r5, 0x1);
        FUN_80770d0(r0);
        CPU.cmpT(r5, 0xdf);
      } while(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <=

      r0 = CPU.movT(0, 0xb6);
      r0 = CPU.lslT(r0, 1);
      FUN_80770d0(r0);
      r0 = CPU.movT(0, 0xa2);
      r0 = CPU.lslT(r0, 1);
      FUN_80770d0(r0);
      r0 = MEMORY.ref(4, 0x808acb4).get();
      FUN_80770d0(r0);
      r0 = MEMORY.ref(4, 0x808acb8).get();
      FUN_80770d0(r0);
      r0 = CPU.movT(0, 0x8e);
      r0 = CPU.lslT(r0, 1);
      FUN_80770d0(r0);
      r1 = MEMORY.ref(4, 0x808ac98).get();
      r3 = MEMORY.ref(4, 0x808acbc).get();
      r2 = CPU.addT(r1, r3);
      r3 = MEMORY.ref(4, 0x808acc0).get();
      MEMORY.ref(2, r2).setu(r3);
      r5 = CPU.addT(r1, 0x0);
    }

    //LAB_808ac54
    r1 = CPU.movT(0, 0xe6);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r5, r1);
    MEMORY.ref(2, r3).setu(r6);
    r2 = CPU.movT(0, 0xc0);
    r3 = CPU.movT(0, 0x7f);
    r2 = CPU.lslT(r2, 1);
    r6 = CPU.andT(r6, r3);
    r0 = CPU.addT(r6, r2);
    FUN_80770c8(r0);
    r1 = CPU.movT(0, 0xe0);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r5, r1);
    r2 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r2).get();
    r2 = MEMORY.ref(4, 0x808ac9c).get();
    r3 = CPU.lslT(r3, 3);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x3);
    r2 = MEMORY.ref(1, r3 + r2).get();
    r1 = CPU.addT(r1, 0x7e);
    r3 = CPU.addT(r5, r1);
    MEMORY.ref(2, r3).setu(r2);
    CPU.cmpT(r2, 0x2);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, 0x808acb8).get();
      FUN_80770c8(r0);
    }

    //LAB_808ac8e
    FUN_80772f0();
  }

  @Method(0x808acc4)
  public static void FUN_808acc4() {
    final int r0;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x808acdc).get();
    r2 = CPU.movT(0, 0xf8);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r3, r2);
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r3 + r2).get();
    FUN_80f9010(r0);
  }

  @Method(0x808ace0)
  public static void FUN_808ace0(int r0) {
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

    r3 = MEMORY.ref(4, 0x808addc).get();
    r2 = MEMORY.ref(4, 0x808ade0).get();
    r3 = MEMORY.ref(4, r3).get();
    r1 = CPU.movT(0, 0xe0);
    r1 = CPU.lslT(r1, 1);
    CPU.r10().value = r3;
    r3 = CPU.addT(r2, r1);
    r1 = CPU.movT(0, 0x0);
    r4 = MEMORY.ref(2, r3 + r1).get();
    CPU.r11().value = r4;
    r4 = CPU.movT(0, 0xe1);
    r4 = CPU.lslT(r4, 1);
    r3 = CPU.addT(r2, r4);
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r2).get();
    r6 = CPU.movT(0, 0xd0);
    CPU.sp().value -= 0x8;
    r6 = CPU.lslT(r6, 1);
    r3 = CPU.movT(0, 0x0);
    CPU.r9().value = r1;
    r6 += CPU.r10().value;
    r5 = MEMORY.ref(4, 0x808ade4).get();
    r7 = CPU.movT(0, 0x0);
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.movT(0, 0x1);
      r4 = CPU.movT(0, 0x0);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r1 = CPU.negT(r1, r1);
      r2 = MEMORY.ref(2, r5).getUnsigned();
      r3 = CPU.cmpT(r3, r1);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.r8().value = r1;
        r1 = MEMORY.ref(4, 0x808ade8).get();

        //LAB_808ad34
        do {
          r3 = CPU.lslT(r2, 16);
          r3 = CPU.asrT(r3, 16);
          CPU.cmpT(r3, CPU.r11().value);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x2);
            r3 = MEMORY.ref(2, r5 + r0).get();
            CPU.cmpT(r3, CPU.r8().value);
            if(r3 == CPU.r8().value || r3 == CPU.r9().value) {
              //LAB_808ad48
              r0 = MEMORY.ref(2, r5 + 0x4).getUnsigned();
              if((r0 & r1) == r1 || FUN_80770c0(r0 << 17 >> 17) == 0) {
                //LAB_808ad62
                r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
                r3 = CPU.lslT(r3, 24);
                r3 = CPU.asrT(r3, 31);
                r3 = CPU.lslT(r3, 16);
                r3 = CPU.asrT(r3, 16);
                r1 = CPU.movT(0, 0x6);
                r7 = MEMORY.ref(2, r5 + r1).get();
                MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
                break;
              }
            }
          }

          //LAB_808ad74
          r5 = CPU.addT(r5, 0x8);
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r5 + r4).get();
          r2 = MEMORY.ref(2, r5).getUnsigned();
          CPU.cmpT(r3, CPU.r8().value);
        } while(!CPU.cpsr().getZero()); // !=
      }
    }

    //LAB_808ad80
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(1, r6).setu(r3);
    r6 = CPU.addT(r6, 0x1);
    r3 = CPU.movT(0, 0x0);

    //LAB_808ad88
    do {
      MEMORY.ref(1, r6).setu(r7);
      r6 = CPU.addT(r6, 0x1);
      CPU.cmpT(r7, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r7 = CPU.addT(r7, 0x1);
      }

      //LAB_808ad92
      r3 = CPU.addT(r3, 0x1);
      CPU.cmpT(r3, 0x6);
    } while(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()); // unsigned <=

    r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(4, 0x808adec).get();
      r2 = CPU.movT(0, 0xd0);
      r0 += CPU.r10().value;
      r3 = MEMORY.ref(1, r0).getUnsigned();
      r2 = CPU.lslT(r2, 1);
      r2 += CPU.r10().value;
      MEMORY.ref(1, r2).setu(r3);
      MEMORY.ref(1, r0).setu(0);
    }

    //LAB_808adb0
    r2 = CPU.movT(0, 0xd4);
    r2 = CPU.lslT(r2, 1);
    r2 += CPU.r10().value;
    r3 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r2).setu(r3);
    r2 = CPU.movT(0, 0xd6);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.movT(0, 0x80);
    r2 += CPU.r10().value;
    r3 = CPU.lslT(r3, 13);
    MEMORY.ref(4, r2).setu(r3);
    FUN_808b25c();
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x808b090)
  public static void FUN_808b090() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    final int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);

    r4 = MEMORY.ref(4, 0x808b14c).get();
    r2 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r4, r2);
    r1 = CPU.movT(0, 0x12);
    CPU.r10().value = r1;
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r2).get();
    CPU.r11().value = r1;
    r1 = CPU.movT(0, 0xe1);
    r1 = CPU.lslT(r1, 1);
    r5 = MEMORY.ref(4, 0x808b150).get();
    r3 = CPU.addT(r4, r1);
    r1 = CPU.addT(r1, 0xa);
    r2 = CPU.movT(0, 0x0);
    r7 = MEMORY.ref(2, r3 + r2).get();
    r0 = MEMORY.ref(2, r5).getUnsigned();
    r3 = CPU.addT(r4, r1);
    r1 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(2, r3 + r1).get();
    r1 = CPU.addT(r0, 0x0);
    CPU.r9().value = r2;
    r3 = CPU.lslT(r1, 16);
    r2 = CPU.movT(0, 0x1);
    r3 = CPU.asrT(r3, 16);
    r2 = CPU.negT(r2, r2);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = MEMORY.ref(4, 0x808b154).get();
      CPU.r8().value = r2;

      //LAB_808b0da
      do {
        if((MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) != 0 && (short)r1 == CPU.r11().value || (MEMORY.ref(1, r5 + 0x3).getUnsigned() & 0x80) == 0 && (short)r0 == CPU.r9().value) {
          //LAB_808b0f6
          r2 = MEMORY.ref(2, r5 + 0x2).getUnsigned();
          if((r2 & r6) == r6 || r2 << 17 >> 17 == r7) {
            //LAB_808b108
            r0 = MEMORY.ref(2, r5 + 0x4).get();
            if(r0 == CPU.r8().value || FUN_80770c0(r0) != 0) {
              //LAB_808b118
              r1 = CPU.movT(0, 0x6);
              r3 = MEMORY.ref(2, r5 + r1).get();
              CPU.r10().value = r3;
              break;
            }
          }
        }

        //LAB_808b122
        r5 = CPU.addT(r5, 0x8);
        r1 = MEMORY.ref(2, r5).getUnsigned();
        r3 = CPU.lslT(r1, 16);
        r3 = CPU.asrT(r3, 16);
        r0 = CPU.addT(r1, 0x0);
        CPU.cmpT(r3, CPU.r8().value);
      } while(!CPU.cpsr().getZero()); // !=

      r4 = MEMORY.ref(4, 0x808b14c).get();
    }

    //LAB_808b132
    r2 = CPU.movT(0, 0xf8);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r4, r2);
    r1 = CPU.r10().value;
    MEMORY.ref(2, r3).setu(r1);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x808b1d8)
  public static void FUN_808b1d8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808b25c)
  public static void FUN_808b25c() {
    final int r0;
    int r1 = 0; // r1 undefined when if statement conditions are false
    int r2;
    int r3;
    int r4;
    final int r5;
    int r6;

    r2 = MEMORY.ref(4, 0x808b2a4).get();
    r3 = CPU.movT(0, 0xe0);
    CPU.r12().value = r2;
    r3 = CPU.lslT(r3, 1);
    r4 = MEMORY.ref(4, 0x808b2a8).get();
    r3 += CPU.r12().value;
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r3 + r2).get();
    r2 = MEMORY.ref(4, r4).get();
    r4 += 0x4;

    CPU.cmpT(r2, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.cmpT(r2, r0);
      if(!CPU.cpsr().getZero()) { // !=
        r6 = CPU.movT(0, 0x80);
        r5 = MEMORY.ref(4, 0x808b2ac).get();
        r6 = CPU.lslT(r6, 24);

        //LAB_808b27e
        do {
          r3 = CPU.addT(r2, 0x0);
          r3 = CPU.andT(r3, r6);
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r1 = CPU.addT(r5, 0x0);
            r1 = CPU.andT(r1, r2);
          }

          //LAB_808b28a
          r2 = MEMORY.ref(4, r4).get();
          r4 += 0x4;

          CPU.cmpT(r2, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            break;
          }
          r2 = CPU.cmpT(r2, r0);
        } while(!CPU.cpsr().getZero()); // !=
      }
    }

    //LAB_808b294
    r3 = CPU.movT(0, 0xeb);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r12().value;
    MEMORY.ref(2, r3).setu(r1);
  }

  @Method(0x808b398)
  public static int FUN_808b398(int r0) {
    int r5;

    r5 = CPU.addT(r0, 0x0);
    CPU.cmpT(r5, 0x8);
    if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
      r0 = CPU.movT(0, 0x20);
      r0 = FUN_80770c0(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        CPU.cmpT(r5, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r5 = CPU.movT(0, 0x12);
        }

        //LAB_808b3b0
        CPU.cmpT(r5, 0x1);
        if(CPU.cpsr().getZero()) { // ==
          r5 = CPU.movT(0, 0x13);
        }
      } else {
        //LAB_808b3b8
        r0 = CPU.movT(0, 0x21);
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          CPU.cmpT(r5, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r5 = CPU.movT(0, 0x11);
          }
        }
      }
    }

    //LAB_808b3c8
    r0 = CPU.addT(r5, 0x0);
    return r0;
  }

  @Method(0x808b3ec)
  public static void FUN_808b3ec(int r0, int r1) {
    int r2;
    int r3;
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

    r3 = MEMORY.ref(4, 0x808b638).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r9().value = r3;
    r3 = MEMORY.ref(4, r3).get();
    r7 = CPU.addT(r0, 0x0);
    CPU.r11().value = r1;
    CPU.sp().value -= 0x8;
    r1 = CPU.movT(0, 0x0);
    r3 = CPU.cmpT(r3, r7);

    jmp_808b42e:
    if(!CPU.cpsr().getZero()) { // !=
      CPU.cmpT(r3, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r0 = CPU.r9().value;
        MEMORY.ref(4, r0).setu(r7);
      } else {
        //LAB_808b418
        do {
          r1 = CPU.addT(r1, 0x1);
          CPU.cmpT(r1, 0x3);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            break jmp_808b42e;
          }
          r2 = CPU.lslT(r1, 2);
          r0 = CPU.r9().value;
          r3 = MEMORY.ref(4, r0 + r2).get();
          r3 = CPU.cmpT(r3, r7);
          if(CPU.cpsr().getZero()) { // ==
            break jmp_808b42e;
          }
          CPU.cmpT(r3, 0x0);
        } while(!CPU.cpsr().getZero()); // !=

        MEMORY.ref(4, r0 + r2).setu(r7);
      }
    }

    //LAB_808b42e
    r0 = CPU.movT(0, 0x1);
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r7 + r1).get();
    r0 = CPU.negT(r0, r0);
    r2 = MEMORY.ref(2, r7).getUnsigned();

    //LAB_808b43a
    while(r3 != r0 && CPU.r11().value <= 0x41) {
      r3 = CPU.lslT(r2, 16);
      r3 = CPU.asrT(r3, 16);
      CPU.cmpT(r3, 0x7);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
      } else {
        //LAB_808b446
        r2 = MEMORY.ref(4, 0x808b63c).get();
        r3 = CPU.cmpT(r3, r2);
        if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
          r3 = CPU.r11().value;
          r0 = CPU.movT(0, 0x1);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          CPU.r11().value += r0;
        }
      }

      //LAB_808b454
      r1 = CPU.movT(0, 0x2);
      r5 = MEMORY.ref(2, r7 + r1).get();
      r0 = CPU.addT(r5, 0x0);
      r0 = FUN_808d428(r0);
      CPU.cmpT(r0, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        //LAB_808b464
        r3 = CPU.addT(r5, 0x0);
        r3 = CPU.subT(r3, 0x30);
        if(r3 < 0 || r3 > 0x4f || MEMORY.ref(2, CPU.r9().value + 0x19e).get() == 3 || FUN_808d428(r5 + 0x50) != 0) {
          //LAB_808b488
          r3 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(2, r7 + r3).get();
          r0 = FUN_808b398(r0);
          CPU.r10().value = r0;
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r0 = FUN_808ba1c(r0);
          r6 = CPU.addT(r0, 0x0);
          CPU.cmpT(r6, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = MEMORY.ref(4, r7 + 0x8).get();
            r2 = MEMORY.ref(4, r7 + 0xc).get();
            r3 = MEMORY.ref(4, r7 + 0x10).get();
            r0 = CPU.r10().value;
            r0 = FUN_80090c8(r0, r1, r2, r3);
            r2 = MEMORY.ref(1, r7 + 0x17).getUnsigned();
            r3 = CPU.movT(0, 0x1);
            r3 = CPU.andT(r3, r2);
            r6 = CPU.addT(r0, 0x0);
            r1 = CPU.movT(0, 0x1);
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r0 = CPU.subT(r0, 0x1);
              MEMORY.ref(4, CPU.sp().value).setu(r1);
              r0 = FUN_808ba1c(r0);
              r3 = CPU.addT(r0, 0x0);
              r3 = CPU.addT(r3, 0x54);
              r3 = MEMORY.ref(1, r3).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value).get();
              CPU.cmpT(r3, 0x1);
              if(CPU.cpsr().getZero()) { // ==
                r3 = CPU.addT(r6, 0x0);
                r3 = CPU.addT(r3, 0x54);
                r3 = MEMORY.ref(1, r3).getUnsigned();
                CPU.cmpT(r3, 0x1);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = MEMORY.ref(4, r0 + 0x50).get();
                  r3 = MEMORY.ref(1, r0 + 0x1d).getUnsigned();
                  r3 = CPU.orrT(r3, r1);
                  MEMORY.ref(1, r0 + 0x1d).setu(r3);
                  r5 = MEMORY.ref(1, r0 + 0x1c).getUnsigned();
                  r0 = MEMORY.ref(4, r6 + 0x50).get();
                  r3 = MEMORY.ref(1, r0 + 0x1d).getUnsigned();
                  r3 = CPU.orrT(r3, r1);
                  CPU.r8().value = r0;
                  MEMORY.ref(1, r0 + 0x1d).setu(r3);
                  r0 = MEMORY.ref(1, r0 + 0x1c).getUnsigned();
                  r0 = FUN_8003f3c(r0);
                  r1 = CPU.r8().value;
                  MEMORY.ref(1, r1 + 0x1c).setu(r5);
                }
              }
            }

            //LAB_808b4f6
            r0 = CPU.movT(0, 0x21);
            r0 = FUN_80770c0(r0);
            CPU.cmpT(r0, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.r10().value;
              r3 = CPU.subT(r3, 0x12);
              CPU.cmpT(r3, 0x1);
              if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
                r0 = CPU.addT(r6, 0x0);
                r1 = CPU.movT(0, 0xe2);
                FUN_8009228(r0, r1);
              }
            }
          } else {
            //LAB_808b512
            r0 = MEMORY.ref(4, 0x808b640).get();
            r0 = FUN_80770c0(r0);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              r1 = MEMORY.ref(4, r7 + 0x8).get();
              r2 = MEMORY.ref(4, r7 + 0xc).get();
              r3 = MEMORY.ref(4, r7 + 0x10).get();
              r0 = CPU.addT(r6, 0x0);
              FUN_80090f0(r0, r1, r2, r3);
            }
          }

          //LAB_808b528
          CPU.cmpT(r6, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = CPU.addT(r6, 0x0);
            r1 = CPU.movT(0, 0x1);
            FUN_8009080(r0, r1);
            r3 = CPU.addT(r6, 0x0);
            r3 = CPU.addT(r3, 0x54);
            r3 = MEMORY.ref(1, r3).getUnsigned();
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              r2 = MEMORY.ref(4, r6 + 0x50).get();
              CPU.r8().value = r2;
              CPU.cmpT(r2, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r0 = FUN_8004458();
                r1 = CPU.movT(0, 0x1e);
                r0 = FUN_8002304(r0, r1);
                r3 = CPU.r8().value;
                r3 = CPU.addT(r3, 0x24);
                MEMORY.ref(1, r3).setu(r0);
              }
            }

            //LAB_808b556
            r3 = MEMORY.ref(2, r7 + 0x14).getUnsigned();
            r2 = CPU.addT(r6, 0x0);
            MEMORY.ref(2, r6 + 0x6).setu(r3);
            r2 = CPU.addT(r2, 0x59);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2).setu(r3);
            r1 = MEMORY.ref(4, r7 + 0x4).get();
            r0 = CPU.addT(r6, 0x0);
            FUN_8093a6c(r0, r1);
            r0 = CPU.addT(r6, 0x0);
            r1 = CPU.movT(0, 0x1);
            FUN_8009080(r0, r1);
            r2 = MEMORY.ref(4, r6 + 0x8).get();
            CPU.cmpT(r2, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r3 = MEMORY.ref(4, 0x808b644).get();
              r2 = CPU.addT(r2, r3);
            }

            //LAB_808b57c
            r3 = CPU.addT(r6, 0x0);
            r3 = CPU.addT(r3, 0x64);
            r2 = CPU.asrT(r2, 16);
            MEMORY.ref(2, r3).setu(r2);
            r3 = MEMORY.ref(4, r6 + 0x10).get();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
              r0 = MEMORY.ref(4, 0x808b644).get();
              r3 = CPU.addT(r3, r0);
            }

            //LAB_808b58e
            r2 = CPU.addT(r6, 0x0);
            r3 = CPU.asrT(r3, 16);
            r2 = CPU.addT(r2, 0x66);
            MEMORY.ref(2, r2).setu(r3);
            r3 = MEMORY.ref(4, r6 + 0xc).get();
            CPU.cmpT(r3, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = CPU.movT(0, 0x4);
              r2 = CPU.subT(r2, 0x11);
              MEMORY.ref(1, r2).setu(r3);
              r1 = CPU.movT(0, 0x80);
              r3 = MEMORY.ref(4, r6 + 0xc).get();
              r1 = CPU.lslT(r1, 8);
              r3 = CPU.addT(r3, r1);
              MEMORY.ref(4, r6 + 0xc).setu(r3);
            }

            //LAB_808b5ac
            r3 = CPU.movT(0, 0xcf);
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r9().value;
            r2 = CPU.movT(0, 0x0);
            r3 = MEMORY.ref(2, r3 + r2).get();
            CPU.cmpT(r3, 0x3);
            if(CPU.cpsr().getZero()) { // ==
              r1 = CPU.addT(r6, 0x0);
              r1 = CPU.addT(r1, 0x55);
              r3 = MEMORY.ref(1, r1).getUnsigned();
              r2 = CPU.movT(0, 0xfe);
              r2 = CPU.andT(r2, r3);
              MEMORY.ref(1, r1).setu(r2);
              r0 = CPU.movT(0, 0x21);
              r0 = FUN_80770c0(r0);
              CPU.cmpT(r0, 0x0);
              if(CPU.cpsr().getZero()) { // ==
                r1 = CPU.r8().value;
                r0 = MEMORY.ref(4, r1 + 0x18).get();
                r1 = CPU.movT(0, 0xc0);
                r3 = MEMORY.ref(4, 0x808b648).get();
                r1 = CPU.lslT(r1, 8);
                r0 = CPU.lslT(r0, 0);
                CPU.r12().value = 0x808b5e0;
                MEMORY.call(r3, r0, r1);
                r2 = CPU.r8().value;
                MEMORY.ref(4, r2 + 0x18).setu(r0);
              }
            } else {
              //LAB_808b5e6
              r1 = MEMORY.ref(4, r6 + 0x8).get();
              r2 = MEMORY.ref(4, r6 + 0x10).get();
              r0 = CPU.movT(0, 0x0);
              r0 = FUN_80091a8(r0, r1, r2);
              r3 = MEMORY.ref(4, r6 + 0xc).get();
              r3 = CPU.addT(r3, r0);
              MEMORY.ref(4, r6 + 0x14).setu(r0);
              MEMORY.ref(4, r6 + 0xc).setu(r3);
            }

            //LAB_808b5f8
            r2 = CPU.addT(r6, 0x0);
            r2 = CPU.addT(r2, 0x23);
            r3 = CPU.movT(0, 0x1);
            MEMORY.ref(1, r2).setu(r3);
          }

          //LAB_808b600
          r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
          r3 = CPU.lslT(r0, 2);
          r3 = CPU.addT(r3, 0x14);
          r1 = CPU.r9().value;
          MEMORY.ref(4, r1 + r3).setu(r6);
        }
      }

      //LAB_808b60a
      r7 = CPU.addT(r7, 0x18);
      r3 = MEMORY.ref(2, r7).getUnsigned();
      r2 = CPU.addT(r3, 0x0);
      r3 = CPU.lslT(r2, 16);
      r0 = CPU.movT(0, 0x1);
      r3 = CPU.asrT(r3, 16);
      r0 = CPU.negT(r0, r0);

      //LAB_808b618
    }

    //LAB_808b624
    CPU.sp().value += 0x8;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x808b674)
  public static void FUN_808b674(int r0) {
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

    r3 = MEMORY.ref(4, 0x808b794).get();
    r3 = MEMORY.ref(4, r3).get();
    CPU.r10().value = r0;
    CPU.r8().value = r3;
    r0 = CPU.movT(0, 0xfa);
    r3 = MEMORY.ref(4, 0x808b798).get();
    r0 = CPU.lslT(r0, 1);
    r5 = CPU.movT(0, 0x80);
    r3 = CPU.addT(r3, r0);
    r5 = CPU.lslT(r5, 2);
    r7 = MEMORY.ref(4, r3).get();
    r5 += CPU.r8().value;
    r3 = MEMORY.ref(4, 0x808b79c).get();
    r2 = CPU.addT(r5, 0x0);
    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r1 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r4 = MEMORY.ref(4, r3).get();
    r3 += 0x4;

    MEMORY.ref(4, r2).setu(r0);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r1);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r4);
    r2 += 0x4;

    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r1 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r4 = MEMORY.ref(4, r3).get();
    r3 += 0x4;

    MEMORY.ref(4, r2).setu(r0);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r1);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r4);
    r2 += 0x4;

    r2 = CPU.movT(0, 0x86);
    r2 = CPU.lslT(r2, 2);
    r2 += CPU.r8().value;
    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r1 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r4 = MEMORY.ref(4, r3).get();
    r3 += 0x4;

    MEMORY.ref(4, r2).setu(r0);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r1);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r4);
    r2 += 0x4;

    r0 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r1 = MEMORY.ref(4, r3).get();
    r3 += 0x4;
    r4 = MEMORY.ref(4, r3).get();
    r3 += 0x4;

    MEMORY.ref(4, r2).setu(r0);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r1);
    r2 += 0x4;
    MEMORY.ref(4, r2).setu(r4);
    r2 += 0x4;

    r3 = CPU.r8().value;
    r2 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r3, 0xc);
    CPU.r12().value = CPU.r8().value;

    //LAB_808b6b6
    do {
      MEMORY.ref(4, r3).setu(r2);
      r3 = CPU.subT(r3, 0x4);
      CPU.cmpT(r3, CPU.r12().value);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=

    FUN_808b9f8();
    r3 = MEMORY.ref(4, 0x808b7a0).get();
    r6 = MEMORY.ref(4, 0x808b798).get();
    r1 = CPU.movT(0, 0xee);
    MEMORY.ref(2, r5 + 0x2).setu(r3);
    MEMORY.ref(2, r5).setu(r7);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r6, r1);
    r3 = MEMORY.ref(4, r3).get();
    r2 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5 + 0xc).setu(r2);
    r2 = CPU.movT(0, 0xf2);
    MEMORY.ref(4, r5 + 0x8).setu(r3);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r6, r2);
    r3 = MEMORY.ref(4, r3).get();
    r4 = CPU.movT(0, 0xf4);
    MEMORY.ref(4, r5 + 0x10).setu(r3);
    r4 = CPU.lslT(r4, 1);
    r3 = CPU.addT(r6, r4);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.addT(r5, 0x0);
    MEMORY.ref(2, r5 + 0x14).setu(r3);
    r1 = CPU.addT(r7, 0x0);
    FUN_808b3ec(r0, r1);
    r0 = CPU.r10().value;
    r1 = CPU.movT(0, 0x8);
    FUN_808b3ec(r0, r1);
    r3 = CPU.lslT(r7, 2);
    r3 = CPU.addT(r3, 0x14);
    r0 = CPU.r8().value;
    r1 = CPU.movT(0, 0xf6);
    r5 = MEMORY.ref(4, r0 + r3).get();
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r6, r1);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r2 = CPU.addT(r5, 0x0);
    r2 = CPU.addT(r2, 0x22);
    MEMORY.ref(1, r2).setu(r3);
    r3 = MEMORY.ref(4, r5 + 0x8).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r2 = MEMORY.ref(4, 0x808b7a4).get();
      r3 = CPU.addT(r3, r2);
    }

    //LAB_808b71c
    r2 = CPU.asrT(r3, 20);
    r3 = MEMORY.ref(4, r5 + 0x10).get();
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
      r4 = MEMORY.ref(4, 0x808b7a4).get();
      r3 = CPU.addT(r3, r4);
    }

    //LAB_808b728
    r3 = CPU.asrT(r3, 20);
    r3 = CPU.lslT(r3, 7);
    r3 = CPU.addT(r2, r3);
    r0 = MEMORY.ref(4, 0x808b7a8).get();
    r3 = CPU.lslT(r3, 2);
    r2 = CPU.addT(r3, r0);
    r4 = MEMORY.ref(4, 0x808b7ac).get();
    r0 = CPU.movT(0, 0xf0);
    r0 = CPU.lslT(r0, 1);
    r1 = CPU.addT(r3, r4);
    r3 = CPU.addT(r6, r0);
    r3 = MEMORY.ref(4, r3).get();
    if(r3 != 0 && MEMORY.ref(1, r2 + 0x2).getUnsigned() == 0xfd && MEMORY.ref(1, r1 + 0x2).getUnsigned() == 0xfd) {
      r1 = CPU.movT(0, 0xf9);
      r1 = CPU.lslT(r1, 1);
      r2 = CPU.addT(r6, r1);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r2).setu(r3);
      r3 = MEMORY.ref(4, 0x808b7b0).get();
      r2 = MEMORY.ref(4, r5 + 0x10).get();
      r1 = MEMORY.ref(4, r5 + 0x8).get();
      r2 = CPU.addT(r2, r3);
      r0 = CPU.movT(0, 0x0);
      r0 = FUN_80091a8(r0, r1, r2);
      r4 = MEMORY.ref(4, 0x808b7b4).get();
      r3 = MEMORY.ref(4, r5 + 0xc).get();
      r0 = CPU.addT(r0, r4);
      r3 = CPU.addT(r3, r0);
      MEMORY.ref(4, r5 + 0xc).setu(r3);
      MEMORY.ref(4, r5 + 0x14).setu(r3);
      r2 = CPU.addT(r5, 0x0);
      r3 = MEMORY.ref(4, 0x808b790).get();
      r2 = CPU.addT(r2, 0x55);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r2).setu(r3);
      FUN_80091e0(r0, r1);
      r0 = CPU.addT(r5, 0x0);
      r1 = CPU.movT(0, 0xc);
      FUN_8009080(r0, r1);
    } else {
      //LAB_808b7b8
      r3 = MEMORY.ref(4, 0x808b81c).get();
      r0 = CPU.movT(0, 0xf9);
      r0 = CPU.lslT(r0, 1);
      r2 = CPU.addT(r3, r0);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(1, r2).setu(r3);
    }

    //LAB_808b7c4
    r0 = CPU.movT(0, 0x80);
    r1 = MEMORY.ref(4, r5 + 0x8).get();
    r2 = MEMORY.ref(4, r5 + 0xc).get();
    r3 = MEMORY.ref(4, r5 + 0x10).get();
    r0 = CPU.lslT(r0, 8);
    r0 = FUN_80090c8(r0, r1, r2, r3);
    r3 = MEMORY.ref(4, r5 + 0x14).get();
    r6 = CPU.addT(r0, 0x0);
    MEMORY.ref(4, r6 + 0x14).setu(r3);
    r1 = CPU.addT(r5, 0x0);
    FUN_80090e0(r0, r1);
    r3 = CPU.movT(0, 0xcf);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r8().value;
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r1).get();
    CPU.cmpT(r3, 0x3);
    if(CPU.cpsr().getZero()) { // ==
      r0 = MEMORY.ref(4, r5 + 0x50).get();
      r1 = CPU.movT(0, 0x17);
      r0 = FUN_8009048(r0, r1);
      r3 = CPU.movT(0, 0xf);
      MEMORY.ref(1, r0 + 0x5).setu(r3);
      r3 = CPU.movT(0, 0x9);
      MEMORY.ref(1, r0 + 0x6).setu(r3);
    }

    //LAB_808b7fc
    r3 = MEMORY.ref(4, 0x808b820).get();
    r2 = MEMORY.ref(4, r3).get();
    r3 = CPU.addT(r6, 0x0);
    r3 = CPU.addT(r3, 0x8);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.movT(0, 0xf0);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r8().value;
    MEMORY.ref(4, r3).setu(r6);
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x808b9f8)
  public static void FUN_808b9f8() {
    int r0;
    final int r1;
    int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x808ba18).get();
    r0 = CPU.movT(0, 0x8c);
    r3 = MEMORY.ref(4, r3).get();
    r0 = CPU.lslT(r0, 1);
    r1 = CPU.movT(0, 0x0);
    r2 = CPU.movT(0, 0x41);
    r3 = CPU.addT(r3, r0);

    //LAB_808ba08
    do {
      r2 = CPU.subT(r2, 0x1);
      MEMORY.ref(4, r3).setu(r1);
      r3 = CPU.subT(r3, 0x4);
      CPU.cmpT(r2, 0x0);
    } while(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >=
  }

  @Method(0x808ba1c)
  public static int FUN_808ba1c(int r0) {
    final int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x808ba34).get();
    r2 = MEMORY.ref(4, r3).get();
    CPU.cmpT(r0, 0xbf);
    if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
      r0 = CPU.movT(0, 0x0);
    } else {
      //LAB_808ba2a
      r3 = CPU.lslT(r0, 2);
      r3 = CPU.addT(r3, 0x14);
      r0 = MEMORY.ref(4, r2 + r3).get();
    }

    //LAB_808ba30
    return r0;
  }

  @Method(0x808ba38)
  public static void FUN_808ba38() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bb2c)
  public static void FUN_808bb2c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bc44)
  public static void FUN_808bc44() {
    int r0;
    final int r1;
    final int r2;
    int r3;

    r3 = MEMORY.ref(4, 0x808bc98).get();
    r0 = CPU.movT(0, 0xb6);
    r1 = MEMORY.ref(4, r3).get();
    r0 = CPU.lslT(r0, 1);
    r2 = CPU.movT(0, 0x0);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    r0 = CPU.addT(r0, 0x2);
    MEMORY.ref(2, r3).setu(r2);
    r3 = CPU.addT(r1, r0);
    MEMORY.ref(2, r3).setu(r2);
  }

  @Method(0x808bc9c)
  public static int FUN_808bc9c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808bec0)
  public static void FUN_808bec0(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c44c)
  public static void FUN_808c44c() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c4c0)
  public static void FUN_808c4c0() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808c4f8)
  public static int FUN_808c4f8(int r0) {
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

    r1 = MEMORY.ref(4, 0x808c7f0).get();
    r0 = CPU.movT(0, 0x1b);
    CPU.sp().value -= 0x10;
    r0 = FUN_80048f4(r0, r1);
    r7 = CPU.movT(0, 0x0);
    CPU.r8().value = r0;
    r0 = CPU.sp().value + 0xc;
    MEMORY.ref(4, r0).setu(r7);
    r1 = CPU.r8().value;
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(0x85000333);

    r0 = MEMORY.ref(4, 0x808c7fc).get();
    FUN_80770d0(r0);
    r5 = MEMORY.ref(4, 0x808c800).get();
    r1 = CPU.movT(0, 0xe0);
    r1 = CPU.lslT(r1, 1);
    r3 = CPU.addT(r5, r1);
    r4 = CPU.movT(0, 0xe4);
    r2 = MEMORY.ref(2, r3).getUnsigned();
    r4 = CPU.lslT(r4, 1);
    r3 = CPU.addT(r5, r4);
    MEMORY.ref(2, r3).setu(r2);
    r1 = CPU.addT(r1, 0x2);
    r3 = CPU.addT(r5, r1);
    r3 = MEMORY.ref(2, r3).getUnsigned();
    r4 = CPU.addT(r4, 0x2);
    r2 = CPU.addT(r5, r4);
    MEMORY.ref(2, r2).setu(r3);
    r1 = CPU.addT(r1, 0xc);
    r3 = MEMORY.ref(4, 0x808c804).get();
    r2 = CPU.addT(r5, r1);
    MEMORY.ref(2, r2).setu(r3);
    r3 = CPU.movT(0, 0xe8);
    r3 = CPU.lslT(r3, 1);
    r2 = CPU.addT(r5, r3);
    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r4 = CPU.addT(r4, 0x8);
    MEMORY.ref(2, r2).setu(r3);
    r1 = CPU.addT(r1, 0x6);
    r2 = CPU.addT(r5, r4);
    MEMORY.ref(2, r2).setu(r3);
    r2 = CPU.addT(r5, r1);
    MEMORY.ref(2, r2).setu(r3);
    FUN_80040e8();
    r0 = CPU.movT(0, 0x0);
    FUN_8095778(r0);
    r2 = CPU.movT(0, 0xed);
    r2 = CPU.lslT(r2, 1);
    r3 = CPU.addT(r5, r2);
    r4 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r3 + r4).get();
    if(r0 == 1) {
      FUN_8009118();
      r1 = CPU.movT(0, 0x89);
      r1 = CPU.lslT(r1, 2);
      r2 = CPU.addT(r5, r1);
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(1, r2).setu(r3);
      r0 = CPU.movT(0, 0x0);
      r6 = CPU.movT(0, 0x3);
      FUN_808ace0(r0);
    } else {
      //LAB_808c598
      FUN_8009110(r0);
      r0 = CPU.movT(0, 0x1);
      r6 = CPU.movT(0, 0x2);
      FUN_808ace0(r0);
    }

    //LAB_808c5a4
    r3 = CPU.movT(0, 0xcf);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r8().value;
    MEMORY.ref(2, r3).setu(r6);
    r0 = CPU.addT(r6, 0x0);
    FUN_8009078(r0);
    FUN_8015000();
    FUN_808bc44();
    r5 = 0x2008000;
    r0 = MEMORY.ref(4, r5 + 0x24).get();
    r0 = (int)MEMORY.call(r0);
    r2 = CPU.r8().value;
    MEMORY.ref(4, r2 + 0x10).setu(r0);
    FUN_808cf78();
    r0 = MEMORY.ref(4, r5 + 0x1c).get();
    r0 = (int)MEMORY.call(r0);
    FUN_808b674(r0);
    r0 = MEMORY.ref(4, 0x808c810).get();
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_808bb2c();
    }

    //LAB_808c5e2
    r5 = MEMORY.ref(4, 0x808c800).get();
    r4 = CPU.movT(0, 0x8d);
    r4 = CPU.lslT(r4, 2);
    r3 = CPU.addT(r5, r4);
    r1 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r1).get();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      FUN_8095680();
    }

    //LAB_808c5f6
    CPU.cmpT(r6, 0x3);
    if(CPU.cpsr().getZero()) { // ==
      FUN_8009130();
      r2 = CPU.movT(0, 0xee);
      r2 = CPU.lslT(r2, 1);
      r4 = CPU.movT(0, 0xf2);
      r3 = CPU.addT(r5, r2);
      r4 = CPU.lslT(r4, 1);
      r0 = MEMORY.ref(4, r3).get();
      r3 = CPU.addT(r5, r4);
      r1 = MEMORY.ref(4, r3).get();
      FUN_8009138(r0, r1);
    } else {
      //LAB_808c614
      FUN_8009128();
    }

    //LAB_808c618
    FUN_808e9c0();
    FUN_8091174();
    r0 = CPU.movT(0, 0x80);
    r1 = CPU.movT(0, 0x0);
    r0 = CPU.lslT(r0, 9);
    FUN_8091200(r0, r1);
    r2 = CPU.movT(0, 0xe0);
    r2 = CPU.lslT(r2, 1);
    r2 += CPU.r8().value;
    r3 = CPU.movT(0, 0x80);
    r1 = CPU.addT(r2, 0x0);
    r3 = CPU.lslT(r3, 1);
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.addT(r3, 0xc8);
    r3 += CPU.r8().value;
    r4 = CPU.movT(0, 0x10);
    r7 = CPU.movT(0, 0xe3);
    r2 = CPU.movT(0, 0xd8);
    MEMORY.ref(4, r3).setu(r4);
    CPU.r10().value = r3;
    r7 = CPU.lslT(r7, 1);
    r3 = MEMORY.ref(4, 0x808c814).get();
    r2 = CPU.lslT(r2, 1);
    r6 = CPU.movT(0, 0x0);
    r7 += CPU.r8().value;
    r2 += CPU.r8().value;
    MEMORY.ref(2, r7).setu(r6);
    MEMORY.ref(4, r2).setu(r3);
    r3 = CPU.addT(r3, 0x1b);
    r3 += CPU.r8().value;
    r5 = MEMORY.ref(4, 0x808c800).get();
    r1 = MEMORY.ref(4, 0x808c818).get();
    MEMORY.ref(4, r3).setu(r6);
    r3 = CPU.addT(r5, r1);
    CPU.r11().value = r4;
    r4 = CPU.movT(0, 0x0);
    r3 = MEMORY.ref(2, r3 + r4).get();
    CPU.cmpT(r3, 0x2);
    if(CPU.cpsr().getZero()) { // ==
      r0 = CPU.movT(0, 0xa2);
      MEMORY.ref(4, r2).setu(r6);
      r0 = CPU.lslT(r0, 1);
      FUN_80770c8(r0);
    }

    //LAB_808c678
    r3 = CPU.movT(0, 0xde);
    r1 = MEMORY.ref(4, 0x808c810).get();
    r3 = CPU.lslT(r3, 1);
    r2 = MEMORY.ref(4, 0x808c81c).get();
    r3 += CPU.r8().value;
    CPU.r9().value = r1;
    MEMORY.ref(4, r3).setu(r2);
    r0 = CPU.r9().value;
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      FUN_808b1d8();
      r2 = CPU.movT(0, 0x8b);
      r2 = CPU.lslT(r2, 2);
      r1 = MEMORY.ref(4, 0x808c820).get();
      r3 = CPU.addT(r5, r2);
      r4 = CPU.r11().value;
      MEMORY.ref(2, r3).setu(r4);
      r3 = CPU.addT(r5, r1);
      MEMORY.ref(2, r3).setu(r6);
      r3 = CPU.movT(0, 0x8c);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r5, r3);
      r4 = MEMORY.ref(4, 0x808c824).get();
      r3 = CPU.movT(0, 0x1);
      MEMORY.ref(2, r2).setu(r3);
      r3 = MEMORY.ref(4, 0x808c804).get();
      r2 = CPU.addT(r5, r4);
      r1 = CPU.addT(r1, 0x1e);
      MEMORY.ref(2, r2).setu(r3);
      r3 = CPU.addT(r5, r1);
      MEMORY.ref(2, r3).setu(r6);
    }

    //LAB_808c6bc
    FUN_8099810();
    r2 = MEMORY.ref(4, 0x808c828).get();
    r3 = MEMORY.ref(4, 0x808c804).get();
    r2 += CPU.r8().value;
    MEMORY.ref(2, r2).setu(r3);
    r3 = MEMORY.ref(4, 0x808c80c).get();
    r0 = MEMORY.ref(4, r3 + 0x4).get();
    MEMORY.call(r0);
    r3 = CPU.movT(0, 0xb8);
    r3 = CPU.lslT(r3, 1);
    r3 += CPU.r8().value;
    r2 = CPU.movT(0, 0x0);
    r0 = MEMORY.ref(2, r3 + r2).get();
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r7 = CPU.addT(r0, 0x0);
      MEMORY.ref(2, r3).setu(r6);
    } else {
      //LAB_808c6ec
      r0 = CPU.r9().value;
      FUN_80770d0(r0);
      r0 = FUN_808bc9c();
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r5 = MEMORY.ref(2, r7).getUnsigned();
        CPU.cmpT(r5, 0x0);
        if(CPU.cpsr().getZero()) { // ==
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          r4 = CPU.r10().value;
          r0 = MEMORY.ref(4, r3).get();
          r1 = MEMORY.ref(4, r4).get();
          FUN_808fefc(r0, r1);
          r3 = CPU.movT(0, 0x1);
          MEMORY.ref(2, r7).setu(r3);
          r3 = CPU.movT(0, 0xa0);
          r3 = CPU.lslT(r3, 19);
          MEMORY.ref(2, r3).setu(r5);
          r0 = FUN_8094428();
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r1 = CPU.r10().value;
            r0 = MEMORY.ref(4, r1).get();
            r0 = CPU.addT(r0, 0x1);
            r3 = CPU.lsrT(r0, 31);
            r0 = CPU.addT(r0, r3);
            r0 = CPU.asrT(r0, 1);
            FUN_80030f8(r0);
          }
        }

        //LAB_808c72e
        r5 = MEMORY.ref(4, 0x808c82c).get();
        r0 = CPU.addT(r5, 0x0);
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = CPU.addT(r5, 0x0);
          FUN_80770d0(r0);
          r3 = MEMORY.ref(4, 0x808c800).get();
          r2 = CPU.movT(0, 0xe0);
          r2 = CPU.lslT(r2, 1);
          r3 = CPU.addT(r3, r2);
          r4 = CPU.movT(0, 0x0);
          r0 = MEMORY.ref(2, r3 + r4).get();
          FUN_8015200(r0);
        }

        //LAB_808c750
        r5 = MEMORY.ref(4, 0x808c800).get();
        r1 = CPU.movT(0, 0x8d);
        r1 = CPU.lslT(r1, 2);
        r6 = CPU.addT(r5, r1);
        r2 = CPU.movT(0, 0x0);
        r0 = MEMORY.ref(2, r6 + r2).get();
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0x1);
          FUN_8095778(r0);
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(2, r6).setu(r3);
        }

        //LAB_808c76a
        r3 = CPU.movT(0, 0x8f);
        r3 = CPU.lslT(r3, 2);
        r5 = CPU.addT(r5, r3);
        r3 = MEMORY.ref(2, r5).getUnsigned();
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          FUN_808c44c();
          r0 = MEMORY.ref(2, r5).getUnsigned();
          r0 = FUN_80919d8(r0);
          CPU.cmpT(r0, 0x0);
          if(CPU.cpsr().getZero()) { // ==
            r0 = MEMORY.ref(2, r5).getUnsigned();
            r1 = CPU.movT(0, 0x0);
            r0 = FUN_8091a58(r0, r1);
          }

          //LAB_808c78c
          FUN_808c4c0();
          r3 = CPU.movT(0, 0x0);
          MEMORY.ref(2, r5).setu(r3);
        }
      }

      //LAB_808c794
      r4 = MEMORY.ref(4, 0x808c800).get();
      r1 = CPU.movT(0, 0x0);
      CPU.r9().value = r4;
      CPU.r11().value = r1;

      //LAB_808c79c
      outer:
      do {
        r0 = CPU.movT(0, 0x82);
        r0 = CPU.lslT(r0, 1);
        FUN_80770c8(r0);
        r2 = MEMORY.ref(4, 0x808c830).get();
        r3 = MEMORY.ref(4, r2).get();
        r3 = CPU.lslT(r3, 2);
        r4 = CPU.r8().value;
        r3 = CPU.addT(r3, 0x14);
        r3 = MEMORY.ref(4, r4 + r3).get();
        CPU.r10().value = r3;
        r0 = CPU.r10().value;
        FUN_8009140(r0);
        r1 = CPU.r10().value;
        r2 = CPU.movT(0, 0xee);
        r3 = MEMORY.ref(4, r1 + 0x8).get();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r3 = CPU.movT(0, 0xf0);
        r3 = CPU.lslT(r3, 1);
        r3 += CPU.r9().value;
        r2 = CPU.r11().value;
        MEMORY.ref(4, r3).setu(r2);
        r2 = CPU.movT(0, 0xf2);
        r3 = MEMORY.ref(4, r1 + 0x10).get();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r2 = CPU.movT(0, 0xf4);
        r3 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
        r2 = CPU.lslT(r2, 1);
        r2 += CPU.r9().value;
        MEMORY.ref(4, r2).setu(r3);
        r3 = CPU.r10().value;
        r3 = CPU.addT(r3, 0x22);
        r3 = MEMORY.ref(1, r3).getUnsigned();
        r4 = MEMORY.ref(4, 0x808c834).get();
        MEMORY.ref(2, r4).setu(r3);

        //LAB_808c838
        while(FUN_808bc9c() != 0) {
          r1 = CPU.movT(0, 0xb8);
          r1 = CPU.lslT(r1, 1);
          r1 += CPU.r8().value;
          r2 = CPU.movT(0, 0x0);
          r5 = MEMORY.ref(2, r1 + r2).get();
          CPU.cmpT(r5, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_808c6e4
            r3 = CPU.movT(0, 0x0);
            r7 = CPU.addT(r5, 0x0);
            MEMORY.ref(2, r1).setu(r3);
            break outer;
          }

          //LAB_808c848
          r2 = CPU.movT(0, 0xc1);
          r2 = CPU.lslT(r2, 1);
          r2 += CPU.r8().value;
          r3 = CPU.movT(0, 0x0);
          r6 = MEMORY.ref(2, r2 + r3).get();
          CPU.cmpT(r6, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            //LAB_808c858
            r3 = MEMORY.ref(4, 0x808c890).get();
            r4 = MEMORY.ref(4, 0x808c88c).get();
            r3 += CPU.r8().value;
            MEMORY.ref(2, r3).setu(r4);
            r1 = CPU.movT(0, 0x0);
            r0 = MEMORY.ref(2, r2 + r1).get();
            r2 = CPU.movT(0, 0x1);
            r2 = CPU.negT(r2, r2);
            r0 = CPU.cmpT(r0, r2);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_808c9d4
              r3 = MEMORY.ref(4, 0x808caa0).get();
              r0 = CPU.cmpT(r0, r3);
              if(CPU.cpsr().getZero()) { // ==
                FUN_8091660();
                r0 = MEMORY.ref(4, 0x808caa4).get();
                FUN_809c138(r0);
              } else {
                //LAB_808c9e6
                r4 = MEMORY.ref(4, 0x808caa8).get();
                r0 = CPU.cmpT(r0, r4);
                if(CPU.cpsr().getZero()) { // ==
                  FUN_8091660();
                  FUN_809c3a4();
                } else {
                  //LAB_808c9f6
                  FUN_808d7d8(r0);
                }
              }
            } else {
              //LAB_808c86e
              FUN_8091660();
              FUN_808c44c();
              r3 = CPU.movT(0, 0xc2);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r4 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r4).get();
              r6 = CPU.movT(0, 0x0);
              r5 = CPU.cmpT(r5, r3);
              if(!CPU.cpsr().getCarry()) { // unsigned <
                r5 = CPU.movT(0, 0xc4);
                r5 = CPU.lslT(r5, 1);

                //LAB_808c894
                do {
                  r0 = CPU.r10().value;
                  r1 = CPU.movT(0, 0x16);
                  FUN_8009080(r0, r1);
                  r1 = CPU.r8().value;
                  r0 = MEMORY.ref(2, r5 + r1).get();
                  r1 = CPU.movT(0, 0x1);
                  FUN_8015120(r0, r1);
                  r0 = MEMORY.ref(4, 0x808c8f8).get();
                  r1 = CPU.movT(0, 0x1);
                  FUN_8015040(r0, r1);
                  r3 = CPU.movT(0, 0xc2);
                  r3 = CPU.lslT(r3, 1);
                  r3 += CPU.r8().value;
                  r4 = CPU.movT(0, 0x0);
                  r3 = MEMORY.ref(2, r3 + r4).get();
                  r6 = CPU.addT(r6, 0x1);
                  r5 = CPU.addT(r5, 0x2);
                  r6 = CPU.cmpT(r6, r3);
                } while(!CPU.cpsr().getCarry()); // unsigned <
              }

              //LAB_808c8c0
              r3 = CPU.movT(0, 0xc3);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r1 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r1).get();
              CPU.cmpT(r3, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                //LAB_808c9c0
                FUN_808c4c0();
              } else {
                //LAB_808c8d0
                r2 = MEMORY.ref(4, 0x808c8fc).get();
                r3 = MEMORY.ref(4, r2).get();
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r0 = CPU.movT(0, 0x20);
                  r0 = FUN_80770c0(r0);
                  CPU.cmpT(r0, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r0 = CPU.r10().value;
                    r1 = CPU.movT(0, 0x15);
                    FUN_8009080(r0, r1);
                  } else {
                    //LAB_808c8ec
                    r0 = CPU.r10().value;
                    r1 = CPU.movT(0, 0x25);
                    FUN_8009080(r0, r1);
                  }
                } else {
                  //LAB_808c900
                  r0 = CPU.r10().value;
                  r1 = CPU.movT(0, 0x13);
                  FUN_8009080(r0, r1);
                }

                //LAB_808c908
                r0 = CPU.movT(0, 0x3b);
                FUN_80f9010(r0);
                r1 = CPU.movT(0, 0x1);
                r0 = MEMORY.ref(4, 0x808c948).get();
                FUN_8015040(r0, r1);
                r3 = MEMORY.ref(4, 0x808c94c).get();
                r0 = MEMORY.ref(4, r3).get();
                r0 = FUN_8077008(r0);
                r4 = MEMORY.ref(4, 0x808c944).get();
                r6 = CPU.addT(r0, 0x0);
                MEMORY.ref(2, r6 + 0x38).setu(r4);
                r1 = CPU.movT(0, 0x1);
                r5 = CPU.lslT(r1, 14);
                r0 = CPU.addT(r5, 0x0);
                r2 = CPU.movT(0, 0x34);
                r1 = MEMORY.ref(2, r6 + r2).get();
                r0 = FUN_80022ec(r0, r1);
                r3 = CPU.movT(0, 0x80);
                r3 = CPU.lslT(r3, 7);
                r0 = CPU.cmpT(r0, r3);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r5 = CPU.movT(0, 0x0);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                    r5 = CPU.addT(r0, 0x0);
                  }
                }

                //LAB_808c950
                r3 = CPU.lslT(r5, 16);
                MEMORY.ref(2, r6 + 0x14).setu(r5);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r4 = CPU.movT(0, 0x38);
                  r3 = MEMORY.ref(2, r6 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r1 = MEMORY.ref(4, 0x808c984).get();
                    MEMORY.ref(2, r6 + 0x14).setu(r1);
                  }
                }

                //LAB_808c964
                r2 = CPU.movT(0, 0x3a);
                r0 = MEMORY.ref(2, r6 + r2).get();
                r3 = CPU.movT(0, 0x36);
                r1 = MEMORY.ref(2, r6 + r3).get();
                r0 = CPU.lslT(r0, 14);
                r0 = FUN_80022ec(r0, r1);
                r3 = CPU.movT(0, 0x80);
                r3 = CPU.lslT(r3, 7);
                r0 = CPU.cmpT(r0, r3);
                if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
                  r3 = CPU.movT(0, 0x0);
                  CPU.cmpT(r0, 0x0);
                  if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
                    r3 = CPU.addT(r0, 0x0);
                  }
                }

                //LAB_808c988
                MEMORY.ref(2, r6 + 0x16).setu(r3);
                r3 = CPU.lslT(r3, 16);
                CPU.cmpT(r3, 0x0);
                if(CPU.cpsr().getZero()) { // ==
                  r4 = CPU.movT(0, 0x3a);
                  r3 = MEMORY.ref(2, r6 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    r1 = MEMORY.ref(4, 0x808c9c8).get();
                    MEMORY.ref(2, r6 + 0x16).setu(r1);
                  }
                }

                //LAB_808c99c
                r3 = CPU.movT(0, 0xe2);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                r2 = MEMORY.ref(2, r3).getUnsigned();
                r3 = CPU.movT(0, 0xe0);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                MEMORY.ref(2, r3).setu(r2);
                r3 = CPU.movT(0, 0xe3);
                r3 = CPU.lslT(r3, 1);
                r3 += CPU.r9().value;
                r3 = MEMORY.ref(2, r3).getUnsigned();
                r2 = MEMORY.ref(4, 0x808c9cc).get();
                MEMORY.ref(2, r2).setu(r3);
                FUN_808c4c0();
                r7 = MEMORY.ref(4, 0x808c9d0).get();
                break outer;
              }
            }

            //LAB_808c9fa
            r3 = MEMORY.ref(4, 0x808caac).get();
            r1 = CPU.r11().value;
            r3 += CPU.r8().value;
            MEMORY.ref(2, r3).setu(r1);
            r3 = CPU.movT(0, 0xc1);
            r3 = CPU.lslT(r3, 1);
            r3 += CPU.r8().value;
            r2 = CPU.r11().value;
            MEMORY.ref(2, r3).setu(r2);
          } else {
            //LAB_808ca0e
            r5 = CPU.movT(0, 0xbe);
            r5 = CPU.lslT(r5, 1);
            r5 += CPU.r8().value;
            r3 = CPU.movT(0, 0x0);
            r7 = MEMORY.ref(2, r5 + r3).get();
            CPU.cmpT(r7, 0x0);
            if(!CPU.cpsr().getZero()) { // !=
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r1);
              FUN_8091660();
              FUN_808ba38();
              r2 = MEMORY.ref(4, 0x808cab0).get();
              r3 = MEMORY.ref(4, 0x808cab4).get();
              r2 += CPU.r9().value;
              MEMORY.ref(2, r2).setu(r3);
              r2 = CPU.movT(0, 0xe0);
              r2 = CPU.lslT(r2, 1);
              r3 = CPU.movT(0, 0xff);
              r2 += CPU.r9().value;
              r3 = CPU.lslT(r3, 1);
              MEMORY.ref(2, r2).setu(r3);
              r4 = MEMORY.ref(4, 0x808cab8).get();
              r3 = MEMORY.ref(2, r5).getUnsigned();
              r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              MEMORY.ref(2, r4).setu(r3);
              r3 = MEMORY.ref(4, 0x808cabc).get();
              MEMORY.ref(2, r1).setu(r3);
              r1 = CPU.movT(0, 0x0);
              r0 = MEMORY.ref(2, r5 + r1).get();
              FUN_80941e0(r0);
              r3 = CPU.movT(0, 0xd4);
              r3 = CPU.lslT(r3, 1);
              r2 = MEMORY.ref(4, 0x808cac0).get();
              r3 += CPU.r8().value; // returned from last method call
              MEMORY.ref(4, r3).setu(r6);
              MEMORY.ref(2, r5).setu(r6);
              MEMORY.ref(4, r2).setu(r6);
            } else {
              //LAB_808ca5e
              r3 = CPU.movT(0, 0xb6);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r4 = CPU.movT(0, 0x0);
              r6 = MEMORY.ref(2, r3 + r4).get();
              CPU.cmpT(r6, 0x0);
              if(!CPU.cpsr().getZero()) { // !=
                r5 = MEMORY.ref(4, 0x808caac).get();
                r1 = MEMORY.ref(4, 0x808ca9c).get();
                r5 += CPU.r8().value;
                MEMORY.ref(2, r5).setu(r1);
                r2 = CPU.movT(0, 0x0);
                r0 = MEMORY.ref(2, r3 + r2).get();
                MEMORY.ref(4, CPU.sp().value).setu(r3);
                r0 = FUN_808d828(r0);
                r3 = MEMORY.ref(4, CPU.sp().value).get();
                MEMORY.ref(2, r5).setu(r7);
                MEMORY.ref(2, r3).setu(r7);
              } else {
                //LAB_808ca86
                r5 = CPU.movT(0, 0xb7);
                r5 = CPU.lslT(r5, 1);
                r5 += CPU.r8().value;
                r3 = CPU.movT(0, 0x0);
                r0 = MEMORY.ref(2, r5 + r3).get();
                CPU.cmpT(r0, 0x0);
                if(!CPU.cpsr().getZero()) { // !=
                  r0 = FUN_808d8f0(r0);
                  MEMORY.ref(2, r5).setu(r6);
                } else {
                  //LAB_808cac4
                  r3 = CPU.movT(0, 0xba);
                  r3 = CPU.lslT(r3, 1);
                  r3 += CPU.r8().value;
                  r4 = CPU.movT(0, 0x0);
                  r3 = MEMORY.ref(2, r3 + r4).get();
                  CPU.cmpT(r3, 0x0);
                  if(!CPU.cpsr().getZero()) { // !=
                    FUN_8015208();
                    r1 = MEMORY.ref(4, 0x808cb18).get();
                    r0 = MEMORY.ref(4, r1).get();
                    r0 = FUN_808ddec(r0, r1);
                    r2 = CPU.movT(0, 0x1);
                    r5 = CPU.addT(r0, 0x0);
                    r2 = CPU.negT(r2, r2);
                    r6 = CPU.movT(0, 0x0);
                    r5 = CPU.cmpT(r5, r2);
                    if(!CPU.cpsr().getZero()) { // !=
                      r0 = FUN_808d5a4(r0);
                      CPU.cmpT(r0, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r0 = CPU.movT(0, 0x1);
                      }

                      //LAB_808caf4
                      r6 = CPU.addT(r0, 0x0);
                    }

                    //LAB_808caf6
                    CPU.cmpT(r6, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      r3 = MEMORY.ref(4, 0x808cb14).get();
                      r5 = CPU.orrT(r5, r3);
                      r3 = CPU.movT(0, 0xbc);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      MEMORY.ref(2, r3).setu(r5);
                      r3 = CPU.movT(0, 0xb9);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      r4 = CPU.r11().value;
                      MEMORY.ref(2, r3).setu(r4);
                    } else {
                      //LAB_808cb1c
                      r0 = FUN_808ce74();
                      r6 = CPU.addT(r0, 0x0);
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        r3 = CPU.movT(0, 0xbd);
                        r3 = CPU.lslT(r3, 1);
                        r3 += CPU.r8().value;
                        MEMORY.ref(2, r3).setu(r6);
                        r3 = CPU.movT(0, 0xb9);
                        r3 = CPU.lslT(r3, 1);
                        r3 += CPU.r8().value;
                        r1 = CPU.r11().value;
                        MEMORY.ref(2, r3).setu(r1);
                      } else {
                        //LAB_808cb3a
                        r3 = CPU.movT(0, 0xb9);
                        r3 = CPU.lslT(r3, 1);
                        r2 = MEMORY.ref(4, 0x808cb48).get();
                        r3 += CPU.r8().value;
                        MEMORY.ref(2, r3).setu(r2);
                      }
                    }

                    //LAB_808cb44
                    r3 = CPU.movT(0, 0xba);
                    r3 = CPU.lslT(r3, 1);
                    r3 += CPU.r8().value;
                    r4 = CPU.r11().value;
                    MEMORY.ref(2, r3).setu(r4);
                  } else {
                    //LAB_808cb4c
                    r3 = CPU.movT(0, 0xb9);
                    r3 = CPU.lslT(r3, 1);
                    r3 += CPU.r8().value;
                    r1 = CPU.movT(0, 0x0);
                    r7 = MEMORY.ref(2, r3 + r1).get();
                    CPU.cmpT(r7, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      FUN_8015208();
                      FUN_8091660();
                      r0 = CPU.movT(0, 0x6f);
                      FUN_80f9010(r0);
                      FUN_808c44c();
                      r0 = CPU.movT(0, 0x83);
                      r0 = CPU.lslT(r0, 1);
                      FUN_80770c8(r0);

                      r1 = MEMORY.ref(4, 0x808cbdc).get();
                      if(MEMORY.ref(4, 0x808cbd8).deref(1).getUnsigned() == 0 || (MEMORY.ref(4, r1).get() & 0x2) == 0 || (MEMORY.ref(4, r1).get() & 0x4) == 0) {
                        //LAB_808cb98
                        r0 = MEMORY.ref(4, 0x808cbe0).get();
                        r0 = FUN_80770c0(r0);
                        CPU.cmpT(r0, 0x0);
                        if(!CPU.cpsr().getZero()) { // !=
                          r2 = CPU.movT(0, 0xc1);
                          r2 = CPU.lslT(r2, 1);
                          r2 += CPU.r8().value;
                          r3 = CPU.movT(0, 0xfa);
                          MEMORY.ref(2, r2).setu(r3);
                        } else {
                          //LAB_808cbae
                          r5 = CPU.movT(0, 0xcc);
                          r5 = CPU.lslT(r5, 4);
                          r5 += CPU.r8().value;
                          MEMORY.ref(2, r5).setu(r0);
                          r0 = FUN_80151e8();
                          r2 = MEMORY.ref(4, 0x808cbd4).get();
                          MEMORY.ref(2, r5).setu(r2);
                        }
                      } else {
                        r0 = FUN_8015290();
                      }

                      //LAB_808cbbe
                      FUN_808c4c0();
                      r0 = CPU.movT(0, 0x83);
                      r0 = CPU.lslT(r0, 1);
                      FUN_80770d0(r0);
                      FUN_80772f0();
                      r3 = CPU.movT(0, 0xb9);
                      r3 = CPU.lslT(r3, 1);
                      r3 += CPU.r8().value;
                      r4 = CPU.r11().value;
                      MEMORY.ref(2, r3).setu(r4);
                    } else {
                      //LAB_808cbe4
                      r5 = CPU.movT(0, 0xbc);
                      r5 = CPU.lslT(r5, 1);
                      r5 += CPU.r8().value;
                      r1 = CPU.movT(0, 0x0);
                      r6 = MEMORY.ref(2, r5 + r1).get();
                      CPU.cmpT(r6, 0x0);
                      if(!CPU.cpsr().getZero()) { // !=
                        FUN_808c44c();
                        r3 = MEMORY.ref(2, r5).getUnsigned();
                        r0 = MEMORY.ref(4, 0x808cc20).get();
                        r0 = CPU.andT(r0, r3);
                        r0 = FUN_808d5dc(r0);

                        //LAB_808cc42
                        FUN_808c4c0();
                        MEMORY.ref(2, r5).setu(r7);
                      } else {
                        //LAB_808cc02
                        r5 = CPU.movT(0, 0xbd);
                        r5 = CPU.lslT(r5, 1);
                        r5 += CPU.r8().value;
                        r2 = CPU.movT(0, 0x0);
                        r7 = MEMORY.ref(2, r5 + r2).get();
                        CPU.cmpT(r7, 0x0);
                        if(!CPU.cpsr().getZero()) { // !=
                          FUN_808c44c();
                          r3 = CPU.movT(0, 0x0);
                          r0 = MEMORY.ref(2, r5 + r3).get();
                          r0 = FUN_808d9a4(r0);

                          //LAB_808cc6e
                          FUN_808c4c0();
                          MEMORY.ref(2, r5).setu(r6);
                        } else {
                          //LAB_808cc24
                          r5 = CPU.movT(0, 0xbf);
                          r5 = CPU.lslT(r5, 1);
                          r5 += CPU.r8().value;
                          r4 = CPU.movT(0, 0x0);
                          r6 = MEMORY.ref(2, r5 + r4).get();
                          CPU.cmpT(r6, 0x0);
                          if(!CPU.cpsr().getZero()) { // !=
                            FUN_8015208();
                            FUN_808c44c();
                            r1 = CPU.movT(0, 0x0);
                            r0 = MEMORY.ref(2, r5 + r1).get();
                            r0 = FUN_808e680(r0);
                            FUN_808c4c0();
                            MEMORY.ref(2, r5).setu(r7);
                          } else {
                            //LAB_808cc4a
                            r5 = CPU.movT(0, 0xc0);
                            r5 = CPU.lslT(r5, 1);
                            r5 += CPU.r8().value;
                            r2 = CPU.movT(0, 0x0);
                            r3 = MEMORY.ref(2, r5 + r2).get();
                            CPU.cmpT(r3, 0x0);
                            if(!CPU.cpsr().getZero()) { // !=
                              FUN_808c44c();
                              r3 = CPU.movT(0, 0x0);
                              r0 = MEMORY.ref(2, r5 + r3).get();
                              r3 = CPU.movT(0, 0xcd);
                              r3 = CPU.lslT(r3, 1);
                              r3 += CPU.r8().value;
                              r4 = CPU.movT(0, 0x0);
                              r1 = MEMORY.ref(2, r3 + r4).get();
                              r0 = FUN_808e23c(r0, r1);
                              FUN_808c4c0();
                              MEMORY.ref(2, r5).setu(r6);
                            } else {
                              //LAB_808cc76
                              r3 = CPU.movT(0, 0xbb);
                              r3 = CPU.lslT(r3, 1);
                              r3 += CPU.r8().value;
                              r1 = CPU.movT(0, 0x0);
                              r3 = MEMORY.ref(2, r3 + r1).get();
                              CPU.cmpT(r3, 0x0);
                              if(!CPU.cpsr().getZero()) { // !=
                                r0 = CPU.movT(0, 0x6f);
                                FUN_80f9010(r0);
                                FUN_8091660();
                                FUN_808c44c();
                                r0 = CPU.movT(0, 0x83);
                                r0 = CPU.lslT(r0, 1);
                                FUN_80770c8(r0);
                                r1 = MEMORY.ref(4, 0x808cd40).get();
                                if(MEMORY.ref(1, r1).getUnsigned() != 0 && (MEMORY.ref(4, 0x808cd44).deref(4).get() & 0x2) != 0) {
                                  r0 = FUN_8015288();
                                } else {
                                  //LAB_808ccb4
                                  if(MEMORY.ref(1, r1).getUnsigned() != 0 && (MEMORY.ref(4, 0x808cd44).deref(4).get() & 0x200) != 0) {
                                    FUN_808d0c8();
                                  } else {
                                    //LAB_808ccce
                                    r0 = MEMORY.ref(4, 0x808cd48).get();
                                    r0 = FUN_80770c0(r0);
                                    CPU.cmpT(r0, 0x0);
                                    if(!CPU.cpsr().getZero()) { // !=
                                      r2 = CPU.movT(0, 0xc1);
                                      r2 = CPU.lslT(r2, 1);
                                      r2 += CPU.r8().value;
                                      r3 = CPU.movT(0, 0xfa);
                                      MEMORY.ref(2, r2).setu(r3);
                                    } else {
                                      //LAB_808cce4
                                      FUN_808e118();
                                      FUN_8015208();
                                      r0 = FUN_80f9070();
                                      r3 = MEMORY.ref(4, 0x808cd4c).get();
                                      r3 += CPU.r9().value;
                                      MEMORY.ref(2, r3).setu(r0);
                                      r0 = CPU.movT(0, 0xbf);
                                      r0 = CPU.lslT(r0, 1);
                                      r0 = FUN_80770c0(r0);
                                      CPU.cmpT(r0, 0x0);
                                      if(CPU.cpsr().getZero()) { // ==
                                        r3 = MEMORY.ref(4, 0x808cd50).get();
                                        r2 = CPU.movT(0, 0x80);
                                        r5 = MEMORY.ref(4, r3).get();
                                        r1 = MEMORY.ref(4, 0x808cd54).get();
                                        r0 = CPU.movT(0, 0x0);
                                        r2 = CPU.lslT(r2, 2);

                                        //LAB_808cd0e
                                        do {
                                          r3 = MEMORY.ref(1, r1).getUnsigned();
                                          r1 = CPU.addT(r1, 0x1);
                                          CPU.cmpT(r3, 0xff);
                                          if(CPU.cpsr().getZero()) { // ==
                                            r0 = CPU.addT(r0, 0x1);
                                          }

                                          //LAB_808cd18
                                          r2 = CPU.subT(r2, 0x1);
                                          CPU.cmpT(r2, 0x0);
                                        } while(!CPU.cpsr().getZero()); // !=

                                        r3 = CPU.addT(r0, 0x0);
                                        r3 = CPU.subT(r3, 0x88);
                                        CPU.cmpT(r3, 0x0);
                                        if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                                          r2 = MEMORY.ref(4, 0x808cd3c).get();
                                          r0 = CPU.movT(0, 0x1);
                                          MEMORY.ref(2, r5 + 0x4).setu(r2);
                                          FUN_80030f8(r0);
                                        }

                                        //LAB_808cd30
                                        r0 = CPU.movT(0, 0x0);
                                        r0 = FUN_8015370(r0);
                                        r3 = CPU.r11().value;
                                        MEMORY.ref(2, r5 + 0x4).setu(r3);
                                      } else {
                                        //LAB_808cd58
                                        r0 = MEMORY.ref(4, 0x808ce60).get();
                                        r1 = CPU.movT(0, 0x1);
                                        FUN_8015040(r0, r1);
                                      }
                                    }
                                  }
                                }

                                //LAB_808cd60
                                FUN_808c4c0();
                                r0 = CPU.movT(0, 0x83);
                                r0 = CPU.lslT(r0, 1);
                                FUN_80770d0(r0);
                                r3 = CPU.movT(0, 0xbb);
                                r3 = CPU.lslT(r3, 1);
                                r3 += CPU.r8().value;
                                r4 = CPU.r11().value;
                                MEMORY.ref(2, r3).setu(r4);
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

          //LAB_808cd76
        }

        //LAB_808cd80
        r0 = CPU.movT(0, 0x82);
        r0 = CPU.lslT(r0, 1);
        FUN_80770d0(r0);
        r1 = MEMORY.ref(4, 0x808ce64).get();
        r3 = MEMORY.ref(4, r1).get();
        r3 = CPU.lslT(r3, 2);
        r3 = CPU.addT(r3, 0x14);
        r4 = CPU.r8().value;
        r3 = MEMORY.ref(4, r4 + r3).get();
        r2 = MEMORY.ref(4, 0x808ce68).get();
        CPU.r10().value = r3;
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r1 = CPU.movT(0, 0xf9);
          r1 = CPU.lslT(r1, 1);
          r3 = CPU.addT(r2, r1);
          r3 = MEMORY.ref(1, r3).getUnsigned();
          CPU.cmpT(r3, 0x2);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.r10().value;
            FUN_80090b8(r0);
          } else {
            //LAB_808cdb0
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getZero()) { // ==
              r0 = CPU.r10().value;
              FUN_80090b0(r0);
            } else {
              //LAB_808cdbc
              r3 = CPU.movT(0, 0xcf);
              r3 = CPU.lslT(r3, 1);
              r3 += CPU.r8().value;
              r2 = CPU.movT(0, 0x0);
              r3 = MEMORY.ref(2, r3 + r2).get();
              CPU.cmpT(r3, 0x3);
              if(CPU.cpsr().getZero()) { // ==
                r0 = CPU.r10().value;
                FUN_80090a8(r0);
              } else {
                //LAB_808cdd2
                r0 = CPU.r10().value;
                FUN_80090a0(r0);
              }
            }
          }
        }

        //LAB_808cdd8
        r5 = MEMORY.ref(4, 0x808ce64).get();

        //LAB_808cdda
        do {
          FUN_80030f8(1);
          r3 = MEMORY.ref(4, r5).get();
          r3 = CPU.lslT(r3, 2);
          r3 = CPU.addT(r3, 0x14);
          r4 = CPU.r8().value;
          r3 = MEMORY.ref(4, r4 + r3).get();
          CPU.r10().value = r3;
          r3 = MEMORY.ref(4, 0x808ce6c).get();
          r3 = MEMORY.ref(1, r3).getUnsigned();
          if(r3 == 0 || FUN_80770c0(0x163) == 0) {
            //LAB_808cdfe
            r3 = CPU.r10().value;
            r3 = CPU.addT(r3, 0x22);
            r2 = CPU.r10().value;
            r4 = CPU.r10().value;
            r0 = MEMORY.ref(1, r3).getUnsigned();
            r1 = MEMORY.ref(4, r2 + 0x8).get();
            r3 = MEMORY.ref(4, r4 + 0x10).get();
            r2 = MEMORY.ref(4, r2 + 0xc).get();
            FUN_808bec0(r0, r1, r2, r3);
          }

          //LAB_808ce12
          r0 = FUN_808bc9c();
          CPU.cmpT(r0, 0x0);
        } while(CPU.cpsr().getZero()); // ==
      } while(true);
    }

    //LAB_808ce1c
    r6 = CPU.movT(0, 0xe3);
    r6 = CPU.lslT(r6, 1);
    r6 += CPU.r8().value;
    r3 = MEMORY.ref(2, r6).getUnsigned();
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r3 = CPU.movT(0, 0xe0);
      r5 = CPU.movT(0, 0xe4);
      r3 = CPU.lslT(r3, 1);
      r5 = CPU.lslT(r5, 1);
      r3 += CPU.r8().value;
      r5 += CPU.r8().value;
      r0 = MEMORY.ref(4, r3).get();
      r1 = MEMORY.ref(4, r5).get();
      FUN_80901c0(r0, r1);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r6).setu(r3);
      r0 = MEMORY.ref(4, r5).get();
      FUN_80030f8(r0);
    }

    //LAB_808ce46
    r0 = CPU.movT(0, 0x1b);
    FUN_8002dd8(r0);
    r0 = CPU.addT(r7, 0x0);
    CPU.sp().value += 0x10;
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

  @Method(0x808ce74)
  public static int FUN_808ce74() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808cf78)
  public static void FUN_808cf78() {
    int r0;
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

    r3 = MEMORY.ref(4, 0x808d0b0).get();
    r0 = CPU.movT(0, 0xe1);
    r7 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, 0x808d0b4).get();
    r0 = CPU.lslT(r0, 1);
    r3 = CPU.addT(r3, r0);
    r2 = CPU.movT(0, 0x0);
    r1 = MEMORY.ref(2, r3 + r2).get();
    r3 = MEMORY.ref(4, 0x808d0b8).get();
    r0 = MEMORY.ref(4, r3 + 0xc).get();
    CPU.r8().value = r1;
    r0 = (int)MEMORY.call(r0);
    r6 = CPU.movT(0, 0x1);
    r3 = CPU.movT(0, 0x0);
    r5 = r0;
    CPU.r10().value = r3;
    r6 = CPU.negT(r6, r6);

    // Subtract 0x18 so we don't have to jump over the initial increment
    r5 -= 0x18;
    // LAB_808cfa8;

    //LAB_808cfa6
    jmp_808cfc8:
    {
      do {
        do {
          r5 += 0x18;

          //LAB_808cfa8
          r4 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r5 + r4).get();
          r3 = CPU.cmpT(r3, r6);
          if(CPU.cpsr().getZero()) { // ==
            break jmp_808cfc8;
          }
          CPU.cmpT(r3, CPU.r8().value);
        } while(!CPU.cpsr().getZero()); // !=

        r1 = CPU.movT(0, 0x2);
        r0 = MEMORY.ref(2, r5 + r1).get();
        r0 = CPU.cmpT(r0, r6);
        if(CPU.cpsr().getZero()) { // ==
          break;
        }
        r0 = FUN_80770c0(r0);
        CPU.cmpT(r0, 0x0);
      } while(CPU.cpsr().getZero()); // ==

      //LAB_808cfc4
      r2 = CPU.movT(0, 0x1);
      CPU.r10().value = r2;
    }

    //LAB_808cfc8
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r3 = MEMORY.ref(4, 0x808d0b8).get();
      r0 = MEMORY.ref(4, r3 + 0xc).get();
      r0 = (int)MEMORY.call(r0);
      r5 = CPU.addT(r0, 0x0);
    }

    //LAB_808cfd8
    r0 = MEMORY.ref(4, 0x808d0bc).get();
    r0 = FUN_80770c0(r0);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      r1 = MEMORY.ref(4, 0x808d0b4).get();
      r4 = CPU.movT(0, 0xee);
      r4 = CPU.lslT(r4, 1);
      r2 = CPU.addT(r1, r4);
      r4 = CPU.movT(0, 0x4);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf0);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0x6);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf2);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0x8);
      r3 = MEMORY.ref(2, r5 + r4).get();
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.movT(0, 0xf4);
      r3 = CPU.lslT(r3, 1);
      r2 = CPU.addT(r1, r3);
      r4 = CPU.movT(0, 0xf6);
      r3 = MEMORY.ref(2, r5 + 0xa).getUnsigned();
      r4 = CPU.lslT(r4, 1);
      MEMORY.ref(4, r2).setu(r3);
      r3 = CPU.addT(r1, r4);
      MEMORY.ref(2, r3).setu(r0);
    }

    //LAB_808d020
    r1 = CPU.movT(0, 0x1);
    r0 = CPU.movT(0, 0xe);
    r3 = MEMORY.ref(2, r5 + r0).get();
    r1 = CPU.negT(r1, r1);
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r6 = CPU.addT(r7, 0x0);
      r6 = CPU.addT(r6, 0xec);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r6).setu(r3);
    } else {
      //LAB_808d036
      r6 = CPU.addT(r7, 0x0);
      r6 = CPU.addT(r6, 0xec);
    }

    //LAB_808d03a
    r2 = CPU.movT(0, 0x10);
    r3 = MEMORY.ref(2, r5 + r2).get();
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = CPU.addT(r7, 0x0);
      r4 = CPU.addT(r4, 0xf0);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r4).setu(r3);
    } else {
      //LAB_808d04c
      r4 = CPU.addT(r7, 0x0);
      r4 = CPU.addT(r4, 0xf0);
    }

    //LAB_808d050
    r0 = CPU.movT(0, 0x12);
    r3 = MEMORY.ref(2, r5 + r0).get();
    r3 = CPU.cmpT(r3, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r2 = CPU.addT(r7, 0x0);
      r2 = CPU.addT(r2, 0xf4);
      r3 = CPU.lslT(r3, 16);
      MEMORY.ref(4, r2).setu(r3);
    } else {
      //LAB_808d062
      r2 = CPU.addT(r7, 0x0);
      r2 = CPU.addT(r2, 0xf4);
    }

    //LAB_808d066
    r3 = CPU.movT(0, 0x14);
    r0 = MEMORY.ref(2, r5 + r3).get();
    r0 = CPU.cmpT(r0, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r1 = CPU.addT(r7, 0x0);
      r1 = CPU.addT(r1, 0xf8);
      r3 = CPU.lslT(r0, 16);
      MEMORY.ref(4, r1).setu(r3);
    } else {
      //LAB_808d078
      r1 = CPU.addT(r7, 0x0);
      r1 = CPU.addT(r1, 0xf8);
    }

    //LAB_808d07c
    r3 = MEMORY.ref(4, r6).get();
    r0 = CPU.movT(0, 0xf0);
    r0 = CPU.lslT(r0, 16);
    r2 = MEMORY.ref(4, r2).get();
    r3 = CPU.addT(r3, r0);
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = MEMORY.ref(4, 0x808d0c0).get();
      r3 = CPU.addT(r2, r0);
      MEMORY.ref(4, r6).setu(r3);
    }

    //LAB_808d090
    r3 = MEMORY.ref(4, r4).get();
    r2 = CPU.movT(0, 0xa0);
    r2 = CPU.lslT(r2, 16);
    r3 = CPU.addT(r3, r2);
    r2 = MEMORY.ref(4, r1).get();
    r3 = CPU.cmpT(r3, r2);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r0 = MEMORY.ref(4, 0x808d0c4).get();
      r3 = CPU.addT(r2, r0);
      MEMORY.ref(4, r4).setu(r3);
    }

    //LAB_808d0a4
    r3 = CPU.pop();
    r5 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r10().value = r5;
  }

  @Method(0x808d0c8)
  public static void FUN_808d0c8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d394)
  public static int FUN_808d394(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d428)
  public static int FUN_808d428(int r0) {
    int r3;

    r3 = CPU.movT(0, 0x1);
    r3 = CPU.negT(r3, r3);
    r0 = CPU.cmpT(r0, r3);
    if(CPU.cpsr().getZero()) { // ==
      return CPU.movT(0, 0x1);
    }

    //LAB_808d436
    r3 = CPU.movT(0, 0x80);
    r3 = CPU.lslT(r3, 5);
    r3 = CPU.andT(r3, r0);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      return FUN_80770c0(r0);
    }

    //LAB_808d446
    r0 = FUN_80770c0(r0);
    r3 = CPU.negT(r3, r0);
    r3 = CPU.orrT(r3, r0);
    r3 = CPU.lsrT(r3, 31);
    r0 = CPU.movT(0, 0x1);
    r0 = CPU.subT(r0, r3);

    //LAB_808d454
    return r0;
  }

  @Method(0x808d5a4)
  public static int FUN_808d5a4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d5dc)
  public static int FUN_808d5dc(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d7d8)
  public static int FUN_808d7d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d828)
  public static int FUN_808d828(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d8f0)
  public static int FUN_808d8f0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808d9a4)
  public static int FUN_808d9a4(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808ddec)
  public static int FUN_808ddec(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e118)
  public static void FUN_808e118() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e23c)
  public static int FUN_808e23c(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e680)
  public static int FUN_808e680(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x808e9a8)
  public static void FUN_808e9a8(final int r0) {
    final int ret = FUN_80091a8(0, MEMORY.ref(4, r0 + 0x8).get(), MEMORY.ref(4, r0 + 0x10).get());
    MEMORY.ref(4, r0 + 0xc).setu(ret);
    MEMORY.ref(4, r0 + 0x14).setu(ret);
  }

  @Method(0x808e9c0)
  public static void FUN_808e9c0() {
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

    r3 = MEMORY.ref(4, 0x808ebf4).get();
    CPU.sp().value -= 0xc;
    r1 = CPU.movT(0, 0x0);
    r2 = MEMORY.ref(4, r3).get();
    r3 = MEMORY.ref(4, r3 + 0x4c).get();
    MEMORY.ref(4, CPU.sp().value).setu(r1);
    r2 = MEMORY.ref(4, r2 + 0x10).get();
    CPU.r10().value = r2;
    r2 = CPU.movT(0, 0x8e);
    r2 = CPU.lslT(r2, 1);
    r2 = CPU.addT(r2, r3);
    CPU.r8().value = r2;
    r0 = CPU.sp().value + 0x8;
    MEMORY.ref(4, r0).setu(r1);
    r3 = MEMORY.ref(4, 0x808ebf8).get();
    r1 = CPU.r8().value;
    r2 = MEMORY.ref(4, 0x808ebfc).get();
    MEMORY.ref(4, r3).setu(r0);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r1);
    r3 += 0x4;
    MEMORY.ref(4, r3).setu(r2);
    r3 += 0x4;

    r3 = CPU.subT(r3, 0xc);
    r3 = CPU.r10().value;
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      //LAB_808e9fc
      r4 = CPU.movT(0, 0x1);
      CPU.r10().value += r4;
      r7 = MEMORY.ref(1, r3).getUnsigned();
      r1 = CPU.r10().value;
      r5 = MEMORY.ref(1, r1).getUnsigned();
      CPU.r10().value += r4;
      if(r7 != 0xff || r5 != 0xff) {
        //LAB_808ea12
        jmp_808ebe2:
        do {
          r2 = CPU.r10().value;
          r2 = MEMORY.ref(1, r2).getUnsigned();
          r3 = CPU.movT(0, 0x1);
          CPU.r10().value += r3;
          r3 = CPU.addT(r2, 0x0);
          r3 = CPU.subT(r3, 0x64);
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r2);
          CPU.cmpT(r3, 0x8b);
          if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
            //LAB_808ea26
            r3 = MEMORY.ref(4, 0x808ec00).get();
            r0 = MEMORY.ref(4, r3 + 0x24).get();
            r0 = (int)MEMORY.call(r0);
            r6 = CPU.addT(r0, 0x0);
            r4 = CPU.movT(0, 0x1);
            r2 = MEMORY.ref(4, r6).get();
            r4 = CPU.negT(r4, r4);
            r2 = CPU.cmpT(r2, r4);
            if(!CPU.cpsr().getZero()) { // !=
              //LAB_808ea3c
              r1 = CPU.movT(0, 0x80);
              r7 = CPU.lslT(r7, 20);
              r1 = CPU.lslT(r1, 12);
              CPU.r11().value = r7;
              CPU.r9().value = r1;
              r7 = CPU.lslT(r5, 20);

              //LAB_808ea48
              do {
                r4 = CPU.movT(0, 0x4);
                r3 = MEMORY.ref(2, r6 + r4).get();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
                r3 = CPU.cmpT(r3, r1);
                jmp_808ebb8:
                if(CPU.cpsr().getZero()) { // ==
                  //LAB_808ea54
                  r3 = MEMORY.ref(4, 0x808ec04).get();
                  r3 = CPU.andT(r3, r2);
                  CPU.cmpT(r3, 0x13);
                  if(!CPU.cpsr().getZero()) { // !=
                    //LAB_808eb02
                    CPU.cmpT(r3, 0x3);
                    if(CPU.cpsr().getZero()) { // ==
                      r3 = MEMORY.ref(4, 0x808ec08).get();
                      r2 = MEMORY.ref(4, r6 + 0x8).get();
                      r2 = CPU.andT(r2, r3);
                      r3 = CPU.movT(0, 0xc0);
                      r3 = CPU.lslT(r3, 14);
                      r2 = CPU.cmpT(r2, r3);
                      if(CPU.cpsr().getZero()) { // ==
                        r4 = CPU.movT(0, 0x6);
                        r0 = MEMORY.ref(2, r6 + r4).get();
                        r0 = FUN_80770c0(r0);
                        CPU.cmpT(r0, 0x0);
                        if(CPU.cpsr().getZero()) { // ==
                          r4 = CPU.r9().value;
                          r1 = CPU.r11().value;
                          r0 = CPU.movT(0, 0x1c);
                          r1 += CPU.r9().value;
                          r2 = CPU.movT(0, 0x0);
                          r3 = CPU.addT(r7, r4);
                          r0 = FUN_80090c8(r0, r1, r2, r3);
                          r5 = CPU.addT(r0, 0x0);
                          CPU.cmpT(r5, 0x0);
                          if(!CPU.cpsr().getZero()) { // !=
                            FUN_808e9a8(r0);
                            r1 = CPU.movT(0, 0x0);
                            r0 = CPU.addT(r5, 0x0);
                            FUN_80091e0(r0, r1);
                            r0 = CPU.addT(r5, 0x0);
                            FUN_8009140(r0);
                            r0 = CPU.addT(r5, 0x0);
                            r1 = CPU.movT(0, 0x1);
                            FUN_8009080(r0, r1);
                            r2 = MEMORY.ref(4, r5 + 0x8).get();
                            CPU.cmpT(r2, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r1 = MEMORY.ref(4, 0x808ec0c).get();
                              r2 = CPU.addT(r2, r1);
                            }

                            //LAB_808eb5a
                            r3 = CPU.addT(r5, 0x0);
                            r3 = CPU.addT(r3, 0x64);
                            r2 = CPU.asrT(r2, 16);
                            MEMORY.ref(2, r3).setu(r2);
                            r3 = MEMORY.ref(4, r5 + 0x10).get();
                            CPU.cmpT(r3, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r2 = MEMORY.ref(4, 0x808ec0c).get();
                              r3 = CPU.addT(r3, r2);
                            }

                            //LAB_808eb6c
                            r2 = CPU.addT(r5, 0x0);
                            r3 = CPU.asrT(r3, 16);
                            r2 = CPU.addT(r2, 0x66);
                            MEMORY.ref(2, r2).setu(r3);
                            r3 = CPU.movT(0, 0x1);
                            r2 = CPU.subT(r2, 0xd);
                            MEMORY.ref(1, r2).setu(r3);
                            r2 = CPU.subT(r2, 0x36);
                            MEMORY.ref(1, r2).setu(r3);
                            r3 = CPU.r8().value;
                            MEMORY.ref(4, r3).setu(r5);
                            r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
                            r4 = CPU.r8().value;
                            MEMORY.ref(1, r4 + 0x4).setu(r3);
                            r3 = MEMORY.ref(4, r5 + 0x8).get();
                            CPU.cmpT(r3, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r1 = MEMORY.ref(4, 0x808ec10).get();
                              r3 = CPU.addT(r3, r1);
                            }

                            //LAB_808eb92
                            r0 = MEMORY.ref(4, r5 + 0x10).get();
                            r3 = CPU.asrT(r3, 20);
                            r2 = CPU.r8().value;
                            MEMORY.ref(1, r2 + 0x6).setu(r3);
                            CPU.cmpT(r0, 0x0);
                            if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                              r3 = MEMORY.ref(4, 0x808ec10).get();
                              r0 = CPU.addT(r0, r3);
                            }

                            //LAB_808eba2
                            r4 = CPU.r8().value;
                            r3 = CPU.asrT(r0, 20);
                            MEMORY.ref(1, r4 + 0x7).setu(r3);
                            r2 = MEMORY.ref(4, CPU.sp().value).get();
                            r1 = CPU.movT(0, 0x8);
                            r2 = CPU.addT(r2, 0x1);
                            CPU.r8().value += r1;
                            MEMORY.ref(4, CPU.sp().value).setu(r2);
                            CPU.cmpT(r2, 0x9);
                            if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                              break;
                            }
                            break jmp_808ebe2;
                          }
                        }
                      }
                    }
                  } else {
                    r4 = CPU.r9().value;
                    r1 = CPU.r11().value;
                    r0 = CPU.movT(0, 0x14);
                    r1 += CPU.r9().value;
                    r2 = CPU.movT(0, 0x0);
                    r3 = CPU.addT(r7, r4);
                    r0 = FUN_80090c8(r0, r1, r2, r3);
                    r5 = CPU.addT(r0, 0x0);
                    CPU.cmpT(r5, 0x0);
                    if(!CPU.cpsr().getZero()) { // !=
                      //LAB_808ea74
                      FUN_808e9a8(r0);
                      r0 = CPU.addT(r5, 0x0);
                      r1 = CPU.movT(0, 0x0);
                      FUN_80091e0(r0, r1);
                      r1 = CPU.movT(0, 0x6);
                      r0 = MEMORY.ref(2, r6 + r1).get();
                      r0 = FUN_80770c0(r0);
                      if(r0 != 0) {
                        if((MEMORY.ref(4, r6 + 0x8).get() & 0xfff00000) == 0x500000) {
                          r0 = FUN_80090d0(r5, r1, r2);
                          break jmp_808ebb8;
                        }

                        //LAB_808eaa2
                        r0 = CPU.addT(r5, 0x0);
                        r1 = CPU.movT(0, 0x2);
                        FUN_8009080(r0, r1);
                      }

                      //LAB_808eaaa
                      r0 = CPU.addT(r5, 0x0);
                      FUN_8009140(r0);
                      r2 = MEMORY.ref(4, r5 + 0x8).get();
                      CPU.cmpT(r2, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r4 = MEMORY.ref(4, 0x808ec0c).get();
                        r2 = CPU.addT(r2, r4);
                      }

                      //LAB_808eaba
                      r3 = CPU.addT(r5, 0x0);
                      r3 = CPU.addT(r3, 0x64);
                      r2 = CPU.asrT(r2, 16);
                      MEMORY.ref(2, r3).setu(r2);
                      r3 = MEMORY.ref(4, r5 + 0x10).get();
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r1 = MEMORY.ref(4, 0x808ec0c).get();
                        r3 = CPU.addT(r3, r1);
                      }

                      //LAB_808eacc
                      r2 = CPU.addT(r5, 0x0);
                      r3 = CPU.asrT(r3, 16);
                      r2 = CPU.addT(r2, 0x66);
                      MEMORY.ref(2, r2).setu(r3);
                      r3 = CPU.movT(0, 0x1);
                      r2 = CPU.subT(r2, 0x43);
                      MEMORY.ref(1, r2).setu(r3);
                      r2 = CPU.addT(r2, 0x36);
                      MEMORY.ref(1, r2).setu(r3);
                      r3 = MEMORY.ref(2, r6 + 0x4).getUnsigned();
                      r2 = CPU.r8().value;
                      MEMORY.ref(1, r2 + 0x4).setu(r3);
                      r3 = MEMORY.ref(4, r5 + 0x8).get();
                      MEMORY.ref(4, r2).setu(r5);
                      CPU.cmpT(r3, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r4 = MEMORY.ref(4, 0x808ec10).get();
                        r3 = CPU.addT(r3, r4);
                      }

                      //LAB_808eaf0
                      r0 = MEMORY.ref(4, r5 + 0x10).get();
                      r3 = CPU.asrT(r3, 20);
                      r1 = CPU.r8().value;
                      MEMORY.ref(1, r1 + 0x6).setu(r3);
                      CPU.cmpT(r0, 0x0);
                      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
                        r2 = MEMORY.ref(4, 0x808ec10).get();
                        r0 = CPU.addT(r0, r2);
                      }
                      r4 = CPU.r8().value;
                      r3 = CPU.asrT(r0, 20);
                      MEMORY.ref(1, r4 + 0x7).setu(r3);
                      r2 = MEMORY.ref(4, CPU.sp().value).get();
                      r1 = CPU.movT(0, 0x8);
                      r2 = CPU.addT(r2, 0x1);
                      CPU.r8().value += r1;
                      MEMORY.ref(4, CPU.sp().value).setu(r2);
                      CPU.cmpT(r2, 0x9);
                      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
                        break;
                      }
                      break jmp_808ebe2;
                    }
                  }
                }

                //LAB_808ebb8
                r6 = CPU.addT(r6, 0xc);
                r3 = MEMORY.ref(4, r6).get();
                r4 = CPU.movT(0, 0x1);
                r4 = CPU.negT(r4, r4);
                r2 = CPU.addT(r3, 0x0);
                r3 = CPU.cmpT(r3, r4);
                if(CPU.cpsr().getZero()) { // ==
                  break;
                }
              } while(true);
            }
          }

          //LAB_808ebc8
          r1 = CPU.r10().value;
          r2 = CPU.movT(0, 0x1);
          CPU.r10().value += r2;
          r7 = MEMORY.ref(1, r1).getUnsigned();
          r3 = CPU.r10().value;
          r5 = MEMORY.ref(1, r3).getUnsigned();
          CPU.r10().value += r2;
          CPU.cmpT(r7, 0xff);
          if(CPU.cpsr().getZero()) { // ==
            //LAB_808ebdc
            CPU.cmpT(r5, 0xff);
            if(CPU.cpsr().getZero()) { // ==
              break;
            }
          }
        } while(true);
      }
    }

    //LAB_808ebe2
    CPU.sp().value += 0xc;
    r3 = CPU.pop();
    r5 = CPU.pop();
    r6 = CPU.pop();
    r7 = CPU.pop();

    CPU.r8().value = r3;
    CPU.r9().value = r5;
    CPU.r10().value = r6;
    CPU.r11().value = r7;
  }

  @Method(0x808fefc)
  public static void FUN_808fefc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80901c0)
  public static void FUN_80901c0(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8090a5c)
  public static void FUN_8090a5c(final int r0, final int r1, final int r2, final int r3) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091174)
  public static void FUN_8091174() {
    final int r4 = FUN_80048f4(0x20, 0x2a04);

    CPU.sp().value -= 0x4;
    final int r0 = CPU.sp().value;
    MEMORY.ref(4, r0).setu(0);
    DMA.channels[3].SAD.setu(r0);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x85000a81);
    CPU.sp().value += 0x4;

    DMA.channels[3].SAD.setu(0x5000000);
    DMA.channels[3].DAD.setu(r4);
    DMA.channels[3].CNT.setu(0x84000070);

    DMA.channels[3].SAD.setu(0x5000200);
    DMA.channels[3].DAD.setu(r4 + 0x1c0);
    DMA.channels[3].CNT.setu(0x84000070);

    FUN_8090a5c(0x10000, r4, r4 + 0xe00, 0);
    FUN_80041d8(0x80908e1, 0xc8f);
  }

  @Method(0x8091200)
  public static void FUN_8091200(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091660)
  public static void FUN_8091660() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80919d8)
  public static int FUN_80919d8(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8091a58)
  public static int FUN_8091a58(final int a0, final int a1) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8092054)
  public static int FUN_8092054(final int r0) {
    return FUN_808ba1c(r0);
  }

  @Method(0x8093a6c)
  public static void FUN_8093a6c(final int r0, int r1) {
    switch(r1 - 1) {
      case 0 -> r1 = 0x809fe00;
      case 1 -> r1 = 0x809fd44;
      case 2 -> r1 = 0x809fe10;
      case 3 -> r1 = 0x809fecc;
      case 4 -> r1 = 0x809ff18;
      case 5 -> {
        MEMORY.ref(4, r0 + 0x68).setu(FUN_8092054(MEMORY.ref(4, 0x2000434).get()));
        r1 = 0x809ff2c;
      }
    }

    //LAB_8093ac6
    FUN_8009098(r0, r1);
  }

  /** NOTE returns r8 */
  @Method(0x80941e0)
  public static void FUN_80941e0(final int r0) {

  }

  @Method(0x8094428)
  public static int FUN_8094428() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80955b0)
  public static void FUN_80955b0(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095680)
  public static void FUN_8095680() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8095778)
  public static void FUN_8095778(int r0) {
    int r1;
    int r2;
    int r3;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r8().value);

    CPU.r8().value = r0;
    r1 = MEMORY.ref(4, 0x809586c).get();
    r0 = CPU.movT(0, 0x8d);
    r0 = CPU.lslT(r0, 2);
    r7 = CPU.addT(r1, r0);
    r3 = CPU.movT(0, 0x0);
    r5 = MEMORY.ref(2, r7 + r3).get();
    r2 = MEMORY.ref(2, r7).getUnsigned();
    r3 = CPU.movT(0, 0xf0);
    r6 = MEMORY.ref(4, 0x8095870).get();
    r3 = CPU.lslT(r3, 8);
    r0 = CPU.r8().value;
    r5 = CPU.andT(r5, r3);
    r6 = CPU.andT(r6, r2);
    CPU.cmpT(r0, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, 0x8095874).get();
        r2 = MEMORY.ref(4, 0x8095878).get();
        r6 = CPU.andT(r6, r3);
        r3 = CPU.addT(r6, r2);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r0 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r0);
          r1 = CPU.movT(0, 0x0);
          r2 = MEMORY.ref(2, r3 + r1).get();
          if(r2 <= 0 || r2 == MEMORY.ref(4, 0x8095880).get()) {
            //LAB_80957c0
            r0 = CPU.addT(r6, 0x0);
            r0 = CPU.subT(r0, 0xac);
            FUN_80770c8(r0);
            MEMORY.ref(2, r7).setu(r5);
          }
        }
      } else {
        //LAB_80957cc
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 5);
        r5 = CPU.cmpT(r5, r0);
        if(CPU.cpsr().getZero()) { // ==
          r2 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x1);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.addT(r6, 0x0);
            FUN_80770c8(r0);
          }

          //LAB_80957e6
          r1 = CPU.r8().value;
          MEMORY.ref(2, r7).setu(r1);
        }
      }
    } else {
      //LAB_80957ec
      CPU.cmpT(r5, 0x0);
      if(CPU.cpsr().getZero()) { // ==
        r2 = MEMORY.ref(4, 0x8095874).get();
        r0 = MEMORY.ref(4, 0x8095878).get();
        r6 = CPU.andT(r6, r2);
        r3 = CPU.addT(r6, r0);
        CPU.cmpT(r3, 0x50);
        if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
          r6 = CPU.andT(r6, r2);
          r2 = MEMORY.ref(4, 0x809587c).get();
          r3 = CPU.addT(r1, r2);
          r0 = CPU.movT(0, 0x0);
          r3 = MEMORY.ref(2, r3 + r0).get();
          CPU.cmpT(r3, 0x0);
          if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
            r1 = MEMORY.ref(4, 0x8095878).get();
            r5 = CPU.addT(r6, r1);
            r0 = CPU.addT(r5, 0x0);
            r1 = CPU.movT(0, 0x14);
            r0 = FUN_80022ec(r0, r1);
            r1 = CPU.movT(0, 0x14);
            CPU.r8().value = r0;
            r0 = CPU.addT(r5, 0x0);
            r0 = FUN_80022fc(r0, r1);
            r5 = CPU.movT(0, 0x7);
            r7 = CPU.addT(r0, 0x0);

            //LAB_8095826
            jmp_8095854:
            {
              do {
                do {
                  r5++;

                  //LAB_8095828
                  if(r5 > 0x41) {
                    break jmp_8095854;
                  }
                  r0 = FUN_808d394(r5);
                } while(r0 == 0);

                r2 = CPU.movT(0, 0x2);
                r3 = MEMORY.ref(2, r0 + r2).get();
                r0 = MEMORY.ref(4, 0x8095878).get();
                r3 = CPU.subT(r3, 0x30);
                r2 = CPU.addT(r6, r0);
                r3 = CPU.cmpT(r3, r2);
              } while(!CPU.cpsr().getZero()); // !=

              r0 = CPU.movT(0, 0x28);
              FUN_80030f8(r0);
              r1 = CPU.r8().value;
              r0 = CPU.addT(r5, 0x0);
              r2 = CPU.addT(r7, 0x0);
              FUN_80955b0(r0, r1, r2);
            }

            //LAB_8095854
            r1 = MEMORY.ref(4, 0x809586c).get();
          }
        }
      }

      //LAB_8095856
      r3 = CPU.movT(0, 0x8d);
      r3 = CPU.lslT(r3, 2);
      r2 = CPU.addT(r1, r3);
      r3 = CPU.movT(0, 0x0);
      MEMORY.ref(2, r2).setu(r3);
    }

    //LAB_8095860
    CPU.r8().value = CPU.pop();
  }

  @Method(0x8099810)
  public static void FUN_8099810() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809c138)
  public static void FUN_809c138(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x809c3a4)
  public static void FUN_809c3a4() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80b50a0)
  public static int FUN_80b50a0(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80f4000)
  public static int FUN_80f4000(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80f6000)
  public static int FUN_80f6000(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x80f9008)
  public static void FUN_80f9008() {
    FUN_80f9438();
  }

  @Method(0x80f9010)
  public static void FUN_80f9010(final int r0) {
    MEMORY.call(0x80f9081, r0);
  }

  @Method(0x80f9018)
  public static void FUN_80f9018() {
    FUN_80f91e8();
  }

  @Method(0x80f9070)
  public static int FUN_80f9070() {
    throw new RuntimeException("Not implenented");
  }

  @Method(0x80f9080)
  public static void FUN_80f9080(int r0) {
    int r1;
    int r2;
    int r3;
    final int r4;
    int r5;
    int r6;
    final int r7;

    r5 = CPU.movT(0, 0xf0);
    r3 = MEMORY.ref(4, 0x80f9134).get();
    r6 = CPU.addT(r0, 0x0);
    r5 = CPU.lslT(r5, 8);
    r5 = CPU.andT(r5, r6);
    r6 = CPU.andT(r6, r3);
    CPU.cmpT(r6, 0x11);
    if(CPU.cpsr().getZero()) { // ==
      r5 = MEMORY.ref(4, 0x80f9138).get();
      r3 = MEMORY.ref(1, r5).getUnsigned();
      CPU.cmpT(r3, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        return;
      }

      //LAB_80f909c
      r0 = MEMORY.ref(4, 0x80f913c).get();
      r1 = CPU.movT(0, 0x7);
      FUN_80fa4bc(r0, r1);
      r3 = MEMORY.ref(1, r5).getUnsigned();
      r2 = MEMORY.ref(4, 0x80f9140).get();
      r3 = CPU.addT(r3, 0x1);
      MEMORY.ref(1, r5).setu(r3);
      r3 = CPU.movT(0, 0x13);
    } else {
      //LAB_80f90b0
      r3 = MEMORY.ref(4, 0x80f9144).get();
      r6 = CPU.cmpT(r6, r3);
      if(CPU.cpsr().getZero()) { // ==
        r3 = MEMORY.ref(4, 0x80f9148).get();
        r2 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r3 + 0x6).setu(r2);
        r0 = MEMORY.ref(4, 0x80f914c).get();
        r1 = CPU.movT(0, 0x3);
        FUN_80fa4bc(r0, r1);
        return;
      }

      //LAB_80f90c6
      CPU.cmpT(r6, 0x63);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r7 = MEMORY.ref(4, 0x80f9150).get();
        r4 = CPU.lslT(r6, 3);
        r3 = CPU.addT(r4, 0x4);
        r2 = MEMORY.ref(2, r7 + r3).getUnsigned();
        CPU.cmpT(r2, 0x7);

        jmp_80f90f6:
        if(CPU.cpsr().getZero()) { // ==
          r1 = MEMORY.ref(4, 0x80f9154).get();

          //LAB_80f90d8
          do {
            r5 = CPU.lslT(r2, 1);
            r3 = CPU.addT(r5, r2);
            r3 = CPU.lslT(r3, 2);
            r3 = MEMORY.ref(4, r1 + r3).get();
            r3 = MEMORY.ref(1, r3 + 0x4).getUnsigned();
            CPU.cmpT(r3, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              break jmp_80f90f6;
            }
            r2 = CPU.subT(r2, 0x1);
            CPU.cmpT(r2, 0x3);
          } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >

          r2 = CPU.movT(0, 0x7);
          r5 = CPU.movT(0, 0xe);
        } else {
          //LAB_80f90f2
          r1 = MEMORY.ref(4, 0x80f9154).get();
          r5 = CPU.lslT(r2, 1);
        }

        //LAB_80f90f6
        r3 = CPU.addT(r5, r2);
        r3 = CPU.lslT(r3, 2);
        r0 = MEMORY.ref(4, r1 + r3).get();
        r1 = MEMORY.ref(4, r7 + r4).get();
        FUN_80faa58(r0, r1);
        r3 = MEMORY.ref(4, 0x80f9148).get();
        MEMORY.ref(2, r3 + r5).setu(r6);
        return;
      }

      //LAB_80f9108
      CPU.cmpT(r6, 0x4f);
      if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
        r0 = MEMORY.ref(4, 0x80f913c).get();
        r1 = CPU.movT(0, 0xff);
        r2 = CPU.movT(0, 0x0);
        FUN_80fb2cc(r0, r1, r2);
        r2 = MEMORY.ref(4, 0x80f9130).get();
        r3 = MEMORY.ref(4, 0x80f9158).get();
        MEMORY.ref(2, r3).setu(r2);
        r3 = MEMORY.ref(4, 0x80f915c).get();
        r0 = CPU.lslT(r6, 16);
        MEMORY.ref(2, r3).setu(r2);
        r0 = CPU.lsrT(r0, 16);
        FUN_80fa324(r0);
        r2 = MEMORY.ref(4, 0x80f9160).get();
        r3 = CPU.movT(0, 0xa);
      } else {
        //LAB_80f9164
        CPU.cmpT(r6, 0x12);
        if(CPU.cpsr().getZero()) { // ==
          return;
        }
        r2 = MEMORY.ref(4, 0x80f91a4).get();
        r3 = MEMORY.ref(1, r2).getUnsigned();
        r6 = CPU.cmpT(r6, r3);
        if(CPU.cpsr().getZero()) { // ==
          return;
        }
        MEMORY.ref(1, r2).setu(r6);
        CPU.cmpT(r6, 0x46);
        if(CPU.cpsr().getZero()) { // ==
          r0 = CPU.movT(0, 0x3);
        } else {
          CPU.cmpT(r6, 0x4b);
          if(CPU.cpsr().getZero()) { // ==
            r0 = CPU.movT(0, 0x3);
          } else {
            r0 = CPU.movT(0, 0x2);
            CPU.cmpT(r6, 0x43);
            if(CPU.cpsr().getZero()) { // ==
              r0 = CPU.movT(0, 0x3);
            }
          }
        }

        //LAB_80f9182
        FUN_80037d4(r0);
        r0 = CPU.lslT(r6, 16);
        r0 = CPU.lsrT(r0, 16);
        FUN_80fa324(r0);
        r3 = CPU.movT(0, 0x80);
        r3 = CPU.lslT(r3, 5);
        r3 = CPU.andT(r3, r5);
        CPU.cmpT(r3, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r2 = MEMORY.ref(4, 0x80f91a8).get();
          r3 = MEMORY.ref(4, 0x80f91a0).get();
        } else {
          //LAB_80f91ac
          r2 = MEMORY.ref(4, 0x80f91d0).get();
          r3 = MEMORY.ref(4, 0x80f91c8).get();
        }

        //LAB_80f91b0
        MEMORY.ref(2, r2).setu(r3);
        r2 = MEMORY.ref(4, 0x80f91d4).get();
        r3 = MEMORY.ref(4, 0x80f91c8).get();
        MEMORY.ref(2, r2).setu(r3);
        r2 = MEMORY.ref(4, 0x80f91d8).get();
        r3 = MEMORY.ref(4, 0x80f91cc).get();
        MEMORY.ref(2, r2).setu(r3);
        r2 = MEMORY.ref(4, 0x80f91dc).get();
        r3 = CPU.movT(0, 0x0);
      }
    }

    //LAB_80f91c2
    MEMORY.ref(1, r2).setu(r3);

    //LAB_80f91e0
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

  @Method(0x80fa4bc)
  public static void FUN_80fa4bc(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
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

  @Method(0x80f9ef8)
  public static void FUN_80f9ef8(int r0, int r1) {
    int r3;
    int r4;
    final int r5;
    final int r6;

    r5 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(1, r5).getUnsigned();
    r0 = CPU.movT(0, 0x80);
    r0 = CPU.tstT(r0, r1);
    if(!CPU.cpsr().getZero()) { // !=
      r4 = MEMORY.ref(4, r5 + 0x20).get();
      CPU.cmpT(r4, 0x0);
      if(!CPU.cpsr().getZero()) { // !=
        r6 = CPU.movT(0, 0x0);

        //LAB_80f9f0c
        do {
          r0 = MEMORY.ref(1, r4).getUnsigned();
          CPU.cmpT(r0, 0x0);
          if(!CPU.cpsr().getZero()) { // !=
            r0 = MEMORY.ref(1, r4 + 0x1).getUnsigned();
            r3 = CPU.movT(0, 0x7);
            r0 = CPU.andT(r0, r3);
            if(!CPU.cpsr().getZero()) { // !=
              r3 = MEMORY.ref(4, 0x80f9f38).get();
              r3 = MEMORY.ref(4, r3).get();
              r3 = MEMORY.ref(4, r3 + 0x2c).get();
              MEMORY.call(r3, r0, r1);
            }

            //LAB_80f9f24
            MEMORY.ref(1, r4).setu(r6);
          }

          //LAB_80f9f26
          MEMORY.ref(4, r4 + 0x2c).setu(r6);
          r4 = MEMORY.ref(4, r4 + 0x34).get();
          CPU.cmpT(r4, 0x0);
        } while(!CPU.cpsr().getZero()); // !=
      }

      //LAB_80f9f2e
      MEMORY.ref(4, r5 + 0x20).setu(r4);
    }

    //LAB_80f9f30
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

  @Method(0x80fa324)
  public static void FUN_80fa324(final int r0) {
    throw new RuntimeException("Not implemented");
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
  public static void FUN_80fa798(final int r0) {
    final int r1;
    final int r2;
    final int r5;

    final int r4 = _3007ff0.deref().getAddress();
    r2 = (r0 & 0xf0000) >>> 16;
    MEMORY.ref(1, r4 + 0x8).setu(r2);
    r5 = MEMORY.ref(2, 0x80fb914 + (r2 - 1) * 0x2).getUnsigned();
    MEMORY.ref(4, r4 + 0x10).setu(r5);
    MEMORY.ref(1, r4 + 0xb).setu(FUN_80022ec(0x630, r5));
    r1 = FUN_80022ec(0x91d1b * r5 + 0x1388, 0x2710);
    MEMORY.ref(4, r4 + 0x14).setu(r1);
    MEMORY.ref(4, r4 + 0x18).setu(FUN_80022ec(0x1000000, r1) + 1 >> 1);
    TIMERS.timers[0].CNT_H.setu(0);
    TIMERS.timers[0].CNT_L.setu(-FUN_80022ec(0x44940, r5));
    FUN_80fa9a4();

    //LAB_80fa7fc
    while(GPU.VCOUNT.getUnsigned() == 0x9f) {
      // ...
    }

    //LAB_80fa804
    while(GPU.VCOUNT.getUnsigned() != 0x9f) {
      // ...
    }

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
    final int r2 = _3007ff0.deref().getAddress();
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

  @Method(0x80faa58)
  public static void FUN_80faa58(int r0, int r1) {
    int r2;
    int r4;
    final int r5;
    int r6;
    final int r7;

    CPU.push(CPU.r8().value);

    r5 = CPU.addT(r0, 0x0);
    r7 = CPU.addT(r1, 0x0);
    r1 = MEMORY.ref(4, r5 + 0x34).get();
    r0 = MEMORY.ref(4, 0x80fab38).get();
    r1 = CPU.cmpT(r1, r0);
    if(!CPU.cpsr().getZero()) { // !=
      CPU.r8().value = CPU.pop();
      return;
    }

    r2 = MEMORY.ref(1, r7 + 0x2).getUnsigned();
    if(MEMORY.ref(1, r5 + 0xb).getUnsigned() != 0) {
      if(MEMORY.ref(4, r5).get() != 0 && (MEMORY.ref(4, r5 + 0x2c).deref(1).getUnsigned() & 0x40) != 0 || MEMORY.ref(2, r5 + 0x4).getUnsigned() != 0 && MEMORY.ref(4, r5 + 0x4).get() >= 0) {
        //LAB_80faa90
        r0 = MEMORY.ref(1, r7 + 0x2).getUnsigned();
        r2 = CPU.addT(r0, 0x0);
        r0 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
        r0 = CPU.cmpT(r0, r2);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          CPU.r8().value = CPU.pop();
          return;
        }
      }
    }

    //LAB_80faa9a
    r0 = MEMORY.ref(4, r5 + 0x34).get();
    r0 = CPU.addT(r0, 0x1);
    MEMORY.ref(4, r5 + 0x34).setu(r0);
    r1 = CPU.movT(0, 0x0);
    MEMORY.ref(4, r5 + 0x4).setu(r1);
    MEMORY.ref(4, r5).setu(r7);
    r0 = MEMORY.ref(4, r7 + 0x4).get();
    MEMORY.ref(4, r5 + 0x30).setu(r0);
    MEMORY.ref(1, r5 + 0x9).setu(r2);
    MEMORY.ref(4, r5 + 0xc).setu(r1);
    r0 = CPU.movT(0, 0x96);
    MEMORY.ref(2, r5 + 0x1c).setu(r0);
    MEMORY.ref(2, r5 + 0x20).setu(r0);
    r0 = CPU.addT(r0, 0x6a);
    MEMORY.ref(2, r5 + 0x1e).setu(r0);
    MEMORY.ref(2, r5 + 0x22).setu(r1);
    MEMORY.ref(2, r5 + 0x24).setu(r1);
    r6 = CPU.movT(0, 0x0);
    r4 = MEMORY.ref(4, r5 + 0x2c).get();
    r1 = MEMORY.ref(1, r7).getUnsigned();
    r6 = CPU.cmpT(r6, r1);

    jmp_80fab1a:
    {
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r0 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
        r6 = CPU.cmpT(r6, r0);
        if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
          break jmp_80fab1a;
        }
        CPU.r8().value = r6;

        //LAB_80faace
        do {
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.addT(r4, 0x0);
          FUN_80f9ef8(r0, r1);
          r0 = CPU.movT(0, 0xc0);
          MEMORY.ref(1, r4).setu(r0);
          r1 = CPU.r8().value;
          MEMORY.ref(4, r4 + 0x20).setu(r1);
          r1 = CPU.lslT(r6, 2);
          r0 = CPU.addT(r7, 0x0);
          r0 = CPU.addT(r0, 0x8);
          r0 = CPU.addT(r0, r1);
          r0 = MEMORY.ref(4, r0).get();
          MEMORY.ref(4, r4 + 0x40).setu(r0);
          r6 = CPU.addT(r6, 0x1);
          r4 = CPU.addT(r4, 0x50);
          r0 = MEMORY.ref(1, r7).getUnsigned();
          r6 = CPU.cmpT(r6, r0);
          if(CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >=
            break;
          }
          r1 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
          r6 = CPU.cmpT(r6, r1);
        } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
      }

      //LAB_80faafa
      r0 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
      r6 = CPU.cmpT(r6, r0);
      if(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <
        r1 = CPU.movT(0, 0x0);
        CPU.r8().value = r1;

        //LAB_80fab04
        do {
          r0 = CPU.addT(r5, 0x0);
          r1 = CPU.addT(r4, 0x0);
          FUN_80f9ef8(r0, r1);
          r0 = CPU.r8().value;
          MEMORY.ref(1, r4).setu(r0);
          r6 = CPU.addT(r6, 0x1);
          r4 = CPU.addT(r4, 0x50);
          r1 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
          r6 = CPU.cmpT(r6, r1);
        } while(CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()); // <
      }
    }

    //LAB_80fab1a
    r0 = CPU.movT(0, 0x80);
    r1 = MEMORY.ref(1, r7 + 0x3).getUnsigned();
    r0 = CPU.andT(r0, r1);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = MEMORY.ref(1, r7 + 0x3).getUnsigned();
      FUN_80fa83c(r0);
    }

    //LAB_80fab2a
    r0 = MEMORY.ref(4, 0x80fab38).get();
    MEMORY.ref(4, r5 + 0x34).setu(r0);

    //LAB_80fab2e
    CPU.r8().value = CPU.pop();
  }

  @Method(0x80fab7c)
  public static void FUN_80fab7c(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    final int r6;
    int r7;

    r6 = CPU.addT(r0, 0x0);
    r1 = MEMORY.ref(2, r6 + 0x24).getUnsigned();
    CPU.cmpT(r1, 0x0);
    if(CPU.cpsr().getZero()) { // ==
      return;
    }
    r0 = MEMORY.ref(2, r6 + 0x26).getUnsigned();
    r0 = CPU.subT(r0, 0x1);
    MEMORY.ref(2, r6 + 0x26).setu(r0);
    r3 = MEMORY.ref(4, 0x80fabbc).get();
    r2 = CPU.addT(r3, 0x0);
    r0 = CPU.lslT(r0, 16);
    r3 = CPU.lsrT(r0, 16);
    CPU.cmpT(r3, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      return;
    }
    MEMORY.ref(2, r6 + 0x26).setu(r1);
    r1 = MEMORY.ref(2, r6 + 0x28).getUnsigned();
    r0 = CPU.movT(0, 0x2);
    r0 = CPU.andT(r0, r1);
    CPU.cmpT(r0, 0x0);
    if(!CPU.cpsr().getZero()) { // !=
      r0 = CPU.addT(r1, 0x0);
      r0 = CPU.addT(r0, 0x10);
      MEMORY.ref(2, r6 + 0x28).setu(r0);
      r0 = CPU.andT(r0, r2);
      CPU.cmpT(r0, 0xff);
      if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
        r0 = CPU.movT(0, 0x80);
        r0 = CPU.lslT(r0, 1);
        MEMORY.ref(2, r6 + 0x28).setu(r0);
        MEMORY.ref(2, r6 + 0x24).setu(r3);
      }
    } else {
      //LAB_80fabc0
      r0 = CPU.addT(r1, 0x0);
      r0 = CPU.subT(r0, 0x10);
      MEMORY.ref(2, r6 + 0x28).setu(r0);
      r0 = CPU.andT(r0, r2);
      r0 = CPU.lslT(r0, 16);
      CPU.cmpT(r0, 0x0);
      if(CPU.cpsr().getZero() || CPU.cpsr().getNegative() != CPU.cpsr().getOverflow()) { // <=
        r5 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
        r4 = MEMORY.ref(4, r6 + 0x2c).get();
        CPU.cmpT(r5, 0x0);
        if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
          //LAB_80fabd6
          do {
            r0 = CPU.addT(r6, 0x0);
            r1 = CPU.addT(r4, 0x0);
            FUN_80f9ef8(r0, r1);
            r0 = CPU.movT(0, 0x1);
            r7 = MEMORY.ref(2, r6 + 0x28).getUnsigned();
            r0 = CPU.andT(r0, r7);
            CPU.cmpT(r0, 0x0);
            if(CPU.cpsr().getZero()) { // ==
              MEMORY.ref(1, r4).setu(r0);
            }

            //LAB_80fabea
            r5 = CPU.subT(r5, 0x1);
            r4 = CPU.addT(r4, 0x50);
            CPU.cmpT(r5, 0x0);
          } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
        }

        //LAB_80fabf2
        r0 = CPU.movT(0, 0x1);
        r1 = MEMORY.ref(2, r6 + 0x28).getUnsigned();
        r0 = CPU.andT(r0, r1);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r0 = MEMORY.ref(4, r6 + 0x4).get();
          r1 = CPU.movT(0, 0x80);
          r1 = CPU.lslT(r1, 24);
          r0 = CPU.orrT(r0, r1);
        } else {
          //LAB_80fac06
          r0 = CPU.movT(0, 0x80);
          r0 = CPU.lslT(r0, 24);
        }

        //LAB_80fac0a
        MEMORY.ref(4, r6 + 0x4).setu(r0);
        r0 = CPU.movT(0, 0x0);
        MEMORY.ref(2, r6 + 0x24).setu(r0);
        return;
      }
    }

    //LAB_80fac12
    r5 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
    r4 = MEMORY.ref(4, r6 + 0x2c).get();
    CPU.cmpT(r5, 0x0);
    if(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()) { // >
      r3 = CPU.movT(0, 0x80);
      r7 = CPU.movT(0, 0x0);
      r2 = CPU.movT(0, 0x3);

      //LAB_80fac20
      do {
        r1 = MEMORY.ref(1, r4).getUnsigned();
        r0 = CPU.addT(r3, 0x0);
        r0 = CPU.andT(r0, r1);
        CPU.cmpT(r0, 0x0);
        if(!CPU.cpsr().getZero()) { // !=
          r7 = MEMORY.ref(2, r6 + 0x28).getUnsigned();
          r0 = CPU.lsrT(r7, 2);
          MEMORY.ref(1, r4 + 0x13).setu(r0);
          r0 = CPU.addT(r1, 0x0);
          r0 = CPU.orrT(r0, r2);
          MEMORY.ref(1, r4).setu(r0);
        }

        //LAB_80fac36
        r5 = CPU.subT(r5, 0x1);
        r4 = CPU.addT(r4, 0x50);
        CPU.cmpT(r5, 0x0);
      } while(!CPU.cpsr().getZero() && CPU.cpsr().getNegative() == CPU.cpsr().getOverflow()); // >
    }

    //LAB_80fac3e
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

  @Method(0x8185000)
  public static int FUN_8185000(final int r0) {
    return (int)MEMORY.call(0x8185009, r0);
  }

  @Method(0x8185008)
  public static int FUN_8185008(final int r0) {
    return 0x8185024 + (r0 & 0xfff) * 0x14;
  }
}
