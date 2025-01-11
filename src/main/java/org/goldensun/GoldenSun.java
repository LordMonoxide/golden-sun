package org.goldensun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.goldensun.battle.Camera4c;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.Pointer;
import org.goldensun.memory.types.RunnableRef;
import org.goldensun.types.Actor70;
import org.goldensun.types.Map194;
import org.goldensun.types.Matrix30;
import org.goldensun.types.ObjAttributes08;
import org.goldensun.types.PointerTableType296;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.RotationScaling08;
import org.goldensun.types.SaveStruct1100;
import org.goldensun.types.SoundStructFb0;
import org.goldensun.types.Sprite38;
import org.goldensun.types.SpriteLayer18;
import org.goldensun.types.SramTypeStruct;
import org.goldensun.types.Struct0c;
import org.goldensun.types.Struct5c;
import org.goldensun.types.Structccc;
import org.goldensun.types.TickCallback08;
import org.goldensun.types.TileAttributes04;
import org.goldensun.types.VblankTransferQueue184;
import org.goldensun.types.Vec3;
import org.goldensun.types.VramSlot04;

import javax.annotation.Nullable;

import static org.goldensun.Bios.SvcHalt;
import static org.goldensun.CopiedSegment8000770.intHandlers_30000e0;
import static org.goldensun.CopiedSegment8000770.memzero;
import static org.goldensun.CopiedSegment8000770.mul16;
import static org.goldensun.CopiedSegment8000770.mulTransforms;
import static org.goldensun.CopiedSegment8000770.sqrt;
import static org.goldensun.CopiedSegment8000770.transformVector;
import static org.goldensun.GoldenSunVars._2004c00;
import static org.goldensun.GoldenSunVars._2004c08;
import static org.goldensun.GoldenSunVars._2004c0c;
import static org.goldensun.GoldenSunVars._2004c10;
import static org.goldensun.GoldenSunVars._2004c14;
import static org.goldensun.GoldenSunVars._2004c18;
import static org.goldensun.GoldenSunVars._2004c22;
import static org.goldensun.GoldenSunVars._2004c24;
import static org.goldensun.GoldenSunVars._3001810;
import static org.goldensun.GoldenSunVars._3001a10;
import static org.goldensun.GoldenSunVars._3001ac0;
import static org.goldensun.GoldenSunVars._3001ac4;
import static org.goldensun.GoldenSunVars._3001aec;
import static org.goldensun.GoldenSunVars._3001af0;
import static org.goldensun.GoldenSunVars._3001afc;
import static org.goldensun.GoldenSunVars._3001b00;
import static org.goldensun.GoldenSunVars._3001c98;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001ca0;
import static org.goldensun.GoldenSunVars._3001ca4;
import static org.goldensun.GoldenSunVars._3001ca8;
import static org.goldensun.GoldenSunVars._3001cb0;
import static org.goldensun.GoldenSunVars._3001cb8;
import static org.goldensun.GoldenSunVars._3001cbc;
import static org.goldensun.GoldenSunVars._3001cc0;
import static org.goldensun.GoldenSunVars._3001ccc;
import static org.goldensun.GoldenSunVars._3001cd0;
import static org.goldensun.GoldenSunVars._3001cd4;
import static org.goldensun.GoldenSunVars._3001cf4;
import static org.goldensun.GoldenSunVars._3001cfc;
import static org.goldensun.GoldenSunVars._3001d04;
import static org.goldensun.GoldenSunVars._3001d18;
import static org.goldensun.GoldenSunVars._3001d1c;
import static org.goldensun.GoldenSunVars._3001d20;
import static org.goldensun.GoldenSunVars._3001d2c;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001e44;
import static org.goldensun.GoldenSunVars._3001f58;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars._3007800;
import static org.goldensun.GoldenSunVars._3007804;
import static org.goldensun.GoldenSunVars._3007810;
import static org.goldensun.GoldenSunVars._3007ff0;
import static org.goldensun.GoldenSunVars._3007ffc;
import static org.goldensun.GoldenSunVars._8007a0c;
import static org.goldensun.GoldenSunVars._8013190;
import static org.goldensun.GoldenSunVars._8013624;
import static org.goldensun.GoldenSunVars._80136e0;
import static org.goldensun.GoldenSunVars._8013784;
import static org.goldensun.GoldenSunVars.accumulatedButtons_3001af8;
import static org.goldensun.GoldenSunVars.blendConfig_3001cf8;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.boundPsynergy1_2000460;
import static org.goldensun.GoldenSunVars.boundPsynergy2_2000462;
import static org.goldensun.GoldenSunVars.chipWramMallocHead_3001e54;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.heldButtons_3001d0c;
import static org.goldensun.GoldenSunVars.interactButton_2000450;
import static org.goldensun.GoldenSunVars.matrixStackDepth_3001cc4;
import static org.goldensun.GoldenSunVars.menuButton_2000454;
import static org.goldensun.GoldenSunVars.oldInterrupts_2004c2c;
import static org.goldensun.GoldenSunVars.packets_3001400;
import static org.goldensun.GoldenSunVars.playerMapActorIndex_2000434;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.psynergy1Button_2000458;
import static org.goldensun.GoldenSunVars.psynergy2Button_200045a;
import static org.goldensun.GoldenSunVars.ptrTable_8320000;
import static org.goldensun.GoldenSunVars.readOneByteFromPtr_2004c1c;
import static org.goldensun.GoldenSunVars.rotationScalingCount_3001d00;
import static org.goldensun.GoldenSunVars.rotationScaling_3001d40;
import static org.goldensun.GoldenSunVars.runButton_200045c;
import static org.goldensun.GoldenSunVars.seed_3001cb4;
import static org.goldensun.GoldenSunVars.systemMenuButton_2000456;
import static org.goldensun.GoldenSunVars.tickCallbacksInitialized_3001d34;
import static org.goldensun.GoldenSunVars.tickCallbacks_3001a20;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars.tileAttribs_2010000;
import static org.goldensun.GoldenSunVars.timerCntLPtr_2004c28;
import static org.goldensun.GoldenSunVars.timerIndex_2004c20;
import static org.goldensun.GoldenSunVars.transforms_3000350;
import static org.goldensun.GoldenSunVars.vblankOccurred_3001d28;
import static org.goldensun.GoldenSunVars.vblankTransferQueue_2002090;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSunVars.writeSectorPtr_2004c04;
import static org.goldensun.GoldenSun_801.FUN_8010000;
import static org.goldensun.GoldenSun_801.FUN_8010230;
import static org.goldensun.GoldenSun_801.FUN_80118d8;
import static org.goldensun.GoldenSun_801.FUN_8011a84;
import static org.goldensun.GoldenSun_801.FUN_80120dc;
import static org.goldensun.GoldenSun_801.FUN_801219c;
import static org.goldensun.GoldenSun_801.getHeight;
import static org.goldensun.GoldenSun_807.clearFlag_;
import static org.goldensun.GoldenSun_807.getUnit_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a008;
import static org.goldensun.GoldenSun_808.FUN_808a330;
import static org.goldensun.GoldenSun_808.FUN_808a348;
import static org.goldensun.GoldenSun_80f.FUN_80f9008;
import static org.goldensun.GoldenSun_80f.FUN_80f9018;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.GoldenSun_818.getSpriteData;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GATE;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INPUT;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.Hardware.SRAM;
import static org.goldensun.Hardware.TIMERS;
import static org.goldensun.MathHelper.clamp;
import static org.goldensun.input.Input.BUTTON_B;
import static org.goldensun.input.Input.BUTTON_L;
import static org.goldensun.input.Input.BUTTON_R;
import static org.goldensun.memory.MemoryHelper.getMethodAddress;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun {
  private GoldenSun() { }

  private static final Logger LOGGER = LogManager.getFormatterLogger(GoldenSun.class);

  /** {@link #sleep} */
  @Method(0x80000c0)
  public static void sleep_(final int frames) {
    MEMORY.call(0x80030f8, frames);
  }

  /** {@link #setTickCallback} */
  @Method(0x80000d0)
  public static void setTickCallback_(@Nullable final RunnableRef callback, final int classAndPriority) {
    MEMORY.call(0x80041d8, callback, classAndPriority);
  }

  /** {@link GoldenSun#clearTickCallback} */
  @Method(0x80000d8)
  public static int clearTickCallback_(final RunnableRef r0) {
    return (int)MEMORY.call(0x8004278, r0);
  }

  /** {@link GoldenSun#rand} */
  @Method(0x80000f8)
  public static int rand_() {
    return (int)MEMORY.call(0x8004458);
  }

  /** {@link GoldenSun#atan2} */
  @Method(0x8000100)
  public static int atan2_(final int b, final int a) {
    return (int)MEMORY.call(0x80044d0, b, a);
  }

  /** {@link GoldenSun#sqrt16} */
  @Method(0x8000110)
  public static int sqrt16_(final int r0) {
    return (int)MEMORY.call(0x80045d4, r0);
  }

  /** {@link GoldenSun#sin} */
  @Method(0x8000118)
  public static int sin_(final int angle) {
    return (int)MEMORY.call(0x8002322, angle);
  }

  /** {@link GoldenSun#cos} */
  @Method(0x8000120)
  public static int cos_(final int angle) {
    return (int)MEMORY.call(0x800231c, angle);
  }

  /** {@link GoldenSun#rotVec3} */
  @Method(0x8000128)
  public static void retVec3(final int distance, final int angle, final Vec3 vec) {
    MEMORY.call(0x800447c, distance, angle, vec);
  }

  /** {@link GoldenSun#setInterruptHandler} */
  @Method(0x8000130)
  public static void setInterruptHandler_(final int interruptType, final int vcountSetting, @Nullable final RunnableRef callback) {
    MEMORY.call(0x800307c, interruptType, vcountSetting, callback);
  }

  /** {@link GoldenSun#initMemoryAllocator} */
  @Method(0x8000138)
  public static void initMemoryAllocator_() {
    MEMORY.call(0x8004858);
  }

  /** {@link GoldenSun#mallocSlotChip} */
  @Method(0x8000140)
  public static int mallocSlotChip_(final int slot, final int size) {
    return (int)MEMORY.call(0x80048b0, slot, size);
  }

  /** {@link GoldenSun#mallocSlotBoard} */
  @Method(0x8000148)
  public static int mallocSlotBoard_(final int slot, final int size) {
    return (int)MEMORY.call(0x80048f4, slot, size);
  }

  /** {@link GoldenSun#freeSlot} */
  @Method(0x8000150)
  public static void freeSlot_(final int slot) {
    MEMORY.call(0x8002dd8, slot);
  }

  /** {@link #decompress} */
  @Method(0x80001a8)
  public static int decompress_(final int src, final int dest) {
    return (int)MEMORY.call(0x8005340, src, dest);
  }

  /** {@link GoldenSun#clearVramSlot} */
  @Method(0x80001b8)
  public static int clearVramSlot_(final int slot) {
    return (int)MEMORY.call(0x8003f3c, slot);
  }

  /** {@link GoldenSun#allocateSpriteSlot} */
  @Method(0x80001c8)
  public static int allocateSpriteSlot_(final int slot, final int size, final int newDataPtr) {
    return (int)MEMORY.call(0x8003fa4, slot, size, newDataPtr);
  }

  /** {@link #getPointerTableEntry} */
  @Method(0x8000290)
  public static int getPointerTableEntry_(final int index) {
    return (int)MEMORY.call(0x8002f40, index);
  }

  /** {@link #FUN_8002f3c} */
  @Method(0x8000298)
  public static void FUN_8000298(final int r0) {
    MEMORY.call(0x8002f3c, r0);
  }

  /** {@link #fadeOutBrightness} */
  @Method(0x80002a8)
  public static void fadeOutBrightness_(final int frames) {
    MEMORY.call(0x8003b70, frames);
  }

  /** {@link #waitForFade} */
  @Method(0x80002d0)
  public static void waitForFade_() {
    MEMORY.call(0x8003ce0);
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

  @Method(0x8001ea8)
  public static void FUN_8001ea8(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;

    r2 = r2 + r0;
    CPU.r12().value = 0x3f3f3f3f;

    //LAB_8001ebc
    do {
      int address8001ebc = r0;
      r3 = MEMORY.ref(4, address8001ebc).getUnsigned();
      address8001ebc += 0x4;
      r4 = MEMORY.ref(4, address8001ebc).getUnsigned();
      address8001ebc += 0x4;
      r5 = MEMORY.ref(4, address8001ebc).getUnsigned();
      address8001ebc += 0x4;
      r6 = MEMORY.ref(4, address8001ebc).getUnsigned();

      int address8001ec0 = r1;
      MEMORY.ref(4, address8001ec0).setu(r3);
      address8001ec0 += 0x4;
      MEMORY.ref(4, address8001ec0).setu(r4);
      address8001ec0 += 0x4;
      MEMORY.ref(4, address8001ec0).setu(r5);
      address8001ec0 += 0x4;
      MEMORY.ref(4, address8001ec0).setu(r6);
      address8001ec0 += 0x4;
      r1 = address8001ec0;

      r3 = CPU.addA(r3, r3 << 1);
      if(!CPU.cpsr().getZero()) { // !=
        r3 = CPU.r12().value & r3 >>> 2;
      }
      r4 = CPU.addA(r4, r4 << 1);
      if(!CPU.cpsr().getZero()) { // !=
        r4 = CPU.r12().value & r4 >>> 2;
      }
      r5 = CPU.addA(r5, r5 << 1);
      if(!CPU.cpsr().getZero()) { // !=
        r5 = CPU.r12().value & r5 >>> 2;
      }
      r6 = CPU.addA(r6, r6 << 1);
      if(!CPU.cpsr().getZero()) { // !=
        r6 = CPU.r12().value & r6 >>> 2;
      }

      int address8001ee4 = r0;
      MEMORY.ref(4, address8001ee4).setu(r3);
      address8001ee4 += 0x4;
      MEMORY.ref(4, address8001ee4).setu(r4);
      address8001ee4 += 0x4;
      MEMORY.ref(4, address8001ee4).setu(r5);
      address8001ee4 += 0x4;
      MEMORY.ref(4, address8001ee4).setu(r6);
      address8001ee4 += 0x4;
      r0 = address8001ee4;

      CPU.cmpA(r0, r2);
    } while(!CPU.cpsr().getZero()); // !=
  }

  @Method(0x8001ef8)
  public static void FUN_8001ef8(int r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;

    r2 = r2 + r0;
    CPU.r12().value = 0x3f00;
    CPU.r12().value = CPU.r12().value + 0x3f;
    CPU.r12().value = CPU.r12().value | CPU.r12().value << 16;

    //LAB_8001f0c
    do {
      int address8001f0c = r0;
      r3 = MEMORY.ref(4, address8001f0c).getUnsigned();
      address8001f0c += 0x4;
      r4 = MEMORY.ref(4, address8001f0c).getUnsigned();
      address8001f0c += 0x4;
      r5 = MEMORY.ref(4, address8001f0c).getUnsigned();
      address8001f0c += 0x4;
      r6 = MEMORY.ref(4, address8001f0c).getUnsigned();

      int address8001f10 = r1;
      MEMORY.ref(4, address8001f10).setu(r3);
      address8001f10 += 0x4;
      MEMORY.ref(4, address8001f10).setu(r4);
      address8001f10 += 0x4;
      MEMORY.ref(4, address8001f10).setu(r5);
      address8001f10 += 0x4;
      MEMORY.ref(4, address8001f10).setu(r6);
      address8001f10 += 0x4;
      r1 = address8001f10;
      r3 = CPU.r12().value & r3 >>> 1;
      r4 = CPU.r12().value & r4 >>> 1;
      r5 = CPU.r12().value & r5 >>> 1;
      r6 = CPU.r12().value & r6 >>> 1;
      int address8001f24 = r0;
      MEMORY.ref(4, address8001f24).setu(r3);
      address8001f24 += 0x4;
      MEMORY.ref(4, address8001f24).setu(r4);
      address8001f24 += 0x4;
      MEMORY.ref(4, address8001f24).setu(r5);
      address8001f24 += 0x4;
      MEMORY.ref(4, address8001f24).setu(r6);
      address8001f24 += 0x4;
      r0 = address8001f24;
      CPU.cmpA(r0, r2);
    } while(!CPU.cpsr().getZero()); // !=
  }

  /** Signed division */
  @Method(0x80022ec)
  public static int divideS(final int r0, final int r1) {
    return (int)MEMORY.call(0x3000380, r0, r1);
  }

  /** Unsigned division */
  @Method(0x80022f4)
  public static int divideU(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003f0, r0, r1);
  }

  /** Signed mod */
  @Method(0x80022fc)
  public static int modS(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003ac, r0, r1);
  }

  /** Unsigned mod */
  @Method(0x8002304)
  public static int modU(final int r0, final int r1) {
    return (int)MEMORY.call(0x30003e1, r0, r1);
  }

  @Method(0x800231c)
  public static int cos(final int r0) {
    return sin(r0 + 0x4000); // falls through to this method
  }

  @Method(0x8002322)
  public static int sin(int r0) {
    int r1;
    int r2;
    int r3;

    r0 = CPU.addT(r0, 0x20);
    r1 = CPU.lslT(r0, 18);
    r1 = CPU.lsrT(r1, 24);
    if(CPU.cpsr().getZero()) { // ==
      r2 = CPU.lsrT(r0, 14);
      r0 = CPU.movT(0x1);
      r0 = CPU.andT(r0, r2);
      r0 = CPU.lslT(r0, 16);
      r2 = CPU.lsrT(r2, 2);
      if(CPU.cpsr().getCarry()) { // unsigned >=
        r0 = CPU.negT(r0);
      }

      //LAB_800231a
      return r0;
    }
    r2 = CPU.lsrT(r0, 15);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r3 = CPU.movT(0x80);
      r3 = CPU.lslT(r3, 1);
      r1 = CPU.subT(r3, r1);
    }

    //LAB_8002334
    r1 = CPU.lslT(r1, 1);
    r3 = 0x8002344;
    r0 = MEMORY.ref(2, r3 + r1).getUnsigned();
    r2 = CPU.lsrT(r2, 1);
    if(CPU.cpsr().getCarry()) { // unsigned >=
      r0 = CPU.negT(r0);
    }

    //LAB_8002342
    return r0;
  }

  @Method(0x8002dd8)
  public static void freeSlot(final int slot) {
    final int addr = boardWramMallocHead_3001e50.offset(slot * 0x4).get();
    final int r3 = addr >>> 22;
    if(r3 != 0) {
      boardWramMallocHead_3001e50.offset(slot * 0x4).setu(0);
      boardWramMallocHead_3001e50.offset(r3 & 0x4).setu(addr);
    }

    //LAB_8002dec
  }

  /**
   * Resets the memory allocator address ot the address that's passed in. Used
   * to deallocate everything that was allocated after a certain point.
   */
  @Method(0x8002df0)
  public static void setMallocAddress(final int addr) {
    boardWramMallocHead_3001e50.offset(addr >>> 22 & 0x4).setu(addr);
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
    vblankTransferQueue_2002090.count_00.set(0);
    vblankTransferQueue_2002090._02.set(0);
    _3001ac4.setu(0);
    debug_3001f54.set(0);
    _3001f58.set(0);
    FUN_8002f10();
    loadUiTextures();
    FUN_8004760();
    GPU.DISPCNT.setu(0x140);
    setInterruptHandler(0, 1, getRunnable(GoldenSun.class, "vblankInterruptHandler"));
    INPUT.KEY_CNT.setu(0xc00f);
    FUN_80f9008();
    initVramSlots();
    clearTickCallbacks();
    _3007800.set(0);
    _3001d18.set(1);
    _3001ca0.set(0);
    sleep(10);
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
  public static void decompressPointerTableEntry(final int pointerTableEntry, final int dst) {
    LOGGER.info("Decompressing pointer table entry %d to 0x%x", pointerTableEntry, dst);

    final int decompressedSize = decompress(getPointerTableEntry(pointerTableEntry), dst);

    final int size = 0x7c;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8002d5c);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8002d5c.class, "FUN_8002d5c", int.class, int.class);
    MEMORY.call(addr, dst, decompressedSize); // Update function pointers in decompressed THUMB code
    setMallocAddress(addr);
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
  public static void sleep(final int frames) {
/*
    int r10 = CPU.sp().value;
    if(r10 < 0x3007a00) {
      final int r2 = 0x3007a00 - r10;
      oldSp_3001804.set(r2);
      DMA.channels[3].SAD.setu(r10);
      DMA.channels[3].DAD.setu(0x20023b0);
      DMA.channels[3].CNT.setu(0x84000000 | r2 / 4);
      CPU.sp().value = 0x3007a00;
    }
*/

    //LAB_8003130
    //LAB_800313c
    //LAB_8003144
    for(int frame = 0; frame < frames; frame++) {
      _3001a10.set(1);
      runTickCallbacks(0xc80);
      _3001a10.set(0);
      processRenderQueue(MEMORY.ref(4, mallocSlotChip(52, 0x400), ArrayRef.of(ObjAttributes08.class, 0x80, 0x8, ObjAttributes08::new)));
      _3001e44.set(1);

      if(_3001f58.get() != 0) {
        int r1 = GPU.VCOUNT.getUnsigned();
        if(r1 > 160) {
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

      //LAB_8003210
      jmp_800330a:
      if(debug_3001f54.get() != 0) {
        //LAB_800321a
        //LAB_80032e4
        //LAB_8003288
        while(_3001d20.get() == 0) {
          // Start+select held
          if(heldButtonsLastFrame_3001ae8.get() != 0xc) {
            break jmp_800330a;
          }
          _3001d20.set(1);

          //LAB_8003292
          vblankOccurred_3001d28.and(0xfffe);

          //LAB_800329e
          do {
            CPU.pc().value = 0x80032a0;
            SvcHalt();
          } while((vblankOccurred_3001d28.get() & 0x1) == 0);

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

        if((pressedButtons_3001b04.get() & 0x7) != 0) {
          break jmp_800330a;
        }

        if((heldButtonsLastFrame_3001ae8.get() & 0xf0) != 0) { // Direction buttons
          break jmp_800330a;
        }

        if((pressedButtons_3001b04.get() & 0x8) == 0) {
          throw new RuntimeException("How do we do this jump?");
          //LAB_8003292;
        }

        _3001d20.set(0);
      }

      //LAB_800330a
      _3001cd0.setu(_3001ccc.get());
      _3001ccc.set(0);
      vblankOccurred_3001d28.and(0xfffe);

      //LAB_8003322
      do {
        CPU.pc().value = 0x8003324;
        SvcHalt();
      } while((vblankOccurred_3001d28.get() & 0x1) == 0);

      freeSlot(52);
      clearRenderQueue();
      _3001e40.incr();
      _3001c9c.incr();
      FUN_8003538();

      if(_3001cb0.get() != 0) {
        FUN_8005fcc();

        if(MEMORY.ref(1, 0x2002240).getUnsigned() != 0) {
          MEMORY.ref(1, 0x2002248).setu(1);
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
/*
    if(oldSp_3001804.get() != 0) {
      r10 = CPU.sp().value - oldSp_3001804.get();
      CPU.sp().value = r10;
      DMA.channels[3].SAD.setu(0x20023b0);
      DMA.channels[3].DAD.setu(r10);
      DMA.channels[3].CNT.setu(0x84000000 | oldSp_3001804.get() / 4);

      //LAB_80034f0
      while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
        DebugHelper.sleep(1);
      }

      oldSp_3001804.set(0);
    }
*/

    //LAB_80034fc
  }

  @Method(0x800352c)
  public static void FUN_800352c() {
    _3001b00.set(0x13);
  }

  @Method(0x8003538)
  public static void FUN_8003538() {
    final int r0 = _3001b00.get();
    int r5 = 0;
    if(r0 <= 0) {
      pressedButtons_3001b04.set(heldButtonsLastFrame_3001ae8.get());
      if(r0 == 0) {
        _3001b00.set(0x6);
      } else {
        //LAB_8003558
        _3001b00.set(0x13);
      }
    } else {
      //LAB_800355e
      pressedButtons_3001b04.set(r5);
    }

    //LAB_8003564
    final int r1 = pressedButtons_3001b04.get();
    if(r1 != 0) {
      int r2 = 0;
      if((r1 & 0x40) != 0) {
        r2++;
      }

      //LAB_8003574
      if((r1 & 0x80) != 0) {
        r2++;
      }

      //LAB_800357e
      if((r1 & 0x20) != 0) {
        r2++;
      }

      //LAB_8003588
      if((r1 & 0x10) != 0) {
        r2++;
      }

      //LAB_8003592
      _3001afc.set(r1);

      if(r2 == 0) {
        //LAB_80035b0
        _3001d04.set(0x30);
      } else if(r2 == 1) {
        //LAB_80035b8
        _3001d04.set(r1 & 0xf0);
      } else if(r2 == 2) {
        //LAB_80035c2
        if((_3001d04.get() & _3001afc.get()) == 0) {
          _3001d04.set(0x30);
        }

        //LAB_80035d2
        _3001afc.and(_3001d04.get() ^ 0xffff);
      } else if(r2 == 3) {
        //LAB_80035e0
        if((_3001d04.get() & 0x30) != 0) {
          r5 = 0x30;
        }

        //LAB_80035ee
        if((_3001d04.get() & 0xc0) != 0) {
          r5 = 0xc0;
        }

        //LAB_80035fa
        r2 = r5 ^ 0xffff;
        _3001d04.set(r1 & r2);
        _3001afc.and(r2);
      } else {
        _3001d04.set(0x30);
        _3001afc.and(0xff0f);
      }
    } else {
      //LAB_800360a
      _3001afc.set(r1);
    }

    //LAB_800360e
    pressedButtons_3001c94.set((heldButtonsLastFrame_3001ae8.get() ^ _3001cf4.get()) & heldButtonsLastFrame_3001ae8.get());
    _3001cf4.set(heldButtonsLastFrame_3001ae8.get());
  }

  @Method(0x8003650)
  public static void vblankInterruptHandler() {
    DMA.channels[0].CNT.offset(2, 0x2).and(0xc5ff).and(0x7fff);

    if(_3001cb0.get() != 0) {
      _3001f64.set(FUN_8006088(0x2002220, 0x2002020));
      FUN_800655c();
    }

    //LAB_800367e
    FUN_80f9018();
    FUN_8003adc();

    if(_3001e44.get() != 0) {
      if(_3001d18.get() != 0) {
        DMA.channels[3].SAD.setu(boardWramMallocHead_3001e50.offset(52 * 0x4).get());
        DMA.channels[3].DAD.setu(0x7000000); // OAM
        DMA.channels[3].CNT.setu(0x84000100);
      }

      //LAB_80036a8
      DMA.channels[3].SAD.setu(0x3001ad0);
      DMA.channels[3].DAD.setu(GPU.BG0HOFS.getAddress());
      DMA.channels[3].CNT.setu(0x84000004);
      performVblankTransfers();
      _3001e44.set(0);
    }

    //LAB_80036bc
    if(_3001cfc.get() != 0) {
      _3001cfc.set(0);
      //FUN_80072ec(r0, r1, r2);
      throw new RuntimeException("What should r0 be here?");
    }

    //LAB_80036cc
    runTickCallbacks(0x480);

    final int pressedButtons = 0x3ff ^ INPUT.KEY_INPUT.getUnsigned();
    final int pressedThisFrame = pressedButtons & ~heldButtonsLastFrame_3001ae8.get();
    pressedButtons_3001c94.set(pressedThisFrame);
    accumulatedButtons_3001af8.or(pressedThisFrame);
    heldButtonsLastFrame_3001ae8.set(pressedButtons);

    if(pressedButtons == 0) {
      _3001b00.set(0x13);
      pressedButtons_3001b04.set(0);
      //LAB_8003768
    } else if((pressedButtons & (heldButtons_3001d0c.get() ^ 0xffff)) != 0) {
      _3001b00.set(-1);
      pressedButtons_3001b04.set(pressedButtons);
      //LAB_8003786
    } else if(_3001b00.get() > 0) {
      _3001b00.decr();
    }

    //LAB_8003792
    heldButtons_3001d0c.set(pressedButtons);
    ticks_3001800.incr();
    _3001ccc.incr();
    vblankOccurred_3001d28.set(1);
    FUN_80006fc();
  }

  /** Overwrites a 0x98-byte segment of {@link CopiedSegment8000770#FUN_3000b60} */
  @Method(0x80037d4)
  public static int FUN_80037d4(int mode) {
    if(mode < 0 || mode > 4) {
      mode = 0;
    }

    //LAB_80037dc
    DMA.channels[3].SAD.setu(0x8000404 + mode * 0x98);
    DMA.channels[3].DAD.setu(0x3000bd8);
    DMA.channels[3].CNT.setu(0x84000026);
    CopiedSegment8000770.FUN_3000b60_MODE = mode;
    return 0;
  }

  @Method(0x800387c)
  public static void FUN_800387c(final int r0, final int r1) {
    final int r5 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    final VblankTransferQueue184 r4 = vblankTransferQueue_2002090;
    final int r2 = r4.count_00.get();
    if(r2 < 0x20) {
      r4.queue_04.get(r2 * 0xc).src_00.set(r1);
      r4.queue_04.get(r2 * 0xc).dst_04.set(r0);
      r4.queue_04.get(r2 * 0xc).cnt_08.set(0x20000);
      r4.count_00.incr();
    }

    //LAB_80038aa
    INTERRUPTS.INT_MASTER_ENABLE.setu(r5);
  }

  @Method(0x800393c)
  public static void FUN_800393c(final int r0, final int r1) {
    final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    final int r2 = vblankTransferQueue_2002090.count_00.get();
    if(r2 < 32) {
      vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(r1);
      vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(r0);
      vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0x60000);
      vblankTransferQueue_2002090.count_00.incr();
    }

    //LAB_800396a
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldIme);
  }

  @Method(0x80039fc)
  public static void FUN_80039fc(final int r0, final int r1) {
    final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    final int r2 = vblankTransferQueue_2002090.count_00.get();
    if(r2 < 32) {
      vblankTransferQueue_2002090.queue_04.get(r2).src_00.set(r1);
      vblankTransferQueue_2002090.queue_04.get(r2).dst_04.set(r0);
      vblankTransferQueue_2002090.queue_04.get(r2).cnt_08.set(0xa0000);
      vblankTransferQueue_2002090.count_00.incr();
    }

    //LAB_8003a2a
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldIme);
  }

  @Method(0x8003a7c)
  public static void performVblankTransfers() {
    final int oldSp = CPU.sp().value;

    final int count = vblankTransferQueue_2002090.count_00.get();
    if(count != 0) {
      final int size = 0x68;
      CPU.sp().value -= size;

      // So we're just gonna copy an entire function to the stack and pretend that's normal?
      DMA.channels[3].SAD.setu(0x8002cf4);
      DMA.channels[3].DAD.setu(CPU.sp().value);
      DMA.channels[3].CNT.setu(0x84000000 | size / 4);

      MEMORY.setFunction(CPU.sp().value, StackFunction8002cf4.class, "performVblankTransfers_", VblankTransferQueue184.class, int.class);
      MEMORY.call(CPU.sp().value, vblankTransferQueue_2002090, count);

      vblankTransferQueue_2002090.count_00.set(0);
    }

    //LAB_8003abc
    CPU.sp().value = oldSp;
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
      GPU.BLDY.setu(_3001ca8.get() + divideS(_3001ac0.get() * (_3001aec.get() - _3001ca8.get()), _3001c98.get()));

      if(_3001ac0.get() == 0) {
        _3001c98.set(0);
      }
    }

    //LAB_8003b68
  }

  @Method(0x8003b70)
  public static void fadeOutBrightness(final int frames) {
    _3001cd4.set(0);
    blendConfig_3001cf8.set(0x3e); // bg1/2/3/obj/bd 1st target pixel
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0x10);
    _3001c98.set(frames);
    _3001ac0.set(frames);
  }

  @Method(0x8003bb4)
  public static void fadeInBrightness(final int frames) {
    _3001cd4.set(0);
    blendConfig_3001cf8.set(0x3e); // bg1/2/3/obj/bd 1st target pixel
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0);
    _3001c98.set(frames);
    _3001ac0.set(frames);
  }

  @Method(0x8003bf8)
  public static void fadeOutAlpha(final int frames) {
    _3001cd4.set(1);
    blendConfig_3001cf8.set(0x3e); // bg1/2/3/obj/bd 1st target pixel
    _3001aec.set(MEMORY.ref(1, 0x3001ca8).getUnsigned());
    _3001ca8.set(0x10);
    _3001c98.set(frames);
    _3001ac0.set(frames);
  }

  @Method(0x8003c3c)
  public static void fadeInAlpha(final int frames) {
    _3001cd4.set(1);
    blendConfig_3001cf8.set(0x3e);
    _3001aec.set(_3001ca8.get());
    _3001ca8.set(0);
    _3001c98.set(frames);
    _3001ac0.set(frames);
  }

  @Method(0x8003ce0)
  public static void waitForFade() {
    //LAB_8003cec
    while(_3001c98.get() != 0) {
      sleep(1);
    }

    //LAB_8003cf8
  }

  @Method(0x8003d04)
  public static void clearRenderQueue() {
    rotationScalingCount_3001d00.set(0);
    memzero(packets_3001400.getAddress(), 0x400);
  }

  @Method(0x8003d28)
  public static int addRotScaleParams(final int r0) {
    final int index = rotationScalingCount_3001d00.get();
    if(index > 0x1f) {
      return 0;
    }

    final int x = MEMORY.ref(2, r0).get();
    final int y = MEMORY.ref(2, r0 + 0x2).get();
    final int angle = MEMORY.ref(2, r0 + 0x4).getUnsigned();

    final RotationScaling08 params = rotationScaling_3001d40.get(index);

    //LAB_8003d62
    if((x == y || -x == y) && angle == 0) { // uniform scaling, no rotation
      final int r0_0 = divideS(0x10000, y);
      final int r2;
      if(-x == y) {
        r2 = -r0_0;
      } else {
        r2 = r0_0;
      }

      //LAB_8003d7e
      params.pa_00.set(r2 & 0xffff);
      params.pb_02.set(0);
      params.pc_04.set(0);
      params.pd_06.set(r0_0);
    } else {
      //LAB_8003d8a
      final int sin = sin(angle);
      final int cos = cos(angle);
      params.pa_00.set(divideS(cos, x));
      params.pb_02.set(divideS(sin, x));
      params.pc_04.set(divideS(-sin, y));
      params.pd_06.set(divideS(cos, y));
    }

    //LAB_8003dc8
    rotationScalingCount_3001d00.incr();

    //LAB_8003dd2
    return index;
  }

  @Method(0x8003dec)
  public static void insertIntoRenderQueue(final RenderPacket0c packet, final int z) {
    final Pointer<RenderPacket0c> r3 = packets_3001400.get(clamp(z, 0, 0xff));
    packet.next_00.setNullable(r3.derefNullable());
    r3.set(packet);
  }

  @Method(0x8003e10)
  public static void processRenderQueue(final ArrayRef<ObjAttributes08> attribs) {
    final int size = 0xe0;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8001dc8);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x8400_0000 | size / 4); // 0x38 words, 32-bit, enable

    MEMORY.setFunction(addr, CopiedSegment8001dc8.class, "FUN_3002400", ArrayRef.classFor(ObjAttributes08.class));
    MEMORY.call(addr, attribs);

    setMallocAddress(addr);
  }

  @Method(0x8003e58)
  public static int FUN_8003e58(int r0, int r1) {
    int r4;
    final int r5;
    final int r6;

    r6 = r0;
    r5 = r1 >>> 6;
    if(r6 >= 0x60) {
      return -1;
    }

    //LAB_8003e68
    r4 = 0;

    //LAB_8003e74
    do {
      if(r4 >= 0x200) {
        return -1;
      }

      jmp_8003eb2:
      if(_3001810.get(r4).get() == 0xff) {
        r0 = r4;
        r1 = r5 + r4;

        //LAB_8003e90
        while(r4 < r1) {
          if(_3001810.get(r4).get() != 0xff) {
            break jmp_8003eb2;
          }
          r4++;
        }

        //LAB_8003e9e
        //LAB_8003ea4
        for(int i = 0; i < r5; i++) {
          _3001810.get(r0 + i).set(r6);
        }

        break;
      }

      //LAB_8003eb2
      r4 += vramSlots_3001b10.get(_3001810.get(r4).get()).size_00.get() >>> 6;
    } while(true);

    //LAB_8003ec2
    //LAB_8003ec4
    return r0 << 6;
  }

  @Method(0x8003f04)
  public static int FUN_8003f04(final int r0) {
    if(r0 < 0 || r0 >= 0x60) {
      return -1;
    }

    int r4 = 0;

    //LAB_8003f14
    for(int r1 = 0; r1 < 0x200; r1++) {
      if(_3001810.get(r1).get() == r0) {
        _3001810.get(r1).set(0xff);
        r4++;
      }

      //LAB_8003f1e
    }

    if(r4 != 0) {
      //LAB_8003f2a
      return -1;
    }

    //LAB_8003f30
    //LAB_8003f32
    return 0;
  }

  @Method(0x8003f3c)
  public static int clearVramSlot(final int slot) {
    if(slot < 0 || slot >= 0x60) {
      return -1;
    }

    //LAB_8003f4e
    final VramSlot04 r5 = vramSlots_3001b10.get(slot);
    if(r5.vramAddr_02.get() != 0xffff) {
      FUN_8003f04(slot);
      r5.size_00.set(0);
      r5.vramAddr_02.set(0xffff);
    }

    //LAB_8003f66
    //LAB_8003f68
    return 0;
  }

  @Method(0x8003f78)
  public static int FUN_8003f78(final int slot) {
    if(slot < 0 || slot >= 0x60) {
      return -1;
    }

    //LAB_8003f8a
    if(vramSlots_3001b10.get(slot).size_00.get() > 0x10) {
      FUN_8003f04(slot);
      vramSlots_3001b10.get(slot).size_00.set(1);
    }

    //LAB_8003f98
    //LAB_8003f9a
    return 0;
  }

  /**
   * @return Tile number (see OAM attribute 2)
   */
  @Method(0x8003fa4)
  public static int allocateSpriteSlot(final int slot, final int size, final int newDataPtr) {
    if(slot >= 0x60 || size > 0x2000) {
      return 0;
    }

    final VramSlot04 r7 = vramSlots_3001b10.get(slot);
    final int r5;
    if(r7.size_00.get() <= 0x10) {
      r5 = FUN_8003e58(slot, size);
    } else if(r7.size_00.get() == size) {
      //LAB_8003fd6
      r5 = r7.vramAddr_02.get();
    } else {
      clearVramSlot(slot);
      r5 = FUN_8003e58(slot, size);
    }

    //LAB_8003fe4
    if(r5 == -1) {
      //LAB_800401e
      return 0;
    }

    r7.size_00.set(size);
    r7.vramAddr_02.set(r5); // record the position in vram

    if(newDataPtr != 0) {
      if(newDataPtr == -1) {
        MEMORY.call(0x3000164, 0x6010000 + r5, size); // memzero
      } else {
        //LAB_800400a
        DMA.channels[3].SAD.setu(newDataPtr);
        DMA.channels[3].DAD.setu(0x6010000 + r5);
        DMA.channels[3].CNT.setu(0x84000000 | size / 4);
      }
    }

    //LAB_800401a
    //LAB_8004020
    return r5 >>> 5;
  }

  @Method(0x800403c)
  public static void initVramSlots() {
    //LAB_8004046
    MEMORY.memfill(_3001810.getAddress(), 0x200, 0xff);

    //LAB_800406c
    for(int i = 0; i < 0x60; i++) {
      final VramSlot04 r2 = vramSlots_3001b10.get(i);
      r2.size_00.set(0);
      r2.vramAddr_02.set(0xffff);
    }
  }

  @Method(0x8004080)
  public static int getFreeVramSlot() {
    //LAB_8004094
    for(int i = 0; i < 0x60; i++) {
      if(vramSlots_3001b10.get(i).vramAddr_02.get() == 0xffff) {
        return i;
      }
    }

    //LAB_80040a6
//    return 0x60;
    throw new RuntimeException("Ran out of vram slots");
  }

  @Method(0x80040b4)
  public static int allocateFirstFreeSpriteSlot(final int size) {
    final int slot = getFreeVramSlot();
    allocateSpriteSlot(slot, size, 0);
    return slot;
  }

  @Method(0x80040d0)
  public static int FUN_80040d0(final int vramSlot, final int newDataPtr) {
    return allocateSpriteSlot(vramSlot, vramSlots_3001b10.get(vramSlot).size_00.get(), newDataPtr);
  }

  @Method(0x80040e8)
  public static void clearTickCallbacks() {
    tickCallbacksInitialized_3001d34.set(0);
    _3001a10.set(0);

    //LAB_80040fc
    for(int i = 0; i < 20; i++) {
      final TickCallback08 r1 = tickCallbacks_3001a20.get(i);
      r1.callback_00.clear();
      r1.classAndPriority_04.set(0xffff);
      r1._06.set(0);
    }

    tickCallbacksInitialized_3001d34.set(1);

    //LAB_8004128
  }

  @Method(0x8004144)
  public static void sortTickCallbacks() {
    //LAB_800414e
    for(int r4 = 19; r4 > 1; r4--) {
      //LAB_8004150
      //LAB_8004158
      for(int r0 = 0; r0 < r4; r0++) {
        final TickCallback08 struct1 = tickCallbacks_3001a20.get(r0);
        final TickCallback08 struct2 = tickCallbacks_3001a20.get(r0 + 1);

        if(struct2.classAndPriority_04.get() > struct1.classAndPriority_04.get()) {
          final RunnableRef callback1 = struct1.callback_00.derefNullable();
          final int classAndPriority1 = struct1.classAndPriority_04.get();
          final int _06_1 = struct1._06.get();
          struct1.callback_00.setNullable(struct2.callback_00.derefNullable());
          struct1.classAndPriority_04.set(struct2.classAndPriority_04.get());
          struct1._06.set(struct2._06.get());
          struct2.callback_00.setNullable(callback1);
          struct2.classAndPriority_04.set(classAndPriority1);
          struct2._06.set(_06_1);
        }

        //LAB_800417c
        //LAB_800417e
      }

      //LAB_8004184
    }
  }

  @Method(0x80041d8)
  public static int setTickCallback(@Nullable final RunnableRef callback, final int classAndPriority) {
    final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    int r5 = -1;

    for(int i = 0; i < 20; i++) {
      final TickCallback08 r4 = tickCallbacks_3001a20.get(i);

      if(callback == null && r4.callback_00.isNull() || callback != null && r4.callback_00.getPointer() == callback.getAddress()) {
        r4.classAndPriority_04.set(classAndPriority);
        r5 = i;
        break;
      }
    }

    //LAB_800420c
    if(r5 == -1) {
      //LAB_800423c
      for(int i = 0; i < 20; i++) {
        final TickCallback08 r4 = tickCallbacks_3001a20.get(i);

        if(r4.callback_00.isNull()) {
          r4.callback_00.setNullable(callback);
          r4.classAndPriority_04.set(classAndPriority);
          r4._06.set(0);
          r5 = i;
          break;
        }
      }
    }

    //LAB_8004254
    sortTickCallbacks();
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);

    //LAB_8004268
    return r5;
  }

  @Method(0x8004278)
  public static int clearTickCallback(final RunnableRef r0) {
    final int oldInterrupts = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    int ret = -1;
    for(int i = 0; i < 20; i++) {
      final TickCallback08 r4 = tickCallbacks_3001a20.get(i);

      if(r4.callback_00.getPointer() == r0.getAddress()) {
        r4.callback_00.clear();
        r4.classAndPriority_04.set(0x7fff);
        ret = i;
        break;
      }
    }

    //LAB_80042b0
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts);
    return ret;
  }

  /** Pretty sure this temporarily disables a callback */
  @Method(0x80042c8)
  public static int disableTickCallback(@Nullable final RunnableRef r0) {
    final int r6 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    //LAB_80042dc
    int r5 = -1;
    for(int r1 = 0; r1 < 20; r1++) {
      final TickCallback08 r4 = tickCallbacks_3001a20.get(r1);
      if(r0 == null || r4.callback_00.getPointer() == r0.getAddress()) {
        //LAB_80042e6
        r4.classAndPriority_04.or(0x100); // was actually _05 | 0x1
        r5 = r1;
      }

      //LAB_80042ee
    }

    INTERRUPTS.INT_MASTER_ENABLE.setu(r6);
    return r5;
  }

  @Method(0x800430c)
  public static int disableMapTickCallbacks() {
    final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    //LAB_8004320
    int ret = -1;
    for(int callbackIndex = 0; callbackIndex < 20; callbackIndex++) {
      final TickCallback08 callback = tickCallbacks_3001a20.get(callbackIndex);
      if((callback.callback_00.getPointer() & 0xff00_0000) == 0x200_0000 && (callback._06.get() & 0x1) == 0) {
        callback.classAndPriority_04.or(0x100);
        ret = callbackIndex;
      }

      //LAB_800433a
    }

    INTERRUPTS.INT_MASTER_ENABLE.setu(oldIme);
    return ret;
  }

  /** Pretty sure this re-enables a callback */
  @Method(0x800439c)
  public static int enableTickCallback(final RunnableRef r0) {
    final int r7 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    int r5 = -1;

    //LAB_80043b0
    for(int r1 = 0; r1 < 20; r1++) {
      final TickCallback08 r4 = tickCallbacks_3001a20.get(r1);
      if(r0 == null || r4.callback_00.getPointer() == r0.getAddress()) {
        //LAB_80043ba
        r4.classAndPriority_04.and(~0x100);
        r5 = r1;
      }

      //LAB_80043c4
    }

    INTERRUPTS.INT_MASTER_ENABLE.setu(r7);
    return r5;
  }

  @Method(0x80043e0)
  public static int enableMapTickCallbacks() {
    final int oldIme = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);

    //LAB_80043f4
    int ret = -1;
    for(int callbackIndex = 0; callbackIndex < 20; callbackIndex++) {
      final TickCallback08 r4 = tickCallbacks_3001a20.get(callbackIndex);
      if((r4.callback_00.getPointer() & 0xff00_0000) == 0x200_0000) {
        r4.classAndPriority_04.and(~0x100);
        ret = callbackIndex;
      }

      //LAB_8004404
    }

    INTERRUPTS.INT_MASTER_ENABLE.set(oldIme);
    return ret;
  }

  @Method(0x8004420)
  public static void runTickCallbacks(final int cls) {
    if(tickCallbacksInitialized_3001d34.get() == 1) {
      //LAB_8004434
      for(int r5 = 0; r5 < 20; r5++) {
        final TickCallback08 r6 = tickCallbacks_3001a20.get(r5);

        if((r6.classAndPriority_04.get() & 0xff00) == (cls & 0xff00)) {
          r6.callback_00.deref().run();
        }
      }
    }

    //LAB_800444a
  }

  /** Returns a random 8-bit number */
  @Method(0x8004458)
  public static int rand() {
    return seed_3001cb4.mul(0x41c64e6d).add(0x3039).get() << 8 >>> 16;
  }

  @Method(0x800447c)
  public static void rotVec3(final int distance, final int angle, final Vec3 vec) {
    vec.x_00.add((int)MEMORY.call(0x3000118, distance, cos(angle)));
    vec.z_08.add((int)MEMORY.call(0x3000118, distance, sin(angle)));
  }

  @Method(0x80044d0)
  public static int atan2(int r0, int r1) {
    final int r6 = r0;
    final int r5 = r1;
    int r4 = 0;
    if(r6 != 0) {
      r4 = 0x4000;
      if(r5 != 0) {
        //LAB_80044ea
        //LAB_80044f2
        r1 = divideS(Math.abs(r6) << 8, Math.abs(r5));
        if(r1 <= 0xfb6a) {
          int r2 = 0x8007676;
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r4 = 0;
          r2 -= 0x80;
          if(r1 > r0) {
            r4 = 0x2000;
            r2 += 0x100;
          }

          //LAB_800451a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 -= 0x40;
          if(r1 > r0) {
            r4 = r4 | 0x1000;
            r2 += 0x80;
          }

          //LAB_800452a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 -= 0x20;
          if(r1 > r0) {
            r4 = r4 | 0x800;
            r2 += 0x40;
          }

          //LAB_800453a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 -= 0x10;
          if(r1 > r0) {
            r4 = r4 | 0x400;
            r2 += 0x20;
          }

          //LAB_800454a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 -= 0x8;
          if(r1 > r0) {
            r4 = r4 | 0x200;
            r2 += 0x10;
          }

          //LAB_800455a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 += 0x4;
          if(r1 > r0) {
            r4 = r4 | 0x100;
            r2 += 0x8;
          }

          //LAB_800456a
          r0 = MEMORY.ref(2, r2).getUnsigned();
          r2 -= 0x2;
          if(r1 > r0) {
            r4 = r4 | 0x80;
            r2 += 0x4;
          }

          //LAB_8004578
          if(r1 > MEMORY.ref(2, r2).getUnsigned()) {
            r4 = r4 | 0x40;
          }
        }
      }
    }

    //LAB_8004582
    if(r5 < 0) {
      r4 = 0x8000 - r4;
    }

    //LAB_800458c
    if(r6 < 0) {
      r4 = -r4;
    }

    //LAB_8004592
    return r4 & 0xffff;
  }

  @Method(0x80045d4)
  public static int sqrt16(final int val) {
    return (int)MEMORY.call(0x30001d8, val) << 8;
  }

  @Method(0x80045e8)
  public static int FUN_80045e8() {
    return 0x800779c;
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

  @Method(0x800488c)
  public static int getChipMallocDelta() {
    return 0x3007800 - chipWramMallocHead_3001e54.get();
  }

  @Method(0x80048a0)
  public static int getBoardMallocDelta() {
    return 0x2040000 - boardWramMallocHead_3001e50.get();
  }

  /** Prefers chip WRAM but will overflow into board WRAM */
  @Method(0x80048b0)
  public static int mallocSlotChip(final int slot, int size) {
    final int alreadyAllocated = boardWramMallocHead_3001e50.offset(slot * 0x4).get();
    if(alreadyAllocated != 0) {
      return alreadyAllocated;
    }

    size = size + 0x3 & ~0x3;
    final int chipAddr = chipWramMallocHead_3001e54.get();
    if(chipAddr + size < 0x3007800) {
      chipWramMallocHead_3001e54.setu(chipAddr + size);
      boardWramMallocHead_3001e50.offset(slot * 0x4).setu(chipAddr);
      return chipAddr;
    }

    final int boardAddr = boardWramMallocHead_3001e50.get();
    if(boardAddr + size < 0x2040000) {
      boardWramMallocHead_3001e50.setu(boardAddr + size);
      boardWramMallocHead_3001e50.offset(slot * 0x4).setu(boardAddr);
      return boardAddr;
    }

    return 0;
  }

  /** Prefers board WRAM but will overflow into chip WRAM */
  @Method(0x80048f4)
  public static int mallocSlotBoard(final int slot, int size) {
    final int alreadyAllocated = boardWramMallocHead_3001e50.offset(slot * 0x4).get();
    if(alreadyAllocated != 0) {
      return alreadyAllocated;
    }

    size = size + 0x3 & ~0x3;
    final int boardAddr = boardWramMallocHead_3001e50.get();
    if(boardAddr + size < 0x2040000) {
      boardWramMallocHead_3001e50.setu(boardAddr + size);
      boardWramMallocHead_3001e50.offset(slot * 0x4).setu(boardAddr);
      return boardAddr;
    }

    final int chipAddr = chipWramMallocHead_3001e54.get();
    if(chipAddr + size < 0x3007800) {
      chipWramMallocHead_3001e54.setu(chipAddr + size);
      boardWramMallocHead_3001e50.offset(slot * 0x4).setu(chipAddr);
      return chipAddr;
    }

    return 0;
  }

  /** Prefers chip WRAM but will overflow into board WRAM */
  @Method(0x8004938)
  public static int mallocChip(int size) {
    size = size + 0x3 & ~0x3;

    final int chipAddr = chipWramMallocHead_3001e54.get();
    if(chipAddr + size < 0x3007800) {
      chipWramMallocHead_3001e54.setu(chipAddr + size);
      return chipAddr;
    }

    final int boardAddr = boardWramMallocHead_3001e50.get();
    if(boardAddr + size < 0x2040000) {
      boardWramMallocHead_3001e50.setu(boardAddr + size);
      return boardAddr;
    }

    return 0;
  }

  /** Prefers board WRAM but will overflow into chip WRAM */
  @Method(0x8004970)
  public static int mallocBoard(int size) {
    size = size + 0x3 & ~0x3;

    final int boardAddr = boardWramMallocHead_3001e50.get();
    if(boardAddr + size < 0x2040000) {
      boardWramMallocHead_3001e50.setu(boardAddr + size);
      return boardAddr;
    }

    final int chipAddr = chipWramMallocHead_3001e54.get();
    if(chipAddr + size < 0x3007800) {
      chipWramMallocHead_3001e54.setu(chipAddr + size);
      return chipAddr;
    }

    return 0;
  }

  @Method(0x80049ac)
  public static void initMatrixStack() {
    matrixStackDepth_3001cc4.set(0);
    _3001d2c.set(mallocSlotBoard(2, 0x30));
    transforms_3000350.identity();
  }

  @Method(0x80049e8)
  public static void pushMatrix() {
    if(matrixStackDepth_3001cc4.get() < 1) {
      DMA.channels[3].SAD.setu(0x3000350);
      DMA.channels[3].DAD.setu(_3001d2c.get());
      DMA.channels[3].CNT.setu(0x8400000c);
      matrixStackDepth_3001cc4.incr();
      _3001d2c.add(0x30);
    }
  }

  @Method(0x8004a5c)
  public static void popMatrix() {
    if(matrixStackDepth_3001cc4.get() > 0) {
      matrixStackDepth_3001cc4.decr();
      _3001d2c.sub(0x30);
      DMA.channels[3].SAD.setu(_3001d2c.get());
      DMA.channels[3].DAD.setu(transforms_3000350.getAddress());
      DMA.channels[3].CNT.setu(0x8400000c);
    }
  }

  @Method(0x8004bd4)
  public static void rotateMatrixX(final int angle) {
    mulTransforms(new Matrix30().rotationX(angle));
  }

  @Method(0x8004c1c)
  public static void rotateMatrixY(final int angle) {
    mulTransforms(new Matrix30().rotationY(angle));
  }

  @Method(0x8004c6c)
  public static void rotateMatrixZ(final int angle) {
    mulTransforms(new Matrix30().rotationZ(angle));
  }

  @Method(0x8004cb4)
  public static void translateMatrix(final Vec3 translation) {
    mulTransforms(new Matrix30().translation(translation));
  }

  @Method(0x8004fe4)
  public static void FUN_8004fe4(final Vec3 center, final Vec3 eye, final Matrix30 out) {
    int r3;
    int r6;
    int r7;
    final int r8;
    int r10;

    int dirX = eye.getX() - center.getX();
    int dirY = eye.getY() - center.getY();
    int dirZ = eye.getZ() - center.getZ();

    // Normalize direction
    final int invDirLen = -(divideU(0x80000000, sqrt(mulAdd3(dirX >> 8, dirX >> 8, dirY >> 8, dirY >> 8, dirZ >> 8, dirZ >> 8))) >>> 15);
    dirX = mul16(dirX, invDirLen);
    dirY = mul16(dirY, invDirLen);
    dirZ = mul16(dirZ, invDirLen);

    final int r0 = 0x10000 - mul16(dirY, dirY);
    if(r0 > 0) {
      r3 = divideU(0x80000000, sqrt16(r0)) * 2;
    } else {
      r3 = 0x10000;
    }

    //LAB_80050a6
    final int sp10 = mul16(dirZ, r3);
    r8 = mul16(-dirX, r3);
    r10 = mul16(dirY, r8);
    r6 = mul16(dirZ, sp10) - mul16(dirX, r8);
    r7 = -mul16(dirY, sp10);
    r3 = divideU(0x80000000, sqrt16(mulAdd3(r10, r10, r6, r6, r7, r7))) * 2;
    r10 = mul16(r10, r3);
    r6 = mul16(r6, r3);
    r7 = mul16(r7, r3);
    out.set(0, sp10);
    out.set(1, r10);
    out.set(2, dirX);
    out.set(3, 0);
    out.set(4, r6);
    out.set(5, dirY);
    out.set(6, r8);
    out.set(7, r7);
    out.set(8, dirZ);
    out.set(9, -mulAdd3(center.getX(), sp10, center.getZ(), r8, 0, 0));
    out.set(10, -mulAdd3(center.getX(), r10, center.getY(), r6, center.getZ(), r7));
    out.set(11, -mulAdd3(center.getX(), dirX, center.getY(), dirY, center.getZ(), dirZ));
  }

  @Method(0x80051d8)
  public static void FUN_80051d8(final Vec3 r0, final Vec3 r1) {
    FUN_8004fe4(r0, r1, transforms_3000350);
  }

  @Method(0x80051e8)
  public static void FUN_80051e8(final Vec3 r0, final Vec3 r1) {
    final Matrix30 r5 = new Matrix30();
    FUN_8004fe4(r0, r1, r5);
    mulTransforms(r5);
  }

  @Method(0x8005258)
  public static void FUN_8005258(final int x, final int y, final int z) {
    final int r3 = 0x3001ce0;
    MEMORY.ref(4, r3).setu(x);
    MEMORY.ref(4, r3 + 0x4).setu(y);
    MEMORY.ref(4, r3 + 0x8).setu(z);
  }

  @Method(0x8005268)
  public static int FUN_8005268(final Vec3 in, final Vec3 out) {
    transformVector(in, out);
    final int r3 = out.getZ();
    final int r7 = 0x3001ce0;

    if(-r3 < MEMORY.ref(4, r7 + 0x4).get() || -r3 > MEMORY.ref(4, r7 + 0x8).get()) {
      return 0;
    }

    out.setZ(-r3 >> 16);

    final int r4;
    if(MEMORY.ref(4, r7).get() != 0) {
      r4 = divideU(MEMORY.ref(4, r7).get() << 5, -r3 >>> 11);
    } else {
      //LAB_800529e
      r4 = 0x151eb;
    }

    //LAB_80052a0
    out.setX(MEMORY.ref(4, r7 + 0xc).get() + (int)MEMORY.call(0x3000118, out.getX(), r4) / 0x10000);
    out.setY(MEMORY.ref(4, r7 + 0x10).get() - (int)MEMORY.call(0x3000118, out.getY(), r4) / 0x10000);
    return r4;
  }

  @Method(0x8005340)
  public static int decompress(final int src, final int dst) {
    // Copy decompression routine into system memory
    final int size = 0x2c4;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8002544);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, Decompressor.class, "decompress", int.class, int.class);

    // Decompress
    final int decompressedSize = (int)MEMORY.call(addr, src, dst);

    setMallocAddress(addr);

    if(src == 0x8779188 && dst == 0x2008000) {
      MEMORY.addFunctions(Decompressed8779188.class);
    } else if(src == 0x87795e8 && dst == 0x2008000) {
      MEMORY.addFunctions(Decompressed87795e8.class);
    }

    return decompressedSize;
  }

  @Method(0x8005394)
  public static int decompressImage(final int src, final int dst) {
    final int size = 0x4ec;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8002808);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3006000 -> MEMORY.addFunctions(CopiedSegment8002808.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    final int ret = (int)MEMORY.call(addr, src, dst);
    setMallocAddress(addr);

    return ret;
  }

  @Method(0x80053e8)
  public static int FUN_80053e8(final int src, final int dest) {
    final int size = 0x258;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x8001b70);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 0x4);

    MEMORY.setFunction(addr, CopiedSegment8001b70.class, "FUN_8001b70", int.class, int.class);
    final int ret = (int)MEMORY.call(addr, src, dest);
    setMallocAddress(addr);

    return ret;
  }

  @Method(0x800543c)
  public static void FUN_800543c(final int r0, final int r1, final int r2, final int r3) {
    final int oldSp = CPU.sp().value;
    CPU.sp().value -= 0x84;
    DMA.channels[3].SAD.setu(0x8001fb8);
    DMA.channels[3].DAD.setu(CPU.sp().value);
    DMA.channels[3].CNT.setu(0x84000021);
    MEMORY.call(CPU.sp().value, r0, r1, r2, r3);
    CPU.sp().value = oldSp;
  }

  @Method(0x8005490)
  public static void FUN_8005490(final int r0, final int r1, final int r2, final int r3) {
    final int oldSp = CPU.sp().value;
    CPU.sp().value -= 0x80;
    DMA.channels[3].SAD.setu(0x8001f38);
    DMA.channels[3].DAD.setu(CPU.sp().value);
    DMA.channels[3].CNT.setu(0x84000020);
    MEMORY.call(CPU.sp().value, r0, r1, r2, r3);
    CPU.sp().value = oldSp;
  }

  @Method(0x80054e4)
  public static void FUN_80054e4(final int r0, final int r1, final int r2) {
    final int oldSp = CPU.sp().value;
    CPU.sp().value -= 0x50;
    DMA.channels[3].SAD.setu(0x8001ea8);
    DMA.channels[3].DAD.setu(CPU.sp().value);
    DMA.channels[3].CNT.setu(0x84000014);
    MEMORY.setFunction(CPU.sp().value, GoldenSun.class, "FUN_8001ea8", int.class, int.class, int.class);
    MEMORY.call(CPU.sp().value, r0, r1, r2);
    CPU.sp().value = oldSp;
  }

  @Method(0x8005534)
  public static void FUN_8005534(final int r0, final int r1, final int r2) {
    final int oldSp = CPU.sp().value;
    CPU.sp().value -= 0x40;
    DMA.channels[3].SAD.setu(0x8001ef8);
    DMA.channels[3].DAD.setu(CPU.sp().value);
    DMA.channels[3].CNT.setu(0x84000010);
    MEMORY.setFunction(CPU.sp().value, GoldenSun.class, "FUN_8001ef8", int.class, int.class, int.class);
    MEMORY.call(CPU.sp().value, r0, r1, r2);
    CPU.sp().value = oldSp;
  }

  /** @return 1 if it fails to initialize SRAM, 0 otherwise */
  @Method(0x80056cc)
  public static int loadSaveList() {
    final SaveStruct1100 r11 = MEMORY.ref(4, mallocSlotBoard(51, 0x1100), SaveStruct1100::new);
    MEMORY.memfill(r11.getAddress(), 0x1100, 0);

    FUN_80069c8(2, 0x30000f4);

    //LAB_8005704
    //LAB_800570c
    int r7 = 0;
    while(loadSramHandler() != 0) {
      sleep(1);
      r7++;

      if(r7 > 7) {
        //LAB_800571c
        return 1;
      }
    }

    //LAB_800572c
    //LAB_8005748
    for(int saveSlot = 0; saveSlot < 16; saveSlot++) {
      r11._00.get(saveSlot).set(0);
      r11._10.get(saveSlot).set(0x10);
      r11._20.get(saveSlot).set(0);

      final int checksumDiff = loadSave(saveSlot);
      final SaveStruct1100.Sub10 r8 = r11._40;

      if(compareBytes(r8.camelot_00.getAddress(), 0x80079b0, 7) == 0) { // CAMELOT
        r11._20.get(saveSlot).set(r8._0a.get());

        final int r2 = r8._07.get();
        if(r2 < 16) {
          if(checksumDiff == 0) {
            r11._00.get(saveSlot).set(1);
            r11._10.get(saveSlot).set(r2);

            //LAB_80057c8
            for(int r5 = 0; r5 < saveSlot; r5++) {
              if(r11._10.get(r5).get() == r2) {
                if(r11._20.get(r5).get() < r8._0a.get()) {
                  r11._00.get(r5).set(0);
                } else {
                  //LAB_80057de
                  r11._00.get(saveSlot).set(0);
                }
              }

              //LAB_80057e0
            }
          }
        }
      }

      //LAB_80057ea
    }

    //LAB_80057fc
    return 0;
  }

  @Method(0x8005810)
  public static int getRandomAvailableSaveSlot(final int r0) {
    final SaveStruct1100 r2 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    final int[] availableSlots = new int[0x10];

    //LAB_800581e
    int availableSlotCount = 0;
    for(int i = 0; i < 0x10; i++) {
      if(r2._00.get(i).get() == 0) {
        availableSlots[availableSlotCount] = i;
        availableSlotCount++;
      }

      //LAB_800582a
    }

    if(availableSlotCount > 1) {
      //LAB_8005848
      return availableSlots[modU(rand(), availableSlotCount)];
    }

    if(availableSlotCount != 0 && getSaveSlot(r0) != 0x10) {
      return availableSlots[0];
    }

    //LAB_800585a
    return 0x10;
  }

  /** Returns true if there's a problem with the save data */
  @Method(0x8005868)
  public static boolean writeSector(final int saveSlot) {
    final int r6 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new)._40.getAddress(); //TODO
    SRAM.directWrite(saveSlot, r6);
    return false;

/*
    if((short)(int)writeSectorPtr_2004c04.deref().run(saveSlot, r6) != 0) {
      return true;
    }

    //LAB_800588c
    //LAB_800589c
    return verifySram(saveSlot, r6) != 0;
*/
  }

  /** @return difference between calculated checksum and checksum stored with save */
  @Method(0x80058ac)
  public static int loadSave(final int saveSlot) {
    final SaveStruct1100.Sub10 r5 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new)._40;
    readFromSram(saveSlot, 0, r5.getAddress(), 0x1000);
    return (calcSaveChecksum() & 0xffff) - r5.checksum_08.get();
  }

  @Method(0x8005920)
  public static int saveGame(final int saveFile, final int gameStatePtr) {
    final SaveStruct1100 r10 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    MEMORY.memfill(r10._40.getAddress(), 0x1000, 0);

    final int saveSlot = getSaveSlot(saveFile);
    int r6 = getRandomAvailableSaveSlot(saveFile);
    if(r6 > 0xf) {
      return 1;
    }

    DMA.channels[3].SAD.setu(gameStatePtr);
    DMA.channels[3].DAD.setu(r10._50.getAddress());
    DMA.channels[3].CNT.setu(0x840003fc); // 0xff0 bytes

    //LAB_8005982
    while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
      DebugHelper.sleep(0);
    }

    MEMORY.memcpy(r10._40.camelot_00.getAddress(), 0x80079b8, 8); // CAMELOTT
    r10._40._07.set(saveFile);
    r10._40.checksum_08.set(calcSaveChecksum());
    r10._40._0a.set(FUN_8005c2c(saveFile) + 1);

    if(writeSector(r6) || saveSlot < 0x10 && FUN_8005b64(saveSlot) != 0) {
      return 1;
    }

    //LAB_80059ec
    if(r10._40._0a.get() > 65000) {
      r10._40._0a.set(0x1);

      if(writeSector(saveSlot) || FUN_8005b64(r6) != 0) {
        return 1;
      }

      //LAB_8005a2a
      r6 = saveSlot;
    }

    //LAB_8005a2c
    r10._00.get(r6).set(0x1);
    r10._10.get(r6).set(saveFile);
    r10._20.get(r6).set(r10._40._0a.get());

    //LAB_8005a46
    return 0;
  }

  @Method(0x8005a78)
  public static int FUN_8005a78(final int saveFile, final int r1) {
    final SaveStruct1100 r5 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);

    final int saveSlot = getSaveSlot(saveFile);
    if(saveSlot > 0xf) {
      return 1;
    }

    //LAB_8005a8c
    loadSave(saveSlot);

    DMA.channels[3].SAD.setu(r5._50.getAddress());
    DMA.channels[3].DAD.setu(r1);
    DMA.channels[3].CNT.setu(0x840003fc); // 0xff0 bytes

    //LAB_8005aa4
    while((DMA.channels[3].CNT.get() & 0x80000000) != 0) {
      DebugHelper.sleep(0);
    }

    //LAB_8005aae
    return 0;
  }

  @Method(0x8005ae0)
  public static int calcSaveChecksum() {
    int r0 = 0;

    //LAB_8005af0
    for(int r1 = 0; r1 < 0x1fd; r1++) {
      final int r2 = boardWramMallocHead_3001e50.offset(51 * 0x4).get() + 0x50 + r1 * 0x8;
      r0 = r0 + MEMORY.ref(1, r2).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x1).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x2).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x3).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x4).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x5).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x6).getUnsigned();
      r0 = r0 + MEMORY.ref(1, r2 + 0x7).getUnsigned();
    }

    return r0;
  }

  @Method(0x8005b24)
  public static int getSaveSlot(final int r0) {
    final SaveStruct1100 r2 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    int r5 = 0x10;
    int r0_0 = 0;

    //LAB_8005b38
    for(int r4 = 0; r4 < 16; r4++) {
      if(r2._00.get(r4).get() != 0) {
        if(r0 == r2._10.get(r4).get()) {
          final int r3 = r2._20.get(r4).get();
          if(r0_0 < r3) {
            r0_0 = r3;
            r5 = r4;
          }
        }
      }

      //LAB_8005b4e
    }

    return r5;
  }

  @Method(0x8005b64)
  public static int FUN_8005b64(final int r0) {
    final SaveStruct1100 r6 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    MEMORY.memfill(r6._40.getAddress(), 0x10, 0);
    MEMORY.memcpy(r6._40.getAddress(), 0x80079b8, 0x8); // Camelott
    r6._40._07.set(0x10);
    r6._40._0a.set(0);

    if(writeSector(r0)) {
      return 1;
    }

    //LAB_8005bd6
    r6._00.get(r0).set(0);
    r6._10.get(r0).set(0x10);
    r6._20.get(r0).set(0);

    //LAB_8005be8
    return 0;
  }

  @Method(0x8005c08)
  public static int compareBytes(int r0, int r1, int len) {
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

  @Method(0x8005c2c)
  public static int FUN_8005c2c(final int r0) {
    final SaveStruct1100 r3 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    int ret = 0;

    //LAB_8005c3e
    for(int r4 = 0; r4 < 0x10; r4++) {
      if(r3._00.get(r4).get() != 0) {
        if(r0 == r3._10.get(r4).get()) {
          ret = Math.max(ret, r3._20.get(r4).get());
        }
      }

      //LAB_8005c52
    }
    return ret;
  }

  @Method(0x8005c68)
  public static int loadSavePreview() {
    final SaveStruct1100 saveStruct = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    int saveCount = 0;

    //LAB_8005c86
    for(int saveFile = 0; saveFile < 3; saveFile++) {
      final SaveStruct1100.Preview40 r5 = saveStruct._1040.get(saveFile);
      MEMORY.memfill(r5.getAddress(), 0x40, 0);

      int saveSlot = getSaveSlot(saveFile);
      if(saveSlot < 16) {
        readFromSram(saveSlot, 0, r5.getAddress(), 0x40);
        saveCount++;
      }

      //LAB_8005cb2
      saveSlot = getSaveSlot(saveFile + 3);
      if(saveSlot < 16) {
        readFromSram(saveSlot, 0x110, r5._38.getAddress(), 0x4);
      } else {
        //LAB_8005cd0
        r5._38.set(0);
      }

      //LAB_8005cd4
    }

    return saveCount;
  }

  @Method(0x8005cf8)
  public static void unloadSaveList() {
    setInterruptHandler(5, 0, null);
    freeSlot(51);
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
  public static int getSramManufacturerAndDevice() {
    CPU.sp().value -= 0x40;
    FUN_8006ac0(CPU.sp().value);
    final int r5 = CPU.sp().value + 0x1;
    MEMORY.ref(1, 0xe005555).setu(0xaa);
    MEMORY.ref(1, 0xe002aaa).setu(0x55);
    MEMORY.ref(1, 0xe005555).setu(0x90);

    final int r4 = ((int)MEMORY.call(r5, 0xe000001) & 0xff) << 8 | (int)MEMORY.call(r5, 0xe000000) & 0xff;

    MEMORY.ref(1, 0xe005555).setu(0xaa);
    MEMORY.ref(1, 0xe002aaa).setu(0x55);
    MEMORY.ref(1, 0xe005555).setu(0xf0);

    CPU.sp().value += 0x40;
    return r4;
  }

  @Method(0x8006910)
  public static int loadSramHandler() {
    INTERRUPTS.WAITCNT.and(0xfffc).oru(0x3);
    final int r3 = getSramManufacturerAndDevice() & 0xffff;

    for(int i = 0; i < 5; i++) {
      final SramTypeStruct r2 = _8007a0c.get(i).deref();

      if(r2._28.get() == r3) {
        writeSectorPtr_2004c04.set(r2._00.deref());
        _2004c10.set(r2._04.get());
        _2004c14.set(r2._08.get());
        _2004c00.set(r2._0c.deref());
        _2004c18.set(r2._10.get());
        _2004c08.set(r2._14.getAddress()); //TODO
        return 0;
      }
    }

    return 1;
  }

  @Method(0x80069a4)
  public static void FUN_80069a4() {
    if(_2004c22.get() != 0) {
      _2004c22.decr();
      if(_2004c22.get() == 0) {
        _2004c24.set(0x1);
      }
    }

    //LAB_80069be
  }

  @Method(0x80069c8)
  public static int FUN_80069c8(int timerIndex, final int r1) {
    timerIndex = timerIndex & 0xff;

    if(timerIndex > 3) {
      //LAB_80069fc
      return 1;
    }

    timerIndex_2004c20.set(timerIndex);
    timerCntLPtr_2004c28.set(TIMERS.timers[timerIndex].CNT_L.getAddress());
    MEMORY.ref(4, r1).setu(0x80069a5);

    //LAB_80069fe
    return 0;
  }

  @Method(0x8006a00)
  public static void FUN_8006a00(final int r0) {
    final int r2 = _2004c18.get() + r0 * 0x6;
    oldInterrupts_2004c2c.set(INTERRUPTS.INT_MASTER_ENABLE.getUnsigned());
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);
    INTERRUPTS.INT_ENABLE.oru(8 << timerIndex_2004c20.get());
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x1);
    _2004c24.set(0);
    _2004c22.set(MEMORY.ref(2, r2).getUnsigned());
    final int timerAddr = timerCntLPtr_2004c28.get();
    MEMORY.ref(2, timerAddr).setu(MEMORY.ref(2, r2 + 0x2).getUnsigned());
    MEMORY.ref(2, timerAddr + 0x2).setu(MEMORY.ref(2, r2 + 0x4).getUnsigned());
  }

  @Method(0x8006a78)
  public static void FUN_8006a78() {
    final int timerAddr = timerCntLPtr_2004c28.get();
    MEMORY.ref(2, timerAddr).setu(0);
    MEMORY.ref(2, timerAddr + 0x2).setu(0);
    INTERRUPTS.INT_MASTER_ENABLE.setu(0);
    INTERRUPTS.INT_ENABLE.and(~(8 << timerIndex_2004c20.get()));
    INTERRUPTS.INT_MASTER_ENABLE.setu(oldInterrupts_2004c2c.get());
  }

  @Method(0x8006abc)
  public static int FUN_8006abc(final int r0) {
    return MEMORY.ref(1, r0).getUnsigned();
  }

  /** Copies {@link #FUN_8006abc} to r0 */
  @Method(0x8006ac0)
  public static void FUN_8006ac0(final int r0) {
    readOneByteFromPtr_2004c1c.setPointer(r0 + 0x1);

    //LAB_8006ae4
    for(int i = 0; i < 2; i++) {
      MEMORY.ref(2, r0 + i * 0x2).setu(MEMORY.ref(2, 0x8006abc + i * 0x2).getUnsigned());
    }

    MEMORY.setFunction(r0, GoldenSun.class, "FUN_8006abc", int.class);
  }

  @Method(0x8006af8)
  public static int FUN_8006af8(final int r0, final int sramPtr, final int data) {
    FUN_8006a00(r0 & 0xff);

    //LAB_8006b48
    do {
      if((readOneByteFromPtr_2004c1c.deref().run(sramPtr) & 0xff) == data) {
        FUN_8006a78();
        return 0;
      }
    } while(_2004c24.get() == 0);

    int r8 = 0;
    if((readOneByteFromPtr_2004c1c.deref().run(sramPtr) & 0xff) != data) {
      //LAB_8006b24
      final int r1_0 = _2004c08.get();
      if(MEMORY.ref(2, r1_0 + 0x14).getUnsigned() == 0x1cc2) { // Macronix, unsure what this is doing but we don't need it
        MEMORY.ref(1, 0xe005555).setu(0xf0);
      }

      //LAB_8006b36
      r8 = r0 & 0xff | 0xc000;
    }

    //LAB_8006b70
    FUN_8006a78();
    return r8;
  }

  @Method(0x8006b84)
  public static void FUN_8006b84(final int src, final int dest, final int size) {
    //LAB_8006b92
    for(int i = 0; i < size; i++) {
      MEMORY.ref(1, dest + i).setu(MEMORY.ref(1, src + i).getUnsigned());
    }

    //LAB_8006ba0
  }

  @Method(0x8006ba8)
  public static void readFromSram(final int saveSlot, final int offset, final int dest, final int size) {
    CPU.sp().value -= 0x80;
    INTERRUPTS.WAITCNT.and(0xfffc).oru(0x3);

    MEMORY.memcpy(CPU.sp().value, 0x8006b84, 0x24);
    MEMORY.setFunction(CPU.sp().value, GoldenSun.class, "FUN_8006b84", int.class, int.class, int.class);

    MEMORY.call(CPU.sp().value + 0x1, 0xe000000 + ((saveSlot & 0xffff) << MEMORY.ref(1, 0x8007ad8).getUnsigned()) + offset, dest, size);
    CPU.sp().value += 0x80;
  }

  @Method(0x8006c24)
  public static int FUN_8006c24(final int src, final int dest, final int size) {
    //LAB_8006c3a
    for(int i = 0; i < size; i++) {
      if(MEMORY.ref(1, dest + i).getUnsigned() != MEMORY.ref(1, src + i).getUnsigned()) {
        return dest + i;
      }

      //LAB_8006c54
    }

    //LAB_8006c5e
    //LAB_8006c60
    return 0;
  }

  /** Compares SRAM sector with src and returns address of the first difference (or 0 if no differences) */
  @Method(0x8006c68)
  public static int verifySram(final int saveSlot, final int src) {
    CPU.sp().value -= 0x100;
    INTERRUPTS.WAITCNT.oru(0x3);

    //LAB_8006ca4
    //LAB_8006cb0
    for(int i = 0; i < 0x22; i++) {
      MEMORY.ref(2, CPU.sp().value + i * 0x2).setu(MEMORY.ref(2, 0x8006c24 + i * 0x2).getUnsigned());
    }

    MEMORY.setFunction(CPU.sp().value, GoldenSun.class, "FUN_8006c24", int.class, int.class, int.class);

    final int ret = (int)MEMORY.call(CPU.sp().value + 0x1, src, 0xe000000 + (saveSlot << MEMORY.ref(1, 0x8007ad8).getUnsigned()), MEMORY.ref(2, 0x8007ad4).getUnsigned());
    CPU.sp().value += 0x100;
    return ret;
  }

  @Method(0x8006d50)
  public static int eraseSector(final int sector) {
    CPU.sp().value -= 0x40;

    final int ret;
    if(sector < 0x10) {
      final int r2 = _2004c08.get();
      INTERRUPTS.WAITCNT.and(~0x3).oru(MEMORY.ref(2, r2 + 0x10).getUnsigned());
      final int sramSectorPtr = 0xe000000 + (sector << MEMORY.ref(1, r2 + 0x8).getUnsigned());

      // erase sector
      MEMORY.ref(1, 0xe005555).setu(0xaa);
      MEMORY.ref(1, 0xe002aaa).setu(0x55);
      MEMORY.ref(1, 0xe005555).setu(0x80); // erase
      MEMORY.ref(1, 0xe005555).setu(0xaa);
      MEMORY.ref(1, 0xe002aaa).setu(0x55);
      MEMORY.ref(1, sramSectorPtr).setu(0x30); // sector n

      FUN_8006ac0(CPU.sp().value);
      ret = _2004c00.deref().run(0x2, sramSectorPtr, 0xff) & 0xffff;
      INTERRUPTS.WAITCNT.oru(0x3);
    } else {
      //LAB_8006dd8
      ret = 0x80ff;
    }

    //LAB_8006dda
    CPU.sp().value += 0x40;
    return ret;
  }

  @Method(0x8006dec)
  public static int writeByteToSram(final int dataPtr, final int sramPtr) {
    final int data = MEMORY.ref(1, dataPtr).getUnsigned();
    MEMORY.ref(1, 0x0e005555).setu(0xaa);
    MEMORY.ref(1, 0xe002aaa).setu(0x55);
    MEMORY.ref(1, 0x0e005555).setu(0xa0);
    MEMORY.ref(1, sramPtr).setu(data);
    return _2004c00.deref().run(0x1, sramPtr, data) & 0xffff;
  }

  @Method(0x8006e24)
  public static int writeSectorSst(final int sector, final int dataPtr) {
    int r4;
    int r5;
    final int r6;

    if(sector >= 0x10) {
      return 0x80ff;
    }

    CPU.sp().value -= 0x60;

    //LAB_8006e44
    final int sectorPtr = 0xe000000 + (sector << MEMORY.ref(1, _2004c08.get() + 0x8).getUnsigned());

    //LAB_8006e70
    //LAB_8006e7a
    MEMORY.memcpy(CPU.sp().value, getMethodAddress(GoldenSun.class, "verifySectorErased", int.class), 0x24);
    MEMORY.setFunction(CPU.sp().value, GoldenSun.class, "verifySectorErased", int.class);

    r4 = 0;

    //LAB_8006e86
    //LAB_8006e90
    while((r5 = eraseSector(sector) & 0xffff) != 0 || (r5 = FUN_8006f6c(sectorPtr, CPU.sp().value + 0x1) & 0xffff) != 0) {
      r4++;
      if(r4 == 0x51) {
        CPU.sp().value += 0x60;
        return r5;
      }
    }

    if(r4 != 0) {
      r6 = 0x6;
    } else {
      r6 = 0x1;
    }

    //LAB_8006eb8
    r4 = 0x1;

    //LAB_8006ebe
    while(r4 <= r6) {
      eraseSector(sector);
      r4++;
    }

    //LAB_8006ece
    FUN_8006ac0(CPU.sp().value);

    final int sramInfo = _2004c08.get();
    INTERRUPTS.WAITCNT.and(~0x3).oru(MEMORY.ref(2, sramInfo + 0x10).getUnsigned());

    _2004c0c.set(MEMORY.ref(4, sramInfo + 0x4).get());
    //LAB_8006f00
    for(int i = 0; _2004c0c.get() > 0 && (r5 = writeByteToSram(dataPtr + i, sectorPtr + i) & 0xffff) == 0; i++) {
      _2004c0c.decr();
    }

    //LAB_8006f22
    INTERRUPTS.WAITCNT.and(0xfffc).oru(0x3);

    //LAB_8006f32
    CPU.sp().value += 0x60;
    return r5;
  }

  @Method(0x8006f48)
  public static int verifySectorErased(final int r0) {
    int r2 = r0;
    int r1 = MEMORY.ref(4, _2004c08.get() + 0x4).get();

    //LAB_8006f58
    //LAB_8006f5a
    while(r1 > 0 && MEMORY.ref(1, r2++).getUnsigned() == 0xff) {
      r1--;
    }

    //LAB_8006f66
    return r1;
  }

  @Method(0x8006f6c)
  public static int FUN_8006f6c(final int r0, final int r1) {
    if((int)MEMORY.call(r1, r0) == 0) {
      return 0;
    }

    //LAB_8006f7a
    //LAB_8006f7c
    return 0x8004;
  }

  @Method(0x8007994)
  public static int mulAdd3(final int a0, final int b0, final int a1, final int b1, final int a2, final int b2) {
    return (int)((long)a0 * b0 + (long)a1 * b1 + (long)a2 * b2 >>> 16);
  }

  /** {@link GoldenSun#drawSprite} */
  @Method(0x8009008)
  public static void drawSprite_(final Sprite38 sprite, final int r1, final int r2, final int angle) {
    MEMORY.call(0x800b168, sprite, r1, r2, angle);
  }

  /** {@link GoldenSun#setSpriteAnimation} */
  @Method(0x8009020)
  public static int setSpriteAnimation_(final Sprite38 sprite, final int animation) {
    return (int)MEMORY.call(0x800ba30, sprite, animation);
  }

  /** {@link GoldenSun#loadSprite} */
  @Method(0x8009030)
  public static Sprite38 loadSprite_(final int spriteDataIndex) {
    return (Sprite38)MEMORY.call(0x800bc70, spriteDataIndex);
  }

  /** {@link GoldenSun#clearSprite} */
  @Method(0x8009038)
  public static void clearSprite_(final Sprite38 r0) {
    MEMORY.call(0x800bdd4, r0);
  }

  /** {@link GoldenSun#addLayerToSprite} */
  @Method(0x8009048)
  public static SpriteLayer18 addLayerToSprite_(final Sprite38 sprite, final int spriteDataIndex) {
    return (SpriteLayer18)MEMORY.call(0x800b8ac, sprite, spriteDataIndex);
  }

  /** {@link GoldenSun#FUN_800b93c} */
  @Method(0x8009050)
  public static void FUN_8009050(final Sprite38 sprite, final SpriteLayer18 spriteLayer) {
    MEMORY.call(0x800b93c, sprite, spriteLayer);
  }

  /** {@link GoldenSun#FUN_800b9f4} */
  @Method(0x8009070)
  public static void FUN_8009070(final SpriteLayer18 layer, final int r1) {
    MEMORY.call(0x800b9f4, layer, r1);
  }

  /** {@link GoldenSun#initActors} */
  @Method(0x8009078)
  public static void initActors_(final int r0) {
    MEMORY.call(0x800c004, r0);
  }

  /** {@link GoldenSun#setActorAnimation} */
  @Method(0x8009080)
  public static void setActorAnimation_(final Actor70 actor, final int animationIndex) {
    MEMORY.call(0x800c300, actor, animationIndex);
  }

  /** {@link GoldenSun#FUN_800c344} */
  @Method(0x8009088)
  public static void FUN_8009088(final Actor70 actor, final int r1) {
    MEMORY.call(0x800c344, actor, r1);
  }

  /** {@link GoldenSun#setActorSpriteScript} */
  @Method(0x8009098)
  public static void setActorSpriteScript_(final Actor70 actor, final int script) {
    MEMORY.call(0x800c2d8, actor, script);
  }

  /** {@link GoldenSun#FUN_800c48c} */
  @Method(0x80090a0)
  public static void FUN_80090a0(final Actor70 actor) {
    MEMORY.call(0x800c48c, actor);
  }

  /** {@link GoldenSun#FUN_800c49c} */
  @Method(0x80090a8)
  public static void FUN_80090a8(final Actor70 actor) {
    MEMORY.call(0x800c49c, actor);
  }

  /** {@link GoldenSun#FUN_800c47c} */
  @Method(0x80090b0)
  public static void FUN_80090b0(final Actor70 actor) {
    MEMORY.call(0x800c47c, actor);
  }

  /** {@link GoldenSun#FUN_800c46c} */
  @Method(0x80090b8)
  public static void FUN_80090b8(final Actor70 actor) {
    MEMORY.call(0x800c46c, actor);
  }

  /** {@link GoldenSun#loadActor} */
  @Method(0x80090c8)
  public static Actor70 loadActor_(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    return (Actor70)MEMORY.call(0x800c150, spriteTypeAndDataIndex, x, y, z);
  }

  /** {@link GoldenSun#clearActor} */
  @Method(0x80090d0)
  public static void clearActor_(final Actor70 r0) {
    MEMORY.call(0x800c0f4, r0);
  }

  /** {@link GoldenSun#FUN_800c4bc} */
  @Method(0x80090e0)
  public static void FUN_80090e0(final Actor70 r0, final Actor70 r1) {
    MEMORY.call(0x800c4bc, r0, r1);
  }

  /** {@link GoldenSun#setActorPosition} */
  @Method(0x80090f0)
  public static void setActorPosition_(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x800d130, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_800be70} */
  @Method(0x80090f8)
  public static void FUN_80090f8(final int r0, final int r1) {
    MEMORY.call(0x800be70, r0, r1);
  }

  /** {@link GoldenSun#loadMap} */
  @Method(0x8009110)
  public static int loadMap_(final int index) {
    return (int)MEMORY.call(0x800fb38, index);
  }

  /** {@link GoldenSun_801#FUN_80109e8} */
  @Method(0x8009118)
  public static void FUN_8009118() {
    MEMORY.call(0x80109e8);
  }

  /** {@link GoldenSun#FUN_800fe9c} */
  @Method(0x8009128)
  public static void FUN_8009128() {
    MEMORY.call(0x800fe9c);
  }

  @Method(0x8009130)
  public static void FUN_8009130() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8009138)
  public static void FUN_8009138(final int r0, final int r1) {
    throw new RuntimeException("Not implemented");
  }

  /** {@link GoldenSun#FUN_800c4ac} */
  @Method(0x8009140)
  public static void FUN_8009140(final Actor70 r0) {
    MEMORY.call(0x800c4ac, r0);
  }

  /** {@link GoldenSun#FUN_800c4ec} */
  @Method(0x8009148)
  public static void FUN_8009148(final Actor70 r0) {
    MEMORY.call(0x800c4ec, r0);
  }

  /** {@link GoldenSun#FUN_800d14c} */
  @Method(0x8009150)
  public static void FUN_8009150(final Actor70 actor, final int x, final int y, final int z) {
    MEMORY.call(0x800d14c, actor, x, y, z);
  }

  /** {@link GoldenSun#FUN_800ca6c} */
  @Method(0x8009158)
  public static void FUN_8009158(final Actor70 r0) {
    MEMORY.call(0x800ca6c, r0);
  }

  /** {@link GoldenSun_801#FUN_8010560} */
  @Method(0x8009178)
  public static void FUN_8009178(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8010560, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8010424} */
  @Method(0x8009180)
  public static void FUN_8009180(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8010424, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#FUN_80118a8} */
  @Method(0x8009188)
  public static void FUN_8009188(final int r0) {
    MEMORY.call(0x80118a8, r0);
  }

  /** {@link GoldenSun_801#FUN_80118c0} */
  @Method(0x8009190)
  public static void FUN_8009190(final int r0) {
    MEMORY.call(0x80118c0, r0);
  }

  /** {@link GoldenSun_801#FUN_8011ae0} */
  @Method(0x80091a0)
  public static void FUN_80091a0() {
    MEMORY.call(0x8011ae0);
  }

  /** {@link GoldenSun_801#getHeight} */
  @Method(0x80091a8)
  public static int getHeight_(final int mapLayer, final int x, final int z) {
    return (int)MEMORY.call(0x8011f54, mapLayer, x, z);
  }

  /** {@link GoldenSun_801#getTileType} */
  @Method(0x80091b0)
  public static int getTileType_(final int mapLayer, final int x, final int z) {
    return (int)MEMORY.call(0x8012038, mapLayer, x, z);
  }

  /** {@link GoldenSun_801#FUN_80105d4} */
  @Method(0x80091b8)
  public static void FUN_80091b8(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x80105d4, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#FUN_8010704} */
  @Method(0x80091c0)
  public static void FUN_80091c0(final int r0, final int r1, final int r2, final int r3, final int a4, final int a5) {
    MEMORY.call(0x8010704, r0, r1, r2, r3, a4, a5);
  }

  /** {@link GoldenSun_801#FUN_80120dc} */
  @Method(0x80091d8)
  public static int FUN_80091d8(final Actor70 r0, final Vec3 r1) {
    return (int)MEMORY.call(0x80120dc, r0, r1);
  }

  /** {@link GoldenSun#FUN_800c528} */
  @Method(0x80091e0)
  public static void FUN_80091e0(final Actor70 actor, final int r1) {
    MEMORY.call(0x800c528, actor, r1);
  }

  /** {@link GoldenSun#FUN_800c548} */
  @Method(0x80091e8)
  public static void FUN_80091e8(final Actor70 actor, final int r1) {
    MEMORY.call(0x800c548, actor, r1);
  }

  /** {@link GoldenSun_801#FUN_8012330} */
  @Method(0x80091f0)
  public static void FUN_80091f0(final int r0, final int r1, final int r2) {
    MEMORY.call(0x8012330, r0, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_8012350} */
  @Method(0x80091f8)
  public static void FUN_80091f8() {
    MEMORY.call(0x8012350);
  }

  /** {@link GoldenSun#FUN_800c5b4} */
  @Method(0x8009208)
  public static void FUN_8009208() {
    MEMORY.call(0x800c5b4);
  }

  /** {@link GoldenSun#FUN_800c5fc} */
  @Method(0x8009210)
  public static void FUN_8009210() {
    MEMORY.call(0x800c5fc);
  }

  /** {@link GoldenSun_801#FUN_801219c} */
  @Method(0x8009220)
  public static int FUN_8009220(final Vec3 r0) {
    return (int)MEMORY.call(0x801219c, r0);
  }

  /**
   * Opening cutscene, mom gives Isaac his cloak
   * {@link GoldenSun#addLayerToSpriteIfRegularSprite}
   */
  @Method(0x8009228)
  public static void addLayerToSpriteIfRegularSprite_(@Nullable final Actor70 actor, final int spriteDataIndex) {
    MEMORY.call(0x800c430, actor, spriteDataIndex);
  }

  /** {@link GoldenSun_801#FUN_8011590} */
  @Method(0x8009230)
  public static void FUN_8009230() {
    MEMORY.call(0x8011590);
  }

  /** {@link GoldenSun_801#FUN_8011644} */
  @Method(0x8009238)
  public static void FUN_8009238() {
    MEMORY.call(0x8011644);
  }

  /** {@link GoldenSun#FUN_800c598} */
  @Method(0x8009240)
  public static void FUN_8009240(final Actor70 r0, final int r1) {
    MEMORY.call(0x800c598, r0, r1);
  }

  /** {@link GoldenSun#FUN_800be20} */
  @Method(0x8009260)
  public static int FUN_8009260(final int spriteDataIndex, final int r1, final int r2) {
    return (int)MEMORY.call(0x800be20, spriteDataIndex, r1, r2);
  }

  /** {@link GoldenSun_801#FUN_80122c8} */
  @Method(0x8009268)
  public static int FUN_8009268(final Vec3 r0, final int r1) {
    return (int)MEMORY.call(0x80122c8, r0, r1);
  }

  /** {@link GoldenSun#FUN_800b6b8} */
  @Method(0x8009270)
  public static int FUN_8009270(final int r0, final int r1, final int r2, final int r3) {
    return (int)MEMORY.call(0x800b6b8, r0, r1, r2, r3);
  }

  /** {@link GoldenSun_801#FUN_8012078} */
  @Method(0x8009278)
  public static void FUN_8009278(final int r0, final int r1, final int r2, final int r3) {
    MEMORY.call(0x8012078, r0, r1, r2, r3);
  }

  /** {@link GoldenSun#FUN_800f9cc} */
  @Method(0x8009288)
  public static void FUN_8009288(final int r0, final int r1) {
    MEMORY.call(0x800f9cc, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8011984} */
  @Method(0x8009290)
  public static void FUN_8009290() {
    MEMORY.call(0x8011984);
  }

  /** {@link GoldenSun_801#FUN_80119a8} */
  @Method(0x8009298)
  public static void FUN_8009298() {
    MEMORY.call(0x80119a8);
  }

  /** {@link GoldenSun#FUN_800d98c} */
  @Method(0x80092a0)
  public static Actor70 FUN_80092a0(final Actor70 r0, final Vec3 r1) {
    return (Actor70)MEMORY.call(0x800d98c, r0, r1);
  }

  /** {@link GoldenSun_801#FUN_8011fd8} */
  @Method(0x80092a8)
  public static int FUN_80092a8(final int r0, final int r1, final int r2) {
    return (int)MEMORY.call(0x8011fd8, r0, r1, r2);
  }

  @Method(0x800a97c)
  public static int decompressSprite(int r0, int r1) {
    int r2;
    int r4;
    int r5;
    int r6;
    final int r7;

    r4 = MEMORY.ref(1, r0 + 0x1).getUnsigned() << 8 | MEMORY.ref(1, r0).getUnsigned();
    r5 = r1;
    final int r12 = r1;
    r6 = r0 + 0x2;
    if(r4 == 0) {
      return r6;
    }

    //LAB_800a992
    r0 = r0 + r4;
    r1 = MEMORY.ref(1, r0).getUnsigned() | 0x100;
    r0++;
    r7 = r6;

    //LAB_800a9d8
    if((r1 & 0x1) != 0) {
      if(r1 != 1) {
        MEMORY.ref(1, r5).setu(MEMORY.ref(1, r6).getUnsigned());
        r6++;
        r5++;
      }

      while(true) {
        r1 = r1 >>> 1;
        if(r1 == 0) {
          r1 = MEMORY.ref(1, r0).getUnsigned() | 0x100;
          r0++;
        }

        if((r1 & 0x1) == 0) {
          break;
        }
        if(r1 != 1) {
          MEMORY.ref(1, r5).setu(MEMORY.ref(1, r6).getUnsigned());
          r6++;
          r5++;
        }
      }
    }

    //LAB_800a9ee
    r4 = MEMORY.ref(1, r0).getUnsigned() << 8 | MEMORY.ref(1, r0 + 0x1).getUnsigned();
    r0 += 0x2;

    //LAB_800a9a0
    while(r4 != 0) {
      r2 = r4 >> 12;
      if(r2 == 0) {
        r2 = MEMORY.ref(1, r0).getUnsigned() + 0x10;
        r0++;
      }

      //LAB_800a9ae
      r2 = r2 + 0x2;
      r4 = r7 - (r4 & 0xfff);
      //LAB_800a9ba
      while(r2 > 0) {
        MEMORY.ref(1, r5).setu(MEMORY.ref(1, r4).getUnsigned());
        r4++;
        r5++;
        r2--;
      }

      //LAB_800a9c8
      do {
        r1 = r1 >>> 1;
        if(r1 == 0) {
          r1 = MEMORY.ref(1, r0).getUnsigned() | 0x100;
          r0++;
        }

        //LAB_800a9d8
        if((r1 & 0x1) == 0) {
          break;
        }
        if(r1 != 1) {
          MEMORY.ref(1, r5).setu(MEMORY.ref(1, r6).getUnsigned());
          r6++;
          r5++;
        }
      } while(true);

      //LAB_800a9ee
      r4 = MEMORY.ref(1, r0).getUnsigned() << 8 | MEMORY.ref(1, r0 + 0x1).getUnsigned();
      r0 += 0x2;
    }

    //LAB_800aa00
    return r12;
  }

  @Method(0x800aa0c)
  public static int FUN_800aa0c(final Sprite38 sprite, final int angle) {
    CPU.sp().value -= 0x38;
    int sp28 = 0;
    final Struct5c sp20 = boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new);

    final int functionAlreadyLoaded;
    if(boardWramMallocHead_3001e50.offset(52 * 0x4).get() == 0) {
      final int addr = mallocSlotChip(52, 0x2c4);
      DMA.channels[3].SAD.setu(0x8009bb8);
      DMA.channels[3].DAD.setu(addr);
      DMA.channels[3].CNT.setu(0x84000000 | 0x1e4 / 0x4);
      functionAlreadyLoaded = 0;

      MEMORY.setFunction(addr, CopiedSegment8009bb8.class, "FUN_8009bb8", int.class, int.class, int.class);
    } else {
      functionAlreadyLoaded = 1;
    }

    //LAB_800aa62
    //LAB_800aa7c
    int r5;
    int r3;
    int r2;
    int r0;
    for(int layerIndex = 0; layerIndex < sprite.layerCount_27.get(); layerIndex++) {
      final SpriteLayer18 layer = sprite.layers_28.get(layerIndex).derefNullable();
      //LAB_800aa8c
      if(layer != null && layer.dataPtr_10.get() != 0) {
        //LAB_800aa94
        do {
          if(layer._02.get() > 0) {
            //LAB_800ab66
            layer._02.sub(layer._15.get());
            r0 = layer._17.get();
          } else {
            r0 = MEMORY.ref(1, layer.dataPtr_10.get() + layer.dataOffset_14.get()).getUnsigned();
            layer.dataOffset_14.incr();
            r5 = MEMORY.ref(1, layer.dataPtr_10.get() + layer.dataOffset_14.get()).getUnsigned();
            layer.dataOffset_14.incr();

            switch(r0) {
              case 0xfe: // jump to animation N immediately
                FUN_800b9f4(layer, r5);
                sprite.anim_24.set(r5);
                continue;

              case 0xfd: // loop back to frame N (of same animation) immediately
                layer.dataOffset_14.set(r5);
                continue;

              case 0xf5: // delay N more frames on the same image
                layer._02.add(r5 * 16);
                continue;

              case 0xf1: // on the next frame, continue from the previous animation frame
                layer.dataOffset_14.sub(2);
                r0 = layer._17.get();
                break;

              case 0xf0: // change directional type to N
                layer._04.set(r5);
                continue;

              case 0xff: // disable the sprite for N frames
                layer._17.set(0xff);
                layer._02.add(r5 * 16);
                r0 = 0xff;
                break;

              case 0xef: // unset data and layer?
                layer._17.set(0xff);
                layer.dataPtr_10.set(0);
                sprite.layerCount_27.decr();
                r0 = 0xff;
                break;

              case 0xf2:
              case 0xf3:
              case 0xf4:
              case 0xf6:
              case 0xf7:
              case 0xf8:
              case 0xf9:
              case 0xfa:
              case 0xfc:
                continue;

              default: // also 0xfb: interprets 0xfb as sprite id; probably broken
                //LAB_800ab5a
                layer._17.set(r0);
                layer._02.add(r5 * 16);
                break;
            }
          }

          break;
        } while(true);

        //LAB_800ab6e
        //LAB_800ab78
        r2 = switch(layer._04.get()) {
          case 1 -> MEMORY.ref(1, 0x801307c + (angle << 16 >>> 29)).getUnsigned();
          case 2, 0x14 -> MEMORY.ref(1, 0x8013094 + (angle << 16 >>> 29)).getUnsigned();
          case 0x16 -> MEMORY.ref(1, 0x801308c + (angle << 16 >>> 29)).getUnsigned();
          case 3 -> MEMORY.ref(1, 0x801309c + (angle << 16 >>> 28)).getUnsigned();
          case 4 -> MEMORY.ref(1, 0x80130cc + (angle << 16 >>> 26)).getUnsigned();
          case 5 -> MEMORY.ref(1, 0x80130ac + (angle << 16 >>> 28)).getUnsigned();
          case 6 -> MEMORY.ref(1, 0x801310c + (angle << 16 >>> 26)).getUnsigned();
          case 8 -> MEMORY.ref(1, 0x80130bc + ((angle << 16) + 0x10000000 >>> 29)).getUnsigned();
          case 0x58 -> MEMORY.ref(1, 0x80130c4 + ((angle << 16) + 0x10000000 >>> 29)).getUnsigned();
          //LAB_800ad6c
          default -> 0;
        };

        //LAB_800ad6e
        r0 = r0 + (r2 & 0x7);
        if(layerIndex == 0 && r2 >>> 7 != 0) {
          sp28 = 1;
        }

        //LAB_800ad84
        if(layer._16.get() != r0) {
          layer._16.set(r0);
          sprite._25.set(0x1);
        }
      }

      //LAB_800ad92
    }

    //LAB_800ada0
    if(sprite._25.get() != 0) {
      //LAB_800adaa
      final int spriteSize = sprite.height_21.get() * sprite.width_20.get();
      final int r10 = mallocChip(spriteSize);
      MEMORY.call(0x3000164, r10, spriteSize); // memzero
      int lr = 0;
      int r9 = -1;

      //LAB_800adf0
      int r4;
      for(int layerIndex = sprite.layerCount_27.get() - 1; layerIndex >= 0; layerIndex--) {
        final SpriteLayer18 r6 = sprite.layers_28.get(layerIndex).derefNullable();
        if(r6 != null && r6._08.get() != 0 && r6._16.get() != 0xff) {
          r0 = r6._06.get();
          if(r0 <= 3) {
            r0 = r0 << 8 | layerIndex;
            int r6_0 = r9;
            if(r6_0 < 0) {
              //LAB_800ae48
              r3 = r9 * 0x2;
            } else {
              r3 = MEMORY.ref(2, CPU.sp().value + 0x30 + r6_0 * 0x2).getUnsigned();
              if(r3 <= r0) {
                //LAB_800ae50
                r3 = r6_0 * 0x2;
              } else {
                MEMORY.ref(2, CPU.sp().value + 0x30 + lr).setu(r3);
                r3 = CPU.sp().value + 0x30 + r6_0 * 0x2;
                r4 = r3 + 0x2;
                int r1_0 = r6_0 * 0x2;

                //LAB_800ae32
                do {
                  r6_0--;
                  r1_0 += 0x2;
                  if(r6_0 < 0) {
                    //LAB_800ae54
                    r3 = r6_0 * 0x2;
                    break;
                  }
                  r3 = r1_0;
                  r2 = MEMORY.ref(2, CPU.sp().value + 0x30 + r3).getUnsigned();
                  if(r2 <= r0) {
                    break;
                  }
                  r4 -= 0x2;
                  MEMORY.ref(2, r4).setu(r2);
                } while(true);
              }
            }

            //LAB_800ae56
            MEMORY.ref(2, CPU.sp().value + 0x30 + r3 + 0x2).setu(r0);
            lr += 0x2;
            r9++;
          }
        }

        //LAB_800ae62
      }

      //LAB_800ae6e
      r9++;

      //LAB_800ae7a
      for(int r8 = 0; r8 < r9; r8++) {
        final SpriteLayer18 r6 = sprite.layers_28.get(MEMORY.ref(1, CPU.sp().value + 0x30 + r8 * 0x2).getUnsigned()).deref();
        r3 = r6._07.get();
        if(r3 == 1) {
          r2 = r6._08.get();
          decompress(MEMORY.ref(4, r2 + r6._16.get() * 0x4).get(), r10);
          //LAB_800aea4
        } else if(r3 == 3) {
          if(r6._05.get() != 0) {
            r5 = mallocChip(0x400);
            r0 = decompressSprite(MEMORY.ref(4, r6._08.get() + r6._16.get() * 0x4).get(), r5);
            MEMORY.call(boardWramMallocHead_3001e50.offset(52 * 0x4).get(), r0, r10, r6._05.get());
            setMallocAddress(r5);
          } else {
            //LAB_800aed8
            r0 = (int)MEMORY.call(0x30005c0, MEMORY.ref(4, r6._08.get() + r6._16.get() * 0x4).get(), r10);
            if(r0 != 0) {
              MEMORY.call(boardWramMallocHead_3001e50.offset(52 * 0x4).get(), r0, r10, 0);
            }
          }
        } else {
          //LAB_800aef8
          MEMORY.call(boardWramMallocHead_3001e50.offset(52 * 0x4).get(), MEMORY.ref(4, r6._08.get() + r6._16.get() * 0x4).get(), r10, r6._05.get());
        }

        //LAB_800af0a
      }

      //LAB_800af12
      if((sprite._26.get() & 0x2) != 0) {
        final int sp0c = mallocChip(spriteSize);
        MEMORY.call(0x3000164, sp0c, spriteSize); // memzero

        final int w = sprite.width_20.get();
        final int h = sprite.height_21.get();
        final int sp08 = sp20._06.get();
        final int sp04 = sp20._07.get();
        int r1_0 = r10 + w + 1;
        r4 = sp0c + w + 1;

        //LAB_800af60
        for(int r8 = 1; r8 < h - 1; r8++) {
          int r5_0 = r1_0 + w;
          r0 = r1_0 - w;
          r2 = r1_0 - 0x1;

          //LAB_800af72
          for(int r6 = 1; r6 < w - 1; r6++) {
            if(MEMORY.ref(1, r2).getUnsigned() != 0 && MEMORY.ref(1, r2 + 0x2).getUnsigned() != 0 && MEMORY.ref(1, r0).getUnsigned() != 0 && MEMORY.ref(1, r5_0).getUnsigned() != 0) {
              MEMORY.ref(1, r4).setu(0x1);
            }

            //LAB_800af8e
            r4++;
            r5_0++;
            r0++;
            r2++;
            r1_0++;
          }

          //LAB_800af9e
          r4 += 0x2;
          r1_0 += 0x2;
        }

        //LAB_800afaa
        //LAB_800afb8
        for(int r8 = 0; r8 < spriteSize; r8++) {
          if(MEMORY.ref(1, sp0c + r8).getUnsigned() != 0) {
            MEMORY.ref(1, r10 + r8).setu(sp04);
            //LAB_800afd0
          } else if(MEMORY.ref(1, r10 + r8).getUnsigned() != 0) {
            MEMORY.ref(1, r10 + r8).setu(sp08);
          }

          //LAB_800afdc
        }

        //LAB_800afea
        setMallocAddress(sp0c);
      }

      //LAB_800aff0
      final int tileNum = allocateSpriteSlot(sprite.slot_1c.get(), spriteSize, 0);
      MEMORY.call(boardWramMallocHead_3001e50.offset(53 * 0x4).get(), r10, sprite.width_20.get(), sprite.height_21.get(), 0x6010000 + tileNum * 0x20);
      sprite.packet_00.attribs_04.attrib2_04.and(~0x3ff).or(tileNum & 0x3ff);
      sprite._25.set(0);
      sp20._00.add(spriteSize);
      setMallocAddress(r10);
    }

    //LAB_800b054
    if(functionAlreadyLoaded == 0) {
      freeSlot(52);
    }

    //LAB_800b060
    CPU.sp().value += 0x38;

    return sp28;
  }

  @Method(0x800b168)
  public static void drawSprite(final Sprite38 sprite, int r1, final int r2, final int angle) {
    int r4;
    int r5;
    int r6;
    final int r8;
    final int r9;
    final int r10;
    final int r11;

    CPU.sp().value -= 0x44;
    MEMORY.ref(4, CPU.sp().value + 0x1c).setu(sprite.width_20.get() >>> 1);
    MEMORY.ref(4, CPU.sp().value + 0x18).setu(sprite.height_21.get() >>> 1);
    MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x8);
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x4);

    r8 = MEMORY.ref(4, r2).get();
    r9 = MEMORY.ref(4, r2 + 0x4).get();

    r10 = MEMORY.ref(4, r1).get();
    MEMORY.ref(4, CPU.sp().value + 0x4).setu(MEMORY.ref(4, r1 + 0x4).get());
    r11 = MEMORY.ref(4, r1 + 0x8).get();
    r6 = MEMORY.ref(4, r1 + 0xc).get();

    r5 = FUN_800aa0c(sprite, angle & 0xffff);

    if(r5 == 0 && r8 == 0x10000 && r9 == 0x10000 && sprite.rotation_1e.get() == 0) {
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(0);
    } else {
      //LAB_800b1dc
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(1);
      MEMORY.ref(2, CPU.sp().value + 0x24).setu(r8 >>> 8 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x26).setu(r9 >>> 8 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x28).set(sprite.rotation_1e.get());

      if(r5 != 0) {
        MEMORY.ref(2, CPU.sp().value + 0x24).neg().and(0xffff);
      }

      //LAB_800b21c
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(addRotScaleParams(CPU.sp().value + 0x24));
    }

    //LAB_800b222
    if(r8 > 0x10000 || r9 > 0x10000) {
      //LAB_800b22e
      MEMORY.ref(4, CPU.sp().value + 0x8).setu(0x3);
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(MEMORY.ref(4, CPU.sp().value + 0x1c).get() << 1);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(MEMORY.ref(4, CPU.sp().value + 0x18).get() << 1);
      MEMORY.ref(4, CPU.sp().value + 0x10).setu(0x10);
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(0x8);
    }

    //LAB_800b246
    if(MEMORY.ref(4, CPU.sp().value + 0x4).get() <= -0x640000) {
      MEMORY.ref(4, CPU.sp().value).setu(1);
      r4 = 0;
    } else {
      //LAB_800b256
      MEMORY.ref(4, CPU.sp().value).setu((r11 >> 17) + 0xa);
      r4 = 2;
    }

    //LAB_800b260
    r6 = (r11 - r6 >> 16) - MEMORY.ref(4, CPU.sp().value + 0xc).get();
    r5 = r10 >> 16;
    if((sprite._26.get() & 0x1) != 0) {
      if(r6 < 0xa0) {
        sprite.shadowPacket_0c.attribs_04.y_00.set(r6 & 0xff);
        sprite.shadowPacket_0c.attribs_04.flags_01.and(~0x3).or(MEMORY.ref(4, CPU.sp().value + 0x8).get());
        sprite.shadowPacket_0c.attribs_04.attrib1_02.and(~0x1ff).or(r5 - MEMORY.ref(4, CPU.sp().value + 0x10).get() & 0x1ff);
        sprite.shadowPacket_0c.attribs_04.attrib1_02.and(~0x3e00).or((MEMORY.ref(4, CPU.sp().value + 0x20).get() & 0x1f) << 9);
        insertIntoRenderQueue(sprite.shadowPacket_0c, r4);
      } else {
        //LAB_800b2d8
        r5 = r10 >> 16;
      }
    }

    //LAB_800b2dc
    r4 = r5 - MEMORY.ref(4, CPU.sp().value + 0x1c).get() + (r8 * sprite.x_22.get() + 0xffff >> 16);
    r1 = (r11 - MEMORY.ref(4, CPU.sp().value + 0x4).get() >> 16) - MEMORY.ref(4, CPU.sp().value + 0x18).get();
    r6 = r1 - (r9 * ((sprite.height_21.get() >>> 1) - sprite.y_23.get()) + 0xffff >> 16);
    if(r4 < 0xf0 && r6 < 0xa0) {
      MEMORY.ref(4, CPU.sp().value + 0x20).and(0x1f);
      sprite.packet_00.attribs_04.y_00.set(r6 & 0xff);
      sprite.packet_00.attribs_04.flags_01.and(~0x3).or(MEMORY.ref(4, CPU.sp().value + 0x8).get());
      sprite.packet_00.attribs_04.attrib1_02.and(~0x1ff).or(r4 & 0x1ff);
      sprite.packet_00.attribs_04.attrib1_02.and(~0x3e00).or(MEMORY.ref(4, CPU.sp().value + 0x20).get() << 9);
      insertIntoRenderQueue(sprite.packet_00, MEMORY.ref(4, CPU.sp().value).get());
    }

    //LAB_800b374
    CPU.sp().value += 0x44;
  }

  @Method(0x800b388)
  public static void drawBattleSprite(final Sprite38 sprite, final Vec3 pos, final int r2, final int angle, final int layer) {
    final int r4;
    int r5;
    final int r6;
    int r8;
    int r11;
    int lr;

    CPU.sp().value -= 0x38;
    int sp00 = 1;
    if(boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._04.get() == 0) {
      //LAB_800b3b2
      final Vec3 r10 = new Vec3();
      r5 = FUN_8005268(pos, r10);
      if(r10.getZ() != 0 && r10.getX() >= -32 && r10.getX() <= 272 && r10.getY() >= -32 && r10.getY() <= 208) {
        if((sprite._1d.get() & 0x2) != 0) {
          r5 = sprite.scale_18.get();
        } else {
          //LAB_800b3fe
          r5 = (int)MEMORY.call(0x3000118, r5, sprite.scale_18.get());
        }

        //LAB_800b40a
        r11 = sprite.width_20.get() >>> 1;
        int sp08 = sprite.height_21.get() >>> 1;
        int sp04 = 8;
        final int sp0c = FUN_800aa0c(sprite, angle & 0xffff);
        r4 = r5 + 0x400 & ~0x7ff;
        r5 = (int)MEMORY.call(0x3000118, r4, MEMORY.ref(4, r2).get());
        lr = (int)MEMORY.call(0x3000118, r4, MEMORY.ref(4, r2 + 0x4).get());

        if(r5 > 0x1f800) {
          r5 = 0x1f800;
        }

        //LAB_800b464
        if(lr >= 0x1f800) {
          lr = 0x1f800;
        }

        //LAB_800b46e
        r8 = (int)MEMORY.call(0x3000118, sprite.x_22.get(), r5);
        r6 = -(int)MEMORY.call(0x3000118, (sprite.height_21.get() >>> 1) - sprite.y_23.get(), lr);
        if(r5 > 0x10000 || lr > 0x10000) {
          //LAB_800b4a2
          sp00 = 3;
          r11 <<= 1;
          sp08 <<= 1;
          sp04 = 16;
          //LAB_800b4b8
        } else if(r5 == 0x10000 && sprite.rotation_1e.get() == 0 && lr == r5) {
          sp00 = 0;
        }

        //LAB_800b4ca
        if(sp00 != 0) {
          final int r0_0 = CPU.sp().value + 0x18;
          MEMORY.ref(4, r0_0 + 0x4).and(~0xffff).or(sprite.rotation_1e.get());
          MEMORY.ref(4, r0_0).and(~0xffff).or(r5 << 8 >>> 16);

          if(sp0c != 0) {
            MEMORY.ref(4, r0_0).and(~0xffff).or(-MEMORY.ref(2, r0_0).getUnsigned() << 16 >>> 16);
            r8 = -r8;
          }

          //LAB_800b506
          MEMORY.ref(4, r0_0).and(~0xffff).or(lr << 8 >>> 16 << 16);
          r5 = addRotScaleParams(r0_0);
          //LAB_800b520
        } else if(sp0c != 0) {
          r5 = 0x8;
          r8 = -r8;
        } else {
          //LAB_800b548
          r5 = 0x0;
        }

        //LAB_800b54a
        sprite.packet_00.attribs_04.attrib1_02.and(~0x1ff).or(r10.getX() - r11 + r8 & 0x1ff);
        sprite.packet_00.attribs_04.y_00.set(r10.getY() - sp08 + r6);
        sprite.packet_00.attribs_04.flags_01.and(~0x3).or(sp00);
        sprite.packet_00.attribs_04.attrib1_02.and(~0x3e00).or((r5 & 0x1f) << 9);

        int r1_0;
        if(layer == 0) {
          r1_0 = (0x200 - r10.getZ()) / 2 + 0x80;
          if(r1_0 <= 0) {
            r1_0 = 1;
          }
        } else {
          //LAB_800b5c4
          r1_0 = layer;
        }

        insertIntoRenderQueue(sprite.packet_00, r1_0);

        //LAB_800b5cc
        if((sprite._26.get() & 0x1) != 0) {
          final Vec3 vec = new Vec3();
          vec.setX(pos.getX());
          vec.setY(0);
          vec.setZ(pos.getZ());
          FUN_8005268(vec, r10);
          sprite.shadowPacket_0c.attribs_04.attrib1_02.and(~0x1ff).or(r10.getX() - sp04 & 0x1ff);
          sprite.shadowPacket_0c.attribs_04.y_00.set(r10.getY() - (sp04 >>> 1) + 2);
          sprite.shadowPacket_0c.attribs_04.flags_01.and(~0x3).or(sp00);
          sprite.shadowPacket_0c.attribs_04.attrib1_02.and(~0x3e00).or((r5 & 0x1f) << 9);
          insertIntoRenderQueue(sprite.shadowPacket_0c, layer);
        }

        CPU.sp().value += 0x38;
        return;
      }
    }

    //LAB_800b658
    if((sprite._1d.get() & 0x1) == 0) {
      FUN_8003f78(sprite.slot_1c.get());
      sprite._25.set(1);
    }

    //LAB_800b670
    CPU.sp().value += 0x38;
  }

  @Method(0x800b684)
  public static void FUN_800b684(final Sprite38 r0, final int r1) {
    if(r0 != null) {
      //LAB_800b69c
      for(int i = 0; i < r0.layerCount_27.get(); i++) {
        final SpriteLayer18 r2 = r0.layers_28.get(i).deref();

        if(r2._05.get() != 0xf) {
          r2._05.set(r1);
        }

        //LAB_800b6a6
      }

      //LAB_800b6ac
      r0._25.set(0x1);
    }

    //LAB_800b6b4
  }

  @Method(0x800b6b8)
  public static int FUN_800b6b8(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    final int r7;
    final int r8;
    final int r10;

    r6 = r0;
    r7 = r1;
    r4 = r2;
    r8 = r3;
    if((r6 & 0xffff_ffffL) > (0x7 & 0xffff_ffffL)) {
      //LAB_800b6ce
      return 0;
    }

    //LAB_800b6d2
    r3 = 0x3001e68;
    r5 = MEMORY.ref(4, r3).get();
    r0 = r4;
    r3 = r6 << 3;
    r5 = r5 + r3;
    r0 = getSpriteData(r0);
    r2 = 0x8012fa0;
    r3 = r6 << 12;
    r5 = r5 + 0x1c;
    r3 = r3 | r4;
    MEMORY.ref(4, r5).setu(r3);
    r1 = 0x2;
    r3 = MEMORY.ref(2, r2 + r1).get();
    r3 = r3 << 16;
    r3 = r3 >>> 16;
    r10 = r0;
    MEMORY.ref(4, r5 + 0x4).setu(r7);
    r0 = MEMORY.ref(2, r2).getUnsigned();
    r1 = r2 + 0x6;
    r5 = 0x0;

    //LAB_800b700
    do {
      r2 = r2 + 0x4;
      if(r3 == 0x0) {
        return 0;
      }
      if(r3 == r4) {
        break;
      }
      r5 = r5 + 0x1;
      if((r5 & 0xffff_ffffL) > (0xff & 0xffff_ffffL)) {
        break;
      }
      r6 = 0x0;
      r3 = MEMORY.ref(2, r1 + r6).get();
      r3 = r3 << 16;
      r3 = r3 >>> 16;
      r0 = MEMORY.ref(2, r2).getUnsigned();
      r1 = r1 + 0x4;
    } while(true);

    //LAB_800b71e
    r0 = getPointerTableEntry(r0);
    r1 = r7;
    r0 = decompress(r0, r1);
    r3 = MEMORY.ref(4, r7).get();
    r4 = r7;
    r5 = 0x0;
    if(r3 != 0) {
      r2 = r3;

      //LAB_800b734
      do {
        r3 = r2 + r7;
        r5 = r5 + 0x1;
        MEMORY.ref(4, r4).setu(r3);
        r4 += 0x4;
        if((r5 & 0xffff_ffffL) > (0xff & 0xffff_ffffL)) {
          break;
        }
        r3 = MEMORY.ref(4, r4).get();
        r2 = r3;
      } while(r3 != 0);
    }

    //LAB_800b746
    r1 = r8;
    if(r1 != 0x0) {
      r2 = r8;
      r2 = r2 - 0x1;
      r5 = r4 + 0x4;
      r0 = r7 + r0;
      if((r2 & 0xffff_ffffL) > (0x4 & 0xffff_ffffL)) {
        r2 = 0x0;
      }

      //LAB_800b75a
      r3 = 0x80092b8;
      r2 = r2 << 8;
      r2 = r2 + r3;
      if((r5 & 0xffff_ffffL) < (r0 & 0xffff_ffffL)) {
        //LAB_800b764
        do {
          r4 = MEMORY.ref(1, r5).getUnsigned();
          if((r4 & 0xffff_ffffL) <= (0xdf & 0xffff_ffffL)) {
            r4 = MEMORY.ref(1, r2 + r4).getUnsigned();
            MEMORY.ref(1, r5).setu(r4);
          }

          //LAB_800b76e
          r5 = r5 + 0x1;
        } while((r5 & 0xffff_ffffL) < (r0 & 0xffff_ffffL));
      }
    }

    //LAB_800b774
    r2 = r10;
    r3 = MEMORY.ref(1, r2).getUnsigned();
    r2 = MEMORY.ref(1, r2 + 0x1).getUnsigned();
    r0 = r2;
    r0 = r0 * r3;

    //LAB_800b77e
    return r0;
  }

  @Method(0x800b798)
  public static int FUN_800b798(final int r0) {
    final ArrayRef<Struct5c.Sub08> structs = boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new)._1c;

    //LAB_800b7a4
    for(int i = 0; i < 8; i++) {
      final Struct5c.Sub08 r2 = structs.get(i);
      if(r2._00.get() == r0) {
        return r2._04.get();
      }

      //LAB_800b7ae
    }

    //LAB_800b7b8
    return 0;
  }

  @Method(0x800b8ac)
  public static SpriteLayer18 addLayerToSprite(final Sprite38 sprite, final int spriteDataIndex) {
    //LAB_800b8c2
    int layerIndex;
    for(layerIndex = 0; layerIndex < 4 && !sprite.layers_28.get(layerIndex).isNull(); layerIndex++) {
      // no-op
    }

    //LAB_800b8d0
    if(layerIndex == 4) {
//      return -1;
      throw new RuntimeException("No slot available");
    }

    //LAB_800b8da
    final SpriteLayer18 layer = loadSpriteLayer(spriteDataIndex);

    if(layer == null) {
      return null;
    }

    sprite.layers_28.get(layerIndex).set(layer);
    final int spriteData = getSpriteData(spriteDataIndex);

    if(sprite.layerCount_27.get() == 0) {
      sprite.width_20.set(MEMORY.ref(1, spriteData).getUnsigned());
      sprite.height_21.set(MEMORY.ref(1, spriteData + 0x1).getUnsigned());
      sprite.scale_18.set(MEMORY.ref(2, spriteData + 0x2).getUnsigned() << 8);
      sprite.y_23.set(MEMORY.ref(1, spriteData + 0x7).getUnsigned());
      sprite.x_22.set(MEMORY.ref(1, spriteData + 0x6).getUnsigned());
    }

    //LAB_800b924
    if(sprite.layerCount_27.get() == layerIndex) {
      sprite.layerCount_27.incr();
    }

    //LAB_800b930
    return layer;

    //LAB_800b932
  }

  @Method(0x800b9f4)
  public static void FUN_800b9f4(final SpriteLayer18 layer, final int r1) {
    if(layer._0c.get() != 0) {
      final int spriteData = getSpriteData(layer.spriteDataIndex_00.get());

      if(r1 < MEMORY.ref(1, spriteData + 0x5).getUnsigned()) {
        final int r2 = layer._0c.get();
        layer._04.set(MEMORY.ref(1, spriteData + 0x4).getUnsigned());
        layer.dataPtr_10.set(MEMORY.ref(4, r2 + r1 * 0x4).get());
        layer._15.set(0x10);

        if((r1 & 0x80) == 0) {
          layer.dataOffset_14.set(0);
          layer._02.set(0);
        }
      }
    }

    //LAB_800ba2a
  }

  @Method(0x800ba30)
  public static int setSpriteAnimation(final Sprite38 sprite, final int animation) {
    final int newAnim = animation & 0x7f;

    if(sprite.anim_24.get() != newAnim) {
      //LAB_800ba5c
      for(int i = 0; i < sprite.layerCount_27.get(); i++) {
        final SpriteLayer18 layer = sprite.layers_28.get(i).derefNullable();

        if(layer != null) {
          if(layer._0c.get() != 0) {
            final int spriteData = getSpriteData(layer.spriteDataIndex_00.get());

            if(newAnim < MEMORY.ref(1, spriteData + 0x5).getUnsigned()) {
              layer._04.set(MEMORY.ref(1, spriteData + 0x4).getUnsigned());
              layer.dataPtr_10.set(MEMORY.ref(4, layer._0c.get()).offset(newAnim * 0x4).get());
              layer._15.set(0x10);

              if((animation & 0x80) == 0) {
                layer.dataOffset_14.set(0);
                layer._02.set(0);
              }

              //LAB_800ba9a
              if(i == 0) {
                sprite.x_22.set(MEMORY.ref(1, spriteData + 0x6).getUnsigned());
                sprite.y_23.set(MEMORY.ref(1, spriteData + 0x7).getUnsigned());
              }
            }
          }
        }

        //LAB_800baac
        //LAB_800baae
      }

      sprite.anim_24.set(newAnim);
    }

    //LAB_800baba
    return 0;
  }

  @Method(0x800baf8)
  public static void FUN_800baf8(final Sprite38 sprite, final int r1) {
    //LAB_800bb08
    for(int i = 0; i < sprite.layerCount_27.get(); i++) {
      final SpriteLayer18 r2 = sprite.layers_28.get(i).derefNullable();

      if(r2 != null && r2._0c.get() != 0) {
        r2._15.set(r1);
      }

      //LAB_800bb16
    }

    //LAB_800bb1c
  }

  @Method(0x800bb20)
  public static void FUN_800bb20(final int r0) {
    final int r6;
    final int r7;
    if(r0 == 3) {
      r7 = mallocSlotBoard(4, 0xe00);
      r6 = mallocSlotBoard(3, 0x600);
    } else {
      //LAB_800bb40
      r7 = mallocSlotChip(4, 0xe00);
      r6 = mallocSlotChip(3, 0x600);
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

    allocateSpriteSlot(0x5d, 0x80, 0x8012f20);

    final int size = 0x7c;
    final int addr = mallocSlotChip(53, size);
    DMA.channels[3].SAD.setu(0x800a418);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment800a418.class, "FUN_800a418", int.class, int.class, int.class, int.class);

    CPU.sp().value += 0x4;
  }

  @Method(0x800bbc0)
  public static SpriteLayer18 loadSpriteLayer(final int spriteDataIndex) {
    final int spriteData = getSpriteData(spriteDataIndex);

    if(MEMORY.ref(1, spriteData).getUnsigned() == 0) {
      return null;
    }

    //LAB_800bbec
    //LAB_800bbf6
    final ArrayRef<SpriteLayer18> spriteLayers = boardWramMallocHead_3001e50.offset(3 * 0x4).deref(4).cast(ArrayRef.of(SpriteLayer18.class, 0x40, 0x18, SpriteLayer18::new));
    for(int spriteLayerSlot = 0; spriteLayerSlot < 0x40; spriteLayerSlot++) {
      final SpriteLayer18 layer = spriteLayers.get(spriteLayerSlot);
      if(layer._04.get() == 0) {
        layer.spriteDataIndex_00.set(spriteDataIndex);

        int r0_0 = MEMORY.ref(4, spriteData + 0xc).get();
        if(r0_0 == 0) {
          r0_0 = FUN_800b798(spriteDataIndex);
        }

        //LAB_800bc14
        layer._04.set(MEMORY.ref(1, spriteData + 0x4).getUnsigned());
        layer._05.set(0);
        layer._07.set(MEMORY.ref(1, spriteData + 0xa).getUnsigned());
        layer._08.set(r0_0);
        layer._0c.set(MEMORY.ref(4, spriteData + 0x10).get());
        layer.dataPtr_10.set(MEMORY.ref(4, spriteData + 0x10).deref(4).get());
        layer.dataOffset_14.set(0);
        layer._16.set(0xff);
        return layer;
      }
    }

    //LAB_800bbfc
    return null;
  }

  @Method(0x800bc48)
  public static void clearSpriteLayer(final SpriteLayer18 layer) {
    if(layer != null) {
      CPU.sp().value -= 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(0);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(layer.getAddress());
      DMA.channels[3].CNT.setu(0x85000006);
      CPU.sp().value += 0x4;
    }

    //LAB_800bc60
  }

  @Method(0x800bc70)
  public static Sprite38 loadSprite(final int spriteDataIndex) {
    final int spriteData = getSpriteData(spriteDataIndex);
    final int slot = getFreeVramSlot();
    final ArrayRef<Sprite38> sprites = boardWramMallocHead_3001e50.offset(4 * 0x4).deref(4).cast(ArrayRef.of(Sprite38.class, 64, 0x38, Sprite38::new));

    if(MEMORY.ref(1, spriteData).getUnsigned() == 0) {
      return null;
    }

    //LAB_800bc98
    //LAB_800bca2
    //LAB_800bcb0
    Sprite38 r8 = null;
    for(int r2 = 0; r2 < 64; r2++) {
      final Sprite38 r5 = sprites.get(r2);
      if(r5.width_20.get() == 0) {
        r8 = r5;
        break;
      }
    }

    //LAB_800bcb6
    if(r8 == null || slot == 0x60) {
      return null;
    }

    final int tileNum = allocateSpriteSlot(slot, 0, 0);
    if(tileNum == 0) {
      return null;
    }

    //LAB_800bcd6
    r8.slot_1c.set(slot);
    r8.rotation_1e.set(0);
    r8._26.set(1);

    final int r0_0 = MEMORY.ref(1, spriteData).getUnsigned() * 0x100 + MEMORY.ref(1, spriteData + 0x1).getUnsigned();
    final int r4;
    if(r0_0 == 0x810) {
      r4 = 0x8000;
    } else if(r0_0 == 0x1008) {
      r4 = 0x4000;
    } else if(r0_0 == 0x1010) {
      r4 = 0x40000000;
    } else if(r0_0 == 0x1020) {
      r4 = 0x80008000;
    } else if(r0_0 == 0x2010) {
      r4 = 0x80004000;
    } else if(r0_0 == 0x2020) {
      r4 = 0x80000000;
    } else if(r0_0 == 0x2040) {
      r4 = 0xc0008000;
    } else if(r0_0 == 0x4020) {
      r4 = 0xc0004000;
    } else if(r0_0 == 0x4040) {
      r4 = 0xc0000000;
    } else {
      r4 = 0;
    }

    //LAB_800bd5e
    //TODO
    r8.packet_00.next_00.clear();
    MEMORY.ref(4, r8.packet_00.attribs_04.attrib0_00.getAddress()).setu(r4 | 0x2000);
    MEMORY.ref(4, r8.packet_00.attribs_04.attrib2_04.getAddress()).setu(tileNum | 0x800);
    r8.shadowPacket_0c.next_00.clear();
    MEMORY.ref(4, r8.shadowPacket_0c.attribs_04.attrib0_00.getAddress()).setu(0x6000);
    MEMORY.ref(4, r8.shadowPacket_0c.attribs_04.attrib2_04.getAddress()).setu(vramSlots_3001b10.get(93).vramAddr_02.get() >>> 5 | 0x800);
    addLayerToSprite(r8, spriteDataIndex);

    //LAB_800bd9c
    return r8;
  }

  @Method(0x800bdd4)
  public static void clearSprite(final Sprite38 sprite) {
    if(sprite != null) {
      if((sprite._1d.get() & 0x1) == 0) {
        clearVramSlot(sprite.slot_1c.get());
      }

      //LAB_800bdee
      //LAB_800bdf4
      for(int r6 = 0; r6 < 4; r6++) {
        clearSpriteLayer(sprite.layers_28.get(r6).derefNullable());
      }

      CPU.sp().value -= 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(0);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(sprite.getAddress());
      DMA.channels[3].CNT.setu(0x8500000e);
      CPU.sp().value += 0x4;
    }

    //LAB_800be10
  }

  @Method(0x800be20)
  public static int FUN_800be20(int r0, final int r1, int r2) {
    int r3;
    int r5;
    final int r6;
    int r7;

    r6 = r1;
    r5 = r2;
    r0 = getSpriteData(r0);
    r3 = MEMORY.ref(1, r0 + 0x5).getUnsigned();
    r7 = 0x0;
    if((r6 & 0xffff_ffffL) >= (r3 & 0xffff_ffffL)) {
      return 0;
    }

    //LAB_800be36
    r2 = MEMORY.ref(4, r0 + 0x10).get();
    r3 = r6 << 2;
    r0 = MEMORY.ref(4, r3 + r2).get();

    //LAB_800be3c
    do {
      do {
        r2 = MEMORY.ref(1, r0).getUnsigned();
        r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
        r0 = r0 + 0x2;
        if(r2 == 0xfe || r2 == 0xf1 || r2 == 0xfd || r2 == 0xef) {
          return r7;
        }
        if(r2 == 0xf5 || r2 == 0xff) {
          break;
        }
      } while((r2 & 0xffff_ffffL) > 0xee);

      //LAB_800be5e
      r5 = r5 - 0x1;
      r7 = r7 + r3;
    } while(r5 != 0);

    //LAB_800be66
    //LAB_800be68
    return r7;
  }

  @Method(0x800be70)
  public static void FUN_800be70(final int r0, int r1) {
    final int r5 = 0x6010000 + vramSlots_3001b10.get(MEMORY.ref(1, r0 + 0x1c).getUnsigned()).vramAddr_02.get();
    final int r6 = MEMORY.ref(1, r0 + 0x21).getUnsigned() * MEMORY.ref(1, r0 + 0x20).getUnsigned() / 0x40;

    //LAB_800beae
    for(int r4 = 0; r4 < r6; r4++) {
      if(r1 >= 64 && r1 < 128) {
        final int r2 = MEMORY.ref(1, 0x801314c + (r1 + r4 * 0x10 & 0x3f)).getUnsigned();
        final int r0_0 = r5 + r1 * 0x40 + (r2 & 0x3e);
        final int r3;
        if((r2 & 0x1) != 0) {
          r3 = MEMORY.ref(1, r0_0).getUnsigned();
        } else {
          //LAB_800bed4
          r3 = MEMORY.ref(2, r0_0).getUnsigned() & 0xff00;
        }

        //LAB_800beda
        MEMORY.ref(2, r0_0).setu(r3);
      }

      //LAB_800bedc
      r1 = r1 + 0x1;
    }

    //LAB_800bee6
  }

  @Method(0x800c004)
  public static void initActors(final int r0) {
    final Struct5c r8 = MEMORY.ref(4, mallocSlotBoard(6, 0x5c), Struct5c::new);
    final int r6 = mallocSlotBoard(5, 0x70 * 64);
    FUN_800bb20(r0);

    CPU.sp().value -= 0x4;

    final int r4 = CPU.sp().value;
    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r6);
    DMA.channels[3].CNT.setu(0x85000700);

    MEMORY.ref(4, r4).setu(0);
    DMA.channels[3].SAD.setu(r4);
    DMA.channels[3].DAD.setu(r8.getAddress());
    DMA.channels[3].CNT.setu(0x85000017);

    CPU.sp().value += 0x4;

    if(r0 == 4) {
      setTickCallback(getRunnable(GoldenSun.class, "FUN_800d340"), 0xc8a);
    } else {
      //LAB_800c056
      setTickCallback(getRunnable(GoldenSun.class, "FUN_800cacc"), 0xc8a);
    }

    //LAB_800c05e
    CPU.cmpT(r0 - 3, 0x1);
    if(!CPU.cpsr().getCarry() || CPU.cpsr().getZero()) { // unsigned <=
      setTickCallback(getRunnable(GoldenSun.class, "FUN_800c880"), 0xc80);
    } else {
      //LAB_800c070
      setTickCallback(getRunnable(GoldenSun.class, "FUN_800c62c"), 0xc80);
      _3001d1c.set(0);
      _3001cc0.set(0);
    }

    //LAB_800c084
    r8._06.set(0xf);
    r8._07.set(0);
  }

  @Method(0x800c0cc)
  public static Actor70 FUN_800c0cc() {
    final int r2 = boardWramMallocHead_3001e50.offset(5 * 0x4).get();

    //LAB_800c0da
    //LAB_800c0e4
    for(int i = 0; i < 0x40; i++) {
      if(MEMORY.ref(4, r2 + i * 0x70).get() == 0) {
        return MEMORY.ref(4, r2 + i * 0x70, Actor70::new);
      }
    }

    //LAB_800c0ea
    return null;
  }

  @Method(0x800c0f4)
  public static void clearActor(final Actor70 r0) {
    if(r0 != null) {
      final int r2 = r0.spriteType_54.get() & 0xf;
      if(r2 == 1) {
        //LAB_800c112
        clearSprite(r0.sprite_50.deref());
      } else if(r2 == 2) {
        //LAB_800c11a
        final int r5 = r0.sprite_50.getPointer(); //TODO

        //LAB_800c11e
        for(int r6 = 0; r6 < 4; r6++) {
          final int r0_0 = MEMORY.ref(4, r5 + r6 * 0x4).get();

          if(r0_0 != 0) {
            clearSprite(MEMORY.ref(4, r0_0, Sprite38::new));
          }

          //LAB_800c128
        }
      }

      //LAB_800c12e
      CPU.sp().value -= 0x4;
      MEMORY.ref(4, CPU.sp().value).setu(0);
      DMA.channels[3].SAD.setu(CPU.sp().value);
      DMA.channels[3].DAD.setu(r0.getAddress());
      DMA.channels[3].CNT.setu(0x8500001c);
      CPU.sp().value += 0x4;
    }

    //LAB_800c13e
  }

  @Method(0x800c150)
  public static Actor70 loadActor(final int spriteTypeAndDataIndex, final int x, final int y, final int z) {
    final int spriteType = spriteTypeAndDataIndex >>> 12;
    final int spriteDataIndex = spriteTypeAndDataIndex & 0xfff;
    final Actor70 actor = FUN_800c0cc();
    if(actor != null) {
      //LAB_800c188
      actor.radius_20.set(0x10);
      if(spriteType == 0) {
        //LAB_800c196
        final Sprite38 sprite = loadSprite(spriteDataIndex);
        if(sprite != null) {
          actor.spriteType_54.set(1);
          actor.sprite_50.set(sprite);
          actor.radius_20.set(MEMORY.ref(1, getSpriteData(spriteDataIndex) + 0x9).getUnsigned() >> 1);
        } else {
          //LAB_800c1ba
          actor.spriteType_54.set(0);
        }
      } else if(spriteType == 2) {
        //LAB_800c1cc
        final Struct5c addr = boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new);
        final int r10 = addr.getAddress() + addr._18.get() * 0x4; //TODO
        actor.spriteType_54.set(2);

        int r8 = r10 + 0x8;
        actor.sprite_50.setPointer(r8); //TODO

        CPU.sp().value -= 0x4;
        MEMORY.ref(4, CPU.sp().value).setu(0);
        DMA.channels[3].SAD.setu(CPU.sp().value);
        DMA.channels[3].DAD.setu(r8);
        DMA.channels[3].CNT.setu(0x85000004);
        CPU.sp().value += 0x4;

        Sprite38 r5_0 = loadSprite(spriteDataIndex);
        if(r5_0 != null) {
          actor.radius_20.set(MEMORY.ref(1, getSpriteData(spriteDataIndex) + 0x9).getUnsigned() >>> 1);
          MEMORY.ref(4, r8).setu(r5_0.getAddress()); //TODO
          r8 = r10 + 0xc;
        }

        //LAB_800c220
        r5_0 = loadSprite(spriteDataIndex + 0x1);
        if(r5_0 != null) {
          MEMORY.ref(4, r8).setu(r5_0.getAddress()); //TODO
        }

        addr._18.incr();
      }

      //LAB_800c230
      setActorPosition(actor, x, y, z);
      actor.scriptPtr_00.set(0x801358c); //TODO
      actor.scriptPos_04.set(0);
      actor.angle_06.set(0x4000);
      actor.scale_18.set(0x10000);
      actor._1c.set(0x10000);
      actor.velocityScalar_30.set(0x20000);
      actor.acceleration_34.set(0x10000);
      actor._44.set(0x4000);
      actor._48.set(0x10000);
      actor._4c.set(0);
      actor._55.set(0x3);
      actor._59.set(0);
      actor._5a.set(0x1);
      actor._64.set(x / 0x10000);
      actor._66.set(z / 0x10000);
    }

    //LAB_800c2be

    return actor;
  }

  @Method(0x800c2d8)
  public static void setActorSpriteScript(final Actor70 actor, final int script) {
    if(actor != null) {
      actor.scriptPtr_00.set(script);
      actor.scriptPos_04.set(0);
      actor._5b.set(0);
      actor._5d.set(0);
      actor._63.set(0);
    }

    //LAB_800c2fc
  }

  @Method(0x800c300)
  public static void setActorAnimation(final Actor70 actor, final int animationIndex) {
    if(actor != null) {
      final int r2 = actor.spriteType_54.get() & 0xf;

      if(r2 == 1) {
        //LAB_800c31c
        setSpriteAnimation(actor.sprite_50.deref(), animationIndex);
      } else if(r2 == 2) {
        //LAB_800c326
        final int r5 = actor.sprite_50.getPointer(); //TODO

        //LAB_800c32a
        for(int i = 0; i < 4; i++) {
          final int r0_0 = MEMORY.ref(4, r5 + i * 0x4).get();

          if(r0_0 != 0) {
            setSpriteAnimation(MEMORY.ref(4, r0_0, Sprite38::new), animationIndex);
          }

          //LAB_800c336
        }
      }
    }

    //LAB_800c33c
  }

  @Method(0x800c344)
  public static void FUN_800c344(final Actor70 actor, final int r1) {
    if(actor != null) {
      final int spriteType = actor.spriteType_54.get() & 0xf;
      if(spriteType == 1) {
        //LAB_800c360
        FUN_800baf8(actor.sprite_50.deref(), r1);
      } else if(spriteType == 2) {
        //LAB_800c36a
        final Sprite38 r5 = actor.sprite_50.deref();

        //LAB_800c36e
        for(int i = 0; i < 4; i++) {
          final int r0_0 = MEMORY.ref(4, r5.getAddress() + i * 0x4).get(); //TODO

          if(r0_0 != 0) {
            FUN_800baf8(MEMORY.ref(4, r0_0, Sprite38::new), r1);
          }

          //LAB_800c37a
        }
      }
    }

    //LAB_800c380
  }

  @Method(0x800c430)
  public static void addLayerToSpriteIfRegularSprite(@Nullable final Actor70 r0, final int spriteDataIndex) {
    if(r0 != null && (r0.spriteType_54.get() & 0xf) == 1 && spriteDataIndex >= 0) {
      addLayerToSprite(r0.sprite_50.deref(), spriteDataIndex);
    }

    //LAB_800c44e
  }

  @Method(0x800c46c)
  public static void FUN_800c46c(final Actor70 actor) {
    setActorSpriteScript(actor, 0x8013590);
  }

  @Method(0x800c47c)
  public static void FUN_800c47c(final Actor70 actor) {
    setActorSpriteScript(actor, 0x80135a8);
  }

  @Method(0x800c48c)
  public static void FUN_800c48c(final Actor70 actor) {
    setActorSpriteScript(actor, 0x80135c0);
  }

  @Method(0x800c49c)
  public static void FUN_800c49c(final Actor70 actor) {
    setActorSpriteScript(actor, 0x80135d8);
  }

  @Method(0x800c4ac)
  public static void FUN_800c4ac(final Actor70 r0) {
    setActorSpriteScript(r0, 0x8013620); //TODO
  }

  @Method(0x800c4bc)
  public static void FUN_800c4bc(final Actor70 r0, @Nullable final Actor70 r1) {
    setActorSpriteScript(r0, 0x80135f0); //TODO

    if(r1 != null) {
      r0.velocityScalar_30.set(0x40000);
      r0.acceleration_34.set(0x8000);
      r0._64.set(0);
      r0._68.set(r1);
    }

    //LAB_800c4e2
  }

  @Method(0x800c4ec)
  public static void FUN_800c4ec(final Actor70 r0) {
    int r6 = 0;
    //LAB_800c500
    while(MEMORY.ref(4, r0.scriptPtr_00.get() + r0.scriptPos_04.get() * 0x4).get() != 0x10) {
      sleep(0x1);
      r6++;
      if(r6 > 0x12b) {
        break;
      }
    }

    //LAB_800c51c
  }

  @Method(0x800c528)
  public static void FUN_800c528(final Actor70 actor, final int r1) {
    if(actor != null && (actor.spriteType_54.get() & 0xf) == 1) {
      actor.sprite_50.deref()._26.set(r1);
    }

    //LAB_800c542
  }

  @Method(0x800c548)
  public static void FUN_800c548(final Actor70 actor, final int r1) {
    if(actor != null && actor.spriteType_54.get() == 1) {
      actor.sprite_50.deref().packet_00.attribs_04.flags_01.and(~0xc).or((r1 & 0x3) << 2);
    }
  }

  @Method(0x800c598)
  public static void FUN_800c598(final Actor70 r0, final int r1) {
    if(r0 != null && r0.spriteType_54.get() == 1) {
      FUN_800b684(r0.sprite_50.deref(), r1);
    }

    //LAB_800c5ae
  }

  @Method(0x800c5b4)
  public static void FUN_800c5b4() {
    disableTickCallback(getRunnable(GoldenSun.class, "FUN_800c62c"));
    disableTickCallback(getRunnable(GoldenSun.class, "FUN_800c880"));
    FUN_808a330(0x10000, 0x1);
    FUN_808a348(0x1);
    sleep(0x1);
    GPU.DISPCNT.and(0xf1ff).oru(0x1000);
  }

  @Method(0x800c5fc)
  public static void FUN_800c5fc() {
    enableTickCallback(getRunnable(GoldenSun.class, "FUN_800c62c"));
    enableTickCallback(getRunnable(GoldenSun.class, "FUN_800c880"));
    GPU.DISPCNT.and(0xe1ff);
  }

  @Method(0x800c62c)
  public static void FUN_800c62c() {
    CPU.sp().value -= 0x50;
    final Map194 sp0c = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    final int sp08 = sp0c._e4.get() & 0xffff0000;
    final int sp04 = sp0c._e8.get() & 0xffff0000;
    final Struct5c sp00 = boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new);

    final int size = 0x2c4;
    final int addr = mallocSlotChip(52, size);
    DMA.channels[3].SAD.setu(0x8009bb8);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    MEMORY.setFunction(addr, CopiedSegment8009bb8.class, "FUN_8009bb8", int.class, int.class, int.class);

    sp00._00.set(0);

    //LAB_800c696
    final int actors = boardWramMallocHead_3001e50.offset(5 * 0x4).get();
    for(int i = 0; i < 0x40; i++) {
      final Actor70 actor = MEMORY.ref(4, actors + i * 0x70, Actor70::new);

      jmp_800c822:
      if(actor.scriptPtr_00.get() != 0) {
        final Sprite38 r5 = actor.sprite_50.derefNullable();

        //LAB_800c6a0
        int r2;

        //LAB_800c6ae
        if((actor.spriteType_54.get() & 0xf) == 1) {
          if(actor.pos_08.getX() != 0 || actor.pos_08.getZ() != 0) {
            //LAB_800c6c2
            if(sp00._04.get() != 0 && actor._5c.get() == 0) {
              FUN_8003f78(r5.slot_1c.get());
              r5._25.set(1);
              break jmp_800c822;
            }

            //LAB_800c6e0
            final int r6 = actor.pos_08.getZ() - sp04;
            final int r9 = actor.pos_08.getX() - sp08;
            r2 = r6 - actor.pos_08.getY();
            if(r9 > -0x200000 && r9 < 0x1100000 && r2 > -0x200000 && r2 < 0xe00000) {
              final TileAttributes04 tile = sp0c.layers_104.get(actor.layer_22.get()).tiles_2c.deref().get((actor.pos_08.getZ() >> 20) * 0x80 + (actor.pos_08.getX() >> 20));

              //LAB_800c762
              if((actor.flags_23.get() & 0x1) != 0) {
                final int priority = tile.getPriority();
                if(priority != 0) {
                  r5.packet_00.attribs_04.attrib2_04.and(~0xc00).or(priority << 10);
                  r5.shadowPacket_0c.attribs_04.attrib2_04.and(~0xc00).or(priority << 10);
                }
              }

              //LAB_800c764
              final int layerChange = tile.getLayerChange();
              if(layerChange != 0) {
                actor.layer_22.set(layerChange - 1);
              }

              //LAB_800c774
              final int r1 = CPU.sp().value + 0x1c;
              r2 = CPU.sp().value + 0x14;
              MEMORY.ref(4, r2).setu((int)MEMORY.call(0x3000118, actor.scale_18.get(), r5.scale_18.get()));
              MEMORY.ref(4, r2 + 0x4).setu((int)MEMORY.call(0x3000118, actor._1c.get(), r5.scale_18.get()));
              MEMORY.ref(4, r1).setu(r9);
              MEMORY.ref(4, r1 + 0x8).setu(r6);
              MEMORY.ref(4, r1 + 0x4).setu(actor.pos_08.getY());
              MEMORY.ref(4, r1 + 0xc).setu(actor._14.get());

              if((actor.flags_23.get() & 0x2) != 0) {
                MEMORY.ref(4, r1 + 0x4).addu(0xfec00000);
                MEMORY.ref(4, r1 + 0x8).addu(0xfec00000);
                MEMORY.ref(4, r1 + 0xc).addu(0xfec00000);
              }

              //LAB_800c7be
              if((actor.flags_23.get() & 0x4) != 0) {
                MEMORY.ref(4, r1 + 0x4).addu(0x1400000);
                MEMORY.ref(4, r1 + 0x8).addu(0x1400000);
                MEMORY.ref(4, r1 + 0xc).addu(0x1400000);
              }

              //LAB_800c7dc
              drawSprite(r5, r1, r2, actor.angle_06.get());
              break jmp_800c822;
            }
          }

          //LAB_800c7ea
          if(actor._5c.get() == 0) {
            //LAB_800c80e
            if((r5._1d.get() & 0x1) == 0) {
              FUN_8003f78(r5.slot_1c.get());
              r5._25.set(0x1);
            }
          }
        }
      }
    }

    //LAB_800c836
    freeSlot(52);
    CPU.sp().value += 0x50;
  }

  /** Draws battle actors */
  @Method(0x800c880)
  public static void FUN_800c880() {
    final Camera4c camera = boardWramMallocHead_3001e50.offset(12 * 0x4).deref(4).cast(Camera4c::new);
    final Struct5c r8 = boardWramMallocHead_3001e50.offset(6 * 0x4).deref(4).cast(Struct5c::new);
    CPU.sp().value -= 0x34;

    final int size = 0x2c4;
    final int addr = mallocSlotChip(52, size);
    DMA.channels[3].SAD.setu(0x8009bb8);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size >>> 2);
    MEMORY.setFunction(addr, CopiedSegment8009bb8.class, "FUN_8009bb8", int.class, int.class, int.class);

    final Vec3 r5;
    if(!camera._18.isNull()) {
      r5 = camera._18.deref();
    } else {
      r5 = camera._00;
    }

    //LAB_800c8c4
    final Vec3 r6;
    if(!camera._1c.isNull()) {
      r6 = camera._1c.deref();
    } else {
      r6 = camera._0c;
    }

    //LAB_800c8cc
    r8._00.set(0);
    int angle = (short)atan2(r5.getX() - r6.getX() >> 16, r5.getZ() - r6.getZ() >> 16);
    initMatrixStack();

    if(readFlag_(0x16b) != 0) {
      angle -= 0x2000;
      mulTransforms(_8013190);
      FUN_80051e8(r5, r6);
    } else {
      //LAB_800c910
      FUN_80051d8(r5, r6);
    }

    //LAB_800c918
    final ArrayRef<Actor70> actors = boardWramMallocHead_3001e50.offset(5 * 0x4).deref(4).cast(ArrayRef.of(Actor70.class, 64, 0x70, Actor70::new));

    //LAB_800c930
    for(int sp08 = 63; sp08 >= 0; sp08--) {
      final Actor70 actor = actors.get(sp08);

      if(actor.scriptPtr_00.get() != 0) {
        final int spriteType = actor.spriteType_54.get() & 0xf;

        if(spriteType == 1) {
          //LAB_800c950
          final int r6_0 = CPU.sp().value + 0x14;
          MEMORY.ref(4, r6_0).setu(actor.scale_18.get());
          MEMORY.ref(4, r6_0 + 0x4).setu(actor._1c.get());
          if(readFlag_(0x16b) != 0) {
            MEMORY.ref(4, r6_0).setu(0x10000);
            MEMORY.ref(4, r6_0 + 0x4).setu(0x10000);
          }

          //LAB_800c972
          drawBattleSprite(actor.sprite_50.deref(), actor.pos_08, r6_0, actor.angle_06.get() + angle, actor.layer_22.get());
        } else if(spriteType == 2) {
          //LAB_800c988
          final int r4 = CPU.sp().value + 0xc;
          MEMORY.ref(4, r4).setu(actor.scale_18.get());
          MEMORY.ref(4, r4 + 0x4).setu(actor._1c.get());

          if(readFlag_(0x16b) != 0) {
            MEMORY.ref(4, r4).setu(0x10000);
            MEMORY.ref(4, r4 + 0x4).setu(0x10000);
          }

          //LAB_800c9a6
          final int sprites = actor.sprite_50.getPointer();

          //LAB_800c9ac
          for(int spriteIndex = 0; spriteIndex < 4; spriteIndex++) {
            final Sprite38 sprite = MEMORY.ref(4, sprites + spriteIndex * 0x4).deref(4).cast(Sprite38::new);

            if(sprite != null) {
              drawBattleSprite(sprite, actor.pos_08, r4, actor.angle_06.get() + angle, actor.layer_22.get());
            }

            //LAB_800c9cc
          }
        }
      }

      //LAB_800c9d8
    }

    freeSlot(52);
    CPU.sp().value += 0x34;
  }

  @Method(0x800ca6c)
  public static void FUN_800ca6c(final Actor70 r0) {
    //LAB_800ca74
    for(int r5 = 0; FUN_800ca98(r0) == 0 && r5 <= 0x100; r5++) {
      sleep(0x1);
    }

    //LAB_800ca8c
  }

  @Method(0x800ca98)
  public static int FUN_800ca98(final Actor70 r0) {
    //LAB_800cab2
    if(r0.dest_38.getX() != 0x80000000) {
      return 0;
    }

    if(r0._55.get() == 0 && r0.dest_38.getY() != 0x80000000) {
      return 0;
    }

    //LAB_800cab8
    if(r0.dest_38.getZ() != 0x80000000) {
      return 0;
    }

    //LAB_800cac6
    return 1;
  }

  @Method(0x800cacc)
  public static void FUN_800cacc() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x30;

    final int r6_0 = boardWramMallocHead_3001e50.offset(5 * 0x4).get();

    //LAB_800caf0
    for(int sp20 = 0; sp20 < 0x40; sp20++) {
      final Actor70 r6 = MEMORY.ref(4, r6_0 + sp20 * 0x70, Actor70::new);

      int sp0c = 0;
      r2 = r6.scriptPtr_00.get();

      jmp_800d0fe:
      if(r2 != 0) {
        //LAB_800cafc
        if(!r6._6c.isNull()) {
          r6._6c.deref().run(r6);
          r2 = r6.scriptPtr_00.get();
        }

        //LAB_800cb0a
        if(r2 != 0) {
          //LAB_800cb10
          if(r6._5b.get() == 0) {
            //LAB_800cb1a
            if(r6._5e.get() != 0) {
              r6._5e.decr();
            } else {
              //LAB_800cb2c
              //LAB_800cb36
              do {
                r3 = MEMORY.ref(4, r2 + r6.scriptPos_04.get() * 0x4).get();
                if(r3 < 0 || r3 > 0x3f) {
                  r6.scriptPos_04.incr();
                  r2 = r6.scriptPtr_00.get();
                  continue;
                }

                if(_8013624.get(r3).deref().run(r6) != 0) {
                  r2 = r6.scriptPtr_00.get();
                  continue;
                }

                break;
              } while(true);

              if(r6.scriptPtr_00.get() == 0) {
                break jmp_800d0fe;
              }
            }

            //LAB_800cb5a
            int sp1c = r6.pos_08.getX();
            int sp18 = r6.pos_08.getY();
            int sp14 = r6.pos_08.getZ();
            if(r6._61.get() == 0) {
              //LAB_800cb70
              if(r6._55.get() == 0) {
                //LAB_800cb7a
                if(r6.dest_38.getX() != 0x80000000) {
                  //LAB_800cb86
                  CPU.r8().value = (r6.dest_38.getX() - sp1c) / 0x10000;
                  CPU.r11().value = (r6.dest_38.getY() - sp18) / 0x10000;
                  CPU.r9().value = (r6.dest_38.getZ() - sp14) / 0x10000;
                  r0 = sqrt(CPU.r8().value * CPU.r8().value + CPU.r11().value * CPU.r11().value + CPU.r9().value * CPU.r9().value);
                  if(r0 == 0) {
                    sp1c = r6.dest_38.getX();
                    sp18 = r6.dest_38.getY();
                    sp14 = r6.dest_38.getZ();
                  } else {
                    //LAB_800cbe8
                    r5 = (int)MEMORY.call(0x300013c, r0 << 16, r6.acceleration_34.get());
                    r0 = r6.velocity_24.getX() + CPU.r8().value * r5;
                    r7 = r6.velocity_24.getY() + CPU.r11().value * r5;
                    r3 = r6.velocity_24.getZ() + CPU.r9().value * r5;
                    CPU.r10().value = r0;
                    CPU.r9().value = r3;
                    r6.velocity_24.set(r0, r7, r3);

                    final int sqrt = sqrt16((int)MEMORY.call(0x3000118, CPU.r10().value, CPU.r10().value) + (int)MEMORY.call(0x3000118, r7, r7) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                    if(sqrt > r6.velocityScalar_30.get()) {
                      //LAB_800cc4e
                      r5 = (int)MEMORY.call(0x300013c, sqrt, r6.velocityScalar_30.get());
                      r6.velocity_24.setX((int)MEMORY.call(0x3000118, CPU.r10().value, r5));
                      r6.velocity_24.setY((int)MEMORY.call(0x3000118, r7, r5));
                      r6.velocity_24.setZ((int)MEMORY.call(0x3000118, CPU.r9().value, r5));
                    }
                  }
                } else {
                  //LAB_800cc7c
                  CPU.r8().value = r6.velocity_24.getX();
                  CPU.r11().value = r6.velocity_24.getY();
                  CPU.r9().value = r6.velocity_24.getZ();

                  r0 = sqrt16((int)MEMORY.call(0x3000118, CPU.r8().value, CPU.r8().value) + (int)MEMORY.call(0x3000118, CPU.r11().value, CPU.r11().value) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                  if(r0 != 0) {
                    r5 = (int)MEMORY.call(0x300013c, r0, Math.max(0, r0 - r6.acceleration_34.get()));
                    r6.velocity_24.setX((int)MEMORY.call(0x3000118, CPU.r8().value, r5));
                    r6.velocity_24.setY((int)MEMORY.call(0x3000118, CPU.r11().value, r5));
                    r6.velocity_24.setZ((int)MEMORY.call(0x3000118, CPU.r9().value, r5));
                  } else {
                    //LAB_800ccf0
                    r6.velocity_24.zero();
                  }
                }
              } else {
                //LAB_800ccf8
                if(r6.dest_38.getX() != 0x80000000) {
                  //LAB_800cd04
                  CPU.r8().value = (r6.dest_38.getX() - sp1c) / 0x10000;
                  CPU.r9().value = (r6.dest_38.getZ() - sp14) / 0x10000;

                  r0 = sqrt(CPU.r8().value * CPU.r8().value + CPU.r9().value * CPU.r9().value) << 16;
                  if(r0 < 0x1000000) {
                    CPU.r8().value = r6.dest_38.getX() - sp1c;
                    CPU.r9().value = r6.dest_38.getZ() - sp14;
                    r0 = sqrt16((int)MEMORY.call(0x3000118, CPU.r8().value, CPU.r8().value) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                  }

                  //LAB_800cd70
                  if(r0 == 0) {
                    sp1c = r6.dest_38.getX();
                    sp14 = r6.dest_38.getZ();
                  } else {
                    //LAB_800cd9c
                    r5 = (int)MEMORY.call(0x300013c, r0, r6.acceleration_34.get());
                    CPU.r10().value = r6.velocity_24.getX() + (int)MEMORY.call(0x3000118, CPU.r8().value, r5);
                    CPU.r9().value = r6.velocity_24.getZ() + (int)MEMORY.call(0x3000118, CPU.r9().value, r5);
                    r6.velocity_24.setX(CPU.r10().value);
                    r6.velocity_24.setZ(CPU.r9().value);
                    r0 = sqrt16((int)MEMORY.call(0x3000118, CPU.r10().value, CPU.r10().value) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                    r1 = r6.velocityScalar_30.get();
                    if(r0 > r1) {
                      r5 = (int)MEMORY.call(0x300013c, r0, r1);
                      r6.velocity_24.setX((int)MEMORY.call(0x3000118, CPU.r10().value, r5));
                      r6.velocity_24.setZ((int)MEMORY.call(0x3000118, CPU.r9().value, r5));
                    }
                  }
                } else {
                  //LAB_800ce0e
                  CPU.r8().value = r6.velocity_24.getX();
                  CPU.r9().value = r6.velocity_24.getZ();
                  r0 = sqrt16((int)MEMORY.call(0x3000118, CPU.r8().value, CPU.r8().value) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                  if(r0 != 0) {
                    r5 = (int)MEMORY.call(0x300013c, r0, Math.max(0, r0 - r6.acceleration_34.get()));
                    r6.velocity_24.setX((int)MEMORY.call(0x3000118, CPU.r8().value, r5));
                    r6.velocity_24.setZ((int)MEMORY.call(0x3000118, CPU.r9().value, r5));
                  } else {
                    //LAB_800ce62
                    r6.velocity_24.setX(0);
                    r6.velocity_24.setZ(0);
                  }
                }

                //LAB_800ce66
                r2 = r6._55.get();
                if((r2 & 0x1) != 0) {
                  //LAB_800ce74
                  r1 = sp1c + r6.velocity_24.getX();
                  r2 = sp14 + r6.velocity_24.getZ();
                  CPU.r10().value = r1;
                  CPU.r9().value = r2;
                  r0 = getHeight(r6.layer_22.get(), r1, r2);
                  MEMORY.ref(4, CPU.sp().value + 0x10).setu(r0);
                  r7 = r0 - r6._14.get();
                  if(r0 - sp18 > -0x40000) {
                    sp18 += r7;
                  }

                  //LAB_800cea2
                  if(r7 < 0) {
                    r7 = -r7;
                  }

                  //LAB_800cea8
                  r3 = r6.acceleration_34.get() / 2;
                  if(r7 > r3) {
                    r7 = r3;
                  }

                  //LAB_800ceb6
                  r7 = r7 * 3;
                  if(r7 != 0) {
                    r2 = r6._55.get();
                    if((r2 & 0x10) == 0) {
                      CPU.r8().value = r6.velocity_24.getX();
                      CPU.r11().value = r6.velocity_24.getY();
                      CPU.r9().value = r6.velocity_24.getZ();
                      r0 = sqrt16((int)MEMORY.call(0x3000118, CPU.r8().value, CPU.r8().value) + (int)MEMORY.call(0x3000118, CPU.r11().value, CPU.r11().value) + (int)MEMORY.call(0x3000118, CPU.r9().value, CPU.r9().value));
                      if(r0 != 0) {
                        r5 = (int)MEMORY.call(0x300013c, r0, Math.max(0, r0 - r7));
                        r6.velocity_24.setX((int)MEMORY.call(0x3000118, CPU.r8().value, r5));
                        r6.velocity_24.setY((int)MEMORY.call(0x3000118, CPU.r11().value, r5));
                        r6.velocity_24.setZ((int)MEMORY.call(0x3000118, CPU.r9().value, r5));
                      }
                    }
                  }

                  //LAB_800cf3e
                  r6._14.set(MEMORY.ref(4, CPU.sp().value + 0x10).get());
                }

                //LAB_800cf42
                r2 = r6._55.get();
                if((r2 & 0x2) != 0) {
                  r4 = r6._14.get();
                  MEMORY.ref(4, CPU.sp().value + 0x10).setu(r4);
                  if(sp18 > r4) {
                    r6.velocity_24.y_04.sub(r6._48.get());
                  } else {
                    //LAB_800cf60
                    r0 = r6.velocity_24.getY();
                    if(r0 < 0) {
                      sp18 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
                      r0 = (int)MEMORY.call(0x3000118, r0, r6._44.get());
                      r2 = -r0;
                      r6.velocity_24.setY(r2);
                      if(r2 < 0) {
                        r2 = r0;
                      }

                      //LAB_800cf80
                      if(r2 <= r6._48.get()) {
                        //LAB_800cf88
                        r6.velocity_24.setY(0);
                      }
                    }
                  }
                }

                //LAB_800cf8a
                r2 = r6._55.get();
                if((r2 & 0x4) != 0) {
                  r1 = r6._44.get() & 0x3f;
                  if((r2 & 0x8) != 0) {
                    r3 = CPU.lsrT(r1, 1);
                    r3 = CPU.lslT(r3, 2);
                    r2 = MEMORY.ref(4, 0x80131c0 + r3).get();
                    r3 = r6._48.get() * r2 / 0x10;
                  } else {
                    //LAB_800cfba
                    r3 = CPU.lsrT(r1, 1);
                    r3 = CPU.lslT(r3, 2);
                    r2 = MEMORY.ref(4, 0x80131c0 + r3).get();
                    r3 = r6._48.get() * r2 / 0x40;
                  }

                  //LAB_800cfce
                  r6.velocity_24.setY(r3);
                  r6._44.incr();
                }
              }
            }

            //LAB_800cfd6
            sp1c += r6.velocity_24.getX();
            sp18 += r6.velocity_24.getY();
            sp14 += r6.velocity_24.getZ();

            if((r6._59.get() & 0x80) != 0) {
              final Vec3 sp24 = new Vec3();
              sp24.set(sp1c, sp18, sp14);

              if(FUN_800d924(r6, sp24) == 0) {
                //LAB_800d018
                r6._60.set(0);
              } else {
                r6._60.incr();
                break jmp_800d0fe;
              }
            }

            //LAB_800d01c
            r3 = r6._56.get();
            if(r3 == 0x10) {
              //LAB_800d034
              r2 = r6.dest_38.getX();
              if(sp1c == r2 || (r6.pos_08.getX() - r2 ^ sp1c - r2) < 0) {
                sp0c = 0x1;
              }
              //LAB_800d02e
            } else if(r3 == 0x11) {
              //LAB_800d042
              r2 = r6.dest_38.getY();
              if(sp18 == r2 || (r6.pos_08.getY() - r2 ^ sp18 - r2) < 0) {
                sp0c = 0x1;
              }
            } else if(r3 == 0x12) {
              //LAB_800d060
              r2 = r6.dest_38.getZ();
              if(sp14 == r2 || (r6.pos_08.getZ() - r2 ^ sp14 - r2) < 0) {
                sp0c = 0x1;
              }
            }

            //LAB_800d07a
            if(sp0c != 0) {
              if(r6._58.get() != 0) {
                sp1c = r6.dest_38.getX();
                sp14 = r6.dest_38.getZ();
                r6.velocity_24.setX(0);
                r6.velocity_24.setZ(0);
                if(r6._55.get() == 0) {
                  sp18 = r6.dest_38.getY();
                  r6.velocity_24.setY(0);
                }
              }

              //LAB_800d0a2
              r6.dest_38.set(0x80000000, 0x80000000, 0x80000000);
              r6._56.set(0);
            }

            //LAB_800d0b0
            r6.pos_08.set(sp1c, sp18, sp14);

            if((r6._5a.get() & 0x1) != 0) {
              sp1c = r6.velocity_24.getX();
              sp14 = r6.velocity_24.getZ();
              if(sp1c != 0 || sp14 != 0) {
                //LAB_800d0d8
                r0 = atan2(sp14, sp1c) - r6.angle_06.get();
                r0 = CPU.lslT(r0, 16);
                r0 = CPU.asrT(r0, 16);
                if(r0 > 0x1000) {
                  r0 = 0x1000;
                }

                //LAB_800d0f2
                if(r0 < -0x1000) {
                  r0 = -0x1000;
                }

                //LAB_800d0fa
                r6.angle_06.add(r0);
              }
            }
          }
        }
      }

      //LAB_800d0fe
    }

    //LAB_800d118
    CPU.sp().value += 0x30;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x800d130)
  public static void setActorPosition(final Actor70 actor, final int x, final int y, final int z) {
    actor.pos_08.set(x, y, z);
    actor.velocity_24.zero();
    actor.dest_38.set(0x80000000, 0x80000000, 0x80000000);
  }

  @Method(0x800d14c)
  public static void FUN_800d14c(final Actor70 r0, final int x, final int y, final int z) {
    int x1 = x;
    int y1 = y;
    int z1 = z;
    int r1_0 = (x1 - r0.pos_08.getX()) / 0x10000;
    int r5 = (y1 - r0.pos_08.getY()) / 0x10000;
    int r6 = (z1 - r0.pos_08.getZ()) / 0x10000;
    r5 = sqrt(r1_0 * r1_0 + r5 * r5 + r6 * r6) >> 16;
    if(r5 < 0x100000) {
      r1_0 = x1 - r0.pos_08.getX();
      r5 = y1 - r0.pos_08.getY();
      r6 = z1 - r0.pos_08.getZ();
      r5 = sqrt16((int)MEMORY.call(0x3000118, r1_0, r1_0) + (int)MEMORY.call(0x3000118, r5, r5) + (int)MEMORY.call(0x3000118, r6, r6));
    }

    //LAB_800d1ec
    if(r5 < 0x10000) {
      r0.pos_08.set(x1, y1, z1);
      r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
    } else {
      //LAB_800d20c
      if(r0._58.get() == 0) {
        r1_0 = r0.velocityScalar_30.get();
        r1_0 = (int)MEMORY.call(0x3000118, r1_0, r1_0);
        r1_0 = (int)MEMORY.call(0x300013c, r0.acceleration_34.get(), r1_0);
        if(r5 > r1_0) {
          r1_0 = r5 - r1_0 / 2;
        } else {
          //LAB_800d23a
          r1_0 = r5 / 2;
        }

        //LAB_800d240
        r5 = (int)MEMORY.call(0x300013c, r5, r1_0);
        int r4 = r0.pos_08.getX();
        x1 = r4 + (int)MEMORY.call(0x3000118, x1 - r4, r5);
        r4 = r0.pos_08.getY();
        y1 = r4 + (int)MEMORY.call(0x3000118, y1 - r4, r5);
        r4 = r0.pos_08.getZ();
        z1 = r4 + (int)MEMORY.call(0x3000118, z1 - r4, r5);
      }

      //LAB_800d27c
      r0.dest_38.set(x1, y1, z1);
      r1_0 = x1 - r0.pos_08.getX();
      r5 = y1 - r0.pos_08.getY();
      r6 = z1 - r0.pos_08.getZ();
      r0._56.set(0x10);

      //LAB_800d2ae
      //LAB_800d2b6
      if(Math.abs(r1_0) < Math.abs(r6)) {
        r0._56.set(0x12);
        r1_0 = r6;
      }

      //LAB_800d2c2
      if(r0._55.get() == 0) {
        //LAB_800d2d2
        //LAB_800d2da
        if(Math.abs(r1_0) < Math.abs(r5)) {
          r0._56.set(0x11);
        }
      }
    }

    //LAB_800d2e4
  }

  /** Battle actor renderer or something? */
  @Method(0x800d340)
  public static void FUN_800d340() {
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
    r3 = 0x3001e64;
    r5 = MEMORY.ref(4, r3).get();
    r2 = r5;
    CPU.sp().value -= 0x10;
    r0 = 0xd;
    r2 = r2 + 0x55;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r0);
    MEMORY.ref(4, CPU.sp().value).setu(r2);

    //LAB_800d35e
    do {
      r3 = MEMORY.ref(4, r5).get();
      if(r3 != 0) {
        //LAB_800d366
        r4 = MEMORY.ref(4, r5 + 0xc).get();
        r3 = MEMORY.ref(4, r5 + 0x8).get();
        r2 = MEMORY.ref(4, CPU.sp().value).get();
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
        CPU.r11().value = r3;
        r0 = MEMORY.ref(4, r5 + 0x10).get();
        r3 = MEMORY.ref(1, r2 + 0xc).getUnsigned();
        CPU.r9().value = r0;
        if(r3 != 0) {
          r0 = MEMORY.ref(4, r5 + 0x28).get();
        } else {
          //LAB_800d37c
          r3 = 0x0;
          MEMORY.ref(4, CPU.sp().value + 0x4).setu(r3);
          r4 = 0x80;
          r3 = MEMORY.ref(4, r5 + 0x38).get();
          r4 = r4 << 24;
          if(r3 != r4) {
            //LAB_800d38c
            r2 = CPU.r11().value;
            r0 = r3 - r2;
            if(r0 < 0) {
              r3 = 0xffff;
              r0 = r0 + r3;
            }

            //LAB_800d398
            r3 = MEMORY.ref(4, r5 + 0x40).get();
            r4 = CPU.r9().value;
            r6 = r0 >> 16;
            r0 = r3 - r4;
            if(r0 < 0) {
              r2 = 0xffff;
              r0 = r0 + r2;
            }

            //LAB_800d3a8
            r7 = r0 >> 16;
            r3 = r7;
            r3 = r3 * r7;
            r0 = r6;
            r0 = r0 * r6;
            r0 = r0 + r3;
            r0 = sqrt(r0);
            r4 = 0xffffff;
            r0 = r0 << 16;
            if(r0 <= r4) {
              r3 = MEMORY.ref(4, r5 + 0x38).get();
              r0 = CPU.r11().value;
              r6 = r3 - r0;
              r3 = MEMORY.ref(4, r5 + 0x40).get();
              r2 = CPU.r9().value;
              r7 = r3 - r2;
              r0 = r6;
              r1 = r6;
              r3 = 0x3000118;
              r0 = (int)MEMORY.call(r3, r0, r1);
              r3 = r0;
              r1 = r7;
              r0 = r7;
              r4 = 0x3000118;
              r0 = (int)MEMORY.call(r4, r0, r1);
              r3 = r3 + r0;
              r0 = r3;
              r0 = sqrt(r0);
              r0 = r0 << 8;
            }

            //LAB_800d3f0
            if(r0 == 0) {
              r3 = MEMORY.ref(4, r5 + 0x38).get();
              r4 = MEMORY.ref(4, r5 + 0x40).get();
              CPU.r11().value = r3;
              CPU.r9().value = r4;
            } else {
              //LAB_800d3fe
              r1 = MEMORY.ref(4, r5 + 0x34).get();
              r2 = 0x300013c;
              r0 = (int)MEMORY.call(r2, r0, r1);
              r3 = 0x3000118;
              r4 = r0;
              CPU.r8().value = r3;
              r0 = r6;
              r1 = r4;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              r3 = MEMORY.ref(4, r5 + 0x24).get();
              r3 = r3 + r0;
              CPU.r10().value = r3;
              MEMORY.ref(4, r5 + 0x24).setu(r3);
              r0 = r7;
              r1 = r4;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              r3 = MEMORY.ref(4, r5 + 0x2c).get();
              r6 = r3 + r0;
              MEMORY.ref(4, r5 + 0x2c).setu(r6);
              r0 = CPU.r10().value;
              r1 = CPU.r10().value;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              r3 = r0;
              r1 = r6;
              r0 = r6;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              r3 = r3 + r0;
              r0 = r3;
              r0 = sqrt(r0);
              r1 = MEMORY.ref(4, r5 + 0x30).get();
              r0 = r0 << 8;
              if(r0 > r1) {
                r2 = 0x300013c;
                r0 = (int)MEMORY.call(r2, r0, r1);
                r4 = r0;
                r1 = r4;
                r0 = CPU.r10().value;
                r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                MEMORY.ref(4, r5 + 0x24).setu(r0);
                r1 = r4;
                r0 = r6;
                r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
                MEMORY.ref(4, r5 + 0x2c).setu(r0);
              }
            }
          } else {
            //LAB_800d472
            r6 = MEMORY.ref(4, r5 + 0x24).get();
            r7 = MEMORY.ref(4, r5 + 0x2c).get();
            r3 = r6;
            r3 = r3 | r7;
            if(r3 != 0) {
              r3 = 0x3000118;
              r0 = r6;
              CPU.r8().value = r3;
              r1 = r6;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              r3 = r0;
              r1 = r7;
              r0 = r7;
              r0 = (int)MEMORY.call(CPU.r8().value, r0, r1);
              MEMORY.ref(4, r5 + 0x2c).setu(r0);
            }
          }

          //LAB_800d4dc
          r3 = MEMORY.ref(4, CPU.sp().value).get();
          r2 = MEMORY.ref(1, r3).getUnsigned();
          r3 = 0x2;
          r3 = r3 & r2;
          if(r3 != 0) {
            r3 = MEMORY.ref(4, r5 + 0x14).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            if(r4 > r3) {
              r2 = MEMORY.ref(4, r5 + 0x28).get();
              r3 = MEMORY.ref(4, r5 + 0x48).get();
              r2 = r2 - r3;
              MEMORY.ref(4, r5 + 0x28).setu(r2);
              r0 = r2;
            } else {
              //LAB_800d4fc
              r0 = MEMORY.ref(4, r5 + 0x28).get();
              if(r0 < 0) {
                MEMORY.ref(4, CPU.sp().value + 0x8).setu(r3);
                r3 = 0x3000118;
                r1 = MEMORY.ref(4, r5 + 0x44).get();
                r0 = (int)MEMORY.call(r3, r0, r1);
                r3 = r0;
                r0 = -r3;
                r1 = r0;
                MEMORY.ref(4, r5 + 0x28).setu(r0);
                if(r1 < 0) {
                  r1 = r3;
                }

                //LAB_800d51a
                r3 = MEMORY.ref(4, r5 + 0x48).get();
                if(r1 <= r3) {
                  r3 = 0x0;
                  MEMORY.ref(4, r5 + 0x28).setu(r3);
                  r0 = 0x0;
                }
              }
            }
          } else {
            //LAB_800d528
            r0 = MEMORY.ref(4, r5 + 0x28).get();
          }
        }

        //LAB_800d52a
        r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r4 = r4 + r0;
        r3 = MEMORY.ref(4, r5 + 0x24).get();
        MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
        CPU.r11().value = CPU.r11().value + r3;
        r0 = MEMORY.ref(4, CPU.sp().value).get();
        r3 = MEMORY.ref(4, r5 + 0x2c).get();
        CPU.r9().value = CPU.r9().value + r3;
        r3 = MEMORY.ref(1, r0 + 0x1).getUnsigned();
        r1 = r5;
        r1 = r1 + 0x56;
        if(r3 == 0x10) {
          //LAB_800d558
          r2 = MEMORY.ref(4, r5 + 0x38).get();
          if(CPU.r11().value == r2) {
            r0 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          } else {
            r3 = MEMORY.ref(4, r5 + 0x8).get();
            r4 = CPU.r11().value;
            r3 = r3 - r2;
            r2 = r4 - r2;
            r3 = r3 ^ r2;
            if(r3 < 0) {
              //LAB_800d5a0
              r0 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            }
          }
        } else if(r3 == 0x11) {
          //LAB_800d564
          r2 = MEMORY.ref(4, r5 + 0x3c).get();
          r3 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
          if(r3 == r2) {
            r0 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          } else {
            r3 = MEMORY.ref(4, r5 + 0xc).get();
            r4 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
            r3 = r3 - r2;
            r2 = r4 - r2;
            r3 = r3 ^ r2;
            if(r3 < 0) {
              //LAB_800d5a0
              r0 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            }
          }
        } else if(r3 == 0x12) {
          //LAB_800d58c
          r2 = MEMORY.ref(4, r5 + 0x40).get();
          if(CPU.r9().value == r2) {
            r0 = 0x1;
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
          } else {
            r3 = MEMORY.ref(4, r5 + 0x10).get();
            r4 = CPU.r9().value;
            r3 = r3 - r2;
            r2 = r4 - r2;
            r3 = r3 ^ r2;
            if(r3 < 0) {
              //LAB_800d5a0
              r0 = 0x1;
              MEMORY.ref(4, CPU.sp().value + 0x4).setu(r0);
            }
          }
        }

        //LAB_800d5a4
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
        if(r2 != 0) {
          r4 = MEMORY.ref(4, CPU.sp().value).get();
          r3 = MEMORY.ref(1, r4 + 0x3).getUnsigned();
          if(r3 != 0) {
            r3 = 0x0;
            MEMORY.ref(4, r5 + 0x24).setu(r3);
            MEMORY.ref(4, r5 + 0x2c).setu(r3);
            r0 = MEMORY.ref(4, r5 + 0x38).get();
            r2 = MEMORY.ref(4, r5 + 0x40).get();
            r3 = MEMORY.ref(1, r4).getUnsigned();
            CPU.r11().value = r0;
            CPU.r9().value = r2;
            if(r3 == 0) {
              r4 = MEMORY.ref(4, r5 + 0x3c).get();
              MEMORY.ref(4, CPU.sp().value + 0x8).setu(r4);
              MEMORY.ref(4, r5 + 0x28).setu(r3);
            }
          }

          //LAB_800d5cc
          r3 = 0x80;
          r3 = r3 << 24;
          MEMORY.ref(4, r5 + 0x38).setu(r3);
          MEMORY.ref(4, r5 + 0x3c).setu(r3);
          MEMORY.ref(4, r5 + 0x40).setu(r3);
          r3 = 0x0;
          MEMORY.ref(1, r1).setu(r3);
        }

        //LAB_800d5da
        r0 = CPU.r11().value;
        MEMORY.ref(4, r5 + 0x8).setu(r0);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
        r3 = CPU.r9().value;
        MEMORY.ref(4, r5 + 0x10).setu(r3);
        MEMORY.ref(4, r5 + 0xc).setu(r2);
        r4 = MEMORY.ref(4, CPU.sp().value).get();
        r2 = MEMORY.ref(1, r4 + 0x5).getUnsigned();
        r3 = 0x1;
        r3 = r3 & r2;
        if(r3 != 0) {
          r0 = MEMORY.ref(4, r5 + 0x24).get();
          r2 = MEMORY.ref(4, r5 + 0x2c).get();
          CPU.r11().value = r0;
          CPU.r9().value = r2;
          if(r0 != 0 || r2 != 0) {
            //LAB_800d602
            r0 = CPU.r9().value;
            r1 = CPU.r11().value;
            r0 = atan2(r0, r1);
            r3 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
            r0 = r0 - r3;
            r0 = r0 << 16;
            r4 = 0x80;
            r0 = r0 >> 16;
            r4 = r4 << 5;
            if(r0 > r4) {
              r0 = 0x80;
              r0 = r0 << 5;
            }

            //LAB_800d61e
            r2 = 0xfffff000;
            if(r0 < r2) {
              r0 = 0xfffff000;
            }

            //LAB_800d626
            r3 = r3 + r0;
            MEMORY.ref(2, r5 + 0x6).setu(r3);
          }
        }
      }

      //LAB_800d62a
      r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
      r4 = MEMORY.ref(4, CPU.sp().value).get();
      r3 = r3 - 0x1;
      r4 = r4 + 0x70;
      MEMORY.ref(4, CPU.sp().value + 0xc).setu(r3);
      MEMORY.ref(4, CPU.sp().value).setu(r4);
      r5 = r5 + 0x70;
    } while(r3 >= 0);

    //LAB_800d63e
    CPU.sp().value += 0x10;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x800d654)
  public static int FUN_800d654(final Actor70 r0) {
    r0._5e.set(MEMORY.ref(4, r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4).get() - 1);
    r0.scriptPos_04.add(2);
    return 0;
  }

  /** Early in first cutscene */
  @Method(0x800d674)
  public static int FUN_800d674(final Actor70 r0) {
    if(r0._60.get() > 0x3b) {
      r0._60.set(0);
      r0.scriptPos_04.incr();
      return 1;
    }

    //LAB_800d688
    if(FUN_800ca98(r0) != 0) {
      //LAB_800d692
      r0.scriptPos_04.incr();
      return 1;
    }

    //LAB_800d69c
    //LAB_800d69e
    return 0;
  }

  @Method(0x800d6a4)
  public static int FUN_800d6a4(final Actor70 r0) {
    final int r6 = r0.scriptPos_04.get();
    final int r2 = r0.scriptPtr_00.get();

    if((int)MEMORY.call(MEMORY.ref(4, r2 + 0x4 + r6 * 0x4).get(), r0) != 0) {
      return 0;
    }

    //LAB_800d6c0
    if(r0.scriptPos_04.get() == r6) {
      r0.scriptPos_04.add(0x2);
    }

    //LAB_800d6ce
    //LAB_800d6d0
    return 1;
  }

  @Method(0x800d6d8)
  public static int FUN_800d6d8(final Actor70 r0, final int r1) {
    r0._5e.set(0);

    if(r1 != 0) {
      //LAB_800d6ec
      final int r2 = r0.scriptPtr_00.get();

      //LAB_800d6f6
      for(int i = 0; i < 0x400; i++) {
        if(MEMORY.ref(4, r2 + i * 0x4).get() == (r1 & 0xbfffffff)) {
          //LAB_800d6e8
          return i + 1;
        }
      }
    }

    //LAB_800d702
    //LAB_800d704
    return 0;
  }

  @Method(0x800d710)
  public static int FUN_800d710(final Actor70 r0) {
    final int r3 = r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4;
    final int r4 = MEMORY.ref(4, r3).get();
    final int r1 = MEMORY.ref(4, r3 + 0x4).get();

    if(r4 == 0xffff) {
      r0.scriptPos_04.set(FUN_800d6d8(r0, r1));
    } else {
      r0._5d.incr();

      if(r0._5d.get() < (short)r4) {
        r0.scriptPos_04.set(FUN_800d6d8(r0, r1));
      } else {
        //LAB_800d74a
        r0._5d.set(0);
        r0.scriptPos_04.add(0x3);
      }
    }

    //LAB_800d754
    return 1;
  }

  @Method(0x800d7e8)
  public static int FUN_800d7e8(final Actor70 r0) {
    r0.scriptPtr_00.set(0x8013240);
    r0.scriptPos_04.set(0);
    return 0;
  }

  /** Early in first cutscene */
  @Method(0x800d8c4)
  public static int FUN_800d8c4(final Actor70 r0) {
    final int r3 = r0.scriptPtr_00.get() + r0.scriptPos_04.get() * 0x4;
    setActorAnimation(r0, MEMORY.ref(4, r3 + 0x4).get());
    r0.scriptPos_04.add(0x2);
    return 1;
  }

  @Method(0x800d8e8)
  public static int FUN_800d8e8(final Actor70 r0) {
    clearActor(r0);
    return 0;
  }

  @Method(0x800d900)
  public static int FUN_800d900(final Actor70 r0) {
    final int r3 = r0.scriptPtr_00.get() + r0.scriptPos_04.get() * 0x4;
    playSound_(MEMORY.ref(4, r3 + 0x4).get());
    r0.scriptPos_04.add(0x2);
    return 1;
  }

  @Method(0x800d924)
  public static int FUN_800d924(final Actor70 r0, final Vec3 r1) {
    final int r5_0 = boardWramMallocHead_3001e50.offset(5 * 0x4).get();

    //LAB_800d93a
    for(int r4 = 0; r4 < 0x40; r4++) {
      final Actor70 r5 = MEMORY.ref(4, r5_0 + r4 * 0x70, Actor70::new);
      if(r5.scriptPtr_00.get() != 0) {
        if((r5._59.get() & 0x1) != 0) {
          if(r5.getAddress() != r0.getAddress()) {
            if(FUN_800eba0(r5.pos_08, r5.radius_20.get() - 0x2, r1, r0.radius_20.get() - 0x2) >= 0) {
              return -1;
            }
          }
        }
      }

      //LAB_800d96e
    }

    //LAB_800d97a
    return 0;
  }

  @Method(0x800d98c)
  public static Actor70 FUN_800d98c(final Actor70 r0, final Vec3 r1) {
    final ArrayRef<Actor70> actors = boardWramMallocHead_3001e50.offset(5 * 0x8).deref(4).cast(ArrayRef.of(Actor70.class, 64, 0x4, Actor70::new));

    //LAB_800d9a2
    for(int r4 = 0; r4 < 0x40; r4++) {
      final Actor70 r5 = actors.get(r4);

      if(r5.scriptPtr_00.get() != 0) {
        if((r5._59.get() & 0x1) != 0x0) {
          if(r5.getAddress() != r0.getAddress()) {
            if(FUN_800eba0(r5.pos_08, r5.radius_20.get() - 2, r1, r0.radius_20.get() - 2) >= 0) {
              return r5;
            }
          }
        }
      }

      //LAB_800d9d4
    }

    return null;
  }

  /** Leaving house in first cutscene */
  @Method(0x800d9f0)
  public static int FUN_800d9f0(final Actor70 r0) {
    final int r3 = r0.scriptPtr_00.get() + r0.scriptPos_04.get() * 0x4 + 0x4;
    setActorPosition(r0, MEMORY.ref(4, r3).get(), MEMORY.ref(4, r3 + 0x4).get(), MEMORY.ref(4, r3 + 0x8).get());
    r0.scriptPos_04.add(0x4);
    return 1;
  }

  /** Early in first cutscene */
  @Method(0x800da18)
  public static int FUN_800da18(final Actor70 r0) {
    final int r3 = r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4;
    FUN_800d14c(r0, MEMORY.ref(4, r3).get(), MEMORY.ref(4, r3 + 0x4).get(), MEMORY.ref(4, r3 + 0x8).get());
    r0.scriptPos_04.add(0x4);
    return 1;
  }

  @Method(0x800da78)
  public static int FUN_800da78(final Actor70 r0) {
    final Actor70 r2 = r0._68.deref();
    r0.angle_06.set(atan2(r2.pos_08.getZ() - r0.pos_08.getZ(), r2.pos_08.getX() - r0.pos_08.getX()));
    r0.scriptPos_04.incr();
    return 1;
  }

  @Method(0x800daf0)
  public static int FUN_800daf0(final Actor70 r0_0) {
    int r1;
    int r3;
    final int r4;
    int r5;
    int r6;
    int r7;
    int r9;
    int r10;
    int r11;

    final Map194 struct = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new);
    r7 = struct._ec.get() + 0x780000;
    final Actor70 r0 = r0_0._68.deref();
    r6 = struct._f0.get() + r0.pos_08.getY() + 0x600000;
    r4 = struct._f4.get() - 0x780000;
    r1 = struct._f8.get() + r0.pos_08.getY() - 0x400000;
    r0_0._55.set(0);
    if(r0 != null) {
      //LAB_800db48
      if(r0.scriptPtr_00.get() != 0) {
        //LAB_800db50
        r11 = r0.pos_08.getX();
        r5 = r0.pos_08.getY();
        int sp04 = r0.pos_08.getZ();
        r0_0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
        if(r11 < r7) {
          r11 = r7;
        }

        //LAB_800db6c
        if(sp04 < r6) {
          sp04 = r6;
        }

        //LAB_800db74
        if(r11 > r4) {
          r11 = r4;
        }

        //LAB_800db7a
        if(sp04  > r1) {
          sp04 = r1;
        }

        //LAB_800db82
        if(r0_0._64.get() != 0) {
          r0_0.pos_08.set(r11, r5, sp04);
        } else {
          //LAB_800db9c
          r10 = (r11 - r0_0.pos_08.getX()) / 0x10000;
          r6 = (sp04 - r0_0.pos_08.getZ()) / 0x10000;
          r7 = sqrt(r10 * r10 + r6 * r6) >> 16;
          r10 = r11 - r0_0.pos_08.getX();
          r9 = r5 - r0_0.pos_08.getY();
          r6 = sp04 - r0_0.pos_08.getZ();
          if(r7 < 0x400000) {
            MEMORY.call(0x3000118, r10, r10);
            MEMORY.call(0x3000118, r6, r6);
            r7 = sqrt16(r10 + r6);
          }

          //LAB_800dc16
          r1 = r7;
          if(r7 < 0) {
            r1 = r7 + 0x7;
          }

          //LAB_800dc1e
          r3 = r0_0.velocityScalar_30.get();
          r5 = r1 >> 3;
          if(r5 > r3) {
            r5 = r3;
          }

          //LAB_800dc2a
          if(r7 < 0x4000) {
            r0_0.pos_08.setX(r11);
            r0_0.pos_08.setZ(sp04);
          } else {
            //LAB_800dc3e
            if(r7 > r5) {
              r1 = r10;
              r10 = (int)MEMORY.call(0x3000118, MEMORY.call(0x300013c, r7, r1), r5);
              r6 = (int)MEMORY.call(0x3000118, MEMORY.call(0x300013c, r7, r6), r5);
            }

            //LAB_800dc6e
            r0_0.pos_08.x_00.add(r10);
            r0_0.pos_08.z_08.add(r6);
          }

          //LAB_800dc7c
          r3 = r9;
          if(r3 < 0) {
            r3 = -r3;
          }

          //LAB_800dc84
          if(r3 > 0x8000) {
            r9 /= 4;
          }

          //LAB_800dc98
          r0_0.pos_08.y_04.add(r9);
        }
      }
    }

    //LAB_800dca0
    r0_0.scriptPos_04.incr();

    return 1;
  }

  @Method(0x800dcdc)
  public static int FUN_800dcdc(final Actor70 r0) {
    final Actor70 r2 = r0._68.deref();
    r0.velocityScalar_30.set(r2.velocityScalar_30.get());
    r0.acceleration_34.set(r2.acceleration_34.get());
    final int dx = r2.pos_08.getX() - r0.pos_08.getX();
    final int dz = r2.pos_08.getZ() - r0.pos_08.getZ();
    final int r3_0 = dx >> 16;
    final int r2_0 = dz >> 16;
    final int r7 = sqrt(r3_0 * r3_0 + r2_0 * r2_0);
    if(r7 > 0x10) {
      final int r5 = r7 - 0x10;
      final int r1 = r0.pos_08.getX() + divideS(dx * r5, r7);
      final int r3 = r0.pos_08.getZ() + divideS(dz * r5, r7);
      FUN_800d14c(r0, r1, r0.pos_08.getY(), r3);
      setActorAnimation(r0, 0x2);
      r0.scriptPos_04.incr();
      return 1;
    }

    //LAB_800dd56
    setActorAnimation(r0, 0x1);
    return 0;
  }

  @Method(0x800df04)
  public static int FUN_800df04(final Actor70 r0) {
    int r2;
    int r3;
    int r4;
    int r7;
    int r8;
    int r9;
    int r10;
    int r11;

    r3 = r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4;
    final int sp18 = MEMORY.ref(4, r3).get();
    final int sp14 = MEMORY.ref(4, r3 + 0x4).get();
    r3 = MEMORY.ref(4, r3 + 0x8).get() / 0x10000;
    int sp0c = r0.angle_06.get();
    r11 = r0.pos_08.getX() / 0x10000 - r0._64.get();
    r9 = r0.pos_08.getZ() / 0x10000 - r0._66.get();
    r10 = 0;

    final Vec3 sp1c = new Vec3();
    final Vec3 sp28 = new Vec3();

    jmp_800e146:
    if(r11 * r11 + r9 * r9 <= r3 * r3) {
      //LAB_800df92
      do {
        do {
          do {
            do {
              do {
                do {
                  do {
                    do {
                      r10++;
                      if(r10 > 0x7) {
                        break jmp_800e146;
                      }

                      //LAB_800df9e
                      r8 = sp18 + mul16(rand(), sp14);
                      r2 = sp0c << 16 >>> 16;
                      r2 = r2 + (rand() >>> 2);
                      r2 = r2 - (rand() >>> 2);
                      r2 = r2 << 16;
                      r4 = r2 >>> 16;
                      sp28.set(r0.pos_08);
                      rotVec3(0x80000, r4, sp28);
                    } while(FUN_800d924(r0, sp28) != 0x0);

                    sp28.set(r0.pos_08);
                    rotVec3(r8, r4, sp28);
                  } while(FUN_80120dc(r0, sp28) != 0x0);

                  sp1c.set(r0.pos_08);
                  r8 += 0x80000;
                  rotVec3(r8, r4, sp1c);
                } while(FUN_80120dc(r0, sp1c) != 0x0);

                sp1c.set(r0.pos_08);
                rotVec3(r8, r4 + 0x2000, sp1c);
              } while(FUN_80120dc(r0, sp1c) != 0x0);

              sp1c.set(r0.pos_08);
              rotVec3(r8, r4 - 0x2000, sp1c);
            } while(FUN_80120dc(r0, sp1c) != 0x0);

            //LAB_800e098
            sp1c.set(r0.pos_08);
            rotVec3(r8, r4 + 0x4000, sp1c);
          } while(FUN_80120dc(r0, sp1c) != 0x0);

          //LAB_800e0c2
          sp1c.set(r0.pos_08);
          rotVec3(r8, r4 - 0x4000, sp1c);
        } while(FUN_80120dc(r0, sp1c) != 0x0);

        //LAB_800e0e8
        r11 = sp28.getX() / 0x10000 - r0._64.get();
        r9 = sp28.getZ() / 0x10000 - r0._66.get();
      } while(r11 * r11 + r9 * r9 > r3 * r3);

      //LAB_800e12e
      r0._59.or(0x2);
      FUN_800d14c(r0, sp28.getX(), sp28.getY(), sp28.getZ());
      r0.scriptPos_04.add(0x4);
      return 1;
    }

    //LAB_800e146
    r10 = 0;
    sp0c = (short)(atan2(r9, r11) + 0x8000);

    //LAB_800e15e
    do {
      do {
        r10++;
        if(r10 > 0x7) {
          r0.scriptPos_04.add(0x4);
          return 1;
        }

        r8 = sp18 + mul16(rand(), sp14);
        r2 = sp0c << 16 >>> 16;
        r2 = r2 + (rand() >>> 2);
        r2 = r2 - (rand() >>> 2);
        r2 = r2 << 16;
        r7 = r2 >>> 16;
        sp28.set(r0.pos_08);
        rotVec3(0x80000, r7, sp28);
      } while(FUN_800d924(r0, sp28) != 0x0);

      sp28.set(r0.pos_08);
      rotVec3(r8, r7, sp28);
    } while(FUN_80120dc(r0, sp28) != 0x0);

    r0._59.and(~0x2);
    FUN_800d14c(r0, sp28.getX(), sp28.getY(), sp28.getZ());

    //LAB_800e1f6
    r0.scriptPos_04.add(0x4);
    return 1;
  }

  @Method(0x800e280)
  public static void FUN_800e280(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.angle_06.set(r2);
      //LAB_800e28c
    } else if(r1 == 1) {
      r0.angle_06.add(r2);
      //LAB_800e298
    } else if(r0.angle_06.get() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }
  }

  @Method(0x800e2dc)
  public static void FUN_800e2dc(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.pos_08.setY(r2);
      //LAB_800e2e6
    } else if(r1 == 1) {
      r0.pos_08.y_04.add(r2);
      //LAB_800e2f2
    } else if(r0.pos_08.getY() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }

    //LAB_800e302
  }

  @Method(0x800e364)
  public static void FUN_800e364(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.scale_18.set(r2);
      //LAB_800e36e
    } else if(r1 == 1) {
      r0.scale_18.add(r2);
      //LAB_800e37a
    } else if(r0.scale_18.get() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }

    //LAB_800e38a
  }

  @Method(0x800e390)
  public static void FUN_800e390(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0._1c.set(r2);
      //LAB_800e39a
    } else if(r1 == 1) {
      r0._1c.add(r2);
      //LAB_800e3a6
    } else if(r0._1c.get() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }

    //LAB_800e3b6
  }

  @Method(0x800e3e8)
  public static void FUN_800e3e8(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.velocity_24.setY(r2);
      //LAB_800e3f2
    } else if(r1 == 1) {
      r0.velocity_24.y_04.add(r2);
    } else {
      //LAB_800e3fe
      //LAB_800e408
      r0._57.set(r0.velocity_24.getY() == r2 ? 1 : 0);
    }
  }

  @Method(0x800e440)
  public static void FUN_800e440(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.velocityScalar_30.set(r2);
      //LAB_800e44a
    } else if(r1 == 1) {
      r0.velocityScalar_30.add(r2);
      //LAB_800e456
    } else if(r0.velocityScalar_30.get() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }
  }

  @Method(0x800e46c)
  public static void FUN_800e46c(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.acceleration_34.set(r2);
      //LAB_800e476
    } else if(r1 == 1) {
      r0.acceleration_34.add(r2);
    } else {
      //LAB_800e482
      //LAB_800e48c
      r0._57.set(r0.acceleration_34.get() == r2 ? 1 : 0);
    }
  }

  @Method(0x800e4c4)
  public static void FUN_800e4c4(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0.dest_38.setY(r2);
      //LAB_800e4ce
    } else if(r1 == 1) {
      r0.dest_38.y_04.add(r2);
      //LAB_800e4da
    } else if(r0.dest_38.getY() == r2) {
      r0._57.set(1);
    } else {
      r0._57.set(0);
    }

    //LAB_800e4ea
  }

  @Method(0x800e634)
  public static void FUN_800e634(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0._55.set(r2);
      //LAB_800e644
    } else if(r1 == 1) {
      r0._55.add(r2);
    } else {
      //LAB_800e654
      r0._57.set(r0._55.get() == (r2 & 0xff) ? 1 : 0);
    }
  }

  @Method(0x800e720)
  public static void FUN_800e720(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0._59.set(r2);
      //LAB_800e730
    } else if(r1 == 1) {
      r0._59.add(r2);
    } else {
      //LAB_800e740
      //LAB_800e752
      r0._57.set(r0._59.get() == (r2 & 0xff) ? 1 : 0);
    }
  }

  @Method(0x800e850)
  public static void FUN_800e850(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0._64.set(r2);
      //LAB_800e860
    } else if(r1 == 1) {
      r0._64.add(r2);
    } else {
      //LAB_800e870
      //LAB_800e884
      r0._57.set(r0._64.get() == (short)r2 ? 1 : 0);
    }
  }

  @Method(0x800e890)
  public static void FUN_800e890(final Actor70 r0, final int r1, final int r2) {
    if(r1 == 0) {
      r0._66.set(r2);
      //LAB_800e8a0
    }  else if(r1 == 1) {
      r0._66.add(r2);
    } else {
      //LAB_800e8b0
      //LAB_800e8c4
      r0._57.set(r0._66.get() == (short)r2 ? 1 : 0);
    }
  }

  @Method(0x800e9a0)
  public static int FUN_800e9a0(final Actor70 r0) {
    final int r1 = r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4;
    final var r3 = _80136e0.get(MEMORY.ref(4, r1).get()).derefNullable();
    if(r3 != null) {
      r3.run(r0, 0, MEMORY.ref(4, r1 + 0x4).get());
    }

    //LAB_800e9ca
    r0.scriptPos_04.add(0x3);
    return 1;
  }

  @Method(0x800e9dc)
  public static int FUN_800e9dc(final Actor70 r0) {
    final int r1 = r0.scriptPtr_00.get() + 0x4 + r0.scriptPos_04.get() * 0x4;
    final var r3 = _80136e0.get(MEMORY.ref(4, r1).get()).derefNullable();
    if(r3 != null) {
      r3.run(r0, 0x1, MEMORY.ref(4, r1 + 0x4).get());
    }

    //LAB_800ea06
    r0.scriptPos_04.add(0x3);
    return 1;
  }

  @Method(0x800eaf8)
  public static int checkActionButtonInput() {
    final Structccc r1 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(r1 == null) {
      return 0;
    }

    final int actionUsed;
    if((pressedButtons_3001c94.get() & menuButton_2000454.get()) != 0) {
      r1.menuPressed_172.set(1);
      actionUsed = 1;
      //LAB_800eb1e
    } else if((pressedButtons_3001c94.get() & interactButton_2000450.get()) != 0) {
      r1.interactPressed_174.set(1);
      actionUsed = 1;
      //LAB_800eb32
    } else if((pressedButtons_3001c94.get() & systemMenuButton_2000456.get()) != 0) {
      r1.systemMenuPressed_176.set(1);
      actionUsed = 1;
      //LAB_800eb4e
    } else if((pressedButtons_3001c94.get() & psynergy1Button_2000458.get()) != 0) {
      actionUsed = useFieldPsynergy(boundPsynergy1_2000460.get());
      //LAB_800eb64
    } else if((pressedButtons_3001c94.get() & psynergy2Button_200045a.get()) != 0) {
      actionUsed = useFieldPsynergy(boundPsynergy2_2000462.get());
    } else {
      actionUsed = 0;
    }

    //LAB_800eb7e
    //LAB_800eb80
    return actionUsed;
  }

  @Method(0x800ea60)
  public static int useFieldPsynergy(final int r0) {
    final int r6 = r0 >>> 14;
    final int r7 = r0 & 0x3fff;
    final Structccc r5 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(readFlag_(0x107) != 0) {
      r5._182.set(0xfa);
      //LAB_800ea82
    } else if(r5._19e.get() == 3) {
      if((pressedButtons_3001c94.get() & BUTTON_R) != 0) {
        r5._182.set(0xfc88);
        //LAB_800eaaa
      } else if((pressedButtons_3001c94.get() & BUTTON_L) != 0) {
        r5._182.set(0xfc87);
      }
      //LAB_800eac2
    } else if(r6 == 0) {
      //LAB_800eacc
      r5._17e.set(r7);
    } else if(r6 == 1) {
      //LAB_800ead0
      r5._180.set(r7);
    }

    //LAB_800ead8
    return r7;
  }

  @Method(0x800eba0)
  public static int FUN_800eba0(final Vec3 r0, final int r1, final Vec3 r2, final int r3) {
    final int dx = r0.getX() - r2.getX() >> 16;
    final int dy = r0.getY() - r2.getY() >> 16;
    final int dz = r0.getZ() - r2.getZ() >> 16;

    final int r1_0 = r1 + r3;

    if(dx <= 0x40_0000) {
      if(dz <= 0x40_0000) {
        if(dx * dx + dy * dy + dz * dz < r1_0 * r1_0) {
          return 0;
        }
      }
    }

    //LAB_800ebe2
    //LAB_800ebe6
    return -1;
  }

  @Method(0x800ebec)
  public static int handleMovement(final Actor70 r0) {
    int r2;
    final int r5;
    int r6;
    final Vec3 sp44 = new Vec3();
    final Vec3 sp50 = new Vec3();
    final Vec3 sp5c = new Vec3();

    int sp14 = 0;
    int sp10 = 0;

    if(debug_3001f54.get() != 0 && readFlag_(0x15e) != 0) {
      int count = 0;

      //LAB_800ec20
      for(r2 = 0; r2 < 0x200; r2++) {
        if(_3001810.get(r2).get() == 0xff) {
          count++;
        }

        //LAB_800ec2a
      }

      if(count - 0x88 < 0) {
        playSound_(0x87);
      }

      //LAB_800ec3e
    }

    //LAB_800ec78
    int sp08;
    if((heldButtonsLastFrame_3001ae8.get() & runButton_200045c.get()) != 0) {
      r0.velocityScalar_30.set(0x18000);
      r0.acceleration_34.set(0x4000);
      sp08 = 0x5;
    } else {
      //LAB_800ec9c
      r0.velocityScalar_30.set(0x10000);
      r0.acceleration_34.set(0x4000);
      sp08 = 0x2;
    }

    //LAB_800ecac
    if(readFlag_(0x17f) != 0 && (heldButtonsLastFrame_3001ae8.get() & BUTTON_B) != 0) {
      r0.velocityScalar_30.set(0x40000);
      r0.acceleration_34.set(0x10000);
      sp08 = 0x5;
    }

    //LAB_800ecd6
    final int sp04 = MEMORY.ref(2, 0x8013254 + (heldButtonsLastFrame_3001ae8.get() >>> 4 & 0xf) * 0x2).get() & 0xffff;

    int sp0c = sp04; // uninitialized, pretty sure this is the right value to initialize it with

    jmp_800f0c6:
    if(sp04 == 0xffff) {
      sp14 |= 0x4;
    } else {
      //LAB_800ecfa
      sp5c.set(r0.pos_08);
      rotVec3(0x80000, sp04, sp5c);

      if(debug_3001f54.get() != 0 && (heldButtonsLastFrame_3001ae8.get() & BUTTON_L) != 0) {
        break jmp_800f0c6;
      }

      jmp_800ef44:
      {
        //LAB_800ed38
        if(FUN_80120dc(r0, sp5c) == 0) {
          sp50.set(r0.pos_08);
          rotVec3(0x80000, sp04 + 0x1000, sp50);

          if(FUN_80120dc(r0, sp50) == 0) {
            sp50.set(r0.pos_08);
            rotVec3(0x80000, sp04 - 0x1000, sp50);

            if(FUN_80120dc(r0, sp50) == 0) {
              sp50.set(r0.pos_08);
              rotVec3(0x80000, sp04 + 0x2000, sp50);

              if(FUN_80120dc(r0, sp50) == 0) {
                sp50.set(r0.pos_08);
                rotVec3(0x80000, sp04 - 0x2000, sp50);

                if(FUN_80120dc(r0, sp50) == 0) {
                  sp0c = sp04;
                  break jmp_800ef44;
                }
              }
            }
          }
        }

        //LAB_800ee14
        final int[] r10 = new int[6];
        r10[0] = sp04 + 0x1000;
        r10[1] = sp04 - 0x1000;
        r10[2] = sp04 + 0x2000;
        r10[3] = sp04 - 0x2000;
        r10[4] = sp04 + 0x3000;
        r10[5] = sp04 - 0x3000;

        //LAB_800ee50
        for(int r9 = 0; r9 < 6; r9++) {
          sp0c = r10[r9];
          sp5c.set(r0.pos_08);
          r6 = sp0c & 0xffff;
          rotVec3(0x80000, r6, sp5c);

          if(FUN_80120dc(r0, sp5c) == 0) {
            sp50.set(r0.pos_08);
            rotVec3(0x80000, r6 + 0x1000, sp50);

            if(FUN_80120dc(r0, sp50) == 0) {
              sp50.set(r0.pos_08);
              rotVec3(0x80000, r6 - 0x1000, sp50);

              if(FUN_80120dc(r0, sp50) == 0) {
                sp50.set(r0.pos_08);
                rotVec3(0x80000, r6 + 0x2000, sp50);

                if(FUN_80120dc(r0, sp50) == 0) {
                  sp50.set(r0.pos_08);
                  rotVec3(0x80000, r6 - 0x2000, sp50);

                  if(FUN_80120dc(r0, sp50) == 0) {
                    break jmp_800ef44;
                  }
                }
              }
            }
          }

          //LAB_800ef24
        }

        sp5c.set(r0.pos_08);
        sp14 |= 0x1;
      }

      //LAB_800ef44
      sp44.set(r0.pos_08);
      rotVec3(0x40000, sp0c & 0xffff, sp44);

      final ArrayRef<Actor70> actors = boardWramMallocHead_3001e50.offset(5 * 0x4).deref(4).cast(ArrayRef.of(Actor70.class, 0x40, 0x70, Actor70::new));

      //LAB_800ef72
      for(int actorIndex = 0; actorIndex < 0x40; actorIndex++) {
        final Actor70 otherActor = actors.get(actorIndex);
        if(otherActor.scriptPtr_00.get() != 0) {
          //LAB_800ef80
          if((otherActor._59.get() & 0x1) != 0) {
            //LAB_800ef90
            if(otherActor.getAddress() != r0.getAddress()) {
              //LAB_800ef96
              if(FUN_800eba0(otherActor.pos_08, r0.radius_20.get() - 2, sp44, otherActor.radius_20.get() - 2) >= 0) {
                if((otherActor._58.get() & 0xff000200) != 0x200) {
                  sp14 |= 0x2;
                } else {
                  final int angle = atan2(otherActor.pos_08.getZ() - r0.pos_08.getZ(), otherActor.pos_08.getX() - r0.pos_08.getX());
                  sp50.set(otherActor.pos_08);
                  final int angle2 = angle & 0xffff;
                  sp0c = (short)angle;
                  rotVec3(0x4000, angle2, sp50);

                  if(FUN_800d924(otherActor, sp50) != 0) {
                    sp14 |= 0x2;
                  } else {
                    sp50.set(otherActor.pos_08);
                    rotVec3(0xa0000, angle2, sp50);

                    if(FUN_80120dc(otherActor, sp50) != 0) {
                      sp14 |= 0x2;
                    } else {
                      sp50.set(otherActor.pos_08);
                      rotVec3(0xa0000, angle2 + 0x1000, sp50);

                      if(FUN_80120dc(otherActor, sp50) != 0) {
                        sp14 |= 0x2;
                      } else {
                        sp50.set(otherActor.pos_08);
                        rotVec3(0xa0000, angle2 - 0x1000, sp50);

                        if(FUN_80120dc(otherActor, sp50) != 0) {
                          //LAB_800f092
                          sp14 |= 0x2;
                        } else {
                          rotVec3(0x4000, angle2, otherActor.dest_38);
                          otherActor.dest_38.setX(0x80000000);
                          otherActor.dest_38.setY(0x80000000);
                          otherActor.dest_38.setZ(0x80000000);
                          sp10 |= 0x1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }

        //LAB_800f09a
      }

      //LAB_800f0ae
      if(sp14 == 0 && sp10 != 0) {
        r0.velocityScalar_30.set(0x4000);
        r0.acceleration_34.set(0x2000);
      }
    }

    //LAB_800f0c6
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(r3 != null) {
      if((sp14 & 0x3) != 0) {
        r3._19c.incr();
      } else {
        //LAB_800f0e6
        r3._19c.set(0);
      }
    }

    //LAB_800f0ee
    if(sp10 != 0) {
      setActorAnimation(r0, 8);
      //LAB_800f0fe
    } else if(sp14 != 0) {
      if(getUnit_(playerMapActorIndex_2000434.get()).hp_38.get() == 0) {
        r5 = 22; // Zero HP standing animation
      } else {
        r5 = 9; // Normal standing animation
      }

      //LAB_800f11e
      setActorAnimation(r0, r5);
    } else {
      //LAB_800f128
      setActorAnimation(r0, sp08);
    }

    //LAB_800f130
    if(sp14 != 0) {
      r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
      r0.velocity_24.setX(0);
      r0.velocity_24.setZ(0);

      if((sp14 & 0x3) != 0) {
        int angle = (short)sp04 - r0.angle_06.get();

        if(angle > 0x1000) {
          angle = 0x1000;
        }

        //LAB_800f164
        if(angle < -0x1000) {
          angle = -0x1000;
        }

        //LAB_800f16c
        r0.angle_06.add(angle);
      }

      //LAB_800f170
      r0._64.set(0);
      r0._66.set(0x2);
    } else {
      //LAB_800f1a4
      FUN_800d14c(r0, sp5c.getX(), sp5c.getY(), sp5c.getZ());
      final int sqrt = sqrt16(mul16(r0.velocity_24.getX(), r0.velocity_24.getX()) + mul16(r0.velocity_24.getZ(), r0.velocity_24.getZ()));
      r0.velocity_24.setX(sp14);
      r0.velocity_24.setZ(sp14);
      rotVec3(sqrt, sp0c & 0xffff, r0.velocity_24);
      if(r0._64.get() != 0) {
        r0._64.decr();
      }
    }

    //LAB_800f1fa
    if(boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._17.get() != 0) {
      if(r0._64.get() == 0) {
        if(sp14 == 0) {
          final Actor70 actor = loadActor(0x19, r0.pos_08.getX(), r0.pos_08.getY(), r0.pos_08.getZ());
          if(actor != null) {
            actor._14.set(r0._14.get());
            final Sprite38 sprite = actor.sprite_50.derefNullable();
            setActorSpriteScript(actor, 0x8013274);
            actor.flags_23.set(0x2);
            actor._55.set(0);
            if(sprite != null) {
              setSpriteAnimation(sprite, 0x1);
              sprite._26.set(0);
              sprite.rotation_1e.set(sp04 + 0x4000);
              sprite.packet_00.attribs_04.attrib2_04.or(0xc00);
            }

            //LAB_800f270
            if(r0._66.get() == 2) {
              setSpriteAnimation(sprite, 0x2);
              r0._66.set(sp14);
              r2 = 0;
            } else {
              r2 = r0._66.get();
            }

            //LAB_800f294
            if(r2 != 0) {
              actor.angle_06.set(0x8000);
            }

            //LAB_800f2a0
            if(sp08 == 5) {
              r0._64.set(0xc);
            } else {
              //LAB_800f2c0
              r0._64.set(0x12);
            }

            //LAB_800f2c6
            r0._66.xor(0x1);
          }
        }
      }
    }

    //LAB_800f2d8
    checkActionButtonInput();
    r0.scriptPos_04.incr();

    return 1;
  }

  /** Hopping off ladder after climbing */
  @Method(0x800f7f4)
  public static int FUN_800f7f4(final Actor70 r0) {
    r0.velocityScalar_30.set(0x8000);
    r0.acceleration_34.set(0x4000);
    int r1 = MEMORY.ref(2, 0x8013254 + (heldButtonsLastFrame_3001ae8.get() >>> 4 & 0xf) * 0x2).getUnsigned();
    final Vec3 r5 = new Vec3();
    int r9 = 0xc;
    int r10 = 0x4;
    if(r1 != 0xffff) {
      //LAB_800f832
      if((r1 & 0xf000) == 0) {
        r9 = 0xe;
      } else if((r1 & 0xf000) == 0x8000) {
        r9 = 0xf;
      } else {
        r9 = 0xa;
      }

      //LAB_800f84c
      r10 = 0;
      r5.zero();
      rotVec3(0x80000, r1, r5);

      r5.x_00.add(r0.pos_08.getX());

      if(r5.getZ() < 0x0) {
        r0.angle_06.set(0xc000);
      }

      //LAB_800f878
      if(r5.getZ() > 0x0) {
        r0.angle_06.set(0x4000);
      }

      //LAB_800f882
      r5.setY(r0.pos_08.getY() - r5.getZ());
      r5.setZ(r0.pos_08.getZ());
      r1 = r0.pos_08.getZ() / 0x100000 * 0x80;
      final TileAttributes04 r8 = tileAttribs_2010000.get(r0.pos_08.getX() / 0x100000 + r1);
      final TileAttributes04 r7 = tileAttribs_2010000.get(r5.getX() / 0x100000 + r1);

      if(FUN_801219c(r5) != 0x0) {
        r10 = 0x4;
        r9 = 0xc;
      } else if(r8.getType() != r7.getType()) {
        //LAB_800f8da
        r10 = 0x4;
        r9 = 0xc;
        //LAB_800f8e4
      } else if((heldButtonsLastFrame_3001ae8.get() & 0x40) != 0x0) {
        if(getHeight(r0.layer_22.get(), r5.getX(), r5.getZ() - 0x100000) - r0.pos_08.getY() < 0x100000) {
          r10 = 0x1;
          r9 = 0xc;
        }
        //LAB_800f910
      } else if((heldButtonsLastFrame_3001ae8.get() & 0x80) != 0x0) {
        if(getHeight(r0.layer_22.get(), r5.getX(), r5.getZ()) - r0.pos_08.getY() > -0x80000) {
          //LAB_800f932
          r10 = 0x1;
          r9 = 0xc;
        }
      }
    }

    //LAB_800f93a
    final Structccc r3 = boardWramMallocHead_3001e50.offset(27 * 0x4).deref(4).cast(Structccc::new);
    if(r3 != null) {
      if((r10 & 0x3) != 0x0) {
        r3._19c.incr();
      } else {
        //LAB_800f95a
        r3._19c.set(0);
      }
    }

    //LAB_800f962
    setActorAnimation(r0, r9);
    if(r10 != 0x0) {
      r0.dest_38.set(0x80000000, 0x80000000, 0x80000000);
      r0.velocity_24.zero();
    } else {
      //LAB_800f984
      FUN_800d14c(r0, r5.getX(), r5.getY(), r5.getZ());
    }

    //LAB_800f992
    r0.scriptPos_04.incr();
    return 1;
  }


  @Method(0x800f9cc)
  public static void FUN_800f9cc(final int r0, final int r1) {
    //LAB_800f9dc
    for(int i = 0; i < r1; i++) {
      MEMORY.ref(1, r0 + i).setu(MEMORY.ref(1, 0x80097b8 + MEMORY.ref(1, r0 + i).getUnsigned()).getUnsigned());
    }

    //LAB_800f9ea
  }

  @Method(0x800f9f4)
  public static void FUN_800f9f4(final int size) {
    final int count = (size - 1) / 2;
    if((size & 0x1) != 0) {
      final int r3 = MEMORY.ref(1, 0x2010001).getUnsigned();
      if(r3 == 0) {
        //LAB_800fa22
        //LAB_800fa28
        for(int i = 0; i < count; i++) {
          MEMORY.ref(2, 0x2020000 + i * 0x2).setu(MEMORY.ref(2, 0x2010002 + i * 0x2).getUnsigned());
        }
      } else if(r3 == 1) {
        //LAB_800fa38
        int r7 = 0;
        //LAB_800fa44
        for(int i = 0; i < count; i++) {
          r7 = (MEMORY.ref(1, 0x2010002 + i).getUnsigned() << 8 | MEMORY.ref(1, 0x2010002 + count + i).getUnsigned()) ^ r7;
          MEMORY.ref(2, 0x2020000 + i * 0x2).setu(r7);
        }
        //LAB_800fa1c
      } else if(r3 == 2) {
        //LAB_800fa60
        int r2 = 0;

        //LAB_800fa68
        for(int i = 0; i < count; i++) {
          r2 = MEMORY.ref(2, 0x2010002 + i * 0x2).getUnsigned() ^ r2;
          MEMORY.ref(2, 0x2020000 + i * 0x2).setu(r2);
        }
      }
    }

    //LAB_800fa7a
  }

  @Method(0x800fac8)
  public static void FUN_800fac8() {
    final int r8 = mallocBoard(0x8000);
    MEMORY.call(0x3001388, r8, tileAttribs_2010000.getAddress(), 0x8000); // memcpy

    final int size = 0x9c;
    final int addr = mallocChip(size);
    DMA.channels[3].SAD.setu(0x800a37c);
    DMA.channels[3].DAD.setu(addr);
    DMA.channels[3].CNT.setu(0x84000000 | size / 4);

    switch(addr) {
      case 0x3002000 -> MEMORY.addFunctions(CopiedSegment800a37c.class);
      default -> throw new RuntimeException("Need to implement overlay " + Integer.toHexString(addr));
    }

    MEMORY.call(addr, 0x2018000, tileAttribs_2010000.getAddress(), r8);
    setMallocAddress(addr);
    setMallocAddress(r8);
  }

  @Method(0x800fb38) // Loads a map
  public static int loadMap(final int index) {
    GPU.DISPCNT.and(0xc1ff);

    fadeInBrightness(0);

    final Struct0c sp0x08 = _8013784.get(index);

    final Map194 map = MEMORY.ref(4, mallocSlotBoard(8, 0x194), Map194::new);
    MEMORY.call(0x3000164, map.getAddress(), 0x194); // memzero

    final PointerTableType296 r5 = MEMORY.ref(4, getPointerTableEntry(296 + sp0x08._00.get()), PointerTableType296::new);
    FUN_800f9f4(decompress(r5._24.deref().getAddress(), 0x2010001)); // without this, the background doesn't load
    decompress(r5._28.deref().getAddress(), 0x202c000); // without this, the background doesn't load
    decompress(r5._2c.deref().getAddress(), tileAttribs_2010000.getAddress()); // without this, the background doesn't load
    FUN_800fac8();

    if(!r5._30.isNull()) {
      decompress(r5._30.deref().getAddress(), 0x202d000);
      FUN_80118d8(0x202d000);
    }

    //LAB_800fbc8
    if(!r5._34.isNull()) { // Without this, it looks like the alpha channel doesn't work. Light ways from the windows are opaque, etc.
      decompress(r5._34.deref().getAddress(), 0x202de00);
      FUN_8011a84(0x202de00);
    }

    //LAB_800fbde
    map._10.set(r5._38.deref().getAddress());
    map._e4.set(0);
    map._e8.set(0);
    map._ec.set(r5._00.get() << 19);
    map._f0.set(r5._01.get() << 19);
    map._f4.set(r5._02.get() << 19);
    map._f8.set(r5._03.get() << 19);
    map._100.get(0).set(r5._04.get());
    map._100.get(1).set(r5._05.get());
    map._100.get(2).set(r5._06.get());

    //LAB_800fc48
    for(int i = 0; i < 3; i++) {
      final PointerTableType296.Sub08 r6 = r5._0c.get(i);
      final Map194.Sub30 r7 = map.layers_104.get(i);
      final int lr = r6._00.get() << 19;
      final int r10 = r6._01.get() << 19;
      r7._08.set(lr);
      r7._0c.set(r10);
      r7._18.set(r6._04.get() << 12);
      r7._1c.set(r6._05.get() << 12);
      r7._20.set(0);
      r7._24.set(0);
      r7._28.set(r6._06.get());
      r7._2a.set(r6._07.get());
      final int r0 = r6._00.get() >>> 1;
      final int r2 = r6._01.get() >>> 1 << 7;
      final int r1 = r6._02.get() << 12;
      final int r4 = r6._03.get() << 12;
      r7._10.set(r1);
      r7._14.set(r4);
      r7.tiles_2c.set(tileAttribs_2010000.slice(r2 + r0));

      r7._00.set((int)MEMORY.call(0x3000118, map._e4.get(), r1) + lr);
      r7._04.set((int)MEMORY.call(0x3000118, map._e8.get(), r4) + r10);
    }

    map._14.set(0x1000);

    if(map._100.get(0).get() != 0) {
      map._14.set(0x1800);
    }

    //LAB_800fcde
    if(map._100.get(1).get() != 0) {
      map._14.or(0x400);
    }

    //LAB_800fcf4
    if(map._100.get(2).get() != 0) {
      map._14.or(0x200);
    }

    //LAB_800fd0e
    GPU.BG3CNT.setu(0x500 | map._100.get(0).get() | r5._07.get() << 2);
    GPU.BG2CNT.setu(0x600 | map._100.get(1).get() | r5._08.get() << 2);
    GPU.BG1CNT.setu(0x700 | map._100.get(2).get() | r5._09.get() << 2);

    if(readFlag_(0x170) != 0) {
      clearFlag_(0x170);
    } else {
      //LAB_800fd98
      final int r7 = mallocChip(0x4000);
      if(r7 != 0) {
        final int backgroundColour = MEMORY.ref(2, 0x5000000).get();

        decompress(getPointerTableEntry(296 + sp0x08.compressedPalette_02.get()), r7); // Confirmed to be palette
        MEMORY.ref(2, r7).setu(backgroundColour);
        MEMORY.call(0x3001388, 0x5000000, r7, 0x1c0); // memcpy

        decompressImage(getPointerTableEntry(296 + sp0x08._04.get()), r7); // Tiles1 in no$, main background
        MEMORY.call(0x3001388,  0x6004000, r7, 0x4000); // memcpy

        decompressImage(getPointerTableEntry(296 + sp0x08._06.get()), r7); // Overlays like rugs, windows, etc.
        MEMORY.call(0x3001388, 0x6008000, r7, 0x4000); // memcpy

        decompressImage(getPointerTableEntry(296 + sp0x08._08.get()), r7); // Bottom half of tiles2 in no$, also background, but with this it still renders, just glitched
        MEMORY.call(0x3001388, 0x600c000, r7, 0x4000); // memcpy

        decompressImage(getPointerTableEntry(296 + sp0x08._0a.get()), 0x2028000);
        setMallocAddress(r7);
      }
    }

    //LAB_800fe42
    GPU.MOSAIC.setu(0);
    GPU.BLDCNT.setu(0);
    GPU.DISPCNT.setu(0x140);

    // Causes the first map to shake
    setTickCallback(getRunnable(GoldenSun_801.class, "FUN_8010000"), 0xc85);

    return 2;
  }

  @Method(0x800fe9c)
  public static void FUN_800fe9c() {
    final int x;
    final int y;
    final int z;

    final Vec3 r3 = boardWramMallocHead_3001e50.offset(8 * 0x4).deref(4).cast(Map194::new)._00.derefNullable();
    if(r3 != null) {
      x = r3.getX();
      y = r3.getY();
      z = r3.getZ();
    } else {
      x = 0;
      y = 0;
      z = 0;
    }

    //LAB_800feb4
    FUN_8010230(x, z - y);
    FUN_8010000();
  }

  @Method(0x800fec8)
  public static void FUN_800fec8(final int r0_0, final int r1_0, final int r2_0) {
    final int r12 = 0x6002800 + r0_0 * 0x800;
    final int r7 = (r2_0 / 2 & 0x7f) * 0x80;
    final int r10 = (r2_0 & 0x1e) * 0x20;
    int r0 = r1_0 & 0x1e;
    int r5 = r1_0 / 2 & 0x7f;

    //LAB_800ff00
    for(int r4 = 0; r4 < 0x10; r4++) {
      final int tile = tileAttribs_2010000.get(r7 + r5).getTile();
      final int r3 = MEMORY.ref(4, 0x2020000 + tile * 0x8).get();
      final int r2 = r12 + (r10 + r0) * 0x2;
      MEMORY.ref(4, r2).setu(r3);
      MEMORY.ref(4, r2 + 0x40).setu(MEMORY.ref(4, 0x2020004 + tile * 0x8).get());
      r0 = r0 + 2 & 0x1e;
      r5 = r5 + 1 & 0x7f;
    }
  }

  @Method(0x800ff54)
  public static void FUN_800ff54(final int r0, final int r1, final int r2) {
    final int lr = 0x6002800 + r0 * 0x800;
    int r3 = r2 / 2 & 0x7f;
    int r6 = r3 << 7;
    int r5 = (r2 & 0x1e) * 0x20;
    final int r7 = r1 / 2 & 0x7f;
    final int r4 = r1 & 0x1e;
    final int r12 = r1 & 0x1;

    //LAB_800ffa0
    for(int i = 0; i < 11; i++) {
      final int r1_0 = (tileAttribs_2010000.get(r6 + r7).getTile() * 0x4 + r12) * 0x2;
      r3 = lr + (r5 + r4 + r12) * 0x2;
      MEMORY.ref(2, r3).setu(MEMORY.ref(2, 0x2020000 + r1_0).getUnsigned());
      MEMORY.ref(2, r3 + 0x40).setu(MEMORY.ref(2, 0x2020004 + r1_0).getUnsigned());
      r6 = r6 + 0x80 & 0x3f80;
      r5 = r5 + 0x40 & 0x3c0;
    }
  }
}
